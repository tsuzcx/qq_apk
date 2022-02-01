package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.aa.l;
import com.tencent.mm.plugin.appbrand.aa.l.a;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.g.c;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.page.t;
import com.tencent.mm.plugin.appbrand.s.a.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.protocal.protobuf.bij;
import com.tencent.mm.protocal.protobuf.bix;
import com.tencent.mm.protocal.protobuf.biz;
import com.tencent.mm.protocal.protobuf.cmy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

public final class d
{
  private static final LinkedList<Runnable> lim;
  private static final a lin;
  private static boolean lio;
  private static final Set<String> lip;
  private final int dkC;
  private final c lij;
  private final h lik;
  private final String lil;
  private final String mAppId;
  
  static
  {
    AppMethodBeat.i(147633);
    lim = new LinkedList();
    lin = new a((byte)0);
    lio = false;
    lip = new HashSet();
    AppMethodBeat.o(147633);
  }
  
  private d(c paramc, final h paramh, final String paramString)
  {
    AppMethodBeat.i(147625);
    this.lij = new b(paramc, paramh)
    {
      private String blh()
      {
        AppMethodBeat.i(147602);
        String str = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { paramh.getAppId(), paramh.getClass().getSimpleName(), paramString });
        AppMethodBeat.o(147602);
        return str;
      }
      
      public final void Ll(String paramAnonymousString)
      {
        AppMethodBeat.i(147600);
        super.Ll(paramAnonymousString);
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, blh() });
        AppMethodBeat.o(147600);
      }
      
      public final void biM()
      {
        AppMethodBeat.i(147599);
        super.biM();
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + blh());
        AppMethodBeat.o(147599);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(147601);
        super.onCancel();
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + blh());
        AppMethodBeat.o(147601);
      }
    };
    this.lik = paramh;
    this.mAppId = paramh.getAppId();
    this.lil = paramString;
    this.dkC = this.lik.getRuntime().Ef().jdS.iOQ;
    AppMethodBeat.o(147625);
  }
  
  public static void Mf(String paramString)
  {
    AppMethodBeat.i(147629);
    a locala = lin;
    if (!bt.isNullOrNil(paramString)) {
      try
      {
        locala.liE.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(147629);
      }
    }
    AppMethodBeat.o(147629);
  }
  
  public static void a(h paramh, final String paramString, final c paramc)
  {
    AppMethodBeat.i(147628);
    final String str = paramh.getAppId();
    if ((bt.isNullOrNil(str)) || (bt.isNullOrNil(paramString)))
    {
      AppMethodBeat.o(147628);
      return;
    }
    synchronized (lip)
    {
      if (lip.contains(str))
      {
        paramh = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147611);
            d.b(this.jyz, paramString, new d.d(paramc, (byte)0));
            AppMethodBeat.o(147611);
          }
        };
        l.bqm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(147612);
            if (d.blf())
            {
              d.blg().add(this.liD);
              ad.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { str, paramString });
              AppMethodBeat.o(147612);
              return;
            }
            d.gN(true);
            this.liD.run();
            AppMethodBeat.o(147612);
          }
        });
        AppMethodBeat.o(147628);
        return;
      }
      com.tencent.mm.plugin.appbrand.g.a(str, new g.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(147610);
          d.Mf(this.val$appId);
          d.ble().remove(this.val$appId);
          AppMethodBeat.o(147610);
        }
      });
    }
  }
  
  public static boolean a(h paramh, String paramString)
  {
    AppMethodBeat.i(147627);
    if (paramString.equals("getWifiList"))
    {
      paramh = paramh.getRuntime().Ef();
      if (!paramh.jdP) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramh.jdP) {
          break;
        }
        AppMethodBeat.o(147627);
        return true;
      }
      AppMethodBeat.o(147627);
      return false;
    }
    AppMethodBeat.o(147627);
    return false;
  }
  
  public static boolean dO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(147626);
    boolean bool = lin.dP(paramString1, paramString2);
    AppMethodBeat.o(147626);
    return bool;
  }
  
  static final class a
  {
    final HashMap<String, HashSet<String>> liE;
    
    private a()
    {
      AppMethodBeat.i(147613);
      this.liE = new HashMap();
      AppMethodBeat.o(147613);
    }
    
    final void T(String paramString1, String paramString2)
    {
      AppMethodBeat.i(147616);
      if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(147616);
        return;
      }
      try
      {
        paramString1 = (HashSet)this.liE.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(147616);
      }
    }
    
    /* Error */
    final boolean dP(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 54
      //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: invokestatic 41	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   9: ifne +10 -> 19
      //   12: aload_2
      //   13: invokestatic 41	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
      //   16: ifeq +10 -> 26
      //   19: ldc 54
      //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: iconst_0
      //   25: ireturn
      //   26: aload_0
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/d$a:liE	Ljava/util/HashMap;
      //   32: aload_1
      //   33: invokevirtual 45	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
      //   36: checkcast 47	java/util/HashSet
      //   39: astore_1
      //   40: aload_1
      //   41: ifnull +22 -> 63
      //   44: aload_1
      //   45: aload_2
      //   46: invokevirtual 57	java/util/HashSet:contains	(Ljava/lang/Object;)Z
      //   49: ifeq +14 -> 63
      //   52: iconst_1
      //   53: istore_3
      //   54: aload_0
      //   55: monitorexit
      //   56: ldc 54
      //   58: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   61: iload_3
      //   62: ireturn
      //   63: iconst_0
      //   64: istore_3
      //   65: goto -11 -> 54
      //   68: astore_1
      //   69: aload_0
      //   70: monitorexit
      //   71: ldc 54
      //   73: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   76: aload_1
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramString1	String
      //   0	78	2	paramString2	String
      //   53	12	3	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   28	40	68	finally
      //   44	52	68	finally
      //   54	56	68	finally
      //   69	71	68	finally
    }
    
    final void put(String paramString1, String paramString2)
    {
      AppMethodBeat.i(147615);
      if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(147615);
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.liE.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.liE.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally
      {
        AppMethodBeat.o(147615);
      }
    }
  }
  
  static class b
    implements d.c
  {
    private final d.c liF;
    
    private b(d.c paramc)
    {
      this.liF = paramc;
    }
    
    public void Ll(String paramString)
    {
      AppMethodBeat.i(147618);
      if (this.liF != null) {
        this.liF.Ll(paramString);
      }
      AppMethodBeat.o(147618);
    }
    
    public void biM()
    {
      AppMethodBeat.i(147617);
      if (this.liF != null) {
        this.liF.biM();
      }
      AppMethodBeat.o(147617);
    }
    
    public void onCancel()
    {
      AppMethodBeat.i(147619);
      if (this.liF != null) {
        this.liF.onCancel();
      }
      AppMethodBeat.o(147619);
    }
  }
  
  public static abstract interface c
  {
    public abstract void Ll(String paramString);
    
    public abstract void biM();
    
    public abstract void onCancel();
  }
  
  static final class d
    extends d.b
  {
    private d(d.c paramc)
    {
      super((byte)0);
    }
    
    private void bli()
    {
      AppMethodBeat.i(147624);
      l.bqm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(147620);
          Runnable localRunnable = (Runnable)d.blg().pollFirst();
          if (localRunnable != null)
          {
            localRunnable.run();
            AppMethodBeat.o(147620);
            return;
          }
          ad.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
          d.gN(false);
          AppMethodBeat.o(147620);
        }
      });
      AppMethodBeat.o(147624);
    }
    
    public final void Ll(String paramString)
    {
      AppMethodBeat.i(147622);
      super.Ll(paramString);
      bli();
      AppMethodBeat.o(147622);
    }
    
    public final void biM()
    {
      AppMethodBeat.i(147621);
      super.biM();
      bli();
      AppMethodBeat.o(147621);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(147623);
      super.onCancel();
      bli();
      AppMethodBeat.o(147623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d
 * JD-Core Version:    0.7.0.1
 */
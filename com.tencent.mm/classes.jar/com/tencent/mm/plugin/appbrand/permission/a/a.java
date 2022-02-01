package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.plugin.appbrand.z.m.a;
import com.tencent.mm.protocal.protobuf.bql;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.cxm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

public final class a
{
  private static final LinkedList<Runnable> mir;
  private static final a mis;
  private static boolean mit;
  private static final Set<String> miu;
  private final int dtF;
  private final c mip;
  private final c miq;
  
  static
  {
    AppMethodBeat.i(192321);
    mir = new LinkedList();
    mis = new a((byte)0);
    mit = false;
    miu = new HashSet();
    AppMethodBeat.o(192321);
  }
  
  private a(c paramc, final c paramc1)
  {
    AppMethodBeat.i(192313);
    this.mip = new b(paramc, paramc1)
    {
      private String bwh()
      {
        AppMethodBeat.i(192290);
        Object localObject = paramc1.miS;
        String str = paramc1.miT;
        localObject = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { ((d)localObject).getAppId(), localObject.getClass().getSimpleName(), str });
        AppMethodBeat.o(192290);
        return localObject;
      }
      
      public final void Sg(String paramAnonymousString)
      {
        AppMethodBeat.i(192288);
        super.Sg(paramAnonymousString);
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, bwh() });
        AppMethodBeat.o(192288);
      }
      
      public final void bsq()
      {
        AppMethodBeat.i(192287);
        super.bsq();
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + bwh());
        AppMethodBeat.o(192287);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(192289);
        super.onCancel();
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + bwh());
        AppMethodBeat.o(192289);
      }
    };
    this.miq = paramc1;
    this.dtF = paramc1.miS.getRuntime().jwG.dPf;
    AppMethodBeat.o(192313);
  }
  
  public static void TT(String paramString)
  {
    AppMethodBeat.i(192317);
    a locala = mis;
    if (!bt.isNullOrNil(paramString)) {
      try
      {
        locala.miL.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(192317);
      }
    }
    AppMethodBeat.o(192317);
  }
  
  public static void a(final c paramc, final c paramc1)
  {
    AppMethodBeat.i(192316);
    final String str = paramc.miS.getAppId();
    if ((bt.isNullOrNil(str)) || (bt.isNullOrNil(paramc.miT)))
    {
      AppMethodBeat.o(192316);
      return;
    }
    synchronized (miu)
    {
      if (miu.contains(str))
      {
        paramc1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192299);
            a.b(this.miv, new a.d(paramc1, (byte)0));
            AppMethodBeat.o(192299);
          }
        };
        m.bBp().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(192300);
            if (a.bwf())
            {
              a.bwg().add(this.miK);
              ad.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { str, paramc.miT });
              AppMethodBeat.o(192300);
              return;
            }
            a.hp(true);
            this.miK.run();
            AppMethodBeat.o(192300);
          }
        });
        AppMethodBeat.o(192316);
        return;
      }
      com.tencent.mm.plugin.appbrand.g.a(str, new a.7(str));
    }
  }
  
  public static boolean a(h paramh, String paramString)
  {
    AppMethodBeat.i(192315);
    if (paramString.equals("getWifiList"))
    {
      paramh = paramh.getRuntime().Fh();
      if (!paramh.jYe) {}
      for (boolean bool = true;; bool = false)
      {
        ad.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramh.jYe) {
          break;
        }
        AppMethodBeat.o(192315);
        return true;
      }
      AppMethodBeat.o(192315);
      return false;
    }
    AppMethodBeat.o(192315);
    return false;
  }
  
  public static boolean ek(String paramString1, String paramString2)
  {
    AppMethodBeat.i(192314);
    boolean bool = mis.el(paramString1, paramString2);
    AppMethodBeat.o(192314);
    return bool;
  }
  
  static final class a
  {
    final HashMap<String, HashSet<String>> miL;
    
    private a()
    {
      AppMethodBeat.i(192301);
      this.miL = new HashMap();
      AppMethodBeat.o(192301);
    }
    
    final void V(String paramString1, String paramString2)
    {
      AppMethodBeat.i(192304);
      if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(192304);
        return;
      }
      try
      {
        paramString1 = (HashSet)this.miL.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(192304);
      }
    }
    
    /* Error */
    final boolean el(String paramString1, String paramString2)
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
      //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/a/a$a:miL	Ljava/util/HashMap;
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
      AppMethodBeat.i(192303);
      if ((bt.isNullOrNil(paramString1)) || (bt.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(192303);
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.miL.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.miL.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally
      {
        AppMethodBeat.o(192303);
      }
    }
  }
  
  static class b
    implements a.c
  {
    private final a.c miM;
    
    private b(a.c paramc)
    {
      this.miM = paramc;
    }
    
    public void Sg(String paramString)
    {
      AppMethodBeat.i(192306);
      if (this.miM != null) {
        this.miM.Sg(paramString);
      }
      AppMethodBeat.o(192306);
    }
    
    public void bsq()
    {
      AppMethodBeat.i(192305);
      if (this.miM != null) {
        this.miM.bsq();
      }
      AppMethodBeat.o(192305);
    }
    
    public void onCancel()
    {
      AppMethodBeat.i(192307);
      if (this.miM != null) {
        this.miM.onCancel();
      }
      AppMethodBeat.o(192307);
    }
  }
  
  public static abstract interface c
  {
    public abstract void Sg(String paramString);
    
    public abstract void bsq();
    
    public abstract void onCancel();
  }
  
  static final class d
    extends a.b
  {
    private d(a.c paramc)
    {
      super((byte)0);
    }
    
    private void bwi()
    {
      AppMethodBeat.i(192312);
      m.bBp().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(192308);
          Runnable localRunnable = (Runnable)a.bwg().pollFirst();
          if (localRunnable != null)
          {
            localRunnable.run();
            AppMethodBeat.o(192308);
            return;
          }
          ad.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
          a.hp(false);
          AppMethodBeat.o(192308);
        }
      });
      AppMethodBeat.o(192312);
    }
    
    public final void Sg(String paramString)
    {
      AppMethodBeat.i(192310);
      super.Sg(paramString);
      bwi();
      AppMethodBeat.o(192310);
    }
    
    public final void bsq()
    {
      AppMethodBeat.i(192309);
      super.bsq();
      bwi();
      AppMethodBeat.o(192309);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(192311);
      super.onCancel();
      bwi();
      AppMethodBeat.o(192311);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.a
 * JD-Core Version:    0.7.0.1
 */
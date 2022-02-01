package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.b;
import com.tencent.mm.plugin.appbrand.y.m;
import com.tencent.mm.plugin.appbrand.y.m.a;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.brt;
import com.tencent.mm.protocal.protobuf.brv;
import com.tencent.mm.protocal.protobuf.cyg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Set;

public final class a
{
  private static final LinkedList<Runnable> mno;
  private static final a mnp;
  private static boolean mnq;
  private static final Set<String> mnr;
  private final int duK;
  private final c mnm;
  private final c mnn;
  
  static
  {
    AppMethodBeat.i(220896);
    mno = new LinkedList();
    mnp = new a((byte)0);
    mnq = false;
    mnr = new HashSet();
    AppMethodBeat.o(220896);
  }
  
  private a(c paramc, final c paramc1)
  {
    AppMethodBeat.i(220888);
    this.mnm = new b(paramc, paramc1)
    {
      private String bwY()
      {
        AppMethodBeat.i(220865);
        Object localObject = paramc1.mnP;
        String str = paramc1.mnQ;
        localObject = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { ((d)localObject).getAppId(), localObject.getClass().getSimpleName(), str });
        AppMethodBeat.o(220865);
        return localObject;
      }
      
      public final void SP(String paramAnonymousString)
      {
        AppMethodBeat.i(220863);
        super.SP(paramAnonymousString);
        ae.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, bwY() });
        AppMethodBeat.o(220863);
      }
      
      public final void btb()
      {
        AppMethodBeat.i(220862);
        super.btb();
        ae.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + bwY());
        AppMethodBeat.o(220862);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(220864);
        super.onCancel();
        ae.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + bwY());
        AppMethodBeat.o(220864);
      }
    };
    this.mnn = paramc1;
    this.duK = paramc1.mnP.getRuntime().jzC.dQv;
    AppMethodBeat.o(220888);
  }
  
  public static void UD(String paramString)
  {
    AppMethodBeat.i(220892);
    a locala = mnp;
    if (!bu.isNullOrNil(paramString)) {
      try
      {
        locala.mnI.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(220892);
      }
    }
    AppMethodBeat.o(220892);
  }
  
  public static void a(final c paramc, final c paramc1)
  {
    AppMethodBeat.i(220891);
    final String str = paramc.mnP.getAppId();
    if ((bu.isNullOrNil(str)) || (bu.isNullOrNil(paramc.mnQ)))
    {
      AppMethodBeat.o(220891);
      return;
    }
    synchronized (mnr)
    {
      if (mnr.contains(str))
      {
        paramc1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220874);
            a.b(this.mns, new a.d(paramc1, (byte)0));
            AppMethodBeat.o(220874);
          }
        };
        m.bCj().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(220875);
            if (a.bwW())
            {
              a.bwX().add(this.mnH);
              ae.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { str, paramc.mnQ });
              AppMethodBeat.o(220875);
              return;
            }
            a.hq(true);
            this.mnH.run();
            AppMethodBeat.o(220875);
          }
        });
        AppMethodBeat.o(220891);
        return;
      }
      com.tencent.mm.plugin.appbrand.h.a(str, new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(220873);
          a.UD(this.val$appId);
          a.bwV().remove(this.val$appId);
          AppMethodBeat.o(220873);
        }
      });
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.jsapi.h paramh, String paramString)
  {
    AppMethodBeat.i(220890);
    if (paramString.equals("getWifiList"))
    {
      paramh = paramh.getRuntime().Fm();
      if (!paramh.kbt) {}
      for (boolean bool = true;; bool = false)
      {
        ae.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramh.kbt) {
          break;
        }
        AppMethodBeat.o(220890);
        return true;
      }
      AppMethodBeat.o(220890);
      return false;
    }
    AppMethodBeat.o(220890);
    return false;
  }
  
  public static boolean en(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220889);
    boolean bool = mnp.eo(paramString1, paramString2);
    AppMethodBeat.o(220889);
    return bool;
  }
  
  static final class a
  {
    final HashMap<String, HashSet<String>> mnI;
    
    private a()
    {
      AppMethodBeat.i(220876);
      this.mnI = new HashMap();
      AppMethodBeat.o(220876);
    }
    
    final void V(String paramString1, String paramString2)
    {
      AppMethodBeat.i(220879);
      if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(220879);
        return;
      }
      try
      {
        paramString1 = (HashSet)this.mnI.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(220879);
      }
    }
    
    /* Error */
    final boolean eo(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 54
      //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: invokestatic 41	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   9: ifne +10 -> 19
      //   12: aload_2
      //   13: invokestatic 41	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
      //   16: ifeq +10 -> 26
      //   19: ldc 54
      //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: iconst_0
      //   25: ireturn
      //   26: aload_0
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/a/a$a:mnI	Ljava/util/HashMap;
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
      AppMethodBeat.i(220878);
      if ((bu.isNullOrNil(paramString1)) || (bu.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(220878);
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.mnI.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.mnI.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally
      {
        AppMethodBeat.o(220878);
      }
    }
  }
  
  static class b
    implements a.c
  {
    private final a.c mnJ;
    
    private b(a.c paramc)
    {
      this.mnJ = paramc;
    }
    
    public void SP(String paramString)
    {
      AppMethodBeat.i(220881);
      if (this.mnJ != null) {
        this.mnJ.SP(paramString);
      }
      AppMethodBeat.o(220881);
    }
    
    public void btb()
    {
      AppMethodBeat.i(220880);
      if (this.mnJ != null) {
        this.mnJ.btb();
      }
      AppMethodBeat.o(220880);
    }
    
    public void onCancel()
    {
      AppMethodBeat.i(220882);
      if (this.mnJ != null) {
        this.mnJ.onCancel();
      }
      AppMethodBeat.o(220882);
    }
  }
  
  public static abstract interface c
  {
    public abstract void SP(String paramString);
    
    public abstract void btb();
    
    public abstract void onCancel();
  }
  
  static final class d
    extends a.b
  {
    private d(a.c paramc)
    {
      super((byte)0);
    }
    
    private void bwZ()
    {
      AppMethodBeat.i(220887);
      m.bCj().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(220883);
          Runnable localRunnable = (Runnable)a.bwX().pollFirst();
          if (localRunnable != null)
          {
            localRunnable.run();
            AppMethodBeat.o(220883);
            return;
          }
          ae.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
          a.hq(false);
          AppMethodBeat.o(220883);
        }
      });
      AppMethodBeat.o(220887);
    }
    
    public final void SP(String paramString)
    {
      AppMethodBeat.i(220885);
      super.SP(paramString);
      bwZ();
      AppMethodBeat.o(220885);
    }
    
    public final void btb()
    {
      AppMethodBeat.i(220884);
      super.btb();
      bwZ();
      AppMethodBeat.o(220884);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(220886);
      super.onCancel();
      bwZ();
      AppMethodBeat.o(220886);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.a
 * JD-Core Version:    0.7.0.1
 */
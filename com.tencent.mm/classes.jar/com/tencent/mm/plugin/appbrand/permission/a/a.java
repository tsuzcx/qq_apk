package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.g.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.a;
import com.tencent.mm.protocal.protobuf.cmt;
import com.tencent.mm.protocal.protobuf.cnh;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class a
{
  private static final LinkedList<Runnable> qAl;
  private static final a qAm;
  private static boolean qAn;
  private static final Set<String> qAo;
  private final int fES;
  private final c qAj;
  private final c qAk;
  
  static
  {
    AppMethodBeat.i(247281);
    qAl = new LinkedList();
    qAm = new a((byte)0);
    qAn = false;
    qAo = new HashSet();
    AppMethodBeat.o(247281);
  }
  
  private a(c paramc, final c paramc1)
  {
    AppMethodBeat.i(247266);
    this.qAj = new b(paramc, paramc1)
    {
      private String cgl()
      {
        AppMethodBeat.i(237080);
        Object localObject = paramc1.oDq;
        String str = paramc1.qAN;
        localObject = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.g)localObject).getAppId(), localObject.getClass().getSimpleName(), str });
        AppMethodBeat.o(237080);
        return localObject;
      }
      
      public final void akr(String paramAnonymousString)
      {
        AppMethodBeat.i(237076);
        super.akr(paramAnonymousString);
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, cgl() });
        AppMethodBeat.o(237076);
      }
      
      public final void caY()
      {
        AppMethodBeat.i(237074);
        super.caY();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + cgl());
        AppMethodBeat.o(237074);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(237079);
        super.onCancel();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + cgl());
        AppMethodBeat.o(237079);
      }
    };
    this.qAk = paramc1;
    this.fES = paramc1.oDq.getRuntime().ntz.cBI;
    AppMethodBeat.o(247266);
  }
  
  public static void a(final c paramc, final c paramc1)
  {
    AppMethodBeat.i(247270);
    final String str = paramc.oDq.getAppId();
    if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramc.qAN)))
    {
      AppMethodBeat.o(247270);
      return;
    }
    synchronized (qAo)
    {
      if (qAo.contains(str))
      {
        paramc1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241059);
            a.b(this.qAp, new a.d(paramc1, (byte)0));
            AppMethodBeat.o(241059);
          }
        };
        m.clV().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(241383);
            if (a.cgj())
            {
              a.cgk().add(this.qAF);
              Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { str, paramc.qAN });
              AppMethodBeat.o(241383);
              return;
            }
            a.jo(true);
            this.qAF.run();
            AppMethodBeat.o(241383);
          }
        });
        AppMethodBeat.o(247270);
        return;
      }
      k.a(str, new k.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(244325);
          a.aml(this.val$appId);
          a.cgi().remove(this.val$appId);
          AppMethodBeat.o(244325);
        }
      });
    }
  }
  
  public static boolean a(j paramj, String paramString)
  {
    AppMethodBeat.i(247268);
    if (paramString.equals("getWifiList"))
    {
      paramj = paramj.getRuntime().Sp();
      if (!paramj.nYO) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramj.nYO) {
          break;
        }
        AppMethodBeat.o(247268);
        return true;
      }
      AppMethodBeat.o(247268);
      return false;
    }
    AppMethodBeat.o(247268);
    return false;
  }
  
  public static void aml(String paramString)
  {
    AppMethodBeat.i(247271);
    a locala = qAm;
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        locala.qAG.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(247271);
      }
    }
    AppMethodBeat.o(247271);
  }
  
  public static boolean eU(String paramString1, String paramString2)
  {
    AppMethodBeat.i(247267);
    boolean bool = qAm.eV(paramString1, paramString2);
    AppMethodBeat.o(247267);
    return bool;
  }
  
  static final class a
  {
    final HashMap<String, HashSet<String>> qAG;
    
    private a()
    {
      AppMethodBeat.i(250791);
      this.qAG = new HashMap();
      AppMethodBeat.o(250791);
    }
    
    final void ac(String paramString1, String paramString2)
    {
      AppMethodBeat.i(250798);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(250798);
        return;
      }
      try
      {
        paramString1 = (HashSet)this.qAG.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(250798);
      }
    }
    
    /* Error */
    final boolean eV(String paramString1, String paramString2)
    {
      // Byte code:
      //   0: ldc 54
      //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_1
      //   6: invokestatic 41	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   9: ifne +10 -> 19
      //   12: aload_2
      //   13: invokestatic 41	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
      //   16: ifeq +10 -> 26
      //   19: ldc 54
      //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: iconst_0
      //   25: ireturn
      //   26: aload_0
      //   27: monitorenter
      //   28: aload_0
      //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/a/a$a:qAG	Ljava/util/HashMap;
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
    }
    
    final void put(String paramString1, String paramString2)
    {
      AppMethodBeat.i(250796);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(250796);
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.qAG.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.qAG.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally
      {
        AppMethodBeat.o(250796);
      }
    }
  }
  
  static class b
    implements a.c
  {
    private final a.c qAH;
    
    private b(a.c paramc)
    {
      this.qAH = paramc;
    }
    
    public void akr(String paramString)
    {
      AppMethodBeat.i(236468);
      if (this.qAH != null) {
        this.qAH.akr(paramString);
      }
      AppMethodBeat.o(236468);
    }
    
    public void caY()
    {
      AppMethodBeat.i(236466);
      if (this.qAH != null) {
        this.qAH.caY();
      }
      AppMethodBeat.o(236466);
    }
    
    public void onCancel()
    {
      AppMethodBeat.i(236470);
      if (this.qAH != null) {
        this.qAH.onCancel();
      }
      AppMethodBeat.o(236470);
    }
  }
  
  public static abstract interface c
  {
    public abstract void akr(String paramString);
    
    public abstract void caY();
    
    public abstract void onCancel();
  }
  
  static final class d
    extends a.b
  {
    private d(a.c paramc)
    {
      super((byte)0);
    }
    
    private void cgm()
    {
      AppMethodBeat.i(249200);
      m.clV().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(243785);
          Runnable localRunnable = (Runnable)a.cgk().pollFirst();
          if (localRunnable != null)
          {
            localRunnable.run();
            AppMethodBeat.o(243785);
            return;
          }
          Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
          a.jo(false);
          AppMethodBeat.o(243785);
        }
      });
      AppMethodBeat.o(249200);
    }
    
    public final void akr(String paramString)
    {
      AppMethodBeat.i(249198);
      super.akr(paramString);
      cgm();
      AppMethodBeat.o(249198);
    }
    
    public final void caY()
    {
      AppMethodBeat.i(249196);
      super.caY();
      cgm();
      AppMethodBeat.o(249196);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(249199);
      super.onCancel();
      cgm();
      AppMethodBeat.o(249199);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.permission.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.ac.m.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.d;
import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.appbrand.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.h.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.i.a;
import com.tencent.mm.protocal.protobuf.cdz;
import com.tencent.mm.protocal.protobuf.cen;
import com.tencent.mm.protocal.protobuf.cep;
import com.tencent.mm.protocal.protobuf.drb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import com.tencent.mm.vending.g.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public final class a
{
  private static final LinkedList<Runnable> nxZ;
  private static final a nya;
  private static boolean nyb;
  private static final Set<String> nyc;
  private final int dMe;
  private final c nxX;
  private final c nxY;
  
  static
  {
    AppMethodBeat.i(230003);
    nxZ = new LinkedList();
    nya = new a((byte)0);
    nyb = false;
    nyc = new HashSet();
    AppMethodBeat.o(230003);
  }
  
  private a(c paramc, final c paramc1)
  {
    AppMethodBeat.i(229995);
    this.nxX = new b(paramc, paramc1)
    {
      private String bTi()
      {
        AppMethodBeat.i(229972);
        Object localObject = paramc1.nyB;
        String str = paramc1.nyC;
        localObject = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { ((d)localObject).getAppId(), localObject.getClass().getSimpleName(), str });
        AppMethodBeat.o(229972);
        return localObject;
      }
      
      public final void acx(String paramAnonymousString)
      {
        AppMethodBeat.i(229970);
        super.acx(paramAnonymousString);
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, bTi() });
        AppMethodBeat.o(229970);
      }
      
      public final void bOI()
      {
        AppMethodBeat.i(229969);
        super.bOI();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + bTi());
        AppMethodBeat.o(229969);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(229971);
        super.onCancel();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + bTi());
        AppMethodBeat.o(229971);
      }
    };
    this.nxY = paramc1;
    this.dMe = paramc1.nyB.getRuntime().kAq.eix;
    AppMethodBeat.o(229995);
  }
  
  public static void a(final c paramc, final c paramc1)
  {
    AppMethodBeat.i(229998);
    final String str = paramc.nyB.getAppId();
    if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramc.nyC)))
    {
      AppMethodBeat.o(229998);
      return;
    }
    synchronized (nyc)
    {
      if (nyc.contains(str))
      {
        paramc1 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(229981);
            a.b(this.nyd, new a.d(paramc1, (byte)0));
            AppMethodBeat.o(229981);
          }
        };
        m.bZn().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(229982);
            if (a.bTg())
            {
              a.bTh().add(this.nyt);
              Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { str, paramc.nyC });
              AppMethodBeat.o(229982);
              return;
            }
            a.ir(true);
            this.nyt.run();
            AppMethodBeat.o(229982);
          }
        });
        AppMethodBeat.o(229998);
        return;
      }
      h.a(str, new h.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(229980);
          a.aer(this.val$appId);
          a.bTf().remove(this.val$appId);
          AppMethodBeat.o(229980);
        }
      });
    }
  }
  
  public static boolean a(k paramk, String paramString)
  {
    AppMethodBeat.i(229997);
    if (paramString.equals("getWifiList"))
    {
      paramk = paramk.getRuntime().OT();
      if (!paramk.leB) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramk.leB) {
          break;
        }
        AppMethodBeat.o(229997);
        return true;
      }
      AppMethodBeat.o(229997);
      return false;
    }
    AppMethodBeat.o(229997);
    return false;
  }
  
  public static void aer(String paramString)
  {
    AppMethodBeat.i(229999);
    a locala = nya;
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        locala.nyu.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(229999);
      }
    }
    AppMethodBeat.o(229999);
  }
  
  public static boolean eG(String paramString1, String paramString2)
  {
    AppMethodBeat.i(229996);
    boolean bool = nya.eH(paramString1, paramString2);
    AppMethodBeat.o(229996);
    return bool;
  }
  
  static final class a
  {
    final HashMap<String, HashSet<String>> nyu;
    
    private a()
    {
      AppMethodBeat.i(229983);
      this.nyu = new HashMap();
      AppMethodBeat.o(229983);
    }
    
    final void Y(String paramString1, String paramString2)
    {
      AppMethodBeat.i(229986);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(229986);
        return;
      }
      try
      {
        paramString1 = (HashSet)this.nyu.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(229986);
      }
    }
    
    /* Error */
    final boolean eH(String paramString1, String paramString2)
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
      //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/a/a$a:nyu	Ljava/util/HashMap;
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
      AppMethodBeat.i(229985);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(229985);
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.nyu.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.nyu.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally
      {
        AppMethodBeat.o(229985);
      }
    }
  }
  
  static class b
    implements a.c
  {
    private final a.c nyv;
    
    private b(a.c paramc)
    {
      this.nyv = paramc;
    }
    
    public void acx(String paramString)
    {
      AppMethodBeat.i(229988);
      if (this.nyv != null) {
        this.nyv.acx(paramString);
      }
      AppMethodBeat.o(229988);
    }
    
    public void bOI()
    {
      AppMethodBeat.i(229987);
      if (this.nyv != null) {
        this.nyv.bOI();
      }
      AppMethodBeat.o(229987);
    }
    
    public void onCancel()
    {
      AppMethodBeat.i(229989);
      if (this.nyv != null) {
        this.nyv.onCancel();
      }
      AppMethodBeat.o(229989);
    }
  }
  
  public static abstract interface c
  {
    public abstract void acx(String paramString);
    
    public abstract void bOI();
    
    public abstract void onCancel();
  }
  
  static final class d
    extends a.b
  {
    private d(a.c paramc)
    {
      super((byte)0);
    }
    
    private void bTj()
    {
      AppMethodBeat.i(229994);
      m.bZn().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(229990);
          Runnable localRunnable = (Runnable)a.bTh().pollFirst();
          if (localRunnable != null)
          {
            localRunnable.run();
            AppMethodBeat.o(229990);
            return;
          }
          Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
          a.ir(false);
          AppMethodBeat.o(229990);
        }
      });
      AppMethodBeat.o(229994);
    }
    
    public final void acx(String paramString)
    {
      AppMethodBeat.i(229992);
      super.acx(paramString);
      bTj();
      AppMethodBeat.o(229992);
    }
    
    public final void bOI()
    {
      AppMethodBeat.i(229991);
      super.bOI();
      bTj();
      AppMethodBeat.o(229991);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(229993);
      super.onCancel();
      bTj();
      AppMethodBeat.o(229993);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.a
 * JD-Core Version:    0.7.0.1
 */
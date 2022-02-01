package com.tencent.mm.plugin.appbrand.permission.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.af.o;
import com.tencent.mm.plugin.appbrand.af.o.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.jsapi.aj;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.widget.dialog.k.a;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.ddz;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.protocal.protobuf.eq;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.fvl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class a
{
  private static c tFi;
  private static final LinkedList<Runnable> tFl;
  private static final a tFm;
  private static boolean tFn;
  private static final Set<String> tFo;
  private final int hJK;
  private final d tFj;
  private final c tFk;
  
  static
  {
    AppMethodBeat.i(318906);
    tFi = c.tFJ;
    tFl = new LinkedList();
    tFm = new a((byte)0);
    tFn = false;
    tFo = new HashSet();
    AppMethodBeat.o(318906);
  }
  
  protected a(d paramd, final c paramc)
  {
    AppMethodBeat.i(318822);
    this.tFj = new b(paramd, paramc)
    {
      private String cHc()
      {
        AppMethodBeat.i(318813);
        Object localObject = paramc.rGz;
        String str = paramc.tFV;
        localObject = String.format(Locale.ENGLISH, "component[%s %s], api[%s]", new Object[] { ((com.tencent.mm.plugin.appbrand.g)localObject).getAppId(), localObject.getClass().getSimpleName(), str });
        AppMethodBeat.o(318813);
        return localObject;
      }
      
      public final void adx(String paramAnonymousString)
      {
        AppMethodBeat.i(318825);
        super.adx(paramAnonymousString);
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onDeny reason[%s] %s", new Object[] { paramAnonymousString, cHc() });
        AppMethodBeat.o(318825);
      }
      
      public final void bSs()
      {
        AppMethodBeat.i(318818);
        super.bSs();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onConfirm " + cHc());
        AppMethodBeat.o(318818);
      }
      
      public final void onCancel()
      {
        AppMethodBeat.i(318830);
        super.onCancel();
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "onCancel " + cHc());
        AppMethodBeat.o(318830);
      }
    };
    this.tFk = paramc;
    this.hJK = paramc.rGz.getRuntime().qsh.eul;
    AppMethodBeat.o(318822);
  }
  
  public static void a(c paramc)
  {
    tFi = paramc;
  }
  
  public static void a(final c paramc, final d paramd)
  {
    AppMethodBeat.i(318846);
    final String str = paramc.rGz.getAppId();
    if ((Util.isNullOrNil(str)) || (Util.isNullOrNil(paramc.tFV)))
    {
      AppMethodBeat.o(318846);
      return;
    }
    synchronized (tFo)
    {
      if (tFo.contains(str))
      {
        paramd = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(318806);
            a.a(a.this, new a.e(paramd, (byte)0), a.cHa());
            AppMethodBeat.o(318806);
          }
        };
        o.cNm().postToWorker(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(318802);
            if (a.aDb())
            {
              a.cHb().add(a.this);
              Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, another request already running, put this in queue, appId %s, api %s", new Object[] { str, paramc.tFV });
              AppMethodBeat.o(318802);
              return;
            }
            a.dX(true);
            a.this.run();
            AppMethodBeat.o(318802);
          }
        });
        AppMethodBeat.o(318846);
        return;
      }
      com.tencent.mm.plugin.appbrand.k.a(str, new k.c()
      {
        public final void onDestroy()
        {
          AppMethodBeat.i(318797);
          a.aft(a.this);
          a.cGZ().remove(a.this);
          AppMethodBeat.o(318797);
        }
      });
    }
  }
  
  public static boolean a(com.tencent.mm.plugin.appbrand.jsapi.k paramk, String paramString)
  {
    AppMethodBeat.i(318839);
    if (paramString.equals("getWifiList"))
    {
      paramk = paramk.getRuntime().asG();
      if (!paramk.qYV) {}
      for (boolean bool = true;; bool = false)
      {
        Log.i("MicroMsg.AppBrandJsApiUserAuth", "getWifiList jump userauth:%b", new Object[] { Boolean.valueOf(bool) });
        if (paramk.qYV) {
          break;
        }
        AppMethodBeat.o(318839);
        return true;
      }
      AppMethodBeat.o(318839);
      return false;
    }
    AppMethodBeat.o(318839);
    return false;
  }
  
  public static void aft(String paramString)
  {
    AppMethodBeat.i(318853);
    a locala = tFm;
    if (!Util.isNullOrNil(paramString)) {
      try
      {
        locala.tFH.remove(paramString);
        return;
      }
      finally
      {
        AppMethodBeat.o(318853);
      }
    }
    AppMethodBeat.o(318853);
  }
  
  public static boolean fl(String paramString1, String paramString2)
  {
    AppMethodBeat.i(318834);
    boolean bool = tFm.fm(paramString1, paramString2);
    AppMethodBeat.o(318834);
    return bool;
  }
  
  protected boolean P(AppBrandRuntime paramAppBrandRuntime)
  {
    return false;
  }
  
  protected deb a(deb paramdeb)
  {
    return paramdeb;
  }
  
  static final class a
  {
    final HashMap<String, HashSet<String>> tFH;
    
    private a()
    {
      AppMethodBeat.i(318787);
      this.tFH = new HashMap();
      AppMethodBeat.o(318787);
    }
    
    final void ah(String paramString1, String paramString2)
    {
      AppMethodBeat.i(318824);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(318824);
        return;
      }
      try
      {
        paramString1 = (HashSet)this.tFH.get(paramString1);
        if (paramString1 != null) {
          paramString1.remove(paramString2);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(318824);
      }
    }
    
    /* Error */
    final boolean fm(String paramString1, String paramString2)
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
      //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/a/a$a:tFH	Ljava/util/HashMap;
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
      AppMethodBeat.i(318814);
      if ((Util.isNullOrNil(paramString1)) || (Util.isNullOrNil(paramString2)))
      {
        AppMethodBeat.o(318814);
        return;
      }
      try
      {
        HashSet localHashSet2 = (HashSet)this.tFH.get(paramString1);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.tFH.put(paramString1, localHashSet1);
        }
        localHashSet1.add(paramString2);
        return;
      }
      finally
      {
        AppMethodBeat.o(318814);
      }
    }
  }
  
  static class b
    implements a.d
  {
    private final a.d tFI;
    
    private b(a.d paramd)
    {
      this.tFI = paramd;
    }
    
    public void adx(String paramString)
    {
      AppMethodBeat.i(318798);
      if (this.tFI != null) {
        this.tFI.adx(paramString);
      }
      AppMethodBeat.o(318798);
    }
    
    public void bSs()
    {
      AppMethodBeat.i(318792);
      if (this.tFI != null) {
        this.tFI.bSs();
      }
      AppMethodBeat.o(318792);
    }
    
    public void onCancel()
    {
      AppMethodBeat.i(318801);
      if (this.tFI != null) {
        this.tFI.onCancel();
      }
      AppMethodBeat.o(318801);
    }
  }
  
  public static abstract interface c
  {
    public static final c tFJ = new c()
    {
      public final a a(a.d paramAnonymousd, c paramAnonymousc)
      {
        AppMethodBeat.i(318820);
        paramAnonymousd = new a(paramAnonymousd, paramAnonymousc);
        AppMethodBeat.o(318820);
        return paramAnonymousd;
      }
    };
    
    public abstract a a(a.d paramd, c paramc);
  }
  
  public static abstract interface d
  {
    public abstract void adx(String paramString);
    
    public abstract void bSs();
    
    public abstract void onCancel();
  }
  
  static final class e
    extends a.b
  {
    private e(a.d paramd)
    {
      super((byte)0);
    }
    
    private void cHd()
    {
      AppMethodBeat.i(318781);
      o.cNm().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(318795);
          Runnable localRunnable = (Runnable)a.cHb().pollFirst();
          if (localRunnable != null)
          {
            localRunnable.run();
            AppMethodBeat.o(318795);
            return;
          }
          Log.i("MicroMsg.AppBrandJsApiUserAuth", "requireUserAuth, poll null from queue, all requests done");
          a.dX(false);
          AppMethodBeat.o(318795);
        }
      });
      AppMethodBeat.o(318781);
    }
    
    public final void adx(String paramString)
    {
      AppMethodBeat.i(318799);
      super.adx(paramString);
      cHd();
      AppMethodBeat.o(318799);
    }
    
    public final void bSs()
    {
      AppMethodBeat.i(318794);
      super.bSs();
      cHd();
      AppMethodBeat.o(318794);
    }
    
    public final void onCancel()
    {
      AppMethodBeat.i(318803);
      super.onCancel();
      cHd();
      AppMethodBeat.o(318803);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.a.a
 * JD-Core Version:    0.7.0.1
 */
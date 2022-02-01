package com.tencent.mm.plugin.flutter.b;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.flutter.d;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.dart.DartExecutor.a;
import io.flutter.plugin.a.j;
import io.flutter.plugin.a.k;
import io.flutter.plugin.a.k.c;
import io.flutter.plugin.a.k.d;
import io.flutter.view.FlutterMain;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class a
{
  public io.flutter.embedding.engine.a tti;
  public com.tencent.mm.plugin.flutter.ui.a ttj;
  private HashMap<String, com.tencent.mm.flutter.b> ttk;
  HashMap<String, com.tencent.mm.flutter.a> ttl;
  private HashMap<Integer, Pair<Integer, String>> ttm;
  public AtomicInteger ttn;
  private k tto;
  private k.c ttp;
  private io.flutter.embedding.engine.b.b ttq;
  
  public a()
  {
    AppMethodBeat.i(148849);
    this.ttk = new HashMap();
    this.ttl = new HashMap();
    this.ttm = new HashMap();
    this.ttn = new AtomicInteger(0);
    this.ttp = new k.c()
    {
      public final void a(j paramAnonymousj, final k.d paramAnonymousd)
      {
        AppMethodBeat.i(148847);
        ae.i("MicroMsg.Flutter.FlutterEngineMgr", "onMethodCall %s", new Object[] { paramAnonymousj.method });
        String[] arrayOfString = paramAnonymousj.method.split(":");
        final com.tencent.mm.flutter.c localc = new com.tencent.mm.flutter.c();
        if (a.this.ttj != null) {
          localc.context = a.this.ttj.getActivity();
        }
        localc.gtD = arrayOfString[0];
        localc.gtE = arrayOfString[1];
        localc.gtF = paramAnonymousj.gtF;
        localc.callback = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(148846);
            if (localc.result != null)
            {
              ae.i("MicroMsg.Flutter.FlutterEngineMgr", "onMethodCallback, %s", new Object[] { localc.gtE });
              paramAnonymousd.df(localc.result);
              AppMethodBeat.o(148846);
              return;
            }
            ae.i("MicroMsg.Flutter.FlutterEngineMgr", "onMethodCallback, %s null", new Object[] { localc.gtE });
            paramAnonymousd.df(null);
            AppMethodBeat.o(148846);
          }
        };
        if (a.this.ttl.containsKey(localc.gtD)) {
          try
          {
            ((com.tencent.mm.flutter.a)a.this.ttl.get(localc.gtD)).a(localc);
            AppMethodBeat.o(148847);
            return;
          }
          catch (com.tencent.mm.flutter.e paramAnonymousj)
          {
            ae.printErrStackTrace("MicroMsg.Flutter.FlutterEngineMgr", paramAnonymousj, "", new Object[0]);
          }
        }
        AppMethodBeat.o(148847);
      }
    };
    this.ttq = new io.flutter.embedding.engine.b.b()
    {
      public final void cSR()
      {
        AppMethodBeat.i(213521);
        ae.i("MicroMsg.Flutter.FlutterEngineMgr", "onFlutterUiDisplayed");
        if (a.this.ttj != null) {
          a.this.ttj.cSU();
        }
        AppMethodBeat.o(213521);
      }
      
      public final void cSS() {}
    };
    AppMethodBeat.o(148849);
  }
  
  private static JSONObject ag(Bundle paramBundle)
  {
    AppMethodBeat.i(148854);
    JSONObject localJSONObject = new JSONObject();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        localJSONObject.put(str, paramBundle.get(str));
      }
      catch (Exception localException) {}
    }
    AppMethodBeat.o(148854);
    return localJSONObject;
  }
  
  public final boolean a(com.tencent.mm.plugin.flutter.a.c paramc, String paramString)
  {
    int i = 0;
    AppMethodBeat.i(148850);
    int j;
    if (this.tti == null)
    {
      ae.i("MicroMsg.Flutter.FlutterEngineMgr", "InitRoute %s ", new Object[] { paramc });
      this.tti = new io.flutter.embedding.engine.a(ak.getContext());
      paramc.tth = true;
      this.tti.MZr.setInitialRoute(paramc.aYO());
      System.loadLibrary("wechatlv");
      paramc = this.tti.MZm;
      ak.getContext().getAssets();
      paramc.a(new DartExecutor.a(FlutterMain.findAppBundlePath(ak.getContext()), paramString, (byte)0));
      this.tti.MYh.addIsDisplayingFlutterUiListener(this.ttq);
      io.flutter.a.a.registerWith(new com.tencent.mm.b(this.tti, ak.getContext()));
      this.tto = new k(this.tti.MZm, "com.tencent.mm.flutter.mmnative");
      this.tto.a(this.ttp);
      this.ttl.clear();
      paramc = d.gtG.iterator();
      while (paramc.hasNext())
      {
        paramString = (Class)paramc.next();
        try
        {
          paramString = (com.tencent.mm.flutter.a)paramString.newInstance();
          paramString.create();
          this.ttl.put(paramString.agK(), paramString);
        }
        catch (Exception paramString) {}
      }
      this.ttk.clear();
      paramc = com.tencent.mm.flutter.a.b.c.gtH;
      j = paramc.length;
    }
    for (;;)
    {
      if (i < j) {
        paramString = paramc[i];
      }
      try
      {
        com.tencent.mm.flutter.b localb = (com.tencent.mm.flutter.b)paramString.newInstance();
        localb.gtz = this.tto;
        this.ttk.put(paramString.getName(), localb);
        label287:
        i += 1;
        continue;
        this.ttm.clear();
        for (boolean bool = true;; bool = false)
        {
          AppMethodBeat.o(148850);
          return bool;
          ae.i("MicroMsg.Flutter.FlutterEngineMgr", "Push Route %s", new Object[] { paramc });
          this.tti.MZr.bds(paramc.aYO());
        }
      }
      catch (Exception paramString)
      {
        break label287;
      }
    }
  }
  
  public final <T> T aO(Class<T> paramClass)
  {
    AppMethodBeat.i(148855);
    if (this.ttk.containsKey(paramClass.getName()))
    {
      paramClass = this.ttk.get(paramClass.getName());
      AppMethodBeat.o(148855);
      return paramClass;
    }
    try
    {
      paramClass = paramClass.newInstance();
      AppMethodBeat.o(148855);
      return paramClass;
    }
    catch (Exception paramClass)
    {
      AppMethodBeat.o(148855);
    }
    return null;
  }
  
  public final void cSQ()
  {
    AppMethodBeat.i(148852);
    this.tti.MZr.cSQ();
    AppMethodBeat.o(148852);
  }
  
  public final int dE(String paramString, int paramInt)
  {
    AppMethodBeat.i(148856);
    int i = (Math.abs(paramString.hashCode()) | paramInt) >> 16;
    this.ttm.put(Integer.valueOf(i), Pair.create(Integer.valueOf(paramInt), paramString));
    ae.i("MicroMsg.Flutter.FlutterEngineMgr", "getRealRequestCode %s %d %d", new Object[] { paramString, Integer.valueOf(paramInt), Integer.valueOf(i) });
    AppMethodBeat.o(148856);
    return i;
  }
  
  /* Error */
  public final boolean onActivityResult(int paramInt1, int paramInt2, android.content.Intent paramIntent)
  {
    // Byte code:
    //   0: ldc_w 307
    //   3: invokestatic 40	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 49	com/tencent/mm/plugin/flutter/b/a:ttm	Ljava/util/HashMap;
    //   10: iload_1
    //   11: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   14: invokevirtual 272	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   17: checkcast 299	android/util/Pair
    //   20: astore 6
    //   22: aload 6
    //   24: ifnull +139 -> 163
    //   27: ldc 114
    //   29: ldc_w 309
    //   32: iconst_3
    //   33: anewarray 4	java/lang/Object
    //   36: dup
    //   37: iconst_0
    //   38: aload 6
    //   40: getfield 313	android/util/Pair:second	Ljava/lang/Object;
    //   43: aastore
    //   44: dup
    //   45: iconst_1
    //   46: aload 6
    //   48: getfield 316	android/util/Pair:first	Ljava/lang/Object;
    //   51: aastore
    //   52: dup
    //   53: iconst_2
    //   54: iload_2
    //   55: invokestatic 297	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   58: aastore
    //   59: invokestatic 121	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   62: aload_0
    //   63: ldc_w 318
    //   66: invokevirtual 320	com/tencent/mm/plugin/flutter/b/a:aO	(Ljava/lang/Class;)Ljava/lang/Object;
    //   69: checkcast 318	com/tencent/mm/flutter/a/b/a
    //   72: astore 4
    //   74: aload 6
    //   76: getfield 313	android/util/Pair:second	Ljava/lang/Object;
    //   79: checkcast 99	java/lang/String
    //   82: astore 5
    //   84: aload 6
    //   86: getfield 316	android/util/Pair:first	Ljava/lang/Object;
    //   89: checkcast 293	java/lang/Integer
    //   92: invokevirtual 323	java/lang/Integer:intValue	()I
    //   95: istore_1
    //   96: aload_3
    //   97: invokevirtual 329	android/content/Intent:getExtras	()Landroid/os/Bundle;
    //   100: invokestatic 331	com/tencent/mm/plugin/flutter/b/a:ag	(Landroid/os/Bundle;)Lorg/json/JSONObject;
    //   103: astore 6
    //   105: new 74	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 75	org/json/JSONObject:<init>	()V
    //   112: astore_3
    //   113: aload_3
    //   114: ldc_w 333
    //   117: aload 5
    //   119: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload_3
    //   124: ldc_w 335
    //   127: iload_1
    //   128: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   131: pop
    //   132: aload_3
    //   133: ldc_w 340
    //   136: iload_2
    //   137: invokevirtual 338	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   140: pop
    //   141: aload_3
    //   142: ldc_w 342
    //   145: aload 6
    //   147: invokevirtual 107	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 4
    //   153: ldc_w 343
    //   156: aload_3
    //   157: invokevirtual 346	org/json/JSONObject:toString	()Ljava/lang/String;
    //   160: invokevirtual 350	com/tencent/mm/flutter/a/b/a:e	(Ljava/lang/String;Ljava/lang/Object;)V
    //   163: ldc_w 307
    //   166: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   169: iconst_0
    //   170: ireturn
    //   171: astore_3
    //   172: goto -9 -> 163
    //   175: astore 5
    //   177: goto -26 -> 151
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	180	0	this	a
    //   0	180	1	paramInt1	int
    //   0	180	2	paramInt2	int
    //   0	180	3	paramIntent	android.content.Intent
    //   72	80	4	locala	com.tencent.mm.flutter.a.b.a
    //   82	36	5	str	String
    //   175	1	5	localException	Exception
    //   20	126	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	22	171	java/lang/Exception
    //   27	113	171	java/lang/Exception
    //   151	163	171	java/lang/Exception
    //   113	151	175	java/lang/Exception
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(148851);
    if (this.ttn.decrementAndGet() <= 0)
    {
      Iterator localIterator = this.ttl.values().iterator();
      while (localIterator.hasNext()) {
        ((com.tencent.mm.flutter.a)localIterator.next()).destroy();
      }
      this.ttm.clear();
      this.ttl.clear();
      this.ttk.clear();
      if (this.tti != null) {
        this.tti.destroy();
      }
      this.tti = null;
      this.tto = null;
    }
    AppMethodBeat.o(148851);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.flutter.b.a
 * JD-Core Version:    0.7.0.1
 */
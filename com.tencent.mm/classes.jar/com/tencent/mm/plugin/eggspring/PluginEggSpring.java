package com.tencent.mm.plugin.eggspring;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.b.a.a;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.modelpackage.e;
import com.tencent.mm.modelpackage.m;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.game.luggage.h.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import kotlin.ah;
import kotlin.g.b.s;

public class PluginEggSpring
  extends com.tencent.mm.kernel.b.f
  implements com.tencent.mm.kernel.a.b.b, com.tencent.mm.kernel.api.bucket.c, com.tencent.mm.plugin.eggspring.a.a
{
  private static final String xDl;
  public static final String xDm;
  public static final String xDn;
  private final Set<String> xDo;
  private long xDp;
  private long xDq;
  
  static
  {
    AppMethodBeat.i(108141);
    xDl = com.tencent.mm.loader.i.b.bnu();
    StringBuilder localStringBuilder = new StringBuilder();
    com.tencent.mm.plugin.eggspring.c.b.a locala = com.tencent.mm.plugin.eggspring.c.b.xEB;
    xDm = s.X(com.tencent.mm.loader.i.b.bms(), "/emoji/") + "egg_spring/";
    xDn = xDm + "innerLuckyBag.wxam";
    AppMethodBeat.o(108141);
  }
  
  public PluginEggSpring()
  {
    AppMethodBeat.i(266495);
    this.xDo = new HashSet();
    this.xDp = 0L;
    this.xDq = 3600000L;
    AppMethodBeat.o(266495);
  }
  
  /* Error */
  private void copyAsset(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: ldc 109
    //   4: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 115	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   10: invokevirtual 121	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   13: astore 5
    //   15: aload 5
    //   17: aload_1
    //   18: invokevirtual 127	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   21: astore_1
    //   22: new 129	com/tencent/mm/vfs/u
    //   25: dup
    //   26: aload_2
    //   27: invokespecial 132	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;)V
    //   30: astore 5
    //   32: aload 5
    //   34: invokevirtual 136	com/tencent/mm/vfs/u:jKS	()Z
    //   37: istore 4
    //   39: iload 4
    //   41: ifeq +17 -> 58
    //   44: aload_1
    //   45: ifnull +7 -> 52
    //   48: aload_1
    //   49: invokevirtual 141	java/io/InputStream:close	()V
    //   52: ldc 109
    //   54: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   57: return
    //   58: aload 5
    //   60: invokevirtual 145	com/tencent/mm/vfs/u:jKP	()Lcom/tencent/mm/vfs/u;
    //   63: invokevirtual 148	com/tencent/mm/vfs/u:jKY	()Z
    //   66: pop
    //   67: aload 5
    //   69: invokestatic 154	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   72: astore 5
    //   74: aload_0
    //   75: aload_1
    //   76: aload 5
    //   78: invokespecial 158	com/tencent/mm/plugin/eggspring/PluginEggSpring:copyFile	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   81: iload_3
    //   82: istore 4
    //   84: aload 5
    //   86: ifnull +11 -> 97
    //   89: aload 5
    //   91: invokevirtual 161	java/io/OutputStream:close	()V
    //   94: iload_3
    //   95: istore 4
    //   97: iload 4
    //   99: ifne +8 -> 107
    //   102: aload_2
    //   103: invokestatic 165	com/tencent/mm/vfs/y:deleteFile	(Ljava/lang/String;)Z
    //   106: pop
    //   107: ldc 167
    //   109: ldc 169
    //   111: iconst_1
    //   112: anewarray 171	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: iload 4
    //   119: invokestatic 177	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   122: aastore
    //   123: invokestatic 182	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: aload_1
    //   127: ifnull +130 -> 257
    //   130: aload_1
    //   131: invokevirtual 141	java/io/InputStream:close	()V
    //   134: ldc 109
    //   136: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: return
    //   140: astore_1
    //   141: ldc 167
    //   143: aload_1
    //   144: ldc 184
    //   146: iconst_0
    //   147: anewarray 171	java/lang/Object
    //   150: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: ldc 109
    //   155: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore 6
    //   161: ldc 167
    //   163: aload 6
    //   165: ldc 190
    //   167: iconst_0
    //   168: anewarray 171	java/lang/Object
    //   171: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: iconst_0
    //   175: istore_3
    //   176: goto -95 -> 81
    //   179: astore 6
    //   181: aload 5
    //   183: ifnull +8 -> 191
    //   186: aload 5
    //   188: invokevirtual 161	java/io/OutputStream:close	()V
    //   191: ldc 109
    //   193: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload 6
    //   198: athrow
    //   199: astore 5
    //   201: ldc 167
    //   203: aload 5
    //   205: ldc 192
    //   207: iconst_0
    //   208: anewarray 171	java/lang/Object
    //   211: invokestatic 188	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   214: iconst_0
    //   215: istore 4
    //   217: goto -120 -> 97
    //   220: astore 5
    //   222: aload 6
    //   224: aload 5
    //   226: invokevirtual 198	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   229: goto -38 -> 191
    //   232: astore_2
    //   233: aload_1
    //   234: ifnull +7 -> 241
    //   237: aload_1
    //   238: invokevirtual 141	java/io/InputStream:close	()V
    //   241: ldc 109
    //   243: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_2
    //   247: athrow
    //   248: astore_1
    //   249: aload_2
    //   250: aload_1
    //   251: invokevirtual 198	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   254: goto -13 -> 241
    //   257: ldc 109
    //   259: invokestatic 83	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   262: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	PluginEggSpring
    //   0	263	1	paramString1	String
    //   0	263	2	paramString2	String
    //   1	175	3	bool1	boolean
    //   37	179	4	bool2	boolean
    //   13	174	5	localObject1	Object
    //   199	5	5	localIOException1	java.io.IOException
    //   220	5	5	localThrowable	java.lang.Throwable
    //   159	5	6	localIOException2	java.io.IOException
    //   179	44	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	140	java/io/IOException
    //   48	52	140	java/io/IOException
    //   130	139	140	java/io/IOException
    //   241	248	140	java/io/IOException
    //   249	254	140	java/io/IOException
    //   74	81	159	java/io/IOException
    //   74	81	179	finally
    //   161	174	179	finally
    //   67	74	199	java/io/IOException
    //   89	94	199	java/io/IOException
    //   191	199	199	java/io/IOException
    //   222	229	199	java/io/IOException
    //   186	191	220	finally
    //   22	39	232	finally
    //   58	67	232	finally
    //   67	74	232	finally
    //   89	94	232	finally
    //   102	107	232	finally
    //   107	126	232	finally
    //   191	199	232	finally
    //   201	214	232	finally
    //   222	229	232	finally
    //   237	241	248	finally
  }
  
  private void copyFile(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    AppMethodBeat.i(108138);
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
    AppMethodBeat.o(108138);
  }
  
  private void initDir()
  {
    AppMethodBeat.i(108137);
    copyAsset("innerLuckyBag.wxam", xDn);
    AppMethodBeat.o(108137);
  }
  
  public void cleanPrefetch()
  {
    AppMethodBeat.i(266544);
    Log.i("MicroMsg.PluginEggSpring", "cleanPrefetch: ");
    Iterator localIterator = this.xDo.iterator();
    while (localIterator.hasNext()) {
      com.tencent.mm.plugin.game.luggage.h.remove((String)localIterator.next());
    }
    this.xDo.clear();
    AppMethodBeat.o(266544);
  }
  
  public void dependency()
  {
    AppMethodBeat.i(266583);
    dependsOn(com.tencent.mm.plugin.appbrand.api.c.class);
    AppMethodBeat.o(266583);
  }
  
  public boolean enablePlayLuckyEffect()
  {
    AppMethodBeat.i(266577);
    int i = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getInt("EmoticonLuckyBagProb", 100);
    int j = new Random().nextInt(100);
    Log.i("MicroMsg.PluginEggSpring", "enablePlayLuckyEffect config:%d, random:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    if (j < i)
    {
      AppMethodBeat.o(266577);
      return true;
    }
    AppMethodBeat.o(266577);
    return false;
  }
  
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(108139);
    Log.i("MicroMsg.PluginEggSpring", "execute");
    AppMethodBeat.o(108139);
  }
  
  public void filterOutInvalidAppId(com.tencent.mm.modelpackage.g arg1)
  {
    AppMethodBeat.i(266556);
    Object localObject1 = com.tencent.mm.plugin.eggspring.e.a.xFF;
    if (??? != null)
    {
      ??? = ???.oQz;
      s.s(???, "eggList.eggList");
      ??? = (Iterable)???;
      localObject1 = (Collection)new ArrayList();
      Iterator localIterator = ???.iterator();
      label98:
      while (localIterator.hasNext())
      {
        ??? = ((e)localIterator.next()).mij;
        if (??? == null) {}
        for (??? = null;; ??? = ???.appId)
        {
          if (??? == null) {
            break label98;
          }
          ((Collection)localObject1).add(???);
          break;
        }
      }
      localObject1 = (List)localObject1;
      synchronized (com.tencent.mm.plugin.eggspring.e.a.lPT)
      {
        localIterator = com.tencent.mm.plugin.eggspring.e.a.lPT.iterator();
        s.s(localIterator, "blockList.iterator()");
        while (localIterator.hasNext())
        {
          Object localObject3 = localIterator.next();
          s.s(localObject3, "iterator.next()");
          if (!((List)localObject1).contains((String)localObject3)) {
            localIterator.remove();
          }
        }
      }
      ah localah = ah.aiuX;
      com.tencent.mm.plugin.eggspring.e.a.dxK();
    }
    AppMethodBeat.o(266556);
  }
  
  public void goMiniApp(Context paramContext, String paramString1, String paramString2, int paramInt, final String paramString3)
  {
    AppMethodBeat.i(266568);
    paramString1 = new com.tencent.mm.plugin.appbrand.api.g();
    paramString1.username = paramString2;
    com.tencent.mm.util.i locali = com.tencent.mm.util.i.agtt;
    if (1 == com.tencent.mm.util.i.a(com.tencent.mm.util.b.a.agsv, 0)) {}
    for (int i = 1;; i = 0)
    {
      paramString1.scene = paramInt;
      if (i != 0) {}
      for (paramString1.euz = 2;; paramString1.euz = 0)
      {
        paramString1.ept = com.tencent.mm.plugin.appbrand.config.y.raR;
        paramString1.epu = com.tencent.mm.plugin.appbrand.config.y.raR;
        if (!Util.isNullOrNil(paramString3)) {
          paramString1.qAG = new com.tencent.mm.plugin.appbrand.api.d()
          {
            public final String toJsonString()
            {
              return paramString3;
            }
          };
        }
        Log.i("MicroMsg.PluginEggSpring", "goMiniApp username:%s", new Object[] { paramString2 });
        ((t)com.tencent.mm.kernel.h.ax(t.class)).a(paramContext, paramString1);
        AppMethodBeat.o(266568);
        return;
      }
    }
  }
  
  public void onAccountInitialized(f.c paramc)
  {
    AppMethodBeat.i(108135);
    Log.i("MicroMsg.PluginEggSpring", "onAccountInitialized");
    if (MMApplicationContext.isMainProcess())
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(108134);
          if (1 == ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znm, 0))
          {
            Log.i("MicroMsg.PluginEggSpring", "clear useless media.");
            com.tencent.mm.vfs.y.ew(PluginEggSpring.xDl, true);
            com.tencent.mm.vfs.y.ew(PluginEggSpring.xDm, true);
            AppMethodBeat.o(108134);
            return;
          }
          PluginEggSpring.access$100(PluginEggSpring.this);
          AppMethodBeat.o(108134);
        }
      }, "init_egg_spring_dir");
      paramc = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().dzx();
      if ((paramc != null) && (!paramc.oQz.isEmpty()))
      {
        paramc = paramc.oQz.iterator();
        while (paramc.hasNext())
        {
          e locale = (e)paramc.next();
          if (locale.type == 5)
          {
            w localw = (w)com.tencent.mm.kernel.h.ax(w.class);
            if (localw != null)
            {
              Log.i("MicroMsg.PluginEggSpring", "registerPkgSpecs success, username:%s, appId:%s", new Object[] { locale.mhJ.userName, locale.mhJ.appId });
              localw.A(locale.mhJ.userName, locale.mhJ.appId, 1189);
            }
            else
            {
              com.tencent.threadpool.h.ahAA.o(new PluginEggSpring..ExternalSyntheticLambda0(locale), 10000L);
              Log.i("MicroMsg.PluginEggSpring", "registerPkgSpecs Failed, IWxaPkgDownloaderExportService Null");
            }
          }
        }
      }
    }
    AppMethodBeat.o(108135);
  }
  
  public void onAccountRelease()
  {
    AppMethodBeat.i(108136);
    Log.i("MicroMsg.PluginEggSpring", "onAccountRelease");
    AppMethodBeat.o(108136);
  }
  
  public void parallelsDependency()
  {
    AppMethodBeat.i(266585);
    com.tencent.mm.kernel.a.b.a.a(this, com.tencent.mm.kernel.api.c.class).db(com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.appbrand.api.c.class));
    AppMethodBeat.o(266585);
  }
  
  public void prefetch(String paramString)
  {
    AppMethodBeat.i(266540);
    this.xDo.add(paramString);
    if (com.tencent.mm.plugin.game.luggage.h.aFZ(paramString) != null)
    {
      Log.i("MicroMsg.PluginEggSpring", "has prefetch %s", new Object[] { paramString });
      AppMethodBeat.o(266540);
      return;
    }
    int i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.znp, 0);
    Log.i("MicroMsg.PluginEggSpring", "prefetch %s: config %s", new Object[] { paramString, Integer.valueOf(i) });
    if (i == 1) {
      com.tencent.mm.plugin.game.luggage.h.a(com.tencent.mm.plugin.game.luggage.i.class, paramString, new h.a()
      {
        public final void callback()
        {
          AppMethodBeat.i(266489);
          Log.i("MicroMsg.PluginEggSpring", "prefetch callback");
          AppMethodBeat.o(266489);
        }
      });
    }
    AppMethodBeat.o(266540);
  }
  
  public void preloadMiniProgram(String paramString)
  {
    AppMethodBeat.i(266561);
    ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.g.class)).b(ab.tUh);
    AppMethodBeat.o(266561);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.eggspring.PluginEggSpring
 * JD-Core Version:    0.7.0.1
 */
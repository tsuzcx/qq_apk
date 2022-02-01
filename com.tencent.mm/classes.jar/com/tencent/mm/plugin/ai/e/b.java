package com.tencent.mm.plugin.ai.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.HashSet;

public final class b
{
  String dNA;
  String kxA;
  String kxB;
  String kxC;
  int kxD;
  int kxE;
  int kxF;
  int kxG;
  HashSet<String> kxH;
  boolean kxr;
  private PBool kxs;
  String kxt;
  String kxu;
  String kxv;
  String kxw;
  String kxx;
  String kxy;
  String kxz;
  int pos;
  
  public b(String paramString)
  {
    AppMethodBeat.i(238928);
    this.kxr = false;
    this.kxs = null;
    this.kxH = new HashSet();
    this.dNA = paramString;
    AppMethodBeat.o(238928);
  }
  
  /* Error */
  private static String A(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 61
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 63	com/tencent/mm/vfs/o
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 66	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: astore 5
    //   16: new 68	java/io/BufferedInputStream
    //   19: dup
    //   20: aload_2
    //   21: invokestatic 74	com/tencent/mm/vfs/s:openRead	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: invokespecial 77	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_1
    //   28: new 79	java/io/BufferedOutputStream
    //   31: dup
    //   32: aload 5
    //   34: invokestatic 83	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   37: invokespecial 86	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_1
    //   46: aload_0
    //   47: invokestatic 92	org/apache/commons/a/e:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   50: pop
    //   51: aload_1
    //   52: invokestatic 95	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
    //   55: aload_0
    //   56: invokestatic 98	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
    //   59: aload 5
    //   61: invokevirtual 102	com/tencent/mm/vfs/o:exists	()Z
    //   64: ifeq +73 -> 137
    //   67: aload 5
    //   69: invokevirtual 106	com/tencent/mm/vfs/o:her	()Landroid/net/Uri;
    //   72: invokestatic 112	com/tencent/mm/vfs/aa:z	(Landroid/net/Uri;)Ljava/lang/String;
    //   75: astore_0
    //   76: ldc 61
    //   78: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: aload_0
    //   82: areturn
    //   83: astore 4
    //   85: aconst_null
    //   86: astore_0
    //   87: aconst_null
    //   88: astore_1
    //   89: aload_0
    //   90: astore_3
    //   91: aload_1
    //   92: astore_2
    //   93: ldc 114
    //   95: aload 4
    //   97: ldc 116
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 122	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: invokestatic 95	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
    //   110: aload_0
    //   111: invokestatic 98	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
    //   114: goto -55 -> 59
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: invokestatic 95	org/apache/commons/a/e:W	(Ljava/io/InputStream;)V
    //   126: aload_3
    //   127: invokestatic 98	org/apache/commons/a/e:e	(Ljava/io/OutputStream;)V
    //   130: ldc 61
    //   132: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: athrow
    //   137: ldc 61
    //   139: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: ldc 124
    //   144: areturn
    //   145: astore_0
    //   146: aconst_null
    //   147: astore_3
    //   148: goto -26 -> 122
    //   151: astore_0
    //   152: aload_2
    //   153: astore_1
    //   154: goto -32 -> 122
    //   157: astore 4
    //   159: aconst_null
    //   160: astore_0
    //   161: goto -72 -> 89
    //   164: astore 4
    //   166: goto -77 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString1	String
    //   0	169	1	paramString2	String
    //   0	169	2	paramString3	String
    //   42	106	3	str	String
    //   83	13	4	localException1	Exception
    //   157	1	4	localException2	Exception
    //   164	1	4	localException3	Exception
    //   14	54	5	localo	o
    // Exception table:
    //   from	to	target	type
    //   16	28	83	java/lang/Exception
    //   16	28	117	finally
    //   28	41	145	finally
    //   45	51	151	finally
    //   93	106	151	finally
    //   28	41	157	java/lang/Exception
    //   45	51	164	java/lang/Exception
  }
  
  private boolean cj(String paramString1, String paramString2)
  {
    AppMethodBeat.i(238931);
    long l = Util.currentTicks();
    if (this.kxs == null)
    {
      this.kxs = new PBool();
      this.kxs.value = false;
    }
    try
    {
      System.load(paramString1);
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        boolean bool;
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
        h.CyF.dN(1559, 36);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        label58:
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
        h.CyF.dN(1559, 36);
      }
    }
    try
    {
      System.load(paramString2);
      this.kxs.value = true;
      org.tensorflow.lite.a.a.Ujx.value = true;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
      h.CyF.dN(1559, 37);
      break label58;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
      h.CyF.dN(1559, 37);
      break label58;
    }
    Log.i("MicroMsg.FinderRedDotConfig", "load tensorflow lite so [%b] cost[%d]", new Object[] { Boolean.valueOf(this.kxs.value), Long.valueOf(Util.ticksToNow(l)) });
    bool = this.kxs.value;
    AppMethodBeat.o(238931);
    return bool;
  }
  
  private static String z(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(238932);
    paramString1 = new o(paramString3, paramString1);
    if (!paramString1.exists())
    {
      AppMethodBeat.o(238932);
      return "";
    }
    if (!paramString2.equalsIgnoreCase(com.tencent.mm.b.g.a(paramString1, 102400)))
    {
      paramString1.delete();
      AppMethodBeat.o(238932);
      return "";
    }
    paramString1 = aa.z(paramString1.her());
    AppMethodBeat.o(238932);
    return paramString1;
  }
  
  final void TL(String paramString)
  {
    AppMethodBeat.i(238929);
    if (!Util.isNullOrNil(paramString))
    {
      String[] arrayOfString = paramString.split("#");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          this.kxH.add(str);
          i += 1;
        }
      }
    }
    Log.i("MicroMsg.FinderRedDotConfig", "parse no predict session id [%s]", new Object[] { paramString });
    AppMethodBeat.o(238929);
  }
  
  protected final boolean a(com.tencent.mm.plugin.ai.d.a.a parama, PString paramPString1, PString paramPString2, PString paramPString3)
  {
    AppMethodBeat.i(238930);
    if (!this.kxr)
    {
      AppMethodBeat.o(238930);
      return false;
    }
    paramPString3.value = "";
    paramPString2.value = "";
    paramPString1.value = "";
    int i;
    for (;;)
    {
      try
      {
        Object localObject1 = new PString();
        Object localObject2 = this.kxt;
        ((PString)localObject1).value = "";
        localObject2 = com.tencent.mm.plugin.ai.f.b.bqC().TM((String)localObject2);
        Object localObject3;
        Object localObject4;
        label363:
        boolean bool;
        if (Util.isNullOrNil((String)localObject2))
        {
          i = -1;
          break label1216;
          localObject2 = this.kxt;
          localObject3 = this.kxu;
          long l = 0L;
          if (parama.kwG.containsKey(localObject2)) {
            l = ((Long)parama.kwG.get(localObject2)).longValue();
          }
          if (Util.milliSecondsToNow(l) <= 1800000L) {
            break label1239;
          }
          h.CyF.dN(1559, 0);
          parama.kwG.put(localObject2, new Long(Util.nowMilliSecond()));
          localObject1 = com.tencent.mm.plugin.ai.f.b.bqC();
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = "";
            localObject4 = com.tencent.mm.plugin.ai.f.b.bqC().TM((String)localObject2);
            localObject4 = new com.tencent.mm.plugin.ai.d.a.b((String)localObject2, (String)localObject1, (String)localObject3, parama.kwH, (String)localObject4);
            com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
            localg.field_mediaId = ((com.tencent.mm.plugin.ai.d.a.b)localObject4).mediaId;
            localg.gqB = ((com.tencent.mm.plugin.ai.d.a.b)localObject4).url;
            localg.field_fullpath = ((com.tencent.mm.plugin.ai.d.a.b)localObject4).kwN;
            localg.field_fileType = com.tencent.mm.i.a.gqg;
            localg.gqF = false;
            localg.gqy = ((g.a)localObject4);
            f.baQ().b(localg, -1);
            Log.i("MicroMsg.AiDownloadTask", "start to download task [%s] [%s] [%s]", new Object[] { ((com.tencent.mm.plugin.ai.d.a.b)localObject4).mediaId, ((com.tencent.mm.plugin.ai.d.a.b)localObject4).kwN, ((com.tencent.mm.plugin.ai.d.a.b)localObject4).url });
            Log.i("MicroMsg.AiDownloadLogic", "%s add to download url[%s] path[%s] md5[%s]", new Object[] { parama.info(), localObject2, localObject1, localObject3 });
            break label1239;
            bool = Util.isNullOrNil(parama);
            if (!bool) {
              continue;
            }
            AppMethodBeat.o(238930);
            return false;
          }
        }
        else
        {
          if (!s.YS((String)localObject2))
          {
            i = -1;
            break label1216;
          }
          ((PString)localObject1).value = ((String)localObject2);
          i = 0;
          break label1216;
          h.CyF.dN(1559, 30);
          parama = ((PString)localObject1).value;
          continue;
        }
        localObject1 = ((com.tencent.mm.plugin.ai.f.b)localObject1).kxN + ((String)localObject2).hashCode() + ".file";
        continue;
        if (org.tensorflow.lite.a.a.Ujx.value)
        {
          bool = true;
          if (!bool)
          {
            Log.w("MicroMsg.FinderRedDotConfig", "load tensorflow lite so error");
            s.dy(parama, true);
            AppMethodBeat.o(238930);
            return false;
          }
        }
        else
        {
          com.tencent.mm.plugin.ai.f.b.bqC();
          localObject1 = o.X(MMApplicationContext.getContext().getDir("aimodel", 0));
          if ((!((o)localObject1).exists()) && (!((o)localObject1).mkdirs()))
          {
            localObject1 = "";
            if (Util.isNullOrNil((String)localObject1))
            {
              h.CyF.dN(1559, 31);
              bool = false;
            }
          }
          else
          {
            localObject1 = aa.z(((o)localObject1).her());
            continue;
          }
          localObject3 = z("libtensorflowlite_jni.so", this.kxv, (String)localObject1);
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3))
          {
            localObject2 = new PString();
            if ((com.tencent.mm.plugin.ai.d.a.a.a(this.kxv, "libtensorflowlite_jni.so", parama, (PString)localObject2) != 0) || (Util.isNullOrNil(((PString)localObject2).value)))
            {
              h.CyF.dN(1559, 32);
              bool = false;
              continue;
            }
            localObject3 = A((String)localObject1, "libtensorflowlite_jni.so", ((PString)localObject2).value);
            localObject2 = localObject3;
            if (Util.isNullOrNil((String)localObject3))
            {
              h.CyF.dN(1559, 33);
              bool = false;
              continue;
            }
          }
          localObject4 = z("libtensorflowlite_flex_jni.so", this.kxw, (String)localObject1);
          localObject3 = localObject4;
          if (Util.isNullOrNil((String)localObject4))
          {
            localObject3 = new PString();
            if ((com.tencent.mm.plugin.ai.d.a.a.a(this.kxw, "libtensorflowlite_flex_jni.so", parama, (PString)localObject3) != 0) || (Util.isNullOrNil(((PString)localObject3).value)))
            {
              h.CyF.dN(1559, 34);
              bool = false;
              continue;
            }
            localObject1 = A((String)localObject1, "libtensorflowlite_flex_jni.so", ((PString)localObject3).value);
            localObject3 = localObject1;
            if (Util.isNullOrNil((String)localObject1))
            {
              h.CyF.dN(1559, 35);
              bool = false;
              continue;
            }
          }
          bool = cj((String)localObject2, (String)localObject3);
          continue;
        }
        localObject1 = new PString();
        switch (com.tencent.mm.plugin.ai.d.a.a.a(this.kxy, this.kxx, parama, (PString)localObject1))
        {
        case -1: 
          label888:
          paramPString1.value = ((PString)localObject1).value;
          if (!Util.isNullOrNil(paramPString1.value)) {
            break label975;
          }
          Log.w("MicroMsg.FinderRedDotConfig", "model file is null");
          s.dy(parama, true);
          AppMethodBeat.o(238930);
          return false;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", parama, "start to check error", new Object[0]);
        AppMethodBeat.o(238930);
        return false;
      }
      h.CyF.dN(1559, 2);
      continue;
      h.CyF.dN(1559, 1);
    }
    label975:
    paramPString1 = new PString();
    switch (com.tencent.mm.plugin.ai.d.a.a.a(this.kxA, this.kxz, parama, paramPString1))
    {
    case -1: 
    case 0: 
    case -2: 
      for (;;)
      {
        label1024:
        paramPString2.value = paramPString1.value;
        if (!Util.isNullOrNil(paramPString2.value)) {
          break;
        }
        Log.w("MicroMsg.FinderRedDotConfig", "model Quantiles file is null");
        s.dy(parama, true);
        AppMethodBeat.o(238930);
        return false;
        h.CyF.dN(1559, 39);
        continue;
        h.CyF.dN(1559, 40);
      }
      paramPString1 = new PString();
      switch (com.tencent.mm.plugin.ai.d.a.a.a(this.kxC, this.kxB, parama, paramPString1))
      {
      }
      break;
    }
    for (;;)
    {
      paramPString3.value = paramPString1.value;
      if (Util.isNullOrNil(paramPString3.value))
      {
        Log.w("MicroMsg.FinderRedDotConfig", "model Tffeat2idx file is null");
        s.dy(parama, true);
        AppMethodBeat.o(238930);
        return false;
        h.CyF.dN(1559, 41);
        continue;
        h.CyF.dN(1559, 42);
      }
      else
      {
        AppMethodBeat.o(238930);
        return true;
        label1216:
        switch (i)
        {
        }
        break;
        label1239:
        parama = "";
        break label363;
        break label888;
        break label1024;
      }
    }
  }
  
  protected final boolean bqA()
  {
    if (!this.kxr) {}
    while (this.kxD <= 0) {
      return false;
    }
    return true;
  }
  
  protected final int bqB()
  {
    if (!this.kxr) {}
    do
    {
      return -1;
      if (this.kxD > 0) {
        return this.kxD;
      }
    } while (this.kxE <= 0);
    return this.kxE;
  }
  
  protected final int getPos()
  {
    if (!this.kxr) {
      return -1;
    }
    return this.pos;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.e.b
 * JD-Core Version:    0.7.0.1
 */
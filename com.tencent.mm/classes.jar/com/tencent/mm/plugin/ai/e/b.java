package com.tencent.mm.plugin.ai.e;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aq.f;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.ai.f.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.HashSet;

public final class b
{
  String fGM;
  int nqA;
  int nqB;
  private PInt nqC;
  private PInt nqD;
  PFloat nqE;
  PInt nqF;
  boolean nqj;
  private PBool nqk;
  String nql;
  String nqm;
  String nqn;
  String nqo;
  String nqp;
  String nqq;
  String nqr;
  String nqs;
  String nqt;
  String nqu;
  int nqv;
  int nqw;
  int nqx;
  int nqy;
  HashSet<String> nqz;
  int pos;
  
  public b(String paramString)
  {
    AppMethodBeat.i(239857);
    this.nqj = false;
    this.nqk = null;
    this.nqz = new HashSet();
    this.fGM = paramString;
    AppMethodBeat.o(239857);
  }
  
  private static String A(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(239878);
    paramString1 = new q(paramString3, paramString1);
    if (!paramString1.ifE())
    {
      AppMethodBeat.o(239878);
      return "";
    }
    if (!paramString2.equalsIgnoreCase(com.tencent.mm.b.g.a(paramString1, 102400)))
    {
      paramString1.cFq();
      AppMethodBeat.o(239878);
      return "";
    }
    paramString1 = paramString1.bOF();
    AppMethodBeat.o(239878);
    return paramString1;
  }
  
  /* Error */
  private static String B(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 102
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 69	com/tencent/mm/vfs/q
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 72	com/tencent/mm/vfs/q:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: astore 5
    //   16: new 104	java/io/BufferedInputStream
    //   19: dup
    //   20: aload_2
    //   21: invokestatic 110	com/tencent/mm/vfs/u:Tf	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: invokespecial 113	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_1
    //   28: new 115	java/io/BufferedOutputStream
    //   31: dup
    //   32: aload 5
    //   34: invokestatic 119	com/tencent/mm/vfs/u:an	(Lcom/tencent/mm/vfs/q;)Ljava/io/OutputStream;
    //   37: invokespecial 122	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_1
    //   46: aload_0
    //   47: invokestatic 128	org/apache/commons/a/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   50: pop
    //   51: aload_1
    //   52: invokestatic 131	org/apache/commons/a/d:T	(Ljava/io/InputStream;)V
    //   55: aload_0
    //   56: invokestatic 134	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   59: aload 5
    //   61: invokevirtual 76	com/tencent/mm/vfs/q:ifE	()Z
    //   64: ifeq +70 -> 134
    //   67: aload 5
    //   69: invokevirtual 98	com/tencent/mm/vfs/q:bOF	()Ljava/lang/String;
    //   72: astore_0
    //   73: ldc 102
    //   75: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: aload_0
    //   79: areturn
    //   80: astore 4
    //   82: aconst_null
    //   83: astore_0
    //   84: aconst_null
    //   85: astore_1
    //   86: aload_0
    //   87: astore_3
    //   88: aload_1
    //   89: astore_2
    //   90: ldc 136
    //   92: aload 4
    //   94: ldc 138
    //   96: iconst_0
    //   97: anewarray 4	java/lang/Object
    //   100: invokestatic 144	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_1
    //   104: invokestatic 131	org/apache/commons/a/d:T	(Ljava/io/InputStream;)V
    //   107: aload_0
    //   108: invokestatic 134	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   111: goto -52 -> 59
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_3
    //   117: aconst_null
    //   118: astore_1
    //   119: aload_1
    //   120: invokestatic 131	org/apache/commons/a/d:T	(Ljava/io/InputStream;)V
    //   123: aload_3
    //   124: invokestatic 134	org/apache/commons/a/d:e	(Ljava/io/OutputStream;)V
    //   127: ldc 102
    //   129: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   132: aload_0
    //   133: athrow
    //   134: ldc 102
    //   136: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: ldc 78
    //   141: areturn
    //   142: astore_0
    //   143: aconst_null
    //   144: astore_3
    //   145: goto -26 -> 119
    //   148: astore_0
    //   149: aload_2
    //   150: astore_1
    //   151: goto -32 -> 119
    //   154: astore 4
    //   156: aconst_null
    //   157: astore_0
    //   158: goto -72 -> 86
    //   161: astore 4
    //   163: goto -77 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	166	0	paramString1	String
    //   0	166	1	paramString2	String
    //   0	166	2	paramString3	String
    //   42	103	3	str	String
    //   80	13	4	localException1	Exception
    //   154	1	4	localException2	Exception
    //   161	1	4	localException3	Exception
    //   14	54	5	localq	q
    // Exception table:
    //   from	to	target	type
    //   16	28	80	java/lang/Exception
    //   16	28	114	finally
    //   28	41	142	finally
    //   45	51	148	finally
    //   90	103	148	finally
    //   28	41	154	java/lang/Exception
    //   45	51	161	java/lang/Exception
  }
  
  private int bBn()
  {
    if (!this.nqj) {
      return -1;
    }
    return this.pos;
  }
  
  private boolean co(String paramString1, String paramString2)
  {
    AppMethodBeat.i(239875);
    long l = Util.currentTicks();
    if (this.nqk == null)
    {
      this.nqk = new PBool();
      this.nqk.value = false;
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
        h.IzE.el(1559, 36);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        label58:
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
        h.IzE.el(1559, 36);
      }
    }
    try
    {
      System.load(paramString2);
      this.nqk.value = true;
      org.tensorflow.lite.a.a.abMS.value = true;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
      h.IzE.el(1559, 37);
      break label58;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
      h.IzE.el(1559, 37);
      break label58;
    }
    Log.i("MicroMsg.FinderRedDotConfig", "load tensorflow lite so [%b] cost[%d]", new Object[] { Boolean.valueOf(this.nqk.value), Long.valueOf(Util.ticksToNow(l)) });
    bool = this.nqk.value;
    AppMethodBeat.o(239875);
    return bool;
  }
  
  protected final boolean a(com.tencent.mm.plugin.ai.d.a.a parama, PString paramPString1, PString paramPString2, PString paramPString3)
  {
    AppMethodBeat.i(239873);
    if (!this.nqj)
    {
      AppMethodBeat.o(239873);
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
        Object localObject2 = this.nql;
        ((PString)localObject1).value = "";
        localObject2 = com.tencent.mm.plugin.ai.f.b.bBr().abw((String)localObject2);
        Object localObject3;
        Object localObject4;
        label363:
        boolean bool;
        if (Util.isNullOrNil((String)localObject2))
        {
          i = -1;
          break label1203;
          localObject2 = this.nql;
          localObject3 = this.nqm;
          long l = 0L;
          if (parama.npA.containsKey(localObject2)) {
            l = ((Long)parama.npA.get(localObject2)).longValue();
          }
          if (Util.milliSecondsToNow(l) <= 1800000L) {
            break label1227;
          }
          h.IzE.el(1559, 0);
          parama.npA.put(localObject2, new Long(Util.nowMilliSecond()));
          localObject1 = com.tencent.mm.plugin.ai.f.b.bBr();
          if (Util.isNullOrNil((String)localObject2))
          {
            localObject1 = "";
            localObject4 = com.tencent.mm.plugin.ai.f.b.bBr().abw((String)localObject2);
            localObject4 = new com.tencent.mm.plugin.ai.d.a.b((String)localObject2, (String)localObject1, (String)localObject3, parama.npB, (String)localObject4);
            com.tencent.mm.i.g localg = new com.tencent.mm.i.g();
            localg.field_mediaId = ((com.tencent.mm.plugin.ai.d.a.b)localObject4).mediaId;
            localg.iUJ = ((com.tencent.mm.plugin.ai.d.a.b)localObject4).url;
            localg.field_fullpath = ((com.tencent.mm.plugin.ai.d.a.b)localObject4).npH;
            localg.field_fileType = com.tencent.mm.i.a.iUo;
            localg.iUN = false;
            localg.iUG = ((g.a)localObject4);
            f.bkg().b(localg, -1);
            Log.i("MicroMsg.AiDownloadTask", "start to download task [%s] [%s] [%s]", new Object[] { ((com.tencent.mm.plugin.ai.d.a.b)localObject4).mediaId, ((com.tencent.mm.plugin.ai.d.a.b)localObject4).npH, ((com.tencent.mm.plugin.ai.d.a.b)localObject4).url });
            Log.i("MicroMsg.AiDownloadLogic", "%s add to download url[%s] path[%s] md5[%s]", new Object[] { parama.info(), localObject2, localObject1, localObject3 });
            break label1227;
            bool = Util.isNullOrNil(parama);
            if (!bool) {
              continue;
            }
            AppMethodBeat.o(239873);
            return false;
          }
        }
        else
        {
          if (!u.agG((String)localObject2))
          {
            i = -1;
            break label1203;
          }
          ((PString)localObject1).value = ((String)localObject2);
          i = 0;
          break label1203;
          h.IzE.el(1559, 30);
          parama = ((PString)localObject1).value;
          continue;
        }
        localObject1 = ((com.tencent.mm.plugin.ai.f.b)localObject1).nqM + ((String)localObject2).hashCode() + ".file";
        continue;
        if (org.tensorflow.lite.a.a.abMS.value)
        {
          bool = true;
          if (!bool)
          {
            Log.w("MicroMsg.FinderRedDotConfig", "load tensorflow lite so error");
            u.deleteDir(parama);
            AppMethodBeat.o(239873);
            return false;
          }
        }
        else
        {
          com.tencent.mm.plugin.ai.f.b.bBr();
          localObject1 = q.Q(MMApplicationContext.getContext().getDir("aimodel", 0));
          if ((!((q)localObject1).ifE()) && (!((q)localObject1).ifL()))
          {
            localObject1 = "";
            if (Util.isNullOrNil((String)localObject1))
            {
              h.IzE.el(1559, 31);
              bool = false;
            }
          }
          else
          {
            localObject1 = ((q)localObject1).bOF();
            continue;
          }
          localObject3 = A("libtensorflowlite_jni.so", this.nqn, (String)localObject1);
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3))
          {
            localObject2 = new PString();
            if ((com.tencent.mm.plugin.ai.d.a.a.a(this.nqn, "libtensorflowlite_jni.so", parama, (PString)localObject2) != 0) || (Util.isNullOrNil(((PString)localObject2).value)))
            {
              h.IzE.el(1559, 32);
              bool = false;
              continue;
            }
            localObject3 = B((String)localObject1, "libtensorflowlite_jni.so", ((PString)localObject2).value);
            localObject2 = localObject3;
            if (Util.isNullOrNil((String)localObject3))
            {
              h.IzE.el(1559, 33);
              bool = false;
              continue;
            }
          }
          localObject4 = A("libtensorflowlite_flex_jni.so", this.nqo, (String)localObject1);
          localObject3 = localObject4;
          if (Util.isNullOrNil((String)localObject4))
          {
            localObject3 = new PString();
            if ((com.tencent.mm.plugin.ai.d.a.a.a(this.nqo, "libtensorflowlite_flex_jni.so", parama, (PString)localObject3) != 0) || (Util.isNullOrNil(((PString)localObject3).value)))
            {
              h.IzE.el(1559, 34);
              bool = false;
              continue;
            }
            localObject1 = B((String)localObject1, "libtensorflowlite_flex_jni.so", ((PString)localObject3).value);
            localObject3 = localObject1;
            if (Util.isNullOrNil((String)localObject1))
            {
              h.IzE.el(1559, 35);
              bool = false;
              continue;
            }
          }
          bool = co((String)localObject2, (String)localObject3);
          continue;
        }
        localObject1 = new PString();
        switch (com.tencent.mm.plugin.ai.d.a.a.a(this.nqq, this.nqp, parama, (PString)localObject1))
        {
        case -1: 
          label884:
          paramPString1.value = ((PString)localObject1).value;
          if (!Util.isNullOrNil(paramPString1.value)) {
            break label970;
          }
          Log.w("MicroMsg.FinderRedDotConfig", "model file is null");
          u.deleteDir(parama);
          AppMethodBeat.o(239873);
          return false;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", parama, "start to check error", new Object[0]);
        AppMethodBeat.o(239873);
        return false;
      }
      h.IzE.el(1559, 2);
      continue;
      h.IzE.el(1559, 1);
    }
    label970:
    paramPString1 = new PString();
    switch (com.tencent.mm.plugin.ai.d.a.a.a(this.nqs, this.nqr, parama, paramPString1))
    {
    case -1: 
    case 0: 
    case -2: 
      for (;;)
      {
        label1016:
        paramPString2.value = paramPString1.value;
        if (!Util.isNullOrNil(paramPString2.value)) {
          break;
        }
        Log.w("MicroMsg.FinderRedDotConfig", "model Quantiles file is null");
        u.deleteDir(parama);
        AppMethodBeat.o(239873);
        return false;
        h.IzE.el(1559, 39);
        continue;
        h.IzE.el(1559, 40);
      }
      paramPString1 = new PString();
      switch (com.tencent.mm.plugin.ai.d.a.a.a(this.nqu, this.nqt, parama, paramPString1))
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
        u.deleteDir(parama);
        AppMethodBeat.o(239873);
        return false;
        h.IzE.el(1559, 41);
        continue;
        h.IzE.el(1559, 42);
      }
      else
      {
        AppMethodBeat.o(239873);
        return true;
        label1203:
        switch (i)
        {
        }
        break;
        label1227:
        parama = "";
        break label363;
        break label884;
        break label1016;
      }
    }
  }
  
  final void abv(String paramString)
  {
    AppMethodBeat.i(239860);
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
          this.nqz.add(str);
          i += 1;
        }
      }
    }
    Log.i("MicroMsg.FinderRedDotConfig", "parse no predict session id [%s]", new Object[] { paramString });
    AppMethodBeat.o(239860);
  }
  
  protected final int bBo()
  {
    if (!this.nqj) {
      return -1;
    }
    return this.nqA;
  }
  
  protected final int bBp()
  {
    int i = -1;
    AppMethodBeat.i(239868);
    int k = bBo();
    int j = bBn();
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(239868);
      return i;
      i = bBn();
      continue;
      k = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond());
      if (k > 0) {
        break;
      }
      label69:
      if (i <= 0) {
        break label201;
      }
    }
    HashSet localHashSet;
    int m;
    if ((this.nqD == null) || (this.nqD.value != k) || (this.nqC == null))
    {
      this.nqD = new PInt(k);
      this.nqC = new PInt(-1);
      localHashSet = com.tencent.mm.plugin.ai.f.b.bBr().nqG.bBs();
      i = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 86400000L);
      k = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 172800000L);
      m = com.tencent.mm.plugin.ai.c.a.Hg(Util.nowMilliSecond() - 259200000L);
      if ((localHashSet != null) && (!localHashSet.isEmpty())) {
        break label203;
      }
      this.nqC.value = 20;
    }
    for (;;)
    {
      i = this.nqC.value;
      break label69;
      label201:
      break;
      label203:
      if ((localHashSet.contains(Integer.valueOf(i))) && (localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m)))) {
        this.nqC.value = 6;
      } else if ((localHashSet.contains(Integer.valueOf(i))) && (localHashSet.contains(Integer.valueOf(k)))) {
        this.nqC.value = 8;
      } else if ((localHashSet.contains(Integer.valueOf(i))) && (localHashSet.contains(Integer.valueOf(m)))) {
        this.nqC.value = 10;
      } else if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m)))) {
        this.nqC.value = 12;
      } else if (localHashSet.contains(Integer.valueOf(i))) {
        this.nqC.value = 14;
      } else if (localHashSet.contains(Integer.valueOf(k))) {
        this.nqC.value = 16;
      } else if (localHashSet.contains(Integer.valueOf(m))) {
        this.nqC.value = 18;
      }
    }
  }
  
  protected final int bBq()
  {
    if (!this.nqj) {}
    do
    {
      return -1;
      if (this.nqv > 0) {
        return this.nqv;
      }
    } while (this.nqw <= 0);
    return this.nqw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.e.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ai.service;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ai.d.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PFloat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashSet;

public final class b
{
  String hMi;
  String modelName;
  int pos;
  boolean qoO;
  private PBool qoP;
  String qoQ;
  String qoR;
  String qoS;
  String qoT;
  String qoU;
  String qoV;
  String qoW;
  String qoX;
  String qoY;
  int qoZ;
  int qpa;
  int qpb;
  int qpc;
  HashSet<String> qpd;
  int qpe;
  int qpf;
  private PInt qpg;
  private PInt qph;
  PFloat qpi;
  PInt qpj;
  
  public b(String paramString)
  {
    AppMethodBeat.i(267435);
    this.qoO = false;
    this.qoP = null;
    this.qpd = new HashSet();
    this.hMi = paramString;
    AppMethodBeat.o(267435);
  }
  
  private static String D(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(267455);
    paramString1 = new u(paramString3, paramString1);
    if (!paramString1.jKS())
    {
      AppMethodBeat.o(267455);
      return "";
    }
    if (!paramString2.equalsIgnoreCase(com.tencent.mm.b.g.a(paramString1, 102400)))
    {
      paramString1.diJ();
      AppMethodBeat.o(267455);
      return "";
    }
    paramString1 = ah.v(paramString1.jKT());
    AppMethodBeat.o(267455);
    return paramString1;
  }
  
  /* Error */
  private static String E(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: ldc 108
    //   2: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 69	com/tencent/mm/vfs/u
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: invokespecial 72	com/tencent/mm/vfs/u:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   14: astore 5
    //   16: new 110	java/io/BufferedInputStream
    //   19: dup
    //   20: aload_2
    //   21: invokestatic 116	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   24: invokespecial 119	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   27: astore_1
    //   28: new 121	java/io/BufferedOutputStream
    //   31: dup
    //   32: aload 5
    //   34: invokestatic 125	com/tencent/mm/vfs/y:ap	(Lcom/tencent/mm/vfs/u;)Ljava/io/OutputStream;
    //   37: invokespecial 128	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   40: astore_0
    //   41: aload_0
    //   42: astore_3
    //   43: aload_1
    //   44: astore_2
    //   45: aload_1
    //   46: aload_0
    //   47: invokestatic 134	org/apache/commons/b/d:copy	(Ljava/io/InputStream;Ljava/io/OutputStream;)I
    //   50: pop
    //   51: aload_1
    //   52: invokestatic 137	org/apache/commons/b/d:ai	(Ljava/io/InputStream;)V
    //   55: aload_0
    //   56: invokestatic 140	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   59: aload 5
    //   61: invokevirtual 76	com/tencent/mm/vfs/u:jKS	()Z
    //   64: ifeq +73 -> 137
    //   67: aload 5
    //   69: invokevirtual 98	com/tencent/mm/vfs/u:jKT	()Landroid/net/Uri;
    //   72: invokestatic 104	com/tencent/mm/vfs/ah:v	(Landroid/net/Uri;)Ljava/lang/String;
    //   75: astore_0
    //   76: ldc 108
    //   78: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   93: ldc 142
    //   95: aload 4
    //   97: ldc 144
    //   99: iconst_0
    //   100: anewarray 4	java/lang/Object
    //   103: invokestatic 150	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   106: aload_1
    //   107: invokestatic 137	org/apache/commons/b/d:ai	(Ljava/io/InputStream;)V
    //   110: aload_0
    //   111: invokestatic 140	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   114: goto -55 -> 59
    //   117: astore_0
    //   118: aconst_null
    //   119: astore_3
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: invokestatic 137	org/apache/commons/b/d:ai	(Ljava/io/InputStream;)V
    //   126: aload_3
    //   127: invokestatic 140	org/apache/commons/b/d:e	(Ljava/io/OutputStream;)V
    //   130: ldc 108
    //   132: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_0
    //   136: athrow
    //   137: ldc 108
    //   139: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   142: ldc 78
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
    //   14	54	5	localu	u
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
  
  private boolean cE(String paramString1, String paramString2)
  {
    AppMethodBeat.i(267447);
    long l = Util.currentTicks();
    if (this.qoP == null)
    {
      this.qoP = new PBool();
      this.qoP.value = false;
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
        h.OAn.kJ(1559, 36);
      }
    }
    catch (Exception paramString1)
    {
      for (;;)
      {
        label58:
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
        h.OAn.kJ(1559, 36);
      }
    }
    try
    {
      System.load(paramString2);
      this.qoP.value = true;
      org.tensorflow.lite.a.a.ajZL.value = true;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
      h.OAn.kJ(1559, 37);
      break label58;
    }
    catch (Exception paramString1)
    {
      Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", paramString1, "", new Object[0]);
      h.OAn.kJ(1559, 37);
      break label58;
    }
    Log.i("MicroMsg.FinderRedDotConfig", "load tensorflow lite so [%b] cost[%d]", new Object[] { Boolean.valueOf(this.qoP.value), Long.valueOf(Util.ticksToNow(l)) });
    bool = this.qoP.value;
    AppMethodBeat.o(267447);
    return bool;
  }
  
  private int caB()
  {
    if (!this.qoO) {
      return -1;
    }
    return this.pos;
  }
  
  final void TR(String paramString)
  {
    AppMethodBeat.i(267467);
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
          this.qpd.add(str);
          i += 1;
        }
      }
    }
    Log.i("MicroMsg.FinderRedDotConfig", "parse no predict session id [%s]", new Object[] { paramString });
    AppMethodBeat.o(267467);
  }
  
  protected final boolean a(com.tencent.mm.plugin.ai.c.a.a parama, PString paramPString1, PString paramPString2, PString paramPString3)
  {
    int i = -1;
    AppMethodBeat.i(267514);
    if (!this.qoO)
    {
      AppMethodBeat.o(267514);
      return false;
    }
    paramPString3.value = "";
    paramPString2.value = "";
    paramPString1.value = "";
    for (;;)
    {
      try
      {
        Object localObject1 = new PString();
        Object localObject2 = this.qoQ;
        ((PString)localObject1).value = "";
        localObject2 = e.caH().TY((String)localObject2);
        boolean bool;
        if (Util.isNullOrNil((String)localObject2))
        {
          break label912;
          parama.l(this.qoQ, this.qoR, true);
          parama = "";
          bool = Util.isNullOrNil(parama);
          if (bool)
          {
            AppMethodBeat.o(267514);
            return false;
          }
        }
        else
        {
          if (!y.ZC((String)localObject2)) {
            break label912;
          }
          ((PString)localObject1).value = ((String)localObject2);
          i = 0;
          break label912;
          h.OAn.kJ(1559, 30);
          parama = ((PString)localObject1).value;
          continue;
        }
        if (org.tensorflow.lite.a.a.ajZL.value)
        {
          bool = true;
          if (!bool)
          {
            Log.w("MicroMsg.FinderRedDotConfig", "load tensorflow lite so error");
            y.ew(parama, true);
            AppMethodBeat.o(267514);
            return false;
          }
        }
        else
        {
          e.caH();
          localObject1 = u.V(MMApplicationContext.getContext().getDir("aimodel", 0));
          if ((!((u)localObject1).jKS()) && (!((u)localObject1).jKY()))
          {
            localObject1 = "";
            if (Util.isNullOrNil((String)localObject1))
            {
              h.OAn.kJ(1559, 31);
              bool = false;
            }
          }
          else
          {
            localObject1 = ah.v(((u)localObject1).jKT());
            continue;
          }
          Object localObject3 = D("libtensorflowlite_jni.so", this.qoS, (String)localObject1);
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3))
          {
            localObject2 = new PString();
            if ((com.tencent.mm.plugin.ai.c.a.a.a(this.qoS, "libtensorflowlite_jni.so", parama, (PString)localObject2) != 0) || (Util.isNullOrNil(((PString)localObject2).value)))
            {
              h.OAn.kJ(1559, 32);
              bool = false;
              continue;
            }
            localObject3 = E((String)localObject1, "libtensorflowlite_jni.so", ((PString)localObject2).value);
            localObject2 = localObject3;
            if (Util.isNullOrNil((String)localObject3))
            {
              h.OAn.kJ(1559, 33);
              bool = false;
              continue;
            }
          }
          String str = D("libtensorflowlite_flex_jni.so", this.qoT, (String)localObject1);
          localObject3 = str;
          if (Util.isNullOrNil(str))
          {
            localObject3 = new PString();
            if ((com.tencent.mm.plugin.ai.c.a.a.a(this.qoT, "libtensorflowlite_flex_jni.so", parama, (PString)localObject3) != 0) || (Util.isNullOrNil(((PString)localObject3).value)))
            {
              h.OAn.kJ(1559, 34);
              bool = false;
              continue;
            }
            localObject1 = E((String)localObject1, "libtensorflowlite_flex_jni.so", ((PString)localObject3).value);
            localObject3 = localObject1;
            if (Util.isNullOrNil((String)localObject1))
            {
              h.OAn.kJ(1559, 35);
              bool = false;
              continue;
            }
          }
          bool = cE((String)localObject2, (String)localObject3);
          continue;
        }
        localObject1 = new PString();
        switch (com.tencent.mm.plugin.ai.c.a.a.a(this.qoU, this.modelName, parama, (PString)localObject1))
        {
        case -1: 
          label584:
          paramPString1.value = ((PString)localObject1).value;
          if (!Util.isNullOrNil(paramPString1.value)) {
            break label671;
          }
          Log.w("MicroMsg.FinderRedDotConfig", "model file is null");
          y.ew(parama, true);
          AppMethodBeat.o(267514);
          return false;
        }
      }
      catch (Exception parama)
      {
        Log.printErrStackTrace("MicroMsg.FinderRedDotConfig", parama, "start to check error", new Object[0]);
        AppMethodBeat.o(267514);
        return false;
      }
      h.OAn.kJ(1559, 2);
      continue;
      h.OAn.kJ(1559, 1);
    }
    label671:
    paramPString1 = new PString();
    switch (com.tencent.mm.plugin.ai.c.a.a.a(this.qoW, this.qoV, parama, paramPString1))
    {
    case -1: 
    case 0: 
    case -2: 
      for (;;)
      {
        label720:
        paramPString2.value = paramPString1.value;
        if (!Util.isNullOrNil(paramPString2.value)) {
          break;
        }
        Log.w("MicroMsg.FinderRedDotConfig", "model Quantiles file is null");
        y.ew(parama, true);
        AppMethodBeat.o(267514);
        return false;
        h.OAn.kJ(1559, 39);
        continue;
        h.OAn.kJ(1559, 40);
      }
      paramPString1 = new PString();
      switch (com.tencent.mm.plugin.ai.c.a.a.a(this.qoY, this.qoX, parama, paramPString1))
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
        y.ew(parama, true);
        AppMethodBeat.o(267514);
        return false;
        h.OAn.kJ(1559, 41);
        continue;
        h.OAn.kJ(1559, 42);
      }
      else
      {
        AppMethodBeat.o(267514);
        return true;
        label912:
        switch (i)
        {
        }
        break;
        break label584;
        break label720;
      }
    }
  }
  
  protected final int caC()
  {
    if (!this.qoO) {
      return -1;
    }
    return this.qpe;
  }
  
  protected final int caD()
  {
    int i = -1;
    AppMethodBeat.i(267487);
    int k = caC();
    int j = caB();
    switch (k)
    {
    default: 
      i = j;
    }
    for (;;)
    {
      AppMethodBeat.o(267487);
      return i;
      i = caB();
      continue;
      k = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond());
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
    if ((this.qph == null) || (this.qph.value != k) || (this.qpg == null))
    {
      this.qph = new PInt(k);
      this.qpg = new PInt(-1);
      localHashSet = e.caH().qpp.caI();
      i = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 86400000L);
      k = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 172800000L);
      m = com.tencent.mm.plugin.ai.b.a.jx(Util.nowMilliSecond() - 259200000L);
      if ((localHashSet != null) && (!localHashSet.isEmpty())) {
        break label203;
      }
      this.qpg.value = 20;
    }
    for (;;)
    {
      i = this.qpg.value;
      break label69;
      label201:
      break;
      label203:
      if ((localHashSet.contains(Integer.valueOf(i))) && (localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m)))) {
        this.qpg.value = 6;
      } else if ((localHashSet.contains(Integer.valueOf(i))) && (localHashSet.contains(Integer.valueOf(k)))) {
        this.qpg.value = 8;
      } else if ((localHashSet.contains(Integer.valueOf(i))) && (localHashSet.contains(Integer.valueOf(m)))) {
        this.qpg.value = 10;
      } else if ((localHashSet.contains(Integer.valueOf(k))) && (localHashSet.contains(Integer.valueOf(m)))) {
        this.qpg.value = 12;
      } else if (localHashSet.contains(Integer.valueOf(i))) {
        this.qpg.value = 14;
      } else if (localHashSet.contains(Integer.valueOf(k))) {
        this.qpg.value = 16;
      } else if (localHashSet.contains(Integer.valueOf(m))) {
        this.qpg.value = 18;
      }
    }
  }
  
  protected final int caE()
  {
    if (!this.qoO) {}
    do
    {
      return -1;
      if (this.qoZ > 0) {
        return this.qoZ;
      }
    } while (this.qpa <= 0);
    return this.qpa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ai.service.b
 * JD-Core Version:    0.7.0.1
 */
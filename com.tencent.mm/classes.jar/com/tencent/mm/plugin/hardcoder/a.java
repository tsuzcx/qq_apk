package com.tencent.mm.plugin.hardcoder;

import android.util.Pair;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.hardcoder.f;
import com.tencent.mm.hardcoder.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public final class a
  implements i
{
  private static String ljr = null;
  private static Long ljs = null;
  public static boolean ljt = false;
  private c kum = new a.1(this);
  private ArrayList<Pair<Integer, Object[]>> lju = new ArrayList();
  private ArrayList<Object[]> ljv = new ArrayList();
  
  /* Error */
  private static void Fm(String paramString)
  {
    // Byte code:
    //   0: getstatic 27	com/tencent/mm/plugin/hardcoder/a:ljt	Z
    //   3: ifne +4 -> 7
    //   6: return
    //   7: new 51	java/lang/StringBuilder
    //   10: dup
    //   11: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   14: astore_1
    //   15: invokestatic 58	com/tencent/mm/kernel/g:DQ	()Lcom/tencent/mm/kernel/g;
    //   18: pop
    //   19: aload_1
    //   20: invokestatic 62	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   23: getfield 67	com/tencent/mm/kernel/e:dKs	Ljava/lang/String;
    //   26: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 73
    //   31: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore_1
    //   38: iconst_1
    //   39: anewarray 79	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: aload_1
    //   45: aastore
    //   46: invokestatic 85	com/tencent/mm/a/e:d	([Ljava/lang/String;)V
    //   49: new 87	java/io/File
    //   52: dup
    //   53: aload_1
    //   54: ldc 89
    //   56: invokespecial 92	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: astore_1
    //   60: aload_1
    //   61: invokevirtual 96	java/io/File:exists	()Z
    //   64: ifne +8 -> 72
    //   67: aload_1
    //   68: invokevirtual 99	java/io/File:createNewFile	()Z
    //   71: pop
    //   72: new 101	java/io/FileOutputStream
    //   75: dup
    //   76: aload_1
    //   77: iconst_1
    //   78: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   81: astore_2
    //   82: aload_2
    //   83: astore_1
    //   84: aload_2
    //   85: new 51	java/lang/StringBuilder
    //   88: dup
    //   89: invokespecial 52	java/lang/StringBuilder:<init>	()V
    //   92: aload_0
    //   93: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: ldc 106
    //   98: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: ldc 108
    //   106: invokevirtual 112	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   109: invokevirtual 118	java/io/OutputStream:write	([B)V
    //   112: aload_2
    //   113: astore_1
    //   114: aload_2
    //   115: invokevirtual 121	java/io/OutputStream:flush	()V
    //   118: aload_2
    //   119: invokevirtual 124	java/io/OutputStream:close	()V
    //   122: return
    //   123: astore_0
    //   124: ldc 126
    //   126: new 51	java/lang/StringBuilder
    //   129: dup
    //   130: ldc 128
    //   132: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   135: aload_0
    //   136: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   139: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   145: invokestatic 138	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: return
    //   149: astore_2
    //   150: ldc 126
    //   152: new 51	java/lang/StringBuilder
    //   155: dup
    //   156: ldc 140
    //   158: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   161: aload_2
    //   162: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: invokestatic 138	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -102 -> 72
    //   177: astore_3
    //   178: aconst_null
    //   179: astore_0
    //   180: aload_0
    //   181: astore_1
    //   182: ldc 126
    //   184: new 51	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 142
    //   190: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: aload_3
    //   194: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 138	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   206: aload_0
    //   207: ifnull -201 -> 6
    //   210: aload_0
    //   211: invokevirtual 124	java/io/OutputStream:close	()V
    //   214: return
    //   215: astore_0
    //   216: ldc 126
    //   218: new 51	java/lang/StringBuilder
    //   221: dup
    //   222: ldc 128
    //   224: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   227: aload_0
    //   228: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   231: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 138	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: return
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_1
    //   244: aload_1
    //   245: ifnull +7 -> 252
    //   248: aload_1
    //   249: invokevirtual 124	java/io/OutputStream:close	()V
    //   252: aload_0
    //   253: athrow
    //   254: astore_1
    //   255: ldc 126
    //   257: new 51	java/lang/StringBuilder
    //   260: dup
    //   261: ldc 128
    //   263: invokespecial 130	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   266: aload_1
    //   267: invokevirtual 133	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   270: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: invokestatic 138	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   279: goto -27 -> 252
    //   282: astore_0
    //   283: goto -39 -> 244
    //   286: astore_3
    //   287: aload_2
    //   288: astore_0
    //   289: goto -109 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	paramString	String
    //   14	235	1	localObject	Object
    //   254	13	1	localException1	java.lang.Exception
    //   81	38	2	localFileOutputStream	java.io.FileOutputStream
    //   149	139	2	localException2	java.lang.Exception
    //   177	17	3	localException3	java.lang.Exception
    //   286	1	3	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   118	122	123	java/lang/Exception
    //   67	72	149	java/lang/Exception
    //   72	82	177	java/lang/Exception
    //   210	214	215	java/lang/Exception
    //   72	82	241	finally
    //   248	252	254	java/lang/Exception
    //   84	112	282	finally
    //   114	118	282	finally
    //   182	206	282	finally
    //   84	112	286	java/lang/Exception
    //   114	118	286	java/lang/Exception
  }
  
  private void f(int paramInt, Object... paramVarArgs)
  {
    if (com.tencent.mm.kernel.g.DN().dJH)
    {
      h.nFQ.f(paramInt, paramVarArgs);
      return;
    }
    y.w("MicroMsg.HardCoderReporterImpl", "kvStat accountNotInitialReady!");
    this.kum.cqo();
    this.lju.add(new Pair(Integer.valueOf(paramInt), paramVarArgs));
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, long paramLong1, int paramInt6, int paramInt7, int[] paramArrayOfInt1, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, long paramLong2, int[] paramArrayOfInt2, int[] paramArrayOfInt3)
  {
    if ((y.getLogLevel() > 1) && (!WXHardCoderJNI.hcKVPerReport)) {
      return;
    }
    if (WXHardCoderJNI.isHCEnable()) {}
    String str;
    int n;
    int k;
    int j;
    int m;
    for (int i = 1;; i = 0)
    {
      if (ljs == null)
      {
        com.tencent.mm.kernel.g.DQ();
        ljs = (Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uuZ, Long.valueOf(0L));
      }
      if (ljr == null) {
        ljr = bk.fP(ae.getContext());
      }
      str = ljr;
      n = (int)ljs.longValue();
      localObject1 = new StringBuilder();
      if (paramArrayOfInt1 == null) {
        break;
      }
      k = paramArrayOfInt1.length;
      j = 0;
      while (j < k)
      {
        m = paramArrayOfInt1[j];
        ((StringBuilder)localObject1).append(m + "#");
        j += 1;
      }
    }
    paramArrayOfInt1 = new StringBuilder();
    int i1;
    if (paramArrayOfInt2 != null)
    {
      i1 = paramArrayOfInt2.length;
      j = 0;
      while (j < i1)
      {
        m = paramArrayOfInt2[j];
        localObject2 = new StringBuilder();
        k = m;
        if (m < 0) {
          k = 0;
        }
        paramArrayOfInt1.append(k + "#");
        j += 1;
      }
    }
    paramArrayOfInt2 = new StringBuilder();
    if (paramArrayOfInt3 != null)
    {
      i1 = paramArrayOfInt3.length;
      j = 0;
      while (j < i1)
      {
        m = paramArrayOfInt3[j];
        localObject2 = new StringBuilder();
        k = m;
        if (m < 0) {
          k = 0;
        }
        paramArrayOfInt2.append(k + "#");
        j += 1;
      }
    }
    Object localObject2 = String.format("[oneliang]performance report,imei:%s,threadId:%s,enable:%s, heavy:%s,speedUp:%s,engineStatus:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[] { str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong1), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), ((StringBuilder)localObject1).toString(), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), Integer.valueOf(paramInt10), Integer.valueOf(paramInt11), Integer.valueOf(paramInt12), Long.valueOf(paramLong2), paramArrayOfInt1.toString(), paramArrayOfInt2.toString() });
    paramArrayOfInt3 = String.format("time:%s,imei:%s,threadId:%s,enable:%s,heavy:%s,speedUp:%s,cancelInDelay:%s,scene:%s,action:%s,cpuLevel:%s,ioLevel:%s,bindCoreIds:%s,executeTime:%s,runtime:%s,threadJiffies:%s, phonePower:%s, phoneHZ:%s, processJiffies:%s,cpuLevelTimeArray:%s, ioLevelTimeArray:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), str, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong1), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), ((StringBuilder)localObject1).toString(), Integer.valueOf(paramInt8), Integer.valueOf(paramInt9), Integer.valueOf(paramInt10), Integer.valueOf(paramInt11), Integer.valueOf(paramInt12), Long.valueOf(paramLong2), paramArrayOfInt1.toString(), paramArrayOfInt2.toString() });
    if (WXHardCoderJNI.getDebug()) {
      y.i("MicroMsg.HardCoderReporterImpl", (String)localObject2);
    }
    Object localObject1 = ((StringBuilder)localObject1).toString();
    paramInt1 = paramInt8;
    if (paramInt8 < 0) {
      paramInt1 = 0;
    }
    f(14607, new Object[] { str, Integer.valueOf(n), Integer.valueOf(i), Integer.valueOf(paramInt4), Integer.valueOf(paramInt5), Long.valueOf(paramLong1), Integer.valueOf(paramInt6), Integer.valueOf(paramInt7), localObject1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt9), Integer.valueOf(paramInt10), Integer.valueOf(paramInt11), Integer.valueOf(paramInt12), Long.valueOf(paramLong2), paramArrayOfInt1.toString(), paramArrayOfInt2.toString(), "", Integer.valueOf(0), Integer.valueOf(paramInt3), Integer.valueOf(paramInt2) });
    Fm(paramArrayOfInt3);
  }
  
  public final void a(int paramInt1, long paramLong, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ljr == null) {
      ljr = bk.fP(ae.getContext());
    }
    String str1 = ljr;
    long l = paramLong;
    if (paramLong <= 0L) {
      l = System.currentTimeMillis();
    }
    String str2 = String.format("errorReport imei:%s,callbackType:%s,errorTimestamp:%s,errCode:%s,funcId:%s,dataType:%s", new Object[] { str1, Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    String str3 = String.format("time:%s,imei:%s,callbackType:%s,errorTimestamp:%s,errCode:%s,funcId:%s,dataType:%s", new Object[] { Long.valueOf(System.currentTimeMillis()), str1, Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    y.i("MicroMsg.HardCoderReporterImpl", str2);
    f(14610, new Object[] { str1, Integer.valueOf(paramInt1), Long.valueOf(l), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    Fm(str3);
  }
  
  public final void reportInfo(com.tencent.mm.hardcoder.e parame)
  {
    long l1;
    long l2;
    long l3;
    boolean bool;
    if ((parame instanceof com.tencent.mm.hardcoder.g))
    {
      parame = (com.tencent.mm.hardcoder.g)parame;
      y.i("MicroMsg.HardCoderReporterImpl", "reportIDKey feature[%b] key[%d], value[%d]", new Object[] { Boolean.valueOf(parame.dFg), Integer.valueOf(parame.key), Integer.valueOf(parame.value), Boolean.valueOf(parame.bZO) });
      if (parame.dFg)
      {
        l1 = 678L;
        l2 = parame.key;
        l3 = parame.value;
        bool = parame.bZO;
        if (!com.tencent.mm.kernel.g.DN().dJH) {
          break label128;
        }
        h.nFQ.a(l1, l2, l3, bool);
      }
    }
    label128:
    label536:
    label539:
    for (;;)
    {
      return;
      l1 = 679L;
      break;
      y.w("MicroMsg.HardCoderReporterImpl", "idkeyStat accountNotInitialReady!");
      this.kum.cqo();
      this.ljv.add(new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Boolean.valueOf(bool) });
      return;
      if ((parame instanceof f))
      {
        parame = (f)parame;
        if (ljs == null)
        {
          com.tencent.mm.kernel.g.DQ();
          ljs = (Long)com.tencent.mm.kernel.g.DP().Dz().get(ac.a.uuZ, Long.valueOf(0L));
        }
        if (ljr == null) {
          ljr = bk.fP(ae.getContext());
        }
        String str = ljr;
        int k = (int)ljs.longValue();
        int i;
        int m;
        if (WXHardCoderJNI.isHCEnable())
        {
          i = 1;
          m = WXHardCoderJNI.isRunning();
          if (!WXHardCoderJNI.getEnable()) {
            break label536;
          }
        }
        for (int j = 1;; j = 0)
        {
          if (parame.type != 1) {
            break label539;
          }
          l1 = parame.dFe * 100L / parame.dFf;
          f(15187, new Object[] { str, Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(parame.scene), Long.valueOf(parame.dEo), Integer.valueOf(parame.type), Long.valueOf(parame.dFe), Long.valueOf(parame.dFf), Long.valueOf(l1), Integer.valueOf(j) });
          y.i("MicroMsg.HardCoderReporterImpl", String.format("fpsReport imei:%s enable:%s, heavy:%s speedUp:%s, engineStatus:%s, scene:%s, action:%s, type:%s, totalDroppedFrames:%s, interval:%s, average:%s", new Object[] { str, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), Integer.valueOf(m), Integer.valueOf(parame.scene), Long.valueOf(parame.dEo), Integer.valueOf(parame.type), Long.valueOf(parame.dFe), Long.valueOf(parame.dFf), Long.valueOf(l1) }));
          return;
          i = 0;
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.hardcoder.a
 * JD-Core Version:    0.7.0.1
 */
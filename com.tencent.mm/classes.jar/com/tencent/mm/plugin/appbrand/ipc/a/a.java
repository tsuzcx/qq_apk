package com.tencent.mm.plugin.appbrand.ipc.a;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ipc/util/IpcBigDataTransfer;", "", "()V", "BUFF_MAX_LIMIT", "", "CLEAN_CHECK_INTERVAL", "", "MMKV_FILE_DANGER_SIZE", "MMKV_NANE", "", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "get", "", "key", "clear", "", "save", "Lkotlin/Pair;", "data", "tryCleanInvalidData", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final MultiProcessMMKV eMf;
  public static final a rvP;
  private static final long rvQ;
  
  static
  {
    AppMethodBeat.i(319427);
    rvP = new a();
    rvQ = TimeUnit.DAYS.toMillis(1L);
    eMf = MultiProcessMMKV.getMMKV("jsapi_ipc_big_data_transfer");
    AppMethodBeat.o(319427);
  }
  
  public static byte[] ZI(String paramString)
  {
    AppMethodBeat.i(319419);
    s.u(paramString, "key");
    byte[] arrayOfByte = eMf.decodeBytes(paramString);
    eMf.remove(paramString);
    s.s(arrayOfByte, "mmkv.decodeBytes(key).al…mkv.remove(key)\n        }");
    AppMethodBeat.o(319419);
    return arrayOfByte;
  }
  
  public static r<Boolean, String> aT(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(319418);
    s.u(paramArrayOfByte, "data");
    if (paramArrayOfByte.length >= 102400)
    {
      String str = SystemClock.elapsedRealtimeNanos();
      eMf.encode(str, paramArrayOfByte);
      paramArrayOfByte = new r(Boolean.TRUE, str);
      AppMethodBeat.o(319418);
      return paramArrayOfByte;
    }
    paramArrayOfByte = new r(Boolean.FALSE, "");
    AppMethodBeat.o(319418);
    return paramArrayOfByte;
  }
  
  public static void cpC()
  {
    AppMethodBeat.i(319423);
    h.ahAA.bm(a..ExternalSyntheticLambda0.INSTANCE);
    AppMethodBeat.o(319423);
  }
  
  /* Error */
  private static final void cpD()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_0
    //   2: ldc 169
    //   4: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: invokestatic 175	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   10: invokevirtual 181	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   13: getstatic 187	com/tencent/mm/storage/at$a:acOo	Lcom/tencent/mm/storage/at$a;
    //   16: lconst_0
    //   17: invokevirtual 193	com/tencent/mm/storage/aq:a	(Lcom/tencent/mm/storage/at$a;J)J
    //   20: lstore_1
    //   21: getstatic 72	com/tencent/mm/plugin/appbrand/ipc/a/a:rvQ	J
    //   24: lstore_3
    //   25: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   28: lstore 5
    //   30: lload_1
    //   31: lload_3
    //   32: ladd
    //   33: lload 5
    //   35: lcmp
    //   36: ifgt +117 -> 153
    //   39: getstatic 82	com/tencent/mm/plugin/appbrand/ipc/a/a:eMf	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   42: invokevirtual 201	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:totalSize	()J
    //   45: ldc2_w 202
    //   48: lcmp
    //   49: iflt +55 -> 104
    //   52: ldc 205
    //   54: ldc 207
    //   56: iconst_1
    //   57: anewarray 4	java/lang/Object
    //   60: dup
    //   61: iconst_0
    //   62: iload_0
    //   63: invokestatic 211	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   66: aastore
    //   67: invokestatic 216	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   70: iload_0
    //   71: ifeq +9 -> 80
    //   74: getstatic 82	com/tencent/mm/plugin/appbrand/ipc/a/a:eMf	Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   77: invokevirtual 219	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:clearAll	()V
    //   80: invokestatic 175	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   83: invokevirtual 181	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   86: getstatic 187	com/tencent/mm/storage/at$a:acOo	Lcom/tencent/mm/storage/at$a;
    //   89: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   92: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   95: invokevirtual 228	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   98: ldc 169
    //   100: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: return
    //   104: iconst_0
    //   105: istore_0
    //   106: goto -54 -> 52
    //   109: astore 7
    //   111: ldc 205
    //   113: ldc 230
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: aload 7
    //   123: aastore
    //   124: invokestatic 233	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: invokestatic 175	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   130: invokevirtual 181	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   133: getstatic 187	com/tencent/mm/storage/at$a:acOo	Lcom/tencent/mm/storage/at$a;
    //   136: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   139: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   142: invokevirtual 228	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   145: ldc 169
    //   147: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: astore 7
    //   153: ldc 169
    //   155: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore 7
    //   161: invokestatic 175	com/tencent/mm/kernel/h:baE	()Lcom/tencent/mm/kernel/f;
    //   164: invokevirtual 181	com/tencent/mm/kernel/f:ban	()Lcom/tencent/mm/storage/aq;
    //   167: getstatic 187	com/tencent/mm/storage/at$a:acOo	Lcom/tencent/mm/storage/at$a;
    //   170: invokestatic 198	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
    //   173: invokestatic 224	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   176: invokevirtual 228	com/tencent/mm/storage/aq:set	(Lcom/tencent/mm/storage/at$a;Ljava/lang/Object;)V
    //   179: ldc 169
    //   181: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   184: aload 7
    //   186: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   1	105	0	bool	boolean
    //   20	11	1	l1	long
    //   24	8	3	l2	long
    //   28	6	5	l3	long
    //   109	13	7	localObject1	Object
    //   151	1	7	localObject2	Object
    //   159	26	7	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   39	52	109	finally
    //   52	70	109	finally
    //   74	80	109	finally
    //   7	30	151	finally
    //   80	103	151	finally
    //   127	150	151	finally
    //   161	187	151	finally
    //   111	127	159	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.a.a
 * JD-Core Version:    0.7.0.1
 */
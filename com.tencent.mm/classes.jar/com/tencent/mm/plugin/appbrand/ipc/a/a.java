package com.tencent.mm.plugin.appbrand.ipc.a;

import android.os.SystemClock;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/ipc/util/IpcBigDataTransfer;", "", "()V", "BUFF_MAX_LIMIT", "", "CLEAN_CHECK_INTERVAL", "", "MMKV_FILE_DANGER_SIZE", "MMKV_NANE", "", "TAG", "mmkv", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "get", "", "key", "clear", "", "save", "Lkotlin/Pair;", "data", "tryCleanInvalidData", "", "plugin-appbrand-integration_release"})
public final class a
{
  private static final MultiProcessMMKV cQe;
  private static final long lxd;
  public static final a lxe;
  
  static
  {
    AppMethodBeat.i(228227);
    lxe = new a();
    lxd = TimeUnit.DAYS.toMillis(1L);
    cQe = MultiProcessMMKV.getMMKV("jsapi_ipc_big_data_transfer");
    AppMethodBeat.o(228227);
  }
  
  public static byte[] Za(String paramString)
  {
    AppMethodBeat.i(228225);
    p.h(paramString, "key");
    byte[] arrayOfByte = cQe.decodeBytes(paramString);
    cQe.remove(paramString);
    p.g(arrayOfByte, "mmkv.decodeBytes(key).al…mkv.remove(key)\n        }");
    AppMethodBeat.o(228225);
    return arrayOfByte;
  }
  
  public static o<Boolean, String> aH(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(228224);
    p.h(paramArrayOfByte, "data");
    if (paramArrayOfByte.length >= 102400)
    {
      String str = String.valueOf(SystemClock.elapsedRealtimeNanos());
      cQe.encode(str, paramArrayOfByte);
      paramArrayOfByte = new o(Boolean.TRUE, str);
      AppMethodBeat.o(228224);
      return paramArrayOfByte;
    }
    paramArrayOfByte = new o(Boolean.FALSE, "");
    AppMethodBeat.o(228224);
    return paramArrayOfByte;
  }
  
  public static void bDV()
  {
    AppMethodBeat.i(228226);
    h.RTc.aX((Runnable)a.lxf);
    AppMethodBeat.o(228226);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    public static final a lxf;
    
    static
    {
      AppMethodBeat.i(228223);
      lxf = new a();
      AppMethodBeat.o(228223);
    }
    
    /* Error */
    public final void run()
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore_1
      //   2: ldc 44
      //   4: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   7: invokestatic 50	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
      //   10: astore 8
      //   12: aload 8
      //   14: ldc 52
      //   16: invokestatic 58	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   19: aload 8
      //   21: invokevirtual 64	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
      //   24: getstatic 70	com/tencent/mm/storage/ar$a:NYT	Lcom/tencent/mm/storage/ar$a;
      //   27: lconst_0
      //   28: invokevirtual 76	com/tencent/mm/storage/ao:a	(Lcom/tencent/mm/storage/ar$a;J)J
      //   31: lstore_2
      //   32: getstatic 80	com/tencent/mm/plugin/appbrand/ipc/a/a:lxe	Lcom/tencent/mm/plugin/appbrand/ipc/a/a;
      //   35: astore 8
      //   37: invokestatic 84	com/tencent/mm/plugin/appbrand/ipc/a/a:bDW	()J
      //   40: lstore 4
      //   42: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   45: lstore 6
      //   47: lload_2
      //   48: lload 4
      //   50: ladd
      //   51: lload 6
      //   53: lcmp
      //   54: ifgt +149 -> 203
      //   57: getstatic 80	com/tencent/mm/plugin/appbrand/ipc/a/a:lxe	Lcom/tencent/mm/plugin/appbrand/ipc/a/a;
      //   60: astore 8
      //   62: invokestatic 93	com/tencent/mm/plugin/appbrand/ipc/a/a:bDX	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
      //   65: invokevirtual 98	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:totalSize	()J
      //   68: ldc2_w 99
      //   71: lcmp
      //   72: iflt +71 -> 143
      //   75: ldc 102
      //   77: ldc 104
      //   79: iconst_1
      //   80: anewarray 4	java/lang/Object
      //   83: dup
      //   84: iconst_0
      //   85: iload_1
      //   86: invokestatic 110	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
      //   89: aastore
      //   90: invokestatic 115	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   93: iload_1
      //   94: ifeq +14 -> 108
      //   97: getstatic 80	com/tencent/mm/plugin/appbrand/ipc/a/a:lxe	Lcom/tencent/mm/plugin/appbrand/ipc/a/a;
      //   100: astore 8
      //   102: invokestatic 93	com/tencent/mm/plugin/appbrand/ipc/a/a:bDX	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
      //   105: invokevirtual 118	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:clearAll	()V
      //   108: invokestatic 50	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
      //   111: astore 8
      //   113: aload 8
      //   115: ldc 52
      //   117: invokestatic 58	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   120: aload 8
      //   122: invokevirtual 64	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
      //   125: getstatic 70	com/tencent/mm/storage/ar$a:NYT	Lcom/tencent/mm/storage/ar$a;
      //   128: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   131: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   134: invokevirtual 127	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
      //   137: ldc 44
      //   139: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: return
      //   143: iconst_0
      //   144: istore_1
      //   145: goto -70 -> 75
      //   148: astore 8
      //   150: ldc 102
      //   152: ldc 129
      //   154: iconst_1
      //   155: anewarray 4	java/lang/Object
      //   158: dup
      //   159: iconst_0
      //   160: aload 8
      //   162: aastore
      //   163: invokestatic 132	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   166: invokestatic 50	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
      //   169: astore 8
      //   171: aload 8
      //   173: ldc 52
      //   175: invokestatic 58	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   178: aload 8
      //   180: invokevirtual 64	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
      //   183: getstatic 70	com/tencent/mm/storage/ar$a:NYT	Lcom/tencent/mm/storage/ar$a;
      //   186: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   189: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   192: invokevirtual 127	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
      //   195: ldc 44
      //   197: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   200: return
      //   201: astore 8
      //   203: ldc 44
      //   205: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   208: return
      //   209: astore 8
      //   211: invokestatic 50	com/tencent/mm/kernel/g:aAh	()Lcom/tencent/mm/kernel/e;
      //   214: astore 9
      //   216: aload 9
      //   218: ldc 52
      //   220: invokestatic 58	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
      //   223: aload 9
      //   225: invokevirtual 64	com/tencent/mm/kernel/e:azQ	()Lcom/tencent/mm/storage/ao;
      //   228: getstatic 70	com/tencent/mm/storage/ar$a:NYT	Lcom/tencent/mm/storage/ar$a;
      //   231: invokestatic 89	com/tencent/mm/sdk/platformtools/Util:nowMilliSecond	()J
      //   234: invokestatic 123	java/lang/Long:valueOf	(J)Ljava/lang/Long;
      //   237: invokevirtual 127	com/tencent/mm/storage/ao:set	(Lcom/tencent/mm/storage/ar$a;Ljava/lang/Object;)V
      //   240: ldc 44
      //   242: invokestatic 39	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   245: aload 8
      //   247: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	248	0	this	a
      //   1	144	1	bool	boolean
      //   31	17	2	l1	long
      //   40	9	4	l2	long
      //   45	7	6	l3	long
      //   10	111	8	localObject1	Object
      //   148	13	8	localThrowable1	java.lang.Throwable
      //   169	10	8	locale1	com.tencent.mm.kernel.e
      //   201	1	8	localThrowable2	java.lang.Throwable
      //   209	37	8	localObject2	Object
      //   214	10	9	locale2	com.tencent.mm.kernel.e
      // Exception table:
      //   from	to	target	type
      //   57	75	148	java/lang/Throwable
      //   75	93	148	java/lang/Throwable
      //   97	108	148	java/lang/Throwable
      //   7	47	201	java/lang/Throwable
      //   108	142	201	java/lang/Throwable
      //   166	200	201	java/lang/Throwable
      //   211	248	201	java/lang/Throwable
      //   57	75	209	finally
      //   75	93	209	finally
      //   97	108	209	finally
      //   150	166	209	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ipc.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.device_discovery.bluetooth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.device_discovery.a;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/RetryDelayMillsResolver;", "", "()V", "backoffFactor", "", "reset", "", "resolve", "", "updateBackoffFactor", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class q
{
  public static final a rhr;
  private int rhs = 1;
  
  static
  {
    AppMethodBeat.i(321626);
    rhr = new a((byte)0);
    AppMethodBeat.o(321626);
  }
  
  /* Error */
  public final long cmQ()
  {
    // Byte code:
    //   0: ldc 55
    //   2: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   11: istore_1
    //   12: aload_0
    //   13: monitorexit
    //   14: ldc2_w 56
    //   17: ldc2_w 58
    //   20: iload_1
    //   21: iconst_1
    //   22: isub
    //   23: i2d
    //   24: invokestatic 65	java/lang/Math:pow	(DD)D
    //   27: d2f
    //   28: f2i
    //   29: i2l
    //   30: lmul
    //   31: lstore_3
    //   32: getstatic 71	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   35: astore 5
    //   37: ldc 73
    //   39: new 75	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 77
    //   45: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: iload_1
    //   49: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   52: ldc 86
    //   54: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: lload_3
    //   58: invokevirtual 92	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   61: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 99	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   67: aload_0
    //   68: monitorenter
    //   69: aload_0
    //   70: getfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   73: istore_1
    //   74: aload_0
    //   75: aload_0
    //   76: getfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   79: iconst_1
    //   80: iadd
    //   81: putfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   84: bipush 10
    //   86: aload_0
    //   87: getfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   90: if_icmpge +8 -> 98
    //   93: aload_0
    //   94: iconst_1
    //   95: putfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   98: aload_0
    //   99: getfield 52	com/tencent/mm/plugin/appbrand/device_discovery/bluetooth/q:rhs	I
    //   102: istore_2
    //   103: getstatic 105	kotlin/ah:aiuX	Lkotlin/ah;
    //   106: astore 5
    //   108: aload_0
    //   109: monitorexit
    //   110: getstatic 71	com/tencent/mm/plugin/appbrand/device_discovery/a:rfZ	Lcom/tencent/mm/plugin/appbrand/device_discovery/a;
    //   113: astore 5
    //   115: ldc 73
    //   117: new 75	java/lang/StringBuilder
    //   120: dup
    //   121: ldc 107
    //   123: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   126: iload_1
    //   127: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   130: ldc 109
    //   132: invokevirtual 89	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: iload_2
    //   136: invokevirtual 84	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   139: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 99	com/tencent/mm/plugin/appbrand/device_discovery/a:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: ldc 55
    //   147: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: lload_3
    //   151: lreturn
    //   152: astore 5
    //   154: aload_0
    //   155: monitorexit
    //   156: ldc 55
    //   158: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aload 5
    //   163: athrow
    //   164: astore 5
    //   166: aload_0
    //   167: monitorexit
    //   168: ldc 55
    //   170: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   173: aload 5
    //   175: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	176	0	this	q
    //   11	116	1	i	int
    //   102	34	2	j	int
    //   31	120	3	l	long
    //   35	79	5	localObject1	Object
    //   152	10	5	localObject2	Object
    //   164	10	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   7	12	152	finally
    //   69	98	164	finally
    //   98	108	164	finally
  }
  
  public final void reset()
  {
    AppMethodBeat.i(321650);
    Object localObject1 = a.rfZ;
    a.i("MicroMsg.AppBrand.AutoConnectGattRetryStrategy", "reset#RetryDelayMillsResolver");
    try
    {
      this.rhs = 1;
      localObject1 = ah.aiuX;
      return;
    }
    finally
    {
      AppMethodBeat.o(321650);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/device_discovery/bluetooth/RetryDelayMillsResolver$Companion;", "", "()V", "MAX_EXPONENTIAL_BACKOFF_TIMES", "", "RETRY_DELAY_UNIT_MILLS", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.device_discovery.bluetooth.q
 * JD-Core Version:    0.7.0.1
 */
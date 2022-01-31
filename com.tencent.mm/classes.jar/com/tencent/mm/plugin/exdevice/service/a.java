package com.tencent.mm.plugin.exdevice.service;

import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements r
{
  private static a lHY = null;
  private Object ceY;
  private final HashMap<Long, Long> lHZ;
  private g lIa;
  ak mHandler;
  
  public a(g paramg)
  {
    AppMethodBeat.i(19522);
    this.lHZ = new HashMap();
    this.lIa = null;
    this.mHandler = new a.a(this, v.bqB().fPW.oNc.getLooper());
    this.ceY = new Object();
    this.lIa = paramg;
    lHY = this;
    AppMethodBeat.o(19522);
  }
  
  /* Error */
  private int a(long paramLong, p paramp)
  {
    // Byte code:
    //   0: sipush 19526
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 92
    //   8: ldc 94
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_3
    //   25: invokestatic 111	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   28: aload_3
    //   29: invokeinterface 117 1 0
    //   34: invokeinterface 123 1 0
    //   39: lstore 5
    //   41: ldc 125
    //   43: lload 5
    //   45: invokestatic 131	com/tencent/mm/plugin/exdevice/h/a:K	(Ljava/lang/String;J)Z
    //   48: ifne +125 -> 173
    //   51: ldc 92
    //   53: ldc 133
    //   55: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 16	com/tencent/mm/plugin/exdevice/service/a$e
    //   61: dup
    //   62: invokespecial 138	com/tencent/mm/plugin/exdevice/service/a$e:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: lload_1
    //   68: putfield 142	com/tencent/mm/plugin/exdevice/service/a$e:lIf	J
    //   71: aload_3
    //   72: iconst_m1
    //   73: putfield 146	com/tencent/mm/plugin/exdevice/service/a$e:lCs	I
    //   76: aload_3
    //   77: iconst_m1
    //   78: putfield 149	com/tencent/mm/plugin/exdevice/service/a$e:lCE	I
    //   81: aload_3
    //   82: ldc 151
    //   84: putfield 155	com/tencent/mm/plugin/exdevice/service/a$e:hyJ	Ljava/lang/String;
    //   87: getstatic 36	com/tencent/mm/plugin/exdevice/service/a:lHY	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   90: getfield 81	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/ak;
    //   93: getstatic 36	com/tencent/mm/plugin/exdevice/service/a:lHY	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   96: getfield 81	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/ak;
    //   99: iconst_3
    //   100: iconst_0
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 161	com/tencent/mm/sdk/platformtools/ak:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   106: invokevirtual 165	com/tencent/mm/sdk/platformtools/ak:sendMessage	(Landroid/os/Message;)Z
    //   109: invokestatic 169	junit/framework/Assert:assertTrue	(Z)V
    //   112: sipush 19526
    //   115: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_m1
    //   119: ireturn
    //   120: astore_3
    //   121: ldc 92
    //   123: ldc 171
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_3
    //   132: invokevirtual 175	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: ldc 92
    //   141: aload_3
    //   142: ldc 180
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 184	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 54	com/tencent/mm/plugin/exdevice/service/a:lIa	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   155: lload_1
    //   156: iconst_m1
    //   157: iconst_m1
    //   158: ldc 186
    //   160: invokeinterface 192 6 0
    //   165: sipush 19526
    //   168: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_m1
    //   172: ireturn
    //   173: aload_0
    //   174: getfield 52	com/tencent/mm/plugin/exdevice/service/a:lHZ	Ljava/util/HashMap;
    //   177: lload 5
    //   179: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: invokevirtual 196	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   185: ifne +44 -> 229
    //   188: ldc 92
    //   190: ldc 198
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: lload 5
    //   200: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   203: aastore
    //   204: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload_0
    //   208: getfield 54	com/tencent/mm/plugin/exdevice/service/a:lIa	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   211: lload_1
    //   212: iconst_m1
    //   213: iconst_m1
    //   214: ldc 200
    //   216: invokeinterface 192 6 0
    //   221: sipush 19526
    //   224: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: iconst_m1
    //   228: ireturn
    //   229: new 202	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd
    //   232: dup
    //   233: invokespecial 203	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:<init>	()V
    //   236: astore 7
    //   238: aload 7
    //   240: aload_0
    //   241: getfield 52	com/tencent/mm/plugin/exdevice/service/a:lHZ	Ljava/util/HashMap;
    //   244: lload 5
    //   246: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: invokevirtual 207	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   252: checkcast 96	java/lang/Long
    //   255: invokevirtual 210	java/lang/Long:longValue	()J
    //   258: putfield 213	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   261: aload 7
    //   263: aload_3
    //   264: invokeinterface 117 1 0
    //   269: invokeinterface 217 1 0
    //   274: putfield 220	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   277: aload 7
    //   279: aload_3
    //   280: invokeinterface 117 1 0
    //   285: invokeinterface 223 1 0
    //   290: putfield 226	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   293: aload_3
    //   294: invokeinterface 117 1 0
    //   299: invokeinterface 230 1 0
    //   304: astore 8
    //   306: aload_3
    //   307: invokeinterface 117 1 0
    //   312: invokeinterface 233 1 0
    //   317: istore 4
    //   319: lload_1
    //   320: iload 4
    //   322: i2s
    //   323: aload 7
    //   325: aload 8
    //   327: invokestatic 239	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice:startTask	(JSLcom/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd;[B)I
    //   330: ifeq +124 -> 454
    //   333: ldc 92
    //   335: ldc 241
    //   337: invokestatic 243	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: sipush 19526
    //   343: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: iconst_m1
    //   347: ireturn
    //   348: astore_3
    //   349: ldc 92
    //   351: ldc 245
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload_3
    //   360: invokevirtual 175	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   363: aastore
    //   364: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: ldc 92
    //   369: aload_3
    //   370: ldc 180
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 184	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: aload_0
    //   380: getfield 54	com/tencent/mm/plugin/exdevice/service/a:lIa	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   383: lload_1
    //   384: iconst_m1
    //   385: iconst_m1
    //   386: ldc 247
    //   388: invokeinterface 192 6 0
    //   393: sipush 19526
    //   396: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: iconst_m1
    //   400: ireturn
    //   401: astore_3
    //   402: ldc 92
    //   404: ldc 249
    //   406: iconst_1
    //   407: anewarray 4	java/lang/Object
    //   410: dup
    //   411: iconst_0
    //   412: aload_3
    //   413: invokevirtual 175	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   416: aastore
    //   417: invokestatic 178	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   420: ldc 92
    //   422: aload_3
    //   423: ldc 180
    //   425: iconst_0
    //   426: anewarray 4	java/lang/Object
    //   429: invokestatic 184	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   432: aload_0
    //   433: getfield 54	com/tencent/mm/plugin/exdevice/service/a:lIa	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   436: lload_1
    //   437: iconst_m1
    //   438: iconst_m1
    //   439: ldc 251
    //   441: invokeinterface 192 6 0
    //   446: sipush 19526
    //   449: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   452: iconst_m1
    //   453: ireturn
    //   454: ldc 92
    //   456: ldc 253
    //   458: bipush 6
    //   460: anewarray 4	java/lang/Object
    //   463: dup
    //   464: iconst_0
    //   465: lload_1
    //   466: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   469: aastore
    //   470: dup
    //   471: iconst_1
    //   472: lload 5
    //   474: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   477: aastore
    //   478: dup
    //   479: iconst_2
    //   480: aload 7
    //   482: getfield 213	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   485: invokestatic 100	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   488: aastore
    //   489: dup
    //   490: iconst_3
    //   491: iload 4
    //   493: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   496: aastore
    //   497: dup
    //   498: iconst_4
    //   499: aload 7
    //   501: getfield 220	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   504: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   507: aastore
    //   508: dup
    //   509: iconst_5
    //   510: aload 7
    //   512: getfield 226	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   515: invokestatic 258	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   518: aastore
    //   519: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   522: sipush 19526
    //   525: invokestatic 86	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   528: iconst_0
    //   529: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	530	0	this	a
    //   0	530	1	paramLong	long
    //   0	530	3	paramp	p
    //   317	175	4	i	int
    //   39	434	5	l	long
    //   236	275	7	localAccessoryCmd	com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd
    //   304	22	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	41	120	android/os/RemoteException
    //   261	293	348	android/os/RemoteException
    //   293	319	401	android/os/RemoteException
  }
  
  public static void b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(19528);
    Assert.assertNotNull(lHY);
    ab.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + paramLong + " oldState = " + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    paramLong = lHY.jh(paramLong);
    if (-1L == paramLong)
    {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      AppMethodBeat.o(19528);
      return;
    }
    a.d locald = new a.d((byte)0);
    locald.jRn = paramLong;
    locald.lCs = paramInt3;
    locald.lIe = paramInt2;
    locald.lId = paramInt1;
    Assert.assertTrue(lHY.mHandler.sendMessage(lHY.mHandler.obtainMessage(4, 0, 0, locald)));
    AppMethodBeat.o(19528);
  }
  
  public static long[] bqn()
  {
    AppMethodBeat.i(19524);
    long[] arrayOfLong = com.tencent.mm.plugin.exdevice.h.a.LG("conneted_device");
    AppMethodBeat.o(19524);
    return arrayOfLong;
  }
  
  public static void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(19527);
    Assert.assertNotNull(lHY);
    ab.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + paramLong + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    a.e locale = new a.e();
    locale.lIf = paramLong;
    locale.lCs = paramInt2;
    locale.lCE = paramInt1;
    locale.hyJ = paramString;
    Assert.assertTrue(lHY.mHandler.sendMessage(lHY.mHandler.obtainMessage(3, 0, 0, locale)));
    AppMethodBeat.o(19527);
  }
  
  private boolean jg(long paramLong)
  {
    AppMethodBeat.i(19525);
    ab.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = ".concat(String.valueOf(paramLong)));
    ab.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", new Object[] { Long.valueOf(paramLong) });
    if (!com.tencent.mm.plugin.exdevice.h.a.M("conneted_device", paramLong)) {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
    }
    if (!this.lHZ.containsKey(Long.valueOf(paramLong)))
    {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
      AppMethodBeat.o(19525);
      return false;
    }
    Java2CExDevice.stopChannelService(((Long)this.lHZ.get(Long.valueOf(paramLong))).longValue());
    Java2CExDevice.destroyChannel(((Long)this.lHZ.get(Long.valueOf(paramLong))).longValue());
    AppMethodBeat.o(19525);
    return true;
  }
  
  private long jh(long paramLong)
  {
    AppMethodBeat.i(19529);
    if (!this.lHZ.containsValue(Long.valueOf(paramLong)))
    {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceInfo by channelId");
      AppMethodBeat.o(19529);
      return -1L;
    }
    Iterator localIterator = this.lHZ.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramLong == ((Long)localEntry.getValue()).longValue())
      {
        paramLong = ((Long)localEntry.getKey()).longValue();
        AppMethodBeat.o(19529);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(19529);
    return -1L;
  }
  
  public static void onDeviceRequest(long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(19530);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ab.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d", new Object[] { Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i), Integer.valueOf(paramInt) });
      Assert.assertNotNull(lHY);
      ab.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + paramLong + " seq = " + paramShort1 + "cmdId = " + paramShort2 + "errCode = " + paramInt);
      paramLong = lHY.jh(paramLong);
      if (-1L != paramLong) {
        break;
      }
      ab.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      AppMethodBeat.o(19530);
      return;
    }
    a.b localb = new a.b((byte)0);
    localb.jRn = paramLong;
    localb.lCt = paramArrayOfByte;
    localb.lIc = paramShort2;
    localb.lCz = paramShort1;
    Assert.assertTrue(lHY.mHandler.sendMessage(lHY.mHandler.obtainMessage(5, paramInt, 0, localb)));
    AppMethodBeat.o(19530);
  }
  
  public static boolean uX(int paramInt)
  {
    AppMethodBeat.i(19523);
    ab.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
    if (!b.uX(paramInt))
    {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
      AppMethodBeat.o(19523);
      return false;
    }
    AppMethodBeat.o(19523);
    return true;
  }
  
  public final void GE(String paramString)
  {
    AppMethodBeat.i(19533);
    ab.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
    if (!this.mHandler.post(new a.1(this))) {
      ab.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
    }
    AppMethodBeat.o(19533);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19532);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ab.d("MicroMsg.exdevice.BTDeviceManager", "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      paramString1 = new a.c(paramString1, paramString2, paramInt2, paramArrayOfByte);
      Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, paramString1)));
      AppMethodBeat.o(19532);
      return;
    }
  }
  
  public final void rN(int paramInt)
  {
    AppMethodBeat.i(19531);
    ab.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    AppMethodBeat.o(19531);
  }
  
  static final class f
  {
    long jRn;
    byte[] mData;
    
    public f(long paramLong, byte[] paramArrayOfByte)
    {
      this.jRn = paramLong;
      this.mData = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.a
 * JD-Core Version:    0.7.0.1
 */
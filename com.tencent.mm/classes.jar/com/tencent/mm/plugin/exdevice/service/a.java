package com.tencent.mm.plugin.exdevice.service;

import android.os.HandlerThread;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements r
{
  private static a jyz = null;
  private Object bjn = new Object();
  private final HashMap<Long, Long> jyA = new HashMap();
  private g jyB = null;
  ah mHandler = new a.a(this, v.aMo().eAg.mnU.getLooper());
  
  public a(g paramg)
  {
    this.jyB = paramg;
    jyz = this;
  }
  
  /* Error */
  private int a(long paramLong, p paramp)
  {
    // Byte code:
    //   0: ldc 83
    //   2: ldc 85
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: lload_1
    //   11: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   14: aastore
    //   15: invokestatic 97	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   18: aload_3
    //   19: invokestatic 103	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   22: aload_3
    //   23: invokeinterface 109 1 0
    //   28: invokeinterface 115 1 0
    //   33: lstore 5
    //   35: ldc 117
    //   37: lload 5
    //   39: invokestatic 123	com/tencent/mm/plugin/exdevice/h/a:A	(Ljava/lang/String;J)Z
    //   42: ifne +113 -> 155
    //   45: ldc 83
    //   47: ldc 125
    //   49: invokestatic 129	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   52: new 16	com/tencent/mm/plugin/exdevice/service/a$e
    //   55: dup
    //   56: invokespecial 130	com/tencent/mm/plugin/exdevice/service/a$e:<init>	()V
    //   59: astore_3
    //   60: aload_3
    //   61: lload_1
    //   62: putfield 134	com/tencent/mm/plugin/exdevice/service/a$e:jyG	J
    //   65: aload_3
    //   66: iconst_m1
    //   67: putfield 138	com/tencent/mm/plugin/exdevice/service/a$e:jsT	I
    //   70: aload_3
    //   71: iconst_m1
    //   72: putfield 141	com/tencent/mm/plugin/exdevice/service/a$e:jtf	I
    //   75: aload_3
    //   76: ldc 143
    //   78: putfield 147	com/tencent/mm/plugin/exdevice/service/a$e:ghs	Ljava/lang/String;
    //   81: getstatic 36	com/tencent/mm/plugin/exdevice/service/a:jyz	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   84: getfield 75	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/ah;
    //   87: getstatic 36	com/tencent/mm/plugin/exdevice/service/a:jyz	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   90: getfield 75	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/ah;
    //   93: iconst_3
    //   94: iconst_0
    //   95: iconst_0
    //   96: aload_3
    //   97: invokevirtual 153	com/tencent/mm/sdk/platformtools/ah:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   100: invokevirtual 157	com/tencent/mm/sdk/platformtools/ah:sendMessage	(Landroid/os/Message;)Z
    //   103: invokestatic 161	junit/framework/Assert:assertTrue	(Z)V
    //   106: iconst_m1
    //   107: ireturn
    //   108: astore_3
    //   109: ldc 83
    //   111: ldc 163
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_3
    //   120: invokevirtual 167	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   123: aastore
    //   124: invokestatic 170	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   127: ldc 83
    //   129: aload_3
    //   130: ldc 172
    //   132: iconst_0
    //   133: anewarray 4	java/lang/Object
    //   136: invokestatic 176	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: aload_0
    //   140: getfield 48	com/tencent/mm/plugin/exdevice/service/a:jyB	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   143: lload_1
    //   144: iconst_m1
    //   145: iconst_m1
    //   146: ldc 178
    //   148: invokeinterface 184 6 0
    //   153: iconst_m1
    //   154: ireturn
    //   155: aload_0
    //   156: getfield 46	com/tencent/mm/plugin/exdevice/service/a:jyA	Ljava/util/HashMap;
    //   159: lload 5
    //   161: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   164: invokevirtual 188	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   167: ifne +38 -> 205
    //   170: ldc 83
    //   172: ldc 190
    //   174: iconst_1
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: lload 5
    //   182: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: invokestatic 170	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   189: aload_0
    //   190: getfield 48	com/tencent/mm/plugin/exdevice/service/a:jyB	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   193: lload_1
    //   194: iconst_m1
    //   195: iconst_m1
    //   196: ldc 192
    //   198: invokeinterface 184 6 0
    //   203: iconst_m1
    //   204: ireturn
    //   205: new 194	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd
    //   208: dup
    //   209: invokespecial 195	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:<init>	()V
    //   212: astore 7
    //   214: aload 7
    //   216: aload_0
    //   217: getfield 46	com/tencent/mm/plugin/exdevice/service/a:jyA	Ljava/util/HashMap;
    //   220: lload 5
    //   222: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   225: invokevirtual 199	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   228: checkcast 87	java/lang/Long
    //   231: invokevirtual 202	java/lang/Long:longValue	()J
    //   234: putfield 205	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   237: aload 7
    //   239: aload_3
    //   240: invokeinterface 109 1 0
    //   245: invokeinterface 209 1 0
    //   250: putfield 212	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   253: aload 7
    //   255: aload_3
    //   256: invokeinterface 109 1 0
    //   261: invokeinterface 215 1 0
    //   266: putfield 218	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   269: aload_3
    //   270: invokeinterface 109 1 0
    //   275: invokeinterface 222 1 0
    //   280: astore 8
    //   282: aload_3
    //   283: invokeinterface 109 1 0
    //   288: invokeinterface 225 1 0
    //   293: istore 4
    //   295: lload_1
    //   296: iload 4
    //   298: i2s
    //   299: aload 7
    //   301: aload 8
    //   303: invokestatic 231	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice:startTask	(JSLcom/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd;[B)I
    //   306: ifeq +106 -> 412
    //   309: ldc 83
    //   311: ldc 233
    //   313: invokestatic 235	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   316: iconst_m1
    //   317: ireturn
    //   318: astore_3
    //   319: ldc 83
    //   321: ldc 237
    //   323: iconst_1
    //   324: anewarray 4	java/lang/Object
    //   327: dup
    //   328: iconst_0
    //   329: aload_3
    //   330: invokevirtual 167	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   333: aastore
    //   334: invokestatic 170	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   337: ldc 83
    //   339: aload_3
    //   340: ldc 172
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 176	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   349: aload_0
    //   350: getfield 48	com/tencent/mm/plugin/exdevice/service/a:jyB	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   353: lload_1
    //   354: iconst_m1
    //   355: iconst_m1
    //   356: ldc 239
    //   358: invokeinterface 184 6 0
    //   363: iconst_m1
    //   364: ireturn
    //   365: astore_3
    //   366: ldc 83
    //   368: ldc 241
    //   370: iconst_1
    //   371: anewarray 4	java/lang/Object
    //   374: dup
    //   375: iconst_0
    //   376: aload_3
    //   377: invokevirtual 167	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   380: aastore
    //   381: invokestatic 170	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   384: ldc 83
    //   386: aload_3
    //   387: ldc 172
    //   389: iconst_0
    //   390: anewarray 4	java/lang/Object
    //   393: invokestatic 176	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   396: aload_0
    //   397: getfield 48	com/tencent/mm/plugin/exdevice/service/a:jyB	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   400: lload_1
    //   401: iconst_m1
    //   402: iconst_m1
    //   403: ldc 243
    //   405: invokeinterface 184 6 0
    //   410: iconst_m1
    //   411: ireturn
    //   412: ldc 83
    //   414: ldc 245
    //   416: bipush 6
    //   418: anewarray 4	java/lang/Object
    //   421: dup
    //   422: iconst_0
    //   423: lload_1
    //   424: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: lload 5
    //   432: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   435: aastore
    //   436: dup
    //   437: iconst_2
    //   438: aload 7
    //   440: getfield 205	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   443: invokestatic 91	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   446: aastore
    //   447: dup
    //   448: iconst_3
    //   449: iload 4
    //   451: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   454: aastore
    //   455: dup
    //   456: iconst_4
    //   457: aload 7
    //   459: getfield 212	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   462: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   465: aastore
    //   466: dup
    //   467: iconst_5
    //   468: aload 7
    //   470: getfield 218	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   473: invokestatic 250	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   476: aastore
    //   477: invokestatic 97	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   480: iconst_0
    //   481: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	482	0	this	a
    //   0	482	1	paramLong	long
    //   0	482	3	paramp	p
    //   293	157	4	i	int
    //   33	398	5	l	long
    //   212	257	7	localAccessoryCmd	com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd
    //   280	22	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   22	35	108	android/os/RemoteException
    //   237	269	318	android/os/RemoteException
    //   269	295	365	android/os/RemoteException
  }
  
  public static long[] aMa()
  {
    return com.tencent.mm.plugin.exdevice.h.a.BE("conneted_device");
  }
  
  public static void b(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    Assert.assertNotNull(jyz);
    y.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + paramLong + " oldState = " + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    paramLong = jyz.dP(paramLong);
    if (-1L == paramLong)
    {
      y.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      return;
    }
    a.d locald = new a.d((byte)0);
    locald.hXu = paramLong;
    locald.jsT = paramInt3;
    locald.jyF = paramInt2;
    locald.jyE = paramInt1;
    Assert.assertTrue(jyz.mHandler.sendMessage(jyz.mHandler.obtainMessage(4, 0, 0, locald)));
  }
  
  public static void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    Assert.assertNotNull(jyz);
    y.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + paramLong + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    a.e locale = new a.e();
    locale.jyG = paramLong;
    locale.jsT = paramInt2;
    locale.jtf = paramInt1;
    locale.ghs = paramString;
    Assert.assertTrue(jyz.mHandler.sendMessage(jyz.mHandler.obtainMessage(3, 0, 0, locale)));
  }
  
  private boolean dO(long paramLong)
  {
    y.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = " + paramLong);
    y.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", new Object[] { Long.valueOf(paramLong) });
    if (!com.tencent.mm.plugin.exdevice.h.a.C("conneted_device", paramLong)) {
      y.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
    }
    if (!this.jyA.containsKey(Long.valueOf(paramLong)))
    {
      y.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
      return false;
    }
    Java2CExDevice.stopChannelService(((Long)this.jyA.get(Long.valueOf(paramLong))).longValue());
    Java2CExDevice.destroyChannel(((Long)this.jyA.get(Long.valueOf(paramLong))).longValue());
    return true;
  }
  
  private long dP(long paramLong)
  {
    if (!this.jyA.containsValue(Long.valueOf(paramLong)))
    {
      y.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceId by channelId");
      return -1L;
    }
    Iterator localIterator = this.jyA.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramLong == ((Long)localEntry.getValue()).longValue()) {
        return ((Long)localEntry.getKey()).longValue();
      }
    }
    Assert.assertTrue(false);
    return -1L;
  }
  
  public static void onDeviceRequest(long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      y.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d", new Object[] { Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i), Integer.valueOf(paramInt) });
      Assert.assertNotNull(jyz);
      y.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + paramLong + " seq = " + paramShort1 + "cmdId = " + paramShort2 + "errCode = " + paramInt);
      paramLong = jyz.dP(paramLong);
      if (-1L != paramLong) {
        break;
      }
      y.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      return;
    }
    a.b localb = new a.b((byte)0);
    localb.hXu = paramLong;
    localb.jsU = paramArrayOfByte;
    localb.jyD = paramShort2;
    localb.jta = paramShort1;
    Assert.assertTrue(jyz.mHandler.sendMessage(jyz.mHandler.obtainMessage(5, paramInt, 0, localb)));
  }
  
  public static boolean qq(int paramInt)
  {
    y.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
    if (!b.qq(paramInt))
    {
      y.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
      return false;
    }
    return true;
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      y.d("MicroMsg.exdevice.BTDeviceManager", "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      paramString1 = new a.c(paramString1, paramString2, paramInt2, paramArrayOfByte);
      Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, paramString1)));
      return;
    }
  }
  
  public final void nZ(int paramInt)
  {
    y.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = " + paramInt);
    Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
  }
  
  public final void xM(String paramString)
  {
    y.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
    if (!this.mHandler.post(new a.1(this))) {
      y.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
    }
  }
  
  private static final class f
  {
    long hXu;
    byte[] mData;
    
    public f(long paramLong, byte[] paramArrayOfByte)
    {
      this.hXu = paramLong;
      this.mData = paramArrayOfByte;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.a
 * JD-Core Version:    0.7.0.1
 */
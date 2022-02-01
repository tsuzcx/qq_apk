package com.tencent.mm.plugin.exdevice.service;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements r
{
  private static a qfy = null;
  private Object dcK;
  ap mHandler;
  private g qfA;
  private final HashMap<Long, Long> qfz;
  
  public a(g paramg)
  {
    AppMethodBeat.i(23590);
    this.qfz = new HashMap();
    this.qfA = null;
    this.mHandler = new a(v.clW().imu.getSerialTag());
    this.dcK = new Object();
    this.qfA = paramg;
    qfy = this;
    AppMethodBeat.o(23590);
  }
  
  public static boolean CC(int paramInt)
  {
    AppMethodBeat.i(23591);
    ad.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
    if (!b.CC(paramInt))
    {
      ad.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
      AppMethodBeat.o(23591);
      return false;
    }
    AppMethodBeat.o(23591);
    return true;
  }
  
  /* Error */
  private int a(long paramLong, p paramp)
  {
    // Byte code:
    //   0: sipush 23594
    //   3: invokestatic 55	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: ldc 91
    //   8: ldc 111
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 120	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_3
    //   25: invokestatic 126	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   28: aload_3
    //   29: invokeinterface 132 1 0
    //   34: invokeinterface 138 1 0
    //   39: lstore 5
    //   41: ldc 140
    //   43: lload 5
    //   45: invokestatic 146	com/tencent/mm/plugin/exdevice/i/a:ad	(Ljava/lang/String;J)Z
    //   48: ifne +125 -> 173
    //   51: ldc 91
    //   53: ldc 148
    //   55: invokestatic 151	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 22	com/tencent/mm/plugin/exdevice/service/a$e
    //   61: dup
    //   62: invokespecial 152	com/tencent/mm/plugin/exdevice/service/a$e:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: lload_1
    //   68: putfield 156	com/tencent/mm/plugin/exdevice/service/a$e:qfF	J
    //   71: aload_3
    //   72: iconst_m1
    //   73: putfield 160	com/tencent/mm/plugin/exdevice/service/a$e:pZU	I
    //   76: aload_3
    //   77: iconst_m1
    //   78: putfield 163	com/tencent/mm/plugin/exdevice/service/a$e:qag	I
    //   81: aload_3
    //   82: ldc 165
    //   84: putfield 169	com/tencent/mm/plugin/exdevice/service/a$e:ksX	Ljava/lang/String;
    //   87: getstatic 44	com/tencent/mm/plugin/exdevice/service/a:qfy	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   90: getfield 82	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/ap;
    //   93: getstatic 44	com/tencent/mm/plugin/exdevice/service/a:qfy	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   96: getfield 82	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/ap;
    //   99: iconst_3
    //   100: iconst_0
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 173	com/tencent/mm/sdk/platformtools/ap:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   106: invokevirtual 177	com/tencent/mm/sdk/platformtools/ap:sendMessage	(Landroid/os/Message;)Z
    //   109: invokestatic 181	junit/framework/Assert:assertTrue	(Z)V
    //   112: sipush 23594
    //   115: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_m1
    //   119: ireturn
    //   120: astore_3
    //   121: ldc 91
    //   123: ldc 183
    //   125: iconst_1
    //   126: anewarray 4	java/lang/Object
    //   129: dup
    //   130: iconst_0
    //   131: aload_3
    //   132: invokevirtual 186	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   135: aastore
    //   136: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   139: ldc 91
    //   141: aload_3
    //   142: ldc 190
    //   144: iconst_0
    //   145: anewarray 4	java/lang/Object
    //   148: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   151: aload_0
    //   152: getfield 62	com/tencent/mm/plugin/exdevice/service/a:qfA	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   155: lload_1
    //   156: iconst_m1
    //   157: iconst_m1
    //   158: ldc 196
    //   160: invokeinterface 201 6 0
    //   165: sipush 23594
    //   168: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   171: iconst_m1
    //   172: ireturn
    //   173: aload_0
    //   174: getfield 60	com/tencent/mm/plugin/exdevice/service/a:qfz	Ljava/util/HashMap;
    //   177: lload 5
    //   179: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   182: invokevirtual 205	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   185: ifne +44 -> 229
    //   188: ldc 91
    //   190: ldc 207
    //   192: iconst_1
    //   193: anewarray 4	java/lang/Object
    //   196: dup
    //   197: iconst_0
    //   198: lload 5
    //   200: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   203: aastore
    //   204: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   207: aload_0
    //   208: getfield 62	com/tencent/mm/plugin/exdevice/service/a:qfA	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   211: lload_1
    //   212: iconst_m1
    //   213: iconst_m1
    //   214: ldc 209
    //   216: invokeinterface 201 6 0
    //   221: sipush 23594
    //   224: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: iconst_m1
    //   228: ireturn
    //   229: new 211	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd
    //   232: dup
    //   233: invokespecial 212	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:<init>	()V
    //   236: astore 7
    //   238: aload 7
    //   240: aload_0
    //   241: getfield 60	com/tencent/mm/plugin/exdevice/service/a:qfz	Ljava/util/HashMap;
    //   244: lload 5
    //   246: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   249: invokevirtual 216	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   252: checkcast 113	java/lang/Long
    //   255: invokevirtual 219	java/lang/Long:longValue	()J
    //   258: putfield 222	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   261: aload 7
    //   263: aload_3
    //   264: invokeinterface 132 1 0
    //   269: invokeinterface 226 1 0
    //   274: putfield 229	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   277: aload 7
    //   279: aload_3
    //   280: invokeinterface 132 1 0
    //   285: invokeinterface 232 1 0
    //   290: putfield 235	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   293: aload_3
    //   294: invokeinterface 132 1 0
    //   299: invokeinterface 239 1 0
    //   304: astore 8
    //   306: aload_3
    //   307: invokeinterface 132 1 0
    //   312: invokeinterface 242 1 0
    //   317: istore 4
    //   319: lload_1
    //   320: iload 4
    //   322: i2s
    //   323: aload 7
    //   325: aload 8
    //   327: invokestatic 248	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice:startTask	(JSLcom/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd;[B)I
    //   330: ifeq +126 -> 456
    //   333: ldc 91
    //   335: ldc 250
    //   337: invokestatic 106	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   340: sipush 23594
    //   343: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   346: iconst_m1
    //   347: ireturn
    //   348: astore_3
    //   349: ldc 91
    //   351: ldc 252
    //   353: iconst_1
    //   354: anewarray 4	java/lang/Object
    //   357: dup
    //   358: iconst_0
    //   359: aload_3
    //   360: invokevirtual 186	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   363: aastore
    //   364: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: ldc 91
    //   369: aload_3
    //   370: ldc 190
    //   372: iconst_0
    //   373: anewarray 4	java/lang/Object
    //   376: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   379: aload_0
    //   380: getfield 62	com/tencent/mm/plugin/exdevice/service/a:qfA	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   383: lload_1
    //   384: iconst_m1
    //   385: iconst_m1
    //   386: ldc 254
    //   388: invokeinterface 201 6 0
    //   393: sipush 23594
    //   396: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: iconst_m1
    //   400: ireturn
    //   401: astore_3
    //   402: ldc 91
    //   404: ldc_w 256
    //   407: iconst_1
    //   408: anewarray 4	java/lang/Object
    //   411: dup
    //   412: iconst_0
    //   413: aload_3
    //   414: invokevirtual 186	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   417: aastore
    //   418: invokestatic 188	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   421: ldc 91
    //   423: aload_3
    //   424: ldc 190
    //   426: iconst_0
    //   427: anewarray 4	java/lang/Object
    //   430: invokestatic 194	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: aload_0
    //   434: getfield 62	com/tencent/mm/plugin/exdevice/service/a:qfA	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   437: lload_1
    //   438: iconst_m1
    //   439: iconst_m1
    //   440: ldc_w 258
    //   443: invokeinterface 201 6 0
    //   448: sipush 23594
    //   451: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   454: iconst_m1
    //   455: ireturn
    //   456: ldc 91
    //   458: ldc_w 260
    //   461: bipush 6
    //   463: anewarray 4	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: lload_1
    //   469: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   472: aastore
    //   473: dup
    //   474: iconst_1
    //   475: lload 5
    //   477: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   480: aastore
    //   481: dup
    //   482: iconst_2
    //   483: aload 7
    //   485: getfield 222	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   488: invokestatic 117	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   491: aastore
    //   492: dup
    //   493: iconst_3
    //   494: iload 4
    //   496: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   499: aastore
    //   500: dup
    //   501: iconst_4
    //   502: aload 7
    //   504: getfield 229	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   507: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   510: aastore
    //   511: dup
    //   512: iconst_5
    //   513: aload 7
    //   515: getfield 235	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   518: invokestatic 265	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   521: aastore
    //   522: invokestatic 120	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   525: sipush 23594
    //   528: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   531: iconst_0
    //   532: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	533	0	this	a
    //   0	533	1	paramLong	long
    //   0	533	3	paramp	p
    //   317	178	4	i	int
    //   39	437	5	l	long
    //   236	278	7	localAccessoryCmd	com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd
    //   304	22	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	41	120	android/os/RemoteException
    //   261	293	348	android/os/RemoteException
    //   293	319	401	android/os/RemoteException
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23596);
    Assert.assertNotNull(qfy);
    ad.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + paramLong + " oldState = " + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    paramLong = qfy.uz(paramLong);
    if (-1L == paramLong)
    {
      ad.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      AppMethodBeat.o(23596);
      return;
    }
    d locald = new d((byte)0);
    locald.nTx = paramLong;
    locald.pZU = paramInt3;
    locald.qfE = paramInt2;
    locald.qfD = paramInt1;
    Assert.assertTrue(qfy.mHandler.sendMessage(qfy.mHandler.obtainMessage(4, 0, 0, locald)));
    AppMethodBeat.o(23596);
  }
  
  public static void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23595);
    Assert.assertNotNull(qfy);
    ad.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + paramLong + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    e locale = new e();
    locale.qfF = paramLong;
    locale.pZU = paramInt2;
    locale.qag = paramInt1;
    locale.ksX = paramString;
    Assert.assertTrue(qfy.mHandler.sendMessage(qfy.mHandler.obtainMessage(3, 0, 0, locale)));
    AppMethodBeat.o(23595);
  }
  
  public static long[] clI()
  {
    AppMethodBeat.i(23592);
    long[] arrayOfLong = com.tencent.mm.plugin.exdevice.i.a.acH("conneted_device");
    AppMethodBeat.o(23592);
    return arrayOfLong;
  }
  
  public static void onDeviceRequest(long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23598);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ad.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d", new Object[] { Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i), Integer.valueOf(paramInt) });
      Assert.assertNotNull(qfy);
      ad.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + paramLong + " seq = " + paramShort1 + "cmdId = " + paramShort2 + "errCode = " + paramInt);
      paramLong = qfy.uz(paramLong);
      if (-1L != paramLong) {
        break;
      }
      ad.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      AppMethodBeat.o(23598);
      return;
    }
    b localb = new b((byte)0);
    localb.nTx = paramLong;
    localb.pZV = paramArrayOfByte;
    localb.qfC = paramShort2;
    localb.qab = paramShort1;
    Assert.assertTrue(qfy.mHandler.sendMessage(qfy.mHandler.obtainMessage(5, paramInt, 0, localb)));
    AppMethodBeat.o(23598);
  }
  
  private boolean uy(long paramLong)
  {
    AppMethodBeat.i(23593);
    ad.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = ".concat(String.valueOf(paramLong)));
    ad.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", new Object[] { Long.valueOf(paramLong) });
    if (!com.tencent.mm.plugin.exdevice.i.a.af("conneted_device", paramLong)) {
      ad.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
    }
    if (!this.qfz.containsKey(Long.valueOf(paramLong)))
    {
      ad.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
      AppMethodBeat.o(23593);
      return false;
    }
    Java2CExDevice.stopChannelService(((Long)this.qfz.get(Long.valueOf(paramLong))).longValue());
    Java2CExDevice.destroyChannel(((Long)this.qfz.get(Long.valueOf(paramLong))).longValue());
    AppMethodBeat.o(23593);
    return true;
  }
  
  private long uz(long paramLong)
  {
    AppMethodBeat.i(23597);
    if (!this.qfz.containsValue(Long.valueOf(paramLong)))
    {
      ad.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceInfo by channelId");
      AppMethodBeat.o(23597);
      return -1L;
    }
    Iterator localIterator = this.qfz.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (paramLong == ((Long)localEntry.getValue()).longValue())
      {
        paramLong = ((Long)localEntry.getKey()).longValue();
        AppMethodBeat.o(23597);
        return paramLong;
      }
    }
    Assert.assertTrue(false);
    AppMethodBeat.o(23597);
    return -1L;
  }
  
  public final void WC(String paramString)
  {
    AppMethodBeat.i(23601);
    ad.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
    if (!this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23588);
        a.a(a.this).a(0, -1, "", "", "", 0, null);
        AppMethodBeat.o(23588);
      }
    })) {
      ad.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
    }
    AppMethodBeat.o(23601);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23600);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      ad.d("MicroMsg.exdevice.BTDeviceManager", "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      paramString1 = new c(paramString1, paramString2, paramInt2, paramArrayOfByte);
      Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, paramString1)));
      AppMethodBeat.o(23600);
      return;
    }
  }
  
  public final void yV(int paramInt)
  {
    AppMethodBeat.i(23599);
    ad.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    AppMethodBeat.o(23599);
  }
  
  final class a
    extends ap
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(23589);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(23589);
        return;
      case 2: 
        a.a(a.this).a(2, 0, null, null, null, 0, null);
        AppMethodBeat.o(23589);
        return;
      case 1: 
        paramMessage = (a.c)paramMessage.obj;
        a.a(a.this).a(1, 0, null, paramMessage.nTB, paramMessage.mDeviceName, paramMessage.kGT, paramMessage.nTC);
        AppMethodBeat.o(23589);
        return;
      case 3: 
        paramMessage = (a.e)paramMessage.obj;
        a.a(a.this).c(paramMessage.qfF, paramMessage.qag, paramMessage.pZU, paramMessage.ksX);
        AppMethodBeat.o(23589);
        return;
      case 4: 
        paramMessage = (a.d)paramMessage.obj;
        a.a(a.this).a(paramMessage.nTx, paramMessage.qfD, paramMessage.qfE, paramMessage.pZU);
        AppMethodBeat.o(23589);
        return;
      case 5: 
        ??? = (a.b)paramMessage.obj;
        a.a(a.this).a(paramMessage.arg1, ((a.b)???).nTx, ((a.b)???).qab, ((a.b)???).qfC, ((a.b)???).pZV);
        AppMethodBeat.o(23589);
        return;
      case 6: 
        AppMethodBeat.o(23589);
        return;
      case 7: 
        AppMethodBeat.o(23589);
        return;
      case 10: 
        paramMessage = (a.f)paramMessage.obj;
        a.a(a.this, paramMessage.nTx, paramMessage.mData);
        AppMethodBeat.o(23589);
        return;
      case 8: 
        paramMessage = (a.g)paramMessage.obj;
        a.a(a.this, paramMessage.qfF, paramMessage.qfG);
        AppMethodBeat.o(23589);
        return;
      case 9: 
        a.uA(((Long)paramMessage.obj).longValue());
        AppMethodBeat.o(23589);
        return;
      case 11: 
        synchronized (a.b(a.this))
        {
          a.a(a.this, ((Long)paramMessage.obj).longValue());
          AppMethodBeat.o(23589);
          return;
        }
      }
      synchronized (a.b(a.this))
      {
        a.b(a.this, ((Long)paramMessage.obj).longValue());
        AppMethodBeat.o(23589);
        return;
      }
    }
  }
  
  static final class b
  {
    long nTx = 0L;
    byte[] pZV = null;
    short qab = 0;
    short qfC = 0;
  }
  
  static final class c
  {
    int kGT;
    String mDeviceName;
    String nTB;
    byte[] nTC;
    
    public c(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.nTB = paramString1;
      this.mDeviceName = paramString2;
      this.kGT = paramInt;
      this.nTC = paramArrayOfByte;
    }
  }
  
  static final class d
  {
    long nTx = 0L;
    int pZU = 0;
    int qfD = 0;
    int qfE = 0;
  }
  
  static final class e
  {
    String ksX = null;
    int pZU = 0;
    int qag = 0;
    long qfF = 0L;
  }
  
  static final class f
  {
    byte[] mData;
    long nTx;
    
    public f(long paramLong, byte[] paramArrayOfByte)
    {
      this.nTx = paramLong;
      this.mData = paramArrayOfByte;
    }
  }
  
  static final class g
  {
    long qfF;
    p qfG;
    
    public g(long paramLong, p paramp)
    {
      this.qfF = paramLong;
      this.qfG = paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.a
 * JD-Core Version:    0.7.0.1
 */
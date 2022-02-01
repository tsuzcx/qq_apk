package com.tencent.mm.plugin.exdevice.service;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.jni.Java2CExDevice;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import junit.framework.Assert;

public final class a
  implements r
{
  private static a viJ = null;
  private Object fnq;
  MMHandler mHandler;
  private final HashMap<Long, Long> viK;
  private g viL;
  
  public a(g paramg)
  {
    AppMethodBeat.i(23590);
    this.viK = new HashMap();
    this.viL = null;
    this.mHandler = new a(v.dam().mat.getSerialTag());
    this.fnq = new Object();
    this.viL = paramg;
    viJ = this;
    AppMethodBeat.o(23590);
  }
  
  private boolean Jh(long paramLong)
  {
    AppMethodBeat.i(23593);
    Log.i("MicroMsg.exdevice.BTDeviceManager", "stopChannelImp deviceId = ".concat(String.valueOf(paramLong)));
    Log.i("MicroMsg.exdevice.BTDeviceManager", "remove the device from connected devices : [%d]", new Object[] { Long.valueOf(paramLong) });
    if (!com.tencent.mm.plugin.exdevice.i.a.af("conneted_device", paramLong)) {
      Log.e("MicroMsg.exdevice.BTDeviceManager", "removeFromSharedPreferences failed!!!");
    }
    if (!this.viK.containsKey(Long.valueOf(paramLong)))
    {
      Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId in the map");
      AppMethodBeat.o(23593);
      return false;
    }
    Java2CExDevice.stopChannelService(((Long)this.viK.get(Long.valueOf(paramLong))).longValue());
    Java2CExDevice.destroyChannel(((Long)this.viK.get(Long.valueOf(paramLong))).longValue());
    AppMethodBeat.o(23593);
    return true;
  }
  
  private long Ji(long paramLong)
  {
    AppMethodBeat.i(23597);
    if (!this.viK.containsValue(Long.valueOf(paramLong)))
    {
      Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find DeviceInfo by channelId");
      AppMethodBeat.o(23597);
      return -1L;
    }
    Iterator localIterator = this.viK.entrySet().iterator();
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
  
  public static boolean Kh(int paramInt)
  {
    AppMethodBeat.i(23591);
    Log.i("MicroMsg.exdevice.BTDeviceManager", "------stopScan------");
    if (!b.Kh(paramInt))
    {
      Log.e("MicroMsg.exdevice.BTDeviceManager", "BluetoothSDKAdapter.stopScan Failed!!!");
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
    //   8: ldc 217
    //   10: iconst_1
    //   11: anewarray 4	java/lang/Object
    //   14: dup
    //   15: iconst_0
    //   16: lload_1
    //   17: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   20: aastore
    //   21: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: aload_3
    //   25: invokestatic 221	junit/framework/Assert:assertNotNull	(Ljava/lang/Object;)V
    //   28: aload_3
    //   29: invokeinterface 227 1 0
    //   34: invokeinterface 232 1 0
    //   39: lstore 5
    //   41: ldc 120
    //   43: lload 5
    //   45: invokestatic 235	com/tencent/mm/plugin/exdevice/i/a:ad	(Ljava/lang/String;J)Z
    //   48: ifne +128 -> 176
    //   51: ldc 91
    //   53: ldc 237
    //   55: invokestatic 240	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 22	com/tencent/mm/plugin/exdevice/service/a$e
    //   61: dup
    //   62: invokespecial 241	com/tencent/mm/plugin/exdevice/service/a$e:<init>	()V
    //   65: astore_3
    //   66: aload_3
    //   67: lload_1
    //   68: putfield 245	com/tencent/mm/plugin/exdevice/service/a$e:viQ	J
    //   71: aload_3
    //   72: iconst_m1
    //   73: putfield 249	com/tencent/mm/plugin/exdevice/service/a$e:vdb	I
    //   76: aload_3
    //   77: iconst_m1
    //   78: putfield 252	com/tencent/mm/plugin/exdevice/service/a$e:vdn	I
    //   81: aload_3
    //   82: ldc 254
    //   84: putfield 258	com/tencent/mm/plugin/exdevice/service/a$e:ovI	Ljava/lang/String;
    //   87: getstatic 44	com/tencent/mm/plugin/exdevice/service/a:viJ	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   90: getfield 82	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   93: getstatic 44	com/tencent/mm/plugin/exdevice/service/a:viJ	Lcom/tencent/mm/plugin/exdevice/service/a;
    //   96: getfield 82	com/tencent/mm/plugin/exdevice/service/a:mHandler	Lcom/tencent/mm/sdk/platformtools/MMHandler;
    //   99: iconst_3
    //   100: iconst_0
    //   101: iconst_0
    //   102: aload_3
    //   103: invokevirtual 262	com/tencent/mm/sdk/platformtools/MMHandler:obtainMessage	(IIILjava/lang/Object;)Landroid/os/Message;
    //   106: invokevirtual 266	com/tencent/mm/sdk/platformtools/MMHandler:sendMessage	(Landroid/os/Message;)Z
    //   109: invokestatic 196	junit/framework/Assert:assertTrue	(Z)V
    //   112: sipush 23594
    //   115: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: iconst_m1
    //   119: ireturn
    //   120: astore_3
    //   121: ldc 91
    //   123: ldc_w 268
    //   126: iconst_1
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: aload_3
    //   133: invokevirtual 271	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   136: aastore
    //   137: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   140: ldc 91
    //   142: aload_3
    //   143: ldc_w 275
    //   146: iconst_0
    //   147: anewarray 4	java/lang/Object
    //   150: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   153: aload_0
    //   154: getfield 62	com/tencent/mm/plugin/exdevice/service/a:viL	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   157: lload_1
    //   158: iconst_m1
    //   159: iconst_m1
    //   160: ldc_w 281
    //   163: invokeinterface 286 6 0
    //   168: sipush 23594
    //   171: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: iconst_m1
    //   175: ireturn
    //   176: aload_0
    //   177: getfield 60	com/tencent/mm/plugin/exdevice/service/a:viK	Ljava/util/HashMap;
    //   180: lload 5
    //   182: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: invokevirtual 134	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   188: ifne +46 -> 234
    //   191: ldc 91
    //   193: ldc_w 288
    //   196: iconst_1
    //   197: anewarray 4	java/lang/Object
    //   200: dup
    //   201: iconst_0
    //   202: lload 5
    //   204: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   207: aastore
    //   208: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: aload_0
    //   212: getfield 62	com/tencent/mm/plugin/exdevice/service/a:viL	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   215: lload_1
    //   216: iconst_m1
    //   217: iconst_m1
    //   218: ldc_w 290
    //   221: invokeinterface 286 6 0
    //   226: sipush 23594
    //   229: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   232: iconst_m1
    //   233: ireturn
    //   234: new 292	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd
    //   237: dup
    //   238: invokespecial 293	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:<init>	()V
    //   241: astore 7
    //   243: aload 7
    //   245: aload_0
    //   246: getfield 60	com/tencent/mm/plugin/exdevice/service/a:viK	Ljava/util/HashMap;
    //   249: lload 5
    //   251: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   254: invokevirtual 140	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   257: checkcast 112	java/lang/Long
    //   260: invokevirtual 144	java/lang/Long:longValue	()J
    //   263: putfield 296	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   266: aload 7
    //   268: aload_3
    //   269: invokeinterface 227 1 0
    //   274: invokeinterface 300 1 0
    //   279: putfield 303	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   282: aload 7
    //   284: aload_3
    //   285: invokeinterface 227 1 0
    //   290: invokeinterface 306 1 0
    //   295: putfield 309	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   298: aload_3
    //   299: invokeinterface 227 1 0
    //   304: invokeinterface 313 1 0
    //   309: astore 8
    //   311: aload_3
    //   312: invokeinterface 227 1 0
    //   317: invokeinterface 316 1 0
    //   322: istore 4
    //   324: lload_1
    //   325: iload 4
    //   327: i2s
    //   328: aload 7
    //   330: aload 8
    //   332: invokestatic 320	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice:startTask	(JSLcom/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd;[B)I
    //   335: ifeq +131 -> 466
    //   338: ldc 91
    //   340: ldc_w 322
    //   343: invokestatic 130	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   346: sipush 23594
    //   349: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: iconst_m1
    //   353: ireturn
    //   354: astore_3
    //   355: ldc 91
    //   357: ldc_w 324
    //   360: iconst_1
    //   361: anewarray 4	java/lang/Object
    //   364: dup
    //   365: iconst_0
    //   366: aload_3
    //   367: invokevirtual 271	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   370: aastore
    //   371: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   374: ldc 91
    //   376: aload_3
    //   377: ldc_w 275
    //   380: iconst_0
    //   381: anewarray 4	java/lang/Object
    //   384: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   387: aload_0
    //   388: getfield 62	com/tencent/mm/plugin/exdevice/service/a:viL	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   391: lload_1
    //   392: iconst_m1
    //   393: iconst_m1
    //   394: ldc_w 326
    //   397: invokeinterface 286 6 0
    //   402: sipush 23594
    //   405: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   408: iconst_m1
    //   409: ireturn
    //   410: astore_3
    //   411: ldc 91
    //   413: ldc_w 328
    //   416: iconst_1
    //   417: anewarray 4	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload_3
    //   423: invokevirtual 271	android/os/RemoteException:getMessage	()Ljava/lang/String;
    //   426: aastore
    //   427: invokestatic 273	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: ldc 91
    //   432: aload_3
    //   433: ldc_w 275
    //   436: iconst_0
    //   437: anewarray 4	java/lang/Object
    //   440: invokestatic 279	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   443: aload_0
    //   444: getfield 62	com/tencent/mm/plugin/exdevice/service/a:viL	Lcom/tencent/mm/plugin/exdevice/service/g;
    //   447: lload_1
    //   448: iconst_m1
    //   449: iconst_m1
    //   450: ldc_w 330
    //   453: invokeinterface 286 6 0
    //   458: sipush 23594
    //   461: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   464: iconst_m1
    //   465: ireturn
    //   466: ldc 91
    //   468: ldc_w 332
    //   471: bipush 6
    //   473: anewarray 4	java/lang/Object
    //   476: dup
    //   477: iconst_0
    //   478: lload_1
    //   479: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   482: aastore
    //   483: dup
    //   484: iconst_1
    //   485: lload 5
    //   487: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   490: aastore
    //   491: dup
    //   492: iconst_2
    //   493: aload 7
    //   495: getfield 296	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:channelID	J
    //   498: invokestatic 115	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   501: aastore
    //   502: dup
    //   503: iconst_3
    //   504: iload 4
    //   506: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   509: aastore
    //   510: dup
    //   511: iconst_4
    //   512: aload 7
    //   514: getfield 303	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:reqCmdID	I
    //   517: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   520: aastore
    //   521: dup
    //   522: iconst_5
    //   523: aload 7
    //   525: getfield 309	com/tencent/mm/plugin/exdevice/jni/Java2CExDevice$AccessoryCmd:respCmdID	I
    //   528: invokestatic 337	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   531: aastore
    //   532: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   535: sipush 23594
    //   538: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   541: iconst_0
    //   542: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	543	0	this	a
    //   0	543	1	paramLong	long
    //   0	543	3	paramp	p
    //   322	183	4	i	int
    //   39	447	5	l	long
    //   241	283	7	localAccessoryCmd	com.tencent.mm.plugin.exdevice.jni.Java2CExDevice.AccessoryCmd
    //   309	22	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   28	41	120	android/os/RemoteException
    //   266	298	354	android/os/RemoteException
    //   298	324	410	android/os/RemoteException
  }
  
  public static void a(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(23596);
    Assert.assertNotNull(viJ);
    Log.i("MicroMsg.exdevice.BTDeviceManager", "onStateChange channelId = " + paramLong + " oldState = " + paramInt1 + " newState = " + paramInt2 + " errCode = " + paramInt3);
    paramLong = viJ.Ji(paramLong);
    if (-1L == paramLong)
    {
      Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      AppMethodBeat.o(23596);
      return;
    }
    d locald = new d((byte)0);
    locald.smk = paramLong;
    locald.vdb = paramInt3;
    locald.viP = paramInt2;
    locald.viO = paramInt1;
    Assert.assertTrue(viJ.mHandler.sendMessage(viJ.mHandler.obtainMessage(4, 0, 0, locald)));
    AppMethodBeat.o(23596);
  }
  
  public static void c(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(23595);
    Assert.assertNotNull(viJ);
    Log.i("MicroMsg.exdevice.BTDeviceManager", "onTaskEnd taskId = " + paramLong + " errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    e locale = new e();
    locale.viQ = paramLong;
    locale.vdb = paramInt2;
    locale.vdn = paramInt1;
    locale.ovI = paramString;
    Assert.assertTrue(viJ.mHandler.sendMessage(viJ.mHandler.obtainMessage(3, 0, 0, locale)));
    AppMethodBeat.o(23595);
  }
  
  public static long[] cZN()
  {
    AppMethodBeat.i(23592);
    long[] arrayOfLong = com.tencent.mm.plugin.exdevice.i.a.avG("conneted_device");
    AppMethodBeat.o(23592);
    return arrayOfLong;
  }
  
  public static void onDeviceRequest(long paramLong, short paramShort1, short paramShort2, byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(23598);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      Log.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = %d, seq = %d, cmdId =%d, datain len = %d, errCode = %d", new Object[] { Long.valueOf(paramLong), Short.valueOf(paramShort1), Short.valueOf(paramShort2), Integer.valueOf(i), Integer.valueOf(paramInt) });
      Assert.assertNotNull(viJ);
      Log.i("MicroMsg.exdevice.BTDeviceManager", "onDeviceRequest channelId = " + paramLong + " seq = " + paramShort1 + "cmdId = " + paramShort2 + "errCode = " + paramInt);
      paramLong = viJ.Ji(paramLong);
      if (-1L != paramLong) {
        break;
      }
      Log.e("MicroMsg.exdevice.BTDeviceManager", "Cannot find deviceId by channelId");
      AppMethodBeat.o(23598);
      return;
    }
    b localb = new b((byte)0);
    localb.smk = paramLong;
    localb.vdc = paramArrayOfByte;
    localb.viN = paramShort2;
    localb.vdi = paramShort1;
    Assert.assertTrue(viJ.mHandler.sendMessage(viJ.mHandler.obtainMessage(5, paramInt, 0, localb)));
    AppMethodBeat.o(23598);
  }
  
  public final void Gp(int paramInt)
  {
    AppMethodBeat.i(23599);
    Log.i("MicroMsg.exdevice.BTDeviceManager", "******onScanFinished******aBluetoothVersion = ".concat(String.valueOf(paramInt)));
    Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(2, 0, 0, null)));
    AppMethodBeat.o(23599);
  }
  
  public final void a(String paramString1, String paramString2, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23600);
    if (paramArrayOfByte == null) {}
    for (int i = -1;; i = paramArrayOfByte.length)
    {
      Log.d("MicroMsg.exdevice.BTDeviceManager", "------onScanFound------ aBluetoothVersion = %d, device mac = %s, device name = %s, rssi = %d, advertisment length = %d", new Object[] { Integer.valueOf(paramInt1), paramString1, paramString2, Integer.valueOf(paramInt2), Integer.valueOf(i) });
      paramString1 = new c(paramString1, paramString2, paramInt2, paramArrayOfByte);
      Assert.assertTrue(this.mHandler.sendMessage(this.mHandler.obtainMessage(1, 0, 0, paramString1)));
      AppMethodBeat.o(23600);
      return;
    }
  }
  
  public final void aoQ(String paramString)
  {
    AppMethodBeat.i(23601);
    Log.i("MicroMsg.exdevice.BTDeviceManager", "------onScanError------ error code = %d, error msg = %s", new Object[] { Integer.valueOf(-1), Integer.valueOf(-1) });
    if (!this.mHandler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(23588);
        a.a(a.this).a(0, -1, "", "", "", 0, null);
        AppMethodBeat.o(23588);
      }
    })) {
      Log.e("MicroMsg.exdevice.BTDeviceManager", "onScanError: mHandler.post failed!!!");
    }
    AppMethodBeat.o(23601);
  }
  
  final class a
    extends MMHandler
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
        a.a(a.this).a(1, 0, null, paramMessage.smo, paramMessage.mDeviceName, paramMessage.oLi, paramMessage.smp);
        AppMethodBeat.o(23589);
        return;
      case 3: 
        paramMessage = (a.e)paramMessage.obj;
        a.a(a.this).c(paramMessage.viQ, paramMessage.vdn, paramMessage.vdb, paramMessage.ovI);
        AppMethodBeat.o(23589);
        return;
      case 4: 
        paramMessage = (a.d)paramMessage.obj;
        a.a(a.this).a(paramMessage.smk, paramMessage.viO, paramMessage.viP, paramMessage.vdb);
        AppMethodBeat.o(23589);
        return;
      case 5: 
        ??? = (a.b)paramMessage.obj;
        a.a(a.this).a(paramMessage.arg1, ((a.b)???).smk, ((a.b)???).vdi, ((a.b)???).viN, ((a.b)???).vdc);
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
        a.a(a.this, paramMessage.smk, paramMessage.mData);
        AppMethodBeat.o(23589);
        return;
      case 8: 
        paramMessage = (a.g)paramMessage.obj;
        a.a(a.this, paramMessage.viQ, paramMessage.viR);
        AppMethodBeat.o(23589);
        return;
      case 9: 
        a.Jj(((Long)paramMessage.obj).longValue());
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
    long smk = 0L;
    byte[] vdc = null;
    short vdi = 0;
    short viN = 0;
  }
  
  static final class c
  {
    String mDeviceName;
    int oLi;
    String smo;
    byte[] smp;
    
    public c(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
    {
      this.smo = paramString1;
      this.mDeviceName = paramString2;
      this.oLi = paramInt;
      this.smp = paramArrayOfByte;
    }
  }
  
  static final class d
  {
    long smk = 0L;
    int vdb = 0;
    int viO = 0;
    int viP = 0;
  }
  
  static final class e
  {
    String ovI = null;
    int vdb = 0;
    int vdn = 0;
    long viQ = 0L;
  }
  
  static final class f
  {
    byte[] mData;
    long smk;
    
    public f(long paramLong, byte[] paramArrayOfByte)
    {
      this.smk = paramLong;
      this.mData = paramArrayOfByte;
    }
  }
  
  static final class g
  {
    long viQ;
    p viR;
    
    public g(long paramLong, p paramp)
    {
      this.viQ = paramLong;
      this.viR = paramp;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.service.a
 * JD-Core Version:    0.7.0.1
 */
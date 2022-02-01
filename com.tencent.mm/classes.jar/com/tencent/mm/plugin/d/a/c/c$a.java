package com.tencent.mm.plugin.d.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import java.lang.ref.WeakReference;

public final class c$a
{
  public final ap mHandler;
  BluetoothSocket mPW;
  final boolean mPX;
  public final b mPY;
  public final a mPZ;
  boolean mQa;
  final BluetoothDevice mQb;
  
  public c$a(b paramb, a parama, BluetoothDevice paramBluetoothDevice)
  {
    AppMethodBeat.i(22598);
    this.mPZ = parama;
    this.mPY = paramb;
    this.mPX = true;
    this.mQa = false;
    this.mQb = paramBluetoothDevice;
    this.mHandler = new a(com.tencent.e.j.a.aOc("BluetoothChatThreads_handlerThread"), this);
    AppMethodBeat.o(22598);
  }
  
  public final void disconnect()
  {
    AppMethodBeat.i(22599);
    ad.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
    if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
      ad.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[] { Integer.valueOf(1) });
    }
    this.mHandler.quitSafely();
    AppMethodBeat.o(22599);
  }
  
  static final class a
    extends ap
  {
    private WeakReference<c.a> mNy;
    
    public a(com.tencent.e.j.a parama, c.a parama1)
    {
      super();
      AppMethodBeat.i(179584);
      this.mNy = null;
      this.mNy = new WeakReference(parama1);
      AppMethodBeat.o(179584);
    }
    
    /* Error */
    public final void handleMessage(android.os.Message paramMessage)
    {
      // Byte code:
      //   0: sipush 22597
      //   3: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   6: aload_0
      //   7: getfield 26	com/tencent/mm/plugin/d/a/c/c$a$a:mNy	Ljava/lang/ref/WeakReference;
      //   10: invokevirtual 45	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
      //   13: checkcast 6	com/tencent/mm/plugin/d/a/c/c$a
      //   16: astore_2
      //   17: aload_2
      //   18: ifnonnull +17 -> 35
      //   21: ldc 47
      //   23: ldc 49
      //   25: invokestatic 55	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   28: sipush 22597
      //   31: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   34: return
      //   35: aload_1
      //   36: getfield 61	android/os/Message:what	I
      //   39: tableswitch	default:+21 -> 60, 0:+28->67, 1:+396->435
      //   61: pop2
      //   62: fstore_2
      //   63: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   66: return
      //   67: ldc 63
      //   69: ldc 65
      //   71: invokestatic 67	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   74: aload_2
      //   75: getfield 71	com/tencent/mm/plugin/d/a/c/c$a:mQa	Z
      //   78: ifeq +17 -> 95
      //   81: ldc 63
      //   83: ldc 73
      //   85: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   88: sipush 22597
      //   91: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   94: return
      //   95: aload_2
      //   96: getfield 79	com/tencent/mm/plugin/d/a/c/c$a:mPX	Z
      //   99: ifeq +183 -> 282
      //   102: aload_2
      //   103: aload_2
      //   104: getfield 83	com/tencent/mm/plugin/d/a/c/c$a:mQb	Landroid/bluetooth/BluetoothDevice;
      //   107: getstatic 89	com/tencent/mm/plugin/d/a/c/a:mPM	Ljava/util/UUID;
      //   110: invokevirtual 95	android/bluetooth/BluetoothDevice:createRfcommSocketToServiceRecord	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
      //   113: putfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   116: aload_2
      //   117: getfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   120: invokevirtual 105	android/bluetooth/BluetoothSocket:connect	()V
      //   123: aload_2
      //   124: iconst_1
      //   125: putfield 71	com/tencent/mm/plugin/d/a/c/c$a:mQa	Z
      //   128: aload_2
      //   129: getfield 109	com/tencent/mm/plugin/d/a/c/c$a:mPY	Lcom/tencent/mm/plugin/d/a/c/b;
      //   132: astore_1
      //   133: aload_2
      //   134: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   137: astore_3
      //   138: aload_2
      //   139: getfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   142: astore 4
      //   144: ldc 115
      //   146: ldc 117
      //   148: invokestatic 67	com/tencent/mm/sdk/platformtools/ad:i	(Ljava/lang/String;Ljava/lang/String;)V
      //   151: aload_1
      //   152: iconst_3
      //   153: putfield 122	com/tencent/mm/plugin/d/a/c/b:mState	I
      //   156: aload_1
      //   157: getfield 126	com/tencent/mm/plugin/d/a/c/b:mPU	Lcom/tencent/mm/plugin/d/a/c/c$b;
      //   160: ifnull +15 -> 175
      //   163: aload_1
      //   164: getfield 126	com/tencent/mm/plugin/d/a/c/b:mPU	Lcom/tencent/mm/plugin/d/a/c/c$b;
      //   167: invokevirtual 131	com/tencent/mm/plugin/d/a/c/c$b:cancel	()V
      //   170: aload_1
      //   171: aconst_null
      //   172: putfield 126	com/tencent/mm/plugin/d/a/c/b:mPU	Lcom/tencent/mm/plugin/d/a/c/c$b;
      //   175: aload_1
      //   176: getfield 135	com/tencent/mm/plugin/d/a/c/b:mPV	Lcom/tencent/mm/plugin/d/a/c/c$c;
      //   179: ifnull +15 -> 194
      //   182: aload_1
      //   183: getfield 135	com/tencent/mm/plugin/d/a/c/b:mPV	Lcom/tencent/mm/plugin/d/a/c/c$c;
      //   186: invokevirtual 138	com/tencent/mm/plugin/d/a/c/c$c:cancel	()V
      //   189: aload_1
      //   190: aconst_null
      //   191: putfield 135	com/tencent/mm/plugin/d/a/c/b:mPV	Lcom/tencent/mm/plugin/d/a/c/c$c;
      //   194: aload_1
      //   195: new 128	com/tencent/mm/plugin/d/a/c/c$b
      //   198: dup
      //   199: aload_1
      //   200: aload_3
      //   201: aload 4
      //   203: invokespecial 141	com/tencent/mm/plugin/d/a/c/c$b:<init>	(Lcom/tencent/mm/plugin/d/a/c/b;Lcom/tencent/mm/plugin/d/a/c/a;Landroid/bluetooth/BluetoothSocket;)V
      //   206: putfield 126	com/tencent/mm/plugin/d/a/c/b:mPU	Lcom/tencent/mm/plugin/d/a/c/c$b;
      //   209: getstatic 147	com/tencent/e/h:Iye	Lcom/tencent/e/i;
      //   212: aload_1
      //   213: getfield 126	com/tencent/mm/plugin/d/a/c/b:mPU	Lcom/tencent/mm/plugin/d/a/c/c$b;
      //   216: invokeinterface 153 2 0
      //   221: pop
      //   222: aload_1
      //   223: new 137	com/tencent/mm/plugin/d/a/c/c$c
      //   226: dup
      //   227: aload_1
      //   228: aload_3
      //   229: aload 4
      //   231: invokespecial 154	com/tencent/mm/plugin/d/a/c/c$c:<init>	(Lcom/tencent/mm/plugin/d/a/c/b;Lcom/tencent/mm/plugin/d/a/c/a;Landroid/bluetooth/BluetoothSocket;)V
      //   234: putfield 135	com/tencent/mm/plugin/d/a/c/b:mPV	Lcom/tencent/mm/plugin/d/a/c/c$c;
      //   237: getstatic 147	com/tencent/e/h:Iye	Lcom/tencent/e/i;
      //   240: aload_1
      //   241: getfield 135	com/tencent/mm/plugin/d/a/c/b:mPV	Lcom/tencent/mm/plugin/d/a/c/c$c;
      //   244: invokeinterface 153 2 0
      //   249: pop
      //   250: aload_2
      //   251: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   254: ifnull +21 -> 275
      //   257: aload_2
      //   258: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   261: getfield 158	com/tencent/mm/plugin/d/a/c/a:mPO	Lcom/tencent/mm/plugin/d/a/c/a$a;
      //   264: aload_2
      //   265: getfield 109	com/tencent/mm/plugin/d/a/c/c$a:mPY	Lcom/tencent/mm/plugin/d/a/c/b;
      //   268: getfield 162	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
      //   271: iconst_1
      //   272: invokevirtual 168	com/tencent/mm/plugin/d/a/c/a$a:k	(JZ)V
      //   275: sipush 22597
      //   278: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   281: return
      //   282: aload_2
      //   283: aload_2
      //   284: getfield 83	com/tencent/mm/plugin/d/a/c/c$a:mQb	Landroid/bluetooth/BluetoothDevice;
      //   287: getstatic 171	com/tencent/mm/plugin/d/a/c/a:mPN	Ljava/util/UUID;
      //   290: invokevirtual 174	android/bluetooth/BluetoothDevice:createInsecureRfcommSocketToServiceRecord	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
      //   293: putfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   296: goto -180 -> 116
      //   299: astore_1
      //   300: aload_2
      //   301: aconst_null
      //   302: putfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   305: ldc 63
      //   307: ldc 176
      //   309: iconst_1
      //   310: anewarray 178	java/lang/Object
      //   313: dup
      //   314: iconst_0
      //   315: aload_1
      //   316: invokevirtual 182	java/io/IOException:toString	()Ljava/lang/String;
      //   319: aastore
      //   320: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   323: aload_2
      //   324: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   327: ifnull +21 -> 348
      //   330: aload_2
      //   331: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   334: getfield 158	com/tencent/mm/plugin/d/a/c/a:mPO	Lcom/tencent/mm/plugin/d/a/c/a$a;
      //   337: aload_2
      //   338: getfield 109	com/tencent/mm/plugin/d/a/c/c$a:mPY	Lcom/tencent/mm/plugin/d/a/c/b;
      //   341: getfield 162	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
      //   344: iconst_0
      //   345: invokevirtual 168	com/tencent/mm/plugin/d/a/c/a$a:k	(JZ)V
      //   348: sipush 22597
      //   351: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   354: return
      //   355: astore_1
      //   356: ldc 63
      //   358: ldc 187
      //   360: iconst_1
      //   361: anewarray 178	java/lang/Object
      //   364: dup
      //   365: iconst_0
      //   366: aload_1
      //   367: invokevirtual 188	java/lang/Exception:toString	()Ljava/lang/String;
      //   370: aastore
      //   371: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   374: aload_2
      //   375: getfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   378: invokevirtual 191	android/bluetooth/BluetoothSocket:close	()V
      //   381: aload_2
      //   382: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   385: ifnull +21 -> 406
      //   388: aload_2
      //   389: getfield 113	com/tencent/mm/plugin/d/a/c/c$a:mPZ	Lcom/tencent/mm/plugin/d/a/c/a;
      //   392: getfield 158	com/tencent/mm/plugin/d/a/c/a:mPO	Lcom/tencent/mm/plugin/d/a/c/a$a;
      //   395: aload_2
      //   396: getfield 109	com/tencent/mm/plugin/d/a/c/c$a:mPY	Lcom/tencent/mm/plugin/d/a/c/b;
      //   399: getfield 162	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
      //   402: iconst_0
      //   403: invokevirtual 168	com/tencent/mm/plugin/d/a/c/a$a:k	(JZ)V
      //   406: sipush 22597
      //   409: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   412: return
      //   413: astore_1
      //   414: ldc 63
      //   416: ldc 193
      //   418: iconst_1
      //   419: anewarray 178	java/lang/Object
      //   422: dup
      //   423: iconst_0
      //   424: aload_1
      //   425: invokevirtual 182	java/io/IOException:toString	()Ljava/lang/String;
      //   428: aastore
      //   429: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   432: goto -51 -> 381
      //   435: aload_2
      //   436: getfield 71	com/tencent/mm/plugin/d/a/c/c$a:mQa	Z
      //   439: ifne +17 -> 456
      //   442: ldc 63
      //   444: ldc 195
      //   446: invokestatic 76	com/tencent/mm/sdk/platformtools/ad:w	(Ljava/lang/String;Ljava/lang/String;)V
      //   449: sipush 22597
      //   452: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   455: return
      //   456: aload_2
      //   457: getfield 99	com/tencent/mm/plugin/d/a/c/c$a:mPW	Landroid/bluetooth/BluetoothSocket;
      //   460: invokevirtual 191	android/bluetooth/BluetoothSocket:close	()V
      //   463: sipush 22597
      //   466: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   469: return
      //   470: astore_1
      //   471: ldc 63
      //   473: ldc 197
      //   475: iconst_1
      //   476: anewarray 178	java/lang/Object
      //   479: dup
      //   480: iconst_0
      //   481: aload_1
      //   482: invokevirtual 182	java/io/IOException:toString	()Ljava/lang/String;
      //   485: aastore
      //   486: invokestatic 185	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   489: goto -429 -> 60
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	492	0	this	a
      //   0	492	1	paramMessage	android.os.Message
      //   16	441	2	locala	c.a
      //   137	92	3	locala1	a
      //   142	88	4	localBluetoothSocket	BluetoothSocket
      // Exception table:
      //   from	to	target	type
      //   95	116	299	java/io/IOException
      //   282	296	299	java/io/IOException
      //   116	123	355	java/lang/Exception
      //   374	381	413	java/io/IOException
      //   456	463	470	java/io/IOException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.c.a
 * JD-Core Version:    0.7.0.1
 */
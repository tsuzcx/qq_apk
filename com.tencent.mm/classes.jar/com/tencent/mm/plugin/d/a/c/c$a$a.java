package com.tencent.mm.plugin.d.a.c;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class c$a$a
  extends ak
{
  private WeakReference<c.a> jOv;
  
  public c$a$a(Looper paramLooper, c.a parama)
  {
    super(paramLooper);
    AppMethodBeat.i(18485);
    this.jOv = null;
    this.jOv = new WeakReference(parama);
    AppMethodBeat.o(18485);
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: sipush 18486
    //   3: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 23	com/tencent/mm/plugin/d/a/c/c$a$a:jOv	Ljava/lang/ref/WeakReference;
    //   10: invokevirtual 40	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   13: checkcast 6	com/tencent/mm/plugin/d/a/c/c$a
    //   16: astore_2
    //   17: aload_2
    //   18: ifnonnull +17 -> 35
    //   21: ldc 42
    //   23: ldc 44
    //   25: invokestatic 50	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: sipush 18486
    //   31: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: return
    //   35: aload_1
    //   36: getfield 56	android/os/Message:what	I
    //   39: tableswitch	default:+21 -> 60, 0:+28->67, 1:+394->433
    //   61: dstore_1
    //   62: istore 184
    //   64: nop
    //   65: lload_1
    //   66: return
    //   67: ldc 58
    //   69: ldc 60
    //   71: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   74: aload_2
    //   75: getfield 66	com/tencent/mm/plugin/d/a/c/c$a:jQX	Z
    //   78: ifeq +17 -> 95
    //   81: ldc 58
    //   83: ldc 68
    //   85: invokestatic 71	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   88: sipush 18486
    //   91: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: aload_2
    //   96: getfield 74	com/tencent/mm/plugin/d/a/c/c$a:jQU	Z
    //   99: ifeq +181 -> 280
    //   102: aload_2
    //   103: aload_2
    //   104: getfield 78	com/tencent/mm/plugin/d/a/c/c$a:jQY	Landroid/bluetooth/BluetoothDevice;
    //   107: getstatic 84	com/tencent/mm/plugin/d/a/c/a:jQJ	Ljava/util/UUID;
    //   110: invokevirtual 90	android/bluetooth/BluetoothDevice:createRfcommSocketToServiceRecord	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
    //   113: putfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   116: aload_2
    //   117: getfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   120: invokevirtual 100	android/bluetooth/BluetoothSocket:connect	()V
    //   123: aload_2
    //   124: iconst_1
    //   125: putfield 66	com/tencent/mm/plugin/d/a/c/c$a:jQX	Z
    //   128: aload_2
    //   129: getfield 104	com/tencent/mm/plugin/d/a/c/c$a:jQV	Lcom/tencent/mm/plugin/d/a/c/b;
    //   132: astore_1
    //   133: aload_2
    //   134: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   137: astore_3
    //   138: aload_2
    //   139: getfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   142: astore 4
    //   144: ldc 110
    //   146: ldc 112
    //   148: invokestatic 62	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   151: aload_1
    //   152: iconst_3
    //   153: putfield 117	com/tencent/mm/plugin/d/a/c/b:mState	I
    //   156: aload_1
    //   157: getfield 121	com/tencent/mm/plugin/d/a/c/b:jQR	Lcom/tencent/mm/plugin/d/a/c/c$b;
    //   160: ifnull +15 -> 175
    //   163: aload_1
    //   164: getfield 121	com/tencent/mm/plugin/d/a/c/b:jQR	Lcom/tencent/mm/plugin/d/a/c/c$b;
    //   167: invokevirtual 126	com/tencent/mm/plugin/d/a/c/c$b:cancel	()V
    //   170: aload_1
    //   171: aconst_null
    //   172: putfield 121	com/tencent/mm/plugin/d/a/c/b:jQR	Lcom/tencent/mm/plugin/d/a/c/c$b;
    //   175: aload_1
    //   176: getfield 130	com/tencent/mm/plugin/d/a/c/b:jQS	Lcom/tencent/mm/plugin/d/a/c/c$c;
    //   179: ifnull +15 -> 194
    //   182: aload_1
    //   183: getfield 130	com/tencent/mm/plugin/d/a/c/b:jQS	Lcom/tencent/mm/plugin/d/a/c/c$c;
    //   186: invokevirtual 133	com/tencent/mm/plugin/d/a/c/c$c:cancel	()V
    //   189: aload_1
    //   190: aconst_null
    //   191: putfield 130	com/tencent/mm/plugin/d/a/c/b:jQS	Lcom/tencent/mm/plugin/d/a/c/c$c;
    //   194: aload_1
    //   195: new 123	com/tencent/mm/plugin/d/a/c/c$b
    //   198: dup
    //   199: aload_1
    //   200: aload_3
    //   201: aload 4
    //   203: invokespecial 136	com/tencent/mm/plugin/d/a/c/c$b:<init>	(Lcom/tencent/mm/plugin/d/a/c/b;Lcom/tencent/mm/plugin/d/a/c/a;Landroid/bluetooth/BluetoothSocket;)V
    //   206: putfield 121	com/tencent/mm/plugin/d/a/c/b:jQR	Lcom/tencent/mm/plugin/d/a/c/c$b;
    //   209: aload_1
    //   210: getfield 121	com/tencent/mm/plugin/d/a/c/b:jQR	Lcom/tencent/mm/plugin/d/a/c/c$b;
    //   213: ldc 138
    //   215: invokestatic 144	com/tencent/mm/sdk/g/d:h	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   218: invokevirtual 149	java/lang/Thread:start	()V
    //   221: aload_1
    //   222: new 132	com/tencent/mm/plugin/d/a/c/c$c
    //   225: dup
    //   226: aload_1
    //   227: aload_3
    //   228: aload 4
    //   230: invokespecial 150	com/tencent/mm/plugin/d/a/c/c$c:<init>	(Lcom/tencent/mm/plugin/d/a/c/b;Lcom/tencent/mm/plugin/d/a/c/a;Landroid/bluetooth/BluetoothSocket;)V
    //   233: putfield 130	com/tencent/mm/plugin/d/a/c/b:jQS	Lcom/tencent/mm/plugin/d/a/c/c$c;
    //   236: aload_1
    //   237: getfield 130	com/tencent/mm/plugin/d/a/c/b:jQS	Lcom/tencent/mm/plugin/d/a/c/c$c;
    //   240: ldc 152
    //   242: invokestatic 144	com/tencent/mm/sdk/g/d:h	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   245: invokevirtual 149	java/lang/Thread:start	()V
    //   248: aload_2
    //   249: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   252: ifnull +21 -> 273
    //   255: aload_2
    //   256: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   259: getfield 156	com/tencent/mm/plugin/d/a/c/a:jQL	Lcom/tencent/mm/plugin/d/a/c/a$a;
    //   262: aload_2
    //   263: getfield 104	com/tencent/mm/plugin/d/a/c/c$a:jQV	Lcom/tencent/mm/plugin/d/a/c/b;
    //   266: getfield 160	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
    //   269: iconst_1
    //   270: invokevirtual 166	com/tencent/mm/plugin/d/a/c/a$a:l	(JZ)V
    //   273: sipush 18486
    //   276: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: return
    //   280: aload_2
    //   281: aload_2
    //   282: getfield 78	com/tencent/mm/plugin/d/a/c/c$a:jQY	Landroid/bluetooth/BluetoothDevice;
    //   285: getstatic 169	com/tencent/mm/plugin/d/a/c/a:jQK	Ljava/util/UUID;
    //   288: invokevirtual 172	android/bluetooth/BluetoothDevice:createInsecureRfcommSocketToServiceRecord	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
    //   291: putfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   294: goto -178 -> 116
    //   297: astore_1
    //   298: aload_2
    //   299: aconst_null
    //   300: putfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   303: ldc 58
    //   305: ldc 174
    //   307: iconst_1
    //   308: anewarray 176	java/lang/Object
    //   311: dup
    //   312: iconst_0
    //   313: aload_1
    //   314: invokevirtual 180	java/io/IOException:toString	()Ljava/lang/String;
    //   317: aastore
    //   318: invokestatic 183	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   321: aload_2
    //   322: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   325: ifnull +21 -> 346
    //   328: aload_2
    //   329: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   332: getfield 156	com/tencent/mm/plugin/d/a/c/a:jQL	Lcom/tencent/mm/plugin/d/a/c/a$a;
    //   335: aload_2
    //   336: getfield 104	com/tencent/mm/plugin/d/a/c/c$a:jQV	Lcom/tencent/mm/plugin/d/a/c/b;
    //   339: getfield 160	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
    //   342: iconst_0
    //   343: invokevirtual 166	com/tencent/mm/plugin/d/a/c/a$a:l	(JZ)V
    //   346: sipush 18486
    //   349: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   352: return
    //   353: astore_1
    //   354: ldc 58
    //   356: ldc 185
    //   358: iconst_1
    //   359: anewarray 176	java/lang/Object
    //   362: dup
    //   363: iconst_0
    //   364: aload_1
    //   365: invokevirtual 180	java/io/IOException:toString	()Ljava/lang/String;
    //   368: aastore
    //   369: invokestatic 183	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   372: aload_2
    //   373: getfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   376: invokevirtual 188	android/bluetooth/BluetoothSocket:close	()V
    //   379: aload_2
    //   380: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   383: ifnull +21 -> 404
    //   386: aload_2
    //   387: getfield 108	com/tencent/mm/plugin/d/a/c/c$a:jQW	Lcom/tencent/mm/plugin/d/a/c/a;
    //   390: getfield 156	com/tencent/mm/plugin/d/a/c/a:jQL	Lcom/tencent/mm/plugin/d/a/c/a$a;
    //   393: aload_2
    //   394: getfield 104	com/tencent/mm/plugin/d/a/c/c$a:jQV	Lcom/tencent/mm/plugin/d/a/c/b;
    //   397: getfield 160	com/tencent/mm/plugin/d/a/c/b:mSessionId	J
    //   400: iconst_0
    //   401: invokevirtual 166	com/tencent/mm/plugin/d/a/c/a$a:l	(JZ)V
    //   404: sipush 18486
    //   407: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   410: return
    //   411: astore_1
    //   412: ldc 58
    //   414: ldc 190
    //   416: iconst_1
    //   417: anewarray 176	java/lang/Object
    //   420: dup
    //   421: iconst_0
    //   422: aload_1
    //   423: invokevirtual 180	java/io/IOException:toString	()Ljava/lang/String;
    //   426: aastore
    //   427: invokestatic 183	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   430: goto -51 -> 379
    //   433: aload_2
    //   434: getfield 66	com/tencent/mm/plugin/d/a/c/c$a:jQX	Z
    //   437: ifne +17 -> 454
    //   440: ldc 58
    //   442: ldc 192
    //   444: invokestatic 71	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   447: sipush 18486
    //   450: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   453: return
    //   454: aload_2
    //   455: getfield 94	com/tencent/mm/plugin/d/a/c/c$a:jQT	Landroid/bluetooth/BluetoothSocket;
    //   458: invokevirtual 188	android/bluetooth/BluetoothSocket:close	()V
    //   461: sipush 18486
    //   464: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   467: return
    //   468: astore_1
    //   469: ldc 58
    //   471: ldc 194
    //   473: iconst_1
    //   474: anewarray 176	java/lang/Object
    //   477: dup
    //   478: iconst_0
    //   479: aload_1
    //   480: invokevirtual 180	java/io/IOException:toString	()Ljava/lang/String;
    //   483: aastore
    //   484: invokestatic 183	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   487: goto -427 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	a
    //   0	490	1	paramMessage	android.os.Message
    //   16	439	2	locala	c.a
    //   137	91	3	locala1	a
    //   142	87	4	localBluetoothSocket	android.bluetooth.BluetoothSocket
    // Exception table:
    //   from	to	target	type
    //   95	116	297	java/io/IOException
    //   280	294	297	java/io/IOException
    //   116	123	353	java/io/IOException
    //   372	379	411	java/io/IOException
    //   454	461	468	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.d.a.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */
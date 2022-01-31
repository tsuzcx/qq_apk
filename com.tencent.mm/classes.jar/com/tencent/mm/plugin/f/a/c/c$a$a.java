package com.tencent.mm.plugin.f.a.c;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;

final class c$a$a
  extends ah
{
  private WeakReference<c.a> hUB = null;
  
  public c$a$a(Looper paramLooper, c.a parama)
  {
    super(paramLooper);
    this.hUB = new WeakReference(parama);
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 17	com/tencent/mm/plugin/f/a/c/c$a$a:hUB	Ljava/lang/ref/WeakReference;
    //   4: invokevirtual 31	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   7: checkcast 6	com/tencent/mm/plugin/f/a/c/c$a
    //   10: astore_2
    //   11: aload_2
    //   12: ifnonnull +11 -> 23
    //   15: ldc 33
    //   17: ldc 35
    //   19: invokestatic 41	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: return
    //   23: aload_1
    //   24: getfield 47	android/os/Message:what	I
    //   27: tableswitch	default:+21 -> 48, 0:+22->49, 1:+364->391
    //   49: ldc 49
    //   51: ldc 51
    //   53: invokestatic 54	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   56: aload_2
    //   57: getfield 58	com/tencent/mm/plugin/f/a/c/c$a:hXe	Z
    //   60: ifeq +11 -> 71
    //   63: ldc 49
    //   65: ldc 60
    //   67: invokestatic 63	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   70: return
    //   71: aload_2
    //   72: getfield 66	com/tencent/mm/plugin/f/a/c/c$a:hXb	Z
    //   75: ifeq +175 -> 250
    //   78: aload_2
    //   79: aload_2
    //   80: getfield 70	com/tencent/mm/plugin/f/a/c/c$a:hXf	Landroid/bluetooth/BluetoothDevice;
    //   83: getstatic 76	com/tencent/mm/plugin/f/a/c/a:hWQ	Ljava/util/UUID;
    //   86: invokevirtual 82	android/bluetooth/BluetoothDevice:createRfcommSocketToServiceRecord	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
    //   89: putfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   92: aload_2
    //   93: getfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   96: invokevirtual 92	android/bluetooth/BluetoothSocket:connect	()V
    //   99: aload_2
    //   100: iconst_1
    //   101: putfield 58	com/tencent/mm/plugin/f/a/c/c$a:hXe	Z
    //   104: aload_2
    //   105: getfield 96	com/tencent/mm/plugin/f/a/c/c$a:hXc	Lcom/tencent/mm/plugin/f/a/c/b;
    //   108: astore_1
    //   109: aload_2
    //   110: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   113: astore_3
    //   114: aload_2
    //   115: getfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   118: astore 4
    //   120: ldc 102
    //   122: ldc 104
    //   124: invokestatic 54	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_1
    //   128: iconst_3
    //   129: putfield 109	com/tencent/mm/plugin/f/a/c/b:mState	I
    //   132: aload_1
    //   133: getfield 113	com/tencent/mm/plugin/f/a/c/b:hWY	Lcom/tencent/mm/plugin/f/a/c/c$b;
    //   136: ifnull +15 -> 151
    //   139: aload_1
    //   140: getfield 113	com/tencent/mm/plugin/f/a/c/b:hWY	Lcom/tencent/mm/plugin/f/a/c/c$b;
    //   143: invokevirtual 118	com/tencent/mm/plugin/f/a/c/c$b:cancel	()V
    //   146: aload_1
    //   147: aconst_null
    //   148: putfield 113	com/tencent/mm/plugin/f/a/c/b:hWY	Lcom/tencent/mm/plugin/f/a/c/c$b;
    //   151: aload_1
    //   152: getfield 122	com/tencent/mm/plugin/f/a/c/b:hWZ	Lcom/tencent/mm/plugin/f/a/c/c$c;
    //   155: ifnull +15 -> 170
    //   158: aload_1
    //   159: getfield 122	com/tencent/mm/plugin/f/a/c/b:hWZ	Lcom/tencent/mm/plugin/f/a/c/c$c;
    //   162: invokevirtual 125	com/tencent/mm/plugin/f/a/c/c$c:cancel	()V
    //   165: aload_1
    //   166: aconst_null
    //   167: putfield 122	com/tencent/mm/plugin/f/a/c/b:hWZ	Lcom/tencent/mm/plugin/f/a/c/c$c;
    //   170: aload_1
    //   171: new 115	com/tencent/mm/plugin/f/a/c/c$b
    //   174: dup
    //   175: aload_1
    //   176: aload_3
    //   177: aload 4
    //   179: invokespecial 128	com/tencent/mm/plugin/f/a/c/c$b:<init>	(Lcom/tencent/mm/plugin/f/a/c/b;Lcom/tencent/mm/plugin/f/a/c/a;Landroid/bluetooth/BluetoothSocket;)V
    //   182: putfield 113	com/tencent/mm/plugin/f/a/c/b:hWY	Lcom/tencent/mm/plugin/f/a/c/c$b;
    //   185: aload_1
    //   186: getfield 113	com/tencent/mm/plugin/f/a/c/b:hWY	Lcom/tencent/mm/plugin/f/a/c/c$b;
    //   189: ldc 130
    //   191: invokestatic 136	com/tencent/mm/sdk/f/e:b	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   194: invokevirtual 141	java/lang/Thread:start	()V
    //   197: aload_1
    //   198: new 124	com/tencent/mm/plugin/f/a/c/c$c
    //   201: dup
    //   202: aload_1
    //   203: aload_3
    //   204: aload 4
    //   206: invokespecial 142	com/tencent/mm/plugin/f/a/c/c$c:<init>	(Lcom/tencent/mm/plugin/f/a/c/b;Lcom/tencent/mm/plugin/f/a/c/a;Landroid/bluetooth/BluetoothSocket;)V
    //   209: putfield 122	com/tencent/mm/plugin/f/a/c/b:hWZ	Lcom/tencent/mm/plugin/f/a/c/c$c;
    //   212: aload_1
    //   213: getfield 122	com/tencent/mm/plugin/f/a/c/b:hWZ	Lcom/tencent/mm/plugin/f/a/c/c$c;
    //   216: ldc 144
    //   218: invokestatic 136	com/tencent/mm/sdk/f/e:b	(Ljava/lang/Runnable;Ljava/lang/String;)Ljava/lang/Thread;
    //   221: invokevirtual 141	java/lang/Thread:start	()V
    //   224: aload_2
    //   225: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   228: ifnull -206 -> 22
    //   231: aload_2
    //   232: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   235: getfield 148	com/tencent/mm/plugin/f/a/c/a:hWS	Lcom/tencent/mm/plugin/f/a/c/a$a;
    //   238: aload_2
    //   239: getfield 96	com/tencent/mm/plugin/f/a/c/c$a:hXc	Lcom/tencent/mm/plugin/f/a/c/b;
    //   242: getfield 152	com/tencent/mm/plugin/f/a/c/b:mSessionId	J
    //   245: iconst_1
    //   246: invokevirtual 157	com/tencent/mm/plugin/f/a/c/a$a:i	(JZ)V
    //   249: return
    //   250: aload_2
    //   251: aload_2
    //   252: getfield 70	com/tencent/mm/plugin/f/a/c/c$a:hXf	Landroid/bluetooth/BluetoothDevice;
    //   255: getstatic 160	com/tencent/mm/plugin/f/a/c/a:hWR	Ljava/util/UUID;
    //   258: invokevirtual 163	android/bluetooth/BluetoothDevice:createInsecureRfcommSocketToServiceRecord	(Ljava/util/UUID;)Landroid/bluetooth/BluetoothSocket;
    //   261: putfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   264: goto -172 -> 92
    //   267: astore_1
    //   268: aload_2
    //   269: aconst_null
    //   270: putfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   273: ldc 49
    //   275: ldc 165
    //   277: iconst_1
    //   278: anewarray 167	java/lang/Object
    //   281: dup
    //   282: iconst_0
    //   283: aload_1
    //   284: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   287: aastore
    //   288: invokestatic 174	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   291: aload_2
    //   292: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   295: ifnull -273 -> 22
    //   298: aload_2
    //   299: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   302: getfield 148	com/tencent/mm/plugin/f/a/c/a:hWS	Lcom/tencent/mm/plugin/f/a/c/a$a;
    //   305: aload_2
    //   306: getfield 96	com/tencent/mm/plugin/f/a/c/c$a:hXc	Lcom/tencent/mm/plugin/f/a/c/b;
    //   309: getfield 152	com/tencent/mm/plugin/f/a/c/b:mSessionId	J
    //   312: iconst_0
    //   313: invokevirtual 157	com/tencent/mm/plugin/f/a/c/a$a:i	(JZ)V
    //   316: return
    //   317: astore_1
    //   318: ldc 49
    //   320: ldc 176
    //   322: iconst_1
    //   323: anewarray 167	java/lang/Object
    //   326: dup
    //   327: iconst_0
    //   328: aload_1
    //   329: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   332: aastore
    //   333: invokestatic 174	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   336: aload_2
    //   337: getfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   340: invokevirtual 179	android/bluetooth/BluetoothSocket:close	()V
    //   343: aload_2
    //   344: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   347: ifnull -325 -> 22
    //   350: aload_2
    //   351: getfield 100	com/tencent/mm/plugin/f/a/c/c$a:hXd	Lcom/tencent/mm/plugin/f/a/c/a;
    //   354: getfield 148	com/tencent/mm/plugin/f/a/c/a:hWS	Lcom/tencent/mm/plugin/f/a/c/a$a;
    //   357: aload_2
    //   358: getfield 96	com/tencent/mm/plugin/f/a/c/c$a:hXc	Lcom/tencent/mm/plugin/f/a/c/b;
    //   361: getfield 152	com/tencent/mm/plugin/f/a/c/b:mSessionId	J
    //   364: iconst_0
    //   365: invokevirtual 157	com/tencent/mm/plugin/f/a/c/a$a:i	(JZ)V
    //   368: return
    //   369: astore_1
    //   370: ldc 49
    //   372: ldc 181
    //   374: iconst_1
    //   375: anewarray 167	java/lang/Object
    //   378: dup
    //   379: iconst_0
    //   380: aload_1
    //   381: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   384: aastore
    //   385: invokestatic 174	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   388: goto -45 -> 343
    //   391: aload_2
    //   392: getfield 58	com/tencent/mm/plugin/f/a/c/c$a:hXe	Z
    //   395: ifne +11 -> 406
    //   398: ldc 49
    //   400: ldc 183
    //   402: invokestatic 63	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: return
    //   406: aload_2
    //   407: getfield 86	com/tencent/mm/plugin/f/a/c/c$a:hXa	Landroid/bluetooth/BluetoothSocket;
    //   410: invokevirtual 179	android/bluetooth/BluetoothSocket:close	()V
    //   413: return
    //   414: astore_1
    //   415: ldc 49
    //   417: ldc 185
    //   419: iconst_1
    //   420: anewarray 167	java/lang/Object
    //   423: dup
    //   424: iconst_0
    //   425: aload_1
    //   426: invokevirtual 171	java/io/IOException:toString	()Ljava/lang/String;
    //   429: aastore
    //   430: invokestatic 174	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   433: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	434	0	this	a
    //   0	434	1	paramMessage	android.os.Message
    //   10	397	2	locala	c.a
    //   113	91	3	locala1	a
    //   118	87	4	localBluetoothSocket	android.bluetooth.BluetoothSocket
    // Exception table:
    //   from	to	target	type
    //   71	92	267	java/io/IOException
    //   250	264	267	java/io/IOException
    //   92	99	317	java/io/IOException
    //   336	343	369	java/io/IOException
    //   406	413	414	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.f.a.c.c.a.a
 * JD-Core Version:    0.7.0.1
 */
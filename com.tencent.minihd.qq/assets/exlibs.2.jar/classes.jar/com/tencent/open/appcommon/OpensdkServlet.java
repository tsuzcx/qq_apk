package com.tencent.open.appcommon;

import android.content.Intent;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class OpensdkServlet
  extends MSFServlet
{
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: new 15	android/os/Bundle
    //   3: dup
    //   4: invokespecial 16	android/os/Bundle:<init>	()V
    //   7: astore 4
    //   9: aload_2
    //   10: invokevirtual 22	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   13: astore 7
    //   15: aload 7
    //   17: ifnull +96 -> 113
    //   20: aload 7
    //   22: arraylength
    //   23: iconst_4
    //   24: if_icmple +89 -> 113
    //   27: new 24	java/io/ByteArrayInputStream
    //   30: dup
    //   31: aload 7
    //   33: invokespecial 27	java/io/ByteArrayInputStream:<init>	([B)V
    //   36: astore 5
    //   38: new 29	java/io/DataInputStream
    //   41: dup
    //   42: aload 5
    //   44: invokespecial 32	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   47: astore 6
    //   49: aload 6
    //   51: invokevirtual 36	java/io/DataInputStream:readInt	()I
    //   54: iconst_4
    //   55: isub
    //   56: istore_3
    //   57: iload_3
    //   58: newarray byte
    //   60: astore 8
    //   62: aload 7
    //   64: iconst_4
    //   65: aload 8
    //   67: iconst_0
    //   68: iload_3
    //   69: invokestatic 42	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   72: aload 4
    //   74: ldc 44
    //   76: aload 8
    //   78: invokevirtual 48	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   81: aload 4
    //   83: ldc 50
    //   85: aload_2
    //   86: invokevirtual 53	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   89: invokevirtual 57	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   92: aload 4
    //   94: ldc 59
    //   96: aload_2
    //   97: invokevirtual 63	com/tencent/qphone/base/remote/FromServiceMsg:getUin	()Ljava/lang/String;
    //   100: invokevirtual 67	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload 5
    //   105: invokevirtual 70	java/io/ByteArrayInputStream:close	()V
    //   108: aload 6
    //   110: invokevirtual 71	java/io/DataInputStream:close	()V
    //   113: aload_0
    //   114: aload_1
    //   115: iconst_0
    //   116: aload_2
    //   117: invokevirtual 75	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   120: aload 4
    //   122: ldc 77
    //   124: invokevirtual 81	com/tencent/open/appcommon/OpensdkServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   127: return
    //   128: astore 7
    //   130: aload 5
    //   132: invokevirtual 70	java/io/ByteArrayInputStream:close	()V
    //   135: aload 6
    //   137: invokevirtual 71	java/io/DataInputStream:close	()V
    //   140: goto -27 -> 113
    //   143: astore 5
    //   145: goto -32 -> 113
    //   148: astore_1
    //   149: aload 5
    //   151: invokevirtual 70	java/io/ByteArrayInputStream:close	()V
    //   154: aload 6
    //   156: invokevirtual 71	java/io/DataInputStream:close	()V
    //   159: aload_1
    //   160: athrow
    //   161: astore_2
    //   162: goto -3 -> 159
    //   165: astore 5
    //   167: goto -54 -> 113
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	OpensdkServlet
    //   0	170	1	paramIntent	Intent
    //   0	170	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   56	13	3	i	int
    //   7	114	4	localBundle	android.os.Bundle
    //   36	95	5	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   143	7	5	localException1	java.lang.Exception
    //   165	1	5	localException2	java.lang.Exception
    //   47	108	6	localDataInputStream	java.io.DataInputStream
    //   13	50	7	arrayOfByte1	byte[]
    //   128	1	7	localException3	java.lang.Exception
    //   60	17	8	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   49	103	128	java/lang/Exception
    //   130	140	143	java/lang/Exception
    //   49	103	148	finally
    //   149	159	161	java/lang/Exception
    //   103	113	165	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket) {}
  
  /* Error */
  public void service(Intent paramIntent)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 87	mqq/app/MSFServlet:service	(Landroid/content/Intent;)V
    //   5: aload_1
    //   6: ldc 89
    //   8: invokevirtual 95	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   11: astore_2
    //   12: new 97	com/tencent/qphone/base/remote/ToServiceMsg
    //   15: dup
    //   16: aconst_null
    //   17: aload_1
    //   18: ldc 99
    //   20: invokevirtual 95	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
    //   23: aload_2
    //   24: invokespecial 102	com/tencent/qphone/base/remote/ToServiceMsg:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   27: astore_2
    //   28: aload_1
    //   29: ldc 44
    //   31: invokevirtual 106	android/content/Intent:getByteArrayExtra	(Ljava/lang/String;)[B
    //   34: astore 5
    //   36: new 108	java/io/ByteArrayOutputStream
    //   39: dup
    //   40: aload 5
    //   42: arraylength
    //   43: iconst_4
    //   44: iadd
    //   45: invokespecial 111	java/io/ByteArrayOutputStream:<init>	(I)V
    //   48: astore_3
    //   49: new 113	java/io/DataOutputStream
    //   52: dup
    //   53: aload_3
    //   54: invokespecial 116	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: astore 4
    //   59: aload 4
    //   61: aload 5
    //   63: arraylength
    //   64: iconst_4
    //   65: iadd
    //   66: invokevirtual 119	java/io/DataOutputStream:writeInt	(I)V
    //   69: aload 4
    //   71: aload 5
    //   73: invokevirtual 122	java/io/DataOutputStream:write	([B)V
    //   76: aload_2
    //   77: aload_3
    //   78: invokevirtual 125	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   81: invokevirtual 128	com/tencent/qphone/base/remote/ToServiceMsg:putWupBuffer	([B)V
    //   84: aload_3
    //   85: invokevirtual 129	java/io/ByteArrayOutputStream:close	()V
    //   88: aload 4
    //   90: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   93: aload_2
    //   94: ldc2_w 131
    //   97: invokevirtual 136	com/tencent/qphone/base/remote/ToServiceMsg:setTimeout	(J)V
    //   100: aload_2
    //   101: ldc 138
    //   103: ldc 140
    //   105: invokevirtual 144	com/tencent/qphone/base/remote/ToServiceMsg:addAttribute	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   108: pop
    //   109: aload_0
    //   110: aload_1
    //   111: aload_2
    //   112: invokevirtual 148	com/tencent/open/appcommon/OpensdkServlet:sendToMSF	(Landroid/content/Intent;Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   115: return
    //   116: astore 5
    //   118: aload_3
    //   119: invokevirtual 129	java/io/ByteArrayOutputStream:close	()V
    //   122: aload 4
    //   124: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   127: goto -34 -> 93
    //   130: astore_3
    //   131: goto -38 -> 93
    //   134: astore_1
    //   135: aload_3
    //   136: invokevirtual 129	java/io/ByteArrayOutputStream:close	()V
    //   139: aload 4
    //   141: invokevirtual 130	java/io/DataOutputStream:close	()V
    //   144: aload_1
    //   145: athrow
    //   146: astore_2
    //   147: goto -3 -> 144
    //   150: astore_3
    //   151: goto -58 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	154	0	this	OpensdkServlet
    //   0	154	1	paramIntent	Intent
    //   11	101	2	localObject	java.lang.Object
    //   146	1	2	localException1	java.lang.Exception
    //   48	71	3	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   130	6	3	localException2	java.lang.Exception
    //   150	1	3	localException3	java.lang.Exception
    //   57	83	4	localDataOutputStream	java.io.DataOutputStream
    //   34	38	5	arrayOfByte	byte[]
    //   116	1	5	localException4	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   59	84	116	java/lang/Exception
    //   118	127	130	java/lang/Exception
    //   59	84	134	finally
    //   135	144	146	java/lang/Exception
    //   84	93	150	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.appcommon.OpensdkServlet
 * JD-Core Version:    0.7.0.1
 */
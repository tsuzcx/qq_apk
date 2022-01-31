package com.tencent.map.geolocation.internal;

import android.os.Handler;
import android.os.Looper;
import java.io.File;

final class TencentLogImpl$LogHandler
  extends Handler
{
  private static final String TXWATCHDOG = "txwatchdog";
  private File mDest = makeSureDest();
  
  private TencentLogImpl$LogHandler(TencentLogImpl paramTencentLogImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private File makeSureDest()
  {
    File localFile = TencentLogImpl.access$500(this.this$0);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return new File(localFile, "txwatchdog");
  }
  
  /* Error */
  public final void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokespecial 54	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   5: aload_0
    //   6: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   9: ifnull +18 -> 27
    //   12: ldc 11
    //   14: aload_0
    //   15: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   18: invokevirtual 58	java/io/File:getName	()Ljava/lang/String;
    //   21: invokevirtual 64	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   24: ifne +11 -> 35
    //   27: aload_0
    //   28: aload_0
    //   29: invokespecial 26	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:makeSureDest	()Ljava/io/File;
    //   32: putfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   35: aload_1
    //   36: getfield 70	android/os/Message:obj	Ljava/lang/Object;
    //   39: invokevirtual 75	java/lang/Object:toString	()Ljava/lang/String;
    //   42: ldc 77
    //   44: invokevirtual 81	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   47: invokestatic 87	c/t/m/g/j:c	([B)[B
    //   50: astore 10
    //   52: aload 10
    //   54: arraylength
    //   55: istore 4
    //   57: iload 4
    //   59: newarray byte
    //   61: astore_1
    //   62: aload 10
    //   64: iconst_0
    //   65: aload_1
    //   66: iconst_0
    //   67: iload 4
    //   69: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   72: iload 4
    //   74: iconst_5
    //   75: irem
    //   76: bipush 7
    //   78: iadd
    //   79: istore 5
    //   81: iconst_0
    //   82: istore_2
    //   83: iload 5
    //   85: iconst_1
    //   86: ishl
    //   87: iload_2
    //   88: iadd
    //   89: iload 4
    //   91: if_icmpge +17 -> 108
    //   94: iload_2
    //   95: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: invokevirtual 103	java/lang/Integer:byteValue	()B
    //   101: istore 6
    //   103: iconst_0
    //   104: istore_3
    //   105: goto +239 -> 344
    //   108: iload 4
    //   110: iconst_4
    //   111: iadd
    //   112: newarray byte
    //   114: astore 11
    //   116: aload_1
    //   117: arraylength
    //   118: istore_2
    //   119: aload 11
    //   121: iconst_0
    //   122: iload_2
    //   123: bipush 8
    //   125: ishr
    //   126: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: invokevirtual 103	java/lang/Integer:byteValue	()B
    //   132: bastore
    //   133: aload 11
    //   135: iconst_1
    //   136: iload_2
    //   137: bipush 24
    //   139: ishr
    //   140: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   143: invokevirtual 103	java/lang/Integer:byteValue	()B
    //   146: bastore
    //   147: aload 11
    //   149: iconst_2
    //   150: iload_2
    //   151: bipush 16
    //   153: ishr
    //   154: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: invokevirtual 103	java/lang/Integer:byteValue	()B
    //   160: bastore
    //   161: aload 11
    //   163: iconst_3
    //   164: iload_2
    //   165: invokestatic 99	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   168: invokevirtual 103	java/lang/Integer:byteValue	()B
    //   171: bastore
    //   172: aload_1
    //   173: iconst_0
    //   174: aload 11
    //   176: iconst_4
    //   177: iload_2
    //   178: invokestatic 93	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   181: aload_0
    //   182: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   185: astore_1
    //   186: new 105	java/io/BufferedOutputStream
    //   189: dup
    //   190: new 107	java/io/FileOutputStream
    //   193: dup
    //   194: aload_1
    //   195: iconst_1
    //   196: invokespecial 110	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   199: invokespecial 113	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   202: astore 10
    //   204: aload 10
    //   206: astore_1
    //   207: aload 10
    //   209: aload 11
    //   211: invokevirtual 117	java/io/BufferedOutputStream:write	([B)V
    //   214: aload 10
    //   216: astore_1
    //   217: aload 10
    //   219: invokevirtual 121	java/io/BufferedOutputStream:flush	()V
    //   222: aload 10
    //   224: invokestatic 127	c/t/m/g/u:a	(Ljava/io/Closeable;)V
    //   227: aload_0
    //   228: getfield 19	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:this$0	Lcom/tencent/map/geolocation/internal/TencentLogImpl;
    //   231: invokestatic 36	com/tencent/map/geolocation/internal/TencentLogImpl:access$500	(Lcom/tencent/map/geolocation/internal/TencentLogImpl;)Ljava/io/File;
    //   234: astore_1
    //   235: aload_0
    //   236: getfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   239: astore 10
    //   241: aload_1
    //   242: ifnull +8 -> 250
    //   245: aload 10
    //   247: ifnonnull +33 -> 280
    //   250: return
    //   251: astore 11
    //   253: aconst_null
    //   254: astore_1
    //   255: aload 11
    //   257: athrow
    //   258: astore 11
    //   260: aload_1
    //   261: astore 10
    //   263: aload 11
    //   265: astore_1
    //   266: aload 10
    //   268: invokestatic 127	c/t/m/g/u:a	(Ljava/io/Closeable;)V
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: aload_0
    //   275: aconst_null
    //   276: putfield 28	com/tencent/map/geolocation/internal/TencentLogImpl$LogHandler:mDest	Ljava/io/File;
    //   279: return
    //   280: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   283: lstore 8
    //   285: aload 10
    //   287: invokevirtual 134	java/io/File:length	()J
    //   290: ldc2_w 135
    //   293: lcmp
    //   294: ifle -44 -> 250
    //   297: aload 10
    //   299: new 38	java/io/File
    //   302: dup
    //   303: aload_1
    //   304: new 138	java/lang/StringBuilder
    //   307: dup
    //   308: ldc 140
    //   310: invokespecial 143	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   313: lload 8
    //   315: invokevirtual 147	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   318: invokevirtual 148	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokespecial 48	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   324: invokevirtual 152	java/io/File:renameTo	(Ljava/io/File;)Z
    //   327: pop
    //   328: return
    //   329: astore_1
    //   330: aconst_null
    //   331: astore 10
    //   333: goto -67 -> 266
    //   336: astore 11
    //   338: aload 10
    //   340: astore_1
    //   341: goto -86 -> 255
    //   344: iload_3
    //   345: iload 5
    //   347: if_icmpge +48 -> 395
    //   350: aload_1
    //   351: iload_2
    //   352: iload_3
    //   353: iadd
    //   354: baload
    //   355: istore 7
    //   357: aload_1
    //   358: iload_2
    //   359: iload_3
    //   360: iadd
    //   361: aload_1
    //   362: iload_2
    //   363: iload 5
    //   365: iadd
    //   366: iload_3
    //   367: iadd
    //   368: baload
    //   369: iload 6
    //   371: ixor
    //   372: i2b
    //   373: bastore
    //   374: aload_1
    //   375: iload_2
    //   376: iload 5
    //   378: iadd
    //   379: iload_3
    //   380: iadd
    //   381: iload 7
    //   383: iload 6
    //   385: ixor
    //   386: i2b
    //   387: bastore
    //   388: iload_3
    //   389: iconst_1
    //   390: iadd
    //   391: istore_3
    //   392: goto -48 -> 344
    //   395: iload 5
    //   397: iconst_1
    //   398: ishl
    //   399: iload_2
    //   400: iadd
    //   401: istore_2
    //   402: goto -319 -> 83
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	405	0	this	LogHandler
    //   0	405	1	paramMessage	android.os.Message
    //   82	320	2	i	int
    //   104	288	3	j	int
    //   55	57	4	k	int
    //   79	320	5	m	int
    //   101	285	6	n	int
    //   355	31	7	i1	int
    //   283	31	8	l	long
    //   50	289	10	localObject1	java.lang.Object
    //   114	96	11	arrayOfByte	byte[]
    //   251	5	11	localIOException1	java.io.IOException
    //   258	6	11	localObject2	java.lang.Object
    //   336	1	11	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   186	204	251	java/io/IOException
    //   207	214	258	finally
    //   217	222	258	finally
    //   255	258	258	finally
    //   35	72	273	java/io/IOException
    //   94	103	273	java/io/IOException
    //   108	186	273	java/io/IOException
    //   222	227	273	java/io/IOException
    //   266	273	273	java/io/IOException
    //   186	204	329	finally
    //   207	214	336	java/io/IOException
    //   217	222	336	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.geolocation.internal.TencentLogImpl.LogHandler
 * JD-Core Version:    0.7.0.1
 */
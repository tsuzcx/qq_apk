package com.tencent.mm.f.c;

import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.e;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
{
  private OutputStream bEo;
  private int bEp;
  public String mFilePath;
  
  public b(String paramString, int paramInt1, int paramInt2)
  {
    this.mFilePath = paramString;
    try
    {
      this.bEo = e.I(paramString, false);
      paramString = ByteBuffer.allocate(44);
      paramString.order(ByteOrder.LITTLE_ENDIAN);
      paramString.putInt(1179011410);
      paramString.putInt(0);
      paramString.putInt(1163280727);
      paramString.putInt(544501094);
      paramString.putInt(16);
      paramString.putShort((short)1);
      paramString.putShort((short)paramInt1);
      paramString.putInt(paramInt2);
      paramString.putInt(paramInt2 * paramInt1 * 2);
      paramString.putShort((short)(paramInt1 * 2));
      paramString.putShort((short)16);
      paramString.putInt(1635017060);
      paramString.putInt(0);
      this.bEp = 44;
      this.bEo.write(paramString.array());
      return;
    }
    catch (IOException paramString)
    {
      y.e("MicroMsg.PcmWriter", "create file failed: " + paramString.getMessage());
    }
  }
  
  /* Error */
  public final void uG()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 26	com/tencent/mm/f/c/b:bEo	Ljava/io/OutputStream;
    //   4: invokevirtual 98	java/io/OutputStream:close	()V
    //   7: aconst_null
    //   8: astore_3
    //   9: aconst_null
    //   10: astore_1
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: getfield 19	com/tencent/mm/f/c/b:mFilePath	Ljava/lang/String;
    //   17: iconst_1
    //   18: invokestatic 102	com/tencent/mm/vfs/e:bP	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   21: astore 4
    //   23: aload 4
    //   25: astore_2
    //   26: aload 4
    //   28: astore_3
    //   29: aload 4
    //   31: astore_1
    //   32: aload 4
    //   34: ldc2_w 103
    //   37: invokevirtual 110	java/io/RandomAccessFile:seek	(J)V
    //   40: aload 4
    //   42: astore_2
    //   43: aload 4
    //   45: astore_3
    //   46: aload 4
    //   48: astore_1
    //   49: iconst_4
    //   50: invokestatic 32	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   53: astore 5
    //   55: aload 4
    //   57: astore_2
    //   58: aload 4
    //   60: astore_3
    //   61: aload 4
    //   63: astore_1
    //   64: aload 5
    //   66: getstatic 38	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   69: invokevirtual 42	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   72: pop
    //   73: aload 4
    //   75: astore_2
    //   76: aload 4
    //   78: astore_3
    //   79: aload 4
    //   81: astore_1
    //   82: aload 5
    //   84: aload_0
    //   85: getfield 55	com/tencent/mm/f/c/b:bEp	I
    //   88: bipush 8
    //   90: isub
    //   91: invokevirtual 46	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   94: pop
    //   95: aload 4
    //   97: astore_2
    //   98: aload 4
    //   100: astore_3
    //   101: aload 4
    //   103: astore_1
    //   104: aload 4
    //   106: aload 5
    //   108: invokevirtual 59	java/nio/ByteBuffer:array	()[B
    //   111: invokevirtual 111	java/io/RandomAccessFile:write	([B)V
    //   114: aload 4
    //   116: astore_2
    //   117: aload 4
    //   119: astore_3
    //   120: aload 4
    //   122: astore_1
    //   123: aload 5
    //   125: invokevirtual 115	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   128: pop
    //   129: aload 4
    //   131: astore_2
    //   132: aload 4
    //   134: astore_3
    //   135: aload 4
    //   137: astore_1
    //   138: aload 5
    //   140: aload_0
    //   141: getfield 55	com/tencent/mm/f/c/b:bEp	I
    //   144: bipush 42
    //   146: isub
    //   147: invokevirtual 46	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   150: pop
    //   151: aload 4
    //   153: astore_2
    //   154: aload 4
    //   156: astore_3
    //   157: aload 4
    //   159: astore_1
    //   160: aload 4
    //   162: ldc2_w 116
    //   165: invokevirtual 110	java/io/RandomAccessFile:seek	(J)V
    //   168: aload 4
    //   170: astore_2
    //   171: aload 4
    //   173: astore_3
    //   174: aload 4
    //   176: astore_1
    //   177: aload 4
    //   179: aload 5
    //   181: invokevirtual 59	java/nio/ByteBuffer:array	()[B
    //   184: invokevirtual 111	java/io/RandomAccessFile:write	([B)V
    //   187: aload 4
    //   189: ifnull +8 -> 197
    //   192: aload 4
    //   194: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   197: return
    //   198: astore_1
    //   199: ldc 67
    //   201: new 69	java/lang/StringBuilder
    //   204: dup
    //   205: ldc 120
    //   207: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   210: aload_1
    //   211: invokevirtual 78	java/io/IOException:getMessage	()Ljava/lang/String;
    //   214: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 91	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   223: goto -216 -> 7
    //   226: astore_1
    //   227: ldc 67
    //   229: aload_1
    //   230: ldc 122
    //   232: iconst_0
    //   233: anewarray 4	java/lang/Object
    //   236: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   239: return
    //   240: astore_3
    //   241: aload_2
    //   242: astore_1
    //   243: ldc 67
    //   245: aload_3
    //   246: ldc 122
    //   248: iconst_0
    //   249: anewarray 4	java/lang/Object
    //   252: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   255: aload_2
    //   256: ifnull -59 -> 197
    //   259: aload_2
    //   260: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   263: return
    //   264: astore_1
    //   265: ldc 67
    //   267: aload_1
    //   268: ldc 122
    //   270: iconst_0
    //   271: anewarray 4	java/lang/Object
    //   274: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   277: return
    //   278: astore_2
    //   279: aload_3
    //   280: astore_1
    //   281: ldc 67
    //   283: aload_2
    //   284: ldc 122
    //   286: iconst_0
    //   287: anewarray 4	java/lang/Object
    //   290: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: aload_3
    //   294: ifnull -97 -> 197
    //   297: aload_3
    //   298: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   301: return
    //   302: astore_1
    //   303: ldc 67
    //   305: aload_1
    //   306: ldc 122
    //   308: iconst_0
    //   309: anewarray 4	java/lang/Object
    //   312: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   315: return
    //   316: astore_2
    //   317: aload_1
    //   318: ifnull +7 -> 325
    //   321: aload_1
    //   322: invokevirtual 118	java/io/RandomAccessFile:close	()V
    //   325: aload_2
    //   326: athrow
    //   327: astore_1
    //   328: ldc 67
    //   330: aload_1
    //   331: ldc 122
    //   333: iconst_0
    //   334: anewarray 4	java/lang/Object
    //   337: invokestatic 126	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   340: goto -15 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	343	0	this	b
    //   10	167	1	localObject1	Object
    //   198	13	1	localIOException1	IOException
    //   226	4	1	localIOException2	IOException
    //   242	1	1	localObject2	Object
    //   264	4	1	localIOException3	IOException
    //   280	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   302	20	1	localIOException4	IOException
    //   327	4	1	localIOException5	IOException
    //   12	248	2	localObject3	Object
    //   278	6	2	localIOException6	IOException
    //   316	10	2	localObject4	Object
    //   8	166	3	localObject5	Object
    //   240	58	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   21	172	4	localRandomAccessFile	java.io.RandomAccessFile
    //   53	127	5	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   0	7	198	java/io/IOException
    //   192	197	226	java/io/IOException
    //   13	23	240	java/io/FileNotFoundException
    //   32	40	240	java/io/FileNotFoundException
    //   49	55	240	java/io/FileNotFoundException
    //   64	73	240	java/io/FileNotFoundException
    //   82	95	240	java/io/FileNotFoundException
    //   104	114	240	java/io/FileNotFoundException
    //   123	129	240	java/io/FileNotFoundException
    //   138	151	240	java/io/FileNotFoundException
    //   160	168	240	java/io/FileNotFoundException
    //   177	187	240	java/io/FileNotFoundException
    //   259	263	264	java/io/IOException
    //   13	23	278	java/io/IOException
    //   32	40	278	java/io/IOException
    //   49	55	278	java/io/IOException
    //   64	73	278	java/io/IOException
    //   82	95	278	java/io/IOException
    //   104	114	278	java/io/IOException
    //   123	129	278	java/io/IOException
    //   138	151	278	java/io/IOException
    //   160	168	278	java/io/IOException
    //   177	187	278	java/io/IOException
    //   297	301	302	java/io/IOException
    //   13	23	316	finally
    //   32	40	316	finally
    //   49	55	316	finally
    //   64	73	316	finally
    //   82	95	316	finally
    //   104	114	316	finally
    //   123	129	316	finally
    //   138	151	316	finally
    //   160	168	316	finally
    //   177	187	316	finally
    //   243	255	316	finally
    //   281	293	316	finally
    //   321	325	327	java/io/IOException
  }
  
  public final boolean v(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.bEo == null) {
      return false;
    }
    try
    {
      this.bEo.write(paramArrayOfByte, 0, paramInt);
      this.bEp += paramInt;
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      y.e("MicroMsg.PcmWriter", "write to file failed: " + paramArrayOfByte.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.f.c.b
 * JD-Core Version:    0.7.0.1
 */
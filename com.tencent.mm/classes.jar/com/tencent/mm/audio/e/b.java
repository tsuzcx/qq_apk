package com.tencent.mm.audio.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class b
{
  private OutputStream dka;
  private int dkb;
  public String mFilePath;
  
  public b(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(130011);
    this.mFilePath = paramString;
    try
    {
      this.dka = o.db(paramString, false);
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
      this.dkb = 44;
      this.dka.write(paramString.array());
      AppMethodBeat.o(130011);
      return;
    }
    catch (IOException paramString)
    {
      ae.e("MicroMsg.PcmWriter", "create file failed: " + paramString.getMessage());
      AppMethodBeat.o(130011);
    }
  }
  
  /* Error */
  public final void closeFile()
  {
    // Byte code:
    //   0: ldc 107
    //   2: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 34	com/tencent/mm/audio/e/b:dka	Ljava/io/OutputStream;
    //   9: invokevirtual 110	java/io/OutputStream:close	()V
    //   12: aconst_null
    //   13: astore_3
    //   14: aconst_null
    //   15: astore_1
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_0
    //   19: getfield 26	com/tencent/mm/audio/e/b:mFilePath	Ljava/lang/String;
    //   22: iconst_1
    //   23: invokestatic 114	com/tencent/mm/vfs/o:dg	(Ljava/lang/String;Z)Ljava/io/RandomAccessFile;
    //   26: astore 4
    //   28: aload 4
    //   30: astore_2
    //   31: aload 4
    //   33: astore_3
    //   34: aload 4
    //   36: astore_1
    //   37: aload 4
    //   39: ldc2_w 115
    //   42: invokevirtual 122	java/io/RandomAccessFile:seek	(J)V
    //   45: aload 4
    //   47: astore_2
    //   48: aload 4
    //   50: astore_3
    //   51: aload 4
    //   53: astore_1
    //   54: iconst_4
    //   55: invokestatic 40	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   58: astore 5
    //   60: aload 4
    //   62: astore_2
    //   63: aload 4
    //   65: astore_3
    //   66: aload 4
    //   68: astore_1
    //   69: aload 5
    //   71: getstatic 46	java/nio/ByteOrder:LITTLE_ENDIAN	Ljava/nio/ByteOrder;
    //   74: invokevirtual 50	java/nio/ByteBuffer:order	(Ljava/nio/ByteOrder;)Ljava/nio/ByteBuffer;
    //   77: pop
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: aload 4
    //   86: astore_1
    //   87: aload 5
    //   89: aload_0
    //   90: getfield 63	com/tencent/mm/audio/e/b:dkb	I
    //   93: bipush 8
    //   95: isub
    //   96: invokevirtual 54	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   99: pop
    //   100: aload 4
    //   102: astore_2
    //   103: aload 4
    //   105: astore_3
    //   106: aload 4
    //   108: astore_1
    //   109: aload 4
    //   111: aload 5
    //   113: invokevirtual 67	java/nio/ByteBuffer:array	()[B
    //   116: invokevirtual 123	java/io/RandomAccessFile:write	([B)V
    //   119: aload 4
    //   121: astore_2
    //   122: aload 4
    //   124: astore_3
    //   125: aload 4
    //   127: astore_1
    //   128: aload 5
    //   130: invokevirtual 127	java/nio/ByteBuffer:rewind	()Ljava/nio/Buffer;
    //   133: pop
    //   134: aload 4
    //   136: astore_2
    //   137: aload 4
    //   139: astore_3
    //   140: aload 4
    //   142: astore_1
    //   143: aload 5
    //   145: aload_0
    //   146: getfield 63	com/tencent/mm/audio/e/b:dkb	I
    //   149: bipush 42
    //   151: isub
    //   152: invokevirtual 54	java/nio/ByteBuffer:putInt	(I)Ljava/nio/ByteBuffer;
    //   155: pop
    //   156: aload 4
    //   158: astore_2
    //   159: aload 4
    //   161: astore_3
    //   162: aload 4
    //   164: astore_1
    //   165: aload 4
    //   167: ldc2_w 128
    //   170: invokevirtual 122	java/io/RandomAccessFile:seek	(J)V
    //   173: aload 4
    //   175: astore_2
    //   176: aload 4
    //   178: astore_3
    //   179: aload 4
    //   181: astore_1
    //   182: aload 4
    //   184: aload 5
    //   186: invokevirtual 67	java/nio/ByteBuffer:array	()[B
    //   189: invokevirtual 123	java/io/RandomAccessFile:write	([B)V
    //   192: aload 4
    //   194: ifnull +189 -> 383
    //   197: aload 4
    //   199: invokevirtual 130	java/io/RandomAccessFile:close	()V
    //   202: ldc 107
    //   204: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   207: return
    //   208: astore_1
    //   209: ldc 78
    //   211: new 80	java/lang/StringBuilder
    //   214: dup
    //   215: ldc 132
    //   217: invokespecial 85	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   220: aload_1
    //   221: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   224: invokevirtual 93	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 96	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 102	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   233: goto -221 -> 12
    //   236: astore_1
    //   237: ldc 78
    //   239: aload_1
    //   240: ldc 134
    //   242: iconst_0
    //   243: anewarray 4	java/lang/Object
    //   246: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   249: ldc 107
    //   251: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   254: return
    //   255: astore_3
    //   256: aload_2
    //   257: astore_1
    //   258: ldc 78
    //   260: aload_3
    //   261: ldc 134
    //   263: iconst_0
    //   264: anewarray 4	java/lang/Object
    //   267: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   270: aload_2
    //   271: ifnull +112 -> 383
    //   274: aload_2
    //   275: invokevirtual 130	java/io/RandomAccessFile:close	()V
    //   278: ldc 107
    //   280: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   283: return
    //   284: astore_1
    //   285: ldc 78
    //   287: aload_1
    //   288: ldc 134
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   297: ldc 107
    //   299: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   302: return
    //   303: astore_2
    //   304: aload_3
    //   305: astore_1
    //   306: ldc 78
    //   308: aload_2
    //   309: ldc 134
    //   311: iconst_0
    //   312: anewarray 4	java/lang/Object
    //   315: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   318: aload_3
    //   319: ifnull +64 -> 383
    //   322: aload_3
    //   323: invokevirtual 130	java/io/RandomAccessFile:close	()V
    //   326: ldc 107
    //   328: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   331: return
    //   332: astore_1
    //   333: ldc 78
    //   335: aload_1
    //   336: ldc 134
    //   338: iconst_0
    //   339: anewarray 4	java/lang/Object
    //   342: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   345: ldc 107
    //   347: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   350: return
    //   351: astore_2
    //   352: aload_1
    //   353: ifnull +7 -> 360
    //   356: aload_1
    //   357: invokevirtual 130	java/io/RandomAccessFile:close	()V
    //   360: ldc 107
    //   362: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   365: aload_2
    //   366: athrow
    //   367: astore_1
    //   368: ldc 78
    //   370: aload_1
    //   371: ldc 134
    //   373: iconst_0
    //   374: anewarray 4	java/lang/Object
    //   377: invokestatic 138	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   380: goto -20 -> 360
    //   383: ldc 107
    //   385: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   388: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	b
    //   15	167	1	localObject1	Object
    //   208	13	1	localIOException1	IOException
    //   236	4	1	localIOException2	IOException
    //   257	1	1	localObject2	Object
    //   284	4	1	localIOException3	IOException
    //   305	1	1	localFileNotFoundException1	java.io.FileNotFoundException
    //   332	25	1	localIOException4	IOException
    //   367	4	1	localIOException5	IOException
    //   17	258	2	localObject3	Object
    //   303	6	2	localIOException6	IOException
    //   351	15	2	localObject4	Object
    //   13	166	3	localObject5	Object
    //   255	68	3	localFileNotFoundException2	java.io.FileNotFoundException
    //   26	172	4	localRandomAccessFile	java.io.RandomAccessFile
    //   58	127	5	localByteBuffer	ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	12	208	java/io/IOException
    //   197	202	236	java/io/IOException
    //   18	28	255	java/io/FileNotFoundException
    //   37	45	255	java/io/FileNotFoundException
    //   54	60	255	java/io/FileNotFoundException
    //   69	78	255	java/io/FileNotFoundException
    //   87	100	255	java/io/FileNotFoundException
    //   109	119	255	java/io/FileNotFoundException
    //   128	134	255	java/io/FileNotFoundException
    //   143	156	255	java/io/FileNotFoundException
    //   165	173	255	java/io/FileNotFoundException
    //   182	192	255	java/io/FileNotFoundException
    //   274	278	284	java/io/IOException
    //   18	28	303	java/io/IOException
    //   37	45	303	java/io/IOException
    //   54	60	303	java/io/IOException
    //   69	78	303	java/io/IOException
    //   87	100	303	java/io/IOException
    //   109	119	303	java/io/IOException
    //   128	134	303	java/io/IOException
    //   143	156	303	java/io/IOException
    //   165	173	303	java/io/IOException
    //   182	192	303	java/io/IOException
    //   322	326	332	java/io/IOException
    //   18	28	351	finally
    //   37	45	351	finally
    //   54	60	351	finally
    //   69	78	351	finally
    //   87	100	351	finally
    //   109	119	351	finally
    //   128	134	351	finally
    //   143	156	351	finally
    //   165	173	351	finally
    //   182	192	351	finally
    //   258	270	351	finally
    //   306	318	351	finally
    //   356	360	367	java/io/IOException
  }
  
  public final boolean y(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(130012);
    if (this.dka == null)
    {
      AppMethodBeat.o(130012);
      return false;
    }
    try
    {
      this.dka.write(paramArrayOfByte, 0, paramInt);
      this.dkb += paramInt;
      AppMethodBeat.o(130012);
      return true;
    }
    catch (Exception paramArrayOfByte)
    {
      ae.e("MicroMsg.PcmWriter", "write to file failed: " + paramArrayOfByte.getMessage());
      AppMethodBeat.o(130012);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.e.b
 * JD-Core Version:    0.7.0.1
 */
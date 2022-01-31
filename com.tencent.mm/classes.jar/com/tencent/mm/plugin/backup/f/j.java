package com.tencent.mm.plugin.backup.f;

import com.tencent.mm.a.n;
import com.tencent.mm.sdk.platformtools.y;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class j
{
  public static String U(byte[] paramArrayOfByte)
  {
    String str = "";
    int i;
    if (paramArrayOfByte.length > 100) {
      i = paramArrayOfByte.length - 100;
    }
    while (i < paramArrayOfByte.length)
    {
      str = str + Integer.toHexString(paramArrayOfByte[i] & 0xFF) + " ";
      i += 1;
      continue;
      i = 0;
    }
    y.e("MicroMsg.BackupPacker", "dumpErr errBuf:%s", new Object[] { str });
    return str;
  }
  
  public static int a(byte[] paramArrayOfByte1, int paramInt1, short paramShort1, short paramShort2, int paramInt2, byte[] paramArrayOfByte2)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(n.eg(paramInt1));
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort1 >> 8 & 0xFF), (byte)(paramShort1 & 0xFF) });
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort2 >> 8 & 0xFF), (byte)(paramShort2 & 0xFF) });
      localByteArrayOutputStream.write(n.eg(paramInt2));
      localByteArrayOutputStream.write(n.eg(0));
      localByteArrayOutputStream.write(paramArrayOfByte2);
      paramArrayOfByte1 = new CRC32();
      paramArrayOfByte1.update(localByteArrayOutputStream.toByteArray());
      long l = paramArrayOfByte1.getValue();
      return (int)l;
    }
    catch (IOException paramArrayOfByte1)
    {
      y.printErrStackTrace("MicroMsg.BackupPacker", paramArrayOfByte1, "BackupPacker getCheckSum error.", new Object[0]);
    }
    return 0;
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, int paramInt1, short paramShort, com.tencent.mm.pointers.PByteArray paramPByteArray, int paramInt2)
  {
    // Byte code:
    //   0: new 47	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 48	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore 6
    //   9: aload 6
    //   11: astore 5
    //   13: aload 6
    //   15: ldc 81
    //   17: invokevirtual 86	java/lang/String:getBytes	()[B
    //   20: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   23: aload 6
    //   25: astore 5
    //   27: aload 6
    //   29: iload_1
    //   30: invokestatic 58	com/tencent/mm/a/n:eg	(I)[B
    //   33: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   36: aload 6
    //   38: astore 5
    //   40: aload 6
    //   42: iconst_2
    //   43: newarray byte
    //   45: dup
    //   46: iconst_0
    //   47: iconst_0
    //   48: bastore
    //   49: dup
    //   50: iconst_1
    //   51: iconst_1
    //   52: bastore
    //   53: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   56: aload 6
    //   58: astore 5
    //   60: aload 6
    //   62: iconst_2
    //   63: newarray byte
    //   65: dup
    //   66: iconst_0
    //   67: iload_2
    //   68: bipush 8
    //   70: ishr
    //   71: sipush 255
    //   74: iand
    //   75: i2b
    //   76: bastore
    //   77: dup
    //   78: iconst_1
    //   79: iload_2
    //   80: sipush 255
    //   83: iand
    //   84: i2b
    //   85: bastore
    //   86: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   89: aload_0
    //   90: astore 7
    //   92: iload_2
    //   93: iconst_1
    //   94: if_icmpeq +11 -> 105
    //   97: iload_2
    //   98: iconst_2
    //   99: if_icmpne +125 -> 224
    //   102: aload_0
    //   103: astore 7
    //   105: aload 6
    //   107: astore 5
    //   109: aload 6
    //   111: aload 7
    //   113: arraylength
    //   114: bipush 20
    //   116: iadd
    //   117: invokestatic 58	com/tencent/mm/a/n:eg	(I)[B
    //   120: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   123: aload 6
    //   125: astore 5
    //   127: aload 6
    //   129: iconst_0
    //   130: invokestatic 58	com/tencent/mm/a/n:eg	(I)[B
    //   133: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   136: aload 6
    //   138: astore 5
    //   140: aload 6
    //   142: aload 7
    //   144: invokevirtual 52	java/io/ByteArrayOutputStream:write	([B)V
    //   147: aload 6
    //   149: astore 5
    //   151: aload_3
    //   152: aload 6
    //   154: invokevirtual 65	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   157: putfield 92	com/tencent/mm/pointers/PByteArray:value	[B
    //   160: iload 4
    //   162: iconst_1
    //   163: if_icmpne +50 -> 213
    //   166: aload 6
    //   168: astore 5
    //   170: new 60	java/util/zip/CRC32
    //   173: dup
    //   174: invokespecial 61	java/util/zip/CRC32:<init>	()V
    //   177: astore_0
    //   178: aload 6
    //   180: astore 5
    //   182: aload_0
    //   183: aload_3
    //   184: getfield 92	com/tencent/mm/pointers/PByteArray:value	[B
    //   187: invokevirtual 68	java/util/zip/CRC32:update	([B)V
    //   190: aload 6
    //   192: astore 5
    //   194: aload_0
    //   195: invokevirtual 72	java/util/zip/CRC32:getValue	()J
    //   198: l2i
    //   199: invokestatic 58	com/tencent/mm/a/n:eg	(I)[B
    //   202: iconst_0
    //   203: aload_3
    //   204: getfield 92	com/tencent/mm/pointers/PByteArray:value	[B
    //   207: bipush 16
    //   209: iconst_4
    //   210: invokestatic 98	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   213: aload 6
    //   215: invokevirtual 101	java/io/ByteArrayOutputStream:reset	()V
    //   218: aload 6
    //   220: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   223: return
    //   224: aload 6
    //   226: astore 5
    //   228: aload_0
    //   229: invokestatic 109	com/tencent/mm/plugin/backup/b/d:atr	()[B
    //   232: invokestatic 115	com/tencent/mm/a/k:b	([B[B)[B
    //   235: astore 7
    //   237: goto -132 -> 105
    //   240: astore_3
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: astore 5
    //   246: ldc 32
    //   248: aload_3
    //   249: ldc 117
    //   251: iconst_0
    //   252: anewarray 4	java/lang/Object
    //   255: invokestatic 78	com/tencent/mm/sdk/platformtools/y:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   258: aload_0
    //   259: ifnull -36 -> 223
    //   262: aload_0
    //   263: invokevirtual 101	java/io/ByteArrayOutputStream:reset	()V
    //   266: aload_0
    //   267: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   270: return
    //   271: astore_0
    //   272: return
    //   273: astore_0
    //   274: aconst_null
    //   275: astore 5
    //   277: aload 5
    //   279: ifnull +13 -> 292
    //   282: aload 5
    //   284: invokevirtual 101	java/io/ByteArrayOutputStream:reset	()V
    //   287: aload 5
    //   289: invokevirtual 104	java/io/ByteArrayOutputStream:close	()V
    //   292: aload_0
    //   293: athrow
    //   294: astore_3
    //   295: goto -3 -> 292
    //   298: astore_0
    //   299: goto -22 -> 277
    //   302: astore_3
    //   303: aload 6
    //   305: astore_0
    //   306: goto -63 -> 243
    //   309: astore_0
    //   310: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	311	0	paramArrayOfByte	byte[]
    //   0	311	1	paramInt1	int
    //   0	311	2	paramShort	short
    //   0	311	3	paramPByteArray	com.tencent.mm.pointers.PByteArray
    //   0	311	4	paramInt2	int
    //   11	277	5	localObject	Object
    //   7	297	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   90	146	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   0	9	240	java/io/IOException
    //   262	270	271	java/io/IOException
    //   0	9	273	finally
    //   282	292	294	java/io/IOException
    //   13	23	298	finally
    //   27	36	298	finally
    //   40	56	298	finally
    //   60	89	298	finally
    //   109	123	298	finally
    //   127	136	298	finally
    //   140	147	298	finally
    //   151	160	298	finally
    //   170	178	298	finally
    //   182	190	298	finally
    //   194	213	298	finally
    //   228	237	298	finally
    //   246	258	298	finally
    //   13	23	302	java/io/IOException
    //   27	36	302	java/io/IOException
    //   40	56	302	java/io/IOException
    //   60	89	302	java/io/IOException
    //   109	123	302	java/io/IOException
    //   127	136	302	java/io/IOException
    //   140	147	302	java/io/IOException
    //   151	160	302	java/io/IOException
    //   170	178	302	java/io/IOException
    //   182	190	302	java/io/IOException
    //   194	213	302	java/io/IOException
    //   228	237	302	java/io/IOException
    //   213	223	309	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.j
 * JD-Core Version:    0.7.0.1
 */
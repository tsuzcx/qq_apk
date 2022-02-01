package com.tencent.mm.plugin.backup.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.o;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.CRC32;

public final class j
{
  public static int a(byte[] paramArrayOfByte1, int paramInt1, short paramShort1, short paramShort2, int paramInt2, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(21529);
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      localByteArrayOutputStream.write(paramArrayOfByte1);
      localByteArrayOutputStream.write(o.hh(paramInt1));
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort1 >> 8 & 0xFF), (byte)(paramShort1 & 0xFF) });
      localByteArrayOutputStream.write(new byte[] { (byte)(paramShort2 >> 8 & 0xFF), (byte)(paramShort2 & 0xFF) });
      localByteArrayOutputStream.write(o.hh(paramInt2));
      localByteArrayOutputStream.write(o.hh(0));
      localByteArrayOutputStream.write(paramArrayOfByte2);
      paramArrayOfByte1 = new CRC32();
      paramArrayOfByte1.update(localByteArrayOutputStream.toByteArray());
      long l = paramArrayOfByte1.getValue();
      paramInt1 = (int)l;
      AppMethodBeat.o(21529);
      return paramInt1;
    }
    catch (IOException paramArrayOfByte1)
    {
      ad.printErrStackTrace("MicroMsg.BackupPacker", paramArrayOfByte1, "BackupPacker getCheckSum error.", new Object[0]);
      AppMethodBeat.o(21529);
    }
    return 0;
  }
  
  /* Error */
  public static void a(byte[] paramArrayOfByte, int paramInt1, short paramShort, com.tencent.mm.pointers.PByteArray paramPByteArray, int paramInt2)
  {
    // Byte code:
    //   0: sipush 21528
    //   3: invokestatic 14	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 16	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 20	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore 6
    //   15: aload 6
    //   17: astore 5
    //   19: aload 6
    //   21: ldc 61
    //   23: invokevirtual 66	java/lang/String:getBytes	()[B
    //   26: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   29: aload 6
    //   31: astore 5
    //   33: aload 6
    //   35: iload_1
    //   36: invokestatic 30	com/tencent/mm/b/o:hh	(I)[B
    //   39: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   42: aload 6
    //   44: astore 5
    //   46: aload 6
    //   48: iconst_2
    //   49: newarray byte
    //   51: dup
    //   52: iconst_0
    //   53: iconst_0
    //   54: bastore
    //   55: dup
    //   56: iconst_1
    //   57: iconst_1
    //   58: bastore
    //   59: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   62: aload 6
    //   64: astore 5
    //   66: aload 6
    //   68: iconst_2
    //   69: newarray byte
    //   71: dup
    //   72: iconst_0
    //   73: iload_2
    //   74: bipush 8
    //   76: ishr
    //   77: sipush 255
    //   80: iand
    //   81: i2b
    //   82: bastore
    //   83: dup
    //   84: iconst_1
    //   85: iload_2
    //   86: sipush 255
    //   89: iand
    //   90: i2b
    //   91: bastore
    //   92: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   95: aload_0
    //   96: astore 7
    //   98: iload_2
    //   99: iconst_1
    //   100: if_icmpeq +11 -> 111
    //   103: iload_2
    //   104: iconst_2
    //   105: if_icmpne +131 -> 236
    //   108: aload_0
    //   109: astore 7
    //   111: aload 6
    //   113: astore 5
    //   115: aload 6
    //   117: aload 7
    //   119: arraylength
    //   120: bipush 20
    //   122: iadd
    //   123: invokestatic 30	com/tencent/mm/b/o:hh	(I)[B
    //   126: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   129: aload 6
    //   131: astore 5
    //   133: aload 6
    //   135: iconst_0
    //   136: invokestatic 30	com/tencent/mm/b/o:hh	(I)[B
    //   139: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   142: aload 6
    //   144: astore 5
    //   146: aload 6
    //   148: aload 7
    //   150: invokevirtual 24	java/io/ByteArrayOutputStream:write	([B)V
    //   153: aload 6
    //   155: astore 5
    //   157: aload_3
    //   158: aload 6
    //   160: invokevirtual 37	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   163: putfield 72	com/tencent/mm/pointers/PByteArray:value	[B
    //   166: iload 4
    //   168: iconst_1
    //   169: if_icmpne +50 -> 219
    //   172: aload 6
    //   174: astore 5
    //   176: new 32	java/util/zip/CRC32
    //   179: dup
    //   180: invokespecial 33	java/util/zip/CRC32:<init>	()V
    //   183: astore_0
    //   184: aload 6
    //   186: astore 5
    //   188: aload_0
    //   189: aload_3
    //   190: getfield 72	com/tencent/mm/pointers/PByteArray:value	[B
    //   193: invokevirtual 40	java/util/zip/CRC32:update	([B)V
    //   196: aload 6
    //   198: astore 5
    //   200: aload_0
    //   201: invokevirtual 44	java/util/zip/CRC32:getValue	()J
    //   204: l2i
    //   205: invokestatic 30	com/tencent/mm/b/o:hh	(I)[B
    //   208: iconst_0
    //   209: aload_3
    //   210: getfield 72	com/tencent/mm/pointers/PByteArray:value	[B
    //   213: bipush 16
    //   215: iconst_4
    //   216: invokestatic 78	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   219: aload 6
    //   221: invokevirtual 81	java/io/ByteArrayOutputStream:reset	()V
    //   224: aload 6
    //   226: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   229: sipush 21528
    //   232: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   235: return
    //   236: aload 6
    //   238: astore 5
    //   240: aload_0
    //   241: invokestatic 89	com/tencent/mm/plugin/backup/b/d:bHb	()[B
    //   244: invokestatic 95	com/tencent/mm/b/l:e	([B[B)[B
    //   247: astore 7
    //   249: goto -138 -> 111
    //   252: astore_0
    //   253: sipush 21528
    //   256: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   259: return
    //   260: astore_3
    //   261: aconst_null
    //   262: astore_0
    //   263: aload_0
    //   264: astore 5
    //   266: ldc 49
    //   268: aload_3
    //   269: ldc 97
    //   271: iconst_0
    //   272: anewarray 4	java/lang/Object
    //   275: invokestatic 57	com/tencent/mm/sdk/platformtools/ad:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload_0
    //   279: ifnull +53 -> 332
    //   282: aload_0
    //   283: invokevirtual 81	java/io/ByteArrayOutputStream:reset	()V
    //   286: aload_0
    //   287: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   290: sipush 21528
    //   293: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   296: return
    //   297: astore_0
    //   298: sipush 21528
    //   301: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   304: return
    //   305: astore_0
    //   306: aconst_null
    //   307: astore 5
    //   309: aload 5
    //   311: ifnull +13 -> 324
    //   314: aload 5
    //   316: invokevirtual 81	java/io/ByteArrayOutputStream:reset	()V
    //   319: aload 5
    //   321: invokevirtual 84	java/io/ByteArrayOutputStream:close	()V
    //   324: sipush 21528
    //   327: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   330: aload_0
    //   331: athrow
    //   332: sipush 21528
    //   335: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: return
    //   339: astore_3
    //   340: goto -16 -> 324
    //   343: astore_0
    //   344: goto -35 -> 309
    //   347: astore_3
    //   348: aload 6
    //   350: astore_0
    //   351: goto -88 -> 263
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	354	0	paramArrayOfByte	byte[]
    //   0	354	1	paramInt1	int
    //   0	354	2	paramShort	short
    //   0	354	3	paramPByteArray	com.tencent.mm.pointers.PByteArray
    //   0	354	4	paramInt2	int
    //   17	303	5	localObject	Object
    //   13	336	6	localByteArrayOutputStream	ByteArrayOutputStream
    //   96	152	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   219	229	252	java/io/IOException
    //   6	15	260	java/io/IOException
    //   282	290	297	java/io/IOException
    //   6	15	305	finally
    //   314	324	339	java/io/IOException
    //   19	29	343	finally
    //   33	42	343	finally
    //   46	62	343	finally
    //   66	95	343	finally
    //   115	129	343	finally
    //   133	142	343	finally
    //   146	153	343	finally
    //   157	166	343	finally
    //   176	184	343	finally
    //   188	196	343	finally
    //   200	219	343	finally
    //   240	249	343	finally
    //   266	278	343	finally
    //   19	29	347	java/io/IOException
    //   33	42	347	java/io/IOException
    //   46	62	347	java/io/IOException
    //   66	95	347	java/io/IOException
    //   115	129	347	java/io/IOException
    //   133	142	347	java/io/IOException
    //   146	153	347	java/io/IOException
    //   157	166	347	java/io/IOException
    //   176	184	347	java/io/IOException
    //   188	196	347	java/io/IOException
    //   200	219	347	java/io/IOException
    //   240	249	347	java/io/IOException
  }
  
  public static String aC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(21530);
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
    ad.e("MicroMsg.BackupPacker", "dumpErr errBuf:%s", new Object[] { str });
    AppMethodBeat.o(21530);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.f.j
 * JD-Core Version:    0.7.0.1
 */
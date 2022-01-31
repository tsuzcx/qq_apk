package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class d
{
  private static final int gmd;
  private static final int gme;
  private static final int gmf;
  private static final int gmg;
  private static final int gmh;
  private static final int gmi;
  private static final int gmj;
  private static final int gmk;
  private static final int gml;
  private static final int gmm;
  private static final int gmn;
  private static final int gmo;
  private static final int gmp;
  
  static
  {
    AppMethodBeat.i(117844);
    gmd = af(new byte[] { 102, 114, 101, 101 });
    gme = af(new byte[] { 106, 117, 110, 107 });
    gmf = af(new byte[] { 109, 100, 97, 116 });
    gmg = af(new byte[] { 109, 111, 111, 118 });
    gmh = af(new byte[] { 112, 110, 111, 116 });
    gmi = af(new byte[] { 115, 107, 105, 112 });
    gmj = af(new byte[] { 119, 105, 100, 101 });
    gmk = af(new byte[] { 80, 73, 67, 84 });
    gml = af(new byte[] { 102, 116, 121, 112 });
    gmm = af(new byte[] { 117, 117, 105, 100 });
    gmn = af(new byte[] { 99, 109, 111, 118 });
    gmo = af(new byte[] { 115, 116, 99, 111 });
    gmp = af(new byte[] { 99, 111, 54, 52 });
    AppMethodBeat.o(117844);
  }
  
  private static boolean a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(117840);
    paramByteBuffer.clear();
    int i = paramFileChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == paramByteBuffer.capacity())
    {
      AppMethodBeat.o(117840);
      return true;
    }
    AppMethodBeat.o(117840);
    return false;
  }
  
  private static boolean a(FileChannel paramFileChannel1, FileChannel paramFileChannel2, PInt paramPInt)
  {
    AppMethodBeat.i(117843);
    int k = 0;
    long l2 = 0L;
    Object localObject1 = null;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8).order(ByteOrder.BIG_ENDIAN);
    long l3 = 0L;
    int i = 0;
    int j = 0;
    long l4 = -1L;
    long l1;
    int m;
    int n;
    Object localObject2;
    for (;;)
    {
      if (a(paramFileChannel1, localByteBuffer))
      {
        l1 = 0xFFFFFFFF & localByteBuffer.getInt();
        m = localByteBuffer.getInt();
        if (m == gml)
        {
          k = 1;
          i = 1;
          n = hm(l1);
          localObject1 = ByteBuffer.allocate(n).order(ByteOrder.BIG_ENDIAN);
          localByteBuffer.rewind();
          ((ByteBuffer)localObject1).put(localByteBuffer);
          localObject2 = localObject1;
          if (paramFileChannel1.read((ByteBuffer)localObject1) >= n - 8)
          {
            ((ByteBuffer)localObject1).flip();
            l3 = paramFileChannel1.position();
            k = m;
            l2 = l1;
            if (l1 >= 8L) {
              continue;
            }
            ab.w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
            AppMethodBeat.o(117843);
            return false;
          }
        }
        else if (m == gmg)
        {
          l2 = paramFileChannel1.position();
          if (j == 0)
          {
            ab.d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
            paramPInt.value = 1;
            AppMethodBeat.o(117843);
            return false;
          }
          ab.d("MicroMsg.FastStart", "it moov after mdat, need fast start");
          l2 -= 8L;
          j = 1;
          k = m;
        }
      }
    }
    for (;;)
    {
      if ((i == 0) || (j == 0))
      {
        ab.w("MicroMsg.FastStart", "it can not find moov or ftyp");
        AppMethodBeat.o(117843);
        return false;
        if (m == gmf) {
          j = 1;
        }
        if (l1 == 1L)
        {
          localByteBuffer.clear();
          k = i;
          localObject2 = localObject1;
          if (!a(paramFileChannel1, localByteBuffer)) {
            break label853;
          }
          l1 = localByteBuffer.getLong();
          if (l1 < 0L)
          {
            paramFileChannel1 = new Exception("uint64 value is too large");
            AppMethodBeat.o(117843);
            throw paramFileChannel1;
          }
          paramFileChannel1.position(paramFileChannel1.position() + l1 - 16L);
          break;
        }
        paramFileChannel1.position(paramFileChannel1.position() + l1 - 8L);
        break;
      }
      if ((k != gmg) || (l2 < 0L))
      {
        ab.w("MicroMsg.FastStart", "it can not find moov atom");
        AppMethodBeat.o(117843);
        return false;
      }
      j = hm(l1);
      paramPInt = ByteBuffer.allocate(j).order(ByteOrder.BIG_ENDIAN);
      paramPInt.clear();
      i = paramFileChannel1.read(paramPInt, l2);
      paramPInt.flip();
      if (i == paramPInt.capacity()) {}
      for (i = 1; i == 0; i = 0)
      {
        ab.w("MicroMsg.FastStart", "failed to read moov atom");
        AppMethodBeat.o(117843);
        return false;
      }
      if (paramPInt.getInt(12) == gmn)
      {
        ab.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
        AppMethodBeat.o(117843);
        return false;
      }
      while (paramPInt.remaining() >= 8)
      {
        k = paramPInt.position();
        i = paramPInt.getInt(k + 4);
        if ((i != gmo) && (i != gmp))
        {
          paramPInt.position(paramPInt.position() + 1);
        }
        else
        {
          if ((paramPInt.getInt(k) & 0xFFFFFFFF) > paramPInt.remaining())
          {
            ab.w("MicroMsg.FastStart", "bad atom size");
            AppMethodBeat.o(117843);
            return false;
          }
          paramPInt.position(k + 12);
          if (paramPInt.remaining() < 4)
          {
            ab.w("MicroMsg.FastStart", "malformed atom");
            AppMethodBeat.o(117843);
            return false;
          }
          k = hm(paramPInt.getInt());
          if (i == gmo)
          {
            if (paramPInt.remaining() < k * 4)
            {
              ab.w("MicroMsg.FastStart", "bad atom size/element count");
              AppMethodBeat.o(117843);
              return false;
            }
            i = 0;
            while (i < k)
            {
              m = paramPInt.getInt(paramPInt.position());
              n = m + j;
              if ((m < 0) && (n >= 0))
              {
                AppMethodBeat.o(117843);
                return false;
              }
              paramPInt.putInt(n);
              i += 1;
            }
          }
          else if (i == gmp)
          {
            if (paramPInt.remaining() < k * 8)
            {
              ab.w("MicroMsg.FastStart", "bad atom size/element count");
              AppMethodBeat.o(117843);
              return false;
            }
            i = 0;
            while (i < k)
            {
              paramPInt.putLong(paramPInt.getLong(paramPInt.position()) + j);
              i += 1;
            }
          }
        }
      }
      paramFileChannel1.position(l3);
      if (localObject1 != null)
      {
        ((ByteBuffer)localObject1).rewind();
        paramFileChannel2.write((ByteBuffer)localObject1);
      }
      paramPInt.rewind();
      paramFileChannel2.write(paramPInt);
      paramFileChannel1.transferTo(l3, l2 - l3, paramFileChannel2);
      paramFileChannel1.transferTo(l2 + j, paramFileChannel1.size() - l2 - j, paramFileChannel2);
      AppMethodBeat.o(117843);
      return true;
      label853:
      j = 0;
      i = k;
      localObject1 = localObject2;
      k = m;
      l2 = l4;
      continue;
      j = 0;
      l1 = l2;
      l2 = l4;
    }
  }
  
  private static int af(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(117838);
    int i = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).getInt();
    AppMethodBeat.o(117838);
    return i;
  }
  
  /* Error */
  public static boolean b(java.lang.String paramString1, java.lang.String paramString2, PInt paramPInt)
  {
    // Byte code:
    //   0: ldc 244
    //   2: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: iconst_0
    //   6: istore_3
    //   7: new 246	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: new 246	java/io/File
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   25: astore 9
    //   27: new 249	java/io/FileInputStream
    //   30: dup
    //   31: aload 5
    //   33: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   36: astore 5
    //   38: aload 5
    //   40: invokevirtual 256	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   43: astore 10
    //   45: new 258	java/io/FileOutputStream
    //   48: dup
    //   49: aload 9
    //   51: invokespecial 259	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   54: astore 8
    //   56: aload 8
    //   58: astore 7
    //   60: aload 5
    //   62: astore 6
    //   64: aload 10
    //   66: aload 8
    //   68: invokevirtual 260	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   71: aload_2
    //   72: invokestatic 262	com/tencent/mm/plugin/a/d:a	(Ljava/nio/channels/FileChannel;Ljava/nio/channels/FileChannel;Lcom/tencent/mm/pointers/PInt;)Z
    //   75: istore 4
    //   77: iload 4
    //   79: istore_3
    //   80: iload_3
    //   81: istore 4
    //   83: iload_3
    //   84: ifeq +18 -> 102
    //   87: aload 8
    //   89: astore 7
    //   91: aload 5
    //   93: astore 6
    //   95: aload_0
    //   96: aload_1
    //   97: invokestatic 266	com/tencent/mm/plugin/a/d:bh	(Ljava/lang/String;Ljava/lang/String;)Z
    //   100: istore 4
    //   102: aload 5
    //   104: invokestatic 270	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   107: aload 8
    //   109: invokestatic 270	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   112: iload 4
    //   114: ifne +9 -> 123
    //   117: aload 9
    //   119: invokevirtual 274	java/io/File:delete	()Z
    //   122: pop
    //   123: ldc 244
    //   125: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: iload 4
    //   130: ireturn
    //   131: astore_0
    //   132: aconst_null
    //   133: astore_1
    //   134: aconst_null
    //   135: astore 5
    //   137: aload_1
    //   138: astore 7
    //   140: aload 5
    //   142: astore 6
    //   144: ldc 152
    //   146: new 276	java/lang/StringBuilder
    //   149: dup
    //   150: ldc_w 278
    //   153: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   156: aload_0
    //   157: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   160: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   169: aload 5
    //   171: invokestatic 270	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   174: aload_1
    //   175: invokestatic 270	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   178: iload_3
    //   179: istore 4
    //   181: goto -69 -> 112
    //   184: astore_0
    //   185: aconst_null
    //   186: astore 7
    //   188: aconst_null
    //   189: astore 5
    //   191: aload 5
    //   193: invokestatic 270	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   196: aload 7
    //   198: invokestatic 270	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   201: ldc 244
    //   203: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   206: aload_0
    //   207: athrow
    //   208: astore_0
    //   209: aconst_null
    //   210: astore 7
    //   212: goto -21 -> 191
    //   215: astore_0
    //   216: aload 6
    //   218: astore 5
    //   220: goto -29 -> 191
    //   223: astore_0
    //   224: aconst_null
    //   225: astore_1
    //   226: goto -89 -> 137
    //   229: astore_0
    //   230: aload 8
    //   232: astore_1
    //   233: goto -96 -> 137
    //   236: astore_0
    //   237: aload 8
    //   239: astore_1
    //   240: goto -103 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	243	0	paramString1	java.lang.String
    //   0	243	1	paramString2	java.lang.String
    //   0	243	2	paramPInt	PInt
    //   6	173	3	bool1	boolean
    //   75	105	4	bool2	boolean
    //   15	204	5	localObject1	Object
    //   62	155	6	localObject2	Object
    //   58	153	7	localObject3	Object
    //   54	184	8	localFileOutputStream	java.io.FileOutputStream
    //   25	93	9	localFile	java.io.File
    //   43	22	10	localFileChannel	FileChannel
    // Exception table:
    //   from	to	target	type
    //   27	38	131	java/lang/Exception
    //   27	38	184	finally
    //   38	56	208	finally
    //   64	77	215	finally
    //   95	102	215	finally
    //   144	169	215	finally
    //   38	56	223	java/lang/Exception
    //   64	77	229	java/lang/Exception
    //   95	102	236	java/lang/Exception
  }
  
  /* Error */
  private static boolean bh(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc_w 291
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 246	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 246	java/io/File
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 247	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload 6
    //   28: invokevirtual 294	java/io/File:length	()J
    //   31: aload 7
    //   33: invokevirtual 294	java/io/File:length	()J
    //   36: lcmp
    //   37: ifeq +19 -> 56
    //   40: ldc 152
    //   42: ldc_w 296
    //   45: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 291
    //   51: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 298	com/tencent/mm/plugin/a/b
    //   59: dup
    //   60: invokespecial 300	com/tencent/mm/plugin/a/b:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 304	com/tencent/mm/plugin/a/b:wD	(Ljava/lang/String;)J
    //   67: lstore 4
    //   69: new 306	com/tencent/mm/plugin/a/f
    //   72: dup
    //   73: invokespecial 307	com/tencent/mm/plugin/a/f:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: lload 4
    //   83: invokevirtual 311	com/tencent/mm/plugin/a/f:C	(Ljava/lang/String;J)Z
    //   86: pop
    //   87: aload 9
    //   89: getfield 314	com/tencent/mm/plugin/a/f:gmx	I
    //   92: istore_3
    //   93: new 298	com/tencent/mm/plugin/a/b
    //   96: dup
    //   97: invokespecial 300	com/tencent/mm/plugin/a/b:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 304	com/tencent/mm/plugin/a/b:wD	(Ljava/lang/String;)J
    //   104: lstore 4
    //   106: new 306	com/tencent/mm/plugin/a/f
    //   109: dup
    //   110: invokespecial 307	com/tencent/mm/plugin/a/f:<init>	()V
    //   113: astore 8
    //   115: aload 8
    //   117: aload_1
    //   118: lload 4
    //   120: invokevirtual 311	com/tencent/mm/plugin/a/f:C	(Ljava/lang/String;J)Z
    //   123: pop
    //   124: aload 8
    //   126: getfield 314	com/tencent/mm/plugin/a/f:gmx	I
    //   129: istore_2
    //   130: iload_2
    //   131: iload_3
    //   132: if_icmpeq +19 -> 151
    //   135: ldc 152
    //   137: ldc_w 316
    //   140: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 291
    //   146: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: ldc 152
    //   153: new 276	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 318
    //   160: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_3
    //   164: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 323
    //   170: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 321	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 165	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: new 325	java/util/Random
    //   186: dup
    //   187: invokespecial 326	java/util/Random:<init>	()V
    //   190: iload_2
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 329	java/util/Random:nextInt	(I)I
    //   196: iconst_1
    //   197: iadd
    //   198: istore_3
    //   199: iload_3
    //   200: iconst_1
    //   201: iadd
    //   202: iload_2
    //   203: if_icmple +88 -> 291
    //   206: new 167	com/tencent/mm/pointers/PInt
    //   209: dup
    //   210: invokespecial 330	com/tencent/mm/pointers/PInt:<init>	()V
    //   213: astore_1
    //   214: new 167	com/tencent/mm/pointers/PInt
    //   217: dup
    //   218: invokespecial 330	com/tencent/mm/pointers/PInt:<init>	()V
    //   221: astore 10
    //   223: aload 9
    //   225: iload_3
    //   226: iload_2
    //   227: aload_1
    //   228: aload 10
    //   230: invokevirtual 333	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   233: pop
    //   234: new 167	com/tencent/mm/pointers/PInt
    //   237: dup
    //   238: invokespecial 330	com/tencent/mm/pointers/PInt:<init>	()V
    //   241: astore_0
    //   242: new 167	com/tencent/mm/pointers/PInt
    //   245: dup
    //   246: invokespecial 330	com/tencent/mm/pointers/PInt:<init>	()V
    //   249: astore 9
    //   251: aload 8
    //   253: iload_3
    //   254: iload_2
    //   255: aload_0
    //   256: aload 9
    //   258: invokevirtual 333	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   261: pop
    //   262: aload 9
    //   264: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   267: aload 10
    //   269: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   272: if_icmpeq +26 -> 298
    //   275: ldc 152
    //   277: ldc_w 335
    //   280: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc_w 291
    //   286: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore_2
    //   295: goto -89 -> 206
    //   298: new 249	java/io/FileInputStream
    //   301: dup
    //   302: aload 6
    //   304: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   307: astore 6
    //   309: aload 6
    //   311: aload_1
    //   312: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   315: i2l
    //   316: invokevirtual 339	java/io/FileInputStream:skip	(J)J
    //   319: pop2
    //   320: sipush 4096
    //   323: newarray byte
    //   325: astore 8
    //   327: aload 6
    //   329: aload 8
    //   331: invokevirtual 341	java/io/FileInputStream:read	([B)I
    //   334: pop
    //   335: new 249	java/io/FileInputStream
    //   338: dup
    //   339: aload 7
    //   341: invokespecial 252	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   344: astore_1
    //   345: aload_1
    //   346: aload_0
    //   347: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   350: i2l
    //   351: invokevirtual 339	java/io/FileInputStream:skip	(J)J
    //   354: pop2
    //   355: sipush 4096
    //   358: newarray byte
    //   360: astore_0
    //   361: aload 6
    //   363: aload_0
    //   364: invokevirtual 341	java/io/FileInputStream:read	([B)I
    //   367: pop
    //   368: aload 8
    //   370: aload_0
    //   371: invokestatic 347	java/util/Arrays:equals	([B[B)Z
    //   374: ifeq +28 -> 402
    //   377: ldc 152
    //   379: ldc_w 349
    //   382: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   385: aload 6
    //   387: invokevirtual 352	java/io/FileInputStream:close	()V
    //   390: aload_1
    //   391: invokevirtual 352	java/io/FileInputStream:close	()V
    //   394: ldc_w 291
    //   397: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: iconst_0
    //   401: ireturn
    //   402: aload 6
    //   404: invokevirtual 352	java/io/FileInputStream:close	()V
    //   407: aload_1
    //   408: invokevirtual 352	java/io/FileInputStream:close	()V
    //   411: ldc_w 291
    //   414: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   417: iconst_1
    //   418: ireturn
    //   419: astore_1
    //   420: aconst_null
    //   421: astore_0
    //   422: aconst_null
    //   423: astore 6
    //   425: ldc 152
    //   427: new 276	java/lang/StringBuilder
    //   430: dup
    //   431: ldc_w 278
    //   434: invokespecial 279	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   437: aload_1
    //   438: invokevirtual 283	java/lang/Exception:toString	()Ljava/lang/String;
    //   441: invokevirtual 287	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 288	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 160	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   450: aload 6
    //   452: ifnull +8 -> 460
    //   455: aload 6
    //   457: invokevirtual 352	java/io/FileInputStream:close	()V
    //   460: aload_0
    //   461: ifnull -50 -> 411
    //   464: aload_0
    //   465: invokevirtual 352	java/io/FileInputStream:close	()V
    //   468: goto -57 -> 411
    //   471: astore_0
    //   472: goto -61 -> 411
    //   475: astore_0
    //   476: aconst_null
    //   477: astore_1
    //   478: aconst_null
    //   479: astore 6
    //   481: aload 6
    //   483: ifnull +8 -> 491
    //   486: aload 6
    //   488: invokevirtual 352	java/io/FileInputStream:close	()V
    //   491: aload_1
    //   492: ifnull +7 -> 499
    //   495: aload_1
    //   496: invokevirtual 352	java/io/FileInputStream:close	()V
    //   499: ldc_w 291
    //   502: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   505: aload_0
    //   506: athrow
    //   507: astore_0
    //   508: goto -118 -> 390
    //   511: astore_0
    //   512: goto -118 -> 394
    //   515: astore_0
    //   516: goto -109 -> 407
    //   519: astore_0
    //   520: goto -109 -> 411
    //   523: astore_1
    //   524: goto -64 -> 460
    //   527: astore 6
    //   529: goto -38 -> 491
    //   532: astore_1
    //   533: goto -34 -> 499
    //   536: astore_0
    //   537: aconst_null
    //   538: astore_1
    //   539: goto -58 -> 481
    //   542: astore_0
    //   543: goto -62 -> 481
    //   546: astore 7
    //   548: aload_0
    //   549: astore_1
    //   550: aload 7
    //   552: astore_0
    //   553: goto -72 -> 481
    //   556: astore_1
    //   557: aconst_null
    //   558: astore_0
    //   559: goto -134 -> 425
    //   562: astore 7
    //   564: aload_1
    //   565: astore_0
    //   566: aload 7
    //   568: astore_1
    //   569: goto -144 -> 425
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	paramString1	java.lang.String
    //   0	572	1	paramString2	java.lang.String
    //   129	166	2	i	int
    //   92	202	3	j	int
    //   67	52	4	l	long
    //   14	473	6	localObject1	Object
    //   527	1	6	localIOException	IOException
    //   24	316	7	localFile	java.io.File
    //   546	5	7	localObject2	Object
    //   562	5	7	localException	Exception
    //   113	256	8	localObject3	Object
    //   76	187	9	localObject4	Object
    //   221	47	10	localPInt	PInt
    // Exception table:
    //   from	to	target	type
    //   298	309	419	java/lang/Exception
    //   464	468	471	java/io/IOException
    //   298	309	475	finally
    //   385	390	507	java/io/IOException
    //   390	394	511	java/io/IOException
    //   402	407	515	java/io/IOException
    //   407	411	519	java/io/IOException
    //   455	460	523	java/io/IOException
    //   486	491	527	java/io/IOException
    //   495	499	532	java/io/IOException
    //   309	345	536	finally
    //   345	385	542	finally
    //   425	450	546	finally
    //   309	345	556	java/lang/Exception
    //   345	385	562	java/lang/Exception
  }
  
  private static void c(Closeable paramCloseable)
  {
    AppMethodBeat.i(117841);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(117841);
        return;
      }
      catch (IOException paramCloseable)
      {
        ab.w("MicroMsg.FastStart", "Failed to close file: ");
      }
    }
    AppMethodBeat.o(117841);
  }
  
  private static int hm(long paramLong)
  {
    AppMethodBeat.i(117839);
    if ((paramLong > 2147483647L) || (paramLong < 0L))
    {
      Exception localException = new Exception("uint32 value is too large");
      AppMethodBeat.o(117839);
      throw localException;
    }
    int i = (int)paramLong;
    AppMethodBeat.o(117839);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */
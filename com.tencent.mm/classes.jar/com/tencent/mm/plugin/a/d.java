package com.tencent.mm.plugin.a;

import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.y;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class d
{
  private static final int eUf = L(new byte[] { 102, 114, 101, 101 });
  private static final int eUg = L(new byte[] { 106, 117, 110, 107 });
  private static final int eUh = L(new byte[] { 109, 100, 97, 116 });
  private static final int eUi = L(new byte[] { 109, 111, 111, 118 });
  private static final int eUj = L(new byte[] { 112, 110, 111, 116 });
  private static final int eUk = L(new byte[] { 115, 107, 105, 112 });
  private static final int eUl = L(new byte[] { 119, 105, 100, 101 });
  private static final int eUm = L(new byte[] { 80, 73, 67, 84 });
  private static final int eUn = L(new byte[] { 102, 116, 121, 112 });
  private static final int eUo = L(new byte[] { 117, 117, 105, 100 });
  private static final int eUp = L(new byte[] { 99, 109, 111, 118 });
  private static final int eUq = L(new byte[] { 115, 116, 99, 111 });
  private static final int eUr = L(new byte[] { 99, 111, 54, 52 });
  
  private static int L(byte[] paramArrayOfByte)
  {
    return ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).getInt();
  }
  
  private static boolean a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer)
  {
    paramByteBuffer.clear();
    int i = paramFileChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    return i == paramByteBuffer.capacity();
  }
  
  private static boolean a(FileChannel paramFileChannel1, FileChannel paramFileChannel2, PInt paramPInt)
  {
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
        if (m == eUn)
        {
          k = 1;
          i = 1;
          n = cq(l1);
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
            y.w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
            return false;
          }
        }
        else if (m == eUi)
        {
          l2 = paramFileChannel1.position();
          if (j == 0)
          {
            y.d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
            paramPInt.value = 1;
            return false;
          }
          y.d("MicroMsg.FastStart", "it moov after mdat, need fast start");
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
        y.w("MicroMsg.FastStart", "it can not find moov or ftyp");
        return false;
        if (m == eUh) {
          j = 1;
        }
        if (l1 == 1L)
        {
          localByteBuffer.clear();
          localObject2 = localObject1;
          k = i;
          if (!a(paramFileChannel1, localByteBuffer)) {
            break label781;
          }
          l1 = localByteBuffer.getLong();
          if (l1 < 0L) {
            throw new Exception("uint64 value is too large");
          }
          paramFileChannel1.position(paramFileChannel1.position() + l1 - 16L);
          break;
        }
        paramFileChannel1.position(paramFileChannel1.position() + l1 - 8L);
        break;
      }
      if ((k != eUi) || (l2 < 0L))
      {
        y.w("MicroMsg.FastStart", "it can not find moov atom");
        return false;
      }
      j = cq(l1);
      paramPInt = ByteBuffer.allocate(j).order(ByteOrder.BIG_ENDIAN);
      paramPInt.clear();
      i = paramFileChannel1.read(paramPInt, l2);
      paramPInt.flip();
      if (i == paramPInt.capacity()) {}
      for (i = 1; i == 0; i = 0)
      {
        y.w("MicroMsg.FastStart", "failed to read moov atom");
        return false;
      }
      if (paramPInt.getInt(12) == eUp)
      {
        y.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
        return false;
      }
      while (paramPInt.remaining() >= 8)
      {
        k = paramPInt.position();
        i = paramPInt.getInt(k + 4);
        if ((i != eUq) && (i != eUr))
        {
          paramPInt.position(paramPInt.position() + 1);
        }
        else
        {
          if ((paramPInt.getInt(k) & 0xFFFFFFFF) > paramPInt.remaining())
          {
            y.w("MicroMsg.FastStart", "bad atom size");
            return false;
          }
          paramPInt.position(k + 12);
          if (paramPInt.remaining() < 4)
          {
            y.w("MicroMsg.FastStart", "malformed atom");
            return false;
          }
          k = cq(paramPInt.getInt());
          if (i == eUq)
          {
            if (paramPInt.remaining() < k * 4)
            {
              y.w("MicroMsg.FastStart", "bad atom size/element count");
              return false;
            }
            i = 0;
            while (i < k)
            {
              m = paramPInt.getInt(paramPInt.position());
              n = m + j;
              if ((m < 0) && (n >= 0)) {
                return false;
              }
              paramPInt.putInt(n);
              i += 1;
            }
          }
          else if (i == eUr)
          {
            if (paramPInt.remaining() < k * 8)
            {
              y.w("MicroMsg.FastStart", "bad atom size/element count");
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
      return true;
      label781:
      j = 0;
      localObject1 = localObject2;
      i = k;
      k = m;
      l2 = l4;
      continue;
      j = 0;
      l1 = l2;
      l2 = l4;
    }
  }
  
  /* Error */
  private static boolean aO(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: new 234	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore 6
    //   10: new 234	java/io/File
    //   13: dup
    //   14: aload_1
    //   15: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   18: astore 7
    //   20: aload 6
    //   22: invokevirtual 238	java/io/File:length	()J
    //   25: aload 7
    //   27: invokevirtual 238	java/io/File:length	()J
    //   30: lcmp
    //   31: ifeq +12 -> 43
    //   34: ldc 144
    //   36: ldc 240
    //   38: invokestatic 152	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iconst_0
    //   42: ireturn
    //   43: new 242	com/tencent/mm/plugin/a/b
    //   46: dup
    //   47: invokespecial 244	com/tencent/mm/plugin/a/b:<init>	()V
    //   50: aload_0
    //   51: invokevirtual 248	com/tencent/mm/plugin/a/b:po	(Ljava/lang/String;)J
    //   54: lstore 4
    //   56: new 250	com/tencent/mm/plugin/a/f
    //   59: dup
    //   60: invokespecial 251	com/tencent/mm/plugin/a/f:<init>	()V
    //   63: astore 9
    //   65: aload 9
    //   67: aload_0
    //   68: lload 4
    //   70: invokevirtual 255	com/tencent/mm/plugin/a/f:t	(Ljava/lang/String;J)Z
    //   73: pop
    //   74: aload 9
    //   76: getfield 258	com/tencent/mm/plugin/a/f:eUz	I
    //   79: istore_3
    //   80: new 242	com/tencent/mm/plugin/a/b
    //   83: dup
    //   84: invokespecial 244	com/tencent/mm/plugin/a/b:<init>	()V
    //   87: aload_1
    //   88: invokevirtual 248	com/tencent/mm/plugin/a/b:po	(Ljava/lang/String;)J
    //   91: lstore 4
    //   93: new 250	com/tencent/mm/plugin/a/f
    //   96: dup
    //   97: invokespecial 251	com/tencent/mm/plugin/a/f:<init>	()V
    //   100: astore 8
    //   102: aload 8
    //   104: aload_1
    //   105: lload 4
    //   107: invokevirtual 255	com/tencent/mm/plugin/a/f:t	(Ljava/lang/String;J)Z
    //   110: pop
    //   111: aload 8
    //   113: getfield 258	com/tencent/mm/plugin/a/f:eUz	I
    //   116: istore_2
    //   117: iload_2
    //   118: iload_3
    //   119: if_icmpeq +13 -> 132
    //   122: ldc 144
    //   124: ldc_w 260
    //   127: invokestatic 152	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: iconst_0
    //   131: ireturn
    //   132: ldc 144
    //   134: new 262	java/lang/StringBuilder
    //   137: dup
    //   138: ldc_w 264
    //   141: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   144: iload_3
    //   145: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   148: ldc_w 271
    //   151: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload_2
    //   155: invokevirtual 269	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 157	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   164: new 280	java/util/Random
    //   167: dup
    //   168: invokespecial 281	java/util/Random:<init>	()V
    //   171: iload_2
    //   172: iconst_1
    //   173: isub
    //   174: invokevirtual 284	java/util/Random:nextInt	(I)I
    //   177: iconst_1
    //   178: iadd
    //   179: istore_3
    //   180: iload_3
    //   181: iconst_1
    //   182: iadd
    //   183: iload_2
    //   184: if_icmple +82 -> 266
    //   187: new 159	com/tencent/mm/pointers/PInt
    //   190: dup
    //   191: invokespecial 285	com/tencent/mm/pointers/PInt:<init>	()V
    //   194: astore_1
    //   195: new 159	com/tencent/mm/pointers/PInt
    //   198: dup
    //   199: invokespecial 285	com/tencent/mm/pointers/PInt:<init>	()V
    //   202: astore 10
    //   204: aload 9
    //   206: iload_3
    //   207: iload_2
    //   208: aload_1
    //   209: aload 10
    //   211: invokevirtual 288	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   214: pop
    //   215: new 159	com/tencent/mm/pointers/PInt
    //   218: dup
    //   219: invokespecial 285	com/tencent/mm/pointers/PInt:<init>	()V
    //   222: astore_0
    //   223: new 159	com/tencent/mm/pointers/PInt
    //   226: dup
    //   227: invokespecial 285	com/tencent/mm/pointers/PInt:<init>	()V
    //   230: astore 9
    //   232: aload 8
    //   234: iload_3
    //   235: iload_2
    //   236: aload_0
    //   237: aload 9
    //   239: invokevirtual 288	com/tencent/mm/plugin/a/f:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   242: pop
    //   243: aload 9
    //   245: getfield 162	com/tencent/mm/pointers/PInt:value	I
    //   248: aload 10
    //   250: getfield 162	com/tencent/mm/pointers/PInt:value	I
    //   253: if_icmpeq +20 -> 273
    //   256: ldc 144
    //   258: ldc_w 290
    //   261: invokestatic 152	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: iconst_0
    //   265: ireturn
    //   266: iload_3
    //   267: iconst_1
    //   268: iadd
    //   269: istore_2
    //   270: goto -83 -> 187
    //   273: new 292	java/io/FileInputStream
    //   276: dup
    //   277: aload 6
    //   279: invokespecial 295	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   282: astore 6
    //   284: aload 6
    //   286: aload_1
    //   287: getfield 162	com/tencent/mm/pointers/PInt:value	I
    //   290: i2l
    //   291: invokevirtual 299	java/io/FileInputStream:skip	(J)J
    //   294: pop2
    //   295: sipush 4096
    //   298: newarray byte
    //   300: astore 8
    //   302: aload 6
    //   304: aload 8
    //   306: invokevirtual 301	java/io/FileInputStream:read	([B)I
    //   309: pop
    //   310: new 292	java/io/FileInputStream
    //   313: dup
    //   314: aload 7
    //   316: invokespecial 295	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   319: astore_1
    //   320: aload_1
    //   321: aload_0
    //   322: getfield 162	com/tencent/mm/pointers/PInt:value	I
    //   325: i2l
    //   326: invokevirtual 299	java/io/FileInputStream:skip	(J)J
    //   329: pop2
    //   330: sipush 4096
    //   333: newarray byte
    //   335: astore_0
    //   336: aload 6
    //   338: aload_0
    //   339: invokevirtual 301	java/io/FileInputStream:read	([B)I
    //   342: pop
    //   343: aload 8
    //   345: aload_0
    //   346: invokestatic 307	java/util/Arrays:equals	([B[B)Z
    //   349: ifeq +22 -> 371
    //   352: ldc 144
    //   354: ldc_w 309
    //   357: invokestatic 152	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   360: aload 6
    //   362: invokevirtual 312	java/io/FileInputStream:close	()V
    //   365: aload_1
    //   366: invokevirtual 312	java/io/FileInputStream:close	()V
    //   369: iconst_0
    //   370: ireturn
    //   371: aload 6
    //   373: invokevirtual 312	java/io/FileInputStream:close	()V
    //   376: aload_1
    //   377: invokevirtual 312	java/io/FileInputStream:close	()V
    //   380: iconst_1
    //   381: ireturn
    //   382: astore_1
    //   383: aconst_null
    //   384: astore_0
    //   385: aconst_null
    //   386: astore 6
    //   388: ldc 144
    //   390: new 262	java/lang/StringBuilder
    //   393: dup
    //   394: ldc_w 314
    //   397: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   400: aload_1
    //   401: invokevirtual 315	java/lang/Exception:toString	()Ljava/lang/String;
    //   404: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 152	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload 6
    //   415: ifnull +8 -> 423
    //   418: aload 6
    //   420: invokevirtual 312	java/io/FileInputStream:close	()V
    //   423: aload_0
    //   424: ifnull -44 -> 380
    //   427: aload_0
    //   428: invokevirtual 312	java/io/FileInputStream:close	()V
    //   431: goto -51 -> 380
    //   434: astore_0
    //   435: goto -55 -> 380
    //   438: astore_0
    //   439: aconst_null
    //   440: astore_1
    //   441: aconst_null
    //   442: astore 6
    //   444: aload 6
    //   446: ifnull +8 -> 454
    //   449: aload 6
    //   451: invokevirtual 312	java/io/FileInputStream:close	()V
    //   454: aload_1
    //   455: ifnull +7 -> 462
    //   458: aload_1
    //   459: invokevirtual 312	java/io/FileInputStream:close	()V
    //   462: aload_0
    //   463: athrow
    //   464: astore_0
    //   465: goto -100 -> 365
    //   468: astore_0
    //   469: goto -100 -> 369
    //   472: astore_0
    //   473: goto -97 -> 376
    //   476: astore_0
    //   477: goto -97 -> 380
    //   480: astore_1
    //   481: goto -58 -> 423
    //   484: astore 6
    //   486: goto -32 -> 454
    //   489: astore_1
    //   490: goto -28 -> 462
    //   493: astore_0
    //   494: aconst_null
    //   495: astore_1
    //   496: goto -52 -> 444
    //   499: astore_0
    //   500: goto -56 -> 444
    //   503: astore 7
    //   505: aload_0
    //   506: astore_1
    //   507: aload 7
    //   509: astore_0
    //   510: goto -66 -> 444
    //   513: astore_1
    //   514: aconst_null
    //   515: astore_0
    //   516: goto -128 -> 388
    //   519: astore 7
    //   521: aload_1
    //   522: astore_0
    //   523: aload 7
    //   525: astore_1
    //   526: goto -138 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	529	0	paramString1	java.lang.String
    //   0	529	1	paramString2	java.lang.String
    //   116	154	2	i	int
    //   79	190	3	j	int
    //   54	52	4	l	long
    //   8	442	6	localObject1	Object
    //   484	1	6	localIOException	IOException
    //   18	297	7	localFile	java.io.File
    //   503	5	7	localObject2	Object
    //   519	5	7	localException	Exception
    //   100	244	8	localObject3	Object
    //   63	181	9	localObject4	Object
    //   202	47	10	localPInt	PInt
    // Exception table:
    //   from	to	target	type
    //   273	284	382	java/lang/Exception
    //   427	431	434	java/io/IOException
    //   273	284	438	finally
    //   360	365	464	java/io/IOException
    //   365	369	468	java/io/IOException
    //   371	376	472	java/io/IOException
    //   376	380	476	java/io/IOException
    //   418	423	480	java/io/IOException
    //   449	454	484	java/io/IOException
    //   458	462	489	java/io/IOException
    //   284	320	493	finally
    //   320	360	499	finally
    //   388	413	503	finally
    //   284	320	513	java/lang/Exception
    //   320	360	519	java/lang/Exception
  }
  
  /* Error */
  public static boolean b(java.lang.String paramString1, java.lang.String paramString2, PInt paramPInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 234	java/io/File
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   10: astore 5
    //   12: new 234	java/io/File
    //   15: dup
    //   16: aload_1
    //   17: invokespecial 235	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: astore 9
    //   22: new 292	java/io/FileInputStream
    //   25: dup
    //   26: aload 5
    //   28: invokespecial 295	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   31: astore 5
    //   33: aload 5
    //   35: invokevirtual 321	java/io/FileInputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   38: astore 10
    //   40: new 323	java/io/FileOutputStream
    //   43: dup
    //   44: aload 9
    //   46: invokespecial 324	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   49: astore 8
    //   51: aload 8
    //   53: astore 7
    //   55: aload 5
    //   57: astore 6
    //   59: aload 10
    //   61: aload 8
    //   63: invokevirtual 325	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   66: aload_2
    //   67: invokestatic 327	com/tencent/mm/plugin/a/d:a	(Ljava/nio/channels/FileChannel;Ljava/nio/channels/FileChannel;Lcom/tencent/mm/pointers/PInt;)Z
    //   70: istore 4
    //   72: iload 4
    //   74: istore_3
    //   75: iload_3
    //   76: istore 4
    //   78: iload_3
    //   79: ifeq +18 -> 97
    //   82: aload 8
    //   84: astore 7
    //   86: aload 5
    //   88: astore 6
    //   90: aload_0
    //   91: aload_1
    //   92: invokestatic 329	com/tencent/mm/plugin/a/d:aO	(Ljava/lang/String;Ljava/lang/String;)Z
    //   95: istore 4
    //   97: aload 5
    //   99: invokestatic 333	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   102: aload 8
    //   104: invokestatic 333	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   107: iload 4
    //   109: ifne +9 -> 118
    //   112: aload 9
    //   114: invokevirtual 337	java/io/File:delete	()Z
    //   117: pop
    //   118: iload 4
    //   120: ireturn
    //   121: astore_0
    //   122: aconst_null
    //   123: astore_1
    //   124: aconst_null
    //   125: astore 5
    //   127: aload_1
    //   128: astore 7
    //   130: aload 5
    //   132: astore 6
    //   134: ldc 144
    //   136: new 262	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 314
    //   143: invokespecial 265	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: invokevirtual 315	java/lang/Exception:toString	()Ljava/lang/String;
    //   150: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 278	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 152	com/tencent/mm/sdk/platformtools/y:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   159: aload 5
    //   161: invokestatic 333	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   164: aload_1
    //   165: invokestatic 333	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   168: iload_3
    //   169: istore 4
    //   171: goto -64 -> 107
    //   174: astore_0
    //   175: aconst_null
    //   176: astore 7
    //   178: aconst_null
    //   179: astore 5
    //   181: aload 5
    //   183: invokestatic 333	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   186: aload 7
    //   188: invokestatic 333	com/tencent/mm/plugin/a/d:c	(Ljava/io/Closeable;)V
    //   191: aload_0
    //   192: athrow
    //   193: astore_0
    //   194: aconst_null
    //   195: astore 7
    //   197: goto -16 -> 181
    //   200: astore_0
    //   201: aload 6
    //   203: astore 5
    //   205: goto -24 -> 181
    //   208: astore_0
    //   209: aconst_null
    //   210: astore_1
    //   211: goto -84 -> 127
    //   214: astore_0
    //   215: aload 8
    //   217: astore_1
    //   218: goto -91 -> 127
    //   221: astore_0
    //   222: aload 8
    //   224: astore_1
    //   225: goto -98 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	228	0	paramString1	java.lang.String
    //   0	228	1	paramString2	java.lang.String
    //   0	228	2	paramPInt	PInt
    //   1	168	3	bool1	boolean
    //   70	100	4	bool2	boolean
    //   10	194	5	localObject1	Object
    //   57	145	6	localObject2	Object
    //   53	143	7	localObject3	Object
    //   49	174	8	localFileOutputStream	java.io.FileOutputStream
    //   20	93	9	localFile	java.io.File
    //   38	22	10	localFileChannel	FileChannel
    // Exception table:
    //   from	to	target	type
    //   22	33	121	java/lang/Exception
    //   22	33	174	finally
    //   33	51	193	finally
    //   59	72	200	finally
    //   90	97	200	finally
    //   134	159	200	finally
    //   33	51	208	java/lang/Exception
    //   59	72	214	java/lang/Exception
    //   90	97	221	java/lang/Exception
  }
  
  private static void c(Closeable paramCloseable)
  {
    if (paramCloseable != null) {}
    try
    {
      paramCloseable.close();
      return;
    }
    catch (IOException paramCloseable)
    {
      y.w("MicroMsg.FastStart", "Failed to close file: ");
    }
  }
  
  private static int cq(long paramLong)
  {
    if ((paramLong > 2147483647L) || (paramLong < 0L)) {
      throw new Exception("uint32 value is too large");
    }
    return (int)paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.a.d
 * JD-Core Version:    0.7.0.1
 */
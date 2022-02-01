package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;

public final class e
{
  private static final int ixg;
  private static final int ixh;
  private static final int ixi;
  private static final int ixj;
  private static final int ixk;
  private static final int ixl;
  private static final int ixm;
  private static final int ixn;
  private static final int ixo;
  private static final int ixp;
  private static final int ixq;
  private static final int ixr;
  private static final int ixs;
  
  static
  {
    AppMethodBeat.i(133865);
    ixg = ao(new byte[] { 102, 114, 101, 101 });
    ixh = ao(new byte[] { 106, 117, 110, 107 });
    ixi = ao(new byte[] { 109, 100, 97, 116 });
    ixj = ao(new byte[] { 109, 111, 111, 118 });
    ixk = ao(new byte[] { 112, 110, 111, 116 });
    ixl = ao(new byte[] { 115, 107, 105, 112 });
    ixm = ao(new byte[] { 119, 105, 100, 101 });
    ixn = ao(new byte[] { 80, 73, 67, 84 });
    ixo = ao(new byte[] { 102, 116, 121, 112 });
    ixp = ao(new byte[] { 117, 117, 105, 100 });
    ixq = ao(new byte[] { 99, 109, 111, 118 });
    ixr = ao(new byte[] { 115, 116, 99, 111 });
    ixs = ao(new byte[] { 99, 111, 54, 52 });
    AppMethodBeat.o(133865);
  }
  
  private static boolean a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(133861);
    paramByteBuffer.clear();
    int i = paramFileChannel.read(paramByteBuffer);
    paramByteBuffer.flip();
    if (i == paramByteBuffer.capacity())
    {
      AppMethodBeat.o(133861);
      return true;
    }
    AppMethodBeat.o(133861);
    return false;
  }
  
  private static boolean a(FileChannel paramFileChannel1, FileChannel paramFileChannel2, PInt paramPInt)
  {
    AppMethodBeat.i(133864);
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
        if (m == ixo)
        {
          k = 1;
          i = 1;
          n = qA(l1);
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
            ac.w("MicroMsg.FastStart", "atom size less 8, it error mp4.");
            AppMethodBeat.o(133864);
            return false;
          }
        }
        else if (m == ixj)
        {
          l2 = paramFileChannel1.position();
          if (j == 0)
          {
            ac.d("MicroMsg.FastStart", "it moov before mdat, needn't fast start");
            paramPInt.value = 1;
            AppMethodBeat.o(133864);
            return false;
          }
          ac.d("MicroMsg.FastStart", "it moov after mdat, need fast start");
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
        ac.w("MicroMsg.FastStart", "it can not find moov or ftyp");
        AppMethodBeat.o(133864);
        return false;
        if (m == ixi) {
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
            AppMethodBeat.o(133864);
            throw paramFileChannel1;
          }
          paramFileChannel1.position(paramFileChannel1.position() + l1 - 16L);
          break;
        }
        paramFileChannel1.position(paramFileChannel1.position() + l1 - 8L);
        break;
      }
      if ((k != ixj) || (l2 < 0L))
      {
        ac.w("MicroMsg.FastStart", "it can not find moov atom");
        AppMethodBeat.o(133864);
        return false;
      }
      j = qA(l1);
      paramPInt = ByteBuffer.allocate(j).order(ByteOrder.BIG_ENDIAN);
      paramPInt.clear();
      i = paramFileChannel1.read(paramPInt, l2);
      paramPInt.flip();
      if (i == paramPInt.capacity()) {}
      for (i = 1; i == 0; i = 0)
      {
        ac.w("MicroMsg.FastStart", "failed to read moov atom");
        AppMethodBeat.o(133864);
        return false;
      }
      if (paramPInt.getInt(12) == ixq)
      {
        ac.w("MicroMsg.FastStart", "this utility does not support compressed moov atoms yet");
        AppMethodBeat.o(133864);
        return false;
      }
      while (paramPInt.remaining() >= 8)
      {
        k = paramPInt.position();
        i = paramPInt.getInt(k + 4);
        if ((i != ixr) && (i != ixs))
        {
          paramPInt.position(paramPInt.position() + 1);
        }
        else
        {
          if ((paramPInt.getInt(k) & 0xFFFFFFFF) > paramPInt.remaining())
          {
            ac.w("MicroMsg.FastStart", "bad atom size");
            AppMethodBeat.o(133864);
            return false;
          }
          paramPInt.position(k + 12);
          if (paramPInt.remaining() < 4)
          {
            ac.w("MicroMsg.FastStart", "malformed atom");
            AppMethodBeat.o(133864);
            return false;
          }
          k = qA(paramPInt.getInt());
          if (i == ixr)
          {
            if (paramPInt.remaining() < k * 4)
            {
              ac.w("MicroMsg.FastStart", "bad atom size/element count");
              AppMethodBeat.o(133864);
              return false;
            }
            i = 0;
            while (i < k)
            {
              m = paramPInt.getInt(paramPInt.position());
              n = m + j;
              if ((m < 0) && (n >= 0))
              {
                AppMethodBeat.o(133864);
                return false;
              }
              paramPInt.putInt(n);
              i += 1;
            }
          }
          else if (i == ixs)
          {
            if (paramPInt.remaining() < k * 8)
            {
              ac.w("MicroMsg.FastStart", "bad atom size/element count");
              AppMethodBeat.o(133864);
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
      AppMethodBeat.o(133864);
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
  
  private static int ao(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(133859);
    int i = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).getInt();
    AppMethodBeat.o(133859);
    return i;
  }
  
  /* Error */
  public static boolean b(java.lang.String paramString1, java.lang.String paramString2, PInt paramPInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: ldc 244
    //   4: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: new 246	com/tencent/mm/vfs/e
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 247	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   15: astore 5
    //   17: new 246	com/tencent/mm/vfs/e
    //   20: dup
    //   21: aload_1
    //   22: invokespecial 247	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   25: astore 7
    //   27: aload 5
    //   29: getfield 251	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   32: aload 5
    //   34: invokevirtual 255	com/tencent/mm/vfs/e:fxS	()Lcom/tencent/mm/vfs/a$e;
    //   37: invokestatic 261	com/tencent/mm/vfs/i:c	(Landroid/net/Uri;Lcom/tencent/mm/vfs/a$e;)Ljava/nio/channels/ReadableByteChannel;
    //   40: checkcast 97	java/nio/channels/FileChannel
    //   43: astore 5
    //   45: aload 7
    //   47: getfield 251	com/tencent/mm/vfs/e:mUri	Landroid/net/Uri;
    //   50: astore 6
    //   52: aload 7
    //   54: invokevirtual 255	com/tencent/mm/vfs/e:fxS	()Lcom/tencent/mm/vfs/a$e;
    //   57: astore 8
    //   59: invokestatic 267	com/tencent/mm/vfs/a:ghk	()Lcom/tencent/mm/vfs/a;
    //   62: aload 6
    //   64: aload 8
    //   66: invokevirtual 270	com/tencent/mm/vfs/a:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/a$e;)Lcom/tencent/mm/vfs/a$e;
    //   69: astore 8
    //   71: aload 8
    //   73: invokevirtual 276	com/tencent/mm/vfs/a$e:valid	()Z
    //   76: ifne +85 -> 161
    //   79: new 278	java/io/FileNotFoundException
    //   82: dup
    //   83: ldc_w 280
    //   86: aload 6
    //   88: invokestatic 286	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   91: invokevirtual 290	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   94: invokespecial 291	java/io/FileNotFoundException:<init>	(Ljava/lang/String;)V
    //   97: astore_0
    //   98: ldc 244
    //   100: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_0
    //   104: athrow
    //   105: astore_2
    //   106: aconst_null
    //   107: astore_0
    //   108: aload 5
    //   110: astore_1
    //   111: ldc 152
    //   113: new 293	java/lang/StringBuilder
    //   116: dup
    //   117: ldc_w 295
    //   120: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   127: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: aload_1
    //   137: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   140: aload_0
    //   141: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   144: iload_3
    //   145: ifne +9 -> 154
    //   148: aload 7
    //   150: invokevirtual 312	com/tencent/mm/vfs/e:delete	()Z
    //   153: pop
    //   154: ldc 244
    //   156: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   159: iload_3
    //   160: ireturn
    //   161: aload 8
    //   163: getfield 316	com/tencent/mm/vfs/a$e:Jsh	Lcom/tencent/mm/vfs/FileSystem;
    //   166: aload 8
    //   168: getfield 320	com/tencent/mm/vfs/a$e:path	Ljava/lang/String;
    //   171: iconst_0
    //   172: invokeinterface 326 3 0
    //   177: checkcast 97	java/nio/channels/FileChannel
    //   180: astore 6
    //   182: aload 5
    //   184: aload 6
    //   186: aload_2
    //   187: invokestatic 328	com/tencent/mm/plugin/a/e:a	(Ljava/nio/channels/FileChannel;Ljava/nio/channels/FileChannel;Lcom/tencent/mm/pointers/PInt;)Z
    //   190: istore 4
    //   192: iload 4
    //   194: istore_3
    //   195: iload_3
    //   196: istore 4
    //   198: iload_3
    //   199: ifeq +10 -> 209
    //   202: aload_0
    //   203: aload_1
    //   204: invokestatic 332	com/tencent/mm/plugin/a/e:bI	(Ljava/lang/String;Ljava/lang/String;)Z
    //   207: istore 4
    //   209: aload 5
    //   211: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   214: aload 6
    //   216: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   219: iload 4
    //   221: istore_3
    //   222: goto -78 -> 144
    //   225: astore_2
    //   226: aconst_null
    //   227: astore_0
    //   228: aconst_null
    //   229: astore_1
    //   230: aload_1
    //   231: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   234: aload_0
    //   235: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   238: ldc 244
    //   240: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_2
    //   244: athrow
    //   245: astore_2
    //   246: aconst_null
    //   247: astore_0
    //   248: aload 5
    //   250: astore_1
    //   251: goto -21 -> 230
    //   254: astore_2
    //   255: aload 6
    //   257: astore_0
    //   258: aload 5
    //   260: astore_1
    //   261: goto -31 -> 230
    //   264: astore_2
    //   265: goto -35 -> 230
    //   268: astore_2
    //   269: aconst_null
    //   270: astore_0
    //   271: aconst_null
    //   272: astore_1
    //   273: goto -162 -> 111
    //   276: astore_2
    //   277: aload 6
    //   279: astore_0
    //   280: aload 5
    //   282: astore_1
    //   283: goto -172 -> 111
    //   286: astore_2
    //   287: aload 6
    //   289: astore_0
    //   290: aload 5
    //   292: astore_1
    //   293: goto -182 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramString1	java.lang.String
    //   0	296	1	paramString2	java.lang.String
    //   0	296	2	paramPInt	PInt
    //   1	221	3	bool1	boolean
    //   190	30	4	bool2	boolean
    //   15	276	5	localObject1	Object
    //   50	238	6	localObject2	Object
    //   25	124	7	locale	com.tencent.mm.vfs.e
    //   57	110	8	locale1	com.tencent.mm.vfs.a.e
    // Exception table:
    //   from	to	target	type
    //   45	105	105	java/lang/Exception
    //   161	182	105	java/lang/Exception
    //   27	45	225	finally
    //   45	105	245	finally
    //   161	182	245	finally
    //   182	192	254	finally
    //   202	209	254	finally
    //   111	136	264	finally
    //   27	45	268	java/lang/Exception
    //   182	192	276	java/lang/Exception
    //   202	209	286	java/lang/Exception
  }
  
  /* Error */
  private static boolean bI(java.lang.String paramString1, java.lang.String paramString2)
  {
    // Byte code:
    //   0: ldc_w 333
    //   3: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 246	com/tencent/mm/vfs/e
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 247	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   14: astore 6
    //   16: new 246	com/tencent/mm/vfs/e
    //   19: dup
    //   20: aload_1
    //   21: invokespecial 247	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload 6
    //   28: invokevirtual 336	com/tencent/mm/vfs/e:length	()J
    //   31: aload 7
    //   33: invokevirtual 336	com/tencent/mm/vfs/e:length	()J
    //   36: lcmp
    //   37: ifeq +19 -> 56
    //   40: ldc 152
    //   42: ldc_w 338
    //   45: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: ldc_w 333
    //   51: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   54: iconst_0
    //   55: ireturn
    //   56: new 340	com/tencent/mm/plugin/a/b
    //   59: dup
    //   60: invokespecial 342	com/tencent/mm/plugin/a/b:<init>	()V
    //   63: aload_0
    //   64: invokevirtual 346	com/tencent/mm/plugin/a/b:FK	(Ljava/lang/String;)J
    //   67: lstore 4
    //   69: new 348	com/tencent/mm/plugin/a/j
    //   72: dup
    //   73: invokespecial 349	com/tencent/mm/plugin/a/j:<init>	()V
    //   76: astore 9
    //   78: aload 9
    //   80: aload_0
    //   81: lload 4
    //   83: invokevirtual 353	com/tencent/mm/plugin/a/j:F	(Ljava/lang/String;J)Z
    //   86: pop
    //   87: aload 9
    //   89: getfield 356	com/tencent/mm/plugin/a/j:ixA	I
    //   92: istore_3
    //   93: new 340	com/tencent/mm/plugin/a/b
    //   96: dup
    //   97: invokespecial 342	com/tencent/mm/plugin/a/b:<init>	()V
    //   100: aload_1
    //   101: invokevirtual 346	com/tencent/mm/plugin/a/b:FK	(Ljava/lang/String;)J
    //   104: lstore 4
    //   106: new 348	com/tencent/mm/plugin/a/j
    //   109: dup
    //   110: invokespecial 349	com/tencent/mm/plugin/a/j:<init>	()V
    //   113: astore 8
    //   115: aload 8
    //   117: aload_1
    //   118: lload 4
    //   120: invokevirtual 353	com/tencent/mm/plugin/a/j:F	(Ljava/lang/String;J)Z
    //   123: pop
    //   124: aload 8
    //   126: getfield 356	com/tencent/mm/plugin/a/j:ixA	I
    //   129: istore_2
    //   130: iload_2
    //   131: iload_3
    //   132: if_icmpeq +19 -> 151
    //   135: ldc 152
    //   137: ldc_w 358
    //   140: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: ldc_w 333
    //   146: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: iconst_0
    //   150: ireturn
    //   151: ldc 152
    //   153: new 293	java/lang/StringBuilder
    //   156: dup
    //   157: ldc_w 360
    //   160: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   163: iload_3
    //   164: invokevirtual 363	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   167: ldc_w 365
    //   170: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload_2
    //   174: invokevirtual 363	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   177: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 165	com/tencent/mm/sdk/platformtools/ac:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   183: new 367	java/util/Random
    //   186: dup
    //   187: invokespecial 368	java/util/Random:<init>	()V
    //   190: iload_2
    //   191: iconst_1
    //   192: isub
    //   193: invokevirtual 371	java/util/Random:nextInt	(I)I
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
    //   210: invokespecial 372	com/tencent/mm/pointers/PInt:<init>	()V
    //   213: astore_0
    //   214: new 167	com/tencent/mm/pointers/PInt
    //   217: dup
    //   218: invokespecial 372	com/tencent/mm/pointers/PInt:<init>	()V
    //   221: astore 10
    //   223: aload 9
    //   225: iload_3
    //   226: iload_2
    //   227: aload_0
    //   228: aload 10
    //   230: invokevirtual 375	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   233: pop
    //   234: new 167	com/tencent/mm/pointers/PInt
    //   237: dup
    //   238: invokespecial 372	com/tencent/mm/pointers/PInt:<init>	()V
    //   241: astore_1
    //   242: new 167	com/tencent/mm/pointers/PInt
    //   245: dup
    //   246: invokespecial 372	com/tencent/mm/pointers/PInt:<init>	()V
    //   249: astore 9
    //   251: aload 8
    //   253: iload_3
    //   254: iload_2
    //   255: aload_1
    //   256: aload 9
    //   258: invokevirtual 375	com/tencent/mm/plugin/a/j:a	(IILcom/tencent/mm/pointers/PInt;Lcom/tencent/mm/pointers/PInt;)Z
    //   261: pop
    //   262: aload 9
    //   264: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   267: aload 10
    //   269: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   272: if_icmpeq +26 -> 298
    //   275: ldc 152
    //   277: ldc_w 377
    //   280: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   283: ldc_w 333
    //   286: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   289: iconst_0
    //   290: ireturn
    //   291: iload_3
    //   292: iconst_1
    //   293: iadd
    //   294: istore_2
    //   295: goto -89 -> 206
    //   298: aload 6
    //   300: invokestatic 381	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   303: astore 6
    //   305: aload 6
    //   307: aload_0
    //   308: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   311: i2l
    //   312: invokevirtual 387	java/io/InputStream:skip	(J)J
    //   315: pop2
    //   316: sipush 4096
    //   319: newarray byte
    //   321: astore 8
    //   323: aload 6
    //   325: aload 8
    //   327: invokevirtual 389	java/io/InputStream:read	([B)I
    //   330: pop
    //   331: aload 7
    //   333: invokestatic 381	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   336: astore_0
    //   337: aload_0
    //   338: aload_1
    //   339: getfield 170	com/tencent/mm/pointers/PInt:value	I
    //   342: i2l
    //   343: invokevirtual 387	java/io/InputStream:skip	(J)J
    //   346: pop2
    //   347: sipush 4096
    //   350: newarray byte
    //   352: astore_1
    //   353: aload 6
    //   355: aload_1
    //   356: invokevirtual 389	java/io/InputStream:read	([B)I
    //   359: pop
    //   360: aload 8
    //   362: aload_1
    //   363: invokestatic 395	java/util/Arrays:equals	([B[B)Z
    //   366: ifeq +28 -> 394
    //   369: ldc 152
    //   371: ldc_w 397
    //   374: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   377: aload 6
    //   379: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   382: aload_0
    //   383: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   386: ldc_w 333
    //   389: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   392: iconst_0
    //   393: ireturn
    //   394: aload 6
    //   396: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   399: aload_0
    //   400: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   403: ldc_w 333
    //   406: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   409: iconst_1
    //   410: ireturn
    //   411: astore_0
    //   412: aconst_null
    //   413: astore_1
    //   414: aconst_null
    //   415: astore 6
    //   417: ldc 152
    //   419: new 293	java/lang/StringBuilder
    //   422: dup
    //   423: ldc_w 295
    //   426: invokespecial 296	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   429: aload_0
    //   430: invokevirtual 300	java/lang/Exception:toString	()Ljava/lang/String;
    //   433: invokevirtual 304	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 305	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 160	com/tencent/mm/sdk/platformtools/ac:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   442: aload 6
    //   444: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   447: aload_1
    //   448: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   451: goto -48 -> 403
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_1
    //   457: aconst_null
    //   458: astore 6
    //   460: aload 6
    //   462: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   465: aload_1
    //   466: invokestatic 309	com/tencent/mm/plugin/a/e:safeClose	(Ljava/io/Closeable;)V
    //   469: ldc_w 333
    //   472: invokestatic 85	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   475: aload_0
    //   476: athrow
    //   477: astore_0
    //   478: aconst_null
    //   479: astore_1
    //   480: goto -20 -> 460
    //   483: astore 7
    //   485: aload_0
    //   486: astore_1
    //   487: aload 7
    //   489: astore_0
    //   490: goto -30 -> 460
    //   493: astore_0
    //   494: goto -34 -> 460
    //   497: astore_0
    //   498: aconst_null
    //   499: astore_1
    //   500: goto -83 -> 417
    //   503: astore 7
    //   505: aload_0
    //   506: astore_1
    //   507: aload 7
    //   509: astore_0
    //   510: goto -93 -> 417
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	paramString1	java.lang.String
    //   0	513	1	paramString2	java.lang.String
    //   129	166	2	i	int
    //   92	202	3	j	int
    //   67	52	4	l	long
    //   14	447	6	localObject1	Object
    //   24	308	7	locale	com.tencent.mm.vfs.e
    //   483	5	7	localObject2	Object
    //   503	5	7	localException	Exception
    //   113	248	8	localObject3	Object
    //   76	187	9	localObject4	Object
    //   221	47	10	localPInt	PInt
    // Exception table:
    //   from	to	target	type
    //   298	305	411	java/lang/Exception
    //   298	305	454	finally
    //   305	337	477	finally
    //   337	377	483	finally
    //   417	442	493	finally
    //   305	337	497	java/lang/Exception
    //   337	377	503	java/lang/Exception
  }
  
  private static int qA(long paramLong)
  {
    AppMethodBeat.i(133860);
    if ((paramLong > 2147483647L) || (paramLong < 0L))
    {
      Exception localException = new Exception("uint32 value is too large");
      AppMethodBeat.o(133860);
      throw localException;
    }
    int i = (int)paramLong;
    AppMethodBeat.o(133860);
    return i;
  }
  
  private static void safeClose(Closeable paramCloseable)
  {
    AppMethodBeat.i(133862);
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        AppMethodBeat.o(133862);
        return;
      }
      catch (IOException paramCloseable)
      {
        ac.w("MicroMsg.FastStart", "Failed to close file: ");
      }
    }
    AppMethodBeat.o(133862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.a.e
 * JD-Core Version:    0.7.0.1
 */
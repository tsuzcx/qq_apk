package com.bumptech.glide.c.d.a;

import android.util.Log;
import com.bumptech.glide.c.b.a.b;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

public final class f
  implements com.bumptech.glide.c.f
{
  static final byte[] aKV;
  private static final int[] aKW;
  
  static
  {
    AppMethodBeat.i(77383);
    aKV = "".getBytes(Charset.forName("UTF-8"));
    aKW = new int[] { 0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8 };
    AppMethodBeat.o(77383);
  }
  
  private static int a(b paramb)
  {
    AppMethodBeat.i(77382);
    ByteOrder localByteOrder;
    label76:
    int n;
    int m;
    int i1;
    switch (paramb.dr(6))
    {
    default: 
      Log.isLoggable("DfltImageHeaderParser", 3);
      localByteOrder = ByteOrder.BIG_ENDIAN;
      paramb.aKX.order(localByteOrder);
      int j = paramb.dq(10) + 6;
      int k = paramb.dr(j);
      i = 0;
      if (i >= k) {
        break label377;
      }
      n = j + 2 + i * 12;
      m = paramb.dr(n);
      if (m == 274)
      {
        i1 = paramb.dr(n + 2);
        if ((i1 > 0) && (i1 <= 12)) {
          break label161;
        }
        if (!Log.isLoggable("DfltImageHeaderParser", 3)) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      i += 1;
      break label76;
      localByteOrder = ByteOrder.BIG_ENDIAN;
      break;
      localByteOrder = ByteOrder.LITTLE_ENDIAN;
      break;
      label161:
      int i2 = paramb.dq(n + 4);
      if (i2 < 0)
      {
        if (!Log.isLoggable("DfltImageHeaderParser", 3)) {}
      }
      else
      {
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
          new StringBuilder("Got tagIndex=").append(i).append(" tagType=").append(m).append(" formatCode=").append(i1).append(" componentCount=").append(i2);
        }
        i1 = aKW[i1] + i2;
        if (i1 > 4)
        {
          if (!Log.isLoggable("DfltImageHeaderParser", 3)) {}
        }
        else
        {
          n += 8;
          if ((n < 0) || (n > paramb.aKX.remaining()))
          {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
              new StringBuilder("Illegal tagValueOffset=").append(n).append(" tagType=").append(m);
            }
          }
          else
          {
            if ((i1 >= 0) && (n + i1 <= paramb.aKX.remaining())) {
              break label363;
            }
            if (!Log.isLoggable("DfltImageHeaderParser", 3)) {}
          }
        }
      }
    }
    label363:
    int i = paramb.dr(n);
    AppMethodBeat.o(77382);
    return i;
    label377:
    AppMethodBeat.o(77382);
    return -1;
  }
  
  /* Error */
  private static int a(c paramc, b paramb)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 4
    //   3: ldc 123
    //   5: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_0
    //   9: invokeinterface 126 1 0
    //   14: istore_2
    //   15: iload_2
    //   16: ldc 127
    //   18: iand
    //   19: ldc 127
    //   21: if_icmpeq +17 -> 38
    //   24: iload_2
    //   25: sipush 19789
    //   28: if_icmpeq +10 -> 38
    //   31: iload_2
    //   32: sipush 18761
    //   35: if_icmpne +23 -> 58
    //   38: iconst_1
    //   39: istore_2
    //   40: iload_2
    //   41: ifne +22 -> 63
    //   44: ldc 66
    //   46: iconst_3
    //   47: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   50: pop
    //   51: ldc 123
    //   53: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   56: iconst_m1
    //   57: ireturn
    //   58: iconst_0
    //   59: istore_2
    //   60: goto -20 -> 40
    //   63: aload_0
    //   64: invokeinterface 131 1 0
    //   69: sipush 255
    //   72: if_icmpeq +31 -> 103
    //   75: ldc 66
    //   77: iconst_3
    //   78: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   81: pop
    //   82: iconst_m1
    //   83: istore_2
    //   84: iload_2
    //   85: iconst_m1
    //   86: if_icmpne +139 -> 225
    //   89: ldc 66
    //   91: iconst_3
    //   92: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   95: pop
    //   96: ldc 123
    //   98: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_m1
    //   102: ireturn
    //   103: aload_0
    //   104: invokeinterface 131 1 0
    //   109: istore_3
    //   110: iload_3
    //   111: sipush 218
    //   114: if_icmpne +8 -> 122
    //   117: iconst_m1
    //   118: istore_2
    //   119: goto -35 -> 84
    //   122: iload_3
    //   123: sipush 217
    //   126: if_icmpne +15 -> 141
    //   129: ldc 66
    //   131: iconst_3
    //   132: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   135: pop
    //   136: iconst_m1
    //   137: istore_2
    //   138: goto -54 -> 84
    //   141: aload_0
    //   142: invokeinterface 126 1 0
    //   147: iconst_2
    //   148: isub
    //   149: istore_2
    //   150: iload_3
    //   151: sipush 225
    //   154: if_icmpeq +68 -> 222
    //   157: aload_0
    //   158: iload_2
    //   159: i2l
    //   160: invokeinterface 135 3 0
    //   165: lstore 6
    //   167: lload 6
    //   169: iload_2
    //   170: i2l
    //   171: lcmp
    //   172: ifeq -109 -> 63
    //   175: ldc 66
    //   177: iconst_3
    //   178: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   181: ifeq +36 -> 217
    //   184: new 97	java/lang/StringBuilder
    //   187: dup
    //   188: ldc 137
    //   190: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   193: iload_3
    //   194: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   197: ldc 139
    //   199: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload_2
    //   203: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   206: ldc 141
    //   208: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: lload 6
    //   213: invokevirtual 144	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: iconst_m1
    //   218: istore_2
    //   219: goto -135 -> 84
    //   222: goto -138 -> 84
    //   225: aload_1
    //   226: iload_2
    //   227: ldc 145
    //   229: invokeinterface 150 3 0
    //   234: checkcast 145	[B
    //   237: astore 8
    //   239: aload_0
    //   240: aload 8
    //   242: iload_2
    //   243: invokeinterface 154 3 0
    //   248: istore 5
    //   250: iload 5
    //   252: iload_2
    //   253: if_icmpeq +57 -> 310
    //   256: iload 4
    //   258: istore_3
    //   259: ldc 66
    //   261: iconst_3
    //   262: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   265: ifeq +30 -> 295
    //   268: new 97	java/lang/StringBuilder
    //   271: dup
    //   272: ldc 156
    //   274: invokespecial 102	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   277: iload_2
    //   278: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   281: ldc 158
    //   283: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: iload 5
    //   288: invokevirtual 106	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: pop
    //   292: iload 4
    //   294: istore_3
    //   295: aload_1
    //   296: aload 8
    //   298: invokeinterface 162 2 0
    //   303: ldc 123
    //   305: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   308: iload_3
    //   309: ireturn
    //   310: aload 8
    //   312: iload_2
    //   313: invokestatic 165	com/bumptech/glide/c/d/a/f:c	([BI)Z
    //   316: ifeq +20 -> 336
    //   319: new 11	com/bumptech/glide/c/d/a/f$b
    //   322: dup
    //   323: aload 8
    //   325: iload_2
    //   326: invokespecial 168	com/bumptech/glide/c/d/a/f$b:<init>	([BI)V
    //   329: invokestatic 170	com/bumptech/glide/c/d/a/f:a	(Lcom/bumptech/glide/c/d/a/f$b;)I
    //   332: istore_3
    //   333: goto -38 -> 295
    //   336: ldc 66
    //   338: iconst_3
    //   339: invokestatic 72	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   342: pop
    //   343: iload 4
    //   345: istore_3
    //   346: goto -51 -> 295
    //   349: astore_0
    //   350: aload_1
    //   351: aload 8
    //   353: invokeinterface 162 2 0
    //   358: ldc 123
    //   360: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   363: aload_0
    //   364: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	paramc	c
    //   0	365	1	paramb	b
    //   14	312	2	i	int
    //   109	237	3	j	int
    //   1	343	4	k	int
    //   248	39	5	m	int
    //   165	47	6	l	long
    //   237	115	8	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   239	250	349	finally
    //   259	292	349	finally
    //   310	333	349	finally
    //   336	343	349	finally
  }
  
  private static com.bumptech.glide.c.f.a a(c paramc)
  {
    AppMethodBeat.i(77380);
    int i = paramc.pt();
    if (i == 65496)
    {
      paramc = com.bumptech.glide.c.f.a.aEW;
      AppMethodBeat.o(77380);
      return paramc;
    }
    i = i << 16 & 0xFFFF0000 | paramc.pt() & 0xFFFF;
    if (i == -1991225785)
    {
      paramc.skip(21L);
      if (paramc.pv() >= 3)
      {
        paramc = com.bumptech.glide.c.f.a.aEY;
        AppMethodBeat.o(77380);
        return paramc;
      }
      paramc = com.bumptech.glide.c.f.a.aEZ;
      AppMethodBeat.o(77380);
      return paramc;
    }
    if (i >> 8 == 4671814)
    {
      paramc = com.bumptech.glide.c.f.a.aEV;
      AppMethodBeat.o(77380);
      return paramc;
    }
    if (i != 1380533830)
    {
      paramc = com.bumptech.glide.c.f.a.aFc;
      AppMethodBeat.o(77380);
      return paramc;
    }
    paramc.skip(4L);
    if ((paramc.pt() << 16 & 0xFFFF0000 | paramc.pt() & 0xFFFF) != 1464156752)
    {
      paramc = com.bumptech.glide.c.f.a.aFc;
      AppMethodBeat.o(77380);
      return paramc;
    }
    i = paramc.pt() << 16 & 0xFFFF0000 | paramc.pt() & 0xFFFF;
    if ((i & 0xFFFFFF00) != 1448097792)
    {
      paramc = com.bumptech.glide.c.f.a.aFc;
      AppMethodBeat.o(77380);
      return paramc;
    }
    if ((i & 0xFF) == 88)
    {
      paramc.skip(4L);
      if ((paramc.pv() & 0x10) != 0)
      {
        paramc = com.bumptech.glide.c.f.a.aFa;
        AppMethodBeat.o(77380);
        return paramc;
      }
      paramc = com.bumptech.glide.c.f.a.aFb;
      AppMethodBeat.o(77380);
      return paramc;
    }
    if ((i & 0xFF) == 76)
    {
      paramc.skip(4L);
      if ((paramc.pv() & 0x8) != 0)
      {
        paramc = com.bumptech.glide.c.f.a.aFa;
        AppMethodBeat.o(77380);
        return paramc;
      }
      paramc = com.bumptech.glide.c.f.a.aFb;
      AppMethodBeat.o(77380);
      return paramc;
    }
    paramc = com.bumptech.glide.c.f.a.aFb;
    AppMethodBeat.o(77380);
    return paramc;
  }
  
  private static boolean c(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool;
    if ((paramArrayOfByte != null) && (paramInt > aKV.length))
    {
      bool = true;
      if (bool) {
        paramInt = 0;
      }
    }
    else
    {
      for (;;)
      {
        if (paramInt >= aKV.length) {
          return bool;
        }
        if (paramArrayOfByte[paramInt] != aKV[paramInt])
        {
          return false;
          bool = false;
          break;
        }
        paramInt += 1;
      }
    }
    return bool;
  }
  
  public final int a(InputStream paramInputStream, b paramb)
  {
    AppMethodBeat.i(77379);
    int i = a(new d((InputStream)i.checkNotNull(paramInputStream, "Argument must not be null")), (b)i.checkNotNull(paramb, "Argument must not be null"));
    AppMethodBeat.o(77379);
    return i;
  }
  
  public final com.bumptech.glide.c.f.a a(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(77378);
    paramByteBuffer = a(new a((ByteBuffer)i.checkNotNull(paramByteBuffer, "Argument must not be null")));
    AppMethodBeat.o(77378);
    return paramByteBuffer;
  }
  
  public final com.bumptech.glide.c.f.a c(InputStream paramInputStream)
  {
    AppMethodBeat.i(77377);
    paramInputStream = a(new d((InputStream)i.checkNotNull(paramInputStream, "Argument must not be null")));
    AppMethodBeat.o(77377);
    return paramInputStream;
  }
  
  static final class a
    implements f.c
  {
    private final ByteBuffer byteBuffer;
    
    a(ByteBuffer paramByteBuffer)
    {
      AppMethodBeat.i(77362);
      this.byteBuffer = paramByteBuffer;
      paramByteBuffer.order(ByteOrder.BIG_ENDIAN);
      AppMethodBeat.o(77362);
    }
    
    public final int pt()
    {
      AppMethodBeat.i(77363);
      int i = pv();
      int j = pv();
      AppMethodBeat.o(77363);
      return i << 8 & 0xFF00 | j & 0xFF;
    }
    
    public final short pu()
    {
      AppMethodBeat.i(77364);
      short s = (short)(pv() & 0xFF);
      AppMethodBeat.o(77364);
      return s;
    }
    
    public final int pv()
    {
      AppMethodBeat.i(77367);
      if (this.byteBuffer.remaining() <= 0)
      {
        AppMethodBeat.o(77367);
        return -1;
      }
      int i = this.byteBuffer.get();
      AppMethodBeat.o(77367);
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(77366);
      paramInt = Math.min(paramInt, this.byteBuffer.remaining());
      if (paramInt == 0)
      {
        AppMethodBeat.o(77366);
        return -1;
      }
      this.byteBuffer.get(paramArrayOfByte, 0, paramInt);
      AppMethodBeat.o(77366);
      return paramInt;
    }
    
    public final long skip(long paramLong)
    {
      AppMethodBeat.i(77365);
      int i = (int)Math.min(this.byteBuffer.remaining(), paramLong);
      this.byteBuffer.position(this.byteBuffer.position() + i);
      paramLong = i;
      AppMethodBeat.o(77365);
      return paramLong;
    }
  }
  
  static final class b
  {
    final ByteBuffer aKX;
    
    b(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(77368);
      this.aKX = ((ByteBuffer)ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.BIG_ENDIAN).limit(paramInt));
      AppMethodBeat.o(77368);
    }
    
    private boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(77371);
      if (this.aKX.remaining() - paramInt1 >= paramInt2)
      {
        AppMethodBeat.o(77371);
        return true;
      }
      AppMethodBeat.o(77371);
      return false;
    }
    
    final int dq(int paramInt)
    {
      AppMethodBeat.i(77369);
      if (aV(paramInt, 4))
      {
        paramInt = this.aKX.getInt(paramInt);
        AppMethodBeat.o(77369);
        return paramInt;
      }
      AppMethodBeat.o(77369);
      return -1;
    }
    
    final short dr(int paramInt)
    {
      AppMethodBeat.i(77370);
      if (aV(paramInt, 2))
      {
        short s = this.aKX.getShort(paramInt);
        AppMethodBeat.o(77370);
        return s;
      }
      AppMethodBeat.o(77370);
      return -1;
    }
  }
  
  static abstract interface c
  {
    public abstract int pt();
    
    public abstract short pu();
    
    public abstract int pv();
    
    public abstract int read(byte[] paramArrayOfByte, int paramInt);
    
    public abstract long skip(long paramLong);
  }
  
  static final class d
    implements f.c
  {
    private final InputStream aKY;
    
    d(InputStream paramInputStream)
    {
      this.aKY = paramInputStream;
    }
    
    public final int pt()
    {
      AppMethodBeat.i(77372);
      int i = this.aKY.read();
      int j = this.aKY.read();
      AppMethodBeat.o(77372);
      return i << 8 & 0xFF00 | j & 0xFF;
    }
    
    public final short pu()
    {
      AppMethodBeat.i(77373);
      short s = (short)(this.aKY.read() & 0xFF);
      AppMethodBeat.o(77373);
      return s;
    }
    
    public final int pv()
    {
      AppMethodBeat.i(77376);
      int i = this.aKY.read();
      AppMethodBeat.o(77376);
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt)
    {
      AppMethodBeat.i(77375);
      int i = paramInt;
      while (i > 0)
      {
        int j = this.aKY.read(paramArrayOfByte, paramInt - i, i);
        if (j == -1) {
          break;
        }
        i -= j;
      }
      AppMethodBeat.o(77375);
      return paramInt - i;
    }
    
    public final long skip(long paramLong)
    {
      AppMethodBeat.i(77374);
      if (paramLong < 0L)
      {
        AppMethodBeat.o(77374);
        return 0L;
      }
      long l1 = paramLong;
      while (l1 > 0L)
      {
        long l2 = this.aKY.skip(l1);
        if (l2 > 0L)
        {
          l1 -= l2;
        }
        else
        {
          if (this.aKY.read() == -1) {
            break;
          }
          l1 -= 1L;
        }
      }
      AppMethodBeat.o(77374);
      return paramLong - l1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.d.a.f
 * JD-Core Version:    0.7.0.1
 */
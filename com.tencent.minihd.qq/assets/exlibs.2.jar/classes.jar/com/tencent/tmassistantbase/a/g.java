package com.tencent.tmassistantbase.a;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public class g
{
  static final byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  protected final long[] b = new long[4];
  protected final long[] c = new long[2];
  protected final byte[] d = new byte[64];
  protected final byte[] e = new byte[16];
  
  public g()
  {
    a();
  }
  
  public static long a(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong2 | (0xFFFFFFFF ^ paramLong1) & paramLong3;
  }
  
  private long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = a(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    try
    {
      arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        int i;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new g().a(paramString);
    paramString = "";
    i = 0;
    while (i < 16)
    {
      paramString = paramString + b(arrayOfByte[i]);
      i += 1;
    }
    return paramString;
  }
  
  private void a()
  {
    this.c[0] = 0L;
    this.c[1] = 0L;
    this.b[0] = 1732584193L;
    this.b[1] = 4023233417L;
    this.b[2] = 2562383102L;
    this.b[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int j = 0;
    byte[] arrayOfByte = new byte[64];
    int k = (int)(this.c[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.c;
    long l = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l;
    if (l < paramInt << 3)
    {
      arrayOfLong = this.c;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.c;
    arrayOfLong[1] += (paramInt >>> 29);
    int m = 64 - k;
    int i = k;
    if (paramInt >= m)
    {
      a(this.d, paramArrayOfByte, k, 0, m);
      b(this.d);
      i = m;
      while (i + 63 < paramInt)
      {
        a(arrayOfByte, paramArrayOfByte, 0, i, 64);
        b(arrayOfByte);
        i += 64;
      }
      k = 0;
      j = i;
      i = k;
    }
    a(this.d, paramArrayOfByte, i, j, paramInt - j);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i)] = paramArrayOfByte2[(paramInt2 + i)];
      i += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(int)(paramArrayOfLong[j] & 0xFF));
      paramArrayOfByte[(i + 1)] = ((byte)(int)(paramArrayOfLong[j] >>> 8 & 0xFF));
      paramArrayOfByte[(i + 2)] = ((byte)(int)(paramArrayOfLong[j] >>> 16 & 0xFF));
      paramArrayOfByte[(i + 3)] = ((byte)(int)(paramArrayOfLong[j] >>> 24 & 0xFF));
      j += 1;
      i += 4;
    }
  }
  
  private void a(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i = 0;
    int j = 0;
    while (i < paramInt)
    {
      paramArrayOfLong[j] = (a(paramArrayOfByte[i]) | a(paramArrayOfByte[(i + 1)]) << 8 | a(paramArrayOfByte[(i + 2)]) << 16 | a(paramArrayOfByte[(i + 3)]) << 24);
      j += 1;
      i += 4;
    }
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: bipush 64
    //   2: newarray byte
    //   4: astore 8
    //   6: aload_0
    //   7: getfield 25	com/tencent/tmassistantbase/a/g:c	[J
    //   10: iconst_0
    //   11: laload
    //   12: iconst_3
    //   13: lushr
    //   14: l2i
    //   15: bipush 63
    //   17: iand
    //   18: istore 5
    //   20: aload_0
    //   21: getfield 25	com/tencent/tmassistantbase/a/g:c	[J
    //   24: astore 9
    //   26: aload 9
    //   28: iconst_0
    //   29: laload
    //   30: lload_2
    //   31: iconst_3
    //   32: lshl
    //   33: ladd
    //   34: lstore 6
    //   36: aload 9
    //   38: iconst_0
    //   39: lload 6
    //   41: lastore
    //   42: lload 6
    //   44: lload_2
    //   45: iconst_3
    //   46: lshl
    //   47: lcmp
    //   48: ifge +19 -> 67
    //   51: aload_0
    //   52: getfield 25	com/tencent/tmassistantbase/a/g:c	[J
    //   55: astore 9
    //   57: aload 9
    //   59: iconst_1
    //   60: aload 9
    //   62: iconst_1
    //   63: laload
    //   64: lconst_1
    //   65: ladd
    //   66: lastore
    //   67: aload_0
    //   68: getfield 25	com/tencent/tmassistantbase/a/g:c	[J
    //   71: astore 9
    //   73: aload 9
    //   75: iconst_1
    //   76: aload 9
    //   78: iconst_1
    //   79: laload
    //   80: lload_2
    //   81: bipush 29
    //   83: lushr
    //   84: ladd
    //   85: lastore
    //   86: bipush 64
    //   88: iload 5
    //   90: isub
    //   91: istore 4
    //   93: lload_2
    //   94: iload 4
    //   96: i2l
    //   97: lcmp
    //   98: iflt +114 -> 212
    //   101: iload 4
    //   103: newarray byte
    //   105: astore 9
    //   107: aload_1
    //   108: aload 9
    //   110: iconst_0
    //   111: iload 4
    //   113: invokevirtual 104	java/io/InputStream:read	([BII)I
    //   116: pop
    //   117: aload_0
    //   118: aload_0
    //   119: getfield 27	com/tencent/tmassistantbase/a/g:d	[B
    //   122: aload 9
    //   124: iload 5
    //   126: iconst_0
    //   127: iload 4
    //   129: invokespecial 86	com/tencent/tmassistantbase/a/g:a	([B[BIII)V
    //   132: aload_0
    //   133: aload_0
    //   134: getfield 27	com/tencent/tmassistantbase/a/g:d	[B
    //   137: invokespecial 89	com/tencent/tmassistantbase/a/g:b	([B)V
    //   140: iload 4
    //   142: bipush 63
    //   144: iadd
    //   145: i2l
    //   146: lload_2
    //   147: lcmp
    //   148: ifge +26 -> 174
    //   151: aload_1
    //   152: aload 8
    //   154: invokevirtual 107	java/io/InputStream:read	([B)I
    //   157: pop
    //   158: aload_0
    //   159: aload 8
    //   161: invokespecial 89	com/tencent/tmassistantbase/a/g:b	([B)V
    //   164: iload 4
    //   166: bipush 64
    //   168: iadd
    //   169: istore 4
    //   171: goto -31 -> 140
    //   174: iconst_0
    //   175: istore 5
    //   177: lload_2
    //   178: iload 4
    //   180: i2l
    //   181: lsub
    //   182: l2i
    //   183: newarray byte
    //   185: astore 8
    //   187: aload_1
    //   188: aload 8
    //   190: invokevirtual 107	java/io/InputStream:read	([B)I
    //   193: pop
    //   194: aload_0
    //   195: aload_0
    //   196: getfield 27	com/tencent/tmassistantbase/a/g:d	[B
    //   199: aload 8
    //   201: iload 5
    //   203: iconst_0
    //   204: aload 8
    //   206: arraylength
    //   207: invokespecial 86	com/tencent/tmassistantbase/a/g:a	([B[BIII)V
    //   210: iconst_1
    //   211: ireturn
    //   212: iconst_0
    //   213: istore 4
    //   215: goto -38 -> 177
    //   218: astore_1
    //   219: iconst_0
    //   220: ireturn
    //   221: astore_1
    //   222: iconst_0
    //   223: ireturn
    //   224: astore_1
    //   225: iconst_0
    //   226: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	227	0	this	g
    //   0	227	1	paramInputStream	java.io.InputStream
    //   0	227	2	paramLong	long
    //   91	123	4	i	int
    //   18	184	5	j	int
    //   34	9	6	l	long
    //   4	201	8	arrayOfByte	byte[]
    //   24	99	9	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   107	117	218	java/lang/Exception
    //   151	158	221	java/lang/Exception
    //   187	194	224	java/lang/Exception
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = b(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String b(byte paramByte)
  {
    char[] arrayOfChar = new char[16];
    char[] tmp6_5 = arrayOfChar;
    tmp6_5[0] = 48;
    char[] tmp11_6 = tmp6_5;
    tmp11_6[1] = 49;
    char[] tmp16_11 = tmp11_6;
    tmp16_11[2] = 50;
    char[] tmp21_16 = tmp16_11;
    tmp21_16[3] = 51;
    char[] tmp26_21 = tmp21_16;
    tmp26_21[4] = 52;
    char[] tmp31_26 = tmp26_21;
    tmp31_26[5] = 53;
    char[] tmp36_31 = tmp31_26;
    tmp36_31[6] = 54;
    char[] tmp42_36 = tmp36_31;
    tmp42_36[7] = 55;
    char[] tmp48_42 = tmp42_36;
    tmp48_42[8] = 56;
    char[] tmp54_48 = tmp48_42;
    tmp54_48[9] = 57;
    char[] tmp60_54 = tmp54_48;
    tmp60_54[10] = 65;
    char[] tmp66_60 = tmp60_54;
    tmp66_60[11] = 66;
    char[] tmp72_66 = tmp66_60;
    tmp72_66[12] = 67;
    char[] tmp78_72 = tmp72_66;
    tmp78_72[13] = 68;
    char[] tmp84_78 = tmp78_72;
    tmp84_78[14] = 69;
    char[] tmp90_84 = tmp84_78;
    tmp90_84[15] = 70;
    tmp90_84;
    return new String(new char[] { arrayOfChar[(paramByte >>> 4 & 0xF)], arrayOfChar[(paramByte & 0xF)] });
  }
  
  private void b()
  {
    byte[] arrayOfByte = new byte[8];
    a(arrayOfByte, this.c, 8);
    int i = (int)(this.c[0] >>> 3) & 0x3F;
    if (i < 56) {}
    for (i = 56 - i;; i = 120 - i)
    {
      a(a, i);
      a(arrayOfByte, 8);
      a(this.e, this.b, 16);
      return;
    }
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    long l2 = this.b[0];
    long l1 = this.b[1];
    long l4 = this.b[2];
    long l3 = this.b[3];
    long[] arrayOfLong = new long[16];
    a(arrayOfLong, paramArrayOfByte, 64);
    l2 = a(l2, l1, l4, l3, arrayOfLong[0], 7L, 3614090360L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[1], 12L, 3905402710L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[2], 17L, 606105819L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[3], 22L, 3250441966L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[4], 7L, 4118548399L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[5], 12L, 1200080426L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[6], 17L, 2821735955L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[7], 22L, 4249261313L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[8], 7L, 1770035416L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[9], 12L, 2336552879L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[10], 17L, 4294925233L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[11], 22L, 2304563134L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[12], 7L, 1804603682L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[13], 12L, 4254626195L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[14], 17L, 2792965006L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[15], 22L, 1236535329L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[1], 5L, 4129170786L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[6], 9L, 3225465664L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[11], 14L, 643717713L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[0], 20L, 3921069994L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[5], 5L, 3593408605L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[10], 9L, 38016083L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[15], 14L, 3634488961L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[4], 20L, 3889429448L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[9], 5L, 568446438L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[14], 9L, 3275163606L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[3], 14L, 4107603335L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[8], 20L, 1163531501L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[13], 5L, 2850285829L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[2], 9L, 4243563512L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[7], 14L, 1735328473L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[12], 20L, 2368359562L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[5], 4L, 4294588738L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[8], 11L, 2272392833L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[11], 16L, 1839030562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[14], 23L, 4259657740L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[1], 4L, 2763975236L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[4], 11L, 1272893353L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[7], 16L, 4139469664L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[10], 23L, 3200236656L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[13], 4L, 681279174L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[0], 11L, 3936430074L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[3], 16L, 3572445317L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[6], 23L, 76029189L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[9], 4L, 3654602809L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[12], 11L, 3873151461L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[15], 16L, 530742520L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[2], 23L, 3299628645L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[0], 6L, 4096336452L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[7], 10L, 1126891415L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[14], 15L, 2878612391L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[5], 21L, 4237533241L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[12], 6L, 1700485571L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[3], 10L, 2399980690L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[10], 15L, 4293915773L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[1], 21L, 2240044497L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[8], 6L, 1873313359L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[15], 10L, 4264355552L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[6], 15L, 2734768916L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[13], 21L, 1309151649L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[4], 6L, 4149444226L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[11], 10L, 3174756917L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[2], 15L, 718787259L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte = this.b;
    paramArrayOfByte[1] = (l1 + paramArrayOfByte[1]);
    paramArrayOfByte = this.b;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.b;
    paramArrayOfByte[3] += l3;
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = c(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = d(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    a();
    a(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    b();
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantbase.a.g
 * JD-Core Version:    0.7.0.1
 */
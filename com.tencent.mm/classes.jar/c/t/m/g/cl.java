package c.t.m.g;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

public final class cl
{
  private static byte[] a = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private long[] b = new long[4];
  private long[] c = new long[2];
  private byte[] d = new byte[64];
  private byte[] e = new byte[16];
  
  public cl()
  {
    a();
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong3 | (0xFFFFFFFF ^ paramLong2) & paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  public static String a(String paramString)
  {
    try
    {
      localObject = paramString.getBytes("ISO8859_1");
      paramString = (String)localObject;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject;
        paramString = paramString.getBytes();
        continue;
        int i = 120 - i;
      }
      return localUnsupportedEncodingException.toString();
    }
    localObject = new cl();
    ((cl)localObject).a();
    ((cl)localObject).a(new ByteArrayInputStream(paramString), paramString.length);
    paramString = new byte[8];
    a(paramString, ((cl)localObject).c, 8);
    i = (int)(localObject.c[0] >>> 3) & 0x3F;
    if (i < 56)
    {
      i = 56 - i;
      ((cl)localObject).a(a, i);
      ((cl)localObject).a(paramString, 8);
      a(((cl)localObject).e, ((cl)localObject).b, 16);
      paramString = ((cl)localObject).e;
      localObject = new StringBuilder();
      i = 0;
      while (i < 16)
      {
        int j = paramString[i];
        char[] arrayOfChar = new char[16];
        char[] tmp137_135 = arrayOfChar;
        tmp137_135[0] = 48;
        char[] tmp142_137 = tmp137_135;
        tmp142_137[1] = 49;
        char[] tmp147_142 = tmp142_137;
        tmp147_142[2] = 50;
        char[] tmp152_147 = tmp147_142;
        tmp152_147[3] = 51;
        char[] tmp157_152 = tmp152_147;
        tmp157_152[4] = 52;
        char[] tmp162_157 = tmp157_152;
        tmp162_157[5] = 53;
        char[] tmp167_162 = tmp162_157;
        tmp167_162[6] = 54;
        char[] tmp173_167 = tmp167_162;
        tmp173_167[7] = 55;
        char[] tmp179_173 = tmp173_167;
        tmp179_173[8] = 56;
        char[] tmp185_179 = tmp179_173;
        tmp185_179[9] = 57;
        char[] tmp191_185 = tmp185_179;
        tmp191_185[10] = 65;
        char[] tmp197_191 = tmp191_185;
        tmp197_191[11] = 66;
        char[] tmp203_197 = tmp197_191;
        tmp203_197[12] = 67;
        char[] tmp209_203 = tmp203_197;
        tmp209_203[13] = 68;
        char[] tmp215_209 = tmp209_203;
        tmp215_209[14] = 69;
        char[] tmp221_215 = tmp215_209;
        tmp221_215[15] = 70;
        tmp221_215;
        ((StringBuilder)localObject).append(new String(new char[] { arrayOfChar[(j >>> 4 & 0xF)], arrayOfChar[(j & 0xF)] }));
        i += 1;
      }
    }
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
  
  private void a(byte[] paramArrayOfByte)
  {
    long l8 = this.b[0];
    long l5 = this.b[1];
    long l6 = this.b[2];
    long l7 = this.b[3];
    long[] arrayOfLong = new long[16];
    int j = 0;
    int i = 0;
    if (j < 64)
    {
      int k = paramArrayOfByte[j];
      if (k < 0)
      {
        l1 = k & 0xFF;
        label67:
        k = paramArrayOfByte[(j + 1)];
        if (k >= 0) {
          break label173;
        }
        l2 = k & 0xFF;
        label88:
        k = paramArrayOfByte[(j + 2)];
        if (k >= 0) {
          break label181;
        }
        l3 = k & 0xFF;
        label109:
        k = paramArrayOfByte[(j + 3)];
        if (k >= 0) {
          break label189;
        }
      }
      label173:
      label181:
      label189:
      for (l4 = k & 0xFF;; l4 = k)
      {
        arrayOfLong[i] = (l4 << 24 | l2 << 8 | l1 | l3 << 16);
        j += 4;
        i += 1;
        break;
        l1 = k;
        break label67;
        l2 = k;
        break label88;
        l3 = k;
        break label109;
      }
    }
    long l1 = a(l8, l5, l6, l7, arrayOfLong[0], 7L, 3614090360L);
    long l2 = a(l7, l1, l5, l6, arrayOfLong[1], 12L, 3905402710L);
    long l3 = a(l6, l2, l1, l5, arrayOfLong[2], 17L, 606105819L);
    long l4 = a(l5, l3, l2, l1, arrayOfLong[3], 22L, 3250441966L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[4], 7L, 4118548399L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[5], 12L, 1200080426L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[6], 17L, 2821735955L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[7], 22L, 4249261313L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[8], 7L, 1770035416L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[9], 12L, 2336552879L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[10], 17L, 4294925233L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[11], 22L, 2304563134L);
    l1 = a(l1, l4, l3, l2, arrayOfLong[12], 7L, 1804603682L);
    l2 = a(l2, l1, l4, l3, arrayOfLong[13], 12L, 4254626195L);
    l3 = a(l3, l2, l1, l4, arrayOfLong[14], 17L, 2792965006L);
    l4 = a(l4, l3, l2, l1, arrayOfLong[15], 22L, 1236535329L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[1], 5L, 4129170786L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[6], 9L, 3225465664L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[11], 14L, 643717713L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[0], 20L, 3921069994L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[5], 5L, 3593408605L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[10], 9L, 38016083L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[15], 14L, 3634488961L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[4], 20L, 3889429448L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[9], 5L, 568446438L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[14], 9L, 3275163606L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[3], 14L, 4107603335L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[8], 20L, 1163531501L);
    l1 = b(l1, l4, l3, l2, arrayOfLong[13], 5L, 2850285829L);
    l2 = b(l2, l1, l4, l3, arrayOfLong[2], 9L, 4243563512L);
    l3 = b(l3, l2, l1, l4, arrayOfLong[7], 14L, 1735328473L);
    l4 = b(l4, l3, l2, l1, arrayOfLong[12], 20L, 2368359562L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[5], 4L, 4294588738L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[8], 11L, 2272392833L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[11], 16L, 1839030562L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[14], 23L, 4259657740L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[1], 4L, 2763975236L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[4], 11L, 1272893353L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[7], 16L, 4139469664L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[10], 23L, 3200236656L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[13], 4L, 681279174L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[0], 11L, 3936430074L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[3], 16L, 3572445317L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[6], 23L, 76029189L);
    l1 = c(l1, l4, l3, l2, arrayOfLong[9], 4L, 3654602809L);
    l2 = c(l2, l1, l4, l3, arrayOfLong[12], 11L, 3873151461L);
    l3 = c(l3, l2, l1, l4, arrayOfLong[15], 16L, 530742520L);
    l4 = c(l4, l3, l2, l1, arrayOfLong[2], 23L, 3299628645L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[0], 6L, 4096336452L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[7], 10L, 1126891415L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[14], 15L, 2878612391L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[5], 21L, 4237533241L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[12], 6L, 1700485571L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[3], 10L, 2399980690L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[10], 15L, 4293915773L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[1], 21L, 2240044497L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[8], 6L, 1873313359L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[15], 10L, 4264355552L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[6], 15L, 2734768916L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[13], 21L, 1309151649L);
    l1 = d(l1, l4, l3, l2, arrayOfLong[4], 6L, 4149444226L);
    l2 = d(l2, l1, l4, l3, arrayOfLong[11], 10L, 3174756917L);
    l3 = d(l3, l2, l1, l4, arrayOfLong[2], 15L, 718787259L);
    l4 = d(l4, l3, l2, l1, arrayOfLong[9], 21L, 3951481745L);
    paramArrayOfByte = this.b;
    paramArrayOfByte[0] += l1;
    paramArrayOfByte = this.b;
    paramArrayOfByte[1] = (l4 + paramArrayOfByte[1]);
    paramArrayOfByte = this.b;
    paramArrayOfByte[2] += l3;
    paramArrayOfByte = this.b;
    paramArrayOfByte[3] += l2;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int k = 0;
    byte[] arrayOfByte = new byte[64];
    int j = (int)(this.c[0] >>> 3) & 0x3F;
    Object localObject = this.c;
    long l = localObject[0] + (paramInt << 3);
    localObject[0] = l;
    if (l < paramInt << 3)
    {
      localObject = this.c;
      localObject[1] += 1L;
    }
    localObject = this.c;
    localObject[1] += (paramInt >>> 29);
    int m = 64 - j;
    int i;
    if (paramInt >= m)
    {
      localObject = this.d;
      i = 0;
      while (i < m)
      {
        localObject[(j + i)] = paramArrayOfByte[i];
        i += 1;
      }
      a(this.d);
      i = m;
      while (i + 63 < paramInt)
      {
        j = 0;
        while (j < 64)
        {
          arrayOfByte[j] = paramArrayOfByte[(i + j)];
          j += 1;
        }
        a(arrayOfByte);
        i += 64;
      }
      j = 0;
    }
    for (;;)
    {
      arrayOfByte = this.d;
      while (k < paramInt - i)
      {
        arrayOfByte[(j + k)] = paramArrayOfByte[(i + k)];
        k += 1;
      }
      i = 0;
    }
  }
  
  private static void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int j = 0;
    int i = 0;
    while (j < paramInt)
    {
      paramArrayOfByte[j] = ((byte)(int)(paramArrayOfLong[i] & 0xFF));
      paramArrayOfByte[(j + 1)] = ((byte)(int)(paramArrayOfLong[i] >>> 8 & 0xFF));
      paramArrayOfByte[(j + 2)] = ((byte)(int)(paramArrayOfLong[i] >>> 16 & 0xFF));
      paramArrayOfByte[(j + 3)] = ((byte)(int)(paramArrayOfLong[i] >>> 24 & 0xFF));
      j += 4;
      i += 1;
    }
  }
  
  /* Error */
  private boolean a(java.io.InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: bipush 64
    //   5: newarray byte
    //   7: astore 10
    //   9: aload_0
    //   10: getfield 25	c/t/m/g/cl:c	[J
    //   13: iconst_0
    //   14: laload
    //   15: iconst_3
    //   16: lushr
    //   17: l2i
    //   18: bipush 63
    //   20: iand
    //   21: istore 5
    //   23: aload_0
    //   24: getfield 25	c/t/m/g/cl:c	[J
    //   27: astore 11
    //   29: aload 11
    //   31: iconst_0
    //   32: laload
    //   33: lload_2
    //   34: iconst_3
    //   35: lshl
    //   36: ladd
    //   37: lstore 8
    //   39: aload 11
    //   41: iconst_0
    //   42: lload 8
    //   44: lastore
    //   45: lload 8
    //   47: lload_2
    //   48: iconst_3
    //   49: lshl
    //   50: lcmp
    //   51: ifge +19 -> 70
    //   54: aload_0
    //   55: getfield 25	c/t/m/g/cl:c	[J
    //   58: astore 11
    //   60: aload 11
    //   62: iconst_1
    //   63: aload 11
    //   65: iconst_1
    //   66: laload
    //   67: lconst_1
    //   68: ladd
    //   69: lastore
    //   70: aload_0
    //   71: getfield 25	c/t/m/g/cl:c	[J
    //   74: astore 11
    //   76: aload 11
    //   78: iconst_1
    //   79: aload 11
    //   81: iconst_1
    //   82: laload
    //   83: lload_2
    //   84: bipush 29
    //   86: lushr
    //   87: ladd
    //   88: lastore
    //   89: bipush 64
    //   91: iload 5
    //   93: isub
    //   94: istore 7
    //   96: lload_2
    //   97: iload 7
    //   99: i2l
    //   100: lcmp
    //   101: iflt +165 -> 266
    //   104: iload 7
    //   106: newarray byte
    //   108: astore 11
    //   110: aload_1
    //   111: aload 11
    //   113: iconst_0
    //   114: iload 7
    //   116: invokevirtual 283	java/io/InputStream:read	([BII)I
    //   119: pop
    //   120: aload_0
    //   121: getfield 27	c/t/m/g/cl:d	[B
    //   124: astore 12
    //   126: iconst_0
    //   127: istore 4
    //   129: iload 4
    //   131: iload 7
    //   133: if_icmpge +25 -> 158
    //   136: aload 12
    //   138: iload 5
    //   140: iload 4
    //   142: iadd
    //   143: aload 11
    //   145: iload 4
    //   147: baload
    //   148: bastore
    //   149: iload 4
    //   151: iconst_1
    //   152: iadd
    //   153: istore 4
    //   155: goto -26 -> 129
    //   158: aload_0
    //   159: aload_0
    //   160: getfield 27	c/t/m/g/cl:d	[B
    //   163: invokespecial 273	c/t/m/g/cl:a	([B)V
    //   166: iload 7
    //   168: istore 4
    //   170: iload 4
    //   172: bipush 63
    //   174: iadd
    //   175: i2l
    //   176: lload_2
    //   177: lcmp
    //   178: ifge +26 -> 204
    //   181: aload_1
    //   182: aload 10
    //   184: invokevirtual 286	java/io/InputStream:read	([B)I
    //   187: pop
    //   188: aload_0
    //   189: aload 10
    //   191: invokespecial 273	c/t/m/g/cl:a	([B)V
    //   194: iload 4
    //   196: bipush 64
    //   198: iadd
    //   199: istore 4
    //   201: goto -31 -> 170
    //   204: iconst_0
    //   205: istore 5
    //   207: lload_2
    //   208: iload 4
    //   210: i2l
    //   211: lsub
    //   212: l2i
    //   213: newarray byte
    //   215: astore 10
    //   217: aload_1
    //   218: aload 10
    //   220: invokevirtual 286	java/io/InputStream:read	([B)I
    //   223: pop
    //   224: aload_0
    //   225: getfield 27	c/t/m/g/cl:d	[B
    //   228: astore_1
    //   229: aload 10
    //   231: arraylength
    //   232: istore 7
    //   234: iload 6
    //   236: istore 4
    //   238: iload 4
    //   240: iload 7
    //   242: if_icmpge +30 -> 272
    //   245: aload_1
    //   246: iload 5
    //   248: iload 4
    //   250: iadd
    //   251: aload 10
    //   253: iload 4
    //   255: baload
    //   256: bastore
    //   257: iload 4
    //   259: iconst_1
    //   260: iadd
    //   261: istore 4
    //   263: goto -25 -> 238
    //   266: iconst_0
    //   267: istore 4
    //   269: goto -62 -> 207
    //   272: iconst_1
    //   273: ireturn
    //   274: astore_1
    //   275: iconst_0
    //   276: ireturn
    //   277: astore_1
    //   278: iconst_0
    //   279: ireturn
    //   280: astore_1
    //   281: iconst_0
    //   282: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	283	0	this	cl
    //   0	283	1	paramInputStream	java.io.InputStream
    //   0	283	2	paramLong	long
    //   127	141	4	i	int
    //   21	230	5	j	int
    //   1	234	6	k	int
    //   94	149	7	m	int
    //   37	9	8	l	long
    //   7	245	10	arrayOfByte1	byte[]
    //   27	117	11	localObject	Object
    //   124	13	12	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   110	120	274	java/lang/Exception
    //   181	188	277	java/lang/Exception
    //   217	224	280	java/lang/Exception
  }
  
  private static long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 & paramLong4 | (0xFFFFFFFF ^ paramLong4) & paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = (paramLong2 ^ paramLong3 ^ paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
  
  private static long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = ((0xFFFFFFFF ^ paramLong4 | paramLong2) ^ paramLong3) + paramLong5 + paramLong7 + paramLong1;
    int i = (int)paramLong1;
    int j = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i << j) + paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.g.cl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.open.base;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.HexUtil;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import ler;
import les;

public class MD5Utils
{
  static final int jdField_a_of_type_Int = 7;
  protected static Comparator a;
  protected static List a;
  static final byte[] jdField_a_of_type_ArrayOfByte = { -128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  static final int jdField_b_of_type_Int = 12;
  protected static Comparator b;
  static final int jdField_c_of_type_Int = 17;
  static final int d = 22;
  static final int e = 5;
  static final int f = 9;
  static final int g = 14;
  static final int h = 20;
  static final int i = 4;
  static final int j = 11;
  static final int k = 16;
  static final int l = 23;
  static final int m = 6;
  static final int n = 10;
  static final int o = 15;
  static final int p = 21;
  public String a;
  private long[] jdField_a_of_type_ArrayOfLong = new long[4];
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[64];
  private long[] jdField_b_of_type_ArrayOfLong = new long[2];
  private byte[] jdField_c_of_type_ArrayOfByte;
  
  static
  {
    jdField_a_of_type_JavaUtilComparator = new les();
    jdField_b_of_type_JavaUtilComparator = new ler();
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public MD5Utils()
  {
    this.c = new byte[16];
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
    int i1 = (int)paramLong1;
    int i2 = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i1 << i2) + paramLong2;
  }
  
  public static String a(byte paramByte)
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
  
  public static String a(String paramString)
  {
    return HexUtil.a(a(paramString));
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    return HexUtil.a(a(paramArrayOfByte));
  }
  
  private void a()
  {
    this.jdField_b_of_type_ArrayOfLong[0] = 0L;
    this.jdField_b_of_type_ArrayOfLong[1] = 0L;
    this.jdField_a_of_type_ArrayOfLong[0] = 1732584193L;
    this.jdField_a_of_type_ArrayOfLong[1] = 4023233417L;
    this.jdField_a_of_type_ArrayOfLong[2] = 2562383102L;
    this.jdField_a_of_type_ArrayOfLong[3] = 271733878L;
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    long l2 = this.jdField_a_of_type_ArrayOfLong[0];
    long l1 = this.jdField_a_of_type_ArrayOfLong[1];
    long l4 = this.jdField_a_of_type_ArrayOfLong[2];
    long l3 = this.jdField_a_of_type_ArrayOfLong[3];
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
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[0] += l2;
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[1] = (l1 + paramArrayOfByte[1]);
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[2] += l4;
    paramArrayOfByte = this.jdField_a_of_type_ArrayOfLong;
    paramArrayOfByte[3] += l3;
  }
  
  private void a(byte[] paramArrayOfByte, int paramInt)
  {
    int i2 = 0;
    byte[] arrayOfByte = new byte[64];
    int i3 = (int)(this.jdField_b_of_type_ArrayOfLong[0] >>> 3) & 0x3F;
    long[] arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
    long l1 = arrayOfLong[0] + (paramInt << 3);
    arrayOfLong[0] = l1;
    if (l1 < paramInt << 3)
    {
      arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
      arrayOfLong[1] += 1L;
    }
    arrayOfLong = this.jdField_b_of_type_ArrayOfLong;
    arrayOfLong[1] += (paramInt >>> 29);
    int i4 = 64 - i3;
    int i1 = i3;
    if (paramInt >= i4)
    {
      a(this.jdField_b_of_type_ArrayOfByte, paramArrayOfByte, i3, 0, i4);
      a(this.jdField_b_of_type_ArrayOfByte);
      i1 = i4;
      while (i1 + 63 < paramInt)
      {
        a(arrayOfByte, paramArrayOfByte, 0, i1, 64);
        a(arrayOfByte);
        i1 += 64;
      }
      i3 = 0;
      i2 = i1;
      i1 = i3;
    }
    a(this.jdField_b_of_type_ArrayOfByte, paramArrayOfByte, i1, i2, paramInt - i2);
  }
  
  private void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = 0;
    while (i1 < paramInt3)
    {
      paramArrayOfByte1[(paramInt1 + i1)] = paramArrayOfByte2[(paramInt2 + i1)];
      i1 += 1;
    }
  }
  
  private void a(byte[] paramArrayOfByte, long[] paramArrayOfLong, int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramInt)
    {
      paramArrayOfByte[i1] = ((byte)(int)(paramArrayOfLong[i2] & 0xFF));
      paramArrayOfByte[(i1 + 1)] = ((byte)(int)(paramArrayOfLong[i2] >>> 8 & 0xFF));
      paramArrayOfByte[(i1 + 2)] = ((byte)(int)(paramArrayOfLong[i2] >>> 16 & 0xFF));
      paramArrayOfByte[(i1 + 3)] = ((byte)(int)(paramArrayOfLong[i2] >>> 24 & 0xFF));
      i2 += 1;
      i1 += 4;
    }
  }
  
  private void a(long[] paramArrayOfLong, byte[] paramArrayOfByte, int paramInt)
  {
    int i1 = 0;
    int i2 = 0;
    while (i1 < paramInt)
    {
      paramArrayOfLong[i2] = (a(paramArrayOfByte[i1]) | a(paramArrayOfByte[(i1 + 1)]) << 8 | a(paramArrayOfByte[(i1 + 2)]) << 16 | a(paramArrayOfByte[(i1 + 3)]) << 24);
      i2 += 1;
      i1 += 4;
    }
  }
  
  private boolean a(InputStream paramInputStream, long paramLong)
  {
    byte[] arrayOfByte = new byte[64];
    int i2 = (int)(this.jdField_b_of_type_ArrayOfLong[0] >>> 3) & 0x3F;
    Object localObject = this.jdField_b_of_type_ArrayOfLong;
    long l1 = localObject[0] + (paramLong << 3);
    localObject[0] = l1;
    if (l1 < paramLong << 3)
    {
      localObject = this.jdField_b_of_type_ArrayOfLong;
      localObject[1] += 1L;
    }
    localObject = this.jdField_b_of_type_ArrayOfLong;
    localObject[1] += (paramLong >>> 29);
    int i1 = 64 - i2;
    if (paramLong >= i1)
    {
      localObject = new byte[i1];
      try
      {
        paramInputStream.read((byte[])localObject, 0, i1);
        a(this.jdField_b_of_type_ArrayOfByte, (byte[])localObject, i2, 0, i1);
        a(this.jdField_b_of_type_ArrayOfByte);
      }
      catch (Exception paramInputStream)
      {
        try
        {
          paramInputStream.read(arrayOfByte);
          a(arrayOfByte);
          i1 += 64;
        }
        catch (Exception paramInputStream)
        {
          paramInputStream.printStackTrace();
          return false;
        }
        paramInputStream = paramInputStream;
        paramInputStream.printStackTrace();
        return false;
      }
      if (i1 + 63 < paramLong) {}
      i2 = 0;
    }
    for (;;)
    {
      arrayOfByte = new byte[(int)(paramLong - i1)];
      try
      {
        paramInputStream.read(arrayOfByte);
        a(this.jdField_b_of_type_ArrayOfByte, arrayOfByte, i2, 0, arrayOfByte.length);
        return true;
      }
      catch (Exception paramInputStream)
      {
        paramInputStream.printStackTrace();
      }
      i1 = 0;
    }
    return false;
  }
  
  /* Error */
  protected static byte[] a(String paramString)
  {
    // Byte code:
    //   0: ldc_w 334
    //   3: invokestatic 340	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   6: astore_3
    //   7: new 342	java/io/File
    //   10: dup
    //   11: aload_0
    //   12: invokespecial 345	java/io/File:<init>	(Ljava/lang/String;)V
    //   15: astore_0
    //   16: aload_0
    //   17: invokevirtual 349	java/io/File:exists	()Z
    //   20: ifne +5 -> 25
    //   23: aconst_null
    //   24: areturn
    //   25: new 351	java/io/FileInputStream
    //   28: dup
    //   29: aload_0
    //   30: invokespecial 354	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   33: astore_2
    //   34: sipush 1024
    //   37: newarray byte
    //   39: astore_0
    //   40: aload_2
    //   41: aload_0
    //   42: invokevirtual 355	java/io/FileInputStream:read	([B)I
    //   45: istore_1
    //   46: iload_1
    //   47: iconst_m1
    //   48: if_icmpeq +26 -> 74
    //   51: aload_3
    //   52: aload_0
    //   53: iconst_0
    //   54: iload_1
    //   55: invokevirtual 359	java/security/MessageDigest:update	([BII)V
    //   58: goto -18 -> 40
    //   61: astore_0
    //   62: aload_0
    //   63: invokevirtual 360	java/io/IOException:printStackTrace	()V
    //   66: aload_2
    //   67: invokevirtual 363	java/io/FileInputStream:close	()V
    //   70: aconst_null
    //   71: astore_0
    //   72: aload_0
    //   73: areturn
    //   74: aload_3
    //   75: invokevirtual 367	java/security/MessageDigest:digest	()[B
    //   78: astore_0
    //   79: aload_2
    //   80: invokevirtual 363	java/io/FileInputStream:close	()V
    //   83: goto -11 -> 72
    //   86: astore_2
    //   87: aload_2
    //   88: invokevirtual 360	java/io/IOException:printStackTrace	()V
    //   91: goto -19 -> 72
    //   94: astore_0
    //   95: aload_0
    //   96: invokevirtual 368	java/io/FileNotFoundException:printStackTrace	()V
    //   99: aconst_null
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 360	java/io/IOException:printStackTrace	()V
    //   106: aconst_null
    //   107: astore_0
    //   108: goto -36 -> 72
    //   111: astore_0
    //   112: aload_2
    //   113: invokevirtual 363	java/io/FileInputStream:close	()V
    //   116: aload_0
    //   117: athrow
    //   118: astore_0
    //   119: aload_0
    //   120: invokevirtual 369	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   123: aconst_null
    //   124: areturn
    //   125: astore_2
    //   126: aload_2
    //   127: invokevirtual 360	java/io/IOException:printStackTrace	()V
    //   130: goto -14 -> 116
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString	String
    //   45	10	1	i1	int
    //   33	47	2	localFileInputStream	java.io.FileInputStream
    //   86	27	2	localIOException1	java.io.IOException
    //   125	2	2	localIOException2	java.io.IOException
    //   6	69	3	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   40	46	61	java/io/IOException
    //   51	58	61	java/io/IOException
    //   74	79	61	java/io/IOException
    //   79	83	86	java/io/IOException
    //   0	23	94	java/io/FileNotFoundException
    //   25	40	94	java/io/FileNotFoundException
    //   66	70	94	java/io/FileNotFoundException
    //   79	83	94	java/io/FileNotFoundException
    //   87	91	94	java/io/FileNotFoundException
    //   102	106	94	java/io/FileNotFoundException
    //   112	116	94	java/io/FileNotFoundException
    //   116	118	94	java/io/FileNotFoundException
    //   126	130	94	java/io/FileNotFoundException
    //   66	70	101	java/io/IOException
    //   40	46	111	finally
    //   51	58	111	finally
    //   62	66	111	finally
    //   74	79	111	finally
    //   0	23	118	java/security/NoSuchAlgorithmException
    //   25	40	118	java/security/NoSuchAlgorithmException
    //   66	70	118	java/security/NoSuchAlgorithmException
    //   79	83	118	java/security/NoSuchAlgorithmException
    //   87	91	118	java/security/NoSuchAlgorithmException
    //   102	106	118	java/security/NoSuchAlgorithmException
    //   112	116	118	java/security/NoSuchAlgorithmException
    //   116	118	118	java/security/NoSuchAlgorithmException
    //   126	130	118	java/security/NoSuchAlgorithmException
    //   112	116	125	java/io/IOException
  }
  
  protected static byte[] a(byte[] paramArrayOfByte)
  {
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 | (0xFFFFFFFF ^ paramLong3) & paramLong2;
  }
  
  private long b(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = b(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i1 = (int)paramLong1;
    int i2 = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i1 << i2) + paramLong2;
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = HexUtil.a(a(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private void b()
  {
    byte[] arrayOfByte = new byte[8];
    a(arrayOfByte, this.jdField_b_of_type_ArrayOfLong, 8);
    int i1 = (int)(this.jdField_b_of_type_ArrayOfLong[0] >>> 3) & 0x3F;
    if (i1 < 56) {}
    for (i1 = 56 - i1;; i1 = 120 - i1)
    {
      a(jdField_a_of_type_ArrayOfByte, i1);
      a(arrayOfByte, 8);
      a(this.c, this.jdField_a_of_type_ArrayOfLong, 16);
      return;
    }
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 ^ paramLong2 ^ paramLong3;
  }
  
  private long c(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = c(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i1 = (int)paramLong1;
    int i2 = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i1 << i2) + paramLong2;
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString).listFiles();
    if (paramString == null) {
      return "";
    }
    for (;;)
    {
      int i1;
      try
      {
        Arrays.sort(paramString, jdField_b_of_type_JavaUtilComparator);
        int i2 = paramString.length;
        i1 = 0;
        if (i1 < i2)
        {
          localIterator = paramString[i1];
          if (localIterator.isFile()) {
            jdField_a_of_type_JavaUtilList.add(a(localIterator.getAbsolutePath()));
          } else {
            c(localIterator.getAbsolutePath());
          }
        }
      }
      catch (Exception paramString)
      {
        return "";
      }
      Collections.sort(jdField_a_of_type_JavaUtilList, jdField_a_of_type_JavaUtilComparator);
      paramString = new StringBuilder();
      Iterator localIterator = jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext()) {
        paramString.append((String)localIterator.next());
      }
      jdField_a_of_type_JavaUtilList.clear();
      paramString = b(paramString.toString());
      return paramString;
      i1 += 1;
    }
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3)
  {
    return (0xFFFFFFFF ^ paramLong3 | paramLong1) ^ paramLong2;
  }
  
  private long d(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, long paramLong7)
  {
    paramLong1 = d(paramLong2, paramLong3, paramLong4) + paramLong5 + paramLong7 + paramLong1;
    int i1 = (int)paramLong1;
    int i2 = (int)paramLong6;
    return ((int)paramLong1 >>> (int)(32L - paramLong6) | i1 << i2) + paramLong2;
  }
  
  public static String d(String paramString)
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
        int i1;
        paramString = paramString.getBytes();
      }
    }
    arrayOfByte = new MD5Utils().b(paramString);
    paramString = "";
    i1 = 0;
    while (i1 < 16)
    {
      paramString = paramString + a(arrayOfByte[i1]);
      i1 += 1;
    }
    return paramString;
  }
  
  public byte[] b(byte[] paramArrayOfByte)
  {
    a();
    a(new ByteArrayInputStream(paramArrayOfByte), paramArrayOfByte.length);
    b();
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.open.base.MD5Utils
 * JD-Core Version:    0.7.0.1
 */
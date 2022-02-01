package com.tencent.qphone.base.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5
{
  private byte[] buffer = new byte[64];
  private byte[] digest = new byte[16];
  public String digestHexStr;
  
  static {}
  
  public static long b2iu(byte paramByte)
  {
    if (paramByte < 0) {
      return paramByte & 0xFF;
    }
    return paramByte;
  }
  
  public static String byteHEX(byte paramByte)
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
  
  public static byte[] getFileMd5(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    for (;;)
    {
      return null;
      try
      {
        File localFile = new File(paramString);
        if (localFile.exists())
        {
          paramString = getPartfileMd5(paramString, localFile.length());
          return paramString;
        }
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  /* Error */
  public static byte[] getPartfileMd5(String paramString, long paramLong)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 10
    //   3: aconst_null
    //   4: astore 11
    //   6: aload 11
    //   8: astore 7
    //   10: aload_0
    //   11: ifnull +24 -> 35
    //   14: aload 11
    //   16: astore 7
    //   18: aload_0
    //   19: invokevirtual 57	java/lang/String:length	()I
    //   22: ifeq +13 -> 35
    //   25: lload_1
    //   26: lconst_0
    //   27: lcmp
    //   28: ifge +10 -> 38
    //   31: aload 11
    //   33: astore 7
    //   35: aload 7
    //   37: areturn
    //   38: new 80	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 81	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: astore 8
    //   48: aload 8
    //   50: astore 7
    //   52: new 59	java/io/File
    //   55: dup
    //   56: aload_0
    //   57: invokespecial 62	java/io/File:<init>	(Ljava/lang/String;)V
    //   60: astore_0
    //   61: aload 8
    //   63: astore 7
    //   65: aload_0
    //   66: invokevirtual 66	java/io/File:exists	()Z
    //   69: ifeq +126 -> 195
    //   72: aload 8
    //   74: astore 7
    //   76: aload_0
    //   77: invokevirtual 69	java/io/File:length	()J
    //   80: lstore 5
    //   82: lload_1
    //   83: lconst_0
    //   84: lcmp
    //   85: ifeq +146 -> 231
    //   88: lload_1
    //   89: lstore_3
    //   90: lload 5
    //   92: lload_1
    //   93: lcmp
    //   94: ifge +6 -> 100
    //   97: goto +134 -> 231
    //   100: aload 8
    //   102: astore 7
    //   104: aload 8
    //   106: lload_3
    //   107: invokestatic 85	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   110: astore_0
    //   111: aload_0
    //   112: astore 7
    //   114: aload 8
    //   116: ifnull -81 -> 35
    //   119: aload 8
    //   121: invokevirtual 88	java/io/FileInputStream:close	()V
    //   124: aload_0
    //   125: areturn
    //   126: astore 7
    //   128: aload 7
    //   130: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   133: aload_0
    //   134: areturn
    //   135: astore 9
    //   137: aconst_null
    //   138: astore_0
    //   139: aload_0
    //   140: astore 7
    //   142: aload 9
    //   144: invokevirtual 76	java/lang/Exception:printStackTrace	()V
    //   147: aload 11
    //   149: astore 7
    //   151: aload_0
    //   152: ifnull -117 -> 35
    //   155: aload_0
    //   156: invokevirtual 88	java/io/FileInputStream:close	()V
    //   159: aconst_null
    //   160: areturn
    //   161: astore 7
    //   163: aload 10
    //   165: astore_0
    //   166: goto -38 -> 128
    //   169: astore_0
    //   170: aconst_null
    //   171: astore 7
    //   173: aload 7
    //   175: ifnull +8 -> 183
    //   178: aload 7
    //   180: invokevirtual 88	java/io/FileInputStream:close	()V
    //   183: aload_0
    //   184: athrow
    //   185: astore 7
    //   187: aload 7
    //   189: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   192: goto -9 -> 183
    //   195: aload 11
    //   197: astore 7
    //   199: aload 8
    //   201: ifnull -166 -> 35
    //   204: aload 8
    //   206: invokevirtual 88	java/io/FileInputStream:close	()V
    //   209: aconst_null
    //   210: areturn
    //   211: astore 7
    //   213: aload 10
    //   215: astore_0
    //   216: goto -88 -> 128
    //   219: astore_0
    //   220: goto -47 -> 173
    //   223: astore 9
    //   225: aload 8
    //   227: astore_0
    //   228: goto -89 -> 139
    //   231: lload 5
    //   233: lstore_3
    //   234: goto -134 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	237	0	paramString	String
    //   0	237	1	paramLong	long
    //   89	145	3	l1	long
    //   80	152	5	l2	long
    //   8	105	7	localObject1	Object
    //   126	3	7	localIOException1	IOException
    //   140	10	7	localObject2	Object
    //   161	1	7	localIOException2	IOException
    //   171	8	7	localObject3	Object
    //   185	3	7	localIOException3	IOException
    //   197	1	7	localObject4	Object
    //   211	1	7	localIOException4	IOException
    //   46	180	8	localFileInputStream	java.io.FileInputStream
    //   135	8	9	localException1	Exception
    //   223	1	9	localException2	Exception
    //   1	213	10	localObject5	Object
    //   4	192	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   119	124	126	java/io/IOException
    //   38	48	135	java/lang/Exception
    //   155	159	161	java/io/IOException
    //   38	48	169	finally
    //   178	183	185	java/io/IOException
    //   204	209	211	java/io/IOException
    //   52	61	219	finally
    //   65	72	219	finally
    //   76	82	219	finally
    //   104	111	219	finally
    //   142	147	219	finally
    //   52	61	223	java/lang/Exception
    //   65	72	223	java/lang/Exception
    //   76	82	223	java/lang/Exception
    //   104	111	223	java/lang/Exception
  }
  
  public static byte[] sysGetBufferMd5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0)) {
      return null;
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramArrayOfByte, paramInt1, paramInt2);
      paramArrayOfByte = localMessageDigest.digest();
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
    return null;
  }
  
  /* Error */
  public static byte[] sysGetStremMd5(InputStream paramInputStream, long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +9 -> 10
    //   4: lload_1
    //   5: lconst_0
    //   6: lcmp
    //   7: ifne +5 -> 12
    //   10: aconst_null
    //   11: areturn
    //   12: ldc 95
    //   14: invokestatic 101	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   17: astore 6
    //   19: ldc 111
    //   21: newarray byte
    //   23: astore 7
    //   25: aload 7
    //   27: arraylength
    //   28: istore_3
    //   29: lconst_0
    //   30: lstore 4
    //   32: lload 4
    //   34: lload_1
    //   35: lcmp
    //   36: ifge +53 -> 89
    //   39: aload 7
    //   41: arraylength
    //   42: i2l
    //   43: lload 4
    //   45: ladd
    //   46: lload_1
    //   47: lcmp
    //   48: ifle +9 -> 57
    //   51: lload_1
    //   52: lload 4
    //   54: lsub
    //   55: l2i
    //   56: istore_3
    //   57: aload_0
    //   58: aload 7
    //   60: iconst_0
    //   61: iload_3
    //   62: invokevirtual 117	java/io/InputStream:read	([BII)I
    //   65: istore_3
    //   66: iload_3
    //   67: iflt -57 -> 10
    //   70: aload 6
    //   72: aload 7
    //   74: iconst_0
    //   75: iload_3
    //   76: invokevirtual 105	java/security/MessageDigest:update	([BII)V
    //   79: lload 4
    //   81: iload_3
    //   82: i2l
    //   83: ladd
    //   84: lstore 4
    //   86: goto -54 -> 32
    //   89: aload_0
    //   90: invokevirtual 118	java/io/InputStream:close	()V
    //   93: aload 6
    //   95: invokevirtual 108	java/security/MessageDigest:digest	()[B
    //   98: astore_0
    //   99: aload_0
    //   100: areturn
    //   101: astore_0
    //   102: aload_0
    //   103: invokevirtual 109	java/security/NoSuchAlgorithmException:printStackTrace	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokevirtual 89	java/io/IOException:printStackTrace	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: goto -23 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramInputStream	InputStream
    //   0	119	1	paramLong	long
    //   28	54	3	i	int
    //   30	55	4	l	long
    //   17	77	6	localMessageDigest	MessageDigest
    //   23	50	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   12	29	101	java/security/NoSuchAlgorithmException
    //   39	51	101	java/security/NoSuchAlgorithmException
    //   57	66	101	java/security/NoSuchAlgorithmException
    //   70	79	101	java/security/NoSuchAlgorithmException
    //   89	93	101	java/security/NoSuchAlgorithmException
    //   93	99	101	java/security/NoSuchAlgorithmException
    //   12	29	108	java/io/IOException
    //   39	51	108	java/io/IOException
    //   57	66	108	java/io/IOException
    //   70	79	108	java/io/IOException
    //   89	93	108	java/io/IOException
    //   93	99	108	java/io/IOException
    //   89	93	115	java/lang/Exception
  }
  
  public static String toMD5(String paramString)
  {
    int i = 0;
    if (paramString == null) {
      paramString = null;
    }
    do
    {
      return paramString;
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
          byte[] arrayOfByte;
          paramString = paramString.getBytes();
        }
      }
      arrayOfByte = new MD5().getMD5(paramString, 0, paramString.length);
      localObject = "";
      paramString = (String)localObject;
    } while (arrayOfByte == null);
    for (;;)
    {
      paramString = (String)localObject;
      if (i >= 16) {
        break;
      }
      localObject = (String)localObject + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static String toMD5(byte[] paramArrayOfByte)
  {
    Object localObject;
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      localObject = null;
      return localObject;
    }
    byte[] arrayOfByte = new MD5().getMD5(paramArrayOfByte, 0, paramArrayOfByte.length);
    paramArrayOfByte = "";
    int i = 0;
    for (;;)
    {
      localObject = paramArrayOfByte;
      if (i >= 16) {
        break;
      }
      paramArrayOfByte = paramArrayOfByte + byteHEX(arrayOfByte[i]);
      i += 1;
    }
  }
  
  public static byte[] toMD5Byte(InputStream paramInputStream, long paramLong)
  {
    return new MD5().getMD5(paramInputStream, paramLong);
  }
  
  public static byte[] toMD5Byte(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      byte[] arrayOfByte = paramString.getBytes("ISO8859_1");
      paramString = arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        paramString = paramString.getBytes();
      }
    }
    return new MD5().getMD5(paramString, 0, paramString.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte)
  {
    return toMD5Byte(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static byte[] toMD5Byte(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new MD5().getMD5(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  native byte[] getBufferMd5(byte[] paramArrayOfByte);
  
  public byte[] getMD5(InputStream paramInputStream, long paramLong)
  {
    if ((paramInputStream == null) || (paramLong < 0L)) {}
    long l1;
    do
    {
      for (;;)
      {
        return null;
        try
        {
          long l2 = paramInputStream.available();
          if (paramLong != 0L)
          {
            l1 = paramLong;
            if (l2 != 0L)
            {
              l1 = paramLong;
              if (paramInputStream.available() >= paramLong) {}
            }
          }
          else
          {
            int i = paramInputStream.available();
            l1 = i;
          }
          if (l1 != 0L)
          {
            byte[] arrayOfByte1 = sysGetStremMd5(paramInputStream, l1);
            if (arrayOfByte1 == null) {
              break label114;
            }
            this.digest = arrayOfByte1;
            return this.digest;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    } while (paramInputStream == null);
    try
    {
      paramInputStream.close();
      return null;
    }
    catch (IOException paramInputStream)
    {
      paramInputStream.printStackTrace();
      return null;
    }
    try
    {
      label114:
      byte[] arrayOfByte2 = getStremMd5(paramInputStream, l1);
      localObject = arrayOfByte2;
      paramInputStream.close();
      localObject = arrayOfByte2;
    }
    catch (Exception paramInputStream)
    {
      for (;;)
      {
        Object localObject;
        paramInputStream.printStackTrace();
      }
    }
    if (localObject != null)
    {
      this.digest = localObject;
      return this.digest;
    }
    return this.digest;
  }
  
  public byte[] getMD5(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((paramArrayOfByte == null) || (paramInt2 == 0) || (paramInt1 < 0)) {
      return null;
    }
    byte[] arrayOfByte = sysGetBufferMd5(paramArrayOfByte, paramInt1, paramInt2);
    if (arrayOfByte != null)
    {
      this.digest = arrayOfByte;
      return this.digest;
    }
    try
    {
      paramArrayOfByte = getBufferMd5(paramArrayOfByte);
      if (paramArrayOfByte != null)
      {
        this.digest = paramArrayOfByte;
        return this.digest;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = arrayOfByte;
      }
    }
    return this.digest;
  }
  
  native byte[] getStremMd5(InputStream paramInputStream, long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.MD5
 * JD-Core Version:    0.7.0.1
 */
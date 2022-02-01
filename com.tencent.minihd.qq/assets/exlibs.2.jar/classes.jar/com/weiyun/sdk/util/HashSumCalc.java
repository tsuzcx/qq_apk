package com.weiyun.sdk.util;

import com.weiyun.sdk.job.BaseJob;
import com.weiyun.sdk.log.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

public class HashSumCalc
{
  public static final String MD5_HASH_TYPE = "MD5";
  public static final String SHA_HASH_TYPE = "SHA";
  private static final String TAG = "HashSumCalc";
  private static final char[] sHexChar = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  /* Error */
  private static String getHash(String paramString1, String paramString2, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 7
    //   6: aconst_null
    //   7: astore 5
    //   9: aload 7
    //   11: astore 4
    //   13: sipush 8192
    //   16: newarray byte
    //   18: astore 8
    //   20: aload 7
    //   22: astore 4
    //   24: aload_1
    //   25: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   28: astore 9
    //   30: aload 7
    //   32: astore 4
    //   34: new 56	java/io/BufferedInputStream
    //   37: dup
    //   38: new 58	java/io/FileInputStream
    //   41: dup
    //   42: aload_0
    //   43: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   46: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   49: astore_1
    //   50: aload_1
    //   51: aload 8
    //   53: invokevirtual 70	java/io/InputStream:read	([B)I
    //   56: istore_3
    //   57: iload_3
    //   58: ifle +43 -> 101
    //   61: aload 9
    //   63: aload 8
    //   65: iconst_0
    //   66: iload_3
    //   67: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   70: aload_2
    //   71: invokevirtual 80	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   74: ifne -24 -> 50
    //   77: aload_1
    //   78: ifnull +7 -> 85
    //   81: aload_1
    //   82: invokevirtual 83	java/io/InputStream:close	()V
    //   85: ldc 85
    //   87: areturn
    //   88: astore_0
    //   89: ldc 14
    //   91: aload_0
    //   92: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   95: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   98: goto -13 -> 85
    //   101: aload 9
    //   103: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   106: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   109: astore_2
    //   110: aload_1
    //   111: ifnull +7 -> 118
    //   114: aload_1
    //   115: invokevirtual 83	java/io/InputStream:close	()V
    //   118: aload_2
    //   119: areturn
    //   120: astore_0
    //   121: ldc 14
    //   123: aload_0
    //   124: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   127: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: goto -12 -> 118
    //   133: astore_2
    //   134: aload 5
    //   136: astore_1
    //   137: aload_1
    //   138: astore 4
    //   140: ldc 14
    //   142: new 105	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   149: ldc 108
    //   151: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: aload_0
    //   155: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 114
    //   160: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_2
    //   164: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   167: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload_1
    //   177: ifnull -92 -> 85
    //   180: aload_1
    //   181: invokevirtual 83	java/io/InputStream:close	()V
    //   184: ldc 85
    //   186: areturn
    //   187: astore_0
    //   188: ldc 14
    //   190: aload_0
    //   191: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   194: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   197: ldc 85
    //   199: areturn
    //   200: astore_2
    //   201: aload 6
    //   203: astore_1
    //   204: aload_1
    //   205: astore 4
    //   207: ldc 14
    //   209: new 105	java/lang/StringBuilder
    //   212: dup
    //   213: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   216: ldc 108
    //   218: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: aload_0
    //   222: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 114
    //   227: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_2
    //   231: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   234: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   240: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   243: aload_1
    //   244: ifnull -159 -> 85
    //   247: aload_1
    //   248: invokevirtual 83	java/io/InputStream:close	()V
    //   251: ldc 85
    //   253: areturn
    //   254: astore_0
    //   255: ldc 14
    //   257: aload_0
    //   258: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   261: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   264: ldc 85
    //   266: areturn
    //   267: astore_0
    //   268: aload 4
    //   270: ifnull +8 -> 278
    //   273: aload 4
    //   275: invokevirtual 83	java/io/InputStream:close	()V
    //   278: aload_0
    //   279: athrow
    //   280: astore_1
    //   281: ldc 14
    //   283: aload_1
    //   284: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   287: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   290: goto -12 -> 278
    //   293: astore_0
    //   294: aload_1
    //   295: astore 4
    //   297: goto -29 -> 268
    //   300: astore_2
    //   301: goto -97 -> 204
    //   304: astore_2
    //   305: goto -168 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	paramString1	String
    //   0	308	1	paramString2	String
    //   0	308	2	paramBaseJob	BaseJob
    //   56	11	3	i	int
    //   11	285	4	localObject1	Object
    //   7	128	5	localObject2	Object
    //   1	201	6	localObject3	Object
    //   4	27	7	localObject4	Object
    //   18	46	8	arrayOfByte	byte[]
    //   28	74	9	localMessageDigest	MessageDigest
    // Exception table:
    //   from	to	target	type
    //   81	85	88	java/io/IOException
    //   114	118	120	java/io/IOException
    //   13	20	133	java/io/FileNotFoundException
    //   24	30	133	java/io/FileNotFoundException
    //   34	50	133	java/io/FileNotFoundException
    //   180	184	187	java/io/IOException
    //   13	20	200	java/io/IOException
    //   24	30	200	java/io/IOException
    //   34	50	200	java/io/IOException
    //   247	251	254	java/io/IOException
    //   13	20	267	finally
    //   24	30	267	finally
    //   34	50	267	finally
    //   140	176	267	finally
    //   207	243	267	finally
    //   273	278	280	java/io/IOException
    //   50	57	293	finally
    //   61	77	293	finally
    //   101	110	293	finally
    //   50	57	300	java/io/IOException
    //   61	77	300	java/io/IOException
    //   101	110	300	java/io/IOException
    //   50	57	304	java/io/FileNotFoundException
    //   61	77	304	java/io/FileNotFoundException
    //   101	110	304	java/io/FileNotFoundException
  }
  
  public static String getMD5Hash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramBaseJob = getHash(paramString, "MD5", paramBaseJob);
      return paramBaseJob;
    }
    catch (NoSuchAlgorithmException paramBaseJob)
    {
      Log.e("HashSumCalc", "getHash() for file: " + paramString + " failed:" + paramBaseJob.getMessage());
    }
    return "";
  }
  
  public static HashMap<String, String> getMd5AndShaHash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramString = getMd5AndShaHash(paramString, "MD5", "SHA", paramBaseJob);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString) {}
    return null;
  }
  
  /* Error */
  private static HashMap<String, String> getMd5AndShaHash(String paramString1, String paramString2, String paramString3, BaseJob paramBaseJob)
    throws NoSuchAlgorithmException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: new 56	java/io/BufferedInputStream
    //   12: dup
    //   13: new 58	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 61	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   21: invokespecial 64	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   24: astore 7
    //   26: sipush 8192
    //   29: newarray byte
    //   31: astore 9
    //   33: aload_1
    //   34: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   37: astore 6
    //   39: aload_2
    //   40: invokestatic 54	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   43: astore 8
    //   45: aload 7
    //   47: aload 9
    //   49: invokevirtual 70	java/io/InputStream:read	([B)I
    //   52: istore 4
    //   54: iload 4
    //   56: ifle +59 -> 115
    //   59: aload 6
    //   61: aload 9
    //   63: iconst_0
    //   64: iload 4
    //   66: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   69: aload 8
    //   71: aload 9
    //   73: iconst_0
    //   74: iload 4
    //   76: invokevirtual 74	java/security/MessageDigest:update	([BII)V
    //   79: aload_3
    //   80: invokevirtual 80	com/weiyun/sdk/job/BaseJob:isAlive	()Z
    //   83: istore 5
    //   85: iload 5
    //   87: ifne -42 -> 45
    //   90: aload 7
    //   92: ifnull +8 -> 100
    //   95: aload 7
    //   97: invokevirtual 83	java/io/InputStream:close	()V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_0
    //   103: ldc 14
    //   105: aload_0
    //   106: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   109: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   112: goto -12 -> 100
    //   115: new 138	java/util/HashMap
    //   118: dup
    //   119: iconst_2
    //   120: invokespecial 141	java/util/HashMap:<init>	(I)V
    //   123: astore_3
    //   124: aload_3
    //   125: aload_1
    //   126: aload 6
    //   128: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   131: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   134: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   137: pop
    //   138: aload_3
    //   139: aload_2
    //   140: aload 8
    //   142: invokevirtual 99	java/security/MessageDigest:digest	()[B
    //   145: invokestatic 103	com/weiyun/sdk/util/HashSumCalc:toHexString	([B)Ljava/lang/String;
    //   148: invokevirtual 145	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   151: pop
    //   152: aload 7
    //   154: ifnull +8 -> 162
    //   157: aload 7
    //   159: invokevirtual 83	java/io/InputStream:close	()V
    //   162: aload_3
    //   163: areturn
    //   164: astore_0
    //   165: ldc 14
    //   167: aload_0
    //   168: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   171: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -12 -> 162
    //   177: astore_2
    //   178: aload 8
    //   180: astore_1
    //   181: aload_1
    //   182: astore 6
    //   184: ldc 14
    //   186: new 105	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   193: ldc 108
    //   195: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_0
    //   199: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc 114
    //   204: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_2
    //   208: invokevirtual 115	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   211: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 83	java/io/InputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_0
    //   231: ldc 14
    //   233: aload_0
    //   234: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   237: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: goto -12 -> 228
    //   243: astore_2
    //   244: aload 9
    //   246: astore_1
    //   247: aload_1
    //   248: astore 6
    //   250: ldc 14
    //   252: new 105	java/lang/StringBuilder
    //   255: dup
    //   256: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   259: ldc 108
    //   261: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: aload_0
    //   265: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: ldc 114
    //   270: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: aload_2
    //   274: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   277: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   283: invokestatic 121	com/weiyun/sdk/log/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   286: aload_1
    //   287: ifnull +7 -> 294
    //   290: aload_1
    //   291: invokevirtual 83	java/io/InputStream:close	()V
    //   294: aconst_null
    //   295: areturn
    //   296: astore_0
    //   297: ldc 14
    //   299: aload_0
    //   300: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   303: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   306: goto -12 -> 294
    //   309: astore_0
    //   310: aload 6
    //   312: ifnull +8 -> 320
    //   315: aload 6
    //   317: invokevirtual 83	java/io/InputStream:close	()V
    //   320: aload_0
    //   321: athrow
    //   322: astore_1
    //   323: ldc 14
    //   325: aload_1
    //   326: invokevirtual 89	java/io/IOException:getMessage	()Ljava/lang/String;
    //   329: invokestatic 95	com/weiyun/sdk/log/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   332: goto -12 -> 320
    //   335: astore_0
    //   336: aload 7
    //   338: astore 6
    //   340: goto -30 -> 310
    //   343: astore_2
    //   344: aload 7
    //   346: astore_1
    //   347: goto -100 -> 247
    //   350: astore_2
    //   351: aload 7
    //   353: astore_1
    //   354: goto -173 -> 181
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	paramString1	String
    //   0	357	1	paramString2	String
    //   0	357	2	paramString3	String
    //   0	357	3	paramBaseJob	BaseJob
    //   52	23	4	i	int
    //   83	3	5	bool	boolean
    //   4	335	6	localObject	Object
    //   24	328	7	localBufferedInputStream	java.io.BufferedInputStream
    //   7	172	8	localMessageDigest	MessageDigest
    //   1	244	9	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   95	100	102	java/io/IOException
    //   157	162	164	java/io/IOException
    //   9	26	177	java/io/FileNotFoundException
    //   224	228	230	java/io/IOException
    //   9	26	243	java/io/IOException
    //   290	294	296	java/io/IOException
    //   9	26	309	finally
    //   184	220	309	finally
    //   250	286	309	finally
    //   315	320	322	java/io/IOException
    //   26	45	335	finally
    //   45	54	335	finally
    //   59	85	335	finally
    //   115	152	335	finally
    //   26	45	343	java/io/IOException
    //   45	54	343	java/io/IOException
    //   59	85	343	java/io/IOException
    //   115	152	343	java/io/IOException
    //   26	45	350	java/io/FileNotFoundException
    //   45	54	350	java/io/FileNotFoundException
    //   59	85	350	java/io/FileNotFoundException
    //   115	152	350	java/io/FileNotFoundException
  }
  
  public static String getSHA1Hash(String paramString, BaseJob paramBaseJob)
  {
    try
    {
      paramBaseJob = getHash(paramString, "SHA", paramBaseJob);
      return paramBaseJob;
    }
    catch (NoSuchAlgorithmException paramBaseJob)
    {
      Log.e("HashSumCalc", "getHash() for file: " + paramString + " failed:" + paramBaseJob.getMessage());
    }
    return "";
  }
  
  public static String getStringHash(String paramString1, String paramString2)
    throws NoSuchAlgorithmException
  {
    paramString1 = paramString1.getBytes();
    paramString2 = MessageDigest.getInstance(paramString2);
    paramString2.update(paramString1, 0, paramString1.length);
    return toHexString(paramString2.digest());
  }
  
  public static String getStringHashSafely(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = getStringHash(paramString1, paramString2);
      return paramString2;
    }
    catch (NoSuchAlgorithmException paramString2)
    {
      Log.e("HashSumCalc", "", paramString2);
    }
    return String.valueOf(paramString1.hashCode());
  }
  
  public static String toHexString(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      localStringBuilder.append(sHexChar[((paramArrayOfByte[i] & 0xF0) >>> 4)]);
      localStringBuilder.append(sHexChar[(paramArrayOfByte[i] & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.util.HashSumCalc
 * JD-Core Version:    0.7.0.1
 */
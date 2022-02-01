package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class TroopBarShortVideoUploadUtil
{
  public static final long a = 524288L;
  public static final String a = "buluo";
  public static final String b = "tags";
  public static final String c = "cat";
  public static final String d = "title";
  public static final String e = "file_path";
  public static final String f = "vid";
  private static final String g = "https://xiaoqu.qq.com/cgi-bin/bar/post/video/apply_upload";
  
  private static int a(String paramString)
  {
    int k = paramString.length();
    int j = 5381;
    int i = 0;
    while (i < k)
    {
      j += (j << 5) + paramString.charAt(i);
      i += 1;
    }
    return 0x7FFFFFFF & j;
  }
  
  /* Error */
  public static long a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, String paramString, long paramLong1, java.io.RandomAccessFile paramRandomAccessFile, long paramLong2, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   3: lstore 10
    //   5: new 55	kjr
    //   8: dup
    //   9: aload_0
    //   10: aload_1
    //   11: lload_3
    //   12: lload 6
    //   14: iload 8
    //   16: i2l
    //   17: lconst_0
    //   18: lconst_0
    //   19: invokespecial 58	kjr:<init>	([B[BJJJJJ)V
    //   22: astore_0
    //   23: new 60	kjq
    //   26: dup
    //   27: iload 8
    //   29: sipush 348
    //   32: iadd
    //   33: i2l
    //   34: invokespecial 63	kjq:<init>	(J)V
    //   37: astore_1
    //   38: iload 8
    //   40: sipush 364
    //   43: iadd
    //   44: invokestatic 69	java/nio/ByteBuffer:allocate	(I)Ljava/nio/ByteBuffer;
    //   47: astore 12
    //   49: aload_1
    //   50: aload 12
    //   52: invokevirtual 72	kjq:a	(Ljava/nio/ByteBuffer;)V
    //   55: aload_0
    //   56: aload 12
    //   58: invokevirtual 73	kjr:a	(Ljava/nio/ByteBuffer;)V
    //   61: aload 5
    //   63: lload 6
    //   65: invokevirtual 78	java/io/RandomAccessFile:seek	(J)V
    //   68: iload 8
    //   70: newarray byte
    //   72: astore_0
    //   73: aload 5
    //   75: aload_0
    //   76: invokevirtual 82	java/io/RandomAccessFile:read	([B)I
    //   79: pop
    //   80: aload 12
    //   82: aload_0
    //   83: invokevirtual 86	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   86: pop
    //   87: new 88	java/net/URL
    //   90: dup
    //   91: aload_2
    //   92: invokespecial 91	java/net/URL:<init>	(Ljava/lang/String;)V
    //   95: invokevirtual 95	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   98: checkcast 97	java/net/HttpURLConnection
    //   101: astore_0
    //   102: aload_0
    //   103: ldc 99
    //   105: invokevirtual 102	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   108: aload_0
    //   109: iconst_1
    //   110: invokevirtual 106	java/net/HttpURLConnection:setDoInput	(Z)V
    //   113: aload_0
    //   114: iconst_1
    //   115: invokevirtual 109	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   118: aload_0
    //   119: invokevirtual 113	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   122: astore_1
    //   123: aload_1
    //   124: aload 12
    //   126: invokevirtual 117	java/nio/ByteBuffer:array	()[B
    //   129: invokevirtual 123	java/io/OutputStream:write	([B)V
    //   132: aload_1
    //   133: invokevirtual 126	java/io/OutputStream:flush	()V
    //   136: aload_0
    //   137: invokevirtual 129	java/net/HttpURLConnection:connect	()V
    //   140: aload_0
    //   141: invokevirtual 133	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   144: astore_2
    //   145: new 135	java/io/ByteArrayOutputStream
    //   148: dup
    //   149: invokespecial 136	java/io/ByteArrayOutputStream:<init>	()V
    //   152: astore 13
    //   154: bipush 25
    //   156: newarray byte
    //   158: astore 5
    //   160: aload_2
    //   161: aload 5
    //   163: invokevirtual 139	java/io/InputStream:read	([B)I
    //   166: istore 9
    //   168: iload 9
    //   170: iconst_m1
    //   171: if_icmpeq +77 -> 248
    //   174: aload 13
    //   176: aload 5
    //   178: iconst_0
    //   179: iload 9
    //   181: invokevirtual 142	java/io/ByteArrayOutputStream:write	([BII)V
    //   184: goto -24 -> 160
    //   187: astore 5
    //   189: aload_0
    //   190: astore 12
    //   192: aload 5
    //   194: astore_0
    //   195: aload_1
    //   196: astore 5
    //   198: aload 13
    //   200: astore_1
    //   201: aload 5
    //   203: ifnull +13 -> 216
    //   206: aload 5
    //   208: invokevirtual 126	java/io/OutputStream:flush	()V
    //   211: aload 5
    //   213: invokevirtual 145	java/io/OutputStream:close	()V
    //   216: aload_1
    //   217: ifnull +11 -> 228
    //   220: aload_1
    //   221: invokevirtual 146	java/io/ByteArrayOutputStream:flush	()V
    //   224: aload_1
    //   225: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   228: aload_2
    //   229: ifnull +7 -> 236
    //   232: aload_2
    //   233: invokevirtual 148	java/io/InputStream:close	()V
    //   236: aload 12
    //   238: ifnull +8 -> 246
    //   241: aload 12
    //   243: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   246: aload_0
    //   247: athrow
    //   248: aload 13
    //   250: invokevirtual 154	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   253: invokestatic 157	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   256: astore 12
    //   258: new 60	kjq
    //   261: dup
    //   262: aload 12
    //   264: invokespecial 159	kjq:<init>	(Ljava/nio/ByteBuffer;)V
    //   267: astore 5
    //   269: new 161	kjs
    //   272: dup
    //   273: aload 12
    //   275: invokespecial 162	kjs:<init>	(Ljava/nio/ByteBuffer;)V
    //   278: astore 12
    //   280: aload 5
    //   282: getfield 164	kjq:b	J
    //   285: lconst_0
    //   286: lcmp
    //   287: ifne +189 -> 476
    //   290: aload 12
    //   292: getfield 167	kjs:b	I
    //   295: istore 9
    //   297: iload 9
    //   299: iconst_1
    //   300: if_icmpne +103 -> 403
    //   303: aload_1
    //   304: ifnull +11 -> 315
    //   307: aload_1
    //   308: invokevirtual 126	java/io/OutputStream:flush	()V
    //   311: aload_1
    //   312: invokevirtual 145	java/io/OutputStream:close	()V
    //   315: aload 13
    //   317: ifnull +13 -> 330
    //   320: aload 13
    //   322: invokevirtual 146	java/io/ByteArrayOutputStream:flush	()V
    //   325: aload 13
    //   327: invokevirtual 147	java/io/ByteArrayOutputStream:close	()V
    //   330: aload_2
    //   331: ifnull +7 -> 338
    //   334: aload_2
    //   335: invokevirtual 148	java/io/InputStream:close	()V
    //   338: aload_0
    //   339: ifnull +7 -> 346
    //   342: aload_0
    //   343: invokevirtual 151	java/net/HttpURLConnection:disconnect	()V
    //   346: invokestatic 173	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +52 -> 401
    //   352: ldc 175
    //   354: iconst_2
    //   355: new 177	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 178	java/lang/StringBuilder:<init>	()V
    //   362: ldc 180
    //   364: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   370: lload 10
    //   372: lsub
    //   373: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   376: ldc 189
    //   378: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: lload_3
    //   382: invokevirtual 187	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   385: ldc 191
    //   387: invokevirtual 184	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 8
    //   392: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 201	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: lload_3
    //   402: lreturn
    //   403: aload 12
    //   405: getfield 203	kjs:a	J
    //   408: lstore_3
    //   409: goto -106 -> 303
    //   412: astore_0
    //   413: aconst_null
    //   414: astore_1
    //   415: aconst_null
    //   416: astore_2
    //   417: aconst_null
    //   418: astore 5
    //   420: aconst_null
    //   421: astore 12
    //   423: goto -222 -> 201
    //   426: astore_1
    //   427: aconst_null
    //   428: astore_2
    //   429: aconst_null
    //   430: astore 5
    //   432: aload_0
    //   433: astore 12
    //   435: aload_1
    //   436: astore_0
    //   437: aconst_null
    //   438: astore_1
    //   439: goto -238 -> 201
    //   442: astore 13
    //   444: aconst_null
    //   445: astore_2
    //   446: aload_1
    //   447: astore 5
    //   449: aload_0
    //   450: astore 12
    //   452: aload 13
    //   454: astore_0
    //   455: aconst_null
    //   456: astore_1
    //   457: goto -256 -> 201
    //   460: astore 13
    //   462: aload_1
    //   463: astore 5
    //   465: aload_0
    //   466: astore 12
    //   468: aload 13
    //   470: astore_0
    //   471: aconst_null
    //   472: astore_1
    //   473: goto -272 -> 201
    //   476: ldc2_w 204
    //   479: lstore_3
    //   480: goto -177 -> 303
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	483	0	paramArrayOfByte1	byte[]
    //   0	483	1	paramArrayOfByte2	byte[]
    //   0	483	2	paramString	String
    //   0	483	3	paramLong1	long
    //   0	483	5	paramRandomAccessFile	java.io.RandomAccessFile
    //   0	483	6	paramLong2	long
    //   0	483	8	paramInt	int
    //   166	135	9	i	int
    //   3	368	10	l	long
    //   47	420	12	localObject1	Object
    //   152	174	13	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   442	11	13	localObject2	Object
    //   460	9	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   154	160	187	finally
    //   160	168	187	finally
    //   174	184	187	finally
    //   248	297	187	finally
    //   403	409	187	finally
    //   5	102	412	finally
    //   102	123	426	finally
    //   123	145	442	finally
    //   145	154	460	finally
  }
  
  public static TroopBarShortVideoUploadUtil.ApplyUploadRsp a(Bundle paramBundle, String paramString1, String paramString2)
  {
    long l = System.currentTimeMillis();
    String str1 = paramBundle.getString("title");
    String str2 = paramBundle.getString("tags");
    String str3 = paramBundle.getString("cat");
    String str4 = paramBundle.getString("file_path");
    String str5 = paramBundle.getString("vid");
    if (QLog.isColorLevel()) {
      QLog.d("TroopBar", 2, "applyUpload title = " + str1 + ", tags = " + str2 + ", cat = " + str3 + ", filePath = " + str4 + ", size = " + FileUtils.a(str4));
    }
    if ((TextUtils.isEmpty(str4)) || (!FileUtils.a(str4)))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TroopBar", 2, "!!!!!!!applyUpload filePath = " + str4);
      }
      paramString1 = null;
    }
    do
    {
      return paramString1;
      paramBundle = new HttpPost("https://xiaoqu.qq.com/cgi-bin/bar/post/video/apply_upload");
      paramBundle.setHeader("Accept", "Accept text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
      paramBundle.setHeader("Accept-Charset", "utf-8;q=0.7,*;q=0.7");
      paramBundle.setHeader("Accept-Encoding", "gzip, deflate");
      paramBundle.setHeader("Accept-Language", "zh-cn,zh;q=0.5");
      paramBundle.setHeader("Connection", "keep-alive");
      paramBundle.setHeader("Cookie", "skey=" + paramString2 + ";uin=" + paramString1 + ";luin=" + paramString1);
      paramBundle.setHeader("Referer", "https://xiaoqu.qq.com");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BasicNameValuePair("bid", "buluo"));
      localArrayList.add(new BasicNameValuePair("title", str1));
      localArrayList.add(new BasicNameValuePair("tags", str2));
      localArrayList.add(new BasicNameValuePair("cat", str3));
      localArrayList.add(new BasicNameValuePair("size", String.valueOf(FileUtils.a(str4))));
      localArrayList.add(new BasicNameValuePair("sha", HexUtil.a(FileManagerUtil.a(str4))));
      localArrayList.add(new BasicNameValuePair("md5", HexUtil.a(FileManagerUtil.c(str4))));
      if (QLog.isColorLevel()) {
        QLog.d("TroopBar", 2, "applyUpload() getMessageDigest time = " + (System.currentTimeMillis() - l));
      }
      localArrayList.add(new BasicNameValuePair("platform", "android"));
      localArrayList.add(new BasicNameValuePair("g_tk", String.valueOf(a(paramString2))));
      localArrayList.add(new BasicNameValuePair("otype", "json"));
      if (!TextUtils.isEmpty(str5))
      {
        localArrayList.add(new BasicNameValuePair("vid", str5));
        localArrayList.add(new BasicNameValuePair("continue", "1"));
      }
      paramString1 = null;
      try
      {
        paramBundle.setEntity(new UrlEncodedFormEntity(localArrayList, "UTF-8"));
        paramBundle = new DefaultHttpClient().execute(paramBundle);
        if (paramBundle.getStatusLine().getStatusCode() != 200) {
          break;
        }
        paramBundle = EntityUtils.toString(paramBundle.getEntity());
        if (QLog.isColorLevel()) {
          QLog.d("TroopBar", 2, "applyUpload result = " + paramBundle);
        }
        paramBundle = new JSONObject(paramBundle);
        if (paramBundle.optInt("retcode", -1) != 0) {
          break;
        }
        paramBundle = new TroopBarShortVideoUploadUtil.ApplyUploadRsp(paramBundle.getJSONObject("result"));
      }
      catch (Exception paramString2)
      {
        for (;;)
        {
          paramBundle = paramString1;
          if (QLog.isColorLevel())
          {
            QLog.d("TroopBar", 2, QLog.getStackTraceString(paramString2));
            paramBundle = paramString1;
            continue;
            paramBundle = null;
          }
        }
      }
      paramString1 = paramBundle;
    } while (!QLog.isColorLevel());
    QLog.d("TroopBar", 2, "applyUpload time: " + (System.currentTimeMillis() - l));
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopBarShortVideoUploadUtil
 * JD-Core Version:    0.7.0.1
 */
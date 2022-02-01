package com.tencent.mobileqq.jsp;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.compress.CompressOperator;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.webviewplugin.WebViewPlugin;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQProgressDialog.Callback;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import org.json.JSONObject;

public class MediaApiPlugin
  extends WebViewPlugin
  implements QQProgressDialog.Callback
{
  static final byte jdField_a_of_type_Byte = 1;
  static final String jdField_a_of_type_JavaLangString = UiApiPlugin.class.getSimpleName();
  static final byte jdField_b_of_type_Byte = 2;
  static final String jdField_b_of_type_JavaLangString = "getPictureParam";
  static final String c = "callback";
  static final String d = "match";
  static final String e = "data";
  static final String f = "imageID";
  static final String g = "retCode";
  static final String h = "msg";
  static final String i = "statusCode";
  static final String j = "scaleMode";
  static final String k = "getPictureV2";
  static final String l = "getLocalImageV2";
  public QQProgressDialog a;
  private Thread jdField_a_of_type_JavaLangThread;
  
  public static String a(String paramString, int paramInt)
  {
    paramString = new CompressInfo(paramString, paramInt, 1035);
    CompressOperator.a(paramString);
    return paramString.e;
  }
  
  /* Error */
  private String a(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 83	java/io/File
    //   6: dup
    //   7: getstatic 88	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   10: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 95	java/io/File:mkdirs	()Z
    //   18: pop
    //   19: aload_3
    //   20: invokevirtual 98	java/io/File:canWrite	()Z
    //   23: ifne +13 -> 36
    //   26: new 81	java/io/IOException
    //   29: dup
    //   30: ldc 100
    //   32: invokespecial 101	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   35: athrow
    //   36: new 103	android/graphics/BitmapFactory$Options
    //   39: dup
    //   40: invokespecial 104	android/graphics/BitmapFactory$Options:<init>	()V
    //   43: astore_3
    //   44: aload_3
    //   45: iconst_1
    //   46: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   49: aload_1
    //   50: iconst_0
    //   51: aload_1
    //   52: arraylength
    //   53: aload_3
    //   54: invokestatic 114	android/graphics/BitmapFactory:decodeByteArray	([BIILandroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   57: pop
    //   58: aload_3
    //   59: getfield 118	android/graphics/BitmapFactory$Options:outWidth	I
    //   62: ifle +10 -> 72
    //   65: aload_3
    //   66: getfield 121	android/graphics/BitmapFactory$Options:outHeight	I
    //   69: ifgt +13 -> 82
    //   72: new 123	java/lang/IllegalArgumentException
    //   75: dup
    //   76: ldc 125
    //   78: invokespecial 126	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   81: athrow
    //   82: ldc 128
    //   84: aload_3
    //   85: getfield 131	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   88: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   91: ifeq +132 -> 223
    //   94: ldc 139
    //   96: astore_3
    //   97: aload_3
    //   98: ifnull +221 -> 319
    //   101: new 141	java/lang/StringBuilder
    //   104: dup
    //   105: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   108: getstatic 88	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   111: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc 148
    //   116: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   122: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   125: aload_3
    //   126: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: astore 4
    //   134: new 83	java/io/File
    //   137: dup
    //   138: aload 4
    //   140: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   143: astore 5
    //   145: new 162	java/io/FileOutputStream
    //   148: dup
    //   149: aload 5
    //   151: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   154: astore_3
    //   155: aload_3
    //   156: aload_1
    //   157: invokevirtual 169	java/io/FileOutputStream:write	([B)V
    //   160: aload_3
    //   161: ifnull +7 -> 168
    //   164: aload_3
    //   165: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   168: iconst_1
    //   169: istore_2
    //   170: aload 4
    //   172: astore_1
    //   173: iload_2
    //   174: ifeq +308 -> 482
    //   177: new 174	android/content/Intent
    //   180: dup
    //   181: ldc 176
    //   183: invokespecial 177	android/content/Intent:<init>	(Ljava/lang/String;)V
    //   186: astore_3
    //   187: aload_3
    //   188: new 141	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   195: ldc 179
    //   197: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: aload_1
    //   201: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 185	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   210: invokevirtual 189	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
    //   213: pop
    //   214: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   217: aload_3
    //   218: invokevirtual 201	android/content/Context:sendBroadcast	(Landroid/content/Intent;)V
    //   221: aload_1
    //   222: areturn
    //   223: ldc 203
    //   225: aload_3
    //   226: getfield 131	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   229: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   232: ifeq +9 -> 241
    //   235: ldc 205
    //   237: astore_3
    //   238: goto -141 -> 97
    //   241: ldc 207
    //   243: aload_3
    //   244: getfield 131	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   247: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   250: ifeq +9 -> 259
    //   253: ldc 209
    //   255: astore_3
    //   256: goto -159 -> 97
    //   259: ldc 211
    //   261: aload_3
    //   262: getfield 131	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   265: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   268: ifeq +254 -> 522
    //   271: ldc 213
    //   273: astore_3
    //   274: goto -177 -> 97
    //   277: astore_1
    //   278: aconst_null
    //   279: astore_3
    //   280: aload_3
    //   281: ifnull +7 -> 288
    //   284: aload_3
    //   285: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   288: aload 5
    //   290: invokevirtual 216	java/io/File:exists	()Z
    //   293: ifeq +9 -> 302
    //   296: aload 5
    //   298: invokevirtual 219	java/io/File:delete	()Z
    //   301: pop
    //   302: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   305: ifeq +12 -> 317
    //   308: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   311: iconst_2
    //   312: ldc 226
    //   314: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   317: aload_1
    //   318: athrow
    //   319: new 141	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   326: getstatic 88	com/tencent/mobileqq/app/AppConstants:aK	Ljava/lang/String;
    //   329: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc 148
    //   334: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   340: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   343: ldc 139
    //   345: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: astore_3
    //   352: new 83	java/io/File
    //   355: dup
    //   356: aload_3
    //   357: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   360: astore 6
    //   362: new 162	java/io/FileOutputStream
    //   365: dup
    //   366: aload 6
    //   368: invokespecial 165	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   371: astore 5
    //   373: aload_1
    //   374: iconst_0
    //   375: aload_1
    //   376: arraylength
    //   377: invokestatic 232	android/graphics/BitmapFactory:decodeByteArray	([BII)Landroid/graphics/Bitmap;
    //   380: getstatic 238	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   383: bipush 75
    //   385: aload 5
    //   387: invokevirtual 244	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   390: istore_2
    //   391: aload 5
    //   393: ifnull +8 -> 401
    //   396: aload 5
    //   398: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   401: iload_2
    //   402: ifne +115 -> 517
    //   405: aload 6
    //   407: invokevirtual 216	java/io/File:exists	()Z
    //   410: ifeq +9 -> 419
    //   413: aload 6
    //   415: invokevirtual 219	java/io/File:delete	()Z
    //   418: pop
    //   419: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +95 -> 517
    //   425: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   428: iconst_2
    //   429: ldc 246
    //   431: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   434: aload_3
    //   435: astore_1
    //   436: goto -263 -> 173
    //   439: astore_1
    //   440: aload 4
    //   442: astore_3
    //   443: aload_3
    //   444: ifnull +7 -> 451
    //   447: aload_3
    //   448: invokevirtual 172	java/io/FileOutputStream:close	()V
    //   451: aload 6
    //   453: invokevirtual 216	java/io/File:exists	()Z
    //   456: ifeq +9 -> 465
    //   459: aload 6
    //   461: invokevirtual 219	java/io/File:delete	()Z
    //   464: pop
    //   465: invokestatic 224	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +12 -> 480
    //   471: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   474: iconst_2
    //   475: ldc 246
    //   477: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   480: aload_1
    //   481: athrow
    //   482: new 81	java/io/IOException
    //   485: dup
    //   486: invokespecial 247	java/io/IOException:<init>	()V
    //   489: athrow
    //   490: astore_1
    //   491: goto -323 -> 168
    //   494: astore_3
    //   495: goto -207 -> 288
    //   498: astore_1
    //   499: goto -98 -> 401
    //   502: astore_3
    //   503: goto -52 -> 451
    //   506: astore_1
    //   507: aload 5
    //   509: astore_3
    //   510: goto -67 -> 443
    //   513: astore_1
    //   514: goto -234 -> 280
    //   517: aload_3
    //   518: astore_1
    //   519: goto -346 -> 173
    //   522: aconst_null
    //   523: astore_3
    //   524: goto -427 -> 97
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	527	0	this	MediaApiPlugin
    //   0	527	1	paramArrayOfByte	byte[]
    //   169	233	2	bool	boolean
    //   13	435	3	localObject1	Object
    //   494	1	3	localIOException1	IOException
    //   502	1	3	localIOException2	IOException
    //   509	15	3	localObject2	Object
    //   1	440	4	str	String
    //   143	365	5	localObject3	Object
    //   360	100	6	localFile	File
    // Exception table:
    //   from	to	target	type
    //   145	155	277	finally
    //   362	373	439	finally
    //   164	168	490	java/io/IOException
    //   284	288	494	java/io/IOException
    //   396	401	498	java/io/IOException
    //   447	451	502	java/io/IOException
    //   373	391	506	finally
    //   155	160	513	finally
  }
  
  public static JSONObject a(String paramString, int paramInt)
  {
    long l1 = System.currentTimeMillis();
    JSONObject localJSONObject = new JSONObject();
    Object localObject1 = new File(paramString);
    if (((File)localObject1).length() < 3L) {
      throw new IOException();
    }
    Object localObject2 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject2).inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject2);
    int m = ((BitmapFactory.Options)localObject2).outWidth;
    int n = ((BitmapFactory.Options)localObject2).outHeight;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 realWidth: " + m + ", realHeight: " + n + ", realSize: " + ((File)localObject1).length());
    }
    if ((m < 0) || (n < 0)) {
      throw new IOException();
    }
    Object localObject3 = a(paramString, paramInt);
    localObject1 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject1).inJustDecodeBounds = false;
    localObject2 = BitmapFactory.decodeFile((String)localObject3, (BitmapFactory.Options)localObject1);
    if (QLog.isColorLevel())
    {
      localObject3 = new File((String)localObject3);
      QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 curWidth: " + ((BitmapFactory.Options)localObject1).outWidth + ", curHeight: " + ((BitmapFactory.Options)localObject1).outHeight + ", realSize: " + ((File)localObject3).length());
    }
    localObject3 = new ByteArrayOutputStream(1024);
    localObject1 = ((BitmapFactory.Options)localObject1).outMimeType;
    if (("image/png".equalsIgnoreCase((String)localObject1)) || ("image/gif".equals(localObject1)) || ("image/bmp".equals(localObject1)))
    {
      localObject1 = new StringBuilder("data:image/png;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.PNG, 100, (OutputStream)localObject3);
    }
    for (;;)
    {
      ((Bitmap)localObject2).recycle();
      ((StringBuilder)localObject1).append(Base64Util.encodeToString(((ByteArrayOutputStream)localObject3).toByteArray(), 2));
      localJSONObject.put("match", 0);
      localJSONObject.put("data", localObject1);
      localJSONObject.put("imageID", paramString);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "packImageObjectV2 time: " + (System.currentTimeMillis() - l1));
      }
      return localJSONObject;
      localObject1 = new StringBuilder("data:image/jpeg;base64,");
      ((Bitmap)localObject2).compress(Bitmap.CompressFormat.JPEG, 80, (OutputStream)localObject3);
    }
  }
  
  /* Error */
  public static JSONObject a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    // Byte code:
    //   0: new 250	org/json/JSONObject
    //   3: dup
    //   4: invokespecial 251	org/json/JSONObject:<init>	()V
    //   7: astore 11
    //   9: new 83	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 10
    //   19: aload 10
    //   21: invokevirtual 254	java/io/File:length	()J
    //   24: ldc2_w 255
    //   27: lcmp
    //   28: ifge +11 -> 39
    //   31: new 81	java/io/IOException
    //   34: dup
    //   35: invokespecial 247	java/io/IOException:<init>	()V
    //   38: athrow
    //   39: new 103	android/graphics/BitmapFactory$Options
    //   42: dup
    //   43: invokespecial 104	android/graphics/BitmapFactory$Options:<init>	()V
    //   46: astore 9
    //   48: aload 9
    //   50: iconst_1
    //   51: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   54: aload_0
    //   55: aload 9
    //   57: invokestatic 260	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   60: pop
    //   61: aload 9
    //   63: getfield 118	android/graphics/BitmapFactory$Options:outWidth	I
    //   66: istore 7
    //   68: aload 9
    //   70: getfield 121	android/graphics/BitmapFactory$Options:outHeight	I
    //   73: istore 8
    //   75: iload 7
    //   77: iflt +8 -> 85
    //   80: iload 8
    //   82: ifge +11 -> 93
    //   85: new 81	java/io/IOException
    //   88: dup
    //   89: invokespecial 247	java/io/IOException:<init>	()V
    //   92: athrow
    //   93: iload 7
    //   95: iload_1
    //   96: if_icmplt +9 -> 105
    //   99: iload 8
    //   101: iload_2
    //   102: if_icmpge +15 -> 117
    //   105: aload 11
    //   107: ldc 20
    //   109: iconst_1
    //   110: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   113: pop
    //   114: aload 11
    //   116: areturn
    //   117: iload 7
    //   119: iload_3
    //   120: if_icmpgt +337 -> 457
    //   123: iload 8
    //   125: iload 4
    //   127: if_icmpgt +330 -> 457
    //   130: new 316	java/io/FileInputStream
    //   133: dup
    //   134: aload 10
    //   136: invokespecial 317	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 10
    //   141: aload 10
    //   143: invokevirtual 323	java/io/InputStream:read	()I
    //   146: istore_1
    //   147: aload 10
    //   149: invokevirtual 323	java/io/InputStream:read	()I
    //   152: istore_2
    //   153: aload 10
    //   155: invokevirtual 323	java/io/InputStream:read	()I
    //   158: istore_3
    //   159: iload_1
    //   160: sipush 255
    //   163: if_icmpne +104 -> 267
    //   166: iload_2
    //   167: sipush 216
    //   170: if_icmpne +97 -> 267
    //   173: new 141	java/lang/StringBuilder
    //   176: dup
    //   177: ldc_w 313
    //   180: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   183: astore 9
    //   185: aload 9
    //   187: iconst_3
    //   188: newarray byte
    //   190: dup
    //   191: iconst_0
    //   192: iload_1
    //   193: i2b
    //   194: bastore
    //   195: dup
    //   196: iconst_1
    //   197: iload_2
    //   198: i2b
    //   199: bastore
    //   200: dup
    //   201: iconst_2
    //   202: iload_3
    //   203: i2b
    //   204: bastore
    //   205: iconst_2
    //   206: invokestatic 303	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   209: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: sipush 30720
    //   216: newarray byte
    //   218: astore 12
    //   220: aload 10
    //   222: aload 12
    //   224: invokevirtual 326	java/io/InputStream:read	([B)I
    //   227: istore_1
    //   228: iload_1
    //   229: iconst_m1
    //   230: if_icmpeq +186 -> 416
    //   233: invokestatic 332	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   236: invokevirtual 335	java/lang/Thread:isInterrupted	()Z
    //   239: ifeq +125 -> 364
    //   242: new 337	java/lang/InterruptedException
    //   245: dup
    //   246: invokespecial 338	java/lang/InterruptedException:<init>	()V
    //   249: athrow
    //   250: astore_0
    //   251: aload 10
    //   253: astore 9
    //   255: aload 9
    //   257: ifnull +8 -> 265
    //   260: aload 9
    //   262: invokevirtual 339	java/io/InputStream:close	()V
    //   265: aload_0
    //   266: athrow
    //   267: iload_1
    //   268: bipush 66
    //   270: if_icmpne +24 -> 294
    //   273: iload_2
    //   274: bipush 77
    //   276: if_icmpne +18 -> 294
    //   279: new 141	java/lang/StringBuilder
    //   282: dup
    //   283: ldc_w 341
    //   286: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   289: astore 9
    //   291: goto -106 -> 185
    //   294: iload_1
    //   295: sipush 137
    //   298: if_icmpne +24 -> 322
    //   301: iload_2
    //   302: bipush 80
    //   304: if_icmpne +18 -> 322
    //   307: new 141	java/lang/StringBuilder
    //   310: dup
    //   311: ldc_w 286
    //   314: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   317: astore 9
    //   319: goto -134 -> 185
    //   322: iload_1
    //   323: bipush 71
    //   325: if_icmpne +24 -> 349
    //   328: iload_2
    //   329: bipush 73
    //   331: if_icmpne +18 -> 349
    //   334: new 141	java/lang/StringBuilder
    //   337: dup
    //   338: ldc_w 343
    //   341: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   344: astore 9
    //   346: goto -161 -> 185
    //   349: new 141	java/lang/StringBuilder
    //   352: dup
    //   353: ldc_w 345
    //   356: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   359: astore 9
    //   361: goto -176 -> 185
    //   364: iload_1
    //   365: sipush 30720
    //   368: if_icmpge +33 -> 401
    //   371: iload_1
    //   372: newarray byte
    //   374: astore 13
    //   376: aload 12
    //   378: iconst_0
    //   379: aload 13
    //   381: iconst_0
    //   382: iload_1
    //   383: invokestatic 349	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   386: aload 9
    //   388: aload 13
    //   390: iconst_2
    //   391: invokestatic 303	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   394: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: goto -178 -> 220
    //   401: aload 9
    //   403: aload 12
    //   405: iconst_2
    //   406: invokestatic 303	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   409: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   412: pop
    //   413: goto -193 -> 220
    //   416: aload 11
    //   418: ldc 20
    //   420: iconst_0
    //   421: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   424: pop
    //   425: aload 11
    //   427: ldc 23
    //   429: aload 9
    //   431: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   434: pop
    //   435: aload 11
    //   437: ldc 26
    //   439: aload_0
    //   440: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   443: pop
    //   444: aload 10
    //   446: ifnull -332 -> 114
    //   449: aload 10
    //   451: invokevirtual 339	java/io/InputStream:close	()V
    //   454: aload 11
    //   456: areturn
    //   457: iload 7
    //   459: iload_3
    //   460: idiv
    //   461: iload 8
    //   463: iload 4
    //   465: idiv
    //   466: invokestatic 355	java/lang/Math:max	(II)I
    //   469: istore_1
    //   470: aload 9
    //   472: iconst_0
    //   473: putfield 108	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   476: iload_1
    //   477: iload_1
    //   478: iconst_1
    //   479: iushr
    //   480: ior
    //   481: istore_1
    //   482: iload_1
    //   483: iload_1
    //   484: iconst_2
    //   485: iushr
    //   486: ior
    //   487: istore_1
    //   488: iload_1
    //   489: iload_1
    //   490: iconst_4
    //   491: iushr
    //   492: ior
    //   493: istore_1
    //   494: iload_1
    //   495: iload_1
    //   496: bipush 8
    //   498: iushr
    //   499: ior
    //   500: istore_1
    //   501: aload 9
    //   503: iload_1
    //   504: iload_1
    //   505: bipush 16
    //   507: iushr
    //   508: ior
    //   509: iconst_1
    //   510: iadd
    //   511: iconst_1
    //   512: iushr
    //   513: putfield 358	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   516: aload_0
    //   517: aload 9
    //   519: invokestatic 260	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   522: astore 12
    //   524: iload 7
    //   526: iload 4
    //   528: imul
    //   529: iload 8
    //   531: iload_3
    //   532: imul
    //   533: if_icmple +247 -> 780
    //   536: iload_3
    //   537: i2f
    //   538: aload 12
    //   540: invokevirtual 361	android/graphics/Bitmap:getWidth	()I
    //   543: i2f
    //   544: fdiv
    //   545: fstore 5
    //   547: new 363	android/graphics/Matrix
    //   550: dup
    //   551: invokespecial 364	android/graphics/Matrix:<init>	()V
    //   554: astore 10
    //   556: new 366	android/media/ExifInterface
    //   559: dup
    //   560: aload_0
    //   561: invokespecial 367	android/media/ExifInterface:<init>	(Ljava/lang/String;)V
    //   564: ldc_w 369
    //   567: iconst_1
    //   568: invokevirtual 373	android/media/ExifInterface:getAttributeInt	(Ljava/lang/String;I)I
    //   571: tableswitch	default:+410 -> 981, 2:+224->795, 3:+255->826, 4:+276->847, 5:+289->860, 6:+311->882, 7:+332->903, 8:+354->925
    //   613: lconst_1
    //   614: fload 5
    //   616: fload 5
    //   618: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   621: aload 12
    //   623: iconst_0
    //   624: iconst_0
    //   625: aload 12
    //   627: invokevirtual 361	android/graphics/Bitmap:getWidth	()I
    //   630: aload 12
    //   632: invokevirtual 380	android/graphics/Bitmap:getHeight	()I
    //   635: aload 10
    //   637: iconst_1
    //   638: invokestatic 384	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   641: astore 10
    //   643: aload 12
    //   645: aload 10
    //   647: if_acmpeq +8 -> 655
    //   650: aload 12
    //   652: invokevirtual 293	android/graphics/Bitmap:recycle	()V
    //   655: new 277	java/io/ByteArrayOutputStream
    //   658: dup
    //   659: sipush 1024
    //   662: invokespecial 280	java/io/ByteArrayOutputStream:<init>	(I)V
    //   665: astore 12
    //   667: aload 9
    //   669: getfield 131	android/graphics/BitmapFactory$Options:outMimeType	Ljava/lang/String;
    //   672: astore 9
    //   674: ldc 207
    //   676: aload 9
    //   678: invokevirtual 284	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   681: ifne +23 -> 704
    //   684: ldc 211
    //   686: aload 9
    //   688: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   691: ifne +13 -> 704
    //   694: ldc 203
    //   696: aload 9
    //   698: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   701: ifeq +245 -> 946
    //   704: new 141	java/lang/StringBuilder
    //   707: dup
    //   708: ldc_w 286
    //   711: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   714: astore 9
    //   716: aload 10
    //   718: getstatic 290	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   721: bipush 100
    //   723: aload 12
    //   725: invokevirtual 244	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   728: pop
    //   729: aload 10
    //   731: invokevirtual 293	android/graphics/Bitmap:recycle	()V
    //   734: aload 9
    //   736: aload 12
    //   738: invokevirtual 297	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   741: iconst_2
    //   742: invokestatic 303	com/tencent/mobileqq/utils/Base64Util:encodeToString	([BI)Ljava/lang/String;
    //   745: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload 11
    //   751: ldc 20
    //   753: iconst_0
    //   754: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   757: pop
    //   758: aload 11
    //   760: ldc 23
    //   762: aload 9
    //   764: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   767: pop
    //   768: aload 11
    //   770: ldc 26
    //   772: aload_0
    //   773: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   776: pop
    //   777: aload 11
    //   779: areturn
    //   780: iload 4
    //   782: i2f
    //   783: aload 12
    //   785: invokevirtual 380	android/graphics/Bitmap:getHeight	()I
    //   788: i2f
    //   789: fdiv
    //   790: fstore 5
    //   792: goto -245 -> 547
    //   795: fload 5
    //   797: fneg
    //   798: fstore 6
    //   800: aload 10
    //   802: fload 6
    //   804: fload 5
    //   806: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   809: goto -188 -> 621
    //   812: astore 13
    //   814: aload 10
    //   816: fload 5
    //   818: fload 5
    //   820: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   823: goto -202 -> 621
    //   826: aload 10
    //   828: fload 5
    //   830: fload 5
    //   832: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   835: aload 10
    //   837: ldc_w 385
    //   840: invokevirtual 389	android/graphics/Matrix:postRotate	(F)Z
    //   843: pop
    //   844: goto -223 -> 621
    //   847: aload 10
    //   849: fload 5
    //   851: fload 5
    //   853: fneg
    //   854: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   857: goto -236 -> 621
    //   860: aload 10
    //   862: fload 5
    //   864: fload 5
    //   866: fneg
    //   867: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   870: aload 10
    //   872: ldc_w 390
    //   875: invokevirtual 389	android/graphics/Matrix:postRotate	(F)Z
    //   878: pop
    //   879: goto -258 -> 621
    //   882: aload 10
    //   884: fload 5
    //   886: fload 5
    //   888: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   891: aload 10
    //   893: ldc_w 390
    //   896: invokevirtual 389	android/graphics/Matrix:postRotate	(F)Z
    //   899: pop
    //   900: goto -279 -> 621
    //   903: aload 10
    //   905: fload 5
    //   907: fneg
    //   908: fload 5
    //   910: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   913: aload 10
    //   915: ldc_w 390
    //   918: invokevirtual 389	android/graphics/Matrix:postRotate	(F)Z
    //   921: pop
    //   922: goto -301 -> 621
    //   925: aload 10
    //   927: fload 5
    //   929: fload 5
    //   931: invokevirtual 377	android/graphics/Matrix:setScale	(FF)V
    //   934: aload 10
    //   936: ldc_w 391
    //   939: invokevirtual 389	android/graphics/Matrix:postRotate	(F)Z
    //   942: pop
    //   943: goto -322 -> 621
    //   946: new 141	java/lang/StringBuilder
    //   949: dup
    //   950: ldc_w 313
    //   953: invokespecial 287	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   956: astore 9
    //   958: aload 10
    //   960: getstatic 238	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   963: bipush 80
    //   965: aload 12
    //   967: invokevirtual 244	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   970: pop
    //   971: goto -242 -> 729
    //   974: astore_0
    //   975: aconst_null
    //   976: astore 9
    //   978: goto -723 -> 255
    //   981: goto -369 -> 612
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	984	0	paramString	String
    //   0	984	1	paramInt1	int
    //   0	984	2	paramInt2	int
    //   0	984	3	paramInt3	int
    //   0	984	4	paramInt4	int
    //   545	385	5	f1	float
    //   798	5	6	f2	float
    //   66	463	7	m	int
    //   73	460	8	n	int
    //   46	931	9	localObject1	Object
    //   17	942	10	localObject2	Object
    //   7	771	11	localJSONObject	JSONObject
    //   218	748	12	localObject3	Object
    //   374	15	13	arrayOfByte	byte[]
    //   812	1	13	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   141	159	250	finally
    //   173	185	250	finally
    //   185	220	250	finally
    //   220	228	250	finally
    //   233	250	250	finally
    //   279	291	250	finally
    //   307	319	250	finally
    //   334	346	250	finally
    //   349	361	250	finally
    //   371	398	250	finally
    //   401	413	250	finally
    //   416	444	250	finally
    //   556	612	812	java/io/IOException
    //   612	621	812	java/io/IOException
    //   800	809	812	java/io/IOException
    //   826	844	812	java/io/IOException
    //   847	857	812	java/io/IOException
    //   860	879	812	java/io/IOException
    //   882	900	812	java/io/IOException
    //   903	922	812	java/io/IOException
    //   925	943	812	java/io/IOException
    //   130	141	974	finally
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
  }
  
  /* Error */
  protected boolean handleJsRequest(com.tencent.mobileqq.webviewplugin.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc_w 406
    //   3: aload_3
    //   4: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7: ifeq +1278 -> 1285
    //   10: ldc_w 408
    //   13: aload 4
    //   15: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   18: ifne +13 -> 31
    //   21: ldc 41
    //   23: aload 4
    //   25: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   28: ifeq +659 -> 687
    //   31: aload 5
    //   33: arraylength
    //   34: iconst_1
    //   35: if_icmpne +652 -> 687
    //   38: new 250	org/json/JSONObject
    //   41: dup
    //   42: aload 5
    //   44: iconst_0
    //   45: aaload
    //   46: invokespecial 409	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_1
    //   50: ldc 41
    //   52: aload 4
    //   54: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   57: ifeq +13 -> 70
    //   60: aload_1
    //   61: ldc_w 411
    //   64: aload 4
    //   66: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   69: pop
    //   70: aload_1
    //   71: ldc 17
    //   73: invokevirtual 415	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   76: astore_3
    //   77: aload_3
    //   78: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   81: ifeq +5 -> 86
    //   84: iconst_1
    //   85: ireturn
    //   86: aload_1
    //   87: ldc_w 423
    //   90: iconst_0
    //   91: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   94: istore 6
    //   96: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   99: astore_2
    //   100: iload 6
    //   102: ifne +163 -> 265
    //   105: aload_0
    //   106: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   109: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   112: astore 4
    //   114: aload 4
    //   116: instanceof 437
    //   119: ifeq +123 -> 242
    //   122: new 174	android/content/Intent
    //   125: dup
    //   126: invokespecial 438	android/content/Intent:<init>	()V
    //   129: astore_3
    //   130: aload_3
    //   131: aload 4
    //   133: ldc_w 440
    //   136: invokevirtual 444	android/content/Intent:setClass	(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;
    //   139: pop
    //   140: aload_3
    //   141: ldc_w 446
    //   144: aload 4
    //   146: invokevirtual 452	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 455	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 459	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   155: pop
    //   156: aload_3
    //   157: ldc_w 461
    //   160: ldc_w 463
    //   163: invokevirtual 459	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   166: pop
    //   167: aload_1
    //   168: ldc_w 464
    //   171: iconst_1
    //   172: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   175: istore 6
    //   177: aload_3
    //   178: ldc_w 466
    //   181: iload 6
    //   183: invokevirtual 469	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   186: pop
    //   187: iload 6
    //   189: iconst_1
    //   190: if_icmpne +12 -> 202
    //   193: aload_3
    //   194: ldc_w 471
    //   197: iconst_1
    //   198: invokevirtual 474	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   201: pop
    //   202: aload 4
    //   204: checkcast 437	com/tencent/mobileqq/activity/QQBrowserActivity
    //   207: aload_0
    //   208: aload_3
    //   209: iconst_2
    //   210: invokevirtual 477	com/tencent/mobileqq/activity/QQBrowserActivity:a	(Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin;Landroid/content/Intent;B)V
    //   213: aload_2
    //   214: invokestatic 483	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   217: invokeinterface 489 1 0
    //   222: ldc 14
    //   224: aload_1
    //   225: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   228: invokeinterface 496 3 0
    //   233: invokeinterface 499 1 0
    //   238: pop
    //   239: goto +1052 -> 1291
    //   242: aload_0
    //   243: aload_3
    //   244: iconst_2
    //   245: anewarray 133	java/lang/String
    //   248: dup
    //   249: iconst_0
    //   250: ldc_w 501
    //   253: aastore
    //   254: dup
    //   255: iconst_1
    //   256: ldc_w 503
    //   259: aastore
    //   260: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   263: iconst_1
    //   264: ireturn
    //   265: iload 6
    //   267: iconst_1
    //   268: if_icmpne +1023 -> 1291
    //   271: new 83	java/io/File
    //   274: dup
    //   275: new 141	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   282: getstatic 510	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   285: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 512
    //   291: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   297: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   300: astore 4
    //   302: aload 4
    //   304: invokevirtual 216	java/io/File:exists	()Z
    //   307: ifne +46 -> 353
    //   310: aload 4
    //   312: invokevirtual 95	java/io/File:mkdirs	()Z
    //   315: ifne +38 -> 353
    //   318: aload_2
    //   319: ldc_w 513
    //   322: iconst_0
    //   323: invokestatic 518	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   326: invokevirtual 521	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   329: pop
    //   330: aload_0
    //   331: aload_3
    //   332: iconst_2
    //   333: anewarray 133	java/lang/String
    //   336: dup
    //   337: iconst_0
    //   338: ldc_w 501
    //   341: aastore
    //   342: dup
    //   343: iconst_1
    //   344: ldc_w 503
    //   347: aastore
    //   348: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   351: iconst_1
    //   352: ireturn
    //   353: new 141	java/lang/StringBuilder
    //   356: dup
    //   357: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   360: getstatic 510	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   363: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 512
    //   369: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokestatic 154	java/lang/System:currentTimeMillis	()J
    //   375: invokevirtual 157	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: ldc 139
    //   380: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: astore_3
    //   387: new 174	android/content/Intent
    //   390: dup
    //   391: invokespecial 438	android/content/Intent:<init>	()V
    //   394: astore 4
    //   396: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   399: new 83	java/io/File
    //   402: dup
    //   403: aload_3
    //   404: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   407: aload 4
    //   409: invokestatic 527	com/tencent/mobileqq/utils/FileProvider7Helper:setSystemCapture	(Landroid/content/Context;Ljava/io/File;Landroid/content/Intent;)Landroid/net/Uri;
    //   412: pop
    //   413: aload_1
    //   414: ldc_w 529
    //   417: iconst_0
    //   418: invokevirtual 533	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   421: ifeq +13 -> 434
    //   424: aload 4
    //   426: ldc_w 535
    //   429: iconst_1
    //   430: invokevirtual 469	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   433: pop
    //   434: aload_0
    //   435: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   438: ifnull +853 -> 1291
    //   441: aload_0
    //   442: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   445: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   448: ifnull +843 -> 1291
    //   451: aload_0
    //   452: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   455: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   458: instanceof 537
    //   461: ifeq +830 -> 1291
    //   464: aload_0
    //   465: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   468: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   471: checkcast 537	mqq/app/AppActivity
    //   474: astore 5
    //   476: getstatic 542	android/os/Build$VERSION:SDK_INT	I
    //   479: bipush 23
    //   481: if_icmplt +161 -> 642
    //   484: aload 5
    //   486: getfield 546	mqq/app/AppActivity:permissionManager	Lmqq/app/permission/PermissionManager;
    //   489: ldc_w 548
    //   492: invokevirtual 553	mqq/app/permission/PermissionManager:checkPermission	(Ljava/lang/String;)Z
    //   495: ifeq +17 -> 512
    //   498: aload 5
    //   500: getfield 546	mqq/app/AppActivity:permissionManager	Lmqq/app/permission/PermissionManager;
    //   503: ldc_w 555
    //   506: invokevirtual 553	mqq/app/permission/PermissionManager:checkPermission	(Ljava/lang/String;)Z
    //   509: ifne +88 -> 597
    //   512: aload 5
    //   514: getfield 546	mqq/app/AppActivity:permissionManager	Lmqq/app/permission/PermissionManager;
    //   517: iconst_2
    //   518: anewarray 557	mqq/app/permission/PermissionItem
    //   521: dup
    //   522: iconst_0
    //   523: ldc_w 548
    //   526: sipush 200
    //   529: invokestatic 561	mqq/app/permission/PermissionItem:init	(Ljava/lang/String;I)Lmqq/app/permission/PermissionItem;
    //   532: aastore
    //   533: dup
    //   534: iconst_1
    //   535: ldc_w 555
    //   538: sipush 200
    //   541: invokestatic 561	mqq/app/permission/PermissionItem:init	(Ljava/lang/String;I)Lmqq/app/permission/PermissionItem;
    //   544: aastore
    //   545: invokevirtual 565	mqq/app/permission/PermissionManager:permissions	([Lmqq/app/permission/PermissionItem;)Lmqq/app/permission/PermissionManager;
    //   548: new 567	jcj
    //   551: dup
    //   552: aload_0
    //   553: aload 4
    //   555: aload_2
    //   556: aload_3
    //   557: aload_1
    //   558: aload 5
    //   560: invokespecial 570	jcj:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Landroid/content/Intent;Landroid/content/Context;Ljava/lang/String;Lorg/json/JSONObject;Lmqq/app/AppActivity;)V
    //   563: invokevirtual 574	mqq/app/permission/PermissionManager:requests	(Lmqq/app/permission/PermissionCallback;)V
    //   566: goto +725 -> 1291
    //   569: astore_1
    //   570: aload_1
    //   571: invokevirtual 577	java/lang/Exception:printStackTrace	()V
    //   574: aload_2
    //   575: ldc_w 578
    //   578: iconst_0
    //   579: invokestatic 518	com/tencent/mobileqq/widget/QQToast:a	(Landroid/content/Context;II)Lcom/tencent/mobileqq/widget/QQToast;
    //   582: invokevirtual 521	com/tencent/mobileqq/widget/QQToast:a	()Landroid/widget/Toast;
    //   585: pop
    //   586: goto +705 -> 1291
    //   589: astore_1
    //   590: aload_1
    //   591: invokevirtual 579	org/json/JSONException:printStackTrace	()V
    //   594: goto +697 -> 1291
    //   597: aload_0
    //   598: aload 4
    //   600: iconst_1
    //   601: invokevirtual 583	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   604: aload_2
    //   605: invokestatic 483	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   608: invokeinterface 489 1 0
    //   613: ldc_w 585
    //   616: aload_3
    //   617: invokeinterface 496 3 0
    //   622: ldc 14
    //   624: aload_1
    //   625: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   628: invokeinterface 496 3 0
    //   633: invokeinterface 499 1 0
    //   638: pop
    //   639: goto +652 -> 1291
    //   642: aload_0
    //   643: aload 4
    //   645: iconst_1
    //   646: invokevirtual 583	com/tencent/mobileqq/jsp/MediaApiPlugin:startActivityForResult	(Landroid/content/Intent;B)V
    //   649: aload_2
    //   650: invokestatic 483	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   653: invokeinterface 489 1 0
    //   658: ldc_w 585
    //   661: aload_3
    //   662: invokeinterface 496 3 0
    //   667: ldc 14
    //   669: aload_1
    //   670: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   673: invokeinterface 496 3 0
    //   678: invokeinterface 499 1 0
    //   683: pop
    //   684: goto +607 -> 1291
    //   687: ldc_w 587
    //   690: aload 4
    //   692: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   695: ifne +13 -> 708
    //   698: ldc 44
    //   700: aload 4
    //   702: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   705: ifeq +221 -> 926
    //   708: aload 5
    //   710: arraylength
    //   711: iconst_1
    //   712: if_icmpne +214 -> 926
    //   715: new 250	org/json/JSONObject
    //   718: dup
    //   719: aload 5
    //   721: iconst_0
    //   722: aaload
    //   723: invokespecial 409	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   726: astore_1
    //   727: aload_1
    //   728: ldc 17
    //   730: invokevirtual 415	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   733: astore_2
    //   734: aload_1
    //   735: ldc 26
    //   737: invokevirtual 415	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   740: astore_3
    //   741: aload_2
    //   742: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   745: ifne +548 -> 1293
    //   748: aload_3
    //   749: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   752: ifeq +6 -> 758
    //   755: goto +538 -> 1293
    //   758: aload_0
    //   759: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   762: ifnonnull +54 -> 816
    //   765: aload_0
    //   766: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   769: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   772: astore 5
    //   774: aload_0
    //   775: new 591	com/tencent/mobileqq/widget/QQProgressDialog
    //   778: dup
    //   779: aload 5
    //   781: aload 5
    //   783: invokevirtual 597	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   786: ldc_w 598
    //   789: invokevirtual 604	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   792: invokespecial 607	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   795: putfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   798: aload_0
    //   799: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   802: ldc_w 608
    //   805: invokevirtual 610	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   808: aload_0
    //   809: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   812: aload_0
    //   813: invokevirtual 613	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   816: aload_0
    //   817: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   820: invokevirtual 616	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   823: ifne +10 -> 833
    //   826: aload_0
    //   827: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   830: invokevirtual 619	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   833: ldc 44
    //   835: aload 4
    //   837: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   840: ifeq +34 -> 874
    //   843: new 621	jcq
    //   846: dup
    //   847: aload_0
    //   848: aload_2
    //   849: aload_1
    //   850: ldc 38
    //   852: iconst_0
    //   853: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   856: aload_3
    //   857: invokespecial 624	jcq:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;ILjava/lang/String;)V
    //   860: invokevirtual 627	jcq:start	()V
    //   863: goto +428 -> 1291
    //   866: astore_1
    //   867: aload_1
    //   868: invokevirtual 579	org/json/JSONException:printStackTrace	()V
    //   871: goto +420 -> 1291
    //   874: new 629	jcp
    //   877: dup
    //   878: aload_0
    //   879: aload_2
    //   880: aload_1
    //   881: ldc_w 631
    //   884: sipush 1280
    //   887: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   890: aload_1
    //   891: ldc_w 633
    //   894: sipush 1280
    //   897: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   900: aload_1
    //   901: ldc_w 635
    //   904: iconst_1
    //   905: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   908: aload_1
    //   909: ldc_w 637
    //   912: iconst_1
    //   913: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   916: aload_3
    //   917: invokespecial 640	jcp:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIIILjava/lang/String;)V
    //   920: invokevirtual 641	jcp:start	()V
    //   923: goto +368 -> 1291
    //   926: ldc_w 643
    //   929: aload 4
    //   931: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   934: ifeq +357 -> 1291
    //   937: aload 5
    //   939: arraylength
    //   940: iconst_1
    //   941: if_icmpne +350 -> 1291
    //   944: aconst_null
    //   945: astore_2
    //   946: new 645	java/util/concurrent/atomic/AtomicBoolean
    //   949: dup
    //   950: iconst_0
    //   951: invokespecial 648	java/util/concurrent/atomic/AtomicBoolean:<init>	(Z)V
    //   954: astore_3
    //   955: aload_2
    //   956: astore_1
    //   957: new 250	org/json/JSONObject
    //   960: dup
    //   961: aload 5
    //   963: iconst_0
    //   964: aaload
    //   965: invokespecial 409	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   968: astore 4
    //   970: aload_2
    //   971: astore_1
    //   972: aload 4
    //   974: ldc 17
    //   976: invokevirtual 415	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   979: astore_2
    //   980: aload_2
    //   981: astore_1
    //   982: aload 4
    //   984: ldc_w 650
    //   987: invokevirtual 653	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   990: astore 4
    //   992: aload_2
    //   993: astore_1
    //   994: aload 4
    //   996: ldc_w 655
    //   999: invokevirtual 658	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1002: ifne +16 -> 1018
    //   1005: aload_2
    //   1006: astore_1
    //   1007: aload 4
    //   1009: ldc_w 660
    //   1012: invokevirtual 658	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1015: ifeq +213 -> 1228
    //   1018: aload_2
    //   1019: astore_1
    //   1020: aload_0
    //   1021: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1024: ifnonnull +62 -> 1086
    //   1027: aload_2
    //   1028: astore_1
    //   1029: aload_0
    //   1030: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   1033: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   1036: astore 5
    //   1038: aload_2
    //   1039: astore_1
    //   1040: aload_0
    //   1041: new 591	com/tencent/mobileqq/widget/QQProgressDialog
    //   1044: dup
    //   1045: aload 5
    //   1047: aload 5
    //   1049: invokevirtual 597	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   1052: ldc_w 598
    //   1055: invokevirtual 604	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   1058: invokespecial 607	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   1061: putfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1064: aload_2
    //   1065: astore_1
    //   1066: aload_0
    //   1067: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1070: ldc_w 608
    //   1073: invokevirtual 610	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   1076: aload_2
    //   1077: astore_1
    //   1078: aload_0
    //   1079: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1082: aload_0
    //   1083: invokevirtual 613	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   1086: aload_2
    //   1087: astore_1
    //   1088: aload_0
    //   1089: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1092: invokevirtual 616	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   1095: ifne +12 -> 1107
    //   1098: aload_2
    //   1099: astore_1
    //   1100: aload_0
    //   1101: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   1104: invokevirtual 619	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   1107: aload_2
    //   1108: astore_1
    //   1109: new 662	jcl
    //   1112: dup
    //   1113: aload_0
    //   1114: aload 4
    //   1116: aload_2
    //   1117: aload_3
    //   1118: invokespecial 665	jcl:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1121: invokestatic 670	com/tencent/mobileqq/app/ThreadManager:a	(Ljava/lang/Runnable;)V
    //   1124: goto +167 -> 1291
    //   1127: astore_2
    //   1128: invokestatic 673	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1131: ifeq +30 -> 1161
    //   1134: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1137: iconst_4
    //   1138: new 141	java/lang/StringBuilder
    //   1141: dup
    //   1142: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1145: ldc_w 675
    //   1148: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: aload_2
    //   1152: invokevirtual 678	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1155: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1158: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1161: aload_1
    //   1162: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1165: ifne +126 -> 1291
    //   1168: aload_3
    //   1169: iconst_0
    //   1170: iconst_1
    //   1171: invokevirtual 682	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   1174: ifeq +117 -> 1291
    //   1177: new 250	org/json/JSONObject
    //   1180: dup
    //   1181: invokespecial 251	org/json/JSONObject:<init>	()V
    //   1184: astore_2
    //   1185: aload_2
    //   1186: ldc 29
    //   1188: iconst_m1
    //   1189: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1192: pop
    //   1193: aload_2
    //   1194: ldc 32
    //   1196: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   1199: ldc_w 683
    //   1202: invokevirtual 686	android/content/Context:getString	(I)Ljava/lang/String;
    //   1205: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   1208: pop
    //   1209: aload_0
    //   1210: aload_1
    //   1211: iconst_1
    //   1212: anewarray 133	java/lang/String
    //   1215: dup
    //   1216: iconst_0
    //   1217: aload_2
    //   1218: invokevirtual 490	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1221: aastore
    //   1222: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   1225: goto +66 -> 1291
    //   1228: aload_2
    //   1229: astore_1
    //   1230: new 688	jcm
    //   1233: dup
    //   1234: aload_0
    //   1235: aload 4
    //   1237: aload_2
    //   1238: aload_3
    //   1239: invokespecial 689	jcm:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;Ljava/lang/String;Ljava/util/concurrent/atomic/AtomicBoolean;)V
    //   1242: invokestatic 691	com/tencent/mobileqq/app/ThreadManager:b	(Ljava/lang/Runnable;)V
    //   1245: goto +46 -> 1291
    //   1248: astore_1
    //   1249: invokestatic 673	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1252: ifeq +39 -> 1291
    //   1255: getstatic 58	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1258: iconst_4
    //   1259: new 141	java/lang/StringBuilder
    //   1262: dup
    //   1263: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   1266: ldc_w 675
    //   1269: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1272: aload_1
    //   1273: invokevirtual 678	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1276: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1279: invokestatic 229	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1282: goto +9 -> 1291
    //   1285: iconst_0
    //   1286: ireturn
    //   1287: astore_3
    //   1288: goto -79 -> 1209
    //   1291: iconst_1
    //   1292: ireturn
    //   1293: iconst_1
    //   1294: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1295	0	this	MediaApiPlugin
    //   0	1295	1	paramJsBridgeListener	com.tencent.mobileqq.webviewplugin.JsBridgeListener
    //   0	1295	2	paramString1	String
    //   0	1295	3	paramString2	String
    //   0	1295	4	paramString3	String
    //   0	1295	5	paramVarArgs	String[]
    //   94	175	6	m	int
    // Exception table:
    //   from	to	target	type
    //   434	512	569	java/lang/Exception
    //   512	566	569	java/lang/Exception
    //   597	639	569	java/lang/Exception
    //   642	684	569	java/lang/Exception
    //   38	70	589	org/json/JSONException
    //   70	84	589	org/json/JSONException
    //   86	100	589	org/json/JSONException
    //   105	187	589	org/json/JSONException
    //   193	202	589	org/json/JSONException
    //   202	239	589	org/json/JSONException
    //   242	263	589	org/json/JSONException
    //   271	351	589	org/json/JSONException
    //   353	434	589	org/json/JSONException
    //   434	512	589	org/json/JSONException
    //   512	566	589	org/json/JSONException
    //   570	586	589	org/json/JSONException
    //   597	639	589	org/json/JSONException
    //   642	684	589	org/json/JSONException
    //   715	755	866	org/json/JSONException
    //   758	816	866	org/json/JSONException
    //   816	833	866	org/json/JSONException
    //   833	863	866	org/json/JSONException
    //   874	923	866	org/json/JSONException
    //   957	970	1127	java/lang/OutOfMemoryError
    //   972	980	1127	java/lang/OutOfMemoryError
    //   982	992	1127	java/lang/OutOfMemoryError
    //   994	1005	1127	java/lang/OutOfMemoryError
    //   1007	1018	1127	java/lang/OutOfMemoryError
    //   1020	1027	1127	java/lang/OutOfMemoryError
    //   1029	1038	1127	java/lang/OutOfMemoryError
    //   1040	1064	1127	java/lang/OutOfMemoryError
    //   1066	1076	1127	java/lang/OutOfMemoryError
    //   1078	1086	1127	java/lang/OutOfMemoryError
    //   1088	1098	1127	java/lang/OutOfMemoryError
    //   1100	1107	1127	java/lang/OutOfMemoryError
    //   1109	1124	1127	java/lang/OutOfMemoryError
    //   1230	1245	1127	java/lang/OutOfMemoryError
    //   957	970	1248	org/json/JSONException
    //   972	980	1248	org/json/JSONException
    //   982	992	1248	org/json/JSONException
    //   994	1005	1248	org/json/JSONException
    //   1007	1018	1248	org/json/JSONException
    //   1020	1027	1248	org/json/JSONException
    //   1029	1038	1248	org/json/JSONException
    //   1040	1064	1248	org/json/JSONException
    //   1066	1076	1248	org/json/JSONException
    //   1078	1086	1248	org/json/JSONException
    //   1088	1098	1248	org/json/JSONException
    //   1100	1107	1248	org/json/JSONException
    //   1109	1124	1248	org/json/JSONException
    //   1230	1245	1248	org/json/JSONException
    //   1185	1209	1287	org/json/JSONException
  }
  
  /* Error */
  public void onActivityResult(android.content.Intent paramIntent, byte paramByte, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: iload_2
    //   3: iload_3
    //   4: invokespecial 695	com/tencent/mobileqq/webviewplugin/WebViewPlugin:onActivityResult	(Landroid/content/Intent;BI)V
    //   7: iload_2
    //   8: iconst_1
    //   9: if_icmpeq +8 -> 17
    //   12: iload_2
    //   13: iconst_2
    //   14: if_icmpne +83 -> 97
    //   17: invokestatic 195	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   20: astore 6
    //   22: aload 6
    //   24: invokestatic 483	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   27: astore 7
    //   29: aload 7
    //   31: ldc_w 585
    //   34: ldc_w 697
    //   37: invokeinterface 700 3 0
    //   42: astore 8
    //   44: aload 7
    //   46: ldc 14
    //   48: ldc_w 697
    //   51: invokeinterface 700 3 0
    //   56: astore 7
    //   58: aload 6
    //   60: invokestatic 483	android/preference/PreferenceManager:getDefaultSharedPreferences	(Landroid/content/Context;)Landroid/content/SharedPreferences;
    //   63: invokeinterface 489 1 0
    //   68: ldc_w 585
    //   71: invokeinterface 704 2 0
    //   76: ldc 14
    //   78: invokeinterface 704 2 0
    //   83: invokeinterface 499 1 0
    //   88: pop
    //   89: aload 7
    //   91: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   94: ifeq +4 -> 98
    //   97: return
    //   98: new 250	org/json/JSONObject
    //   101: dup
    //   102: aload 7
    //   104: invokespecial 409	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   107: astore 7
    //   109: aload 7
    //   111: ldc 17
    //   113: invokevirtual 653	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   116: astore 6
    //   118: aload 6
    //   120: invokestatic 421	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   123: istore 5
    //   125: iload 5
    //   127: ifne -30 -> 97
    //   130: iload_3
    //   131: iconst_m1
    //   132: if_icmpne +428 -> 560
    //   135: iload_2
    //   136: iconst_1
    //   137: if_icmpne +111 -> 248
    //   140: iconst_1
    //   141: anewarray 133	java/lang/String
    //   144: astore_1
    //   145: aload_1
    //   146: iconst_0
    //   147: aload 8
    //   149: aastore
    //   150: aload 7
    //   152: ldc_w 706
    //   155: iconst_0
    //   156: invokevirtual 533	org/json/JSONObject:optBoolean	(Ljava/lang/String;Z)Z
    //   159: ifeq +207 -> 366
    //   162: new 708	org/json/JSONArray
    //   165: dup
    //   166: invokespecial 709	org/json/JSONArray:<init>	()V
    //   169: astore 7
    //   171: aload_1
    //   172: arraylength
    //   173: istore 4
    //   175: iconst_0
    //   176: istore_3
    //   177: iload_3
    //   178: iload 4
    //   180: if_icmpge +137 -> 317
    //   183: aload_1
    //   184: iload_3
    //   185: aaload
    //   186: astore 8
    //   188: new 250	org/json/JSONObject
    //   191: dup
    //   192: invokespecial 251	org/json/JSONObject:<init>	()V
    //   195: astore 9
    //   197: aload 9
    //   199: ldc 23
    //   201: ldc_w 697
    //   204: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   207: pop
    //   208: aload 9
    //   210: ldc 26
    //   212: aload 8
    //   214: invokevirtual 309	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   217: pop
    //   218: aload 9
    //   220: ldc 20
    //   222: iconst_0
    //   223: invokevirtual 306	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   226: pop
    //   227: aload 7
    //   229: aload 9
    //   231: invokevirtual 712	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   234: pop
    //   235: iload_3
    //   236: iconst_1
    //   237: iadd
    //   238: istore_3
    //   239: goto -62 -> 177
    //   242: astore_1
    //   243: aload_1
    //   244: invokevirtual 579	org/json/JSONException:printStackTrace	()V
    //   247: return
    //   248: aload_1
    //   249: ifnull +45 -> 294
    //   252: aload_1
    //   253: ldc_w 714
    //   256: invokevirtual 718	android/content/Intent:getStringArrayListExtra	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   259: astore_1
    //   260: aload_1
    //   261: ifnull +10 -> 271
    //   264: aload_1
    //   265: invokevirtual 723	java/util/ArrayList:size	()I
    //   268: ifne +31 -> 299
    //   271: aload_0
    //   272: aload 6
    //   274: iconst_2
    //   275: anewarray 133	java/lang/String
    //   278: dup
    //   279: iconst_0
    //   280: ldc_w 501
    //   283: aastore
    //   284: dup
    //   285: iconst_1
    //   286: ldc_w 503
    //   289: aastore
    //   290: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   293: return
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -36 -> 260
    //   299: aload_1
    //   300: aload_1
    //   301: invokevirtual 723	java/util/ArrayList:size	()I
    //   304: anewarray 133	java/lang/String
    //   307: invokevirtual 727	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   310: checkcast 729	[Ljava/lang/String;
    //   313: astore_1
    //   314: goto -164 -> 150
    //   317: aload_0
    //   318: aload 6
    //   320: iconst_2
    //   321: anewarray 133	java/lang/String
    //   324: dup
    //   325: iconst_0
    //   326: ldc_w 731
    //   329: aastore
    //   330: dup
    //   331: iconst_1
    //   332: aload 7
    //   334: invokevirtual 732	org/json/JSONArray:toString	()Ljava/lang/String;
    //   337: aastore
    //   338: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   341: return
    //   342: astore_1
    //   343: aload_0
    //   344: aload 6
    //   346: iconst_2
    //   347: anewarray 133	java/lang/String
    //   350: dup
    //   351: iconst_0
    //   352: ldc_w 501
    //   355: aastore
    //   356: dup
    //   357: iconst_1
    //   358: ldc_w 503
    //   361: aastore
    //   362: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   365: return
    //   366: aload_0
    //   367: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   370: ifnonnull +54 -> 424
    //   373: aload_0
    //   374: getfield 430	com/tencent/mobileqq/jsp/MediaApiPlugin:mRuntime	Lcom/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime;
    //   377: invokevirtual 435	com/tencent/mobileqq/webviewplugin/WebViewPlugin$PluginRuntime:a	()Landroid/app/Activity;
    //   380: astore 8
    //   382: aload_0
    //   383: new 591	com/tencent/mobileqq/widget/QQProgressDialog
    //   386: dup
    //   387: aload 8
    //   389: aload 8
    //   391: invokevirtual 597	android/app/Activity:getResources	()Landroid/content/res/Resources;
    //   394: ldc_w 598
    //   397: invokevirtual 604	android/content/res/Resources:getDimensionPixelSize	(I)I
    //   400: invokespecial 607	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   403: putfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   406: aload_0
    //   407: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   410: ldc_w 608
    //   413: invokevirtual 610	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   416: aload_0
    //   417: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   420: aload_0
    //   421: invokevirtual 613	com/tencent/mobileqq/widget/QQProgressDialog:a	(Lcom/tencent/mobileqq/widget/QQProgressDialog$Callback;)V
    //   424: aload_0
    //   425: getfield 393	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   428: ifnull +10 -> 438
    //   431: aload_0
    //   432: getfield 393	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   435: invokevirtual 396	java/lang/Thread:interrupt	()V
    //   438: aload_0
    //   439: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   442: invokevirtual 616	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   445: ifne +10 -> 455
    //   448: aload_0
    //   449: getfield 589	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   452: invokevirtual 619	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   455: ldc 41
    //   457: aload 7
    //   459: ldc_w 411
    //   462: invokevirtual 415	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   465: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   468: ifeq +34 -> 502
    //   471: aload_0
    //   472: new 734	jco
    //   475: dup
    //   476: aload_0
    //   477: aload 6
    //   479: aload 7
    //   481: ldc 38
    //   483: iconst_0
    //   484: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   487: aload_1
    //   488: invokespecial 737	jco:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;I[Ljava/lang/String;)V
    //   491: putfield 393	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   494: aload_0
    //   495: getfield 393	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   498: invokevirtual 738	java/lang/Thread:start	()V
    //   501: return
    //   502: aload_0
    //   503: new 740	jcn
    //   506: dup
    //   507: aload_0
    //   508: aload 6
    //   510: aload 7
    //   512: ldc_w 631
    //   515: sipush 1280
    //   518: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   521: aload 7
    //   523: ldc_w 633
    //   526: sipush 1280
    //   529: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   532: aload 7
    //   534: ldc_w 635
    //   537: iconst_1
    //   538: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   541: aload 7
    //   543: ldc_w 637
    //   546: iconst_1
    //   547: invokevirtual 426	org/json/JSONObject:optInt	(Ljava/lang/String;I)I
    //   550: aload_1
    //   551: invokespecial 743	jcn:<init>	(Lcom/tencent/mobileqq/jsp/MediaApiPlugin;Ljava/lang/String;IIII[Ljava/lang/String;)V
    //   554: putfield 393	com/tencent/mobileqq/jsp/MediaApiPlugin:jdField_a_of_type_JavaLangThread	Ljava/lang/Thread;
    //   557: goto -63 -> 494
    //   560: aload_0
    //   561: aload 6
    //   563: iconst_2
    //   564: anewarray 133	java/lang/String
    //   567: dup
    //   568: iconst_0
    //   569: ldc_w 745
    //   572: aastore
    //   573: dup
    //   574: iconst_1
    //   575: ldc_w 503
    //   578: aastore
    //   579: invokevirtual 507	com/tencent/mobileqq/jsp/MediaApiPlugin:callJs	(Ljava/lang/String;[Ljava/lang/String;)V
    //   582: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	MediaApiPlugin
    //   0	583	1	paramIntent	android.content.Intent
    //   0	583	2	paramByte	byte
    //   0	583	3	paramInt	int
    //   173	8	4	m	int
    //   123	3	5	bool	boolean
    //   20	542	6	localObject1	Object
    //   27	515	7	localObject2	Object
    //   42	348	8	localObject3	Object
    //   195	35	9	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   98	125	242	org/json/JSONException
    //   162	175	342	org/json/JSONException
    //   188	235	342	org/json/JSONException
    //   317	341	342	org/json/JSONException
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangThread != null) {
      this.jdField_a_of_type_JavaLangThread.interrupt();
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
    }
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.MediaApiPlugin
 * JD-Core Version:    0.7.0.1
 */
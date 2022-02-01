package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.NativeGifImage;
import com.tencent.image.URLDrawableHandler;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.apache.http.Header;

public class EmotionDownloader
  extends AbsDownloader
  implements EmotionConstants
{
  private static final String N = "EmotionDownloader";
  static File jdField_a_of_type_JavaIoFile;
  static File b;
  public static final String h = "system_face_decode_copyfile";
  public final int a;
  BaseApplicationImpl jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl;
  public final int b;
  
  public EmotionDownloader(BaseApplicationImpl paramBaseApplicationImpl)
  {
    this.jdField_a_of_type_Int = 89500;
    this.jdField_b_of_type_Int = 89501;
    this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl = paramBaseApplicationImpl;
    jdField_b_of_type_JavaIoFile = paramBaseApplicationImpl.getDir("", 0);
  }
  
  /* Error */
  public File a(java.io.OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    // Byte code:
    //   0: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   3: ifnull +12 -> 15
    //   6: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   9: invokevirtual 53	java/io/File:exists	()Z
    //   12: ifne +55 -> 67
    //   15: aload_0
    //   16: getfield 31	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   19: ldc 55
    //   21: iconst_0
    //   22: invokevirtual 39	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   25: putstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   28: aload_0
    //   29: getfield 31	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   32: ldc 57
    //   34: iconst_0
    //   35: invokevirtual 39	com/tencent/common/app/BaseApplicationImpl:getDir	(Ljava/lang/String;I)Ljava/io/File;
    //   38: astore_1
    //   39: aload_1
    //   40: invokevirtual 53	java/io/File:exists	()Z
    //   43: ifeq +8 -> 51
    //   46: aload_1
    //   47: invokevirtual 60	java/io/File:delete	()Z
    //   50: pop
    //   51: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   54: invokevirtual 53	java/io/File:exists	()Z
    //   57: ifne +10 -> 67
    //   60: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   63: invokevirtual 63	java/io/File:mkdirs	()Z
    //   66: pop
    //   67: invokestatic 68	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	()Ljava/lang/String;
    //   70: astore_1
    //   71: aload_0
    //   72: getfield 31	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   75: aload_1
    //   76: invokevirtual 72	com/tencent/common/app/BaseApplicationImpl:getAppRuntime	(Ljava/lang/String;)Lmqq/app/AppRuntime;
    //   79: checkcast 74	com/tencent/mobileqq/app/QQAppInterface
    //   82: astore_1
    //   83: aload_1
    //   84: ifnull +556 -> 640
    //   87: aload_1
    //   88: bipush 73
    //   90: invokevirtual 78	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   93: checkcast 65	com/tencent/mobileqq/earlydownload/EarlyDownloadManager
    //   96: astore_1
    //   97: aload_1
    //   98: ifnull +542 -> 640
    //   101: aload_1
    //   102: ldc 80
    //   104: invokevirtual 83	com/tencent/mobileqq/earlydownload/EarlyDownloadManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/earlydownload/handler/EarlyHandler;
    //   107: checkcast 85	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler
    //   110: astore_1
    //   111: aload_2
    //   112: getfield 91	com/tencent/image/DownloadParams:url	Ljava/net/URL;
    //   115: invokevirtual 96	java/net/URL:getHost	()Ljava/lang/String;
    //   118: astore 8
    //   120: new 49	java/io/File
    //   123: dup
    //   124: new 98	java/lang/StringBuilder
    //   127: dup
    //   128: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   131: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   134: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   137: ldc 105
    //   139: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: aload 8
    //   144: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   153: astore_3
    //   154: iconst_0
    //   155: istore 6
    //   157: aload_3
    //   158: invokevirtual 53	java/io/File:exists	()Z
    //   161: ifeq +12 -> 173
    //   164: aload_3
    //   165: invokevirtual 118	java/io/File:length	()J
    //   168: lconst_0
    //   169: lcmp
    //   170: ifne +414 -> 584
    //   173: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +53 -> 229
    //   179: ldc 10
    //   181: iconst_2
    //   182: new 98	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   189: ldc 125
    //   191: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: aload_2
    //   195: getfield 128	com/tencent/image/DownloadParams:urlStr	Ljava/lang/String;
    //   198: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc 130
    //   203: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 8
    //   208: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc 132
    //   213: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: aload_3
    //   217: invokevirtual 135	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   220: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   226: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: getstatic 144	com/tencent/mobileqq/text/EmotcationConstants:b	[Ljava/lang/String;
    //   232: astore 9
    //   234: aload 9
    //   236: arraylength
    //   237: istore 7
    //   239: iconst_0
    //   240: istore 4
    //   242: iload 6
    //   244: istore 5
    //   246: iload 4
    //   248: iload 7
    //   250: if_icmpge +19 -> 269
    //   253: aload 9
    //   255: iload 4
    //   257: aaload
    //   258: aload 8
    //   260: invokevirtual 150	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   263: ifeq +387 -> 650
    //   266: iconst_1
    //   267: istore 5
    //   269: iload 5
    //   271: ifeq +281 -> 552
    //   274: new 49	java/io/File
    //   277: dup
    //   278: new 98	java/lang/StringBuilder
    //   281: dup
    //   282: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   285: getstatic 47	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_JavaIoFile	Ljava/io/File;
    //   288: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   291: ldc 105
    //   293: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload 8
    //   298: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: ldc 152
    //   303: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: invokespecial 114	java/io/File:<init>	(Ljava/lang/String;)V
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 53	java/io/File:exists	()Z
    //   317: ifeq +8 -> 325
    //   320: aload_1
    //   321: invokevirtual 60	java/io/File:delete	()Z
    //   324: pop
    //   325: aload_0
    //   326: getfield 31	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   329: invokevirtual 156	com/tencent/common/app/BaseApplicationImpl:getAssets	()Landroid/content/res/AssetManager;
    //   332: new 98	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   339: ldc 158
    //   341: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: aload 8
    //   346: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: ldc 160
    //   351: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   354: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: invokevirtual 166	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   360: astore_2
    //   361: sipush 4096
    //   364: newarray byte
    //   366: astore 8
    //   368: new 168	java/io/FileOutputStream
    //   371: dup
    //   372: aload_1
    //   373: invokespecial 171	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   376: astore 9
    //   378: aload_2
    //   379: aload 8
    //   381: invokevirtual 177	java/io/InputStream:read	([B)I
    //   384: iconst_m1
    //   385: if_icmpeq +125 -> 510
    //   388: aload 9
    //   390: aload 8
    //   392: invokevirtual 181	java/io/FileOutputStream:write	([B)V
    //   395: aload 9
    //   397: invokevirtual 184	java/io/FileOutputStream:flush	()V
    //   400: goto -22 -> 378
    //   403: astore_1
    //   404: new 186	java/util/HashMap
    //   407: dup
    //   408: invokespecial 187	java/util/HashMap:<init>	()V
    //   411: astore_2
    //   412: aload_2
    //   413: ldc 189
    //   415: ldc 24
    //   417: invokestatic 194	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   420: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   423: pop
    //   424: aload_2
    //   425: ldc 200
    //   427: aload_1
    //   428: invokestatic 205	com/tencent/mobileqq/transfile/AbstractImageDownloader:a	(Ljava/lang/Exception;)Ljava/lang/String;
    //   431: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   434: pop
    //   435: invokestatic 211	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   438: invokestatic 216	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   441: aconst_null
    //   442: ldc 16
    //   444: iconst_0
    //   445: lconst_0
    //   446: lconst_0
    //   447: aload_2
    //   448: ldc 33
    //   450: invokevirtual 219	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   453: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +12 -> 468
    //   459: ldc 10
    //   461: iconst_2
    //   462: ldc 221
    //   464: aload_1
    //   465: invokestatic 225	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: getstatic 41	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   471: areturn
    //   472: astore_1
    //   473: invokestatic 123	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   476: ifeq +169 -> 645
    //   479: ldc 10
    //   481: iconst_2
    //   482: new 98	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 99	java/lang/StringBuilder:<init>	()V
    //   489: ldc 227
    //   491: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload_1
    //   495: invokevirtual 230	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   498: invokevirtual 108	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 233	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: goto +138 -> 645
    //   510: aload 9
    //   512: invokevirtual 236	java/io/FileOutputStream:close	()V
    //   515: aload_2
    //   516: invokevirtual 237	java/io/InputStream:close	()V
    //   519: aload_1
    //   520: aload_3
    //   521: invokevirtual 241	java/io/File:renameTo	(Ljava/io/File;)Z
    //   524: pop
    //   525: invokestatic 211	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   528: invokestatic 216	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   531: aconst_null
    //   532: ldc 16
    //   534: iconst_1
    //   535: lconst_0
    //   536: lconst_0
    //   537: aconst_null
    //   538: ldc 33
    //   540: invokevirtual 219	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   543: aload_3
    //   544: invokevirtual 53	java/io/File:exists	()Z
    //   547: ifeq +49 -> 596
    //   550: aload_3
    //   551: areturn
    //   552: aload_1
    //   553: ifnull -10 -> 543
    //   556: aload_1
    //   557: aload_2
    //   558: ldc 243
    //   560: invokevirtual 247	com/tencent/image/DownloadParams:getHeader	(Ljava/lang/String;)Lorg/apache/http/Header;
    //   563: invokeinterface 252 1 0
    //   568: invokevirtual 254	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:b	(Ljava/lang/String;)V
    //   571: aload_1
    //   572: iconst_0
    //   573: invokevirtual 258	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:c	(Z)V
    //   576: aload_1
    //   577: iconst_0
    //   578: invokevirtual 260	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:d	(Z)V
    //   581: goto -38 -> 543
    //   584: aload_1
    //   585: ifnull -42 -> 543
    //   588: aload_1
    //   589: iconst_1
    //   590: invokevirtual 260	com/tencent/mobileqq/earlydownload/handler/SystemFaceHandler:d	(Z)V
    //   593: goto -50 -> 543
    //   596: new 186	java/util/HashMap
    //   599: dup
    //   600: invokespecial 187	java/util/HashMap:<init>	()V
    //   603: astore_1
    //   604: aload_1
    //   605: ldc 189
    //   607: ldc 27
    //   609: invokestatic 194	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   612: invokevirtual 198	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   615: pop
    //   616: invokestatic 211	com/tencent/qphone/base/util/BaseApplication:getContext	()Landroid/content/Context;
    //   619: invokestatic 216	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   622: aconst_null
    //   623: ldc 16
    //   625: iconst_0
    //   626: lconst_0
    //   627: lconst_0
    //   628: aload_1
    //   629: ldc 33
    //   631: invokevirtual 219	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   634: getstatic 41	com/tencent/mobileqq/transfile/EmotionDownloader:jdField_b_of_type_JavaIoFile	Ljava/io/File;
    //   637: astore_1
    //   638: aload_1
    //   639: areturn
    //   640: aconst_null
    //   641: astore_1
    //   642: goto -531 -> 111
    //   645: aconst_null
    //   646: astore_1
    //   647: goto -564 -> 83
    //   650: iload 4
    //   652: iconst_1
    //   653: iadd
    //   654: istore 4
    //   656: goto -414 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	659	0	this	EmotionDownloader
    //   0	659	1	paramOutputStream	java.io.OutputStream
    //   0	659	2	paramDownloadParams	DownloadParams
    //   0	659	3	paramURLDrawableHandler	URLDrawableHandler
    //   240	415	4	i	int
    //   244	26	5	j	int
    //   155	88	6	k	int
    //   237	14	7	m	int
    //   118	273	8	localObject1	Object
    //   232	279	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	15	403	java/lang/Exception
    //   15	51	403	java/lang/Exception
    //   51	67	403	java/lang/Exception
    //   87	97	403	java/lang/Exception
    //   101	111	403	java/lang/Exception
    //   111	154	403	java/lang/Exception
    //   157	173	403	java/lang/Exception
    //   173	229	403	java/lang/Exception
    //   229	239	403	java/lang/Exception
    //   253	266	403	java/lang/Exception
    //   274	325	403	java/lang/Exception
    //   325	378	403	java/lang/Exception
    //   378	400	403	java/lang/Exception
    //   473	507	403	java/lang/Exception
    //   510	543	403	java/lang/Exception
    //   543	550	403	java/lang/Exception
    //   556	581	403	java/lang/Exception
    //   588	593	403	java/lang/Exception
    //   596	638	403	java/lang/Exception
    //   67	83	472	java/lang/Exception
  }
  
  public boolean a()
  {
    return false;
  }
  
  public Object decodeFile(File paramFile, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    try
    {
      if (paramFile.equals(jdField_b_of_type_JavaIoFile))
      {
        paramFile = paramDownloadParams.getHeader("KEY_STATIC_DRAWABLE_ID").getValue();
        if (paramFile != null)
        {
          int i = Integer.valueOf(paramFile).intValue();
          return BitmapFactory.decodeResource(this.jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl.getResources(), i);
        }
      }
      else
      {
        if (!GifDrawable.isGifFile(paramFile)) {
          break label87;
        }
        paramFile = new NativeGifImage(paramFile, false);
        return paramFile;
      }
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e("EmotionDownloader", 2, "decode file", paramFile);
      }
      return null;
      paramFile = BitmapFactory.decodeFile(paramFile.getAbsolutePath());
      return paramFile;
    }
    catch (OutOfMemoryError paramFile)
    {
      for (;;)
      {
        label87:
        if (QLog.isColorLevel()) {
          QLog.e("EmotionDownloader", 2, "decode file", paramFile);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.EmotionDownloader
 * JD-Core Version:    0.7.0.1
 */
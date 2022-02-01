package com.tencent.device.file;

import android.content.Intent;
import android.os.Handler;
import com.tencent.device.msg.data.MessageForDevShortVideo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo.RetryInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import czt;
import tencent.im.msg.im_msg_body.RichText;

public class DevShortVideoOperator
  extends BaseShortVideoOprerator
{
  private static final String h = "DeviceShortVideoOperator";
  public int a;
  public long a;
  public String a;
  public int b;
  public long b;
  public String b;
  public int c;
  public String c;
  public String d;
  public String e;
  
  public DevShortVideoOperator() {}
  
  public DevShortVideoOperator(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void b(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    ThreadManager.b().post(new czt(this, paramShortVideoUploadInfo));
  }
  
  /* Error */
  public int a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore_3
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 4
    //   11: aconst_null
    //   12: aload_0
    //   13: getfield 49	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokestatic 54	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/content/Context;Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   19: astore_1
    //   20: aload_1
    //   21: ifnonnull +55 -> 76
    //   24: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   27: ifeq +11 -> 38
    //   30: ldc 8
    //   32: iconst_2
    //   33: ldc 62
    //   35: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   38: iconst_0
    //   39: ifeq +11 -> 50
    //   42: new 67	java/lang/NullPointerException
    //   45: dup
    //   46: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   49: athrow
    //   50: iconst_0
    //   51: ifeq +11 -> 62
    //   54: new 67	java/lang/NullPointerException
    //   57: dup
    //   58: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   61: athrow
    //   62: iconst_0
    //   63: ifeq +11 -> 74
    //   66: new 67	java/lang/NullPointerException
    //   69: dup
    //   70: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   73: athrow
    //   74: iconst_m1
    //   75: ireturn
    //   76: aload_1
    //   77: invokestatic 71	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   80: astore 8
    //   82: aload 8
    //   84: ifnonnull +56 -> 140
    //   87: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   90: ifeq +11 -> 101
    //   93: ldc 8
    //   95: iconst_2
    //   96: ldc 73
    //   98: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   101: iconst_0
    //   102: ifeq +11 -> 113
    //   105: new 67	java/lang/NullPointerException
    //   108: dup
    //   109: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   112: athrow
    //   113: iconst_0
    //   114: ifeq +11 -> 125
    //   117: new 67	java/lang/NullPointerException
    //   120: dup
    //   121: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   124: athrow
    //   125: iconst_0
    //   126: ifeq -52 -> 74
    //   129: new 67	java/lang/NullPointerException
    //   132: dup
    //   133: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   136: athrow
    //   137: astore_1
    //   138: iconst_m1
    //   139: ireturn
    //   140: aload_0
    //   141: aload 8
    //   143: invokevirtual 78	android/graphics/Bitmap:getWidth	()I
    //   146: putfield 80	com/tencent/device/file/DevShortVideoOperator:jdField_b_of_type_Int	I
    //   149: aload_0
    //   150: aload 8
    //   152: invokevirtual 83	android/graphics/Bitmap:getHeight	()I
    //   155: putfield 85	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_Int	I
    //   158: new 87	java/io/File
    //   161: dup
    //   162: aload_0
    //   163: getfield 49	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   166: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   169: astore_1
    //   170: aload_0
    //   171: aload_1
    //   172: invokevirtual 94	java/io/File:length	()J
    //   175: putfield 96	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_Long	J
    //   178: new 98	java/io/FileInputStream
    //   181: dup
    //   182: aload_1
    //   183: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   186: astore_2
    //   187: aload_0
    //   188: aload_2
    //   189: aload_0
    //   190: getfield 96	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_Long	J
    //   193: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   196: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   199: putfield 115	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   202: aload_0
    //   203: getfield 115	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   206: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifeq +72 -> 281
    //   212: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq +31 -> 246
    //   218: ldc 8
    //   220: iconst_2
    //   221: new 123	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   228: ldc 126
    //   230: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: aload_0
    //   234: getfield 115	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   237: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   243: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: aload_2
    //   247: ifnull +7 -> 254
    //   250: aload_2
    //   251: invokevirtual 137	java/io/FileInputStream:close	()V
    //   254: iconst_0
    //   255: ifeq +11 -> 266
    //   258: new 67	java/lang/NullPointerException
    //   261: dup
    //   262: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   265: athrow
    //   266: iconst_0
    //   267: ifeq -193 -> 74
    //   270: new 67	java/lang/NullPointerException
    //   273: dup
    //   274: invokespecial 68	java/lang/NullPointerException:<init>	()V
    //   277: athrow
    //   278: astore_1
    //   279: iconst_m1
    //   280: ireturn
    //   281: aload_0
    //   282: aload_0
    //   283: getfield 115	com/tencent/device/file/DevShortVideoOperator:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   286: ldc 139
    //   288: invokestatic 142	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   291: putfield 144	com/tencent/device/file/DevShortVideoOperator:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   294: new 123	java/lang/StringBuilder
    //   297: dup
    //   298: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   301: invokestatic 146	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	()Ljava/lang/String;
    //   304: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: ldc 148
    //   309: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   315: invokestatic 152	com/tencent/mobileqq/utils/FileUtils:b	(Ljava/lang/String;)V
    //   318: new 87	java/io/File
    //   321: dup
    //   322: aload_0
    //   323: getfield 144	com/tencent/device/file/DevShortVideoOperator:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   326: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   329: astore 7
    //   331: new 87	java/io/File
    //   334: dup
    //   335: aload 7
    //   337: invokevirtual 155	java/io/File:getParent	()Ljava/lang/String;
    //   340: invokespecial 90	java/io/File:<init>	(Ljava/lang/String;)V
    //   343: astore_1
    //   344: aload_1
    //   345: invokevirtual 158	java/io/File:exists	()Z
    //   348: ifeq +10 -> 358
    //   351: aload_1
    //   352: invokevirtual 161	java/io/File:isDirectory	()Z
    //   355: ifne +8 -> 363
    //   358: aload_1
    //   359: invokevirtual 164	java/io/File:mkdirs	()Z
    //   362: pop
    //   363: aload 7
    //   365: invokevirtual 158	java/io/File:exists	()Z
    //   368: ifeq +11 -> 379
    //   371: aload 7
    //   373: invokevirtual 167	java/io/File:isFile	()Z
    //   376: ifne +9 -> 385
    //   379: aload 7
    //   381: invokevirtual 170	java/io/File:createNewFile	()Z
    //   384: pop
    //   385: new 172	java/io/FileOutputStream
    //   388: dup
    //   389: aload 7
    //   391: invokespecial 173	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   394: astore_1
    //   395: aload 8
    //   397: getstatic 179	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   400: bipush 50
    //   402: aload_1
    //   403: invokevirtual 183	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   406: pop
    //   407: aload_1
    //   408: invokevirtual 186	java/io/FileOutputStream:flush	()V
    //   411: new 98	java/io/FileInputStream
    //   414: dup
    //   415: aload 7
    //   417: invokespecial 101	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   420: astore_3
    //   421: aload_0
    //   422: aload_3
    //   423: aload 7
    //   425: invokevirtual 94	java/io/File:length	()J
    //   428: invokestatic 107	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   431: invokestatic 113	com/qq/taf/jce/HexUtil:bytes2HexStr	([B)Ljava/lang/String;
    //   434: putfield 188	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   437: aload_0
    //   438: getfield 188	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   441: invokestatic 121	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   444: ifeq +66 -> 510
    //   447: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +31 -> 481
    //   453: ldc 8
    //   455: iconst_2
    //   456: new 123	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 124	java/lang/StringBuilder:<init>	()V
    //   463: ldc 190
    //   465: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload_0
    //   469: getfield 188	com/tencent/device/file/DevShortVideoOperator:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   472: invokevirtual 130	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   478: invokestatic 65	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   481: aload_2
    //   482: ifnull +7 -> 489
    //   485: aload_2
    //   486: invokevirtual 137	java/io/FileInputStream:close	()V
    //   489: aload_1
    //   490: ifnull +7 -> 497
    //   493: aload_1
    //   494: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   497: aload_3
    //   498: ifnull -424 -> 74
    //   501: aload_3
    //   502: invokevirtual 137	java/io/FileInputStream:close	()V
    //   505: iconst_m1
    //   506: ireturn
    //   507: astore_1
    //   508: iconst_m1
    //   509: ireturn
    //   510: aload_0
    //   511: getfield 193	com/tencent/device/file/DevShortVideoOperator:jdField_b_of_type_Long	J
    //   514: lconst_0
    //   515: lcmp
    //   516: ifne +14 -> 530
    //   519: aload_0
    //   520: aload_0
    //   521: getfield 49	com/tencent/device/file/DevShortVideoOperator:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   524: invokestatic 196	com/tencent/mobileqq/shortvideo/ShortVideoUtils:a	(Ljava/lang/String;)J
    //   527: putfield 193	com/tencent/device/file/DevShortVideoOperator:jdField_b_of_type_Long	J
    //   530: aload_2
    //   531: ifnull +7 -> 538
    //   534: aload_2
    //   535: invokevirtual 137	java/io/FileInputStream:close	()V
    //   538: aload_1
    //   539: ifnull +7 -> 546
    //   542: aload_1
    //   543: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   546: aload_3
    //   547: ifnull +7 -> 554
    //   550: aload_3
    //   551: invokevirtual 137	java/io/FileInputStream:close	()V
    //   554: iconst_0
    //   555: ireturn
    //   556: astore_3
    //   557: aconst_null
    //   558: astore_1
    //   559: aconst_null
    //   560: astore_2
    //   561: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +12 -> 576
    //   567: ldc 8
    //   569: iconst_2
    //   570: ldc 198
    //   572: aload_3
    //   573: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   576: aload_2
    //   577: ifnull +7 -> 584
    //   580: aload_2
    //   581: invokevirtual 137	java/io/FileInputStream:close	()V
    //   584: aload 4
    //   586: ifnull +8 -> 594
    //   589: aload 4
    //   591: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   594: aload_1
    //   595: ifnull -521 -> 74
    //   598: aload_1
    //   599: invokevirtual 137	java/io/FileInputStream:close	()V
    //   602: iconst_m1
    //   603: ireturn
    //   604: astore_1
    //   605: iconst_m1
    //   606: ireturn
    //   607: astore 4
    //   609: aconst_null
    //   610: astore_1
    //   611: aconst_null
    //   612: astore 7
    //   614: aload 5
    //   616: astore 6
    //   618: aload_1
    //   619: astore_3
    //   620: aload 7
    //   622: astore_2
    //   623: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +22 -> 648
    //   629: aload 5
    //   631: astore 6
    //   633: aload_1
    //   634: astore_3
    //   635: aload 7
    //   637: astore_2
    //   638: ldc 8
    //   640: iconst_2
    //   641: ldc 198
    //   643: aload 4
    //   645: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   648: aload 7
    //   650: ifnull +8 -> 658
    //   653: aload 7
    //   655: invokevirtual 137	java/io/FileInputStream:close	()V
    //   658: aload 5
    //   660: ifnull +8 -> 668
    //   663: aload 5
    //   665: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   668: aload_1
    //   669: ifnull -595 -> 74
    //   672: aload_1
    //   673: invokevirtual 137	java/io/FileInputStream:close	()V
    //   676: iconst_m1
    //   677: ireturn
    //   678: astore_1
    //   679: iconst_m1
    //   680: ireturn
    //   681: astore 4
    //   683: aconst_null
    //   684: astore_1
    //   685: aconst_null
    //   686: astore 7
    //   688: aload_3
    //   689: astore 5
    //   691: aload 5
    //   693: astore 6
    //   695: aload_1
    //   696: astore_3
    //   697: aload 7
    //   699: astore_2
    //   700: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +22 -> 725
    //   706: aload 5
    //   708: astore 6
    //   710: aload_1
    //   711: astore_3
    //   712: aload 7
    //   714: astore_2
    //   715: ldc 8
    //   717: iconst_2
    //   718: ldc 203
    //   720: aload 4
    //   722: invokestatic 201	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   725: aload 7
    //   727: ifnull +8 -> 735
    //   730: aload 7
    //   732: invokevirtual 137	java/io/FileInputStream:close	()V
    //   735: aload 5
    //   737: ifnull +8 -> 745
    //   740: aload 5
    //   742: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   745: aload_1
    //   746: ifnull -672 -> 74
    //   749: aload_1
    //   750: invokevirtual 137	java/io/FileInputStream:close	()V
    //   753: iconst_m1
    //   754: ireturn
    //   755: astore_1
    //   756: iconst_m1
    //   757: ireturn
    //   758: astore_1
    //   759: aconst_null
    //   760: astore_3
    //   761: aconst_null
    //   762: astore_2
    //   763: aload 6
    //   765: astore 4
    //   767: aload_2
    //   768: ifnull +7 -> 775
    //   771: aload_2
    //   772: invokevirtual 137	java/io/FileInputStream:close	()V
    //   775: aload 4
    //   777: ifnull +8 -> 785
    //   780: aload 4
    //   782: invokevirtual 191	java/io/FileOutputStream:close	()V
    //   785: aload_3
    //   786: ifnull +7 -> 793
    //   789: aload_3
    //   790: invokevirtual 137	java/io/FileInputStream:close	()V
    //   793: aload_1
    //   794: athrow
    //   795: astore_1
    //   796: goto -746 -> 50
    //   799: astore_1
    //   800: goto -738 -> 62
    //   803: astore_1
    //   804: iconst_m1
    //   805: ireturn
    //   806: astore_1
    //   807: goto -694 -> 113
    //   810: astore_1
    //   811: goto -686 -> 125
    //   814: astore_1
    //   815: goto -561 -> 254
    //   818: astore_1
    //   819: goto -553 -> 266
    //   822: astore_2
    //   823: goto -334 -> 489
    //   826: astore_1
    //   827: goto -330 -> 497
    //   830: astore_2
    //   831: goto -293 -> 538
    //   834: astore_1
    //   835: goto -289 -> 546
    //   838: astore_1
    //   839: goto -285 -> 554
    //   842: astore_2
    //   843: goto -259 -> 584
    //   846: astore_2
    //   847: goto -253 -> 594
    //   850: astore_2
    //   851: goto -193 -> 658
    //   854: astore_2
    //   855: goto -187 -> 668
    //   858: astore_2
    //   859: goto -124 -> 735
    //   862: astore_2
    //   863: goto -118 -> 745
    //   866: astore_2
    //   867: goto -92 -> 775
    //   870: astore_2
    //   871: goto -86 -> 785
    //   874: astore_2
    //   875: goto -82 -> 793
    //   878: astore_1
    //   879: aconst_null
    //   880: astore_3
    //   881: aload 6
    //   883: astore 4
    //   885: goto -118 -> 767
    //   888: astore 5
    //   890: aconst_null
    //   891: astore_3
    //   892: aload_1
    //   893: astore 4
    //   895: aload 5
    //   897: astore_1
    //   898: goto -131 -> 767
    //   901: astore 5
    //   903: aload_1
    //   904: astore 4
    //   906: aload 5
    //   908: astore_1
    //   909: goto -142 -> 767
    //   912: astore 5
    //   914: aload_1
    //   915: astore_3
    //   916: aload 5
    //   918: astore_1
    //   919: goto -152 -> 767
    //   922: astore_1
    //   923: aload 6
    //   925: astore 4
    //   927: goto -160 -> 767
    //   930: astore 4
    //   932: aconst_null
    //   933: astore_1
    //   934: aload_3
    //   935: astore 5
    //   937: aload_2
    //   938: astore 7
    //   940: goto -249 -> 691
    //   943: astore 4
    //   945: aconst_null
    //   946: astore_3
    //   947: aload_1
    //   948: astore 5
    //   950: aload_3
    //   951: astore_1
    //   952: aload_2
    //   953: astore 7
    //   955: goto -264 -> 691
    //   958: astore 4
    //   960: aload_1
    //   961: astore 5
    //   963: aload_3
    //   964: astore_1
    //   965: aload_2
    //   966: astore 7
    //   968: goto -277 -> 691
    //   971: astore 4
    //   973: aconst_null
    //   974: astore_1
    //   975: aload_2
    //   976: astore 7
    //   978: goto -364 -> 614
    //   981: astore 4
    //   983: aconst_null
    //   984: astore_3
    //   985: aload_1
    //   986: astore 5
    //   988: aload_3
    //   989: astore_1
    //   990: aload_2
    //   991: astore 7
    //   993: goto -379 -> 614
    //   996: astore 4
    //   998: aload_1
    //   999: astore 5
    //   1001: aload_3
    //   1002: astore_1
    //   1003: aload_2
    //   1004: astore 7
    //   1006: goto -392 -> 614
    //   1009: astore_3
    //   1010: aconst_null
    //   1011: astore_1
    //   1012: goto -451 -> 561
    //   1015: astore_3
    //   1016: aconst_null
    //   1017: astore 5
    //   1019: aload_1
    //   1020: astore 4
    //   1022: aload 5
    //   1024: astore_1
    //   1025: goto -464 -> 561
    //   1028: astore 4
    //   1030: aload_3
    //   1031: astore 5
    //   1033: aload 4
    //   1035: astore_3
    //   1036: aload_1
    //   1037: astore 4
    //   1039: aload 5
    //   1041: astore_1
    //   1042: goto -481 -> 561
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1045	0	this	DevShortVideoOperator
    //   19	58	1	localBitmap1	android.graphics.Bitmap
    //   137	1	1	localIOException1	java.io.IOException
    //   169	14	1	localFile	java.io.File
    //   278	1	1	localIOException2	java.io.IOException
    //   343	151	1	localObject1	Object
    //   507	36	1	localIOException3	java.io.IOException
    //   558	41	1	localObject2	Object
    //   604	1	1	localIOException4	java.io.IOException
    //   610	63	1	localObject3	Object
    //   678	1	1	localIOException5	java.io.IOException
    //   684	66	1	localObject4	Object
    //   755	1	1	localIOException6	java.io.IOException
    //   758	36	1	localObject5	Object
    //   795	1	1	localIOException7	java.io.IOException
    //   799	1	1	localIOException8	java.io.IOException
    //   803	1	1	localIOException9	java.io.IOException
    //   806	1	1	localIOException10	java.io.IOException
    //   810	1	1	localIOException11	java.io.IOException
    //   814	1	1	localIOException12	java.io.IOException
    //   818	1	1	localIOException13	java.io.IOException
    //   826	1	1	localIOException14	java.io.IOException
    //   834	1	1	localIOException15	java.io.IOException
    //   838	1	1	localIOException16	java.io.IOException
    //   878	15	1	localObject6	Object
    //   897	22	1	localObject7	Object
    //   922	1	1	localObject8	Object
    //   933	109	1	localObject9	Object
    //   186	586	2	localObject10	Object
    //   822	1	2	localIOException17	java.io.IOException
    //   830	1	2	localIOException18	java.io.IOException
    //   842	1	2	localIOException19	java.io.IOException
    //   846	1	2	localIOException20	java.io.IOException
    //   850	1	2	localIOException21	java.io.IOException
    //   854	1	2	localIOException22	java.io.IOException
    //   858	1	2	localIOException23	java.io.IOException
    //   862	1	2	localIOException24	java.io.IOException
    //   866	1	2	localIOException25	java.io.IOException
    //   870	1	2	localIOException26	java.io.IOException
    //   874	130	2	localIOException27	java.io.IOException
    //   4	547	3	localFileInputStream	java.io.FileInputStream
    //   556	17	3	localIOException28	java.io.IOException
    //   619	383	3	localObject11	Object
    //   1009	1	3	localIOException29	java.io.IOException
    //   1015	16	3	localIOException30	java.io.IOException
    //   1035	1	3	localObject12	Object
    //   9	581	4	localObject13	Object
    //   607	37	4	localException1	java.lang.Exception
    //   681	40	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   765	161	4	localObject14	Object
    //   930	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   943	1	4	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   958	1	4	localOutOfMemoryError4	java.lang.OutOfMemoryError
    //   971	1	4	localException2	java.lang.Exception
    //   981	1	4	localException3	java.lang.Exception
    //   996	1	4	localException4	java.lang.Exception
    //   1020	1	4	localObject15	Object
    //   1028	6	4	localIOException31	java.io.IOException
    //   1037	1	4	localObject16	Object
    //   1	740	5	localObject17	Object
    //   888	8	5	localObject18	Object
    //   901	6	5	localObject19	Object
    //   912	5	5	localObject20	Object
    //   935	105	5	localObject21	Object
    //   6	918	6	localObject22	Object
    //   329	676	7	localObject23	Object
    //   80	316	8	localBitmap2	android.graphics.Bitmap
    // Exception table:
    //   from	to	target	type
    //   129	137	137	java/io/IOException
    //   270	278	278	java/io/IOException
    //   501	505	507	java/io/IOException
    //   11	20	556	java/io/IOException
    //   24	38	556	java/io/IOException
    //   76	82	556	java/io/IOException
    //   87	101	556	java/io/IOException
    //   140	187	556	java/io/IOException
    //   598	602	604	java/io/IOException
    //   11	20	607	java/lang/Exception
    //   24	38	607	java/lang/Exception
    //   76	82	607	java/lang/Exception
    //   87	101	607	java/lang/Exception
    //   140	187	607	java/lang/Exception
    //   672	676	678	java/io/IOException
    //   11	20	681	java/lang/OutOfMemoryError
    //   24	38	681	java/lang/OutOfMemoryError
    //   76	82	681	java/lang/OutOfMemoryError
    //   87	101	681	java/lang/OutOfMemoryError
    //   140	187	681	java/lang/OutOfMemoryError
    //   749	753	755	java/io/IOException
    //   11	20	758	finally
    //   24	38	758	finally
    //   76	82	758	finally
    //   87	101	758	finally
    //   140	187	758	finally
    //   42	50	795	java/io/IOException
    //   54	62	799	java/io/IOException
    //   66	74	803	java/io/IOException
    //   105	113	806	java/io/IOException
    //   117	125	810	java/io/IOException
    //   250	254	814	java/io/IOException
    //   258	266	818	java/io/IOException
    //   485	489	822	java/io/IOException
    //   493	497	826	java/io/IOException
    //   534	538	830	java/io/IOException
    //   542	546	834	java/io/IOException
    //   550	554	838	java/io/IOException
    //   580	584	842	java/io/IOException
    //   589	594	846	java/io/IOException
    //   653	658	850	java/io/IOException
    //   663	668	854	java/io/IOException
    //   730	735	858	java/io/IOException
    //   740	745	862	java/io/IOException
    //   771	775	866	java/io/IOException
    //   780	785	870	java/io/IOException
    //   789	793	874	java/io/IOException
    //   187	246	878	finally
    //   281	358	878	finally
    //   358	363	878	finally
    //   363	379	878	finally
    //   379	385	878	finally
    //   385	395	878	finally
    //   395	421	888	finally
    //   421	481	901	finally
    //   510	530	901	finally
    //   561	576	912	finally
    //   623	629	922	finally
    //   638	648	922	finally
    //   700	706	922	finally
    //   715	725	922	finally
    //   187	246	930	java/lang/OutOfMemoryError
    //   281	358	930	java/lang/OutOfMemoryError
    //   358	363	930	java/lang/OutOfMemoryError
    //   363	379	930	java/lang/OutOfMemoryError
    //   379	385	930	java/lang/OutOfMemoryError
    //   385	395	930	java/lang/OutOfMemoryError
    //   395	421	943	java/lang/OutOfMemoryError
    //   421	481	958	java/lang/OutOfMemoryError
    //   510	530	958	java/lang/OutOfMemoryError
    //   187	246	971	java/lang/Exception
    //   281	358	971	java/lang/Exception
    //   358	363	971	java/lang/Exception
    //   363	379	971	java/lang/Exception
    //   379	385	971	java/lang/Exception
    //   385	395	971	java/lang/Exception
    //   395	421	981	java/lang/Exception
    //   421	481	996	java/lang/Exception
    //   510	530	996	java/lang/Exception
    //   187	246	1009	java/io/IOException
    //   281	358	1009	java/io/IOException
    //   358	363	1009	java/io/IOException
    //   363	379	1009	java/io/IOException
    //   379	385	1009	java/io/IOException
    //   385	395	1009	java/io/IOException
    //   395	421	1015	java/io/IOException
    //   421	481	1028	java/io/IOException
    //   510	530	1028	java/io/IOException
  }
  
  public MessageRecord a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    int i = 0;
    long l = System.currentTimeMillis();
    MessageForDevShortVideo localMessageForDevShortVideo = (MessageForDevShortVideo)MessageRecordFactory.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramShortVideoUploadInfo.jdField_c_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_d_of_type_JavaLangString, paramShortVideoUploadInfo.jdField_b_of_type_Int);
    localMessageForDevShortVideo.videoFileName = paramShortVideoUploadInfo.jdField_g_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.uuid = paramShortVideoUploadInfo.jdField_a_of_type_JavaLangString;
    if (paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString == null) {
      paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString = "";
    }
    localMessageForDevShortVideo.md5 = paramShortVideoUploadInfo.jdField_e_of_type_JavaLangString;
    localMessageForDevShortVideo.videoFileFormat = 2;
    localMessageForDevShortVideo.videoFileSize = paramShortVideoUploadInfo.jdField_e_of_type_Int;
    localMessageForDevShortVideo.videoFileTime = paramShortVideoUploadInfo.jdField_f_of_type_Int;
    localMessageForDevShortVideo.thumbWidth = paramShortVideoUploadInfo.jdField_c_of_type_Int;
    localMessageForDevShortVideo.thumbHeight = paramShortVideoUploadInfo.jdField_d_of_type_Int;
    localMessageForDevShortVideo.videoFileStatus = 1002;
    localMessageForDevShortVideo.videoFileProgress = 0;
    localMessageForDevShortVideo.fileType = 19;
    localMessageForDevShortVideo.thumbMD5 = paramShortVideoUploadInfo.jdField_f_of_type_JavaLangString;
    localMessageForDevShortVideo.extraflag = 32772;
    if (paramShortVideoUploadInfo.i == null) {
      paramShortVideoUploadInfo.i = "";
    }
    localMessageForDevShortVideo.fileSource = paramShortVideoUploadInfo.i;
    localMessageForDevShortVideo.lastModified = 0L;
    if (paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo != null) {
      i = 1;
    }
    if (i != 0)
    {
      localMessageForDevShortVideo.msgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_a_of_type_Long;
      localMessageForDevShortVideo.shmsgseq = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.jdField_b_of_type_Long;
      localMessageForDevShortVideo.msgUid = paramShortVideoUploadInfo.jdField_a_of_type_ComTencentMobileqqShortvideoShortVideoUploadInfo$RetryInfo.c;
    }
    localMessageForDevShortVideo.msg = localMessageForDevShortVideo.getSummary();
    localMessageForDevShortVideo.serial();
    paramShortVideoUploadInfo.jdField_a_of_type_Long = localMessageForDevShortVideo.uniseq;
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packmsg", "cost:" + (System.currentTimeMillis() - l));
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "packMsg", "mr: " + localMessageForDevShortVideo.toLogString() + "-" + localMessageForDevShortVideo.toString());
    return localMessageForDevShortVideo;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "attachRichText2Msg", "");
    if ((this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord instanceof ChatMessage)) {
      ((ChatMessage)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord).richText = paramRichText;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public ShortVideoDownloadInfo a(Object paramObject)
  {
    return null;
  }
  
  public ShortVideoUploadInfo a(Object paramObject, ShortVideoReq paramShortVideoReq)
  {
    if (paramObject == null)
    {
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "unknow obj");
      return null;
    }
    Object localObject;
    if ((paramObject instanceof Intent))
    {
      localObject = (Intent)paramObject;
      this.jdField_b_of_type_JavaLangString = ((Intent)localObject).getStringExtra("uin");
      this.jdField_a_of_type_Int = ((Intent)localObject).getIntExtra("uintype", 1003);
      this.jdField_a_of_type_JavaLangString = ((Intent)localObject).getStringExtra("file_send_path");
    }
    for (;;)
    {
      a();
      localObject = new ShortVideoUploadInfo();
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).jdField_g_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).h = this.jdField_d_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).jdField_b_of_type_Int = this.jdField_a_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_JavaLangString = "";
      ((ShortVideoUploadInfo)localObject).jdField_e_of_type_Int = ((int)this.jdField_a_of_type_Long);
      ((ShortVideoUploadInfo)localObject).jdField_f_of_type_Int = ((int)this.jdField_b_of_type_Long / 1000);
      ((ShortVideoUploadInfo)localObject).jdField_e_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).jdField_c_of_type_Int = this.jdField_b_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_d_of_type_Int = this.jdField_c_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_g_of_type_Int = paramShortVideoReq.jdField_d_of_type_Int;
      ((ShortVideoUploadInfo)localObject).jdField_a_of_type_JavaLangObject = paramObject;
      ((ShortVideoUploadInfo)localObject).jdField_f_of_type_JavaLangString = this.jdField_e_of_type_JavaLangString;
      ((ShortVideoUploadInfo)localObject).i = "";
      Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "createShortVideoUploadInfo", "");
      return localObject;
      if ((paramObject instanceof MessageForShortVideo))
      {
        localObject = (MessageForShortVideo)paramObject;
        this.jdField_b_of_type_JavaLangString = ((MessageForShortVideo)localObject).frienduin;
        this.jdField_a_of_type_Int = ((MessageForShortVideo)localObject).istroop;
        this.jdField_a_of_type_Long = ((MessageForShortVideo)localObject).videoFileSize;
        this.jdField_b_of_type_Long = (((MessageForShortVideo)localObject).videoFileTime * 1000);
        this.jdField_a_of_type_JavaLangString = ((MessageForShortVideo)localObject).videoFileName;
        this.jdField_d_of_type_JavaLangString = ShortVideoUtils.a(((MessageForShortVideo)localObject).md5, "jpg");
        this.jdField_c_of_type_JavaLangString = ((MessageForShortVideo)localObject).md5;
        this.jdField_b_of_type_Int = ((MessageForShortVideo)localObject).thumbWidth;
        this.jdField_c_of_type_Int = ((MessageForShortVideo)localObject).thumbHeight;
        this.jdField_e_of_type_JavaLangString = ((MessageForShortVideo)localObject).thumbMD5;
      }
    }
  }
  
  public void a(UpCallBack.SendResult paramSendResult)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "updateMsg", "resut:" + paramSendResult);
    if (paramSendResult != null)
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)paramSendResult.jdField_a_of_type_Long);
      localMessageForShortVideo.uuid = paramSendResult.jdField_c_of_type_JavaLangString;
      localMessageForShortVideo.md5 = paramSendResult.jdField_d_of_type_JavaLangString;
      localMessageForShortVideo.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
  
  public void a(ShortVideoUploadInfo paramShortVideoUploadInfo)
  {
    Logger.a(this.jdField_g_of_type_JavaLangString, this.jdField_f_of_type_JavaLangString, "sendPic.start", "");
    b(paramShortVideoUploadInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.device.file.DevShortVideoOperator
 * JD-Core Version:    0.7.0.1
 */
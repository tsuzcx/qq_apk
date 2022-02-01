package com.tencent.mobileqq.troop.data;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.concurrent.atomic.AtomicBoolean;

public class VideoUploadTask
  implements Runnable
{
  private static String jdField_a_of_type_JavaLangString = null;
  private static String b = null;
  private long jdField_a_of_type_Long = -1L;
  private TroopBarShortVideoUploadUtil.OnUploadVideoListener jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener;
  public TroopBarUploadItemEntity a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(true);
  private String c;
  private String d;
  
  public VideoUploadTask(String paramString1, String paramString2, TroopBarUploadItemEntity paramTroopBarUploadItemEntity, TroopBarShortVideoUploadUtil.OnUploadVideoListener paramOnUploadVideoListener)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity = paramTroopBarUploadItemEntity;
    this.jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener = paramOnUploadVideoListener;
    if (jdField_a_of_type_JavaLangString == null) {
      jdField_a_of_type_JavaLangString = BaseApplicationImpl.getContext().getString(2131364122);
    }
    if (b == null) {
      b = BaseApplicationImpl.getContext().getString(2131364123);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   3: lstore 11
    //   5: aload_0
    //   6: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   9: iconst_0
    //   10: invokevirtual 62	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   13: aload_0
    //   14: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   17: ifnonnull +26 -> 43
    //   20: aload_0
    //   21: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   24: iconst_1
    //   25: invokevirtual 62	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   28: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +11 -> 42
    //   34: ldc 84
    //   36: iconst_2
    //   37: ldc 86
    //   39: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   42: return
    //   43: aload_0
    //   44: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   47: ifnull +23 -> 70
    //   50: aload_0
    //   51: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:c	Ljava/lang/String;
    //   54: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   57: ifne +13 -> 70
    //   60: aload_0
    //   61: getfield 41	com/tencent/mobileqq/troop/data/VideoUploadTask:d	Ljava/lang/String;
    //   64: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   67: ifeq +96 -> 163
    //   70: aload_0
    //   71: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   74: iconst_1
    //   75: invokevirtual 62	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   78: aload_0
    //   79: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   82: ldc2_w 34
    //   85: invokeinterface 100 3 0
    //   90: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   93: ifeq -51 -> 42
    //   96: aload_0
    //   97: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   100: ifnonnull +39 -> 139
    //   103: ldc 102
    //   105: astore 13
    //   107: ldc 84
    //   109: iconst_2
    //   110: new 104	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   117: ldc 107
    //   119: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload 13
    //   124: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   127: ldc 113
    //   129: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   135: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   138: return
    //   139: aload_0
    //   140: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:c	Ljava/lang/String;
    //   143: invokestatic 95	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   146: ifeq +10 -> 156
    //   149: ldc 119
    //   151: astore 13
    //   153: goto -46 -> 107
    //   156: ldc 121
    //   158: astore 13
    //   160: goto -53 -> 107
    //   163: aload_0
    //   164: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   167: getfield 126	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:mVideoPath	Ljava/lang/String;
    //   170: astore 14
    //   172: new 128	android/os/Bundle
    //   175: dup
    //   176: invokespecial 129	android/os/Bundle:<init>	()V
    //   179: astore 13
    //   181: aload 13
    //   183: ldc 131
    //   185: getstatic 19	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   188: invokevirtual 135	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload 13
    //   193: ldc 137
    //   195: aload 14
    //   197: invokevirtual 135	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   200: aload 13
    //   202: ldc 139
    //   204: getstatic 21	com/tencent/mobileqq/troop/data/VideoUploadTask:b	Ljava/lang/String;
    //   207: invokevirtual 135	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   210: aload 13
    //   212: ldc 141
    //   214: aload_0
    //   215: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   218: getfield 144	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:mTitle	Ljava/lang/String;
    //   221: invokevirtual 135	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   224: aload 13
    //   226: ldc 146
    //   228: aload_0
    //   229: getfield 43	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarUploadItemEntity	Lcom/tencent/mobileqq/troop/data/TroopBarUploadItemEntity;
    //   232: getfield 149	com/tencent/mobileqq/troop/data/TroopBarUploadItemEntity:mVid	Ljava/lang/String;
    //   235: invokevirtual 135	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   238: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   241: invokestatic 154	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   244: ifeq +759 -> 1003
    //   247: aload_0
    //   248: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   251: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   254: ifne +749 -> 1003
    //   257: aload 13
    //   259: aload_0
    //   260: getfield 39	com/tencent/mobileqq/troop/data/VideoUploadTask:c	Ljava/lang/String;
    //   263: aload_0
    //   264: getfield 41	com/tencent/mobileqq/troop/data/VideoUploadTask:d	Ljava/lang/String;
    //   267: invokestatic 159	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	(Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp;
    //   270: astore 13
    //   272: aload 13
    //   274: ifnull +711 -> 985
    //   277: ldc 161
    //   279: aload 13
    //   281: getfield 166	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:h	Ljava/lang/String;
    //   284: invokevirtual 172	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   287: ifeq +67 -> 354
    //   290: iconst_1
    //   291: istore_1
    //   292: aload_0
    //   293: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   296: iconst_0
    //   297: iconst_1
    //   298: invokevirtual 176	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   301: ifeq +610 -> 911
    //   304: iload_1
    //   305: ifeq +556 -> 861
    //   308: aload_0
    //   309: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   312: invokeinterface 178 1 0
    //   317: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq -278 -> 42
    //   323: ldc 84
    //   325: iconst_2
    //   326: new 104	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   333: ldc 180
    //   335: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   341: lload 11
    //   343: lsub
    //   344: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   347: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   350: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   353: return
    //   354: aload 13
    //   356: getfield 186	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:f	Ljava/lang/String;
    //   359: ifnull +626 -> 985
    //   362: aload 13
    //   364: getfield 187	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:c	Ljava/lang/String;
    //   367: invokestatic 192	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)[B
    //   370: astore 15
    //   372: aload 14
    //   374: invokestatic 195	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Ljava/lang/String;)[B
    //   377: astore 16
    //   379: aload 14
    //   381: invokestatic 200	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)J
    //   384: lstore 5
    //   386: lload 5
    //   388: ldc2_w 201
    //   391: lcmp
    //   392: ifle +248 -> 640
    //   395: ldc2_w 201
    //   398: lstore_3
    //   399: new 104	java/lang/StringBuilder
    //   402: dup
    //   403: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   406: ldc 204
    //   408: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: aload 13
    //   413: getfield 205	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   416: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: ldc 207
    //   421: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: aload 13
    //   426: getfield 208	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$ApplyUploadRsp:b	Ljava/lang/String;
    //   429: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: ldc 210
    //   434: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: astore 17
    //   442: aload_0
    //   443: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   446: invokeinterface 212 1 0
    //   451: new 214	java/io/RandomAccessFile
    //   454: dup
    //   455: aload 14
    //   457: ldc 216
    //   459: invokespecial 218	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   462: astore 14
    //   464: lconst_0
    //   465: lstore 9
    //   467: lload_3
    //   468: lstore 7
    //   470: lload 9
    //   472: lstore_3
    //   473: lload 7
    //   475: lload_3
    //   476: lsub
    //   477: l2i
    //   478: istore_1
    //   479: aload 14
    //   481: astore 13
    //   483: invokestatic 51	com/tencent/common/app/BaseApplicationImpl:getContext	()Landroid/content/Context;
    //   486: invokestatic 154	com/tencent/biz/common/util/HttpUtil:a	(Landroid/content/Context;)Z
    //   489: ifeq +256 -> 745
    //   492: aload 14
    //   494: astore 13
    //   496: aload_0
    //   497: getfield 33	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   500: invokevirtual 66	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   503: ifne +242 -> 745
    //   506: aload 14
    //   508: astore 13
    //   510: aload 15
    //   512: aload 16
    //   514: aload 17
    //   516: lload 5
    //   518: aload 14
    //   520: lload_3
    //   521: iload_1
    //   522: invokestatic 221	com/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil:a	([B[BLjava/lang/String;JLjava/io/RandomAccessFile;JI)J
    //   525: lstore 7
    //   527: aload 14
    //   529: astore 13
    //   531: aload_0
    //   532: lload 7
    //   534: putfield 37	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   537: lload 7
    //   539: ldc2_w 34
    //   542: lcmp
    //   543: ifeq +103 -> 646
    //   546: aload 14
    //   548: astore 13
    //   550: aload_0
    //   551: invokevirtual 223	com/tencent/mobileqq/troop/data/VideoUploadTask:a	()Z
    //   554: ifne +18 -> 572
    //   557: aload 14
    //   559: astore 13
    //   561: aload_0
    //   562: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   565: lload 7
    //   567: invokeinterface 225 3 0
    //   572: ldc2_w 201
    //   575: lload 7
    //   577: ladd
    //   578: lload 5
    //   580: lcmp
    //   581: ifle +154 -> 735
    //   584: lload 5
    //   586: lstore_3
    //   587: lload 7
    //   589: lload 5
    //   591: lcmp
    //   592: iflt +398 -> 990
    //   595: iconst_1
    //   596: istore_2
    //   597: iload_2
    //   598: istore_1
    //   599: aload 14
    //   601: ifnull -309 -> 292
    //   604: aload 14
    //   606: invokevirtual 228	java/io/RandomAccessFile:close	()V
    //   609: iload_2
    //   610: istore_1
    //   611: goto -319 -> 292
    //   614: astore 13
    //   616: iload_2
    //   617: istore_1
    //   618: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq -329 -> 292
    //   624: ldc 84
    //   626: iconst_2
    //   627: aload 13
    //   629: invokestatic 232	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   632: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: iload_2
    //   636: istore_1
    //   637: goto -345 -> 292
    //   640: lload 5
    //   642: lstore_3
    //   643: goto -244 -> 399
    //   646: aload 14
    //   648: astore 13
    //   650: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   653: ifeq -58 -> 595
    //   656: aload 14
    //   658: astore 13
    //   660: ldc 84
    //   662: iconst_2
    //   663: new 104	java/lang/StringBuilder
    //   666: dup
    //   667: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   670: ldc 234
    //   672: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   678: lload 11
    //   680: lsub
    //   681: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   684: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: goto -95 -> 595
    //   693: astore 15
    //   695: aload 14
    //   697: astore 13
    //   699: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq +18 -> 720
    //   705: aload 14
    //   707: astore 13
    //   709: ldc 84
    //   711: iconst_2
    //   712: aload 15
    //   714: invokestatic 232	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   717: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   720: aload 14
    //   722: ifnull +263 -> 985
    //   725: aload 14
    //   727: invokevirtual 228	java/io/RandomAccessFile:close	()V
    //   730: iconst_0
    //   731: istore_1
    //   732: goto -440 -> 292
    //   735: ldc2_w 201
    //   738: lload 7
    //   740: ladd
    //   741: lstore_3
    //   742: goto -155 -> 587
    //   745: aload 14
    //   747: astore 13
    //   749: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq -157 -> 595
    //   755: aload 14
    //   757: astore 13
    //   759: ldc 84
    //   761: iconst_2
    //   762: new 104	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   769: ldc 236
    //   771: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   777: lload 11
    //   779: lsub
    //   780: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   783: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   789: goto -194 -> 595
    //   792: astore 15
    //   794: aload 13
    //   796: astore 14
    //   798: aload 15
    //   800: astore 13
    //   802: aload 14
    //   804: ifnull +8 -> 812
    //   807: aload 14
    //   809: invokevirtual 228	java/io/RandomAccessFile:close	()V
    //   812: aload 13
    //   814: athrow
    //   815: astore 13
    //   817: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   820: ifeq +14 -> 834
    //   823: ldc 84
    //   825: iconst_2
    //   826: aload 13
    //   828: invokestatic 232	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   831: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   834: iconst_0
    //   835: istore_1
    //   836: goto -544 -> 292
    //   839: astore 14
    //   841: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   844: ifeq -32 -> 812
    //   847: ldc 84
    //   849: iconst_2
    //   850: aload 14
    //   852: invokestatic 232	com/tencent/qphone/base/util/QLog:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   855: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: goto -46 -> 812
    //   861: aload_0
    //   862: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   865: aload_0
    //   866: getfield 37	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   869: invokeinterface 100 3 0
    //   874: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   877: ifeq -835 -> 42
    //   880: ldc 84
    //   882: iconst_2
    //   883: new 104	java/lang/StringBuilder
    //   886: dup
    //   887: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   890: ldc 238
    //   892: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   898: lload 11
    //   900: lsub
    //   901: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   904: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   910: return
    //   911: invokestatic 243	com/tencent/mobileqq/troop/data/TroopBarUploadTaskManager:a	()Lcom/tencent/mobileqq/troop/data/TroopBarUploadTaskManager;
    //   914: aload_0
    //   915: invokevirtual 246	com/tencent/mobileqq/troop/data/TroopBarUploadTaskManager:a	(Lcom/tencent/mobileqq/troop/data/VideoUploadTask;)Z
    //   918: pop
    //   919: aload_0
    //   920: getfield 45	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_ComTencentMobileqqTroopDataTroopBarShortVideoUploadUtil$OnUploadVideoListener	Lcom/tencent/mobileqq/troop/data/TroopBarShortVideoUploadUtil$OnUploadVideoListener;
    //   923: aload_0
    //   924: getfield 37	com/tencent/mobileqq/troop/data/VideoUploadTask:jdField_a_of_type_Long	J
    //   927: invokeinterface 248 3 0
    //   932: invokestatic 82	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   935: ifeq -893 -> 42
    //   938: ldc 84
    //   940: iconst_2
    //   941: new 104	java/lang/StringBuilder
    //   944: dup
    //   945: invokespecial 105	java/lang/StringBuilder:<init>	()V
    //   948: ldc 250
    //   950: invokevirtual 111	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: invokestatic 77	java/lang/System:currentTimeMillis	()J
    //   956: lload 11
    //   958: lsub
    //   959: invokevirtual 183	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   962: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   965: invokestatic 89	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   968: return
    //   969: astore 13
    //   971: aconst_null
    //   972: astore 14
    //   974: goto -172 -> 802
    //   977: astore 15
    //   979: aconst_null
    //   980: astore 14
    //   982: goto -287 -> 695
    //   985: iconst_0
    //   986: istore_1
    //   987: goto -695 -> 292
    //   990: lload_3
    //   991: lstore 9
    //   993: lload 7
    //   995: lstore_3
    //   996: lload 9
    //   998: lstore 7
    //   1000: goto -527 -> 473
    //   1003: aconst_null
    //   1004: astore 13
    //   1006: goto -734 -> 272
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1009	0	this	VideoUploadTask
    //   291	696	1	i	int
    //   596	40	2	j	int
    //   398	598	3	l1	long
    //   384	257	5	l2	long
    //   468	531	7	l3	long
    //   465	532	9	l4	long
    //   3	954	11	l5	long
    //   105	455	13	localObject1	Object
    //   614	14	13	localIOException1	java.io.IOException
    //   648	165	13	localObject2	Object
    //   815	12	13	localIOException2	java.io.IOException
    //   969	1	13	localObject3	Object
    //   1004	1	13	localObject4	Object
    //   170	638	14	localObject5	Object
    //   839	12	14	localIOException3	java.io.IOException
    //   972	9	14	localObject6	Object
    //   370	141	15	arrayOfByte1	byte[]
    //   693	20	15	localException1	java.lang.Exception
    //   792	7	15	localObject7	Object
    //   977	1	15	localException2	java.lang.Exception
    //   377	136	16	arrayOfByte2	byte[]
    //   440	75	17	str	String
    // Exception table:
    //   from	to	target	type
    //   604	609	614	java/io/IOException
    //   483	492	693	java/lang/Exception
    //   496	506	693	java/lang/Exception
    //   510	527	693	java/lang/Exception
    //   531	537	693	java/lang/Exception
    //   550	557	693	java/lang/Exception
    //   561	572	693	java/lang/Exception
    //   650	656	693	java/lang/Exception
    //   660	690	693	java/lang/Exception
    //   749	755	693	java/lang/Exception
    //   759	789	693	java/lang/Exception
    //   483	492	792	finally
    //   496	506	792	finally
    //   510	527	792	finally
    //   531	537	792	finally
    //   550	557	792	finally
    //   561	572	792	finally
    //   650	656	792	finally
    //   660	690	792	finally
    //   699	705	792	finally
    //   709	720	792	finally
    //   749	755	792	finally
    //   759	789	792	finally
    //   725	730	815	java/io/IOException
    //   807	812	839	java/io/IOException
    //   442	464	969	finally
    //   442	464	977	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.VideoUploadTask
 * JD-Core Version:    0.7.0.1
 */
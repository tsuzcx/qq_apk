import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticon.EmojiListenerManager;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iex
  extends DownloadListener
{
  public iex(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    Object localObject1 = paramDownloadTask.a();
    int i = ((Bundle)localObject1).getInt(paramDownloadTask.jdField_b_of_type_JavaLangString);
    localObject1 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    long l = paramDownloadTask.h - paramDownloadTask.g;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + ((EmoticonPackage)localObject1).epId + " task:" + paramDownloadTask + " localVersion=" + ((EmoticonPackage)localObject1).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject1).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject1).updateFlag);
    }
    if (paramDownloadTask.a() != 3)
    {
      int j = EmosmUtils.checkResultCode(paramDownloadTask.z);
      if (this.a.a(i)) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, 3, -1, j);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, j, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.a((EmoticonPackage)localObject1, j);
      this.a.a((EmoticonPackage)localObject1, j, l);
      return;
    }
    ((EmoticonPackage)localObject1).updateFlag &= 0xFFFFFFFE;
    if (((EmoticonPackage)localObject1).latestVersion > ((EmoticonPackage)localObject1).localVersion) {
      ((EmoticonPackage)localObject1).localVersion = ((EmoticonPackage)localObject1).latestVersion;
    }
    ((EmoticonPackage)localObject1).hasReadUpdatePage = false;
    ((EmoticonPackage)localObject1).status = 2;
    ((EmoticonPackage)localObject1).valid = true;
    this.a.a().a((EmoticonPackage)localObject1);
    paramDownloadTask = (EmoticonManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    Object localObject2 = (ArrayList)paramDownloadTask.b();
    Object localObject3 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject3).hasNext()) {
      if (((EmoticonPackage)((Iterator)localObject3).next()).epId.equals(((EmoticonPackage)localObject1).epId))
      {
        ((ArrayList)localObject2).remove(localObject1);
        ((ArrayList)localObject2).add(0, localObject1);
      }
    }
    paramDownloadTask.d();
    localObject3 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject3).add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
    }
    paramDownloadTask.b((List)localObject3);
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d((EmoticonPackage)localObject1);
    this.a.a((EmoticonPackage)localObject1, 0);
    this.a.a((EmoticonPackage)localObject1, 0, l);
  }
  
  /* Error */
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokevirtual 23	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: iconst_m1
    //   16: invokevirtual 210	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   19: istore_2
    //   20: aload 4
    //   22: ldc 35
    //   24: invokevirtual 39	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   27: checkcast 41	com/tencent/mobileqq/data/EmoticonPackage
    //   30: astore 7
    //   32: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +41 -> 76
    //   38: aload_0
    //   39: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   42: getfield 58	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: iconst_2
    //   46: new 60	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   53: ldc 212
    //   55: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 7
    //   60: getfield 72	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   63: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 77	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   80: getfield 122	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   83: aload 7
    //   85: aload_1
    //   86: getfield 214	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Long	J
    //   89: l2i
    //   90: aload_1
    //   91: getfield 216	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Long	J
    //   94: l2i
    //   95: invokevirtual 219	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/data/EmoticonPackage;II)V
    //   98: aload_1
    //   99: getfield 222	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload_1
    //   103: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokeinterface 228 2 0
    //   111: checkcast 230	java/io/File
    //   114: astore 8
    //   116: aload_0
    //   117: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   120: iload_2
    //   121: invokevirtual 119	com/tencent/mobileqq/emoticon/EmojiManager:a	(I)Z
    //   124: ifeq +37 -> 161
    //   127: aload_0
    //   128: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   131: getfield 122	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   134: aload 7
    //   136: iload_2
    //   137: iconst_0
    //   138: iconst_0
    //   139: invokevirtual 127	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;III)V
    //   142: iload_2
    //   143: iconst_m1
    //   144: if_icmpeq +16 -> 160
    //   147: aload_0
    //   148: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   151: ldc 232
    //   153: iload_2
    //   154: invokestatic 236	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   157: invokevirtual 238	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: return
    //   161: iload_2
    //   162: bipush 6
    //   164: if_icmpne +26 -> 190
    //   167: iconst_2
    //   168: aload 7
    //   170: getfield 72	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   173: invokestatic 242	com/tencent/mobileqq/emosm/EmosmUtils:getCoverPath	(ILjava/lang/String;)Ljava/lang/String;
    //   176: astore_1
    //   177: aload 8
    //   179: invokevirtual 245	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   182: aload_1
    //   183: invokestatic 251	com/tencent/mobileqq/utils/FileUtils:c	(Ljava/lang/String;Ljava/lang/String;)Z
    //   186: pop
    //   187: goto -45 -> 142
    //   190: iload_2
    //   191: bipush 7
    //   193: if_icmpne -51 -> 142
    //   196: aload_0
    //   197: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   200: getfield 252	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   203: aload_1
    //   204: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   207: invokeinterface 255 2 0
    //   212: ifeq +462 -> 674
    //   215: aload_0
    //   216: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   219: getfield 252	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   222: astore 5
    //   224: aload 5
    //   226: monitorenter
    //   227: aload_0
    //   228: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   231: getfield 252	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   234: aload_1
    //   235: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   238: invokeinterface 228 2 0
    //   243: checkcast 183	java/lang/String
    //   246: astore 4
    //   248: aload_0
    //   249: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   252: getfield 252	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   255: aload_1
    //   256: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   259: invokeinterface 257 2 0
    //   264: pop
    //   265: aload 5
    //   267: monitorexit
    //   268: aload 8
    //   270: ifnull +398 -> 668
    //   273: aload 8
    //   275: invokestatic 260	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   278: astore 6
    //   280: aload 8
    //   282: invokevirtual 245	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   285: astore 5
    //   287: aload 8
    //   289: invokevirtual 263	java/io/File:delete	()Z
    //   292: pop
    //   293: goto +387 -> 680
    //   296: aload_1
    //   297: iconst_1
    //   298: putfield 265	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   301: aload_0
    //   302: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   305: getfield 122	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   308: aload 7
    //   310: sipush 11009
    //   313: aload_0
    //   314: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   317: getfield 130	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   320: invokevirtual 133	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   323: return
    //   324: astore 4
    //   326: aload 4
    //   328: invokevirtual 268	java/lang/Throwable:printStackTrace	()V
    //   331: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +63 -> 397
    //   337: aload_0
    //   338: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   341: getfield 58	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   344: iconst_2
    //   345: new 60	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   352: ldc_w 270
    //   355: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 4
    //   360: invokevirtual 271	java/lang/Throwable:toString	()Ljava/lang/String;
    //   363: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: ldc_w 273
    //   369: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   375: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   378: ldc_w 284
    //   381: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   388: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   391: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: aload_1
    //   398: iconst_1
    //   399: putfield 265	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   402: aload_0
    //   403: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   406: getfield 122	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   409: aload 7
    //   411: sipush 11020
    //   414: aload_0
    //   415: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   418: getfield 130	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   421: invokevirtual 133	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   424: goto -282 -> 142
    //   427: astore 4
    //   429: aload 5
    //   431: monitorexit
    //   432: aload 4
    //   434: athrow
    //   435: aload 6
    //   437: aload 4
    //   439: aload 5
    //   441: invokestatic 288	com/tencent/mobileqq/emosm/EmosmUtils:saveEmosm	([BLjava/lang/String;Ljava/lang/String;)I
    //   444: istore_3
    //   445: iload_3
    //   446: ifeq +157 -> 603
    //   449: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   452: ifeq +37 -> 489
    //   455: aload_0
    //   456: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   459: getfield 58	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   462: iconst_2
    //   463: new 60	java/lang/StringBuilder
    //   466: dup
    //   467: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   470: ldc_w 290
    //   473: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: aload_1
    //   477: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   480: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: invokestatic 295	com/tencent/mobileqq/util/Utils:e	()Z
    //   492: ifeq +84 -> 576
    //   495: invokestatic 297	com/tencent/mobileqq/util/Utils:b	()J
    //   498: ldc2_w 298
    //   501: lcmp
    //   502: ifle +74 -> 576
    //   505: new 60	java/lang/StringBuilder
    //   508: dup
    //   509: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   512: getstatic 304	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   515: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: ldc_w 306
    //   521: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: getstatic 309	java/io/File:separator	Ljava/lang/String;
    //   527: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: aload 7
    //   532: getfield 72	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   535: invokestatic 312	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   538: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: ldc_w 314
    //   544: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: aload 4
    //   549: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: ldc_w 314
    //   555: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: aload 8
    //   560: invokevirtual 317	java/io/File:getName	()Ljava/lang/String;
    //   563: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   569: aload 6
    //   571: iconst_0
    //   572: invokestatic 320	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   575: pop
    //   576: aload_1
    //   577: iconst_1
    //   578: putfield 265	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   581: aload_0
    //   582: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   585: getfield 122	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   588: aload 7
    //   590: sipush 11017
    //   593: aload_0
    //   594: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   597: getfield 130	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   600: invokevirtual 133	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   603: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   606: ifeq -464 -> 142
    //   609: aload_0
    //   610: getfield 10	iex:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   613: getfield 58	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   616: iconst_2
    //   617: new 60	java/lang/StringBuilder
    //   620: dup
    //   621: invokespecial 63	java/lang/StringBuilder:<init>	()V
    //   624: ldc_w 322
    //   627: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: iload_3
    //   631: invokevirtual 86	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: ldc_w 273
    //   637: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: invokestatic 279	java/lang/System:currentTimeMillis	()J
    //   643: invokevirtual 282	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   646: ldc_w 284
    //   649: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: aload_1
    //   653: getfield 27	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   656: invokevirtual 69	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   662: invokestatic 104	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   665: goto -523 -> 142
    //   668: aconst_null
    //   669: astore 5
    //   671: goto +9 -> 680
    //   674: aconst_null
    //   675: astore 4
    //   677: goto -409 -> 268
    //   680: aload 6
    //   682: ifnull -386 -> 296
    //   685: aload 4
    //   687: ifnull -391 -> 296
    //   690: aload 5
    //   692: ifnonnull -257 -> 435
    //   695: goto -399 -> 296
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	698	0	this	iex
    //   0	698	1	paramDownloadTask	DownloadTask
    //   19	175	2	i	int
    //   444	187	3	j	int
    //   7	240	4	localObject1	Object
    //   324	35	4	localThrowable	java.lang.Throwable
    //   427	121	4	str	String
    //   675	11	4	localObject2	Object
    //   1	680	6	arrayOfByte	byte[]
    //   30	559	7	localEmoticonPackage	EmoticonPackage
    //   114	445	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   196	227	324	java/lang/Throwable
    //   273	293	324	java/lang/Throwable
    //   296	323	324	java/lang/Throwable
    //   432	435	324	java/lang/Throwable
    //   435	445	324	java/lang/Throwable
    //   449	489	324	java/lang/Throwable
    //   489	576	324	java/lang/Throwable
    //   576	603	324	java/lang/Throwable
    //   603	665	324	java/lang/Throwable
    //   227	268	427	finally
    //   429	432	427	finally
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    EmoticonPackage localEmoticonPackage = (EmoticonPackage)paramDownloadTask.a().getSerializable("emoticonPackage");
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(localEmoticonPackage);
    this.a.a("param_epId", localEmoticonPackage.epId);
    super.onStart(paramDownloadTask);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     iex
 * JD-Core Version:    0.7.0.1
 */
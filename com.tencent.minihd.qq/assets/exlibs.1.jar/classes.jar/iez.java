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

public class iez
  extends DownloadListener
{
  public iez(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    Object localObject1 = paramDownloadTask.a();
    boolean bool = ((Bundle)localObject1).getBoolean("newPkgAdd", false);
    int i = ((Bundle)localObject1).getInt(paramDownloadTask.jdField_b_of_type_JavaLangString);
    localObject1 = (EmoticonPackage)((Bundle)localObject1).getSerializable("emoticonPackage");
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "onDone:epId=" + ((EmoticonPackage)localObject1).epId + " task:" + paramDownloadTask + " localVersion=" + ((EmoticonPackage)localObject1).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject1).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject1).updateFlag);
    }
    if (paramDownloadTask.a() != 3)
    {
      int j = EmosmUtils.checkResultCode(paramDownloadTask.z);
      if (this.a.a(i)) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, i, -1, j);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, j, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.a((EmoticonPackage)localObject1, j);
      this.a.a((EmoticonPackage)localObject1, j, 0L);
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
    if (bool) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.a.a((EmoticonPackage)localObject1, 0);
    this.a.a((EmoticonPackage)localObject1, 0, l1 - l2);
  }
  
  /* Error */
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_1
    //   4: invokevirtual 30	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   7: astore 4
    //   9: aload 4
    //   11: aload_1
    //   12: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   15: iconst_m1
    //   16: invokevirtual 221	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   19: istore_2
    //   20: aload 4
    //   22: ldc 48
    //   24: invokevirtual 52	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   27: checkcast 54	com/tencent/mobileqq/data/EmoticonPackage
    //   30: astore 7
    //   32: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   35: ifeq +41 -> 76
    //   38: aload_0
    //   39: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   42: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   45: iconst_2
    //   46: new 66	java/lang/StringBuilder
    //   49: dup
    //   50: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   53: ldc 223
    //   55: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload 7
    //   60: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   63: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: aload_1
    //   67: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   70: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   73: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   76: aload_0
    //   77: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   80: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   83: aload 7
    //   85: aload_1
    //   86: getfield 225	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Long	J
    //   89: l2i
    //   90: aload_1
    //   91: getfield 227	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Long	J
    //   94: l2i
    //   95: invokevirtual 230	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/data/EmoticonPackage;II)V
    //   98: aload_1
    //   99: getfield 233	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   102: aload_1
    //   103: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   106: invokeinterface 239 2 0
    //   111: checkcast 241	java/io/File
    //   114: astore 8
    //   116: iload_2
    //   117: lookupswitch	default:+43->160, 2:+62->179, 7:+178->295, 10:+80->197, 16:+121->238
    //   161: iconst_m1
    //   162: if_icmpeq +16 -> 178
    //   165: aload_0
    //   166: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   169: ldc 243
    //   171: iload_2
    //   172: invokestatic 247	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   175: invokevirtual 249	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   178: return
    //   179: aload_0
    //   180: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   183: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   186: aload 7
    //   188: iconst_2
    //   189: iconst_0
    //   190: iconst_0
    //   191: invokevirtual 133	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;III)V
    //   194: goto -34 -> 160
    //   197: aload 8
    //   199: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   202: aload 7
    //   204: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   207: invokestatic 256	com/tencent/mobileqq/emosm/EmosmUtils:getEmoticonPackageFolder	(Ljava/lang/String;)Ljava/lang/String;
    //   210: iconst_0
    //   211: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   214: aload 8
    //   216: invokevirtual 264	java/io/File:delete	()Z
    //   219: pop
    //   220: goto -60 -> 160
    //   223: astore 4
    //   225: aload_1
    //   226: iconst_1
    //   227: putfield 266	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   230: aload 4
    //   232: invokevirtual 269	java/io/IOException:printStackTrace	()V
    //   235: goto -21 -> 214
    //   238: aload 8
    //   240: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   243: aload 7
    //   245: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   248: invokestatic 272	com/tencent/mobileqq/emosm/EmosmUtils:getPngFramePath	(Ljava/lang/String;)Ljava/lang/String;
    //   251: iconst_0
    //   252: invokestatic 261	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;Ljava/lang/String;Z)V
    //   255: aload_0
    //   256: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   259: invokestatic 275	com/tencent/mobileqq/emoticon/EmojiManager:a	(Lcom/tencent/mobileqq/emoticon/EmojiManager;)Lcom/tencent/mobileqq/magicface/drawable/PngFrameManager;
    //   262: aload 7
    //   264: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   267: invokevirtual 280	com/tencent/mobileqq/magicface/drawable/PngFrameManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/magicface/drawable/PngPlayParam;
    //   270: pop
    //   271: aload 8
    //   273: invokevirtual 264	java/io/File:delete	()Z
    //   276: pop
    //   277: goto -117 -> 160
    //   280: astore 4
    //   282: aload_1
    //   283: iconst_1
    //   284: putfield 266	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   287: aload 4
    //   289: invokevirtual 269	java/io/IOException:printStackTrace	()V
    //   292: goto -21 -> 271
    //   295: aload_0
    //   296: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   299: getfield 281	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   302: aload_1
    //   303: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   306: invokeinterface 284 2 0
    //   311: ifeq +435 -> 746
    //   314: aload_0
    //   315: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   318: getfield 281	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   321: astore 5
    //   323: aload 5
    //   325: monitorenter
    //   326: aload_0
    //   327: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   330: getfield 281	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   333: aload_1
    //   334: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   337: invokeinterface 239 2 0
    //   342: checkcast 189	java/lang/String
    //   345: astore 4
    //   347: aload_0
    //   348: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   351: getfield 281	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   354: aload_1
    //   355: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   358: invokeinterface 286 2 0
    //   363: pop
    //   364: aload 5
    //   366: monitorexit
    //   367: aload 8
    //   369: ifnull +371 -> 740
    //   372: aload 8
    //   374: invokestatic 289	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   377: astore 6
    //   379: aload 8
    //   381: invokevirtual 252	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   384: astore 5
    //   386: aload 8
    //   388: invokevirtual 264	java/io/File:delete	()Z
    //   391: pop
    //   392: goto +360 -> 752
    //   395: aload_1
    //   396: iconst_1
    //   397: putfield 266	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   400: aload_0
    //   401: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   404: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   407: aload 7
    //   409: sipush 11009
    //   412: aload_0
    //   413: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   416: getfield 136	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   419: invokevirtual 139	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   422: return
    //   423: astore 4
    //   425: aload 4
    //   427: invokevirtual 290	java/lang/Throwable:printStackTrace	()V
    //   430: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   433: ifeq +63 -> 496
    //   436: aload_0
    //   437: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   440: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   443: iconst_2
    //   444: new 66	java/lang/StringBuilder
    //   447: dup
    //   448: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   451: ldc_w 292
    //   454: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: aload 4
    //   459: invokevirtual 293	java/lang/Throwable:toString	()Ljava/lang/String;
    //   462: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: ldc_w 295
    //   468: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   474: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   477: ldc_w 306
    //   480: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: aload_1
    //   484: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   487: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   496: aload_1
    //   497: iconst_1
    //   498: putfield 266	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   501: aload_0
    //   502: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   505: getfield 128	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   508: aload 7
    //   510: sipush 11020
    //   513: aload_0
    //   514: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   517: getfield 136	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   520: invokevirtual 139	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   523: goto -363 -> 160
    //   526: astore 4
    //   528: aload 5
    //   530: monitorexit
    //   531: aload 4
    //   533: athrow
    //   534: aload 6
    //   536: aload 4
    //   538: aload 5
    //   540: invokestatic 310	com/tencent/mobileqq/emosm/EmosmUtils:saveEmosm	([BLjava/lang/String;Ljava/lang/String;)I
    //   543: istore_3
    //   544: iload_3
    //   545: ifeq +130 -> 675
    //   548: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq +37 -> 588
    //   554: aload_0
    //   555: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   558: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   561: iconst_2
    //   562: new 66	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 312
    //   572: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_1
    //   576: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   579: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   585: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   588: invokestatic 317	com/tencent/mobileqq/util/Utils:e	()Z
    //   591: ifeq +84 -> 675
    //   594: invokestatic 319	com/tencent/mobileqq/util/Utils:b	()J
    //   597: ldc2_w 320
    //   600: lcmp
    //   601: ifle +74 -> 675
    //   604: new 66	java/lang/StringBuilder
    //   607: dup
    //   608: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   611: getstatic 326	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   614: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 328
    //   620: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: getstatic 331	java/io/File:separator	Ljava/lang/String;
    //   626: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload 7
    //   631: getfield 78	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   634: invokestatic 334	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   637: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: ldc_w 336
    //   643: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: aload 4
    //   648: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: ldc_w 336
    //   654: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload 8
    //   659: invokevirtual 339	java/io/File:getName	()Ljava/lang/String;
    //   662: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   665: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   668: aload 6
    //   670: iconst_0
    //   671: invokestatic 342	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   674: pop
    //   675: invokestatic 60	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   678: ifeq -518 -> 160
    //   681: aload_0
    //   682: getfield 10	iez:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   685: getfield 64	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   688: iconst_2
    //   689: new 66	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 69	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 344
    //   699: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: iload_3
    //   703: invokevirtual 92	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: ldc_w 295
    //   709: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   712: invokestatic 301	java/lang/System:currentTimeMillis	()J
    //   715: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   718: ldc_w 306
    //   721: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: aload_1
    //   725: getfield 42	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   728: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   734: invokestatic 110	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   737: goto -577 -> 160
    //   740: aconst_null
    //   741: astore 5
    //   743: goto +9 -> 752
    //   746: aconst_null
    //   747: astore 4
    //   749: goto -382 -> 367
    //   752: aload 6
    //   754: ifnull -359 -> 395
    //   757: aload 4
    //   759: ifnull -364 -> 395
    //   762: aload 5
    //   764: ifnonnull -230 -> 534
    //   767: goto -372 -> 395
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	770	0	this	iez
    //   0	770	1	paramDownloadTask	DownloadTask
    //   19	153	2	i	int
    //   543	160	3	j	int
    //   7	14	4	localBundle	Bundle
    //   223	8	4	localIOException1	java.io.IOException
    //   280	8	4	localIOException2	java.io.IOException
    //   345	1	4	str1	String
    //   423	35	4	localThrowable	java.lang.Throwable
    //   526	121	4	str2	String
    //   747	11	4	localObject1	Object
    //   1	752	6	arrayOfByte	byte[]
    //   30	600	7	localEmoticonPackage	EmoticonPackage
    //   114	544	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   197	214	223	java/io/IOException
    //   238	271	280	java/io/IOException
    //   295	326	423	java/lang/Throwable
    //   372	392	423	java/lang/Throwable
    //   395	422	423	java/lang/Throwable
    //   531	534	423	java/lang/Throwable
    //   534	544	423	java/lang/Throwable
    //   548	588	423	java/lang/Throwable
    //   588	675	423	java/lang/Throwable
    //   675	737	423	java/lang/Throwable
    //   326	367	526	finally
    //   528	531	526	finally
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
 * Qualified Name:     iez
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
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

public class iey
  extends DownloadListener
{
  public iey(EmojiManager paramEmojiManager, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    long l1 = paramDownloadTask.h;
    long l2 = paramDownloadTask.g;
    Object localObject2 = paramDownloadTask.a();
    Object localObject1 = (EmoticonPackage)((Bundle)localObject2).getSerializable("emoticonPackage");
    int i = ((Bundle)localObject2).getInt(paramDownloadTask.jdField_b_of_type_JavaLangString);
    boolean bool1 = ((Bundle)localObject2).getBoolean("newPkgAdd", false);
    boolean bool2 = ((Bundle)localObject2).getBoolean("isUpdate", false);
    if (paramDownloadTask.a() != 3)
    {
      int j = EmosmUtils.checkResultCode(paramDownloadTask.z);
      if (this.a.a(i)) {
        this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, i, -1, j);
      }
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, j, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.a((EmoticonPackage)localObject1, j);
      this.a.a((EmoticonPackage)localObject1, j, 0L);
    }
    do
    {
      do
      {
        return;
        if (!bool2) {
          break;
        }
        localObject2 = (ArrayList)((Bundle)localObject2).getSerializable("emoticonList");
      } while (localObject2 == null);
      paramDownloadTask = (ArrayList)this.a.a().a(((EmoticonPackage)localObject1).epId);
    } while (paramDownloadTask == null);
    i = ((ArrayList)localObject2).size() - 1;
    while (i >= 0)
    {
      paramDownloadTask.add(0, ((ArrayList)localObject2).get(i));
      i -= 1;
    }
    this.a.a().c(((EmoticonPackage)localObject1).epId);
    localObject1 = paramDownloadTask.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((Emoticon)((Iterator)localObject1).next()).setStatus(1000);
    }
    this.a.a().c(paramDownloadTask);
    return;
    if (QLog.isColorLevel()) {
      QLog.d(this.a.jdField_a_of_type_JavaLangString, 2, "localVersion=" + ((EmoticonPackage)localObject1).localVersion + ",latestVersion=" + ((EmoticonPackage)localObject1).latestVersion + ",updateFlag=" + ((EmoticonPackage)localObject1).updateFlag);
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
    localObject2 = (ArrayList)paramDownloadTask.b();
    Object localObject3 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject3).next();
      if (localEmoticonPackage.epId.equals(((EmoticonPackage)localObject1).epId))
      {
        ((ArrayList)localObject2).remove(localEmoticonPackage);
        ((ArrayList)localObject2).add(0, localEmoticonPackage);
      }
    }
    paramDownloadTask.d();
    localObject3 = new ArrayList();
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((ArrayList)localObject3).add(((EmoticonPackage)((Iterator)localObject2).next()).epId);
    }
    paramDownloadTask.b((List)localObject3);
    if (bool1) {
      this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a((EmoticonPackage)localObject1, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.d((EmoticonPackage)localObject1);
    this.a.a((EmoticonPackage)localObject1, 0);
    this.a.a((EmoticonPackage)localObject1, 0, l1 - l2);
  }
  
  /* Error */
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: invokevirtual 30	com/tencent/mobileqq/vip/DownloadTask:a	()Landroid/os/Bundle;
    //   7: astore_3
    //   8: aload_3
    //   9: aload_1
    //   10: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   13: invokevirtual 48	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   16: istore_2
    //   17: aload_3
    //   18: ldc 32
    //   20: invokevirtual 38	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   23: checkcast 40	com/tencent/mobileqq/data/EmoticonPackage
    //   26: astore 6
    //   28: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   31: ifeq +46 -> 77
    //   34: aload_0
    //   35: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   38: getfield 154	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   41: iconst_2
    //   42: new 156	java/lang/StringBuilder
    //   45: dup
    //   46: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   49: ldc 237
    //   51: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload 6
    //   56: getfield 104	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   59: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: ldc 239
    //   64: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: aload_1
    //   68: invokevirtual 242	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_0
    //   78: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   81: getfield 77	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   84: aload 6
    //   86: aload_1
    //   87: getfield 244	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Long	J
    //   90: l2i
    //   91: aload_1
    //   92: getfield 246	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_Long	J
    //   95: l2i
    //   96: invokevirtual 249	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/data/EmoticonPackage;II)V
    //   99: aload_1
    //   100: getfield 252	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   103: aload_1
    //   104: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   107: invokeinterface 257 2 0
    //   112: checkcast 259	java/io/File
    //   115: astore 7
    //   117: aload_0
    //   118: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   121: iload_2
    //   122: invokevirtual 74	com/tencent/mobileqq/emoticon/EmojiManager:a	(I)Z
    //   125: ifeq +19 -> 144
    //   128: aload_0
    //   129: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   132: getfield 77	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   135: aload 6
    //   137: iload_2
    //   138: iconst_0
    //   139: iconst_0
    //   140: invokevirtual 82	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;III)V
    //   143: return
    //   144: iload_2
    //   145: bipush 7
    //   147: if_icmpne -4 -> 143
    //   150: aload_0
    //   151: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   154: getfield 260	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   157: aload_1
    //   158: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   161: invokeinterface 263 2 0
    //   166: ifeq +484 -> 650
    //   169: aload_0
    //   170: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   173: getfield 260	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   176: astore 4
    //   178: aload 4
    //   180: monitorenter
    //   181: aload_0
    //   182: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   185: getfield 260	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   188: aload_1
    //   189: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   192: invokeinterface 257 2 0
    //   197: checkcast 213	java/lang/String
    //   200: astore_3
    //   201: aload_0
    //   202: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   205: getfield 260	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   208: aload_1
    //   209: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   212: invokeinterface 265 2 0
    //   217: pop
    //   218: aload 4
    //   220: monitorexit
    //   221: aload 7
    //   223: ifnull +421 -> 644
    //   226: aload 7
    //   228: invokestatic 270	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)[B
    //   231: astore 5
    //   233: aload 7
    //   235: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   238: astore 4
    //   240: aload 7
    //   242: invokevirtual 276	java/io/File:delete	()Z
    //   245: pop
    //   246: goto +409 -> 655
    //   249: aload_1
    //   250: iconst_1
    //   251: putfield 278	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   254: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   257: ifeq +58 -> 315
    //   260: aload_0
    //   261: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   264: getfield 154	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   267: iconst_2
    //   268: new 156	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   275: ldc 237
    //   277: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload 6
    //   282: getfield 104	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   285: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: ldc_w 280
    //   291: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: aload_3
    //   295: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: ldc_w 282
    //   301: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   304: aload 4
    //   306: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   312: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   315: aload_0
    //   316: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   319: getfield 77	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   322: aload 6
    //   324: sipush 11009
    //   327: aload_0
    //   328: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   331: getfield 85	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: invokevirtual 88	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   337: return
    //   338: astore_3
    //   339: aload_3
    //   340: invokevirtual 285	java/lang/Throwable:printStackTrace	()V
    //   343: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   346: ifeq +62 -> 408
    //   349: aload_0
    //   350: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   353: getfield 154	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   356: iconst_2
    //   357: new 156	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 287
    //   367: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: aload_3
    //   371: invokevirtual 288	java/lang/Throwable:toString	()Ljava/lang/String;
    //   374: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: ldc_w 290
    //   380: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   386: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: ldc_w 301
    //   392: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_1
    //   396: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   399: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: aload_1
    //   409: iconst_1
    //   410: putfield 278	com/tencent/mobileqq/vip/DownloadTask:jdField_a_of_type_Boolean	Z
    //   413: aload_0
    //   414: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   417: getfield 77	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   420: aload 6
    //   422: sipush 11020
    //   425: aload_0
    //   426: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   429: getfield 85	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: invokevirtual 88	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/data/EmoticonPackage;ILcom/tencent/mobileqq/app/QQAppInterface;)V
    //   435: return
    //   436: astore_3
    //   437: aload 4
    //   439: monitorexit
    //   440: aload_3
    //   441: athrow
    //   442: aload 5
    //   444: aload_3
    //   445: aload 4
    //   447: invokestatic 305	com/tencent/mobileqq/emosm/EmosmUtils:saveEmosm	([BLjava/lang/String;Ljava/lang/String;)I
    //   450: istore_2
    //   451: iload_2
    //   452: ifeq +129 -> 581
    //   455: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +37 -> 495
    //   461: aload_0
    //   462: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   465: getfield 154	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   468: iconst_2
    //   469: new 156	java/lang/StringBuilder
    //   472: dup
    //   473: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   476: ldc_w 307
    //   479: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: aload_1
    //   483: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   486: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   495: invokestatic 312	com/tencent/mobileqq/util/Utils:e	()Z
    //   498: ifeq +83 -> 581
    //   501: invokestatic 314	com/tencent/mobileqq/util/Utils:b	()J
    //   504: ldc2_w 315
    //   507: lcmp
    //   508: ifle +73 -> 581
    //   511: new 156	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   518: getstatic 321	com/tencent/mobileqq/app/AppConstants:aG	Ljava/lang/String;
    //   521: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: ldc_w 323
    //   527: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: getstatic 326	java/io/File:separator	Ljava/lang/String;
    //   533: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: aload 6
    //   538: getfield 104	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   541: invokestatic 330	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   544: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   547: ldc_w 332
    //   550: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   553: aload_3
    //   554: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: ldc_w 332
    //   560: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload 7
    //   565: invokevirtual 335	java/io/File:getName	()Ljava/lang/String;
    //   568: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: aload 5
    //   576: iconst_0
    //   577: invokestatic 338	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;[BZ)Z
    //   580: pop
    //   581: invokestatic 152	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq -441 -> 143
    //   587: aload_0
    //   588: getfield 10	iey:a	Lcom/tencent/mobileqq/emoticon/EmojiManager;
    //   591: getfield 154	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   594: iconst_2
    //   595: new 156	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 340
    //   605: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: iload_2
    //   609: invokevirtual 171	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   612: ldc_w 290
    //   615: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   618: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   621: invokevirtual 299	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   624: ldc_w 301
    //   627: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   630: aload_1
    //   631: getfield 44	com/tencent/mobileqq/vip/DownloadTask:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   634: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: invokevirtual 185	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   640: invokestatic 189	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   643: return
    //   644: aconst_null
    //   645: astore 4
    //   647: goto +8 -> 655
    //   650: aconst_null
    //   651: astore_3
    //   652: goto -431 -> 221
    //   655: aload 5
    //   657: ifnull -408 -> 249
    //   660: aload_3
    //   661: ifnull -412 -> 249
    //   664: aload 4
    //   666: ifnonnull -224 -> 442
    //   669: goto -420 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	672	0	this	iey
    //   0	672	1	paramDownloadTask	DownloadTask
    //   16	593	2	i	int
    //   7	288	3	localObject1	Object
    //   338	33	3	localThrowable	java.lang.Throwable
    //   436	118	3	str	String
    //   651	10	3	localObject2	Object
    //   1	655	5	arrayOfByte	byte[]
    //   26	511	6	localEmoticonPackage	EmoticonPackage
    //   115	449	7	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   150	181	338	java/lang/Throwable
    //   226	246	338	java/lang/Throwable
    //   249	315	338	java/lang/Throwable
    //   315	337	338	java/lang/Throwable
    //   440	442	338	java/lang/Throwable
    //   442	451	338	java/lang/Throwable
    //   455	495	338	java/lang/Throwable
    //   495	581	338	java/lang/Throwable
    //   581	643	338	java/lang/Throwable
    //   181	221	436	finally
    //   437	440	436	finally
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
 * Qualified Name:     iey
 * JD-Core Version:    0.7.0.1
 */
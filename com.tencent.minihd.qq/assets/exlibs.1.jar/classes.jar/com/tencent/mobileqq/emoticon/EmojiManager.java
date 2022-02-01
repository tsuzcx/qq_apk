package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.EmosmHandler.EmosmHandlerListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.magicface.drawable.PngFrameManager;
import com.tencent.mobileqq.magicface.drawable.PngPlayParam;
import com.tencent.mobileqq.magicface.model.MagicfaceResLoader;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ieu;
import iev;
import iew;
import iex;
import iey;
import iez;
import ifa;
import ifb;
import ifc;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiManager
  implements Manager
{
  public static final int a = 3;
  public static long a = 0L;
  public static final boolean a = false;
  public static final int b = 30000;
  public static long b = 0L;
  public static final String b = "LAST_ADD_EMO_PACKAGE";
  public static int c = 0;
  public static final long c = 35000L;
  public static final String c = "LAST_ADD_EMO_PACKAGE_MAGIC";
  public static int d = 0;
  public static final String d = "emoticonPackage";
  private static int e = 0;
  public static final String e = "vipEmoticonKey_";
  private static int jdField_f_of_type_Int = 0;
  public static final String f = "newPkgAdd";
  private static int g = 0;
  public static final String g = "isUpdate";
  public static final String h = "jsonType";
  public QQAppInterface a;
  public EmojiListenerManager a;
  private PngFrameManager jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = null;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new iev(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  public String a;
  public ArrayList a;
  public HashMap a;
  public Map a;
  public DownloadListener b;
  private Map b;
  public DownloadListener c;
  public DownloadListener d;
  public DownloadListener e;
  private DownloadListener jdField_f_of_type_ComTencentMobileqqVipDownloadListener = new ieu(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  private int h = 3000000;
  private int i = 0;
  
  static
  {
    jdField_e_of_type_Int = 0;
    jdField_f_of_type_Int = 1;
    g = 2;
    jdField_a_of_type_Long = 1L;
    jdField_b_of_type_Long = 1L;
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_Int = jdField_c_of_type_Int + 1;
  }
  
  public EmojiManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_JavaLangString = EmojiManager.class.getSimpleName();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = null;
    this.jdField_b_of_type_ComTencentMobileqqVipDownloadListener = new iew(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_c_of_type_ComTencentMobileqqVipDownloadListener = new iex(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_d_of_type_ComTencentMobileqqVipDownloadListener = new iey(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_e_of_type_ComTencentMobileqqVipDownloadListener = new iez(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
    this.jdField_b_of_type_JavaUtilMap = Collections.synchronizedMap(new LinkedHashMap(10, 1.1F, true));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager = ((PngFrameManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(78));
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager = new EmojiListenerManager();
  }
  
  private int a(EmoticonPackage paramEmoticonPackage, ArrayList paramArrayList, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    int m = paramArrayList.size();
    int j = 0;
    if (j < m)
    {
      Emoticon localEmoticon = (Emoticon)paramArrayList.get(j);
      Object localObject1;
      if ((paramInt & 0x2) == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo imgPreview.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        localObject1 = c(localEmoticon);
        paramList.add(localObject1[0]);
        paramMap.put(localObject1[0], new File(localObject1[1]));
        localObject1 = localObject1[0];
        if (localEmoticon.jobType == 1)
        {
          k = 15;
          label167:
          paramBundle.putInt((String)localObject1, k);
        }
      }
      else
      {
        if ((paramInt & 0x4) == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo gif.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
          }
          if (paramEmoticonPackage.jobType != 1) {
            break label626;
          }
          localObject1 = d(localEmoticon);
          label271:
          ??? = EmosmUtils.getPngFramePath(localEmoticon.epId);
          if ((paramEmoticonPackage.rscType != 1) || (!FileUtils.a((String)???))) {
            break label653;
          }
          label297:
          paramMap.put(localObject1[0], new File(localObject1[1]));
          if (paramEmoticonPackage.jobType != 1) {
            break label677;
          }
          paramBundle.putInt(localObject1[0], 12);
        }
        label339:
        if ((paramInt & 0x1) == 1)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo AIO preview static.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
          }
          localObject1 = b(localEmoticon);
          paramList.add(localObject1[0]);
          paramMap.put(localObject1[0], new File(localObject1[1]));
          localObject1 = localObject1[0];
          if (localEmoticon.jobType != 1) {
            break label750;
          }
        }
      }
      label653:
      label677:
      label750:
      for (int k = 15;; k = 8) {
        for (;;)
        {
          paramBundle.putInt((String)localObject1, k);
          if ((localEmoticon.isSound) && ((paramInt & 0x8) == 8))
          {
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| Emoticon download emo sound.pid=" + localEmoticon.epId + " eid=" + localEmoticon.eId + " type=" + paramInt);
            }
            localObject1 = a(localEmoticon);
            paramList.add(localObject1[0]);
            paramMap.put(localObject1[0], new File(localObject1[1]));
            paramBundle.putInt(localObject1[0], 9);
          }
          j += 1;
          break;
          k = 6;
          break label167;
          label626:
          if (localEmoticon.hasEncryptKey())
          {
            localObject1 = a(localEmoticon, paramEmoticonPackage.rscType);
            break label271;
          }
          return 11009;
          if (FileUtils.a(localObject1[1])) {
            break label297;
          }
          paramList.add(localObject1[0]);
          break label297;
          if (paramEmoticonPackage.rscType == 1)
          {
            paramBundle.putInt(localObject1[0], 16);
            break label339;
          }
          paramBundle.putInt(localObject1[0], 7);
          synchronized (this.jdField_a_of_type_JavaUtilMap)
          {
            this.jdField_a_of_type_JavaUtilMap.put(localObject1[0], localEmoticon.encryptKey);
          }
        }
      }
    }
    return 0;
  }
  
  private int a(File paramFile, EmoticonPackage paramEmoticonPackage, boolean paramBoolean, List paramList, Map paramMap, Bundle paramBundle, int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ReqInfo localReqInfo = new ReqInfo();
    if (paramFile.exists()) {}
    for (paramFile = FileUtils.a(paramFile);; paramFile = null)
    {
      paramFile = a(paramEmoticonPackage, jdField_c_of_type_Int, paramFile, localArrayList1, localArrayList2, localReqInfo);
      if (paramFile == null) {
        break;
      }
      a("param_error", paramFile, null, 0, null);
      return 11008;
    }
    if (paramBoolean) {}
    for (paramFile = localArrayList2;; paramFile = localArrayList1)
    {
      paramBundle.putBoolean("isUpdate", paramBoolean);
      paramBundle.putSerializable("emoticonList", paramFile);
      if (localReqInfo.jdField_a_of_type_Boolean) {
        break;
      }
      int j = 0;
      int k;
      do
      {
        localReqInfo.jdField_a_of_type_JavaLangString = null;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + j);
        }
        a(paramEmoticonPackage.epId, paramFile, localReqInfo, false);
        k = j + 1;
        if (localReqInfo.jdField_a_of_type_Boolean) {
          break;
        }
        j = k;
      } while (k < 3);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "addEmoticonsTask| fetchEncryptKeys count=" + k + " encryptKeysSuccess=" + localReqInfo.jdField_a_of_type_Boolean);
      }
      if (localReqInfo.jdField_a_of_type_Boolean) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|addEmoticonsTask| fetchEncryptKeys fail epId=" + paramEmoticonPackage.epId + " encryptGetKeySeq=" + localReqInfo.jdField_a_of_type_JavaLangString + " encryptKeysResultCode" + localReqInfo.jdField_a_of_type_Int);
      }
      a(paramEmoticonPackage, localReqInfo.a());
      return 11009;
    }
    paramInt = a(paramEmoticonPackage, paramFile, paramList, paramMap, paramBundle, paramInt);
    if (paramInt != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, paramInt, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a("param_step", String.valueOf(7), null, 0, null);
      return paramInt;
    }
    return 0;
  }
  
  /* Error */
  private Bundle a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: iconst_0
    //   3: istore 12
    //   5: lconst_0
    //   6: lstore 15
    //   8: iconst_m1
    //   9: istore 11
    //   11: aconst_null
    //   12: astore 19
    //   14: aconst_null
    //   15: astore 20
    //   17: aload_0
    //   18: invokevirtual 360	com/tencent/mobileqq/emoticon/EmojiManager:a	()Lcom/tencent/mobileqq/model/EmoticonManager;
    //   21: aload_1
    //   22: invokeinterface 365 2 0
    //   27: astore 17
    //   29: aload 17
    //   31: ifnull +13 -> 44
    //   34: aload 17
    //   36: getfield 368	com/tencent/mobileqq/data/EmoticonPackage:valid	Z
    //   39: ifeq +323 -> 362
    //   42: iconst_1
    //   43: istore_3
    //   44: iload_2
    //   45: iconst_2
    //   46: if_icmpne +1327 -> 1373
    //   49: iconst_1
    //   50: istore 10
    //   52: aload_0
    //   53: invokespecial 371	com/tencent/mobileqq/emoticon/EmojiManager:a	()Lcom/tencent/mobileqq/vip/DownloaderInterface;
    //   56: new 179	java/lang/StringBuilder
    //   59: dup
    //   60: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   63: ldc 30
    //   65: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: aload_1
    //   69: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokeinterface 376 2 0
    //   80: astore 17
    //   82: aload 17
    //   84: ifnull +1278 -> 1362
    //   87: aload 17
    //   89: invokevirtual 380	com/tencent/mobileqq/vip/DownloadTask:b	()Z
    //   92: ifne +1270 -> 1362
    //   95: iconst_0
    //   96: istore 4
    //   98: aload 17
    //   100: getfield 383	com/tencent/mobileqq/vip/DownloadTask:a	F
    //   103: f2i
    //   104: istore_3
    //   105: iconst_2
    //   106: istore 5
    //   108: iload 4
    //   110: iconst_m1
    //   111: if_icmpne +1010 -> 1121
    //   114: iload_2
    //   115: tableswitch	default:+25 -> 140, 1:+252->367, 2:+424->539, 3:+345->460
    //   141: lstore 13
    //   143: iconst_0
    //   144: istore_2
    //   145: aconst_null
    //   146: astore 18
    //   148: iconst_m1
    //   149: istore 7
    //   151: aconst_null
    //   152: astore 17
    //   154: iload 4
    //   156: istore 6
    //   158: iload_2
    //   159: istore 4
    //   161: iload 7
    //   163: istore_2
    //   164: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   167: ifeq +1110 -> 1277
    //   170: aload_0
    //   171: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   174: iconst_2
    //   175: new 179	java/lang/StringBuilder
    //   178: dup
    //   179: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   182: ldc_w 385
    //   185: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: iload 6
    //   190: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   193: ldc_w 387
    //   196: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: iload 5
    //   201: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: ldc_w 389
    //   207: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: iload_3
    //   211: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   214: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: iload 4
    //   222: istore 9
    //   224: iload_2
    //   225: istore 8
    //   227: iload 6
    //   229: istore_2
    //   230: iload 5
    //   232: istore 6
    //   234: iload_3
    //   235: istore 7
    //   237: iload_2
    //   238: istore_3
    //   239: iload_2
    //   240: iconst_m1
    //   241: if_icmpne +11 -> 252
    //   244: iconst_0
    //   245: istore_3
    //   246: iconst_0
    //   247: istore 6
    //   249: iconst_0
    //   250: istore 7
    //   252: new 241	android/os/Bundle
    //   255: dup
    //   256: invokespecial 390	android/os/Bundle:<init>	()V
    //   259: astore 19
    //   261: aload 19
    //   263: ldc_w 392
    //   266: aload_1
    //   267: invokevirtual 396	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   270: aload 19
    //   272: ldc_w 398
    //   275: iload_3
    //   276: invokevirtual 245	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   279: aload 19
    //   281: ldc_w 400
    //   284: iload 6
    //   286: invokevirtual 245	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   289: aload 19
    //   291: ldc_w 402
    //   294: iload 9
    //   296: invokevirtual 245	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   299: aload 19
    //   301: ldc_w 404
    //   304: lload 13
    //   306: invokevirtual 408	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   309: aload 19
    //   311: ldc_w 410
    //   314: iload 7
    //   316: invokevirtual 245	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   319: aload 19
    //   321: ldc_w 412
    //   324: iload 8
    //   326: invokevirtual 245	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   329: aload 19
    //   331: ldc_w 414
    //   334: iload 10
    //   336: invokevirtual 245	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   339: aload 19
    //   341: ldc_w 416
    //   344: aload 18
    //   346: invokevirtual 420	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   349: aload 19
    //   351: ldc_w 422
    //   354: aload 17
    //   356: invokevirtual 420	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   359: aload 19
    //   361: areturn
    //   362: iconst_0
    //   363: istore_3
    //   364: goto -320 -> 44
    //   367: aload_0
    //   368: invokevirtual 360	com/tencent/mobileqq/emoticon/EmojiManager:a	()Lcom/tencent/mobileqq/model/EmoticonManager;
    //   371: aload_1
    //   372: invokeinterface 365 2 0
    //   377: astore 17
    //   379: aload 17
    //   381: ifnull -241 -> 140
    //   384: aload 17
    //   386: getfield 424	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   389: iconst_2
    //   390: if_icmpne -250 -> 140
    //   393: aload_0
    //   394: aload_1
    //   395: invokevirtual 426	com/tencent/mobileqq/emoticon/EmojiManager:b	(Ljava/lang/String;)Z
    //   398: ifeq +55 -> 453
    //   401: aload 17
    //   403: getfield 429	com/tencent/mobileqq/data/EmoticonPackage:updateFlag	I
    //   406: invokestatic 434	com/tencent/mobileqq/emoticonview/EmoticonUtils:a	(I)Z
    //   409: ifeq +36 -> 445
    //   412: iconst_4
    //   413: istore_3
    //   414: iconst_0
    //   415: istore_2
    //   416: lconst_0
    //   417: lstore 13
    //   419: iconst_0
    //   420: istore 4
    //   422: iload_3
    //   423: istore 5
    //   425: aconst_null
    //   426: astore 18
    //   428: iconst_0
    //   429: istore 6
    //   431: iconst_m1
    //   432: istore 7
    //   434: iload_2
    //   435: istore_3
    //   436: aconst_null
    //   437: astore 17
    //   439: iload 7
    //   441: istore_2
    //   442: goto -278 -> 164
    //   445: bipush 100
    //   447: istore_2
    //   448: iconst_3
    //   449: istore_3
    //   450: goto -34 -> 416
    //   453: iconst_0
    //   454: istore_3
    //   455: iconst_0
    //   456: istore_2
    //   457: goto -41 -> 416
    //   460: aload_0
    //   461: invokevirtual 360	com/tencent/mobileqq/emoticon/EmojiManager:a	()Lcom/tencent/mobileqq/model/EmoticonManager;
    //   464: aload_1
    //   465: invokeinterface 365 2 0
    //   470: astore 17
    //   472: aload 17
    //   474: ifnull -334 -> 140
    //   477: aload 17
    //   479: getfield 424	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   482: iconst_2
    //   483: if_icmpne -343 -> 140
    //   486: aload_0
    //   487: aload_1
    //   488: iconst_1
    //   489: invokestatic 439	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   492: invokevirtual 442	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;Ljava/lang/Boolean;)Z
    //   495: ifeq +37 -> 532
    //   498: bipush 100
    //   500: istore_2
    //   501: iconst_3
    //   502: istore_3
    //   503: lconst_0
    //   504: lstore 13
    //   506: iconst_0
    //   507: istore 4
    //   509: iload_3
    //   510: istore 5
    //   512: aconst_null
    //   513: astore 18
    //   515: iconst_0
    //   516: istore 6
    //   518: iconst_m1
    //   519: istore 7
    //   521: iload_2
    //   522: istore_3
    //   523: aconst_null
    //   524: astore 17
    //   526: iload 7
    //   528: istore_2
    //   529: goto -365 -> 164
    //   532: iconst_0
    //   533: istore_3
    //   534: iconst_0
    //   535: istore_2
    //   536: goto -33 -> 503
    //   539: aload_0
    //   540: getfield 70	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   543: ldc_w 444
    //   546: invokestatic 449	com/tencent/mobileqq/emoticon/EPluginInstallTask:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   549: astore 17
    //   551: aload 17
    //   553: ifnull +510 -> 1063
    //   556: aload 17
    //   558: getfield 454	cooperation/plugin/PluginInfo:mState	I
    //   561: iconst_4
    //   562: if_icmpne +501 -> 1063
    //   565: aload 17
    //   567: getfield 457	cooperation/plugin/PluginInfo:mLength	J
    //   570: lstore 13
    //   572: aload_0
    //   573: invokevirtual 360	com/tencent/mobileqq/emoticon/EmojiManager:a	()Lcom/tencent/mobileqq/model/EmoticonManager;
    //   576: aload_1
    //   577: invokeinterface 459 2 0
    //   582: astore 17
    //   584: aload 17
    //   586: ifnull +754 -> 1340
    //   589: aload 17
    //   591: getfield 424	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   594: iconst_2
    //   595: if_icmpne +446 -> 1041
    //   598: aload 17
    //   600: getfield 462	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   603: ifnull +714 -> 1317
    //   606: aload 17
    //   608: getfield 462	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   611: invokevirtual 465	java/lang/String:length	()I
    //   614: ifle +703 -> 1317
    //   617: iload 11
    //   619: istore_3
    //   620: aload 17
    //   622: getfield 462	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   625: invokestatic 471	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   628: istore_2
    //   629: iload_2
    //   630: istore_3
    //   631: aload_0
    //   632: invokevirtual 360	com/tencent/mobileqq/emoticon/EmojiManager:a	()Lcom/tencent/mobileqq/model/EmoticonManager;
    //   635: aload 17
    //   637: getfield 462	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   640: invokeinterface 474 2 0
    //   645: checkcast 80	java/util/ArrayList
    //   648: astore 19
    //   650: aload 19
    //   652: ifnull +656 -> 1308
    //   655: iload_2
    //   656: istore_3
    //   657: aload 19
    //   659: invokevirtual 165	java/util/ArrayList:size	()I
    //   662: istore 4
    //   664: iload_2
    //   665: istore_3
    //   666: new 80	java/util/ArrayList
    //   669: dup
    //   670: iload 4
    //   672: invokespecial 477	java/util/ArrayList:<init>	(I)V
    //   675: astore 18
    //   677: new 80	java/util/ArrayList
    //   680: dup
    //   681: iload 4
    //   683: invokespecial 477	java/util/ArrayList:<init>	(I)V
    //   686: astore 17
    //   688: iconst_0
    //   689: istore_3
    //   690: iload_3
    //   691: iload 4
    //   693: if_icmpge +104 -> 797
    //   696: aload 19
    //   698: iload_3
    //   699: invokevirtual 169	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   702: checkcast 171	com/tencent/mobileqq/data/Emoticon
    //   705: astore 20
    //   707: aload 20
    //   709: getfield 189	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   712: aload 20
    //   714: getfield 194	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   717: invokestatic 481	com/tencent/mobileqq/emosm/EmosmUtils:getEmoticonPreviewPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   720: astore 21
    //   722: aload 21
    //   724: invokestatic 266	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/lang/String;)Z
    //   727: ifeq +63 -> 790
    //   730: aload 18
    //   732: aload 21
    //   734: invokevirtual 482	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   737: pop
    //   738: aload 17
    //   740: new 179	java/lang/StringBuilder
    //   743: dup
    //   744: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   747: aload 20
    //   749: getfield 189	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   752: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: ldc_w 484
    //   758: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: aload 20
    //   763: getfield 194	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   766: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: ldc_w 484
    //   772: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload 20
    //   777: getfield 286	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   780: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   786: invokevirtual 482	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   789: pop
    //   790: iload_3
    //   791: iconst_1
    //   792: iadd
    //   793: istore_3
    //   794: goto -104 -> 690
    //   797: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   800: ifeq +67 -> 867
    //   803: aload_0
    //   804: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   807: astore 20
    //   809: new 179	java/lang/StringBuilder
    //   812: dup
    //   813: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   816: ldc_w 486
    //   819: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: astore 21
    //   824: aload 18
    //   826: ifnonnull +100 -> 926
    //   829: iconst_0
    //   830: istore_3
    //   831: aload 21
    //   833: iload_3
    //   834: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   837: ldc_w 488
    //   840: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   843: astore 21
    //   845: aload 19
    //   847: ifnonnull +88 -> 935
    //   850: iconst_0
    //   851: istore_3
    //   852: aload 20
    //   854: iconst_2
    //   855: aload 21
    //   857: iload_3
    //   858: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   861: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   864: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   867: aload 18
    //   869: ifnull +24 -> 893
    //   872: aload 18
    //   874: invokevirtual 165	java/util/ArrayList:size	()I
    //   877: ifeq +16 -> 893
    //   880: aload 17
    //   882: ifnull +11 -> 893
    //   885: aload 17
    //   887: invokevirtual 165	java/util/ArrayList:size	()I
    //   890: ifne +407 -> 1297
    //   893: iconst_0
    //   894: istore_2
    //   895: aload 18
    //   897: astore 19
    //   899: aload 17
    //   901: astore 20
    //   903: bipush 100
    //   905: istore_3
    //   906: iconst_1
    //   907: istore 4
    //   909: iconst_3
    //   910: istore 5
    //   912: iconst_0
    //   913: istore 6
    //   915: aload 20
    //   917: astore 17
    //   919: aload 19
    //   921: astore 18
    //   923: goto -759 -> 164
    //   926: aload 18
    //   928: invokevirtual 165	java/util/ArrayList:size	()I
    //   931: istore_3
    //   932: goto -101 -> 831
    //   935: aload 19
    //   937: invokevirtual 165	java/util/ArrayList:size	()I
    //   940: istore_3
    //   941: goto -89 -> 852
    //   944: astore 19
    //   946: aconst_null
    //   947: astore 18
    //   949: iload_3
    //   950: istore_2
    //   951: aconst_null
    //   952: astore 17
    //   954: aload 19
    //   956: invokevirtual 491	java/lang/Exception:printStackTrace	()V
    //   959: aload 18
    //   961: ifnull +32 -> 993
    //   964: aload 18
    //   966: invokevirtual 165	java/util/ArrayList:size	()I
    //   969: ifeq +24 -> 993
    //   972: aload 17
    //   974: ifnull +19 -> 993
    //   977: aload 17
    //   979: astore 20
    //   981: aload 18
    //   983: astore 19
    //   985: aload 17
    //   987: invokevirtual 165	java/util/ArrayList:size	()I
    //   990: ifne -87 -> 903
    //   993: iconst_0
    //   994: istore_2
    //   995: aload 17
    //   997: astore 20
    //   999: aload 18
    //   1001: astore 19
    //   1003: goto -100 -> 903
    //   1006: astore_1
    //   1007: aconst_null
    //   1008: astore 17
    //   1010: aconst_null
    //   1011: astore 18
    //   1013: aload 18
    //   1015: ifnull +24 -> 1039
    //   1018: aload 18
    //   1020: invokevirtual 165	java/util/ArrayList:size	()I
    //   1023: ifeq +16 -> 1039
    //   1026: aload 17
    //   1028: ifnull +11 -> 1039
    //   1031: aload 17
    //   1033: invokevirtual 165	java/util/ArrayList:size	()I
    //   1036: ifne +3 -> 1039
    //   1039: aload_1
    //   1040: athrow
    //   1041: iconst_1
    //   1042: istore 4
    //   1044: iconst_0
    //   1045: istore_3
    //   1046: aconst_null
    //   1047: astore 17
    //   1049: iconst_0
    //   1050: istore 5
    //   1052: iconst_0
    //   1053: istore 6
    //   1055: iconst_m1
    //   1056: istore_2
    //   1057: aconst_null
    //   1058: astore 18
    //   1060: goto -896 -> 164
    //   1063: iconst_0
    //   1064: istore 6
    //   1066: aload 17
    //   1068: ifnull +29 -> 1097
    //   1071: aload 17
    //   1073: getfield 457	cooperation/plugin/PluginInfo:mLength	J
    //   1076: lstore 13
    //   1078: iconst_0
    //   1079: istore 4
    //   1081: iconst_0
    //   1082: istore 5
    //   1084: aconst_null
    //   1085: astore 18
    //   1087: iconst_m1
    //   1088: istore_2
    //   1089: iconst_0
    //   1090: istore_3
    //   1091: aconst_null
    //   1092: astore 17
    //   1094: goto -930 -> 164
    //   1097: ldc2_w 492
    //   1100: lstore 13
    //   1102: iconst_0
    //   1103: istore 4
    //   1105: iconst_0
    //   1106: istore 5
    //   1108: aconst_null
    //   1109: astore 18
    //   1111: iconst_m1
    //   1112: istore_2
    //   1113: iconst_0
    //   1114: istore_3
    //   1115: aconst_null
    //   1116: astore 17
    //   1118: goto -954 -> 164
    //   1121: iload_3
    //   1122: istore 7
    //   1124: iload 5
    //   1126: istore 6
    //   1128: iload 4
    //   1130: istore_2
    //   1131: iload 11
    //   1133: istore 8
    //   1135: aload 20
    //   1137: astore 17
    //   1139: aload 19
    //   1141: astore 18
    //   1143: lload 15
    //   1145: lstore 13
    //   1147: iload 12
    //   1149: istore 9
    //   1151: invokestatic 177	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1154: ifeq -917 -> 237
    //   1157: aload_0
    //   1158: getfield 78	com/tencent/mobileqq/emoticon/EmojiManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1161: iconst_2
    //   1162: new 179	java/lang/StringBuilder
    //   1165: dup
    //   1166: invokespecial 180	java/lang/StringBuilder:<init>	()V
    //   1169: ldc_w 495
    //   1172: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1175: iload 4
    //   1177: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1180: ldc_w 387
    //   1183: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1186: iload 5
    //   1188: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1191: ldc_w 389
    //   1194: invokevirtual 186	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1197: iload_3
    //   1198: invokevirtual 199	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1201: invokevirtual 213	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1204: invokestatic 216	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1207: iload_3
    //   1208: istore 7
    //   1210: iload 5
    //   1212: istore 6
    //   1214: iload 4
    //   1216: istore_2
    //   1217: iload 11
    //   1219: istore 8
    //   1221: aload 20
    //   1223: astore 17
    //   1225: aload 19
    //   1227: astore 18
    //   1229: lload 15
    //   1231: lstore 13
    //   1233: iload 12
    //   1235: istore 9
    //   1237: goto -1000 -> 237
    //   1240: astore_1
    //   1241: aconst_null
    //   1242: astore 17
    //   1244: goto -231 -> 1013
    //   1247: astore_1
    //   1248: goto -235 -> 1013
    //   1251: astore_1
    //   1252: goto -239 -> 1013
    //   1255: astore_1
    //   1256: goto -243 -> 1013
    //   1259: astore 19
    //   1261: aconst_null
    //   1262: astore 17
    //   1264: goto -310 -> 954
    //   1267: astore 19
    //   1269: goto -315 -> 954
    //   1272: astore 19
    //   1274: goto -320 -> 954
    //   1277: iload_2
    //   1278: istore 8
    //   1280: iload 6
    //   1282: istore_2
    //   1283: iload_3
    //   1284: istore 7
    //   1286: iload 5
    //   1288: istore 6
    //   1290: iload 4
    //   1292: istore 9
    //   1294: goto -1057 -> 237
    //   1297: aload 17
    //   1299: astore 20
    //   1301: aload 18
    //   1303: astore 19
    //   1305: goto -402 -> 903
    //   1308: aconst_null
    //   1309: astore 17
    //   1311: aconst_null
    //   1312: astore 18
    //   1314: goto -517 -> 797
    //   1317: aconst_null
    //   1318: astore 17
    //   1320: aconst_null
    //   1321: astore 18
    //   1323: iconst_m1
    //   1324: istore_2
    //   1325: bipush 100
    //   1327: istore_3
    //   1328: iconst_1
    //   1329: istore 4
    //   1331: iconst_3
    //   1332: istore 5
    //   1334: iconst_0
    //   1335: istore 6
    //   1337: goto -1173 -> 164
    //   1340: iconst_1
    //   1341: istore 7
    //   1343: aconst_null
    //   1344: astore 17
    //   1346: iload 4
    //   1348: istore 6
    //   1350: iconst_m1
    //   1351: istore_2
    //   1352: aconst_null
    //   1353: astore 18
    //   1355: iload 7
    //   1357: istore 4
    //   1359: goto -1195 -> 164
    //   1362: iconst_0
    //   1363: istore_3
    //   1364: iconst_0
    //   1365: istore 5
    //   1367: iconst_m1
    //   1368: istore 4
    //   1370: goto -1262 -> 108
    //   1373: iload_3
    //   1374: istore 10
    //   1376: goto -1324 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1379	0	this	EmojiManager
    //   0	1379	1	paramString	String
    //   0	1379	2	paramInt	int
    //   1	1373	3	j	int
    //   96	1273	4	k	int
    //   106	1260	5	m	int
    //   156	1193	6	n	int
    //   149	1207	7	i1	int
    //   225	1054	8	i2	int
    //   222	1071	9	i3	int
    //   50	1325	10	i4	int
    //   9	1209	11	i5	int
    //   3	1231	12	i6	int
    //   141	1091	13	l1	long
    //   6	1224	15	l2	long
    //   27	1318	17	localObject1	Object
    //   146	1208	18	localObject2	Object
    //   12	924	19	localObject3	Object
    //   944	11	19	localException1	Exception
    //   983	243	19	localObject4	Object
    //   1259	1	19	localException2	Exception
    //   1267	1	19	localException3	Exception
    //   1272	1	19	localException4	Exception
    //   1303	1	19	localObject5	Object
    //   15	1285	20	localObject6	Object
    //   720	136	21	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   620	629	944	java/lang/Exception
    //   631	650	944	java/lang/Exception
    //   657	664	944	java/lang/Exception
    //   666	677	944	java/lang/Exception
    //   620	629	1006	finally
    //   631	650	1006	finally
    //   657	664	1006	finally
    //   666	677	1006	finally
    //   677	688	1240	finally
    //   696	790	1247	finally
    //   797	824	1251	finally
    //   831	845	1251	finally
    //   852	867	1251	finally
    //   926	932	1251	finally
    //   935	941	1251	finally
    //   954	959	1255	finally
    //   677	688	1259	java/lang/Exception
    //   696	790	1267	java/lang/Exception
    //   797	824	1272	java/lang/Exception
    //   831	845	1272	java/lang/Exception
    //   852	867	1272	java/lang/Exception
    //   926	932	1272	java/lang/Exception
    //   935	941	1272	java/lang/Exception
  }
  
  private DownloaderInterface a()
  {
    return ((DownloaderFactory)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(46)).a(1);
  }
  
  private String a(EmoticonPackage paramEmoticonPackage)
  {
    if (paramEmoticonPackage == null) {
      return null;
    }
    switch (paramEmoticonPackage.jobType)
    {
    default: 
      return "actEmoPackage";
    case 0: 
      return "actEmoPackage";
    case 2: 
      return "actQFaceGifPackage";
    }
    return "actQFaceMaterial";
  }
  
  private void a(Emoticon paramEmoticon, int paramInt, long paramLong)
  {
    if ((paramInt == 11003) || (paramInt == 11001) || (paramInt == 11000)) {
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        HashMap localHashMap2 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        int j = (int)(System.currentTimeMillis() - paramLong);
        if (paramInt == 0) {
          break label133;
        }
        bool = false;
        a("param_FailCode", String.valueOf(paramInt));
        if (paramEmoticon.jobType == 1)
        {
          paramEmoticon = "actQFaceGif";
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramEmoticon, bool, j, 0L, localHashMap2, "");
          return;
        }
      }
      paramEmoticon = "actEmoAIO";
      continue;
      label133:
      boolean bool = true;
    }
  }
  
  private void a(Emoticon paramEmoticon, ReqInfo paramReqInfo)
  {
    if ((paramEmoticon == null) || (paramReqInfo == null)) {}
    while ((paramEmoticon.encryptKey != null) && (paramEmoticon.encryptKey.length() > 0)) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramEmoticon);
    a(paramEmoticon.epId, localArrayList, paramReqInfo, false);
  }
  
  private void a(String paramString, ArrayList paramArrayList, ReqInfo paramReqInfo, boolean paramBoolean)
  {
    int j;
    try
    {
      j = Integer.parseInt(paramString);
      if ((paramArrayList == null) || (paramArrayList.size() == 0) || (paramReqInfo == null)) {
        return;
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return;
    }
    paramString = new Object();
    EmosmHandler localEmosmHandler = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    Object localObject = new ifb(this, paramReqInfo, localEmosmHandler, paramBoolean, paramArrayList, paramString);
    localEmosmHandler.a((EmosmHandler.EmosmHandlerListener)localObject);
    this.jdField_a_of_type_JavaUtilArrayList.add(localObject);
    int k = this.i;
    this.i = (k + 1);
    localObject = Integer.toString(k);
    paramReqInfo.jdField_a_of_type_JavaLangString = ((String)localObject);
    paramReqInfo.jdField_a_of_type_Int = 11022;
    localEmosmHandler.a(j, paramArrayList, (String)localObject);
    try
    {
      try
      {
        paramString.wait(35000L);
        return;
      }
      finally {}
      return;
    }
    catch (InterruptedException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    String str1 = paramEmoticonPackage.epId;
    int k;
    if (paramEmoticonPackage.jobType == 2)
    {
      str1 = paramEmoticonPackage.kinId;
      k = 13;
    }
    for (int j = 14;; j = 4)
    {
      String str2 = EmosmUtils.getCoverUrl(k, str1);
      String str3 = EmosmUtils.getCoverPath(3, paramEmoticonPackage.epId);
      paramList.add(str2);
      paramMap.put(str2, new File(str3));
      paramBundle.putInt(str2, 3);
      str1 = EmosmUtils.getCoverUrl(j, str1);
      paramEmoticonPackage = EmosmUtils.getCoverPath(4, paramEmoticonPackage.epId);
      paramList.add(str1);
      paramMap.put(str1, new File(paramEmoticonPackage));
      paramBundle.putInt(str1, 4);
      return;
      k = 3;
    }
  }
  
  private String[] a(Emoticon paramEmoticon)
  {
    return new String[] { EmosmUtils.getEmoticonSoundUrl(paramEmoticon.epId, paramEmoticon.eId), EmosmUtils.getEmoticonSoundPath(paramEmoticon.epId, paramEmoticon.eId) };
  }
  
  private String[] a(Emoticon paramEmoticon, int paramInt)
  {
    String str2 = EmosmUtils.getEmoticonEncrytUrl(paramEmoticon.epId, paramEmoticon.eId, paramInt);
    String str1 = EmosmUtils.getEmoticonEncryptPath(paramEmoticon.epId, paramEmoticon.eId);
    paramEmoticon = str1;
    if (1 == paramInt)
    {
      paramEmoticon = str1;
      if (!TextUtils.isEmpty(str1)) {
        paramEmoticon = str1 + ".zip";
      }
    }
    return new String[] { str2, paramEmoticon };
  }
  
  private void b(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (paramEmoticonPackage.jobType == 2) {}
    for (String str = paramEmoticonPackage.kinId;; str = paramEmoticonPackage.epId)
    {
      str = EmosmUtils.getCoverUrl(2, str);
      paramEmoticonPackage = EmosmUtils.getCoverPath(2, paramEmoticonPackage.epId);
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 2);
      return;
    }
  }
  
  private boolean b(String paramString, Boolean paramBoolean)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject;
    if (paramBoolean.booleanValue())
    {
      paramBoolean = (ArrayList)a().a(paramString);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.iterator();
        if (!paramBoolean.hasNext()) {
          break label503;
        }
        paramBoolean = (Emoticon)paramBoolean.next();
        if (paramBoolean == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
          }
          return false;
        }
        if ((paramBoolean.jobType == 2) && ((paramBoolean.encryptKey == null) || (paramBoolean.encryptKey.length() == 0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + paramBoolean.eId);
          }
          return false;
        }
        if (!new File(EmosmUtils.getEmoticonPreviewPath(paramString, paramBoolean.eId)).exists())
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
          }
          return false;
        }
        localObject = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString);
        if (localObject == null) {
          break label918;
        }
      }
    }
    label918:
    for (int j = ((EmoticonPackage)localObject).rscType;; j = 0)
    {
      if (1 == j)
      {
        if (!FileUtils.a(EmosmUtils.getEmoticonAIOPreviewPath(paramString, paramBoolean.eId))) {
          return false;
        }
        localObject = EmosmUtils.getPngFramePath(paramString);
        paramBoolean = new File((String)localObject);
        localObject = new File((String)localObject + File.separator + "config.json");
        if ((!paramBoolean.exists()) || (!((File)localObject).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "func checkMagicFacePackageIntact, PNG is not intact.");
          }
          return false;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a(paramString);
        if (paramString == null) {
          return false;
        }
        return paramString.a();
      }
      if (!new File(EmosmUtils.getEmoticonEncryptPath(paramString, paramBoolean.eId)).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + paramBoolean.eId);
        }
        return false;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
        }
        return false;
      }
      label503:
      paramBoolean = MagicfaceResLoader.a();
      String str = EmosmUtils.getEmoticonPackageFolder(paramString) + paramBoolean + File.separator + "video.ini";
      File localFile = new File(str);
      localObject = localFile;
      if (!localFile.exists())
      {
        paramBoolean = "big";
        str = EmosmUtils.getEmoticonPackageFolder(paramString) + "big" + File.separator + "video.ini";
        localFile = new File(str);
        localObject = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str);
      }
      localObject = FileUtils.a((File)localObject);
      int k;
      if (localObject != null)
      {
        localObject = ((String)localObject).split("&");
        k = localObject.length;
        j = 0;
        while (j < k)
        {
          str = localObject[j];
          if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + paramBoolean + File.separator + str).exists()) {
            return false;
          }
          j += 1;
        }
      }
      paramBoolean = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini");
      if (!paramBoolean.exists()) {
        return false;
      }
      paramBoolean = FileUtils.a(paramBoolean);
      if (paramBoolean != null)
      {
        paramBoolean = paramBoolean.split("&");
        k = paramBoolean.length;
        j = 0;
        while (j < k)
        {
          localObject = paramBoolean[j];
          if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + (String)localObject).exists()) {
            return false;
          }
          j += 1;
        }
      }
      return a(paramString, jdField_f_of_type_Int);
    }
  }
  
  private String[] b(Emoticon paramEmoticon)
  {
    String str;
    if (paramEmoticon.jobType == 1) {
      str = EmosmUtils.getQFaceThumbUrl(paramEmoticon.epId, paramEmoticon.eId, paramEmoticon.encryptKey);
    }
    for (paramEmoticon = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId);; paramEmoticon = EmosmUtils.getEmoticonAIOPreviewPath(paramEmoticon.epId, paramEmoticon.eId))
    {
      return new String[] { str, paramEmoticon };
      str = EmosmUtils.getEmoticonAIOPreviewUrl(paramEmoticon.epId, paramEmoticon.eId);
    }
  }
  
  private void c(EmoticonPackage paramEmoticonPackage)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null) || (paramEmoticonPackage.jobType != 1)) {
      return;
    }
    new ifc(this, EmosmUtils.getQFaceMaterialFolderPath(paramEmoticonPackage.epId, false)).start();
  }
  
  private void c(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, jdField_f_of_type_Int))
    {
      String str = EmosmUtils.getMagicFaceMaterialPackageUrl(paramEmoticonPackage.epId, 1);
      paramEmoticonPackage = EmosmUtils.getMagicFaceZipPath(paramEmoticonPackage.epId);
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 10);
    }
  }
  
  private String[] c(Emoticon paramEmoticon)
  {
    String str;
    if (paramEmoticon.jobType == 1) {
      str = EmosmUtils.getQFaceThumbUrl(paramEmoticon.epId, paramEmoticon.eId, paramEmoticon.encryptKey);
    }
    for (paramEmoticon = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId);; paramEmoticon = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId))
    {
      return new String[] { str, paramEmoticon };
      str = EmosmUtils.getEmoticonPreviewUrl(paramEmoticon.epId, paramEmoticon.eId);
    }
  }
  
  private void d(List paramList, Map paramMap, EmoticonPackage paramEmoticonPackage, Bundle paramBundle)
  {
    if (!a(paramEmoticonPackage.epId, jdField_e_of_type_Int))
    {
      String str = EmosmUtils.getMagicFaceMaterialPackageUrl(paramEmoticonPackage.epId, 0);
      paramEmoticonPackage = EmosmUtils.getMagicFaceZipPath(paramEmoticonPackage.epId);
      paramList.add(str);
      paramMap.put(str, new File(paramEmoticonPackage));
      paramBundle.putInt(str, 10);
    }
  }
  
  private boolean d(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    Object localObject1 = EmosmUtils.getCoverPath(2, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_thumb isn't exist." + (String)localObject1);
      }
      return false;
    }
    localObject1 = EmosmUtils.getCoverPath(3, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_color isn't exist." + (String)localObject1);
      }
      return false;
    }
    localObject1 = EmosmUtils.getCoverPath(4, paramString);
    if (!new File((String)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "cover_pkg_gray isn't exist." + (String)localObject1);
      }
      return false;
    }
    localObject1 = (ArrayList)a().a(paramString);
    Object localObject2;
    EmoticonPackage localEmoticonPackage;
    if (localObject1 != null)
    {
      localObject1 = ((ArrayList)localObject1).iterator();
      if (!((Iterator)localObject1).hasNext()) {
        break label655;
      }
      localObject2 = (Emoticon)((Iterator)localObject1).next();
      if (localObject2 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "one of encrypts is null!" + paramString);
        }
        return false;
      }
      if ((((Emoticon)localObject2).jobType == 0) && ((((Emoticon)localObject2).encryptKey == null) || (((Emoticon)localObject2).encryptKey.length() == 0)))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "encrypt isn't exist.epId=" + paramString + " eId=" + ((Emoticon)localObject2).eId);
        }
        return false;
      }
      if (!new File(EmosmUtils.getEmoticonPreviewPath(paramString, ((Emoticon)localObject2).eId)).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img preview do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject2).eId);
        }
        return false;
      }
      localEmoticonPackage = ((EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13)).a(paramString);
      if (localEmoticonPackage == null) {
        break label657;
      }
    }
    label655:
    label657:
    for (int j = localEmoticonPackage.rscType;; j = 0)
    {
      if (1 == j)
      {
        localObject2 = EmosmUtils.getPngFramePath(paramString);
        localObject1 = new File((String)localObject2);
        localObject2 = new File((String)localObject2 + File.separator + "config.json");
        if ((!((File)localObject1).exists()) || (!((File)localObject2).exists()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "func checkMagicFacePackageIntact, PNG is not intact.");
          }
          return false;
        }
        paramString = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a(paramString);
        if (paramString == null) {
          return false;
        }
        return paramString.a();
      }
      if (new File(EmosmUtils.getEmoticonEncryptPath(paramString, ((Emoticon)localObject2).eId)).exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emo img encrypt file do not be exist! epId=" + paramString + " eId=" + ((Emoticon)localObject2).eId);
      }
      return false;
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticons do not be exist.epId=" + paramString);
      }
      return true;
    }
  }
  
  private String[] d(Emoticon paramEmoticon)
  {
    return new String[] { EmosmUtils.getQFaceGifUrl(paramEmoticon.epId, paramEmoticon.eId, paramEmoticon.encryptKey), EmosmUtils.getQFaceGifPath(paramEmoticon.epId, paramEmoticon.eId) };
  }
  
  public float a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return -1.0F;
      paramString = a().a("vipEmoticonKey_" + paramString);
    } while (paramString == null);
    return paramString.a;
  }
  
  public Bundle a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)a().b();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3));
        } else if (localEmoticonPackage.kinId != null) {
          localArrayList.add(a(localEmoticonPackage.kinId, 2));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    String str = String.valueOf(paramBundle.getInt("id"));
    int j = paramBundle.getInt("businessType");
    if (a().a("vipEmoticonKey_" + str) != null)
    {
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      return localBundle;
    }
    paramBundle = a().b(str);
    if ((paramBundle != null) && (paramBundle.status != 0))
    {
      switch (paramBundle.status)
      {
      default: 
        j = 1;
      }
      for (;;)
      {
        if ((paramBundle != null) && (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
        }
        localBundle.putInt("result", j);
        localBundle.putString("messge", "");
        return localBundle;
        if (EmoticonUtils.a(paramBundle.updateFlag))
        {
          a(paramBundle, true);
          j = 0;
        }
        else
        {
          j = 3;
          continue;
          j = 4;
        }
      }
    }
    EmoticonPackage localEmoticonPackage = a().a(str);
    paramBundle = localEmoticonPackage;
    if (localEmoticonPackage == null)
    {
      paramBundle = new EmoticonPackage();
      paramBundle.epId = str;
      paramBundle.wordingId = -1L;
      if (j != 2) {
        break label367;
      }
      paramBundle.jobType = 1;
    }
    for (;;)
    {
      paramBundle.isMagicFaceDownloading = false;
      a(paramBundle, true);
      localBundle.putInt("result", 0);
      localBundle.putString("messge", "");
      return localBundle;
      label367:
      if (j == 3) {
        paramBundle.jobType = 3;
      } else {
        paramBundle.jobType = 0;
      }
    }
  }
  
  public Bundle a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = a().a("vipEmoticonKey_" + paramString);
    if (paramString != null)
    {
      paramString.a(true);
      paramString = (EmoticonPackage)paramString.a().getSerializable("emoticonPackage");
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramString, 11007, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      }
    }
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    return paramString;
  }
  
  public EmoticonManager a()
  {
    return (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
  }
  
  public String a(EmoticonPackage paramEmoticonPackage, int paramInt, byte[] paramArrayOfByte, ArrayList paramArrayList1, ArrayList paramArrayList2, ReqInfo paramReqInfo)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 1))
    {
      paramArrayOfByte = "json data is null";
      return paramArrayOfByte;
    }
    EmoticonManager localEmoticonManager = (EmoticonManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(13);
    for (;;)
    {
      Object localObject1;
      String str1;
      Object localObject2;
      int k;
      int m;
      int n;
      int i1;
      int j;
      boolean bool;
      int i2;
      String str2;
      String str3;
      int i3;
      try
      {
        localObject1 = new JSONObject(new String(paramArrayOfByte, "utf-8"));
        str1 = ((JSONObject)localObject1).getString("id");
        localObject2 = ((JSONObject)localObject1).getString("name");
        if (!((JSONObject)localObject1).has("mark")) {
          break label1266;
        }
        paramArrayOfByte = ((JSONObject)localObject1).getString("mark");
        if (!((JSONObject)localObject1).has("type")) {
          break label1260;
        }
        k = ((JSONObject)localObject1).getInt("type");
        if (!((JSONObject)localObject1).has("feetype")) {
          break label1254;
        }
        m = ((JSONObject)localObject1).getInt("feetype");
        if (!((JSONObject)localObject1).has("rscType")) {
          break label1248;
        }
        n = ((JSONObject)localObject1).getInt("rscType");
        if (!((JSONObject)localObject1).has("updateTime")) {
          break label1242;
        }
        i1 = ((JSONObject)localObject1).getInt("updateTime");
        j = 0;
        if (!((JSONObject)localObject1).has("ringtype")) {
          break label1236;
        }
        Object localObject3 = ((JSONObject)localObject1).getString("ringtype");
        if ("1".equals(localObject3))
        {
          bool = true;
          if ((!((JSONObject)localObject1).has("type")) || (1 != k)) {
            break label1233;
          }
          j = 3;
          i2 = 0;
          if (((JSONObject)localObject1).has("downloadcount")) {
            i2 = ((JSONObject)localObject1).getInt("downloadcount");
          }
          paramEmoticonPackage.name = ((String)localObject2);
          paramEmoticonPackage.mark = paramArrayOfByte;
          paramEmoticonPackage.type = k;
          paramEmoticonPackage.mobileFeetype = m;
          paramEmoticonPackage.hasSound = bool;
          paramEmoticonPackage.downloadCount = i2;
          paramEmoticonPackage.jobType = j;
          paramEmoticonPackage.rscType = n;
          if (paramInt != jdField_d_of_type_Int) {
            paramEmoticonPackage.localVersion = i1;
          }
          if ((paramEmoticonPackage.mobileFeetype == 1) || (paramEmoticonPackage.isRecommendation) || (paramEmoticonPackage.jobType == 1))
          {
            paramEmoticonPackage.wordingId = 1L;
            localEmoticonManager.a(paramEmoticonPackage);
            if (QLog.isColorLevel()) {
              QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PARSE_EMOTICON_JSON epId[" + str1 + "]name[" + (String)localObject2 + "]mark[" + paramArrayOfByte + "]type[" + k + "]feetype[" + m + "]");
            }
            localObject3 = ((JSONObject)localObject1).getJSONArray("imgs");
            int i4 = ((JSONArray)localObject3).length();
            j = 1;
            m = 0;
            k = 0;
            if (m >= i4) {
              break label1198;
            }
            paramArrayOfByte = ((JSONArray)localObject3).getJSONObject(m);
            str2 = paramArrayOfByte.getString("id");
            str3 = paramArrayOfByte.getString("name");
            if (!paramArrayOfByte.has("wWidthInPhone")) {
              break label1227;
            }
            i1 = paramArrayOfByte.getInt("wWidthInPhone");
            if (!paramArrayOfByte.has("wHeightInPhone")) {
              break label1221;
            }
            i2 = paramArrayOfByte.getInt("wHeightInPhone");
            if (!paramArrayOfByte.has("keywords")) {
              break label1030;
            }
            localObject1 = paramArrayOfByte.getJSONArray("keywords");
            if (str3 != null) {
              ((JSONArray)localObject1).put(str3);
            }
            paramArrayOfByte = paramArrayOfByte.getJSONArray("keywords").toString();
            localObject2 = localEmoticonManager.a(str1, str2);
            i3 = 0;
            if (localObject2 != null) {
              break label1061;
            }
            n = i3;
            localObject1 = localObject2;
            if (paramInt != jdField_d_of_type_Int)
            {
              localObject2 = new Emoticon();
              ((Emoticon)localObject2).eId = str2;
              ((Emoticon)localObject2).epId = str1;
              ((Emoticon)localObject2).name = str3;
              ((Emoticon)localObject2).width = i1;
              ((Emoticon)localObject2).height = i2;
              ((Emoticon)localObject2).keywords = paramArrayOfByte;
              i1 = 1;
              n = i3;
              localObject1 = localObject2;
              j = i1;
              if (EmoticonUtils.a(paramEmoticonPackage))
              {
                paramArrayList2.add(localObject2);
                n = 1;
                j = i1;
                localObject1 = localObject2;
              }
            }
            i1 = k;
            if (localObject1 != null)
            {
              if ((((Emoticon)localObject1).encryptKey == null) || (((Emoticon)localObject1).encryptKey.length() < 1)) {
                break label1273;
              }
              ((Emoticon)localObject1).isSound = paramEmoticonPackage.hasSound;
              paramArrayList1.add(localObject1);
              i1 = k;
            }
            if ((j != 0) && (n == 0)) {
              localEmoticonManager.a((Emoticon)localObject1);
            }
            if (!QLog.isColorLevel()) {
              break label1279;
            }
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "emoticon eId[" + str2 + "]eName[" + str3 + "]");
            break label1279;
          }
        }
        else
        {
          if (!"2".equals(localObject3)) {
            break label1236;
          }
          j = 1;
          bool = false;
          continue;
        }
        localObject3 = localEmoticonManager.b(str1);
        if (localObject3 != null)
        {
          paramEmoticonPackage.wordingId = ((EmoticonPackage)localObject3).wordingId;
          continue;
        }
      }
      catch (JSONException paramArrayList2)
      {
        paramArrayList2.printStackTrace();
        paramArrayList1 = paramArrayList2.toString();
        paramArrayOfByte = paramArrayList1;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramArrayList2.toString());
        return paramArrayList1;
        paramEmoticonPackage.wordingId = -1L;
        continue;
      }
      catch (Exception paramArrayList2)
      {
        paramArrayList2.printStackTrace();
        paramArrayList1 = paramArrayList2.toString();
        paramArrayOfByte = paramArrayList1;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + paramEmoticonPackage.epId + " exception=" + paramArrayList2.toString());
      return paramArrayList1;
      label1030:
      paramArrayOfByte = "[" + str3 + "]";
      continue;
      label1061:
      if ((!str2.equals(((Emoticon)localObject2).eId)) || (!str1.equals(((Emoticon)localObject2).epId)) || (!str3.equals(((Emoticon)localObject2).name)))
      {
        ((Emoticon)localObject2).eId = str2;
        ((Emoticon)localObject2).epId = str1;
        ((Emoticon)localObject2).name = str3;
        ((Emoticon)localObject2).width = i1;
        ((Emoticon)localObject2).height = i2;
        ((Emoticon)localObject2).keywords = paramArrayOfByte;
        j = 1;
        n = i3;
        localObject1 = localObject2;
      }
      else
      {
        j = 0;
        n = i3;
        localObject1 = localObject2;
        if (!paramArrayOfByte.equals(((Emoticon)localObject2).keywords))
        {
          j = 1;
          ((Emoticon)localObject2).keywords = paramArrayOfByte;
          n = i3;
          localObject1 = localObject2;
          continue;
          label1198:
          if (k != 0)
          {
            paramReqInfo.jdField_a_of_type_Boolean = false;
            break label1292;
          }
          paramReqInfo.jdField_a_of_type_Boolean = true;
          break label1292;
          label1221:
          i2 = 0;
          continue;
          label1227:
          i1 = 0;
          continue;
          label1233:
          continue;
          label1236:
          bool = false;
          continue;
          label1242:
          i1 = 0;
          continue;
          label1248:
          n = 0;
          continue;
          label1254:
          m = 0;
          continue;
          label1260:
          k = 0;
          continue;
          label1266:
          paramArrayOfByte = "";
          continue;
          label1273:
          k = 1;
          continue;
          label1279:
          m += 1;
          k = i1;
        }
      }
    }
    label1292:
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.c.clear();
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    c(paramEmoticonPackage, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt)
  {
    if ((paramEmoticonPackage == null) || (paramInt == 11007) || (paramInt == 11003) || (paramInt == 11001) || (paramInt == 11000)) {
      return;
    }
    HashMap localHashMap1 = this.jdField_a_of_type_JavaUtilHashMap;
    boolean bool = true;
    if (paramInt != 0) {}
    try
    {
      a("param_FailCode", String.valueOf(paramInt), null, 0, null);
      bool = false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
      {
        HashMap localHashMap2 = (HashMap)this.jdField_a_of_type_JavaUtilHashMap.clone();
        this.jdField_a_of_type_JavaUtilHashMap.clear();
        StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramEmoticonPackage), bool, 0L, 0L, localHashMap2, "");
      }
      return;
    }
    finally {}
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, int paramInt, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "download emoji report actionResult=" + paramInt + ",epId=" + paramEmoticonPackage.epId + ",downloadTime=" + paramLong);
    }
    int j = 0;
    if (paramInt != 0) {
      j = 1;
    }
    paramInt = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "EMOJI_DOWN", a(paramEmoticonPackage), 0, j, paramEmoticonPackage.epId + "", paramInt + "", "", String.valueOf(paramLong));
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener) {}
  
  public void a(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmoticonPackage ep:" + paramEmoticonPackage);
    }
    Object localObject2 = EmosmUtils.getEmosmJsonUrl(paramEmoticonPackage.epId);
    Object localObject1 = new File(EmosmUtils.getEmosmJsonFile(paramEmoticonPackage.epId));
    localObject2 = new DownloadTask((String)localObject2, (File)localObject1);
    ((DownloadTask)localObject2).h = true;
    int j = DownloaderFactory.a((DownloadTask)localObject2, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (j != 0)
    {
      j = EmosmUtils.checkResultCode(j);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramEmoticonPackage, j);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localObject2 = new Bundle();
    ((Bundle)localObject2).putSerializable("emoticonPackage", paramEmoticonPackage);
    ((Bundle)localObject2).putBoolean("newPkgAdd", paramBoolean);
    paramBoolean = EmoticonUtils.a(paramEmoticonPackage);
    if (!paramBoolean)
    {
      a(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
      b(localArrayList, localHashMap, paramEmoticonPackage, (Bundle)localObject2);
    }
    j = a((File)localObject1, paramEmoticonPackage, paramBoolean, localArrayList, localHashMap, (Bundle)localObject2, 14);
    if (j == 0)
    {
      localObject1 = new DownloadTask(localArrayList, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
      a().a((DownloadTask)localObject1, paramDownloadListener, (Bundle)localObject2);
    }
    for (;;)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006648", "0X8006648", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleEmoticonPackage| ep download finish resultCode:" + j + " epId:" + paramEmoticonPackage.epId);
      return;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramEmoticonPackage, j);
    }
  }
  
  public void a(EmoticonPackage paramEmoticonPackage, boolean paramBoolean)
  {
    if ((paramEmoticonPackage == null) || (paramEmoticonPackage.epId == null)) {}
    HashMap localHashMap;
    do
    {
      do
      {
        return;
      } while (a().a("vipEmoticonKey_" + paramEmoticonPackage.epId) != null);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "try to pullEmoticonPackage ep:" + paramEmoticonPackage.epId);
      }
      if (EmosmUtils.isNumeral(paramEmoticonPackage.epId)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ep.epId=" + paramEmoticonPackage.epId + " isNumeral false.");
      }
      localHashMap = new HashMap();
      localHashMap.put("param_FailCode", Integer.toString(11024));
      localHashMap.put("param_epId", paramEmoticonPackage.epId);
    } while (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null);
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), a(paramEmoticonPackage), false, 0L, 0L, localHashMap, "");
    return;
    if (!paramEmoticonPackage.isMagicFaceDownloading) {
      if ((paramEmoticonPackage.status != 2) || (!EmoticonUtils.a(paramEmoticonPackage.updateFlag))) {
        break label273;
      }
    }
    for (;;)
    {
      paramEmoticonPackage.valid = true;
      a().a(paramEmoticonPackage);
      a().a(paramEmoticonPackage.epId);
      ThreadManager.a(new ifa(this, paramEmoticonPackage, paramBoolean));
      return;
      label273:
      paramEmoticonPackage.status = 0;
    }
  }
  
  public void a(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return;
      paramString = a().a("vipEmoticonKey_" + paramString);
    } while (paramString == null);
    paramString.a(true);
  }
  
  public void a(String paramString, int paramInt)
  {
    a(paramString, paramInt, this.jdField_f_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void a(String paramString1, int paramInt1, SogouEmoji.OnEmojiJsonBackSogou paramOnEmojiJsonBackSogou, int paramInt2, String paramString2)
  {
    this.jdField_b_of_type_JavaUtilMap.put(paramString1, new Object[] { paramOnEmojiJsonBackSogou, Integer.valueOf(paramInt2), paramString1, paramString2 });
    a(paramString1, paramInt1, this.jdField_f_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void a(String paramString, int paramInt, DownloadListener paramDownloadListener)
  {
    if (a(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|epId is in downloading:" + paramString);
      }
      return;
    }
    Object localObject2 = a().a(paramString);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson|emoPackage is not exist:" + paramString);
      }
      localObject1 = new EmoticonPackage();
      ((EmoticonPackage)localObject1).epId = paramString;
      ((EmoticonPackage)localObject1).status = 0;
    }
    a().a((EmoticonPackage)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "startDownloadEmosmJson epId:" + ((EmoticonPackage)localObject1).epId);
    }
    paramString = new DownloadTask(EmosmUtils.getEmosmJsonUrl(paramString), new File(EmosmUtils.getEmosmJsonFile(paramString)));
    localObject2 = new Bundle();
    ((Bundle)localObject2).putInt("jsonType", paramInt);
    ((Bundle)localObject2).putSerializable("emoticonPackage", (Serializable)localObject1);
    paramString.e = this.h;
    a().a(paramString, paramDownloadListener, (Bundle)localObject2);
  }
  
  public void a(String paramString1, String paramString2)
  {
    a(paramString1, paramString2, null, 0, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if ((paramString1 == null) || (paramString1.length() <= 0) || (paramString2 == null) || (paramString2.length() <= 0)) {}
    while (("param_error".equals(paramString1)) || ("param_resp_content_read".equals(paramString1)) || ("param_resp_content".equals(paramString1)) || ("param_try_count".equals(paramString1))) {
      return;
    }
    if (("param_step".equals(paramString1)) && (Integer.toString(5).equals(paramString2)))
    {
      if ((paramString3 != null) && (paramString3.length() > 0)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_key_seq", paramString3);
      }
      if (paramInt > 0) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_encrypt_keys", Integer.toString(paramInt));
      }
      if ((paramString4 != null) && (paramString4.length() > 0)) {
        this.jdField_a_of_type_JavaUtilHashMap.put("param_timeout", paramString4);
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public boolean a()
  {
    if (-1L == jdField_a_of_type_Long)
    {
      jdField_a_of_type_Long = System.currentTimeMillis();
      return true;
    }
    if (-1L == jdField_b_of_type_Long)
    {
      jdField_b_of_type_Long = System.currentTimeMillis();
      return true;
    }
    long l = System.currentTimeMillis();
    if (l - jdField_a_of_type_Long > 30000L)
    {
      jdField_a_of_type_Long = jdField_b_of_type_Long;
      jdField_b_of_type_Long = l;
      return true;
    }
    return false;
  }
  
  public boolean a(int paramInt)
  {
    return (paramInt == 3) || (paramInt == 4) || (paramInt == 2);
  }
  
  public boolean a(Emoticon paramEmoticon, int paramInt)
  {
    if ((paramEmoticon == null) || (paramEmoticon.epId == null) || (paramEmoticon.eId == null)) {}
    while (a().a("vipEmoticonKey_" + paramEmoticon.epId) == null) {
      return false;
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {}
    do
    {
      return false;
      paramString = EmosmUtils.getEmosmJsonUrl(paramString);
      paramString = a().a(paramString);
    } while ((paramString == null) || (paramString.b()));
    return true;
  }
  
  public boolean a(String paramString, int paramInt)
  {
    Object localObject1;
    Object localObject2;
    int j;
    if (paramInt == jdField_f_of_type_Int)
    {
      localObject1 = MagicfaceResLoader.a();
      String str = EmosmUtils.getEmoticonPackageFolder(paramString) + (String)localObject1 + File.separator + "video.ini";
      File localFile = new File(str);
      localObject2 = localFile;
      if (!localFile.exists())
      {
        localObject1 = "big";
        str = EmosmUtils.getEmoticonPackageFolder(paramString) + "big" + File.separator + "video.ini";
        localFile = new File(str);
        localObject2 = localFile;
        if (!localFile.exists()) {
          return false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.jdField_a_of_type_JavaLangString, 2, "videoConfigPath ==" + str);
      }
      localObject2 = FileUtils.a((File)localObject2).split("&");
      j = localObject2.length;
      paramInt = 0;
      while (paramInt < j)
      {
        str = localObject2[paramInt];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + (String)localObject1 + File.separator + str).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == jdField_e_of_type_Int)
    {
      localObject1 = new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini");
      if (!((File)localObject1).exists()) {
        return false;
      }
      localObject1 = FileUtils.a((File)localObject1).split("&");
      j = localObject1.length;
      paramInt = 0;
      while (paramInt < j)
      {
        localObject2 = localObject1[paramInt];
        if (!new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + (String)localObject2).exists()) {
          return false;
        }
        paramInt += 1;
      }
    }
    if (paramInt == g)
    {
      localObject2 = EmosmUtils.getEmoticonPackageFolder(paramString) + "png";
      localObject1 = new File((String)localObject2);
      localObject2 = new File((String)localObject2 + File.separator + "png.jtmp");
      if ((!((File)localObject1).exists()) || (!((File)localObject2).exists()))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "func checkPackageIntact, PNG is not intact.");
        }
        return false;
      }
      paramString = this.jdField_a_of_type_ComTencentMobileqqMagicfaceDrawablePngFrameManager.a(paramString);
      if (paramString == null) {
        return false;
      }
      return paramString.a();
    }
    return true;
  }
  
  public boolean a(String paramString, Boolean paramBoolean)
  {
    boolean bool = b(paramString, paramBoolean);
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!bool) {
        break label51;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label51:
    while (paramString.status == 0) {
      return bool;
    }
    paramString.status = 0;
    a().a(paramString);
    return bool;
  }
  
  public Bundle b(Bundle paramBundle)
  {
    int j = 1;
    Object localObject = paramBundle.getString("id");
    int m = paramBundle.getInt("businessType");
    if ((paramBundle == null) || (localObject == null) || (((String)localObject).length() == 0)) {
      j = 0;
    }
    for (;;)
    {
      paramBundle = new Bundle();
      if (j != 0)
      {
        localObject = a((String)localObject, m);
        paramBundle.putInt("result", ((Bundle)localObject).getInt("result"));
        paramBundle.putString("messge", "");
        paramBundle.putInt("id", -1);
        paramBundle.putInt("status", ((Bundle)localObject).getInt("status"));
        paramBundle.putInt("pluginStatus", ((Bundle)localObject).getInt("pluginStatus"));
        paramBundle.putLong("pluginSize", ((Bundle)localObject).getLong("pluginSize"));
        paramBundle.putInt("progress", ((Bundle)localObject).getInt("progress"));
        paramBundle.putInt("dynamicEmojiId", ((Bundle)localObject).getInt("dEmojiId"));
        paramBundle.putStringArrayList("dynamicEmojiList", ((Bundle)localObject).getStringArrayList("srcList"));
        paramBundle.putStringArrayList("urlParamsList", ((Bundle)localObject).getStringArrayList("urlParamsList"));
        return paramBundle;
        try
        {
          k = Integer.parseInt((String)localObject);
          if (k == -1) {
            j = 0;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
            }
            int k = -1;
          }
        }
      }
    }
    paramBundle.putInt("result", 0);
    paramBundle.putString("messge", "");
    paramBundle.putInt("id", -1);
    paramBundle.putInt("status", 0);
    paramBundle.putInt("pluginStatus", 0);
    paramBundle.putLong("pluginSize", 0L);
    paramBundle.putInt("progress", 0);
    paramBundle.putInt("dynamicEmojiId", -1);
    paramBundle.putStringArrayList("dynamicEmojiList", null);
    paramBundle.putStringArrayList("urlParamsList", null);
    return paramBundle;
  }
  
  public void b()
  {
    if (a() != null) {
      a().f();
    }
  }
  
  public void b(EmoticonPackage paramEmoticonPackage)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.c(paramEmoticonPackage);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleQFaceGifPackage ep:" + paramEmoticonPackage);
    }
    ArrayList localArrayList1 = (ArrayList)a().a(paramEmoticonPackage.epId);
    if (localArrayList1 == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, 0, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleQFaceGifPackage|epId:" + paramEmoticonPackage.epId + " has not any emoticon");
      }
      return;
    }
    ArrayList localArrayList2 = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList2, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList2, localHashMap, paramEmoticonPackage, localBundle);
    int j = a(paramEmoticonPackage, localArrayList1, localArrayList2, localHashMap, localBundle, 14);
    if (j != 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a(paramEmoticonPackage, j);
      return;
    }
    paramEmoticonPackage = new DownloadTask(localArrayList2, localHashMap, "vipEmoticonKey_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.e = this.h;
    a().a(paramEmoticonPackage, paramDownloadListener, localBundle);
  }
  
  public void b(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "ep:" + paramEmoticonPackage);
    }
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleMagicFacePackage| netUnSupport epId=" + paramEmoticonPackage.epId);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, 11003, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    localBundle.putBoolean("newPkgAdd", paramBoolean);
    Object localObject;
    int j;
    if (!paramEmoticonPackage.isMagicFaceDownloading)
    {
      localObject = "vipEmoticonKey_" + paramEmoticonPackage.epId;
      String str = EmosmUtils.getEmosmJsonUrl(paramEmoticonPackage.epId);
      File localFile = new File(EmosmUtils.getEmosmJsonFile(paramEmoticonPackage.epId));
      int m = DownloaderFactory.a(new DownloadTask(str, localFile), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      j = EmosmUtils.checkResultCode(m);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, j);
      if (m != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a(paramEmoticonPackage, j, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        a("param_error", "json download fail");
        a(paramEmoticonPackage, j);
        return;
      }
      int k = a(localFile, paramEmoticonPackage, false, localArrayList, localHashMap, localBundle, 15);
      j = k;
      if (k != 0)
      {
        j = EmosmUtils.checkResultCode(m);
        a("param_error", "json data is null");
        a(paramEmoticonPackage, j);
      }
    }
    for (;;)
    {
      b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      c(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      d(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
      localObject = new DownloadTask(localArrayList, localHashMap, (String)localObject);
      a().a((DownloadTask)localObject, paramDownloadListener, localBundle);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80065A7", "0X80065A7", 0, 0, "", "", "", "");
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "handleMagicFacePackage| ep download finish resultCode:" + j + " epId:" + paramEmoticonPackage.epId);
      return;
      localObject = "vipEmoticonKey_auto_" + paramEmoticonPackage.epId;
      j = 0;
    }
  }
  
  public boolean b(Emoticon paramEmoticon, int paramInt)
  {
    long l = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon|taskvalue:" + paramInt + "，epid:" + paramEmoticon.epId + "，eid=" + paramEmoticon.eId);
    }
    if (Utils.e())
    {
      if (Utils.b() < 1048576L)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|sdcardcheck,sdcard full .return. epId=" + paramEmoticon.epId);
        }
        return false;
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|sdcardcheck,has sdcard FALSE .return. epId=" + paramEmoticon.epId);
      }
      return false;
    }
    Object localObject1;
    if ((paramInt & 0x2) == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo imgPreview.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      localObject1 = c(paramEmoticon);
      if (DownloaderFactory.a(new DownloadTask(localObject1[0], new File(localObject1[1])), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
      {
        a("param_step", String.valueOf(6));
        a(paramEmoticon, 11011, l);
        return false;
      }
    }
    File localFile;
    DownloadTask localDownloadTask;
    Object localObject2;
    if ((paramInt & 0x4) == 4)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo gif.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
      }
      localObject1 = null;
      if (paramEmoticon.jobType == 1) {
        localObject1 = d(paramEmoticon);
      }
      do
      {
        localFile = new File(localObject1[1]);
        localDownloadTask = new DownloadTask(localObject1[0], localFile);
        if (DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) == 0) {
          break;
        }
        a("param_step", String.valueOf(7));
        a(paramEmoticon, 11011, l);
        return false;
        if ((paramInt & 0x4) == 4) {
          localObject1 = a(paramEmoticon, 0);
        }
        localObject2 = new ReqInfo();
        a(paramEmoticon, (ReqInfo)localObject2);
      } while ((paramEmoticon.encryptKey != null) && (paramEmoticon.encryptKey.length() != 0));
      paramInt = ((ReqInfo)localObject2).a();
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "qq_error|Emotiocon need EncryptKey, fetched fail. resultCode=" + paramInt + "pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + 4 + " time:" + System.currentTimeMillis());
      }
      a("param_step", String.valueOf(5));
      a(paramEmoticon, paramInt, l);
      return false;
      if (paramEmoticon.jobType != 1)
      {
        localObject2 = null;
        localObject1 = null;
        if (localFile == null) {
          break label1240;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = FileUtils.a(localFile);
        localObject1 = localFile.getAbsolutePath();
        localFile.delete();
      }
      catch (Throwable localThrowable)
      {
        int j;
        localThrowable.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress|qq_error| Emotiocon encode resource fail .EXCEPTION:" + localThrowable.toString() + " time:" + System.currentTimeMillis() + " url=" + localDownloadTask.b);
        a(paramEmoticon, 11019, l);
        return false;
      }
      a(paramEmoticon, 11019, l);
      return false;
      j = EmosmUtils.saveEmosm((byte[])localObject2, paramEmoticon.encryptKey, (String)localObject1);
      if (j != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress|qq_error|download encrypt exception, url=" + localDownloadTask.b);
        }
        if ((Utils.e()) && (Utils.b() > 1048576L)) {
          FileUtils.a(AppConstants.aG + "err" + File.separator + String.valueOf(paramEmoticon.epId) + "_" + paramEmoticon.encryptKey + "_" + localFile.getName(), (byte[])localObject2, false);
        }
        a(paramEmoticon, 11017, l);
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "onProgress| Emotiocon encode resource done.result=" + j + " time:" + System.currentTimeMillis() + " url=" + localDownloadTask.b);
      }
      if ((paramInt & 0x1) == 1)
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo AIO preview static.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt);
        }
        localObject1 = b(paramEmoticon);
        if (DownloaderFactory.a(new DownloadTask(localObject1[0], new File(localObject1[1])), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
        {
          a("param_step", String.valueOf(8));
          a(paramEmoticon, 11011, l);
          return false;
        }
      }
      String[] arrayOfString;
      if ((paramEmoticon.isSound) && ((paramInt & 0x8) == 8))
      {
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "downloadAIOEmoticon| Emoticon download emo sound.pid=" + paramEmoticon.epId + " eid=" + paramEmoticon.eId + " type=" + paramInt + " time:" + System.currentTimeMillis());
        }
        arrayOfString = a(paramEmoticon);
        if (DownloaderFactory.a(new DownloadTask(arrayOfString[0], new File(arrayOfString[1])), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface) != 0)
        {
          a("param_step", String.valueOf(9), null, 0, null);
          a(paramEmoticon, 11011, l);
          return false;
        }
      }
      return true;
      label1240:
      if (localObject2 != null) {
        if (arrayOfString != null) {}
      }
    }
  }
  
  public boolean b(String paramString)
  {
    boolean bool = d(paramString);
    paramString = a().a(paramString);
    if (paramString != null)
    {
      if (!bool) {
        break label50;
      }
      if (paramString.status != 2)
      {
        paramString.status = 2;
        a().a(paramString);
      }
    }
    label50:
    while (paramString.status == 0) {
      return bool;
    }
    paramString.status = 0;
    a().a(paramString);
    return bool;
  }
  
  public void c(EmoticonPackage paramEmoticonPackage, DownloadListener paramDownloadListener)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("emoticonPackage", paramEmoticonPackage);
    a(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    b(localArrayList, localHashMap, paramEmoticonPackage, localBundle);
    paramEmoticonPackage = new DownloadTask(localArrayList, localHashMap, "vipEmoticonKey_cover_" + paramEmoticonPackage.epId);
    paramEmoticonPackage.e = this.h;
    a().a(paramEmoticonPackage, paramDownloadListener, localBundle);
  }
  
  public boolean c(Emoticon paramEmoticon, int paramInt)
  {
    boolean bool1;
    if (paramEmoticon == null)
    {
      bool1 = true;
      return bool1;
    }
    String str;
    if ((paramInt & 0x1) == 1) {
      if (paramEmoticon.jobType == 1) {
        str = EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId);
      }
    }
    label36:
    for (boolean bool2 = FileUtil.a(str);; bool2 = true)
    {
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if ((paramInt & 0x4) == 4) {
          if (paramEmoticon.jobType != 1) {
            break label182;
          }
        }
      }
      label182:
      for (str = EmosmUtils.getQFaceGifPath(paramEmoticon.epId, paramEmoticon.eId);; str = EmosmUtils.getEmoticonEncryptPath(paramEmoticon.epId, paramEmoticon.eId))
      {
        bool1 = FileUtil.a(str);
        bool2 = bool1;
        if (bool1)
        {
          bool2 = bool1;
          if ((paramInt & 0x2) == 2) {
            bool2 = FileUtil.a(EmosmUtils.getEmoticonPreviewPath(paramEmoticon.epId, paramEmoticon.eId));
          }
        }
        bool1 = bool2;
        if (!bool2) {
          break;
        }
        bool1 = bool2;
        if (!paramEmoticon.isSound) {
          break;
        }
        bool1 = bool2;
        if ((paramInt & 0x8) != 8) {
          break;
        }
        return FileUtil.a(EmosmUtils.getEmoticonSoundPath(paramEmoticon.epId, paramEmoticon.eId));
        str = EmosmUtils.getEmoticonAIOPreviewPath(paramEmoticon.epId, paramEmoticon.eId);
        break label36;
      }
    }
  }
  
  public boolean c(String paramString)
  {
    return new File(EmosmUtils.getEmoticonPackageFolder(paramString) + "audio" + File.separator + "audio.ini").exists();
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "clear History. uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount() + " app=" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonEmojiListenerManager.a();
    ??? = (EmosmHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(11);
    if (??? != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        ((EmosmHandler)???).b((EmosmHandler.EmosmHandlerListener)localIterator.next());
      }
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if (a() != null) {
      a().e();
    }
    if (this.jdField_b_of_type_JavaUtilMap != null) {
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
    synchronized (this.jdField_a_of_type_JavaUtilMap)
    {
      this.jdField_a_of_type_JavaUtilMap.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager
 * JD-Core Version:    0.7.0.1
 */
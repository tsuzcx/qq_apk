package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.struct.PicAndAdConf;
import com.tencent.mobileqq.struct.NearbyPushBanner;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hxk;
import hxl;
import hxm;
import hxn;
import hxo;
import hxp;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mqq.manager.Manager;

public class NearbyBannerManager
  implements Manager
{
  public static final int a = 0;
  public static final String a = "NearbyBanner.Manager";
  public static final int b = 1;
  public static final String b = "NearbyBanner.Config";
  public static final int c = 2;
  public static final String c = "NearbyBannerPic";
  private static final int jdField_e_of_type_Int = 20;
  private static final String jdField_e_of_type_JavaLangString = "nearby_banner_sp";
  private static final int jdField_f_of_type_Int = 10;
  private static final String jdField_f_of_type_JavaLangString = "key_config_ver";
  private static final String g = "key_expired_banner";
  private static final String h = "nearby_banner";
  private static final String j = "|";
  private SharedPreferences jdField_a_of_type_AndroidContentSharedPreferences;
  private Handler jdField_a_of_type_AndroidOsHandler = new hxk(this, ThreadManager.a());
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private PicAndAdConf jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf;
  public LinkedList a;
  private volatile int d;
  public String d;
  private String i;
  
  public NearbyBannerManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentSharedPreferences = paramQQAppInterface.a().getSharedPreferences("nearby_banner_sp" + paramQQAppInterface.a(), 0);
    this.jdField_d_of_type_Int = this.jdField_a_of_type_AndroidContentSharedPreferences.getInt("key_config_ver", 0);
    this.i = (paramQQAppInterface.a().getFilesDir().getAbsolutePath() + "/" + paramQQAppInterface.a());
    this.jdField_d_of_type_JavaLangString = (paramQQAppInterface.a().getFilesDir().getAbsolutePath() + "/" + "NearbyBannerPic");
  }
  
  private void a()
  {
    try
    {
      Object localObject = new File(this.jdField_d_of_type_JavaLangString);
      int k;
      if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
      {
        localObject = Arrays.asList(((File)localObject).listFiles());
        if (((List)localObject).size() > 10)
        {
          Collections.sort((List)localObject, new hxp(this));
          k = 10;
        }
      }
      else
      {
        while (k < ((List)localObject).size())
        {
          a((File)((List)localObject).get(k));
          k += 1;
          continue;
          if (((File)localObject).isFile()) {
            a((File)localObject);
          }
        }
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void a(int paramInt)
  {
    this.jdField_d_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("key_config_ver", paramInt).commit();
  }
  
  private void a(File paramFile)
  {
    try
    {
      if (paramFile.exists())
      {
        if (paramFile.isFile())
        {
          paramFile.delete();
          return;
        }
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          if (paramFile != null)
          {
            int k = 0;
            while (k < paramFile.length)
            {
              a(paramFile[k]);
              k += 1;
            }
          }
        }
      }
      return;
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBanner.Manager", 2, "", paramFile);
      }
    }
  }
  
  private void a(boolean paramBoolean, List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new hxo(this, paramBoolean, paramList));
  }
  
  /* Error */
  private boolean a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: new 221	com/tencent/mobileqq/config/struct/PicAndAdConf
    //   8: dup
    //   9: bipush 21
    //   11: iconst_2
    //   12: invokespecial 224	com/tencent/mobileqq/config/struct/PicAndAdConf:<init>	(SB)V
    //   15: astore 6
    //   17: new 108	java/io/File
    //   20: dup
    //   21: new 77	java/lang/StringBuilder
    //   24: dup
    //   25: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   28: aload_0
    //   29: getfield 115	com/tencent/mobileqq/config/NearbyBannerManager:i	Ljava/lang/String;
    //   32: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 113
    //   37: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: ldc 34
    //   42: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 128	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_2
    //   52: aload_2
    //   53: invokevirtual 132	java/io/File:exists	()Z
    //   56: ifeq +162 -> 218
    //   59: aload_2
    //   60: invokevirtual 227	java/io/File:canRead	()Z
    //   63: ifeq +155 -> 218
    //   66: aload_2
    //   67: invokevirtual 231	java/io/File:length	()J
    //   70: lconst_0
    //   71: lcmp
    //   72: ifle +146 -> 218
    //   75: new 233	java/io/FileInputStream
    //   78: dup
    //   79: aload_2
    //   80: invokespecial 235	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: astore_2
    //   84: new 237	java/io/DataInputStream
    //   87: dup
    //   88: aload_2
    //   89: invokespecial 240	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   92: astore_3
    //   93: aload 6
    //   95: aload_3
    //   96: invokevirtual 243	com/tencent/mobileqq/config/struct/PicAndAdConf:a	(Ljava/io/DataInputStream;)V
    //   99: aload 6
    //   101: invokevirtual 245	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()Z
    //   104: ifeq +8 -> 112
    //   107: aload 6
    //   109: invokevirtual 246	com/tencent/mobileqq/config/struct/PicAndAdConf:a	()V
    //   112: aload_2
    //   113: ifnull +7 -> 120
    //   116: aload_2
    //   117: invokevirtual 249	java/io/FileInputStream:close	()V
    //   120: aload_3
    //   121: ifnull +7 -> 128
    //   124: aload_3
    //   125: invokevirtual 250	java/io/DataInputStream:close	()V
    //   128: iconst_0
    //   129: istore_1
    //   130: iload_1
    //   131: ifeq +149 -> 280
    //   134: aload_0
    //   135: iconst_0
    //   136: invokespecial 191	com/tencent/mobileqq/config/NearbyBannerManager:a	(I)V
    //   139: iload_1
    //   140: ifne +149 -> 289
    //   143: iconst_1
    //   144: ireturn
    //   145: astore_2
    //   146: aconst_null
    //   147: astore_3
    //   148: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +12 -> 163
    //   154: ldc 12
    //   156: iconst_2
    //   157: ldc 206
    //   159: aload_2
    //   160: invokestatic 209	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   163: aload 4
    //   165: ifnull +8 -> 173
    //   168: aload 4
    //   170: invokevirtual 249	java/io/FileInputStream:close	()V
    //   173: aload_3
    //   174: ifnull -46 -> 128
    //   177: aload_3
    //   178: invokevirtual 250	java/io/DataInputStream:close	()V
    //   181: goto -53 -> 128
    //   184: astore_2
    //   185: goto -57 -> 128
    //   188: astore_2
    //   189: aconst_null
    //   190: astore 5
    //   192: aload_3
    //   193: astore 4
    //   195: aload 5
    //   197: astore_3
    //   198: aload 4
    //   200: ifnull +8 -> 208
    //   203: aload 4
    //   205: invokevirtual 249	java/io/FileInputStream:close	()V
    //   208: aload_3
    //   209: ifnull +7 -> 216
    //   212: aload_3
    //   213: invokevirtual 250	java/io/DataInputStream:close	()V
    //   216: aload_2
    //   217: athrow
    //   218: invokestatic 204	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   221: ifeq +54 -> 275
    //   224: ldc 12
    //   226: iconst_2
    //   227: new 77	java/lang/StringBuilder
    //   230: dup
    //   231: invokespecial 78	java/lang/StringBuilder:<init>	()V
    //   234: ldc 252
    //   236: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: aload_2
    //   240: invokevirtual 132	java/io/File:exists	()Z
    //   243: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   246: ldc_w 257
    //   249: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload_2
    //   253: invokevirtual 227	java/io/File:canRead	()Z
    //   256: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   259: ldc_w 259
    //   262: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload_2
    //   266: invokevirtual 262	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   269: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   272: invokestatic 265	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   275: iconst_1
    //   276: istore_1
    //   277: goto -147 -> 130
    //   280: aload_0
    //   281: aload 6
    //   283: putfield 122	com/tencent/mobileqq/config/NearbyBannerManager:jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf	Lcom/tencent/mobileqq/config/struct/PicAndAdConf;
    //   286: goto -147 -> 139
    //   289: iconst_0
    //   290: ireturn
    //   291: astore_2
    //   292: goto -172 -> 120
    //   295: astore_2
    //   296: goto -168 -> 128
    //   299: astore_2
    //   300: goto -127 -> 173
    //   303: astore 4
    //   305: goto -97 -> 208
    //   308: astore_3
    //   309: goto -93 -> 216
    //   312: astore 5
    //   314: aconst_null
    //   315: astore_3
    //   316: aload_2
    //   317: astore 4
    //   319: aload 5
    //   321: astore_2
    //   322: goto -124 -> 198
    //   325: astore 5
    //   327: aload_2
    //   328: astore 4
    //   330: aload 5
    //   332: astore_2
    //   333: goto -135 -> 198
    //   336: astore_2
    //   337: goto -139 -> 198
    //   340: astore 5
    //   342: aconst_null
    //   343: astore_3
    //   344: aload_2
    //   345: astore 4
    //   347: aload 5
    //   349: astore_2
    //   350: goto -202 -> 148
    //   353: astore 5
    //   355: aload_2
    //   356: astore 4
    //   358: aload 5
    //   360: astore_2
    //   361: goto -213 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	364	0	this	NearbyBannerManager
    //   129	148	1	k	int
    //   51	66	2	localObject1	Object
    //   145	15	2	localException1	Exception
    //   184	1	2	localException2	Exception
    //   188	78	2	localObject2	Object
    //   291	1	2	localException3	Exception
    //   295	1	2	localException4	Exception
    //   299	18	2	localException5	Exception
    //   321	12	2	localObject3	Object
    //   336	9	2	localObject4	Object
    //   349	12	2	localObject5	Object
    //   1	212	3	localObject6	Object
    //   308	1	3	localException6	Exception
    //   315	29	3	localObject7	Object
    //   3	201	4	localObject8	Object
    //   303	1	4	localException7	Exception
    //   317	40	4	localObject9	Object
    //   190	6	5	localObject10	Object
    //   312	8	5	localObject11	Object
    //   325	6	5	localObject12	Object
    //   340	8	5	localException8	Exception
    //   353	6	5	localException9	Exception
    //   15	267	6	localPicAndAdConf	PicAndAdConf
    // Exception table:
    //   from	to	target	type
    //   75	84	145	java/lang/Exception
    //   177	181	184	java/lang/Exception
    //   75	84	188	finally
    //   116	120	291	java/lang/Exception
    //   124	128	295	java/lang/Exception
    //   168	173	299	java/lang/Exception
    //   203	208	303	java/lang/Exception
    //   212	216	308	java/lang/Exception
    //   84	93	312	finally
    //   93	112	325	finally
    //   148	163	336	finally
    //   84	93	340	java/lang/Exception
    //   93	112	353	java/lang/Exception
  }
  
  private boolean a(long paramLong1, long paramLong2)
  {
    if ((paramLong1 == 0L) || (paramLong2 == 0L)) {}
    long l;
    do
    {
      return false;
      l = System.currentTimeMillis();
    } while ((l <= paramLong1) || (l >= paramLong2));
    return true;
  }
  
  private void b(BaseActivity paramBaseActivity)
  {
    boolean bool1;
    ArrayList localArrayList;
    int m;
    Set localSet;
    int k;
    label92:
    NearbyPushBanner localNearbyPushBanner;
    if (this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf != null)
    {
      bool2 = true;
      bool1 = bool2;
      if (!bool2) {
        bool1 = a();
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBanner.Manager", 2, "parseBannerList | parse config = " + bool1);
      }
      localArrayList = new ArrayList();
      bool2 = bool1;
      if (!bool1) {
        break label648;
      }
      m = this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.b();
      localSet = a();
      k = 0;
      if (k >= m) {
        break label592;
      }
      localNearbyPushBanner = new NearbyPushBanner(this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k), this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.b(k), this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k));
      bool1 = localNearbyPushBanner.a(this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.d(k));
      localNearbyPushBanner.m = this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.c(k);
      if ((localNearbyPushBanner.c == null) || (!localNearbyPushBanner.c.contains("|"))) {
        break label333;
      }
      long l1 = Long.parseLong(localNearbyPushBanner.c.substring(0, localNearbyPushBanner.c.indexOf("|")));
      long l2 = Long.parseLong(localNearbyPushBanner.c.substring(localNearbyPushBanner.c.indexOf("|") + 1));
      if (a(l1, l2)) {
        break label333;
      }
      if (QLog.isColorLevel()) {
        QLog.d("NearbyBanner.Manager", 2, "parseBannerList | banner is outdate, cid = " + this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k) + ", endTime = " + TimeFormatterUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), l2) + ", startTime = " + TimeFormatterUtils.c(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), l1));
      }
    }
    for (;;)
    {
      k += 1;
      break label92;
      bool2 = false;
      break;
      label333:
      if (localSet.contains(this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k) + this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.c(k)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyBanner.Manager", 2, "parseBannerList | banner has deleted, cid = " + this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k));
        }
      }
      else
      {
        if ((bool1) && (!TextUtils.isEmpty(localNearbyPushBanner.j)))
        {
          localNearbyPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction = JumpParser.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramBaseActivity, localNearbyPushBanner.j);
          if (localNearbyPushBanner.jdField_a_of_type_ComTencentMobileqqUtilsJumpAction == null)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("NearbyBanner.Manager", 2, "parseBannerList | jumpAction invalid, cid = " + this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k) + " dest = " + localNearbyPushBanner.j);
            continue;
          }
        }
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k);
        if (localBitmap == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NearbyBanner.Manager", 2, "parseBannerList | bitmap is null, cid = " + this.jdField_a_of_type_ComTencentMobileqqConfigStructPicAndAdConf.a(k));
          }
        }
        else
        {
          localNearbyPushBanner.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
          localArrayList.add(localNearbyPushBanner);
        }
      }
    }
    label592:
    boolean bool2 = bool1;
    if (QLog.isColorLevel())
    {
      QLog.d("NearbyBanner.Manager", 2, "parseBannerList | orgin banner count = " + m + " | fit count = " + localArrayList.size());
      bool2 = bool1;
    }
    label648:
    a(bool2, localArrayList);
  }
  
  public int a()
  {
    return this.jdField_d_of_type_Int;
  }
  
  public Set a()
  {
    return new HashSet(Arrays.asList(this.jdField_a_of_type_AndroidContentSharedPreferences.getString("key_expired_banner", "").split("\\|")));
  }
  
  public void a(BaseActivity paramBaseActivity)
  {
    ThreadManager.a().post(new hxl(this, paramBaseActivity));
  }
  
  public void a(NearbyBannerManager.INearbyBannerListener paramINearbyBannerListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.add(paramINearbyBannerListener);
  }
  
  public void a(PicAndAdConf paramPicAndAdConf, int paramInt)
  {
    ThreadManager.a().post(new hxn(this, paramPicAndAdConf, paramInt));
  }
  
  public void a(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (paramList != null)
    {
      int k = 0;
      try
      {
        while (k < paramList.size())
        {
          localArrayList1.add(((NearbyPushBanner)paramList.get(k)).jdField_a_of_type_JavaLangString);
          localArrayList2.add(((NearbyPushBanner)paramList.get(k)).m);
          k += 1;
        }
        this.jdField_a_of_type_AndroidOsHandler.post(new hxm(this, localArrayList1, localArrayList2));
      }
      catch (Exception paramList)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NearbyBanner.Manager", 2, "removeAllBanners encounter exception", paramList);
        }
      }
    }
  }
  
  public void b(NearbyBannerManager.INearbyBannerListener paramINearbyBannerListener)
  {
    this.jdField_a_of_type_JavaUtilLinkedList.remove(paramINearbyBannerListener);
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.NearbyBannerManager
 * JD-Core Version:    0.7.0.1
 */
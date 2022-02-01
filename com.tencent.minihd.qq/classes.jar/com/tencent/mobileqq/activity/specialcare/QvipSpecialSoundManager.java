package com.tencent.mobileqq.activity.specialcare;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import haj;
import hak;
import hal;
import ham;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QvipSpecialSoundManager
{
  public static final int a = 1000277;
  public static final String a = "key_special_sound_list";
  public static HashMap a;
  private static final String b = "QvipSpecialSoundManager";
  public static HashMap b = new HashMap();
  private static final String c = "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json";
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  static
  {
    jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public QvipSpecialSoundManager(Context paramContext, AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  private String a()
  {
    Object localObject = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "https://i.gtimg.cn/club/moblie/special_sound/sound_config.json");
    if (!((File)localObject).exists()) {}
    for (;;)
    {
      try
      {
        DownloadTask localDownloadTask = new DownloadTask("https://i.gtimg.cn/club/moblie/special_sound/sound_config.json", (File)localObject);
        localDownloadTask.a = 1;
        i = DownloaderFactory.a(localDownloadTask, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (i != 0) {
          break label171;
        }
        if (localObject != null)
        {
          l = ((File)localObject).length();
          a(l);
          i = 1;
          if (i != 0) {
            break label112;
          }
          b("downLoad Special Sound Config failed.");
          return "";
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
        i = -1;
        continue;
        long l = 0L;
        continue;
      }
      int i = 1;
      continue;
      try
      {
        label112:
        localObject = a((File)localObject);
        return localObject;
      }
      catch (IOException localIOException)
      {
        b("decodeTextFile is IOException.");
        localIOException.printStackTrace();
        return "";
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        for (;;)
        {
          b("decodeTextFile is OutOfMemoryError.");
          localOutOfMemoryError.printStackTrace();
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          b("decodeTextFile is exception.");
          localException1.printStackTrace();
        }
      }
      label171:
      i = 0;
    }
  }
  
  /* Error */
  private String a(File paramFile)
  {
    // Byte code:
    //   0: new 123	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 126	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   8: astore_1
    //   9: new 128	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 129	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore 4
    //   18: sipush 4096
    //   21: newarray byte
    //   23: astore_3
    //   24: aload_1
    //   25: aload_3
    //   26: iconst_0
    //   27: sipush 4096
    //   30: invokevirtual 135	java/io/InputStream:read	([BII)I
    //   33: istore_2
    //   34: iload_2
    //   35: iconst_m1
    //   36: if_icmpeq +50 -> 86
    //   39: aload 4
    //   41: aload_3
    //   42: iconst_0
    //   43: iload_2
    //   44: invokevirtual 139	java/io/ByteArrayOutputStream:write	([BII)V
    //   47: goto -23 -> 24
    //   50: astore_3
    //   51: aload_3
    //   52: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   55: aload_1
    //   56: ifnull +7 -> 63
    //   59: aload_1
    //   60: invokevirtual 142	java/io/InputStream:close	()V
    //   63: aload 4
    //   65: ifnull +8 -> 73
    //   68: aload 4
    //   70: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   73: ldc 102
    //   75: astore_1
    //   76: aload_1
    //   77: areturn
    //   78: astore_1
    //   79: aload_1
    //   80: invokevirtual 144	java/io/FileNotFoundException:printStackTrace	()V
    //   83: ldc 102
    //   85: areturn
    //   86: new 146	java/lang/String
    //   89: dup
    //   90: aload 4
    //   92: invokevirtual 150	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   95: ldc 152
    //   97: invokespecial 155	java/lang/String:<init>	([BLjava/lang/String;)V
    //   100: astore_3
    //   101: aload_1
    //   102: ifnull +7 -> 109
    //   105: aload_1
    //   106: invokevirtual 142	java/io/InputStream:close	()V
    //   109: aload_3
    //   110: astore_1
    //   111: aload 4
    //   113: ifnull -37 -> 76
    //   116: aload 4
    //   118: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   121: aload_3
    //   122: areturn
    //   123: astore_3
    //   124: aload_1
    //   125: ifnull +7 -> 132
    //   128: aload_1
    //   129: invokevirtual 142	java/io/InputStream:close	()V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 143	java/io/ByteArrayOutputStream:close	()V
    //   142: aload_3
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	QvipSpecialSoundManager
    //   0	144	1	paramFile	File
    //   33	11	2	i	int
    //   23	19	3	arrayOfByte	byte[]
    //   50	2	3	localIOException	IOException
    //   100	22	3	str	String
    //   123	20	3	localObject	Object
    //   16	122	4	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   24	34	50	java/io/IOException
    //   39	47	50	java/io/IOException
    //   86	101	50	java/io/IOException
    //   0	9	78	java/io/FileNotFoundException
    //   24	34	123	finally
    //   39	47	123	finally
    //   51	55	123	finally
    //   86	101	123	finally
  }
  
  private void a(QvipSpecialSoundManager.CallBack paramCallBack, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new ham(this, paramCallBack, paramBoolean));
  }
  
  private void a(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      Object localObject1;
      Object localObject2;
      try
      {
        if ((TextUtils.isEmpty(paramString1)) || (paramString2 == null)) {
          return;
        }
        if (TextUtils.isEmpty(paramString2)) {
          return;
        }
        paramString2 = QvipSpecialSoundConfig.a(new JSONObject(paramString2));
        paramString1 = QvipSpecialSoundConfig.a(new JSONObject(paramString1));
        localObject1 = paramString1.jdField_a_of_type_JavaLangString;
        localObject2 = paramString2.jdField_a_of_type_JavaLangString;
        if ((localObject2 != null) && (!((String)localObject2).equals(localObject1)))
        {
          localObject1 = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
          ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_one", true).commit();
          ((SharedPreferences)localObject1).edit().putBoolean("special_care_red_point_two", true).commit();
        }
        paramString2 = paramString2.jdField_a_of_type_JavaUtilList;
        paramString1 = paramString1.jdField_a_of_type_JavaUtilList;
        if ((paramString2 == null) || (paramString1 == null) || (paramString2.isEmpty()) || (paramString1.isEmpty()) || (paramString2.size() < paramString1.size()))
        {
          b("updateSpecialSound return.");
          return;
        }
      }
      catch (Exception paramString1)
      {
        b("updateSpecialSound exception");
        paramString1.printStackTrace();
        return;
      }
      int j = paramString1.size();
      int i = 0;
      while (i < j)
      {
        localObject1 = (haj)paramString2.get(i);
        localObject2 = (haj)paramString1.get(i);
        if ((((haj)localObject1).jdField_a_of_type_Int == ((haj)localObject2).jdField_a_of_type_Int) && (!((haj)localObject1).jdField_b_of_type_JavaLangString.equals(((haj)localObject2).jdField_b_of_type_JavaLangString))) {
          ThreadManager.a(new hak(this, (haj)localObject1));
        }
        i += 1;
      }
    }
  }
  
  private void a(List paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {
      b("SpecialSoundList is empty, donot need sort.");
    }
    do
    {
      return;
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      int j = paramList.size();
      SharedPreferences.Editor localEditor = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit();
      int i = 0;
      if (i < j)
      {
        haj localhaj = (haj)paramList.get(i);
        if (!b.containsKey(String.valueOf(localhaj.jdField_a_of_type_Int))) {
          b.put(String.valueOf(localhaj.jdField_a_of_type_Int), localhaj);
        }
        localEditor.putString("special_sound_url" + localhaj.jdField_a_of_type_Int, localhaj.jdField_c_of_type_JavaLangString);
        if (!b(localhaj.d)) {
          b("is white list.");
        }
        for (;;)
        {
          i += 1;
          break;
          if (localhaj.jdField_c_of_type_Int == 1) {
            if (localhaj.jdField_b_of_type_Int == 1) {
              localArrayList1.add(localhaj);
            } else if (localhaj.jdField_b_of_type_Int == 2) {
              localArrayList2.add(localhaj);
            } else {
              localArrayList3.add(localhaj);
            }
          }
        }
      }
      localEditor.commit();
      paramList.clear();
      paramList.addAll(localArrayList1);
      paramList.addAll(localArrayList2);
      paramList.addAll(localArrayList3);
    } while (jdField_a_of_type_JavaUtilHashMap.containsKey("key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a()));
    jdField_a_of_type_JavaUtilHashMap.put("key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(), paramList);
  }
  
  private boolean b(String paramString)
  {
    str = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return true;
      if (paramString.contains("|")) {
        try
        {
          String[] arrayOfString = paramString.split("\\|");
          int j = arrayOfString.length;
          int i = 0;
          for (;;)
          {
            if (i >= j) {
              break label85;
            }
            boolean bool = arrayOfString[i].trim().equals(str);
            if (bool) {
              break;
            }
            i += 1;
          }
          return paramString.equals(str);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  private void c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getSharedPreferences("com.tencent.mobileqq_preferences", 4);
    if (((SharedPreferences)localObject).contains("defaulut_special_sound_source1")) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("defaulut_special_sound_source1", 2131165199);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public int a(String paramString)
  {
    Object localObject = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    localObject = (List)jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null) {
      return -1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      haj localhaj = (haj)((Iterator)localObject).next();
      if (paramString.equals(localhaj.jdField_c_of_type_JavaLangString)) {
        return localhaj.jdField_a_of_type_Int;
      }
    }
    return -1;
  }
  
  public String a(int paramInt)
  {
    if ((b != null) && (!b.isEmpty()))
    {
      haj localhaj = (haj)b.get(String.valueOf(paramInt));
      if (localhaj != null) {
        return localhaj.jdField_a_of_type_JavaLangString;
      }
    }
    return "";
  }
  
  public String a(String paramString)
  {
    Object localObject = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    localObject = (List)jdField_a_of_type_JavaUtilHashMap.get(localObject);
    if (localObject == null) {
      return null;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      haj localhaj = (haj)((Iterator)localObject).next();
      if (paramString.equals(localhaj.jdField_c_of_type_JavaLangString)) {
        return localhaj.jdField_a_of_type_JavaLangString;
      }
    }
    return null;
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore_2
    //   2: aconst_null
    //   3: astore 10
    //   5: aload_0
    //   6: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   9: invokevirtual 194	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   12: ldc 196
    //   14: iconst_4
    //   15: invokevirtual 202	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   18: ldc_w 362
    //   21: lconst_0
    //   22: invokeinterface 366 4 0
    //   27: lstore 4
    //   29: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   32: lstore 6
    //   34: lload 6
    //   36: lload 4
    //   38: lsub
    //   39: ldc2_w 372
    //   42: lcmp
    //   43: ifgt +11 -> 54
    //   46: lload 6
    //   48: lload 4
    //   50: lcmp
    //   51: ifge +293 -> 344
    //   54: new 62	java/io/File
    //   57: dup
    //   58: aload_0
    //   59: getfield 49	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   62: invokevirtual 68	android/content/Context:getFilesDir	()Ljava/io/File;
    //   65: ldc 17
    //   67: invokespecial 71	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   70: astore 11
    //   72: aload 11
    //   74: invokevirtual 75	java/io/File:exists	()Z
    //   77: ifeq +174 -> 251
    //   80: aload_0
    //   81: aload 11
    //   83: invokespecial 108	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/io/File;)Ljava/lang/String;
    //   86: astore 8
    //   88: new 77	com/tencent/mobileqq/vip/DownloadTask
    //   91: dup
    //   92: ldc 17
    //   94: aload 11
    //   96: invokespecial 80	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   99: astore 9
    //   101: aload 9
    //   103: iconst_1
    //   104: putfield 83	com/tencent/mobileqq/vip/DownloadTask:a	B
    //   107: aload 9
    //   109: aload_0
    //   110: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   113: invokestatic 88	com/tencent/mobileqq/vip/DownloaderFactory:a	(Lcom/tencent/mobileqq/vip/DownloadTask;Lcom/tencent/common/app/AppInterface;)I
    //   116: istore_1
    //   117: aload 10
    //   119: astore 9
    //   121: iload_1
    //   122: ifne +62 -> 184
    //   125: aload_0
    //   126: getfield 51	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   129: invokevirtual 194	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   132: ldc 196
    //   134: iconst_4
    //   135: invokevirtual 202	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   138: invokeinterface 208 1 0
    //   143: ldc_w 362
    //   146: invokestatic 371	java/lang/System:currentTimeMillis	()J
    //   149: invokeinterface 377 4 0
    //   154: invokeinterface 219 1 0
    //   159: pop
    //   160: aload_0
    //   161: aload 11
    //   163: invokespecial 108	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/io/File;)Ljava/lang/String;
    //   166: astore 9
    //   168: aload 11
    //   170: ifnull +9 -> 179
    //   173: aload 11
    //   175: invokevirtual 92	java/io/File:length	()J
    //   178: lstore_2
    //   179: aload_0
    //   180: lload_2
    //   181: invokevirtual 95	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(J)V
    //   184: aload 9
    //   186: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   189: ifeq +120 -> 309
    //   192: aload_0
    //   193: ldc_w 379
    //   196: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   199: return
    //   200: astore 8
    //   202: aload_0
    //   203: ldc 110
    //   205: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   208: aload 8
    //   210: invokevirtual 111	java/io/IOException:printStackTrace	()V
    //   213: aconst_null
    //   214: astore 8
    //   216: goto -128 -> 88
    //   219: astore 8
    //   221: aload_0
    //   222: ldc 113
    //   224: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   227: aload 8
    //   229: invokevirtual 114	java/lang/OutOfMemoryError:printStackTrace	()V
    //   232: aconst_null
    //   233: astore 8
    //   235: goto -147 -> 88
    //   238: astore 8
    //   240: aload_0
    //   241: ldc 116
    //   243: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   246: aload 8
    //   248: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   251: aconst_null
    //   252: astore 8
    //   254: goto -166 -> 88
    //   257: astore 9
    //   259: aload 9
    //   261: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   264: iconst_m1
    //   265: istore_1
    //   266: goto -149 -> 117
    //   269: astore 9
    //   271: aload_0
    //   272: ldc 116
    //   274: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   277: aload 9
    //   279: invokevirtual 105	java/lang/Exception:printStackTrace	()V
    //   282: aload 10
    //   284: astore 9
    //   286: goto -102 -> 184
    //   289: astore 9
    //   291: aload_0
    //   292: ldc 113
    //   294: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   297: aload 9
    //   299: invokevirtual 114	java/lang/OutOfMemoryError:printStackTrace	()V
    //   302: aload 10
    //   304: astore 9
    //   306: goto -122 -> 184
    //   309: aload 8
    //   311: invokestatic 174	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   314: ifne +21 -> 335
    //   317: aload 8
    //   319: aload 9
    //   321: invokevirtual 189	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   324: ifeq +11 -> 335
    //   327: aload_0
    //   328: ldc_w 381
    //   331: invokevirtual 100	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:b	(Ljava/lang/String;)V
    //   334: return
    //   335: aload_0
    //   336: aload 8
    //   338: aload 9
    //   340: invokespecial 383	com/tencent/mobileqq/activity/specialcare/QvipSpecialSoundManager:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   343: return
    //   344: invokestatic 388	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq -148 -> 199
    //   350: ldc 14
    //   352: iconst_2
    //   353: ldc_w 390
    //   356: invokestatic 394	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   359: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	360	0	this	QvipSpecialSoundManager
    //   116	150	1	i	int
    //   1	180	2	l1	long
    //   27	22	4	l2	long
    //   32	15	6	l3	long
    //   86	1	8	str	String
    //   200	9	8	localIOException	IOException
    //   214	1	8	localObject1	Object
    //   219	9	8	localOutOfMemoryError1	OutOfMemoryError
    //   233	1	8	localObject2	Object
    //   238	9	8	localException1	Exception
    //   252	85	8	localCharSequence	java.lang.CharSequence
    //   99	86	9	localObject3	Object
    //   257	3	9	localException2	Exception
    //   269	9	9	localException3	Exception
    //   284	1	9	localObject4	Object
    //   289	9	9	localOutOfMemoryError2	OutOfMemoryError
    //   304	35	9	localObject5	Object
    //   3	300	10	localObject6	Object
    //   70	104	11	localFile	File
    // Exception table:
    //   from	to	target	type
    //   80	88	200	java/io/IOException
    //   80	88	219	java/lang/OutOfMemoryError
    //   80	88	238	java/lang/Exception
    //   88	117	257	java/lang/Exception
    //   125	168	269	java/lang/Exception
    //   173	179	269	java/lang/Exception
    //   179	184	269	java/lang/Exception
    //   125	168	289	java/lang/OutOfMemoryError
    //   173	179	289	java/lang/OutOfMemoryError
    //   179	184	289	java/lang/OutOfMemoryError
  }
  
  public void a(long paramLong)
  {
    if (paramLong <= 0L)
    {
      b("reportFlowData is Empty flowSize = " + paramLong);
      return;
    }
    String[] arrayOfString;
    if (NetworkUtil.b(BaseApplication.getContext()) == 1)
    {
      b("reportFlowData int wifi state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_WIFISpecialCareDownloadFlow";
      arrayOfString[1] = "param_WIFIFlow";
      arrayOfString[2] = "param_Flow";
    }
    for (;;)
    {
      b("sendAppDataIncerment flowSize = " + paramLong);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getAccount(), arrayOfString, paramLong);
      return;
      b("reportFlowData int 2G/3G state");
      arrayOfString = new String[3];
      arrayOfString[0] = "param_XGSpecialCareDownloadFlow";
      arrayOfString[1] = "param_XGFlow";
      arrayOfString[2] = "param_Flow";
    }
  }
  
  public void a(QvipSpecialSoundManager.CallBack paramCallBack)
  {
    ThreadManager.a(new hal(this, paramCallBack));
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {}
    for (;;)
    {
      return;
      try
      {
        paramString = QvipSpecialSoundConfig.a(new JSONObject(paramString));
        if (paramString != null)
        {
          a(paramString.jdField_a_of_type_JavaUtilList);
          return;
        }
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public boolean a()
  {
    String str = "key_special_sound_list" + this.jdField_a_of_type_ComTencentCommonAppAppInterface.a();
    return jdField_a_of_type_JavaUtilHashMap.containsKey(str);
  }
  
  public boolean a(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), paramString);
      try
      {
        paramString = new DownloadTask(MsfSdkUtils.insertMtype("lingyin", paramString), localFile);
        paramString.a = 1;
        i = DownloaderFactory.a(paramString, this.jdField_a_of_type_ComTencentCommonAppAppInterface);
        if (i == 0) {
          continue;
        }
        return false;
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          paramString.printStackTrace();
          int i = -1;
        }
      }
    }
  }
  
  public void b()
  {
    c();
    a(a());
  }
  
  public void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QvipSpecialSoundManager", 2, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.specialcare.QvipSpecialSoundManager
 * JD-Core Version:    0.7.0.1
 */
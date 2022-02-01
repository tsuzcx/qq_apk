package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kuv;
import kuw;
import kux;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ClubContentJsonTask
{
  public static final int a = 1;
  public static ClubContentJsonTask.TaskInfo a;
  public static final String a = "ClubContentJsonTask";
  public static ClubContentJsonTask.TaskInfo[] a;
  public static final int b = 2;
  public static ClubContentJsonTask.TaskInfo b;
  public static final String b = "clubContentVersion";
  public static final int c = 1;
  public static ClubContentJsonTask.TaskInfo c;
  public static final int d = 2;
  public static ClubContentJsonTask.TaskInfo d;
  public static final int e = 3;
  public static ClubContentJsonTask.TaskInfo e;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo("Emoticon_promotion.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aio/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_emoji_aio/xydata.json", "EPPromotionVersion", "promotion_json");
    b = new ClubContentJsonTask.TaskInfo("Individuation.json", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/", "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_individuation/xydata.json", "IndividuationVersion", "individ_json");
    c = new ClubContentJsonTask.TaskInfo("EmoticonWording.json", "", "https://i.gtimg.cn/club/item/parcel/client_wording.json", "EmoticonWordingVersion", "wording_json");
    d = new ClubContentJsonTask.TaskInfo("keyword.json", "", "https://imgcache.qq.com/club/item/parcel/json/keyword_2.json", "EmoticonKeywordVersion", "keyword.json");
    e = new ClubContentJsonTask.TaskInfo("themeActivity.json", "", "https://i.gtimg.cn/qqshow/admindata/comdata/viptheme_act_autoswitch/xydata.json", "ThemeActivityVersion", "theme_autoswitch_json");
    jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo = new ClubContentJsonTask.TaskInfo[] { jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo, b, c };
  }
  
  public static int a(Context paramContext)
  {
    int k = 0;
    paramContext = new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString);
    for (;;)
    {
      try
      {
        paramContext = FileUtils.a(paramContext);
        j = k;
        if (paramContext != null)
        {
          paramContext = new JSONObject(paramContext).getJSONObject("data").getJSONArray("showNewBiz");
          i = 0;
          j = k;
          if (i < paramContext.length())
          {
            if ((System.currentTimeMillis() >= Long.parseLong(paramContext.getJSONObject(i).getString("expireTime"))) || (paramContext.getJSONObject(i).getInt("bizType") != 1)) {
              continue;
            }
            j = paramContext.getJSONObject(i).getInt("newId");
          }
        }
      }
      catch (Exception paramContext)
      {
        int i;
        int j = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
      }
      return j;
      i += 1;
    }
    return 0;
  }
  
  public static int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("clubContentVersion", 0).getInt(paramString, 0);
  }
  
  public static String a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString);
    try
    {
      paramContext = new JSONObject(FileUtils.a(paramContext)).getJSONObject("data").getJSONArray("AttentionIcon").getJSONObject(0);
      if (System.currentTimeMillis() < Long.parseLong(paramContext.getString("expireTime")))
      {
        paramContext = b.c + paramContext.getString("bizIcon");
        return paramContext;
      }
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
      }
    }
    return null;
  }
  
  public static String a(JSONArray paramJSONArray, long paramLong1, long paramLong2)
  {
    Object localObject;
    if (paramLong1 == -1L) {
      localObject = "";
    }
    for (;;)
    {
      return localObject;
      long l = paramLong1;
      if (paramLong1 == 0L) {
        l = 1L;
      }
      if (paramJSONArray == null) {
        break label261;
      }
      if (l >= 1L) {}
      try
      {
        if (l > paramJSONArray.length())
        {
          if (!QLog.isColorLevel()) {
            break label264;
          }
          QLog.d("ClubContentJsonTask", 2, "Illegal wordingId,wordingId=" + l + ",listSize=" + paramJSONArray.length());
          break label264;
        }
        str2 = ((JSONObject)paramJSONArray.get((int)l - 1)).getString("desc_mqq");
        localObject = str2;
        if (str2 != null)
        {
          localObject = str2;
          paramJSONArray = str2;
          try
          {
            if (str2.contains("$EXPIRE_DATE$"))
            {
              if (paramLong2 > 0L) {
                break label218;
              }
              str2 = "";
              localObject = str2;
              paramJSONArray = str2;
              if (QLog.isColorLevel())
              {
                paramJSONArray = str2;
                QLog.d("ClubContentJsonTask", 2, "Illegal expireTime, expireTime=" + paramLong2);
                return "";
              }
            }
          }
          catch (JSONException localJSONException1) {}
        }
      }
      catch (JSONException localJSONException2)
      {
        for (;;)
        {
          String str2;
          String str1;
          paramJSONArray = "";
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ClubContentJsonTask", 2, "Error occurred while parsing wording.json");
    }
    localJSONException1.printStackTrace();
    return paramJSONArray;
    label218:
    paramJSONArray = str2;
    str1 = str2.replaceAll("\\$EXPIRE_DATE\\$", new SimpleDateFormat("yyyy年MM月dd日").format(Long.valueOf(1000L * paramLong2)));
    return str1;
    label261:
    return "";
    label264:
    return "";
  }
  
  public static List a(Context paramContext)
  {
    localArrayList = new ArrayList();
    paramContext = new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString);
    try
    {
      paramContext = FileUtils.a(paramContext);
      if (paramContext != null)
      {
        paramContext = new JSONObject(paramContext).getJSONObject("data").getJSONArray("showNewBiz");
        int i = 0;
        while (i < paramContext.length())
        {
          if (System.currentTimeMillis() < Long.parseLong(paramContext.getJSONObject(i).getString("expireTime")))
          {
            Bundle localBundle = new Bundle();
            localBundle.putInt("bizType", paramContext.getJSONObject(i).getInt("bizType"));
            localBundle.putInt("newId", paramContext.getJSONObject(i).getInt("newId"));
            localArrayList.add(localBundle);
          }
          i += 1;
        }
      }
      return localArrayList;
    }
    catch (Exception paramContext)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
      }
    }
  }
  
  public static List a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, jdField_a_of_type_ComTencentMobileqqVasClubContentJsonTask$TaskInfo.jdField_a_of_type_JavaLangString + " not exist.");
      }
      return localArrayList;
    }
    paramQQAppInterface = ((EmoticonManager)paramQQAppInterface.getManager(13)).b();
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(FileUtils.a((File)localObject1)).getJSONObject("data").getJSONArray("aioemoji");
        int i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = paramQQAppInterface.iterator();
          if (((Iterator)localObject2).hasNext())
          {
            if (!((EmoticonPackage)((Iterator)localObject2).next()).epId.equals(((JSONArray)localObject1).getJSONObject(i).getString("id"))) {
              continue;
            }
            j = 1;
            if (j == 0)
            {
              localObject2 = new ClubContentJsonTask.PromotionEmoticonPkg();
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).d = ((JSONArray)localObject1).getJSONObject(i).getString("btn_desc");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).e = ((JSONArray)localObject1).getJSONObject(i).getString("btn_url");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_a_of_type_JavaLangString = ((JSONArray)localObject1).getJSONObject(i).getString("id");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_b_of_type_JavaLangString = ((JSONArray)localObject1).getJSONObject(i).getString("img");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).c = ((JSONArray)localObject1).getJSONObject(i).getString("pkg_desc");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_a_of_type_Int = ((JSONArray)localObject1).getJSONObject(i).getInt("type");
              ((ClubContentJsonTask.PromotionEmoticonPkg)localObject2).jdField_b_of_type_Int = ((JSONArray)localObject1).getJSONObject(i).getInt("btn_url_type");
              localArrayList.add(localObject2);
            }
            i += 1;
          }
        }
        else
        {
          return localArrayList;
        }
      }
      catch (JSONException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "Invalid json.");
        }
      }
      int j = 0;
    }
  }
  
  public static JSONArray a(Context paramContext)
  {
    paramContext = FileUtils.a(new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString));
    if (paramContext != null) {
      try
      {
        paramContext = new JSONObject(paramContext).getJSONObject("data").getJSONArray("ABTestBanner");
        return paramContext;
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
        }
      }
    }
    return null;
  }
  
  public static JSONArray a(QQAppInterface paramQQAppInterface)
  {
    a(paramQQAppInterface, c);
    paramQQAppInterface = FileUtils.a(new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), c.jdField_a_of_type_JavaLangString));
    if (paramQQAppInterface != null) {
      try
      {
        paramQQAppInterface = new JSONObject(paramQQAppInterface).getJSONArray("wording");
        return paramQQAppInterface;
      }
      catch (JSONException paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramQQAppInterface.getMessage());
        }
      }
    }
    return null;
  }
  
  public static JSONObject a(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, d.jdField_a_of_type_JavaLangString);
  }
  
  /* Error */
  private static JSONObject a(QQAppInterface paramQQAppInterface, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 92	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: invokevirtual 279	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   14: invokevirtual 285	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   17: invokevirtual 98	android/content/Context:getFilesDir	()Ljava/io/File;
    //   20: aload_1
    //   21: invokespecial 103	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_0
    //   25: aload_0
    //   26: invokevirtual 288	java/io/File:exists	()Z
    //   29: ifeq -25 -> 4
    //   32: aload_0
    //   33: invokestatic 108	com/tencent/mobileqq/utils/FileUtils:a	(Ljava/io/File;)Ljava/lang/String;
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull -34 -> 4
    //   41: new 110	org/json/JSONObject
    //   44: dup
    //   45: aload_0
    //   46: invokespecial 113	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   49: astore_0
    //   50: aload_0
    //   51: areturn
    //   52: astore_0
    //   53: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   56: ifeq +13 -> 69
    //   59: ldc 11
    //   61: iconst_2
    //   62: aload_0
    //   63: invokevirtual 374	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   66: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: aconst_null
    //   70: astore_0
    //   71: goto -34 -> 37
    //   74: astore_0
    //   75: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq -74 -> 4
    //   81: ldc 11
    //   83: iconst_2
    //   84: aload_0
    //   85: invokevirtual 359	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   88: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_0
    //   94: invokestatic 166	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq -93 -> 4
    //   100: ldc 11
    //   102: iconst_2
    //   103: aload_0
    //   104: invokevirtual 375	java/lang/NumberFormatException:getMessage	()Ljava/lang/String;
    //   107: invokestatic 173	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: aconst_null
    //   111: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	paramQQAppInterface	QQAppInterface
    //   0	112	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   32	37	52	java/lang/OutOfMemoryError
    //   41	50	74	org/json/JSONException
    //   41	50	93	java/lang/NumberFormatException
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    paramContext.getSharedPreferences("clubContentVersion", 0).edit().putInt(paramString, paramInt).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Context localContext = paramQQAppInterface.getApplication().getApplicationContext();
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo.length)
    {
      String str = jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i].jdField_b_of_type_JavaLangString;
      File localFile = new File(localContext.getFilesDir(), jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i].jdField_a_of_type_JavaLangString);
      if (!localFile.exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, "downloadAllIfNotExist, not found: " + jdField_a_of_type_ArrayOfComTencentMobileqqVasClubContentJsonTask$TaskInfo[i].jdField_a_of_type_JavaLangString);
        }
        paramQQAppInterface.a(new kuw(str, localFile));
      }
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo)
  {
    File localFile = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString);
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, not exist: " + paramTaskInfo.jdField_a_of_type_JavaLangString);
      }
      paramQQAppInterface.a(new kuv(paramTaskInfo, localFile));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ClubContentJsonTask", 2, "downloadIfNotExist, exists.");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ClubContentJsonTask.TaskInfo paramTaskInfo, int paramInt)
  {
    Context localContext = paramQQAppInterface.getApplication().getApplicationContext();
    paramQQAppInterface.a(new kux(paramTaskInfo, new File(localContext.getFilesDir(), paramTaskInfo.jdField_a_of_type_JavaLangString), localContext, paramInt, paramQQAppInterface));
  }
  
  public static boolean a(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    JSONArray localJSONArray;
    int i;
    for (;;)
    {
      try
      {
        if ((paramJSONObject.has("AList")) && ((paramJSONObject.get("AList") instanceof JSONArray)))
        {
          localJSONArray = paramJSONObject.getJSONArray("AList");
          break label214;
          if (i >= localJSONArray.length()) {
            break;
          }
          if (!paramString.equals(localJSONArray.getString(i))) {
            break label90;
          }
          return true;
        }
        localJSONArray = new JSONArray();
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ClubContentJsonTask", 2, paramJSONObject.getMessage());
        }
      }
      label88:
      return true;
      label90:
      i += 1;
    }
    if ((paramJSONObject.has("BList")) && ((paramJSONObject.get("BList") instanceof JSONArray))) {
      localJSONArray = paramJSONObject.getJSONArray("BList");
    }
    for (;;)
    {
      if (i < localJSONArray.length())
      {
        if (!paramString.equals(localJSONArray.getString(i))) {
          break label224;
        }
        return false;
        localJSONArray = new JSONArray();
      }
      else
      {
        i = Integer.parseInt(paramJSONObject.getString("ARate"));
        int j = Integer.parseInt(paramString.substring(paramString.length() - 2));
        if (paramBoolean)
        {
          if (j < i) {
            break label88;
          }
          return false;
        }
        if (j <= i) {
          break label88;
        }
        return false;
        label214:
        i = 0;
        break;
      }
      i = 0;
      continue;
      label224:
      i += 1;
    }
  }
  
  public static int b(Context paramContext, String paramString)
  {
    if (paramString.length() > 2)
    {
      paramContext = FileUtils.a(new File(paramContext.getFilesDir(), b.jdField_a_of_type_JavaLangString));
      if (paramContext == null) {}
    }
    try
    {
      boolean bool = a(new JSONObject(paramContext).getJSONObject("data").getJSONArray("ABTestUserRate").getJSONObject(0), paramString, false);
      if (!bool) {
        break label68;
      }
    }
    catch (JSONException paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ClubContentJsonTask", 2, paramContext.getMessage());
    }
    return 1;
    label68:
    return 2;
    return 1;
  }
  
  public static JSONObject b(QQAppInterface paramQQAppInterface)
  {
    return a(paramQQAppInterface, e.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ClubContentJsonTask
 * JD-Core Version:    0.7.0.1
 */
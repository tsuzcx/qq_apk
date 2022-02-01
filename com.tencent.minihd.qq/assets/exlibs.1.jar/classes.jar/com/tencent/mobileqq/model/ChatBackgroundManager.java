package com.tencent.mobileqq.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.aio.ChatBackground;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatBackgroundInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jgh;
import jgi;
import jgj;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatBackgroundManager
  implements Manager
{
  public static int a = 0;
  public static Handler a;
  public static final String a = "ChatBackgroundManager";
  public static int b = 0;
  public static final int c = 0;
  public static final String c = "null";
  public static final int d = 1;
  public static final String d = "custom";
  public static int e = 0;
  public static final String e = "userChatbgInfo";
  static final int f = 1;
  public static final String f = "userChatbgKey";
  public static final String g = AppConstants.bD + "ChatBgJson.txt";
  public static final String h = "https://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/";
  public static final String i = "?isOldVersion=";
  public static final String j = "&isOldVersion=";
  public static String k;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new jgh(this, "param_WIFIFontDownloadFlow", "param_XGFontDownloadFlow");
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  String b;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 0;
    jdField_a_of_type_AndroidOsHandler = new jgj(BaseApplication.getContext().getMainLooper());
  }
  
  public ChatBackgroundManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_b_of_type_JavaLangString = paramQQAppInterface.getAccount();
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramQQAppInterface.getManager(46));
  }
  
  public static void a()
  {
    k = null;
    e = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "ChatBackground destroy() is called");
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, StatisticCollector paramStatisticCollector)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(k, Integer.valueOf(1));
    if (QLog.isColorLevel()) {
      QLog.d("ThemeDownloadTrace", 2, "initCurrChatBgNameForReport is:" + k);
    }
    paramStatisticCollector.b(paramQQAppInterface, paramString, localHashMap);
  }
  
  private String e(String paramString)
  {
    String str;
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.equals("null"))) {
      str = "null";
    }
    do
    {
      return str;
      if (paramString.equals("none")) {
        return "null";
      }
      int m = paramString.lastIndexOf(File.separatorChar);
      if ((m < 0) || (m >= paramString.length() - 1)) {
        break label147;
      }
      str = paramString.substring(0, m + 1);
      if (!AppConstants.bD.equals(str)) {
        break;
      }
      str = paramString.substring(m + 1);
      m = str.lastIndexOf('.');
      paramString = str;
      if (m >= 0) {
        paramString = str.substring(0, m);
      }
      str = paramString;
    } while (!QLog.isColorLevel());
    QLog.d("ChatBackgroundManager", 2, "picName is:" + paramString);
    return paramString;
    return "custom";
    label147:
    throw new IllegalStateException("picPath is illegal,picPath is:" + paramString);
  }
  
  public int a(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences("mobileQQ", 0).getInt(d(paramString), 0);
  }
  
  public int a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, "stopDownload  id=" + paramString1 + ", ret=" + 0);
    }
    return 0;
  }
  
  public Bundle a(Context paramContext, String paramString1, String paramString2)
  {
    Bundle localBundle = new Bundle();
    try
    {
      File localFile = new File(AppConstants.bD + paramString1 + ".jpg");
      if ((a(paramContext, paramString1) != null) && (localFile.exists()))
      {
        localBundle.putInt("status", 1);
        localBundle.putInt("progress", 100);
        localBundle.putInt("result", 0);
        localBundle.putString("message", "本地存在");
      }
      for (;;)
      {
        localBundle.putString("id", paramString1);
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackgroundManager", 2, "queryInfo chatbgId=" + paramString1 + ",json=" + localBundle.toString());
        }
        return localBundle;
        paramContext = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramString2);
        if (paramContext == null) {
          break;
        }
        switch (paramContext.a())
        {
        case 0: 
        case 1: 
          localBundle.putInt("result", 0);
          localBundle.putString("message", "未知状态");
          localBundle.putInt("status", 0);
          localBundle.putInt("progress", (int)paramContext.a);
        }
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
        continue;
        localBundle.putInt("result", 0);
        localBundle.putString("message", "下载中");
        continue;
        localBundle.putInt("result", 0);
        localBundle.putString("message", "下载完成");
        continue;
        localBundle.putInt("result", 1);
        localBundle.putString("message", "下载失败");
        continue;
        localBundle.putInt("status", 0);
        localBundle.putInt("progress", 0);
        localBundle.putInt("result", 0);
        localBundle.putString("message", "未知状态");
      }
    }
  }
  
  public ChatBackgroundInfo a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("userChatbgInfo", 0).getString("userChatbgKey", "");
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, " getchatbgInfo chatbgInfo=" + paramContext);
    }
    if (paramContext != null)
    {
      try
      {
        if (paramContext.length() <= 0) {
          break label145;
        }
        paramContext = new JSONObject(paramContext);
        if (!paramContext.has(paramString)) {
          break label145;
        }
        JSONObject localJSONObject = paramContext.getJSONObject(paramString);
        paramContext = new ChatBackgroundInfo();
        paramString.printStackTrace();
      }
      catch (JSONException paramString)
      {
        try
        {
          paramContext.id = paramString;
          paramContext.name = localJSONObject.getString("name");
          paramContext.url = localJSONObject.getString("url");
          paramContext.thumbUrl = localJSONObject.getString("thumbUrl");
          return paramContext;
        }
        catch (JSONException paramString)
        {
          break label135;
        }
        paramString = paramString;
        paramContext = null;
      }
      label135:
      return paramContext;
    }
    label145:
    return null;
  }
  
  public String a(Context paramContext, String paramString)
  {
    String str = "none";
    paramContext = a(paramContext, paramString);
    if (paramContext != null)
    {
      paramString = paramContext.thumbUrl;
      paramContext = paramString;
      if (paramString != null)
      {
        paramContext = paramString;
        if (!"none".equals(paramString)) {
          paramContext = paramString + "&isOldVersion=" + jdField_b_of_type_Int;
        }
      }
    }
    do
    {
      do
      {
        return paramContext;
        paramContext = str;
      } while (!new File(g).exists());
      paramString = a(paramString);
      paramContext = paramString;
    } while ("none".equals(paramString));
    return paramString + "?isOldVersion=" + jdField_a_of_type_Int;
  }
  
  public String a(String paramString)
  {
    try
    {
      Object localObject = FileUtils.a(new File(g));
      localObject = new JSONObject((String)((String)localObject).subSequence(((String)localObject).indexOf("{"), ((String)localObject).length() - 1)).getJSONObject("data").getJSONArray("chatBackground");
      int n = ((JSONArray)localObject).length();
      int m = 0;
      while (m < n)
      {
        JSONObject localJSONObject = ((JSONArray)localObject).getJSONObject(m);
        if (localJSONObject.getString("id").equals(paramString))
        {
          paramString = "https://i.gtimg.cn/qqshow/admindata/comdata/backgroundMall_chat_1/" + localJSONObject.getString("thumbnail");
          return paramString;
        }
        m += 1;
      }
      return "none";
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
      return null;
    }
  }
  
  public HashMap a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject1 = ((Context)localObject1).getSharedPreferences("chat_background_path_" + (String)localObject2, 0);
    localObject2 = new HashMap();
    Iterator localIterator = ((SharedPreferences)localObject1).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches()) {
        ((HashMap)localObject2).put(str, e(((SharedPreferences)localObject1).getString(str, "null")));
      }
    }
    ((HashMap)localObject2).put("chat_uniform_bg", e(((SharedPreferences)localObject1).getString("chat_uniform_bg", "null")));
    return localObject2;
  }
  
  public List a()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext();
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a();
    localObject2 = ((Context)localObject1).getSharedPreferences("chat_background_path_" + (String)localObject2, 0);
    localObject1 = new ArrayList();
    Iterator localIterator = ((SharedPreferences)localObject2).getAll().keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (Pattern.compile("[0-9]*").matcher(str).matches())
      {
        str = e(((SharedPreferences)localObject2).getString(str, "null"));
        if ((str != null) && (!str.equals("null")) && (!str.equals("custom")) && (!((List)localObject1).contains(Integer.valueOf(str)))) {
          ((List)localObject1).add(Integer.valueOf(str));
        }
      }
    }
    localObject2 = e(((SharedPreferences)localObject2).getString("chat_uniform_bg", "null"));
    if ((localObject2 != null) && (!((String)localObject2).equals("null")) && (!((String)localObject2).equals("custom")) && (!((List)localObject1).contains(Integer.valueOf((String)localObject2)))) {
      ((List)localObject1).add(Integer.valueOf((String)localObject2));
    }
    return localObject1;
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ChatBackgroundManager", 2, "download chatbg report actionResult=" + paramInt + ",chatbgId=" + paramString);
    }
    int m = NetworkUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext());
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "chatbackground", "BjIDXiazai", 0, paramInt, paramString, "", m + "", String.valueOf(paramLong));
  }
  
  public void a(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    if ((paramString == null) || (paramString.trim().length() == 0)) {
      if (QLog.isColorLevel()) {
        QLog.e("ChatBackgroundManager", 2, "uin is empty,not save switch bg times");
      }
    }
    int m;
    do
    {
      return;
      paramString = d(paramString);
      m = paramContext.getInt(paramString, 0);
      if (QLog.isColorLevel()) {
        QLog.d("ChatBackgroundManager", 2, "oldCount is:" + m);
      }
      paramContext = paramContext.edit();
      m += 1;
      paramContext.putInt(paramString, m);
      paramContext.commit();
    } while (!QLog.isColorLevel());
    QLog.d("ChatBackgroundManager", 2, "save count is:" + m);
  }
  
  public void a(Intent paramIntent)
  {
    paramIntent = paramIntent.getExtras();
    if (paramIntent != null)
    {
      String str = ChatActivityUtils.b(paramIntent.getInt("uintype", 999));
      int m = paramIntent.getInt("bg_replace_entrance", 999);
      if (QLog.isDevelopLevel()) {
        QLog.d("reportEvent", 4, " uin_type : " + str + " entrance_type ： " + m);
      }
      if (m != 999) {
        ReportController.b(null, "CliOper", "", "", "background", "bkground_replace", m, 0, str, "", "", "");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    e = 0;
    jdField_a_of_type_AndroidOsHandler.removeMessages(1);
    k = null;
    paramQQAppInterface.a(new jgi(this, paramString, paramQQAppInterface));
  }
  
  public void a(ChatBackgroundInfo paramChatBackgroundInfo, String paramString)
  {
    if (((paramString == null) && (!DownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext()))) || (paramChatBackgroundInfo == null)) {}
    String str1;
    do
    {
      return;
      str1 = paramChatBackgroundInfo.id;
      Bundle localBundle = new Bundle();
      localBundle.putInt("id", Integer.valueOf(str1).intValue());
      localBundle.putString("callbackId", paramString);
      if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramChatBackgroundInfo.id) == null) {
        a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext(), paramChatBackgroundInfo);
      }
      paramString = new File(AppConstants.bD + str1 + ".jpg");
      if (paramString.exists())
      {
        this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(Long.valueOf(str1).longValue(), 0, localBundle);
        return;
      }
      String str2 = paramChatBackgroundInfo.url;
      localBundle.putSerializable("chatbgInfo", paramChatBackgroundInfo);
      paramChatBackgroundInfo = new DownloadTask(str2, paramString);
      paramChatBackgroundInfo.b = true;
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(1).a(paramChatBackgroundInfo, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
    } while (!QLog.isColorLevel());
    QLog.d("ChatBackgroundManager", 2, "startDownload  id=" + str1);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    ChatBackground.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getApplicationContext(), paramString1, paramString2, paramString3);
  }
  
  public boolean a(Context paramContext, ChatBackgroundInfo paramChatBackgroundInfo)
  {
    boolean bool = false;
    paramContext = paramContext.getSharedPreferences("userChatbgInfo", 0);
    SharedPreferences.Editor localEditor = paramContext.edit();
    paramContext = paramContext.getString("userChatbgKey", "");
    if (QLog.isColorLevel()) {
      QLog.d("ChatBackgroundManager", 2, " setchatbgInfo chatbgInfo=" + paramChatBackgroundInfo.toString());
    }
    String str = paramChatBackgroundInfo.id;
    if (str != null)
    {
      if (paramContext != null) {}
      try
      {
        if (paramContext.length() > 0)
        {
          paramContext = new JSONObject(paramContext);
          if (!paramContext.has(str)) {
            break label230;
          }
        }
        label230:
        for (JSONObject localJSONObject = paramContext.getJSONObject(str);; localJSONObject = new JSONObject())
        {
          localJSONObject.put("name", paramChatBackgroundInfo.name);
          localJSONObject.put("url", paramChatBackgroundInfo.url);
          localJSONObject.put("thumbUrl", paramChatBackgroundInfo.thumbUrl);
          paramContext.put(str, localJSONObject);
          bool = localEditor.putString("userChatbgKey", paramContext.toString()).commit();
          if ((bool) || (!QLog.isColorLevel())) {
            return bool;
          }
          QLog.d("ChatBackgroundManager", 2, "setThemeInfo sp comit rt=" + bool);
          return bool;
          paramContext = new JSONObject();
          break;
        }
        if (!QLog.isColorLevel()) {
          return bool;
        }
      }
      catch (JSONException paramContext)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ChatBackgroundManager", 2, "ThemeUtil setThemeInfo error:" + paramContext.getMessage());
        }
        paramContext.printStackTrace();
        return false;
      }
    }
    else
    {
      QLog.d("ChatBackgroundManager", 2, "ThemeUtil setThemeInfo error themeId is null");
      return false;
    }
    return bool;
  }
  
  public String b(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("chat_background_path_" + this.jdField_b_of_type_JavaLangString, 0);
    String str = localSharedPreferences.getString(paramString, null);
    paramString = str;
    if (str == null)
    {
      str = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString = str;
      if (str == null) {
        paramString = "null";
      }
    }
    if ((paramString == null) || (paramString.trim().length() == 0) || (paramString.equals("null"))) {
      str = "null";
    }
    do
    {
      return str;
      str = paramString;
    } while (!paramString.equals("none"));
    return "null";
  }
  
  public void b(Context paramContext, String paramString)
  {
    paramContext = paramContext.getSharedPreferences("mobileQQ", 0);
    paramString = d(paramString);
    paramContext = paramContext.edit();
    paramContext.putInt(paramString, 0);
    paramContext.commit();
  }
  
  public String c(String paramString)
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("chat_background_path_" + this.jdField_b_of_type_JavaLangString, 0);
    String str = localSharedPreferences.getString(paramString, null);
    paramString = str;
    if (str == null)
    {
      str = localSharedPreferences.getString("chat_uniform_bg", null);
      paramString = str;
      if (str == null) {
        paramString = "null";
      }
    }
    return e(paramString);
  }
  
  public String d(String paramString)
  {
    return "chat_background_switch_times_" + paramString;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.model.ChatBackgroundManager
 * JD-Core Version:    0.7.0.1
 */
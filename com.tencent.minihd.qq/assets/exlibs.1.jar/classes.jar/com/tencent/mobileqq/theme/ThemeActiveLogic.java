package com.tencent.mobileqq.theme;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.SkinEngine;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThemeActiveLogic
{
  public static final String ACTIVE_THEME_SP_NAME = "active_theme_sp_name_";
  public static final String ACTIVE_THME_SP_DELETE_KEY = "active_theme_sp_delete_key_";
  public static final String ACTIVE_THME_SP_KEY = "active_theme_sp_key_";
  public static int AFTER = 2;
  public static int BEFORE = 0;
  public static int DURING = 0;
  public static final String IS_FIRST_EFFICTIVE_LOGIN_DURING_ACTIVE = "is_first_login_during_active";
  public static final String TAG = "ThemeActiveLogic";
  public static int UNKOWN = -1;
  QQAppInterface mApp;
  Context mContext;
  DownloadListener mThemeDownloadListener = new ThemeActiveLogic.1(this, "param_WIFIThemeDownloadFlow", "param_XGThemeDownloadFlow");
  
  static
  {
    BEFORE = 0;
    DURING = 1;
  }
  
  public ThemeActiveLogic(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramQQAppInterface.getApplication().getApplicationContext();
  }
  
  public static ThemeActiveLogic.ActiveThemeInfo getActiveThemeInfo(JSONArray paramJSONArray)
  {
    int j = 0;
    ThemeActiveLogic.ActiveThemeInfo localActiveThemeInfo = new ThemeActiveLogic.ActiveThemeInfo();
    label76:
    Object localObject4;
    label103:
    String str1;
    try
    {
      localJSONObject = paramJSONArray.getJSONObject(0);
      if (localJSONObject == null) {
        return null;
      }
      localObject1 = localJSONObject.getString("actBegin");
      if (localObject1 == null) {
        break label634;
      }
      if (!"".equals(localObject1)) {
        break label628;
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Object localObject1;
        String str2;
        localJSONException.printStackTrace();
        while (QLog.isColorLevel())
        {
          QLog.d("ThemeActiveLogic", 2, "active theme json info" + paramJSONArray);
          return localActiveThemeInfo;
          localActiveThemeInfo.BList = ((List)localObject3);
          localObject3 = localJSONObject.getJSONObject("themeInfo");
          if (localObject3 != null)
          {
            localObject2 = ((JSONObject)localObject3).getJSONObject("m");
            if (localObject2 != null)
            {
              localActiveThemeInfo.androidMSize = ((JSONObject)localObject2).getString("fileSize");
              localActiveThemeInfo.androidMurl = ((JSONObject)localObject2).getString("url");
              localActiveThemeInfo.androidMVersion = ((JSONObject)localObject2).getString("version");
            }
            localObject4 = ((JSONObject)localObject3).getJSONObject("h");
            if (localObject2 != null)
            {
              localActiveThemeInfo.androidHSize = ((JSONObject)localObject4).getString("fileSize");
              localActiveThemeInfo.androidHurl = ((JSONObject)localObject4).getString("url");
              localActiveThemeInfo.androidHVersion = ((JSONObject)localObject4).getString("version");
            }
            localObject3 = ((JSONObject)localObject3).getJSONObject("xh");
            if (localObject2 != null)
            {
              localActiveThemeInfo.androidXHSize = ((JSONObject)localObject3).getString("fileSize");
              localActiveThemeInfo.androidXHurl = ((JSONObject)localObject3).getString("url");
              localActiveThemeInfo.androidXHVersion = ((JSONObject)localObject3).getString("version");
            }
          }
        }
        continue;
      }
      return localActiveThemeInfo;
    }
    Object localObject3 = localJSONObject.getString("actEnd");
    if (localObject3 != null) {
      if ("".equals(localObject3))
      {
        break label640;
        localObject4 = localJSONObject.getString("downBegin");
        if (localObject4 == null) {
          break label647;
        }
        if ("".equals(localObject4))
        {
          break label647;
          str2 = localJSONObject.getString("downEnd");
          if (str2 == null) {
            break label654;
          }
          str1 = str2;
          if ("".equals(str2)) {
            break label654;
          }
          label134:
          localActiveThemeInfo.actBegin = ((String)localObject1);
          localActiveThemeInfo.actEnd = ((String)localObject3);
          localActiveThemeInfo.downBegin = ((String)localObject4);
          localActiveThemeInfo.downEnd = str1;
          localObject3 = localJSONObject.getString("netWork");
          if (localObject3 == null) {
            break label661;
          }
          localObject1 = localObject3;
          if ("".equals(localObject3)) {
            break label661;
          }
        }
      }
    }
    for (;;)
    {
      localActiveThemeInfo.netWork = ((String)localObject1);
      localActiveThemeInfo.themeID = localJSONObject.getString("themeID");
      localActiveThemeInfo.switchOff = localJSONObject.getInt("switch");
      localActiveThemeInfo.actID = localJSONObject.getInt("actID");
      if ((localJSONObject.has("AList")) && ((localJSONObject.get("AList") instanceof JSONArray))) {
        localObject1 = localJSONObject.getJSONArray("AList");
      }
      int i;
      while (((JSONArray)localObject1).length() > 0)
      {
        localObject3 = new ArrayList();
        i = 0;
        for (;;)
        {
          if (i < ((JSONArray)localObject1).length())
          {
            ((List)localObject3).add(((JSONArray)localObject1).getString(i));
            i += 1;
            continue;
            localObject1 = new JSONArray();
            break;
          }
        }
        localActiveThemeInfo.AList = ((List)localObject3);
      }
      if ((localJSONObject.has("BList")) && ((localJSONObject.get("BList") instanceof JSONArray))) {}
      for (localObject1 = localJSONObject.getJSONArray("BList");; localObject1 = new JSONArray())
      {
        if (((JSONArray)localObject1).length() <= 0) {
          break label462;
        }
        localObject3 = new ArrayList();
        i = j;
        while (i < ((JSONArray)localObject1).length())
        {
          ((List)localObject3).add(((JSONArray)localObject1).getString(i));
          i += 1;
        }
      }
      label462:
      label628:
      label634:
      Object localObject2 = "0";
      break;
      label640:
      localObject3 = "0";
      break label76;
      label647:
      localObject4 = "0";
      break label103;
      label654:
      str1 = "0";
      break label134;
      label661:
      localObject2 = "0";
    }
  }
  
  private boolean isThemeExist(String paramString1, String paramString2, long paramLong)
  {
    File localFile = new File(ThemeUtil.getThemeDownloadFilePath(this.mContext, paramString1, paramString2));
    if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() == paramLong))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeActiveLogic", 2, "themeZipFile:" + paramString1 + "," + paramString2 + "," + paramLong + " already exists.");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ThemeActiveLogic", 2, "themeZipFile:" + paramString1 + "," + paramString2 + "," + paramLong + " not exist.");
    }
    return false;
  }
  
  public boolean ABListAuth(ThemeActiveLogic.ActiveThemeInfo paramActiveThemeInfo)
  {
    String str = this.mApp.a();
    List localList = paramActiveThemeInfo.BList;
    if ((localList != null) && (localList.size() > 0) && (localList.contains(str))) {}
    int i;
    do
    {
      return false;
      i = paramActiveThemeInfo.switchOff;
      paramActiveThemeInfo = paramActiveThemeInfo.AList;
    } while ((i == ThemeActiveLogic.ActiveThemeInfo.CLOES) && ((paramActiveThemeInfo == null) || (paramActiveThemeInfo.size() <= 0) || (!paramActiveThemeInfo.contains(str))));
    return true;
  }
  
  public int DuringActiveTime()
  {
    Object localObject = getActiveThemeJson();
    if (localObject == null) {
      return UNKOWN;
    }
    localObject = getActiveThemeInfo((JSONArray)localObject);
    if (localObject == null) {
      return UNKOWN;
    }
    long l1 = Long.valueOf(((ThemeActiveLogic.ActiveThemeInfo)localObject).actBegin).longValue();
    long l2 = Long.valueOf(((ThemeActiveLogic.ActiveThemeInfo)localObject).actEnd).longValue();
    long l3 = System.currentTimeMillis();
    if (l3 < l1) {
      return BEFORE;
    }
    if (l3 > l2) {
      return AFTER;
    }
    return DURING;
  }
  
  public void downloadTheme(ThemeActiveLogic.ActiveThemeInfo paramActiveThemeInfo)
  {
    ThemeUtil.ThemeInfo localThemeInfo;
    String str2;
    Object localObject;
    String str1;
    long l1;
    int i;
    label368:
    if (paramActiveThemeInfo != null)
    {
      localThemeInfo = getActiveThemeInfoByDensity(paramActiveThemeInfo);
      try
      {
        str2 = localThemeInfo.downloadUrl;
        localObject = localThemeInfo.version;
        str1 = localThemeInfo.themeId;
        l1 = localThemeInfo.size;
        if (!localThemeInfo.isVoiceTheme) {
          break label558;
        }
        i = 1;
        if (QLog.isColorLevel()) {
          QLog.d("ThemeActiveLogic", 2, "ThemeSwitchManager start download theme ver=" + (String)localObject + ",id=" + str1 + ",size=" + l1 + ",isSound=" + i);
        }
        if (!Utils.e())
        {
          if (!QLog.isColorLevel()) {
            break label557;
          }
          QLog.d("ThemeActiveLogic", 2, "SDCard not available.");
          return;
        }
        long l2 = Utils.b();
        if (l2 >= 5242880 + l1) {
          break label248;
        }
        if (!QLog.isColorLevel()) {
          break label557;
        }
        QLog.d("ThemeActiveLogic", 2, "Insufficient SDCard space, required:" + l1 + "| reserved:" + 5242880 + "|available:" + l2);
        return;
      }
      catch (Exception paramActiveThemeInfo)
      {
        paramActiveThemeInfo.printStackTrace();
        if (!QLog.isColorLevel()) {
          break label557;
        }
      }
      QLog.i("ThemeActiveLogic", 2, "Err, " + paramActiveThemeInfo.getMessage());
      return;
      label248:
      if (!NetworkUtil.e(this.mApp.getApplication()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeActiveLogic", 2, "No network access.");
        }
      }
      else if (isThemeExist(str1, (String)localObject, l1))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ThemeActiveLogic", 2, "Theme already exists, themeId=" + str1 + ",version=" + (String)localObject + ",size=" + l1);
        }
        paramActiveThemeInfo = ThemeUtil.getThemeInfo(this.mApp.getApplication(), str1);
        if (paramActiveThemeInfo != null) {
          break label554;
        }
        paramActiveThemeInfo = new ThemeUtil.ThemeInfo();
        paramActiveThemeInfo.downsize = l1;
        paramActiveThemeInfo.size = l1;
        paramActiveThemeInfo.themeId = str1;
        paramActiveThemeInfo.version = ((String)localObject);
        paramActiveThemeInfo.status = "3";
        if (i != 1) {
          break label563;
        }
      }
    }
    label554:
    label557:
    label558:
    label563:
    for (boolean bool = true;; bool = false)
    {
      paramActiveThemeInfo.isVoiceTheme = bool;
      ThemeUtil.setThemeInfo(this.mApp.getApplication(), paramActiveThemeInfo);
      return;
      String str3 = ThemeUtil.getThemeDownloadFilePath(this.mApp.getApplication(), str1, (String)localObject);
      paramActiveThemeInfo = new Bundle();
      paramActiveThemeInfo.putString("id", str1);
      paramActiveThemeInfo.putString("version", (String)localObject);
      paramActiveThemeInfo.putSerializable("themeInfo", localThemeInfo);
      localObject = new DownloadTask(str2, new File(str3));
      ((DownloadTask)localObject).b = true;
      i = (int)(l1 / 50L);
      if (i > 2048) {
        ((DownloadTask)localObject).b(i);
      }
      ((DownloadTask)localObject).b(false);
      ((DownloaderFactory)this.mApp.getManager(46)).a(1).a((DownloadTask)localObject, this.mThemeDownloadListener, paramActiveThemeInfo);
      return;
      break label368;
      return;
      i = 0;
      break;
    }
  }
  
  public ThemeUtil.ThemeInfo getActiveThemeInfoByDensity(ThemeActiveLogic.ActiveThemeInfo paramActiveThemeInfo)
  {
    ThemeUtil.ThemeInfo localThemeInfo = new ThemeUtil.ThemeInfo();
    String str2;
    long l;
    String str1;
    String str3;
    if (paramActiveThemeInfo != null)
    {
      localThemeInfo.themeId = paramActiveThemeInfo.themeID;
      str2 = "";
      l = 0L;
      str1 = "0";
      str3 = ThemeUtil.getThemeDensity(this.mContext);
      if (!str3.equals("m")) {
        break label97;
      }
      l = Long.valueOf(paramActiveThemeInfo.androidMSize).longValue();
      str2 = paramActiveThemeInfo.androidMurl;
      str1 = paramActiveThemeInfo.androidMVersion;
    }
    for (;;)
    {
      localThemeInfo.downloadUrl = str2;
      localThemeInfo.size = l;
      localThemeInfo.version = str1;
      return localThemeInfo;
      label97:
      if (str3.equals("h"))
      {
        l = Long.valueOf(paramActiveThemeInfo.androidHSize).longValue();
        str2 = paramActiveThemeInfo.androidHurl;
        str1 = paramActiveThemeInfo.androidHVersion;
      }
      else if (str3.equals("xh"))
      {
        l = Long.valueOf(paramActiveThemeInfo.androidXHSize).longValue();
        str2 = paramActiveThemeInfo.androidXHurl;
        str1 = paramActiveThemeInfo.androidXHVersion;
      }
    }
  }
  
  public JSONArray getActiveThemeJson()
  {
    try
    {
      Object localObject = ClubContentJsonTask.b(this.mApp);
      if (localObject == null) {
        return null;
      }
      localObject = ((JSONObject)localObject).getJSONObject("data");
      if (localObject != null)
      {
        localObject = ((JSONObject)localObject).getJSONArray("themeAutoSwitch");
        if (localObject != null) {
          return localObject;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public int getNetWorkType()
  {
    int i = NetworkUtil.a(this.mContext);
    if (i == 2) {
      return 2;
    }
    if (i == 3) {
      return 3;
    }
    if (i == 4) {
      return 4;
    }
    if (i == 1) {
      return 5;
    }
    return 0;
  }
  
  public void handleActiveTheme()
  {
    Object localObject1 = getActiveThemeJson();
    if (localObject1 == null) {}
    Object localObject2;
    do
    {
      int i;
      SharedPreferences.Editor localEditor;
      String str;
      do
      {
        do
        {
          long l1;
          long l2;
          long l3;
          do
          {
            do
            {
              return;
              localObject1 = getActiveThemeInfo((JSONArray)localObject1);
            } while ((localObject1 == null) || (!ABListAuth((ThemeActiveLogic.ActiveThemeInfo)localObject1)));
            start((ThemeActiveLogic.ActiveThemeInfo)localObject1);
            i = ((ThemeActiveLogic.ActiveThemeInfo)localObject1).actID;
            l1 = Long.valueOf(((ThemeActiveLogic.ActiveThemeInfo)localObject1).actBegin).longValue();
            l2 = Long.valueOf(((ThemeActiveLogic.ActiveThemeInfo)localObject1).actEnd).longValue();
            l3 = System.currentTimeMillis();
          } while ((l3 < l1) || (l3 > l2));
          localObject2 = ThemeUtil.getUinPreferences(this.mApp);
          localEditor = ((SharedPreferences)localObject2).edit();
        } while ((((SharedPreferences)localObject2).getBoolean("is_first_login_during_active", false)) || (((SharedPreferences)localObject2).getInt("active_theme_sp_key_" + i, 0) != 0));
        localObject2 = getActiveThemeInfoByDensity((ThemeActiveLogic.ActiveThemeInfo)localObject1).version;
        str = ThemeUtil.getThemeResourcePath(this.mApp.getApplication().getApplicationContext(), ((ThemeActiveLogic.ActiveThemeInfo)localObject1).themeID, (String)localObject2);
        if (!new File(str).exists()) {
          break;
        }
      } while (!SkinEngine.getInstances().setSkinRootPath(this.mApp.getApplication(), str));
      ThemeUtil.setCurrentThemeIdVersion(this.mApp, ((ThemeActiveLogic.ActiveThemeInfo)localObject1).themeID, (String)localObject2);
      localEditor.putInt("active_theme_sp_key_" + i, 1);
      localEditor.putBoolean("is_first_login_during_active", true);
      localEditor.commit();
      ((ChatBackgroundManager)this.mApp.getManager(61)).a(this.mApp.a(), null, "null");
      return;
    } while (!new File(ThemeUtil.getThemeDownloadFilePath(this.mApp.getApplication().getApplicationContext(), ((ThemeActiveLogic.ActiveThemeInfo)localObject1).themeID, (String)localObject2)).exists());
    this.mApp.a(new ThemeActiveLogic.2(this, (ThemeActiveLogic.ActiveThemeInfo)localObject1, (String)localObject2));
  }
  
  public void handleDelete(ThemeActiveLogic.ActiveThemeInfo paramActiveThemeInfo)
  {
    if (paramActiveThemeInfo == null) {}
    SharedPreferences localSharedPreferences;
    do
    {
      long l;
      do
      {
        return;
        l = Long.valueOf(paramActiveThemeInfo.actEnd).longValue();
      } while (System.currentTimeMillis() <= l);
      localSharedPreferences = ThemeUtil.getUinPreferences(this.mApp);
    } while ((localSharedPreferences.getInt("active_theme_sp_delete_key_" + paramActiveThemeInfo.actID, 0) != 0) || (!SkinEngine.getInstances().setSkinRootPath(this.mApp.getApplication(), null)));
    ThemeUtil.setCurrentThemeIdVersion(this.mApp, "1000", "0");
    localSharedPreferences.edit().putInt("active_theme_sp_delete_key_" + paramActiveThemeInfo.actID, 1).commit();
    ((ChatBackgroundManager)this.mApp.getManager(61)).a(this.mApp.a(), null, "null");
  }
  
  public boolean isNeedDownload(ThemeActiveLogic.ActiveThemeInfo paramActiveThemeInfo)
  {
    if (paramActiveThemeInfo != null)
    {
      long l1 = Long.valueOf(paramActiveThemeInfo.downBegin).longValue();
      long l2 = Long.valueOf(paramActiveThemeInfo.downEnd).longValue();
      long l3 = System.currentTimeMillis();
      String str1 = getActiveThemeInfoByDensity(paramActiveThemeInfo).version;
      if ((l3 >= l1) && (l3 <= l2))
      {
        String str2 = ThemeUtil.getThemeDownloadFilePath(this.mContext, paramActiveThemeInfo.themeID, str1);
        if ((str2 == null) || (!new File(str2).exists())) {
          break label112;
        }
        this.mApp.a(new ThemeActiveLogic.3(this, paramActiveThemeInfo, str1));
      }
    }
    return false;
    label112:
    return true;
  }
  
  public void start(ThemeActiveLogic.ActiveThemeInfo paramActiveThemeInfo)
  {
    if (paramActiveThemeInfo == null) {}
    int i;
    do
    {
      do
      {
        return;
      } while (!isNeedDownload(paramActiveThemeInfo));
      i = Integer.valueOf(paramActiveThemeInfo.netWork).intValue();
    } while (getNetWorkType() < i);
    downloadTheme(paramActiveThemeInfo);
  }
  
  public void uncompressThemeZip(String paramString1, String paramString2)
  {
    String str = ThemeUtil.getThemeDownloadFilePath(this.mContext, paramString1, paramString2);
    paramString2 = ThemeUtil.getThemeResourcePath(this.mContext, paramString1, paramString2);
    try
    {
      FileUtils.a(str, paramString2, false);
      if (new File(paramString2).exists())
      {
        paramString1 = ThemeUtil.getThemeInfo(this.mApp.getApplication().getApplicationContext(), paramString1);
        if (paramString1 != null)
        {
          paramString1.status = "5";
          ThemeUtil.setThemeInfo(this.mContext, paramString1);
        }
      }
      else
      {
        FileUtils.d(str);
        return;
      }
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeActiveLogic
 * JD-Core Version:    0.7.0.1
 */
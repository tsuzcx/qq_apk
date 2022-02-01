package com.tencent.mobileqq.theme;

import android.app.Activity;
import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NightModeLogic
{
  static final int MSG_URL_JSON_LOADED_FLAG = 4097;
  public static final int NIGHTMODE_ACTION_DOWNLOADING = 3;
  public static final int NIGHTMODE_ACTION_DOWNLOAD_COMPLETE = 4;
  public static final int NIGHTMODE_ACTION_THEMESWITCH_END = 2;
  public static final int NIGHTMODE_ACTION_THEMESWITCH_START = 1;
  public static final int NIGHTMODE_STATUS_NIGHT = 1;
  public static final int NIGHTMODE_STATUS_NOT_NIGHT = 2;
  public static final int NIGHTMODE_STATUS_SWITCHING = 0;
  public static final String TAG = "ThemeSwitch";
  private final String NIGHT_THEME_JSON_NAME = "5.9.3night_theme_json.xml";
  private final String NIGHT_THEME_JSON_URL = "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_theme_night/xydata.json";
  Dialog downloadDialog;
  private Activity mActivity;
  NightModeLogic.NightModeCallback mCallback;
  AppRuntime mRuntime;
  protected Handler.Callback mUrlJsonLoadedUICallback = new NightModeLogic.5(this);
  private ThemeUtil.ThemeInfo nighThemeInfo;
  private ThemeSwitchManager switchManager;
  private Activity waitActivity = null;
  
  public NightModeLogic(AppRuntime paramAppRuntime, Activity paramActivity)
  {
    this.mRuntime = paramAppRuntime;
    this.mActivity = paramActivity;
    buildBaseNightInfo();
  }
  
  private int compareVersion(String paramString1, String paramString2)
  {
    int m = 0;
    int j;
    if ((paramString1 == null) || (paramString2 == null))
    {
      j = 1;
      return j;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    int n = Math.max(paramString1.length, paramString2.length);
    int i = 0;
    for (;;)
    {
      j = m;
      if (i >= n) {
        break;
      }
      if (i >= paramString1.length)
      {
        j = 0;
        if (i < paramString2.length) {
          break label93;
        }
      }
      label93:
      for (int k = 0;; k = Integer.valueOf(paramString2[i]).intValue())
      {
        if (j <= k) {
          break label107;
        }
        return 1;
        j = Integer.valueOf(paramString1[i]).intValue();
        break;
      }
      label107:
      if (j < k) {
        return -1;
      }
      i += 1;
    }
  }
  
  private Dialog newCustomDialog(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    Object localObject2 = this.mActivity.getResources().getString(paramInt1);
    Object localObject1 = this.mActivity.getResources().getString(paramInt2);
    String str2 = this.mActivity.getResources().getString(paramInt3);
    String str1 = this.mActivity.getResources().getString(paramInt4);
    if ((paramString != null) && (!"".equals(paramString))) {}
    for (paramString = String.format((String)localObject1, new Object[] { paramString });; paramString = (String)localObject1)
    {
      localObject1 = new Dialog(this.mActivity, 2131558902);
      ((Dialog)localObject1).setContentView(2130903211);
      TextView localTextView = (TextView)((Dialog)localObject1).findViewById(2131297367);
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject2);
      }
      localObject2 = (TextView)((Dialog)localObject1).findViewById(2131296606);
      if (localObject2 != null) {
        ((TextView)localObject2).setText(paramString);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131297370);
      if (paramString != null)
      {
        paramString.setText(str2);
        paramString.setOnClickListener(paramOnClickListener1);
      }
      paramString = (TextView)((Dialog)localObject1).findViewById(2131297371);
      if (paramString != null)
      {
        paramString.setText(str1);
        paramString.setOnClickListener(paramOnClickListener2);
      }
      return localObject1;
    }
  }
  
  private boolean setNightThemeURLInfo(JSONObject paramJSONObject, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramJSONObject != null) {
      if (paramString != null)
      {
        SharedPreferences localSharedPreferences = this.mActivity.getSharedPreferences("userThemeSharedPreferences", 0);
        paramString = "night_theme_info_" + paramString + "_" + "5.9.3";
        localSharedPreferences.edit().putString(paramString, paramJSONObject.toString()).commit();
      }
    }
    try
    {
      this.nighThemeInfo.downloadUrl = paramJSONObject.getString("url").trim();
      this.nighThemeInfo.size = Long.parseLong(paramJSONObject.getString("fileSize").trim());
      this.nighThemeInfo.version = paramJSONObject.getString("version").trim();
      paramJSONObject = ThemeUtil.getThemeInfo(this.mRuntime.getApplication().getApplicationContext(), this.nighThemeInfo.themeId);
      if ((paramJSONObject != null) && (paramJSONObject.version != null) && (this.nighThemeInfo.version != null) && (Integer.valueOf(paramJSONObject.version).intValue() > Integer.valueOf(this.nighThemeInfo.version).intValue())) {
        this.nighThemeInfo.version = paramJSONObject.version;
      }
      bool1 = true;
    }
    catch (JSONException paramJSONObject)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("setNightThemeInfoJson", 2, paramJSONObject.getMessage());
      return false;
    }
    catch (Exception paramJSONObject)
    {
      do
      {
        bool1 = bool2;
      } while (!QLog.isColorLevel());
      QLog.d("setNightThemeInfoJson1:", 2, paramJSONObject.getMessage());
    }
    return bool1;
    return false;
  }
  
  private boolean setNightThemeURLInfo(boolean paramBoolean)
  {
    if (this.mRuntime == null) {
      return false;
    }
    String str2 = ThemeUtil.getThemeDensity(this.mRuntime.getApplication().getApplicationContext());
    boolean bool;
    if (!paramBoolean)
    {
      String str1 = this.mActivity.getSharedPreferences("userThemeSharedPreferences", 0).getString("night_theme_info_" + str2 + "_" + "5.9.3", null);
      if (str1 != null) {
        try
        {
          bool = setNightThemeURLInfo(new JSONObject(str1), null);
          if (bool) {
            return true;
          }
        }
        catch (JSONException localJSONException)
        {
          if (QLog.isColorLevel()) {
            QLog.d("setNightThemeInfoJson", 2, localJSONException.getMessage());
          }
        }
      }
    }
    Object localObject1 = new File(AppConstants.aG + "data/theme_night/", "5.9.3night_theme_json.xml");
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(FileUtils.a((File)localObject1)).getJSONObject("data").getJSONArray("nightThemeInfo");
        int i = ((JSONArray)localObject1).length() - 1;
        if (i < 0) {
          break label361;
        }
        JSONObject localJSONObject = ((JSONArray)localObject1).getJSONObject(i);
        if ((localJSONObject != null) && ("1".equals(localJSONObject.getString("platform"))) && ("1103".equals(localJSONObject.getString("id"))) && (compareVersion("5.9.3", localJSONObject.getString("minVersion")) >= 0) && (compareVersion("5.9.3", localJSONObject.getString("maxVersion")) <= 0))
        {
          localObject1 = localJSONObject.getJSONObject("themeInfo");
          if (localObject1 != null)
          {
            bool = setNightThemeURLInfo(((JSONObject)localObject1).getJSONObject(str2), str2);
            if (bool) {
              return true;
            }
          }
        }
        else
        {
          i -= 1;
          continue;
        }
        if (paramBoolean) {
          break;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("setNightThemeInfoJson", 2, localException.getMessage());
        }
      }
      ThreadManager.a(new NightModeLogic.4(this));
      return false;
      label361:
      Object localObject2 = null;
    }
  }
  
  private void showDownloadDialog()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "showDownloadDialog");
    }
    this.downloadDialog = newCustomDialog(2131366740, 2131366741, 2131365736, 2131367132, (float)Math.round(getNightThemeInfo().size / 1024.0D / 1024.0D * 100.0D) / 100.0F + "", new NightModeLogic.1(this), new NightModeLogic.2(this));
    this.downloadDialog.setOnDismissListener(new NightModeLogic.3(this));
    this.downloadDialog.show();
  }
  
  public void buildBaseNightInfo()
  {
    this.nighThemeInfo = new ThemeUtil.ThemeInfo();
    this.nighThemeInfo.isVoiceTheme = false;
    this.nighThemeInfo.themeId = "1103";
    setNightThemeURLInfo(false);
  }
  
  public void destroy()
  {
    if (this.switchManager != null) {
      this.switchManager.manageCallbacks(this.mCallback, false, true);
    }
    this.mCallback = null;
    this.mActivity = null;
    this.mRuntime = null;
  }
  
  public boolean downLoadNightTheme()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "downLoadNightTheme nightthemeInfo");
    }
    if (ThemeSwitchManager.isDownloadingInProgress)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ThemeSwitch", 2, "downLoadNightTheme is downloading theme");
      }
      return false;
    }
    this.switchManager.startDownload(this.mRuntime, getNightThemeInfo());
    return true;
  }
  
  public int getNightModeStatus()
  {
    int i = 2;
    ThemeUtil.ThemeInfo localThemeInfo = getNightThemeInfo();
    if ((isDownloadOrSwtich()) || ((localThemeInfo != null) && (localThemeInfo.status.equals("2"))))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "switchRightViewImage status: juhua");
      }
      i = 0;
    }
    do
    {
      return i;
      if (isCurrentNightMode())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "switchRightViewImage status: sun");
        }
        return 1;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ThemeSwitch", 2, "switchRightViewImage status: moon");
    return 2;
  }
  
  public ThemeUtil.ThemeInfo getNightThemeInfo()
  {
    Object localObject;
    if (this.mRuntime == null) {
      localObject = this.nighThemeInfo;
    }
    ThemeUtil.ThemeInfo localThemeInfo;
    do
    {
      return localObject;
      localThemeInfo = ThemeUtil.getThemeInfo(this.mRuntime.getApplication().getApplicationContext(), this.nighThemeInfo.themeId);
      if ((localThemeInfo == null) || (localThemeInfo.version == null) || (!localThemeInfo.version.equals(this.nighThemeInfo.version)) || (!isThemeExist(localThemeInfo, false))) {
        break;
      }
      localObject = localThemeInfo;
    } while (!localThemeInfo.status.equals("2"));
    if (QLog.isColorLevel()) {
      QLog.w("ThemeSwitch", 2, "theme info status update");
    }
    localThemeInfo.status = "5";
    ThemeUtil.setThemeInfo(this.mRuntime.getApplication().getApplicationContext(), localThemeInfo);
    return localThemeInfo;
    return this.nighThemeInfo;
  }
  
  public void initSwitchManger(Activity paramActivity)
  {
    if (this.switchManager == null) {
      this.switchManager = ThemeSwitchManager.getThemeSwitchManagerInstance(paramActivity);
    }
    this.switchManager.setActivity(paramActivity);
  }
  
  public boolean isCurrentNightMode()
  {
    String str = ThemeUtil.getUserCurrentThemeId((QQAppInterface)this.mRuntime);
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitch", 2, "isCurrentNightMode currthemeID=" + str);
    }
    return str.equals(this.nighThemeInfo.themeId);
  }
  
  public boolean isDownloadOrSwtich()
  {
    if (QLog.isColorLevel()) {
      QLog.w("ThemeSwitch", 2, "isDownloadOrSwtich isDownloadingInProgress=" + ThemeSwitchManager.isDownloadingInProgress + ", isSwitchTheme=" + ThemeSwitchManager.isSwitchTheme);
    }
    return (ThemeSwitchManager.isDownloadingInProgress) || (ThemeSwitchManager.isSwitchTheme);
  }
  
  public boolean isThemeExist(ThemeUtil.ThemeInfo paramThemeInfo, boolean paramBoolean)
  {
    boolean bool = true;
    if (paramThemeInfo == null) {}
    ThemeUtil.ThemeInfo localThemeInfo;
    Object localObject;
    do
    {
      return false;
      localThemeInfo = ThemeUtil.getThemeInfo(this.mRuntime.getApplication().getApplicationContext(), paramThemeInfo.themeId);
      localObject = ThemeUtil.getThemeDownloadFilePath(this.mRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version);
      String str = ThemeUtil.getThemeResourcePath(this.mRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version);
      localObject = new File((String)localObject);
      if ((localThemeInfo == null) || ((!localThemeInfo.status.equals("5")) && (!localThemeInfo.status.equals("3")))) {
        break;
      }
      if (new File(str).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ThemeSwitch", 2, "isThemeExist themeResPath exists,themeResPath=" + str);
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ThemeSwitch", 2, "isThemeExist themeResPath dir is not exists,themeResPath=" + str);
      }
    } while (paramBoolean);
    if (localThemeInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ThemeSwitch", 2, "isThemeExist info is null");
      }
      if ((paramThemeInfo.themeId.equals(this.nighThemeInfo.themeId)) && (paramThemeInfo.version.equals(this.nighThemeInfo.version))) {
        if ((((File)localObject).exists()) && (((File)localObject).length() == this.nighThemeInfo.size))
        {
          paramThemeInfo.status = "1";
          paramThemeInfo.isVoiceTheme = this.nighThemeInfo.isVoiceTheme;
          paramThemeInfo.downloadUrl = this.nighThemeInfo.downloadUrl;
          paramThemeInfo.size = this.nighThemeInfo.size;
          if (new File(ThemeUtil.getThemeResourcePath(this.mRuntime.getApplication(), paramThemeInfo.themeId, paramThemeInfo.version)).exists())
          {
            paramThemeInfo.status = "5";
            ThemeUtil.setThemeInfo(this.mRuntime.getApplication().getApplicationContext(), paramThemeInfo);
            paramBoolean = bool;
          }
        }
      }
    }
    for (;;)
    {
      return paramBoolean;
      paramThemeInfo.status = "3";
      break;
      ((File)localObject).delete();
      paramBoolean = false;
      continue;
      paramBoolean = false;
      continue;
      if (((File)localObject).exists())
      {
        paramBoolean = bool;
        if (((File)localObject).length() == paramThemeInfo.size) {}
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("ThemeSwitch", 2, "isThemeExist themePkgFile is not exists or size is not match");
        }
        paramBoolean = false;
      }
    }
  }
  
  public void onAccountChanged(AppRuntime paramAppRuntime)
  {
    this.mRuntime = paramAppRuntime;
  }
  
  public void onPostThemeChanged()
  {
    if (this.switchManager != null) {
      this.switchManager.onPostThemeChanged();
    }
  }
  
  public void registerModeCallback(NightModeLogic.NightModeCallback paramNightModeCallback)
  {
    initSwitchManger(this.mActivity);
    if (this.switchManager != null)
    {
      this.switchManager.manageCallbacks(paramNightModeCallback, true, false);
      this.mCallback = paramNightModeCallback;
    }
  }
  
  public boolean setupNightTheme()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ThemeSwitch", 4, "setupNightTheme");
    }
    if (ThemeSwitchManager.isSwitchTheme)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ThemeSwitch", 2, "is switching theme");
      }
      return false;
    }
    boolean bool = isCurrentNightMode();
    Object localObject1 = new ThemeUtil.ThemeInfo();
    if (!bool)
    {
      localObject1 = getNightThemeInfo();
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "1", "", "", "");
      ReportController.b((QQAppInterface)this.mRuntime, "CliStatus", "", "", "Setting_tab", "Night_mode", 0, 1, "", "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitch", 2, "setupNightTheme themeID=" + ((ThemeUtil.ThemeInfo)localObject1).themeId);
      }
      initSwitchManger(this.mActivity);
      this.switchManager.setup(this.mRuntime, (ThemeUtil.ThemeInfo)localObject1);
      return true;
    }
    Object localObject2 = ThemeSwitchUtil.getPreviousThemeIdVersion((QQAppInterface)this.mRuntime);
    localObject2 = ThemeUtil.getThemeInfo(this.mRuntime.getApplication().getApplicationContext(), ((Bundle)localObject2).getString("themeID"));
    if (localObject2 != null) {
      localObject1 = localObject2;
    }
    for (;;)
    {
      if (!isThemeExist((ThemeUtil.ThemeInfo)localObject1, false))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ThemeSwitch", 2, "setupNightTheme theme is not exists, so setup default theme");
        }
        ((ThemeUtil.ThemeInfo)localObject1).themeId = "1000";
        ((ThemeUtil.ThemeInfo)localObject1).version = "0";
      }
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "0", "", "", "");
      break;
    }
  }
  
  public void startNightMode(Activity paramActivity)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ThemeSwitch", 4, "startNightMode");
    }
    if (((this.nighThemeInfo.downloadUrl == null) || (this.nighThemeInfo.downloadUrl.equals(""))) && (!setNightThemeURLInfo(false))) {
      this.waitActivity = paramActivity;
    }
    do
    {
      return;
      ThemeUtil.ThemeInfo localThemeInfo = getNightThemeInfo();
      if ((!isDownloadOrSwtich()) && ((localThemeInfo == null) || (!localThemeInfo.status.equals("2")))) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("ThemeSwitch", 4, "startNightMode is download or switching theme");
    return;
    initSwitchManger(paramActivity);
    if ((!isCurrentNightMode()) && (!isThemeExist(getNightThemeInfo(), false)))
    {
      showDownloadDialog();
      ReportController.b((QQAppInterface)this.mRuntime, "CliOper", "", "", "Setting_tab", "Night_mode", 0, 0, "2", "", "", "");
      return;
    }
    if ((this.mCallback != null) && (!ThemeSwitchManager.isSwitchTheme))
    {
      paramActivity = new Bundle();
      paramActivity.putInt("start_status", 1);
      this.mCallback.c(paramActivity);
    }
    setupNightTheme();
  }
  
  public void unRegisterModeCallback(NightModeLogic.NightModeCallback paramNightModeCallback)
  {
    initSwitchManger(this.mActivity);
    if (this.switchManager != null)
    {
      this.switchManager.manageCallbacks(paramNightModeCallback, false, true);
      this.mCallback = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic
 * JD-Core Version:    0.7.0.1
 */
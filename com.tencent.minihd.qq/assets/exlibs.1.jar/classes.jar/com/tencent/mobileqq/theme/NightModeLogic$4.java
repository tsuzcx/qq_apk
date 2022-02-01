package com.tencent.mobileqq.theme;

import android.os.Looper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class NightModeLogic$4
  implements Runnable
{
  NightModeLogic$4(NightModeLogic paramNightModeLogic) {}
  
  public void run()
  {
    boolean bool = HttpDownloadUtil.a(null, "https://i.gtimg.cn/qqshow/admindata/comdata/vipData_theme_night/xydata.json", new File(AppConstants.aG + "data/theme_night/", "5.9.3night_theme_json.xml"));
    if (QLog.isColorLevel()) {
      QLog.d("downloadThemeInfoJson", 2, "downloadThemeInfoJson, https://i.gtimg.cn/qqshow/admindata/comdata/vipData_theme_night/xydata.json,ret=" + bool);
    }
    if ((bool) && (NightModeLogic.access$000(this.this$0, true)) && (NightModeLogic.access$100(this.this$0) != null)) {
      new CustomHandler(Looper.getMainLooper(), this.this$0.mUrlJsonLoadedUICallback).sendEmptyMessage(4097);
    }
    NightModeLogic.access$102(this.this$0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.NightModeLogic.4
 * JD-Core Version:    0.7.0.1
 */
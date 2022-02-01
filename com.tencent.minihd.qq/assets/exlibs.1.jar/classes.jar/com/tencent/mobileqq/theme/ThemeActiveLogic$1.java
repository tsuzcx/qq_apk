package com.tencent.mobileqq.theme;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;

class ThemeActiveLogic$1
  extends DownloadListener
{
  ThemeActiveLogic$1(ThemeActiveLogic paramThemeActiveLogic, String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    if (paramDownloadTask.a() == 3)
    {
      Object localObject = paramDownloadTask.a();
      paramDownloadTask = ((Bundle)localObject).getString("id");
      String str = ((Bundle)localObject).getString("version");
      localObject = (ThemeUtil.ThemeInfo)((Bundle)localObject).getSerializable("themeInfo");
      ((ThemeUtil.ThemeInfo)localObject).status = "3";
      ThemeUtil.setThemeInfo(this.this$0.mContext, (ThemeUtil.ThemeInfo)localObject);
      this.this$0.uncompressThemeZip(paramDownloadTask, str);
    }
  }
  
  public boolean onStart(DownloadTask paramDownloadTask)
  {
    return super.onStart(paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.ThemeActiveLogic.1
 * JD-Core Version:    0.7.0.1
 */
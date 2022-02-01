package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Process;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.utils.DisplayUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

class ThemeDIYActivity$DoBrightnessTask
  extends AsyncTask
{
  ThemeDIYData data;
  String orgSrc;
  String saveSrc;
  
  public ThemeDIYActivity$DoBrightnessTask(ThemeDIYActivity paramThemeDIYActivity, String paramString, ThemeDIYData paramThemeDIYData)
  {
    this.orgSrc = paramString;
    this.data = paramThemeDIYData;
  }
  
  protected Integer doInBackground(Object... paramVarArgs)
  {
    paramVarArgs = new BitmapFactory.Options();
    paramVarArgs.inPreferredConfig = Bitmap.Config.RGB_565;
    paramVarArgs = BitmapManager.a(this.orgSrc, paramVarArgs);
    if (paramVarArgs == null) {
      return Integer.valueOf(0);
    }
    int m = this.data.dealInt;
    int n = paramVarArgs.getWidth();
    int i1 = paramVarArgs.getHeight() - (int)(DisplayUtils.a(this.this$0.mContext, 113.0F) / 4.0F * 3.0F);
    int i2 = (int)(DisplayUtils.a(this.this$0.mContext, 51.0F) / 4.0F * 3.0F);
    Bitmap localBitmap;
    for (;;)
    {
      int i;
      int i5;
      int i6;
      try
      {
        localBitmap = Bitmap.createBitmap(n, i1, paramVarArgs.getConfig());
        i = 0;
        if (i >= n) {
          break;
        }
        int j = 0;
        if (j >= i1) {
          break label329;
        }
        k = paramVarArgs.getPixel(i, j + i2);
        int i3 = Color.alpha(k);
        int i4 = Color.red(k);
        i5 = Color.green(k);
        i6 = Color.blue(k);
        if (m > 0)
        {
          k = 255 - i4;
          int i7 = k * m / 100;
          if (m <= 0) {
            break label311;
          }
          k = 255 - i5;
          int i8 = k * m / 100;
          if (m <= 0) {
            break label320;
          }
          k = 255 - i6;
          localBitmap.setPixel(i, j, Color.argb(i3, i4 + i7, i5 + i8, k * m / 100 + i6));
          j += 1;
          continue;
        }
        k = 0 - i4;
      }
      catch (OutOfMemoryError paramVarArgs)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ThemeDIYActivity", 2, "DoBrightnessTask " + paramVarArgs.getMessage());
        }
        return Integer.valueOf(0);
      }
      continue;
      label311:
      int k = 0 - i5;
      continue;
      label320:
      k = 0 - i6;
      continue;
      label329:
      i += 1;
    }
    try
    {
      this.saveSrc = (this.orgSrc.substring(0, this.orgSrc.length() - 3) + "png");
      ImageUtil.a(localBitmap, new File(this.saveSrc));
      return Integer.valueOf(1);
    }
    catch (IOException paramVarArgs)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ThemeDIYActivity", 2, "DoBrightnessTask1 " + paramVarArgs.getMessage());
      }
    }
    return Integer.valueOf(0);
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    if (paramInteger.intValue() == 1)
    {
      ThemeBackground.setThemeBackgroundPic(this.this$0.mContext, this.data.dealSpkey, this.this$0.app.a(), this.saveSrc);
      if (ThemeDIYActivity.isBacked)
      {
        paramInteger = new Intent("com.tencent.qplus.THEME_INVALIDATE");
        paramInteger.putExtra("pid", Process.myPid());
        this.this$0.mContext.sendBroadcast(paramInteger, "com.tencent.msg.permission.pushnotify2");
      }
    }
    this.data = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.DoBrightnessTask
 * JD-Core Version:    0.7.0.1
 */
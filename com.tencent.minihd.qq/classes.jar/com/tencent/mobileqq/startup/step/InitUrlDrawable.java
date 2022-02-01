package com.tencent.mobileqq.startup.step;

import android.content.res.Resources;
import android.os.Environment;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import jvz;

public class InitUrlDrawable
  extends Step
{
  public static DiskCache a;
  
  protected boolean a()
  {
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.a;
    URLDrawable.DEBUG = false;
    File localFile;
    if ("mounted".equals(Environment.getExternalStorageState())) {
      localFile = new File(AppConstants.aG);
    }
    try
    {
      for (;;)
      {
        URLDrawable.init(localBaseApplicationImpl, new jvz(localBaseApplicationImpl));
        localFile = new File(localFile, "diskcache");
        if (localFile != null) {
          break;
        }
        localFile = Utils.getExternalCacheDir(localBaseApplicationImpl);
        a = new DiskCache(localFile);
        URLDrawableHelper.a = localFile;
        URLDrawableHelper.i = (int)(URLDrawableHelper.e * localBaseApplicationImpl.getResources().getDisplayMetrics().density);
        URLDrawableHelper.j = (int)(URLDrawableHelper.f * localBaseApplicationImpl.getResources().getDisplayMetrics().density);
        return true;
        localFile = localBaseApplicationImpl.getCacheDir();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.InitUrlDrawable
 * JD-Core Version:    0.7.0.1
 */
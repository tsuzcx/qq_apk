package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.mm.network.a;
import com.tencent.mm.network.af;
import com.tencent.mm.network.v;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.o;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppCallBack
  implements AppLogic.ICallBack
{
  private static final String TAG = "AppCallBack";
  private Context context = null;
  AppLogic.DeviceInfo info = new AppLogic.DeviceInfo(d.DEVICE_NAME, d.ics);
  
  public AppCallBack(Context paramContext)
  {
    this.context = paramContext;
  }
  
  private static String exception2String(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public AppLogic.AccountInfo getAccountInfo()
  {
    AppLogic.AccountInfo localAccountInfo = new AppLogic.AccountInfo();
    if ((af.bkl() == null) || (af.bkl().jEj == null)) {}
    for (;;)
    {
      return localAccountInfo;
      try
      {
        localAccountInfo.uin = af.bkl().jEj.getUin();
        localAccountInfo.userName = af.bkl().jEj.aZd();
        if (Util.isNullOrNil(localAccountInfo.userName))
        {
          localAccountInfo.userName = af.bkl().jEj.getUsername();
          return localAccountInfo;
        }
      }
      catch (Exception localException) {}
    }
    return localAccountInfo;
  }
  
  public String getAppFilePath()
  {
    if (this.context == null)
    {
      Assert.assertTrue(false);
      return null;
    }
    try
    {
      Object localObject = o.X(this.context.getFilesDir());
      if (!((o)localObject).exists()) {
        ((o)localObject).createNewFile();
      }
      localObject = ((o)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      Log.e("AppCallBack", exception2String(localException));
      Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return "";
  }
  
  public int getClientVersion()
  {
    return d.KyO;
  }
  
  public String getCurLanguage()
  {
    return LocaleUtil.getApplicationLanguage();
  }
  
  public AppLogic.DeviceInfo getDeviceType()
  {
    return this.info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mars.mm.AppCallBack
 * JD-Core Version:    0.7.0.1
 */
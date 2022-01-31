package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.mm.network.a;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppCallBack
  implements AppLogic.ICallBack
{
  private static final String TAG = "AppCallBack";
  private Context context = null;
  AppLogic.DeviceInfo info = new AppLogic.DeviceInfo(d.DEVICE_NAME, d.dOM);
  
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
    if ((aa.Uu() == null) || (aa.Uu().eNL == null)) {}
    for (;;)
    {
      return localAccountInfo;
      try
      {
        localAccountInfo.uin = aa.Uu().eNL.CK();
        localAccountInfo.userName = aa.Uu().eNL.Lm();
        if (bk.bl(localAccountInfo.userName))
        {
          localAccountInfo.userName = aa.Uu().eNL.getUsername();
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
      Object localObject = this.context.getFilesDir();
      if (!((File)localObject).exists()) {
        ((File)localObject).createNewFile();
      }
      localObject = ((File)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      y.e("AppCallBack", exception2String(localException));
      Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return null;
  }
  
  public int getClientVersion()
  {
    return d.spa;
  }
  
  public String getCurLanguage()
  {
    return x.cqJ();
  }
  
  public AppLogic.DeviceInfo getDeviceType()
  {
    return this.info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mars.mm.AppCallBack
 * JD-Core Version:    0.7.0.1
 */
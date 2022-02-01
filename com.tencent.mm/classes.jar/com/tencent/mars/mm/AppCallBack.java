package com.tencent.mars.mm;

import android.content.Context;
import com.tencent.mars.app.AppLogic.AccountInfo;
import com.tencent.mars.app.AppLogic.DeviceInfo;
import com.tencent.mars.app.AppLogic.ICallBack;
import com.tencent.mm.network.a;
import com.tencent.mm.network.t;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vfs.e;
import java.io.PrintWriter;
import java.io.StringWriter;

public class AppCallBack
  implements AppLogic.ICallBack
{
  private static final String TAG = "AppCallBack";
  private Context context = null;
  AppLogic.DeviceInfo info = new AppLogic.DeviceInfo(d.DEVICE_NAME, d.glX);
  
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
    if ((com.tencent.mm.network.ad.aFo() == null) || (com.tencent.mm.network.ad.aFo().hKZ == null)) {}
    for (;;)
    {
      return localAccountInfo;
      try
      {
        localAccountInfo.uin = com.tencent.mm.network.ad.aFo().hKZ.getUin();
        localAccountInfo.userName = com.tencent.mm.network.ad.aFo().hKZ.avc();
        if (bt.isNullOrNil(localAccountInfo.userName))
        {
          localAccountInfo.userName = com.tencent.mm.network.ad.aFo().hKZ.getUsername();
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
      Object localObject = e.R(this.context.getFilesDir());
      if (!((e)localObject).exists()) {
        ((e)localObject).createNewFile();
      }
      localObject = ((e)localObject).toString();
      return localObject;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.ad.e("AppCallBack", exception2String(localException));
      Assert.assertTrue(localException.getClass().getSimpleName() + ":" + localException.getStackTrace()[0] + ", " + localException.getStackTrace()[1], false);
    }
    return "";
  }
  
  public int getClientVersion()
  {
    return d.CpK;
  }
  
  public String getCurLanguage()
  {
    return ac.eFu();
  }
  
  public AppLogic.DeviceInfo getDeviceType()
  {
    return this.info;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mars.mm.AppCallBack
 * JD-Core Version:    0.7.0.1
 */
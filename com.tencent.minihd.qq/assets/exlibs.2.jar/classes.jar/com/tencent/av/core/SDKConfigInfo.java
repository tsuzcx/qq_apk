package com.tencent.av.core;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Environment;
import android.os.Process;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class SDKConfigInfo
{
  public boolean isDebugVersion = false;
  public boolean isGrayVersion = false;
  public boolean isPublicVersion = true;
  public String logDir = "";
  public String processName = "";
  private int terminalType = 4;
  
  public SDKConfigInfo(Context paramContext) {}
  
  private String getLogDir(Context paramContext)
  {
    String str = "";
    if ("mounted".equals(Environment.getExternalStorageState()))
    {
      str = Environment.getExternalStorageDirectory().getPath();
      paramContext = paramContext.getPackageName().replace(".", File.separator);
      str = str + File.separator + "tencent" + File.separator + "msflogs" + File.separator + paramContext + File.separator;
    }
    return str;
  }
  
  private String getProcessName(Context paramContext)
  {
    String str = "";
    int i = Process.myPid();
    Object localObject = (ActivityManager)paramContext.getSystemService("activity");
    paramContext = str;
    if (localObject != null)
    {
      localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
      do
      {
        paramContext = str;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        paramContext = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      } while (paramContext.pid != i);
      paramContext = paramContext.processName;
    }
    return paramContext;
  }
  
  public String toString()
  {
    return String.format("SDKConfigInfo{logDir=%s processName=%s isDebugVersion=%s isGrayVersion=%s isPublicVersion=%s}", new Object[] { this.logDir, this.processName, Boolean.valueOf(this.isDebugVersion), Boolean.valueOf(this.isGrayVersion), Boolean.valueOf(this.isPublicVersion) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.core.SDKConfigInfo
 * JD-Core Version:    0.7.0.1
 */
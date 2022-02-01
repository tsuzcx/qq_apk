package com.tencent.midas.comm;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.APLogFileInfo;
import com.tencent.midas.comm.log.processor.APLogEncryptor;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class APLogInfo
{
  public static final String LOG_TAG = "MidasComm<Log>";
  public static final int LOG_VERSION_CODE = 43;
  public static final String LOG_VERSION_NAME = "1.2.23";
  private boolean autoFlush = true;
  private boolean compressLog = true;
  private Context context = null;
  private boolean encryptLog = true;
  private boolean hasWritePermission = false;
  private String logCallbackClassName;
  private boolean logEnable = true;
  private String logPath = "";
  private String logTag = "Midas";
  private String pkgName = "";
  private boolean printLog = false;
  private String processName = "";
  private boolean writeLog = true;
  
  private void initLogPath()
  {
    AppMethodBeat.i(253940);
    try
    {
      if (!this.hasWritePermission)
      {
        localObject = this.context.getExternalFilesDir("midas" + File.separator + "log" + File.separator);
        if (localObject != null) {
          break label153;
        }
      }
      label153:
      for (Object localObject = "";; localObject = ((File)localObject).getPath())
      {
        this.logPath = ((String)localObject);
        if ((TextUtils.isEmpty(this.logPath)) || (!new File(this.logPath).canWrite())) {
          this.logPath = (Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "Midas" + File.separator + "Log" + File.separator);
        }
        AppMethodBeat.o(253940);
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      new StringBuilder("init log path error: ").append(localThrowable.getMessage());
      this.logPath = (Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "Midas" + File.separator + "Log" + File.separator);
      AppMethodBeat.o(253940);
    }
  }
  
  private void initPermission()
  {
    AppMethodBeat.i(253936);
    if (this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pkgName) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasWritePermission = bool;
      new StringBuilder("has WRITE_EXTERNAL_STORAGE? : ").append(this.hasWritePermission);
      AppMethodBeat.o(253936);
      return;
    }
  }
  
  private void initPkgName()
  {
    AppMethodBeat.i(253934);
    if (this.context == null)
    {
      AppMethodBeat.o(253934);
      return;
    }
    PackageManager localPackageManager = this.context.getPackageManager();
    try
    {
      this.pkgName = localPackageManager.getPackageInfo(this.context.getApplicationContext().getPackageName(), 0).packageName;
      new StringBuilder("get pkgName: ").append(this.pkgName);
      AppMethodBeat.o(253934);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        new StringBuilder("getPackage: ").append(localThrowable.toString());
      }
    }
  }
  
  private void initProcessName()
  {
    AppMethodBeat.i(253938);
    for (;;)
    {
      try
      {
        int i = Process.myPid();
        Object localObject = (ActivityManager)this.context.getSystemService("activity");
        if (localObject != null)
        {
          localObject = ((ActivityManager)localObject).getRunningAppProcesses().iterator();
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
            if (localRunningAppProcessInfo.pid != i) {
              continue;
            }
            localObject = localRunningAppProcessInfo.processName.split(":");
            if (localObject.length <= 1) {
              continue;
            }
            this.processName = localObject[1];
          }
        }
      }
      catch (Throwable localThrowable)
      {
        new StringBuilder("get process: ").append(localThrowable.toString());
        continue;
      }
      new StringBuilder("get process name: ").append(this.processName);
      AppMethodBeat.o(253938);
      return;
      this.processName = "";
    }
  }
  
  private void setPrintLog(boolean paramBoolean)
  {
    this.printLog = paramBoolean;
  }
  
  private void setWriteLog(boolean paramBoolean)
  {
    this.writeLog = paramBoolean;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public String getLogCallbackClassName()
  {
    return this.logCallbackClassName;
  }
  
  public String getLogPath()
  {
    return this.logPath;
  }
  
  public String getLogTag()
  {
    return this.logTag;
  }
  
  public String getPkgName()
  {
    return this.pkgName;
  }
  
  public String getProcessName()
  {
    return this.processName;
  }
  
  public void init()
  {
    AppMethodBeat.i(253932);
    if (this.context == null)
    {
      AppMethodBeat.o(253932);
      return;
    }
    initPkgName();
    initPermission();
    initProcessName();
    initLogPath();
    AppMethodBeat.o(253932);
  }
  
  public boolean isAutoFlush()
  {
    return this.autoFlush;
  }
  
  public boolean isCompressLog()
  {
    return this.compressLog;
  }
  
  public boolean isEncryptLog()
  {
    return this.encryptLog;
  }
  
  public boolean isHasWritePermission()
  {
    return this.hasWritePermission;
  }
  
  public boolean isLogEnable()
  {
    return this.logEnable;
  }
  
  public boolean isPrintLog()
  {
    return this.printLog;
  }
  
  public boolean isWriteLog()
  {
    return this.writeLog;
  }
  
  public void setAutoFlush(boolean paramBoolean)
  {
    this.autoFlush = paramBoolean;
  }
  
  public void setCompressLog(boolean paramBoolean)
  {
    this.compressLog = paramBoolean;
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(253944);
    this.context = paramContext.getApplicationContext();
    AppMethodBeat.o(253944);
  }
  
  public void setEncryptKey(String paramString)
  {
    AppMethodBeat.i(253955);
    APLogEncryptor.setEncryptKey(paramString);
    AppMethodBeat.o(253955);
  }
  
  public void setEncryptLog(boolean paramBoolean)
  {
    this.encryptLog = paramBoolean;
  }
  
  public void setEncryptProtocolVersion(byte paramByte)
  {
    AppMethodBeat.i(253957);
    APLogEncryptor.setProtocolVersion(paramByte);
    AppMethodBeat.o(253957);
  }
  
  public void setLogCallbackClassName(String paramString)
  {
    this.logCallbackClassName = paramString;
  }
  
  public void setLogEnable(boolean paramBoolean)
  {
    this.logEnable = paramBoolean;
  }
  
  public void setLogFileKeepDays(int paramInt)
  {
    APLogFileUtil.maxLogKeepDays = paramInt;
  }
  
  public void setLogFileNum(int paramInt)
  {
    APLogFileUtil.maxLogFileNum = paramInt;
  }
  
  public void setLogFileSizeMB(int paramInt)
  {
    AppMethodBeat.i(253959);
    APLogFileUtil.maxLogFileSizeMB = paramInt;
    new StringBuilder("set log file size: ").append(paramInt).append(" MB");
    AppMethodBeat.o(253959);
  }
  
  public void setLogParamFromServer(String paramString)
  {
    AppMethodBeat.i(253948);
    setLogWrite(paramString);
    AppMethodBeat.o(253948);
  }
  
  public void setLogPath(String paramString)
  {
    this.logPath = paramString;
  }
  
  public void setLogTag(String paramString)
  {
    this.logTag = paramString;
  }
  
  public void setLogWrite(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(253949);
    try
    {
      i = Integer.valueOf(paramString).intValue();
      if ((i & 0x1) == 1)
      {
        bool1 = true;
        setPrintLog(bool1);
        if ((i & 0x2) != 2) {
          break label64;
        }
        bool1 = bool2;
        setWriteLog(bool1);
        AppMethodBeat.o(253949);
      }
    }
    catch (Throwable paramString)
    {
      for (;;)
      {
        int i = 3;
        continue;
        boolean bool1 = false;
        continue;
        label64:
        bool1 = false;
      }
    }
  }
  
  public boolean shouldPrintLog()
  {
    AppMethodBeat.i(253951);
    if ((this.logEnable) || (this.printLog) || (APLogFileUtil.isDebugMode(APLogFileInfo.dirName)))
    {
      AppMethodBeat.o(253951);
      return true;
    }
    AppMethodBeat.o(253951);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.midas.comm.APLogInfo
 * JD-Core Version:    0.7.0.1
 */
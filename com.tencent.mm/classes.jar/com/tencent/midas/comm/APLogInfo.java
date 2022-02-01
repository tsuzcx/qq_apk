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
    AppMethodBeat.i(217198);
    try
    {
      if (!this.hasWritePermission)
      {
        localObject1 = this.context.getExternalFilesDir("midas" + File.separator + "log" + File.separator);
        if (localObject1 != null) {
          break label153;
        }
      }
      label153:
      for (Object localObject1 = "";; localObject1 = ((File)localObject1).getPath())
      {
        this.logPath = ((String)localObject1);
        if ((TextUtils.isEmpty(this.logPath)) || (!new File(this.logPath).canWrite())) {
          this.logPath = (Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "Midas" + File.separator + "Log" + File.separator);
        }
        AppMethodBeat.o(217198);
        return;
      }
      return;
    }
    finally
    {
      new StringBuilder("init log path error: ").append(localObject2.getMessage());
      this.logPath = (Environment.getExternalStorageDirectory() + File.separator + "tencent" + File.separator + "Midas" + File.separator + "Log" + File.separator);
      AppMethodBeat.o(217198);
    }
  }
  
  private void initPermission()
  {
    AppMethodBeat.i(217181);
    if (this.context.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", this.pkgName) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.hasWritePermission = bool;
      new StringBuilder("has WRITE_EXTERNAL_STORAGE? : ").append(this.hasWritePermission);
      AppMethodBeat.o(217181);
      return;
    }
  }
  
  private void initPkgName()
  {
    AppMethodBeat.i(217174);
    if (this.context == null)
    {
      AppMethodBeat.o(217174);
      return;
    }
    PackageManager localPackageManager = this.context.getPackageManager();
    try
    {
      this.pkgName = localPackageManager.getPackageInfo(this.context.getApplicationContext().getPackageName(), 0).packageName;
      new StringBuilder("get pkgName: ").append(this.pkgName);
      AppMethodBeat.o(217174);
      return;
    }
    finally
    {
      for (;;)
      {
        new StringBuilder("getPackage: ").append(localObject.toString());
      }
    }
  }
  
  private void initProcessName()
  {
    AppMethodBeat.i(217188);
    for (;;)
    {
      try
      {
        int i = Process.myPid();
        Object localObject1 = (ActivityManager)this.context.getSystemService("activity");
        if (localObject1 != null)
        {
          localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses().iterator();
          if (((Iterator)localObject1).hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject1).next();
            if (localRunningAppProcessInfo.pid != i) {
              continue;
            }
            localObject1 = localRunningAppProcessInfo.processName.split(":");
            if (localObject1.length <= 1) {
              continue;
            }
            this.processName = localObject1[1];
          }
        }
      }
      finally
      {
        new StringBuilder("get process: ").append(localObject2.toString());
        continue;
      }
      new StringBuilder("get process name: ").append(this.processName);
      AppMethodBeat.o(217188);
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
    AppMethodBeat.i(217217);
    if (this.context == null)
    {
      AppMethodBeat.o(217217);
      return;
    }
    initPkgName();
    initPermission();
    initProcessName();
    initLogPath();
    AppMethodBeat.o(217217);
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
    AppMethodBeat.i(217241);
    this.context = paramContext.getApplicationContext();
    AppMethodBeat.o(217241);
  }
  
  public void setEncryptKey(String paramString)
  {
    AppMethodBeat.i(217388);
    APLogEncryptor.setEncryptKey(paramString);
    AppMethodBeat.o(217388);
  }
  
  public void setEncryptLog(boolean paramBoolean)
  {
    this.encryptLog = paramBoolean;
  }
  
  public void setEncryptProtocolVersion(byte paramByte)
  {
    AppMethodBeat.i(217395);
    APLogEncryptor.setProtocolVersion(paramByte);
    AppMethodBeat.o(217395);
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
    AppMethodBeat.i(217400);
    APLogFileUtil.maxLogFileSizeMB = paramInt;
    new StringBuilder("set log file size: ").append(paramInt).append(" MB");
    AppMethodBeat.o(217400);
  }
  
  public void setLogParamFromServer(String paramString)
  {
    AppMethodBeat.i(217305);
    setLogWrite(paramString);
    AppMethodBeat.o(217305);
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
    AppMethodBeat.i(217315);
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
        AppMethodBeat.o(217315);
      }
    }
    finally
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
    AppMethodBeat.i(217332);
    if ((this.logEnable) || (this.printLog) || (APLogFileUtil.isDebugMode(APLogFileInfo.dirName)))
    {
      AppMethodBeat.o(217332);
      return true;
    }
    AppMethodBeat.o(217332);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.midas.comm.APLogInfo
 * JD-Core Version:    0.7.0.1
 */
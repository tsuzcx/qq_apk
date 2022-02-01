package com.tencent.mm.plugin.appbrand.debugger.console;

import com.tencent.mm.sdk.platformtools.Log.LogImp;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/LogImplAdapter;", "Lcom/tencent/mm/sdk/platformtools/Log$LogImp;", "()V", "appenderClose", "", "appenderFlush", "logInstancePtr", "", "isSync", "", "appenderOpen", "level", "", "mode", "cacheDir", "", "logDir", "nameprefix", "cacheDays", "getLogLevel", "getXlogInstance", "logD", "tag", "filename", "funcname", "linuxTid", "pid", "tid", "maintid", "log", "logE", "logF", "logI", "logV", "logW", "moveLogsFromCacheDirToLogDir", "openLogInstance", "releaseXlogInstance", "setAppenderMode", "setConsoleLogOpen", "isOpen", "setMaxAliveTime", "aliveSeconds", "setMaxFileSize", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class h
  implements Log.LogImp
{
  public void appenderClose() {}
  
  public void appenderFlush(long paramLong, boolean paramBoolean) {}
  
  public void appenderOpen(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3) {}
  
  public int getLogLevel(long paramLong)
  {
    return 0;
  }
  
  public long getXlogInstance(String paramString)
  {
    return 0L;
  }
  
  public void logD(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4) {}
  
  public void logE(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4) {}
  
  public void logF(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4) {}
  
  public void logI(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4) {}
  
  public void logV(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4) {}
  
  public void logW(long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, long paramLong2, long paramLong3, String paramString4) {}
  
  public void moveLogsFromCacheDirToLogDir() {}
  
  public long openLogInstance(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, int paramInt3)
  {
    return 0L;
  }
  
  public void releaseXlogInstance(String paramString) {}
  
  public void setAppenderMode(long paramLong, int paramInt) {}
  
  public void setConsoleLogOpen(long paramLong, boolean paramBoolean) {}
  
  public void setMaxAliveTime(long paramLong1, long paramLong2) {}
  
  public void setMaxFileSize(long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.h
 * JD-Core Version:    0.7.0.1
 */
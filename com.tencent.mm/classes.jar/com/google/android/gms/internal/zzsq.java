package com.google.android.gms.internal;

import com.google.android.gms.analytics.Logger;

class zzsq
  implements Logger
{
  private boolean zzabL;
  private int zzafc = 2;
  
  public void error(Exception paramException) {}
  
  public void error(String paramString) {}
  
  public int getLogLevel()
  {
    return this.zzafc;
  }
  
  public void info(String paramString) {}
  
  public void setLogLevel(int paramInt)
  {
    this.zzafc = paramInt;
    if (!this.zzabL)
    {
      zzsw.zzafl.get();
      String str = (String)zzsw.zzafl.get();
      new StringBuilder(String.valueOf(str).length() + 91).append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.").append(str).append(" DEBUG");
      this.zzabL = true;
    }
  }
  
  public void verbose(String paramString) {}
  
  public void warn(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.internal.zzsq
 * JD-Core Version:    0.7.0.1
 */
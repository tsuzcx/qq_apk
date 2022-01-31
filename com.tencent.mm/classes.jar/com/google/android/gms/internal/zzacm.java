package com.google.android.gms.internal;

import android.util.Log;
import com.google.android.gms.common.internal.zzq;

public class zzacm
{
  private final String mTag;
  private final zzq zzaGO;
  private final String zzaGs;
  private final int zzafc;
  
  private zzacm(String paramString1, String paramString2)
  {
    this.zzaGs = paramString2;
    this.mTag = paramString1;
    this.zzaGO = new zzq(paramString1);
    this.zzafc = getLogLevel();
  }
  
  public zzacm(String paramString, String... paramVarArgs)
  {
    this(paramString, zzd(paramVarArgs));
  }
  
  private int getLogLevel()
  {
    int i = 2;
    while ((7 >= i) && (!Log.isLoggable(this.mTag, i))) {
      i += 1;
    }
    return i;
  }
  
  private static String zzd(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('[');
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (localStringBuilder.length() > 1) {
        localStringBuilder.append(",");
      }
      localStringBuilder.append(str);
      i += 1;
    }
    localStringBuilder.append(']').append(' ');
    return localStringBuilder.toString();
  }
  
  protected String format(String paramString, Object... paramVarArgs)
  {
    String str = paramString;
    if (paramVarArgs != null)
    {
      str = paramString;
      if (paramVarArgs.length > 0) {
        str = String.format(paramString, paramVarArgs);
      }
    }
    return this.zzaGs.concat(str);
  }
  
  public void zza(String paramString, Object... paramVarArgs)
  {
    if (zzak(2)) {
      format(paramString, paramVarArgs);
    }
  }
  
  public boolean zzak(int paramInt)
  {
    return this.zzafc <= paramInt;
  }
  
  public void zzb(String paramString, Object... paramVarArgs)
  {
    if (zzak(3)) {
      format(paramString, paramVarArgs);
    }
  }
  
  public void zze(String paramString, Object... paramVarArgs)
  {
    format(paramString, paramVarArgs);
  }
  
  public void zzf(String paramString, Object... paramVarArgs)
  {
    format(paramString, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.internal.zzacm
 * JD-Core Version:    0.7.0.1
 */
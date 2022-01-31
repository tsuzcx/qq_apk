package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;

class zzdi$zza
  implements Logger
{
  private static int zznI(int paramInt)
  {
    switch (paramInt)
    {
    case 6: 
    default: 
      return 3;
    case 5: 
      return 2;
    case 3: 
    case 4: 
      return 1;
    }
    return 0;
  }
  
  public void error(Exception paramException)
  {
    zzbo.zzb("", paramException);
  }
  
  public void error(String paramString)
  {
    zzbo.e(paramString);
  }
  
  public int getLogLevel()
  {
    return zznI(zzbo.getLogLevel());
  }
  
  public void info(String paramString)
  {
    zzbo.zzbg(paramString);
  }
  
  public void setLogLevel(int paramInt)
  {
    zzbo.zzbh("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
  }
  
  public void verbose(String paramString)
  {
    zzbo.v(paramString);
  }
  
  public void warn(String paramString)
  {
    zzbo.zzbh(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzdi.zza
 * JD-Core Version:    0.7.0.1
 */
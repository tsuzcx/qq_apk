package com.google.android.gms.internal;

import android.app.Activity;
import java.util.HashMap;
import java.util.Map;

public class zztl
  implements zzsn
{
  public String zzabs;
  public double zzagO = -1.0D;
  public int zzagP = -1;
  public int zzagQ = -1;
  public int zzagR = -1;
  public int zzagS = -1;
  public Map<String, String> zzagT = new HashMap();
  
  public int getSessionTimeout()
  {
    return this.zzagP;
  }
  
  public String getTrackingId()
  {
    return this.zzabs;
  }
  
  public String zzcd(String paramString)
  {
    String str = (String)this.zzagT.get(paramString);
    if (str != null) {
      return str;
    }
    return paramString;
  }
  
  public boolean zzqA()
  {
    return this.zzagS == 1;
  }
  
  public boolean zzqs()
  {
    return this.zzabs != null;
  }
  
  public boolean zzqt()
  {
    return this.zzagO >= 0.0D;
  }
  
  public double zzqu()
  {
    return this.zzagO;
  }
  
  public boolean zzqv()
  {
    return this.zzagP >= 0;
  }
  
  public boolean zzqw()
  {
    return this.zzagQ != -1;
  }
  
  public boolean zzqx()
  {
    return this.zzagQ == 1;
  }
  
  public boolean zzqy()
  {
    return this.zzagR != -1;
  }
  
  public boolean zzqz()
  {
    return this.zzagR == 1;
  }
  
  public String zzr(Activity paramActivity)
  {
    return zzcd(paramActivity.getClass().getCanonicalName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zztl
 * JD-Core Version:    0.7.0.1
 */
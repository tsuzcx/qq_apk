package com.google.android.gms.internal;

import com.google.android.gms.analytics.zzf;
import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzro
  extends zzf<zzro>
{
  private final Map<String, Object> zzFP = new HashMap();
  
  private String zzbA(String paramString)
  {
    zzac.zzdr(paramString);
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.startsWith("&")) {
        str = paramString.substring(1);
      }
    }
    zzac.zzh(str, "Name can not be empty or \"&\"");
    return str;
  }
  
  public final void set(String paramString1, String paramString2)
  {
    paramString1 = zzbA(paramString1);
    this.zzFP.put(paramString1, paramString2);
  }
  
  public final String toString()
  {
    return zzj(this.zzFP);
  }
  
  public final void zza(zzro paramzzro)
  {
    zzac.zzw(paramzzro);
    paramzzro.zzFP.putAll(this.zzFP);
  }
  
  public final Map<String, Object> zznj()
  {
    return Collections.unmodifiableMap(this.zzFP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzro
 * JD-Core Version:    0.7.0.1
 */
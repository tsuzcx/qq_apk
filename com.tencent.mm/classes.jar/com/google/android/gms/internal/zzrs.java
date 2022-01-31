package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzf;
import java.util.HashMap;
import java.util.Map;

public final class zzrs
  extends zzf<zzrs>
{
  public String zzade;
  public boolean zzadf;
  
  public final String getDescription()
  {
    return this.zzade;
  }
  
  public final void setDescription(String paramString)
  {
    this.zzade = paramString;
  }
  
  public final String toString()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("description", this.zzade);
    localHashMap.put("fatal", Boolean.valueOf(this.zzadf));
    return zzj(localHashMap);
  }
  
  public final void zzR(boolean paramBoolean)
  {
    this.zzadf = paramBoolean;
  }
  
  public final void zza(zzrs paramzzrs)
  {
    if (!TextUtils.isEmpty(this.zzade)) {
      paramzzrs.setDescription(this.zzade);
    }
    if (this.zzadf) {
      paramzzrs.zzR(this.zzadf);
    }
  }
  
  public final boolean zznt()
  {
    return this.zzadf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.internal.zzrs
 * JD-Core Version:    0.7.0.1
 */
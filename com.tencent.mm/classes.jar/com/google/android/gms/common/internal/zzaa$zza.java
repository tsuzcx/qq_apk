package com.google.android.gms.common.internal;

import java.util.ArrayList;
import java.util.List;

public final class zzaa$zza
{
  private final Object zzYG;
  private final List<String> zzaGv;
  
  private zzaa$zza(Object paramObject)
  {
    this.zzYG = zzac.zzw(paramObject);
    this.zzaGv = new ArrayList();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100).append(this.zzYG.getClass().getSimpleName()).append('{');
    int j = this.zzaGv.size();
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append((String)this.zzaGv.get(i));
      if (i < j - 1) {
        localStringBuilder.append(", ");
      }
      i += 1;
    }
    return '}';
  }
  
  public final zza zzg(String paramString, Object paramObject)
  {
    List localList = this.zzaGv;
    paramString = (String)zzac.zzw(paramString);
    paramObject = String.valueOf(String.valueOf(paramObject));
    localList.add(String.valueOf(paramString).length() + 1 + String.valueOf(paramObject).length() + paramString + "=" + paramObject);
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzaa.zza
 * JD-Core Version:    0.7.0.1
 */
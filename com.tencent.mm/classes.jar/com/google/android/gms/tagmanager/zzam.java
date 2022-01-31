package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzak.zza;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class zzam
{
  private final Set<String> zzbGn;
  private final String zzbGo;
  
  public zzam(String paramString, String... paramVarArgs)
  {
    this.zzbGo = paramString;
    this.zzbGn = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramString = paramVarArgs[i];
      this.zzbGn.add(paramString);
      i += 1;
    }
  }
  
  public String zzQK()
  {
    return this.zzbGo;
  }
  
  public Set<String> zzQL()
  {
    return this.zzbGn;
  }
  
  public abstract boolean zzQa();
  
  public abstract zzak.zza zzZ(Map<String, zzak.zza> paramMap);
  
  boolean zzf(Set<String> paramSet)
  {
    return paramSet.containsAll(this.zzbGn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzam
 * JD-Core Version:    0.7.0.1
 */
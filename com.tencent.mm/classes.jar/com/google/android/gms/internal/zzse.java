package com.google.android.gms.internal;

import com.google.android.gms.common.internal.zzac;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzse
{
  private final Map<String, String> zzFP;
  private final String zzadh;
  private final long zzaeh;
  private final String zzaei;
  private final boolean zzaej;
  private long zzaek;
  
  public zzse(long paramLong1, String paramString1, String paramString2, boolean paramBoolean, long paramLong2, Map<String, String> paramMap)
  {
    zzac.zzdr(paramString1);
    zzac.zzdr(paramString2);
    this.zzaeh = paramLong1;
    this.zzadh = paramString1;
    this.zzaei = paramString2;
    this.zzaej = paramBoolean;
    this.zzaek = paramLong2;
    if (paramMap != null)
    {
      this.zzFP = new HashMap(paramMap);
      return;
    }
    this.zzFP = Collections.emptyMap();
  }
  
  public Map<String, String> zzfE()
  {
    return this.zzFP;
  }
  
  public String zzmy()
  {
    return this.zzadh;
  }
  
  public long zzoj()
  {
    return this.zzaeh;
  }
  
  public String zzok()
  {
    return this.zzaei;
  }
  
  public boolean zzol()
  {
    return this.zzaej;
  }
  
  public long zzom()
  {
    return this.zzaek;
  }
  
  public void zzs(long paramLong)
  {
    this.zzaek = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.internal.zzse
 * JD-Core Version:    0.7.0.1
 */
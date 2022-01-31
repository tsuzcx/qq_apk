package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzdl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class zzbjf$zzd
{
  private String zzavB = "";
  private int zzbMA = 0;
  private final List<zzbjf.zze> zzbMy = new ArrayList();
  private final Map<String, List<zzbjf.zza>> zzbMz = new HashMap();
  
  public zzbjf.zzc zzTz()
  {
    return new zzbjf.zzc(this.zzbMy, this.zzbMz, this.zzavB, this.zzbMA, null);
  }
  
  public zzd zzb(zzbjf.zze paramzze)
  {
    this.zzbMy.add(paramzze);
    return this;
  }
  
  public zzd zzc(zzbjf.zza paramzza)
  {
    String str = zzdl.zze((zzak.zza)paramzza.zzSV().get(zzai.zzhI.toString()));
    List localList = (List)this.zzbMz.get(str);
    Object localObject = localList;
    if (localList == null)
    {
      localObject = new ArrayList();
      this.zzbMz.put(str, localObject);
    }
    ((List)localObject).add(paramzza);
    return this;
  }
  
  public zzd zzih(String paramString)
  {
    this.zzavB = paramString;
    return this;
  }
  
  public zzd zznO(int paramInt)
  {
    this.zzbMA = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.internal.zzbjf.zzd
 * JD-Core Version:    0.7.0.1
 */
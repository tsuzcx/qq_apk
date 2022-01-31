package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class zzy
  extends zzdj
{
  private static final String ID = zzah.zzdT.toString();
  private static final String VALUE = zzai.zzke.toString();
  private static final String zzbFZ = zzai.zzgg.toString();
  private final DataLayer zzbEZ;
  
  public zzy(DataLayer paramDataLayer)
  {
    super(ID, new String[] { VALUE });
    this.zzbEZ = paramDataLayer;
  }
  
  private void zza(zzak.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzdl.zzRK())) {}
    do
    {
      return;
      paramzza = zzdl.zze(paramzza);
    } while (paramzza == zzdl.zzRP());
    this.zzbEZ.zzha(paramzza);
  }
  
  private void zzb(zzak.zza paramzza)
  {
    if ((paramzza == null) || (paramzza == zzdl.zzRK())) {}
    for (;;)
    {
      return;
      paramzza = zzdl.zzj(paramzza);
      if ((paramzza instanceof List))
      {
        paramzza = ((List)paramzza).iterator();
        while (paramzza.hasNext())
        {
          Object localObject = paramzza.next();
          if ((localObject instanceof Map))
          {
            localObject = (Map)localObject;
            this.zzbEZ.push((Map)localObject);
          }
        }
      }
    }
  }
  
  public void zzab(Map<String, zzak.zza> paramMap)
  {
    zzb((zzak.zza)paramMap.get(VALUE));
    zza((zzak.zza)paramMap.get(zzbFZ));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzy
 * JD-Core Version:    0.7.0.1
 */
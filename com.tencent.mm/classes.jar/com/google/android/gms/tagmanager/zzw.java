package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzw
  extends zzam
{
  private static final String ID = zzah.zzdl.toString();
  private static final String NAME = zzai.zzih.toString();
  private static final String zzbFO = zzai.zzgM.toString();
  private final DataLayer zzbEZ;
  
  public zzw(DataLayer paramDataLayer)
  {
    super(ID, new String[] { NAME });
    this.zzbEZ = paramDataLayer;
  }
  
  public boolean zzQa()
  {
    return false;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    Object localObject = this.zzbEZ.get(zzdl.zze((zzak.zza)paramMap.get(NAME)));
    if (localObject == null)
    {
      paramMap = (zzak.zza)paramMap.get(zzbFO);
      if (paramMap != null) {
        return paramMap;
      }
      return zzdl.zzRQ();
    }
    return zzdl.zzR(localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzw
 * JD-Core Version:    0.7.0.1
 */
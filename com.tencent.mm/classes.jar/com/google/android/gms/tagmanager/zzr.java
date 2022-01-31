package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzr
  extends zzam
{
  private static final String ID = zzah.zzdm.toString();
  private final String zzavB;
  
  public zzr(String paramString)
  {
    super(ID, new String[0]);
    this.zzavB = paramString;
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    if (this.zzavB == null) {
      return zzdl.zzRQ();
    }
    return zzdl.zzR(this.zzavB);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzr
 * JD-Core Version:    0.7.0.1
 */
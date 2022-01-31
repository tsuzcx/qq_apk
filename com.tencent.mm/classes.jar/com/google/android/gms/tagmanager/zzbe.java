package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzbe
  extends zzam
{
  private static final String ID = zzah.zzdP.toString();
  private static final String zzbEQ = zzai.zzgl.toString();
  private final Context zzqn;
  
  public zzbe(Context paramContext)
  {
    super(ID, new String[0]);
    this.zzqn = paramContext;
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    if ((zzak.zza)paramMap.get(zzbEQ) != null) {}
    for (paramMap = zzdl.zze((zzak.zza)paramMap.get(zzbEQ));; paramMap = null)
    {
      paramMap = zzbf.zzN(this.zzqn, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzdl.zzR(paramMap);
    }
    return zzdl.zzRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbe
 * JD-Core Version:    0.7.0.1
 */
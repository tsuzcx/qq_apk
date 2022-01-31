package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzai;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zze
  extends zzam
{
  private static final String ID = zzah.zzdK.toString();
  private static final String zzbEQ = zzai.zzgl.toString();
  private static final String zzbER = zzai.zzgo.toString();
  private final Context zzqn;
  
  public zze(Context paramContext)
  {
    super(ID, new String[] { zzbER });
    this.zzqn = paramContext;
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    Object localObject = (zzak.zza)paramMap.get(zzbER);
    if (localObject == null) {
      return zzdl.zzRQ();
    }
    localObject = zzdl.zze((zzak.zza)localObject);
    paramMap = (zzak.zza)paramMap.get(zzbEQ);
    if (paramMap != null) {}
    for (paramMap = zzdl.zze(paramMap);; paramMap = null)
    {
      paramMap = zzbf.zzr(this.zzqn, (String)localObject, paramMap);
      if (paramMap == null) {
        break;
      }
      return zzdl.zzR(paramMap);
    }
    return zzdl.zzRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zze
 * JD-Core Version:    0.7.0.1
 */
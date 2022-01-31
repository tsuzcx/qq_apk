package com.google.android.gms.tagmanager;

import android.content.Context;
import android.provider.Settings.Secure;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzbs
  extends zzam
{
  private static final String ID = zzah.zzdR.toString();
  private final Context mContext;
  
  public zzbs(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public boolean zzQa()
  {
    return true;
  }
  
  public zzak.zza zzZ(Map<String, zzak.zza> paramMap)
  {
    paramMap = zzbU(this.mContext);
    if (paramMap == null) {
      return zzdl.zzRQ();
    }
    return zzdl.zzR(paramMap);
  }
  
  protected String zzbU(Context paramContext)
  {
    return Settings.Secure.getString(paramContext.getContentResolver(), "android_id");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzbs
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.internal.zzah;
import com.google.android.gms.internal.zzak.zza;
import java.util.Map;

class zzco
  extends zzam
{
  private static final String ID = zzah.zzdE.toString();
  private final Context mContext;
  
  public zzco(Context paramContext)
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
    paramMap = new DisplayMetrics();
    ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getMetrics(paramMap);
    int i = paramMap.widthPixels;
    int j = paramMap.heightPixels;
    return zzdl.zzR(23 + i + "x" + j);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.tagmanager.zzco
 * JD-Core Version:    0.7.0.1
 */
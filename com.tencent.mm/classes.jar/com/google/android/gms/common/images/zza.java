package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.zzacb;
import com.google.android.gms.internal.zzacd;

public abstract class zza
{
  private boolean zzaEA = true;
  final zza.zza zzaEu;
  protected int zzaEv = 0;
  protected int zzaEw = 0;
  protected boolean zzaEx = false;
  private boolean zzaEy = true;
  private boolean zzaEz = false;
  
  public zza(Uri paramUri, int paramInt)
  {
    this.zzaEu = new zza.zza(paramUri);
    this.zzaEw = paramInt;
  }
  
  private Drawable zza(Context paramContext, zzacd paramzzacd, int paramInt)
  {
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  protected zzacb zza(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof zzacb)) {}
    }
    for (Drawable localDrawable = ((zzacb)paramDrawable1).zzxs();; localDrawable = null) {
      return new zzacb(localDrawable, paramDrawable2);
    }
  }
  
  void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    zzc.zzt(paramBitmap);
    zza(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }
  
  void zza(Context paramContext, zzacd paramzzacd)
  {
    if (this.zzaEA) {
      zza(null, false, true, false);
    }
  }
  
  void zza(Context paramContext, zzacd paramzzacd, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.zzaEw != 0) {
      localDrawable = zza(paramContext, paramzzacd, this.zzaEw);
    }
    zza(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  protected boolean zzc(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zzaEy) && (!paramBoolean2) && (!paramBoolean1);
  }
  
  public void zzcO(int paramInt)
  {
    this.zzaEw = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.gms.common.images.zza
 * JD-Core Version:    0.7.0.1
 */
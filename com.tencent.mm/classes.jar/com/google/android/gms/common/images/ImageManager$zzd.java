package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

final class ImageManager$zzd
  implements ComponentCallbacks2
{
  private final ImageManager.zza zzaEk;
  
  public ImageManager$zzd(ImageManager.zza paramzza)
  {
    this.zzaEk = paramzza;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory()
  {
    this.zzaEk.evictAll();
  }
  
  public final void onTrimMemory(int paramInt)
  {
    if (paramInt >= 60) {
      this.zzaEk.evictAll();
    }
    while (paramInt < 20) {
      return;
    }
    this.zzaEk.trimToSize(this.zzaEk.size() / 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzd
 * JD-Core Version:    0.7.0.1
 */
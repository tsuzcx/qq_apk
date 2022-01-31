package com.google.android.gms.common.images;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageManager$zzd
  implements ComponentCallbacks2
{
  private final ImageManager.zza zzpa;
  
  public ImageManager$zzd(ImageManager.zza paramzza)
  {
    this.zzpa = paramzza;
  }
  
  public final void onConfigurationChanged(Configuration paramConfiguration) {}
  
  public final void onLowMemory()
  {
    AppMethodBeat.i(61213);
    this.zzpa.evictAll();
    AppMethodBeat.o(61213);
  }
  
  public final void onTrimMemory(int paramInt)
  {
    AppMethodBeat.i(61214);
    if (paramInt >= 60)
    {
      this.zzpa.evictAll();
      AppMethodBeat.o(61214);
      return;
    }
    if (paramInt >= 20) {
      this.zzpa.trimToSize(this.zzpa.size() / 2);
    }
    AppMethodBeat.o(61214);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzd
 * JD-Core Version:    0.7.0.1
 */
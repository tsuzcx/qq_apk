package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Map;

final class ImageManager$zzc
  implements Runnable
{
  private final ImageRequest zzpi;
  
  public ImageManager$zzc(ImageManager paramImageManager, ImageRequest paramImageRequest)
  {
    this.zzpi = paramImageRequest;
  }
  
  public final void run()
  {
    AppMethodBeat.i(61212);
    Asserts.checkMainThread("LoadImageRunnable must be executed on the main thread");
    Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(this.zzpg).get(this.zzpi);
    if (localObject1 != null)
    {
      ImageManager.zza(this.zzpg).remove(this.zzpi);
      ((ImageManager.ImageReceiver)localObject1).zzb(this.zzpi);
    }
    ImageRequest.zza localzza = this.zzpi.zzpk;
    if (localzza.uri == null)
    {
      this.zzpi.zza(ImageManager.zzb(this.zzpg), ImageManager.zzc(this.zzpg), true);
      AppMethodBeat.o(61212);
      return;
    }
    localObject1 = ImageManager.zza(this.zzpg, localzza);
    if (localObject1 != null)
    {
      this.zzpi.zza(ImageManager.zzb(this.zzpg), (Bitmap)localObject1, true);
      AppMethodBeat.o(61212);
      return;
    }
    localObject1 = (Long)ImageManager.zzd(this.zzpg).get(localzza.uri);
    if (localObject1 != null)
    {
      if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
      {
        this.zzpi.zza(ImageManager.zzb(this.zzpg), ImageManager.zzc(this.zzpg), true);
        AppMethodBeat.o(61212);
        return;
      }
      ImageManager.zzd(this.zzpg).remove(localzza.uri);
    }
    this.zzpi.zza(ImageManager.zzb(this.zzpg), ImageManager.zzc(this.zzpg));
    ??? = (ImageManager.ImageReceiver)ImageManager.zze(this.zzpg).get(localzza.uri);
    localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new ImageManager.ImageReceiver(this.zzpg, localzza.uri);
      ImageManager.zze(this.zzpg).put(localzza.uri, localObject1);
    }
    ((ImageManager.ImageReceiver)localObject1).zza(this.zzpi);
    if (!(this.zzpi instanceof ImageRequest.ListenerImageRequest)) {
      ImageManager.zza(this.zzpg).put(this.zzpi, localObject1);
    }
    synchronized (ImageManager.zzcm())
    {
      if (!ImageManager.zzcn().contains(localzza.uri))
      {
        ImageManager.zzcn().add(localzza.uri);
        ((ImageManager.ImageReceiver)localObject1).zzco();
      }
      AppMethodBeat.o(61212);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzc
 * JD-Core Version:    0.7.0.1
 */
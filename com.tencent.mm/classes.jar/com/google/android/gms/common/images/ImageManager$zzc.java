package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzc;
import java.util.HashSet;
import java.util.Map;

final class ImageManager$zzc
  implements Runnable
{
  private final zza zzaEs;
  
  public ImageManager$zzc(ImageManager paramImageManager, zza paramzza)
  {
    this.zzaEs = paramzza;
  }
  
  public final void run()
  {
    zzc.zzdj("LoadImageRunnable must be executed on the main thread");
    Object localObject1 = (ImageManager.ImageReceiver)ImageManager.zza(this.zzaEq).get(this.zzaEs);
    if (localObject1 != null)
    {
      ImageManager.zza(this.zzaEq).remove(this.zzaEs);
      ((ImageManager.ImageReceiver)localObject1).zzc(this.zzaEs);
    }
    zza.zza localzza = this.zzaEs.zzaEu;
    if (localzza.uri == null)
    {
      this.zzaEs.zza(ImageManager.zzb(this.zzaEq), ImageManager.zzc(this.zzaEq), true);
      return;
    }
    localObject1 = ImageManager.zza(this.zzaEq, localzza);
    if (localObject1 != null)
    {
      this.zzaEs.zza(ImageManager.zzb(this.zzaEq), (Bitmap)localObject1, true);
      return;
    }
    localObject1 = (Long)ImageManager.zzd(this.zzaEq).get(localzza.uri);
    if (localObject1 != null)
    {
      if (SystemClock.elapsedRealtime() - ((Long)localObject1).longValue() < 3600000L)
      {
        this.zzaEs.zza(ImageManager.zzb(this.zzaEq), ImageManager.zzc(this.zzaEq), true);
        return;
      }
      ImageManager.zzd(this.zzaEq).remove(localzza.uri);
    }
    this.zzaEs.zza(ImageManager.zzb(this.zzaEq), ImageManager.zzc(this.zzaEq));
    ??? = (ImageManager.ImageReceiver)ImageManager.zze(this.zzaEq).get(localzza.uri);
    localObject1 = ???;
    if (??? == null)
    {
      localObject1 = new ImageManager.ImageReceiver(this.zzaEq, localzza.uri);
      ImageManager.zze(this.zzaEq).put(localzza.uri, localObject1);
    }
    ((ImageManager.ImageReceiver)localObject1).zzb(this.zzaEs);
    if (!(this.zzaEs instanceof zza.zzc)) {
      ImageManager.zza(this.zzaEq).put(this.zzaEs, localObject1);
    }
    synchronized (ImageManager.zzuH())
    {
      if (!ImageManager.zzxq().contains(localzza.uri))
      {
        ImageManager.zzxq().add(localzza.uri);
        ((ImageManager.ImageReceiver)localObject1).zzxr();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zzc
 * JD-Core Version:    0.7.0.1
 */
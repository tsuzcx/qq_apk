package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.internal.zzc;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class ImageManager$zze
  implements Runnable
{
  private final Bitmap mBitmap;
  private final Uri mUri;
  private boolean zzaEt;
  private final CountDownLatch zztj;
  
  public ImageManager$zze(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.mUri = paramUri;
    this.mBitmap = paramBitmap;
    this.zzaEt = paramBoolean;
    this.zztj = paramCountDownLatch;
  }
  
  private void zza(ImageManager.ImageReceiver paramImageReceiver, boolean paramBoolean)
  {
    paramImageReceiver = ImageManager.ImageReceiver.zza(paramImageReceiver);
    int j = paramImageReceiver.size();
    int i = 0;
    if (i < j)
    {
      zza localzza = (zza)paramImageReceiver.get(i);
      if (paramBoolean) {
        localzza.zza(ImageManager.zzb(this.zzaEq), this.mBitmap, false);
      }
      for (;;)
      {
        if (!(localzza instanceof zza.zzc)) {
          ImageManager.zza(this.zzaEq).remove(localzza);
        }
        i += 1;
        break;
        ImageManager.zzd(this.zzaEq).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
        localzza.zza(ImageManager.zzb(this.zzaEq), ImageManager.zzc(this.zzaEq), false);
      }
    }
  }
  
  public final void run()
  {
    zzc.zzdj("OnBitmapLoadedRunnable must be executed in the main thread");
    boolean bool;
    if (this.mBitmap != null) {
      bool = true;
    }
    while (ImageManager.zzh(this.zzaEq) != null) {
      if (this.zzaEt)
      {
        ImageManager.zzh(this.zzaEq).evictAll();
        System.gc();
        this.zzaEt = false;
        ImageManager.zzg(this.zzaEq).post(this);
        return;
        bool = false;
      }
      else if (bool)
      {
        ImageManager.zzh(this.zzaEq).put(new zza.zza(this.mUri), this.mBitmap);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.zze(this.zzaEq).remove(this.mUri);
    if (??? != null) {
      zza((ImageManager.ImageReceiver)???, bool);
    }
    this.zztj.countDown();
    synchronized (ImageManager.zzuH())
    {
      ImageManager.zzxq().remove(this.mUri);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zze
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

final class ImageManager$zze
  implements Runnable
{
  private final Bitmap mBitmap;
  private final Uri mUri;
  private final CountDownLatch zzfd;
  private boolean zzpj;
  
  public ImageManager$zze(ImageManager paramImageManager, Uri paramUri, Bitmap paramBitmap, boolean paramBoolean, CountDownLatch paramCountDownLatch)
  {
    this.mUri = paramUri;
    this.mBitmap = paramBitmap;
    this.zzpj = paramBoolean;
    this.zzfd = paramCountDownLatch;
  }
  
  public final void run()
  {
    AppMethodBeat.i(61215);
    Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
    int i;
    if (this.mBitmap != null) {
      i = 1;
    }
    while (ImageManager.zzh(this.zzpg) != null) {
      if (this.zzpj)
      {
        ImageManager.zzh(this.zzpg).evictAll();
        System.gc();
        this.zzpj = false;
        ImageManager.zzg(this.zzpg).post(this);
        AppMethodBeat.o(61215);
        return;
        i = 0;
      }
      else if (i != 0)
      {
        ImageManager.zzh(this.zzpg).put(new ImageRequest.zza(this.mUri), this.mBitmap);
      }
    }
    ??? = (ImageManager.ImageReceiver)ImageManager.zze(this.zzpg).remove(this.mUri);
    if (??? != null)
    {
      ??? = ImageManager.ImageReceiver.zza((ImageManager.ImageReceiver)???);
      int k = ((ArrayList)???).size();
      int j = 0;
      if (j < k)
      {
        ImageRequest localImageRequest = (ImageRequest)((ArrayList)???).get(j);
        if (i != 0) {
          localImageRequest.zza(ImageManager.zzb(this.zzpg), this.mBitmap, false);
        }
        for (;;)
        {
          if (!(localImageRequest instanceof ImageRequest.ListenerImageRequest)) {
            ImageManager.zza(this.zzpg).remove(localImageRequest);
          }
          j += 1;
          break;
          ImageManager.zzd(this.zzpg).put(this.mUri, Long.valueOf(SystemClock.elapsedRealtime()));
          localImageRequest.zza(ImageManager.zzb(this.zzpg), ImageManager.zzc(this.zzpg), false);
        }
      }
    }
    this.zzfd.countDown();
    synchronized (ImageManager.zzcm())
    {
      ImageManager.zzcn().remove(this.mUri);
      AppMethodBeat.o(61215);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.zze
 * JD-Core Version:    0.7.0.1
 */
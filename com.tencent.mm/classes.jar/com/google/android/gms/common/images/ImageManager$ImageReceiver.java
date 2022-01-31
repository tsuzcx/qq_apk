package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.zzc;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

@KeepName
final class ImageManager$ImageReceiver
  extends ResultReceiver
{
  private final Uri mUri;
  private final ArrayList<zza> zzaEp;
  
  ImageManager$ImageReceiver(ImageManager paramImageManager, Uri paramUri)
  {
    super(new Handler(Looper.getMainLooper()));
    this.mUri = paramUri;
    this.zzaEp = new ArrayList();
  }
  
  public final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
    ImageManager.zzf(this.zzaEq).execute(new ImageManager.zzb(this.zzaEq, this.mUri, paramBundle));
  }
  
  public final void zzb(zza paramzza)
  {
    zzc.zzdj("ImageReceiver.addImageRequest() must be called in the main thread");
    this.zzaEp.add(paramzza);
  }
  
  public final void zzc(zza paramzza)
  {
    zzc.zzdj("ImageReceiver.removeImageRequest() must be called in the main thread");
    this.zzaEp.remove(paramzza);
  }
  
  public final void zzxr()
  {
    Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
    localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
    localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
    localIntent.putExtra("com.google.android.gms.extras.priority", 3);
    ImageManager.zzb(this.zzaEq).sendBroadcast(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.ImageReceiver
 * JD-Core Version:    0.7.0.1
 */
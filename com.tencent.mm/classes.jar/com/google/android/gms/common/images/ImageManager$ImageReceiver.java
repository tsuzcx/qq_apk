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
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

@KeepName
final class ImageManager$ImageReceiver
  extends ResultReceiver
{
  private final Uri mUri;
  private final ArrayList<ImageRequest> zzpf;
  
  ImageManager$ImageReceiver(ImageManager paramImageManager, Uri paramUri)
  {
    super(new Handler(Looper.getMainLooper()));
    AppMethodBeat.i(61203);
    this.mUri = paramUri;
    this.zzpf = new ArrayList();
    AppMethodBeat.o(61203);
  }
  
  public final void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(61207);
    paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
    ImageManager.zzf(this.zzpg).execute(new ImageManager.zzb(this.zzpg, this.mUri, paramBundle));
    AppMethodBeat.o(61207);
  }
  
  public final void zza(ImageRequest paramImageRequest)
  {
    AppMethodBeat.i(61204);
    Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
    this.zzpf.add(paramImageRequest);
    AppMethodBeat.o(61204);
  }
  
  public final void zzb(ImageRequest paramImageRequest)
  {
    AppMethodBeat.i(61205);
    Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
    this.zzpf.remove(paramImageRequest);
    AppMethodBeat.o(61205);
  }
  
  public final void zzco()
  {
    AppMethodBeat.i(61206);
    Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
    localIntent.putExtra("com.google.android.gms.extras.uri", this.mUri);
    localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
    localIntent.putExtra("com.google.android.gms.extras.priority", 3);
    ImageManager.zzb(this.zzpg).sendBroadcast(localIntent);
    AppMethodBeat.o(61206);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageManager.ImageReceiver
 * JD-Core Version:    0.7.0.1
 */
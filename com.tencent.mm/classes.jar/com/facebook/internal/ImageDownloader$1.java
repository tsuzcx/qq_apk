package com.facebook.internal;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ImageDownloader$1
  implements Runnable
{
  ImageDownloader$1(ImageRequest paramImageRequest, Exception paramException, boolean paramBoolean, Bitmap paramBitmap, ImageRequest.Callback paramCallback) {}
  
  public final void run()
  {
    AppMethodBeat.i(72369);
    ImageResponse localImageResponse = new ImageResponse(this.val$request, this.val$error, this.val$isCachedRedirect, this.val$bitmap);
    this.val$callback.onCompleted(localImageResponse);
    AppMethodBeat.o(72369);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.ImageDownloader.1
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ImageRequest$ListenerImageRequest
  extends ImageRequest
{
  private WeakReference<ImageManager.OnImageLoadedListener> zzpp;
  
  public ImageRequest$ListenerImageRequest(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    AppMethodBeat.i(61232);
    Asserts.checkNotNull(paramOnImageLoadedListener);
    this.zzpp = new WeakReference(paramOnImageLoadedListener);
    AppMethodBeat.o(61232);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61234);
    if (!(paramObject instanceof ListenerImageRequest))
    {
      AppMethodBeat.o(61234);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(61234);
      return true;
    }
    paramObject = (ListenerImageRequest)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zzpp.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)paramObject.zzpp.get();
    if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (Objects.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (Objects.equal(paramObject.zzpk, this.zzpk)))
    {
      AppMethodBeat.o(61234);
      return true;
    }
    AppMethodBeat.o(61234);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(61233);
    int i = Objects.hashCode(new Object[] { this.zzpk });
    AppMethodBeat.o(61233);
    return i;
  }
  
  protected final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(61235);
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zzpp.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(this.zzpk.uri, paramDrawable, paramBoolean3);
      }
    }
    AppMethodBeat.o(61235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageRequest.ListenerImageRequest
 * JD-Core Version:    0.7.0.1
 */
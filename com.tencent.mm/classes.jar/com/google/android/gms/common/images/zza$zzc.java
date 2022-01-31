package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzc;
import java.lang.ref.WeakReference;

public final class zza$zzc
  extends zza
{
  private WeakReference<ImageManager.OnImageLoadedListener> zzaEC;
  
  public zza$zzc(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    super(paramUri, 0);
    zzc.zzt(paramOnImageLoadedListener);
    this.zzaEC = new WeakReference(paramOnImageLoadedListener);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof zzc)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    paramObject = (zzc)paramObject;
    ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zzaEC.get();
    ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)paramObject.zzaEC.get();
    return (localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (zzaa.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (zzaa.equal(paramObject.zzaEu, this.zzaEu));
  }
  
  public final int hashCode()
  {
    return zzaa.hashCode(new Object[] { this.zzaEu });
  }
  
  protected final void zza(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (!paramBoolean2)
    {
      ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zzaEC.get();
      if (localOnImageLoadedListener != null) {
        localOnImageLoadedListener.onImageLoaded(this.zzaEu.uri, paramDrawable, paramBoolean3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.zza.zzc
 * JD-Core Version:    0.7.0.1
 */
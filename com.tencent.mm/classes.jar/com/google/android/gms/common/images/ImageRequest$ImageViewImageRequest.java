package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.images.internal.CrossFadingDrawable;
import com.google.android.gms.common.images.internal.LoadingImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class ImageRequest$ImageViewImageRequest
  extends ImageRequest
{
  private WeakReference<ImageView> zzpo;
  
  public ImageRequest$ImageViewImageRequest(ImageView paramImageView, int paramInt)
  {
    super(null, paramInt);
    AppMethodBeat.i(61229);
    Asserts.checkNotNull(paramImageView);
    this.zzpo = new WeakReference(paramImageView);
    AppMethodBeat.o(61229);
  }
  
  public ImageRequest$ImageViewImageRequest(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    AppMethodBeat.i(61228);
    Asserts.checkNotNull(paramImageView);
    this.zzpo = new WeakReference(paramImageView);
    AppMethodBeat.o(61228);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(61230);
    if (!(paramObject instanceof ImageViewImageRequest))
    {
      AppMethodBeat.o(61230);
      return false;
    }
    if (this == paramObject)
    {
      AppMethodBeat.o(61230);
      return true;
    }
    Object localObject = (ImageViewImageRequest)paramObject;
    paramObject = (ImageView)this.zzpo.get();
    localObject = (ImageView)((ImageViewImageRequest)localObject).zzpo.get();
    if ((localObject != null) && (paramObject != null) && (Objects.equal(localObject, paramObject)))
    {
      AppMethodBeat.o(61230);
      return true;
    }
    AppMethodBeat.o(61230);
    return false;
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  protected final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(61231);
    Object localObject2 = (ImageView)this.zzpo.get();
    int i;
    if (localObject2 != null)
    {
      if ((paramBoolean2) || (paramBoolean3)) {
        break label198;
      }
      i = 1;
      if ((i != 0) && ((localObject2 instanceof LoadingImageView)))
      {
        int j = ((LoadingImageView)localObject2).getLoadedNoDataPlaceholderResId();
        if ((this.mNoDataPlaceholderResId != 0) && (j == this.mNoDataPlaceholderResId)) {}
      }
      else
      {
        paramBoolean1 = shouldCrossFade(paramBoolean1, paramBoolean2);
        if ((!this.mUseNewDrawable) || (paramDrawable == null)) {
          break label215;
        }
        paramDrawable = paramDrawable.getConstantState().newDrawable();
      }
    }
    label153:
    label198:
    label204:
    label209:
    label215:
    for (;;)
    {
      Object localObject1 = paramDrawable;
      if (paramBoolean1) {
        localObject1 = createTransitionDrawable(((ImageView)localObject2).getDrawable(), paramDrawable);
      }
      ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
      if ((localObject2 instanceof LoadingImageView))
      {
        localObject2 = (LoadingImageView)localObject2;
        if (!paramBoolean3) {
          break label204;
        }
        paramDrawable = this.zzpk.uri;
        ((LoadingImageView)localObject2).setLoadedUri(paramDrawable);
        if (i == 0) {
          break label209;
        }
      }
      for (i = this.mNoDataPlaceholderResId;; i = 0)
      {
        ((LoadingImageView)localObject2).setLoadedNoDataPlaceholderResId(i);
        if (paramBoolean1) {
          ((CrossFadingDrawable)localObject1).startTransition(250);
        }
        AppMethodBeat.o(61231);
        return;
        i = 0;
        break;
        paramDrawable = null;
        break label153;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageRequest.ImageViewImageRequest
 * JD-Core Version:    0.7.0.1
 */
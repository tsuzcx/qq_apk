package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.images.internal.CrossFadingDrawable;
import com.google.android.gms.common.images.internal.ImageUtils;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache.PostProcessedResource;
import com.google.android.gms.common.internal.Asserts;

public abstract class ImageRequest
{
  protected int mLoadingPlaceholderResId = 0;
  protected int mNoDataPlaceholderResId = 0;
  protected ImageManager.OnImageLoadedListener mOnImageLoadedListener;
  protected int mPostProcessingFlags;
  protected boolean mUseNewDrawable = false;
  final ImageRequest.zza zzpk;
  private boolean zzpl = true;
  private boolean zzpm = false;
  private boolean zzpn = true;
  
  public ImageRequest(Uri paramUri, int paramInt)
  {
    this.zzpk = new ImageRequest.zza(paramUri);
    this.mNoDataPlaceholderResId = paramInt;
  }
  
  private final Drawable zza(Context paramContext, PostProcessedResourceCache paramPostProcessedResourceCache, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.mPostProcessingFlags > 0)
    {
      PostProcessedResourceCache.PostProcessedResource localPostProcessedResource = new PostProcessedResourceCache.PostProcessedResource(paramInt, this.mPostProcessingFlags);
      Drawable localDrawable = (Drawable)paramPostProcessedResourceCache.get(localPostProcessedResource);
      paramContext = localDrawable;
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        paramContext = localDrawable;
        if ((this.mPostProcessingFlags & 0x1) != 0) {
          paramContext = frameDrawableInCircle(localResources, localDrawable);
        }
        paramPostProcessedResourceCache.put(localPostProcessedResource, paramContext);
      }
      return paramContext;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected CrossFadingDrawable createTransitionDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null)
    {
      localDrawable = paramDrawable1;
      if (!(paramDrawable1 instanceof CrossFadingDrawable)) {}
    }
    for (Drawable localDrawable = ((CrossFadingDrawable)paramDrawable1).getEndDrawable();; localDrawable = null) {
      return new CrossFadingDrawable(localDrawable, paramDrawable2);
    }
  }
  
  protected Drawable frameDrawableInCircle(Resources paramResources, Drawable paramDrawable)
  {
    return ImageUtils.frameDrawableInCircle(paramResources, paramDrawable);
  }
  
  protected abstract void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void setCrossFadeAlwaysEnabled(boolean paramBoolean)
  {
    this.zzpm = paramBoolean;
    if (paramBoolean) {
      setCrossFadeEnabled(true);
    }
  }
  
  public void setCrossFadeEnabled(boolean paramBoolean)
  {
    this.zzpl = paramBoolean;
  }
  
  public void setLoadingPlaceholder(int paramInt)
  {
    this.mLoadingPlaceholderResId = paramInt;
  }
  
  public void setLoadingPlaceholderEnabled(boolean paramBoolean)
  {
    this.zzpn = paramBoolean;
  }
  
  public void setNoDataPlaceholder(int paramInt)
  {
    this.mNoDataPlaceholderResId = paramInt;
  }
  
  public void setOnImageLoadedListener(ImageManager.OnImageLoadedListener paramOnImageLoadedListener)
  {
    this.mOnImageLoadedListener = paramOnImageLoadedListener;
  }
  
  public void setPostProcessingFlags(int paramInt)
  {
    this.mPostProcessingFlags = paramInt;
  }
  
  public void setUseNewDrawable(boolean paramBoolean)
  {
    this.mUseNewDrawable = paramBoolean;
  }
  
  protected boolean shouldCrossFade(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zzpl) && (!paramBoolean2) && ((!paramBoolean1) || (this.zzpm));
  }
  
  final void zza(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    Asserts.checkNotNull(paramBitmap);
    Bitmap localBitmap = paramBitmap;
    if ((this.mPostProcessingFlags & 0x1) != 0) {
      localBitmap = ImageUtils.frameBitmapInCircle(paramBitmap);
    }
    paramContext = new BitmapDrawable(paramContext.getResources(), localBitmap);
    if (this.mOnImageLoadedListener != null) {
      this.mOnImageLoadedListener.onImageLoaded(this.zzpk.uri, paramContext, true);
    }
    loadImage(paramContext, paramBoolean, false, true);
  }
  
  final void zza(Context paramContext, PostProcessedResourceCache paramPostProcessedResourceCache)
  {
    if (this.zzpn)
    {
      Drawable localDrawable = null;
      if (this.mLoadingPlaceholderResId != 0) {
        localDrawable = zza(paramContext, paramPostProcessedResourceCache, this.mLoadingPlaceholderResId);
      }
      loadImage(localDrawable, false, true, false);
    }
  }
  
  final void zza(Context paramContext, PostProcessedResourceCache paramPostProcessedResourceCache, boolean paramBoolean)
  {
    Drawable localDrawable = null;
    if (this.mNoDataPlaceholderResId != 0) {
      localDrawable = zza(paramContext, paramPostProcessedResourceCache, this.mNoDataPlaceholderResId);
    }
    if (this.mOnImageLoadedListener != null) {
      this.mOnImageLoadedListener.onImageLoaded(this.zzpk.uri, localDrawable, false);
    }
    loadImage(localDrawable, paramBoolean, false, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageRequest
 * JD-Core Version:    0.7.0.1
 */
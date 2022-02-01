package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.common.images.internal.CrossFadingDrawable;
import com.google.android.gms.common.images.internal.ImageUtils;
import com.google.android.gms.common.images.internal.LoadingImageView;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache;
import com.google.android.gms.common.images.internal.PostProcessedResourceCache.PostProcessedResource;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public abstract class ImageRequest
{
  protected int mLoadingPlaceholderResId = 0;
  protected int mNoDataPlaceholderResId = 0;
  protected ImageManager.OnImageLoadedListener mOnImageLoadedListener;
  protected int mPostProcessingFlags;
  protected boolean mUseNewDrawable = false;
  final zza zzpk;
  private boolean zzpl = true;
  private boolean zzpm = false;
  private boolean zzpn = true;
  
  public ImageRequest(Uri paramUri, int paramInt)
  {
    this.zzpk = new zza(paramUri);
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
  
  public static final class ImageViewImageRequest
    extends ImageRequest
  {
    private WeakReference<ImageView> zzpo;
    
    public ImageViewImageRequest(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      AppMethodBeat.i(11721);
      Asserts.checkNotNull(paramImageView);
      this.zzpo = new WeakReference(paramImageView);
      AppMethodBeat.o(11721);
    }
    
    public ImageViewImageRequest(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      AppMethodBeat.i(11720);
      Asserts.checkNotNull(paramImageView);
      this.zzpo = new WeakReference(paramImageView);
      AppMethodBeat.o(11720);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(11722);
      if (!(paramObject instanceof ImageViewImageRequest))
      {
        AppMethodBeat.o(11722);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(11722);
        return true;
      }
      Object localObject = (ImageViewImageRequest)paramObject;
      paramObject = (ImageView)this.zzpo.get();
      localObject = (ImageView)((ImageViewImageRequest)localObject).zzpo.get();
      if ((localObject != null) && (paramObject != null) && (Objects.equal(localObject, paramObject)))
      {
        AppMethodBeat.o(11722);
        return true;
      }
      AppMethodBeat.o(11722);
      return false;
    }
    
    public final int hashCode()
    {
      return 0;
    }
    
    protected final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(11723);
      Object localObject2 = (ImageView)this.zzpo.get();
      int i;
      if (localObject2 != null)
      {
        if ((paramBoolean2) || (paramBoolean3)) {
          break label200;
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
            break label217;
          }
          paramDrawable = paramDrawable.getConstantState().newDrawable();
        }
      }
      label154:
      label200:
      label206:
      label211:
      label217:
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
            break label206;
          }
          paramDrawable = this.zzpk.uri;
          ((LoadingImageView)localObject2).setLoadedUri(paramDrawable);
          if (i == 0) {
            break label211;
          }
        }
        for (i = this.mNoDataPlaceholderResId;; i = 0)
        {
          ((LoadingImageView)localObject2).setLoadedNoDataPlaceholderResId(i);
          if (paramBoolean1) {
            ((CrossFadingDrawable)localObject1).startTransition(250);
          }
          AppMethodBeat.o(11723);
          return;
          i = 0;
          break;
          paramDrawable = null;
          break label154;
        }
      }
    }
  }
  
  public static final class ListenerImageRequest
    extends ImageRequest
  {
    private WeakReference<ImageManager.OnImageLoadedListener> zzpp;
    
    public ListenerImageRequest(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      AppMethodBeat.i(11724);
      Asserts.checkNotNull(paramOnImageLoadedListener);
      this.zzpp = new WeakReference(paramOnImageLoadedListener);
      AppMethodBeat.o(11724);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(11726);
      if (!(paramObject instanceof ListenerImageRequest))
      {
        AppMethodBeat.o(11726);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(11726);
        return true;
      }
      paramObject = (ListenerImageRequest)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.zzpp.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)paramObject.zzpp.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (Objects.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (Objects.equal(paramObject.zzpk, this.zzpk)))
      {
        AppMethodBeat.o(11726);
        return true;
      }
      AppMethodBeat.o(11726);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(11725);
      int i = Objects.hashCode(new Object[] { this.zzpk });
      AppMethodBeat.o(11725);
      return i;
    }
    
    protected final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(11727);
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.zzpp.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.zzpk.uri, paramDrawable, paramBoolean3);
        }
      }
      AppMethodBeat.o(11727);
    }
  }
  
  public static final class TextViewImageRequest
    extends ImageRequest
  {
    public static final int POSITION_BOTTOM = 3;
    public static final int POSITION_END = 2;
    public static final int POSITION_START = 0;
    public static final int POSITION_TOP = 1;
    private WeakReference<TextView> zzpq;
    private int zzpr;
    
    public TextViewImageRequest(TextView paramTextView, int paramInt1, int paramInt2)
    {
      super(paramInt2);
      AppMethodBeat.i(11729);
      this.zzpr = -1;
      Asserts.checkNotNull(paramTextView);
      if ((paramInt1 != 0) && (paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3)) {}
      for (;;)
      {
        Asserts.checkState(bool, 29 + "Invalid position: " + paramInt1);
        this.zzpq = new WeakReference(paramTextView);
        this.zzpr = paramInt1;
        AppMethodBeat.o(11729);
        return;
        bool = false;
      }
    }
    
    public TextViewImageRequest(TextView paramTextView, int paramInt, Uri paramUri)
    {
      super(0);
      AppMethodBeat.i(11728);
      this.zzpr = -1;
      Asserts.checkNotNull(paramTextView);
      if ((paramInt != 0) && (paramInt != 1) && (paramInt != 2) && (paramInt != 3)) {}
      for (;;)
      {
        Asserts.checkState(bool, 29 + "Invalid position: " + paramInt);
        this.zzpq = new WeakReference(paramTextView);
        this.zzpr = paramInt;
        AppMethodBeat.o(11728);
        return;
        bool = false;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(11731);
      if (!(paramObject instanceof TextViewImageRequest))
      {
        AppMethodBeat.o(11731);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(11731);
        return true;
      }
      paramObject = (TextViewImageRequest)paramObject;
      TextView localTextView1 = (TextView)this.zzpq.get();
      TextView localTextView2 = (TextView)paramObject.zzpq.get();
      if ((localTextView2 != null) && (localTextView1 != null) && (Objects.equal(localTextView2, localTextView1)) && (Objects.equal(Integer.valueOf(paramObject.zzpr), Integer.valueOf(this.zzpr))))
      {
        AppMethodBeat.o(11731);
        return true;
      }
      AppMethodBeat.o(11731);
      return false;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(11730);
      int i = Objects.hashCode(new Object[] { Integer.valueOf(this.zzpr) });
      AppMethodBeat.o(11730);
      return i;
    }
    
    protected final void loadImage(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      AppMethodBeat.i(11732);
      TextView localTextView = (TextView)this.zzpq.get();
      int i;
      Object localObject;
      Drawable localDrawable1;
      if (localTextView != null)
      {
        i = this.zzpr;
        paramBoolean1 = shouldCrossFade(paramBoolean1, paramBoolean2);
        if (!PlatformVersion.isAtLeastJellyBeanMR1()) {
          break label143;
        }
        localObject = localTextView.getCompoundDrawablesRelative();
        localDrawable1 = localObject[i];
        if (!paramBoolean1) {
          break label205;
        }
        paramDrawable = createTransitionDrawable(localDrawable1, paramDrawable);
      }
      label76:
      label205:
      for (;;)
      {
        Drawable localDrawable2;
        label85:
        Drawable localDrawable3;
        if (i == 0)
        {
          localDrawable1 = paramDrawable;
          if (i != 1) {
            break label162;
          }
          localDrawable2 = paramDrawable;
          if (i != 2) {
            break label171;
          }
          localDrawable3 = paramDrawable;
          label94:
          if (i != 3) {
            break label180;
          }
          localObject = paramDrawable;
          label103:
          if (!PlatformVersion.isAtLeastJellyBeanMR1()) {
            break label189;
          }
          localTextView.setCompoundDrawablesRelativeWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
        }
        for (;;)
        {
          if (paramBoolean1) {
            ((CrossFadingDrawable)paramDrawable).startTransition(250);
          }
          AppMethodBeat.o(11732);
          return;
          localObject = localTextView.getCompoundDrawables();
          break;
          localDrawable1 = localObject[0];
          break label76;
          localDrawable2 = localObject[1];
          break label85;
          localDrawable3 = localObject[2];
          break label94;
          localObject = localObject[3];
          break label103;
          localTextView.setCompoundDrawablesWithIntrinsicBounds(localDrawable1, localDrawable2, localDrawable3, (Drawable)localObject);
        }
      }
    }
  }
  
  static final class zza
  {
    public final Uri uri;
    
    public zza(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(11734);
      if (!(paramObject instanceof zza))
      {
        AppMethodBeat.o(11734);
        return false;
      }
      if (this == paramObject)
      {
        AppMethodBeat.o(11734);
        return true;
      }
      boolean bool = Objects.equal(((zza)paramObject).uri, this.uri);
      AppMethodBeat.o(11734);
      return bool;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(11733);
      int i = Objects.hashCode(new Object[] { this.uri });
      AppMethodBeat.o(11733);
      return i;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.gms.common.images.ImageRequest
 * JD-Core Version:    0.7.0.1
 */
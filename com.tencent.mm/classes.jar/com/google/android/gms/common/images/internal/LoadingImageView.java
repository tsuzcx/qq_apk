package com.google.android.gms.common.images.internal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.google.android.gms.base.R.styleable;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.images.ImageManager.OnImageLoadedListener;
import com.google.android.gms.common.images.ImageRequest;
import com.google.android.gms.common.images.ImageRequest.ImageViewImageRequest;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.util.PlatformVersion;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LoadingImageView
  extends ImageView
{
  public static final int ASPECT_RATIO_ADJUST_HEIGHT = 2;
  public static final int ASPECT_RATIO_ADJUST_NONE = 0;
  public static final int ASPECT_RATIO_ADJUST_WIDTH = 1;
  private static ImageManager zzqm;
  private ImageManager.OnImageLoadedListener mOnImageLoadedListener;
  private int mPostProcessingFlags;
  private boolean zzpl;
  private boolean zzpm;
  private Uri zzqn;
  private int zzqo;
  private boolean zzqp;
  private int zzqq;
  private ClipPathProvider zzqr;
  private int zzqs;
  private float zzqt;
  
  public LoadingImageView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(11774);
    this.zzqo = 0;
    this.zzpl = true;
    this.zzpm = false;
    this.zzqp = false;
    this.zzqq = 0;
    this.mPostProcessingFlags = 0;
    this.zzqs = 0;
    this.zzqt = 1.0F;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.LoadingImageView);
    this.zzqs = paramContext.getInt(2, 0);
    this.zzqt = paramContext.getFloat(1, 1.0F);
    setCircleCropEnabled(paramContext.getBoolean(0, false));
    paramContext.recycle();
    AppMethodBeat.o(11774);
  }
  
  private final void zzc(boolean paramBoolean)
  {
    AppMethodBeat.i(11787);
    if (this.mOnImageLoadedListener != null) {
      this.mOnImageLoadedListener.onImageLoaded(this.zzqn, null, paramBoolean);
    }
    AppMethodBeat.o(11787);
  }
  
  public final void clearAspectRatioAdjust()
  {
    AppMethodBeat.i(11784);
    if (this.zzqs != 0)
    {
      this.zzqs = 0;
      requestLayout();
    }
    AppMethodBeat.o(11784);
  }
  
  public final void clearImage()
  {
    AppMethodBeat.i(11775);
    loadUri(null);
    this.zzqp = true;
    AppMethodBeat.o(11775);
  }
  
  public final int getLoadedNoDataPlaceholderResId()
  {
    return this.zzqo;
  }
  
  public final Uri getLoadedUri()
  {
    return this.zzqn;
  }
  
  public final void loadUri(Uri paramUri)
  {
    AppMethodBeat.i(11776);
    loadUri(paramUri, 0, true, false);
    AppMethodBeat.o(11776);
  }
  
  public final void loadUri(Uri paramUri, int paramInt)
  {
    AppMethodBeat.i(11777);
    loadUri(paramUri, paramInt, true, false);
    AppMethodBeat.o(11777);
  }
  
  public final void loadUri(Uri paramUri, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(11778);
    loadUri(paramUri, paramInt, paramBoolean, false);
    AppMethodBeat.o(11778);
  }
  
  public final void loadUri(Uri paramUri, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(11779);
    if (paramUri != null) {
      bool1 = paramUri.equals(this.zzqn);
    }
    while (bool1) {
      if (this.zzqn != null)
      {
        zzc(true);
        AppMethodBeat.o(11779);
        return;
        if (this.zzqn == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
      }
      else if (this.zzqo == paramInt)
      {
        zzc(false);
        AppMethodBeat.o(11779);
        return;
      }
    }
    if (zzqm == null)
    {
      bool1 = getContext().getApplicationContext().getPackageName().equals("com.google.android.play.games");
      zzqm = ImageManager.create(getContext(), bool1);
    }
    boolean bool1 = bool2;
    if (!this.zzpm) {
      if (!this.zzqp) {
        break label218;
      }
    }
    label218:
    for (bool1 = bool2;; bool1 = false)
    {
      this.zzqp = false;
      paramUri = new ImageRequest.ImageViewImageRequest(this, paramUri);
      paramUri.setNoDataPlaceholder(paramInt);
      paramUri.setCrossFadeEnabled(this.zzpl);
      paramUri.setCrossFadeAlwaysEnabled(bool1);
      paramUri.setLoadingPlaceholderEnabled(paramBoolean1);
      paramUri.setPostProcessingFlags(this.mPostProcessingFlags);
      paramUri.setOnImageLoadedListener(this.mOnImageLoadedListener);
      paramUri.setUseNewDrawable(paramBoolean2);
      zzqm.loadImage(paramUri);
      AppMethodBeat.o(11779);
      return;
    }
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(11786);
    if (this.zzqr != null) {
      paramCanvas.clipPath(this.zzqr.getClipPath(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.zzqq != 0) {
      paramCanvas.drawColor(this.zzqq);
    }
    AppMethodBeat.o(11786);
  }
  
  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(11785);
    super.onMeasure(paramInt1, paramInt2);
    switch (this.zzqs)
    {
    default: 
      AppMethodBeat.o(11785);
      return;
    case 1: 
      paramInt1 = getMeasuredHeight();
      paramInt2 = (int)(paramInt1 * this.zzqt);
    }
    for (;;)
    {
      setMeasuredDimension(paramInt2, paramInt1);
      AppMethodBeat.o(11785);
      return;
      paramInt2 = getMeasuredWidth();
      paramInt1 = (int)(paramInt2 / this.zzqt);
    }
  }
  
  public final void setCircleCropEnabled(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mPostProcessingFlags |= 0x1;
      return;
    }
    this.mPostProcessingFlags &= 0xFFFFFFFE;
  }
  
  public final void setClipPathProvider(ClipPathProvider paramClipPathProvider)
  {
    AppMethodBeat.i(11782);
    this.zzqr = paramClipPathProvider;
    if (!PlatformVersion.isAtLeastJellyBean()) {
      setLayerType(1, null);
    }
    AppMethodBeat.o(11782);
  }
  
  public final void setCrossFadeAlwaysEnabled(boolean paramBoolean)
  {
    this.zzpm = paramBoolean;
  }
  
  public final void setCrossFadeEnabled(boolean paramBoolean)
  {
    this.zzpl = paramBoolean;
  }
  
  public final void setImageAspectRatioAdjust(int paramInt, float paramFloat)
  {
    boolean bool2 = true;
    AppMethodBeat.i(11783);
    if ((paramInt == 0) || (paramInt == 1) || (paramInt == 2))
    {
      bool1 = true;
      Asserts.checkState(bool1);
      if (paramFloat <= 0.0F) {
        break label68;
      }
    }
    label68:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      Asserts.checkState(bool1);
      this.zzqs = paramInt;
      this.zzqt = paramFloat;
      requestLayout();
      AppMethodBeat.o(11783);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void setLoadedNoDataPlaceholderResId(int paramInt)
  {
    this.zzqo = paramInt;
  }
  
  public final void setLoadedUri(Uri paramUri)
  {
    this.zzqn = paramUri;
  }
  
  public final void setOnImageLoadedListener(ImageManager.OnImageLoadedListener paramOnImageLoadedListener)
  {
    this.mOnImageLoadedListener = paramOnImageLoadedListener;
  }
  
  public final void setTintColor(int paramInt)
  {
    AppMethodBeat.i(11781);
    this.zzqq = paramInt;
    if (this.zzqq != 0) {
      setColorFilter(ColorFilters.COLOR_FILTER_BW);
    }
    for (;;)
    {
      invalidate();
      AppMethodBeat.o(11781);
      return;
      setColorFilter(null);
    }
  }
  
  public final void setTintColorId(int paramInt)
  {
    AppMethodBeat.i(11780);
    int j = 0;
    int i = j;
    if (paramInt > 0)
    {
      Resources localResources = getResources();
      i = j;
      if (localResources != null) {
        i = localResources.getColor(paramInt);
      }
    }
    setTintColor(i);
    AppMethodBeat.o(11780);
  }
  
  public static abstract interface ClipPathProvider
  {
    public abstract Path getClipPath(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.images.internal.LoadingImageView
 * JD-Core Version:    0.7.0.1
 */
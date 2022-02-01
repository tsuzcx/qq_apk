package com.tencent.mm.graphics.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;
import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.davemorrissey.labs.subscaleview.decoder.ImageDecodeResult;
import com.davemorrissey.labs.subscaleview.performance.ImageDecodeRecord;
import com.davemorrissey.labs.subscaleview.view.ImageSource;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.AnimationBuilder;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.EdgeSwipeListener;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.OnStateChangedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.c;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a;
import com.tencent.mm.graphics.c.b;
import com.tencent.mm.graphics.c.c;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WxBaseImageView
  extends FrameLayout
{
  private boolean eoc;
  protected int imageHeight;
  protected int imageWidth;
  private Context mContext;
  private Rect mRect;
  private long mStartLoadTime;
  private ViewStub mwd;
  private ViewStub mwe;
  private ImageView mwf;
  public SubsamplingScaleImageView mwg;
  private com.tencent.mm.graphics.a.b mwh;
  private a mwi;
  private com.tencent.mm.graphics.a.d mwj;
  private boolean mwk;
  private a.a mwl;
  private a.a mwm;
  private boolean mwn;
  private boolean mwo;
  private boolean mwp;
  private boolean mwq;
  private boolean mwr;
  private boolean mws;
  private MMHandler mwt;
  
  public WxBaseImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WxBaseImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WxBaseImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(136229);
    this.mwd = null;
    this.mwe = null;
    this.mwf = null;
    this.mwg = null;
    this.mwh = null;
    this.mwi = null;
    this.mwj = com.tencent.mm.graphics.a.d.mvw;
    this.mwk = false;
    this.mRect = new Rect();
    this.mwr = false;
    this.mws = false;
    this.mwt = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(c.b.view_mm_image_view, this, true);
    this.mwd = ((ViewStub)findViewById(c.a.stub_tile));
    Object localObject = this.mwd.inflate();
    if (localObject != null)
    {
      this.mwg = ((SubsamplingScaleImageView)localObject);
      this.mwg.setVisibility(0);
    }
    localObject = c.mvH;
    if (!((c)localObject).mvL)
    {
      ((c)localObject).mvL = true;
      Log.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { Util.getStack() });
      ((c)localObject).aXZ().postFrameCallback((Choreographer.FrameCallback)localObject);
    }
    com.tencent.mm.graphics.b.d.mvO.mvP = new WeakReference(this.mContext);
    this.mwg.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(136221);
        com.tencent.mm.graphics.b.d.mvO.aYb();
        WxBaseImageView.a(WxBaseImageView.this);
        AppMethodBeat.o(136221);
      }
    });
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, c.c.WxBaseImageView);
    try
    {
      setTileBackgroundColor(paramContext.getColor(c.c.WxBaseImageView_tileBackgroundColor, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(136229);
    }
  }
  
  private void aYc()
  {
    AppMethodBeat.i(136246);
    if (!this.mwk)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.eoc)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.mwn) && (!this.mwp))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.mwo) && (!this.mwq))
    {
      AppMethodBeat.o(136246);
      return;
    }
    Log.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.mvV;
    com.tencent.mm.graphics.c.a.a(this.mwm, this.mwl);
    this.eoc = true;
    AppMethodBeat.o(136246);
  }
  
  private String getActivityName()
  {
    AppMethodBeat.i(136243);
    if ((this.mContext != null) && ((this.mContext instanceof Activity)))
    {
      String str = ((Activity)this.mContext).getClass().getSimpleName();
      AppMethodBeat.o(136243);
      return str;
    }
    AppMethodBeat.o(136243);
    return "Default";
  }
  
  private void rX(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      ImageDecodeRecord localImageDecodeRecord;
      if ((this.mwg != null) && (this.mwl != null))
      {
        this.mwl.mvY = ((int)(System.currentTimeMillis() - this.mStartLoadTime));
        localImageDecodeRecord = this.mwg.getImageDecodeRecord();
        if (localImageDecodeRecord == null) {
          break label142;
        }
      }
      label142:
      for (this.mwl.mvZ = localImageDecodeRecord.mPreviewLoadedTime;; this.mwl.mvZ = 0)
      {
        this.mwl.mvX = paramInt;
        this.mwl.orientation = this.mwg.getPreviewOrientation();
        this.mwl.width = this.mwg.getPreviewWidth();
        this.mwl.height = this.mwg.getPreviewHeight();
        this.mwl.fullImageSampleSize = 1;
        this.mwl.fileSize = ((int)y.bEl(this.mwl.imagePath));
        AppMethodBeat.o(136244);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillPreviewInfo exception", new Object[0]);
      AppMethodBeat.o(136244);
    }
  }
  
  private void rY(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      ImageDecodeRecord localImageDecodeRecord;
      a.a locala;
      int i;
      if ((this.mwg != null) && (this.mwm != null))
      {
        this.mwm.mvY = ((int)(System.currentTimeMillis() - this.mStartLoadTime));
        localImageDecodeRecord = this.mwg.getImageDecodeRecord();
        if (localImageDecodeRecord == null) {
          break label159;
        }
        locala = this.mwm;
        i = localImageDecodeRecord.mTileInitTime;
      }
      label159:
      for (locala.mvZ = (localImageDecodeRecord.mTileDecodeTime + i);; this.mwl.mvZ = 0)
      {
        this.mwm.mvX = paramInt;
        this.mwm.orientation = this.mwg.getRequiredRotation();
        this.mwm.width = this.mwg.getSWidth();
        this.mwm.height = this.mwg.getSHeight();
        this.mwm.fullImageSampleSize = this.mwg.getFullImageSampleSize();
        this.mwm.fileSize = ((int)y.bEl(this.mwm.imagePath));
        AppMethodBeat.o(136245);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      Log.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillMainInfo exception", new Object[0]);
      AppMethodBeat.o(136245);
    }
  }
  
  public final void a(String paramString, ImageSource paramImageSource)
  {
    AppMethodBeat.i(136232);
    Log.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()) });
    if (this.mwj == com.tencent.mm.graphics.a.d.mvw)
    {
      if (this.mwg == null)
      {
        Log.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
        AppMethodBeat.o(136232);
        return;
      }
      if (paramString == null)
      {
        Log.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
        AppMethodBeat.o(136232);
        return;
      }
      this.mwd.setVisibility(0);
      ImageSource localImageSource = ImageSource.uri(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (localImageSource.bitmap == null)
      {
        localImageSource.sWidth = i;
        localImageSource.sHeight = j;
      }
      if (localImageSource.sRegion != null)
      {
        localImageSource.tile = true;
        localImageSource.sWidth = localImageSource.sRegion.width();
        localImageSource.sHeight = localImageSource.sRegion.height();
      }
      this.mStartLoadTime = System.currentTimeMillis();
      Log.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.mStartLoadTime) });
      this.mwm = new a.a();
      this.mwm.imageType = 22;
      this.mwm.imagePath = paramString;
      this.mwm.from = getActivityName();
      this.mwo = true;
      if (paramImageSource != null)
      {
        this.mwl = new a.a();
        if (paramImageSource.getUri() != null)
        {
          this.mwl.imagePath = paramImageSource.getUri().toString();
          Log.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.mwl.imagePath });
          this.mwl.imageType = 21;
          this.mwl.from = getActivityName();
        }
      }
      for (this.mwn = true;; this.mwn = false)
      {
        if (paramImageSource == null) {
          break label391;
        }
        this.mwg.a(localImageSource, paramImageSource);
        AppMethodBeat.o(136232);
        return;
        this.mwl.imagePath = "";
        break;
      }
      label391:
      this.mwg.setImage(localImageSource);
    }
    AppMethodBeat.o(136232);
  }
  
  protected final void addOnTouchListener(View.OnTouchListener paramOnTouchListener)
  {
    AppMethodBeat.i(231795);
    if (this.mwg != null) {
      this.mwg.onTouchListener = paramOnTouchListener;
    }
    AppMethodBeat.o(231795);
  }
  
  public float ag(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(231846);
    if (this.mwg != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.mwg;
      PointF localPointF = new PointF(paramFloat1, paramFloat2);
      paramFloat1 = localSubsamplingScaleImageView.doubleTapZoom(localSubsamplingScaleImageView.viewToSourceCoord(localPointF), localPointF);
      AppMethodBeat.o(231846);
      return paramFloat1;
    }
    AppMethodBeat.o(231846);
    return 0.0F;
  }
  
  public final void dU(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public Bitmap getFullImageBitmap()
  {
    AppMethodBeat.i(136237);
    if (this.mwg != null)
    {
      Bitmap localBitmap = this.mwg.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(231799);
    if (this.mwg != null)
    {
      PointF localPointF = this.mwg.getImageViewMatrixScale();
      AppMethodBeat.o(231799);
      return localPointF;
    }
    AppMethodBeat.o(231799);
    return null;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(231803);
    if (this.mwg != null)
    {
      PointF localPointF = this.mwg.getImageViewMatrixTranslation();
      AppMethodBeat.o(231803);
      return localPointF;
    }
    AppMethodBeat.o(231803);
    return null;
  }
  
  public boolean getInternalTouchEventConsumed()
  {
    AppMethodBeat.i(231766);
    boolean bool = this.mwg.getInternalTouchEventConsumed();
    AppMethodBeat.o(231766);
    return bool;
  }
  
  public float getMinScale()
  {
    AppMethodBeat.i(231834);
    if (this.mwg != null)
    {
      float f = this.mwg.getMinScale();
      AppMethodBeat.o(231834);
      return f;
    }
    AppMethodBeat.o(231834);
    return 1.0F;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.mwg != null)
    {
      float f = this.mwg.getScale();
      AppMethodBeat.o(136241);
      return f;
    }
    AppMethodBeat.o(136241);
    return 1.0F;
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(136230);
    super.onMeasure(paramInt1, paramInt2);
    this.mRect.left = getLeft();
    this.mRect.right = getRight();
    this.mRect.top = getTop();
    this.mRect.bottom = getBottom();
    if (!getGlobalVisibleRect(this.mRect)) {
      this.mwk = false;
    }
    for (;;)
    {
      aYc();
      AppMethodBeat.o(136230);
      return;
      Log.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.mwk = true;
      if (this.mws) {
        continue;
      }
      this.mws = true;
      com.tencent.mm.graphics.b.d locald = com.tencent.mm.graphics.b.d.mvO;
      synchronized (locald.mvS)
      {
        if (locald.Uz)
        {
          Log.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.Uz = false;
        }
        if (locald.mvR != null) {
          locald.mvR.cancel();
        }
        System.gc();
        locald.mvQ.clear();
        if ((locald.mvP != null) && (locald.mvP.get() != null)) {
          locald.mvQ.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.mvP.get()));
        }
        i locali = h.ahAA;
        d.1 local1 = new d.1(locald);
        locald.mvR = local1;
        locali.a(local1, 0L, 5L);
        locald.Uz = true;
      }
    }
  }
  
  public final void resetSize()
  {
    AppMethodBeat.i(136242);
    if (this.mwg != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.mwg;
      localSubsamplingScaleImageView.setScaleAndCenter(localSubsamplingScaleImageView.mScaleRate, new PointF(0.0F, 0.0F));
    }
    AppMethodBeat.o(136242);
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(231863);
    if (this.mwg != null) {
      this.mwg.setAllowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(231863);
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(136235);
    Log.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(136235);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(231836);
    if (this.mwg != null) {
      this.mwg.setCanRefresh(paramBoolean);
    }
    AppMethodBeat.o(231836);
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(231850);
    if ((this.mwg != null) && (paramFloat != null)) {
      this.mwg.setScaleRate(paramFloat.floatValue());
    }
    AppMethodBeat.o(231850);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.EdgeSwipeListener paramEdgeSwipeListener)
  {
    AppMethodBeat.i(136234);
    this.mwg.setEdgeSwipeListener(paramEdgeSwipeListener);
    AppMethodBeat.o(136234);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(136236);
    Log.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
    AppMethodBeat.o(136236);
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.d paramd)
  {
    AppMethodBeat.i(136231);
    Log.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramd });
    this.mwj = paramd;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.mwg != null) {
      this.mwg.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(231807);
    if (this.mwg != null) {
      this.mwg.setImageViewMatrix(paramMatrix);
    }
    AppMethodBeat.o(231807);
  }
  
  public void setInternalTouchEventConsumed(boolean paramBoolean)
  {
    AppMethodBeat.i(231775);
    this.mwg.setInternalTouchEventConsumed(paramBoolean);
    AppMethodBeat.o(231775);
  }
  
  public void setMinScale(float paramFloat)
  {
    AppMethodBeat.i(231829);
    if (this.mwg != null) {
      this.mwg.setMinScale(paramFloat);
    }
    AppMethodBeat.o(231829);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    AppMethodBeat.i(231853);
    if (this.mwg != null) {
      this.mwg.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
    AppMethodBeat.o(231853);
  }
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.mwg != null)
    {
      this.mwh = new com.tencent.mm.graphics.a.b()
      {
        public final void onImageLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
        {
          AppMethodBeat.i(136226);
          WxBaseImageView.b(WxBaseImageView.this, paramAnonymousImageDecodeResult);
          if (paramb != null) {
            paramb.onImageLoadError(paramAnonymousImageDecodeResult);
          }
          AppMethodBeat.o(136226);
        }
        
        public final void onImageLoaded(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(136224);
          WxBaseImageView.e(WxBaseImageView.this);
          if (paramb != null) {
            paramb.onImageLoaded(paramAnonymousBitmap);
          }
          AppMethodBeat.o(136224);
        }
        
        public final void onPreviewLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
        {
          AppMethodBeat.i(136225);
          WxBaseImageView.a(WxBaseImageView.this, paramAnonymousImageDecodeResult);
          if (paramb != null) {
            paramb.onPreviewLoadError(paramAnonymousImageDecodeResult);
          }
          AppMethodBeat.o(136225);
        }
        
        public final void onPreviewLoaded()
        {
          AppMethodBeat.i(136223);
          WxBaseImageView.d(WxBaseImageView.this);
          if (paramb != null) {
            paramb.onPreviewLoaded();
          }
          AppMethodBeat.o(136223);
        }
        
        public final void onPreviewReleased()
        {
          AppMethodBeat.i(136228);
          Log.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.onPreviewReleased();
          }
          AppMethodBeat.o(136228);
        }
        
        public final void onTileLoadError(ImageDecodeResult paramAnonymousImageDecodeResult)
        {
          AppMethodBeat.i(136227);
          WxBaseImageView.b(WxBaseImageView.this, paramAnonymousImageDecodeResult);
          if (paramb != null) {
            paramb.onTileLoadError(paramAnonymousImageDecodeResult);
          }
          AppMethodBeat.o(136227);
        }
      };
      this.mwg.setOnImageEventListener(this.mwh);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.mwg != null) {
      this.mwg.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setOnZoomScaleChangedListener(SubsamplingScaleImageView.OnStateChangedListener paramOnStateChangedListener)
  {
    AppMethodBeat.i(231859);
    if (this.mwg != null) {
      this.mwg.setOnStateChangedListener(paramOnStateChangedListener);
    }
    AppMethodBeat.o(231859);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.mwg != null) {
      this.mwg.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
  
  public void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(231760);
    if (this.mwg != null) {
      this.mwg.setTileBackgroundColor(paramInt);
    }
    AppMethodBeat.o(231760);
  }
  
  public void zoomToWithAnimation(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(231841);
    if (this.mwg != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.mwg;
      Object localObject = new PointF(paramFloat2, paramFloat3);
      Log.v(localSubsamplingScaleImageView.TAG, "alvinluo zoomToWithAnimation target scale: %s, mScaleRate: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(localSubsamplingScaleImageView.mScaleRate) });
      localObject = new SubsamplingScaleImageView.AnimationBuilder(localSubsamplingScaleImageView, paramFloat1, localSubsamplingScaleImageView.viewToSourceCoord((PointF)localObject), (byte)0);
      ((SubsamplingScaleImageView.AnimationBuilder)localObject).interruptible = false;
      ((SubsamplingScaleImageView.AnimationBuilder)localObject).duration = localSubsamplingScaleImageView.doubleTapZoomDuration;
      ((SubsamplingScaleImageView.AnimationBuilder)localObject).origin = 4;
      ((SubsamplingScaleImageView.AnimationBuilder)localObject).start();
      localSubsamplingScaleImageView.invalidate();
    }
    AppMethodBeat.o(231841);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
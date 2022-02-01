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
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.b;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.c;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.f;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a;
import com.tencent.mm.graphics.c.b;
import com.tencent.mm.graphics.c.c;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WxBaseImageView
  extends FrameLayout
{
  private long aGc;
  private boolean cwe;
  protected int imageHeight;
  protected int imageWidth;
  private ViewStub jWj;
  private ViewStub jWk;
  private ImageView jWl;
  public SubsamplingScaleImageView jWm;
  private com.tencent.mm.graphics.a.b jWn;
  private a jWo;
  private com.tencent.mm.graphics.a.d jWp;
  private boolean jWq;
  private a.a jWr;
  private a.a jWs;
  private boolean jWt;
  private boolean jWu;
  private boolean jWv;
  private boolean jWw;
  private boolean jWx;
  private boolean jWy;
  private MMHandler jWz;
  private Context mContext;
  private Rect mRect;
  
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
    this.jWj = null;
    this.jWk = null;
    this.jWl = null;
    this.jWm = null;
    this.jWn = null;
    this.jWo = null;
    this.jWp = com.tencent.mm.graphics.a.d.jVC;
    this.jWq = false;
    this.mRect = new Rect();
    this.jWx = false;
    this.jWy = false;
    this.jWz = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(c.b.view_mm_image_view, this, true);
    this.jWj = ((ViewStub)findViewById(c.a.stub_tile));
    Object localObject = this.jWj.inflate();
    if (localObject != null)
    {
      this.jWm = ((SubsamplingScaleImageView)localObject);
      this.jWm.setVisibility(0);
    }
    localObject = com.tencent.mm.graphics.b.c.jVN;
    if (!((com.tencent.mm.graphics.b.c)localObject).jVR)
    {
      ((com.tencent.mm.graphics.b.c)localObject).jVR = true;
      Log.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { Util.getStack() });
      ((com.tencent.mm.graphics.b.c)localObject).aEX().postFrameCallback((Choreographer.FrameCallback)localObject);
    }
    com.tencent.mm.graphics.b.d.jVU.jVV = new WeakReference(this.mContext);
    this.jWm.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(136221);
        com.tencent.mm.graphics.b.d.jVU.aEZ();
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
  
  private void aFb()
  {
    AppMethodBeat.i(136246);
    if (!this.jWq)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.cwe)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.jWt) && (!this.jWv))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.jWu) && (!this.jWw))
    {
      AppMethodBeat.o(136246);
      return;
    }
    Log.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.jWb;
    com.tencent.mm.graphics.c.a.a(this.jWs, this.jWr);
    this.cwe = true;
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
  
  private void sb(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.jWm != null) && (this.jWr != null))
      {
        this.jWr.jWe = ((int)(System.currentTimeMillis() - this.aGc));
        locala = this.jWm.getImageDecodeRecord();
        if (locala == null) {
          break label142;
        }
      }
      label142:
      for (this.jWr.jWf = locala.aGk;; this.jWr.jWf = 0)
      {
        this.jWr.jWd = paramInt;
        this.jWr.FO = this.jWm.getPreviewOrientation();
        this.jWr.width = this.jWm.getPreviewWidth();
        this.jWr.height = this.jWm.getPreviewHeight();
        this.jWr.aGE = 1;
        this.jWr.fileSize = ((int)u.bBQ(this.jWr.imagePath));
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
  
  private void sc(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.jWm != null) && (this.jWs != null))
      {
        this.jWs.jWe = ((int)(System.currentTimeMillis() - this.aGc));
        locala = this.jWm.getImageDecodeRecord();
        if (locala == null) {
          break label159;
        }
        locala1 = this.jWs;
        i = locala.aGl;
      }
      label159:
      for (locala1.jWf = (locala.aGm + i);; this.jWr.jWf = 0)
      {
        this.jWs.jWd = paramInt;
        this.jWs.FO = this.jWm.getRequiredRotation();
        this.jWs.width = this.jWm.getSWidth();
        this.jWs.height = this.jWm.getSHeight();
        this.jWs.aGE = this.jWm.getFullImageSampleSize();
        this.jWs.fileSize = ((int)u.bBQ(this.jWs.imagePath));
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
  
  public float A(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(193472);
    if (this.jWm != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.jWm;
      PointF localPointF = new PointF(paramFloat1, paramFloat2);
      paramFloat1 = localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.a(localPointF), localPointF);
      AppMethodBeat.o(193472);
      return paramFloat1;
    }
    AppMethodBeat.o(193472);
    return 0.0F;
  }
  
  protected final void a(View.OnTouchListener paramOnTouchListener)
  {
    if (this.jWm != null) {
      this.jWm.aIw = paramOnTouchListener;
    }
  }
  
  public final void a(String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(136232);
    Log.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()) });
    if (this.jWp == com.tencent.mm.graphics.a.d.jVC)
    {
      if (this.jWm == null)
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
      this.jWj.setVisibility(0);
      com.davemorrissey.labs.subscaleview.view.a locala = com.davemorrissey.labs.subscaleview.view.a.aZ(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (locala.bitmap == null)
      {
        locala.aGp = i;
        locala.aGq = j;
      }
      if (locala.aGr != null)
      {
        locala.aGo = true;
        locala.aGp = locala.aGr.width();
        locala.aGq = locala.aGr.height();
      }
      this.aGc = System.currentTimeMillis();
      Log.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aGc) });
      this.jWs = new a.a();
      this.jWs.imageType = 22;
      this.jWs.imagePath = paramString;
      this.jWs.from = getActivityName();
      this.jWu = true;
      if (parama != null)
      {
        this.jWr = new a.a();
        if (parama.getUri() != null)
        {
          this.jWr.imagePath = parama.getUri().toString();
          Log.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.jWr.imagePath });
          this.jWr.imageType = 21;
          this.jWr.from = getActivityName();
        }
      }
      for (this.jWt = true;; this.jWt = false)
      {
        if (parama == null) {
          break label391;
        }
        this.jWm.a(locala, parama);
        AppMethodBeat.o(136232);
        return;
        this.jWr.imagePath = "";
        break;
      }
      label391:
      this.jWm.setImage(locala);
    }
    AppMethodBeat.o(136232);
  }
  
  public final void aFa()
  {
    AppMethodBeat.i(136242);
    if (this.jWm != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.jWm;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.aIn, new PointF(0.0F, 0.0F));
    }
    AppMethodBeat.o(136242);
  }
  
  public final void di(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public Bitmap getFullImageBitmap()
  {
    AppMethodBeat.i(136237);
    if (this.jWm != null)
    {
      Bitmap localBitmap = this.jWm.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(193458);
    if (this.jWm != null)
    {
      PointF localPointF = this.jWm.getImageViewMatrixScale();
      AppMethodBeat.o(193458);
      return localPointF;
    }
    AppMethodBeat.o(193458);
    return null;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(193459);
    if (this.jWm != null)
    {
      PointF localPointF = this.jWm.getImageViewMatrixTranslation();
      AppMethodBeat.o(193459);
      return localPointF;
    }
    AppMethodBeat.o(193459);
    return null;
  }
  
  public float getMinScale()
  {
    AppMethodBeat.i(193466);
    if (this.jWm != null)
    {
      float f = this.jWm.getMinScale();
      AppMethodBeat.o(193466);
      return f;
    }
    AppMethodBeat.o(193466);
    return 1.0F;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.jWm != null)
    {
      float f = this.jWm.getScale();
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
  
  public void m(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(193470);
    if (this.jWm != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.jWm;
      Object localObject = new PointF(paramFloat2, paramFloat3);
      Log.v(localSubsamplingScaleImageView.TAG, "alvinluo zoomToWithAnimation target scale: %s, mScaleRate: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(localSubsamplingScaleImageView.aIn) });
      localObject = new SubsamplingScaleImageView.b(localSubsamplingScaleImageView, paramFloat1, localSubsamplingScaleImageView.a((PointF)localObject), (byte)0);
      ((SubsamplingScaleImageView.b)localObject).aIQ = false;
      ((SubsamplingScaleImageView.b)localObject).duration = localSubsamplingScaleImageView.aHb;
      ((SubsamplingScaleImageView.b)localObject).aIS = 4;
      ((SubsamplingScaleImageView.b)localObject).start();
      localSubsamplingScaleImageView.invalidate();
    }
    AppMethodBeat.o(193470);
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
      this.jWq = false;
    }
    for (;;)
    {
      aFb();
      AppMethodBeat.o(136230);
      return;
      Log.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.jWq = true;
      if (this.jWy) {
        continue;
      }
      this.jWy = true;
      com.tencent.mm.graphics.b.d locald = com.tencent.mm.graphics.b.d.jVU;
      synchronized (locald.jVY)
      {
        if (locald.isRunning)
        {
          Log.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.jVX != null) {
          locald.jVX.cancel();
        }
        System.gc();
        locald.jVW.clear();
        if ((locald.jVV != null) && (locald.jVV.get() != null)) {
          locald.jVW.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.jVV.get()));
        }
        i locali = h.ZvG;
        d.1 local1 = new d.1(locald);
        locald.jVX = local1;
        locali.a(local1, 0L, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(193476);
    if (this.jWm != null) {
      this.jWm.setAllowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(193476);
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(136235);
    Log.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(136235);
  }
  
  public void setCanRefresh(boolean paramBoolean)
  {
    AppMethodBeat.i(193467);
    if (this.jWm != null) {
      this.jWm.setCanRefresh(paramBoolean);
    }
    AppMethodBeat.o(193467);
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(193473);
    if ((this.jWm != null) && (paramFloat != null)) {
      this.jWm.setScaleRate(paramFloat.floatValue());
    }
    AppMethodBeat.o(193473);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    AppMethodBeat.i(136234);
    this.jWm.setEdgeSwipeListener(paramc);
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
    this.jWp = paramd;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.jWm != null) {
      this.jWm.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(193460);
    if (this.jWm != null) {
      this.jWm.setImageViewMatrix(paramMatrix);
    }
    AppMethodBeat.o(193460);
  }
  
  public void setMinScale(float paramFloat)
  {
    AppMethodBeat.i(193465);
    if (this.jWm != null) {
      this.jWm.setMinScale(paramFloat);
    }
    AppMethodBeat.o(193465);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    AppMethodBeat.i(193474);
    if (this.jWm != null) {
      this.jWm.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
    AppMethodBeat.o(193474);
  }
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.jWm != null)
    {
      this.jWn = new com.tencent.mm.graphics.a.b()
      {
        public final void a(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(136225);
          WxBaseImageView.a(WxBaseImageView.this, paramAnonymousc);
          if (paramb != null) {
            paramb.a(paramAnonymousc);
          }
          AppMethodBeat.o(136225);
        }
        
        public final void b(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(136226);
          WxBaseImageView.b(WxBaseImageView.this, paramAnonymousc);
          if (paramb != null) {
            paramb.b(paramAnonymousc);
          }
          AppMethodBeat.o(136226);
        }
        
        public final void c(com.davemorrissey.labs.subscaleview.a.c paramAnonymousc)
        {
          AppMethodBeat.i(136227);
          WxBaseImageView.b(WxBaseImageView.this, paramAnonymousc);
          if (paramb != null) {
            paramb.c(paramAnonymousc);
          }
          AppMethodBeat.o(136227);
        }
        
        public final void i(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(136224);
          WxBaseImageView.e(WxBaseImageView.this);
          if (paramb != null) {
            paramb.i(paramAnonymousBitmap);
          }
          AppMethodBeat.o(136224);
        }
        
        public final void pP()
        {
          AppMethodBeat.i(136223);
          WxBaseImageView.d(WxBaseImageView.this);
          if (paramb != null) {
            paramb.pP();
          }
          AppMethodBeat.o(136223);
        }
        
        public final void pQ()
        {
          AppMethodBeat.i(136228);
          Log.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.pQ();
          }
          AppMethodBeat.o(136228);
        }
      };
      this.jWm.setOnImageEventListener(this.jWn);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.jWm != null) {
      this.jWm.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setOnZoomScaleChangedListener(SubsamplingScaleImageView.f paramf)
  {
    AppMethodBeat.i(193475);
    if (this.jWm != null) {
      this.jWm.setOnStateChangedListener(paramf);
    }
    AppMethodBeat.o(193475);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.jWm != null) {
      this.jWm.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
  
  public void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(193451);
    if (this.jWm != null) {
      this.jWm.setTileBackgroundColor(paramInt);
    }
    AppMethodBeat.o(193451);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
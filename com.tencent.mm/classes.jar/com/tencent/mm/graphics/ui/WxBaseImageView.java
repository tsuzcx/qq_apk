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
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.s;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WxBaseImageView
  extends FrameLayout
{
  private long aWK;
  private boolean cxw;
  private ViewStub hkA;
  private ViewStub hkB;
  private ImageView hkC;
  public SubsamplingScaleImageView hkD;
  private com.tencent.mm.graphics.a.b hkE;
  private a hkF;
  private com.tencent.mm.graphics.a.c hkG;
  private boolean hkH;
  private a.a hkI;
  private a.a hkJ;
  private boolean hkK;
  private boolean hkL;
  private boolean hkM;
  private boolean hkN;
  private boolean hkO;
  private boolean hkP;
  private MMHandler hkQ;
  protected int imageHeight;
  protected int imageWidth;
  private Context mContext;
  private Rect mRect;
  
  public WxBaseImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WxBaseImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(136229);
    this.hkA = null;
    this.hkB = null;
    this.hkC = null;
    this.hkD = null;
    this.hkE = null;
    this.hkF = null;
    this.hkG = com.tencent.mm.graphics.a.c.hjT;
    this.hkH = false;
    this.mRect = new Rect();
    this.hkO = false;
    this.hkP = false;
    this.hkQ = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131496818, this, true);
    this.hkA = ((ViewStub)findViewById(2131308713));
    Object localObject = this.hkA.inflate();
    if (localObject != null)
    {
      this.hkD = ((SubsamplingScaleImageView)localObject);
      this.hkD.setVisibility(0);
    }
    localObject = com.tencent.mm.graphics.b.c.hke;
    if (!((com.tencent.mm.graphics.b.c)localObject).hki)
    {
      ((com.tencent.mm.graphics.b.c)localObject).hki = true;
      Log.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { Util.getStack() });
      ((com.tencent.mm.graphics.b.c)localObject).axF().postFrameCallback((Choreographer.FrameCallback)localObject);
    }
    d.hkl.hkm = new WeakReference(this.mContext);
    this.hkD.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(136221);
        d.hkl.axH();
        WxBaseImageView.a(WxBaseImageView.this);
        AppMethodBeat.o(136221);
      }
    });
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, c.a.WxBaseImageView);
    try
    {
      setTileBackgroundColor(paramContext.getColor(0, 0));
      return;
    }
    finally
    {
      paramContext.recycle();
      AppMethodBeat.o(136229);
    }
  }
  
  private void axK()
  {
    AppMethodBeat.i(136246);
    if (!this.hkH)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.cxw)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.hkK) && (!this.hkM))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.hkL) && (!this.hkN))
    {
      AppMethodBeat.o(136246);
      return;
    }
    Log.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.hks;
    com.tencent.mm.graphics.c.a.a(this.hkJ, this.hkI);
    this.cxw = true;
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
  
  private void pC(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.hkD != null) && (this.hkI != null))
      {
        this.hkI.hkv = ((int)(System.currentTimeMillis() - this.aWK));
        locala = this.hkD.getImageDecodeRecord();
        if (locala == null) {
          break label142;
        }
      }
      label142:
      for (this.hkI.hkw = locala.aWS;; this.hkI.hkw = 0)
      {
        this.hkI.hku = paramInt;
        this.hkI.orientation = this.hkD.getPreviewOrientation();
        this.hkI.width = this.hkD.getPreviewWidth();
        this.hkI.height = this.hkD.getPreviewHeight();
        this.hkI.aXk = 1;
        this.hkI.fileSize = ((int)s.boW(this.hkI.imagePath));
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
  
  private void pD(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.hkD != null) && (this.hkJ != null))
      {
        this.hkJ.hkv = ((int)(System.currentTimeMillis() - this.aWK));
        locala = this.hkD.getImageDecodeRecord();
        if (locala == null) {
          break label159;
        }
        locala1 = this.hkJ;
        i = locala.aWT;
      }
      label159:
      for (locala1.hkw = (locala.aWU + i);; this.hkI.hkw = 0)
      {
        this.hkJ.hku = paramInt;
        this.hkJ.orientation = this.hkD.getRequiredRotation();
        this.hkJ.width = this.hkD.getSWidth();
        this.hkJ.height = this.hkD.getSHeight();
        this.hkJ.aXk = this.hkD.getFullImageSampleSize();
        this.hkJ.fileSize = ((int)s.boW(this.hkJ.imagePath));
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
  
  protected final void a(View.OnTouchListener paramOnTouchListener)
  {
    if (this.hkD != null) {
      this.hkD.aZa = paramOnTouchListener;
    }
  }
  
  public final void a(String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(136232);
    Log.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()) });
    if (this.hkG == com.tencent.mm.graphics.a.c.hjT)
    {
      if (this.hkD == null)
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
      this.hkA.setVisibility(0);
      com.davemorrissey.labs.subscaleview.view.a locala = com.davemorrissey.labs.subscaleview.view.a.aP(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (locala.bitmap == null)
      {
        locala.aWX = i;
        locala.aWY = j;
      }
      if (locala.aWZ != null)
      {
        locala.aWW = true;
        locala.aWX = locala.aWZ.width();
        locala.aWY = locala.aWZ.height();
      }
      this.aWK = System.currentTimeMillis();
      Log.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aWK) });
      this.hkJ = new a.a();
      this.hkJ.imageType = 22;
      this.hkJ.imagePath = paramString;
      this.hkJ.from = getActivityName();
      this.hkL = true;
      if (parama != null)
      {
        this.hkI = new a.a();
        if (parama.getUri() != null)
        {
          this.hkI.imagePath = parama.getUri().toString();
          Log.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.hkI.imagePath });
          this.hkI.imageType = 21;
          this.hkI.from = getActivityName();
        }
      }
      for (this.hkK = true;; this.hkK = false)
      {
        if (parama == null) {
          break label391;
        }
        this.hkD.a(locala, parama);
        AppMethodBeat.o(136232);
        return;
        this.hkI.imagePath = "";
        break;
      }
      label391:
      this.hkD.setImage(locala);
    }
    AppMethodBeat.o(136232);
  }
  
  public final void axJ()
  {
    AppMethodBeat.i(136242);
    if (this.hkD != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.hkD;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.aYR, new PointF(0.0F, 0.0F));
    }
    AppMethodBeat.o(136242);
  }
  
  public final void cN(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public Bitmap getFullImageBitmap()
  {
    AppMethodBeat.i(136237);
    if (this.hkD != null)
    {
      Bitmap localBitmap = this.hkD.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public PointF getImageViewMatrixScale()
  {
    AppMethodBeat.i(224114);
    if (this.hkD != null)
    {
      PointF localPointF = this.hkD.getImageViewMatrixScale();
      AppMethodBeat.o(224114);
      return localPointF;
    }
    AppMethodBeat.o(224114);
    return null;
  }
  
  public PointF getImageViewMatrixTranslation()
  {
    AppMethodBeat.i(224115);
    if (this.hkD != null)
    {
      PointF localPointF = this.hkD.getImageViewMatrixTranslation();
      AppMethodBeat.o(224115);
      return localPointF;
    }
    AppMethodBeat.o(224115);
    return null;
  }
  
  public float getMinScale()
  {
    AppMethodBeat.i(224118);
    if (this.hkD != null)
    {
      float f = this.hkD.getMinScale();
      AppMethodBeat.o(224118);
      return f;
    }
    AppMethodBeat.o(224118);
    return 1.0F;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.hkD != null)
    {
      float f = this.hkD.getScale();
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
  
  public void l(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    AppMethodBeat.i(224119);
    if (this.hkD != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.hkD;
      Object localObject = new PointF(paramFloat2, paramFloat3);
      Log.v(localSubsamplingScaleImageView.TAG, "alvinluo zoomToWithAnimation target scale: %s, mScaleRate: %s", new Object[] { Float.valueOf(paramFloat1), Float.valueOf(localSubsamplingScaleImageView.aYR) });
      localObject = new SubsamplingScaleImageView.b(localSubsamplingScaleImageView, paramFloat1, localSubsamplingScaleImageView.a((PointF)localObject), (byte)0);
      ((SubsamplingScaleImageView.b)localObject).aZu = false;
      ((SubsamplingScaleImageView.b)localObject).duration = localSubsamplingScaleImageView.aXH;
      ((SubsamplingScaleImageView.b)localObject).aZw = 4;
      ((SubsamplingScaleImageView.b)localObject).start();
      localSubsamplingScaleImageView.invalidate();
    }
    AppMethodBeat.o(224119);
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
      this.hkH = false;
    }
    for (;;)
    {
      axK();
      AppMethodBeat.o(136230);
      return;
      Log.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.hkH = true;
      if (this.hkP) {
        continue;
      }
      this.hkP = true;
      d locald = d.hkl;
      synchronized (locald.hkp)
      {
        if (locald.isRunning)
        {
          Log.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.hko != null) {
          locald.hko.cancel();
        }
        System.gc();
        locald.hkn.clear();
        if ((locald.hkm != null) && (locald.hkm.get() != null)) {
          locald.hkn.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.hkm.get()));
        }
        i locali = h.RTc;
        d.1 local1 = new d.1(locald);
        locald.hko = local1;
        locali.p(local1, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAllowInterceptTouchEvent(boolean paramBoolean)
  {
    AppMethodBeat.i(224124);
    if (this.hkD != null) {
      this.hkD.setAllowInterceptTouchEvent(paramBoolean);
    }
    AppMethodBeat.o(224124);
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(136235);
    Log.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(136235);
  }
  
  public void setCustomScaleRate(Float paramFloat)
  {
    AppMethodBeat.i(224121);
    if ((this.hkD != null) && (paramFloat != null)) {
      this.hkD.setScaleRate(paramFloat.floatValue());
    }
    AppMethodBeat.o(224121);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    AppMethodBeat.i(136234);
    this.hkD.setEdgeSwipeListener(paramc);
    AppMethodBeat.o(136234);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(136236);
    Log.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
    AppMethodBeat.o(136236);
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.c paramc)
  {
    AppMethodBeat.i(136231);
    Log.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramc });
    this.hkG = paramc;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.hkD != null) {
      this.hkD.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageViewMatrix(Matrix paramMatrix)
  {
    AppMethodBeat.i(224116);
    if (this.hkD != null) {
      this.hkD.setImageViewMatrix(paramMatrix);
    }
    AppMethodBeat.o(224116);
  }
  
  public void setMinScale(float paramFloat)
  {
    AppMethodBeat.i(224117);
    if (this.hkD != null) {
      this.hkD.setMinScale(paramFloat);
    }
    AppMethodBeat.o(224117);
  }
  
  public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener paramOnDoubleTapListener)
  {
    AppMethodBeat.i(224122);
    if (this.hkD != null) {
      this.hkD.setOnDoubleTapListener(paramOnDoubleTapListener);
    }
    AppMethodBeat.o(224122);
  }
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.hkD != null)
    {
      this.hkE = new com.tencent.mm.graphics.a.b()
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
        
        public final void n(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(136224);
          WxBaseImageView.e(WxBaseImageView.this);
          if (paramb != null) {
            paramb.n(paramAnonymousBitmap);
          }
          AppMethodBeat.o(136224);
        }
        
        public final void sb()
        {
          AppMethodBeat.i(136223);
          WxBaseImageView.d(WxBaseImageView.this);
          if (paramb != null) {
            paramb.sb();
          }
          AppMethodBeat.o(136223);
        }
        
        public final void sc()
        {
          AppMethodBeat.i(136228);
          Log.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.sc();
          }
          AppMethodBeat.o(136228);
        }
      };
      this.hkD.setOnImageEventListener(this.hkE);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.hkD != null) {
      this.hkD.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setOnZoomScaleChangedListener(SubsamplingScaleImageView.f paramf)
  {
    AppMethodBeat.i(224123);
    if (this.hkD != null) {
      this.hkD.setOnStateChangedListener(paramf);
    }
    AppMethodBeat.o(224123);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.hkD != null) {
      this.hkD.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
  
  public void setTileBackgroundColor(int paramInt)
  {
    AppMethodBeat.i(224113);
    if (this.hkD != null) {
      this.hkD.setTileBackgroundColor(paramInt);
    }
    AppMethodBeat.o(224113);
  }
  
  public float y(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(224120);
    if (this.hkD != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.hkD;
      PointF localPointF = new PointF(paramFloat1, paramFloat2);
      paramFloat1 = localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.a(localPointF), localPointF);
      AppMethodBeat.o(224120);
      return paramFloat1;
    }
    AppMethodBeat.o(224120);
    return 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
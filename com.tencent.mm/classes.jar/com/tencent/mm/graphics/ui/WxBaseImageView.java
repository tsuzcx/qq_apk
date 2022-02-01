package com.tencent.mm.graphics.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.Choreographer;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLongClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView;
import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.c;
import com.tencent.e.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WxBaseImageView
  extends FrameLayout
{
  private long aLL;
  private boolean cel;
  private ViewStub fWP;
  private ViewStub fWQ;
  private ImageView fWR;
  private SubsamplingScaleImageView fWS;
  private com.tencent.mm.graphics.a.b fWT;
  private a fWU;
  private com.tencent.mm.graphics.a.c fWV;
  private boolean fWW;
  private a.a fWX;
  private a.a fWY;
  private boolean fWZ;
  private boolean fXa;
  private boolean fXb;
  private boolean fXc;
  private boolean fXd;
  private boolean fXe;
  private ap fXf;
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
    this.fWP = null;
    this.fWQ = null;
    this.fWR = null;
    this.fWS = null;
    this.fWT = null;
    this.fWU = null;
    this.fWV = com.tencent.mm.graphics.a.c.fWh;
    this.fWW = false;
    this.mRect = new Rect();
    this.fXd = false;
    this.fXe = false;
    this.fXf = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131495849, this, true);
    this.fWP = ((ViewStub)findViewById(2131305505));
    paramContext = this.fWP.inflate();
    if (paramContext != null)
    {
      this.fWS = ((SubsamplingScaleImageView)paramContext);
      this.fWS.setVisibility(0);
    }
    paramContext = com.tencent.mm.graphics.b.c.fWs;
    if (!paramContext.fWx)
    {
      paramContext.fWx = true;
      ad.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bt.eGN() });
      paramContext.adb().postFrameCallback(paramContext);
    }
    d.fWA.fWB = new WeakReference(this.mContext);
    this.fWS.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(136221);
        d.fWA.ade();
        WxBaseImageView.a(WxBaseImageView.this);
        AppMethodBeat.o(136221);
      }
    });
    AppMethodBeat.o(136229);
  }
  
  private void adh()
  {
    AppMethodBeat.i(136246);
    if (!this.fWW)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.cel)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.fWZ) && (!this.fXb))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.fXa) && (!this.fXc))
    {
      AppMethodBeat.o(136246);
      return;
    }
    ad.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.fWH;
    com.tencent.mm.graphics.c.a.a(this.fWY, this.fWX);
    this.cel = true;
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
  
  private void lO(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.fWS != null) && (this.fWX != null))
      {
        this.fWX.fWK = ((int)(System.currentTimeMillis() - this.aLL));
        locala = this.fWS.getImageDecodeRecord();
        if (locala == null) {
          break label142;
        }
      }
      label142:
      for (this.fWX.fWL = locala.aLT;; this.fWX.fWL = 0)
      {
        this.fWX.fWJ = paramInt;
        this.fWX.orientation = this.fWS.getPreviewOrientation();
        this.fWX.width = this.fWS.getPreviewWidth();
        this.fWX.height = this.fWS.getPreviewHeight();
        this.fWX.aMn = 1;
        this.fWX.fileSize = ((int)com.tencent.mm.vfs.i.aMN(this.fWX.imagePath));
        AppMethodBeat.o(136244);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillPreviewInfo exception", new Object[0]);
      AppMethodBeat.o(136244);
    }
  }
  
  private void lP(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.fWS != null) && (this.fWY != null))
      {
        this.fWY.fWK = ((int)(System.currentTimeMillis() - this.aLL));
        locala = this.fWS.getImageDecodeRecord();
        if (locala == null) {
          break label159;
        }
        locala1 = this.fWY;
        i = locala.aLU;
      }
      label159:
      for (locala1.fWL = (locala.aLV + i);; this.fWX.fWL = 0)
      {
        this.fWY.fWJ = paramInt;
        this.fWY.orientation = this.fWS.getRequiredRotation();
        this.fWY.width = this.fWS.getSWidth();
        this.fWY.height = this.fWS.getSHeight();
        this.fWY.aMn = this.fWS.getFullImageSampleSize();
        this.fWY.fileSize = ((int)com.tencent.mm.vfs.i.aMN(this.fWY.imagePath));
        AppMethodBeat.o(136245);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ad.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillMainInfo exception", new Object[0]);
      AppMethodBeat.o(136245);
    }
  }
  
  public final void a(String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(136232);
    ad.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()) });
    if (this.fWV == com.tencent.mm.graphics.a.c.fWh)
    {
      if (this.fWS == null)
      {
        ad.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
        AppMethodBeat.o(136232);
        return;
      }
      if (paramString == null)
      {
        ad.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
        AppMethodBeat.o(136232);
        return;
      }
      this.fWP.setVisibility(0);
      com.davemorrissey.labs.subscaleview.view.a locala = com.davemorrissey.labs.subscaleview.view.a.U(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (locala.bitmap == null)
      {
        locala.aLY = i;
        locala.aLZ = j;
      }
      if (locala.aMa != null)
      {
        locala.aLX = true;
        locala.aLY = locala.aMa.width();
        locala.aLZ = locala.aMa.height();
      }
      this.aLL = System.currentTimeMillis();
      ad.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aLL) });
      this.fWY = new a.a();
      this.fWY.imageType = 22;
      this.fWY.imagePath = paramString;
      this.fWY.dvh = getActivityName();
      this.fXa = true;
      if (parama != null)
      {
        this.fWX = new a.a();
        if (parama.uri != null)
        {
          this.fWX.imagePath = parama.uri.toString();
          ad.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.fWX.imagePath });
          this.fWX.imageType = 21;
          this.fWX.dvh = getActivityName();
        }
      }
      for (this.fWZ = true;; this.fWZ = false)
      {
        if (parama == null) {
          break label391;
        }
        this.fWS.a(locala, parama);
        AppMethodBeat.o(136232);
        return;
        this.fWX.imagePath = "";
        break;
      }
      label391:
      this.fWS.setImage(locala);
    }
    AppMethodBeat.o(136232);
  }
  
  public final void adg()
  {
    AppMethodBeat.i(136242);
    if (this.fWS != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.fWS;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.aNM, new PointF(0.0F, 0.0F));
    }
    AppMethodBeat.o(136242);
  }
  
  public final void cH(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public Bitmap getFullImageBitmap()
  {
    AppMethodBeat.i(136237);
    if (this.fWS != null)
    {
      Bitmap localBitmap = this.fWS.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.fWS != null)
    {
      float f = this.fWS.getScale();
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
      this.fWW = false;
    }
    for (;;)
    {
      adh();
      AppMethodBeat.o(136230);
      return;
      ad.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.fWW = true;
      if (this.fXe) {
        continue;
      }
      this.fXe = true;
      d locald = d.fWA;
      synchronized (locald.fWE)
      {
        if (locald.isRunning)
        {
          ad.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.fWD != null) {
          locald.fWD.cancel();
        }
        System.gc();
        locald.fWC.clear();
        if ((locald.fWB != null) && (locald.fWB.get() != null)) {
          locald.fWC.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.fWB.get()));
        }
        com.tencent.e.i locali = h.Iye;
        d.1 local1 = new d.1(locald);
        locald.fWD = local1;
        locali.r(local1, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(136235);
    ad.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(136235);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    AppMethodBeat.i(136234);
    this.fWS.setEdgeSwipeListener(paramc);
    AppMethodBeat.o(136234);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(136236);
    ad.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
    AppMethodBeat.o(136236);
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.c paramc)
  {
    AppMethodBeat.i(136231);
    ad.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramc });
    this.fWV = paramc;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.fWS != null) {
      this.fWS.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageMatrix(Matrix paramMatrix) {}
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.fWS != null)
    {
      this.fWT = new com.tencent.mm.graphics.a.b()
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
        
        public final void m(Bitmap paramAnonymousBitmap)
        {
          AppMethodBeat.i(136224);
          WxBaseImageView.e(WxBaseImageView.this);
          if (paramb != null) {
            paramb.m(paramAnonymousBitmap);
          }
          AppMethodBeat.o(136224);
        }
        
        public final void qq()
        {
          AppMethodBeat.i(136223);
          WxBaseImageView.d(WxBaseImageView.this);
          if (paramb != null) {
            paramb.qq();
          }
          AppMethodBeat.o(136223);
        }
        
        public final void qr()
        {
          AppMethodBeat.i(136228);
          ad.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.qr();
          }
          AppMethodBeat.o(136228);
        }
      };
      this.fWS.setOnImageEventListener(this.fWT);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.fWS != null) {
      this.fWS.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.fWS != null) {
      this.fWS.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
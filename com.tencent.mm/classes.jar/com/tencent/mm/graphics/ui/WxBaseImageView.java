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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WxBaseImageView
  extends FrameLayout
{
  private long aWS;
  private boolean clB;
  private ViewStub gxN;
  private ViewStub gxO;
  private ImageView gxP;
  protected SubsamplingScaleImageView gxQ;
  private com.tencent.mm.graphics.a.b gxR;
  private a gxS;
  private com.tencent.mm.graphics.a.c gxT;
  private boolean gxU;
  private a.a gxV;
  private a.a gxW;
  private boolean gxX;
  private boolean gxY;
  private boolean gxZ;
  private boolean gya;
  private boolean gyb;
  private boolean gyc;
  private aq gyd;
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
    this.gxN = null;
    this.gxO = null;
    this.gxP = null;
    this.gxQ = null;
    this.gxR = null;
    this.gxS = null;
    this.gxT = com.tencent.mm.graphics.a.c.gxf;
    this.gxU = false;
    this.mRect = new Rect();
    this.gyb = false;
    this.gyc = false;
    this.gyd = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131495849, this, true);
    this.gxN = ((ViewStub)findViewById(2131305505));
    paramContext = this.gxN.inflate();
    if (paramContext != null)
    {
      this.gxQ = ((SubsamplingScaleImageView)paramContext);
      this.gxQ.setVisibility(0);
    }
    paramContext = com.tencent.mm.graphics.b.c.gxq;
    if (!paramContext.gxv)
    {
      paramContext.gxv = true;
      ae.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bu.fpN() });
      paramContext.aht().postFrameCallback(paramContext);
    }
    d.gxy.gxz = new WeakReference(this.mContext);
    this.gxQ.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(136221);
        d.gxy.ahv();
        WxBaseImageView.a(WxBaseImageView.this);
        AppMethodBeat.o(136221);
      }
    });
    AppMethodBeat.o(136229);
  }
  
  private void ahy()
  {
    AppMethodBeat.i(136246);
    if (!this.gxU)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.clB)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.gxX) && (!this.gxZ))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.gxY) && (!this.gya))
    {
      AppMethodBeat.o(136246);
      return;
    }
    ae.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.gxF;
    com.tencent.mm.graphics.c.a.a(this.gxW, this.gxV);
    this.clB = true;
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
  
  private void mp(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.gxQ != null) && (this.gxV != null))
      {
        this.gxV.gxI = ((int)(System.currentTimeMillis() - this.aWS));
        locala = this.gxQ.getImageDecodeRecord();
        if (locala == null) {
          break label142;
        }
      }
      label142:
      for (this.gxV.gxJ = locala.aXa;; this.gxV.gxJ = 0)
      {
        this.gxV.gxH = paramInt;
        this.gxV.orientation = this.gxQ.getPreviewOrientation();
        this.gxV.width = this.gxQ.getPreviewWidth();
        this.gxV.height = this.gxQ.getPreviewHeight();
        this.gxV.aXv = 1;
        this.gxV.fileSize = ((int)o.aZR(this.gxV.imagePath));
        AppMethodBeat.o(136244);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillPreviewInfo exception", new Object[0]);
      AppMethodBeat.o(136244);
    }
  }
  
  private void mq(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.gxQ != null) && (this.gxW != null))
      {
        this.gxW.gxI = ((int)(System.currentTimeMillis() - this.aWS));
        locala = this.gxQ.getImageDecodeRecord();
        if (locala == null) {
          break label159;
        }
        locala1 = this.gxW;
        i = locala.aXb;
      }
      label159:
      for (locala1.gxJ = (locala.aXc + i);; this.gxV.gxJ = 0)
      {
        this.gxW.gxH = paramInt;
        this.gxW.orientation = this.gxQ.getRequiredRotation();
        this.gxW.width = this.gxQ.getSWidth();
        this.gxW.height = this.gxQ.getSHeight();
        this.gxW.aXv = this.gxQ.getFullImageSampleSize();
        this.gxW.fileSize = ((int)o.aZR(this.gxW.imagePath));
        AppMethodBeat.o(136245);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ae.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillMainInfo exception", new Object[0]);
      AppMethodBeat.o(136245);
    }
  }
  
  public final void a(String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(136232);
    ae.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()) });
    if (this.gxT == com.tencent.mm.graphics.a.c.gxf)
    {
      if (this.gxQ == null)
      {
        ae.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
        AppMethodBeat.o(136232);
        return;
      }
      if (paramString == null)
      {
        ae.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
        AppMethodBeat.o(136232);
        return;
      }
      this.gxN.setVisibility(0);
      com.davemorrissey.labs.subscaleview.view.a locala = com.davemorrissey.labs.subscaleview.view.a.aP(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (locala.bitmap == null)
      {
        locala.aXg = i;
        locala.aXh = j;
      }
      if (locala.aXi != null)
      {
        locala.aXf = true;
        locala.aXg = locala.aXi.width();
        locala.aXh = locala.aXi.height();
      }
      this.aWS = System.currentTimeMillis();
      ae.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aWS) });
      this.gxW = new a.a();
      this.gxW.imageType = 22;
      this.gxW.imagePath = paramString;
      this.gxW.dFY = getActivityName();
      this.gxY = true;
      if (parama != null)
      {
        this.gxV = new a.a();
        if (parama.getUri() != null)
        {
          this.gxV.imagePath = parama.getUri().toString();
          ae.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.gxV.imagePath });
          this.gxV.imageType = 21;
          this.gxV.dFY = getActivityName();
        }
      }
      for (this.gxX = true;; this.gxX = false)
      {
        if (parama == null) {
          break label391;
        }
        this.gxQ.a(locala, parama);
        AppMethodBeat.o(136232);
        return;
        this.gxV.imagePath = "";
        break;
      }
      label391:
      this.gxQ.setImage(locala);
    }
    AppMethodBeat.o(136232);
  }
  
  public final void ahx()
  {
    AppMethodBeat.i(136242);
    if (this.gxQ != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.gxQ;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.aYW, new PointF(0.0F, 0.0F));
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
    if (this.gxQ != null)
    {
      Bitmap localBitmap = this.gxQ.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.gxQ != null)
    {
      float f = this.gxQ.getScale();
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
      this.gxU = false;
    }
    for (;;)
    {
      ahy();
      AppMethodBeat.o(136230);
      return;
      ae.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.gxU = true;
      if (this.gyc) {
        continue;
      }
      this.gyc = true;
      d locald = d.gxy;
      synchronized (locald.gxC)
      {
        if (locald.isRunning)
        {
          ae.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.gxB != null) {
          locald.gxB.cancel();
        }
        System.gc();
        locald.gxA.clear();
        if ((locald.gxz != null) && (locald.gxz.get() != null)) {
          locald.gxA.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.gxz.get()));
        }
        i locali = h.MqF;
        d.1 local1 = new d.1(locald);
        locald.gxB = local1;
        locali.s(local1, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(136235);
    ae.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(136235);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    AppMethodBeat.i(136234);
    this.gxQ.setEdgeSwipeListener(paramc);
    AppMethodBeat.o(136234);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(136236);
    ae.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
    AppMethodBeat.o(136236);
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.c paramc)
  {
    AppMethodBeat.i(136231);
    ae.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramc });
    this.gxT = paramc;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.gxQ != null) {
      this.gxQ.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageMatrix(Matrix paramMatrix) {}
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.gxQ != null)
    {
      this.gxR = new com.tencent.mm.graphics.a.b()
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
        
        public final void rY()
        {
          AppMethodBeat.i(136223);
          WxBaseImageView.d(WxBaseImageView.this);
          if (paramb != null) {
            paramb.rY();
          }
          AppMethodBeat.o(136223);
        }
        
        public final void rZ()
        {
          AppMethodBeat.i(136228);
          ae.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.rZ();
          }
          AppMethodBeat.o(136228);
        }
      };
      this.gxQ.setOnImageEventListener(this.gxR);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.gxQ != null) {
      this.gxQ.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.gxQ != null) {
      this.gxQ.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
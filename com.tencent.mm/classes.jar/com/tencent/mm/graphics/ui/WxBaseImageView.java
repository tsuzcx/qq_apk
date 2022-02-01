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
  private long aWS;
  private boolean clz;
  private ViewStub gvg;
  private ViewStub gvh;
  private ImageView gvi;
  protected SubsamplingScaleImageView gvj;
  private com.tencent.mm.graphics.a.b gvk;
  private a gvl;
  private com.tencent.mm.graphics.a.c gvm;
  private boolean gvn;
  private a.a gvo;
  private a.a gvp;
  private boolean gvq;
  private boolean gvr;
  private boolean gvs;
  private boolean gvt;
  private boolean gvu;
  private boolean gvv;
  private ap gvw;
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
    this.gvg = null;
    this.gvh = null;
    this.gvi = null;
    this.gvj = null;
    this.gvk = null;
    this.gvl = null;
    this.gvm = com.tencent.mm.graphics.a.c.guy;
    this.gvn = false;
    this.mRect = new Rect();
    this.gvu = false;
    this.gvv = false;
    this.gvw = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131495849, this, true);
    this.gvg = ((ViewStub)findViewById(2131305505));
    paramContext = this.gvg.inflate();
    if (paramContext != null)
    {
      this.gvj = ((SubsamplingScaleImageView)paramContext);
      this.gvj.setVisibility(0);
    }
    paramContext = com.tencent.mm.graphics.b.c.guJ;
    if (!paramContext.guO)
    {
      paramContext.guO = true;
      ad.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bt.flS() });
      paramContext.ahe().postFrameCallback(paramContext);
    }
    d.guR.guS = new WeakReference(this.mContext);
    this.gvj.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(136221);
        d.guR.ahg();
        WxBaseImageView.a(WxBaseImageView.this);
        AppMethodBeat.o(136221);
      }
    });
    AppMethodBeat.o(136229);
  }
  
  private void ahj()
  {
    AppMethodBeat.i(136246);
    if (!this.gvn)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.clz)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.gvq) && (!this.gvs))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.gvr) && (!this.gvt))
    {
      AppMethodBeat.o(136246);
      return;
    }
    ad.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.guY;
    com.tencent.mm.graphics.c.a.a(this.gvp, this.gvo);
    this.clz = true;
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
  
  private void mm(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.gvj != null) && (this.gvo != null))
      {
        this.gvo.gvb = ((int)(System.currentTimeMillis() - this.aWS));
        locala = this.gvj.getImageDecodeRecord();
        if (locala == null) {
          break label142;
        }
      }
      label142:
      for (this.gvo.gvc = locala.aXa;; this.gvo.gvc = 0)
      {
        this.gvo.gva = paramInt;
        this.gvo.orientation = this.gvj.getPreviewOrientation();
        this.gvo.width = this.gvj.getPreviewWidth();
        this.gvo.height = this.gvj.getPreviewHeight();
        this.gvo.aXv = 1;
        this.gvo.fileSize = ((int)com.tencent.mm.vfs.i.aYo(this.gvo.imagePath));
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
  
  private void mn(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.gvj != null) && (this.gvp != null))
      {
        this.gvp.gvb = ((int)(System.currentTimeMillis() - this.aWS));
        locala = this.gvj.getImageDecodeRecord();
        if (locala == null) {
          break label159;
        }
        locala1 = this.gvp;
        i = locala.aXb;
      }
      label159:
      for (locala1.gvc = (locala.aXc + i);; this.gvo.gvc = 0)
      {
        this.gvp.gva = paramInt;
        this.gvp.orientation = this.gvj.getRequiredRotation();
        this.gvp.width = this.gvj.getSWidth();
        this.gvp.height = this.gvj.getSHeight();
        this.gvp.aXv = this.gvj.getFullImageSampleSize();
        this.gvp.fileSize = ((int)com.tencent.mm.vfs.i.aYo(this.gvp.imagePath));
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
    if (this.gvm == com.tencent.mm.graphics.a.c.guy)
    {
      if (this.gvj == null)
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
      this.gvg.setVisibility(0);
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
      ad.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aWS) });
      this.gvp = new a.a();
      this.gvp.imageType = 22;
      this.gvp.imagePath = paramString;
      this.gvp.dET = getActivityName();
      this.gvr = true;
      if (parama != null)
      {
        this.gvo = new a.a();
        if (parama.getUri() != null)
        {
          this.gvo.imagePath = parama.getUri().toString();
          ad.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.gvo.imagePath });
          this.gvo.imageType = 21;
          this.gvo.dET = getActivityName();
        }
      }
      for (this.gvq = true;; this.gvq = false)
      {
        if (parama == null) {
          break label391;
        }
        this.gvj.a(locala, parama);
        AppMethodBeat.o(136232);
        return;
        this.gvo.imagePath = "";
        break;
      }
      label391:
      this.gvj.setImage(locala);
    }
    AppMethodBeat.o(136232);
  }
  
  public final void ahi()
  {
    AppMethodBeat.i(136242);
    if (this.gvj != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.gvj;
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
    if (this.gvj != null)
    {
      Bitmap localBitmap = this.gvj.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.gvj != null)
    {
      float f = this.gvj.getScale();
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
      this.gvn = false;
    }
    for (;;)
    {
      ahj();
      AppMethodBeat.o(136230);
      return;
      ad.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.gvn = true;
      if (this.gvv) {
        continue;
      }
      this.gvv = true;
      d locald = d.guR;
      synchronized (locald.guV)
      {
        if (locald.isRunning)
        {
          ad.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.guU != null) {
          locald.guU.cancel();
        }
        System.gc();
        locald.guT.clear();
        if ((locald.guS != null) && (locald.guS.get() != null)) {
          locald.guT.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.guS.get()));
        }
        com.tencent.e.i locali = h.LTJ;
        d.1 local1 = new d.1(locald);
        locald.guU = local1;
        locali.s(local1, 5L);
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
    this.gvj.setEdgeSwipeListener(paramc);
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
    this.gvm = paramc;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.gvj != null) {
      this.gvj.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageMatrix(Matrix paramMatrix) {}
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.gvj != null)
    {
      this.gvk = new com.tencent.mm.graphics.a.b()
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
          ad.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.rZ();
          }
          AppMethodBeat.o(136228);
        }
      };
      this.gvj.setOnImageEventListener(this.gvk);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.gvj != null) {
      this.gvj.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.gvj != null) {
      this.gvj.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
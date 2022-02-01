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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class WxBaseImageView
  extends FrameLayout
{
  private long aMB;
  private boolean cbi;
  private com.tencent.mm.graphics.a.b gbA;
  private a gbB;
  private com.tencent.mm.graphics.a.c gbC;
  private boolean gbD;
  private a.a gbE;
  private a.a gbF;
  private boolean gbG;
  private boolean gbH;
  private boolean gbI;
  private boolean gbJ;
  private boolean gbK;
  private boolean gbL;
  private ao gbM;
  private ViewStub gbw;
  private ViewStub gbx;
  private ImageView gby;
  private SubsamplingScaleImageView gbz;
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
    this.gbw = null;
    this.gbx = null;
    this.gby = null;
    this.gbz = null;
    this.gbA = null;
    this.gbB = null;
    this.gbC = com.tencent.mm.graphics.a.c.gaO;
    this.gbD = false;
    this.mRect = new Rect();
    this.gbK = false;
    this.gbL = false;
    this.gbM = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2131495849, this, true);
    this.gbw = ((ViewStub)findViewById(2131305505));
    paramContext = this.gbw.inflate();
    if (paramContext != null)
    {
      this.gbz = ((SubsamplingScaleImageView)paramContext);
      this.gbz.setVisibility(0);
    }
    paramContext = com.tencent.mm.graphics.b.c.gaZ;
    if (!paramContext.gbe)
    {
      paramContext.gbe = true;
      ac.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bs.eWi() });
      paramContext.aes().postFrameCallback(paramContext);
    }
    d.gbh.gbi = new WeakReference(this.mContext);
    this.gbz.setOnAttachStateChangeListener(new WxBaseImageView.1(this));
    AppMethodBeat.o(136229);
  }
  
  private void aex()
  {
    AppMethodBeat.i(136246);
    if (!this.gbD)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if (this.cbi)
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.gbG) && (!this.gbI))
    {
      AppMethodBeat.o(136246);
      return;
    }
    if ((this.gbH) && (!this.gbJ))
    {
      AppMethodBeat.o(136246);
      return;
    }
    ac.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.gbo;
    com.tencent.mm.graphics.c.a.a(this.gbF, this.gbE);
    this.cbi = true;
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
  
  private void lN(int paramInt)
  {
    AppMethodBeat.i(136244);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.gbz != null) && (this.gbE != null))
      {
        this.gbE.gbr = ((int)(System.currentTimeMillis() - this.aMB));
        locala = this.gbz.getImageDecodeRecord();
        if (locala == null) {
          break label142;
        }
      }
      label142:
      for (this.gbE.gbs = locala.aMJ;; this.gbE.gbs = 0)
      {
        this.gbE.gbq = paramInt;
        this.gbE.orientation = this.gbz.getPreviewOrientation();
        this.gbE.width = this.gbz.getPreviewWidth();
        this.gbE.height = this.gbz.getPreviewHeight();
        this.gbE.aNd = 1;
        this.gbE.fileSize = ((int)com.tencent.mm.vfs.i.aSp(this.gbE.imagePath));
        AppMethodBeat.o(136244);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillPreviewInfo exception", new Object[0]);
      AppMethodBeat.o(136244);
    }
  }
  
  private void lO(int paramInt)
  {
    AppMethodBeat.i(136245);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.gbz != null) && (this.gbF != null))
      {
        this.gbF.gbr = ((int)(System.currentTimeMillis() - this.aMB));
        locala = this.gbz.getImageDecodeRecord();
        if (locala == null) {
          break label159;
        }
        locala1 = this.gbF;
        i = locala.aMK;
      }
      label159:
      for (locala1.gbs = (locala.aML + i);; this.gbE.gbs = 0)
      {
        this.gbF.gbq = paramInt;
        this.gbF.orientation = this.gbz.getRequiredRotation();
        this.gbF.width = this.gbz.getSWidth();
        this.gbF.height = this.gbz.getSHeight();
        this.gbF.aNd = this.gbz.getFullImageSampleSize();
        this.gbF.fileSize = ((int)com.tencent.mm.vfs.i.aSp(this.gbF.imagePath));
        AppMethodBeat.o(136245);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ac.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillMainInfo exception", new Object[0]);
      AppMethodBeat.o(136245);
    }
  }
  
  public final void a(String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(136232);
    ac.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d, %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight), Integer.valueOf(hashCode()) });
    if (this.gbC == com.tencent.mm.graphics.a.c.gaO)
    {
      if (this.gbz == null)
      {
        ac.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
        AppMethodBeat.o(136232);
        return;
      }
      if (paramString == null)
      {
        ac.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
        AppMethodBeat.o(136232);
        return;
      }
      this.gbw.setVisibility(0);
      com.davemorrissey.labs.subscaleview.view.a locala = com.davemorrissey.labs.subscaleview.view.a.W(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (locala.bitmap == null)
      {
        locala.aMO = i;
        locala.aMP = j;
      }
      if (locala.aMQ != null)
      {
        locala.aMN = true;
        locala.aMO = locala.aMQ.width();
        locala.aMP = locala.aMQ.height();
      }
      this.aMB = System.currentTimeMillis();
      ac.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aMB) });
      this.gbF = new a.a();
      this.gbF.imageType = 22;
      this.gbF.imagePath = paramString;
      this.gbF.dsT = getActivityName();
      this.gbH = true;
      if (parama != null)
      {
        this.gbE = new a.a();
        if (parama.uri != null)
        {
          this.gbE.imagePath = parama.uri.toString();
          ac.d("MicroMsg.WxBaseImageView", "alvinluo onStartLoad previewImagePath: %s", new Object[] { this.gbE.imagePath });
          this.gbE.imageType = 21;
          this.gbE.dsT = getActivityName();
        }
      }
      for (this.gbG = true;; this.gbG = false)
      {
        if (parama == null) {
          break label391;
        }
        this.gbz.a(locala, parama);
        AppMethodBeat.o(136232);
        return;
        this.gbE.imagePath = "";
        break;
      }
      label391:
      this.gbz.setImage(locala);
    }
    AppMethodBeat.o(136232);
  }
  
  public final void aew()
  {
    AppMethodBeat.i(136242);
    if (this.gbz != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.gbz;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.aOC, new PointF(0.0F, 0.0F));
    }
    AppMethodBeat.o(136242);
  }
  
  public final void cF(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public Bitmap getFullImageBitmap()
  {
    AppMethodBeat.i(136237);
    if (this.gbz != null)
    {
      Bitmap localBitmap = this.gbz.getFullImageBitmap();
      AppMethodBeat.o(136237);
      return localBitmap;
    }
    AppMethodBeat.o(136237);
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(136241);
    if (this.gbz != null)
    {
      float f = this.gbz.getScale();
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
      this.gbD = false;
    }
    for (;;)
    {
      aex();
      AppMethodBeat.o(136230);
      return;
      ac.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.gbD = true;
      if (this.gbL) {
        continue;
      }
      this.gbL = true;
      d locald = d.gbh;
      synchronized (locald.gbl)
      {
        if (locald.isRunning)
        {
          ac.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.gbk != null) {
          locald.gbk.cancel();
        }
        System.gc();
        locald.gbj.clear();
        if ((locald.gbi != null) && (locald.gbi.get() != null)) {
          locald.gbj.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.gbi.get()));
        }
        com.tencent.e.i locali = h.JZN;
        d.1 local1 = new d.1(locald);
        locald.gbk = local1;
        locali.r(local1, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(136235);
    ac.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(136235);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    AppMethodBeat.i(136234);
    this.gbz.setEdgeSwipeListener(paramc);
    AppMethodBeat.o(136234);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(136236);
    ac.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
    AppMethodBeat.o(136236);
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.c paramc)
  {
    AppMethodBeat.i(136231);
    ac.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramc });
    this.gbC = paramc;
    AppMethodBeat.o(136231);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(136238);
    if (this.gbz != null) {
      this.gbz.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(136238);
  }
  
  public void setImageMatrix(Matrix paramMatrix) {}
  
  public void setOnImageLoadEventListener(final com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(136240);
    if (this.gbz != null)
    {
      this.gbA = new com.tencent.mm.graphics.a.b()
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
        
        public final void qA()
        {
          AppMethodBeat.i(136223);
          WxBaseImageView.d(WxBaseImageView.this);
          if (paramb != null) {
            paramb.qA();
          }
          AppMethodBeat.o(136223);
        }
        
        public final void qB()
        {
          AppMethodBeat.i(136228);
          ac.i("MicroMsg.WxBaseImageView", "alvinluo onPreviewReleased");
          if (paramb != null) {
            paramb.qB();
          }
          AppMethodBeat.o(136228);
        }
      };
      this.gbz.setOnImageEventListener(this.gbA);
    }
    AppMethodBeat.o(136240);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(136239);
    if (this.gbz != null) {
      this.gbz.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(136239);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(136233);
    if (this.gbz != null) {
      this.gbz.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(136233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
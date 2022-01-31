package com.tencent.mm.graphics.ui;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Rect;
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
import com.tencent.mm.a.e;
import com.tencent.mm.graphics.a.b;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public class WxBaseImageView
  extends FrameLayout
{
  public long aoF;
  private boolean bCk;
  public ViewStub dDJ = null;
  private ViewStub dDK = null;
  private ImageView dDL = null;
  public SubsamplingScaleImageView dDM = null;
  private com.tencent.mm.graphics.a.b dDN = null;
  private a dDO = null;
  public com.tencent.mm.graphics.a.c dDP = com.tencent.mm.graphics.a.c.dDd;
  private boolean dDQ = false;
  public com.tencent.mm.graphics.c.a.a dDR;
  public com.tencent.mm.graphics.c.a.a dDS;
  public boolean dDT;
  public boolean dDU;
  private boolean dDV;
  private boolean dDW;
  private boolean dDX = false;
  private boolean dDY = false;
  private ai dDZ = null;
  public int imageHeight;
  public int imageWidth;
  private Context mContext;
  private Rect mRect = new Rect();
  
  public WxBaseImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WxBaseImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(a.b.view_mm_image_view, this, true);
    this.dDJ = ((ViewStub)findViewById(com.tencent.mm.graphics.a.a.stub_tile));
    paramContext = this.dDJ.inflate();
    if (paramContext != null)
    {
      this.dDM = ((SubsamplingScaleImageView)paramContext);
      this.dDM.setVisibility(0);
    }
    paramContext = com.tencent.mm.graphics.b.c.dDo;
    if (!paramContext.dDs)
    {
      paramContext.dDs = true;
      paramContext.aUi.postFrameCallback(paramContext);
    }
    d.dDu.dDv = new WeakReference(this.mContext);
    this.dDM.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        d.dDu.BM();
        WxBaseImageView.a(WxBaseImageView.this);
      }
    });
  }
  
  private void BN()
  {
    if (!this.dDQ) {}
    while ((this.bCk) || ((this.dDT) && (!this.dDV)) || ((this.dDU) && (!this.dDW))) {
      return;
    }
    y.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    Object localObject = com.tencent.mm.graphics.c.a.dDA;
    localObject = this.dDS;
    com.tencent.mm.graphics.c.a.a locala = this.dDR;
    long l = System.currentTimeMillis();
    if (localObject != null) {
      com.tencent.mm.graphics.c.a.a(l, (com.tencent.mm.graphics.c.a.a)localObject);
    }
    if (locala != null) {
      com.tencent.mm.graphics.c.a.a(l, locala);
    }
    this.bCk = true;
  }
  
  private void gX(int paramInt)
  {
    try
    {
      if ((this.dDM != null) && (this.dDR != null))
      {
        this.dDR.dDE = ((int)(System.currentTimeMillis() - this.aoF));
        com.davemorrissey.labs.subscaleview.d.a locala = this.dDM.getImageDecodeRecord();
        if (locala != null) {}
        for (this.dDR.dDF = locala.aoO;; this.dDR.dDF = 0)
        {
          this.dDR.dDD = paramInt;
          this.dDR.orientation = this.dDM.getPreviewOrientation();
          this.dDR.width = this.dDM.getPreviewWidth();
          this.dDR.height = this.dDM.getPreviewHeight();
          this.dDR.api = 1;
          this.dDR.fileSize = e.bJ(this.dDR.imagePath);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillPreviewInfo exception", new Object[0]);
    }
  }
  
  private void gY(int paramInt)
  {
    try
    {
      if ((this.dDM != null) && (this.dDS != null))
      {
        this.dDS.dDE = ((int)(System.currentTimeMillis() - this.aoF));
        com.davemorrissey.labs.subscaleview.d.a locala = this.dDM.getImageDecodeRecord();
        com.tencent.mm.graphics.c.a.a locala1;
        int i;
        if (locala != null)
        {
          locala1 = this.dDS;
          i = locala.aoP;
        }
        for (locala1.dDF = (locala.aoQ + i);; this.dDR.dDF = 0)
        {
          this.dDS.dDD = paramInt;
          this.dDS.orientation = this.dDM.getRequiredRotation();
          this.dDS.width = this.dDM.getSWidth();
          this.dDS.height = this.dDM.getSHeight();
          this.dDS.api = this.dDM.getFullImageSampleSize();
          this.dDS.fileSize = e.bJ(this.dDS.imagePath);
          return;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      y.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillMainInfo exception", new Object[0]);
    }
  }
  
  public String getActivityName()
  {
    if ((this.mContext != null) && ((this.mContext instanceof Activity))) {
      return ((Activity)this.mContext).getClass().getSimpleName();
    }
    return "Default";
  }
  
  public Bitmap getFullImageBitmap()
  {
    if (this.dDM != null) {
      return this.dDM.getFullImageBitmap();
    }
    return null;
  }
  
  public float getScale()
  {
    if (this.dDM != null) {
      return this.dDM.getScale();
    }
    return 1.0F;
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.mRect.left = getLeft();
    this.mRect.right = getRight();
    this.mRect.top = getTop();
    this.mRect.bottom = getBottom();
    if (!getGlobalVisibleRect(this.mRect)) {
      this.dDQ = false;
    }
    for (;;)
    {
      BN();
      return;
      y.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.dDQ = true;
      if (this.dDY) {
        continue;
      }
      this.dDY = true;
      d locald = d.dDu;
      synchronized (locald.dDx)
      {
        if (locald.isRunning)
        {
          y.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.mTimer != null) {
          locald.mTimer.cancel();
        }
        System.gc();
        locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
        locald.dDw.clear();
        if ((locald.dDv != null) && (locald.dDv.get() != null)) {
          locald.dDw.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.dDv.get()));
        }
        locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    y.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    this.dDM.setEdgeSwipeListener(paramc);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    y.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.c paramc)
  {
    y.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramc });
    this.dDP = paramc;
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    if (this.dDM != null) {
      this.dDM.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
  }
  
  public void setImageMatrix(Matrix paramMatrix) {}
  
  public void setOnImageLoadEventListener(com.tencent.mm.graphics.a.b paramb)
  {
    if (this.dDM != null)
    {
      this.dDN = new WxBaseImageView.3(this, paramb);
      this.dDM.setOnImageEventListener(this.dDN);
    }
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    if (this.dDM != null) {
      this.dDM.setOnLongClickListener(paramOnLongClickListener);
    }
  }
  
  public void setScaleRate(float paramFloat)
  {
    if (this.dDM != null) {
      this.dDM.setScaleRate(paramFloat);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
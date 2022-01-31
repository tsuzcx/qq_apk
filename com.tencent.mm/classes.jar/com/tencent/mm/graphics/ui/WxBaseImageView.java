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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.e;
import com.tencent.mm.graphics.b.d;
import com.tencent.mm.graphics.b.d.1;
import com.tencent.mm.graphics.c.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Timer;

public class WxBaseImageView
  extends FrameLayout
{
  private long aqZ;
  private boolean bCp;
  private al eBA;
  private ViewStub eBk;
  private ViewStub eBl;
  private ImageView eBm;
  private SubsamplingScaleImageView eBn;
  private com.tencent.mm.graphics.a.b eBo;
  private a eBp;
  private com.tencent.mm.graphics.a.c eBq;
  private boolean eBr;
  private a.a eBs;
  private a.a eBt;
  private boolean eBu;
  private boolean eBv;
  private boolean eBw;
  private boolean eBx;
  private boolean eBy;
  private boolean eBz;
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
    AppMethodBeat.i(57110);
    this.eBk = null;
    this.eBl = null;
    this.eBm = null;
    this.eBn = null;
    this.eBo = null;
    this.eBp = null;
    this.eBq = com.tencent.mm.graphics.a.c.eAE;
    this.eBr = false;
    this.mRect = new Rect();
    this.eBy = false;
    this.eBz = false;
    this.eBA = null;
    this.mContext = paramContext;
    LayoutInflater.from(getContext()).inflate(2130971083, this, true);
    this.eBk = ((ViewStub)findViewById(2131828743));
    paramContext = this.eBk.inflate();
    if (paramContext != null)
    {
      this.eBn = ((SubsamplingScaleImageView)paramContext);
      this.eBn.setVisibility(0);
    }
    paramContext = com.tencent.mm.graphics.b.c.eAP;
    if (!paramContext.eAT)
    {
      paramContext.eAT = true;
      ab.i("MicroMsg.Metronome", "[start] stack:%s", new Object[] { bo.dtY() });
      paramContext.choreographer.postFrameCallback(paramContext);
    }
    d.eAV.eAW = new WeakReference(this.mContext);
    this.eBn.setOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
    {
      public final void onViewAttachedToWindow(View paramAnonymousView) {}
      
      public final void onViewDetachedFromWindow(View paramAnonymousView)
      {
        AppMethodBeat.i(57102);
        d.eAV.Py();
        WxBaseImageView.a(WxBaseImageView.this);
        AppMethodBeat.o(57102);
      }
    });
    AppMethodBeat.o(57110);
  }
  
  private void PA()
  {
    AppMethodBeat.i(57127);
    if (!this.eBr)
    {
      AppMethodBeat.o(57127);
      return;
    }
    if (this.bCp)
    {
      AppMethodBeat.o(57127);
      return;
    }
    if ((this.eBu) && (!this.eBw))
    {
      AppMethodBeat.o(57127);
      return;
    }
    if ((this.eBv) && (!this.eBx))
    {
      AppMethodBeat.o(57127);
      return;
    }
    ab.i("MicroMsg.WxBaseImageView", "alvinluo reportImageInfo info ready and report");
    com.tencent.mm.graphics.c.a locala = com.tencent.mm.graphics.c.a.eBb;
    com.tencent.mm.graphics.c.a.a(this.eBt, this.eBs);
    this.bCp = true;
    AppMethodBeat.o(57127);
  }
  
  private String getActivityName()
  {
    AppMethodBeat.i(57124);
    if ((this.mContext != null) && ((this.mContext instanceof Activity)))
    {
      String str = ((Activity)this.mContext).getClass().getSimpleName();
      AppMethodBeat.o(57124);
      return str;
    }
    AppMethodBeat.o(57124);
    return "Default";
  }
  
  private void jm(int paramInt)
  {
    AppMethodBeat.i(57125);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      if ((this.eBn != null) && (this.eBs != null))
      {
        this.eBs.eBf = ((int)(System.currentTimeMillis() - this.aqZ));
        locala = this.eBn.getImageDecodeRecord();
        if (locala == null) {
          break label141;
        }
      }
      label141:
      for (this.eBs.eBg = locala.ari;; this.eBs.eBg = 0)
      {
        this.eBs.eBe = paramInt;
        this.eBs.orientation = this.eBn.getPreviewOrientation();
        this.eBs.width = this.eBn.getPreviewWidth();
        this.eBs.height = this.eBn.getPreviewHeight();
        this.eBs.arC = 1;
        this.eBs.fileSize = e.cM(this.eBs.imagePath);
        AppMethodBeat.o(57125);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillPreviewInfo exception", new Object[0]);
      AppMethodBeat.o(57125);
    }
  }
  
  private void jn(int paramInt)
  {
    AppMethodBeat.i(57126);
    try
    {
      com.davemorrissey.labs.subscaleview.d.a locala;
      a.a locala1;
      int i;
      if ((this.eBn != null) && (this.eBt != null))
      {
        this.eBt.eBf = ((int)(System.currentTimeMillis() - this.aqZ));
        locala = this.eBn.getImageDecodeRecord();
        if (locala == null) {
          break label158;
        }
        locala1 = this.eBt;
        i = locala.arj;
      }
      label158:
      for (locala1.eBg = (locala.ark + i);; this.eBs.eBg = 0)
      {
        this.eBt.eBe = paramInt;
        this.eBt.orientation = this.eBn.getRequiredRotation();
        this.eBt.width = this.eBn.getSWidth();
        this.eBt.height = this.eBn.getSHeight();
        this.eBt.arC = this.eBn.getFullImageSampleSize();
        this.eBt.fileSize = e.cM(this.eBt.imagePath);
        AppMethodBeat.o(57126);
        return;
      }
      return;
    }
    catch (Exception localException)
    {
      ab.printErrStackTrace("MicroMsg.WxBaseImageView", localException, "alvinluo fillMainInfo exception", new Object[0]);
      AppMethodBeat.o(57126);
    }
  }
  
  public final void Pz()
  {
    AppMethodBeat.i(57123);
    if (this.eBn != null)
    {
      SubsamplingScaleImageView localSubsamplingScaleImageView = this.eBn;
      localSubsamplingScaleImageView.a(localSubsamplingScaleImageView.atc, new PointF(0.0F, 0.0F));
    }
    AppMethodBeat.o(57123);
  }
  
  public final void a(String paramString, com.davemorrissey.labs.subscaleview.view.a parama)
  {
    AppMethodBeat.i(57113);
    ab.d("MicroMsg.WxBaseImageView", "alvinluo: loading from local file: %s, width: %d, height: %d", new Object[] { paramString, Integer.valueOf(this.imageWidth), Integer.valueOf(this.imageHeight) });
    if (this.eBq == com.tencent.mm.graphics.a.c.eAE)
    {
      if (this.eBn == null)
      {
        ab.e("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView laodFile mTileIv is null");
        AppMethodBeat.o(57113);
        return;
      }
      if (paramString == null)
      {
        ab.i("MicroMsg.WxBaseImageView", "alvinluo WxBaseImageView loadFile path is null");
        AppMethodBeat.o(57113);
        return;
      }
      this.eBk.setVisibility(0);
      com.davemorrissey.labs.subscaleview.view.a locala = com.davemorrissey.labs.subscaleview.view.a.Y(paramString);
      int i = this.imageWidth;
      int j = this.imageHeight;
      if (locala.bitmap == null)
      {
        locala.arn = i;
        locala.aro = j;
      }
      if (locala.arp != null)
      {
        locala.arm = true;
        locala.arn = locala.arp.width();
        locala.aro = locala.arp.height();
      }
      this.aqZ = System.currentTimeMillis();
      ab.i("MicroMsg.WxBaseImageView", "alvinluo onStartLoad imagePath: %s, mStartLoadTime: %d", new Object[] { paramString, Long.valueOf(this.aqZ) });
      this.eBt = new a.a();
      this.eBt.eBd = 22;
      this.eBt.imagePath = paramString;
      this.eBt.cEG = getActivityName();
      this.eBv = true;
      if (parama != null)
      {
        this.eBs = new a.a();
        if (parama.uri != null)
        {
          this.eBs.imagePath = parama.uri.toString();
          this.eBs.eBd = 21;
          this.eBs.cEG = getActivityName();
        }
      }
      for (this.eBu = true;; this.eBu = false)
      {
        if (parama == null) {
          break label359;
        }
        this.eBn.a(locala, parama);
        AppMethodBeat.o(57113);
        return;
        this.eBs.imagePath = "";
        break;
      }
      label359:
      this.eBn.setImage(locala);
    }
    AppMethodBeat.o(57113);
  }
  
  public final void cb(int paramInt1, int paramInt2)
  {
    this.imageWidth = paramInt1;
    this.imageHeight = paramInt2;
  }
  
  public Bitmap getFullImageBitmap()
  {
    AppMethodBeat.i(57118);
    if (this.eBn != null)
    {
      Bitmap localBitmap = this.eBn.getFullImageBitmap();
      AppMethodBeat.o(57118);
      return localBitmap;
    }
    AppMethodBeat.o(57118);
    return null;
  }
  
  public float getScale()
  {
    AppMethodBeat.i(57122);
    if (this.eBn != null)
    {
      float f = this.eBn.getScale();
      AppMethodBeat.o(57122);
      return f;
    }
    AppMethodBeat.o(57122);
    return 1.0F;
  }
  
  public boolean hasOverlappingRendering()
  {
    return false;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(57111);
    super.onMeasure(paramInt1, paramInt2);
    this.mRect.left = getLeft();
    this.mRect.right = getRight();
    this.mRect.top = getTop();
    this.mRect.bottom = getBottom();
    if (!getGlobalVisibleRect(this.mRect)) {
      this.eBr = false;
    }
    for (;;)
    {
      PA();
      AppMethodBeat.o(57111);
      return;
      ab.d("MicroMsg.WxBaseImageView", "alvinluo ImageView visible, can report");
      this.eBr = true;
      if (this.eBz) {
        continue;
      }
      this.eBz = true;
      d locald = d.eAV;
      synchronized (locald.eAY)
      {
        if (locald.isRunning)
        {
          ab.w("MicroMsg.PerformanceMonitor", "hy: already running. stop last and run new");
          locald.isRunning = false;
        }
        if (locald.mTimer != null) {
          locald.mTimer.cancel();
        }
        System.gc();
        locald.mTimer = new Timer("Handle_Monitor_mem_cpu", true);
        locald.eAX.clear();
        if ((locald.eAW != null) && (locald.eAW.get() != null)) {
          locald.eAX.put(Integer.valueOf(2), new com.tencent.mm.graphics.b.b((Context)locald.eAW.get()));
        }
        locald.mTimer.scheduleAtFixedRate(new d.1(locald), 0L, 5L);
        locald.isRunning = true;
      }
    }
  }
  
  public void setAnimateMode(com.tencent.mm.graphics.a.a parama)
  {
    AppMethodBeat.i(57116);
    ab.d("MicroMsg.WxBaseImageView", "hy: set current animation mode: %s", new Object[] { parama });
    AppMethodBeat.o(57116);
  }
  
  public void setEdgeSwipeListener(SubsamplingScaleImageView.c paramc)
  {
    AppMethodBeat.i(57115);
    this.eBn.setEdgeSwipeListener(paramc);
    AppMethodBeat.o(57115);
  }
  
  public void setFitType(ImageView.ScaleType paramScaleType)
  {
    AppMethodBeat.i(57117);
    ab.d("MicroMsg.WxBaseImageView", "hy: set fit type: %s", new Object[] { paramScaleType });
    AppMethodBeat.o(57117);
  }
  
  public void setForceTileFlag(com.tencent.mm.graphics.a.c paramc)
  {
    AppMethodBeat.i(57112);
    ab.d("MicroMsg.WxBaseImageView", "hy: setting force tile flag; %s", new Object[] { paramc });
    this.eBq = paramc;
    AppMethodBeat.o(57112);
  }
  
  public void setGestureDetectorListener(GestureDetector.SimpleOnGestureListener paramSimpleOnGestureListener)
  {
    AppMethodBeat.i(57119);
    if (this.eBn != null) {
      this.eBn.setGestureDetectorListener(paramSimpleOnGestureListener);
    }
    AppMethodBeat.o(57119);
  }
  
  public void setImageMatrix(Matrix paramMatrix) {}
  
  public void setOnImageLoadEventListener(com.tencent.mm.graphics.a.b paramb)
  {
    AppMethodBeat.i(57121);
    if (this.eBn != null)
    {
      this.eBo = new WxBaseImageView.3(this, paramb);
      this.eBn.setOnImageEventListener(this.eBo);
    }
    AppMethodBeat.o(57121);
  }
  
  public void setOnLongClickListener(View.OnLongClickListener paramOnLongClickListener)
  {
    AppMethodBeat.i(57120);
    if (this.eBn != null) {
      this.eBn.setOnLongClickListener(paramOnLongClickListener);
    }
    AppMethodBeat.o(57120);
  }
  
  public void setScaleRate(float paramFloat)
  {
    AppMethodBeat.i(57114);
    if (this.eBn != null) {
      this.eBn.setScaleRate(paramFloat);
    }
    AppMethodBeat.o(57114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.graphics.ui.WxBaseImageView
 * JD-Core Version:    0.7.0.1
 */
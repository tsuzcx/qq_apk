package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int arE;
  private int arF;
  private float cHW;
  private int count;
  private int kvn;
  private int kvo;
  private boolean rMA;
  private boolean rMB;
  private boolean rMC;
  private boolean rMD;
  private j rME;
  private j rMF;
  private j rMG;
  private d rMH;
  private b rMI;
  private MultiTouchImageView rMo;
  private long rMp;
  private long rMq;
  private float rMr;
  private float rMs;
  private long rMt;
  private boolean rMu;
  private OverScroller rMv;
  private GestureDetector rMw;
  private RectF rMx;
  private a rMy;
  private float rMz;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.rMp = 0L;
    this.rMq = 0L;
    this.rMr = 0.0F;
    this.rMs = 0.0F;
    this.rMt = 0L;
    this.rMu = false;
    this.rMx = new RectF();
    this.rMA = false;
    this.rMB = false;
    this.rMC = false;
    this.rMD = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.rMp = 0L;
    this.rMq = 0L;
    this.rMr = 0.0F;
    this.rMs = 0.0F;
    this.rMt = 0L;
    this.rMu = false;
    this.rMx = new RectF();
    this.rMA = false;
    this.rMB = false;
    this.rMC = false;
    this.rMD = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void cAV()
  {
    AppMethodBeat.i(111774);
    this.rME.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void cAW()
  {
    AppMethodBeat.i(111775);
    cAV();
    this.rME.j(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.rMo = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.rMw = new GestureDetector(paramContext, new c((byte)0));
    this.rMv = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.rMo.setLayoutParams(paramContext);
    addView(this.rMo);
    this.rME = new j(new WeakReference(this));
    this.rMF = new j(new WeakReference(this));
    this.rMG = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.rMo == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.rMv.computeScrollOffset())
    {
      i = this.rMv.getCurrX() - this.arE;
      int n = this.rMv.getCurrY() - this.arF;
      this.arE = this.rMv.getCurrX();
      this.arF = this.rMv.getCurrY();
      float f3 = this.rMo.getScale();
      f4 = this.rMo.getImageWidth();
      float f1 = f3 * this.rMo.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.rMo.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.rMx.right - Math.round(f3)) {
          j = (int)(this.rMx.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.rMx.left - Math.round(f2)) {
          i = (int)(this.rMx.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.rMx.bottom - Math.round(f5)) {
          k = (int)(this.rMx.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.rMx.top - Math.round(f4)) {
          j = (int)(this.rMx.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.rMx.left) && (Math.round(f3) > this.rMx.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.kvo) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.rMo.ag(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.rMx.top)
      {
        k = i;
        if (Math.round(f5) > this.rMx.bottom) {
          break;
        }
      }
      j = 0;
      k = i;
      break;
    }
  }
  
  public int getImageHeight()
  {
    AppMethodBeat.i(111779);
    int i = this.rMo.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.rMo.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.kvn = View.MeasureSpec.getSize(paramInt1);
    this.kvo = View.MeasureSpec.getSize(paramInt2);
    this.rMx.set(0.0F, 0.0F, this.kvn, this.kvo);
    ad.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.kvn + " height:" + this.kvo);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    this.rMw.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.rMv.forceFinished(true);
      this.rMG.removeMessages(2);
      this.rMG.j(2, 500L, 0L);
      this.rMo.eSB();
      this.count += 1;
      if (this.count == 1)
      {
        this.rMp = System.currentTimeMillis();
        this.rMr = f.d(paramMotionEvent, 0);
        this.rMs = f.e(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.rMG.removeMessages(2);
        this.cHW = 0.0F;
        this.rMz = this.rMo.getScale();
        this.rMu = true;
        float f4;
        if (this.rMz < this.rMo.getScaleRate())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.rMo.ae(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
        if (this.rMz > this.rMo.getDoubleTabScale())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.rMo.af(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.rMG.removeMessages(2);
        if (((!this.rMC) && (!this.rMD)) || ((!this.rMA) && (!this.rMB))) {
          break label777;
        }
        this.rMy = new f(this.rMo);
        cAW();
        this.rMC = false;
        this.rMD = false;
        this.rMA = false;
        this.rMB = false;
        label368:
        this.cHW = 0.0F;
        this.rMz = this.rMo.getScale();
        if (this.count == 1)
        {
          this.rMq = System.currentTimeMillis();
          if (this.rMq - this.rMp >= 350L) {
            break label908;
          }
          if ((Math.abs(this.rMr - f.d(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.rMs - f.e(paramMotionEvent, 0)) < 10.0F))
          {
            j localj = this.rMF;
            localj.dAD = false;
            localj.j(0, 350L, 0L);
          }
        }
      }
      label477:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.cHW = 0.0F;
        this.rMz = this.rMo.getScale();
        this.rMu = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.ab(paramMotionEvent) != 2) {
          break label979;
        }
        this.rMG.removeMessages(2);
        this.rMu = true;
        this.count = 0;
        f1 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
        f2 = f.e(paramMotionEvent, 0) - f.e(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.cHW != 0.0F) {
          break label925;
        }
        this.cHW = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.rMt = System.currentTimeMillis();
      if (this.rMt - this.rMq < 350L)
      {
        if ((Math.abs(this.rMr - f.d(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.rMs - f.e(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          ad.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.rMo.getScale() <= this.rMo.getScaleRate())
          {
            this.rMo.af(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
            break;
          }
          this.rMo.ae(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
          this.rMo.eSA();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label777:
      if (this.rMC)
      {
        this.rMC = false;
        this.rMy = new g(this.rMo);
        cAW();
      }
      if (this.rMD)
      {
        this.rMD = false;
        this.rMy = new h(this.rMo);
        cAW();
      }
      if (this.rMA)
      {
        this.rMA = false;
        this.rMy = new i(this.rMo);
        cAW();
      }
      if (!this.rMB) {
        break label368;
      }
      this.rMB = false;
      this.rMy = new e(this.rMo);
      cAW();
      break label368;
      label908:
      this.count = 0;
      ad.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label477;
      label925:
      f3 /= this.cHW;
      if (this.rMu)
      {
        this.rMo.m(f3 * this.rMz, f1 + f.d(paramMotionEvent, 1), f2 + f.e(paramMotionEvent, 1));
        this.rMo.eSA();
        continue;
        label979:
        if ((Math.abs(this.rMr - f.d(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.rMs - f.e(paramMotionEvent, 0)) > 10.0F))
        {
          this.rMG.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.rMo.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.rMo.setImageBitmap(paramBitmap);
    this.rMo.eSz();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.rMo.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.rMo.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.rMI = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.rMH = paramd;
  }
  
  abstract class a
  {
    protected boolean cHI = false;
    
    public a() {}
    
    public final boolean cAX()
    {
      return this.cHI;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b {}
  
  final class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private c() {}
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      return true;
    }
  }
  
  public static abstract interface d {}
  
  final class e
    extends MultiGestureImageView.a
  {
    MultiTouchImageView jPH;
    float[] rMK;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.rMK = new float[9];
      this.jPH = paramMultiTouchImageView;
      AppMethodBeat.o(111750);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111751);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111749);
          MultiGestureImageView.e.this.jPH.getImageMatrix().getValues(MultiGestureImageView.e.this.rMK);
          float f1 = MultiGestureImageView.e.this.jPH.getScale();
          float f2 = MultiGestureImageView.e.this.jPH.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.rMK[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.cHI = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.jPH.ag(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.cHI = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(111751);
    }
  }
  
  final class f
    extends MultiGestureImageView.a
  {
    MultiTouchImageView jPH;
    float[] rMK;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.rMK = new float[9];
      this.jPH = paramMultiTouchImageView;
      AppMethodBeat.o(111753);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111754);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111752);
          MultiGestureImageView.f.this.jPH.getImageMatrix().getValues(MultiGestureImageView.f.this.rMK);
          float f5 = MultiGestureImageView.f.this.jPH.getScale() * MultiGestureImageView.f.this.jPH.getImageWidth();
          float f1 = MultiGestureImageView.f.this.jPH.getScale();
          float f8 = MultiGestureImageView.f.this.jPH.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.rMK[2];
          float f10 = MultiGestureImageView.f.this.rMK[5];
          float f6 = MultiGestureImageView.f.this.rMK[2];
          float f9 = MultiGestureImageView.f.this.rMK[5];
          float f2 = 0.0F;
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          float f3 = 0.0F;
          float f4 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f8 < MultiGestureImageView.i(MultiGestureImageView.this))
          {
            f2 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f8 / 2.0F;
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f8 / 2.0F;
          }
          for (;;)
          {
            f2 -= f10;
            f1 -= f9 + f8;
            if (f2 < 0.0F) {
              f1 = f2;
            }
            for (;;)
            {
              if (f5 < MultiGestureImageView.g(MultiGestureImageView.this))
              {
                f3 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F;
                f4 = f5 / 2.0F;
                f2 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f5 / 2.0F;
                f3 -= f4;
              }
              for (;;)
              {
                f3 -= f7;
                f2 -= f6 + f5;
                if (f3 < 0.0F) {
                  f2 = f3;
                }
                for (;;)
                {
                  label306:
                  if ((Math.abs(f2) <= 5.0F) && (Math.abs(f1) <= 5.0F)) {
                    MultiGestureImageView.f.this.cHI = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.jPH.ag(f2, f1);
                    AppMethodBeat.o(111752);
                    return;
                    if (f1 <= 0.0F) {
                      break label508;
                    }
                    break;
                    if (f2 <= 0.0F) {
                      break label497;
                    }
                    break label306;
                    if (f2 >= 0.0F) {}
                    for (f2 = (float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F;; f2 = -(float)(Math.abs(f2) - Math.pow(Math.sqrt(Math.abs(f2)) - 1.0D, 2.0D)) * 2.0F)
                    {
                      if (f1 < 0.0F) {
                        break label467;
                      }
                      f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                      break;
                    }
                    label467:
                    f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
                  }
                  label497:
                  f2 = 0.0F;
                }
                f2 = f4;
              }
              label508:
              f1 = 0.0F;
            }
          }
        }
      });
      AppMethodBeat.o(111754);
    }
  }
  
  final class g
    extends MultiGestureImageView.a
  {
    MultiTouchImageView jPH;
    float[] rMK;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.rMK = new float[9];
      this.jPH = paramMultiTouchImageView;
      AppMethodBeat.o(111756);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111757);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111755);
          MultiGestureImageView.g.this.jPH.getImageMatrix().getValues(MultiGestureImageView.g.this.rMK);
          float f2 = MultiGestureImageView.g.this.rMK[2];
          float f1 = MultiGestureImageView.g.this.jPH.getScale() * MultiGestureImageView.g.this.jPH.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.cHI = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.jPH.ag(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.cHI = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(111757);
    }
  }
  
  final class h
    extends MultiGestureImageView.a
  {
    MultiTouchImageView jPH;
    float[] rMK;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.rMK = new float[9];
      this.jPH = paramMultiTouchImageView;
      AppMethodBeat.o(111759);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111760);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111758);
          MultiGestureImageView.h.this.jPH.getImageMatrix().getValues(MultiGestureImageView.h.this.rMK);
          float f1 = MultiGestureImageView.h.this.jPH.getScale();
          float f2 = MultiGestureImageView.h.this.jPH.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.rMK[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.cHI = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.jPH.ag(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.cHI = true;
            } else {
              f1 = (float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
            }
          }
        }
      });
      AppMethodBeat.o(111760);
    }
  }
  
  final class i
    extends MultiGestureImageView.a
  {
    MultiTouchImageView jPH;
    float[] rMK;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.rMK = new float[9];
      this.jPH = paramMultiTouchImageView;
      AppMethodBeat.o(111762);
    }
    
    public final void play()
    {
      AppMethodBeat.i(111763);
      MultiGestureImageView.h(MultiGestureImageView.this).getHandler().post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(111761);
          MultiGestureImageView.i.this.jPH.getImageMatrix().getValues(MultiGestureImageView.i.this.rMK);
          float f2 = MultiGestureImageView.i.this.rMK[5];
          float f1 = MultiGestureImageView.i.this.jPH.getScale() * MultiGestureImageView.i.this.jPH.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.cHI = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.jPH.ag(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.cHI = true;
              } else {
                f1 = -(float)(Math.abs(f1) - Math.pow(Math.sqrt(Math.abs(f1)) - 1.0D, 2.0D)) * 2.0F;
              }
            }
          }
        }
      });
      AppMethodBeat.o(111763);
    }
  }
  
  public final class j
    extends ap
  {
    boolean dAD;
    WeakReference<MultiGestureImageView> lo;
    private long rMQ;
    
    public j()
    {
      Object localObject;
      this.lo = localObject;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(111766);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.lo != null)
      {
        final MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.lo.get();
        if (localMultiGestureImageView != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.dAD))
            {
              ad.d("MicroMsg.MultiGestureImageView", "single click over!");
              if (MultiGestureImageView.b(localMultiGestureImageView) != null) {
                localMultiGestureImageView.getHandler().post(new Runnable()
                {
                  public final void run()
                  {
                    AppMethodBeat.i(111764);
                    MultiGestureImageView.b(localMultiGestureImageView);
                    AppMethodBeat.o(111764);
                  }
                });
              }
            }
            MultiGestureImageView.c(MultiGestureImageView.this);
            AppMethodBeat.o(111766);
            return;
          }
          if (paramMessage.what == 1)
          {
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).cAX()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.rMQ);
              AppMethodBeat.o(111766);
              return;
            }
            MultiGestureImageView.e(localMultiGestureImageView);
            AppMethodBeat.o(111766);
            return;
          }
          removeMessages(2);
          if (MultiGestureImageView.f(localMultiGestureImageView) != null) {
            localMultiGestureImageView.getHandler().post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(111765);
                MultiGestureImageView.f(localMultiGestureImageView);
                AppMethodBeat.o(111765);
              }
            });
          }
        }
      }
      AppMethodBeat.o(111766);
    }
    
    public final void j(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111767);
      this.rMQ = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */
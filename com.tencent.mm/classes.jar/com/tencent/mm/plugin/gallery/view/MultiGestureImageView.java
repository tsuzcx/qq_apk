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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int asA;
  private int asz;
  private float cFd;
  private int count;
  private int kWB;
  private int kWC;
  private MultiTouchImageView sUd;
  private long sUe;
  private long sUf;
  private float sUg;
  private float sUh;
  private long sUi;
  private boolean sUj;
  private OverScroller sUk;
  private GestureDetector sUl;
  private RectF sUm;
  private a sUn;
  private float sUo;
  private boolean sUp;
  private boolean sUq;
  private boolean sUr;
  private boolean sUs;
  private j sUt;
  private j sUu;
  private j sUv;
  private d sUw;
  private b sUx;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.sUe = 0L;
    this.sUf = 0L;
    this.sUg = 0.0F;
    this.sUh = 0.0F;
    this.sUi = 0L;
    this.sUj = false;
    this.sUm = new RectF();
    this.sUp = false;
    this.sUq = false;
    this.sUr = false;
    this.sUs = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.sUe = 0L;
    this.sUf = 0L;
    this.sUg = 0.0F;
    this.sUh = 0.0F;
    this.sUi = 0L;
    this.sUj = false;
    this.sUm = new RectF();
    this.sUp = false;
    this.sUq = false;
    this.sUr = false;
    this.sUs = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void cOe()
  {
    AppMethodBeat.i(111774);
    this.sUt.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void cOf()
  {
    AppMethodBeat.i(111775);
    cOe();
    this.sUt.j(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.sUd = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.sUl = new GestureDetector(paramContext, new c((byte)0));
    this.sUk = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.sUd.setLayoutParams(paramContext);
    addView(this.sUd);
    this.sUt = new j(new WeakReference(this));
    this.sUu = new j(new WeakReference(this));
    this.sUv = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.sUd == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.sUk.computeScrollOffset())
    {
      i = this.sUk.getCurrX() - this.asz;
      int n = this.sUk.getCurrY() - this.asA;
      this.asz = this.sUk.getCurrX();
      this.asA = this.sUk.getCurrY();
      float f3 = this.sUd.getScale();
      f4 = this.sUd.getImageWidth();
      float f1 = f3 * this.sUd.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.sUd.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.sUm.right - Math.round(f3)) {
          j = (int)(this.sUm.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.sUm.left - Math.round(f2)) {
          i = (int)(this.sUm.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.sUm.bottom - Math.round(f5)) {
          k = (int)(this.sUm.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.sUm.top - Math.round(f4)) {
          j = (int)(this.sUm.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.sUm.left) && (Math.round(f3) > this.sUm.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.kWC) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.sUd.ak(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.sUm.top)
      {
        k = i;
        if (Math.round(f5) > this.sUm.bottom) {
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
    int i = this.sUd.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.sUd.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.kWB = View.MeasureSpec.getSize(paramInt1);
    this.kWC = View.MeasureSpec.getSize(paramInt2);
    this.sUm.set(0.0F, 0.0F, this.kWB, this.kWC);
    ac.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.kWB + " height:" + this.kWC);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    this.sUl.onTouchEvent(paramMotionEvent);
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.sUk.forceFinished(true);
      this.sUv.removeMessages(2);
      this.sUv.j(2, 500L, 0L);
      this.sUd.fil();
      this.count += 1;
      if (this.count == 1)
      {
        this.sUe = System.currentTimeMillis();
        this.sUg = f.d(paramMotionEvent, 0);
        this.sUh = f.e(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.sUv.removeMessages(2);
        this.cFd = 0.0F;
        this.sUo = this.sUd.getScale();
        this.sUj = true;
        float f4;
        if (this.sUo < this.sUd.getScaleRate())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.sUd.ai(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
        if (this.sUo > this.sUd.getDoubleTabScale())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.sUd.aj(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.sUv.removeMessages(2);
        if (((!this.sUr) && (!this.sUs)) || ((!this.sUp) && (!this.sUq))) {
          break label777;
        }
        this.sUn = new f(this.sUd);
        cOf();
        this.sUr = false;
        this.sUs = false;
        this.sUp = false;
        this.sUq = false;
        label368:
        this.cFd = 0.0F;
        this.sUo = this.sUd.getScale();
        if (this.count == 1)
        {
          this.sUf = System.currentTimeMillis();
          if (this.sUf - this.sUe >= 350L) {
            break label908;
          }
          if ((Math.abs(this.sUg - f.d(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.sUh - f.e(paramMotionEvent, 0)) < 10.0F))
          {
            j localj = this.sUu;
            localj.dyp = false;
            localj.j(0, 350L, 0L);
          }
        }
      }
      label477:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.cFd = 0.0F;
        this.sUo = this.sUd.getScale();
        this.sUj = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.ab(paramMotionEvent) != 2) {
          break label979;
        }
        this.sUv.removeMessages(2);
        this.sUj = true;
        this.count = 0;
        f1 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
        f2 = f.e(paramMotionEvent, 0) - f.e(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.cFd != 0.0F) {
          break label925;
        }
        this.cFd = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.sUi = System.currentTimeMillis();
      if (this.sUi - this.sUf < 350L)
      {
        if ((Math.abs(this.sUg - f.d(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.sUh - f.e(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          ac.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.sUd.getScale() <= this.sUd.getScaleRate())
          {
            this.sUd.aj(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
            break;
          }
          this.sUd.ai(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
          this.sUd.fik();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label777:
      if (this.sUr)
      {
        this.sUr = false;
        this.sUn = new g(this.sUd);
        cOf();
      }
      if (this.sUs)
      {
        this.sUs = false;
        this.sUn = new h(this.sUd);
        cOf();
      }
      if (this.sUp)
      {
        this.sUp = false;
        this.sUn = new i(this.sUd);
        cOf();
      }
      if (!this.sUq) {
        break label368;
      }
      this.sUq = false;
      this.sUn = new e(this.sUd);
      cOf();
      break label368;
      label908:
      this.count = 0;
      ac.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label477;
      label925:
      f3 /= this.cFd;
      if (this.sUj)
      {
        this.sUd.m(f3 * this.sUo, f1 + f.d(paramMotionEvent, 1), f2 + f.e(paramMotionEvent, 1));
        this.sUd.fik();
        continue;
        label979:
        if ((Math.abs(this.sUg - f.d(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.sUh - f.e(paramMotionEvent, 0)) > 10.0F))
        {
          this.sUv.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.sUd.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.sUd.setImageBitmap(paramBitmap);
    this.sUd.fij();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.sUd.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.sUd.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.sUx = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.sUw = paramd;
  }
  
  abstract class a
  {
    protected boolean cEQ = false;
    
    public a() {}
    
    public final boolean cOg()
    {
      return this.cEQ;
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
    MultiTouchImageView kqu;
    float[] sUz;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.sUz = new float[9];
      this.kqu = paramMultiTouchImageView;
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
          MultiGestureImageView.e.this.kqu.getImageMatrix().getValues(MultiGestureImageView.e.this.sUz);
          float f1 = MultiGestureImageView.e.this.kqu.getScale();
          float f2 = MultiGestureImageView.e.this.kqu.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.sUz[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.cEQ = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.kqu.ak(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.cEQ = true;
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
    MultiTouchImageView kqu;
    float[] sUz;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.sUz = new float[9];
      this.kqu = paramMultiTouchImageView;
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
          MultiGestureImageView.f.this.kqu.getImageMatrix().getValues(MultiGestureImageView.f.this.sUz);
          float f5 = MultiGestureImageView.f.this.kqu.getScale() * MultiGestureImageView.f.this.kqu.getImageWidth();
          float f1 = MultiGestureImageView.f.this.kqu.getScale();
          float f8 = MultiGestureImageView.f.this.kqu.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.sUz[2];
          float f10 = MultiGestureImageView.f.this.sUz[5];
          float f6 = MultiGestureImageView.f.this.sUz[2];
          float f9 = MultiGestureImageView.f.this.sUz[5];
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
                    MultiGestureImageView.f.this.cEQ = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.kqu.ak(f2, f1);
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
    MultiTouchImageView kqu;
    float[] sUz;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.sUz = new float[9];
      this.kqu = paramMultiTouchImageView;
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
          MultiGestureImageView.g.this.kqu.getImageMatrix().getValues(MultiGestureImageView.g.this.sUz);
          float f2 = MultiGestureImageView.g.this.sUz[2];
          float f1 = MultiGestureImageView.g.this.kqu.getScale() * MultiGestureImageView.g.this.kqu.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.cEQ = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.kqu.ak(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.cEQ = true;
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
    MultiTouchImageView kqu;
    float[] sUz;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.sUz = new float[9];
      this.kqu = paramMultiTouchImageView;
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
          MultiGestureImageView.h.this.kqu.getImageMatrix().getValues(MultiGestureImageView.h.this.sUz);
          float f1 = MultiGestureImageView.h.this.kqu.getScale();
          float f2 = MultiGestureImageView.h.this.kqu.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.sUz[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.cEQ = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.kqu.ak(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.cEQ = true;
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
    MultiTouchImageView kqu;
    float[] sUz;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.sUz = new float[9];
      this.kqu = paramMultiTouchImageView;
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
          MultiGestureImageView.i.this.kqu.getImageMatrix().getValues(MultiGestureImageView.i.this.sUz);
          float f2 = MultiGestureImageView.i.this.sUz[5];
          float f1 = MultiGestureImageView.i.this.kqu.getScale() * MultiGestureImageView.i.this.kqu.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.cEQ = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.kqu.ak(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.cEQ = true;
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
    extends ao
  {
    boolean dyp;
    WeakReference<MultiGestureImageView> mn;
    private long sUF;
    
    public j()
    {
      Object localObject;
      this.mn = localObject;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(111766);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.mn != null)
      {
        final MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.mn.get();
        if (localMultiGestureImageView != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.dyp))
            {
              ac.d("MicroMsg.MultiGestureImageView", "single click over!");
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
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).cOg()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.sUF);
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
      this.sUF = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.gallery.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.OverScroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int auq;
  private int aur;
  private float cQS;
  private int count;
  private int lxZ;
  private int lya;
  private OverScroller ubA;
  private GestureDetector ubB;
  private RectF ubC;
  private a ubD;
  private float ubE;
  private boolean ubF;
  private boolean ubG;
  private boolean ubH;
  private boolean ubI;
  private j ubJ;
  private j ubK;
  private j ubL;
  private d ubM;
  private b ubN;
  private MultiTouchImageView ubt;
  private long ubu;
  private long ubv;
  private float ubw;
  private float ubx;
  private long uby;
  private boolean ubz;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.ubu = 0L;
    this.ubv = 0L;
    this.ubw = 0.0F;
    this.ubx = 0.0F;
    this.uby = 0L;
    this.ubz = false;
    this.ubC = new RectF();
    this.ubF = false;
    this.ubG = false;
    this.ubH = false;
    this.ubI = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.ubu = 0L;
    this.ubv = 0L;
    this.ubw = 0.0F;
    this.ubx = 0.0F;
    this.uby = 0L;
    this.ubz = false;
    this.ubC = new RectF();
    this.ubF = false;
    this.ubG = false;
    this.ubH = false;
    this.ubI = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void cZc()
  {
    AppMethodBeat.i(111774);
    this.ubJ.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void cZd()
  {
    AppMethodBeat.i(111775);
    cZc();
    this.ubJ.j(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.ubt = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.ubB = new GestureDetector(paramContext, new MultiGestureImageView.c(this, (byte)0));
    this.ubA = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.ubt.setLayoutParams(paramContext);
    addView(this.ubt);
    this.ubJ = new j(new WeakReference(this));
    this.ubK = new j(new WeakReference(this));
    this.ubL = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.ubt == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.ubA.computeScrollOffset())
    {
      i = this.ubA.getCurrX() - this.auq;
      int n = this.ubA.getCurrY() - this.aur;
      this.auq = this.ubA.getCurrX();
      this.aur = this.ubA.getCurrY();
      float f3 = this.ubt.getScale();
      f4 = this.ubt.getImageWidth();
      float f1 = f3 * this.ubt.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.ubt.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.ubC.right - Math.round(f3)) {
          j = (int)(this.ubC.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.ubC.left - Math.round(f2)) {
          i = (int)(this.ubC.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.ubC.bottom - Math.round(f5)) {
          k = (int)(this.ubC.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.ubC.top - Math.round(f4)) {
          j = (int)(this.ubC.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.ubC.left) && (Math.round(f3) > this.ubC.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.lya) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.ubt.ao(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.ubC.top)
      {
        k = i;
        if (Math.round(f5) > this.ubC.bottom) {
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
    int i = this.ubt.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.ubt.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.lxZ = View.MeasureSpec.getSize(paramInt1);
    this.lya = View.MeasureSpec.getSize(paramInt2);
    this.ubC.set(0.0F, 0.0F, this.lxZ, this.lya);
    ae.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.lxZ + " height:" + this.lya);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    Object localObject = this.ubB;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mt(0)), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.ubA.forceFinished(true);
      this.ubL.removeMessages(2);
      this.ubL.j(2, 500L, 0L);
      this.ubt.fCC();
      this.count += 1;
      if (this.count == 1)
      {
        this.ubu = System.currentTimeMillis();
        this.ubw = f.d(paramMotionEvent, 0);
        this.ubx = f.e(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.ubL.removeMessages(2);
        this.cQS = 0.0F;
        this.ubE = this.ubt.getScale();
        this.ubz = true;
        float f4;
        if (this.ubE < this.ubt.getScaleRate())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.ubt.am(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
        if (this.ubE > this.ubt.getDoubleTabScale())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.ubt.an(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.ubL.removeMessages(2);
        if (((!this.ubH) && (!this.ubI)) || ((!this.ubF) && (!this.ubG))) {
          break label853;
        }
        this.ubD = new f(this.ubt);
        cZd();
        this.ubH = false;
        this.ubI = false;
        this.ubF = false;
        this.ubG = false;
        label444:
        this.cQS = 0.0F;
        this.ubE = this.ubt.getScale();
        if (this.count == 1)
        {
          this.ubv = System.currentTimeMillis();
          if (this.ubv - this.ubu >= 350L) {
            break label984;
          }
          if ((Math.abs(this.ubw - f.d(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.ubx - f.e(paramMotionEvent, 0)) < 10.0F))
          {
            localObject = this.ubK;
            ((j)localObject).dLR = false;
            ((j)localObject).j(0, 350L, 0L);
          }
        }
      }
      label553:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.cQS = 0.0F;
        this.ubE = this.ubt.getScale();
        this.ubz = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.ab(paramMotionEvent) != 2) {
          break label1055;
        }
        this.ubL.removeMessages(2);
        this.ubz = true;
        this.count = 0;
        f1 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
        f2 = f.e(paramMotionEvent, 0) - f.e(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.cQS != 0.0F) {
          break label1001;
        }
        this.cQS = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.uby = System.currentTimeMillis();
      if (this.uby - this.ubv < 350L)
      {
        if ((Math.abs(this.ubw - f.d(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.ubx - f.e(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          ae.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.ubt.getScale() <= this.ubt.getScaleRate())
          {
            this.ubt.an(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
            break;
          }
          this.ubt.am(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
          this.ubt.fCB();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label853:
      if (this.ubH)
      {
        this.ubH = false;
        this.ubD = new g(this.ubt);
        cZd();
      }
      if (this.ubI)
      {
        this.ubI = false;
        this.ubD = new h(this.ubt);
        cZd();
      }
      if (this.ubF)
      {
        this.ubF = false;
        this.ubD = new i(this.ubt);
        cZd();
      }
      if (!this.ubG) {
        break label444;
      }
      this.ubG = false;
      this.ubD = new e(this.ubt);
      cZd();
      break label444;
      label984:
      this.count = 0;
      ae.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label553;
      label1001:
      f3 /= this.cQS;
      if (this.ubz)
      {
        this.ubt.o(f3 * this.ubE, f1 + f.d(paramMotionEvent, 1), f2 + f.e(paramMotionEvent, 1));
        this.ubt.fCB();
        continue;
        label1055:
        if ((Math.abs(this.ubw - f.d(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.ubx - f.e(paramMotionEvent, 0)) > 10.0F))
        {
          this.ubL.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.ubt.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.ubt.setImageBitmap(paramBitmap);
    this.ubt.fCA();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.ubt.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.ubt.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.ubN = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.ubM = paramd;
  }
  
  abstract class a
  {
    protected boolean cQF = false;
    
    public a() {}
    
    public final boolean cZe()
    {
      return this.cQF;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b {}
  
  public static abstract interface d {}
  
  final class e
    extends MultiGestureImageView.a
  {
    MultiTouchImageView kOL;
    float[] ubP;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.ubP = new float[9];
      this.kOL = paramMultiTouchImageView;
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
          MultiGestureImageView.e.this.kOL.getImageMatrix().getValues(MultiGestureImageView.e.this.ubP);
          float f1 = MultiGestureImageView.e.this.kOL.getScale();
          float f2 = MultiGestureImageView.e.this.kOL.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.ubP[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.cQF = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.kOL.ao(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.cQF = true;
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
    MultiTouchImageView kOL;
    float[] ubP;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.ubP = new float[9];
      this.kOL = paramMultiTouchImageView;
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
          MultiGestureImageView.f.this.kOL.getImageMatrix().getValues(MultiGestureImageView.f.this.ubP);
          float f5 = MultiGestureImageView.f.this.kOL.getScale() * MultiGestureImageView.f.this.kOL.getImageWidth();
          float f1 = MultiGestureImageView.f.this.kOL.getScale();
          float f8 = MultiGestureImageView.f.this.kOL.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.ubP[2];
          float f10 = MultiGestureImageView.f.this.ubP[5];
          float f6 = MultiGestureImageView.f.this.ubP[2];
          float f9 = MultiGestureImageView.f.this.ubP[5];
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
                    MultiGestureImageView.f.this.cQF = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.kOL.ao(f2, f1);
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
    MultiTouchImageView kOL;
    float[] ubP;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.ubP = new float[9];
      this.kOL = paramMultiTouchImageView;
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
          MultiGestureImageView.g.this.kOL.getImageMatrix().getValues(MultiGestureImageView.g.this.ubP);
          float f2 = MultiGestureImageView.g.this.ubP[2];
          float f1 = MultiGestureImageView.g.this.kOL.getScale() * MultiGestureImageView.g.this.kOL.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.cQF = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.kOL.ao(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.cQF = true;
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
    MultiTouchImageView kOL;
    float[] ubP;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.ubP = new float[9];
      this.kOL = paramMultiTouchImageView;
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
          MultiGestureImageView.h.this.kOL.getImageMatrix().getValues(MultiGestureImageView.h.this.ubP);
          float f1 = MultiGestureImageView.h.this.kOL.getScale();
          float f2 = MultiGestureImageView.h.this.kOL.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.ubP[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.cQF = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.kOL.ao(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.cQF = true;
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
    MultiTouchImageView kOL;
    float[] ubP;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.ubP = new float[9];
      this.kOL = paramMultiTouchImageView;
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
          MultiGestureImageView.i.this.kOL.getImageMatrix().getValues(MultiGestureImageView.i.this.ubP);
          float f2 = MultiGestureImageView.i.this.ubP[5];
          float f1 = MultiGestureImageView.i.this.kOL.getScale() * MultiGestureImageView.i.this.kOL.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.cQF = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.kOL.ao(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.cQF = true;
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
    extends aq
  {
    boolean dLR;
    WeakReference<MultiGestureImageView> og;
    private long ubV;
    
    public j()
    {
      Object localObject;
      this.og = localObject;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(111766);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.og != null)
      {
        final MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.og.get();
        if (localMultiGestureImageView != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.dLR))
            {
              ae.d("MicroMsg.MultiGestureImageView", "single click over!");
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
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).cZe()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.ubV);
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
      this.ubV = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */
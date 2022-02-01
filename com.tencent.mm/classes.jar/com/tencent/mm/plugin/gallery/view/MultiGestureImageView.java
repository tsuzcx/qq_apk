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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.g;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private boolean HRA;
  private boolean HRB;
  private boolean HRC;
  private j HRD;
  private j HRE;
  private j HRF;
  private d HRG;
  private b HRH;
  private MultiTouchImageView HRn;
  private long HRo;
  private long HRp;
  private float HRq;
  private float HRr;
  private long HRs;
  private boolean HRt;
  private OverScroller HRu;
  private GestureDetector HRv;
  private RectF HRw;
  private a HRx;
  private float HRy;
  private boolean HRz;
  private int caG;
  private int caH;
  private int count;
  private float hct;
  private int pvg;
  private int sJv;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.HRo = 0L;
    this.HRp = 0L;
    this.HRq = 0.0F;
    this.HRr = 0.0F;
    this.HRs = 0L;
    this.HRt = false;
    this.HRw = new RectF();
    this.HRz = false;
    this.HRA = false;
    this.HRB = false;
    this.HRC = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.HRo = 0L;
    this.HRp = 0L;
    this.HRq = 0.0F;
    this.HRr = 0.0F;
    this.HRs = 0L;
    this.HRt = false;
    this.HRw = new RectF();
    this.HRz = false;
    this.HRA = false;
    this.HRB = false;
    this.HRC = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void fBX()
  {
    AppMethodBeat.i(111774);
    this.HRD.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void fBY()
  {
    AppMethodBeat.i(111775);
    fBX();
    this.HRD.o(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.HRn = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.HRv = new GestureDetector(paramContext, new MultiGestureImageView.c(this, (byte)0));
    this.HRu = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.HRn.setLayoutParams(paramContext);
    addView(this.HRn);
    this.HRD = new j(new WeakReference(this));
    this.HRE = new j(new WeakReference(this));
    this.HRF = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.HRn == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.HRu.computeScrollOffset())
    {
      i = this.HRu.getCurrX() - this.caG;
      int n = this.HRu.getCurrY() - this.caH;
      this.caG = this.HRu.getCurrX();
      this.caH = this.HRu.getCurrY();
      float f3 = this.HRn.getScale();
      f4 = this.HRn.getImageWidth();
      float f1 = f3 * this.HRn.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.HRn.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.HRw.right - Math.round(f3)) {
          j = (int)(this.HRw.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.HRw.left - Math.round(f2)) {
          i = (int)(this.HRw.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.HRw.bottom - Math.round(f5)) {
          k = (int)(this.HRw.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.HRw.top - Math.round(f4)) {
          j = (int)(this.HRw.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.HRw.left) && (Math.round(f3) > this.HRw.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.pvg) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.HRn.be(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.HRw.top)
      {
        k = i;
        if (Math.round(f5) > this.HRw.bottom) {
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
    int i = this.HRn.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.HRn.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.sJv = View.MeasureSpec.getSize(paramInt1);
    this.pvg = View.MeasureSpec.getSize(paramInt2);
    this.HRw.set(0.0F, 0.0F, this.sJv, this.pvg);
    Log.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.sJv + " height:" + this.pvg);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    Object localObject = this.HRv;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().cG(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.b(localObject, locala.aYi(), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.sb(0)), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.HRu.forceFinished(true);
      this.HRF.removeMessages(2);
      this.HRF.o(2, 500L, 0L);
      this.HRn.jmc();
      this.count += 1;
      if (this.count == 1)
      {
        this.HRo = System.currentTimeMillis();
        this.HRq = g.k(paramMotionEvent, 0);
        this.HRr = g.l(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.HRF.removeMessages(2);
        this.hct = 0.0F;
        this.HRy = this.HRn.getScale();
        this.HRt = true;
        float f4;
        if (this.HRy < this.HRn.getScaleRate())
        {
          f1 = g.k(paramMotionEvent, 0);
          f2 = g.k(paramMotionEvent, 1);
          f3 = g.l(paramMotionEvent, 0);
          f4 = g.l(paramMotionEvent, 1);
          this.HRn.bd(f1 - f2 + g.k(paramMotionEvent, 1), f3 - f4 + g.l(paramMotionEvent, 1));
        }
        if (this.HRy > this.HRn.getDoubleTabScale())
        {
          f1 = g.k(paramMotionEvent, 0);
          f2 = g.k(paramMotionEvent, 1);
          f3 = g.l(paramMotionEvent, 0);
          f4 = g.l(paramMotionEvent, 1);
          this.HRn.ag(f1 - f2 + g.k(paramMotionEvent, 1), f3 - f4 + g.l(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.HRF.removeMessages(2);
        if (((!this.HRB) && (!this.HRC)) || ((!this.HRz) && (!this.HRA))) {
          break label855;
        }
        this.HRx = new f(this.HRn);
        fBY();
        this.HRB = false;
        this.HRC = false;
        this.HRz = false;
        this.HRA = false;
        label445:
        this.hct = 0.0F;
        this.HRy = this.HRn.getScale();
        if (this.count == 1)
        {
          this.HRp = System.currentTimeMillis();
          if (this.HRp - this.HRo >= 350L) {
            break label986;
          }
          if ((Math.abs(this.HRq - g.k(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.HRr - g.l(paramMotionEvent, 0)) < 10.0F))
          {
            localObject = this.HRE;
            ((j)localObject).idP = false;
            ((j)localObject).o(0, 350L, 0L);
          }
        }
      }
      label554:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.hct = 0.0F;
        this.HRy = this.HRn.getScale();
        this.HRt = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (g.au(paramMotionEvent) != 2) {
          break label1057;
        }
        this.HRF.removeMessages(2);
        this.HRt = true;
        this.count = 0;
        f1 = g.k(paramMotionEvent, 0) - g.k(paramMotionEvent, 1);
        f2 = g.l(paramMotionEvent, 0) - g.l(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.hct != 0.0F) {
          break label1003;
        }
        this.hct = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.HRs = System.currentTimeMillis();
      if (this.HRs - this.HRp < 350L)
      {
        if ((Math.abs(this.HRq - g.k(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.HRr - g.l(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          Log.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.HRn.getScale() <= this.HRn.getScaleRate())
          {
            this.HRn.ag(g.k(paramMotionEvent, 0), g.l(paramMotionEvent, 0));
            break;
          }
          this.HRn.bd(g.k(paramMotionEvent, 0), g.l(paramMotionEvent, 0));
          this.HRn.jmb();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label855:
      if (this.HRB)
      {
        this.HRB = false;
        this.HRx = new g(this.HRn);
        fBY();
      }
      if (this.HRC)
      {
        this.HRC = false;
        this.HRx = new h(this.HRn);
        fBY();
      }
      if (this.HRz)
      {
        this.HRz = false;
        this.HRx = new i(this.HRn);
        fBY();
      }
      if (!this.HRA) {
        break label445;
      }
      this.HRA = false;
      this.HRx = new e(this.HRn);
      fBY();
      break label445;
      label986:
      this.count = 0;
      Log.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label554;
      label1003:
      f3 /= this.hct;
      if (this.HRt)
      {
        this.HRn.x(f3 * this.HRy, f1 + g.k(paramMotionEvent, 1), f2 + g.l(paramMotionEvent, 1));
        this.HRn.jmb();
        continue;
        label1057:
        if ((Math.abs(this.HRq - g.k(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.HRr - g.l(paramMotionEvent, 0)) > 10.0F))
        {
          this.HRF.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.HRn.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.HRn.setImageBitmap(paramBitmap);
    this.HRn.jma();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.HRn.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.HRn.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.HRH = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.HRG = paramd;
  }
  
  abstract class a
  {
    protected boolean hcg = false;
    
    public a() {}
    
    public final boolean efT()
    {
      return this.hcg;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b {}
  
  public static abstract interface d {}
  
  final class e
    extends MultiGestureImageView.a
  {
    float[] HRJ;
    MultiTouchImageView rUf;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.HRJ = new float[9];
      this.rUf = paramMultiTouchImageView;
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
          MultiGestureImageView.e.this.rUf.getImageMatrix().getValues(MultiGestureImageView.e.this.HRJ);
          float f1 = MultiGestureImageView.e.this.rUf.getScale();
          float f2 = MultiGestureImageView.e.this.rUf.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.HRJ[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.hcg = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.rUf.be(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.hcg = true;
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
    float[] HRJ;
    MultiTouchImageView rUf;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.HRJ = new float[9];
      this.rUf = paramMultiTouchImageView;
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
          MultiGestureImageView.f.this.rUf.getImageMatrix().getValues(MultiGestureImageView.f.this.HRJ);
          float f5 = MultiGestureImageView.f.this.rUf.getScale() * MultiGestureImageView.f.this.rUf.getImageWidth();
          float f1 = MultiGestureImageView.f.this.rUf.getScale();
          float f8 = MultiGestureImageView.f.this.rUf.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.HRJ[2];
          float f10 = MultiGestureImageView.f.this.HRJ[5];
          float f6 = MultiGestureImageView.f.this.HRJ[2];
          float f9 = MultiGestureImageView.f.this.HRJ[5];
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
                    MultiGestureImageView.f.this.hcg = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.rUf.be(f2, f1);
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
    float[] HRJ;
    MultiTouchImageView rUf;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.HRJ = new float[9];
      this.rUf = paramMultiTouchImageView;
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
          MultiGestureImageView.g.this.rUf.getImageMatrix().getValues(MultiGestureImageView.g.this.HRJ);
          float f2 = MultiGestureImageView.g.this.HRJ[2];
          float f1 = MultiGestureImageView.g.this.rUf.getScale() * MultiGestureImageView.g.this.rUf.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.hcg = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.rUf.be(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.hcg = true;
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
    float[] HRJ;
    MultiTouchImageView rUf;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.HRJ = new float[9];
      this.rUf = paramMultiTouchImageView;
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
          MultiGestureImageView.h.this.rUf.getImageMatrix().getValues(MultiGestureImageView.h.this.HRJ);
          float f1 = MultiGestureImageView.h.this.rUf.getScale();
          float f2 = MultiGestureImageView.h.this.rUf.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.HRJ[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.hcg = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.rUf.be(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.hcg = true;
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
    float[] HRJ;
    MultiTouchImageView rUf;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.HRJ = new float[9];
      this.rUf = paramMultiTouchImageView;
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
          MultiGestureImageView.i.this.rUf.getImageMatrix().getValues(MultiGestureImageView.i.this.HRJ);
          float f2 = MultiGestureImageView.i.this.HRJ[5];
          float f1 = MultiGestureImageView.i.this.rUf.getScale() * MultiGestureImageView.i.this.rUf.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.hcg = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.rUf.be(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.hcg = true;
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
    extends MMHandler
  {
    private long HRP;
    boolean idP;
    WeakReference<MultiGestureImageView> viewRef;
    
    public j()
    {
      Object localObject;
      this.viewRef = localObject;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(111766);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.viewRef != null)
      {
        final MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.viewRef.get();
        if (localMultiGestureImageView != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.idP))
            {
              Log.d("MicroMsg.MultiGestureImageView", "single click over!");
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
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).efT()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.HRP);
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
    
    public final void o(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111767);
      this.HRP = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */
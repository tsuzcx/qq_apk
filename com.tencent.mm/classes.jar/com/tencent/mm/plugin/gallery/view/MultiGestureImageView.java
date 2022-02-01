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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int auq;
  private int aur;
  private float cQi;
  private int count;
  private int ltA;
  private int ltB;
  private MultiTouchImageView tQC;
  private long tQD;
  private long tQE;
  private float tQF;
  private float tQG;
  private long tQH;
  private boolean tQI;
  private OverScroller tQJ;
  private GestureDetector tQK;
  private RectF tQL;
  private a tQM;
  private float tQN;
  private boolean tQO;
  private boolean tQP;
  private boolean tQQ;
  private boolean tQR;
  private j tQS;
  private j tQT;
  private j tQU;
  private d tQV;
  private b tQW;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.tQD = 0L;
    this.tQE = 0L;
    this.tQF = 0.0F;
    this.tQG = 0.0F;
    this.tQH = 0L;
    this.tQI = false;
    this.tQL = new RectF();
    this.tQO = false;
    this.tQP = false;
    this.tQQ = false;
    this.tQR = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.tQD = 0L;
    this.tQE = 0L;
    this.tQF = 0.0F;
    this.tQG = 0.0F;
    this.tQH = 0L;
    this.tQI = false;
    this.tQL = new RectF();
    this.tQO = false;
    this.tQP = false;
    this.tQQ = false;
    this.tQR = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void cWx()
  {
    AppMethodBeat.i(111774);
    this.tQS.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void cWy()
  {
    AppMethodBeat.i(111775);
    cWx();
    this.tQS.j(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.tQC = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.tQK = new GestureDetector(paramContext, new MultiGestureImageView.c(this, (byte)0));
    this.tQJ = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.tQC.setLayoutParams(paramContext);
    addView(this.tQC);
    this.tQS = new j(new WeakReference(this));
    this.tQT = new j(new WeakReference(this));
    this.tQU = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.tQC == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.tQJ.computeScrollOffset())
    {
      i = this.tQJ.getCurrX() - this.auq;
      int n = this.tQJ.getCurrY() - this.aur;
      this.auq = this.tQJ.getCurrX();
      this.aur = this.tQJ.getCurrY();
      float f3 = this.tQC.getScale();
      f4 = this.tQC.getImageWidth();
      float f1 = f3 * this.tQC.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.tQC.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.tQL.right - Math.round(f3)) {
          j = (int)(this.tQL.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.tQL.left - Math.round(f2)) {
          i = (int)(this.tQL.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.tQL.bottom - Math.round(f5)) {
          k = (int)(this.tQL.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.tQL.top - Math.round(f4)) {
          j = (int)(this.tQL.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.tQL.left) && (Math.round(f3) > this.tQL.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.ltB) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.tQC.ao(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.tQL.top)
      {
        k = i;
        if (Math.round(f5) > this.tQL.bottom) {
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
    int i = this.tQC.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.tQC.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.ltA = View.MeasureSpec.getSize(paramInt1);
    this.ltB = View.MeasureSpec.getSize(paramInt2);
    this.tQL.set(0.0F, 0.0F, this.ltA, this.ltB);
    ad.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.ltA + " height:" + this.ltB);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    Object localObject = this.tQK;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahp(), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.mq(0)), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.tQJ.forceFinished(true);
      this.tQU.removeMessages(2);
      this.tQU.j(2, 500L, 0L);
      this.tQC.fyA();
      this.count += 1;
      if (this.count == 1)
      {
        this.tQD = System.currentTimeMillis();
        this.tQF = f.d(paramMotionEvent, 0);
        this.tQG = f.e(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.tQU.removeMessages(2);
        this.cQi = 0.0F;
        this.tQN = this.tQC.getScale();
        this.tQI = true;
        float f4;
        if (this.tQN < this.tQC.getScaleRate())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.tQC.am(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
        if (this.tQN > this.tQC.getDoubleTabScale())
        {
          f1 = f.d(paramMotionEvent, 0);
          f2 = f.d(paramMotionEvent, 1);
          f3 = f.e(paramMotionEvent, 0);
          f4 = f.e(paramMotionEvent, 1);
          this.tQC.an(f1 - f2 + f.d(paramMotionEvent, 1), f3 - f4 + f.e(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.tQU.removeMessages(2);
        if (((!this.tQQ) && (!this.tQR)) || ((!this.tQO) && (!this.tQP))) {
          break label853;
        }
        this.tQM = new f(this.tQC);
        cWy();
        this.tQQ = false;
        this.tQR = false;
        this.tQO = false;
        this.tQP = false;
        label444:
        this.cQi = 0.0F;
        this.tQN = this.tQC.getScale();
        if (this.count == 1)
        {
          this.tQE = System.currentTimeMillis();
          if (this.tQE - this.tQD >= 350L) {
            break label984;
          }
          if ((Math.abs(this.tQF - f.d(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.tQG - f.e(paramMotionEvent, 0)) < 10.0F))
          {
            localObject = this.tQT;
            ((j)localObject).dKC = false;
            ((j)localObject).j(0, 350L, 0L);
          }
        }
      }
      label553:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.cQi = 0.0F;
        this.tQN = this.tQC.getScale();
        this.tQI = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.ad(paramMotionEvent) != 2) {
          break label1055;
        }
        this.tQU.removeMessages(2);
        this.tQI = true;
        this.count = 0;
        f1 = f.d(paramMotionEvent, 0) - f.d(paramMotionEvent, 1);
        f2 = f.e(paramMotionEvent, 0) - f.e(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.cQi != 0.0F) {
          break label1001;
        }
        this.cQi = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.tQH = System.currentTimeMillis();
      if (this.tQH - this.tQE < 350L)
      {
        if ((Math.abs(this.tQF - f.d(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.tQG - f.e(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          ad.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.tQC.getScale() <= this.tQC.getScaleRate())
          {
            this.tQC.an(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
            break;
          }
          this.tQC.am(f.d(paramMotionEvent, 0), f.e(paramMotionEvent, 0));
          this.tQC.fyz();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label853:
      if (this.tQQ)
      {
        this.tQQ = false;
        this.tQM = new g(this.tQC);
        cWy();
      }
      if (this.tQR)
      {
        this.tQR = false;
        this.tQM = new h(this.tQC);
        cWy();
      }
      if (this.tQO)
      {
        this.tQO = false;
        this.tQM = new i(this.tQC);
        cWy();
      }
      if (!this.tQP) {
        break label444;
      }
      this.tQP = false;
      this.tQM = new e(this.tQC);
      cWy();
      break label444;
      label984:
      this.count = 0;
      ad.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label553;
      label1001:
      f3 /= this.cQi;
      if (this.tQI)
      {
        this.tQC.o(f3 * this.tQN, f1 + f.d(paramMotionEvent, 1), f2 + f.e(paramMotionEvent, 1));
        this.tQC.fyz();
        continue;
        label1055:
        if ((Math.abs(this.tQF - f.d(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.tQG - f.e(paramMotionEvent, 0)) > 10.0F))
        {
          this.tQU.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.tQC.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.tQC.setImageBitmap(paramBitmap);
    this.tQC.fyy();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.tQC.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.tQC.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.tQW = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.tQV = paramd;
  }
  
  abstract class a
  {
    protected boolean cPV = false;
    
    public a() {}
    
    public final boolean cWz()
    {
      return this.cPV;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b {}
  
  public static abstract interface d {}
  
  final class e
    extends MultiGestureImageView.a
  {
    MultiTouchImageView kLw;
    float[] tQY;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.tQY = new float[9];
      this.kLw = paramMultiTouchImageView;
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
          MultiGestureImageView.e.this.kLw.getImageMatrix().getValues(MultiGestureImageView.e.this.tQY);
          float f1 = MultiGestureImageView.e.this.kLw.getScale();
          float f2 = MultiGestureImageView.e.this.kLw.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.tQY[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.cPV = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.kLw.ao(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.cPV = true;
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
    MultiTouchImageView kLw;
    float[] tQY;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.tQY = new float[9];
      this.kLw = paramMultiTouchImageView;
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
          MultiGestureImageView.f.this.kLw.getImageMatrix().getValues(MultiGestureImageView.f.this.tQY);
          float f5 = MultiGestureImageView.f.this.kLw.getScale() * MultiGestureImageView.f.this.kLw.getImageWidth();
          float f1 = MultiGestureImageView.f.this.kLw.getScale();
          float f8 = MultiGestureImageView.f.this.kLw.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.tQY[2];
          float f10 = MultiGestureImageView.f.this.tQY[5];
          float f6 = MultiGestureImageView.f.this.tQY[2];
          float f9 = MultiGestureImageView.f.this.tQY[5];
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
                    MultiGestureImageView.f.this.cPV = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.kLw.ao(f2, f1);
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
    MultiTouchImageView kLw;
    float[] tQY;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.tQY = new float[9];
      this.kLw = paramMultiTouchImageView;
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
          MultiGestureImageView.g.this.kLw.getImageMatrix().getValues(MultiGestureImageView.g.this.tQY);
          float f2 = MultiGestureImageView.g.this.tQY[2];
          float f1 = MultiGestureImageView.g.this.kLw.getScale() * MultiGestureImageView.g.this.kLw.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.cPV = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.kLw.ao(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.cPV = true;
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
    MultiTouchImageView kLw;
    float[] tQY;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.tQY = new float[9];
      this.kLw = paramMultiTouchImageView;
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
          MultiGestureImageView.h.this.kLw.getImageMatrix().getValues(MultiGestureImageView.h.this.tQY);
          float f1 = MultiGestureImageView.h.this.kLw.getScale();
          float f2 = MultiGestureImageView.h.this.kLw.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.tQY[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.cPV = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.kLw.ao(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.cPV = true;
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
    MultiTouchImageView kLw;
    float[] tQY;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.tQY = new float[9];
      this.kLw = paramMultiTouchImageView;
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
          MultiGestureImageView.i.this.kLw.getImageMatrix().getValues(MultiGestureImageView.i.this.tQY);
          float f2 = MultiGestureImageView.i.this.tQY[5];
          float f1 = MultiGestureImageView.i.this.kLw.getScale() * MultiGestureImageView.i.this.kLw.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.cPV = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.kLw.ao(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.cPV = true;
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
    boolean dKC;
    WeakReference<MultiGestureImageView> og;
    private long tRe;
    
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
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.dKC))
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
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).cWz()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.tRe);
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
      this.tRe = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */
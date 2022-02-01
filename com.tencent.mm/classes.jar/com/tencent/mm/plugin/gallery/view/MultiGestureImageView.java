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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.f;
import java.lang.ref.WeakReference;

public class MultiGestureImageView
  extends LinearLayout
{
  private int auo;
  private int aup;
  private int count;
  private float dhm;
  private int mEX;
  private int mEY;
  private MultiTouchImageView xsH;
  private long xsI;
  private long xsJ;
  private float xsK;
  private float xsL;
  private long xsM;
  private boolean xsN;
  private OverScroller xsO;
  private GestureDetector xsP;
  private RectF xsQ;
  private a xsR;
  private float xsS;
  private boolean xsT;
  private boolean xsU;
  private boolean xsV;
  private boolean xsW;
  private j xsX;
  private j xsY;
  private j xsZ;
  private d xta;
  private b xtb;
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(111768);
    this.count = 0;
    this.xsI = 0L;
    this.xsJ = 0L;
    this.xsK = 0.0F;
    this.xsL = 0.0F;
    this.xsM = 0L;
    this.xsN = false;
    this.xsQ = new RectF();
    this.xsT = false;
    this.xsU = false;
    this.xsV = false;
    this.xsW = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111768);
  }
  
  public MultiGestureImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(111769);
    this.count = 0;
    this.xsI = 0L;
    this.xsJ = 0L;
    this.xsK = 0.0F;
    this.xsL = 0.0F;
    this.xsM = 0L;
    this.xsN = false;
    this.xsQ = new RectF();
    this.xsT = false;
    this.xsU = false;
    this.xsV = false;
    this.xsW = false;
    init(paramContext, paramAttributeSet);
    AppMethodBeat.o(111769);
  }
  
  private void dSC()
  {
    AppMethodBeat.i(111774);
    this.xsX.removeMessages(1);
    AppMethodBeat.o(111774);
  }
  
  private void dSD()
  {
    AppMethodBeat.i(111775);
    dSC();
    this.xsX.m(1, 15L, 15L);
    AppMethodBeat.o(111775);
  }
  
  private void init(Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(111770);
    this.xsH = new MultiTouchImageView(paramContext, paramAttributeSet);
    this.xsP = new GestureDetector(paramContext, new c((byte)0));
    this.xsO = new OverScroller(paramContext, new DecelerateInterpolator(2.0F));
    paramContext = new LinearLayout.LayoutParams(-1, -1);
    this.xsH.setLayoutParams(paramContext);
    addView(this.xsH);
    this.xsX = new j(new WeakReference(this));
    this.xsY = new j(new WeakReference(this));
    this.xsZ = new j(new WeakReference(this));
    AppMethodBeat.o(111770);
  }
  
  public void computeScroll()
  {
    int m = 0;
    AppMethodBeat.i(111773);
    if (this.xsH == null)
    {
      AppMethodBeat.o(111773);
      return;
    }
    float f4;
    float f5;
    int j;
    int k;
    if (this.xsO.computeScrollOffset())
    {
      i = this.xsO.getCurrX() - this.auo;
      int n = this.xsO.getCurrY() - this.aup;
      this.auo = this.xsO.getCurrX();
      this.aup = this.xsO.getCurrY();
      float f3 = this.xsH.getScale();
      f4 = this.xsH.getImageWidth();
      float f1 = f3 * this.xsH.getImageHeight();
      float[] arrayOfFloat = new float[9];
      this.xsH.getImageMatrix().getValues(arrayOfFloat);
      float f2 = arrayOfFloat[2];
      f3 = f4 * f3 + f2;
      f4 = arrayOfFloat[5];
      f5 = f4 + f1;
      j = i;
      if (i < 0)
      {
        j = i;
        if (i < this.xsQ.right - Math.round(f3)) {
          j = (int)(this.xsQ.right - Math.round(f3));
        }
      }
      i = j;
      if (j > 0)
      {
        i = j;
        if (j > this.xsQ.left - Math.round(f2)) {
          i = (int)(this.xsQ.left - Math.round(f2));
        }
      }
      k = n;
      if (n < 0)
      {
        k = n;
        if (n < this.xsQ.bottom - Math.round(f5)) {
          k = (int)(this.xsQ.bottom - Math.round(f5));
        }
      }
      j = k;
      if (k > 0)
      {
        j = k;
        if (k > this.xsQ.top - Math.round(f4)) {
          j = (int)(this.xsQ.top - Math.round(f4));
        }
      }
      if ((Math.round(f2) < this.xsQ.left) && (Math.round(f3) > this.xsQ.right)) {
        break label424;
      }
      k = 0;
      if (f1 >= this.mEY) {
        break label472;
      }
    }
    label424:
    label472:
    for (int i = m;; i = j)
    {
      this.xsH.au(k, i);
      postInvalidate();
      AppMethodBeat.o(111773);
      return;
      if (Math.round(f4) < this.xsQ.top)
      {
        k = i;
        if (Math.round(f5) > this.xsQ.bottom) {
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
    int i = this.xsH.getImageHeight();
    AppMethodBeat.o(111779);
    return i;
  }
  
  public int getImageWidth()
  {
    AppMethodBeat.i(111777);
    int i = this.xsH.getImageWidth();
    AppMethodBeat.o(111777);
    return i;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(111771);
    super.onMeasure(paramInt1, paramInt2);
    this.mEX = View.MeasureSpec.getSize(paramInt1);
    this.mEY = View.MeasureSpec.getSize(paramInt2);
    this.xsQ.set(0.0F, 0.0F, this.mEX, this.mEY);
    Log.v("MicroMsg.MultiGestureImageView", "MMGestureGallery width:" + this.mEX + " height:" + this.mEY);
    AppMethodBeat.o(111771);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(111772);
    Object localObject = this.xsP;
    com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bl(paramMotionEvent);
    com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.axQ(), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    com.tencent.mm.hellhoundlib.a.a.a(localObject, ((GestureDetector)localObject).onTouchEvent((MotionEvent)locala.pG(0)), "com/tencent/mm/plugin/gallery/view/MultiGestureImageView", "onTouchEvent", "(Landroid/view/MotionEvent;)Z", "android/view/GestureDetector_EXEC_", "onTouchEvent", "(Landroid/view/MotionEvent;)Z");
    float f1;
    float f2;
    float f3;
    if (paramMotionEvent.getAction() == 0)
    {
      this.xsO.forceFinished(true);
      this.xsZ.removeMessages(2);
      this.xsZ.m(2, 500L, 0L);
      this.xsH.gKA();
      this.count += 1;
      if (this.count == 1)
      {
        this.xsI = System.currentTimeMillis();
        this.xsK = f.j(paramMotionEvent, 0);
        this.xsL = f.k(paramMotionEvent, 0);
      }
    }
    else
    {
      if ((paramMotionEvent.getAction() == 6) || (paramMotionEvent.getAction() == 262))
      {
        this.xsZ.removeMessages(2);
        this.dhm = 0.0F;
        this.xsS = this.xsH.getScale();
        this.xsN = true;
        float f4;
        if (this.xsS < this.xsH.getScaleRate())
        {
          f1 = f.j(paramMotionEvent, 0);
          f2 = f.j(paramMotionEvent, 1);
          f3 = f.k(paramMotionEvent, 0);
          f4 = f.k(paramMotionEvent, 1);
          this.xsH.at(f1 - f2 + f.j(paramMotionEvent, 1), f3 - f4 + f.k(paramMotionEvent, 1));
        }
        if (this.xsS > this.xsH.getDoubleTabScale())
        {
          f1 = f.j(paramMotionEvent, 0);
          f2 = f.j(paramMotionEvent, 1);
          f3 = f.k(paramMotionEvent, 0);
          f4 = f.k(paramMotionEvent, 1);
          this.xsH.y(f1 - f2 + f.j(paramMotionEvent, 1), f3 - f4 + f.k(paramMotionEvent, 1));
        }
      }
      if (paramMotionEvent.getAction() == 1)
      {
        this.xsZ.removeMessages(2);
        if (((!this.xsV) && (!this.xsW)) || ((!this.xsT) && (!this.xsU))) {
          break label855;
        }
        this.xsR = new f(this.xsH);
        dSD();
        this.xsV = false;
        this.xsW = false;
        this.xsT = false;
        this.xsU = false;
        label445:
        this.dhm = 0.0F;
        this.xsS = this.xsH.getScale();
        if (this.count == 1)
        {
          this.xsJ = System.currentTimeMillis();
          if (this.xsJ - this.xsI >= 350L) {
            break label986;
          }
          if ((Math.abs(this.xsK - f.j(paramMotionEvent, 0)) < 10.0F) && (Math.abs(this.xsL - f.k(paramMotionEvent, 0)) < 10.0F))
          {
            localObject = this.xsY;
            ((j)localObject).edG = false;
            ((j)localObject).m(0, 350L, 0L);
          }
        }
      }
      label554:
      if ((paramMotionEvent.getAction() == 5) || (paramMotionEvent.getAction() == 261))
      {
        this.dhm = 0.0F;
        this.xsS = this.xsH.getScale();
        this.xsN = true;
      }
      if (paramMotionEvent.getAction() == 2)
      {
        if (f.ai(paramMotionEvent) != 2) {
          break label1057;
        }
        this.xsZ.removeMessages(2);
        this.xsN = true;
        this.count = 0;
        f1 = f.j(paramMotionEvent, 0) - f.j(paramMotionEvent, 1);
        f2 = f.k(paramMotionEvent, 0) - f.k(paramMotionEvent, 1);
        f3 = (float)Math.sqrt(f1 * f1 + f2 * f2);
        if (this.dhm != 0.0F) {
          break label1003;
        }
        this.dhm = f3;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(111772);
      return true;
      if (this.count != 2) {
        break;
      }
      this.xsM = System.currentTimeMillis();
      if (this.xsM - this.xsJ < 350L)
      {
        if ((Math.abs(this.xsK - f.j(paramMotionEvent, 0)) < 35.0F) && (Math.abs(this.xsL - f.k(paramMotionEvent, 0)) < 35.0F))
        {
          this.count = 0;
          Log.d("MicroMsg.MultiGestureImageView", "double click!");
          if (this.xsH.getScale() <= this.xsH.getScaleRate())
          {
            this.xsH.y(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
            break;
          }
          this.xsH.at(f.j(paramMotionEvent, 0), f.k(paramMotionEvent, 0));
          this.xsH.gKz();
          break;
        }
        this.count = 1;
        break;
      }
      this.count = 1;
      break;
      label855:
      if (this.xsV)
      {
        this.xsV = false;
        this.xsR = new g(this.xsH);
        dSD();
      }
      if (this.xsW)
      {
        this.xsW = false;
        this.xsR = new h(this.xsH);
        dSD();
      }
      if (this.xsT)
      {
        this.xsT = false;
        this.xsR = new i(this.xsH);
        dSD();
      }
      if (!this.xsU) {
        break label445;
      }
      this.xsU = false;
      this.xsR = new e(this.xsH);
      dSD();
      break label445;
      label986:
      this.count = 0;
      Log.d("MicroMsg.MultiGestureImageView", "single long click over!");
      break label554;
      label1003:
      f3 /= this.dhm;
      if (this.xsN)
      {
        this.xsH.r(f3 * this.xsS, f1 + f.j(paramMotionEvent, 1), f2 + f.k(paramMotionEvent, 1));
        this.xsH.gKz();
        continue;
        label1057:
        if ((Math.abs(this.xsK - f.j(paramMotionEvent, 0)) > 10.0F) || (Math.abs(this.xsL - f.k(paramMotionEvent, 0)) > 10.0F))
        {
          this.xsZ.removeMessages(2);
          this.count = 0;
          computeScroll();
        }
      }
    }
  }
  
  public void setEnableHorLongBmpMode(boolean paramBoolean)
  {
    AppMethodBeat.i(111776);
    this.xsH.setEnableHorLongBmpMode(paramBoolean);
    AppMethodBeat.o(111776);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    AppMethodBeat.i(111781);
    this.xsH.setImageBitmap(paramBitmap);
    this.xsH.gKy();
    AppMethodBeat.o(111781);
  }
  
  public void setImageHeight(int paramInt)
  {
    AppMethodBeat.i(111780);
    this.xsH.setImageHeight(paramInt);
    AppMethodBeat.o(111780);
  }
  
  public void setImageWidth(int paramInt)
  {
    AppMethodBeat.i(111778);
    this.xsH.setImageWidth(paramInt);
    AppMethodBeat.o(111778);
  }
  
  public void setLongClickOverListener(b paramb)
  {
    this.xtb = paramb;
  }
  
  public void setSingleClickOverListener(d paramd)
  {
    this.xta = paramd;
  }
  
  abstract class a
  {
    protected boolean dgZ = false;
    
    public a() {}
    
    public final boolean deQ()
    {
      return this.dgZ;
    }
    
    public abstract void play();
  }
  
  public static abstract interface b {}
  
  final class c
    extends GestureDetector.SimpleOnGestureListener
  {
    private c() {}
    
    public final boolean onContextClick(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257766);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onContextClick(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257766);
      return bool;
    }
    
    public final boolean onDoubleTap(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257763);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257763);
      return true;
    }
    
    public final void onLongPress(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257765);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.axR());
      super.onLongPress(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
      AppMethodBeat.o(257765);
    }
    
    public final boolean onSingleTapUp(MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(257764);
      b localb = new b();
      localb.bm(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.axR());
      boolean bool = super.onSingleTapUp(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/gallery/view/MultiGestureImageView$MySimpleGesture", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
      AppMethodBeat.o(257764);
      return bool;
    }
  }
  
  public static abstract interface d {}
  
  final class e
    extends MultiGestureImageView.a
  {
    MultiTouchImageView lTJ;
    float[] xtd;
    
    public e(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111750);
      this.xtd = new float[9];
      this.lTJ = paramMultiTouchImageView;
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
          MultiGestureImageView.e.this.lTJ.getImageMatrix().getValues(MultiGestureImageView.e.this.xtd);
          float f1 = MultiGestureImageView.e.this.lTJ.getScale();
          float f2 = MultiGestureImageView.e.this.lTJ.getImageHeight() * f1;
          float f3 = MultiGestureImageView.e.this.xtd[5];
          f1 = MultiGestureImageView.i(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.i(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.e.this.dgZ = true;
          }
          for (;;)
          {
            MultiGestureImageView.e.this.lTJ.au(0.0F, f1);
            AppMethodBeat.o(111749);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.e.this.dgZ = true;
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
    MultiTouchImageView lTJ;
    float[] xtd;
    
    public f(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111753);
      this.xtd = new float[9];
      this.lTJ = paramMultiTouchImageView;
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
          MultiGestureImageView.f.this.lTJ.getImageMatrix().getValues(MultiGestureImageView.f.this.xtd);
          float f5 = MultiGestureImageView.f.this.lTJ.getScale() * MultiGestureImageView.f.this.lTJ.getImageWidth();
          float f1 = MultiGestureImageView.f.this.lTJ.getScale();
          float f8 = MultiGestureImageView.f.this.lTJ.getImageHeight() * f1;
          float f7 = MultiGestureImageView.f.this.xtd[2];
          float f10 = MultiGestureImageView.f.this.xtd[5];
          float f6 = MultiGestureImageView.f.this.xtd[2];
          float f9 = MultiGestureImageView.f.this.xtd[5];
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
                    MultiGestureImageView.f.this.dgZ = true;
                  }
                  for (;;)
                  {
                    MultiGestureImageView.f.this.lTJ.au(f2, f1);
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
    MultiTouchImageView lTJ;
    float[] xtd;
    
    public g(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111756);
      this.xtd = new float[9];
      this.lTJ = paramMultiTouchImageView;
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
          MultiGestureImageView.g.this.lTJ.getImageMatrix().getValues(MultiGestureImageView.g.this.xtd);
          float f2 = MultiGestureImageView.g.this.xtd[2];
          float f1 = MultiGestureImageView.g.this.lTJ.getScale() * MultiGestureImageView.g.this.lTJ.getImageWidth();
          if (f1 < MultiGestureImageView.g(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.g.this.dgZ = true;
            }
            for (;;)
            {
              MultiGestureImageView.g.this.lTJ.au(f1, 0.0F);
              AppMethodBeat.o(111755);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.g.this.dgZ = true;
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
    MultiTouchImageView lTJ;
    float[] xtd;
    
    public h(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111759);
      this.xtd = new float[9];
      this.lTJ = paramMultiTouchImageView;
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
          MultiGestureImageView.h.this.lTJ.getImageMatrix().getValues(MultiGestureImageView.h.this.xtd);
          float f1 = MultiGestureImageView.h.this.lTJ.getScale();
          float f2 = MultiGestureImageView.h.this.lTJ.getImageWidth() * f1;
          float f3 = MultiGestureImageView.h.this.xtd[2];
          f1 = MultiGestureImageView.g(MultiGestureImageView.this);
          if (f2 < MultiGestureImageView.g(MultiGestureImageView.this)) {
            f1 = MultiGestureImageView.g(MultiGestureImageView.this) / 2.0F + f2 / 2.0F;
          }
          f1 -= f3 + f2;
          if (f1 <= 0.0F) {
            MultiGestureImageView.h.this.dgZ = true;
          }
          for (;;)
          {
            MultiGestureImageView.h.this.lTJ.au(f1, 0.0F);
            AppMethodBeat.o(111758);
            return;
            if (Math.abs(f1) <= 5.0F) {
              MultiGestureImageView.h.this.dgZ = true;
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
    MultiTouchImageView lTJ;
    float[] xtd;
    
    public i(MultiTouchImageView paramMultiTouchImageView)
    {
      super();
      AppMethodBeat.i(111762);
      this.xtd = new float[9];
      this.lTJ = paramMultiTouchImageView;
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
          MultiGestureImageView.i.this.lTJ.getImageMatrix().getValues(MultiGestureImageView.i.this.xtd);
          float f2 = MultiGestureImageView.i.this.xtd[5];
          float f1 = MultiGestureImageView.i.this.lTJ.getScale() * MultiGestureImageView.i.this.lTJ.getImageHeight();
          if (f1 < MultiGestureImageView.i(MultiGestureImageView.this)) {}
          for (f1 = MultiGestureImageView.i(MultiGestureImageView.this) / 2.0F - f1 / 2.0F;; f1 = 0.0F)
          {
            f1 -= f2;
            if (f1 >= 0.0F) {
              MultiGestureImageView.i.this.dgZ = true;
            }
            for (;;)
            {
              MultiGestureImageView.i.this.lTJ.au(0.0F, f1);
              AppMethodBeat.o(111761);
              return;
              if (Math.abs(f1) <= 5.0F) {
                MultiGestureImageView.i.this.dgZ = true;
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
    boolean edG;
    WeakReference<MultiGestureImageView> oi;
    private long xtj;
    
    public j()
    {
      Object localObject;
      this.oi = localObject;
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(111766);
      super.handleMessage(paramMessage);
      removeMessages(paramMessage.what);
      if (this.oi != null)
      {
        final MultiGestureImageView localMultiGestureImageView = (MultiGestureImageView)this.oi.get();
        if (localMultiGestureImageView != null)
        {
          if (paramMessage.what == 0)
          {
            if ((MultiGestureImageView.a(localMultiGestureImageView) == 1) || (this.edG))
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
            if ((MultiGestureImageView.d(MultiGestureImageView.this) != null) && (!MultiGestureImageView.d(MultiGestureImageView.this).deQ()))
            {
              MultiGestureImageView.d(MultiGestureImageView.this).play();
              sendEmptyMessageDelayed(paramMessage.what, this.xtj);
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
    
    public final void m(int paramInt, long paramLong1, long paramLong2)
    {
      AppMethodBeat.i(111767);
      this.xtj = paramLong2;
      sendEmptyMessageDelayed(paramInt, paramLong1);
      AppMethodBeat.o(111767);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.gallery.view.MultiGestureImageView
 * JD-Core Version:    0.7.0.1
 */
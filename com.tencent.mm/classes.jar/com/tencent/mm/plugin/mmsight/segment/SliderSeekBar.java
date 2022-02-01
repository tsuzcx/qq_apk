package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public class SliderSeekBar
  extends View
{
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  private View.OnTouchListener tDQ;
  private float vSA;
  private int vSB;
  private float vSC;
  private int vSD;
  private Paint vSE;
  private float vSF;
  private Paint vSG;
  private Paint vSH;
  private int vSI;
  private float vSJ;
  private float vSK;
  private float vSL;
  private int vSM;
  private Rect vSN;
  private Rect vSO;
  private boolean vSP;
  private a vSq;
  private boolean vSr;
  boolean vSs;
  private int vSt;
  private int vSu;
  private boolean vSv;
  private boolean vSw;
  private Drawable vSx;
  private Drawable vSy;
  private int vSz;
  
  public SliderSeekBar(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(94449);
    AppMethodBeat.o(94449);
  }
  
  public SliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(214486);
    this.vSr = false;
    this.vSs = false;
    this.vSv = false;
    this.vSw = false;
    this.vSC = -1.0F;
    this.vSK = -1.0F;
    this.vSL = -1.0F;
    this.padding = 0;
    this.vSP = true;
    this.tDQ = new View.OnTouchListener()
    {
      float cNg;
      float cNh;
      int vSU = -1;
      int vSV = -1;
      int vSW;
      int vSX;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94445);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahq());
        if (!SliderSeekBar.h(SliderSeekBar.this))
        {
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(94445);
          return false;
        }
        boolean bool;
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        case 4: 
        default: 
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(94445);
          return false;
        case 2: 
          if ((!SliderSeekBar.a(SliderSeekBar.this, true)) && (!SliderSeekBar.a(SliderSeekBar.this, false)))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this))
          {
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return true;
          }
          this.vSX = 0;
          bool = false;
          if (this.vSX < paramAnonymousMotionEvent.getPointerCount())
          {
            this.vSW = paramAnonymousMotionEvent.getPointerId(this.vSX);
            if ((this.vSW == this.vSU) || (this.vSW == this.vSV))
            {
              paramAnonymousView = SliderSeekBar.this;
              if (this.vSW != this.vSU) {
                break label392;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.vSX));
              if ((SliderSeekBar.j(SliderSeekBar.this)) && (bool) && (!SliderSeekBar.k(SliderSeekBar.this))) {
                SliderSeekBar.this.performHapticFeedback(0, 2);
              }
              SliderSeekBar.b(SliderSeekBar.this, bool);
              if (SliderSeekBar.l(SliderSeekBar.this) != null)
              {
                paramAnonymousView = SliderSeekBar.l(SliderSeekBar.this);
                if (this.vSW != this.vSU) {
                  break label397;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              paramAnonymousView.ov(bool);
              bool = true;
              this.vSX += 1;
              break;
              bool = false;
              break label282;
            }
          }
          com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(94445);
          return bool;
        case 1: 
        case 3: 
        case 6: 
          label282:
          this.vSW = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label392:
          label397:
          if ((this.vSW != this.vSU) && (this.vSW != this.vSV))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dnK();
          }
          paramAnonymousView = SliderSeekBar.this;
          if (this.vSW == this.vSU)
          {
            bool = true;
            SliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.vSW != this.vSU) {
              break label572;
            }
            this.vSU = -1;
          }
          for (;;)
          {
            SliderSeekBar.b(SliderSeekBar.this, false);
            com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return true;
            bool = false;
            break;
            label572:
            this.vSV = -1;
          }
        }
        this.vSX = paramAnonymousMotionEvent.getActionIndex();
        this.vSW = paramAnonymousMotionEvent.getPointerId(this.vSX);
        this.cNg = paramAnonymousMotionEvent.getX(this.vSX);
        this.cNh = paramAnonymousMotionEvent.getY(this.vSX);
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.f(SliderSeekBar.this), this.cNg, this.cNh))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, true))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dnJ();
          }
          this.vSU = this.vSW;
          SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.f(SliderSeekBar.this).getBounds().left);
          SliderSeekBar.a(SliderSeekBar.this, true, true);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(94445);
          return true;
        }
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.g(SliderSeekBar.this), this.cNg, this.cNh))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, false))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dnJ();
          }
          this.vSV = this.vSW;
          SliderSeekBar.b(SliderSeekBar.this, SliderSeekBar.g(SliderSeekBar.this).getBounds().right);
          SliderSeekBar.a(SliderSeekBar.this, false, true);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(94445);
          return true;
        }
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(94445);
        return false;
      }
    };
    this.vSz = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.vSA = (this.vSz * 0.5F);
    this.vSM = com.tencent.mm.cc.a.fromDPToPix(getContext(), 8);
    this.vSx = new b(com.tencent.mm.cc.a.l(getContext(), 2131691359), com.tencent.mm.cc.a.l(getContext(), 2131691358));
    this.vSy = new b(com.tencent.mm.cc.a.l(getContext(), 2131691359), com.tencent.mm.cc.a.l(getContext(), 2131691358));
    this.vSP = true;
    postInvalidate();
    this.vSB = com.tencent.mm.cc.a.fromDPToPix(getContext(), 1);
    this.vSD = com.tencent.mm.cc.a.ax(getContext(), 2131166956);
    this.vSC = -1.0F;
    this.vSE = new Paint();
    this.vSE.setColor(com.tencent.mm.cc.a.n(getContext(), 2131099684));
    this.vSE.setAlpha(102);
    this.vSG = new Paint();
    this.vSG.setColor(com.tencent.mm.cc.a.n(getContext(), 2131099654));
    this.vSG.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(com.tencent.mm.cc.a.n(getContext(), 2131099684));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = fO(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.vSF = (this.borderWidth * 0.5F);
    this.vSH = new Paint();
    this.vSH.setColor(com.tencent.mm.cc.a.n(getContext(), 2131099684));
    this.vSH.setStyle(Paint.Style.STROKE);
    this.vSI = fO(getContext());
    this.vSJ = (this.vSI * 0.5F);
    this.vSH.setStrokeWidth(this.vSI);
    this.vSH.setAlpha(178);
    setOnTouchListener(this.tDQ);
    AppMethodBeat.o(214486);
  }
  
  private static int fO(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean ow(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.vSx);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.vSy);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void aj(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(214487);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94444);
        if (paramInt1 <= SliderSeekBar.a(SliderSeekBar.this) * 2)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
          AppMethodBeat.o(94444);
          throw localIllegalStateException;
        }
        SliderSeekBar.b(SliderSeekBar.this);
        SliderSeekBar.a(SliderSeekBar.this, paramInt3);
        SliderSeekBar.b(SliderSeekBar.this, Math.min(paramInt1, SliderSeekBar.this.getWidth() - paramInt3 * 2));
        SliderSeekBar.c(SliderSeekBar.this, Math.max(paramInt2, 0));
        SliderSeekBar.c(SliderSeekBar.this);
        if ((SliderSeekBar.d(SliderSeekBar.this) == null) && (SliderSeekBar.e(SliderSeekBar.this) == null))
        {
          SliderSeekBar.a(SliderSeekBar.this, new Rect(SliderSeekBar.f(SliderSeekBar.this).getBounds().left, SliderSeekBar.f(SliderSeekBar.this).getBounds().top, SliderSeekBar.f(SliderSeekBar.this).getBounds().right, SliderSeekBar.f(SliderSeekBar.this).getBounds().bottom));
          SliderSeekBar.b(SliderSeekBar.this, new Rect(SliderSeekBar.g(SliderSeekBar.this).getBounds().left, SliderSeekBar.g(SliderSeekBar.this).getBounds().top, SliderSeekBar.g(SliderSeekBar.this).getBounds().right, SliderSeekBar.g(SliderSeekBar.this).getBounds().bottom));
        }
        SliderSeekBar.this.invalidate();
        AppMethodBeat.o(94444);
      }
    });
    AppMethodBeat.o(214487);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(214489);
    if ((!this.vSr) || (this.vSx == null) || (this.vSy == null) || (this.vSx.getBounds().width() <= 0) || (this.vSy.getBounds().width() <= 0))
    {
      AppMethodBeat.o(214489);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label134:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.vSy.getBounds().left - this.vSu;
      f1 = Math.max(this.padding, this.vSy.getBounds().left - this.vSt);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label237;
      }
      bool = true;
      if (!paramBoolean) {
        break label243;
      }
      localRect = this.vSx.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.vSz), 0);
      this.vSx.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(214489);
      return bool;
      f1 = this.vSx.getBounds().right + this.vSu;
      f2 = Math.min(getWidth() - this.padding, this.vSx.getBounds().right + this.vSt);
      break;
      label237:
      bool = false;
      break label134;
      label243:
      localRect = this.vSy.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.vSy.setBounds(localRect);
    }
  }
  
  public final void dnL()
  {
    this.vSs = true;
  }
  
  public final void dnM()
  {
    this.vSs = false;
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.vSx.getBounds().right;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.vSy.getBounds().left;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.vSC > 0.0F)
    {
      float f = getWidth() * this.vSC;
      paramCanvas.drawRect(f - this.vSB * 0.5F, 0.0F, this.vSB * 0.5F + f, getHeight(), this.vSE);
    }
    if (!this.vSr)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.vSx.getBounds().centerX();
    int j = this.vSy.getBounds().centerX();
    if (((ow(true)) || (ow(false))) && (this.vSP)) {
      paramCanvas.drawRect(this.padding + this.vSJ, this.vSJ, getWidth() - this.padding - this.vSJ, getBottom() - this.vSJ, this.vSH);
    }
    if (this.vSx.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.vSG);
    }
    if (this.vSy.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.vSG);
    }
    if (this.vSP)
    {
      paramCanvas.drawLine(i, this.vSF, j, this.vSF, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.vSF, j, getHeight() - this.vSF, this.borderPaint);
    }
    this.vSx.draw(paramCanvas);
    this.vSy.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.vSN != null) && (this.vSO != null))
    {
      Rect localRect1 = new Rect(this.vSN.left, this.vSN.top, this.vSN.right, this.vSN.bottom);
      Rect localRect2 = new Rect(this.vSO.left, this.vSO.top, this.vSO.right, this.vSO.bottom);
      this.vSx.setBounds(localRect1);
      this.vSy.setBounds(localRect2);
      this.vSC = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.vSr)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.vSC = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.vSw = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(214488);
    this.vSG.setColor(paramInt);
    AppMethodBeat.o(214488);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.vSq = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dnJ();
    
    public abstract void dnK();
    
    public abstract void ov(boolean paramBoolean);
  }
  
  final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable vSY;
    private Drawable vSZ;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.vSY = paramDrawable1;
      this.vSZ = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(94446);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.vSY;; localDrawable = this.vSZ)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(94446);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(94447);
      this.vSY.setAlpha(paramInt);
      this.vSZ.setAlpha(paramInt);
      AppMethodBeat.o(94447);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(94448);
      this.vSY.setColorFilter(paramColorFilter);
      this.vSZ.setColorFilter(paramColorFilter);
      AppMethodBeat.o(94448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
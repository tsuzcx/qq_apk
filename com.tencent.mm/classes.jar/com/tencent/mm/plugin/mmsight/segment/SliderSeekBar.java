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
  private View.OnTouchListener tOH;
  private boolean weA;
  private Drawable weB;
  private Drawable weC;
  private int weD;
  private float weE;
  private int weF;
  private float weG;
  private int weH;
  private Paint weI;
  private float weJ;
  private Paint weK;
  private Paint weL;
  private int weM;
  private float weN;
  private float weO;
  private float weP;
  private int weQ;
  private Rect weR;
  private Rect weS;
  private boolean weT;
  private a weu;
  private boolean wev;
  boolean wew;
  private int wex;
  private int wey;
  private boolean wez;
  
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
    AppMethodBeat.i(189022);
    this.wev = false;
    this.wew = false;
    this.wez = false;
    this.weA = false;
    this.weG = -1.0F;
    this.weO = -1.0F;
    this.weP = -1.0F;
    this.padding = 0;
    this.weT = true;
    this.tOH = new View.OnTouchListener()
    {
      float cNQ;
      float cNR;
      int weY = -1;
      int weZ = -1;
      int wfa;
      int wfb;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94445);
        b localb = new b();
        localb.bd(paramAnonymousView);
        localb.bd(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
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
          this.wfb = 0;
          bool = false;
          if (this.wfb < paramAnonymousMotionEvent.getPointerCount())
          {
            this.wfa = paramAnonymousMotionEvent.getPointerId(this.wfb);
            if ((this.wfa == this.weY) || (this.wfa == this.weZ))
            {
              paramAnonymousView = SliderSeekBar.this;
              if (this.wfa != this.weY) {
                break label392;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.wfb));
              if ((SliderSeekBar.j(SliderSeekBar.this)) && (bool) && (!SliderSeekBar.k(SliderSeekBar.this))) {
                SliderSeekBar.this.performHapticFeedback(0, 2);
              }
              SliderSeekBar.b(SliderSeekBar.this, bool);
              if (SliderSeekBar.l(SliderSeekBar.this) != null)
              {
                paramAnonymousView = SliderSeekBar.l(SliderSeekBar.this);
                if (this.wfa != this.weY) {
                  break label397;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              paramAnonymousView.oA(bool);
              bool = true;
              this.wfb += 1;
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
          this.wfa = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label392:
          label397:
          if ((this.wfa != this.weY) && (this.wfa != this.weZ))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dqI();
          }
          paramAnonymousView = SliderSeekBar.this;
          if (this.wfa == this.weY)
          {
            bool = true;
            SliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.wfa != this.weY) {
              break label572;
            }
            this.weY = -1;
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
            this.weZ = -1;
          }
        }
        this.wfb = paramAnonymousMotionEvent.getActionIndex();
        this.wfa = paramAnonymousMotionEvent.getPointerId(this.wfb);
        this.cNQ = paramAnonymousMotionEvent.getX(this.wfb);
        this.cNR = paramAnonymousMotionEvent.getY(this.wfb);
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.f(SliderSeekBar.this), this.cNQ, this.cNR))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, true))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dqH();
          }
          this.weY = this.wfa;
          SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.f(SliderSeekBar.this).getBounds().left);
          SliderSeekBar.a(SliderSeekBar.this, true, true);
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
          AppMethodBeat.o(94445);
          return true;
        }
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.g(SliderSeekBar.this), this.cNQ, this.cNR))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, false))
          {
            com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/mmsight/segment/SliderSeekBar$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dqH();
          }
          this.weZ = this.wfa;
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
    this.weD = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.weE = (this.weD * 0.5F);
    this.weQ = com.tencent.mm.cb.a.fromDPToPix(getContext(), 8);
    this.weB = new b(com.tencent.mm.cb.a.l(getContext(), 2131691359), com.tencent.mm.cb.a.l(getContext(), 2131691358));
    this.weC = new b(com.tencent.mm.cb.a.l(getContext(), 2131691359), com.tencent.mm.cb.a.l(getContext(), 2131691358));
    this.weT = true;
    postInvalidate();
    this.weF = com.tencent.mm.cb.a.fromDPToPix(getContext(), 1);
    this.weH = com.tencent.mm.cb.a.ax(getContext(), 2131166956);
    this.weG = -1.0F;
    this.weI = new Paint();
    this.weI.setColor(com.tencent.mm.cb.a.n(getContext(), 2131099684));
    this.weI.setAlpha(102);
    this.weK = new Paint();
    this.weK.setColor(com.tencent.mm.cb.a.n(getContext(), 2131099654));
    this.weK.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(com.tencent.mm.cb.a.n(getContext(), 2131099684));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = fU(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.weJ = (this.borderWidth * 0.5F);
    this.weL = new Paint();
    this.weL.setColor(com.tencent.mm.cb.a.n(getContext(), 2131099684));
    this.weL.setStyle(Paint.Style.STROKE);
    this.weM = fU(getContext());
    this.weN = (this.weM * 0.5F);
    this.weL.setStrokeWidth(this.weM);
    this.weL.setAlpha(178);
    setOnTouchListener(this.tOH);
    AppMethodBeat.o(189022);
  }
  
  private static int fU(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean oB(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.weB);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.weC);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void aj(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(189023);
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
    AppMethodBeat.o(189023);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(189025);
    if ((!this.wev) || (this.weB == null) || (this.weC == null) || (this.weB.getBounds().width() <= 0) || (this.weC.getBounds().width() <= 0))
    {
      AppMethodBeat.o(189025);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label134:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.weC.getBounds().left - this.wey;
      f1 = Math.max(this.padding, this.weC.getBounds().left - this.wex);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label237;
      }
      bool = true;
      if (!paramBoolean) {
        break label243;
      }
      localRect = this.weB.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.weD), 0);
      this.weB.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(189025);
      return bool;
      f1 = this.weB.getBounds().right + this.wey;
      f2 = Math.min(getWidth() - this.padding, this.weB.getBounds().right + this.wex);
      break;
      label237:
      bool = false;
      break label134;
      label243:
      localRect = this.weC.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.weC.setBounds(localRect);
    }
  }
  
  public final void dqJ()
  {
    this.wew = true;
  }
  
  public final void dqK()
  {
    this.wew = false;
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.weB.getBounds().right;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.weC.getBounds().left;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.weG > 0.0F)
    {
      float f = getWidth() * this.weG;
      paramCanvas.drawRect(f - this.weF * 0.5F, 0.0F, this.weF * 0.5F + f, getHeight(), this.weI);
    }
    if (!this.wev)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.weB.getBounds().centerX();
    int j = this.weC.getBounds().centerX();
    if (((oB(true)) || (oB(false))) && (this.weT)) {
      paramCanvas.drawRect(this.padding + this.weN, this.weN, getWidth() - this.padding - this.weN, getBottom() - this.weN, this.weL);
    }
    if (this.weB.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.weK);
    }
    if (this.weC.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.weK);
    }
    if (this.weT)
    {
      paramCanvas.drawLine(i, this.weJ, j, this.weJ, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.weJ, j, getHeight() - this.weJ, this.borderPaint);
    }
    this.weB.draw(paramCanvas);
    this.weC.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.weR != null) && (this.weS != null))
    {
      Rect localRect1 = new Rect(this.weR.left, this.weR.top, this.weR.right, this.weR.bottom);
      Rect localRect2 = new Rect(this.weS.left, this.weS.top, this.weS.right, this.weS.bottom);
      this.weB.setBounds(localRect1);
      this.weC.setBounds(localRect2);
      this.weG = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.wev)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.weG = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.weA = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(189024);
    this.weK.setColor(paramInt);
    AppMethodBeat.o(189024);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.weu = parama;
  }
  
  public static abstract interface a
  {
    public abstract void dqH();
    
    public abstract void dqI();
    
    public abstract void oA(boolean paramBoolean);
  }
  
  final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable wfc;
    private Drawable wfd;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.wfc = paramDrawable1;
      this.wfd = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(94446);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.wfc;; localDrawable = this.wfd)
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
      this.wfc.setAlpha(paramInt);
      this.wfd.setAlpha(paramInt);
      AppMethodBeat.o(94447);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(94448);
      this.wfc.setColorFilter(paramColorFilter);
      this.wfd.setColorFilter(paramColorFilter);
      AppMethodBeat.o(94448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
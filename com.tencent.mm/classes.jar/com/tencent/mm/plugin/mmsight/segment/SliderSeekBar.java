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
import com.tencent.mm.cc.a;

public class SliderSeekBar
  extends View
{
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  private View.OnTouchListener sGX;
  private float uPA;
  private float uPB;
  private float uPC;
  private int uPD;
  private Rect uPE;
  private Rect uPF;
  private a uPh;
  private boolean uPi;
  boolean uPj;
  private int uPk;
  private int uPl;
  private boolean uPm;
  private boolean uPn;
  private Drawable uPo;
  private Drawable uPp;
  private int uPq;
  private float uPr;
  private int uPs;
  private float uPt;
  private int uPu;
  private Paint uPv;
  private float uPw;
  private Paint uPx;
  private Paint uPy;
  private int uPz;
  
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
    AppMethodBeat.i(209929);
    this.uPi = false;
    this.uPj = false;
    this.uPm = false;
    this.uPn = false;
    this.uPt = -1.0F;
    this.uPB = -1.0F;
    this.uPC = -1.0F;
    this.padding = 0;
    this.sGX = new View.OnTouchListener()
    {
      float cCh;
      float cCi;
      int uPK = -1;
      int uPL = -1;
      int uPM;
      int uPN;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94445);
        if (!SliderSeekBar.h(SliderSeekBar.this))
        {
          AppMethodBeat.o(94445);
          return false;
        }
        boolean bool;
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        case 4: 
        default: 
          AppMethodBeat.o(94445);
          return false;
        case 2: 
          if ((!SliderSeekBar.a(SliderSeekBar.this, true)) && (!SliderSeekBar.a(SliderSeekBar.this, false)))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this))
          {
            AppMethodBeat.o(94445);
            return true;
          }
          this.uPN = 0;
          bool = false;
          if (this.uPN < paramAnonymousMotionEvent.getPointerCount())
          {
            this.uPM = paramAnonymousMotionEvent.getPointerId(this.uPN);
            if ((this.uPM == this.uPK) || (this.uPM == this.uPL))
            {
              paramAnonymousView = SliderSeekBar.this;
              if (this.uPM != this.uPK) {
                break label301;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.uPN));
              if ((SliderSeekBar.j(SliderSeekBar.this)) && (bool) && (!SliderSeekBar.k(SliderSeekBar.this))) {
                SliderSeekBar.this.performHapticFeedback(0, 2);
              }
              SliderSeekBar.b(SliderSeekBar.this, bool);
              if (SliderSeekBar.l(SliderSeekBar.this) != null)
              {
                paramAnonymousView = SliderSeekBar.l(SliderSeekBar.this);
                if (this.uPM != this.uPK) {
                  break label306;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              paramAnonymousView.ob(bool);
              bool = true;
              this.uPN += 1;
              break;
              bool = false;
              break label191;
            }
          }
          AppMethodBeat.o(94445);
          return bool;
        case 1: 
        case 3: 
        case 6: 
          label191:
          this.uPM = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label301:
          label306:
          if ((this.uPM != this.uPK) && (this.uPM != this.uPL))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).dem();
          }
          paramAnonymousView = SliderSeekBar.this;
          if (this.uPM == this.uPK)
          {
            bool = true;
            SliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.uPM != this.uPK) {
              break label442;
            }
            this.uPK = -1;
          }
          for (;;)
          {
            SliderSeekBar.b(SliderSeekBar.this, false);
            AppMethodBeat.o(94445);
            return true;
            bool = false;
            break;
            label442:
            this.uPL = -1;
          }
        }
        this.uPN = paramAnonymousMotionEvent.getActionIndex();
        this.uPM = paramAnonymousMotionEvent.getPointerId(this.uPN);
        this.cCh = paramAnonymousMotionEvent.getX(this.uPN);
        this.cCi = paramAnonymousMotionEvent.getY(this.uPN);
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.c(SliderSeekBar.this), this.cCh, this.cCi))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, true))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).del();
          }
          this.uPK = this.uPM;
          SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.c(SliderSeekBar.this).getBounds().left);
          SliderSeekBar.a(SliderSeekBar.this, true, true);
          AppMethodBeat.o(94445);
          return true;
        }
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.e(SliderSeekBar.this), this.cCh, this.cCi))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, false))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.l(SliderSeekBar.this) != null) {
            SliderSeekBar.l(SliderSeekBar.this).del();
          }
          this.uPL = this.uPM;
          SliderSeekBar.b(SliderSeekBar.this, SliderSeekBar.e(SliderSeekBar.this).getBounds().right);
          SliderSeekBar.a(SliderSeekBar.this, false, true);
          AppMethodBeat.o(94445);
          return true;
        }
        AppMethodBeat.o(94445);
        return false;
      }
    };
    this.uPq = a.fromDPToPix(getContext(), 8);
    this.uPr = (this.uPq * 0.5F);
    this.uPD = a.fromDPToPix(getContext(), 8);
    this.uPo = new b(a.l(getContext(), 2131691359), a.l(getContext(), 2131691358));
    this.uPp = new b(a.l(getContext(), 2131691359), a.l(getContext(), 2131691358));
    this.uPs = a.fromDPToPix(getContext(), 1);
    this.uPu = a.au(getContext(), 2131166956);
    this.uPt = -1.0F;
    this.uPv = new Paint();
    this.uPv.setColor(a.n(getContext(), 2131101179));
    this.uPv.setAlpha(102);
    this.uPx = new Paint();
    this.uPx.setColor(a.n(getContext(), 2131100017));
    this.uPx.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.n(getContext(), 2131101179));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = fJ(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.uPw = (this.borderWidth * 0.5F);
    this.uPy = new Paint();
    this.uPy.setColor(a.n(getContext(), 2131101179));
    this.uPy.setStyle(Paint.Style.STROKE);
    this.uPz = fJ(getContext());
    this.uPA = (this.uPz * 0.5F);
    this.uPy.setStrokeWidth(this.uPz);
    this.uPy.setAlpha(178);
    setOnTouchListener(this.sGX);
    AppMethodBeat.o(209929);
  }
  
  private static int fJ(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean oc(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.uPo);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.uPp);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void aj(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(209930);
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
        SliderSeekBar.c(SliderSeekBar.this, Math.max(paramInt2, SliderSeekBar.a(SliderSeekBar.this) * 2));
        SliderSeekBar.c(SliderSeekBar.this).setBounds(paramInt3, 0, paramInt3 + SliderSeekBar.a(SliderSeekBar.this), SliderSeekBar.this.getHeight());
        SliderSeekBar.e(SliderSeekBar.this).setBounds(paramInt3 + SliderSeekBar.d(SliderSeekBar.this) - SliderSeekBar.a(SliderSeekBar.this), 0, SliderSeekBar.d(SliderSeekBar.this) + paramInt3, SliderSeekBar.this.getHeight());
        if ((SliderSeekBar.f(SliderSeekBar.this) == null) && (SliderSeekBar.g(SliderSeekBar.this) == null))
        {
          SliderSeekBar.a(SliderSeekBar.this, new Rect(SliderSeekBar.c(SliderSeekBar.this).getBounds().left, SliderSeekBar.c(SliderSeekBar.this).getBounds().top, SliderSeekBar.c(SliderSeekBar.this).getBounds().right, SliderSeekBar.c(SliderSeekBar.this).getBounds().bottom));
          SliderSeekBar.b(SliderSeekBar.this, new Rect(SliderSeekBar.e(SliderSeekBar.this).getBounds().left, SliderSeekBar.e(SliderSeekBar.this).getBounds().top, SliderSeekBar.e(SliderSeekBar.this).getBounds().right, SliderSeekBar.e(SliderSeekBar.this).getBounds().bottom));
        }
        SliderSeekBar.this.invalidate();
        AppMethodBeat.o(94444);
      }
    });
    AppMethodBeat.o(209930);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(209932);
    if ((!this.uPi) || (this.uPo == null) || (this.uPp == null) || (this.uPo.getBounds().width() <= 0) || (this.uPp.getBounds().width() <= 0))
    {
      AppMethodBeat.o(209932);
      return false;
    }
    float f1;
    float f2;
    boolean bool;
    label152:
    Rect localRect;
    if (paramBoolean)
    {
      f1 = this.uPp.getBounds().right - this.uPl;
      f2 = this.uPr + f1;
      f1 = Math.max(this.padding + this.uPr, this.uPp.getBounds().right - this.uPk + this.uPr);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label270;
      }
      bool = true;
      if (!paramBoolean) {
        break label276;
      }
      localRect = this.uPo.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.uPr), 0);
      this.uPo.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(209932);
      return bool;
      f1 = this.uPo.getBounds().left + this.uPl - this.uPr;
      f2 = Math.min(getWidth() - this.padding - this.uPr, this.uPo.getBounds().left + this.uPk - this.uPr);
      break;
      label270:
      bool = false;
      break label152;
      label276:
      localRect = this.uPp.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat - this.uPr), 0);
      this.uPp.setBounds(localRect);
    }
  }
  
  public final void den()
  {
    this.uPj = true;
  }
  
  public final void deo()
  {
    this.uPj = false;
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.uPo.getBounds().left;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.uPp.getBounds().right;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.uPt > 0.0F)
    {
      float f = getWidth() * this.uPt;
      paramCanvas.drawRect(f - this.uPs * 0.5F, 0.0F, this.uPs * 0.5F + f, getHeight(), this.uPv);
    }
    if (!this.uPi)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.uPo.getBounds().centerX();
    int j = this.uPp.getBounds().centerX();
    if ((oc(true)) || (oc(false))) {
      paramCanvas.drawRect(this.padding + this.uPA, this.uPA, getWidth() - this.padding - this.uPA, getBottom() - this.uPA, this.uPy);
    }
    if (this.uPo.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.uPx);
    }
    if (this.uPp.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.uPx);
    }
    paramCanvas.drawLine(i, this.uPw, j, this.uPw, this.borderPaint);
    paramCanvas.drawLine(i, getHeight() - this.uPw, j, getHeight() - this.uPw, this.borderPaint);
    this.uPo.draw(paramCanvas);
    this.uPp.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.uPE != null) && (this.uPF != null))
    {
      Rect localRect1 = new Rect(this.uPE.left, this.uPE.top, this.uPE.right, this.uPE.bottom);
      Rect localRect2 = new Rect(this.uPF.left, this.uPF.top, this.uPF.right, this.uPF.bottom);
      this.uPo.setBounds(localRect1);
      this.uPp.setBounds(localRect2);
      this.uPt = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.uPi)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.uPt = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.uPn = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(209931);
    this.uPx.setColor(paramInt);
    AppMethodBeat.o(209931);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.uPh = parama;
  }
  
  public static abstract interface a
  {
    public abstract void del();
    
    public abstract void dem();
    
    public abstract void ob(boolean paramBoolean);
  }
  
  final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable uPO;
    private Drawable uPP;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.uPO = paramDrawable1;
      this.uPP = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(94446);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.uPO;; localDrawable = this.uPP)
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
      this.uPO.setAlpha(paramInt);
      this.uPP.setAlpha(paramInt);
      AppMethodBeat.o(94447);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(94448);
      this.uPO.setColorFilter(paramColorFilter);
      this.uPP.setColorFilter(paramColorFilter);
      AppMethodBeat.o(94448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
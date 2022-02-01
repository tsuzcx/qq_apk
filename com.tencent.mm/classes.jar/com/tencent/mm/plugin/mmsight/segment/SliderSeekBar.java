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
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.g;

public class SliderSeekBar
  extends View
{
  protected Drawable KYA;
  protected Drawable KYB;
  protected int KYC;
  protected float KYD;
  private int KYE;
  private float KYF;
  private int KYG;
  private Paint KYH;
  private float KYI;
  private Paint KYJ;
  private Paint KYK;
  private int KYL;
  private float KYM;
  private float KYN;
  private float KYO;
  protected int KYP;
  private Rect KYQ;
  private Rect KYR;
  protected boolean KYS;
  private boolean KYu;
  public boolean KYv;
  private int KYw;
  private int KYx;
  private boolean KYy;
  private boolean KYz;
  private a Lad;
  private int borderWidth;
  private View.OnTouchListener onTouchListener;
  private int padding;
  private Paint uMn;
  
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
    AppMethodBeat.i(303579);
    this.KYu = false;
    this.KYv = false;
    this.KYy = false;
    this.KYz = false;
    this.KYF = -1.0F;
    this.KYN = -1.0F;
    this.KYO = -1.0F;
    this.padding = 0;
    this.KYS = true;
    this.onTouchListener = new View.OnTouchListener()
    {
      int KYT = -1;
      int KYU = -1;
      int KYV;
      int KYW;
      float fif;
      float fig;
      
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(94445);
        if (!SliderSeekBar.e(SliderSeekBar.this))
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
          if (SliderSeekBar.f(SliderSeekBar.this))
          {
            AppMethodBeat.o(94445);
            return true;
          }
          this.KYW = 0;
          bool = false;
          if (this.KYW < paramAnonymousMotionEvent.getPointerCount())
          {
            this.KYV = paramAnonymousMotionEvent.getPointerId(this.KYW);
            if ((this.KYV == this.KYT) || (this.KYV == this.KYU))
            {
              paramAnonymousView = SliderSeekBar.this;
              if (this.KYV != this.KYT) {
                break label301;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.KYW));
              if ((SliderSeekBar.g(SliderSeekBar.this)) && (bool) && (!SliderSeekBar.h(SliderSeekBar.this))) {
                SliderSeekBar.this.performHapticFeedback(0, 2);
              }
              SliderSeekBar.b(SliderSeekBar.this, bool);
              if (SliderSeekBar.i(SliderSeekBar.this) != null)
              {
                paramAnonymousView = SliderSeekBar.i(SliderSeekBar.this);
                if (this.KYV != this.KYT) {
                  break label306;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              paramAnonymousView.yA(bool);
              bool = true;
              this.KYW += 1;
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
          this.KYV = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label301:
          label306:
          if ((this.KYV != this.KYT) && (this.KYV != this.KYU))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null)
          {
            paramAnonymousView = SliderSeekBar.i(SliderSeekBar.this);
            if (this.KYV == this.KYT)
            {
              bool = true;
              paramAnonymousView.yy(bool);
            }
          }
          else
          {
            paramAnonymousView = SliderSeekBar.this;
            if (this.KYV != this.KYT) {
              break label458;
            }
            bool = true;
            label415:
            SliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.KYV != this.KYT) {
              break label463;
            }
            this.KYT = -1;
          }
          for (;;)
          {
            SliderSeekBar.b(SliderSeekBar.this, false);
            AppMethodBeat.o(94445);
            return true;
            bool = false;
            break;
            label458:
            bool = false;
            break label415;
            label463:
            this.KYU = -1;
          }
        }
        this.KYW = paramAnonymousMotionEvent.getActionIndex();
        this.KYV = paramAnonymousMotionEvent.getPointerId(this.KYW);
        this.fif = paramAnonymousMotionEvent.getX(this.KYW);
        this.fig = paramAnonymousMotionEvent.getY(this.KYW);
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.KYA, this.fif, this.fig))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, true))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).yx(true);
          }
          this.KYT = this.KYV;
          SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.KYA.getBounds().left);
          SliderSeekBar.a(SliderSeekBar.this, true, true);
          AppMethodBeat.o(94445);
          return true;
        }
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.KYB, this.fif, this.fig))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, false))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).yx(false);
          }
          this.KYU = this.KYV;
          SliderSeekBar.b(SliderSeekBar.this, SliderSeekBar.this.KYB.getBounds().right);
          SliderSeekBar.a(SliderSeekBar.this, false, true);
          AppMethodBeat.o(94445);
          return true;
        }
        AppMethodBeat.o(94445);
        return false;
      }
    };
    init();
    AppMethodBeat.o(303579);
  }
  
  private static int iS(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean yw(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.KYA);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.KYB);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void aR(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(303591);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94444);
        if (paramInt1 <= SliderSeekBar.this.KYC * 2)
        {
          IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
          AppMethodBeat.o(94444);
          throw localIllegalStateException;
        }
        SliderSeekBar.a(SliderSeekBar.this);
        SliderSeekBar.a(SliderSeekBar.this, paramInt3);
        SliderSeekBar.b(SliderSeekBar.this, Math.min(paramInt1, SliderSeekBar.this.getWidth() - paramInt3 * 2));
        SliderSeekBar.c(SliderSeekBar.this, Math.max(paramInt2, 0));
        SliderSeekBar.b(SliderSeekBar.this);
        if ((SliderSeekBar.c(SliderSeekBar.this) == null) && (SliderSeekBar.d(SliderSeekBar.this) == null))
        {
          SliderSeekBar.a(SliderSeekBar.this, new Rect(SliderSeekBar.this.KYA.getBounds().left, SliderSeekBar.this.KYA.getBounds().top, SliderSeekBar.this.KYA.getBounds().right, SliderSeekBar.this.KYA.getBounds().bottom));
          SliderSeekBar.b(SliderSeekBar.this, new Rect(SliderSeekBar.this.KYB.getBounds().left, SliderSeekBar.this.KYB.getBounds().top, SliderSeekBar.this.KYB.getBounds().right, SliderSeekBar.this.KYB.getBounds().bottom));
        }
        SliderSeekBar.this.invalidate();
        AppMethodBeat.o(94444);
      }
    });
    AppMethodBeat.o(303591);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(303594);
    if ((!this.KYu) || (this.KYA == null) || (this.KYB == null) || (this.KYA.getBounds().width() <= 0) || (this.KYB.getBounds().width() <= 0))
    {
      AppMethodBeat.o(303594);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label132:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.KYB.getBounds().left - this.KYx;
      f1 = Math.max(this.padding, this.KYB.getBounds().left - this.KYw);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label234;
      }
      bool = true;
      if (!paramBoolean) {
        break label240;
      }
      localRect = this.KYA.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.KYC), 0);
      this.KYA.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(303594);
      return bool;
      f1 = this.KYA.getBounds().right + this.KYx;
      f2 = Math.min(getWidth() - this.padding, this.KYA.getBounds().right + this.KYw);
      break;
      label234:
      bool = false;
      break label132;
      label240:
      localRect = this.KYB.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.KYB.setBounds(localRect);
    }
  }
  
  public void gcY()
  {
    AppMethodBeat.i(303599);
    this.KYA = new b(a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.KYB = new b(a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.KYS = true;
    postInvalidate();
    AppMethodBeat.o(303599);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.KYA.getBounds().right;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.KYB.getBounds().left;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void init()
  {
    AppMethodBeat.i(303588);
    this.KYC = a.fromDPToPix(getContext(), 8);
    this.KYD = (this.KYC * 0.5F);
    this.KYP = a.fromDPToPix(getContext(), 8);
    gcY();
    this.KYE = a.fromDPToPix(getContext(), 1);
    this.KYG = a.br(getContext(), a.c.video_segment_seekbar_recycler_view_height);
    this.KYF = -1.0F;
    this.KYH = new Paint();
    this.KYH.setColor(a.w(getContext(), a.b.BW_BG_100));
    this.KYH.setAlpha(102);
    this.KYJ = new Paint();
    this.KYJ.setColor(a.w(getContext(), a.b.BW_0));
    this.KYJ.setAlpha(102);
    this.uMn = new Paint();
    this.uMn.setColor(a.w(getContext(), a.b.BW_BG_100));
    this.uMn.setStyle(Paint.Style.STROKE);
    this.borderWidth = iS(getContext());
    this.uMn.setStrokeWidth(this.borderWidth);
    this.KYI = (this.borderWidth * 0.5F);
    this.KYK = new Paint();
    this.KYK.setColor(a.w(getContext(), a.b.BW_BG_100));
    this.KYK.setStyle(Paint.Style.STROKE);
    this.KYL = iS(getContext());
    this.KYM = (this.KYL * 0.5F);
    this.KYK.setStrokeWidth(this.KYL);
    this.KYK.setAlpha(178);
    setOnTouchListener(this.onTouchListener);
    AppMethodBeat.o(303588);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.KYF > 0.0F)
    {
      float f = getWidth() * this.KYF;
      paramCanvas.drawRect(f - this.KYE * 0.5F, 0.0F, this.KYE * 0.5F + f, getHeight(), this.KYH);
    }
    if (!this.KYu)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.KYA.getBounds().centerX();
    int j = this.KYB.getBounds().centerX();
    if (((yw(true)) || (yw(false))) && (this.KYS)) {
      paramCanvas.drawRect(this.padding + this.KYM, this.KYM, getWidth() - this.padding - this.KYM, getBottom() - this.KYM, this.KYK);
    }
    if (this.KYA.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.KYJ);
    }
    if (this.KYB.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.KYJ);
    }
    if (this.KYS)
    {
      paramCanvas.drawLine(i, this.KYI, j, this.KYI, this.uMn);
      paramCanvas.drawLine(i, getHeight() - this.KYI, j, getHeight() - this.KYI, this.uMn);
    }
    this.KYA.draw(paramCanvas);
    this.KYB.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.KYQ != null) && (this.KYR != null))
    {
      Rect localRect1 = new Rect(this.KYQ.left, this.KYQ.top, this.KYQ.right, this.KYQ.bottom);
      Rect localRect2 = new Rect(this.KYR.left, this.KYR.top, this.KYR.right, this.KYR.bottom);
      this.KYA.setBounds(localRect1);
      this.KYB.setBounds(localRect2);
      this.KYF = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorColor(int paramInt)
  {
    AppMethodBeat.i(303593);
    this.KYH.setColor(paramInt);
    AppMethodBeat.o(303593);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.KYu)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.KYF = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setCursorWidth(int paramInt)
  {
    this.KYE = paramInt;
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.KYz = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(303592);
    this.KYJ.setColor(paramInt);
    AppMethodBeat.o(303592);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.Lad = parama;
  }
  
  public static abstract interface a
  {
    public abstract void yA(boolean paramBoolean);
    
    public abstract void yx(boolean paramBoolean);
    
    public abstract void yy(boolean paramBoolean);
  }
  
  public final class b
    extends Drawable
  {
    private Drawable KYY;
    private Drawable KYZ;
    boolean isPressed = false;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.KYY = paramDrawable1;
      this.KYZ = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(94446);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.KYY;; localDrawable = this.KYZ)
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
      this.KYY.setAlpha(paramInt);
      this.KYZ.setAlpha(paramInt);
      AppMethodBeat.o(94447);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(94448);
      this.KYY.setColorFilter(paramColorFilter);
      this.KYZ.setColorFilter(paramColorFilter);
      AppMethodBeat.o(94448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
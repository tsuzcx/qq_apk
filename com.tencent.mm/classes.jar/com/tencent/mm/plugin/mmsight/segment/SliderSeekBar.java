package com.tencent.mm.plugin.mmsight.segment;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
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
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.g;

public class SliderSeekBar
  extends View
{
  private boolean FcL;
  boolean FcM;
  private int FcN;
  private int FcO;
  private boolean FcP;
  private boolean FcQ;
  protected Drawable FcR;
  protected Drawable FcS;
  protected int FcT;
  protected float FcU;
  private int FcV;
  private float FcW;
  private int FcX;
  private Paint FcY;
  private float FcZ;
  private Paint Fda;
  private Paint Fdb;
  private int Fdc;
  private float Fdd;
  private float Fde;
  private float Fdf;
  protected int Fdg;
  private Rect Fdh;
  private Rect Fdi;
  protected boolean Fdj;
  private a Feu;
  private View.OnTouchListener aIw;
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  
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
    AppMethodBeat.i(249732);
    this.FcL = false;
    this.FcM = false;
    this.FcP = false;
    this.FcQ = false;
    this.FcW = -1.0F;
    this.Fde = -1.0F;
    this.Fdf = -1.0F;
    this.padding = 0;
    this.Fdj = true;
    this.aIw = new View.OnTouchListener()
    {
      int Fdk = -1;
      int Fdl = -1;
      int Fdm;
      int Fdn;
      float dit;
      float diu;
      
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
          this.Fdn = 0;
          bool = false;
          if (this.Fdn < paramAnonymousMotionEvent.getPointerCount())
          {
            this.Fdm = paramAnonymousMotionEvent.getPointerId(this.Fdn);
            if ((this.Fdm == this.Fdk) || (this.Fdm == this.Fdl))
            {
              paramAnonymousView = SliderSeekBar.this;
              if (this.Fdm != this.Fdk) {
                break label301;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.Fdn));
              if ((SliderSeekBar.g(SliderSeekBar.this)) && (bool) && (!SliderSeekBar.h(SliderSeekBar.this))) {
                SliderSeekBar.this.performHapticFeedback(0, 2);
              }
              SliderSeekBar.b(SliderSeekBar.this, bool);
              if (SliderSeekBar.i(SliderSeekBar.this) != null)
              {
                paramAnonymousView = SliderSeekBar.i(SliderSeekBar.this);
                if (this.Fdm != this.Fdk) {
                  break label306;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              paramAnonymousView.un(bool);
              bool = true;
              this.Fdn += 1;
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
          this.Fdm = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label301:
          label306:
          if ((this.Fdm != this.Fdk) && (this.Fdm != this.Fdl))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).eUh();
          }
          paramAnonymousView = SliderSeekBar.this;
          if (this.Fdm == this.Fdk)
          {
            bool = true;
            SliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.Fdm != this.Fdk) {
              break label442;
            }
            this.Fdk = -1;
          }
          for (;;)
          {
            SliderSeekBar.b(SliderSeekBar.this, false);
            AppMethodBeat.o(94445);
            return true;
            bool = false;
            break;
            label442:
            this.Fdl = -1;
          }
        }
        this.Fdn = paramAnonymousMotionEvent.getActionIndex();
        this.Fdm = paramAnonymousMotionEvent.getPointerId(this.Fdn);
        this.dit = paramAnonymousMotionEvent.getX(this.Fdn);
        this.diu = paramAnonymousMotionEvent.getY(this.Fdn);
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.FcR, this.dit, this.diu))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, true))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).eUg();
          }
          this.Fdk = this.Fdm;
          SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.FcR.getBounds().left);
          SliderSeekBar.a(SliderSeekBar.this, true, true);
          AppMethodBeat.o(94445);
          return true;
        }
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.FcS, this.dit, this.diu))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, false))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).eUg();
          }
          this.Fdl = this.Fdm;
          SliderSeekBar.b(SliderSeekBar.this, SliderSeekBar.this.FcS.getBounds().right);
          SliderSeekBar.a(SliderSeekBar.this, false, true);
          AppMethodBeat.o(94445);
          return true;
        }
        AppMethodBeat.o(94445);
        return false;
      }
    };
    init();
    AppMethodBeat.o(249732);
  }
  
  private static int hx(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean ui(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = SliderSeekBar.b.a((SliderSeekBar.b)this.FcR);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = SliderSeekBar.b.a((SliderSeekBar.b)this.FcS);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void at(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(249736);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94444);
        if (paramInt1 <= SliderSeekBar.this.FcT * 2)
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
          SliderSeekBar.a(SliderSeekBar.this, new Rect(SliderSeekBar.this.FcR.getBounds().left, SliderSeekBar.this.FcR.getBounds().top, SliderSeekBar.this.FcR.getBounds().right, SliderSeekBar.this.FcR.getBounds().bottom));
          SliderSeekBar.b(SliderSeekBar.this, new Rect(SliderSeekBar.this.FcS.getBounds().left, SliderSeekBar.this.FcS.getBounds().top, SliderSeekBar.this.FcS.getBounds().right, SliderSeekBar.this.FcS.getBounds().bottom));
        }
        SliderSeekBar.this.invalidate();
        AppMethodBeat.o(94444);
      }
    });
    AppMethodBeat.o(249736);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(249742);
    if ((!this.FcL) || (this.FcR == null) || (this.FcS == null) || (this.FcR.getBounds().width() <= 0) || (this.FcS.getBounds().width() <= 0))
    {
      AppMethodBeat.o(249742);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label132:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.FcS.getBounds().left - this.FcO;
      f1 = Math.max(this.padding, this.FcS.getBounds().left - this.FcN);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label234;
      }
      bool = true;
      if (!paramBoolean) {
        break label240;
      }
      localRect = this.FcR.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.FcT), 0);
      this.FcR.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(249742);
      return bool;
      f1 = this.FcR.getBounds().right + this.FcO;
      f2 = Math.min(getWidth() - this.padding, this.FcR.getBounds().right + this.FcN);
      break;
      label234:
      bool = false;
      break label132;
      label240:
      localRect = this.FcS.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.FcS.setBounds(localRect);
    }
  }
  
  public final void eUi()
  {
    this.FcM = true;
  }
  
  public final void eUj()
  {
    this.FcM = false;
  }
  
  public void eUk()
  {
    AppMethodBeat.i(249744);
    this.FcR = new SliderSeekBar.b(this, a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.FcS = new SliderSeekBar.b(this, a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.Fdj = true;
    postInvalidate();
    AppMethodBeat.o(249744);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.FcR.getBounds().right;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.FcS.getBounds().left;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void init()
  {
    AppMethodBeat.i(249733);
    this.FcT = a.fromDPToPix(getContext(), 8);
    this.FcU = (this.FcT * 0.5F);
    this.Fdg = a.fromDPToPix(getContext(), 8);
    eUk();
    this.FcV = a.fromDPToPix(getContext(), 1);
    this.FcX = a.aY(getContext(), a.c.video_segment_seekbar_recycler_view_height);
    this.FcW = -1.0F;
    this.FcY = new Paint();
    this.FcY.setColor(a.w(getContext(), a.b.BW_BG_100));
    this.FcY.setAlpha(102);
    this.Fda = new Paint();
    this.Fda.setColor(a.w(getContext(), a.b.BW_0));
    this.Fda.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.w(getContext(), a.b.BW_BG_100));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.borderWidth = hx(getContext());
    this.borderPaint.setStrokeWidth(this.borderWidth);
    this.FcZ = (this.borderWidth * 0.5F);
    this.Fdb = new Paint();
    this.Fdb.setColor(a.w(getContext(), a.b.BW_BG_100));
    this.Fdb.setStyle(Paint.Style.STROKE);
    this.Fdc = hx(getContext());
    this.Fdd = (this.Fdc * 0.5F);
    this.Fdb.setStrokeWidth(this.Fdc);
    this.Fdb.setAlpha(178);
    setOnTouchListener(this.aIw);
    AppMethodBeat.o(249733);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.FcW > 0.0F)
    {
      float f = getWidth() * this.FcW;
      paramCanvas.drawRect(f - this.FcV * 0.5F, 0.0F, this.FcV * 0.5F + f, getHeight(), this.FcY);
    }
    if (!this.FcL)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.FcR.getBounds().centerX();
    int j = this.FcS.getBounds().centerX();
    if (((ui(true)) || (ui(false))) && (this.Fdj)) {
      paramCanvas.drawRect(this.padding + this.Fdd, this.Fdd, getWidth() - this.padding - this.Fdd, getBottom() - this.Fdd, this.Fdb);
    }
    if (this.FcR.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.Fda);
    }
    if (this.FcS.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.Fda);
    }
    if (this.Fdj)
    {
      paramCanvas.drawLine(i, this.FcZ, j, this.FcZ, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.FcZ, j, getHeight() - this.FcZ, this.borderPaint);
    }
    this.FcR.draw(paramCanvas);
    this.FcS.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.Fdh != null) && (this.Fdi != null))
    {
      Rect localRect1 = new Rect(this.Fdh.left, this.Fdh.top, this.Fdh.right, this.Fdh.bottom);
      Rect localRect2 = new Rect(this.Fdi.left, this.Fdi.top, this.Fdi.right, this.Fdi.bottom);
      this.FcR.setBounds(localRect1);
      this.FcS.setBounds(localRect2);
      this.FcW = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorColor(int paramInt)
  {
    AppMethodBeat.i(249740);
    this.FcY.setColor(paramInt);
    AppMethodBeat.o(249740);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.FcL)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.FcW = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setCursorWidth(int paramInt)
  {
    this.FcV = paramInt;
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.FcQ = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(249738);
    this.Fda.setColor(paramInt);
    AppMethodBeat.o(249738);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.Feu = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eUg();
    
    public abstract void eUh();
    
    public abstract void un(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
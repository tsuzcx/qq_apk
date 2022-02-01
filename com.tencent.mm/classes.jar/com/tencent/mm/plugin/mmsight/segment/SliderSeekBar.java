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
import com.tencent.mm.cb.a;

public class SliderSeekBar
  extends View
{
  private View.OnTouchListener aZa;
  private Paint borderPaint;
  private int padding;
  private int rc;
  protected float zxA;
  private int zxB;
  private float zxC;
  private int zxD;
  private Paint zxE;
  private float zxF;
  private Paint zxG;
  private Paint zxH;
  private int zxI;
  private float zxJ;
  private float zxK;
  private float zxL;
  protected int zxM;
  private Rect zxN;
  private Rect zxO;
  protected boolean zxP;
  private boolean zxr;
  boolean zxs;
  private int zxt;
  private int zxu;
  private boolean zxv;
  private boolean zxw;
  protected Drawable zxx;
  protected Drawable zxy;
  protected int zxz;
  private a zzA;
  
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
    AppMethodBeat.i(187064);
    this.zxr = false;
    this.zxs = false;
    this.zxv = false;
    this.zxw = false;
    this.zxC = -1.0F;
    this.zxK = -1.0F;
    this.zxL = -1.0F;
    this.padding = 0;
    this.zxP = true;
    this.aZa = new View.OnTouchListener()
    {
      float deo;
      float dep;
      int zxQ = -1;
      int zxR = -1;
      int zxS;
      int zxT;
      
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
          this.zxT = 0;
          bool = false;
          if (this.zxT < paramAnonymousMotionEvent.getPointerCount())
          {
            this.zxS = paramAnonymousMotionEvent.getPointerId(this.zxT);
            if ((this.zxS == this.zxQ) || (this.zxS == this.zxR))
            {
              paramAnonymousView = SliderSeekBar.this;
              if (this.zxS != this.zxQ) {
                break label301;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.zxT));
              if ((SliderSeekBar.g(SliderSeekBar.this)) && (bool) && (!SliderSeekBar.h(SliderSeekBar.this))) {
                SliderSeekBar.this.performHapticFeedback(0, 2);
              }
              SliderSeekBar.b(SliderSeekBar.this, bool);
              if (SliderSeekBar.i(SliderSeekBar.this) != null)
              {
                paramAnonymousView = SliderSeekBar.i(SliderSeekBar.this);
                if (this.zxS != this.zxQ) {
                  break label306;
                }
              }
            }
            for (bool = true;; bool = false)
            {
              paramAnonymousView.rj(bool);
              bool = true;
              this.zxT += 1;
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
          this.zxS = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label301:
          label306:
          if ((this.zxS != this.zxQ) && (this.zxS != this.zxR))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).ekz();
          }
          paramAnonymousView = SliderSeekBar.this;
          if (this.zxS == this.zxQ)
          {
            bool = true;
            SliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.zxS != this.zxQ) {
              break label442;
            }
            this.zxQ = -1;
          }
          for (;;)
          {
            SliderSeekBar.b(SliderSeekBar.this, false);
            AppMethodBeat.o(94445);
            return true;
            bool = false;
            break;
            label442:
            this.zxR = -1;
          }
        }
        this.zxT = paramAnonymousMotionEvent.getActionIndex();
        this.zxS = paramAnonymousMotionEvent.getPointerId(this.zxT);
        this.deo = paramAnonymousMotionEvent.getX(this.zxT);
        this.dep = paramAnonymousMotionEvent.getY(this.zxT);
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.zxx, this.deo, this.dep))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, true))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).eky();
          }
          this.zxQ = this.zxS;
          SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.zxx.getBounds().left);
          SliderSeekBar.a(SliderSeekBar.this, true, true);
          AppMethodBeat.o(94445);
          return true;
        }
        if (SliderSeekBar.a(SliderSeekBar.this, SliderSeekBar.this.zxy, this.deo, this.dep))
        {
          if (SliderSeekBar.a(SliderSeekBar.this, false))
          {
            AppMethodBeat.o(94445);
            return false;
          }
          if (SliderSeekBar.i(SliderSeekBar.this) != null) {
            SliderSeekBar.i(SliderSeekBar.this).eky();
          }
          this.zxR = this.zxS;
          SliderSeekBar.b(SliderSeekBar.this, SliderSeekBar.this.zxy.getBounds().right);
          SliderSeekBar.a(SliderSeekBar.this, false, true);
          AppMethodBeat.o(94445);
          return true;
        }
        AppMethodBeat.o(94445);
        return false;
      }
    };
    init();
    AppMethodBeat.o(187064);
  }
  
  private static int gz(Context paramContext)
  {
    AppMethodBeat.i(94450);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(94450);
    return i;
  }
  
  private boolean re(boolean paramBoolean)
  {
    AppMethodBeat.i(94453);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.zxx);
      AppMethodBeat.o(94453);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.zxy);
    AppMethodBeat.o(94453);
    return paramBoolean;
  }
  
  public final void ao(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    AppMethodBeat.i(187066);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(94444);
        if (paramInt1 <= SliderSeekBar.this.zxz * 2)
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
          SliderSeekBar.a(SliderSeekBar.this, new Rect(SliderSeekBar.this.zxx.getBounds().left, SliderSeekBar.this.zxx.getBounds().top, SliderSeekBar.this.zxx.getBounds().right, SliderSeekBar.this.zxx.getBounds().bottom));
          SliderSeekBar.b(SliderSeekBar.this, new Rect(SliderSeekBar.this.zxy.getBounds().left, SliderSeekBar.this.zxy.getBounds().top, SliderSeekBar.this.zxy.getBounds().right, SliderSeekBar.this.zxy.getBounds().bottom));
        }
        SliderSeekBar.this.invalidate();
        AppMethodBeat.o(94444);
      }
    });
    AppMethodBeat.o(187066);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(187069);
    if ((!this.zxr) || (this.zxx == null) || (this.zxy == null) || (this.zxx.getBounds().width() <= 0) || (this.zxy.getBounds().width() <= 0))
    {
      AppMethodBeat.o(187069);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label132:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.zxy.getBounds().left - this.zxu;
      f1 = Math.max(this.padding, this.zxy.getBounds().left - this.zxt);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label234;
      }
      bool = true;
      if (!paramBoolean) {
        break label240;
      }
      localRect = this.zxx.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.zxz), 0);
      this.zxx.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(187069);
      return bool;
      f1 = this.zxx.getBounds().right + this.zxu;
      f2 = Math.min(getWidth() - this.padding, this.zxx.getBounds().right + this.zxt);
      break;
      label234:
      bool = false;
      break label132;
      label240:
      localRect = this.zxy.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.zxy.setBounds(localRect);
    }
  }
  
  public final void ekA()
  {
    this.zxs = true;
  }
  
  public final void ekB()
  {
    this.zxs = false;
  }
  
  public void ekC()
  {
    AppMethodBeat.i(187070);
    this.zxx = new b(a.l(getContext(), 2131691693), a.l(getContext(), 2131691692));
    this.zxy = new b(a.l(getContext(), 2131691693), a.l(getContext(), 2131691692));
    this.zxP = true;
    postInvalidate();
    AppMethodBeat.o(187070);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(94454);
    int i = this.zxx.getBounds().right;
    AppMethodBeat.o(94454);
    return i;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(94455);
    int i = this.zxy.getBounds().left;
    AppMethodBeat.o(94455);
    return i;
  }
  
  protected void init()
  {
    AppMethodBeat.i(187065);
    this.zxz = a.fromDPToPix(getContext(), 8);
    this.zxA = (this.zxz * 0.5F);
    this.zxM = a.fromDPToPix(getContext(), 8);
    ekC();
    this.zxB = a.fromDPToPix(getContext(), 1);
    this.zxD = a.aG(getContext(), 2131167091);
    this.zxC = -1.0F;
    this.zxE = new Paint();
    this.zxE.setColor(a.n(getContext(), 2131099694));
    this.zxE.setAlpha(102);
    this.zxG = new Paint();
    this.zxG.setColor(a.n(getContext(), 2131099654));
    this.zxG.setAlpha(102);
    this.borderPaint = new Paint();
    this.borderPaint.setColor(a.n(getContext(), 2131099694));
    this.borderPaint.setStyle(Paint.Style.STROKE);
    this.rc = gz(getContext());
    this.borderPaint.setStrokeWidth(this.rc);
    this.zxF = (this.rc * 0.5F);
    this.zxH = new Paint();
    this.zxH.setColor(a.n(getContext(), 2131099694));
    this.zxH.setStyle(Paint.Style.STROKE);
    this.zxI = gz(getContext());
    this.zxJ = (this.zxI * 0.5F);
    this.zxH.setStrokeWidth(this.zxI);
    this.zxH.setAlpha(178);
    setOnTouchListener(this.aZa);
    AppMethodBeat.o(187065);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(94451);
    if (this.zxC > 0.0F)
    {
      float f = getWidth() * this.zxC;
      paramCanvas.drawRect(f - this.zxB * 0.5F, 0.0F, this.zxB * 0.5F + f, getHeight(), this.zxE);
    }
    if (!this.zxr)
    {
      AppMethodBeat.o(94451);
      return;
    }
    int i = this.zxx.getBounds().centerX();
    int j = this.zxy.getBounds().centerX();
    if (((re(true)) || (re(false))) && (this.zxP)) {
      paramCanvas.drawRect(this.padding + this.zxJ, this.zxJ, getWidth() - this.padding - this.zxJ, getBottom() - this.zxJ, this.zxH);
    }
    if (this.zxx.getBounds().left > 0) {
      paramCanvas.drawRect(0.0F, 0.0F, i, getHeight(), this.zxG);
    }
    if (this.zxy.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth(), getHeight(), this.zxG);
    }
    if (this.zxP)
    {
      paramCanvas.drawLine(i, this.zxF, j, this.zxF, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.zxF, j, getHeight() - this.zxF, this.borderPaint);
    }
    this.zxx.draw(paramCanvas);
    this.zxy.draw(paramCanvas);
    AppMethodBeat.o(94451);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(94456);
    if ((this.zxN != null) && (this.zxO != null))
    {
      Rect localRect1 = new Rect(this.zxN.left, this.zxN.top, this.zxN.right, this.zxN.bottom);
      Rect localRect2 = new Rect(this.zxO.left, this.zxO.top, this.zxO.right, this.zxO.bottom);
      this.zxx.setBounds(localRect1);
      this.zxy.setBounds(localRect2);
      this.zxC = 0.0F;
      postInvalidate();
    }
    AppMethodBeat.o(94456);
  }
  
  public void setCursorColor(int paramInt)
  {
    AppMethodBeat.i(187068);
    this.zxE.setColor(paramInt);
    AppMethodBeat.o(187068);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(94452);
    if (!this.zxr)
    {
      AppMethodBeat.o(94452);
      return;
    }
    this.zxC = paramFloat;
    invalidate();
    AppMethodBeat.o(94452);
  }
  
  public void setCursorWidth(int paramInt)
  {
    this.zxB = paramInt;
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.zxw = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(187067);
    this.zxG.setColor(paramInt);
    AppMethodBeat.o(187067);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.zzA = parama;
  }
  
  public static abstract interface a
  {
    public abstract void eky();
    
    public abstract void ekz();
    
    public abstract void rj(boolean paramBoolean);
  }
  
  public final class b
    extends Drawable
  {
    boolean isPressed = false;
    private Drawable zxV;
    private Drawable zxW;
    
    public b(Drawable paramDrawable1, Drawable paramDrawable2)
    {
      this.zxV = paramDrawable1;
      this.zxW = paramDrawable2;
      this.isPressed = false;
    }
    
    public final void draw(Canvas paramCanvas)
    {
      AppMethodBeat.i(94446);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.zxV;; localDrawable = this.zxW)
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
      this.zxV.setAlpha(paramInt);
      this.zxW.setAlpha(paramInt);
      AppMethodBeat.o(94447);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(94448);
      this.zxV.setColorFilter(paramColorFilter);
      this.zxW.setColorFilter(paramColorFilter);
      AppMethodBeat.o(94448);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.SliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
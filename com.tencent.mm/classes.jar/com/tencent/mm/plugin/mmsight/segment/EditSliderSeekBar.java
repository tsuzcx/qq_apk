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
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.g;

public class EditSliderSeekBar
  extends View
{
  private Drawable KYA;
  private Drawable KYB;
  private int KYC;
  private float KYD;
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
  private int KYP;
  private Rect KYQ;
  private Rect KYR;
  private boolean KYS;
  private a KYt;
  private boolean KYu;
  private boolean KYv;
  private int KYw;
  private int KYx;
  private boolean KYy;
  private boolean KYz;
  private int borderWidth;
  private View.OnTouchListener onTouchListener;
  private int padding;
  private Paint uMn;
  
  public EditSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(303595);
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
        AppMethodBeat.i(303578);
        if (!EditSliderSeekBar.a(EditSliderSeekBar.this))
        {
          AppMethodBeat.o(303578);
          return false;
        }
        boolean bool;
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        case 4: 
        default: 
          AppMethodBeat.o(303578);
          return false;
        case 2: 
          if ((!EditSliderSeekBar.a(EditSliderSeekBar.this, true)) && (!EditSliderSeekBar.a(EditSliderSeekBar.this, false)))
          {
            AppMethodBeat.o(303578);
            return false;
          }
          if (EditSliderSeekBar.b(EditSliderSeekBar.this))
          {
            AppMethodBeat.o(303578);
            return true;
          }
          this.KYW = 0;
          bool = false;
          if (this.KYW < paramAnonymousMotionEvent.getPointerCount())
          {
            this.KYV = paramAnonymousMotionEvent.getPointerId(this.KYW);
            if ((this.KYV == this.KYT) || (this.KYV == this.KYU))
            {
              paramAnonymousView = EditSliderSeekBar.this;
              if (this.KYV != this.KYT) {
                break label348;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.KYW));
              if ((EditSliderSeekBar.c(EditSliderSeekBar.this)) && (bool) && (!EditSliderSeekBar.d(EditSliderSeekBar.this))) {
                EditSliderSeekBar.this.performHapticFeedback(0, 2);
              }
              EditSliderSeekBar.b(EditSliderSeekBar.this, bool);
              if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null)
              {
                paramAnonymousView = new int[2];
                EditSliderSeekBar.this.getLocationOnScreen(paramAnonymousView);
                if (this.KYV != this.KYT) {
                  break label354;
                }
                bool = true;
                if (!bool) {
                  break label360;
                }
              }
            }
            for (float f = paramAnonymousView[0] + EditSliderSeekBar.this.getLeftSliderBound();; f = paramAnonymousView[0] + EditSliderSeekBar.this.getRightSliderBound())
            {
              EditSliderSeekBar.e(EditSliderSeekBar.this).c(bool, f + EditSliderSeekBar.f(EditSliderSeekBar.this));
              bool = true;
              this.KYW += 1;
              break;
              bool = false;
              break label193;
              bool = false;
              break label290;
            }
          }
          if (bool) {
            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          }
          AppMethodBeat.o(303578);
          return bool;
        case 1: 
        case 3: 
        case 6: 
          label193:
          label348:
          label354:
          label360:
          this.KYV = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label290:
          if ((this.KYV != this.KYT) && (this.KYV != this.KYU))
          {
            AppMethodBeat.o(303578);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null)
          {
            paramAnonymousView = EditSliderSeekBar.e(EditSliderSeekBar.this);
            if (this.KYV == this.KYT)
            {
              bool = true;
              paramAnonymousView.yy(bool);
            }
          }
          else
          {
            paramAnonymousView = EditSliderSeekBar.this;
            if (this.KYV != this.KYT) {
              break label570;
            }
            bool = true;
            label507:
            EditSliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.KYV != this.KYT) {
              break label576;
            }
            this.KYT = -1;
          }
          for (;;)
          {
            EditSliderSeekBar.b(EditSliderSeekBar.this, false);
            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(303578);
            return true;
            bool = false;
            break;
            label570:
            bool = false;
            break label507;
            label576:
            this.KYU = -1;
          }
        }
        this.KYW = paramAnonymousMotionEvent.getActionIndex();
        this.KYV = paramAnonymousMotionEvent.getPointerId(this.KYW);
        this.fif = paramAnonymousMotionEvent.getX(this.KYW);
        this.fig = paramAnonymousMotionEvent.getY(this.KYW);
        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.g(EditSliderSeekBar.this), this.fif, this.fig))
        {
          if (EditSliderSeekBar.a(EditSliderSeekBar.this, true))
          {
            AppMethodBeat.o(303578);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null) {
            EditSliderSeekBar.e(EditSliderSeekBar.this).yx(true);
          }
          this.KYT = this.KYV;
          EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.g(EditSliderSeekBar.this).getBounds().left);
          EditSliderSeekBar.a(EditSliderSeekBar.this, true, true);
          EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          AppMethodBeat.o(303578);
          return true;
        }
        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.h(EditSliderSeekBar.this), this.fif, this.fig))
        {
          if (EditSliderSeekBar.a(EditSliderSeekBar.this, false))
          {
            AppMethodBeat.o(303578);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null) {
            EditSliderSeekBar.e(EditSliderSeekBar.this).yx(false);
          }
          this.KYU = this.KYV;
          EditSliderSeekBar.b(EditSliderSeekBar.this, EditSliderSeekBar.h(EditSliderSeekBar.this).getBounds().right);
          EditSliderSeekBar.a(EditSliderSeekBar.this, false, true);
          EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          AppMethodBeat.o(303578);
          return true;
        }
        AppMethodBeat.o(303578);
        return false;
      }
    };
    this.KYC = a.fromDPToPix(getContext(), 8);
    this.KYD = (this.KYC * 0.5F);
    this.KYP = a.fromDPToPix(getContext(), 8);
    this.KYA = new b(a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.KYB = new b(a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.KYS = true;
    postInvalidate();
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
    AppMethodBeat.o(303595);
  }
  
  private static int iS(Context paramContext)
  {
    AppMethodBeat.i(303596);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(303596);
    return i;
  }
  
  private boolean yw(boolean paramBoolean)
  {
    AppMethodBeat.i(303597);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.KYA);
      AppMethodBeat.o(303597);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.KYB);
    AppMethodBeat.o(303597);
    return paramBoolean;
  }
  
  public final void aR(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(303612);
    if (paramInt1 <= this.KYC * 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
      AppMethodBeat.o(303612);
      throw localIllegalStateException;
    }
    this.KYu = true;
    this.padding = paramInt3;
    this.KYw = paramInt1;
    this.KYx = paramInt2;
    this.KYA.setBounds(this.padding - this.KYC, 0, this.padding, getHeight());
    this.KYB.setBounds(this.padding + this.KYw, 0, this.KYw + this.padding + this.KYC, getHeight());
    if ((this.KYQ == null) && (this.KYR == null))
    {
      this.KYQ = new Rect(this.KYA.getBounds().left, this.KYA.getBounds().top, this.KYA.getBounds().right, this.KYA.getBounds().bottom);
      this.KYR = new Rect(this.KYB.getBounds().left, this.KYB.getBounds().top, this.KYB.getBounds().right, this.KYB.getBounds().bottom);
    }
    invalidate();
    AppMethodBeat.o(303612);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(303615);
    if ((!this.KYu) || (this.KYA == null) || (this.KYB == null) || (this.KYA.getBounds().width() <= 0) || (this.KYB.getBounds().width() <= 0))
    {
      AppMethodBeat.o(303615);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label134:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.KYB.getBounds().left - this.KYx;
      f1 = Math.max(this.padding, this.KYB.getBounds().left - this.KYw);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label237;
      }
      bool = true;
      if (!paramBoolean) {
        break label243;
      }
      localRect = this.KYA.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.KYC), 0);
      this.KYA.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(303615);
      return bool;
      f1 = this.KYA.getBounds().right + this.KYx;
      f2 = Math.min(this.padding + this.KYw, this.KYA.getBounds().right + this.KYw);
      break;
      label237:
      bool = false;
      break label134;
      label243:
      localRect = this.KYB.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.KYB.setBounds(localRect);
    }
  }
  
  public final void gcN()
  {
    AppMethodBeat.i(303613);
    this.KYu = false;
    this.KYw = 0;
    this.KYx = 0;
    this.KYA.setBounds(0, 0, 0, 0);
    this.KYB.setBounds(0, 0, 0, 0);
    invalidate();
    AppMethodBeat.o(303613);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(303616);
    int i = this.KYA.getBounds().right;
    int j = this.padding;
    AppMethodBeat.o(303616);
    return i - j;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(303617);
    int i = this.KYB.getBounds().left;
    int j = this.padding;
    AppMethodBeat.o(303617);
    return i - j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(303609);
    if (this.KYF > 0.0F)
    {
      float f = getWidth() * this.KYF;
      paramCanvas.drawRect(f - this.KYE * 0.5F, 0.0F, this.KYE * 0.5F + f, getHeight(), this.KYH);
    }
    if (!this.KYu)
    {
      AppMethodBeat.o(303609);
      return;
    }
    int i = this.KYA.getBounds().centerX();
    int j = this.KYB.getBounds().centerX();
    if (((yw(true)) || (yw(false))) && (this.KYS)) {
      paramCanvas.drawRect(this.padding + this.KYM, this.KYM, getWidth() - this.padding - this.KYM, getBottom() - this.KYM, this.KYK);
    }
    if (this.KYA.getBounds().left > 0) {
      paramCanvas.drawRect(this.padding, 0.0F, i, getHeight(), this.KYJ);
    }
    if (this.KYB.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth() - this.padding, getHeight(), this.KYJ);
    }
    if (this.KYS)
    {
      paramCanvas.drawLine(i, this.KYI, j, this.KYI, this.uMn);
      paramCanvas.drawLine(i, getHeight() - this.KYI, j, getHeight() - this.KYI, this.uMn);
    }
    this.KYA.draw(paramCanvas);
    this.KYB.draw(paramCanvas);
    AppMethodBeat.o(303609);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(303610);
    if (!this.KYu)
    {
      AppMethodBeat.o(303610);
      return;
    }
    this.KYF = paramFloat;
    invalidate();
    AppMethodBeat.o(303610);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.KYz = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(303614);
    this.KYJ.setColor(paramInt);
    AppMethodBeat.o(303614);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.KYt = parama;
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean, float paramFloat);
    
    public abstract void yx(boolean paramBoolean);
    
    public abstract void yy(boolean paramBoolean);
  }
  
  final class b
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
      AppMethodBeat.i(303581);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.KYY;; localDrawable = this.KYZ)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(303581);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(303583);
      this.KYY.setAlpha(paramInt);
      this.KYZ.setAlpha(paramInt);
      AppMethodBeat.o(303583);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(303584);
      this.KYY.setColorFilter(paramColorFilter);
      this.KYZ.setColorFilter(paramColorFilter);
      AppMethodBeat.o(303584);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
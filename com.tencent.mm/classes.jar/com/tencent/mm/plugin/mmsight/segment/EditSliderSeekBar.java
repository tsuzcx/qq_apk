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
import com.tencent.mm.cb.a;

public class EditSliderSeekBar
  extends View
{
  private View.OnTouchListener aZa;
  private Paint borderPaint;
  private int padding;
  private int rc;
  private float zxA;
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
  private int zxM;
  private Rect zxN;
  private Rect zxO;
  private boolean zxP;
  private a zxq;
  private boolean zxr;
  private boolean zxs;
  private int zxt;
  private int zxu;
  private boolean zxv;
  private boolean zxw;
  private Drawable zxx;
  private Drawable zxy;
  private int zxz;
  
  public EditSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(187049);
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
        AppMethodBeat.i(187045);
        if (!EditSliderSeekBar.a(EditSliderSeekBar.this))
        {
          AppMethodBeat.o(187045);
          return false;
        }
        boolean bool;
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        case 4: 
        default: 
          AppMethodBeat.o(187045);
          return false;
        case 2: 
          if ((!EditSliderSeekBar.a(EditSliderSeekBar.this, true)) && (!EditSliderSeekBar.a(EditSliderSeekBar.this, false)))
          {
            AppMethodBeat.o(187045);
            return false;
          }
          if (EditSliderSeekBar.b(EditSliderSeekBar.this))
          {
            AppMethodBeat.o(187045);
            return true;
          }
          this.zxT = 0;
          bool = false;
          if (this.zxT < paramAnonymousMotionEvent.getPointerCount())
          {
            this.zxS = paramAnonymousMotionEvent.getPointerId(this.zxT);
            if ((this.zxS == this.zxQ) || (this.zxS == this.zxR))
            {
              paramAnonymousView = EditSliderSeekBar.this;
              if (this.zxS != this.zxQ) {
                break label348;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.zxT));
              if ((EditSliderSeekBar.c(EditSliderSeekBar.this)) && (bool) && (!EditSliderSeekBar.d(EditSliderSeekBar.this))) {
                EditSliderSeekBar.this.performHapticFeedback(0, 2);
              }
              EditSliderSeekBar.b(EditSliderSeekBar.this, bool);
              if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null)
              {
                paramAnonymousView = new int[2];
                EditSliderSeekBar.this.getLocationOnScreen(paramAnonymousView);
                if (this.zxS != this.zxQ) {
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
              this.zxT += 1;
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
          AppMethodBeat.o(187045);
          return bool;
        case 1: 
        case 3: 
        case 6: 
          label193:
          label348:
          label354:
          label360:
          this.zxS = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label290:
          if ((this.zxS != this.zxQ) && (this.zxS != this.zxR))
          {
            AppMethodBeat.o(187045);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null)
          {
            paramAnonymousView = EditSliderSeekBar.e(EditSliderSeekBar.this);
            if (this.zxS == this.zxQ)
            {
              bool = true;
              paramAnonymousView.rg(bool);
            }
          }
          else
          {
            paramAnonymousView = EditSliderSeekBar.this;
            if (this.zxS != this.zxQ) {
              break label570;
            }
            bool = true;
            label507:
            EditSliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.zxS != this.zxQ) {
              break label576;
            }
            this.zxQ = -1;
          }
          for (;;)
          {
            EditSliderSeekBar.b(EditSliderSeekBar.this, false);
            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(187045);
            return true;
            bool = false;
            break;
            label570:
            bool = false;
            break label507;
            label576:
            this.zxR = -1;
          }
        }
        this.zxT = paramAnonymousMotionEvent.getActionIndex();
        this.zxS = paramAnonymousMotionEvent.getPointerId(this.zxT);
        this.deo = paramAnonymousMotionEvent.getX(this.zxT);
        this.dep = paramAnonymousMotionEvent.getY(this.zxT);
        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.g(EditSliderSeekBar.this), this.deo, this.dep))
        {
          if (EditSliderSeekBar.a(EditSliderSeekBar.this, true))
          {
            AppMethodBeat.o(187045);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null) {
            EditSliderSeekBar.e(EditSliderSeekBar.this).rf(true);
          }
          this.zxQ = this.zxS;
          EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.g(EditSliderSeekBar.this).getBounds().left);
          EditSliderSeekBar.a(EditSliderSeekBar.this, true, true);
          EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          AppMethodBeat.o(187045);
          return true;
        }
        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.h(EditSliderSeekBar.this), this.deo, this.dep))
        {
          if (EditSliderSeekBar.a(EditSliderSeekBar.this, false))
          {
            AppMethodBeat.o(187045);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null) {
            EditSliderSeekBar.e(EditSliderSeekBar.this).rf(false);
          }
          this.zxR = this.zxS;
          EditSliderSeekBar.b(EditSliderSeekBar.this, EditSliderSeekBar.h(EditSliderSeekBar.this).getBounds().right);
          EditSliderSeekBar.a(EditSliderSeekBar.this, false, true);
          EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          AppMethodBeat.o(187045);
          return true;
        }
        AppMethodBeat.o(187045);
        return false;
      }
    };
    this.zxz = a.fromDPToPix(getContext(), 8);
    this.zxA = (this.zxz * 0.5F);
    this.zxM = a.fromDPToPix(getContext(), 8);
    this.zxx = new b(a.l(getContext(), 2131691693), a.l(getContext(), 2131691692));
    this.zxy = new b(a.l(getContext(), 2131691693), a.l(getContext(), 2131691692));
    this.zxP = true;
    postInvalidate();
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
    AppMethodBeat.o(187049);
  }
  
  private static int gz(Context paramContext)
  {
    AppMethodBeat.i(187050);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(187050);
    return i;
  }
  
  private boolean re(boolean paramBoolean)
  {
    AppMethodBeat.i(187056);
    if (paramBoolean)
    {
      paramBoolean = b.a((b)this.zxx);
      AppMethodBeat.o(187056);
      return paramBoolean;
    }
    paramBoolean = b.a((b)this.zxy);
    AppMethodBeat.o(187056);
    return paramBoolean;
  }
  
  public final void ao(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(187053);
    if (paramInt1 <= this.zxz * 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
      AppMethodBeat.o(187053);
      throw localIllegalStateException;
    }
    this.zxr = true;
    this.padding = paramInt3;
    this.zxt = paramInt1;
    this.zxu = paramInt2;
    this.zxx.setBounds(this.padding - this.zxz, 0, this.padding, getHeight());
    this.zxy.setBounds(this.padding + this.zxt, 0, this.zxt + this.padding + this.zxz, getHeight());
    if ((this.zxN == null) && (this.zxO == null))
    {
      this.zxN = new Rect(this.zxx.getBounds().left, this.zxx.getBounds().top, this.zxx.getBounds().right, this.zxx.getBounds().bottom);
      this.zxO = new Rect(this.zxy.getBounds().left, this.zxy.getBounds().top, this.zxy.getBounds().right, this.zxy.getBounds().bottom);
    }
    invalidate();
    AppMethodBeat.o(187053);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(187057);
    if ((!this.zxr) || (this.zxx == null) || (this.zxy == null) || (this.zxx.getBounds().width() <= 0) || (this.zxy.getBounds().width() <= 0))
    {
      AppMethodBeat.o(187057);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label134:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.zxy.getBounds().left - this.zxu;
      f1 = Math.max(this.padding, this.zxy.getBounds().left - this.zxt);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label237;
      }
      bool = true;
      if (!paramBoolean) {
        break label243;
      }
      localRect = this.zxx.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.zxz), 0);
      this.zxx.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(187057);
      return bool;
      f1 = this.zxx.getBounds().right + this.zxu;
      f2 = Math.min(this.padding + this.zxt, this.zxx.getBounds().right + this.zxt);
      break;
      label237:
      bool = false;
      break label134;
      label243:
      localRect = this.zxy.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.zxy.setBounds(localRect);
    }
  }
  
  public final void ekn()
  {
    AppMethodBeat.i(187054);
    this.zxr = false;
    this.zxt = 0;
    this.zxu = 0;
    this.zxx.setBounds(0, 0, 0, 0);
    this.zxy.setBounds(0, 0, 0, 0);
    invalidate();
    AppMethodBeat.o(187054);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(187058);
    int i = this.zxx.getBounds().right;
    int j = this.padding;
    AppMethodBeat.o(187058);
    return i - j;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(187059);
    int i = this.zxy.getBounds().left;
    int j = this.padding;
    AppMethodBeat.o(187059);
    return i - j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(187051);
    if (this.zxC > 0.0F)
    {
      float f = getWidth() * this.zxC;
      paramCanvas.drawRect(f - this.zxB * 0.5F, 0.0F, this.zxB * 0.5F + f, getHeight(), this.zxE);
    }
    if (!this.zxr)
    {
      AppMethodBeat.o(187051);
      return;
    }
    int i = this.zxx.getBounds().centerX();
    int j = this.zxy.getBounds().centerX();
    if (((re(true)) || (re(false))) && (this.zxP)) {
      paramCanvas.drawRect(this.padding + this.zxJ, this.zxJ, getWidth() - this.padding - this.zxJ, getBottom() - this.zxJ, this.zxH);
    }
    if (this.zxx.getBounds().left > 0) {
      paramCanvas.drawRect(this.padding, 0.0F, i, getHeight(), this.zxG);
    }
    if (this.zxy.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth() - this.padding, getHeight(), this.zxG);
    }
    if (this.zxP)
    {
      paramCanvas.drawLine(i, this.zxF, j, this.zxF, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.zxF, j, getHeight() - this.zxF, this.borderPaint);
    }
    this.zxx.draw(paramCanvas);
    this.zxy.draw(paramCanvas);
    AppMethodBeat.o(187051);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(187052);
    if (!this.zxr)
    {
      AppMethodBeat.o(187052);
      return;
    }
    this.zxC = paramFloat;
    invalidate();
    AppMethodBeat.o(187052);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.zxw = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(187055);
    this.zxG.setColor(paramInt);
    AppMethodBeat.o(187055);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.zxq = parama;
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean, float paramFloat);
    
    public abstract void rf(boolean paramBoolean);
    
    public abstract void rg(boolean paramBoolean);
  }
  
  final class b
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
      AppMethodBeat.i(187046);
      if (this.isPressed) {}
      for (Drawable localDrawable = this.zxV;; localDrawable = this.zxW)
      {
        if (!getBounds().equals(localDrawable.getBounds())) {
          localDrawable.setBounds(getBounds());
        }
        localDrawable.draw(paramCanvas);
        AppMethodBeat.o(187046);
        return;
      }
    }
    
    public final int getOpacity()
    {
      return -3;
    }
    
    public final void setAlpha(int paramInt)
    {
      AppMethodBeat.i(187047);
      this.zxV.setAlpha(paramInt);
      this.zxW.setAlpha(paramInt);
      AppMethodBeat.o(187047);
    }
    
    public final void setColorFilter(ColorFilter paramColorFilter)
    {
      AppMethodBeat.i(187048);
      this.zxV.setColorFilter(paramColorFilter);
      this.zxW.setColorFilter(paramColorFilter);
      AppMethodBeat.o(187048);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
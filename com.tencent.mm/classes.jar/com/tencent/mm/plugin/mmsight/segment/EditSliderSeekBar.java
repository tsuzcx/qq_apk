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
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.plugin.w.a.b;
import com.tencent.mm.plugin.w.a.c;
import com.tencent.mm.plugin.w.a.g;

public class EditSliderSeekBar
  extends View
{
  private a FcK;
  private boolean FcL;
  private boolean FcM;
  private int FcN;
  private int FcO;
  private boolean FcP;
  private boolean FcQ;
  private Drawable FcR;
  private Drawable FcS;
  private int FcT;
  private float FcU;
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
  private int Fdg;
  private Rect Fdh;
  private Rect Fdi;
  private boolean Fdj;
  private View.OnTouchListener aIw;
  private Paint borderPaint;
  private int borderWidth;
  private int padding;
  
  public EditSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public EditSliderSeekBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(249596);
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
        AppMethodBeat.i(249675);
        if (!EditSliderSeekBar.a(EditSliderSeekBar.this))
        {
          AppMethodBeat.o(249675);
          return false;
        }
        boolean bool;
        switch (paramAnonymousMotionEvent.getActionMasked())
        {
        case 4: 
        default: 
          AppMethodBeat.o(249675);
          return false;
        case 2: 
          if ((!EditSliderSeekBar.a(EditSliderSeekBar.this, true)) && (!EditSliderSeekBar.a(EditSliderSeekBar.this, false)))
          {
            AppMethodBeat.o(249675);
            return false;
          }
          if (EditSliderSeekBar.b(EditSliderSeekBar.this))
          {
            AppMethodBeat.o(249675);
            return true;
          }
          this.Fdn = 0;
          bool = false;
          if (this.Fdn < paramAnonymousMotionEvent.getPointerCount())
          {
            this.Fdm = paramAnonymousMotionEvent.getPointerId(this.Fdn);
            if ((this.Fdm == this.Fdk) || (this.Fdm == this.Fdl))
            {
              paramAnonymousView = EditSliderSeekBar.this;
              if (this.Fdm != this.Fdk) {
                break label348;
              }
              bool = true;
              bool = paramAnonymousView.b(bool, paramAnonymousMotionEvent.getX(this.Fdn));
              if ((EditSliderSeekBar.c(EditSliderSeekBar.this)) && (bool) && (!EditSliderSeekBar.d(EditSliderSeekBar.this))) {
                EditSliderSeekBar.this.performHapticFeedback(0, 2);
              }
              EditSliderSeekBar.b(EditSliderSeekBar.this, bool);
              if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null)
              {
                paramAnonymousView = new int[2];
                EditSliderSeekBar.this.getLocationOnScreen(paramAnonymousView);
                if (this.Fdm != this.Fdk) {
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
              this.Fdn += 1;
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
          AppMethodBeat.o(249675);
          return bool;
        case 1: 
        case 3: 
        case 6: 
          label193:
          label348:
          label354:
          label360:
          this.Fdm = paramAnonymousMotionEvent.getPointerId(paramAnonymousMotionEvent.getActionIndex());
          label290:
          if ((this.Fdm != this.Fdk) && (this.Fdm != this.Fdl))
          {
            AppMethodBeat.o(249675);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null)
          {
            paramAnonymousView = EditSliderSeekBar.e(EditSliderSeekBar.this);
            if (this.Fdm == this.Fdk)
            {
              bool = true;
              paramAnonymousView.uk(bool);
            }
          }
          else
          {
            paramAnonymousView = EditSliderSeekBar.this;
            if (this.Fdm != this.Fdk) {
              break label570;
            }
            bool = true;
            label507:
            EditSliderSeekBar.a(paramAnonymousView, bool, false);
            if (this.Fdm != this.Fdk) {
              break label576;
            }
            this.Fdk = -1;
          }
          for (;;)
          {
            EditSliderSeekBar.b(EditSliderSeekBar.this, false);
            EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(false);
            AppMethodBeat.o(249675);
            return true;
            bool = false;
            break;
            label570:
            bool = false;
            break label507;
            label576:
            this.Fdl = -1;
          }
        }
        this.Fdn = paramAnonymousMotionEvent.getActionIndex();
        this.Fdm = paramAnonymousMotionEvent.getPointerId(this.Fdn);
        this.dit = paramAnonymousMotionEvent.getX(this.Fdn);
        this.diu = paramAnonymousMotionEvent.getY(this.Fdn);
        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.g(EditSliderSeekBar.this), this.dit, this.diu))
        {
          if (EditSliderSeekBar.a(EditSliderSeekBar.this, true))
          {
            AppMethodBeat.o(249675);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null) {
            EditSliderSeekBar.e(EditSliderSeekBar.this).uj(true);
          }
          this.Fdk = this.Fdm;
          EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.g(EditSliderSeekBar.this).getBounds().left);
          EditSliderSeekBar.a(EditSliderSeekBar.this, true, true);
          EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          AppMethodBeat.o(249675);
          return true;
        }
        if (EditSliderSeekBar.a(EditSliderSeekBar.this, EditSliderSeekBar.h(EditSliderSeekBar.this), this.dit, this.diu))
        {
          if (EditSliderSeekBar.a(EditSliderSeekBar.this, false))
          {
            AppMethodBeat.o(249675);
            return false;
          }
          if (EditSliderSeekBar.e(EditSliderSeekBar.this) != null) {
            EditSliderSeekBar.e(EditSliderSeekBar.this).uj(false);
          }
          this.Fdl = this.Fdm;
          EditSliderSeekBar.b(EditSliderSeekBar.this, EditSliderSeekBar.h(EditSliderSeekBar.this).getBounds().right);
          EditSliderSeekBar.a(EditSliderSeekBar.this, false, true);
          EditSliderSeekBar.this.getParent().getParent().requestDisallowInterceptTouchEvent(true);
          AppMethodBeat.o(249675);
          return true;
        }
        AppMethodBeat.o(249675);
        return false;
      }
    };
    this.FcT = a.fromDPToPix(getContext(), 8);
    this.FcU = (this.FcT * 0.5F);
    this.Fdg = a.fromDPToPix(getContext(), 8);
    this.FcR = new EditSliderSeekBar.b(this, a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.FcS = new EditSliderSeekBar.b(this, a.m(getContext(), a.g.video_clip_slider_selected), a.m(getContext(), a.g.video_clip_slider_normal));
    this.Fdj = true;
    postInvalidate();
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
    AppMethodBeat.o(249596);
  }
  
  private static int hx(Context paramContext)
  {
    AppMethodBeat.i(249597);
    int i = Math.round(TypedValue.applyDimension(1, 1.5F, paramContext.getResources().getDisplayMetrics()));
    AppMethodBeat.o(249597);
    return i;
  }
  
  private boolean ui(boolean paramBoolean)
  {
    AppMethodBeat.i(249611);
    if (paramBoolean)
    {
      paramBoolean = EditSliderSeekBar.b.a((EditSliderSeekBar.b)this.FcR);
      AppMethodBeat.o(249611);
      return paramBoolean;
    }
    paramBoolean = EditSliderSeekBar.b.a((EditSliderSeekBar.b)this.FcS);
    AppMethodBeat.o(249611);
    return paramBoolean;
  }
  
  public final void at(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(249604);
    if (paramInt1 <= this.FcT * 2)
    {
      IllegalStateException localIllegalStateException = new IllegalStateException("MaxExtent can not less than sliderWidth * 2");
      AppMethodBeat.o(249604);
      throw localIllegalStateException;
    }
    this.FcL = true;
    this.padding = paramInt3;
    this.FcN = paramInt1;
    this.FcO = paramInt2;
    this.FcR.setBounds(this.padding - this.FcT, 0, this.padding, getHeight());
    this.FcS.setBounds(this.padding + this.FcN, 0, this.FcN + this.padding + this.FcT, getHeight());
    if ((this.Fdh == null) && (this.Fdi == null))
    {
      this.Fdh = new Rect(this.FcR.getBounds().left, this.FcR.getBounds().top, this.FcR.getBounds().right, this.FcR.getBounds().bottom);
      this.Fdi = new Rect(this.FcS.getBounds().left, this.FcS.getBounds().top, this.FcS.getBounds().right, this.FcS.getBounds().bottom);
    }
    invalidate();
    AppMethodBeat.o(249604);
  }
  
  public final boolean b(boolean paramBoolean, float paramFloat)
  {
    AppMethodBeat.i(249612);
    if ((!this.FcL) || (this.FcR == null) || (this.FcS == null) || (this.FcR.getBounds().width() <= 0) || (this.FcS.getBounds().width() <= 0))
    {
      AppMethodBeat.o(249612);
      return false;
    }
    float f2;
    float f1;
    boolean bool;
    label134:
    Rect localRect;
    if (paramBoolean)
    {
      f2 = this.FcS.getBounds().left - this.FcO;
      f1 = Math.max(this.padding, this.FcS.getBounds().left - this.FcN);
      paramFloat = Math.max(f1, Math.min(paramFloat, f2));
      if ((paramFloat != f1) && (paramFloat != f2)) {
        break label237;
      }
      bool = true;
      if (!paramBoolean) {
        break label243;
      }
      localRect = this.FcR.getBounds();
      localRect.offsetTo((int)Math.ceil(paramFloat - this.FcT), 0);
      this.FcR.setBounds(localRect);
    }
    for (;;)
    {
      postInvalidate();
      AppMethodBeat.o(249612);
      return bool;
      f1 = this.FcR.getBounds().right + this.FcO;
      f2 = Math.min(this.padding + this.FcN, this.FcR.getBounds().right + this.FcN);
      break;
      label237:
      bool = false;
      break label134;
      label243:
      localRect = this.FcS.getBounds();
      localRect.offsetTo((int)Math.floor(paramFloat), 0);
      this.FcS.setBounds(localRect);
    }
  }
  
  public final void eTV()
  {
    AppMethodBeat.i(249606);
    this.FcL = false;
    this.FcN = 0;
    this.FcO = 0;
    this.FcR.setBounds(0, 0, 0, 0);
    this.FcS.setBounds(0, 0, 0, 0);
    invalidate();
    AppMethodBeat.o(249606);
  }
  
  public int getLeftSliderBound()
  {
    AppMethodBeat.i(249613);
    int i = this.FcR.getBounds().right;
    int j = this.padding;
    AppMethodBeat.o(249613);
    return i - j;
  }
  
  public int getRightSliderBound()
  {
    AppMethodBeat.i(249614);
    int i = this.FcS.getBounds().left;
    int j = this.padding;
    AppMethodBeat.o(249614);
    return i - j;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(249600);
    if (this.FcW > 0.0F)
    {
      float f = getWidth() * this.FcW;
      paramCanvas.drawRect(f - this.FcV * 0.5F, 0.0F, this.FcV * 0.5F + f, getHeight(), this.FcY);
    }
    if (!this.FcL)
    {
      AppMethodBeat.o(249600);
      return;
    }
    int i = this.FcR.getBounds().centerX();
    int j = this.FcS.getBounds().centerX();
    if (((ui(true)) || (ui(false))) && (this.Fdj)) {
      paramCanvas.drawRect(this.padding + this.Fdd, this.Fdd, getWidth() - this.padding - this.Fdd, getBottom() - this.Fdd, this.Fdb);
    }
    if (this.FcR.getBounds().left > 0) {
      paramCanvas.drawRect(this.padding, 0.0F, i, getHeight(), this.Fda);
    }
    if (this.FcS.getBounds().right < getWidth()) {
      paramCanvas.drawRect(j, 0.0F, getWidth() - this.padding, getHeight(), this.Fda);
    }
    if (this.Fdj)
    {
      paramCanvas.drawLine(i, this.FcZ, j, this.FcZ, this.borderPaint);
      paramCanvas.drawLine(i, getHeight() - this.FcZ, j, getHeight() - this.FcZ, this.borderPaint);
    }
    this.FcR.draw(paramCanvas);
    this.FcS.draw(paramCanvas);
    AppMethodBeat.o(249600);
  }
  
  public void setCursorPos(float paramFloat)
  {
    AppMethodBeat.i(249603);
    if (!this.FcL)
    {
      AppMethodBeat.o(249603);
      return;
    }
    this.FcW = paramFloat;
    invalidate();
    AppMethodBeat.o(249603);
  }
  
  public void setEnableHapticAtEdge(boolean paramBoolean)
  {
    this.FcQ = paramBoolean;
  }
  
  public void setMaskColor(int paramInt)
  {
    AppMethodBeat.i(249608);
    this.Fda.setColor(paramInt);
    AppMethodBeat.o(249608);
  }
  
  public void setOnSliderTouchListener(a parama)
  {
    this.FcK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void c(boolean paramBoolean, float paramFloat);
    
    public abstract void uj(boolean paramBoolean);
    
    public abstract void uk(boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.EditSliderSeekBar
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.w.g;
import com.tencent.mm.sdk.platformtools.ac;

public class WxaScrollView
  extends FrameLayout
  implements r, s, g
{
  private float kpJ;
  private float[] kpK;
  private float kpL;
  private int kpM;
  private Paint kpN;
  private FrameLayout kqg;
  private ScrollView kqh;
  private q kqi;
  private boolean kqj;
  private boolean kqk;
  private int mBgColor;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137552);
    this.kqj = true;
    this.kqk = true;
    this.kpN = new Paint();
    init();
    AppMethodBeat.o(137552);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137553);
    this.kqj = true;
    this.kqk = true;
    this.kpN = new Paint();
    init();
    AppMethodBeat.o(137553);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137554);
    this.kqj = true;
    this.kqk = true;
    this.kpN = new Paint();
    init();
    AppMethodBeat.o(137554);
  }
  
  private Drawable getShadowDrawable()
  {
    AppMethodBeat.i(206802);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    if (this.mBgColor != 0) {
      localGradientDrawable.setColor(this.mBgColor);
    }
    if ((this.kpK != null) && (this.kpK.length > 3)) {
      localGradientDrawable.setCornerRadii(new float[] { this.kpK[0], this.kpK[0], this.kpK[1], this.kpK[1], this.kpK[3], this.kpK[3], this.kpK[2], this.kpK[2] });
    }
    if ((this.kpL > 0.0F) && (this.kpM != 0)) {
      localGradientDrawable.setStroke((int)this.kpL, this.kpM);
    }
    AppMethodBeat.o(206802);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(137555);
    this.kqh = new ScrollView(getContext())
    {
      protected final void onScrollChanged(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        AppMethodBeat.i(137549);
        super.onScrollChanged(paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
        if (WxaScrollView.a(WxaScrollView.this) != null) {
          WxaScrollView.a(WxaScrollView.this).p(WxaScrollView.this, paramAnonymousInt1, paramAnonymousInt2);
        }
        AppMethodBeat.o(137549);
      }
      
      public final boolean onTouchEvent(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(137550);
        switch (paramAnonymousMotionEvent.getAction())
        {
        }
        do
        {
          boolean bool = super.onTouchEvent(paramAnonymousMotionEvent);
          AppMethodBeat.o(137550);
          return bool;
        } while (WxaScrollView.b(WxaScrollView.this));
        ac.e("MicroMsg.WxaScrollView", "can not move");
        AppMethodBeat.o(137550);
        return false;
      }
    };
    this.kqg = new FrameLayout(getContext());
    super.addView(this.kqh, 0, new ViewGroup.LayoutParams(-1, -1));
    this.kqh.addView(this.kqg, 0, new ViewGroup.LayoutParams(-1, -2));
    this.kpN.setStyle(Paint.Style.STROKE);
    this.kpN.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(137555);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137558);
    this.kqg.addView(paramView, paramInt);
    AppMethodBeat.o(137558);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137559);
    this.kqg.addView(paramView, paramInt, paramLayoutParams);
    AppMethodBeat.o(137559);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137563);
    if (paramMotionEvent.getActionMasked() == 0)
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      double d1;
      float f3;
      float f4;
      double d2;
      int i;
      if (this.kpJ > 0.0F)
      {
        d1 = Math.pow(this.kpJ, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.kpJ) {
          if (f2 < this.kpJ)
          {
            d2 = Math.pow(this.kpJ - f1, 2.0D);
            if (Math.pow(this.kpJ - f2, 2.0D) + d2 <= d1) {
              break label325;
            }
            i = 0;
          }
        }
      }
      while (i == 0)
      {
        AppMethodBeat.o(137563);
        return false;
        if (f2 > f4 - this.kpJ)
        {
          d2 = Math.pow(this.kpJ - f1, 2.0D);
          if (Math.pow(this.kpJ + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.kpJ) {
              if (f2 < this.kpJ)
              {
                d2 = Math.pow(f1 + this.kpJ - f3, 2.0D);
                if (Math.pow(this.kpJ - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.kpJ)
              {
                d2 = Math.pow(f1 + this.kpJ - f3, 2.0D);
                if (Math.pow(this.kpJ + f2 - f4, 2.0D) + d2 > d1)
                {
                  i = 0;
                  continue;
                }
              }
            }
          }
        }
        label325:
        i = 1;
      }
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(137563);
    return bool;
  }
  
  public void draw(Canvas paramCanvas)
  {
    float f2 = 0.0F;
    AppMethodBeat.i(137556);
    if ((this.kpK != null) && (this.kpK.length == 4))
    {
      setBackground(getShadowDrawable());
      super.draw(paramCanvas);
      AppMethodBeat.o(137556);
      return;
    }
    int i;
    if (this.kpJ > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.kpJ, this.kpJ, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.kpL <= 0.0F) {
        break label338;
      }
      float f1 = this.kpL / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.kpJ, this.kpJ, this.kpN);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.kpJ > 0.0F)
      {
        f1 = f2;
        if (this.kpJ - this.kpL > 0.0F) {
          f1 = this.kpJ - this.kpL;
        }
      }
      localPath.addRoundRect(new RectF(this.kpL, this.kpL, getWidth() - this.kpL, getHeight() - this.kpL), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label338:
    for (;;)
    {
      int j = paramCanvas.save();
      super.draw(paramCanvas);
      paramCanvas.restoreToCount(j);
      if (i != 0) {
        paramCanvas.restore();
      }
      AppMethodBeat.o(137556);
      return;
      i = 0;
      break;
    }
  }
  
  public ViewGroup getTargetView()
  {
    return this.kqg;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(137557);
    int i = this.kqg.getChildCount();
    AppMethodBeat.o(137557);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(137560);
    this.kqg.removeView(paramView);
    AppMethodBeat.o(137560);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137564);
    this.kqh.scrollTo(paramInt1, paramInt2);
    invalidate();
    AppMethodBeat.o(137564);
  }
  
  public void setBgColor(int paramInt)
  {
    this.mBgColor = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    AppMethodBeat.i(137561);
    this.kpM = paramInt;
    this.kpN.setColor(paramInt);
    AppMethodBeat.o(137561);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.kpJ = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    this.kpK = paramArrayOfFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(137562);
    this.kpL = paramFloat;
    this.kpN.setStrokeWidth(paramFloat);
    AppMethodBeat.o(137562);
  }
  
  public void setOnScrollChangedListener(q paramq)
  {
    this.kqi = paramq;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.kqk = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.kqj = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.x.f;
import com.tencent.mm.sdk.platformtools.ad;

public class WxaScrollView
  extends FrameLayout
  implements r, s, f
{
  private boolean jPA;
  private float jPi;
  private float jPj;
  private int jPk;
  private Paint jPl;
  private FrameLayout jPw;
  private ScrollView jPx;
  private q jPy;
  private boolean jPz;
  private int mBgColor;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137552);
    this.jPz = true;
    this.jPA = true;
    this.jPl = new Paint();
    init();
    AppMethodBeat.o(137552);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137553);
    this.jPz = true;
    this.jPA = true;
    this.jPl = new Paint();
    init();
    AppMethodBeat.o(137553);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137554);
    this.jPz = true;
    this.jPA = true;
    this.jPl = new Paint();
    init();
    AppMethodBeat.o(137554);
  }
  
  private void init()
  {
    AppMethodBeat.i(137555);
    this.jPx = new ScrollView(getContext())
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
        ad.e("MicroMsg.WxaScrollView", "can not move");
        AppMethodBeat.o(137550);
        return false;
      }
    };
    this.jPw = new FrameLayout(getContext());
    super.addView(this.jPx, 0, new ViewGroup.LayoutParams(-1, -1));
    this.jPx.addView(this.jPw, 0, new ViewGroup.LayoutParams(-1, -2));
    this.jPl.setStyle(Paint.Style.STROKE);
    this.jPl.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(137555);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137558);
    this.jPw.addView(paramView, paramInt);
    AppMethodBeat.o(137558);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137559);
    this.jPw.addView(paramView, paramInt, paramLayoutParams);
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
      if (this.jPi > 0.0F)
      {
        d1 = Math.pow(this.jPi, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.jPi) {
          if (f2 < this.jPi)
          {
            d2 = Math.pow(this.jPi - f1, 2.0D);
            if (Math.pow(this.jPi - f2, 2.0D) + d2 <= d1) {
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
        if (f2 > f4 - this.jPi)
        {
          d2 = Math.pow(this.jPi - f1, 2.0D);
          if (Math.pow(this.jPi + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.jPi) {
              if (f2 < this.jPi)
              {
                d2 = Math.pow(f1 + this.jPi - f3, 2.0D);
                if (Math.pow(this.jPi - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.jPi)
              {
                d2 = Math.pow(f1 + this.jPi - f3, 2.0D);
                if (Math.pow(this.jPi + f2 - f4, 2.0D) + d2 > d1)
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
    int i;
    if (this.jPi > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.jPi, this.jPi, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.jPj <= 0.0F) {
        break label303;
      }
      float f1 = this.jPj / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.jPi, this.jPi, this.jPl);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.jPi > 0.0F)
      {
        f1 = f2;
        if (this.jPi - this.jPj > 0.0F) {
          f1 = this.jPi - this.jPj;
        }
      }
      localPath.addRoundRect(new RectF(this.jPj, this.jPj, getWidth() - this.jPj, getHeight() - this.jPj), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label303:
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
    return this.jPw;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(137557);
    int i = this.jPw.getChildCount();
    AppMethodBeat.o(137557);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(137560);
    this.jPw.removeView(paramView);
    AppMethodBeat.o(137560);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137564);
    this.jPx.scrollTo(paramInt1, paramInt2);
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
    this.jPk = paramInt;
    this.jPl.setColor(paramInt);
    AppMethodBeat.o(137561);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.jPi = paramFloat;
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(137562);
    this.jPj = paramFloat;
    this.jPl.setStrokeWidth(paramFloat);
    AppMethodBeat.o(137562);
  }
  
  public void setOnScrollChangedListener(q paramq)
  {
    this.jPy = paramq;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.jPA = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.jPz = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.appbrand.jsapi.z.g;
import com.tencent.mm.sdk.platformtools.ad;

public class WxaScrollView
  extends FrameLayout
  implements r, s, g
{
  private float kKJ;
  private float[] kKK;
  private float kKL;
  private int kKM;
  private Paint kKN;
  GradientDrawable kKV;
  float[] kKW;
  private FrameLayout kLi;
  private ScrollView kLj;
  private q kLk;
  private boolean kLl;
  private boolean kLm;
  private int mBgColor;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137552);
    this.kLl = true;
    this.kLm = true;
    this.kKN = new Paint();
    this.kKV = new GradientDrawable();
    this.kKW = new float[8];
    init();
    AppMethodBeat.o(137552);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137553);
    this.kLl = true;
    this.kLm = true;
    this.kKN = new Paint();
    this.kKV = new GradientDrawable();
    this.kKW = new float[8];
    init();
    AppMethodBeat.o(137553);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137554);
    this.kLl = true;
    this.kLm = true;
    this.kKN = new Paint();
    this.kKV = new GradientDrawable();
    this.kKW = new float[8];
    init();
    AppMethodBeat.o(137554);
  }
  
  private Drawable getShadowDrawable()
  {
    AppMethodBeat.i(195008);
    if (this.mBgColor != 0) {
      this.kKV.setColor(this.mBgColor);
    }
    if ((this.kKK != null) && (this.kKK.length > 3))
    {
      this.kKW[0] = this.kKK[0];
      this.kKW[1] = this.kKK[0];
      this.kKW[2] = this.kKK[1];
      this.kKW[3] = this.kKK[1];
      this.kKW[4] = this.kKK[3];
      this.kKW[5] = this.kKK[3];
      this.kKW[6] = this.kKK[2];
      this.kKW[7] = this.kKK[2];
      this.kKV.setCornerRadii(this.kKW);
    }
    if ((this.kKL > 0.0F) && (this.kKM != 0)) {
      this.kKV.setStroke((int)this.kKL, this.kKM);
    }
    GradientDrawable localGradientDrawable = this.kKV;
    AppMethodBeat.o(195008);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(137555);
    this.kLj = new ScrollView(getContext())
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
    this.kLi = new FrameLayout(getContext());
    super.addView(this.kLj, 0, new ViewGroup.LayoutParams(-1, -1));
    this.kLj.addView(this.kLi, 0, new ViewGroup.LayoutParams(-1, -2));
    this.kKN.setStyle(Paint.Style.STROKE);
    this.kKN.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(137555);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137558);
    this.kLi.addView(paramView, paramInt);
    AppMethodBeat.o(137558);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137559);
    this.kLi.addView(paramView, paramInt, paramLayoutParams);
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
      if (this.kKJ > 0.0F)
      {
        d1 = Math.pow(this.kKJ, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.kKJ) {
          if (f2 < this.kKJ)
          {
            d2 = Math.pow(this.kKJ - f1, 2.0D);
            if (Math.pow(this.kKJ - f2, 2.0D) + d2 <= d1) {
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
        if (f2 > f4 - this.kKJ)
        {
          d2 = Math.pow(this.kKJ - f1, 2.0D);
          if (Math.pow(this.kKJ + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.kKJ) {
              if (f2 < this.kKJ)
              {
                d2 = Math.pow(f1 + this.kKJ - f3, 2.0D);
                if (Math.pow(this.kKJ - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.kKJ)
              {
                d2 = Math.pow(f1 + this.kKJ - f3, 2.0D);
                if (Math.pow(this.kKJ + f2 - f4, 2.0D) + d2 > d1)
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
    if ((this.kKK != null) && (this.kKK.length == 4))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(137556);
      return;
    }
    int i;
    if (this.kKJ > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.kKJ, this.kKJ, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.kKL <= 0.0F) {
        break label330;
      }
      float f1 = this.kKL / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.kKJ, this.kKJ, this.kKN);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.kKJ > 0.0F)
      {
        f1 = f2;
        if (this.kKJ - this.kKL > 0.0F) {
          f1 = this.kKJ - this.kKL;
        }
      }
      localPath.addRoundRect(new RectF(this.kKL, this.kKL, getWidth() - this.kKL, getHeight() - this.kKL), f1, f1, Path.Direction.CW);
      paramCanvas.clipPath(localPath);
      i = 1;
    }
    label330:
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
    return this.kLi;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(137557);
    int i = this.kLi.getChildCount();
    AppMethodBeat.o(137557);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(137560);
    this.kLi.removeView(paramView);
    AppMethodBeat.o(137560);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137564);
    this.kLj.scrollTo(paramInt1, paramInt2);
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
    this.kKM = paramInt;
    this.kKN.setColor(paramInt);
    AppMethodBeat.o(137561);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.kKJ = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(195009);
    this.kKK = paramArrayOfFloat;
    if ((this.kKK != null) && (this.kKK.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(195009);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(137562);
    this.kKL = paramFloat;
    this.kKN.setStrokeWidth(paramFloat);
    AppMethodBeat.o(137562);
  }
  
  public void setOnScrollChangedListener(q paramq)
  {
    this.kLk = paramq;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.kLm = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.kLl = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */
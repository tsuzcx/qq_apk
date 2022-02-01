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
import com.tencent.mm.plugin.appbrand.jsapi.ac.g;
import com.tencent.mm.sdk.platformtools.Log;

public class WxaScrollView
  extends FrameLayout
  implements g, u, v
{
  private float gPO;
  private float lSR;
  private float[] lSS;
  private int lST;
  private Paint lSU;
  GradientDrawable lTc;
  float[] lTd;
  private FrameLayout lTv;
  private ScrollView lTw;
  private t lTx;
  private boolean lTy;
  private boolean lTz;
  private int mBgColor;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137552);
    this.lTy = true;
    this.lTz = true;
    this.lSU = new Paint();
    this.lTc = new GradientDrawable();
    this.lTd = new float[8];
    init();
    AppMethodBeat.o(137552);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137553);
    this.lTy = true;
    this.lTz = true;
    this.lSU = new Paint();
    this.lTc = new GradientDrawable();
    this.lTd = new float[8];
    init();
    AppMethodBeat.o(137553);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137554);
    this.lTy = true;
    this.lTz = true;
    this.lSU = new Paint();
    this.lTc = new GradientDrawable();
    this.lTd = new float[8];
    init();
    AppMethodBeat.o(137554);
  }
  
  private Drawable getShadowDrawable()
  {
    AppMethodBeat.i(193675);
    if (this.mBgColor != 0) {
      this.lTc.setColor(this.mBgColor);
    }
    if ((this.lSS != null) && (this.lSS.length > 3))
    {
      this.lTd[0] = this.lSS[0];
      this.lTd[1] = this.lSS[0];
      this.lTd[2] = this.lSS[1];
      this.lTd[3] = this.lSS[1];
      this.lTd[4] = this.lSS[3];
      this.lTd[5] = this.lSS[3];
      this.lTd[6] = this.lSS[2];
      this.lTd[7] = this.lSS[2];
      this.lTc.setCornerRadii(this.lTd);
    }
    if ((this.gPO > 0.0F) && (this.lST != 0)) {
      this.lTc.setStroke((int)this.gPO, this.lST);
    }
    GradientDrawable localGradientDrawable = this.lTc;
    AppMethodBeat.o(193675);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(137555);
    this.lTw = new ScrollView(getContext())
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
        Log.e("MicroMsg.WxaScrollView", "can not move");
        AppMethodBeat.o(137550);
        return false;
      }
    };
    this.lTv = new FrameLayout(getContext());
    super.addView(this.lTw, 0, new ViewGroup.LayoutParams(-1, -1));
    this.lTw.addView(this.lTv, 0, new ViewGroup.LayoutParams(-1, -2));
    this.lSU.setStyle(Paint.Style.STROKE);
    this.lSU.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(137555);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137558);
    this.lTv.addView(paramView, paramInt);
    AppMethodBeat.o(137558);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137559);
    this.lTv.addView(paramView, paramInt, paramLayoutParams);
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
      if (this.lSR > 0.0F)
      {
        d1 = Math.pow(this.lSR, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.lSR) {
          if (f2 < this.lSR)
          {
            d2 = Math.pow(this.lSR - f1, 2.0D);
            if (Math.pow(this.lSR - f2, 2.0D) + d2 <= d1) {
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
        if (f2 > f4 - this.lSR)
        {
          d2 = Math.pow(this.lSR - f1, 2.0D);
          if (Math.pow(this.lSR + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.lSR) {
              if (f2 < this.lSR)
              {
                d2 = Math.pow(f1 + this.lSR - f3, 2.0D);
                if (Math.pow(this.lSR - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.lSR)
              {
                d2 = Math.pow(f1 + this.lSR - f3, 2.0D);
                if (Math.pow(this.lSR + f2 - f4, 2.0D) + d2 > d1)
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
    if ((this.lSS != null) && (this.lSS.length == 4))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(137556);
      return;
    }
    int i;
    if (this.lSR > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.lSR, this.lSR, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.gPO <= 0.0F) {
        break label330;
      }
      float f1 = this.gPO / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.lSR, this.lSR, this.lSU);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.lSR > 0.0F)
      {
        f1 = f2;
        if (this.lSR - this.gPO > 0.0F) {
          f1 = this.lSR - this.gPO;
        }
      }
      localPath.addRoundRect(new RectF(this.gPO, this.gPO, getWidth() - this.gPO, getHeight() - this.gPO), f1, f1, Path.Direction.CW);
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
    return this.lTv;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(137557);
    int i = this.lTv.getChildCount();
    AppMethodBeat.o(137557);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(137560);
    this.lTv.removeView(paramView);
    AppMethodBeat.o(137560);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137564);
    this.lTw.scrollTo(paramInt1, paramInt2);
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
    this.lST = paramInt;
    this.lSU.setColor(paramInt);
    AppMethodBeat.o(137561);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.lSR = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(193676);
    this.lSS = paramArrayOfFloat;
    if ((this.lSS != null) && (this.lSS.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(193676);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(137562);
    this.gPO = paramFloat;
    this.lSU.setStrokeWidth(paramFloat);
    AppMethodBeat.o(137562);
  }
  
  public void setOnScrollChangedListener(t paramt)
  {
    this.lTx = paramt;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.lTz = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.lTy = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */
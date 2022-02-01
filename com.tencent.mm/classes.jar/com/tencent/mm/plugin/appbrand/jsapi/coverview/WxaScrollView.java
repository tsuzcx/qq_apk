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
import com.tencent.mm.plugin.appbrand.jsapi.ah.g;
import com.tencent.mm.sdk.platformtools.Log;

public class WxaScrollView
  extends FrameLayout
  implements g, u, v
{
  private int mBgColor;
  private ScrollView pLK;
  float[] rTA;
  private FrameLayout rTS;
  private t rTT;
  private boolean rTU;
  private boolean rTV;
  private float rTn;
  private float[] rTo;
  private float rTp;
  private int rTq;
  private Paint rTr;
  GradientDrawable rTz;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137552);
    this.rTU = true;
    this.rTV = true;
    this.rTr = new Paint();
    this.rTz = new GradientDrawable();
    this.rTA = new float[8];
    init();
    AppMethodBeat.o(137552);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137553);
    this.rTU = true;
    this.rTV = true;
    this.rTr = new Paint();
    this.rTz = new GradientDrawable();
    this.rTA = new float[8];
    init();
    AppMethodBeat.o(137553);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137554);
    this.rTU = true;
    this.rTV = true;
    this.rTr = new Paint();
    this.rTz = new GradientDrawable();
    this.rTA = new float[8];
    init();
    AppMethodBeat.o(137554);
  }
  
  private Drawable getShadowDrawable()
  {
    AppMethodBeat.i(327328);
    if (this.mBgColor != 0) {
      this.rTz.setColor(this.mBgColor);
    }
    if ((this.rTo != null) && (this.rTo.length > 3))
    {
      this.rTA[0] = this.rTo[0];
      this.rTA[1] = this.rTo[0];
      this.rTA[2] = this.rTo[1];
      this.rTA[3] = this.rTo[1];
      this.rTA[4] = this.rTo[3];
      this.rTA[5] = this.rTo[3];
      this.rTA[6] = this.rTo[2];
      this.rTA[7] = this.rTo[2];
      this.rTz.setCornerRadii(this.rTA);
    }
    if ((this.rTp > 0.0F) && (this.rTq != 0)) {
      this.rTz.setStroke((int)this.rTp, this.rTq);
    }
    GradientDrawable localGradientDrawable = this.rTz;
    AppMethodBeat.o(327328);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(137555);
    this.pLK = new ScrollView(getContext())
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
    this.rTS = new FrameLayout(getContext());
    super.addView(this.pLK, 0, new ViewGroup.LayoutParams(-1, -1));
    this.pLK.addView(this.rTS, 0, new ViewGroup.LayoutParams(-1, -2));
    this.rTr.setStyle(Paint.Style.STROKE);
    this.rTr.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(137555);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137558);
    this.rTS.addView(paramView, paramInt);
    AppMethodBeat.o(137558);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137559);
    this.rTS.addView(paramView, paramInt, paramLayoutParams);
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
      if (this.rTn > 0.0F)
      {
        d1 = Math.pow(this.rTn, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.rTn) {
          if (f2 < this.rTn)
          {
            d2 = Math.pow(this.rTn - f1, 2.0D);
            if (Math.pow(this.rTn - f2, 2.0D) + d2 <= d1) {
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
        if (f2 > f4 - this.rTn)
        {
          d2 = Math.pow(this.rTn - f1, 2.0D);
          if (Math.pow(this.rTn + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.rTn) {
              if (f2 < this.rTn)
              {
                d2 = Math.pow(f1 + this.rTn - f3, 2.0D);
                if (Math.pow(this.rTn - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.rTn)
              {
                d2 = Math.pow(f1 + this.rTn - f3, 2.0D);
                if (Math.pow(this.rTn + f2 - f4, 2.0D) + d2 > d1)
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
    if ((this.rTo != null) && (this.rTo.length == 4))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(137556);
      return;
    }
    int i;
    if (this.rTn > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.rTn, this.rTn, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.rTp <= 0.0F) {
        break label330;
      }
      float f1 = this.rTp / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.rTn, this.rTn, this.rTr);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.rTn > 0.0F)
      {
        f1 = f2;
        if (this.rTn - this.rTp > 0.0F) {
          f1 = this.rTn - this.rTp;
        }
      }
      localPath.addRoundRect(new RectF(this.rTp, this.rTp, getWidth() - this.rTp, getHeight() - this.rTp), f1, f1, Path.Direction.CW);
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
    return this.rTS;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(137557);
    int i = this.rTS.getChildCount();
    AppMethodBeat.o(137557);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(137560);
    this.rTS.removeView(paramView);
    AppMethodBeat.o(137560);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137564);
    this.pLK.scrollTo(paramInt1, paramInt2);
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
    this.rTq = paramInt;
    this.rTr.setColor(paramInt);
    AppMethodBeat.o(137561);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.rTn = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(327359);
    this.rTo = paramArrayOfFloat;
    if ((this.rTo != null) && (this.rTo.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(327359);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(137562);
    this.rTp = paramFloat;
    this.rTr.setStrokeWidth(paramFloat);
    AppMethodBeat.o(137562);
  }
  
  public void setOnScrollChangedListener(t paramt)
  {
    this.rTT = paramt;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.rTV = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.rTU = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.appbrand.jsapi.aa.g;
import com.tencent.mm.sdk.platformtools.ae;

public class WxaScrollView
  extends FrameLayout
  implements g, r, s
{
  private float kNY;
  private float[] kNZ;
  private boolean kOA;
  private boolean kOB;
  private float kOa;
  private int kOb;
  private Paint kOc;
  GradientDrawable kOk;
  float[] kOl;
  private FrameLayout kOx;
  private ScrollView kOy;
  private q kOz;
  private int mBgColor;
  
  public WxaScrollView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137552);
    this.kOA = true;
    this.kOB = true;
    this.kOc = new Paint();
    this.kOk = new GradientDrawable();
    this.kOl = new float[8];
    init();
    AppMethodBeat.o(137552);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(137553);
    this.kOA = true;
    this.kOB = true;
    this.kOc = new Paint();
    this.kOk = new GradientDrawable();
    this.kOl = new float[8];
    init();
    AppMethodBeat.o(137553);
  }
  
  public WxaScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(137554);
    this.kOA = true;
    this.kOB = true;
    this.kOc = new Paint();
    this.kOk = new GradientDrawable();
    this.kOl = new float[8];
    init();
    AppMethodBeat.o(137554);
  }
  
  private Drawable getShadowDrawable()
  {
    AppMethodBeat.i(197231);
    if (this.mBgColor != 0) {
      this.kOk.setColor(this.mBgColor);
    }
    if ((this.kNZ != null) && (this.kNZ.length > 3))
    {
      this.kOl[0] = this.kNZ[0];
      this.kOl[1] = this.kNZ[0];
      this.kOl[2] = this.kNZ[1];
      this.kOl[3] = this.kNZ[1];
      this.kOl[4] = this.kNZ[3];
      this.kOl[5] = this.kNZ[3];
      this.kOl[6] = this.kNZ[2];
      this.kOl[7] = this.kNZ[2];
      this.kOk.setCornerRadii(this.kOl);
    }
    if ((this.kOa > 0.0F) && (this.kOb != 0)) {
      this.kOk.setStroke((int)this.kOa, this.kOb);
    }
    GradientDrawable localGradientDrawable = this.kOk;
    AppMethodBeat.o(197231);
    return localGradientDrawable;
  }
  
  private void init()
  {
    AppMethodBeat.i(137555);
    this.kOy = new ScrollView(getContext())
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
        ae.e("MicroMsg.WxaScrollView", "can not move");
        AppMethodBeat.o(137550);
        return false;
      }
    };
    this.kOx = new FrameLayout(getContext());
    super.addView(this.kOy, 0, new ViewGroup.LayoutParams(-1, -1));
    this.kOy.addView(this.kOx, 0, new ViewGroup.LayoutParams(-1, -2));
    this.kOc.setStyle(Paint.Style.STROKE);
    this.kOc.setAntiAlias(true);
    setWillNotDraw(false);
    AppMethodBeat.o(137555);
  }
  
  public void addView(View paramView, int paramInt)
  {
    AppMethodBeat.i(137558);
    this.kOx.addView(paramView, paramInt);
    AppMethodBeat.o(137558);
  }
  
  public void addView(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams)
  {
    AppMethodBeat.i(137559);
    this.kOx.addView(paramView, paramInt, paramLayoutParams);
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
      if (this.kNY > 0.0F)
      {
        d1 = Math.pow(this.kNY, 2.0D);
        f3 = getWidth();
        f4 = getHeight();
        if (f1 < this.kNY) {
          if (f2 < this.kNY)
          {
            d2 = Math.pow(this.kNY - f1, 2.0D);
            if (Math.pow(this.kNY - f2, 2.0D) + d2 <= d1) {
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
        if (f2 > f4 - this.kNY)
        {
          d2 = Math.pow(this.kNY - f1, 2.0D);
          if (Math.pow(this.kNY + f2 - f4, 2.0D) + d2 > d1)
          {
            i = 0;
            continue;
            if (f1 > f3 - this.kNY) {
              if (f2 < this.kNY)
              {
                d2 = Math.pow(f1 + this.kNY - f3, 2.0D);
                if (Math.pow(this.kNY - f2, 2.0D) + d2 > d1) {
                  i = 0;
                }
              }
              else if (f2 > f4 - this.kNY)
              {
                d2 = Math.pow(f1 + this.kNY - f3, 2.0D);
                if (Math.pow(this.kNY + f2 - f4, 2.0D) + d2 > d1)
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
    if ((this.kNZ != null) && (this.kNZ.length == 4))
    {
      super.draw(paramCanvas);
      AppMethodBeat.o(137556);
      return;
    }
    int i;
    if (this.kNY > 0.0F)
    {
      i = 1;
      if (i != 0)
      {
        paramCanvas.save();
        localPath = new Path();
        localPath.addRoundRect(new RectF(0.0F, 0.0F, getWidth(), getHeight()), this.kNY, this.kNY, Path.Direction.CW);
        paramCanvas.clipPath(localPath);
      }
      if (this.mBgColor != 0) {
        paramCanvas.drawColor(this.mBgColor);
      }
      if (this.kOa <= 0.0F) {
        break label330;
      }
      float f1 = this.kOa / 2.0F;
      paramCanvas.drawRoundRect(new RectF(f1, f1, getWidth() - f1, getHeight() - f1), this.kNY, this.kNY, this.kOc);
      if (i != 0) {
        paramCanvas.restore();
      }
      paramCanvas.save();
      Path localPath = new Path();
      f1 = f2;
      if (this.kNY > 0.0F)
      {
        f1 = f2;
        if (this.kNY - this.kOa > 0.0F) {
          f1 = this.kNY - this.kOa;
        }
      }
      localPath.addRoundRect(new RectF(this.kOa, this.kOa, getWidth() - this.kOa, getHeight() - this.kOa), f1, f1, Path.Direction.CW);
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
    return this.kOx;
  }
  
  public int getTargetViewChildCount()
  {
    AppMethodBeat.i(137557);
    int i = this.kOx.getChildCount();
    AppMethodBeat.o(137557);
    return i;
  }
  
  public void removeView(View paramView)
  {
    AppMethodBeat.i(137560);
    this.kOx.removeView(paramView);
    AppMethodBeat.o(137560);
  }
  
  public void scrollTo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(137564);
    this.kOy.scrollTo(paramInt1, paramInt2);
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
    this.kOb = paramInt;
    this.kOc.setColor(paramInt);
    AppMethodBeat.o(137561);
  }
  
  public void setBorderRadius(float paramFloat)
  {
    this.kNY = paramFloat;
  }
  
  public void setBorderRadius(float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(197232);
    this.kNZ = paramArrayOfFloat;
    if ((this.kNZ != null) && (this.kNZ.length > 0)) {
      setBackground(getShadowDrawable());
    }
    AppMethodBeat.o(197232);
  }
  
  public void setBorderWidth(float paramFloat)
  {
    AppMethodBeat.i(137562);
    this.kOa = paramFloat;
    this.kOc.setStrokeWidth(paramFloat);
    AppMethodBeat.o(137562);
  }
  
  public void setOnScrollChangedListener(q paramq)
  {
    this.kOz = paramq;
  }
  
  public void setScrollHorizontal(boolean paramBoolean)
  {
    this.kOB = paramBoolean;
  }
  
  public void setScrollVertical(boolean paramBoolean)
  {
    this.kOA = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.WxaScrollView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kinda.framework.widget.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaButtonImpl
  extends FrameLayout
{
  private static final String TAG = "KindaButtonImpl";
  private boolean mIsPressed;
  private ImageView mKButtonImageView;
  private KindaTextViewImpl mKButtonTextView;
  
  public KindaButtonImpl(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(144725);
    init(paramContext);
    AppMethodBeat.o(144725);
  }
  
  public KindaButtonImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(144726);
    init(paramContext);
    AppMethodBeat.o(144726);
  }
  
  public KindaButtonImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(144727);
    init(paramContext);
    AppMethodBeat.o(144727);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(144728);
    this.mKButtonImageView = new ImageView(paramContext);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.mKButtonImageView.setLayoutParams(localLayoutParams);
    this.mKButtonImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    addView(this.mKButtonImageView);
    this.mKButtonTextView = new KindaTextViewImpl(paramContext);
    this.mKButtonTextView.setKindaButton(this);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.mKButtonTextView.setLayoutParams(paramContext);
    this.mKButtonTextView.setBackgroundResource(2131690605);
    this.mKButtonTextView.setGravity(17);
    addView(this.mKButtonTextView);
    AppMethodBeat.o(144728);
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(144731);
    CharSequence localCharSequence = this.mKButtonTextView.getText();
    AppMethodBeat.o(144731);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(144733);
    int i = this.mKButtonTextView.getCurrentTextColor();
    AppMethodBeat.o(144733);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(144735);
    float f = this.mKButtonTextView.getTextSize();
    AppMethodBeat.o(144735);
    return f;
  }
  
  public boolean isKindaPressed()
  {
    return this.mIsPressed;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144738);
    int m = View.MeasureSpec.getMode(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    View.MeasureSpec.getSize(paramInt1);
    View.MeasureSpec.getSize(paramInt2);
    int i = paramInt1;
    int j = paramInt2;
    if (getHeight() > 0)
    {
      i = paramInt1;
      j = paramInt2;
      if (getWidth() > 0)
      {
        if (m == -2147483648) {
          paramInt1 = getWidth() + 1073741824;
        }
        i = paramInt1;
        j = paramInt2;
        if (k == -2147483648)
        {
          j = getHeight() + 1073741824;
          i = paramInt1;
        }
      }
    }
    super.onMeasure(i, j);
    AppMethodBeat.o(144738);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(144737);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!isEnabled())
    {
      AppMethodBeat.o(144737);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(144737);
      return bool;
      this.mIsPressed = true;
      continue;
      this.mIsPressed = false;
    }
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(144729);
    if (this.mKButtonImageView == null)
    {
      AppMethodBeat.o(144729);
      return;
    }
    this.mKButtonImageView.setImageDrawable(paramDrawable);
    AppMethodBeat.o(144729);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(144730);
    this.mKButtonTextView.setText(paramString);
    AppMethodBeat.o(144730);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(144732);
    this.mKButtonTextView.setTextColor(paramColorStateList);
    AppMethodBeat.o(144732);
  }
  
  public void setTextFont(Typeface paramTypeface)
  {
    AppMethodBeat.i(144736);
    if (paramTypeface != null)
    {
      this.mKButtonTextView.setTypeface(paramTypeface);
      this.mKButtonTextView.requestLayout();
    }
    AppMethodBeat.o(144736);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(144734);
    this.mKButtonTextView.setTextSize(paramInt, paramFloat);
    AppMethodBeat.o(144734);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaButtonImpl
 * JD-Core Version:    0.7.0.1
 */
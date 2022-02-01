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
    AppMethodBeat.i(18856);
    init(paramContext);
    AppMethodBeat.o(18856);
  }
  
  public KindaButtonImpl(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(18857);
    init(paramContext);
    AppMethodBeat.o(18857);
  }
  
  public KindaButtonImpl(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(18858);
    init(paramContext);
    AppMethodBeat.o(18858);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(18859);
    this.mKButtonImageView = new ImageView(paramContext);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.mKButtonImageView.setLayoutParams(localLayoutParams);
    this.mKButtonImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    addView(this.mKButtonImageView);
    this.mKButtonTextView = new KindaTextViewImpl(paramContext);
    this.mKButtonTextView.setKindaButton(this);
    paramContext = new ViewGroup.LayoutParams(-1, -1);
    this.mKButtonTextView.setLayoutParams(paramContext);
    this.mKButtonTextView.setBackgroundResource(2131101053);
    this.mKButtonTextView.setGravity(17);
    addView(this.mKButtonTextView);
    super.setId(2131308495);
    AppMethodBeat.o(18859);
  }
  
  public KindaTextViewImpl getKButtonTextView()
  {
    return this.mKButtonTextView;
  }
  
  public CharSequence getText()
  {
    AppMethodBeat.i(18862);
    CharSequence localCharSequence = this.mKButtonTextView.getText();
    AppMethodBeat.o(18862);
    return localCharSequence;
  }
  
  public int getTextColor()
  {
    AppMethodBeat.i(18864);
    int i = this.mKButtonTextView.getCurrentTextColor();
    AppMethodBeat.o(18864);
    return i;
  }
  
  public float getTextSize()
  {
    AppMethodBeat.i(18866);
    float f = this.mKButtonTextView.getTextSize();
    AppMethodBeat.o(18866);
    return f;
  }
  
  public boolean isKindaPressed()
  {
    return this.mIsPressed;
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18869);
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
    AppMethodBeat.o(18869);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(18868);
    boolean bool = super.onTouchEvent(paramMotionEvent);
    if (!isEnabled())
    {
      AppMethodBeat.o(18868);
      return bool;
    }
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(18868);
      return bool;
      this.mIsPressed = true;
      continue;
      this.mIsPressed = false;
    }
  }
  
  public void setContentDescription(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(18871);
    this.mKButtonTextView.setContentDescription(paramCharSequence);
    AppMethodBeat.o(18871);
  }
  
  public void setId(int paramInt)
  {
    AppMethodBeat.i(18870);
    this.mKButtonTextView.setId(paramInt);
    AppMethodBeat.o(18870);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    AppMethodBeat.i(18860);
    if (this.mKButtonImageView == null)
    {
      AppMethodBeat.o(18860);
      return;
    }
    this.mKButtonImageView.setImageDrawable(paramDrawable);
    AppMethodBeat.o(18860);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(18861);
    this.mKButtonTextView.setText(paramString);
    AppMethodBeat.o(18861);
  }
  
  public void setTextColor(ColorStateList paramColorStateList)
  {
    AppMethodBeat.i(18863);
    this.mKButtonTextView.setTextColor(paramColorStateList);
    AppMethodBeat.o(18863);
  }
  
  public void setTextFont(Typeface paramTypeface)
  {
    AppMethodBeat.i(18867);
    if (paramTypeface != null)
    {
      this.mKButtonTextView.setTypeface(paramTypeface);
      this.mKButtonTextView.requestLayout();
    }
    AppMethodBeat.o(18867);
  }
  
  public void setTextSize(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(18865);
    this.mKButtonTextView.setTextSize(paramInt, paramFloat);
    AppMethodBeat.o(18865);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaButtonImpl
 * JD-Core Version:    0.7.0.1
 */
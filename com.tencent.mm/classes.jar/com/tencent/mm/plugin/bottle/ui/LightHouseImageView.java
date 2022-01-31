package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;

public class LightHouseImageView
  extends ImageView
{
  private AnimationDrawable hZS;
  private ah handler = new ah();
  
  public LightHouseImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LightHouseImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void om(int paramInt)
  {
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)getLayoutParams();
    FrameLayout localFrameLayout = (FrameLayout)getParent();
    if (((paramInt >= 6) && (paramInt <= 8)) || ((paramInt >= 21) && (paramInt <= 23))) {
      localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localFrameLayout.getHeight() * 250 / 800, localFrameLayout.getWidth() * 123 / 480, localMarginLayoutParams.bottomMargin);
    }
    for (;;)
    {
      setLayoutParams(localMarginLayoutParams);
      return;
      if (((paramInt >= 0) && (paramInt <= 8)) || ((paramInt >= 21) && (paramInt <= 29))) {
        localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localFrameLayout.getHeight() * 245 / 800, localFrameLayout.getWidth() * 130 / 480, localMarginLayoutParams.bottomMargin);
      } else {
        localMarginLayoutParams.setMargins(localMarginLayoutParams.leftMargin, localFrameLayout.getHeight() * 245 / 800, localFrameLayout.getWidth() * 125 / 480 - getWidth(), localMarginLayoutParams.bottomMargin);
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    try
    {
      Field localField = AnimationDrawable.class.getDeclaredField("mCurFrame");
      localField.setAccessible(true);
      om(localField.getInt(this.hZS));
      super.onDraw(paramCanvas);
      return;
    }
    catch (Exception paramCanvas) {}
  }
  
  public void setVisibility(int paramInt)
  {
    this.handler.postDelayed(new LightHouseImageView.1(this, paramInt), 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.LightHouseImageView
 * JD-Core Version:    0.7.0.1
 */
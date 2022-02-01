package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageSwitcher;

public class ImageSwitcherTouch
  extends ImageSwitcher
{
  public ImageSwitcherTouch(Context paramContext)
  {
    super(paramContext);
  }
  
  public ImageSwitcherTouch(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private Bitmap drawableToBitmap(Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicWidth();
    int j = paramDrawable.getIntrinsicHeight();
    if (paramDrawable.getOpacity() != -1) {}
    for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
    {
      localObject = Bitmap.createBitmap(i, j, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, i, j);
      paramDrawable.draw(localCanvas);
      return localObject;
    }
  }
  
  public void setDrawable(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    ImageViewTouche localImageViewTouche = (ImageViewTouche)getCurrentView();
    localImageViewTouche.setAdjustViewBounds(true);
    localImageViewTouche.setMaxWidth(paramInt1);
    localImageViewTouche.setMaxHeight(paramInt2);
    localImageViewTouche.setImageBitmap(null);
    localImageViewTouche.setImageDrawable(paramDrawable);
  }
  
  public void setDrawableWithSize(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    ImageViewTouche localImageViewTouche = (ImageViewTouche)getCurrentView();
    localImageViewTouche.setAdjustViewBounds(true);
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageViewTouche.getLayoutParams();
    localLayoutParams.width = paramInt1;
    localLayoutParams.height = paramInt2;
    localImageViewTouche.setImageBitmap(null);
    localImageViewTouche.setImageDrawable(paramDrawable);
  }
  
  public void setImageBitmap(Bitmap paramBitmap)
  {
    ImageViewTouche localImageViewTouche = (ImageViewTouche)getCurrentView();
    localImageViewTouche.setImageBitmap(paramBitmap);
    localImageViewTouche.setImageRotateBitmapResetBase(new RotateBitmap(paramBitmap, 0), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageSwitcherTouch
 * JD-Core Version:    0.7.0.1
 */
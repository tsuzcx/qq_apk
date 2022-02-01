package com.tencent.mm.plugin.appbrand.platform.window;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout.LayoutParams;

public class WxaWindowLayoutParams
  extends FrameLayout.LayoutParams
{
  public float scale = 1.0F;
  
  public WxaWindowLayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public WxaWindowLayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.platform.window.WxaWindowLayoutParams
 * JD-Core Version:    0.7.0.1
 */
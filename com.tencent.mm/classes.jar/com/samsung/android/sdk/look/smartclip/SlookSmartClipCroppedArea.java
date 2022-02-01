package com.samsung.android.sdk.look.smartclip;

import android.graphics.Rect;
import android.view.View;

public abstract interface SlookSmartClipCroppedArea
{
  public abstract Rect getRect();
  
  public abstract boolean intersects(Rect paramRect);
  
  public abstract boolean intersects(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.samsung.android.sdk.look.smartclip.SlookSmartClipCroppedArea
 * JD-Core Version:    0.7.0.1
 */
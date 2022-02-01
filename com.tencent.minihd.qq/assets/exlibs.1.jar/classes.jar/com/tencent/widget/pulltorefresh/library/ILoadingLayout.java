package com.tencent.widget.pulltorefresh.library;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public abstract interface ILoadingLayout
{
  public abstract void setLastUpdatedLabel(CharSequence paramCharSequence);
  
  public abstract void setLoadingDrawable(Drawable paramDrawable);
  
  public abstract void setPullLabel(CharSequence paramCharSequence);
  
  public abstract void setRefreshingLabel(CharSequence paramCharSequence);
  
  public abstract void setReleaseLabel(CharSequence paramCharSequence);
  
  public abstract void setTextTypeface(Typeface paramTypeface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.ILoadingLayout
 * JD-Core Version:    0.7.0.1
 */
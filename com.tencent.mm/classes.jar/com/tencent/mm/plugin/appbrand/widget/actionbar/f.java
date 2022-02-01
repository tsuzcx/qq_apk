package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnClickListener;

public abstract interface f
{
  public abstract void destroy();
  
  public abstract View getActionView();
  
  public abstract int getBackgroundColor();
  
  public abstract void hK(boolean paramBoolean);
  
  public abstract void setBackButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setBackgroundColor(int paramInt);
  
  public abstract void setCloseButtonClickListener(View.OnClickListener paramOnClickListener);
  
  public abstract void setForegroundColor(int paramInt);
  
  public abstract void setForegroundStyle(String paramString);
  
  public abstract void setLoadingIconVisibility(boolean paramBoolean);
  
  public abstract void setMainTitle(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.f
 * JD-Core Version:    0.7.0.1
 */
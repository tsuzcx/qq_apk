package com.tencent.mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public abstract class HeaderContainer
  extends FrameLayout
{
  public HeaderContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public HeaderContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract Rect getBackUpFooterRect();
  
  public abstract View getEmptyView();
  
  public abstract GyroView getGyroView();
  
  public abstract com.tencent.mm.plugin.appbrand.widget.header.a.a getHeaderView();
  
  public boolean isFullScreen()
  {
    return false;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public abstract void setAnimController(a parama);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.HeaderContainer
 * JD-Core Version:    0.7.0.1
 */
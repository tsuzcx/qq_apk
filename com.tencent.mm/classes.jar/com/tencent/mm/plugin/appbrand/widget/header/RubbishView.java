package com.tencent.mm.plugin.appbrand.widget.header;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class RubbishView
  extends FrameLayout
{
  public RubbishView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public RubbishView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void setHeaderContainer(HeaderContainer paramHeaderContainer);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.header.RubbishView
 * JD-Core Version:    0.7.0.1
 */
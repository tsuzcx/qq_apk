package com.tencent.mm.plugin.appbrand.jsapi.container;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.s;

public class AppBrandNativeContainerView
  extends FrameLayout
  implements s
{
  public boolean kNN;
  
  public AppBrandNativeContainerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AppBrandNativeContainerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AppBrandNativeContainerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setFullscreenWithChild(boolean paramBoolean)
  {
    this.kNN = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.Platform;

public class UIPagePlatformDelegateImpl
  implements IUIPagePlatformDelegate
{
  private Context context;
  
  public UIPagePlatformDelegateImpl(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public Platform currentPlatform()
  {
    return Platform.ANDROID;
  }
  
  public Context getContext()
  {
    return this.context;
  }
  
  public void setContext(Context paramContext)
  {
    this.context = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.UIPagePlatformDelegateImpl
 * JD-Core Version:    0.7.0.1
 */
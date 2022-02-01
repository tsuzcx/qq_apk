package com.tencent.widget.pulltorefresh.library;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import luc;
import lud;
import lue;

public class PullToRefreshWebView
  extends PullToRefreshBase
{
  private static final PullToRefreshBase.OnRefreshListener jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener = new luc();
  private final WebChromeClient jdField_a_of_type_AndroidWebkitWebChromeClient = new lud(this);
  
  public PullToRefreshWebView(Context paramContext)
  {
    super(paramContext);
    setOnRefreshListener(jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener);
    ((WebView)this.jdField_a_of_type_AndroidViewView).setWebChromeClient(this.jdField_a_of_type_AndroidWebkitWebChromeClient);
  }
  
  public PullToRefreshWebView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOnRefreshListener(jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener);
    ((WebView)this.jdField_a_of_type_AndroidViewView).setWebChromeClient(this.jdField_a_of_type_AndroidWebkitWebChromeClient);
  }
  
  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.Mode paramMode)
  {
    super(paramContext, paramMode);
    setOnRefreshListener(jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener);
    ((WebView)this.jdField_a_of_type_AndroidViewView).setWebChromeClient(this.jdField_a_of_type_AndroidWebkitWebChromeClient);
  }
  
  public PullToRefreshWebView(Context paramContext, PullToRefreshBase.Mode paramMode, PullToRefreshBase.AnimationStyle paramAnimationStyle)
  {
    super(paramContext, paramMode, paramAnimationStyle);
    setOnRefreshListener(jdField_a_of_type_ComTencentWidgetPulltorefreshLibraryPullToRefreshBase$OnRefreshListener);
    ((WebView)this.jdField_a_of_type_AndroidViewView).setWebChromeClient(this.jdField_a_of_type_AndroidWebkitWebChromeClient);
  }
  
  protected WebView a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (Build.VERSION.SDK_INT >= 9) {}
    for (paramContext = new lue(this, paramContext, paramAttributeSet);; paramContext = new WebView(paramContext, paramAttributeSet))
    {
      if (Build.VERSION.SDK_INT >= 11)
      {
        paramContext.removeJavascriptInterface("searchBoxJavaBridge_");
        paramContext.removeJavascriptInterface("accessibility");
        paramContext.removeJavascriptInterface("accessibilityTraversal");
      }
      paramContext.setId(2131296450);
      return paramContext;
    }
  }
  
  public final PullToRefreshBase.Orientation a()
  {
    return PullToRefreshBase.Orientation.VERTICAL;
  }
  
  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    ((WebView)this.jdField_a_of_type_AndroidViewView).restoreState(paramBundle);
  }
  
  protected void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    ((WebView)this.jdField_a_of_type_AndroidViewView).saveState(paramBundle);
  }
  
  protected boolean i()
  {
    return ((WebView)this.jdField_a_of_type_AndroidViewView).getScrollY() == 0;
  }
  
  protected boolean j()
  {
    float f = ((WebView)this.jdField_a_of_type_AndroidViewView).getContentHeight();
    f = (float)Math.floor(((WebView)this.jdField_a_of_type_AndroidViewView).getScale() * f);
    return ((WebView)this.jdField_a_of_type_AndroidViewView).getScrollY() >= f - ((WebView)this.jdField_a_of_type_AndroidViewView).getHeight();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.pulltorefresh.library.PullToRefreshWebView
 * JD-Core Version:    0.7.0.1
 */
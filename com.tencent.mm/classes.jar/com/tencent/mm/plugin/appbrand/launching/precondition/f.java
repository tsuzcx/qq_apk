package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;

public final class f
  extends ContextWrapper
  implements h
{
  public f(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
  }
  
  public final void onPause() {}
  
  public final void onResume() {}
  
  public final void p(Intent paramIntent)
  {
    paramIntent = e.uX(paramIntent.getStringExtra("extra_entry_token"));
    if (paramIntent == null)
    {
      ((AppBrandLaunchProxyUI)super.getBaseContext()).finish();
      return;
    }
    paramIntent.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.f
 * JD-Core Version:    0.7.0.1
 */
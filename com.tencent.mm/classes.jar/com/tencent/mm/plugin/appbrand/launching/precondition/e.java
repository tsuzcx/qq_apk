package com.tencent.mm.plugin.appbrand.launching.precondition;

import android.content.ContextWrapper;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.AppBrandLaunchProxyUI;
import com.tencent.mm.plugin.appbrand.ui.o;

public final class e
  extends ContextWrapper
  implements g
{
  public e(AppBrandLaunchProxyUI paramAppBrandLaunchProxyUI)
  {
    super(paramAppBrandLaunchProxyUI);
  }
  
  public final void F(Intent paramIntent)
  {
    AppMethodBeat.i(132074);
    o.a(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow());
    o.a(((AppBrandLaunchProxyUI)super.getBaseContext()).getWindow(), true);
    paramIntent = d.Dr(paramIntent.getStringExtra("extra_entry_token"));
    if (paramIntent == null)
    {
      ((AppBrandLaunchProxyUI)super.getBaseContext()).finish();
      AppMethodBeat.o(132074);
      return;
    }
    paramIntent.setBaseContext((AppBrandLaunchProxyUI)super.getBaseContext());
    AppMethodBeat.o(132074);
  }
  
  public final boolean aHw()
  {
    return true;
  }
  
  public final void onDestroy() {}
  
  public final void onPause() {}
  
  public final void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.launching.precondition.e
 * JD-Core Version:    0.7.0.1
 */
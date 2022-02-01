package com.tencent.mm.plugin.appbrand.ui.wxa_container;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ad;
import com.tencent.mm.ui.report.MMSecDataActivity;

@Deprecated
public abstract class BaseAppBrandUILegacy
  extends MMSecDataActivity
  implements ad
{
  public boolean initNavigationSwipeBack()
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUILegacy
 * JD-Core Version:    0.7.0.1
 */
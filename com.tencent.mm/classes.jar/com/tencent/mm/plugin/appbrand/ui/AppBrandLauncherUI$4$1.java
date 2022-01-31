package com.tencent.mm.plugin.appbrand.ui;

import android.text.TextUtils;
import com.tencent.luggage.sdk.customize.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.launching.precondition.f;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.h.b;

final class AppBrandLauncherUI$4$1
  implements h.b
{
  AppBrandLauncherUI$4$1(AppBrandLauncherUI.4 param4, AppBrandLauncherUI paramAppBrandLauncherUI) {}
  
  public final boolean onFinish(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(143588);
    if (!TextUtils.isEmpty(paramCharSequence))
    {
      paramCharSequence = paramCharSequence.toString();
      AppBrandStatObject localAppBrandStatObject = new AppBrandStatObject();
      localAppBrandStatObject.scene = 1001;
      f.ioc.a(this.iMN, "", paramCharSequence, null, 0, 0, localAppBrandStatObject, null, null);
      AppMethodBeat.o(143588);
      return true;
    }
    AppMethodBeat.o(143588);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.AppBrandLauncherUI.4.1
 * JD-Core Version:    0.7.0.1
 */
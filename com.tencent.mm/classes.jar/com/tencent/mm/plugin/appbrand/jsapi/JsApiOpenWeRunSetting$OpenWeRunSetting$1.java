package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.mm.plugin.appbrand.compat.a.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class JsApiOpenWeRunSetting$OpenWeRunSetting$1
  implements a.a
{
  JsApiOpenWeRunSetting$OpenWeRunSetting$1(JsApiOpenWeRunSetting.OpenWeRunSetting paramOpenWeRunSetting) {}
  
  public final void p(boolean paramBoolean1, boolean paramBoolean2)
  {
    JsApiOpenWeRunSetting.OpenWeRunSetting localOpenWeRunSetting = this.ggR;
    if ((paramBoolean1) && (paramBoolean2)) {}
    for (boolean bool = true;; bool = false)
    {
      JsApiOpenWeRunSetting.OpenWeRunSetting.a(localOpenWeRunSetting, bool);
      y.i("MicroMsg.JsApiOpenWeRunSetting", "After getUserState requestOk %b, hasStep %b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
      JsApiOpenWeRunSetting.OpenWeRunSetting.a(this.ggR);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting.OpenWeRunSetting.1
 * JD-Core Version:    0.7.0.1
 */
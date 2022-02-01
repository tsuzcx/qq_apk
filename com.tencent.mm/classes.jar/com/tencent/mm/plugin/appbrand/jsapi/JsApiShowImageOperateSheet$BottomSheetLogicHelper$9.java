package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$9
  implements e.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$9(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void dR(String paramString)
  {
    AppMethodBeat.i(45662);
    Log.i("MicroMsg.JsApiShowImageOperateSheet", "saveToSDCard localPath:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45662);
      return;
    }
    u.n(paramString, JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.oxr).getContext());
    AppMethodBeat.o(45662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.9
 * JD-Core Version:    0.7.0.1
 */
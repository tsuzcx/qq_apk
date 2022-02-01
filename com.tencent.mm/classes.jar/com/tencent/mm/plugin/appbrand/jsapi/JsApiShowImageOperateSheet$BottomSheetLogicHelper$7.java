package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$7
  implements b.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$7(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void Jr(String paramString)
  {
    AppMethodBeat.i(45659);
    ac.i("MicroMsg.JsApiShowImageOperateSheet", "saveToSDCard localPath:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45659);
      return;
    }
    q.j(paramString, JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.jZS).getContext());
    AppMethodBeat.o(45659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$8
  implements b.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$8(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void BO(String paramString)
  {
    AppMethodBeat.i(143258);
    ab.i("MicroMsg.JsApiShowImageOperateSheet", "fav localPath:%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(143258);
      return;
    }
    f.a("com.tencent.mm", new IPCString(paramString), JsApiShowImageOperateSheet.BottomSheetLogicHelper.a.class, new JsApiShowImageOperateSheet.BottomSheetLogicHelper.8.1(this));
    AppMethodBeat.o(143258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.8
 * JD-Core Version:    0.7.0.1
 */
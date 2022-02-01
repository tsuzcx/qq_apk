package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.d;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.widget.snackbar.b;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$8
  implements b.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$8(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void MK(String paramString)
  {
    AppMethodBeat.i(45662);
    ad.i("MicroMsg.JsApiShowImageOperateSheet", "fav localPath:%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45662);
      return;
    }
    h.a("com.tencent.mm", new IPCString(paramString), JsApiShowImageOperateSheet.BottomSheetLogicHelper.a.class, new d() {});
    AppMethodBeat.o(45662);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.8
 * JD-Core Version:    0.7.0.1
 */
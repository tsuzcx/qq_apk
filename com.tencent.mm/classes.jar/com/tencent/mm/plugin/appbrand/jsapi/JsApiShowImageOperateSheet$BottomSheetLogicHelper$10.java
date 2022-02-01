package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.utils.g.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.widget.snackbar.b;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$10
  implements g.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$10(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void onLoad(String paramString)
  {
    AppMethodBeat.i(325445);
    Log.i("MicroMsg.JsApiShowImageOperateSheet", "fav localPath:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(325445);
      return;
    }
    j.a(MainProcessIPCService.PROCESS_NAME, new IPCString(paramString), JsApiShowImageOperateSheet.BottomSheetLogicHelper.a.class, new f() {});
    AppMethodBeat.o(325445);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.10
 * JD-Core Version:    0.7.0.1
 */
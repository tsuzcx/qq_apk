package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.scanner.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.widget.b.d;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$2
  implements n.c
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$2(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper, Context paramContext) {}
  
  public final void onCreateMMMenu(l paraml)
  {
    AppMethodBeat.i(130575);
    JsApiShowImageOperateSheet.BottomSheetLogicHelper.b(this.hzV).setFooterView(null);
    paraml.clear();
    paraml.hx(1, 2131302650);
    paraml.hx(2, 2131302869);
    paraml.hx(3, 2131302102);
    if ((JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV) != null) && (!bo.isNullOrNil(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV)))))
    {
      if (a.ba(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV)), JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV))))
      {
        JsApiShowImageOperateSheet.BottomSheetLogicHelper.b(this.hzV).setFooterView(JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(this.hzV, this.val$context, JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.c(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV)), JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.d(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV))));
        AppMethodBeat.o(130575);
        return;
      }
      ab.w("MicroMsg.JsApiShowImageOperateSheet", "showBottomSheet not WXCode codeType:%d result:%s", new Object[] { Integer.valueOf(JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.b(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV))), JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCQRCodeRecognizeResult.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.c(this.hzV)) });
      AppMethodBeat.o(130575);
      return;
    }
    JsApiShowImageOperateSheet.BottomSheetLogicHelper.a(this.hzV, JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.hzV));
    AppMethodBeat.o(130575);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.2
 * JD-Core Version:    0.7.0.1
 */
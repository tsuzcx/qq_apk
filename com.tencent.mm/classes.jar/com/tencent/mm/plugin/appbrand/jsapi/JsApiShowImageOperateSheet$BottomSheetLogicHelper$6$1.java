package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.appbrand.page.z;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$6$1
  implements Runnable
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$6$1(JsApiShowImageOperateSheet.BottomSheetLogicHelper.6 param6, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(143256);
    Intent localIntent = new Intent();
    localIntent.putExtra("Retr_File_Name", this.hzW);
    localIntent.putExtra("Retr_Compress_Type", 0);
    localIntent.putExtra("Retr_Msg_Type", 0);
    d.f(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.hzX.hzV).getContext(), ".ui.transmit.MsgRetransmitUI", localIntent);
    AppMethodBeat.o(143256);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.6.1
 * JD-Core Version:    0.7.0.1
 */
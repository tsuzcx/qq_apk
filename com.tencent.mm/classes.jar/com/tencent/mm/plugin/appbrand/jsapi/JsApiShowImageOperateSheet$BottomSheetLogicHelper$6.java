package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.s;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$6
  implements b.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$6(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void Jr(final String paramString)
  {
    AppMethodBeat.i(45658);
    ac.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", new Object[] { paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45658);
      return;
    }
    if (s.aKD(paramString))
    {
      ac.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest localIPCSendToFriendEmojiRequest = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest();
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a(localIPCSendToFriendEmojiRequest, paramString);
      a.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.jZS).getContext(), localIPCSendToFriendEmojiRequest, null);
      AppMethodBeat.o(45658);
      return;
    }
    ap.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45657);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_File_Name", paramString);
        localIntent.putExtra("Retr_Compress_Type", 0);
        localIntent.putExtra("Retr_Msg_Type", 0);
        d.e(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(JsApiShowImageOperateSheet.BottomSheetLogicHelper.6.this.jZS).getContext(), ".ui.transmit.MsgRetransmitUI", localIntent);
        AppMethodBeat.o(45657);
      }
    });
    AppMethodBeat.o(45658);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.page.ae;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.t;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$6
  implements b.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$6(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void MK(final String paramString)
  {
    AppMethodBeat.i(45658);
    ad.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", new Object[] { paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45658);
      return;
    }
    if (t.aQj(paramString))
    {
      ad.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest localIPCSendToFriendEmojiRequest = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest();
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a(localIPCSendToFriendEmojiRequest, paramString);
      a.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.kuo).getContext(), localIPCSendToFriendEmojiRequest, null);
      AppMethodBeat.o(45658);
      return;
    }
    aq.f(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(45657);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_File_Name", paramString);
        localIntent.putExtra("Retr_Compress_Type", 0);
        localIntent.putExtra("Retr_Msg_Type", 0);
        d.f(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(JsApiShowImageOperateSheet.BottomSheetLogicHelper.6.this.kuo).getContext(), ".ui.transmit.MsgRetransmitUI", localIntent);
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
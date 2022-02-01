package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.utils.e.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$8
  implements e.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$8(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void dR(final String paramString)
  {
    AppMethodBeat.i(45659);
    Log.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", new Object[] { paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(45659);
      return;
    }
    if (ImgUtil.isGif(paramString))
    {
      Log.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest localIPCSendToFriendEmojiRequest = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest();
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a(localIPCSendToFriendEmojiRequest, paramString);
      a.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.oxr).getContext(), localIPCSendToFriendEmojiRequest, null);
      AppMethodBeat.o(45659);
      return;
    }
    MMHandlerThread.postToMainThread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(284605);
        Intent localIntent = new Intent();
        localIntent.putExtra("Retr_File_Name", paramString);
        localIntent.putExtra("Retr_Compress_Type", 0);
        localIntent.putExtra("Retr_Msg_Type", 0);
        c.f(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(JsApiShowImageOperateSheet.BottomSheetLogicHelper.8.this.oxr).getContext(), ".ui.transmit.MsgRetransmitUI", localIntent);
        AppMethodBeat.o(284605);
      }
    });
    AppMethodBeat.o(45659);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ipc.a;
import com.tencent.mm.plugin.appbrand.page.z;
import com.tencent.mm.plugin.appbrand.t.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$6
  implements b.a
{
  JsApiShowImageOperateSheet$BottomSheetLogicHelper$6(JsApiShowImageOperateSheet.BottomSheetLogicHelper paramBottomSheetLogicHelper) {}
  
  public final void BO(String paramString)
  {
    AppMethodBeat.i(130579);
    ab.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend path:%s", new Object[] { paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(130579);
      return;
    }
    if (r.aoY(paramString))
    {
      ab.i("MicroMsg.JsApiShowImageOperateSheet", "sendToFriend as emoji");
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest localIPCSendToFriendEmojiRequest = new JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest();
      JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a(localIPCSendToFriendEmojiRequest, paramString);
      a.a(JsApiShowImageOperateSheet.BottomSheetLogicHelper.d(this.hzV).getContext(), localIPCSendToFriendEmojiRequest, null);
      AppMethodBeat.o(130579);
      return;
    }
    al.d(new JsApiShowImageOperateSheet.BottomSheetLogicHelper.6.1(this, paramString));
    AppMethodBeat.o(130579);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.6
 * JD-Core Version:    0.7.0.1
 */
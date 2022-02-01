package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.o;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$d
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(45690);
    if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest))
    {
      ae.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
      AppMethodBeat.o(45690);
      return;
    }
    Object localObject = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest)paramProcessRequest);
    paramProcessRequest = o.aRh((String)localObject);
    paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramProcessRequest);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
      ak.getContext();
      paramProcessRequest = paramProcessRequest.ack((String)localObject);
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aci(paramProcessRequest);
    }
    for (;;)
    {
      long l;
      if (paramProcessRequest == null)
      {
        l = 0L;
        if (paramProcessRequest != null) {
          break label232;
        }
        label121:
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((com.tencent.mm.sdk.platformtools.h.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= b.acp())) && (localOptions.outWidth <= b.acp())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if ((l > b.acq()) || (i != 0))
        {
          com.tencent.mm.ui.base.h.a(bis(), ak.getResources().getString(2131758246), "", ak.getResources().getString(2131760315), null);
          b(null);
          AppMethodBeat.o(45690);
          return;
          l = o.aZR(paramProcessRequest.fSQ());
          break;
          label232:
          localObject = paramProcessRequest.fSQ();
          break label121;
        }
        localObject = new Intent();
        if (paramProcessRequest == null) {}
        for (paramProcessRequest = "";; paramProcessRequest = paramProcessRequest.Lj())
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramProcessRequest);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.br.d.f(bis(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.JsApiShowImageOperateSheet.BottomSheetLogicHelper.d
 * JD-Core Version:    0.7.0.1
 */
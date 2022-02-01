package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.i;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$d
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(45690);
    if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest))
    {
      ac.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
      AppMethodBeat.o(45690);
      return;
    }
    Object localObject = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest)paramProcessRequest);
    paramProcessRequest = i.aKe((String)localObject);
    paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramProcessRequest);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
      ai.getContext();
      paramProcessRequest = paramProcessRequest.XN((String)localObject);
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ad(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().XL(paramProcessRequest);
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
        if (((f.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= b.ZF())) && (localOptions.outWidth <= b.ZF())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if ((l > b.ZG()) || (i != 0))
        {
          h.a(bef(), ai.getResources().getString(2131758246), "", ai.getResources().getString(2131760315), null);
          b(null);
          AppMethodBeat.o(45690);
          return;
          l = i.aSp(paramProcessRequest.ghd());
          break;
          label232:
          localObject = paramProcessRequest.ghd();
          break label121;
        }
        localObject = new Intent();
        if (paramProcessRequest == null) {}
        for (paramProcessRequest = "";; paramProcessRequest = paramProcessRequest.JC())
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramProcessRequest);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.br.d.e(bef(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
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
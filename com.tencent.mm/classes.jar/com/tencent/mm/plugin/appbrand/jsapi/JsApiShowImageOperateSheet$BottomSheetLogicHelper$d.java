package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.y;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$d
  extends AppBrandProxyUIProcessTask
{
  public final void handleRequest(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(45690);
    if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest))
    {
      Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
      AppMethodBeat.o(45690);
      return;
    }
    Object localObject = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest)paramProcessRequest);
    paramProcessRequest = y.bub((String)localObject);
    paramProcessRequest = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramProcessRequest);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr();
      MMApplicationContext.getContext();
      paramProcessRequest = paramProcessRequest.aog((String)localObject);
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.c.d)h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramProcessRequest);
    }
    for (;;)
    {
      long l;
      if (paramProcessRequest == null)
      {
        l = 0L;
        if (paramProcessRequest != null) {
          break label230;
        }
        label121:
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((BitmapUtil.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.k.c.aRh())) && (localOptions.outWidth <= com.tencent.mm.k.c.aRh())) {
          break label304;
        }
      }
      label304:
      for (int i = 1;; i = 0)
      {
        if ((l > com.tencent.mm.k.c.aRi()) || (i != 0))
        {
          k.a(getActivityContext(), getString(ba.i.emoji_custom_gif_max_size_limit_cannot_send), "", getString(ba.i.i_know_it), null);
          finishProcess(null);
          AppMethodBeat.o(45690);
          return;
          l = y.bEl(paramProcessRequest.kMn());
          break;
          label230:
          localObject = paramProcessRequest.kMn();
          break label121;
        }
        localObject = new Intent();
        if (paramProcessRequest == null) {}
        for (paramProcessRequest = "";; paramProcessRequest = paramProcessRequest.getMd5())
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramProcessRequest);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.br.c.g(getActivityContext(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
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
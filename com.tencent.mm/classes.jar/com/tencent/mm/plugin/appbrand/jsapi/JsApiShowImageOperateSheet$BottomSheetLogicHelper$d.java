package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.au.i;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.vfs.u;

final class JsApiShowImageOperateSheet$BottomSheetLogicHelper$d
  extends AppBrandProxyUIProcessTask
{
  public final void a(AppBrandProxyUIProcessTask.ProcessRequest paramProcessRequest)
  {
    AppMethodBeat.i(45690);
    if (!(paramProcessRequest instanceof JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest))
    {
      Log.e("MicroMsg.JsApiShowImageOperateSheet", "IPCSendToFriendEmojiRequest request instance not valid");
      AppMethodBeat.o(45690);
      return;
    }
    Object localObject = JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest.a((JsApiShowImageOperateSheet.BottomSheetLogicHelper.IPCSendToFriendEmojiRequest)paramProcessRequest);
    paramProcessRequest = u.buc((String)localObject);
    paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramProcessRequest);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
      MMApplicationContext.getContext();
      paramProcessRequest = paramProcessRequest.auf((String)localObject);
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aud(paramProcessRequest);
    }
    for (;;)
    {
      long l;
      if (paramProcessRequest == null)
      {
        l = 0L;
        if (paramProcessRequest != null) {
          break label244;
        }
        label121:
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        if (((BitmapUtil.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.n.c.awH())) && (localOptions.outWidth <= com.tencent.mm.n.c.awH())) {
          break label318;
        }
      }
      label318:
      for (int i = 1;; i = 0)
      {
        if ((l > com.tencent.mm.n.c.awI()) || (i != 0))
        {
          paramProcessRequest = bPf();
          i = au.i.emoji_custom_gif_max_size_limit_cannot_send;
          localObject = MMApplicationContext.getResources().getString(i);
          i = au.i.i_know_it;
          com.tencent.mm.ui.base.h.a(paramProcessRequest, (String)localObject, "", MMApplicationContext.getResources().getString(i), null);
          b(null);
          AppMethodBeat.o(45690);
          return;
          l = u.bBQ(paramProcessRequest.ifh());
          break;
          label244:
          localObject = paramProcessRequest.ifh();
          break label121;
        }
        localObject = new Intent();
        if (paramProcessRequest == null) {}
        for (paramProcessRequest = "";; paramProcessRequest = paramProcessRequest.getMd5())
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramProcessRequest);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.by.c.f(bPf(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
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
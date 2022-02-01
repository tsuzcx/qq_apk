package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.s;

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
    paramProcessRequest = s.bhK((String)localObject);
    paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramProcessRequest);
    if (paramProcessRequest == null)
    {
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr();
      MMApplicationContext.getContext();
      paramProcessRequest = paramProcessRequest.amn((String)localObject);
      paramProcessRequest = ((com.tencent.mm.plugin.emoji.b.d)g.ah(com.tencent.mm.plugin.emoji.b.d.class)).getEmojiMgr().aml(paramProcessRequest);
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
        if (((BitmapUtil.decodeFile((String)localObject, localOptions) == null) || (localOptions.outHeight <= com.tencent.mm.n.c.aqo())) && (localOptions.outWidth <= com.tencent.mm.n.c.aqo())) {
          break label306;
        }
      }
      label306:
      for (int i = 1;; i = 0)
      {
        if ((l > com.tencent.mm.n.c.aqp()) || (i != 0))
        {
          h.a(bDF(), MMApplicationContext.getResources().getString(2131758534), "", MMApplicationContext.getResources().getString(2131761757), null);
          b(null);
          AppMethodBeat.o(45690);
          return;
          l = s.boW(paramProcessRequest.hRM());
          break;
          label232:
          localObject = paramProcessRequest.hRM();
          break label121;
        }
        localObject = new Intent();
        if (paramProcessRequest == null) {}
        for (paramProcessRequest = "";; paramProcessRequest = paramProcessRequest.getMd5())
        {
          ((Intent)localObject).putExtra("Retr_File_Name", paramProcessRequest);
          ((Intent)localObject).putExtra("Retr_Msg_Type", 5);
          ((Intent)localObject).putExtra("Retr_MsgImgScene", 1);
          com.tencent.mm.br.c.f(bDF(), ".ui.transmit.MsgRetransmitUI", (Intent)localObject);
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
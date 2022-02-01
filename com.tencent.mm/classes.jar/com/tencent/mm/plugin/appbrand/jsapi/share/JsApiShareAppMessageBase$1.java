package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.IWWAPI.WWAppType;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaMiniProgram;

final class JsApiShareAppMessageBase$1
  implements Runnable
{
  JsApiShareAppMessageBase$1(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, c paramc, int paramInt, JsApiShareAppMessageBase.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(282498);
    JsApiShareAppMessageBase localJsApiShareAppMessageBase = this.ppj;
    c localc = this.nAX;
    int j = this.cuf;
    Object localObject2 = this.ppi;
    Log.i("MicroMsg.JsApiShareAppMessageBase", "sendToWework");
    Object localObject1 = localc.getRuntime().bDx();
    WWMediaMiniProgram localWWMediaMiniProgram = new WWMediaMiniProgram();
    localWWMediaMiniProgram.username = ((JsApiShareAppMessageBase.d)localObject2).userName;
    localWWMediaMiniProgram.path = ((JsApiShareAppMessageBase.d)localObject2).fve;
    localWWMediaMiniProgram.title = ((JsApiShareAppMessageBase.d)localObject2).title;
    if (TextUtils.isEmpty(localWWMediaMiniProgram.title)) {
      localWWMediaMiniProgram.title = ((l)localObject1).fzM;
    }
    localWWMediaMiniProgram.ZYx = ((JsApiShareAppMessageBase.d)localObject2).fES;
    localWWMediaMiniProgram.type = 0;
    if (localObject1 != null)
    {
      localWWMediaMiniProgram.name = ((l)localObject1).fzM;
      localWWMediaMiniProgram.iconUrl = ((l)localObject1).mnM;
    }
    Log.i("MicroMsg.JsApiShareAppMessageBase", "username:%s, path:%s, title:%s, name:%s, iconUrl:%s, miniProgramType:%d, imgPath:%s", new Object[] { localWWMediaMiniProgram.username, localWWMediaMiniProgram.path, localWWMediaMiniProgram.title, localWWMediaMiniProgram.name, localWWMediaMiniProgram.iconUrl, Integer.valueOf(localWWMediaMiniProgram.ZYx), ((JsApiShareAppMessageBase.d)localObject2).fKH });
    if (!TextUtils.isEmpty(((JsApiShareAppMessageBase.d)localObject2).fKH)) {
      localObject1 = ((JsApiShareAppMessageBase.d)localObject2).fKH;
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiShareAppMessageBase", "imageUrl:%s", new Object[] { ((JsApiShareAppMessageBase.d)localObject2).imageUrl });
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = z.aiD((String)localObject1);
        localObject2 = (com.tencent.mm.plugin.appbrand.f.a)localc.K(com.tencent.mm.plugin.appbrand.f.a.class);
        if (com.tencent.mm.pluginsdk.k.a.d.a.agG((String)localObject1))
        {
          localObject1 = n.aIt((String)localObject1);
          if (localObject1 != null) {
            JsApiShareAppMessageBase.a((Bitmap)localObject1, localWWMediaMiniProgram);
          }
          i = 1;
          label297:
          if (i == 0) {}
        }
      }
      try
      {
        WWAPIFactory.mw(localc.getContext()).a(localWWMediaMiniProgram, IWWAPI.WWAppType.ZYb);
        localc.j(j, localJsApiShareAppMessageBase.h("ok", null));
        AppMethodBeat.o(282498);
        return;
        localObject1 = ((JsApiShareAppMessageBase.d)localObject2).imageUrl;
        continue;
        if (localObject2 != null)
        {
          Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap imagePath:%s", new Object[] { localObject1 });
          localObject1 = ((com.tencent.mm.plugin.appbrand.f.a)localObject2).a((String)localObject1, null, new JsApiShareAppMessageBase.6(localJsApiShareAppMessageBase, localWWMediaMiniProgram, localc, j));
          if (localObject1 != null)
          {
            Log.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap success");
            JsApiShareAppMessageBase.a((Bitmap)localObject1, localWWMediaMiniProgram);
            i = 1;
            break label297;
          }
          Log.i("MicroMsg.JsApiShareAppMessageBase", "don't send message");
          i = 0;
          break label297;
        }
        localWWMediaMiniProgram.ZYw = new byte[1];
        Log.e("MicroMsg.JsApiShareAppMessageBase", "loader is null");
        i = 1;
        break label297;
        Log.e("MicroMsg.JsApiShareAppMessageBase", "imgPath is empty");
        localWWMediaMiniProgram.ZYw = new byte[1];
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.1
 * JD-Core Version:    0.7.0.1
 */
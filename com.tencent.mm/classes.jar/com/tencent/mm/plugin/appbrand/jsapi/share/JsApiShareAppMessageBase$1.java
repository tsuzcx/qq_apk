package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.gallery.model.p;
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
    AppMethodBeat.i(326425);
    JsApiShareAppMessageBase localJsApiShareAppMessageBase = this.stX;
    c localc = this.qAj;
    int j = this.elZ;
    Object localObject2 = this.stW;
    Log.i("MicroMsg.JsApiShareAppMessageBase", "sendToWework");
    Object localObject1 = localc.getRuntime().ccM();
    WWMediaMiniProgram localWWMediaMiniProgram = new WWMediaMiniProgram();
    localWWMediaMiniProgram.username = ((JsApiShareAppMessageBase.d)localObject2).userName;
    localWWMediaMiniProgram.path = ((JsApiShareAppMessageBase.d)localObject2).hzy;
    localWWMediaMiniProgram.title = ((JsApiShareAppMessageBase.d)localObject2).title;
    if (TextUtils.isEmpty(localWWMediaMiniProgram.title)) {
      localWWMediaMiniProgram.title = ((n)localObject1).hEy;
    }
    localWWMediaMiniProgram.miniProgramType = ((JsApiShareAppMessageBase.d)localObject2).hJK;
    localWWMediaMiniProgram.type = 0;
    if (localObject1 != null)
    {
      localWWMediaMiniProgram.name = ((n)localObject1).hEy;
      localWWMediaMiniProgram.iconUrl = ((n)localObject1).phA;
    }
    Log.i("MicroMsg.JsApiShareAppMessageBase", "username:%s, path:%s, title:%s, name:%s, iconUrl:%s, miniProgramType:%d, imgPath:%s", new Object[] { localWWMediaMiniProgram.username, localWWMediaMiniProgram.path, localWWMediaMiniProgram.title, localWWMediaMiniProgram.name, localWWMediaMiniProgram.iconUrl, Integer.valueOf(localWWMediaMiniProgram.miniProgramType), ((JsApiShareAppMessageBase.d)localObject2).hQn });
    if (!TextUtils.isEmpty(((JsApiShareAppMessageBase.d)localObject2).hQn)) {
      localObject1 = ((JsApiShareAppMessageBase.d)localObject2).hQn;
    }
    for (;;)
    {
      Log.i("MicroMsg.JsApiShareAppMessageBase", "imageUrl:%s", new Object[] { ((JsApiShareAppMessageBase.d)localObject2).imageUrl });
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = x.abD((String)localObject1);
        localObject2 = (com.tencent.mm.plugin.appbrand.f.a)localc.T(com.tencent.mm.plugin.appbrand.f.a.class);
        if (com.tencent.mm.pluginsdk.res.downloader.b.a.ZC((String)localObject1))
        {
          localObject1 = p.aER((String)localObject1);
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
        WWAPIFactory.oM(localc.getContext()).a(localWWMediaMiniProgram, IWWAPI.WWAppType.aicA);
        localc.callback(j, localJsApiShareAppMessageBase.ZP("ok"));
        AppMethodBeat.o(326425);
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
        localWWMediaMiniProgram.aida = new byte[1];
        Log.e("MicroMsg.JsApiShareAppMessageBase", "loader is null");
        i = 1;
        break label297;
        Log.e("MicroMsg.JsApiShareAppMessageBase", "imgPath is empty");
        localWWMediaMiniProgram.aida = new byte[1];
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
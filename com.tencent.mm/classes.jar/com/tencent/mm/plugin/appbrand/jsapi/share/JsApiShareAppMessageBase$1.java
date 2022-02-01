package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.service.c;
import com.tencent.mm.plugin.gallery.model.n;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.wework.api.IWWAPI;
import com.tencent.wework.api.WWAPIFactory;
import com.tencent.wework.api.model.WWMediaMiniProgram;

final class JsApiShareAppMessageBase$1
  implements Runnable
{
  JsApiShareAppMessageBase$1(JsApiShareAppMessageBase paramJsApiShareAppMessageBase, c paramc, int paramInt, JsApiShareAppMessageBase.d paramd) {}
  
  public final void run()
  {
    AppMethodBeat.i(222670);
    JsApiShareAppMessageBase localJsApiShareAppMessageBase = this.llo;
    c localc = this.kvs;
    int j = this.cjS;
    Object localObject2 = this.lln;
    ae.i("MicroMsg.JsApiShareAppMessageBase", "sendToWework");
    Object localObject1 = localc.getRuntime().aXw();
    WWMediaMiniProgram localWWMediaMiniProgram = new WWMediaMiniProgram();
    localWWMediaMiniProgram.username = ((JsApiShareAppMessageBase.d)localObject2).userName;
    localWWMediaMiniProgram.path = ((JsApiShareAppMessageBase.d)localObject2).dlk;
    localWWMediaMiniProgram.title = ((JsApiShareAppMessageBase.d)localObject2).title;
    if (TextUtils.isEmpty(localWWMediaMiniProgram.title)) {
      localWWMediaMiniProgram.title = ((k)localObject1).dpI;
    }
    localWWMediaMiniProgram.MLu = ((JsApiShareAppMessageBase.d)localObject2).duK;
    localWWMediaMiniProgram.type = 0;
    if (localObject1 != null)
    {
      localWWMediaMiniProgram.name = ((k)localObject1).dpI;
      localWWMediaMiniProgram.iconUrl = ((k)localObject1).iCT;
    }
    ae.i("MicroMsg.JsApiShareAppMessageBase", "username:%s, path:%s, title:%s, name:%s, iconUrl:%s, miniProgramType:%d, imgPath:%s", new Object[] { localWWMediaMiniProgram.username, localWWMediaMiniProgram.path, localWWMediaMiniProgram.title, localWWMediaMiniProgram.name, localWWMediaMiniProgram.iconUrl, Integer.valueOf(localWWMediaMiniProgram.MLu), ((JsApiShareAppMessageBase.d)localObject2).dzD });
    if (!TextUtils.isEmpty(((JsApiShareAppMessageBase.d)localObject2).dzD)) {
      localObject1 = ((JsApiShareAppMessageBase.d)localObject2).dzD;
    }
    for (;;)
    {
      ae.i("MicroMsg.JsApiShareAppMessageBase", "imageUrl:%s", new Object[] { ((JsApiShareAppMessageBase.d)localObject2).hBa });
      int i;
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = r.Ri((String)localObject1);
        localObject2 = (com.tencent.mm.plugin.appbrand.f.a)localc.K(com.tencent.mm.plugin.appbrand.f.a.class);
        if (com.tencent.mm.pluginsdk.j.a.d.a.fB((String)localObject1))
        {
          localObject1 = n.alP((String)localObject1);
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
        WWAPIFactory.lz(localc.getContext()).a(localWWMediaMiniProgram);
        localc.h(j, localJsApiShareAppMessageBase.e("ok", null));
        AppMethodBeat.o(222670);
        return;
        localObject1 = ((JsApiShareAppMessageBase.d)localObject2).hBa;
        continue;
        if (localObject2 != null)
        {
          ae.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap imagePath:%s", new Object[] { localObject1 });
          localObject1 = ((com.tencent.mm.plugin.appbrand.f.a)localObject2).a((String)localObject1, null, new JsApiShareAppMessageBase.6(localJsApiShareAppMessageBase, localWWMediaMiniProgram, localc, j));
          if (localObject1 != null)
          {
            ae.i("MicroMsg.JsApiShareAppMessageBase", "load bitmap success");
            JsApiShareAppMessageBase.a((Bitmap)localObject1, localWWMediaMiniProgram);
            i = 1;
            break label297;
          }
          ae.i("MicroMsg.JsApiShareAppMessageBase", "don't send message");
          i = 0;
          break label297;
        }
        localWWMediaMiniProgram.MLt = new byte[1];
        ae.e("MicroMsg.JsApiShareAppMessageBase", "loader is null");
        i = 1;
        break label297;
        ae.e("MicroMsg.JsApiShareAppMessageBase", "imgPath is empty");
        localWWMediaMiniProgram.MLt = new byte[1];
        i = 1;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("MicroMsg.JsApiShareAppMessageBase", localException, "", new Object[0]);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.share.JsApiShareAppMessageBase.1
 * JD-Core Version:    0.7.0.1
 */
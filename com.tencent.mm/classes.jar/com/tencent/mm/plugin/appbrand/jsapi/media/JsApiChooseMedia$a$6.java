package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.ArrayList;

final class JsApiChooseMedia$a$6
  implements Runnable
{
  JsApiChooseMedia$a$6(JsApiChooseMedia.a parama, boolean paramBoolean, String paramString) {}
  
  public final void run()
  {
    AppMethodBeat.i(131175);
    if (this.hQP) {}
    for (Object localObject = JsApiChooseMedia.a.access$1500(this.val$filePath);; localObject = this.val$filePath)
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject = AppBrandLocalMediaObjectManager.j(JsApiChooseMedia.a.h(this.hRe).appId, (String)localObject, this.hQP | true);
      if (localObject == null) {
        break;
      }
      localArrayList1.add(Long.valueOf(((AppBrandLocalMediaObject)localObject).gmb));
      localArrayList2.add(((AppBrandLocalMediaObject)localObject).ctV);
      al.d(new JsApiChooseMedia.a.6.1(this, localArrayList2, localArrayList1));
      AppMethodBeat.o(131175);
      return;
    }
    ab.e("MicroMsg.JsApiChooseMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
    JsApiChooseMedia.a.e(this.hRe).bpE = -2;
    JsApiChooseMedia.a.h(this.hRe, JsApiChooseMedia.a.e(this.hRe));
    AppMethodBeat.o(131175);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia.a.6
 * JD-Core Version:    0.7.0.1
 */
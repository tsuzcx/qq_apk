package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObjectManager;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Calendar;

final class JsApiChooseMultiMedia$a$2
  implements Runnable
{
  JsApiChooseMultiMedia$a$2(JsApiChooseMultiMedia.a parama, boolean paramBoolean, String paramString, double paramDouble1, double paramDouble2) {}
  
  public final void run()
  {
    AppMethodBeat.i(131231);
    Object localObject1;
    JsApiChooseMultiMedia.b localb;
    long l;
    double d;
    Object localObject2;
    if (this.hQP)
    {
      localObject1 = JsApiChooseMultiMedia.a.Cw(this.val$filePath);
      localb = JsApiChooseMultiMedia.Ct((String)localObject1);
      localObject1 = AppBrandLocalMediaObjectManager.j(this.hRC.hRy.appId, (String)localObject1, this.hQP | true);
      if (localObject1 == null) {
        break label261;
      }
      l = Calendar.getInstance().getTimeInMillis() / 1000L;
      d = -1.0D;
      if ((!a.q(this.fCg)) || (!a.p(this.fCh))) {
        break label240;
      }
      localObject2 = JsApiChooseMultiMedia.a.aDP();
      if (localObject2 == null) {
        break label219;
      }
      d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).cyV, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject2).fFN, this.fCg, this.fCh);
    }
    for (;;)
    {
      localObject2 = JsApiChooseMultiMedia.a.a(l, d);
      ab.i("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight is done.");
      this.hRC.hRz.bpE = -1;
      this.hRC.hRz.hRx = JsApiChooseMultiMedia.a.b(((AppBrandLocalMediaObject)localObject1).ctV, ((AppBrandLocalMediaObject)localObject1).gmb, localb.width, localb.height, localb.hha, (String)localObject2);
      JsApiChooseMultiMedia.a.c(this.hRC, this.hRC.hRz);
      AppMethodBeat.o(131231);
      return;
      localObject1 = this.val$filePath;
      break;
      label219:
      ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. pic_Path: %s.", new Object[] { this.val$filePath });
      continue;
      label240:
      ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. pic_Path: %s.", new Object[] { this.val$filePath });
    }
    label261:
    ab.e("MicroMsg.JsApiChooseMultiMedia", "handle image from mm-sight camera, get null obj from path: %s", new Object[] { this.val$filePath });
    this.hRC.hRz.bpE = -2;
    JsApiChooseMultiMedia.a.d(this.hRC, this.hRC.hRz);
    AppMethodBeat.o(131231);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.2
 * JD-Core Version:    0.7.0.1
 */
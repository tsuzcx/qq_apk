package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.map.geolocation.TencentLocationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.a;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalVideoObject;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.ExifHelper.LatLongData;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.File;
import java.util.Calendar;

final class JsApiChooseMultiMedia$a$3
  implements Runnable
{
  JsApiChooseMultiMedia$a$3(JsApiChooseMultiMedia.a parama, String paramString, double paramDouble1, double paramDouble2) {}
  
  public final void run()
  {
    AppMethodBeat.i(131232);
    AppBrandLocalVideoObject localAppBrandLocalVideoObject;
    if (new File(this.hRD).exists())
    {
      ab.i("MicroMsg.JsApiChooseMultiMedia", "take media camera, the mVideoFilePath file exist, success");
      this.hRC.hRz.bpE = -1;
      localAppBrandLocalVideoObject = JsApiChooseMultiMedia.a.a(this.hRC, this.hRD, false);
      if (localAppBrandLocalVideoObject == null)
      {
        ab.e("MicroMsg.JsApiChooseMultiMedia", "addVideoItem fail ,mVideoFilePath is %s", new Object[] { this.hRD });
        this.hRC.hRz.bpE = -2;
        JsApiChooseMultiMedia.a.e(this.hRC, this.hRC.hRz);
        AppMethodBeat.o(131232);
        return;
      }
      str = JsApiChooseMultiMedia.a.Cy(this.hRD);
      if (bo.isNullOrNil(str)) {
        break label368;
      }
    }
    label368:
    for (String str = JsApiChooseMultiMedia.a.a(this.hRC, str);; str = "")
    {
      long l = Calendar.getInstance().getTimeInMillis() / 1000L;
      double d = -1.0D;
      Object localObject;
      if ((a.q(this.fCg)) && (a.p(this.fCh)))
      {
        localObject = JsApiChooseMultiMedia.a.aDP();
        if (localObject != null) {
          d = TencentLocationUtils.distanceBetween(((BackwardSupportUtil.ExifHelper.LatLongData)localObject).cyV, ((BackwardSupportUtil.ExifHelper.LatLongData)localObject).fFN, this.fCg, this.fCh);
        }
      }
      for (;;)
      {
        localObject = JsApiChooseMultiMedia.a.a(l, d);
        this.hRC.hRz.hRx = JsApiChooseMultiMedia.a.b(localAppBrandLocalVideoObject.ctV, localAppBrandLocalVideoObject.size, localAppBrandLocalVideoObject.width, localAppBrandLocalVideoObject.height, localAppBrandLocalVideoObject.duration, str, (String)localObject);
        JsApiChooseMultiMedia.a.f(this.hRC, this.hRC.hRz);
        AppMethodBeat.o(131232);
        return;
        ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, locData is null. video_Path: %s.", new Object[] { this.hRD });
        continue;
        ab.w("MicroMsg.JsApiChooseMultiMedia", "calculate X fail, lat/long is invalid. video_Path: %s.", new Object[] { this.hRD });
      }
      ab.e("MicroMsg.JsApiChooseMultiMedia", "take media camera, mVideoFilePath is %s, the file not exist, fail", new Object[] { this.hRD });
      this.hRC.hRz.bpE = -2;
      JsApiChooseMultiMedia.a.g(this.hRC, this.hRC.hRz);
      AppMethodBeat.o(131232);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMultiMedia.a.3
 * JD-Core Version:    0.7.0.1
 */
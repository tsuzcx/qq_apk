package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mmsight.SightParams;

final class JsApiChooseImage$a$2
  implements Runnable
{
  JsApiChooseImage$a$2(JsApiChooseImage.a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(46410);
    if (this.mcv.mcs) {
      JsApiChooseImage.a.a(this.mcv);
    }
    Object localObject = GetSightParamsIPCTask.mbY;
    localObject = GetSightParamsIPCTask.a.p(2, 0, false);
    ((SightParams)localObject).zsP = false;
    Intent localIntent = new Intent();
    localIntent.setClassName(JsApiChooseImage.a.b(this.mcv), "com.tencent.mm.plugin.mmsight.ui.SightCaptureUI");
    localIntent.putExtra("KEY_SIGHT_PARAMS", (Parcelable)localObject);
    JsApiChooseImage.a.a(this.mcv, localIntent);
    AppMethodBeat.o(46410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseImage.a.2
 * JD-Core Version:    0.7.0.1
 */
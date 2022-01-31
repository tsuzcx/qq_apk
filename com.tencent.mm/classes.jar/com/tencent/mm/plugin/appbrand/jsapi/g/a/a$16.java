package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$16
  implements TencentMap.OnScreenShotListener
{
  a$16(a parama) {}
  
  public final void onMapScreenShot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(138424);
    ab.v("MicroMsg.DefaultTencentMapView", "updateScreenCapture end");
    if (paramBitmap != null) {
      a.j(this.hOM).setImageBitmap(paramBitmap);
    }
    a.o(this.hOM).set(false);
    AppMethodBeat.o(138424);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.16
 * JD-Core Version:    0.7.0.1
 */
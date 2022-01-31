package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;
import java.util.concurrent.atomic.AtomicBoolean;

final class a$14
  implements TencentMap.OnScreenShotListener
{
  a$14(a parama) {}
  
  public final void onMapScreenShot(Bitmap paramBitmap)
  {
    y.v("MicroMsg.DefaultTencentMapView", "updateScreenCapture end");
    if (paramBitmap != null) {
      this.gtW.bNu.setImageBitmap(paramBitmap);
    }
    this.gtW.gtU.set(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.14
 * JD-Core Version:    0.7.0.1
 */
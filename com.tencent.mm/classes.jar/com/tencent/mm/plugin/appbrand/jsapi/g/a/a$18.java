package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

final class a$18
  implements TencentMap.OnScreenShotListener
{
  a$18(a parama) {}
  
  public final void onMapScreenShot(Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      this.gtW.bNu.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.18
 * JD-Core Version:    0.7.0.1
 */
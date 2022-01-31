package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnScreenShotListener;

final class a$21
  implements TencentMap.OnScreenShotListener
{
  a$21(a parama) {}
  
  public final void onMapScreenShot(Bitmap paramBitmap)
  {
    AppMethodBeat.i(51172);
    if (paramBitmap != null) {
      a.j(this.hOM).setImageBitmap(paramBitmap);
    }
    AppMethodBeat.o(51172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.21
 * JD-Core Version:    0.7.0.1
 */
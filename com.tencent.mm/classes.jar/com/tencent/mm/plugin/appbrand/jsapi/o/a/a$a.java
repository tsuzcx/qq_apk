package com.tencent.mm.plugin.appbrand.jsapi.o.a;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.g.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;

public final class a$a
  implements TencentMap.InfoWindowAdapter
{
  public a$a(a parama) {}
  
  public final View getInfoWindow(Marker paramMarker)
  {
    AppMethodBeat.i(146488);
    if (paramMarker == null)
    {
      AppMethodBeat.o(146488);
      return null;
    }
    if (Util.isNullOrNil((String)paramMarker.getTag()))
    {
      Log.w("MicroMsg.Map.DefaultTencentMapView", "realMarker.getTag is null, return");
      AppMethodBeat.o(146488);
      return null;
    }
    if (((String)paramMarker.getTag()).endsWith("#label"))
    {
      AppMethodBeat.o(146488);
      return null;
    }
    paramMarker = this.scU.aaH((String)paramMarker.getTag());
    if (paramMarker == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "[getInfoWindow] appbrandMarker is null, return");
      AppMethodBeat.o(146488);
      return null;
    }
    if (paramMarker.sec == null)
    {
      Log.e("MicroMsg.Map.DefaultTencentMapView", "[getInfoWindow] appBrandMarker.appBrandMarkerOptions is null, return");
      AppMethodBeat.o(146488);
      return null;
    }
    Object localObject2 = paramMarker.sec.sei;
    if (localObject2 == null)
    {
      AppMethodBeat.o(146488);
      return null;
    }
    boolean bool;
    if (((b.v.a)localObject2).view != null) {
      bool = true;
    }
    for (;;)
    {
      Log.i("MicroMsg.Map.DefaultTencentMapView", "marker:%s calloutStyle.view is %b", new Object[] { paramMarker, Boolean.valueOf(bool) });
      if (((b.v.a)localObject2).view != null)
      {
        if (paramMarker.sdJ == null) {
          paramMarker.sdJ = new ImageView(a.u(this.scU));
        }
        localObject2 = BitmapUtil.getBitmapFromView(((b.v.a)localObject2).view);
        if (localObject2 == null) {
          Log.e("MicroMsg.Map.DefaultTencentMapView", "marker:%s calloutStyle.view exist but bitmap is null");
        }
        synchronized (a.v(this.scU))
        {
          if (paramMarker.sdJ != null) {
            paramMarker.sdJ.setImageBitmap((Bitmap)localObject2);
          }
          paramMarker = paramMarker.sdJ;
          AppMethodBeat.o(146488);
          return paramMarker;
          bool = false;
        }
      }
    }
    a locala = this.scU;
    ??? = i.ctc();
    paramMarker = (Marker)???;
    if (??? == null) {
      paramMarker = new b(locala.context);
    }
    paramMarker.setText("");
    paramMarker.setTextSize(12);
    paramMarker.setTextColor(b.uMs);
    paramMarker.setTitlePadding(0);
    paramMarker.setGravity("center");
    int i = b.uMt;
    paramMarker.J(0, 0, i, i);
    paramMarker.setText(((b.v.a)localObject2).content);
    paramMarker.setTextSize(((b.v.a)localObject2).fontSize);
    paramMarker.setTextColor(((b.v.a)localObject2).color);
    paramMarker.setTitlePadding(((b.v.a)localObject2).padding);
    paramMarker.setGravity(((b.v.a)localObject2).qTN);
    paramMarker.J(((b.v.a)localObject2).sek, ((b.v.a)localObject2).borderWidth, ((b.v.a)localObject2).borderColor, ((b.v.a)localObject2).bgColor);
    AppMethodBeat.o(146488);
    return paramMarker;
  }
  
  public final void onInfoWindowDettached(Marker paramMarker, View paramView)
  {
    AppMethodBeat.i(146489);
    if ((paramView instanceof b))
    {
      Log.d("MicroMsg.Map.DefaultTencentMapView", "recycler calloutView");
      i.a((b)paramView);
    }
    AppMethodBeat.o(146489);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.o.a.a.a
 * JD-Core Version:    0.7.0.1
 */
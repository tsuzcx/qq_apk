package com.tencent.mapsdk.rastercore;

import android.content.Context;
import com.f.a.a.a.a.a;
import com.f.a.a.a.a.d;
import com.f.a.a.a.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.vfs.o;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class MapProvider
{
  private TencentMapOptions mTencentMapOptions;
  
  public static String getMapSdkPath()
  {
    AppMethodBeat.i(212531);
    String str = b.ask() + "mapsdk";
    if (!o.fB(str)) {
      o.aZI(str);
    }
    ae.d("MapProvider", "path:%s", new Object[] { str });
    AppMethodBeat.o(212531);
    return str;
  }
  
  public IMapView getMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(212530);
    int i = 0;
    this.mTencentMapOptions = paramTencentMapOptions;
    if (this.mTencentMapOptions != null) {
      i = this.mTencentMapOptions.getMapType();
    }
    switch (i)
    {
    default: 
      paramContext = new d(paramContext, this.mTencentMapOptions);
    }
    for (;;)
    {
      AppMethodBeat.o(212530);
      return paramContext;
      LogHelper.e("maptype", "glmapview");
      paramContext = new d(paramContext, this.mTencentMapOptions);
      continue;
      paramContext = new a(paramContext, this.mTencentMapOptions);
      LogHelper.e("maptype", "texturemapview");
      continue;
      paramContext = new j(paramContext, this.mTencentMapOptions);
      LogHelper.e("maptype", "maprenderlayer");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.MapProvider
 * JD-Core Version:    0.7.0.1
 */
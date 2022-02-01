package com.tencent.mapsdk.rastercore;

import android.content.Context;
import com.j.a.a.a.a.a;
import com.j.a.a.a.a.d;
import com.j.a.a.a.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import com.tencent.tencentmap.mapsdk.map.IMapView;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;

public class MapProvider
{
  private TencentMapOptions mTencentMapOptions;
  
  public static String getMapSdkPath()
  {
    AppMethodBeat.i(221357);
    String str = b.bmA() + "mapsdk";
    if (!y.ZC(str)) {
      y.bDX(str);
    }
    Log.d("MapProvider", "path:%s", new Object[] { str });
    AppMethodBeat.o(221357);
    return str;
  }
  
  public IMapView getMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(221362);
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
      AppMethodBeat.o(221362);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.MapProvider
 * JD-Core Version:    0.7.0.1
 */
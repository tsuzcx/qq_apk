package com.tencent.mm.plugin.appbrand.jsapi.al.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.o.a.f;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.util.Map;

public final class b
  extends a
{
  private int mHeight;
  private Surface mSurface;
  private int mWidth;
  
  public b(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    super(paramContext, paramString, paramMap);
  }
  
  public final void B(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139540);
    if (this.mSurface == null)
    {
      AppMethodBeat.o(139540);
      return;
    }
    if (this.sbN != null) {
      this.sbN.dispatchTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(139540);
  }
  
  public final TencentMapOptions P(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(139539);
    TencentMapOptions localTencentMapOptions = super.P(paramMap);
    if (paramMap != null)
    {
      localObject = paramMap.get("surface");
      if (!(localObject instanceof Surface)) {}
    }
    for (Object localObject = (Surface)localObject;; localObject = null)
    {
      this.mSurface = ((Surface)localObject);
      if (this.mSurface == null)
      {
        Log.e("MicroMsg.SameLayerMapView", "mSurface is null, return");
        this.mSurface = new Surface(new SurfaceTexture(0));
      }
      localTencentMapOptions.setExtSurface(this.mSurface);
      this.mWidth = f.a(paramMap, "width", 0);
      this.mHeight = f.a(paramMap, "height", 0);
      Log.i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      localTencentMapOptions.setExtSurfaceDimension(this.mWidth, this.mHeight);
      localTencentMapOptions.setMapType(2);
      AppMethodBeat.o(139539);
      return localTencentMapOptions;
    }
  }
  
  public final boolean csM()
  {
    return true;
  }
  
  public final void m(Surface paramSurface)
  {
    AppMethodBeat.i(327084);
    if ((paramSurface != null) && (this.mSurface != paramSurface))
    {
      Surface localSurface = this.mSurface;
      this.mSurface = paramSurface;
      this.sbN.onSurfaceChanged(this.mSurface, this.mWidth, this.mHeight);
      if (localSurface != null) {
        localSurface.release();
      }
    }
    AppMethodBeat.o(327084);
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139541);
    if (this.mSurface != null)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
    }
    try
    {
      this.sbN.onSizeChanged(paramInt1, paramInt2, paramInt1, paramInt2);
      AppMethodBeat.o(139541);
      return;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.SameLayerMapView", "onSizeChanged :%s", new Object[] { localException });
      if ((BuildInfo.IS_FLAVOR_RED) || (BuildInfo.DEBUG))
      {
        AppMethodBeat.o(139541);
        throw localException;
      }
      AppMethodBeat.o(139541);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.d.b
 * JD-Core Version:    0.7.0.1
 */
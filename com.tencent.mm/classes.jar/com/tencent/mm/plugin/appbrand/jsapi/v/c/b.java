package com.tencent.mm.plugin.appbrand.jsapi.v.c;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.g.a.a;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.tencentmap.mapsdk.map.TencentMapOptions;
import java.util.Map;

public final class b
  extends a
{
  private int mHeight;
  private SurfaceTexture mSurfaceTexture;
  private int mWidth;
  
  public b(Context paramContext, String paramString, Map<String, Object> paramMap)
  {
    super(paramContext, paramString, paramMap);
  }
  
  public final TencentMapOptions B(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(117350);
    TencentMapOptions localTencentMapOptions = super.B(paramMap);
    if (paramMap != null)
    {
      localObject = paramMap.get("surface");
      if (!(localObject instanceof SurfaceTexture)) {}
    }
    for (Object localObject = (SurfaceTexture)localObject;; localObject = null)
    {
      this.mSurfaceTexture = ((SurfaceTexture)localObject);
      if (this.mSurfaceTexture == null)
      {
        ab.e("MicroMsg.SameLayerMapView", "mSurface is null, return");
        this.mSurfaceTexture = new SurfaceTexture(0);
      }
      localTencentMapOptions.setExtSurface(new Surface(this.mSurfaceTexture));
      this.mWidth = com.tencent.mm.plugin.appbrand.jsapi.g.a.f.a(paramMap, "width", 0);
      this.mHeight = com.tencent.mm.plugin.appbrand.jsapi.g.a.f.a(paramMap, "height", 0);
      ab.i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      localTencentMapOptions.setExtSurfaceDimension(this.mWidth, this.mHeight);
      localTencentMapOptions.setMapType(2);
      this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
      AppMethodBeat.o(117350);
      return localTencentMapOptions;
    }
  }
  
  public final boolean aDx()
  {
    return true;
  }
  
  public final void g(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(140062);
    if (paramSurfaceTexture != null)
    {
      this.mSurfaceTexture = paramSurfaceTexture;
      this.hOi.onSurfaceChanged(this.mSurfaceTexture, this.mWidth, this.mHeight);
    }
    AppMethodBeat.o(140062);
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(117352);
    if (this.mSurfaceTexture != null)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    }
    try
    {
      this.hOi.onSizeChanged(paramInt1, paramInt2, paramInt1, paramInt2);
      AppMethodBeat.o(117352);
      return;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.SameLayerMapView", "onSizeChanged :%s", new Object[] { localException });
      if ((com.tencent.mm.sdk.platformtools.f.IS_FLAVOR_RED) || (com.tencent.mm.sdk.platformtools.f.DEBUG))
      {
        AppMethodBeat.o(117352);
        throw localException;
      }
      AppMethodBeat.o(117352);
    }
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(117351);
    if (this.mSurfaceTexture == null)
    {
      AppMethodBeat.o(117351);
      return;
    }
    if (this.hOi != null) {
      this.hOi.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(117351);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.ac.d;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.i.a.f;
import com.tencent.mm.plugin.location_soso.api.SoSoMapView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.i;
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
  
  public final TencentMapOptions F(Map<String, Object> paramMap)
  {
    AppMethodBeat.i(139539);
    TencentMapOptions localTencentMapOptions = super.F(paramMap);
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
        ad.e("MicroMsg.SameLayerMapView", "mSurface is null, return");
        this.mSurfaceTexture = new SurfaceTexture(0);
      }
      localTencentMapOptions.setExtSurface(this.mSurfaceTexture);
      this.mWidth = f.a(paramMap, "width", 0);
      this.mHeight = f.a(paramMap, "height", 0);
      ad.i("MicroMsg.SameLayerMapView", "handler insert, position:[%d, %d]", new Object[] { Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight) });
      localTencentMapOptions.setExtSurfaceDimension(this.mWidth, this.mHeight);
      localTencentMapOptions.setMapType(2);
      this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
      AppMethodBeat.o(139539);
      return localTencentMapOptions;
    }
  }
  
  public final boolean bkR()
  {
    return true;
  }
  
  public final void g(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(139542);
    if ((paramSurfaceTexture != null) && (this.mSurfaceTexture != paramSurfaceTexture))
    {
      SurfaceTexture localSurfaceTexture = this.mSurfaceTexture;
      this.mSurfaceTexture = paramSurfaceTexture;
      this.kPJ.onSurfaceChanged(this.mSurfaceTexture, this.mWidth, this.mHeight);
      this.mSurfaceTexture.setDefaultBufferSize(this.mWidth, this.mHeight);
      if (localSurfaceTexture != null) {
        localSurfaceTexture.release();
      }
    }
    AppMethodBeat.o(139542);
  }
  
  public final void onSizeChanged(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139541);
    if (this.mSurfaceTexture != null)
    {
      this.mWidth = paramInt1;
      this.mHeight = paramInt2;
      this.mSurfaceTexture.setDefaultBufferSize(paramInt1, paramInt2);
    }
    try
    {
      this.kPJ.onSizeChanged(paramInt1, paramInt2, paramInt1, paramInt2);
      AppMethodBeat.o(139541);
      return;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.SameLayerMapView", "onSizeChanged :%s", new Object[] { localException });
      if ((i.IS_FLAVOR_RED) || (i.DEBUG))
      {
        AppMethodBeat.o(139541);
        throw localException;
      }
      AppMethodBeat.o(139541);
    }
  }
  
  public final void onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(139540);
    if (this.mSurfaceTexture == null)
    {
      AppMethodBeat.o(139540);
      return;
    }
    if (this.kPJ != null) {
      this.kPJ.onTouchEvent(paramMotionEvent);
    }
    AppMethodBeat.o(139540);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.d.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ad.a.a.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class SameLayerCameraView
  extends AppBrandCameraView
  implements g
{
  private SurfaceTexture mSurfaceTexture;
  
  public SameLayerCameraView(Context paramContext)
  {
    super(paramContext);
  }
  
  public SameLayerCameraView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public SameLayerCameraView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static void bkn()
  {
    AppMethodBeat.i(46224);
    com.tencent.mm.plugin.appbrand.jsapi.ad.a.a.lBy = new a.a()
    {
      public final f ds(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46222);
        paramAnonymousContext = new SameLayerCameraView(paramAnonymousContext);
        AppMethodBeat.o(46222);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(46224);
  }
  
  protected final AppBrandCameraView.a Qh(String paramString)
  {
    AppMethodBeat.i(46228);
    if ((!bu.isNullOrNil(paramString)) && (paramString.equals("scanCode")))
    {
      paramString = new SameLayerCameraView.a(this);
      AppMethodBeat.o(46228);
      return paramString;
    }
    paramString = super.Qh(paramString);
    AppMethodBeat.o(46228);
    return paramString;
  }
  
  protected final MMSightRecordView e(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46226);
    paramContext = new MMSightRecordView(paramContext, this.mSurfaceTexture, paramInt1, paramInt2);
    AppMethodBeat.o(46226);
    return paramContext;
  }
  
  public final void l(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(46227);
    if (getRecordView() == null)
    {
      AppMethodBeat.o(46227);
      return;
    }
    getRecordView().vYV.l(paramMotionEvent);
    AppMethodBeat.o(46227);
  }
  
  public void setCustomSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(46225);
    ae.i("MicroMsg.SameLayerCameraView", "setCustomSurfaceTexture:%s", new Object[] { paramSurfaceTexture });
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(46225);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.SameLayerCameraView
 * JD-Core Version:    0.7.0.1
 */
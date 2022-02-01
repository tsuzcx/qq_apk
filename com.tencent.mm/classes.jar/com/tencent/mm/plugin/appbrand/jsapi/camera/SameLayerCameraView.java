package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ac.a.a.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

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
  
  public static void bjE()
  {
    AppMethodBeat.i(46224);
    com.tencent.mm.plugin.appbrand.jsapi.ac.a.a.lxa = new a.a()
    {
      public final f dq(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46222);
        paramAnonymousContext = new SameLayerCameraView(paramAnonymousContext);
        AppMethodBeat.o(46222);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(46224);
  }
  
  protected final AppBrandCameraView.a Pz(String paramString)
  {
    AppMethodBeat.i(46228);
    if ((!bt.isNullOrNil(paramString)) && (paramString.equals("scanCode")))
    {
      paramString = new a();
      AppMethodBeat.o(46228);
      return paramString;
    }
    paramString = super.Pz(paramString);
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
    getRecordView().vMS.l(paramMotionEvent);
    AppMethodBeat.o(46227);
  }
  
  public void setCustomSurfaceTexture(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(46225);
    ad.i("MicroMsg.SameLayerCameraView", "setCustomSurfaceTexture:%s", new Object[] { paramSurfaceTexture });
    this.mSurfaceTexture = paramSurfaceTexture;
    AppMethodBeat.o(46225);
  }
  
  protected final class a
    extends AppBrandCameraView.c
  {
    protected a()
    {
      super();
    }
    
    public final void init()
    {
      AppMethodBeat.i(46223);
      this.kHU = 1;
      super.init();
      AppMethodBeat.o(46223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.SameLayerCameraView
 * JD-Core Version:    0.7.0.1
 */
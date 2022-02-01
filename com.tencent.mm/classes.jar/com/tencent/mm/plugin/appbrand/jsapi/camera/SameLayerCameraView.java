package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.k;
import com.tencent.mm.plugin.appbrand.jsapi.al.a.a.a;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView;
import com.tencent.mm.plugin.mmsight.api.MMSightRecordView.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class SameLayerCameraView
  extends AppBrandCameraView
  implements g
{
  private Surface mSurface;
  
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
  
  public static void crz()
  {
    AppMethodBeat.i(46224);
    com.tencent.mm.plugin.appbrand.jsapi.al.a.a.sOG = new a.a()
    {
      public final f eG(Context paramAnonymousContext)
      {
        AppMethodBeat.i(46222);
        k.ceQ();
        paramAnonymousContext = new SameLayerCameraView(paramAnonymousContext);
        AppMethodBeat.o(46222);
        return paramAnonymousContext;
      }
    };
    AppMethodBeat.o(46224);
  }
  
  protected final AppBrandCameraView.a aat(String paramString)
  {
    AppMethodBeat.i(46228);
    if ((!Util.isNullOrNil(paramString)) && (paramString.equals("scanCode")))
    {
      paramString = new a();
      AppMethodBeat.o(46228);
      return paramString;
    }
    paramString = super.aat(paramString);
    AppMethodBeat.o(46228);
    return paramString;
  }
  
  protected final MMSightRecordView d(Context paramContext, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(46226);
    paramContext = new MMSightRecordView(paramContext, this.mSurface, paramInt1, paramInt2);
    AppMethodBeat.o(46226);
    return paramContext;
  }
  
  public final void o(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(46227);
    if (getRecordView() == null)
    {
      AppMethodBeat.o(46227);
      return;
    }
    getRecordView().KUk.o(paramMotionEvent);
    AppMethodBeat.o(46227);
  }
  
  public void setCustomSurface(Surface paramSurface)
  {
    AppMethodBeat.i(325993);
    Log.i("MicroMsg.SameLayerCameraView", "setCustomSurface:%s", new Object[] { paramSurface });
    this.mSurface = paramSurface;
    AppMethodBeat.o(325993);
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
      crO();
      super.init();
      AppMethodBeat.o(46223);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.SameLayerCameraView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.tencent.live2.jsplugin.V2TXJSAdapterError;
import com.tencent.live2.jsplugin.pusher.V2TXLivePusherJSAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.live.k;
import com.tencent.mm.plugin.appbrand.jsapi.live.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import org.json.JSONObject;

public final class w
  extends t
  implements m
{
  private final x eCO;
  private ITXLivePushListener mLivePushListener;
  
  public w(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(220819);
    this.eCO = new x(this.sbu);
    AppMethodBeat.o(220819);
  }
  
  public final k aa(float paramFloat1, float paramFloat2)
  {
    AppMethodBeat.i(220910);
    k localk = new k(this.sbu.setFocusPosition(paramFloat1, paramFloat2));
    AppMethodBeat.o(220910);
    return localk;
  }
  
  public final void atU()
  {
    AppMethodBeat.i(220936);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapterV2SameLayerSupport", "sendHandupStop, send event 5000");
      this.mLivePushListener.onPushEvent(5000, new Bundle());
    }
    AppMethodBeat.o(220936);
  }
  
  public final void atV()
  {
    AppMethodBeat.i(220944);
    if (this.mLivePushListener != null)
    {
      Log.i("TXLivePusherJSAdapterV2SameLayerSupport", "sendWeChatStop, send event 5001");
      this.mLivePushListener.onPushEvent(5001, new Bundle());
    }
    AppMethodBeat.o(220944);
  }
  
  public final k aup()
  {
    AppMethodBeat.i(220881);
    k localk = super.aup();
    this.eCO.mInited = false;
    AppMethodBeat.o(220881);
    return localk;
  }
  
  public final k b(TXCloudVideoView paramTXCloudVideoView, Bundle paramBundle)
  {
    AppMethodBeat.i(220848);
    k localk = super.b(paramTXCloudVideoView, paramBundle);
    this.eCO.c(paramTXCloudVideoView, paramBundle);
    AppMethodBeat.o(220848);
    return localk;
  }
  
  public final k dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(220902);
    k localk = new k(this.sbu.setSurfaceSize(paramInt1, paramInt2));
    AppMethodBeat.o(220902);
    return localk;
  }
  
  public final k e(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(220871);
    k localk = super.e(paramString, paramJSONObject);
    if (-4 == localk.errorCode)
    {
      paramString = this.eCO.e(paramString, paramJSONObject);
      AppMethodBeat.o(220871);
      return paramString;
    }
    AppMethodBeat.o(220871);
    return localk;
  }
  
  public final int getMaxZoom()
  {
    AppMethodBeat.i(220928);
    int i = this.sbu.getMaxZoom();
    AppMethodBeat.o(220928);
    return i;
  }
  
  public final k h(Surface paramSurface)
  {
    AppMethodBeat.i(220891);
    paramSurface = new k(this.sbu.setSurface(paramSurface));
    AppMethodBeat.o(220891);
    return paramSurface;
  }
  
  public final k mF(int paramInt)
  {
    AppMethodBeat.i(220923);
    k localk = new k(this.sbu.setZoom(paramInt));
    AppMethodBeat.o(220923);
    return localk;
  }
  
  public final void setPushListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(220841);
    super.setPushListener(paramITXLivePushListener);
    this.mLivePushListener = paramITXLivePushListener;
    AppMethodBeat.o(220841);
  }
  
  public final void setThreadHandler(Handler paramHandler)
  {
    AppMethodBeat.i(220829);
    this.sbu.setThreadHandler(paramHandler);
    AppMethodBeat.o(220829);
  }
  
  public final k y(Bundle paramBundle)
  {
    AppMethodBeat.i(220854);
    V2TXJSAdapterError localV2TXJSAdapterError = this.sbu.initLivePusher(paramBundle);
    this.eCO.A(paramBundle);
    paramBundle = new k(localV2TXJSAdapterError);
    AppMethodBeat.o(220854);
    return paramBundle;
  }
  
  public final k z(Bundle paramBundle)
  {
    AppMethodBeat.i(220863);
    k localk = super.z(paramBundle);
    this.eCO.B(paramBundle);
    AppMethodBeat.o(220863);
    return localk;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.w
 * JD-Core Version:    0.7.0.1
 */
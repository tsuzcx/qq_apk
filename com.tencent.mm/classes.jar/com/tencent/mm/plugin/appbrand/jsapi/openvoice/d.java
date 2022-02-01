package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 625;
  public static final String NAME = "removeVoIPView";
  
  public d()
  {
    AppMethodBeat.i(174846);
    com.tencent.mm.plugin.appbrand.permission.c.afo("removeVoIPView");
    AppMethodBeat.o(174846);
  }
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46684);
    int i = paramJSONObject.optInt("viewId", 0);
    AppMethodBeat.o(46684);
    return i;
  }
  
  public final boolean b(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46685);
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "onRemoveView," + paramJSONObject.toString());
    super.b(paramh, paramInt, paramView, paramJSONObject);
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46685);
      return false;
    }
    paramh = (View)((CoverViewContainer)paramView).aT(View.class);
    if ((paramh == null) || (!(paramh instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.service.c)))
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46685);
      return false;
    }
    paramh = (com.tencent.mm.plugin.cloudvoip.cloudvoice.service.c)paramh;
    q.wVc.wVh.a(paramh);
    AppMethodBeat.o(46685);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.d
 * JD-Core Version:    0.7.0.1
 */
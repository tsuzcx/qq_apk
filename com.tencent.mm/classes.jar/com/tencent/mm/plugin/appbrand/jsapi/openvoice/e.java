package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class e
  extends d
{
  private static final int CTRL_INDEX = 624;
  public static final String NAME = "updateVoIPView";
  
  public e()
  {
    AppMethodBeat.i(174847);
    com.tencent.mm.plugin.appbrand.permission.c.aem("updateVoIPView");
    AppMethodBeat.o(174847);
  }
  
  public final int H(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46686);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(46686);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46687);
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView," + paramJSONObject.toString());
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46687);
      return false;
    }
    paramh = (View)((CoverViewContainer)paramView).aB(View.class);
    if ((paramh == null) || (!(paramh instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)))
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46687);
      return false;
    }
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView,viewId:[" + paramInt + "," + H(paramJSONObject) + "],data:" + paramJSONObject.toString());
    ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)paramh).aH(paramJSONObject);
    AppMethodBeat.o(46687);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 624;
  public static final String NAME = "updateVoIPView";
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143429);
    ab.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView," + paramJSONObject.toString());
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(143429);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).aa(View.class);
    if ((parame == null) || (!(parame instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c)))
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(143429);
      return false;
    }
    ab.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView,viewId:[" + paramInt + "," + w(paramJSONObject) + "],data:" + paramJSONObject.toString());
    ((com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c)parame).W(paramJSONObject);
    AppMethodBeat.o(143429);
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143428);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(143428);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.sdk.platformtools.ac;
import org.json.JSONObject;

public final class e
  extends com.tencent.mm.plugin.appbrand.jsapi.base.c
{
  private static final int CTRL_INDEX = 624;
  public static final String NAME = "updateVoIPView";
  
  public e()
  {
    AppMethodBeat.i(174847);
    com.tencent.mm.plugin.appbrand.permission.c.Qk("updateVoIPView");
    AppMethodBeat.o(174847);
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46686);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(46686);
    return i;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46687);
    ac.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView," + paramJSONObject.toString());
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46687);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if ((parame == null) || (!(parame instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)))
    {
      ac.w("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "the camera view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46687);
      return false;
    }
    ac.i("MicroMsg.OpenVoice.JsApiCloudVoiceUpdateView", "onUpdateView,viewId:[" + paramInt + "," + A(paramJSONObject) + "],data:" + paramJSONObject.toString());
    ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)parame).am(paramJSONObject);
    AppMethodBeat.o(46687);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.e
 * JD-Core Version:    0.7.0.1
 */
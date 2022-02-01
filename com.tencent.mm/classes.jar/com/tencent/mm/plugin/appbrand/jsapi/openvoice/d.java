package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.g;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t;
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
    com.tencent.mm.plugin.appbrand.permission.c.amg("removeVoIPView");
    AppMethodBeat.o(174846);
  }
  
  public final int K(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46684);
    int i = paramJSONObject.optInt("viewId", 0);
    AppMethodBeat.o(46684);
    return i;
  }
  
  public final boolean b(g paramg, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46685);
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "onRemoveView," + paramJSONObject.toString());
    super.b(paramg, paramInt, paramView, paramJSONObject);
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46685);
      return false;
    }
    paramg = (View)((CoverViewContainer)paramView).aA(View.class);
    if ((paramg == null) || (!(paramg instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)))
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46685);
      return false;
    }
    paramg = (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)paramg;
    q.tRM.tRR.a(paramg);
    AppMethodBeat.o(46685);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.d
 * JD-Core Version:    0.7.0.1
 */
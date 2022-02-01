package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s;
import com.tencent.mm.sdk.platformtools.ad;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 623;
  public static final String NAME = "insertVoIPView";
  
  public b()
  {
    AppMethodBeat.i(174845);
    com.tencent.mm.plugin.appbrand.permission.c.TP("insertVoIPView");
    AppMethodBeat.o(174845);
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46672);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(46672);
    return i;
  }
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46671);
    ad.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflateView," + paramJSONObject.toString());
    parame = parame.getContext();
    if (parame == null)
    {
      ad.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, context is null, %s", new Object[] { getName() });
      AppMethodBeat.o(46671);
      return null;
    }
    if (p.oXv.oXG == 2)
    {
      ad.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s, audio room", new Object[] { getName() });
      AppMethodBeat.o(46671);
      return null;
    }
    paramJSONObject = p.oXv.oXz.a(parame, paramJSONObject);
    if (paramJSONObject == null)
    {
      ad.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s", new Object[] { getName() });
      AppMethodBeat.o(46671);
      return null;
    }
    parame = new CoverViewContainer(parame, (View)paramJSONObject);
    AppMethodBeat.o(46671);
    return parame;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46673);
    parame = (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)((CoverViewContainer)paramView).ax(View.class);
    if (parame == null)
    {
      ad.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView failed, view is null, viewId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(46673);
      return;
    }
    ad.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView, viewId:[" + paramInt + "," + parame.getViewId() + "],data:" + paramJSONObject.toString());
    parame.ao(paramJSONObject);
    AppMethodBeat.o(46673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.b
 * JD-Core Version:    0.7.0.1
 */
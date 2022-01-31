package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.a;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.r;
import com.tencent.mm.sdk.platformtools.ab;
import org.json.JSONObject;

public final class b
  extends a
{
  private static final int CTRL_INDEX = 623;
  public static final String NAME = "insertVoIPView";
  
  public final View a(e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143422);
    ab.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflateView," + paramJSONObject.toString());
    parame = parame.getContext();
    if (parame == null)
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, context is null, %s", new Object[] { getName() });
      AppMethodBeat.o(143422);
      return null;
    }
    if (o.kKN.kKW == 2)
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s, audio room", new Object[] { getName() });
      AppMethodBeat.o(143422);
      return null;
    }
    paramJSONObject = o.kKN.kKR.a(parame, paramJSONObject);
    if (paramJSONObject == null)
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s", new Object[] { getName() });
      AppMethodBeat.o(143422);
      return null;
    }
    parame = new CoverViewContainer(parame, (View)paramJSONObject);
    AppMethodBeat.o(143422);
    return parame;
  }
  
  public final void a(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143424);
    parame = (c)((CoverViewContainer)paramView).aa(View.class);
    if (parame == null)
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView failed, view is null, viewId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(143424);
      return;
    }
    ab.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView, viewId:[" + paramInt + "," + parame.getViewId() + "],data:" + paramJSONObject.toString());
    parame.V(paramJSONObject);
    AppMethodBeat.o(143424);
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143423);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(143423);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.b
 * JD-Core Version:    0.7.0.1
 */
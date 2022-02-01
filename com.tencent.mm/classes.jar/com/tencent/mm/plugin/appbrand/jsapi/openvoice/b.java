package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import org.json.JSONObject;

public final class b
  extends com.tencent.mm.plugin.appbrand.jsapi.base.b
{
  private static final int CTRL_INDEX = 623;
  public static final String NAME = "insertVoIPView";
  
  public b()
  {
    AppMethodBeat.i(174845);
    com.tencent.mm.plugin.appbrand.permission.c.afo("insertVoIPView");
    AppMethodBeat.o(174845);
  }
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46672);
    int i = paramJSONObject.optInt("viewId");
    AppMethodBeat.o(46672);
    return i;
  }
  
  public final View a(h paramh, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46671);
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflateView," + paramJSONObject.toString());
    paramh = paramh.getContext();
    if (paramh == null)
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, context is null, %s", new Object[] { getName() });
      AppMethodBeat.o(46671);
      return null;
    }
    if (q.wVc.mRoomType == 2)
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s, audio room", new Object[] { getName() });
      AppMethodBeat.o(46671);
      return null;
    }
    paramJSONObject = q.wVc.wVh.a(paramh, paramJSONObject, false);
    if (paramJSONObject == null)
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "inflate view failed, newView failed, %s", new Object[] { getName() });
      AppMethodBeat.o(46671);
      return null;
    }
    paramh = new CoverViewContainer(paramh, (View)paramJSONObject);
    AppMethodBeat.o(46671);
    return paramh;
  }
  
  public final void a(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46673);
    paramh = (com.tencent.mm.plugin.cloudvoip.cloudvoice.service.c)((CoverViewContainer)paramView).aT(View.class);
    if (paramh == null)
    {
      Log.w("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView failed, view is null, viewId:".concat(String.valueOf(paramInt)));
      AppMethodBeat.o(46673);
      return;
    }
    Log.i("MicroMsg.OpenVoice.JsApiCloudVoiceInsertView", "onInsertView, viewId:[" + paramInt + "," + paramh.getViewId() + "],data:" + paramJSONObject.toString());
    paramh.aV(paramJSONObject);
    AppMethodBeat.o(46673);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.b
 * JD-Core Version:    0.7.0.1
 */
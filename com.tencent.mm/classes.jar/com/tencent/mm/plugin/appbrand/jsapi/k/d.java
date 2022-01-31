package com.tencent.mm.plugin.appbrand.jsapi.k;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends b
{
  private static final int CTRL_INDEX = 625;
  public static final String NAME = "removeVoIPView";
  
  public final boolean b(e arg1, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143427);
    ab.i("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "onRemoveView," + paramJSONObject.toString());
    super.b(???, paramInt, paramView, paramJSONObject);
    if (!(paramView instanceof CoverViewContainer))
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(143427);
      return false;
    }
    ??? = (View)((CoverViewContainer)paramView).aa(View.class);
    if ((??? == null) || (!(??? instanceof c)))
    {
      ab.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(143427);
      return false;
    }
    paramView = (c)???;
    paramJSONObject = o.kKN.kKR;
    synchronized (paramJSONObject.kMy)
    {
      paramView.uint();
      paramJSONObject.kMy.remove(paramView.getOpenId());
      ab.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "del View, viewId:" + paramView.getViewId() + " memberId:" + paramView.getMemberId());
      AppMethodBeat.o(143427);
      return true;
    }
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(143426);
    int i = paramJSONObject.optInt("viewId", 0);
    AppMethodBeat.o(143426);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.k.d
 * JD-Core Version:    0.7.0.1
 */
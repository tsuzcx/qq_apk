package com.tencent.mm.plugin.appbrand.jsapi.openvoice;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.b;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.p.16;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.s;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.Map;
import org.json.JSONObject;

public final class d
  extends b
{
  private static final int CTRL_INDEX = 625;
  public static final String NAME = "removeVoIPView";
  
  public d()
  {
    AppMethodBeat.i(174846);
    com.tencent.mm.plugin.appbrand.permission.c.Qk("removeVoIPView");
    AppMethodBeat.o(174846);
  }
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(46684);
    int i = paramJSONObject.optInt("viewId", 0);
    AppMethodBeat.o(46684);
    return i;
  }
  
  public final boolean b(e parame, int paramInt, View paramView, JSONObject arg4)
  {
    AppMethodBeat.i(46685);
    ac.i("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "onRemoveView," + ???.toString());
    super.b(parame, paramInt, paramView, ???);
    if (!(paramView instanceof CoverViewContainer))
    {
      ac.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46685);
      return false;
    }
    parame = (View)((CoverViewContainer)paramView).ax(View.class);
    if ((parame == null) || (!(parame instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)))
    {
      ac.w("MicroMsg.OpenVoice.JsApiCloudVoiceRemoveView", "the view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(46685);
      return false;
    }
    parame = (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)parame;
    paramView = p.otZ.oud;
    if (parame.bVo())
    {
      ??? = p.otZ;
      ac.i("MicroMsg.OpenVoice.OpenVoiceService", "onCameraStop");
      ???.ag(new p.16(???));
    }
    synchronized (paramView.owd)
    {
      parame.uint();
      paramView.owd.remove(parame.getOpenId());
      ac.i("MicroMsg.OpenVoice.OpenVoiceVideoMgr", "del View, viewId:" + parame.getViewId() + " memberId:" + parame.getMemberId());
      AppMethodBeat.o(46685);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.openvoice.d
 * JD-Core Version:    0.7.0.1
 */
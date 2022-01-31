package com.tencent.mm.plugin.appbrand.jsapi.camera;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.coverview.CoverViewContainer;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.permission.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public final class j
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 329;
  public static final String NAME = "insertCamera";
  static j.a hJe;
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126243);
    Context localContext = parame.getContext();
    e locale = hJe.cK(localContext);
    int k = paramJSONObject.optInt("cameraId");
    String str1 = paramJSONObject.optString("mode", "normal");
    String str2 = paramJSONObject.optString("devicePosition", "back");
    String str3 = paramJSONObject.optString("flash", "auto");
    String str4 = paramJSONObject.optString("size");
    int j = 720;
    int i = -1;
    switch (str4.hashCode())
    {
    default: 
      switch (i)
      {
      default: 
        i = j;
        label147:
        boolean bool = paramJSONObject.optBoolean("needOutput", false);
        locale.setAppId(parame.getAppId());
        locale.setPage(parame);
        locale.setCameraId(k);
        locale.setMode(str1);
        locale.aj(str2, true);
        locale.setFlash(str3);
        locale.setFrameLimitSize(i);
        locale.setNeedOutput(bool);
        parame = paramJSONObject.optJSONObject("position");
        i = com.tencent.mm.plugin.appbrand.s.g.a(parame, "width", 0);
        j = com.tencent.mm.plugin.appbrand.s.g.a(parame, "height", 0);
        if ((i != 0) && (j != 0)) {
          locale.dg(i, j);
        }
        parame = paramJSONObject.optJSONArray("scanArea");
        if ((parame != null) && (parame.length() == 4))
        {
          ab.i("MicroMsg.JsApiInsertCamera", "scanAreaArray:%s, scanAreaArray.length:%d", new Object[] { parame, Integer.valueOf(parame.length()) });
          locale.w(com.tencent.mm.plugin.appbrand.s.g.pO(parame.optInt(0)), com.tencent.mm.plugin.appbrand.s.g.pO(parame.optInt(1)), com.tencent.mm.plugin.appbrand.s.g.pO(parame.optInt(2)), com.tencent.mm.plugin.appbrand.s.g.pO(parame.optInt(3)));
          label358:
          locale.setScanFreq(paramJSONObject.optInt("scanFreq"));
          ab.d("MicroMsg.JsApiInsertCamera", "inflateView cameraId: %d,devicePosition: %s,flash: %s,width: %d,height: %d", new Object[] { Integer.valueOf(k), str2, str3, Integer.valueOf(i), Integer.valueOf(j) });
          paramJSONObject = locale.getView();
          if (!"normal".equals(str1)) {
            break label549;
          }
        }
        break;
      }
      break;
    }
    label549:
    for (parame = localContext.getString(2131296548);; parame = localContext.getString(2131296549))
    {
      paramJSONObject.setContentDescription(parame);
      parame = new CoverViewContainer(localContext, (View)locale);
      AppMethodBeat.o(126243);
      return parame;
      if (!str4.equals("small")) {
        break;
      }
      i = 0;
      break;
      if (!str4.equals("medium")) {
        break;
      }
      i = 1;
      break;
      if (!str4.equals("large")) {
        break;
      }
      i = 2;
      break;
      i = 288;
      break label147;
      i = 480;
      break label147;
      i = 720;
      break label147;
      locale.w(0, 0, i, j);
      break label358;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject, com.tencent.mm.plugin.appbrand.jsapi.base.g paramg)
  {
    AppMethodBeat.i(138256);
    ab.i("MicroMsg.JsApiInsertCamera", "onInsertView cameraId=%d", new Object[] { Integer.valueOf(paramInt) });
    paramg.BS(j("ok", null));
    paramView = (e)((CoverViewContainer)paramView).aa(View.class);
    if (paramView == null)
    {
      ab.w("MicroMsg.JsApiInsertCamera", "onInsertView(viewId : %d) failed, cameraView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(138256);
      return;
    }
    a(parame, paramView);
    paramJSONObject = a.a.aCy();
    int i = paramView.getCameraId();
    paramJSONObject.hIm.put(Integer.valueOf(i), paramView);
    parame.a(paramView);
    parame.a(paramView);
    parame.a(paramView);
    com.tencent.mm.plugin.appbrand.e.a(parame.getAppId(), new j.1(this, parame, paramView, paramInt));
    paramView.setOutPutCallBack(new j.2(this));
    AppMethodBeat.o(138256);
  }
  
  final boolean a(c paramc, e parame)
  {
    AppMethodBeat.i(126246);
    n.b(String.valueOf(paramc.getAppId()), new j.3(this, paramc, parame));
    Activity localActivity = (Activity)paramc.getContext();
    if (localActivity == null)
    {
      AppMethodBeat.o(126246);
      return false;
    }
    boolean bool = com.tencent.luggage.g.g.a(localActivity, "android.permission.CAMERA", 16, "", "");
    a.a.aCy().hIk = bool;
    if (!bool)
    {
      AppMethodBeat.o(126246);
      return false;
    }
    bool = com.tencent.luggage.g.g.a(localActivity, "android.permission.RECORD_AUDIO", 18, "", "");
    a.a.aCy().hIl = bool;
    if (!bool)
    {
      AppMethodBeat.o(126246);
      return false;
    }
    n.EA(paramc.getAppId());
    parame.initView();
    AppMethodBeat.o(126246);
    return true;
  }
  
  public final boolean aCb()
  {
    return true;
  }
  
  public final int w(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(126244);
    int i = paramJSONObject.optInt("cameraId");
    AppMethodBeat.o(126244);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.camera.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.base.a
{
  private static final int CTRL_INDEX = 809;
  public static final String NAME = "insertImagePreviewer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195824);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(195824);
    return i;
  }
  
  public final View a(com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(195825);
    paramJSONObject = parame.getContext();
    ZoomImagePreviewer localZoomImagePreviewer = new ZoomImagePreviewer(paramJSONObject, null);
    localZoomImagePreviewer.setComponent(parame);
    parame = new CoverViewContainer(paramJSONObject, localZoomImagePreviewer);
    AppMethodBeat.o(195825);
    return parame;
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195826);
    super.a(parame, paramInt, paramView, paramJSONObject);
    ad.d("MicroMsg.JsApiInsertImagePreviewer", "insertImagePreviewer(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    ad.d("MicroMsg.JsApiInsertImagePreviewer", "onInsertView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    parame = (ZoomImagePreviewer)((CoverViewContainer)paramView).ax(ZoomImagePreviewer.class);
    if (parame == null)
    {
      ad.w("MicroMsg.JsApiInsertImagePreviewer", "onInsertView(viewId : %d) failed, targetView is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(195826);
      return;
    }
    com.tencent.mm.plugin.appbrand.jsapi.x.e.b(paramView, paramJSONObject.optJSONObject("style"));
    com.tencent.mm.plugin.appbrand.jsapi.x.a.a(parame, paramJSONObject);
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("position"))
        {
          paramView = E(paramJSONObject);
          if (paramView != null) {
            parame.dN((int)paramView[2], (int)paramView[3]);
          }
        }
        if (paramJSONObject.has("scale")) {
          parame.setScale((float)paramJSONObject.optDouble("scale"));
        }
        if (paramJSONObject.has("urls"))
        {
          paramView = new ArrayList();
          paramJSONObject = paramJSONObject.optJSONArray("urls");
          if (paramJSONObject != null)
          {
            paramInt = 0;
            if (paramInt < paramJSONObject.length())
            {
              String str = paramJSONObject.get(paramInt).toString();
              if (TextUtils.isEmpty(str)) {
                break label288;
              }
              paramView.add(str);
              break label288;
            }
          }
          else
          {
            ad.e("MicroMsg.JsApiInsertImagePreviewer", "urls is empty");
          }
          if (!paramView.isEmpty()) {
            parame.setData(paramView);
          }
        }
        AppMethodBeat.o(195826);
        return;
      }
      catch (JSONException parame)
      {
        ad.printErrStackTrace("MicroMsg.JsApiInsertImagePreviewer", parame, "", new Object[0]);
        AppMethodBeat.o(195826);
        return;
      }
      label288:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.d
 * JD-Core Version:    0.7.0.1
 */
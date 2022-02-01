package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.base.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends c
{
  private static final int CTRL_INDEX = 810;
  public static final String NAME = "updateImagePreviewer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195830);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(195830);
    return i;
  }
  
  public final boolean c(com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(195829);
    ad.d("MicroMsg.JsApiUpdateImagePreviewer", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      ad.w("MicroMsg.JsApiUpdateImagePreviewer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(195829);
      return false;
    }
    ZoomImagePreviewer localZoomImagePreviewer = (ZoomImagePreviewer)((CoverViewContainer)paramView).ax(ZoomImagePreviewer.class);
    if (localZoomImagePreviewer == null)
    {
      ad.w("MicroMsg.JsApiUpdateImagePreviewer", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(195829);
      return false;
    }
    com.tencent.mm.plugin.appbrand.jsapi.x.e.b(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.has("position"))
      {
        localObject = E(paramJSONObject);
        if (localObject != null) {
          localZoomImagePreviewer.dN((int)localObject[2], (int)localObject[3]);
        }
      }
      if (paramJSONObject.has("scale")) {
        localZoomImagePreviewer.setScale((float)paramJSONObject.optDouble("scale"));
      }
      if (!paramJSONObject.has("urls")) {
        break label274;
      }
      localObject = new ArrayList();
      localJSONArray = paramJSONObject.optJSONArray("urls");
      if (localJSONArray == null) {
        break label252;
      }
      i = 0;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Object localObject;
        JSONArray localJSONArray;
        int i;
        String str;
        label252:
        boolean bool;
        label274:
        ad.printErrStackTrace("MicroMsg.JsApiUpdateImagePreviewer", localJSONException, "", new Object[0]);
        continue;
        i += 1;
      }
    }
    if (i < localJSONArray.length())
    {
      str = localJSONArray.get(i).toString();
      if (!TextUtils.isEmpty(str))
      {
        ((ArrayList)localObject).add(str);
        break label311;
        ad.e("MicroMsg.JsApiUpdateImagePreviewer", "urls is empty");
      }
    }
    else
    {
      if (!((ArrayList)localObject).isEmpty()) {
        localZoomImagePreviewer.t((ArrayList)localObject);
      }
      bool = super.c(parame, paramInt, paramView, paramJSONObject);
      AppMethodBeat.o(195829);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.l
 * JD-Core Version:    0.7.0.1
 */
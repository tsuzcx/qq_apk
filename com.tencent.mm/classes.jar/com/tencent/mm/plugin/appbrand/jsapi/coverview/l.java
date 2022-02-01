package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class l
  extends d
{
  private static final int CTRL_INDEX = 810;
  public static final String NAME = "updateImagePreviewer";
  
  public final int A(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222439);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(222439);
    return i;
  }
  
  public final boolean c(e parame, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(222438);
    ae.d("MicroMsg.JsApiUpdateImagePreviewer", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      ae.w("MicroMsg.JsApiUpdateImagePreviewer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(222438);
      return false;
    }
    ZoomImagePreviewer localZoomImagePreviewer = (ZoomImagePreviewer)((CoverViewContainer)paramView).ax(ZoomImagePreviewer.class);
    if (localZoomImagePreviewer == null)
    {
      ae.w("MicroMsg.JsApiUpdateImagePreviewer", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(222438);
      return false;
    }
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.has("position"))
      {
        localObject = E(paramJSONObject);
        if (localObject != null) {
          localZoomImagePreviewer.dQ((int)localObject[2], (int)localObject[3]);
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
        ae.printErrStackTrace("MicroMsg.JsApiUpdateImagePreviewer", localJSONException, "", new Object[0]);
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
        ae.e("MicroMsg.JsApiUpdateImagePreviewer", "urls is empty");
      }
    }
    else
    {
      if (!((ArrayList)localObject).isEmpty()) {
        localZoomImagePreviewer.x((ArrayList)localObject);
      }
      bool = super.c(parame, paramInt, paramView, paramJSONObject);
      AppMethodBeat.o(222438);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.coverview;

import android.text.TextUtils;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah.f;
import com.tencent.mm.plugin.appbrand.jsapi.base.d;
import com.tencent.mm.plugin.appbrand.jsapi.h;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class o
  extends d
{
  private static final int CTRL_INDEX = 810;
  public static final String NAME = "updateImagePreviewer";
  
  public final int V(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327352);
    int i = paramJSONObject.getInt("viewId");
    AppMethodBeat.o(327352);
    return i;
  }
  
  public final boolean c(h paramh, int paramInt, View paramView, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(327347);
    Log.d("MicroMsg.JsApiUpdateImagePreviewer", "onUpdateView(viewId : %s, %s)", new Object[] { Integer.valueOf(paramInt), paramJSONObject });
    if (!(paramView instanceof CoverViewContainer))
    {
      Log.w("MicroMsg.JsApiUpdateImagePreviewer", "the view(%s) is not a instance of CoverViewContainer", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(327347);
      return false;
    }
    ZoomImagePreviewer localZoomImagePreviewer = (ZoomImagePreviewer)((CoverViewContainer)paramView).aT(ZoomImagePreviewer.class);
    if (localZoomImagePreviewer == null)
    {
      Log.w("MicroMsg.JsApiUpdateImagePreviewer", "the target view(%s) is null", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(327347);
      return false;
    }
    f.b(paramView, paramJSONObject.optJSONObject("style"));
    try
    {
      if (paramJSONObject.has("position"))
      {
        localObject = aa(paramJSONObject);
        if (localObject != null) {
          localZoomImagePreviewer.fu((int)localObject[2], (int)localObject[3]);
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
        Log.printErrStackTrace("MicroMsg.JsApiUpdateImagePreviewer", localJSONException, "", new Object[0]);
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
        Log.e("MicroMsg.JsApiUpdateImagePreviewer", "urls is empty");
      }
    }
    else
    {
      if (!((ArrayList)localObject).isEmpty()) {
        localZoomImagePreviewer.G((ArrayList)localObject);
      }
      bool = super.c(paramh, paramInt, paramView, paramJSONObject);
      AppMethodBeat.o(327347);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.coverview.o
 * JD-Core Version:    0.7.0.1
 */
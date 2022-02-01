package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class f
  extends c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "openFinderProfile";
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(163962);
    if (!(paramf.getContext() instanceof Activity))
    {
      paramf.callback(paramInt, "fail");
      AppMethodBeat.o(163962);
      return;
    }
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, "fail:data is null");
      AppMethodBeat.o(163962);
      return;
    }
    paramJSONObject = paramJSONObject.optString("username", "");
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramf.callback(paramInt, "fail:username is null");
      AppMethodBeat.o(163962);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramJSONObject);
    a.GfO.enterFinderProfileUI(paramf.getContext(), localIntent);
    AppMethodBeat.o(163962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.f
 * JD-Core Version:    0.7.0.1
 */
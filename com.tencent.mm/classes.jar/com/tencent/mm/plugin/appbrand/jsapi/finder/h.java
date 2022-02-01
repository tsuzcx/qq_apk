package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONObject;

public final class h
  extends c
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "openFinderProfile";
  
  public final void a(e parame, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(163962);
    if (!(parame.getContext() instanceof Activity))
    {
      parame.j(paramInt, "fail");
      AppMethodBeat.o(163962);
      return;
    }
    if (paramJSONObject == null)
    {
      parame.j(paramInt, "fail:data is null");
      AppMethodBeat.o(163962);
      return;
    }
    Object localObject = paramJSONObject.optString("username", "");
    if (Util.isNullOrNil((String)localObject))
    {
      parame.j(paramInt, "fail:username is null");
      AppMethodBeat.o(163962);
      return;
    }
    paramJSONObject = new Intent();
    paramJSONObject.putExtra("finder_username", (String)localObject);
    localObject = a.ACH;
    a.enterFinderProfileUI(parame.getContext(), paramJSONObject);
    AppMethodBeat.o(163962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.h
 * JD-Core Version:    0.7.0.1
 */
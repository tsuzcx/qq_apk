package com.tencent.mm.plugin.appbrand.jsapi.finder;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONObject;

public final class h
  extends com.tencent.mm.plugin.appbrand.jsapi.a
{
  public static final int CTRL_INDEX = -2;
  public static final String NAME = "openFinderProfile";
  
  public final void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(163962);
    if (!(paramc.getContext() instanceof Activity))
    {
      paramc.h(paramInt, "fail");
      AppMethodBeat.o(163962);
      return;
    }
    if (paramJSONObject == null)
    {
      paramc.h(paramInt, "fail:data is null");
      AppMethodBeat.o(163962);
      return;
    }
    Object localObject = paramJSONObject.optString("username", "");
    if (bt.isNullOrNil((String)localObject))
    {
      paramc.h(paramInt, "fail:username is null");
      AppMethodBeat.o(163962);
      return;
    }
    paramJSONObject = new Intent(paramc.getContext(), FinderProfileUI.class);
    paramJSONObject.putExtra("finder_username", (String)localObject);
    localObject = com.tencent.mm.plugin.finder.utils.a.qSb;
    com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI(paramc.getContext(), paramJSONObject);
    AppMethodBeat.o(163962);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.finder.h
 * JD-Core Version:    0.7.0.1
 */
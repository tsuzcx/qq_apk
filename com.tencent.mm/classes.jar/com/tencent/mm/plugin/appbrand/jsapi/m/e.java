package com.tencent.mm.plugin.appbrand.jsapi.m;

import android.content.Intent;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiChoosePOI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "REQUEST_CODE_CHOOSE_POI", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c<y>
{
  public static final int CTRL_INDEX = 938;
  public static final String NAME = "choosePoi";
  public static final e.a rZX;
  private final int rZY;
  
  static
  {
    AppMethodBeat.i(329204);
    rZX = new e.a((byte)0);
    AppMethodBeat.o(329204);
  }
  
  public e()
  {
    AppMethodBeat.i(329192);
    this.rZY = a.ce(a.evH);
    AppMethodBeat.o(329192);
  }
  
  private static final boolean a(e parame, y paramy, int paramInt1, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(329200);
    s.u(parame, "this$0");
    if (paramInt2 != parame.rZY)
    {
      AppMethodBeat.o(329200);
      return false;
    }
    switch (paramInt3)
    {
    default: 
      paramy.callback(paramInt1, parame.ZP("fail"));
      Log.e("MicroMsg.JsApiChoosePOI", "choose failed");
    }
    for (;;)
    {
      AppMethodBeat.o(329200);
      return true;
      if (paramIntent == null)
      {
        paramy.callback(paramInt1, parame.ZP("fail:internal error"));
        AppMethodBeat.o(329200);
        return true;
      }
      Map localMap = (Map)new HashMap();
      paramInt2 = paramIntent.getIntExtra("get_poi_data_type", 0);
      localMap.put("type", Integer.valueOf(paramInt2));
      switch (paramInt2)
      {
      }
      for (;;)
      {
        paramy.callback(paramInt1, parame.m("ok", localMap));
        break;
        paramIntent = paramIntent.getStringExtra("get_city");
        s.checkNotNull(paramIntent);
        s.s(paramIntent, "data.getStringExtra(Cons…UI.NearLifeUI.GET_CITY)!!");
        localMap.put("city", paramIntent);
        continue;
        String str = paramIntent.getStringExtra("get_poi_name");
        s.checkNotNull(str);
        s.s(str, "data.getStringExtra(Cons…earLifeUI.GET_POI_NAME)!!");
        localMap.put("name", str);
        str = paramIntent.getStringExtra("get_poi_address");
        s.checkNotNull(str);
        s.s(str, "data.getStringExtra(Cons…LifeUI.GET_POI_ADDRESS)!!");
        localMap.put("address", str);
        localMap.put("latitude", Float.valueOf(paramIntent.getFloatExtra("get_lat", -1.0F)));
        localMap.put("longitude", Float.valueOf(paramIntent.getFloatExtra("get_lng", -1.0F)));
      }
      paramy.callback(paramInt1, parame.ZP("fail cancel"));
      Log.i("MicroMsg.JsApiChoosePOI", "choose canceled");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.m.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.j;

import android.content.Intent;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiChoosePOI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "REQUEST_CODE_CHOOSE_POI", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends c<v>
{
  public static final int CTRL_INDEX = 938;
  public static final String NAME = "choosePoi";
  public static final e.a oUJ;
  private final int oUI;
  
  static
  {
    AppMethodBeat.i(253766);
    oUJ = new e.a((byte)0);
    AppMethodBeat.o(253766);
  }
  
  public e()
  {
    AppMethodBeat.i(253764);
    this.oUI = a.aI(a.cDj);
    AppMethodBeat.o(253764);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements f.c
  {
    b(e parame, v paramv, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(281052);
      if (paramInt1 != e.a(this.oUK))
      {
        AppMethodBeat.o(281052);
        return false;
      }
      switch (paramInt2)
      {
      default: 
        this.oUL.j(this.otk, this.oUK.agS("fail"));
        Log.e("MicroMsg.JsApiChoosePOI", "choose failed");
      }
      for (;;)
      {
        AppMethodBeat.o(281052);
        return true;
        if (paramIntent == null)
        {
          this.oUL.j(this.otk, this.oUK.agS("fail:internal error"));
          AppMethodBeat.o(281052);
          return true;
        }
        Map localMap = (Map)new HashMap();
        paramInt1 = paramIntent.getIntExtra("get_poi_data_type", 0);
        localMap.put("type", Integer.valueOf(paramInt1));
        switch (paramInt1)
        {
        }
        for (;;)
        {
          this.oUL.j(this.otk, this.oUK.m("ok", localMap));
          break;
          paramIntent = paramIntent.getStringExtra("get_city");
          p.j(paramIntent, "data.getStringExtra(Cons…tsUI.NearLifeUI.GET_CITY)");
          localMap.put("city", paramIntent);
          continue;
          String str = paramIntent.getStringExtra("get_poi_name");
          p.j(str, "data.getStringExtra(Cons….NearLifeUI.GET_POI_NAME)");
          localMap.put("name", str);
          str = paramIntent.getStringExtra("get_poi_address");
          p.j(str, "data.getStringExtra(Cons…arLifeUI.GET_POI_ADDRESS)");
          localMap.put("address", str);
          localMap.put("latitude", Float.valueOf(paramIntent.getFloatExtra("get_lat", -1.0F)));
          localMap.put("longitude", Float.valueOf(paramIntent.getFloatExtra("get_lng", -1.0F)));
        }
        this.oUL.j(this.otk, this.oUK.agS("fail cancel"));
        Log.i("MicroMsg.JsApiChoosePOI", "choose canceled");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.j.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.i;

import android.content.Intent;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiChoosePOI;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandService;", "()V", "REQUEST_CODE_CHOOSE_POI", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.jsapi.d<s>
{
  public static final int CTRL_INDEX = 938;
  public static final String NAME = "choosePoi";
  public static final a lWY;
  private final int lWX;
  
  static
  {
    AppMethodBeat.i(228422);
    lWY = new a((byte)0);
    AppMethodBeat.o(228422);
  }
  
  public d()
  {
    AppMethodBeat.i(228421);
    this.lWX = a.aK(a.cCG);
    AppMethodBeat.o(228421);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/lbs/JsApiChoosePOI$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "TAG", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onResult"})
  static final class b
    implements f.c
  {
    b(d paramd, s params, int paramInt) {}
    
    public final boolean c(int paramInt1, int paramInt2, Intent paramIntent)
    {
      AppMethodBeat.i(228419);
      if (paramInt1 != d.a(this.lWZ))
      {
        AppMethodBeat.o(228419);
        return false;
      }
      switch (paramInt2)
      {
      default: 
        this.lXa.i(this.lyo, this.lWZ.Zf("fail"));
        Log.e("MicroMsg.JsApiChoosePOI", "choose failed");
      }
      for (;;)
      {
        AppMethodBeat.o(228419);
        return true;
        if (paramIntent == null)
        {
          this.lXa.i(this.lyo, this.lWZ.Zf("fail:internal error"));
          AppMethodBeat.o(228419);
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
          this.lXa.i(this.lyo, this.lWZ.n("ok", localMap));
          break;
          paramIntent = paramIntent.getStringExtra("get_city");
          p.g(paramIntent, "data.getStringExtra(Cons…tsUI.NearLifeUI.GET_CITY)");
          localMap.put("city", paramIntent);
          continue;
          String str = paramIntent.getStringExtra("get_poi_name");
          p.g(str, "data.getStringExtra(Cons….NearLifeUI.GET_POI_NAME)");
          localMap.put("name", str);
          str = paramIntent.getStringExtra("get_poi_address");
          p.g(str, "data.getStringExtra(Cons…arLifeUI.GET_POI_ADDRESS)");
          localMap.put("address", str);
          localMap.put("latitude", Float.valueOf(paramIntent.getFloatExtra("get_lat", -1.0F)));
          localMap.put("longitude", Float.valueOf(paramIntent.getFloatExtra("get_lng", -1.0F)));
        }
        this.lXa.i(this.lyo, this.lWZ.Zf("fail cancel"));
        Log.i("MicroMsg.JsApiChoosePOI", "choose canceled");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.d
 * JD-Core Version:    0.7.0.1
 */
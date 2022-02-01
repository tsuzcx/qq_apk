package com.tencent.mm.plugin.appbrand.jsapi.aa.c.b;

import android.os.Bundle;
import com.tencent.luggage.k.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.luggage.k.a.a.a.b.a.b
{
  private com.tencent.mm.plugin.appbrand.i.b kzD;
  
  private void a(ar paramar, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139526);
    if ((!paramar.getName().equalsIgnoreCase("onXWebLivePusherEvent")) && (!paramar.getName().equalsIgnoreCase("onXWebLivePusherNetStatus"))) {
      ad.i("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "dispatch event:%s, data:%s", new Object[] { paramar.getName(), paramJSONObject.toString() });
    }
    paramar = paramar.HK(paramJSONObject.toString());
    if (this.kzD != null)
    {
      paramJSONObject = this.kzD.joJ;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof q))
        {
          ((q)paramJSONObject).b(paramar);
          AppMethodBeat.o(139526);
          return;
        }
        if ((paramJSONObject instanceof aa))
        {
          ((aa)paramJSONObject).b(paramar);
          AppMethodBeat.o(139526);
          return;
        }
        paramJSONObject.b(paramar);
      }
    }
    AppMethodBeat.o(139526);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(139525);
    e locale = new e((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      localJSONObject.put("errMsg", bt.nullAsNil(paramString));
      if (!paramHashMap.isEmpty()) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
      a(locale, localJSONObject);
      AppMethodBeat.o(139525);
      return;
    }
    catch (JSONException paramString)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherError fail", new Object[] { paramString });
      AppMethodBeat.o(139525);
    }
  }
  
  public final void b(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(139520);
    f localf = new f((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      if (paramBundle == null) {}
      for (paramBundle = "";; paramBundle = paramBundle.getString("EVT_MSG"))
      {
        localJSONObject.put("errMsg", paramBundle);
        a(localf, localJSONObject);
        AppMethodBeat.o(139520);
        return;
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherEvent fail", new Object[] { paramBundle });
      AppMethodBeat.o(139520);
    }
  }
  
  public final void bY(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139524);
    b localb = new b((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      a(localb, localJSONObject);
      AppMethodBeat.o(139524);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(139524);
    }
  }
  
  public final void bZ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(178856);
    a locala = new a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("volume", paramInt2);
      a(locala, localJSONObject);
      AppMethodBeat.o(178856);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherAudioVolume fail", new Object[] { localJSONException });
      AppMethodBeat.o(178856);
    }
  }
  
  public final void e(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(139521);
    g localg = new g((byte)0);
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("viewId", paramInt);
      JSONObject localJSONObject2 = new JSONObject();
      if (paramBundle != null)
      {
        Iterator localIterator = paramBundle.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          localJSONObject2.put(str, paramBundle.get(str));
        }
      }
      localJSONObject1.put("info", localJSONObject2);
    }
    catch (JSONException paramBundle)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherNetStatus fail", new Object[] { paramBundle });
      AppMethodBeat.o(139521);
      return;
    }
    a(localg, localJSONObject1);
    AppMethodBeat.o(139521);
  }
  
  public final void f(int paramInt, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139523);
    c localc = new c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("progress", paramLong1);
      localJSONObject.put("duration", paramLong2);
      a(localc, localJSONObject);
      AppMethodBeat.o(139523);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139523);
    }
  }
  
  public final void gW(int paramInt)
  {
    AppMethodBeat.i(139522);
    d locald = new d((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt);
      a(locald, localJSONObject);
      AppMethodBeat.o(139522);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMStart fail", new Object[] { localJSONException });
      AppMethodBeat.o(139522);
    }
  }
  
  public final void n(a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.i.b)) {
      this.kzD = ((com.tencent.mm.plugin.appbrand.i.b)parama);
    }
  }
  
  static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 784;
    private static final String NAME = "onXWebLivePusherAudioVolume";
  }
  
  static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 573;
    private static final String NAME = "onXWebLivePusherBGMComplete";
  }
  
  static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 572;
    private static final String NAME = "onXWebLivePusherBGMProgress";
  }
  
  static final class d
    extends ar
  {
    private static final int CTRL_INDEX = 571;
    private static final String NAME = "onXWebLivePusherBGMStart";
  }
  
  static final class e
    extends ar
  {
    private static final int CTRL_INDEX = 574;
    private static final String NAME = "onXWebLivePusherError";
  }
  
  static final class f
    extends ar
  {
    private static final int CTRL_INDEX = 569;
    private static final String NAME = "onXWebLivePusherEvent";
  }
  
  static final class g
    extends ar
  {
    private static final int CTRL_INDEX = 570;
    private static final String NAME = "onXWebLivePusherNetStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aa.c.b.b
 * JD-Core Version:    0.7.0.1
 */
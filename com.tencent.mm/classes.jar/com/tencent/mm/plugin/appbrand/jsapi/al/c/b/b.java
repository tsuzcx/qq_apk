package com.tencent.mm.plugin.appbrand.jsapi.al.c.b;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.a.b
{
  private com.tencent.mm.plugin.appbrand.h.b sPI;
  
  private void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139526);
    if ((!parambc.getName().equalsIgnoreCase("onXWebLivePusherEvent")) && (!parambc.getName().equalsIgnoreCase("onXWebLivePusherNetStatus"))) {
      Log.i("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "dispatch event:%s, data:%s", new Object[] { parambc.getName(), paramJSONObject.toString() });
    }
    parambc = parambc.ZR(paramJSONObject.toString());
    if (this.sPI != null)
    {
      paramJSONObject = this.sPI.rot;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof y))
        {
          ((y)paramJSONObject).a(parambc, null);
          AppMethodBeat.o(139526);
          return;
        }
        if ((paramJSONObject instanceof ad))
        {
          ((ad)paramJSONObject).a(parambc, null);
          AppMethodBeat.o(139526);
          return;
        }
        paramJSONObject.a(parambc, null);
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
      localJSONObject.put("errMsg", Util.nullAsNil(paramString));
      if (!paramHashMap.isEmpty()) {
        localJSONObject.put("data", new JSONObject(paramHashMap));
      }
      a(locale, localJSONObject);
      AppMethodBeat.o(139525);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherError fail", new Object[] { paramString });
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherEvent fail", new Object[] { paramBundle });
      AppMethodBeat.o(139520);
    }
  }
  
  public final void df(int paramInt1, int paramInt2)
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMComplete fail", new Object[] { localJSONException });
      AppMethodBeat.o(139524);
    }
  }
  
  public final void dg(int paramInt1, int paramInt2)
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherAudioVolume fail", new Object[] { localJSONException });
      AppMethodBeat.o(178856);
    }
  }
  
  public final void g(int paramInt, long paramLong1, long paramLong2)
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139523);
    }
  }
  
  public final void g(int paramInt, Bundle paramBundle)
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherNetStatus fail", new Object[] { paramBundle });
      AppMethodBeat.o(139521);
      return;
    }
    a(localg, localJSONObject1);
    AppMethodBeat.o(139521);
  }
  
  public final void m(a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.sPI = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
  
  public final void mI(int paramInt)
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePusherEventHandler", "onXWebLivePusherBGMStart fail", new Object[] { localJSONException });
      AppMethodBeat.o(139522);
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 784;
    private static final String NAME = "onXWebLivePusherAudioVolume";
  }
  
  static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 573;
    private static final String NAME = "onXWebLivePusherBGMComplete";
  }
  
  static final class c
    extends bc
  {
    private static final int CTRL_INDEX = 572;
    private static final String NAME = "onXWebLivePusherBGMProgress";
  }
  
  static final class d
    extends bc
  {
    private static final int CTRL_INDEX = 571;
    private static final String NAME = "onXWebLivePusherBGMStart";
  }
  
  static final class e
    extends bc
  {
    private static final int CTRL_INDEX = 574;
    private static final String NAME = "onXWebLivePusherError";
  }
  
  static final class f
    extends bc
  {
    private static final int CTRL_INDEX = 569;
    private static final String NAME = "onXWebLivePusherEvent";
  }
  
  static final class g
    extends bc
  {
    private static final int CTRL_INDEX = 570;
    private static final String NAME = "onXWebLivePusherNetStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.b.b
 * JD-Core Version:    0.7.0.1
 */
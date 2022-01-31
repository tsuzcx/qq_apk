package com.tencent.mm.plugin.appbrand.jsapi.v.b.a;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.v;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b
{
  private com.tencent.mm.plugin.appbrand.f.b iiC;
  
  private void a(ai paramai, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(140046);
    if ((!paramai.getName().equalsIgnoreCase("onXWebLivePlayerEvent")) && (!paramai.getName().equalsIgnoreCase("onXWebLivePlayerNetStatus"))) {
      ab.i("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "dispatch event:%s, data:%s", new Object[] { paramai.getName(), paramJSONObject.toString() });
    }
    paramai = paramai.BN(paramJSONObject.toString());
    if (this.iiC != null)
    {
      paramJSONObject = this.iiC.hrA;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof r))
        {
          paramJSONObject = (r)paramJSONObject;
          paramJSONObject.b(paramai);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramai);
          }
          AppMethodBeat.o(140046);
          return;
        }
        if ((paramJSONObject instanceof v))
        {
          paramJSONObject = (v)paramJSONObject;
          paramJSONObject.b(paramai);
          paramJSONObject = paramJSONObject.ws();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramai);
          }
          AppMethodBeat.o(140046);
          return;
        }
        paramJSONObject.b(paramai);
      }
    }
    AppMethodBeat.o(140046);
  }
  
  public final void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(140044);
    a locala = new a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      if (paramBundle == null) {}
      for (paramBundle = "";; paramBundle = paramBundle.getString("EVT_MSG"))
      {
        localJSONObject.put("errMsg", paramBundle);
        a(locala, localJSONObject);
        AppMethodBeat.o(140044);
        return;
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      ab.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerEvent fail", new Object[] { paramBundle });
      AppMethodBeat.o(140044);
    }
  }
  
  public final void c(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(140045);
    b.b localb = new b.b((byte)0);
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
      ab.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerNetStatus fail", new Object[] { paramBundle });
      AppMethodBeat.o(140045);
      return;
    }
    a(localb, localJSONObject1);
    AppMethodBeat.o(140045);
  }
  
  public final void d(a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.f.b)) {
      this.iiC = ((com.tencent.mm.plugin.appbrand.f.b)parama);
    }
  }
  
  static final class a
    extends ai
  {
    private static final int CTRL_INDEX = 575;
    private static final String NAME = "onXWebLivePlayerEvent";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.v.b.a.b
 * JD-Core Version:    0.7.0.1
 */
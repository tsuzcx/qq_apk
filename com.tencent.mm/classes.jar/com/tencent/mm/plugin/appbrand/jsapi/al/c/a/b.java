package com.tencent.mm.plugin.appbrand.jsapi.al.c.a;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.luggage.xweb_ext.extendplugin.component.live.a.a.b
{
  private com.tencent.mm.plugin.appbrand.h.b sPI;
  
  private void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139492);
    if ((!parambc.getName().equalsIgnoreCase("onXWebLivePlayerEvent")) && (!parambc.getName().equalsIgnoreCase("onXWebLivePlayerNetStatus")) && (!parambc.getName().equalsIgnoreCase("onXWebLivePlayerAudioVolume"))) {
      Log.i("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "dispatch event:%s, data:%s", new Object[] { parambc.getName(), paramJSONObject.toString() });
    }
    parambc = parambc.ZR(paramJSONObject.toString());
    if (this.sPI != null)
    {
      paramJSONObject = this.sPI.rot;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof y))
        {
          paramJSONObject = (y)paramJSONObject;
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.a(parambc, null);
          }
          AppMethodBeat.o(139492);
          return;
        }
        if ((paramJSONObject instanceof ad))
        {
          paramJSONObject = (ad)paramJSONObject;
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.ari();
          if (paramJSONObject != null) {
            paramJSONObject.a(parambc, null);
          }
          AppMethodBeat.o(139492);
          return;
        }
        paramJSONObject.a(parambc, null);
      }
    }
    AppMethodBeat.o(139492);
  }
  
  public final void M(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(327143);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("playInBackground", paramBoolean);
      a(new b((byte)0), localJSONObject);
      AppMethodBeat.o(327143);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(327143);
    }
  }
  
  public final void a(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    AppMethodBeat.i(139489);
    c localc = new c((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("errCode", paramInt2);
      if (paramBundle == null) {}
      for (paramBundle = "";; paramBundle = paramBundle.getString("EVT_MSG"))
      {
        localJSONObject.put("errMsg", paramBundle);
        a(localc, localJSONObject);
        AppMethodBeat.o(139489);
        return;
      }
      return;
    }
    catch (JSONException paramBundle)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerEvent fail", new Object[] { paramBundle });
      AppMethodBeat.o(139489);
    }
  }
  
  public final void de(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139491);
    a locala = new a((byte)0);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("viewId", paramInt1);
      localJSONObject.put("volume", paramInt2);
      a(locala, localJSONObject);
      AppMethodBeat.o(139491);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerAudioVolume fail", new Object[] { localJSONException });
      AppMethodBeat.o(139491);
    }
  }
  
  public final void f(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(139490);
    d locald = new d((byte)0);
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
      Log.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerNetStatus fail", new Object[] { paramBundle });
      AppMethodBeat.o(139490);
      return;
    }
    a(locald, localJSONObject1);
    AppMethodBeat.o(139490);
  }
  
  public final void m(a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.sPI = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
  
  static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 710;
    private static final String NAME = "onXWebLivePlayerAudioVolume";
  }
  
  static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 839;
    private static final String NAME = "onXWebLivePlayerBackgroundPlaybackChange";
  }
  
  static final class c
    extends bc
  {
    private static final int CTRL_INDEX = 575;
    private static final String NAME = "onXWebLivePlayerEvent";
  }
  
  static final class d
    extends bc
  {
    private static final int CTRL_INDEX = 576;
    private static final String NAME = "onXWebLivePlayerNetStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.c.a.b
 * JD-Core Version:    0.7.0.1
 */
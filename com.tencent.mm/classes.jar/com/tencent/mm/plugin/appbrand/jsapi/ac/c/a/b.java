package com.tencent.mm.plugin.appbrand.jsapi.ac.c.a;

import android.os.Bundle;
import com.tencent.luggage.xweb_ext.extendplugin.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
  implements com.tencent.luggage.xweb_ext.extendplugin.component.a.a.a.b
{
  private com.tencent.mm.plugin.appbrand.h.b lxU;
  
  private void a(at paramat, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139492);
    if ((!paramat.getName().equalsIgnoreCase("onXWebLivePlayerEvent")) && (!paramat.getName().equalsIgnoreCase("onXWebLivePlayerNetStatus")) && (!paramat.getName().equalsIgnoreCase("onXWebLivePlayerAudioVolume"))) {
      ad.i("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "dispatch event:%s, data:%s", new Object[] { paramat.getName(), paramJSONObject.toString() });
    }
    paramat = paramat.Pi(paramJSONObject.toString());
    if (this.lxU != null)
    {
      paramJSONObject = this.lxU.kjg;
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof q))
        {
          paramJSONObject = (q)paramJSONObject;
          paramJSONObject.b(paramat);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramat);
          }
          AppMethodBeat.o(139492);
          return;
        }
        if ((paramJSONObject instanceof aa))
        {
          paramJSONObject = (aa)paramJSONObject;
          paramJSONObject.b(paramat);
          paramJSONObject = paramJSONObject.Ew();
          if (paramJSONObject != null) {
            paramJSONObject.b(paramat);
          }
          AppMethodBeat.o(139492);
          return;
        }
        paramJSONObject.b(paramat);
      }
    }
    AppMethodBeat.o(139492);
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
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerEvent fail", new Object[] { paramBundle });
      AppMethodBeat.o(139489);
    }
  }
  
  public final void bW(int paramInt1, int paramInt2)
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
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerAudioVolume fail", new Object[] { localJSONException });
      AppMethodBeat.o(139491);
    }
  }
  
  public final void d(int paramInt, Bundle paramBundle)
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
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerNetStatus fail", new Object[] { paramBundle });
      AppMethodBeat.o(139490);
      return;
    }
    a(locald, localJSONObject1);
    AppMethodBeat.o(139490);
  }
  
  public final void m(a parama)
  {
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b)) {
      this.lxU = ((com.tencent.mm.plugin.appbrand.h.b)parama);
    }
  }
  
  public final void r(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(186922);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewId", paramInt);
      localJSONObject.put("playInBackground", paramBoolean);
      a(new b((byte)0), localJSONObject);
      AppMethodBeat.o(186922);
      return;
    }
    catch (JSONException localJSONException)
    {
      ad.e("MicroMsg.SameLayer.AppBrandLivePlayerEventHandler", "onXWebLivePlayerBackgroundPlaybackChange fail", new Object[] { localJSONException });
      AppMethodBeat.o(186922);
    }
  }
  
  static final class a
    extends at
  {
    private static final int CTRL_INDEX = 710;
    private static final String NAME = "onXWebLivePlayerAudioVolume";
  }
  
  static final class b
    extends at
  {
    private static final int CTRL_INDEX = 839;
    private static final String NAME = "onXWebLivePlayerBackgroundPlaybackChange";
  }
  
  static final class c
    extends at
  {
    private static final int CTRL_INDEX = 575;
    private static final String NAME = "onXWebLivePlayerEvent";
  }
  
  static final class d
    extends at
  {
    private static final int CTRL_INDEX = 576;
    private static final String NAME = "onXWebLivePlayerNetStatus";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.c.a.b
 * JD-Core Version:    0.7.0.1
 */
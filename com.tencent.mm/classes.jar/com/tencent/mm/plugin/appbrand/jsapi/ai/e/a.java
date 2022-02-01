package com.tencent.mm.plugin.appbrand.jsapi.ai.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigDecimal;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "()V", "mEventData", "", "mInvokeContext", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandInvokeContext;", "mLastUpdatePos", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "getBaseEventData", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoProgress", "percent", "onVideoTimeUpdate", "currentPosition", "duration", "onVideoWaiting", "onXWebCastingInterrupt", "onXWebCastingUserSelect", "state", "", "onXWebDLNACastingStateChange", "isSuccess", "setInvokeContext", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "Companion", "OnXWebCastingInterrupt", "OnXWebCastingUserSelect", "OnXWebVideoEnded", "OnXWebVideoError", "OnXWebVideoLoadedMetaData", "OnXWebVideoPause", "OnXWebVideoPlay", "OnXWebVideoPreloadedMetaData", "OnXWebVideoProgress", "OnXWebVideoTimeUpdate", "OnXWebVideoWaiting", "luggage-xweb-ext_release"})
public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
{
  public static final a pLo;
  private b pKP;
  private int pLm;
  private String pLn = "";
  
  static
  {
    AppMethodBeat.i(139650);
    pLo = new a((byte)0);
    AppMethodBeat.o(139650);
  }
  
  private final void a(az paramaz, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139648);
    if ((!(paramaz instanceof h)) && (!(paramaz instanceof g))) {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "dispatch event:%s, data:%s", new Object[] { paramaz.getName(), paramJSONObject.toString() });
    }
    paramaz = paramaz.agU(paramJSONObject.toString());
    if (this.pKP != null)
    {
      paramJSONObject = this.pKP;
      if (paramJSONObject == null) {
        p.iCn();
      }
      paramJSONObject = paramJSONObject.QK();
      if (paramJSONObject != null)
      {
        if ((paramJSONObject instanceof v))
        {
          paramJSONObject = (v)paramJSONObject;
          paramJSONObject.a(paramaz, null);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null)
          {
            paramJSONObject.a(paramaz, null);
            AppMethodBeat.o(139648);
            return;
          }
          AppMethodBeat.o(139648);
          return;
        }
        if ((paramJSONObject instanceof ad))
        {
          paramJSONObject = (ad)paramJSONObject;
          paramJSONObject.a(paramaz, null);
          paramJSONObject = paramJSONObject.QW();
          if (paramJSONObject != null)
          {
            paramJSONObject.a(paramaz, null);
            AppMethodBeat.o(139648);
            return;
          }
          AppMethodBeat.o(139648);
          return;
        }
        paramJSONObject.a(paramaz, null);
      }
    }
    AppMethodBeat.o(139648);
  }
  
  private final JSONObject bWg()
  {
    AppMethodBeat.i(139649);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.pLn);
    AppMethodBeat.o(139649);
    return localJSONObject;
  }
  
  public final void Ui()
  {
    AppMethodBeat.i(139646);
    try
    {
      JSONObject localJSONObject = bWg();
      a((az)new b(), localJSONObject);
      AppMethodBeat.o(139646);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingInterrupt fail", new Object[] { localJSONException });
      AppMethodBeat.o(139646);
    }
  }
  
  public final void cs(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139642);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoTimeUpdate: currentPosition = " + paramInt1 + " duration = " + paramInt2);
    try
    {
      if (Math.abs(paramInt1 - this.pLm) < 250)
      {
        AppMethodBeat.o(139642);
        return;
      }
      this.pLm = paramInt1;
      double d1 = paramInt2 * 1.0D / 1000.0D;
      double d2 = new BigDecimal(paramInt1 * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = bWg();
      localJSONObject.put("type", "DLNA");
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a((az)new h(), localJSONObject);
      AppMethodBeat.o(139642);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      AppMethodBeat.o(139642);
    }
  }
  
  public final void ct(boolean paramBoolean)
  {
    AppMethodBeat.i(139644);
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebDLNACastingStateChange: status = ".concat(String.valueOf(str)));
      try
      {
        JSONObject localJSONObject = bWg();
        localJSONObject.put("status", str);
        a((az)new j(), localJSONObject);
        AppMethodBeat.o(139644);
        return;
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebDLNACastingStateChange fail", new Object[] { localJSONException });
        AppMethodBeat.o(139644);
      }
    }
  }
  
  public final void cu(boolean paramBoolean)
  {
    AppMethodBeat.i(161187);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingUserSelect: ");
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("type", "DLNA");
      if (paramBoolean) {}
      for (String str = "success";; str = "fail")
      {
        localJSONObject.put("state", str);
        a((az)new c(), localJSONObject);
        AppMethodBeat.o(161187);
        return;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebCastingUserSelect fail", new Object[] { localJSONException });
      AppMethodBeat.o(161187);
    }
  }
  
  public final void ew(String paramString)
  {
    AppMethodBeat.i(139647);
    p.k(paramString, "data");
    this.pLn = paramString;
    AppMethodBeat.o(139647);
  }
  
  public final void jh(int paramInt)
  {
    AppMethodBeat.i(139641);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoProgress: ".concat(String.valueOf(paramInt)));
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("buffered", paramInt);
      localJSONObject.put("type", "DLNA");
      a((az)new g(), localJSONObject);
      AppMethodBeat.o(139641);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139641);
    }
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139643);
    p.k(parama, "invokeContext");
    if ((parama instanceof b)) {
      this.pKP = ((b)parama);
    }
    AppMethodBeat.o(139643);
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139639);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoEnded: ");
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("type", "DLNA");
      a((az)new d(), localJSONObject);
      AppMethodBeat.o(139639);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoEnded fail", new Object[] { localJSONException });
      AppMethodBeat.o(139639);
    }
  }
  
  public final void onVideoPause()
  {
    AppMethodBeat.i(139638);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoPause: ");
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("type", "DLNA");
      a((az)new e(), localJSONObject);
      AppMethodBeat.o(139638);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoPause fail", new Object[] { localJSONException });
      AppMethodBeat.o(139638);
    }
  }
  
  public final void onVideoPlay()
  {
    AppMethodBeat.i(139637);
    try
    {
      this.pLm = 0;
      JSONObject localJSONObject = bWg();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("type", "DLNA");
      a((az)new f(), localJSONObject);
      AppMethodBeat.o(139637);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoPlay fail", new Object[] { localJSONException });
      AppMethodBeat.o(139637);
    }
  }
  
  public final void onVideoWaiting()
  {
    AppMethodBeat.i(139640);
    try
    {
      JSONObject localJSONObject = bWg();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("type", "DLNA");
      a((az)new i(), localJSONObject);
      AppMethodBeat.o(139640);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(139640);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$Companion;", "", "()V", "TAG", "", "luggage-xweb-ext_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingInterrupt;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class b
    extends az
  {
    private static final int CTRL_INDEX = 704;
    private static final String NAME = "onXWebCastingInterrupt";
    public static final a pLp;
    
    static
    {
      AppMethodBeat.i(139628);
      pLp = new a((byte)0);
      NAME = "onXWebCastingInterrupt";
      CTRL_INDEX = 704;
      AppMethodBeat.o(139628);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingInterrupt$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingUserSelect;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class c
    extends az
  {
    private static final int CTRL_INDEX = 695;
    private static final String NAME = "onXWebCastingUserSelect";
    public static final a pLq;
    
    static
    {
      AppMethodBeat.i(139629);
      pLq = new a((byte)0);
      NAME = "onXWebCastingUserSelect";
      CTRL_INDEX = 695;
      AppMethodBeat.o(139629);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingUserSelect$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoEnded;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class d
    extends az
  {
    private static final int CTRL_INDEX = 543;
    private static final String NAME = "onXWebVideoEnded";
    public static final a pLr;
    
    static
    {
      AppMethodBeat.i(139630);
      pLr = new a((byte)0);
      NAME = "onXWebVideoEnded";
      CTRL_INDEX = 543;
      AppMethodBeat.o(139630);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoEnded$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPause;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class e
    extends az
  {
    private static final int CTRL_INDEX = 542;
    private static final String NAME = "onXWebVideoPause";
    public static final a pLs;
    
    static
    {
      AppMethodBeat.i(139631);
      pLs = new a((byte)0);
      NAME = "onXWebVideoPause";
      CTRL_INDEX = 542;
      AppMethodBeat.o(139631);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPause$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPlay;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class f
    extends az
  {
    private static final int CTRL_INDEX = 541;
    private static final String NAME = "onXWebVideoPlay";
    public static final a pLt;
    
    static
    {
      AppMethodBeat.i(139632);
      pLt = new a((byte)0);
      NAME = "onXWebVideoPlay";
      CTRL_INDEX = 541;
      AppMethodBeat.o(139632);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPlay$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoProgress;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class g
    extends az
  {
    private static final int CTRL_INDEX = 547;
    private static final String NAME = "onXWebVideoProgress";
    public static final a pLu;
    
    static
    {
      AppMethodBeat.i(139633);
      pLu = new a((byte)0);
      NAME = "onXWebVideoProgress";
      CTRL_INDEX = 547;
      AppMethodBeat.o(139633);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoProgress$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoTimeUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class h
    extends az
  {
    private static final int CTRL_INDEX = 544;
    private static final String NAME = "onXWebVideoTimeUpdate";
    public static final a pLv;
    
    static
    {
      AppMethodBeat.i(139634);
      pLv = new a((byte)0);
      NAME = "onXWebVideoTimeUpdate";
      CTRL_INDEX = 544;
      AppMethodBeat.o(139634);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoTimeUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoWaiting;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class i
    extends az
  {
    private static final int CTRL_INDEX = 540;
    private static final String NAME = "onXWebVideoWaiting";
    public static final a pLw;
    
    static
    {
      AppMethodBeat.i(139635);
      pLw = new a((byte)0);
      NAME = "onXWebVideoWaiting";
      CTRL_INDEX = 540;
      AppMethodBeat.o(139635);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoWaiting$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$onXWebDLNACastingStateChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"})
  static final class j
    extends az
  {
    private static final int CTRL_INDEX = 697;
    private static final String NAME = "onXWebDLNACastingStateChange";
    public static final a pLx;
    
    static
    {
      AppMethodBeat.i(139636);
      pLx = new a((byte)0);
      NAME = "onXWebDLNACastingStateChange";
      CTRL_INDEX = 697;
      AppMethodBeat.o(139636);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$onXWebDLNACastingStateChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ai.e.a
 * JD-Core Version:    0.7.0.1
 */
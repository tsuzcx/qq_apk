package com.tencent.mm.plugin.appbrand.jsapi.al.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.page.ad;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/video/custom/IVideoCastEventHandler;", "()V", "mEventData", "", "mInvokeContext", "Lcom/tencent/mm/plugin/appbrand/extendplugin/AppBrandInvokeContext;", "mLastUpdatePos", "", "dispatchEvent", "", "event", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "data", "Lorg/json/JSONObject;", "getBaseEventData", "onVideoEnded", "onVideoPause", "onVideoPlay", "onVideoProgress", "percent", "onVideoTimeUpdate", "currentPosition", "duration", "onVideoWaiting", "onXWebCastingInterrupt", "onXWebCastingUserSelect", "state", "", "onXWebDLNACastingStateChange", "isSuccess", "setInvokeContext", "invokeContext", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "setVideoEventData", "Companion", "OnXWebCastingInterrupt", "OnXWebCastingUserSelect", "OnXWebVideoEnded", "OnXWebVideoError", "OnXWebVideoLoadedMetaData", "OnXWebVideoPause", "OnXWebVideoPlay", "OnXWebVideoPreloadedMetaData", "OnXWebVideoProgress", "OnXWebVideoTimeUpdate", "OnXWebVideoWaiting", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a
{
  public static final a sQf;
  private b sPI;
  private int sQg;
  private String sQh = "";
  
  static
  {
    AppMethodBeat.i(139650);
    sQf = new a((byte)0);
    AppMethodBeat.o(139650);
  }
  
  private final void a(bc parambc, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(139648);
    if ((!(parambc instanceof h)) && (!(parambc instanceof g))) {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "dispatch event:%s, data:%s", new Object[] { parambc.getName(), paramJSONObject.toString() });
    }
    parambc = parambc.ZR(paramJSONObject.toString());
    if (this.sPI != null)
    {
      paramJSONObject = this.sPI;
      s.checkNotNull(paramJSONObject);
      paramJSONObject = paramJSONObject.rot;
      if (paramJSONObject != null) {
        if ((paramJSONObject instanceof y))
        {
          paramJSONObject = (y)paramJSONObject;
          s.checkNotNull(parambc);
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.getCurrentPageView();
          if (paramJSONObject != null)
          {
            paramJSONObject.a(parambc, null);
            AppMethodBeat.o(139648);
          }
        }
        else if ((paramJSONObject instanceof ad))
        {
          paramJSONObject = (ad)paramJSONObject;
          s.checkNotNull(parambc);
          paramJSONObject.a(parambc, null);
          paramJSONObject = paramJSONObject.ari();
          if (paramJSONObject != null)
          {
            paramJSONObject.a(parambc, null);
            AppMethodBeat.o(139648);
          }
        }
        else
        {
          paramJSONObject.a(parambc, null);
        }
      }
    }
    AppMethodBeat.o(139648);
  }
  
  private final JSONObject cws()
  {
    AppMethodBeat.i(139649);
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("data", this.sQh);
    AppMethodBeat.o(139649);
    return localJSONObject;
  }
  
  public final void auL()
  {
    AppMethodBeat.i(139646);
    try
    {
      JSONObject localJSONObject = cws();
      a((bc)new b(), localJSONObject);
      AppMethodBeat.o(139646);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingInterrupt fail", new Object[] { localJSONException });
      AppMethodBeat.o(139646);
    }
  }
  
  public final void cZ(boolean paramBoolean)
  {
    AppMethodBeat.i(139644);
    if (paramBoolean) {}
    for (String str = "success";; str = "fail")
    {
      Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", s.X("onXWebDLNACastingStateChange: status = ", str));
      try
      {
        JSONObject localJSONObject = cws();
        localJSONObject.put("status", str);
        a((bc)new j(), localJSONObject);
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
  
  public final void da(boolean paramBoolean)
  {
    AppMethodBeat.i(161187);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onXWebCastingUserSelect: ");
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("type", "DLNA");
      if (paramBoolean) {}
      for (String str = "success";; str = "fail")
      {
        localJSONObject.put("state", str);
        a((bc)new c(), localJSONObject);
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
  
  public final void dh(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(139642);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoTimeUpdate: currentPosition = " + paramInt1 + " duration = " + paramInt2);
    try
    {
      if (Math.abs(paramInt1 - this.sQg) < 250)
      {
        AppMethodBeat.o(139642);
        return;
      }
      this.sQg = paramInt1;
      double d1 = paramInt2 * 1.0D / 1000.0D;
      double d2 = new BigDecimal(paramInt1 * 1.0D / 1000.0D).setScale(3, 4).doubleValue();
      JSONObject localJSONObject = cws();
      localJSONObject.put("type", "DLNA");
      localJSONObject.put("position", d2);
      localJSONObject.put("duration", d1);
      a((bc)new h(), localJSONObject);
      AppMethodBeat.o(139642);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoTimeUpdate fail", new Object[] { localJSONException });
      AppMethodBeat.o(139642);
    }
  }
  
  public final void fT(String paramString)
  {
    AppMethodBeat.i(139647);
    s.u(paramString, "data");
    this.sQh = paramString;
    AppMethodBeat.o(139647);
  }
  
  public final void m(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(139643);
    s.u(parama, "invokeContext");
    if ((parama instanceof b)) {
      this.sPI = ((b)parama);
    }
    AppMethodBeat.o(139643);
  }
  
  public final void mJ(int paramInt)
  {
    AppMethodBeat.i(139641);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", s.X("onVideoProgress: ", Integer.valueOf(paramInt)));
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("buffered", paramInt);
      localJSONObject.put("type", "DLNA");
      a((bc)new g(), localJSONObject);
      AppMethodBeat.o(139641);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoProgress fail", new Object[] { localJSONException });
      AppMethodBeat.o(139641);
    }
  }
  
  public final void onVideoEnded()
  {
    AppMethodBeat.i(139639);
    Log.i("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "onVideoEnded: ");
    try
    {
      JSONObject localJSONObject = cws();
      localJSONObject.put("type", "DLNA");
      a((bc)new d(), localJSONObject);
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
      JSONObject localJSONObject = cws();
      localJSONObject.put("type", "DLNA");
      a((bc)new e(), localJSONObject);
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
      this.sQg = 0;
      JSONObject localJSONObject = cws();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("type", "DLNA");
      a((bc)new f(), localJSONObject);
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
      JSONObject localJSONObject = cws();
      localJSONObject.put("timeStamp", System.currentTimeMillis());
      localJSONObject.put("type", "DLNA");
      a((bc)new i(), localJSONObject);
      AppMethodBeat.o(139640);
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.e("MicroMsg.SameLayer.AppBrandVideoCastEventHandler", "OnXWebVideoWaiting fail", new Object[] { localJSONException });
      AppMethodBeat.o(139640);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$Companion;", "", "()V", "TAG", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingInterrupt;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQi;
    
    static
    {
      AppMethodBeat.i(139628);
      sQi = new a((byte)0);
      NAME = "onXWebCastingInterrupt";
      CTRL_INDEX = 704;
      AppMethodBeat.o(139628);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingInterrupt$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingUserSelect;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class c
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQj;
    
    static
    {
      AppMethodBeat.i(139629);
      sQj = new a((byte)0);
      NAME = "onXWebCastingUserSelect";
      CTRL_INDEX = 695;
      AppMethodBeat.o(139629);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebCastingUserSelect$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoEnded;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class d
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQk;
    
    static
    {
      AppMethodBeat.i(139630);
      sQk = new a((byte)0);
      NAME = "onXWebVideoEnded";
      CTRL_INDEX = 543;
      AppMethodBeat.o(139630);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoEnded$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPause;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class e
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQl;
    
    static
    {
      AppMethodBeat.i(139631);
      sQl = new a((byte)0);
      NAME = "onXWebVideoPause";
      CTRL_INDEX = 542;
      AppMethodBeat.o(139631);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPause$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPlay;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class f
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQm;
    
    static
    {
      AppMethodBeat.i(139632);
      sQm = new a((byte)0);
      NAME = "onXWebVideoPlay";
      CTRL_INDEX = 541;
      AppMethodBeat.o(139632);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoPlay$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoProgress;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class g
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQn;
    
    static
    {
      AppMethodBeat.i(139633);
      sQn = new a((byte)0);
      NAME = "onXWebVideoProgress";
      CTRL_INDEX = 547;
      AppMethodBeat.o(139633);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoProgress$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoTimeUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class h
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQo;
    
    static
    {
      AppMethodBeat.i(139634);
      sQo = new a((byte)0);
      NAME = "onXWebVideoTimeUpdate";
      CTRL_INDEX = 544;
      AppMethodBeat.o(139634);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoTimeUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoWaiting;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class i
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQp;
    
    static
    {
      AppMethodBeat.i(139635);
      sQp = new a((byte)0);
      NAME = "onXWebVideoWaiting";
      CTRL_INDEX = 540;
      AppMethodBeat.o(139635);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$OnXWebVideoWaiting$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$onXWebDLNACastingStateChange;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class j
    extends bc
  {
    private static final int CTRL_INDEX;
    private static final String NAME;
    public static final a sQq;
    
    static
    {
      AppMethodBeat.i(139636);
      sQq = new a((byte)0);
      NAME = "onXWebDLNACastingStateChange";
      CTRL_INDEX = 697;
      AppMethodBeat.o(139636);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastEventHandler$onXWebDLNACastingStateChange$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "luggage-xweb-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al.e.a
 * JD-Core Version:    0.7.0.1
 */
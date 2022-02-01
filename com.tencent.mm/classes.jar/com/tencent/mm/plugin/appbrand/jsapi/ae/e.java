package com.tencent.mm.plugin.appbrand.jsapi.ae;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/voip/VoipRoomPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "()V", "cloudVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "scaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "surfaceDefaultBufferHeight", "", "surfaceDefaultBufferWidth", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoHeight", "videoObjectFit", "", "videoWidth", "adjustScale", "", "data", "Lorg/json/JSONObject;", "adjustSurfaceSize", "openVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "applyScale", "handleJsApi", "invokeContext", "handlePluginDestroy", "handlePluginReady", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isPluginReady", "", "onVideoSizeChanged", "width", "height", "release", "remove", "update", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements d.b
{
  public static final e.a mGk;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> lRj;
  private com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c mGf;
  private int mGg;
  private int mGh;
  private String mGi;
  private com.tencent.mm.plugin.appbrand.jsapi.ag.e.g mGj;
  private SurfaceTexture surfaceTexture;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(228595);
    mGk = new e.a((byte)0);
    AppMethodBeat.o(228595);
  }
  
  public e()
  {
    AppMethodBeat.i(228594);
    this.lRj = ((List)new ArrayList());
    this.mGi = "cover";
    this.mGj = new com.tencent.mm.plugin.appbrand.jsapi.ag.e.g();
    AppMethodBeat.o(228594);
  }
  
  private final void bLm()
  {
    AppMethodBeat.i(228593);
    com.tencent.mm.plugin.appbrand.jsapi.ag.e.g localg = this.mGj;
    if (localg.a(this.mGi, this.mGg, this.mGh, this.videoWidth, this.videoHeight)) {
      com.tencent.luggage.xweb_ext.extendplugin.d.a(QJ(), getType(), getId(), localg.QH(), localg.QI());
    }
    AppMethodBeat.o(228593);
  }
  
  public final void PQ()
  {
    AppMethodBeat.i(228586);
    super.PQ();
    this.surfaceTexture = null;
    release();
    this.lRj.clear();
    AppMethodBeat.o(228586);
  }
  
  final void a(JSONObject paramJSONObject, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d paramd)
  {
    AppMethodBeat.i(228591);
    paramJSONObject = paramJSONObject.optJSONObject("position");
    if (paramJSONObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.ac.g.zD(paramJSONObject.optInt("width", 0));
      int j = com.tencent.mm.plugin.appbrand.ac.g.zD(paramJSONObject.optInt("height", 0));
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "adjustSurfaceSize, size:[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i > 0) && (j > 0))
      {
        this.mGg = i;
        this.mGh = j;
        SurfaceTexture localSurfaceTexture = this.surfaceTexture;
        if (localSurfaceTexture != null) {
          localSurfaceTexture.setDefaultBufferSize(i, j);
        }
        if (paramd != null) {
          paramd.fq(i, j);
        }
        if (paramd != null)
        {
          paramd.fr(paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
          AppMethodBeat.o(228591);
          return;
        }
      }
    }
    AppMethodBeat.o(228591);
  }
  
  final void ag(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(228592);
    paramJSONObject = paramJSONObject.optString("objectFit", "");
    kotlin.g.b.p.g(paramJSONObject, "objFit");
    if (((CharSequence)paramJSONObject).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.mGi = paramJSONObject;
      }
      bLm();
      AppMethodBeat.o(228592);
      return;
    }
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(228585);
    super.e(paramSurfaceTexture);
    this.surfaceTexture = paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture = ((Iterable)this.lRj).iterator();
      while (paramSurfaceTexture.hasNext()) {
        h((com.tencent.luggage.xweb_ext.extendplugin.a)paramSurfaceTexture.next());
      }
      this.lRj.clear();
    }
    AppMethodBeat.o(228585);
  }
  
  public final void eq(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(228590);
    if ((this.videoWidth == paramInt1) && (this.videoHeight == paramInt2))
    {
      AppMethodBeat.o(228590);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    bLm();
    AppMethodBeat.o(228590);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(228587);
    kotlin.g.b.p.h(parama, "invokeContext");
    AppMethodBeat.o(228587);
    return true;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(228588);
    kotlin.g.b.p.h(parama, "invokeContext");
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      final f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
      final com.tencent.mm.plugin.appbrand.jsapi.p localp = ((com.tencent.mm.plugin.appbrand.h.b)parama).bCx();
      final JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.h.b)parama).KX();
      String str = Lb();
      kotlin.g.b.p.g(localp, "jsApi");
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { str, localp.getName(), localJSONObject.toString() });
      localf.P((Runnable)new b(this, parama, (Runnable)new c(this, localp, localf, parama, localJSONObject)));
    }
    AppMethodBeat.o(228588);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(228589);
    if (this.mGf != null)
    {
      q.qta.czk().a(this.mGf);
      this.mGf = null;
    }
    AppMethodBeat.o(228589);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, Runnable paramRunnable) {}
    
    public final void run()
    {
      AppMethodBeat.i(228583);
      if (e.b(this.mGl) == null)
      {
        e.c(this.mGl).add(parama);
        AppMethodBeat.o(228583);
        return;
      }
      this.mGm.run();
      AppMethodBeat.o(228583);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, com.tencent.mm.plugin.appbrand.jsapi.p paramp, f paramf, com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(228584);
      Object localObject1 = localp;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((localObject1 instanceof c))
      {
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "insert xweb voip");
        localObject1 = this.mGl;
        localObject2 = localf;
        kotlin.g.b.p.g(localObject2, "component");
        localObject3 = parama;
        localObject4 = localJSONObject;
        kotlin.g.b.p.g(localObject4, "data");
        e.a((e)localObject1, (f)localObject2, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject3, (JSONObject)localObject4);
        AppMethodBeat.o(228584);
        return;
      }
      JSONObject localJSONObject;
      if ((localObject1 instanceof b))
      {
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "update xweb voip");
        localObject3 = this.mGl;
        localObject4 = parama;
        localObject2 = e.a(this.mGl);
        localJSONObject = localJSONObject;
        kotlin.g.b.p.g(localJSONObject, "data");
        kotlin.g.b.p.h(localObject4, "invokeContext");
        kotlin.g.b.p.h(localJSONObject, "data");
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onUpdateView, data:".concat(String.valueOf(localJSONObject)));
        if (localObject2 == null)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).dP("fail");
          Log.w("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "the view is null");
          AppMethodBeat.o(228584);
          return;
        }
        if ((localObject2 instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d)) {
          break label303;
        }
      }
      label303:
      for (localObject1 = null;; localObject1 = localObject2)
      {
        ((e)localObject3).a(localJSONObject, (com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d)localObject1);
        ((e)localObject3).ag(localJSONObject);
        ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)localObject2).aH(localJSONObject);
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).dP("ok");
        AppMethodBeat.o(228584);
        return;
        if ((localObject1 instanceof d))
        {
          Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "remove xweb voip");
          localObject1 = this.mGl;
          localObject2 = parama;
          localObject3 = localJSONObject;
          kotlin.g.b.p.g(localObject3, "data");
          kotlin.g.b.p.h(localObject2, "invokeContext");
          kotlin.g.b.p.h(localObject3, "data");
          Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onRemoveView,".concat(String.valueOf(localObject3)));
          ((e)localObject1).release();
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).dP("ok");
        }
        AppMethodBeat.o(228584);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ae.e
 * JD-Core Version:    0.7.0.1
 */
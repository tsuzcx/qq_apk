package com.tencent.mm.plugin.appbrand.jsapi.ag;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.d.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/voip/VoipRoomPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "()V", "cloudVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "scaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "surfaceDefaultBufferHeight", "", "surfaceDefaultBufferWidth", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoHeight", "videoObjectFit", "", "videoWidth", "adjustScale", "", "data", "Lorg/json/JSONObject;", "adjustSurfaceSize", "openVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "applyScale", "handleJsApi", "invokeContext", "handlePluginDestroy", "handlePluginReady", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isPluginReady", "", "onVideoSizeChanged", "width", "height", "release", "remove", "update", "Companion", "plugin-appbrand-integration_release"})
public final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements d.b
{
  public static final e.a pFp;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> oNE;
  private com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c pFk;
  private int pFl;
  private int pFm;
  private String pFn;
  private com.tencent.mm.plugin.appbrand.jsapi.ai.e.g pFo;
  private SurfaceTexture surfaceTexture;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(253615);
    pFp = new e.a((byte)0);
    AppMethodBeat.o(253615);
  }
  
  public e()
  {
    AppMethodBeat.i(253614);
    this.oNE = ((List)new ArrayList());
    this.pFn = "cover";
    this.pFo = new com.tencent.mm.plugin.appbrand.jsapi.ai.e.g();
    AppMethodBeat.o(253614);
  }
  
  private final void bXm()
  {
    AppMethodBeat.i(253611);
    com.tencent.mm.plugin.appbrand.jsapi.ai.e.g localg = this.pFo;
    if (localg.a(this.pFn, this.pFl, this.pFm, this.videoWidth, this.videoHeight)) {
      com.tencent.luggage.xweb_ext.extendplugin.d.a(Uq(), getType(), getId(), localg.Uo(), localg.Up());
    }
    AppMethodBeat.o(253611);
  }
  
  public final void Tr()
  {
    AppMethodBeat.i(253593);
    super.Tr();
    this.surfaceTexture = null;
    release();
    this.oNE.clear();
    AppMethodBeat.o(253593);
  }
  
  final void a(JSONObject paramJSONObject, com.tencent.mm.plugin.cloudvoip.cloudvoice.d.d paramd)
  {
    AppMethodBeat.i(253606);
    paramJSONObject = paramJSONObject.optJSONObject("position");
    if (paramJSONObject != null)
    {
      int i = com.tencent.mm.plugin.appbrand.ac.g.Di(paramJSONObject.optInt("width", 0));
      int j = com.tencent.mm.plugin.appbrand.ac.g.Di(paramJSONObject.optInt("height", 0));
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "adjustSurfaceSize, size:[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i > 0) && (j > 0))
      {
        this.pFl = i;
        this.pFm = j;
        SurfaceTexture localSurfaceTexture = this.surfaceTexture;
        if (localSurfaceTexture != null) {
          localSurfaceTexture.setDefaultBufferSize(i, j);
        }
        if (paramd != null) {
          paramd.fN(i, j);
        }
        if (paramd != null)
        {
          paramd.fO(paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
          AppMethodBeat.o(253606);
          return;
        }
      }
    }
    AppMethodBeat.o(253606);
  }
  
  final void ak(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(253609);
    paramJSONObject = paramJSONObject.optString("objectFit", "");
    p.j(paramJSONObject, "objFit");
    if (((CharSequence)paramJSONObject).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.pFn = paramJSONObject;
      }
      bXm();
      AppMethodBeat.o(253609);
      return;
    }
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(253591);
    super.e(paramSurfaceTexture);
    this.surfaceTexture = paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture = ((Iterable)this.oNE).iterator();
      while (paramSurfaceTexture.hasNext()) {
        h((com.tencent.luggage.xweb_ext.extendplugin.a)paramSurfaceTexture.next());
      }
      this.oNE.clear();
    }
    AppMethodBeat.o(253591);
  }
  
  public final void eO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(253603);
    if ((this.videoWidth == paramInt1) && (this.videoHeight == paramInt2))
    {
      AppMethodBeat.o(253603);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    bXm();
    AppMethodBeat.o(253603);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(253596);
    p.k(parama, "invokeContext");
    AppMethodBeat.o(253596);
    return true;
  }
  
  public final String h(final com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(253598);
    p.k(parama, "invokeContext");
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      final com.tencent.mm.plugin.appbrand.jsapi.e locale = ((com.tencent.mm.plugin.appbrand.h.b)parama).QK();
      final o localo = ((com.tencent.mm.plugin.appbrand.h.b)parama).bNS();
      final JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.h.b)parama).NN();
      String str = key();
      p.j(localo, "jsApi");
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { str, localo.getName(), localJSONObject.toString() });
      locale.P((Runnable)new b(this, parama, (Runnable)new c(this, localo, locale, parama, localJSONObject)));
    }
    AppMethodBeat.o(253598);
    return null;
  }
  
  public final void release()
  {
    AppMethodBeat.i(253600);
    if (this.pFk != null)
    {
      q.tRM.cNJ().a(this.pFk);
      this.pFk = null;
    }
    AppMethodBeat.o(253600);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, Runnable paramRunnable) {}
    
    public final void run()
    {
      AppMethodBeat.i(280156);
      if (e.b(this.pFq) == null)
      {
        e.c(this.pFq).add(parama);
        AppMethodBeat.o(280156);
        return;
      }
      this.pFr.run();
      AppMethodBeat.o(280156);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(e parame, o paramo, com.tencent.mm.plugin.appbrand.jsapi.e parame1, com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject) {}
    
    public final void run()
    {
      AppMethodBeat.i(280029);
      Object localObject1 = localo;
      Object localObject2;
      Object localObject3;
      Object localObject4;
      if ((localObject1 instanceof c))
      {
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "insert xweb voip");
        localObject1 = this.pFq;
        localObject2 = locale;
        p.j(localObject2, "component");
        localObject3 = parama;
        localObject4 = localJSONObject;
        p.j(localObject4, "data");
        e.a((e)localObject1, (com.tencent.mm.plugin.appbrand.jsapi.e)localObject2, (com.tencent.luggage.xweb_ext.extendplugin.a)localObject3, (JSONObject)localObject4);
        AppMethodBeat.o(280029);
        return;
      }
      JSONObject localJSONObject;
      if ((localObject1 instanceof b))
      {
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "update xweb voip");
        localObject3 = this.pFq;
        localObject4 = parama;
        localObject2 = e.a(this.pFq);
        localJSONObject = localJSONObject;
        p.j(localJSONObject, "data");
        p.k(localObject4, "invokeContext");
        p.k(localJSONObject, "data");
        Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onUpdateView, data:".concat(String.valueOf(localJSONObject)));
        if (localObject2 == null)
        {
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).er("fail");
          Log.w("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "the view is null");
          AppMethodBeat.o(280029);
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
        ((e)localObject3).ak(localJSONObject);
        ((com.tencent.mm.plugin.cloudvoip.cloudvoice.d.c)localObject2).aL(localJSONObject);
        ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject4).er("ok");
        AppMethodBeat.o(280029);
        return;
        if ((localObject1 instanceof d))
        {
          Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "remove xweb voip");
          localObject1 = this.pFq;
          localObject2 = parama;
          localObject3 = localJSONObject;
          p.j(localObject3, "data");
          p.k(localObject2, "invokeContext");
          p.k(localObject3, "data");
          Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "onRemoveView,".concat(String.valueOf(localObject3)));
          ((e)localObject1).release();
          ((com.tencent.luggage.xweb_ext.extendplugin.a)localObject2).er("ok");
        }
        AppMethodBeat.o(280029);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ag.e
 * JD-Core Version:    0.7.0.1
 */
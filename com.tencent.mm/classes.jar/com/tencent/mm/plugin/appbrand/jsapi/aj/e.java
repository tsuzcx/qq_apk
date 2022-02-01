package com.tencent.mm.plugin.appbrand.jsapi.aj;

import android.graphics.SurfaceTexture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.jsapi.al.e.g;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d.a;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d.b;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.q;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.service.t;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/voip/VoipRoomPluginHandler;", "Lcom/tencent/luggage/xweb_ext/extendplugin/handler/BaseExtendPluginHandler;", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView$SameLayerCallback;", "()V", "cloudVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/IOpenVoiceView;", "pendingInvokeContexts", "", "Lcom/tencent/luggage/xweb_ext/extendplugin/IExtendPluginInvokeContext;", "scaleHandler", "Lcom/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoScaleHandler;", "surfaceDefaultBufferHeight", "", "surfaceDefaultBufferWidth", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "videoHeight", "videoObjectFit", "", "videoWidth", "adjustScale", "", "data", "Lorg/json/JSONObject;", "adjustSurfaceSize", "openVoiceView", "Lcom/tencent/mm/plugin/cloudvoip/cloudvoice/service/ISameLayerOpenVoiceView;", "applyScale", "handleJsApi", "invokeContext", "handlePluginDestroy", "handlePluginReady", "insert", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "isPluginReady", "", "onVideoSizeChanged", "width", "height", "release", "remove", "update", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.luggage.xweb_ext.extendplugin.a.a
  implements d.b
{
  public static final e.a sKv;
  private final List<com.tencent.luggage.xweb_ext.extendplugin.a> rRz;
  private g sKA;
  private com.tencent.mm.plugin.cloudvoip.cloudvoice.service.c sKw;
  private int sKx;
  private int sKy;
  private String sKz;
  private SurfaceTexture surfaceTexture;
  private int videoHeight;
  private int videoWidth;
  
  static
  {
    AppMethodBeat.i(325839);
    sKv = new e.a((byte)0);
    AppMethodBeat.o(325839);
  }
  
  public e()
  {
    AppMethodBeat.i(325815);
    this.rRz = ((List)new ArrayList());
    this.sKz = "cover";
    this.sKA = new g();
    AppMethodBeat.o(325815);
  }
  
  private static final void a(e parame, com.tencent.luggage.xweb_ext.extendplugin.a parama, Runnable paramRunnable)
  {
    AppMethodBeat.i(325837);
    s.u(parame, "this$0");
    s.u(parama, "$invokeContext");
    s.u(paramRunnable, "$runnable");
    if (parame.surfaceTexture == null)
    {
      parame.rRz.add(parama);
      AppMethodBeat.o(325837);
      return;
    }
    paramRunnable.run();
    AppMethodBeat.o(325837);
  }
  
  private static final void a(p paramp, e parame, f paramf, com.tencent.luggage.xweb_ext.extendplugin.a parama, JSONObject paramJSONObject)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(325832);
    s.u(parame, "this$0");
    s.u(parama, "$invokeContext");
    if ((paramp instanceof c))
    {
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "insert xweb voip");
      s.s(paramf, "component");
      s.s(paramJSONObject, "data");
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", s.X("onInsertView, viewId:[data:", paramJSONObject));
      SurfaceTexture localSurfaceTexture = parame.surfaceTexture;
      if (localSurfaceTexture != null)
      {
        paramp = paramf.getContext();
        if (paramp == null)
        {
          parama.fO("fail");
          AppMethodBeat.o(325832);
          return;
        }
        if (q.wVc.mRoomType == 2)
        {
          parama.fO("fail");
          Log.w("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "insert XWeb VoIp view failed, room is audio room");
          AppMethodBeat.o(325832);
          return;
        }
        com.tencent.mm.plugin.cloudvoip.cloudvoice.service.c localc = q.wVc.wVh.a(paramp, paramJSONObject, true);
        if (localc == null)
        {
          paramp = localObject2;
          parame.sKw = paramp;
          if (parame.sKw != null)
          {
            parama.fO("ok");
            AppMethodBeat.o(325832);
          }
        }
        else
        {
          if ((localc instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d))
          {
            paramp = (com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d)localc;
            label195:
            if (paramp != null) {
              break label209;
            }
          }
          for (paramp = null;; paramp = localc)
          {
            break;
            paramp = null;
            break label195;
            label209:
            parame.a(paramJSONObject, paramp);
            parame.au(paramJSONObject);
            paramf = localObject1;
            if ((paramp instanceof d.a)) {
              paramf = (d.a)paramp;
            }
            if (paramf != null) {
              paramf.setSameLayerCallback((d.b)parame);
            }
            paramp.setSurfaceTexture(localSurfaceTexture);
            localc.aV(paramJSONObject);
          }
        }
        parama.fO("fail");
      }
      AppMethodBeat.o(325832);
      return;
    }
    if ((paramp instanceof b))
    {
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "update xweb voip");
      paramf = parame.sKw;
      s.s(paramJSONObject, "data");
      s.u(parama, "invokeContext");
      s.u(paramJSONObject, "data");
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", s.X("onUpdateView, data:", paramJSONObject));
      if (paramf == null)
      {
        parama.fO("fail");
        Log.w("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "the view is null");
        AppMethodBeat.o(325832);
        return;
      }
      if ((paramf instanceof com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d)) {}
      for (paramp = (com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d)paramf;; paramp = null)
      {
        parame.a(paramJSONObject, paramp);
        parame.au(paramJSONObject);
        paramf.aW(paramJSONObject);
        parama.fO("ok");
        AppMethodBeat.o(325832);
        return;
      }
    }
    if ((paramp instanceof d))
    {
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "remove xweb voip");
      s.s(paramJSONObject, "data");
      s.u(parama, "invokeContext");
      s.u(paramJSONObject, "data");
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", s.X("onRemoveView,", paramJSONObject));
      parame.release();
      parama.fO("ok");
    }
    AppMethodBeat.o(325832);
  }
  
  private final void a(JSONObject paramJSONObject, com.tencent.mm.plugin.cloudvoip.cloudvoice.service.d paramd)
  {
    AppMethodBeat.i(325818);
    paramJSONObject = paramJSONObject.optJSONObject("position");
    if (paramJSONObject != null)
    {
      int i = i.DC(paramJSONObject.optInt("width", 0));
      int j = i.DC(paramJSONObject.optInt("height", 0));
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "adjustSurfaceSize, size:[%d, %d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      if ((i > 0) && (j > 0))
      {
        this.sKx = i;
        this.sKy = j;
        SurfaceTexture localSurfaceTexture = this.surfaceTexture;
        if (localSurfaceTexture != null) {
          localSurfaceTexture.setDefaultBufferSize(i, j);
        }
        if (paramd != null) {
          paramd.gE(i, j);
        }
        if (paramd != null) {
          paramd.gF(paramJSONObject.optInt("width", 0), paramJSONObject.optInt("height", 0));
        }
      }
    }
    AppMethodBeat.o(325818);
  }
  
  private final void au(JSONObject paramJSONObject)
  {
    AppMethodBeat.i(325820);
    paramJSONObject = paramJSONObject.optString("objectFit", "");
    s.s(paramJSONObject, "objFit");
    if (((CharSequence)paramJSONObject).length() > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.sKz = paramJSONObject;
      }
      cxy();
      AppMethodBeat.o(325820);
      return;
    }
  }
  
  private final void cxy()
  {
    AppMethodBeat.i(325825);
    g localg = this.sKA;
    if (localg.a(this.sKz, this.sKx, this.sKy, this.videoWidth, this.videoHeight)) {
      com.tencent.luggage.xweb_ext.extendplugin.d.a(auT(), this.type, getId(), localg.sQQ, localg.sQR);
    }
    AppMethodBeat.o(325825);
  }
  
  private void release()
  {
    AppMethodBeat.i(325816);
    if (this.sKw != null)
    {
      q.wVc.wVh.a(this.sKw);
      this.sKw = null;
    }
    AppMethodBeat.o(325816);
  }
  
  public final void atW()
  {
    AppMethodBeat.i(325850);
    super.atW();
    this.surfaceTexture = null;
    release();
    this.rRz.clear();
    AppMethodBeat.o(325850);
  }
  
  public final void e(SurfaceTexture paramSurfaceTexture)
  {
    AppMethodBeat.i(325849);
    super.e(paramSurfaceTexture);
    this.surfaceTexture = paramSurfaceTexture;
    if (paramSurfaceTexture != null)
    {
      paramSurfaceTexture = ((Iterable)this.rRz).iterator();
      while (paramSurfaceTexture.hasNext()) {
        h((com.tencent.luggage.xweb_ext.extendplugin.a)paramSurfaceTexture.next());
      }
      this.rRz.clear();
    }
    AppMethodBeat.o(325849);
  }
  
  public final void fH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(325858);
    if ((this.videoWidth == paramInt1) && (this.videoHeight == paramInt2))
    {
      AppMethodBeat.o(325858);
      return;
    }
    this.videoWidth = paramInt1;
    this.videoHeight = paramInt2;
    cxy();
    AppMethodBeat.o(325858);
  }
  
  public final boolean g(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(325851);
    s.u(parama, "invokeContext");
    AppMethodBeat.o(325851);
    return true;
  }
  
  public final String h(com.tencent.luggage.xweb_ext.extendplugin.a parama)
  {
    AppMethodBeat.i(325856);
    s.u(parama, "invokeContext");
    if ((parama instanceof com.tencent.mm.plugin.appbrand.h.b))
    {
      f localf = ((com.tencent.mm.plugin.appbrand.h.b)parama).rot;
      p localp = ((com.tencent.mm.plugin.appbrand.h.b)parama).ros;
      JSONObject localJSONObject = ((com.tencent.mm.plugin.appbrand.h.b)parama).rmi;
      Log.i("MicroMsg.AppBrand.SameLayer.VoipRoomPluginHandler", "*** handler(%s) handleJsApi(%s), data:%s", new Object[] { key(), localp.getName(), localJSONObject.toString() });
      localf.V(new e..ExternalSyntheticLambda0(this, parama, new e..ExternalSyntheticLambda1(localp, this, localf, parama, localJSONObject)));
    }
    AppMethodBeat.o(325856);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aj.e
 * JD-Core Version:    0.7.0.1
 */
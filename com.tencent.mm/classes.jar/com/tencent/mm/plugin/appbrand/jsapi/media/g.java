package com.tencent.mm.plugin.appbrand.jsapi.media;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.appbrand.af.k;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatEnvironment;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideoNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "()V", "oldImpl", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/JsApiChooseVideo;", "invoke", "", "component", "data", "Lorg/json/JSONObject;", "callbackId", "", "shouldDeleteSourceFileBySourceScene", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/media/ChooseMediaResult$OK;", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends com.tencent.mm.plugin.appbrand.jsapi.c<com.tencent.mm.plugin.appbrand.jsapi.f>
{
  @Deprecated
  public static final int CTRL_INDEX = 36;
  @Deprecated
  public static final String NAME = "chooseVideo";
  private static final g.a sgH;
  private JsApiChooseVideo sgI;
  
  static
  {
    AppMethodBeat.i(50564);
    sgH = new g.a((byte)0);
    AppMethodBeat.o(50564);
  }
  
  public g()
  {
    AppMethodBeat.i(50563);
    if (((com.tencent.mm.plugin.expt.b.c)h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yTF, 1) > 0) {}
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.sgI = new JsApiChooseVideo();
      }
      AppMethodBeat.o(50563);
      return;
    }
  }
  
  private static final com.tencent.mm.vfs.u a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, boolean paramBoolean, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(329289);
    if (!paramf.isRunning())
    {
      com.tencent.mm.vending.g.g.jJL().gM(new Exception("component not running"));
      AppMethodBeat.o(329289);
      return null;
    }
    if (paramBoolean) {
      try
      {
        paramf = new com.tencent.mm.vfs.u(u.aaU(com.tencent.mm.vfs.ah.v(paramu.jKT())));
        AppMethodBeat.o(329289);
        return paramf;
      }
      catch (Exception paramf)
      {
        if (WeChatEnvironment.hasDebugger())
        {
          AppMethodBeat.o(329289);
          throw paramf;
        }
        com.tencent.mm.vending.g.g.jJL().gM(paramf);
        AppMethodBeat.o(329289);
        return null;
      }
    }
    AppMethodBeat.o(329289);
    return paramu;
  }
  
  private static final kotlin.ah a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, g paramg, boolean paramBoolean, b paramb)
  {
    AppMethodBeat.i(329299);
    s.u(paramg, "this$0");
    Object localObject;
    if ((paramb instanceof b.c))
    {
      localObject = ((b.c)paramb).message;
      paramb = (b)localObject;
      if (localObject == null) {
        paramb = "";
      }
      paramf.callback(paramInt, paramg.ZP(s.X("fail ", paramb)));
    }
    for (;;)
    {
      paramf = kotlin.ah.aiuX;
      AppMethodBeat.o(329299);
      return paramf;
      if ((paramb instanceof b.d))
      {
        if (!paramf.isRunning())
        {
          paramf = kotlin.ah.aiuX;
          AppMethodBeat.o(329299);
          return paramf;
        }
        j localj;
        if (paramBoolean)
        {
          localj = new j(paramf.getContext());
          localj.setMessage((CharSequence)paramf.getContext().getString(ba.i.app_brand_choose_media_video_compressing));
          localj.setCanceledOnTouchOutside(false);
          r localr = paramf.getDialogContainer();
          localObject = localj;
          if (localr != null) {
            localr.b((com.tencent.mm.plugin.appbrand.widget.dialog.n)localj);
          }
        }
        for (localObject = localj;; localObject = null)
        {
          com.tencent.mm.cp.g.ha(((b.d)paramb).sfd.get(0)).j(new g..ExternalSyntheticLambda2(paramf, paramBoolean)).g(new g..ExternalSyntheticLambda1(paramf, paramb, paramInt, paramg)).b(new g..ExternalSyntheticLambda3((j)localObject)).a(new g..ExternalSyntheticLambda5((j)localObject));
          break;
        }
      }
      if (s.p(paramb, b.a.sfc)) {
        paramf.callback(paramInt, paramg.ZP("fail user canceled"));
      }
    }
  }
  
  private static final kotlin.ah a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, b paramb, int paramInt, g paramg, com.tencent.mm.vfs.u paramu)
  {
    AppMethodBeat.i(329291);
    s.u(paramg, "this$0");
    if (paramu == null)
    {
      Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "get NULL selected, appId[" + paramf.getAppId() + "], callbackId[" + paramInt + ']');
      com.tencent.mm.vending.g.g.jJL().gM(new Exception("fail:internal error"));
      paramf = kotlin.ah.aiuX;
      AppMethodBeat.o(329291);
      return paramf;
    }
    Object localObject1 = paramf.getFileSystem();
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        s.u(paramg, "this$0");
        Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "on selected NULL fs appId[" + paramf.getAppId() + "], callbackId[" + paramInt + ']');
        paramf.callback(paramInt, paramg.ZP("fail:internal error"));
      }
      paramg = (com.tencent.mm.vfs.u)((b.d)paramb).sfd.get(0);
      Log.i("MicroMsg.AppBrand.JsApiChooseVideoNew", "on selected source[" + com.tencent.mm.vfs.ah.v(paramg.jKT()) + "], selected[" + com.tencent.mm.vfs.ah.v(paramu.jKT()) + "], appId[" + paramf.getAppId() + "], callbackId[" + paramInt + ']');
      s.s(paramb, "result");
      if (((b.d)paramb).from != 2) {
        break label591;
      }
    }
    label398:
    label435:
    label591:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        y.deleteFile(com.tencent.mm.vfs.ah.v(paramg.jKT()));
      }
      if (!s.p(com.tencent.mm.vfs.ah.v(paramu.jKT()), com.tencent.mm.vfs.ah.v(paramg.jKT()))) {
        y.deleteFile(com.tencent.mm.vfs.ah.v(paramu.jKT()));
      }
      paramf = kotlin.ah.aiuX;
      AppMethodBeat.o(329291);
      return paramf;
      Object localObject2 = new k();
      ((w)localObject1).a(paramu, null, false, (k)localObject2);
      localObject1 = (CharSequence)((k)localObject2).value;
      int i;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        i = 1;
        if (i == 0) {
          break label435;
        }
      }
      for (localObject1 = paramg.ZP("fail create temp file failed");; localObject1 = paramg.m("ok", (Map)localObject1))
      {
        paramf.callback(paramInt, (String)localObject1);
        localObject1 = kotlin.ah.aiuX;
        break;
        i = 0;
        break label398;
        localObject1 = new HashMap();
        ((HashMap)localObject1).put("tempFilePath", ((k)localObject2).value);
        localObject2 = v.shR;
        localObject2 = com.tencent.mm.vfs.ah.v(paramu.jKT());
        s.s(localObject2, "selected.absolutePath");
        localObject2 = v.a.abf((String)localObject2);
        if (localObject2 != null)
        {
          ((HashMap)localObject1).put("duration", Long.valueOf(Math.round(((v)localObject2).duration / 1000.0D)));
          ((HashMap)localObject1).put("size", Long.valueOf(((v)localObject2).size));
          ((HashMap)localObject1).put("height", Integer.valueOf(((v)localObject2).height));
          ((HashMap)localObject1).put("width", Integer.valueOf(((v)localObject2).width));
        }
        localObject2 = kotlin.ah.aiuX;
      }
    }
  }
  
  private static final kotlin.ah a(j paramj, kotlin.ah paramah)
  {
    AppMethodBeat.i(329292);
    if (paramj == null)
    {
      AppMethodBeat.o(329292);
      return null;
    }
    paramj.dismiss();
    paramj = kotlin.ah.aiuX;
    AppMethodBeat.o(329292);
    return paramj;
  }
  
  private static final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt, g paramg, Object paramObject)
  {
    AppMethodBeat.i(329301);
    s.u(paramg, "this$0");
    if ((paramObject instanceof Exception))
    {
      String str = ((Exception)paramObject).getMessage();
      paramObject = str;
      if (str == null) {
        paramObject = "";
      }
      if (kotlin.n.n.U(paramObject, "fail", false)) {}
      for (;;)
      {
        paramf.callback(paramInt, paramg.ZP(paramObject));
        AppMethodBeat.o(329301);
        return;
        paramObject = s.X("fail ", paramObject);
      }
    }
    Log.e("MicroMsg.AppBrand.JsApiChooseVideoNew", "choose pipeline onInterrupt(" + paramObject + ')');
    paramf.callback(paramInt, paramg.ZP("fail:internal error"));
    AppMethodBeat.o(329301);
  }
  
  private static final void a(j paramj)
  {
    AppMethodBeat.i(329294);
    s.u(paramj, "$this_apply");
    paramj.dismiss();
    AppMethodBeat.o(329294);
  }
  
  private static final void a(j paramj, Object paramObject)
  {
    AppMethodBeat.i(329296);
    if (paramj != null) {
      MMHandlerThread.postToMainThread(new g..ExternalSyntheticLambda6(paramj));
    }
    AppMethodBeat.o(329296);
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, int paramInt)
  {
    boolean bool1 = true;
    AppMethodBeat.i(50562);
    s.checkNotNull(paramf);
    s.checkNotNull(paramJSONObject);
    if (this.sgI != null)
    {
      localObject = this.sgI;
      s.checkNotNull(localObject);
      ((JsApiChooseVideo)localObject).a(paramf, paramJSONObject, paramInt);
      AppMethodBeat.o(50562);
      return;
    }
    boolean bool2 = paramJSONObject.optBoolean("compressed", true);
    Object localObject = r.d.shH;
    s.u(paramJSONObject, "json");
    localObject = r.b.shB;
    localObject = new StringBuilder();
    String str = r.d.shI.name();
    if (str == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramf;
    }
    str = str.toLowerCase();
    s.s(str, "(this as java.lang.String).toLowerCase()");
    localObject = ((StringBuilder)localObject).append(str).append(", ");
    str = r.d.shJ.name();
    if (str == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramf;
    }
    str = str.toLowerCase();
    s.s(str, "(this as java.lang.String).toLowerCase()");
    int i = r.b.b.a(paramJSONObject, "sourceType", str, (r.b[])r.d.values());
    localObject = r.a.shx;
    s.u(paramJSONObject, "json");
    localObject = r.b.shB;
    localObject = r.a.shz.name();
    if (localObject == null)
    {
      paramf = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(50562);
      throw paramf;
    }
    localObject = ((String)localObject).toLowerCase();
    s.s(localObject, "(this as java.lang.String).toLowerCase()");
    int j = r.b.b.a(paramJSONObject, "camera", (String)localObject, (r.b[])r.a.values());
    int k = r.c.shF.eQp;
    int m = paramJSONObject.optInt("maxDuration", 60);
    if (m <= 0)
    {
      paramf.callback(paramInt, ZP("fail invalid maxDuration"));
      AppMethodBeat.o(50562);
      return;
    }
    if (!bool2) {}
    for (;;)
    {
      new c(paramf, i, j, k, bool1, m).cte().g(new g..ExternalSyntheticLambda0(paramf, paramInt, this, bool2)).a(new g..ExternalSyntheticLambda4(paramf, paramInt, this));
      AppMethodBeat.o(50562);
      return;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.g
 * JD-Core Version:    0.7.0.1
 */
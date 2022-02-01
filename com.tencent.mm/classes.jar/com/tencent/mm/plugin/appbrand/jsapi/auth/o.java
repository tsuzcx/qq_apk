package com.tencent.mm.plugin.appbrand.jsapi.auth;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.luggage.sdk.g.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.permission.a.b.d;
import com.tencent.mm.plugin.appbrand.widget.dialog.d.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.deg;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.eul;
import com.tencent.mm.protocal.protobuf.fur;
import com.tencent.mm.protocal.protobuf.fus;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "invokeContext", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsInvokeContext;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class o
  extends j
  implements f
{
  @Deprecated
  public static final int CTRL_INDEX = 79;
  @Deprecated
  public static final String NAME = "operateWXData";
  private static final o.c rGt;
  
  static
  {
    AppMethodBeat.i(169619);
    rGt = new o.c((byte)0);
    AppMethodBeat.o(169619);
  }
  
  private static final deg a(com.tencent.mm.plugin.appbrand.g paramg, o paramo, String paramString)
  {
    AppMethodBeat.i(326898);
    deg localdeg = new deg();
    localdeg.oOI = paramg.getAppId();
    s.s(paramString, "cgiRequestData");
    localdeg.vgA = paramo.aab(paramString);
    localdeg.aaJu = paramg.getRuntime().qsh.eul;
    localdeg.aaJv = f.c.a(paramo, new glg(), (k)paramg);
    AppMethodBeat.o(326898);
    return localdeg;
  }
  
  private static final deh a(com.tencent.mm.plugin.appbrand.g paramg, o paramo, int paramInt, String paramString, deh paramdeh)
  {
    AppMethodBeat.i(326922);
    s.u(paramg, "$service");
    s.u(paramo, "this$0");
    if (paramdeh == null)
    {
      localObject = null;
      if (localObject != null) {
        break label69;
      }
    }
    label69:
    while (((Integer)localObject).intValue() != -12000)
    {
      AppMethodBeat.o(326922);
      return paramdeh;
      localObject = paramdeh.aaJx;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = Integer.valueOf(((ddh)localObject).hGE);
      break;
    }
    Object localObject = com.tencent.mm.vending.g.g.jJV();
    h.ahAA.bk(new o..ExternalSyntheticLambda5(paramg, (com.tencent.mm.vending.g.b)localObject, paramo, paramInt, paramString, paramdeh));
    AppMethodBeat.o(326922);
    return null;
  }
  
  private static final ah a(com.tencent.mm.plugin.appbrand.g paramg, int paramInt, o paramo, deh paramdeh)
  {
    Object localObject2 = null;
    AppMethodBeat.i(326931);
    s.u(paramg, "$service");
    s.u(paramo, "this$0");
    Object localObject1;
    if (paramdeh == null)
    {
      localObject1 = null;
      if (localObject1 != null) {
        break label89;
      }
      label32:
      if (localObject1 != null) {
        break label237;
      }
      paramg.callback(paramInt, paramo.ZP("fail invalid response"));
    }
    for (;;)
    {
      paramg = ah.aiuX;
      AppMethodBeat.o(326931);
      return paramg;
      localObject1 = paramdeh.aaJx;
      if (localObject1 == null)
      {
        localObject1 = null;
        break;
      }
      localObject1 = Integer.valueOf(((ddh)localObject1).hGE);
      break;
      label89:
      if (((Integer)localObject1).intValue() != 0) {
        break label32;
      }
      paramdeh = paramdeh.vgA;
      if (paramdeh == null) {
        paramdeh = localObject2;
      }
      for (;;)
      {
        if (paramdeh != null) {
          break label235;
        }
        s.u(paramg, "$service");
        s.u(paramo, "this$0");
        Log.e("Luggage.WXA.JsApiOperateWXDataLU", "response ok but data is NULL, appId[" + paramg.getAppId() + "], callbackId[" + paramInt + ']');
        paramg.callback(paramInt, paramo.ZP("fail invalid response"));
        break;
        localObject1 = paramdeh.ZV();
        paramdeh = localObject2;
        if (localObject1 != null)
        {
          paramdeh = new HashMap();
          paramdeh.put("data", localObject1);
          localObject1 = ah.aiuX;
          paramg.callback(paramInt, paramo.m("ok", (Map)paramdeh));
          paramdeh = ah.aiuX;
        }
      }
      label235:
      continue;
      label237:
      paramg.callback(paramInt, paramo.ZP("fail response errcode=" + localObject1 + " errmsg=" + paramdeh.aaJx.errmsg));
    }
  }
  
  private void a(Context paramContext, Bitmap paramBitmap, String paramString1, String paramString2, com.tencent.mm.plugin.appbrand.permission.a.b paramb)
  {
    AppMethodBeat.i(326894);
    f.c.a(this, paramContext, paramBitmap, paramString1, paramString2, paramb);
    AppMethodBeat.o(326894);
  }
  
  private static final void a(final com.tencent.mm.plugin.appbrand.g paramg, final com.tencent.mm.vending.g.b paramb, final o paramo, int paramInt, final String paramString, deh paramdeh)
  {
    int i = 0;
    AppMethodBeat.i(326915);
    s.u(paramg, "$service");
    s.u(paramo, "this$0");
    if (!paramg.isRunning())
    {
      paramb.gM(f.b.rEP);
      AppMethodBeat.o(326915);
      return;
    }
    paramString = new b(paramInt, paramb, paramg, paramo, paramString);
    paramb = f.c.a(paramo, (k)paramg);
    paramString = (b.d)paramString;
    Object localObject = paramg.getRuntime();
    boolean bool;
    if (localObject == null)
    {
      bool = false;
      paramString = new com.tencent.mm.plugin.appbrand.widget.dialog.d(paramb, paramString, bool);
      paramString.setAppBrandName(paramdeh.IKJ);
      paramString.setRequestDesc(paramdeh.aaJO.IGG);
      paramString.setApplyWording(paramdeh.aaJD);
      paramString.setNegativeButtonText(paramdeh.aaJB);
      paramString.setPositiveButtonText(paramdeh.aaJC);
      paramString.setIconUrl(paramdeh.YDL);
      paramString.setFunctionButtonText("");
      paramb = paramg.getWindowAndroid();
      paramInt = i;
      if (paramb != null)
      {
        paramInt = i;
        if (paramb.asu() == true) {
          paramInt = 1;
        }
      }
      if (paramInt != 0) {
        paramString.setPosition(1);
      }
      if (!s.p("scope.userInfo", paramdeh.aaJO.YVX)) {
        break label361;
      }
      paramb = (com.tencent.luggage.sdk.g.a)paramg.T(com.tencent.luggage.sdk.g.a.class);
      if (paramb != null) {
        break label358;
      }
      paramb = (com.tencent.luggage.sdk.g.a)new a(paramdeh);
      label256:
      paramo.a(f.c.a(paramo, (k)paramg), null, paramb.asO(), "scope.userInfo", (com.tencent.mm.plugin.appbrand.permission.a.b)paramString);
      paramb.a(new o..ExternalSyntheticLambda0(paramo, paramg, paramb, paramString));
    }
    for (;;)
    {
      paramg = paramg.getDialogContainer();
      s.checkNotNull(paramg);
      paramg.b((n)paramString);
      AppMethodBeat.o(326915);
      return;
      localObject = ((AppBrandRuntime)localObject).getWindowAndroid();
      if (localObject == null)
      {
        bool = false;
        break;
      }
      bool = ((com.tencent.mm.plugin.appbrand.platform.window.c)localObject).asq();
      break;
      label358:
      break label256;
      label361:
      paramb = paramdeh.aaJO.YVX;
      s.s(paramb, "response.Scope.Scope");
      paramString.setScope(paramb);
    }
  }
  
  private static final void a(e parame, com.tencent.mm.plugin.appbrand.g paramg, int paramInt, o paramo, Object paramObject)
  {
    AppMethodBeat.i(326942);
    s.u(paramg, "$service");
    s.u(paramo, "this$0");
    if (parame != null) {
      parame.onAuthResult();
    }
    StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramg.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
    if (paramObject == null) {}
    for (parame = null;; parame = paramObject.toString())
    {
      Log.i("Luggage.WXA.JsApiOperateWXDataLU", parame + ']');
      if (!(paramObject instanceof f.b)) {
        break;
      }
      AppMethodBeat.o(326942);
      return;
    }
    if ((paramObject instanceof f.a))
    {
      paramg.callback(paramInt, paramo.ZP(s.X("fail ", ((f.a)paramObject).getMessage())));
      AppMethodBeat.o(326942);
      return;
    }
    if ((paramObject instanceof Throwable))
    {
      paramg.callback(paramInt, paramo.ZP(s.X("fail ", ((Throwable)paramObject).getMessage())));
      AppMethodBeat.o(326942);
      return;
    }
    if (paramObject == null)
    {
      paramg.callback(paramInt, paramo.ZP("fail:internal error"));
      AppMethodBeat.o(326942);
      return;
    }
    paramg.callback(paramInt, paramo.ZP(s.X("fail ", paramObject)));
    AppMethodBeat.o(326942);
  }
  
  private static final void a(o paramo, com.tencent.mm.plugin.appbrand.g paramg, com.tencent.luggage.sdk.g.a parama, com.tencent.mm.plugin.appbrand.widget.dialog.d paramd, Bitmap paramBitmap)
  {
    AppMethodBeat.i(326904);
    s.u(paramo, "this$0");
    s.u(paramg, "$service");
    s.u(parama, "$provider");
    s.u(paramd, "$dialog");
    paramo.a(f.c.a(paramo, (k)paramg), paramBitmap, parama.asO(), "scope.userInfo", (com.tencent.mm.plugin.appbrand.permission.a.b)paramd);
    AppMethodBeat.o(326904);
  }
  
  private com.tencent.mm.bx.b aab(String paramString)
  {
    AppMethodBeat.i(169620);
    s.u(this, "this");
    s.u(paramString, "receiver");
    paramString = paramString.getBytes(kotlin.n.d.UTF_8);
    s.s(paramString, "(this as java.lang.String).getBytes(charset)");
    paramString = new com.tencent.mm.bx.b(paramString);
    AppMethodBeat.o(169620);
    return paramString;
  }
  
  private static final void b(e parame, Object paramObject)
  {
    AppMethodBeat.i(326937);
    if (parame != null) {
      parame.onAuthResult();
    }
    AppMethodBeat.o(326937);
  }
  
  public final <R extends esc> com.tencent.mm.vending.g.c<R> a(k paramk, String paramString, com.tencent.mm.bx.a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169622);
    paramk = f.c.a(this, paramk, paramString, parama, paramClass);
    AppMethodBeat.o(169622);
    return paramk;
  }
  
  protected final void a(dh<com.tencent.mm.plugin.appbrand.g> paramdh, e parame)
  {
    AppMethodBeat.i(326984);
    s.u(paramdh, "invokeContext");
    com.tencent.mm.plugin.appbrand.g localg = (com.tencent.mm.plugin.appbrand.g)paramdh.rBv;
    JSONObject localJSONObject = paramdh.rmi;
    int i = paramdh.ror;
    paramdh = localJSONObject.optString("data", null);
    if (paramdh == null)
    {
      localg.callback(i, ((o)this).ZP("fail:invalid data"));
      AppMethodBeat.o(326984);
      return;
    }
    a((k)localg, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bx.a)a(localg, this, paramdh), deh.class).d(new o..ExternalSyntheticLambda2(localg, this, i, paramdh)).f(new o..ExternalSyntheticLambda1(localg, i, this)).a(new o..ExternalSyntheticLambda4(parame)).a((com.tencent.mm.vending.h.d)com.tencent.mm.vending.h.d.UI, new o..ExternalSyntheticLambda3(parame, localg, i, this));
    AppMethodBeat.o(326984);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$2$1$1$provider$1", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider;", "getUserAvatarHDHeadImage", "", "callback", "Lcom/tencent/luggage/sdk/userinfo/IWechatUserInfoProvider$OnGetImagePathCallback;", "getUserDisplayNickName", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements com.tencent.luggage.sdk.g.a
  {
    a(deh paramdeh) {}
    
    public final void a(a.a parama)
    {
      AppMethodBeat.i(326762);
      s.u(parama, "callback");
      Object localObject = this.rGu.aaJR;
      if (localObject == null)
      {
        localObject = null;
        CharSequence localCharSequence = (CharSequence)localObject;
        if ((localCharSequence != null) && (localCharSequence.length() != 0)) {
          break label117;
        }
      }
      label117:
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label122;
        }
        com.tencent.mm.modelappbrand.a.b.bEY().a((b.k)new a(parama), (String)localObject, null);
        AppMethodBeat.o(326762);
        return;
        localObject = ((fur)localObject).abaX;
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = (fus)((LinkedList)localObject).peekFirst();
        if (localObject == null)
        {
          localObject = null;
          break;
        }
        localObject = ((fus)localObject).rHi;
        break;
      }
      label122:
      parama.onGetImagePath(null);
      AppMethodBeat.o(326762);
    }
    
    public final String asO()
    {
      AppMethodBeat.i(326766);
      Object localObject = this.rGu.aaJR;
      if (localObject == null)
      {
        AppMethodBeat.o(326766);
        return null;
      }
      localObject = ((fur)localObject).abaX;
      if (localObject == null)
      {
        AppMethodBeat.o(326766);
        return null;
      }
      localObject = (fus)((LinkedList)localObject).peekFirst();
      if (localObject == null)
      {
        AppMethodBeat.o(326766);
        return null;
      }
      localObject = ((fus)localObject).nickname;
      AppMethodBeat.o(326766);
      return localObject;
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$2$1$1$provider$1$getUserAvatarHDHeadImage$1", "Lcom/tencent/mm/modelappbrand/image/AppBrandSimpleImageLoader$ILoadTarget;", "beforeLoadBitmap", "", "key", "", "onBitmapLoaded", "bitmap", "Landroid/graphics/Bitmap;", "onLoadFailed", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements b.k
    {
      a(a.a parama) {}
      
      public final void bFg() {}
      
      public final void bFh() {}
      
      public final String key()
      {
        return "JsApiOperateWXData";
      }
      
      public final void onBitmapLoaded(Bitmap paramBitmap)
      {
        AppMethodBeat.i(326789);
        a.a locala = this.rGv;
        if (locala != null) {
          locala.onGetImagePath(paramBitmap);
        }
        AppMethodBeat.o(326789);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiOperateWXDataLU$AuthInvoke$2$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeRequestDialog$Listener;", "onMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "avatarId", "userAgreementChecked", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements d.b
  {
    b(int paramInt, com.tencent.mm.vending.g.b paramb, com.tencent.mm.plugin.appbrand.g paramg, o paramo, String paramString) {}
    
    public final void a(int paramInt1, ArrayList<String> paramArrayList, int paramInt2, boolean paramBoolean)
    {
      AppMethodBeat.i(326769);
      s.u(paramArrayList, "resultData");
      Log.i("Luggage.WXA.JsApiOperateWXDataLU", "dialog onMsg, resultCode[" + paramInt1 + "], callbackId[" + this.rxe + ']');
      switch (paramInt1)
      {
      default: 
        paramb.gM(new f.a("fail:auth canceled"));
        AppMethodBeat.o(326769);
        return;
      case 1: 
        localObject1 = o.b(paramg, paramo, paramString);
        localObject2 = paramo;
        com.tencent.mm.vending.g.b localb = paramb;
        com.tencent.mm.plugin.appbrand.g localg = paramg;
        ((deg)localObject1).aaJt = 1;
        ((deg)localObject1).aaJM = ((String)p.oL((List)paramArrayList));
        s.s(localb, "m");
        f.c.a((f)localObject2, localb, ((o)localObject2).a((k)localg, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bx.a)localObject1, deh.class));
        AppMethodBeat.o(326769);
        return;
      }
      paramb.gM(new f.a("fail:auth denied"));
      paramArrayList = o.b(paramg, paramo, paramString);
      Object localObject1 = paramo;
      Object localObject2 = paramg;
      paramArrayList.aaJt = 2;
      ((o)localObject1).a((k)localObject2, "/cgi-bin/mmbiz-bin/js-operatewxdata", (com.tencent.mm.bx.a)paramArrayList, deh.class);
      AppMethodBeat.o(326769);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.o
 * JD-Core Version:    0.7.0.1
 */
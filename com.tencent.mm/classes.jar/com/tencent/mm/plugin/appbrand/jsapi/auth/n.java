package com.tencent.mm.plugin.appbrand.jsapi.auth;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.jsapi.dh;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.c.a;
import com.tencent.mm.plugin.appbrand.widget.dialog.r;
import com.tencent.mm.protocal.protobuf.ddh;
import com.tencent.mm.protocal.protobuf.dec;
import com.tencent.mm.protocal.protobuf.ded;
import com.tencent.mm.protocal.protobuf.dee;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.glg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.d;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.u;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/BaseAuthJsApi;", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthHelper;", "()V", "AuthInvoke", "", "invokeContext", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsInvokeContext;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "listener", "Lcom/tencent/mm/plugin/appbrand/jsapi/auth/AuthFinishListener;", "invoke", "cgiUrlStripForApiCallback", "", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends j
  implements f
{
  @Deprecated
  public static final int CTRL_INDEX = 52;
  @Deprecated
  public static final String NAME = "login";
  private static final n.b rFO;
  
  static
  {
    AppMethodBeat.i(169600);
    rFO = new n.b((byte)0);
    AppMethodBeat.o(169600);
  }
  
  private static final ah a(com.tencent.mm.plugin.appbrand.g paramg, int paramInt, n paramn, u paramu)
  {
    AppMethodBeat.i(326903);
    s.u(paramg, "$service");
    s.u(paramn, "this$0");
    ddh localddh = (ddh)paramu.bsC;
    Object localObject = (String)paramu.bsD;
    String str = (String)paramu.aiuN;
    if (localddh == null)
    {
      paramu = null;
      if (paramu != null) {
        break label116;
      }
      label55:
      if (paramu != null) {
        break label163;
      }
      paramg.callback(paramInt, paramn.ZP("fail invalid " + aaa(str) + " response"));
    }
    for (;;)
    {
      paramg = ah.aiuX;
      AppMethodBeat.o(326903);
      return paramg;
      paramu = Integer.valueOf(localddh.hGE);
      break;
      label116:
      if (paramu.intValue() != 0) {
        break label55;
      }
      paramu = new HashMap();
      paramu.put("code", localObject);
      localObject = ah.aiuX;
      paramg.callback(paramInt, paramn.m("ok", (Map)paramu));
      continue;
      label163:
      paramg.callback(paramInt, paramn.ZP("fail " + aaa(str) + " response errcode=" + paramu + " errmsg=" + localddh.errmsg));
    }
  }
  
  private static final u a(com.tencent.mm.plugin.appbrand.g paramg, int paramInt, n paramn, def paramdef)
  {
    AppMethodBeat.i(326896);
    s.u(paramg, "$service");
    s.u(paramn, "this$0");
    Object localObject;
    if (paramdef == null)
    {
      localObject = null;
      if (localObject != null) {
        break label90;
      }
      label29:
      if (paramdef != null) {
        break label187;
      }
      paramg = null;
      label35:
      if (paramdef != null) {
        break label195;
      }
    }
    label162:
    label187:
    label195:
    for (paramn = null;; paramn = paramdef.aaJI)
    {
      paramg = new u(paramg, paramn, "/cgi-bin/mmbiz-bin/js-login");
      AppMethodBeat.o(326896);
      return paramg;
      localObject = paramdef.aaJx;
      if (localObject == null)
      {
        localObject = null;
        break;
      }
      localObject = Integer.valueOf(((ddh)localObject).hGE);
      break;
      label90:
      if (((Integer)localObject).intValue() != -12000) {
        break label29;
      }
      localObject = com.tencent.mm.vending.g.g.jJV();
      Collection localCollection = (Collection)paramdef.aans;
      int i;
      if ((localCollection == null) || (localCollection.isEmpty()))
      {
        i = 1;
        if (i == 0) {
          break label162;
        }
        paramg.callback(paramInt, paramn.ZP("fail:internal error scope empty"));
      }
      for (;;)
      {
        AppMethodBeat.o(326896);
        return null;
        i = 0;
        break;
        h.ahAA.bk(new n..ExternalSyntheticLambda4(paramg, (b)localObject, paramn, paramdef, paramInt));
      }
      paramg = paramdef.aaJx;
      break label35;
    }
  }
  
  private static final void a(final com.tencent.mm.plugin.appbrand.g paramg, final b paramb, final n paramn, def paramdef, int paramInt)
  {
    AppMethodBeat.i(326892);
    s.u(paramg, "$service");
    s.u(paramn, "this$0");
    if (!paramg.isRunning())
    {
      paramb.gM(f.b.rEP);
      AppMethodBeat.o(326892);
      return;
    }
    paramb = new a(paramInt, paramn, paramb, paramg);
    r localr = paramg.getDialogContainer();
    s.checkNotNull(localr);
    localr.b((com.tencent.mm.plugin.appbrand.widget.dialog.n)new com.tencent.mm.plugin.appbrand.widget.dialog.c(f.c.a(paramn, (k)paramg), (List)j.C(paramdef.aans), paramdef.IKJ, paramdef.YDL, (c.a)paramb));
    AppMethodBeat.o(326892);
  }
  
  private static final void a(e parame, com.tencent.mm.plugin.appbrand.g paramg, int paramInt, n paramn, Object paramObject)
  {
    AppMethodBeat.i(326917);
    s.u(paramg, "$service");
    s.u(paramn, "this$0");
    if (parame != null) {
      parame.onAuthResult();
    }
    StringBuilder localStringBuilder = new StringBuilder("onInterrupt, appId[").append(paramg.getAppId()).append("], callbackId[").append(paramInt).append("], e[");
    if (paramObject == null) {}
    for (parame = null;; parame = paramObject.toString())
    {
      Log.i("Luggage.WXA.JsApiLoginLU", parame + ']');
      if (!(paramObject instanceof f.b)) {
        break;
      }
      AppMethodBeat.o(326917);
      return;
    }
    if ((paramObject instanceof f.a))
    {
      paramg.callback(paramInt, paramn.ZP(s.X("fail ", ((f.a)paramObject).getMessage())));
      AppMethodBeat.o(326917);
      return;
    }
    if ((paramObject instanceof Throwable))
    {
      paramg.callback(paramInt, paramn.ZP(s.X("fail ", ((Throwable)paramObject).getMessage())));
      AppMethodBeat.o(326917);
      return;
    }
    if (paramObject == null)
    {
      paramg.callback(paramInt, paramn.ZP("fail:internal error"));
      AppMethodBeat.o(326917);
      return;
    }
    paramg.callback(paramInt, paramn.ZP(s.X("fail ", paramObject)));
    AppMethodBeat.o(326917);
  }
  
  private static final void a(e parame, Object paramObject)
  {
    AppMethodBeat.i(326909);
    if (parame != null) {
      parame.onAuthResult();
    }
    AppMethodBeat.o(326909);
  }
  
  private static String aaa(String paramString)
  {
    AppMethodBeat.i(326888);
    if (s.p(paramString, "/cgi-bin/mmbiz-bin/js-login"))
    {
      AppMethodBeat.o(326888);
      return "js-login";
    }
    if (s.p(paramString, "/cgi-bin/mmbiz-bin/js-login-confirm"))
    {
      AppMethodBeat.o(326888);
      return "js-login-confirm";
    }
    AppMethodBeat.o(326888);
    return paramString;
  }
  
  public final <R extends esc> com.tencent.mm.vending.g.c<R> a(k paramk, String paramString, a parama, Class<R> paramClass)
  {
    AppMethodBeat.i(169601);
    paramk = f.c.a(this, paramk, paramString, parama, paramClass);
    AppMethodBeat.o(169601);
    return paramk;
  }
  
  public final void a(dh<com.tencent.mm.plugin.appbrand.g> paramdh)
  {
    AppMethodBeat.i(326950);
    s.u(paramdh, "invokeContext");
    JSONObject localJSONObject = paramdh.rmi;
    try
    {
      if (!localJSONObject.has("requestInQueue")) {
        localJSONObject.put("requestInQueue", false);
      }
      super.a(paramdh);
      AppMethodBeat.o(326950);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        Log.e("Luggage.WXA.JsApiLoginLU", s.X("invoke put KEY_IN_QUEUE e=", localJSONException.getMessage()));
      }
    }
  }
  
  protected final void a(dh<com.tencent.mm.plugin.appbrand.g> paramdh, e parame)
  {
    AppMethodBeat.i(326957);
    s.u(paramdh, "invokeContext");
    com.tencent.mm.plugin.appbrand.g localg = (com.tencent.mm.plugin.appbrand.g)paramdh.rBv;
    int i = paramdh.ror;
    paramdh = (k)localg;
    dee localdee = new dee();
    localdee.oOI = localg.getAppId();
    localdee.aaJu = localg.getRuntime().qsh.eul;
    localdee.aaJv = f.c.a(this, new glg(), (k)localg);
    ah localah = ah.aiuX;
    a(paramdh, "/cgi-bin/mmbiz-bin/js-login", (a)localdee, def.class).d(new n..ExternalSyntheticLambda0(localg, i, this)).f(new n..ExternalSyntheticLambda1(localg, i, this)).a(new n..ExternalSyntheticLambda3(parame)).a(new n..ExternalSyntheticLambda2(parame, localg, i, this));
    AppMethodBeat.o(326957);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/auth/JsApiLoginLU$AuthInvoke$2$1$promptListener$1", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/AppBrandAuthorizeDialog$Listener;", "onRecvMsg", "", "resultCode", "", "resultData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c.a
  {
    a(int paramInt, n paramn, b paramb, com.tencent.mm.plugin.appbrand.g paramg) {}
    
    private static final dec a(com.tencent.mm.plugin.appbrand.g paramg, ArrayList<String> paramArrayList, int paramInt, n paramn)
    {
      AppMethodBeat.i(326863);
      dec localdec = new dec();
      localdec.oOI = paramg.getAppId();
      LinkedList localLinkedList = localdec.aaJs;
      paramArrayList = (List)paramArrayList;
      if (paramArrayList == null) {
        paramArrayList = (List)ab.aivy;
      }
      for (;;)
      {
        localLinkedList.addAll((Collection)paramArrayList);
        localdec.aaJt = paramInt;
        localdec.aaJu = paramg.getRuntime().qsh.eul;
        localdec.aaJv = f.c.a(paramn, new glg(), (k)paramg);
        AppMethodBeat.o(326863);
        return localdec;
      }
    }
    
    private static final u a(ded paramded)
    {
      Object localObject2 = null;
      AppMethodBeat.i(326867);
      Object localObject1;
      if (paramded == null)
      {
        localObject1 = null;
        if (paramded != null) {
          break label46;
        }
      }
      label46:
      for (paramded = localObject2;; paramded = paramded.aaJI)
      {
        paramded = new u(localObject1, paramded, "/cgi-bin/mmbiz-bin/js-login-confirm");
        AppMethodBeat.o(326867);
        return paramded;
        localObject1 = paramded.aaJx;
        break;
      }
    }
    
    public final void a(int paramInt, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(169591);
      Log.i("Luggage.WXA.JsApiLoginLU", "dialog onRecvMsg, resultCode[" + paramInt + "], callbackId[" + this.rxe + ']');
      switch (paramInt)
      {
      default: 
        paramb.gM(new f.a("fail:auth canceled"));
        AppMethodBeat.o(169591);
        return;
      case 1: 
        n localn = paramn;
        b localb = paramb;
        s.s(localb, "m");
        paramArrayList = paramn.a((k)paramg, "/cgi-bin/mmbiz-bin/js-login-confirm", (a)a(paramg, paramArrayList, paramInt, paramn), ded.class).d(n.a..ExternalSyntheticLambda0.INSTANCE);
        s.s(paramArrayList, "service.runCgi(CONFIRM_U…                        }");
        f.c.a(localn, localb, paramArrayList);
        AppMethodBeat.o(169591);
        return;
      }
      paramb.gM(new f.a("fail:auth denied"));
      paramn.a((k)paramg, "/cgi-bin/mmbiz-bin/js-login-confirm", (a)a(paramg, paramArrayList, paramInt, paramn), ded.class);
      AppMethodBeat.o(169591);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.auth.n
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.g;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class at
  extends c<g>
{
  @Deprecated
  public static final int CTRL_INDEX;
  @Deprecated
  public static final String NAME;
  @Deprecated
  public static final String rxA;
  private static final a rxz;
  
  static
  {
    AppMethodBeat.i(183052);
    rxz = new a((byte)0);
    NAME = "batchGetContact";
    CTRL_INDEX = 410;
    rxA = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    AppMethodBeat.o(183052);
  }
  
  protected final boolean cpE()
  {
    return true;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Constants;", "", "()V", "BATCH_GET_CGI_URI", "", "CTRL_INDEX", "", "NAME", "TAG", "toJsonContactList", "Lorg/json/JSONArray;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class b
    extends bc
  {
    public static final int CTRL_INDEX;
    public static final String NAME;
    public static final a rxB;
    
    static
    {
      AppMethodBeat.i(183038);
      rxB = new a((byte)0);
      NAME = "onContactUpdate";
      CTRL_INDEX = -2;
      AppMethodBeat.o(183038);
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "eventCallbackId", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static void a(g paramg, List<WxaAttributes> paramList, String paramString)
      {
        AppMethodBeat.i(183037);
        if ((paramg != null) && (paramg.isRunning() == true)) {}
        for (int i = 1; i == 0; i = 0)
        {
          AppMethodBeat.o(183037);
          return;
        }
        Object localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(183037);
          return;
        }
        localObject = new at.b();
        if (paramList != null)
        {
          at.cpU();
          ((at.b)localObject).w("contactList", at.a.dg(paramList));
        }
        ((at.b)localObject).w("callbackId", paramString);
        ((at.b)localObject).i((f)paramg).cpV();
        AppMethodBeat.o(183037);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements b<List<? extends WxaAttributes>, ah>
  {
    d(int paramInt, at.h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements b<List<? extends WxaAttributes>, ah>
  {
    e(int paramInt, at.h paramh, WeakReference<g> paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(int paramInt, WeakReference<g> paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "errMsg", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements b<String, ah>
  {
    g(int paramInt, WeakReference<g> paramWeakReference, at paramat)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroidx/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements androidx.a.a.c.a<List<? extends WxaAttributes>, Boolean>
  {
    private boolean rxO;
    
    h(WeakReference<g> paramWeakReference, int paramInt, at paramat, String paramString) {}
    
    public final Boolean dh(List<WxaAttributes> paramList)
    {
      AppMethodBeat.i(183048);
      s.u(paramList, "input");
      if (!this.rxO)
      {
        try
        {
          g localg = (g)this.rxL.get();
          if (localg != null)
          {
            int i = this.rxe;
            at localat = this.rxN;
            JSONObject localJSONObject = new JSONObject();
            String str = this.rxM;
            at.cpU();
            localJSONObject.put("contactList", at.a.dg(paramList));
            localJSONObject.put("callbackId", str);
            paramList = ah.aiuX;
            localg.callback(i, localat.h("ok", localJSONObject));
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            paramList = (g)this.rxL.get();
            if (paramList != null) {
              paramList.callback(this.rxe, this.rxN.ZP("fail: toJson fail"));
            }
          }
        }
        this.rxO = true;
      }
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(183048);
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.at
 * JD-Core Version:    0.7.0.1
 */
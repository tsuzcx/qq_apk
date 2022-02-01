package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.protocal.protobuf.fnx;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import org.json.JSONException;
import org.json.JSONObject;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"})
public final class aq
  extends c<g>
{
  public static final int CTRL_INDEX = 410;
  public static final String NAME = "batchGetContact";
  public static final String otS = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
  @Deprecated
  public static final a otT;
  
  static
  {
    AppMethodBeat.i(183052);
    otT = new a((byte)0);
    NAME = "batchGetContact";
    CTRL_INDEX = 410;
    otS = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    AppMethodBeat.o(183052);
  }
  
  protected final boolean bPy()
  {
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Constants;", "", "()V", "BATCH_GET_CGI_URI", "", "CTRL_INDEX", "", "NAME", "TAG", "toJsonContactList", "Lorg/json/JSONArray;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "luggage-wechat-full-sdk_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
  static final class b
    extends az
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onContactUpdate";
    public static final a otU;
    
    static
    {
      AppMethodBeat.i(183038);
      otU = new a((byte)0);
      NAME = "onContactUpdate";
      CTRL_INDEX = -2;
      AppMethodBeat.o(183038);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "eventCallbackId", "luggage-wechat-full-sdk_release"})
    public static final class a
    {
      public static void a(g paramg, List<WxaAttributes> paramList, String paramString)
      {
        AppMethodBeat.i(183037);
        if (paramg == null)
        {
          AppMethodBeat.o(183037);
          return;
        }
        Object localObject = (CharSequence)paramString;
        if ((localObject == null) || (((CharSequence)localObject).length() == 0)) {}
        for (int i = 1; i != 0; i = 0)
        {
          AppMethodBeat.o(183037);
          return;
        }
        localObject = new aq.b();
        if (paramList != null)
        {
          aq.bPN();
          ((aq.b)localObject).o("contactList", aq.a.bv(paramList));
        }
        ((aq.b)localObject).o("callbackId", paramString);
        ((aq.b)localObject).j((e)paramg).bPO();
        AppMethodBeat.o(183037);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"})
  static final class c
  {
    final String nIo;
    final long otV;
    final List<String> otW;
    final com.tencent.mm.plugin.appbrand.networking.c otX;
    final int tag;
    
    public c(String paramString, int paramInt, List<String> paramList, com.tencent.mm.plugin.appbrand.networking.c paramc)
    {
      AppMethodBeat.i(183043);
      this.nIo = paramString;
      this.tag = paramInt;
      this.otW = paramList;
      this.otX = paramc;
      this.otV = TimeUnit.MINUTES.toSeconds(5L);
      AppMethodBeat.o(183043);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements com.tencent.e.i.h
    {
      a(kotlin.g.a.b paramb1, kotlin.g.a.b paramb2, kotlin.g.a.b paramb3, kotlin.g.a.a parama) {}
      
      public final String getKey()
      {
        return "Luggage.FULL.JsApiBatchGetContact.Loader";
      }
      
      public final void run()
      {
        AppMethodBeat.i(183040);
        Object localObject4 = new LinkedList();
        Object localObject3 = new LinkedList();
        for (;;)
        {
          Object localObject5;
          Object localObject6;
          Object localObject7;
          int i;
          try
          {
            localObject5 = new HashSet((Collection)this.otY.otW);
            ab.bLM();
            localObject1 = ab.a(this.otY.otW, new String[] { "appId", "appInfo", "syncVersion", "syncTimeSecond" });
            if (localObject1 == null) {
              break label343;
            }
            localObject6 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject6).hasNext()) {
              break label361;
            }
            localObject1 = (WxaAttributes)((Iterator)localObject6).next();
            localObject7 = (CharSequence)((WxaAttributes)localObject1).field_appInfo;
            if (localObject7 == null) {
              break label637;
            }
            if (((CharSequence)localObject7).length() != 0) {
              break label294;
            }
          }
          catch (JSONException localJSONException)
          {
            Object localObject1;
            aq.bPN();
            Log.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.otY.hashCode() + ").run(), make callback array e=" + localJSONException);
            this.otZ.invoke("get contact json error");
            AppMethodBeat.o(183040);
            return;
          }
          if (i == 0)
          {
            ((HashSet)localObject5).remove(((WxaAttributes)localObject1).field_appId);
            ((LinkedList)localObject4).add(localObject1);
            if (Util.secondsToNow(((WxaAttributes)localObject1).field_syncTimeSecond) > this.otY.otV)
            {
              localObject7 = new fnx();
              ((fnx)localObject7).appid = ((WxaAttributes)localObject1).field_appId;
              localObject1 = ((WxaAttributes)localObject1).field_syncVersion;
              label294:
              Object localObject2;
              if (localObject1 != null)
              {
                Charset localCharset = kotlin.n.d.UTF_8;
                if (localObject1 == null)
                {
                  localObject1 = new t("null cannot be cast to non-null type java.lang.String");
                  AppMethodBeat.o(183040);
                  throw ((Throwable)localObject1);
                  i = 0;
                  continue;
                }
                localObject2 = localJSONException.getBytes(localCharset);
                p.j(localObject2, "(this as java.lang.String).getBytes(charset)");
                if (localObject2 != null) {}
              }
              else
              {
                localObject2 = new byte[0];
              }
              for (;;)
              {
                ((fnx)localObject7).RTT = new com.tencent.mm.cd.b((byte[])localObject2);
                ((LinkedList)localObject3).add(localObject7);
                break;
                label343:
                this.otZ.invoke("get contact fail");
                AppMethodBeat.o(183040);
                return;
                label361:
                localObject2 = ((Iterable)localObject5).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject5 = (String)((Iterator)localObject2).next();
                  localObject6 = new fnx();
                  ((fnx)localObject6).appid = ((String)localObject5);
                  ((fnx)localObject6).RTT = new com.tencent.mm.cd.b(new byte[0]);
                  ((LinkedList)localObject3).add(localObject6);
                }
                if (((LinkedList)localObject4).size() == this.otY.otW.size()) {
                  this.oua.invoke(localObject4);
                }
                if (((Collection)localObject3).isEmpty()) {}
                for (i = 1; i == 0; i = 0)
                {
                  aq.bPN();
                  Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.otY.tag + ").waitForBatchCgiUpdate requestList.size:" + ((LinkedList)localObject3).size());
                  localObject2 = this.otY;
                  localObject3 = (List)localObject3;
                  localObject4 = (kotlin.g.a.b)new a(this);
                  localObject5 = this.otZ;
                  localObject6 = new lb();
                  ((lb)localObject6).RPu.addAll((Collection)localObject3);
                  ((lb)localObject6).CPw = 100;
                  com.tencent.mm.vending.h.d.LOGIC.arrange((Runnable)new aq.c.b((aq.c)localObject2, (lb)localObject6, (kotlin.g.a.b)localObject4, (kotlin.g.a.b)localObject5));
                  AppMethodBeat.o(183040);
                  return;
                }
                this.ouc.invoke();
                AppMethodBeat.o(183040);
                return;
              }
              label637:
              i = 1;
            }
          }
        }
      }
      
      @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"})
      static final class a
        extends q
        implements kotlin.g.a.b<lc, x>
      {
        a(aq.c.a parama)
        {
          super();
        }
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(aq.c paramc, lb paramlb, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(183042);
        Object localObject = this.otY.otX;
        aq.bPN();
        com.tencent.mm.vending.g.c localc = ((com.tencent.mm.plugin.appbrand.networking.c)localObject).a(aq.otS, (com.tencent.mm.cd.a)this.oue, lc.class);
        localObject = this.ouf;
        if (localObject != null) {
          localObject = new ar((kotlin.g.a.b)localObject);
        }
        for (;;)
        {
          localc.a((d.b)localObject).a((d.a)new d.a()
          {
            public final void cm(Object paramAnonymousObject)
            {
              AppMethodBeat.i(183041);
              if (paramAnonymousObject == null) {
                paramAnonymousObject = null;
              }
              for (;;)
              {
                this.oug.otZ.invoke(paramAnonymousObject);
                AppMethodBeat.o(183041);
                return;
                if ((paramAnonymousObject instanceof Throwable)) {
                  paramAnonymousObject = ((Throwable)paramAnonymousObject).getMessage();
                } else {
                  paramAnonymousObject = paramAnonymousObject.toString();
                }
              }
            }
          });
          AppMethodBeat.o(183042);
          return;
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<List<? extends WxaAttributes>, x>
  {
    d(int paramInt, aq.h paramh)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<List<? extends WxaAttributes>, x>
  {
    e(int paramInt, aq.h paramh, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(int paramInt, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errMsg", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<String, x>
  {
    g(aq paramaq, int paramInt, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroidx/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"})
  public static final class h
    implements androidx.a.a.c.a<List<? extends WxaAttributes>, Boolean>
  {
    private boolean oul;
    
    h(WeakReference paramWeakReference, int paramInt, String paramString) {}
    
    public final Boolean bw(List<WxaAttributes> paramList)
    {
      AppMethodBeat.i(183048);
      p.k(paramList, "input");
      if (!this.oul)
      {
        try
        {
          g localg = (g)this.oui.get();
          if (localg != null)
          {
            int i = this.otk;
            aq localaq = this.ouk;
            JSONObject localJSONObject = new JSONObject();
            aq.bPN();
            localJSONObject.put("contactList", aq.a.bv(paramList));
            localJSONObject.put("callbackId", this.ouj);
            localg.j(i, localaq.h("ok", localJSONObject));
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            paramList = (g)this.oui.get();
            if (paramList != null) {
              paramList.j(this.otk, this.ouk.agS("fail: toJson fail"));
            }
          }
        }
        this.oul = true;
      }
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(183048);
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aq
 * JD-Core Version:    0.7.0.1
 */
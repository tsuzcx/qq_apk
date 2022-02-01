package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ab;
import com.tencent.mm.protocal.protobuf.fcw;
import com.tencent.mm.protocal.protobuf.ll;
import com.tencent.mm.protocal.protobuf.lm;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"})
public final class at
  extends d<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 410;
  public static final String NAME = "batchGetContact";
  public static final String lyN = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
  @Deprecated
  public static final a lyO;
  
  static
  {
    AppMethodBeat.i(183052);
    lyO = new a((byte)0);
    NAME = "batchGetContact";
    CTRL_INDEX = 410;
    lyN = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    AppMethodBeat.o(183052);
  }
  
  protected final boolean bEa()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Constants;", "", "()V", "BATCH_GET_CGI_URI", "", "CTRL_INDEX", "", "NAME", "TAG", "toJsonContactList", "Lorg/json/JSONArray;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "luggage-wechat-full-sdk_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
  static final class b
    extends bc
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onContactUpdate";
    public static final a lyP;
    
    static
    {
      AppMethodBeat.i(183038);
      lyP = new a((byte)0);
      NAME = "onContactUpdate";
      CTRL_INDEX = -2;
      AppMethodBeat.o(183038);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "eventCallbackId", "luggage-wechat-full-sdk_release"})
    public static final class a
    {
      public static void a(com.tencent.mm.plugin.appbrand.d paramd, List<WxaAttributes> paramList, String paramString)
      {
        AppMethodBeat.i(183037);
        if (paramd == null)
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
        localObject = new at.b();
        if (paramList != null)
        {
          at.bEn();
          ((at.b)localObject).p("contactList", at.a.bx(paramList));
        }
        ((at.b)localObject).p("callbackId", paramString);
        paramd.a((bc)localObject);
        AppMethodBeat.o(183037);
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"})
  static final class c
  {
    final String kOn;
    final long lyQ;
    final List<String> lyR;
    final com.tencent.mm.plugin.appbrand.networking.c lyS;
    final int tag;
    
    public c(String paramString, int paramInt, List<String> paramList, com.tencent.mm.plugin.appbrand.networking.c paramc)
    {
      AppMethodBeat.i(183043);
      this.kOn = paramString;
      this.tag = paramInt;
      this.lyR = paramList;
      this.lyS = paramc;
      this.lyQ = TimeUnit.MINUTES.toSeconds(5L);
      AppMethodBeat.o(183043);
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements com.tencent.f.i.h
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
            localObject5 = new HashSet((Collection)this.lyT.lyR);
            ab.bAu();
            localObject1 = ab.a(this.lyT.lyR, new String[] { "appId", "appInfo", "syncVersion", "syncTimeSecond" });
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
            at.bEn();
            Log.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyT.hashCode() + ").run(), make callback array e=" + localJSONException);
            this.lyU.invoke("get contact json error");
            AppMethodBeat.o(183040);
            return;
          }
          if (i == 0)
          {
            ((HashSet)localObject5).remove(((WxaAttributes)localObject1).field_appId);
            ((LinkedList)localObject4).add(localObject1);
            if (Util.secondsToNow(((WxaAttributes)localObject1).field_syncTimeSecond) > this.lyT.lyQ)
            {
              localObject7 = new fcw();
              ((fcw)localObject7).dNI = ((WxaAttributes)localObject1).field_appId;
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
                p.g(localObject2, "(this as java.lang.String).getBytes(charset)");
                if (localObject2 != null) {}
              }
              else
              {
                localObject2 = new byte[0];
              }
              for (;;)
              {
                ((fcw)localObject7).KSW = new com.tencent.mm.bw.b((byte[])localObject2);
                ((LinkedList)localObject3).add(localObject7);
                break;
                label343:
                this.lyU.invoke("get contact fail");
                AppMethodBeat.o(183040);
                return;
                label361:
                localObject2 = ((Iterable)localObject5).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject5 = (String)((Iterator)localObject2).next();
                  localObject6 = new fcw();
                  ((fcw)localObject6).dNI = ((String)localObject5);
                  ((fcw)localObject6).KSW = new com.tencent.mm.bw.b(new byte[0]);
                  ((LinkedList)localObject3).add(localObject6);
                }
                if (((LinkedList)localObject4).size() == this.lyT.lyR.size()) {
                  this.lyV.invoke(localObject4);
                }
                if (((Collection)localObject3).isEmpty()) {}
                for (i = 1; i == 0; i = 0)
                {
                  at.bEn();
                  Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.lyT.tag + ").waitForBatchCgiUpdate requestList.size:" + ((LinkedList)localObject3).size());
                  localObject2 = this.lyT;
                  localObject3 = (List)localObject3;
                  localObject4 = (kotlin.g.a.b)new a(this);
                  localObject5 = this.lyU;
                  localObject6 = new ll();
                  ((ll)localObject6).KOw.addAll((Collection)localObject3);
                  ((ll)localObject6).Scene = 100;
                  com.tencent.mm.vending.h.d.LOGIC.arrange((Runnable)new at.c.b((at.c)localObject2, (ll)localObject6, (kotlin.g.a.b)localObject4, (kotlin.g.a.b)localObject5));
                  AppMethodBeat.o(183040);
                  return;
                }
                this.lyX.invoke();
                AppMethodBeat.o(183040);
                return;
              }
              label637:
              i = 1;
            }
          }
        }
      }
      
      @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"})
      static final class a
        extends q
        implements kotlin.g.a.b<lm, x>
      {
        a(at.c.a parama)
        {
          super();
        }
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(at.c paramc, ll paramll, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(183042);
        Object localObject = this.lyT.lyS;
        at.bEn();
        com.tencent.mm.vending.g.c localc = ((com.tencent.mm.plugin.appbrand.networking.c)localObject).a(at.lyN, (com.tencent.mm.bw.a)this.lyZ, lm.class);
        localObject = this.lza;
        if (localObject != null) {
          localObject = new au((kotlin.g.a.b)localObject);
        }
        for (;;)
        {
          localc.a((d.b)localObject).a((d.a)new d.a()
          {
            public final void cn(Object paramAnonymousObject)
            {
              AppMethodBeat.i(183041);
              if (paramAnonymousObject == null) {
                paramAnonymousObject = null;
              }
              for (;;)
              {
                this.lzb.lyU.invoke(paramAnonymousObject);
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<List<? extends WxaAttributes>, x>
  {
    d(int paramInt, at.h paramh)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.b<List<? extends WxaAttributes>, x>
  {
    e(int paramInt, at.h paramh, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(int paramInt, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errMsg", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.b<String, x>
  {
    g(at paramat, int paramInt, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroid/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"})
  public static final class h
    implements android.arch.a.c.a<List<? extends WxaAttributes>, Boolean>
  {
    private boolean lzg;
    
    h(WeakReference paramWeakReference, int paramInt, String paramString) {}
    
    public final Boolean by(List<WxaAttributes> paramList)
    {
      AppMethodBeat.i(183048);
      p.h(paramList, "input");
      if (!this.lzg)
      {
        try
        {
          com.tencent.mm.plugin.appbrand.d locald = (com.tencent.mm.plugin.appbrand.d)this.lzd.get();
          if (locald != null)
          {
            int i = this.lyo;
            at localat = this.lzf;
            JSONObject localJSONObject = new JSONObject();
            at.bEn();
            localJSONObject.put("contactList", at.a.bx(paramList));
            localJSONObject.put("callbackId", this.lze);
            locald.i(i, localat.h("ok", localJSONObject));
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            paramList = (com.tencent.mm.plugin.appbrand.d)this.lzd.get();
            if (paramList != null) {
              paramList.i(this.lyo, this.lzf.Zf("fail: toJson fail"));
            }
          }
        }
        this.lzg = true;
      }
      for (boolean bool = true;; bool = false)
      {
        AppMethodBeat.o(183048);
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.at
 * JD-Core Version:    0.7.0.1
 */
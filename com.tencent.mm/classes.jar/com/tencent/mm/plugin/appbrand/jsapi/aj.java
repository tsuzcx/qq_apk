package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.kf;
import com.tencent.mm.protocal.protobuf.kg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.k;
import d.v;
import d.y;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"})
public final class aj
  extends a<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 410;
  public static final String NAME = "batchGetContact";
  public static final String jwM = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
  @Deprecated
  public static final aj.a jwN;
  
  static
  {
    AppMethodBeat.i(183052);
    jwN = new aj.a((byte)0);
    NAME = "batchGetContact";
    CTRL_INDEX = 410;
    jwM = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    AppMethodBeat.o(183052);
  }
  
  protected final boolean aXA()
  {
    return true;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
  static final class b
    extends ar
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onContactUpdate";
    public static final a jwO;
    
    static
    {
      AppMethodBeat.i(183038);
      jwO = new a((byte)0);
      NAME = "onContactUpdate";
      CTRL_INDEX = -2;
      AppMethodBeat.o(183038);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "requestId", "luggage-wechat-full-sdk_release"})
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
        localObject = new aj.b();
        if (paramList != null)
        {
          aj.aXP();
          ((aj.b)localObject).r("contactList", aj.a.bj(paramList));
        }
        ((aj.b)localObject).r("requestId", paramString);
        paramd.a((ar)localObject);
        AppMethodBeat.o(183037);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"})
  static final class c
  {
    final String iPd;
    final long jwP;
    final List<String> jwQ;
    final com.tencent.mm.plugin.appbrand.networking.a jwR;
    final int tag;
    
    public c(String paramString, int paramInt, List<String> paramList, com.tencent.mm.plugin.appbrand.networking.a parama)
    {
      AppMethodBeat.i(183043);
      this.iPd = paramString;
      this.tag = paramInt;
      this.jwQ = paramList;
      this.jwR = parama;
      this.jwP = TimeUnit.MINUTES.toSeconds(5L);
      AppMethodBeat.o(183043);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
    public static final class a
      implements com.tencent.e.i.h
    {
      a(d.g.a.b paramb1, d.g.a.b paramb2, d.g.a.b paramb3, d.g.a.a parama) {}
      
      public final String getKey()
      {
        return "Luggage.FULL.JsApiBatchGetContact.Loader";
      }
      
      public final void run()
      {
        AppMethodBeat.i(183040);
        Object localObject4 = new LinkedList();
        Object localObject3 = new LinkedList();
        label645:
        label648:
        for (;;)
        {
          Object localObject5;
          Object localObject6;
          Object localObject7;
          int i;
          try
          {
            localObject5 = new HashSet((Collection)this.jwS.jwQ);
            x.aTU();
            localObject1 = x.a(this.jwS.jwQ, new String[] { "appId", "appInfo", "syncVersion", "syncTimeSecond" });
            if (localObject1 == null) {
              break label354;
            }
            localObject6 = ((Iterable)localObject1).iterator();
            if (!((Iterator)localObject6).hasNext()) {
              break label372;
            }
            localObject1 = (WxaAttributes)((Iterator)localObject6).next();
            ((HashSet)localObject5).remove(((WxaAttributes)localObject1).field_appId);
            if (localObject1 == null) {
              break label235;
            }
            localObject7 = (CharSequence)((WxaAttributes)localObject1).field_appInfo;
            if (localObject7 == null) {
              break label648;
            }
            if (((CharSequence)localObject7).length() != 0) {
              break label230;
            }
          }
          catch (JSONException localJSONException)
          {
            Object localObject1;
            aj.aXP();
            ad.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.jwS.hashCode() + ").run(), make callback array e=" + localJSONException);
            this.jwT.aA("get contact json error");
            AppMethodBeat.o(183040);
            return;
          }
          label354:
          if (i == 0)
          {
            ((LinkedList)localObject4).add(localObject1);
            continue;
            label230:
            i = 0;
          }
          else
          {
            label235:
            if (bt.lZ(localJSONException.field_syncTimeSecond) > this.jwS.jwP)
            {
              localObject7 = new dus();
              ((dus)localObject7).dlB = localJSONException.field_appId;
              if (localJSONException != null)
              {
                localObject2 = localJSONException.field_syncVersion;
                if (localObject2 != null)
                {
                  Charset localCharset = d.n.d.UTF_8;
                  if (localObject2 == null)
                  {
                    localObject2 = new v("null cannot be cast to non-null type java.lang.String");
                    AppMethodBeat.o(183040);
                    throw ((Throwable)localObject2);
                  }
                  localObject2 = ((String)localObject2).getBytes(localCharset);
                  k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
                  if (localObject2 != null) {
                    break label645;
                  }
                }
              }
              Object localObject2 = new byte[0];
              for (;;)
              {
                ((dus)localObject7).CIu = new com.tencent.mm.bx.b((byte[])localObject2);
                ((LinkedList)localObject3).add(localObject7);
                break;
                this.jwT.aA("get contact fail");
                AppMethodBeat.o(183040);
                return;
                label372:
                localObject2 = ((Iterable)localObject5).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject5 = (String)((Iterator)localObject2).next();
                  localObject6 = new dus();
                  ((dus)localObject6).dlB = ((String)localObject5);
                  ((dus)localObject6).CIu = new com.tencent.mm.bx.b(new byte[0]);
                  ((LinkedList)localObject3).add(localObject6);
                }
                if (((LinkedList)localObject4).size() == this.jwS.jwQ.size()) {
                  this.jwU.aA(localObject4);
                }
                if (((Collection)localObject3).isEmpty()) {}
                for (i = 1; i == 0; i = 0)
                {
                  aj.aXP();
                  ad.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.jwS.tag + ").waitForBatchCgiUpdate requestList.size:" + ((LinkedList)localObject3).size());
                  localObject2 = this.jwS;
                  localObject3 = (List)localObject3;
                  localObject4 = (d.g.a.b)new a(this);
                  localObject5 = this.jwT;
                  localObject6 = new kf();
                  ((kf)localObject6).CEx.addAll((Collection)localObject3);
                  ((kf)localObject6).Scene = 100;
                  com.tencent.mm.vending.h.d.HQM.v((Runnable)new aj.c.b((aj.c)localObject2, (kf)localObject6, (d.g.a.b)localObject4, (d.g.a.b)localObject5));
                  AppMethodBeat.o(183040);
                  return;
                }
                this.jwW.invoke();
                AppMethodBeat.o(183040);
                return;
              }
              i = 1;
            }
          }
        }
      }
      
      @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.b<kg, y>
      {
        a(aj.c.a parama)
        {
          super();
        }
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(aj.c paramc, kf paramkf, d.g.a.b paramb1, d.g.a.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(183042);
        Object localObject = this.jwS.jwR;
        aj.aXP();
        c localc = ((com.tencent.mm.plugin.appbrand.networking.a)localObject).a(aj.jwM, (com.tencent.mm.bx.a)this.jwY, kg.class);
        localObject = this.jwZ;
        if (localObject != null) {
          localObject = new ak((d.g.a.b)localObject);
        }
        for (;;)
        {
          localc.a((d.b)localObject).a((d.a)new d.a()
          {
            public final void ce(Object paramAnonymousObject)
            {
              AppMethodBeat.i(183041);
              if (paramAnonymousObject == null) {
                paramAnonymousObject = null;
              }
              for (;;)
              {
                this.jxa.jwT.aA(paramAnonymousObject);
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<List<? extends WxaAttributes>, y>
  {
    d(int paramInt, aj.h paramh)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<List<? extends WxaAttributes>, y>
  {
    e(int paramInt, aj.h paramh, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(int paramInt, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "errMsg", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    g(aj paramaj, int paramInt, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroid/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"})
  public static final class h
    implements android.arch.a.c.a<List<? extends WxaAttributes>, Boolean>
  {
    private boolean jxg;
    
    h(WeakReference paramWeakReference, int paramInt) {}
    
    public final Boolean bk(List<WxaAttributes> paramList)
    {
      AppMethodBeat.i(183048);
      k.h(paramList, "input");
      if (!this.jxg)
      {
        try
        {
          com.tencent.mm.plugin.appbrand.d locald = (com.tencent.mm.plugin.appbrand.d)this.jxd.get();
          if (locald != null)
          {
            int i = this.jxb;
            aj localaj = this.jxf;
            JSONObject localJSONObject = new JSONObject();
            aj.aXP();
            locald.h(i, localaj.e("ok", localJSONObject.put("contactList", aj.a.bj(paramList))));
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            paramList = (com.tencent.mm.plugin.appbrand.d)this.jxd.get();
            if (paramList != null) {
              paramList.h(this.jxb, this.jxf.HI("fail: toJson fail"));
            }
          }
        }
        this.jxg = true;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */
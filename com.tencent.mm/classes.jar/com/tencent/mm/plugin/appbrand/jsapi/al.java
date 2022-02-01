package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.protocal.protobuf.egn;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.protocal.protobuf.kv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d.a;
import com.tencent.mm.vending.g.d.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
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

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"})
public final class al
  extends a<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 410;
  public static final String NAME = "batchGetContact";
  public static final String krE = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
  @Deprecated
  public static final al.a krF;
  
  static
  {
    AppMethodBeat.i(183052);
    krF = new al.a((byte)0);
    NAME = "batchGetContact";
    CTRL_INDEX = 410;
    krE = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    AppMethodBeat.o(183052);
  }
  
  protected final boolean bib()
  {
    return true;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
  static final class b
    extends at
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onContactUpdate";
    public static final a krG;
    
    static
    {
      AppMethodBeat.i(183038);
      krG = new a((byte)0);
      NAME = "onContactUpdate";
      CTRL_INDEX = -2;
      AppMethodBeat.o(183038);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "requestId", "luggage-wechat-full-sdk_release"})
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
        localObject = new al.b();
        if (paramList != null)
        {
          al.biq();
          ((al.b)localObject).p("contactList", al.a.bj(paramList));
        }
        ((al.b)localObject).p("requestId", paramString);
        paramd.a((at)localObject);
        AppMethodBeat.o(183037);
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"})
  static final class c
  {
    final String jJi;
    final long krH;
    final List<String> krI;
    final com.tencent.mm.plugin.appbrand.networking.b krJ;
    final int tag;
    
    public c(String paramString, int paramInt, List<String> paramList, com.tencent.mm.plugin.appbrand.networking.b paramb)
    {
      AppMethodBeat.i(183043);
      this.jJi = paramString;
      this.tag = paramInt;
      this.krI = paramList;
      this.krJ = paramb;
      this.krH = TimeUnit.MINUTES.toSeconds(5L);
      AppMethodBeat.o(183043);
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
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
        for (;;)
        {
          Object localObject5;
          Object localObject6;
          Object localObject7;
          int i;
          try
          {
            localObject5 = new HashSet((Collection)this.krK.krI);
            y.bes();
            localObject1 = y.a(this.krK.krI, new String[] { "appId", "appInfo", "syncVersion", "syncTimeSecond" });
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
            al.biq();
            ad.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.krK.hashCode() + ").run(), make callback array e=" + localJSONException);
            this.krL.invoke("get contact json error");
            AppMethodBeat.o(183040);
            return;
          }
          if (i == 0)
          {
            ((HashSet)localObject5).remove(((WxaAttributes)localObject1).field_appId);
            ((LinkedList)localObject4).add(localObject1);
            if (bt.rM(((WxaAttributes)localObject1).field_syncTimeSecond) > this.krK.krH)
            {
              localObject7 = new egn();
              ((egn)localObject7).duW = ((WxaAttributes)localObject1).field_appId;
              localObject1 = ((WxaAttributes)localObject1).field_syncVersion;
              label294:
              Object localObject2;
              if (localObject1 != null)
              {
                Charset localCharset = d.n.d.UTF_8;
                if (localObject1 == null)
                {
                  localObject1 = new v("null cannot be cast to non-null type java.lang.String");
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
                ((egn)localObject7).FGF = new com.tencent.mm.bx.b((byte[])localObject2);
                ((LinkedList)localObject3).add(localObject7);
                break;
                label343:
                this.krL.invoke("get contact fail");
                AppMethodBeat.o(183040);
                return;
                label361:
                localObject2 = ((Iterable)localObject5).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject5 = (String)((Iterator)localObject2).next();
                  localObject6 = new egn();
                  ((egn)localObject6).duW = ((String)localObject5);
                  ((egn)localObject6).FGF = new com.tencent.mm.bx.b(new byte[0]);
                  ((LinkedList)localObject3).add(localObject6);
                }
                if (((LinkedList)localObject4).size() == this.krK.krI.size()) {
                  this.krM.invoke(localObject4);
                }
                if (((Collection)localObject3).isEmpty()) {}
                for (i = 1; i == 0; i = 0)
                {
                  al.biq();
                  ad.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.krK.tag + ").waitForBatchCgiUpdate requestList.size:" + ((LinkedList)localObject3).size());
                  localObject2 = this.krK;
                  localObject3 = (List)localObject3;
                  localObject4 = (d.g.a.b)new a(this);
                  localObject5 = this.krL;
                  localObject6 = new ku();
                  ((ku)localObject6).FCt.addAll((Collection)localObject3);
                  ((ku)localObject6).Scene = 100;
                  com.tencent.mm.vending.h.d.LiM.w((Runnable)new al.c.b((al.c)localObject2, (ku)localObject6, (d.g.a.b)localObject4, (d.g.a.b)localObject5));
                  AppMethodBeat.o(183040);
                  return;
                }
                this.krO.invoke();
                AppMethodBeat.o(183040);
                return;
              }
              label637:
              i = 1;
            }
          }
        }
      }
      
      @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"})
      static final class a
        extends q
        implements d.g.a.b<kv, z>
      {
        a(al.c.a parama)
        {
          super();
        }
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(al.c paramc, ku paramku, d.g.a.b paramb1, d.g.a.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(183042);
        Object localObject = this.krK.krJ;
        al.biq();
        c localc = ((com.tencent.mm.plugin.appbrand.networking.b)localObject).a(al.krE, (com.tencent.mm.bx.a)this.krQ, kv.class);
        localObject = this.krR;
        if (localObject != null) {
          localObject = new am((d.g.a.b)localObject);
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
                this.krS.krL.invoke(paramAnonymousObject);
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class d
    extends q
    implements d.g.a.b<List<? extends WxaAttributes>, z>
  {
    d(int paramInt, al.h paramh)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class e
    extends q
    implements d.g.a.b<List<? extends WxaAttributes>, z>
  {
    e(int paramInt, al.h paramh, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
  {
    f(int paramInt, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errMsg", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.b<String, z>
  {
    g(al paramal, int paramInt, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroid/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"})
  public static final class h
    implements android.arch.a.c.a<List<? extends WxaAttributes>, Boolean>
  {
    private boolean krX;
    
    h(WeakReference paramWeakReference, int paramInt) {}
    
    public final Boolean bk(List<WxaAttributes> paramList)
    {
      AppMethodBeat.i(183048);
      p.h(paramList, "input");
      if (!this.krX)
      {
        try
        {
          com.tencent.mm.plugin.appbrand.d locald = (com.tencent.mm.plugin.appbrand.d)this.krU.get();
          if (locald != null)
          {
            int i = this.krv;
            al localal = this.krW;
            JSONObject localJSONObject = new JSONObject();
            al.biq();
            locald.h(i, localal.e("ok", localJSONObject.put("contactList", al.a.bj(paramList))));
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            paramList = (com.tencent.mm.plugin.appbrand.d)this.krU.get();
            if (paramList != null) {
              paramList.h(this.krv, this.krW.Pg("fail: toJson fail"));
            }
          }
        }
        this.krX = true;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.al
 * JD-Core Version:    0.7.0.1
 */
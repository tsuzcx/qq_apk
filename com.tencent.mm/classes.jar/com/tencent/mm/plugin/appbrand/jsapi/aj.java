package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.x;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandAsyncJsApi;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "()V", "dispatchInJsThread", "", "invoke", "", "env", "data", "Lorg/json/JSONObject;", "callbackId", "", "Constants", "EventOnContactUpdate", "Loader", "luggage-wechat-full-sdk_release"})
public final class aj
  extends a<com.tencent.mm.plugin.appbrand.d>
{
  public static final int CTRL_INDEX = 410;
  public static final String NAME = "batchGetContact";
  public static final String jXi = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
  @Deprecated
  public static final aj.a jXj;
  
  static
  {
    AppMethodBeat.i(183052);
    jXj = new aj.a((byte)0);
    NAME = "batchGetContact";
    CTRL_INDEX = 410;
    jXi = "/cgi-bin/mmbiz-bin/wxaattr/batchwxaattrsync";
    AppMethodBeat.o(183052);
  }
  
  protected final boolean bex()
  {
    return true;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate;", "Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiEvent;", "()V", "Companion", "luggage-wechat-full-sdk_release"})
  static final class b
    extends ar
  {
    public static final int CTRL_INDEX = -2;
    public static final String NAME = "onContactUpdate";
    public static final a jXk;
    
    static
    {
      AppMethodBeat.i(183038);
      jXk = new a((byte)0);
      NAME = "onContactUpdate";
      CTRL_INDEX = -2;
      AppMethodBeat.o(183038);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$EventOnContactUpdate$Companion;", "", "()V", "CTRL_INDEX", "", "NAME", "", "dispatch", "", "env", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "attrList", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "requestId", "luggage-wechat-full-sdk_release"})
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
          aj.beM();
          ((aj.b)localObject).q("contactList", aj.a.bh(paramList));
        }
        ((aj.b)localObject).q("requestId", paramString);
        paramd.a((ar)localObject);
        AppMethodBeat.o(183037);
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"})
  static final class c
  {
    final long jXl;
    final List<String> jXm;
    final com.tencent.mm.plugin.appbrand.networking.a jXn;
    final String jpn;
    final int tag;
    
    public c(String paramString, int paramInt, List<String> paramList, com.tencent.mm.plugin.appbrand.networking.a parama)
    {
      AppMethodBeat.i(183043);
      this.jpn = paramString;
      this.tag = paramInt;
      this.jXm = paramList;
      this.jXn = parama;
      this.jXl = TimeUnit.MINUTES.toSeconds(5L);
      AppMethodBeat.o(183043);
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"})
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
            localObject5 = new HashSet((Collection)this.jXo.jXm);
            x.baS();
            localObject1 = x.a(this.jXo.jXm, new String[] { "appId", "appInfo", "syncVersion", "syncTimeSecond" });
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
            aj.beM();
            ac.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.jXo.hashCode() + ").run(), make callback array e=" + localJSONException);
            this.jXp.ay("get contact json error");
            AppMethodBeat.o(183040);
            return;
          }
          if (i == 0)
          {
            ((HashSet)localObject5).remove(((WxaAttributes)localObject1).field_appId);
            ((LinkedList)localObject4).add(localObject1);
            if (bs.pN(((WxaAttributes)localObject1).field_syncTimeSecond) > this.jXo.jXl)
            {
              localObject7 = new eaj();
              ((eaj)localObject7).djj = ((WxaAttributes)localObject1).field_appId;
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
                k.g(localObject2, "(this as java.lang.String).getBytes(charset)");
                if (localObject2 != null) {}
              }
              else
              {
                localObject2 = new byte[0];
              }
              for (;;)
              {
                ((eaj)localObject7).EaW = new com.tencent.mm.bw.b((byte[])localObject2);
                ((LinkedList)localObject3).add(localObject7);
                break;
                label343:
                this.jXp.ay("get contact fail");
                AppMethodBeat.o(183040);
                return;
                label361:
                localObject2 = ((Iterable)localObject5).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  localObject5 = (String)((Iterator)localObject2).next();
                  localObject6 = new eaj();
                  ((eaj)localObject6).djj = ((String)localObject5);
                  ((eaj)localObject6).EaW = new com.tencent.mm.bw.b(new byte[0]);
                  ((LinkedList)localObject3).add(localObject6);
                }
                if (((LinkedList)localObject4).size() == this.jXo.jXm.size()) {
                  this.jXq.ay(localObject4);
                }
                if (((Collection)localObject3).isEmpty()) {}
                for (i = 1; i == 0; i = 0)
                {
                  aj.beM();
                  ac.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.jXo.tag + ").waitForBatchCgiUpdate requestList.size:" + ((LinkedList)localObject3).size());
                  localObject2 = this.jXo;
                  localObject3 = (List)localObject3;
                  localObject4 = (d.g.a.b)new a(this);
                  localObject5 = this.jXp;
                  localObject6 = new kl();
                  ((kl)localObject6).DWX.addAll((Collection)localObject3);
                  ((kl)localObject6).Scene = 100;
                  com.tencent.mm.vending.h.d.Jrh.w((Runnable)new aj.c.b((aj.c)localObject2, (kl)localObject6, (d.g.a.b)localObject4, (d.g.a.b)localObject5));
                  AppMethodBeat.o(183040);
                  return;
                }
                this.jXs.invoke();
                AppMethodBeat.o(183040);
                return;
              }
              label637:
              i = 1;
            }
          }
        }
      }
      
      @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "invoke"})
      static final class a
        extends d.g.b.l
        implements d.g.a.b<km, y>
      {
        a(aj.c.a parama)
        {
          super();
        }
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
    static final class b
      implements Runnable
    {
      b(aj.c paramc, kl paramkl, d.g.a.b paramb1, d.g.a.b paramb2) {}
      
      public final void run()
      {
        AppMethodBeat.i(183042);
        Object localObject = this.jXo.jXn;
        aj.beM();
        c localc = ((com.tencent.mm.plugin.appbrand.networking.a)localObject).a(aj.jXi, (com.tencent.mm.bw.a)this.jXu, km.class);
        localObject = this.jXv;
        if (localObject != null) {
          localObject = new ak((d.g.a.b)localObject);
        }
        for (;;)
        {
          localc.a((d.b)localObject).a((d.a)new d.a()
          {
            public final void cc(Object paramAnonymousObject)
            {
              AppMethodBeat.i(183041);
              if (paramAnonymousObject == null) {
                paramAnonymousObject = null;
              }
              for (;;)
              {
                this.jXw.jXp.ay(paramAnonymousObject);
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class d
    extends d.g.b.l
    implements d.g.a.b<List<? extends WxaAttributes>, y>
  {
    d(int paramInt, aj.h paramh)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "list", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.b<List<? extends WxaAttributes>, y>
  {
    e(int paramInt, aj.h paramh, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(int paramInt, WeakReference paramWeakReference, String paramString)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "errMsg", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.b<String, y>
  {
    g(aj paramaj, int paramInt, WeakReference paramWeakReference)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$invoke$callback$1", "Landroid/arch/core/util/Function;", "", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "", "callbackInvoked", "getCallbackInvoked", "()Z", "setCallbackInvoked", "(Z)V", "apply", "input", "(Ljava/util/List;)Ljava/lang/Boolean;", "luggage-wechat-full-sdk_release"})
  public static final class h
    implements android.arch.a.c.a<List<? extends WxaAttributes>, Boolean>
  {
    private boolean jXC;
    
    h(WeakReference paramWeakReference, int paramInt) {}
    
    public final Boolean bi(List<WxaAttributes> paramList)
    {
      AppMethodBeat.i(183048);
      k.h(paramList, "input");
      if (!this.jXC)
      {
        try
        {
          com.tencent.mm.plugin.appbrand.d locald = (com.tencent.mm.plugin.appbrand.d)this.jXz.get();
          if (locald != null)
          {
            int i = this.jXx;
            aj localaj = this.jXB;
            JSONObject localJSONObject = new JSONObject();
            aj.beM();
            locald.h(i, localaj.e("ok", localJSONObject.put("contactList", aj.a.bh(paramList))));
          }
        }
        catch (JSONException paramList)
        {
          for (;;)
          {
            paramList = (com.tencent.mm.plugin.appbrand.d)this.jXz.get();
            if (paramList != null) {
              paramList.h(this.jXx, this.jXB.LM("fail: toJson fail"));
            }
          }
        }
        this.jXC = true;
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
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.aj
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.ac;
import com.tencent.mm.plugin.appbrand.config.ai;
import com.tencent.mm.protocal.protobuf.gkw;
import com.tencent.mm.protocal.protobuf.mc;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vending.g.d;
import com.tencent.threadpool.i.h;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import org.json.JSONException;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader;", "", "hostWxaAppId", "", "tag", "", "appIds", "", "cgiService", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "(Ljava/lang/String;ILjava/util/List;Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;)V", "INTERVAL_SECONDS", "", "load", "", "onLoaded", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "onUpdated", "onNoUpdate", "Lkotlin/Function0;", "onError", "waitForBatchCgiUpdate", "requestList", "Lcom/tencent/mm/protocal/protobuf/WxaAttrSyncSingleReqInfo;", "onSuccess", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
final class at$c
{
  private final String qIf;
  final List<String> rxC;
  final com.tencent.mm.plugin.appbrand.networking.c rxD;
  final long rxE;
  final int tag;
  
  public at$c(String paramString, int paramInt, List<String> paramList, com.tencent.mm.plugin.appbrand.networking.c paramc)
  {
    AppMethodBeat.i(183043);
    this.qIf = paramString;
    this.tag = paramInt;
    this.rxC = paramList;
    this.rxD = paramc;
    this.rxE = TimeUnit.MINUTES.toSeconds(5L);
    AppMethodBeat.o(183043);
  }
  
  private static final void a(c paramc, mc parammc, kotlin.g.a.b paramb1, kotlin.g.a.b paramb2)
  {
    AppMethodBeat.i(325726);
    s.u(paramc, "this$0");
    s.u(parammc, "$request");
    s.u(paramb1, "$onSuccess");
    s.u(paramb2, "$onError");
    paramc.rxD.a(at.rxA, (com.tencent.mm.bx.a)parammc, md.class).a(new at.c..ExternalSyntheticLambda1(paramb1)).a(new at.c..ExternalSyntheticLambda0(paramb2));
    AppMethodBeat.o(325726);
  }
  
  private static final void a(kotlin.g.a.b paramb, md parammd)
  {
    AppMethodBeat.i(325717);
    s.u(paramb, "$tmp0");
    paramb.invoke(parammd);
    AppMethodBeat.o(325717);
  }
  
  private static final void c(kotlin.g.a.b paramb, Object paramObject)
  {
    AppMethodBeat.i(325720);
    s.u(paramb, "$onError");
    if (paramObject == null) {
      paramObject = null;
    }
    for (;;)
    {
      paramb.invoke(paramObject);
      AppMethodBeat.o(325720);
      return;
      if ((paramObject instanceof Throwable)) {
        paramObject = ((Throwable)paramObject).getMessage();
      } else {
        paramObject = paramObject.toString();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/JsApiBatchGetContactNew$Loader$load$runnable$1", "Lcom/tencent/threadpool/runnable/KeyRunnable;", "getKey", "", "run", "", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements h
  {
    a(at.c paramc, kotlin.g.a.b<? super String, kotlin.ah> paramb, kotlin.g.a.b<? super List<WxaAttributes>, kotlin.ah> paramb1, kotlin.g.a.a<kotlin.ah> parama, kotlin.g.a.b<? super List<WxaAttributes>, kotlin.ah> paramb2) {}
    
    public final String getKey()
    {
      return "Luggage.FULL.JsApiBatchGetContact.Loader";
    }
    
    public final void run()
    {
      AppMethodBeat.i(183040);
      LinkedList localLinkedList1 = new LinkedList();
      LinkedList localLinkedList2 = new LinkedList();
      for (;;)
      {
        Object localObject3;
        Object localObject4;
        Object localObject5;
        Object localObject6;
        int i;
        try
        {
          localObject3 = new HashSet((Collection)this.rxF.rxC);
          ai.clk();
          localObject1 = ai.a(this.rxF.rxC, new String[] { "username", "appId", "versionInfo", "appInfo", "syncTimeSecond", "syncVersion" });
          if (localObject1 == null)
          {
            localObject1 = null;
            if (localObject1 != null) {
              break label373;
            }
            this.rxG.invoke("get contact fail");
            AppMethodBeat.o(183040);
            return;
          }
          localObject4 = (Iterable)localObject1;
          localObject1 = this.rxF;
          localObject4 = ((Iterable)localObject4).iterator();
          if (!((Iterator)localObject4).hasNext()) {
            break label366;
          }
          localObject5 = (WxaAttributes)((Iterator)localObject4).next();
          localObject6 = (CharSequence)((WxaAttributes)localObject5).field_appInfo;
          if (localObject6 == null) {
            break label606;
          }
          if (((CharSequence)localObject6).length() != 0) {
            break label348;
          }
        }
        catch (JSONException localJSONException)
        {
          Object localObject1;
          Log.e("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.rxF.hashCode() + ").run(), make callback array e=" + localJSONException);
          this.rxG.invoke("get contact json error");
          AppMethodBeat.o(183040);
          return;
        }
        if (i == 0)
        {
          ((HashSet)localObject3).remove(((WxaAttributes)localObject5).field_appId);
          localLinkedList1.add(localObject5);
          if (Util.secondsToNow(((WxaAttributes)localObject5).field_syncTimeSecond) > ((at.c)localObject1).rxE)
          {
            localObject6 = new gkw();
            ((gkw)localObject6).appid = ((WxaAttributes)localObject5).field_appId;
            if ((com.tencent.mm.plugin.appbrand.config.ah.g((WxaAttributes)localObject5)) || (com.tencent.mm.plugin.appbrand.config.ah.h((WxaAttributes)localObject5)))
            {
              ((gkw)localObject6).YRt = new com.tencent.mm.bx.b(new byte[0]);
              localObject5 = kotlin.ah.aiuX;
              localLinkedList2.add(localObject6);
              continue;
              label348:
              i = 0;
            }
            else
            {
              ((gkw)localObject6).YRt = ac.d((WxaAttributes)localObject5);
              continue;
              label366:
              Object localObject2 = kotlin.ah.aiuX;
              continue;
              label373:
              localObject2 = ((Iterable)localObject3).iterator();
              while (((Iterator)localObject2).hasNext())
              {
                localObject4 = (String)((Iterator)localObject2).next();
                localObject3 = new gkw();
                ((gkw)localObject3).appid = ((String)localObject4);
                ((gkw)localObject3).YRt = new com.tencent.mm.bx.b(new byte[0]);
                localObject4 = kotlin.ah.aiuX;
                localLinkedList2.add(localObject3);
              }
              if (localLinkedList1.size() == this.rxF.rxC.size()) {
                this.rxH.invoke(localLinkedList1);
              }
              if (((Collection)localLinkedList2).isEmpty()) {}
              for (i = 1; i == 0; i = 0)
              {
                Log.i("Luggage.FULL.JsApiBatchGetContact", "Loader(" + this.rxF.tag + ").waitForBatchCgiUpdate requestList.size:" + localLinkedList2.size());
                at.c.a(this.rxF, (List)localLinkedList2, (kotlin.g.a.b)new a(this.rxG, this.rxF, this.rxJ), this.rxG);
                AppMethodBeat.o(183040);
                return;
              }
              this.rxI.invoke();
              AppMethodBeat.o(183040);
              return;
              label606:
              i = 1;
            }
          }
        }
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/protocal/protobuf/BatchWxaAttrSyncResponse;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.b<md, kotlin.ah>
    {
      a(kotlin.g.a.b<? super String, kotlin.ah> paramb, at.c paramc, kotlin.g.a.b<? super List<WxaAttributes>, kotlin.ah> paramb1)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.at.c
 * JD-Core Version:    0.7.0.1
 */
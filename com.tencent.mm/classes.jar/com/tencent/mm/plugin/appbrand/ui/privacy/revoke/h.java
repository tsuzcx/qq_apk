package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.al;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.gjz;
import com.tencent.mm.protocal.protobuf.gnd;
import com.tencent.mm.protocal.protobuf.gne;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.b.s;
import kotlin.j.c;
import kotlin.k.k;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeMockLogic;", "", "()V", "fakeAppIconUrl", "", "fakeAppId", "fakeAppName", "fakePluginNames", "", "[Ljava/lang/String;", "fakeScopeItems", "Lcom/tencent/mm/protocal/protobuf/ScopeItem;", "[Lcom/tencent/mm/protocal/protobuf/ScopeItem;", "random", "Lkotlin/random/Random;", "fakeDoRevoke", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mockUserInfoUsageInfo", "appAttrs", "Lcom/tencent/mm/plugin/appbrand/config/WxaProfileAttributes;", "getAuthInfoResp", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetAuthInfoResp;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  private static final c uiQ;
  public static final h ukh;
  private static final String uki;
  private static final String ukj;
  private static final String ukk;
  private static final eum[] ukl;
  private static final String[] ukm;
  
  static
  {
    AppMethodBeat.i(322894);
    ukh = new h();
    uiQ = kotlin.j.d.BG(Util.currentTicks());
    uki = "wxe5f52902cf4de896";
    ukj = "小程序示例";
    ukk = "http://wx.qlogo.cn/mmhead/Q3auHgzwzM7Fll3F71bOWuUvJCZWo1yia2gtXmiaDMcAC0hIsAgJ2UlQ/96";
    eum localeum = new eum();
    localeum.scope = "scope.nickname";
    localeum.desc = "微信头像和昵称";
    localeum.state = 0;
    localeum.icon_url = "https://wximg.qq.com/cityservices/relieved_buy/consumer_protect.png";
    Object localObject1 = kotlin.ah.aiuX;
    localObject1 = new eum();
    ((eum)localObject1).scope = "scope.phone_number";
    ((eum)localObject1).desc = "手机号";
    ((eum)localObject1).state = 0;
    ((eum)localObject1).icon_url = "https://wximg.qq.com/cityservices/relieved_buy/fast_answer.png";
    Object localObject2 = kotlin.ah.aiuX;
    localObject2 = new eum();
    ((eum)localObject2).scope = "scope.address";
    ((eum)localObject2).desc = "地址";
    ((eum)localObject2).state = 0;
    ((eum)localObject2).icon_url = "https://wximg.qq.com/cityservices/relieved_buy/fast_delivery.png";
    Object localObject3 = kotlin.ah.aiuX;
    localObject3 = new eum();
    ((eum)localObject3).scope = "scope.invoice";
    ((eum)localObject3).desc = "发票信息";
    ((eum)localObject3).state = 0;
    ((eum)localObject3).icon_url = "https://wximg.qq.com/cityservices/relieved_buy/fast_refund.png";
    kotlin.ah localah = kotlin.ah.aiuX;
    ukl = new eum[] { localeum, localObject1, localObject2, localObject3 };
    ukm = new String[] { "下单助手", "下单助手2", "下单助手3", "下单助手4" };
    AppMethodBeat.o(322894);
  }
  
  public static void a(al paramal, gjz paramgjz)
  {
    AppMethodBeat.i(322883);
    s.u(paramgjz, "getAuthInfoResp");
    int k = uiQ.Pa(8);
    int j = uiQ.Pa(8);
    Object localObject2 = (Iterable)k.qt(0, j);
    Object localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      ((kotlin.a.ah)localObject2).Zo();
      ((Collection)localObject1).add(Integer.valueOf(uiQ.Pa(8)));
    }
    List localList = (List)localObject1;
    int i = 0;
    gnd localgnd = new gnd();
    gne localgne = new gne();
    localgne.appid = uki;
    if (paramal == null)
    {
      localObject1 = null;
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = ukj;
      }
      localgne.xkX = ((String)localObject2);
      if (paramal != null) {
        break label353;
      }
    }
    Object localObject3;
    label353:
    for (paramal = null;; paramal = paramal.hJL)
    {
      localObject1 = paramal;
      if (paramal == null) {
        localObject1 = ukk;
      }
      localgne.icon_url = ((String)localObject1);
      paramal = localgne.acip;
      localObject2 = (Iterable)k.qt(0, k);
      localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ((kotlin.a.ah)localObject2).Zo();
        localObject3 = new eum();
        ((eum)localObject3).parseFrom(ukl[uiQ.Pa(ukl.length)].toByteArray());
        localgne.appid = s.X(localgne.appid, Integer.valueOf(i));
        if (uiQ.Pa(5) == 0) {
          ((eum)localObject3).state = 7;
        }
        ((Collection)localObject1).add(localObject3);
        i += 1;
      }
      localObject1 = paramal.nickname;
      break;
    }
    paramal.addAll((Collection)localObject1);
    paramal = kotlin.ah.aiuX;
    localgnd.acin = localgne;
    paramal = localgnd.acio;
    localObject2 = (Iterable)k.qt(0, j);
    localObject1 = (Collection)new ArrayList(p.a((Iterable)localObject2, 10));
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      j = ((kotlin.a.ah)localObject2).Zo();
      localgne = new gne();
      localgne.appid = uki;
      localgne.xkX = ukm[uiQ.Pa(ukm.length)];
      localgne.icon_url = "";
      localObject3 = localgne.acip;
      Object localObject4 = (Iterable)k.qt(0, ((Number)localList.get(j)).intValue());
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        ((kotlin.a.ah)localObject4).Zo();
        eum localeum = new eum();
        localeum.parseFrom(ukl[uiQ.Pa(ukl.length)].toByteArray());
        localgne.appid = s.X(localgne.appid, Integer.valueOf(i));
        if (uiQ.Pa(5) == 0) {
          localeum.state = 7;
        }
        localCollection.add(localeum);
        i += 1;
      }
      ((LinkedList)localObject3).addAll((Collection)localCollection);
      ((Collection)localObject1).add(localgne);
    }
    paramal.addAll((Collection)localObject1);
    paramal = kotlin.ah.aiuX;
    paramgjz.acfV = localgnd;
    AppMethodBeat.o(322883);
  }
  
  public final Object V(kotlin.d.d<? super kotlin.ah> paramd)
  {
    AppMethodBeat.i(322906);
    Object localObject;
    if ((paramd instanceof a))
    {
      localObject = (a)paramd;
      if ((((a)localObject).label & 0x80000000) != 0) {
        ((a)localObject).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super kotlin.ah>)localObject;; paramd = new a(this, paramd))
    {
      localObject = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322906);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject);
    paramd.label = 1;
    if (bb.e(500L, paramd) == locala)
    {
      AppMethodBeat.o(322906);
      return locala;
      ResultKt.throwOnFailure(localObject);
    }
    if (uiQ.Pa(5) == 0)
    {
      paramd = new IOException("Fake do cgi fail");
      AppMethodBeat.o(322906);
      throw paramd;
    }
    paramd = kotlin.ah.aiuX;
    AppMethodBeat.o(322906);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(h paramh, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322905);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ukn.V((kotlin.d.d)this);
      AppMethodBeat.o(322905);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.h
 * JD-Core Version:    0.7.0.1
 */
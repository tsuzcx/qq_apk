package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gkf;
import com.tencent.mm.protocal.protobuf.gng;
import com.tencent.mm.protocal.protobuf.gni;
import com.tencent.mm.sdk.platformtools.Log;
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
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.gkf;>;
import kotlin.j.c;
import kotlin.k.k;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/AppBrandPrivacyManageMockLogic;", "", "()V", "DAY_IN_SECOND", "", "TAG", "", "fakeAllShownScopeList", "", "fakeScopeItems", "", "Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "[Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "fakeUsernames", "[Ljava/lang/String;", "random", "Lkotlin/random/Random;", "mockFetch", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetUserAuthorizeScopeListResp;", "updateTime", "maxFetchCount", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  public static final d uiP;
  private static final c uiQ;
  private static final String[] uiR;
  private static final gng[] uiS;
  private static final List<String> uiT;
  
  static
  {
    AppMethodBeat.i(322994);
    uiP = new d();
    uiQ = kotlin.j.d.BG(Util.currentTicks());
    uiR = new String[] { "gh_32d0f14ab3c6@app", "gh_2e62a5bd9694@app", "gh_62e907af89ac@app", "gh_f4d6fe63d60c@app", "gh_3453a6d4e00d@app", "gh_e5e82d93a62a@app" };
    gng localgng = new gng();
    localgng.scope = "scope.nickname";
    localgng.desc = "微信头像和昵称";
    Object localObject1 = kotlin.ah.aiuX;
    localObject1 = new gng();
    ((gng)localObject1).scope = "scope.phone_number";
    ((gng)localObject1).desc = "手机号";
    Object localObject2 = kotlin.ah.aiuX;
    localObject2 = new gng();
    ((gng)localObject2).scope = "scope.address";
    ((gng)localObject2).desc = "地址";
    Object localObject3 = kotlin.ah.aiuX;
    localObject3 = new gng();
    ((gng)localObject3).scope = "scope.invoice";
    ((gng)localObject3).desc = "发票信息";
    kotlin.ah localah = kotlin.ah.aiuX;
    uiS = new gng[] { localgng, localObject1, localObject2, localObject3 };
    uiT = p.listOf(new String[] { "scope.nickname", "scope.phone_number", "scope.address", "scope.invoice" });
    AppMethodBeat.o(322994);
  }
  
  public final Object d(int paramInt1, int paramInt2, kotlin.d.d<? super gkf> paramd)
  {
    AppMethodBeat.i(323011);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super gkf>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(323011);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd.aai = paramInt1;
    paramd.asI = paramInt2;
    paramd.label = 1;
    if (bb.e(500L, paramd) == localObject2)
    {
      AppMethodBeat.o(323011);
      return localObject2;
      paramInt2 = paramd.asI;
      paramInt1 = paramd.aai;
      ResultKt.throwOnFailure(localObject1);
    }
    if (uiQ.Pa(5) == 0)
    {
      paramd = new IOException("Fake do cgi fail");
      AppMethodBeat.o(323011);
      throw paramd;
    }
    paramd = new gkf();
    int i;
    label239:
    Object localObject3;
    if (uiQ.Pa(5) == 0)
    {
      i = 0;
      paramd.status = i;
      i = k.qv(paramInt1, (int)Util.nowSecond());
      if (2147483647 != paramInt1) {
        break label545;
      }
      Log.i("MicroMsg.AppBrandPrivacyManageMockLogic", "mockFetch, status: " + paramd.status + ", updateTimeUpperBound: " + i + ", fakeFetchedCount: " + paramInt2);
      localObject1 = paramd.acgg;
      localObject3 = (Iterable)k.qt(0, paramInt2);
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
    }
    for (;;)
    {
      if (!((Iterator)localObject3).hasNext()) {
        break label585;
      }
      ((kotlin.a.ah)localObject3).Zo();
      gni localgni = new gni();
      localgni.username = uiR[uiQ.Pa(uiR.length)];
      localgni.update_time = (i - uiQ.Pa(86400));
      paramInt1 = uiQ.qq(0, 10);
      Log.i("MicroMsg.AppBrandPrivacyManageMockLogic", "mockFetch, username: " + localgni.username + ", updateTime: " + localgni.update_time + ", authScopeItemCount: " + paramInt1);
      LinkedList localLinkedList = localgni.acip;
      Object localObject4 = (Iterable)k.qt(0, paramInt1);
      Collection localCollection = (Collection)new ArrayList(p.a((Iterable)localObject4, 10));
      localObject4 = ((Iterable)localObject4).iterator();
      for (;;)
      {
        if (((Iterator)localObject4).hasNext())
        {
          ((kotlin.a.ah)localObject4).Zo();
          localCollection.add(uiS[uiQ.Pa(uiS.length)]);
          continue;
          i = 1;
          break;
          label545:
          paramInt2 -= uiQ.Pa(paramInt2);
          break label239;
        }
      }
      localLinkedList.addAll((Collection)localCollection);
      ((Collection)localObject2).add(localgni);
    }
    label585:
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    paramd.acgh.addAll((Collection)uiT);
    AppMethodBeat.o(323011);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int aai;
    int asI;
    int label;
    
    a(d paramd, kotlin.d.d<? super a> paramd1)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322966);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.uiU.d(0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(322966);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui.privacy.use_record;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gkh;
import com.tencent.mm.protocal.protobuf.gnf;
import com.tencent.mm.protocal.protobuf.gng;
import com.tencent.mm.protocal.protobuf.gnh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.a.p;
import kotlin.d.d<-Lcom.tencent.mm.protocal.protobuf.gkh;>;
import kotlin.j.c;
import kotlin.k.k;
import kotlinx.coroutines.bb;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/use_record/AppBrandPrivacyUseRecordMockLogic;", "", "()V", "DAY_IN_SECOND", "", "TAG", "", "fakePluginInfos", "", "Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopePluginInfo;", "[Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopePluginInfo;", "fakeScopeItems", "Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "[Lcom/tencent/mm/protocal/protobuf/WxaUserAuthScopeItem;", "random", "Lkotlin/random/Random;", "mockFetch", "Lcom/tencent/mm/protocal/protobuf/WxaAppGetWxaUseUserInfoRecordListResp;", "updateTime", "maxFetchCount", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  private static final c uiQ;
  private static final gng[] uiS;
  public static final a ukR;
  private static final gnh[] ukS;
  
  static
  {
    AppMethodBeat.i(322769);
    ukR = new a();
    uiQ = kotlin.j.d.BG(Util.currentTicks());
    Object localObject1 = new gng();
    ((gng)localObject1).scope = "scope.nickname";
    ((gng)localObject1).desc = "微信头像和昵称";
    Object localObject2 = kotlin.ah.aiuX;
    localObject2 = new gng();
    ((gng)localObject2).scope = "scope.phone_number";
    ((gng)localObject2).desc = "手机号";
    Object localObject3 = kotlin.ah.aiuX;
    localObject3 = new gng();
    ((gng)localObject3).scope = "scope.address";
    ((gng)localObject3).desc = "地址";
    Object localObject4 = kotlin.ah.aiuX;
    localObject4 = new gng();
    ((gng)localObject4).scope = "scope.invoice";
    ((gng)localObject4).desc = "发票信息";
    kotlin.ah localah = kotlin.ah.aiuX;
    uiS = new gng[] { localObject1, localObject2, localObject3, localObject4 };
    localObject1 = new gnh();
    ((gnh)localObject1).aaWC = "";
    ((gnh)localObject1).nickname = "腾讯地图";
    localObject2 = kotlin.ah.aiuX;
    localObject2 = new gnh();
    ((gnh)localObject2).aaWC = "";
    ((gnh)localObject2).nickname = "腾讯文档";
    localObject3 = kotlin.ah.aiuX;
    localObject3 = new gnh();
    ((gnh)localObject3).aaWC = "";
    ((gnh)localObject3).nickname = "看一看+";
    localObject4 = kotlin.ah.aiuX;
    localObject4 = new gnh();
    ((gnh)localObject4).aaWC = "";
    ((gnh)localObject4).nickname = "腾讯视频";
    localah = kotlin.ah.aiuX;
    ukS = new gnh[] { localObject1, localObject2, localObject3, localObject4 };
    AppMethodBeat.o(322769);
  }
  
  public final Object d(int paramInt1, int paramInt2, kotlin.d.d<? super gkh> paramd)
  {
    AppMethodBeat.i(322782);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super gkh>)localObject1;; paramd = new a(this, paramd))
    {
      localObject1 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322782);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject1);
    paramd.aai = paramInt1;
    paramd.asI = paramInt2;
    paramd.label = 1;
    if (bb.e(500L, paramd) == localObject2)
    {
      AppMethodBeat.o(322782);
      return localObject2;
      paramInt2 = paramd.asI;
      paramInt1 = paramd.aai;
      ResultKt.throwOnFailure(localObject1);
    }
    if (uiQ.Pa(5) == 0)
    {
      paramd = new IOException("Fake do cgi fail");
      AppMethodBeat.o(322782);
      throw paramd;
    }
    paramd = new gkh();
    int i;
    if (uiQ.Pa(5) == 0)
    {
      i = 0;
      paramd.status = i;
      i = k.qv(paramInt1, (int)Util.nowSecond());
      if (2147483647 != paramInt1) {
        break label438;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandPrivacyUseRecordMockLogic", "mockFetch, status: " + paramd.status + ", updateTimeUpperBound: " + i + ", fakeFetchedCount: " + paramInt2);
      localObject1 = paramd.acgj;
      Object localObject3 = (Iterable)k.qt(0, paramInt2);
      localObject2 = (Collection)new ArrayList(p.a((Iterable)localObject3, 10));
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        ((kotlin.a.ah)localObject3).Zo();
        gnf localgnf = new gnf();
        if (uiQ.Pa(3) == 0) {
          localgnf.aciq = ukS[uiQ.Pa(ukS.length)];
        }
        localgnf.acir = uiS[uiQ.Pa(uiS.length)];
        localgnf.HTK = (i - uiQ.Pa(86400));
        ((Collection)localObject2).add(localgnf);
      }
      i = 1;
      break;
      label438:
      paramInt2 -= uiQ.Pa(paramInt2);
    }
    ((LinkedList)localObject1).addAll((Collection)localObject2);
    AppMethodBeat.o(322782);
    return paramd;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int aai;
    int asI;
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322741);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ukT.d(0, 0, (kotlin.d.d)this);
      AppMethodBeat.o(322741);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.use_record.a
 * JD-Core Version:    0.7.0.1
 */
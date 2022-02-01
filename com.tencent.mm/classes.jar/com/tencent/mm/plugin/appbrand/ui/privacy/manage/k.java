package com.tencent.mm.plugin.appbrand.ui.privacy.manage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.ag;
import com.tencent.mm.plugin.appbrand.config.ag.d;
import com.tencent.mm.plugin.appbrand.config.q.a;
import com.tencent.mm.protocal.protobuf.gkf;
import com.tencent.mm.protocal.protobuf.gni;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lcom.tencent.mm.plugin.appbrand.ui.privacy.manage.l;>;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppGetUserAuthorizeScopeListWithAttrs;", "", "()V", "TAG", "", "doFetch", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/manage/WxaAppUserAuthorizeScopeListWithAttrs;", "updateTime", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
{
  public static final k ujv;
  
  static
  {
    AppMethodBeat.i(323005);
    ujv = new k();
    AppMethodBeat.o(323005);
  }
  
  public final Object e(int paramInt, kotlin.d.d<? super l> paramd)
  {
    AppMethodBeat.i(323021);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super l>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(323021);
        throw paramd;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    for (;;)
    {
      try
      {
        localObject1 = g.ujm;
        paramd.label = 1;
        localObject1 = g.d(paramInt, paramd);
        localObject2 = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(323021);
          return locala;
          ResultKt.throwOnFailure(localObject2);
        }
        localObject3 = (gkf)localObject2;
        localObject1 = (Collection)((gkf)localObject3).acgg;
        if ((localObject1 == null) || (((Collection)localObject1).isEmpty()))
        {
          paramInt = 1;
          if (paramInt == 0) {
            break;
          }
          Log.w("MicroMsg.WxaAppGetUserAuthorizeScopeListWithAttrs", "doFetch, resp is empty");
          AppMethodBeat.o(323021);
          return null;
        }
      }
      catch (Exception paramd)
      {
        Log.w("MicroMsg.WxaAppGetUserAuthorizeScopeListWithAttrs", s.X("doFetch, fetch fail since ", paramd));
        AppMethodBeat.o(323021);
        return null;
      }
      paramInt = 0;
    }
    paramd.L$0 = localObject3;
    paramd.label = 2;
    Object localObject1 = new q(kotlin.d.a.b.au(paramd), 1);
    ((q)localObject1).kBA();
    Object localObject2 = (kotlinx.coroutines.p)localObject1;
    kotlin.g.a.a locala1 = (kotlin.g.a.a)new c((gkf)localObject3, new WeakReference(localObject2));
    Object localObject3 = ((gkf)localObject3).acgg;
    s.s(localObject3, "resp.wxa_item_list");
    Object localObject4 = (Iterable)localObject3;
    localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
    localObject4 = ((Iterable)localObject4).iterator();
    while (((Iterator)localObject4).hasNext()) {
      ((Collection)localObject3).add(((gni)((Iterator)localObject4).next()).username);
    }
    ((kotlinx.coroutines.p)localObject2).bg((kotlin.g.a.b)new k.b(ag.a((List)localObject3, q.a.qZo, (ag.d)new k.d(locala1))));
    localObject1 = ((q)localObject1).getResult();
    if (localObject1 == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    localObject2 = localObject1;
    if (localObject1 == locala)
    {
      AppMethodBeat.o(323021);
      return locala;
      ResultKt.throwOnFailure(localObject2);
    }
    AppMethodBeat.o(323021);
    return localObject2;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    int label;
    
    a(k paramk, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322974);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.ujw.e(0, (kotlin.d.d)this);
      AppMethodBeat.o(322974);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(gkf paramgkf, WeakReference<kotlinx.coroutines.p<l>> paramWeakReference)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.manage.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.f;
import com.tencent.mm.protocal.protobuf.bqi;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class MemberHistoryCardListViewModel
  extends CardsViewModel
{
  public static final MemberHistoryCardListViewModel.a qjC;
  private final int qhC;
  private bqi qjB;
  private final int qja;
  private int qjb;
  private final ArrayList<a> qjk;
  
  static
  {
    AppMethodBeat.i(201723);
    qjC = new MemberHistoryCardListViewModel.a((byte)0);
    AppMethodBeat.o(201723);
  }
  
  public MemberHistoryCardListViewModel()
  {
    AppMethodBeat.i(201722);
    this.qhC = 10;
    this.qja = 5;
    this.qjk = new ArrayList();
    this.qiQ.postValue(e.qjn);
    AppMethodBeat.o(201722);
  }
  
  private final ArrayList<a> d(List<? extends ua> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(201716);
    if (paramList != null)
    {
      if (!paramBoolean) {}
      for (ArrayList localArrayList = new ArrayList();; localArrayList = this.qjk)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          ua localua = (ua)paramList.next();
          a locala = new a();
          locala.qiw = localua;
          locala.type = 4;
          localArrayList.add(locala);
        }
      }
      AppMethodBeat.o(201716);
      return localArrayList;
    }
    AppMethodBeat.o(201716);
    return null;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(201719);
    p.h(parama, "cardDataModel");
    Object localObject = parama.qiw;
    if (localObject != null)
    {
      Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card: %s", new Object[] { ((ua)localObject).KDM });
      e locale = (e)this.qiQ.getValue();
      if ((locale == e.qjo) || (locale == e.qjp))
      {
        AppMethodBeat.o(201719);
        return;
      }
      this.qiR.postValue(Boolean.TRUE);
      this.qiQ.postValue(e.qjp);
      localObject = ((ua)localObject).KDM;
      p.g(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.a.b((String)localObject).aYI().b((com.tencent.mm.vending.c.a)new c(locale, this, parama));
      AppMethodBeat.o(201719);
      return;
    }
    AppMethodBeat.o(201719);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(201717);
    p.h(paramb, "keeper");
    Object localObject = (e)this.qiQ.getValue();
    if ((localObject == e.qjo) || (localObject == e.qjp) || (localObject == e.qjr))
    {
      AppMethodBeat.o(201717);
      return;
    }
    this.qiQ.postValue(e.qjo);
    int i;
    if (this.qjb > 0)
    {
      int j = this.qjb;
      i = j;
      if (j < this.qhC) {
        i = this.qhC;
      }
      i += this.qjb;
      localObject = new com.tencent.mm.plugin.card.model.c.d(l, i).aYH().aYI();
      p.g(localObject, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
      com.tencent.mm.ac.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this)).b(paramb);
      AppMethodBeat.o(201717);
      return;
    }
    localObject = this.qjB;
    if (localObject != null) {}
    for (l = ((bqi)localObject).LUJ;; l = 0L)
    {
      i = this.qhC;
      break;
    }
  }
  
  public final void cxu()
  {
    AppMethodBeat.i(201720);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
    localObject = a.a.cun();
    if (localObject != null)
    {
      this.qiN.postValue(((bqi)localObject).LUK);
      localObject = ((bqi)localObject).iAd;
      p.g(localObject, "items");
      localObject = d((List)localObject, false);
      if (localObject != null) {}
      for (int i = ((ArrayList)localObject).size();; i = 0)
      {
        this.qjb = i;
        this.qiP.postValue(localObject);
        AppMethodBeat.o(201720);
        return;
      }
    }
    AppMethodBeat.o(201720);
  }
  
  public final void cxv()
  {
    AppMethodBeat.i(201721);
    bqi localbqi = this.qjB;
    if (localbqi != null)
    {
      Object localObject = new LinkedList();
      if (!((Collection)this.qjk).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.qjk.iterator();
        while (localIterator.hasNext())
        {
          ua localua = ((a)localIterator.next()).qiw;
          if (localua != null) {
            ((LinkedList)localObject).add(localua);
          }
        }
      }
      localbqi.iAd = ((LinkedList)localObject);
      localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
      p.h(localbqi, "response");
      Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save coupon History card list snapshot");
      com.tencent.mm.ac.d.i((kotlin.g.a.a)new a.a.f(localbqi));
      AppMethodBeat.o(201721);
      return;
    }
    AppMethodBeat.o(201721);
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(201718);
    p.h(paramb, "keeper");
    Object localObject = (e)this.qiQ.getValue();
    if ((localObject == e.qjo) || (localObject == e.qjp))
    {
      AppMethodBeat.o(201718);
      return;
    }
    this.qiQ.postValue(e.qjo);
    int i = 0;
    if (this.qjb > 0) {
      i = this.qjb;
    }
    for (;;)
    {
      int j = i;
      if (i < this.qhC) {
        j = this.qhC;
      }
      i = this.qja;
      this.qjk.clear();
      localObject = new com.tencent.mm.plugin.card.model.c.d(0L, j + i).aYH().aYI();
      p.g(localObject, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
      com.tencent.mm.ac.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(201718);
      return;
      if (this.qjk.size() > 0) {
        i = this.qjk.size() + 0;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<c.a<bqi>, x>
  {
    b(MemberHistoryCardListViewModel paramMemberHistoryCardListViewModel)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel$performDeleteCard$1$1"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(e parame, MemberHistoryCardListViewModel paramMemberHistoryCardListViewModel, a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<bqi>, x>
  {
    d(MemberHistoryCardListViewModel paramMemberHistoryCardListViewModel)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.MemberHistoryCardListViewModel
 * JD-Core Version:    0.7.0.1
 */
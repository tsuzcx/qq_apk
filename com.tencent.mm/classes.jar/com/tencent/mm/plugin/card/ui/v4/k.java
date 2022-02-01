package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.f;
import com.tencent.mm.protocal.protobuf.byc;
import com.tencent.mm.protocal.protobuf.uc;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class k
  extends d
{
  public static final k.a tFy;
  private final int tDy;
  private final int tEW;
  private int tEX;
  private final ArrayList<a> tFg;
  private byc tFx;
  
  static
  {
    AppMethodBeat.i(245104);
    tFy = new k.a((byte)0);
    AppMethodBeat.o(245104);
  }
  
  public k()
  {
    AppMethodBeat.i(245102);
    this.tDy = 10;
    this.tEW = 5;
    this.tFg = new ArrayList();
    this.tEM.L(h.tFj);
    AppMethodBeat.o(245102);
  }
  
  private final ArrayList<a> c(List<? extends uc> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(245089);
    if (paramList != null)
    {
      if (!paramBoolean) {}
      for (ArrayList localArrayList = new ArrayList();; localArrayList = this.tFg)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          uc localuc = (uc)paramList.next();
          a locala = new a();
          locala.tEs = localuc;
          locala.type = 4;
          localArrayList.add(locala);
        }
      }
      AppMethodBeat.o(245089);
      return localArrayList;
    }
    AppMethodBeat.o(245089);
    return null;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(245096);
    p.k(parama, "cardDataModel");
    Object localObject = parama.tEs;
    if (localObject != null)
    {
      Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card: %s", new Object[] { ((uc)localObject).RFf });
      h localh = (h)this.tEM.getValue();
      if ((localh == h.tFk) || (localh == h.tFl))
      {
        AppMethodBeat.o(245096);
        return;
      }
      this.tEN.L(Boolean.TRUE);
      this.tEM.L(h.tFl);
      localObject = ((uc)localObject).RFf;
      p.j(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.a.b((String)localObject).bhW().b((com.tencent.mm.vending.c.a)new c(localh, this, parama));
      AppMethodBeat.o(245096);
      return;
    }
    AppMethodBeat.o(245096);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(245091);
    p.k(paramb, "keeper");
    Object localObject = (h)this.tEM.getValue();
    if ((localObject == h.tFk) || (localObject == h.tFl) || (localObject == h.tFn))
    {
      AppMethodBeat.o(245091);
      return;
    }
    this.tEM.L(h.tFk);
    int i;
    if (this.tEX > 0)
    {
      int j = this.tEX;
      i = j;
      if (j < this.tDy) {
        i = this.tDy;
      }
      i += this.tEX;
      localObject = new com.tencent.mm.plugin.card.model.c.d(l, i).bhV().bhW();
      p.j(localObject, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this)).b(paramb);
      AppMethodBeat.o(245091);
      return;
    }
    localObject = this.tFx;
    if (localObject != null) {}
    for (l = ((byc)localObject).Tdr;; l = 0L)
    {
      i = this.tDy;
      break;
    }
  }
  
  public final void cKW()
  {
    AppMethodBeat.i(245098);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.trh;
    localObject = a.a.cHP();
    if (localObject != null)
    {
      this.tEJ.L(((byc)localObject).Tds);
      localObject = ((byc)localObject).lpz;
      p.j(localObject, "items");
      localObject = c((List)localObject, false);
      if (localObject != null) {}
      for (int i = ((ArrayList)localObject).size();; i = 0)
      {
        this.tEX = i;
        this.tEL.L(localObject);
        AppMethodBeat.o(245098);
        return;
      }
    }
    AppMethodBeat.o(245098);
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(245101);
    byc localbyc = this.tFx;
    if (localbyc != null)
    {
      Object localObject = new LinkedList();
      if (!((Collection)this.tFg).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.tFg.iterator();
        while (localIterator.hasNext())
        {
          uc localuc = ((a)localIterator.next()).tEs;
          if (localuc != null) {
            ((LinkedList)localObject).add(localuc);
          }
        }
      }
      localbyc.lpz = ((LinkedList)localObject);
      localObject = com.tencent.mm.plugin.card.model.a.a.trh;
      p.k(localbyc, "response");
      Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save coupon History card list snapshot");
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new a.a.f(localbyc));
      AppMethodBeat.o(245101);
      return;
    }
    AppMethodBeat.o(245101);
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(245094);
    p.k(paramb, "keeper");
    Object localObject = (h)this.tEM.getValue();
    if ((localObject == h.tFk) || (localObject == h.tFl))
    {
      AppMethodBeat.o(245094);
      return;
    }
    this.tEM.L(h.tFk);
    int i = 0;
    if (this.tEX > 0) {
      i = this.tEX;
    }
    for (;;)
    {
      int j = i;
      if (i < this.tDy) {
        j = this.tDy;
      }
      i = this.tEW;
      this.tFg.clear();
      localObject = new com.tencent.mm.plugin.card.model.c.d(0L, j + i).bhV().bhW();
      p.j(localObject, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(245094);
      return;
      if (this.tFg.size() > 0) {
        i = this.tFg.size() + 0;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<c.a<byc>, x>
  {
    b(k paramk)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCardInInvalidListResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel$performDeleteCard$1$1"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(h paramh, k paramk, a parama) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<byc>, x>
  {
    d(k paramk)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.c;
import com.tencent.mm.plugin.card.model.c.e;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "Lcom/tencent/mm/protocal/protobuf/CouponAndGiftList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class g
  extends d
{
  public static final g.a tFh;
  private final int tDy;
  private final int tEW;
  private int tEX;
  private btf tFf;
  private final ArrayList<a> tFg;
  
  static
  {
    AppMethodBeat.i(250033);
    tFh = new g.a((byte)0);
    AppMethodBeat.o(250033);
  }
  
  public g()
  {
    AppMethodBeat.i(250032);
    this.tDy = 10;
    this.tEW = 5;
    this.tFg = new ArrayList();
    this.tEM.L(h.tFj);
    AppMethodBeat.o(250032);
  }
  
  private final ArrayList<a> a(aeb paramaeb, boolean paramBoolean)
  {
    AppMethodBeat.i(250023);
    if (paramaeb != null)
    {
      ArrayList localArrayList;
      label29:
      a locala;
      if (!paramBoolean)
      {
        localArrayList = new ArrayList();
        paramaeb = paramaeb.lpz.iterator();
        if (!paramaeb.hasNext()) {
          break label107;
        }
        uc localuc = (uc)paramaeb.next();
        locala = new a();
        locala.tEs = localuc;
        if (localuc.Seh != 1) {
          break label98;
        }
      }
      label98:
      for (locala.type = 5;; locala.type = 3)
      {
        localArrayList.add(locala);
        break label29;
        localArrayList = this.tFg;
        break;
      }
      label107:
      AppMethodBeat.o(250023);
      return localArrayList;
    }
    AppMethodBeat.o(250023);
    return null;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(250028);
    p.k(parama, "cardDataModel");
    Object localObject = parama.tEs;
    if (localObject != null)
    {
      Log.i("MicroMsg.HistoryCardListViewModel", "do delete card: %s", new Object[] { ((uc)localObject).RFf });
      h localh = (h)this.tEM.getValue();
      if ((localh == h.tFk) || (localh == h.tFl))
      {
        AppMethodBeat.o(250028);
        return;
      }
      this.tEN.L(Boolean.TRUE);
      this.tEM.L(h.tFl);
      localObject = ((uc)localObject).RFf;
      p.j(localObject, "user_card_id");
      new e((String)localObject).bhW().b((com.tencent.mm.vending.c.a)new c(localh, this, parama));
      AppMethodBeat.o(250028);
      return;
    }
    AppMethodBeat.o(250028);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(250024);
    p.k(paramb, "keeper");
    Object localObject = (h)this.tEM.getValue();
    if ((localObject == h.tFk) || (localObject == h.tFl) || (localObject == h.tFn))
    {
      AppMethodBeat.o(250024);
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
      localObject = new com.tencent.mm.plugin.card.model.c.b(l, i).bhV().bhW();
      p.j(localObject, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this)).b(paramb);
      AppMethodBeat.o(250024);
      return;
    }
    localObject = this.tFf;
    if (localObject != null) {}
    for (l = ((btf)localObject).Tdr;; l = 0L)
    {
      i = this.tDy;
      break;
    }
  }
  
  public final void cKW()
  {
    int i = 0;
    AppMethodBeat.i(250029);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.trh;
    localObject = a.a.cHO();
    if (localObject != null)
    {
      this.tEJ.L(((btf)localObject).Tds);
      localObject = ((btf)localObject).Tdt;
      p.j(localObject, "items_list");
      localObject = a((aeb)localObject, false);
      if (localObject != null) {
        i = ((ArrayList)localObject).size();
      }
      this.tEX = i;
      this.tEL.L(localObject);
      AppMethodBeat.o(250029);
      return;
    }
    AppMethodBeat.o(250029);
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(250030);
    btf localbtf = this.tFf;
    if (localbtf != null)
    {
      Object localObject = new aeb();
      if (!((Collection)this.tFg).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.tFg.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.tEs != null) {
            ((aeb)localObject).lpz.add(locala.tEs);
          }
        }
      }
      localbtf.Tdt = ((aeb)localObject);
      localObject = com.tencent.mm.plugin.card.model.a.a.trh;
      p.k(localbtf, "response");
      Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save coupon History card list snapshot");
      com.tencent.mm.ae.d.h((kotlin.g.a.a)new a.a.c(localbtf));
      AppMethodBeat.o(250030);
      return;
    }
    AppMethodBeat.o(250030);
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(250027);
    p.k(paramb, "keeper");
    Object localObject = (h)this.tEM.getValue();
    if ((localObject == h.tFk) || (localObject == h.tFl))
    {
      AppMethodBeat.o(250027);
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
      localObject = new com.tencent.mm.plugin.card.model.c.b(0L, j + i).bhV().bhW();
      p.j(localObject, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(250027);
      return;
      if (this.tFg.size() > 0) {
        i = this.tFg.size() + 0;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<c.a<btf>, x>
  {
    b(g paramg)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCouponResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel$performDeleteCard$1$1"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(h paramh, g paramg, a parama) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<btf>, x>
  {
    d(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.g
 * JD-Core Version:    0.7.0.1
 */
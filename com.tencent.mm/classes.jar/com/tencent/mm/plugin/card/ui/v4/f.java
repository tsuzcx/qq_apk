package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.c.a;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.protocal.protobuf.aeb;
import com.tencent.mm.protocal.protobuf.bth;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCouponCards", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mGiftCards", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "response", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class f
  extends d
{
  public static final f.a tFb;
  private final int tDy;
  private final int tEW;
  private int tEX;
  private bth tEY;
  private final ArrayList<a> tEZ;
  private final ArrayList<a> tFa;
  
  static
  {
    AppMethodBeat.i(244296);
    tFb = new f.a((byte)0);
    AppMethodBeat.o(244296);
  }
  
  public f()
  {
    AppMethodBeat.i(244295);
    this.tDy = 10;
    this.tEW = 5;
    this.tEZ = new ArrayList();
    this.tFa = new ArrayList();
    this.tEM.L(h.tFj);
    AppMethodBeat.o(244295);
  }
  
  private final ArrayList<a> a(bth parambth, boolean paramBoolean)
  {
    AppMethodBeat.i(244287);
    if (parambth != null)
    {
      ArrayList localArrayList2 = new ArrayList();
      Object localObject1;
      ArrayList localArrayList1;
      label44:
      Object localObject2;
      Object localObject3;
      if (!paramBoolean)
      {
        localObject1 = new ArrayList();
        if (paramBoolean) {
          break label203;
        }
        localArrayList1 = new ArrayList();
        localObject2 = parambth.Tdu;
        if (localObject2 == null) {
          break label217;
        }
        localObject3 = ((aeb)localObject2).lpz;
        p.j(localObject3, "items");
        if (((Collection)localObject3).isEmpty()) {
          break label212;
        }
      }
      label203:
      label212:
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label217;
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          localObject3 = new a();
          ((a)localObject3).type = 0;
          ((a)localObject3).title = ((aeb)localObject2).SqI;
          ((ArrayList)localObject1).add(localObject3);
        }
        localObject2 = ((aeb)localObject2).lpz.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (uc)((Iterator)localObject2).next();
          a locala = new a();
          locala.tEs = ((uc)localObject3);
          locala.type = 2;
          ((ArrayList)localObject1).add(locala);
        }
        localObject1 = this.tEZ;
        break;
        localArrayList1 = this.tFa;
        break label44;
      }
      label217:
      localArrayList2.addAll((Collection)localObject1);
      parambth = parambth.Tdv;
      if (parambth != null)
      {
        localObject1 = parambth.lpz;
        p.j(localObject1, "items");
        if (!((Collection)localObject1).isEmpty()) {}
        for (i = 1; i != 0; i = 0)
        {
          if (localArrayList1.isEmpty())
          {
            localObject1 = new a();
            ((a)localObject1).type = 0;
            ((a)localObject1).title = parambth.SqI;
            localArrayList1.add(localObject1);
          }
          parambth = parambth.lpz.iterator();
          while (parambth.hasNext())
          {
            localObject1 = (uc)parambth.next();
            localObject2 = new a();
            ((a)localObject2).tEs = ((uc)localObject1);
            ((a)localObject2).type = 1;
            localArrayList1.add(localObject2);
          }
        }
      }
      localArrayList2.addAll((Collection)localArrayList1);
      AppMethodBeat.o(244287);
      return localArrayList2;
    }
    AppMethodBeat.o(244287);
    return null;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(244292);
    p.k(parama, "cardDataModel");
    Object localObject = parama.tEs;
    if (localObject != null)
    {
      Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card: %s", new Object[] { ((uc)localObject).RFf });
      h localh = (h)this.tEM.getValue();
      if ((localh == h.tFk) || (localh == h.tFl))
      {
        AppMethodBeat.o(244292);
        return;
      }
      this.tEN.L(Boolean.TRUE);
      this.tEM.L(h.tFl);
      localObject = ((uc)localObject).RFf;
      p.j(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.c.a((String)localObject).bhW().b((com.tencent.mm.vending.c.a)new c(localh, this, parama));
    }
    com.tencent.mm.plugin.report.service.h.IzE.a(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
    AppMethodBeat.o(244292);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(244289);
    p.k(paramb, "keeper");
    Object localObject = (h)this.tEM.getValue();
    if ((localObject == h.tFk) || (localObject == h.tFl) || (localObject == h.tFn))
    {
      AppMethodBeat.o(244289);
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
      localObject = new com.tencent.mm.plugin.card.model.c.c(l, i).bhV().bhW();
      p.j(localObject, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this)).b(paramb);
      AppMethodBeat.o(244289);
      return;
    }
    localObject = this.tEY;
    if (localObject != null) {}
    for (l = ((bth)localObject).Tdr;; l = 0L)
    {
      i = this.tDy;
      break;
    }
  }
  
  public final void cKW()
  {
    int i = 0;
    AppMethodBeat.i(244293);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.trh;
    localObject = a.a.cHN();
    if (localObject == null)
    {
      AppMethodBeat.o(244293);
      return;
    }
    this.tEJ.L(((bth)localObject).Tds);
    localObject = a((bth)localObject, false);
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    }
    this.tEX = i;
    this.tEL.L(localObject);
    AppMethodBeat.o(244293);
  }
  
  public final void cKX()
  {
    AppMethodBeat.i(244294);
    bth localbth = this.tEY;
    if (localbth != null)
    {
      aeb localaeb = new aeb();
      if (!((Collection)this.tEZ).isEmpty()) {}
      Object localObject2;
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.tEZ.remove(0);
        p.j(localObject1, "mGiftCards.removeAt(0)");
        localObject1 = (a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = ((a)localObject1).title;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localaeb.SqI = ((String)localObject1);
        localObject1 = this.tEZ.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (((a)localObject2).tEs != null) {
            localaeb.lpz.add(((a)localObject2).tEs);
          }
        }
      }
      localbth.Tdu = localaeb;
      localaeb = new aeb();
      if (!((Collection)this.tFa).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        localObject1 = this.tFa.remove(0);
        p.j(localObject1, "mCouponCards.removeAt(0)");
        localObject1 = (a)localObject1;
        if (localObject1 != null)
        {
          localObject2 = ((a)localObject1).title;
          localObject1 = localObject2;
          if (localObject2 != null) {}
        }
        else
        {
          localObject1 = "";
        }
        localaeb.SqI = ((String)localObject1);
        localObject1 = this.tFa.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (((a)localObject2).tEs != null) {
            localaeb.lpz.add(((a)localObject2).tEs);
          }
        }
      }
      localbth.Tdv = localaeb;
      Object localObject1 = com.tencent.mm.plugin.card.model.a.a.trh;
      a.a.a(localbth);
      AppMethodBeat.o(244294);
      return;
    }
    AppMethodBeat.o(244294);
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(244291);
    p.k(paramb, "keeper");
    Object localObject = (h)this.tEM.getValue();
    if ((localObject == h.tFk) || (localObject == h.tFl))
    {
      AppMethodBeat.o(244291);
      return;
    }
    this.tEM.L(h.tFk);
    int j = 0;
    int i;
    if (this.tEX > 0) {
      i = this.tEX;
    }
    for (;;)
    {
      j = i;
      if (i < this.tDy) {
        j = this.tDy;
      }
      i = this.tEW;
      this.tEZ.clear();
      this.tFa.clear();
      localObject = new com.tencent.mm.plugin.card.model.c.c(0L, j + i).bhV().bhW();
      p.j(localObject, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(244291);
      return;
      if (this.tEZ.size() > 0) {
        j = this.tEZ.size() + 0;
      }
      i = j;
      if (this.tFa.size() > 0) {
        i = j + this.tFa.size();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<c.a<bth>, x>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel$performDeleteCard$1$1"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(h paramh, f paramf, a parama) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<bth>, x>
  {
    d(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.f
 * JD-Core Version:    0.7.0.1
 */
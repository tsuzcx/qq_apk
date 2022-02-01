package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.bly;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCouponCards", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mGiftCards", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "response", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class CouponAndGiftCardListViewModel
  extends CardsViewModel
{
  public static final CouponAndGiftCardListViewModel.a qjf;
  private final int qhC;
  private final int qja;
  private int qjb;
  private bly qjc;
  private final ArrayList<a> qjd;
  private final ArrayList<a> qje;
  
  static
  {
    AppMethodBeat.i(201663);
    qjf = new CouponAndGiftCardListViewModel.a((byte)0);
    AppMethodBeat.o(201663);
  }
  
  public CouponAndGiftCardListViewModel()
  {
    AppMethodBeat.i(201662);
    this.qhC = 10;
    this.qja = 5;
    this.qjd = new ArrayList();
    this.qje = new ArrayList();
    this.qiQ.postValue(e.qjn);
    AppMethodBeat.o(201662);
  }
  
  private final ArrayList<a> a(bly parambly, boolean paramBoolean)
  {
    AppMethodBeat.i(201656);
    if (parambly != null)
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
        localObject2 = parambly.LUM;
        if (localObject2 == null) {
          break label217;
        }
        localObject3 = ((adu)localObject2).iAd;
        p.g(localObject3, "items");
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
          ((a)localObject3).title = ((adu)localObject2).Lpm;
          ((ArrayList)localObject1).add(localObject3);
        }
        localObject2 = ((adu)localObject2).iAd.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ua)((Iterator)localObject2).next();
          a locala = new a();
          locala.qiw = ((ua)localObject3);
          locala.type = 2;
          ((ArrayList)localObject1).add(locala);
        }
        localObject1 = this.qjd;
        break;
        localArrayList1 = this.qje;
        break label44;
      }
      label217:
      localArrayList2.addAll((Collection)localObject1);
      parambly = parambly.LUN;
      if (parambly != null)
      {
        localObject1 = parambly.iAd;
        p.g(localObject1, "items");
        if (!((Collection)localObject1).isEmpty()) {}
        for (i = 1; i != 0; i = 0)
        {
          if (localArrayList1.isEmpty())
          {
            localObject1 = new a();
            ((a)localObject1).type = 0;
            ((a)localObject1).title = parambly.Lpm;
            localArrayList1.add(localObject1);
          }
          parambly = parambly.iAd.iterator();
          while (parambly.hasNext())
          {
            localObject1 = (ua)parambly.next();
            localObject2 = new a();
            ((a)localObject2).qiw = ((ua)localObject1);
            ((a)localObject2).type = 1;
            localArrayList1.add(localObject2);
          }
        }
      }
      localArrayList2.addAll((Collection)localArrayList1);
      AppMethodBeat.o(201656);
      return localArrayList2;
    }
    AppMethodBeat.o(201656);
    return null;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(201659);
    p.h(parama, "cardDataModel");
    Object localObject = parama.qiw;
    if (localObject != null)
    {
      Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card: %s", new Object[] { ((ua)localObject).KDM });
      e locale = (e)this.qiQ.getValue();
      if ((locale == e.qjo) || (locale == e.qjp))
      {
        AppMethodBeat.o(201659);
        return;
      }
      this.qiR.postValue(Boolean.TRUE);
      this.qiQ.postValue(e.qjp);
      localObject = ((ua)localObject).KDM;
      p.g(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.c.a((String)localObject).aYI().b((com.tencent.mm.vending.c.a)new c(locale, this, parama));
    }
    h.CyF.a(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
    AppMethodBeat.o(201659);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(201657);
    p.h(paramb, "keeper");
    Object localObject = (e)this.qiQ.getValue();
    if ((localObject == e.qjo) || (localObject == e.qjp) || (localObject == e.qjr))
    {
      AppMethodBeat.o(201657);
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
      localObject = new com.tencent.mm.plugin.card.model.c.c(l, i).aYH().aYI();
      p.g(localObject, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this)).b(paramb);
      AppMethodBeat.o(201657);
      return;
    }
    localObject = this.qjc;
    if (localObject != null) {}
    for (l = ((bly)localObject).LUJ;; l = 0L)
    {
      i = this.qhC;
      break;
    }
  }
  
  public final void cxu()
  {
    int i = 0;
    AppMethodBeat.i(201660);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
    localObject = a.a.cul();
    if (localObject == null)
    {
      AppMethodBeat.o(201660);
      return;
    }
    this.qiN.postValue(((bly)localObject).LUK);
    localObject = a((bly)localObject, false);
    if (localObject != null) {
      i = ((ArrayList)localObject).size();
    }
    this.qjb = i;
    this.qiP.postValue(localObject);
    AppMethodBeat.o(201660);
  }
  
  public final void cxv()
  {
    AppMethodBeat.i(201661);
    bly localbly = this.qjc;
    if (localbly != null)
    {
      adu localadu = new adu();
      if (!((Collection)this.qjd).isEmpty()) {}
      Object localObject2;
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.qjd.remove(0);
        p.g(localObject1, "mGiftCards.removeAt(0)");
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
        localadu.Lpm = ((String)localObject1);
        localObject1 = this.qjd.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (((a)localObject2).qiw != null) {
            localadu.iAd.add(((a)localObject2).qiw);
          }
        }
      }
      localbly.LUM = localadu;
      localadu = new adu();
      if (!((Collection)this.qje).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        localObject1 = this.qje.remove(0);
        p.g(localObject1, "mCouponCards.removeAt(0)");
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
        localadu.Lpm = ((String)localObject1);
        localObject1 = this.qje.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (((a)localObject2).qiw != null) {
            localadu.iAd.add(((a)localObject2).qiw);
          }
        }
      }
      localbly.LUN = localadu;
      Object localObject1 = com.tencent.mm.plugin.card.model.a.a.pVg;
      a.a.a(localbly);
      AppMethodBeat.o(201661);
      return;
    }
    AppMethodBeat.o(201661);
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(201658);
    p.h(paramb, "keeper");
    Object localObject = (e)this.qiQ.getValue();
    if ((localObject == e.qjo) || (localObject == e.qjp))
    {
      AppMethodBeat.o(201658);
      return;
    }
    this.qiQ.postValue(e.qjo);
    int j = 0;
    int i;
    if (this.qjb > 0) {
      i = this.qjb;
    }
    for (;;)
    {
      j = i;
      if (i < this.qhC) {
        j = this.qhC;
      }
      i = this.qja;
      this.qjd.clear();
      this.qje.clear();
      localObject = new com.tencent.mm.plugin.card.model.c.c(0L, j + i).aYH().aYI();
      p.g(localObject, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(201658);
      return;
      if (this.qjd.size() > 0) {
        j = this.qjd.size() + 0;
      }
      i = j;
      if (this.qje.size() > 0) {
        i = j + this.qje.size();
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<c.a<bly>, x>
  {
    b(CouponAndGiftCardListViewModel paramCouponAndGiftCardListViewModel)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/DeleteCouponResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel$performDeleteCard$1$1"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(e parame, CouponAndGiftCardListViewModel paramCouponAndGiftCardListViewModel, a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<bly>, x>
  {
    d(CouponAndGiftCardListViewModel paramCouponAndGiftCardListViewModel)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponAndGiftCardListViewModel
 * JD-Core Version:    0.7.0.1
 */
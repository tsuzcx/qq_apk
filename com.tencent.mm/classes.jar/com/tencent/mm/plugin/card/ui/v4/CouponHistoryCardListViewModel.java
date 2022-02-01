package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.c;
import com.tencent.mm.protocal.protobuf.adu;
import com.tencent.mm.protocal.protobuf.blw;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "Lcom/tencent/mm/protocal/protobuf/CouponAndGiftList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"})
public final class CouponHistoryCardListViewModel
  extends CardsViewModel
{
  public static final CouponHistoryCardListViewModel.a qjl;
  private final int qhC;
  private final int qja;
  private int qjb;
  private blw qjj;
  private final ArrayList<a> qjk;
  
  static
  {
    AppMethodBeat.i(201676);
    qjl = new CouponHistoryCardListViewModel.a((byte)0);
    AppMethodBeat.o(201676);
  }
  
  public CouponHistoryCardListViewModel()
  {
    AppMethodBeat.i(201675);
    this.qhC = 10;
    this.qja = 5;
    this.qjk = new ArrayList();
    this.qiQ.postValue(e.qjn);
    AppMethodBeat.o(201675);
  }
  
  private final ArrayList<a> a(adu paramadu, boolean paramBoolean)
  {
    AppMethodBeat.i(201669);
    if (paramadu != null)
    {
      ArrayList localArrayList;
      label29:
      a locala;
      if (!paramBoolean)
      {
        localArrayList = new ArrayList();
        paramadu = paramadu.iAd.iterator();
        if (!paramadu.hasNext()) {
          break label107;
        }
        ua localua = (ua)paramadu.next();
        locala = new a();
        locala.qiw = localua;
        if (localua.LcU != 1) {
          break label98;
        }
      }
      label98:
      for (locala.type = 5;; locala.type = 3)
      {
        localArrayList.add(locala);
        break label29;
        localArrayList = this.qjk;
        break;
      }
      label107:
      AppMethodBeat.o(201669);
      return localArrayList;
    }
    AppMethodBeat.o(201669);
    return null;
  }
  
  public final void a(final a parama)
  {
    AppMethodBeat.i(201672);
    p.h(parama, "cardDataModel");
    Object localObject = parama.qiw;
    if (localObject != null)
    {
      Log.i("MicroMsg.HistoryCardListViewModel", "do delete card: %s", new Object[] { ((ua)localObject).KDM });
      e locale = (e)this.qiQ.getValue();
      if ((locale == e.qjo) || (locale == e.qjp))
      {
        AppMethodBeat.o(201672);
        return;
      }
      this.qiR.postValue(Boolean.TRUE);
      this.qiQ.postValue(e.qjp);
      localObject = ((ua)localObject).KDM;
      p.g(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.c.e((String)localObject).aYI().b((com.tencent.mm.vending.c.a)new c(locale, this, parama));
      AppMethodBeat.o(201672);
      return;
    }
    AppMethodBeat.o(201672);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(201670);
    p.h(paramb, "keeper");
    Object localObject = (e)this.qiQ.getValue();
    if ((localObject == e.qjo) || (localObject == e.qjp) || (localObject == e.qjr))
    {
      AppMethodBeat.o(201670);
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
      localObject = new com.tencent.mm.plugin.card.model.c.b(l, i).aYH().aYI();
      p.g(localObject, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new d(this)).b(paramb);
      AppMethodBeat.o(201670);
      return;
    }
    localObject = this.qjj;
    if (localObject != null) {}
    for (l = ((blw)localObject).LUJ;; l = 0L)
    {
      i = this.qhC;
      break;
    }
  }
  
  public final void cxu()
  {
    int i = 0;
    AppMethodBeat.i(201673);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
    localObject = a.a.cum();
    if (localObject != null)
    {
      this.qiN.postValue(((blw)localObject).LUK);
      localObject = ((blw)localObject).LUL;
      p.g(localObject, "items_list");
      localObject = a((adu)localObject, false);
      if (localObject != null) {
        i = ((ArrayList)localObject).size();
      }
      this.qjb = i;
      this.qiP.postValue(localObject);
      AppMethodBeat.o(201673);
      return;
    }
    AppMethodBeat.o(201673);
  }
  
  public final void cxv()
  {
    AppMethodBeat.i(201674);
    blw localblw = this.qjj;
    if (localblw != null)
    {
      Object localObject = new adu();
      if (!((Collection)this.qjk).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.qjk.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.qiw != null) {
            ((adu)localObject).iAd.add(locala.qiw);
          }
        }
      }
      localblw.LUL = ((adu)localObject);
      localObject = com.tencent.mm.plugin.card.model.a.a.pVg;
      p.h(localblw, "response");
      Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save coupon History card list snapshot");
      d.i((kotlin.g.a.a)new a.a.c(localblw));
      AppMethodBeat.o(201674);
      return;
    }
    AppMethodBeat.o(201674);
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(201671);
    p.h(paramb, "keeper");
    Object localObject = (e)this.qiQ.getValue();
    if ((localObject == e.qjo) || (localObject == e.qjp))
    {
      AppMethodBeat.o(201671);
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
      localObject = new com.tencent.mm.plugin.card.model.c.b(0L, j + i).aYH().aYI();
      p.g(localObject, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
      d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(201671);
      return;
      if (this.qjk.size() > 0) {
        i = this.qjk.size() + 0;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.b<c.a<blw>, x>
  {
    b(CouponHistoryCardListViewModel paramCouponHistoryCardListViewModel)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/RemoveCouponResponse;", "kotlin.jvm.PlatformType", "call", "com/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel$performDeleteCard$1$1"})
  static final class c<_Ret, _Var>
    implements com.tencent.mm.vending.c.a<_Ret, _Var>
  {
    c(e parame, CouponHistoryCardListViewModel paramCouponHistoryCardListViewModel, a parama) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.b<c.a<blw>, x>
  {
    d(CouponHistoryCardListViewModel paramCouponHistoryCardListViewModel)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CouponHistoryCardListViewModel
 * JD-Core Version:    0.7.0.1
 */
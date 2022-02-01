package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.f;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.cnf;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/MemberHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "", "Lcom/tencent/mm/protocal/protobuf/CardElementCouponList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends d
{
  public static final i.a wIW;
  private final int wHx;
  private final ArrayList<a> wIG;
  private cnf wIX;
  private final int wIy;
  private int wIz;
  
  static
  {
    AppMethodBeat.i(294445);
    wIW = new i.a((byte)0);
    AppMethodBeat.o(294445);
  }
  
  public i()
  {
    AppMethodBeat.i(294364);
    this.wHx = 10;
    this.wIy = 5;
    this.wIG = new ArrayList();
    this.wIp.t(g.wII);
    AppMethodBeat.o(294364);
  }
  
  private static final ah a(i parami, g paramg, a parama, b.a parama1)
  {
    Object localObject2 = null;
    AppMethodBeat.i(294397);
    s.u(parami, "this$0");
    s.u(parama, "$cardDataModel");
    Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card, errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama1.errType), Integer.valueOf(parama1.errCode) });
    String str = "";
    parami.wIq.t(Boolean.FALSE);
    Object localObject1 = str;
    if (parama1.errType == 0)
    {
      localObject1 = str;
      if (parama1.errCode == 0)
      {
        localObject1 = (ajj)parama1.ott;
        Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card, retCode: %s", new Object[] { Integer.valueOf(((ajj)localObject1).wuz) });
        if (((ajj)localObject1).wuz == 0)
        {
          parami.wIp.t(paramg);
          paramg = parami.wIo;
          parama1 = parami.wIG;
          if (parama1 == null)
          {
            parami = null;
            localObject1 = new StringBuilder("remove card, is removed: ").append(parami).append(", data type: ").append(parama.type).append(", errMsg: ");
            parami = parama.wIa;
            if (parami != null) {
              break label236;
            }
          }
          label236:
          for (parami = localObject2;; parami = parami.YBH)
          {
            Log.i("MicroMsg.MemberHistoryCardListViewModel", parami);
            paramg.t(parama1);
            parami = ah.aiuX;
            AppMethodBeat.o(294397);
            return parami;
            parami = Boolean.valueOf(parama1.remove(parama));
            break;
          }
        }
        localObject1 = ((ajj)parama1.ott).wuA;
        s.s(localObject1, "it.resp.ret_msg");
      }
    }
    g.wIN.alk((String)localObject1);
    parami.wIp.t(g.wIN);
    parami = ah.aiuX;
    AppMethodBeat.o(294397);
    return parami;
  }
  
  private final ArrayList<a> g(List<? extends vt> paramList, boolean paramBoolean)
  {
    AppMethodBeat.i(294379);
    if (paramList != null)
    {
      if (!paramBoolean) {}
      for (ArrayList localArrayList = new ArrayList();; localArrayList = this.wIG)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          vt localvt = (vt)paramList.next();
          a locala = new a();
          locala.wIa = localvt;
          locala.type = 4;
          localArrayList.add(locala);
        }
      }
      AppMethodBeat.o(294379);
      return localArrayList;
    }
    AppMethodBeat.o(294379);
    return null;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(294485);
    s.u(parama, "cardDataModel");
    Object localObject = parama.wIa;
    if (localObject != null)
    {
      Log.i("MicroMsg.MemberHistoryCardListViewModel", "do delete card: %s", new Object[] { ((vt)localObject).YBH });
      g localg = (g)this.wIp.getValue();
      if ((localg == g.wIJ) || (localg == g.wIK))
      {
        AppMethodBeat.o(294485);
        return;
      }
      this.wIq.t(Boolean.TRUE);
      this.wIp.t(g.wIK);
      localObject = ((vt)localObject).YBH;
      s.s(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.a.b((String)localObject).bFJ().b(new i..ExternalSyntheticLambda0(this, localg, parama));
    }
    AppMethodBeat.o(294485);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(294472);
    s.u(paramb, "keeper");
    Object localObject = (g)this.wIp.getValue();
    if ((localObject == g.wIJ) || (localObject == g.wIK) || (localObject == g.wIM))
    {
      AppMethodBeat.o(294472);
      return;
    }
    this.wIp.t(g.wIJ);
    int i;
    if (this.wIz > 0)
    {
      int j = this.wIz;
      i = j;
      if (j < this.wHx) {
        i = this.wHx;
      }
      i += this.wIz;
      localObject = new com.tencent.mm.plugin.card.model.c.d(l, i);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      s.s(localObject, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((c)localObject, (kotlin.g.a.b)new c(this)).b(paramb);
      AppMethodBeat.o(294472);
      return;
    }
    localObject = this.wIX;
    if (localObject == null) {}
    for (l = 0L;; l = ((cnf)localObject).aaqG)
    {
      i = this.wHx;
      break;
    }
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(294478);
    s.u(paramb, "keeper");
    Object localObject = (g)this.wIp.getValue();
    if ((localObject == g.wIJ) || (localObject == g.wIK))
    {
      AppMethodBeat.o(294478);
      return;
    }
    this.wIp.t(g.wIJ);
    int i = 0;
    if (this.wIz > 0) {
      i = this.wIz;
    }
    for (;;)
    {
      int j = i;
      if (i < this.wHx) {
        j = this.wHx;
      }
      i = this.wIy;
      this.wIG.clear();
      localObject = new com.tencent.mm.plugin.card.model.c.d(0L, j + i);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      s.s(localObject, "CgiGetMemberCardHistoryR…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(294478);
      return;
      if (this.wIG.size() > 0) {
        i = this.wIG.size() + 0;
      }
    }
  }
  
  public final void doC()
  {
    AppMethodBeat.i(294491);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
    localObject = a.a.dlg();
    if (localObject != null)
    {
      this.wIm.t(((cnf)localObject).aaqH);
      localObject = ((cnf)localObject).nUC;
      s.s(localObject, "items");
      localObject = g((List)localObject, false);
      if (localObject != null) {
        break label77;
      }
    }
    label77:
    for (int i = 0;; i = ((ArrayList)localObject).size())
    {
      this.wIz = i;
      this.wIo.t(localObject);
      AppMethodBeat.o(294491);
      return;
    }
  }
  
  public final void doD()
  {
    AppMethodBeat.i(294494);
    cnf localcnf = this.wIX;
    if (localcnf != null)
    {
      Object localObject = new LinkedList();
      if (!((Collection)this.wIG).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.wIG.iterator();
        while (localIterator.hasNext())
        {
          vt localvt = ((a)localIterator.next()).wIa;
          if (localvt != null) {
            ((LinkedList)localObject).add(localvt);
          }
        }
      }
      localcnf.nUC = ((LinkedList)localObject);
      localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
      s.u(localcnf, "response");
      Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save coupon History card list snapshot");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new a.a.f(localcnf));
    }
    AppMethodBeat.o(294494);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<b.a<cnf>, ah>
  {
    b(i parami)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetMemberCardHistoryResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<b.a<cnf>, ah>
  {
    c(i parami)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.i
 * JD-Core Version:    0.7.0.1
 */
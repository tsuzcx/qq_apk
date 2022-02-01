package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.card.model.a.a.a.c;
import com.tencent.mm.plugin.card.model.c.e;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.epq;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vending.g.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CouponHistoryCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCardModels", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "cards", "Lcom/tencent/mm/protocal/protobuf/CouponAndGiftList;", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  extends d
{
  public static final f.a wIE;
  private final int wHx;
  private chy wIF;
  private final ArrayList<a> wIG;
  private final int wIy;
  private int wIz;
  
  static
  {
    AppMethodBeat.i(294407);
    wIE = new f.a((byte)0);
    AppMethodBeat.o(294407);
  }
  
  public f()
  {
    AppMethodBeat.i(294363);
    this.wHx = 10;
    this.wIy = 5;
    this.wIG = new ArrayList();
    this.wIp.t(g.wII);
    AppMethodBeat.o(294363);
  }
  
  private final ArrayList<a> a(agm paramagm, boolean paramBoolean)
  {
    AppMethodBeat.i(294374);
    if (paramagm != null)
    {
      ArrayList localArrayList;
      label29:
      a locala;
      if (!paramBoolean)
      {
        localArrayList = new ArrayList();
        paramagm = paramagm.nUC.iterator();
        if (!paramagm.hasNext()) {
          break label107;
        }
        vt localvt = (vt)paramagm.next();
        locala = new a();
        locala.wIa = localvt;
        if (localvt.Zcd != 1) {
          break label98;
        }
      }
      label98:
      for (locala.type = 5;; locala.type = 3)
      {
        localArrayList.add(locala);
        break label29;
        localArrayList = this.wIG;
        break;
      }
      label107:
      AppMethodBeat.o(294374);
      return localArrayList;
    }
    AppMethodBeat.o(294374);
    return null;
  }
  
  private static final ah a(f paramf, g paramg, a parama, b.a parama1)
  {
    Object localObject2 = null;
    AppMethodBeat.i(294386);
    s.u(paramf, "this$0");
    s.u(parama, "$cardDataModel");
    Log.i("MicroMsg.HistoryCardListViewModel", "do delete card, errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama1.errType), Integer.valueOf(parama1.errCode) });
    String str = "";
    paramf.wIq.t(Boolean.FALSE);
    Object localObject1 = str;
    if (parama1.errType == 0)
    {
      localObject1 = str;
      if (parama1.errCode == 0)
      {
        localObject1 = (epq)parama1.ott;
        Log.i("MicroMsg.HistoryCardListViewModel", "do delete card, retCode: %s", new Object[] { Integer.valueOf(((epq)localObject1).wuz) });
        if (((epq)localObject1).wuz == 0)
        {
          paramf.wIp.t(paramg);
          paramg = paramf.wIo;
          parama1 = paramf.wIG;
          if (parama1 == null)
          {
            paramf = null;
            localObject1 = new StringBuilder("remove card, is removed: ").append(paramf).append(", data type: ").append(parama.type).append(", errMsg: ");
            paramf = parama.wIa;
            if (paramf != null) {
              break label236;
            }
          }
          label236:
          for (paramf = localObject2;; paramf = paramf.YBH)
          {
            Log.i("MicroMsg.HistoryCardListViewModel", paramf);
            paramg.t(parama1);
            paramf = ah.aiuX;
            AppMethodBeat.o(294386);
            return paramf;
            paramf = Boolean.valueOf(parama1.remove(parama));
            break;
          }
        }
        localObject1 = ((epq)parama1.ott).wuA;
        s.s(localObject1, "it.resp.ret_msg");
      }
    }
    g.wIN.alk((String)localObject1);
    paramf.wIp.t(g.wIN);
    paramf = ah.aiuX;
    AppMethodBeat.o(294386);
    return paramf;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(294444);
    s.u(parama, "cardDataModel");
    Object localObject = parama.wIa;
    if (localObject != null)
    {
      Log.i("MicroMsg.HistoryCardListViewModel", "do delete card: %s", new Object[] { ((vt)localObject).YBH });
      g localg = (g)this.wIp.getValue();
      if ((localg == g.wIJ) || (localg == g.wIK))
      {
        AppMethodBeat.o(294444);
        return;
      }
      this.wIq.t(Boolean.TRUE);
      this.wIp.t(g.wIK);
      localObject = ((vt)localObject).YBH;
      s.s(localObject, "user_card_id");
      new e((String)localObject).bFJ().b(new f..ExternalSyntheticLambda0(this, localg, parama));
    }
    AppMethodBeat.o(294444);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(294425);
    s.u(paramb, "keeper");
    Object localObject = (g)this.wIp.getValue();
    if ((localObject == g.wIJ) || (localObject == g.wIK) || (localObject == g.wIM))
    {
      AppMethodBeat.o(294425);
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
      localObject = new com.tencent.mm.plugin.card.model.c.b(l, i);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      s.s(localObject, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((c)localObject, (kotlin.g.a.b)new c(this)).b(paramb);
      AppMethodBeat.o(294425);
      return;
    }
    localObject = this.wIF;
    if (localObject == null) {}
    for (l = 0L;; l = ((chy)localObject).aaqG)
    {
      i = this.wHx;
      break;
    }
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(294436);
    s.u(paramb, "keeper");
    Object localObject = (g)this.wIp.getValue();
    if ((localObject == g.wIJ) || (localObject == g.wIK))
    {
      AppMethodBeat.o(294436);
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
      localObject = new com.tencent.mm.plugin.card.model.c.b(0L, j + i);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      s.s(localObject, "CgiGetCouponAndGiftHisto…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(294436);
      return;
      if (this.wIG.size() > 0) {
        i = this.wIG.size() + 0;
      }
    }
  }
  
  public final void doC()
  {
    int i = 0;
    AppMethodBeat.i(294450);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
    localObject = a.a.dlf();
    if (localObject != null)
    {
      this.wIm.t(((chy)localObject).aaqH);
      localObject = ((chy)localObject).aaqI;
      s.s(localObject, "items_list");
      localObject = a((agm)localObject, false);
      if (localObject != null) {
        break label74;
      }
    }
    for (;;)
    {
      this.wIz = i;
      this.wIo.t(localObject);
      AppMethodBeat.o(294450);
      return;
      label74:
      i = ((ArrayList)localObject).size();
    }
  }
  
  public final void doD()
  {
    AppMethodBeat.i(294459);
    chy localchy = this.wIF;
    if (localchy != null)
    {
      Object localObject = new agm();
      if (!((Collection)this.wIG).isEmpty()) {}
      for (int i = 1; i != 0; i = 0)
      {
        Iterator localIterator = this.wIG.iterator();
        while (localIterator.hasNext())
        {
          a locala = (a)localIterator.next();
          if (locala.wIa != null) {
            ((agm)localObject).nUC.add(locala.wIa);
          }
        }
      }
      localchy.aaqI = ((agm)localObject);
      localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
      s.u(localchy, "response");
      Log.d(com.tencent.mm.plugin.card.model.a.a.access$getTAG$cp(), "save coupon History card list snapshot");
      com.tencent.mm.ae.d.B((kotlin.g.a.a)new a.a.c(localchy));
    }
    AppMethodBeat.o(294459);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<b.a<chy>, ah>
  {
    b(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftHistoryResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<b.a<chy>, ah>
  {
    c(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.f
 * JD-Core Version:    0.7.0.1
 */
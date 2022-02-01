package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.card.model.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.agm;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.cia;
import com.tencent.mm.protocal.protobuf.vt;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CouponAndGiftCardListViewModel;", "Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "()V", "mCacheMoreNum", "", "mCachedSnapSize", "mCouponCards", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "mGiftCards", "mReqNum", "mResponse", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "getCardDataModels", "response", "needAppend", "", "loadSnapshot", "performDeleteCard", "cardDataModel", "refreshCardListIncrementally", "removeCardDataModels", "data", "saveSnapshot", "Companion", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends d
{
  public static final e.a wIx;
  private final int wHx;
  private cia wIA;
  private final ArrayList<a> wIB;
  private final ArrayList<a> wIC;
  private final int wIy;
  private int wIz;
  
  static
  {
    AppMethodBeat.i(294413);
    wIx = new e.a((byte)0);
    AppMethodBeat.o(294413);
  }
  
  public e()
  {
    AppMethodBeat.i(294365);
    this.wHx = 10;
    this.wIy = 5;
    this.wIB = new ArrayList();
    this.wIC = new ArrayList();
    this.wIp.t(g.wII);
    AppMethodBeat.o(294365);
  }
  
  private final ArrayList<a> a(cia paramcia, boolean paramBoolean)
  {
    AppMethodBeat.i(294380);
    if (paramcia != null)
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
        localObject2 = paramcia.aaqJ;
        if (localObject2 == null) {
          break label217;
        }
        localObject3 = ((agm)localObject2).nUC;
        s.s(localObject3, "items");
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
          ((a)localObject3).title = ((agm)localObject2).ZpI;
          ((ArrayList)localObject1).add(localObject3);
        }
        localObject2 = ((agm)localObject2).nUC.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (vt)((Iterator)localObject2).next();
          a locala = new a();
          locala.wIa = ((vt)localObject3);
          locala.type = 2;
          ((ArrayList)localObject1).add(locala);
        }
        localObject1 = this.wIB;
        break;
        localArrayList1 = this.wIC;
        break label44;
      }
      label217:
      localArrayList2.addAll((Collection)localObject1);
      paramcia = paramcia.aaqK;
      if (paramcia != null)
      {
        localObject1 = paramcia.nUC;
        s.s(localObject1, "items");
        if (!((Collection)localObject1).isEmpty()) {}
        for (i = 1; i != 0; i = 0)
        {
          if (localArrayList1.isEmpty())
          {
            localObject1 = new a();
            ((a)localObject1).type = 0;
            ((a)localObject1).title = paramcia.ZpI;
            localArrayList1.add(localObject1);
          }
          paramcia = paramcia.nUC.iterator();
          while (paramcia.hasNext())
          {
            localObject1 = (vt)paramcia.next();
            localObject2 = new a();
            ((a)localObject2).wIa = ((vt)localObject1);
            ((a)localObject2).type = 1;
            localArrayList1.add(localObject2);
          }
        }
      }
      localArrayList2.addAll((Collection)localArrayList1);
      AppMethodBeat.o(294380);
      return localArrayList2;
    }
    AppMethodBeat.o(294380);
    return null;
  }
  
  private static final ah a(e parame, g paramg, a parama, b.a parama1)
  {
    AppMethodBeat.i(294391);
    s.u(parame, "this$0");
    s.u(parama, "$cardDataModel");
    Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card errtype: %s, errcode: %s", new Object[] { Integer.valueOf(parama1.errType), Integer.valueOf(parama1.errCode) });
    Object localObject2 = "";
    parame.wIq.t(Boolean.FALSE);
    Object localObject1 = localObject2;
    if (parama1.errType == 0)
    {
      localObject1 = localObject2;
      if (parama1.errCode == 0)
      {
        localObject1 = (ajm)parama1.ott;
        Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card retCode: %s", new Object[] { Integer.valueOf(((ajm)localObject1).wuz) });
        if (((ajm)localObject1).wuz == 0)
        {
          parame.wIp.t(paramg);
          parama1 = parame.wIo;
          localObject1 = (ArrayList)parame.wIo.getValue();
          boolean bool;
          if (localObject1 == null)
          {
            bool = false;
            localObject2 = new StringBuilder("remove card, is removed: ").append(bool).append(", data type: ").append(parama.type).append(", errMsg: ");
            paramg = parama.wIa;
            if (paramg != null) {
              break label276;
            }
            paramg = null;
            label202:
            Log.i("MicroMsg.CouponAndGiftCardViewModel", paramg);
            if (bool) {
              switch (parama.type)
              {
              }
            }
          }
          for (;;)
          {
            parama1.t(localObject1);
            parame = ah.aiuX;
            AppMethodBeat.o(294391);
            return parame;
            bool = ((ArrayList)localObject1).remove(parama);
            break;
            label276:
            paramg = paramg.YBH;
            break label202;
            parame.wIC.remove(parama);
            if (parame.wIC.size() == 1)
            {
              parame = parame.wIC.remove(0);
              s.s(parame, "mCouponCards.removeAt(0)");
              parame = (a)parame;
              if (localObject1 != null)
              {
                ((ArrayList)localObject1).remove(parame);
                continue;
                parame.wIB.remove(parama);
                if (parame.wIB.size() == 1)
                {
                  parame = parame.wIB.remove(0);
                  s.s(parame, "mGiftCards.removeAt(0)");
                  parame = (a)parame;
                  if (localObject1 != null) {
                    ((ArrayList)localObject1).remove(parame);
                  }
                }
              }
            }
          }
        }
        localObject1 = ((ajm)parama1.ott).wuA;
        s.s(localObject1, "it.resp.ret_msg");
      }
    }
    g.wIN.alk((String)localObject1);
    parame.wIp.t(g.wIN);
    parame = ah.aiuX;
    AppMethodBeat.o(294391);
    return parame;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(294451);
    s.u(parama, "cardDataModel");
    Object localObject = parama.wIa;
    if (localObject != null)
    {
      Log.i("MicroMsg.CouponAndGiftCardViewModel", "do delete card: %s", new Object[] { ((vt)localObject).YBH });
      g localg = (g)this.wIp.getValue();
      if ((localg == g.wIJ) || (localg == g.wIK))
      {
        AppMethodBeat.o(294451);
        return;
      }
      this.wIq.t(Boolean.TRUE);
      this.wIp.t(g.wIK);
      localObject = ((vt)localObject).YBH;
      s.s(localObject, "user_card_id");
      new com.tencent.mm.plugin.card.model.c.a((String)localObject).bFJ().b(new e..ExternalSyntheticLambda0(this, localg, parama));
    }
    h.OAn.b(19747, new Object[] { Integer.valueOf(3), Integer.valueOf(4) });
    AppMethodBeat.o(294451);
  }
  
  public final void c(com.tencent.mm.vending.e.b<?> paramb)
  {
    long l = 0L;
    AppMethodBeat.i(294430);
    s.u(paramb, "keeper");
    Object localObject = (g)this.wIp.getValue();
    if ((localObject == g.wIJ) || (localObject == g.wIK) || (localObject == g.wIM))
    {
      AppMethodBeat.o(294430);
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
      localObject = new com.tencent.mm.plugin.card.model.c.c(l, i);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      s.s(localObject, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new c(this)).b(paramb);
      AppMethodBeat.o(294430);
      return;
    }
    localObject = this.wIA;
    if (localObject == null) {}
    for (l = 0L;; l = ((cia)localObject).aaqG)
    {
      i = this.wHx;
      break;
    }
  }
  
  public final void d(com.tencent.mm.vending.e.b<?> paramb)
  {
    AppMethodBeat.i(294442);
    s.u(paramb, "keeper");
    Object localObject = (g)this.wIp.getValue();
    if ((localObject == g.wIJ) || (localObject == g.wIK))
    {
      AppMethodBeat.o(294442);
      return;
    }
    this.wIp.t(g.wIJ);
    int j = 0;
    int i;
    if (this.wIz > 0) {
      i = this.wIz;
    }
    for (;;)
    {
      j = i;
      if (i < this.wHx) {
        j = this.wHx;
      }
      i = this.wIy;
      this.wIB.clear();
      this.wIC.clear();
      localObject = new com.tencent.mm.plugin.card.model.c.c(0L, j + i);
      ((com.tencent.mm.am.b)localObject).otr = true;
      localObject = ((com.tencent.mm.am.b)localObject).bFJ();
      s.s(localObject, "CgiGetCouponAndGiftList(…ntCancelAfterDead().run()");
      com.tencent.mm.ae.d.b((com.tencent.mm.vending.g.c)localObject, (kotlin.g.a.b)new b(this)).b(paramb);
      AppMethodBeat.o(294442);
      return;
      if (this.wIB.size() > 0) {
        j = this.wIB.size() + 0;
      }
      i = j;
      if (this.wIC.size() > 0) {
        i = j + this.wIC.size();
      }
    }
  }
  
  public final void doC()
  {
    int i = 0;
    AppMethodBeat.i(294458);
    Object localObject = com.tencent.mm.plugin.card.model.a.a.wvG;
    localObject = a.a.dle();
    if (localObject == null)
    {
      AppMethodBeat.o(294458);
      return;
    }
    this.wIm.t(((cia)localObject).aaqH);
    localObject = a((cia)localObject, false);
    if (localObject == null) {}
    for (;;)
    {
      this.wIz = i;
      this.wIo.t(localObject);
      AppMethodBeat.o(294458);
      return;
      i = ((ArrayList)localObject).size();
    }
  }
  
  public final void doD()
  {
    AppMethodBeat.i(294467);
    cia localcia = this.wIA;
    if (localcia != null)
    {
      agm localagm = new agm();
      if (!((Collection)this.wIB).isEmpty()) {}
      Object localObject2;
      for (int i = 1; i != 0; i = 0)
      {
        localObject1 = this.wIB.remove(0);
        s.s(localObject1, "mGiftCards.removeAt(0)");
        localObject2 = ((a)localObject1).title;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localagm.ZpI = ((String)localObject1);
        localObject1 = this.wIB.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (((a)localObject2).wIa != null) {
            localagm.nUC.add(((a)localObject2).wIa);
          }
        }
      }
      localcia.aaqJ = localagm;
      localagm = new agm();
      if (!((Collection)this.wIC).isEmpty()) {}
      for (i = 1; i != 0; i = 0)
      {
        localObject1 = this.wIC.remove(0);
        s.s(localObject1, "mCouponCards.removeAt(0)");
        localObject2 = ((a)localObject1).title;
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localagm.ZpI = ((String)localObject1);
        localObject1 = this.wIC.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a)((Iterator)localObject1).next();
          if (((a)localObject2).wIa != null) {
            localagm.nUC.add(((a)localObject2).wIa);
          }
        }
      }
      localcia.aaqK = localagm;
      Object localObject1 = com.tencent.mm.plugin.card.model.a.a.wvG;
      a.a.a(localcia);
    }
    AppMethodBeat.o(294467);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<b.a<cia>, ah>
  {
    b(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/modelbase/Cgi$CgiBack;", "Lcom/tencent/mm/protocal/protobuf/GetCouponAndGiftListResponse;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<b.a<cia>, ah>
  {
    c(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.e
 * JD-Core Version:    0.7.0.1
 */
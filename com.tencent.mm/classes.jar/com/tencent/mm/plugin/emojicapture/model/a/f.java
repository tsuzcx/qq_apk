package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aza;
import com.tencent.mm.protocal.protobuf.bpk;
import com.tencent.mm.protocal.protobuf.bpl;
import com.tencent.mm.protocal.protobuf.bpn;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.sticker.c.h;
import com.tencent.mm.sticker.c.i;
import com.tencent.mm.sticker.c.i.a;
import d.a.j;
import d.a.v;
import d.g.b.k;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class f
{
  private static final bpl poi;
  private static final bpl poj;
  private static final bpl pok;
  private static final bpl pol;
  private static final bpl pom;
  private static final bpl pon;
  public static final a poo;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fSt;
  private boolean isLoading;
  public final LinkedList<bpl> pnO;
  private final int pnX;
  private byte[] pnY;
  private boolean pnZ;
  private boolean poa;
  private boolean pob;
  public boolean poc;
  public byte[] pod;
  private final LinkedList<bpl> poe;
  private final LinkedList<bpl> pof;
  private final LinkedList<bpl> pog;
  final d poh;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(249);
    poo = new a((byte)0);
    poi = new bpl();
    poj = new bpl();
    pok = new bpl();
    pol = new bpl();
    pom = new bpl();
    pon = new bpl();
    AppMethodBeat.o(249);
  }
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd)
  {
    AppMethodBeat.i(248);
    this.fSt = paramb;
    this.poh = paramd;
    this.pnX = 2;
    this.pnZ = true;
    this.poa = true;
    this.requestType = 1;
    this.pnO = new LinkedList();
    this.poe = new LinkedList();
    this.pof = new LinkedList();
    this.pog = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.GBj;
    com.tencent.mm.sticker.a.b.H(null);
    AppMethodBeat.o(245);
  }
  
  public final void YH(String paramString)
  {
    AppMethodBeat.i(243);
    k.h(paramString, "lensId");
    bpl localbpl = new bpl();
    localbpl.Ewy = paramString;
    a(localbpl);
    AppMethodBeat.o(243);
  }
  
  public final void a(bpl parambpl)
  {
    AppMethodBeat.i(244);
    k.h(parambpl, "info");
    Object localObject2 = ((Iterable)this.pnO).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (k.g(((bpl)localObject1).Ewy, parambpl.Ewy))
      {
        localObject2 = (bpl)localObject1;
        Iterator localIterator = ((Iterable)this.poe).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (k.g(((bpl)localObject1).Ewy, parambpl.Ewy))
            {
              label112:
              localObject1 = (bpl)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.poe.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      cfr();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = parambpl.Ewy;
        if ((localObject1 != null) && (!a.b(parambpl)))
        {
          parambpl = com.tencent.mm.sticker.c.d.GBn;
          d.a.a(this.fSt, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.poe.add(parambpl);
        }
      }
    }
  }
  
  public final void cfp()
  {
    AppMethodBeat.i(241);
    ac.i(g.abZ(), "loadMore: " + this.isLoading + ", " + this.pnZ);
    if ((!this.pnZ) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.GBw;
    i.a.a(this.requestType, this.pnY, this.pod, this.fSt, (h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void cfq()
  {
    AppMethodBeat.i(242);
    this.pof.clear();
    LinkedList localLinkedList = this.pof;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.GBj;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.eYC());
    ac.i(g.abZ(), "updateHistory: " + this.pof.size());
    cfs();
    AppMethodBeat.o(242);
  }
  
  public final void cfr()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ac.c.g((d.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void cfs()
  {
    int j = 0;
    AppMethodBeat.i(247);
    ac.i(g.abZ(), "processMore: " + this.pof.size() + ", " + this.pog.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.pof.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(pol, 0, 6, (byte)0));
      localObject1 = (Iterable)this.pof;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fOc();
        }
        localCollection.add(new com.tencent.mm.sticker.c((bpl)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.c(pom, 0, 6, (byte)0));
    }
    if (this.pog.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(pon, 0, 6, (byte)0));
      localObject1 = (Iterable)this.pog;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fOc();
        }
        localCollection.add(new com.tencent.mm.sticker.c((bpl)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.poh.cT((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
  public static final class a
  {
    public static boolean b(bpl parambpl)
    {
      Object localObject2 = null;
      AppMethodBeat.i(235);
      k.h(parambpl, "lensInfo");
      if (!bs.isNullOrNil(parambpl.Ewy))
      {
        Object localObject1 = parambpl.FeL;
        if (localObject1 != null) {}
        for (localObject1 = ((bpk)localObject1).Url; !bs.isNullOrNil((String)localObject1); localObject1 = null)
        {
          localObject1 = parambpl.FeM;
          parambpl = localObject2;
          if (localObject1 != null) {
            parambpl = ((bpn)localObject1).DUJ;
          }
          if (bs.isNullOrNil(parambpl)) {
            break;
          }
          AppMethodBeat.o(235);
          return true;
        }
      }
      AppMethodBeat.o(235);
      return false;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    public final void a(int paramInt, bpl parambpl)
    {
      AppMethodBeat.i(236);
      ac.i(g.abZ(), "getLensInfo onResult: ".concat(String.valueOf(parambpl)));
      if (parambpl != null)
      {
        f.f(this.pop).add(parambpl);
        f.g(this.pop);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(f paramf)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
  public static final class d
    implements h
  {
    public final void a(int paramInt1, int paramInt2, aza paramaza)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool = true;
      AppMethodBeat.i(238);
      f.b(this.pop);
      Object localObject3;
      if ((paramInt1 == 4) && (paramInt2 == f.c(this.pop)) && (paramaza != null))
      {
        localObject2 = this.pop;
        localObject3 = paramaza.EQy;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.bw.b)localObject3).getBytes();
        }
        f.a((f)localObject2, (byte[])localObject1);
        localObject1 = this.pop;
        localObject2 = f.d(this.pop);
        if (localObject2 != null) {
          if (localObject2.length == 0)
          {
            paramInt1 = 1;
            if (paramInt1 != 0) {
              break label200;
            }
            paramInt1 = 1;
            label107:
            if (paramInt1 != 1) {
              break label205;
            }
            label112:
            f.a((f)localObject1, bool);
            localObject1 = this.pop;
            paramaza = paramaza.EQA;
            k.g(paramaza, "response.LensList");
            f.a((f)localObject1, (List)paramaza);
          }
        }
      }
      for (;;)
      {
        ac.i(g.abZ(), "getLensList onResult: " + f.a(this.pop) + ", " + f.e(this.pop));
        AppMethodBeat.o(238);
        return;
        paramInt1 = 0;
        break;
        label200:
        paramInt1 = 0;
        break label107;
        label205:
        bool = false;
        break label112;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramaza != null))
        {
          f.a(this.pop, false);
          localObject3 = this.pop;
          com.tencent.mm.bw.b localb = paramaza.EQy;
          localObject1 = localObject2;
          if (localb != null) {
            localObject1 = localb.getBytes();
          }
          f.a((f)localObject3, (byte[])localObject1);
          localObject1 = this.pop;
          paramaza = paramaza.EQA;
          k.g(paramaza, "response.LensList");
          f.a((f)localObject1, (List)paramaza);
        }
        else
        {
          f.a(this.pop, (List)v.KTF);
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(f paramf, List paramList)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f
 * JD-Core Version:    0.7.0.1
 */
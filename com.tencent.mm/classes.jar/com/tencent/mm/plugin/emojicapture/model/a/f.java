package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bde;
import com.tencent.mm.protocal.protobuf.btx;
import com.tencent.mm.protocal.protobuf.bty;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.sticker.c.h;
import com.tencent.mm.sticker.c.i;
import com.tencent.mm.sticker.c.i.a;
import d.a.j;
import d.a.v;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class f
{
  private static final bty pRI;
  private static final bty pRJ;
  private static final bty pRK;
  private static final bty pRL;
  private static final bty pRM;
  private static final bty pRN;
  public static final a pRO;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> glX;
  private boolean isLoading;
  private boolean pRA;
  private boolean pRB;
  public boolean pRC;
  public byte[] pRD;
  private final LinkedList<bty> pRE;
  private final LinkedList<bty> pRF;
  private final LinkedList<bty> pRG;
  final d pRH;
  public final LinkedList<bty> pRo;
  private final int pRx;
  private byte[] pRy;
  private boolean pRz;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(249);
    pRO = new a((byte)0);
    pRI = new bty();
    pRJ = new bty();
    pRK = new bty();
    pRL = new bty();
    pRM = new bty();
    pRN = new bty();
    AppMethodBeat.o(249);
  }
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd)
  {
    AppMethodBeat.i(248);
    this.glX = paramb;
    this.pRH = paramd;
    this.pRx = 2;
    this.pRz = true;
    this.pRA = true;
    this.requestType = 1;
    this.pRo = new LinkedList();
    this.pRE = new LinkedList();
    this.pRF = new LinkedList();
    this.pRG = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.Ind;
    com.tencent.mm.sticker.a.b.L(null);
    AppMethodBeat.o(245);
  }
  
  public final void a(bty parambty)
  {
    AppMethodBeat.i(244);
    p.h(parambty, "info");
    Object localObject2 = ((Iterable)this.pRo).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (p.i(((bty)localObject1).Geb, parambty.Geb))
      {
        localObject2 = (bty)localObject1;
        Iterator localIterator = ((Iterable)this.pRE).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (p.i(((bty)localObject1).Geb, parambty.Geb))
            {
              label112:
              localObject1 = (bty)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.pRE.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      cjU();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = parambty.Geb;
        if ((localObject1 != null) && (!a.b(parambty)))
        {
          parambty = com.tencent.mm.sticker.c.d.Inh;
          d.a.a(this.glX, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.pRE.add(parambty);
        }
      }
    }
  }
  
  public final void acn(String paramString)
  {
    AppMethodBeat.i(243);
    p.h(paramString, "lensId");
    bty localbty = new bty();
    localbty.Geb = paramString;
    a(localbty);
    AppMethodBeat.o(243);
  }
  
  public final void cjS()
  {
    AppMethodBeat.i(241);
    ad.i(g.aeD(), "loadMore: " + this.isLoading + ", " + this.pRz);
    if ((!this.pRz) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.Inq;
    i.a.a(this.requestType, this.pRy, this.pRD, this.glX, (h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void cjT()
  {
    AppMethodBeat.i(242);
    this.pRF.clear();
    LinkedList localLinkedList = this.pRF;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.Ind;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.fom());
    ad.i(g.aeD(), "updateHistory: " + this.pRF.size());
    cjV();
    AppMethodBeat.o(242);
  }
  
  public final void cjU()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void cjV()
  {
    int j = 0;
    AppMethodBeat.i(247);
    ad.i(g.aeD(), "processMore: " + this.pRF.size() + ", " + this.pRG.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.pRF.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(pRL, 0, 6, (byte)0));
      localObject1 = (Iterable)this.pRF;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gfB();
        }
        localCollection.add(new com.tencent.mm.sticker.c((bty)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.c(pRM, 0, 6, (byte)0));
    }
    if (this.pRG.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(pRN, 0, 6, (byte)0));
      localObject1 = (Iterable)this.pRG;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gfB();
        }
        localCollection.add(new com.tencent.mm.sticker.c((bty)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.pRH.cT((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
  public static final class a
  {
    public static boolean b(bty parambty)
    {
      Object localObject2 = null;
      AppMethodBeat.i(235);
      p.h(parambty, "lensInfo");
      if (!bt.isNullOrNil(parambty.Geb))
      {
        Object localObject1 = parambty.GOp;
        if (localObject1 != null) {}
        for (localObject1 = ((btx)localObject1).Url; !bt.isNullOrNil((String)localObject1); localObject1 = null)
        {
          localObject1 = parambty.GOq;
          parambty = localObject2;
          if (localObject1 != null) {
            parambty = ((bua)localObject1).FAe;
          }
          if (bt.isNullOrNil(parambty)) {
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
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    public final void a(int paramInt, bty parambty)
    {
      AppMethodBeat.i(236);
      ad.i(g.aeD(), "getLensInfo onResult: ".concat(String.valueOf(parambty)));
      if (parambty != null)
      {
        f.f(this.pRP).add(parambty);
        f.g(this.pRP);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(f paramf)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
  public static final class d
    implements h
  {
    public final void a(int paramInt1, int paramInt2, bde parambde)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool = true;
      AppMethodBeat.i(238);
      f.b(this.pRP);
      Object localObject3;
      if ((paramInt1 == 4) && (paramInt2 == f.c(this.pRP)) && (parambde != null))
      {
        localObject2 = this.pRP;
        localObject3 = parambde.GzP;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.bx.b)localObject3).getBytes();
        }
        f.a((f)localObject2, (byte[])localObject1);
        localObject1 = this.pRP;
        localObject2 = f.d(this.pRP);
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
            localObject1 = this.pRP;
            parambde = parambde.GzR;
            p.g(parambde, "response.LensList");
            f.a((f)localObject1, (List)parambde);
          }
        }
      }
      for (;;)
      {
        ad.i(g.aeD(), "getLensList onResult: " + f.a(this.pRP) + ", " + f.e(this.pRP));
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
        if ((paramInt1 == 0) && (paramInt2 == 0) && (parambde != null))
        {
          f.a(this.pRP, false);
          localObject3 = this.pRP;
          com.tencent.mm.bx.b localb = parambde.GzP;
          localObject1 = localObject2;
          if (localb != null) {
            localObject1 = localb.getBytes();
          }
          f.a((f)localObject3, (byte[])localObject1);
          localObject1 = this.pRP;
          parambde = parambde.GzR;
          p.g(parambde, "response.LensList");
          f.a((f)localObject1, (List)parambde);
        }
        else
        {
          f.a(this.pRP, (List)v.MKE);
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements d.g.a.a<z>
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
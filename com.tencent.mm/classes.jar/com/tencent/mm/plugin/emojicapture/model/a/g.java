package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.avu;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.blp;
import com.tencent.mm.protocal.protobuf.blr;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sticker.c.d;
import com.tencent.mm.sticker.c.d.a;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class g
{
  private static final blp oKP;
  private static final blp oKQ;
  private static final blp oKR;
  private static final blp oKS;
  private static final blp oKT;
  private static final blp oKU;
  public static final a oKV;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> fOI;
  private boolean isLoading;
  private final int oKE;
  private byte[] oKF;
  private boolean oKG;
  private boolean oKH;
  private boolean oKI;
  public boolean oKJ;
  public byte[] oKK;
  private final LinkedList<blp> oKL;
  private final LinkedList<blp> oKM;
  private final LinkedList<blp> oKN;
  final e oKO;
  public final LinkedList<blp> oKt;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(249);
    oKV = new a((byte)0);
    oKP = new blp();
    oKQ = new blp();
    oKR = new blp();
    oKS = new blp();
    oKT = new blp();
    oKU = new blp();
    AppMethodBeat.o(249);
  }
  
  public g(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, e parame)
  {
    AppMethodBeat.i(248);
    this.fOI = paramb;
    this.oKO = parame;
    this.oKE = 2;
    this.oKG = true;
    this.oKH = true;
    this.requestType = 1;
    this.oKt = new LinkedList();
    this.oKL = new LinkedList();
    this.oKM = new LinkedList();
    this.oKN = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.FdI;
    com.tencent.mm.sticker.a.b.B(null);
    AppMethodBeat.o(245);
  }
  
  public final void Uv(String paramString)
  {
    AppMethodBeat.i(243);
    k.h(paramString, "lensId");
    blp localblp = new blp();
    localblp.Dds = paramString;
    a(localblp);
    AppMethodBeat.o(243);
  }
  
  public final void a(blp paramblp)
  {
    AppMethodBeat.i(244);
    k.h(paramblp, "info");
    Object localObject2 = ((Iterable)this.oKt).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (k.g(((blp)localObject1).Dds, paramblp.Dds))
      {
        localObject2 = (blp)localObject1;
        Iterator localIterator = ((Iterable)this.oKL).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (k.g(((blp)localObject1).Dds, paramblp.Dds))
            {
              label112:
              localObject1 = (blp)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.oKL.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      bYe();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = paramblp.Dds;
        if ((localObject1 != null) && (!a.b(paramblp)))
        {
          paramblp = d.FdM;
          d.a.a(this.fOI, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.oKL.add(paramblp);
        }
      }
    }
  }
  
  public final void bYc()
  {
    AppMethodBeat.i(241);
    ad.i(h.abb(), "loadMore: " + this.isLoading + ", " + this.oKG);
    if ((!this.oKG) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.FdV;
    i.a.a(this.requestType, this.oKF, this.oKK, this.fOI, (com.tencent.mm.sticker.c.h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void bYd()
  {
    AppMethodBeat.i(242);
    this.oKM.clear();
    LinkedList localLinkedList = this.oKM;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.FdI;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.eJh());
    ad.i(h.abb(), "updateHistory: " + this.oKM.size());
    bYf();
    AppMethodBeat.o(242);
  }
  
  public final void bYe()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ad.c.g((d.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void bYf()
  {
    int j = 0;
    AppMethodBeat.i(247);
    ad.i(h.abb(), "processMore: " + this.oKM.size() + ", " + this.oKN.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.oKM.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.g(oKS, 0, 6, (byte)0));
      localObject1 = (Iterable)this.oKM;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fvx();
        }
        localCollection.add(new com.tencent.mm.sticker.g((blp)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.g(oKT, 0, 6, (byte)0));
    }
    if (this.oKN.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.g(oKU, 0, 6, (byte)0));
      localObject1 = (Iterable)this.oKN;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fvx();
        }
        localCollection.add(new com.tencent.mm.sticker.g((blp)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.oKO.cR((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
  public static final class a
  {
    public static boolean b(blp paramblp)
    {
      Object localObject2 = null;
      AppMethodBeat.i(235);
      k.h(paramblp, "lensInfo");
      if (!bt.isNullOrNil(paramblp.Dds))
      {
        Object localObject1 = paramblp.DJq;
        if (localObject1 != null) {}
        for (localObject1 = ((blo)localObject1).Url; !bt.isNullOrNil((String)localObject1); localObject1 = null)
        {
          localObject1 = paramblp.DJr;
          paramblp = localObject2;
          if (localObject1 != null) {
            paramblp = ((blr)localObject1).CCm;
          }
          if (bt.isNullOrNil(paramblp)) {
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    public final void a(int paramInt, blp paramblp)
    {
      AppMethodBeat.i(236);
      ad.i(h.abb(), "getLensInfo onResult: ".concat(String.valueOf(paramblp)));
      if (paramblp != null)
      {
        g.f(this.oKW).add(paramblp);
        g.g(this.oKW);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  public static final class c
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    public c(g paramg)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
  public static final class d
    implements com.tencent.mm.sticker.c.h
  {
    public final void a(int paramInt1, int paramInt2, avu paramavu)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool = true;
      AppMethodBeat.i(238);
      g.b(this.oKW);
      Object localObject3;
      if ((paramInt1 == 4) && (paramInt2 == g.c(this.oKW)) && (paramavu != null))
      {
        localObject2 = this.oKW;
        localObject3 = paramavu.Dvp;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.bx.b)localObject3).getBytes();
        }
        g.a((g)localObject2, (byte[])localObject1);
        localObject1 = this.oKW;
        localObject2 = g.d(this.oKW);
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
            g.a((g)localObject1, bool);
            localObject1 = this.oKW;
            paramavu = paramavu.Dvr;
            k.g(paramavu, "response.LensList");
            g.a((g)localObject1, (List)paramavu);
          }
        }
      }
      for (;;)
      {
        ad.i(h.abb(), "getLensList onResult: " + g.a(this.oKW) + ", " + g.e(this.oKW));
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
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramavu != null))
        {
          g.a(this.oKW, false);
          localObject3 = this.oKW;
          com.tencent.mm.bx.b localb = paramavu.Dvp;
          localObject1 = localObject2;
          if (localb != null) {
            localObject1 = localb.getBytes();
          }
          g.a((g)localObject3, (byte[])localObject1);
          localObject1 = this.oKW;
          paramavu = paramavu.Dvr;
          k.g(paramavu, "response.LensList");
          g.a((g)localObject1, (List)paramavu);
        }
        else
        {
          g.a(this.oKW, (List)v.Jgl);
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class e
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    e(g paramg, List paramList)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class f
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    f(g paramg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.g
 * JD-Core Version:    0.7.0.1
 */
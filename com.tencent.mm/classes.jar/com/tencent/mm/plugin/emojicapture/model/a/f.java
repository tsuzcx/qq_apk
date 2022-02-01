package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.bur;
import com.tencent.mm.protocal.protobuf.bus;
import com.tencent.mm.protocal.protobuf.buu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class f
{
  private static final bus pYn;
  private static final bus pYo;
  private static final bus pYp;
  private static final bus pYq;
  private static final bus pYr;
  private static final bus pYs;
  public static final a pYt;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> got;
  private boolean isLoading;
  public final LinkedList<bus> pXT;
  private final int pYc;
  private byte[] pYd;
  private boolean pYe;
  private boolean pYf;
  private boolean pYg;
  public boolean pYh;
  public byte[] pYi;
  private final LinkedList<bus> pYj;
  private final LinkedList<bus> pYk;
  private final LinkedList<bus> pYl;
  final d pYm;
  public int requestType;
  
  static
  {
    AppMethodBeat.i(249);
    pYt = new a((byte)0);
    pYn = new bus();
    pYo = new bus();
    pYp = new bus();
    pYq = new bus();
    pYr = new bus();
    pYs = new bus();
    AppMethodBeat.o(249);
  }
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd)
  {
    AppMethodBeat.i(248);
    this.got = paramb;
    this.pYm = paramd;
    this.pYc = 2;
    this.pYe = true;
    this.pYf = true;
    this.requestType = 1;
    this.pXT = new LinkedList();
    this.pYj = new LinkedList();
    this.pYk = new LinkedList();
    this.pYl = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.IHo;
    com.tencent.mm.sticker.a.b.L(null);
    AppMethodBeat.o(245);
  }
  
  public final void a(bus parambus)
  {
    AppMethodBeat.i(244);
    p.h(parambus, "info");
    Object localObject2 = ((Iterable)this.pXT).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (p.i(((bus)localObject1).GwI, parambus.GwI))
      {
        localObject2 = (bus)localObject1;
        Iterator localIterator = ((Iterable)this.pYj).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (p.i(((bus)localObject1).GwI, parambus.GwI))
            {
              label112:
              localObject1 = (bus)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.pYj.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      clk();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = parambus.GwI;
        if ((localObject1 != null) && (!a.b(parambus)))
        {
          parambus = com.tencent.mm.sticker.c.d.IHs;
          d.a.a(this.got, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.pYj.add(parambus);
        }
      }
    }
  }
  
  public final void ade(String paramString)
  {
    AppMethodBeat.i(243);
    p.h(paramString, "lensId");
    bus localbus = new bus();
    localbus.GwI = paramString;
    a(localbus);
    AppMethodBeat.o(243);
  }
  
  public final void cli()
  {
    AppMethodBeat.i(241);
    ae.i(g.aeP(), "loadMore: " + this.isLoading + ", " + this.pYe);
    if ((!this.pYe) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.IHB;
    i.a.a(this.requestType, this.pYd, this.pYi, this.got, (h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void clj()
  {
    AppMethodBeat.i(242);
    this.pYk.clear();
    LinkedList localLinkedList = this.pYk;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.IHo;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.fsf());
    ae.i(g.aeP(), "updateHistory: " + this.pYk.size());
    cll();
    AppMethodBeat.o(242);
  }
  
  public final void clk()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ac.c.h((d.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void cll()
  {
    int j = 0;
    AppMethodBeat.i(247);
    ae.i(g.aeP(), "processMore: " + this.pYk.size() + ", " + this.pYl.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.pYk.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(pYq, 0, 6, (byte)0));
      localObject1 = (Iterable)this.pYk;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gkd();
        }
        localCollection.add(new com.tencent.mm.sticker.c((bus)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.c(pYr, 0, 6, (byte)0));
    }
    if (this.pYl.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(pYs, 0, 6, (byte)0));
      localObject1 = (Iterable)this.pYl;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.gkd();
        }
        localCollection.add(new com.tencent.mm.sticker.c((bus)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.pYm.cW((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$Companion;", "", "()V", "EMPTY_STICKER", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getEMPTY_STICKER", "()Lcom/tencent/mm/protocal/protobuf/LensInfo;", "HISTORY_END", "getHISTORY_END", "HISTORY_HEADER", "getHISTORY_HEADER", "MORE_STICKER", "getMORE_STICKER", "MORE_STICKER_DISABLE", "getMORE_STICKER_DISABLE", "RECOMMEND_HEADER", "getRECOMMEND_HEADER", "isValidLensInfo", "", "lensInfo", "plugin-emojicapture_release"})
  public static final class a
  {
    public static boolean b(bus parambus)
    {
      Object localObject2 = null;
      AppMethodBeat.i(235);
      p.h(parambus, "lensInfo");
      if (!bu.isNullOrNil(parambus.GwI))
      {
        Object localObject1 = parambus.HhP;
        if (localObject1 != null) {}
        for (localObject1 = ((bur)localObject1).Url; !bu.isNullOrNil((String)localObject1); localObject1 = null)
        {
          localObject1 = parambus.HhQ;
          parambus = localObject2;
          if (localObject1 != null) {
            parambus = ((buu)localObject1).FSC;
          }
          if (bu.isNullOrNil(parambus)) {
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    public final void a(int paramInt, bus parambus)
    {
      AppMethodBeat.i(236);
      ae.i(g.aeP(), "getLensInfo onResult: ".concat(String.valueOf(parambus)));
      if (parambus != null)
      {
        f.f(this.pYu).add(parambus);
        f.g(this.pYu);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements d.g.a.a<z>
  {
    public c(f paramf)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
  public static final class d
    implements h
  {
    public final void a(int paramInt1, int paramInt2, bdu parambdu)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool = true;
      AppMethodBeat.i(238);
      f.b(this.pYu);
      Object localObject3;
      if ((paramInt1 == 4) && (paramInt2 == f.c(this.pYu)) && (parambdu != null))
      {
        localObject2 = this.pYu;
        localObject3 = parambdu.GTp;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.bw.b)localObject3).getBytes();
        }
        f.a((f)localObject2, (byte[])localObject1);
        localObject1 = this.pYu;
        localObject2 = f.d(this.pYu);
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
            localObject1 = this.pYu;
            parambdu = parambdu.GTr;
            p.g(parambdu, "response.LensList");
            f.a((f)localObject1, (List)parambdu);
          }
        }
      }
      for (;;)
      {
        ae.i(g.aeP(), "getLensList onResult: " + f.a(this.pYu) + ", " + f.e(this.pYu));
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
        if ((paramInt1 == 0) && (paramInt2 == 0) && (parambdu != null))
        {
          f.a(this.pYu, false);
          localObject3 = this.pYu;
          com.tencent.mm.bw.b localb = parambdu.GTp;
          localObject1 = localObject2;
          if (localb != null) {
            localObject1 = localb.getBytes();
          }
          f.a((f)localObject3, (byte[])localObject1);
          localObject1 = this.pYu;
          parambdu = parambdu.GTr;
          p.g(parambdu, "response.LensList");
          f.a((f)localObject1, (List)parambdu);
        }
        else
        {
          f.a(this.pYu, (List)v.NhH);
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements d.g.a.a<z>
  {
    e(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f
 * JD-Core Version:    0.7.0.1
 */
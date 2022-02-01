package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bxc;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sticker.c.d.a;
import com.tencent.mm.sticker.c.h;
import com.tencent.mm.sticker.c.i;
import com.tencent.mm.sticker.c.i.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.a.v;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class f
{
  private static final cqv uUR;
  private static final cqv uUS;
  private static final cqv uUT;
  private static final cqv uUU;
  private static final cqv uUV;
  private static final cqv uUW;
  public static final f.a uUX;
  private boolean isLoading;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> jKn;
  public int requestType;
  private final int uUG;
  private byte[] uUH;
  private boolean uUI;
  private boolean uUJ;
  private boolean uUK;
  public boolean uUL;
  public byte[] uUM;
  private final LinkedList<cqv> uUN;
  private final LinkedList<cqv> uUO;
  private final LinkedList<cqv> uUP;
  final d uUQ;
  public final LinkedList<cqv> uUx;
  
  static
  {
    AppMethodBeat.i(249);
    uUX = new f.a((byte)0);
    uUR = new cqv();
    uUS = new cqv();
    uUT = new cqv();
    uUU = new cqv();
    uUV = new cqv();
    uUW = new cqv();
    AppMethodBeat.o(249);
  }
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd)
  {
    AppMethodBeat.i(248);
    this.jKn = paramb;
    this.uUQ = paramd;
    this.uUG = 2;
    this.uUI = true;
    this.uUJ = true;
    this.requestType = 1;
    this.uUx = new LinkedList();
    this.uUN = new LinkedList();
    this.uUO = new LinkedList();
    this.uUP = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.VbS;
    com.tencent.mm.sticker.a.b.an(null);
    AppMethodBeat.o(245);
  }
  
  public final void a(cqv paramcqv)
  {
    AppMethodBeat.i(244);
    p.k(paramcqv, "info");
    Object localObject2 = ((Iterable)this.uUx).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (p.h(((cqv)localObject1).LensId, paramcqv.LensId))
      {
        localObject2 = (cqv)localObject1;
        Iterator localIterator = ((Iterable)this.uUN).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (p.h(((cqv)localObject1).LensId, paramcqv.LensId))
            {
              label112:
              localObject1 = (cqv)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.uUN.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      cXU();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = paramcqv.LensId;
        if ((localObject1 != null) && (!f.a.b(paramcqv)))
        {
          paramcqv = com.tencent.mm.sticker.c.d.VbW;
          d.a.a(this.jKn, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.uUN.add(paramcqv);
        }
      }
    }
  }
  
  public final void aDi()
  {
    AppMethodBeat.i(241);
    Log.i(g.aBy(), "loadMore: " + this.isLoading + ", " + this.uUI);
    if ((!this.uUI) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.Vce;
    i.a.a(this.requestType, this.uUH, this.uUM, this.jKn, (h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void avl(String paramString)
  {
    AppMethodBeat.i(243);
    p.k(paramString, "lensId");
    cqv localcqv = new cqv();
    localcqv.LensId = paramString;
    a(localcqv);
    AppMethodBeat.o(243);
  }
  
  public final void cXT()
  {
    AppMethodBeat.i(242);
    this.uUO.clear();
    LinkedList localLinkedList = this.uUO;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.VbS;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.hvf());
    Log.i(g.aBy(), "updateHistory: " + this.uUO.size());
    cXV();
    AppMethodBeat.o(242);
  }
  
  public final void cXU()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void cXV()
  {
    int j = 0;
    AppMethodBeat.i(247);
    Log.i(g.aBy(), "processMore: " + this.uUO.size() + ", " + this.uUP.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.uUO.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(uUU, 0, 6, (byte)0));
      localObject1 = (Iterable)this.uUO;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        localCollection.add(new com.tencent.mm.sticker.c((cqv)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.c(uUV, 0, 6, (byte)0));
    }
    if (this.uUP.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(uUW, 0, 6, (byte)0));
      localObject1 = (Iterable)this.uUP;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.iBO();
        }
        localCollection.add(new com.tencent.mm.sticker.c((cqv)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.uUQ.dm((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    public final void a(int paramInt, cqv paramcqv)
    {
      AppMethodBeat.i(236);
      Log.i(g.aBy(), "getLensInfo onResult: ".concat(String.valueOf(paramcqv)));
      if (paramcqv != null)
      {
        f.f(this.uUY).add(paramcqv);
        f.g(this.uUY);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(f paramf)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
  public static final class d
    implements h
  {
    public final void a(int paramInt1, int paramInt2, bxc parambxc)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool = true;
      AppMethodBeat.i(238);
      f.b(this.uUY);
      Object localObject3;
      if ((paramInt1 == 4) && (paramInt2 == f.c(this.uUY)) && (parambxc != null))
      {
        localObject2 = this.uUY;
        localObject3 = parambxc.TgS;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.cd.b)localObject3).UH;
        }
        f.a((f)localObject2, (byte[])localObject1);
        localObject1 = this.uUY;
        localObject2 = f.d(this.uUY);
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
            localObject1 = this.uUY;
            parambxc = parambxc.TgU;
            p.j(parambxc, "response.LensList");
            f.a((f)localObject1, (List)parambxc);
          }
        }
      }
      for (;;)
      {
        Log.i(g.aBy(), "getLensList onResult: " + f.a(this.uUY) + ", " + f.e(this.uUY));
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
        if ((paramInt1 == 0) && (paramInt2 == 0) && (parambxc != null))
        {
          f.a(this.uUY, false);
          localObject3 = this.uUY;
          com.tencent.mm.cd.b localb = parambxc.TgS;
          localObject1 = localObject2;
          if (localb != null) {
            localObject1 = localb.UH;
          }
          f.a((f)localObject3, (byte[])localObject1);
          localObject1 = this.uUY;
          parambxc = parambxc.TgU;
          p.j(parambxc, "response.LensList");
          f.a((f)localObject1, (List)parambxc);
        }
        else
        {
          f.a(this.uUY, (List)v.aaAd);
        }
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f
 * JD-Core Version:    0.7.0.1
 */
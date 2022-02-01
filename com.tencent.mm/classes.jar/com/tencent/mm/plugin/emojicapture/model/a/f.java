package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.chz;
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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"})
public final class f
{
  private static final chz rpl;
  private static final chz rpm;
  private static final chz rpn;
  private static final chz rpo;
  private static final chz rpp;
  private static final chz rpq;
  public static final f.a rpr;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> gZm;
  private boolean isLoading;
  public int requestType;
  public final LinkedList<chz> roR;
  private final int rpa;
  private byte[] rpb;
  private boolean rpc;
  private boolean rpd;
  private boolean rpe;
  public boolean rpf;
  public byte[] rpg;
  private final LinkedList<chz> rph;
  private final LinkedList<chz> rpi;
  private final LinkedList<chz> rpj;
  final d rpk;
  
  static
  {
    AppMethodBeat.i(249);
    rpr = new f.a((byte)0);
    rpl = new chz();
    rpm = new chz();
    rpn = new chz();
    rpo = new chz();
    rpp = new chz();
    rpq = new chz();
    AppMethodBeat.o(249);
  }
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd)
  {
    AppMethodBeat.i(248);
    this.gZm = paramb;
    this.rpk = paramd;
    this.rpa = 2;
    this.rpc = true;
    this.rpd = true;
    this.requestType = 1;
    this.roR = new LinkedList();
    this.rph = new LinkedList();
    this.rpi = new LinkedList();
    this.rpj = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.NOi;
    com.tencent.mm.sticker.a.b.ae(null);
    AppMethodBeat.o(245);
  }
  
  public final void a(chz paramchz)
  {
    AppMethodBeat.i(244);
    p.h(paramchz, "info");
    Object localObject2 = ((Iterable)this.roR).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (p.j(((chz)localObject1).Lso, paramchz.Lso))
      {
        localObject2 = (chz)localObject1;
        Iterator localIterator = ((Iterable)this.rph).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (p.j(((chz)localObject1).Lso, paramchz.Lso))
            {
              label112:
              localObject1 = (chz)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.rph.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      cJm();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = paramchz.Lso;
        if ((localObject1 != null) && (!f.a.b(paramchz)))
        {
          paramchz = com.tencent.mm.sticker.c.d.NOm;
          d.a.a(this.gZm, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.rph.add(paramchz);
        }
      }
    }
  }
  
  public final void ann(String paramString)
  {
    AppMethodBeat.i(243);
    p.h(paramString, "lensId");
    chz localchz = new chz();
    localchz.Lso = paramString;
    a(localchz);
    AppMethodBeat.o(243);
  }
  
  public final void cJk()
  {
    AppMethodBeat.i(241);
    Log.i(g.auD(), "loadMore: " + this.isLoading + ", " + this.rpc);
    if ((!this.rpc) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.NOv;
    i.a.a(this.requestType, this.rpb, this.rpg, this.gZm, (h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void cJl()
  {
    AppMethodBeat.i(242);
    this.rpi.clear();
    LinkedList localLinkedList = this.rpi;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.NOi;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.gzf());
    Log.i(g.auD(), "updateHistory: " + this.rpi.size());
    cJn();
    AppMethodBeat.o(242);
  }
  
  public final void cJm()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void cJn()
  {
    int j = 0;
    AppMethodBeat.i(247);
    Log.i(g.auD(), "processMore: " + this.rpi.size() + ", " + this.rpj.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.rpi.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(rpo, 0, 6, (byte)0));
      localObject1 = (Iterable)this.rpi;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.hxH();
        }
        localCollection.add(new com.tencent.mm.sticker.c((chz)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.c(rpp, 0, 6, (byte)0));
    }
    if (this.rpj.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(rpq, 0, 6, (byte)0));
      localObject1 = (Iterable)this.rpj;
      localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.hxH();
        }
        localCollection.add(new com.tencent.mm.sticker.c((chz)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.rpk.dl((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"})
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    public final void a(int paramInt, chz paramchz)
    {
      AppMethodBeat.i(236);
      Log.i(g.auD(), "getLensInfo onResult: ".concat(String.valueOf(paramchz)));
      if (paramchz != null)
      {
        f.f(this.rps).add(paramchz);
        f.g(this.rps);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    public c(f paramf)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"})
  public static final class d
    implements h
  {
    public final void a(int paramInt1, int paramInt2, bpi parambpi)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      boolean bool = true;
      AppMethodBeat.i(238);
      f.b(this.rps);
      Object localObject3;
      if ((paramInt1 == 4) && (paramInt2 == f.c(this.rps)) && (parambpi != null))
      {
        localObject2 = this.rps;
        localObject3 = parambpi.LXB;
        if (localObject3 != null) {
          localObject1 = ((com.tencent.mm.bw.b)localObject3).zy;
        }
        f.a((f)localObject2, (byte[])localObject1);
        localObject1 = this.rps;
        localObject2 = f.d(this.rps);
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
            localObject1 = this.rps;
            parambpi = parambpi.LXD;
            p.g(parambpi, "response.LensList");
            f.a((f)localObject1, (List)parambpi);
          }
        }
      }
      for (;;)
      {
        Log.i(g.auD(), "getLensList onResult: " + f.a(this.rps) + ", " + f.e(this.rps));
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
        if ((paramInt1 == 0) && (paramInt2 == 0) && (parambpi != null))
        {
          f.a(this.rps, false);
          localObject3 = this.rps;
          com.tencent.mm.bw.b localb = parambpi.LXB;
          localObject1 = localObject2;
          if (localb != null) {
            localObject1 = localb.zy;
          }
          f.a((f)localObject3, (byte[])localObject1);
          localObject1 = this.rps;
          parambpi = parambpi.LXD;
          p.g(parambpi, "response.LensList");
          f.a((f)localObject1, (List)parambpi);
        }
        else
        {
          f.a(this.rps, (List)v.SXr);
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<x>
  {
    e(f paramf, List paramList)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f
 * JD-Core Version:    0.7.0.1
 */
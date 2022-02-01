package com.tencent.mm.plugin.emojicapture.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.dhp;
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
import kotlin.Metadata;
import kotlin.a.ab;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData;", "", "lifeCycleKeeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "callback", "Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "(Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;)V", "appendList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "getCallback", "()Lcom/tencent/mm/plugin/emojicapture/model/capture/StickerPanelCallback;", "codeMore", "", "ctxBuff", "", "dataHasMore", "", "firstLoaded", "firstPage", "historyList", "isLoading", "getLifeCycleKeeper", "()Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "moreList", "pageBuff", "recommendHasMore", "recommendList", "requestType", "appendRecommend", "", "info", "lensId", "", "destroy", "loadData", "loadMore", "processData", "lensList", "", "processMore", "processRecommend", "setup", "timeEnter", "", "username", "updateHistory", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  private static final dhp yhA;
  private static final dhp yhB;
  private static final dhp yhC;
  private static final dhp yhD;
  private static final dhp yhE;
  public static final f.a yhn;
  private static final dhp yhz;
  private boolean isLoading;
  private final com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> mjD;
  public int requestType;
  public final LinkedList<dhp> yhj;
  final d yho;
  private final int yhp;
  private byte[] yhq;
  private boolean yhr;
  private boolean yhs;
  private boolean yht;
  public boolean yhu;
  public byte[] yhv;
  private final LinkedList<dhp> yhw;
  private final LinkedList<dhp> yhx;
  private final LinkedList<dhp> yhy;
  
  static
  {
    AppMethodBeat.i(249);
    yhn = new f.a((byte)0);
    yhz = new dhp();
    yhA = new dhp();
    yhB = new dhp();
    yhC = new dhp();
    yhD = new dhp();
    yhE = new dhp();
    AppMethodBeat.o(249);
  }
  
  public f(com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> paramb, d paramd)
  {
    AppMethodBeat.i(248);
    this.mjD = paramb;
    this.yho = paramd;
    this.yhp = 2;
    this.yhr = true;
    this.yhs = true;
    this.requestType = 1;
    this.yhj = new LinkedList();
    this.yhw = new LinkedList();
    this.yhx = new LinkedList();
    this.yhy = new LinkedList();
    AppMethodBeat.o(248);
  }
  
  public static void destroy()
  {
    AppMethodBeat.i(245);
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.acDc;
    com.tencent.mm.sticker.a.b.cc(null);
    AppMethodBeat.o(245);
  }
  
  public final void a(dhp paramdhp)
  {
    AppMethodBeat.i(244);
    s.u(paramdhp, "info");
    Object localObject2 = ((Iterable)this.yhj).iterator();
    Object localObject1;
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (s.p(((dhp)localObject1).LensId, paramdhp.LensId))
      {
        localObject2 = (dhp)localObject1;
        Iterator localIterator = ((Iterable)this.yhw).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            localObject1 = localIterator.next();
            if (s.p(((dhp)localObject1).LensId, paramdhp.LensId))
            {
              label112:
              localObject1 = (dhp)localObject1;
              if (localObject2 == null) {
                break label155;
              }
              if (localObject1 == null) {
                this.yhw.add(localObject2);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      dEk();
      AppMethodBeat.o(244);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label112;
      label155:
      if (localObject1 == null)
      {
        localObject1 = paramdhp.LensId;
        if ((localObject1 != null) && (!f.a.b(paramdhp)))
        {
          paramdhp = com.tencent.mm.sticker.c.d.acDm;
          d.a.a(this.mjD, (String)localObject1, (com.tencent.mm.sticker.c.c)new b(this));
        }
        else
        {
          this.yhw.add(paramdhp);
        }
      }
    }
  }
  
  public final void aWi()
  {
    AppMethodBeat.i(241);
    Log.i(g.aUw(), "loadMore: " + this.isLoading + ", " + this.yhr);
    if ((!this.yhr) || (this.isLoading))
    {
      AppMethodBeat.o(241);
      return;
    }
    this.isLoading = true;
    i.a locala = i.acDr;
    i.a.a(this.requestType, this.yhq, this.yhv, this.mjD, (h)new d(this));
    AppMethodBeat.o(241);
  }
  
  public final void apl(String paramString)
  {
    AppMethodBeat.i(243);
    s.u(paramString, "lensId");
    dhp localdhp = new dhp();
    localdhp.LensId = paramString;
    a(localdhp);
    AppMethodBeat.o(243);
  }
  
  public final void dEj()
  {
    AppMethodBeat.i(242);
    this.yhx.clear();
    LinkedList localLinkedList = this.yhx;
    com.tencent.mm.sticker.a.b localb = com.tencent.mm.sticker.a.b.acDc;
    localLinkedList.addAll((Collection)com.tencent.mm.sticker.a.b.iWG());
    Log.i(g.aUw(), s.X("updateHistory: ", Integer.valueOf(this.yhx.size())));
    dEl();
    AppMethodBeat.o(242);
  }
  
  public final void dEk()
  {
    AppMethodBeat.i(246);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f(this));
    AppMethodBeat.o(246);
  }
  
  public final void dEl()
  {
    int j = 0;
    AppMethodBeat.i(247);
    Log.i(g.aUw(), "processMore: " + this.yhx.size() + ", " + this.yhy.size());
    LinkedList localLinkedList = new LinkedList();
    Object localObject1;
    Collection localCollection;
    int i;
    Object localObject2;
    if (this.yhx.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(yhC, 0, 6, (byte)0));
      localObject1 = (Iterable)this.yhx;
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = 0;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localCollection.add(new com.tencent.mm.sticker.c((dhp)localObject2, i + 1, 2));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
      localLinkedList.add(new com.tencent.mm.sticker.c(yhD, 0, 6, (byte)0));
    }
    if (this.yhy.size() > 0)
    {
      localLinkedList.add(new com.tencent.mm.sticker.c(yhE, 0, 6, (byte)0));
      localObject1 = (Iterable)this.yhy;
      localCollection = (Collection)new ArrayList(p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      i = j;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          p.kkW();
        }
        localCollection.add(new com.tencent.mm.sticker.c((dhp)localObject2, i + 1, 3));
        i += 1;
      }
      localLinkedList.addAll((Collection)localCollection);
    }
    this.yho.fj((List)localLinkedList);
    AppMethodBeat.o(247);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$appendRecommend$1", "Lcom/tencent/mm/sticker/task/GetLensInfoCallback;", "onResult", "", "errType", "", "info", "Lcom/tencent/mm/protocal/protobuf/LensInfo;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements com.tencent.mm.sticker.c.c
  {
    b(f paramf) {}
    
    public final void a(int paramInt, dhp paramdhp)
    {
      AppMethodBeat.i(236);
      Log.i(g.aUw(), s.X("getLensInfo onResult: ", paramdhp));
      if (paramdhp != null)
      {
        f.f(this.yhF).add(paramdhp);
        f.g(this.yhF);
      }
      AppMethodBeat.o(236);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    public c(f paramf)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/emojicapture/model/capture/StickerPanelData$loadMore$1", "Lcom/tencent/mm/sticker/task/GetLensListCallback;", "onResult", "", "errType", "", "errCode", "response", "Lcom/tencent/mm/protocal/protobuf/GetLensListResponse;", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements h
  {
    d(f paramf) {}
    
    public final void a(int paramInt1, int paramInt2, cmf paramcmf)
    {
      Object localObject2 = null;
      Object localObject1 = null;
      AppMethodBeat.i(238);
      f.a(this.yhF);
      Object localObject3;
      label91:
      label97:
      boolean bool;
      if ((paramInt1 == 4) && (paramInt2 == f.b(this.yhF)) && (paramcmf != null))
      {
        localObject2 = this.yhF;
        localObject3 = paramcmf.aaui;
        if (localObject3 == null)
        {
          f.a((f)localObject2, (byte[])localObject1);
          localObject1 = this.yhF;
          localObject2 = f.c(this.yhF);
          if (localObject2 == null) {
            break label208;
          }
          if (localObject2.length != 0) {
            break label198;
          }
          paramInt1 = 1;
          if (paramInt1 != 0) {
            break label203;
          }
          paramInt1 = 1;
          if (paramInt1 != 1) {
            break label208;
          }
          bool = true;
          label105:
          f.a((f)localObject1, bool);
          localObject1 = this.yhF;
          paramcmf = paramcmf.aauk;
          s.s(paramcmf, "response.LensList");
          f.a((f)localObject1, (List)paramcmf);
        }
      }
      for (;;)
      {
        Log.i(g.aUw(), "getLensList onResult: " + f.d(this.yhF) + ", " + f.e(this.yhF));
        AppMethodBeat.o(238);
        return;
        localObject1 = ((com.tencent.mm.bx.b)localObject3).Op;
        break;
        label198:
        paramInt1 = 0;
        break label91;
        label203:
        paramInt1 = 0;
        break label97;
        label208:
        bool = false;
        break label105;
        if ((paramInt1 == 0) && (paramInt2 == 0) && (paramcmf != null))
        {
          f.a(this.yhF, false);
          localObject3 = this.yhF;
          localObject1 = paramcmf.aaui;
          if (localObject1 == null) {}
          for (localObject1 = localObject2;; localObject1 = ((com.tencent.mm.bx.b)localObject1).Op)
          {
            f.a((f)localObject3, (byte[])localObject1);
            localObject1 = this.yhF;
            paramcmf = paramcmf.aauk;
            s.s(paramcmf, "response.LensList");
            f.a((f)localObject1, (List)paramcmf);
            break;
          }
        }
        f.a(this.yhF, (List)ab.aivy);
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ah>
  {
    e(f paramf, List<? extends dhp> paramList)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ah>
  {
    f(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.a.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.loader;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.ap;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bat;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "onFetchDone", "response", "PurchaseListFetcher", "PurchaseListResp", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePurchaseListLoader
  extends BaseFeedLoader<cc>
{
  public kotlin.g.a.b<? super IResponse<cc>, ah> fetchEndCallback;
  
  public FinderLivePurchaseListLoader()
  {
    super(null, 1, null);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(351004);
    i locali = (i)new a();
    AppMethodBeat.o(351004);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(350999);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    d.uiThread((kotlin.g.a.a)new c(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(350999);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader$PurchaseListFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "(Lcom/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLivePurchaseList;", "genRefreshCgi", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class a
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    public a()
    {
      AppMethodBeat.i(351001);
      AppMethodBeat.o(351001);
    }
    
    public final IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc)
    {
      AppMethodBeat.i(351017);
      FinderLivePurchaseListLoader.b localb = new FinderLivePurchaseListLoader.b(this.CDs, paramInt1, paramInt2, paramString);
      if ((paramesc instanceof bat))
      {
        LinkedList localLinkedList = new LinkedList();
        if (this.CDs.getDataListJustForAdapter().isEmpty()) {
          localLinkedList.addAll((Collection)((bat)paramesc).ZIQ);
        }
        for (;;)
        {
          paramb = (Iterable)localLinkedList;
          paramString = (Collection)new ArrayList(p.a(paramb, 10));
          paramb = paramb.iterator();
          while (paramb.hasNext()) {
            paramString.add(new ap((FinderObject)paramb.next()));
          }
          List localList = p.a((Iterable)this.CDs.getDataListJustForAdapter(), ap.class);
          paramString = ((bat)paramesc).ZIQ;
          s.s(paramString, "resp.objects");
          Iterator localIterator1 = ((Iterable)paramString).iterator();
          while (localIterator1.hasNext())
          {
            FinderObject localFinderObject = (FinderObject)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            paramInt1 = 0;
            label215:
            if (localIterator2.hasNext())
            {
              paramb = (ap)localIterator2.next();
              paramString = localFinderObject.liveInfo;
              if (paramString == null)
              {
                paramString = null;
                label249:
                paramb = paramb.EDa.liveInfo;
                if (paramb != null) {
                  break label321;
                }
                paramb = null;
                if (!s.p(paramString, paramb)) {
                  break label334;
                }
                if (paramInt1 == -1) {
                  break label346;
                }
              }
            }
            label267:
            label276:
            label321:
            label334:
            label346:
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label351;
              }
              Log.i(getTAG(), s.X("repeat feed:", com.tencent.mm.plugin.finder.live.view.convert.a.a(com.tencent.mm.plugin.finder.live.view.convert.a.DUC, localFinderObject)));
              break;
              paramString = Long.valueOf(paramString.liveId);
              break label249;
              paramb = Long.valueOf(paramb.liveId);
              break label267;
              paramInt1 += 1;
              break label215;
              paramInt1 = -1;
              break label276;
            }
            label351:
            localLinkedList.add(localFinderObject);
          }
        }
        localb.setIncrementList((List)paramString);
        localb.CDt = ((bat)paramesc).ZLz;
        localb.setLastBuffer(((bat)paramesc).ZEQ);
        if (((bat)paramesc).BeA != 1) {
          break label438;
        }
      }
      label438:
      for (boolean bool = true;; bool = false)
      {
        localb.setHasMore(bool);
        localb.setPullType(2);
        paramString = (IResponse)localb;
        AppMethodBeat.o(351017);
        return paramString;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader$PurchaseListResp;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Lcom/tencent/mm/plugin/finder/live/loader/FinderLivePurchaseListLoader;IILjava/lang/String;)V", "purchasedCount", "getPurchasedCount", "()I", "setPurchasedCount", "(I)V", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends IResponse<cc>
  {
    public int CDt;
    
    public b(int paramInt, String paramString)
    {
      super(paramString, str);
      AppMethodBeat.i(350998);
      AppMethodBeat.o(350998);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(FinderLivePurchaseListLoader paramFinderLivePurchaseListLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.loader.FinderLivePurchaseListLoader
 * JD-Core Version:    0.7.0.1
 */
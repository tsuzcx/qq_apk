package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.c.e;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.esc;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "designerUin", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$CacheState;)V", "getDesignerUin", "()I", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$State;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "onFetchInitDone", "initResponse", "CacheState", "DesignerPackFetcher", "EmojiListResponse", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEmojiListLoader
  extends BaseFinderFeedLoader
{
  public a<ah> BbB;
  public d Bfm;
  public a Bfn;
  private final int mhB;
  
  public FinderEmojiListLoader(int paramInt, bui parambui)
  {
    super(parambui);
    this.mhB = paramInt;
    this.Bfm = d.Bft;
    this.Bfn = a.Bfo;
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(366509);
    s.u(paramd, "<set-?>");
    this.Bfm = paramd;
    AppMethodBeat.o(366509);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366515);
    i locali = (i)new b(this.mhB);
    AppMethodBeat.o(366515);
    return locali;
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366528);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (getDataListJustForAdapter().size() > 0) {}
    for (a locala = a.Bfq;; locala = a.Bfp)
    {
      this.Bfn = locala;
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(366528);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.BbB;
      if (paramIResponse != null) {
        paramIResponse.invoke();
      }
    }
    AppMethodBeat.o(366528);
  }
  
  public final void onFetchInitDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366522);
    s.u(paramIResponse, "initResponse");
    super.onFetchInitDone(paramIResponse);
    AppMethodBeat.o(366522);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(366154);
      Bfo = new a("INIT", 0);
      Bfp = new a("NO_CACHE", 1);
      Bfq = new a("WITH_CACHED", 2);
      Bfr = new a[] { Bfo, Bfp, Bfq };
      AppMethodBeat.o(366154);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$DesignerPackFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "designerUin", "", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader;I)V", "getDesignerUin", "()I", "reqBuff", "", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "fetch", "", "request", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreCgi", "genRefreshCgi", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    private final int mhB;
    private byte[] mhC;
    
    public b()
    {
      AppMethodBeat.i(366135);
      int i;
      this.mhB = i;
      AppMethodBeat.o(366135);
    }
    
    public final IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc)
    {
      cjb localcjb = null;
      Object localObject = null;
      AppMethodBeat.i(366172);
      if ((paramesc instanceof cps))
      {
        paramb = (cps)paramesc;
        paramesc = new FinderEmojiListLoader.c(paramInt1, paramInt2, paramString);
        if ((paramInt1 != 0) || (paramInt2 != 0)) {
          break label200;
        }
        FinderEmojiListLoader.this.a(FinderEmojiListLoader.d.Bfv);
        if (paramb != null) {
          break label95;
        }
        paramString = localObject;
      }
      for (;;)
      {
        paramesc.setIncrementList(paramString);
        paramesc.setHasMore(false);
        paramString = (IResponse)paramesc;
        AppMethodBeat.o(366172);
        return paramString;
        paramb = null;
        break;
        label95:
        paramString = paramb.Zvf;
        if (paramString == null)
        {
          paramString = localObject;
        }
        else
        {
          paramb = (Iterable)paramString;
          paramString = (Collection)new ArrayList(p.a(paramb, 10));
          paramb = paramb.iterator();
          while (paramb.hasNext())
          {
            localcjb = (cjb)paramb.next();
            s.s(localcjb, "it");
            paramString.add(new r(localcjb));
          }
          paramString = (List)paramString;
        }
      }
      label200:
      if ((paramInt1 == 4) && (paramInt2 == 2))
      {
        FinderEmojiListLoader.this.a(FinderEmojiListLoader.d.Bfv);
        if (paramb == null)
        {
          paramString = null;
          this.mhC = w.a(paramString);
          if (paramb != null) {
            break label277;
          }
          paramString = localcjb;
        }
        for (;;)
        {
          paramesc.setIncrementList(paramString);
          paramesc.setHasMore(true);
          paramString = (IResponse)paramesc;
          AppMethodBeat.o(366172);
          return paramString;
          paramString = paramb.YGU;
          break;
          paramString = paramb.Zvf;
          if (paramString == null)
          {
            paramString = localcjb;
          }
          else
          {
            paramb = (Iterable)paramString;
            paramString = (Collection)new ArrayList(p.a(paramb, 10));
            paramb = paramb.iterator();
            while (paramb.hasNext())
            {
              localcjb = (cjb)paramb.next();
              s.s(localcjb, "it");
              paramString.add(new r(localcjb));
            }
            paramString = (List)paramString;
          }
        }
      }
      label277:
      FinderEmojiListLoader.this.a(FinderEmojiListLoader.d.Bfw);
      AppMethodBeat.o(366172);
      return null;
    }
    
    public final com.tencent.mm.am.b<? extends esc> edO()
    {
      AppMethodBeat.i(366150);
      this.mhC = null;
      com.tencent.mm.am.b localb = (com.tencent.mm.am.b)new e(this.mhB, this.mhC);
      AppMethodBeat.o(366150);
      return localb;
    }
    
    public final com.tencent.mm.am.b<? extends esc> edP()
    {
      AppMethodBeat.i(366158);
      com.tencent.mm.am.b localb = (com.tencent.mm.am.b)new e(this.mhB, this.mhC);
      AppMethodBeat.o(366158);
      return localb;
    }
    
    public final void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366144);
      s.u(paramh, "callback");
      super.fetch(paramObject, paramh, paramBoolean);
      FinderEmojiListLoader.this.a(FinderEmojiListLoader.d.Bfu);
      AppMethodBeat.o(366144);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$EmojiListResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderEmojiListLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(366137);
      Bft = new d("INIT", 0);
      Bfu = new d("LOADING", 1);
      Bfv = new d("LOADED", 2);
      Bfw = new d("FAILURE", 3);
      Bfx = new d[] { Bft, Bfu, Bfv, Bfw };
      AppMethodBeat.o(366137);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderEmojiListLoader
 * JD-Core Version:    0.7.0.1
 */
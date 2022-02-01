package com.tencent.mm.plugin.finder.feed.model;

import android.text.TextUtils;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cy;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bt;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.event.IListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "enterType", "", "finderUserName", "", "finderSelfName", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "cachedState", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$CacheState;", "getCachedState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$CacheState;", "setCachedState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$CacheState;)V", "getEnterType", "()I", "fetchEndCallback", "Lkotlin/Function0;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function0;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function0;)V", "getFinderSelfName", "()Ljava/lang/String;", "getFinderUserName", "musicPlayEventListener", "com/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$musicPlayEventListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$musicPlayEventListener$1;", "state", "Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$State;", "getState", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$State;", "setState", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$State;)V", "addRvFeed", "index", "feed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "findMusicIndex", "wrapper", "Lcom/tencent/mm/modelmusic/MusicWrapper;", "id", "", "handleMusic", "action", "onAlive", "onDead", "onFetchDone", "response", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "transformFinderObj", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "transformToMusicData", "item", "updateMusic", "CacheState", "QQMusicDataFetcher", "QQMusicResponse", "State", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderProfileQQMusicLoader
  extends BaseFinderFeedLoader
{
  final int ACR;
  public a<ah> BbB;
  public d BiB;
  public a BiC;
  private final musicPlayEventListener.1 BiD;
  final String Bil;
  final String zDJ;
  
  public FinderProfileQQMusicLoader(String paramString1, String paramString2, bui parambui)
  {
    super(parambui);
    AppMethodBeat.i(366302);
    this.ACR = 23;
    this.zDJ = paramString1;
    this.Bil = paramString2;
    this.BiB = d.BiJ;
    this.BiC = a.BiE;
    this.BiD = new IListener(f.hfK) {};
    AppMethodBeat.o(366302);
  }
  
  public final void a(d paramd)
  {
    AppMethodBeat.i(366309);
    s.u(paramd, "<set-?>");
    this.BiB = paramd;
    AppMethodBeat.o(366309);
  }
  
  public final void addRvFeed(int paramInt, cc paramcc)
  {
    AppMethodBeat.i(366341);
    s.u(paramcc, "feed");
    if (((paramcc instanceof BaseFinderFeed)) && (!(paramcc instanceof bt)))
    {
      getDataList().add(paramInt, transformToMusicData(((BaseFinderFeed)paramcc).feedObject));
      AppMethodBeat.o(366341);
      return;
    }
    getDataList().add(paramInt, paramcc);
    AppMethodBeat.o(366341);
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(366329);
    i locali = (i)new b();
    AppMethodBeat.o(366329);
    return locali;
  }
  
  public final void onAlive()
  {
    AppMethodBeat.i(366318);
    super.onAlive();
    this.BiD.alive();
    AppMethodBeat.o(366318);
  }
  
  public final void onDead()
  {
    AppMethodBeat.i(366324);
    super.onDead();
    this.BiD.dead();
    AppMethodBeat.o(366324);
  }
  
  public final void onFetchDone(IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(366352);
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    if (getDataListJustForAdapter().size() > 0) {}
    for (a locala = a.BiG;; locala = a.BiF)
    {
      this.BiC = locala;
      if (!isInitOperation(paramIResponse)) {
        break;
      }
      AppMethodBeat.o(366352);
      return;
    }
    if (!paramIResponse.getHasMore())
    {
      paramIResponse = this.BbB;
      if (paramIResponse != null) {
        paramIResponse.invoke();
      }
    }
    AppMethodBeat.o(366352);
  }
  
  public final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(366336);
    s.u(paramFinderItem, "feedObj");
    if (interceptMvFeed())
    {
      paramFinderItem = transformToMusicData(paramFinderItem);
      AppMethodBeat.o(366336);
      return paramFinderItem;
    }
    paramFinderItem = super.transformFinderObj(paramFinderItem);
    AppMethodBeat.o(366336);
    return paramFinderItem;
  }
  
  public final BaseFinderFeed transformToMusicData(FinderItem paramFinderItem)
  {
    AppMethodBeat.i(366347);
    s.u(paramFinderItem, "item");
    paramFinderItem = (BaseFinderFeed)new bt(paramFinderItem);
    AppMethodBeat.o(366347);
    return paramFinderItem;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$CacheState;", "", "(Ljava/lang/String;I)V", "INIT", "NO_CACHE", "WITH_CACHED", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    static
    {
      AppMethodBeat.i(366377);
      BiE = new a("INIT", 0);
      BiF = new a("NO_CACHE", 1);
      BiG = new a("WITH_CACHED", 2);
      BiH = new a[] { BiE, BiF, BiG };
      AppMethodBeat.o(366377);
    }
    
    private a() {}
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$QQMusicDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchNetscene;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader;)V", "callInit", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "dealOnSceneEnd", "errType", "", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "fetch", "", "netscene", "", "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "isAuto", "", "genLoadMoreNetScene", "genRefreshNetScene", "getCmdIds", "", "saveFirstPage", "pullType", "objectList", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "transfromMusicInfoList", "Lcom/tencent/mm/plugin/finder/model/FinderQQMusicInfoData;", "items", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends com.tencent.mm.plugin.finder.feed.model.internal.c
  {
    public b()
    {
      AppMethodBeat.i(366204);
      AppMethodBeat.o(366204);
    }
    
    public final IResponse<cc> callInit()
    {
      AppMethodBeat.i(366246);
      Object localObject3 = k.FNg;
      Object localObject2 = this.BiI.zDJ;
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject2 = ((k.a)localObject3).eO((String)localObject1, 19);
      localObject1 = new FinderProfileQQMusicLoader.c(0, 0, "");
      localObject3 = (Iterable)localObject2;
      localObject2 = (Collection)new ArrayList();
      localObject3 = ((Iterable)localObject3).iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject2).add(new bt((FinderItem)((Iterator)localObject3).next()));
      }
      ((FinderProfileQQMusicLoader.c)localObject1).setIncrementList((List)localObject2);
      ((FinderProfileQQMusicLoader.c)localObject1).setLastBuffer(null);
      localObject1 = (IResponse)localObject1;
      AppMethodBeat.o(366246);
      return localObject1;
    }
    
    public final IResponse<cc> dealOnSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
    {
      AppMethodBeat.i(366259);
      s.u(paramp, "scene");
      if ((paramp instanceof cy))
      {
        Object localObject2 = this.BiI;
        List localList;
        int i;
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          localObject1 = FinderProfileQQMusicLoader.d.BiL;
          ((FinderProfileQQMusicLoader)localObject2).a((FinderProfileQQMusicLoader.d)localObject1);
          localList = ((cy)paramp).dWn();
          if (((cy)paramp).pullType == 2) {
            break label187;
          }
          i = 1;
        }
        label187:
        for (;;)
        {
          label71:
          if (i != 0)
          {
            localObject2 = this.BiI.zDJ;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = z.bAW();
            }
            if (localList != null)
            {
              localObject2 = new LinkedList();
              Object localObject3 = ((Iterable)localList).iterator();
              for (;;)
              {
                if (((Iterator)localObject3).hasNext())
                {
                  FinderItem localFinderItem = (FinderItem)((Iterator)localObject3).next();
                  ((LinkedList)localObject2).add(new r(0, localFinderItem.getFinderObject().id, localFinderItem.getFinderObject(), 196608));
                  continue;
                  localObject1 = FinderProfileQQMusicLoader.d.BiM;
                  break;
                  i = 0;
                  break label71;
                }
              }
              if (((LinkedList)localObject2).size() > 0)
              {
                localObject3 = k.FNg;
                if (!TextUtils.isEmpty((CharSequence)localObject1)) {
                  break label322;
                }
                localObject1 = z.bAW();
              }
            }
          }
        }
        for (;;)
        {
          s.s(localObject1, "if (TextUtils.isEmpty(us…sername() else userName!!");
          k.a.a(19, (String)localObject1, (LinkedList)localObject2);
          paramString = new FinderProfileQQMusicLoader.c(paramInt1, paramInt2, paramString);
          localObject2 = (Iterable)localList;
          localObject1 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject2, 10));
          localObject2 = ((Iterable)localObject2).iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((Collection)localObject1).add(new bt((FinderItem)((Iterator)localObject2).next()));
          }
          label322:
          s.checkNotNull(localObject1);
        }
        paramString.setIncrementList((List)localObject1);
        paramString.setPullType(((cy)paramp).pullType);
        Object localObject1 = c.c.b(((cy)paramp).oDw.otC);
        if (localObject1 == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMusicUserPageResponse");
          AppMethodBeat.o(366259);
          throw paramString;
        }
        if (((bqm)localObject1).continueFlag == 1) {}
        for (boolean bool = true;; bool = false)
        {
          paramString.setHasMore(bool);
          paramp = c.c.b(((cy)paramp).oDw.otC);
          if (paramp != null) {
            break;
          }
          paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderMusicUserPageResponse");
          AppMethodBeat.o(366259);
          throw paramString;
        }
        paramString.setLastBuffer(((bqm)paramp).lastBuffer);
        paramString = (IResponse)paramString;
        AppMethodBeat.o(366259);
        return paramString;
      }
      AppMethodBeat.o(366259);
      return null;
    }
    
    public final void fetch(Object paramObject, h<cc> paramh, boolean paramBoolean)
    {
      AppMethodBeat.i(366213);
      s.u(paramh, "callback");
      super.fetch(paramObject, paramh, paramBoolean);
      this.BiI.a(FinderProfileQQMusicLoader.d.BiK);
      AppMethodBeat.o(366213);
    }
    
    public final com.tencent.mm.am.p genLoadMoreNetScene()
    {
      AppMethodBeat.i(366237);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cy(this.BiI.ACR, this.BiI.zDJ, this.BiI.Bil, this.BiI.getLastBuffer(), 2, this.BiI.getContextObj());
      AppMethodBeat.o(366237);
      return localp;
    }
    
    public final com.tencent.mm.am.p genRefreshNetScene()
    {
      AppMethodBeat.i(366232);
      com.tencent.mm.am.p localp = (com.tencent.mm.am.p)new cy(this.BiI.ACR, this.BiI.zDJ, this.BiI.Bil, null, 0, this.BiI.getContextObj());
      AppMethodBeat.o(366232);
      return localp;
    }
    
    public final List<Integer> getCmdIds()
    {
      AppMethodBeat.i(366221);
      List localList = kotlin.a.p.listOf(Integer.valueOf(5999));
      AppMethodBeat.o(366221);
      return localList;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$QQMusicResponse;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(IILjava/lang/String;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends IResponse<cc>
  {
    public c(int paramInt1, int paramInt2, String paramString)
    {
      super(paramInt2, paramString);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderProfileQQMusicLoader$State;", "", "(Ljava/lang/String;I)V", "INIT", "LOADING", "LOADED", "FAILURE", "PRIVATE_LOCK", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum d
  {
    static
    {
      AppMethodBeat.i(366249);
      BiJ = new d("INIT", 0);
      BiK = new d("LOADING", 1);
      BiL = new d("LOADED", 2);
      BiM = new d("FAILURE", 3);
      BiN = new d("PRIVATE_LOCK", 4);
      BiO = new d[] { BiJ, BiK, BiL, BiM, BiN };
      AppMethodBeat.o(366249);
    }
    
    private d() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.FinderProfileQQMusicLoader
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.live.olympic.loader;

import com.tencent.d.a.a.a.b.b.b;
import com.tencent.d.a.a.a.b.b.b.a;
import com.tencent.d.a.a.a.b.b.f;
import com.tencent.d.a.a.a.b.b.f.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.protocal.protobuf.awr;
import com.tencent.mm.protocal.protobuf.bkq;
import com.tencent.mm.protocal.protobuf.bo;
import com.tencent.mm.protocal.protobuf.bp;
import com.tencent.mm.protocal.protobuf.bv;
import com.tencent.mm.protocal.protobuf.bw;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.protocal.protobuf.cdq;
import com.tencent.mm.protocal.protobuf.dii;
import com.tencent.mm.protocal.protobuf.esc;
import com.tencent.mm.protocal.protobuf.fgz;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "activity", "Lcom/tencent/mm/protocal/protobuf/SportActivity;", "(Lcom/tencent/mm/protocal/protobuf/SportActivity;)V", "LoaderTAG", "", "getLoaderTAG", "()Ljava/lang/String;", "getActivity", "()Lcom/tencent/mm/protocal/protobuf/SportActivity;", "fetchEndCallback", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "", "getFetchEndCallback", "()Lkotlin/jvm/functions/Function1;", "setFetchEndCallback", "(Lkotlin/jvm/functions/Function1;)V", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "debugResult", "result", "Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader$OlympicRunnerResp;", "innerResp", "Lcom/tencent/mm/protocal/protobuf/GetActivityBoardResponse;", "getActivityBoardItemInfo", "item", "Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;", "onFetchDone", "response", "printList", "board_items", "Ljava/util/LinkedList;", "prefix", "Companion", "OlympicRunnerResp", "PurchaseListFetcher", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveOlympicRunnerPannelLoader
  extends BaseFeedLoader<cc>
{
  public static final a CRC;
  private static boolean CRE;
  final fgz CNI;
  final String CRD;
  public kotlin.g.a.b<? super IResponse<cc>, kotlin.ah> fetchEndCallback;
  
  static
  {
    AppMethodBeat.i(360662);
    CRC = new a((byte)0);
    AppMethodBeat.o(360662);
  }
  
  public FinderLiveOlympicRunnerPannelLoader(fgz paramfgz)
  {
    super(null, 1, null);
    AppMethodBeat.i(360609);
    this.CNI = paramfgz;
    this.CRD = s.X("FinderLiveOlympicRunnerPannelLoader", Integer.valueOf(hashCode()));
    AppMethodBeat.o(360609);
  }
  
  private static String a(bp parambp)
  {
    boolean bool2 = true;
    Object localObject2 = null;
    Object localObject3 = null;
    AppMethodBeat.i(360617);
    Object localObject1 = aw.Gjk;
    if (aw.bgV())
    {
      localObject2 = new StringBuilder("nickname:");
      localObject1 = parambp.YDj;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = ((StringBuilder)localObject2).append(localObject1).append(",rank:").append(parambp.YDk).append(",amount:").append(parambp.ihV).append(",username:");
        localObject1 = parambp.YDj;
        if (localObject1 != null) {
          break label141;
        }
        localObject1 = null;
        label93:
        localObject1 = ((StringBuilder)localObject2).append(localObject1).append(",head url is empty:");
        parambp = parambp.YDj;
        if (parambp != null) {
          break label149;
        }
        parambp = (bp)localObject3;
      }
      label141:
      label149:
      do
      {
        parambp = parambp;
        AppMethodBeat.o(360617);
        return parambp;
        localObject1 = ((dii)localObject1).nickname;
        break;
        localObject1 = ((dii)localObject1).aanS;
        break label93;
        localObject2 = parambp.xkY;
        parambp = (bp)localObject3;
      } while (localObject2 == null);
      if (((CharSequence)localObject2).length() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        parambp = Boolean.valueOf(bool1);
        break;
      }
    }
    localObject3 = new StringBuilder("nickname:");
    localObject1 = parambp.YDj;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = ((StringBuilder)localObject3).append(localObject1).append(",rank:").append(parambp.YDk).append(",amount:").append(parambp.ihV).append(",username is empty:");
      localObject1 = parambp.YDj;
      if (localObject1 != null) {
        break label309;
      }
      localObject1 = null;
      label261:
      localObject1 = ((StringBuilder)localObject3).append(localObject1).append(",head url is empty:");
      parambp = parambp.YDj;
      if (parambp != null) {
        break label350;
      }
      parambp = (bp)localObject2;
    }
    label309:
    label350:
    do
    {
      parambp = parambp;
      AppMethodBeat.o(360617);
      return parambp;
      localObject1 = ((dii)localObject1).nickname;
      break;
      localObject1 = ((dii)localObject1).aanS;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label261;
      }
      if (((CharSequence)localObject1).length() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        localObject1 = Boolean.valueOf(bool1);
        break;
      }
      localObject3 = parambp.xkY;
      parambp = (bp)localObject2;
    } while (localObject3 == null);
    if (((CharSequence)localObject3).length() == 0) {}
    for (boolean bool1 = bool2;; bool1 = false)
    {
      parambp = Boolean.valueOf(bool1);
      break;
    }
  }
  
  public final i<cc> createDataFetch()
  {
    AppMethodBeat.i(360675);
    i locali = (i)new c();
    AppMethodBeat.o(360675);
    return locali;
  }
  
  public final void onFetchDone(final IResponse<cc> paramIResponse)
  {
    AppMethodBeat.i(360670);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aYj());
    s.u(paramIResponse, "response");
    super.onFetchDone(paramIResponse);
    d.uiThread((kotlin.g.a.a)new d(this, paramIResponse));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
    AppMethodBeat.o(360670);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader$Companion;", "", "()V", "DEBUG_LOADER", "", "getDEBUG_LOADER", "()Z", "setDEBUG_LOADER", "(Z)V", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader$OlympicRunnerResp;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "(Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader;IILjava/lang/String;)V", "req", "Lcom/tencent/mm/protocal/protobuf/GetActivityBoardRequest;", "getReq", "()Lcom/tencent/mm/protocal/protobuf/GetActivityBoardRequest;", "setReq", "(Lcom/tencent/mm/protocal/protobuf/GetActivityBoardRequest;)V", "selfBlured", "", "getSelfBlured", "()Z", "setSelfBlured", "(Z)V", "selfItem", "Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;", "getSelfItem", "()Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;", "setSelfItem", "(Lcom/tencent/mm/protocal/protobuf/ActivityBoardItem;)V", "staticConfig", "Lcom/tencent/mm/protocal/protobuf/ActivityBoardConfig;", "getStaticConfig", "()Lcom/tencent/mm/protocal/protobuf/ActivityBoardConfig;", "setStaticConfig", "(Lcom/tencent/mm/protocal/protobuf/ActivityBoardConfig;)V", "success", "getSuccess", "setSuccess", "toString", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class b
    extends IResponse<cc>
  {
    public boolean CRB;
    public bp CRF;
    public bo CRG;
    cdp CRH;
    boolean success;
    
    public b(int paramInt, String paramString)
    {
      super(paramString, str);
      AppMethodBeat.i(360614);
      AppMethodBeat.o(360614);
    }
    
    public final String toString()
    {
      Object localObject2 = null;
      AppMethodBeat.i(360623);
      StringBuilder localStringBuilder = new StringBuilder("success:").append(this.success).append(",req scene:");
      Object localObject1 = this.CRH;
      if (localObject1 == null)
      {
        localObject1 = null;
        localStringBuilder = localStringBuilder.append(localObject1).append(",hasMore:").append(getHasMore()).append(",increment size:");
        localObject1 = getIncrementList();
        if (localObject1 != null) {
          break label179;
        }
        localObject1 = null;
        label74:
        localStringBuilder = localStringBuilder.append(localObject1).append(",selfItem:");
        localObject1 = this.CRF;
        if (localObject1 != null) {
          break label192;
        }
        localObject1 = null;
        label96:
        localStringBuilder = localStringBuilder.append(localObject1).append(",selfBlured:").append(this.CRB).append(",staticConfig:");
        localObject1 = this.CRG;
        if (localObject1 != null) {
          break label200;
        }
        localObject1 = null;
        label130:
        localStringBuilder = localStringBuilder.append(localObject1).append('-');
        localObject1 = this.CRG;
        if (localObject1 != null) {
          break label208;
        }
      }
      label179:
      label192:
      label200:
      label208:
      for (localObject1 = localObject2;; localObject1 = ((bo)localObject1).YDi)
      {
        localObject1 = localObject1;
        AppMethodBeat.o(360623);
        return localObject1;
        localObject1 = Integer.valueOf(((cdp)localObject1).scene);
        break;
        localObject1 = Integer.valueOf(((List)localObject1).size());
        break label74;
        localObject1 = FinderLiveOlympicRunnerPannelLoader.b((bp)localObject1);
        break label96;
        localObject1 = ((bo)localObject1).YDh;
        break label130;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader$PurchaseListFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataFetchCgi;", "(Lcom/tencent/mm/plugin/finder/live/olympic/loader/FinderLiveOlympicRunnerPannelLoader;)V", "dealOnSceneEnd", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "errType", "", "errCode", "errMsg", "", "requestCgi", "Lcom/tencent/mm/modelbase/Cgi;", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "resp", "genLoadMoreCgi", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderLiveOpenTransferBuffer;", "Lcom/tencent/mm/protocal/protobuf/GetActivityBoardRequest;", "genRefreshCgi", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public final class c
    extends com.tencent.mm.plugin.finder.feed.model.internal.b
  {
    public c()
    {
      AppMethodBeat.i(360611);
      AppMethodBeat.o(360611);
    }
    
    public final IResponse<cc> a(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.b<? extends esc> paramb, esc paramesc)
    {
      AppMethodBeat.i(360635);
      FinderLiveOlympicRunnerPannelLoader.b localb = new FinderLiveOlympicRunnerPannelLoader.b(this.CRI, paramInt1, paramInt2, paramString);
      label44:
      label59:
      Object localObject;
      if ((paramb instanceof com.tencent.mm.plugin.finder.cgi.ah))
      {
        paramb = (com.tencent.mm.plugin.finder.cgi.ah)paramb;
        if (paramb != null) {
          break label198;
        }
        paramb = null;
        if (!(paramb instanceof cdp)) {
          break label208;
        }
        paramb = (cdp)paramb;
        localb.CRH = paramb;
        paramb = this.CRI.CRD;
        localObject = new StringBuilder("dealOnSceneEnd errType:").append(paramInt1).append(",errCode:").append(paramInt2).append(",errMsg:").append(paramString).append("(reqScene:");
        paramString = localb.CRH;
        if (paramString != null) {
          break label214;
        }
        paramString = null;
        label125:
        localObject = ((StringBuilder)localObject).append(paramString).append(", params scene:");
        paramString = this.CRI.CNI;
        if (paramString != null) {
          break label225;
        }
        paramString = null;
      }
      for (;;)
      {
        Log.i(paramb, paramString + ')');
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label304;
        }
        paramString = (IResponse)localb;
        AppMethodBeat.o(360635);
        return paramString;
        paramb = null;
        break;
        label198:
        paramb = paramb.AzQ;
        break label44;
        label208:
        paramb = null;
        break label59;
        label214:
        paramString = Integer.valueOf(paramString.scene);
        break label125;
        label225:
        paramString = paramString.abHp;
        if (paramString == null)
        {
          paramString = null;
        }
        else
        {
          paramString = (bv)p.oL((List)paramString);
          if (paramString == null)
          {
            paramString = null;
          }
          else
          {
            paramString = paramString.YDC;
            if (paramString == null)
            {
              paramString = null;
            }
            else
            {
              paramString = (bw)p.oL((List)paramString);
              if (paramString == null) {
                paramString = null;
              } else {
                paramString = Integer.valueOf(paramString.YDD);
              }
            }
          }
        }
      }
      label304:
      if ((paramesc instanceof bkq))
      {
        paramb = ((bkq)paramesc).ZQV;
        if (paramb == null)
        {
          paramString = null;
          if (paramString != null)
          {
            paramb = paramString.YGg;
            if (paramb == null) {
              break label435;
            }
            paramInt1 = paramb.ret;
            paramb = b.f.ahou;
            if (paramInt1 != b.f.a.jWd()) {
              break label435;
            }
          }
        }
        label435:
        for (paramInt1 = 1;; paramInt1 = 0) {
          for (;;)
          {
            if (paramInt1 != 0) {
              break label440;
            }
            paramString = (IResponse)localb;
            AppMethodBeat.o(360635);
            return paramString;
            paramString = (com.tencent.mm.bx.a)new cdq();
            paramb = paramb.toByteArray();
            try
            {
              paramString.parseFrom(paramb);
              paramString = (cdq)paramString;
            }
            catch (Exception paramString)
            {
              for (;;)
              {
                Log.printDebugStack("safeParser", "", new Object[] { paramString });
                paramString = null;
              }
            }
          }
        }
        label440:
        if (BuildInfo.DEBUG)
        {
          paramb = FinderLiveOlympicRunnerPannelLoader.CRC;
          if (FinderLiveOlympicRunnerPannelLoader.eof())
          {
            paramb = localb.CRH;
            if (paramb != null) {
              break label725;
            }
            paramb = null;
            paramesc = b.b.ahnZ;
            paramInt1 = b.b.a.jVS();
            if (paramb != null) {
              break label738;
            }
            label486:
            paramesc = b.b.ahnZ;
            paramInt1 = b.b.a.jVT();
            if (paramb != null) {
              break label770;
            }
            label500:
            paramesc = b.b.ahnZ;
            paramInt1 = b.b.a.jVU();
            if (paramb != null) {
              break label915;
            }
          }
        }
        localb.success = true;
        List localList = p.a((Iterable)this.CRI.getDataListJustForAdapter(), com.tencent.mm.plugin.finder.live.olympic.data.b.class);
        localObject = new LinkedList();
        if (localList.isEmpty())
        {
          ((LinkedList)localObject).addAll((Collection)paramString.aanV);
          paramb = this.CRI;
          paramesc = paramString.aanV;
          s.s(paramesc, "innerResp.board_items");
          FinderLiveOlympicRunnerPannelLoader.a(paramb, paramesc, "last_ctx:" + paramString.aanT + ",continue_flag:" + paramString.TpE + ",first list");
        }
        for (;;)
        {
          localObject = (Iterable)localObject;
          paramb = this.CRI;
          paramesc = (Collection)new ArrayList(p.a((Iterable)localObject, 10));
          localObject = ((Iterable)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramesc.add(new com.tencent.mm.plugin.finder.live.olympic.data.b((bp)((Iterator)localObject).next(), 0, null, paramb.CNI, false, 22));
          }
          label725:
          paramb = Integer.valueOf(paramb.scene);
          break;
          label738:
          if (paramb.intValue() != paramInt1) {
            break label486;
          }
          FinderLiveOlympicRunnerPannelLoader.a(this.CRI, localb, paramString);
          paramString = (IResponse)localb;
          AppMethodBeat.o(360635);
          return paramString;
          if (paramb.intValue() != paramInt1) {
            break label500;
          }
          paramb = paramString.aanW;
          if (paramb == null)
          {
            paramb = null;
            if (paramb != null)
            {
              paramesc = paramString.aanV;
              if (paramesc != null) {
                break label870;
              }
              paramesc = null;
              paramb.aanS = s.X("test_", paramesc);
            }
            paramb = paramString.aanW;
            if (paramb == null) {
              break label514;
            }
            paramesc = paramString.aanV;
            if (paramesc != null) {
              break label883;
            }
            paramInt1 = 0;
          }
          for (;;)
          {
            paramb.YDk = (paramInt1 + 1);
            break;
            paramb = paramb.YDj;
            break label793;
            label870:
            paramesc = Integer.valueOf(paramesc.size());
            break label812;
            label883:
            paramesc = (bp)p.oN((List)paramesc);
            if (paramesc == null) {
              paramInt1 = 0;
            } else {
              paramInt1 = paramesc.YDk;
            }
          }
          if (paramb.intValue() != paramInt1) {
            break label514;
          }
          paramb = paramString.aanW;
          if (paramb == null) {}
          for (paramb = null;; paramb = paramb.YDj)
          {
            if (paramb != null) {
              paramb.aanS = "2";
            }
            paramb = paramString.aanW;
            if (paramb == null) {
              break;
            }
            paramb.YDk = 3;
            break;
          }
          paramb = paramString.aanV;
          s.s(paramb, "innerResp.board_items");
          paramb = (Iterable)paramb;
          FinderLiveOlympicRunnerPannelLoader localFinderLiveOlympicRunnerPannelLoader = this.CRI;
          Iterator localIterator1 = paramb.iterator();
          while (localIterator1.hasNext())
          {
            bp localbp = (bp)localIterator1.next();
            Iterator localIterator2 = localList.iterator();
            paramInt1 = 0;
            if (localIterator2.hasNext())
            {
              paramesc = (com.tencent.mm.plugin.finder.live.olympic.data.b)localIterator2.next();
              paramb = localbp.YDj;
              if (paramb == null)
              {
                paramb = null;
                label1087:
                paramesc = paramesc.CRz.YDj;
                if (paramesc != null) {
                  break label1170;
                }
                paramesc = null;
                label1105:
                if (!s.p(paramb, paramesc)) {
                  break label1180;
                }
                label1115:
                if (paramInt1 == -1) {
                  break label1192;
                }
              }
            }
            for (paramInt1 = 1;; paramInt1 = 0)
            {
              if (paramInt1 == 0) {
                break label1197;
              }
              paramb = localFinderLiveOlympicRunnerPannelLoader.CRD;
              s.s(localbp, "newFeed");
              Log.i(paramb, s.X("repeat feed:", FinderLiveOlympicRunnerPannelLoader.b(localbp)));
              break;
              paramb = paramb.aanS;
              break label1087;
              paramesc = paramesc.aanS;
              break label1105;
              paramInt1 += 1;
              break label1050;
              paramInt1 = -1;
              break label1115;
            }
            ((LinkedList)localObject).add(localbp);
          }
          FinderLiveOlympicRunnerPannelLoader.a(this.CRI, (LinkedList)localObject, "last_ctx:" + paramString.aanT + ",continue_flag:" + paramString.TpE + ",increment list");
        }
        localb.setIncrementList((List)new LinkedList((Collection)paramesc));
        localb.CRF = paramString.aanW;
        localb.setLastBuffer(paramString.aanT);
        localb.setHasMore(paramString.TpE);
        localb.CRG = paramString.aaoa;
        localb.CRB = paramString.aanY;
        localb.setPullType(2);
      }
      label514:
      label793:
      label812:
      label1197:
      paramString = (IResponse)localb;
      label770:
      label915:
      label1050:
      label1180:
      label1192:
      AppMethodBeat.o(360635);
      label1170:
      return paramString;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<kotlin.ah>
  {
    d(FinderLiveOlympicRunnerPannelLoader paramFinderLiveOlympicRunnerPannelLoader, IResponse<cc> paramIResponse)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.loader.FinderLiveOlympicRunnerPannelLoader
 * JD-Core Version:    0.7.0.1
 */
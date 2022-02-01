package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.app.f;
import com.tencent.mm.bx.b;
import com.tencent.mm.plugin.finder.cgi.dm;
import com.tencent.mm.plugin.finder.live.report.d;
import com.tencent.mm.plugin.finder.live.report.q.w;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.model.z;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bvu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/ArrayList;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getDataList", "()Ljava/util/ArrayList;", "feedUpdateListener", "com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1;", "lastScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "getLastScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "setLastScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;)V", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "checkCleanRefresh", "responseList", "clearAll", "", "initData", "loadMore", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "release", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements com.tencent.mm.am.h
{
  public static boolean ABD;
  public static final a BiT;
  public static ArrayList<cc> BiX;
  public static b lastBuffer;
  public final bui Auc;
  public boolean Bcz;
  public final k BiU;
  public dm BiV;
  public final FinderSnsHeaderLoader.feedUpdateListener.1 BiW;
  public final String TAG;
  public final ArrayList<cc> pUj;
  
  static
  {
    AppMethodBeat.i(365997);
    BiT = new a((byte)0);
    BiX = new ArrayList();
    ABD = true;
    AppMethodBeat.o(365997);
  }
  
  public l(ArrayList<cc> paramArrayList, k paramk)
  {
    AppMethodBeat.i(365987);
    this.pUj = paramArrayList;
    this.BiU = paramk;
    this.TAG = "Finder.FinderSnsHeaderLoader";
    paramArrayList = new bui();
    paramArrayList.AJo = 61;
    paramk = ah.aiuX;
    this.Auc = paramArrayList;
    this.BiW = new FinderSnsHeaderLoader.feedUpdateListener.1(this, f.hfK);
    AppMethodBeat.o(365987);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(366026);
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((kotlin.g.b.s.p(paramp, this.BiV)) && (paramp != null) && ((paramp instanceof dm))) {
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        if (((dm)paramp).ADl.size() > 0) {
          if (((dm)paramp).pullType != 2)
          {
            localObject2 = this.pUj;
            localObject3 = ((dm)paramp).ADl;
            if (((ArrayList)localObject2).size() == ((ArrayList)localObject3).size())
            {
              localObject4 = (List)new ArrayList();
              paramInt2 = ((ArrayList)localObject2).size();
              if (paramInt2 >= 0) {
                paramInt1 = 0;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramString = (cc)kotlin.a.p.ae((List)localObject2, paramInt1);
      Object localObject1;
      if (paramString == null)
      {
        paramString = null;
        localObject1 = (cc)kotlin.a.p.ae((List)localObject3, paramInt1);
        if (localObject1 != null) {
          break label269;
        }
        localObject1 = null;
        label158:
        if ((kotlin.g.b.s.p(paramString, localObject1)) && (kotlin.a.p.ae((List)localObject2, paramInt1) != null)) {
          break label284;
        }
        paramInt1 = 1;
        label181:
        if (paramInt1 != 0)
        {
          this.pUj.clear();
          this.pUj.addAll((Collection)((dm)paramp).ADl);
          this.BiU.onChanged();
        }
      }
      for (;;)
      {
        paramString = c.c.b(((dm)paramp).rr.otC);
        if (paramString != null) {
          break label743;
        }
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
        AppMethodBeat.o(366026);
        throw paramString;
        paramString = Long.valueOf(paramString.bZA());
        break;
        label269:
        localObject1 = Long.valueOf(((cc)localObject1).bZA());
        break label158;
        label284:
        ((ArrayList)localObject2).set(paramInt1, ((ArrayList)localObject3).get(paramInt1));
        ((List)localObject4).add(Integer.valueOf(paramInt1));
        if (paramInt1 != paramInt2) {
          break label907;
        }
        paramString = ((Iterable)localObject4).iterator();
        while (paramString.hasNext())
        {
          paramInt1 = ((Number)paramString.next()).intValue();
          this.BiU.onItemRangeChanged(paramInt1, 1, Integer.valueOf(1));
        }
        paramInt1 = 0;
        break label181;
        paramInt1 = 1;
        break label181;
        int i = this.pUj.size();
        paramString = new ArrayList();
        localObject1 = ((Iterable)((dm)paramp).ADl).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (cc)((Iterator)localObject1).next();
          if ((localObject2 instanceof z))
          {
            localObject3 = ((z)localObject2).ECN.liveInfo;
            long l;
            if (localObject3 == null)
            {
              l = 0L;
              label461:
              localObject3 = (List)this.pUj;
              paramInt1 = 0;
              localObject3 = ((List)localObject3).iterator();
              label481:
              if (!((Iterator)localObject3).hasNext()) {
                break label630;
              }
              localObject4 = (cc)((Iterator)localObject3).next();
              if (!(localObject4 instanceof z)) {
                break label618;
              }
              localObject4 = ((z)localObject4).ECN.liveInfo;
              if ((localObject4 == null) || (((bip)localObject4).liveId != l)) {
                break label613;
              }
              paramInt2 = 1;
              label542:
              if (paramInt2 == 0) {
                break label618;
              }
              paramInt2 = 1;
              label548:
              if (paramInt2 == 0) {
                break label623;
              }
            }
            for (;;)
            {
              if (paramInt1 < 0) {
                break label635;
              }
              this.pUj.set(paramInt1, localObject2);
              this.BiU.onItemRangeChanged(paramInt1, 1, Integer.valueOf(1));
              Log.i(this.TAG, kotlin.g.b.s.X("loadmore, exist, ", Long.valueOf(l)));
              break;
              l = ((bip)localObject3).liveId;
              break label461;
              label613:
              paramInt2 = 0;
              break label542;
              label618:
              paramInt2 = 0;
              break label548;
              label623:
              paramInt1 += 1;
              break label481;
              label630:
              paramInt1 = -1;
            }
            label635:
            paramString.add(localObject2);
          }
          else
          {
            paramString.add(localObject2);
          }
        }
        Log.i(this.TAG, kotlin.g.b.s.X("loadmore, append size:", Integer.valueOf(paramString.size())));
        if (paramString.size() > 0)
        {
          this.pUj.addAll((Collection)paramString);
          this.BiU.onItemRangeInserted(i, paramString.size());
          continue;
          if (((dm)paramp).pullType != 2)
          {
            this.pUj.clear();
            this.BiU.onChanged();
          }
        }
      }
      label743:
      lastBuffer = ((bvu)paramString).lastBuffer;
      paramString = c.c.b(((dm)paramp).rr.otC);
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
        AppMethodBeat.o(366026);
        throw paramString;
      }
      if (((bvu)paramString).continueFlag != 0) {}
      for (boolean bool = true;; bool = false)
      {
        ABD = bool;
        Log.i(this.TAG, "onSceneEnd, pullType:" + ((dm)paramp).pullType + ", curSize:" + this.pUj.size() + " continueFlag:" + ABD);
        ((ce)com.tencent.mm.kernel.h.ax(ce.class)).b(null, q.w.DwO, "61", d.Dnh);
        this.Bcz = false;
        AppMethodBeat.o(366026);
        return;
      }
      label907:
      paramInt1 += 1;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(366004);
    com.tencent.mm.kernel.h.aZW().b(6847, (com.tencent.mm.am.h)this);
    this.BiW.dead();
    AppMethodBeat.o(366004);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$Companion;", "", "()V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "dataCache", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataCache", "()Ljava/util/ArrayList;", "setDataCache", "(Ljava/util/ArrayList;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.l
 * JD-Core Version:    0.7.0.1
 */
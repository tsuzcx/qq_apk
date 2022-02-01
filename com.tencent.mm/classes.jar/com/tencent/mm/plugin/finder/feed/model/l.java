package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.a.hu;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.cgi.cl;
import com.tencent.mm.plugin.finder.live.report.c;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.t;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.bjk;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/ArrayList;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getDataList", "()Ljava/util/ArrayList;", "feedUpdateListener", "com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1;", "lastScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "getLastScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "setLastScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;)V", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "checkCleanRefresh", "responseList", "clearAll", "", "initData", "loadMore", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "release", "Companion", "plugin-finder_release"})
public final class l
  implements i
{
  public static b lastBuffer;
  public static ArrayList<bu> xJm;
  public static final a xJn;
  public static boolean xcp;
  public final String TAG;
  public final ArrayList<bu> mXB;
  public boolean xFl;
  public cl xJj;
  public final b xJk;
  public final com.tencent.mm.view.j xJl;
  public final bid xbu;
  
  static
  {
    AppMethodBeat.i(270056);
    xJn = new a((byte)0);
    xJm = new ArrayList();
    xcp = true;
    AppMethodBeat.o(270056);
  }
  
  public l(ArrayList<bu> paramArrayList, com.tencent.mm.view.j paramj)
  {
    AppMethodBeat.i(270054);
    this.mXB = paramArrayList;
    this.xJl = paramj;
    this.TAG = "Finder.FinderSnsHeaderLoader";
    paramArrayList = new bid();
    paramArrayList.xkX = 61;
    this.xbu = paramArrayList;
    this.xJk = new b(this);
    AppMethodBeat.o(270054);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(270052);
    if ((p.h(paramq, this.xJj)) && (paramq != null) && ((paramq instanceof cl))) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        label144:
        Object localObject1;
        if (((cl)paramq).xec.size() > 0) {
          if (((cl)paramq).pullType != 2)
          {
            localObject2 = this.mXB;
            localObject3 = ((cl)paramq).xec;
            if (((ArrayList)localObject2).size() == ((ArrayList)localObject3).size())
            {
              localObject4 = (List)new ArrayList();
              paramInt2 = ((ArrayList)localObject2).size();
              if (paramInt2 >= 0)
              {
                paramInt1 = 0;
                paramString = (bu)kotlin.a.j.M((List)localObject2, paramInt1);
                if (paramString != null)
                {
                  paramString = Long.valueOf(paramString.mf());
                  localObject1 = (bu)kotlin.a.j.M((List)localObject3, paramInt1);
                  if (localObject1 == null) {
                    break label277;
                  }
                  localObject1 = Long.valueOf(((bu)localObject1).mf());
                  label175:
                  if ((!(p.h(paramString, localObject1) ^ true)) && (kotlin.a.j.M((List)localObject2, paramInt1) != null)) {
                    break label283;
                  }
                  paramInt1 = 1;
                  label200:
                  if (paramInt1 != 0)
                  {
                    this.mXB.clear();
                    this.mXB.addAll((Collection)((cl)paramq).xec);
                    this.xJl.onChanged();
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          paramString = ((cl)paramq).rr.bhY();
          if (paramString != null) {
            break label745;
          }
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
          AppMethodBeat.o(270052);
          throw paramString;
          paramString = null;
          break label144;
          label277:
          localObject1 = null;
          break label175;
          label283:
          ((ArrayList)localObject2).set(paramInt1, ((ArrayList)localObject3).get(paramInt1));
          ((List)localObject4).add(Integer.valueOf(paramInt1));
          if (paramInt1 != paramInt2)
          {
            paramInt1 += 1;
            break;
          }
          paramString = ((Iterable)localObject4).iterator();
          while (paramString.hasNext())
          {
            paramInt1 = ((Number)paramString.next()).intValue();
            this.xJl.onItemRangeChanged(paramInt1, 1, Integer.valueOf(1));
          }
          paramInt1 = 0;
          break label200;
          paramInt1 = 1;
          break label200;
          int i = this.mXB.size();
          paramString = new ArrayList();
          localObject1 = ((Iterable)((cl)paramq).xec).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bu)((Iterator)localObject1).next();
            if ((localObject2 instanceof y))
            {
              localObject3 = ((y)localObject2).zAF.liveInfo;
              long l;
              if (localObject3 != null)
              {
                l = ((bac)localObject3).liveId;
                label471:
                localObject3 = (List)this.mXB;
                paramInt1 = 0;
                localObject3 = ((List)localObject3).iterator();
                label491:
                if (!((Iterator)localObject3).hasNext()) {
                  break label625;
                }
                localObject4 = (bu)((Iterator)localObject3).next();
                if (!(localObject4 instanceof y)) {
                  break label613;
                }
                localObject4 = ((y)localObject4).zAF.liveInfo;
                if ((localObject4 == null) || (((bac)localObject4).liveId != l)) {
                  break label613;
                }
                paramInt2 = 1;
                label552:
                if (paramInt2 == 0) {
                  break label618;
                }
              }
              for (;;)
              {
                if (paramInt1 < 0) {
                  break label630;
                }
                this.mXB.set(paramInt1, localObject2);
                this.xJl.onItemRangeChanged(paramInt1, 1, Integer.valueOf(1));
                Log.i(this.TAG, "loadmore, exist, ".concat(String.valueOf(l)));
                break;
                l = 0L;
                break label471;
                label613:
                paramInt2 = 0;
                break label552;
                label618:
                paramInt1 += 1;
                break label491;
                label625:
                paramInt1 = -1;
              }
              label630:
              paramString.add(localObject2);
            }
            else
            {
              paramString.add(localObject2);
            }
          }
          Log.i(this.TAG, "loadmore, append size:" + paramString.size());
          if (paramString.size() > 0)
          {
            this.mXB.addAll((Collection)paramString);
            this.xJl.onItemRangeInserted(i, paramString.size());
            continue;
            if (((cl)paramq).pullType != 2)
            {
              this.mXB.clear();
              this.xJl.onChanged();
            }
          }
        }
        label745:
        lastBuffer = ((bjk)paramString).lastBuffer;
        paramString = ((cl)paramq).rr.bhY();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
          AppMethodBeat.o(270052);
          throw paramString;
        }
        if (((bjk)paramString).continueFlag == 0) {
          break label893;
        }
      }
    }
    label893:
    for (boolean bool = true;; bool = false)
    {
      xcp = bool;
      Log.i(this.TAG, "onSceneEnd, pullType:" + ((cl)paramq).pullType + ", curSize:" + this.mXB.size() + " continueFlag:" + xcp);
      paramString = k.yBj;
      k.b(null, s.t.yGM, "61", c.yAk);
      this.xFl = false;
      AppMethodBeat.o(270052);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(270047);
    h.aGY().b(6847, (i)this);
    this.xJk.dead();
    AppMethodBeat.o(270047);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$Companion;", "", "()V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "dataCache", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataCache", "()Ljava/util/ArrayList;", "setDataCache", "(Ljava/util/ArrayList;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hu>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.l
 * JD-Core Version:    0.7.0.1
 */
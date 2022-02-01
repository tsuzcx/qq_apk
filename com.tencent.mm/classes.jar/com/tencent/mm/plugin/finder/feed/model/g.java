package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.y;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s.p;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bcp;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "viewCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "(Ljava/util/ArrayList;Lcom/tencent/mm/view/IViewActionCallback;)V", "TAG", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "getDataList", "()Ljava/util/ArrayList;", "feedUpdateListener", "com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1;", "lastScene", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "getLastScene", "()Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;", "setLastScene", "(Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderSnsGetLiveObjectList;)V", "requesting", "", "getRequesting", "()Z", "setRequesting", "(Z)V", "getViewCallback", "()Lcom/tencent/mm/view/IViewActionCallback;", "checkCleanRefresh", "responseList", "clearAll", "", "initData", "loadMore", "onSceneEnd", "errType", "", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refresh", "release", "Companion", "plugin-finder_release"})
public final class g
  implements i
{
  public static b lastBuffer;
  public static ArrayList<bo> tXm;
  public static final a tXn;
  public static boolean tuG;
  public final String TAG;
  public final ArrayList<bo> kgc;
  public boolean tUq;
  public ch tXj;
  public final b tXk;
  public final com.tencent.mm.view.j tXl;
  public final bbn ttO;
  
  static
  {
    AppMethodBeat.i(244864);
    tXn = new a((byte)0);
    tXm = new ArrayList();
    tuG = true;
    AppMethodBeat.o(244864);
  }
  
  public g(ArrayList<bo> paramArrayList, com.tencent.mm.view.j paramj)
  {
    AppMethodBeat.i(244863);
    this.kgc = paramArrayList;
    this.tXl = paramj;
    this.TAG = "Finder.FinderSnsHeaderLoader";
    paramArrayList = new bbn();
    paramArrayList.tCE = 61;
    this.ttO = paramArrayList;
    this.tXk = new b(this);
    AppMethodBeat.o(244863);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(244862);
    if ((p.j(paramq, this.tXj)) && (paramq != null) && ((paramq instanceof ch))) {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        Object localObject2;
        Object localObject3;
        Object localObject4;
        label144:
        Object localObject1;
        if (((ch)paramq).twn.size() > 0) {
          if (((ch)paramq).pullType != 2)
          {
            localObject2 = this.kgc;
            localObject3 = ((ch)paramq).twn;
            if (((ArrayList)localObject2).size() == ((ArrayList)localObject3).size())
            {
              localObject4 = (List)new ArrayList();
              paramInt2 = ((ArrayList)localObject2).size();
              if (paramInt2 >= 0)
              {
                paramInt1 = 0;
                paramString = (bo)kotlin.a.j.L((List)localObject2, paramInt1);
                if (paramString != null)
                {
                  paramString = Long.valueOf(paramString.lT());
                  localObject1 = (bo)kotlin.a.j.L((List)localObject3, paramInt1);
                  if (localObject1 == null) {
                    break label277;
                  }
                  localObject1 = Long.valueOf(((bo)localObject1).lT());
                  label175:
                  if ((!(p.j(paramString, localObject1) ^ true)) && (kotlin.a.j.L((List)localObject2, paramInt1) != null)) {
                    break label283;
                  }
                  paramInt1 = 1;
                  label200:
                  if (paramInt1 != 0)
                  {
                    this.kgc.clear();
                    this.kgc.addAll((Collection)((ch)paramq).twn);
                    this.tXl.onChanged();
                  }
                }
              }
            }
          }
        }
        for (;;)
        {
          paramString = ((ch)paramq).rr.aYK();
          if (paramString != null) {
            break label745;
          }
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
          AppMethodBeat.o(244862);
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
            this.tXl.onItemRangeChanged(paramInt1, 1, Integer.valueOf(1));
          }
          paramInt1 = 0;
          break label200;
          paramInt1 = 1;
          break label200;
          int i = this.kgc.size();
          paramString = new ArrayList();
          localObject1 = ((Iterable)((ch)paramq).twn).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (bo)((Iterator)localObject1).next();
            if ((localObject2 instanceof y))
            {
              localObject3 = ((y)localObject2).uOo.liveInfo;
              long l;
              if (localObject3 != null)
              {
                l = ((awe)localObject3).liveId;
                label471:
                localObject3 = (List)this.kgc;
                paramInt1 = 0;
                localObject3 = ((List)localObject3).iterator();
                label491:
                if (!((Iterator)localObject3).hasNext()) {
                  break label625;
                }
                localObject4 = (bo)((Iterator)localObject3).next();
                if (!(localObject4 instanceof y)) {
                  break label613;
                }
                localObject4 = ((y)localObject4).uOo.liveInfo;
                if ((localObject4 == null) || (((awe)localObject4).liveId != l)) {
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
                this.kgc.set(paramInt1, localObject2);
                this.tXl.onItemRangeChanged(paramInt1, 1, Integer.valueOf(1));
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
            this.kgc.addAll((Collection)paramString);
            this.tXl.onItemRangeInserted(i, paramString.size());
            continue;
            if (((ch)paramq).pullType != 2)
            {
              this.kgc.clear();
              this.tXl.onChanged();
            }
          }
        }
        label745:
        lastBuffer = ((bcp)paramString).lastBuffer;
        paramString = ((ch)paramq).rr.aYK();
        if (paramString == null)
        {
          paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderSnsGetLiveObjectListResponse");
          AppMethodBeat.o(244862);
          throw paramString;
        }
        if (((bcp)paramString).continueFlag == 0) {
          break label893;
        }
      }
    }
    label893:
    for (boolean bool = true;; bool = false)
    {
      tuG = bool;
      Log.i(this.TAG, "onSceneEnd, pullType:" + ((ch)paramq).pullType + ", curSize:" + this.kgc.size() + " continueFlag:" + tuG);
      paramString = k.vkd;
      k.b(null, s.p.voz, "61", c.vjh);
      this.tUq = false;
      AppMethodBeat.o(244862);
      return;
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(244861);
    com.tencent.mm.kernel.g.azz().b(6847, (i)this);
    this.tXk.dead();
    AppMethodBeat.o(244861);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$Companion;", "", "()V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "dataCache", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "getDataCache", "()Ljava/util/ArrayList;", "setDataCache", "(Ljava/util/ArrayList;)V", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "setLastBuffer", "(Lcom/tencent/mm/protobuf/ByteString;)V", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/feed/model/FinderSnsHeaderLoader$feedUpdateListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
  public static final class b
    extends IListener<hn>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.g
 * JD-Core Version:    0.7.0.1
 */
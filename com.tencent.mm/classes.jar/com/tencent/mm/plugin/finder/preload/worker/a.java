package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.c;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.g.b.p;
import d.k.h;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "()V", "onClearAll", "", "onMediaFocus", "mediaId", "", "isFocused", "", "onPreloadStart", "onPreloadStop", "onRelease", "preload", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a slA;
  
  static
  {
    AppMethodBeat.i(203058);
    slA = new a((byte)0);
    AppMethodBeat.o(203058);
  }
  
  public static void a(BaseFinderFeed paramBaseFinderFeed, List<o<al, List<bvf>>> paramList)
  {
    AppMethodBeat.i(203056);
    p.h(paramBaseFinderFeed, "centerFeed");
    p.h(paramList, "dataList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(203056);
      return;
    }
    Object localObject1 = paramList.iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (o)((Iterator)localObject1).next();
      if ((((o)localObject2).first instanceof BaseFinderFeed))
      {
        localObject2 = ((o)localObject2).first;
        if (localObject2 == null)
        {
          paramBaseFinderFeed = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(203056);
          throw paramBaseFinderFeed;
        }
        if (((BaseFinderFeed)localObject2).feedObject.getExpectId() == paramBaseFinderFeed.feedObject.getExpectId())
        {
          j = 1;
          label128:
          if (j == 0) {
            break label147;
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label159;
      }
      AppMethodBeat.o(203056);
      return;
      j = 0;
      break label128;
      label147:
      i += 1;
      break;
      i = -1;
    }
    label159:
    i = Math.max(0, i - 1);
    paramBaseFinderFeed = new StringBuilder();
    localObject1 = new LinkedList();
    Object localObject2 = (Iterable)paramList.subList(i, paramList.size());
    paramList = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    Object localObject3;
    Object localObject4;
    label324:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (o)localObject3;
      if ((((o)localObject4).first instanceof BaseFinderFeed))
      {
        localObject4 = ((o)localObject4).first;
        if (localObject4 == null)
        {
          paramBaseFinderFeed = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(203056);
          throw paramBaseFinderFeed;
        }
        if (((BaseFinderFeed)localObject4).feedObject.getMediaType() != 2) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label324;
        }
        paramList.add(localObject3);
        break;
      }
    }
    paramList = ((Iterable)paramList).iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localObject2 = paramList.next();
      if (i < 0) {
        j.gfB();
      }
      localObject2 = (o)localObject2;
      if (i < 4)
      {
        localObject3 = new StringBuilder("feed=");
        localObject4 = ((o)localObject2).first;
        if (localObject4 == null)
        {
          paramBaseFinderFeed = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(203056);
          throw paramBaseFinderFeed;
        }
        paramBaseFinderFeed.append(c.rc(((BaseFinderFeed)localObject4).feedObject.getFeedObject().id) + " mediaSize=" + ((List)((o)localObject2).second).size() + " | ");
        localObject2 = ((Iterable)((List)((o)localObject2).second).subList(0, Math.min(2, ((List)((o)localObject2).second).size()))).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bvf)((Iterator)localObject2).next();
          ((LinkedList)localObject1).add(new g((bvf)localObject3, r.syD));
          paramBaseFinderFeed.append(((bvf)localObject3).mediaId.subSequence(0, h.lq(5, ((bvf)localObject3).mediaId.length()))).append(",");
        }
        paramBaseFinderFeed.append("\n");
      }
      i += 1;
    }
    paramList = ((Iterable)localObject1).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (g)paramList.next();
      localObject3 = i.sja;
      i.cCB().bI(localObject2).aqI();
    }
    ad.i("ImagePreloadWorker", "[preload] size=" + ((LinkedList)localObject1).size() + ' ' + paramBaseFinderFeed);
    AppMethodBeat.o(203056);
  }
  
  public static void ahH(String paramString)
  {
    AppMethodBeat.i(203057);
    p.h(paramString, "mediaId");
    AppMethodBeat.o(203057);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker$Companion;", "", "()V", "EVER_FEED_COUNT", "", "PRELOAD_FEED_COUNT", "PRELOAD_FEED_PRE_COUNT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.a
 * JD-Core Version:    0.7.0.1
 */
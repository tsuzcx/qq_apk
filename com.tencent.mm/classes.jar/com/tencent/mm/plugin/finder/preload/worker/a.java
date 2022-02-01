package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.g;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import d.o;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "()V", "onClearAll", "", "onMediaFocus", "mediaId", "", "isFocused", "", "onPreloadStart", "onPreloadStop", "onRelease", "preload", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a svr;
  
  static
  {
    AppMethodBeat.i(203599);
    svr = new a((byte)0);
    AppMethodBeat.o(203599);
  }
  
  public static void a(BaseFinderFeed paramBaseFinderFeed, List<o<am, List<bvz>>> paramList)
  {
    AppMethodBeat.i(203597);
    p.h(paramBaseFinderFeed, "centerFeed");
    p.h(paramList, "dataList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(203597);
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
          AppMethodBeat.o(203597);
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
      AppMethodBeat.o(203597);
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
    localObject1 = new StringBuilder();
    Object localObject2 = new LinkedList();
    paramList = (Iterable)paramList.subList(i, paramList.size());
    paramBaseFinderFeed = (Collection)new ArrayList();
    paramList = paramList.iterator();
    Object localObject3;
    Object localObject4;
    label320:
    while (paramList.hasNext())
    {
      localObject3 = paramList.next();
      localObject4 = (o)localObject3;
      if ((((o)localObject4).first instanceof BaseFinderFeed))
      {
        localObject4 = ((o)localObject4).first;
        if (localObject4 == null)
        {
          paramBaseFinderFeed = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(203597);
          throw paramBaseFinderFeed;
        }
        if (((BaseFinderFeed)localObject4).feedObject.getMediaType() != 2) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label320;
        }
        paramBaseFinderFeed.add(localObject3);
        break;
      }
    }
    paramList = ((Iterable)paramBaseFinderFeed).iterator();
    i = 0;
    while (paramList.hasNext())
    {
      paramBaseFinderFeed = paramList.next();
      if (i < 0) {
        d.a.j.gkd();
      }
      paramBaseFinderFeed = (o)paramBaseFinderFeed;
      if (i < 4)
      {
        localObject3 = new StringBuilder("feed=");
        localObject4 = paramBaseFinderFeed.first;
        if (localObject4 == null)
        {
          paramBaseFinderFeed = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(203597);
          throw paramBaseFinderFeed;
        }
        ((StringBuilder)localObject1).append(c.rp(((BaseFinderFeed)localObject4).feedObject.getFeedObject().id) + " mediaSize=" + ((List)paramBaseFinderFeed.second).size() + " | ");
        localObject3 = ((Iterable)((List)paramBaseFinderFeed.second).subList(0, Math.min(2, ((List)paramBaseFinderFeed.second).size()))).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bvz)((Iterator)localObject3).next();
          ((LinkedList)localObject2).add(new g((bvz)localObject4, r.sJu));
          paramBaseFinderFeed = ((bvz)localObject4).mediaId;
          if (paramBaseFinderFeed != null)
          {
            localObject4 = ((bvz)localObject4).mediaId;
            if (localObject4 != null) {
              j = ((String)localObject4).length();
            }
          }
          label572:
          for (paramBaseFinderFeed = paramBaseFinderFeed.subSequence(0, d.k.j.lx(5, j));; paramBaseFinderFeed = null)
          {
            ((StringBuilder)localObject1).append(paramBaseFinderFeed).append(",");
            break;
            j = 0;
            break label572;
          }
        }
        ((StringBuilder)localObject1).append("\n");
      }
      i += 1;
    }
    paramBaseFinderFeed = ((Iterable)localObject2).iterator();
    while (paramBaseFinderFeed.hasNext())
    {
      paramList = (g)paramBaseFinderFeed.next();
      localObject3 = i.srW;
      i.cEn().bI(paramList).aqX();
    }
    ae.i("ImagePreloadWorker", "[preload] size=" + ((LinkedList)localObject2).size() + ' ' + localObject1);
    AppMethodBeat.o(203597);
  }
  
  public static void aiF(String paramString)
  {
    AppMethodBeat.i(203598);
    p.h(paramString, "mediaId");
    AppMethodBeat.o(203598);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker$Companion;", "", "()V", "EVER_FEED_COUNT", "", "PRELOAD_FEED_COUNT", "PRELOAD_FEED_PRE_COUNT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.a
 * JD-Core Version:    0.7.0.1
 */
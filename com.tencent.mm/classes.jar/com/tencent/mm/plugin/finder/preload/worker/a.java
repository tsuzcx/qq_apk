package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.c;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "()V", "onActivityStart", "", "onActivityStop", "onClearAll", "onMediaFocus", "mediaId", "", "isFocused", "", "onRelease", "preload", "centerFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a rvZ;
  
  static
  {
    AppMethodBeat.i(202637);
    rvZ = new a((byte)0);
    AppMethodBeat.o(202637);
  }
  
  public static void a(BaseFinderFeed paramBaseFinderFeed, List<o<BaseFinderFeed, List<bqs>>> paramList)
  {
    AppMethodBeat.i(202635);
    k.h(paramBaseFinderFeed, "centerFeed");
    k.h(paramList, "dataList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(202635);
      return;
    }
    Object localObject1 = paramList.iterator();
    int i = 0;
    int j;
    label87:
    label91:
    Object localObject2;
    if (((Iterator)localObject1).hasNext()) {
      if (((BaseFinderFeed)((o)((Iterator)localObject1).next()).first).feedObject.getExpectId() == paramBaseFinderFeed.feedObject.getExpectId())
      {
        j = 1;
        if (j == 0) {
          break label217;
        }
        i = Math.max(0, i - 1);
        paramBaseFinderFeed = new StringBuilder();
        localObject1 = new LinkedList();
        localObject2 = (Iterable)paramList.subList(i, paramList.size());
        paramList = (Collection)new ArrayList();
        localObject2 = ((Iterable)localObject2).iterator();
      }
    }
    label154:
    Object localObject3;
    label217:
    label232:
    for (;;)
    {
      if (!((Iterator)localObject2).hasNext()) {
        break label234;
      }
      localObject3 = ((Iterator)localObject2).next();
      if (((BaseFinderFeed)((o)localObject3).first).feedObject.getMediaType() == 2) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label232;
        }
        paramList.add(localObject3);
        break label154;
        j = 0;
        break label87;
        i += 1;
        break;
        i = -1;
        break label91;
      }
    }
    label234:
    paramList = ((Iterable)paramList).iterator();
    i = 0;
    while (paramList.hasNext())
    {
      localObject2 = paramList.next();
      if (i < 0) {
        j.fOc();
      }
      localObject2 = (o)localObject2;
      if (i < 4)
      {
        paramBaseFinderFeed.append("feed=" + c.pb(((BaseFinderFeed)((o)localObject2).first).feedObject.getFeedObject().id) + " mediaSize=" + ((List)((o)localObject2).second).size() + " | ");
        localObject2 = ((Iterable)((List)((o)localObject2).second).subList(0, Math.min(2, ((List)((o)localObject2).second).size()))).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bqs)((Iterator)localObject2).next();
          ((LinkedList)localObject1).add(new f((bqs)localObject3, m.rDQ));
          paramBaseFinderFeed.append(((bqs)localObject3).mediaId.subSequence(0, d.k.h.lb(5, ((bqs)localObject3).mediaId.length()))).append(",");
        }
        paramBaseFinderFeed.append("\n");
      }
      i += 1;
    }
    paramList = ((Iterable)localObject1).iterator();
    while (paramList.hasNext())
    {
      localObject2 = (f)paramList.next();
      localObject3 = com.tencent.mm.plugin.finder.loader.h.rtK;
      com.tencent.mm.plugin.finder.loader.h.cwn().bG(localObject2).anW();
    }
    ac.i("ImagePreloadWorker", "[preload] size=" + ((LinkedList)localObject1).size() + ' ' + paramBaseFinderFeed);
    AppMethodBeat.o(202635);
  }
  
  public static void adL(String paramString)
  {
    AppMethodBeat.i(202636);
    k.h(paramString, "mediaId");
    AppMethodBeat.o(202636);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker$Companion;", "", "()V", "EVER_FEED_COUNT", "", "PRELOAD_FEED_COUNT", "PRELOAD_FEED_PRE_COUNT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.a
 * JD-Core Version:    0.7.0.1
 */
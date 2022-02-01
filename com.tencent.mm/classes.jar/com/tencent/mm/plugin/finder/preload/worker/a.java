package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.k.i;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "()V", "onClearAll", "", "onMediaFocus", "mediaId", "", "isFocused", "", "onPreloadStart", "onPreloadStop", "onRelease", "preload", "commentScene", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a zLX;
  
  static
  {
    AppMethodBeat.i(278517);
    zLX = new a((byte)0);
    AppMethodBeat.o(278517);
  }
  
  public static void a(FeedData paramFeedData, List<o<bu, List<csg>>> paramList)
  {
    AppMethodBeat.i(278515);
    p.k(paramFeedData, "centerFeed");
    p.k(paramList, "dataList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(278515);
      return;
    }
    Object localObject1 = paramList.iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (o)((Iterator)localObject1).next();
      if ((((o)localObject2).Mx instanceof BaseFinderFeed))
      {
        localObject2 = ((o)localObject2).Mx;
        if (localObject2 == null)
        {
          paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(278515);
          throw paramFeedData;
        }
        if (((BaseFinderFeed)localObject2).feedObject.getExpectId() == paramFeedData.getExpectId())
        {
          j = 1;
          label125:
          if (j == 0) {
            break label144;
          }
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label156;
      }
      AppMethodBeat.o(278515);
      return;
      j = 0;
      break label125;
      label144:
      i += 1;
      break;
      i = -1;
    }
    label156:
    i = Math.max(0, i - 1);
    localObject1 = new StringBuilder();
    Object localObject2 = new LinkedList();
    paramList = (Iterable)paramList.subList(i, paramList.size());
    paramFeedData = (Collection)new ArrayList();
    paramList = paramList.iterator();
    Object localObject3;
    Object localObject4;
    label317:
    while (paramList.hasNext())
    {
      localObject3 = paramList.next();
      localObject4 = (o)localObject3;
      if ((((o)localObject4).Mx instanceof BaseFinderFeed))
      {
        localObject4 = ((o)localObject4).Mx;
        if (localObject4 == null)
        {
          paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(278515);
          throw paramFeedData;
        }
        if (((BaseFinderFeed)localObject4).feedObject.getMediaType() != 2) {}
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label317;
        }
        paramFeedData.add(localObject3);
        break;
      }
    }
    paramList = ((Iterable)paramFeedData).iterator();
    i = 0;
    while (paramList.hasNext())
    {
      paramFeedData = paramList.next();
      if (i < 0) {
        j.iBO();
      }
      paramFeedData = (o)paramFeedData;
      if (i < 4)
      {
        localObject3 = new StringBuilder("feed=");
        localObject4 = paramFeedData.Mx;
        if (localObject4 == null)
        {
          paramFeedData = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
          AppMethodBeat.o(278515);
          throw paramFeedData;
        }
        ((StringBuilder)localObject1).append(com.tencent.mm.ae.d.Fw(((BaseFinderFeed)localObject4).feedObject.getFeedObject().id) + " mediaSize=" + ((List)paramFeedData.My).size() + " | ");
        localObject3 = ((Iterable)((List)paramFeedData.My).subList(0, Math.min(2, ((List)paramFeedData.My).size()))).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localObject4 = (csg)((Iterator)localObject3).next();
          ((LinkedList)localObject2).add(new r((csg)localObject4, u.Aly, null, null, 12));
          paramFeedData = ((csg)localObject4).mediaId;
          if (paramFeedData != null)
          {
            localObject4 = ((csg)localObject4).mediaId;
            if (localObject4 != null) {
              j = ((String)localObject4).length();
            }
          }
          label573:
          for (paramFeedData = paramFeedData.subSequence(0, i.ow(5, j));; paramFeedData = null)
          {
            ((StringBuilder)localObject1).append(paramFeedData).append(",");
            break;
            j = 0;
            break label573;
          }
        }
        ((StringBuilder)localObject1).append("\n");
      }
      i += 1;
    }
    paramFeedData = ((Iterable)localObject2).iterator();
    while (paramFeedData.hasNext())
    {
      paramList = (r)paramFeedData.next();
      localObject3 = com.tencent.mm.plugin.finder.loader.t.ztT;
      com.tencent.mm.plugin.finder.loader.t.dJe().bQ(paramList).aRr();
    }
    Log.i("ImagePreloadWorker", "[preload] size=" + ((LinkedList)localObject2).size() + ' ' + localObject1);
    AppMethodBeat.o(278515);
  }
  
  public static void aDK(String paramString)
  {
    AppMethodBeat.i(278516);
    p.k(paramString, "mediaId");
    AppMethodBeat.o(278516);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker$Companion;", "", "()V", "EVER_FEED_COUNT", "", "PRELOAD_FEED_COUNT", "PRELOAD_FEED_PRE_COUNT", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.a
 * JD-Core Version:    0.7.0.1
 */
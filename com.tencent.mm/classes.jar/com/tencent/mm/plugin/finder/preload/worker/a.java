package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.storage.FeedData;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.k.k;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/preload/worker/ImagePreloadWorker;", "Lcom/tencent/mm/plugin/finder/preload/worker/IPreloadWorker;", "()V", "cancel", "", "mediaId", "", "onClearAll", "onMediaFocus", "isFocused", "", "onPreloadStart", "onPreloadStop", "onRelease", "preload", "commentScene", "", "centerFeed", "Lcom/tencent/mm/plugin/finder/storage/FeedData;", "dataList", "", "Lkotlin/Pair;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "source", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a EWU;
  
  static
  {
    AppMethodBeat.i(346316);
    EWU = new a.a((byte)0);
    AppMethodBeat.o(346316);
  }
  
  public static void a(FeedData paramFeedData, List<r<cc, List<dji>>> paramList)
  {
    AppMethodBeat.i(346301);
    s.u(paramFeedData, "centerFeed");
    s.u(paramList, "dataList");
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(346301);
      return;
    }
    Object localObject1 = paramList.iterator();
    int i = 0;
    int j;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (r)((Iterator)localObject1).next();
      if (((((r)localObject2).bsC instanceof BaseFinderFeed)) && (((BaseFinderFeed)((r)localObject2).bsC).feedObject.getExpectId() == paramFeedData.getExpectId()))
      {
        j = 1;
        label99:
        if (j == 0) {
          break label118;
        }
      }
    }
    for (;;)
    {
      if (i >= 0) {
        break label130;
      }
      AppMethodBeat.o(346301);
      return;
      j = 0;
      break label99;
      label118:
      i += 1;
      break;
      i = -1;
    }
    label130:
    i = Math.max(0, i - 1);
    localObject1 = new StringBuilder();
    Object localObject2 = new LinkedList();
    paramList = (Iterable)paramList.subList(i, paramList.size());
    paramFeedData = (Collection)new ArrayList();
    paramList = paramList.iterator();
    Object localObject3;
    Object localObject4;
    label265:
    while (paramList.hasNext())
    {
      localObject3 = paramList.next();
      localObject4 = (r)localObject3;
      if (((((r)localObject4).bsC instanceof BaseFinderFeed)) && (((BaseFinderFeed)((r)localObject4).bsC).feedObject.getMediaType() == 2)) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label265;
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
        kotlin.a.p.kkW();
      }
      paramFeedData = (r)paramFeedData;
      if (i < 4)
      {
        ((StringBuilder)localObject1).append("feed=" + com.tencent.mm.ae.d.hF(((BaseFinderFeed)paramFeedData.bsC).feedObject.getFeedObject().id) + " mediaSize=" + ((List)paramFeedData.bsD).size() + " | ");
        localObject3 = ((Iterable)((List)paramFeedData.bsD).subList(0, Math.min(2, ((List)paramFeedData.bsD).size()))).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (dji)((Iterator)localObject3).next();
          ((LinkedList)localObject2).add(new n((dji)localObject4, v.FKY, null, null, 12));
          paramFeedData = ((dji)localObject4).mediaId;
          if (paramFeedData == null)
          {
            paramFeedData = null;
            ((StringBuilder)localObject1).append(paramFeedData).append(",");
          }
          else
          {
            localObject4 = ((dji)localObject4).mediaId;
            if (localObject4 == null) {}
            for (j = 0;; j = ((String)localObject4).length())
            {
              paramFeedData = paramFeedData.subSequence(0, k.qv(5, j));
              break;
            }
          }
        }
        ((StringBuilder)localObject1).append("\n");
      }
      i += 1;
    }
    paramFeedData = ((Iterable)localObject2).iterator();
    while (paramFeedData.hasNext())
    {
      paramList = (n)paramFeedData.next();
      localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
      com.tencent.mm.plugin.finder.loader.p.eCl().dk(paramList).blg();
    }
    Log.i("ImagePreloadWorker", "[preload] size=" + ((LinkedList)localObject2).size() + ' ' + localObject1);
    AppMethodBeat.o(346301);
  }
  
  public static void azo(String paramString)
  {
    AppMethodBeat.i(346308);
    s.u(paramString, "mediaId");
    AppMethodBeat.o(346308);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.a
 * JD-Core Version:    0.7.0.1
 */
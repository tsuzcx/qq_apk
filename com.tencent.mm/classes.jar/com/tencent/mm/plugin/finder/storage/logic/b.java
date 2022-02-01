package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import d.f;
import d.g.a.a;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.FinderFeedLogic";
  private static final f sAr;
  public static final a sAs;
  
  static
  {
    AppMethodBeat.i(167103);
    sAs = new a((byte)0);
    TAG = "Finder.FinderFeedLogic";
    sAr = d.g.O((a)b.sAt);
    AppMethodBeat.o(167103);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "insertFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "extraOp", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "saveCache", "list", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isNeedClear", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
  public static final class a
  {
    public static bvf a(int paramInt, FinderMedia paramFinderMedia)
    {
      AppMethodBeat.i(167101);
      d.g.b.p.h(paramFinderMedia, "feedMedia");
      bvf localbvf = new bvf();
      localbvf.url = paramFinderMedia.url;
      localbvf.mediaType = paramInt;
      localbvf.thumbUrl = paramFinderMedia.thumbUrl;
      localbvf.videoDuration = paramFinderMedia.videoDuration;
      localbvf.mediaId = ai.ee(paramFinderMedia.url);
      localbvf.width = paramFinderMedia.width;
      localbvf.height = paramFinderMedia.height;
      localbvf.md5sum = paramFinderMedia.md5sum;
      localbvf.fileSize = paramFinderMedia.fileSize;
      localbvf.bitrate = paramFinderMedia.bitrate;
      localbvf.spec = paramFinderMedia.spec;
      localbvf.coverUrl = paramFinderMedia.coverUrl;
      localbvf.decodeKey = paramFinderMedia.decodeKey;
      localbvf.cover_url_token = paramFinderMedia.cover_url_token;
      localbvf.thumb_url_token = paramFinderMedia.thumb_url_token;
      localbvf.url_token = paramFinderMedia.url_token;
      AppMethodBeat.o(167101);
      return localbvf;
    }
    
    private static List<FinderItem> a(List<? extends FinderObject> paramList, int paramInt, aqy paramaqy)
    {
      AppMethodBeat.i(203855);
      d.g.b.p.h(paramList, "feedList");
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(d.a.j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        FinderObject localFinderObject = (FinderObject)((Iterator)localObject1).next();
        Object localObject2 = FinderItem.syk;
        localObject2 = FinderItem.a.a(localFinderObject, paramInt);
        Object localObject3 = com.tencent.mm.plugin.finder.model.j.sjX;
        com.tencent.mm.plugin.finder.model.j.b((FinderItem)localObject2);
        localObject3 = d.szI;
        d.a.f((FinderItem)localObject2);
        i += 1;
        if (paramaqy != null)
        {
          localObject3 = ((FinderItem)localObject2).getFeedObject().sessionBuffer;
          if (localObject3 != null)
          {
            h localh = h.soM;
            h.d(((FinderItem)localObject2).getId(), paramaqy.rTD, (String)localObject3);
          }
        }
        localObject3 = c.rHn;
        localObject3 = ((FinderItem)localObject2).getFeedObject().contact;
        d.g.b.p.g(localObject3, "item.feedObject.contact");
        c.a.b((FinderContact)localObject3);
        ad.i(b.access$getTAG$cp(), "insert item index id:" + localFinderObject.nickname + " obj=" + localFinderObject.id + " sourceType " + paramInt + ' ');
        localCollection.add(localObject2);
      }
      localArrayList.addAll((Collection)localCollection);
      ad.i(b.access$getTAG$cp(), "[insertFeedList] insert count=" + paramList.size() + " successfulCount=" + i + " sourceType=" + paramInt);
      paramList = (List)localArrayList;
      AppMethodBeat.o(203855);
      return paramList;
    }
    
    public static void a(List<? extends al> paramList, int paramInt, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(203857);
      d.g.b.p.h(paramList, "list");
      d.g.b.p.h(paramString, "username");
      Object localObject1;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!d.g.b.p.i(paramString, u.aAu()))) {
          break label152;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sMo;
      }
      label152:
      for (int i = com.tencent.mm.plugin.finder.utils.p.FR(paramInt);; i = 3)
      {
        localObject1 = new LinkedList();
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          Object localObject2 = (al)paramList.next();
          if ((localObject2 instanceof BaseFinderFeed))
          {
            localObject2 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject();
            ((LinkedList)localObject1).add(new com.tencent.mm.plugin.finder.storage.data.n(0, ((FinderObject)localObject2).id, (FinderObject)localObject2, paramInt));
          }
        }
        i = 0;
        break;
      }
      if ((((LinkedList)localObject1).size() > 0) || (paramBoolean))
      {
        paramList = k.sAe;
        k.a.a(i, paramString, (LinkedList)localObject1);
      }
      AppMethodBeat.o(203857);
    }
    
    public static List<Integer> cJq()
    {
      AppMethodBeat.i(167092);
      Object localObject = b.cJp();
      a locala = b.sAs;
      localObject = (List)((f)localObject).getValue();
      AppMethodBeat.o(167092);
      return localObject;
    }
    
    public static boolean i(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167100);
      d.g.b.p.h(paramFinderItem, "feedObject");
      long l2 = paramFinderItem.field_id;
      long l3 = paramFinderItem.getLocalId();
      i locali = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage();
      long l1 = -1L;
      if (xf(l3)) {}
      for (boolean bool = locali.b(l3, paramFinderItem);; bool = locali.a(l2, paramFinderItem))
      {
        if (bool) {
          l1 = paramFinderItem.getLocalId();
        }
        ad.d(b.access$getTAG$cp(), "replace feedSucc %s, rowId %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
        AppMethodBeat.o(167100);
        return bool;
      }
    }
    
    public static BaseFinderFeed j(FinderItem paramFinderItem)
    {
      AppMethodBeat.i(167102);
      d.g.b.p.h(paramFinderItem, "finderObject");
      BaseFinderFeed localBaseFinderFeed;
      switch (paramFinderItem.getMediaType())
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.q(paramFinderItem);
      }
      for (;;)
      {
        paramFinderItem = paramFinderItem.getFeedObject().contact;
        d.g.b.p.g(paramFinderItem, "finderObject.feedObject.contact");
        localBaseFinderFeed.contact = com.tencent.mm.plugin.finder.api.b.a(paramFinderItem, null);
        AppMethodBeat.o(167102);
        return localBaseFinderFeed;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.n(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new r(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new s(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.p(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.q(paramFinderItem);
      }
    }
    
    public static boolean xf(long paramLong)
    {
      AppMethodBeat.i(167096);
      if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().wP(paramLong) != null)
      {
        AppMethodBeat.o(167096);
        return true;
      }
      AppMethodBeat.o(167096);
      return false;
    }
    
    public static FinderItem xg(long paramLong)
    {
      AppMethodBeat.i(167097);
      ad.d(b.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
      FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().wP(paramLong);
      AppMethodBeat.o(167097);
      return localFinderItem;
    }
    
    public static boolean xh(long paramLong)
    {
      AppMethodBeat.i(167098);
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().wQ(paramLong);
      ad.i(b.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
      AppMethodBeat.o(167098);
      return bool;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<List<? extends Integer>>
  {
    public static final b sAt;
    
    static
    {
      AppMethodBeat.i(167090);
      sAt = new b();
      AppMethodBeat.o(167090);
    }
    
    b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.logic.b
 * JD-Core Version:    0.7.0.1
 */
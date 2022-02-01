package com.tencent.mm.plugin.finder.storage.logic;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.o;
import com.tencent.mm.plugin.finder.model.r;
import com.tencent.mm.plugin.finder.model.s;
import com.tencent.mm.plugin.finder.model.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.FinderItem.a;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.n;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import d.a.j;
import d.f;
import d.g.a.a;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic;", "", "()V", "Companion", "plugin-finder_release"})
public final class b
{
  private static final String TAG = "Finder.FinderFeedLogic";
  private static final f sLp;
  public static final a sLq;
  
  static
  {
    AppMethodBeat.i(167103);
    sLq = new a((byte)0);
    TAG = "Finder.FinderFeedLogic";
    sLp = d.g.O((a)b.sLr);
    AppMethodBeat.o(167103);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/storage/logic/FinderFeedLogic$Companion;", "", "()V", "CARE_MEDIA_TYPE", "", "", "getCARE_MEDIA_TYPE", "()Ljava/util/List;", "CARE_MEDIA_TYPE$delegate", "Lkotlin/Lazy;", "TAG", "", "deleteFeed", "", "objectId", "", "deleteFeedByLocalId", "localId", "deleteGroupFeed", "", "getBySenderLocal", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getLocalSenderFeedBeforeTime", "Ljava/util/LinkedList;", "username", "startTime", "endTime", "insertFeedList", "feedList", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "sourceType", "extraOp", "Lkotlin/Function1;", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "isLocalSenderFeedExists", "replaceSenderFeed", "feedObject", "saveCache", "list", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isNeedClear", "transformFinderMediaToLocal", "Lcom/tencent/mm/protocal/protobuf/LocalFinderMedia;", "mediaType", "feedMedia", "Lcom/tencent/mm/protocal/protobuf/FinderMedia;", "transformFinderObjectToTimeLineData", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "finderObject", "updateFeedCommentCount", "count", "feed", "plugin-finder_release"})
  public static final class a
  {
    public static bvz a(int paramInt, FinderMedia paramFinderMedia)
    {
      AppMethodBeat.i(167101);
      d.g.b.p.h(paramFinderMedia, "feedMedia");
      bvz localbvz = new bvz();
      localbvz.url = paramFinderMedia.url;
      localbvz.mediaType = paramInt;
      localbvz.thumbUrl = paramFinderMedia.thumbUrl;
      localbvz.videoDuration = paramFinderMedia.videoDuration;
      localbvz.mediaId = aj.ej(paramFinderMedia.url);
      localbvz.width = paramFinderMedia.width;
      localbvz.height = paramFinderMedia.height;
      localbvz.md5sum = paramFinderMedia.md5sum;
      localbvz.fileSize = paramFinderMedia.fileSize;
      localbvz.bitrate = paramFinderMedia.bitrate;
      localbvz.spec = paramFinderMedia.spec;
      localbvz.coverUrl = paramFinderMedia.coverUrl;
      localbvz.decodeKey = paramFinderMedia.decodeKey;
      localbvz.cover_url_token = paramFinderMedia.cover_url_token;
      localbvz.thumb_url_token = paramFinderMedia.thumb_url_token;
      localbvz.url_token = paramFinderMedia.url_token;
      AppMethodBeat.o(167101);
      return localbvz;
    }
    
    private static List<FinderItem> a(List<? extends FinderObject> paramList, int paramInt, arn paramarn)
    {
      AppMethodBeat.i(204447);
      d.g.b.p.h(paramList, "feedList");
      int i = 0;
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = (Iterable)paramList;
      Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        FinderObject localFinderObject = (FinderObject)((Iterator)localObject1).next();
        Object localObject2 = FinderItem.sJb;
        localObject2 = FinderItem.a.a(localFinderObject, paramInt);
        Object localObject3 = com.tencent.mm.plugin.finder.model.k.ssU;
        com.tencent.mm.plugin.finder.model.k.b((FinderItem)localObject2);
        localObject3 = d.sKD;
        d.a.f((FinderItem)localObject2);
        i += 1;
        Object localObject4;
        if (paramarn != null)
        {
          localObject3 = ((FinderItem)localObject2).getFeedObject().sessionBuffer;
          if (localObject3 != null)
          {
            localObject4 = com.tencent.mm.plugin.finder.report.i.syT;
            com.tencent.mm.plugin.finder.report.i.d(((FinderItem)localObject2).getId(), paramarn.sch, (String)localObject3);
          }
          localObject3 = d.sKD;
          d.a.i(paramarn.sch, paramList);
        }
        localObject3 = ((FinderItem)localObject2).getFeedObject().contact;
        if (localObject3 != null)
        {
          localObject4 = c.rPy;
          c.a.b((FinderContact)localObject3);
        }
        ae.i(b.access$getTAG$cp(), "insert item index id:" + localFinderObject.nickname + " obj=" + localFinderObject.id + " sourceType " + paramInt + ' ');
        localCollection.add(localObject2);
      }
      localArrayList.addAll((Collection)localCollection);
      ae.i(b.access$getTAG$cp(), "[insertFeedList] insert count=" + paramList.size() + " successfulCount=" + i + " sourceType=" + paramInt);
      paramList = (List)localArrayList;
      AppMethodBeat.o(204447);
      return paramList;
    }
    
    public static void a(List<? extends am> paramList, int paramInt, String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(204449);
      d.g.b.p.h(paramList, "list");
      d.g.b.p.h(paramString, "username");
      Object localObject1;
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!d.g.b.p.i(paramString, v.aAK()))) {
          break label152;
        }
        localObject1 = com.tencent.mm.plugin.finder.utils.p.sXz;
      }
      label152:
      for (int i = com.tencent.mm.plugin.finder.utils.p.Gq(paramInt);; i = 3)
      {
        localObject1 = new LinkedList();
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          Object localObject2 = (am)paramList.next();
          if ((localObject2 instanceof BaseFinderFeed))
          {
            localObject2 = ((BaseFinderFeed)localObject2).feedObject.getFeedObject();
            ((LinkedList)localObject1).add(new n(0, ((FinderObject)localObject2).id, (FinderObject)localObject2, paramInt));
          }
        }
        i = 0;
        break;
      }
      if ((((LinkedList)localObject1).size() > 0) || (paramBoolean))
      {
        paramList = com.tencent.mm.plugin.finder.storage.data.k.sLb;
        k.a.a(i, paramString, (LinkedList)localObject1);
      }
      AppMethodBeat.o(204449);
    }
    
    public static List<Integer> cLT()
    {
      AppMethodBeat.i(167092);
      Object localObject = b.cLS();
      a locala = b.sLq;
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
      com.tencent.mm.plugin.finder.storage.i locali = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage();
      long l1 = -1L;
      if (xw(l3)) {}
      for (boolean bool = locali.b(l3, paramFinderItem);; bool = locali.a(l2, paramFinderItem))
      {
        if (bool) {
          l1 = paramFinderItem.getLocalId();
        }
        ae.d(b.access$getTAG$cp(), "replace feedSucc %s, rowId %d", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1) });
        AppMethodBeat.o(167100);
        return bool;
      }
    }
    
    public static BaseFinderFeed j(FinderItem paramFinderItem)
    {
      Object localObject = null;
      AppMethodBeat.i(167102);
      d.g.b.p.h(paramFinderItem, "finderObject");
      BaseFinderFeed localBaseFinderFeed;
      switch (paramFinderItem.getMediaType())
      {
      case 3: 
      case 5: 
      case 6: 
      default: 
        localBaseFinderFeed = (BaseFinderFeed)new r(paramFinderItem);
      }
      for (;;)
      {
        FinderContact localFinderContact = paramFinderItem.getFeedObject().contact;
        paramFinderItem = localObject;
        if (localFinderContact != null) {
          paramFinderItem = com.tencent.mm.plugin.finder.api.b.a(localFinderContact, null);
        }
        localBaseFinderFeed.contact = paramFinderItem;
        AppMethodBeat.o(167102);
        return localBaseFinderFeed;
        localBaseFinderFeed = (BaseFinderFeed)new o(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new s(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new t(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new com.tencent.mm.plugin.finder.model.q(paramFinderItem);
        continue;
        localBaseFinderFeed = (BaseFinderFeed)new r(paramFinderItem);
      }
    }
    
    public static boolean xw(long paramLong)
    {
      AppMethodBeat.i(167096);
      if (((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().xg(paramLong) != null)
      {
        AppMethodBeat.o(167096);
        return true;
      }
      AppMethodBeat.o(167096);
      return false;
    }
    
    public static FinderItem xx(long paramLong)
    {
      AppMethodBeat.i(167097);
      ae.d(b.access$getTAG$cp(), "get feed local id %s", new Object[] { Long.valueOf(paramLong) });
      FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().xg(paramLong);
      AppMethodBeat.o(167097);
      return localFinderItem;
    }
    
    public static boolean xy(long paramLong)
    {
      AppMethodBeat.i(167098);
      boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().xh(paramLong);
      ae.i(b.access$getTAG$cp(), "delete feed " + paramLong + " success " + bool);
      AppMethodBeat.o(167098);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "", "invoke"})
  static final class b
    extends d.g.b.q
    implements a<List<? extends Integer>>
  {
    public static final b sLr;
    
    static
    {
      AppMethodBeat.i(167090);
      sLr = new b();
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
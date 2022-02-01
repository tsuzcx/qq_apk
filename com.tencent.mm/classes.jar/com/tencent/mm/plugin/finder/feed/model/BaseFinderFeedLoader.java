package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gw;
import com.tencent.mm.g.a.gw.a;
import com.tencent.mm.g.a.gy;
import com.tencent.mm.g.a.gy.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.c.a;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.upload.f.a;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.a.v;
import d.o;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "username", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "getUsername", "()Ljava/lang/String;", "isObservePostEvent", "", "onAlive", "", "onDead", "onPostEnd", "localId", "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "remove", "", "feedId", "notify", "removeByLocalId", "feedLocalId", "transformFinderObj", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "updateByLocalId", "newFeed", "updateItem", "svrId", "updateProgressByLoalId", "Companion", "plugin-finder_release"})
public abstract class BaseFinderFeedLoader
  extends com.tencent.mm.plugin.finder.feed.model.internal.a<BaseFinderFeed>
  implements com.tencent.mm.plugin.finder.upload.k
{
  public static final Companion Companion = new Companion(null);
  private static final Map<String, BaseFinderFeedLoader.Companion.Cache> loaderCache = (Map)new LinkedHashMap();
  private byte _hellAccFlag_;
  private final feedChangeListener.1 feedChangeListener;
  private final feedDeleteListener.1 feedDeleteListener;
  private final String username;
  
  public BaseFinderFeedLoader(String paramString, dzp paramdzp)
  {
    super(paramdzp);
    this.username = paramString;
    this.feedDeleteListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final gw paramAnonymousgw)
      {
        AppMethodBeat.i(198138);
        if (paramAnonymousgw != null) {
          com.tencent.mm.ad.c.g((d.g.a.a)new d.g.b.l(paramAnonymousgw)
          {
            public final void invoke()
            {
              AppMethodBeat.i(198137);
              if (paramAnonymousgw.dkx.id != 0L)
              {
                this.this$0.this$0.remove(paramAnonymousgw.dkx.id, true);
                AppMethodBeat.o(198137);
                return;
              }
              this.this$0.this$0.removeByLocalId(paramAnonymousgw.dkx.deI, true);
              AppMethodBeat.o(198137);
            }
          });
        }
        AppMethodBeat.o(198138);
        return false;
      }
    };
    this.feedChangeListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final gy paramAnonymousgy)
      {
        AppMethodBeat.i(198136);
        d.g.b.k.h(paramAnonymousgy, "event");
        com.tencent.mm.ad.c.a(0L, (d.g.a.a)new d.g.b.l(paramAnonymousgy)
        {
          public final void invoke()
          {
            AppMethodBeat.i(198135);
            ad.i(this.this$0.this$0.getTAG(), "feedChangeListener " + paramAnonymousgy.dkz.id);
            switch (paramAnonymousgy.dkz.type)
            {
            }
            label267:
            label272:
            label279:
            label409:
            label543:
            label553:
            for (;;)
            {
              AppMethodBeat.o(198135);
              return;
              if (paramAnonymousgy.dkz.id != 0L)
              {
                Object localObject = com.tencent.mm.plugin.finder.storage.data.b.qKl;
                localObject = paramAnonymousgy.dkz;
                if (localObject == null) {
                  d.g.b.k.fvU();
                }
                localObject = com.tencent.mm.plugin.finder.storage.data.b.a.qC(((gy.a)localObject).id);
                int i;
                int j;
                if (localObject != null)
                {
                  Iterator localIterator = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (!localIterator.hasNext()) {
                    break label279;
                  }
                  if (((BaseFinderFeed)localIterator.next()).feedObject.getId() != paramAnonymousgy.dkz.id) {
                    break label267;
                  }
                  j = 1;
                  label208:
                  if (j == 0) {
                    break label272;
                  }
                }
                for (;;)
                {
                  if (i != -1)
                  {
                    this.this$0.this$0.getDataList().set(i, BaseFinderFeedLoader.access$transformFinderObj(this.this$0.this$0, (FinderItem)localObject));
                    this.this$0.this$0.dispatcher().m(i, Integer.valueOf(1));
                  }
                  AppMethodBeat.o(198135);
                  return;
                  j = 0;
                  break label208;
                  i += 1;
                  break;
                  i = -1;
                }
                if (paramAnonymousgy.dkz.id != 0L)
                {
                  localObject = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  label320:
                  if (((Iterator)localObject).hasNext()) {
                    if (((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getId() == paramAnonymousgy.dkz.id)
                    {
                      j = 1;
                      label360:
                      if (j == 0) {
                        break label409;
                      }
                    }
                  }
                  while (i != -1)
                  {
                    this.this$0.this$0.dispatcher().m(i, new o(Integer.valueOf(3), Integer.valueOf(1)));
                    AppMethodBeat.o(198135);
                    return;
                    j = 0;
                    break label360;
                    i += 1;
                    break label320;
                    i = -1;
                  }
                  if (paramAnonymousgy.dkz.id != 0L)
                  {
                    localObject = ((List)this.this$0.this$0.getDataList()).iterator();
                    i = 0;
                    label457:
                    if (((Iterator)localObject).hasNext()) {
                      if (((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getId() == paramAnonymousgy.dkz.id)
                      {
                        j = 1;
                        label497:
                        if (j == 0) {
                          break label543;
                        }
                      }
                    }
                    for (;;)
                    {
                      if (i == -1) {
                        break label553;
                      }
                      this.this$0.this$0.dispatcher().m(i, new o(Integer.valueOf(4), Integer.valueOf(1)));
                      break;
                      j = 0;
                      break label497;
                      i += 1;
                      break label457;
                      i = -1;
                    }
                  }
                }
              }
            }
          }
        });
        AppMethodBeat.o(198136);
        return true;
      }
    };
  }
  
  private final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    return com.tencent.mm.plugin.finder.storage.logic.b.a.h(paramFinderItem);
  }
  
  public final String getUsername()
  {
    return this.username;
  }
  
  public boolean isObservePostEvent()
  {
    return false;
  }
  
  public void onAlive()
  {
    super.onAlive();
    if (isObservePostEvent())
    {
      f.a locala = com.tencent.mm.plugin.finder.upload.f.qRf;
      com.tencent.mm.plugin.finder.upload.f.crB().a((com.tencent.mm.plugin.finder.upload.k)this);
    }
    this.feedDeleteListener.alive();
    this.feedChangeListener.alive();
  }
  
  public void onDead()
  {
    super.onDead();
    if (isObservePostEvent())
    {
      f.a locala = com.tencent.mm.plugin.finder.upload.f.qRf;
      com.tencent.mm.plugin.finder.upload.f.crB().b((com.tencent.mm.plugin.finder.upload.k)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.be(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.ado());
    super.onFetchDone(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V");
  }
  
  public void onPostEnd(long paramLong, boolean paramBoolean)
  {
    updateItem(paramLong);
  }
  
  public void onPostNotify(long paramLong, boolean paramBoolean)
  {
    updateItem(paramLong);
  }
  
  public void onPostOk(long paramLong1, long paramLong2)
  {
    updateItem(paramLong1, paramLong2);
  }
  
  public void onPostStart(long paramLong)
  {
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.a.qG(paramLong);
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = transformFinderObj((FinderItem)localObject2);
      ad.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localObject2);
      ((ArrayList)localObject1).add(localObject2);
      com.tencent.mm.plugin.finder.feed.model.internal.c.mergeDataAndNotify$default(this, 2, (List)localObject1, true, null, 8, null);
    }
  }
  
  public final int remove(long paramLong, boolean paramBoolean)
  {
    Iterator localIterator = ((List)getDataList()).iterator();
    int i = 0;
    int j;
    if (localIterator.hasNext()) {
      if (((BaseFinderFeed)localIterator.next()).feedObject.getId() == paramLong)
      {
        j = 1;
        label51:
        if (j == 0) {
          break label100;
        }
      }
    }
    for (;;)
    {
      if (i != -1)
      {
        d.g.b.k.g(getDataList().remove(i), "dataList.removeAt(index)");
        if (paramBoolean) {
          dispatcher().au(i, 1);
        }
      }
      return i;
      j = 0;
      break label51;
      label100:
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final int removeByLocalId(long paramLong, boolean paramBoolean)
  {
    Object localObject = getDataList();
    int i;
    int j;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      i = 0;
      if (((Iterator)localObject).hasNext()) {
        if (((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getLocalId() == paramLong)
        {
          j = 1;
          label60:
          if (j == 0) {
            break label123;
          }
        }
      }
    }
    label65:
    for (localObject = Integer.valueOf(i);; localObject = null)
    {
      i = ((Integer)localObject).intValue();
      if (i != -1)
      {
        d.g.b.k.g(getDataList().remove(i), "dataList.removeAt(index)");
        if (paramBoolean) {
          dispatcher().au(i, 1);
        }
      }
      return i;
      j = 0;
      break label60;
      label123:
      i += 1;
      break;
      i = -1;
      break label65;
    }
  }
  
  public final int updateByLocalId(BaseFinderFeed paramBaseFinderFeed, boolean paramBoolean)
  {
    d.g.b.k.h(paramBaseFinderFeed, "newFeed");
    int j;
    if (paramBaseFinderFeed.feedObject.getLocalId() <= 0L)
    {
      j = -1;
      return j;
    }
    Object localObject1 = (Iterable)getDataList();
    int i = 0;
    localObject1 = ((Iterable)localObject1).iterator();
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label161;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (i < 0) {
        j.fvx();
      }
      if (((BaseFinderFeed)localObject2).feedObject.getLocalId() == paramBaseFinderFeed.feedObject.getLocalId())
      {
        getDataList().set(i, paramBaseFinderFeed);
        j = i;
        if (!paramBoolean) {
          break;
        }
        ad.i(getTAG(), "updateByLocalId " + paramBaseFinderFeed.feedObject.getLocalId());
        dispatcher().m(i, Integer.valueOf(1));
        return i;
      }
      i += 1;
    }
    label161:
    return -1;
  }
  
  protected final void updateItem(long paramLong)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.a.qG(paramLong);
    if (localObject != null)
    {
      ad.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      localObject = transformFinderObj((FinderItem)localObject);
      if (localObject != null) {
        updateByLocalId((BaseFinderFeed)localObject, true);
      }
    }
  }
  
  protected final void updateItem(long paramLong1, long paramLong2)
  {
    Object localObject = com.tencent.mm.plugin.finder.storage.data.b.qKl;
    localObject = com.tencent.mm.plugin.finder.storage.data.b.a.qC(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      ad.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      localObject = transformFinderObj((FinderItem)localObject);
      if (localObject != null)
      {
        ((BaseFinderFeed)localObject).showLikeTips = true;
        updateByLocalId((BaseFinderFeed)localObject, true);
      }
    }
  }
  
  public final void updateProgressByLoalId(long paramLong)
  {
    if (paramLong <= 0L) {}
    for (;;)
    {
      return;
      Object localObject1 = (Iterable)getDataList();
      int i = 0;
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (i < 0) {
          j.fvx();
        }
        localObject2 = (BaseFinderFeed)localObject2;
        if (((BaseFinderFeed)localObject2).feedObject.getLocalId() == paramLong)
        {
          Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.a.qG(paramLong);
          if (localObject3 != null) {
            getDataList().set(i, transformFinderObj((FinderItem)localObject3));
          }
          ad.i(getTAG(), "updateProgressByLoalId " + ((BaseFinderFeed)localObject2).feedObject.getLocalId());
          dispatcher().m(i, new o(Integer.valueOf(2), Integer.valueOf(1)));
        }
        i += 1;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$Companion;", "", "()V", "loaderCache", "", "", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$Companion$Cache;", "create", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "username", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "profileCacheKey", "putCache", "", "key", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "Cache", "plugin-finder_release"})
  public static final class Companion
  {
    public final BaseFinderFeedLoader create(com.tencent.mm.plugin.finder.feed.model.internal.b paramb, String paramString1, dzp paramdzp, String paramString2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(198131);
      d.g.b.k.h(paramb, "scene");
      d.g.b.k.h(paramString1, "username");
      d.g.b.k.h(paramString2, "profileCacheKey");
      Object localObject1;
      if ((BaseFinderFeedLoader.access$getLoaderCache$cp().containsKey(paramString2)) && ((paramb == com.tencent.mm.plugin.finder.feed.model.internal.b.KQE) || (paramb == com.tencent.mm.plugin.finder.feed.model.internal.b.KQF)))
      {
        ad.i("Finder.FinderFeedLoader", "getfromCache username " + paramString1 + ", profileCacheKey " + paramString2);
        ArrayList localArrayList = new ArrayList();
        localObject1 = (Cache)BaseFinderFeedLoader.access$getLoaderCache$cp().get(paramString2);
        if (localObject1 != null)
        {
          localObject1 = ((Cache)localObject1).getDataList();
          if (localObject1 != null)
          {
            localObject1 = (Collection)localObject1;
            localArrayList.addAll((Collection)localObject1);
            paramString1 = new FinderProfileFeedLoader(paramb, paramString1, localArrayList, paramdzp);
            paramdzp = (Cache)BaseFinderFeedLoader.access$getLoaderCache$cp().get(paramString2);
            paramb = localObject2;
            if (paramdzp != null) {
              paramb = paramdzp.getLastBuffer();
            }
            paramString1.setLastBuffer(paramb);
            paramb = paramString1;
          }
        }
      }
      for (;;)
      {
        paramb = (BaseFinderFeedLoader)paramb;
        AppMethodBeat.o(198131);
        return paramb;
        localObject1 = (Collection)v.Jgl;
        break;
        if (paramb == com.tencent.mm.plugin.finder.feed.model.internal.b.KQz)
        {
          paramb = new h(paramb, paramdzp);
        }
        else if (paramb == com.tencent.mm.plugin.finder.feed.model.internal.b.KQG)
        {
          paramb = new f(paramb, paramdzp);
        }
        else if ((paramb == com.tencent.mm.plugin.finder.feed.model.internal.b.KQE) || (paramb == com.tencent.mm.plugin.finder.feed.model.internal.b.KQF))
        {
          ad.i("Finder.FinderFeedLoader", "getfromCreate username ".concat(String.valueOf(paramString1)));
          paramb = new FinderProfileFeedLoader(paramb, paramString1, null, paramdzp, 4, null);
        }
        else
        {
          paramb = new FinderProfileFeedLoader(paramb, paramString1, null, paramdzp, 4, null);
        }
      }
    }
    
    public final void putCache(String paramString, ArrayList<BaseFinderFeed> paramArrayList, com.tencent.mm.bx.b paramb)
    {
      AppMethodBeat.i(198133);
      d.g.b.k.h(paramString, "key");
      d.g.b.k.h(paramArrayList, "dataList");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((Collection)paramArrayList);
      BaseFinderFeedLoader.access$getLoaderCache$cp().put(paramString, new Cache(localArrayList, paramb));
      AppMethodBeat.o(198133);
    }
    
    public final void removeCache(String paramString)
    {
      AppMethodBeat.i(198134);
      d.g.b.k.h(paramString, "key");
      BaseFinderFeedLoader.access$getLoaderCache$cp().remove(paramString);
      AppMethodBeat.o(198134);
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$Companion$Cache;", "", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "(Ljava/util/ArrayList;Lcom/tencent/mm/protobuf/ByteString;)V", "getDataList", "()Ljava/util/ArrayList;", "getLastBuffer", "()Lcom/tencent/mm/protobuf/ByteString;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "plugin-finder_release"})
    public static final class Cache
    {
      private final ArrayList<BaseFinderFeed> dataList;
      private final com.tencent.mm.bx.b lastBuffer;
      
      public Cache(ArrayList<BaseFinderFeed> paramArrayList, com.tencent.mm.bx.b paramb)
      {
        AppMethodBeat.i(185702);
        this.dataList = paramArrayList;
        this.lastBuffer = paramb;
        AppMethodBeat.o(185702);
      }
      
      public final ArrayList<BaseFinderFeed> component1()
      {
        return this.dataList;
      }
      
      public final com.tencent.mm.bx.b component2()
      {
        return this.lastBuffer;
      }
      
      public final Cache copy(ArrayList<BaseFinderFeed> paramArrayList, com.tencent.mm.bx.b paramb)
      {
        AppMethodBeat.i(198129);
        d.g.b.k.h(paramArrayList, "dataList");
        paramArrayList = new Cache(paramArrayList, paramb);
        AppMethodBeat.o(198129);
        return paramArrayList;
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(185705);
        if (this != paramObject)
        {
          if ((paramObject instanceof Cache))
          {
            paramObject = (Cache)paramObject;
            if ((!d.g.b.k.g(this.dataList, paramObject.dataList)) || (!d.g.b.k.g(this.lastBuffer, paramObject.lastBuffer))) {}
          }
        }
        else
        {
          AppMethodBeat.o(185705);
          return true;
        }
        AppMethodBeat.o(185705);
        return false;
      }
      
      public final ArrayList<BaseFinderFeed> getDataList()
      {
        return this.dataList;
      }
      
      public final com.tencent.mm.bx.b getLastBuffer()
      {
        return this.lastBuffer;
      }
      
      public final int hashCode()
      {
        int j = 0;
        AppMethodBeat.i(185704);
        Object localObject = this.dataList;
        if (localObject != null) {}
        for (int i = localObject.hashCode();; i = 0)
        {
          localObject = this.lastBuffer;
          if (localObject != null) {
            j = localObject.hashCode();
          }
          AppMethodBeat.o(185704);
          return i * 31 + j;
        }
      }
      
      public final String toString()
      {
        AppMethodBeat.i(185703);
        String str = "Cache(dataList=" + this.dataList + ", lastBuffer=" + this.lastBuffer + ")";
        AppMethodBeat.o(185703);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */
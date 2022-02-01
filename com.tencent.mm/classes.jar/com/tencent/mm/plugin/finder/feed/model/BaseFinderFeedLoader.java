package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gx;
import com.tencent.mm.g.a.gx.a;
import com.tencent.mm.g.a.ha;
import com.tencent.mm.g.a.ha.a;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.upload.f.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.ac;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lcom/tencent/mm/plugin/finder/upload/IFinderPostListener;", "username", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "feedChangeListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1;", "feedDeleteListener", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1;", "getUsername", "()Ljava/lang/String;", "isObservePostEvent", "", "onAlive", "", "onDead", "onPostEnd", "localId", "", "isOk", "onPostNotify", "onPostOk", "svrID", "onPostStart", "remove", "", "feedId", "notify", "removeByLocalId", "feedLocalId", "transformFinderObj", "feedObj", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "updateByLocalId", "newFeed", "updateItem", "svrId", "updateProgressByLoalId", "Companion", "plugin-finder_release"})
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
  
  public BaseFinderFeedLoader(String paramString, anm paramanm)
  {
    super(paramanm);
    this.username = paramString;
    this.feedDeleteListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final gx paramAnonymousgx)
      {
        AppMethodBeat.i(202046);
        if (paramAnonymousgx != null) {
          com.tencent.mm.ac.c.g((d.g.a.a)new d.g.b.l(paramAnonymousgx)
          {
            public final void invoke()
            {
              AppMethodBeat.i(202045);
              if (paramAnonymousgx.dhS.id != 0L)
              {
                this.this$0.this$0.remove(paramAnonymousgx.dhS.id, true);
                AppMethodBeat.o(202045);
                return;
              }
              this.this$0.this$0.removeByLocalId(paramAnonymousgx.dhS.dcd, true);
              AppMethodBeat.o(202045);
            }
          });
        }
        AppMethodBeat.o(202046);
        return false;
      }
    };
    this.feedChangeListener = new com.tencent.mm.sdk.b.c()
    {
      public final boolean callback(final ha paramAnonymousha)
      {
        AppMethodBeat.i(202044);
        d.g.b.k.h(paramAnonymousha, "event");
        com.tencent.mm.ac.c.a(0L, (d.g.a.a)new d.g.b.l(paramAnonymousha)
        {
          public final void invoke()
          {
            AppMethodBeat.i(202043);
            ac.i(this.this$0.this$0.getTAG(), "feedChangeListener " + paramAnonymousha.dhX.id);
            switch (paramAnonymousha.dhX.type)
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
              AppMethodBeat.o(202043);
              return;
              if (paramAnonymousha.dhX.id != 0L)
              {
                Object localObject = d.rEF;
                localObject = paramAnonymousha.dhX;
                if (localObject == null) {
                  d.g.b.k.fOy();
                }
                localObject = d.a.uS(((ha.a)localObject).id);
                int i;
                int j;
                if (localObject != null)
                {
                  Iterator localIterator = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  if (!localIterator.hasNext()) {
                    break label279;
                  }
                  if (((BaseFinderFeed)localIterator.next()).feedObject.getId() != paramAnonymousha.dhX.id) {
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
                  AppMethodBeat.o(202043);
                  return;
                  j = 0;
                  break label208;
                  i += 1;
                  break;
                  i = -1;
                }
                if (paramAnonymousha.dhX.id != 0L)
                {
                  localObject = ((List)this.this$0.this$0.getDataList()).iterator();
                  i = 0;
                  label320:
                  if (((Iterator)localObject).hasNext()) {
                    if (((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getId() == paramAnonymousha.dhX.id)
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
                    AppMethodBeat.o(202043);
                    return;
                    j = 0;
                    break label360;
                    i += 1;
                    break label320;
                    i = -1;
                  }
                  if (paramAnonymousha.dhX.id != 0L)
                  {
                    localObject = ((List)this.this$0.this$0.getDataList()).iterator();
                    i = 0;
                    label457:
                    if (((Iterator)localObject).hasNext()) {
                      if (((BaseFinderFeed)((Iterator)localObject).next()).feedObject.getId() == paramAnonymousha.dhX.id)
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
        AppMethodBeat.o(202044);
        return true;
      }
    };
  }
  
  private final BaseFinderFeed transformFinderObj(FinderItem paramFinderItem)
  {
    com.tencent.mm.plugin.finder.storage.logic.b.a locala = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    return com.tencent.mm.plugin.finder.storage.logic.b.a.i(paramFinderItem);
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
      f.a locala = f.rNg;
      f.cCv().a((com.tencent.mm.plugin.finder.upload.k)this);
    }
    this.feedDeleteListener.alive();
    this.feedChangeListener.alive();
  }
  
  public void onDead()
  {
    super.onDead();
    if (isObservePostEvent())
    {
      f.a locala = f.rNg;
      f.cCv().b((com.tencent.mm.plugin.finder.upload.k)this);
    }
    this.feedDeleteListener.dead();
    this.feedChangeListener.dead();
  }
  
  public void onFetchDone(IResponse paramIResponse)
  {
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bb(paramIResponse);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader", "com/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader", "onFetchDone", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;)V", this, localb.aeE());
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
    Object localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    Object localObject2 = com.tencent.mm.plugin.finder.storage.logic.b.a.ve(paramLong);
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = transformFinderObj((FinderItem)localObject2);
      ac.i(getTAG(), "onPostStart localId " + paramLong + " feed " + localObject2);
      ((ArrayList)localObject1).add(localObject2);
      com.tencent.mm.plugin.finder.feed.model.internal.b.mergeDataAndNotify$default(this, 2, (List)localObject1, true, null, 8, null);
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
        j.fOc();
      }
      if (((BaseFinderFeed)localObject2).feedObject.getLocalId() == paramBaseFinderFeed.feedObject.getLocalId())
      {
        getDataList().set(i, paramBaseFinderFeed);
        j = i;
        if (!paramBoolean) {
          break;
        }
        ac.i(getTAG(), "updateByLocalId " + paramBaseFinderFeed.feedObject.getLocalId());
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
    Object localObject = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
    localObject = com.tencent.mm.plugin.finder.storage.logic.b.a.ve(paramLong);
    if (localObject != null)
    {
      ac.i(getTAG(), "updateItem localId:" + paramLong + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
      localObject = transformFinderObj((FinderItem)localObject);
      if (localObject != null) {
        updateByLocalId((BaseFinderFeed)localObject, true);
      }
    }
  }
  
  protected final void updateItem(long paramLong1, long paramLong2)
  {
    Object localObject = d.rEF;
    localObject = d.a.uS(paramLong2);
    if (localObject != null) {
      ((FinderItem)localObject).setLocalId(paramLong1);
    }
    if (localObject != null)
    {
      ac.i(getTAG(), "updateItem localId:" + paramLong1 + " itemLoadId:" + ((FinderItem)localObject).getLocalId() + " itemId:" + ((FinderItem)localObject).getId());
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
          j.fOc();
        }
        localObject2 = (BaseFinderFeed)localObject2;
        if (((BaseFinderFeed)localObject2).feedObject.getLocalId() == paramLong)
        {
          Object localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
          localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.a.ve(paramLong);
          if (localObject3 != null) {
            getDataList().set(i, transformFinderObj((FinderItem)localObject3));
          }
          ac.i(getTAG(), "updateProgressByLoalId " + ((BaseFinderFeed)localObject2).feedObject.getLocalId());
          dispatcher().m(i, new o(Integer.valueOf(2), Integer.valueOf(1)));
        }
        i += 1;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$Companion;", "", "()V", "loaderCache", "", "", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$Companion$Cache;", "create", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "scene", "Lcom/tencent/mm/plugin/finder/feed/model/internal/FinderLoaderScene;", "username", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "profileCacheKey", "putCache", "", "key", "dataList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "Lkotlin/collections/ArrayList;", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "removeCache", "Cache", "plugin-finder_release"})
  public static final class Companion
  {
    public final BaseFinderFeedLoader create(com.tencent.mm.plugin.finder.feed.model.internal.c paramc, String paramString1, anm paramanm, String paramString2)
    {
      Object localObject2 = null;
      AppMethodBeat.i(202039);
      d.g.b.k.h(paramc, "scene");
      d.g.b.k.h(paramString1, "username");
      d.g.b.k.h(paramString2, "profileCacheKey");
      Object localObject1;
      if ((BaseFinderFeedLoader.access$getLoaderCache$cp().containsKey(paramString2)) && ((paramc == com.tencent.mm.plugin.finder.feed.model.internal.c.rod) || (paramc == com.tencent.mm.plugin.finder.feed.model.internal.c.roe)))
      {
        ac.i("Finder.FinderFeedLoader", "getfromCache username " + paramString1 + ", profileCacheKey " + paramString2);
        ArrayList localArrayList = new ArrayList();
        localObject1 = (BaseFinderFeedLoader.Companion.Cache)BaseFinderFeedLoader.access$getLoaderCache$cp().get(paramString2);
        if (localObject1 != null)
        {
          localObject1 = ((BaseFinderFeedLoader.Companion.Cache)localObject1).getDataList();
          if (localObject1 != null)
          {
            localObject1 = (Collection)localObject1;
            localArrayList.addAll((Collection)localObject1);
            paramString1 = new FinderProfileFeedLoader(paramc, paramString1, localArrayList, paramanm);
            paramanm = (BaseFinderFeedLoader.Companion.Cache)BaseFinderFeedLoader.access$getLoaderCache$cp().get(paramString2);
            paramc = localObject2;
            if (paramanm != null) {
              paramc = paramanm.getLastBuffer();
            }
            paramString1.setLastBuffer(paramc);
            paramc = paramString1;
          }
        }
      }
      for (;;)
      {
        paramc = (BaseFinderFeedLoader)paramc;
        AppMethodBeat.o(202039);
        return paramc;
        localObject1 = (Collection)v.KTF;
        break;
        if (paramc == com.tencent.mm.plugin.finder.feed.model.internal.c.rnY)
        {
          paramc = new m(paramc, paramanm);
        }
        else if (paramc == com.tencent.mm.plugin.finder.feed.model.internal.c.rof)
        {
          paramc = new k(paramc, paramanm);
        }
        else if ((paramc == com.tencent.mm.plugin.finder.feed.model.internal.c.rod) || (paramc == com.tencent.mm.plugin.finder.feed.model.internal.c.roe))
        {
          ac.i("Finder.FinderFeedLoader", "getfromCreate username ".concat(String.valueOf(paramString1)));
          paramc = new FinderProfileFeedLoader(paramc, paramString1, null, paramanm, 4, null);
        }
        else
        {
          paramc = new FinderProfileFeedLoader(paramc, paramString1, null, paramanm, 4, null);
        }
      }
    }
    
    public final void putCache(String paramString, ArrayList<BaseFinderFeed> paramArrayList, com.tencent.mm.bw.b paramb)
    {
      AppMethodBeat.i(202041);
      d.g.b.k.h(paramString, "key");
      d.g.b.k.h(paramArrayList, "dataList");
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll((Collection)paramArrayList);
      BaseFinderFeedLoader.access$getLoaderCache$cp().put(paramString, new BaseFinderFeedLoader.Companion.Cache(localArrayList, paramb));
      AppMethodBeat.o(202041);
    }
    
    public final void removeCache(String paramString)
    {
      AppMethodBeat.i(202042);
      d.g.b.k.h(paramString, "key");
      BaseFinderFeedLoader.access$getLoaderCache$cp().remove(paramString);
      AppMethodBeat.o(202042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader
 * JD-Core Version:    0.7.0.1
 */
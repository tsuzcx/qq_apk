package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.w;
import com.tencent.mm.plugin.finder.report.n.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.utils.b.b;
import com.tencent.mm.plugin.finder.utils.o.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.aqj;
import com.tencent.mm.protocal.protobuf.aqk;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvf;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import d.a.j;
import d.l;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class aw
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static final a rJQ;
  private com.tencent.mm.al.f callback;
  public final String clientId;
  private final long dnz;
  public FinderObject rJO;
  private FinderItem rJP;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(165259);
    rJQ = new a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public aw(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.rJP = paramFinderItem;
    this.clientId = paramString;
    this.dnz = paramLong;
    this.rJO = this.rJP.getFeedObject();
    paramString = new com.tencent.mm.al.b.a();
    paramString.Dl("/cgi-bin/micromsg-bin/finderpost");
    paramString.oP(getType());
    aqj localaqj = new aqj();
    localaqj.clientId = this.clientId;
    paramFinderItem = (com.tencent.mm.bx.a)new FinderObjectDesc();
    Object localObject1 = this.rJO.objectDesc.toByteArray();
    try
    {
      paramFinderItem.parseFrom((byte[])localObject1);
      if (paramFinderItem == null) {
        d.g.b.p.gfZ();
      }
      paramFinderItem = (FinderObjectDesc)paramFinderItem;
      if (this.rJO.refObjectId == 0L)
      {
        localObject1 = paramFinderItem.media;
        d.g.b.p.g(localObject1, "objectDesc.media");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderMedia)((Iterator)localObject1).next();
          Object localObject3 = this.rJP;
          String str = ai.ee(((FinderMedia)localObject2).url);
          d.g.b.p.g(str, "MD5Util.getMD5String(media.url)");
          localObject3 = ((FinderItem)localObject3).mediaExt(str);
          if (localObject3 != null)
          {
            ((FinderMedia)localObject2).url = ((bvf)localObject3).GPr;
            ((FinderMedia)localObject2).thumbUrl = ((bvf)localObject3).GPs;
            ((FinderMedia)localObject2).md5sum = ((bvf)localObject3).md5sum;
            ((FinderMedia)localObject2).coverUrl = ((bvf)localObject3).GPv;
          }
        }
      }
    }
    catch (Exception paramFinderItem)
    {
      Object localObject2;
      for (;;)
      {
        ad.l("safeParser", "", new Object[] { paramFinderItem });
        paramFinderItem = null;
      }
      if (paramFinderItem.mediaType == 8) {
        paramFinderItem.mediaType = 0;
      }
      localaqj.Got = paramFinderItem;
      paramFinderItem = localaqj.Got.media;
      if (paramFinderItem != null)
      {
        paramFinderItem = ((Iterable)paramFinderItem).iterator();
        while (paramFinderItem.hasNext())
        {
          localObject1 = (FinderMedia)paramFinderItem.next();
          if ((localObject1 != null) && (((FinderMedia)localObject1).mediaType == 4) && ((((FinderMedia)localObject1).videoDuration <= 0) || (((FinderMedia)localObject1).videoDuration > 2000)))
          {
            ad.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + ((FinderMedia)localObject1).videoDuration);
            if ((com.tencent.mm.sdk.platformtools.i.DEBUG) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.i.IS_FLAVOR_RED))
            {
              paramFinderItem = (Throwable)new RuntimeException("NetSceneFinderPost videoDuration invalid:" + ((FinderMedia)localObject1).videoDuration);
              AppMethodBeat.o(165258);
              throw paramFinderItem;
            }
          }
        }
      }
      localaqj.username = u.aAu();
      localaqj.Gou = this.rJO.refObjectId;
      localaqj.refObjectNonceId = this.rJO.refObjectNonceId;
      paramFinderItem = v.rIR;
      localaqj.Glv = v.cxY();
      paramFinderItem = this.rJP.field_postExtraData;
      if (paramFinderItem != null)
      {
        localaqj.dyz = paramFinderItem.dyz;
        localaqj.dAp = paramFinderItem.dAp;
        localaqj.Gor = paramFinderItem.Gor;
        localaqj.Goq = paramFinderItem.Goq;
        localaqj.Gos = paramFinderItem.Gos;
      }
      localaqj.Gov = new LinkedList();
      paramFinderItem = com.tencent.mm.plugin.finder.storage.b.sxa;
      if (com.tencent.mm.plugin.finder.storage.b.cGf())
      {
        paramFinderItem = new ArrayList();
        localObject1 = com.tencent.mm.plugin.finder.storage.b.sxa;
        if (com.tencent.mm.plugin.finder.storage.b.cGg())
        {
          paramFinderItem = new HashMap();
          if ((this.rJP.field_postinfo != null) && (this.rJP.field_postinfo.GPD != null))
          {
            localObject1 = this.rJP.field_postinfo.GPD.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bvd)((Iterator)localObject1).next();
              paramFinderItem.put(((bvd)localObject2).nickname, localObject2);
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.b.sKO;
          localObject1 = this.rJO.objectDesc.description;
          d.g.b.p.g(localObject1, "feedObject.objectDesc.description");
          paramFinderItem = (ArrayList)com.tencent.mm.plugin.finder.utils.b.a((String)localObject1, paramFinderItem, null).second;
        }
        localObject1 = localaqj.Gov;
        localObject2 = com.tencent.mm.plugin.finder.utils.o.sMi;
        localObject2 = this.rJO.objectDesc.description;
        d.g.b.p.g(localObject2, "feedObject.objectDesc.description");
        localObject2 = (Iterable)com.tencent.mm.plugin.finder.utils.o.a((String)localObject2, paramFinderItem, null);
        paramFinderItem = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramFinderItem.add(((o.c)((Iterator)localObject2).next()).dzZ);
        }
        ((LinkedList)localObject1).addAll((Collection)paramFinderItem);
      }
      localaqj.originalFlag = this.rJO.originalFlag;
      paramString.c((com.tencent.mm.bx.a)localaqj);
      paramString.d((com.tencent.mm.bx.a)new aqk());
      paramFinderItem = new StringBuilder("post clientId ").append(this.clientId).append(" content: ");
      localObject1 = localaqj.Got;
      d.g.b.p.g(localObject1, "postRequest.content");
      ad.i("Finder.LogPost.NetSceneFinderPost", com.tencent.mm.ad.f.bF(localObject1) + " refId: " + localaqj.Gou + " localId:" + this.rJP.getLocalId() + " isCreatedInFinder:" + localaqj.Gos + ", latitude:" + localaqj.dyz + ", longitude:" + localaqj.dAp + ", feedLatitude:" + localaqj.Gor + ", feedLongitude:" + localaqj.Goq + ", originalFlag:" + this.rJO.originalFlag);
      paramFinderItem = paramString.aDC();
      d.g.b.p.g(paramFinderItem, "builder.buildInstance()");
      this.rr = paramFinderItem;
      AppMethodBeat.o(165258);
    }
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().wP(paramLong);
    Object localObject = new StringBuilder("updateLocalFeed, isExist ");
    label136:
    int i;
    if (localFinderItem == null)
    {
      bool = true;
      ad.i("Finder.LogPost.NetSceneFinderPost", bool);
      if (localFinderItem == null) {
        break label407;
      }
      localFinderItem.setPostFinish();
      e(paramFinderObject);
      localFinderItem.updateFinderObject(paramFinderObject);
      localObject = com.tencent.mm.plugin.finder.storage.data.k.sAe;
      d.g.b.p.h(localFinderItem, "item");
      k.a.c(paramLong, localFinderItem);
      localObject = com.tencent.mm.ui.component.a.KiD;
      Iterator localIterator = ((Iterable)((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Gi(3).sZm).iterator();
      if (!localIterator.hasNext()) {
        break label248;
      }
      localObject = localIterator.next();
      al localal = (al)localObject;
      if ((!(localal instanceof BaseFinderFeed)) || (((BaseFinderFeed)localal).feedObject.getLocalId() != paramLong) || (paramLong == 0L)) {
        break label242;
      }
      i = 1;
      label195:
      if (i == 0) {
        break label246;
      }
    }
    for (;;)
    {
      localObject = (al)localObject;
      if (localObject == null) {
        break label276;
      }
      if (localObject != null) {
        break label254;
      }
      paramFinderObject = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      AppMethodBeat.o(165255);
      throw paramFinderObject;
      bool = false;
      break;
      label242:
      i = 0;
      break label195;
      label246:
      break label136;
      label248:
      localObject = null;
    }
    label254:
    localObject = (BaseFinderFeed)localObject;
    d.g.b.p.h(localFinderItem, "<set-?>");
    ((BaseFinderFeed)localObject).feedObject = localFinderItem;
    label276:
    localFinderItem.setMediaExtList(new LinkedList());
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().u(paramLong, false);
    ad.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
    localObject = com.tencent.mm.plugin.finder.storage.data.d.szI;
    paramLong = paramFinderObject.id;
    d.g.b.p.h(localFinderItem, "finder");
    paramFinderObject = com.tencent.mm.plugin.finder.storage.data.d.cJd();
    d.g.b.p.g(paramFinderObject, "cacheItems");
    paramFinderObject.put(Long.valueOf(paramLong), localFinderItem);
    AppMethodBeat.o(165255);
    return;
    label407:
    AppMethodBeat.o(165255);
  }
  
  private final void cyI()
  {
    AppMethodBeat.i(201159);
    Object localObject1 = this.rJP.field_postinfo.GPD.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bvd)((Iterator)localObject1).next()).sMP = this.rJP.field_createTime;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.b.sKO;
    Object localObject3 = this.rJP.field_postinfo.GPD;
    d.g.b.p.g(localObject3, "finderItem.field_postinfo.atContactList");
    d.g.b.p.h(localObject3, "atContacts");
    if (!((LinkedList)localObject3).isEmpty())
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.b.cKZ();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinkedList();
      }
      localObject2 = new HashMap(((LinkedList)localObject1).size());
      Object localObject4 = ((LinkedList)localObject1).iterator();
      bvd localbvd;
      while (((Iterator)localObject4).hasNext())
      {
        localbvd = (bvd)((Iterator)localObject4).next();
        ((HashMap)localObject2).put(localbvd.username, localbvd);
      }
      localObject3 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (bvd)((Iterator)localObject3).next();
        localbvd = (bvd)((HashMap)localObject2).get(((bvd)localObject4).username);
        if ((localbvd == null) || (localbvd.sMP < ((bvd)localObject4).sMP)) {
          ((HashMap)localObject2).put(((bvd)localObject4).username, localObject4);
        }
      }
      ((LinkedList)localObject1).clear();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map.Entry)localObject3).getKey();
        ((LinkedList)localObject1).add((bvd)((Map.Entry)localObject3).getValue());
      }
      Collections.sort((List)localObject1, (Comparator)b.b.sKR);
      if (((LinkedList)localObject1).size() > 5)
      {
        int i = ((LinkedList)localObject1).size() - 1;
        while (i >= 5)
        {
          ((LinkedList)localObject1).remove(i);
          i -= 1;
        }
      }
      localObject2 = new bvh();
      ((bvh)localObject2).Gne = ((LinkedList)localObject1);
      try
      {
        localObject1 = ((bvh)localObject2).toByteArray();
        if (localObject1 == null)
        {
          AppMethodBeat.o(201159);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = FinderPostAtUI.sEw;
        ad.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(201159);
        return;
      }
      com.tencent.mm.plugin.finder.utils.b.Lv().encode("_finder_at_mmkv_recent_at", localIOException);
    }
    AppMethodBeat.o(201159);
  }
  
  private final void e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165256);
    Iterator localIterator = ((Iterable)this.rJP.getMediaExtList()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.gfB();
      }
      Object localObject2 = (bvf)localObject1;
      localObject1 = com.tencent.mm.plugin.finder.upload.f.sJc;
      localObject1 = ((bvf)localObject2).url;
      d.g.b.p.g(localObject1, "localMedia.url");
      com.tencent.mm.plugin.finder.upload.f.aiM((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.upload.f.sJc;
      localObject1 = ((bvf)localObject2).thumbUrl;
      d.g.b.p.g(localObject1, "localMedia.thumbUrl");
      com.tencent.mm.plugin.finder.upload.f.aiM((String)localObject1);
      localObject1 = paramFinderObject.objectDesc.media;
      d.g.b.p.g(localObject1, "svrFeed.objectDesc.media");
      Object localObject3 = ((Iterable)localObject1).iterator();
      label179:
      Object localObject4;
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          if (d.g.b.p.i(((FinderMedia)localObject1).url, ((bvf)localObject2).GPr))
          {
            localObject3 = (FinderMedia)localObject1;
            if (localObject3 == null) {
              break label817;
            }
            ad.v("Finder.LogPost.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((bvf)localObject2).mediaId + " newMediaID " + ai.ee(((FinderMedia)localObject3).url));
            ((bvf)localObject2).mediaId = ai.ee(((FinderMedia)localObject3).url);
            if ((((bvf)localObject2).mediaType == 2) || (((bvf)localObject2).mediaType == 7))
            {
              localObject1 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject2, r.syE);
              localObject4 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject2, r.syD);
              ad.i("Finder.LogPost.NetSceneFinderPost", "cp image files thumbUrl " + ((bvf)localObject2).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.g)localObject1).getPath() + " url " + ((FinderMedia)localObject3).thumbUrl);
              ad.i("Finder.LogPost.NetSceneFinderPost", "cp image files url " + ((bvf)localObject2).url + " to path " + ((com.tencent.mm.plugin.finder.loader.g)localObject4).getPath() + "  url " + ((FinderMedia)localObject3).url);
              com.tencent.mm.vfs.i.mz(((bvf)localObject2).thumbUrl, ((com.tencent.mm.plugin.finder.loader.g)localObject1).getPath());
              com.tencent.mm.vfs.i.mz(((bvf)localObject2).url, ((com.tencent.mm.plugin.finder.loader.g)localObject4).getPath());
            }
            if (((bvf)localObject2).mediaType == 4)
            {
              localObject4 = new com.tencent.mm.plugin.finder.loader.g((bvf)localObject2, r.syE);
              if (!com.tencent.mm.modelcontrol.d.pf(4)) {
                break label812;
              }
            }
          }
        }
      }
      label812:
      for (i = 2;; i = 1)
      {
        localObject1 = new m((bvf)localObject2, r.syQ, i, null, 8);
        Object localObject5 = new com.tencent.mm.plugin.finder.loader.n((bvf)localObject2, r.syD);
        ad.i("Finder.LogPost.NetSceneFinderPost", "cp video files thumbUrl " + ((bvf)localObject2).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.g)localObject4).getPath() + "  url " + ((FinderMedia)localObject3).thumbUrl);
        ad.i("Finder.LogPost.NetSceneFinderPost", "cp video files url " + ((bvf)localObject2).url + " to path " + ((m)localObject1).getPath() + "  url " + ((FinderMedia)localObject3).url);
        ad.i("Finder.LogPost.NetSceneFinderPost", "cp cover files url " + ((bvf)localObject2).url + " to path " + ((com.tencent.mm.plugin.finder.loader.n)localObject5).getPath() + "  url " + ((FinderMedia)localObject3).coverUrl);
        com.tencent.mm.vfs.i.mz(((bvf)localObject2).thumbUrl, ((com.tencent.mm.plugin.finder.loader.g)localObject4).getPath());
        com.tencent.mm.vfs.i.mz(((bvf)localObject2).url, ((m)localObject1).getPath());
        com.tencent.mm.vfs.i.mz(((bvf)localObject2).coverUrl, ((com.tencent.mm.plugin.finder.loader.n)localObject5).getPath());
        long l = com.tencent.mm.vfs.i.aYo(((bvf)localObject2).url);
        localObject3 = c.sAv;
        localObject3 = ((m)localObject1).aeA();
        localObject4 = ((bvf)localObject2).mediaId;
        d.g.b.p.g(localObject4, "localMedia.mediaId");
        localObject5 = ((bvf)localObject2).url;
        d.g.b.p.g(localObject5, "localMedia.url");
        localObject2 = ((bvf)localObject2).url;
        d.g.b.p.g(localObject2, "localMedia.url");
        c.a((String)localObject3, (String)localObject4, (String)localObject5, (String)localObject2, i, r.syQ.detail, l, l, 3, ((m)localObject1).siC.videoDuration, "", "");
        i = j;
        break;
        localObject1 = null;
        break label179;
      }
      label817:
      i = j;
    }
    AppMethodBeat.o(165256);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(165254);
    this.callback = paramf;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165254);
    return i;
  }
  
  public final int getType()
  {
    return 3585;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165257);
    ad.i("Finder.LogPost.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.rJP.getLocalId(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.dnz) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 5L, 1L, false);
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.aEF(); paramq == null; paramq = null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(165257);
        throw paramString;
      }
      paramArrayOfByte = ((aqk)paramq).Gow;
      localObject = new StringBuilder("onGYNetEnd ").append(paramArrayOfByte).append(' ');
      if (paramArrayOfByte != null)
      {
        paramq = Long.valueOf(paramArrayOfByte.id);
        ad.i("Finder.LogPost.NetSceneFinderPost", paramq + ", localId:" + this.dnz);
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        if (!com.tencent.mm.plugin.finder.storage.logic.b.a.xf(this.dnz)) {
          break label609;
        }
        localObject = this.rJO.contact;
        if (paramArrayOfByte != null) {
          break label832;
        }
      }
    }
    label806:
    label808:
    label816:
    label832:
    for (paramq = this.rJO;; paramq = paramArrayOfByte)
    {
      this.rJO = paramq;
      FinderObject localFinderObject = this.rJO;
      paramArrayOfByte = this.rJO.nickname;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = ((FinderContact)localObject).nickname;
      }
      localFinderObject.nickname = paramq;
      this.rJO.contact = ((FinderContact)localObject);
      a(this.dnz, this.rJO);
      cyI();
      paramq = com.tencent.mm.plugin.finder.storage.data.d.szI;
      paramq = d.a.wT(this.rJO.id);
      long l;
      if (paramq != null)
      {
        paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.sKi;
        paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.cKV().xm(this.dnz);
        boolean bool2 = ((Boolean)paramArrayOfByte.first).booleanValue();
        bool1 = ((Boolean)paramArrayOfByte.second).booleanValue();
        if (bool2)
        {
          paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.sKi;
          paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.cKV();
          l = this.dnz;
          d.g.b.p.h(paramq, "feed");
          ad.i(com.tencent.mm.plugin.finder.upload.action.g.TAG, "doLikeLocalFeed localId:" + l + ", isPrivate:" + bool1 + ", feedid:" + paramq.getId());
          paramArrayOfByte = (com.tencent.mm.plugin.finder.storage.o)paramArrayOfByte.sKg.get(Long.valueOf(l));
          if (paramArrayOfByte != null)
          {
            localObject = w.skq;
            localObject = paramArrayOfByte.field_contextObj;
            d.g.b.p.g(localObject, "action.field_contextObj");
            paramInt1 = paramArrayOfByte.field_likeAction;
            int i = paramArrayOfByte.field_scene;
            bool2 = paramArrayOfByte.field_showTips;
            paramArrayOfByte = com.tencent.mm.plugin.finder.utils.p.sMo;
            w.a((aqy)localObject, paramInt1, paramq, true, bool1, i, bool2, false, com.tencent.mm.plugin.finder.utils.p.cLC());
          }
        }
      }
      for (;;)
      {
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.p.gfZ();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        }
        paramq = com.tencent.mm.plugin.finder.spam.a.suA;
        com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(165257);
        return;
        paramq = null;
        break;
        label609:
        if (paramArrayOfByte != null)
        {
          paramq = u.aAu();
          d.g.b.p.g(paramq, "ConfigStorageLogic.getMyFinderUsername()");
          l = paramArrayOfByte.id;
          paramArrayOfByte = paramArrayOfByte.objectNonceId;
          d.g.b.p.g(paramArrayOfByte, "it.objectNonceId");
          paramq = new aa(paramq, l, paramArrayOfByte);
          com.tencent.mm.kernel.g.aiU().b((com.tencent.mm.al.n)paramq);
        }
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 6L, 1L, false);
      paramq = n.c.sqy;
      n.c.cDV();
      paramq = com.tencent.mm.plugin.finder.spam.a.suA;
      boolean bool1 = com.tencent.mm.plugin.finder.spam.a.fP(paramInt2, paramInt3);
      if (paramInt3 == -4013)
      {
        paramInt1 = 1;
        label722:
        if ((paramInt2 != 4) && (bool1) && (paramInt1 == 0)) {
          break label806;
        }
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.a.xg(this.dnz);
        if (paramq != null)
        {
          if (!bool1) {
            break label816;
          }
          if (paramInt1 == 0) {
            break label808;
          }
          paramq.setPostFailedAndNoAuth();
        }
      }
      for (;;)
      {
        this.rJP.field_localFlag = paramq.field_localFlag;
        paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
        com.tencent.mm.plugin.finder.storage.logic.b.a.i(paramq);
        paramq = n.c.sqy;
        n.c.cDN();
        break;
        paramInt1 = 0;
        break label722;
        break;
        paramq.setPostFailed();
        continue;
        paramArrayOfByte = n.c.sqy;
        n.c.cDW();
        paramq.setPostFailedAndNotRetry();
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aw
 * JD-Core Version:    0.7.0.1
 */
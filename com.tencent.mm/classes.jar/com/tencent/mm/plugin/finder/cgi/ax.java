package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.am;
import com.tencent.mm.plugin.finder.model.x;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.d.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.i;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.r;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.utils.b.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.aqz;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.bvx;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwb;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ay;
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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class ax
  extends com.tencent.mm.ak.n
  implements com.tencent.mm.network.k
{
  public static final a rSe;
  private com.tencent.mm.ak.f callback;
  public final String clientId;
  private final long doE;
  public FinderObject rSc;
  private FinderItem rSd;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(165259);
    rSe = new a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public ax(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.rSd = paramFinderItem;
    this.clientId = paramString;
    this.doE = paramLong;
    this.rSc = this.rSd.getFeedObject();
    com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
    locala.DN("/cgi-bin/micromsg-bin/finderpost");
    locala.oS(getType());
    aqy localaqy = new aqy();
    localaqy.clientId = this.clientId;
    paramString = (com.tencent.mm.bw.a)new FinderObjectDesc();
    paramFinderItem = this.rSc.objectDesc;
    if (paramFinderItem != null) {}
    for (paramFinderItem = paramFinderItem.toByteArray();; paramFinderItem = null)
    {
      try
      {
        paramString.parseFrom(paramFinderItem);
        paramFinderItem = paramString;
      }
      catch (Exception paramFinderItem)
      {
        Object localObject3;
        for (;;)
        {
          ae.l("safeParser", "", new Object[] { paramFinderItem });
          paramFinderItem = null;
        }
        if (paramFinderItem.mediaType != 8) {
          break label311;
        }
        paramFinderItem.mediaType = 0;
        localaqy.GHK = paramFinderItem;
        paramFinderItem = localaqy.GHK;
        if (paramFinderItem == null) {
          break label473;
        }
        paramFinderItem = paramFinderItem.media;
        if (paramFinderItem == null) {
          break label473;
        }
        paramFinderItem = ((Iterable)paramFinderItem).iterator();
        while (paramFinderItem.hasNext())
        {
          paramString = (FinderMedia)paramFinderItem.next();
          if ((paramString != null) && (paramString.mediaType == 4) && ((paramString.videoDuration <= 0) || (paramString.videoDuration > 2000)))
          {
            ae.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + paramString.videoDuration);
            if ((com.tencent.mm.sdk.platformtools.j.DEBUG) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) || (com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_RED))
            {
              paramFinderItem = (Throwable)new RuntimeException("NetSceneFinderPost videoDuration invalid:" + paramString.videoDuration);
              AppMethodBeat.o(165258);
              throw paramFinderItem;
            }
          }
        }
        localaqy.username = com.tencent.mm.model.v.aAK();
        localaqy.GHL = this.rSc.refObjectId;
        localaqy.refObjectNonceId = this.rSc.refObjectNonceId;
        paramFinderItem = v.rRb;
        localaqy.GDR = v.czz();
        paramFinderItem = this.rSd.field_postExtraData;
        if (paramFinderItem == null) {
          break label574;
        }
        localaqy.dzE = paramFinderItem.dzE;
        localaqy.dBu = paramFinderItem.dBu;
        localaqy.GHI = paramFinderItem.GHI;
        localaqy.GHH = paramFinderItem.GHH;
        localaqy.GHJ = paramFinderItem.GHJ;
        localaqy.GHM = new LinkedList();
        paramFinderItem = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cIc()) {
          break label872;
        }
        paramFinderItem = new ArrayList();
        paramString = com.tencent.mm.plugin.finder.storage.b.sHP;
        if (!com.tencent.mm.plugin.finder.storage.b.cId()) {
          break label754;
        }
        Object localObject1 = new HashMap();
        if ((this.rSd.field_postinfo == null) || (this.rSd.field_postinfo.Hjf == null)) {
          break label710;
        }
        Object localObject2 = this.rSd.field_postinfo.Hjf.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bvx)((Iterator)localObject2).next();
          paramString = ((bvx)localObject3).nickname;
          paramFinderItem = paramString;
          if (paramString == null) {
            paramFinderItem = "";
          }
          ((HashMap)localObject1).put(paramFinderItem, localObject3);
        }
        paramFinderItem = com.tencent.mm.plugin.finder.utils.b.sWa;
        paramFinderItem = this.rSc.objectDesc;
        if (paramFinderItem == null) {
          break label737;
        }
        paramString = paramFinderItem.description;
        paramFinderItem = paramString;
        if (paramString != null) {
          break label740;
        }
        paramFinderItem = "";
        paramFinderItem = (ArrayList)com.tencent.mm.plugin.finder.utils.b.a(paramFinderItem, (HashMap)localObject1, null).second;
        localObject2 = localaqy.GHM;
        paramString = com.tencent.mm.plugin.finder.utils.o.sXt;
        paramString = this.rSc.objectDesc;
        if (paramString == null) {
          break label791;
        }
        localObject1 = paramString.description;
        paramString = (String)localObject1;
        if (localObject1 != null) {
          break label794;
        }
        paramString = "";
        paramString = (Iterable)com.tencent.mm.plugin.finder.utils.o.a(paramString, paramFinderItem, null);
        paramFinderItem = (Collection)new ArrayList(d.a.j.a(paramString, 10));
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          paramFinderItem.add(((com.tencent.mm.plugin.finder.utils.o.c)paramString.next()).dBe);
        }
        ((LinkedList)localObject2).addAll((Collection)paramFinderItem);
        localaqy.originalFlag = this.rSc.originalFlag;
        locala.c((com.tencent.mm.bw.a)localaqy);
        locala.d((com.tencent.mm.bw.a)new aqz());
        localObject1 = new StringBuilder("post clientId ").append(this.clientId).append(" content: ");
        paramString = localaqy.GHK;
        paramFinderItem = paramString;
        if (paramString != null) {
          break label949;
        }
        paramFinderItem = "";
        ae.i("Finder.LogPost.NetSceneFinderPost", com.tencent.mm.ac.f.bF(paramFinderItem) + " refId: " + localaqy.GHL + " localId:" + this.rSd.getLocalId() + " isCreatedInFinder:" + localaqy.GHJ + ", latitude:" + localaqy.dzE + ", longitude:" + localaqy.dBu + ", feedLatitude:" + localaqy.GHI + ", feedLongitude:" + localaqy.GHH + ", originalFlag:" + this.rSc.originalFlag);
        paramFinderItem = locala.aDS();
        d.g.b.p.g(paramFinderItem, "builder.buildInstance()");
        this.rr = paramFinderItem;
        AppMethodBeat.o(165258);
      }
      if (paramFinderItem == null) {
        d.g.b.p.gkB();
      }
      paramFinderItem = (FinderObjectDesc)paramFinderItem;
      if (this.rSc.refObjectId != 0L) {
        break;
      }
      paramString = paramFinderItem.media;
      d.g.b.p.g(paramString, "objectDesc.media");
      paramString = ((Iterable)paramString).iterator();
      while (paramString.hasNext())
      {
        localObject1 = (FinderMedia)paramString.next();
        localObject2 = this.rSd;
        localObject3 = aj.ej(((FinderMedia)localObject1).url);
        d.g.b.p.g(localObject3, "MD5Util.getMD5String(media.url)");
        localObject2 = ((FinderItem)localObject2).mediaExt((String)localObject3);
        if (localObject2 != null)
        {
          ((FinderMedia)localObject1).url = ((bvz)localObject2).HiT;
          ((FinderMedia)localObject1).thumbUrl = ((bvz)localObject2).HiU;
          ((FinderMedia)localObject1).md5sum = ((bvz)localObject2).md5sum;
          ((FinderMedia)localObject1).coverUrl = ((bvz)localObject2).HiX;
        }
      }
    }
    label311:
    label473:
    label737:
    label740:
    label754:
    return;
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().xg(paramLong);
    Object localObject = new StringBuilder("updateLocalFeed, isExist ");
    label136:
    int i;
    if (localFinderItem == null)
    {
      bool = true;
      ae.i("Finder.LogPost.NetSceneFinderPost", bool);
      if (localFinderItem == null) {
        break label407;
      }
      localFinderItem.setPostFinish();
      e(paramFinderObject);
      localFinderItem.updateFinderObject(paramFinderObject);
      localObject = com.tencent.mm.plugin.finder.storage.data.k.sLb;
      d.g.b.p.h(localFinderItem, "item");
      k.a.c(paramLong, localFinderItem);
      localObject = com.tencent.mm.ui.component.a.KEX;
      Iterator localIterator = ((Iterable)((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).GH(3).tkA).iterator();
      if (!localIterator.hasNext()) {
        break label248;
      }
      localObject = localIterator.next();
      am localam = (am)localObject;
      if ((!(localam instanceof BaseFinderFeed)) || (((BaseFinderFeed)localam).feedObject.getLocalId() != paramLong) || (paramLong == 0L)) {
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
      localObject = (am)localObject;
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
    ae.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
    localObject = com.tencent.mm.plugin.finder.storage.data.d.sKD;
    paramLong = paramFinderObject.id;
    d.g.b.p.h(localFinderItem, "finder");
    paramFinderObject = com.tencent.mm.plugin.finder.storage.data.d.cLF();
    d.g.b.p.g(paramFinderObject, "cacheItems");
    paramFinderObject.put(Long.valueOf(paramLong), localFinderItem);
    AppMethodBeat.o(165255);
    return;
    label407:
    AppMethodBeat.o(165255);
  }
  
  private final void cAj()
  {
    AppMethodBeat.i(201581);
    Object localObject1 = this.rSd.field_postinfo.Hjf.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bvx)((Iterator)localObject1).next()).sYa = this.rSd.field_createTime;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.b.sWa;
    Object localObject4 = this.rSd.field_postinfo.Hjf;
    d.g.b.p.g(localObject4, "finderItem.field_postinfo.atContactList");
    d.g.b.p.h(localObject4, "atContacts");
    if (!((LinkedList)localObject4).isEmpty())
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.b.cND();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinkedList();
      }
      HashMap localHashMap = new HashMap(((LinkedList)localObject1).size());
      Object localObject5 = ((LinkedList)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject5).hasNext())
      {
        bvx localbvx = (bvx)((Iterator)localObject5).next();
        localObject3 = localbvx.username;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localHashMap.put(localObject2, localbvx);
      }
      localObject4 = ((LinkedList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (bvx)((Iterator)localObject4).next();
        localObject2 = (bvx)((Map)localHashMap).get(((bvx)localObject5).username);
        if ((localObject2 == null) || (((bvx)localObject2).sYa < ((bvx)localObject5).sYa))
        {
          localObject3 = ((bvx)localObject5).username;
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          localHashMap.put(localObject2, localObject5);
        }
      }
      ((LinkedList)localObject1).clear();
      localObject2 = ((Map)localHashMap).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map.Entry)localObject3).getKey();
        ((LinkedList)localObject1).add((bvx)((Map.Entry)localObject3).getValue());
      }
      Collections.sort((List)localObject1, (Comparator)b.b.sWd);
      if (((LinkedList)localObject1).size() > 5)
      {
        int i = ((LinkedList)localObject1).size() - 1;
        while (i >= 5)
        {
          ((LinkedList)localObject1).remove(i);
          i -= 1;
        }
      }
      localObject2 = new bwb();
      ((bwb)localObject2).GGk = ((LinkedList)localObject1);
      try
      {
        localObject1 = ((bwb)localObject2).toByteArray();
        if (localObject1 == null)
        {
          AppMethodBeat.o(201581);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = FinderPostAtUI.sPv;
        ae.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(201581);
        return;
      }
      com.tencent.mm.plugin.finder.utils.b.LD().encode("_finder_at_mmkv_recent_at", localIOException);
    }
    AppMethodBeat.o(201581);
  }
  
  private final void e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165256);
    Iterator localIterator = ((Iterable)this.rSd.getMediaExtList()).iterator();
    int i = 0;
    Object localObject1;
    int j;
    Object localObject3;
    Object localObject2;
    label195:
    Object localObject4;
    label478:
    Object localObject5;
    long l;
    if (localIterator.hasNext())
    {
      localObject1 = localIterator.next();
      j = i + 1;
      if (i < 0) {
        d.a.j.gkd();
      }
      localObject3 = (bvz)localObject1;
      localObject1 = com.tencent.mm.plugin.finder.upload.f.sUp;
      localObject2 = ((bvz)localObject3).url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.upload.f.ajJ((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.upload.f.sUp;
      localObject2 = ((bvz)localObject3).thumbUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.upload.f.ajJ((String)localObject1);
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              if (d.g.b.p.i(((FinderMedia)localObject1).url, ((bvz)localObject3).HiT))
              {
                localObject1 = (FinderMedia)localObject1;
                if (localObject1 == null) {
                  break label822;
                }
                ae.v("Finder.LogPost.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((bvz)localObject3).mediaId + " newMediaID " + aj.ej(((FinderMedia)localObject1).url));
                ((bvz)localObject3).mediaId = aj.ej(((FinderMedia)localObject1).url);
                if ((((bvz)localObject3).mediaType == 2) || (((bvz)localObject3).mediaType == 7))
                {
                  localObject2 = new com.tencent.mm.plugin.finder.loader.g((bvz)localObject3, r.sJv);
                  localObject4 = new com.tencent.mm.plugin.finder.loader.g((bvz)localObject3, r.sJu);
                  ae.i("Finder.LogPost.NetSceneFinderPost", "cp image files thumbUrl " + ((bvz)localObject3).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.g)localObject2).getPath() + " url " + ((FinderMedia)localObject1).thumbUrl);
                  ae.i("Finder.LogPost.NetSceneFinderPost", "cp image files url " + ((bvz)localObject3).url + " to path " + ((com.tencent.mm.plugin.finder.loader.g)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
                  com.tencent.mm.vfs.o.mF(((bvz)localObject3).thumbUrl, ((com.tencent.mm.plugin.finder.loader.g)localObject2).getPath());
                  com.tencent.mm.vfs.o.mF(((bvz)localObject3).url, ((com.tencent.mm.plugin.finder.loader.g)localObject4).getPath());
                }
                if (((bvz)localObject3).mediaType == 4)
                {
                  localObject2 = new com.tencent.mm.plugin.finder.loader.g((bvz)localObject3, r.sJv);
                  if (!com.tencent.mm.modelcontrol.d.pi(4)) {
                    break label817;
                  }
                  i = 2;
                  localObject4 = new m((bvz)localObject3, r.sJH, i, null, 8);
                  localObject5 = new com.tencent.mm.plugin.finder.loader.n((bvz)localObject3, r.sJu);
                  ae.i("Finder.LogPost.NetSceneFinderPost", "cp video files thumbUrl " + ((bvz)localObject3).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.g)localObject2).getPath() + "  url " + ((FinderMedia)localObject1).thumbUrl);
                  ae.i("Finder.LogPost.NetSceneFinderPost", "cp video files url " + ((bvz)localObject3).url + " to path " + ((m)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
                  ae.i("Finder.LogPost.NetSceneFinderPost", "cp cover files url " + ((bvz)localObject3).url + " to path " + ((com.tencent.mm.plugin.finder.loader.n)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
                  com.tencent.mm.vfs.o.mF(((bvz)localObject3).thumbUrl, ((com.tencent.mm.plugin.finder.loader.g)localObject2).getPath());
                  com.tencent.mm.vfs.o.mF(((bvz)localObject3).url, ((m)localObject4).getPath());
                  com.tencent.mm.vfs.o.mF(((bvz)localObject3).coverUrl, ((com.tencent.mm.plugin.finder.loader.n)localObject5).getPath());
                  l = com.tencent.mm.vfs.o.aZR(((bvz)localObject3).url);
                  localObject1 = c.sLt;
                  localObject5 = ((m)localObject4).aeM();
                  localObject1 = ((bvz)localObject3).mediaId;
                  if (localObject1 != null) {
                    break label834;
                  }
                  localObject1 = "";
                }
              }
            }
          }
        }
      }
    }
    label817:
    label822:
    label834:
    for (;;)
    {
      localObject3 = ((bvz)localObject3).url;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      c.a((String)localObject5, (String)localObject1, (String)localObject2, i, r.sJH.detail, l, l, 3, ((m)localObject4).srx.videoDuration, "", "");
      i = j;
      break;
      localObject1 = null;
      break label195;
      i = 1;
      break label478;
      i = j;
      break;
      AppMethodBeat.o(165256);
      return;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
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
    ae.i("Finder.LogPost.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.rSd.getLocalId(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.doE) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 5L, 1L, false);
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.aEV(); paramq == null; paramq = null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(165257);
        throw paramString;
      }
      paramArrayOfByte = ((aqz)paramq).sKE;
      localObject = new StringBuilder("onGYNetEnd ").append(paramArrayOfByte).append(' ');
      if (paramArrayOfByte != null)
      {
        paramq = Long.valueOf(paramArrayOfByte.id);
        ae.i("Finder.LogPost.NetSceneFinderPost", paramq + ", localId:" + this.doE);
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        if (!com.tencent.mm.plugin.finder.storage.logic.b.a.xw(this.doE)) {
          break label633;
        }
        localObject = this.rSc.contact;
        if (paramArrayOfByte != null) {
          break label861;
        }
      }
    }
    label291:
    label835:
    label837:
    label845:
    label861:
    for (paramq = this.rSc;; paramq = paramArrayOfByte)
    {
      this.rSc = paramq;
      FinderObject localFinderObject = this.rSc;
      paramArrayOfByte = this.rSc.nickname;
      paramq = paramArrayOfByte;
      long l;
      if (paramArrayOfByte == null)
      {
        if (localObject != null) {
          paramq = ((FinderContact)localObject).nickname;
        }
      }
      else
      {
        paramArrayOfByte = paramq;
        if (paramq == null) {
          paramArrayOfByte = "";
        }
        localFinderObject.nickname = paramArrayOfByte;
        this.rSc.contact = ((FinderContact)localObject);
        a(this.doE, this.rSc);
        cAj();
        paramq = com.tencent.mm.plugin.finder.storage.data.d.sKD;
        paramq = d.a.xk(this.rSc.id);
        if (paramq != null)
        {
          paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.sVv;
          paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.cNz().xD(this.doE);
          boolean bool2 = ((Boolean)paramArrayOfByte.first).booleanValue();
          bool1 = ((Boolean)paramArrayOfByte.second).booleanValue();
          if (bool2)
          {
            paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.sVv;
            paramArrayOfByte = com.tencent.mm.plugin.finder.upload.action.g.cNz();
            l = this.doE;
            d.g.b.p.h(paramq, "feed");
            ae.i(com.tencent.mm.plugin.finder.upload.action.g.TAG, "doLikeLocalFeed localId:" + l + ", isPrivate:" + bool1 + ", feedid:" + paramq.getId());
            paramArrayOfByte = (com.tencent.mm.plugin.finder.storage.o)paramArrayOfByte.sVt.get(Long.valueOf(l));
            if (paramArrayOfByte != null)
            {
              localObject = x.stn;
              localObject = paramArrayOfByte.field_contextObj;
              d.g.b.p.g(localObject, "action.field_contextObj");
              paramInt1 = paramArrayOfByte.field_likeAction;
              int i = paramArrayOfByte.field_scene;
              bool2 = paramArrayOfByte.field_showTips;
              paramArrayOfByte = com.tencent.mm.plugin.finder.utils.p.sXz;
              x.a((arn)localObject, paramInt1, paramq, true, bool1, i, bool2, false, com.tencent.mm.plugin.finder.utils.p.cOj());
            }
          }
        }
      }
      for (;;)
      {
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.p.gkB();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        }
        paramq = com.tencent.mm.plugin.finder.spam.a.sEK;
        com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(165257);
        return;
        paramq = null;
        break;
        paramq = null;
        break label291;
        label633:
        if (paramArrayOfByte != null)
        {
          localObject = com.tencent.mm.model.v.aAK();
          d.g.b.p.g(localObject, "ConfigStorageLogic.getMyFinderUsername()");
          l = paramArrayOfByte.id;
          paramArrayOfByte = paramArrayOfByte.objectNonceId;
          paramq = paramArrayOfByte;
          if (paramArrayOfByte == null) {
            paramq = "";
          }
          paramq = new ab((String)localObject, l, paramq);
          com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)paramq);
        }
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 6L, 1L, false);
      paramq = com.tencent.mm.plugin.finder.report.o.c.sAI;
      com.tencent.mm.plugin.finder.report.o.c.cFR();
      paramq = com.tencent.mm.plugin.finder.spam.a.sEK;
      boolean bool1 = com.tencent.mm.plugin.finder.spam.a.fP(paramInt2, paramInt3);
      if (paramInt3 == -4013)
      {
        paramInt1 = 1;
        label751:
        if ((paramInt2 != 4) && (bool1) && (paramInt1 == 0)) {
          break label835;
        }
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.a.xx(this.doE);
        if (paramq != null)
        {
          if (!bool1) {
            break label845;
          }
          if (paramInt1 == 0) {
            break label837;
          }
          paramq.setPostFailedAndNoAuth();
        }
      }
      for (;;)
      {
        this.rSd.field_localFlag = paramq.field_localFlag;
        paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
        com.tencent.mm.plugin.finder.storage.logic.b.a.i(paramq);
        paramq = com.tencent.mm.plugin.finder.report.o.c.sAI;
        com.tencent.mm.plugin.finder.report.o.c.cFJ();
        break;
        paramInt1 = 0;
        break label751;
        break;
        paramq.setPostFailed();
        continue;
        paramArrayOfByte = com.tencent.mm.plugin.finder.report.o.c.sAI;
        com.tencent.mm.plugin.finder.report.o.c.cFS();
        paramq.setPostFailedAndNotRetry();
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ax
 * JD-Core Version:    0.7.0.1
 */
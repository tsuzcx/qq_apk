package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.u;
import com.tencent.mm.modelcontrol.d;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.e.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.f.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.utils.h.c;
import com.tencent.mm.plugin.finder.utils.n.b;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.akl;
import com.tencent.mm.protocal.protobuf.akm;
import com.tencent.mm.protocal.protobuf.bmd;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.ebc;
import com.tencent.mm.protocal.protobuf.ebd;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.vfs.i;
import d.a.j;
import d.o;
import d.v;
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

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class x
  extends com.tencent.mm.al.n
  implements com.tencent.mm.network.k
{
  public static final a qpu;
  private com.tencent.mm.al.g callback;
  public final String clientId;
  private final long deI;
  public FinderObject qps;
  private FinderItem qpt;
  private com.tencent.mm.al.b rr;
  
  static
  {
    AppMethodBeat.i(165259);
    qpu = new a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public x(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.qpt = paramFinderItem;
    this.clientId = paramString;
    this.deI = paramLong;
    this.qps = this.qpt.getFeedObject();
    paramString = new com.tencent.mm.al.b.a();
    paramString.wg("/cgi-bin/micromsg-bin/finderpost");
    paramString.nB(getType());
    akl localakl = new akl();
    localakl.clientId = this.clientId;
    paramFinderItem = (com.tencent.mm.bx.a)new FinderObjectDesc();
    Object localObject1 = this.qps.objectDesc.toByteArray();
    try
    {
      paramFinderItem.parseFrom((byte[])localObject1);
      if (paramFinderItem == null) {
        d.g.b.k.fvU();
      }
      paramFinderItem = (FinderObjectDesc)paramFinderItem;
      if (this.qps.refObjectId == 0L)
      {
        localObject1 = paramFinderItem.media;
        d.g.b.k.g(localObject1, "objectDesc.media");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderMedia)((Iterator)localObject1).next();
          Object localObject3 = this.qpt;
          String str = ai.du(((FinderMedia)localObject2).url);
          d.g.b.k.g(str, "MD5Util.getMD5String(media.url)");
          localObject3 = ((FinderItem)localObject3).mediaExt(str);
          if (localObject3 != null)
          {
            ((FinderMedia)localObject2).url = ((bmd)localObject3).DJB;
            ((FinderMedia)localObject2).thumbUrl = ((bmd)localObject3).DJC;
            ((FinderMedia)localObject2).md5sum = ((bmd)localObject3).md5sum;
            ((FinderMedia)localObject2).coverUrl = ((bmd)localObject3).LzM;
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
      localakl.DlY = paramFinderItem;
      localakl.username = u.aqO();
      localakl.DlZ = this.qps.refObjectId;
      localakl.refObjectNonceId = this.qps.refObjectNonceId;
      paramFinderItem = am.KJy;
      localakl.Dkw = am.fRS();
      paramFinderItem = this.qpt.field_postExtraData;
      if (paramFinderItem != null)
      {
        localakl.dpb = paramFinderItem.dpb;
        localakl.dqQ = paramFinderItem.dqQ;
        localakl.DlW = paramFinderItem.DlW;
        localakl.DlV = paramFinderItem.DlV;
        localakl.DlX = paramFinderItem.DlX;
      }
      localakl.Dma = new LinkedList();
      paramFinderItem = com.tencent.mm.plugin.finder.storage.b.qJA;
      if (com.tencent.mm.plugin.finder.storage.b.cpO())
      {
        paramFinderItem = new ArrayList();
        localObject1 = com.tencent.mm.plugin.finder.storage.b.qJA;
        if (com.tencent.mm.plugin.finder.storage.b.fUh())
        {
          paramFinderItem = new HashMap();
          if ((this.qpt.field_postinfo != null) && (this.qpt.field_postinfo.LzN != null))
          {
            localObject1 = this.qpt.field_postinfo.LzN.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (ebc)((Iterator)localObject1).next();
              paramFinderItem.put(((ebc)localObject2).nickname, localObject2);
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.n.LaC;
          localObject1 = this.qps.objectDesc.description;
          d.g.b.k.g(localObject1, "feedObject.objectDesc.description");
          paramFinderItem = (ArrayList)com.tencent.mm.plugin.finder.utils.n.a((String)localObject1, paramFinderItem, null).second;
        }
        localObject1 = localakl.Dma;
        localObject2 = com.tencent.mm.plugin.finder.utils.h.qSR;
        localObject2 = this.qps.objectDesc.description;
        d.g.b.k.g(localObject2, "feedObject.objectDesc.description");
        localObject2 = (Iterable)com.tencent.mm.plugin.finder.utils.h.a((String)localObject2, paramFinderItem, null);
        paramFinderItem = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramFinderItem.add(((h.c)((Iterator)localObject2).next()).dqA);
        }
        ((LinkedList)localObject1).addAll((Collection)paramFinderItem);
      }
      localakl.originalFlag = this.qps.originalFlag;
      paramString.c((com.tencent.mm.bx.a)localakl);
      paramString.d((com.tencent.mm.bx.a)new akm());
      paramFinderItem = new StringBuilder("post clientId ").append(this.clientId).append(" content: ");
      localObject1 = localakl.DlY;
      d.g.b.k.g(localObject1, "postRequest.content");
      ad.i("Finder.NetSceneFinderPost", com.tencent.mm.ad.f.bG(localObject1) + " refId: " + localakl.DlZ + " localId:" + this.qpt.getLocalId() + " isCreatedInFinder:" + localakl.DlX + ", latitude:" + localakl.dpb + ", longitude:" + localakl.dqQ + ", feedLatitude:" + localakl.DlW + ", feedLongitude:" + localakl.DlV + ", originalFlag:" + this.qps.originalFlag);
      paramFinderItem = paramString.atI();
      d.g.b.k.g(paramFinderItem, "builder.buildInstance()");
      this.rr = paramFinderItem;
      AppMethodBeat.o(165258);
    }
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().qy(paramLong);
    Object localObject = new StringBuilder("updateLocalFeed, isExist ");
    boolean bool;
    label137:
    int i;
    if (localFinderItem == null)
    {
      bool = true;
      ad.i("Finder.NetSceneFinderPost", bool);
      if (localFinderItem == null) {
        break label363;
      }
      localFinderItem.setPostFinish();
      a(paramFinderObject);
      localFinderItem.updateFinderObject(paramFinderObject);
      localObject = com.tencent.mm.plugin.finder.storage.data.f.qKv;
      d.g.b.k.h(localFinderItem, "item");
      f.a.b(paramLong, localFinderItem);
      localObject = com.tencent.mm.ui.component.a.LCX;
      Iterator localIterator = ((Iterable)((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bE(PluginFinder.class).get(FinderHomeTabStateVM.class)).ahO(3).Lhe).iterator();
      if (!localIterator.hasNext()) {
        break label357;
      }
      localObject = localIterator.next();
      if ((((BaseFinderFeed)localObject).feedObject.getLocalId() != paramLong) || (paramLong == 0L)) {
        break label351;
      }
      i = 1;
      label181:
      if (i == 0) {
        break label355;
      }
    }
    for (;;)
    {
      localObject = (BaseFinderFeed)localObject;
      if (localObject != null)
      {
        d.g.b.k.h(localFinderItem, "<set-?>");
        ((BaseFinderFeed)localObject).feedObject = localFinderItem;
      }
      localFinderItem.setMediaExtList(new LinkedList());
      bool = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().u(paramLong, false);
      ad.i("Finder.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
      localObject = com.tencent.mm.plugin.finder.storage.data.b.qKl;
      paramLong = paramFinderObject.id;
      d.g.b.k.h(localFinderItem, "finder");
      paramFinderObject = com.tencent.mm.plugin.finder.storage.data.b.cqE();
      d.g.b.k.g(paramFinderObject, "cacheItems");
      paramFinderObject.put(Long.valueOf(paramLong), localFinderItem);
      AppMethodBeat.o(165255);
      return;
      bool = false;
      break;
      label351:
      i = 0;
      break label181;
      label355:
      break label137;
      label357:
      localObject = null;
    }
    label363:
    AppMethodBeat.o(165255);
  }
  
  private final void a(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165256);
    Iterator localIterator = ((Iterable)this.qpt.getMediaExtList()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.fvx();
      }
      Object localObject2 = (bmd)localObject1;
      localObject1 = com.tencent.mm.plugin.finder.upload.e.qQW;
      localObject1 = ((bmd)localObject2).url;
      d.g.b.k.g(localObject1, "localMedia.url");
      com.tencent.mm.plugin.finder.upload.e.ZG((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.upload.e.qQW;
      localObject1 = ((bmd)localObject2).thumbUrl;
      d.g.b.k.g(localObject1, "localMedia.thumbUrl");
      com.tencent.mm.plugin.finder.upload.e.ZG((String)localObject1);
      localObject1 = paramFinderObject.objectDesc.media;
      d.g.b.k.g(localObject1, "svrFeed.objectDesc.media");
      Object localObject3 = ((Iterable)localObject1).iterator();
      label179:
      Object localObject4;
      for (;;)
      {
        if (((Iterator)localObject3).hasNext())
        {
          localObject1 = ((Iterator)localObject3).next();
          if (d.g.b.k.g(((FinderMedia)localObject1).url, ((bmd)localObject2).DJB))
          {
            localObject1 = (FinderMedia)localObject1;
            if (localObject1 == null) {
              break label811;
            }
            ad.v("Finder.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((bmd)localObject2).mediaId + " newMediaID " + ai.du(((FinderMedia)localObject1).url));
            ((bmd)localObject2).mediaId = ai.du(((FinderMedia)localObject1).url);
            if ((((bmd)localObject2).mediaType == 2) || (((bmd)localObject2).mediaType == 7))
            {
              localObject3 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJZ);
              localObject4 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJY);
              ad.i("Finder.NetSceneFinderPost", "cp image files thumbUrl " + ((bmd)localObject2).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.f)localObject3).getPath() + " url " + ((FinderMedia)localObject1).thumbUrl);
              ad.i("Finder.NetSceneFinderPost", "cp image files url " + ((bmd)localObject2).url + " to path " + ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
              i.lC(((bmd)localObject2).thumbUrl, ((com.tencent.mm.plugin.finder.loader.f)localObject3).getPath());
              i.lC(((bmd)localObject2).url, ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath());
            }
            if (((bmd)localObject2).mediaType == 4)
            {
              localObject4 = new com.tencent.mm.plugin.finder.loader.f((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJZ);
              if (!d.nQ(4)) {
                break label806;
              }
            }
          }
        }
      }
      label806:
      for (i = 2;; i = 1)
      {
        localObject3 = new com.tencent.mm.plugin.finder.loader.l((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.KXa, i, null, 8);
        com.tencent.mm.plugin.finder.loader.n localn = new com.tencent.mm.plugin.finder.loader.n((bmd)localObject2, com.tencent.mm.plugin.finder.storage.h.qJY);
        ad.i("Finder.NetSceneFinderPost", "cp video files thumbUrl " + ((bmd)localObject2).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).thumbUrl);
        ad.i("Finder.NetSceneFinderPost", "cp video files url " + ((bmd)localObject2).url + " to path " + ((com.tencent.mm.plugin.finder.loader.l)localObject3).getPath() + "  url " + ((FinderMedia)localObject1).url);
        ad.i("Finder.NetSceneFinderPost", "cp cover files url " + ((bmd)localObject2).url + " to path " + localn.getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
        i.lC(((bmd)localObject2).thumbUrl, ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath());
        i.lC(((bmd)localObject2).url, ((com.tencent.mm.plugin.finder.loader.l)localObject3).getPath());
        i.lC(((bmd)localObject2).coverUrl, localn.getPath());
        long l = i.aMN(((bmd)localObject2).url);
        localObject1 = c.KXF;
        localObject1 = ((com.tencent.mm.plugin.finder.loader.l)localObject3).aaX();
        localObject3 = ((bmd)localObject2).mediaId;
        d.g.b.k.g(localObject3, "localMedia.mediaId");
        localObject4 = ((bmd)localObject2).url;
        d.g.b.k.g(localObject4, "localMedia.url");
        localObject2 = ((bmd)localObject2).url;
        d.g.b.k.g(localObject2, "localMedia.url");
        c.a((String)localObject1, (String)localObject3, (String)localObject4, (String)localObject2, i, com.tencent.mm.plugin.finder.storage.h.KXa.detail, l, l, 3);
        i = j;
        break;
        localObject1 = null;
        break label179;
      }
      label811:
      i = j;
    }
    AppMethodBeat.o(165256);
  }
  
  private final void fSg()
  {
    AppMethodBeat.i(197333);
    Object localObject1 = this.qpt.field_postinfo.LzN.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((ebc)((Iterator)localObject1).next()).Lbz = this.qpt.field_createTime;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.n.LaC;
    Object localObject3 = this.qpt.field_postinfo.LzN;
    d.g.b.k.g(localObject3, "finderItem.field_postinfo.atContactList");
    d.g.b.k.h(localObject3, "atContacts");
    if (!((LinkedList)localObject3).isEmpty())
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.n.fVO();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinkedList();
      }
      localObject2 = new HashMap(((LinkedList)localObject1).size());
      Object localObject4 = ((LinkedList)localObject1).iterator();
      ebc localebc;
      while (((Iterator)localObject4).hasNext())
      {
        localebc = (ebc)((Iterator)localObject4).next();
        ((HashMap)localObject2).put(localebc.username, localebc);
      }
      localObject3 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ebc)((Iterator)localObject3).next();
        localebc = (ebc)((HashMap)localObject2).get(((ebc)localObject4).username);
        if ((localebc == null) || (localebc.Lbz < ((ebc)localObject4).Lbz)) {
          ((HashMap)localObject2).put(((ebc)localObject4).username, localObject4);
        }
      }
      ((LinkedList)localObject1).clear();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map.Entry)localObject3).getKey();
        ((LinkedList)localObject1).add((ebc)((Map.Entry)localObject3).getValue());
      }
      Collections.sort((List)localObject1, (Comparator)n.b.LaF);
      if (((LinkedList)localObject1).size() > 5)
      {
        int i = ((LinkedList)localObject1).size() - 1;
        while (i >= 5)
        {
          ((LinkedList)localObject1).remove(i);
          i -= 1;
        }
      }
      localObject2 = new ebd();
      ((ebd)localObject2).DmI = ((LinkedList)localObject1);
      try
      {
        localObject1 = ((ebd)localObject2).toByteArray();
        if (localObject1 == null)
        {
          AppMethodBeat.o(197333);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = FinderPostAtUI.KYJ;
        ad.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(197333);
        return;
      }
      com.tencent.mm.plugin.finder.utils.n.Km().encode("_finder_at_mmkv_recent_at", localIOException);
    }
    AppMethodBeat.o(197333);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165254);
    this.callback = paramg;
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
    ad.i("Finder.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.qpt.getLocalId(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.deI) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 5L, 1L, false);
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.auM(); paramq == null; paramq = null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(165257);
        throw paramString;
      }
      paramArrayOfByte = ((akm)paramq).Dmb;
      localObject = new StringBuilder("onGYNetEnd ").append(paramArrayOfByte).append(' ');
      if (paramArrayOfByte != null)
      {
        paramq = Long.valueOf(paramArrayOfByte.id);
        ad.i("Finder.NetSceneFinderPost", paramq + ", localId:" + this.deI);
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        if (!com.tencent.mm.plugin.finder.storage.logic.b.a.qF(this.deI)) {
          break label381;
        }
        localObject = this.qps.contact;
        if (paramArrayOfByte != null) {
          break label604;
        }
      }
    }
    label578:
    label580:
    label588:
    label604:
    for (paramq = this.qps;; paramq = paramArrayOfByte)
    {
      this.qps = paramq;
      FinderObject localFinderObject = this.qps;
      paramArrayOfByte = this.qps.nickname;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = ((FinderContact)localObject).nickname;
      }
      localFinderObject.nickname = paramq;
      this.qps.contact = ((FinderContact)localObject);
      a(this.deI, this.qps);
      fSg();
      for (;;)
      {
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.k.fvU();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.al.n)this);
        }
        paramq = com.tencent.mm.plugin.finder.spam.a.qIC;
        com.tencent.mm.plugin.finder.spam.a.y(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(165257);
        return;
        paramq = null;
        break;
        label381:
        if (paramArrayOfByte != null)
        {
          paramq = u.aqO();
          d.g.b.k.g(paramq, "ConfigStorageLogic.getMyFinderUsername()");
          long l = paramArrayOfByte.id;
          paramArrayOfByte = paramArrayOfByte.objectNonceId;
          d.g.b.k.g(paramArrayOfByte, "it.objectNonceId");
          paramq = new m(paramq, l, paramArrayOfByte);
          com.tencent.mm.kernel.g.aeS().b((com.tencent.mm.al.n)paramq);
        }
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 6L, 1L, false);
      paramq = e.c.qFV;
      e.c.cnQ();
      paramq = com.tencent.mm.plugin.finder.spam.a.qIC;
      boolean bool = com.tencent.mm.plugin.finder.spam.a.fy(paramInt2, paramInt3);
      if (paramInt3 == -4013)
      {
        paramInt1 = 1;
        label494:
        if ((paramInt2 != 4) && (bool) && (paramInt1 == 0)) {
          break label578;
        }
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.a.qG(this.deI);
        if (paramq != null)
        {
          if (!bool) {
            break label588;
          }
          if (paramInt1 == 0) {
            break label580;
          }
          paramq.setPostFailedAndNoAuth();
        }
      }
      for (;;)
      {
        this.qpt.field_localFlag = paramq.field_localFlag;
        paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
        com.tencent.mm.plugin.finder.storage.logic.b.a.g(paramq);
        paramq = e.c.qFV;
        e.c.cnI();
        break;
        paramInt1 = 0;
        break label494;
        break;
        paramq.setPostFailed();
        continue;
        paramArrayOfByte = e.c.qFV;
        e.c.cnR();
        paramq.setPostFailedAndNotRetry();
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.x
 * JD-Core Version:    0.7.0.1
 */
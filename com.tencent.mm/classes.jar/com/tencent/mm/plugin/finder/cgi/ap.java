package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.i.c;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.i.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.utils.b.b;
import com.tencent.mm.plugin.finder.utils.m.c;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.amx;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqs;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqu;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aw;
import d.a.j;
import d.o;
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

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/modelbase/NetSceneBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "onGYNetEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class ap
  extends n
  implements com.tencent.mm.network.k
{
  public static final ap.a qYA;
  private com.tencent.mm.ak.g callback;
  public final String clientId;
  private final long dcd;
  public FinderObject qYy;
  private FinderItem qYz;
  private com.tencent.mm.ak.b rr;
  
  static
  {
    AppMethodBeat.i(165259);
    qYA = new ap.a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public ap(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.qYz = paramFinderItem;
    this.clientId = paramString;
    this.dcd = paramLong;
    this.qYy = this.qYz.getFeedObject();
    paramString = new com.tencent.mm.ak.b.a();
    paramString.Am("/cgi-bin/micromsg-bin/finderpost");
    paramString.op(getType());
    amx localamx = new amx();
    localamx.clientId = this.clientId;
    paramFinderItem = (com.tencent.mm.bw.a)new FinderObjectDesc();
    Object localObject1 = this.qYy.objectDesc.toByteArray();
    try
    {
      paramFinderItem.parseFrom((byte[])localObject1);
      if (paramFinderItem == null) {
        d.g.b.k.fOy();
      }
      paramFinderItem = (FinderObjectDesc)paramFinderItem;
      if (this.qYy.refObjectId == 0L)
      {
        localObject1 = paramFinderItem.media;
        d.g.b.k.g(localObject1, "objectDesc.media");
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (FinderMedia)((Iterator)localObject1).next();
          Object localObject3 = this.qYz;
          String str = ah.dg(((FinderMedia)localObject2).url);
          d.g.b.k.g(str, "MD5Util.getMD5String(media.url)");
          localObject3 = ((FinderItem)localObject3).mediaExt(str);
          if (localObject3 != null)
          {
            ((FinderMedia)localObject2).url = ((bqs)localObject3).FfN;
            ((FinderMedia)localObject2).thumbUrl = ((bqs)localObject3).FfO;
            ((FinderMedia)localObject2).md5sum = ((bqs)localObject3).md5sum;
            ((FinderMedia)localObject2).coverUrl = ((bqs)localObject3).FfR;
          }
        }
      }
    }
    catch (Exception paramFinderItem)
    {
      Object localObject2;
      for (;;)
      {
        ac.l("safeParser", "", new Object[] { paramFinderItem });
        paramFinderItem = null;
      }
      if (paramFinderItem.mediaType == 8) {
        paramFinderItem.mediaType = 0;
      }
      localamx.EFX = paramFinderItem;
      localamx.username = u.axE();
      localamx.EFY = this.qYy.refObjectId;
      localamx.refObjectNonceId = this.qYy.refObjectNonceId;
      paramFinderItem = q.qXH;
      localamx.EDL = q.csi();
      paramFinderItem = this.qYz.field_postExtraData;
      if (paramFinderItem != null)
      {
        localamx.dmL = paramFinderItem.dmL;
        localamx.doB = paramFinderItem.doB;
        localamx.EFV = paramFinderItem.EFV;
        localamx.EFU = paramFinderItem.EFU;
        localamx.EFW = paramFinderItem.EFW;
      }
      localamx.EFZ = new LinkedList();
      paramFinderItem = com.tencent.mm.plugin.finder.storage.b.rCU;
      if (com.tencent.mm.plugin.finder.storage.b.czo())
      {
        paramFinderItem = new ArrayList();
        localObject1 = com.tencent.mm.plugin.finder.storage.b.rCU;
        if (com.tencent.mm.plugin.finder.storage.b.czp())
        {
          paramFinderItem = new HashMap();
          if ((this.qYz.field_postinfo != null) && (this.qYz.field_postinfo.Fgb != null))
          {
            localObject1 = this.qYz.field_postinfo.Fgb.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (bqq)((Iterator)localObject1).next();
              paramFinderItem.put(((bqq)localObject2).nickname, localObject2);
            }
          }
          localObject1 = com.tencent.mm.plugin.finder.utils.b.rOw;
          localObject1 = this.qYy.objectDesc.description;
          d.g.b.k.g(localObject1, "feedObject.objectDesc.description");
          paramFinderItem = (ArrayList)com.tencent.mm.plugin.finder.utils.b.a((String)localObject1, paramFinderItem, null).second;
        }
        localObject1 = localamx.EFZ;
        localObject2 = com.tencent.mm.plugin.finder.utils.m.rPH;
        localObject2 = this.qYy.objectDesc.description;
        d.g.b.k.g(localObject2, "feedObject.objectDesc.description");
        localObject2 = (Iterable)com.tencent.mm.plugin.finder.utils.m.a((String)localObject2, paramFinderItem, null);
        paramFinderItem = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
        localObject2 = ((Iterable)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          paramFinderItem.add(((m.c)((Iterator)localObject2).next()).dol);
        }
        ((LinkedList)localObject1).addAll((Collection)paramFinderItem);
      }
      localamx.originalFlag = this.qYy.originalFlag;
      paramString.c((com.tencent.mm.bw.a)localamx);
      paramString.d((com.tencent.mm.bw.a)new amy());
      paramFinderItem = new StringBuilder("post clientId ").append(this.clientId).append(" content: ");
      localObject1 = localamx.EFX;
      d.g.b.k.g(localObject1, "postRequest.content");
      ac.i("Finder.NetSceneFinderPost", com.tencent.mm.ac.f.bD(localObject1) + " refId: " + localamx.EFY + " localId:" + this.qYz.getLocalId() + " isCreatedInFinder:" + localamx.EFW + ", latitude:" + localamx.dmL + ", longitude:" + localamx.doB + ", feedLatitude:" + localamx.EFV + ", feedLongitude:" + localamx.EFU + ", originalFlag:" + this.qYy.originalFlag);
      paramFinderItem = paramString.aAz();
      d.g.b.k.g(paramFinderItem, "builder.buildInstance()");
      this.rr = paramFinderItem;
      AppMethodBeat.o(165258);
    }
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ad(PluginFinder.class)).getFeedStorage().uO(paramLong);
    Object localObject = new StringBuilder("updateLocalFeed, isExist ");
    boolean bool;
    label137:
    int i;
    if (localFinderItem == null)
    {
      bool = true;
      ac.i("Finder.NetSceneFinderPost", bool);
      if (localFinderItem == null) {
        break label363;
      }
      localFinderItem.setPostFinish();
      e(paramFinderObject);
      localFinderItem.updateFinderObject(paramFinderObject);
      localObject = com.tencent.mm.plugin.finder.storage.data.i.rEV;
      d.g.b.k.h(localFinderItem, "item");
      i.a.b(paramLong, localFinderItem);
      localObject = com.tencent.mm.ui.component.a.IrY;
      Iterator localIterator = ((Iterable)((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bg(PluginFinder.class).get(FinderHomeTabStateVM.class)).EU(3).sbU).iterator();
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
      ac.i("Finder.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
      localObject = com.tencent.mm.plugin.finder.storage.data.d.rEF;
      paramLong = paramFinderObject.id;
      d.g.b.k.h(localFinderItem, "finder");
      paramFinderObject = com.tencent.mm.plugin.finder.storage.data.d.cBd();
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
  
  private final void csN()
  {
    AppMethodBeat.i(201211);
    Object localObject1 = this.qYz.field_postinfo.Fgb.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((bqq)((Iterator)localObject1).next()).rQj = this.qYz.field_createTime;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.b.rOw;
    Object localObject3 = this.qYz.field_postinfo.Fgb;
    d.g.b.k.g(localObject3, "finderItem.field_postinfo.atContactList");
    d.g.b.k.h(localObject3, "atContacts");
    if (!((LinkedList)localObject3).isEmpty())
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.b.cCL();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinkedList();
      }
      localObject2 = new HashMap(((LinkedList)localObject1).size());
      Object localObject4 = ((LinkedList)localObject1).iterator();
      bqq localbqq;
      while (((Iterator)localObject4).hasNext())
      {
        localbqq = (bqq)((Iterator)localObject4).next();
        ((HashMap)localObject2).put(localbqq.username, localbqq);
      }
      localObject3 = ((LinkedList)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (bqq)((Iterator)localObject3).next();
        localbqq = (bqq)((HashMap)localObject2).get(((bqq)localObject4).username);
        if ((localbqq == null) || (localbqq.rQj < ((bqq)localObject4).rQj)) {
          ((HashMap)localObject2).put(((bqq)localObject4).username, localObject4);
        }
      }
      ((LinkedList)localObject1).clear();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map.Entry)localObject3).getKey();
        ((LinkedList)localObject1).add((bqq)((Map.Entry)localObject3).getValue());
      }
      Collections.sort((List)localObject1, (Comparator)b.b.rOz);
      if (((LinkedList)localObject1).size() > 5)
      {
        int i = ((LinkedList)localObject1).size() - 1;
        while (i >= 5)
        {
          ((LinkedList)localObject1).remove(i);
          i -= 1;
        }
      }
      localObject2 = new bqu();
      ((bqu)localObject2).EEY = ((LinkedList)localObject1);
      try
      {
        localObject1 = ((bqu)localObject2).toByteArray();
        if (localObject1 == null)
        {
          AppMethodBeat.o(201211);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = FinderPostAtUI.rJx;
        ac.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(201211);
        return;
      }
      com.tencent.mm.plugin.finder.utils.b.JW().encode("_finder_at_mmkv_recent_at", localIOException);
    }
    AppMethodBeat.o(201211);
  }
  
  private final void e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165256);
    Iterator localIterator = ((Iterable)this.qYz.getMediaExtList()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.fOc();
      }
      Object localObject2 = (bqs)localObject1;
      localObject1 = com.tencent.mm.plugin.finder.upload.e.rMX;
      localObject1 = ((bqs)localObject2).url;
      d.g.b.k.g(localObject1, "localMedia.url");
      com.tencent.mm.plugin.finder.upload.e.aes((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.upload.e.rMX;
      localObject1 = ((bqs)localObject2).thumbUrl;
      d.g.b.k.g(localObject1, "localMedia.thumbUrl");
      com.tencent.mm.plugin.finder.upload.e.aes((String)localObject1);
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
          if (d.g.b.k.g(((FinderMedia)localObject1).url, ((bqs)localObject2).FfN))
          {
            localObject1 = (FinderMedia)localObject1;
            if (localObject1 == null) {
              break label811;
            }
            ac.v("Finder.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((bqs)localObject2).mediaId + " newMediaID " + ah.dg(((FinderMedia)localObject1).url));
            ((bqs)localObject2).mediaId = ah.dg(((FinderMedia)localObject1).url);
            if ((((bqs)localObject2).mediaType == 2) || (((bqs)localObject2).mediaType == 7))
            {
              localObject3 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDR);
              localObject4 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDQ);
              ac.i("Finder.NetSceneFinderPost", "cp image files thumbUrl " + ((bqs)localObject2).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.f)localObject3).getPath() + " url " + ((FinderMedia)localObject1).thumbUrl);
              ac.i("Finder.NetSceneFinderPost", "cp image files url " + ((bqs)localObject2).url + " to path " + ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
              com.tencent.mm.vfs.i.lZ(((bqs)localObject2).thumbUrl, ((com.tencent.mm.plugin.finder.loader.f)localObject3).getPath());
              com.tencent.mm.vfs.i.lZ(((bqs)localObject2).url, ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath());
            }
            if (((bqs)localObject2).mediaType == 4)
            {
              localObject4 = new com.tencent.mm.plugin.finder.loader.f((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDR);
              if (!com.tencent.mm.modelcontrol.d.oE(4)) {
                break label806;
              }
            }
          }
        }
      }
      label806:
      for (i = 2;; i = 1)
      {
        localObject3 = new com.tencent.mm.plugin.finder.loader.l((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rEd, i, null, 8);
        com.tencent.mm.plugin.finder.loader.m localm = new com.tencent.mm.plugin.finder.loader.m((bqs)localObject2, com.tencent.mm.plugin.finder.storage.m.rDQ);
        ac.i("Finder.NetSceneFinderPost", "cp video files thumbUrl " + ((bqs)localObject2).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).thumbUrl);
        ac.i("Finder.NetSceneFinderPost", "cp video files url " + ((bqs)localObject2).url + " to path " + ((com.tencent.mm.plugin.finder.loader.l)localObject3).getPath() + "  url " + ((FinderMedia)localObject1).url);
        ac.i("Finder.NetSceneFinderPost", "cp cover files url " + ((bqs)localObject2).url + " to path " + localm.getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
        com.tencent.mm.vfs.i.lZ(((bqs)localObject2).thumbUrl, ((com.tencent.mm.plugin.finder.loader.f)localObject4).getPath());
        com.tencent.mm.vfs.i.lZ(((bqs)localObject2).url, ((com.tencent.mm.plugin.finder.loader.l)localObject3).getPath());
        com.tencent.mm.vfs.i.lZ(((bqs)localObject2).coverUrl, localm.getPath());
        long l = com.tencent.mm.vfs.i.aSp(((bqs)localObject2).url);
        localObject1 = c.rFo;
        localObject1 = ((com.tencent.mm.plugin.finder.loader.l)localObject3).abW();
        localObject3 = ((bqs)localObject2).mediaId;
        d.g.b.k.g(localObject3, "localMedia.mediaId");
        localObject4 = ((bqs)localObject2).url;
        d.g.b.k.g(localObject4, "localMedia.url");
        localObject2 = ((bqs)localObject2).url;
        d.g.b.k.g(localObject2, "localMedia.url");
        c.a((String)localObject1, (String)localObject3, (String)localObject4, (String)localObject2, i, com.tencent.mm.plugin.finder.storage.m.rEd.detail, l, l, 3);
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
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
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
    ac.i("Finder.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.qYz.getLocalId(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.dcd) });
    Object localObject;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 5L, 1L, false);
      paramq = this.rr;
      if (paramq != null) {}
      for (paramq = paramq.aBD(); paramq == null; paramq = null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(165257);
        throw paramString;
      }
      paramArrayOfByte = ((amy)paramq).EGa;
      localObject = new StringBuilder("onGYNetEnd ").append(paramArrayOfByte).append(' ');
      if (paramArrayOfByte != null)
      {
        paramq = Long.valueOf(paramArrayOfByte.id);
        ac.i("Finder.NetSceneFinderPost", paramq + ", localId:" + this.dcd);
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        if (!com.tencent.mm.plugin.finder.storage.logic.b.a.vd(this.dcd)) {
          break label381;
        }
        localObject = this.qYy.contact;
        if (paramArrayOfByte != null) {
          break label604;
        }
      }
    }
    label578:
    label580:
    label588:
    label604:
    for (paramq = this.qYy;; paramq = paramArrayOfByte)
    {
      this.qYy = paramq;
      FinderObject localFinderObject = this.qYy;
      paramArrayOfByte = this.qYy.nickname;
      paramq = paramArrayOfByte;
      if (paramArrayOfByte == null) {
        paramq = ((FinderContact)localObject).nickname;
      }
      localFinderObject.nickname = paramq;
      this.qYy.contact = ((FinderContact)localObject);
      a(this.dcd, this.qYy);
      csN();
      for (;;)
      {
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.k.fOy();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        }
        paramq = com.tencent.mm.plugin.finder.spam.a.rBD;
        com.tencent.mm.plugin.finder.spam.a.x(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(165257);
        return;
        paramq = null;
        break;
        label381:
        if (paramArrayOfByte != null)
        {
          paramq = u.axE();
          d.g.b.k.g(paramq, "ConfigStorageLogic.getMyFinderUsername()");
          long l = paramArrayOfByte.id;
          paramArrayOfByte = paramArrayOfByte.objectNonceId;
          d.g.b.k.g(paramArrayOfByte, "it.objectNonceId");
          paramq = new v(paramq, l, paramArrayOfByte);
          com.tencent.mm.kernel.g.agi().b((n)paramq);
        }
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 6L, 1L, false);
      paramq = i.c.ryP;
      i.c.cxm();
      paramq = com.tencent.mm.plugin.finder.spam.a.rBD;
      boolean bool = com.tencent.mm.plugin.finder.spam.a.fC(paramInt2, paramInt3);
      if (paramInt3 == -4013)
      {
        paramInt1 = 1;
        label494:
        if ((paramInt2 != 4) && (bool) && (paramInt1 == 0)) {
          break label578;
        }
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        paramq = com.tencent.mm.plugin.finder.storage.logic.b.a.ve(this.dcd);
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
        this.qYz.field_localFlag = paramq.field_localFlag;
        paramArrayOfByte = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
        com.tencent.mm.plugin.finder.storage.logic.b.a.h(paramq);
        paramq = i.c.ryP;
        i.c.cxe();
        break;
        paramInt1 = 0;
        break label494;
        break;
        paramq.setPostFailed();
        continue;
        paramArrayOfByte = i.c.ryP;
        i.c.cxn();
        paramq.setPostFailedAndNotRetry();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ap
 * JD-Core Version:    0.7.0.1
 */
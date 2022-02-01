package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.an;
import com.tencent.mm.plugin.finder.model.cc;
import com.tencent.mm.plugin.finder.report.ah.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.upload.action.l;
import com.tencent.mm.plugin.finder.upload.o;
import com.tencent.mm.plugin.finder.utils.as;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.utils.bo;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker;
import com.tencent.mm.plugin.recordvideo.util.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.atq;
import com.tencent.mm.protocal.protobuf.atr;
import com.tencent.mm.protocal.protobuf.auq;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqz;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.bsw;
import com.tencent.mm.protocal.protobuf.bsx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byx;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.protocal.protobuf.gdd;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.vfs.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "postRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "getPostRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "setPostRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildAttachmentList", "Lcom/tencent/mm/protocal/protobuf/FinderAttachmentList;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dg
  extends com.tencent.mm.plugin.findersdk.b.h
{
  public static final a ADa;
  private FinderItem ABU;
  public bsw ADb;
  private com.tencent.mm.am.h callback;
  public final String clientId;
  public FinderObject feedObject;
  private final long localId;
  private c rr;
  
  static
  {
    AppMethodBeat.i(165259);
    ADa = new a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public dg(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.ABU = paramFinderItem;
    this.clientId = paramString;
    this.localId = paramLong;
    this.feedObject = this.ABU.getFeedObject();
    c.a locala = new c.a();
    locala.uri = "/cgi-bin/micromsg-bin/finderpost";
    locala.funcId = getType();
    this.ADb = new bsw();
    this.ADb.clientId = this.clientId;
    Object localObject1 = this.ADb;
    paramString = (com.tencent.mm.bx.a)new FinderObjectDesc();
    paramFinderItem = this.feedObject.objectDesc;
    if (paramFinderItem == null) {
      paramFinderItem = null;
    }
    int i;
    for (;;)
    {
      try
      {
        paramString.parseFrom(paramFinderItem);
        paramFinderItem = paramString;
      }
      catch (Exception paramFinderItem)
      {
        FinderMedia localFinderMedia;
        dji localdji;
        MultiMediaVideoChecker localMultiMediaVideoChecker;
        Log.printDebugStack("safeParser", "", new Object[] { paramFinderItem });
        paramFinderItem = null;
        continue;
        i = (int)paramFinderItem.duration;
        continue;
        if (((FinderObjectDesc)localObject2).mediaType != 8) {
          continue;
        }
        ((FinderObjectDesc)localObject2).mediaType = 0;
        ((bsw)localObject1).aaay = ((FinderObjectDesc)localObject2);
        this.ADb.attachmentList = dWr();
        this.ADb.username = z.bAW();
        this.ADb.aaaz = this.feedObject.refObjectId;
        this.ADb.refObjectNonceId = this.feedObject.refObjectNonceId;
        paramFinderItem = this.ADb;
        paramString = this.feedObject.objectDesc;
        if (paramString != null) {
          continue;
        }
        paramLong = 0L;
        paramFinderItem.ocD = paramLong;
        paramFinderItem = this.ADb;
        paramString = bi.ABn;
        paramFinderItem.CJv = bi.dVu();
        paramFinderItem = this.ABU.field_postExtraData;
        if (paramFinderItem == null) {
          continue;
        }
        this.ADb.latitude = paramFinderItem.latitude;
        this.ADb.longitude = paramFinderItem.longitude;
        this.ADb.aaat = paramFinderItem.aaat;
        this.ADb.aaas = paramFinderItem.aaas;
        this.ADb.aaau = paramFinderItem.aaau;
        paramFinderItem = ah.aiuX;
        paramFinderItem = ah.aiuX;
        this.ADb.topics = new LinkedList();
        paramFinderItem = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!com.tencent.mm.plugin.finder.storage.d.eRs()) {
          continue;
        }
        paramString = new ArrayList();
        paramFinderItem = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!com.tencent.mm.plugin.finder.storage.d.eRt()) {
          continue;
        }
        localObject1 = new HashMap();
        if ((this.ABU.field_postinfo == null) || (this.ABU.field_postinfo.aaPA == null)) {
          continue;
        }
        Object localObject2 = this.ABU.field_postinfo.aaPA.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        Object localObject3 = (djg)((Iterator)localObject2).next();
        paramString = ((djg)localObject3).nickname;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        ((HashMap)localObject1).put(paramFinderItem, localObject3);
        paramFinderItem = ah.aiuX;
        continue;
        paramString = paramString.event;
        if (paramString != null) {
          continue;
        }
        paramLong = 0L;
        continue;
        paramLong = paramString.ocD;
        continue;
        paramFinderItem = com.tencent.mm.plugin.finder.utils.h.Gga;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem != null) {
          continue;
        }
        paramFinderItem = "";
        paramString = com.tencent.mm.plugin.finder.utils.h.a(paramFinderItem, (HashMap)localObject1, null).bsD;
        paramFinderItem = ah.aiuX;
        localObject2 = this.ADb.topics;
        paramFinderItem = as.GiG;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem != null) {
          continue;
        }
        paramFinderItem = "";
        paramString = (Iterable)as.a(paramFinderItem, (ArrayList)paramString, null);
        paramFinderItem = (Collection)new ArrayList(kotlin.a.p.a(paramString, 10));
        paramString = paramString.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        paramFinderItem.add(((bo)paramString.next()).topic);
        continue;
        paramString = paramFinderItem.description;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        continue;
        localObject1 = paramFinderItem.description;
        paramFinderItem = (FinderItem)localObject1;
        if (localObject1 != null) {
          continue;
        }
        paramFinderItem = "";
        continue;
        ((LinkedList)localObject2).addAll((Collection)paramFinderItem);
        this.ADb.originalFlag = this.feedObject.originalFlag;
        paramFinderItem = new LinkedList();
        paramString = this.feedObject.objectDesc;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.mentionedMusics;
        if (paramString == null) {
          continue;
        }
        paramString = ((Iterable)paramString).iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        localObject1 = ((bpi)paramString.next()).musicInfo;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((bqj)localObject1).HsD;
        if (localObject1 == null) {
          continue;
        }
        paramFinderItem.add(localObject1);
        localObject1 = ah.aiuX;
        localObject1 = ah.aiuX;
        continue;
        paramString = ah.aiuX;
        this.ADb.aaaB = paramFinderItem;
        paramString = this.ADb;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          break;
        }
      }
      kotlin.g.b.s.checkNotNull(paramFinderItem);
      localObject2 = (FinderObjectDesc)paramFinderItem;
      if (this.feedObject.refObjectId == 0L)
      {
        paramFinderItem = ((FinderObjectDesc)localObject2).media;
        kotlin.g.b.s.s(paramFinderItem, "objectDesc.media");
        localObject3 = ((Iterable)paramFinderItem).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localFinderMedia = (FinderMedia)((Iterator)localObject3).next();
          paramFinderItem = this.ABU;
          paramString = MD5Util.getMD5String(localFinderMedia.url);
          kotlin.g.b.s.s(paramString, "getMD5String(media.url)");
          localdji = paramFinderItem.mediaExt(paramString);
          if (localdji == null) {
            continue;
          }
          paramFinderItem = o.Gco;
          kotlin.g.b.s.s(localFinderMedia, "media");
          o.a(localFinderMedia, localdji, this.ABU.getHalfVideoMediaExtList());
          if ((localFinderMedia.mediaType != 4) || ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000))) {
            continue;
          }
          localMultiMediaVideoChecker = MultiMediaVideoChecker.ObB;
          paramString = localdji.url;
          paramFinderItem = paramString;
          if (paramString == null) {
            paramFinderItem = "";
          }
          paramFinderItem = localMultiMediaVideoChecker.aTG(paramFinderItem);
          if (paramFinderItem == null)
          {
            i = 0;
            localFinderMedia.videoDuration = (i / 1000);
            if ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)) {
              continue;
            }
            Log.e("Finder.LogPost.NetSceneFinderPost", kotlin.g.b.s.X("NetSceneFinderPost videoDuration invalid:", Integer.valueOf(localdji.videoDuration)));
            if (!BuildInfo.DEBUG) {
              continue;
            }
            paramFinderItem = new RuntimeException(kotlin.g.b.s.X("NetSceneFinderPost videoDuration invalid:", Integer.valueOf(localdji.videoDuration)));
            AppMethodBeat.o(165258);
            throw paramFinderItem;
            paramFinderItem = paramFinderItem.toByteArray();
            continue;
          }
        }
      }
      paramFinderItem = paramFinderItem.feedBgmInfo;
      if (paramFinderItem != null)
      {
        paramFinderItem = paramFinderItem.musicInfo;
        if (paramFinderItem != null)
        {
          paramFinderItem = paramFinderItem.ZYp;
          if ((paramFinderItem != null) && (kotlin.n.n.U(paramFinderItem, "http", true) == true))
          {
            i = 1;
            if (i == 0) {
              break label1908;
            }
            paramFinderItem = this.feedObject.objectDesc;
            if (paramFinderItem == null) {
              break label1908;
            }
            paramFinderItem = paramFinderItem.feedBgmInfo;
            if (paramFinderItem == null) {
              break label1908;
            }
            paramFinderItem = paramFinderItem.musicInfo;
            if (paramFinderItem == null) {
              break label1908;
            }
            paramFinderItem = paramFinderItem.ZYp;
            if (paramFinderItem == null) {
              break label1908;
            }
            label1200:
            paramString.aaaD = paramFinderItem;
            paramString = this.ADb;
            paramFinderItem = this.feedObject.objectDesc;
            if (paramFinderItem != null) {
              break label1914;
            }
            paramFinderItem = null;
            label1224:
            paramString.groupId = paramFinderItem;
            paramString = this.ADb;
            paramFinderItem = this.feedObject.objectDesc;
            if (paramFinderItem != null) {
              break label1936;
            }
            paramFinderItem = null;
            label1248:
            if (paramFinderItem != null)
            {
              paramFinderItem = this.feedObject.objectDesc;
              if (paramFinderItem != null) {
                break label1958;
              }
              paramFinderItem = null;
              label1266:
              paramFinderItem = (CharSequence)paramFinderItem;
              if ((paramFinderItem != null) && (paramFinderItem.length() != 0)) {
                break label1994;
              }
              i = 1;
              if (i == 0) {
                break label2000;
              }
            }
            label1287:
            i = 1;
            label1295:
            paramString.aaaE = i;
            this.ADb.aaao = this.ABU.getFeedObject().objectType;
            Log.i("Finder.LogPost.NetSceneFinderPost", "bgmInfo: groupBgmUrl:" + this.ADb.aaaD + ",groupId:" + this.ADb.groupId + ",groupPostType:" + this.ADb.aaaE);
            paramFinderItem = this.ABU.getFeedObject().objectDesc;
            if (paramFinderItem != null)
            {
              paramFinderItem = paramFinderItem.client_draft_ext_info;
              if (paramFinderItem != null)
              {
                this.ADb.EUp = paramFinderItem.ZEX;
                paramFinderItem = ah.aiuX;
                paramFinderItem = ah.aiuX;
              }
            }
            if (this.ADb.EUp == 0) {
              this.ADb.EUp = this.ABU.getPostInfo().EUp;
            }
            paramString = new StringBuilder("waitType ");
            paramFinderItem = this.ABU.getFeedObject().objectDesc;
            if (paramFinderItem != null) {
              break label2006;
            }
            paramFinderItem = null;
            label1476:
            Log.i("Finder.LogPost.NetSceneFinderPost", paramFinderItem + ", " + this.ABU.getPostInfo().EUp + ", " + this.ADb.EUp);
            paramFinderItem = this.feedObject.attachmentList;
            if (paramFinderItem != null) {
              break label2031;
            }
            paramFinderItem = null;
            label1538:
            if (paramFinderItem != null) {
              this.ADb.aaar = 1;
            }
            paramFinderItem = new gdd();
            paramFinderItem.acaW = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.aQo("ce_feed_publish"));
            paramFinderItem.acaX = new gol().df(com.tencent.mm.plugin.normsg.a.d.MtP.gtE());
            paramString = this.ADb.CJv;
            if (paramString != null) {
              paramString.ZEq = new com.tencent.mm.bx.b(paramFinderItem.toByteArray());
            }
            paramFinderItem = com.tencent.mm.plugin.secinforeport.a.d.Pmb;
            com.tencent.mm.plugin.secinforeport.a.d.asyncReportFinderSecurityInfoThroughCgi(540999699);
            locala.otE = ((com.tencent.mm.bx.a)this.ADb);
            locala.otF = ((com.tencent.mm.bx.a)new bsx());
            paramString = new StringBuilder("post clientId ").append(this.clientId).append(" draftId:");
            paramFinderItem = this.ADb.aaay;
            if (paramFinderItem != null) {
              break label2109;
            }
          }
        }
      }
    }
    label1936:
    label1958:
    label2102:
    label2109:
    for (paramFinderItem = null;; paramFinderItem = Long.valueOf(paramFinderItem.draftObjectId))
    {
      localObject1 = paramString.append(paramFinderItem).append(", content: ");
      paramString = this.ADb.aaay;
      paramFinderItem = paramString;
      if (paramString == null) {
        paramFinderItem = "";
      }
      Log.i("Finder.LogPost.NetSceneFinderPost", com.tencent.mm.ae.f.dg(paramFinderItem) + " refId: " + this.ADb.aaaz + " localId:" + this.ABU.getLocalId() + " isCreatedInFinder:" + this.ADb.aaau + ", latitude:" + this.ADb.latitude + ", longitude:" + this.ADb.longitude + ", feedLatitude:" + this.ADb.aaat + ", feedLongitude:" + this.ADb.aaas + ", originalFlag:" + this.feedObject.originalFlag);
      paramFinderItem = locala.bEF();
      kotlin.g.b.s.s(paramFinderItem, "builder.buildInstance()");
      this.rr = paramFinderItem;
      AppMethodBeat.o(165258);
      return;
      i = 0;
      break;
      label1908:
      paramFinderItem = "";
      break label1200;
      label1914:
      paramFinderItem = paramFinderItem.feedBgmInfo;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label1224;
      }
      paramFinderItem = paramFinderItem.groupId;
      break label1224;
      paramFinderItem = paramFinderItem.feedBgmInfo;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label1248;
      }
      paramFinderItem = paramFinderItem.musicInfo;
      break label1248;
      paramFinderItem = paramFinderItem.feedBgmInfo;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label1266;
      }
      paramFinderItem = paramFinderItem.musicInfo;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label1266;
      }
      paramFinderItem = paramFinderItem.HsD;
      break label1266;
      label1994:
      i = 0;
      break label1287;
      label2000:
      i = 2;
      break label1295;
      label2006:
      paramFinderItem = paramFinderItem.client_draft_ext_info;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label1476;
      }
      paramFinderItem = Integer.valueOf(paramFinderItem.ZEX);
      break label1476;
      label2031:
      paramFinderItem = paramFinderItem.ZEi;
      if (paramFinderItem == null)
      {
        paramFinderItem = null;
        break label1538;
      }
      paramString = ((Iterable)paramFinderItem).iterator();
      if (paramString.hasNext())
      {
        paramFinderItem = paramString.next();
        if (((atq)paramFinderItem).type == 1)
        {
          i = 1;
          if (i == 0) {
            break label2102;
          }
        }
      }
      for (;;)
      {
        paramFinderItem = (atq)paramFinderItem;
        break;
        i = 0;
        break label2085;
        break label2055;
        paramFinderItem = null;
      }
    }
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFeedStorage().qc(paramLong);
    boolean bool;
    int i;
    label78:
    Object localObject3;
    label245:
    Object localObject4;
    if (localFinderItem == null)
    {
      bool = true;
      Log.i("Finder.LogPost.NetSceneFinderPost", kotlin.g.b.s.X("updateLocalFeed, isExist ", Boolean.valueOf(bool)));
      if (localFinderItem == null) {
        break label1259;
      }
      localFinderItem.setPostFinish();
      Iterator localIterator = ((Iterable)this.ABU.getMediaExtList()).iterator();
      i = 0;
      if (!localIterator.hasNext()) {
        break label990;
      }
      localObject1 = localIterator.next();
      if (i < 0) {
        kotlin.a.p.kkW();
      }
      localObject3 = (dji)localObject1;
      localObject1 = com.tencent.mm.plugin.finder.upload.f.GbE;
      localObject2 = ((dji)localObject3).url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.upload.f.aBk((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.upload.f.GbE;
      localObject2 = ((dji)localObject3).thumbUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.upload.f.aBk((String)localObject1);
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
              if (kotlin.g.b.s.p(((FinderMedia)localObject1).url, ((dji)localObject3).aaPd))
              {
                localObject1 = (FinderMedia)localObject1;
                if (localObject1 != null)
                {
                  Log.v("Finder.LogPost.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((dji)localObject3).mediaId + " newMediaID " + MD5Util.getMD5String(((FinderMedia)localObject1).url));
                  ((dji)localObject3).mediaId = MD5Util.getMD5String(((FinderMedia)localObject1).url);
                  if ((((dji)localObject3).mediaType == 2) || (((dji)localObject3).mediaType == 7))
                  {
                    localObject2 = new com.tencent.mm.plugin.finder.loader.n((dji)localObject3, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
                    localObject4 = new com.tencent.mm.plugin.finder.loader.n((dji)localObject3, com.tencent.mm.plugin.finder.storage.v.FKY, null, null, 12);
                    Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files thumbUrl " + ((dji)localObject3).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.n)localObject2).getPath() + " url " + ((FinderMedia)localObject1).thumbUrl);
                    Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files url " + ((dji)localObject3).url + " to path " + ((com.tencent.mm.plugin.finder.loader.n)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
                    y.O(((dji)localObject3).thumbUrl, ((com.tencent.mm.plugin.finder.loader.n)localObject2).getPath(), false);
                    y.O(((dji)localObject3).url, ((com.tencent.mm.plugin.finder.loader.n)localObject4).getPath(), false);
                  }
                  if (((dji)localObject3).mediaType == 4)
                  {
                    localObject2 = new com.tencent.mm.plugin.finder.loader.n((dji)localObject3, com.tencent.mm.plugin.finder.storage.v.FKZ, null, null, 12);
                    if (!com.tencent.mm.modelcontrol.e.wb(4)) {
                      break label984;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label984:
    for (int j = 2;; j = 1)
    {
      localObject4 = new com.tencent.mm.plugin.finder.loader.v((dji)localObject3, com.tencent.mm.plugin.finder.storage.v.FLB, j, null, 8);
      Object localObject5 = new t((dji)localObject3, com.tencent.mm.plugin.finder.storage.v.FKY);
      com.tencent.mm.plugin.finder.loader.k localk = new com.tencent.mm.plugin.finder.loader.k((dji)localObject3, com.tencent.mm.plugin.finder.storage.v.FKZ);
      Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files thumbUrl " + ((dji)localObject3).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.n)localObject2).getPath() + "  url " + ((FinderMedia)localObject1).thumbUrl);
      Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files url " + ((dji)localObject3).url + " to path " + ((com.tencent.mm.plugin.finder.loader.v)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
      Log.i("Finder.LogPost.NetSceneFinderPost", "cp cover files url " + ((dji)localObject3).coverUrl + " to path " + ((t)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
      Log.i("Finder.LogPost.NetSceneFinderPost", "cp fullThumb files url " + ((dji)localObject3).aaPi + " to path " + ((t)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
      y.O(((dji)localObject3).thumbUrl, ((com.tencent.mm.plugin.finder.loader.n)localObject2).getPath(), false);
      y.O(((dji)localObject3).url, ((com.tencent.mm.plugin.finder.loader.v)localObject4).getPath(), false);
      y.O(((dji)localObject3).coverUrl, ((t)localObject5).getPath(), false);
      y.O(((dji)localObject3).aaPi, localk.getPath(), false);
      long l = y.bEl(((dji)localObject3).url);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.FNF;
      localObject5 = ((com.tencent.mm.plugin.finder.loader.v)localObject4).aUt();
      localObject2 = ((dji)localObject3).mediaId;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject3 = ((dji)localObject3).url;
      localObject2 = localObject3;
      if (localObject3 == null) {
        localObject2 = "";
      }
      com.tencent.mm.plugin.finder.storage.logic.e.a((String)localObject5, (String)localObject1, (String)localObject2, j, com.tencent.mm.plugin.finder.storage.v.FLB.detail, l, l, 3, ((com.tencent.mm.plugin.finder.loader.v)localObject4).ExE.videoDuration, "", "");
      i += 1;
      break label78;
      bool = false;
      break;
      localObject1 = null;
      break label245;
    }
    label990:
    localFinderItem.updateFinderObject(paramFinderObject);
    Object localObject1 = com.tencent.mm.plugin.finder.storage.data.k.FNg;
    kotlin.g.b.s.u(localFinderItem, "item");
    k.a.d(paramLong, localFinderItem);
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    Object localObject2 = ((Iterable)((com.tencent.mm.plugin.finder.viewmodel.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.d.class)).UV(3).GKv).iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      localObject3 = (cc)localObject1;
      if (((localObject3 instanceof BaseFinderFeed)) && (((BaseFinderFeed)localObject3).feedObject.getLocalId() == paramLong) && (paramLong != 0L))
      {
        i = 1;
        label1111:
        if (i == 0) {
          break label1270;
        }
      }
    }
    for (;;)
    {
      localObject1 = (cc)localObject1;
      if (localObject1 != null)
      {
        localObject1 = (BaseFinderFeed)localObject1;
        kotlin.g.b.s.u(localFinderItem, "<set-?>");
        ((BaseFinderFeed)localObject1).feedObject = localFinderItem;
      }
      localFinderItem.setMediaExtList(new LinkedList());
      localFinderItem.setLongVideoMediaExtList(new LinkedList());
      bool = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getFeedStorage().I(paramLong, false);
      Log.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
      localObject1 = com.tencent.mm.plugin.finder.storage.data.e.FMN;
      e.a.b(paramFinderObject.id, localFinderItem);
      label1259:
      AppMethodBeat.o(165255);
      return;
      i = 0;
      break label1111;
      label1270:
      break;
      localObject1 = null;
    }
  }
  
  private final atr dWr()
  {
    AppMethodBeat.i(336606);
    Object localObject1 = this.feedObject.attachmentList;
    if (localObject1 != null)
    {
      localObject1 = ((atr)localObject1).ZEi;
      if (localObject1 != null)
      {
        Object localObject2 = ((Iterable)localObject1).iterator();
        Object localObject4;
        do
        {
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = ((Iterator)localObject2).next();
          localObject3 = (atq)localObject1;
          localObject4 = av.GiL;
          kotlin.g.b.s.s(localObject3, "it");
        } while (!av.a((atq)localObject3));
        for (;;)
        {
          localObject1 = (atq)localObject1;
          if (localObject1 == null) {
            break label267;
          }
          localObject1 = ((atq)localObject1).ZEf;
          if (localObject1 == null) {
            break label267;
          }
          localObject1 = ((byx)localObject1).ZXx;
          if (localObject1 == null) {
            break label267;
          }
          localObject1 = ((dne)localObject1).aaUt;
          if (localObject1 == null) {
            break label267;
          }
          localObject2 = new LinkedList();
          localObject4 = (Iterable)this.ABU.getLongVideoMediaExtList();
          localObject3 = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject4, 10));
          localObject4 = ((Iterable)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            dji localdji = (dji)((Iterator)localObject4).next();
            dnv localdnv = com.tencent.mm.plugin.finder.storage.data.n.c(localdji);
            localdnv.url = localdji.aaPd;
            localdnv.thumbUrl = localdji.aaPe;
            localdnv.md5sum = localdji.md5sum;
            localdnv.coverUrl = localdji.aaPg;
            ((Collection)localObject3).add(localdnv);
          }
          localObject1 = null;
        }
        ((LinkedList)localObject2).addAll((Collection)localObject3);
        Object localObject3 = ah.aiuX;
        ((dnh)localObject1).media = ((LinkedList)localObject2);
      }
    }
    label267:
    localObject1 = this.feedObject.attachmentList;
    AppMethodBeat.o(336606);
    return localObject1;
  }
  
  private final void dWs()
  {
    AppMethodBeat.i(336623);
    Object localObject = this.ABU.field_postinfo.aaPA.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((djg)((Iterator)localObject).next()).GlB = this.ABU.field_createTime;
    }
    localObject = com.tencent.mm.plugin.finder.utils.h.Gga;
    localObject = this.ABU.field_postinfo.aaPA;
    kotlin.g.b.s.s(localObject, "finderItem.field_postinfo.atContactList");
    com.tencent.mm.plugin.finder.utils.h.bh((LinkedList)localObject);
    AppMethodBeat.o(336623);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336652);
    Log.i("Finder.LogPost.NetSceneFinderPost", kotlin.g.b.s.X("errType %d, errCode %d, errMsg %s, localId %s localId:", Long.valueOf(this.ABU.getLocalId())), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.localId) });
    Object localObject1;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 5L, 1L, false);
      params = this.rr;
      if (params == null) {}
      for (params = null; params == null; params = c.c.b(params.otC))
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(336652);
        throw paramString;
      }
      localObject1 = ((bsx)params).aaaF;
      Object localObject2 = new StringBuilder("onGYNetEnd ").append(localObject1).append(' ');
      if (localObject1 == null)
      {
        params = null;
        Log.i("Finder.LogPost.NetSceneFinderPost", params + ", localId:" + this.localId);
        params = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        if (!com.tencent.mm.plugin.finder.storage.logic.d.a.pX(this.localId)) {
          break label738;
        }
        localObject2 = this.feedObject.contact;
        if (localObject1 != null) {
          break label698;
        }
        params = this.feedObject;
        label238:
        this.feedObject = params;
        FinderObject localFinderObject = this.feedObject;
        localObject1 = this.feedObject.nickname;
        params = (com.tencent.mm.network.s)localObject1;
        if (localObject1 == null)
        {
          if (localObject2 != null) {
            break label705;
          }
          params = "";
        }
        label277:
        localFinderObject.nickname = params;
        this.feedObject.contact = ((FinderContact)localObject2);
        a(this.localId, this.feedObject);
        dWs();
        params = com.tencent.mm.plugin.finder.storage.data.e.FMN;
        params = e.a.jn(this.feedObject.id);
        if (params != null)
        {
          localObject1 = l.Gdj;
          localObject1 = l.fek();
          long l = this.localId;
          boolean bool2 = ((l)localObject1).Gar.containsKey(Long.valueOf(l));
          localObject1 = (com.tencent.mm.plugin.finder.storage.s)((l)localObject1).Gar.get(Long.valueOf(l));
          if (localObject1 != null) {
            break label728;
          }
          bool1 = false;
          label388:
          Log.i(l.TAG, "isLocalFeedLike " + l + ", " + bool2);
          localObject1 = new r(Boolean.valueOf(bool2), Boolean.valueOf(bool1));
          bool2 = ((Boolean)((r)localObject1).bsC).booleanValue();
          bool1 = ((Boolean)((r)localObject1).bsD).booleanValue();
          if (bool2)
          {
            localObject1 = l.Gdj;
            localObject1 = l.fek();
            l = this.localId;
            kotlin.g.b.s.u(params, "feed");
            Log.i(l.TAG, "doLikeLocalFeed localId:" + l + ", isPrivate:" + bool1 + ", feedid:" + params.getId());
            localObject1 = (com.tencent.mm.plugin.finder.storage.s)((l)localObject1).Gar.get(Long.valueOf(l));
            if (localObject1 != null)
            {
              localObject2 = an.ECX;
              localObject2 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_contextObj;
              kotlin.g.b.s.s(localObject2, "action.field_contextObj");
              paramInt1 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_likeAction;
              int i = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_scene;
              bool2 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_showTips;
              localObject1 = aw.Gjk;
              an.a((bui)localObject2, paramInt1, params, true, bool1, i, bool2, false, aw.eKm());
            }
          }
        }
      }
      for (;;)
      {
        if (this.callback != null)
        {
          params = this.callback;
          kotlin.g.b.s.checkNotNull(params);
          params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
        }
        params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
        com.tencent.mm.plugin.findersdk.d.a.B(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(336652);
        return;
        params = Long.valueOf(((FinderObject)localObject1).id);
        break;
        label698:
        params = (com.tencent.mm.network.s)localObject1;
        break label238;
        label705:
        localObject1 = ((FinderContact)localObject2).nickname;
        params = (com.tencent.mm.network.s)localObject1;
        if (localObject1 != null) {
          break label277;
        }
        params = "";
        break label277;
        label728:
        bool1 = ((com.tencent.mm.plugin.finder.storage.s)localObject1).field_isPrivate;
        break label388;
        label738:
        if (localObject1 != null)
        {
          params = z.bAW();
          kotlin.g.b.s.s(params, "getMyFinderUsername()");
          params = new bt(params, (FinderObject)localObject1);
          com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)params, 0);
        }
      }
    }
    com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 6L, 1L, false);
    params = ah.d.Ftw;
    ah.d.tJ(this.ABU.isLongVideo());
    params = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    boolean bool1 = com.tencent.mm.plugin.findersdk.d.a.iO(paramInt2, paramInt3);
    if (paramInt3 == -4013)
    {
      paramInt1 = 1;
      label835:
      if ((paramInt2 != 4) && (bool1) && (paramInt1 == 0)) {
        break label926;
      }
      params = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      params = com.tencent.mm.plugin.finder.storage.logic.d.a.qr(this.localId);
      if (params != null)
      {
        if (!bool1) {
          break label936;
        }
        if (paramInt1 == 0) {
          break label928;
        }
        params.setPostFailedAndNoAuth();
      }
    }
    for (;;)
    {
      this.ABU.field_localFlag = params.field_localFlag;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      com.tencent.mm.plugin.finder.storage.logic.d.a.v(params);
      params = ah.d.Ftw;
      ah.d.tC(this.ABU.isLongVideo());
      break;
      paramInt1 = 0;
      break label835;
      label926:
      break;
      label928:
      params.setPostFailed();
      continue;
      label936:
      localObject1 = ah.d.Ftw;
      ah.d.tV(this.ABU.isLongVideo());
      params.setPostFailedAndNotRetry(paramInt3);
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dVi()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.Hde;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165254);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165254);
    return i;
  }
  
  public final int getType()
  {
    return 3585;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dg
 * JD-Core Version:    0.7.0.1
 */
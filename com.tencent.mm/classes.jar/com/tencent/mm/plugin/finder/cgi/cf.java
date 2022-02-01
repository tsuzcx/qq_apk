package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.loader.aa;
import com.tencent.mm.plugin.finder.loader.y;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.al;
import com.tencent.mm.plugin.finder.model.bu;
import com.tencent.mm.plugin.finder.report.v.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.utils.ag;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.plugin.finder.utils.ax;
import com.tencent.mm.plugin.finder.utils.e.b;
import com.tencent.mm.plugin.finder.viewmodel.b.a;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.apw;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfs;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.bhb;
import com.tencent.mm.protocal.protobuf.bhc;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blj;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.csi;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.g.a;
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
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "postRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "getPostRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "setPostRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrLongVideoDesc", "Lcom/tencent/mm/protocal/protobuf/FinderAttachmentList;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/findersdk/cgi/report/EnableValue;", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class cf
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xdQ;
  private i callback;
  public final String clientId;
  public FinderObject feedObject;
  private final long localId;
  private com.tencent.mm.an.d rr;
  private FinderItem xcG;
  public bhb xdP;
  
  static
  {
    AppMethodBeat.i(165259);
    xdQ = new a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public cf(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.xcG = paramFinderItem;
    this.clientId = paramString;
    this.localId = paramLong;
    this.feedObject = this.xcG.getFeedObject();
    d.a locala = new d.a();
    locala.TW("/cgi-bin/micromsg-bin/finderpost");
    locala.vD(getType());
    this.xdP = new bhb();
    this.xdP.clientId = this.clientId;
    Object localObject1 = this.xdP;
    paramString = (com.tencent.mm.cd.a)new FinderObjectDesc();
    paramFinderItem = this.feedObject.objectDesc;
    if (paramFinderItem != null) {
      paramFinderItem = paramFinderItem.toByteArray();
    }
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
        csg localcsg;
        MultiMediaVideoChecker localMultiMediaVideoChecker;
        Log.printDebugStack("safeParser", "", new Object[] { paramFinderItem });
        paramFinderItem = null;
        continue;
        i = 0;
        continue;
        if (((FinderObjectDesc)localObject2).mediaType != 8) {
          continue;
        }
        ((FinderObjectDesc)localObject2).mediaType = 0;
        ((bhb)localObject1).SRA = ((FinderObjectDesc)localObject2);
        this.xdP.attachmentList = doS();
        this.xdP.username = z.bdh();
        this.xdP.SRB = this.feedObject.refObjectId;
        this.xdP.refObjectNonceId = this.feedObject.refObjectNonceId;
        paramFinderItem = this.xdP;
        paramString = this.feedObject.objectDesc;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.event;
        if (paramString == null) {
          continue;
        }
        paramLong = paramString.xdR;
        paramFinderItem.xdR = paramLong;
        paramFinderItem = this.xdP;
        paramString = ao.xcj;
        paramFinderItem.yjp = ao.dnO();
        paramFinderItem = this.xcG.field_postExtraData;
        if (paramFinderItem == null) {
          continue;
        }
        this.xdP.latitude = paramFinderItem.latitude;
        this.xdP.longitude = paramFinderItem.longitude;
        this.xdP.SRy = paramFinderItem.SRy;
        this.xdP.SRx = paramFinderItem.SRx;
        this.xdP.SRz = paramFinderItem.SRz;
        this.xdP.topics = new LinkedList();
        paramFinderItem = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dTd()) {
          continue;
        }
        paramFinderItem = new ArrayList();
        paramString = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (!com.tencent.mm.plugin.finder.storage.d.dTe()) {
          continue;
        }
        localObject1 = new HashMap();
        if ((this.xcG.field_postinfo == null) || (this.xcG.field_postinfo.TAm == null)) {
          continue;
        }
        Object localObject2 = this.xcG.field_postinfo.TAm.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        Object localObject3 = (cse)((Iterator)localObject2).next();
        paramString = ((cse)localObject3).nickname;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        ((HashMap)localObject1).put(paramFinderItem, localObject3);
        continue;
        paramLong = 0L;
        continue;
        paramFinderItem = com.tencent.mm.plugin.finder.utils.e.ACV;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          continue;
        }
        paramString = paramFinderItem.description;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        paramFinderItem = (ArrayList)com.tencent.mm.plugin.finder.utils.e.a(paramFinderItem, (HashMap)localObject1, null).My;
        localObject2 = this.xdP.topics;
        paramString = ag.AFH;
        paramString = this.feedObject.objectDesc;
        if (paramString == null) {
          continue;
        }
        localObject1 = paramString.description;
        paramString = (String)localObject1;
        if (localObject1 != null) {
          continue;
        }
        paramString = "";
        paramString = (Iterable)ag.a(paramString, paramFinderItem, null);
        paramFinderItem = (Collection)new ArrayList(j.a(paramString, 10));
        paramString = paramString.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        paramFinderItem.add(((ax)paramString.next()).topic);
        continue;
        ((LinkedList)localObject2).addAll((Collection)paramFinderItem);
        this.xdP.originalFlag = this.feedObject.originalFlag;
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
        localObject1 = ((bej)paramString.next()).musicInfo;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((bfg)localObject1).BHW;
        if (localObject1 == null) {
          continue;
        }
        paramFinderItem.add(localObject1);
        continue;
        this.xdP.SRD = paramFinderItem;
        localObject1 = this.xdP;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          continue;
        }
        paramFinderItem = paramFinderItem.feedBgmInfo;
        if (paramFinderItem == null) {
          continue;
        }
        paramFinderItem = paramFinderItem.musicInfo;
        if (paramFinderItem == null) {
          continue;
        }
        paramFinderItem = paramFinderItem.SPV;
        if ((paramFinderItem == null) || (kotlin.n.n.M(paramFinderItem, "http", true) != true)) {
          continue;
        }
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          continue;
        }
        paramFinderItem = paramFinderItem.feedBgmInfo;
        if (paramFinderItem == null) {
          continue;
        }
        paramFinderItem = paramFinderItem.musicInfo;
        if (paramFinderItem == null) {
          continue;
        }
        paramString = paramFinderItem.SPV;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        ((bhb)localObject1).SRF = paramFinderItem;
        paramString = this.xdP;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          break label1635;
        }
      }
      if (paramFinderItem == null) {
        p.iCn();
      }
      localObject2 = (FinderObjectDesc)paramFinderItem;
      if (this.feedObject.refObjectId == 0L)
      {
        paramFinderItem = ((FinderObjectDesc)localObject2).media;
        p.j(paramFinderItem, "objectDesc.media");
        localObject3 = ((Iterable)paramFinderItem).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localFinderMedia = (FinderMedia)((Iterator)localObject3).next();
          paramFinderItem = this.xcG;
          paramString = MD5Util.getMD5String(localFinderMedia.url);
          p.j(paramString, "MD5Util.getMD5String(media.url)");
          localcsg = paramFinderItem.mediaExt(paramString);
          if (localcsg == null) {
            continue;
          }
          paramFinderItem = com.tencent.mm.plugin.finder.upload.o.AAZ;
          p.j(localFinderMedia, "media");
          com.tencent.mm.plugin.finder.upload.o.a(localFinderMedia, localcsg, this.xcG.getHalfVideoMediaExtList());
          if ((localFinderMedia.mediaType != 4) || ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000))) {
            continue;
          }
          localMultiMediaVideoChecker = MultiMediaVideoChecker.NmA;
          paramString = localcsg.url;
          paramFinderItem = paramString;
          if (paramString == null) {
            paramFinderItem = "";
          }
          paramFinderItem = localMultiMediaVideoChecker.bfs(paramFinderItem);
          if (paramFinderItem != null)
          {
            i = (int)paramFinderItem.duration;
            localFinderMedia.videoDuration = (i / 1000);
            if ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)) {
              continue;
            }
            Log.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + localcsg.videoDuration);
            if (!BuildInfo.DEBUG) {
              continue;
            }
            paramFinderItem = (Throwable)new RuntimeException("NetSceneFinderPost videoDuration invalid:" + localcsg.videoDuration);
            AppMethodBeat.o(165258);
            throw paramFinderItem;
            paramFinderItem = null;
            continue;
          }
        }
      }
      paramFinderItem = paramFinderItem.feedBgmInfo;
      label1285:
      label1306:
      if (paramFinderItem != null)
      {
        paramFinderItem = paramFinderItem.groupId;
        paramString.groupId = paramFinderItem;
        paramString = this.xdP;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          break label1640;
        }
        paramFinderItem = paramFinderItem.feedBgmInfo;
        if (paramFinderItem == null) {
          break label1640;
        }
        paramFinderItem = paramFinderItem.musicInfo;
        label1246:
        if (paramFinderItem != null)
        {
          paramFinderItem = this.feedObject.objectDesc;
          if (paramFinderItem == null) {
            break label1645;
          }
          paramFinderItem = paramFinderItem.feedBgmInfo;
          if (paramFinderItem == null) {
            break label1645;
          }
          paramFinderItem = paramFinderItem.musicInfo;
          if (paramFinderItem == null) {
            break label1645;
          }
          paramFinderItem = paramFinderItem.BHW;
          paramFinderItem = (CharSequence)paramFinderItem;
          if ((paramFinderItem != null) && (paramFinderItem.length() != 0)) {
            break label1650;
          }
          i = 1;
          if (i == 0) {
            break label1656;
          }
        }
      }
    }
    label1635:
    label1640:
    label1645:
    label1650:
    label1656:
    for (int i = 1;; i = 2)
    {
      paramString.SRG = i;
      this.xdP.SRv = this.xcG.getFeedObject().objectType;
      Log.i("Finder.LogPost.NetSceneFinderPost", "bgmInfo: groupBgmUrl:" + this.xdP.SRF + ",groupId:" + this.xdP.groupId + ",groupPostType:" + this.xdP.SRG);
      locala.c((com.tencent.mm.cd.a)this.xdP);
      locala.d((com.tencent.mm.cd.a)new bhc());
      localObject1 = new StringBuilder("post clientId ").append(this.clientId).append(" content: ");
      paramString = this.xdP.SRA;
      paramFinderItem = paramString;
      if (paramString == null) {
        paramFinderItem = "";
      }
      Log.i("Finder.LogPost.NetSceneFinderPost", com.tencent.mm.ae.g.bN(paramFinderItem) + " refId: " + this.xdP.SRB + " localId:" + this.xcG.getLocalId() + " isCreatedInFinder:" + this.xdP.SRz + ", latitude:" + this.xdP.latitude + ", longitude:" + this.xdP.longitude + ", feedLatitude:" + this.xdP.SRy + ", feedLongitude:" + this.xdP.SRx + ", originalFlag:" + this.feedObject.originalFlag);
      paramFinderItem = locala.bgN();
      p.j(paramFinderItem, "builder.buildInstance()");
      this.rr = paramFinderItem;
      AppMethodBeat.o(165258);
      return;
      paramFinderItem = null;
      break;
      paramFinderItem = null;
      break label1246;
      paramFinderItem = null;
      break label1285;
      i = 0;
      break label1306;
    }
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().MI(paramLong);
    Object localObject = new StringBuilder("updateLocalFeed, isExist ");
    label136:
    int i;
    if (localFinderItem == null)
    {
      bool = true;
      Log.i("Finder.LogPost.NetSceneFinderPost", bool);
      if (localFinderItem == null) {
        break label392;
      }
      localFinderItem.setPostFinish();
      d(paramFinderObject);
      localFinderItem.updateFinderObject(paramFinderObject);
      localObject = k.Anu;
      p.k(localFinderItem, "item");
      k.a.c(paramLong, localFinderItem);
      localObject = com.tencent.mm.ui.component.g.Xox;
      Iterator localIterator = ((Iterable)((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.g.bD(PluginFinder.class).i(com.tencent.mm.plugin.finder.viewmodel.b.class)).RI(3).Bgw).iterator();
      if (!localIterator.hasNext()) {
        break label248;
      }
      localObject = localIterator.next();
      bu localbu = (bu)localObject;
      if ((!(localbu instanceof BaseFinderFeed)) || (((BaseFinderFeed)localbu).feedObject.getLocalId() != paramLong) || (paramLong == 0L)) {
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
      localObject = (bu)localObject;
      if (localObject == null) {
        break label276;
      }
      if (localObject != null) {
        break label254;
      }
      paramFinderObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
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
    p.k(localFinderItem, "<set-?>");
    ((BaseFinderFeed)localObject).feedObject = localFinderItem;
    label276:
    localFinderItem.setMediaExtList(new LinkedList());
    localFinderItem.setLongVideoMediaExtList(new LinkedList());
    boolean bool = ((PluginFinder)h.ag(PluginFinder.class)).getFeedStorage().A(paramLong, false);
    Log.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
    localObject = com.tencent.mm.plugin.finder.storage.data.e.AmW;
    e.a.a(paramFinderObject.id, localFinderItem);
    AppMethodBeat.o(165255);
    return;
    label392:
    AppMethodBeat.o(165255);
  }
  
  private final void d(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165256);
    Iterator localIterator = ((Iterable)this.xcG.getMediaExtList()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        j.iBO();
      }
      Object localObject3 = (csg)localObject1;
      localObject1 = com.tencent.mm.plugin.finder.upload.f.AzZ;
      Object localObject2 = ((csg)localObject3).url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.upload.f.aFl((String)localObject1);
      localObject1 = com.tencent.mm.plugin.finder.upload.f.AzZ;
      localObject2 = ((csg)localObject3).thumbUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.plugin.finder.upload.f.aFl((String)localObject1);
      localObject1 = paramFinderObject.objectDesc;
      if (localObject1 != null)
      {
        localObject1 = ((FinderObjectDesc)localObject1).media;
        if (localObject1 != null)
        {
          localObject2 = ((Iterable)localObject1).iterator();
          label195:
          Object localObject4;
          for (;;)
          {
            if (((Iterator)localObject2).hasNext())
            {
              localObject1 = ((Iterator)localObject2).next();
              if (p.h(((FinderMedia)localObject1).url, ((csg)localObject3).TzS))
              {
                localObject1 = (FinderMedia)localObject1;
                if (localObject1 == null) {
                  break label920;
                }
                Log.v("Finder.LogPost.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((csg)localObject3).mediaId + " newMediaID " + MD5Util.getMD5String(((FinderMedia)localObject1).url));
                ((csg)localObject3).mediaId = MD5Util.getMD5String(((FinderMedia)localObject1).url);
                if ((((csg)localObject3).mediaType == 2) || (((csg)localObject3).mediaType == 7))
                {
                  localObject2 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
                  localObject4 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.Aly, null, null, 12);
                  Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files thumbUrl " + ((csg)localObject3).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.r)localObject2).getPath() + " url " + ((FinderMedia)localObject1).thumbUrl);
                  Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files url " + ((csg)localObject3).url + " to path " + ((com.tencent.mm.plugin.finder.loader.r)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
                  com.tencent.mm.vfs.u.on(((csg)localObject3).thumbUrl, ((com.tencent.mm.plugin.finder.loader.r)localObject2).getPath());
                  com.tencent.mm.vfs.u.on(((csg)localObject3).url, ((com.tencent.mm.plugin.finder.loader.r)localObject4).getPath());
                }
                if (((csg)localObject3).mediaType == 4)
                {
                  localObject2 = new com.tencent.mm.plugin.finder.loader.r((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.Alz, null, null, 12);
                  if (!com.tencent.mm.modelcontrol.e.vW(4)) {
                    break label915;
                  }
                }
              }
            }
          }
          label915:
          for (i = 2;; i = 1)
          {
            localObject4 = new aa((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.AlL, i, null, 8);
            Object localObject5 = new y((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.Aly);
            com.tencent.mm.plugin.finder.loader.o localo = new com.tencent.mm.plugin.finder.loader.o((csg)localObject3, com.tencent.mm.plugin.finder.storage.u.Alz);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files thumbUrl " + ((csg)localObject3).thumbUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.r)localObject2).getPath() + "  url " + ((FinderMedia)localObject1).thumbUrl);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files url " + ((csg)localObject3).url + " to path " + ((aa)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp cover files url " + ((csg)localObject3).coverUrl + " to path " + ((y)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp fullThumb files url " + ((csg)localObject3).TzX + " to path " + ((y)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
            com.tencent.mm.vfs.u.on(((csg)localObject3).thumbUrl, ((com.tencent.mm.plugin.finder.loader.r)localObject2).getPath());
            com.tencent.mm.vfs.u.on(((csg)localObject3).url, ((aa)localObject4).getPath());
            com.tencent.mm.vfs.u.on(((csg)localObject3).coverUrl, ((y)localObject5).getPath());
            com.tencent.mm.vfs.u.on(((csg)localObject3).TzX, localo.getPath());
            long l = com.tencent.mm.vfs.u.bBQ(((csg)localObject3).url);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.AnN;
            localObject5 = ((aa)localObject4).aBv();
            localObject2 = ((csg)localObject3).mediaId;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject3 = ((csg)localObject3).url;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            com.tencent.mm.plugin.finder.storage.logic.d.a((String)localObject5, (String)localObject1, (String)localObject2, i, com.tencent.mm.plugin.finder.storage.u.AlL.detail, l, l, 3, ((aa)localObject4).ztO.videoDuration, "", "");
            i = j;
            break;
            localObject1 = null;
            break label195;
          }
        }
      }
      label920:
      i = j;
    }
    AppMethodBeat.o(165256);
  }
  
  private final apx doS()
  {
    AppMethodBeat.i(280372);
    Object localObject1 = this.feedObject.attachmentList;
    if (localObject1 != null)
    {
      localObject1 = ((apx)localObject1).SDm;
      if (localObject1 != null)
      {
        localObject1 = (apw)j.lp((List)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((apw)localObject1).SDl;
          if (localObject1 != null)
          {
            localObject1 = ((blj)localObject1).SPm;
            if (localObject1 != null)
            {
              localObject1 = ((cvy)localObject1).TEM;
              if (localObject1 != null)
              {
                LinkedList localLinkedList = new LinkedList();
                Object localObject2 = (Iterable)this.xcG.getLongVideoMediaExtList();
                Collection localCollection = (Collection)new ArrayList(j.a((Iterable)localObject2, 10));
                localObject2 = ((Iterable)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  csg localcsg = (csg)((Iterator)localObject2).next();
                  cwq localcwq = com.tencent.mm.plugin.finder.storage.data.n.c(localcsg);
                  localcwq.url = localcsg.TzS;
                  localcwq.thumbUrl = localcsg.TzT;
                  localcwq.md5sum = localcsg.md5sum;
                  localCollection.add(localcwq);
                }
                localLinkedList.addAll((Collection)localCollection);
                ((cwc)localObject1).media = localLinkedList;
              }
            }
          }
        }
      }
    }
    localObject1 = this.feedObject.attachmentList;
    AppMethodBeat.o(280372);
    return localObject1;
  }
  
  private final void doT()
  {
    AppMethodBeat.i(280375);
    Object localObject1 = this.xcG.field_postinfo.TAm.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((cse)((Iterator)localObject1).next()).AJe = this.xcG.field_createTime;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.e.ACV;
    Object localObject4 = this.xcG.field_postinfo.TAm;
    p.j(localObject4, "finderItem.field_postinfo.atContactList");
    p.k(localObject4, "atContacts");
    if (!((LinkedList)localObject4).isEmpty())
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.e.ecL();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinkedList();
      }
      HashMap localHashMap = new HashMap(((LinkedList)localObject1).size());
      Object localObject5 = ((LinkedList)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject5).hasNext())
      {
        cse localcse = (cse)((Iterator)localObject5).next();
        localObject3 = localcse.username;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localHashMap.put(localObject2, localcse);
      }
      localObject4 = ((LinkedList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (cse)((Iterator)localObject4).next();
        if (!Util.isNullOrNil(((cse)localObject5).username))
        {
          localObject2 = (cse)((Map)localHashMap).get(((cse)localObject5).username);
          if ((localObject2 == null) || (((cse)localObject2).AJe < ((cse)localObject5).AJe))
          {
            localObject3 = ((cse)localObject5).username;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localHashMap.put(localObject2, localObject5);
          }
        }
      }
      ((LinkedList)localObject1).clear();
      localObject2 = ((Map)localHashMap).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Map.Entry)((Iterator)localObject2).next();
        ((Map.Entry)localObject3).getKey();
        ((LinkedList)localObject1).add((cse)((Map.Entry)localObject3).getValue());
      }
      Collections.sort((List)localObject1, (Comparator)e.b.ACY);
      if (((LinkedList)localObject1).size() > 5)
      {
        int i = ((LinkedList)localObject1).size() - 1;
        while (i >= 5)
        {
          ((LinkedList)localObject1).remove(i);
          i -= 1;
        }
      }
      localObject2 = new csi();
      ((csi)localObject2).SGP = ((LinkedList)localObject1);
      try
      {
        localObject1 = ((csi)localObject2).toByteArray();
        if (localObject1 == null)
        {
          AppMethodBeat.o(280375);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = FinderPostAtUI.Atv;
        Log.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(280375);
        return;
      }
      com.tencent.mm.plugin.finder.utils.e.aal().encode("_finder_at_mmkv_recent_at", localIOException);
    }
    AppMethodBeat.o(280375);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(280374);
    Log.i("Finder.LogPost.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.xcG.getLocalId(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.localId) });
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 5L, 1L, false);
      params = this.rr;
      if (params != null) {}
      for (params = params.bhY(); params == null; params = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(280374);
        throw paramString;
      }
      localObject1 = ((bhc)params).xVl;
      localObject2 = new StringBuilder("onGYNetEnd ").append(localObject1).append(' ');
      if (localObject1 != null)
      {
        params = Long.valueOf(((FinderObject)localObject1).id);
        Log.i("Finder.LogPost.NetSceneFinderPost", params + ", localId:" + this.localId);
        params = c.AnK;
        if (!c.a.MR(this.localId)) {
          break label633;
        }
        localObject2 = this.feedObject.contact;
        if (localObject1 != null) {
          break label854;
        }
      }
    }
    label291:
    label820:
    label822:
    label830:
    label854:
    for (params = this.feedObject;; params = (s)localObject1)
    {
      this.feedObject = params;
      FinderObject localFinderObject = this.feedObject;
      localObject1 = this.feedObject.nickname;
      params = (s)localObject1;
      if (localObject1 == null)
      {
        if (localObject2 != null) {
          params = ((FinderContact)localObject2).nickname;
        }
      }
      else
      {
        localObject1 = params;
        if (params == null) {
          localObject1 = "";
        }
        localFinderObject.nickname = ((String)localObject1);
        this.feedObject.contact = ((FinderContact)localObject2);
        a(this.localId, this.feedObject);
        doT();
        params = com.tencent.mm.plugin.finder.storage.data.e.AmW;
        params = e.a.MH(this.feedObject.id);
        if (params != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
          localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ecG().Na(this.localId);
          boolean bool2 = ((Boolean)((kotlin.o)localObject1).Mx).booleanValue();
          bool1 = ((Boolean)((kotlin.o)localObject1).My).booleanValue();
          if (bool2)
          {
            localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ACj;
            localObject1 = com.tencent.mm.plugin.finder.upload.action.l.ecG();
            long l = this.localId;
            p.k(params, "feed");
            Log.i(com.tencent.mm.plugin.finder.upload.action.l.TAG, "doLikeLocalFeed localId:" + l + ", isPrivate:" + bool1 + ", feedid:" + params.getId());
            localObject1 = (com.tencent.mm.plugin.finder.storage.r)((com.tencent.mm.plugin.finder.upload.action.l)localObject1).ACh.get(Long.valueOf(l));
            if (localObject1 != null)
            {
              localObject2 = al.zAN;
              localObject2 = ((com.tencent.mm.plugin.finder.storage.r)localObject1).field_contextObj;
              p.j(localObject2, "action.field_contextObj");
              paramInt1 = ((com.tencent.mm.plugin.finder.storage.r)localObject1).field_likeAction;
              int i = ((com.tencent.mm.plugin.finder.storage.r)localObject1).field_scene;
              bool2 = ((com.tencent.mm.plugin.finder.storage.r)localObject1).field_showTips;
              localObject1 = aj.AGc;
              al.a((bid)localObject2, paramInt1, params, true, bool1, i, bool2, false, aj.dOO());
            }
          }
        }
      }
      for (;;)
      {
        if (this.callback != null)
        {
          params = this.callback;
          if (params == null) {
            p.iCn();
          }
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        }
        params = com.tencent.mm.plugin.findersdk.c.a.Bwg;
        com.tencent.mm.plugin.findersdk.c.a.x(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(280374);
        return;
        params = null;
        break;
        params = null;
        break label291;
        label633:
        if (localObject1 != null)
        {
          params = z.bdh();
          p.j(params, "ConfigStorageLogic.getMyFinderUsername()");
          params = new ay(params, (FinderObject)localObject1);
          h.aGY().b((q)params);
        }
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 6L, 1L, false);
      params = v.d.zYG;
      v.d.qu(this.xcG.isLongVideo());
      params = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      boolean bool1 = com.tencent.mm.plugin.findersdk.c.a.ht(paramInt2, paramInt3);
      if (paramInt3 == -4013)
      {
        paramInt1 = 1;
        label729:
        if ((paramInt2 != 4) && (bool1) && (paramInt1 == 0)) {
          break label820;
        }
        params = c.AnK;
        params = c.a.MS(this.localId);
        if (params != null)
        {
          if (!bool1) {
            break label830;
          }
          if (paramInt1 == 0) {
            break label822;
          }
          params.setPostFailedAndNoAuth();
        }
      }
      for (;;)
      {
        this.xcG.field_localFlag = params.field_localFlag;
        localObject1 = c.AnK;
        c.a.s(params);
        params = v.d.zYG;
        v.d.qm(this.xcG.isLongVideo());
        break;
        paramInt1 = 0;
        break label729;
        break;
        params.setPostFailed();
        continue;
        localObject1 = v.d.zYG;
        v.d.qv(this.xcG.isLongVideo());
        params.setPostFailedAndNotRetry(paramInt3);
      }
    }
  }
  
  public final com.tencent.mm.plugin.findersdk.b.a.b dnF()
  {
    return com.tencent.mm.plugin.findersdk.b.a.b.BvU;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165254);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(165254);
    return i;
  }
  
  public final int getType()
  {
    return 3585;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cf
 * JD-Core Version:    0.7.0.1
 */
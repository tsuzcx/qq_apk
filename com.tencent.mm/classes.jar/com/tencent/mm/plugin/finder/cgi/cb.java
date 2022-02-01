package com.tencent.mm.plugin.finder.cgi;

import android.arch.lifecycle.ViewModelProvider;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.cgi.report.b;
import com.tencent.mm.plugin.finder.loader.k;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.aj;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.r.d;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e.a;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.plugin.finder.ui.FinderPostAtUI;
import com.tencent.mm.plugin.finder.upload.f;
import com.tencent.mm.plugin.finder.utils.d.b;
import com.tencent.mm.plugin.finder.utils.w;
import com.tencent.mm.plugin.finder.utils.w.c;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM.a;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker;
import com.tencent.mm.plugin.vlog.model.MultiMediaVideoChecker.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderMedia;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.protocal.protobuf.aoq;
import com.tencent.mm.protocal.protobuf.ayp;
import com.tencent.mm.protocal.protobuf.azk;
import com.tencent.mm.protocal.protobuf.azr;
import com.tencent.mm.protocal.protobuf.azs;
import com.tencent.mm.protocal.protobuf.bal;
import com.tencent.mm.protocal.protobuf.baq;
import com.tencent.mm.protocal.protobuf.bar;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.bei;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cjm;
import com.tencent.mm.protocal.protobuf.cjn;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
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
import kotlin.g.b.p;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "finderItem", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "clientId", "", "localId", "", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;Ljava/lang/String;J)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClientId", "()Ljava/lang/String;", "feedObject", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFeedObject", "()Lcom/tencent/mm/protocal/protobuf/FinderObject;", "setFeedObject", "(Lcom/tencent/mm/protocal/protobuf/FinderObject;)V", "getFinderItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "setFinderItem", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getLocalId", "()J", "postRequest", "Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "getPostRequest", "()Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;", "setPostRequest", "(Lcom/tencent/mm/protocal/protobuf/FinderPostRequest;)V", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "buildSvrLongVideoDesc", "Lcom/tencent/mm/protocal/protobuf/FinderAttachmentList;", "buildSvrObjectDesc", "Lcom/tencent/mm/protocal/protobuf/FinderObjectDesc;", "objectDesc", "copyLocalMediaFiles", "", "svrFeed", "doScene", "", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "fix", "getRespFeedObject", "getType", "isEnableReport", "Lcom/tencent/mm/plugin/finder/cgi/report/EnableValue;", "onCgiEnd", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "updateLocalFeed", "updateRecentAtContact", "Companion", "plugin-finder_release"})
public final class cb
  extends ax
  implements m
{
  public static final a twc;
  private com.tencent.mm.ak.i callback;
  public final String clientId;
  public FinderObject feedObject;
  private final long localId;
  private com.tencent.mm.ak.d rr;
  private FinderItem tuX;
  public baq twb;
  
  static
  {
    AppMethodBeat.i(165259);
    twc = new a((byte)0);
    AppMethodBeat.o(165259);
  }
  
  public cb(FinderItem paramFinderItem, String paramString, long paramLong)
  {
    AppMethodBeat.i(165258);
    this.tuX = paramFinderItem;
    this.clientId = paramString;
    this.localId = paramLong;
    this.feedObject = this.tuX.getFeedObject();
    d.a locala = new d.a();
    locala.MB("/cgi-bin/micromsg-bin/finderpost");
    locala.sG(getType());
    this.twb = new baq();
    this.twb.clientId = this.clientId;
    Object localObject1 = this.twb;
    paramString = (com.tencent.mm.bw.a)new FinderObjectDesc();
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
        cjl localcjl;
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
        ((baq)localObject1).LKf = ((FinderObjectDesc)localObject2);
        this.twb.attachmentList = cZa();
        this.twb.username = z.aUg();
        this.twb.LKg = this.feedObject.refObjectId;
        this.twb.refObjectNonceId = this.feedObject.refObjectNonceId;
        paramFinderItem = this.twb;
        paramString = this.feedObject.objectDesc;
        if (paramString == null) {
          continue;
        }
        paramString = paramString.event;
        if (paramString == null) {
          continue;
        }
        paramLong = paramString.twd;
        paramFinderItem.twd = paramLong;
        paramFinderItem = this.twb;
        paramString = am.tuw;
        paramFinderItem.uli = am.cXY();
        paramFinderItem = this.tuX.field_postExtraData;
        if (paramFinderItem == null) {
          continue;
        }
        this.twb.latitude = paramFinderItem.latitude;
        this.twb.dTj = paramFinderItem.dTj;
        this.twb.LKd = paramFinderItem.LKd;
        this.twb.LKc = paramFinderItem.LKc;
        this.twb.LKe = paramFinderItem.LKe;
        this.twb.Gbc = new LinkedList();
        paramFinderItem = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drN()) {
          continue;
        }
        paramFinderItem = new ArrayList();
        paramString = com.tencent.mm.plugin.finder.storage.c.vCb;
        if (!com.tencent.mm.plugin.finder.storage.c.drO()) {
          continue;
        }
        localObject1 = new HashMap();
        if ((this.tuX.field_postinfo == null) || (this.tuX.field_postinfo.Mpg == null)) {
          continue;
        }
        Object localObject2 = this.tuX.field_postinfo.Mpg.iterator();
        if (!((Iterator)localObject2).hasNext()) {
          continue;
        }
        Object localObject3 = (cjj)((Iterator)localObject2).next();
        paramString = ((cjj)localObject3).nickname;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        ((HashMap)localObject1).put(paramFinderItem, localObject3);
        continue;
        paramLong = 0L;
        continue;
        paramFinderItem = com.tencent.mm.plugin.finder.utils.d.vVg;
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
        paramFinderItem = (ArrayList)com.tencent.mm.plugin.finder.utils.d.a(paramFinderItem, (HashMap)localObject1, null).second;
        localObject2 = this.twb.Gbc;
        paramString = w.vXp;
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
        paramString = (Iterable)w.a(paramString, paramFinderItem, null);
        paramFinderItem = (Collection)new ArrayList(kotlin.a.j.a(paramString, 10));
        paramString = paramString.iterator();
        if (!paramString.hasNext()) {
          continue;
        }
        paramFinderItem.add(((w.c)paramString.next()).dST);
        continue;
        ((LinkedList)localObject2).addAll((Collection)paramFinderItem);
        this.twb.originalFlag = this.feedObject.originalFlag;
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
        localObject1 = ((ayp)paramString.next()).musicInfo;
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((azk)localObject1).wWb;
        if (localObject1 == null) {
          continue;
        }
        paramFinderItem.add(localObject1);
        continue;
        this.twb.LKi = paramFinderItem;
        localObject1 = this.twb;
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
        paramFinderItem = paramFinderItem.LJi;
        if ((paramFinderItem == null) || (n.J(paramFinderItem, "http", true) != true)) {
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
        paramString = paramFinderItem.LJi;
        paramFinderItem = paramString;
        if (paramString != null) {
          continue;
        }
        paramFinderItem = "";
        ((baq)localObject1).LKk = paramFinderItem;
        paramString = this.twb;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          break label1638;
        }
      }
      if (paramFinderItem == null) {
        p.hyc();
      }
      localObject2 = (FinderObjectDesc)paramFinderItem;
      if (this.feedObject.refObjectId == 0L)
      {
        paramFinderItem = ((FinderObjectDesc)localObject2).media;
        p.g(paramFinderItem, "objectDesc.media");
        localObject3 = ((Iterable)paramFinderItem).iterator();
        if (((Iterator)localObject3).hasNext())
        {
          localFinderMedia = (FinderMedia)((Iterator)localObject3).next();
          paramFinderItem = this.tuX;
          paramString = MD5Util.getMD5String(localFinderMedia.url);
          p.g(paramString, "MD5Util.getMD5String(media.url)");
          localcjl = paramFinderItem.mediaExt(paramString);
          if (localcjl == null) {
            continue;
          }
          paramFinderItem = com.tencent.mm.plugin.finder.upload.o.vTw;
          p.g(localFinderMedia, "media");
          com.tencent.mm.plugin.finder.upload.o.a(localFinderMedia, localcjl, this.tuX.getHalfVideoMediaExtList());
          if ((localFinderMedia.mediaType != 4) || ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000))) {
            continue;
          }
          localMultiMediaVideoChecker = MultiMediaVideoChecker.GyY;
          paramString = localcjl.url;
          paramFinderItem = paramString;
          if (paramString == null) {
            paramFinderItem = "";
          }
          paramFinderItem = localMultiMediaVideoChecker.aTV(paramFinderItem);
          if (paramFinderItem != null)
          {
            i = (int)paramFinderItem.duration;
            localFinderMedia.videoDuration = (i / 1000);
            if ((localFinderMedia.videoDuration > 0) && (localFinderMedia.videoDuration <= 2000)) {
              continue;
            }
            Log.e("Finder.LogPost.NetSceneFinderPost", "NetSceneFinderPost videoDuration invalid:" + localcjl.videoDuration);
            if (!BuildInfo.DEBUG) {
              continue;
            }
            paramFinderItem = (Throwable)new RuntimeException("NetSceneFinderPost videoDuration invalid:" + localcjl.videoDuration);
            AppMethodBeat.o(165258);
            throw paramFinderItem;
            paramFinderItem = null;
            continue;
          }
        }
      }
      paramFinderItem = paramFinderItem.feedBgmInfo;
      label1286:
      label1307:
      if (paramFinderItem != null)
      {
        paramFinderItem = paramFinderItem.groupId;
        paramString.groupId = paramFinderItem;
        paramString = this.twb;
        paramFinderItem = this.feedObject.objectDesc;
        if (paramFinderItem == null) {
          break label1643;
        }
        paramFinderItem = paramFinderItem.feedBgmInfo;
        if (paramFinderItem == null) {
          break label1643;
        }
        paramFinderItem = paramFinderItem.musicInfo;
        label1247:
        if (paramFinderItem != null)
        {
          paramFinderItem = this.feedObject.objectDesc;
          if (paramFinderItem == null) {
            break label1648;
          }
          paramFinderItem = paramFinderItem.feedBgmInfo;
          if (paramFinderItem == null) {
            break label1648;
          }
          paramFinderItem = paramFinderItem.musicInfo;
          if (paramFinderItem == null) {
            break label1648;
          }
          paramFinderItem = paramFinderItem.wWb;
          paramFinderItem = (CharSequence)paramFinderItem;
          if ((paramFinderItem != null) && (paramFinderItem.length() != 0)) {
            break label1653;
          }
          i = 1;
          if (i == 0) {
            break label1659;
          }
        }
      }
    }
    label1638:
    label1643:
    label1648:
    label1653:
    label1659:
    for (int i = 1;; i = 2)
    {
      paramString.LKl = i;
      this.twb.LKa = this.tuX.getFeedObject().objectType;
      Log.i("Finder.LogPost.NetSceneFinderPost", "bgmInfo: groupBgmUrl:" + this.twb.LKk + ",groupId:" + this.twb.groupId + ",groupPostType:" + this.twb.LKl);
      locala.c((com.tencent.mm.bw.a)this.twb);
      locala.d((com.tencent.mm.bw.a)new bar());
      localObject1 = new StringBuilder("post clientId ").append(this.clientId).append(" content: ");
      paramString = this.twb.LKf;
      paramFinderItem = paramString;
      if (paramString == null) {
        paramFinderItem = "";
      }
      Log.i("Finder.LogPost.NetSceneFinderPost", com.tencent.mm.ac.g.bN(paramFinderItem) + " refId: " + this.twb.LKg + " localId:" + this.tuX.getLocalId() + " isCreatedInFinder:" + this.twb.LKe + ", latitude:" + this.twb.latitude + ", longitude:" + this.twb.dTj + ", feedLatitude:" + this.twb.LKd + ", feedLongitude:" + this.twb.LKc + ", originalFlag:" + this.feedObject.originalFlag);
      paramFinderItem = locala.aXF();
      p.g(paramFinderItem, "builder.buildInstance()");
      this.rr = paramFinderItem;
      AppMethodBeat.o(165258);
      return;
      paramFinderItem = null;
      break;
      paramFinderItem = null;
      break label1247;
      paramFinderItem = null;
      break label1286;
      i = 0;
      break label1307;
    }
  }
  
  private final void a(long paramLong, FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165255);
    FinderItem localFinderItem = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().Fz(paramLong);
    Object localObject = new StringBuilder("updateLocalFeed, isExist ");
    label137:
    int i;
    if (localFinderItem == null)
    {
      bool = true;
      Log.i("Finder.LogPost.NetSceneFinderPost", bool);
      if (localFinderItem == null) {
        break label409;
      }
      localFinderItem.setPostFinish();
      e(paramFinderObject);
      localFinderItem.updateFinderObject(paramFinderObject);
      localObject = com.tencent.mm.plugin.finder.storage.data.l.vGw;
      p.h(localFinderItem, "item");
      l.a.c(paramLong, localFinderItem);
      localObject = com.tencent.mm.ui.component.a.PRN;
      Iterator localIterator = ((Iterable)((FinderHomeTabStateVM)com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mq(3).wuc).iterator();
      if (!localIterator.hasNext()) {
        break label249;
      }
      localObject = localIterator.next();
      bo localbo = (bo)localObject;
      if ((!(localbo instanceof BaseFinderFeed)) || (((BaseFinderFeed)localbo).feedObject.getLocalId() != paramLong) || (paramLong == 0L)) {
        break label243;
      }
      i = 1;
      label196:
      if (i == 0) {
        break label247;
      }
    }
    for (;;)
    {
      localObject = (bo)localObject;
      if (localObject == null) {
        break label277;
      }
      if (localObject != null) {
        break label255;
      }
      paramFinderObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
      AppMethodBeat.o(165255);
      throw paramFinderObject;
      bool = false;
      break;
      label243:
      i = 0;
      break label196;
      label247:
      break label137;
      label249:
      localObject = null;
    }
    label255:
    localObject = (BaseFinderFeed)localObject;
    p.h(localFinderItem, "<set-?>");
    ((BaseFinderFeed)localObject).feedObject = localFinderItem;
    label277:
    localFinderItem.setMediaExtList(new LinkedList());
    boolean bool = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getFeedStorage().A(paramLong, false);
    Log.i("Finder.LogPost.NetSceneFinderPost", "updateLocalFeed, delete local feed " + bool + ", localId:" + localFinderItem.getLocalId() + ", id:" + localFinderItem.getId());
    localObject = com.tencent.mm.plugin.finder.storage.data.e.vFX;
    paramLong = paramFinderObject.id;
    p.h(localFinderItem, "finder");
    paramFinderObject = com.tencent.mm.plugin.finder.storage.data.e.dyx();
    p.g(paramFinderObject, "cacheItems");
    paramFinderObject.put(Long.valueOf(paramLong), localFinderItem);
    AppMethodBeat.o(165255);
    return;
    label409:
    AppMethodBeat.o(165255);
  }
  
  private final aoq cZa()
  {
    AppMethodBeat.i(242492);
    Object localObject1 = this.feedObject.attachmentList;
    if (localObject1 != null)
    {
      localObject1 = ((aoq)localObject1).LAM;
      if (localObject1 != null)
      {
        localObject1 = (aop)kotlin.a.j.kt((List)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((aop)localObject1).LAL;
          if (localObject1 != null)
          {
            localObject1 = ((bei)localObject1).LIA;
            if (localObject1 != null)
            {
              localObject1 = ((cng)localObject1).MtG;
              if (localObject1 != null)
              {
                LinkedList localLinkedList = new LinkedList();
                Object localObject2 = (Iterable)this.tuX.getLongVideoMediaExtList();
                Collection localCollection = (Collection)new ArrayList(kotlin.a.j.a((Iterable)localObject2, 10));
                localObject2 = ((Iterable)localObject2).iterator();
                while (((Iterator)localObject2).hasNext())
                {
                  cjl localcjl = (cjl)((Iterator)localObject2).next();
                  cod localcod = com.tencent.mm.plugin.finder.storage.data.o.d(localcjl);
                  localcod.url = localcjl.MoM;
                  localcod.thumbUrl = localcjl.MoN;
                  localcod.md5sum = localcjl.md5sum;
                  localCollection.add(localcod);
                }
                localLinkedList.addAll((Collection)localCollection);
                ((cnl)localObject1).media = localLinkedList;
              }
            }
          }
        }
      }
    }
    localObject1 = this.feedObject.attachmentList;
    AppMethodBeat.o(242492);
    return localObject1;
  }
  
  private final void cZb()
  {
    AppMethodBeat.i(242494);
    Object localObject1 = this.tuX.field_postinfo.Mpg.iterator();
    while (((Iterator)localObject1).hasNext()) {
      ((cjj)((Iterator)localObject1).next()).wal = this.tuX.field_createTime;
    }
    localObject1 = com.tencent.mm.plugin.finder.utils.d.vVg;
    Object localObject4 = this.tuX.field_postinfo.Mpg;
    p.g(localObject4, "finderItem.field_postinfo.atContactList");
    p.h(localObject4, "atContacts");
    if (!((LinkedList)localObject4).isEmpty())
    {
      Object localObject2 = com.tencent.mm.plugin.finder.utils.d.dBy();
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = new LinkedList();
      }
      HashMap localHashMap = new HashMap(((LinkedList)localObject1).size());
      Object localObject5 = ((LinkedList)localObject1).iterator();
      Object localObject3;
      while (((Iterator)localObject5).hasNext())
      {
        cjj localcjj = (cjj)((Iterator)localObject5).next();
        localObject3 = localcjj.username;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "";
        }
        localHashMap.put(localObject2, localcjj);
      }
      localObject4 = ((LinkedList)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (cjj)((Iterator)localObject4).next();
        if (!Util.isNullOrNil(((cjj)localObject5).username))
        {
          localObject2 = (cjj)((Map)localHashMap).get(((cjj)localObject5).username);
          if ((localObject2 == null) || (((cjj)localObject2).wal < ((cjj)localObject5).wal))
          {
            localObject3 = ((cjj)localObject5).username;
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
        ((LinkedList)localObject1).add((cjj)((Map.Entry)localObject3).getValue());
      }
      Collections.sort((List)localObject1, (Comparator)d.b.vVj);
      if (((LinkedList)localObject1).size() > 5)
      {
        int i = ((LinkedList)localObject1).size() - 1;
        while (i >= 5)
        {
          ((LinkedList)localObject1).remove(i);
          i -= 1;
        }
      }
      localObject2 = new cjn();
      ((cjn)localObject2).LDz = ((LinkedList)localObject1);
      try
      {
        localObject1 = ((cjn)localObject2).toByteArray();
        if (localObject1 == null)
        {
          AppMethodBeat.o(242494);
          return;
        }
      }
      catch (IOException localIOException)
      {
        localObject2 = FinderPostAtUI.vME;
        Log.printErrStackTrace(FinderPostAtUI.access$getTAG$cp(), (Throwable)localIOException, "_writeRecentAt, LocalFinderRecentAtContactCache, _write: %s", new Object[] { localIOException.getMessage() });
        AppMethodBeat.o(242494);
        return;
      }
      com.tencent.mm.plugin.finder.utils.d.VQ().encode("_finder_at_mmkv_recent_at", localIOException);
    }
    AppMethodBeat.o(242494);
  }
  
  private final void e(FinderObject paramFinderObject)
  {
    AppMethodBeat.i(165256);
    Iterator localIterator = ((Iterable)this.tuX.getMediaExtList()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      int j = i + 1;
      if (i < 0) {
        kotlin.a.j.hxH();
      }
      Object localObject3 = (cjl)localObject1;
      localObject1 = f.vSz;
      Object localObject2 = ((cjl)localObject3).url;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      f.avV((String)localObject1);
      localObject1 = f.vSz;
      localObject2 = ((cjl)localObject3).thumbUrl;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      f.avV((String)localObject1);
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
              if (p.j(((FinderMedia)localObject1).url, ((cjl)localObject3).MoM))
              {
                localObject1 = (FinderMedia)localObject1;
                if (localObject1 == null) {
                  break label927;
                }
                Log.v("Finder.LogPost.NetSceneFinderPost", "cpFiles new MediaId mediaID " + ((cjl)localObject3).mediaId + " newMediaID " + MD5Util.getMD5String(((FinderMedia)localObject1).url));
                ((cjl)localObject3).mediaId = MD5Util.getMD5String(((FinderMedia)localObject1).url);
                if ((((cjl)localObject3).mediaType == 2) || (((cjl)localObject3).mediaType == 7))
                {
                  localObject2 = new k((cjl)localObject3, x.vEo, null, null, 12);
                  localObject4 = new k((cjl)localObject3, x.vEn, null, null, 12);
                  Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files thumbUrl " + ((cjl)localObject3).thumbUrl + " to path " + ((k)localObject2).getPath() + " url " + ((FinderMedia)localObject1).thumbUrl);
                  Log.i("Finder.LogPost.NetSceneFinderPost", "cp image files url " + ((cjl)localObject3).url + " to path " + ((k)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
                  com.tencent.mm.vfs.s.nw(((cjl)localObject3).thumbUrl, ((k)localObject2).getPath());
                  com.tencent.mm.vfs.s.nw(((cjl)localObject3).url, ((k)localObject4).getPath());
                }
                if (((cjl)localObject3).mediaType == 4)
                {
                  localObject2 = new k((cjl)localObject3, x.vEo, null, null, 12);
                  if (!com.tencent.mm.modelcontrol.e.sX(4)) {
                    break label922;
                  }
                }
              }
            }
          }
          label922:
          for (i = 2;; i = 1)
          {
            localObject4 = new com.tencent.mm.plugin.finder.loader.s((cjl)localObject3, x.vEA, i, null, 8);
            Object localObject5 = new com.tencent.mm.plugin.finder.loader.q((cjl)localObject3, x.vEn);
            com.tencent.mm.plugin.finder.loader.i locali = new com.tencent.mm.plugin.finder.loader.i((cjl)localObject3, x.vEo);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files thumbUrl " + ((cjl)localObject3).thumbUrl + " to path " + ((k)localObject2).getPath() + "  url " + ((FinderMedia)localObject1).thumbUrl);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp video files url " + ((cjl)localObject3).url + " to path " + ((com.tencent.mm.plugin.finder.loader.s)localObject4).getPath() + "  url " + ((FinderMedia)localObject1).url);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp cover files url " + ((cjl)localObject3).coverUrl + " to path " + ((com.tencent.mm.plugin.finder.loader.q)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
            Log.i("Finder.LogPost.NetSceneFinderPost", "cp fullThumb files url " + ((cjl)localObject3).MoR + " to path " + ((com.tencent.mm.plugin.finder.loader.q)localObject5).getPath() + "  url " + ((FinderMedia)localObject1).coverUrl);
            com.tencent.mm.vfs.s.nw(((cjl)localObject3).thumbUrl, ((k)localObject2).getPath());
            com.tencent.mm.vfs.s.nw(((cjl)localObject3).url, ((com.tencent.mm.plugin.finder.loader.s)localObject4).getPath());
            com.tencent.mm.vfs.s.nw(((cjl)localObject3).coverUrl, ((com.tencent.mm.plugin.finder.loader.q)localObject5).getPath());
            com.tencent.mm.vfs.s.nw(((cjl)localObject3).MoR, locali.getPath());
            long l = com.tencent.mm.vfs.s.boW(((cjl)localObject3).url);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.vGR;
            localObject5 = ((com.tencent.mm.plugin.finder.loader.s)localObject4).auA();
            localObject2 = ((cjl)localObject3).mediaId;
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = "";
            }
            localObject3 = ((cjl)localObject3).url;
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            com.tencent.mm.plugin.finder.storage.logic.d.a((String)localObject5, (String)localObject1, (String)localObject2, i, x.vEA.detail, l, l, 3, ((com.tencent.mm.plugin.finder.loader.s)localObject4).uIw.videoDuration, "", "");
            i = j;
            break;
            localObject1 = null;
            break label195;
          }
        }
      }
      label927:
      i = j;
    }
    AppMethodBeat.o(165256);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(242493);
    Log.i("Finder.LogPost.NetSceneFinderPost", "errType %d, errCode %d, errMsg %s, localId %s localId:" + this.tuX.getLocalId(), new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, Long.valueOf(this.localId) });
    Object localObject1;
    Object localObject2;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 5L, 1L, false);
      params = this.rr;
      if (params != null) {}
      for (params = params.aYK(); params == null; params = null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderPostResponse");
        AppMethodBeat.o(242493);
        throw paramString;
      }
      localObject1 = ((bar)params).LKm;
      localObject2 = new StringBuilder("onGYNetEnd ").append(localObject1).append(' ');
      if (localObject1 != null)
      {
        params = Long.valueOf(((FinderObject)localObject1).id);
        Log.i("Finder.LogPost.NetSceneFinderPost", params + ", localId:" + this.localId);
        params = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        if (!c.a.FR(this.localId)) {
          break label635;
        }
        localObject2 = this.feedObject.contact;
        if (localObject1 != null) {
          break label856;
        }
      }
    }
    label293:
    label822:
    label824:
    label832:
    label856:
    for (params = this.feedObject;; params = (com.tencent.mm.network.s)localObject1)
    {
      this.feedObject = params;
      FinderObject localFinderObject = this.feedObject;
      localObject1 = this.feedObject.nickname;
      params = (com.tencent.mm.network.s)localObject1;
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
        cZb();
        params = com.tencent.mm.plugin.finder.storage.data.e.vFX;
        params = e.a.Fy(this.feedObject.id);
        if (params != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
          localObject1 = com.tencent.mm.plugin.finder.upload.action.j.dBt().Ga(this.localId);
          boolean bool2 = ((Boolean)((kotlin.o)localObject1).first).booleanValue();
          bool1 = ((Boolean)((kotlin.o)localObject1).second).booleanValue();
          if (bool2)
          {
            localObject1 = com.tencent.mm.plugin.finder.upload.action.j.vUw;
            localObject1 = com.tencent.mm.plugin.finder.upload.action.j.dBt();
            long l = this.localId;
            p.h(params, "feed");
            Log.i(com.tencent.mm.plugin.finder.upload.action.j.TAG, "doLikeLocalFeed localId:" + l + ", isPrivate:" + bool1 + ", feedid:" + params.getId());
            localObject1 = (u)((com.tencent.mm.plugin.finder.upload.action.j)localObject1).vUu.get(Long.valueOf(l));
            if (localObject1 != null)
            {
              localObject2 = aj.uOw;
              localObject2 = ((u)localObject1).field_contextObj;
              p.g(localObject2, "action.field_contextObj");
              paramInt1 = ((u)localObject1).field_likeAction;
              int i = ((u)localObject1).field_scene;
              bool2 = ((u)localObject1).field_showTips;
              localObject1 = y.vXH;
              aj.a((bbn)localObject2, paramInt1, params, true, bool1, i, bool2, false, y.dnv());
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
            p.hyc();
          }
          params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.q)this);
        }
        params = com.tencent.mm.plugin.finder.spam.a.vwk;
        com.tencent.mm.plugin.finder.spam.a.v(paramInt2, paramInt3, paramString);
        AppMethodBeat.o(242493);
        return;
        params = null;
        break;
        params = null;
        break label293;
        label635:
        if (localObject1 != null)
        {
          params = z.aUg();
          p.g(params, "ConfigStorageLogic.getMyFinderUsername()");
          params = new av(params, (FinderObject)localObject1);
          com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)params);
        }
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 6L, 1L, false);
      params = r.d.vhx;
      r.d.oj(this.tuX.isLongVideo());
      params = com.tencent.mm.plugin.finder.spam.a.vwk;
      boolean bool1 = com.tencent.mm.plugin.finder.spam.a.gj(paramInt2, paramInt3);
      if (paramInt3 == -4013)
      {
        paramInt1 = 1;
        label731:
        if ((paramInt2 != 4) && (bool1) && (paramInt1 == 0)) {
          break label822;
        }
        params = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        params = c.a.FS(this.localId);
        if (params != null)
        {
          if (!bool1) {
            break label832;
          }
          if (paramInt1 == 0) {
            break label824;
          }
          params.setPostFailedAndNoAuth();
        }
      }
      for (;;)
      {
        this.tuX.field_localFlag = params.field_localFlag;
        localObject1 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        c.a.r(params);
        params = r.d.vhx;
        r.d.ob(this.tuX.isLongVideo());
        break;
        paramInt1 = 0;
        break label731;
        break;
        params.setPostFailed();
        continue;
        localObject1 = r.d.vhx;
        r.d.ok(this.tuX.isLongVideo());
        params.setPostFailedAndNotRetry(paramInt3);
      }
    }
  }
  
  public final b cXS()
  {
    return b.tye;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(165254);
    this.callback = parami;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165254);
    return i;
  }
  
  public final int getType()
  {
    return 3585;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderPost$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cb
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.data.u;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.atz;
import com.tencent.mm.protocal.protobuf.auc;
import com.tencent.mm.protocal.protobuf.bci;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bry;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.bzd;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "Lcom/tencent/mm/plugin/api/INetSceneFinderUserPage;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "topicId", "isOnlyFetchUserInfo", "", "biz_username", "clickFeedId", "scene", "refLiveObjectOd", "liveNoticeId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJZLjava/lang/String;JLjava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;)V", "allowPrefetch", "getAllowPrefetch", "()I", "setAllowPrefetch", "(I)V", "getBiz_username", "()Ljava/lang/String;", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "getClickFeedId", "()J", "continueFlag", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "setFansCount", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "setOnlyFetchUserInfo", "getLiveNoticeId", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getRefLiveObjectOd", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getReq_username", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "showJustWatch", "getShowJustWatch", "setShowJustWatch", "getTopicId", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "checkIsOnlyFetchUserInfo", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAccountLogOutUrl", "getBizInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "getCampaignInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getCurrentLiveInfo", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "getFinderUserPagePoi", "Lcom/tencent/mm/protocal/protobuf/FinderUserPagePoi;", "getFirstPageMD5", "getIsAccountLogOut", "getJumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getLastBuffer", "getLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getLiveNoticeListInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeListInfo;", "getMaxId", "getNextLiveNoticeInfo", "getPrivateLock", "getShopAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "getTopicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "getWeComInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWeComInfo;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "reqUserName", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class dt
  extends com.tencent.mm.plugin.findersdk.b.h
  implements com.tencent.mm.plugin.api.a
{
  public static final a ADB;
  private final Long AAD;
  private final Integer AAE;
  public final String ABB;
  public boolean ABD;
  public List<? extends FinderItem> ACl;
  public boolean ADC;
  private final String ADE;
  private final long ADF;
  public final long ADo;
  public int allowPrefetch;
  private com.tencent.mm.am.h callback;
  public int fansCount;
  public int friendFollowCount;
  private final int hJx;
  private final String liveNoticeId;
  public int pullType;
  public com.tencent.mm.am.c rr;
  public int showJustWatch;
  public LinkedList<String> userTags;
  
  static
  {
    AppMethodBeat.i(165291);
    ADB = new a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public dt(String paramString1, long paramLong1, com.tencent.mm.bx.b paramb, int paramInt1, bui parambui, int paramInt2, long paramLong2, boolean paramBoolean, String paramString2, long paramLong3, Integer paramInteger, Long paramLong, String paramString3)
  {
    super(parambui);
    AppMethodBeat.i(336808);
    this.ABB = paramString1;
    this.hJx = paramInt2;
    this.ADo = paramLong2;
    this.ADC = paramBoolean;
    this.ADE = paramString2;
    this.ADF = paramLong3;
    this.AAE = paramInteger;
    this.AAD = paramLong;
    this.liveNoticeId = paramString3;
    this.ABD = true;
    this.userTags = new LinkedList();
    paramString1 = com.tencent.mm.plugin.finder.api.d.AwY;
    paramString1 = com.tencent.mm.plugin.finder.api.d.a.auT(this.ABB);
    if (paramString1 == null)
    {
      paramString1 = "";
      paramString2 = new c.a();
      paramString2.uri = "/cgi-bin/micromsg-bin/finderuserpage";
      paramString2.funcId = getType();
      paramInteger = new byn();
      paramInteger.username = this.ABB;
      paramInteger.maxId = paramLong1;
      paramInteger.firstPageMD5 = paramString1;
      paramInteger.YIZ = z.bAW();
      paramInteger.hJx = this.hJx;
      paramInteger.ADo = this.ADo;
      paramLong = bi.ABn;
      paramInteger.CJv = bi.a(parambui);
      paramLong = paramInteger.CJv;
      if (paramLong != null)
      {
        if (parambui != null) {
          break label682;
        }
        paramInt2 = 0;
        label235:
        paramLong.scene = paramInt2;
      }
      if (!n.T(paramInteger.username, paramInteger.YIZ, false))
      {
        parambui = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.eWc().bmg()).booleanValue()) {
          break label692;
        }
      }
      paramInt2 = 1;
      label282:
      paramInteger.ZDP = paramInt2;
      paramInteger.lastBuffer = paramb;
      paramb = bi.ABn;
      paramInteger.ZDQ = bi.bTZ();
      paramb = com.tencent.mm.ui.component.k.aeZF;
      paramb = ((com.tencent.mm.plugin.finder.viewmodel.b)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.b.class)).dUh();
      paramInteger.longitude = ((Number)paramb.bsC).floatValue();
      paramInteger.latitude = ((Number)paramb.bsD).floatValue();
      paramb = this.AAE;
      if (paramb != null) {
        break label698;
      }
      paramInt2 = 0;
      label380:
      paramInteger.scene = paramInt2;
      paramb = this.AAD;
      if (paramb != null) {
        break label708;
      }
      paramLong2 = 0L;
      label401:
      paramInteger.aahl = paramLong2;
      paramInteger.ZNN = this.liveNoticeId;
      if (this.ADF == 0L) {
        break label718;
      }
      paramLong2 = this.ADF;
      label432:
      paramInteger.object_id = paramLong2;
      if (((CharSequence)this.ADE).length() <= 0) {
        break label745;
      }
      paramInt2 = 1;
      label457:
      if (paramInt2 != 0)
      {
        if (this.ADF == 0L) {
          break label751;
        }
        paramInt2 = 23;
        label475:
        paramInteger.ACR = paramInt2;
        paramInteger.ADE = this.ADE;
      }
      paramb = bi.ABn;
      paramb = paramInteger.CJv;
      parambui = paramInteger.CJv;
      if (parambui != null) {
        break label758;
      }
    }
    label682:
    label692:
    label698:
    label708:
    label718:
    label745:
    label751:
    label758:
    for (paramInt2 = 0;; paramInt2 = parambui.scene)
    {
      bi.a(paramb, kotlin.a.p.listOf(new r(Integer.valueOf(paramInt2), Long.valueOf(this.ADo))));
      paramb = new FinderUserPageResponse();
      paramString2.otE = ((com.tencent.mm.bx.a)paramInteger);
      paramString2.otF = ((com.tencent.mm.bx.a)paramb);
      paramb = paramString2.bEF();
      kotlin.g.b.s.s(paramb, "builder.buildInstance()");
      this.rr = paramb;
      this.pullType = paramInt1;
      Log.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong1 + " username " + this.ABB + " pullType " + paramInt1 + " fpMD5 " + paramString1);
      AppMethodBeat.o(336808);
      return;
      paramString1 = paramString1.field_firstPageMD5;
      if (paramString1 == null)
      {
        paramString1 = "";
        break;
      }
      break;
      paramInt2 = parambui.hLK;
      break label235;
      paramInt2 = 0;
      break label282;
      paramInt2 = paramb.intValue();
      break label380;
      paramLong2 = paramb.longValue();
      break label401;
      paramb = this.AAD;
      if (paramb == null)
      {
        paramLong2 = 0L;
        break label432;
      }
      paramLong2 = paramb.longValue();
      break label432;
      paramInt2 = 0;
      break label457;
      paramInt2 = 24;
      break label475;
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336848);
    Log.i("Finder.NetSceneFinderUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject4;
    label201:
    Object localObject1;
    Object localObject5;
    label329:
    label345:
    label1262:
    Object localObject3;
    label1237:
    label1240:
    label1371:
    label1381:
    boolean bool;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 13L, 1L, false);
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(336848);
        throw paramString;
      }
      FinderUserPageResponse localFinderUserPageResponse = (FinderUserPageResponse)params;
      Object localObject2 = this.ABB;
      localObject4 = this.ADE;
      params = localFinderUserPageResponse.userTags;
      kotlin.g.b.s.s(params, "resp.userTags");
      this.userTags = params;
      this.friendFollowCount = localFinderUserPageResponse.friendFollowCount;
      this.fansCount = localFinderUserPageResponse.fansCount;
      params = localFinderUserPageResponse.just_watch;
      if (params == null) {
        paramInt1 = 0;
      }
      for (;;)
      {
        this.showJustWatch = paramInt1;
        params = localFinderUserPageResponse.just_watch;
        if (params == null)
        {
          paramInt1 = 0;
          this.allowPrefetch = paramInt1;
          params = com.tencent.mm.plugin.finder.preload.a.EUs;
          params = localFinderUserPageResponse.preloadInfo;
          localObject1 = localFinderUserPageResponse.object;
          kotlin.g.b.s.s(localObject1, "resp.`object`");
          com.tencent.mm.plugin.finder.preload.a.a(params, (List)localObject1, 3736);
          localObject5 = localFinderUserPageResponse.contact;
          if (localObject5 != null)
          {
            Log.i("Finder.NetSceneFinderUserPage", "contact info " + com.tencent.mm.ae.f.dg(localObject5) + " fansCount: " + localFinderUserPageResponse.fansCount + " friendFollowCount:" + localFinderUserPageResponse.friendFollowCount);
            localObject1 = ((FinderContact)localObject5).username;
            if (localObject1 != null) {
              break label1237;
            }
            localObject1 = "";
            params = com.tencent.mm.plugin.finder.api.c.b((FinderContact)localObject5);
            if (params != null) {
              break label1240;
            }
            params = "";
            localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
            com.tencent.mm.plugin.finder.api.d.a.d((FinderContact)localObject5);
            localObject2 = (CharSequence)((FinderContact)localObject5).username;
            if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
              break label1262;
            }
            paramInt1 = 1;
            if ((paramInt1 == 0) && (!kotlin.g.b.s.p(((FinderContact)localObject5).username, this.ABB)))
            {
              localObject2 = (com.tencent.mm.bx.a)new FinderContact();
              localObject4 = ((FinderContact)localObject5).toByteArray();
            }
          }
        }
        try
        {
          ((com.tencent.mm.bx.a)localObject2).parseFrom((byte[])localObject4);
          localObject2 = (FinderContact)localObject2;
          if (localObject2 != null)
          {
            ((FinderContact)localObject2).username = this.ABB;
            localObject4 = com.tencent.mm.plugin.finder.api.d.AwY;
            com.tencent.mm.plugin.finder.api.d.a.d((FinderContact)localObject2);
            Log.i("Finder.NetSceneFinderUserPage", "duplicate contact for " + this.ABB + ", " + (String)localObject1);
            localObject2 = ah.aiuX;
            localObject2 = ah.aiuX;
          }
          localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
          localObject6 = com.tencent.mm.plugin.finder.api.d.a.auT(((FinderContact)localObject5).username);
          localObject2 = localObject1;
          localObject4 = params;
          if (localObject6 != null)
          {
            ((com.tencent.mm.plugin.finder.api.m)localObject6).field_firstPageMD5 = localFinderUserPageResponse.firstPageMD5;
            localObject2 = com.tencent.mm.plugin.finder.api.d.AwY;
            com.tencent.mm.plugin.finder.api.d.a.d((com.tencent.mm.plugin.finder.api.m)localObject6);
            if (kotlin.g.b.s.p(((com.tencent.mm.plugin.finder.api.m)localObject6).getUsername(), z.bAW()))
            {
              if (localFinderUserPageResponse.fansCount > 0) {
                com.tencent.mm.kernel.h.baE().ban().set(at.a.adcP, Integer.valueOf(localFinderUserPageResponse.fansCount));
              }
              localObject4 = com.tencent.mm.kernel.h.baE().ban();
              localObject6 = at.a.acZS;
              localObject2 = localFinderUserPageResponse.contact;
              if (localObject2 == null)
              {
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject4 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.acZT;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1302;
                }
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject4 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.acZU;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1312;
                }
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject4 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.acZW;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1322;
                }
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject4 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.adbs;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1332;
                }
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject4 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.adag;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1345;
                }
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject4 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.adal;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1358;
                }
                localObject2 = null;
                ((aq)localObject4).set((at.a)localObject6, localObject2);
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1371;
                }
                localObject2 = null;
                if (localObject2 != null)
                {
                  localObject4 = com.tencent.mm.kernel.h.baE().ban();
                  localObject6 = at.a.adah;
                  localObject2 = localFinderUserPageResponse.contact;
                  if (localObject2 != null) {
                    break label1381;
                  }
                  localObject2 = null;
                  ((aq)localObject4).set((at.a)localObject6, localObject2);
                  localObject4 = com.tencent.mm.kernel.h.baE().ban();
                  localObject6 = at.a.adai;
                  localObject2 = localFinderUserPageResponse.contact;
                  if (localObject2 != null) {
                    break label1412;
                  }
                  localObject2 = null;
                  ((aq)localObject4).set((at.a)localObject6, localObject2);
                  localObject4 = com.tencent.mm.kernel.h.baE().ban();
                  localObject6 = at.a.adaj;
                  localObject2 = localFinderUserPageResponse.contact;
                  if (localObject2 != null) {
                    break label1443;
                  }
                  localObject2 = null;
                  ((aq)localObject4).set((at.a)localObject6, localObject2);
                  localObject4 = com.tencent.mm.kernel.h.baE().ban();
                  localObject6 = at.a.adak;
                  localObject2 = localFinderUserPageResponse.contact;
                  if (localObject2 != null) {
                    break label1474;
                  }
                  localObject2 = null;
                  ((aq)localObject4).set((at.a)localObject6, localObject2);
                  localObject4 = com.tencent.mm.kernel.h.baE().ban();
                  localObject6 = at.a.adan;
                  localObject2 = localFinderUserPageResponse.contact;
                  if (localObject2 != null) {
                    break label1505;
                  }
                  localObject2 = null;
                  ((aq)localObject4).set((at.a)localObject6, localObject2);
                }
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1536;
                }
                localObject2 = null;
                if (localObject2 != null) {
                  break label1546;
                }
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acZV, "");
                localObject5 = com.tencent.mm.kernel.h.baE().ban();
                localObject6 = at.a.adaE;
                localObject2 = localFinderUserPageResponse.contact;
                if (localObject2 != null) {
                  break label1599;
                }
                localObject2 = "";
                ((aq)localObject5).set((at.a)localObject6, localObject2);
              }
            }
            else
            {
              localObject2 = ah.aiuX;
              localObject2 = ah.aiuX;
              localObject4 = params;
              localObject2 = localObject1;
            }
          }
          else
          {
            if (!this.ADC) {
              break label1622;
            }
            Log.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
            if (this.callback != null)
            {
              params = this.callback;
              kotlin.g.b.s.checkNotNull(params);
              params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
              paramString = ah.aiuX;
              paramString = ah.aiuX;
            }
            AppMethodBeat.o(336848);
            return;
            paramInt1 = params.ZNo;
            continue;
            paramInt1 = params.ZNp;
            break label201;
            break label329;
            params = params.ADE;
            if (params == null)
            {
              params = "";
              break label345;
            }
            break label345;
            paramInt1 = 0;
          }
        }
        catch (Exception localException)
        {
          Object localObject6;
          for (;;)
          {
            Log.printDebugStack("safeParser", "", new Object[] { localException });
            localObject3 = null;
            continue;
            localObject3 = ((FinderContact)localObject3).nickname;
            continue;
            label1302:
            localObject3 = ((FinderContact)localObject3).signature;
            continue;
            label1312:
            localObject3 = ((FinderContact)localObject3).headUrl;
            continue;
            label1322:
            localObject3 = ((FinderContact)localObject3).coverImgUrl;
            continue;
            label1332:
            localObject3 = Integer.valueOf(((FinderContact)localObject3).extFlag);
            continue;
            label1345:
            localObject3 = Integer.valueOf(((FinderContact)localObject3).originalFlag);
            continue;
            label1358:
            localObject3 = Integer.valueOf(((FinderContact)localObject3).originalEntranceFlag);
            continue;
            localObject3 = ((FinderContact)localObject3).originalInfo;
            continue;
            localObject3 = ((FinderContact)localObject3).originalInfo;
            if (localObject3 == null)
            {
              localObject3 = null;
            }
            else
            {
              localObject3 = Integer.valueOf(((bry)localObject3).ZZW);
              continue;
              label1412:
              localObject3 = ((FinderContact)localObject3).originalInfo;
              if (localObject3 == null)
              {
                localObject3 = null;
              }
              else
              {
                localObject3 = Integer.valueOf(((bry)localObject3).ZZX);
                continue;
                label1443:
                localObject3 = ((FinderContact)localObject3).originalInfo;
                if (localObject3 == null)
                {
                  localObject3 = null;
                }
                else
                {
                  localObject3 = Integer.valueOf(((bry)localObject3).ZZY);
                  continue;
                  label1474:
                  localObject3 = ((FinderContact)localObject3).originalInfo;
                  if (localObject3 == null)
                  {
                    localObject3 = null;
                  }
                  else
                  {
                    localObject3 = Integer.valueOf(((bry)localObject3).ZZZ);
                    continue;
                    label1505:
                    localObject3 = ((FinderContact)localObject3).originalInfo;
                    if (localObject3 == null)
                    {
                      localObject3 = null;
                    }
                    else
                    {
                      localObject3 = Integer.valueOf(((bry)localObject3).aaaa);
                      continue;
                      label1536:
                      localObject3 = ((FinderContact)localObject3).authInfo;
                      continue;
                      label1546:
                      localObject4 = com.tencent.mm.kernel.h.baE().ban();
                      localObject6 = at.a.acZV;
                      localObject3 = ((FinderContact)localObject5).authInfo;
                      if (localObject3 == null) {}
                      for (localObject3 = null;; localObject3 = ((FinderAuthInfo)localObject3).toByteArray())
                      {
                        ((aq)localObject4).set((at.a)localObject6, Util.encodeHexString((byte[])localObject3));
                        break;
                      }
                      label1599:
                      localObject4 = ((FinderContact)localObject3).liveCoverImgUrl;
                      localObject3 = localObject4;
                      if (localObject4 == null) {
                        localObject3 = "";
                      }
                    }
                  }
                }
              }
            }
          }
          label1622:
          params = localFinderUserPageResponse.object;
          kotlin.g.b.s.checkNotNull(params);
          localObject1 = new StringBuilder("cgiBack: continueFlag:").append(localFinderUserPageResponse.continueFlag).append(", list:");
          localObject5 = bg.ABl;
          Log.i("Finder.NetSceneFinderUserPage", bg.fV((List)params));
          Log.i("Finder.NetSceneFinderUserPage", kotlin.g.b.s.X("onGYNetEnd list:", Integer.valueOf(params.size())));
          if (localFinderUserPageResponse.continueFlag == 1)
          {
            bool = true;
            this.ABD = bool;
            if (this.pullType == 2) {
              break label1822;
            }
          }
          label1822:
          for (bool = true;; bool = false)
          {
            localObject1 = (Iterable)params;
            params = (Collection)new ArrayList();
            localObject1 = ((Iterable)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject5 = ((Iterator)localObject1).next();
              localObject6 = (FinderObject)localObject5;
              av localav = av.GiL;
              if (av.y((FinderObject)localObject6)) {
                params.add(localObject5);
              }
            }
            bool = false;
            break;
          }
          params = (List)params;
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          this.ACl = com.tencent.mm.plugin.finder.storage.logic.d.a.a(params, 2, getContextObj());
          if (!bool) {
            break label2050;
          }
        }
      }
      if (this.ADo == 0L)
      {
        params = this.ACl;
        if (params != null)
        {
          if (this.hJx != 1) {
            break label2131;
          }
          localObject1 = new LinkedList();
          localObject3 = ((Iterable)params).iterator();
          label1990:
          while (((Iterator)localObject3).hasNext())
          {
            localObject4 = (FinderItem)((Iterator)localObject3).next();
            params = ((FinderItem)localObject4).getMegaVideo();
            if (params == null) {}
            for (params = null;; params = Long.valueOf(params.id))
            {
              if (params == null) {
                break label1990;
              }
              ((LinkedList)localObject1).add(new u(params.longValue(), 32768, ((FinderItem)localObject4).getFeedObject()));
              break;
            }
          }
          if (((LinkedList)localObject1).size() > 0)
          {
            params = com.tencent.mm.plugin.finder.storage.data.k.FNg;
            if (!TextUtils.isEmpty((CharSequence)this.ABB)) {
              break label2122;
            }
            params = z.bAW();
            kotlin.g.b.s.s(params, "if (TextUtils.isEmpty(re…rname() else req_username");
            k.a.a(13, params, (LinkedList)localObject1);
          }
          label2040:
          params = ah.aiuX;
          params = ah.aiuX;
        }
      }
      label2050:
      params = com.tencent.mm.plugin.finder.api.d.AwY;
      com.tencent.mm.plugin.finder.api.d.a.N(this.ABB, localFinderUserPageResponse.logout_lock, localFinderUserPageResponse.logout_url);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.am.p)this);
        paramString = ah.aiuX;
        paramString = ah.aiuX;
      }
      AppMethodBeat.o(336848);
      return;
      label2122:
      params = this.ABB;
      break;
      label2131:
      localObject1 = (CharSequence)localObject4;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {
        paramInt1 = 1;
      }
      for (;;)
      {
        if (paramInt1 == 0)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
          localObject1 = (Iterable)params;
          params = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              localObject3 = (FinderItem)((Iterator)localObject1).next();
              localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
              params.add(com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject3));
              continue;
              paramInt1 = 0;
              break;
            }
          }
          com.tencent.mm.plugin.finder.storage.logic.d.a.v((List)params, (String)localObject4);
          break;
        }
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      localObject1 = (Iterable)params;
      params = (Collection)new ArrayList(kotlin.a.p.a((Iterable)localObject1, 10));
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject4 = (FinderItem)((Iterator)localObject1).next();
        localObject5 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
        params.add(com.tencent.mm.plugin.finder.storage.logic.d.a.a((FinderItem)localObject4));
      }
      com.tencent.mm.plugin.finder.storage.logic.d.a.a((List)params, 2, (String)localObject3, bool);
      break label2040;
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 14L, 1L, false);
    }
  }
  
  public final FinderContact caK()
  {
    AppMethodBeat.i(336865);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336865);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).contact;
    AppMethodBeat.o(336865);
    return localObject;
  }
  
  public final boolean caL()
  {
    return this.ADC;
  }
  
  public final String caM()
  {
    return this.ABB;
  }
  
  public final int caN()
  {
    return this.friendFollowCount;
  }
  
  public final bkk caO()
  {
    AppMethodBeat.i(336911);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336911);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).liveNoticeInfo;
    AppMethodBeat.o(336911);
    return localObject;
  }
  
  public final FinderObject caP()
  {
    AppMethodBeat.i(336919);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336919);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).object;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…serPageResponse).`object`");
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      FinderObjectDesc localFinderObjectDesc = ((FinderObject)localObject).objectDesc;
      if ((localFinderObjectDesc != null) && (localFinderObjectDesc.mediaType == 9))
      {
        i = 1;
        label107:
        if (i == 0) {
          break label127;
        }
      }
    }
    for (;;)
    {
      localObject = (FinderObject)localObject;
      AppMethodBeat.o(336919);
      return localObject;
      i = 0;
      break label107;
      label127:
      break;
      localObject = null;
    }
  }
  
  public final bzd dWB()
  {
    AppMethodBeat.i(336881);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336881);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).wxaShopInfo;
    AppMethodBeat.o(336881);
    return localObject;
  }
  
  public final bkl dWC()
  {
    AppMethodBeat.i(336885);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336885);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).live_notice_list_info;
    AppMethodBeat.o(336885);
    return localObject;
  }
  
  public final List<FinderJumpInfo> dWD()
  {
    AppMethodBeat.i(336892);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336892);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).jump_info;
    kotlin.g.b.s.s(localObject, "rr.responseProtoBuf as F…erPageResponse).jump_info");
    localObject = (List)localObject;
    AppMethodBeat.o(336892);
    return localObject;
  }
  
  public final bzb dWE()
  {
    AppMethodBeat.i(336900);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336900);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).contact;
    if (localObject == null)
    {
      AppMethodBeat.o(336900);
      return null;
    }
    localObject = ((FinderContact)localObject).bind_info;
    if (localObject == null)
    {
      AppMethodBeat.o(336900);
      return null;
    }
    Iterator localIterator = ((Iterable)localObject).iterator();
    int i;
    if (localIterator.hasNext())
    {
      localObject = localIterator.next();
      if (((auc)localObject).ZEC == 2)
      {
        i = 1;
        label116:
        if (i == 0) {
          break label140;
        }
      }
    }
    for (;;)
    {
      localObject = (auc)localObject;
      if (localObject != null) {
        break label147;
      }
      AppMethodBeat.o(336900);
      return null;
      i = 0;
      break label116;
      label140:
      break;
      localObject = null;
    }
    label147:
    localObject = ((auc)localObject).ZED;
    AppMethodBeat.o(336900);
    return localObject;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165289);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (com.tencent.mm.network.m)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final com.tencent.mm.bx.b getLastBuffer()
  {
    AppMethodBeat.i(336878);
    Object localObject = c.c.b(this.rr.otC);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(336878);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).lastBuffer;
    AppMethodBeat.o(336878);
    return localObject;
  }
  
  public final long getMaxId()
  {
    AppMethodBeat.i(336860);
    Object localObject = c.b.b(this.rr.otB);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
      AppMethodBeat.o(336860);
      throw ((Throwable)localObject);
    }
    long l = ((byn)localObject).maxId;
    AppMethodBeat.o(336860);
    return l;
  }
  
  public final int getType()
  {
    return 3736;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "ERRCODE_LOGOUT", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.dt
 * JD-Core Version:    0.7.0.1
 */
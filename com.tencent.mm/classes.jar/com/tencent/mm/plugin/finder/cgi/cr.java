package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.k;
import com.tencent.mm.plugin.finder.storage.data.k.a;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.logic.c.a;
import com.tencent.mm.plugin.finder.utils.aj;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.bgi;
import com.tencent.mm.protocal.protobuf.bhh;
import com.tencent.mm.protocal.protobuf.bid;
import com.tencent.mm.protocal.protobuf.blb;
import com.tencent.mm.protocal.protobuf.bln;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.o;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "topicId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getAccountLogOutUrl", "getBizInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "getCampaignInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "getFirstPageMD5", "getIsAccountLogOut", "getLastBuffer", "getLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getMaxId", "getPrivateLock", "getShopAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "getTopicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cr
  extends com.tencent.mm.plugin.findersdk.b.g
{
  public static final a xes;
  private com.tencent.mm.an.i callback;
  private final int fEH;
  public int fansCount;
  public int friendFollowCount;
  public int pullType;
  public com.tencent.mm.an.d rr;
  public LinkedList<String> userTags;
  public List<? extends FinderItem> xcV;
  public boolean xcp;
  public final String xcq;
  public final long xee;
  public boolean xer;
  
  static
  {
    AppMethodBeat.i(165291);
    xes = new a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public cr(String paramString, long paramLong1, b paramb, int paramInt1, bid parambid, int paramInt2, long paramLong2)
  {
    super(parambid);
    AppMethodBeat.i(278682);
    this.xcq = paramString;
    this.fEH = paramInt2;
    this.xee = paramLong2;
    this.xcp = true;
    this.userTags = new LinkedList();
    paramString = com.tencent.mm.plugin.finder.api.d.wZQ;
    paramString = com.tencent.mm.plugin.finder.api.d.a.aAK(this.xcq);
    if (paramString != null)
    {
      paramString = paramString.field_firstPageMD5;
      if (paramString != null) {}
    }
    else
    {
      paramString = "";
    }
    for (;;)
    {
      com.tencent.mm.an.d.a locala = new com.tencent.mm.an.d.a();
      locala.TW("/cgi-bin/micromsg-bin/finderuserpage");
      locala.vD(getType());
      blb localblb = new blb();
      localblb.username = this.xcq;
      localblb.JVf = paramLong1;
      localblb.firstPageMD5 = paramString;
      localblb.RLN = z.bdh();
      localblb.fEH = this.fEH;
      localblb.xee = this.xee;
      Object localObject = ao.xcj;
      localblb.yjp = ao.a(parambid);
      localObject = localblb.yjp;
      if (localObject != null)
      {
        if (parambid != null)
        {
          paramInt2 = parambid.fGo;
          ((aqe)localObject).scene = paramInt2;
        }
      }
      else
      {
        if (!n.L(localblb.username, localblb.RLN, false))
        {
          parambid = com.tencent.mm.plugin.finder.storage.d.AjH;
          if (!((Boolean)com.tencent.mm.plugin.finder.storage.d.dXn().aSr()).booleanValue()) {
            break label455;
          }
        }
        paramInt2 = 1;
        label245:
        localblb.SCV = paramInt2;
        localblb.lastBuffer = paramb;
        paramb = ao.xcj;
        localblb.SCW = ao.dnP();
        paramb = ao.xcj;
        paramb = localblb.yjp;
        parambid = localblb.yjp;
        if (parambid == null) {
          break label461;
        }
      }
      label455:
      label461:
      for (paramInt2 = parambid.scene;; paramInt2 = 0)
      {
        ao.a(paramb, j.listOf(new o(Integer.valueOf(paramInt2), Long.valueOf(this.xee))));
        paramb = new FinderUserPageResponse();
        locala.c((com.tencent.mm.cd.a)localblb);
        locala.d((com.tencent.mm.cd.a)paramb);
        paramb = locala.bgN();
        p.j(paramb, "builder.buildInstance()");
        this.rr = paramb;
        this.pullType = paramInt1;
        Log.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong1 + " username " + this.xcq + " pullType " + paramInt1 + " fpMD5 " + paramString);
        AppMethodBeat.o(278682);
        return;
        paramInt2 = 0;
        break;
        paramInt2 = 0;
        break label245;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(278677);
    Log.i("Finder.NetSceneFinderUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    FinderUserPageResponse localFinderUserPageResponse;
    Object localObject1;
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 13L, 1L, false);
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(278677);
        throw paramString;
      }
      localFinderUserPageResponse = (FinderUserPageResponse)params;
      params = this.xcq;
      localObject1 = localFinderUserPageResponse.userTags;
      p.j(localObject1, "resp.userTags");
      this.userTags = ((LinkedList)localObject1);
      this.friendFollowCount = localFinderUserPageResponse.friendFollowCount;
      this.fansCount = localFinderUserPageResponse.fansCount;
      localObject1 = com.tencent.mm.plugin.finder.preload.a.zKe;
      localObject1 = localFinderUserPageResponse.preloadInfo;
      localObject3 = localFinderUserPageResponse.object;
      p.j(localObject3, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((bhh)localObject1, (List)localObject3, 3736);
      localObject3 = localFinderUserPageResponse.contact;
      if (localObject3 != null)
      {
        params = new StringBuilder("contact info ");
        p.j(localObject3, "it");
        Log.i("Finder.NetSceneFinderUserPage", com.tencent.mm.ae.g.bN(localObject3) + " fansCount: " + localFinderUserPageResponse.fansCount + " friendFollowCount:" + localFinderUserPageResponse.friendFollowCount);
        params = ((FinderContact)localObject3).username;
        if (params != null) {
          break label2270;
        }
        params = "";
      }
    }
    label1873:
    label2270:
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
      com.tencent.mm.plugin.finder.api.d.a.a((FinderContact)localObject3);
      localObject1 = (CharSequence)((FinderContact)localObject3).username;
      if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
      {
        paramInt1 = 1;
        if ((paramInt1 == 0) && ((p.h(((FinderContact)localObject3).username, this.xcq) ^ true)))
        {
          localObject1 = (com.tencent.mm.cd.a)new FinderContact();
          localObject4 = ((FinderContact)localObject3).toByteArray();
        }
      }
      Object localObject5;
      for (;;)
      {
        try
        {
          ((com.tencent.mm.cd.a)localObject1).parseFrom((byte[])localObject4);
          localObject1 = (FinderContact)localObject1;
          if (localObject1 != null)
          {
            ((FinderContact)localObject1).username = this.xcq;
            localObject4 = com.tencent.mm.plugin.finder.api.d.wZQ;
            com.tencent.mm.plugin.finder.api.d.a.a((FinderContact)localObject1);
            Log.i("Finder.NetSceneFinderUserPage", "duplicate contact for " + this.xcq + ", " + params);
            localObject1 = x.aazN;
          }
          localObject1 = com.tencent.mm.plugin.finder.api.d.wZQ;
          localObject1 = com.tencent.mm.plugin.finder.api.d.a.aAK(((FinderContact)localObject3).username);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.finder.api.i)localObject1).field_firstPageMD5 = localFinderUserPageResponse.firstPageMD5;
            localObject4 = com.tencent.mm.plugin.finder.api.d.wZQ;
            com.tencent.mm.plugin.finder.api.d.a.c((com.tencent.mm.plugin.finder.api.i)localObject1);
            if (p.h(((com.tencent.mm.plugin.finder.api.i)localObject1).getUsername(), z.bdh()))
            {
              if (localFinderUserPageResponse.fansCount > 0)
              {
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VAx, Integer.valueOf(localFinderUserPageResponse.fansCount));
              }
              localObject1 = h.aHG();
              p.j(localObject1, "MMKernel.storage()");
              localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
              localObject5 = ar.a.VxY;
              localObject1 = localFinderUserPageResponse.contact;
              if (localObject1 != null)
              {
                localObject1 = ((FinderContact)localObject1).nickname;
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.VxZ;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).signature;
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.Vya;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).headUrl;
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.Vyc;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).coverImgUrl;
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.Vzn;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = Integer.valueOf(((FinderContact)localObject1).extFlag);
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.Vyl;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = Integer.valueOf(((FinderContact)localObject1).originalFlag);
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.Vyq;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = Integer.valueOf(((FinderContact)localObject1).originalEntranceFlag);
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).originalInfo;
                if (localObject1 != null)
                {
                  localObject1 = h.aHG();
                  p.j(localObject1, "MMKernel.storage()");
                  localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                  localObject5 = ar.a.Vym;
                  localObject1 = localFinderUserPageResponse.contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bgi)localObject1).SRe);
                  ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                  localObject1 = h.aHG();
                  p.j(localObject1, "MMKernel.storage()");
                  localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                  localObject5 = ar.a.Vyn;
                  localObject1 = localFinderUserPageResponse.contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bgi)localObject1).SRf);
                  ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                  localObject1 = h.aHG();
                  p.j(localObject1, "MMKernel.storage()");
                  localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                  localObject5 = ar.a.Vyo;
                  localObject1 = localFinderUserPageResponse.contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bgi)localObject1).SRg);
                  ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                  localObject1 = h.aHG();
                  p.j(localObject1, "MMKernel.storage()");
                  localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                  localObject5 = ar.a.Vyp;
                  localObject1 = localFinderUserPageResponse.contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bgi)localObject1).SRh);
                  ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                  localObject1 = h.aHG();
                  p.j(localObject1, "MMKernel.storage()");
                  localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                  localObject5 = ar.a.Vys;
                  localObject1 = localFinderUserPageResponse.contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bgi)localObject1).SRi);
                  ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
                }
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).authInfo;
                if (localObject1 != null) {
                  continue;
                }
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.Vyb, "");
                localObject1 = h.aHG();
                p.j(localObject1, "MMKernel.storage()");
                localObject4 = ((com.tencent.mm.kernel.f)localObject1).aHp();
                localObject5 = ar.a.VyI;
                localObject1 = localFinderUserPageResponse.contact;
                if (localObject1 != null)
                {
                  localObject3 = ((FinderContact)localObject1).liveCoverImgUrl;
                  localObject1 = localObject3;
                  if (localObject3 != null) {}
                }
                else
                {
                  localObject1 = "";
                }
                ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, localObject1);
              }
            }
            else
            {
              localObject1 = x.aazN;
              if (!this.xer) {
                break label1663;
              }
              Log.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
              if (this.callback != null)
              {
                params = this.callback;
                if (params == null) {
                  p.iCn();
                }
                params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
                paramString = x.aazN;
              }
              AppMethodBeat.o(278677);
              return;
              paramInt1 = 0;
            }
          }
        }
        catch (Exception localException)
        {
          Log.printDebugStack("safeParser", "", new Object[] { localException });
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = null;
          continue;
          localObject2 = h.aHG();
          p.j(localObject2, "MMKernel.storage()");
          localObject4 = ((com.tencent.mm.kernel.f)localObject2).aHp();
          localObject5 = ar.a.Vyb;
          localObject2 = ((FinderContact)localObject3).authInfo;
          if (localObject2 != null)
          {
            localObject2 = ((FinderAuthInfo)localObject2).toByteArray();
            ((com.tencent.mm.storage.ao)localObject4).set((ar.a)localObject5, Util.encodeHexString((byte[])localObject2));
          }
          else
          {
            localObject2 = null;
            continue;
          }
        }
      }
      label1663:
      Object localObject2 = localFinderUserPageResponse.object;
      if (localObject2 == null) {
        p.iCn();
      }
      localObject3 = new StringBuilder("cgiBack: continueFlag:").append(localFinderUserPageResponse.continueFlag).append(", list:");
      Object localObject4 = am.xch;
      Log.i("Finder.NetSceneFinderUserPage", am.dY((List)localObject2));
      Log.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + ((LinkedList)localObject2).size());
      if (localFinderUserPageResponse.continueFlag == 1)
      {
        bool = true;
        this.xcp = bool;
        if (this.pullType == 2) {
          break label1873;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (FinderObject)localObject4;
          aj localaj = aj.AGc;
          if (aj.w((FinderObject)localObject5)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        bool = false;
        break;
      }
      localObject2 = (List)localObject2;
      localObject3 = c.AnK;
      this.xcV = c.a.a((List)localObject2, 2, this.xbu);
      if ((bool) && (this.xee == 0L))
      {
        localObject3 = this.xcV;
        if (localObject3 != null)
        {
          if (this.fEH != 1) {
            break label2154;
          }
          localObject2 = new LinkedList();
          params = ((Iterable)localObject3).iterator();
          while (params.hasNext())
          {
            localObject3 = (FinderItem)params.next();
            localObject4 = ((FinderItem)localObject3).getMegaVideo();
            if (localObject4 != null) {
              ((LinkedList)localObject2).add(new com.tencent.mm.plugin.finder.storage.data.t(((cvy)localObject4).id, 32768, ((FinderItem)localObject3).getFeedObject()));
            }
          }
          if (((LinkedList)localObject2).size() > 0)
          {
            params = k.Anu;
            if (!TextUtils.isEmpty((CharSequence)this.xcq)) {
              break label2145;
            }
            params = z.bdh();
            p.j(params, "if (TextUtils.isEmpty(re…rname() else req_username");
            k.a.a(13, params, (LinkedList)localObject2);
          }
          params = x.aazN;
        }
      }
      params = com.tencent.mm.plugin.finder.api.d.wZQ;
      com.tencent.mm.plugin.finder.api.d.a.L(this.xcq, localFinderUserPageResponse.logout_lock, localFinderUserPageResponse.logout_url);
      for (;;)
      {
        if (this.callback != null)
        {
          params = this.callback;
          if (params == null) {
            p.iCn();
          }
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
          paramString = x.aazN;
        }
        AppMethodBeat.o(278677);
        return;
        label2145:
        params = this.xcq;
        break;
        label2154:
        localObject2 = c.AnK;
        localObject3 = (Iterable)localObject3;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderItem)((Iterator)localObject3).next();
          localObject5 = c.AnK;
          ((Collection)localObject2).add(c.a.a((FinderItem)localObject4));
        }
        c.a.a((List)localObject2, 2, params, bool);
        break label2070;
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 14L, 1L, false);
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.an.i parami)
  {
    AppMethodBeat.i(165289);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final long dpb()
  {
    AppMethodBeat.i(278678);
    Object localObject = this.rr.bhX();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
      AppMethodBeat.o(278678);
      throw ((Throwable)localObject);
    }
    long l = ((blb)localObject).JVf;
    AppMethodBeat.o(278678);
    return l;
  }
  
  public final FinderContact dpc()
  {
    AppMethodBeat.i(278679);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(278679);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).contact;
    AppMethodBeat.o(278679);
    return localObject;
  }
  
  public final bln dpd()
  {
    AppMethodBeat.i(278681);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(278681);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).wxaShopInfo;
    AppMethodBeat.o(278681);
    return localObject;
  }
  
  public final b getLastBuffer()
  {
    AppMethodBeat.i(278680);
    Object localObject = this.rr.bhY();
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(278680);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).lastBuffer;
    AppMethodBeat.o(278680);
    return localObject;
  }
  
  public final int getType()
  {
    return 3736;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "ERRCODE_LOGOUT", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cr
 * JD-Core Version:    0.7.0.1
 */
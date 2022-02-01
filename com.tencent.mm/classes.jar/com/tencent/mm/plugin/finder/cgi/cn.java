package com.tencent.mm.plugin.finder.cgi;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.l.a;
import com.tencent.mm.plugin.finder.storage.data.u;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.bac;
import com.tencent.mm.protocal.protobuf.baw;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.protocal.protobuf.bel;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "tabType", "topicId", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;IJ)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "getTopicId", "()J", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getBizInfo", "Lcom/tencent/mm/protocal/protobuf/FinderBizInfo;", "getFirstPageMD5", "getLastBuffer", "getLiveNoticeInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveNoticeInfo;", "getMaxId", "getPrivateLock", "getShopAppInfo", "Lcom/tencent/mm/protocal/protobuf/FinderWxAppInfo;", "getTopicList", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class cn
  extends ax
  implements m
{
  public static final a twD;
  private i callback;
  private final int dLS;
  public int fansCount;
  public int friendFollowCount;
  public int pullType;
  public d rr;
  public boolean tuG;
  public final String tuH;
  public List<? extends FinderItem> tvo;
  public boolean twC;
  public final long twp;
  public LinkedList<String> userTags;
  
  static
  {
    AppMethodBeat.i(165291);
    twD = new a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public cn(String paramString, long paramLong1, b paramb, int paramInt1, bbn parambbn, int paramInt2, long paramLong2)
  {
    super(parambbn);
    AppMethodBeat.i(242532);
    this.tuH = paramString;
    this.dLS = paramInt2;
    this.twp = paramLong2;
    this.tuG = true;
    this.userTags = new LinkedList();
    paramString = com.tencent.mm.plugin.finder.api.c.tsp;
    paramString = com.tencent.mm.plugin.finder.api.c.a.asG(this.tuH);
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
      d.a locala = new d.a();
      locala.MB("/cgi-bin/micromsg-bin/finderuserpage");
      locala.sG(getType());
      beb localbeb = new beb();
      localbeb.username = this.tuH;
      localbeb.DIf = paramLong1;
      localbeb.firstPageMD5 = paramString;
      localbeb.LAt = z.aUg();
      localbeb.dLS = this.dLS;
      localbeb.twp = this.twp;
      Object localObject = am.tuw;
      localbeb.uli = am.a(parambbn);
      localObject = localbeb.uli;
      if (localObject != null) {
        if (parambbn == null) {
          break label367;
        }
      }
      label367:
      for (paramInt2 = parambbn.tyh;; paramInt2 = 0)
      {
        ((aov)localObject).scene = paramInt2;
        if (n.I(localbeb.username, localbeb.LAt, false)) {
          localbeb.LAu = 1;
        }
        localbeb.lastBuffer = paramb;
        paramb = am.tuw;
        localbeb.LAv = am.cXZ();
        paramb = new FinderUserPageResponse();
        locala.c((com.tencent.mm.bw.a)localbeb);
        locala.d((com.tencent.mm.bw.a)paramb);
        paramb = locala.aXF();
        p.g(paramb, "builder.buildInstance()");
        this.rr = paramb;
        this.pullType = paramInt1;
        Log.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong1 + " username " + this.tuH + " pullType " + paramInt1 + " fpMD5 " + paramString);
        AppMethodBeat.o(242532);
        return;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242527);
    Log.i("Finder.NetSceneFinderUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    Object localObject4;
    Object localObject1;
    Object localObject3;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 13L, 1L, false);
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(242527);
        throw paramString;
      }
      localObject4 = (FinderUserPageResponse)params;
      params = this.tuH;
      localObject1 = ((FinderUserPageResponse)localObject4).userTags;
      p.g(localObject1, "resp.userTags");
      this.userTags = ((LinkedList)localObject1);
      this.friendFollowCount = ((FinderUserPageResponse)localObject4).friendFollowCount;
      this.fansCount = ((FinderUserPageResponse)localObject4).fansCount;
      localObject1 = com.tencent.mm.plugin.finder.preload.a.uTO;
      localObject1 = ((FinderUserPageResponse)localObject4).preloadInfo;
      localObject3 = ((FinderUserPageResponse)localObject4).object;
      p.g(localObject3, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a((baw)localObject1, (List)localObject3, 3736);
      localObject3 = ((FinderUserPageResponse)localObject4).contact;
      if (localObject3 != null)
      {
        params = new StringBuilder("contact info ");
        p.g(localObject3, "it");
        Log.i("Finder.NetSceneFinderUserPage", com.tencent.mm.ac.g.bN(localObject3) + " fansCount: " + ((FinderUserPageResponse)localObject4).fansCount + " friendFollowCount:" + ((FinderUserPageResponse)localObject4).friendFollowCount);
        params = ((FinderContact)localObject3).username;
        if (params != null) {
          break label2212;
        }
        params = "";
      }
    }
    label2212:
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
      com.tencent.mm.plugin.finder.api.c.a.a((FinderContact)localObject3);
      if ((p.j(((FinderContact)localObject3).username, this.tuH) ^ true))
      {
        localObject1 = (com.tencent.mm.bw.a)new FinderContact();
        localObject5 = ((FinderContact)localObject3).toByteArray();
      }
      Object localObject6;
      for (;;)
      {
        try
        {
          ((com.tencent.mm.bw.a)localObject1).parseFrom((byte[])localObject5);
          localObject1 = (FinderContact)localObject1;
          if (localObject1 != null)
          {
            ((FinderContact)localObject1).username = this.tuH;
            localObject5 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.c.a.a((FinderContact)localObject1);
            Log.i("Finder.NetSceneFinderUserPage", "duplicate contact for " + this.tuH + ", " + params);
            localObject1 = x.SXb;
          }
          localObject1 = com.tencent.mm.plugin.finder.api.c.tsp;
          localObject1 = com.tencent.mm.plugin.finder.api.c.a.asG(((FinderContact)localObject3).username);
          if (localObject1 != null)
          {
            ((com.tencent.mm.plugin.finder.api.g)localObject1).field_firstPageMD5 = ((FinderUserPageResponse)localObject4).firstPageMD5;
            localObject5 = com.tencent.mm.plugin.finder.api.c.tsp;
            com.tencent.mm.plugin.finder.api.c.a.c((com.tencent.mm.plugin.finder.api.g)localObject1);
            if (p.j(((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername(), z.aUg()))
            {
              if (((FinderUserPageResponse)localObject4).fansCount > 0)
              {
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.OlC, Integer.valueOf(((FinderUserPageResponse)localObject4).fansCount));
              }
              localObject1 = com.tencent.mm.kernel.g.aAh();
              p.g(localObject1, "MMKernel.storage()");
              localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
              localObject6 = ar.a.OjH;
              localObject1 = ((FinderUserPageResponse)localObject4).contact;
              if (localObject1 != null)
              {
                localObject1 = ((FinderContact)localObject1).nickname;
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.OjI;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).signature;
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.OjJ;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).headUrl;
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.OjL;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).coverImgUrl;
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.Okw;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = Integer.valueOf(((FinderContact)localObject1).extFlag);
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.OjP;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = Integer.valueOf(((FinderContact)localObject1).originalFlag);
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.OjU;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = Integer.valueOf(((FinderContact)localObject1).originalEntranceFlag);
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).originalInfo;
                if (localObject1 != null)
                {
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                  localObject6 = ar.a.OjQ;
                  localObject1 = ((FinderUserPageResponse)localObject4).contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bac)localObject1).LJQ);
                  ((ao)localObject5).set((ar.a)localObject6, localObject1);
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                  localObject6 = ar.a.OjR;
                  localObject1 = ((FinderUserPageResponse)localObject4).contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bac)localObject1).LJR);
                  ((ao)localObject5).set((ar.a)localObject6, localObject1);
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                  localObject6 = ar.a.OjS;
                  localObject1 = ((FinderUserPageResponse)localObject4).contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bac)localObject1).LJS);
                  ((ao)localObject5).set((ar.a)localObject6, localObject1);
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                  localObject6 = ar.a.OjT;
                  localObject1 = ((FinderUserPageResponse)localObject4).contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bac)localObject1).LJT);
                  ((ao)localObject5).set((ar.a)localObject6, localObject1);
                  localObject1 = com.tencent.mm.kernel.g.aAh();
                  p.g(localObject1, "MMKernel.storage()");
                  localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                  localObject6 = ar.a.OjW;
                  localObject1 = ((FinderUserPageResponse)localObject4).contact;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = ((FinderContact)localObject1).originalInfo;
                  if (localObject1 == null) {
                    continue;
                  }
                  localObject1 = Integer.valueOf(((bac)localObject1).LJU);
                  ((ao)localObject5).set((ar.a)localObject6, localObject1);
                }
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
                if (localObject1 == null) {
                  continue;
                }
                localObject1 = ((FinderContact)localObject1).authInfo;
                if (localObject1 != null) {
                  continue;
                }
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.OjK, "");
                localObject1 = com.tencent.mm.kernel.g.aAh();
                p.g(localObject1, "MMKernel.storage()");
                localObject5 = ((com.tencent.mm.kernel.e)localObject1).azQ();
                localObject6 = ar.a.Okk;
                localObject1 = ((FinderUserPageResponse)localObject4).contact;
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
                ((ao)localObject5).set((ar.a)localObject6, localObject1);
              }
            }
            else
            {
              localObject1 = x.SXb;
              if (!this.twC) {
                break;
              }
              Log.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
              if (this.callback != null)
              {
                params = this.callback;
                if (params == null) {
                  p.hyc();
                }
                params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
                paramString = x.SXb;
              }
              AppMethodBeat.o(242527);
              return;
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
          localObject2 = com.tencent.mm.kernel.g.aAh();
          p.g(localObject2, "MMKernel.storage()");
          localObject5 = ((com.tencent.mm.kernel.e)localObject2).azQ();
          localObject6 = ar.a.OjK;
          localObject2 = ((FinderContact)localObject3).authInfo;
          if (localObject2 != null)
          {
            localObject2 = ((FinderAuthInfo)localObject2).toByteArray();
            ((ao)localObject5).set((ar.a)localObject6, Util.encodeHexString((byte[])localObject2));
          }
          else
          {
            localObject2 = null;
            continue;
          }
        }
      }
      Object localObject2 = ((FinderUserPageResponse)localObject4).object;
      if (localObject2 == null) {
        p.hyc();
      }
      localObject3 = new StringBuilder("cgiBack: continueFlag:").append(((FinderUserPageResponse)localObject4).continueFlag).append(", list:");
      Object localObject5 = al.tuv;
      Log.i("Finder.NetSceneFinderUserPage", al.dQ((List)localObject2));
      Log.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + ((LinkedList)localObject2).size());
      if (((FinderUserPageResponse)localObject4).continueFlag == 1)
      {
        bool = true;
        this.tuG = bool;
        if (this.pullType == 2) {
          break label1837;
        }
      }
      label1837:
      for (boolean bool = true;; bool = false)
      {
        localObject3 = (Iterable)localObject2;
        localObject2 = (Collection)new ArrayList();
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = ((Iterator)localObject3).next();
          localObject5 = (FinderObject)localObject4;
          localObject6 = y.vXH;
          if (y.r((FinderObject)localObject5)) {
            ((Collection)localObject2).add(localObject4);
          }
        }
        bool = false;
        break;
      }
      localObject2 = (List)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
      this.tvo = com.tencent.mm.plugin.finder.storage.logic.c.a.a((List)localObject2, 2, this.ttO);
      if ((bool) && (this.twp == 0L))
      {
        localObject3 = this.tvo;
        if (localObject3 != null)
        {
          if (this.dLS != 1) {
            break label2096;
          }
          localObject2 = new LinkedList();
          params = ((Iterable)localObject3).iterator();
          while (params.hasNext())
          {
            localObject3 = (FinderItem)params.next();
            localObject4 = ((FinderItem)localObject3).getMegaVideo();
            if (localObject4 != null) {
              ((LinkedList)localObject2).add(new u(((cng)localObject4).id, 32768, ((FinderItem)localObject3).getFeedObject()));
            }
          }
          if (((LinkedList)localObject2).size() > 0)
          {
            params = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            if (!TextUtils.isEmpty((CharSequence)this.tuH)) {
              break label2087;
            }
            params = z.aUg();
            p.g(params, "if (TextUtils.isEmpty(re…rname() else req_username");
            l.a.a(13, params, (LinkedList)localObject2);
          }
          label2034:
          params = x.SXb;
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
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
          paramString = x.SXb;
        }
        AppMethodBeat.o(242527);
        return;
        label2087:
        params = this.tuH;
        break;
        label2096:
        localObject2 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
        localObject3 = (Iterable)localObject3;
        localObject2 = (Collection)new ArrayList(j.a((Iterable)localObject3, 10));
        localObject3 = ((Iterable)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (FinderItem)((Iterator)localObject3).next();
          localObject5 = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
          ((Collection)localObject2).add(com.tencent.mm.plugin.finder.storage.logic.c.a.s((FinderItem)localObject4));
        }
        com.tencent.mm.plugin.finder.storage.logic.c.a.a((List)localObject2, 2, params, bool);
        break label2034;
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 14L, 1L, false);
      }
    }
  }
  
  public final long cZj()
  {
    AppMethodBeat.i(242528);
    Object localObject = this.rr.aYJ();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
      AppMethodBeat.o(242528);
      throw ((Throwable)localObject);
    }
    long l = ((beb)localObject).DIf;
    AppMethodBeat.o(242528);
    return l;
  }
  
  public final FinderContact cZk()
  {
    AppMethodBeat.i(242529);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(242529);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).contact;
    AppMethodBeat.o(242529);
    return localObject;
  }
  
  public final bel cZl()
  {
    AppMethodBeat.i(242531);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(242531);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).wxaShopInfo;
    AppMethodBeat.o(242531);
    return localObject;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165289);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final b getLastBuffer()
  {
    AppMethodBeat.i(242530);
    Object localObject = this.rr.aYK();
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(242530);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).lastBuffer;
    AppMethodBeat.o(242530);
    return localObject;
  }
  
  public final int getType()
  {
    return 3736;
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cn
 * JD-Core Version:    0.7.0.1
 */
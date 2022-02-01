package com.tencent.mm.plugin.finder.cgi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.bw.a;
import com.tencent.mm.bw.b;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.logic.e.a;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.protocal.protobuf.ate;
import com.tencent.mm.protocal.protobuf.ayk;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.protocal.protobuf.ayn;
import com.tencent.mm.protocal.protobuf.ayo;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.ar.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bo
  extends ax
{
  private static final String TAG = "Finder.NetSceneFinderGetMentionList";
  private static final int tvv = 1;
  private static final int tvw = 2;
  public static final a tvx;
  private i callback;
  public final LinkedList<com.tencent.mm.plugin.finder.storage.ao> gZp;
  private d rr;
  public int scene;
  public int tvu;
  
  static
  {
    AppMethodBeat.i(165232);
    tvx = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    tvv = 1;
    tvw = 2;
    AppMethodBeat.o(165232);
  }
  
  public bo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.gZp = new LinkedList();
    this.tvu = paramInt2;
    this.scene = paramInt1;
    Object localObject2 = new d.a();
    ((d.a)localObject2).sG(getType());
    atd localatd = new atd();
    localatd.tvu = paramInt2;
    int i = a.Ik(paramInt1);
    Object localObject1;
    label117:
    Object localObject3;
    if (i == tvw) {
      switch (paramInt2)
      {
      default: 
        localObject1 = new byte[0];
        localatd.tsO = b.cD((byte[])localObject1);
        localatd.scene = a.Ik(this.scene);
        localatd.username = z.aUg();
        localObject1 = am.tuw;
        localatd.uli = am.cXY();
        ((d.a)localObject2).c((a)localatd);
        ((d.a)localObject2).d((a)new ate());
        ((d.a)localObject2).MB("/cgi-bin/micromsg-bin/findergetmentionlist");
        localObject1 = ((d.a)localObject2).aXF();
        p.g(localObject1, "builder.buildInstance()");
        this.rr = ((d)localObject1);
        localObject2 = TAG;
        localObject3 = new StringBuilder("NetSceneFinderGetMentionList init, scene ").append(paramInt1).append(" type ").append(paramInt2).append(" lastBuf ");
        if (localatd.tsO == null) {
          localObject1 = "null";
        }
        break;
      }
    }
    for (;;)
    {
      Log.i((String)localObject2, localObject1);
      AppMethodBeat.o(165231);
      return;
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Omg, "");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = Util.decodeHexString((String)localObject1);
      if (localObject1 == null)
      {
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        if (p.j(((com.tencent.mm.kernel.e)localObject3).azQ().get(ar.a.Omm, Integer.valueOf(0)), Integer.valueOf(1))) {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 55L, 1L, false);
        }
      }
      p.g(localObject1, "lastBuf");
      break label117;
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Omh, "");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = Util.decodeHexString((String)localObject1);
      if (localObject1 == null)
      {
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        if (p.j(((com.tencent.mm.kernel.e)localObject3).azQ().get(ar.a.Omn, Integer.valueOf(0)), Integer.valueOf(1))) {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 56L, 1L, false);
        }
      }
      p.g(localObject1, "lastBuf");
      break label117;
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Omi, "");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = Util.decodeHexString((String)localObject1);
      if (localObject1 == null)
      {
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        p.j(((com.tencent.mm.kernel.e)localObject3).azQ().get(ar.a.Omo, Integer.valueOf(0)), Integer.valueOf(1));
      }
      p.g(localObject1, "lastBuf");
      break label117;
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Omj, "");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = Util.decodeHexString((String)localObject1);
      if (localObject1 == null)
      {
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        p.j(((com.tencent.mm.kernel.e)localObject3).azQ().get(ar.a.Omp, Integer.valueOf(0)), Integer.valueOf(1));
      }
      p.g(localObject1, "lastBuf");
      break label117;
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Omk, "");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = Util.decodeHexString((String)localObject1);
      if (localObject1 == null)
      {
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        p.j(((com.tencent.mm.kernel.e)localObject3).azQ().get(ar.a.Omq, Integer.valueOf(0)), Integer.valueOf(1));
      }
      p.g(localObject1, "lastBuf");
      break label117;
      if (i != tvv) {
        break;
      }
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).azQ().get(ar.a.Omd, "");
      if (localObject1 == null)
      {
        localObject1 = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = Util.decodeHexString((String)localObject1);
      if (localObject1 == null)
      {
        localObject3 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject3, "MMKernel.storage()");
        if (p.j(((com.tencent.mm.kernel.e)localObject3).azQ().get(ar.a.Omn, Integer.valueOf(0)), Integer.valueOf(1))) {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 57L, 1L, false);
        }
      }
      p.g(localObject1, "lastBuf");
      break label117;
      localObject1 = localatd.tsO;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((b)localObject1).zy.length);
      } else {
        localObject1 = null;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(242439);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    b localb;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(242439);
        throw paramString;
      }
      localb = ((ate)params).tsO;
      params = this.rr.aYK();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(242439);
        throw paramString;
      }
      localObject1 = ((ate)params).LEb;
      if (localObject1 != null)
      {
        Log.i(TAG, "GetMentionList size " + ((ayo)localObject1).LIP.size());
        params = ((ayo)localObject1).LIP;
        p.g(params, "it.mentions");
        ((Collection)params).isEmpty();
        params = ((ayo)localObject1).LIP;
        p.g(params, "mentionList.mentions");
        localObject2 = ((Iterable)params).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ayk)((Iterator)localObject2).next();
          localObject4 = this.gZp;
          params = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
          p.g(localObject3, "mention");
          p.h(localObject3, "mention");
          localObject5 = new com.tencent.mm.plugin.finder.storage.ao();
          ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_headUrl = ((ayk)localObject3).headUrl;
          if (((ayk)localObject3).LII != 0)
          {
            params = new aym();
            params.LII = ((ayk)localObject3).LII;
            params.LIH = ((ayk)localObject3).LIH;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_aggregatedContacts = params;
            label348:
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_nickname = ((ayk)localObject3).nickName;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_type = ((ayk)localObject3).LEa;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_content = ((ayk)localObject3).LIB;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_createTime = ((ayk)localObject3).iXu;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_thumbUrl = ((ayk)localObject3).thumbUrl;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_id = ((ayk)localObject3).id;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_objectId = ((ayk)localObject3).hFK;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_objectNonceId = ((ayk)localObject3).objectNonceId;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_commentId = ((ayk)localObject3).commentId;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_flag = ((ayk)localObject3).cSx;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_refContent = ((ayk)localObject3).LIC;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_extFlag = ((ayk)localObject3).extFlag;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_notify = ((ayk)localObject3).LID;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_mediaType = ((ayk)localObject3).mediaType;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_description = ((ayk)localObject3).description;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_replayUsername = ((ayk)localObject3).LBr;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_replayNickname = ((ayk)localObject3).replyNickname;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_username = ((ayk)localObject3).username;
            params = ((ayk)localObject3).LIE;
            if (params == null) {
              break label697;
            }
            params = params.contact;
            label547:
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_contact = params;
            params = ((ayk)localObject3).LIF;
            if (params == null) {
              break label703;
            }
          }
          label697:
          label703:
          for (params = params.contact;; params = null)
          {
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_replyContact = params;
            params = com.tencent.mm.kernel.g.aAh();
            p.g(params, "MMKernel.storage()");
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_userVersion = params.azQ().getInt(ar.a.OlN, 0);
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_followExpireTime = ((ayk)localObject3).LIJ;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_clientMsgId = ((ayk)localObject3).fQY;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_followId = ((ayk)localObject3).LCX;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_objectType = ((ayk)localObject3).objectType;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_refVideoObjectId = ((ayk)localObject3).LIK;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_refVideoObjectNonceId = ((ayk)localObject3).LIL;
            ((LinkedList)localObject4).add(localObject5);
            break;
            ((com.tencent.mm.plugin.finder.storage.ao)localObject5).field_aggregatedContacts = new aym();
            break label348;
            params = null;
            break label547;
          }
        }
        params = ((ayo)localObject1).LIP;
        p.g(params, "it.mentions");
        ((Collection)params).isEmpty();
        params = ((ayo)localObject1).LIP;
        p.g(params, "mentionList.mentions");
        localObject2 = ((Iterable)params).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          params = (ayk)((Iterator)localObject2).next();
          if ((params.LEa == 10) && (!Util.isNullOrNil(params.fQY)))
          {
            Log.i(TAG, "MENTION_TYPE_FOLLOW_APPLICATION APPROVED, clean db, username:" + params.username + ", clientMsgId:" + params.fQY + " scene:" + this.scene);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
            params = params.fQY;
            if (params != null) {
              break label1973;
            }
            params = "";
          }
        }
      }
    }
    label1456:
    label1973:
    for (;;)
    {
      paramInt1 = this.scene;
      p.h(params, "clientMsgId");
      localObject4 = ((PluginFinder)com.tencent.mm.kernel.g.ah(PluginFinder.class)).getMentionStorage(e.a.Li(paramInt1));
      localObject1 = com.tencent.mm.kernel.g.aAh();
      p.g(localObject1, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.e)localObject1).azQ().getInt(ar.a.OlN, 0);
      if (e.a.Li(paramInt1) == 1) {}
      for (localObject1 = cm.fFi;; localObject1 = cm.fFh)
      {
        localObject3 = "DELETE FROM " + (String)localObject1 + ' ' + " WHERE type=10  AND clientMsgId='" + params + "'  AND userVersion=" + i + ' ';
        params = "SELECT * FROM " + (String)localObject1 + ' ' + " WHERE type=10  AND clientMsgId='" + params + "'  AND userVersion=" + i + ' ';
        if (!BuildInfo.IS_FLAVOR_PURPLE) {
          break label1227;
        }
        localObject5 = ((MAutoStorage)localObject4).rawQuery(params, new String[0]);
        bool = ((MAutoStorage)localObject4).execSQL((String)localObject1, (String)localObject3);
        localObject1 = ((MAutoStorage)localObject4).rawQuery(params, new String[0]);
        localObject4 = com.tencent.mm.plugin.finder.storage.logic.e.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("removePrivateMention, before:");
        p.g(localObject5, "q1");
        localObject5 = localStringBuilder.append(((Cursor)localObject5).getCount()).append(", after:");
        p.g(localObject1, "q2");
        Log.i((String)localObject4, ((Cursor)localObject1).getCount() + ", querySql:" + params);
        Log.i(com.tencent.mm.plugin.finder.storage.logic.e.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject3);
        break;
      }
      label1227:
      boolean bool = ((MAutoStorage)localObject4).execSQL((String)localObject1, (String)localObject3);
      Log.i(com.tencent.mm.plugin.finder.storage.logic.e.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject3);
      break;
      if (!((Collection)this.gZp).isEmpty())
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          params = com.tencent.mm.plugin.finder.storage.logic.e.vGT;
          e.a.t((List)this.gZp, this.scene);
        }
        if (localb != null)
        {
          i = this.scene;
          paramInt1 = this.tvu;
          params = localb.toByteArray();
          p.g(params, "it.toByteArray()");
          i = a.Ik(i);
          if (i != tvw) {
            break label1835;
          }
        }
        switch (paramInt1)
        {
        default: 
          label1400:
          if ((localb != null) && (localb.zy.length == 0))
          {
            paramInt1 = a.Ik(this.scene);
            if (paramInt1 != tvw) {
              break;
            }
          }
          else
          {
            switch (this.tvu)
            {
            default: 
              localObject1 = TAG;
              localObject2 = new StringBuilder("lastBuf ");
              if (localb != null) {}
              break;
            }
          }
          break;
        }
      }
      for (params = "null";; params = Integer.valueOf(localb.zy.length))
      {
        Log.i((String)localObject1, params);
        if (this.callback != null)
        {
          params = this.callback;
          if (params == null) {
            p.hyc();
          }
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        }
        AppMethodBeat.o(242439);
        return;
        paramInt1 = 0;
        break;
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Omg, Util.encodeHexString(params));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Omm, Integer.valueOf(1));
        break label1400;
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Omh, Util.encodeHexString(params));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Omn, Integer.valueOf(1));
        break label1400;
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Omi, Util.encodeHexString(params));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Omo, Integer.valueOf(1));
        break label1400;
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Omj, Util.encodeHexString(params));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Omp, Integer.valueOf(1));
        break label1400;
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Omk, Util.encodeHexString(params));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Omq, Integer.valueOf(1));
        break label1400;
        if (i != tvv) {
          break label1400;
        }
        localObject1 = com.tencent.mm.kernel.g.aAh();
        p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).azQ().set(ar.a.Omd, Util.encodeHexString(params));
        params = com.tencent.mm.kernel.g.aAh();
        p.g(params, "MMKernel.storage()");
        params.azQ().set(ar.a.Oml, Integer.valueOf(1));
        break label1400;
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 50L, 1L, false);
        break label1456;
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 51L, 1L, false);
        break label1456;
        if (paramInt1 != tvv) {
          break label1456;
        }
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(1279L, 52L, 1L, false);
        break label1456;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(165229);
    this.callback = parami;
    int i = dispatch(paramg, (s)this.rr, (m)this);
    AppMethodBeat.o(165229);
    return i;
  }
  
  public final int getType()
  {
    return 978;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "", "lastBuf", "plugin-finder_release"})
  public static final class a
  {
    static int Ik(int paramInt)
    {
      AppMethodBeat.i(242438);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(242438);
        return 0;
      case 2: 
        paramInt = bo.cYB();
        AppMethodBeat.o(242438);
        return paramInt;
      }
      paramInt = bo.cYC();
      AppMethodBeat.o(242438);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bo
 * JD-Core Version:    0.7.0.1
 */
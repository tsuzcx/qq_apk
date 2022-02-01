package com.tencent.mm.plugin.finder.cgi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.cd.a;
import com.tencent.mm.cd.b;
import com.tencent.mm.f.c.cr;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.storage.logic.e;
import com.tencent.mm.plugin.finder.storage.logic.e.a;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.protocal.protobuf.avh;
import com.tencent.mm.protocal.protobuf.bee;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.protocal.protobuf.beh;
import com.tencent.mm.protocal.protobuf.bei;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class br
  extends com.tencent.mm.plugin.findersdk.b.g
{
  private static final String TAG = "Finder.NetSceneFinderGetMentionList";
  private static final int xdd = 1;
  private static final int xde = 2;
  public static final a xdf;
  private i callback;
  public final LinkedList<an> jKq;
  private d rr;
  public int scene;
  public int xdc;
  
  static
  {
    AppMethodBeat.i(165232);
    xdf = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    xdd = 1;
    xde = 2;
    AppMethodBeat.o(165232);
  }
  
  public br(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.jKq = new LinkedList();
    this.xdc = paramInt2;
    this.scene = paramInt1;
    Object localObject2 = new d.a();
    ((d.a)localObject2).vD(getType());
    Object localObject1 = new avg();
    ((avg)localObject1).xdc = paramInt2;
    ((avg)localObject1).xaw = b.cU(a.gv(paramInt1, paramInt2));
    ((avg)localObject1).scene = a.LV(this.scene);
    ((avg)localObject1).username = z.bdh();
    Object localObject3 = ao.xcj;
    ((avg)localObject1).yjp = ao.dnO();
    ((d.a)localObject2).c((a)localObject1);
    ((d.a)localObject2).d((a)new avh());
    ((d.a)localObject2).TW("/cgi-bin/micromsg-bin/findergetmentionlist");
    localObject2 = ((d.a)localObject2).bgN();
    p.j(localObject2, "builder.buildInstance()");
    this.rr = ((d)localObject2);
    localObject2 = TAG;
    localObject3 = new StringBuilder("NetSceneFinderGetMentionList init, scene ").append(paramInt1).append(" type ").append(paramInt2).append(" lastBuf ");
    if (((avg)localObject1).xaw == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Log.i((String)localObject2, localObject1);
      AppMethodBeat.o(165231);
      return;
      localObject1 = ((avg)localObject1).xaw;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((b)localObject1).UH.length);
      } else {
        localObject1 = null;
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, s params)
  {
    AppMethodBeat.i(289614);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    b localb;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(289614);
        throw paramString;
      }
      localb = ((avh)params).xaw;
      params = this.rr.bhY();
      if (params == null)
      {
        paramString = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(289614);
        throw paramString;
      }
      localObject1 = ((avh)params).SHF;
      if (localObject1 != null)
      {
        Log.i(TAG, "GetMentionList size " + ((bei)localObject1).SPB.size());
        params = ((bei)localObject1).SPB;
        p.j(params, "it.mentions");
        ((Collection)params).isEmpty();
        params = ((bei)localObject1).SPB;
        p.j(params, "mentionList.mentions");
        localObject2 = ((Iterable)params).iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (bee)((Iterator)localObject2).next();
          localObject4 = this.jKq;
          params = e.AnP;
          p.j(localObject3, "mention");
          p.k(localObject3, "mention");
          localObject5 = new an();
          ((an)localObject5).field_headUrl = ((bee)localObject3).headUrl;
          if (((bee)localObject3).SPu != 0)
          {
            params = new beg();
            params.SPu = ((bee)localObject3).SPu;
            params.SPt = ((bee)localObject3).SPt;
            ((an)localObject5).field_aggregatedContacts = params;
            label339:
            ((an)localObject5).field_nickname = ((bee)localObject3).nickName;
            ((an)localObject5).field_type = ((bee)localObject3).xcE;
            ((an)localObject5).field_content = ((bee)localObject3).SPn;
            ((an)localObject5).field_createTime = ((bee)localObject3).createTime;
            ((an)localObject5).field_thumbUrl = ((bee)localObject3).thumbUrl;
            ((an)localObject5).field_id = ((bee)localObject3).id;
            ((an)localObject5).field_objectId = ((bee)localObject3).xbk;
            ((an)localObject5).field_objectNonceId = ((bee)localObject3).objectNonceId;
            ((an)localObject5).field_commentId = ((bee)localObject3).commentId;
            ((an)localObject5).field_flag = ((bee)localObject3).cUP;
            ((an)localObject5).field_refContent = ((bee)localObject3).SPo;
            ((an)localObject5).field_extFlag = ((bee)localObject3).extFlag;
            ((an)localObject5).field_notify = ((bee)localObject3).SPp;
            ((an)localObject5).field_mediaType = ((bee)localObject3).mediaType;
            ((an)localObject5).field_description = ((bee)localObject3).description;
            ((an)localObject5).field_replayUsername = ((bee)localObject3).SEa;
            ((an)localObject5).field_replayNickname = ((bee)localObject3).replyNickname;
            ((an)localObject5).field_username = ((bee)localObject3).username;
            params = ((bee)localObject3).SPq;
            if (params == null) {
              break label689;
            }
            params = params.contact;
            label538:
            ((an)localObject5).field_contact = params;
            params = ((bee)localObject3).SPr;
            if (params == null) {
              break label695;
            }
          }
          label689:
          label695:
          for (params = params.contact;; params = null)
          {
            ((an)localObject5).field_replyContact = params;
            params = h.aHG();
            p.j(params, "MMKernel.storage()");
            ((an)localObject5).field_userVersion = params.aHp().getInt(ar.a.VAI, 0);
            ((an)localObject5).field_followExpireTime = ((bee)localObject3).SPv;
            ((an)localObject5).field_clientMsgId = ((bee)localObject3).ilo;
            ((an)localObject5).field_followId = ((bee)localObject3).SGj;
            ((an)localObject5).field_objectType = ((bee)localObject3).objectType;
            ((an)localObject5).field_refVideoObjectId = ((bee)localObject3).SPw;
            ((an)localObject5).field_refVideoObjectNonceId = ((bee)localObject3).SPx;
            ((LinkedList)localObject4).add(localObject5);
            break;
            ((an)localObject5).field_aggregatedContacts = new beg();
            break label339;
            params = null;
            break label538;
          }
        }
        params = ((bei)localObject1).SPB;
        p.j(params, "it.mentions");
        ((Collection)params).isEmpty();
        params = ((bei)localObject1).SPB;
        p.j(params, "mentionList.mentions");
        localObject2 = ((Iterable)params).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          params = (bee)((Iterator)localObject2).next();
          if ((params.xcE == 10) && (!Util.isNullOrNil(params.ilo)))
          {
            Log.i(TAG, "MENTION_TYPE_FOLLOW_APPLICATION APPROVED, clean db, username:" + params.username + ", clientMsgId:" + params.ilo + " scene:" + this.scene);
            localObject1 = e.AnP;
            params = params.ilo;
            if (params != null) {
              break label1976;
            }
            params = "";
          }
        }
      }
    }
    label1448:
    label1836:
    label1976:
    for (;;)
    {
      paramInt1 = this.scene;
      p.k(params, "clientMsgId");
      localObject4 = ((PluginFinder)h.ag(PluginFinder.class)).getMentionStorage(e.a.Qs(paramInt1));
      localObject1 = h.aHG();
      p.j(localObject1, "MMKernel.storage()");
      int i = ((com.tencent.mm.kernel.f)localObject1).aHp().getInt(ar.a.VAI, 0);
      if (e.a.Qs(paramInt1) == 1) {}
      for (localObject1 = cr.hUo;; localObject1 = cr.hUn)
      {
        localObject3 = "DELETE FROM " + (String)localObject1 + ' ' + " WHERE type=10  AND clientMsgId='" + params + "'  AND userVersion=" + i + ' ';
        params = "SELECT * FROM " + (String)localObject1 + ' ' + " WHERE type=10  AND clientMsgId='" + params + "'  AND userVersion=" + i + ' ';
        if (!BuildInfo.IS_FLAVOR_PURPLE) {
          break label1221;
        }
        localObject5 = ((MAutoStorage)localObject4).rawQuery(params, new String[0]);
        bool = ((MAutoStorage)localObject4).execSQL((String)localObject1, (String)localObject3);
        localObject1 = ((MAutoStorage)localObject4).rawQuery(params, new String[0]);
        localObject4 = e.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("removePrivateMention, before:");
        p.j(localObject5, "q1");
        localObject5 = localStringBuilder.append(((Cursor)localObject5).getCount()).append(", after:");
        p.j(localObject1, "q2");
        Log.i((String)localObject4, ((Cursor)localObject1).getCount() + ", querySql:" + params);
        Log.i(e.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject3);
        break;
      }
      label1221:
      boolean bool = ((MAutoStorage)localObject4).execSQL((String)localObject1, (String)localObject3);
      Log.i(e.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject3);
      break;
      if (!((Collection)this.jKq).isEmpty())
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          params = e.AnP;
          e.a.s((List)this.jKq, this.scene);
        }
        if (localb != null)
        {
          i = this.scene;
          paramInt1 = this.xdc;
          params = localb.toByteArray();
          p.j(params, "it.toByteArray()");
          i = a.LV(i);
          if (i != xde) {
            break label1836;
          }
        }
        switch (paramInt1)
        {
        default: 
          label1392:
          if ((localb != null) && (localb.UH.length == 0))
          {
            paramInt1 = a.LV(this.scene);
            if (paramInt1 != xde) {
              break;
            }
          }
          else
          {
            switch (this.xdc)
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
      for (params = "null";; params = Integer.valueOf(localb.UH.length))
      {
        Log.i((String)localObject1, params);
        if (this.callback != null)
        {
          params = this.callback;
          if (params == null) {
            p.iCn();
          }
          params.onSceneEnd(paramInt2, paramInt3, paramString, (q)this);
        }
        AppMethodBeat.o(289614);
        return;
        paramInt1 = 0;
        break;
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBd, Util.encodeHexString(params));
        params = h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VBj, Integer.valueOf(1));
        break label1392;
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBe, Util.encodeHexString(params));
        params = h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VBk, Integer.valueOf(1));
        break label1392;
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBf, Util.encodeHexString(params));
        params = h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VBl, Integer.valueOf(1));
        break label1392;
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBg, Util.encodeHexString(params));
        params = h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VBm, Integer.valueOf(1));
        break label1392;
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBh, Util.encodeHexString(params));
        params = h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VBn, Integer.valueOf(1));
        break label1392;
        if (i != xdd) {
          break label1392;
        }
        localObject1 = h.aHG();
        p.j(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.f)localObject1).aHp().set(ar.a.VBa, Util.encodeHexString(params));
        params = h.aHG();
        p.j(params, "MMKernel.storage()");
        params.aHp().set(ar.a.VBi, Integer.valueOf(1));
        break label1392;
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 50L, 1L, false);
        break label1448;
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 51L, 1L, false);
        break label1448;
        if (paramInt1 != xdd) {
          break label1448;
        }
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 52L, 1L, false);
        break label1448;
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "", "lastBuf", "plugin-finder_release"})
  public static final class a
  {
    static int LV(int paramInt)
    {
      AppMethodBeat.i(287465);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(287465);
        return 0;
      case 2: 
        paramInt = br.dop();
        AppMethodBeat.o(287465);
        return paramInt;
      }
      paramInt = br.doq();
      AppMethodBeat.o(287465);
      return paramInt;
    }
    
    public static byte[] gv(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(287467);
      paramInt1 = LV(paramInt1);
      if (paramInt1 == br.doq()) {
        switch (paramInt2)
        {
        }
      }
      com.tencent.mm.kernel.f localf;
      while (paramInt1 != br.dop())
      {
        AppMethodBeat.o(287467);
        return new byte[0];
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBd, "");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(287467);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null)
        {
          localf = h.aHG();
          p.j(localf, "MMKernel.storage()");
          if (p.h(localf.aHp().get(ar.a.VBj, Integer.valueOf(0)), Integer.valueOf(1))) {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 55L, 1L, false);
          }
        }
        p.j(localObject, "lastBuf");
        AppMethodBeat.o(287467);
        return localObject;
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBe, "");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(287467);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null)
        {
          localf = h.aHG();
          p.j(localf, "MMKernel.storage()");
          if (p.h(localf.aHp().get(ar.a.VBk, Integer.valueOf(0)), Integer.valueOf(1))) {
            com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 56L, 1L, false);
          }
        }
        p.j(localObject, "lastBuf");
        AppMethodBeat.o(287467);
        return localObject;
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBf, "");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(287467);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null)
        {
          localf = h.aHG();
          p.j(localf, "MMKernel.storage()");
          p.h(localf.aHp().get(ar.a.VBl, Integer.valueOf(0)), Integer.valueOf(1));
        }
        p.j(localObject, "lastBuf");
        AppMethodBeat.o(287467);
        return localObject;
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBg, "");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(287467);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null)
        {
          localf = h.aHG();
          p.j(localf, "MMKernel.storage()");
          p.h(localf.aHp().get(ar.a.VBm, Integer.valueOf(0)), Integer.valueOf(1));
        }
        p.j(localObject, "lastBuf");
        AppMethodBeat.o(287467);
        return localObject;
        localObject = h.aHG();
        p.j(localObject, "MMKernel.storage()");
        localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBh, "");
        if (localObject == null)
        {
          localObject = new t("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(287467);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null)
        {
          localf = h.aHG();
          p.j(localf, "MMKernel.storage()");
          p.h(localf.aHp().get(ar.a.VBn, Integer.valueOf(0)), Integer.valueOf(1));
        }
        p.j(localObject, "lastBuf");
        AppMethodBeat.o(287467);
        return localObject;
      }
      Object localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.f)localObject).aHp().get(ar.a.VBa, "");
      if (localObject == null)
      {
        localObject = new t("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(287467);
        throw ((Throwable)localObject);
      }
      localObject = Util.decodeHexString((String)localObject);
      if (localObject == null)
      {
        localf = h.aHG();
        p.j(localf, "MMKernel.storage()");
        if (p.h(localf.aHp().get(ar.a.VBk, Integer.valueOf(0)), Integer.valueOf(1))) {
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(1279L, 57L, 1L, false);
        }
      }
      p.j(localObject, "lastBuf");
      AppMethodBeat.o(287467);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.br
 * JD-Core Version:    0.7.0.1
 */
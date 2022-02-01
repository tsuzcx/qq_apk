package com.tencent.mm.plugin.finder.cgi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.cz;
import com.tencent.mm.bx.a;
import com.tencent.mm.bx.b;
import com.tencent.mm.model.z;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.storage.logic.f.a;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bpc;
import com.tencent.mm.protocal.protobuf.bpe;
import com.tencent.mm.protocal.protobuf.bpf;
import com.tencent.mm.protocal.protobuf.bph;
import com.tencent.mm.protocal.protobuf.dhs;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/findersdk/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "index", "getIndex", "()I", "setIndex", "(I)V", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onCgiEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cp
  extends com.tencent.mm.plugin.findersdk.b.h
{
  private static final int ACB;
  private static final int ACC;
  public static final a ACz;
  private static final String TAG;
  public int ACA;
  private com.tencent.mm.am.h callback;
  public int index;
  public final LinkedList<av> mjH;
  private c rr;
  public int scene;
  
  static
  {
    AppMethodBeat.i(165232);
    ACz = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    ACB = 1;
    ACC = 2;
    AppMethodBeat.o(165232);
  }
  
  public cp(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.mjH = new LinkedList();
    this.ACA = paramInt2;
    this.scene = paramInt1;
    Object localObject2 = new c.a();
    ((c.a)localObject2).funcId = getType();
    Object localObject1 = new bae();
    ((bae)localObject1).ACA = paramInt2;
    ((bae)localObject1).AyB = b.cX(a.hp(paramInt1, paramInt2));
    ((bae)localObject1).scene = a.MY(this.scene);
    ((bae)localObject1).username = z.bAW();
    Object localObject3 = bi.ABn;
    ((bae)localObject1).CJv = bi.dVu();
    ((c.a)localObject2).otE = ((a)localObject1);
    ((c.a)localObject2).otF = ((a)new baf());
    ((c.a)localObject2).uri = "/cgi-bin/micromsg-bin/findergetmentionlist";
    localObject2 = ((c.a)localObject2).bEF();
    kotlin.g.b.s.s(localObject2, "builder.buildInstance()");
    this.rr = ((c)localObject2);
    localObject2 = TAG;
    localObject3 = new StringBuilder("NetSceneFinderGetMentionList init, scene ").append(paramInt1).append(" type ").append(paramInt2).append(" lastBuf ");
    if (((bae)localObject1).AyB == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      Log.i((String)localObject2, localObject1);
      AppMethodBeat.o(165231);
      return;
      localObject1 = ((bae)localObject1).AyB;
      if (localObject1 == null) {
        localObject1 = null;
      } else {
        localObject1 = Integer.valueOf(((b)localObject1).Op.length);
      }
    }
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(336687);
    Log.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    b localb;
    Object localObject1;
    label339:
    label1013:
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(336687);
        throw paramString;
      }
      localb = ((baf)params).AyB;
      params = c.c.b(this.rr.otC);
      if (params == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(336687);
        throw paramString;
      }
      localObject1 = ((baf)params).ZLd;
      if (localObject1 != null)
      {
        Log.i(TAG, kotlin.g.b.s.X("GetMentionList size ", Integer.valueOf(((bph)localObject1).ZXT.size())));
        params = ((bph)localObject1).ZXT;
        kotlin.g.b.s.s(params, "it.mentions");
        ((Collection)params).isEmpty();
        params = ((bph)localObject1).ZXT;
        kotlin.g.b.s.s(params, "mentionList.mentions");
        Iterator localIterator = ((Iterable)params).iterator();
        Object localObject2;
        Object localObject3;
        Object localObject4;
        if (localIterator.hasNext())
        {
          localObject2 = (bpc)localIterator.next();
          localObject3 = this.mjH;
          params = com.tencent.mm.plugin.finder.storage.logic.f.FNJ;
          kotlin.g.b.s.s(localObject2, "mention");
          kotlin.g.b.s.u(localObject2, "mention");
          localObject4 = new av();
          ((av)localObject4).field_headUrl = ((bpc)localObject2).headUrl;
          label534:
          label556:
          long l;
          if (((bpc)localObject2).ZXF != 0)
          {
            params = new bpe();
            params.ZXF = ((bpc)localObject2).ZXF;
            params.ZXE = ((bpc)localObject2).ZXE;
            ((av)localObject4).field_aggregatedContacts = params;
            ((av)localObject4).field_nickname = ((bpc)localObject2).nickName;
            ((av)localObject4).field_type = ((bpc)localObject2).ABS;
            ((av)localObject4).field_content = ((bpc)localObject2).ZXy;
            ((av)localObject4).field_createTime = ((bpc)localObject2).createTime;
            ((av)localObject4).field_thumbUrl = ((bpc)localObject2).thumbUrl;
            ((av)localObject4).field_id = ((bpc)localObject2).id;
            ((av)localObject4).field_objectId = ((bpc)localObject2).hKN;
            ((av)localObject4).field_objectNonceId = ((bpc)localObject2).objectNonceId;
            ((av)localObject4).field_commentId = ((bpc)localObject2).commentId;
            ((av)localObject4).field_flag = ((bpc)localObject2).eQp;
            ((av)localObject4).field_refContent = ((bpc)localObject2).ZXz;
            ((av)localObject4).field_extFlag = ((bpc)localObject2).extFlag;
            ((av)localObject4).field_notify = ((bpc)localObject2).ZXA;
            ((av)localObject4).field_mediaType = ((bpc)localObject2).mediaType;
            ((av)localObject4).field_description = ((bpc)localObject2).description;
            ((av)localObject4).field_replayUsername = ((bpc)localObject2).ZFu;
            ((av)localObject4).field_replayNickname = ((bpc)localObject2).replyNickname;
            ((av)localObject4).field_username = ((bpc)localObject2).username;
            params = ((bpc)localObject2).ZXB;
            if (params != null) {
              break label783;
            }
            params = null;
            ((av)localObject4).field_contact = params;
            params = ((bpc)localObject2).ZXC;
            if (params != null) {
              break label793;
            }
            params = null;
            ((av)localObject4).field_replyContact = params;
            ((av)localObject4).field_userVersion = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adda, 0);
            ((av)localObject4).field_followExpireTime = ((bpc)localObject2).ZXG;
            ((av)localObject4).field_clientMsgId = ((bpc)localObject2).kLn;
            ((av)localObject4).field_followId = ((bpc)localObject2).ZIT;
            ((av)localObject4).field_objectType = ((bpc)localObject2).objectType;
            ((av)localObject4).field_refVideoObjectId = ((bpc)localObject2).ZXH;
            ((av)localObject4).field_refVideoObjectNonceId = ((bpc)localObject2).ZXI;
            params = ((bpc)localObject2).ZXJ;
            if (params != null) {
              break label803;
            }
            l = 0L;
            label658:
            ((av)localObject4).field_likeId = l;
            params = ((bpc)localObject2).ZXB;
            if (params != null) {
              break label813;
            }
            l = 0L;
            label680:
            ((av)localObject4).field_fansId = l;
            ((av)localObject4).field_authorContact = ((bpc)localObject2).author_contact;
            params = ((bpc)localObject2).ZXJ;
            if (params != null) {
              break label823;
            }
            paramInt1 = 0;
            label711:
            ((av)localObject4).field_likeType = paramInt1;
            ((av)localObject4).field_commentMentionedUser = ((bpc)localObject2).ZXK;
            params = ((bpc)localObject2).ZXB;
            if (params != null) {
              break label832;
            }
          }
          label783:
          label793:
          label803:
          label813:
          label823:
          label832:
          for (paramInt1 = 0;; paramInt1 = params.ZXQ)
          {
            ((av)localObject4).field_relationType = paramInt1;
            ((av)localObject4).field_extInfo = ((bpc)localObject2).ZXL;
            ((LinkedList)localObject3).add(localObject4);
            break;
            ((av)localObject4).field_aggregatedContacts = new bpe();
            break label339;
            params = params.contact;
            break label534;
            params = params.contact;
            break label556;
            l = params.Tqf;
            break label658;
            l = params.ZXP;
            break label680;
            paramInt1 = params.aaMW;
            break label711;
          }
        }
        params = ((bph)localObject1).ZXT;
        kotlin.g.b.s.s(params, "it.mentions");
        ((Collection)params).isEmpty();
        params = ((bph)localObject1).ZXT;
        kotlin.g.b.s.s(params, "mentionList.mentions");
        localIterator = ((Iterable)params).iterator();
        while (localIterator.hasNext())
        {
          params = (bpc)localIterator.next();
          if ((params.ABS == 10) && (!Util.isNullOrNil(params.kLn)))
          {
            Log.i(TAG, "MENTION_TYPE_FOLLOW_APPLICATION APPROVED, clean db, username:" + params.username + ", clientMsgId:" + params.kLn + " scene:" + this.scene);
            localObject1 = com.tencent.mm.plugin.finder.storage.logic.f.FNJ;
            params = params.kLn;
            if (params == null)
            {
              params = "";
              paramInt1 = this.scene;
              kotlin.g.b.s.u(params, "clientMsgId");
              localObject2 = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMentionStorage(f.a.Tz(paramInt1));
              i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adda, 0);
              if (f.a.Tz(paramInt1) != 1) {
                break label1306;
              }
            }
            label1306:
            for (localObject1 = cz.ktN;; localObject1 = cz.ktM)
            {
              localObject3 = "DELETE FROM " + localObject1 + "  WHERE type=10  AND clientMsgId='" + params + "'  AND userVersion=" + i + ' ';
              params = "SELECT * FROM " + localObject1 + "  WHERE type=10  AND clientMsgId='" + params + "'  AND userVersion=" + i + ' ';
              if (!BuildInfo.IS_FLAVOR_PURPLE) {
                break label1314;
              }
              localObject4 = ((MAutoStorage)localObject2).rawQuery(params, new String[0]);
              bool = ((MAutoStorage)localObject2).execSQL((String)localObject1, (String)localObject3);
              localObject1 = ((MAutoStorage)localObject2).rawQuery(params, new String[0]);
              Log.i(com.tencent.mm.plugin.finder.storage.logic.f.access$getTAG$cp(), "removePrivateMention, before:" + ((Cursor)localObject4).getCount() + ", after:" + ((Cursor)localObject1).getCount() + ", querySql:" + params);
              Log.i(com.tencent.mm.plugin.finder.storage.logic.f.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject3);
              break;
              break label1013;
            }
            label1314:
            boolean bool = ((MAutoStorage)localObject2).execSQL((String)localObject1, (String)localObject3);
            Log.i(com.tencent.mm.plugin.finder.storage.logic.f.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject3);
          }
        }
        if (((Collection)this.mjH).isEmpty()) {
          break label1606;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          params = com.tencent.mm.plugin.finder.storage.logic.f.FNJ;
          f.a.L((List)this.mjH, this.scene);
        }
      }
      if (localb != null)
      {
        i = this.scene;
        paramInt1 = this.ACA;
        params = localb.toByteArray();
        kotlin.g.b.s.s(params, "it.toByteArray()");
        i = a.MY(i);
        if (i != ACC) {
          break label1791;
        }
      }
      switch (paramInt1)
      {
      default: 
        label1484:
        if ((localb != null) && (localb.Op.length == 0))
        {
          paramInt1 = a.MY(this.scene);
          if (paramInt1 != ACC) {
            break;
          }
        }
        else
        {
          switch (this.ACA)
          {
          default: 
            localObject1 = TAG;
            if (localb != null) {}
            break;
          }
        }
        label1540:
        break;
      }
    }
    for (params = "null";; params = Integer.valueOf(localb.Op.length))
    {
      Log.i((String)localObject1, kotlin.g.b.s.X("lastBuf ", params));
      if (this.callback != null)
      {
        params = this.callback;
        kotlin.g.b.s.checkNotNull(params);
        params.onSceneEnd(paramInt2, paramInt3, paramString, (p)this);
      }
      AppMethodBeat.o(336687);
      return;
      label1606:
      paramInt1 = 0;
      break;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addx, Util.encodeHexString(params));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addF, Integer.valueOf(1));
      break label1484;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addy, Util.encodeHexString(params));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addG, Integer.valueOf(1));
      break label1484;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addz, Util.encodeHexString(params));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addH, Integer.valueOf(1));
      break label1484;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addA, Util.encodeHexString(params));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addI, Integer.valueOf(1));
      break label1484;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addB, Util.encodeHexString(params));
      com.tencent.mm.kernel.h.baE().ban().set(at.a.addJ, Integer.valueOf(1));
      break label1484;
      label1791:
      if (i != ACB) {
        break label1484;
      }
      switch (paramInt1)
      {
      default: 
        break;
      case 1: 
        com.tencent.mm.kernel.h.baE().ban().set(at.a.adds, Util.encodeHexString(params));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.addC, Integer.valueOf(1));
        break;
      case 7: 
        com.tencent.mm.kernel.h.baE().ban().set(at.a.addt, Util.encodeHexString(params));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.addD, Integer.valueOf(1));
        break;
      case 8: 
        com.tencent.mm.kernel.h.baE().ban().set(at.a.addu, Util.encodeHexString(params));
        com.tencent.mm.kernel.h.baE().ban().set(at.a.addE, Integer.valueOf(1));
        break;
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 50L, 1L, false);
        break label1540;
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 51L, 1L, false);
        break label1540;
        if (paramInt1 != ACB) {
          break label1540;
        }
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 52L, 1L, false);
        break label1540;
      }
    }
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(165229);
    this.callback = paramh;
    int i = dispatch(paramg, (com.tencent.mm.network.s)this.rr, (m)this);
    AppMethodBeat.o(165229);
    return i;
  }
  
  public final int getType()
  {
    return 978;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "", "lastBuf", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    static int MY(int paramInt)
    {
      AppMethodBeat.i(336436);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(336436);
        return 0;
      case 2: 
        paramInt = cp.dWb();
        AppMethodBeat.o(336436);
        return paramInt;
      }
      paramInt = cp.dWc();
      AppMethodBeat.o(336436);
      return paramInt;
    }
    
    public static byte[] hp(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(336451);
      paramInt1 = MY(paramInt1);
      if (paramInt1 == cp.dWc()) {
        switch (paramInt2)
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(336451);
        return new byte[0];
        localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addx, "");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(336451);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if ((localObject == null) && (kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.addF, Integer.valueOf(0)), Integer.valueOf(1)))) {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 55L, 1L, false);
        }
        kotlin.g.b.s.s(localObject, "lastBuf");
        AppMethodBeat.o(336451);
        return localObject;
        localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addy, "");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(336451);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if ((localObject == null) && (kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.addG, Integer.valueOf(0)), Integer.valueOf(1)))) {
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 56L, 1L, false);
        }
        kotlin.g.b.s.s(localObject, "lastBuf");
        AppMethodBeat.o(336451);
        return localObject;
        localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addz, "");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(336451);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null) {
          kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.addH, Integer.valueOf(0)), Integer.valueOf(1));
        }
        kotlin.g.b.s.s(localObject, "lastBuf");
        AppMethodBeat.o(336451);
        return localObject;
        localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addA, "");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(336451);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null) {
          kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.addI, Integer.valueOf(0)), Integer.valueOf(1));
        }
        kotlin.g.b.s.s(localObject, "lastBuf");
        AppMethodBeat.o(336451);
        return localObject;
        localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addB, "");
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(336451);
          throw ((Throwable)localObject);
        }
        localObject = Util.decodeHexString((String)localObject);
        if (localObject == null) {
          kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.addJ, Integer.valueOf(0)), Integer.valueOf(1));
        }
        kotlin.g.b.s.s(localObject, "lastBuf");
        AppMethodBeat.o(336451);
        return localObject;
        if (paramInt1 == cp.dWb()) {
          switch (paramInt2)
          {
          }
        }
      }
      Object localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.adds, "");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(336451);
        throw ((Throwable)localObject);
      }
      localObject = Util.decodeHexString((String)localObject);
      if ((localObject == null) && (kotlin.g.b.s.p(com.tencent.mm.kernel.h.baE().ban().get(at.a.addG, Integer.valueOf(0)), Integer.valueOf(1)))) {
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(1279L, 57L, 1L, false);
      }
      kotlin.g.b.s.s(localObject, "lastBuf");
      AppMethodBeat.o(336451);
      return localObject;
      localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addt, "");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(336451);
        throw ((Throwable)localObject);
      }
      localObject = Util.decodeHexString((String)localObject);
      kotlin.g.b.s.s(localObject, "decodeHexString(MMKernel…RING_SYNC, \"\") as String)");
      AppMethodBeat.o(336451);
      return localObject;
      localObject = com.tencent.mm.kernel.h.baE().ban().get(at.a.addu, "");
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(336451);
        throw ((Throwable)localObject);
      }
      localObject = Util.decodeHexString((String)localObject);
      kotlin.g.b.s.s(localObject, "decodeHexString(MMKernel…RING_SYNC, \"\") as String)");
      AppMethodBeat.o(336451);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.cp
 * JD-Core Version:    0.7.0.1
 */
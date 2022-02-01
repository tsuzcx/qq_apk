package com.tencent.mm.plugin.finder.cgi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.aol;
import com.tencent.mm.protocal.protobuf.aom;
import com.tencent.mm.protocal.protobuf.apq;
import com.tencent.mm.protocal.protobuf.aps;
import com.tencent.mm.protocal.protobuf.apt;
import com.tencent.mm.protocal.protobuf.apu;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ao
  extends ad
{
  private static final String TAG = "Finder.NetSceneFinderGetMentionList";
  private static final int rRF = 1;
  private static final int rRG = 2;
  public static final a rRH;
  private f callback;
  public final LinkedList<ac> gow;
  public int rRE;
  private com.tencent.mm.ak.b rr;
  public int scene;
  
  static
  {
    AppMethodBeat.i(165232);
    rRH = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    rRF = 1;
    rRG = 2;
    AppMethodBeat.o(165232);
  }
  
  public ao(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.gow = new LinkedList();
    this.rRE = paramInt2;
    this.scene = paramInt1;
    Object localObject2 = new b.a();
    ((b.a)localObject2).oS(getType());
    aol localaol = new aol();
    localaol.rRE = paramInt2;
    int i = a.Ex(paramInt1);
    Object localObject1;
    label105:
    StringBuilder localStringBuilder;
    if (i == rRG) {
      switch (paramInt2)
      {
      default: 
        localObject1 = new byte[0];
        localaol.rPQ = com.tencent.mm.bw.b.cm((byte[])localObject1);
        localaol.scene = a.Ex(this.scene);
        localaol.username = com.tencent.mm.model.v.aAK();
        localObject1 = v.rRb;
        localaol.GDR = v.czz();
        ((b.a)localObject2).c((a)localaol);
        ((b.a)localObject2).d((a)new aom());
        ((b.a)localObject2).DN("/cgi-bin/micromsg-bin/findergetmentionlist");
        localObject1 = ((b.a)localObject2).aDS();
        p.g(localObject1, "builder.buildInstance()");
        this.rr = ((com.tencent.mm.ak.b)localObject1);
        localObject2 = TAG;
        localStringBuilder = new StringBuilder("NetSceneFinderGetMentionList init, scene ").append(paramInt1).append(" type ").append(paramInt2).append(" lastBuf ");
        if (localaol.rPQ == null) {
          localObject1 = "null";
        }
        break;
      }
    }
    for (;;)
    {
      ae.i((String)localObject2, localObject1);
      AppMethodBeat.o(165231);
      return;
      localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.JcZ, "");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bu.aSx((String)localObject1);
      p.g(localObject1, "lastBuf");
      break label105;
      localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.Jda, "");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bu.aSx((String)localObject1);
      p.g(localObject1, "lastBuf");
      break label105;
      if (i != rRF) {
        break;
      }
      localObject1 = g.ajR();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajA().get(am.a.JcW, "");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bu.aSx((String)localObject1);
      p.g(localObject1, "lastBuf");
      break label105;
      localObject1 = localaol.rPQ;
      if (localObject1 != null) {
        localObject1 = Integer.valueOf(((com.tencent.mm.bw.b)localObject1).size());
      } else {
        localObject1 = null;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(165229);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165229);
    return i;
  }
  
  public final int getType()
  {
    return 978;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165230);
    ae.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    com.tencent.mm.bw.b localb;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      localb = ((aom)paramq).rPQ;
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      paramArrayOfByte = ((aom)paramq).GFR;
      if (paramArrayOfByte != null)
      {
        ae.i(TAG, "GetMentionList size " + paramArrayOfByte.GGW.size());
        paramq = paramArrayOfByte.GGW;
        p.g(paramq, "it.mentions");
        ((Collection)paramq).isEmpty();
        paramq = paramArrayOfByte.GGW;
        p.g(paramq, "mentionList.mentions");
        localObject1 = ((Iterable)paramq).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (apq)((Iterator)localObject1).next();
          localObject3 = this.gow;
          paramq = d.sLu;
          p.g(localObject2, "mention");
          p.h(localObject2, "mention");
          localObject4 = new ac();
          ((ac)localObject4).field_headUrl = ((apq)localObject2).headUrl;
          if (((apq)localObject2).GGR != 0)
          {
            paramq = new aps();
            paramq.GGR = ((apq)localObject2).GGR;
            paramq.GGQ = ((apq)localObject2).GGQ;
            ((ac)localObject4).field_aggregatedContacts = paramq;
            label361:
            ((ac)localObject4).field_nickname = ((apq)localObject2).bVF;
            ((ac)localObject4).field_type = ((apq)localObject2).GFQ;
            ((ac)localObject4).field_content = ((apq)localObject2).GGK;
            ((ac)localObject4).field_createTime = ((apq)localObject2).icw;
            ((ac)localObject4).field_thumbUrl = ((apq)localObject2).thumbUrl;
            ((ac)localObject4).field_id = ((apq)localObject2).id;
            ((ac)localObject4).field_objectId = ((apq)localObject2).rRn;
            ((ac)localObject4).field_objectNonceId = ((apq)localObject2).objectNonceId;
            ((ac)localObject4).field_commentId = ((apq)localObject2).commentId;
            ((ac)localObject4).field_flag = ((apq)localObject2).dEu;
            ((ac)localObject4).field_refContent = ((apq)localObject2).GGL;
            ((ac)localObject4).field_extFlag = ((apq)localObject2).extFlag;
            ((ac)localObject4).field_notify = ((apq)localObject2).GGM;
            ((ac)localObject4).field_mediaType = ((apq)localObject2).mediaType;
            ((ac)localObject4).field_description = ((apq)localObject2).description;
            ((ac)localObject4).field_replayUsername = ((apq)localObject2).GEx;
            ((ac)localObject4).field_replayNickname = ((apq)localObject2).replyNickname;
            ((ac)localObject4).field_username = ((apq)localObject2).username;
            paramq = ((apq)localObject2).GGN;
            if (paramq == null) {
              break label690;
            }
            paramq = paramq.contact;
            label560:
            ((ac)localObject4).field_contact = paramq;
            paramq = ((apq)localObject2).GGO;
            if (paramq == null) {
              break label696;
            }
          }
          label690:
          label696:
          for (paramq = paramq.contact;; paramq = null)
          {
            ((ac)localObject4).field_replyContact = paramq;
            paramq = g.ajR();
            p.g(paramq, "MMKernel.storage()");
            ((ac)localObject4).field_userVersion = paramq.ajA().getInt(am.a.JcJ, 0);
            ((ac)localObject4).field_followExpireTime = ((apq)localObject2).GGS;
            ((ac)localObject4).field_clientMsgId = ((apq)localObject2).fmu;
            ((ac)localObject4).field_followId = ((apq)localObject2).GFv;
            ((ac)localObject4).field_objectType = ((apq)localObject2).objectType;
            ((LinkedList)localObject3).add(localObject4);
            break;
            ((ac)localObject4).field_aggregatedContacts = new aps();
            break label361;
            paramq = null;
            break label560;
          }
        }
        paramq = paramArrayOfByte.GGW;
        p.g(paramq, "it.mentions");
        ((Collection)paramq).isEmpty();
        paramq = paramArrayOfByte.GGW;
        p.g(paramq, "mentionList.mentions");
        localObject1 = ((Iterable)paramq).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramq = (apq)((Iterator)localObject1).next();
          if ((paramq.GFQ == 10) && (!bu.isNullOrNil(paramq.fmu)))
          {
            ae.i(TAG, "MENTION_TYPE_FOLLOW_APPLICATION APPROVED, clean db, username:" + paramq.username + ", clientMsgId:" + paramq.fmu + " scene:" + this.scene);
            paramArrayOfByte = d.sLu;
            paramq = paramq.fmu;
            if (paramq != null) {
              break label1778;
            }
            paramq = "";
          }
        }
      }
    }
    label1220:
    label1380:
    label1641:
    label1778:
    for (;;)
    {
      paramInt1 = this.scene;
      p.h(paramq, "clientMsgId");
      localObject3 = ((PluginFinder)g.ad(PluginFinder.class)).getMentionStorage(d.a.FU(paramInt1));
      paramArrayOfByte = g.ajR();
      p.g(paramArrayOfByte, "MMKernel.storage()");
      int i = paramArrayOfByte.ajA().getInt(am.a.JcJ, 0);
      if (d.a.FU(paramInt1) == 1) {}
      for (paramArrayOfByte = ci.fbd;; paramArrayOfByte = ci.fbc)
      {
        localObject2 = "DELETE FROM " + paramArrayOfByte + ' ' + " WHERE type=10  AND clientMsgId='" + paramq + "'  AND userVersion=" + i + ' ';
        paramq = "SELECT * FROM " + paramArrayOfByte + ' ' + " WHERE type=10  AND clientMsgId='" + paramq + "'  AND userVersion=" + i + ' ';
        if (!com.tencent.mm.sdk.platformtools.j.IS_FLAVOR_PURPLE) {
          break label1220;
        }
        localObject4 = ((com.tencent.mm.sdk.e.j)localObject3).rawQuery(paramq, new String[0]);
        bool = ((com.tencent.mm.sdk.e.j)localObject3).execSQL(paramArrayOfByte, (String)localObject2);
        paramArrayOfByte = ((com.tencent.mm.sdk.e.j)localObject3).rawQuery(paramq, new String[0]);
        localObject3 = d.access$getTAG$cp();
        StringBuilder localStringBuilder = new StringBuilder("removePrivateMention, before:");
        p.g(localObject4, "q1");
        localObject4 = localStringBuilder.append(((Cursor)localObject4).getCount()).append(", after:");
        p.g(paramArrayOfByte, "q2");
        ae.i((String)localObject3, paramArrayOfByte.getCount() + ", querySql:" + paramq);
        ae.i(d.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject2);
        break;
      }
      boolean bool = ((com.tencent.mm.sdk.e.j)localObject3).execSQL(paramArrayOfByte, (String)localObject2);
      ae.i(d.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject2);
      break;
      if (!((Collection)this.gow).isEmpty())
      {
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramq = d.sLu;
          d.a.q((List)this.gow, this.scene);
        }
        if (localb != null)
        {
          i = this.scene;
          paramInt1 = this.rRE;
          paramq = localb.toByteArray();
          p.g(paramq, "it.toByteArray()");
          i = a.Ex(i);
          if (i != rRG) {
            break label1641;
          }
        }
        switch (paramInt1)
        {
        default: 
          if ((localb != null) && (localb.size() == 0))
          {
            paramInt1 = a.Ex(this.scene);
            if (paramInt1 != rRG) {
              break;
            }
          }
          else
          {
            switch (this.rRE)
            {
            default: 
              paramArrayOfByte = TAG;
              localObject1 = new StringBuilder("lastBuf ");
              if (localb != null) {}
              break;
            }
          }
          break;
        }
      }
      for (paramq = "null";; paramq = Integer.valueOf(localb.size()))
      {
        ae.i(paramArrayOfByte, paramq);
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            p.gkB();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        }
        AppMethodBeat.o(165230);
        return;
        paramInt1 = 0;
        break;
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JcZ, bu.cH(paramq));
        paramq = g.ajR();
        p.g(paramq, "MMKernel.storage()");
        paramq.ajA().set(am.a.Jdc, Integer.valueOf(1));
        break label1380;
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.Jda, bu.cH(paramq));
        paramq = g.ajR();
        p.g(paramq, "MMKernel.storage()");
        paramq.ajA().set(am.a.Jdd, Integer.valueOf(1));
        break label1380;
        if (i != rRF) {
          break label1380;
        }
        paramArrayOfByte = g.ajR();
        p.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.ajA().set(am.a.JcW, bu.cH(paramq));
        paramq = g.ajR();
        p.g(paramq, "MMKernel.storage()");
        paramq.ajA().set(am.a.Jdb, Integer.valueOf(1));
        break label1380;
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 50L, 1L, false);
        break label1436;
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 51L, 1L, false);
        break label1436;
        if (paramInt1 != rRF) {
          break label1436;
        }
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 52L, 1L, false);
        break label1436;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "", "lastBuf", "plugin-finder_release"})
  public static final class a
  {
    static int Ex(int paramInt)
    {
      AppMethodBeat.i(201561);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201561);
        return 0;
      case 2: 
        paramInt = ao.czS();
        AppMethodBeat.o(201561);
        return paramInt;
      }
      paramInt = ao.czT();
      AppMethodBeat.o(201561);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ao
 * JD-Core Version:    0.7.0.1
 */
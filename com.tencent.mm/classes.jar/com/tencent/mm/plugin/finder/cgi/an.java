package com.tencent.mm.plugin.finder.cgi;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.g.c.ci;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.any;
import com.tencent.mm.protocal.protobuf.anz;
import com.tencent.mm.protocal.protobuf.apd;
import com.tencent.mm.protocal.protobuf.apf;
import com.tencent.mm.protocal.protobuf.apg;
import com.tencent.mm.protocal.protobuf.aph;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.i;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class an
  extends ac
{
  private static final String TAG = "Finder.NetSceneFinderGetMentionList";
  private static final int rJr = 1;
  private static final int rJs = 2;
  public static final a rJt;
  private f callback;
  public final LinkedList<com.tencent.mm.plugin.finder.storage.ac> gma;
  public int rJq;
  private com.tencent.mm.al.b rr;
  public int scene;
  
  static
  {
    AppMethodBeat.i(165232);
    rJt = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    rJr = 1;
    rJs = 2;
    AppMethodBeat.o(165232);
  }
  
  public an(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.gma = new LinkedList();
    this.rJq = paramInt2;
    this.scene = paramInt1;
    Object localObject2 = new b.a();
    ((b.a)localObject2).oP(getType());
    any localany = new any();
    localany.rJq = paramInt2;
    int i = a.Ek(paramInt1);
    label105:
    StringBuilder localStringBuilder;
    if (i == rJs) {
      switch (paramInt2)
      {
      default: 
        localObject1 = new byte[0];
        localany.rHF = com.tencent.mm.bx.b.cj((byte[])localObject1);
        localany.scene = a.Ek(this.scene);
        localany.username = u.aAu();
        localObject1 = v.rIR;
        localany.Glv = v.cxY();
        ((b.a)localObject2).c((a)localany);
        ((b.a)localObject2).d((a)new anz());
        ((b.a)localObject2).Dl("/cgi-bin/micromsg-bin/findergetmentionlist");
        localObject1 = ((b.a)localObject2).aDC();
        p.g(localObject1, "builder.buildInstance()");
        this.rr = ((com.tencent.mm.al.b)localObject1);
        localObject2 = TAG;
        localStringBuilder = new StringBuilder("NetSceneFinderGetMentionList init, scene ").append(paramInt1).append(" type ").append(paramInt2).append(" lastBuf ");
        if (localany.rHF != null) {
          break;
        }
      }
    }
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(localany.rHF.size()))
    {
      ad.i((String)localObject2, localObject1);
      AppMethodBeat.o(165231);
      return;
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(al.a.IIw, "");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bt.aRa((String)localObject1);
      p.g(localObject1, "lastBuf");
      break label105;
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(al.a.IIx, "");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bt.aRa((String)localObject1);
      p.g(localObject1, "lastBuf");
      break label105;
      if (i != rJr) {
        break;
      }
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).ajl().get(al.a.IIt, "");
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bt.aRa((String)localObject1);
      p.g(localObject1, "lastBuf");
      break label105;
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
    ad.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    Object localObject1;
    Object localObject2;
    label361:
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      paramArrayOfByte = ((anz)paramq).rHF;
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      localObject1 = ((anz)paramq).GmK;
      if (localObject1 != null)
      {
        ad.i(TAG, "GetMentionList size " + ((aph)localObject1).GnQ.size());
        paramq = ((aph)localObject1).GnQ;
        p.g(paramq, "it.mentions");
        ((Collection)paramq).isEmpty();
        paramq = ((aph)localObject1).GnQ;
        p.g(paramq, "mentionList.mentions");
        localObject2 = ((Iterable)paramq).iterator();
        Object localObject3;
        Object localObject4;
        Object localObject5;
        if (((Iterator)localObject2).hasNext())
        {
          localObject3 = (apd)((Iterator)localObject2).next();
          localObject4 = this.gma;
          paramq = d.sAw;
          p.g(localObject3, "mention");
          p.h(localObject3, "mention");
          localObject5 = new com.tencent.mm.plugin.finder.storage.ac();
          ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_headUrl = ((apd)localObject3).headUrl;
          if (((apd)localObject3).GnL != 0)
          {
            paramq = new apf();
            paramq.GnL = ((apd)localObject3).GnL;
            paramq.GnK = ((apd)localObject3).GnK;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_aggregatedContacts = paramq;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_nickname = ((apd)localObject3).bVF;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_type = ((apd)localObject3).GmJ;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_content = ((apd)localObject3).GnE;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_createTime = ((apd)localObject3).hZE;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_thumbUrl = ((apd)localObject3).thumbUrl;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_id = ((apd)localObject3).id;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_objectId = ((apd)localObject3).rIZ;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_objectNonceId = ((apd)localObject3).objectNonceId;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_commentId = ((apd)localObject3).commentId;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_flag = ((apd)localObject3).dDp;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_refContent = ((apd)localObject3).GnF;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_extFlag = ((apd)localObject3).extFlag;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_notify = ((apd)localObject3).GnG;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_mediaType = ((apd)localObject3).mediaType;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_description = ((apd)localObject3).description;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_replayUsername = ((apd)localObject3).Glu;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_replayNickname = ((apd)localObject3).replyNickname;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_username = ((apd)localObject3).username;
            paramq = ((apd)localObject3).GnH;
            if (paramq == null) {
              break label679;
            }
            paramq = paramq.contact;
            label560:
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_contact = paramq;
            paramq = ((apd)localObject3).GnI;
            if (paramq == null) {
              break label685;
            }
          }
          label679:
          label685:
          for (paramq = paramq.contact;; paramq = null)
          {
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_replyContact = paramq;
            paramq = g.ajC();
            p.g(paramq, "MMKernel.storage()");
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_userVersion = paramq.ajl().getInt(al.a.IIg, 0);
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_followExpireTime = ((apd)localObject3).GnM;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_clientMsgId = ((apd)localObject3).fkx;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_followId = ((apd)localObject3).Gmn;
            ((LinkedList)localObject4).add(localObject5);
            break;
            ((com.tencent.mm.plugin.finder.storage.ac)localObject5).field_aggregatedContacts = new apf();
            break label361;
            paramq = null;
            break label560;
          }
        }
        paramq = ((aph)localObject1).GnQ;
        p.g(paramq, "it.mentions");
        ((Collection)paramq).isEmpty();
        paramq = ((aph)localObject1).GnQ;
        p.g(paramq, "mentionList.mentions");
        localObject1 = ((Iterable)paramq).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          paramq = (apd)((Iterator)localObject1).next();
          if ((paramq.GmJ == 10) && (!bt.isNullOrNil(paramq.fkx)))
          {
            ad.i(TAG, "MENTION_TYPE_FOLLOW_APPLICATION APPROVED, clean db, username:" + paramq.username + ", clientMsgId:" + paramq.fkx + " scene:" + this.scene);
            localObject2 = d.sAw;
            localObject4 = paramq.fkx;
            p.g(localObject4, "mention.clientMsgId");
            paramInt1 = this.scene;
            p.h(localObject4, "clientMsgId");
            localObject3 = ((PluginFinder)g.ad(PluginFinder.class)).getMentionStorage(d.a.Fx(paramInt1));
            paramq = g.ajC();
            p.g(paramq, "MMKernel.storage()");
            i = paramq.ajl().getInt(al.a.IIg, 0);
            if (d.a.Fx(paramInt1) == 1) {}
            for (paramq = ci.eZq;; paramq = ci.eZp)
            {
              localObject2 = "DELETE FROM " + paramq + ' ' + " WHERE type=10  AND clientMsgId='" + (String)localObject4 + "'  AND userVersion=" + i + ' ';
              localObject4 = "SELECT * FROM " + paramq + ' ' + " WHERE type=10  AND clientMsgId='" + (String)localObject4 + "'  AND userVersion=" + i + ' ';
              if (!i.IS_FLAVOR_PURPLE) {
                break label1208;
              }
              localObject5 = ((j)localObject3).rawQuery((String)localObject4, new String[0]);
              bool = ((j)localObject3).execSQL(paramq, (String)localObject2);
              paramq = ((j)localObject3).rawQuery((String)localObject4, new String[0]);
              localObject3 = d.access$getTAG$cp();
              StringBuilder localStringBuilder = new StringBuilder("removePrivateMention, before:");
              p.g(localObject5, "q1");
              localObject5 = localStringBuilder.append(((Cursor)localObject5).getCount()).append(", after:");
              p.g(paramq, "q2");
              ad.i((String)localObject3, paramq.getCount() + ", querySql:" + (String)localObject4);
              ad.i(d.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject2);
              break;
            }
            label1208:
            boolean bool = ((j)localObject3).execSQL(paramq, (String)localObject2);
            ad.i(d.access$getTAG$cp(), "removePrivateMention, succ " + bool + ",  sql " + (String)localObject2);
          }
        }
        if (((Collection)this.gma).isEmpty()) {
          break label1508;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramq = d.sAw;
          d.a.p((List)this.gma, this.scene);
        }
      }
      if (paramArrayOfByte != null)
      {
        i = this.scene;
        paramInt1 = this.rJq;
        paramq = paramArrayOfByte.toByteArray();
        p.g(paramq, "it.toByteArray()");
        i = a.Ek(i);
        if (i != rJs) {
          break label1629;
        }
      }
      switch (paramInt1)
      {
      default: 
        label1368:
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() == 0))
        {
          paramInt1 = a.Ek(this.scene);
          if (paramInt1 != rJs) {
            break;
          }
        }
        else
        {
          switch (this.rJq)
          {
          default: 
            localObject1 = TAG;
            localObject2 = new StringBuilder("lastBuf ");
            if (paramArrayOfByte != null) {}
            break;
          }
        }
        label1424:
        break;
      }
    }
    for (paramq = "null";; paramq = Integer.valueOf(paramArrayOfByte.size()))
    {
      ad.i((String)localObject1, paramq);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165230);
      return;
      label1508:
      paramInt1 = 0;
      break;
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IIw, bt.cE(paramq));
      paramq = g.ajC();
      p.g(paramq, "MMKernel.storage()");
      paramq.ajl().set(al.a.IIz, Integer.valueOf(1));
      break label1368;
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IIx, bt.cE(paramq));
      paramq = g.ajC();
      p.g(paramq, "MMKernel.storage()");
      paramq.ajl().set(al.a.IIA, Integer.valueOf(1));
      break label1368;
      label1629:
      if (i != rJr) {
        break label1368;
      }
      localObject1 = g.ajC();
      p.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IIt, bt.cE(paramq));
      paramq = g.ajC();
      p.g(paramq, "MMKernel.storage()");
      paramq.ajl().set(al.a.IIy, Integer.valueOf(1));
      break label1368;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 50L, 1L, false);
      break label1424;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 51L, 1L, false);
      break label1424;
      if (paramInt1 != rJr) {
        break label1424;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 52L, 1L, false);
      break label1424;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "", "lastBuf", "plugin-finder_release"})
  public static final class a
  {
    static int Ek(int paramInt)
    {
      AppMethodBeat.i(201139);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201139);
        return 0;
      case 2: 
        paramInt = an.cyr();
        AppMethodBeat.o(201139);
        return paramInt;
      }
      paramInt = an.cys();
      AppMethodBeat.o(201139);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.an
 * JD-Core Version:    0.7.0.1
 */
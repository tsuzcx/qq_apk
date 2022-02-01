package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.bw.a;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.akx;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.alx;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.ama;
import com.tencent.mm.protocal.protobuf.amb;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ag
  extends w
{
  private static final String TAG = "Finder.NetSceneFinderGetMentionList";
  private static final int qYf = 1;
  private static final int qYg = 2;
  public static final a qYh;
  private com.tencent.mm.ak.g callback;
  public final LinkedList<com.tencent.mm.plugin.finder.storage.u> fSw;
  public int qYe;
  private com.tencent.mm.ak.b rr;
  public int scene;
  
  static
  {
    AppMethodBeat.i(165232);
    qYh = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    qYf = 1;
    qYg = 2;
    AppMethodBeat.o(165232);
  }
  
  public ag(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.fSw = new LinkedList();
    this.qYe = paramInt2;
    this.scene = paramInt1;
    Object localObject2 = new b.a();
    ((b.a)localObject2).op(getType());
    akx localakx = new akx();
    localakx.qYe = paramInt2;
    int i = a.Dr(paramInt1);
    label105:
    StringBuilder localStringBuilder;
    if (i == qYg) {
      switch (paramInt2)
      {
      default: 
        localObject1 = new byte[0];
        localakx.rpX = com.tencent.mm.bw.b.cc((byte[])localObject1);
        localakx.scene = a.Dr(this.scene);
        localakx.username = com.tencent.mm.model.u.axE();
        localObject1 = q.qXH;
        localakx.EDL = q.csi();
        ((b.a)localObject2).c((a)localakx);
        ((b.a)localObject2).d((a)new aky());
        ((b.a)localObject2).Am("/cgi-bin/micromsg-bin/findergetmentionlist");
        localObject1 = ((b.a)localObject2).aAz();
        d.g.b.k.g(localObject1, "builder.buildInstance()");
        this.rr = ((com.tencent.mm.ak.b)localObject1);
        localObject2 = TAG;
        localStringBuilder = new StringBuilder("NetSceneFinderGetMentionList init, scene ").append(paramInt1).append(" type ").append(paramInt2).append(" lastBuf ");
        if (localakx.rpX != null) {
          break;
        }
      }
    }
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(localakx.rpX.size()))
    {
      ac.i((String)localObject2, localObject1);
      AppMethodBeat.o(165231);
      return;
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GVG, "");
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bs.aLu((String)localObject1);
      d.g.b.k.g(localObject1, "lastBuf");
      break label105;
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GVH, "");
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bs.aLu((String)localObject1);
      d.g.b.k.g(localObject1, "lastBuf");
      break label105;
      if (i != qYf) {
        break;
      }
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      localObject1 = ((com.tencent.mm.kernel.e)localObject1).agA().get(ah.a.GVF, "");
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject1);
      }
      localObject1 = bs.aLu((String)localObject1);
      d.g.b.k.g(localObject1, "lastBuf");
      break label105;
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165229);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165229);
    return i;
  }
  
  public final int getType()
  {
    return 978;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165230);
    ac.i(TAG, "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    Object localObject1;
    Object localObject2;
    label361:
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      paramArrayOfByte = ((aky)paramq).rpX;
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      paramq = ((aky)paramq).EEN;
      if (paramq != null)
      {
        ac.i(TAG, "GetMentionList size " + paramq.EFB.size());
        localObject1 = paramq.EFB;
        d.g.b.k.g(localObject1, "it.mentions");
        ((Collection)localObject1).isEmpty();
        paramq = paramq.EFB;
        d.g.b.k.g(paramq, "mentionList.mentions");
        localObject1 = ((Iterable)paramq).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          alx localalx = (alx)((Iterator)localObject1).next();
          localObject2 = this.fSw;
          paramq = d.rFp;
          d.g.b.k.g(localalx, "mention");
          d.g.b.k.h(localalx, "mention");
          com.tencent.mm.plugin.finder.storage.u localu = new com.tencent.mm.plugin.finder.storage.u();
          localu.field_headUrl = localalx.headUrl;
          if (localalx.EFx != 0)
          {
            paramq = new alz();
            paramq.EFx = localalx.EFx;
            paramq.EFw = localalx.EFw;
            localu.field_aggregatedContacts = paramq;
            localu.field_nickname = localalx.bLs;
            localu.field_type = localalx.EEM;
            localu.field_content = localalx.EFq;
            localu.field_createTime = localalx.hGU;
            localu.field_thumbUrl = localalx.thumbUrl;
            localu.field_id = localalx.id;
            localu.field_objectId = localalx.qXP;
            localu.field_objectNonceId = localalx.objectNonceId;
            localu.field_commentId = localalx.commentId;
            localu.field_flag = localalx.drx;
            localu.field_refContent = localalx.EFr;
            localu.field_extFlag = localalx.extFlag;
            localu.field_notify = localalx.EFs;
            localu.field_mediaType = localalx.mediaType;
            localu.field_description = localalx.description;
            localu.field_replayUsername = localalx.EDK;
            localu.field_replayNickname = localalx.replyNickname;
            localu.field_username = localalx.username;
            paramq = localalx.EFt;
            if (paramq == null) {
              break label648;
            }
            paramq = paramq.contact;
            label560:
            localu.field_contact = paramq;
            paramq = localalx.EFu;
            if (paramq == null) {
              break label654;
            }
          }
          label648:
          label654:
          for (paramq = paramq.contact;; paramq = null)
          {
            localu.field_replyContact = paramq;
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            localu.field_userVersion = paramq.agA().getInt(ah.a.GVw, 0);
            ((LinkedList)localObject2).add(localu);
            break;
            localu.field_aggregatedContacts = new alz();
            break label361;
            paramq = null;
            break label560;
          }
        }
        if (((Collection)this.fSw).isEmpty()) {
          break label912;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramq = d.rFp;
          d.a.n((List)this.fSw, this.scene);
        }
      }
      if (paramArrayOfByte != null)
      {
        i = this.scene;
        paramInt1 = this.qYe;
        paramq = paramArrayOfByte.toByteArray();
        d.g.b.k.g(paramq, "it.toByteArray()");
        i = a.Dr(i);
        if (i != qYg) {
          break label1033;
        }
      }
      switch (paramInt1)
      {
      default: 
        label772:
        if ((paramArrayOfByte != null) && (paramArrayOfByte.size() == 0))
        {
          paramInt1 = a.Dr(this.scene);
          if (paramInt1 != qYg) {
            break;
          }
        }
        else
        {
          switch (this.qYe)
          {
          default: 
            label828:
            localObject1 = TAG;
            localObject2 = new StringBuilder("lastBuf ");
            if (paramArrayOfByte != null) {}
            break;
          }
        }
        break;
      }
    }
    for (paramq = "null";; paramq = Integer.valueOf(paramArrayOfByte.size()))
    {
      ac.i((String)localObject1, paramq);
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165230);
      return;
      label912:
      paramInt1 = 0;
      break;
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GVG, bs.cx(paramq));
      paramq = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq.agA().set(ah.a.GVJ, Integer.valueOf(1));
      break label772;
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GVH, bs.cx(paramq));
      paramq = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq.agA().set(ah.a.GVK, Integer.valueOf(1));
      break label772;
      label1033:
      if (i != qYf) {
        break label772;
      }
      localObject1 = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(localObject1, "MMKernel.storage()");
      ((com.tencent.mm.kernel.e)localObject1).agA().set(ah.a.GVF, bs.cx(paramq));
      paramq = com.tencent.mm.kernel.g.agR();
      d.g.b.k.g(paramq, "MMKernel.storage()");
      paramq.agA().set(ah.a.GVI, Integer.valueOf(1));
      break label772;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 50L, 1L, false);
      break label828;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 51L, 1L, false);
      break label828;
      if (paramInt1 != qYf) {
        break label828;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 52L, 1L, false);
      break label828;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "clearLastBuf", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "lastBuf", "plugin-finder_release"})
  public static final class a
  {
    static int Dr(int paramInt)
    {
      AppMethodBeat.i(201191);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(201191);
        return 0;
      case 2: 
        paramInt = ag.csA();
        AppMethodBeat.o(201191);
        return paramInt;
      }
      paramInt = ag.csB();
      AppMethodBeat.o(201191);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ag
 * JD-Core Version:    0.7.0.1
 */
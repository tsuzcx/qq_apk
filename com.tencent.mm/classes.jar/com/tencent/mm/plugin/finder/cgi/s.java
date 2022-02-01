package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.logic.d;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.protocal.protobuf.ajf;
import com.tencent.mm.protocal.protobuf.ajg;
import com.tencent.mm.protocal.protobuf.aju;
import com.tencent.mm.protocal.protobuf.ajv;
import com.tencent.mm.protocal.protobuf.dzg;
import com.tencent.mm.protocal.protobuf.dzh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import d.v;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "scene", "", "requestScene", "(II)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "mentionType", "resultList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getMentionList", "getRequestScene", "getScene", "getType", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class s
  extends ap
{
  private static final String TAG = "Finder.NetSceneFinderGetMentionList";
  private static final int qoI = 1;
  private static final int qpk = 2;
  public static final a qpl;
  public int KJH;
  private com.tencent.mm.al.g callback;
  public final LinkedList<com.tencent.mm.plugin.finder.storage.l> fOL;
  private com.tencent.mm.al.b rr;
  public int scene;
  
  static
  {
    AppMethodBeat.i(165232);
    qpl = new a((byte)0);
    TAG = "Finder.NetSceneFinderGetMentionList";
    qoI = 1;
    qpk = 2;
    AppMethodBeat.o(165232);
  }
  
  public s(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(165231);
    this.fOL = new LinkedList();
    this.KJH = paramInt2;
    this.scene = paramInt1;
    b.a locala = new b.a();
    locala.nB(getType());
    ajf localajf = new ajf();
    localajf.KJH = paramInt2;
    int i = a.ahc(paramInt1);
    Object localObject;
    if (i == qpk) {
      switch (paramInt2)
      {
      default: 
        localObject = new byte[0];
      }
    }
    for (;;)
    {
      localajf.qKW = com.tencent.mm.bx.b.cd((byte[])localObject);
      localajf.scene = a.ahc(this.scene);
      localajf.username = u.aqO();
      localObject = am.KJy;
      localajf.Dkw = am.fRS();
      locala.c((a)localajf);
      locala.d((a)new ajg());
      locala.wg("/cgi-bin/micromsg-bin/findergetmentionlist");
      localObject = locala.atI();
      d.g.b.k.g(localObject, "builder.buildInstance()");
      this.rr = ((com.tencent.mm.al.b)localObject);
      ad.i(TAG, "NetSceneFinderGetMentionList init, scene " + paramInt1 + " type " + paramInt2);
      AppMethodBeat.o(165231);
      return;
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.LBl, "");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject);
      }
      localObject = bt.aGd((String)localObject);
      d.g.b.k.g(localObject, "Util.decodeHexString(MMK…RING_SYNC, \"\") as String)");
      continue;
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.LBm, "");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject);
      }
      localObject = bt.aGd((String)localObject);
      d.g.b.k.g(localObject, "Util.decodeHexString(MMK…RING_SYNC, \"\") as String)");
      continue;
      if (i != qoI) {
        break;
      }
      localObject = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(localObject, "MMKernel.storage()");
      localObject = ((com.tencent.mm.kernel.e)localObject).afk().get(ae.a.LBk, "");
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.String");
        AppMethodBeat.o(165231);
        throw ((Throwable)localObject);
      }
      localObject = bt.aGd((String)localObject);
      d.g.b.k.g(localObject, "Util.decodeHexString(MMK…RING_SYNC, \"\") as String)");
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165229);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
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
    label560:
    label639:
    int i;
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      paramArrayOfByte = ((ajg)paramq).qKW;
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderGetMentionListResponse");
        AppMethodBeat.o(165230);
        throw paramString;
      }
      paramq = ((ajg)paramq).Dlw;
      if (paramq != null)
      {
        ad.i(TAG, "GetMentionList size " + paramq.DlM.size());
        Object localObject = paramq.DlM;
        d.g.b.k.g(localObject, "it.mentions");
        ((Collection)localObject).isEmpty();
        paramq = paramq.DlM;
        d.g.b.k.g(paramq, "mentionList.mentions");
        localObject = ((Iterable)paramq).iterator();
        if (((Iterator)localObject).hasNext())
        {
          aju localaju = (aju)((Iterator)localObject).next();
          LinkedList localLinkedList = this.fOL;
          paramq = d.qKK;
          d.g.b.k.g(localaju, "mention");
          d.g.b.k.h(localaju, "mention");
          com.tencent.mm.plugin.finder.storage.l locall = new com.tencent.mm.plugin.finder.storage.l();
          locall.field_headUrl = localaju.headUrl;
          if (localaju.LxM != 0)
          {
            paramq = new dzg();
            paramq.LxM = localaju.LxM;
            paramq.LxL = localaju.LxL;
            locall.field_aggregatedContacts = paramq;
          }
          locall.field_nickname = localaju.bNK;
          locall.field_type = localaju.qpj;
          locall.field_content = localaju.DlJ;
          locall.field_createTime = localaju.hgr;
          locall.field_thumbUrl = localaju.thumbUrl;
          locall.field_id = localaju.id;
          locall.field_objectId = localaju.objectId;
          locall.field_objectNonceId = localaju.objectNonceId;
          locall.field_commentId = localaju.commentId;
          locall.field_flag = localaju.dtM;
          locall.field_refContent = localaju.DlK;
          locall.field_extFlag = localaju.extFlag;
          locall.field_notify = localaju.DlL;
          locall.field_mediaType = localaju.mediaType;
          locall.field_description = localaju.description;
          locall.field_replayUsername = localaju.Dkv;
          locall.field_replayNickname = localaju.replyNickname;
          locall.field_username = localaju.username;
          paramq = localaju.LxI;
          if (paramq != null)
          {
            paramq = paramq.contact;
            locall.field_contact = paramq;
            paramq = localaju.LxJ;
            if (paramq == null) {
              break label639;
            }
          }
          for (paramq = paramq.contact;; paramq = null)
          {
            locall.field_replyContact = paramq;
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            locall.field_userVersion = paramq.afk().getInt(ae.a.Fxg, 0);
            localLinkedList.add(locall);
            break;
            paramq = null;
            break label560;
          }
        }
        if (((Collection)this.fOL).isEmpty()) {
          break label799;
        }
        paramInt1 = 1;
        if (paramInt1 != 0)
        {
          paramq = d.qKK;
          d.a.E((List)this.fOL, this.scene);
        }
      }
      if (paramArrayOfByte != null)
      {
        i = this.scene;
        paramInt1 = this.KJH;
        paramq = paramArrayOfByte.toByteArray();
        d.g.b.k.g(paramq, "it.toByteArray()");
        i = a.ahc(i);
        if (i != qpk) {
          break label866;
        }
        switch (paramInt1)
        {
        }
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fvU();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165230);
      return;
      label799:
      paramInt1 = 0;
      break;
      paramArrayOfByte = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte.afk().set(ae.a.LBl, bt.cy(paramq));
      continue;
      paramArrayOfByte = com.tencent.mm.kernel.g.afB();
      d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
      paramArrayOfByte.afk().set(ae.a.LBm, bt.cy(paramq));
      continue;
      label866:
      if (i == qoI)
      {
        paramArrayOfByte = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramArrayOfByte, "MMKernel.storage()");
        paramArrayOfByte.afk().set(ae.a.LBk, bt.cy(paramq));
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderGetMentionList$Companion;", "", "()V", "SCENE_FINDER", "", "getSCENE_FINDER", "()I", "SCENE_WX", "getSCENE_WX", "TAG", "", "clearLastBuf", "", "getMentionScene", "scene", "readFinderLastBuf", "", "requestScene", "writeFinderLastBuf", "lastBuf", "plugin-finder_release"})
  public static final class a
  {
    static int ahc(int paramInt)
    {
      AppMethodBeat.i(197313);
      switch (paramInt)
      {
      default: 
        AppMethodBeat.o(197313);
        return 0;
      case 2: 
        paramInt = s.fSb();
        AppMethodBeat.o(197313);
        return paramInt;
      }
      paramInt = s.fSc();
      AppMethodBeat.o(197313);
      return paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.s
 * JD-Core Version:    0.7.0.1
 */
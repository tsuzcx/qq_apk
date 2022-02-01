package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aiu;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFirstPageMD5", "getLastBuffer", "getMaxId", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class aw
  extends w
  implements com.tencent.mm.network.k
{
  public static final aw.a qYR;
  private com.tencent.mm.ak.g callback;
  public int fansCount;
  public int friendFollowCount;
  public int pullType;
  public boolean qYO;
  public boolean qYP;
  public final String qYQ;
  public List<? extends FinderItem> qYc;
  public com.tencent.mm.ak.b rr;
  public LinkedList<String> userTags;
  
  static
  {
    AppMethodBeat.i(165291);
    qYR = new aw.a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public aw(String paramString, long paramLong, com.tencent.mm.bw.b paramb, int paramInt, anm paramanm)
  {
    super(paramanm);
    AppMethodBeat.i(201214);
    this.qYQ = paramString;
    this.qYO = true;
    this.userTags = new LinkedList();
    paramString = com.tencent.mm.plugin.finder.api.b.qWt;
    paramString = com.tencent.mm.plugin.finder.api.b.a.adh(this.qYQ);
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
      com.tencent.mm.ak.b.a locala = new com.tencent.mm.ak.b.a();
      locala.Am("/cgi-bin/micromsg-bin/finderuserpage");
      locala.op(getType());
      aow localaow = new aow();
      localaow.username = this.qYQ;
      localaow.xRo = paramLong;
      localaow.firstPageMD5 = paramString;
      localaow.EEI = u.axE();
      Object localObject = q.qXH;
      localaow.EDL = q.a(paramanm);
      localObject = localaow.EDL;
      if (paramanm != null) {}
      for (int i = paramanm.seo;; i = 0)
      {
        ((aiu)localObject).scene = i;
        if (localaow.username.equals(localaow.EEI)) {
          localaow.EHM = 1;
        }
        localaow.lastBuffer = paramb;
        paramb = new FinderUserPageResponse();
        locala.c((a)localaow);
        locala.d((a)paramb);
        paramb = locala.aAz();
        d.g.b.k.g(paramb, "builder.buildInstance()");
        this.rr = paramb;
        this.pullType = paramInt;
        ac.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong + " username " + this.qYQ + " pullType " + paramInt + " fpMD5 " + paramString);
        AppMethodBeat.o(201214);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(165289);
    this.callback = paramg;
    int i = dispatch(parame, (com.tencent.mm.network.q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final int getType()
  {
    return 3736;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165288);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ac.i("Finder.NetSceneFinderUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 13L, 1L, false);
      paramq = this.rr.aBD();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(165288);
        throw paramString;
      }
      Object localObject1 = (FinderUserPageResponse)paramq;
      paramq = this.qYQ;
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).userTags;
      d.g.b.k.g(paramArrayOfByte, "resp.userTags");
      this.userTags = paramArrayOfByte;
      this.friendFollowCount = ((FinderUserPageResponse)localObject1).friendFollowCount;
      this.fansCount = ((FinderUserPageResponse)localObject1).fansCount;
      Object localObject2 = ((FinderUserPageResponse)localObject1).contact;
      if (localObject2 != null)
      {
        ac.i("Finder.NetSceneFinderUserPage", "contact info " + com.tencent.mm.ac.f.bD(localObject2) + " fansCount: " + ((FinderUserPageResponse)localObject1).fansCount + " friendFollowCount:" + ((FinderUserPageResponse)localObject1).friendFollowCount);
        paramArrayOfByte = ((FinderContact)localObject2).username;
        d.g.b.k.g(paramArrayOfByte, "it.username");
        paramq = com.tencent.mm.plugin.finder.api.b.qWt;
        paramq = ((FinderUserPageResponse)localObject1).contact;
        d.g.b.k.g(paramq, "resp.contact");
        com.tencent.mm.plugin.finder.api.b.a.a(paramq);
        paramq = com.tencent.mm.plugin.finder.api.b.qWt;
        paramq = ((FinderContact)localObject2).username;
        d.g.b.k.g(paramq, "it.username");
        localObject2 = com.tencent.mm.plugin.finder.api.b.a.adh(paramq);
        paramq = paramArrayOfByte;
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.api.f)localObject2).field_firstPageMD5 = ((FinderUserPageResponse)localObject1).firstPageMD5;
          paramq = com.tencent.mm.plugin.finder.api.b.qWt;
          com.tencent.mm.plugin.finder.api.b.a.b((com.tencent.mm.plugin.finder.api.f)localObject2);
          paramq = paramArrayOfByte;
          if (d.g.b.k.g(((com.tencent.mm.plugin.finder.api.f)localObject2).getUsername(), u.axE()))
          {
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GVn, Integer.valueOf(((FinderUserPageResponse)localObject1).fansCount));
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GTR, ((FinderUserPageResponse)localObject1).contact.nickname);
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GTS, ((FinderUserPageResponse)localObject1).contact.signature);
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GTT, ((FinderUserPageResponse)localObject1).contact.headUrl);
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GTV, ((FinderUserPageResponse)localObject1).contact.coverImgUrl);
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GUq, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.extFlag));
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GTY, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalFlag));
            if (((FinderUserPageResponse)localObject1).contact.originalInfo != null)
            {
              paramq = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.agA().set(ah.a.GTZ, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.EFP));
              paramq = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.agA().set(ah.a.GUa, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.EFQ));
              paramq = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.agA().set(ah.a.GUb, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.EFR));
              paramq = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.agA().set(ah.a.GUc, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.EFS));
              paramq = com.tencent.mm.kernel.g.agR();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.agA().set(ah.a.GUf, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.EFT));
            }
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GUd, Integer.valueOf(((FinderUserPageResponse)localObject1).originalEntranceFlag));
            if (((FinderUserPageResponse)localObject1).contact.authInfo != null) {
              break label915;
            }
            paramq = com.tencent.mm.kernel.g.agR();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.agA().set(ah.a.GTU, "");
          }
        }
      }
      for (paramq = paramArrayOfByte; this.qYP; paramq = paramArrayOfByte)
      {
        ac.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.k.fOy();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        }
        AppMethodBeat.o(165288);
        return;
        label915:
        paramq = com.tencent.mm.kernel.g.agR();
        d.g.b.k.g(paramq, "MMKernel.storage()");
        paramq.agA().set(ah.a.GTU, bs.cx(((FinderUserPageResponse)localObject1).contact.authInfo.toByteArray()));
      }
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).object;
      if (paramArrayOfByte == null) {
        d.g.b.k.fOy();
      }
      localObject2 = new StringBuilder("cgiBack: continueFlag:").append(((FinderUserPageResponse)localObject1).continueFlag).append(", list:");
      Object localObject3 = p.qXG;
      ac.i("Finder.NetSceneFinderUserPage", p.dw((List)paramArrayOfByte));
      ac.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + paramArrayOfByte.size());
      boolean bool1;
      if (((FinderUserPageResponse)localObject1).continueFlag == 1)
      {
        bool1 = true;
        this.qYO = bool1;
        if (this.pullType == 2) {
          break label1204;
        }
        bool1 = true;
        label1082:
        if (!bool1) {
          break label1215;
        }
        localObject1 = (Collection)paramArrayOfByte;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label1210;
        }
        paramInt1 = 1;
        label1111:
        if (paramInt1 == 0) {
          break label1215;
        }
      }
      label1204:
      label1210:
      label1215:
      for (boolean bool2 = true;; bool2 = false)
      {
        localObject1 = (Iterable)paramArrayOfByte;
        paramArrayOfByte = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (FinderObject)localObject2;
          com.tencent.mm.plugin.finder.utils.n localn = com.tencent.mm.plugin.finder.utils.n.rPN;
          if (com.tencent.mm.plugin.finder.utils.n.n((FinderObject)localObject3)) {
            paramArrayOfByte.add(localObject2);
          }
        }
        bool1 = false;
        break;
        bool1 = false;
        break label1082;
        paramInt1 = 0;
        break label1111;
      }
      paramArrayOfByte = (List)paramArrayOfByte;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.rFl;
      this.qYc = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramArrayOfByte, 2, bool1, paramq, bool2, this.contextObj, 32);
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.k.fOy();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      }
      AppMethodBeat.o(165288);
      return;
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(1279L, 14L, 1L, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.aw
 * JD-Core Version:    0.7.0.1
 */
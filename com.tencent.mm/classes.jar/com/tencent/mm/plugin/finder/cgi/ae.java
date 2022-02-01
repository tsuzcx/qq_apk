package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.model.u;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.alt;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.dzp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFirstPageMD5", "getLastBuffer", "getMaxId", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class ae
  extends ap
  implements com.tencent.mm.network.k
{
  public static final a qpL;
  private com.tencent.mm.al.g callback;
  public int fansCount;
  public int friendFollowCount;
  public int pullType;
  public boolean qpI;
  public boolean qpJ;
  public final String qpK;
  public List<? extends FinderItem> qpi;
  public com.tencent.mm.al.b rr;
  public LinkedList<String> userTags;
  
  static
  {
    AppMethodBeat.i(165291);
    qpL = new a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public ae(String paramString, long paramLong, com.tencent.mm.bx.b paramb, int paramInt, dzp paramdzp)
  {
    super(paramdzp);
    AppMethodBeat.i(197336);
    this.qpK = paramString;
    this.qpI = true;
    this.userTags = new LinkedList();
    paramString = com.tencent.mm.plugin.finder.api.b.qnX;
    paramString = com.tencent.mm.plugin.finder.api.b.a.YL(this.qpK);
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
      com.tencent.mm.al.b.a locala = new com.tencent.mm.al.b.a();
      locala.wg("/cgi-bin/micromsg-bin/finderuserpage");
      locala.nB(getType());
      alt localalt = new alt();
      localalt.username = this.qpK;
      localalt.wET = paramLong;
      localalt.firstPageMD5 = paramString;
      localalt.Dls = u.aqO();
      Object localObject = am.KJy;
      localalt.Dkw = am.a(paramdzp);
      localObject = localalt.Dkw;
      if (paramdzp != null) {}
      for (int i = paramdzp.LiL;; i = 0)
      {
        ((aht)localObject).scene = i;
        if (localalt.username.equals(localalt.Dls)) {
          localalt.DmP = 1;
        }
        localalt.lastBuffer = paramb;
        paramb = new FinderUserPageResponse();
        locala.c((a)localalt);
        locala.d((a)paramb);
        paramb = locala.atI();
        d.g.b.k.g(paramb, "builder.buildInstance()");
        this.rr = paramb;
        this.pullType = paramInt;
        ad.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong + " username " + this.qpK + " pullType " + paramInt + " fpMD5 " + paramString);
        AppMethodBeat.o(197336);
        return;
      }
    }
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(165289);
    this.callback = paramg;
    int i = dispatch(parame, (q)this.rr, (com.tencent.mm.network.k)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final int getType()
  {
    return 3736;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(165288);
    super.onGYNetEnd(paramInt1, paramInt2, paramInt3, paramString, paramq, paramArrayOfByte);
    ad.i("Finder.NetSceneFinderUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 13L, 1L, false);
      paramq = this.rr.auM();
      if (paramq == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(165288);
        throw paramString;
      }
      Object localObject1 = (FinderUserPageResponse)paramq;
      paramq = this.qpK;
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).userTags;
      d.g.b.k.g(paramArrayOfByte, "resp.userTags");
      this.userTags = paramArrayOfByte;
      this.friendFollowCount = ((FinderUserPageResponse)localObject1).friendFollowCount;
      this.fansCount = ((FinderUserPageResponse)localObject1).fansCount;
      Object localObject2 = ((FinderUserPageResponse)localObject1).contact;
      if (localObject2 != null)
      {
        ad.i("Finder.NetSceneFinderUserPage", "contact info " + com.tencent.mm.ad.f.bG(localObject2) + " fansCount: " + ((FinderUserPageResponse)localObject1).fansCount + " friendFollowCount:" + ((FinderUserPageResponse)localObject1).friendFollowCount);
        paramArrayOfByte = ((FinderContact)localObject2).username;
        d.g.b.k.g(paramArrayOfByte, "it.username");
        paramq = com.tencent.mm.plugin.finder.api.b.qnX;
        paramq = ((FinderUserPageResponse)localObject1).contact;
        d.g.b.k.g(paramq, "resp.contact");
        com.tencent.mm.plugin.finder.api.b.a.a(paramq);
        paramq = com.tencent.mm.plugin.finder.api.b.qnX;
        paramq = ((FinderContact)localObject2).username;
        d.g.b.k.g(paramq, "it.username");
        localObject2 = com.tencent.mm.plugin.finder.api.b.a.YL(paramq);
        paramq = paramArrayOfByte;
        if (localObject2 != null)
        {
          ((com.tencent.mm.plugin.finder.api.f)localObject2).field_firstPageMD5 = ((FinderUserPageResponse)localObject1).firstPageMD5;
          paramq = com.tencent.mm.plugin.finder.api.b.qnX;
          com.tencent.mm.plugin.finder.api.b.a.b((com.tencent.mm.plugin.finder.api.f)localObject2);
          paramq = paramArrayOfByte;
          if (d.g.b.k.g(((com.tencent.mm.plugin.finder.api.f)localObject2).getUsername(), u.aqO()))
          {
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.FwX, Integer.valueOf(((FinderUserPageResponse)localObject1).fansCount));
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.FvX, ((FinderUserPageResponse)localObject1).contact.nickname);
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.FvY, ((FinderUserPageResponse)localObject1).contact.signature);
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.FvZ, ((FinderUserPageResponse)localObject1).contact.headUrl);
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.Fwb, ((FinderUserPageResponse)localObject1).contact.coverImgUrl);
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.Fwo, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.extFlag));
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.Fwe, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalFlag));
            if (((FinderUserPageResponse)localObject1).contact.originalInfo != null)
            {
              paramq = com.tencent.mm.kernel.g.afB();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.afk().set(com.tencent.mm.storage.ae.a.Fwf, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.LxV));
              paramq = com.tencent.mm.kernel.g.afB();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.afk().set(com.tencent.mm.storage.ae.a.Fwg, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.LxW));
              paramq = com.tencent.mm.kernel.g.afB();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.afk().set(com.tencent.mm.storage.ae.a.Fwh, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.LxX));
              paramq = com.tencent.mm.kernel.g.afB();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.afk().set(com.tencent.mm.storage.ae.a.Fwi, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.LxY));
              paramq = com.tencent.mm.kernel.g.afB();
              d.g.b.k.g(paramq, "MMKernel.storage()");
              paramq.afk().set(com.tencent.mm.storage.ae.a.LAK, Integer.valueOf(((FinderUserPageResponse)localObject1).contact.originalInfo.LxZ));
            }
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.Fwj, Integer.valueOf(((FinderUserPageResponse)localObject1).originalEntranceFlag));
            if (((FinderUserPageResponse)localObject1).contact.authInfo != null) {
              break label915;
            }
            paramq = com.tencent.mm.kernel.g.afB();
            d.g.b.k.g(paramq, "MMKernel.storage()");
            paramq.afk().set(com.tencent.mm.storage.ae.a.Fwa, "");
          }
        }
      }
      for (paramq = paramArrayOfByte; this.qpJ; paramq = paramArrayOfByte)
      {
        ad.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.k.fvU();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        }
        AppMethodBeat.o(165288);
        return;
        label915:
        paramq = com.tencent.mm.kernel.g.afB();
        d.g.b.k.g(paramq, "MMKernel.storage()");
        paramq.afk().set(com.tencent.mm.storage.ae.a.Fwa, bt.cy(((FinderUserPageResponse)localObject1).contact.authInfo.toByteArray()));
      }
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).object;
      if (paramArrayOfByte == null) {
        d.g.b.k.fvU();
      }
      localObject2 = new StringBuilder("cgiBack: continueFlag:").append(((FinderUserPageResponse)localObject1).continueFlag).append(", list:");
      Object localObject3 = i.qoK;
      ad.i("Finder.NetSceneFinderUserPage", i.du((List)paramArrayOfByte));
      ad.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + paramArrayOfByte.size());
      boolean bool1;
      if (((FinderUserPageResponse)localObject1).continueFlag == 1)
      {
        bool1 = true;
        this.qpI = bool1;
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
          com.tencent.mm.plugin.finder.utils.i locali = com.tencent.mm.plugin.finder.utils.i.qTa;
          if (com.tencent.mm.plugin.finder.utils.i.f((FinderObject)localObject3)) {
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
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.qKG;
      this.qpi = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramArrayOfByte, 2, bool1, paramq, bool2, this.contextObj, 32);
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
      AppMethodBeat.o(165288);
      return;
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(1279L, 14L, 1L, false);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.ae
 * JD-Core Version:    0.7.0.1
 */
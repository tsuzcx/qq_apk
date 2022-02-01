package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.bx.a;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.alk;
import com.tencent.mm.protocal.protobuf.aqe;
import com.tencent.mm.protocal.protobuf.aqy;
import com.tencent.mm.protocal.protobuf.asn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFirstPageMD5", "getLastBuffer", "getMaxId", "getPrivateLock", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class be
  extends ac
  implements k
{
  public static final a rKi;
  private com.tencent.mm.al.f callback;
  public int fansCount;
  public int friendFollowCount;
  public int pullType;
  public List<? extends FinderItem> rJo;
  public boolean rKf;
  public boolean rKg;
  public final String rKh;
  public com.tencent.mm.al.b rr;
  public LinkedList<String> userTags;
  
  static
  {
    AppMethodBeat.i(165291);
    rKi = new a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public be(String paramString, long paramLong, com.tencent.mm.bx.b paramb, int paramInt, aqy paramaqy)
  {
    super(paramaqy);
    AppMethodBeat.i(201168);
    this.rKh = paramString;
    this.rKf = true;
    this.userTags = new LinkedList();
    paramString = c.rHn;
    paramString = c.a.agW(this.rKh);
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
      locala.Dl("/cgi-bin/micromsg-bin/finderuserpage");
      locala.oP(getType());
      asn localasn = new asn();
      localasn.username = this.rKh;
      localasn.zhi = paramLong;
      localasn.firstPageMD5 = paramString;
      localasn.Gmz = com.tencent.mm.model.u.aAu();
      Object localObject = v.rIR;
      localasn.Glv = v.a(paramaqy);
      localObject = localasn.Glv;
      if (paramaqy != null) {}
      for (int i = paramaqy.tcl;; i = 0)
      {
        ((alk)localObject).scene = i;
        if (localasn.username.equals(localasn.Gmz)) {
          localasn.GqB = 1;
        }
        localasn.lastBuffer = paramb;
        paramb = new FinderUserPageResponse();
        locala.c((a)localasn);
        locala.d((a)paramb);
        paramb = locala.aDC();
        d.g.b.p.g(paramb, "builder.buildInstance()");
        this.rr = paramb;
        this.pullType = paramInt;
        ad.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong + " username " + this.rKh + " pullType " + paramInt + " fpMD5 " + paramString);
        AppMethodBeat.o(201168);
        return;
      }
    }
  }
  
  public final long cyQ()
  {
    AppMethodBeat.i(201166);
    Object localObject = this.rr.aEE();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
      AppMethodBeat.o(201166);
      throw ((Throwable)localObject);
    }
    long l = ((asn)localObject).zhi;
    AppMethodBeat.o(201166);
    return l;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(165289);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final com.tencent.mm.bx.b getLastBuffer()
  {
    AppMethodBeat.i(201167);
    Object localObject = this.rr.aEF();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(201167);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).lastBuffer;
    AppMethodBeat.o(201167);
    return localObject;
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 13L, 1L, false);
      paramq = this.rr.aEF();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(165288);
        throw paramString;
      }
      paramArrayOfByte = (FinderUserPageResponse)paramq;
      paramq = this.rKh;
      Object localObject1 = paramArrayOfByte.userTags;
      d.g.b.p.g(localObject1, "resp.userTags");
      this.userTags = ((LinkedList)localObject1);
      this.friendFollowCount = paramArrayOfByte.friendFollowCount;
      this.fansCount = paramArrayOfByte.fansCount;
      localObject1 = paramArrayOfByte.contact;
      if (localObject1 != null)
      {
        ad.i("Finder.NetSceneFinderUserPage", "contact info " + com.tencent.mm.ad.f.bF(localObject1) + " fansCount: " + paramArrayOfByte.fansCount + " friendFollowCount:" + paramArrayOfByte.friendFollowCount);
        paramq = ((FinderContact)localObject1).username;
        d.g.b.p.g(paramq, "it.username");
        localObject2 = c.rHn;
        localObject2 = paramArrayOfByte.contact;
        d.g.b.p.g(localObject2, "resp.contact");
        c.a.a((FinderContact)localObject2);
        localObject2 = c.rHn;
        localObject1 = ((FinderContact)localObject1).username;
        d.g.b.p.g(localObject1, "it.username");
        localObject1 = c.a.agW((String)localObject1);
        if (localObject1 != null)
        {
          ((com.tencent.mm.plugin.finder.api.g)localObject1).field_firstPageMD5 = paramArrayOfByte.firstPageMD5;
          localObject2 = c.rHn;
          c.a.b((com.tencent.mm.plugin.finder.api.g)localObject1);
          if (d.g.b.p.i(((com.tencent.mm.plugin.finder.api.g)localObject1).getUsername(), com.tencent.mm.model.u.aAu()))
          {
            if (paramArrayOfByte.fansCount > 0)
            {
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IHV, Integer.valueOf(paramArrayOfByte.fansCount));
            }
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGx, paramArrayOfByte.contact.nickname);
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGy, paramArrayOfByte.contact.signature);
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGz, paramArrayOfByte.contact.headUrl);
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGB, paramArrayOfByte.contact.coverImgUrl);
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGW, Integer.valueOf(paramArrayOfByte.contact.extFlag));
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGE, Integer.valueOf(paramArrayOfByte.contact.originalFlag));
            if (paramArrayOfByte.contact.originalInfo != null)
            {
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGF, Integer.valueOf(paramArrayOfByte.contact.originalInfo.Gok));
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGG, Integer.valueOf(paramArrayOfByte.contact.originalInfo.Gol));
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGH, Integer.valueOf(paramArrayOfByte.contact.originalInfo.Gom));
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGI, Integer.valueOf(paramArrayOfByte.contact.originalInfo.Gon));
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGL, Integer.valueOf(paramArrayOfByte.contact.originalInfo.Goo));
            }
            localObject1 = com.tencent.mm.kernel.g.ajC();
            d.g.b.p.g(localObject1, "MMKernel.storage()");
            ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGJ, Integer.valueOf(paramArrayOfByte.originalEntranceFlag));
            if (paramArrayOfByte.contact.authInfo == null)
            {
              localObject1 = com.tencent.mm.kernel.g.ajC();
              d.g.b.p.g(localObject1, "MMKernel.storage()");
              ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGA, "");
            }
          }
        }
      }
      while (this.rKg)
      {
        ad.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.p.gfZ();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
        }
        AppMethodBeat.o(165288);
        return;
        localObject1 = com.tencent.mm.kernel.g.ajC();
        d.g.b.p.g(localObject1, "MMKernel.storage()");
        ((com.tencent.mm.kernel.e)localObject1).ajl().set(al.a.IGA, bt.cE(paramArrayOfByte.contact.authInfo.toByteArray()));
        continue;
      }
      localObject1 = paramArrayOfByte.object;
      if (localObject1 == null) {
        d.g.b.p.gfZ();
      }
      Object localObject2 = new StringBuilder("cgiBack: continueFlag:").append(paramArrayOfByte.continueFlag).append(", list:");
      Object localObject3 = u.rIQ;
      ad.i("Finder.NetSceneFinderUserPage", u.dy((List)localObject1));
      ad.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + ((LinkedList)localObject1).size());
      label1079:
      int i;
      if (paramArrayOfByte.continueFlag == 1)
      {
        bool = true;
        this.rKf = bool;
        if (this.pullType == 2) {
          break label1202;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1213;
        }
        paramArrayOfByte = (Collection)localObject1;
        if ((paramArrayOfByte != null) && (!paramArrayOfByte.isEmpty())) {
          break label1207;
        }
        i = 1;
        label1108:
        if (i == 0) {
          break label1213;
        }
      }
      label1202:
      label1207:
      label1213:
      for (boolean bool = true;; bool = false)
      {
        localObject1 = (Iterable)localObject1;
        paramArrayOfByte = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (FinderObject)localObject2;
          com.tencent.mm.plugin.finder.utils.p localp = com.tencent.mm.plugin.finder.utils.p.sMo;
          if (com.tencent.mm.plugin.finder.utils.p.o((FinderObject)localObject3)) {
            paramArrayOfByte.add(localObject2);
          }
        }
        bool = false;
        break;
        paramInt1 = 0;
        break label1079;
        i = 0;
        break label1108;
      }
      paramArrayOfByte = (List)paramArrayOfByte;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
      this.rJo = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramArrayOfByte, 2, this.rIl, 4);
      if (paramInt1 != 0)
      {
        paramArrayOfByte = this.rJo;
        if (paramArrayOfByte != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
          localObject1 = (Iterable)paramArrayOfByte;
          paramArrayOfByte = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderItem)((Iterator)localObject1).next();
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sAs;
            paramArrayOfByte.add(com.tencent.mm.plugin.finder.storage.logic.b.a.j((FinderItem)localObject2));
          }
          com.tencent.mm.plugin.finder.storage.logic.b.a.a((List)paramArrayOfByte, 2, paramq, bool);
        }
      }
    }
    for (;;)
    {
      if (this.callback != null)
      {
        paramq = this.callback;
        if (paramq == null) {
          d.g.b.p.gfZ();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (n)this);
      }
      AppMethodBeat.o(165288);
      return;
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(1279L, 14L, 1L, false);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.be
 * JD-Core Version:    0.7.0.1
 */
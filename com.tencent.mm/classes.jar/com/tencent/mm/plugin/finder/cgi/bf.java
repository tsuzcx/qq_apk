package com.tencent.mm.plugin.finder.cgi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderUserPageResponse;
import com.tencent.mm.protocal.protobuf.alw;
import com.tencent.mm.protocal.protobuf.aqt;
import com.tencent.mm.protocal.protobuf.arn;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage;", "Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderBase;", "Lcom/tencent/mm/network/IOnGYNetEnd;", "req_username", "", "maxId", "", "lastBuffer", "Lcom/tencent/mm/protobuf/ByteString;", "pullType", "", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Ljava/lang/String;JLcom/tencent/mm/protobuf/ByteString;ILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "callback", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "fansCount", "getFansCount", "()I", "setFansCount", "(I)V", "friendFollowCount", "getFriendFollowCount", "setFriendFollowCount", "isOnlyFetchUserInfo", "setOnlyFetchUserInfo", "objectList", "", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "getObjectList", "()Ljava/util/List;", "setObjectList", "(Ljava/util/List;)V", "getPullType", "setPullType", "getReq_username", "()Ljava/lang/String;", "rr", "Lcom/tencent/mm/modelbase/CommReqResp;", "userTags", "Ljava/util/LinkedList;", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "doScene", "dispatcher", "Lcom/tencent/mm/network/IDispatcher;", "getFirstPageMD5", "getLastBuffer", "getMaxId", "getPrivateLock", "getType", "getUserContact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "getUserPageFeed", "Lcom/tencent/mm/protocal/protobuf/FinderObject;", "onGYNetEnd", "", "netId", "errType", "errCode", "errMsg", "Lcom/tencent/mm/network/IReqResp;", "cookie", "", "Companion", "plugin-finder_release"})
public final class bf
  extends ad
  implements k
{
  public static final a rSu;
  private com.tencent.mm.ak.f callback;
  public int fansCount;
  public int friendFollowCount;
  public int pullType;
  public List<? extends FinderItem> rRC;
  public boolean rRg;
  public final String rRh;
  public boolean rSt;
  public com.tencent.mm.ak.b rr;
  public LinkedList<String> userTags;
  
  static
  {
    AppMethodBeat.i(165291);
    rSu = new a((byte)0);
    AppMethodBeat.o(165291);
  }
  
  public bf(String paramString, long paramLong, com.tencent.mm.bw.b paramb, int paramInt, arn paramarn)
  {
    super(paramarn);
    AppMethodBeat.i(201590);
    this.rRh = paramString;
    this.rRg = true;
    this.userTags = new LinkedList();
    paramString = c.rPy;
    paramString = c.a.ahT(this.rRh);
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
      locala.DN("/cgi-bin/micromsg-bin/finderuserpage");
      locala.oS(getType());
      atd localatd = new atd();
      localatd.username = this.rRh;
      localatd.zxX = paramLong;
      localatd.firstPageMD5 = paramString;
      localatd.GDP = com.tencent.mm.model.v.aAK();
      Object localObject = v.rRb;
      localatd.GDR = v.a(paramarn);
      localObject = localatd.GDR;
      if (localObject != null) {
        if (paramarn == null) {
          break label336;
        }
      }
      label336:
      for (int i = paramarn.tnf;; i = 0)
      {
        ((alw)localObject).scene = i;
        if (d.n.n.H(localatd.username, localatd.GDP, false)) {
          localatd.GDQ = 1;
        }
        localatd.lastBuffer = paramb;
        paramb = v.rRb;
        localatd.GDS = v.cXN();
        paramb = new FinderUserPageResponse();
        locala.c((com.tencent.mm.bw.a)localatd);
        locala.d((com.tencent.mm.bw.a)paramb);
        paramb = locala.aDS();
        d.g.b.p.g(paramb, "builder.buildInstance()");
        this.rr = paramb;
        this.pullType = paramInt;
        ae.i("Finder.NetSceneFinderUserPage", "NetSceneFinderUserPage init maxId " + paramLong + " username " + this.rRh + " pullType " + paramInt + " fpMD5 " + paramString);
        AppMethodBeat.o(201590);
        return;
      }
    }
  }
  
  public final long cAr()
  {
    AppMethodBeat.i(201588);
    Object localObject = this.rr.aEU();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageRequest");
      AppMethodBeat.o(201588);
      throw ((Throwable)localObject);
    }
    long l = ((atd)localObject).zxX;
    AppMethodBeat.o(201588);
    return l;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(165289);
    this.callback = paramf;
    int i = dispatch(parame, (q)this.rr, (k)this);
    AppMethodBeat.o(165289);
    return i;
  }
  
  public final com.tencent.mm.bw.b getLastBuffer()
  {
    AppMethodBeat.i(201589);
    Object localObject = this.rr.aEV();
    if (localObject == null)
    {
      localObject = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
      AppMethodBeat.o(201589);
      throw ((Throwable)localObject);
    }
    localObject = ((FinderUserPageResponse)localObject).lastBuffer;
    AppMethodBeat.o(201589);
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
    ae.i("Finder.NetSceneFinderUserPage", "errType " + paramInt2 + ", errCode " + paramInt3 + ", errMsg " + paramString);
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 13L, 1L, false);
      paramq = this.rr.aEV();
      if (paramq == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderUserPageResponse");
        AppMethodBeat.o(165288);
        throw paramString;
      }
      Object localObject1 = (FinderUserPageResponse)paramq;
      paramq = this.rRh;
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).userTags;
      d.g.b.p.g(paramArrayOfByte, "resp.userTags");
      this.userTags = paramArrayOfByte;
      this.friendFollowCount = ((FinderUserPageResponse)localObject1).friendFollowCount;
      this.fansCount = ((FinderUserPageResponse)localObject1).fansCount;
      paramArrayOfByte = com.tencent.mm.plugin.finder.preload.a.stE;
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).preloadInfo;
      Object localObject2 = ((FinderUserPageResponse)localObject1).object;
      d.g.b.p.g(localObject2, "resp.`object`");
      com.tencent.mm.plugin.finder.preload.a.a(paramArrayOfByte, (List)localObject2, 3736);
      localObject2 = ((FinderUserPageResponse)localObject1).contact;
      Object localObject4;
      if (localObject2 != null)
      {
        paramq = new StringBuilder("contact info ");
        d.g.b.p.g(localObject2, "it");
        ae.i("Finder.NetSceneFinderUserPage", com.tencent.mm.ac.f.bF(localObject2) + " fansCount: " + ((FinderUserPageResponse)localObject1).fansCount + " friendFollowCount:" + ((FinderUserPageResponse)localObject1).friendFollowCount);
        paramArrayOfByte = ((FinderContact)localObject2).username;
        paramq = paramArrayOfByte;
        if (paramArrayOfByte == null) {
          paramq = "";
        }
        paramArrayOfByte = c.rPy;
        c.a.a((FinderContact)localObject2);
        paramArrayOfByte = c.rPy;
        paramArrayOfByte = c.a.ahT(((FinderContact)localObject2).username);
        if (paramArrayOfByte != null)
        {
          paramArrayOfByte.field_firstPageMD5 = ((FinderUserPageResponse)localObject1).firstPageMD5;
          localObject3 = c.rPy;
          c.a.b(paramArrayOfByte);
          if (d.g.b.p.i(paramArrayOfByte.getUsername(), com.tencent.mm.model.v.aAK()))
          {
            if (((FinderUserPageResponse)localObject1).fansCount > 0)
            {
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              paramArrayOfByte.ajA().set(am.a.Jcy, Integer.valueOf(((FinderUserPageResponse)localObject1).fansCount));
            }
            paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
            d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
            localObject3 = paramArrayOfByte.ajA();
            localObject4 = am.a.JaX;
            paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
            if (paramArrayOfByte != null)
            {
              paramArrayOfByte = paramArrayOfByte.nickname;
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              localObject3 = paramArrayOfByte.ajA();
              localObject4 = am.a.JaY;
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1276;
              }
              paramArrayOfByte = paramArrayOfByte.signature;
              label514:
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              localObject3 = paramArrayOfByte.ajA();
              localObject4 = am.a.JaZ;
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1282;
              }
              paramArrayOfByte = paramArrayOfByte.headUrl;
              label567:
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              localObject3 = paramArrayOfByte.ajA();
              localObject4 = am.a.Jbb;
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1288;
              }
              paramArrayOfByte = paramArrayOfByte.coverImgUrl;
              label620:
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              localObject3 = paramArrayOfByte.ajA();
              localObject4 = am.a.Jbx;
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1294;
              }
              paramArrayOfByte = Integer.valueOf(paramArrayOfByte.extFlag);
              label676:
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              localObject3 = paramArrayOfByte.ajA();
              localObject4 = am.a.Jbe;
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1300;
              }
              paramArrayOfByte = Integer.valueOf(paramArrayOfByte.originalFlag);
              label732:
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              localObject3 = paramArrayOfByte.ajA();
              localObject4 = am.a.Jbj;
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1306;
              }
              paramArrayOfByte = Integer.valueOf(paramArrayOfByte.originalEntranceFlag);
              label788:
              ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1312;
              }
              paramArrayOfByte = paramArrayOfByte.originalInfo;
              label816:
              if (paramArrayOfByte != null)
              {
                paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
                localObject3 = paramArrayOfByte.ajA();
                localObject4 = am.a.Jbf;
                paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
                if (paramArrayOfByte == null) {
                  break label1318;
                }
                paramArrayOfByte = paramArrayOfByte.originalInfo;
                if (paramArrayOfByte == null) {
                  break label1318;
                }
                paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHB);
                label880:
                ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
                paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
                localObject3 = paramArrayOfByte.ajA();
                localObject4 = am.a.Jbg;
                paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
                if (paramArrayOfByte == null) {
                  break label1324;
                }
                paramArrayOfByte = paramArrayOfByte.originalInfo;
                if (paramArrayOfByte == null) {
                  break label1324;
                }
                paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHC);
                label948:
                ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
                paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
                localObject3 = paramArrayOfByte.ajA();
                localObject4 = am.a.Jbh;
                paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
                if (paramArrayOfByte == null) {
                  break label1330;
                }
                paramArrayOfByte = paramArrayOfByte.originalInfo;
                if (paramArrayOfByte == null) {
                  break label1330;
                }
                paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHD);
                label1016:
                ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
                paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
                localObject3 = paramArrayOfByte.ajA();
                localObject4 = am.a.Jbi;
                paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
                if (paramArrayOfByte == null) {
                  break label1336;
                }
                paramArrayOfByte = paramArrayOfByte.originalInfo;
                if (paramArrayOfByte == null) {
                  break label1336;
                }
                paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHE);
                label1084:
                ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
                paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
                d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
                localObject3 = paramArrayOfByte.ajA();
                localObject4 = am.a.Jbl;
                paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
                if (paramArrayOfByte == null) {
                  break label1342;
                }
                paramArrayOfByte = paramArrayOfByte.originalInfo;
                if (paramArrayOfByte == null) {
                  break label1342;
                }
                paramArrayOfByte = Integer.valueOf(paramArrayOfByte.GHF);
                ((aj)localObject3).set((am.a)localObject4, paramArrayOfByte);
              }
              label1152:
              paramArrayOfByte = ((FinderUserPageResponse)localObject1).contact;
              if (paramArrayOfByte == null) {
                break label1348;
              }
              paramArrayOfByte = paramArrayOfByte.authInfo;
              label1180:
              if (paramArrayOfByte != null) {
                break label1354;
              }
              paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
              d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
              paramArrayOfByte.ajA().set(am.a.Jba, "");
            }
          }
        }
      }
      for (;;)
      {
        if (!this.rSt) {
          break label1425;
        }
        ae.w("Finder.NetSceneFinderUserPage", "isOnlyFetchUserInfo=true");
        if (this.callback != null)
        {
          paramq = this.callback;
          if (paramq == null) {
            d.g.b.p.gkB();
          }
          paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
        }
        AppMethodBeat.o(165288);
        return;
        paramArrayOfByte = null;
        break;
        label1276:
        paramArrayOfByte = null;
        break label514;
        label1282:
        paramArrayOfByte = null;
        break label567;
        label1288:
        paramArrayOfByte = null;
        break label620;
        label1294:
        paramArrayOfByte = null;
        break label676;
        label1300:
        paramArrayOfByte = null;
        break label732;
        label1306:
        paramArrayOfByte = null;
        break label788;
        label1312:
        paramArrayOfByte = null;
        break label816;
        label1318:
        paramArrayOfByte = null;
        break label880;
        label1324:
        paramArrayOfByte = null;
        break label948;
        label1330:
        paramArrayOfByte = null;
        break label1016;
        label1336:
        paramArrayOfByte = null;
        break label1084;
        label1342:
        paramArrayOfByte = null;
        break label1152;
        label1348:
        paramArrayOfByte = null;
        break label1180;
        label1354:
        paramArrayOfByte = com.tencent.mm.kernel.g.ajR();
        d.g.b.p.g(paramArrayOfByte, "MMKernel.storage()");
        localObject3 = paramArrayOfByte.ajA();
        localObject4 = am.a.Jba;
        paramArrayOfByte = ((FinderContact)localObject2).authInfo;
        if (paramArrayOfByte != null) {}
        for (paramArrayOfByte = paramArrayOfByte.toByteArray();; paramArrayOfByte = null)
        {
          ((aj)localObject3).set((am.a)localObject4, bu.cH(paramArrayOfByte));
          break;
        }
      }
      label1425:
      paramArrayOfByte = ((FinderUserPageResponse)localObject1).object;
      if (paramArrayOfByte == null) {
        d.g.b.p.gkB();
      }
      localObject2 = new StringBuilder("cgiBack: continueFlag:").append(((FinderUserPageResponse)localObject1).continueFlag).append(", list:");
      Object localObject3 = u.rRa;
      ae.i("Finder.NetSceneFinderUserPage", u.dB((List)paramArrayOfByte));
      ae.i("Finder.NetSceneFinderUserPage", "onGYNetEnd list:" + paramArrayOfByte.size());
      label1548:
      int i;
      if (((FinderUserPageResponse)localObject1).continueFlag == 1)
      {
        bool = true;
        this.rRg = bool;
        if (this.pullType == 2) {
          break label1671;
        }
        paramInt1 = 1;
        if (paramInt1 == 0) {
          break label1682;
        }
        localObject1 = (Collection)paramArrayOfByte;
        if ((localObject1 != null) && (!((Collection)localObject1).isEmpty())) {
          break label1676;
        }
        i = 1;
        label1577:
        if (i == 0) {
          break label1682;
        }
      }
      label1671:
      label1676:
      label1682:
      for (boolean bool = true;; bool = false)
      {
        localObject1 = (Iterable)paramArrayOfByte;
        paramArrayOfByte = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = ((Iterator)localObject1).next();
          localObject3 = (FinderObject)localObject2;
          localObject4 = com.tencent.mm.plugin.finder.utils.p.sXz;
          if (com.tencent.mm.plugin.finder.utils.p.o((FinderObject)localObject3)) {
            paramArrayOfByte.add(localObject2);
          }
        }
        bool = false;
        break;
        paramInt1 = 0;
        break label1548;
        i = 0;
        break label1577;
      }
      paramArrayOfByte = (List)paramArrayOfByte;
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
      this.rRC = com.tencent.mm.plugin.finder.storage.logic.b.a.a(paramArrayOfByte, 2, this.rQw, 4);
      if (paramInt1 != 0)
      {
        paramArrayOfByte = this.rRC;
        if (paramArrayOfByte != null)
        {
          localObject1 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
          localObject1 = (Iterable)paramArrayOfByte;
          paramArrayOfByte = (Collection)new ArrayList(j.a((Iterable)localObject1, 10));
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (FinderItem)((Iterator)localObject1).next();
            localObject3 = com.tencent.mm.plugin.finder.storage.logic.b.sLq;
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
          d.g.b.p.gkB();
        }
        paramq.onSceneEnd(paramInt2, paramInt3, paramString, (com.tencent.mm.ak.n)this);
      }
      AppMethodBeat.o(165288);
      return;
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(1279L, 14L, 1L, false);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/cgi/NetSceneFinderUserPage$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.cgi.bf
 * JD-Core Version:    0.7.0.1
 */
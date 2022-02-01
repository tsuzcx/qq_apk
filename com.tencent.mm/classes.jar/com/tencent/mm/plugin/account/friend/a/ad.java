package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.bdx;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.bwd;
import com.tencent.mm.protocal.protobuf.bzf;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.f callback;
  private List<String> jaX;
  private List<String> jeq;
  public com.tencent.mm.al.b rr;
  
  public ad()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    aTb();
    bdx localbdx = (bdx)this.rr.hNK.hNQ;
    localbdx.MD5 = "";
    localbdx.GAk = null;
    localbdx.GAj = 0;
    localbdx.GAi = null;
    localbdx.GAh = 0;
    localbdx.gsV = 0;
    localbdx.Scene = 1;
    AppMethodBeat.o(131105);
  }
  
  public ad(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    aTb();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.jaX = paramList1;
    this.jeq = paramList2;
    paramList1 = (bdx)this.rr.hNK.hNQ;
    paramList1.MD5 = "";
    paramList1.gsV = 2;
    paramList1.Scene = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, bwd parambwd)
  {
    parama.jdb = parambwd.jdb;
    parama.jdc = parambwd.jdc;
    parama.jdd = parambwd.jdd;
    parama.jde = parambwd.jde;
    parama.jdf = parambwd.jdf;
    parama.jdg = parambwd.jdg;
    parama.jdh = parambwd.jdh;
    parama.jdi = parambwd.jdi;
    parama.jdk = parambwd.jdk;
    parama.jdj = parambwd.jdj;
    parama.jdl = parambwd.jdl;
    parama.jdm = parambwd.jdm;
    dhg localdhg = parambwd.GOa;
    if (localdhg != null)
    {
      parama.jdn = localdhg.jdn;
      parama.jdo = localdhg.jdo;
      parama.jdp = localdhg.jdp;
    }
    parambwd = parambwd.GOb;
    if (parambwd != null)
    {
      parama.jdq = parambwd.jdq;
      parama.jdr = parambwd.jdr;
      parama.jds = parambwd.jds;
      parama.jdt = parambwd.jdt;
    }
  }
  
  private void aTb()
  {
    AppMethodBeat.i(131107);
    b.a locala = new b.a();
    locala.hNM = new bdx();
    locala.hNN = new bdy();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.hNO = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDC();
    AppMethodBeat.o(131107);
  }
  
  public final void aTc()
  {
    AppMethodBeat.i(131108);
    bdx localbdx = (bdx)this.rr.hNK.hNQ;
    localbdx.MD5 = ((String)com.tencent.mm.kernel.g.ajC().ajl().get(65828, null));
    localbdx.gsV = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(131109);
    this.callback = paramf;
    paramf = (bdx)this.rr.hNK.hNQ;
    if (paramf.gsV == 2)
    {
      if (((this.jaX == null) || (this.jaX.size() == 0)) && ((this.jeq == null) || (this.jeq.size() == 0)))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.jaX != null) && (this.jaX.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.jaX.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.jaX.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bzf();
          ((bzf)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.GAi = localLinkedList;
        paramf.GAh = localLinkedList.size();
      }
      if ((this.jeq != null) && (this.jeq.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.jeq.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.jeq.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bwc();
          ((bwc)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.GAk = localLinkedList;
        paramf.GAj = localLinkedList.size();
      }
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(131109);
    return i;
  }
  
  public final int getType()
  {
    return 32;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131110);
    paramArrayOfByte = (bdy)this.rr.hNL.hNQ;
    bdx localbdx = (bdx)this.rr.hNK.hNQ;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().ErrMsg.HoB, this);
      AppMethodBeat.o(131110);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = bt.nullAsNil((String)com.tencent.mm.kernel.g.ajC().ajl().get(65828, null));
    if ((localbdx.gsV == 1) && (!bt.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(paramq)))
    {
      com.tencent.mm.kernel.g.ajC().ajl().set(65828, paramArrayOfByte.MD5);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).aSJ();
    }
    if (paramArrayOfByte.ujw == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.ujw.size()) });
    long l = com.tencent.mm.kernel.g.ajC().gBq.xO(Thread.currentThread().getId());
    paramInt1 = 0;
    bwd localbwd;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.ujw.size())
    {
      localbwd = (bwd)paramArrayOfByte.ujw.get(paramInt1);
      if (localbwd == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Jx(localbwd.jdb);
        if ((locala == null) && (localbdx.gsV != 1))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localbwd.jdb });
        }
        else
        {
          com.tencent.mm.plugin.c.a.aVi().azR().lU(localbwd.Username, localbwd.Guj);
          localg = new g();
          if (localbdx.gsV != 1) {
            break label959;
          }
          if (localbwd.GQk != null) {
            break label494;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.ePm = localbwd.GQk.pQX;
      localg.jdw = localbwd.GQk.GfP;
      c.CL(localbwd.GQk.pQX);
      localg.jdv = localbwd.GQk.Name;
      localg.ffB = localbwd.jdh;
      localg.ePv = localbwd.jde;
      localg.ePu = localbwd.jdd;
      localg.signature = localbwd.jdf;
      localg.ePt = localbwd.jdg;
      localg.ePk = localbwd.jdc;
      localg.bVF = localbwd.Nickname;
      localg.jcV = com.tencent.mm.platformtools.f.IM(localbwd.GQk.Name);
      localg.jcW = com.tencent.mm.platformtools.f.IL(localbwd.GQk.Name);
      localg.username = localbwd.Username;
      label669:
      localj = new j();
      localj.username = localbwd.Username;
      localj.ePu = localbwd.jdd;
      localj.ePv = localbwd.jde;
      localj.signature = localbwd.jdf;
      localj.ePk = localbwd.jdc;
      localj.ePt = localbwd.jdg;
      paramq = null;
      if (!bt.isNullOrNil(localbwd.Username))
      {
        paramq = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf(localbwd.Username);
        if ((paramq == null) || (!localbwd.Username.equals(paramq.field_username))) {
          break label981;
        }
        if ((bt.isNullOrNil(localbwd.jdh)) || (localbwd.jdh.equals(paramq.VA()))) {
          break label1328;
        }
        paramq.sQ(localbwd.jdh);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().c(paramq.field_username, paramq);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (bt.isNullOrNil(localbwd.Username)) {
        if (localbdx.gsV == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localbdx.gsV == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!bt.isNullOrNil(localbwd.Username)) {
          break label669;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        paramq = null;
        break label863;
        bool = false;
        break label886;
        if ((paramq == null) || (!com.tencent.mm.o.b.lM(paramq.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localbwd.Username;
            locala.bVF = localbwd.Nickname;
            locala.jcV = com.tencent.mm.platformtools.f.IM(localbwd.GQk.Name);
            locala.jcW = com.tencent.mm.platformtools.f.IL(localbwd.GQk.Name);
            locala.jda = locala.acE();
            a(locala, localbwd);
            locala.dDp = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Lb(), locala);
            paramq = new i();
            paramq.username = localbwd.Username;
            paramq.hMX = localbwd.FVo;
            paramq.hMW = localbwd.FVp;
            paramq.eB(true);
            paramq.ePj = 3;
            p.aEx().b(paramq);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localbwd.Username;
            locala.bVF = localbwd.Nickname;
            locala.jda = locala.acE();
            a(locala, localbwd);
            locala.dDp = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Lb(), locala);
            c.ak(localbwd.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.ajC().gBq.sJ(l);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.ais;
import com.tencent.mm.protocal.protobuf.ben;
import com.tencent.mm.protocal.protobuf.beo;
import com.tencent.mm.protocal.protobuf.bww;
import com.tencent.mm.protocal.protobuf.bwx;
import com.tencent.mm.protocal.protobuf.bzz;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f callback;
  private List<String> jdQ;
  private List<String> jhj;
  public com.tencent.mm.ak.b rr;
  
  public ad()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    aTA();
    ben localben = (ben)this.rr.hQD.hQJ;
    localben.MD5 = "";
    localben.GTK = null;
    localben.GTJ = 0;
    localben.GTI = null;
    localben.GTH = 0;
    localben.gvx = 0;
    localben.Scene = 1;
    AppMethodBeat.o(131105);
  }
  
  public ad(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    aTA();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.jdQ = paramList1;
    this.jhj = paramList2;
    paramList1 = (ben)this.rr.hQD.hQJ;
    paramList1.MD5 = "";
    paramList1.gvx = 2;
    paramList1.Scene = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, bwx parambwx)
  {
    parama.jfU = parambwx.jfU;
    parama.jfV = parambwx.jfV;
    parama.jfW = parambwx.jfW;
    parama.jfX = parambwx.jfX;
    parama.jfY = parambwx.jfY;
    parama.jfZ = parambwx.jfZ;
    parama.jga = parambwx.jga;
    parama.jgb = parambwx.jgb;
    parama.jgd = parambwx.jgd;
    parama.jgc = parambwx.jgc;
    parama.jge = parambwx.jge;
    parama.jgf = parambwx.jgf;
    dia localdia = parambwx.HhA;
    if (localdia != null)
    {
      parama.jgg = localdia.jgg;
      parama.jgh = localdia.jgh;
      parama.jgi = localdia.jgi;
    }
    parambwx = parambwx.HhB;
    if (parambwx != null)
    {
      parama.jgj = parambwx.jgj;
      parama.jgk = parambwx.jgk;
      parama.jgl = parambwx.jgl;
      parama.jgm = parambwx.jgm;
    }
  }
  
  private void aTA()
  {
    AppMethodBeat.i(131107);
    b.a locala = new b.a();
    locala.hQF = new ben();
    locala.hQG = new beo();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.hQH = 0;
    locala.respCmdId = 0;
    this.rr = locala.aDS();
    AppMethodBeat.o(131107);
  }
  
  public final void aTB()
  {
    AppMethodBeat.i(131108);
    ben localben = (ben)this.rr.hQD.hQJ;
    localben.MD5 = ((String)com.tencent.mm.kernel.g.ajR().ajA().get(65828, null));
    localben.gvx = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(131109);
    this.callback = paramf;
    paramf = (ben)this.rr.hQD.hQJ;
    if (paramf.gvx == 2)
    {
      if (((this.jdQ == null) || (this.jdQ.size() == 0)) && ((this.jhj == null) || (this.jhj.size() == 0)))
      {
        ae.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.jdQ != null) && (this.jdQ.size() > 0))
      {
        ae.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.jdQ.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.jdQ.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bzz();
          ((bzz)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.GTI = localLinkedList;
        paramf.GTH = localLinkedList.size();
      }
      if ((this.jhj != null) && (this.jhj.size() > 0))
      {
        ae.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.jhj.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.jhj.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bww();
          ((bww)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.GTK = localLinkedList;
        paramf.GTJ = localLinkedList.size();
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
    paramArrayOfByte = (beo)this.rr.hQE.hQJ;
    ben localben = (ben)this.rr.hQD.hQJ;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().ErrMsg.HId, this);
      AppMethodBeat.o(131110);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ae.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
    ae.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = bu.nullAsNil((String)com.tencent.mm.kernel.g.ajR().ajA().get(65828, null));
    if ((localben.gvx == 1) && (!bu.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(paramq)))
    {
      com.tencent.mm.kernel.g.ajR().ajA().set(65828, paramArrayOfByte.MD5);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).aTi();
    }
    if (paramArrayOfByte.uuU == null)
    {
      ae.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    ae.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.uuU.size()) });
    long l = com.tencent.mm.kernel.g.ajR().gDX.yi(Thread.currentThread().getId());
    paramInt1 = 0;
    bwx localbwx;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.uuU.size())
    {
      localbwx = (bwx)paramArrayOfByte.uuU.get(paramInt1);
      if (localbwx == null) {
        ae.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).JW(localbwx.jfU);
        if ((locala == null) && (localben.gvx != 1))
        {
          ae.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localbwx.jfU });
        }
        else
        {
          com.tencent.mm.plugin.c.a.aVH().aAh().mb(localbwx.Username, localbwx.GNI);
          localg = new g();
          if (localben.gvx != 1) {
            break label959;
          }
          if (localbwx.HjL != null) {
            break label494;
          }
          ae.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.eQX = localbwx.HjL.pXC;
      localg.jgp = localbwx.HjL.Gyx;
      com.tencent.mm.aj.c.Dn(localbwx.HjL.pXC);
      localg.jgo = localbwx.HjL.Name;
      localg.fhy = localbwx.jga;
      localg.eRg = localbwx.jfX;
      localg.eRf = localbwx.jfW;
      localg.signature = localbwx.jfY;
      localg.eRe = localbwx.jfZ;
      localg.eQV = localbwx.jfV;
      localg.bVF = localbwx.Nickname;
      localg.jfO = com.tencent.mm.platformtools.f.Jl(localbwx.HjL.Name);
      localg.jfP = com.tencent.mm.platformtools.f.Jk(localbwx.HjL.Name);
      localg.username = localbwx.Username;
      label669:
      localj = new j();
      localj.username = localbwx.Username;
      localj.eRf = localbwx.jfW;
      localj.eRg = localbwx.jfX;
      localj.signature = localbwx.jfY;
      localj.eQV = localbwx.jfV;
      localj.eRe = localbwx.jfZ;
      paramq = null;
      if (!bu.isNullOrNil(localbwx.Username))
      {
        paramq = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localbwx.Username);
        if ((paramq == null) || (!localbwx.Username.equals(paramq.field_username))) {
          break label981;
        }
        if ((bu.isNullOrNil(localbwx.jga)) || (localbwx.jga.equals(paramq.VI()))) {
          break label1328;
        }
        paramq.tl(localbwx.jga);
        ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().c(paramq.field_username, paramq);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (bu.isNullOrNil(localbwx.Username)) {
        if (localben.gvx == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localben.gvx == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!bu.isNullOrNil(localbwx.Username)) {
          break label669;
        }
        ae.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        paramq = null;
        break label863;
        bool = false;
        break label886;
        if ((paramq == null) || (!com.tencent.mm.contact.c.lO(paramq.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localbwx.Username;
            locala.bVF = localbwx.Nickname;
            locala.jfO = com.tencent.mm.platformtools.f.Jl(localbwx.HjL.Name);
            locala.jfP = com.tencent.mm.platformtools.f.Jk(localbwx.HjL.Name);
            locala.jfT = locala.acP();
            a(locala, localbwx);
            locala.dEu = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Lj(), locala);
            paramq = new i();
            paramq.username = localbwx.Username;
            paramq.hPQ = localbwx.GnN;
            paramq.hPP = localbwx.GnO;
            paramq.eD(true);
            paramq.eQU = 3;
            p.aEN().b(paramq);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localbwx.Username;
            locala.bVF = localbwx.Nickname;
            locala.jfT = locala.acP();
            a(locala, localbwx);
            locala.dEu = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Lj(), locala);
            com.tencent.mm.aj.c.al(localbwx.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.ajR().gDX.sW(l);
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
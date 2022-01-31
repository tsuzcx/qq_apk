package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abb;
import com.tencent.mm.protocal.protobuf.amg;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.bba;
import com.tencent.mm.protocal.protobuf.bbb;
import com.tencent.mm.protocal.protobuf.bdj;
import com.tencent.mm.protocal.protobuf.bwc;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ab
  extends m
  implements com.tencent.mm.network.k
{
  private f callback;
  private List<String> guG;
  private List<String> gyd;
  public com.tencent.mm.ai.b rr;
  
  public ab()
  {
    AppMethodBeat.i(108444);
    this.callback = null;
    aqD();
    amg localamg = (amg)this.rr.fsV.fta;
    localamg.wQr = "";
    localamg.xcY = null;
    localamg.xcX = 0;
    localamg.xcW = null;
    localamg.xcV = 0;
    localamg.nrS = 0;
    localamg.Scene = 1;
    AppMethodBeat.o(108444);
  }
  
  public ab(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(108445);
    this.callback = null;
    aqD();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(108445);
      return;
    }
    this.guG = paramList1;
    this.gyd = paramList2;
    paramList1 = (amg)this.rr.fsV.fta;
    paramList1.wQr = "";
    paramList1.nrS = 2;
    paramList1.Scene = 1;
    AppMethodBeat.o(108445);
  }
  
  private static void a(a parama, bbb parambbb)
  {
    parama.gwO = parambbb.gwO;
    parama.gwP = parambbb.gwP;
    parama.gwQ = parambbb.gwQ;
    parama.gwR = parambbb.gwR;
    parama.gwS = parambbb.gwS;
    parama.gwT = parambbb.gwT;
    parama.gwU = parambbb.gwU;
    parama.gwV = parambbb.gwV;
    parama.gwX = parambbb.gwX;
    parama.gwW = parambbb.gwW;
    parama.gwY = parambbb.gwY;
    parama.gwZ = parambbb.gwZ;
    cfj localcfj = parambbb.xpk;
    if (localcfj != null)
    {
      parama.gxa = localcfj.gxa;
      parama.gxb = localcfj.gxb;
      parama.gxc = localcfj.gxc;
    }
    parambbb = parambbb.xpl;
    if (parambbb != null)
    {
      parama.gxd = parambbb.gxd;
      parama.gxe = parambbb.gxe;
      parama.gxf = parambbb.gxf;
      parama.gxg = parambbb.gxg;
    }
  }
  
  private void aqD()
  {
    AppMethodBeat.i(108446);
    b.a locala = new b.a();
    locala.fsX = new amg();
    locala.fsY = new amh();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.ado();
    AppMethodBeat.o(108446);
  }
  
  public final void aqE()
  {
    AppMethodBeat.i(108447);
    amg localamg = (amg)this.rr.fsV.fta;
    localamg.wQr = ((String)com.tencent.mm.kernel.g.RL().Ru().get(65828, null));
    localamg.nrS = 1;
    AppMethodBeat.o(108447);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(108448);
    this.callback = paramf;
    paramf = (amg)this.rr.fsV.fta;
    if (paramf.nrS == 2)
    {
      if (((this.guG == null) || (this.guG.size() == 0)) && ((this.gyd == null) || (this.gyd.size() == 0)))
      {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(108448);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.guG != null) && (this.guG.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.guG.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.guG.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bdj();
          ((bdj)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.xcW = localLinkedList;
        paramf.xcV = localLinkedList.size();
      }
      if ((this.gyd != null) && (this.gyd.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.gyd.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.gyd.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bba();
          ((bba)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.xcY = localLinkedList;
        paramf.xcX = localLinkedList.size();
      }
    }
    int i = dispatch(parame, this.rr, this);
    AppMethodBeat.o(108448);
    return i;
  }
  
  public final int getType()
  {
    return 32;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108449);
    paramArrayOfByte = (amh)this.rr.fsW.fta;
    amg localamg = (amg)this.rr.fsV.fta;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().ErrMsg.xJE, this);
      AppMethodBeat.o(108449);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108449);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = bo.nullAsNil((String)com.tencent.mm.kernel.g.RL().Ru().get(65828, null));
    if ((localamg.nrS == 1) && (!bo.isNullOrNil(paramArrayOfByte.wQr)) && (!paramArrayOfByte.wQr.equals(paramq)))
    {
      com.tencent.mm.kernel.g.RL().Ru().set(65828, paramArrayOfByte.wQr);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).aql();
    }
    if (paramArrayOfByte.ntS == null)
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(108449);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.ntS.size()) });
    long l = com.tencent.mm.kernel.g.RL().eHS.kr(Thread.currentThread().getId());
    paramInt1 = 0;
    bbb localbbb;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.ntS.size())
    {
      localbbb = (bbb)paramArrayOfByte.ntS.get(paramInt1);
      if (localbbb == null) {
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).xa(localbbb.gwO);
        if ((locala == null) && (localamg.nrS != 1))
        {
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localbbb.gwO });
        }
        else
        {
          com.tencent.mm.plugin.c.a.asD().Zb().in(localbbb.Username, localbbb.wYu);
          localg = new g();
          if (localamg.nrS != 1) {
            break label959;
          }
          if (localbbb.xqj != null) {
            break label494;
          }
          com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.dqE = localbbb.xqj.ltw;
      localg.gxj = localbbb.xqj.wRF;
      com.tencent.mm.ah.b.qM(localbbb.xqj.ltw);
      localg.gxi = localbbb.xqj.Name;
      localg.dCJ = localbbb.gwU;
      localg.city = localbbb.gwR;
      localg.province = localbbb.gwQ;
      localg.signature = localbbb.gwS;
      localg.dqL = localbbb.gwT;
      localg.dqC = localbbb.gwP;
      localg.blZ = localbbb.Nickname;
      localg.gwI = com.tencent.mm.platformtools.g.wr(localbbb.xqj.Name);
      localg.gwJ = com.tencent.mm.platformtools.g.wq(localbbb.xqj.Name);
      localg.username = localbbb.Username;
      label669:
      localj = new j();
      localj.username = localbbb.Username;
      localj.province = localbbb.gwQ;
      localj.city = localbbb.gwR;
      localj.signature = localbbb.gwS;
      localj.dqC = localbbb.gwP;
      localj.dqL = localbbb.gwT;
      paramq = null;
      if (!bo.isNullOrNil(localbbb.Username))
      {
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(localbbb.Username);
        if ((paramq == null) || (!localbbb.Username.equals(paramq.field_username))) {
          break label981;
        }
        if ((bo.isNullOrNil(localbbb.gwU)) || (localbbb.gwU.equals(paramq.Hq()))) {
          break label1328;
        }
        paramq.jm(localbbb.gwU);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().b(paramq.field_username, paramq);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (bo.isNullOrNil(localbbb.Username)) {
        if (localamg.nrS == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localamg.nrS == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!bo.isNullOrNil(localbbb.Username)) {
          break label669;
        }
        com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        paramq = null;
        break label863;
        bool = false;
        break label886;
        if ((paramq == null) || (!com.tencent.mm.n.a.je(paramq.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localbbb.Username;
            locala.blZ = localbbb.Nickname;
            locala.gwI = com.tencent.mm.platformtools.g.wr(localbbb.xqj.Name);
            locala.gwJ = com.tencent.mm.platformtools.g.wq(localbbb.xqj.Name);
            locala.gwN = locala.Nu();
            a(locala, localbbb);
            locala.bsY = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Al(), locala);
            paramq = new com.tencent.mm.ah.h();
            paramq.username = localbbb.Username;
            paramq.fsl = localbbb.wJq;
            paramq.fsk = localbbb.wJr;
            paramq.cM(true);
            paramq.dqB = 3;
            o.adg().b(paramq);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localbbb.Username;
            locala.blZ = localbbb.Nickname;
            locala.gwN = locala.Nu();
            a(locala, localbbb);
            locala.bsY = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Al(), locala);
            com.tencent.mm.ah.b.U(localbbb.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.RL().eHS.nY(l);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(108449);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ab
 * JD-Core Version:    0.7.0.1
 */
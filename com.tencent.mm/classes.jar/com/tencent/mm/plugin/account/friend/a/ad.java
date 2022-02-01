package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aet;
import com.tencent.mm.protocal.protobuf.awb;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.bmz;
import com.tencent.mm.protocal.protobuf.bna;
import com.tencent.mm.protocal.protobuf.bpz;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.g callback;
  private List<String> ihG;
  private List<String> ila;
  public com.tencent.mm.al.b rr;
  
  public ad()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    aIY();
    awb localawb = (awb)this.rr.gUS.gUX;
    localawb.MD5 = "";
    localawb.Dvy = null;
    localawb.Dvx = 0;
    localawb.Dvw = null;
    localawb.Dvv = 0;
    localawb.fVE = 0;
    localawb.Scene = 1;
    AppMethodBeat.o(131105);
  }
  
  public ad(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    aIY();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.ihG = paramList1;
    this.ila = paramList2;
    paramList1 = (awb)this.rr.gUS.gUX;
    paramList1.MD5 = "";
    paramList1.fVE = 2;
    paramList1.Scene = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, bna parambna)
  {
    parama.ijL = parambna.ijL;
    parama.ijM = parambna.ijM;
    parama.ijN = parambna.ijN;
    parama.ijO = parambna.ijO;
    parama.ijP = parambna.ijP;
    parama.ijQ = parambna.ijQ;
    parama.ijR = parambna.ijR;
    parama.ijS = parambna.ijS;
    parama.ijU = parambna.ijU;
    parama.ijT = parambna.ijT;
    parama.ijV = parambna.ijV;
    parama.ijW = parambna.ijW;
    cwh localcwh = parambna.DJb;
    if (localcwh != null)
    {
      parama.ijX = localcwh.ijX;
      parama.ijY = localcwh.ijY;
      parama.ijZ = localcwh.ijZ;
    }
    parambna = parambna.DJc;
    if (parambna != null)
    {
      parama.ika = parambna.ika;
      parama.ikb = parambna.ikb;
      parama.ikc = parambna.ikc;
      parama.ikd = parambna.ikd;
    }
  }
  
  private void aIY()
  {
    AppMethodBeat.i(131107);
    b.a locala = new b.a();
    locala.gUU = new awb();
    locala.gUV = new awc();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.atI();
    AppMethodBeat.o(131107);
  }
  
  public final void aIZ()
  {
    AppMethodBeat.i(131108);
    awb localawb = (awb)this.rr.gUS.gUX;
    localawb.MD5 = ((String)com.tencent.mm.kernel.g.afB().afk().get(65828, null));
    localawb.fVE = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.al.g paramg)
  {
    AppMethodBeat.i(131109);
    this.callback = paramg;
    paramg = (awb)this.rr.gUS.gUX;
    if (paramg.fVE == 2)
    {
      if (((this.ihG == null) || (this.ihG.size() == 0)) && ((this.ila == null) || (this.ila.size() == 0)))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.ihG != null) && (this.ihG.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.ihG.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.ihG.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bpz();
          ((bpz)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramg.Dvw = localLinkedList;
        paramg.Dvv = localLinkedList.size();
      }
      if ((this.ila != null) && (this.ila.size() > 0))
      {
        com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.ila.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.ila.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new bmz();
          ((bmz)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramg.Dvy = localLinkedList;
        paramg.Dvx = localLinkedList.size();
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
    paramArrayOfByte = (awc)this.rr.gUT.gUX;
    awb localawb = (awb)this.rr.gUS.gUX;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().ErrMsg.Ehn, this);
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
    paramq = bt.nullAsNil((String)com.tencent.mm.kernel.g.afB().afk().get(65828, null));
    if ((localawb.fVE == 1) && (!bt.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(paramq)))
    {
      com.tencent.mm.kernel.g.afB().afk().set(65828, paramArrayOfByte.MD5);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).aIG();
    }
    if (paramArrayOfByte.sdt == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.sdt.size()) });
    long l = com.tencent.mm.kernel.g.afB().gda.rb(Thread.currentThread().getId());
    paramInt1 = 0;
    bna localbna;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.sdt.size())
    {
      localbna = (bna)paramArrayOfByte.sdt.get(paramInt1);
      if (localbna == null) {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Cf(localbna.ijL);
        if ((locala == null) && (localawb.fVE != 1))
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localbna.ijL });
        }
        else
        {
          com.tencent.mm.plugin.c.a.aLf().aqn().kY(localbna.Username, localbna.Dqd);
          localg = new g();
          if (localawb.fVE != 1) {
            break label959;
          }
          if (localbna.DKt != null) {
            break label494;
          }
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.evr = localbna.DKt.oJZ;
      localg.ikg = localbna.DKt.DeX;
      c.vG(localbna.DKt.oJZ);
      localg.ikf = localbna.DKt.Name;
      localg.eKn = localbna.ijR;
      localg.evA = localbna.ijO;
      localg.evz = localbna.ijN;
      localg.signature = localbna.ijP;
      localg.evy = localbna.ijQ;
      localg.evp = localbna.ijM;
      localg.bNK = localbna.Nickname;
      localg.ijF = f.Bs(localbna.DKt.Name);
      localg.ijG = f.Br(localbna.DKt.Name);
      localg.username = localbna.Username;
      label669:
      localj = new j();
      localj.username = localbna.Username;
      localj.evz = localbna.ijN;
      localj.evA = localbna.ijO;
      localj.signature = localbna.ijP;
      localj.evp = localbna.ijM;
      localj.evy = localbna.ijQ;
      paramq = null;
      if (!bt.isNullOrNil(localbna.Username))
      {
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(localbna.Username);
        if ((paramq == null) || (!localbna.Username.equals(paramq.field_username))) {
          break label981;
        }
        if ((bt.isNullOrNil(localbna.ijR)) || (localbna.ijR.equals(paramq.Ss()))) {
          break label1328;
        }
        paramq.na(localbna.ijR);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().c(paramq.field_username, paramq);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (bt.isNullOrNil(localbna.Username)) {
        if (localawb.fVE == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localawb.fVE == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!bt.isNullOrNil(localbna.Username)) {
          break label669;
        }
        com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        paramq = null;
        break label863;
        bool = false;
        break label886;
        if ((paramq == null) || (!com.tencent.mm.n.b.ls(paramq.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localbna.Username;
            locala.bNK = localbna.Nickname;
            locala.ijF = f.Bs(localbna.DKt.Name);
            locala.ijG = f.Br(localbna.DKt.Name);
            locala.ijK = locala.Zh();
            a(locala, localbna);
            locala.dtM = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.JS(), locala);
            paramq = new i();
            paramq.username = localbna.Username;
            paramq.gUg = localbna.CVv;
            paramq.gUf = localbna.CVw;
            paramq.ee(true);
            paramq.evo = 3;
            p.auF().b(paramq);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localbna.Username;
            locala.bNK = localbna.Nickname;
            locala.ijK = locala.Zh();
            a(locala, localbna);
            locala.dtM = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.JS(), locala);
            c.ac(localbna.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.afB().gda.mX(l);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.c;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.c.av;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.afs;
import com.tencent.mm.protocal.protobuf.azt;
import com.tencent.mm.protocal.protobuf.azu;
import com.tencent.mm.protocal.protobuf.brp;
import com.tencent.mm.protocal.protobuf.brq;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.protocal.protobuf.crm;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.g callback;
  private List<String> iHO;
  private List<String> iLh;
  public com.tencent.mm.ak.b rr;
  
  public ad()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    aPP();
    azt localazt = (azt)this.rr.hvr.hvw;
    localazt.MD5 = "";
    localazt.EQT = null;
    localazt.EQS = 0;
    localazt.EQR = null;
    localazt.EQQ = 0;
    localazt.fZz = 0;
    localazt.Scene = 1;
    AppMethodBeat.o(131105);
  }
  
  public ad(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    aPP();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.iHO = paramList1;
    this.iLh = paramList2;
    paramList1 = (azt)this.rr.hvr.hvw;
    paramList1.MD5 = "";
    paramList1.fZz = 2;
    paramList1.Scene = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, brq parambrq)
  {
    parama.iJS = parambrq.iJS;
    parama.iJT = parambrq.iJT;
    parama.iJU = parambrq.iJU;
    parama.iJV = parambrq.iJV;
    parama.iJW = parambrq.iJW;
    parama.iJX = parambrq.iJX;
    parama.iJY = parambrq.iJY;
    parama.iJZ = parambrq.iJZ;
    parama.iKb = parambrq.iKb;
    parama.iKa = parambrq.iKa;
    parama.iKc = parambrq.iKc;
    parama.iKd = parambrq.iKd;
    dbt localdbt = parambrq.Few;
    if (localdbt != null)
    {
      parama.iKe = localdbt.iKe;
      parama.iKf = localdbt.iKf;
      parama.iKg = localdbt.iKg;
    }
    parambrq = parambrq.Fex;
    if (parambrq != null)
    {
      parama.iKh = parambrq.iKh;
      parama.iKi = parambrq.iKi;
      parama.iKj = parambrq.iKj;
      parama.iKk = parambrq.iKk;
    }
  }
  
  private void aPP()
  {
    AppMethodBeat.i(131107);
    b.a locala = new b.a();
    locala.hvt = new azt();
    locala.hvu = new azu();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.reqCmdId = 0;
    locala.respCmdId = 0;
    this.rr = locala.aAz();
    AppMethodBeat.o(131107);
  }
  
  public final void aPQ()
  {
    AppMethodBeat.i(131108);
    azt localazt = (azt)this.rr.hvr.hvw;
    localazt.MD5 = ((String)com.tencent.mm.kernel.g.agR().agA().get(65828, null));
    localazt.fZz = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.e parame, com.tencent.mm.ak.g paramg)
  {
    AppMethodBeat.i(131109);
    this.callback = paramg;
    paramg = (azt)this.rr.hvr.hvw;
    if (paramg.fZz == 2)
    {
      if (((this.iHO == null) || (this.iHO.size() == 0)) && ((this.iLh == null) || (this.iLh.size() == 0)))
      {
        ac.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.iHO != null) && (this.iHO.size() > 0))
      {
        ac.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.iHO.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.iHO.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new buq();
          ((buq)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramg.EQR = localLinkedList;
        paramg.EQQ = localLinkedList.size();
      }
      if ((this.iLh != null) && (this.iLh.size() > 0))
      {
        ac.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.iLh.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.iLh.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new brp();
          ((brp)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramg.EQT = localLinkedList;
        paramg.EQS = localLinkedList.size();
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
    paramArrayOfByte = (azu)this.rr.hvs.hvw;
    azt localazt = (azt)this.rr.hvr.hvw;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().ErrMsg.FEm, this);
      AppMethodBeat.o(131110);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      ac.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
    ac.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = bs.nullAsNil((String)com.tencent.mm.kernel.g.agR().agA().get(65828, null));
    if ((localazt.fZz == 1) && (!bs.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(paramq)))
    {
      com.tencent.mm.kernel.g.agR().agA().set(65828, paramArrayOfByte.MD5);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).aPx();
    }
    if (paramArrayOfByte.tln == null)
    {
      ac.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    ac.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.tln.size()) });
    long l = com.tencent.mm.kernel.g.agR().ghG.vE(Thread.currentThread().getId());
    paramInt1 = 0;
    brq localbrq;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.tln.size())
    {
      localbrq = (brq)paramArrayOfByte.tln.get(paramInt1);
      if (localbrq == null) {
        ac.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).Gi(localbrq.iJS);
        if ((locala == null) && (localazt.fZz != 1))
        {
          ac.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localbrq.iJS });
        }
        else
        {
          com.tencent.mm.plugin.c.a.aRW().axc().lv(localbrq.Username, localbrq.ELg);
          localg = new g();
          if (localazt.fZz != 1) {
            break label959;
          }
          if (localbrq.FgI != null) {
            break label494;
          }
          ac.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.exN = localbrq.FgI.pnx;
      localg.iKn = localbrq.FgI.Eyd;
      c.zM(localbrq.FgI.pnx);
      localg.iKm = localbrq.FgI.Name;
      localg.eNf = localbrq.iJY;
      localg.exW = localbrq.iJV;
      localg.exV = localbrq.iJU;
      localg.signature = localbrq.iJW;
      localg.exU = localbrq.iJX;
      localg.exL = localbrq.iJT;
      localg.bLs = localbrq.Nickname;
      localg.iJM = f.Fw(localbrq.FgI.Name);
      localg.iJN = f.Fv(localbrq.FgI.Name);
      localg.username = localbrq.Username;
      label669:
      localj = new j();
      localj.username = localbrq.Username;
      localj.exV = localbrq.iJU;
      localj.exW = localbrq.iJV;
      localj.signature = localbrq.iJW;
      localj.exL = localbrq.iJT;
      localj.exU = localbrq.iJX;
      paramq = null;
      if (!bs.isNullOrNil(localbrq.Username))
      {
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(localbrq.Username);
        if ((paramq == null) || (!localbrq.Username.equals(paramq.field_username))) {
          break label981;
        }
        if ((bs.isNullOrNil(localbrq.iJY)) || (localbrq.iJY.equals(paramq.Tl()))) {
          break label1328;
        }
        paramq.qg(localbrq.iJY);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().c(paramq.field_username, paramq);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (bs.isNullOrNil(localbrq.Username)) {
        if (localazt.fZz == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localazt.fZz == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!bs.isNullOrNil(localbrq.Username)) {
          break label669;
        }
        ac.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        paramq = null;
        break label863;
        bool = false;
        break label886;
        if ((paramq == null) || (!com.tencent.mm.n.b.ln(paramq.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localbrq.Username;
            locala.bLs = localbrq.Nickname;
            locala.iJM = f.Fw(localbrq.FgI.Name);
            locala.iJN = f.Fv(localbrq.FgI.Name);
            locala.iJR = locala.aac();
            a(locala, localbrq);
            locala.drx = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.JC(), locala);
            paramq = new i();
            paramq.username = localbrq.Username;
            paramq.huF = localbrq.Eof;
            paramq.huE = localbrq.Eog;
            paramq.ez(true);
            paramq.exK = 3;
            p.aBw().b(paramq);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localbrq.Username;
            locala.bLs = localbrq.Nickname;
            locala.iJR = locala.aac();
            a(locala, localbrq);
            locala.drx = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.JC(), locala);
            c.ag(localbrq.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.agR().ghG.qL(l);
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
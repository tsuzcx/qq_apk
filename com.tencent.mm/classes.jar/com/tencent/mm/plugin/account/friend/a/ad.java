package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.e;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.alg;
import com.tencent.mm.protocal.protobuf.bqd;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.cko;
import com.tencent.mm.protocal.protobuf.ckp;
import com.tencent.mm.protocal.protobuf.cpb;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ad
  extends q
  implements m
{
  private com.tencent.mm.ak.i callback;
  private List<String> kbT;
  private List<String> kfn;
  public d rr;
  
  public ad()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    bom();
    bqd localbqd = (bqd)this.rr.iLK.iLR;
    localbqd.MD5 = "";
    localbqd.LXY = null;
    localbqd.LXX = 0;
    localbqd.LXW = null;
    localbqd.LXV = 0;
    localbqd.him = 0;
    localbqd.Scene = 1;
    AppMethodBeat.o(131105);
  }
  
  public ad(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    bom();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.kbT = paramList1;
    this.kfn = paramList2;
    paramList1 = (bqd)this.rr.iLK.iLR;
    paramList1.MD5 = "";
    paramList1.him = 2;
    paramList1.Scene = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, ckp paramckp)
  {
    parama.kdX = paramckp.kdX;
    parama.kdY = paramckp.kdY;
    parama.kdZ = paramckp.kdZ;
    parama.kea = paramckp.kea;
    parama.keb = paramckp.keb;
    parama.kec = paramckp.kec;
    parama.ked = paramckp.ked;
    parama.kee = paramckp.kee;
    parama.keg = paramckp.keg;
    parama.kef = paramckp.kef;
    parama.keh = paramckp.keh;
    parama.kei = paramckp.kei;
    ebj localebj = paramckp.MmQ;
    if (localebj != null)
    {
      parama.kej = localebj.kej;
      parama.kek = localebj.kek;
      parama.kel = localebj.kel;
    }
    paramckp = paramckp.MmR;
    if (paramckp != null)
    {
      parama.kem = paramckp.kem;
      parama.ken = paramckp.ken;
      parama.keo = paramckp.keo;
      parama.kep = paramckp.kep;
    }
  }
  
  private void bom()
  {
    AppMethodBeat.i(131107);
    d.a locala = new d.a();
    locala.iLN = new bqd();
    locala.iLO = new bqe();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.iLP = 0;
    locala.respCmdId = 0;
    this.rr = locala.aXF();
    AppMethodBeat.o(131107);
  }
  
  public final void bon()
  {
    AppMethodBeat.i(131108);
    bqd localbqd = (bqd)this.rr.iLK.iLR;
    localbqd.MD5 = ((String)com.tencent.mm.kernel.g.aAh().azQ().get(65828, null));
    localbqd.him = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(131109);
    this.callback = parami;
    parami = (bqd)this.rr.iLK.iLR;
    if (parami.him == 2)
    {
      if (((this.kbT == null) || (this.kbT.size() == 0)) && ((this.kfn == null) || (this.kfn.size() == 0)))
      {
        Log.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.kbT != null) && (this.kbT.size() > 0))
      {
        Log.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.kbT.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.kbT.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new cpb();
          ((cpb)localObject).v = str;
          localLinkedList.add(localObject);
        }
        parami.LXW = localLinkedList;
        parami.LXV = localLinkedList.size();
      }
      if ((this.kfn != null) && (this.kfn.size() > 0))
      {
        Log.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.kfn.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.kfn.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new cko();
          ((cko)localObject).v = str;
          localLinkedList.add(localObject);
        }
        parami.LXY = localLinkedList;
        parami.LXX = localLinkedList.size();
      }
    }
    int i = dispatch(paramg, this.rr, this);
    AppMethodBeat.o(131109);
    return i;
  }
  
  public final int getType()
  {
    return 32;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(131110);
    paramArrayOfByte = (bqe)this.rr.iLL.iLR;
    bqd localbqd = (bqd)this.rr.iLK.iLR;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().ErrMsg.MTo, this);
      AppMethodBeat.o(131110);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      Log.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
    Log.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    params = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(65828, null));
    if ((localbqd.him == 1) && (!Util.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(params)))
    {
      com.tencent.mm.kernel.g.aAh().azQ().set(65828, paramArrayOfByte.MD5);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).bnU();
    }
    if (paramArrayOfByte.xMV == null)
    {
      Log.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    Log.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.xMV.size()) });
    long l = com.tencent.mm.kernel.g.aAh().hqK.beginTransaction(Thread.currentThread().getId());
    paramInt1 = 0;
    ckp localckp;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.xMV.size())
    {
      localckp = (ckp)paramArrayOfByte.xMV.get(paramInt1);
      if (localckp == null) {
        Log.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).SU(localckp.kdX);
        if ((locala == null) && (localbqd.him != 1))
        {
          Log.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localckp.kdX });
        }
        else
        {
          com.tencent.mm.plugin.c.a.bqE().aTp().mP(localckp.Username, localckp.LRO);
          localg = new g();
          if (localbqd.him != 1) {
            break label959;
          }
          if (localckp.MpZ != null) {
            break label494;
          }
          Log.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.fuC = localckp.MpZ.oIi;
      localg.kes = localckp.MpZ.Lul;
      com.tencent.mm.aj.c.LX(localckp.MpZ.oIi);
      localg.ker = localckp.MpZ.Name;
      localg.fMb = localckp.ked;
      localg.fuK = localckp.kea;
      localg.fuJ = localckp.kdZ;
      localg.signature = localckp.keb;
      localg.fuI = localckp.kec;
      localg.fuA = localckp.kdY;
      localg.nickName = localckp.Nickname;
      localg.kdR = f.Si(localckp.MpZ.Name);
      localg.kdS = f.Sh(localckp.MpZ.Name);
      localg.username = localckp.Username;
      label669:
      localj = new j();
      localj.username = localckp.Username;
      localj.fuJ = localckp.kdZ;
      localj.fuK = localckp.kea;
      localj.signature = localckp.keb;
      localj.fuA = localckp.kdY;
      localj.fuI = localckp.kec;
      params = null;
      if (!Util.isNullOrNil(localckp.Username))
      {
        params = ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().Kn(localckp.Username);
        if ((params == null) || (!localckp.Username.equals(params.field_username))) {
          break label981;
        }
        if ((Util.isNullOrNil(localckp.ked)) || (localckp.ked.equals(params.ajx()))) {
          break label1328;
        }
        params.BC(localckp.ked);
        ((l)com.tencent.mm.kernel.g.af(l.class)).aSN().c(params.field_username, params);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (Util.isNullOrNil(localckp.Username)) {
        if (localbqd.him == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localbqd.him == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!Util.isNullOrNil(localckp.Username)) {
          break label669;
        }
        Log.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        params = null;
        break label863;
        bool = false;
        break label886;
        if ((params == null) || (!com.tencent.mm.contact.c.oR(params.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localckp.Username;
            locala.nickName = localckp.Nickname;
            locala.kdR = f.Si(localckp.MpZ.Name);
            locala.kdS = f.Sh(localckp.MpZ.Name);
            locala.kdW = locala.aqN();
            a(locala, localckp);
            locala.cSx = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.getMd5(), locala);
            params = new com.tencent.mm.aj.i();
            params.username = localckp.Username;
            params.iKX = localckp.Lir;
            params.iKW = localckp.Lis;
            params.fv(true);
            params.fuz = 3;
            p.aYB().b(params);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localckp.Username;
            locala.nickName = localckp.Nickname;
            locala.kdW = locala.aqN();
            a(locala, localckp);
            locala.cSx = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.getMd5(), locala);
            com.tencent.mm.aj.c.ap(localckp.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.aAh().hqK.endTransaction(l);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ad
 * JD-Core Version:    0.7.0.1
 */
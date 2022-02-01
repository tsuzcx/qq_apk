package com.tencent.mm.plugin.account.friend.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.apz;
import com.tencent.mm.protocal.protobuf.cna;
import com.tencent.mm.protocal.protobuf.cnb;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dkk;
import com.tencent.mm.protocal.protobuf.dow;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class aa
  extends p
  implements m
{
  private com.tencent.mm.am.h callback;
  private List<String> pPZ;
  private List<String> pTt;
  public c rr;
  
  public aa()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    bXj();
    cna localcna = (cna)c.b.b(this.rr.otB);
    localcna.MD5 = "";
    localcna.aauF = null;
    localcna.aauE = 0;
    localcna.aauD = null;
    localcna.aauC = 0;
    localcna.muC = 0;
    localcna.IJG = 1;
    AppMethodBeat.o(131105);
  }
  
  public aa(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    bXj();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.pPZ = paramList1;
    this.pTt = paramList2;
    paramList1 = (cna)c.b.b(this.rr.otB);
    paramList1.MD5 = "";
    paramList1.muC = 2;
    paramList1.IJG = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, dkk paramdkk)
  {
    parama.pSe = paramdkk.pSe;
    parama.pSf = paramdkk.pSf;
    parama.pSg = paramdkk.pSg;
    parama.pSh = paramdkk.pSh;
    parama.pSi = paramdkk.pSi;
    parama.pSj = paramdkk.pSj;
    parama.pSk = paramdkk.pSk;
    parama.pSl = paramdkk.pSl;
    parama.pSn = paramdkk.pSn;
    parama.pSm = paramdkk.pSm;
    parama.pSo = paramdkk.pSo;
    parama.pSp = paramdkk.pSp;
    ffs localffs = paramdkk.aaMs;
    if (localffs != null)
    {
      parama.pSq = localffs.pSq;
      parama.pSr = localffs.pSr;
      parama.pSs = localffs.pSs;
    }
    paramdkk = paramdkk.aaMt;
    if (paramdkk != null)
    {
      parama.pSt = paramdkk.pSt;
      parama.pSu = paramdkk.pSu;
      parama.pSv = paramdkk.pSv;
      parama.pSw = paramdkk.pSw;
    }
  }
  
  private void bXj()
  {
    AppMethodBeat.i(131107);
    c.a locala = new c.a();
    locala.otE = new cna();
    locala.otF = new cnb();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.otG = 0;
    locala.respCmdId = 0;
    this.rr = locala.bEF();
    AppMethodBeat.o(131107);
  }
  
  public final void bXk()
  {
    AppMethodBeat.i(131108);
    cna localcna = (cna)c.b.b(this.rr.otB);
    localcna.MD5 = ((String)com.tencent.mm.kernel.h.baE().ban().d(65828, null));
    localcna.muC = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(131109);
    this.callback = paramh;
    paramh = (cna)c.b.b(this.rr.otB);
    if (paramh.muC == 2)
    {
      if (((this.pPZ == null) || (this.pPZ.size() == 0)) && ((this.pTt == null) || (this.pTt.size() == 0)))
      {
        Log.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.pPZ != null) && (this.pPZ.size() > 0))
      {
        Log.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.pPZ.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.pPZ.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new dow();
          ((dow)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramh.aauD = localLinkedList;
        paramh.aauC = localLinkedList.size();
      }
      if ((this.pTt != null) && (this.pTt.size() > 0))
      {
        Log.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.pTt.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.pTt.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new dkj();
          ((dkj)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramh.aauF = localLinkedList;
        paramh.aauE = localLinkedList.size();
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
    paramArrayOfByte = (cnb)c.c.b(this.rr.otC);
    cna localcna = (cna)c.b.b(this.rr.otB);
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().akjO.abwM, this);
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
    params = Util.nullAsNil((String)com.tencent.mm.kernel.h.baE().ban().d(65828, null));
    if ((localcna.muC == 1) && (!Util.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(params)))
    {
      com.tencent.mm.kernel.h.baE().ban().B(65828, paramArrayOfByte.MD5);
      ((e)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getFacebookFrdStg()).bwy();
    }
    if (paramArrayOfByte.ILu == null)
    {
      Log.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    Log.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.ILu.size()) });
    long l = com.tencent.mm.kernel.h.baE().mCN.beginTransaction(Thread.currentThread().getId());
    paramInt1 = 0;
    dkk localdkk;
    a locala;
    d locald;
    label494:
    g localg;
    if (paramInt1 < paramArrayOfByte.ILu.size())
    {
      localdkk = (dkk)paramArrayOfByte.ILu.get(paramInt1);
      if (localdkk == null) {
        Log.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).SU(localdkk.pSe);
        if ((locala == null) && (localcna.muC != 1))
        {
          Log.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localdkk.pSe });
        }
        else
        {
          com.tencent.mm.plugin.c.a.caJ().bAc().pE(localdkk.Username, localdkk.aant);
          locald = new d();
          if (localcna.muC != 1) {
            break label959;
          }
          if (localdkk.aaQq != null) {
            break label494;
          }
          Log.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      locald.kaa = localdkk.aaQq.ID;
      locald.pSz = localdkk.aaQq.Zxs;
      com.tencent.mm.modelavatar.d.Lu(localdkk.aaQq.ID);
      locald.pSy = localdkk.aaQq.IGU;
      locald.kDc = localdkk.pSk;
      locald.city = localdkk.pSh;
      locald.province = localdkk.pSg;
      locald.signature = localdkk.pSi;
      locald.kag = localdkk.pSj;
      locald.sex = localdkk.pSf;
      locald.nickName = localdkk.Nickname;
      locald.pRY = com.tencent.mm.platformtools.f.Sa(localdkk.aaQq.IGU);
      locald.pRZ = com.tencent.mm.platformtools.f.RZ(localdkk.aaQq.IGU);
      locald.username = localdkk.Username;
      label669:
      localg = new g();
      localg.username = localdkk.Username;
      localg.province = localdkk.pSg;
      localg.city = localdkk.pSh;
      localg.signature = localdkk.pSi;
      localg.sex = localdkk.pSf;
      localg.kag = localdkk.pSj;
      params = null;
      if (!Util.isNullOrNil(localdkk.Username))
      {
        params = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localdkk.Username);
        if ((params == null) || (!localdkk.Username.equals(params.field_username))) {
          break label981;
        }
        if ((Util.isNullOrNil(localdkk.pSk)) || (localdkk.pSk.equals(params.aJs()))) {
          break label1328;
        }
        params.AV(localdkk.pSk);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().d(params.field_username, params);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (Util.isNullOrNil(localdkk.Username)) {
        if (localcna.muC == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          locald.status = 102;
        }
      }
      for (;;)
      {
        if (localcna.muC == 1) {
          ((e)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getFacebookFrdStg()).a(locald);
        }
        ((h)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getFrdExtStg()).a(localg);
        break;
        label959:
        if (!Util.isNullOrNil(localdkk.Username)) {
          break label669;
        }
        Log.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        params = null;
        break label863;
        bool = false;
        break label886;
        if ((params == null) || (!com.tencent.mm.contact.d.rs(params.field_type)))
        {
          locald.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localdkk.Username;
            locala.nickName = localdkk.Nickname;
            locala.pRY = com.tencent.mm.platformtools.f.Sa(localdkk.aaQq.IGU);
            locala.pRZ = com.tencent.mm.platformtools.f.RZ(localdkk.aaQq.IGU);
            locala.pSd = locala.aRH();
            a(locala, localdkk);
            locala.eQp = -1;
            ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).a(locala.getMd5(), locala);
            params = new j();
            params.username = localdkk.Username;
            params.osN = localdkk.ZhO;
            params.osM = localdkk.ZhP;
            params.gX(true);
            params.jZY = 3;
            q.bFE().b(params);
          }
        }
        else
        {
          locald.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localdkk.Username;
            locala.nickName = localdkk.Nickname;
            locala.pSd = locala.aRH();
            a(locala, localdkk);
            locala.eQp = -1;
            ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).a(locala.getMd5(), locala);
            com.tencent.mm.modelavatar.d.aS(localdkk.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.h.baE().mCN.endTransaction(l);
      this.callback.onSceneEnd(paramInt2, paramInt3, paramString, this);
      AppMethodBeat.o(131110);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.aa
 * JD-Core Version:    0.7.0.1
 */
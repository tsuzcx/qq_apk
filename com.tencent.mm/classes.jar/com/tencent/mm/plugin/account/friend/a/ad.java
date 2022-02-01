package com.tencent.mm.plugin.account.friend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.bxy;
import com.tencent.mm.protocal.protobuf.cth;
import com.tencent.mm.protocal.protobuf.cti;
import com.tencent.mm.protocal.protobuf.cxr;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.jh;
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
  extends com.tencent.mm.an.q
  implements m
{
  private i callback;
  private List<String> mTs;
  private List<String> mWM;
  public com.tencent.mm.an.d rr;
  
  public ad()
  {
    AppMethodBeat.i(131105);
    this.callback = null;
    byv();
    bxx localbxx = (bxx)d.b.b(this.rr.lBR);
    localbxx.MD5 = "";
    localbxx.Thp = null;
    localbxx.Tho = 0;
    localbxx.Thn = null;
    localbxx.Thm = 0;
    localbxx.jUk = 0;
    localbxx.CPw = 1;
    AppMethodBeat.o(131105);
  }
  
  public ad(List<String> paramList1, List<String> paramList2)
  {
    AppMethodBeat.i(131106);
    this.callback = null;
    byv();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0)))
    {
      AppMethodBeat.o(131106);
      return;
    }
    this.mTs = paramList1;
    this.mWM = paramList2;
    paramList1 = (bxx)d.b.b(this.rr.lBR);
    paramList1.MD5 = "";
    paramList1.jUk = 2;
    paramList1.CPw = 1;
    AppMethodBeat.o(131106);
  }
  
  private static void a(a parama, cti paramcti)
  {
    parama.mVx = paramcti.mVx;
    parama.mVy = paramcti.mVy;
    parama.mVz = paramcti.mVz;
    parama.mVA = paramcti.mVA;
    parama.mVB = paramcti.mVB;
    parama.mVC = paramcti.mVC;
    parama.mVD = paramcti.mVD;
    parama.mVE = paramcti.mVE;
    parama.mVG = paramcti.mVG;
    parama.mVF = paramcti.mVF;
    parama.mVH = paramcti.mVH;
    parama.mVI = paramcti.mVI;
    elj localelj = paramcti.TxL;
    if (localelj != null)
    {
      parama.mVJ = localelj.mVJ;
      parama.mVK = localelj.mVK;
      parama.mVL = localelj.mVL;
    }
    paramcti = paramcti.TxM;
    if (paramcti != null)
    {
      parama.mVM = paramcti.mVM;
      parama.mVN = paramcti.mVN;
      parama.mVO = paramcti.mVO;
      parama.mVP = paramcti.mVP;
    }
  }
  
  private void byv()
  {
    AppMethodBeat.i(131107);
    d.a locala = new d.a();
    locala.lBU = new bxx();
    locala.lBV = new bxy();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.funcId = 142;
    locala.lBW = 0;
    locala.respCmdId = 0;
    this.rr = locala.bgN();
    AppMethodBeat.o(131107);
  }
  
  public final void byw()
  {
    AppMethodBeat.i(131108);
    bxx localbxx = (bxx)d.b.b(this.rr.lBR);
    localbxx.MD5 = ((String)com.tencent.mm.kernel.h.aHG().aHp().b(65828, null));
    localbxx.jUk = 1;
    AppMethodBeat.o(131108);
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(131109);
    this.callback = parami;
    parami = (bxx)d.b.b(this.rr.lBR);
    if (parami.jUk == 2)
    {
      if (((this.mTs == null) || (this.mTs.size() == 0)) && ((this.mWM == null) || (this.mWM.size() == 0)))
      {
        Log.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        AppMethodBeat.o(131109);
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.mTs != null) && (this.mTs.size() > 0))
      {
        Log.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.mTs.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.mTs.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new cxr();
          ((cxr)localObject).v = str;
          localLinkedList.add(localObject);
        }
        parami.Thn = localLinkedList;
        parami.Thm = localLinkedList.size();
      }
      if ((this.mWM != null) && (this.mWM.size() > 0))
      {
        Log.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.mWM.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.mWM.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new cth();
          ((cth)localObject).v = str;
          localLinkedList.add(localObject);
        }
        parami.Thp = localLinkedList;
        parami.Tho = localLinkedList.size();
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
    paramArrayOfByte = (bxy)d.c.b(this.rr.lBS);
    bxx localbxx = (bxx)d.b.b(this.rr.lBR);
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.callback.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.getBaseResponse().Tef.Ufy, this);
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
    params = Util.nullAsNil((String)com.tencent.mm.kernel.h.aHG().aHp().b(65828, null));
    if ((localbxx.jUk == 1) && (!Util.isNullOrNil(paramArrayOfByte.MD5)) && (!paramArrayOfByte.MD5.equals(params)))
    {
      com.tencent.mm.kernel.h.aHG().aHp().i(65828, paramArrayOfByte.MD5);
      ((h)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getFacebookFrdStg()).byd();
    }
    if (paramArrayOfByte.CRe == null)
    {
      Log.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      AppMethodBeat.o(131110);
      return;
    }
    Log.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.CRe.size()) });
    long l = com.tencent.mm.kernel.h.aHG().kcF.beginTransaction(Thread.currentThread().getId());
    paramInt1 = 0;
    cti localcti;
    a locala;
    g localg;
    label494:
    j localj;
    if (paramInt1 < paramArrayOfByte.CRe.size())
    {
      localcti = (cti)paramArrayOfByte.CRe.get(paramInt1);
      if (localcti == null) {
        Log.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).aaA(localcti.mVx);
        if ((locala == null) && (localbxx.jUk != 1))
        {
          Log.e("MicroMsg.NetSceneGetMFriend", "Err MD5 %s not found in AddrUploadStg, md5: ", new Object[] { localcti.mVx });
        }
        else
        {
          com.tencent.mm.plugin.c.a.bBt().bcn().nG(localcti.Username, localcti.Tav);
          localg = new g();
          if (localbxx.jUk != 1) {
            break label959;
          }
          if (localcti.TBc != null) {
            break label494;
          }
          Log.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.hDe = localcti.TBc.rJY;
      localg.mVS = localcti.TBc.SwJ;
      com.tencent.mm.am.d.Ts(localcti.TBc.rJY);
      localg.mVR = localcti.TBc.CMP;
      localg.idS = localcti.mVD;
      localg.city = localcti.mVA;
      localg.province = localcti.mVz;
      localg.signature = localcti.mVB;
      localg.hDk = localcti.mVC;
      localg.sex = localcti.mVy;
      localg.nickName = localcti.Nickname;
      localg.mVr = com.tencent.mm.platformtools.f.ZK(localcti.TBc.CMP);
      localg.mVs = com.tencent.mm.platformtools.f.ZJ(localcti.TBc.CMP);
      localg.username = localcti.Username;
      label669:
      localj = new j();
      localj.username = localcti.Username;
      localj.province = localcti.mVz;
      localj.city = localcti.mVA;
      localj.signature = localcti.mVB;
      localj.sex = localcti.mVy;
      localj.hDk = localcti.mVC;
      params = null;
      if (!Util.isNullOrNil(localcti.Username))
      {
        params = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localcti.Username);
        if ((params == null) || (!localcti.Username.equals(params.field_username))) {
          break label981;
        }
        if ((Util.isNullOrNil(localcti.mVD)) || (localcti.mVD.equals(params.apf()))) {
          break label1328;
        }
        params.Iq(localcti.mVD);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().c(params.field_username, params);
      }
    }
    label1328:
    for (;;)
    {
      label863:
      boolean bool;
      if (Util.isNullOrNil(localcti.Username)) {
        if (localbxx.jUk == 1)
        {
          bool = true;
          label886:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localbxx.jUk == 1) {
          ((h)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label959:
        if (!Util.isNullOrNil(localcti.Username)) {
          break label669;
        }
        Log.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label981:
        params = null;
        break label863;
        bool = false;
        break label886;
        if ((params == null) || (!com.tencent.mm.contact.d.rk(params.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            locala.status = 1;
            locala.username = localcti.Username;
            locala.nickName = localcti.Nickname;
            locala.mVr = com.tencent.mm.platformtools.f.ZK(localcti.TBc.CMP);
            locala.mVs = com.tencent.mm.platformtools.f.ZJ(localcti.TBc.CMP);
            locala.mVw = locala.axh();
            a(locala, localcti);
            locala.cUP = -1;
            ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).a(locala.getMd5(), locala);
            params = new com.tencent.mm.am.j();
            params.username = localcti.Username;
            params.lBe = localcti.SjI;
            params.lBd = localcti.SjJ;
            params.gg(true);
            params.hDc = 3;
            com.tencent.mm.am.q.bhP().b(params);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            locala.status = 2;
            locala.username = localcti.Username;
            locala.nickName = localcti.Nickname;
            locala.mVw = locala.axh();
            a(locala, localcti);
            locala.cUP = -1;
            ((b)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getAddrUploadStg()).a(locala.getMd5(), locala);
            com.tencent.mm.am.d.aH(localcti.Username, 3);
          }
        }
      }
      com.tencent.mm.kernel.h.aHG().kcF.endTransaction(l);
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
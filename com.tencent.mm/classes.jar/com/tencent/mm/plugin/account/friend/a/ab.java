package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahl;
import com.tencent.mm.protocal.c.ahm;
import com.tencent.mm.protocal.c.auq;
import com.tencent.mm.protocal.c.aur;
import com.tencent.mm.protocal.c.awt;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.protocal.c.bml;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.gd;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.protocal.c.ww;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  public com.tencent.mm.ah.b dmK;
  private f dmL = null;
  private List<String> fcV;
  private List<String> fgv;
  
  public ab()
  {
    WZ();
    ahl localahl = (ahl)this.dmK.ecE.ecN;
    localahl.sRE = "";
    localahl.tfb = null;
    localahl.tfa = 0;
    localahl.teZ = null;
    localahl.teY = 0;
    localahl.kTS = 0;
    localahl.pyo = 1;
  }
  
  public ab(List<String> paramList1, List<String> paramList2)
  {
    WZ();
    if (((paramList1 == null) || (paramList1.size() == 0)) && ((paramList2 == null) || (paramList2.size() == 0))) {
      return;
    }
    this.fcV = paramList1;
    this.fgv = paramList2;
    paramList1 = (ahl)this.dmK.ecE.ecN;
    paramList1.sRE = "";
    paramList1.kTS = 2;
    paramList1.pyo = 1;
  }
  
  private void WZ()
  {
    b.a locala = new b.a();
    locala.ecH = new ahl();
    locala.ecI = new ahm();
    locala.uri = "/cgi-bin/micromsg-bin/getmfriend";
    locala.ecG = 142;
    locala.ecJ = 0;
    locala.ecK = 0;
    this.dmK = locala.Kt();
  }
  
  private static void a(a parama, aur paramaur)
  {
    parama.ffg = paramaur.ffg;
    parama.ffh = paramaur.ffh;
    parama.ffi = paramaur.ffi;
    parama.ffj = paramaur.ffj;
    parama.ffk = paramaur.ffk;
    parama.ffl = paramaur.ffl;
    parama.ffm = paramaur.ffm;
    parama.ffn = paramaur.ffn;
    parama.ffp = paramaur.ffp;
    parama.ffo = paramaur.ffo;
    parama.ffq = paramaur.ffq;
    parama.ffr = paramaur.ffr;
    but localbut = paramaur.tpm;
    if (localbut != null)
    {
      parama.ffs = localbut.ffs;
      parama.fft = localbut.fft;
      parama.ffu = localbut.ffu;
    }
    paramaur = paramaur.tpn;
    if (paramaur != null)
    {
      parama.ffv = paramaur.ffv;
      parama.ffw = paramaur.ffw;
      parama.ffx = paramaur.ffx;
      parama.ffy = paramaur.ffy;
    }
  }
  
  public final void Xa()
  {
    ahl localahl = (ahl)this.dmK.ecE.ecN;
    localahl.sRE = ((String)com.tencent.mm.kernel.g.DP().Dz().get(65828, null));
    localahl.kTS = 1;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dmL = paramf;
    paramf = (ahl)this.dmK.ecE.ecN;
    if (paramf.kTS == 2)
    {
      if (((this.fcV == null) || (this.fcV.size() == 0)) && ((this.fgv == null) || (this.fgv.size() == 0)))
      {
        y.e("MicroMsg.NetSceneGetMFriend", "doScene failed, mobile list and email list empty.");
        return -1;
      }
      LinkedList localLinkedList;
      Iterator localIterator;
      String str;
      Object localObject;
      if ((this.fcV != null) && (this.fcV.size() > 0))
      {
        y.d("MicroMsg.NetSceneGetMFriend", "doScene get mobile list size:%d", new Object[] { Integer.valueOf(this.fcV.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.fcV.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new awt();
          ((awt)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.teZ = localLinkedList;
        paramf.teY = localLinkedList.size();
      }
      if ((this.fgv != null) && (this.fgv.size() > 0))
      {
        y.d("MicroMsg.NetSceneGetMFriend", "doScene get email list size:%d", new Object[] { Integer.valueOf(this.fgv.size()) });
        localLinkedList = new LinkedList();
        localIterator = this.fgv.iterator();
        while (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObject = new auq();
          ((auq)localObject).v = str;
          localLinkedList.add(localObject);
        }
        paramf.tfb = localLinkedList;
        paramf.tfa = localLinkedList.size();
      }
    }
    return a(parame, this.dmK, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    paramArrayOfByte = (ahm)this.dmK.ecF.ecN;
    ahl localahl = (ahl)this.dmK.ecE.ecN;
    if ((paramInt2 == 4) && (paramInt3 == -68))
    {
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramArrayOfByte.tFx.sAn.tFO, this);
      return;
    }
    if ((paramInt2 != 0) || (paramInt3 != 0))
    {
      y.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
    y.d("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  errType:" + paramInt2 + " errCode:" + paramInt3);
    paramq = bk.pm((String)com.tencent.mm.kernel.g.DP().Dz().get(65828, null));
    if ((localahl.kTS == 1) && (!bk.bl(paramArrayOfByte.sRE)) && (!paramArrayOfByte.sRE.equals(paramq)))
    {
      com.tencent.mm.kernel.g.DP().Dz().o(65828, paramArrayOfByte.sRE);
      ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).WJ();
    }
    if (paramArrayOfByte.kVS == null)
    {
      y.e("MicroMsg.NetSceneGetMFriend", "onGYNetEnd  friendlist null");
      return;
    }
    y.i("MicroMsg.NetSceneGetMFriend", "onGYNetEnd friend list size:%d", new Object[] { Integer.valueOf(paramArrayOfByte.kVS.size()) });
    long l = com.tencent.mm.kernel.g.DP().dKu.eV(Thread.currentThread().getId());
    paramInt1 = 0;
    aur localaur;
    a locala;
    g localg;
    label490:
    j localj;
    if (paramInt1 < paramArrayOfByte.kVS.size())
    {
      localaur = (aur)paramArrayOfByte.kVS.get(paramInt1);
      if (localaur == null) {
        y.e("MicroMsg.NetSceneGetMFriend", "Err getFriendList null");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        locala = ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pI(localaur.ffg);
        if ((locala == null) && (localahl.kTS != 1))
        {
          y.e("MicroMsg.NetSceneGetMFriend", "Err MD5 not found is AddrUploadStg, nickName: " + localaur.tqh + " md5: " + localaur.ffg);
        }
        else
        {
          com.tencent.mm.plugin.c.a.YT().Ga().gm(localaur.sxM, localaur.tac);
          localg = new g();
          if (localahl.kTS != 1) {
            break label955;
          }
          if (localaur.tqi != null) {
            break label490;
          }
          y.e("MicroMsg.NetSceneGetMFriend", "ERR: facebook friend return null info");
        }
      }
      localg.cCs = localaur.tqi.nGh;
      localg.ffB = localaur.tqi.sTI;
      com.tencent.mm.ag.b.jT(localaur.tqi.nGh);
      localg.ffA = localaur.tqi.kRZ;
      localg.cMT = localaur.ffm;
      localg.cCB = localaur.ffj;
      localg.cCA = localaur.ffi;
      localg.signature = localaur.ffk;
      localg.cCz = localaur.ffl;
      localg.sex = localaur.ffh;
      localg.aVr = localaur.tqh;
      localg.ffa = com.tencent.mm.platformtools.g.oZ(localaur.tqi.kRZ);
      localg.ffb = com.tencent.mm.platformtools.g.oY(localaur.tqi.kRZ);
      localg.username = localaur.sxM;
      label665:
      localj = new j();
      localj.username = localaur.sxM;
      localj.cCA = localaur.ffi;
      localj.cCB = localaur.ffj;
      localj.signature = localaur.ffk;
      localj.sex = localaur.ffh;
      localj.cCz = localaur.ffl;
      paramq = null;
      if (!bk.bl(localaur.sxM))
      {
        paramq = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(localaur.sxM);
        if ((paramq == null) || (!localaur.sxM.equals(paramq.field_username))) {
          break label977;
        }
        if ((bk.bl(localaur.ffm)) || (localaur.ffm.equals(paramq.vk()))) {
          break label1412;
        }
        paramq.cZ(localaur.ffm);
        ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().a(paramq.field_username, paramq);
      }
    }
    label1412:
    for (;;)
    {
      label859:
      boolean bool;
      if (bk.bl(localaur.sxM)) {
        if (localahl.kTS == 1)
        {
          bool = true;
          label882:
          Assert.assertTrue("mobile friend never go here", bool);
          localg.status = 102;
        }
      }
      for (;;)
      {
        if (localahl.kTS == 1) {
          ((h)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFacebookFrdStg()).a(localg);
        }
        ((k)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getFrdExtStg()).a(localj);
        break;
        label955:
        if (!bk.bl(localaur.sxM)) {
          break label665;
        }
        y.w("MicroMsg.NetSceneGetMFriend", "username null for mobile");
        break;
        label977:
        paramq = null;
        break label859;
        bool = false;
        break label882;
        if ((paramq == null) || (!com.tencent.mm.n.a.gR(paramq.field_type)))
        {
          localg.status = 100;
          if (locala != null)
          {
            y.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status on, nick:" + localaur.tqh + " realName:" + locala.Wx() + "  MFriend:" + localaur.toString());
            locala.status = 1;
            locala.username = localaur.sxM;
            locala.aVr = localaur.tqh;
            locala.ffa = com.tencent.mm.platformtools.g.oZ(localaur.tqi.kRZ);
            locala.ffb = com.tencent.mm.platformtools.g.oY(localaur.tqi.kRZ);
            locala.fff = locala.AE();
            a(locala, localaur);
            locala.bcw = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Wv(), locala);
            paramq = new com.tencent.mm.ag.h();
            paramq.username = localaur.sxM;
            paramq.ebT = localaur.sLD;
            paramq.ebS = localaur.sLE;
            paramq.bK(true);
            paramq.cCq = 3;
            o.Kh().a(paramq);
          }
        }
        else
        {
          localg.status = 101;
          if (locala != null)
          {
            y.v("MicroMsg.NetSceneGetMFriend", "onGYNetEnd update status friend, nick:" + localaur.tqh + "  md5:" + localaur.ffg);
            locala.status = 2;
            locala.username = localaur.sxM;
            locala.aVr = localaur.tqh;
            locala.fff = locala.AE();
            a(locala, localaur);
            locala.bcw = -1;
            ((b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).a(locala.Wv(), locala);
            com.tencent.mm.ag.b.M(localaur.sxM, 3);
          }
        }
      }
      com.tencent.mm.kernel.g.DP().dKu.hI(l);
      this.dmL.onSceneEnd(paramInt2, paramInt3, paramString, this);
      return;
    }
  }
  
  public final int getType()
  {
    return 32;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.ab
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ah.b.a;
import com.tencent.mm.ah.b.b;
import com.tencent.mm.ah.b.c;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ai.d;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.n.a;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.c.atz;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.protocal.c.hc;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends m
  implements com.tencent.mm.network.k
{
  private f dIJ = null;
  private com.tencent.mm.ah.b jvQ = null;
  private String[] jvR;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    this.jvR = paramArrayOfString;
    y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).ecH = new hc();
    ((b.a)localObject).ecI = new hd();
    ((b.a)localObject).ecG = 542;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((b.a)localObject).ecJ = 0;
    ((b.a)localObject).ecK = 0;
    this.jvQ = ((b.a)localObject).Kt();
    localObject = (hc)this.jvQ.ecE.ecN;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        hb localhb = new hb();
        localhb.sAE = str;
        localLinkedList.add(localhb);
        y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((hc)localObject).sAF = localLinkedList;
    if (!bk.bl(paramString))
    {
      paramArrayOfString = new ha();
      paramArrayOfString.sAD = paramString;
      ((hc)localObject).sAG = paramArrayOfString;
    }
    ((hc)localObject).sAH = 3;
  }
  
  public final int a(com.tencent.mm.network.e parame, f paramf)
  {
    this.dIJ = paramf;
    return a(parame, this.jvQ, this);
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, String paramString, com.tencent.mm.network.q paramq, byte[] paramArrayOfByte)
  {
    y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((this.jvR != null) && (this.jvR.length == 1)) {
      y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.jvR[0] });
    }
    if (paramq == null)
    {
      y.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      return;
    }
    if (this.jvQ.ecG != paramq.getType())
    {
      y.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.jvQ.ecG), Integer.valueOf(paramq.getType()) });
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = aLD().sAI.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (he)paramq.next();
        y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.sze), paramArrayOfByte.sAJ, paramArrayOfByte.sAE, paramArrayOfByte.hQc });
        if (paramArrayOfByte.sAK == null)
        {
          y.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.sAK;
          if (paramArrayOfByte == null)
          {
            y.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = aa.a(paramArrayOfByte.sQs);
            String str2 = bk.pm(paramArrayOfByte.ttu);
            if ((bk.bl(str1)) && (bk.bl(str2)))
            {
              y.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              au.Hx();
              ad localad1 = com.tencent.mm.model.c.Fw().abl(str1);
              if ((localad1 != null) && (str1.equals(localad1.field_encryptUsername)))
              {
                y.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                ad localad2 = new ad(str1);
                localad2.cZ(paramArrayOfByte.ffm);
                localad2.setType(paramArrayOfByte.sPr & paramArrayOfByte.sPs);
                label441:
                long l;
                if (!bk.bl(str2))
                {
                  localad2.dq(str2);
                  if (localad1 != null) {
                    break label1005;
                  }
                  l = 0L;
                  label449:
                  localad2.dBe = l;
                  localad2.dk(aa.a(paramArrayOfByte.tmw));
                  localad2.dl(aa.a(paramArrayOfByte.sQa));
                  localad2.dm(aa.a(paramArrayOfByte.sQb));
                  localad2.fm(paramArrayOfByte.ffh);
                  localad2.fp(paramArrayOfByte.sPx);
                  localad2.dg(aa.a(paramArrayOfByte.tto));
                  localad2.fq(paramArrayOfByte.sPB);
                  localad2.fr(paramArrayOfByte.ffl);
                  localad2.dF(RegionCodeDecoder.ao(paramArrayOfByte.ffq, paramArrayOfByte.ffi, paramArrayOfByte.ffj));
                  localad2.dz(paramArrayOfByte.ffk);
                  localad2.fi(paramArrayOfByte.tpg);
                  localad2.dE(paramArrayOfByte.tph);
                  localad2.setSource(paramArrayOfByte.swS);
                  localad2.fh(paramArrayOfByte.tpk);
                  localad2.dn(paramArrayOfByte.tpj);
                  if (s.ia(paramArrayOfByte.tpi)) {
                    localad2.dD(paramArrayOfByte.tpi);
                  }
                  localad2.ft((int)bk.UX());
                  localad2.df(aa.a(paramArrayOfByte.tsS));
                  localad2.jdMethod_do(aa.a(paramArrayOfByte.tsU));
                  localad2.dp(aa.a(paramArrayOfByte.tsT));
                  localad2.dG(paramArrayOfByte.sxZ);
                  localad2.dH(paramArrayOfByte.ttE);
                  if ((localad1 != null) && (!bk.pm(localad1.cCK).equals(bk.pm(paramArrayOfByte.ttE))))
                  {
                    com.tencent.mm.bb.c.PO();
                    com.tencent.mm.bb.c.mM(str1);
                  }
                  au.Hx();
                  com.tencent.mm.model.c.Fw().abq(str1);
                  if (!bk.bl(localad2.field_username)) {
                    break label1017;
                  }
                  y.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label791:
                  localad2.fk(paramArrayOfByte.ttD);
                  if ((paramArrayOfByte.ttz != null) && (paramArrayOfByte.ttz.svV != null))
                  {
                    localad2.dI(paramArrayOfByte.ttz.svV.sBf);
                    localad2.dJ(paramArrayOfByte.ttz.svV.sBg);
                    localad2.dK(paramArrayOfByte.ttz.svV.sBh);
                  }
                  if (s.hU(str1)) {
                    localad2.AQ();
                  }
                  if (localad2.cua()) {
                    localad2.AT();
                  }
                  if (bk.bl(str2)) {
                    break label1352;
                  }
                  au.Hx();
                  com.tencent.mm.model.c.Fw().b(str2, localad2);
                }
                for (;;)
                {
                  if ((localad1 == null) || ((localad1.field_type & 0x800) == (localad2.field_type & 0x800))) {
                    break label1368;
                  }
                  if ((localad2.field_type & 0x800) == 0) {
                    break label1370;
                  }
                  au.Hx();
                  com.tencent.mm.model.c.FB().abB(localad2.field_username);
                  break;
                  if ((localad1 == null) || ((int)localad1.dBe <= 0)) {
                    break label441;
                  }
                  localad2.dq(localad1.field_encryptUsername);
                  break label441;
                  label1005:
                  l = (int)localad1.dBe;
                  break label449;
                  label1017:
                  Object localObject1 = localad2.field_username;
                  Object localObject2 = com.tencent.mm.ag.b.a((String)localObject1, paramArrayOfByte);
                  o.Kh().a((h)localObject2);
                  localObject2 = paramArrayOfByte.tpm;
                  if ((!localad2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((but)localObject2).ffs + " " + paramArrayOfByte.sQs);
                    y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((but)localObject2).fft);
                    y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((but)localObject2).ffu);
                    y.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((but)localObject2).tLp);
                    if (n.omD != null) {
                      n.omD.a(localad2.field_username, (but)localObject2);
                    }
                  }
                  localObject2 = com.tencent.mm.model.q.Gj();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label791;
                  }
                  localObject2 = z.My().kQ((String)localObject1);
                  ((d)localObject2).field_username = ((String)localObject1);
                  ((d)localObject2).field_brandList = paramArrayOfByte.ffr;
                  localObject1 = paramArrayOfByte.tpn;
                  if (localObject1 != null)
                  {
                    ((d)localObject2).field_brandFlag = ((sg)localObject1).ffv;
                    ((d)localObject2).field_brandInfo = ((sg)localObject1).ffx;
                    ((d)localObject2).field_brandIconURL = ((sg)localObject1).ffy;
                    ((d)localObject2).field_extInfo = ((sg)localObject1).ffw;
                    ((d)localObject2).field_attrSyncVersion = null;
                    ((d)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!z.My().e((d)localObject2)) {
                    z.My().d((d)localObject2);
                  }
                  localad2.fu(((d)localObject2).field_type);
                  break label791;
                  label1352:
                  au.Hx();
                  com.tencent.mm.model.c.Fw().U(localad2);
                }
                label1368:
                continue;
                label1370:
                au.Hx();
                com.tencent.mm.model.c.FB().abC(localad2.field_username);
              }
            }
          }
        }
      }
    }
    this.dIJ.onSceneEnd(paramInt2, paramInt3, paramString, this);
  }
  
  public final hd aLD()
  {
    if ((this.jvQ != null) && (this.jvQ.ecF.ecN != null)) {
      return (hd)this.jvQ.ecF.ecN;
    }
    return null;
  }
  
  public final int getType()
  {
    return 542;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.am.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.bug;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.b grW;
  private com.tencent.mm.al.f gzH;
  private String[] qcR;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.grW = null;
    this.gzH = null;
    this.qcR = paramArrayOfString;
    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).hNM = new kl();
    ((b.a)localObject).hNN = new km();
    ((b.a)localObject).funcId = 542;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((b.a)localObject).hNO = 0;
    ((b.a)localObject).respCmdId = 0;
    this.grW = ((b.a)localObject).aDC();
    localObject = (kl)this.grW.hNK.hNQ;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        kk localkk = new kk();
        localkk.FCM = str;
        localLinkedList.add(localkk);
        ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((kl)localObject).FCN = localLinkedList;
    if (!bt.isNullOrNil(paramString))
    {
      paramArrayOfString = new kj();
      paramArrayOfString.FCL = paramString;
      ((kl)localObject).FCO = paramArrayOfString;
    }
    ((kl)localObject).FCP = 3;
    AppMethodBeat.o(23380);
  }
  
  public final km cll()
  {
    if ((this.grW != null) && (this.grW.hNL.hNQ != null)) {
      return (km)this.grW.hNL.hNQ;
    }
    return null;
  }
  
  public final int doScene(e parame, com.tencent.mm.al.f paramf)
  {
    AppMethodBeat.i(23382);
    this.gzH = paramf;
    int i = dispatch(parame, this.grW, this);
    AppMethodBeat.o(23382);
    return i;
  }
  
  public final int getType()
  {
    return 542;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23381);
    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((this.qcR != null) && (this.qcR.length == 1)) {
      ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.qcR[0] });
    }
    if (paramq == null)
    {
      ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.grW.getType() != paramq.getType())
    {
      ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.grW.getType()), Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = cll().FCQ.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (kn)paramq.next();
        ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Ret), paramArrayOfByte.FCR, paramArrayOfByte.FCM, paramArrayOfByte.nDs });
        if (paramArrayOfByte.FCS == null)
        {
          ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.FCS;
          if (paramArrayOfByte == null)
          {
            ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = z.a(paramArrayOfByte.GbY);
            String str2 = bt.nullAsNil(paramArrayOfByte.GUs);
            if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)))
            {
              ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              ba.aBQ();
              am localam1 = com.tencent.mm.model.c.azp().Bf(str1);
              if ((localam1 != null) && (str1.equals(localam1.field_encryptUsername)))
              {
                ad.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                am localam2 = new am(str1);
                localam2.sQ(paramArrayOfByte.jdh);
                localam2.setType(paramArrayOfByte.GaB & paramArrayOfByte.GaC);
                label460:
                long l;
                if (!bt.isNullOrNil(str2))
                {
                  localam2.sZ(str2);
                  if (localam1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localam2.gfj = l;
                  localam2.sT(z.a(paramArrayOfByte.GKC));
                  localam2.sU(z.a(paramArrayOfByte.Gbr));
                  localam2.sV(z.a(paramArrayOfByte.Gbs));
                  localam2.kf(paramArrayOfByte.jdc);
                  localam2.kh(paramArrayOfByte.GaH);
                  localam2.sS(z.a(paramArrayOfByte.GUm));
                  localam2.ki(paramArrayOfByte.GaL);
                  localam2.kj(paramArrayOfByte.jdg);
                  localam2.tq(RegionCodeDecoder.bf(paramArrayOfByte.jdl, paramArrayOfByte.jdd, paramArrayOfByte.jde));
                  localam2.tk(paramArrayOfByte.jdf);
                  localam2.kb(paramArrayOfByte.GNU);
                  localam2.tp(paramArrayOfByte.GNV);
                  localam2.setSource(paramArrayOfByte.tRT);
                  localam2.ka(paramArrayOfByte.GNY);
                  localam2.sW(paramArrayOfByte.GNX);
                  if (w.Av(paramArrayOfByte.GNW)) {
                    localam2.to(paramArrayOfByte.GNW);
                  }
                  localam2.kk((int)bt.aQJ());
                  localam2.sR(z.a(paramArrayOfByte.GTS));
                  localam2.sX(z.a(paramArrayOfByte.GTU));
                  localam2.sY(z.a(paramArrayOfByte.GTT));
                  localam2.tr(paramArrayOfByte.Fvh);
                  localam2.ts(paramArrayOfByte.GUB);
                  if ((localam1 != null) && (!bt.nullAsNil(localam1.ePE).equals(bt.nullAsNil(paramArrayOfByte.GUB))))
                  {
                    com.tencent.mm.be.c.aKd();
                    com.tencent.mm.be.c.Gf(str1);
                  }
                  ba.aBQ();
                  com.tencent.mm.model.c.azp().aTq(str1);
                  if (!bt.isNullOrNil(localam2.field_username)) {
                    break label1036;
                  }
                  ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localam2.kd(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.GUx != null) && (paramArrayOfByte.GUx.FvA != null))
                  {
                    localam2.tt(paramArrayOfByte.GUx.FvA.FDA);
                    localam2.tu(paramArrayOfByte.GUx.FvA.FDB);
                    localam2.tv(paramArrayOfByte.GUx.FvA.FDC);
                  }
                  if (w.Ap(str1)) {
                    localam2.acQ();
                  }
                  if (localam2.fqg()) {
                    localam2.acT();
                  }
                  if (bt.isNullOrNil(str2)) {
                    break label1371;
                  }
                  ba.aBQ();
                  com.tencent.mm.model.c.azp().d(str2, localam2);
                }
                for (;;)
                {
                  if ((localam1 == null) || ((localam1.field_type & 0x800) == (localam2.field_type & 0x800))) {
                    break label1387;
                  }
                  if ((localam2.field_type & 0x800) == 0) {
                    break label1389;
                  }
                  ba.aBQ();
                  com.tencent.mm.model.c.azv().aTF(localam2.field_username);
                  break;
                  if ((localam1 == null) || ((int)localam1.gfj <= 0)) {
                    break label460;
                  }
                  localam2.sZ(localam1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localam1.gfj;
                  break label468;
                  label1036:
                  Object localObject1 = localam2.field_username;
                  Object localObject2 = com.tencent.mm.ak.c.a((String)localObject1, paramArrayOfByte);
                  p.aEx().b((i)localObject2);
                  localObject2 = paramArrayOfByte.GOa;
                  if ((!localam2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((dhg)localObject2).jdn + " " + paramArrayOfByte.GbY);
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((dhg)localObject2).jdo);
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((dhg)localObject2).jdp);
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((dhg)localObject2).HvJ);
                    if (o.zbT != null) {
                      o.zbT.a(localam2.field_username, (dhg)localObject2);
                    }
                  }
                  localObject2 = u.aAm();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = ag.aFZ().DD((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.jdm;
                  localObject1 = paramArrayOfByte.GOb;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((acf)localObject1).jdq;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((acf)localObject1).jds;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((acf)localObject1).jdt;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((acf)localObject1).jdr;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!ag.aFZ().g((com.tencent.mm.api.c)localObject2)) {
                    ag.aFZ().f((com.tencent.mm.api.c)localObject2);
                  }
                  localam2.kl(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1371:
                  ba.aBQ();
                  com.tencent.mm.model.c.azp().af(localam2);
                }
                label1387:
                continue;
                label1389:
                ba.aBQ();
                com.tencent.mm.model.c.azv().aTG(localam2.field_username);
              }
            }
          }
        }
      }
    }
    this.gzH.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
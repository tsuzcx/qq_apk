package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.al.n;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.c.f;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.protocal.protobuf.blv;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.de;
import com.tencent.mm.protocal.protobuf.ju;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.protocal.protobuf.jw;
import com.tencent.mm.protocal.protobuf.jx;
import com.tencent.mm.protocal.protobuf.jy;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.al.b fUF;
  private g gbr;
  private String[] oWb;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.fUF = null;
    this.gbr = null;
    this.oWb = paramArrayOfString;
    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).gUU = new jw();
    ((b.a)localObject).gUV = new jx();
    ((b.a)localObject).funcId = 542;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fUF = ((b.a)localObject).atI();
    localObject = (jw)this.fUF.gUS.gUX;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        jv localjv = new jv();
        localjv.CEQ = str;
        localLinkedList.add(localjv);
        ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((jw)localObject).CER = localLinkedList;
    if (!bt.isNullOrNil(paramString))
    {
      paramArrayOfString = new ju();
      paramArrayOfString.CEP = paramString;
      ((jw)localObject).CES = paramArrayOfString;
    }
    ((jw)localObject).CET = 3;
    AppMethodBeat.o(23380);
  }
  
  public final jx bZy()
  {
    if ((this.fUF != null) && (this.fUF.gUT.gUX != null)) {
      return (jx)this.fUF.gUT.gUX;
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(23382);
    this.gbr = paramg;
    int i = dispatch(parame, this.fUF, this);
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
    if ((this.oWb != null) && (this.oWb.length == 1)) {
      ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.oWb[0] });
    }
    if (paramq == null)
    {
      ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.fUF.getType() != paramq.getType())
    {
      ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.fUF.getType()), Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = bZy().CEU.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (jy)paramq.next();
        ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Ret), paramArrayOfByte.CEV, paramArrayOfByte.CEQ, paramArrayOfByte.mAU });
        if (paramArrayOfByte.CEW == null)
        {
          ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.CEW;
          if (paramArrayOfByte == null)
          {
            ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = z.a(paramArrayOfByte.Dby);
            String str2 = bt.nullAsNil(paramArrayOfByte.DOt);
            if ((bt.isNullOrNil(str1)) && (bt.isNullOrNil(str2)))
            {
              ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              az.arV();
              com.tencent.mm.storage.af localaf1 = com.tencent.mm.model.c.apM().aHY(str1);
              if ((localaf1 != null) && (str1.equals(localaf1.field_encryptUsername)))
              {
                ad.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                com.tencent.mm.storage.af localaf2 = new com.tencent.mm.storage.af(str1);
                localaf2.na(paramArrayOfByte.ijR);
                localaf2.setType(paramArrayOfByte.Dan & paramArrayOfByte.Dao);
                label460:
                long l;
                if (!bt.isNullOrNil(str2))
                {
                  localaf2.nj(str2);
                  if (localaf1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localaf2.fId = l;
                  localaf2.nd(z.a(paramArrayOfByte.DFJ));
                  localaf2.ne(z.a(paramArrayOfByte.Dbb));
                  localaf2.nf(z.a(paramArrayOfByte.Dbc));
                  localaf2.jJ(paramArrayOfByte.ijM);
                  localaf2.jL(paramArrayOfByte.Dat);
                  localaf2.nc(z.a(paramArrayOfByte.DOn));
                  localaf2.jM(paramArrayOfByte.Dax);
                  localaf2.jN(paramArrayOfByte.ijQ);
                  localaf2.nA(RegionCodeDecoder.aT(paramArrayOfByte.ijV, paramArrayOfByte.ijN, paramArrayOfByte.ijO));
                  localaf2.nu(paramArrayOfByte.ijP);
                  localaf2.jF(paramArrayOfByte.DIV);
                  localaf2.nz(paramArrayOfByte.DIW);
                  localaf2.setSource(paramArrayOfByte.rNz);
                  localaf2.jE(paramArrayOfByte.DIZ);
                  localaf2.ng(paramArrayOfByte.DIY);
                  if (w.tu(paramArrayOfByte.DIX)) {
                    localaf2.ny(paramArrayOfByte.DIX);
                  }
                  localaf2.jO((int)bt.aGK());
                  localaf2.nb(z.a(paramArrayOfByte.DNT));
                  localaf2.nh(z.a(paramArrayOfByte.DNV));
                  localaf2.ni(z.a(paramArrayOfByte.DNU));
                  localaf2.nB(paramArrayOfByte.Cxw);
                  localaf2.nC(paramArrayOfByte.DOC);
                  if ((localaf1 != null) && (!bt.nullAsNil(localaf1.evJ).equals(bt.nullAsNil(paramArrayOfByte.DOC))))
                  {
                    com.tencent.mm.be.c.aAc();
                    com.tencent.mm.be.c.yV(str1);
                  }
                  az.arV();
                  com.tencent.mm.model.c.apM().aIe(str1);
                  if (!bt.isNullOrNil(localaf2.field_username)) {
                    break label1036;
                  }
                  ad.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localaf2.jH(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.DOy != null) && (paramArrayOfByte.DOy.CxP != null))
                  {
                    localaf2.nD(paramArrayOfByte.DOy.CxP.CFE);
                    localaf2.nE(paramArrayOfByte.DOy.CxP.CFF);
                    localaf2.nF(paramArrayOfByte.DOy.CxP.CFG);
                  }
                  if (w.to(str1)) {
                    localaf2.Zt();
                  }
                  if (localaf2.eKB()) {
                    localaf2.Zw();
                  }
                  if (bt.isNullOrNil(str2)) {
                    break label1371;
                  }
                  az.arV();
                  com.tencent.mm.model.c.apM().d(str2, localaf2);
                }
                for (;;)
                {
                  if ((localaf1 == null) || ((localaf1.field_type & 0x800) == (localaf2.field_type & 0x800))) {
                    break label1387;
                  }
                  if ((localaf2.field_type & 0x800) == 0) {
                    break label1389;
                  }
                  az.arV();
                  com.tencent.mm.model.c.apR().aIt(localaf2.field_username);
                  break;
                  if ((localaf1 == null) || ((int)localaf1.fId <= 0)) {
                    break label460;
                  }
                  localaf2.nj(localaf1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localaf1.fId;
                  break label468;
                  label1036:
                  Object localObject1 = localaf2.field_username;
                  Object localObject2 = com.tencent.mm.ak.c.a((String)localObject1, paramArrayOfByte);
                  p.auF().b((i)localObject2);
                  localObject2 = paramArrayOfByte.DJb;
                  if ((!localaf2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((cwh)localObject2).ijX + " " + paramArrayOfByte.Dby);
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((cwh)localObject2).ijY);
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((cwh)localObject2).ijZ);
                    ad.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((cwh)localObject2).Eoc);
                    if (o.wzH != null) {
                      o.wzH.a(localaf2.field_username, (cwh)localObject2);
                    }
                  }
                  localObject2 = u.aqG();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = com.tencent.mm.am.af.awe().wy((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.ijW;
                  localObject1 = paramArrayOfByte.DJc;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((zh)localObject1).ika;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((zh)localObject1).ikc;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((zh)localObject1).ikd;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((zh)localObject1).ikb;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!com.tencent.mm.am.af.awe().g((com.tencent.mm.api.c)localObject2)) {
                    com.tencent.mm.am.af.awe().f((com.tencent.mm.api.c)localObject2);
                  }
                  localaf2.jP(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1371:
                  az.arV();
                  com.tencent.mm.model.c.apM().ae(localaf2);
                }
                label1387:
                continue;
                label1389:
                az.arV();
                com.tencent.mm.model.c.apR().aIu(localaf2.field_username);
              }
            }
          }
        }
      }
    }
    this.gbr.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
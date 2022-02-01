package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.dh;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.kj;
import com.tencent.mm.protocal.protobuf.kk;
import com.tencent.mm.protocal.protobuf.kl;
import com.tencent.mm.protocal.protobuf.km;
import com.tencent.mm.protocal.protobuf.kn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.f gCo;
  private b gux;
  private String[] qjw;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.gux = null;
    this.gCo = null;
    this.qjw = paramArrayOfString;
    ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).hQF = new kl();
    ((b.a)localObject).hQG = new km();
    ((b.a)localObject).funcId = 542;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((b.a)localObject).hQH = 0;
    ((b.a)localObject).respCmdId = 0;
    this.gux = ((b.a)localObject).aDS();
    localObject = (kl)this.gux.hQD.hQJ;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        kk localkk = new kk();
        localkk.FVh = str;
        localLinkedList.add(localkk);
        ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((kl)localObject).FVi = localLinkedList;
    if (!bu.isNullOrNil(paramString))
    {
      paramArrayOfString = new kj();
      paramArrayOfString.FVg = paramString;
      ((kl)localObject).FVj = paramArrayOfString;
    }
    ((kl)localObject).FVk = 3;
    AppMethodBeat.o(23380);
  }
  
  public final km cmB()
  {
    if ((this.gux != null) && (this.gux.hQE.hQJ != null)) {
      return (km)this.gux.hQE.hQJ;
    }
    return null;
  }
  
  public final int doScene(e parame, com.tencent.mm.ak.f paramf)
  {
    AppMethodBeat.i(23382);
    this.gCo = paramf;
    int i = dispatch(parame, this.gux, this);
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
    ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((this.qjw != null) && (this.qjw.length == 1)) {
      ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.qjw[0] });
    }
    if (paramq == null)
    {
      ae.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.gux.getType() != paramq.getType())
    {
      ae.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.gux.getType()), Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = cmB().FVl.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (kn)paramq.next();
        ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Ret), paramArrayOfByte.FVm, paramArrayOfByte.FVh, paramArrayOfByte.nIN });
        if (paramArrayOfByte.FVn == null)
        {
          ae.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.FVn;
          if (paramArrayOfByte == null)
          {
            ae.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = z.a(paramArrayOfByte.GuF);
            String str2 = bu.nullAsNil(paramArrayOfByte.HnT);
            if ((bu.isNullOrNil(str1)) && (bu.isNullOrNil(str2)))
            {
              ae.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              bc.aCg();
              an localan1 = com.tencent.mm.model.c.azF().BH(str1);
              if ((localan1 != null) && (str1.equals(localan1.field_encryptUsername)))
              {
                ae.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                an localan2 = new an(str1);
                localan2.tl(paramArrayOfByte.jga);
                localan2.setType(paramArrayOfByte.Gti & paramArrayOfByte.Gtj);
                label460:
                long l;
                if (!bu.isNullOrNil(str2))
                {
                  localan2.tu(str2);
                  if (localan1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localan2.ght = l;
                  localan2.to(z.a(paramArrayOfByte.Hed));
                  localan2.tp(z.a(paramArrayOfByte.GtY));
                  localan2.tq(z.a(paramArrayOfByte.GtZ));
                  localan2.kh(paramArrayOfByte.jfV);
                  localan2.kj(paramArrayOfByte.Gto);
                  localan2.tn(z.a(paramArrayOfByte.HnN));
                  localan2.kk(paramArrayOfByte.Gts);
                  localan2.kl(paramArrayOfByte.jfZ);
                  localan2.tL(RegionCodeDecoder.bg(paramArrayOfByte.jge, paramArrayOfByte.jfW, paramArrayOfByte.jfX));
                  localan2.tF(paramArrayOfByte.jfY);
                  localan2.kd(paramArrayOfByte.Hhu);
                  localan2.tK(paramArrayOfByte.Hhv);
                  localan2.setSource(paramArrayOfByte.ucK);
                  localan2.kc(paramArrayOfByte.Hhy);
                  localan2.tr(paramArrayOfByte.Hhx);
                  if (x.Bf(paramArrayOfByte.Hhw)) {
                    localan2.tJ(paramArrayOfByte.Hhw);
                  }
                  localan2.km((int)bu.aRi());
                  localan2.tm(z.a(paramArrayOfByte.Hnt));
                  localan2.ts(z.a(paramArrayOfByte.Hnv));
                  localan2.tt(z.a(paramArrayOfByte.Hnu));
                  localan2.tM(paramArrayOfByte.FNF);
                  localan2.tN(paramArrayOfByte.Hoc);
                  if ((localan1 != null) && (!bu.nullAsNil(localan1.eRp).equals(bu.nullAsNil(paramArrayOfByte.Hoc))))
                  {
                    com.tencent.mm.bd.c.aKw();
                    com.tencent.mm.bd.c.GH(str1);
                  }
                  bc.aCg();
                  com.tencent.mm.model.c.azF().aUR(str1);
                  if (!bu.isNullOrNil(localan2.field_username)) {
                    break label1036;
                  }
                  ae.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localan2.kf(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.HnY != null) && (paramArrayOfByte.HnY.FNY != null))
                  {
                    localan2.tO(paramArrayOfByte.HnY.FNY.FVV);
                    localan2.tP(paramArrayOfByte.HnY.FNY.FVW);
                    localan2.tQ(paramArrayOfByte.HnY.FNY.FVX);
                  }
                  if (x.AZ(str1)) {
                    localan2.adb();
                  }
                  if (localan2.fug()) {
                    localan2.adf();
                  }
                  if (bu.isNullOrNil(str2)) {
                    break label1371;
                  }
                  bc.aCg();
                  com.tencent.mm.model.c.azF().d(str2, localan2);
                }
                for (;;)
                {
                  if ((localan1 == null) || ((localan1.field_type & 0x800) == (localan2.field_type & 0x800))) {
                    break label1387;
                  }
                  if ((localan2.field_type & 0x800) == 0) {
                    break label1389;
                  }
                  bc.aCg();
                  com.tencent.mm.model.c.azL().aVg(localan2.field_username);
                  break;
                  if ((localan1 == null) || ((int)localan1.ght <= 0)) {
                    break label460;
                  }
                  localan2.tu(localan1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localan1.ght;
                  break label468;
                  label1036:
                  Object localObject1 = localan2.field_username;
                  Object localObject2 = com.tencent.mm.aj.c.a((String)localObject1, paramArrayOfByte);
                  p.aEN().b((i)localObject2);
                  localObject2 = paramArrayOfByte.HhA;
                  if ((!localan2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((dia)localObject2).jgg + " " + paramArrayOfByte.GuF);
                    ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((dia)localObject2).jgh);
                    ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((dia)localObject2).jgi);
                    ae.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((dia)localObject2).HPm);
                    if (o.zsw != null) {
                      o.zsw.a(localan2.field_username, (dia)localObject2);
                    }
                  }
                  localObject2 = v.aAC();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = ag.aGp().Ef((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.jgf;
                  localObject1 = paramArrayOfByte.HhB;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((aco)localObject1).jgj;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((aco)localObject1).jgl;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((aco)localObject1).jgm;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((aco)localObject1).jgk;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!ag.aGp().g((com.tencent.mm.api.c)localObject2)) {
                    ag.aGp().f((com.tencent.mm.api.c)localObject2);
                  }
                  localan2.kn(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1371:
                  bc.aCg();
                  com.tencent.mm.model.c.azF().am(localan2);
                }
                label1387:
                continue;
                label1389:
                bc.aCg();
                com.tencent.mm.model.c.azL().aVh(localan2.field_username);
              }
            }
          }
        }
      }
    }
    this.gCo.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
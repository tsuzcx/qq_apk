package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.sns.b.f;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.bpt;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.dg;
import com.tencent.mm.protocal.protobuf.ka;
import com.tencent.mm.protocal.protobuf.kb;
import com.tencent.mm.protocal.protobuf.kc;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ke;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends n
  implements com.tencent.mm.network.k
{
  private com.tencent.mm.ak.b fYA;
  private g gfX;
  private String[] pzm;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.fYA = null;
    this.gfX = null;
    this.pzm = paramArrayOfString;
    ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).hvt = new kc();
    ((b.a)localObject).hvu = new kd();
    ((b.a)localObject).funcId = 542;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.fYA = ((b.a)localObject).aAz();
    localObject = (kc)this.fYA.hvr.hvw;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        kb localkb = new kb();
        localkb.DXq = str;
        localLinkedList.add(localkb);
        ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((kc)localObject).DXr = localLinkedList;
    if (!bs.isNullOrNil(paramString))
    {
      paramArrayOfString = new ka();
      paramArrayOfString.DXp = paramString;
      ((kc)localObject).DXs = paramArrayOfString;
    }
    ((kc)localObject).DXt = 3;
    AppMethodBeat.o(23380);
  }
  
  public final kd cgH()
  {
    if ((this.fYA != null) && (this.fYA.hvs.hvw != null)) {
      return (kd)this.fYA.hvs.hvw;
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, g paramg)
  {
    AppMethodBeat.i(23382);
    this.gfX = paramg;
    int i = dispatch(parame, this.fYA, this);
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
    ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((this.pzm != null) && (this.pzm.length == 1)) {
      ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.pzm[0] });
    }
    if (paramq == null)
    {
      ac.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.fYA.getType() != paramq.getType())
    {
      ac.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.fYA.getType()), Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = cgH().DXu.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (ke)paramq.next();
        ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Ret), paramArrayOfByte.DXv, paramArrayOfByte.DXq, paramArrayOfByte.ncV });
        if (paramArrayOfByte.DXw == null)
        {
          ac.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.DXw;
          if (paramArrayOfByte == null)
          {
            ac.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = z.a(paramArrayOfByte.EuE);
            String str2 = bs.nullAsNil(paramArrayOfByte.FkK);
            if ((bs.isNullOrNil(str1)) && (bs.isNullOrNil(str2)))
            {
              ac.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              az.ayM();
              ai localai1 = com.tencent.mm.model.c.awB().aNt(str1);
              if ((localai1 != null) && (str1.equals(localai1.field_encryptUsername)))
              {
                ac.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                ai localai2 = new ai(str1);
                localai2.qg(paramArrayOfByte.iJY);
                localai2.setType(paramArrayOfByte.Etk & paramArrayOfByte.Etl);
                label460:
                long l;
                if (!bs.isNullOrNil(str2))
                {
                  localai2.qp(str2);
                  if (localai1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localai2.fLJ = l;
                  localai2.qj(z.a(paramArrayOfByte.Fbd));
                  localai2.qk(z.a(paramArrayOfByte.EtY));
                  localai2.ql(z.a(paramArrayOfByte.EtZ));
                  localai2.jH(paramArrayOfByte.iJT);
                  localai2.jJ(paramArrayOfByte.Etq);
                  localai2.qi(z.a(paramArrayOfByte.FkE));
                  localai2.jK(paramArrayOfByte.Etu);
                  localai2.jL(paramArrayOfByte.iJX);
                  localai2.qG(RegionCodeDecoder.aW(paramArrayOfByte.iKc, paramArrayOfByte.iJU, paramArrayOfByte.iJV));
                  localai2.qA(paramArrayOfByte.iJW);
                  localai2.jD(paramArrayOfByte.Feq);
                  localai2.qF(paramArrayOfByte.Fer);
                  localai2.setSource(paramArrayOfByte.sVo);
                  localai2.jC(paramArrayOfByte.Feu);
                  localai2.qm(paramArrayOfByte.Fet);
                  if (w.xx(paramArrayOfByte.Fes)) {
                    localai2.qE(paramArrayOfByte.Fes);
                  }
                  localai2.jM((int)bs.aNx());
                  localai2.qh(z.a(paramArrayOfByte.Fkk));
                  localai2.qn(z.a(paramArrayOfByte.Fkm));
                  localai2.qo(z.a(paramArrayOfByte.Fkl));
                  localai2.qH(paramArrayOfByte.DPS);
                  localai2.qI(paramArrayOfByte.FkT);
                  if ((localai1 != null) && (!bs.nullAsNil(localai1.eyg).equals(bs.nullAsNil(paramArrayOfByte.FkT))))
                  {
                    com.tencent.mm.bd.c.aGS();
                    com.tencent.mm.bd.c.Da(str1);
                  }
                  az.ayM();
                  com.tencent.mm.model.c.awB().aNz(str1);
                  if (!bs.isNullOrNil(localai2.field_username)) {
                    break label1036;
                  }
                  ac.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localai2.jF(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.FkP != null) && (paramArrayOfByte.FkP.DQl != null))
                  {
                    localai2.qJ(paramArrayOfByte.FkP.DQl.DYe);
                    localai2.qK(paramArrayOfByte.FkP.DQl.DYf);
                    localai2.qL(paramArrayOfByte.FkP.DQl.DYg);
                  }
                  if (w.xr(str1)) {
                    localai2.aao();
                  }
                  if (localai2.fad()) {
                    localai2.aar();
                  }
                  if (bs.isNullOrNil(str2)) {
                    break label1371;
                  }
                  az.ayM();
                  com.tencent.mm.model.c.awB().d(str2, localai2);
                }
                for (;;)
                {
                  if ((localai1 == null) || ((localai1.field_type & 0x800) == (localai2.field_type & 0x800))) {
                    break label1387;
                  }
                  if ((localai2.field_type & 0x800) == 0) {
                    break label1389;
                  }
                  az.ayM();
                  com.tencent.mm.model.c.awG().aNO(localai2.field_username);
                  break;
                  if ((localai1 == null) || ((int)localai1.fLJ <= 0)) {
                    break label460;
                  }
                  localai2.qp(localai1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localai1.fLJ;
                  break label468;
                  label1036:
                  Object localObject1 = localai2.field_username;
                  Object localObject2 = com.tencent.mm.aj.c.a((String)localObject1, paramArrayOfByte);
                  p.aBw().b((i)localObject2);
                  localObject2 = paramArrayOfByte.Few;
                  if ((!localai2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((dbt)localObject2).iKe + " " + paramArrayOfByte.EuE);
                    ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((dbt)localObject2).iKf);
                    ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((dbt)localObject2).iKg);
                    ac.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((dbt)localObject2).FLb);
                    if (o.xMb != null) {
                      o.xMb.a(localai2.field_username, (dbt)localObject2);
                    }
                  }
                  localObject2 = u.axw();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = af.aCW().AE((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.iKd;
                  localObject1 = paramArrayOfByte.Fex;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((aaf)localObject1).iKh;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((aaf)localObject1).iKj;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((aaf)localObject1).iKk;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((aaf)localObject1).iKi;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!af.aCW().g((com.tencent.mm.api.c)localObject2)) {
                    af.aCW().f((com.tencent.mm.api.c)localObject2);
                  }
                  localai2.jN(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1371:
                  az.ayM();
                  com.tencent.mm.model.c.awB().af(localai2);
                }
                label1387:
                continue;
                label1389:
                az.ayM();
                com.tencent.mm.model.c.awG().aNP(localai2.field_username);
              }
            }
          }
        }
      }
    }
    this.gfX.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
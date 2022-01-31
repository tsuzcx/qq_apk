package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.b.a;
import com.tencent.mm.ai.b.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.aj.d;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.n.a;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.protocal.protobuf.baf;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cw;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.protocal.protobuf.is;
import com.tencent.mm.protocal.protobuf.it;
import com.tencent.mm.protocal.protobuf.iu;
import com.tencent.mm.protocal.protobuf.iv;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private f eGj;
  private com.tencent.mm.ai.b lFp;
  private String[] lFq;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(19311);
    this.lFp = null;
    this.eGj = null;
    this.lFq = paramArrayOfString;
    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new b.a();
    ((b.a)localObject).fsX = new it();
    ((b.a)localObject).fsY = new iu();
    ((b.a)localObject).funcId = 542;
    ((b.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((b.a)localObject).reqCmdId = 0;
    ((b.a)localObject).respCmdId = 0;
    this.lFp = ((b.a)localObject).ado();
    localObject = (it)this.lFp.fsV.fta;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        is localis = new is();
        localis.wuT = str;
        localLinkedList.add(localis);
        ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((it)localObject).wuU = localLinkedList;
    if (!bo.isNullOrNil(paramString))
    {
      paramArrayOfString = new ir();
      paramArrayOfString.wuS = paramString;
      ((it)localObject).wuV = paramArrayOfString;
    }
    ((it)localObject).wuW = 3;
    AppMethodBeat.o(19311);
  }
  
  public final iu bpQ()
  {
    if ((this.lFp != null) && (this.lFp.fsW.fta != null)) {
      return (iu)this.lFp.fsW.fta;
    }
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.e parame, f paramf)
  {
    AppMethodBeat.i(19313);
    this.eGj = paramf;
    int i = dispatch(parame, this.lFp, this);
    AppMethodBeat.o(19313);
    return i;
  }
  
  public final int getType()
  {
    return 542;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, q paramq, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(19312);
    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((this.lFq != null) && (this.lFq.length == 1)) {
      ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.lFq[0] });
    }
    if (paramq == null)
    {
      ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(19312);
      return;
    }
    if (this.lFp.getType() != paramq.getType())
    {
      ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.lFp.getType()), Integer.valueOf(paramq.getType()) });
      AppMethodBeat.o(19312);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      paramq = bpQ().wuX.iterator();
      while (paramq.hasNext())
      {
        paramArrayOfByte = (iv)paramq.next();
        ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Ret), paramArrayOfByte.wuY, paramArrayOfByte.wuT, paramArrayOfByte.jJE });
        if (paramArrayOfByte.wuZ == null)
        {
          ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.wuZ;
          if (paramArrayOfByte == null)
          {
            ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = aa.a(paramArrayOfByte.wOT);
            String str2 = bo.nullAsNil(paramArrayOfByte.xtu);
            if ((bo.isNullOrNil(str1)) && (bo.isNullOrNil(str2)))
            {
              ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              aw.aaz();
              ad localad1 = com.tencent.mm.model.c.YA().arw(str1);
              if ((localad1 != null) && (str1.equals(localad1.field_encryptUsername)))
              {
                ab.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                ad localad2 = new ad(str1);
                localad2.jm(paramArrayOfByte.gwU);
                localad2.setType(paramArrayOfByte.wNK & paramArrayOfByte.wNL);
                label460:
                long l;
                if (!bo.isNullOrNil(str2))
                {
                  localad2.jv(str2);
                  if (localad1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localad2.euF = l;
                  localad2.jp(aa.a(paramArrayOfByte.xmi));
                  localad2.jq(aa.a(paramArrayOfByte.wOv));
                  localad2.jr(aa.a(paramArrayOfByte.wOw));
                  localad2.hy(paramArrayOfByte.gwP);
                  localad2.hA(paramArrayOfByte.wNQ);
                  localad2.jo(aa.a(paramArrayOfByte.xto));
                  localad2.hB(paramArrayOfByte.wNU);
                  localad2.hC(paramArrayOfByte.gwT);
                  localad2.jL(RegionCodeDecoder.aF(paramArrayOfByte.gwY, paramArrayOfByte.gwQ, paramArrayOfByte.gwR));
                  localad2.jF(paramArrayOfByte.gwS);
                  localad2.hu(paramArrayOfByte.xpe);
                  localad2.jK(paramArrayOfByte.xpf);
                  localad2.setSource(paramArrayOfByte.niK);
                  localad2.ht(paramArrayOfByte.xpi);
                  localad2.js(paramArrayOfByte.xph);
                  if (t.oJ(paramArrayOfByte.xpg)) {
                    localad2.jJ(paramArrayOfByte.xpg);
                  }
                  localad2.hE((int)bo.aox());
                  localad2.jn(aa.a(paramArrayOfByte.xsT));
                  localad2.jt(aa.a(paramArrayOfByte.xsV));
                  localad2.ju(aa.a(paramArrayOfByte.xsU));
                  localad2.jM(paramArrayOfByte.woO);
                  localad2.jN(paramArrayOfByte.xtD);
                  if ((localad1 != null) && (!bo.nullAsNil(localad1.dqU).equals(bo.nullAsNil(paramArrayOfByte.xtD))))
                  {
                    com.tencent.mm.bc.c.aiT();
                    com.tencent.mm.bc.c.tW(str1);
                  }
                  aw.aaz();
                  com.tencent.mm.model.c.YA().arB(str1);
                  if (!bo.isNullOrNil(localad2.field_username)) {
                    break label1036;
                  }
                  ab.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localad2.hw(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.xtz != null) && (paramArrayOfByte.xtz.wpi != null))
                  {
                    localad2.jO(paramArrayOfByte.xtz.wpi.wvz);
                    localad2.jP(paramArrayOfByte.xtz.wpi.wvA);
                    localad2.jQ(paramArrayOfByte.xtz.wpi.wvB);
                  }
                  if (t.oD(str1)) {
                    localad2.NG();
                  }
                  if (localad2.dwz()) {
                    localad2.NJ();
                  }
                  if (bo.isNullOrNil(str2)) {
                    break label1371;
                  }
                  aw.aaz();
                  com.tencent.mm.model.c.YA().c(str2, localad2);
                }
                for (;;)
                {
                  if ((localad1 == null) || ((localad1.field_type & 0x800) == (localad2.field_type & 0x800))) {
                    break label1387;
                  }
                  if ((localad2.field_type & 0x800) == 0) {
                    break label1389;
                  }
                  aw.aaz();
                  com.tencent.mm.model.c.YF().arN(localad2.field_username);
                  break;
                  if ((localad1 == null) || ((int)localad1.euF <= 0)) {
                    break label460;
                  }
                  localad2.jv(localad1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localad1.euF;
                  break label468;
                  label1036:
                  Object localObject1 = localad2.field_username;
                  Object localObject2 = com.tencent.mm.ah.b.a((String)localObject1, paramArrayOfByte);
                  o.adg().b((h)localObject2);
                  localObject2 = paramArrayOfByte.xpk;
                  if ((!localad2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((cfj)localObject2).gxa + " " + paramArrayOfByte.wOT);
                    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((cfj)localObject2).gxb);
                    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((cfj)localObject2).gxc);
                    ab.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((cfj)localObject2).xPN);
                    if (n.raR != null) {
                      n.raR.a(localad2.field_username, (cfj)localObject2);
                    }
                  }
                  localObject2 = r.Zn();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = z.afi().rK((String)localObject1);
                  ((d)localObject2).field_username = ((String)localObject1);
                  ((d)localObject2).field_brandList = paramArrayOfByte.gwZ;
                  localObject1 = paramArrayOfByte.xpl;
                  if (localObject1 != null)
                  {
                    ((d)localObject2).field_brandFlag = ((wc)localObject1).gxd;
                    ((d)localObject2).field_brandInfo = ((wc)localObject1).gxf;
                    ((d)localObject2).field_brandIconURL = ((wc)localObject1).gxg;
                    ((d)localObject2).field_extInfo = ((wc)localObject1).gxe;
                    ((d)localObject2).field_attrSyncVersion = null;
                    ((d)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!z.afi().e((d)localObject2)) {
                    z.afi().d((d)localObject2);
                  }
                  localad2.hF(((d)localObject2).field_type);
                  break label810;
                  label1371:
                  aw.aaz();
                  com.tencent.mm.model.c.YA().X(localad2);
                }
                label1387:
                continue;
                label1389:
                aw.aaz();
                com.tencent.mm.model.c.YF().arO(localad2.field_username);
              }
            }
          }
        }
      }
    }
    this.eGj.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(19312);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
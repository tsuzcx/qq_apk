package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.f;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.crd;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.do;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.kq;
import com.tencent.mm.protocal.protobuf.kr;
import com.tencent.mm.protocal.protobuf.ks;
import com.tencent.mm.protocal.protobuf.kt;
import com.tencent.mm.protocal.protobuf.ku;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends com.tencent.mm.an.q
  implements m
{
  private i jQg;
  private com.tencent.mm.an.d jTk;
  private String[] vfY;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.jTk = null;
    this.jQg = null;
    this.vfY = paramArrayOfString;
    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new d.a();
    ((d.a)localObject).lBU = new ks();
    ((d.a)localObject).lBV = new kt();
    ((d.a)localObject).funcId = 542;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((d.a)localObject).lBW = 0;
    ((d.a)localObject).respCmdId = 0;
    this.jTk = ((d.a)localObject).bgN();
    localObject = (ks)d.b.b(this.jTk.lBR);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        kr localkr = new kr();
        localkr.RPQ = str;
        localLinkedList.add(localkr);
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((ks)localObject).RPR = localLinkedList;
    if (!Util.isNullOrNil(paramString))
    {
      paramArrayOfString = new kq();
      paramArrayOfString.RPP = paramString;
      ((ks)localObject).RPS = paramArrayOfString;
    }
    ((ks)localObject).RPT = 3;
    AppMethodBeat.o(23380);
  }
  
  public final kt cZp()
  {
    AppMethodBeat.i(289479);
    if ((this.jTk != null) && (d.c.b(this.jTk.lBS) != null))
    {
      kt localkt = (kt)d.c.b(this.jTk.lBS);
      AppMethodBeat.o(289479);
      return localkt;
    }
    AppMethodBeat.o(289479);
    return null;
  }
  
  public final int doScene(com.tencent.mm.network.g paramg, i parami)
  {
    AppMethodBeat.i(23382);
    this.jQg = parami;
    int i = dispatch(paramg, this.jTk, this);
    AppMethodBeat.o(23382);
    return i;
  }
  
  public final int getType()
  {
    return 542;
  }
  
  public final void onGYNetEnd(int paramInt1, int paramInt2, int paramInt3, String paramString, s params, byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(23381);
    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "onGYNetEnd, netId = %d, errType = %d, errCode = %d, errMsg = %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString });
    if ((this.vfY != null) && (this.vfY.length == 1)) {
      Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.vfY[0] });
    }
    if (params == null)
    {
      Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.jTk.getType() != params.getType())
    {
      Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.jTk.getType()), Integer.valueOf(params.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = cZp().RPU.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (ku)params.next();
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.CqV), paramArrayOfByte.RPV, paramArrayOfByte.RPQ, paramArrayOfByte.rVG });
        if (paramArrayOfByte.RPW == null)
        {
          Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.RPW;
          if (paramArrayOfByte == null)
          {
            Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = com.tencent.mm.platformtools.z.a(paramArrayOfByte.SrH);
            String str2 = Util.nullAsNil(paramArrayOfByte.TGl);
            if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
            {
              Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              bh.beI();
              as localas1 = com.tencent.mm.model.c.bbL().RG(str1);
              if ((localas1 != null) && (str1.equals(localas1.field_encryptUsername)))
              {
                Log.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                as localas2 = new as(str1);
                localas2.Iq(paramArrayOfByte.mVD);
                localas2.setType(paramArrayOfByte.Sqc & paramArrayOfByte.Sqd);
                label460:
                long l;
                if (!Util.isNullOrNil(str2))
                {
                  localas2.Iy(str2);
                  if (localas1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localas2.jxt = l;
                  localas2.setNickname(com.tencent.mm.platformtools.z.a(paramArrayOfByte.TtX));
                  localas2.It(com.tencent.mm.platformtools.z.a(paramArrayOfByte.SqW));
                  localas2.Iu(com.tencent.mm.platformtools.z.a(paramArrayOfByte.SqX));
                  localas2.pw(paramArrayOfByte.mVy);
                  localas2.pz(paramArrayOfByte.Sqi);
                  localas2.Is(com.tencent.mm.platformtools.z.a(paramArrayOfByte.TGf));
                  localas2.pA(paramArrayOfByte.Sqm);
                  localas2.pB(paramArrayOfByte.mVC);
                  localas2.IP(RegionCodeDecoder.bl(paramArrayOfByte.mVH, paramArrayOfByte.mVz, paramArrayOfByte.mVA));
                  localas2.IJ(paramArrayOfByte.mVB);
                  localas2.ps(paramArrayOfByte.TxF);
                  localas2.IO(paramArrayOfByte.TxG);
                  localas2.setSource(paramArrayOfByte.Cqs);
                  localas2.pr(paramArrayOfByte.TxJ);
                  localas2.Iv(paramArrayOfByte.TxI);
                  if (ab.Rd(paramArrayOfByte.TxH)) {
                    localas2.IN(paramArrayOfByte.TxH);
                  }
                  localas2.pC((int)Util.nowSecond());
                  localas2.Ir(com.tencent.mm.platformtools.z.a(paramArrayOfByte.TFz));
                  localas2.Iw(com.tencent.mm.platformtools.z.a(paramArrayOfByte.TFB));
                  localas2.Ix(com.tencent.mm.platformtools.z.a(paramArrayOfByte.TFA));
                  localas2.IQ(paramArrayOfByte.RIC);
                  localas2.IR(paramArrayOfByte.TGu);
                  if ((localas1 != null) && (!Util.nullAsNil(localas1.hDr).equals(Util.nullAsNil(paramArrayOfByte.TGu))))
                  {
                    com.tencent.mm.bg.c.bnY();
                    com.tencent.mm.bg.c.WQ(str1);
                  }
                  bh.beI();
                  com.tencent.mm.model.c.bbL().bwo(str1);
                  if (!Util.isNullOrNil(localas2.field_username)) {
                    break label1036;
                  }
                  Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localas2.pu(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.TGq != null) && (paramArrayOfByte.TGq.RIW != null))
                  {
                    localas2.IS(paramArrayOfByte.TGq.RIW.RQE);
                    localas2.IT(paramArrayOfByte.TGq.RIW.RQF);
                    localas2.IU(paramArrayOfByte.TGq.RIW.RQG);
                  }
                  if (ab.QX(str1)) {
                    localas2.axx();
                  }
                  if (localas2.hxX()) {
                    localas2.axA();
                  }
                  if (Util.isNullOrNil(str2)) {
                    break label1373;
                  }
                  bh.beI();
                  com.tencent.mm.model.c.bbL().d(str2, localas2);
                }
                for (;;)
                {
                  if ((localas1 == null) || ((localas1.field_type & 0x800) == (localas2.field_type & 0x800))) {
                    break label1389;
                  }
                  if ((localas2.field_type & 0x800) == 0) {
                    break label1391;
                  }
                  bh.beI();
                  com.tencent.mm.model.c.bbR().bwD(localas2.field_username);
                  break;
                  if ((localas1 == null) || ((int)localas1.jxt <= 0)) {
                    break label460;
                  }
                  localas2.Iy(localas1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localas1.jxt;
                  break label468;
                  label1036:
                  Object localObject1 = localas2.field_username;
                  Object localObject2 = com.tencent.mm.am.d.a((String)localObject1, paramArrayOfByte, localas2);
                  com.tencent.mm.am.q.bhP().b((j)localObject2);
                  localObject2 = paramArrayOfByte.TxL;
                  if ((!localas2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((elj)localObject2).mVJ + " " + paramArrayOfByte.SrH);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((elj)localObject2).mVK);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((elj)localObject2).mVL);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((elj)localObject2).Unw);
                    if (p.JPd != null) {
                      p.JPd.a(localas2.field_username, (elj)localObject2);
                    }
                  }
                  localObject2 = com.tencent.mm.model.z.bcZ();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = af.bjv().Uo((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.mVI;
                  localObject1 = paramArrayOfByte.TxM;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((aez)localObject1).mVM;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((aez)localObject1).mVO;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((aez)localObject1).mVP;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((aez)localObject1).mVN;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!af.bjv().h((com.tencent.mm.api.c)localObject2)) {
                    af.bjv().g((com.tencent.mm.api.c)localObject2);
                  }
                  localas2.pD(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1373:
                  bh.beI();
                  com.tencent.mm.model.c.bbL().au(localas2);
                }
                label1389:
                continue;
                label1391:
                bh.beI();
                com.tencent.mm.model.c.bbR().bwE(localas2.field_username);
              }
            }
          }
        }
      }
    }
    this.jQg.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.g;
import com.tencent.mm.network.m;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.dq;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.la;
import com.tencent.mm.protocal.protobuf.lb;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.protocal.protobuf.ld;
import com.tencent.mm.protocal.protobuf.le;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import java.util.Iterator;
import java.util.LinkedList;

public final class k
  extends q
  implements m
{
  private com.tencent.mm.ak.i heq;
  private d hhm;
  private String[] rAr;
  
  public k(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.hhm = null;
    this.heq = null;
    this.rAr = paramArrayOfString;
    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new d.a();
    ((d.a)localObject).iLN = new lc();
    ((d.a)localObject).iLO = new ld();
    ((d.a)localObject).funcId = 542;
    ((d.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((d.a)localObject).iLP = 0;
    ((d.a)localObject).respCmdId = 0;
    this.hhm = ((d.a)localObject).aXF();
    localObject = (lc)this.hhm.iLK.iLR;
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        lb locallb = new lb();
        locallb.KOS = str;
        localLinkedList.add(locallb);
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((lc)localObject).KOT = localLinkedList;
    if (!Util.isNullOrNil(paramString))
    {
      paramArrayOfString = new la();
      paramArrayOfString.KOR = paramString;
      ((lc)localObject).KOU = paramArrayOfString;
    }
    ((lc)localObject).KOV = 3;
    AppMethodBeat.o(23380);
  }
  
  public final ld cKD()
  {
    if ((this.hhm != null) && (this.hhm.iLL.iLR != null)) {
      return (ld)this.hhm.iLL.iLR;
    }
    return null;
  }
  
  public final int doScene(g paramg, com.tencent.mm.ak.i parami)
  {
    AppMethodBeat.i(23382);
    this.heq = parami;
    int i = dispatch(paramg, this.hhm, this);
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
    if ((this.rAr != null) && (this.rAr.length == 1)) {
      Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.rAr[0] });
    }
    if (params == null)
    {
      Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.hhm.getType() != params.getType())
    {
      Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.hhm.getType()), Integer.valueOf(params.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = cKD().KOW.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (le)params.next();
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Ret), paramArrayOfByte.KOX, paramArrayOfByte.KOS, paramArrayOfByte.oTI });
        if (paramArrayOfByte.KOY == null)
        {
          Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.KOY;
          if (paramArrayOfByte == null)
          {
            Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = com.tencent.mm.platformtools.z.a(paramArrayOfByte.Lqk);
            String str2 = Util.nullAsNil(paramArrayOfByte.Mvn);
            if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
            {
              Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              bg.aVF();
              as localas1 = com.tencent.mm.model.c.aSN().Kn(str1);
              if ((localas1 != null) && (str1.equals(localas1.field_encryptUsername)))
              {
                Log.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                as localas2 = new as(str1);
                localas2.BC(paramArrayOfByte.ked);
                localas2.setType(paramArrayOfByte.LoG & paramArrayOfByte.LoH);
                label460:
                long l;
                if (!Util.isNullOrNil(str2))
                {
                  localas2.BK(str2);
                  if (localas1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localas2.gMZ = l;
                  localas2.setNickname(com.tencent.mm.platformtools.z.a(paramArrayOfByte.Mjj));
                  localas2.BF(com.tencent.mm.platformtools.z.a(paramArrayOfByte.LpA));
                  localas2.BG(com.tencent.mm.platformtools.z.a(paramArrayOfByte.LpB));
                  localas2.nj(paramArrayOfByte.kdY);
                  localas2.nl(paramArrayOfByte.LoM);
                  localas2.BE(com.tencent.mm.platformtools.z.a(paramArrayOfByte.Mvh));
                  localas2.nm(paramArrayOfByte.LoQ);
                  localas2.nn(paramArrayOfByte.kec);
                  localas2.Cb(RegionCodeDecoder.bq(paramArrayOfByte.keh, paramArrayOfByte.kdZ, paramArrayOfByte.kea));
                  localas2.BV(paramArrayOfByte.keb);
                  localas2.nf(paramArrayOfByte.MmK);
                  localas2.Ca(paramArrayOfByte.MmL);
                  localas2.setSource(paramArrayOfByte.xub);
                  localas2.ne(paramArrayOfByte.MmO);
                  localas2.BH(paramArrayOfByte.MmN);
                  if (ab.JK(paramArrayOfByte.MmM)) {
                    localas2.BZ(paramArrayOfByte.MmM);
                  }
                  localas2.no((int)Util.nowSecond());
                  localas2.BD(com.tencent.mm.platformtools.z.a(paramArrayOfByte.MuI));
                  localas2.BI(com.tencent.mm.platformtools.z.a(paramArrayOfByte.MuK));
                  localas2.BJ(com.tencent.mm.platformtools.z.a(paramArrayOfByte.MuJ));
                  localas2.Cc(paramArrayOfByte.KHk);
                  localas2.Cd(paramArrayOfByte.Mvw);
                  if ((localas1 != null) && (!Util.nullAsNil(localas1.fuS).equals(Util.nullAsNil(paramArrayOfByte.Mvw))))
                  {
                    com.tencent.mm.bd.c.bez();
                    com.tencent.mm.bd.c.Pt(str1);
                  }
                  bg.aVF();
                  com.tencent.mm.model.c.aSN().bjQ(str1);
                  if (!Util.isNullOrNil(localas2.field_username)) {
                    break label1036;
                  }
                  Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localas2.nh(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.Mvs != null) && (paramArrayOfByte.Mvs.KHD != null))
                  {
                    localas2.Ce(paramArrayOfByte.Mvs.KHD.KPG);
                    localas2.Cf(paramArrayOfByte.Mvs.KHD.KPH);
                    localas2.Cg(paramArrayOfByte.Mvs.KHD.KPI);
                  }
                  if (ab.JE(str1)) {
                    localas2.aqZ();
                  }
                  if (localas2.gBM()) {
                    localas2.arc();
                  }
                  if (Util.isNullOrNil(str2)) {
                    break label1371;
                  }
                  bg.aVF();
                  com.tencent.mm.model.c.aSN().d(str2, localas2);
                }
                for (;;)
                {
                  if ((localas1 == null) || ((localas1.field_type & 0x800) == (localas2.field_type & 0x800))) {
                    break label1387;
                  }
                  if ((localas2.field_type & 0x800) == 0) {
                    break label1389;
                  }
                  bg.aVF();
                  com.tencent.mm.model.c.aST().bke(localas2.field_username);
                  break;
                  if ((localas1 == null) || ((int)localas1.gMZ <= 0)) {
                    break label460;
                  }
                  localas2.BK(localas1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localas1.gMZ;
                  break label468;
                  label1036:
                  Object localObject1 = localas2.field_username;
                  Object localObject2 = com.tencent.mm.aj.c.a((String)localObject1, paramArrayOfByte);
                  p.aYB().b((com.tencent.mm.aj.i)localObject2);
                  localObject2 = paramArrayOfByte.MmQ;
                  if ((!localas2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((ebj)localObject2).kej + " " + paramArrayOfByte.Lqk);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((ebj)localObject2).kek);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((ebj)localObject2).kel);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((ebj)localObject2).Nbc);
                    if (o.DCN != null) {
                      o.DCN.a(localas2.field_username, (ebj)localObject2);
                    }
                  }
                  localObject2 = com.tencent.mm.model.z.aTY();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = ag.bah().MT((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.kei;
                  localObject1 = paramArrayOfByte.MmR;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((aeq)localObject1).kem;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((aeq)localObject1).keo;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((aeq)localObject1).kep;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((aeq)localObject1).ken;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!ag.bah().h((com.tencent.mm.api.c)localObject2)) {
                    ag.bah().g((com.tencent.mm.api.c)localObject2);
                  }
                  localas2.np(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1371:
                  bg.aVF();
                  com.tencent.mm.model.c.aSN().ao(localas2);
                }
                label1387:
                continue;
                label1389:
                bg.aVF();
                com.tencent.mm.model.c.aST().bkf(localas2.field_username);
              }
            }
          }
        }
      }
    }
    this.heq.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.k
 * JD-Core Version:    0.7.0.1
 */
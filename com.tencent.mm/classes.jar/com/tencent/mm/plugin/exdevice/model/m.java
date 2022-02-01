package com.tencent.mm.plugin.exdevice.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.an.f;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.ed;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.lm;
import com.tencent.mm.protocal.protobuf.ln;
import com.tencent.mm.protocal.protobuf.lo;
import com.tencent.mm.protocal.protobuf.lp;
import com.tencent.mm.protocal.protobuf.lq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import java.util.Iterator;
import java.util.LinkedList;

public final class m
  extends p
  implements com.tencent.mm.network.m
{
  private com.tencent.mm.am.h mAY;
  private com.tencent.mm.am.c mtC;
  private String[] yrW;
  
  public m(String[] paramArrayOfString, String paramString)
  {
    AppMethodBeat.i(23380);
    this.mtC = null;
    this.mAY = null;
    this.yrW = paramArrayOfString;
    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, %s, list = %d", new Object[] { paramString, Integer.valueOf(1) });
    Object localObject = new c.a();
    ((c.a)localObject).otE = new lo();
    ((c.a)localObject).otF = new lp();
    ((c.a)localObject).funcId = 542;
    ((c.a)localObject).uri = "/cgi-bin/micromsg-bin/batchsearchharddevice";
    ((c.a)localObject).otG = 0;
    ((c.a)localObject).respCmdId = 0;
    this.mtC = ((c.a)localObject).bEF();
    localObject = (lo)c.b.b(this.mtC.otB);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i <= 0)
    {
      String str = paramArrayOfString[0];
      if (str != null)
      {
        ln localln = new ln();
        localln.YNe = str;
        localLinkedList.add(localln);
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "NetSceneBatchSearchHardDevice, item = %s", new Object[] { str });
      }
      i += 1;
    }
    ((lo)localObject).YNf = localLinkedList;
    if (!Util.isNullOrNil(paramString))
    {
      paramArrayOfString = new lm();
      paramArrayOfString.YNd = paramString;
      ((lo)localObject).YNg = paramArrayOfString;
    }
    ((lo)localObject).YNh = 3;
    AppMethodBeat.o(23380);
  }
  
  public final lp dFG()
  {
    AppMethodBeat.i(274637);
    if ((this.mtC != null) && (c.c.b(this.mtC.otC) != null))
    {
      lp locallp = (lp)c.c.b(this.mtC.otC);
      AppMethodBeat.o(274637);
      return locallp;
    }
    AppMethodBeat.o(274637);
    return null;
  }
  
  public final int doScene(g paramg, com.tencent.mm.am.h paramh)
  {
    AppMethodBeat.i(23382);
    this.mAY = paramh;
    int i = dispatch(paramg, this.mtC, this);
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
    if ((this.yrW != null) && (this.yrW.length == 1)) {
      Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "device mac is  = %s", new Object[] { this.yrW[0] });
    }
    if (params == null)
    {
      Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == rr");
      AppMethodBeat.o(23381);
      return;
    }
    if (this.mtC.getType() != params.getType())
    {
      Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "mReqResp.getType(%d) != rr.getType(%d)", new Object[] { Integer.valueOf(this.mtC.getType()), Integer.valueOf(params.getType()) });
      AppMethodBeat.o(23381);
      return;
    }
    if ((paramInt2 == 0) && (paramInt3 == 0))
    {
      params = dFG().YNi.iterator();
      while (params.hasNext())
      {
        paramArrayOfByte = (lq)params.next();
        Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "BatchSearchHardDeviceResp, ret = %d, bind ticket = %s, mac = %s, device name = %s", new Object[] { Integer.valueOf(paramArrayOfByte.Idd), paramArrayOfByte.YNj, paramArrayOfByte.YNe, paramArrayOfByte.vgW });
        if (paramArrayOfByte.YNk == null)
        {
          Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "null == item.Contact");
        }
        else
        {
          paramArrayOfByte = paramArrayOfByte.YNk;
          if (paramArrayOfByte == null)
          {
            Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "unable to parse mod contact");
          }
          else
          {
            String str1 = w.a(paramArrayOfByte.ZqL);
            String str2 = Util.nullAsNil(paramArrayOfByte.aaVR);
            if ((Util.isNullOrNil(str1)) && (Util.isNullOrNil(str2)))
            {
              Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact user is null user:%s enuser:%s", new Object[] { str1, str2 });
            }
            else
            {
              Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "processModContact : %s", new Object[] { str1 });
              bh.bCz();
              au localau1 = com.tencent.mm.model.c.bzA().JE(str1);
              if ((localau1 != null) && (str1.equals(localau1.field_encryptUsername)))
              {
                Log.w("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "cat's replace user with stranger");
              }
              else
              {
                au localau2 = new au(str1);
                localau2.AV(paramArrayOfByte.pSk);
                localau2.setType(paramArrayOfByte.ZoY & paramArrayOfByte.ZoZ);
                label460:
                long l;
                if (!Util.isNullOrNil(str2))
                {
                  localau2.Bd(str2);
                  if (localau1 != null) {
                    break label1024;
                  }
                  l = 0L;
                  label468:
                  localau2.maN = l;
                  localau2.setNickname(w.a(paramArrayOfByte.aaIz));
                  localau2.AY(w.a(paramArrayOfByte.ZpX));
                  localau2.AZ(w.a(paramArrayOfByte.ZpY));
                  localau2.pv(paramArrayOfByte.pSf);
                  localau2.py(paramArrayOfByte.Zpe);
                  localau2.AX(w.a(paramArrayOfByte.aaVL));
                  localau2.pz(paramArrayOfByte.Zpi);
                  localau2.pA(paramArrayOfByte.pSj);
                  localau2.Bu(RegionCodeDecoder.bI(paramArrayOfByte.pSo, paramArrayOfByte.pSg, paramArrayOfByte.pSh));
                  localau2.Bo(paramArrayOfByte.pSi);
                  localau2.pr(paramArrayOfByte.aaMm);
                  localau2.Bt(paramArrayOfByte.aaMn);
                  localau2.setSource(paramArrayOfByte.IcB);
                  localau2.pq(paramArrayOfByte.aaMq);
                  localau2.Ba(paramArrayOfByte.aaMp);
                  if (ab.Jb(paramArrayOfByte.aaMo)) {
                    localau2.Bs(paramArrayOfByte.aaMo);
                  }
                  localau2.pB((int)Util.nowSecond());
                  localau2.AW(w.a(paramArrayOfByte.aaVg));
                  localau2.Bb(w.a(paramArrayOfByte.aaVi));
                  localau2.Bc(w.a(paramArrayOfByte.aaVh));
                  localau2.Bv(paramArrayOfByte.crB);
                  localau2.Bw(paramArrayOfByte.aaWa);
                  if ((localau1 != null) && (!Util.nullAsNil(localau1.kam).equals(Util.nullAsNil(paramArrayOfByte.aaWa))))
                  {
                    com.tencent.mm.ba.c.bLL();
                    com.tencent.mm.ba.c.OQ(str1);
                  }
                  bh.bCz();
                  com.tencent.mm.model.c.bzA().bxB(str1);
                  if (!Util.isNullOrNil(localau2.field_username)) {
                    break label1036;
                  }
                  Log.e("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "dkinit dealModContactExtInfo failed invalid contact");
                  label810:
                  localau2.pt(paramArrayOfByte.DeleteFlag);
                  if ((paramArrayOfByte.aaVW != null) && (paramArrayOfByte.aaVW.YGk != null))
                  {
                    localau2.Bx(paramArrayOfByte.aaVW.YGk.YNT);
                    localau2.By(paramArrayOfByte.aaVW.YGk.YNU);
                    localau2.Bz(paramArrayOfByte.aaVW.YGk.YNV);
                  }
                  if (ab.IV(str1)) {
                    localau2.aRZ();
                  }
                  if (localau2.iZC()) {
                    localau2.aSc();
                  }
                  if (Util.isNullOrNil(str2)) {
                    break label1373;
                  }
                  bh.bCz();
                  com.tencent.mm.model.c.bzA().e(str2, localau2);
                }
                for (;;)
                {
                  if ((localau1 == null) || ((localau1.field_type & 0x800) == (localau2.field_type & 0x800))) {
                    break label1389;
                  }
                  if ((localau2.field_type & 0x800) == 0) {
                    break label1391;
                  }
                  bh.bCz();
                  com.tencent.mm.model.c.bzG().bxT(localau2.field_username);
                  break;
                  if ((localau1 == null) || ((int)localau1.maN <= 0)) {
                    break label460;
                  }
                  localau2.Bd(localau1.field_encryptUsername);
                  break label460;
                  label1024:
                  l = (int)localau1.maN;
                  break label468;
                  label1036:
                  Object localObject1 = localau2.field_username;
                  Object localObject2 = com.tencent.mm.modelavatar.d.a((String)localObject1, paramArrayOfByte, localau2);
                  com.tencent.mm.modelavatar.q.bFE().b((j)localObject2);
                  localObject2 = paramArrayOfByte.aaMs;
                  if ((!localau2.field_username.endsWith("@chatroom")) && (localObject2 != null))
                  {
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsFlag modcontact " + ((ffs)localObject2).pSq + " " + paramArrayOfByte.ZqL);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBg modcontact " + ((ffs)localObject2).pSr);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((ffs)localObject2).pSs);
                    Log.i("MicroMsg.exdevice.NetSceneBatchSearchHardDevice", "SnsBgId modcontact " + ((ffs)localObject2).abFF);
                    if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
                      com.tencent.mm.plugin.sns.c.q.Qki.a(localau2.field_username, (ffs)localObject2);
                    }
                  }
                  localObject2 = z.bAM();
                  if ((localObject2 == null) || (((String)localObject2).equals(localObject1))) {
                    break label810;
                  }
                  localObject2 = af.bHf().Mn((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_username = ((String)localObject1);
                  ((com.tencent.mm.api.c)localObject2).field_brandList = paramArrayOfByte.pSp;
                  localObject1 = paramArrayOfByte.aaMt;
                  if (localObject1 != null)
                  {
                    ((com.tencent.mm.api.c)localObject2).field_brandFlag = ((ahl)localObject1).pSt;
                    ((com.tencent.mm.api.c)localObject2).field_brandInfo = ((ahl)localObject1).pSv;
                    ((com.tencent.mm.api.c)localObject2).field_brandIconURL = ((ahl)localObject1).pSw;
                    ((com.tencent.mm.api.c)localObject2).field_extInfo = ((ahl)localObject1).pSu;
                    ((com.tencent.mm.api.c)localObject2).field_attrSyncVersion = null;
                    ((com.tencent.mm.api.c)localObject2).field_incrementUpdateTime = 0L;
                  }
                  if (!af.bHf().h((com.tencent.mm.api.c)localObject2)) {
                    af.bHf().g((com.tencent.mm.api.c)localObject2);
                  }
                  localau2.pC(((com.tencent.mm.api.c)localObject2).field_type);
                  break label810;
                  label1373:
                  bh.bCz();
                  com.tencent.mm.model.c.bzA().aA(localau2);
                }
                label1389:
                continue;
                label1391:
                bh.bCz();
                com.tencent.mm.model.c.bzG().bxU(localau2.field_username);
              }
            }
          }
        }
      }
    }
    this.mAY.onSceneEnd(paramInt2, paramInt3, paramString, this);
    AppMethodBeat.o(23381);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.m
 * JD-Core Version:    0.7.0.1
 */
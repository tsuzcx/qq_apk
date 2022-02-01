package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.l;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ah;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.f;
import com.tencent.mm.protocal.j.a;
import com.tencent.mm.protocal.j.b;
import com.tencent.mm.protocal.j.e;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.j.h;
import com.tencent.mm.protocal.j.i;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.l.e;
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.o.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bte;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.bxl;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.duy;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.hd;
import com.tencent.mm.protocal.protobuf.he;
import com.tencent.mm.protocal.protobuf.hg;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.op;
import com.tencent.mm.protocal.protobuf.oq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ae;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ba
  extends l
  implements j.e
{
  private static a hnV = null;
  private final int hnS;
  private final j.h hnT;
  private final j.i hnU;
  
  public ba(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.hnS = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.hnT = new j.a();
      this.hnU = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.hnT = new j.f();
    this.hnU = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)paramq.getReqObj();
    j.i locali = (j.i)paramq.getRespObj();
    ac.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(locali.gbq), bs.eWi() });
    int i;
    if (locali.gbq != 0)
    {
      ac.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.gbq) });
      i = locali.gbq;
      AppMethodBeat.o(132248);
      return i;
    }
    dlb localdlb = locali.DIG;
    int k = localdlb.FTQ;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localdlb.FTR;
      j = ((gq)localObject1).DTO;
      ac.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((gq)localObject1).DTN) });
      arrayOfByte1 = com.tencent.mm.platformtools.z.a(((gq)localObject1).DTR);
      arrayOfByte2 = com.tencent.mm.platformtools.z.a(((gq)localObject1).DTS);
      paramq = ((gq)localObject1).DTy;
      arrayOfByte3 = com.tencent.mm.platformtools.z.a(((gq)localObject1).DTz);
      int m = paramq.DUt.getILen();
      int n = paramq.Ewf;
      if (arrayOfByte3 == null)
      {
        i = -1;
        ac.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bs.aLJ(bs.cu(arrayOfByte3)), bs.aLJ(bs.cu(arrayOfByte1)), bs.aLJ(bs.cu(arrayOfByte2)) });
        localObject1 = com.tencent.mm.platformtools.z.a(paramq.DUt);
        localObject2 = ((j.h)localObject2).DIF;
        if (bs.cv((byte[])localObject1)) {
          break label667;
        }
        m = localObject1.length;
        Object localObject3 = bs.aLJ(bs.cu((byte[])localObject1));
        if (localObject2 != null) {
          break label654;
        }
        i = -1;
        label352:
        ac.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bs.aLJ(bs.cu((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramq.Ewf, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramq = ((PByteArray)localObject3).value;
        if (paramq != null) {
          break label661;
        }
        i = -1;
        label431:
        ac.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bs.aLJ(bs.cu(paramq)) });
        label467:
        if (paramq == null) {
          break label693;
        }
        localObject1 = paramq;
        label474:
        locali.DIK = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label800;
        }
        ac.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bs.cv(paramq)) {
          break label757;
        }
        paramq = MMProtocalJni.aesDecrypt(arrayOfByte3, paramq);
        if (arrayOfByte3 != null) {
          break label701;
        }
        i = -1;
        label515:
        localObject1 = bs.aLJ(bs.cu(arrayOfByte3));
        if (paramq != null) {
          break label708;
        }
        j = -1;
        label531:
        ac.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bs.aLJ(bs.cu(paramq)) });
        if (bs.cv(paramq)) {
          break label714;
        }
        ac.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bs.aLJ(bs.cu(paramq)) });
        locali.b(paramq, arrayOfByte1, arrayOfByte2);
        locali.gbq = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.diA = localdlb.FTS.ncR;
      }
    }
    for (;;)
    {
      i = locali.gbq;
      AppMethodBeat.o(132248);
      return i;
      i = arrayOfByte3.length;
      break;
      label654:
      i = localObject2.length;
      break label352;
      label661:
      i = paramq.length;
      break label431;
      label667:
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 24L, 1L, false);
      ac.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
      paramq = null;
      break label467;
      label693:
      localObject1 = new byte[0];
      break label474;
      label701:
      i = arrayOfByte3.length;
      break label515;
      label708:
      j = paramq.length;
      break label531;
      label714:
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 25L, 1L, false);
      ac.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.gbq = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 26L, 1L, false);
      ac.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.gbq = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 27L, 1L, false);
      ac.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.gbq = 1;
      break label615;
      ac.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localdlb.FTR });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.gbq = 2;
      break label615;
      label885:
      ac.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    hnV = parama;
  }
  
  public static void a(boolean paramBoolean, oq paramoq, bxl parambxl, bkh parambkh)
  {
    AppMethodBeat.i(132244);
    int i;
    int j;
    label20:
    int k;
    label27:
    int m;
    label34:
    int n;
    label41:
    int i1;
    if (paramoq == null)
    {
      i = -1;
      if (paramoq != null) {
        break label202;
      }
      j = -1;
      if (parambkh != null) {
        break label211;
      }
      k = -1;
      if (parambxl != null) {
        break label220;
      }
      m = -1;
      if (parambxl != null) {
        break label229;
      }
      n = -1;
      if (parambxl != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (parambxl != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (parambxl != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = parambxl.Fmj)
    {
      ac.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((parambkh != null) && (parambkh.ncM != null) && (parambkh.ncM.size() > 0)) {
        break label265;
      }
      ac.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bs.eWi() });
      AppMethodBeat.o(132244);
      return;
      i = paramoq.Eey;
      break;
      label202:
      j = paramoq.Eez;
      break label20;
      label211:
      k = parambkh.ncL;
      break label27;
      label220:
      m = parambxl.Fmk;
      break label34;
      label229:
      n = parambxl.Fml;
      break label41;
      label238:
      i1 = parambxl.Fmm;
      break label48;
      label247:
      localObject1 = parambxl.Fmi;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (paramoq != null)
    {
      localObject3 = paramoq.EeC.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (op)((Iterator)localObject3).next();
        localObject1 = "";
        if (((op)localObject4).Eex != null) {
          localObject1 = ((op)localObject4).Eex.eQU();
        }
        ((List)localObject2).add(new o(((op)localObject4).type, ((op)localObject4).Eew.eQU(), ((op)localObject4).port, (String)localObject1));
        ac.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((op)localObject4).type), Integer.valueOf(((op)localObject4).port), ((op)localObject4).Eew.eQU() });
      }
    }
    localObject2 = o.gW((List)localObject2);
    Object localObject1 = new LinkedList();
    if (paramoq != null)
    {
      localObject3 = paramoq.EeB.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (op)((Iterator)localObject3).next();
        paramoq = "";
        if (((op)localObject4).Eex != null) {
          paramoq = ((op)localObject4).Eex.eQU();
        }
        ((List)localObject1).add(new o(((op)localObject4).type, ((op)localObject4).Eew.eQU(), ((op)localObject4).port, paramoq));
        ac.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((op)localObject4).type), Integer.valueOf(((op)localObject4).port), ((op)localObject4).Eew.eQU() });
      }
    }
    Object localObject3 = o.gW((List)localObject1);
    ac.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    g.agS();
    g.agR().ghx.set(2, localObject2);
    Object localObject4 = ai.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    g.agS();
    g.agR().ghx.set(3, localObject3);
    if (parambxl != null)
    {
      g.agS();
      g.agR().ghx.set(6, parambxl.Fmi);
      g.agS();
      g.agR().ghx.set(7, parambxl.Fmj);
      if (parambxl.Fmm != 0)
      {
        g.agS();
        paramoq = g.agR().ghx;
        if (parambxl.Fmm > 60)
        {
          i = 60;
          paramoq.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        ah.z(parambxl.Fmk, parambxl.Fmn);
      }
    }
    for (paramoq = o.lf(parambxl.Fmi, parambxl.Fmj);; paramoq = null)
    {
      parambxl = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[parambkh.ncM.size()];
      String[] arrayOfString2 = new String[parambkh.ncM.size()];
      int[] arrayOfInt = new int[parambkh.ncM.size()];
      ac.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(parambkh.ncL) });
      Iterator localIterator = parambkh.ncM.iterator();
      i = 0;
      parambkh = (bkh)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (bkg)localIterator.next();
        ac.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((bkg)localObject1).EZU, ((bkg)localObject1).EZV });
        arrayOfString1[i] = ((bkg)localObject1).EZU;
        arrayOfString2[i] = ((bkg)localObject1).EZV;
        arrayOfInt[i] = ((bkg)localObject1).EZW;
        j = i + 1;
        i = j;
        if (!bs.isNullOrNil(((bkg)localObject1).EZU))
        {
          i = j;
          if (!bs.isNullOrNil(((bkg)localObject1).EZV))
          {
            if (((bkg)localObject1).EZU.equals("short.weixin.qq.com"))
            {
              g.agS();
              g.agR().ghx.set(24, ((bkg)localObject1).EZV);
              parambkh = ((bkg)localObject1).EZV;
              i = j;
              continue;
              i = parambxl.Fmm;
              break;
            }
            if (((bkg)localObject1).EZU.equals("long.weixin.qq.com"))
            {
              g.agS();
              g.agR().ghx.set(25, ((bkg)localObject1).EZV);
              parambxl = ((bkg)localObject1).EZV;
              i = j;
            }
            else
            {
              i = j;
              if (((bkg)localObject1).EZU.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!bs.isNullOrNil(((bkg)localObject1).EZV))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((bkg)localObject1).EZV).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      g.agS();
      localObject1 = g.agQ().ghe.hwg;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!bs.isNullOrNil(parambxl))
      {
        g.agS();
        g.agR().ghx.set(25, parambxl);
      }
      if (!bs.isNullOrNil(parambkh))
      {
        g.agS();
        g.agR().ghx.set(24, parambkh);
      }
      if ((localObject1 != null) && (paramoq != null)) {
        ((com.tencent.mm.network.e)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, paramoq.DIU, paramoq.DIV, paramoq.DIW, paramoq.DIX, parambkh, parambxl);
      }
      AppMethodBeat.o(132244);
      return;
    }
  }
  
  public static SharedPreferences ayR()
  {
    AppMethodBeat.i(210303);
    SharedPreferences localSharedPreferences = bb.ayR();
    AppMethodBeat.o(210303);
    return localSharedPreferences;
  }
  
  private com.tencent.mm.network.q nW(int paramInt)
  {
    AppMethodBeat.i(132240);
    ac.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bs.eWi() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = bb.ayR();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    ac.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.DIc) });
    long l;
    iq localiq;
    if (i < d.DIc)
    {
      if ((this.hnS == 702) || (this.hnS == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.e.wTc;
        if (this.hnS != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, false);
        localiq = new iq();
        localiq.DWA = paramInt;
        localiq.DTG = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localiq.DTF = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject1 = new duy();
        localiq.DWy = ((duy)localObject1);
        ((duy)localObject1).DYU = "";
        ((duy)localObject1).DYT = "";
        ((duy)localObject1).GcE = "";
        localObject1 = new dzn();
        localiq.DWz = ((dzn)localObject1);
        ((dzn)localObject1).EUa = "";
        ((dzn)localObject1).ETZ = "";
        if (g.agM()) {
          break label364;
        }
        ac.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.hnS == 702) || (this.hnS == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    g.agS();
    Object localObject1 = bs.nullAsNil((String)g.agR().agA().get(2, null));
    g.agS();
    Object localObject7 = new p(bs.a((Integer)g.agR().agA().get(9, null), 0));
    if (bs.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      g.agS();
      Object localObject2 = g.agP().afQ();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.hnS == 252) || (this.hnS == 701))
      {
        bool = true;
        localObject3 = ((com.tencent.mm.ak.z)localObject2).a(l, "", bool);
        if (localObject3 != null) {
          break label874;
        }
        paramInt = -1;
        label495:
        if (localObject3 != null) {
          break label881;
        }
        localObject2 = "null";
        label505:
        ac.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new SKBuiltinBuffer_t();
        if (!bs.cv((byte[])localObject3)) {
          break label894;
        }
        localObject2 = new byte[0];
        label561:
        localiq.DWx = ((SKBuiltinBuffer_t)localObject7).setBuffer((byte[])localObject2);
        if ((this.hnS != 702) && (this.hnS != 763)) {
          break label1021;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new hd();
        localObject6 = new hg();
        ((j.a)localObject2).DIE.DUu = ((hg)localObject6);
        ((j.a)localObject2).DIE.DUv = ((hd)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label901;
        }
        paramInt = -1;
        ac.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = bs.aLu((String)localObject4);
        localObject4 = new he();
        if (bs.cv((byte[])localObject7)) {
          break label943;
        }
        ((hd)localObject5).DTA = new SKBuiltinBuffer_t().setBuffer((byte[])localObject7);
        ac.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((hd)localObject5).DTA.getBuffer().xy.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((he)localObject4).parseFrom((byte[])localObject7);
          if (((he)localObject4).DUs == null) {
            break label978;
          }
          ((hg)localObject6).DUw = ((he)localObject4).DUs;
          ac.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((he)localObject4).DUs.getBuffer().xy.length), bs.cu(((he)localObject4).DUs.getBuffer().xy) });
          ((hd)localObject5).DUl = localiq;
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).diA = ((String)localObject1);
          AppMethodBeat.o(132240);
          return this;
          bool = false;
          break;
          label874:
          paramInt = localObject3.length;
          break label495;
          label881:
          localObject2 = bs.aLJ(bs.cu((byte[])localObject3));
          break label505;
          label894:
          localObject2 = localObject3;
          break label561;
          label901:
          paramInt = ((String)localObject4).length();
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 15L, 1L, false);
          ac.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label943:
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 16L, 1L, false);
        ((hd)localObject5).DTA = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        continue;
        label978:
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 17L, 1L, false);
        ((hg)localObject6).DUw = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ac.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1021:
        localObject3 = (j.f)localObject6;
        localObject2 = new btg();
        localObject4 = new bte();
        ((j.f)localObject3).DII.Fim = ((btg)localObject2);
        ((j.f)localObject3).DII.Fin = ((bte)localObject4);
        ((bte)localObject4).Fil = 2;
        ((bte)localObject4).DUl = localiq;
        ((btg)localObject2).ncR = ((String)localObject1);
        g.agS();
        localObject1 = bs.nullAsNil((String)g.agR().agA().get(3, null));
        g.agS();
        ((btg)localObject2).DYF = bs.nullAsNil((String)g.agR().agA().get(19, null));
        ((btg)localObject2).DYS = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!g.agM())
    {
      ac.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    dlb localdlb = parami.DIG;
    boolean bool;
    if ((localdlb != null) && (localdlb.FTR != null))
    {
      int i = parami.DIG.FTR.DTP;
      ac.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      g.agS();
      g.agR().ghx.set(47, Integer.valueOf(i));
      com.tencent.mm.network.e locale = g.agQ().ghe.hwg;
      if (locale != null)
      {
        if ((i & 0x1) != 0) {
          break label263;
        }
        bool = true;
        locale.eG(bool);
      }
    }
    for (;;)
    {
      ac.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label384;
      }
      if ((paramInt1 != 4) || (paramInt2 != -301)) {
        break label309;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 18L, 1L, false);
      ac.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localdlb == null) || (localdlb.FTT == null)) {
        break label294;
      }
      a(true, parami.DIG.FTT.DYH, parami.DIG.FTT.DYI, parami.DIG.FTT.DYG);
      AppMethodBeat.o(132243);
      return;
      label263:
      bool = false;
      break;
      ac.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(parami.getRetCode()) });
    }
    label294:
    ac.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
    AppMethodBeat.o(132243);
    return;
    label309:
    paramh = com.tencent.mm.plugin.report.e.wTc;
    if (f.DIl)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.e.wTc;
      if (!f.DIm) {
        break label376;
      }
    }
    label376:
    for (long l = 121L;; l = 122L)
    {
      paramh.idkeyStat(148L, l, 1L, false);
      AppMethodBeat.o(132243);
      return;
      l = 120L;
      break;
    }
    label384:
    if (hnV != null) {
      hnV.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int ayQ()
  {
    AppMethodBeat.i(132241);
    if (g.agM())
    {
      g.agS();
      g.agP();
      int i = a.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    ac.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bs.eWi() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final com.tencent.mm.network.q da(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    com.tencent.mm.network.q localq = new ba(paramInt1).nW(paramInt2);
    AppMethodBeat.o(132242);
    return localq;
  }
  
  public final l.d getReqObjImp()
  {
    return this.hnT;
  }
  
  public final l.e getRespObj()
  {
    return this.hnU;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.hnT.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.hnT.getUri();
    AppMethodBeat.o(132247);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ba
 * JD-Core Version:    0.7.0.1
 */
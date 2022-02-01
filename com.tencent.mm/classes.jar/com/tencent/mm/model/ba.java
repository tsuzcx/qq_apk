package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
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
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.boo;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bsu;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dtw;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.gz;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hc;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.oi;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ba
  extends l
  implements j.e
{
  private static a gNv = null;
  private final int gNs;
  private final j.h gNt;
  private final j.i gNu;
  
  public ba(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.gNs = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.gNt = new j.a();
      this.gNu = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.gNt = new j.f();
    this.gNu = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)paramq.getReqObj();
    j.i locali = (j.i)paramq.getRespObj();
    ad.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(locali.fWJ), bt.eGN() });
    int i;
    if (locali.fWJ != 0)
    {
      ad.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.fWJ) });
      i = locali.fWJ;
      AppMethodBeat.o(132248);
      return i;
    }
    dfm localdfm = locali.Cqo;
    int k = localdfm.EwO;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localdfm.EwP;
      j = ((gm)localObject1).CBq;
      ad.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((gm)localObject1).CBp) });
      arrayOfByte1 = com.tencent.mm.platformtools.z.a(((gm)localObject1).CBt);
      arrayOfByte2 = com.tencent.mm.platformtools.z.a(((gm)localObject1).CBu);
      paramq = ((gm)localObject1).CBa;
      arrayOfByte3 = com.tencent.mm.platformtools.z.a(((gm)localObject1).CBb);
      int m = paramq.CBW.getILen();
      int n = paramq.DcY;
      if (arrayOfByte3 == null)
      {
        i = -1;
        ad.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bt.aGs(bt.cv(arrayOfByte3)), bt.aGs(bt.cv(arrayOfByte1)), bt.aGs(bt.cv(arrayOfByte2)) });
        localObject1 = com.tencent.mm.platformtools.z.a(paramq.CBW);
        localObject2 = ((j.h)localObject2).Cqn;
        if (bt.cw((byte[])localObject1)) {
          break label667;
        }
        m = localObject1.length;
        Object localObject3 = bt.aGs(bt.cv((byte[])localObject1));
        if (localObject2 != null) {
          break label654;
        }
        i = -1;
        label352:
        ad.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bt.aGs(bt.cv((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramq.DcY, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramq = ((PByteArray)localObject3).value;
        if (paramq != null) {
          break label661;
        }
        i = -1;
        label431:
        ad.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bt.aGs(bt.cv(paramq)) });
        label467:
        if (paramq == null) {
          break label693;
        }
        localObject1 = paramq;
        label474:
        locali.Cqs = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label800;
        }
        ad.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bt.cw(paramq)) {
          break label757;
        }
        paramq = MMProtocalJni.aesDecrypt(arrayOfByte3, paramq);
        if (arrayOfByte3 != null) {
          break label701;
        }
        i = -1;
        label515:
        localObject1 = bt.aGs(bt.cv(arrayOfByte3));
        if (paramq != null) {
          break label708;
        }
        j = -1;
        label531:
        ad.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bt.aGs(bt.cv(paramq)) });
        if (bt.cw(paramq)) {
          break label714;
        }
        ad.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bt.aGs(bt.cv(paramq)) });
        locali.b(paramq, arrayOfByte1, arrayOfByte2);
        locali.fWJ = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.hKD = localdfm.EwQ.mAQ;
      }
    }
    for (;;)
    {
      i = locali.fWJ;
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 24L, 1L, false);
      ad.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
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
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 25L, 1L, false);
      ad.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.fWJ = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 26L, 1L, false);
      ad.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.fWJ = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 27L, 1L, false);
      ad.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.fWJ = 1;
      break label615;
      ad.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localdfm.EwP });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.fWJ = 2;
      break label615;
      label885:
      ad.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    gNv = parama;
  }
  
  public static void a(boolean paramBoolean, oj paramoj, bsu parambsu, bgp parambgp)
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
    if (paramoj == null)
    {
      i = -1;
      if (paramoj != null) {
        break label202;
      }
      j = -1;
      if (parambgp != null) {
        break label211;
      }
      k = -1;
      if (parambsu != null) {
        break label220;
      }
      m = -1;
      if (parambsu != null) {
        break label229;
      }
      n = -1;
      if (parambsu != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (parambsu != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (parambsu != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = parambsu.DPS)
    {
      ad.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((parambgp != null) && (parambgp.mAL != null) && (parambgp.mAL.size() > 0)) {
        break label265;
      }
      ad.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bt.eGN() });
      AppMethodBeat.o(132244);
      return;
      i = paramoj.CLW;
      break;
      label202:
      j = paramoj.CLX;
      break label20;
      label211:
      k = parambgp.mAK;
      break label27;
      label220:
      m = parambsu.DPT;
      break label34;
      label229:
      n = parambsu.DPU;
      break label41;
      label238:
      i1 = parambsu.DPV;
      break label48;
      label247:
      localObject1 = parambsu.DPR;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (paramoj != null)
    {
      localObject3 = paramoj.CMa.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (oi)((Iterator)localObject3).next();
        localObject1 = "";
        if (((oi)localObject4).CLV != null) {
          localObject1 = ((oi)localObject4).CLV.eBA();
        }
        ((List)localObject2).add(new o(((oi)localObject4).type, ((oi)localObject4).CLU.eBA(), ((oi)localObject4).port, (String)localObject1));
        ad.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((oi)localObject4).type), Integer.valueOf(((oi)localObject4).port), ((oi)localObject4).CLU.eBA() });
      }
    }
    localObject2 = o.gJ((List)localObject2);
    Object localObject1 = new LinkedList();
    if (paramoj != null)
    {
      localObject3 = paramoj.CLZ.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (oi)((Iterator)localObject3).next();
        paramoj = "";
        if (((oi)localObject4).CLV != null) {
          paramoj = ((oi)localObject4).CLV.eBA();
        }
        ((List)localObject1).add(new o(((oi)localObject4).type, ((oi)localObject4).CLU.eBA(), ((oi)localObject4).port, paramoj));
        ad.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((oi)localObject4).type), Integer.valueOf(((oi)localObject4).port), ((oi)localObject4).CLU.eBA() });
      }
    }
    Object localObject3 = o.gJ((List)localObject1);
    ad.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    g.afC();
    g.afB().gcR.set(2, localObject2);
    Object localObject4 = aj.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    g.afC();
    g.afB().gcR.set(3, localObject3);
    if (parambsu != null)
    {
      g.afC();
      g.afB().gcR.set(6, parambsu.DPR);
      g.afC();
      g.afB().gcR.set(7, parambsu.DPS);
      if (parambsu.DPV != 0)
      {
        g.afC();
        paramoj = g.afB().gcR;
        if (parambsu.DPV > 60)
        {
          i = 60;
          paramoj.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        ah.C(parambsu.DPT, parambsu.DPW);
      }
    }
    for (paramoj = o.kI(parambsu.DPR, parambsu.DPS);; paramoj = null)
    {
      parambsu = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[parambgp.mAL.size()];
      String[] arrayOfString2 = new String[parambgp.mAL.size()];
      int[] arrayOfInt = new int[parambgp.mAL.size()];
      ad.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(parambgp.mAK) });
      Iterator localIterator = parambgp.mAL.iterator();
      i = 0;
      parambgp = (bgp)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (bgo)localIterator.next();
        ad.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((bgo)localObject1).DEz, ((bgo)localObject1).DEA });
        arrayOfString1[i] = ((bgo)localObject1).DEz;
        arrayOfString2[i] = ((bgo)localObject1).DEA;
        arrayOfInt[i] = ((bgo)localObject1).DEB;
        j = i + 1;
        i = j;
        if (!bt.isNullOrNil(((bgo)localObject1).DEz))
        {
          i = j;
          if (!bt.isNullOrNil(((bgo)localObject1).DEA))
          {
            if (((bgo)localObject1).DEz.equals("short.weixin.qq.com"))
            {
              g.afC();
              g.afB().gcR.set(24, ((bgo)localObject1).DEA);
              parambgp = ((bgo)localObject1).DEA;
              i = j;
              continue;
              i = parambsu.DPV;
              break;
            }
            if (((bgo)localObject1).DEz.equals("long.weixin.qq.com"))
            {
              g.afC();
              g.afB().gcR.set(25, ((bgo)localObject1).DEA);
              parambsu = ((bgo)localObject1).DEA;
              i = j;
            }
            else
            {
              i = j;
              if (((bgo)localObject1).DEz.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!bt.isNullOrNil(((bgo)localObject1).DEA))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((bgo)localObject1).DEA).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      g.afC();
      localObject1 = g.afA().gcy.gVH;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!bt.isNullOrNil(parambsu))
      {
        g.afC();
        g.afB().gcR.set(25, parambsu);
      }
      if (!bt.isNullOrNil(parambgp))
      {
        g.afC();
        g.afB().gcR.set(24, parambgp);
      }
      if ((localObject1 != null) && (paramoj != null)) {
        ((com.tencent.mm.network.e)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, paramoj.CqC, paramoj.CqD, paramoj.CqE, paramoj.CqF, parambgp, parambsu);
      }
      AppMethodBeat.o(132244);
      return;
    }
  }
  
  public static SharedPreferences asa()
  {
    AppMethodBeat.i(202262);
    SharedPreferences localSharedPreferences = bb.asa();
    AppMethodBeat.o(202262);
    return localSharedPreferences;
  }
  
  private com.tencent.mm.network.q ni(int paramInt)
  {
    AppMethodBeat.i(132240);
    ad.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bt.eGN() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = bb.asa();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    ad.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.CpK) });
    long l;
    ik localik;
    if (i < d.CpK)
    {
      if ((this.gNs == 702) || (this.gNs == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.e.vIY;
        if (this.gNs != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, false);
        localik = new ik();
        localik.CEa = paramInt;
        localik.CBi = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localik.CBh = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject1 = new dph();
        localik.CDY = ((dph)localObject1);
        ((dph)localObject1).CGu = "";
        ((dph)localObject1).CGt = "";
        ((dph)localObject1).EFs = "";
        localObject1 = new dtw();
        localik.CDZ = ((dtw)localObject1);
        ((dtw)localObject1).DyE = "";
        ((dtw)localObject1).DyD = "";
        if (g.afw()) {
          break label364;
        }
        ad.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.gNs == 702) || (this.gNs == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    g.afC();
    Object localObject1 = bt.nullAsNil((String)g.afB().afk().get(2, null));
    g.afC();
    Object localObject7 = new p(bt.a((Integer)g.afB().afk().get(9, null), 0));
    if (bt.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      g.afC();
      Object localObject2 = g.afz().aeA();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.gNs == 252) || (this.gNs == 701))
      {
        bool = true;
        localObject3 = ((com.tencent.mm.al.z)localObject2).a(l, "", bool);
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
        ad.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new SKBuiltinBuffer_t();
        if (!bt.cw((byte[])localObject3)) {
          break label894;
        }
        localObject2 = new byte[0];
        label561:
        localik.CDX = ((SKBuiltinBuffer_t)localObject7).setBuffer((byte[])localObject2);
        if ((this.gNs != 702) && (this.gNs != 763)) {
          break label1021;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new gz();
        localObject6 = new hc();
        ((j.a)localObject2).Cqm.CBX = ((hc)localObject6);
        ((j.a)localObject2).Cqm.CBY = ((gz)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label901;
        }
        paramInt = -1;
        ad.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = bt.aGd((String)localObject4);
        localObject4 = new ha();
        if (bt.cw((byte[])localObject7)) {
          break label943;
        }
        ((gz)localObject5).CBc = new SKBuiltinBuffer_t().setBuffer((byte[])localObject7);
        ad.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((gz)localObject5).CBc.getBuffer().wA.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((ha)localObject4).parseFrom((byte[])localObject7);
          if (((ha)localObject4).CBV == null) {
            break label978;
          }
          ((hc)localObject6).CBZ = ((ha)localObject4).CBV;
          ad.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ha)localObject4).CBV.getBuffer().wA.length), bt.cv(((ha)localObject4).CBV.getBuffer().wA) });
          ((gz)localObject5).CBN = localik;
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).hKD = ((String)localObject1);
          AppMethodBeat.o(132240);
          return this;
          bool = false;
          break;
          label874:
          paramInt = localObject3.length;
          break label495;
          label881:
          localObject2 = bt.aGs(bt.cv((byte[])localObject3));
          break label505;
          label894:
          localObject2 = localObject3;
          break label561;
          label901:
          paramInt = ((String)localObject4).length();
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 15L, 1L, false);
          ad.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label943:
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 16L, 1L, false);
        ((gz)localObject5).CBc = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        continue;
        label978:
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 17L, 1L, false);
        ((hc)localObject6).CBZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ad.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1021:
        localObject3 = (j.f)localObject6;
        localObject2 = new boq();
        localObject4 = new boo();
        ((j.f)localObject3).Cqq.DLX = ((boq)localObject2);
        ((j.f)localObject3).Cqq.DLY = ((boo)localObject4);
        ((boo)localObject4).DLW = 2;
        ((boo)localObject4).CBN = localik;
        ((boq)localObject2).mAQ = ((String)localObject1);
        g.afC();
        localObject1 = bt.nullAsNil((String)g.afB().afk().get(3, null));
        g.afC();
        ((boq)localObject2).CGf = bt.nullAsNil((String)g.afB().afk().get(19, null));
        ((boq)localObject2).CGs = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!g.afw())
    {
      ad.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    dfm localdfm = parami.Cqo;
    boolean bool;
    if ((localdfm != null) && (localdfm.EwP != null))
    {
      int i = parami.Cqo.EwP.CBr;
      ad.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      g.afC();
      g.afB().gcR.set(47, Integer.valueOf(i));
      com.tencent.mm.network.e locale = g.afA().gcy.gVH;
      if (locale != null)
      {
        if ((i & 0x1) != 0) {
          break label263;
        }
        bool = true;
        locale.el(bool);
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label384;
      }
      if ((paramInt1 != 4) || (paramInt2 != -301)) {
        break label309;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 18L, 1L, false);
      ad.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localdfm == null) || (localdfm.EwR == null)) {
        break label294;
      }
      a(true, parami.Cqo.EwR.CGh, parami.Cqo.EwR.CGi, parami.Cqo.EwR.CGg);
      AppMethodBeat.o(132243);
      return;
      label263:
      bool = false;
      break;
      ad.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(parami.getRetCode()) });
    }
    label294:
    ad.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
    AppMethodBeat.o(132243);
    return;
    label309:
    paramh = com.tencent.mm.plugin.report.e.vIY;
    if (f.CpT)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.e.vIY;
      if (!f.CpU) {
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
    if (gNv != null) {
      gNv.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int arZ()
  {
    AppMethodBeat.i(132241);
    if (g.afw())
    {
      g.afC();
      g.afz();
      int i = a.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    ad.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bt.eGN() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final com.tencent.mm.network.q da(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    com.tencent.mm.network.q localq = new ba(paramInt1).ni(paramInt2);
    AppMethodBeat.o(132242);
    return localq;
  }
  
  public final l.d getReqObjImp()
  {
    return this.gNt;
  }
  
  public final l.e getRespObj()
  {
    return this.gNu;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.gNt.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.gNt.getUri();
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
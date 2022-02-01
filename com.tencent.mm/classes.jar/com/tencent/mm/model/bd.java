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
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.bym;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.ccw;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.ecj;
import com.tencent.mm.protocal.protobuf.ehi;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.protocal.protobuf.pw;
import com.tencent.mm.protocal.protobuf.px;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bd
  extends l
  implements j.e
{
  private static a hJf = null;
  private final int hJc;
  private final j.h hJd;
  private final j.i hJe;
  
  public bd(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.hJc = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.hJd = new j.a();
      this.hJe = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.hJd = new j.f();
    this.hJe = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)paramq.getReqObj();
    j.i locali = (j.i)paramq.getRespObj();
    ae.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(locali.gxH), bu.fpN() });
    int i;
    if (locali.gxH != 0)
    {
      ae.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.gxH) });
      i = locali.gxH;
      AppMethodBeat.o(132248);
      return i;
    }
    drp localdrp = locali.FGl;
    int k = localdrp.HYr;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localdrp.HYs;
      j = ((gx)localObject1).FRG;
      ae.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((gx)localObject1).FRF) });
      arrayOfByte1 = com.tencent.mm.platformtools.z.a(((gx)localObject1).FRJ);
      arrayOfByte2 = com.tencent.mm.platformtools.z.a(((gx)localObject1).FRK);
      paramq = ((gx)localObject1).FRq;
      arrayOfByte3 = com.tencent.mm.platformtools.z.a(((gx)localObject1).FRr);
      int m = paramq.FSl.getILen();
      int n = paramq.Gwi;
      if (arrayOfByte3 == null)
      {
        i = -1;
        ae.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bu.aSM(bu.cE(arrayOfByte3)), bu.aSM(bu.cE(arrayOfByte1)), bu.aSM(bu.cE(arrayOfByte2)) });
        localObject1 = com.tencent.mm.platformtools.z.a(paramq.FSl);
        localObject2 = ((j.h)localObject2).FGk;
        if (bu.cF((byte[])localObject1)) {
          break label667;
        }
        m = localObject1.length;
        Object localObject3 = bu.aSM(bu.cE((byte[])localObject1));
        if (localObject2 != null) {
          break label654;
        }
        i = -1;
        label352:
        ae.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bu.aSM(bu.cE((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramq.Gwi, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramq = ((PByteArray)localObject3).value;
        if (paramq != null) {
          break label661;
        }
        i = -1;
        label431:
        ae.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bu.aSM(bu.cE(paramq)) });
        label467:
        if (paramq == null) {
          break label693;
        }
        localObject1 = paramq;
        label474:
        locali.FGp = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label800;
        }
        ae.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bu.cF(paramq)) {
          break label757;
        }
        paramq = MMProtocalJni.aesDecrypt(arrayOfByte3, paramq);
        if (arrayOfByte3 != null) {
          break label701;
        }
        i = -1;
        label515:
        localObject1 = bu.aSM(bu.cE(arrayOfByte3));
        if (paramq != null) {
          break label708;
        }
        j = -1;
        label531:
        ae.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bu.aSM(bu.cE(paramq)) });
        if (bu.cF(paramq)) {
          break label714;
        }
        ae.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bu.aSM(bu.cE(paramq)) });
        locali.b(paramq, arrayOfByte1, arrayOfByte2);
        locali.gxH = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.dvq = localdrp.HYt.nIJ;
      }
    }
    for (;;)
    {
      i = locali.gxH;
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
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 24L, 1L, false);
      ae.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
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
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 25L, 1L, false);
      ae.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.gxH = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 26L, 1L, false);
      ae.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.gxH = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 27L, 1L, false);
      ae.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.gxH = 1;
      break label615;
      ae.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localdrp.HYs });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.gxH = 2;
      break label615;
      label885:
      ae.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    hJf = parama;
  }
  
  public static void a(boolean paramBoolean, px parampx, ccw paramccw, bpj parambpj)
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
    if (parampx == null)
    {
      i = -1;
      if (parampx != null) {
        break label202;
      }
      j = -1;
      if (parambpj != null) {
        break label211;
      }
      k = -1;
      if (paramccw != null) {
        break label220;
      }
      m = -1;
      if (paramccw != null) {
        break label229;
      }
      n = -1;
      if (paramccw != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (paramccw != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (paramccw != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = paramccw.Hps)
    {
      ae.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((parambpj != null) && (parambpj.nIE != null) && (parambpj.nIE.size() > 0)) {
        break label265;
      }
      ae.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bu.fpN() });
      AppMethodBeat.o(132244);
      return;
      i = parampx.Gdw;
      break;
      label202:
      j = parampx.Gdx;
      break label20;
      label211:
      k = parambpj.nID;
      break label27;
      label220:
      m = paramccw.Hpt;
      break label34;
      label229:
      n = paramccw.Hpu;
      break label41;
      label238:
      i1 = paramccw.Hpv;
      break label48;
      label247:
      localObject1 = paramccw.Hpr;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (parampx != null)
    {
      localObject3 = parampx.GdA.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (pw)((Iterator)localObject3).next();
        localObject1 = "";
        if (((pw)localObject4).Gdv != null) {
          localObject1 = ((pw)localObject4).Gdv.fjO();
        }
        ((List)localObject2).add(new o(((pw)localObject4).type, ((pw)localObject4).Gdu.fjO(), ((pw)localObject4).port, (String)localObject1));
        ae.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((pw)localObject4).type), Integer.valueOf(((pw)localObject4).port), ((pw)localObject4).Gdu.fjO() });
      }
    }
    localObject2 = o.hr((List)localObject2);
    Object localObject1 = new LinkedList();
    if (parampx != null)
    {
      localObject3 = parampx.Gdz.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (pw)((Iterator)localObject3).next();
        parampx = "";
        if (((pw)localObject4).Gdv != null) {
          parampx = ((pw)localObject4).Gdv.fjO();
        }
        ((List)localObject1).add(new o(((pw)localObject4).type, ((pw)localObject4).Gdu.fjO(), ((pw)localObject4).port, parampx));
        ae.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((pw)localObject4).type), Integer.valueOf(((pw)localObject4).port), ((pw)localObject4).Gdu.fjO() });
      }
    }
    Object localObject3 = o.hr((List)localObject1);
    ae.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    g.ajS();
    g.ajR().gDO.set(2, localObject2);
    Object localObject4 = ak.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    g.ajS();
    g.ajR().gDO.set(3, localObject3);
    if (paramccw != null)
    {
      g.ajS();
      g.ajR().gDO.set(6, paramccw.Hpr);
      g.ajS();
      g.ajR().gDO.set(7, paramccw.Hps);
      if (paramccw.Hpv != 0)
      {
        g.ajS();
        parampx = g.ajR().gDO;
        if (paramccw.Hpv > 60)
        {
          i = 60;
          parampx.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        ah.z(paramccw.Hpt, paramccw.Hpw);
      }
    }
    for (parampx = o.lL(paramccw.Hpr, paramccw.Hps);; parampx = null)
    {
      paramccw = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[parambpj.nIE.size()];
      String[] arrayOfString2 = new String[parambpj.nIE.size()];
      int[] arrayOfInt = new int[parambpj.nIE.size()];
      ae.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(parambpj.nID) });
      Iterator localIterator = parambpj.nIE.iterator();
      i = 0;
      parambpj = (bpj)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (bpi)localIterator.next();
        ae.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((bpi)localObject1).HcU, ((bpi)localObject1).HcV });
        arrayOfString1[i] = ((bpi)localObject1).HcU;
        arrayOfString2[i] = ((bpi)localObject1).HcV;
        arrayOfInt[i] = ((bpi)localObject1).HcW;
        j = i + 1;
        i = j;
        if (!bu.isNullOrNil(((bpi)localObject1).HcU))
        {
          i = j;
          if (!bu.isNullOrNil(((bpi)localObject1).HcV))
          {
            if (((bpi)localObject1).HcU.equals("short.weixin.qq.com"))
            {
              g.ajS();
              g.ajR().gDO.set(24, ((bpi)localObject1).HcV);
              parambpj = ((bpi)localObject1).HcV;
              i = j;
              continue;
              i = paramccw.Hpv;
              break;
            }
            if (((bpi)localObject1).HcU.equals("long.weixin.qq.com"))
            {
              g.ajS();
              g.ajR().gDO.set(25, ((bpi)localObject1).HcV);
              paramccw = ((bpi)localObject1).HcV;
              i = j;
            }
            else
            {
              i = j;
              if (((bpi)localObject1).HcU.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!bu.isNullOrNil(((bpi)localObject1).HcV))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((bpi)localObject1).HcV).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      g.ajS();
      localObject1 = g.ajQ().gDv.hRo;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!bu.isNullOrNil(paramccw))
      {
        g.ajS();
        g.ajR().gDO.set(25, paramccw);
      }
      if (!bu.isNullOrNil(parambpj))
      {
        g.ajS();
        g.ajR().gDO.set(24, parambpj);
      }
      if ((localObject1 != null) && (parampx != null)) {
        ((com.tencent.mm.network.e)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, parampx.FGz, parampx.FGA, parampx.FGB, parampx.FGC, parambpj, paramccw);
      }
      AppMethodBeat.o(132244);
      return;
    }
  }
  
  public static SharedPreferences aCl()
  {
    AppMethodBeat.i(224418);
    SharedPreferences localSharedPreferences = be.aCl();
    AppMethodBeat.o(224418);
    return localSharedPreferences;
  }
  
  private com.tencent.mm.network.q oz(int paramInt)
  {
    AppMethodBeat.i(132240);
    ae.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bu.fpN() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = be.aCl();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    ae.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.FFH) });
    long l;
    ix localix;
    if (i < d.FFH)
    {
      if ((this.hJc == 702) || (this.hJc == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.e.ywz;
        if (this.hJc != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, false);
        localix = new ix();
        localix.FUr = paramInt;
        localix.FRy = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localix.FRx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject1 = new ecj();
        localix.FUp = ((ecj)localObject1);
        ((ecj)localObject1).FWL = "";
        ((ecj)localObject1).FWK = "";
        ((ecj)localObject1).IhI = "";
        localObject1 = new ehi();
        localix.FUq = ((ehi)localObject1);
        ((ehi)localObject1).GXa = "";
        ((ehi)localObject1).GWZ = "";
        if (g.ajM()) {
          break label364;
        }
        ae.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.hJc == 702) || (this.hJc == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    g.ajS();
    Object localObject1 = bu.nullAsNil((String)g.ajR().ajA().get(2, null));
    g.ajS();
    Object localObject7 = new p(bu.a((Integer)g.ajR().ajA().get(9, null), 0));
    if (bu.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      g.ajS();
      Object localObject2 = g.ajP().aiR();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.hJc == 252) || (this.hJc == 701))
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
        ae.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new SKBuiltinBuffer_t();
        if (!bu.cF((byte[])localObject3)) {
          break label894;
        }
        localObject2 = new byte[0];
        label561:
        localix.FUo = ((SKBuiltinBuffer_t)localObject7).setBuffer((byte[])localObject2);
        if ((this.hJc != 702) && (this.hJc != 763)) {
          break label1021;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new hk();
        localObject6 = new hn();
        ((j.a)localObject2).FGj.FSm = ((hn)localObject6);
        ((j.a)localObject2).FGj.FSn = ((hk)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label901;
        }
        paramInt = -1;
        ae.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = bu.aSx((String)localObject4);
        localObject4 = new hl();
        if (bu.cF((byte[])localObject7)) {
          break label943;
        }
        ((hk)localObject5).FRs = new SKBuiltinBuffer_t().setBuffer((byte[])localObject7);
        ae.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((hk)localObject5).FRs.getBuffer().zr.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((hl)localObject4).parseFrom((byte[])localObject7);
          if (((hl)localObject4).FSk == null) {
            break label978;
          }
          ((hn)localObject6).FSo = ((hl)localObject4).FSk;
          ae.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((hl)localObject4).FSk.getBuffer().zr.length), bu.cE(((hl)localObject4).FSk.getBuffer().zr) });
          ((hk)localObject5).FSd = localix;
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).dvq = ((String)localObject1);
          AppMethodBeat.o(132240);
          return this;
          bool = false;
          break;
          label874:
          paramInt = localObject3.length;
          break label495;
          label881:
          localObject2 = bu.aSM(bu.cE((byte[])localObject3));
          break label505;
          label894:
          localObject2 = localObject3;
          break label561;
          label901:
          paramInt = ((String)localObject4).length();
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 15L, 1L, false);
          ae.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label943:
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 16L, 1L, false);
        ((hk)localObject5).FRs = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        continue;
        label978:
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 17L, 1L, false);
        ((hn)localObject6).FSo = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ae.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1021:
        localObject3 = (j.f)localObject6;
        localObject2 = new byo();
        localObject4 = new bym();
        ((j.f)localObject3).FGn.Hlo = ((byo)localObject2);
        ((j.f)localObject3).FGn.Hlp = ((bym)localObject4);
        ((bym)localObject4).Hln = 2;
        ((bym)localObject4).FSd = localix;
        ((byo)localObject2).nIJ = ((String)localObject1);
        g.ajS();
        localObject1 = bu.nullAsNil((String)g.ajR().ajA().get(3, null));
        g.ajS();
        ((byo)localObject2).FWw = bu.nullAsNil((String)g.ajR().ajA().get(19, null));
        ((byo)localObject2).FWJ = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!g.ajM())
    {
      ae.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    drp localdrp = parami.FGl;
    boolean bool;
    if ((localdrp != null) && (localdrp.HYs != null))
    {
      int i = parami.FGl.HYs.FRH;
      ae.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      g.ajS();
      g.ajR().gDO.set(47, Integer.valueOf(i));
      com.tencent.mm.network.e locale = g.ajQ().gDv.hRo;
      if (locale != null)
      {
        if ((i & 0x1) != 0) {
          break label263;
        }
        bool = true;
        locale.eK(bool);
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label384;
      }
      if ((paramInt1 != 4) || (paramInt2 != -301)) {
        break label309;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 18L, 1L, false);
      ae.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localdrp == null) || (localdrp.HYu == null)) {
        break label294;
      }
      a(true, parami.FGl.HYu.FWy, parami.FGl.HYu.FWz, parami.FGl.HYu.FWx);
      AppMethodBeat.o(132243);
      return;
      label263:
      bool = false;
      break;
      ae.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(parami.getRetCode()) });
    }
    label294:
    ae.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
    AppMethodBeat.o(132243);
    return;
    label309:
    paramh = com.tencent.mm.plugin.report.e.ywz;
    if (f.FFQ)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.e.ywz;
      if (!f.FFR) {
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
    if (hJf != null) {
      hJf.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int aCk()
  {
    AppMethodBeat.i(132241);
    if (g.ajM())
    {
      g.ajS();
      g.ajP();
      int i = a.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    ae.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bu.fpN() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final com.tencent.mm.network.q dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    com.tencent.mm.network.q localq = new bd(paramInt1).oz(paramInt2);
    AppMethodBeat.o(132242);
    return localq;
  }
  
  public final l.d getReqObjImp()
  {
    return this.hJd;
  }
  
  public final l.e getRespObj()
  {
    return this.hJe;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.hJd.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.hJd.getUri();
    AppMethodBeat.o(132247);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.l;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
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
import com.tencent.mm.protocal.protobuf.afp;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.bxs;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.ccc;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.eas;
import com.tencent.mm.protocal.protobuf.efr;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ix;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.protocal.protobuf.pv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bb
  extends l
  implements j.e
{
  private static a hGn = null;
  private final int hGk;
  private final j.h hGl;
  private final j.i hGm;
  
  public bb(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.hGk = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.hGl = new j.a();
      this.hGm = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.hGl = new j.f();
    this.hGm = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(com.tencent.mm.network.q paramq)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)paramq.getReqObj();
    j.i locali = (j.i)paramq.getRespObj();
    ad.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(locali.gva), bt.flS() });
    int i;
    if (locali.gva != 0)
    {
      ad.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.gva) });
      i = locali.gva;
      AppMethodBeat.o(132248);
      return i;
    }
    dqs localdqs = locali.FnN;
    int k = localdqs.HEE;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localdqs.HEF;
      j = ((gx)localObject1).Fzi;
      ad.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((gx)localObject1).Fzh) });
      arrayOfByte1 = com.tencent.mm.platformtools.z.a(((gx)localObject1).Fzl);
      arrayOfByte2 = com.tencent.mm.platformtools.z.a(((gx)localObject1).Fzm);
      paramq = ((gx)localObject1).FyS;
      arrayOfByte3 = com.tencent.mm.platformtools.z.a(((gx)localObject1).FyT);
      int m = paramq.FzN.getILen();
      int n = paramq.GdB;
      if (arrayOfByte3 == null)
      {
        i = -1;
        ad.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bt.aRp(bt.cB(arrayOfByte3)), bt.aRp(bt.cB(arrayOfByte1)), bt.aRp(bt.cB(arrayOfByte2)) });
        localObject1 = com.tencent.mm.platformtools.z.a(paramq.FzN);
        localObject2 = ((j.h)localObject2).FnM;
        if (bt.cC((byte[])localObject1)) {
          break label667;
        }
        m = localObject1.length;
        Object localObject3 = bt.aRp(bt.cB((byte[])localObject1));
        if (localObject2 != null) {
          break label654;
        }
        i = -1;
        label352:
        ad.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bt.aRp(bt.cB((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramq.GdB, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramq = ((PByteArray)localObject3).value;
        if (paramq != null) {
          break label661;
        }
        i = -1;
        label431:
        ad.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bt.aRp(bt.cB(paramq)) });
        label467:
        if (paramq == null) {
          break label693;
        }
        localObject1 = paramq;
        label474:
        locali.FnR = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label800;
        }
        ad.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bt.cC(paramq)) {
          break label757;
        }
        paramq = MMProtocalJni.aesDecrypt(arrayOfByte3, paramq);
        if (arrayOfByte3 != null) {
          break label701;
        }
        i = -1;
        label515:
        localObject1 = bt.aRp(bt.cB(arrayOfByte3));
        if (paramq != null) {
          break label708;
        }
        j = -1;
        label531:
        ad.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bt.aRp(bt.cB(paramq)) });
        if (bt.cC(paramq)) {
          break label714;
        }
        ad.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bt.aRp(bt.cB(paramq)) });
        locali.b(paramq, arrayOfByte1, arrayOfByte2);
        locali.gva = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.dul = localdqs.HEG.nDo;
      }
    }
    for (;;)
    {
      i = locali.gva;
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 24L, 1L, false);
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 25L, 1L, false);
      ad.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.gva = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 26L, 1L, false);
      ad.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.gva = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 27L, 1L, false);
      ad.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.gva = 1;
      break label615;
      ad.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localdqs.HEF });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.gva = 2;
      break label615;
      label885:
      ad.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    hGn = parama;
  }
  
  public static void a(boolean paramBoolean, pv parampv, ccc paramccc, bor parambor)
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
    if (parampv == null)
    {
      i = -1;
      if (parampv != null) {
        break label202;
      }
      j = -1;
      if (parambor != null) {
        break label211;
      }
      k = -1;
      if (paramccc != null) {
        break label220;
      }
      m = -1;
      if (paramccc != null) {
        break label229;
      }
      n = -1;
      if (paramccc != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (paramccc != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (paramccc != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = paramccc.GVS)
    {
      ad.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((parambor != null) && (parambor.nDj != null) && (parambor.nDj.size() > 0)) {
        break label265;
      }
      ad.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bt.flS() });
      AppMethodBeat.o(132244);
      return;
      i = parampv.FKX;
      break;
      label202:
      j = parampv.FKY;
      break label20;
      label211:
      k = parambor.nDi;
      break label27;
      label220:
      m = paramccc.GVT;
      break label34;
      label229:
      n = paramccc.GVU;
      break label41;
      label238:
      i1 = paramccc.GVV;
      break label48;
      label247:
      localObject1 = paramccc.GVR;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (parampv != null)
    {
      localObject3 = parampv.FLb.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (pu)((Iterator)localObject3).next();
        localObject1 = "";
        if (((pu)localObject4).FKW != null) {
          localObject1 = ((pu)localObject4).FKW.ffY();
        }
        ((List)localObject2).add(new o(((pu)localObject4).type, ((pu)localObject4).FKV.ffY(), ((pu)localObject4).port, (String)localObject1));
        ad.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((pu)localObject4).type), Integer.valueOf(((pu)localObject4).port), ((pu)localObject4).FKV.ffY() });
      }
    }
    localObject2 = o.hh((List)localObject2);
    Object localObject1 = new LinkedList();
    if (parampv != null)
    {
      localObject3 = parampv.FLa.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (pu)((Iterator)localObject3).next();
        parampv = "";
        if (((pu)localObject4).FKW != null) {
          parampv = ((pu)localObject4).FKW.ffY();
        }
        ((List)localObject1).add(new o(((pu)localObject4).type, ((pu)localObject4).FKV.ffY(), ((pu)localObject4).port, parampv));
        ad.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((pu)localObject4).type), Integer.valueOf(((pu)localObject4).port), ((pu)localObject4).FKV.ffY() });
      }
    }
    Object localObject3 = o.hh((List)localObject1);
    ad.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    g.ajD();
    g.ajC().gBh.set(2, localObject2);
    Object localObject4 = aj.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    g.ajD();
    g.ajC().gBh.set(3, localObject3);
    if (paramccc != null)
    {
      g.ajD();
      g.ajC().gBh.set(6, paramccc.GVR);
      g.ajD();
      g.ajC().gBh.set(7, paramccc.GVS);
      if (paramccc.GVV != 0)
      {
        g.ajD();
        parampv = g.ajC().gBh;
        if (paramccc.GVV > 60)
        {
          i = 60;
          parampv.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        com.tencent.mm.network.ah.z(paramccc.GVT, paramccc.GVW);
      }
    }
    for (parampv = o.lE(paramccc.GVR, paramccc.GVS);; parampv = null)
    {
      paramccc = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[parambor.nDj.size()];
      String[] arrayOfString2 = new String[parambor.nDj.size()];
      int[] arrayOfInt = new int[parambor.nDj.size()];
      ad.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(parambor.nDi) });
      Iterator localIterator = parambor.nDj.iterator();
      i = 0;
      parambor = (bor)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (boq)localIterator.next();
        ad.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((boq)localObject1).GJt, ((boq)localObject1).GJu });
        arrayOfString1[i] = ((boq)localObject1).GJt;
        arrayOfString2[i] = ((boq)localObject1).GJu;
        arrayOfInt[i] = ((boq)localObject1).GJv;
        j = i + 1;
        i = j;
        if (!bt.isNullOrNil(((boq)localObject1).GJt))
        {
          i = j;
          if (!bt.isNullOrNil(((boq)localObject1).GJu))
          {
            if (((boq)localObject1).GJt.equals("short.weixin.qq.com"))
            {
              g.ajD();
              g.ajC().gBh.set(24, ((boq)localObject1).GJu);
              parambor = ((boq)localObject1).GJu;
              i = j;
              continue;
              i = paramccc.GVV;
              break;
            }
            if (((boq)localObject1).GJt.equals("long.weixin.qq.com"))
            {
              g.ajD();
              g.ajC().gBh.set(25, ((boq)localObject1).GJu);
              paramccc = ((boq)localObject1).GJu;
              i = j;
            }
            else
            {
              i = j;
              if (((boq)localObject1).GJt.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!bt.isNullOrNil(((boq)localObject1).GJu))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((boq)localObject1).GJu).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      g.ajD();
      localObject1 = g.ajB().gAO.hOv;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!bt.isNullOrNil(paramccc))
      {
        g.ajD();
        g.ajC().gBh.set(25, paramccc);
      }
      if (!bt.isNullOrNil(parambor))
      {
        g.ajD();
        g.ajC().gBh.set(24, parambor);
      }
      if ((localObject1 != null) && (parampv != null)) {
        ((com.tencent.mm.network.e)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, parampv.Fob, parampv.Foc, parampv.Fod, parampv.Foe, parambor, paramccc);
      }
      AppMethodBeat.o(132244);
      return;
    }
  }
  
  public static SharedPreferences aBV()
  {
    AppMethodBeat.i(221710);
    SharedPreferences localSharedPreferences = bc.aBV();
    AppMethodBeat.o(221710);
    return localSharedPreferences;
  }
  
  private com.tencent.mm.network.q ow(int paramInt)
  {
    AppMethodBeat.i(132240);
    ad.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bt.flS() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = bc.aBV();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    ad.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.Fnj) });
    long l;
    ix localix;
    if (i < d.Fnj)
    {
      if ((this.hGk == 702) || (this.hGk == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.e.ygI;
        if (this.hGk != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, false);
        localix = new ix();
        localix.FBW = paramInt;
        localix.Fza = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localix.FyZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject1 = new eas();
        localix.FBU = ((eas)localObject1);
        ((eas)localObject1).FEq = "";
        ((eas)localObject1).FEp = "";
        ((eas)localObject1).HNB = "";
        localObject1 = new efr();
        localix.FBV = ((efr)localObject1);
        ((efr)localObject1).GDx = "";
        ((efr)localObject1).GDw = "";
        if (g.ajx()) {
          break label364;
        }
        ad.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.hGk == 702) || (this.hGk == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    g.ajD();
    Object localObject1 = bt.nullAsNil((String)g.ajC().ajl().get(2, null));
    g.ajD();
    Object localObject7 = new p(bt.a((Integer)g.ajC().ajl().get(9, null), 0));
    if (bt.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      g.ajD();
      Object localObject2 = g.ajA().aiC();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.hGk == 252) || (this.hGk == 701))
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
        if (!bt.cC((byte[])localObject3)) {
          break label894;
        }
        localObject2 = new byte[0];
        label561:
        localix.FBT = ((SKBuiltinBuffer_t)localObject7).setBuffer((byte[])localObject2);
        if ((this.hGk != 702) && (this.hGk != 763)) {
          break label1021;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new hk();
        localObject6 = new hn();
        ((j.a)localObject2).FnL.FzO = ((hn)localObject6);
        ((j.a)localObject2).FnL.FzP = ((hk)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label901;
        }
        paramInt = -1;
        ad.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = bt.aRa((String)localObject4);
        localObject4 = new hl();
        if (bt.cC((byte[])localObject7)) {
          break label943;
        }
        ((hk)localObject5).FyU = new SKBuiltinBuffer_t().setBuffer((byte[])localObject7);
        ad.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((hk)localObject5).FyU.getBuffer().zr.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((hl)localObject4).parseFrom((byte[])localObject7);
          if (((hl)localObject4).FzM == null) {
            break label978;
          }
          ((hn)localObject6).FzQ = ((hl)localObject4).FzM;
          ad.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((hl)localObject4).FzM.getBuffer().zr.length), bt.cB(((hl)localObject4).FzM.getBuffer().zr) });
          ((hk)localObject5).FzF = localix;
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).dul = ((String)localObject1);
          AppMethodBeat.o(132240);
          return this;
          bool = false;
          break;
          label874:
          paramInt = localObject3.length;
          break label495;
          label881:
          localObject2 = bt.aRp(bt.cB((byte[])localObject3));
          break label505;
          label894:
          localObject2 = localObject3;
          break label561;
          label901:
          paramInt = ((String)localObject4).length();
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 15L, 1L, false);
          ad.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label943:
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 16L, 1L, false);
        ((hk)localObject5).FyU = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        continue;
        label978:
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 17L, 1L, false);
        ((hn)localObject6).FzQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ad.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1021:
        localObject3 = (j.f)localObject6;
        localObject2 = new bxu();
        localObject4 = new bxs();
        ((j.f)localObject3).FnP.GRN = ((bxu)localObject2);
        ((j.f)localObject3).FnP.GRO = ((bxs)localObject4);
        ((bxs)localObject4).GRM = 2;
        ((bxs)localObject4).FzF = localix;
        ((bxu)localObject2).nDo = ((String)localObject1);
        g.ajD();
        localObject1 = bt.nullAsNil((String)g.ajC().ajl().get(3, null));
        g.ajD();
        ((bxu)localObject2).FEb = bt.nullAsNil((String)g.ajC().ajl().get(19, null));
        ((bxu)localObject2).FEo = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!g.ajx())
    {
      ad.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    dqs localdqs = parami.FnN;
    boolean bool;
    if ((localdqs != null) && (localdqs.HEF != null))
    {
      int i = parami.FnN.HEF.Fzj;
      ad.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      g.ajD();
      g.ajC().gBh.set(47, Integer.valueOf(i));
      com.tencent.mm.network.e locale = g.ajB().gAO.hOv;
      if (locale != null)
      {
        if ((i & 0x1) != 0) {
          break label263;
        }
        bool = true;
        locale.eI(bool);
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
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 18L, 1L, false);
      ad.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localdqs == null) || (localdqs.HEH == null)) {
        break label294;
      }
      a(true, parami.FnN.HEH.FEd, parami.FnN.HEH.FEe, parami.FnN.HEH.FEc);
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
    paramh = com.tencent.mm.plugin.report.e.ygI;
    if (f.Fns)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.e.ygI;
      if (!f.Fnt) {
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
    if (hGn != null) {
      hGn.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int aBU()
  {
    AppMethodBeat.i(132241);
    if (g.ajx())
    {
      g.ajD();
      g.ajA();
      int i = a.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    ad.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bt.flS() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final com.tencent.mm.network.q dc(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    com.tencent.mm.network.q localq = new bb(paramInt1).ow(paramInt2);
    AppMethodBeat.o(132242);
    return localq;
  }
  
  public final l.d getReqObjImp()
  {
    return this.hGl;
  }
  
  public final l.e getRespObj()
  {
    return this.hGm;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.hGl.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.hGl.getUri();
    AppMethodBeat.o(132247);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bb
 * JD-Core Version:    0.7.0.1
 */
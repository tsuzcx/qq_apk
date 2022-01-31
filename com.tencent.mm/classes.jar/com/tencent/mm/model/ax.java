package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ae;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
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
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.bcd;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.bft;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cvg;
import com.tencent.mm.protocal.protobuf.czg;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gd;
import com.tencent.mm.protocal.protobuf.ge;
import com.tencent.mm.protocal.protobuf.gg;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.protocal.protobuf.mf;
import com.tencent.mm.protocal.protobuf.mg;
import com.tencent.mm.protocal.protobuf.zd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ax
  extends k
  implements j.e
{
  private static a fmh = null;
  private final int fme;
  private final j.h fmf;
  private final j.i fmg;
  
  public ax(int paramInt)
  {
    AppMethodBeat.i(58095);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.fme = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.fmf = new j.a();
      this.fmg = new j.b();
      AppMethodBeat.o(58095);
      return;
    }
    this.fmf = new j.f();
    this.fmg = new j.g();
    AppMethodBeat.o(58095);
  }
  
  public static int a(q paramq)
  {
    AppMethodBeat.i(58104);
    Object localObject2 = (j.h)paramq.getReqObj();
    j.i locali = (j.i)paramq.getRespObj();
    ab.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(locali.eBe), bo.dtY() });
    int i;
    if (locali.eBe != 0)
    {
      ab.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.eBe) });
      i = locali.eBe;
      AppMethodBeat.o(58104);
      return i;
    }
    cmm localcmm = locali.wil;
    int k = localcmm.xWl;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localcmm.xWm;
      j = ((ft)localObject1).wrZ;
      ab.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((ft)localObject1).wrY) });
      arrayOfByte1 = aa.a(((ft)localObject1).wsc);
      arrayOfByte2 = aa.a(((ft)localObject1).wsd);
      paramq = ((ft)localObject1).wrJ;
      arrayOfByte3 = aa.a(((ft)localObject1).wrK);
      int m = paramq.wsu.getILen();
      int n = paramq.wQb;
      if (arrayOfByte3 == null)
      {
        i = -1;
        ab.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bo.aqg(bo.cd(arrayOfByte3)), bo.aqg(bo.cd(arrayOfByte1)), bo.aqg(bo.cd(arrayOfByte2)) });
        localObject1 = aa.a(paramq.wsu);
        localObject2 = ((j.h)localObject2).wik;
        if (bo.ce((byte[])localObject1)) {
          break label667;
        }
        m = localObject1.length;
        Object localObject3 = bo.aqg(bo.cd((byte[])localObject1));
        if (localObject2 != null) {
          break label654;
        }
        i = -1;
        label352:
        ab.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bo.aqg(bo.cd((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramq.wQb, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramq = ((PByteArray)localObject3).value;
        if (paramq != null) {
          break label661;
        }
        i = -1;
        label431:
        ab.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bo.aqg(bo.cd(paramq)) });
        label467:
        if (paramq == null) {
          break label693;
        }
        localObject1 = paramq;
        label474:
        locali.wip = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label800;
        }
        ab.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bo.ce(paramq)) {
          break label757;
        }
        paramq = MMProtocalJni.aesDecrypt(arrayOfByte3, paramq);
        if (arrayOfByte3 != null) {
          break label701;
        }
        i = -1;
        label515:
        localObject1 = bo.aqg(bo.cd(arrayOfByte3));
        if (paramq != null) {
          break label708;
        }
        j = -1;
        label531:
        ab.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bo.aqg(bo.cd(paramq)) });
        if (bo.ce(paramq)) {
          break label714;
        }
        ab.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bo.aqg(bo.cd(paramq)) });
        locali.b(paramq, arrayOfByte1, arrayOfByte2);
        locali.eBe = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.gde = localcmm.xWn.jJA;
      }
    }
    for (;;)
    {
      i = locali.eBe;
      AppMethodBeat.o(58104);
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
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 24L, 1L, false);
      ab.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
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
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 25L, 1L, false);
      ab.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.eBe = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 26L, 1L, false);
      ab.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.eBe = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 27L, 1L, false);
      ab.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.eBe = 1;
      break label615;
      ab.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localcmm.xWm });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.eBe = 2;
      break label615;
      label885:
      ab.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    fmh = parama;
  }
  
  public static void a(boolean paramBoolean, mg parammg, bft parambft, avk paramavk)
  {
    AppMethodBeat.i(58100);
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
    if (parammg == null)
    {
      i = -1;
      if (parammg != null) {
        break label202;
      }
      j = -1;
      if (paramavk != null) {
        break label211;
      }
      k = -1;
      if (parambft != null) {
        break label220;
      }
      m = -1;
      if (parambft != null) {
        break label229;
      }
      n = -1;
      if (parambft != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (parambft != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (parambft != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = parambft.xuH)
    {
      ab.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((paramavk != null) && (paramavk.jJv != null) && (paramavk.jJv.size() > 0)) {
        break label265;
      }
      ab.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bo.dtY() });
      AppMethodBeat.o(58100);
      return;
      i = parammg.wAI;
      break;
      label202:
      j = parammg.wAJ;
      break label20;
      label211:
      k = paramavk.jJu;
      break label27;
      label220:
      m = parambft.xuI;
      break label34;
      label229:
      n = parambft.xuJ;
      break label41;
      label238:
      i1 = parambft.xuK;
      break label48;
      label247:
      localObject1 = parambft.xuG;
      break label57;
    }
    label265:
    if ((paramavk == null) || (paramavk.jJv == null) || (paramavk.jJv.size() <= 0))
    {
      ab.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bo.dtY() });
      AppMethodBeat.o(58100);
      return;
    }
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (parammg != null)
    {
      localObject3 = parammg.wAM.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (mf)((Iterator)localObject3).next();
        localObject1 = "";
        if (((mf)localObject4).wAH != null) {
          localObject1 = ((mf)localObject4).wAH.dqj();
        }
        ((List)localObject2).add(new o(((mf)localObject4).type, ((mf)localObject4).wAG.dqj(), ((mf)localObject4).port, (String)localObject1));
        ab.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((mf)localObject4).type), Integer.valueOf(((mf)localObject4).port), ((mf)localObject4).wAG.dqj() });
      }
    }
    localObject2 = o.eq((List)localObject2);
    Object localObject1 = new LinkedList();
    if (parammg != null)
    {
      localObject3 = parammg.wAL.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (mf)((Iterator)localObject3).next();
        parammg = "";
        if (((mf)localObject4).wAH != null) {
          parammg = ((mf)localObject4).wAH.dqj();
        }
        ((List)localObject1).add(new o(((mf)localObject4).type, ((mf)localObject4).wAG.dqj(), ((mf)localObject4).port, parammg));
        ab.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((mf)localObject4).type), Integer.valueOf(((mf)localObject4).port), ((mf)localObject4).wAG.dqj() });
      }
    }
    Object localObject3 = o.eq((List)localObject1);
    ab.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    g.RM();
    g.RL().eHM.set(2, localObject2);
    Object localObject4 = ah.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    g.RM();
    g.RL().eHM.set(3, localObject3);
    if (parambft != null)
    {
      g.RM();
      g.RL().eHM.set(6, parambft.xuG);
      g.RM();
      g.RL().eHM.set(7, parambft.xuH);
      if (parambft.xuK != 0)
      {
        g.RM();
        parammg = g.RL().eHM;
        if (parambft.xuK > 60)
        {
          i = 60;
          parammg.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        ae.A(parambft.xuI, parambft.xuL);
      }
    }
    for (parammg = o.ib(parambft.xuG, parambft.xuH);; parammg = null)
    {
      parambft = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[paramavk.jJv.size()];
      String[] arrayOfString2 = new String[paramavk.jJv.size()];
      int[] arrayOfInt = new int[paramavk.jJv.size()];
      ab.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(paramavk.jJu) });
      Iterator localIterator = paramavk.jJv.iterator();
      i = 0;
      paramavk = (avk)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1193;
        }
        localObject1 = (avj)localIterator.next();
        ab.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((avj)localObject1).xkP, ((avj)localObject1).xkQ });
        arrayOfString1[i] = ((avj)localObject1).xkP;
        arrayOfString2[i] = ((avj)localObject1).xkQ;
        arrayOfInt[i] = ((avj)localObject1).xkR;
        j = i + 1;
        i = j;
        if (!bo.isNullOrNil(((avj)localObject1).xkP))
        {
          i = j;
          if (!bo.isNullOrNil(((avj)localObject1).xkQ))
          {
            if (((avj)localObject1).xkP.equals("short.weixin.qq.com"))
            {
              g.RM();
              g.RL().eHM.set(24, ((avj)localObject1).xkQ);
              paramavk = ((avj)localObject1).xkQ;
              i = j;
              continue;
              i = parambft.xuK;
              break;
            }
            if (((avj)localObject1).xkP.equals("long.weixin.qq.com"))
            {
              g.RM();
              g.RL().eHM.set(25, ((avj)localObject1).xkQ);
              parambft = ((avj)localObject1).xkQ;
              i = j;
            }
            else
            {
              i = j;
              if (((avj)localObject1).xkP.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!bo.isNullOrNil(((avj)localObject1).xkQ))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((avj)localObject1).xkQ).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1193:
      g.RM();
      localObject1 = g.RK().eHt.ftA;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!bo.isNullOrNil(parambft))
      {
        g.RM();
        g.RL().eHM.set(25, parambft);
      }
      if (!bo.isNullOrNil(paramavk))
      {
        g.RM();
        g.RL().eHM.set(24, paramavk);
      }
      if ((localObject1 != null) && (parammg != null)) {
        ((com.tencent.mm.network.e)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, parammg.wiy, parammg.wiz, parammg.wiA, parammg.wiB, paramavk, parambft);
      }
      AppMethodBeat.o(58100);
      return;
    }
  }
  
  public static SharedPreferences aaF()
  {
    AppMethodBeat.i(156839);
    SharedPreferences localSharedPreferences = ay.aaF();
    AppMethodBeat.o(156839);
    return localSharedPreferences;
  }
  
  private q kC(int paramInt)
  {
    AppMethodBeat.i(58096);
    ab.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bo.dtY() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = ay.aaF();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    ab.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.whH) });
    long l;
    hm localhm;
    if (i < d.whH)
    {
      if ((this.fme == 702) || (this.fme == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.e.qrI;
        if (this.fme != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, false);
        localhm = new hm();
        localhm.wuk = paramInt;
        localhm.wrR = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localhm.wrQ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject1 = new cvg();
        localhm.wui = ((cvg)localObject1);
        ((cvg)localObject1).wwl = "";
        ((cvg)localObject1).wwk = "";
        ((cvg)localObject1).ydL = "";
        localObject1 = new czg();
        localhm.wuj = ((czg)localObject1);
        ((czg)localObject1).xfJ = "";
        ((czg)localObject1).xfI = "";
        if (g.RG()) {
          break label364;
        }
        ab.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(58096);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.fme == 702) || (this.fme == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    g.RM();
    Object localObject1 = bo.nullAsNil((String)g.RL().Ru().get(2, null));
    g.RM();
    Object localObject7 = new com.tencent.mm.a.p(bo.a((Integer)g.RL().Ru().get(9, null), 0));
    if (bo.isNullOrNil((String)localObject1)) {
      localObject1 = ((com.tencent.mm.a.p)localObject7).toString();
    }
    for (;;)
    {
      g.RM();
      Object localObject2 = g.RJ().QN();
      l = ((com.tencent.mm.a.p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.fme == 252) || (this.fme == 701))
      {
        bool = true;
        localObject3 = ((com.tencent.mm.ai.y)localObject2).a(l, "", bool);
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
        ab.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new SKBuiltinBuffer_t();
        if (!bo.ce((byte[])localObject3)) {
          break label894;
        }
        localObject2 = new byte[0];
        label561:
        localhm.wuh = ((SKBuiltinBuffer_t)localObject7).setBuffer((byte[])localObject2);
        if ((this.fme != 702) && (this.fme != 763)) {
          break label1021;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new gd();
        localObject6 = new gg();
        ((j.a)localObject2).wij.wsv = ((gg)localObject6);
        ((j.a)localObject2).wij.wsw = ((gd)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label901;
        }
        paramInt = -1;
        ab.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = bo.apQ((String)localObject4);
        localObject4 = new ge();
        if (bo.ce((byte[])localObject7)) {
          break label943;
        }
        ((gd)localObject5).wrL = new SKBuiltinBuffer_t().setBuffer((byte[])localObject7);
        ab.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((gd)localObject5).wrL.getBuffer().pW.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((ge)localObject4).parseFrom((byte[])localObject7);
          if (((ge)localObject4).wst == null) {
            break label978;
          }
          ((gg)localObject6).wsx = ((ge)localObject4).wst;
          ab.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ge)localObject4).wst.getBuffer().pW.length), bo.cd(((ge)localObject4).wst.getBuffer().pW) });
          ((gd)localObject5).wsm = localhm;
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).gde = ((String)localObject1);
          AppMethodBeat.o(58096);
          return this;
          bool = false;
          break;
          label874:
          paramInt = localObject3.length;
          break label495;
          label881:
          localObject2 = bo.aqg(bo.cd((byte[])localObject3));
          break label505;
          label894:
          localObject2 = localObject3;
          break label561;
          label901:
          paramInt = ((String)localObject4).length();
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 15L, 1L, false);
          ab.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label943:
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 16L, 1L, false);
        ((gd)localObject5).wrL = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        continue;
        label978:
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 17L, 1L, false);
        ((gg)localObject6).wsx = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        ab.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1021:
        localObject3 = (j.f)localObject6;
        localObject2 = new bcf();
        localObject4 = new bcd();
        ((j.f)localObject3).win.xrm = ((bcf)localObject2);
        ((j.f)localObject3).win.xrn = ((bcd)localObject4);
        ((bcd)localObject4).xrl = 2;
        ((bcd)localObject4).wsm = localhm;
        ((bcf)localObject2).jJA = ((String)localObject1);
        g.RM();
        localObject1 = bo.nullAsNil((String)g.RL().Ru().get(3, null));
        g.RM();
        ((bcf)localObject2).wvW = bo.nullAsNil((String)g.RL().Ru().get(19, null));
        ((bcf)localObject2).wwj = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(58099);
    if (!g.RG())
    {
      ab.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(58099);
      return;
    }
    cmm localcmm = parami.wil;
    boolean bool;
    if ((localcmm != null) && (localcmm.xWm != null))
    {
      int i = parami.wil.xWm.wsa;
      ab.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      g.RM();
      g.RL().eHM.set(47, Integer.valueOf(i));
      com.tencent.mm.network.e locale = g.RK().eHt.ftA;
      if (locale != null)
      {
        if ((i & 0x1) != 0) {
          break label263;
        }
        bool = true;
        locale.cT(bool);
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label384;
      }
      if ((paramInt1 != 4) || (paramInt2 != -301)) {
        break label309;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 18L, 1L, false);
      ab.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localcmm == null) || (localcmm.xWo == null)) {
        break label294;
      }
      a(true, parami.wil.xWo.wvY, parami.wil.xWo.wvZ, parami.wil.xWo.wvX);
      AppMethodBeat.o(58099);
      return;
      label263:
      bool = false;
      break;
      ab.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(parami.getRetCode()) });
    }
    label294:
    ab.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
    AppMethodBeat.o(58099);
    return;
    label309:
    paramh = com.tencent.mm.plugin.report.e.qrI;
    if (f.whQ)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.e.qrI;
      if (!f.whR) {
        break label376;
      }
    }
    label376:
    for (long l = 121L;; l = 122L)
    {
      paramh.idkeyStat(148L, l, 1L, false);
      AppMethodBeat.o(58099);
      return;
      l = 120L;
      break;
    }
    label384:
    if (fmh != null) {
      fmh.a(paramh, parami);
    }
    AppMethodBeat.o(58099);
  }
  
  public final int aaE()
  {
    AppMethodBeat.i(58097);
    if (g.RG())
    {
      g.RM();
      g.RJ();
      int i = a.getUin();
      AppMethodBeat.o(58097);
      return i;
    }
    ab.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bo.dtY() });
    AppMethodBeat.o(58097);
    return 0;
  }
  
  public final q cr(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(58098);
    q localq = new ax(paramInt1).kC(paramInt2);
    AppMethodBeat.o(58098);
    return localq;
  }
  
  public final l.d getReqObjImp()
  {
    return this.fmf;
  }
  
  public final l.e getRespObj()
  {
    return this.fmg;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(58102);
    int i = this.fmf.getFuncId();
    AppMethodBeat.o(58102);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(58103);
    String str = this.fmf.getUri();
    AppMethodBeat.o(58103);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.ax
 * JD-Core Version:    0.7.0.1
 */
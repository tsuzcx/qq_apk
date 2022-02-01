package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.aj;
import com.tencent.mm.network.c;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
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
import com.tencent.mm.protocal.o.a;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aif;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.cme;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.ctb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ewr;
import com.tencent.mm.protocal.protobuf.fca;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.hy;
import com.tencent.mm.protocal.protobuf.ia;
import com.tencent.mm.protocal.protobuf.jk;
import com.tencent.mm.protocal.protobuf.qx;
import com.tencent.mm.protocal.protobuf.qy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bh
  extends com.tencent.mm.ak.o
  implements j.e
{
  private static a iDP = null;
  private final int iDM;
  private final j.h iDN;
  private final j.i iDO;
  
  public bh(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.iDM = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.iDN = new j.a();
      this.iDO = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.iDN = new j.f();
    this.iDO = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(s params)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)params.getReqObj();
    j.i locali = (j.i)params.getRespObj();
    Log.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(params.hashCode()), Integer.valueOf(locali.hku), Util.getStack() });
    int i;
    if (locali.hku != 0)
    {
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.hku) });
      i = locali.hku;
      AppMethodBeat.o(132248);
      return i;
    }
    ell localell = locali.Kzw;
    int k = localell.Nkx;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localell.Nky;
      j = ((hk)localObject1).KLn;
      Log.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((hk)localObject1).KLm) });
      arrayOfByte1 = z.a(((hk)localObject1).KLq);
      arrayOfByte2 = z.a(((hk)localObject1).KLr);
      params = ((hk)localObject1).KKX;
      arrayOfByte3 = z.a(((hk)localObject1).KKY);
      int m = params.KLU.getILen();
      int n = params.LrO;
      if (arrayOfByte3 == null)
      {
        i = -1;
        Log.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Util.secPrint(Util.dumpHex(arrayOfByte3)), Util.secPrint(Util.dumpHex(arrayOfByte1)), Util.secPrint(Util.dumpHex(arrayOfByte2)) });
        localObject1 = z.a(params.KLU);
        localObject2 = ((j.h)localObject2).Kzv;
        if (Util.isNullOrNil((byte[])localObject1)) {
          break label667;
        }
        m = localObject1.length;
        Object localObject3 = Util.secPrint(Util.dumpHex((byte[])localObject1));
        if (localObject2 != null) {
          break label654;
        }
        i = -1;
        label352:
        Log.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), Util.secPrint(Util.dumpHex((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(params.LrO, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        params = ((PByteArray)localObject3).value;
        if (params != null) {
          break label661;
        }
        i = -1;
        label431:
        Log.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), Util.secPrint(Util.dumpHex(params)) });
        label467:
        if (params == null) {
          break label693;
        }
        localObject1 = params;
        label474:
        locali.KzA = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label800;
        }
        Log.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (Util.isNullOrNil(params)) {
          break label757;
        }
        params = MMProtocalJni.aesDecrypt(arrayOfByte3, params);
        if (arrayOfByte3 != null) {
          break label701;
        }
        i = -1;
        label515:
        localObject1 = Util.secPrint(Util.dumpHex(arrayOfByte3));
        if (params != null) {
          break label708;
        }
        j = -1;
        label531:
        Log.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), Util.secPrint(Util.dumpHex(params)) });
        if (Util.isNullOrNil(params)) {
          break label714;
        }
        Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { Util.secPrint(Util.dumpHex(params)) });
        locali.b(params, arrayOfByte1, arrayOfByte2);
        locali.hku = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.dMW = localell.Nkz.UserName;
      }
    }
    for (;;)
    {
      i = locali.hku;
      AppMethodBeat.o(132248);
      return i;
      i = arrayOfByte3.length;
      break;
      label654:
      i = localObject2.length;
      break label352;
      label661:
      i = params.length;
      break label431;
      label667:
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 24L, 1L, false);
      Log.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
      params = null;
      break label467;
      label693:
      localObject1 = new byte[0];
      break label474;
      label701:
      i = arrayOfByte3.length;
      break label515;
      label708:
      j = params.length;
      break label531;
      label714:
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 25L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.hku = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 26L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.hku = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 27L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.hku = 1;
      break label615;
      Log.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localell.Nky });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.hku = 2;
      break label615;
      label885:
      Log.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    iDP = parama;
  }
  
  public static void a(boolean paramBoolean, qy paramqy, ctb paramctb, ccb paramccb)
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
    if (paramqy == null)
    {
      i = -1;
      if (paramqy != null) {
        break label202;
      }
      j = -1;
      if (paramccb != null) {
        break label211;
      }
      k = -1;
      if (paramctb != null) {
        break label220;
      }
      m = -1;
      if (paramctb != null) {
        break label229;
      }
      n = -1;
      if (paramctb != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (paramctb != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (paramctb != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = paramctb.MxZ)
    {
      Log.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((paramccb != null) && (paramccb.oTA != null) && (paramccb.oTA.size() > 0)) {
        break label265;
      }
      Log.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(132244);
      return;
      i = paramqy.KXN;
      break;
      label202:
      j = paramqy.KXO;
      break label20;
      label211:
      k = paramccb.oTz;
      break label27;
      label220:
      m = paramctb.Mya;
      break label34;
      label229:
      n = paramctb.Myb;
      break label41;
      label238:
      i1 = paramctb.Myc;
      break label48;
      label247:
      localObject1 = paramctb.MxY;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (paramqy != null)
    {
      localObject3 = paramqy.KXR.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (qx)((Iterator)localObject3).next();
        localObject1 = "";
        if (((qx)localObject4).KXM != null) {
          localObject1 = ((qx)localObject4).KXM.yO();
        }
        ((List)localObject2).add(new com.tencent.mm.protocal.o(((qx)localObject4).type, ((qx)localObject4).KXL.yO(), ((qx)localObject4).port, (String)localObject1));
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((qx)localObject4).type), Integer.valueOf(((qx)localObject4).port), ((qx)localObject4).KXL.yO() });
      }
    }
    localObject2 = com.tencent.mm.protocal.o.iz((List)localObject2);
    Object localObject1 = new LinkedList();
    if (paramqy != null)
    {
      localObject3 = paramqy.KXQ.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (qx)((Iterator)localObject3).next();
        paramqy = "";
        if (((qx)localObject4).KXM != null) {
          paramqy = ((qx)localObject4).KXM.yO();
        }
        ((List)localObject1).add(new com.tencent.mm.protocal.o(((qx)localObject4).type, ((qx)localObject4).KXL.yO(), ((qx)localObject4).port, paramqy));
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((qx)localObject4).type), Integer.valueOf(((qx)localObject4).port), ((qx)localObject4).KXL.yO() });
      }
    }
    Object localObject3 = com.tencent.mm.protocal.o.iz((List)localObject1);
    Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().hqB.set(2, localObject2);
    Object localObject4 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    com.tencent.mm.kernel.g.aAi();
    com.tencent.mm.kernel.g.aAh().hqB.set(3, localObject3);
    if (paramctb != null)
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(6, paramctb.MxY);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(7, paramctb.MxZ);
      if (paramctb.Myc != 0)
      {
        com.tencent.mm.kernel.g.aAi();
        paramqy = com.tencent.mm.kernel.g.aAh().hqB;
        if (paramctb.Myc > 60)
        {
          i = 60;
          paramqy.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        aj.E(paramctb.Mya, paramctb.Myd);
      }
    }
    for (paramqy = com.tencent.mm.protocal.o.mJ(paramctb.MxY, paramctb.MxZ);; paramqy = null)
    {
      paramctb = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[paramccb.oTA.size()];
      String[] arrayOfString2 = new String[paramccb.oTA.size()];
      int[] arrayOfInt = new int[paramccb.oTA.size()];
      Log.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(paramccb.oTz) });
      Iterator localIterator = paramccb.oTA.iterator();
      i = 0;
      paramccb = (ccb)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (cca)localIterator.next();
        Log.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((cca)localObject1).MhX, ((cca)localObject1).MhY });
        arrayOfString1[i] = ((cca)localObject1).MhX;
        arrayOfString2[i] = ((cca)localObject1).MhY;
        arrayOfInt[i] = ((cca)localObject1).MhZ;
        j = i + 1;
        i = j;
        if (!Util.isNullOrNil(((cca)localObject1).MhX))
        {
          i = j;
          if (!Util.isNullOrNil(((cca)localObject1).MhY))
          {
            if (((cca)localObject1).MhX.equals(c.jDI))
            {
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().hqB.set(24, ((cca)localObject1).MhY);
              paramccb = ((cca)localObject1).MhY;
              i = j;
              continue;
              i = paramctb.Myc;
              break;
            }
            if (((cca)localObject1).MhX.equals(c.jDG))
            {
              com.tencent.mm.kernel.g.aAi();
              com.tencent.mm.kernel.g.aAh().hqB.set(25, ((cca)localObject1).MhY);
              paramctb = ((cca)localObject1).MhY;
              i = j;
            }
            else
            {
              i = j;
              if (((cca)localObject1).MhX.equals(c.icB))
              {
                i = j;
                if (!Util.isNullOrNil(((cca)localObject1).MhY))
                {
                  ((SharedPreferences)localObject4).edit().putString(c.icB, ((cca)localObject1).MhY).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      com.tencent.mm.kernel.g.aAi();
      localObject1 = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.g)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!Util.isNullOrNil(paramctb))
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().hqB.set(25, paramctb);
      }
      if (!Util.isNullOrNil(paramccb))
      {
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAh().hqB.set(24, paramccb);
      }
      if ((localObject1 != null) && (paramqy != null)) {
        ((com.tencent.mm.network.g)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, paramqy.KzK, paramqy.KzL, paramqy.KzM, paramqy.KzN, paramccb, paramctb);
      }
      AppMethodBeat.o(132244);
      return;
    }
  }
  
  public static SharedPreferences aVK()
  {
    AppMethodBeat.i(258483);
    SharedPreferences localSharedPreferences = bi.aVK();
    AppMethodBeat.o(258483);
    return localSharedPreferences;
  }
  
  private s sa(int paramInt)
  {
    AppMethodBeat.i(132240);
    Log.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Util.getStack() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = bi.aVK();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    Log.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.KyO) });
    long l;
    jk localjk;
    if (i < d.KyO)
    {
      if ((this.iDM == 702) || (this.iDM == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.e.Cxv;
        if (this.iDM != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, false);
        localjk = new jk();
        localjk.KOa = paramInt;
        localjk.KLf = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localjk.KLe = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        localObject1 = new ewr();
        localjk.KNY = ((ewr)localObject1);
        ((ewr)localObject1).KQx = "";
        ((ewr)localObject1).KQw = "";
        ((ewr)localObject1).Num = "";
        localObject1 = new fca();
        localjk.KNZ = ((fca)localObject1);
        ((fca)localObject1).MbK = "";
        ((fca)localObject1).MbJ = "";
        if (com.tencent.mm.kernel.g.aAc()) {
          break label364;
        }
        Log.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.iDM == 702) || (this.iDM == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    com.tencent.mm.kernel.g.aAi();
    Object localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(2, null));
    com.tencent.mm.kernel.g.aAi();
    Object localObject7 = new p(Util.nullAs((Integer)com.tencent.mm.kernel.g.aAh().azQ().get(9, null), 0));
    if (Util.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      com.tencent.mm.kernel.g.aAi();
      Object localObject2 = com.tencent.mm.kernel.g.aAf().azh();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.iDM == 252) || (this.iDM == 701))
      {
        bool = true;
        localObject3 = ((ac)localObject2).a(l, "", bool);
        if (localObject3 != null) {
          break label902;
        }
        paramInt = -1;
        label495:
        if (localObject3 != null) {
          break label909;
        }
        localObject2 = "null";
        label505:
        Log.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new SKBuiltinBuffer_t();
        if (!Util.isNullOrNil((byte[])localObject3)) {
          break label922;
        }
        localObject2 = new byte[0];
        label561:
        localjk.KNX = ((SKBuiltinBuffer_t)localObject7).setBuffer((byte[])localObject2);
        if ((this.iDM != 702) && (this.iDM != 763)) {
          break label1049;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new hx();
        localObject6 = new ia();
        ((j.a)localObject2).Kzu.KLV = ((ia)localObject6);
        ((j.a)localObject2).Kzu.KLW = ((hx)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label929;
        }
        paramInt = -1;
        Log.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = Util.decodeHexString((String)localObject4);
        localObject4 = new hy();
        if (Util.isNullOrNil((byte[])localObject7)) {
          break label971;
        }
        ((hx)localObject5).KKZ = new SKBuiltinBuffer_t().setBuffer((byte[])localObject7);
        Log.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((hx)localObject5).KKZ.getBuffer().zy.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((hy)localObject4).parseFrom((byte[])localObject7);
          if (((hy)localObject4).KLT == null) {
            break label1006;
          }
          ((ia)localObject6).KLX = ((hy)localObject4).KLT;
          Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((hy)localObject4).KLT.getBuffer().zy.length), Util.dumpHex(((hy)localObject4).KLT.getBuffer().zy) });
          ((hx)localObject5).KLK = localjk;
          ((hx)localObject5).KFu = MMApplicationContext.getApplicationId();
          Log.i("MicroMsg.MMReqRespAuth", "aesReq.AndroidPackageName [%s]", new Object[] { ((hx)localObject5).KFu });
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).dMW = ((String)localObject1);
          AppMethodBeat.o(132240);
          return this;
          bool = false;
          break;
          label902:
          paramInt = localObject3.length;
          break label495;
          label909:
          localObject2 = Util.secPrint(Util.dumpHex((byte[])localObject3));
          break label505;
          label922:
          localObject2 = localObject3;
          break label561;
          label929:
          paramInt = ((String)localObject4).length();
        }
        catch (IOException localIOException)
        {
          com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 15L, 1L, false);
          Log.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label971:
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 16L, 1L, false);
        ((hx)localObject5).KKZ = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        continue;
        label1006:
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 17L, 1L, false);
        ((ia)localObject6).KLX = new SKBuiltinBuffer_t().setBuffer(new byte[0]);
        Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1049:
        localObject3 = (j.f)localObject6;
        localObject2 = new cmg();
        localObject4 = new cme();
        ((j.f)localObject3).Kzy.MrA = ((cmg)localObject2);
        ((j.f)localObject3).Kzy.MrB = ((cme)localObject4);
        ((cme)localObject4).Mrz = 2;
        ((cme)localObject4).KLK = localjk;
        ((cmg)localObject2).UserName = ((String)localObject1);
        com.tencent.mm.kernel.g.aAi();
        localObject1 = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(3, null));
        com.tencent.mm.kernel.g.aAi();
        ((cmg)localObject2).KQi = Util.nullAsNil((String)com.tencent.mm.kernel.g.aAh().azQ().get(19, null));
        ((cmg)localObject2).KQv = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!com.tencent.mm.kernel.g.aAc())
    {
      Log.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    ell localell = parami.Kzw;
    boolean bool;
    if ((localell != null) && (localell.Nky != null))
    {
      int i = parami.Kzw.Nky.KLo;
      Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAh().hqB.set(47, Integer.valueOf(i));
      com.tencent.mm.network.g localg = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if (localg != null)
      {
        if ((i & 0x1) != 0) {
          break label263;
        }
        bool = true;
        localg.fB(bool);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label384;
      }
      if ((paramInt1 != 4) || (paramInt2 != -301)) {
        break label309;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 18L, 1L, false);
      Log.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localell == null) || (localell.NkA == null)) {
        break label294;
      }
      a(true, parami.Kzw.NkA.KQk, parami.Kzw.NkA.KQl, parami.Kzw.NkA.KQj);
      AppMethodBeat.o(132243);
      return;
      label263:
      bool = false;
      break;
      Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(parami.getRetCode()) });
    }
    label294:
    Log.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
    AppMethodBeat.o(132243);
    return;
    label309:
    paramh = com.tencent.mm.plugin.report.e.Cxv;
    if (f.KyZ)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.e.Cxv;
      if (!f.Kza) {
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
    if (localell.Nkz != null)
    {
      cr.sk(localell.Nkz.KEl);
      cr.a(localell.Nkz.KEm);
      cr.a(localell.Nkz.KEn);
    }
    if (iDP != null) {
      iDP.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int aVJ()
  {
    AppMethodBeat.i(132241);
    if (com.tencent.mm.kernel.g.aAc())
    {
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.aAf();
      int i = a.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    Log.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final s dm(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    s locals = new bh(paramInt1).sa(paramInt2);
    AppMethodBeat.o(132242);
    return locals;
  }
  
  public final l.d getReqObjImp()
  {
    return this.iDN;
  }
  
  public final l.e getRespObj()
  {
    return this.iDO;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.iDN.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.iDN.getUri();
    AppMethodBeat.o(132247);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.bh
 * JD-Core Version:    0.7.0.1
 */
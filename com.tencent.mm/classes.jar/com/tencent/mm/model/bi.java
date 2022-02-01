package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.ac;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.aj;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
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
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.ay;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.protocal.protobuf.cke;
import com.tencent.mm.protocal.protobuf.cva;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.fhd;
import com.tencent.mm.protocal.protobuf.fmx;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.protocal.protobuf.hn;
import com.tencent.mm.protocal.protobuf.ho;
import com.tencent.mm.protocal.protobuf.hq;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.protocal.protobuf.qq;
import com.tencent.mm.protocal.protobuf.qr;
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

public final class bi
  extends com.tencent.mm.an.o
  implements j.e
{
  private static a ltQ = null;
  private final int ltN;
  private final j.h ltO;
  private final j.i ltP;
  
  public bi(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.ltN = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.ltO = new j.a();
      this.ltP = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.ltO = new j.f();
    this.ltP = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(s params)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)params.getReqObj();
    j.i locali = (j.i)params.getRespObj();
    Log.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(params.hashCode()), Integer.valueOf(locali.jWd), Util.getStack() });
    int i;
    if (locali.jWd != 0)
    {
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.jWd) });
      i = locali.jWd;
      AppMethodBeat.o(132248);
      return i;
    }
    evr localevr = locali.RBm;
    int k = localevr.Uxh;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localevr.Uxi;
      j = ((ha)localObject1).RMj;
      Log.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((ha)localObject1).RMi) });
      arrayOfByte1 = z.a(((ha)localObject1).RMm);
      arrayOfByte2 = z.a(((ha)localObject1).RMn);
      params = ((ha)localObject1).RLT;
      arrayOfByte3 = z.a(((ha)localObject1).RLU);
      int m = params.RMR.Ufv;
      int n = params.Stl;
      if (arrayOfByte3 == null)
      {
        i = -1;
        Log.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Util.secPrint(Util.dumpHex(arrayOfByte3)), Util.secPrint(Util.dumpHex(arrayOfByte1)), Util.secPrint(Util.dumpHex(arrayOfByte2)) });
        localObject1 = z.a(params.RMR);
        localObject2 = ((j.h)localObject2).RBl;
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
        m = MMProtocalJni.computerKeyWithAllStr(params.Stl, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
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
        locali.RBq = ((byte[])localObject1);
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
        locali.jWd = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.fGe = localevr.Uxj.UserName;
      }
    }
    for (;;)
    {
      i = locali.jWd;
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
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 24L, 1L, false);
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
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 25L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.jWd = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 26L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.jWd = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 27L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.jWd = 1;
      break label615;
      Log.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localevr.Uxi });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.jWd = 2;
      break label615;
      label885:
      Log.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    ltQ = parama;
  }
  
  public static void a(boolean paramBoolean1, qr paramqr, dca paramdca, cke paramcke, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(205729);
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
    if (paramqr == null)
    {
      i = -1;
      if (paramqr != null) {
        break label202;
      }
      j = -1;
      if (paramcke != null) {
        break label211;
      }
      k = -1;
      if (paramdca != null) {
        break label220;
      }
      m = -1;
      if (paramdca != null) {
        break label229;
      }
      n = -1;
      if (paramdca != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (paramdca != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (paramdca != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = paramdca.TJy)
    {
      Log.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((paramcke != null) && (paramcke.rVy != null) && (paramcke.rVy.size() > 0)) {
        break label265;
      }
      Log.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(205729);
      return;
      i = paramqr.RYW;
      break;
      label202:
      j = paramqr.RYX;
      break label20;
      label211:
      k = paramcke.rVx;
      break label27;
      label220:
      m = paramdca.TJz;
      break label34;
      label229:
      n = paramdca.TJA;
      break label41;
      label238:
      i1 = paramdca.TJB;
      break label48;
      label247:
      localObject1 = paramdca.TJx;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (paramqr != null)
    {
      localObject3 = paramqr.RZa.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (qq)((Iterator)localObject3).next();
        localObject1 = "";
        if (((qq)localObject4).RYV != null) {
          localObject1 = ((qq)localObject4).RYV.Ap();
        }
        ((List)localObject2).add(new com.tencent.mm.protocal.o(((qq)localObject4).type, ((qq)localObject4).RYU.Ap(), ((qq)localObject4).port, (String)localObject1));
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((qq)localObject4).type), Integer.valueOf(((qq)localObject4).port), ((qq)localObject4).RYU.Ap() });
      }
    }
    localObject2 = com.tencent.mm.protocal.o.jr((List)localObject2);
    Object localObject1 = new LinkedList();
    if (paramqr != null)
    {
      localObject3 = paramqr.RYZ.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (qq)((Iterator)localObject3).next();
        paramqr = "";
        if (((qq)localObject4).RYV != null) {
          paramqr = ((qq)localObject4).RYV.Ap();
        }
        ((List)localObject1).add(new com.tencent.mm.protocal.o(((qq)localObject4).type, ((qq)localObject4).RYU.Ap(), ((qq)localObject4).port, paramqr));
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((qq)localObject4).type), Integer.valueOf(((qq)localObject4).port), ((qq)localObject4).RYU.Ap() });
      }
    }
    Object localObject3 = com.tencent.mm.protocal.o.jr((List)localObject1);
    Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    h.aHH();
    h.aHG().kcw.i(2, localObject2);
    Object localObject4 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    h.aHH();
    h.aHG().kcw.i(3, localObject3);
    if (paramdca != null)
    {
      h.aHH();
      h.aHG().kcw.i(6, paramdca.TJx);
      h.aHH();
      h.aHG().kcw.i(7, paramdca.TJy);
      if (paramdca.TJB != 0)
      {
        h.aHH();
        paramqr = h.aHG().kcw;
        if (paramdca.TJB > 60)
        {
          i = 60;
          paramqr.i(35, Integer.valueOf(i));
        }
      }
      else
      {
        aj.D(paramdca.TJz, paramdca.TJC);
      }
    }
    for (paramqr = com.tencent.mm.protocal.o.nA(paramdca.TJx, paramdca.TJy);; paramqr = null)
    {
      paramdca = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[paramcke.rVy.size()];
      String[] arrayOfString2 = new String[paramcke.rVy.size()];
      int[] arrayOfInt = new int[paramcke.rVy.size()];
      Log.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(paramcke.rVx) });
      Iterator localIterator = paramcke.rVy.iterator();
      i = 0;
      paramcke = (cke)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (ckd)localIterator.next();
        Log.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((ckd)localObject1).TrK, ((ckd)localObject1).TrL });
        arrayOfString1[i] = ((ckd)localObject1).TrK;
        arrayOfString2[i] = ((ckd)localObject1).TrL;
        arrayOfInt[i] = ((ckd)localObject1).TrM;
        j = i + 1;
        i = j;
        if (!Util.isNullOrNil(((ckd)localObject1).TrK))
        {
          i = j;
          if (!Util.isNullOrNil(((ckd)localObject1).TrL))
          {
            if (((ckd)localObject1).TrK.equals(com.tencent.mm.network.c.mul))
            {
              h.aHH();
              h.aHG().kcw.i(24, ((ckd)localObject1).TrL);
              paramcke = ((ckd)localObject1).TrL;
              i = j;
              continue;
              i = paramdca.TJB;
              break;
            }
            if (((ckd)localObject1).TrK.equals(com.tencent.mm.network.c.muj))
            {
              h.aHH();
              h.aHG().kcw.i(25, ((ckd)localObject1).TrL);
              paramdca = ((ckd)localObject1).TrL;
              i = j;
            }
            else
            {
              i = j;
              if (((ckd)localObject1).TrK.equals(com.tencent.mm.network.c.kRi))
              {
                i = j;
                if (!Util.isNullOrNil(((ckd)localObject1).TrL))
                {
                  ((SharedPreferences)localObject4).edit().putString(com.tencent.mm.network.c.kRi, ((ckd)localObject1).TrL).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      h.aHH();
      localObject1 = h.aHF().kcd.lCD;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((g)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!Util.isNullOrNil(paramdca))
      {
        h.aHH();
        h.aHG().kcw.i(25, paramdca);
      }
      if (!Util.isNullOrNil(paramcke))
      {
        h.aHH();
        h.aHG().kcw.i(24, paramcke);
      }
      if ((localObject1 != null) && (paramqr != null)) {
        ((g)localObject1).a(paramBoolean1, (String)localObject2, (String)localObject3, paramqr.RBA, paramqr.RBB, paramqr.RBC, paramqr.RBD, paramcke, paramdca);
      }
      if ((paramBoolean2) && (localObject1 != null))
      {
        i = ((g)localObject1).getMMtlsRegion();
        Log.i("MicroMsg.MMReqRespAuth", "new cert region %d, current region %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (paramInt == 0)
        {
          ((g)localObject1).clearMMtlsForbidenHostAndPsk();
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 60L, 1L, false);
          AppMethodBeat.o(205729);
          return;
        }
        if ((paramInt > 0) && (i != paramInt))
        {
          ((g)localObject1).clearMMtlsForbidenHostAndPsk();
          ((g)localObject1).setMMtlsRegion(paramInt);
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 59L, 1L, false);
        }
      }
      AppMethodBeat.o(205729);
      return;
    }
  }
  
  public static SharedPreferences beN()
  {
    AppMethodBeat.i(292916);
    SharedPreferences localSharedPreferences = bj.beN();
    AppMethodBeat.o(292916);
    return localSharedPreferences;
  }
  
  private s uX(int paramInt)
  {
    AppMethodBeat.i(132240);
    Log.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Util.getStack() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = bj.beN();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    Log.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.RAD) });
    long l;
    iz localiz;
    if (i < d.RAD)
    {
      if ((this.ltN == 702) || (this.ltN == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.f.Iyx;
        if (this.ltN != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.f)localObject1).idkeyStat(148L, l, 1L, false);
        localiz = new iz();
        localiz.ROU = paramInt;
        localiz.RMb = new eae().dc(new byte[0]);
        localiz.RMa = new eae().dc(new byte[0]);
        localObject1 = new fhd();
        localiz.ROS = ((fhd)localObject1);
        ((fhd)localObject1).RRv = "";
        ((fhd)localObject1).RRu = "";
        ((fhd)localObject1).UHm = "";
        localObject1 = new fmx();
        localiz.ROT = ((fmx)localObject1);
        ((fmx)localObject1).Tlm = "";
        ((fmx)localObject1).Tll = "";
        if (h.aHB()) {
          break label364;
        }
        Log.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.ltN == 702) || (this.ltN == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    h.aHH();
    Object localObject1 = Util.nullAsNil((String)h.aHG().aHp().b(2, null));
    h.aHH();
    Object localObject7 = new p(Util.nullAs((Integer)h.aHG().aHp().b(9, null), 0));
    if (Util.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      h.aHH();
      Object localObject2 = h.aHE().aGC();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.ltN == 252) || (this.ltN == 701))
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
        localObject7 = new eae();
        if (!Util.isNullOrNil((byte[])localObject3)) {
          break label922;
        }
        localObject2 = new byte[0];
        label561:
        localiz.ROR = ((eae)localObject7).dc((byte[])localObject2);
        if ((this.ltN != 702) && (this.ltN != 763)) {
          break label1049;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new hn();
        localObject6 = new hq();
        ((j.a)localObject2).RBk.RMS = ((hq)localObject6);
        ((j.a)localObject2).RBk.RMT = ((hn)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label929;
        }
        paramInt = -1;
        Log.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = Util.decodeHexString((String)localObject4);
        localObject4 = new ho();
        if (Util.isNullOrNil((byte[])localObject7)) {
          break label971;
        }
        ((hn)localObject5).RLV = new eae().dc((byte[])localObject7);
        Log.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((hn)localObject5).RLV.Tkb.UH.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((ho)localObject4).parseFrom((byte[])localObject7);
          if (((ho)localObject4).RMQ == null) {
            break label1006;
          }
          ((hq)localObject6).RMU = ((ho)localObject4).RMQ;
          Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ho)localObject4).RMQ.Tkb.UH.length), Util.dumpHex(((ho)localObject4).RMQ.Tkb.UH) });
          ((hn)localObject5).RMG = localiz;
          ((hn)localObject5).RGL = MMApplicationContext.getApplicationId();
          Log.i("MicroMsg.MMReqRespAuth", "aesReq.AndroidPackageName [%s]", new Object[] { ((hn)localObject5).RGL });
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).fGe = ((String)localObject1);
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
          com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 15L, 1L, false);
          Log.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label971:
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 16L, 1L, false);
        ((hn)localObject5).RLV = new eae().dc(new byte[0]);
        continue;
        label1006:
        com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 17L, 1L, false);
        ((hq)localObject6).RMU = new eae().dc(new byte[0]);
        Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1049:
        localObject3 = (j.f)localObject6;
        localObject2 = new cvc();
        localObject4 = new cva();
        ((j.f)localObject3).RBo.TCK = ((cvc)localObject2);
        ((j.f)localObject3).RBo.TCL = ((cva)localObject4);
        ((cva)localObject4).TCJ = 2;
        ((cva)localObject4).RMG = localiz;
        ((cvc)localObject2).UserName = ((String)localObject1);
        h.aHH();
        localObject1 = Util.nullAsNil((String)h.aHG().aHp().b(3, null));
        h.aHH();
        ((cvc)localObject2).RRg = Util.nullAsNil((String)h.aHG().aHp().b(19, null));
        ((cvc)localObject2).RRt = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!h.aHB())
    {
      Log.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    evr localevr = parami.RBm;
    boolean bool;
    if ((localevr != null) && (localevr.Uxi != null))
    {
      int i = parami.RBm.Uxi.RMk;
      Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      h.aHH();
      h.aHG().kcw.i(47, Integer.valueOf(i));
      g localg = h.aHF().kcd.lCD;
      if (localg != null)
      {
        if ((i & 0x1) != 0) {
          break label274;
        }
        bool = true;
        localg.gm(bool);
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label395;
      }
      if ((paramInt1 != 4) || (paramInt2 != -301)) {
        break label320;
      }
      com.tencent.mm.plugin.report.f.Iyx.idkeyStat(148L, 18L, 1L, false);
      Log.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localevr == null) || (localevr.Uxk == null)) {
        break label305;
      }
      a(true, parami.RBm.Uxk.RRi, parami.RBm.Uxk.RRj, parami.RBm.Uxk.RRh, true, parami.RBm.Uxk.TJD);
      AppMethodBeat.o(132243);
      return;
      label274:
      bool = false;
      break;
      Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(parami.getRetCode()) });
    }
    label305:
    Log.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
    AppMethodBeat.o(132243);
    return;
    label320:
    paramh = com.tencent.mm.plugin.report.f.Iyx;
    if (com.tencent.mm.protocal.f.RAO)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.f.Iyx;
      if (!com.tencent.mm.protocal.f.RAP) {
        break label387;
      }
    }
    label387:
    for (long l = 121L;; l = 122L)
    {
      paramh.idkeyStat(148L, l, 1L, false);
      AppMethodBeat.o(132243);
      return;
      l = 120L;
      break;
    }
    label395:
    if (localevr.Uxj != null)
    {
      cs.vh(localevr.Uxj.RFD);
      cs.a(localevr.Uxj.RFE);
      cs.a(localevr.Uxj.RFF);
    }
    if (ltQ != null) {
      ltQ.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int beM()
  {
    AppMethodBeat.i(132241);
    if (h.aHB())
    {
      h.aHH();
      h.aHE();
      int i = com.tencent.mm.kernel.b.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    Log.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final s dI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    s locals = new bi(paramInt1).uX(paramInt2);
    AppMethodBeat.o(132242);
    return locals;
  }
  
  public final l.d getReqObjImp()
  {
    return this.ltO;
  }
  
  public final l.e getRespObj()
  {
    return this.ltP;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.ltO.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.ltO.getUri();
    AppMethodBeat.o(132247);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.bi
 * JD-Core Version:    0.7.0.1
 */
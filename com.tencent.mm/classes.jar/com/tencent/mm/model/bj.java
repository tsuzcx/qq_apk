package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.ab;
import com.tencent.mm.am.n;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.ak;
import com.tencent.mm.network.g;
import com.tencent.mm.platformtools.w;
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
import com.tencent.mm.protocal.o;
import com.tencent.mm.protocal.o.a;
import com.tencent.mm.protocal.protobuf.all;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.dal;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.dts;
import com.tencent.mm.protocal.protobuf.dtt;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.gdp;
import com.tencent.mm.protocal.protobuf.gjp;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.ij;
import com.tencent.mm.protocal.protobuf.ik;
import com.tencent.mm.protocal.protobuf.im;
import com.tencent.mm.protocal.protobuf.jv;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.aq;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class bj
  extends n
  implements j.e
{
  private static a olp = null;
  private final int olm;
  private final j.h oln;
  private final j.i olo;
  
  public bj(int paramInt)
  {
    AppMethodBeat.i(132239);
    if ((paramInt == 702) || (paramInt == 701) || (paramInt == 252) || (paramInt == 763)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.olm = paramInt;
      if ((paramInt != 702) && (paramInt != 763)) {
        break;
      }
      this.oln = new j.a();
      this.olo = new j.b();
      AppMethodBeat.o(132239);
      return;
    }
    this.oln = new j.f();
    this.olo = new j.g();
    AppMethodBeat.o(132239);
  }
  
  public static int a(com.tencent.mm.network.s params)
  {
    AppMethodBeat.i(132248);
    Object localObject2 = (j.h)params.getReqObj();
    j.i locali = (j.i)params.getRespObj();
    Log.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((j.h)localObject2).getFuncId()), Integer.valueOf(params.hashCode()), Integer.valueOf(locali.mvX), Util.getStack() });
    int i;
    if (locali.mvX != 0)
    {
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(locali.mvX) });
      i = locali.mvX;
      AppMethodBeat.o(132248);
      return i;
    }
    frg localfrg = locali.YxP;
    int k = localfrg.abQP;
    Object localObject1;
    int j;
    byte[] arrayOfByte1;
    byte[] arrayOfByte2;
    byte[] arrayOfByte3;
    if ((k & 0x1) != 0)
    {
      localObject1 = localfrg.abQQ;
      j = ((hw)localObject1).YJx;
      Log.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((hw)localObject1).YJw) });
      arrayOfByte1 = w.a(((hw)localObject1).YJA);
      arrayOfByte2 = w.a(((hw)localObject1).YJB);
      params = ((hw)localObject1).YJh;
      arrayOfByte3 = w.a(((hw)localObject1).YJi);
      int m = params.YKf.abwJ;
      int n = params.Zsz;
      if (arrayOfByte3 == null)
      {
        i = -1;
        Log.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s, clientSession[%s], serverSession[%s]", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), Util.secPrint(Util.dumpHex(arrayOfByte3)), Util.secPrint(Util.dumpHex(arrayOfByte1)), Util.secPrint(Util.dumpHex(arrayOfByte2)) });
        localObject1 = w.a(params.YKf);
        localObject2 = ((j.h)localObject2).YxO;
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
        m = MMProtocalJni.computerKeyWithAllStr(params.Zsz, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
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
        locali.YxT = ((byte[])localObject1);
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
        locali.mvX = 1;
        label615:
        if ((k & 0x2) == 0) {
          break label885;
        }
        locali.hLv = localfrg.abQR.UserName;
      }
    }
    for (;;)
    {
      i = locali.mvX;
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 24L, 1L, false);
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 25L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.mvX = 2;
      break label615;
      label757:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 26L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      locali.b(new byte[0], arrayOfByte1, arrayOfByte2);
      locali.mvX = 2;
      break label615;
      label800:
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 27L, 1L, false);
      Log.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      locali.b(arrayOfByte3, arrayOfByte1, arrayOfByte2);
      locali.mvX = 1;
      break label615;
      Log.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed AuthSectResp[%s]", new Object[] { localfrg.abQQ });
      locali.b(new byte[0], new byte[0], new byte[0]);
      locali.mvX = 2;
      break label615;
      label885:
      Log.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    olp = parama;
  }
  
  public static void a(boolean paramBoolean1, sc paramsc, dts paramdts, dal paramdal, boolean paramBoolean2, int paramInt)
  {
    AppMethodBeat.i(241961);
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
    if (paramsc == null)
    {
      i = -1;
      if (paramsc != null) {
        break label202;
      }
      j = -1;
      if (paramdal != null) {
        break label211;
      }
      k = -1;
      if (paramdts != null) {
        break label220;
      }
      m = -1;
      if (paramdts != null) {
        break label229;
      }
      n = -1;
      if (paramdts != null) {
        break label238;
      }
      i1 = -1;
      label48:
      if (paramdts != null) {
        break label247;
      }
      localObject1 = "null";
      label57:
      if (paramdts != null) {
        break label256;
      }
    }
    label256:
    for (Object localObject2 = "null";; localObject2 = paramdts.aaZn)
    {
      Log.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean1), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((paramdal != null) && (paramdal.vgO != null) && (paramdal.vgO.size() > 0)) {
        break label265;
      }
      Log.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { Util.getStack() });
      AppMethodBeat.o(241961);
      return;
      i = paramsc.YWW;
      break;
      label202:
      j = paramsc.YWX;
      break label20;
      label211:
      k = paramdal.vgN;
      break label27;
      label220:
      m = paramdts.aaZo;
      break label34;
      label229:
      n = paramdts.aaZp;
      break label41;
      label238:
      i1 = paramdts.aaZq;
      break label48;
      label247:
      localObject1 = paramdts.aaZm;
      break label57;
    }
    label265:
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (paramsc != null)
    {
      localObject3 = paramsc.YXa.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (sb)((Iterator)localObject3).next();
        localObject1 = "";
        if (((sb)localObject4).YWV != null) {
          localObject1 = ((sb)localObject4).YWV.ZV();
        }
        ((List)localObject2).add(new o(((sb)localObject4).type, ((sb)localObject4).YWU.ZV(), ((sb)localObject4).port, (String)localObject1));
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((sb)localObject4).type), Integer.valueOf(((sb)localObject4).port), ((sb)localObject4).YWU.ZV() });
      }
    }
    localObject2 = o.mD((List)localObject2);
    Object localObject1 = new LinkedList();
    if (paramsc != null)
    {
      localObject3 = paramsc.YWZ.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (sb)((Iterator)localObject3).next();
        paramsc = "";
        if (((sb)localObject4).YWV != null) {
          paramsc = ((sb)localObject4).YWV.ZV();
        }
        ((List)localObject1).add(new o(((sb)localObject4).type, ((sb)localObject4).YWU.ZV(), ((sb)localObject4).port, paramsc));
        Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((sb)localObject4).type), Integer.valueOf(((sb)localObject4).port), ((sb)localObject4).YWU.ZV() });
      }
    }
    Object localObject3 = o.mD((List)localObject1);
    Log.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    h.baF();
    h.baE().mCE.B(2, localObject2);
    Object localObject4 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    h.baF();
    h.baE().mCE.B(3, localObject3);
    if (paramdts != null)
    {
      h.baF();
      h.baE().mCE.B(6, paramdts.aaZm);
      h.baF();
      h.baE().mCE.B(7, paramdts.aaZn);
      if (paramdts.aaZq != 0)
      {
        h.baF();
        paramsc = h.baE().mCE;
        if (paramdts.aaZq > 60)
        {
          i = 60;
          paramsc.B(35, Integer.valueOf(i));
        }
      }
      else
      {
        ak.aa(paramdts.aaZo, paramdts.aaZr);
      }
    }
    for (paramsc = o.pw(paramdts.aaZm, paramdts.aaZn);; paramsc = null)
    {
      paramdts = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[paramdal.vgO.size()];
      String[] arrayOfString2 = new String[paramdal.vgO.size()];
      int[] arrayOfInt = new int[paramdal.vgO.size()];
      Log.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(paramdal.vgN) });
      Iterator localIterator = paramdal.vgO.iterator();
      i = 0;
      paramdal = (dal)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1147;
        }
        localObject1 = (dak)localIterator.next();
        Log.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((dak)localObject1).aaFW, ((dak)localObject1).aaFX });
        arrayOfString1[i] = ((dak)localObject1).aaFW;
        arrayOfString2[i] = ((dak)localObject1).aaFX;
        arrayOfInt[i] = ((dak)localObject1).aaFY;
        j = i + 1;
        i = j;
        if (!Util.isNullOrNil(((dak)localObject1).aaFW))
        {
          i = j;
          if (!Util.isNullOrNil(((dak)localObject1).aaFX))
          {
            if (((dak)localObject1).aaFW.equals(com.tencent.mm.network.c.pnF))
            {
              h.baF();
              h.baE().mCE.B(24, ((dak)localObject1).aaFX);
              paramdal = ((dak)localObject1).aaFX;
              i = j;
              continue;
              i = paramdts.aaZq;
              break;
            }
            if (((dak)localObject1).aaFW.equals(com.tencent.mm.network.c.pnD))
            {
              h.baF();
              h.baE().mCE.B(25, ((dak)localObject1).aaFX);
              paramdts = ((dak)localObject1).aaFX;
              i = j;
            }
            else
            {
              i = j;
              if (((dak)localObject1).aaFW.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!Util.isNullOrNil(((dak)localObject1).aaFX))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((dak)localObject1).aaFX).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1147:
      h.baF();
      localObject1 = h.baD().mCm.oun;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((g)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!Util.isNullOrNil(paramdts))
      {
        h.baF();
        h.baE().mCE.B(25, paramdts);
      }
      if (!Util.isNullOrNil(paramdal))
      {
        h.baF();
        h.baE().mCE.B(24, paramdal);
      }
      if ((localObject1 != null) && (paramsc != null)) {
        ((g)localObject1).a(paramBoolean1, (String)localObject2, (String)localObject3, paramsc.Yyd, paramsc.Yye, paramsc.Yyf, paramsc.Yyg, paramdal, paramdts);
      }
      if ((paramBoolean2) && (localObject1 != null))
      {
        i = ((g)localObject1).getMMtlsRegion();
        Log.i("MicroMsg.MMReqRespAuth", "new cert region %d, current region %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i) });
        if (paramInt == 0)
        {
          ((g)localObject1).clearMMtlsForbidenHostAndPsk();
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 60L, 1L, false);
          AppMethodBeat.o(241961);
          return;
        }
        if ((paramInt > 0) && (i != paramInt))
        {
          ((g)localObject1).clearMMtlsForbidenHostAndPsk();
          ((g)localObject1).setMMtlsRegion(paramInt);
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 59L, 1L, false);
        }
      }
      AppMethodBeat.o(241961);
      return;
    }
  }
  
  public static SharedPreferences bCE()
  {
    AppMethodBeat.i(369589);
    SharedPreferences localSharedPreferences = bk.bCE();
    AppMethodBeat.o(369589);
    return localSharedPreferences;
  }
  
  private com.tencent.mm.network.s vi(int paramInt)
  {
    AppMethodBeat.i(132240);
    Log.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), Util.getStack() });
    Object localObject6 = (j.h)getReqObj();
    Object localObject5 = (j.i)getRespObj();
    Object localObject4 = bk.bCE();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    Log.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.Yxh) });
    long l;
    jv localjv;
    if (i < d.Yxh)
    {
      if ((this.olm == 702) || (this.olm == 763))
      {
        i = 12;
        ((j.h)localObject6).setSceneStatus(i);
        localObject1 = com.tencent.mm.plugin.report.f.Ozc;
        if (this.olm != 702) {
          break label321;
        }
      }
      label321:
      for (l = 14L;; l = 13L)
      {
        ((com.tencent.mm.plugin.report.f)localObject1).idkeyStat(148L, l, 1L, false);
        localjv = new jv();
        localjv.YMi = paramInt;
        localjv.YJp = new gol().df(new byte[0]);
        localjv.YJo = new gol().df(new byte[0]);
        localObject1 = new gdp();
        localjv.YMg = ((gdp)localObject1);
        ((gdp)localObject1).YON = "";
        ((gdp)localObject1).YOM = "";
        ((gdp)localObject1).acbw = "";
        localObject1 = new gjp();
        localjv.YMh = ((gjp)localObject1);
        ((gjp)localObject1).aayW = "";
        ((gjp)localObject1).aayV = "";
        if (h.baz()) {
          break label364;
        }
        Log.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        AppMethodBeat.o(132240);
        return null;
        i = 16;
        break;
      }
    }
    if ((this.olm == 702) || (this.olm == 763)) {}
    for (i = 2;; i = 1)
    {
      ((j.h)localObject6).setSceneStatus(i);
      break;
    }
    label364:
    h.baF();
    Object localObject1 = Util.nullAsNil((String)h.baE().ban().d(2, null));
    h.baF();
    Object localObject7 = new p(Util.nullAs((Integer)h.baE().ban().d(9, null), 0));
    if (Util.isNullOrNil((String)localObject1)) {
      localObject1 = ((p)localObject7).toString();
    }
    for (;;)
    {
      h.baF();
      Object localObject2 = h.baC().aZE();
      l = ((p)localObject7).longValue();
      boolean bool;
      Object localObject3;
      if ((this.olm == 252) || (this.olm == 701))
      {
        bool = true;
        localObject3 = ((ab)localObject2).a(l, "", bool);
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
        localObject7 = new gol();
        if (!Util.isNullOrNil((byte[])localObject3)) {
          break label922;
        }
        localObject2 = new byte[0];
        label561:
        localjv.YMf = ((gol)localObject7).df((byte[])localObject2);
        if ((this.olm != 702) && (this.olm != 763)) {
          break label1049;
        }
        localObject2 = (j.a)localObject6;
        localObject3 = (j.b)localObject5;
        localObject5 = new ij();
        localObject6 = new im();
        ((j.a)localObject2).YxN.YKg = ((im)localObject6);
        ((j.a)localObject2).YxN.YKh = ((ij)localObject5);
        localObject4 = ((SharedPreferences)localObject4).getString("_auth_key", "");
        if (localObject4 != null) {
          break label929;
        }
        paramInt = -1;
        Log.i("MicroMsg.MMReqRespAuth", "summerauths KEY_SP_SUFFIX keyStr[%s]", new Object[] { Integer.valueOf(paramInt) });
        localObject7 = Util.decodeHexString((String)localObject4);
        localObject4 = new ik();
        if (Util.isNullOrNil((byte[])localObject7)) {
          break label971;
        }
        ((ij)localObject5).YJj = new gol().df((byte[])localObject7);
        Log.i("MicroMsg.MMReqRespAuth", "summerauths keyBuf[%s, %s]", new Object[] { Integer.valueOf(((ij)localObject5).YJj.aaxD.Op.length), Integer.valueOf(localObject7.length) });
      }
      for (;;)
      {
        try
        {
          ((ik)localObject4).parseFrom((byte[])localObject7);
          if (((ik)localObject4).YKe == null) {
            break label1006;
          }
          ((im)localObject6).YKi = ((ik)localObject4).YKe;
          Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey [%s][%s]", new Object[] { Integer.valueOf(((ik)localObject4).YKe.aaxD.Op.length), Util.dumpHex(((ik)localObject4).YKe.aaxD.Op) });
          ((ij)localObject5).YJU = localjv;
          ((ij)localObject5).YDN = MMApplicationContext.getApplicationId();
          Log.i("MicroMsg.MMReqRespAuth", "aesReq.AndroidPackageName [%s]", new Object[] { ((ij)localObject5).YDN });
          ((j.a)localObject2).username = ((String)localObject1);
          ((j.i)localObject3).hLv = ((String)localObject1);
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
          com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 15L, 1L, false);
          Log.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label971:
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 16L, 1L, false);
        ((ij)localObject5).YJj = new gol().df(new byte[0]);
        continue;
        label1006:
        com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 17L, 1L, false);
        ((im)localObject6).YKi = new gol().df(new byte[0]);
        Log.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
        continue;
        label1049:
        localObject3 = (j.f)localObject6;
        localObject2 = new dmi();
        localObject4 = new dmg();
        ((j.f)localObject3).YxR.aaSr = ((dmi)localObject2);
        ((j.f)localObject3).YxR.aaSs = ((dmg)localObject4);
        ((dmg)localObject4).aaSq = 2;
        ((dmg)localObject4).YJU = localjv;
        ((dmi)localObject2).UserName = ((String)localObject1);
        h.baF();
        localObject1 = Util.nullAsNil((String)h.baE().ban().d(3, null));
        h.baF();
        ((dmi)localObject2).YOy = Util.nullAsNil((String)h.baE().ban().d(19, null));
        ((dmi)localObject2).YOL = ((String)localObject1);
      }
    }
  }
  
  public final void a(j.h paramh, j.i parami, int paramInt1, int paramInt2, String paramString)
  {
    AppMethodBeat.i(132243);
    if (!h.baz())
    {
      Log.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
      AppMethodBeat.o(132243);
      return;
    }
    frg localfrg = parami.YxP;
    boolean bool;
    if ((localfrg != null) && (localfrg.abQQ != null))
    {
      int i = parami.YxP.abQQ.YJy;
      Log.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
      h.baF();
      h.baE().mCE.B(47, Integer.valueOf(i));
      g localg = h.baD().mCm.oun;
      if (localg != null)
      {
        if ((i & 0x1) != 0) {
          break label274;
        }
        bool = true;
        localg.hd(bool);
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
      com.tencent.mm.plugin.report.f.Ozc.idkeyStat(148L, 18L, 1L, false);
      Log.i("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
      if ((localfrg == null) || (localfrg.abQS == null)) {
        break label305;
      }
      a(true, parami.YxP.abQS.YOA, parami.YxP.abQS.YOB, parami.YxP.abQS.YOz, true, parami.YxP.abQS.aaZs);
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
    paramh = com.tencent.mm.plugin.report.f.Ozc;
    if (com.tencent.mm.protocal.f.Yxs)
    {
      l = 119L;
      paramh.idkeyStat(148L, l, 1L, false);
      paramh = com.tencent.mm.plugin.report.f.Ozc;
      if (!com.tencent.mm.protocal.f.Yxt) {
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
    if (localfrg.abQR != null)
    {
      ct.vr(localfrg.abQR.YCg);
      ct.a(localfrg.abQR.YCh);
      ct.a(localfrg.abQR.YCi);
    }
    if (olp != null) {
      olp.a(paramh, parami);
    }
    AppMethodBeat.o(132243);
  }
  
  public final int bCD()
  {
    AppMethodBeat.i(132241);
    if (h.baz())
    {
      h.baF();
      h.baC();
      int i = com.tencent.mm.kernel.b.getUin();
      AppMethodBeat.o(132241);
      return i;
    }
    Log.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { Util.getStack() });
    AppMethodBeat.o(132241);
    return 0;
  }
  
  public final com.tencent.mm.network.s eC(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(132242);
    com.tencent.mm.network.s locals = new bj(paramInt1).vi(paramInt2);
    AppMethodBeat.o(132242);
    return locals;
  }
  
  public final l.d getReqObjImp()
  {
    return this.oln;
  }
  
  public final l.e getRespObj()
  {
    return this.olo;
  }
  
  public final int getType()
  {
    AppMethodBeat.i(132246);
    int i = this.oln.getFuncId();
    AppMethodBeat.o(132246);
    return i;
  }
  
  public final String getUri()
  {
    AppMethodBeat.i(132247);
    String str = this.oln.getUri();
    AppMethodBeat.o(132247);
    return str;
  }
  
  public static abstract interface a
  {
    public abstract void a(j.h paramh, j.i parami);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.bj
 * JD-Core Version:    0.7.0.1
 */
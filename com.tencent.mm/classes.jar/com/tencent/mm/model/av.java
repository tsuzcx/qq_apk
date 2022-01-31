package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.a.o;
import com.tencent.mm.ah.k;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.ad;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.c.apk;
import com.tencent.mm.protocal.c.apl;
import com.tencent.mm.protocal.c.ar;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avr;
import com.tencent.mm.protocal.c.ays;
import com.tencent.mm.protocal.c.ayt;
import com.tencent.mm.protocal.c.bmk;
import com.tencent.mm.protocal.c.bzo;
import com.tencent.mm.protocal.c.chv;
import com.tencent.mm.protocal.c.clp;
import com.tencent.mm.protocal.c.eq;
import com.tencent.mm.protocal.c.ez;
import com.tencent.mm.protocal.c.fa;
import com.tencent.mm.protocal.c.fc;
import com.tencent.mm.protocal.c.ga;
import com.tencent.mm.protocal.c.ju;
import com.tencent.mm.protocal.c.jv;
import com.tencent.mm.protocal.c.uq;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.i.a;
import com.tencent.mm.protocal.i.b;
import com.tencent.mm.protocal.i.c;
import com.tencent.mm.protocal.i.d;
import com.tencent.mm.protocal.i.e;
import com.tencent.mm.protocal.i.f;
import com.tencent.mm.protocal.i.g;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.n;
import com.tencent.mm.protocal.n.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.z;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class av
  extends k
  implements i.c
{
  private static a dVX = null;
  private final int dVU;
  private final i.f dVV;
  private final i.g dVW;
  
  public av(int paramInt)
  {
    if ((paramInt == 702) || (paramInt == 701)) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      this.dVU = paramInt;
      if (paramInt != 702) {
        break;
      }
      this.dVV = new i.a();
      this.dVW = new i.b();
      return;
    }
    this.dVV = new i.d();
    this.dVW = new i.e();
  }
  
  public static SharedPreferences HD()
  {
    return aw.HD();
  }
  
  public static int a(q paramq)
  {
    Object localObject2 = (i.f)paramq.Kv();
    i.g localg = (i.g)paramq.HF();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo type:%d, hashcode:%d, ret:%d, stack[%s]", new Object[] { Integer.valueOf(((i.f)localObject2).HH()), Integer.valueOf(paramq.hashCode()), Integer.valueOf(localg.dDD), bk.csb() });
    if (localg.dDD != 0)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth decodeAndRetriveAccInfo resp just decoded and ret result:%d", new Object[] { Integer.valueOf(localg.dDD) });
      return localg.dDD;
    }
    bzo localbzo = localg.spz;
    int k = localbzo.tPu;
    Object localObject1;
    int j;
    byte[] arrayOfByte;
    int i;
    if ((k & 0x1) != 0)
    {
      localObject1 = localbzo.tPv;
      j = ((eq)localObject1).syw;
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "decodeAndRetriveAccInfo authResultFlag:%d UpdateFlag:%d ", new Object[] { Integer.valueOf(j), Integer.valueOf(((eq)localObject1).syv) });
      paramq = ((eq)localObject1).syg;
      arrayOfByte = aa.a(((eq)localObject1).syh);
      int m = paramq.syK.tFK;
      int n = paramq.sRn;
      if (arrayOfByte == null)
      {
        i = -1;
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key len:%d, nid:%d sessionKey len:%d, sessionKey：%s", new Object[] { Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i), bk.aac(bk.bD(arrayOfByte)) });
        localObject1 = aa.a(paramq.syK);
        localObject2 = ((i.f)localObject2).spy;
        if (bk.bE((byte[])localObject1)) {
          break label601;
        }
        m = localObject1.length;
        Object localObject3 = bk.aac(bk.bD((byte[])localObject1));
        if (localObject2 != null) {
          break label588;
        }
        i = -1;
        label297:
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth svrPubKey len:%d value:%s prikey len:%d, values:%s", new Object[] { Integer.valueOf(m), localObject3, Integer.valueOf(i), bk.aac(bk.bD((byte[])localObject2)) });
        localObject3 = new PByteArray();
        m = MMProtocalJni.computerKeyWithAllStr(paramq.sRn, (byte[])localObject1, (byte[])localObject2, (PByteArray)localObject3, 0);
        paramq = ((PByteArray)localObject3).value;
        if (paramq != null) {
          break label595;
        }
        i = -1;
        label376:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth ComputerKeyWithAllStr ret:%d, agreedECDHKey len: %d, values:%s", new Object[] { Integer.valueOf(m), Integer.valueOf(i), bk.aac(bk.bD(paramq)) });
        label412:
        if (paramq == null) {
          break label627;
        }
        localObject1 = paramq;
        label419:
        localg.spA = ((byte[])localObject1);
        if ((j & 0x4) == 0) {
          break label724;
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth must decode session key");
        if (bk.bE(paramq)) {
          break label686;
        }
        paramq = MMProtocalJni.aesDecrypt(arrayOfByte, paramq);
        if (arrayOfByte != null) {
          break label635;
        }
        i = -1;
        label460:
        localObject1 = bk.aac(bk.bD(arrayOfByte));
        if (paramq != null) {
          break label642;
        }
        j = -1;
        label476:
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth aesDecrypt sessionKey len:%d, value:%s, session len:%d, value:%s", new Object[] { Integer.valueOf(i), localObject1, Integer.valueOf(j), bk.aac(bk.bD(paramq)) });
        if (bk.bE(paramq)) {
          break label648;
        }
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth decode session key succ session:%s", new Object[] { bk.aac(bk.bD(paramq)) });
        localg.bn(paramq);
        localg.dDD = 1;
        label556:
        if ((k & 0x2) == 0) {
          break label787;
        }
        localg.eNw = localbzo.tPw.hPY;
      }
    }
    for (;;)
    {
      return localg.dDD;
      i = arrayOfByte.length;
      break;
      label588:
      i = localObject2.length;
      break label297;
      label595:
      i = paramq.length;
      break label376;
      label601:
      f.nEG.a(148L, 24L, 1L, false);
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMReqRespAuth", "summerauth svr ecdh key is null!");
      paramq = null;
      break label412;
      label627:
      localObject1 = new byte[0];
      break label419;
      label635:
      i = arrayOfByte.length;
      break label460;
      label642:
      j = paramq.length;
      break label476;
      label648:
      f.nEG.a(148L, 25L, 1L, false);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed ret null!");
      localg.bn(new byte[0]);
      localg.dDD = 2;
      break label556;
      label686:
      f.nEG.a(148L, 26L, 1L, false);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth decode session key failed as agreedECDHKey is null!");
      localg.bn(new byte[0]);
      localg.dDD = 2;
      break label556;
      label724:
      f.nEG.a(148L, 27L, 1L, false);
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth not need decode session key");
      localg.bn(arrayOfByte);
      localg.dDD = 1;
      break label556;
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth auth sect not set so ret failed");
      localg.bn(new byte[0]);
      localg.dDD = 2;
      break label556;
      label787:
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth acct sect not set!");
    }
  }
  
  public static void a(a parama)
  {
    dVX = parama;
  }
  
  public static void a(boolean paramBoolean, jv paramjv, ays paramays, apl paramapl)
  {
    int i;
    int j;
    label14:
    int k;
    label21:
    int m;
    label28:
    int n;
    label35:
    int i1;
    if (paramjv == null)
    {
      i = -1;
      if (paramjv != null) {
        break label190;
      }
      j = -1;
      if (paramapl != null) {
        break label199;
      }
      k = -1;
      if (paramays != null) {
        break label208;
      }
      m = -1;
      if (paramays != null) {
        break label217;
      }
      n = -1;
      if (paramays != null) {
        break label226;
      }
      i1 = -1;
      label42:
      if (paramays != null) {
        break label235;
      }
      localObject1 = "null";
      label51:
      if (paramays != null) {
        break label244;
      }
    }
    label190:
    label199:
    label208:
    label217:
    label226:
    label235:
    label244:
    for (Object localObject2 = "null";; localObject2 = paramays.tuA)
    {
      com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo resetnewwork:%b iplist[l:%d s:%d] hostList[%d] noop[%d %d] typing[%d] port[%s] timeout[%s]", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n), Integer.valueOf(i1), localObject1, localObject2 });
      if ((paramapl != null) && (paramapl.hPT != null) && (paramapl.hPT.size() > 0)) {
        break label253;
      }
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bk.csb() });
      return;
      i = paramjv.sEC;
      break;
      j = paramjv.sED;
      break label14;
      k = paramapl.hPS;
      break label21;
      m = paramays.tuB;
      break label28;
      n = paramays.tuC;
      break label35;
      i1 = paramays.tuD;
      break label42;
      localObject1 = paramays.tuz;
      break label51;
    }
    label253:
    if ((paramapl == null) || (paramapl.hPT == null) || (paramapl.hPT.size() <= 0))
    {
      com.tencent.mm.sdk.platformtools.y.f("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo give empty host request! stack:[%s]", new Object[] { bk.csb() });
      return;
    }
    localObject2 = new LinkedList();
    ((List)localObject2).clear();
    if (paramjv != null)
    {
      localObject3 = paramjv.sEG.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ju)((Iterator)localObject3).next();
        localObject1 = "";
        if (((ju)localObject4).sEB != null) {
          localObject1 = ((ju)localObject4).sEB.coM();
        }
        ((List)localObject2).add(new n(((ju)localObject4).type, ((ju)localObject4).sEA.coM(), ((ju)localObject4).port, (String)localObject1));
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo short type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((ju)localObject4).type), Integer.valueOf(((ju)localObject4).port), ((ju)localObject4).sEA.coM() });
      }
    }
    localObject2 = n.di((List)localObject2);
    Object localObject1 = new LinkedList();
    if (paramjv != null)
    {
      localObject3 = paramjv.sEF.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ju)((Iterator)localObject3).next();
        paramjv = "";
        if (((ju)localObject4).sEB != null) {
          paramjv = ((ju)localObject4).sEB.coM();
        }
        ((List)localObject1).add(new n(((ju)localObject4).type, ((ju)localObject4).sEA.coM(), ((ju)localObject4).port, paramjv));
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo long type:%d port:%d ip:%s", new Object[] { Integer.valueOf(((ju)localObject4).type), Integer.valueOf(((ju)localObject4).port), ((ju)localObject4).sEA.coM() });
      }
    }
    Object localObject3 = n.di((List)localObject1);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "dkidc updateMultiIDCInfo builtin ip long[%s] short[%s]", new Object[] { localObject3, localObject2 });
    g.DQ();
    g.DP().dKo.set(2, localObject2);
    Object localObject4 = ae.getContext().getSharedPreferences("system_config_prefs", 0);
    ((SharedPreferences)localObject4).edit().putString("builtin_short_ips", (String)localObject2).commit();
    g.DQ();
    g.DP().dKo.set(3, localObject3);
    if (paramays != null)
    {
      g.DQ();
      g.DP().dKo.set(6, paramays.tuz);
      g.DQ();
      g.DP().dKo.set(7, paramays.tuA);
      if (paramays.tuD != 0)
      {
        g.DQ();
        paramjv = g.DP().dKo;
        if (paramays.tuD > 60)
        {
          i = 60;
          paramjv.set(35, Integer.valueOf(i));
        }
      }
      else
      {
        ad.r(paramays.tuB, paramays.tuE);
      }
    }
    for (paramjv = n.ga(paramays.tuz, paramays.tuA);; paramjv = null)
    {
      paramays = "";
      localObject1 = "";
      String[] arrayOfString1 = new String[paramapl.hPT.size()];
      String[] arrayOfString2 = new String[paramapl.hPT.size()];
      int[] arrayOfInt = new int[paramapl.hPT.size()];
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "hostlist.Count=%d", new Object[] { Integer.valueOf(paramapl.hPS) });
      Iterator localIterator = paramapl.hPT.iterator();
      i = 0;
      paramapl = (apl)localObject1;
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label1175;
        }
        localObject1 = (apk)localIterator.next();
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "dkidc host org:%s sub:%s", new Object[] { ((apk)localObject1).tlw, ((apk)localObject1).tlx });
        arrayOfString1[i] = ((apk)localObject1).tlw;
        arrayOfString2[i] = ((apk)localObject1).tlx;
        arrayOfInt[i] = ((apk)localObject1).tly;
        j = i + 1;
        i = j;
        if (!bk.bl(((apk)localObject1).tlw))
        {
          i = j;
          if (!bk.bl(((apk)localObject1).tlx))
          {
            if (((apk)localObject1).tlw.equals("short.weixin.qq.com"))
            {
              g.DQ();
              g.DP().dKo.set(24, ((apk)localObject1).tlx);
              paramapl = ((apk)localObject1).tlx;
              i = j;
              continue;
              i = paramays.tuD;
              break;
            }
            if (((apk)localObject1).tlw.equals("long.weixin.qq.com"))
            {
              g.DQ();
              g.DP().dKo.set(25, ((apk)localObject1).tlx);
              paramays = ((apk)localObject1).tlx;
              i = j;
            }
            else
            {
              i = j;
              if (((apk)localObject1).tlw.equals("support.weixin.qq.com"))
              {
                i = j;
                if (!bk.bl(((apk)localObject1).tlx))
                {
                  ((SharedPreferences)localObject4).edit().putString("support.weixin.qq.com", ((apk)localObject1).tlx).commit();
                  i = j;
                }
              }
            }
          }
        }
      }
      label1175:
      g.DQ();
      localObject1 = g.DO().dJT.edx;
      if ((arrayOfString1.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).setHostInfo(arrayOfString1, arrayOfString2, arrayOfInt);
      }
      if (!bk.bl(paramays))
      {
        g.DQ();
        g.DP().dKo.set(25, paramays);
      }
      if (!bk.bl(paramapl))
      {
        g.DQ();
        g.DP().dKo.set(24, paramapl);
      }
      if ((localObject1 == null) || (paramjv == null)) {
        break;
      }
      ((com.tencent.mm.network.e)localObject1).a(paramBoolean, (String)localObject2, (String)localObject3, paramjv.spU, paramjv.spV, paramjv.spW, paramjv.spX, paramapl, paramays);
      return;
    }
  }
  
  private q hQ(int paramInt)
  {
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth autoAuthReq authReqFlag:%d, this:%d, stack:%s", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(hashCode()), bk.csb() });
    Object localObject6 = (i.f)Kv();
    Object localObject5 = (i.g)this.dVW;
    Object localObject4 = aw.HD();
    int i = ((SharedPreferences)localObject4).getInt("key_auth_update_version", 0);
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "summerauth updateVersion:%d, clientVersion:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(d.spa) });
    long l;
    ga localga;
    if (i < d.spa)
    {
      if (this.dVU == 702)
      {
        i = 12;
        ((k.d)localObject6).spI = i;
        localObject1 = f.nEG;
        if (this.dVU != 702) {
          break label299;
        }
      }
      label299:
      for (l = 14L;; l = 13L)
      {
        ((f)localObject1).a(148L, l, 1L, false);
        localga = new ga();
        localga.sAf = paramInt;
        localga.syo = new bmk().bs(new byte[0]);
        localga.syn = new bmk().bs(new byte[0]);
        localObject1 = new chv();
        localga.sAd = ((chv)localObject1);
        ((chv)localObject1).sBQ = "";
        ((chv)localObject1).sBP = "";
        ((chv)localObject1).tWv = "";
        localObject1 = new clp();
        localga.sAe = ((clp)localObject1);
        ((clp)localObject1).tgV = "";
        ((clp)localObject1).tgU = "";
        if (g.DK()) {
          break label332;
        }
        com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMReqRespAuth", "autoAuthReq build autoauth Req  , failed  acc not ready");
        return null;
        i = 16;
        break;
      }
    }
    if (this.dVU == 702) {}
    for (i = 2;; i = 1)
    {
      ((k.d)localObject6).spI = i;
      break;
    }
    label332:
    g.DQ();
    Object localObject1 = bk.pm((String)g.DP().Dz().get(2, null));
    g.DQ();
    Object localObject7 = new o(bk.a((Integer)g.DP().Dz().get(9, null), 0));
    if (bk.bl((String)localObject1)) {
      localObject1 = ((o)localObject7).toString();
    }
    for (;;)
    {
      g.DQ();
      Object localObject2 = g.DN().CU();
      l = ((o)localObject7).longValue();
      boolean bool;
      if (this.dVU == 701)
      {
        bool = true;
        localObject3 = ((com.tencent.mm.ah.y)localObject2).a(l, "", bool);
        if (localObject3 != null) {
          break label700;
        }
        paramInt = -1;
        label453:
        if (localObject3 != null) {
          break label707;
        }
        localObject2 = "null";
        label463:
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth loginbuf username:%s, qq:%s, len:%d, content:[%s]", new Object[] { localObject1, localObject7, Integer.valueOf(paramInt), localObject2 });
        localObject7 = new bmk();
        if (!bk.bE((byte[])localObject3)) {
          break label720;
        }
        localObject2 = new byte[0];
        localga.sAc = ((bmk)localObject7).bs((byte[])localObject2);
        if (this.dVU != 702) {
          break label838;
        }
        localObject2 = (i.a)localObject6;
        localObject3 = (i.b)localObject5;
        localObject5 = new ez();
        localObject6 = new fc();
        ((i.a)localObject2).spu.syL = ((fc)localObject6);
        ((i.a)localObject2).spu.syM = ((ez)localObject5);
        localObject7 = bk.ZM(((SharedPreferences)localObject4).getString("_auth_key", ""));
        localObject4 = new fa();
        if (bk.bE((byte[])localObject7)) {
          break label760;
        }
        ((ez)localObject5).syi = new bmk().bs((byte[])localObject7);
      }
      for (;;)
      {
        try
        {
          ((fa)localObject4).aH((byte[])localObject7);
          if (((fa)localObject4).syJ == null) {
            break label795;
          }
          ((fc)localObject6).syN = ((fa)localObject4).syJ;
          ((ez)localObject5).syE = localga;
          ((i.a)localObject2).username = ((String)localObject1);
          ((i.g)localObject3).eNw = ((String)localObject1);
          return this;
          bool = false;
          break;
          label700:
          paramInt = localObject3.length;
          break label453;
          label707:
          localObject2 = bk.aac(bk.bD((byte[])localObject3));
          break label463;
          label720:
          localObject2 = localObject3;
        }
        catch (IOException localIOException)
        {
          f.nEG.a(148L, 15L, 1L, false);
          com.tencent.mm.sdk.platformtools.y.printErrStackTrace("MicroMsg.MMReqRespAuth", localIOException, "summerauthkey Failed parse autoauthkey buf", new Object[0]);
          continue;
        }
        label760:
        f.nEG.a(148L, 16L, 1L, false);
        ((ez)localObject5).syi = new bmk().bs(new byte[0]);
        continue;
        label795:
        f.nEG.a(148L, 17L, 1L, false);
        ((fc)localObject6).syN = new bmk().bs(new byte[0]);
        com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMReqRespAuth", "summerauthkey AesEncryptKey null!");
      }
      label838:
      Object localObject3 = (i.d)localObject6;
      localObject2 = new avr();
      localObject4 = new avp();
      ((i.d)localObject3).spw.trj = ((avr)localObject2);
      ((i.d)localObject3).spw.trk = ((avp)localObject4);
      ((avp)localObject4).tri = 2;
      ((avp)localObject4).syE = localga;
      ((avr)localObject2).hPY = ((String)localObject1);
      g.DQ();
      localObject1 = bk.pm((String)g.DP().Dz().get(3, null));
      g.DQ();
      ((avr)localObject2).sBC = bk.pm((String)g.DP().Dz().get(19, null));
      ((avr)localObject2).sBO = ((String)localObject1);
      return this;
    }
  }
  
  public final int HC()
  {
    if (g.DK())
    {
      g.DQ();
      g.DN();
      return a.CK();
    }
    com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMReqRespAuth", "dkwt acc NOT Ready , the fucking MMReqRespBase need the fucking uin ???  if u find this log , fuck dk. %s", new Object[] { bk.csb() });
    return 0;
  }
  
  protected final k.d HE()
  {
    return this.dVV;
  }
  
  public final k.e HF()
  {
    return this.dVW;
  }
  
  public final void a(i.f paramf, i.g paramg, int paramInt1, int paramInt2, String paramString)
  {
    if (!g.DK()) {
      com.tencent.mm.sdk.platformtools.y.e("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd but account not ready");
    }
    label112:
    label245:
    do
    {
      return;
      bzo localbzo = paramg.spz;
      boolean bool;
      if ((localbzo != null) && (localbzo.tPv != null))
      {
        int i = paramg.spz.tPv.syx;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto:%s", new Object[] { Integer.valueOf(i) });
        g.DQ();
        g.DP().dKo.set(47, Integer.valueOf(i));
        com.tencent.mm.network.e locale = g.DO().dJT.edx;
        if (locale != null)
        {
          if ((i & 0x1) != 0) {
            break label245;
          }
          bool = true;
          locale.bR(bool);
        }
      }
      for (;;)
      {
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth onAutoAuthEnd errType:%d, errCode:%d, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        if ((paramInt1 == 0) && (paramInt2 == 0)) {
          break label285;
        }
        if ((paramInt1 != 4) || (paramInt2 != -301)) {
          break;
        }
        f.nEG.a(148L, 18L, 1L, false);
        com.tencent.mm.sdk.platformtools.y.d("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC");
        if ((localbzo == null) || (localbzo.tPx == null)) {
          break label276;
        }
        a(true, paramg.spz.tPx.sBE, paramg.spz.tPx.sBF, paramg.spz.tPx.sBD);
        return;
        bool = false;
        break label112;
        com.tencent.mm.sdk.platformtools.y.i("MicroMsg.MMReqRespAuth", "summerauth mmtls auto not set as ret:%s", new Object[] { Integer.valueOf(paramg.spN) });
      }
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.MMReqRespAuth", "dkidc onAutoAuthEnd RedirectIDC but NetworkSectResp is null");
      return;
    } while (dVX == null);
    label276:
    label285:
    dVX.a(paramf, paramg);
  }
  
  public final q bh(int paramInt1, int paramInt2)
  {
    return new av(paramInt1).hQ(paramInt2);
  }
  
  public final int getType()
  {
    return this.dVV.HH();
  }
  
  public final String getUri()
  {
    return this.dVV.getUri();
  }
  
  public static abstract interface a
  {
    public abstract void a(i.f paramf, i.g paramg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.model.av
 * JD-Core Version:    0.7.0.1
 */
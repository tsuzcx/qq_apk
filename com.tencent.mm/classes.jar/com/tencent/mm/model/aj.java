package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.ac;
import com.tencent.mm.ak.t;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ba;
import com.tencent.mm.protocal.protobuf.cca;
import com.tencent.mm.protocal.protobuf.ccb;
import com.tencent.mm.protocal.protobuf.ctc;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.ews;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.ck;
import java.util.Iterator;
import java.util.LinkedList;

public final class aj
{
  public static void a(ell paramell, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramell.Nkx;
    int i;
    label96:
    ao localao;
    Object localObject1;
    long l;
    label257:
    label269:
    label677:
    boolean bool1;
    Object localObject2;
    String str;
    int k;
    Object localObject3;
    label896:
    label1061:
    boolean bool2;
    if (paramell.Nky == null)
    {
      i = -1;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramell.Nky, paramell.Nkz, paramell.NkA, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramell.Nky == null)) {
        break label1507;
      }
      i = paramell.Nky.rBx;
      z.rO(paramell.Nky.KLn);
      com.tencent.mm.kernel.g.aAi();
      com.tencent.mm.kernel.g.qg(i);
      com.tencent.mm.kernel.a.b.e.aAK();
      localao = com.tencent.mm.kernel.g.aAh().azQ();
      localao.set(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramell.Nky.KLm <= 0) {
          break label1570;
        }
        localao.set(ar.a.NSk, Long.valueOf(paramell.Nky.KLm));
        localao.set(ar.a.NSm, Long.valueOf(Util.nowSecond()));
        localao.set(ar.a.NSl, Long.valueOf(com.tencent.mm.protocal.d.KyO));
        Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramell.Nky.KLm), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1526;
        }
        localObject1 = com.tencent.mm.plugin.report.e.Cxv;
        if (paramell.Nky.KLm != 2) {
          break label1518;
        }
        l = 19L;
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1618;
      }
      localObject1 = paramell.Nkz;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((ba)localObject1).KDZ), Integer.valueOf(((ba)localObject1).oTW), ((ba)localObject1).UserName, ((ba)localObject1).oUJ, ((ba)localObject1).KEa, ((ba)localObject1).KEb, ((ba)localObject1).ked, Integer.valueOf(((ba)localObject1).KEc), Integer.valueOf(((ba)localObject1).KEd), ((ba)localObject1).KEe, Integer.valueOf(((ba)localObject1).KEf), ((ba)localObject1).KEg, ((ba)localObject1).KEg, Integer.valueOf(((ba)localObject1).KEi), ((ba)localObject1).KEj });
      if (!paramBoolean) {
        localao.set(52, Integer.valueOf(((ba)localObject1).KEd));
      }
      localao.set(9, Integer.valueOf(((ba)localObject1).KDZ));
      localao.set(7, Integer.valueOf(((ba)localObject1).oTW));
      localao.set(2, ((ba)localObject1).UserName);
      localao.set(4, ((ba)localObject1).oUJ);
      localao.set(5, ((ba)localObject1).KEa);
      localao.set(6, ((ba)localObject1).KEb);
      localao.set(42, ((ba)localObject1).ked);
      localao.set(34, Integer.valueOf(((ba)localObject1).KEc));
      com.tencent.mm.kernel.g.aAh().azR().bkT(((ba)localObject1).KEe);
      localao.set(64, Integer.valueOf(((ba)localObject1).KEf));
      localao.set(21, ((ba)localObject1).KEg);
      localao.set(22, ((ba)localObject1).KEg);
      localao.set(17, Integer.valueOf(((ba)localObject1).KEi));
      bf.iDu.aO("login_weixin_username", ((ba)localObject1).UserName);
      bf.iDu.aO("last_login_nick_name", ((ba)localObject1).oUJ);
      bf.iDu.k(((ba)localObject1).KEb, ((ba)localObject1).KDZ, ((ba)localObject1).KEa);
      if (paramell.Nkz != null)
      {
        cr.sk(paramell.Nkz.KEl);
        cr.a(paramell.Nkz.KEm);
        cr.a(paramell.Nkz.KEn);
      }
      if ((!paramBoolean) && (com.tencent.mm.kernel.g.aAc())) {
        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oou, Boolean.TRUE);
      }
      bool1 = false;
      if ((j & 0x1) == 0) {
        break label1783;
      }
      localObject1 = paramell.Nky;
      localObject2 = ((hk)localObject1).KLg;
      str = Util.encodeHexString(com.tencent.mm.platformtools.z.a(((hk)localObject1).KLh));
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((hk)localObject1).KLk, Integer.valueOf(((hk)localObject1).KLl), Integer.valueOf(((hk)localObject1).KLm), Integer.valueOf(((hk)localObject1).KLn), Util.secPrint((String)localObject2), Util.secPrint(str), ((hk)localObject1).KEj });
      k = ((hk)localObject1).KLa;
      localObject3 = new p(Util.nullAsNil((Integer)localao.get(9, Integer.valueOf(0))));
      if (((hk)localObject1).KLb != null) {
        break label1629;
      }
      i = -1;
      Log.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject3, Integer.valueOf(i) });
      if (k == 0) {
        break label1760;
      }
      if (k != 1) {
        break label1641;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.z.a(((hk)localObject1).KLb);
      bool1 = com.tencent.mm.kernel.g.aAf().azh().a(((p)localObject3).longValue(), arrayOfByte);
      Log.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject3 = Util.encodeHexString(com.tencent.mm.kernel.g.aAf().azh().Aj(((p)localObject3).longValue()));
      localao.set(-1535680990, localObject2);
      localao.set(46, str);
      localao.set(72, localObject3);
      localao.set(29, ((hk)localObject1).KEj);
      if (!paramBoolean)
      {
        localObject2 = ((hk)localObject1).KLb;
        if ((localObject2 == null) || (((SKBuiltinBuffer_t)localObject2).getILen() == 0))
        {
          Log.i("MicroMsg.HandleAuthResponse", "maybe no qq login");
          if (com.tencent.mm.kernel.g.aAc()) {
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Oou, Boolean.FALSE);
          }
        }
      }
      Log.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((hk)localObject1).KLc != null)
      {
        localObject2 = Util.encodeHexString(com.tencent.mm.platformtools.z.a(((hk)localObject1).KLc.KQA));
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localao.set(47, localObject2);
          com.tencent.mm.kernel.g.aAh().hqB.set(18, localObject2);
        }
        Log.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { Util.secPrint((String)localObject2) });
      }
      localObject2 = MMApplicationContext.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.aps()).edit();
      if (((hk)localObject1).KLs != 1) {
        break label1766;
      }
      bool2 = true;
      label1244:
      bool2 = ((SharedPreferences.Editor)localObject2).putBoolean("auth_info_prefs_use_new_ecdh", bool2).commit();
      k = ((hk)localObject1).KLs;
      if (!bool2) {
        break label1772;
      }
      i = 1;
      label1277:
      Log.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((hk)localObject1).KLs != 1) {
        break label1777;
      }
      bool2 = true;
      label1316:
      com.tencent.mm.protocal.f.KyZ = bool2;
      label1321:
      if ((j & 0x4) == 0) {
        break label1808;
      }
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 23L, 1L, false);
      localObject1 = paramell.NkA;
      bh.a(false, ((ctc)localObject1).KQk, ((ctc)localObject1).KQl, ((ctc)localObject1).KQj);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        localObject1 = z.aTY();
        if (bool1)
        {
          i = 1;
          localObject1 = z.aTX();
        }
        Log.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.E(1, i, (String)localObject1);
      }
      localao.set(3, "");
      localao.set(19, "");
      localao.gBI();
      com.tencent.mm.kernel.g.aAh().hqB.setInt(46, 0);
      a.aSH();
      if ((j & 0x8) == 0) {
        break label1819;
      }
      Log.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramell.NkB);
      AppMethodBeat.o(134110);
      return;
      i = paramell.Nky.KLm;
      break;
      label1507:
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      label1518:
      l = 41L;
      break label257;
      label1526:
      localObject1 = com.tencent.mm.plugin.report.e.Cxv;
      if (paramell.Nky.KLm == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
        break;
      }
      label1570:
      localao.set(ar.a.NSk, Long.valueOf(paramell.Nky.KLm));
      localao.set(ar.a.NSm, Long.valueOf(Util.nowSecond()));
      localao.set(ar.a.NSl, Long.valueOf(0L));
      break label269;
      label1618:
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label677;
      label1629:
      i = ((hk)localObject1).KLb.getILen();
      break label896;
      label1641:
      if (k == 2)
      {
        com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.g.aAf().azh().Ak(((p)localObject3).longValue());
        localObject3 = Util.encodeHexString(com.tencent.mm.kernel.g.aAf().azh().Aj(((p)localObject3).longValue()));
        localao.set(-1535680990, localObject2);
        localao.set(46, str);
        localao.set(72, localObject3);
        localao.set(29, ((hk)localObject1).KEj);
        bool1 = false;
        break label1061;
      }
      Log.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
      label1760:
      bool1 = false;
      break label1061;
      label1766:
      bool2 = false;
      break label1244;
      label1772:
      i = 0;
      break label1277;
      label1777:
      bool2 = false;
      break label1316;
      label1783:
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.e.Cxv.idkeyStat(148L, 22L, 1L, false);
      break label1321;
      label1808:
      Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
    label1819:
    Log.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
    AppMethodBeat.o(134110);
  }
  
  public static void a(ig paramig)
  {
    AppMethodBeat.i(134111);
    if (paramig == null) {}
    Object localObject1;
    for (int i = -1;; i = paramig.oTz)
    {
      Log.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.aAi();
      localObject1 = com.tencent.mm.kernel.g.aAg().hqi.iMw;
      if ((localObject1 != null) && (((com.tencent.mm.network.g)localObject1).aZh() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.g)localObject1).aZh().aZg();
    if ((paramig == null) || (paramig.oTz == 0))
    {
      Log.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramig.oTA;
    if ((localLinkedList == null) || (localLinkedList.size() != paramig.oTz)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      Log.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramig.oTz) });
      Log.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    paramig = localLinkedList.iterator();
    while (paramig.hasNext())
    {
      Object localObject2 = (if)paramig.next();
      i = ((if)localObject2).xMB;
      Object localObject3 = ((if)localObject2).KMp;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        Log.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.g)localObject1).aZh().h(i, ((ccb)localObject3).toByteArray());
        localObject2 = new String[((ccb)localObject3).oTA.size()];
        arrayOfString = new String[((ccb)localObject3).oTA.size()];
        arrayOfInt = new int[((ccb)localObject3).oTA.size()];
        Log.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((ccb)localObject3).oTz) });
        localObject3 = ((ccb)localObject3).oTA.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          cca localcca = (cca)((Iterator)localObject3).next();
          Log.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localcca.MhX, localcca.MhY });
          localObject2[i] = localcca.MhX;
          arrayOfString[i] = localcca.MhY;
          arrayOfInt[i] = localcca.MhZ;
          int j = i + 1;
          i = j;
          if (!Util.isNullOrNil(localcca.MhX))
          {
            i = j;
            if (!Util.isNullOrNil(localcca.MhY)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { Util.stackTraceToString(localException) });
        }
      }
      if ((localException.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.g)localObject1).addHostInfo(localException, arrayOfString, arrayOfInt);
      }
    }
    paramig = localLinkedList.iterator();
    while (paramig.hasNext())
    {
      localObject1 = (if)paramig.next();
      h.RTc.aX(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134109);
          Log.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
          com.tencent.mm.kernel.g.azz().a(new ag(this.iDm), 0);
          AppMethodBeat.o(134109);
        }
      });
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.aj
 * JD-Core Version:    0.7.0.1
 */
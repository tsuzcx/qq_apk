package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.au;
import com.tencent.mm.protocal.protobuf.bgo;
import com.tencent.mm.protocal.protobuf.bgp;
import com.tencent.mm.protocal.protobuf.bsv;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.dpi;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.protocal.protobuf.hh;
import com.tencent.mm.protocal.protobuf.hi;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
{
  public static void a(dfm paramdfm, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramdfm.EwO;
    int i;
    label96:
    ab localab;
    Object localObject1;
    long l;
    label247:
    boolean bool1;
    label259:
    label667:
    Object localObject2;
    String str;
    int k;
    Object localObject3;
    label823:
    label988:
    boolean bool2;
    if (paramdfm.EwP == null)
    {
      i = -1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramdfm.EwP, paramdfm.EwQ, paramdfm.EwR, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramdfm.EwP == null)) {
        break label1381;
      }
      i = paramdfm.EwP.oXh;
      com.tencent.mm.kernel.g.afC();
      com.tencent.mm.kernel.g.ms(i);
      com.tencent.mm.kernel.a.b.e.age();
      localab = com.tencent.mm.kernel.g.afB().afk();
      localab.set(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramdfm.EwP.CBp <= 0) {
          break label1444;
        }
        localab.set(ae.a.FfL, Long.valueOf(paramdfm.EwP.CBp));
        localab.set(ae.a.FfN, Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aGK()));
        localab.set(ae.a.FfM, Long.valueOf(com.tencent.mm.protocal.d.CpK));
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramdfm.EwP.CBp), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1400;
        }
        localObject1 = com.tencent.mm.plugin.report.e.vIY;
        if (paramdfm.EwP.CBp != 2) {
          break label1392;
        }
        l = 19L;
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1492;
      }
      localObject1 = paramdfm.EwQ;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((au)localObject1).CuF), Integer.valueOf(((au)localObject1).mBi), ((au)localObject1).mAQ, ((au)localObject1).mBV, ((au)localObject1).CuG, ((au)localObject1).CuH, ((au)localObject1).ijR, Integer.valueOf(((au)localObject1).CuI), Integer.valueOf(((au)localObject1).CuJ), ((au)localObject1).CuK, Integer.valueOf(((au)localObject1).CuL), ((au)localObject1).CuM, ((au)localObject1).CuM, Integer.valueOf(((au)localObject1).CuO), ((au)localObject1).CuP });
      if (!paramBoolean) {
        localab.set(52, Integer.valueOf(((au)localObject1).CuJ));
      }
      localab.set(9, Integer.valueOf(((au)localObject1).CuF));
      localab.set(7, Integer.valueOf(((au)localObject1).mBi));
      localab.set(2, ((au)localObject1).mAQ);
      localab.set(4, ((au)localObject1).mBV);
      localab.set(5, ((au)localObject1).CuG);
      localab.set(6, ((au)localObject1).CuH);
      localab.set(42, ((au)localObject1).ijR);
      localab.set(34, Integer.valueOf(((au)localObject1).CuI));
      com.tencent.mm.kernel.g.afB().afl().aJh(((au)localObject1).CuK);
      localab.set(64, Integer.valueOf(((au)localObject1).CuL));
      localab.set(21, ((au)localObject1).CuM);
      localab.set(22, ((au)localObject1).CuM);
      localab.set(17, Integer.valueOf(((au)localObject1).CuO));
      ay.gNa.aD("login_weixin_username", ((au)localObject1).mAQ);
      ay.gNa.aD("last_login_nick_name", ((au)localObject1).mBV);
      ay.gNa.g(((au)localObject1).CuH, ((au)localObject1).CuF, ((au)localObject1).CuG);
      bool1 = false;
      if ((j & 0x1) == 0) {
        break label1657;
      }
      localObject1 = paramdfm.EwP;
      localObject2 = ((gm)localObject1).CBj;
      str = com.tencent.mm.sdk.platformtools.bt.cy(com.tencent.mm.platformtools.z.a(((gm)localObject1).CBk));
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((gm)localObject1).CBn, Integer.valueOf(((gm)localObject1).CBo), Integer.valueOf(((gm)localObject1).CBp), Integer.valueOf(((gm)localObject1).CBq), com.tencent.mm.sdk.platformtools.bt.aGs((String)localObject2), com.tencent.mm.sdk.platformtools.bt.aGs(str), ((gm)localObject1).CuP });
      k = ((gm)localObject1).CBd;
      localObject3 = new p(com.tencent.mm.sdk.platformtools.bt.l((Integer)localab.get(9, Integer.valueOf(0))));
      if (((gm)localObject1).CBe != null) {
        break label1503;
      }
      i = -1;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject3, Integer.valueOf(i) });
      if (k == 0) {
        break label1634;
      }
      if (k != 1) {
        break label1515;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.z.a(((gm)localObject1).CBe);
      bool1 = com.tencent.mm.kernel.g.afz().aeA().a(((p)localObject3).longValue(), arrayOfByte);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject3 = com.tencent.mm.sdk.platformtools.bt.cy(com.tencent.mm.kernel.g.afz().aeA().md(((p)localObject3).longValue()));
      localab.set(-1535680990, localObject2);
      localab.set(46, str);
      localab.set(72, localObject3);
      localab.set(29, ((gm)localObject1).CuP);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((gm)localObject1).CBf != null)
      {
        localObject2 = com.tencent.mm.sdk.platformtools.bt.cy(com.tencent.mm.platformtools.z.a(((gm)localObject1).CBf.CGx));
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localab.set(47, localObject2);
          com.tencent.mm.kernel.g.afB().gcR.set(18, localObject2);
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.aGs((String)localObject2) });
      }
      localObject2 = aj.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.XN()).edit();
      if (((gm)localObject1).CBv != 1) {
        break label1640;
      }
      bool2 = true;
      label1118:
      bool2 = ((SharedPreferences.Editor)localObject2).putBoolean("auth_info_prefs_use_new_ecdh", bool2).commit();
      k = ((gm)localObject1).CBv;
      if (!bool2) {
        break label1646;
      }
      i = 1;
      label1151:
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((gm)localObject1).CBv != 1) {
        break label1651;
      }
      bool2 = true;
      label1190:
      com.tencent.mm.protocal.f.CpT = bool2;
      label1195:
      if ((j & 0x4) == 0) {
        break label1682;
      }
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 23L, 1L, false);
      localObject1 = paramdfm.EwR;
      ba.a(false, ((bsv)localObject1).CGh, ((bsv)localObject1).CGi, ((bsv)localObject1).CGg);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        localObject1 = u.aqG();
        if (bool1)
        {
          i = 1;
          localObject1 = u.aqF();
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.F(1, i, (String)localObject1);
      }
      localab.set(3, "");
      localab.set(19, "");
      localab.eKy();
      com.tencent.mm.kernel.g.afB().gcR.setInt(46, 0);
      a.apH();
      if ((j & 0x8) == 0) {
        break label1693;
      }
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramdfm.EwS);
      AppMethodBeat.o(134110);
      return;
      i = paramdfm.EwP.CBp;
      break;
      label1381:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      label1392:
      l = 41L;
      break label247;
      label1400:
      localObject1 = com.tencent.mm.plugin.report.e.vIY;
      if (paramdfm.EwP.CBp == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
        break;
      }
      label1444:
      localab.set(ae.a.FfL, Long.valueOf(paramdfm.EwP.CBp));
      localab.set(ae.a.FfN, Long.valueOf(com.tencent.mm.sdk.platformtools.bt.aGK()));
      localab.set(ae.a.FfM, Long.valueOf(0L));
      break label259;
      label1492:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label667;
      label1503:
      i = ((gm)localObject1).CBe.getILen();
      break label823;
      label1515:
      if (k == 2)
      {
        com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.g.afz().aeA().me(((p)localObject3).longValue());
        localObject3 = com.tencent.mm.sdk.platformtools.bt.cy(com.tencent.mm.kernel.g.afz().aeA().md(((p)localObject3).longValue()));
        localab.set(-1535680990, localObject2);
        localab.set(46, str);
        localab.set(72, localObject3);
        localab.set(29, ((gm)localObject1).CuP);
        bool1 = false;
        break label988;
      }
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
      label1634:
      bool1 = false;
      break label988;
      label1640:
      bool2 = false;
      break label1118;
      label1646:
      i = 0;
      break label1151;
      label1651:
      bool2 = false;
      break label1190;
      label1657:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.e.vIY.idkeyStat(148L, 22L, 1L, false);
      break label1195;
      label1682:
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
    label1693:
    com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
    AppMethodBeat.o(134110);
  }
  
  public static void a(hi paramhi)
  {
    AppMethodBeat.i(134111);
    if (paramhi == null) {}
    Object localObject1;
    for (int i = -1;; i = paramhi.mAK)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.afC();
      localObject1 = com.tencent.mm.kernel.g.afA().gcy.gVH;
      if ((localObject1 != null) && (((com.tencent.mm.network.e)localObject1).avg() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.e)localObject1).avg().avf();
    if ((paramhi == null) || (paramhi.mAK == 0))
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramhi.mAL;
    if ((localLinkedList == null) || (localLinkedList.size() != paramhi.mAK)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramhi.mAK) });
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    paramhi = localLinkedList.iterator();
    while (paramhi.hasNext())
    {
      Object localObject2 = (hh)paramhi.next();
      i = ((hh)localObject2).CCp;
      Object localObject3 = ((hh)localObject2).CCr;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.e)localObject1).avg().h(i, ((bgp)localObject3).toByteArray());
        localObject2 = new String[((bgp)localObject3).mAL.size()];
        arrayOfString = new String[((bgp)localObject3).mAL.size()];
        arrayOfInt = new int[((bgp)localObject3).mAL.size()];
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((bgp)localObject3).mAK) });
        localObject3 = ((bgp)localObject3).mAL.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          bgo localbgo = (bgo)((Iterator)localObject3).next();
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localbgo.DEz, localbgo.DEA });
          localObject2[i] = localbgo.DEz;
          arrayOfString[i] = localbgo.DEA;
          arrayOfInt[i] = localbgo.DEB;
          int j = i + 1;
          i = j;
          if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(localbgo.DEz))
          {
            i = j;
            if (!com.tencent.mm.sdk.platformtools.bt.isNullOrNil(localbgo.DEA)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m(localException) });
        }
      }
      if ((localException.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).addHostInfo(localException, arrayOfString, arrayOfInt);
      }
    }
    paramhi = localLinkedList.iterator();
    while (paramhi.hasNext())
    {
      localObject1 = (hh)paramhi.next();
      h.Iye.aP(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134109);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
          com.tencent.mm.kernel.g.aeS().a(new af(this.gMS), 0);
          AppMethodBeat.o(134109);
        }
      });
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.ad
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.modelsimple.af;
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bkg;
import com.tencent.mm.protocal.protobuf.bkh;
import com.tencent.mm.protocal.protobuf.bxm;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.duz;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.protocal.protobuf.hl;
import com.tencent.mm.protocal.protobuf.hm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.bw;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad
{
  public static void a(dlb paramdlb, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramdlb.FTQ;
    int i;
    label96:
    ae localae;
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
    if (paramdlb.FTR == null)
    {
      i = -1;
      ac.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramdlb.FTR, paramdlb.FTS, paramdlb.FTT, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramdlb.FTR == null)) {
        break label1381;
      }
      i = paramdlb.FTR.pAs;
      com.tencent.mm.kernel.g.agS();
      com.tencent.mm.kernel.g.mr(i);
      com.tencent.mm.kernel.a.b.e.ahu();
      localae = com.tencent.mm.kernel.g.agR().agA();
      localae.set(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramdlb.FTR.DTN <= 0) {
          break label1444;
        }
        localae.set(ah.a.GDz, Long.valueOf(paramdlb.FTR.DTN));
        localae.set(ah.a.GDB, Long.valueOf(bs.aNx()));
        localae.set(ah.a.GDA, Long.valueOf(com.tencent.mm.protocal.d.DIc));
        ac.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramdlb.FTR.DTN), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1400;
        }
        localObject1 = com.tencent.mm.plugin.report.e.wTc;
        if (paramdlb.FTR.DTN != 2) {
          break label1392;
        }
        l = 19L;
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1492;
      }
      localObject1 = paramdlb.FTS;
      ac.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((aw)localObject1).DNa), Integer.valueOf(((aw)localObject1).ndj), ((aw)localObject1).ncR, ((aw)localObject1).ndW, ((aw)localObject1).DNb, ((aw)localObject1).DNc, ((aw)localObject1).iJY, Integer.valueOf(((aw)localObject1).DNd), Integer.valueOf(((aw)localObject1).DNe), ((aw)localObject1).DNf, Integer.valueOf(((aw)localObject1).DNg), ((aw)localObject1).DNh, ((aw)localObject1).DNh, Integer.valueOf(((aw)localObject1).DNj), ((aw)localObject1).DNk });
      if (!paramBoolean) {
        localae.set(52, Integer.valueOf(((aw)localObject1).DNe));
      }
      localae.set(9, Integer.valueOf(((aw)localObject1).DNa));
      localae.set(7, Integer.valueOf(((aw)localObject1).ndj));
      localae.set(2, ((aw)localObject1).ncR);
      localae.set(4, ((aw)localObject1).ndW);
      localae.set(5, ((aw)localObject1).DNb);
      localae.set(6, ((aw)localObject1).DNc);
      localae.set(42, ((aw)localObject1).iJY);
      localae.set(34, Integer.valueOf(((aw)localObject1).DNd));
      com.tencent.mm.kernel.g.agR().agB().aOD(((aw)localObject1).DNf);
      localae.set(64, Integer.valueOf(((aw)localObject1).DNg));
      localae.set(21, ((aw)localObject1).DNh);
      localae.set(22, ((aw)localObject1).DNh);
      localae.set(17, Integer.valueOf(((aw)localObject1).DNj));
      ay.hnA.aL("login_weixin_username", ((aw)localObject1).ncR);
      ay.hnA.aL("last_login_nick_name", ((aw)localObject1).ndW);
      ay.hnA.g(((aw)localObject1).DNc, ((aw)localObject1).DNa, ((aw)localObject1).DNb);
      bool1 = false;
      if ((j & 0x1) == 0) {
        break label1657;
      }
      localObject1 = paramdlb.FTR;
      localObject2 = ((gq)localObject1).DTH;
      str = bs.cx(com.tencent.mm.platformtools.z.a(((gq)localObject1).DTI));
      ac.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((gq)localObject1).DTL, Integer.valueOf(((gq)localObject1).DTM), Integer.valueOf(((gq)localObject1).DTN), Integer.valueOf(((gq)localObject1).DTO), bs.aLJ((String)localObject2), bs.aLJ(str), ((gq)localObject1).DNk });
      k = ((gq)localObject1).DTB;
      localObject3 = new p(bs.m((Integer)localae.get(9, Integer.valueOf(0))));
      if (((gq)localObject1).DTC != null) {
        break label1503;
      }
      i = -1;
      ac.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject3, Integer.valueOf(i) });
      if (k == 0) {
        break label1634;
      }
      if (k != 1) {
        break label1515;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.z.a(((gq)localObject1).DTC);
      bool1 = com.tencent.mm.kernel.g.agP().afQ().a(((p)localObject3).longValue(), arrayOfByte);
      ac.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject3 = bs.cx(com.tencent.mm.kernel.g.agP().afQ().pR(((p)localObject3).longValue()));
      localae.set(-1535680990, localObject2);
      localae.set(46, str);
      localae.set(72, localObject3);
      localae.set(29, ((gq)localObject1).DNk);
      ac.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((gq)localObject1).DTD != null)
      {
        localObject2 = bs.cx(com.tencent.mm.platformtools.z.a(((gq)localObject1).DTD.DYX));
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localae.set(47, localObject2);
          com.tencent.mm.kernel.g.agR().ghx.set(18, localObject2);
        }
        ac.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { bs.aLJ((String)localObject2) });
      }
      localObject2 = ai.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.YK()).edit();
      if (((gq)localObject1).DTT != 1) {
        break label1640;
      }
      bool2 = true;
      label1118:
      bool2 = ((SharedPreferences.Editor)localObject2).putBoolean("auth_info_prefs_use_new_ecdh", bool2).commit();
      k = ((gq)localObject1).DTT;
      if (!bool2) {
        break label1646;
      }
      i = 1;
      label1151:
      ac.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((gq)localObject1).DTT != 1) {
        break label1651;
      }
      bool2 = true;
      label1190:
      com.tencent.mm.protocal.f.DIl = bool2;
      label1195:
      if ((j & 0x4) == 0) {
        break label1682;
      }
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 23L, 1L, false);
      localObject1 = paramdlb.FTT;
      ba.a(false, ((bxm)localObject1).DYH, ((bxm)localObject1).DYI, ((bxm)localObject1).DYG);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        localObject1 = u.axw();
        if (bool1)
        {
          i = 1;
          localObject1 = u.axv();
        }
        ac.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.c.d.E(1, i, (String)localObject1);
      }
      localae.set(3, "");
      localae.set(19, "");
      localae.faa();
      com.tencent.mm.kernel.g.agR().ghx.setInt(46, 0);
      a.aww();
      if ((j & 0x8) == 0) {
        break label1693;
      }
      ac.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramdlb.FTU);
      AppMethodBeat.o(134110);
      return;
      i = paramdlb.FTR.DTN;
      break;
      label1381:
      ac.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      label1392:
      l = 41L;
      break label247;
      label1400:
      localObject1 = com.tencent.mm.plugin.report.e.wTc;
      if (paramdlb.FTR.DTN == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
        break;
      }
      label1444:
      localae.set(ah.a.GDz, Long.valueOf(paramdlb.FTR.DTN));
      localae.set(ah.a.GDB, Long.valueOf(bs.aNx()));
      localae.set(ah.a.GDA, Long.valueOf(0L));
      break label259;
      label1492:
      ac.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label667;
      label1503:
      i = ((gq)localObject1).DTC.getILen();
      break label823;
      label1515:
      if (k == 2)
      {
        com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.g.agP().afQ().pS(((p)localObject3).longValue());
        localObject3 = bs.cx(com.tencent.mm.kernel.g.agP().afQ().pR(((p)localObject3).longValue()));
        localae.set(-1535680990, localObject2);
        localae.set(46, str);
        localae.set(72, localObject3);
        localae.set(29, ((gq)localObject1).DNk);
        bool1 = false;
        break label988;
      }
      ac.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
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
      ac.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.e.wTc.idkeyStat(148L, 22L, 1L, false);
      break label1195;
      label1682:
      ac.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
    label1693:
    ac.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
    AppMethodBeat.o(134110);
  }
  
  public static void a(hm paramhm)
  {
    AppMethodBeat.i(134111);
    if (paramhm == null) {}
    Object localObject1;
    for (int i = -1;; i = paramhm.ncL)
    {
      ac.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.agS();
      localObject1 = com.tencent.mm.kernel.g.agQ().ghe.hwg;
      if ((localObject1 != null) && (((com.tencent.mm.network.e)localObject1).aBZ() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.e)localObject1).aBZ().aBY();
    if ((paramhm == null) || (paramhm.ncL == 0))
    {
      ac.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramhm.ncM;
    if ((localLinkedList == null) || (localLinkedList.size() != paramhm.ncL)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      ac.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramhm.ncL) });
      ac.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    paramhm = localLinkedList.iterator();
    while (paramhm.hasNext())
    {
      Object localObject2 = (hl)paramhm.next();
      i = ((hl)localObject2).DUM;
      Object localObject3 = ((hl)localObject2).DUO;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        ac.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.e)localObject1).aBZ().h(i, ((bkh)localObject3).toByteArray());
        localObject2 = new String[((bkh)localObject3).ncM.size()];
        arrayOfString = new String[((bkh)localObject3).ncM.size()];
        arrayOfInt = new int[((bkh)localObject3).ncM.size()];
        ac.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((bkh)localObject3).ncL) });
        localObject3 = ((bkh)localObject3).ncM.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          bkg localbkg = (bkg)((Iterator)localObject3).next();
          ac.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localbkg.EZU, localbkg.EZV });
          localObject2[i] = localbkg.EZU;
          arrayOfString[i] = localbkg.EZV;
          arrayOfInt[i] = localbkg.EZW;
          int j = i + 1;
          i = j;
          if (!bs.isNullOrNil(localbkg.EZU))
          {
            i = j;
            if (!bs.isNullOrNil(localbkg.EZV)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ac.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { bs.m(localException) });
        }
      }
      if ((localException.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).addHostInfo(localException, arrayOfString, arrayOfInt);
      }
    }
    paramhm = localLinkedList.iterator();
    while (paramhm.hasNext())
    {
      localObject1 = (hl)paramhm.next();
      h.JZN.aS(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134109);
          ac.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
          com.tencent.mm.kernel.g.agi().a(new af(this.hns), 0);
          AppMethodBeat.o(134109);
        }
      });
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.ad
 * JD-Core Version:    0.7.0.1
 */
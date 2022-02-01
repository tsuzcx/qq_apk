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
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.bpi;
import com.tencent.mm.protocal.protobuf.bpj;
import com.tencent.mm.protocal.protobuf.ccx;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.eck;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.cd;
import java.util.Iterator;
import java.util.LinkedList;

public final class af
{
  public static void a(drp paramdrp, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramdrp.HYr;
    int i;
    label96:
    aj localaj;
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
    if (paramdrp.HYs == null)
    {
      i = -1;
      ae.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramdrp.HYs, paramdrp.HYt, paramdrp.HYu, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramdrp.HYs == null)) {
        break label1381;
      }
      i = paramdrp.HYs.qkC;
      com.tencent.mm.kernel.g.ajS();
      com.tencent.mm.kernel.g.mT(i);
      com.tencent.mm.kernel.a.b.e.aku();
      localaj = com.tencent.mm.kernel.g.ajR().ajA();
      localaj.set(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramdrp.HYs.FRF <= 0) {
          break label1444;
        }
        localaj.set(am.a.IKm, Long.valueOf(paramdrp.HYs.FRF));
        localaj.set(am.a.IKo, Long.valueOf(bu.aRi()));
        localaj.set(am.a.IKn, Long.valueOf(com.tencent.mm.protocal.d.FFH));
        ae.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramdrp.HYs.FRF), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1400;
        }
        localObject1 = com.tencent.mm.plugin.report.e.ywz;
        if (paramdrp.HYs.FRF != 2) {
          break label1392;
        }
        l = 19L;
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1492;
      }
      localObject1 = paramdrp.HYt;
      ae.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((aw)localObject1).FKD), Integer.valueOf(((aw)localObject1).nJb), ((aw)localObject1).nIJ, ((aw)localObject1).nJO, ((aw)localObject1).FKE, ((aw)localObject1).FKF, ((aw)localObject1).jga, Integer.valueOf(((aw)localObject1).FKG), Integer.valueOf(((aw)localObject1).FKH), ((aw)localObject1).FKI, Integer.valueOf(((aw)localObject1).FKJ), ((aw)localObject1).FKK, ((aw)localObject1).FKK, Integer.valueOf(((aw)localObject1).FKM), ((aw)localObject1).FKN });
      if (!paramBoolean) {
        localaj.set(52, Integer.valueOf(((aw)localObject1).FKH));
      }
      localaj.set(9, Integer.valueOf(((aw)localObject1).FKD));
      localaj.set(7, Integer.valueOf(((aw)localObject1).nJb));
      localaj.set(2, ((aw)localObject1).nIJ);
      localaj.set(4, ((aw)localObject1).nJO);
      localaj.set(5, ((aw)localObject1).FKE);
      localaj.set(6, ((aw)localObject1).FKF);
      localaj.set(42, ((aw)localObject1).jga);
      localaj.set(34, Integer.valueOf(((aw)localObject1).FKG));
      com.tencent.mm.kernel.g.ajR().ajB().aVV(((aw)localObject1).FKI);
      localaj.set(64, Integer.valueOf(((aw)localObject1).FKJ));
      localaj.set(21, ((aw)localObject1).FKK);
      localaj.set(22, ((aw)localObject1).FKK);
      localaj.set(17, Integer.valueOf(((aw)localObject1).FKM));
      bb.hIK.aM("login_weixin_username", ((aw)localObject1).nIJ);
      bb.hIK.aM("last_login_nick_name", ((aw)localObject1).nJO);
      bb.hIK.h(((aw)localObject1).FKF, ((aw)localObject1).FKD, ((aw)localObject1).FKE);
      bool1 = false;
      if ((j & 0x1) == 0) {
        break label1657;
      }
      localObject1 = paramdrp.HYs;
      localObject2 = ((gx)localObject1).FRz;
      str = bu.cH(com.tencent.mm.platformtools.z.a(((gx)localObject1).FRA));
      ae.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((gx)localObject1).FRD, Integer.valueOf(((gx)localObject1).FRE), Integer.valueOf(((gx)localObject1).FRF), Integer.valueOf(((gx)localObject1).FRG), bu.aSM((String)localObject2), bu.aSM(str), ((gx)localObject1).FKN });
      k = ((gx)localObject1).FRt;
      localObject3 = new p(bu.o((Integer)localaj.get(9, Integer.valueOf(0))));
      if (((gx)localObject1).FRu != null) {
        break label1503;
      }
      i = -1;
      ae.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject3, Integer.valueOf(i) });
      if (k == 0) {
        break label1634;
      }
      if (k != 1) {
        break label1515;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.z.a(((gx)localObject1).FRu);
      bool1 = com.tencent.mm.kernel.g.ajP().aiR().a(((p)localObject3).longValue(), arrayOfByte);
      ae.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject3 = bu.cH(com.tencent.mm.kernel.g.ajP().aiR().sd(((p)localObject3).longValue()));
      localaj.set(-1535680990, localObject2);
      localaj.set(46, str);
      localaj.set(72, localObject3);
      localaj.set(29, ((gx)localObject1).FKN);
      ae.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((gx)localObject1).FRv != null)
      {
        localObject2 = bu.cH(com.tencent.mm.platformtools.z.a(((gx)localObject1).FRv.FWO));
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localaj.set(47, localObject2);
          com.tencent.mm.kernel.g.ajR().gDO.set(18, localObject2);
        }
        ae.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { bu.aSM((String)localObject2) });
      }
      localObject2 = ak.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.abv()).edit();
      if (((gx)localObject1).FRL != 1) {
        break label1640;
      }
      bool2 = true;
      label1118:
      bool2 = ((SharedPreferences.Editor)localObject2).putBoolean("auth_info_prefs_use_new_ecdh", bool2).commit();
      k = ((gx)localObject1).FRL;
      if (!bool2) {
        break label1646;
      }
      i = 1;
      label1151:
      ae.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((gx)localObject1).FRL != 1) {
        break label1651;
      }
      bool2 = true;
      label1190:
      com.tencent.mm.protocal.f.FFQ = bool2;
      label1195:
      if ((j & 0x4) == 0) {
        break label1682;
      }
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 23L, 1L, false);
      localObject1 = paramdrp.HYu;
      bd.a(false, ((ccx)localObject1).FWy, ((ccx)localObject1).FWz, ((ccx)localObject1).FWx);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        localObject1 = v.aAC();
        if (bool1)
        {
          i = 1;
          localObject1 = v.aAB();
        }
        ae.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.F(1, i, (String)localObject1);
      }
      localaj.set(3, "");
      localaj.set(19, "");
      localaj.fuc();
      com.tencent.mm.kernel.g.ajR().gDO.setInt(46, 0);
      a.azA();
      if ((j & 0x8) == 0) {
        break label1693;
      }
      ae.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramdrp.HYv);
      AppMethodBeat.o(134110);
      return;
      i = paramdrp.HYs.FRF;
      break;
      label1381:
      ae.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      label1392:
      l = 41L;
      break label247;
      label1400:
      localObject1 = com.tencent.mm.plugin.report.e.ywz;
      if (paramdrp.HYs.FRF == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
        break;
      }
      label1444:
      localaj.set(am.a.IKm, Long.valueOf(paramdrp.HYs.FRF));
      localaj.set(am.a.IKo, Long.valueOf(bu.aRi()));
      localaj.set(am.a.IKn, Long.valueOf(0L));
      break label259;
      label1492:
      ae.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label667;
      label1503:
      i = ((gx)localObject1).FRu.getILen();
      break label823;
      label1515:
      if (k == 2)
      {
        com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.g.ajP().aiR().se(((p)localObject3).longValue());
        localObject3 = bu.cH(com.tencent.mm.kernel.g.ajP().aiR().sd(((p)localObject3).longValue()));
        localaj.set(-1535680990, localObject2);
        localaj.set(46, str);
        localaj.set(72, localObject3);
        localaj.set(29, ((gx)localObject1).FKN);
        bool1 = false;
        break label988;
      }
      ae.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
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
      ae.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.e.ywz.idkeyStat(148L, 22L, 1L, false);
      break label1195;
      label1682:
      ae.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
    label1693:
    ae.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
    AppMethodBeat.o(134110);
  }
  
  public static void a(ht paramht)
  {
    AppMethodBeat.i(134111);
    if (paramht == null) {}
    Object localObject1;
    for (int i = -1;; i = paramht.nID)
    {
      ae.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.ajS();
      localObject1 = com.tencent.mm.kernel.g.ajQ().gDv.hRo;
      if ((localObject1 != null) && (((com.tencent.mm.network.e)localObject1).aFs() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.e)localObject1).aFs().aFr();
    if ((paramht == null) || (paramht.nID == 0))
    {
      ae.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramht.nIE;
    if ((localLinkedList == null) || (localLinkedList.size() != paramht.nID)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      ae.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramht.nID) });
      ae.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    paramht = localLinkedList.iterator();
    while (paramht.hasNext())
    {
      Object localObject2 = (hs)paramht.next();
      i = ((hs)localObject2).uuz;
      Object localObject3 = ((hs)localObject2).FSG;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        ae.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.e)localObject1).aFs().h(i, ((bpj)localObject3).toByteArray());
        localObject2 = new String[((bpj)localObject3).nIE.size()];
        arrayOfString = new String[((bpj)localObject3).nIE.size()];
        arrayOfInt = new int[((bpj)localObject3).nIE.size()];
        ae.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((bpj)localObject3).nID) });
        localObject3 = ((bpj)localObject3).nIE.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          bpi localbpi = (bpi)((Iterator)localObject3).next();
          ae.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localbpi.HcU, localbpi.HcV });
          localObject2[i] = localbpi.HcU;
          arrayOfString[i] = localbpi.HcV;
          arrayOfInt[i] = localbpi.HcW;
          int j = i + 1;
          i = j;
          if (!bu.isNullOrNil(localbpi.HcU))
          {
            i = j;
            if (!bu.isNullOrNil(localbpi.HcV)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { bu.o(localException) });
        }
      }
      if ((localException.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).addHostInfo(localException, arrayOfString, arrayOfInt);
      }
    }
    paramht = localLinkedList.iterator();
    while (paramht.hasNext())
    {
      localObject1 = (hs)paramht.next();
      h.MqF.aO(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(134109);
          ae.i("MicroMsg.HandleAuthResponse", "summerauth do NetsceneAxAuth");
          com.tencent.mm.kernel.g.ajj().a(new ag(this.hIC), 0);
          AppMethodBeat.o(134109);
        }
      });
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.af
 * JD-Core Version:    0.7.0.1
 */
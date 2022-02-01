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
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aw;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.bor;
import com.tencent.mm.protocal.protobuf.ccd;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.eat;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.cc;
import java.util.Iterator;
import java.util.LinkedList;

public final class ae
{
  public static void a(dqs paramdqs, boolean paramBoolean)
  {
    AppMethodBeat.i(134110);
    int j = paramdqs.HEE;
    int i;
    label96:
    ai localai;
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
    if (paramdqs.HEF == null)
    {
      i = -1;
      ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramdqs.HEF, paramdqs.HEG, paramdqs.HEH, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramdqs.HEF == null)) {
        break label1381;
      }
      i = paramdqs.HEF.qdX;
      com.tencent.mm.kernel.g.ajD();
      com.tencent.mm.kernel.g.mQ(i);
      com.tencent.mm.kernel.a.b.e.akf();
      localai = com.tencent.mm.kernel.g.ajC().ajl();
      localai.set(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramdqs.HEF.Fzh <= 0) {
          break label1444;
        }
        localai.set(al.a.IpS, Long.valueOf(paramdqs.HEF.Fzh));
        localai.set(al.a.IpU, Long.valueOf(bt.aQJ()));
        localai.set(al.a.IpT, Long.valueOf(com.tencent.mm.protocal.d.Fnj));
        ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramdqs.HEF.Fzh), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1400;
        }
        localObject1 = com.tencent.mm.plugin.report.e.ygI;
        if (paramdqs.HEF.Fzh != 2) {
          break label1392;
        }
        l = 19L;
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1492;
      }
      localObject1 = paramdqs.HEG;
      ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { p.getString(((aw)localObject1).Fsf), Integer.valueOf(((aw)localObject1).nDG), ((aw)localObject1).nDo, ((aw)localObject1).nEt, ((aw)localObject1).Fsg, ((aw)localObject1).Fsh, ((aw)localObject1).jdh, Integer.valueOf(((aw)localObject1).Fsi), Integer.valueOf(((aw)localObject1).Fsj), ((aw)localObject1).Fsk, Integer.valueOf(((aw)localObject1).Fsl), ((aw)localObject1).Fsm, ((aw)localObject1).Fsm, Integer.valueOf(((aw)localObject1).Fso), ((aw)localObject1).Fsp });
      if (!paramBoolean) {
        localai.set(52, Integer.valueOf(((aw)localObject1).Fsj));
      }
      localai.set(9, Integer.valueOf(((aw)localObject1).Fsf));
      localai.set(7, Integer.valueOf(((aw)localObject1).nDG));
      localai.set(2, ((aw)localObject1).nDo);
      localai.set(4, ((aw)localObject1).nEt);
      localai.set(5, ((aw)localObject1).Fsg);
      localai.set(6, ((aw)localObject1).Fsh);
      localai.set(42, ((aw)localObject1).jdh);
      localai.set(34, Integer.valueOf(((aw)localObject1).Fsi));
      com.tencent.mm.kernel.g.ajC().ajm().aUu(((aw)localObject1).Fsk);
      localai.set(64, Integer.valueOf(((aw)localObject1).Fsl));
      localai.set(21, ((aw)localObject1).Fsm);
      localai.set(22, ((aw)localObject1).Fsm);
      localai.set(17, Integer.valueOf(((aw)localObject1).Fso));
      az.hFS.aM("login_weixin_username", ((aw)localObject1).nDo);
      az.hFS.aM("last_login_nick_name", ((aw)localObject1).nEt);
      az.hFS.h(((aw)localObject1).Fsh, ((aw)localObject1).Fsf, ((aw)localObject1).Fsg);
      bool1 = false;
      if ((j & 0x1) == 0) {
        break label1657;
      }
      localObject1 = paramdqs.HEF;
      localObject2 = ((gx)localObject1).Fzb;
      str = bt.cE(com.tencent.mm.platformtools.z.a(((gx)localObject1).Fzc));
      ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((gx)localObject1).Fzf, Integer.valueOf(((gx)localObject1).Fzg), Integer.valueOf(((gx)localObject1).Fzh), Integer.valueOf(((gx)localObject1).Fzi), bt.aRp((String)localObject2), bt.aRp(str), ((gx)localObject1).Fsp });
      k = ((gx)localObject1).FyV;
      localObject3 = new p(bt.n((Integer)localai.get(9, Integer.valueOf(0))));
      if (((gx)localObject1).FyW != null) {
        break label1503;
      }
      i = -1;
      ad.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject3, Integer.valueOf(i) });
      if (k == 0) {
        break label1634;
      }
      if (k != 1) {
        break label1515;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.z.a(((gx)localObject1).FyW);
      bool1 = com.tencent.mm.kernel.g.ajA().aiC().a(((p)localObject3).longValue(), arrayOfByte);
      ad.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject3 = bt.cE(com.tencent.mm.kernel.g.ajA().aiC().rQ(((p)localObject3).longValue()));
      localai.set(-1535680990, localObject2);
      localai.set(46, str);
      localai.set(72, localObject3);
      localai.set(29, ((gx)localObject1).Fsp);
      ad.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((gx)localObject1).FyX != null)
      {
        localObject2 = bt.cE(com.tencent.mm.platformtools.z.a(((gx)localObject1).FyX.FEt));
        if ((localObject2 != null) && (((String)localObject2).length() > 0))
        {
          localai.set(47, localObject2);
          com.tencent.mm.kernel.g.ajC().gBh.set(18, localObject2);
        }
        ad.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { bt.aRp((String)localObject2) });
      }
      localObject2 = aj.getContext().getSharedPreferences("auth_info_key_prefs", com.tencent.mm.compatible.util.g.abm()).edit();
      if (((gx)localObject1).Fzn != 1) {
        break label1640;
      }
      bool2 = true;
      label1118:
      bool2 = ((SharedPreferences.Editor)localObject2).putBoolean("auth_info_prefs_use_new_ecdh", bool2).commit();
      k = ((gx)localObject1).Fzn;
      if (!bool2) {
        break label1646;
      }
      i = 1;
      label1151:
      ad.i("MicroMsg.HandleAuthResponse", "summerauth get ecdh flag %d, set local cache %d ", new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      if (((gx)localObject1).Fzn != 1) {
        break label1651;
      }
      bool2 = true;
      label1190:
      com.tencent.mm.protocal.f.Fns = bool2;
      label1195:
      if ((j & 0x4) == 0) {
        break label1682;
      }
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 23L, 1L, false);
      localObject1 = paramdqs.HEH;
      bb.a(false, ((ccd)localObject1).FEd, ((ccd)localObject1).FEe, ((ccd)localObject1).FEc);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        localObject1 = u.aAm();
        if (bool1)
        {
          i = 1;
          localObject1 = u.aAl();
        }
        ad.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.F(1, i, (String)localObject1);
      }
      localai.set(3, "");
      localai.set(19, "");
      localai.fqc();
      com.tencent.mm.kernel.g.ajC().gBh.setInt(46, 0);
      a.azk();
      if ((j & 0x8) == 0) {
        break label1693;
      }
      ad.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramdqs.HEI);
      AppMethodBeat.o(134110);
      return;
      i = paramdqs.HEF.Fzh;
      break;
      label1381:
      ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      label1392:
      l = 41L;
      break label247;
      label1400:
      localObject1 = com.tencent.mm.plugin.report.e.ygI;
      if (paramdqs.HEF.Fzh == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
        break;
      }
      label1444:
      localai.set(al.a.IpS, Long.valueOf(paramdqs.HEF.Fzh));
      localai.set(al.a.IpU, Long.valueOf(bt.aQJ()));
      localai.set(al.a.IpT, Long.valueOf(0L));
      break label259;
      label1492:
      ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label667;
      label1503:
      i = ((gx)localObject1).FyW.getILen();
      break label823;
      label1515:
      if (k == 2)
      {
        com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 21L, 1L, false);
        com.tencent.mm.kernel.g.ajA().aiC().rR(((p)localObject3).longValue());
        localObject3 = bt.cE(com.tencent.mm.kernel.g.ajA().aiC().rQ(((p)localObject3).longValue()));
        localai.set(-1535680990, localObject2);
        localai.set(46, str);
        localai.set(72, localObject3);
        localai.set(29, ((gx)localObject1).Fsp);
        bool1 = false;
        break label988;
      }
      ad.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
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
      ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.e.ygI.idkeyStat(148L, 22L, 1L, false);
      break label1195;
      label1682:
      ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
    label1693:
    ad.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
    AppMethodBeat.o(134110);
  }
  
  public static void a(ht paramht)
  {
    AppMethodBeat.i(134111);
    if (paramht == null) {}
    Object localObject1;
    for (int i = -1;; i = paramht.nDi)
    {
      ad.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      com.tencent.mm.kernel.g.ajD();
      localObject1 = com.tencent.mm.kernel.g.ajB().gAO.hOv;
      if ((localObject1 != null) && (((com.tencent.mm.network.e)localObject1).aFc() != null)) {
        break;
      }
      AppMethodBeat.o(134111);
      return;
    }
    ((com.tencent.mm.network.e)localObject1).aFc().aFb();
    if ((paramht == null) || (paramht.nDi == 0))
    {
      ad.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(134111);
      return;
    }
    LinkedList localLinkedList = paramht.nDj;
    if ((localLinkedList == null) || (localLinkedList.size() != paramht.nDi)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      ad.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramht.nDi) });
      ad.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
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
      i = ((hs)localObject2).FAh;
      Object localObject3 = ((hs)localObject2).FAj;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        ad.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.e)localObject1).aFc().h(i, ((bor)localObject3).toByteArray());
        localObject2 = new String[((bor)localObject3).nDj.size()];
        arrayOfString = new String[((bor)localObject3).nDj.size()];
        arrayOfInt = new int[((bor)localObject3).nDj.size()];
        ad.i("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((bor)localObject3).nDi) });
        localObject3 = ((bor)localObject3).nDj.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          boq localboq = (boq)((Iterator)localObject3).next();
          ad.i("MicroMsg.HandleAuthResponse", "ax host org:%s sub:%s", new Object[] { localboq.GJt, localboq.GJu });
          localObject2[i] = localboq.GJt;
          arrayOfString[i] = localboq.GJu;
          arrayOfInt[i] = localboq.GJv;
          int j = i + 1;
          i = j;
          if (!bt.isNullOrNil(localboq.GJt))
          {
            i = j;
            if (!bt.isNullOrNil(localboq.GJu)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { bt.n(localException) });
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
      h.LTJ.aR(new ae.1((hs)localObject1));
    }
    AppMethodBeat.o(134111);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.ae
 * JD-Core Version:    0.7.0.1
 */
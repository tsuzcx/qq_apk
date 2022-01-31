package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.c;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ar;
import com.tencent.mm.protocal.protobuf.avj;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.bfu;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.cvh;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.protocal.protobuf.gk;
import com.tencent.mm.protocal.protobuf.gl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.z;
import java.util.Iterator;
import java.util.LinkedList;

public final class aa
{
  public static void a(cmm paramcmm, boolean paramBoolean)
  {
    AppMethodBeat.i(123394);
    int j = paramcmm.xWl;
    int i;
    label96:
    z localz;
    Object localObject1;
    long l;
    label247:
    boolean bool;
    label259:
    label667:
    String str1;
    String str2;
    int k;
    Object localObject2;
    if (paramcmm.xWm == null)
    {
      i = -1;
      ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile succ update:%d unifyFlag:%d, auth:%s, acct:%s, network:%s autoauth:%b", new Object[] { Integer.valueOf(i), Integer.valueOf(j), paramcmm.xWm, paramcmm.xWn, paramcmm.xWo, Boolean.valueOf(paramBoolean) });
      i = 0;
      if (((j & 0x1) == 0) || (paramcmm.xWm == null)) {
        break label1273;
      }
      i = paramcmm.xWm.lGw;
      g.RM();
      g.jO(i);
      com.tencent.mm.kernel.a.b.e.Sn();
      localz = g.RL().Ru();
      localz.set(256, Boolean.FALSE);
      if ((j & 0x1) != 0)
      {
        if (paramcmm.xWm.wrY <= 0) {
          break label1336;
        }
        localz.set(ac.a.yxr, Long.valueOf(paramcmm.xWm.wrY));
        localz.set(ac.a.yxt, Long.valueOf(bo.aox()));
        localz.set(ac.a.yxs, Long.valueOf(com.tencent.mm.protocal.d.whH));
        ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile need update flag[%d], autoauth[%b]", new Object[] { Integer.valueOf(paramcmm.xWm.wrY), Boolean.valueOf(paramBoolean) });
        if (!paramBoolean) {
          break label1292;
        }
        localObject1 = com.tencent.mm.plugin.report.e.qrI;
        if (paramcmm.xWm.wrY != 2) {
          break label1284;
        }
        l = 19L;
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
      }
      if ((j & 0x2) == 0) {
        break label1384;
      }
      localObject1 = paramcmm.xWn;
      ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect BindUin:%s, Status:%d, UserName:%s, NickName:%s, BindEmail:%s, BindMobile:%s, Alias:%s, PluginFlag:%d, RegType:%d, DeviceInfoXml:%s, SafeDevice:%d, OfficialUserName:%s, OfficialUserName:%s PushMailStatus:%d, FSURL:%s", new Object[] { com.tencent.mm.a.p.getString(((ar)localObject1).wmq), Integer.valueOf(((ar)localObject1).jJS), ((ar)localObject1).jJA, ((ar)localObject1).jKG, ((ar)localObject1).wmr, ((ar)localObject1).wms, ((ar)localObject1).gwU, Integer.valueOf(((ar)localObject1).wmt), Integer.valueOf(((ar)localObject1).wmu), ((ar)localObject1).wmv, Integer.valueOf(((ar)localObject1).wmw), ((ar)localObject1).wmx, ((ar)localObject1).wmx, Integer.valueOf(((ar)localObject1).wmz), ((ar)localObject1).wmA });
      if (!paramBoolean) {
        localz.set(52, Integer.valueOf(((ar)localObject1).wmu));
      }
      localz.set(9, Integer.valueOf(((ar)localObject1).wmq));
      localz.set(7, Integer.valueOf(((ar)localObject1).jJS));
      localz.set(2, ((ar)localObject1).jJA);
      localz.set(4, ((ar)localObject1).jKG);
      localz.set(5, ((ar)localObject1).wmr);
      localz.set(6, ((ar)localObject1).wms);
      localz.set(42, ((ar)localObject1).gwU);
      localz.set(34, Integer.valueOf(((ar)localObject1).wmt));
      g.RL().Rv().asC(((ar)localObject1).wmv);
      localz.set(64, Integer.valueOf(((ar)localObject1).wmw));
      localz.set(21, ((ar)localObject1).wmx);
      localz.set(22, ((ar)localObject1).wmx);
      localz.set(17, Integer.valueOf(((ar)localObject1).wmz));
      av.flM.ao("login_weixin_username", ((ar)localObject1).jJA);
      av.flM.ao("last_login_nick_name", ((ar)localObject1).jKG);
      av.flM.d(((ar)localObject1).wms, ((ar)localObject1).wmq, ((ar)localObject1).wmr);
      bool = false;
      if ((j & 0x1) == 0) {
        break label1532;
      }
      localObject1 = paramcmm.xWm;
      str1 = ((ft)localObject1).wrS;
      str2 = bo.cg(com.tencent.mm.platformtools.aa.a(((ft)localObject1).wrT));
      ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile AuthTicket:%s, NewVersion:%d, UpdateFlag:%d, AuthResultFlag:%d, authKey:%s a2Key:%s fsurl:%s", new Object[] { ((ft)localObject1).wrW, Integer.valueOf(((ft)localObject1).wrX), Integer.valueOf(((ft)localObject1).wrY), Integer.valueOf(((ft)localObject1).wrZ), bo.aqg(str1), bo.aqg(str2), ((ft)localObject1).wmA });
      k = ((ft)localObject1).wrM;
      localObject2 = new com.tencent.mm.a.p(bo.g((Integer)localz.get(9, Integer.valueOf(0))));
      if (((ft)localObject1).wrN != null) {
        break label1395;
      }
      i = -1;
      label823:
      ab.i("MicroMsg.HandleAuthResponse", "summerauth updateProfile wtBuffFlag:%d, bindQQ:%s buff len:%d", new Object[] { Integer.valueOf(k), localObject2, Integer.valueOf(i) });
      if (k == 0) {
        break label1526;
      }
      if (k != 1) {
        break label1407;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 20L, 1L, false);
      byte[] arrayOfByte = com.tencent.mm.platformtools.aa.a(((ft)localObject1).wrN);
      bool = g.RJ().QN().a(((com.tencent.mm.a.p)localObject2).longValue(), arrayOfByte);
      ab.i("MicroMsg.HandleAuthResponse", "WTLoginRspBuff len %s", new Object[] { Integer.valueOf(arrayOfByte.length) });
      localObject2 = bo.cg(g.RJ().QN().gD(((com.tencent.mm.a.p)localObject2).longValue()));
      localz.set(-1535680990, str1);
      localz.set(46, str2);
      localz.set(72, localObject2);
      localz.set(29, ((ft)localObject1).wmA);
      label988:
      ab.i("MicroMsg.HandleAuthResponse", "wtBuffFlag %s", new Object[] { Integer.valueOf(k) });
      if (((ft)localObject1).wrO != null)
      {
        localObject1 = bo.cg(com.tencent.mm.platformtools.aa.a(((ft)localObject1).wrO.wwo));
        if ((localObject1 != null) && (((String)localObject1).length() > 0))
        {
          localz.set(47, localObject1);
          g.RL().eHM.set(18, localObject1);
        }
        ab.i("MicroMsg.HandleAuthResponse", "updateProfile ksid:%s", new Object[] { bo.aqg((String)localObject1) });
      }
      label1087:
      if ((j & 0x4) == 0) {
        break label1557;
      }
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 23L, 1L, false);
      localObject1 = paramcmm.xWo;
      ax.a(false, ((bfu)localObject1).wvY, ((bfu)localObject1).wvZ, ((bfu)localObject1).wvX);
    }
    for (;;)
    {
      if (paramBoolean)
      {
        i = 4;
        localObject1 = r.Zn();
        if (bool)
        {
          i = 1;
          localObject1 = r.Zm();
        }
        ab.i("MicroMsg.HandleAuthResponse", "loginType %s", new Object[] { Integer.valueOf(i) });
        com.tencent.mm.plugin.report.b.d.x(1, i, (String)localObject1);
      }
      localz.set(3, "");
      localz.set(19, "");
      localz.dww();
      g.RL().eHM.setInt(46, 0);
      a.Yu();
      if ((j & 0x8) == 0) {
        break label1568;
      }
      ab.d("MicroMsg.HandleAuthResponse", "start parse axauth ");
      a(paramcmm.xWp);
      AppMethodBeat.o(123394);
      return;
      i = paramcmm.xWm.wrY;
      break;
      label1273:
      ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set and new uin is 0!");
      break label96;
      label1284:
      l = 41L;
      break label247;
      label1292:
      localObject1 = com.tencent.mm.plugin.report.e.qrI;
      if (paramcmm.xWm.wrY == 2) {}
      for (l = 10L;; l = 11L)
      {
        ((com.tencent.mm.plugin.report.e)localObject1).idkeyStat(148L, l, 1L, true);
        break;
      }
      label1336:
      localz.set(ac.a.yxr, Long.valueOf(paramcmm.xWm.wrY));
      localz.set(ac.a.yxt, Long.valueOf(bo.aox()));
      localz.set(ac.a.yxs, Long.valueOf(0L));
      break label259;
      label1384:
      ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile acctsect not set!");
      break label667;
      label1395:
      i = ((ft)localObject1).wrN.getILen();
      break label823;
      label1407:
      if (k == 2)
      {
        com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 21L, 1L, false);
        g.RJ().QN().gE(((com.tencent.mm.a.p)localObject2).longValue());
        localObject2 = bo.cg(g.RJ().QN().gD(((com.tencent.mm.a.p)localObject2).longValue()));
        localz.set(-1535680990, str1);
        localz.set(46, str2);
        localz.set(72, localObject2);
        localz.set(29, ((ft)localObject1).wmA);
        bool = false;
        break label988;
      }
      ab.i("MicroMsg.HandleAuthResponse", "summerauth undefined wrBuffFlag[%d]", new Object[] { Integer.valueOf(k) });
      label1526:
      bool = false;
      break label988;
      label1532:
      ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile authsect not set!");
      com.tencent.mm.plugin.report.e.qrI.idkeyStat(148L, 22L, 1L, false);
      break label1087;
      label1557:
      ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile networksect not set!");
    }
    label1568:
    ab.w("MicroMsg.HandleAuthResponse", "summerauth updateProfile axauthsect no set!");
    AppMethodBeat.o(123394);
  }
  
  public static void a(gl paramgl)
  {
    AppMethodBeat.i(154509);
    if (paramgl == null) {}
    Object localObject1;
    for (int i = -1;; i = paramgl.jJu)
    {
      ab.i("MicroMsg.HandleAuthResponse", "summerauths updateProfile axauth list[%s]", new Object[] { Integer.valueOf(i) });
      g.RM();
      localObject1 = g.RK().eHt.ftA;
      if ((localObject1 != null) && (((com.tencent.mm.network.e)localObject1).adI() != null)) {
        break;
      }
      AppMethodBeat.o(154509);
      return;
    }
    ((com.tencent.mm.network.e)localObject1).adI().adH();
    if ((paramgl == null) || (paramgl.jJu == 0))
    {
      ab.w("MicroMsg.HandleAuthResponse", "summerauthax axAuthSecRespList null or count == 0");
      AppMethodBeat.o(154509);
      return;
    }
    LinkedList localLinkedList = paramgl.jJv;
    if ((localLinkedList == null) || (localLinkedList.size() != paramgl.jJu)) {
      if (localLinkedList != null) {
        break label210;
      }
    }
    label210:
    for (i = -1;; i = localLinkedList.size())
    {
      ab.w("MicroMsg.HandleAuthResponse", "summerauthax updateProfile axauth size not match! [%s, %s]", new Object[] { Integer.valueOf(i), Integer.valueOf(paramgl.jJu) });
      ab.d("MicroMsg.HandleAuthResponse", "axauth list size " + localLinkedList.size());
      if (localLinkedList.size() != 0) {
        break;
      }
      AppMethodBeat.o(154509);
      return;
    }
    paramgl = localLinkedList.iterator();
    while (paramgl.hasNext())
    {
      Object localObject2 = (gk)paramgl.next();
      i = ((gk)localObject2).wsK;
      Object localObject3 = ((gk)localObject2).wsM;
      String[] arrayOfString;
      int[] arrayOfInt;
      try
      {
        ab.i("MicroMsg.HandleAuthResponse", "do axauth bussType ".concat(String.valueOf(i)));
        ((com.tencent.mm.network.e)localObject1).adI().g(i, ((avk)localObject3).toByteArray());
        localObject2 = new String[((avk)localObject3).jJv.size()];
        arrayOfString = new String[((avk)localObject3).jJv.size()];
        arrayOfInt = new int[((avk)localObject3).jJv.size()];
        ab.d("MicroMsg.HandleAuthResponse", "hostlist.Count=%d", new Object[] { Integer.valueOf(((avk)localObject3).jJu) });
        localObject3 = ((avk)localObject3).jJv.iterator();
        i = 0;
        while (((Iterator)localObject3).hasNext())
        {
          avj localavj = (avj)((Iterator)localObject3).next();
          ab.d("MicroMsg.HandleAuthResponse", "dkidc host org:%s sub:%s", new Object[] { localavj.xkP, localavj.xkQ });
          localObject2[i] = localavj.xkP;
          arrayOfString[i] = localavj.xkQ;
          arrayOfInt[i] = localavj.xkR;
          int j = i + 1;
          i = j;
          if (!bo.isNullOrNil(localavj.xkP))
          {
            i = j;
            if (!bo.isNullOrNil(localavj.xkQ)) {
              i = j;
            }
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.HandleAuthResponse", "exception:%s", new Object[] { bo.l(localException) });
        }
      }
      if ((localException.length > 0) && (localObject1 != null)) {
        ((com.tencent.mm.network.e)localObject1).addHostInfo(localException, arrayOfString, arrayOfInt);
      }
    }
    paramgl = localLinkedList.iterator();
    while (paramgl.hasNext())
    {
      localObject1 = (gk)paramgl.next();
      com.tencent.mm.sdk.g.d.ysm.execute(new aa.1((gk)localObject1));
    }
    AppMethodBeat.o(154509);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.model.aa
 * JD-Core Version:    0.7.0.1
 */
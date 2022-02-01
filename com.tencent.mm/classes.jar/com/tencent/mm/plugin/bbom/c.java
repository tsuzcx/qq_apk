package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.p;
import com.tencent.mm.am.ag;
import com.tencent.mm.am.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fk;
import com.tencent.mm.g.a.it;
import com.tencent.mm.g.a.lb;
import com.tencent.mm.g.a.lb.a;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.wl;
import com.tencent.mm.g.a.wm;
import com.tencent.mm.g.a.wm.b;
import com.tencent.mm.g.a.wu;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.span.j.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.acf;
import com.tencent.mm.protocal.protobuf.bzp;
import com.tencent.mm.protocal.protobuf.bzs;
import com.tencent.mm.protocal.protobuf.cai;
import com.tencent.mm.protocal.protobuf.cki;
import com.tencent.mm.protocal.protobuf.ckj;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.protocal.protobuf.dhg;
import com.tencent.mm.protocal.protobuf.vv;
import com.tencent.mm.protocal.protobuf.vw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bq.b;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.cd;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.al.f, com.tencent.mm.plugin.messenger.foundation.a.d
{
  private static int nOw = -1;
  
  private static void K(am paramam)
  {
    AppMethodBeat.i(22341);
    if ((paramam != null) && (com.tencent.mm.am.g.DP(paramam.field_username)) && (!com.tencent.mm.am.g.vd(paramam.field_username)))
    {
      com.tencent.mm.model.ba.aBQ();
      at localat = com.tencent.mm.model.c.azv().aTz(paramam.field_username);
      paramam = ag.aFZ().DD(paramam.field_username);
      if (!com.tencent.mm.am.g.DS(paramam.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localat == null)
      {
        localat = new at(paramam.field_username);
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramam.Kv(), paramam.field_username });
        localat.tD(bt.nullAsNil(paramam.Kv()));
        localat.fqK();
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().e(localat);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  public static boolean Wx(String paramString)
  {
    AppMethodBeat.i(22339);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = j.a.Fht.matcher(paramString);
    if (localMatcher.find())
    {
      if (bt.lQ(paramString, localMatcher.group(0)))
      {
        AppMethodBeat.o(22339);
        return true;
      }
      AppMethodBeat.o(22339);
      return false;
    }
    AppMethodBeat.o(22339);
    return false;
  }
  
  private static void a(bzp parambzp, String paramString, am paramam, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = u.aAm();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = ag.aFZ().DD(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = parambzp.jdm;
      parambzp = parambzp.GOb;
      if (parambzp != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = parambzp.jdq;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = parambzp.jds;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = parambzp.jdt;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = parambzp.jdr;
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bt.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).bX(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).bX(false) != null) && (((com.tencent.mm.api.c)localObject).bX(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).bX(false).KP() != null) && (!bt.isNullOrNil(((com.tencent.mm.api.c)localObject).Kv())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).Kv();
        ad.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!ag.aFZ().g((com.tencent.mm.api.c)localObject)) {
        ag.aFZ().f((com.tencent.mm.api.c)localObject);
      }
      paramam.kl(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  public static boolean a(am paramam, bzp parambzp, boolean paramBoolean)
  {
    AppMethodBeat.i(22338);
    if ((paramam == null) || (bt.isNullOrNil(paramam.field_username)))
    {
      ad.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(22338);
      return false;
    }
    String str = paramam.field_username;
    Object localObject1 = paramam.field_encryptUsername;
    Object localObject2 = com.tencent.mm.ak.c.a(str, parambzp);
    p.aEx().b((com.tencent.mm.ak.i)localObject2);
    localObject2 = parambzp.GOa;
    if ((!paramam.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((dhg)localObject2).jdn + " " + parambzp.GbY);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((dhg)localObject2).jdo);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dhg)localObject2).jdp);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dhg)localObject2).HvJ);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dhg)localObject2).HvK);
      if (o.zbT != null) {
        o.zbT.a(paramam.field_username, (dhg)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.o.b.lM(paramam.field_type))
    {
      bool = com.tencent.mm.bk.d.aMo().gn(str, 1);
      if (!bool) {
        break label429;
      }
      ad.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.o.b.lM(paramam.field_type)) && ((paramam.getSource() == 10) || (paramam.getSource() == 13)))
      {
        t.m(aj.getContext(), paramam.field_username, paramam.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramam.field_encryptUsername);
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).jdb)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramam.field_username;
          ad.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).jdb, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(parambzp, str, paramam, paramBoolean);
      AppMethodBeat.o(22338);
      return true;
      label429:
      bool = com.tencent.mm.bk.d.aMo().gn((String)localObject1, 1);
      ad.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(am paramam, cf paramcf)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!bt.isNullOrNil(paramcf.field_conDescription)) {
      paramam.tr(paramcf.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!w.zC(paramam.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.o.b.lM(paramam.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bt.isNullOrNil(paramcf.field_conDescription))
        {
          bzs localbzs = new bzs();
          localbzs.GUK = paramam.field_username;
          localbzs.Desc = paramcf.field_conDescription;
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azo().c(new k.a(54, localbzs));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  private static void cr(String paramString, int paramInt)
  {
    AppMethodBeat.i(22342);
    br[] arrayOfbr = null;
    cd[] arrayOfcd;
    Object localObject1;
    bh[] arrayOfbh;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ad.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfcd = com.tencent.mm.bk.d.aMq().aUx(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aj.getContext(), arrayOfcd);
      arrayOfbh = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(22342);
      return;
      if (paramInt == 18)
      {
        ad.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbr = com.tencent.mm.bk.d.aMp().aTY(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aj.getContext(), arrayOfbr);
        arrayOfcd = null;
        arrayOfbh = null;
      }
      else
      {
        arrayOfbh = com.tencent.mm.bk.d.aMn().aTV(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aj.getContext(), arrayOfbh);
        arrayOfcd = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bu localbu;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbu = new bu();
      localbu.setContent(localObject2.hDo);
      m = w.Ar(localObject2.username);
      if (arrayOfbh != null)
      {
        j = paramInt + 1;
        localbu.qA(arrayOfbh[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label533:
    for (;;)
    {
      label215:
      localbu.tN(localObject2.username);
      localbu.setType(m);
      label252:
      long l;
      if (localObject2.dNR)
      {
        localbu.setStatus(2);
        localbu.kr(1);
        com.tencent.mm.model.ba.aBQ();
        l = com.tencent.mm.model.c.azs().as(localbu);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbr != null)
        {
          j = paramInt + 1;
          localbu.qA(arrayOfbr[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfcd == null) {
          break label533;
        }
        j = paramInt + 1;
        localbu.qA(arrayOfcd[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbu.setStatus(6);
        localbu.kr(0);
        break label252;
      }
      localObject1 = new bu();
      if (arrayOfbh != null) {
        ((bu)localObject1).qA(arrayOfbh[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bu)localObject1).tN(paramString);
        ((bu)localObject1).setContent(aj.getContext().getString(2131764537));
        ((bu)localObject1).setType(10000);
        ((bu)localObject1).setStatus(6);
        ((bu)localObject1).kr(0);
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azs().as((bu)localObject1);
        AppMethodBeat.o(22342);
        return;
        if (arrayOfbr != null) {
          ((bu)localObject1).qA(arrayOfbr[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcd != null) {
          ((bu)localObject1).qA(arrayOfcd[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(am paramam1, am paramam2, bzp parambzp, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paramam1.field_username;
    String str1 = paramam1.field_encryptUsername;
    if ((paramam2 != null) && (!bt.nullAsNil(paramam2.ePE).equals(bt.nullAsNil(parambzp.GUB))))
    {
      com.tencent.mm.be.c.aKd();
      com.tencent.mm.be.c.Gf(str2);
    }
    if (!bt.cC(paramArrayOfByte))
    {
      if (am.aaR(paramam1.field_verifyFlag)) {
        a(parambzp, str2, paramam1, true);
      }
      if ((paramam2 == null) || (com.tencent.mm.o.b.lM(paramam2.field_type)) || (!com.tencent.mm.o.b.lM(paramam1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (w.zC(str2))) {
        com.tencent.mm.plugin.report.service.g.yhR.dD(931, 22);
      }
      Object localObject1 = paramam1.field_username;
      if (parambzp.GUC == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bt.n(Integer.valueOf(parambzp.GUC.HdV.size()))))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(nOw) });
        if (nOw == -1) {
          nOw = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qEz, 0);
        }
        if (nOw != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((parambzp.GUC == null) || (parambzp.GUC.HdV == null)) {
          break label335;
        }
        paramArrayOfByte = parambzp.GUC.HdV.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (cki)paramArrayOfByte.next();
          if (((cki)localObject1).HdU != null) {
            localStringBuffer.append(((cki)localObject1).HdU).append("，");
          }
        }
        a(paramam1, parambzp, true);
        break;
      }
      label335:
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramam1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paramam2 != null)
      {
        localObject1 = paramam2.ePJ;
        paramArrayOfByte = com.tencent.mm.o.a.a(paramam2, (String)localObject1);
      }
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        paramam2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        com.tencent.mm.model.ba.aBQ();
        localObject3 = com.tencent.mm.model.c.azq().aqz(str1);
        paramam2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((cf)localObject3).field_conPhone;
          paramam2 = paramArrayOfByte;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            paramam2 = ((String)localObject1).split(",");
            localObject2 = localObject1;
          }
        }
      }
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramam1.field_username, bt.nullAsNil((String)localObject2) });
      int i;
      if ((paramam2 != null) && (paramam2.length > 0))
      {
        paramArrayOfByte = com.tencent.mm.o.a.aj(localStringBuffer.toString(), "，");
        int i2 = paramam2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          localObject1 = paramam2[k];
          int n = i;
          int i1 = m;
          if (paramArrayOfByte != null)
          {
            n = i;
            i1 = m;
            if (paramArrayOfByte.length > 0)
            {
              i1 = paramArrayOfByte.length;
              n = 0;
              while (n < i1) {
                if (!bt.lQ((String)localObject1, paramArrayOfByte[n]))
                {
                  i = 1;
                  n += 1;
                }
                else
                {
                  i = 0;
                }
              }
              n = i;
              i1 = m;
              if (i != 0)
              {
                n = i;
                i1 = m;
                if (Wx((String)localObject1))
                {
                  localStringBuffer.append((String)localObject1).append("，");
                  i1 = 1;
                  n = i;
                }
              }
            }
          }
          k += 1;
          i = n;
          m = i1;
        }
        if (m != 0)
        {
          paramam2 = new cai();
          paramam2.GUK = paramam1.field_username;
          paramArrayOfByte = new ckj();
          localObject1 = com.tencent.mm.o.a.aj(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.nDi = localObject1.length;
            paramArrayOfByte.HdV = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new cki();
              ((cki)localObject3).HdU = ((String)localObject2);
              paramArrayOfByte.HdV.add(localObject3);
              i += 1;
            }
            paramam2.GUC = paramArrayOfByte;
            com.tencent.mm.model.ba.aBQ();
            com.tencent.mm.model.c.azo().c(new k.a(60, paramam2));
          }
        }
        if ((j != 0) && (15 == parambzp.tRT) && (!bt.isNullOrNil(paramam1.field_username)))
        {
          paramam2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(paramam1.field_username);
          if (paramam2 != null)
          {
            paramArrayOfByte = com.tencent.mm.o.a.aj(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.g.yhR;
            localObject2 = paramam1.field_username;
            if (!bt.isNullOrNil(paramam2.Lb())) {
              break label1291;
            }
            j = 0;
            if (paramArrayOfByte != null) {
              break label1297;
            }
            i = 0;
            ((com.tencent.mm.plugin.report.service.g)localObject1).f(12040, new Object[] { localObject2, Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramam1.field_username, localStringBuffer.toString() });
      paramam2 = localStringBuffer.toString();
      label998:
      paramam2 = bt.bI(paramam2, "");
      ad.i("MicroMsg.BigBallContactAssemblerImpl", paramam2);
      paramam1.tx(paramam2);
      if ((!w.vF(str2)) && (parambzp.GwB != null)) {
        q.a(str2, parambzp.GwB);
      }
      boolean bool1 = false;
      com.tencent.mm.model.ba.aBQ();
      paramArrayOfByte = com.tencent.mm.model.c.azq().aqz(paramam1.field_username);
      if (!bt.isNullOrNil(paramam1.field_conRemark))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!bt.isNullOrNil(paramam1.ePD)) && (!paramam1.ePD.equals(paramArrayOfByte.field_conDescription))) {
          a(paramam1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramam1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          w.B(paramam1);
        }
        paramam2 = null;
        com.tencent.mm.model.ba.aBQ();
        paramArrayOfByte = com.tencent.mm.model.c.azq().aqz(paramam1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramam2 = paramArrayOfByte.field_contactLabels;
        }
        parambzp = paramam2;
        if (bt.isNullOrNil(paramam2))
        {
          com.tencent.mm.model.ba.aBQ();
          localObject1 = com.tencent.mm.model.c.azq().aqz(paramam1.field_username);
          parambzp = paramam2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            parambzp = ((cf)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bt.isNullOrNil(parambzp))
        {
          com.tencent.mm.plugin.label.a.a.dfo().hC(paramam1.field_username, parambzp);
          paramArrayOfByte.field_contactLabels = "";
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azq().replace(paramArrayOfByte);
        }
        AppMethodBeat.o(22335);
        return;
        j = 1;
        break;
        if (paramArrayOfByte.length >= 5)
        {
          i = 5;
          break label925;
        }
        i = paramArrayOfByte.length;
        break label925;
        paramam2 = new StringBuffer();
        if ((parambzp.GUC != null) && (parambzp.GUC.HdV != null))
        {
          paramArrayOfByte = parambzp.GUC.HdV.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (cki)paramArrayOfByte.next();
            if (((cki)localObject1).HdU != null) {
              paramam2.append(((cki)localObject1).HdU).append("，");
            }
          }
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramam1.field_username, paramam2.toString() });
        paramam2 = paramam2.toString();
        break label998;
        if (paramArrayOfByte != null)
        {
          paramam2 = paramArrayOfByte;
          if (!bt.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
          paramam2 = paramArrayOfByte;
          if (!bt.isNullOrNil(str1))
          {
            com.tencent.mm.model.ba.aBQ();
            paramam2 = com.tencent.mm.model.c.azq().aqz(str1);
          }
        }
        paramBoolean = bool1;
        if (paramam2 != null)
        {
          paramBoolean = bool1;
          if (!bt.isNullOrNil(paramam2.field_encryptUsername))
          {
            ad.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramam2.field_encryptUsername);
            paramam1.sR(paramam2.field_conRemark);
            paramam1.sX(com.tencent.mm.platformtools.f.IL(paramam2.field_conRemark));
            paramam1.sY(com.tencent.mm.platformtools.f.IM(paramam2.field_conRemark));
            paramBoolean = a(paramam1, paramam2);
          }
        }
        switch (paramam1.getSource())
        {
        }
      }
      paramam2 = null;
      if ((parambzp != null) && (!bt.isNullOrNil(parambzp.GUv)))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { parambzp.GUv, parambzp.GUw });
        paramArrayOfByte = com.tencent.mm.plugin.account.a.getAddrUploadStg();
        paramam2 = parambzp.GUv;
        localObject1 = parambzp.GUw;
        parambzp = paramArrayOfByte.Jx(paramam2);
        paramam2 = parambzp;
        if (parambzp == null) {
          paramam2 = paramArrayOfByte.Jx((String)localObject1);
        }
        if (paramam2 != null) {
          break label1919;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramam2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bt.isNullOrNil(paramam2.aSy())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramam2.aSF()) {
          break;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramam2.aSy(), paramam2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramam2.username = paramam1.field_username;
        paramam2.status = 2;
        paramam2.aSE();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramam1.sR(paramam2.aSy());
          paramam1.sX(com.tencent.mm.platformtools.f.IL(paramam2.aSy()));
          paramam1.sY(com.tencent.mm.platformtools.f.IM(paramam2.aSy()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.o.b.lM(paramam1.field_type)) {
          break;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramam2.aSy(), paramam2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramam2.Lb(), paramam2);
        bool1 = bool2;
        break;
        if (bt.isNullOrNil(str1)) {
          break label1694;
        }
        paramam2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(str1);
        break label1694;
        label1919:
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bt.nullAsNil(paramam2.aSy()), bt.nullAsNil(paramam2.getUsername()), Boolean.valueOf(paramam2.aSF()) });
      }
    }
  }
  
  public final void b(am paramam1, am paramam2, bzp parambzp, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paramam1.field_username;
    Object localObject2 = paramam1.field_encryptUsername;
    Object localObject1;
    Object localObject3;
    label138:
    label209:
    int k;
    label257:
    int m;
    Object localObject4;
    int n;
    int i1;
    if (w.vF(paramArrayOfByte))
    {
      if (parambzp.GwB != null)
      {
        localObject1 = parambzp.GwB.FVk;
        if (com.tencent.mm.bj.d.irv != null) {
          break label2001;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = parambzp.GwB.FVk;
          localObject3 = new wm();
          ((wm)localObject3).dKN.dKP = true;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bt.isNullOrNil(paramArrayOfByte)) && (w.vF(paramArrayOfByte)) && (!bt.isNullOrNil(((wm)localObject3).dKO.dKR)) && (paramArrayOfByte.equals(((wm)localObject3).dKO.dKR))) {
            break label2271;
          }
        }
        localObject1 = parambzp.GwB.FVk;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (vw)((Iterator)localObject1).next();
          } while ((bt.isNullOrNil(((vw)localObject3).nDo)) || (!((vw)localObject3).nDo.equals(u.aAm())));
        }
        i = 0;
        if (i != 0)
        {
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).arf(paramArrayOfByte);
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(aj.getContext());
        }
      }
      if (parambzp.GwB != null) {
        break label2420;
      }
      i = 0;
      localObject1 = parambzp.GUq;
      localObject3 = parambzp.GUp;
      k = parambzp.GUA;
      m = parambzp.GUz;
      localObject4 = parambzp.ukw;
      n = parambzp.GUy;
      i1 = parambzp.GUD;
      if (parambzp.GwB != null) {
        break label2432;
      }
    }
    label2432:
    for (int j = -1;; j = parambzp.GwB.FVl)
    {
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s chatroomVersion:%d chatroomInfoVersion:%s infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j) });
      if ((parambzp.GwB != null) && (parambzp.GwB.fLb != 0))
      {
        localObject1 = new com.tencent.mm.k.a.a.a();
        ((com.tencent.mm.k.a.a.a)localObject1).type = parambzp.GUA;
        ((com.tencent.mm.k.a.a.a)localObject1).maxCount = parambzp.GUz;
        ((com.tencent.mm.k.a.a.a)localObject1).fVh = parambzp.ukw;
        ((com.tencent.mm.k.a.a.a)localObject1).fVi = parambzp.GUy;
        if (parambzp.GwB.FVl == 0) {
          ((com.tencent.mm.k.a.a.a)localObject1).dAm = parambzp.GUy;
        }
        localObject3 = new mn();
        ((mn)localObject3).dAl.chatroomName = paramArrayOfByte;
        ((mn)localObject3).dAl.dAm = ((com.tencent.mm.k.a.a.a)localObject1).dAm;
        q.a(paramArrayOfByte, parambzp.GUp, parambzp.GwB, parambzp.GUE, parambzp.GUD, u.aAm(), (com.tencent.mm.k.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
      try
      {
        bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azv().JI(paramArrayOfByte);
        bool2 = q.yV(paramArrayOfByte);
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((bool1) && (bool2))
        {
          localObject1 = new it();
          ((it)localObject1).dvr.dvs = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
          q.ad(paramArrayOfByte, parambzp.GUA);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool1;
          boolean bool2;
          long l;
          ad.e("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s, exception:%s %s", new Object[] { paramArrayOfByte, localException.getClass().getSimpleName(), localException.getMessage() });
          continue;
          if ((paramam1.fqg()) && (com.tencent.mm.am.g.DN(paramam1.field_username)) && (paramam1 != null) && (paramam1.fqg()) && (com.tencent.mm.am.g.DN(paramam1.field_username)))
          {
            ad.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramam1.field_username);
            com.tencent.mm.model.ba.aBQ();
            at localat = com.tencent.mm.model.c.azv().aTz(paramam1.field_username);
            ag.aFZ().DD(paramam1.field_username);
            if (localat == null)
            {
              com.tencent.mm.model.ba.aBQ();
              if (com.tencent.mm.model.c.azv().aTz("officialaccounts") == null)
              {
                localat = new at("officialaccounts");
                localat.fqK();
                com.tencent.mm.model.ba.aBQ();
                com.tencent.mm.model.c.azv().e(localat);
              }
              localat = new at(paramam1.field_username);
              localat.tD("officialaccounts");
              com.tencent.mm.model.ba.aBQ();
              com.tencent.mm.model.c.azv().e(localat);
              continue;
              if (((paramam2 == null) || ((paramam2.field_type & 0x800) != (paramam1.field_type & 0x800))) && (com.tencent.mm.am.g.DP(paramam1.field_username)) && (!com.tencent.mm.am.g.vd(paramam1.field_username)))
              {
                K(paramam1);
                continue;
                ad.i("MicroMsg.BigBallContactAssemblerImpl", "update stranger ok, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, parambzp.GtU });
                continue;
                if (com.tencent.mm.am.g.DS(paramam1.field_username))
                {
                  com.tencent.mm.model.ba.aBQ();
                  if (com.tencent.mm.model.c.azv().aTz(paramam1.field_username) == null)
                  {
                    paramArrayOfByte = ag.aFZ().DD(paramam1.field_username);
                    localat = new at(paramam1.field_username);
                    ad.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.Kv(), paramam1.field_username });
                    localat.tD(bt.nullAsNil(paramArrayOfByte.Kv()));
                    localat.fqK();
                    com.tencent.mm.model.ba.aBQ();
                    com.tencent.mm.model.c.azv().e(localat);
                    continue;
                    i = 0;
                    continue;
                    if ((paramam2 == null) || ((paramam2.field_type & 0x8) != (paramam1.field_type & 0x8)))
                    {
                      com.tencent.mm.model.ba.aBQ();
                      com.tencent.mm.model.c.azv().c(new String[] { paramam1.field_username }, "");
                      continue;
                      paramam2.fqK();
                      continue;
                      bool1 = false;
                    }
                  }
                }
              }
            }
          }
        }
      }
      if ((!com.tencent.mm.o.b.lM(paramam1.field_type)) && (!paramam1.adi()) && (!am.zs(paramam1.field_username)) && (!w.vF(paramam1.field_username)) && (!am.ail(paramam1.field_username)))
      {
        ad.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramam1.field_username, Integer.valueOf(paramam1.field_type) });
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().aTx(paramam1.field_username);
      }
      if ((paramam1.field_type & 0x800) == 0) {
        break label2671;
      }
      if ((paramam2 == null) || ((paramam2.field_type & 0x800) != (paramam1.field_type & 0x800)))
      {
        if ((!com.tencent.mm.am.g.DP(paramam1.field_username)) || (com.tencent.mm.am.g.vd(paramam1.field_username))) {
          break label2485;
        }
        K(paramam1);
      }
      if ((paramam2 == null) || (com.tencent.mm.o.b.lM(paramam2.field_type)) || (!com.tencent.mm.o.b.lM(paramam1.field_type))) {
        break label2930;
      }
      bool1 = true;
      if (com.tencent.mm.o.b.lM(paramam1.field_type))
      {
        com.tencent.mm.model.ba.aBQ();
        localObject1 = com.tencent.mm.model.c.azq().aqz(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bt.isNullOrNil(((cf)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bt.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.model.ba.aBQ();
            paramArrayOfByte = com.tencent.mm.model.c.azq().aqz((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bt.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azq().aqA(paramArrayOfByte.field_encryptUsername);
        }
      }
      if ((com.tencent.mm.o.b.lM(paramam1.field_type)) && (!bt.isNullOrNil(parambzp.GtU)))
      {
        com.tencent.mm.model.ba.aBQ();
        paramArrayOfByte = com.tencent.mm.model.c.azr().apO(parambzp.GbY.HoB);
        if ((paramArrayOfByte != null) && (!bt.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          paramArrayOfByte.field_username = parambzp.GtU;
          paramArrayOfByte.field_modifyTime = System.currentTimeMillis();
          com.tencent.mm.model.ba.aBQ();
          if (com.tencent.mm.model.c.azr().replace(paramArrayOfByte)) {
            break label2721;
          }
          ad.e("MicroMsg.BigBallContactAssemblerImpl", "update stranger fail, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, parambzp.GtU });
        }
      }
      if (com.tencent.mm.am.g.DO(paramam1.field_username))
      {
        ag.aGi();
        e.a(paramam1.field_username, null);
        if ((bool1) && (com.tencent.mm.am.g.DP(paramam1.field_username)))
        {
          if (!com.tencent.mm.am.g.vd(paramam1.field_username)) {
            break label2751;
          }
          ag.aGh();
          com.tencent.mm.am.a.h.a(paramam1.field_username, null);
        }
      }
      paramArrayOfByte = com.tencent.mm.am.g.eS(paramam1.field_username);
      if (paramArrayOfByte == null) {
        break label2867;
      }
      paramArrayOfByte = paramArrayOfByte.bX(false);
      if (paramArrayOfByte == null) {
        break label2867;
      }
      i = 0;
      if (paramArrayOfByte.cQv != null) {
        i = paramArrayOfByte.cQv.optInt("WXAppType", 0);
      }
      if (i == 0) {
        break label2867;
      }
      i = 1;
      if (i != 0)
      {
        ag.aGl();
        com.tencent.mm.am.a.Du(paramam1.field_username);
      }
      if ((paramam1.field_type & 0x8) == 0) {
        break label2873;
      }
      if ((paramam2 == null) || ((paramam2.field_type & 0x8) != (paramam1.field_type & 0x8)))
      {
        com.tencent.mm.model.ba.aBQ();
        com.tencent.mm.model.c.azv().c(new String[] { paramam1.field_username }, "@blacklist");
      }
      if (!paramBoolean)
      {
        if ((paramam1 != null) && (paramam1.fqg()) && (com.tencent.mm.o.b.lM(paramam1.field_type)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.model.ba.aBQ();
          paramArrayOfByte = com.tencent.mm.model.c.azv().aTz(paramam1.field_username);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.lQ(4194304)))
          {
            com.tencent.mm.model.ba.aBQ();
            bool2 = com.tencent.mm.model.c.azv().a(paramam1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
            ad.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramam1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
        if ((paramam2 != null) && ((int)paramam2.gfj > 0) && (paramam2.ePB != 0) && (paramam2.ePC == 0) && (paramam1.ePC == 1))
        {
          ad.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramam1.field_username });
          com.tencent.mm.model.ba.aBQ();
          com.tencent.mm.model.c.azv().aTP(paramam1.field_username);
          com.tencent.mm.model.ba.aBQ();
          paramam2 = com.tencent.mm.model.c.azv().aTz("officialaccounts");
          if (paramam2 != null)
          {
            com.tencent.mm.model.ba.aBQ();
            paramam2.kp(com.tencent.mm.model.c.azv().fqR());
            ad.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramam2.field_unReadCount) });
            com.tencent.mm.model.ba.aBQ();
            paramArrayOfByte = com.tencent.mm.model.c.azv().aTM("officialaccounts");
            com.tencent.mm.model.ba.aBQ();
            paramArrayOfByte = com.tencent.mm.model.c.azs().apX(paramArrayOfByte);
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
              break label2923;
            }
            paramam2.aL(paramArrayOfByte);
            paramam2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
            paramam2.tA(Integer.toString(paramArrayOfByte.getType()));
            com.tencent.mm.model.ba.aBQ();
            localObject1 = com.tencent.mm.model.c.azv().Na();
            if (localObject1 != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              localObject4 = new PInt();
              paramArrayOfByte.tN("officialaccounts");
              paramArrayOfByte.setContent(paramam2.field_content);
              ((bq.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
              paramam2.tB(((PString)localObject2).value);
              paramam2.tC(((PString)localObject3).value);
              paramam2.ks(((PInt)localObject4).value);
            }
            com.tencent.mm.model.ba.aBQ();
            com.tencent.mm.model.c.azv().a(paramam2, paramam2.field_username);
          }
        }
      }
      if (bool1)
      {
        paramam2 = new ly();
        paramam2.dzm.username = paramam1.field_username;
        paramam2.dzm.dzn = paramam1.dzn;
        com.tencent.mm.sdk.b.a.IbL.l(paramam2);
      }
      if ((bool1) && (parambzp.tRT == 18))
      {
        paramam2 = new lb();
        paramam2.dyl.dym = paramam1.field_encryptUsername;
        paramam2.dyl.type = 2;
        com.tencent.mm.bk.d.aMp().apQ(paramam2.dyl.dym);
        com.tencent.mm.sdk.b.a.IbL.l(paramam2);
      }
      if (bool1) {
        cr(paramam1.field_username, parambzp.tRT);
      }
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramam1.ado()), Boolean.valueOf(paramBoolean) });
      if ((!paramBoolean) && (bool1) && (paramam1.ado()))
      {
        paramam2 = paramam1.field_username;
        if (!o.zbV.auM(paramam2))
        {
          paramam2 = new LinkedList();
          paramam2.add(paramam1.field_username);
          paramam1 = new oy();
          paramam1.dCO.list = paramam2;
          paramam1.dCO.drI = 1;
          paramam1.dCO.dCP = 5L;
          paramam1.dCO.dCQ = true;
          com.tencent.mm.sdk.b.a.IbL.l(paramam1);
        }
      }
      com.tencent.mm.plugin.label.a.a.dfo().aox();
      AppMethodBeat.o(22336);
      return;
      label2001:
      localObject3 = com.tencent.mm.bj.d.irv.aMm();
      if ((bt.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!w.vF(paramArrayOfByte)))
      {
        i = 0;
        break;
      }
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (((Iterator)localObject1).hasNext())
          {
            localObject3 = (vw)((Iterator)localObject1).next();
            if ((!bt.isNullOrNil(((vw)localObject3).nDo)) && (((vw)localObject3).nDo.equals(u.aAm())))
            {
              i = 0;
              break;
            }
          }
        }
      }
      if (com.tencent.mm.bj.d.iru != null)
      {
        if (com.tencent.mm.bj.d.iru.bx(paramArrayOfByte, u.aAm()))
        {
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
          localObject1 = new wu();
          ((wu)localObject1).dLh.userName = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        com.tencent.mm.bj.d.iru.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
      }
      if ((com.tencent.mm.bj.d.irv != null) && (!bt.isNullOrNil(com.tencent.mm.bj.d.iru.aMl())))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bj.d.irv.aMm() });
        localObject1 = new fk();
        ((fk)localObject1).dqw.username = com.tencent.mm.bj.d.irv.aMm();
        com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      i = 1;
      break;
      label2271:
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2333;
          }
          localObject3 = (vw)((Iterator)localObject1).next();
          if (!bt.isNullOrNil(((vw)localObject3).nDo)) {
            if (((vw)localObject3).nDo.equals(u.aAm())) {
              break;
            }
          }
        }
      }
      label2333:
      if (com.tencent.mm.bi.g.irs != null) {
        com.tencent.mm.bi.g.irs.a(paramArrayOfByte, null, "", "", 0);
      }
      localObject1 = new wm();
      ((wm)localObject1).dKN.dKQ = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new wl();
      ((wl)localObject1).dKL.dKM = true;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localObject1);
      break label138;
      i = 1;
      break label209;
      label2420:
      i = parambzp.GwB.fLb;
      break label257;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.al.n paramn)
  {
    AppMethodBeat.i(22343);
    ad.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramn.getType() != 681)
    {
      AppMethodBeat.o(22343);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(22343);
      return;
    }
    if (!com.tencent.mm.kernel.g.ajA().gAD)
    {
      ad.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    com.tencent.e.h.LTJ.aS(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193161);
        Object localObject2 = ((com.tencent.mm.bb.b)paramn).iik;
        Object localObject1 = new HashSet();
        try
        {
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localb = (k.b)((Iterator)localObject2).next();
            if (localb.getCmdId() != 2) {
              break label151;
            }
            ((Set)localObject1).add(z.a(((bzp)new bzp().parseFrom(localb.getBuffer())).GbY));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            k.b localb;
            ad.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", localException, "BaseProtoBuf parseFrom error!", new Object[0]);
            localObject1 = ((Set)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              String str = (String)((Iterator)localObject1).next();
              if (!bt.isNullOrNil(str)) {
                as.a.hFO.a(str, null, null);
              }
            }
            label151:
            if (localb.getCmdId() == 54) {
              ((Set)localObject1).add(((bzs)new bzs().parseFrom(localb.getBuffer())).GUK);
            } else if (localb.getCmdId() == 60) {
              ((Set)localObject1).add(((cai)new cai().parseFrom(localb.getBuffer())).GUK);
            }
          }
          AppMethodBeat.o(193161);
        }
      }
    });
    AppMethodBeat.o(22343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
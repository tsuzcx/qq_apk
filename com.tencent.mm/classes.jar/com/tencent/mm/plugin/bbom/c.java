package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.al.n;
import com.tencent.mm.am.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fg;
import com.tencent.mm.g.a.ie;
import com.tencent.mm.g.a.kk;
import com.tencent.mm.g.a.kk.a;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.g.a.og;
import com.tencent.mm.g.a.vi;
import com.tencent.mm.g.a.vj;
import com.tencent.mm.g.a.vj.b;
import com.tencent.mm.g.a.vq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.ay;
import com.tencent.mm.g.c.du;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.m;
import com.tencent.mm.plugin.sns.c.l;
import com.tencent.mm.plugin.sns.c.o;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.bqm;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.cak;
import com.tencent.mm.protocal.protobuf.cal;
import com.tencent.mm.protocal.protobuf.cwh;
import com.tencent.mm.protocal.protobuf.tq;
import com.tencent.mm.protocal.protobuf.tr;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bh.b;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
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
  implements com.tencent.mm.al.g, com.tencent.mm.plugin.messenger.foundation.a.c
{
  private static int mLA = -1;
  
  private static void J(com.tencent.mm.storage.af paramaf)
  {
    AppMethodBeat.i(22341);
    if ((paramaf != null) && (com.tencent.mm.am.f.wK(paramaf.field_username)) && (!com.tencent.mm.am.f.pc(paramaf.field_username)))
    {
      com.tencent.mm.model.az.arV();
      am localam = com.tencent.mm.model.c.apR().aIn(paramaf.field_username);
      paramaf = com.tencent.mm.am.af.awe().wy(paramaf.field_username);
      if (!com.tencent.mm.am.f.wN(paramaf.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localam == null)
      {
        localam = new am(paramaf.field_username);
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramaf.Jm(), paramaf.field_username });
        localam.nN(bt.nullAsNil(paramaf.Jm()));
        localam.eLf();
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apR().e(localam);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  public static boolean OQ(String paramString)
  {
    AppMethodBeat.i(22339);
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = com.tencent.mm.pluginsdk.ui.span.j.a.CjV.matcher(paramString);
    if (localMatcher.find())
    {
      if (bt.kU(paramString, localMatcher.group(0)))
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
  
  private static void a(bqj parambqj, String paramString, com.tencent.mm.storage.af paramaf, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = u.aqG();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = com.tencent.mm.am.af.awe().wy(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = parambqj.ijW;
      parambqj = parambqj.DJc;
      if (parambqj != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = parambqj.ika;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = parambqj.ikc;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = parambqj.ikd;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = parambqj.ikb;
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bt.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).bU(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).bU(false) != null) && (((com.tencent.mm.api.c)localObject).bU(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).bU(false).JH() != null) && (!bt.isNullOrNil(((com.tencent.mm.api.c)localObject).Jm())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).Jm();
        ad.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!com.tencent.mm.am.af.awe().g((com.tencent.mm.api.c)localObject)) {
        com.tencent.mm.am.af.awe().f((com.tencent.mm.api.c)localObject);
      }
      paramaf.jP(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  public static boolean a(com.tencent.mm.storage.af paramaf, bqj parambqj, boolean paramBoolean)
  {
    AppMethodBeat.i(22338);
    if ((paramaf == null) || (bt.isNullOrNil(paramaf.field_username)))
    {
      ad.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(22338);
      return false;
    }
    String str = paramaf.field_username;
    Object localObject1 = paramaf.field_encryptUsername;
    Object localObject2 = com.tencent.mm.ak.c.a(str, parambqj);
    p.auF().b((com.tencent.mm.ak.i)localObject2);
    localObject2 = parambqj.DJb;
    if ((!paramaf.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((cwh)localObject2).ijX + " " + parambqj.Dby);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((cwh)localObject2).ijY);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((cwh)localObject2).ijZ);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((cwh)localObject2).Eoc);
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((cwh)localObject2).Eod);
      if (o.wzH != null) {
        o.wzH.a(paramaf.field_username, (cwh)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.n.b.ls(paramaf.field_type))
    {
      bool = com.tencent.mm.bk.d.aCo().fM(str, 1);
      if (!bool) {
        break label429;
      }
      ad.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.n.b.ls(paramaf.field_type)) && ((paramaf.getSource() == 10) || (paramaf.getSource() == 13)))
      {
        t.l(aj.getContext(), paramaf.field_username, paramaf.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramaf.field_encryptUsername);
        if ((localObject1 != null) && (!bt.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).ijL)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramaf.field_username;
          ad.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).ijL, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(parambqj, str, paramaf, paramBoolean);
      AppMethodBeat.o(22338);
      return true;
      label429:
      bool = com.tencent.mm.bk.d.aCo().fM((String)localObject1, 1);
      ad.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(com.tencent.mm.storage.af paramaf, bw parambw)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!bt.isNullOrNil(parambw.field_conDescription)) {
      paramaf.nB(parambw.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!w.sC(paramaf.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.n.b.ls(paramaf.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bt.isNullOrNil(parambw.field_conDescription))
        {
          bqm localbqm = new bqm();
          localbqm.DOL = paramaf.field_username;
          localbqm.Desc = parambw.field_conDescription;
          com.tencent.mm.model.az.arV();
          com.tencent.mm.model.c.apL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(54, localbqm));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  private static void cj(String paramString, int paramInt)
  {
    AppMethodBeat.i(22342);
    bi[] arrayOfbi = null;
    bu[] arrayOfbu;
    Object localObject1;
    ba[] arrayOfba;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ad.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfbu = com.tencent.mm.bk.d.aCq().aJk(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aj.getContext(), arrayOfbu);
      arrayOfba = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(22342);
      return;
      if (paramInt == 18)
      {
        ad.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbi = com.tencent.mm.bk.d.aCp().aIL(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aj.getContext(), arrayOfbi);
        arrayOfbu = null;
        arrayOfba = null;
      }
      else
      {
        arrayOfba = com.tencent.mm.bk.d.aCn().aII(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(aj.getContext(), arrayOfba);
        arrayOfbu = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bl localbl;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbl = new bl();
      localbl.setContent(localObject2.gKF);
      m = w.tq(localObject2.username);
      if (arrayOfba != null)
      {
        j = paramInt + 1;
        localbl.kY(arrayOfba[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label533:
    for (;;)
    {
      label215:
      localbl.nY(localObject2.username);
      localbl.setType(m);
      label252:
      long l;
      if (localObject2.dDS)
      {
        localbl.setStatus(2);
        localbl.jV(1);
        com.tencent.mm.model.az.arV();
        l = com.tencent.mm.model.c.apO().an(localbl);
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
        if (arrayOfbi != null)
        {
          j = paramInt + 1;
          localbl.kY(arrayOfbi[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfbu == null) {
          break label533;
        }
        j = paramInt + 1;
        localbl.kY(arrayOfbu[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbl.setStatus(6);
        localbl.jV(0);
        break label252;
      }
      localObject1 = new bl();
      if (arrayOfba != null) {
        ((bl)localObject1).kY(arrayOfba[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bl)localObject1).nY(paramString);
        ((bl)localObject1).setContent(aj.getContext().getString(2131764537));
        ((bl)localObject1).setType(10000);
        ((bl)localObject1).setStatus(6);
        ((bl)localObject1).jV(0);
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apO().an((bl)localObject1);
        AppMethodBeat.o(22342);
        return;
        if (arrayOfbi != null) {
          ((bl)localObject1).kY(arrayOfbi[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbu != null) {
          ((bl)localObject1).kY(arrayOfbu[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.storage.af paramaf1, com.tencent.mm.storage.af paramaf2, bqj parambqj, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paramaf1.field_username;
    String str1 = paramaf1.field_encryptUsername;
    if ((paramaf2 != null) && (!bt.nullAsNil(paramaf2.evJ).equals(bt.nullAsNil(parambqj.DOC))))
    {
      com.tencent.mm.be.c.aAc();
      com.tencent.mm.be.c.yV(str2);
    }
    if (!bt.cw(paramArrayOfByte))
    {
      if (com.tencent.mm.storage.af.Wy(paramaf1.field_verifyFlag)) {
        a(parambqj, str2, paramaf1, true);
      }
      if ((paramaf2 == null) || (com.tencent.mm.n.b.ls(paramaf2.field_type)) || (!com.tencent.mm.n.b.ls(paramaf1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (w.sC(str2))) {
        com.tencent.mm.plugin.report.service.h.vKh.dB(931, 22);
      }
      Object localObject1 = paramaf1.field_username;
      if (parambqj.DOD == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bt.l(Integer.valueOf(parambqj.DOD.DWX.size()))))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(mLA) });
        if (mLA == -1) {
          mLA = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.puZ, 0);
        }
        if (mLA != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((parambqj.DOD == null) || (parambqj.DOD.DWX == null)) {
          break label335;
        }
        paramArrayOfByte = parambqj.DOD.DWX.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (cak)paramArrayOfByte.next();
          if (((cak)localObject1).DWW != null) {
            localStringBuffer.append(((cak)localObject1).DWW).append("，");
          }
        }
        a(paramaf1, parambqj, true);
        break;
      }
      label335:
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramaf1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paramaf2 != null)
      {
        localObject1 = paramaf2.evO;
        paramArrayOfByte = com.tencent.mm.n.a.a(paramaf2, (String)localObject1);
      }
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        paramaf2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        com.tencent.mm.model.az.arV();
        localObject3 = com.tencent.mm.model.c.apN().agQ(str1);
        paramaf2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bw)localObject3).field_conPhone;
          paramaf2 = paramArrayOfByte;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            paramaf2 = ((String)localObject1).split(",");
            localObject2 = localObject1;
          }
        }
      }
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramaf1.field_username, bt.nullAsNil((String)localObject2) });
      int i;
      if ((paramaf2 != null) && (paramaf2.length > 0))
      {
        paramArrayOfByte = com.tencent.mm.n.a.af(localStringBuffer.toString(), "，");
        int i2 = paramaf2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          localObject1 = paramaf2[k];
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
                if (!bt.kU((String)localObject1, paramArrayOfByte[n]))
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
                if (OQ((String)localObject1))
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
          paramaf2 = new brb();
          paramaf2.DOL = paramaf1.field_username;
          paramArrayOfByte = new cal();
          localObject1 = com.tencent.mm.n.a.af(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.mAK = localObject1.length;
            paramArrayOfByte.DWX = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new cak();
              ((cak)localObject3).DWW = ((String)localObject2);
              paramArrayOfByte.DWX.add(localObject3);
              i += 1;
            }
            paramaf2.DOD = paramArrayOfByte;
            com.tencent.mm.model.az.arV();
            com.tencent.mm.model.c.apL().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(60, paramaf2));
          }
        }
        if ((j != 0) && (15 == parambqj.rNz) && (!bt.isNullOrNil(paramaf1.field_username)))
        {
          paramaf2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(paramaf1.field_username);
          if (paramaf2 != null)
          {
            paramArrayOfByte = com.tencent.mm.n.a.af(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.h.vKh;
            localObject2 = paramaf1.field_username;
            if (!bt.isNullOrNil(paramaf2.JS())) {
              break label1291;
            }
            j = 0;
            if (paramArrayOfByte != null) {
              break label1297;
            }
            i = 0;
            ((com.tencent.mm.plugin.report.service.h)localObject1).f(12040, new Object[] { localObject2, Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramaf1.field_username, localStringBuffer.toString() });
      paramaf2 = localStringBuffer.toString();
      label998:
      paramaf2 = bt.by(paramaf2, "");
      ad.i("MicroMsg.BigBallContactAssemblerImpl", paramaf2);
      paramaf1.nH(paramaf2);
      if ((!w.pF(str2)) && (parambqj.Dst != null)) {
        q.a(str2, parambqj.Dst);
      }
      boolean bool1 = false;
      com.tencent.mm.model.az.arV();
      paramArrayOfByte = com.tencent.mm.model.c.apN().agQ(paramaf1.field_username);
      if (!bt.isNullOrNil(paramaf1.field_conRemark))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!bt.isNullOrNil(paramaf1.evI)) && (!paramaf1.evI.equals(paramArrayOfByte.field_conDescription))) {
          a(paramaf1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramaf1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          w.B(paramaf1);
        }
        paramaf2 = null;
        com.tencent.mm.model.az.arV();
        paramArrayOfByte = com.tencent.mm.model.c.apN().agQ(paramaf1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramaf2 = paramArrayOfByte.field_contactLabels;
        }
        parambqj = paramaf2;
        if (bt.isNullOrNil(paramaf2))
        {
          com.tencent.mm.model.az.arV();
          localObject1 = com.tencent.mm.model.c.apN().agQ(paramaf1.field_username);
          parambqj = paramaf2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            parambqj = ((bw)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bt.isNullOrNil(parambqj))
        {
          com.tencent.mm.plugin.label.a.a.cIS().gZ(paramaf1.field_username, parambqj);
          paramArrayOfByte.field_contactLabels = "";
          com.tencent.mm.model.az.arV();
          com.tencent.mm.model.c.apN().replace(paramArrayOfByte);
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
        paramaf2 = new StringBuffer();
        if ((parambqj.DOD != null) && (parambqj.DOD.DWX != null))
        {
          paramArrayOfByte = parambqj.DOD.DWX.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (cak)paramArrayOfByte.next();
            if (((cak)localObject1).DWW != null) {
              paramaf2.append(((cak)localObject1).DWW).append("，");
            }
          }
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramaf1.field_username, paramaf2.toString() });
        paramaf2 = paramaf2.toString();
        break label998;
        if (paramArrayOfByte != null)
        {
          paramaf2 = paramArrayOfByte;
          if (!bt.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
          paramaf2 = paramArrayOfByte;
          if (!bt.isNullOrNil(str1))
          {
            com.tencent.mm.model.az.arV();
            paramaf2 = com.tencent.mm.model.c.apN().agQ(str1);
          }
        }
        paramBoolean = bool1;
        if (paramaf2 != null)
        {
          paramBoolean = bool1;
          if (!bt.isNullOrNil(paramaf2.field_encryptUsername))
          {
            ad.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramaf2.field_encryptUsername);
            paramaf1.nb(paramaf2.field_conRemark);
            paramaf1.nh(com.tencent.mm.platformtools.f.Br(paramaf2.field_conRemark));
            paramaf1.ni(com.tencent.mm.platformtools.f.Bs(paramaf2.field_conRemark));
            paramBoolean = a(paramaf1, paramaf2);
          }
        }
        switch (paramaf1.getSource())
        {
        }
      }
      paramaf2 = null;
      if ((parambqj != null) && (!bt.isNullOrNil(parambqj.DOw)))
      {
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { parambqj.DOw, parambqj.DOx });
        paramArrayOfByte = com.tencent.mm.plugin.account.a.getAddrUploadStg();
        paramaf2 = parambqj.DOw;
        localObject1 = parambqj.DOx;
        parambqj = paramArrayOfByte.Cf(paramaf2);
        paramaf2 = parambqj;
        if (parambqj == null) {
          paramaf2 = paramArrayOfByte.Cf((String)localObject1);
        }
        if (paramaf2 != null) {
          break label1919;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramaf2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bt.isNullOrNil(paramaf2.aIv())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramaf2.aIC()) {
          break;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramaf2.aIv(), paramaf2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramaf2.username = paramaf1.field_username;
        paramaf2.status = 2;
        paramaf2.aIB();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramaf1.nb(paramaf2.aIv());
          paramaf1.nh(com.tencent.mm.platformtools.f.Br(paramaf2.aIv()));
          paramaf1.ni(com.tencent.mm.platformtools.f.Bs(paramaf2.aIv()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.n.b.ls(paramaf1.field_type)) {
          break;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramaf2.aIv(), paramaf2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramaf2.JS(), paramaf2);
        bool1 = bool2;
        break;
        if (bt.isNullOrNil(str1)) {
          break label1694;
        }
        paramaf2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(str1);
        break label1694;
        label1919:
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bt.nullAsNil(paramaf2.aIv()), bt.nullAsNil(paramaf2.getUsername()), Boolean.valueOf(paramaf2.aIC()) });
      }
    }
  }
  
  public final void b(com.tencent.mm.storage.af paramaf1, com.tencent.mm.storage.af paramaf2, bqj parambqj, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paramaf1.field_username;
    Object localObject2 = paramaf1.field_encryptUsername;
    Object localObject1;
    int i;
    Object localObject3;
    label138:
    label209:
    label240:
    Object localObject4;
    int j;
    if (w.pF(paramArrayOfByte))
    {
      if (parambqj.Dst != null)
      {
        localObject1 = parambqj.Dst.CVr;
        if (com.tencent.mm.bj.d.hxy != null) {
          break label1776;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = parambqj.Dst.CVr;
          localObject3 = new vj();
          ((vj)localObject3).dAP.dAR = true;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bt.isNullOrNil(paramArrayOfByte)) && (w.pF(paramArrayOfByte)) && (!bt.isNullOrNil(((vj)localObject3).dAQ.dAT)) && (paramArrayOfByte.equals(((vj)localObject3).dAQ.dAT))) {
            break label2046;
          }
        }
        localObject1 = parambqj.Dst.CVr;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (tr)((Iterator)localObject1).next();
          } while ((bt.isNullOrNil(((tr)localObject3).mAQ)) || (!((tr)localObject3).mAQ.equals(u.aqG())));
        }
        i = 0;
        if (i != 0) {
          ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).aho(paramArrayOfByte);
        }
      }
      if (parambqj.Dst != null) {
        break label2195;
      }
      i = 0;
      localObject1 = parambqj.DOr;
      localObject3 = parambqj.DOq;
      int k = parambqj.DOB;
      int m = parambqj.DOA;
      localObject4 = parambqj.sed;
      int n = parambqj.DOz;
      if (parambqj.Dst != null) {
        break label2207;
      }
      j = -1;
      label286:
      ad.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(j) });
      if ((parambqj.Dst != null) && (parambqj.Dst.fpb != 0))
      {
        localObject1 = new com.tencent.mm.j.a.a.a();
        ((com.tencent.mm.j.a.a.a)localObject1).type = parambqj.DOB;
        ((com.tencent.mm.j.a.a.a)localObject1).maxCount = parambqj.DOA;
        ((com.tencent.mm.j.a.a.a)localObject1).fym = parambqj.sed;
        ((com.tencent.mm.j.a.a.a)localObject1).fyn = parambqj.DOz;
        if (parambqj.Dst.CVs == 0) {
          ((com.tencent.mm.j.a.a.a)localObject1).dqN = parambqj.DOz;
        }
        if (q.U(paramArrayOfByte, parambqj.DOz))
        {
          localObject3 = new ie();
          ((ie)localObject3).dlW.dlX = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject3);
          q.V(paramArrayOfByte, parambqj.DOB);
        }
        localObject3 = new lv();
        ((lv)localObject3).dqM.chatroomName = paramArrayOfByte;
        ((lv)localObject3).dqM.dqN = ((com.tencent.mm.j.a.a.a)localObject1).dqN;
        q.a(paramArrayOfByte, parambqj.DOq, parambqj.Dst, parambqj.DOF, u.aqG(), (com.tencent.mm.j.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    if ((!com.tencent.mm.n.b.ls(paramaf1.field_type)) && (!paramaf1.ZK()) && (!com.tencent.mm.storage.af.st(paramaf1.field_username)) && (!w.pF(paramaf1.field_username)))
    {
      ad.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramaf1.field_username, Integer.valueOf(paramaf1.field_type) });
      com.tencent.mm.model.az.arV();
      com.tencent.mm.model.c.apR().aIl(paramaf1.field_username);
    }
    if ((paramaf1.field_type & 0x800) != 0) {
      if ((paramaf2 == null) || ((paramaf2.field_type & 0x800) != (paramaf1.field_type & 0x800)))
      {
        if ((com.tencent.mm.am.f.wK(paramaf1.field_username)) && (!com.tencent.mm.am.f.pc(paramaf1.field_username))) {
          J(paramaf1);
        }
      }
      else {
        label689:
        if ((paramaf2 == null) || (com.tencent.mm.n.b.ls(paramaf2.field_type)) || (!com.tencent.mm.n.b.ls(paramaf1.field_type))) {
          break label2634;
        }
      }
    }
    label944:
    label2108:
    label2627:
    label2634:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (com.tencent.mm.n.b.ls(paramaf1.field_type))
      {
        com.tencent.mm.model.az.arV();
        localObject1 = com.tencent.mm.model.c.apN().agQ(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bt.isNullOrNil(((bw)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bt.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.model.az.arV();
            paramArrayOfByte = com.tencent.mm.model.c.apN().agQ((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bt.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          com.tencent.mm.model.az.arV();
          com.tencent.mm.model.c.apN().agR(paramArrayOfByte.field_encryptUsername);
        }
      }
      if (com.tencent.mm.am.f.wJ(paramaf1.field_username))
      {
        com.tencent.mm.am.af.awn();
        com.tencent.mm.am.d.a(paramaf1.field_username, null);
        if ((bool1) && (com.tencent.mm.am.f.wK(paramaf1.field_username)))
        {
          if (!com.tencent.mm.am.f.pc(paramaf1.field_username)) {
            break label2455;
          }
          com.tencent.mm.am.af.awm();
          com.tencent.mm.am.a.h.a(paramaf1.field_username, null);
        }
      }
      label884:
      paramArrayOfByte = com.tencent.mm.am.f.ei(paramaf1.field_username);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.bU(false);
        if (paramArrayOfByte != null)
        {
          i = 0;
          if (paramArrayOfByte.cIj != null) {
            i = paramArrayOfByte.cIj.optInt("WXAppType", 0);
          }
          if (i != 0)
          {
            i = 1;
            if (i != 0)
            {
              com.tencent.mm.am.af.awq();
              com.tencent.mm.am.a.wp(paramaf1.field_username);
            }
            if ((paramaf1.field_type & 0x8) == 0) {
              break label2577;
            }
            if ((paramaf2 == null) || ((paramaf2.field_type & 0x8) != (paramaf1.field_type & 0x8)))
            {
              com.tencent.mm.model.az.arV();
              com.tencent.mm.model.c.apR().c(new String[] { paramaf1.field_username }, "@blacklist");
            }
            label1017:
            if (!paramBoolean)
            {
              if ((paramaf1 != null) && (paramaf1.eKB()) && (com.tencent.mm.n.b.ls(paramaf1.field_type)))
              {
                long l = System.currentTimeMillis();
                com.tencent.mm.model.az.arV();
                paramArrayOfByte = com.tencent.mm.model.c.apR().aIn(paramaf1.field_username);
                if ((paramArrayOfByte != null) && (paramArrayOfByte.lw(4194304)))
                {
                  com.tencent.mm.model.az.arV();
                  boolean bool2 = com.tencent.mm.model.c.apR().a(paramaf1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
                  ad.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramaf1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
                }
              }
              if ((paramaf2 != null) && ((int)paramaf2.fId > 0) && (paramaf2.evG != 0) && (paramaf2.evH == 0) && (paramaf1.evH == 1))
              {
                ad.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramaf1.field_username });
                com.tencent.mm.model.az.arV();
                com.tencent.mm.model.c.apR().aIC(paramaf1.field_username);
                com.tencent.mm.model.az.arV();
                paramaf2 = com.tencent.mm.model.c.apR().aIn("officialaccounts");
                if (paramaf2 != null)
                {
                  com.tencent.mm.model.az.arV();
                  paramaf2.jT(com.tencent.mm.model.c.apR().eLm());
                  ad.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramaf2.field_unReadCount) });
                  com.tencent.mm.model.az.arV();
                  paramArrayOfByte = com.tencent.mm.model.c.apR().aIz("officialaccounts");
                  com.tencent.mm.model.az.arV();
                  paramArrayOfByte = com.tencent.mm.model.c.apO().agq(paramArrayOfByte);
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
                    break label2627;
                  }
                  paramaf2.aG(paramArrayOfByte);
                  paramaf2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
                  paramaf2.nK(Integer.toString(paramArrayOfByte.getType()));
                  com.tencent.mm.model.az.arV();
                  localObject1 = com.tencent.mm.model.c.apR().Lu();
                  if (localObject1 != null)
                  {
                    localObject2 = new PString();
                    localObject3 = new PString();
                    localObject4 = new PInt();
                    paramArrayOfByte.nY("officialaccounts");
                    paramArrayOfByte.setContent(paramaf2.field_content);
                    ((bh.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
                    paramaf2.nL(((PString)localObject2).value);
                    paramaf2.nM(((PString)localObject3).value);
                    paramaf2.jW(((PInt)localObject4).value);
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apR().a(paramaf2, paramaf2.field_username);
        if (bool1)
        {
          paramaf2 = new lg();
          paramaf2.dpN.username = paramaf1.field_username;
          paramaf2.dpN.dpO = paramaf1.dpO;
          com.tencent.mm.sdk.b.a.ESL.l(paramaf2);
        }
        if ((bool1) && (parambqj.rNz == 18))
        {
          paramaf2 = new kk();
          paramaf2.doP.doQ = paramaf1.field_encryptUsername;
          paramaf2.doP.type = 2;
          com.tencent.mm.bk.d.aCp().agj(paramaf2.doP.doQ);
          com.tencent.mm.sdk.b.a.ESL.l(paramaf2);
        }
        if (bool1) {
          cj(paramaf1.field_username, parambqj.rNz);
        }
        ad.d("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramaf1.ZQ()), Boolean.valueOf(paramBoolean) });
        if ((!paramBoolean) && (bool1) && (paramaf1.ZQ()))
        {
          paramaf2 = paramaf1.field_username;
          if (!o.wzJ.akH(paramaf2))
          {
            paramaf2 = new LinkedList();
            paramaf2.add(paramaf1.field_username);
            paramaf1 = new og();
            paramaf1.dtn.list = paramaf2;
            paramaf1.dtn.diR = 1;
            paramaf1.dtn.dto = 5L;
            paramaf1.dtn.dtp = true;
            com.tencent.mm.sdk.b.a.ESL.l(paramaf1);
          }
        }
        com.tencent.mm.plugin.label.a.a.cIS().ayP();
        AppMethodBeat.o(22336);
        return;
        label1776:
        localObject3 = com.tencent.mm.bj.d.hxy.aCm();
        if ((bt.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!w.pF(paramArrayOfByte)))
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
              localObject3 = (tr)((Iterator)localObject1).next();
              if ((!bt.isNullOrNil(((tr)localObject3).mAQ)) && (((tr)localObject3).mAQ.equals(u.aqG())))
              {
                i = 0;
                break;
              }
            }
          }
        }
        if (com.tencent.mm.bj.d.hxx != null)
        {
          if (com.tencent.mm.bj.d.hxx.bo(paramArrayOfByte, u.aqG()))
          {
            ad.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
            localObject1 = new vq();
            ((vq)localObject1).dBh.userName = paramArrayOfByte;
            com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
          }
          com.tencent.mm.bj.d.hxx.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
        }
        if ((com.tencent.mm.bj.d.hxy != null) && (!bt.isNullOrNil(com.tencent.mm.bj.d.hxx.aCl())))
        {
          ad.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bj.d.hxy.aCm() });
          localObject1 = new fg();
          ((fg)localObject1).dhF.username = com.tencent.mm.bj.d.hxy.aCm();
          com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        i = 1;
        break;
        label2046:
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label2108;
            }
            localObject3 = (tr)((Iterator)localObject1).next();
            if (!bt.isNullOrNil(((tr)localObject3).mAQ)) {
              if (((tr)localObject3).mAQ.equals(u.aqG())) {
                break;
              }
            }
          }
        }
        if (com.tencent.mm.bi.g.hxv != null) {
          com.tencent.mm.bi.g.hxv.a(paramArrayOfByte, null, "", "", 0);
        }
        localObject1 = new vj();
        ((vj)localObject1).dAP.dAS = true;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new vi();
        ((vi)localObject1).dAN.dAO = true;
        com.tencent.mm.sdk.b.a.ESL.l((com.tencent.mm.sdk.b.b)localObject1);
        break label138;
        i = 1;
        break label209;
        i = parambqj.Dst.fpb;
        break label240;
        j = parambqj.Dst.CVs;
        break label286;
        if ((!paramaf1.eKB()) || (!com.tencent.mm.am.f.wI(paramaf1.field_username)) || (paramaf1 == null) || (!paramaf1.eKB()) || (!com.tencent.mm.am.f.wI(paramaf1.field_username))) {
          break label689;
        }
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramaf1.field_username);
        com.tencent.mm.model.az.arV();
        localObject1 = com.tencent.mm.model.c.apR().aIn(paramaf1.field_username);
        com.tencent.mm.am.af.awe().wy(paramaf1.field_username);
        if (localObject1 != null) {
          break label689;
        }
        com.tencent.mm.model.az.arV();
        if (com.tencent.mm.model.c.apR().aIn("officialaccounts") == null)
        {
          localObject1 = new am("officialaccounts");
          ((am)localObject1).eLf();
          com.tencent.mm.model.az.arV();
          com.tencent.mm.model.c.apR().e((am)localObject1);
        }
        localObject1 = new am(paramaf1.field_username);
        ((am)localObject1).nN("officialaccounts");
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apR().e((am)localObject1);
        break label689;
        if (((paramaf2 != null) && ((paramaf2.field_type & 0x800) == (paramaf1.field_type & 0x800))) || (!com.tencent.mm.am.f.wK(paramaf1.field_username)) || (com.tencent.mm.am.f.pc(paramaf1.field_username))) {
          break label689;
        }
        J(paramaf1);
        break label689;
        if (!com.tencent.mm.am.f.wN(paramaf1.field_username)) {
          break label884;
        }
        com.tencent.mm.model.az.arV();
        if (com.tencent.mm.model.c.apR().aIn(paramaf1.field_username) != null) {
          break label884;
        }
        paramArrayOfByte = com.tencent.mm.am.af.awe().wy(paramaf1.field_username);
        localObject1 = new am(paramaf1.field_username);
        ad.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.Jm(), paramaf1.field_username });
        ((am)localObject1).nN(bt.nullAsNil(paramArrayOfByte.Jm()));
        ((am)localObject1).eLf();
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apR().e((am)localObject1);
        break label884;
        i = 0;
        break label944;
        if ((paramaf2 != null) && ((paramaf2.field_type & 0x8) == (paramaf1.field_type & 0x8))) {
          break label1017;
        }
        com.tencent.mm.model.az.arV();
        com.tencent.mm.model.c.apR().c(new String[] { paramaf1.field_username }, "");
        break label1017;
        paramaf2.eLf();
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
    if (!com.tencent.mm.kernel.g.afz().gcn)
    {
      ad.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    paramn = ((com.tencent.mm.bb.b)paramn).hot;
    paramString = new HashSet();
    try
    {
      paramn = paramn.iterator();
      while (paramn.hasNext())
      {
        localb = (j.b)paramn.next();
        if (localb.getCmdId() != 2) {
          break label251;
        }
        paramString.add(z.a(((bqj)new bqj().parseFrom(localb.getBuffer())).Dby));
      }
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        j.b localb;
        ad.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", paramn, "BaseProtoBuf parseFrom error!", new Object[0]);
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramn = (String)paramString.next();
          if (!bt.isNullOrNil(paramn)) {
            ar.a.gMW.a(paramn, null, null);
          }
        }
        label251:
        if (localb.getCmdId() == 54) {
          paramString.add(((bqm)new bqm().parseFrom(localb.getBuffer())).DOL);
        } else if (localb.getCmdId() == 60) {
          paramString.add(((brb)new brb().parseFrom(localb.getBuffer())).DOL);
        }
      }
      AppMethodBeat.o(22343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
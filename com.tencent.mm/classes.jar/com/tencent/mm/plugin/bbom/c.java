package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fl;
import com.tencent.mm.g.a.iu;
import com.tencent.mm.g.a.lc;
import com.tencent.mm.g.a.lc.a;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.g.a.mo;
import com.tencent.mm.g.a.oz;
import com.tencent.mm.g.a.wp;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.wq.b;
import com.tencent.mm.g.a.wy;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.r;
import com.tencent.mm.model.v;
import com.tencent.mm.model.x;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pluginsdk.ui.span.j.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aco;
import com.tencent.mm.protocal.protobuf.caj;
import com.tencent.mm.protocal.protobuf.cam;
import com.tencent.mm.protocal.protobuf.cbc;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.cld;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.vy;
import com.tencent.mm.protocal.protobuf.vz;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bh;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.br.b;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ce;
import com.tencent.mm.storage.cf;
import com.tencent.mm.storage.cg;
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
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.messenger.foundation.a.d
{
  private static int nUc = -1;
  
  private static void R(an paraman)
  {
    AppMethodBeat.i(22341);
    if ((paraman != null) && (com.tencent.mm.al.g.Er(paraman.field_username)) && (!com.tencent.mm.al.g.vz(paraman.field_username)))
    {
      bc.aCg();
      au localau = com.tencent.mm.model.c.azL().aVa(paraman.field_username);
      paraman = ag.aGp().Ef(paraman.field_username);
      if (!com.tencent.mm.al.g.Eu(paraman.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localau == null)
      {
        localau = new au(paraman.field_username);
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paraman.KD(), paraman.field_username });
        localau.tY(bu.nullAsNil(paraman.KD()));
        localau.fuK();
        bc.aCg();
        com.tencent.mm.model.c.azL().e(localau);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  public static boolean Xj(String paramString)
  {
    AppMethodBeat.i(22339);
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = j.a.FzR.matcher(paramString);
    if (localMatcher.find())
    {
      if (bu.lX(paramString, localMatcher.group(0)))
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
  
  private static void a(caj paramcaj, String paramString, an paraman, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = v.aAC();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = ag.aGp().Ef(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = paramcaj.jgf;
      paramcaj = paramcaj.HhB;
      if (paramcaj != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = paramcaj.jgj;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = paramcaj.jgl;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramcaj.jgm;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = paramcaj.jgk;
          ae.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          ae.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bu.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).bX(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).bX(false) != null) && (((com.tencent.mm.api.c)localObject).bX(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).bX(false).KX() != null) && (!bu.isNullOrNil(((com.tencent.mm.api.c)localObject).KD())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).KD();
        ae.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!ag.aGp().g((com.tencent.mm.api.c)localObject)) {
        ag.aGp().f((com.tencent.mm.api.c)localObject);
      }
      paraman.kn(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  public static boolean a(an paraman, caj paramcaj, boolean paramBoolean)
  {
    AppMethodBeat.i(22338);
    if ((paraman == null) || (bu.isNullOrNil(paraman.field_username)))
    {
      ae.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(22338);
      return false;
    }
    String str = paraman.field_username;
    Object localObject1 = paraman.field_encryptUsername;
    Object localObject2 = com.tencent.mm.aj.c.a(str, paramcaj);
    p.aEN().b((com.tencent.mm.aj.i)localObject2);
    localObject2 = paramcaj.HhA;
    if ((!paraman.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((dia)localObject2).jgg + " " + paramcaj.GuF);
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((dia)localObject2).jgh);
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dia)localObject2).jgi);
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dia)localObject2).HPm);
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dia)localObject2).HPn);
      if (o.zsw != null) {
        o.zsw.a(paraman.field_username, (dia)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.contact.c.lO(paraman.field_type))
    {
      bool = com.tencent.mm.bj.d.aMM().gw(str, 1);
      if (!bool) {
        break label429;
      }
      ae.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.contact.c.lO(paraman.field_type)) && ((paraman.getSource() == 10) || (paraman.getSource() == 13)))
      {
        t.m(ak.getContext(), paraman.field_username, paraman.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paraman.field_encryptUsername);
        if ((localObject1 != null) && (!bu.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).jfU)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paraman.field_username;
          ae.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).jfU, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(paramcaj, str, paraman, paramBoolean);
      AppMethodBeat.o(22338);
      return true;
      label429:
      bool = com.tencent.mm.bj.d.aMM().gw((String)localObject1, 1);
      ae.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(an paraman, cg paramcg)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!bu.isNullOrNil(paramcg.field_conDescription)) {
      paraman.tM(paramcg.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!x.Am(paraman.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.contact.c.lO(paraman.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bu.isNullOrNil(paramcg.field_conDescription))
        {
          cam localcam = new cam();
          localcam.Hol = paraman.field_username;
          localcam.Desc = paramcg.field_conDescription;
          bc.aCg();
          com.tencent.mm.model.c.azE().d(new k.a(54, localcam));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  private static void cv(String paramString, int paramInt)
  {
    AppMethodBeat.i(22342);
    bs[] arrayOfbs = null;
    ce[] arrayOfce;
    Object localObject1;
    bi[] arrayOfbi;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ae.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfce = com.tencent.mm.bj.d.aMO().aVY(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ak.getContext(), arrayOfce);
      arrayOfbi = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(22342);
      return;
      if (paramInt == 18)
      {
        ae.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbs = com.tencent.mm.bj.d.aMN().aVz(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ak.getContext(), arrayOfbs);
        arrayOfce = null;
        arrayOfbi = null;
      }
      else
      {
        arrayOfbi = com.tencent.mm.bj.d.aML().aVw(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ak.getContext(), arrayOfbi);
        arrayOfce = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bv localbv;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbv = new bv();
      localbv.setContent(localObject2.hGg);
      m = x.Bb(localObject2.username);
      if (arrayOfbi != null)
      {
        j = paramInt + 1;
        localbv.qN(arrayOfbi[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label533:
    for (;;)
    {
      label215:
      localbv.ui(localObject2.username);
      localbv.setType(m);
      label252:
      long l;
      if (localObject2.dPh)
      {
        localbv.setStatus(2);
        localbv.kt(1);
        bc.aCg();
        l = com.tencent.mm.model.c.azI().ar(localbv);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbs != null)
        {
          j = paramInt + 1;
          localbv.qN(arrayOfbs[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfce == null) {
          break label533;
        }
        j = paramInt + 1;
        localbv.qN(arrayOfce[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbv.setStatus(6);
        localbv.kt(0);
        break label252;
      }
      localObject1 = new bv();
      if (arrayOfbi != null) {
        ((bv)localObject1).qN(arrayOfbi[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bv)localObject1).ui(paramString);
        ((bv)localObject1).setContent(ak.getContext().getString(2131764537));
        ((bv)localObject1).setType(10000);
        ((bv)localObject1).setStatus(6);
        ((bv)localObject1).kt(0);
        bc.aCg();
        com.tencent.mm.model.c.azI().ar((bv)localObject1);
        AppMethodBeat.o(22342);
        return;
        if (arrayOfbs != null) {
          ((bv)localObject1).qN(arrayOfbs[0].field_createtime * 1000L + 1L);
        } else if (arrayOfce != null) {
          ((bv)localObject1).qN(arrayOfce[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(an paraman1, an paraman2, caj paramcaj, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paraman1.field_username;
    String str1 = paraman1.field_encryptUsername;
    if ((paraman2 != null) && (!bu.nullAsNil(paraman2.eRp).equals(bu.nullAsNil(paramcaj.Hoc))))
    {
      com.tencent.mm.bd.c.aKw();
      com.tencent.mm.bd.c.GH(str2);
    }
    if (!bu.cF(paramArrayOfByte))
    {
      if (an.abz(paraman1.field_verifyFlag)) {
        a(paramcaj, str2, paraman1, true);
      }
      if ((paraman2 == null) || (com.tencent.mm.contact.c.lO(paraman2.field_type)) || (!com.tencent.mm.contact.c.lO(paraman1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (x.Am(str2))) {
        com.tencent.mm.plugin.report.service.g.yxI.dD(931, 22);
      }
      Object localObject1 = paraman1.field_username;
      if (paramcaj.Hod == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bu.o(Integer.valueOf(paramcaj.Hod.Hxv.size()))))
      {
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(nUc) });
        if (nUc == -1) {
          nUc = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qMf, 0);
        }
        if (nUc != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((paramcaj.Hod == null) || (paramcaj.Hod.Hxv == null)) {
          break label335;
        }
        paramArrayOfByte = paramcaj.Hod.Hxv.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (clc)paramArrayOfByte.next();
          if (((clc)localObject1).Hxu != null) {
            localStringBuffer.append(((clc)localObject1).Hxu).append("，");
          }
        }
        a(paraman1, paramcaj, true);
        break;
      }
      label335:
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paraman1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paraman2 != null)
      {
        localObject1 = paraman2.eRu;
        paramArrayOfByte = com.tencent.mm.contact.a.a(paraman2, (String)localObject1);
      }
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        paraman2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        bc.aCg();
        localObject3 = com.tencent.mm.model.c.azG().arE(str1);
        paraman2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((cg)localObject3).field_conPhone;
          paraman2 = paramArrayOfByte;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            paraman2 = ((String)localObject1).split(",");
            localObject2 = localObject1;
          }
        }
      }
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paraman1.field_username, bu.nullAsNil((String)localObject2) });
      int i;
      if ((paraman2 != null) && (paraman2.length > 0))
      {
        paramArrayOfByte = com.tencent.mm.contact.a.aj(localStringBuffer.toString(), "，");
        int i2 = paraman2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          localObject1 = paraman2[k];
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
                if (!bu.lX((String)localObject1, paramArrayOfByte[n]))
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
                if (Xj((String)localObject1))
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
          paraman2 = new cbc();
          paraman2.Hol = paraman1.field_username;
          paramArrayOfByte = new cld();
          localObject1 = com.tencent.mm.contact.a.aj(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.nID = localObject1.length;
            paramArrayOfByte.Hxv = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new clc();
              ((clc)localObject3).Hxu = ((String)localObject2);
              paramArrayOfByte.Hxv.add(localObject3);
              i += 1;
            }
            paraman2.Hod = paramArrayOfByte;
            bc.aCg();
            com.tencent.mm.model.c.azE().d(new k.a(60, paraman2));
          }
        }
        if ((j != 0) && (15 == paramcaj.ucK) && (!bu.isNullOrNil(paraman1.field_username)))
        {
          paraman2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(paraman1.field_username);
          if (paraman2 != null)
          {
            paramArrayOfByte = com.tencent.mm.contact.a.aj(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.g.yxI;
            localObject2 = paraman1.field_username;
            if (!bu.isNullOrNil(paraman2.Lj())) {
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
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paraman1.field_username, localStringBuffer.toString() });
      paraman2 = localStringBuffer.toString();
      label998:
      paraman2 = bu.bI(paraman2, "");
      ae.i("MicroMsg.BigBallContactAssemblerImpl", paraman2);
      paraman1.tS(paraman2);
      if ((!x.wb(str2)) && (paramcaj.GQb != null)) {
        r.a(str2, paramcaj.GQb);
      }
      boolean bool1 = false;
      bc.aCg();
      paramArrayOfByte = com.tencent.mm.model.c.azG().arE(paraman1.field_username);
      if (!bu.isNullOrNil(paraman1.field_conRemark))
      {
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!bu.isNullOrNil(paraman1.eRo)) && (!paraman1.eRo.equals(paramArrayOfByte.field_conDescription))) {
          a(paraman1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paraman1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          x.I(paraman1);
        }
        paraman2 = null;
        bc.aCg();
        paramArrayOfByte = com.tencent.mm.model.c.azG().arE(paraman1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paraman2 = paramArrayOfByte.field_contactLabels;
        }
        paramcaj = paraman2;
        if (bu.isNullOrNil(paraman2))
        {
          bc.aCg();
          localObject1 = com.tencent.mm.model.c.azG().arE(paraman1.field_username);
          paramcaj = paraman2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            paramcaj = ((cg)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bu.isNullOrNil(paramcaj))
        {
          com.tencent.mm.plugin.label.a.a.dig().hJ(paraman1.field_username, paramcaj);
          paramArrayOfByte.field_contactLabels = "";
          bc.aCg();
          com.tencent.mm.model.c.azG().replace(paramArrayOfByte);
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
        paraman2 = new StringBuffer();
        if ((paramcaj.Hod != null) && (paramcaj.Hod.Hxv != null))
        {
          paramArrayOfByte = paramcaj.Hod.Hxv.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (clc)paramArrayOfByte.next();
            if (((clc)localObject1).Hxu != null) {
              paraman2.append(((clc)localObject1).Hxu).append("，");
            }
          }
        }
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paraman1.field_username, paraman2.toString() });
        paraman2 = paraman2.toString();
        break label998;
        if (paramArrayOfByte != null)
        {
          paraman2 = paramArrayOfByte;
          if (!bu.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          ae.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
          paraman2 = paramArrayOfByte;
          if (!bu.isNullOrNil(str1))
          {
            bc.aCg();
            paraman2 = com.tencent.mm.model.c.azG().arE(str1);
          }
        }
        paramBoolean = bool1;
        if (paraman2 != null)
        {
          paramBoolean = bool1;
          if (!bu.isNullOrNil(paraman2.field_encryptUsername))
          {
            ae.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paraman2.field_encryptUsername);
            paraman1.tm(paraman2.field_conRemark);
            paraman1.ts(com.tencent.mm.platformtools.f.Jk(paraman2.field_conRemark));
            paraman1.tt(com.tencent.mm.platformtools.f.Jl(paraman2.field_conRemark));
            paramBoolean = a(paraman1, paraman2);
          }
        }
        switch (paraman1.getSource())
        {
        }
      }
      paraman2 = null;
      if ((paramcaj != null) && (!bu.isNullOrNil(paramcaj.HnW)))
      {
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { paramcaj.HnW, paramcaj.HnX });
        paramArrayOfByte = com.tencent.mm.plugin.account.a.getAddrUploadStg();
        paraman2 = paramcaj.HnW;
        localObject1 = paramcaj.HnX;
        paramcaj = paramArrayOfByte.JW(paraman2);
        paraman2 = paramcaj;
        if (paramcaj == null) {
          paraman2 = paramArrayOfByte.JW((String)localObject1);
        }
        if (paraman2 != null) {
          break label1919;
        }
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paraman2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bu.isNullOrNil(paraman2.aSX())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paraman2.aTe()) {
          break;
        }
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paraman2.aSX(), paraman2.getUsername(), Boolean.valueOf(paramBoolean) });
        paraman2.username = paraman1.field_username;
        paraman2.status = 2;
        paraman2.aTd();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paraman1.tm(paraman2.aSX());
          paraman1.ts(com.tencent.mm.platformtools.f.Jk(paraman2.aSX()));
          paraman1.tt(com.tencent.mm.platformtools.f.Jl(paraman2.aSX()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.contact.c.lO(paraman1.field_type)) {
          break;
        }
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paraman2.aSX(), paraman2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paraman2.Lj(), paraman2);
        bool1 = bool2;
        break;
        if (bu.isNullOrNil(str1)) {
          break label1694;
        }
        paraman2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(str1);
        break label1694;
        label1919:
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bu.nullAsNil(paraman2.aSX()), bu.nullAsNil(paraman2.getUsername()), Boolean.valueOf(paraman2.aTe()) });
      }
    }
  }
  
  public final void b(an paraman1, an paraman2, caj paramcaj, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paraman1.field_username;
    Object localObject2 = paraman1.field_encryptUsername;
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
    if (x.wb(paramArrayOfByte))
    {
      if (paramcaj.GQb != null)
      {
        localObject1 = paramcaj.GQb.GnJ;
        if (com.tencent.mm.bi.d.iup != null) {
          break label2001;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = paramcaj.GQb.GnJ;
          localObject3 = new wq();
          ((wq)localObject3).dMc.dMe = true;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bu.isNullOrNil(paramArrayOfByte)) && (x.wb(paramArrayOfByte)) && (!bu.isNullOrNil(((wq)localObject3).dMd.dMg)) && (paramArrayOfByte.equals(((wq)localObject3).dMd.dMg))) {
            break label2271;
          }
        }
        localObject1 = paramcaj.GQb.GnJ;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (vz)((Iterator)localObject1).next();
          } while ((bu.isNullOrNil(((vz)localObject3).nIJ)) || (!((vz)localObject3).nIJ.equals(v.aAC())));
        }
        i = 0;
        if (i != 0)
        {
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.d.class)).asn(paramArrayOfByte);
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(ak.getContext());
        }
      }
      if (paramcaj.GQb != null) {
        break label2420;
      }
      i = 0;
      localObject1 = paramcaj.HnR;
      localObject3 = paramcaj.HnQ;
      k = paramcaj.Hob;
      m = paramcaj.Hoa;
      localObject4 = paramcaj.uvT;
      n = paramcaj.HnZ;
      i1 = paramcaj.Hoe;
      if (paramcaj.GQb != null) {
        break label2432;
      }
    }
    label2432:
    for (int j = -1;; j = paramcaj.GQb.GnK)
    {
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s chatroomVersion:%d chatroomInfoVersion:%s infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j) });
      if ((paramcaj.GQb != null) && (paramcaj.GQb.fNf != 0))
      {
        localObject1 = new com.tencent.mm.k.a.a.a();
        ((com.tencent.mm.k.a.a.a)localObject1).type = paramcaj.Hob;
        ((com.tencent.mm.k.a.a.a)localObject1).maxCount = paramcaj.Hoa;
        ((com.tencent.mm.k.a.a.a)localObject1).fXn = paramcaj.uvT;
        ((com.tencent.mm.k.a.a.a)localObject1).fXo = paramcaj.HnZ;
        if (paramcaj.GQb.GnK == 0) {
          ((com.tencent.mm.k.a.a.a)localObject1).dBr = paramcaj.HnZ;
        }
        localObject3 = new mo();
        ((mo)localObject3).dBq.chatroomName = paramArrayOfByte;
        ((mo)localObject3).dBq.dBr = ((com.tencent.mm.k.a.a.a)localObject1).dBr;
        r.a(paramArrayOfByte, paramcaj.HnQ, paramcaj.GQb, paramcaj.Hof, paramcaj.Hoe, v.aAC(), (com.tencent.mm.k.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
      try
      {
        bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().Kh(paramArrayOfByte);
        bool2 = r.zF(paramArrayOfByte);
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((bool1) && (bool2))
        {
          localObject1 = new iu();
          ((iu)localObject1).dww.dwx = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
          r.ae(paramArrayOfByte, paramcaj.Hob);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool1;
          boolean bool2;
          long l;
          ae.e("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s, exception:%s %s", new Object[] { paramArrayOfByte, localException.getClass().getSimpleName(), localException.getMessage() });
          continue;
          if ((paraman1.fug()) && (com.tencent.mm.al.g.Ep(paraman1.field_username)) && (paraman1 != null) && (paraman1.fug()) && (com.tencent.mm.al.g.Ep(paraman1.field_username)))
          {
            ae.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paraman1.field_username);
            bc.aCg();
            au localau = com.tencent.mm.model.c.azL().aVa(paraman1.field_username);
            ag.aGp().Ef(paraman1.field_username);
            if (localau == null)
            {
              bc.aCg();
              if (com.tencent.mm.model.c.azL().aVa("officialaccounts") == null)
              {
                localau = new au("officialaccounts");
                localau.fuK();
                bc.aCg();
                com.tencent.mm.model.c.azL().e(localau);
              }
              localau = new au(paraman1.field_username);
              localau.tY("officialaccounts");
              bc.aCg();
              com.tencent.mm.model.c.azL().e(localau);
              continue;
              if (((paraman2 == null) || ((paraman2.field_type & 0x800) != (paraman1.field_type & 0x800))) && (com.tencent.mm.al.g.Er(paraman1.field_username)) && (!com.tencent.mm.al.g.vz(paraman1.field_username)))
              {
                R(paraman1);
                continue;
                ae.i("MicroMsg.BigBallContactAssemblerImpl", "update stranger ok, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramcaj.GNt });
                continue;
                if (com.tencent.mm.al.g.Eu(paraman1.field_username))
                {
                  bc.aCg();
                  if (com.tencent.mm.model.c.azL().aVa(paraman1.field_username) == null)
                  {
                    paramArrayOfByte = ag.aGp().Ef(paraman1.field_username);
                    localau = new au(paraman1.field_username);
                    ae.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.KD(), paraman1.field_username });
                    localau.tY(bu.nullAsNil(paramArrayOfByte.KD()));
                    localau.fuK();
                    bc.aCg();
                    com.tencent.mm.model.c.azL().e(localau);
                    continue;
                    i = 0;
                    continue;
                    if ((paraman2 == null) || ((paraman2.field_type & 0x8) != (paraman1.field_type & 0x8)))
                    {
                      bc.aCg();
                      com.tencent.mm.model.c.azL().c(new String[] { paraman1.field_username }, "");
                      continue;
                      paraman2.fuK();
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
      if ((!com.tencent.mm.contact.c.lO(paraman1.field_type)) && (!paraman1.adt()) && (!an.Ac(paraman1.field_username)) && (!x.wb(paraman1.field_username)) && (!an.aji(paraman1.field_username)))
      {
        ae.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paraman1.field_username, Integer.valueOf(paraman1.field_type) });
        bc.aCg();
        com.tencent.mm.model.c.azL().aUY(paraman1.field_username);
      }
      if ((paraman1.field_type & 0x800) == 0) {
        break label2671;
      }
      if ((paraman2 == null) || ((paraman2.field_type & 0x800) != (paraman1.field_type & 0x800)))
      {
        if ((!com.tencent.mm.al.g.Er(paraman1.field_username)) || (com.tencent.mm.al.g.vz(paraman1.field_username))) {
          break label2485;
        }
        R(paraman1);
      }
      if ((paraman2 == null) || (com.tencent.mm.contact.c.lO(paraman2.field_type)) || (!com.tencent.mm.contact.c.lO(paraman1.field_type))) {
        break label2930;
      }
      bool1 = true;
      if (com.tencent.mm.contact.c.lO(paraman1.field_type))
      {
        bc.aCg();
        localObject1 = com.tencent.mm.model.c.azG().arE(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bu.isNullOrNil(((cg)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bu.isNullOrNil((String)localObject2))
          {
            bc.aCg();
            paramArrayOfByte = com.tencent.mm.model.c.azG().arE((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bu.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          bc.aCg();
          com.tencent.mm.model.c.azG().arF(paramArrayOfByte.field_encryptUsername);
        }
      }
      if ((com.tencent.mm.contact.c.lO(paraman1.field_type)) && (!bu.isNullOrNil(paramcaj.GNt)))
      {
        bc.aCg();
        paramArrayOfByte = com.tencent.mm.model.c.azH().aqT(paramcaj.GuF.HId);
        if ((paramArrayOfByte != null) && (!bu.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          paramArrayOfByte.field_username = paramcaj.GNt;
          paramArrayOfByte.field_modifyTime = System.currentTimeMillis();
          bc.aCg();
          if (com.tencent.mm.model.c.azH().replace(paramArrayOfByte)) {
            break label2721;
          }
          ae.e("MicroMsg.BigBallContactAssemblerImpl", "update stranger fail, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramcaj.GNt });
        }
      }
      if (com.tencent.mm.al.g.Eq(paraman1.field_username))
      {
        ag.aGy();
        e.a(paraman1.field_username, null);
        if ((bool1) && (com.tencent.mm.al.g.Er(paraman1.field_username)))
        {
          if (!com.tencent.mm.al.g.vz(paraman1.field_username)) {
            break label2751;
          }
          ag.aGx();
          com.tencent.mm.al.a.h.a(paraman1.field_username, null);
        }
      }
      paramArrayOfByte = com.tencent.mm.al.g.eX(paraman1.field_username);
      if (paramArrayOfByte == null) {
        break label2867;
      }
      paramArrayOfByte = paramArrayOfByte.bX(false);
      if (paramArrayOfByte == null) {
        break label2867;
      }
      i = 0;
      if (paramArrayOfByte.cRf != null) {
        i = paramArrayOfByte.cRf.optInt("WXAppType", 0);
      }
      if (i == 0) {
        break label2867;
      }
      i = 1;
      if (i != 0)
      {
        ag.aGB();
        com.tencent.mm.al.a.DW(paraman1.field_username);
      }
      if ((paraman1.field_type & 0x8) == 0) {
        break label2873;
      }
      if ((paraman2 == null) || ((paraman2.field_type & 0x8) != (paraman1.field_type & 0x8)))
      {
        bc.aCg();
        com.tencent.mm.model.c.azL().c(new String[] { paraman1.field_username }, "@blacklist");
      }
      if (!paramBoolean)
      {
        if ((paraman1 != null) && (paraman1.fug()) && (com.tencent.mm.contact.c.lO(paraman1.field_type)))
        {
          l = System.currentTimeMillis();
          bc.aCg();
          paramArrayOfByte = com.tencent.mm.model.c.azL().aVa(paraman1.field_username);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.lS(4194304)))
          {
            bc.aCg();
            bool2 = com.tencent.mm.model.c.azL().a(paraman1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
            ae.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paraman1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
        if ((paraman2 != null) && ((int)paraman2.ght > 0) && (paraman2.eRm != 0) && (paraman2.eRn == 0) && (paraman1.eRn == 1))
        {
          ae.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paraman1.field_username });
          bc.aCg();
          com.tencent.mm.model.c.azL().aVq(paraman1.field_username);
          bc.aCg();
          paraman2 = com.tencent.mm.model.c.azL().aVa("officialaccounts");
          if (paraman2 != null)
          {
            bc.aCg();
            paraman2.kr(com.tencent.mm.model.c.azL().fuR());
            ae.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paraman2.field_unReadCount) });
            bc.aCg();
            paramArrayOfByte = com.tencent.mm.model.c.azL().aVn("officialaccounts");
            bc.aCg();
            paramArrayOfByte = com.tencent.mm.model.c.azI().arc(paramArrayOfByte);
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
              break label2923;
            }
            paraman2.aK(paramArrayOfByte);
            paraman2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
            paraman2.tV(Integer.toString(paramArrayOfByte.getType()));
            bc.aCg();
            localObject1 = com.tencent.mm.model.c.azL().MV();
            if (localObject1 != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              localObject4 = new PInt();
              paramArrayOfByte.ui("officialaccounts");
              paramArrayOfByte.setContent(paraman2.field_content);
              ((br.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
              paraman2.tW(((PString)localObject2).value);
              paraman2.tX(((PString)localObject3).value);
              paraman2.ku(((PInt)localObject4).value);
            }
            bc.aCg();
            com.tencent.mm.model.c.azL().a(paraman2, paraman2.field_username);
          }
        }
      }
      if (bool1)
      {
        paraman2 = new lz();
        paraman2.dAr.username = paraman1.field_username;
        paraman2.dAr.dAs = paraman1.dAs;
        com.tencent.mm.sdk.b.a.IvT.l(paraman2);
      }
      if ((bool1) && (paramcaj.ucK == 18))
      {
        paraman2 = new lc();
        paraman2.dzq.dzr = paraman1.field_encryptUsername;
        paraman2.dzq.type = 2;
        com.tencent.mm.bj.d.aMN().aqV(paraman2.dzq.dzr);
        com.tencent.mm.sdk.b.a.IvT.l(paraman2);
      }
      if (bool1) {
        cv(paraman1.field_username, paramcaj.ucK);
      }
      ae.i("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paraman1.adz()), Boolean.valueOf(paramBoolean) });
      if ((!paramBoolean) && (bool1) && (paraman1.adz()))
      {
        paraman2 = paraman1.field_username;
        if (!o.zsy.awb(paraman2))
        {
          paraman2 = new LinkedList();
          paraman2.add(paraman1.field_username);
          paraman1 = new oz();
          paraman1.dDT.list = paraman2;
          paraman1.dDT.dsO = 1;
          paraman1.dDT.dDU = 5L;
          paraman1.dDT.dDV = true;
          com.tencent.mm.sdk.b.a.IvT.l(paraman1);
        }
      }
      com.tencent.mm.plugin.label.a.a.dig().aoM();
      AppMethodBeat.o(22336);
      return;
      label2001:
      localObject3 = com.tencent.mm.bi.d.iup.aMK();
      if ((bu.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!x.wb(paramArrayOfByte)))
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
            localObject3 = (vz)((Iterator)localObject1).next();
            if ((!bu.isNullOrNil(((vz)localObject3).nIJ)) && (((vz)localObject3).nIJ.equals(v.aAC())))
            {
              i = 0;
              break;
            }
          }
        }
      }
      if (com.tencent.mm.bi.d.iuo != null)
      {
        if (com.tencent.mm.bi.d.iuo.bx(paramArrayOfByte, v.aAC()))
        {
          ae.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
          localObject1 = new wy();
          ((wy)localObject1).dMw.userName = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        com.tencent.mm.bi.d.iuo.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
      }
      if ((com.tencent.mm.bi.d.iup != null) && (!bu.isNullOrNil(com.tencent.mm.bi.d.iuo.aMJ())))
      {
        ae.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bi.d.iup.aMK() });
        localObject1 = new fl();
        ((fl)localObject1).drB.username = com.tencent.mm.bi.d.iup.aMK();
        com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
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
          localObject3 = (vz)((Iterator)localObject1).next();
          if (!bu.isNullOrNil(((vz)localObject3).nIJ)) {
            if (((vz)localObject3).nIJ.equals(v.aAC())) {
              break;
            }
          }
        }
      }
      label2333:
      if (com.tencent.mm.bh.g.ium != null) {
        com.tencent.mm.bh.g.ium.a(paramArrayOfByte, null, "", "", 0);
      }
      localObject1 = new wq();
      ((wq)localObject1).dMc.dMf = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new wp();
      ((wp)localObject1).dMa.dMb = true;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localObject1);
      break label138;
      i = 1;
      break label209;
      label2420:
      i = paramcaj.GQb.fNf;
      break label257;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final com.tencent.mm.ak.n paramn)
  {
    AppMethodBeat.i(22343);
    ae.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
    if (!com.tencent.mm.kernel.g.ajP().gDk)
    {
      ae.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    com.tencent.e.h.MqF.aP(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(186419);
        Object localObject2 = ((com.tencent.mm.ba.b)paramn).ild;
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
            ((Set)localObject1).add(z.a(((caj)new caj().parseFrom(localb.getBuffer())).GuF));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            k.b localb;
            ae.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", localException, "BaseProtoBuf parseFrom error!", new Object[0]);
            localObject1 = ((Set)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              String str = (String)((Iterator)localObject1).next();
              if (!bu.isNullOrNil(str)) {
                au.a.hIG.a(str, null, null);
              }
            }
            label151:
            if (localb.getCmdId() == 54) {
              ((Set)localObject1).add(((cam)new cam().parseFrom(localb.getBuffer())).Hol);
            } else if (localb.getCmdId() == 60) {
              ((Set)localObject1).add(((cbc)new cbc().parseFrom(localb.getBuffer())).Hol);
            }
          }
          AppMethodBeat.o(186419);
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
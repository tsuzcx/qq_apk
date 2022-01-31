package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.a.fa;
import com.tencent.mm.g.a.hk;
import com.tencent.mm.g.a.jh;
import com.tencent.mm.g.a.jh.a;
import com.tencent.mm.g.a.kb;
import com.tencent.mm.g.a.kq;
import com.tencent.mm.g.a.tk;
import com.tencent.mm.g.a.tl;
import com.tencent.mm.g.a.tl.b;
import com.tencent.mm.g.a.ts;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.b;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.bdt;
import com.tencent.mm.protocal.protobuf.bdu;
import com.tencent.mm.protocal.protobuf.bej;
import com.tencent.mm.protocal.protobuf.bmh;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.rc;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.wc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.ax;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.be.b;
import com.tencent.mm.storage.bf;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.bt;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.bv;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import junit.framework.Assert;
import org.json.JSONObject;

public final class c
  implements com.tencent.mm.ai.f, com.tencent.mm.plugin.messenger.foundation.a.c
{
  private static void D(ad paramad)
  {
    AppMethodBeat.i(18240);
    if ((paramad != null) && (com.tencent.mm.aj.f.rW(paramad.field_username)) && (!com.tencent.mm.aj.f.lg(paramad.field_username)))
    {
      com.tencent.mm.model.aw.aaz();
      ak localak = com.tencent.mm.model.c.YF().arH(paramad.field_username);
      paramad = z.afi().rK(paramad.field_username);
      if (!com.tencent.mm.aj.f.rZ(paramad.field_username))
      {
        AppMethodBeat.o(18240);
        return;
      }
      if (localak == null)
      {
        localak = new ak(paramad.field_username);
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramad.aeo(), paramad.field_username });
        localak.jY(bo.nullAsNil(paramad.aeo()));
        localak.dxc();
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.YF().d(localak);
      }
    }
    AppMethodBeat.o(18240);
  }
  
  private static void a(bdt parambdt, String paramString, ad paramad, boolean paramBoolean)
  {
    AppMethodBeat.i(18237);
    Object localObject = r.Zn();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = z.afi().rK(paramString);
      ((com.tencent.mm.aj.d)localObject).field_username = paramString;
      ((com.tencent.mm.aj.d)localObject).field_brandList = parambdt.gwZ;
      parambdt = parambdt.xpl;
      if (parambdt != null)
      {
        ((com.tencent.mm.aj.d)localObject).field_brandFlag = parambdt.gxd;
        ((com.tencent.mm.aj.d)localObject).field_brandInfo = parambdt.gxf;
        ((com.tencent.mm.aj.d)localObject).field_brandIconURL = parambdt.gxg;
        ((com.tencent.mm.aj.d)localObject).field_extInfo = parambdt.gxe;
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.aj.d)localObject).field_extInfo });
        if (paramBoolean)
        {
          ((com.tencent.mm.aj.d)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.aj.d)localObject).field_incrementUpdateTime = 0L;
          ab.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bo.isNullOrNil(((com.tencent.mm.aj.d)localObject).field_extInfo)) {
          ((com.tencent.mm.aj.d)localObject).cU(true);
        }
      }
      if ((((com.tencent.mm.aj.d)localObject).cU(false) != null) && (((com.tencent.mm.aj.d)localObject).cU(false).getServiceType() == 3) && (((com.tencent.mm.aj.d)localObject).cU(false).aeI() != null) && (!bo.isNullOrNil(((com.tencent.mm.aj.d)localObject).aeo())))
      {
        ((com.tencent.mm.aj.d)localObject).field_enterpriseFather = ((com.tencent.mm.aj.d)localObject).aeo();
        ab.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.aj.d)localObject).field_enterpriseFather });
      }
      if (!z.afi().e((com.tencent.mm.aj.d)localObject)) {
        z.afi().d((com.tencent.mm.aj.d)localObject);
      }
      paramad.hF(((com.tencent.mm.aj.d)localObject).field_type);
    }
    AppMethodBeat.o(18237);
  }
  
  public static boolean a(ad paramad, bdt parambdt, boolean paramBoolean)
  {
    AppMethodBeat.i(18238);
    if ((paramad == null) || (bo.isNullOrNil(paramad.field_username)))
    {
      ab.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(18238);
      return false;
    }
    String str = paramad.field_username;
    Object localObject1 = paramad.field_encryptUsername;
    Object localObject2 = com.tencent.mm.ah.b.a(str, parambdt);
    o.adg().b((com.tencent.mm.ah.h)localObject2);
    localObject2 = parambdt.xpk;
    if ((!paramad.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((cfj)localObject2).gxa + " " + parambdt.wOT);
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((cfj)localObject2).gxb);
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((cfj)localObject2).gxc);
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((cfj)localObject2).xPN);
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((cfj)localObject2).xPO);
      if (com.tencent.mm.plugin.sns.b.n.raR != null) {
        com.tencent.mm.plugin.sns.b.n.raR.a(paramad.field_username, (cfj)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.n.a.je(paramad.field_type))
    {
      bool = com.tencent.mm.bi.d.ali().eD(str, 1);
      if (!bool) {
        break label427;
      }
      ab.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.n.a.je(paramad.field_type)) && ((paramad.getSource() == 10) || (paramad.getSource() == 13)))
      {
        w.n(ah.getContext(), paramad.field_username, paramad.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramad.field_encryptUsername);
        if ((localObject1 != null) && (!bo.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).gwO)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramad.field_username;
          ab.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).gwO, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(parambdt, str, paramad, paramBoolean);
      AppMethodBeat.o(18238);
      return true;
      label427:
      bool = com.tencent.mm.bi.d.ali().eD((String)localObject1, 1);
      ab.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(ad paramad, bv parambv)
  {
    AppMethodBeat.i(18239);
    boolean bool2 = false;
    if (!bo.isNullOrNil(parambv.field_conDescription)) {
      paramad.jM(parambv.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!t.nS(paramad.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.n.a.je(paramad.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bo.isNullOrNil(parambv.field_conDescription))
        {
          bdu localbdu = new bdu();
          localbdu.xtI = paramad.field_username;
          localbdu.Desc = parambv.field_conDescription;
          com.tencent.mm.model.aw.aaz();
          com.tencent.mm.model.c.Yz().c(new j.a(54, localbdu));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(18239);
    return bool1;
  }
  
  private static void bI(String paramString, int paramInt)
  {
    AppMethodBeat.i(18241);
    bf[] arrayOfbf = null;
    bt[] arrayOfbt;
    Object localObject1;
    ax[] arrayOfax;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ab.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfbt = com.tencent.mm.bi.d.alk().asF(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ah.getContext(), arrayOfbt);
      arrayOfax = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(18241);
      return;
      if (paramInt == 18)
      {
        ab.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbf = com.tencent.mm.bi.d.alj().asg(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ah.getContext(), arrayOfbf);
        arrayOfbt = null;
        arrayOfax = null;
      }
      else
      {
        arrayOfax = com.tencent.mm.bi.d.alh().asc(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ah.getContext(), arrayOfax);
        arrayOfbt = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bi localbi;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbi = new bi();
      localbi.setContent(localObject2.fjL);
      m = t.oF(localObject2.username);
      if (arrayOfax != null)
      {
        j = paramInt + 1;
        localbi.fQ(arrayOfax[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label533:
    for (;;)
    {
      label215:
      localbi.kj(localObject2.username);
      localbi.setType(m);
      label252:
      long l;
      if (localObject2.cMU)
      {
        localbi.setStatus(2);
        localbi.hL(1);
        com.tencent.mm.model.aw.aaz();
        l = com.tencent.mm.model.c.YC().Z(localbi);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbf != null)
        {
          j = paramInt + 1;
          localbi.fQ(arrayOfbf[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfbt == null) {
          break label533;
        }
        j = paramInt + 1;
        localbi.fQ(arrayOfbt[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbi.setStatus(6);
        localbi.hL(0);
        break label252;
      }
      localObject1 = new bi();
      if (arrayOfax != null) {
        ((bi)localObject1).fQ(arrayOfax[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bi)localObject1).kj(paramString);
        ((bi)localObject1).setContent(ah.getContext().getString(2131304395));
        ((bi)localObject1).setType(10000);
        ((bi)localObject1).setStatus(6);
        ((bi)localObject1).hL(0);
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.YC().Z((bi)localObject1);
        AppMethodBeat.o(18241);
        return;
        if (arrayOfbf != null) {
          ((bi)localObject1).fQ(arrayOfbf[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbt != null) {
          ((bi)localObject1).fQ(arrayOfbt[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(ad paramad1, ad paramad2, bdt parambdt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(18235);
    String str = paramad1.field_username;
    Object localObject1 = paramad1.field_encryptUsername;
    if ((paramad2 != null) && (!bo.nullAsNil(paramad2.dqU).equals(bo.nullAsNil(parambdt.xtD))))
    {
      com.tencent.mm.bc.c.aiT();
      com.tencent.mm.bc.c.tW(str);
    }
    if (!bo.ce(paramArrayOfByte))
    {
      if (ad.Nt(paramad1.field_verifyFlag)) {
        a(parambdt, str, paramad1, true);
      }
      if ((paramad2 == null) || (com.tencent.mm.n.a.je(paramad2.field_type)) || (!com.tencent.mm.n.a.je(paramad1.field_type))) {
        break label1696;
      }
    }
    label280:
    label798:
    label1696:
    for (int j = 1;; j = 0)
    {
      Object localObject2 = paramad1.field_username;
      if (parambdt.xtE == null) {}
      Object localObject3;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bo.g(Integer.valueOf(parambdt.xtE.xAM.size()))))
      {
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s", new Object[] { localObject2, paramArrayOfByte });
        localObject2 = new StringBuffer();
        if ((parambdt.xtE == null) || (parambdt.xtE.xAM == null)) {
          break label280;
        }
        paramArrayOfByte = parambdt.xtE.xAM.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (bmh)paramArrayOfByte.next();
          if (((bmh)localObject3).xAL != null) {
            ((StringBuffer)localObject2).append(((bmh)localObject3).xAL + ",");
          }
        }
        a(paramad1, parambdt, true);
        break;
      }
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramad1.field_username, ((StringBuffer)localObject2).toString() });
      paramArrayOfByte = null;
      int m = 0;
      if (paramad2 != null) {
        paramArrayOfByte = paramad2.dqZ;
      }
      if (paramArrayOfByte != null)
      {
        paramad2 = paramArrayOfByte;
        if (!paramArrayOfByte.equals("")) {}
      }
      else
      {
        com.tencent.mm.model.aw.aaz();
        localObject3 = com.tencent.mm.model.c.YB().TM((String)localObject1);
        paramad2 = paramArrayOfByte;
        if (localObject3 != null) {
          paramad2 = ((bv)localObject3).field_conPhone;
        }
      }
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramad1.field_username, bo.nullAsNil(paramad2) });
      int i;
      if (!bo.isNullOrNil(paramad2))
      {
        paramad2 = paramad2.split(",");
        int i2 = paramad2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          paramArrayOfByte = paramad2[k];
          int n = i;
          int i1 = m;
          if (!bo.isNullOrNil(((StringBuffer)localObject2).toString()))
          {
            localObject3 = ((StringBuffer)localObject2).toString().split(",");
            i1 = localObject3.length;
            n = 0;
            while (n < i1) {
              if (!paramArrayOfByte.equals(localObject3[n]))
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
              ((StringBuffer)localObject2).append(paramArrayOfByte);
              i1 = 1;
              n = i;
            }
          }
          k += 1;
          i = n;
          m = i1;
        }
        if (m != 0)
        {
          paramad2 = new bej();
          paramad2.xtI = paramad1.field_username;
          paramArrayOfByte = new bmi();
          if (!bo.isNullOrNil(((StringBuffer)localObject2).toString()))
          {
            localObject3 = ((StringBuffer)localObject2).toString().split(",");
            paramArrayOfByte.jJu = localObject3.length;
            paramArrayOfByte.xAM = new LinkedList();
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              Object localObject4 = localObject3[i];
              bmh localbmh = new bmh();
              localbmh.xAL = localObject4;
              paramArrayOfByte.xAM.add(localbmh);
              i += 1;
            }
            paramad2.xtE = paramArrayOfByte;
            com.tencent.mm.model.aw.aaz();
            com.tencent.mm.model.c.Yz().c(new j.a(60, paramad2));
          }
        }
        if ((j != 0) && (15 == parambdt.niK) && (!bo.isNullOrNil(paramad1.field_username)))
        {
          paramad2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(paramad1.field_username);
          if (paramad2 != null)
          {
            paramArrayOfByte = com.tencent.mm.plugin.report.service.h.qsU;
            localObject3 = paramad1.field_username;
            if (!bo.isNullOrNil(paramad2.Al())) {
              break label1155;
            }
            i = 0;
            if (((StringBuffer)localObject2).toString().split(",").length < 5) {
              break label1161;
            }
            j = 5;
            paramArrayOfByte.e(12040, new Object[] { localObject3, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j) });
          }
        }
      }
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramad1.field_username, ((StringBuffer)localObject2).toString() });
      paramad2 = ((StringBuffer)localObject2).toString();
      if (!bo.isNullOrNil(paramad2))
      {
        ab.i("MicroMsg.BigBallContactAssemblerImpl", paramad2);
        paramad1.jS(paramad2);
      }
      if ((!t.lA(str)) && (parambdt.xaC != null)) {
        com.tencent.mm.model.n.a(str, parambdt.xaC);
      }
      boolean bool1 = false;
      com.tencent.mm.model.aw.aaz();
      paramArrayOfByte = com.tencent.mm.model.c.YB().TM(paramad1.field_username);
      if (!bo.isNullOrNil(paramad1.field_conRemark)) {
        if ((paramArrayOfByte != null) && (!bo.isNullOrNil(paramad1.dqT)) && (!paramad1.dqT.equals(paramArrayOfByte.field_conDescription))) {
          a(paramad1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramad1.field_username, Boolean.valueOf(bool1), localObject1 });
        if (bool1) {
          t.v(paramad1);
        }
        paramad2 = null;
        com.tencent.mm.model.aw.aaz();
        paramArrayOfByte = com.tencent.mm.model.c.YB().TM(paramad1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramad2 = paramArrayOfByte.field_contactLabels;
        }
        parambdt = paramad2;
        if (bo.isNullOrNil(paramad2))
        {
          com.tencent.mm.model.aw.aaz();
          localObject1 = com.tencent.mm.model.c.YB().TM(paramad1.field_username);
          parambdt = paramad2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            parambdt = ((bv)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bo.isNullOrNil(parambdt))
        {
          com.tencent.mm.plugin.label.a.a.bKV().eY(paramad1.field_username, parambdt);
          paramArrayOfByte.field_contactLabels = "";
          com.tencent.mm.model.aw.aaz();
          com.tencent.mm.model.c.YB().replace(paramArrayOfByte);
        }
        AppMethodBeat.o(18235);
        return;
        i = 1;
        break;
        j = ((StringBuffer)localObject2).toString().split(",").length;
        break label798;
        if (paramArrayOfByte != null)
        {
          paramad2 = paramArrayOfByte;
          if (!bo.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          paramad2 = paramArrayOfByte;
          if (!bo.isNullOrNil((String)localObject1))
          {
            com.tencent.mm.model.aw.aaz();
            paramad2 = com.tencent.mm.model.c.YB().TM((String)localObject1);
          }
        }
        paramBoolean = bool1;
        if (paramad2 != null)
        {
          paramBoolean = bool1;
          if (!bo.isNullOrNil(paramad2.field_encryptUsername))
          {
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramad2.field_encryptUsername);
            paramad1.jn(paramad2.field_conRemark);
            paramad1.jt(com.tencent.mm.platformtools.g.wq(paramad2.field_conRemark));
            paramad1.ju(com.tencent.mm.platformtools.g.wr(paramad2.field_conRemark));
            paramBoolean = a(paramad1, paramad2);
          }
        }
        switch (paramad1.getSource())
        {
        }
      }
      paramad2 = null;
      if ((parambdt != null) && (!bo.isNullOrNil(parambdt.xtx)))
      {
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { parambdt.xtx, parambdt.xty });
        paramArrayOfByte = com.tencent.mm.plugin.account.a.getAddrUploadStg();
        paramad2 = parambdt.xtx;
        str = parambdt.xty;
        parambdt = paramArrayOfByte.xa(paramad2);
        paramad2 = parambdt;
        if (parambdt == null) {
          paramad2 = paramArrayOfByte.xa(str);
        }
        if (paramad2 != null) {
          break label1651;
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramad2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bo.isNullOrNil(paramad2.apZ())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramad2.aqh()) {
          break;
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramad2.apZ(), paramad2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramad2.username = paramad1.field_username;
        paramad2.status = 2;
        paramad2.aqg();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramad1.jn(paramad2.apZ());
          paramad1.jt(com.tencent.mm.platformtools.g.wq(paramad2.apZ()));
          paramad1.ju(com.tencent.mm.platformtools.g.wr(paramad2.apZ()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.n.a.je(paramad1.field_type)) {
          break;
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramad2.apZ(), paramad2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramad2.Al(), paramad2);
        bool1 = bool2;
        break;
        if (bo.isNullOrNil((String)localObject1)) {
          break label1426;
        }
        paramad2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX((String)localObject1);
        break label1426;
        label1651:
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bo.nullAsNil(paramad2.apZ()), bo.nullAsNil(paramad2.getUsername()), Boolean.valueOf(paramad2.aqh()) });
      }
    }
  }
  
  public final void b(ad paramad1, ad paramad2, bdt parambdt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(18236);
    paramArrayOfByte = paramad1.field_username;
    Object localObject2 = paramad1.field_encryptUsername;
    Object localObject1;
    Object localObject3;
    label138:
    label209:
    label240:
    Object localObject4;
    int j;
    if (t.lA(paramArrayOfByte))
    {
      if (parambdt.xaC != null)
      {
        localObject1 = parambdt.xaC.wJm;
        if (com.tencent.mm.bh.d.fUP != null) {
          break label1627;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = parambdt.xaC.wJm;
          localObject3 = new tl();
          ((tl)localObject3).cJT.cJV = true;
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bo.isNullOrNil(paramArrayOfByte)) && (t.lA(paramArrayOfByte)) && (!bo.isNullOrNil(((tl)localObject3).cJU.cJX)) && (paramArrayOfByte.equals(((tl)localObject3).cJU.cJX))) {
            break label1897;
          }
        }
        localObject1 = parambdt.xaC.wJm;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (rd)((Iterator)localObject1).next();
          } while ((bo.isNullOrNil(((rd)localObject3).jJA)) || (!((rd)localObject3).jJA.equals(r.Zn())));
        }
        i = 0;
        if (i != 0) {
          ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.multitalk.model.a.class)).Uh(paramArrayOfByte);
        }
      }
      if (parambdt.xaC != null) {
        break label2046;
      }
      i = 0;
      localObject1 = parambdt.xts;
      localObject3 = parambdt.xtr;
      int k = parambdt.xtC;
      int m = parambdt.xtB;
      localObject4 = parambdt.nuz;
      int n = parambdt.xtA;
      if (parambdt.xaC != null) {
        break label2058;
      }
      j = -1;
      label286:
      ab.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(j) });
      if ((parambdt.xaC != null) && (parambdt.xaC.eeF != 0))
      {
        localObject1 = new com.tencent.mm.j.a.a.a();
        ((com.tencent.mm.j.a.a.a)localObject1).type = parambdt.xtC;
        ((com.tencent.mm.j.a.a.a)localObject1).eeH = parambdt.xtB;
        ((com.tencent.mm.j.a.a.a)localObject1).elv = parambdt.nuz;
        ((com.tencent.mm.j.a.a.a)localObject1).elw = parambdt.xtA;
        if (parambdt.xaC.wJn == 0) {
          ((com.tencent.mm.j.a.a.a)localObject1).cAE = parambdt.xtA;
        }
        if (com.tencent.mm.model.n.N(paramArrayOfByte, parambdt.xtA))
        {
          localObject3 = new hk();
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject3);
          com.tencent.mm.model.n.O(paramArrayOfByte, parambdt.xtC);
        }
        localObject3 = new kq();
        ((kq)localObject3).cAD.chatroomName = paramArrayOfByte;
        ((kq)localObject3).cAD.cAE = ((com.tencent.mm.j.a.a.a)localObject1).cAE;
        com.tencent.mm.model.n.a(paramArrayOfByte, parambdt.xtr, parambdt.xaC, parambdt.xtG, r.Zn(), (com.tencent.mm.j.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    if ((!com.tencent.mm.n.a.je(paramad1.field_type)) && (!paramad1.NU()) && (!ad.nM(paramad1.field_username)) && (!t.lA(paramad1.field_username)))
    {
      ab.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramad1.field_username, Integer.valueOf(paramad1.field_type) });
      com.tencent.mm.model.aw.aaz();
      com.tencent.mm.model.c.YF().arF(paramad1.field_username);
    }
    if ((paramad1.field_type & 0x800) != 0) {
      if ((paramad2 == null) || ((paramad2.field_type & 0x800) != (paramad1.field_type & 0x800)))
      {
        if ((com.tencent.mm.aj.f.rW(paramad1.field_username)) && (!com.tencent.mm.aj.f.lg(paramad1.field_username))) {
          D(paramad1);
        }
      }
      else {
        label679:
        if ((paramad2 == null) || (com.tencent.mm.n.a.je(paramad2.field_type)) || (!com.tencent.mm.n.a.je(paramad1.field_type))) {
          break label2502;
        }
      }
    }
    label934:
    label1959:
    label2495:
    label2502:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.n.a.je(paramad1.field_type))
      {
        com.tencent.mm.model.aw.aaz();
        localObject1 = com.tencent.mm.model.c.YB().TM(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bo.isNullOrNil(((bv)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bo.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.model.aw.aaz();
            paramArrayOfByte = com.tencent.mm.model.c.YB().TM((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bo.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          com.tencent.mm.model.aw.aaz();
          com.tencent.mm.model.c.YB().TN(paramArrayOfByte.field_encryptUsername);
        }
      }
      if (com.tencent.mm.aj.f.rV(paramad1.field_username))
      {
        z.afr();
        com.tencent.mm.aj.c.a(paramad1.field_username, null);
        if ((i != 0) && (com.tencent.mm.aj.f.rW(paramad1.field_username)))
        {
          if (!com.tencent.mm.aj.f.lg(paramad1.field_username)) {
            break label2306;
          }
          z.afq();
          com.tencent.mm.aj.a.h.a(paramad1.field_username, null);
        }
      }
      label874:
      paramArrayOfByte = com.tencent.mm.aj.f.rS(paramad1.field_username);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.cU(false);
        if (paramArrayOfByte != null)
        {
          j = 0;
          if (paramArrayOfByte.fvc != null) {
            j = paramArrayOfByte.fvc.optInt("WXAppType", 0);
          }
          if (j != 0)
          {
            j = 1;
            if (j != 0)
            {
              z.afu();
              com.tencent.mm.aj.a.rt(paramad1.field_username);
            }
            if ((paramad1.field_type & 0x8) == 0) {
              break label2445;
            }
            if ((paramad2 == null) || ((paramad2.field_type & 0x8) != (paramad1.field_type & 0x8)))
            {
              com.tencent.mm.model.aw.aaz();
              com.tencent.mm.model.c.YF().c(new String[] { paramad1.field_username }, "@blacklist");
            }
            label1007:
            if (!paramBoolean)
            {
              if ((paramad1 != null) && (paramad1.dwz()) && (com.tencent.mm.n.a.je(paramad1.field_type)))
              {
                long l = System.currentTimeMillis();
                com.tencent.mm.model.aw.aaz();
                paramArrayOfByte = com.tencent.mm.model.c.YF().arH(paramad1.field_username);
                if ((paramArrayOfByte != null) && (paramArrayOfByte.ji(4194304)))
                {
                  com.tencent.mm.model.aw.aaz();
                  paramBoolean = com.tencent.mm.model.c.YF().a(paramad1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
                  ab.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramad1.field_username, Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis() - l) });
                }
              }
              if ((paramad2 != null) && ((int)paramad2.euF > 0) && (paramad2.dqR != 0) && (paramad2.dqS == 0) && (paramad1.dqS == 1))
              {
                ab.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramad1.field_username });
                com.tencent.mm.model.aw.aaz();
                com.tencent.mm.model.c.YF().arW(paramad1.field_username);
                com.tencent.mm.model.aw.aaz();
                paramad2 = com.tencent.mm.model.c.YF().arH("officialaccounts");
                if (paramad2 != null)
                {
                  com.tencent.mm.model.aw.aaz();
                  paramad2.hJ(com.tencent.mm.model.c.YF().dxk());
                  ab.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramad2.field_unReadCount) });
                  com.tencent.mm.model.aw.aaz();
                  paramArrayOfByte = com.tencent.mm.model.c.YF().arT("officialaccounts");
                  com.tencent.mm.model.aw.aaz();
                  paramArrayOfByte = com.tencent.mm.model.c.YC().Tm(paramArrayOfByte);
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
                    break label2495;
                  }
                  paramad2.aq(paramArrayOfByte);
                  paramad2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
                  paramad2.jV(Integer.toString(paramArrayOfByte.getType()));
                  com.tencent.mm.model.aw.aaz();
                  localObject1 = com.tencent.mm.model.c.YF().BX();
                  if (localObject1 != null)
                  {
                    localObject2 = new PString();
                    localObject3 = new PString();
                    localObject4 = new PInt();
                    paramArrayOfByte.kj("officialaccounts");
                    paramArrayOfByte.setContent(paramad2.field_content);
                    ((be.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
                    paramad2.jW(((PString)localObject2).value);
                    paramad2.jX(((PString)localObject3).value);
                    paramad2.hM(((PInt)localObject4).value);
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.YF().a(paramad2, paramad2.field_username);
        if (i != 0)
        {
          paramad2 = new kb();
          paramad2.czE.username = paramad1.field_username;
          paramad2.czE.czF = paramad1.czF;
          com.tencent.mm.sdk.b.a.ymk.l(paramad2);
        }
        if ((i != 0) && (parambdt.niK == 18))
        {
          paramad2 = new jh();
          paramad2.cyK.cyL = paramad1.field_encryptUsername;
          paramad2.cyK.type = 2;
          com.tencent.mm.bi.d.alj().Tf(paramad2.cyK.cyL);
          com.tencent.mm.sdk.b.a.ymk.l(paramad2);
        }
        if (i != 0) {
          bI(paramad1.field_username, parambdt.niK);
        }
        com.tencent.mm.plugin.label.a.a.bKV().ahN();
        AppMethodBeat.o(18236);
        return;
        label1627:
        localObject3 = com.tencent.mm.bh.d.fUP.alg();
        if ((bo.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!t.lA(paramArrayOfByte)))
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
              localObject3 = (rd)((Iterator)localObject1).next();
              if ((!bo.isNullOrNil(((rd)localObject3).jJA)) && (((rd)localObject3).jJA.equals(r.Zn())))
              {
                i = 0;
                break;
              }
            }
          }
        }
        if (com.tencent.mm.bh.d.fUO != null)
        {
          if (com.tencent.mm.bh.d.fUO.aY(paramArrayOfByte, r.Zn()))
          {
            ab.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
            localObject1 = new ts();
            ((ts)localObject1).cKl.userName = paramArrayOfByte;
            com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
          }
          com.tencent.mm.bh.d.fUO.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
        }
        if ((com.tencent.mm.bh.d.fUP != null) && (!bo.isNullOrNil(com.tencent.mm.bh.d.fUO.alf())))
        {
          ab.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bh.d.fUP.alg() });
          localObject1 = new fa();
          ((fa)localObject1).csJ.username = com.tencent.mm.bh.d.fUP.alg();
          com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        i = 1;
        break;
        label1897:
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1959;
            }
            localObject3 = (rd)((Iterator)localObject1).next();
            if (!bo.isNullOrNil(((rd)localObject3).jJA)) {
              if (((rd)localObject3).jJA.equals(r.Zn())) {
                break;
              }
            }
          }
        }
        if (com.tencent.mm.bg.g.fUM != null) {
          com.tencent.mm.bg.g.fUM.a(paramArrayOfByte, null, "", "", 0);
        }
        localObject1 = new tl();
        ((tl)localObject1).cJT.cJW = true;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new tk();
        ((tk)localObject1).cJR.cJS = true;
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject1);
        break label138;
        i = 1;
        break label209;
        label2046:
        i = parambdt.xaC.eeF;
        break label240;
        j = parambdt.xaC.wJn;
        break label286;
        if ((!paramad1.dwz()) || (!com.tencent.mm.aj.f.rU(paramad1.field_username)) || (paramad1 == null) || (!paramad1.dwz()) || (!com.tencent.mm.aj.f.rU(paramad1.field_username))) {
          break label679;
        }
        ab.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramad1.field_username);
        com.tencent.mm.model.aw.aaz();
        localObject1 = com.tencent.mm.model.c.YF().arH(paramad1.field_username);
        z.afi().rK(paramad1.field_username);
        if (localObject1 != null) {
          break label679;
        }
        com.tencent.mm.model.aw.aaz();
        if (com.tencent.mm.model.c.YF().arH("officialaccounts") == null)
        {
          localObject1 = new ak("officialaccounts");
          ((ak)localObject1).dxc();
          com.tencent.mm.model.aw.aaz();
          com.tencent.mm.model.c.YF().d((ak)localObject1);
        }
        localObject1 = new ak(paramad1.field_username);
        ((ak)localObject1).jY("officialaccounts");
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.YF().d((ak)localObject1);
        break label679;
        if (((paramad2 != null) && ((paramad2.field_type & 0x800) == (paramad1.field_type & 0x800))) || (!com.tencent.mm.aj.f.rW(paramad1.field_username)) || (com.tencent.mm.aj.f.lg(paramad1.field_username))) {
          break label679;
        }
        D(paramad1);
        break label679;
        if (!com.tencent.mm.aj.f.rZ(paramad1.field_username)) {
          break label874;
        }
        com.tencent.mm.model.aw.aaz();
        if (com.tencent.mm.model.c.YF().arH(paramad1.field_username) != null) {
          break label874;
        }
        paramArrayOfByte = z.afi().rK(paramad1.field_username);
        localObject1 = new ak(paramad1.field_username);
        if (!paramArrayOfByte.aei())
        {
          ab.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.aeo(), paramad1.field_username });
          ((ak)localObject1).jY(bo.nullAsNil(paramArrayOfByte.aeo()));
        }
        for (;;)
        {
          ((ak)localObject1).dxc();
          com.tencent.mm.model.aw.aaz();
          com.tencent.mm.model.c.YF().d((ak)localObject1);
          break;
          ((ak)localObject1).jY(null);
        }
        j = 0;
        break label934;
        if ((paramad2 != null) && ((paramad2.field_type & 0x8) == (paramad1.field_type & 0x8))) {
          break label1007;
        }
        com.tencent.mm.model.aw.aaz();
        com.tencent.mm.model.c.YF().c(new String[] { paramad1.field_username }, "");
        break label1007;
        paramad2.dxc();
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(18242);
    ab.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm.getType() != 681)
    {
      AppMethodBeat.o(18242);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(18242);
      return;
    }
    if (!com.tencent.mm.kernel.g.RJ().eHg)
    {
      ab.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(18242);
      return;
    }
    paramm = ((com.tencent.mm.az.b)paramm).fLH;
    paramString = new HashSet();
    try
    {
      paramm = paramm.iterator();
      while (paramm.hasNext())
      {
        localb = (j.b)paramm.next();
        if (localb.getCmdId() != 2) {
          break label251;
        }
        paramString.add(aa.a(((bdt)new bdt().parseFrom(localb.getBuffer())).wOT));
      }
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        j.b localb;
        ab.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", paramm, "BaseProtoBuf parseFrom error!", new Object[0]);
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramm = (String)paramString.next();
          if (!bo.isNullOrNil(paramm)) {
            ao.a.flI.a(paramm, null, null);
          }
        }
        label251:
        if (localb.getCmdId() == 54) {
          paramString.add(((bdu)new bdu().parseFrom(localb.getBuffer())).xtI);
        } else if (localb.getCmdId() == 60) {
          paramString.add(((bej)new bej().parseFrom(localb.getBuffer())).xtI);
        }
      }
      AppMethodBeat.o(18242);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
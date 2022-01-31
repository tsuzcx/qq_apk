package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.mm.R.l;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.a.ex;
import com.tencent.mm.h.a.hg;
import com.tencent.mm.h.a.iy;
import com.tencent.mm.h.a.iy.a;
import com.tencent.mm.h.a.js;
import com.tencent.mm.h.a.kd;
import com.tencent.mm.h.a.rt;
import com.tencent.mm.h.a.ru;
import com.tencent.mm.h.a.ru.b;
import com.tencent.mm.h.a.sb;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.l;
import com.tencent.mm.plugin.sns.b.n;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.axd;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.protocal.c.ben;
import com.tencent.mm.protocal.c.beo;
import com.tencent.mm.protocal.c.but;
import com.tencent.mm.protocal.c.oa;
import com.tencent.mm.protocal.c.ob;
import com.tencent.mm.protocal.c.sg;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.ak;
import com.tencent.mm.storage.aw;
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
  implements com.tencent.mm.ah.f, com.tencent.mm.plugin.messenger.foundation.a.c
{
  private static void C(ad paramad)
  {
    if ((paramad != null) && (com.tencent.mm.ai.f.lb(paramad.field_username)) && (!com.tencent.mm.ai.f.eW(paramad.field_username)))
    {
      au.Hx();
      localak = com.tencent.mm.model.c.FB().abv(paramad.field_username);
      paramad = z.My().kQ(paramad.field_username);
      if (com.tencent.mm.ai.f.le(paramad.field_username)) {
        break label63;
      }
    }
    label63:
    while (localak != null) {
      return;
    }
    ak localak = new ak(paramad.field_username);
    y.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramad.LG(), paramad.field_username });
    localak.dS(bk.pm(paramad.LG()));
    localak.cuB();
    au.Hx();
    com.tencent.mm.model.c.FB().d(localak);
  }
  
  private static void a(axd paramaxd, String paramString, ad paramad, boolean paramBoolean)
  {
    Object localObject = q.Gj();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = z.My().kQ(paramString);
      ((com.tencent.mm.ai.d)localObject).field_username = paramString;
      ((com.tencent.mm.ai.d)localObject).field_brandList = paramaxd.ffr;
      paramaxd = paramaxd.tpn;
      if (paramaxd != null)
      {
        ((com.tencent.mm.ai.d)localObject).field_brandFlag = paramaxd.ffv;
        ((com.tencent.mm.ai.d)localObject).field_brandInfo = paramaxd.ffx;
        ((com.tencent.mm.ai.d)localObject).field_brandIconURL = paramaxd.ffy;
        ((com.tencent.mm.ai.d)localObject).field_extInfo = paramaxd.ffw;
        if (paramBoolean)
        {
          ((com.tencent.mm.ai.d)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.ai.d)localObject).field_incrementUpdateTime = 0L;
          y.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bk.bl(((com.tencent.mm.ai.d)localObject).field_extInfo)) {
          ((com.tencent.mm.ai.d)localObject).bS(true);
        }
      }
      if ((((com.tencent.mm.ai.d)localObject).bS(false) != null) && (((com.tencent.mm.ai.d)localObject).bS(false).LW() == 3) && (((com.tencent.mm.ai.d)localObject).bS(false).Mb() != null) && (!bk.bl(((com.tencent.mm.ai.d)localObject).LG())))
      {
        ((com.tencent.mm.ai.d)localObject).field_enterpriseFather = ((com.tencent.mm.ai.d)localObject).LG();
        y.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.ai.d)localObject).field_enterpriseFather });
      }
      if (!z.My().e((com.tencent.mm.ai.d)localObject)) {
        z.My().d((com.tencent.mm.ai.d)localObject);
      }
      paramad.fu(((com.tencent.mm.ai.d)localObject).field_type);
    }
  }
  
  public static boolean a(ad paramad, axd paramaxd, boolean paramBoolean)
  {
    if ((paramad == null) || (bk.bl(paramad.field_username)))
    {
      y.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      return false;
    }
    String str1 = paramad.field_username;
    Object localObject1 = paramad.field_encryptUsername;
    Object localObject2 = com.tencent.mm.ag.b.a(str1, paramaxd);
    o.Kh().a((com.tencent.mm.ag.h)localObject2);
    localObject2 = paramaxd.tpm;
    if ((!paramad.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      y.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((but)localObject2).ffs + " " + paramaxd.sQs);
      y.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((but)localObject2).fft);
      y.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((but)localObject2).ffu);
      y.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((but)localObject2).tLp);
      if (n.omD != null) {
        n.omD.a(paramad.field_username, (but)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.n.a.gR(paramad.field_type))
    {
      bool = com.tencent.mm.bh.d.RY().du(str1, 1);
      if (bool)
      {
        y.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = " + str1);
        y.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = " + bool);
      }
    }
    else if ((com.tencent.mm.n.a.gR(paramad.field_type)) && ((paramad.getSource() == 10) || (paramad.getSource() == 13)))
    {
      localObject1 = ae.getContext();
      localObject2 = paramad.field_username;
      String str2 = paramad.field_encryptUsername;
      if (!w.bO((Context)localObject1)) {
        break label483;
      }
      com.tencent.mm.sdk.f.e.b(new com.tencent.mm.platformtools.h((Context)localObject1, w.bQ((Context)localObject1), (String)localObject2, str2), "MMAccountManager_updateSpecifiedContact").start();
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(paramad.field_encryptUsername);
      if ((localObject1 != null) && (!bk.bl(((com.tencent.mm.plugin.account.friend.a.a)localObject1).ffg)))
      {
        ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramad.field_username;
        int i = com.tencent.mm.plugin.account.b.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).ffg, (com.tencent.mm.plugin.account.friend.a.a)localObject1);
        y.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr " + i);
      }
      a(paramaxd, str1, paramad, paramBoolean);
      return true;
      bool = com.tencent.mm.bh.d.RY().du((String)localObject1, 1);
      y.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = " + (String)localObject1);
      break;
      label483:
      w.E((Context)localObject1, null);
      y.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }
  }
  
  private static boolean a(ad paramad, bv parambv)
  {
    boolean bool2 = false;
    if (!bk.bl(parambv.field_conDescription)) {
      paramad.dG(parambv.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!s.hj(paramad.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.n.a.gR(paramad.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bk.bl(parambv.field_conDescription))
        {
          axe localaxe = new axe();
          localaxe.ttJ = paramad.field_username;
          localaxe.kRN = parambv.field_conDescription;
          au.Hx();
          com.tencent.mm.model.c.Fv().b(new i.a(54, localaxe));
          bool1 = bool2;
        }
      }
    }
    return bool1;
  }
  
  private static void bh(String paramString, int paramInt)
  {
    bt[] arrayOfbt;
    Object localObject1;
    ax[] arrayOfax;
    bf[] arrayOfbf;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      y.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfbt = com.tencent.mm.bh.d.Sa().act(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ae.getContext(), arrayOfbt);
      arrayOfax = null;
      arrayOfbf = null;
    }
    while (localObject1 == null)
    {
      return;
      if (paramInt == 18)
      {
        y.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbf = com.tencent.mm.bh.d.RZ().abW(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ae.getContext(), arrayOfbf);
        arrayOfbt = null;
        arrayOfax = null;
      }
      else
      {
        arrayOfax = com.tencent.mm.bh.d.RX().abS(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(ae.getContext(), arrayOfax);
        arrayOfbt = null;
        arrayOfbf = null;
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
      localbi.setContent(localObject2.dTF);
      m = s.hW(localObject2.username);
      if (arrayOfax != null)
      {
        j = paramInt + 1;
        localbi.bg(arrayOfax[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label525:
    for (;;)
    {
      label206:
      localbi.ec(localObject2.username);
      localbi.setType(m);
      label243:
      long l;
      if (localObject2.ceg)
      {
        localbi.setStatus(2);
        localbi.fA(1);
        au.Hx();
        l = com.tencent.mm.model.c.Fy().T(localbi);
        if (l == -1L) {
          break label382;
        }
      }
      label382:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        y.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = " + l);
        i += 1;
        break;
        if (arrayOfbf != null)
        {
          j = paramInt + 1;
          localbi.bg(arrayOfbf[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label206;
        }
        if (arrayOfbt == null) {
          break label525;
        }
        j = paramInt + 1;
        localbi.bg(arrayOfbt[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label206;
        localbi.setStatus(6);
        localbi.fA(0);
        break label243;
      }
      localObject1 = new bi();
      if (arrayOfax != null) {
        ((bi)localObject1).bg(arrayOfax[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bi)localObject1).ec(paramString);
        ((bi)localObject1).setContent(ae.getContext().getString(R.l.transfer_greet_msg_tip));
        ((bi)localObject1).setType(10000);
        ((bi)localObject1).setStatus(6);
        ((bi)localObject1).fA(0);
        au.Hx();
        com.tencent.mm.model.c.Fy().T((bi)localObject1);
        return;
        if (arrayOfbf != null) {
          ((bi)localObject1).bg(arrayOfbf[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbt != null) {
          ((bi)localObject1).bg(arrayOfbt[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(ad paramad1, ad paramad2, axd paramaxd, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    String str = paramad1.field_username;
    Object localObject1 = paramad1.field_encryptUsername;
    if ((paramad2 != null) && (!bk.pm(paramad2.cCK).equals(bk.pm(paramaxd.ttE))))
    {
      com.tencent.mm.bb.c.PO();
      com.tencent.mm.bb.c.mM(str);
    }
    if (!bk.bE(paramArrayOfByte))
    {
      if (ad.Fn(paramad1.field_verifyFlag)) {
        a(paramaxd, str, paramad1, true);
      }
      if ((paramad2 == null) || (com.tencent.mm.n.a.gR(paramad2.field_type)) || (!com.tencent.mm.n.a.gR(paramad1.field_type))) {
        break label1684;
      }
    }
    label274:
    label1684:
    for (int j = 1;; j = 0)
    {
      Object localObject2 = paramad1.field_username;
      if (paramaxd.ttF == null) {}
      Object localObject3;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bk.g(Integer.valueOf(paramaxd.ttF.tzz.size()))))
      {
        y.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s", new Object[] { localObject2, paramArrayOfByte });
        localObject2 = new StringBuffer();
        if ((paramaxd.ttF == null) || (paramaxd.ttF.tzz == null)) {
          break label274;
        }
        paramArrayOfByte = paramaxd.ttF.tzz.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject3 = (ben)paramArrayOfByte.next();
          if (((ben)localObject3).tzy != null) {
            ((StringBuffer)localObject2).append(((ben)localObject3).tzy + ",");
          }
        }
        a(paramad1, paramaxd, true);
        break;
      }
      y.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramad1.field_username, ((StringBuffer)localObject2).toString() });
      paramArrayOfByte = null;
      int m = 0;
      if (paramad2 != null) {
        paramArrayOfByte = paramad2.cCP;
      }
      if (paramArrayOfByte != null)
      {
        paramad2 = paramArrayOfByte;
        if (!paramArrayOfByte.equals("")) {}
      }
      else
      {
        au.Hx();
        localObject3 = com.tencent.mm.model.c.Fx().Id((String)localObject1);
        paramad2 = paramArrayOfByte;
        if (localObject3 != null) {
          paramad2 = ((bv)localObject3).field_conPhone;
        }
      }
      y.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramad1.field_username, bk.pm(paramad2) });
      int i;
      if (!bk.bl(paramad2))
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
          if (!bk.bl(((StringBuffer)localObject2).toString()))
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
          paramad2 = new axq();
          paramad2.ttJ = paramad1.field_username;
          paramArrayOfByte = new beo();
          if (!bk.bl(((StringBuffer)localObject2).toString()))
          {
            localObject3 = ((StringBuffer)localObject2).toString().split(",");
            paramArrayOfByte.hPS = localObject3.length;
            paramArrayOfByte.tzz = new LinkedList();
            k = localObject3.length;
            i = 0;
            while (i < k)
            {
              Object localObject4 = localObject3[i];
              ben localben = new ben();
              localben.tzy = localObject4;
              paramArrayOfByte.tzz.add(localben);
              i += 1;
            }
            paramad2.ttF = paramArrayOfByte;
            au.Hx();
            com.tencent.mm.model.c.Fv().b(new i.a(60, paramad2));
          }
        }
        if ((j != 0) && (15 == paramaxd.swS) && (!bk.bl(paramad1.field_username)))
        {
          paramad2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(paramad1.field_username);
          if (paramad2 != null)
          {
            paramArrayOfByte = com.tencent.mm.plugin.report.service.h.nFQ;
            localObject3 = paramad1.field_username;
            if (!bk.bl(paramad2.Wv())) {
              break label1143;
            }
            i = 0;
            if (((StringBuffer)localObject2).toString().split(",").length < 5) {
              break label1149;
            }
            j = 5;
            label792:
            paramArrayOfByte.f(12040, new Object[] { localObject3, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(j) });
          }
        }
      }
      y.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramad1.field_username, ((StringBuffer)localObject2).toString() });
      paramad2 = ((StringBuffer)localObject2).toString();
      if (!bk.bl(paramad2))
      {
        y.i("MicroMsg.BigBallContactAssemblerImpl", paramad2);
        paramad1.dM(paramad2);
      }
      if ((!s.fn(str)) && (paramaxd.tcj != null)) {
        com.tencent.mm.model.m.a(str, paramaxd.tcj);
      }
      boolean bool1 = false;
      au.Hx();
      paramArrayOfByte = com.tencent.mm.model.c.Fx().Id(paramad1.field_username);
      if (!bk.bl(paramad1.field_conRemark)) {
        if ((paramArrayOfByte != null) && (!bk.bl(paramad1.cCJ)) && (!paramad1.cCJ.equals(paramArrayOfByte.field_conDescription))) {
          a(paramad1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        y.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramad1.field_username, Boolean.valueOf(bool1), localObject1 });
        if (bool1) {
          s.v(paramad1);
        }
        paramad2 = null;
        au.Hx();
        paramArrayOfByte = com.tencent.mm.model.c.Fx().Id(paramad1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramad2 = paramArrayOfByte.field_contactLabels;
        }
        paramaxd = paramad2;
        if (bk.bl(paramad2))
        {
          au.Hx();
          localObject1 = com.tencent.mm.model.c.Fx().Id(paramad1.field_username);
          paramaxd = paramad2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            paramaxd = ((bv)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bk.bl(paramaxd))
        {
          com.tencent.mm.plugin.label.a.a.bdA().dG(paramad1.field_username, paramaxd);
          paramArrayOfByte.field_contactLabels = "";
          au.Hx();
          com.tencent.mm.model.c.Fx().a(paramArrayOfByte);
        }
        return;
        label1143:
        i = 1;
        break;
        label1149:
        j = ((StringBuffer)localObject2).toString().split(",").length;
        break label792;
        if (paramArrayOfByte != null)
        {
          paramad2 = paramArrayOfByte;
          if (!bk.bl(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          paramad2 = paramArrayOfByte;
          if (!bk.bl((String)localObject1))
          {
            au.Hx();
            paramad2 = com.tencent.mm.model.c.Fx().Id((String)localObject1);
          }
        }
        paramBoolean = bool1;
        if (paramad2 != null)
        {
          paramBoolean = bool1;
          if (!bk.bl(paramad2.field_encryptUsername))
          {
            y.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramad2.field_encryptUsername);
            paramad1.df(paramad2.field_conRemark);
            paramad1.jdMethod_do(com.tencent.mm.platformtools.g.oY(paramad2.field_conRemark));
            paramad1.dp(com.tencent.mm.platformtools.g.oZ(paramad2.field_conRemark));
            paramBoolean = a(paramad1, paramad2);
          }
        }
        switch (paramad1.getSource())
        {
        }
      }
      paramad2 = null;
      if ((paramaxd != null) && (!bk.bl(paramaxd.ttx)))
      {
        y.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { paramaxd.ttx, paramaxd.tty });
        paramArrayOfByte = com.tencent.mm.plugin.account.b.getAddrUploadStg();
        paramad2 = paramaxd.ttx;
        str = paramaxd.tty;
        paramaxd = paramArrayOfByte.pI(paramad2);
        paramad2 = paramaxd;
        if (paramaxd == null) {
          paramad2 = paramArrayOfByte.pI(str);
        }
        if (paramad2 != null) {
          break label1639;
        }
        y.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramad2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bk.bl(paramad2.Wx())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramad2.WF()) {
          break;
        }
        y.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramad2.Wx(), paramad2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramad2.username = paramad1.field_username;
        paramad2.status = 2;
        paramad2.WE();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramad1.df(paramad2.Wx());
          paramad1.jdMethod_do(com.tencent.mm.platformtools.g.oY(paramad2.Wx()));
          paramad1.dp(com.tencent.mm.platformtools.g.oZ(paramad2.Wx()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.n.a.gR(paramad1.field_type)) {
          break;
        }
        y.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramad2.Wx(), paramad2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramad2.Wv(), paramad2);
        bool1 = bool2;
        break;
        if (bk.bl((String)localObject1)) {
          break label1414;
        }
        paramad2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH((String)localObject1);
        break label1414;
        label1639:
        y.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bk.pm(paramad2.Wx()), bk.pm(paramad2.getUsername()), Boolean.valueOf(paramad2.WF()) });
      }
    }
  }
  
  public final void b(ad paramad1, ad paramad2, axd paramaxd, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    paramArrayOfByte = paramad1.field_username;
    Object localObject2 = paramad1.field_encryptUsername;
    Object localObject1;
    Object localObject3;
    label132:
    label203:
    label234:
    Object localObject4;
    int j;
    if (s.fn(paramArrayOfByte))
    {
      if (paramaxd.tcj != null)
      {
        localObject1 = paramaxd.tcj.sLz;
        if (com.tencent.mm.bg.d.eEY != null) {
          break label1615;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = paramaxd.tcj.sLz;
          localObject3 = new ru();
          ((ru)localObject3).cbq.cbs = true;
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bk.bl(paramArrayOfByte)) && (s.fn(paramArrayOfByte)) && (!bk.bl(((ru)localObject3).cbr.cbu)) && (paramArrayOfByte.equals(((ru)localObject3).cbr.cbu))) {
            break label1885;
          }
        }
        localObject1 = paramaxd.tcj.sLz;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (ob)((Iterator)localObject1).next();
          } while ((bk.bl(((ob)localObject3).hPY)) || (!((ob)localObject3).hPY.equals(q.Gj())));
        }
        i = 0;
        if (i != 0) {
          ((com.tencent.mm.plugin.multitalk.a.a)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.multitalk.a.a.class)).Is(paramArrayOfByte);
        }
      }
      if (paramaxd.tcj != null) {
        break label2034;
      }
      i = 0;
      localObject1 = paramaxd.tts;
      localObject3 = paramaxd.ttr;
      int k = paramaxd.ttC;
      int m = paramaxd.ttB;
      localObject4 = paramaxd.kWx;
      int n = paramaxd.ttA;
      if (paramaxd.tcj != null) {
        break label2046;
      }
      j = -1;
      label280:
      y.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s ver:%d infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(j) });
      if ((paramaxd.tcj != null) && (paramaxd.tcj.dne != 0))
      {
        localObject1 = new com.tencent.mm.k.a.a.a();
        ((com.tencent.mm.k.a.a.a)localObject1).type = paramaxd.ttC;
        ((com.tencent.mm.k.a.a.a)localObject1).dng = paramaxd.ttB;
        ((com.tencent.mm.k.a.a.a)localObject1).dtI = paramaxd.kWx;
        ((com.tencent.mm.k.a.a.a)localObject1).dtJ = paramaxd.ttA;
        if (paramaxd.tcj.sLA == 0) {
          ((com.tencent.mm.k.a.a.a)localObject1).bSZ = paramaxd.ttA;
        }
        if (com.tencent.mm.model.m.G(paramArrayOfByte, paramaxd.ttA))
        {
          localObject3 = new hg();
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject3);
          com.tencent.mm.model.m.H(paramArrayOfByte, paramaxd.ttC);
        }
        localObject3 = new kd();
        ((kd)localObject3).bSY.chatroomName = paramArrayOfByte;
        ((kd)localObject3).bSY.bSZ = ((com.tencent.mm.k.a.a.a)localObject1).bSZ;
        com.tencent.mm.model.m.a(paramArrayOfByte, paramaxd.ttr, paramaxd.tcj, paramaxd.ttH, q.Gj(), (com.tencent.mm.k.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
    }
    if ((!com.tencent.mm.n.a.gR(paramad1.field_type)) && (!paramad1.Be()) && (!ad.hd(paramad1.field_username)) && (!s.fn(paramad1.field_username)))
    {
      y.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramad1.field_username, Integer.valueOf(paramad1.field_type) });
      au.Hx();
      com.tencent.mm.model.c.FB().abu(paramad1.field_username);
    }
    if ((paramad1.field_type & 0x800) != 0) {
      if ((paramad2 == null) || ((paramad2.field_type & 0x800) != (paramad1.field_type & 0x800)))
      {
        if ((com.tencent.mm.ai.f.lb(paramad1.field_username)) && (!com.tencent.mm.ai.f.eW(paramad1.field_username))) {
          C(paramad1);
        }
      }
      else {
        label673:
        if ((paramad2 == null) || (com.tencent.mm.n.a.gR(paramad2.field_type)) || (!com.tencent.mm.n.a.gR(paramad1.field_type))) {
          break label2490;
        }
      }
    }
    label928:
    label2483:
    label2490:
    for (int i = 1;; i = 0)
    {
      if (com.tencent.mm.n.a.gR(paramad1.field_type))
      {
        au.Hx();
        localObject1 = com.tencent.mm.model.c.Fx().Id(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bk.bl(((bv)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bk.bl((String)localObject2))
          {
            au.Hx();
            paramArrayOfByte = com.tencent.mm.model.c.Fx().Id((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bk.bl(paramArrayOfByte.field_encryptUsername)))
        {
          au.Hx();
          com.tencent.mm.model.c.Fx().Ie(paramArrayOfByte.field_encryptUsername);
        }
      }
      if (com.tencent.mm.ai.f.la(paramad1.field_username))
      {
        z.MH();
        com.tencent.mm.ai.c.a(paramad1.field_username, null);
        if ((i != 0) && (com.tencent.mm.ai.f.lb(paramad1.field_username)))
        {
          if (!com.tencent.mm.ai.f.eW(paramad1.field_username)) {
            break label2294;
          }
          z.MG();
          com.tencent.mm.ai.a.h.a(paramad1.field_username, null);
        }
      }
      label868:
      paramArrayOfByte = com.tencent.mm.ai.f.kX(paramad1.field_username);
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = paramArrayOfByte.bS(false);
        if (paramArrayOfByte != null)
        {
          j = 0;
          if (paramArrayOfByte.efa != null) {
            j = paramArrayOfByte.efa.optInt("WXAppType", 0);
          }
          if (j != 0)
          {
            j = 1;
            if (j != 0)
            {
              z.MK();
              com.tencent.mm.ai.a.kz(paramad1.field_username);
            }
            if ((paramad1.field_type & 0x8) == 0) {
              break label2433;
            }
            if ((paramad2 == null) || ((paramad2.field_type & 0x8) != (paramad1.field_type & 0x8)))
            {
              au.Hx();
              com.tencent.mm.model.c.FB().d(new String[] { paramad1.field_username }, "@blacklist");
            }
            label1001:
            if (!paramBoolean)
            {
              if ((paramad1 != null) && (paramad1.cua()) && (com.tencent.mm.n.a.gR(paramad1.field_type)))
              {
                long l = System.currentTimeMillis();
                au.Hx();
                paramArrayOfByte = com.tencent.mm.model.c.FB().abv(paramad1.field_username);
                if ((paramArrayOfByte != null) && (paramArrayOfByte.gV(4194304)))
                {
                  au.Hx();
                  paramBoolean = com.tencent.mm.model.c.FB().a(paramad1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
                  y.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramad1.field_username, Boolean.valueOf(paramBoolean), Long.valueOf(System.currentTimeMillis() - l) });
                }
              }
              if ((paramad2 != null) && ((int)paramad2.dBe > 0) && (paramad2.cCH != 0) && (paramad2.cCI == 0) && (paramad1.cCI == 1))
              {
                y.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramad1.field_username });
                au.Hx();
                com.tencent.mm.model.c.FB().abM(paramad1.field_username);
                au.Hx();
                paramad2 = com.tencent.mm.model.c.FB().abv("officialaccounts");
                if (paramad2 != null)
                {
                  au.Hx();
                  paramad2.fy(com.tencent.mm.model.c.FB().cuK());
                  y.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramad2.field_unReadCount) });
                  au.Hx();
                  paramArrayOfByte = com.tencent.mm.model.c.FB().abJ("officialaccounts");
                  au.Hx();
                  paramArrayOfByte = com.tencent.mm.model.c.Fy().HA(paramArrayOfByte);
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
                    break label2483;
                  }
                  paramad2.ai(paramArrayOfByte);
                  paramad2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
                  paramad2.dP(Integer.toString(paramArrayOfByte.getType()));
                  au.Hx();
                  localObject1 = com.tencent.mm.model.c.FB().tt();
                  if (localObject1 != null)
                  {
                    localObject2 = new PString();
                    localObject3 = new PString();
                    localObject4 = new PInt();
                    paramArrayOfByte.ec("officialaccounts");
                    paramArrayOfByte.setContent(paramad2.field_content);
                    ((be.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
                    paramad2.dQ(((PString)localObject2).value);
                    paramad2.dR(((PString)localObject3).value);
                    paramad2.fB(((PInt)localObject4).value);
                  }
                }
              }
            }
          }
        }
      }
      for (;;)
      {
        au.Hx();
        com.tencent.mm.model.c.FB().a(paramad2, paramad2.field_username);
        if (i != 0)
        {
          paramad2 = new js();
          paramad2.bSd.username = paramad1.field_username;
          paramad2.bSd.bSe = paramad1.bSe;
          com.tencent.mm.sdk.b.a.udP.m(paramad2);
        }
        if ((i != 0) && (paramaxd.swS == 18))
        {
          paramad2 = new iy();
          paramad2.bRi.bRj = paramad1.field_encryptUsername;
          paramad2.bRi.type = 2;
          com.tencent.mm.bh.d.RZ().Ht(paramad2.bRi.bRj);
          com.tencent.mm.sdk.b.a.udP.m(paramad2);
        }
        if (i != 0) {
          bh(paramad1.field_username, paramaxd.swS);
        }
        com.tencent.mm.plugin.label.a.a.bdA().bdu();
        return;
        label1615:
        localObject3 = com.tencent.mm.bg.d.eEY.RW();
        if ((bk.bl((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!s.fn(paramArrayOfByte)))
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
              localObject3 = (ob)((Iterator)localObject1).next();
              if ((!bk.bl(((ob)localObject3).hPY)) && (((ob)localObject3).hPY.equals(q.Gj())))
              {
                i = 0;
                break;
              }
            }
          }
        }
        if (com.tencent.mm.bg.d.eEX != null)
        {
          if (com.tencent.mm.bg.d.eEX.aF(paramArrayOfByte, q.Gj()))
          {
            y.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
            localObject1 = new sb();
            ((sb)localObject1).cbI.userName = paramArrayOfByte;
            com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
          }
          com.tencent.mm.bg.d.eEX.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
        }
        if ((com.tencent.mm.bg.d.eEY != null) && (!bk.bl(com.tencent.mm.bg.d.eEX.RV())))
        {
          y.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bg.d.eEY.RW() });
          localObject1 = new ex();
          ((ex)localObject1).bLp.username = com.tencent.mm.bg.d.eEY.RW();
          com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        }
        i = 1;
        break;
        label1885:
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          for (;;)
          {
            if (!((Iterator)localObject1).hasNext()) {
              break label1947;
            }
            localObject3 = (ob)((Iterator)localObject1).next();
            if (!bk.bl(((ob)localObject3).hPY)) {
              if (((ob)localObject3).hPY.equals(q.Gj())) {
                break;
              }
            }
          }
        }
        if (com.tencent.mm.bf.g.eEV != null) {
          com.tencent.mm.bf.g.eEV.a(paramArrayOfByte, null, "", "", 0);
        }
        localObject1 = new ru();
        ((ru)localObject1).cbq.cbt = true;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        localObject1 = new rt();
        ((rt)localObject1).cbo.cbp = true;
        com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject1);
        break label132;
        i = 1;
        break label203;
        label2034:
        i = paramaxd.tcj.dne;
        break label234;
        label2046:
        j = paramaxd.tcj.sLA;
        break label280;
        if ((!paramad1.cua()) || (!com.tencent.mm.ai.f.kZ(paramad1.field_username)) || (paramad1 == null) || (!paramad1.cua()) || (!com.tencent.mm.ai.f.kZ(paramad1.field_username))) {
          break label673;
        }
        y.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramad1.field_username);
        au.Hx();
        localObject1 = com.tencent.mm.model.c.FB().abv(paramad1.field_username);
        z.My().kQ(paramad1.field_username);
        if (localObject1 != null) {
          break label673;
        }
        au.Hx();
        if (com.tencent.mm.model.c.FB().abv("officialaccounts") == null)
        {
          localObject1 = new ak("officialaccounts");
          ((ak)localObject1).cuB();
          au.Hx();
          com.tencent.mm.model.c.FB().d((ak)localObject1);
        }
        localObject1 = new ak(paramad1.field_username);
        ((ak)localObject1).dS("officialaccounts");
        au.Hx();
        com.tencent.mm.model.c.FB().d((ak)localObject1);
        break label673;
        if (((paramad2 != null) && ((paramad2.field_type & 0x800) == (paramad1.field_type & 0x800))) || (!com.tencent.mm.ai.f.lb(paramad1.field_username)) || (com.tencent.mm.ai.f.eW(paramad1.field_username))) {
          break label673;
        }
        C(paramad1);
        break label673;
        label2294:
        if (!com.tencent.mm.ai.f.le(paramad1.field_username)) {
          break label868;
        }
        au.Hx();
        if (com.tencent.mm.model.c.FB().abv(paramad1.field_username) != null) {
          break label868;
        }
        paramArrayOfByte = z.My().kQ(paramad1.field_username);
        localObject1 = new ak(paramad1.field_username);
        if (!paramArrayOfByte.LA())
        {
          y.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.LG(), paramad1.field_username });
          ((ak)localObject1).dS(bk.pm(paramArrayOfByte.LG()));
        }
        for (;;)
        {
          ((ak)localObject1).cuB();
          au.Hx();
          com.tencent.mm.model.c.FB().d((ak)localObject1);
          break;
          ((ak)localObject1).dS(null);
        }
        j = 0;
        break label928;
        if ((paramad2 != null) && ((paramad2.field_type & 0x8) == (paramad1.field_type & 0x8))) {
          break label1001;
        }
        au.Hx();
        com.tencent.mm.model.c.FB().d(new String[] { paramad1.field_username }, "");
        break label1001;
        paramad2.cuB();
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramm.getType() != 681) {}
    while ((paramInt1 != 0) || (paramInt2 != 0)) {
      return;
    }
    if (!com.tencent.mm.kernel.g.DN().dJH)
    {
      y.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      return;
    }
    paramm = ((com.tencent.mm.ay.a)paramm).evR;
    paramString = new HashSet();
    for (;;)
    {
      i.b localb;
      try
      {
        paramm = paramm.iterator();
        if (paramm.hasNext())
        {
          localb = (i.b)paramm.next();
          if (localb.getCmdId() != 2) {
            break label226;
          }
          paramString.add(aa.a(((axd)new axd().aH(localb.getBuffer())).sQs));
          continue;
        }
        if (!paramString.hasNext()) {
          break;
        }
      }
      catch (Exception paramm)
      {
        y.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", paramm, "BaseProtoBuf parseFrom error!", new Object[0]);
        paramString = paramString.iterator();
      }
      for (;;)
      {
        paramm = (String)paramString.next();
        if (!bk.bl(paramm)) {
          am.a.dVy.a(paramm, null, null);
        }
      }
      label226:
      if (localb.getCmdId() == 54) {
        paramString.add(((axe)new axe().aH(localb.getBuffer())).ttJ);
      } else if (localb.getCmdId() == 60) {
        paramString.add(((axq)new axq().aH(localb.getBuffer())).ttJ);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
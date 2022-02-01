package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.k;
import com.tencent.mm.ao.af;
import com.tencent.mm.ao.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.a.fv;
import com.tencent.mm.f.a.jz;
import com.tencent.mm.f.a.mj;
import com.tencent.mm.f.a.mj.a;
import com.tencent.mm.f.a.ng;
import com.tencent.mm.f.a.nx;
import com.tencent.mm.f.a.qp;
import com.tencent.mm.f.a.yw;
import com.tencent.mm.f.a.yx;
import com.tencent.mm.f.a.yx.b;
import com.tencent.mm.f.a.zg;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sns.b.m;
import com.tencent.mm.plugin.sns.b.p;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aez;
import com.tencent.mm.protocal.protobuf.cyb;
import com.tencent.mm.protocal.protobuf.cye;
import com.tencent.mm.protocal.protobuf.cyv;
import com.tencent.mm.protocal.protobuf.dkz;
import com.tencent.mm.protocal.protobuf.dla;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.elj;
import com.tencent.mm.protocal.protobuf.xm;
import com.tencent.mm.protocal.protobuf.xn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bn;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.bw.b;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
import com.tencent.mm.storage.co;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.an.i, com.tencent.mm.plugin.messenger.foundation.a.f
{
  private static int sgU = -1;
  
  private static void Y(as paramas)
  {
    AppMethodBeat.i(22341);
    if ((paramas != null) && (com.tencent.mm.ao.g.UB(paramas.field_username)) && (!com.tencent.mm.ao.g.KI(paramas.field_username)))
    {
      bh.beI();
      az localaz = com.tencent.mm.model.c.bbR().bwx(paramas.field_username);
      paramas = af.bjv().Uo(paramas.field_username);
      if (!com.tencent.mm.ao.g.UE(paramas.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localaz == null)
      {
        localaz = new az(paramas.field_username);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramas.Zf(), paramas.field_username });
        localaz.Jc(Util.nullAsNil(paramas.Zf()));
        localaz.hyE();
        bh.beI();
        com.tencent.mm.model.c.bbR().e(localaz);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  private static void a(cyb paramcyb, String paramString, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = z.bcZ();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = af.bjv().Uo(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = paramcyb.mVI;
      paramcyb = paramcyb.TxM;
      if (paramcyb != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = paramcyb.mVM;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = paramcyb.mVO;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramcyb.mVP;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = paramcyb.mVN;
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!Util.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).dc(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).dc(false) != null) && (((com.tencent.mm.api.c)localObject).dc(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).dc(false).Zz() != null) && (!Util.isNullOrNil(((com.tencent.mm.api.c)localObject).Zf())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).Zf();
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!af.bjv().h((com.tencent.mm.api.c)localObject)) {
        af.bjv().g((com.tencent.mm.api.c)localObject);
      }
      paramas.pD(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  public static boolean a(as paramas, cyb paramcyb, boolean paramBoolean)
  {
    AppMethodBeat.i(22338);
    if ((paramas == null) || (Util.isNullOrNil(paramas.field_username)))
    {
      Log.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(22338);
      return false;
    }
    String str = paramas.field_username;
    Object localObject1 = paramas.field_encryptUsername;
    Object localObject2 = com.tencent.mm.am.d.a(str, paramcyb, paramas);
    com.tencent.mm.am.q.bhP().b((com.tencent.mm.am.j)localObject2);
    localObject2 = paramcyb.TxL;
    if ((!paramas.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((elj)localObject2).mVJ + " " + paramcyb.SrH);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((elj)localObject2).mVK);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((elj)localObject2).mVL);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((elj)localObject2).Unw);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((elj)localObject2).Unx);
      if (p.JPd != null) {
        p.JPd.a(paramas.field_username, (elj)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.contact.d.rk(paramas.field_type))
    {
      bool = com.tencent.mm.bl.d.bqc().hx(str, 1);
      if (!bool) {
        break label428;
      }
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.contact.d.rk(paramas.field_type)) && ((paramas.getSource() == 10) || (paramas.getSource() == 13)))
      {
        t.o(MMApplicationContext.getContext(), paramas.field_username, paramas.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramas.field_encryptUsername);
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).mVx)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramas.field_username;
          Log.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.b.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).mVx, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(paramcyb, str, paramas, paramBoolean);
      AppMethodBeat.o(22338);
      return true;
      label428:
      bool = com.tencent.mm.bl.d.bqc().hx((String)localObject1, 1);
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(as paramas, co paramco)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramco.field_conDescription)) {
      paramas.IQ(paramco.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!ab.Qk(paramas.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.contact.d.rk(paramas.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!Util.isNullOrNil(paramco.field_conDescription))
        {
          cye localcye = new cye();
          localcye.TGE = paramas.field_username;
          localcye.CMB = paramco.field_conDescription;
          bh.beI();
          com.tencent.mm.model.c.bbK().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(54, localcye));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  public static boolean aoI(String paramString)
  {
    AppMethodBeat.i(22339);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = com.tencent.mm.pluginsdk.ui.span.k.a.Rsa.matcher(paramString);
    if (localMatcher.find())
    {
      if (Util.isEqual(paramString, localMatcher.group(0)))
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
  
  private static void cX(String paramString, int paramInt)
  {
    AppMethodBeat.i(22342);
    bx[] arrayOfbx = null;
    cm[] arrayOfcm;
    Object localObject1;
    bn[] arrayOfbn;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfcm = com.tencent.mm.bl.d.bqe().bxw(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfcm);
      arrayOfbn = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(22342);
      return;
      if (paramInt == 18)
      {
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbx = com.tencent.mm.bl.d.bqd().bwW(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfbx);
        arrayOfcm = null;
        arrayOfbn = null;
      }
      else
      {
        arrayOfbn = com.tencent.mm.bl.d.bqb().bwT(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfbn);
        arrayOfcm = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    ca localca;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localca = new ca();
      localca.setContent(localObject2.lpM);
      m = ab.QZ(localObject2.username);
      if (arrayOfbn != null)
      {
        j = paramInt + 1;
        localca.setCreateTime(arrayOfbn[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label533:
    for (;;)
    {
      label215:
      localca.Jm(localObject2.username);
      localca.setType(m);
      label252:
      long l;
      if (localObject2.gbt)
      {
        localca.setStatus(2);
        localca.pJ(1);
        bh.beI();
        l = com.tencent.mm.model.c.bbO().aM(localca);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbx != null)
        {
          j = paramInt + 1;
          localca.setCreateTime(arrayOfbx[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfcm == null) {
          break label533;
        }
        j = paramInt + 1;
        localca.setCreateTime(arrayOfcm[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localca.setStatus(6);
        localca.pJ(0);
        break label252;
      }
      localObject1 = new ca();
      if (arrayOfbn != null) {
        ((ca)localObject1).setCreateTime(arrayOfbn[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((ca)localObject1).Jm(paramString);
        ((ca)localObject1).setContent(MMApplicationContext.getContext().getString(R.l.eUw));
        ((ca)localObject1).setType(10000);
        ((ca)localObject1).setStatus(6);
        ((ca)localObject1).pJ(0);
        bh.beI();
        com.tencent.mm.model.c.bbO().aM((ca)localObject1);
        AppMethodBeat.o(22342);
        return;
        if (arrayOfbx != null) {
          ((ca)localObject1).setCreateTime(arrayOfbx[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcm != null) {
          ((ca)localObject1).setCreateTime(arrayOfcm[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(as paramas1, as paramas2, cyb paramcyb, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paramas1.field_username;
    String str1 = paramas1.field_encryptUsername;
    if ((paramas2 != null) && (!Util.nullAsNil(paramas2.hDr).equals(Util.nullAsNil(paramcyb.TGu))))
    {
      com.tencent.mm.bg.c.bnY();
      com.tencent.mm.bg.c.WQ(str2);
    }
    if (!Util.isNullOrNil(paramArrayOfByte))
    {
      if (as.asD(paramas1.field_verifyFlag)) {
        a(paramcyb, str2, paramas1, true);
      }
      if ((paramas2 == null) || (com.tencent.mm.contact.d.rk(paramas2.field_type)) || (!com.tencent.mm.contact.d.rk(paramas1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (ab.Qk(str2))) {
        com.tencent.mm.plugin.report.service.h.IzE.el(931, 22);
      }
      Object localObject1 = paramas1.field_username;
      if (paramcyb.TGv == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(Util.nullAsNil(Integer.valueOf(paramcyb.TGv.TSh.size()))))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(sgU) });
        if (sgU == -1) {
          sgU = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vSw, 0);
        }
        if (sgU != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((paramcyb.TGv == null) || (paramcyb.TGv.TSh == null)) {
          break label335;
        }
        paramArrayOfByte = paramcyb.TGv.TSh.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (dkz)paramArrayOfByte.next();
          if (((dkz)localObject1).TSg != null) {
            localStringBuffer.append(((dkz)localObject1).TSg).append("，");
          }
        }
        a(paramas1, paramcyb, true);
        break;
      }
      label335:
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramas1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paramas2 != null)
      {
        localObject1 = paramas2.hDw;
        paramArrayOfByte = com.tencent.mm.contact.a.a(paramas2, (String)localObject1);
      }
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        paramas2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        bh.beI();
        localObject3 = com.tencent.mm.model.c.bbM().aPj(str1);
        paramas2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((co)localObject3).field_conPhone;
          paramas2 = paramArrayOfByte;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            paramas2 = ((String)localObject1).split(",");
            localObject2 = localObject1;
          }
        }
      }
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramas1.field_username, Util.nullAsNil((String)localObject2) });
      int i;
      if ((paramas2 != null) && (paramas2.length > 0))
      {
        paramArrayOfByte = com.tencent.mm.contact.a.aq(localStringBuffer.toString(), "，");
        int i2 = paramas2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          localObject1 = paramas2[k];
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
                if (!Util.isEqual((String)localObject1, paramArrayOfByte[n]))
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
                if (aoI((String)localObject1))
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
          paramas2 = new cyv();
          paramas2.TGE = paramas1.field_username;
          paramArrayOfByte = new dla();
          localObject1 = com.tencent.mm.contact.a.aq(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.rVx = localObject1.length;
            paramArrayOfByte.TSh = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new dkz();
              ((dkz)localObject3).TSg = ((String)localObject2);
              paramArrayOfByte.TSh.add(localObject3);
              i += 1;
            }
            paramas2.TGv = paramArrayOfByte;
            bh.beI();
            com.tencent.mm.model.c.bbK().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(60, paramas2));
          }
        }
        if ((j != 0) && (15 == paramcyb.Cqs) && (!Util.isNullOrNil(paramas1.field_username)))
        {
          paramas2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(paramas1.field_username);
          if (paramas2 != null)
          {
            paramArrayOfByte = com.tencent.mm.contact.a.aq(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.h.IzE;
            localObject2 = paramas1.field_username;
            if (!Util.isNullOrNil(paramas2.getMd5())) {
              break label1291;
            }
            j = 0;
            if (paramArrayOfByte != null) {
              break label1297;
            }
            i = 0;
            ((com.tencent.mm.plugin.report.service.h)localObject1).a(12040, new Object[] { localObject2, Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramas1.field_username, localStringBuffer.toString() });
      paramas2 = localStringBuffer.toString();
      label998:
      paramas2 = Util.nullAs(paramas2, "");
      Log.i("MicroMsg.BigBallContactAssemblerImpl", paramas2);
      paramas1.IW(paramas2);
      if ((!ab.Lj(str2)) && (paramcyb.TcQ != null)) {
        v.a(str2, paramcyb.TcQ);
      }
      boolean bool1 = false;
      bh.beI();
      paramArrayOfByte = com.tencent.mm.model.c.bbM().aPj(paramas1.field_username);
      if (!Util.isNullOrNil(paramas1.field_conRemark))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramas1.hDq)) && (!paramas1.hDq.equals(paramArrayOfByte.field_conDescription))) {
          a(paramas1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramas1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          ab.P(paramas1);
        }
        paramas2 = null;
        bh.beI();
        paramArrayOfByte = com.tencent.mm.model.c.bbM().aPj(paramas1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramas2 = paramArrayOfByte.field_contactLabels;
        }
        paramcyb = paramas2;
        if (Util.isNullOrNil(paramas2))
        {
          bh.beI();
          localObject1 = com.tencent.mm.model.c.bbM().aPj(paramas1.field_username);
          paramcyb = paramas2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            paramcyb = ((co)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!Util.isNullOrNil(paramcyb))
        {
          com.tencent.mm.plugin.label.a.a.eLe().iF(paramas1.field_username, paramcyb);
          paramArrayOfByte.field_contactLabels = "";
          bh.beI();
          com.tencent.mm.model.c.bbM().replace(paramArrayOfByte);
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
        paramas2 = new StringBuffer();
        if ((paramcyb.TGv != null) && (paramcyb.TGv.TSh != null))
        {
          paramArrayOfByte = paramcyb.TGv.TSh.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (dkz)paramArrayOfByte.next();
            if (((dkz)localObject1).TSg != null) {
              paramas2.append(((dkz)localObject1).TSg).append("，");
            }
          }
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramas1.field_username, paramas2.toString() });
        paramas2 = paramas2.toString();
        break label998;
        if (paramArrayOfByte != null)
        {
          paramas2 = paramArrayOfByte;
          if (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
          paramas2 = paramArrayOfByte;
          if (!Util.isNullOrNil(str1))
          {
            bh.beI();
            paramas2 = com.tencent.mm.model.c.bbM().aPj(str1);
          }
        }
        paramBoolean = bool1;
        if (paramas2 != null)
        {
          paramBoolean = bool1;
          if (!Util.isNullOrNil(paramas2.field_encryptUsername))
          {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramas2.field_encryptUsername);
            paramas1.Ir(paramas2.field_conRemark);
            paramas1.Iw(com.tencent.mm.platformtools.f.ZJ(paramas2.field_conRemark));
            paramas1.Ix(com.tencent.mm.platformtools.f.ZK(paramas2.field_conRemark));
            paramBoolean = a(paramas1, paramas2);
          }
        }
        switch (paramas1.getSource())
        {
        }
      }
      paramas2 = null;
      if ((paramcyb != null) && (!Util.isNullOrNil(paramcyb.TGo)))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { paramcyb.TGo, paramcyb.TGp });
        paramArrayOfByte = com.tencent.mm.plugin.account.b.getAddrUploadStg();
        paramas2 = paramcyb.TGo;
        localObject1 = paramcyb.TGp;
        paramcyb = paramArrayOfByte.aaA(paramas2);
        paramas2 = paramcyb;
        if (paramcyb == null) {
          paramas2 = paramArrayOfByte.aaA((String)localObject1);
        }
        if (paramas2 != null) {
          break label1919;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramas2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (Util.isNullOrNil(paramas2.bxT())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramas2.bya()) {
          break;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramas2.bxT(), paramas2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramas2.username = paramas1.field_username;
        paramas2.status = 2;
        paramas2.bxZ();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramas1.Ir(paramas2.bxT());
          paramas1.Iw(com.tencent.mm.platformtools.f.ZJ(paramas2.bxT()));
          paramas1.Ix(com.tencent.mm.platformtools.f.ZK(paramas2.bxT()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.contact.d.rk(paramas1.field_type)) {
          break;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramas2.bxT(), paramas2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramas2.getMd5(), paramas2);
        bool1 = bool2;
        break;
        if (Util.isNullOrNil(str1)) {
          break label1694;
        }
        paramas2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(str1);
        break label1694;
        label1919:
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { Util.nullAsNil(paramas2.bxT()), Util.nullAsNil(paramas2.getUsername()), Boolean.valueOf(paramas2.bya()) });
      }
    }
  }
  
  public final void b(as paramas1, as paramas2, cyb paramcyb, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paramas1.field_username;
    Object localObject2 = paramas1.field_encryptUsername;
    Object localObject1;
    int i;
    Object localObject3;
    label138:
    label209:
    int k;
    label257:
    int m;
    Object localObject4;
    int n;
    int i1;
    if (ab.Lj(paramArrayOfByte))
    {
      if (paramcyb.TcQ != null)
      {
        localObject1 = paramcyb.TcQ.SjE;
        if (com.tencent.mm.bk.d.meW != null) {
          break label1925;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = paramcyb.TcQ.SjE;
          localObject3 = new yx();
          ((yx)localObject3).fYg.fYi = true;
          EventCenter.instance.publish((IEvent)localObject3);
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (ab.Lj(paramArrayOfByte)) && (!Util.isNullOrNil(((yx)localObject3).fYh.fYk)) && (paramArrayOfByte.equals(((yx)localObject3).fYh.fYk))) {
            break label2195;
          }
        }
        localObject1 = paramcyb.TcQ.SjE;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (xn)((Iterator)localObject1).next();
          } while ((Util.isNullOrNil(((xn)localObject3).UserName)) || (!((xn)localObject3).UserName.equals(z.bcZ())));
        }
        i = 0;
        if (i != 0)
        {
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.multitalk.model.d.class)).aPS(paramArrayOfByte);
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.live.a.class)).forceStopCurLive(MMApplicationContext.getContext());
        }
      }
      if (paramcyb.TcQ != null) {
        break label2344;
      }
      i = 0;
      localObject1 = paramcyb.TGj;
      localObject3 = paramcyb.TGi;
      k = paramcyb.TGt;
      m = paramcyb.TGs;
      localObject4 = paramcyb.CSe;
      n = paramcyb.TGr;
      i1 = paramcyb.TGw;
      if (paramcyb.TcQ != null) {
        break label2356;
      }
    }
    label1925:
    label2195:
    label2344:
    label2356:
    for (int j = -1;; j = paramcyb.TcQ.SjF)
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s chatroomVersion:%d chatroomInfoVersion:%s infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j) });
      if ((paramcyb.TcQ != null) && (paramcyb.TcQ.iWB != 0))
      {
        localObject1 = new com.tencent.mm.k.a.a.a();
        ((com.tencent.mm.k.a.a.a)localObject1).type = paramcyb.TGt;
        ((com.tencent.mm.k.a.a.a)localObject1).iWH = paramcyb.TGs;
        ((com.tencent.mm.k.a.a.a)localObject1).jmz = paramcyb.CSe;
        ((com.tencent.mm.k.a.a.a)localObject1).jmA = paramcyb.TGr;
        if (paramcyb.TcQ.SjF == 0) {
          ((com.tencent.mm.k.a.a.a)localObject1).fMC = paramcyb.TGr;
        }
        localObject3 = new nx();
        ((nx)localObject3).fMB.chatroomName = paramArrayOfByte;
        ((nx)localObject3).fMB.fMC = ((com.tencent.mm.k.a.a.a)localObject1).fMC;
        v.a(paramArrayOfByte, paramcyb.TGi, paramcyb.TcQ, paramcyb.TGx, paramcyb.TGw, z.bcZ(), (com.tencent.mm.k.a.a.a)localObject1, (IEvent)localObject3);
      }
      try
      {
        bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bbR().aaL(paramArrayOfByte);
        bool2 = v.Px(paramArrayOfByte);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((bool1) && (bool2))
        {
          localObject1 = new jz();
          ((jz)localObject1).fHo.fHp = paramArrayOfByte;
          EventCenter.instance.publish((IEvent)localObject1);
          v.az(paramArrayOfByte, paramcyb.TGt);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool1;
          boolean bool2;
          long l;
          Log.e("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s, exception:%s %s", new Object[] { paramArrayOfByte, localException.getClass().getSimpleName(), localException.getMessage() });
          continue;
          if ((paramas1.hxX()) && (com.tencent.mm.ao.g.Uz(paramas1.field_username)) && (paramas1 != null) && (paramas1.hxX()) && (com.tencent.mm.ao.g.Uz(paramas1.field_username)))
          {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramas1.field_username);
            bh.beI();
            az localaz = com.tencent.mm.model.c.bbR().bwx(paramas1.field_username);
            af.bjv().Uo(paramas1.field_username);
            if (localaz == null)
            {
              bh.beI();
              if (com.tencent.mm.model.c.bbR().bwx("officialaccounts") == null)
              {
                localaz = new az("officialaccounts");
                localaz.hyE();
                bh.beI();
                com.tencent.mm.model.c.bbR().e(localaz);
              }
              localaz = new az(paramas1.field_username);
              localaz.Jc("officialaccounts");
              bh.beI();
              com.tencent.mm.model.c.bbR().e(localaz);
              continue;
              if (((paramas2 == null) || ((paramas2.field_type & 0x800) != (paramas1.field_type & 0x800))) && (com.tencent.mm.ao.g.UB(paramas1.field_username)) && (!com.tencent.mm.ao.g.KI(paramas1.field_username)))
              {
                Y(paramas1);
                continue;
                Log.i("MicroMsg.BigBallContactAssemblerImpl", "update stranger ok, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramcyb.Tad });
                continue;
                if (com.tencent.mm.ao.g.UE(paramas1.field_username))
                {
                  bh.beI();
                  if (com.tencent.mm.model.c.bbR().bwx(paramas1.field_username) == null)
                  {
                    paramArrayOfByte = af.bjv().Uo(paramas1.field_username);
                    localaz = new az(paramas1.field_username);
                    Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.Zf(), paramas1.field_username });
                    localaz.Jc(Util.nullAsNil(paramArrayOfByte.Zf()));
                    localaz.hyE();
                    bh.beI();
                    com.tencent.mm.model.c.bbR().e(localaz);
                    continue;
                    if ((paramas2 == null) || ((paramas2.field_type & 0x8) != (paramas1.field_type & 0x8)))
                    {
                      bh.beI();
                      com.tencent.mm.model.c.bbR().c(new String[] { paramas1.field_username }, "");
                      continue;
                      paramas2.hyE();
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
      if ((!com.tencent.mm.contact.d.rk(paramas1.field_type)) && (!paramas1.aya()) && (!as.PY(paramas1.field_username)) && (!ab.Lj(paramas1.field_username)) && (!as.aEF(paramas1.field_username)))
      {
        Log.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramas1.field_username, Integer.valueOf(paramas1.field_type) });
        bh.beI();
        com.tencent.mm.model.c.bbR().bwv(paramas1.field_username);
      }
      if ((paramas1.field_type & 0x800) == 0) {
        break label2595;
      }
      if ((paramas2 == null) || ((paramas2.field_type & 0x800) != (paramas1.field_type & 0x800)))
      {
        if ((!com.tencent.mm.ao.g.UB(paramas1.field_username)) || (com.tencent.mm.ao.g.KI(paramas1.field_username))) {
          break label2409;
        }
        Y(paramas1);
      }
      if ((paramas2 == null) || (com.tencent.mm.contact.d.rk(paramas2.field_type)) || (!com.tencent.mm.contact.d.rk(paramas1.field_type))) {
        break label2848;
      }
      bool1 = true;
      if (com.tencent.mm.contact.d.rk(paramas1.field_type))
      {
        bh.beI();
        localObject1 = com.tencent.mm.model.c.bbM().aPj(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!Util.isNullOrNil(((co)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            bh.beI();
            paramArrayOfByte = com.tencent.mm.model.c.bbM().aPj((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          bh.beI();
          com.tencent.mm.model.c.bbM().aPk(paramArrayOfByte.field_encryptUsername);
        }
      }
      if ((com.tencent.mm.contact.d.rk(paramas1.field_type)) && (!Util.isNullOrNil(paramcyb.Tad)))
      {
        bh.beI();
        paramArrayOfByte = com.tencent.mm.model.c.bbN().aOy(paramcyb.SrH.Ufy);
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          paramArrayOfByte.field_username = paramcyb.Tad;
          paramArrayOfByte.field_modifyTime = System.currentTimeMillis();
          bh.beI();
          if (com.tencent.mm.model.c.bbN().replace(paramArrayOfByte)) {
            break label2645;
          }
          Log.e("MicroMsg.BigBallContactAssemblerImpl", "update stranger fail, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramcyb.Tad });
        }
      }
      if (com.tencent.mm.ao.g.UA(paramas1.field_username))
      {
        af.bjF();
        e.a(paramas1.field_username, null);
        if ((bool1) && (com.tencent.mm.ao.g.UB(paramas1.field_username)))
        {
          if (!com.tencent.mm.ao.g.KI(paramas1.field_username)) {
            break label2675;
          }
          af.bjE();
          com.tencent.mm.ao.a.h.a(paramas1.field_username, null);
        }
      }
      if ((paramas1.field_type & 0x8) == 0) {
        break label2791;
      }
      if ((paramas2 == null) || ((paramas2.field_type & 0x8) != (paramas1.field_type & 0x8)))
      {
        bh.beI();
        com.tencent.mm.model.c.bbR().c(new String[] { paramas1.field_username }, "@blacklist");
      }
      if (!paramBoolean)
      {
        if ((paramas1 != null) && (paramas1.hxX()) && (com.tencent.mm.contact.d.rk(paramas1.field_type)))
        {
          l = System.currentTimeMillis();
          bh.beI();
          paramArrayOfByte = com.tencent.mm.model.c.bbR().bwx(paramas1.field_username);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.rp(4194304)))
          {
            bh.beI();
            bool2 = com.tencent.mm.model.c.bbR().a(paramas1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramas1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
        if ((paramas2 != null) && ((int)paramas2.jxt > 0) && (paramas2.hDo != 0) && (paramas2.hDp == 0) && (paramas1.hDp == 1))
        {
          Log.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramas1.field_username });
          bh.beI();
          com.tencent.mm.model.c.bbR().bwN(paramas1.field_username);
          bh.beI();
          paramas2 = com.tencent.mm.model.c.bbR().bwx("officialaccounts");
          if (paramas2 != null)
          {
            bh.beI();
            paramas2.pH(com.tencent.mm.model.c.bbR().hyL());
            Log.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramas2.field_unReadCount) });
            bh.beI();
            paramArrayOfByte = com.tencent.mm.model.c.bbR().bwJ("officialaccounts");
            bh.beI();
            paramArrayOfByte = com.tencent.mm.model.c.bbO().aOH(paramArrayOfByte);
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
              break label2841;
            }
            paramas2.bq(paramArrayOfByte);
            paramas2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
            paramas2.IZ(Integer.toString(paramArrayOfByte.getType()));
            bh.beI();
            localObject1 = com.tencent.mm.model.c.bbR().abK();
            if (localObject1 != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              localObject4 = new PInt();
              paramArrayOfByte.Jm("officialaccounts");
              paramArrayOfByte.setContent(paramas2.field_content);
              ((bw.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
              paramas2.Ja(((PString)localObject2).value);
              paramas2.Jb(((PString)localObject3).value);
              paramas2.pK(((PInt)localObject4).value);
            }
            bh.beI();
            com.tencent.mm.model.c.bbR().a(paramas2, paramas2.field_username);
          }
        }
      }
      if (bool1)
      {
        paramas2 = new ng();
        paramas2.fLB.username = paramas1.field_username;
        paramas2.fLB.fLC = paramas1.fLC;
        EventCenter.instance.publish(paramas2);
      }
      if ((bool1) && (paramcyb.Cqs == 18))
      {
        paramas2 = new mj();
        paramas2.fKt.fKu = paramas1.field_encryptUsername;
        paramas2.fKt.type = 2;
        com.tencent.mm.bl.d.bqd().aOA(paramas2.fKt.fKu);
        EventCenter.instance.publish(paramas2);
      }
      if (bool1) {
        cX(paramas1.field_username, paramcyb.Cqs);
      }
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramas1.ayj()), Boolean.valueOf(paramBoolean) });
      if ((!paramBoolean) && (bool1) && (paramas1.ayj()))
      {
        paramas2 = paramas1.field_username;
        if (!p.JPf.aUR(paramas2))
        {
          paramas2 = new LinkedList();
          paramas2.add(paramas1.field_username);
          paramas1 = new qp();
          paramas1.fPl.list = paramas2;
          paramas1.fPl.fCN = 1;
          paramas1.fPl.fPm = 5L;
          paramas1.fPl.fEF = true;
          EventCenter.instance.publish(paramas1);
        }
      }
      com.tencent.mm.plugin.label.a.a.eLe().aPn();
      AppMethodBeat.o(22336);
      return;
      localObject3 = com.tencent.mm.bk.d.meW.bqa();
      if ((Util.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!ab.Lj(paramArrayOfByte)))
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
            localObject3 = (xn)((Iterator)localObject1).next();
            if ((!Util.isNullOrNil(((xn)localObject3).UserName)) && (((xn)localObject3).UserName.equals(z.bcZ())))
            {
              i = 0;
              break;
            }
          }
        }
      }
      if (com.tencent.mm.bk.d.meV != null)
      {
        if (com.tencent.mm.bk.d.meV.bE(paramArrayOfByte, z.bcZ()))
        {
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
          localObject1 = new zg();
          ((zg)localObject1).fYD.userName = paramArrayOfByte;
          EventCenter.instance.publish((IEvent)localObject1);
        }
        com.tencent.mm.bk.d.meV.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
      }
      if ((com.tencent.mm.bk.d.meW != null) && (!Util.isNullOrNil(com.tencent.mm.bk.d.meV.bpZ())))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bk.d.meW.bqa() });
        localObject1 = new fv();
        ((fv)localObject1).fBE.username = com.tencent.mm.bk.d.meW.bqa();
        EventCenter.instance.publish((IEvent)localObject1);
      }
      i = 1;
      break;
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2257;
          }
          localObject3 = (xn)((Iterator)localObject1).next();
          if (!Util.isNullOrNil(((xn)localObject3).UserName)) {
            if (((xn)localObject3).UserName.equals(z.bcZ())) {
              break;
            }
          }
        }
      }
      label2257:
      if (com.tencent.mm.bj.g.meT != null) {
        com.tencent.mm.bj.g.meT.a(paramArrayOfByte, null, "", "", 0);
      }
      localObject1 = new yx();
      ((yx)localObject1).fYg.fYj = true;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = new yw();
      ((yw)localObject1).fYe.fYf = true;
      EventCenter.instance.publish((IEvent)localObject1);
      break label138;
      i = 1;
      break label209;
      i = paramcyb.TcQ.iWB;
      break label257;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(22343);
    Log.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramq.getType() != 681)
    {
      AppMethodBeat.o(22343);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(22343);
      return;
    }
    if (!com.tencent.mm.kernel.h.aHE().kbT)
    {
      Log.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    com.tencent.e.h.ZvG.bf(new c.1(this, paramq));
    AppMethodBeat.o(22343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
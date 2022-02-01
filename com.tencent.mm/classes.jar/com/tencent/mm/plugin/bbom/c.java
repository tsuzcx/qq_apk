package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.jj;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.ls.a;
import com.tencent.mm.g.a.mp;
import com.tencent.mm.g.a.nf;
import com.tencent.mm.g.a.pr;
import com.tencent.mm.g.a.xp;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.g.a.xq.b;
import com.tencent.mm.g.a.xz;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.bb;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.v;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.n;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aeq;
import com.tencent.mm.protocal.protobuf.cpl;
import com.tencent.mm.protocal.protobuf.cpo;
import com.tencent.mm.protocal.protobuf.cqe;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dbl;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.protocal.protobuf.xg;
import com.tencent.mm.protocal.protobuf.xh;
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
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.cm;
import com.tencent.mm.storage.cn;
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
  implements com.tencent.mm.ak.i, com.tencent.mm.plugin.messenger.foundation.a.d
{
  private static int peQ = -1;
  
  private static void R(as paramas)
  {
    AppMethodBeat.i(22341);
    if ((paramas != null) && (com.tencent.mm.al.g.Nf(paramas.field_username)) && (!com.tencent.mm.al.g.DQ(paramas.field_username)))
    {
      bg.aVF();
      az localaz = com.tencent.mm.model.c.aST().bjY(paramas.field_username);
      paramas = ag.bah().MT(paramas.field_username);
      if (!com.tencent.mm.al.g.Ni(paramas.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localaz == null)
      {
        localaz = new az(paramas.field_username);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramas.UN(), paramas.field_username });
        localaz.Co(Util.nullAsNil(paramas.UN()));
        localaz.gCr();
        bg.aVF();
        com.tencent.mm.model.c.aST().e(localaz);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  private static void a(cpl paramcpl, String paramString, as paramas, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = com.tencent.mm.model.z.aTY();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = ag.bah().MT(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = paramcpl.kei;
      paramcpl = paramcpl.MmR;
      if (paramcpl != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = paramcpl.kem;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = paramcpl.keo;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramcpl.kep;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = paramcpl.ken;
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!Util.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).cG(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).cG(false) != null) && (((com.tencent.mm.api.c)localObject).cG(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).cG(false).Vh() != null) && (!Util.isNullOrNil(((com.tencent.mm.api.c)localObject).UN())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).UN();
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!ag.bah().h((com.tencent.mm.api.c)localObject)) {
        ag.bah().g((com.tencent.mm.api.c)localObject);
      }
      paramas.np(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  public static boolean a(as paramas, cpl paramcpl, boolean paramBoolean)
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
    Object localObject2 = com.tencent.mm.aj.c.a(str, paramcpl);
    p.aYB().b((com.tencent.mm.aj.i)localObject2);
    localObject2 = paramcpl.MmQ;
    if ((!paramas.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((ebj)localObject2).kej + " " + paramcpl.Lqk);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((ebj)localObject2).kek);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((ebj)localObject2).kel);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((ebj)localObject2).Nbc);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((ebj)localObject2).Nbd);
      if (o.DCN != null) {
        o.DCN.a(paramas.field_username, (ebj)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.contact.c.oR(paramas.field_type))
    {
      bool = com.tencent.mm.bj.d.bgN().gP(str, 1);
      if (!bool) {
        break label428;
      }
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.contact.c.oR(paramas.field_type)) && ((paramas.getSource() == 10) || (paramas.getSource() == 13)))
      {
        t.l(MMApplicationContext.getContext(), paramas.field_username, paramas.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramas.field_encryptUsername);
        if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).kdX)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramas.field_username;
          Log.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).kdX, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(paramcpl, str, paramas, paramBoolean);
      AppMethodBeat.o(22338);
      return true;
      label428:
      bool = com.tencent.mm.bj.d.bgN().gP((String)localObject1, 1);
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(as paramas, cn paramcn)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramcn.field_conDescription)) {
      paramas.Cc(paramcn.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!ab.IR(paramas.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.contact.c.oR(paramas.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!Util.isNullOrNil(paramcn.field_conDescription))
        {
          cpo localcpo = new cpo();
          localcpo.MvG = paramas.field_username;
          localcpo.Desc = paramcn.field_conDescription;
          bg.aVF();
          com.tencent.mm.model.c.aSM().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(54, localcpo));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  public static boolean ahc(String paramString)
  {
    AppMethodBeat.i(22339);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = com.tencent.mm.pluginsdk.ui.span.k.a.KqT.matcher(paramString);
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
  
  private static void cC(String paramString, int paramInt)
  {
    AppMethodBeat.i(22342);
    bx[] arrayOfbx = null;
    cl[] arrayOfcl;
    Object localObject1;
    bn[] arrayOfbn;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfcl = com.tencent.mm.bj.d.bgP().bkW(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfcl);
      arrayOfbn = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(22342);
      return;
      if (paramInt == 18)
      {
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbx = com.tencent.mm.bj.d.bgO().bkx(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfbx);
        arrayOfcl = null;
        arrayOfbn = null;
      }
      else
      {
        arrayOfbn = com.tencent.mm.bj.d.bgM().bku(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfbn);
        arrayOfcl = null;
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
      localca.setContent(localObject2.iAq);
      m = ab.JG(localObject2.username);
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
      localca.Cy(localObject2.username);
      localca.setType(m);
      label252:
      long l;
      if (localObject2.ehd)
      {
        localca.setStatus(2);
        localca.nv(1);
        bg.aVF();
        l = com.tencent.mm.model.c.aSQ().aC(localca);
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
        if (arrayOfcl == null) {
          break label533;
        }
        j = paramInt + 1;
        localca.setCreateTime(arrayOfcl[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localca.setStatus(6);
        localca.nv(0);
        break label252;
      }
      localObject1 = new ca();
      if (arrayOfbn != null) {
        ((ca)localObject1).setCreateTime(arrayOfbn[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((ca)localObject1).Cy(paramString);
        ((ca)localObject1).setContent(MMApplicationContext.getContext().getString(2131766882));
        ((ca)localObject1).setType(10000);
        ((ca)localObject1).setStatus(6);
        ((ca)localObject1).nv(0);
        bg.aVF();
        com.tencent.mm.model.c.aSQ().aC((ca)localObject1);
        AppMethodBeat.o(22342);
        return;
        if (arrayOfbx != null) {
          ((ca)localObject1).setCreateTime(arrayOfbx[0].field_createtime * 1000L + 1L);
        } else if (arrayOfcl != null) {
          ((ca)localObject1).setCreateTime(arrayOfcl[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(as paramas1, as paramas2, cpl paramcpl, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paramas1.field_username;
    String str1 = paramas1.field_encryptUsername;
    if ((paramas2 != null) && (!Util.nullAsNil(paramas2.fuS).equals(Util.nullAsNil(paramcpl.Mvw))))
    {
      com.tencent.mm.bd.c.bez();
      com.tencent.mm.bd.c.Pt(str2);
    }
    if (!Util.isNullOrNil(paramArrayOfByte))
    {
      if (as.akh(paramas1.field_verifyFlag)) {
        a(paramcpl, str2, paramas1, true);
      }
      if ((paramas2 == null) || (com.tencent.mm.contact.c.oR(paramas2.field_type)) || (!com.tencent.mm.contact.c.oR(paramas1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (ab.IR(str2))) {
        com.tencent.mm.plugin.report.service.h.CyF.dN(931, 22);
      }
      Object localObject1 = paramas1.field_username;
      if (paramcpl.Mvx == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(Util.nullAsNil(Integer.valueOf(paramcpl.Mvx.MGv.size()))))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(peQ) });
        if (peQ == -1) {
          peQ = ((com.tencent.mm.plugin.expt.b.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.siy, 0);
        }
        if (peQ != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((paramcpl.Mvx == null) || (paramcpl.Mvx.MGv == null)) {
          break label335;
        }
        paramArrayOfByte = paramcpl.Mvx.MGv.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (dbk)paramArrayOfByte.next();
          if (((dbk)localObject1).MGu != null) {
            localStringBuffer.append(((dbk)localObject1).MGu).append("，");
          }
        }
        a(paramas1, paramcpl, true);
        break;
      }
      label335:
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramas1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paramas2 != null)
      {
        localObject1 = paramas2.fuX;
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
        bg.aVF();
        localObject3 = com.tencent.mm.model.c.aSO().aEZ(str1);
        paramas2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((cn)localObject3).field_conPhone;
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
        paramArrayOfByte = com.tencent.mm.contact.a.al(localStringBuffer.toString(), "，");
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
                if (ahc((String)localObject1))
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
          paramas2 = new cqe();
          paramas2.MvG = paramas1.field_username;
          paramArrayOfByte = new dbl();
          localObject1 = com.tencent.mm.contact.a.al(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.oTz = localObject1.length;
            paramArrayOfByte.MGv = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new dbk();
              ((dbk)localObject3).MGu = ((String)localObject2);
              paramArrayOfByte.MGv.add(localObject3);
              i += 1;
            }
            paramas2.Mvx = paramArrayOfByte;
            bg.aVF();
            com.tencent.mm.model.c.aSM().d(new com.tencent.mm.plugin.messenger.foundation.a.a.k.a(60, paramas2));
          }
        }
        if ((j != 0) && (15 == paramcpl.xub) && (!Util.isNullOrNil(paramas1.field_username)))
        {
          paramas2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(paramas1.field_username);
          if (paramas2 != null)
          {
            paramArrayOfByte = com.tencent.mm.contact.a.al(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.h.CyF;
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
      paramas1.Ci(paramas2);
      if ((!ab.Eq(str2)) && (paramcpl.LUi != null)) {
        v.a(str2, paramcpl.LUi);
      }
      boolean bool1 = false;
      bg.aVF();
      paramArrayOfByte = com.tencent.mm.model.c.aSO().aEZ(paramas1.field_username);
      if (!Util.isNullOrNil(paramas1.field_conRemark))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramas1.fuR)) && (!paramas1.fuR.equals(paramArrayOfByte.field_conDescription))) {
          a(paramas1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramas1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          ab.I(paramas1);
        }
        paramas2 = null;
        bg.aVF();
        paramArrayOfByte = com.tencent.mm.model.c.aSO().aEZ(paramas1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramas2 = paramArrayOfByte.field_contactLabels;
        }
        paramcpl = paramas2;
        if (Util.isNullOrNil(paramas2))
        {
          bg.aVF();
          localObject1 = com.tencent.mm.model.c.aSO().aEZ(paramas1.field_username);
          paramcpl = paramas2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            paramcpl = ((cn)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!Util.isNullOrNil(paramcpl))
        {
          com.tencent.mm.plugin.label.a.a.ecg().is(paramas1.field_username, paramcpl);
          paramArrayOfByte.field_contactLabels = "";
          bg.aVF();
          com.tencent.mm.model.c.aSO().replace(paramArrayOfByte);
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
        if ((paramcpl.Mvx != null) && (paramcpl.Mvx.MGv != null))
        {
          paramArrayOfByte = paramcpl.Mvx.MGv.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (dbk)paramArrayOfByte.next();
            if (((dbk)localObject1).MGu != null) {
              paramas2.append(((dbk)localObject1).MGu).append("，");
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
            bg.aVF();
            paramas2 = com.tencent.mm.model.c.aSO().aEZ(str1);
          }
        }
        paramBoolean = bool1;
        if (paramas2 != null)
        {
          paramBoolean = bool1;
          if (!Util.isNullOrNil(paramas2.field_encryptUsername))
          {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramas2.field_encryptUsername);
            paramas1.BD(paramas2.field_conRemark);
            paramas1.BI(com.tencent.mm.platformtools.f.Sh(paramas2.field_conRemark));
            paramas1.BJ(com.tencent.mm.platformtools.f.Si(paramas2.field_conRemark));
            paramBoolean = a(paramas1, paramas2);
          }
        }
        switch (paramas1.getSource())
        {
        }
      }
      paramas2 = null;
      if ((paramcpl != null) && (!Util.isNullOrNil(paramcpl.Mvq)))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { paramcpl.Mvq, paramcpl.Mvr });
        paramArrayOfByte = com.tencent.mm.plugin.account.a.getAddrUploadStg();
        paramas2 = paramcpl.Mvq;
        localObject1 = paramcpl.Mvr;
        paramcpl = paramArrayOfByte.SU(paramas2);
        paramas2 = paramcpl;
        if (paramcpl == null) {
          paramas2 = paramArrayOfByte.SU((String)localObject1);
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
        if (Util.isNullOrNil(paramas2.bnK())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramas2.bnR()) {
          break;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramas2.bnK(), paramas2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramas2.username = paramas1.field_username;
        paramas2.status = 2;
        paramas2.bnQ();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramas1.BD(paramas2.bnK());
          paramas1.BI(com.tencent.mm.platformtools.f.Sh(paramas2.bnK()));
          paramas1.BJ(com.tencent.mm.platformtools.f.Si(paramas2.bnK()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.contact.c.oR(paramas1.field_type)) {
          break;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramas2.bnK(), paramas2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramas2.getMd5(), paramas2);
        bool1 = bool2;
        break;
        if (Util.isNullOrNil(str1)) {
          break label1694;
        }
        paramas2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().SR(str1);
        break label1694;
        label1919:
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { Util.nullAsNil(paramas2.bnK()), Util.nullAsNil(paramas2.getUsername()), Boolean.valueOf(paramas2.bnR()) });
      }
    }
  }
  
  public final void b(as paramas1, as paramas2, cpl paramcpl, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paramas1.field_username;
    Object localObject2 = paramas1.field_encryptUsername;
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
    if (ab.Eq(paramArrayOfByte))
    {
      if (paramcpl.LUi != null)
      {
        localObject1 = paramcpl.LUi.Lin;
        if (com.tencent.mm.bi.d.jpB != null) {
          break label2001;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = paramcpl.LUi.Lin;
          localObject3 = new xq();
          ((xq)localObject3).edR.edT = true;
          EventCenter.instance.publish((IEvent)localObject3);
          if ((!Util.isNullOrNil(paramArrayOfByte)) && (ab.Eq(paramArrayOfByte)) && (!Util.isNullOrNil(((xq)localObject3).edS.edV)) && (paramArrayOfByte.equals(((xq)localObject3).edS.edV))) {
            break label2271;
          }
        }
        localObject1 = paramcpl.LUi.Lin;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (xh)((Iterator)localObject1).next();
          } while ((Util.isNullOrNil(((xh)localObject3).UserName)) || (!((xh)localObject3).UserName.equals(com.tencent.mm.model.z.aTY())));
        }
        i = 0;
        if (i != 0)
        {
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.multitalk.model.d.class)).aFG(paramArrayOfByte);
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.live.a.class)).forceStopCurLive(MMApplicationContext.getContext());
        }
      }
      if (paramcpl.LUi != null) {
        break label2420;
      }
      i = 0;
      localObject1 = paramcpl.Mvl;
      localObject3 = paramcpl.Mvk;
      k = paramcpl.Mvv;
      m = paramcpl.Mvu;
      localObject4 = paramcpl.xNU;
      n = paramcpl.Mvt;
      i1 = paramcpl.Mvy;
      if (paramcpl.LUi != null) {
        break label2432;
      }
    }
    label2432:
    for (int j = -1;; j = paramcpl.LUi.Lio)
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s chatroomVersion:%d chatroomInfoVersion:%s infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j) });
      if ((paramcpl.LUi != null) && (paramcpl.LUi.gsq != 0))
      {
        localObject1 = new com.tencent.mm.k.a.a.a();
        ((com.tencent.mm.k.a.a.a)localObject1).type = paramcpl.Mvv;
        ((com.tencent.mm.k.a.a.a)localObject1).maxCount = paramcpl.Mvu;
        ((com.tencent.mm.k.a.a.a)localObject1).gCt = paramcpl.xNU;
        ((com.tencent.mm.k.a.a.a)localObject1).gCu = paramcpl.Mvt;
        if (paramcpl.LUi.Lio == 0) {
          ((com.tencent.mm.k.a.a.a)localObject1).dTg = paramcpl.Mvt;
        }
        localObject3 = new nf();
        ((nf)localObject3).dTf.chatroomName = paramArrayOfByte;
        ((nf)localObject3).dTf.dTg = ((com.tencent.mm.k.a.a.a)localObject1).dTg;
        v.a(paramArrayOfByte, paramcpl.Mvk, paramcpl.LUi, paramcpl.Mvz, paramcpl.Mvy, com.tencent.mm.model.z.aTY(), (com.tencent.mm.k.a.a.a)localObject1, (IEvent)localObject3);
      }
      try
      {
        bool1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().Tf(paramArrayOfByte);
        bool2 = v.Ih(paramArrayOfByte);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((bool1) && (bool2))
        {
          localObject1 = new jj();
          ((jj)localObject1).dOd.dOe = paramArrayOfByte;
          EventCenter.instance.publish((IEvent)localObject1);
          v.ah(paramArrayOfByte, paramcpl.Mvv);
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
          if ((paramas1.gBM()) && (com.tencent.mm.al.g.Nd(paramas1.field_username)) && (paramas1 != null) && (paramas1.gBM()) && (com.tencent.mm.al.g.Nd(paramas1.field_username)))
          {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramas1.field_username);
            bg.aVF();
            az localaz = com.tencent.mm.model.c.aST().bjY(paramas1.field_username);
            ag.bah().MT(paramas1.field_username);
            if (localaz == null)
            {
              bg.aVF();
              if (com.tencent.mm.model.c.aST().bjY("officialaccounts") == null)
              {
                localaz = new az("officialaccounts");
                localaz.gCr();
                bg.aVF();
                com.tencent.mm.model.c.aST().e(localaz);
              }
              localaz = new az(paramas1.field_username);
              localaz.Co("officialaccounts");
              bg.aVF();
              com.tencent.mm.model.c.aST().e(localaz);
              continue;
              if (((paramas2 == null) || ((paramas2.field_type & 0x800) != (paramas1.field_type & 0x800))) && (com.tencent.mm.al.g.Nf(paramas1.field_username)) && (!com.tencent.mm.al.g.DQ(paramas1.field_username)))
              {
                R(paramas1);
                continue;
                Log.i("MicroMsg.BigBallContactAssemblerImpl", "update stranger ok, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramcpl.LRy });
                continue;
                if (com.tencent.mm.al.g.Ni(paramas1.field_username))
                {
                  bg.aVF();
                  if (com.tencent.mm.model.c.aST().bjY(paramas1.field_username) == null)
                  {
                    paramArrayOfByte = ag.bah().MT(paramas1.field_username);
                    localaz = new az(paramas1.field_username);
                    Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.UN(), paramas1.field_username });
                    localaz.Co(Util.nullAsNil(paramArrayOfByte.UN()));
                    localaz.gCr();
                    bg.aVF();
                    com.tencent.mm.model.c.aST().e(localaz);
                    continue;
                    i = 0;
                    continue;
                    if ((paramas2 == null) || ((paramas2.field_type & 0x8) != (paramas1.field_type & 0x8)))
                    {
                      bg.aVF();
                      com.tencent.mm.model.c.aST().c(new String[] { paramas1.field_username }, "");
                      continue;
                      paramas2.gCr();
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
      if ((!com.tencent.mm.contact.c.oR(paramas1.field_type)) && (!paramas1.arw()) && (!as.IG(paramas1.field_username)) && (!ab.Eq(paramas1.field_username)) && (!as.avl(paramas1.field_username)))
      {
        Log.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramas1.field_username, Integer.valueOf(paramas1.field_type) });
        bg.aVF();
        com.tencent.mm.model.c.aST().bjW(paramas1.field_username);
      }
      if ((paramas1.field_type & 0x800) == 0) {
        break label2671;
      }
      if ((paramas2 == null) || ((paramas2.field_type & 0x800) != (paramas1.field_type & 0x800)))
      {
        if ((!com.tencent.mm.al.g.Nf(paramas1.field_username)) || (com.tencent.mm.al.g.DQ(paramas1.field_username))) {
          break label2485;
        }
        R(paramas1);
      }
      if ((paramas2 == null) || (com.tencent.mm.contact.c.oR(paramas2.field_type)) || (!com.tencent.mm.contact.c.oR(paramas1.field_type))) {
        break label2930;
      }
      bool1 = true;
      if (com.tencent.mm.contact.c.oR(paramas1.field_type))
      {
        bg.aVF();
        localObject1 = com.tencent.mm.model.c.aSO().aEZ(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!Util.isNullOrNil(((cn)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!Util.isNullOrNil((String)localObject2))
          {
            bg.aVF();
            paramArrayOfByte = com.tencent.mm.model.c.aSO().aEZ((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          bg.aVF();
          com.tencent.mm.model.c.aSO().aFa(paramArrayOfByte.field_encryptUsername);
        }
      }
      if ((com.tencent.mm.contact.c.oR(paramas1.field_type)) && (!Util.isNullOrNil(paramcpl.LRy)))
      {
        bg.aVF();
        paramArrayOfByte = com.tencent.mm.model.c.aSP().aEo(paramcpl.Lqk.MTo);
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          paramArrayOfByte.field_username = paramcpl.LRy;
          paramArrayOfByte.field_modifyTime = System.currentTimeMillis();
          bg.aVF();
          if (com.tencent.mm.model.c.aSP().replace(paramArrayOfByte)) {
            break label2721;
          }
          Log.e("MicroMsg.BigBallContactAssemblerImpl", "update stranger fail, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramcpl.LRy });
        }
      }
      if (com.tencent.mm.al.g.Ne(paramas1.field_username))
      {
        ag.bar();
        e.a(paramas1.field_username, null);
        if ((bool1) && (com.tencent.mm.al.g.Nf(paramas1.field_username)))
        {
          if (!com.tencent.mm.al.g.DQ(paramas1.field_username)) {
            break label2751;
          }
          ag.baq();
          com.tencent.mm.al.a.h.a(paramas1.field_username, null);
        }
      }
      paramArrayOfByte = com.tencent.mm.al.g.fJ(paramas1.field_username);
      if (paramArrayOfByte == null) {
        break label2867;
      }
      paramArrayOfByte = paramArrayOfByte.cG(false);
      if (paramArrayOfByte == null) {
        break label2867;
      }
      i = 0;
      if (paramArrayOfByte.dhz != null) {
        i = paramArrayOfByte.dhz.optInt("WXAppType", 0);
      }
      if (i == 0) {
        break label2867;
      }
      i = 1;
      if (i != 0)
      {
        ag.bau();
        com.tencent.mm.al.a.MK(paramas1.field_username);
      }
      if ((paramas1.field_type & 0x8) == 0) {
        break label2873;
      }
      if ((paramas2 == null) || ((paramas2.field_type & 0x8) != (paramas1.field_type & 0x8)))
      {
        bg.aVF();
        com.tencent.mm.model.c.aST().c(new String[] { paramas1.field_username }, "@blacklist");
      }
      if (!paramBoolean)
      {
        if ((paramas1 != null) && (paramas1.gBM()) && (com.tencent.mm.contact.c.oR(paramas1.field_type)))
        {
          l = System.currentTimeMillis();
          bg.aVF();
          paramArrayOfByte = com.tencent.mm.model.c.aST().bjY(paramas1.field_username);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.oV(4194304)))
          {
            bg.aVF();
            bool2 = com.tencent.mm.model.c.aST().a(paramas1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramas1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
        if ((paramas2 != null) && ((int)paramas2.gMZ > 0) && (paramas2.fuP != 0) && (paramas2.fuQ == 0) && (paramas1.fuQ == 1))
        {
          Log.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramas1.field_username });
          bg.aVF();
          com.tencent.mm.model.c.aST().bko(paramas1.field_username);
          bg.aVF();
          paramas2 = com.tencent.mm.model.c.aST().bjY("officialaccounts");
          if (paramas2 != null)
          {
            bg.aVF();
            paramas2.nt(com.tencent.mm.model.c.aST().gCy());
            Log.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramas2.field_unReadCount) });
            bg.aVF();
            paramArrayOfByte = com.tencent.mm.model.c.aST().bkl("officialaccounts");
            bg.aVF();
            paramArrayOfByte = com.tencent.mm.model.c.aSQ().aEx(paramArrayOfByte);
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
              break label2923;
            }
            paramas2.aX(paramArrayOfByte);
            paramas2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
            paramas2.Cl(Integer.toString(paramArrayOfByte.getType()));
            bg.aVF();
            localObject1 = com.tencent.mm.model.c.aST().Xh();
            if (localObject1 != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              localObject4 = new PInt();
              paramArrayOfByte.Cy("officialaccounts");
              paramArrayOfByte.setContent(paramas2.field_content);
              ((bw.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
              paramas2.Cm(((PString)localObject2).value);
              paramas2.Cn(((PString)localObject3).value);
              paramas2.nw(((PInt)localObject4).value);
            }
            bg.aVF();
            com.tencent.mm.model.c.aST().a(paramas2, paramas2.field_username);
          }
        }
      }
      if (bool1)
      {
        paramas2 = new mp();
        paramas2.dSe.username = paramas1.field_username;
        paramas2.dSe.dSf = paramas1.dSf;
        EventCenter.instance.publish(paramas2);
      }
      if ((bool1) && (paramcpl.xub == 18))
      {
        paramas2 = new ls();
        paramas2.dRd.dRe = paramas1.field_encryptUsername;
        paramas2.dRd.type = 2;
        com.tencent.mm.bj.d.bgO().aEq(paramas2.dRd.dRe);
        EventCenter.instance.publish(paramas2);
      }
      if (bool1) {
        cC(paramas1.field_username, paramcpl.xub);
      }
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramas1.arC()), Boolean.valueOf(paramBoolean) });
      if ((!paramBoolean) && (bool1) && (paramas1.arC()))
      {
        paramas2 = paramas1.field_username;
        if (!o.DCP.aKt(paramas2))
        {
          paramas2 = new LinkedList();
          paramas2.add(paramas1.field_username);
          paramas1 = new pr();
          paramas1.dVH.list = paramas2;
          paramas1.dVH.dJY = 1;
          paramas1.dVH.dVI = 5L;
          paramas1.dVH.dLQ = true;
          EventCenter.instance.publish(paramas1);
        }
      }
      com.tencent.mm.plugin.label.a.a.ecg().aHn();
      AppMethodBeat.o(22336);
      return;
      label2001:
      localObject3 = com.tencent.mm.bi.d.jpB.bgL();
      if ((Util.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!ab.Eq(paramArrayOfByte)))
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
            localObject3 = (xh)((Iterator)localObject1).next();
            if ((!Util.isNullOrNil(((xh)localObject3).UserName)) && (((xh)localObject3).UserName.equals(com.tencent.mm.model.z.aTY())))
            {
              i = 0;
              break;
            }
          }
        }
      }
      if (com.tencent.mm.bi.d.jpA != null)
      {
        if (com.tencent.mm.bi.d.jpA.bB(paramArrayOfByte, com.tencent.mm.model.z.aTY()))
        {
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
          localObject1 = new xz();
          ((xz)localObject1).eeo.userName = paramArrayOfByte;
          EventCenter.instance.publish((IEvent)localObject1);
        }
        com.tencent.mm.bi.d.jpA.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
      }
      if ((com.tencent.mm.bi.d.jpB != null) && (!Util.isNullOrNil(com.tencent.mm.bi.d.jpA.bgK())))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bi.d.jpB.bgL() });
        localObject1 = new fo();
        ((fo)localObject1).dIN.username = com.tencent.mm.bi.d.jpB.bgL();
        EventCenter.instance.publish((IEvent)localObject1);
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
          localObject3 = (xh)((Iterator)localObject1).next();
          if (!Util.isNullOrNil(((xh)localObject3).UserName)) {
            if (((xh)localObject3).UserName.equals(com.tencent.mm.model.z.aTY())) {
              break;
            }
          }
        }
      }
      label2333:
      if (com.tencent.mm.bh.g.jpy != null) {
        com.tencent.mm.bh.g.jpy.a(paramArrayOfByte, null, "", "", 0);
      }
      localObject1 = new xq();
      ((xq)localObject1).edR.edU = true;
      EventCenter.instance.publish((IEvent)localObject1);
      localObject1 = new xp();
      ((xp)localObject1).edP.edQ = true;
      EventCenter.instance.publish((IEvent)localObject1);
      break label138;
      i = 1;
      break label209;
      label2420:
      i = paramcpl.LUi.gsq;
      break label257;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final q paramq)
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
    if (!com.tencent.mm.kernel.g.aAf().hpY)
    {
      Log.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    com.tencent.f.h.RTc.aY(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(231630);
        Object localObject2 = ((com.tencent.mm.ba.b)paramq).jgc;
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
            ((Set)localObject1).add(com.tencent.mm.platformtools.z.a(((cpl)new cpl().parseFrom(localb.getBuffer())).Lqk));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            k.b localb;
            Log.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", localException, "BaseProtoBuf parseFrom error!", new Object[0]);
            localObject1 = ((Set)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              String str = (String)((Iterator)localObject1).next();
              if (!Util.isNullOrNil(str)) {
                ay.a.iDq.a(str, null, null);
              }
            }
            label151:
            if (localb.getCmdId() == 54) {
              ((Set)localObject1).add(((cpo)new cpo().parseFrom(localb.getBuffer())).MvG);
            } else if (localb.getCmdId() == 60) {
              ((Set)localObject1).add(((cqe)new cqe().parseFrom(localb.getBuffer())).MvG);
            }
          }
          AppMethodBeat.o(231630);
        }
      }
    });
    AppMethodBeat.o(22343);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
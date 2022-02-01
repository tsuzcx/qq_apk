package com.tencent.mm.plugin.bbom;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.n;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.il;
import com.tencent.mm.g.a.ks;
import com.tencent.mm.g.a.ks.a;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.g.a.me;
import com.tencent.mm.g.a.op;
import com.tencent.mm.g.a.vs;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.g.a.vt.b;
import com.tencent.mm.g.a.wb;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
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
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.sns.b.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.bva;
import com.tencent.mm.protocal.protobuf.bvd;
import com.tencent.mm.protocal.protobuf.bvs;
import com.tencent.mm.protocal.protobuf.cfj;
import com.tencent.mm.protocal.protobuf.cfk;
import com.tencent.mm.protocal.protobuf.dbt;
import com.tencent.mm.protocal.protobuf.ua;
import com.tencent.mm.protocal.protobuf.ub;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ap;
import com.tencent.mm.storage.bc;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bk.b;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.bm;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.bz;
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
  implements com.tencent.mm.ak.g, com.tencent.mm.plugin.messenger.foundation.a.c
{
  private static int nnJ = -1;
  
  private static void K(com.tencent.mm.storage.ai paramai)
  {
    AppMethodBeat.i(22341);
    if ((paramai != null) && (com.tencent.mm.al.f.AQ(paramai.field_username)) && (!com.tencent.mm.al.f.so(paramai.field_username)))
    {
      com.tencent.mm.model.az.ayM();
      ap localap = com.tencent.mm.model.c.awG().aNI(paramai.field_username);
      paramai = af.aCW().AE(paramai.field_username);
      if (!com.tencent.mm.al.f.AT(paramai.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localap == null)
      {
        localap = new ap(paramai.field_username);
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramai.IV(), paramai.field_username });
        localap.qT(bs.nullAsNil(paramai.IV()));
        localap.faH();
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().e(localap);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  public static boolean Ta(String paramString)
  {
    AppMethodBeat.i(22339);
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = com.tencent.mm.pluginsdk.ui.span.j.a.DCm.matcher(paramString);
    if (localMatcher.find())
    {
      if (bs.lr(paramString, localMatcher.group(0)))
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
  
  private static void a(bva parambva, String paramString, com.tencent.mm.storage.ai paramai, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = u.axw();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = af.aCW().AE(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = parambva.iKd;
      parambva = parambva.Fex;
      if (parambva != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = parambva.iKh;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = parambva.iKj;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = parambva.iKk;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = parambva.iKi;
          ac.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          ac.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!bs.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).bV(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).bV(false) != null) && (((com.tencent.mm.api.c)localObject).bV(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).bV(false).Jq() != null) && (!bs.isNullOrNil(((com.tencent.mm.api.c)localObject).IV())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).IV();
        ac.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!af.aCW().g((com.tencent.mm.api.c)localObject)) {
        af.aCW().f((com.tencent.mm.api.c)localObject);
      }
      paramai.jN(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  public static boolean a(com.tencent.mm.storage.ai paramai, bva parambva, boolean paramBoolean)
  {
    AppMethodBeat.i(22338);
    if ((paramai == null) || (bs.isNullOrNil(paramai.field_username)))
    {
      ac.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(22338);
      return false;
    }
    String str = paramai.field_username;
    Object localObject1 = paramai.field_encryptUsername;
    Object localObject2 = com.tencent.mm.aj.c.a(str, parambva);
    p.aBw().b((com.tencent.mm.aj.i)localObject2);
    localObject2 = parambva.Few;
    if ((!paramai.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((dbt)localObject2).iKe + " " + parambva.EuE);
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((dbt)localObject2).iKf);
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dbt)localObject2).iKg);
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dbt)localObject2).FLb);
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((dbt)localObject2).FLc);
      if (o.xMb != null) {
        o.xMb.a(paramai.field_username, (dbt)localObject2);
      }
    }
    boolean bool;
    if (com.tencent.mm.n.b.ln(paramai.field_type))
    {
      bool = com.tencent.mm.bj.d.aJe().fQ(str, 1);
      if (!bool) {
        break label429;
      }
      ac.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, user = ".concat(String.valueOf(str)));
    }
    for (;;)
    {
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact, update state(ADDED) FMessageConversation, ret = ".concat(String.valueOf(bool)));
      if ((com.tencent.mm.n.b.ln(paramai.field_type)) && ((paramai.getSource() == 10) || (paramai.getSource() == 13)))
      {
        t.l(com.tencent.mm.sdk.platformtools.ai.getContext(), paramai.field_username, paramai.field_encryptUsername);
        localObject1 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramai.field_encryptUsername);
        if ((localObject1 != null) && (!bs.isNullOrNil(((com.tencent.mm.plugin.account.friend.a.a)localObject1).iJS)))
        {
          ((com.tencent.mm.plugin.account.friend.a.a)localObject1).username = paramai.field_username;
          ac.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.a.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.a.a)localObject1).iJS, (com.tencent.mm.plugin.account.friend.a.a)localObject1))));
        }
      }
      a(parambva, str, paramai, paramBoolean);
      AppMethodBeat.o(22338);
      return true;
      label429:
      bool = com.tencent.mm.bj.d.aJe().fQ((String)localObject1, 1);
      ac.d("MicroMsg.BigBallContactAssemblerImpl", "fmsgConversation updateState succ, encryptUser = ".concat(String.valueOf(localObject1)));
    }
  }
  
  private static boolean a(com.tencent.mm.storage.ai paramai, bz parambz)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!bs.isNullOrNil(parambz.field_conDescription)) {
      paramai.qH(parambz.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!w.wF(paramai.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.n.b.ln(paramai.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!bs.isNullOrNil(parambz.field_conDescription))
        {
          bvd localbvd = new bvd();
          localbvd.Flc = paramai.field_username;
          localbvd.Desc = parambz.field_conDescription;
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awA().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(54, localbvd));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  private static void co(String paramString, int paramInt)
  {
    AppMethodBeat.i(22342);
    bl[] arrayOfbl = null;
    bx[] arrayOfbx;
    Object localObject1;
    bd[] arrayOfbd;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      ac.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      arrayOfbx = com.tencent.mm.bj.d.aJg().aOG(paramString);
      localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.sdk.platformtools.ai.getContext(), arrayOfbx);
      arrayOfbd = null;
    }
    while (localObject1 == null)
    {
      AppMethodBeat.o(22342);
      return;
      if (paramInt == 18)
      {
        ac.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbl = com.tencent.mm.bj.d.aJf().aOh(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.sdk.platformtools.ai.getContext(), arrayOfbl);
        arrayOfbx = null;
        arrayOfbd = null;
      }
      else
      {
        arrayOfbd = com.tencent.mm.bj.d.aJd().aOe(paramString);
        localObject1 = com.tencent.mm.pluginsdk.ui.preference.b.a(com.tencent.mm.sdk.platformtools.ai.getContext(), arrayOfbd);
        arrayOfbx = null;
      }
    }
    paramInt = 0;
    int k = localObject1.length;
    int i = 0;
    Object localObject2;
    bo localbo;
    int m;
    int j;
    if (i < k)
    {
      localObject2 = localObject1[i];
      localbo = new bo();
      localbo.setContent(localObject2.hlf);
      m = w.xt(localObject2.username);
      if (arrayOfbd != null)
      {
        j = paramInt + 1;
        localbo.oA(arrayOfbd[paramInt].field_createTime);
        paramInt = j;
      }
    }
    label384:
    label533:
    for (;;)
    {
      label215:
      localbo.re(localObject2.username);
      localbo.setType(m);
      label252:
      long l;
      if (localObject2.dBE)
      {
        localbo.setStatus(2);
        localbo.jT(1);
        com.tencent.mm.model.az.ayM();
        l = com.tencent.mm.model.c.awD().ap(localbo);
        if (l == -1L) {
          break label384;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        break;
        if (arrayOfbl != null)
        {
          j = paramInt + 1;
          localbo.oA(arrayOfbl[paramInt].field_createtime * 1000L);
          paramInt = j;
          break label215;
        }
        if (arrayOfbx == null) {
          break label533;
        }
        j = paramInt + 1;
        localbo.oA(arrayOfbx[paramInt].field_createtime * 1000L);
        paramInt = j;
        break label215;
        localbo.setStatus(6);
        localbo.jT(0);
        break label252;
      }
      localObject1 = new bo();
      if (arrayOfbd != null) {
        ((bo)localObject1).oA(arrayOfbd[0].field_createTime + 1L);
      }
      for (;;)
      {
        ((bo)localObject1).re(paramString);
        ((bo)localObject1).setContent(com.tencent.mm.sdk.platformtools.ai.getContext().getString(2131764537));
        ((bo)localObject1).setType(10000);
        ((bo)localObject1).setStatus(6);
        ((bo)localObject1).jT(0);
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awD().ap((bo)localObject1);
        AppMethodBeat.o(22342);
        return;
        if (arrayOfbl != null) {
          ((bo)localObject1).oA(arrayOfbl[0].field_createtime * 1000L + 1L);
        } else if (arrayOfbx != null) {
          ((bo)localObject1).oA(arrayOfbx[0].field_createtime * 1000L + 1L);
        }
      }
    }
  }
  
  public final void a(com.tencent.mm.storage.ai paramai1, com.tencent.mm.storage.ai paramai2, bva parambva, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paramai1.field_username;
    String str1 = paramai1.field_encryptUsername;
    if ((paramai2 != null) && (!bs.nullAsNil(paramai2.eyg).equals(bs.nullAsNil(parambva.FkT))))
    {
      com.tencent.mm.bd.c.aGS();
      com.tencent.mm.bd.c.Da(str2);
    }
    if (!bs.cv(paramArrayOfByte))
    {
      if (com.tencent.mm.storage.ai.YI(paramai1.field_verifyFlag)) {
        a(parambva, str2, paramai1, true);
      }
      if ((paramai2 == null) || (com.tencent.mm.n.b.ln(paramai2.field_type)) || (!com.tencent.mm.n.b.ln(paramai1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (w.wF(str2))) {
        com.tencent.mm.plugin.report.service.h.wUl.dB(931, 22);
      }
      Object localObject1 = paramai1.field_username;
      if (parambva.FkU == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(bs.m(Integer.valueOf(parambva.FkU.FtQ.size()))))
      {
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(nnJ) });
        if (nnJ == -1) {
          nnJ = ((com.tencent.mm.plugin.expt.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pZn, 0);
        }
        if (nnJ != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((parambva.FkU == null) || (parambva.FkU.FtQ == null)) {
          break label335;
        }
        paramArrayOfByte = parambva.FkU.FtQ.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (cfj)paramArrayOfByte.next();
          if (((cfj)localObject1).FtP != null) {
            localStringBuffer.append(((cfj)localObject1).FtP).append("，");
          }
        }
        a(paramai1, parambva, true);
        break;
      }
      label335:
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramai1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paramai2 != null)
      {
        localObject1 = paramai2.eyl;
        paramArrayOfByte = com.tencent.mm.n.a.a(paramai2, (String)localObject1);
      }
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        paramai2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        com.tencent.mm.model.az.ayM();
        localObject3 = com.tencent.mm.model.c.awC().alK(str1);
        paramai2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((bz)localObject3).field_conPhone;
          paramai2 = paramArrayOfByte;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            paramai2 = ((String)localObject1).split(",");
            localObject2 = localObject1;
          }
        }
      }
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramai1.field_username, bs.nullAsNil((String)localObject2) });
      int i;
      if ((paramai2 != null) && (paramai2.length > 0))
      {
        paramArrayOfByte = com.tencent.mm.n.a.ai(localStringBuffer.toString(), "，");
        int i2 = paramai2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          localObject1 = paramai2[k];
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
                if (!bs.lr((String)localObject1, paramArrayOfByte[n]))
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
                if (Ta((String)localObject1))
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
          paramai2 = new bvs();
          paramai2.Flc = paramai1.field_username;
          paramArrayOfByte = new cfk();
          localObject1 = com.tencent.mm.n.a.ai(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.ncL = localObject1.length;
            paramArrayOfByte.FtQ = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new cfj();
              ((cfj)localObject3).FtP = ((String)localObject2);
              paramArrayOfByte.FtQ.add(localObject3);
              i += 1;
            }
            paramai2.FkU = paramArrayOfByte;
            com.tencent.mm.model.az.ayM();
            com.tencent.mm.model.c.awA().c(new com.tencent.mm.plugin.messenger.foundation.a.a.j.a(60, paramai2));
          }
        }
        if ((j != 0) && (15 == parambva.sVo) && (!bs.isNullOrNil(paramai1.field_username)))
        {
          paramai2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(paramai1.field_username);
          if (paramai2 != null)
          {
            paramArrayOfByte = com.tencent.mm.n.a.ai(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.h.wUl;
            localObject2 = paramai1.field_username;
            if (!bs.isNullOrNil(paramai2.JC())) {
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
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramai1.field_username, localStringBuffer.toString() });
      paramai2 = localStringBuffer.toString();
      label998:
      paramai2 = bs.bG(paramai2, "");
      ac.i("MicroMsg.BigBallContactAssemblerImpl", paramai2);
      paramai1.qN(paramai2);
      if ((!w.sQ(str2)) && (parambva.ENw != null)) {
        q.a(str2, parambva.ENw);
      }
      boolean bool1 = false;
      com.tencent.mm.model.az.ayM();
      paramArrayOfByte = com.tencent.mm.model.c.awC().alK(paramai1.field_username);
      if (!bs.isNullOrNil(paramai1.field_conRemark))
      {
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!bs.isNullOrNil(paramai1.eyf)) && (!paramai1.eyf.equals(paramArrayOfByte.field_conDescription))) {
          a(paramai1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramai1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          w.B(paramai1);
        }
        paramai2 = null;
        com.tencent.mm.model.az.ayM();
        paramArrayOfByte = com.tencent.mm.model.c.awC().alK(paramai1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramai2 = paramArrayOfByte.field_contactLabels;
        }
        parambva = paramai2;
        if (bs.isNullOrNil(paramai2))
        {
          com.tencent.mm.model.az.ayM();
          localObject1 = com.tencent.mm.model.c.awC().alK(paramai1.field_username);
          parambva = paramai2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            parambva = ((bz)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!bs.isNullOrNil(parambva))
        {
          com.tencent.mm.plugin.label.a.a.cWd().hq(paramai1.field_username, parambva);
          paramArrayOfByte.field_contactLabels = "";
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awC().replace(paramArrayOfByte);
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
        paramai2 = new StringBuffer();
        if ((parambva.FkU != null) && (parambva.FkU.FtQ != null))
        {
          paramArrayOfByte = parambva.FkU.FtQ.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (cfj)paramArrayOfByte.next();
            if (((cfj)localObject1).FtP != null) {
              paramai2.append(((cfj)localObject1).FtP).append("，");
            }
          }
        }
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramai1.field_username, paramai2.toString() });
        paramai2 = paramai2.toString();
        break label998;
        if (paramArrayOfByte != null)
        {
          paramai2 = paramArrayOfByte;
          if (!bs.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          ac.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
          paramai2 = paramArrayOfByte;
          if (!bs.isNullOrNil(str1))
          {
            com.tencent.mm.model.az.ayM();
            paramai2 = com.tencent.mm.model.c.awC().alK(str1);
          }
        }
        paramBoolean = bool1;
        if (paramai2 != null)
        {
          paramBoolean = bool1;
          if (!bs.isNullOrNil(paramai2.field_encryptUsername))
          {
            ac.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramai2.field_encryptUsername);
            paramai1.qh(paramai2.field_conRemark);
            paramai1.qn(com.tencent.mm.platformtools.f.Fv(paramai2.field_conRemark));
            paramai1.qo(com.tencent.mm.platformtools.f.Fw(paramai2.field_conRemark));
            paramBoolean = a(paramai1, paramai2);
          }
        }
        switch (paramai1.getSource())
        {
        }
      }
      paramai2 = null;
      if ((parambva != null) && (!bs.isNullOrNil(parambva.FkN)))
      {
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { parambva.FkN, parambva.FkO });
        paramArrayOfByte = com.tencent.mm.plugin.account.a.getAddrUploadStg();
        paramai2 = parambva.FkN;
        localObject1 = parambva.FkO;
        parambva = paramArrayOfByte.Gi(paramai2);
        paramai2 = parambva;
        if (parambva == null) {
          paramai2 = paramArrayOfByte.Gi((String)localObject1);
        }
        if (paramai2 != null) {
          break label1919;
        }
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramai2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (bs.isNullOrNil(paramai2.aPm())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramai2.aPt()) {
          break;
        }
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramai2.aPm(), paramai2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramai2.username = paramai1.field_username;
        paramai2.status = 2;
        paramai2.aPs();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramai1.qh(paramai2.aPm());
          paramai1.qn(com.tencent.mm.platformtools.f.Fv(paramai2.aPm()));
          paramai1.qo(com.tencent.mm.platformtools.f.Fw(paramai2.aPm()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.n.b.ln(paramai1.field_type)) {
          break;
        }
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramai2.aPm(), paramai2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.a.getAddrUploadStg().a(paramai2.JC(), paramai2);
        bool1 = bool2;
        break;
        if (bs.isNullOrNil(str1)) {
          break label1694;
        }
        paramai2 = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(str1);
        break label1694;
        label1919:
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { bs.nullAsNil(paramai2.aPm()), bs.nullAsNil(paramai2.getUsername()), Boolean.valueOf(paramai2.aPt()) });
      }
    }
  }
  
  public final void b(com.tencent.mm.storage.ai paramai1, com.tencent.mm.storage.ai paramai2, bva parambva, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paramai1.field_username;
    Object localObject2 = paramai1.field_encryptUsername;
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
    if (w.sQ(paramArrayOfByte))
    {
      if (parambva.ENw != null)
      {
        localObject1 = parambva.ENw.Eob;
        if (com.tencent.mm.bi.d.hXZ != null) {
          break label1873;
        }
        i = 0;
        if (i == 0)
        {
          localObject1 = parambva.ENw.Eob;
          localObject3 = new vt();
          ((vt)localObject3).dyB.dyD = true;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject3);
          if ((!bs.isNullOrNil(paramArrayOfByte)) && (w.sQ(paramArrayOfByte)) && (!bs.isNullOrNil(((vt)localObject3).dyC.dyF)) && (paramArrayOfByte.equals(((vt)localObject3).dyC.dyF))) {
            break label2143;
          }
        }
        localObject1 = parambva.ENw.Eob;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (ub)((Iterator)localObject1).next();
          } while ((bs.isNullOrNil(((ub)localObject3).ncR)) || (!((ub)localObject3).ncR.equals(u.axw())));
        }
        i = 0;
        if (i != 0)
        {
          ((com.tencent.mm.plugin.multitalk.model.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.multitalk.model.a.class)).amj(paramArrayOfByte);
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.live.a.class)).forceStopCurLive(com.tencent.mm.sdk.platformtools.ai.getContext());
        }
      }
      if (parambva.ENw != null) {
        break label2292;
      }
      i = 0;
      localObject1 = parambva.FkI;
      localObject3 = parambva.FkH;
      k = parambva.FkS;
      m = parambva.FkR;
      localObject4 = parambva.tlX;
      n = parambva.FkQ;
      i1 = parambva.FkV;
      if (parambva.ENw != null) {
        break label2304;
      }
    }
    label2304:
    for (int j = -1;; j = parambva.ENw.Eoc)
    {
      ac.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s chatroomVersion:%d chatroomInfoVersion:%s infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j) });
      if ((parambva.ENw != null) && (parambva.ENw.fsB != 0))
      {
        localObject1 = new com.tencent.mm.j.a.a.a();
        ((com.tencent.mm.j.a.a.a)localObject1).type = parambva.FkS;
        ((com.tencent.mm.j.a.a.a)localObject1).maxCount = parambva.FkR;
        ((com.tencent.mm.j.a.a.a)localObject1).fBT = parambva.tlX;
        ((com.tencent.mm.j.a.a.a)localObject1).fBU = parambva.FkQ;
        if (parambva.ENw.Eoc == 0) {
          ((com.tencent.mm.j.a.a.a)localObject1).doy = parambva.FkQ;
        }
        localObject3 = new me();
        ((me)localObject3).dox.chatroomName = paramArrayOfByte;
        ((me)localObject3).dox.doy = ((com.tencent.mm.j.a.a.a)localObject1).doy;
        q.a(paramArrayOfByte, parambva.FkH, parambva.ENw, parambva.FkW, parambva.FkV, u.axw(), (com.tencent.mm.j.a.a.a)localObject1, (com.tencent.mm.sdk.b.b)localObject3);
      }
      try
      {
        bool1 = ((k)com.tencent.mm.kernel.g.ab(k.class)).awG().Gt(paramArrayOfByte);
        bool2 = q.GN(paramArrayOfByte);
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        if ((bool1) && (bool2))
        {
          localObject1 = new il();
          ((il)localObject1).djE.djF = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
          q.aa(paramArrayOfByte, parambva.FkS);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          boolean bool1;
          boolean bool2;
          long l;
          ac.e("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s, exception:%s %s", new Object[] { paramArrayOfByte, localException.getClass().getSimpleName(), localException.getMessage() });
          continue;
          if ((paramai1.fad()) && (com.tencent.mm.al.f.AO(paramai1.field_username)) && (paramai1 != null) && (paramai1.fad()) && (com.tencent.mm.al.f.AO(paramai1.field_username)))
          {
            ac.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramai1.field_username);
            com.tencent.mm.model.az.ayM();
            ap localap = com.tencent.mm.model.c.awG().aNI(paramai1.field_username);
            af.aCW().AE(paramai1.field_username);
            if (localap == null)
            {
              com.tencent.mm.model.az.ayM();
              if (com.tencent.mm.model.c.awG().aNI("officialaccounts") == null)
              {
                localap = new ap("officialaccounts");
                localap.faH();
                com.tencent.mm.model.az.ayM();
                com.tencent.mm.model.c.awG().e(localap);
              }
              localap = new ap(paramai1.field_username);
              localap.qT("officialaccounts");
              com.tencent.mm.model.az.ayM();
              com.tencent.mm.model.c.awG().e(localap);
              continue;
              if (((paramai2 == null) || ((paramai2.field_type & 0x800) != (paramai1.field_type & 0x800))) && (com.tencent.mm.al.f.AQ(paramai1.field_username)) && (!com.tencent.mm.al.f.so(paramai1.field_username)))
              {
                K(paramai1);
                continue;
                if (com.tencent.mm.al.f.AT(paramai1.field_username))
                {
                  com.tencent.mm.model.az.ayM();
                  if (com.tencent.mm.model.c.awG().aNI(paramai1.field_username) == null)
                  {
                    paramArrayOfByte = af.aCW().AE(paramai1.field_username);
                    localap = new ap(paramai1.field_username);
                    ac.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.IV(), paramai1.field_username });
                    localap.qT(bs.nullAsNil(paramArrayOfByte.IV()));
                    localap.faH();
                    com.tencent.mm.model.az.ayM();
                    com.tencent.mm.model.c.awG().e(localap);
                    continue;
                    i = 0;
                    continue;
                    if ((paramai2 == null) || ((paramai2.field_type & 0x8) != (paramai1.field_type & 0x8)))
                    {
                      com.tencent.mm.model.az.ayM();
                      com.tencent.mm.model.c.awG().c(new String[] { paramai1.field_username }, "");
                      continue;
                      paramai2.faH();
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
      if ((!com.tencent.mm.n.b.ln(paramai1.field_type)) && (!paramai1.aaF()) && (!com.tencent.mm.storage.ai.ww(paramai1.field_username)) && (!w.sQ(paramai1.field_username)))
      {
        ac.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramai1.field_username, Integer.valueOf(paramai1.field_type) });
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().aNG(paramai1.field_username);
      }
      if ((paramai1.field_type & 0x800) == 0) {
        break label2543;
      }
      if ((paramai2 == null) || ((paramai2.field_type & 0x800) != (paramai1.field_type & 0x800)))
      {
        if ((!com.tencent.mm.al.f.AQ(paramai1.field_username)) || (com.tencent.mm.al.f.so(paramai1.field_username))) {
          break label2357;
        }
        K(paramai1);
      }
      if ((paramai2 == null) || (com.tencent.mm.n.b.ln(paramai2.field_type)) || (!com.tencent.mm.n.b.ln(paramai1.field_type))) {
        break label2772;
      }
      bool1 = true;
      if (com.tencent.mm.n.b.ln(paramai1.field_type))
      {
        com.tencent.mm.model.az.ayM();
        localObject1 = com.tencent.mm.model.c.awC().alK(paramArrayOfByte);
        if (localObject1 != null)
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bs.isNullOrNil(((bz)localObject1).field_encryptUsername)) {}
        }
        else
        {
          paramArrayOfByte = (byte[])localObject1;
          if (!bs.isNullOrNil((String)localObject2))
          {
            com.tencent.mm.model.az.ayM();
            paramArrayOfByte = com.tencent.mm.model.c.awC().alK((String)localObject2);
          }
        }
        if ((paramArrayOfByte != null) && (!bs.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
        {
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awC().alL(paramArrayOfByte.field_encryptUsername);
        }
      }
      if (com.tencent.mm.al.f.AP(paramai1.field_username))
      {
        af.aDf();
        com.tencent.mm.al.d.a(paramai1.field_username, null);
        if ((bool1) && (com.tencent.mm.al.f.AQ(paramai1.field_username)))
        {
          if (!com.tencent.mm.al.f.so(paramai1.field_username)) {
            break label2593;
          }
          af.aDe();
          com.tencent.mm.al.a.h.a(paramai1.field_username, null);
        }
      }
      paramArrayOfByte = com.tencent.mm.al.f.dX(paramai1.field_username);
      if (paramArrayOfByte == null) {
        break label2709;
      }
      paramArrayOfByte = paramArrayOfByte.bV(false);
      if (paramArrayOfByte == null) {
        break label2709;
      }
      i = 0;
      if (paramArrayOfByte.cFq != null) {
        i = paramArrayOfByte.cFq.optInt("WXAppType", 0);
      }
      if (i == 0) {
        break label2709;
      }
      i = 1;
      if (i != 0)
      {
        af.aDi();
        com.tencent.mm.al.a.Av(paramai1.field_username);
      }
      if ((paramai1.field_type & 0x8) == 0) {
        break label2715;
      }
      if ((paramai2 == null) || ((paramai2.field_type & 0x8) != (paramai1.field_type & 0x8)))
      {
        com.tencent.mm.model.az.ayM();
        com.tencent.mm.model.c.awG().c(new String[] { paramai1.field_username }, "@blacklist");
      }
      if (!paramBoolean)
      {
        if ((paramai1 != null) && (paramai1.fad()) && (com.tencent.mm.n.b.ln(paramai1.field_type)))
        {
          l = System.currentTimeMillis();
          com.tencent.mm.model.az.ayM();
          paramArrayOfByte = com.tencent.mm.model.c.awG().aNI(paramai1.field_username);
          if ((paramArrayOfByte != null) && (paramArrayOfByte.lr(4194304)))
          {
            com.tencent.mm.model.az.ayM();
            bool2 = com.tencent.mm.model.c.awG().a(paramai1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
            ac.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramai1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
          }
        }
        if ((paramai2 != null) && ((int)paramai2.fLJ > 0) && (paramai2.eyc != 0) && (paramai2.eyd == 0) && (paramai1.eyd == 1))
        {
          ac.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramai1.field_username });
          com.tencent.mm.model.az.ayM();
          com.tencent.mm.model.c.awG().aNY(paramai1.field_username);
          com.tencent.mm.model.az.ayM();
          paramai2 = com.tencent.mm.model.c.awG().aNI("officialaccounts");
          if (paramai2 != null)
          {
            com.tencent.mm.model.az.ayM();
            paramai2.jR(com.tencent.mm.model.c.awG().faO());
            ac.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramai2.field_unReadCount) });
            com.tencent.mm.model.az.ayM();
            paramArrayOfByte = com.tencent.mm.model.c.awG().aNV("officialaccounts");
            com.tencent.mm.model.az.ayM();
            paramArrayOfByte = com.tencent.mm.model.c.awD().alk(paramArrayOfByte);
            if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
              break label2765;
            }
            paramai2.aI(paramArrayOfByte);
            paramai2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
            paramai2.qQ(Integer.toString(paramArrayOfByte.getType()));
            com.tencent.mm.model.az.ayM();
            localObject1 = com.tencent.mm.model.c.awG().Ls();
            if (localObject1 != null)
            {
              localObject2 = new PString();
              localObject3 = new PString();
              localObject4 = new PInt();
              paramArrayOfByte.re("officialaccounts");
              paramArrayOfByte.setContent(paramai2.field_content);
              ((bk.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
              paramai2.qR(((PString)localObject2).value);
              paramai2.qS(((PString)localObject3).value);
              paramai2.jU(((PInt)localObject4).value);
            }
            com.tencent.mm.model.az.ayM();
            com.tencent.mm.model.c.awG().a(paramai2, paramai2.field_username);
          }
        }
      }
      if (bool1)
      {
        paramai2 = new lp();
        paramai2.dny.username = paramai1.field_username;
        paramai2.dny.dnz = paramai1.dnz;
        com.tencent.mm.sdk.b.a.GpY.l(paramai2);
      }
      if ((bool1) && (parambva.sVo == 18))
      {
        paramai2 = new ks();
        paramai2.dmx.dmy = paramai1.field_encryptUsername;
        paramai2.dmx.type = 2;
        com.tencent.mm.bj.d.aJf().ald(paramai2.dmx.dmy);
        com.tencent.mm.sdk.b.a.GpY.l(paramai2);
      }
      if (bool1) {
        co(paramai1.field_username, parambva.sVo);
      }
      ac.d("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramai1.aaL()), Boolean.valueOf(paramBoolean) });
      if ((!paramBoolean) && (bool1) && (paramai1.aaL()))
      {
        paramai2 = paramai1.field_username;
        if (!o.xMd.apG(paramai2))
        {
          paramai2 = new LinkedList();
          paramai2.add(paramai1.field_username);
          paramai1 = new op();
          paramai1.dqX.list = paramai2;
          paramai1.dqX.dgm = 1;
          paramai1.dqX.dqY = 5L;
          paramai1.dqX.dqZ = true;
          com.tencent.mm.sdk.b.a.GpY.l(paramai1);
        }
      }
      com.tencent.mm.plugin.label.a.a.cWd().alK();
      AppMethodBeat.o(22336);
      return;
      label1873:
      localObject3 = com.tencent.mm.bi.d.hXZ.aJc();
      if ((bs.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!w.sQ(paramArrayOfByte)))
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
            localObject3 = (ub)((Iterator)localObject1).next();
            if ((!bs.isNullOrNil(((ub)localObject3).ncR)) && (((ub)localObject3).ncR.equals(u.axw())))
            {
              i = 0;
              break;
            }
          }
        }
      }
      if (com.tencent.mm.bi.d.hXY != null)
      {
        if (com.tencent.mm.bi.d.hXY.bw(paramArrayOfByte, u.axw()))
        {
          ac.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
          localObject1 = new wb();
          ((wb)localObject1).dyV.userName = paramArrayOfByte;
          com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
        }
        com.tencent.mm.bi.d.hXY.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
      }
      if ((com.tencent.mm.bi.d.hXZ != null) && (!bs.isNullOrNil(com.tencent.mm.bi.d.hXY.aJb())))
      {
        ac.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bi.d.hXZ.aJc() });
        localObject1 = new fh();
        ((fh)localObject1).dfa.username = com.tencent.mm.bi.d.hXZ.aJc();
        com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      }
      i = 1;
      break;
      label2143:
      if (localObject1 != null)
      {
        localObject1 = ((LinkedList)localObject1).iterator();
        for (;;)
        {
          if (!((Iterator)localObject1).hasNext()) {
            break label2205;
          }
          localObject3 = (ub)((Iterator)localObject1).next();
          if (!bs.isNullOrNil(((ub)localObject3).ncR)) {
            if (((ub)localObject3).ncR.equals(u.axw())) {
              break;
            }
          }
        }
      }
      label2205:
      if (com.tencent.mm.bh.g.hXW != null) {
        com.tencent.mm.bh.g.hXW.a(paramArrayOfByte, null, "", "", 0);
      }
      localObject1 = new vt();
      ((vt)localObject1).dyB.dyE = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      localObject1 = new vs();
      ((vs)localObject1).dyz.dyA = true;
      com.tencent.mm.sdk.b.a.GpY.l((com.tencent.mm.sdk.b.b)localObject1);
      break label138;
      i = 1;
      break label209;
      label2292:
      i = parambva.ENw.fsB;
      break label257;
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(22343);
    ac.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
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
    if (!com.tencent.mm.kernel.g.agP().ggT)
    {
      ac.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    paramn = ((com.tencent.mm.ba.b)paramn).hOW;
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
        paramString.add(z.a(((bva)new bva().parseFrom(localb.getBuffer())).EuE));
      }
    }
    catch (Exception paramn)
    {
      for (;;)
      {
        j.b localb;
        ac.printErrStackTrace("MicroMsg.BigBallContactAssemblerImpl", paramn, "BaseProtoBuf parseFrom error!", new Object[0]);
        paramString = paramString.iterator();
        while (paramString.hasNext())
        {
          paramn = (String)paramString.next();
          if (!bs.isNullOrNil(paramn)) {
            ar.a.hnw.a(paramn, null, null);
          }
        }
        label251:
        if (localb.getCmdId() == 54) {
          paramString.add(((bvd)new bvd().parseFrom(localb.getBuffer())).Flc);
        } else if (localb.getCmdId() == 60) {
          paramString.add(((bvs)new bvs().parseFrom(localb.getBuffer())).Flc);
        }
      }
      AppMethodBeat.o(22343);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.bbom;

import android.content.Context;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.am.p;
import com.tencent.mm.an.af;
import com.tencent.mm.an.e;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.aap;
import com.tencent.mm.autogen.a.aaq;
import com.tencent.mm.autogen.a.aaq.b;
import com.tencent.mm.autogen.a.aba;
import com.tencent.mm.autogen.a.gg;
import com.tencent.mm.autogen.a.lb;
import com.tencent.mm.autogen.a.np;
import com.tencent.mm.autogen.a.np.a;
import com.tencent.mm.autogen.a.on;
import com.tencent.mm.autogen.a.pf;
import com.tencent.mm.autogen.a.pu;
import com.tencent.mm.autogen.a.sd;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.bd;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.v;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.b;
import com.tencent.mm.pluginsdk.ui.span.o.a;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.ahl;
import com.tencent.mm.protocal.protobuf.aid;
import com.tencent.mm.protocal.protobuf.dpe;
import com.tencent.mm.protocal.protobuf.dph;
import com.tencent.mm.protocal.protobuf.dpk;
import com.tencent.mm.protocal.protobuf.dqb;
import com.tencent.mm.protocal.protobuf.edj;
import com.tencent.mm.protocal.protobuf.edk;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.ffs;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.protocal.protobuf.zh;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bb;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.by.b;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.cc;
import com.tencent.mm.storage.cp;
import com.tencent.mm.storage.cq;
import com.tencent.mm.storage.cr;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import junit.framework.Assert;

public final class c
  implements com.tencent.mm.am.h, com.tencent.mm.plugin.messenger.foundation.a.f
{
  private static int vsO = -1;
  
  private static void a(dph paramdph, String paramString, au paramau, boolean paramBoolean)
  {
    AppMethodBeat.i(22337);
    Object localObject = z.bAM();
    if ((localObject != null) && (!((String)localObject).equals(paramString)))
    {
      localObject = af.bHf().Mn(paramString);
      ((com.tencent.mm.api.c)localObject).field_username = paramString;
      ((com.tencent.mm.api.c)localObject).field_brandList = paramdph.pSp;
      paramdph = paramdph.aaMt;
      if (paramdph != null)
      {
        ((com.tencent.mm.api.c)localObject).field_brandFlag = paramdph.pSt;
        ((com.tencent.mm.api.c)localObject).field_brandInfo = paramdph.pSv;
        ((com.tencent.mm.api.c)localObject).field_brandIconURL = paramdph.pSw;
        if (paramBoolean)
        {
          ((com.tencent.mm.api.c)localObject).field_extInfo = paramdph.pSu;
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "update extInfo=%s", new Object[] { ((com.tencent.mm.api.c)localObject).field_extInfo });
          ((com.tencent.mm.api.c)localObject).field_attrSyncVersion = null;
          ((com.tencent.mm.api.c)localObject).field_incrementUpdateTime = 0L;
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset biz(%s) Attribute syncVersion and incUpdateTime.", new Object[] { paramString });
        }
        if (!Util.isNullOrNil(((com.tencent.mm.api.c)localObject).field_extInfo)) {
          ((com.tencent.mm.api.c)localObject).dO(true);
        }
      }
      if ((((com.tencent.mm.api.c)localObject).dO(false) != null) && (((com.tencent.mm.api.c)localObject).dO(false).getServiceType() == 3) && (((com.tencent.mm.api.c)localObject).dO(false).aBr() != null) && (!Util.isNullOrNil(((com.tencent.mm.api.c)localObject).aAX())))
      {
        ((com.tencent.mm.api.c)localObject).field_enterpriseFather = ((com.tencent.mm.api.c)localObject).aAX();
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "saveBizInfo, %s set enterpriseFather %s", new Object[] { paramString, ((com.tencent.mm.api.c)localObject).field_enterpriseFather });
      }
      if (!af.bHf().h((com.tencent.mm.api.c)localObject)) {
        af.bHf().g((com.tencent.mm.api.c)localObject);
      }
      paramau.pC(((com.tencent.mm.api.c)localObject).field_type);
    }
    AppMethodBeat.o(22337);
  }
  
  private static void a(au paramau, int paramInt)
  {
    AppMethodBeat.i(369704);
    String str = paramau.field_username;
    bz[] arrayOfbz = null;
    Object localObject1;
    if ((paramInt == 26) || (paramInt == 27) || (paramInt == 28) || (paramInt == 29))
    {
      Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is shake");
      paramau = com.tencent.mm.modelverify.d.bNK().byO(str);
      localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), paramau);
      localObject1 = null;
    }
    bp localbp;
    while (localObject2 == null)
    {
      AppMethodBeat.o(369704);
      return;
      if (paramInt == 18)
      {
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "initAddContent, scene is lbs");
        arrayOfbz = com.tencent.mm.modelverify.d.bNJ().byp(str);
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), arrayOfbz);
        paramau = null;
        localObject1 = null;
      }
      else
      {
        localObject2 = paramau.field_encryptUsername;
        localObject1 = com.tencent.mm.modelverify.d.bNH();
        if (!Util.isNullOrNil((String)localObject2)) {}
        for (paramau = "select *, rowid from fmessage_msginfo  where talker = '" + Util.escapeSqlValue(str) + "' or talker = '" + Util.escapeSqlValue((String)localObject2) + "'  order by createTime DESC limit 3";; paramau = "select *, rowid from fmessage_msginfo  where talker = '" + Util.escapeSqlValue(str) + "' order by createTime DESC limit 3")
        {
          Log.d("MicroMsg.FMessageMsgInfoStorage", "getLastFMessageMsgInfo, sql = ".concat(String.valueOf(paramau)));
          paramau = ((bq)localObject1).db.rawQuery(paramau, null, 2);
          localObject1 = new ArrayList();
          while (paramau.moveToNext())
          {
            localbp = new bp();
            localbp.convertFrom(paramau);
            ((ArrayList)localObject1).add(localbp);
          }
        }
        paramau.close();
        localObject1 = (bp[])((ArrayList)localObject1).toArray(new bp[((ArrayList)localObject1).size()]);
        if (localObject1 != null) {
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "filterSendRequestFileterMessage , encryptUsername = %s, fmsgList.length = %s.", new Object[] { localObject2, Integer.valueOf(localObject1.length) });
        }
        localObject2 = com.tencent.mm.pluginsdk.ui.preference.b.a(MMApplicationContext.getContext(), (bp[])localObject1);
        paramau = null;
      }
    }
    Log.i("MicroMsg.BigBallContactAssemblerImpl", "providerList.size = %s", new Object[] { Integer.valueOf(localObject2.length) });
    int j = 0;
    int k = localObject2.length;
    int i = 0;
    if (i < k)
    {
      localbp = localObject2[i];
      cc localcc = new cc();
      localcc.setContent(localbp.nUO);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "provider.digest = %s, provider.username = %s, username = %s", new Object[] { localbp.nUO, localbp.username, str });
      int m = ab.IX(localbp.username);
      long l;
      if (localObject1 != null)
      {
        l = localObject1[j].field_createTime;
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "provider.time = %s ", new Object[] { Long.valueOf(l) });
        localcc.setCreateTime(l);
        paramInt = j + 1;
        label497:
        if (localObject1 == null) {
          break label650;
        }
        localcc.BS(str);
        label509:
        localcc.setType(m);
        if (!localbp.ihD) {
          break label663;
        }
        localcc.setStatus(2);
        localcc.pI(1);
        label536:
        bh.bCz();
        l = com.tencent.mm.model.c.bzD().ba(localcc);
        if (l == -1L) {
          break label679;
        }
      }
      label650:
      label663:
      label679:
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue(bool);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "new msg inserted to db , local id = ".concat(String.valueOf(l)));
        i += 1;
        j = paramInt;
        break;
        if (arrayOfbz != null)
        {
          localcc.setCreateTime(arrayOfbz[j].field_createtime * 1000L);
          paramInt = j + 1;
          break label497;
        }
        paramInt = j;
        if (paramau == null) {
          break label497;
        }
        localcc.setCreateTime(paramau[j].field_createtime * 1000L);
        paramInt = j + 1;
        break label497;
        localcc.BS(localbp.username);
        break label509;
        localcc.setStatus(6);
        localcc.pI(0);
        break label536;
      }
    }
    Object localObject2 = new cc();
    if (localObject1 != null) {
      ((cc)localObject2).setCreateTime(localObject1[0].field_createTime + 1L);
    }
    for (;;)
    {
      ((cc)localObject2).BS(str);
      ((cc)localObject2).setContent(MMApplicationContext.getContext().getString(R.l.gXv));
      ((cc)localObject2).setType(10000);
      ((cc)localObject2).setStatus(6);
      ((cc)localObject2).pI(0);
      bh.bCz();
      com.tencent.mm.model.c.bzD().ba((cc)localObject2);
      AppMethodBeat.o(369704);
      return;
      if (arrayOfbz != null) {
        ((cc)localObject2).setCreateTime(arrayOfbz[0].field_createtime * 1000L + 1L);
      } else if (paramau != null) {
        ((cc)localObject2).setCreateTime(paramau[0].field_createtime * 1000L + 1L);
      }
    }
  }
  
  public static boolean a(au paramau, dph paramdph, boolean paramBoolean)
  {
    AppMethodBeat.i(22338);
    if ((paramau == null) || (Util.isNullOrNil(paramau.field_username)))
    {
      Log.e("MicroMsg.BigBallContactAssemblerImpl", "dkinit dealModContactExtInfo failed invalid contact");
      AppMethodBeat.o(22338);
      return false;
    }
    String str = paramau.field_username;
    Object localObject1 = paramau.field_encryptUsername;
    Object localObject2 = com.tencent.mm.modelavatar.d.a(str, paramdph, paramau);
    com.tencent.mm.modelavatar.q.bFE().b((com.tencent.mm.modelavatar.j)localObject2);
    localObject2 = paramdph.aaMs;
    if ((!paramau.field_username.endsWith("@chatroom")) && (localObject2 != null))
    {
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsFlag modcontact " + ((ffs)localObject2).pSq + " " + paramdph.ZqL);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBg modcontact " + ((ffs)localObject2).pSr);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((ffs)localObject2).pSs);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((ffs)localObject2).abFF);
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "SnsBgId modcontact " + ((ffs)localObject2).abFG);
      if (com.tencent.mm.plugin.sns.c.q.Qki != null) {
        com.tencent.mm.plugin.sns.c.q.Qki.a(paramau.field_username, (ffs)localObject2);
      }
    }
    if (com.tencent.mm.contact.d.rs(paramau.field_type)) {
      com.tencent.mm.plugin.profile.c.lb(str, (String)localObject1);
    }
    if ((com.tencent.mm.contact.d.rs(paramau.field_type)) && ((paramau.getSource() == 10) || (paramau.getSource() == 13)))
    {
      localObject1 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramau.field_encryptUsername);
      if ((localObject1 != null) && (!Util.isNullOrNil(((com.tencent.mm.plugin.account.friend.model.a)localObject1).pSe)))
      {
        ((com.tencent.mm.plugin.account.friend.model.a)localObject1).username = paramau.field_username;
        Log.d("MicroMsg.BigBallContactAssemblerImpl", "account sync: update addr ".concat(String.valueOf(com.tencent.mm.plugin.account.b.getAddrUploadStg().a(((com.tencent.mm.plugin.account.friend.model.a)localObject1).pSe, (com.tencent.mm.plugin.account.friend.model.a)localObject1))));
      }
    }
    a(paramdph, str, paramau, paramBoolean);
    AppMethodBeat.o(22338);
    return true;
  }
  
  private static boolean a(au paramau, cr paramcr)
  {
    AppMethodBeat.i(22340);
    boolean bool2 = false;
    if (!Util.isNullOrNil(paramcr.field_conDescription)) {
      paramau.Bv(paramcr.field_conDescription);
    }
    boolean bool1 = bool2;
    if (!au.bxa(paramau.field_username))
    {
      bool1 = bool2;
      if (com.tencent.mm.contact.d.rs(paramau.field_type))
      {
        bool2 = true;
        bool1 = bool2;
        if (!Util.isNullOrNil(paramcr.field_conDescription))
        {
          dpk localdpk = new dpk();
          localdpk.aaWl = paramau.field_username;
          localdpk.IGG = paramcr.field_conDescription;
          bh.bCz();
          com.tencent.mm.model.c.bzz().d(new k.a(54, localdpk));
          bool1 = bool2;
        }
      }
    }
    AppMethodBeat.o(22340);
    return bool1;
  }
  
  private static void ab(au paramau)
  {
    AppMethodBeat.i(22341);
    if ((paramau != null) && (com.tencent.mm.an.g.MA(paramau.field_username)) && (!com.tencent.mm.an.g.Dn(paramau.field_username)))
    {
      bh.bCz();
      bb localbb = com.tencent.mm.model.c.bzG().bxM(paramau.field_username);
      paramau = af.bHf().Mn(paramau.field_username);
      if (paramau == null)
      {
        Log.w("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceEnterpriseToTop bizInfo is null");
        AppMethodBeat.o(22341);
        return;
      }
      if (!com.tencent.mm.an.g.MD(paramau.field_username))
      {
        AppMethodBeat.o(22341);
        return;
      }
      if (localbb == null)
      {
        localbb = new bb(paramau.field_username);
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramau.aAX(), paramau.field_username });
        localbb.BH(Util.nullAsNil(paramau.aAX()));
        localbb.jaJ();
        bh.bCz();
        com.tencent.mm.model.c.bzG().h(localbb);
      }
    }
    AppMethodBeat.o(22341);
  }
  
  public static boolean aie(String paramString)
  {
    AppMethodBeat.i(22339);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(22339);
      return false;
    }
    Matcher localMatcher = o.a.Yot.matcher(paramString);
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
  
  public final void a(au paramau, aid paramaid) {}
  
  public final void a(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22335);
    String str2 = paramau1.field_username;
    String str1 = paramau1.field_encryptUsername;
    if ((paramau2 != null) && (!Util.nullAsNil(paramau2.kam).equals(Util.nullAsNil(paramdph.aaWa))))
    {
      com.tencent.mm.ba.c.bLL();
      com.tencent.mm.ba.c.OQ(str2);
    }
    if (!Util.isNullOrNil(paramArrayOfByte))
    {
      if (au.ayS(paramau1.field_verifyFlag)) {
        a(paramdph, str2, paramau1, true);
      }
      if ((paramau2 == null) || (com.tencent.mm.contact.d.rs(paramau2.field_type)) || (!com.tencent.mm.contact.d.rs(paramau1.field_type))) {
        break label1964;
      }
    }
    label925:
    label1318:
    label1964:
    for (int j = 1;; j = 0)
    {
      if ((j != 0) && (au.bxa(str2))) {
        com.tencent.mm.plugin.report.service.h.OAn.kJ(931, 22);
      }
      Object localObject1 = paramau1.field_username;
      if (paramdph.aaWb == null) {}
      StringBuffer localStringBuffer;
      for (paramArrayOfByte = "";; paramArrayOfByte = Integer.valueOf(Util.nullAsNil(Integer.valueOf(paramdph.aaWb.abiF.size()))))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s PhoneNumList size:%s mergePhoneSw:%s", new Object[] { localObject1, paramArrayOfByte, Integer.valueOf(vsO) });
        if (vsO == -1) {
          vsO = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.zla, 0);
        }
        if (vsO != 1) {
          break label1318;
        }
        localStringBuffer = new StringBuffer();
        if ((paramdph.aaWb == null) || (paramdph.aaWb.abiF == null)) {
          break label335;
        }
        paramArrayOfByte = paramdph.aaWb.abiF.iterator();
        while (paramArrayOfByte.hasNext())
        {
          localObject1 = (edj)paramArrayOfByte.next();
          if (((edj)localObject1).abiE != null) {
            localStringBuffer.append(((edj)localObject1).abiE).append("，");
          }
        }
        a(paramau1, paramdph, true);
        break;
      }
      label335:
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramau1.field_username, localStringBuffer.toString() });
      localObject1 = null;
      paramArrayOfByte = null;
      int m = 0;
      if (paramau2 != null)
      {
        localObject1 = paramau2.kar;
        paramArrayOfByte = com.tencent.mm.contact.a.a(paramau2, (String)localObject1);
      }
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        paramau2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (!((String)localObject1).equals("")) {}
      }
      else
      {
        bh.bCz();
        localObject3 = com.tencent.mm.model.c.bzB().aMi(str1);
        paramau2 = paramArrayOfByte;
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject1 = ((cr)localObject3).field_conPhone;
          paramau2 = paramArrayOfByte;
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            paramau2 = ((String)localObject1).split(",");
            localObject2 = localObject1;
          }
        }
      }
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, oldPhoneList %s", new Object[] { paramau1.field_username, Util.nullAsNil((String)localObject2) });
      int i;
      if ((paramau2 != null) && (paramau2.length > 0))
      {
        paramArrayOfByte = com.tencent.mm.contact.a.av(localStringBuffer.toString(), "，");
        int i2 = paramau2.length;
        int k = 0;
        i = 0;
        while (k < i2)
        {
          localObject1 = paramau2[k];
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
                if (aie((String)localObject1))
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
          paramau2 = new dqb();
          paramau2.aaWl = paramau1.field_username;
          paramArrayOfByte = new edk();
          localObject1 = com.tencent.mm.contact.a.av(localStringBuffer.toString(), "，");
          if ((localObject1 != null) && (localObject1.length > 0))
          {
            paramArrayOfByte.vgN = localObject1.length;
            paramArrayOfByte.abiF = new LinkedList();
            k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = localObject1[i];
              localObject3 = new edj();
              ((edj)localObject3).abiE = ((String)localObject2);
              paramArrayOfByte.abiF.add(localObject3);
              i += 1;
            }
            paramau2.aaWb = paramArrayOfByte;
            bh.bCz();
            com.tencent.mm.model.c.bzz().d(new k.a(60, paramau2));
          }
        }
        if ((j != 0) && (15 == paramdph.IcB) && (!Util.isNullOrNil(paramau1.field_username)))
        {
          paramau2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(paramau1.field_username);
          if (paramau2 != null)
          {
            paramArrayOfByte = com.tencent.mm.contact.a.av(localStringBuffer.toString(), "，");
            localObject1 = com.tencent.mm.plugin.report.service.h.OAn;
            localObject2 = paramau1.field_username;
            if (!Util.isNullOrNil(paramau2.getMd5())) {
              break label1291;
            }
            j = 0;
            if (paramArrayOfByte != null) {
              break label1297;
            }
            i = 0;
            ((com.tencent.mm.plugin.report.service.h)localObject1).b(12040, new Object[] { localObject2, Integer.valueOf(3), Integer.valueOf(j), Integer.valueOf(i) });
          }
        }
      }
      Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramau1.field_username, localStringBuffer.toString() });
      paramau2 = localStringBuffer.toString();
      label998:
      paramau2 = Util.nullAs(paramau2, "");
      Log.i("MicroMsg.BigBallContactAssemblerImpl", paramau2);
      paramau1.BB(paramau2);
      if ((!au.bwE(str2)) && (paramdph.aaqf != null)) {
        v.a(str2, paramdph.aaqf);
      }
      boolean bool1 = false;
      bh.bCz();
      paramArrayOfByte = com.tencent.mm.model.c.bzB().aMi(paramau1.field_username);
      if (!Util.isNullOrNil(paramau1.field_conRemark))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remark is set");
        if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramau1.kal)) && (!paramau1.kal.equals(paramArrayOfByte.field_conDescription))) {
          a(paramau1, paramArrayOfByte);
        }
      }
      for (bool1 = false;; bool1 = paramBoolean)
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s needModContact %s encryptUser:%s", new Object[] { paramau1.field_username, Boolean.valueOf(bool1), str1 });
        if (bool1) {
          ab.Q(paramau1);
        }
        paramau2 = null;
        bh.bCz();
        paramArrayOfByte = com.tencent.mm.model.c.bzB().aMi(paramau1.field_encryptUsername);
        if (paramArrayOfByte != null) {
          paramau2 = paramArrayOfByte.field_contactLabels;
        }
        paramdph = paramau2;
        if (Util.isNullOrNil(paramau2))
        {
          bh.bCz();
          localObject1 = com.tencent.mm.model.c.bzB().aMi(paramau1.field_username);
          paramdph = paramau2;
          paramArrayOfByte = (byte[])localObject1;
          if (localObject1 != null)
          {
            paramdph = ((cr)localObject1).field_contactLabels;
            paramArrayOfByte = (byte[])localObject1;
          }
        }
        if (!Util.isNullOrNil(paramdph))
        {
          com.tencent.mm.plugin.label.a.a.fTb().jP(paramau1.field_username, paramdph);
          paramArrayOfByte.field_contactLabels = "";
          bh.bCz();
          com.tencent.mm.model.c.bzB().replace(paramArrayOfByte);
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
        paramau2 = new StringBuffer();
        if ((paramdph.aaWb != null) && (paramdph.aaWb.abiF != null))
        {
          paramArrayOfByte = paramdph.aaWb.abiF.iterator();
          while (paramArrayOfByte.hasNext())
          {
            localObject1 = (edj)paramArrayOfByte.next();
            if (((edj)localObject1).abiE != null) {
              paramau2.append(((edj)localObject1).abiE).append("，");
            }
          }
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "username:%s, phoneList %s", new Object[] { paramau1.field_username, paramau2.toString() });
        paramau2 = paramau2.toString();
        break label998;
        if (paramArrayOfByte != null)
        {
          paramau2 = paramArrayOfByte;
          if (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)) {}
        }
        else
        {
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "try get stranger again");
          paramau2 = paramArrayOfByte;
          if (!Util.isNullOrNil(str1))
          {
            bh.bCz();
            paramau2 = com.tencent.mm.model.c.bzB().aMi(str1);
          }
        }
        paramBoolean = bool1;
        if (paramau2 != null)
        {
          paramBoolean = bool1;
          if (!Util.isNullOrNil(paramau2.field_encryptUsername))
          {
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "mod stranger remark : " + paramau2.field_encryptUsername);
            paramau1.AW(paramau2.field_conRemark);
            paramau1.Bb(com.tencent.mm.platformtools.f.RZ(paramau2.field_conRemark));
            paramau1.Bc(com.tencent.mm.platformtools.f.Sa(paramau2.field_conRemark));
            paramBoolean = a(paramau1, paramau2);
          }
        }
        switch (paramau1.getSource())
        {
        }
      }
      paramau2 = null;
      if ((paramdph != null) && (!Util.isNullOrNil(paramdph.aaVU)))
      {
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "MobileHash[%s],MobileFullHash[%s]", new Object[] { paramdph.aaVU, paramdph.aaVV });
        paramArrayOfByte = com.tencent.mm.plugin.account.b.getAddrUploadStg();
        paramau2 = paramdph.aaVU;
        localObject1 = paramdph.aaVV;
        paramdph = paramArrayOfByte.SU(paramau2);
        paramau2 = paramdph;
        if (paramdph == null) {
          paramau2 = paramArrayOfByte.SU((String)localObject1);
        }
        if (paramau2 != null) {
          break label1919;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "dealWithRemark-> addr == null");
      }
      for (;;)
      {
        bool1 = paramBoolean;
        if (paramau2 == null) {
          break;
        }
        bool1 = paramBoolean;
        if (Util.isNullOrNil(paramau2.bWI())) {
          break;
        }
        bool1 = paramBoolean;
        if (!paramau2.bWP()) {
          break;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramau2.bWI(), paramau2.getUsername(), Boolean.valueOf(paramBoolean) });
        paramau2.username = paramau1.field_username;
        paramau2.status = 2;
        paramau2.bWO();
        boolean bool2 = paramBoolean;
        if (!paramBoolean)
        {
          paramau1.AW(paramau2.bWI());
          paramau1.Bb(com.tencent.mm.platformtools.f.RZ(paramau2.bWI()));
          paramau1.Bc(com.tencent.mm.platformtools.f.Sa(paramau2.bWI()));
          bool2 = true;
        }
        bool1 = bool2;
        if (!com.tencent.mm.contact.d.rs(paramau1.field_type)) {
          break;
        }
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "updateAddrUp RealName[%s], User[%s], remarkChange[%s]", new Object[] { paramau2.bWI(), paramau2.getUsername(), Boolean.valueOf(bool2) });
        com.tencent.mm.plugin.account.b.getAddrUploadStg().a(paramau2.getMd5(), paramau2);
        bool1 = bool2;
        break;
        if (Util.isNullOrNil(str1)) {
          break label1694;
        }
        paramau2 = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(str1);
        break label1694;
        label1919:
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "remarkName RealName[%s], User[%s], needSetRemark[%s]", new Object[] { Util.nullAsNil(paramau2.bWI()), Util.nullAsNil(paramau2.getUsername()), Boolean.valueOf(paramau2.bWP()) });
      }
    }
  }
  
  public final void b(au paramau1, au paramau2, dph paramdph, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    AppMethodBeat.i(22336);
    paramArrayOfByte = paramau1.field_username;
    Object localObject2 = paramau1.field_encryptUsername;
    Object localObject1;
    int i;
    if (au.bwE(paramArrayOfByte)) {
      if (paramdph.aaqf != null)
      {
        localObject1 = paramdph.aaqf.ZhK;
        if (com.tencent.mm.bd.d.oXO != null) {
          break label2013;
        }
        i = 0;
      }
    }
    for (;;)
    {
      Object localObject3;
      label135:
      label206:
      label254:
      Object localObject4;
      int j;
      label306:
      boolean bool1;
      if (i == 0)
      {
        localObject1 = paramdph.aaqf.ZhK;
        localObject3 = new aaq();
        ((aaq)localObject3).ieg.iei = true;
        ((aaq)localObject3).publish();
        if ((!Util.isNullOrNil(paramArrayOfByte)) && (au.bwE(paramArrayOfByte)) && (!Util.isNullOrNil(((aaq)localObject3).ieh.iek)) && (paramArrayOfByte.equals(((aaq)localObject3).ieh.iek))) {}
      }
      else
      {
        localObject1 = paramdph.aaqf.ZhK;
        if (localObject1 != null)
        {
          localObject1 = ((LinkedList)localObject1).iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject3 = (zh)((Iterator)localObject1).next();
          } while ((Util.isNullOrNil(((zh)localObject3).UserName)) || (!((zh)localObject3).UserName.equals(z.bAM())));
        }
        i = 0;
        if (i != 0)
        {
          ((com.tencent.mm.plugin.multitalk.model.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.multitalk.model.d.class)).aMN(paramArrayOfByte);
          ((com.tencent.mm.live.a)com.tencent.mm.kernel.h.az(com.tencent.mm.live.a.class)).forceStopCurLive(MMApplicationContext.getContext());
        }
        if (paramdph.aaqf != null) {
          break label2420;
        }
        i = 0;
        localObject1 = paramdph.aaVP;
        localObject3 = paramdph.aaVO;
        int k = paramdph.aaVZ;
        int m = paramdph.aaVY;
        localObject4 = paramdph.IMu;
        int n = paramdph.aaVX;
        int i1 = paramdph.aaWc;
        if (paramdph.aaqf != null) {
          break label2432;
        }
        j = -1;
        Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s count:%d ChatRoomData:%s owner:%s type:%d max:%d upgrader:%s chatroomVersion:%d chatroomInfoVersion:%s infomask:%d ", new Object[] { paramArrayOfByte, Integer.valueOf(i), localObject1, localObject3, Integer.valueOf(k), Integer.valueOf(m), localObject4, Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(j) });
        bool1 = v.a(paramArrayOfByte, paramdph);
        if (paramdph.aaqf != null)
        {
          localObject1 = new com.tencent.mm.h.a.a.a();
          ((com.tencent.mm.h.a.a.a)localObject1).type = paramdph.aaVZ;
          ((com.tencent.mm.h.a.a.a)localObject1).lyL = paramdph.aaVY;
          ((com.tencent.mm.h.a.a.a)localObject1).lPL = paramdph.IMu;
          ((com.tencent.mm.h.a.a.a)localObject1).lPM = paramdph.aaVX;
          if (paramdph.aaqf.ZhL == 0) {
            ((com.tencent.mm.h.a.a.a)localObject1).hSm = paramdph.aaVX;
          }
          localObject3 = new pf();
          ((pf)localObject3).hSl.chatroomName = paramArrayOfByte;
          ((pf)localObject3).hSl.hSm = ((com.tencent.mm.h.a.a.a)localObject1).hSm;
          v.a(paramArrayOfByte, paramdph.aaVO, paramdph.aaqf, paramdph.aaWd, paramdph.aaWc, z.bAM(), (com.tencent.mm.h.a.a.a)localObject1, (IEvent)localObject3);
        }
      }
      try
      {
        if (v.Iv(paramArrayOfByte))
        {
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(paramArrayOfByte);
          if (localObject1 != null) {
            ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.n.class)).a((bb)localObject1, false, true);
          }
          bool2 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().Te(paramArrayOfByte);
          boolean bool3 = v.Iq(paramArrayOfByte);
          Log.i("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s isExistConversation:%s isNeedUpdateChatRoomInfo:%s", new Object[] { paramArrayOfByte, Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
          if ((bool2) && (bool3))
          {
            localObject1 = new lb();
            ((lb)localObject1).hML.hMM = paramArrayOfByte;
            ((lb)localObject1).publish();
            v.aL(paramArrayOfByte, paramdph.aaVZ);
          }
          if (!bool1) {}
        }
      }
      catch (Exception localException1)
      {
        try
        {
          for (;;)
          {
            boolean bool2;
            if (((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().Te(paramArrayOfByte))
            {
              localObject1 = new pu();
              ((pu)localObject1).hSY.hMM = paramArrayOfByte;
              ((pu)localObject1).publish();
            }
            if ((!com.tencent.mm.contact.d.rs(paramau1.field_type)) && (!paramau1.aSD()) && (!au.bwS(paramau1.field_username)) && (!au.bwE(paramau1.field_username)) && (!au.aAy(paramau1.field_username)))
            {
              Log.w("MicroMsg.BigBallContactAssemblerImpl", "processModContact delChatContact now user:%s ,type:%d", new Object[] { paramau1.field_username, Integer.valueOf(paramau1.field_type) });
              bh.bCz();
              com.tencent.mm.model.c.bzG().bxK(paramau1.field_username);
            }
            if ((paramau1.field_type & 0x800) == 0) {
              break label2779;
            }
            if ((paramau2 == null) || ((paramau2.field_type & 0x800) != (paramau1.field_type & 0x800)))
            {
              if ((!com.tencent.mm.an.g.MA(paramau1.field_username)) || (com.tencent.mm.an.g.Dn(paramau1.field_username))) {
                break label2580;
              }
              ab(paramau1);
            }
            if ((paramau2 == null) || (com.tencent.mm.contact.d.rs(paramau2.field_type)) || (!com.tencent.mm.contact.d.rs(paramau1.field_type))) {
              break label3049;
            }
            bool1 = true;
            if (com.tencent.mm.contact.d.rs(paramau1.field_type))
            {
              bh.bCz();
              localObject1 = com.tencent.mm.model.c.bzB().aMi(paramArrayOfByte);
              if (localObject1 != null)
              {
                paramArrayOfByte = (byte[])localObject1;
                if (!Util.isNullOrNil(((cr)localObject1).field_encryptUsername)) {}
              }
              else
              {
                paramArrayOfByte = (byte[])localObject1;
                if (!Util.isNullOrNil((String)localObject2))
                {
                  bh.bCz();
                  paramArrayOfByte = com.tencent.mm.model.c.bzB().aMi((String)localObject2);
                }
              }
              if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
              {
                bh.bCz();
                com.tencent.mm.model.c.bzB().aMj(paramArrayOfByte.field_encryptUsername);
              }
            }
            if ((com.tencent.mm.contact.d.rs(paramau1.field_type)) && (!Util.isNullOrNil(paramdph.aanb)))
            {
              bh.bCz();
              paramArrayOfByte = com.tencent.mm.model.c.bzC().aLx(paramdph.ZqL.abwM);
              if ((paramArrayOfByte != null) && (!Util.isNullOrNil(paramArrayOfByte.field_encryptUsername)))
              {
                paramArrayOfByte.field_username = paramdph.aanb;
                paramArrayOfByte.field_modifyTime = System.currentTimeMillis();
                bh.bCz();
                if (com.tencent.mm.model.c.bzC().replace(paramArrayOfByte)) {
                  break label2829;
                }
                Log.e("MicroMsg.BigBallContactAssemblerImpl", "update stranger fail, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramdph.aanb });
              }
            }
            if (com.tencent.mm.an.g.Mz(paramau1.field_username))
            {
              af.bHq();
              e.a(paramau1.field_username, null);
              if ((bool1) && (com.tencent.mm.an.g.MA(paramau1.field_username)))
              {
                if (!com.tencent.mm.an.g.Dn(paramau1.field_username)) {
                  break label2859;
                }
                af.bHp();
                com.tencent.mm.an.a.h.a(paramau1.field_username, null);
              }
            }
            if ((paramau1.field_type & 0x8) == 0) {
              break label2992;
            }
            if ((paramau2 == null) || ((paramau2.field_type & 0x8) != (paramau1.field_type & 0x8)))
            {
              bh.bCz();
              com.tencent.mm.model.c.bzG().e(new String[] { paramau1.field_username }, "@blacklist");
            }
            if (!paramBoolean)
            {
              if ((paramau1 != null) && (paramau1.iZC()) && (com.tencent.mm.contact.d.rs(paramau1.field_type)))
              {
                long l = System.currentTimeMillis();
                bh.bCz();
                paramArrayOfByte = com.tencent.mm.model.c.bzG().bxM(paramau1.field_username);
                if ((paramArrayOfByte != null) && (paramArrayOfByte.rx(4194304)))
                {
                  bh.bCz();
                  bool2 = com.tencent.mm.model.c.bzG().a(paramau1.field_username, 4194304, false, paramArrayOfByte.field_attrflag);
                  Log.i("MicroMsg.BigBallContactAssemblerImpl", "Reset temp session attr flag.(talker %s, updateSucc %s, cost %s)", new Object[] { paramau1.field_username, Boolean.valueOf(bool2), Long.valueOf(System.currentTimeMillis() - l) });
                }
              }
              if ((paramau2 != null) && ((int)paramau2.maN > 0) && (paramau2.kak != 0) && (paramau2.hyY == 0) && (paramau1.hyY == 1))
              {
                Log.d("MicroMsg.BigBallContactAssemblerImpl", "hakon removeParentRefAndUnread user = %s", new Object[] { paramau1.field_username });
                bh.bCz();
                com.tencent.mm.model.c.bzG().byg(paramau1.field_username);
                bh.bCz();
                paramau2 = com.tencent.mm.model.c.bzG().bxM("officialaccounts");
                if (paramau2 != null)
                {
                  bh.bCz();
                  paramau2.pG(com.tencent.mm.model.c.bzG().jaQ());
                  Log.d("MicroMsg.BigBallContactAssemblerImpl", "unread count is %d", new Object[] { Integer.valueOf(paramau2.field_unReadCount) });
                  bh.bCz();
                  paramArrayOfByte = com.tencent.mm.model.c.bzG().byc("officialaccounts");
                  bh.bCz();
                  paramArrayOfByte = com.tencent.mm.model.c.bzD().aLG(paramArrayOfByte);
                  if ((paramArrayOfByte == null) || (paramArrayOfByte.field_msgId <= 0L)) {
                    break label3042;
                  }
                  paramau2.bG(paramArrayOfByte);
                  paramau2.setContent(paramArrayOfByte.field_talker + ":" + paramArrayOfByte.field_content);
                  paramau2.BE(Integer.toString(paramArrayOfByte.getType()));
                  bh.bCz();
                  localObject1 = com.tencent.mm.model.c.bzG().aDH();
                  if (localObject1 != null)
                  {
                    localObject2 = new PString();
                    localObject3 = new PString();
                    localObject4 = new PInt();
                    paramArrayOfByte.BS("officialaccounts");
                    paramArrayOfByte.setContent(paramau2.field_content);
                    ((by.b)localObject1).a(paramArrayOfByte, (PString)localObject2, (PString)localObject3, (PInt)localObject4, true);
                    paramau2.BF(((PString)localObject2).value);
                    paramau2.BG(((PString)localObject3).value);
                    paramau2.pJ(((PInt)localObject4).value);
                  }
                  bh.bCz();
                  com.tencent.mm.model.c.bzG().c(paramau2, paramau2.field_username);
                }
              }
            }
            if (bool1)
            {
              paramau2 = new on();
              paramau2.hRj.username = paramau1.field_username;
              paramau2.hRj.hRk = paramau1.hRk;
              paramau2.publish();
            }
            if ((bool1) && (paramdph.IcB == 18))
            {
              paramau2 = new np();
              paramau2.hPZ.hQa = paramau1.field_encryptUsername;
              paramau2.hPZ.type = 2;
              com.tencent.mm.modelverify.d.bNJ().aLz(paramau2.hPZ.hQa);
              paramau2.publish();
            }
            if (bool1) {
              a(paramau1, paramdph.IcB);
            }
            Log.i("MicroMsg.BigBallContactAssemblerImpl", "isNewContact:%b, isSnsNoInteresting:%b, isInit:%b", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(paramau1.aSM()), Boolean.valueOf(paramBoolean) });
            if ((!paramBoolean) && (bool1) && (paramau1.aSM()))
            {
              paramau2 = paramau1.field_username;
              if (!com.tencent.mm.plugin.sns.c.q.Qkl.aRZ(paramau2))
              {
                paramau2 = new LinkedList();
                paramau2.add(paramau1.field_username);
                paramau1 = new sd();
                paramau1.hVg.list = paramau2;
                paramau1.hVg.hHC = 1;
                paramau1.hVg.hVh = 5L;
                paramau1.hVg.hJv = true;
                paramau1.publish();
              }
            }
            com.tencent.mm.plugin.label.a.a.fTb().bja();
            AppMethodBeat.o(22336);
            return;
            label2013:
            localObject3 = com.tencent.mm.bd.d.oXO.bNG();
            if ((Util.isNullOrNil((String)localObject3)) || (!((String)localObject3).equals(paramArrayOfByte)) || (!au.bwE(paramArrayOfByte)))
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
                  localObject3 = (zh)((Iterator)localObject1).next();
                  if ((!Util.isNullOrNil(((zh)localObject3).UserName)) && (((zh)localObject3).UserName.equals(z.bAM())))
                  {
                    i = 0;
                    break;
                  }
                }
              }
            }
            if (com.tencent.mm.bd.d.oXN != null)
            {
              if (com.tencent.mm.bd.d.oXN.bQ(paramArrayOfByte, z.bAM()))
              {
                Log.i("MicroMsg.BigBallContactAssemblerImpl", "kicked self shareing");
                localObject1 = new aba();
                ((aba)localObject1).ieF.userName = paramArrayOfByte;
                ((aba)localObject1).publish();
              }
              com.tencent.mm.bd.d.oXN.a(paramArrayOfByte, null, 0.0D, 0.0D, "", "", "");
            }
            if ((com.tencent.mm.bd.d.oXO != null) && (!Util.isNullOrNil(com.tencent.mm.bd.d.oXN.bNF())))
            {
              Log.i("MicroMsg.BigBallContactAssemblerImpl", "sync remove chatroom end track %s", new Object[] { com.tencent.mm.bd.d.oXO.bNG() });
              localObject1 = new gg();
              ((gg)localObject1).hGt.username = com.tencent.mm.bd.d.oXO.bNG();
              ((gg)localObject1).publish();
            }
            i = 1;
            break;
            if (localObject1 != null)
            {
              localObject1 = ((LinkedList)localObject1).iterator();
              for (;;)
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break label2339;
                }
                localObject3 = (zh)((Iterator)localObject1).next();
                if (!Util.isNullOrNil(((zh)localObject3).UserName)) {
                  if (((zh)localObject3).UserName.equals(z.bAM())) {
                    break;
                  }
                }
              }
            }
            label2339:
            if (com.tencent.mm.bc.g.oXL != null) {
              com.tencent.mm.bc.g.oXL.a(paramArrayOfByte, null, "", "", 0);
            }
            localObject1 = new aaq();
            ((aaq)localObject1).ieg.iej = true;
            ((aaq)localObject1).publish();
            localObject1 = new aap();
            ((aap)localObject1).iee.ief = true;
            ((aap)localObject1).publish();
            break label135;
            i = 1;
            break label206;
            label2420:
            i = paramdph.aaqf.lyF;
            break label254;
            label2432:
            j = paramdph.aaqf.ZhL;
            break label306;
            if (paramau2.aMt())
            {
              localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzG().bxM(paramArrayOfByte);
              if (localObject1 != null) {
                ((com.tencent.mm.plugin.appbrand.service.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.n.class)).f((bb)localObject1);
              }
            }
          }
          localException1 = localException1;
          Log.e("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s, exception:%s %s", new Object[] { paramArrayOfByte, localException1.getClass().getSimpleName(), localException1.getMessage() });
        }
        catch (Exception localException2)
        {
          label2829:
          for (;;)
          {
            Log.e("MicroMsg.BigBallContactAssemblerImpl", "processModContact chatroom:%s, exception:%s %s", new Object[] { paramArrayOfByte, localException2.getClass().getSimpleName(), localException2.getMessage() });
            continue;
            label2580:
            if ((paramau1.iZC()) && (com.tencent.mm.an.g.My(paramau1.field_username)) && (paramau1 != null) && (paramau1.iZC()) && (com.tencent.mm.an.g.My(paramau1.field_username)))
            {
              Log.i("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop uct : " + paramau1.field_username);
              bh.bCz();
              bb localbb = com.tencent.mm.model.c.bzG().bxM(paramau1.field_username);
              if (af.bHf().Mn(paramau1.field_username) == null) {
                Log.w("MicroMsg.BigBallContactAssemblerImpl", "dealPlaceSubscribeBizToTop bizInfo is null");
              } else {
                label2859:
                label2992:
                if (localbb == null)
                {
                  bh.bCz();
                  if (com.tencent.mm.model.c.bzG().bxM("officialaccounts") == null)
                  {
                    localbb = new bb("officialaccounts");
                    localbb.jaJ();
                    bh.bCz();
                    com.tencent.mm.model.c.bzG().h(localbb);
                  }
                  localbb = new bb(paramau1.field_username);
                  localbb.BH("officialaccounts");
                  bh.bCz();
                  com.tencent.mm.model.c.bzG().h(localbb);
                  continue;
                  label2779:
                  if (((paramau2 == null) || ((paramau2.field_type & 0x800) != (paramau1.field_type & 0x800))) && (com.tencent.mm.an.g.MA(paramau1.field_username)) && (!com.tencent.mm.an.g.Dn(paramau1.field_username)))
                  {
                    ab(paramau1);
                    continue;
                    Log.i("MicroMsg.BigBallContactAssemblerImpl", "update stranger ok, encryptUsername:%s, friendUsernname:%s", new Object[] { paramArrayOfByte.field_encryptUsername, paramdph.aanb });
                    continue;
                    if (com.tencent.mm.an.g.MD(paramau1.field_username))
                    {
                      bh.bCz();
                      if (com.tencent.mm.model.c.bzG().bxM(paramau1.field_username) == null)
                      {
                        paramArrayOfByte = af.bHf().Mn(paramau1.field_username);
                        if (paramArrayOfByte == null)
                        {
                          Log.w("MicroMsg.BigBallContactAssemblerImpl", "dealCreateEnterpriseNewChildConv bizInfo is null");
                        }
                        else
                        {
                          localbb = new bb(paramau1.field_username);
                          Log.i("MicroMsg.BigBallContactAssemblerImpl", "Enterprise belong %s, userName: %s", new Object[] { paramArrayOfByte.aAX(), paramau1.field_username });
                          localbb.BH(Util.nullAsNil(paramArrayOfByte.aAX()));
                          localbb.jaJ();
                          bh.bCz();
                          com.tencent.mm.model.c.bzG().h(localbb);
                          continue;
                          if ((paramau2 == null) || ((paramau2.field_type & 0x8) != (paramau1.field_type & 0x8)))
                          {
                            bh.bCz();
                            com.tencent.mm.model.c.bzG().e(new String[] { paramau1.field_username }, "");
                            continue;
                            label3042:
                            paramau2.jaJ();
                            continue;
                            label3049:
                            bool1 = false;
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, final p paramp)
  {
    AppMethodBeat.i(22343);
    Log.i("MicroMsg.BigBallContactAssemblerImpl", "onsceneEnd errType:%d,errCode:%d,errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if (paramp.getType() != 681)
    {
      AppMethodBeat.o(22343);
      return;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      AppMethodBeat.o(22343);
      return;
    }
    if (!com.tencent.mm.kernel.h.baC().mBZ)
    {
      Log.w("MicroMsg.BigBallContactAssemblerImpl", "initialize notify is not done.");
      AppMethodBeat.o(22343);
      return;
    }
    com.tencent.threadpool.h.ahAA.bn(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(260647);
        Object localObject2 = ((com.tencent.mm.ay.b)paramp).oPH;
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
            ((Set)localObject1).add(w.a(((dph)new dph().parseFrom(localb.getBuffer())).ZqL));
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
                az.a.okP.a(str, null, null);
              }
            }
            label151:
            if (localb.getCmdId() == 54) {
              ((Set)localObject1).add(((dpk)new dpk().parseFrom(localb.getBuffer())).aaWl);
            } else if (localb.getCmdId() == 60) {
              ((Set)localObject1).add(((dqb)new dqb().parseFrom(localb.getBuffer())).aaWl);
            } else if (localb.getCmdId() == 74) {
              ((Set)localObject1).add(((dpe)new dpe().parseFrom(localb.getBuffer())).YFn.abwM);
            }
          }
          AppMethodBeat.o(260647);
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
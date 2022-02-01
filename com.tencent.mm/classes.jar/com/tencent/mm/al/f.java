package com.tencent.mm.al;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.c.ba;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.at;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.br;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class f
  extends j<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static Map<String, String> hSM;
  private final com.tencent.mm.sdk.e.l<a, f.a.b> hSD;
  
  static
  {
    AppMethodBeat.i(124042);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "bizinfo") };
    hSM = new HashMap();
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) " };
    AppMethodBeat.o(124042);
  }
  
  public f(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, c.info, "bizinfo", INDEX_CREATE);
    AppMethodBeat.i(124010);
    this.hSD = new com.tencent.mm.sdk.e.l() {};
    AppMethodBeat.o(124010);
  }
  
  public static Cursor Eh(String paramString)
  {
    AppMethodBeat.i(124033);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, false);
    a(localStringBuilder, false);
    localStringBuilder.append(" order by ");
    localStringBuilder.append(aFM());
    paramString = localStringBuilder.toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.g.ajR().gDX.a(paramString, null, 0);
    AppMethodBeat.o(124033);
    return paramString;
  }
  
  public static List<String> Ei(String paramString)
  {
    AppMethodBeat.i(124034);
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    paramString = ((StringBuilder)localObject).toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.g.ajR().gDX.a(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(124034);
      return null;
    }
    localObject = new ArrayList();
    while (paramString.moveToNext()) {
      ((List)localObject).add(paramString.getString(0));
    }
    paramString.close();
    AppMethodBeat.o(124034);
    return localObject;
  }
  
  public static String Ej(String paramString)
  {
    AppMethodBeat.i(124035);
    if (bu.isNullOrNil(paramString))
    {
      ae.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
      AppMethodBeat.o(124035);
      return null;
    }
    if ((hSM != null) && (hSM.containsKey(paramString)))
    {
      paramString = (String)hSM.get(paramString);
      if ((!bu.isNullOrNil(paramString)) && (x.An(paramString)))
      {
        AppMethodBeat.o(124035);
        return paramString;
      }
      AppMethodBeat.o(124035);
      return null;
    }
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    a((StringBuilder)localObject, true);
    localObject = ((StringBuilder)localObject).toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[] { localObject });
    Cursor localCursor = com.tencent.mm.kernel.g.ajR().gDX.a((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(124035);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = localCursor.getString(0);
      hSM.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localCursor.close();
      AppMethodBeat.o(124035);
      return paramString;
    }
  }
  
  public static boolean Ek(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124037);
    if ((bu.isNullOrNil(paramString)) || (!g.Et(paramString)))
    {
      AppMethodBeat.o(124037);
      return false;
    }
    Object localObject1 = g.eX(paramString);
    Object localObject2;
    if ((((c)localObject1).bX(false) != null) && (((c)localObject1).bX(false).KX() != null) && (!bu.isNullOrNil(((c)localObject1).KD())))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVo(((c)localObject1).KD());
      if ((localObject2 != null) && (((ba)localObject2).field_username.equals(paramString)) && (((ba)localObject2).field_unReadCount > 0)) {
        ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVc(((c)localObject1).KD());
      }
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().arm(paramString);
    ((Cursor)localObject1).moveToFirst();
    while (!((Cursor)localObject1).isAfterLast())
    {
      localObject2 = new bv();
      ((bv)localObject2).convertFrom((Cursor)localObject1);
      ((bv)localObject2).setStatus(4);
      ae.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + ((ei)localObject2).field_msgSvrId + " status = " + ((ei)localObject2).field_status);
      ((Cursor)localObject1).moveToNext();
      bool = true;
    }
    ((Cursor)localObject1).close();
    if (bool)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azL().aVc(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).doJ().ark(paramString);
    }
    AppMethodBeat.o(124037);
    return bool;
  }
  
  public static void El(String paramString)
  {
    AppMethodBeat.i(124038);
    if ((bu.isNullOrNil(paramString)) || (!g.Et(paramString)))
    {
      AppMethodBeat.o(124038);
      return;
    }
    ((a)com.tencent.mm.kernel.g.ad(a.class)).getNotification().uI(paramString);
    ((a)com.tencent.mm.kernel.g.ad(a.class)).getNotification().MP();
    AppMethodBeat.o(124038);
  }
  
  public static void Em(String paramString)
  {
    AppMethodBeat.i(124039);
    if ((bu.isNullOrNil(paramString)) || (!g.Et(paramString)))
    {
      AppMethodBeat.o(124039);
      return;
    }
    ((a)com.tencent.mm.kernel.g.ad(a.class)).getNotification().uI("");
    AppMethodBeat.o(124039);
  }
  
  public static Cursor M(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(124032);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, true);
    if (paramBoolean) {
      a(localStringBuilder, false);
    }
    try
    {
      paramString = g.Ex(paramString);
      if (!paramString.isEmpty()) {
        a(localStringBuilder, paramString);
      }
      label60:
      localStringBuilder.append(" order by ");
      localStringBuilder.append(aFM());
      paramString = localStringBuilder.toString();
      ae.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[] { paramString });
      paramString = com.tencent.mm.kernel.g.ajR().gDX.a(paramString, null, 0);
      AppMethodBeat.o(124032);
      return paramString;
    }
    catch (Throwable paramString)
    {
      break label60;
    }
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124022);
    paramStringBuilder.append("select bizinfo.username ");
    AppMethodBeat.o(124022);
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(124026);
    paramStringBuilder.append(" and bizinfo.type = 3");
    paramStringBuilder.append(" and bizinfo.enterpriseFather = '").append(paramString).append("' ");
    AppMethodBeat.o(124026);
  }
  
  private static void a(StringBuilder paramStringBuilder, List<String> paramList)
  {
    AppMethodBeat.i(188869);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(188869);
      return;
    }
    paramStringBuilder.append(" and (bizinfo.username NOT IN (");
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)paramList.get(i);
      paramStringBuilder.append("'").append(str).append("'");
      if (i != j - 1) {
        paramStringBuilder.append(",");
      }
      i += 1;
    }
    paramStringBuilder.append(")) ");
    AppMethodBeat.o(188869);
  }
  
  public static void a(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(124027);
    paramStringBuilder.append(" and (bizinfo.bitFlag & 1) ");
    if (paramBoolean) {}
    for (String str = "!=";; str = "==")
    {
      paramStringBuilder.append(str).append(" 0 ");
      AppMethodBeat.o(124027);
      return;
    }
  }
  
  public static String aFL()
  {
    AppMethodBeat.i(124020);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("rcontact.showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(124020);
    return localObject;
  }
  
  private static String aFM()
  {
    AppMethodBeat.i(124021);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("rcontact.type & 2048 desc, ");
    ((StringBuffer)localObject).append("rcontact.showHead asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
    ((StringBuffer)localObject).append(" else upper(rcontact.quanPin) end asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.quanPin) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.nickname) asc, ");
    ((StringBuffer)localObject).append(" upper(rcontact.username) asc ");
    localObject = ((StringBuffer)localObject).toString();
    AppMethodBeat.o(124021);
    return localObject;
  }
  
  public static List<String> aFN()
  {
    AppMethodBeat.i(124031);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select rcontact.username");
    ((StringBuilder)localObject).append(", bizinfo.enterpriseFather");
    ((StringBuilder)localObject).append(", bizinfo.bitFlag & 1");
    c((StringBuilder)localObject);
    d((StringBuilder)localObject);
    ((StringBuilder)localObject).append(" and (");
    ((StringBuilder)localObject).append(" (bizinfo.bitFlag & 1) != 0");
    ((StringBuilder)localObject).append(" or ");
    ((StringBuilder)localObject).append(" (bizinfo.acceptType & 128) > 0 ");
    ((StringBuilder)localObject).append(" and (bizinfo.brandFlag & 1) == 0) ");
    localObject = ((StringBuilder)localObject).toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[] { localObject });
    localObject = com.tencent.mm.kernel.g.ajR().gDX.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null)
    {
      AppMethodBeat.o(124031);
      return localArrayList;
    }
    if (((Cursor)localObject).moveToNext())
    {
      if (((Cursor)localObject).getInt(2) > 0)
      {
        i = 1;
        label161:
        if (i == 0) {
          break label189;
        }
      }
      label189:
      for (int i = 0;; i = 1)
      {
        localArrayList.add(((Cursor)localObject).getString(i));
        break;
        i = 0;
        break label161;
      }
    }
    ((Cursor)localObject).close();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().hQ(localArrayList);
    AppMethodBeat.o(124031);
    return localObject;
  }
  
  public static List<String> aFO()
  {
    AppMethodBeat.i(124036);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.username");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where bizinfo.specialType = 1");
    ((StringBuilder)localObject1).append(" and rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(an.fuj()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    ae.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[] { localObject2 });
    localObject1 = new ArrayList();
    localObject2 = com.tencent.mm.kernel.g.ajR().gDX.a((String)localObject2, null, 2);
    int i = ((Cursor)localObject2).getColumnIndex("username");
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(i));
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(124036);
    return localObject1;
  }
  
  public static Cursor am(String paramString, int paramInt)
  {
    AppMethodBeat.i(124029);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    a(localStringBuilder, false);
    b(localStringBuilder, true);
    localStringBuilder.append(" and (bizinfo.acceptType & ").append(paramInt).append(") > 0 ");
    localStringBuilder.append(" order by ");
    localStringBuilder.append(aFL());
    paramString = localStringBuilder.toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.g.ajR().gDX.a(paramString, null, 0);
    AppMethodBeat.o(124029);
    return paramString;
  }
  
  private static void b(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124023);
    paramStringBuilder.append("select bizinfo.brandIconURL");
    paramStringBuilder.append(", bizinfo.type");
    paramStringBuilder.append(", bizinfo.status");
    paramStringBuilder.append(", bizinfo.enterpriseFather");
    paramStringBuilder.append(", bizinfo.brandFlag");
    paramStringBuilder.append(", bizinfo.extInfo");
    paramStringBuilder.append(", rcontact.username");
    paramStringBuilder.append(", rcontact.conRemark");
    paramStringBuilder.append(", rcontact.quanPin");
    paramStringBuilder.append(", rcontact.nickname");
    paramStringBuilder.append(", rcontact.alias");
    paramStringBuilder.append(", rcontact.type ");
    AppMethodBeat.o(124023);
  }
  
  private static void b(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(124028);
    paramStringBuilder.append(" and (bizinfo.brandFlag & 1) ");
    if (paramBoolean) {}
    for (String str = "==";; str = "!=")
    {
      paramStringBuilder.append(str).append(" 0 ");
      AppMethodBeat.o(124028);
      return;
    }
  }
  
  public static void c(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124024);
    paramStringBuilder.append(" from rcontact, bizinfo");
    paramStringBuilder.append(" where rcontact.username = bizinfo.username");
    paramStringBuilder.append(" and (rcontact.verifyFlag & ").append(an.fuj()).append(") != 0 ");
    paramStringBuilder.append(" and (rcontact.type & 1) != 0 ");
    AppMethodBeat.o(124024);
  }
  
  public static void d(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124025);
    paramStringBuilder.append(" and bizinfo.type = 3 ");
    AppMethodBeat.o(124025);
  }
  
  public final c Ef(String paramString)
  {
    AppMethodBeat.i(124013);
    c localc = new c();
    localc.field_username = paramString;
    super.get(localc, new String[0]);
    AppMethodBeat.o(124013);
    return localc;
  }
  
  public final Cursor Eg(String paramString)
  {
    AppMethodBeat.i(124030);
    Object localObject = Ei(paramString);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bu.isNullOrNil(Ef(str).KC())) {
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(124030);
      return null;
    }
    localObject = new StringBuilder();
    b((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    b((StringBuilder)localObject, true);
    ((StringBuilder)localObject).append(" and (");
    int i = 0;
    while (i < localArrayList.size())
    {
      paramString = (String)localArrayList.get(i);
      if (i > 0) {
        ((StringBuilder)localObject).append(" or ");
      }
      ((StringBuilder)localObject).append("rcontact.username = '").append(paramString).append("'");
      i += 1;
    }
    ((StringBuilder)localObject).append(") order by ");
    ((StringBuilder)localObject).append(aFM());
    paramString = ((StringBuilder)localObject).toString();
    ae.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.g.ajR().gDX.a(paramString, null, 0);
    AppMethodBeat.o(124030);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124012);
    if (this.hSD != null) {
      this.hSD.remove(parama);
    }
    AppMethodBeat.o(124012);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124011);
    this.hSD.a(parama, paramLooper);
    AppMethodBeat.o(124011);
  }
  
  public final void delete(String paramString)
  {
    AppMethodBeat.i(124014);
    c localc = new c();
    localc.field_username = paramString;
    ae.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(localc, new String[] { "username" })), paramString });
    f.a.b localb = new f.a.b();
    localb.hSG = paramString;
    localb.hSS = f.a.a.hSP;
    localb.hST = localc;
    this.hSD.dW(localb);
    this.hSD.doNotify();
    AppMethodBeat.o(124014);
  }
  
  public final void e(c paramc)
  {
    AppMethodBeat.i(124015);
    ae.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(paramc, new String[] { "username" })), paramc.field_username });
    f.a.b localb = new f.a.b();
    localb.hSG = paramc.field_username;
    localb.hSS = f.a.a.hSP;
    localb.hST = paramc;
    this.hSD.dW(localb);
    this.hSD.doNotify();
    AppMethodBeat.o(124015);
  }
  
  public final boolean f(c paramc)
  {
    AppMethodBeat.i(124016);
    paramc.field_updateTime = System.currentTimeMillis();
    paramc.Kq();
    ae.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[] { paramc.field_username, paramc.field_brandList, Integer.valueOf(paramc.field_brandFlag), paramc.field_brandInfo, paramc.field_extInfo, paramc.field_brandIconURL, Long.valueOf(paramc.field_updateTime) });
    Object localObject = paramc.bX(false);
    if (localObject != null)
    {
      localObject = ((c.b)localObject).KP();
      if (localObject != null) {
        paramc.field_specialType = ((c.b.b)localObject).cRO;
      }
    }
    boolean bool = super.insert(paramc);
    if ((bool) && (!x.wb(paramc.field_username)))
    {
      localObject = new f.a.b();
      ((f.a.b)localObject).hSG = paramc.field_username;
      ((f.a.b)localObject).cRs = paramc.Kr();
      ((f.a.b)localObject).hSS = f.a.a.hSO;
      ((f.a.b)localObject).hST = paramc;
      this.hSD.dW(localObject);
      this.hSD.doNotify();
    }
    AppMethodBeat.o(124016);
    return bool;
  }
  
  public final boolean g(c paramc)
  {
    AppMethodBeat.i(124017);
    paramc.field_updateTime = System.currentTimeMillis();
    paramc.Kq();
    Object localObject = paramc.bX(false);
    if (localObject != null)
    {
      localObject = ((c.b)localObject).KP();
      if (localObject != null) {
        paramc.field_specialType = ((c.b.b)localObject).cRO;
      }
    }
    boolean bool = super.replace(paramc);
    if ((bool) && (!x.wb(paramc.field_username)))
    {
      localObject = new f.a.b();
      ((f.a.b)localObject).hSG = paramc.field_username;
      ((f.a.b)localObject).cRs = paramc.Kr();
      ((f.a.b)localObject).hSS = f.a.a.hSQ;
      ((f.a.b)localObject).hST = paramc;
      this.hSD.dW(localObject);
      this.hSD.doNotify();
    }
    AppMethodBeat.o(124017);
    return bool;
  }
  
  public final List<String> oZ(int paramInt)
  {
    AppMethodBeat.i(124018);
    Object localObject = String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[] { "username", "bizinfo", "acceptType", Integer.valueOf(paramInt) });
    ae.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[] { localObject });
    long l = bu.HQ();
    localObject = rawQuery((String)localObject, new String[0]);
    LinkedList localLinkedList = new LinkedList();
    if (localObject != null)
    {
      if (((Cursor)localObject).moveToFirst()) {
        do
        {
          localLinkedList.add(((Cursor)localObject).getString(0));
        } while (((Cursor)localObject).moveToNext());
      }
      ((Cursor)localObject).close();
      ae.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bu.aO(l)) });
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().hQ(localLinkedList);
      AppMethodBeat.o(124018);
      return localObject;
    }
    ae.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bu.aO(l)) });
    AppMethodBeat.o(124018);
    return localLinkedList;
  }
  
  public final int pa(int paramInt)
  {
    AppMethodBeat.i(124019);
    List localList = oZ(paramInt);
    if (bu.ht(localList))
    {
      AppMethodBeat.o(124019);
      return 0;
    }
    paramInt = localList.size();
    AppMethodBeat.o(124019);
    return paramInt;
  }
  
  public static abstract interface a
  {
    public abstract void a(b paramb);
    
    public static enum a
    {
      static
      {
        AppMethodBeat.i(124009);
        hSO = new a("INSTERT", 0);
        hSP = new a("DELETE", 1);
        hSQ = new a("UPDATE", 2);
        hSR = new a[] { hSO, hSP, hSQ };
        AppMethodBeat.o(124009);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public boolean cRs;
      public String hSG;
      public f.a.a hSS;
      public c hST;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.f
 * JD-Core Version:    0.7.0.1
 */
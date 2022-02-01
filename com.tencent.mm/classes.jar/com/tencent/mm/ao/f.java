package com.tencent.mm.ao;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.f.c.bb;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorageEvent;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class f
  extends MAutoStorage<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static Map<String, String> lEs;
  private final MStorageEvent<a, f.a.b> lEj;
  
  static
  {
    AppMethodBeat.i(124042);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "bizinfo") };
    lEs = new HashMap();
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) " };
    AppMethodBeat.o(124042);
  }
  
  public f(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "bizinfo", INDEX_CREATE);
    AppMethodBeat.i(124010);
    this.lEj = new MStorageEvent() {};
    AppMethodBeat.o(124010);
  }
  
  public static Cursor Q(String paramString, boolean paramBoolean)
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
      paramString = g.UH(paramString);
      if (!paramString.isEmpty()) {
        a(localStringBuilder, paramString);
      }
      label59:
      localStringBuilder.append(" order by ");
      localStringBuilder.append(biU());
      paramString = localStringBuilder.toString();
      Log.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[] { paramString });
      paramString = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString, null);
      AppMethodBeat.o(124032);
      return paramString;
    }
    catch (Throwable paramString)
    {
      break label59;
    }
  }
  
  public static Cursor Ur(String paramString)
  {
    AppMethodBeat.i(124033);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, false);
    a(localStringBuilder, false);
    localStringBuilder.append(" order by ");
    localStringBuilder.append(biU());
    paramString = localStringBuilder.toString();
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString, null);
    AppMethodBeat.o(124033);
    return paramString;
  }
  
  public static List<String> Us(String paramString)
  {
    AppMethodBeat.i(124034);
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    paramString = ((StringBuilder)localObject).toString();
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString, null, 2);
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
  
  public static String Ut(String paramString)
  {
    AppMethodBeat.i(124035);
    if (Util.isNullOrNil(paramString))
    {
      Log.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
      AppMethodBeat.o(124035);
      return null;
    }
    if ((lEs != null) && (lEs.containsKey(paramString)))
    {
      paramString = (String)lEs.get(paramString);
      if ((!Util.isNullOrNil(paramString)) && (ab.Ql(paramString)))
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
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[] { localObject });
    Cursor localCursor = com.tencent.mm.kernel.h.aHG().kcF.rawQuery((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(124035);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = localCursor.getString(0);
      lEs.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localCursor.close();
      AppMethodBeat.o(124035);
      return paramString;
    }
  }
  
  public static boolean Uu(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124037);
    if ((Util.isNullOrNil(paramString)) || (!g.UD(paramString)))
    {
      AppMethodBeat.o(124037);
      return false;
    }
    Object localObject1 = g.gu(paramString);
    Object localObject2;
    if ((((c)localObject1).dc(false) != null) && (((c)localObject1).dc(false).Zz() != null) && (!Util.isNullOrNil(((c)localObject1).Zf())))
    {
      localObject2 = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwL(((c)localObject1).Zf());
      if ((localObject2 != null) && (((bb)localObject2).field_username.equals(paramString)) && (((bb)localObject2).field_unReadCount > 0)) {
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwz(((c)localObject1).Zf());
      }
    }
    localObject1 = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOR(paramString);
    ((Cursor)localObject1).moveToFirst();
    while (!((Cursor)localObject1).isAfterLast())
    {
      localObject2 = new ca();
      ((ca)localObject2).convertFrom((Cursor)localObject1);
      ((ca)localObject2).setStatus(4);
      Log.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + ((et)localObject2).field_msgSvrId + " status = " + ((et)localObject2).field_status);
      ((Cursor)localObject1).moveToNext();
      bool = true;
    }
    ((Cursor)localObject1).close();
    if (bool)
    {
      ((n)com.tencent.mm.kernel.h.ae(n.class)).bbR().bwz(paramString);
      ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().aOP(paramString);
    }
    AppMethodBeat.o(124037);
    return bool;
  }
  
  public static void Uv(String paramString)
  {
    AppMethodBeat.i(124038);
    if ((Util.isNullOrNil(paramString)) || (!g.UD(paramString)))
    {
      AppMethodBeat.o(124038);
      return;
    }
    ((a)com.tencent.mm.kernel.h.ag(a.class)).getNotification().JP(paramString);
    ((a)com.tencent.mm.kernel.h.ag(a.class)).getNotification().abF();
    AppMethodBeat.o(124038);
  }
  
  public static void Uw(String paramString)
  {
    AppMethodBeat.i(124039);
    if ((Util.isNullOrNil(paramString)) || (!g.UD(paramString)))
    {
      AppMethodBeat.o(124039);
      return;
    }
    ((a)com.tencent.mm.kernel.h.ag(a.class)).getNotification().JP("");
    AppMethodBeat.o(124039);
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
    AppMethodBeat.i(205232);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(205232);
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
    AppMethodBeat.o(205232);
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
  
  public static Cursor aI(String paramString, int paramInt)
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
    localStringBuilder.append(biT());
    paramString = localStringBuilder.toString();
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString, null);
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
  
  public static String biT()
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
  
  private static String biU()
  {
    AppMethodBeat.i(124021);
    Object localObject = new StringBuffer();
    ((StringBuffer)localObject).append("rcontact.type & 2048").append(" desc, ");
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
  
  public static List<String> biV()
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
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[] { localObject });
    localObject = com.tencent.mm.kernel.h.aHG().kcF.rawQuery((String)localObject, null, 2);
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
    localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jM(localArrayList);
    AppMethodBeat.o(124031);
    return localObject;
  }
  
  public static List<String> biW()
  {
    AppMethodBeat.i(124036);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.username");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where bizinfo.specialType = 1");
    ((StringBuilder)localObject1).append(" and rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(as.hya()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    Log.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[] { localObject2 });
    localObject1 = new ArrayList();
    localObject2 = com.tencent.mm.kernel.h.aHG().kcF.rawQuery((String)localObject2, null, 2);
    int i = ((Cursor)localObject2).getColumnIndex("username");
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(i));
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(124036);
    return localObject1;
  }
  
  public static void c(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124024);
    paramStringBuilder.append(" from rcontact, bizinfo");
    paramStringBuilder.append(" where rcontact.username = bizinfo.username");
    paramStringBuilder.append(" and (rcontact.verifyFlag & ").append(as.hya()).append(") != 0 ");
    paramStringBuilder.append(" and (rcontact.type & 1) != 0 ");
    AppMethodBeat.o(124024);
  }
  
  public static void d(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124025);
    paramStringBuilder.append(" and bizinfo.type = 3 ");
    AppMethodBeat.o(124025);
  }
  
  public final c Uo(String paramString)
  {
    AppMethodBeat.i(124013);
    c localc = new c();
    localc.field_username = paramString;
    super.get(localc, new String[0]);
    AppMethodBeat.o(124013);
    return localc;
  }
  
  public final void Up(String paramString)
  {
    AppMethodBeat.i(124014);
    c localc = new c();
    localc.field_username = paramString;
    Log.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(localc, new String[] { "username" })), paramString });
    f.a.b localb = new f.a.b();
    localb.lEm = paramString;
    localb.lEy = f.a.a.lEv;
    localb.lEz = localc;
    this.lEj.event(localb);
    this.lEj.doNotify();
    AppMethodBeat.o(124014);
  }
  
  public final Cursor Uq(String paramString)
  {
    AppMethodBeat.i(124030);
    Object localObject = Us(paramString);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!Util.isNullOrNil(Uo(str).Ze())) {
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
    ((StringBuilder)localObject).append(biU());
    paramString = ((StringBuilder)localObject).toString();
    Log.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.h.aHG().kcF.rawQuery(paramString, null);
    AppMethodBeat.o(124030);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124012);
    if (this.lEj != null) {
      this.lEj.remove(parama);
    }
    AppMethodBeat.o(124012);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124011);
    this.lEj.add(parama, paramLooper);
    AppMethodBeat.o(124011);
  }
  
  public final void f(c paramc)
  {
    AppMethodBeat.i(124015);
    Log.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(paramc, new String[] { "username" })), paramc.field_username });
    f.a.b localb = new f.a.b();
    localb.lEm = paramc.field_username;
    localb.lEy = f.a.a.lEv;
    localb.lEz = paramc;
    this.lEj.event(localb);
    this.lEj.doNotify();
    AppMethodBeat.o(124015);
  }
  
  public final boolean g(c paramc)
  {
    AppMethodBeat.i(124016);
    paramc.field_updateTime = System.currentTimeMillis();
    paramc.YS();
    Log.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[] { paramc.field_username, paramc.field_brandList, Integer.valueOf(paramc.field_brandFlag), paramc.field_brandInfo, paramc.field_extInfo, paramc.field_brandIconURL, Long.valueOf(paramc.field_updateTime) });
    Object localObject = paramc.dc(false);
    if (localObject != null)
    {
      localObject = ((c.b)localObject).Zr();
      if (localObject != null) {
        paramc.field_specialType = ((c.b.b)localObject).eZO;
      }
    }
    boolean bool = super.insert(paramc);
    if ((bool) && (!ab.Lj(paramc.field_username)))
    {
      localObject = new f.a.b();
      ((f.a.b)localObject).lEm = paramc.field_username;
      ((f.a.b)localObject).eZt = paramc.YT();
      ((f.a.b)localObject).lEy = f.a.a.lEu;
      ((f.a.b)localObject).lEz = paramc;
      this.lEj.event(localObject);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124016);
    return bool;
  }
  
  public final boolean h(c paramc)
  {
    AppMethodBeat.i(124017);
    paramc.field_updateTime = System.currentTimeMillis();
    paramc.YS();
    Object localObject = paramc.dc(false);
    if (localObject != null)
    {
      localObject = ((c.b)localObject).Zr();
      if (localObject != null) {
        paramc.field_specialType = ((c.b.b)localObject).eZO;
      }
    }
    boolean bool = super.replace(paramc);
    if ((bool) && (!ab.Lj(paramc.field_username)))
    {
      localObject = new f.a.b();
      ((f.a.b)localObject).lEm = paramc.field_username;
      ((f.a.b)localObject).eZt = paramc.YT();
      ((f.a.b)localObject).lEy = f.a.a.lEw;
      ((f.a.b)localObject).lEz = paramc;
      this.lEj.event(localObject);
      this.lEj.doNotify();
    }
    AppMethodBeat.o(124017);
    return bool;
  }
  
  public final List<String> vK(int paramInt)
  {
    AppMethodBeat.i(124018);
    Object localObject = String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[] { "username", "bizinfo", "acceptType", Integer.valueOf(paramInt) });
    Log.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[] { localObject });
    long l = Util.currentTicks();
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
      Log.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Util.ticksToNow(l)) });
      localObject = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().jM(localLinkedList);
      AppMethodBeat.o(124018);
      return localObject;
    }
    Log.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Util.ticksToNow(l)) });
    AppMethodBeat.o(124018);
    return localLinkedList;
  }
  
  public final int vL(int paramInt)
  {
    AppMethodBeat.i(124019);
    List localList = vK(paramInt);
    if (Util.isNullOrNil(localList))
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
        lEu = new a("INSTERT", 0);
        lEv = new a("DELETE", 1);
        lEw = new a("UPDATE", 2);
        lEx = new a[] { lEu, lEv, lEw };
        AppMethodBeat.o(124009);
      }
      
      private a() {}
    }
    
    public static final class b
    {
      public boolean eZt;
      public String lEm;
      public f.a.a lEy;
      public c lEz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ao.f
 * JD-Core Version:    0.7.0.1
 */
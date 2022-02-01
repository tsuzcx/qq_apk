package com.tencent.mm.al;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.c;
import com.tencent.mm.api.c.b;
import com.tencent.mm.api.c.b.b;
import com.tencent.mm.g.c.az;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.bk;
import com.tencent.mm.storage.bo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e
  extends j<c>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static Map<String, String> hxz;
  private final l<a, e.a.b> hxq;
  
  static
  {
    AppMethodBeat.i(124042);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "bizinfo") };
    hxz = new HashMap();
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) " };
    AppMethodBeat.o(124042);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, c.info, "bizinfo", INDEX_CREATE);
    AppMethodBeat.i(124010);
    this.hxq = new l() {};
    AppMethodBeat.o(124010);
  }
  
  public static Cursor AG(String paramString)
  {
    AppMethodBeat.i(124033);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, false);
    a(localStringBuilder, false);
    localStringBuilder.append(" order by ");
    localStringBuilder.append(aCt());
    paramString = localStringBuilder.toString();
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[] { paramString });
    paramString = g.agR().ghG.a(paramString, null, 0);
    AppMethodBeat.o(124033);
    return paramString;
  }
  
  public static List<String> AH(String paramString)
  {
    AppMethodBeat.i(124034);
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    paramString = ((StringBuilder)localObject).toString();
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[] { paramString });
    paramString = g.agR().ghG.a(paramString, null, 2);
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
  
  public static String AI(String paramString)
  {
    AppMethodBeat.i(124035);
    if (bs.isNullOrNil(paramString))
    {
      ac.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
      AppMethodBeat.o(124035);
      return null;
    }
    if ((hxz != null) && (hxz.containsKey(paramString)))
    {
      paramString = (String)hxz.get(paramString);
      if ((!bs.isNullOrNil(paramString)) && (w.wG(paramString)))
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
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[] { localObject });
    Cursor localCursor = g.agR().ghG.a((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(124035);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = localCursor.getString(0);
      hxz.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localCursor.close();
      AppMethodBeat.o(124035);
      return paramString;
    }
  }
  
  public static boolean AJ(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(124037);
    if ((bs.isNullOrNil(paramString)) || (!f.AS(paramString)))
    {
      AppMethodBeat.o(124037);
      return false;
    }
    Object localObject1 = f.dX(paramString);
    Object localObject2;
    if ((((c)localObject1).bV(false) != null) && (((c)localObject1).bV(false).Jq() != null) && (!bs.isNullOrNil(((c)localObject1).IV())))
    {
      localObject2 = ((k)g.ab(k.class)).awG().aNW(((c)localObject1).IV());
      if ((localObject2 != null) && (((az)localObject2).field_username.equals(paramString)) && (((az)localObject2).field_unReadCount > 0)) {
        ((k)g.ab(k.class)).awG().aNK(((c)localObject1).IV());
      }
    }
    localObject1 = ((k)g.ab(k.class)).dcr().alt(paramString);
    ((Cursor)localObject1).moveToFirst();
    while (!((Cursor)localObject1).isAfterLast())
    {
      localObject2 = new bo();
      ((bo)localObject2).convertFrom((Cursor)localObject1);
      ((bo)localObject2).setStatus(4);
      ac.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + ((dy)localObject2).field_msgSvrId + " status = " + ((dy)localObject2).field_status);
      ((Cursor)localObject1).moveToNext();
      bool = true;
    }
    ((Cursor)localObject1).close();
    if (bool)
    {
      ((k)g.ab(k.class)).awG().aNK(paramString);
      ((k)g.ab(k.class)).dcr().alr(paramString);
    }
    AppMethodBeat.o(124037);
    return bool;
  }
  
  public static void AK(String paramString)
  {
    AppMethodBeat.i(124038);
    if ((bs.isNullOrNil(paramString)) || (!f.AS(paramString)))
    {
      AppMethodBeat.o(124038);
      return;
    }
    ((a)g.ad(a.class)).getNotification().rA(paramString);
    ((a)g.ad(a.class)).getNotification().Lm();
    AppMethodBeat.o(124038);
  }
  
  public static void AL(String paramString)
  {
    AppMethodBeat.i(124039);
    if ((bs.isNullOrNil(paramString)) || (!f.AS(paramString)))
    {
      AppMethodBeat.o(124039);
      return;
    }
    ((a)g.ad(a.class)).getNotification().rA("");
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
      paramString = f.AW(paramString);
      if (!paramString.isEmpty()) {
        a(localStringBuilder, paramString);
      }
      label60:
      localStringBuilder.append(" order by ");
      localStringBuilder.append(aCt());
      paramString = localStringBuilder.toString();
      ac.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[] { paramString });
      paramString = g.agR().ghG.a(paramString, null, 0);
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
    AppMethodBeat.i(209522);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(209522);
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
    AppMethodBeat.o(209522);
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
  
  public static String aCs()
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
  
  private static String aCt()
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
  
  public static List<String> aCu()
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
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[] { localObject });
    localObject = g.agR().ghG.a((String)localObject, null, 2);
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
    localObject = ((k)g.ab(k.class)).awB().hu(localArrayList);
    AppMethodBeat.o(124031);
    return localObject;
  }
  
  public static List<String> aCv()
  {
    AppMethodBeat.i(124036);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.username");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where bizinfo.specialType = 1");
    ((StringBuilder)localObject1).append(" and rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(ai.fag()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    ac.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[] { localObject2 });
    localObject1 = new ArrayList();
    localObject2 = g.agR().ghG.a((String)localObject2, null, 2);
    int i = ((Cursor)localObject2).getColumnIndex("username");
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(i));
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(124036);
    return localObject1;
  }
  
  public static Cursor ah(String paramString, int paramInt)
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
    localStringBuilder.append(aCs());
    paramString = localStringBuilder.toString();
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[] { paramString });
    paramString = g.agR().ghG.a(paramString, null, 0);
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
    paramStringBuilder.append(" and (rcontact.verifyFlag & ").append(ai.fag()).append(") != 0 ");
    paramStringBuilder.append(" and (rcontact.type & 1) != 0 ");
    AppMethodBeat.o(124024);
  }
  
  public static void d(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(124025);
    paramStringBuilder.append(" and bizinfo.type = 3 ");
    AppMethodBeat.o(124025);
  }
  
  public final c AE(String paramString)
  {
    AppMethodBeat.i(124013);
    c localc = new c();
    localc.field_username = paramString;
    super.get(localc, new String[0]);
    AppMethodBeat.o(124013);
    return localc;
  }
  
  public final Cursor AF(String paramString)
  {
    AppMethodBeat.i(124030);
    Object localObject = AH(paramString);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bs.isNullOrNil(AE(str).IU())) {
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
    ((StringBuilder)localObject).append(aCt());
    paramString = ((StringBuilder)localObject).toString();
    ac.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[] { paramString });
    paramString = g.agR().ghG.a(paramString, null, 0);
    AppMethodBeat.o(124030);
    return paramString;
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(124012);
    if (this.hxq != null) {
      this.hxq.remove(parama);
    }
    AppMethodBeat.o(124012);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(124011);
    this.hxq.a(parama, paramLooper);
    AppMethodBeat.o(124011);
  }
  
  public final void delete(String paramString)
  {
    AppMethodBeat.i(124014);
    c localc = new c();
    localc.field_username = paramString;
    ac.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(localc, new String[] { "username" })), paramString });
    e.a.b localb = new e.a.b();
    localb.hxt = paramString;
    localb.hxF = e.a.a.hxC;
    localb.hxG = localc;
    this.hxq.dS(localb);
    this.hxq.doNotify();
    AppMethodBeat.o(124014);
  }
  
  public final void e(c paramc)
  {
    AppMethodBeat.i(124015);
    ac.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(paramc, new String[] { "username" })), paramc.field_username });
    e.a.b localb = new e.a.b();
    localb.hxt = paramc.field_username;
    localb.hxF = e.a.a.hxC;
    localb.hxG = paramc;
    this.hxq.dS(localb);
    this.hxq.doNotify();
    AppMethodBeat.o(124015);
  }
  
  public final boolean f(c paramc)
  {
    AppMethodBeat.i(124016);
    paramc.field_updateTime = System.currentTimeMillis();
    paramc.II();
    ac.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[] { paramc.field_username, paramc.field_brandList, Integer.valueOf(paramc.field_brandFlag), paramc.field_brandInfo, paramc.field_extInfo, paramc.field_brandIconURL, Long.valueOf(paramc.field_updateTime) });
    Object localObject = paramc.bV(false);
    if (localObject != null)
    {
      localObject = ((c.b)localObject).Jh();
      if (localObject != null) {
        paramc.field_specialType = ((c.b.b)localObject).cFZ;
      }
    }
    boolean bool = super.insert(paramc);
    if ((bool) && (!w.sQ(paramc.field_username)))
    {
      localObject = new e.a.b();
      ((e.a.b)localObject).hxt = paramc.field_username;
      ((e.a.b)localObject).cFD = paramc.IJ();
      ((e.a.b)localObject).hxF = e.a.a.hxB;
      ((e.a.b)localObject).hxG = paramc;
      this.hxq.dS(localObject);
      this.hxq.doNotify();
    }
    AppMethodBeat.o(124016);
    return bool;
  }
  
  public final boolean g(c paramc)
  {
    AppMethodBeat.i(124017);
    paramc.field_updateTime = System.currentTimeMillis();
    paramc.II();
    Object localObject = paramc.bV(false);
    if (localObject != null)
    {
      localObject = ((c.b)localObject).Jh();
      if (localObject != null) {
        paramc.field_specialType = ((c.b.b)localObject).cFZ;
      }
    }
    boolean bool = super.replace(paramc);
    if ((bool) && (!w.sQ(paramc.field_username)))
    {
      localObject = new e.a.b();
      ((e.a.b)localObject).hxt = paramc.field_username;
      ((e.a.b)localObject).cFD = paramc.IJ();
      ((e.a.b)localObject).hxF = e.a.a.hxD;
      ((e.a.b)localObject).hxG = paramc;
      this.hxq.dS(localObject);
      this.hxq.doNotify();
    }
    AppMethodBeat.o(124017);
    return bool;
  }
  
  public final List<String> ov(int paramInt)
  {
    AppMethodBeat.i(124018);
    Object localObject = String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[] { "username", "bizinfo", "acceptType", Integer.valueOf(paramInt) });
    ac.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[] { localObject });
    long l = bs.Gn();
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
      ac.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bs.aO(l)) });
      localObject = ((k)g.ab(k.class)).awB().hu(localLinkedList);
      AppMethodBeat.o(124018);
      return localObject;
    }
    ac.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bs.aO(l)) });
    AppMethodBeat.o(124018);
    return localLinkedList;
  }
  
  public final int ow(int paramInt)
  {
    AppMethodBeat.i(124019);
    List localList = ov(paramInt);
    if (bs.gY(localList))
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
    
    public static final class b
    {
      public boolean cFD;
      public e.a.a hxF;
      public c hxG;
      public String hxt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.al.e
 * JD-Core Version:    0.7.0.1
 */
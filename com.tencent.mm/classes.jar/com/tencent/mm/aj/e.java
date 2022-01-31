package com.tencent.mm.aj;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.an;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.be;
import com.tencent.mm.storage.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class e
  extends com.tencent.mm.sdk.e.j<d>
{
  public static final String[] INDEX_CREATE;
  public static final String[] SQL_CREATE;
  public static Map<String, String> fwe;
  private final l<a, e.a.b> fuL;
  
  static
  {
    AppMethodBeat.i(11358);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(d.info, "bizinfo") };
    fwe = new HashMap();
    INDEX_CREATE = new String[] { "CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) " };
    AppMethodBeat.o(11358);
  }
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.info, "bizinfo", INDEX_CREATE);
    AppMethodBeat.i(11326);
    this.fuL = new e.1(this);
    AppMethodBeat.o(11326);
  }
  
  public static Cursor G(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(11348);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, true);
    if (paramBoolean) {
      a(localStringBuilder, false);
    }
    localStringBuilder.append(" order by ");
    localStringBuilder.append(aeL());
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[] { paramString });
    paramString = g.RL().eHS.a(paramString, null, 0);
    AppMethodBeat.o(11348);
    return paramString;
  }
  
  public static Cursor V(String paramString, int paramInt)
  {
    AppMethodBeat.i(11345);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    a(localStringBuilder, false);
    b(localStringBuilder, true);
    localStringBuilder.append(" and (bizinfo.acceptType & ").append(paramInt).append(") > 0 ");
    localStringBuilder.append(" order by ");
    localStringBuilder.append(aeK());
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[] { paramString });
    paramString = g.RL().eHS.a(paramString, null, 0);
    AppMethodBeat.o(11345);
    return paramString;
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(11338);
    paramStringBuilder.append("select bizinfo.username ");
    AppMethodBeat.o(11338);
  }
  
  private static void a(StringBuilder paramStringBuilder, String paramString)
  {
    AppMethodBeat.i(11342);
    paramStringBuilder.append(" and bizinfo.type = 3");
    paramStringBuilder.append(" and bizinfo.enterpriseFather = '").append(paramString).append("' ");
    AppMethodBeat.o(11342);
  }
  
  public static void a(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(11343);
    paramStringBuilder.append(" and (bizinfo.bitFlag & 1) ");
    if (paramBoolean) {}
    for (String str = "!=";; str = "==")
    {
      paramStringBuilder.append(str).append(" 0 ");
      AppMethodBeat.o(11343);
      return;
    }
  }
  
  public static String aeK()
  {
    AppMethodBeat.i(11336);
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
    AppMethodBeat.o(11336);
    return localObject;
  }
  
  private static String aeL()
  {
    AppMethodBeat.i(11337);
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
    AppMethodBeat.o(11337);
    return localObject;
  }
  
  public static List<String> aeM()
  {
    AppMethodBeat.i(11347);
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
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[] { localObject });
    localObject = g.RL().eHS.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null)
    {
      AppMethodBeat.o(11347);
      return localArrayList;
    }
    if (((Cursor)localObject).moveToNext())
    {
      if (((Cursor)localObject).getInt(2) > 0)
      {
        i = 1;
        label152:
        if (i == 0) {
          break label180;
        }
      }
      label180:
      for (int i = 0;; i = 1)
      {
        localArrayList.add(((Cursor)localObject).getString(i));
        break;
        i = 0;
        break label152;
      }
    }
    ((Cursor)localObject).close();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().eM(localArrayList);
    AppMethodBeat.o(11347);
    return localObject;
  }
  
  public static List<String> aeN()
  {
    AppMethodBeat.i(11352);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.username");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where bizinfo.specialType = 1");
    ((StringBuilder)localObject1).append(" and rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(ad.dwB()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    ab.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[] { localObject2 });
    localObject1 = new ArrayList();
    localObject2 = g.RL().eHS.a((String)localObject2, null, 2);
    int i = ((Cursor)localObject2).getColumnIndex("username");
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(i));
    }
    ((Cursor)localObject2).close();
    AppMethodBeat.o(11352);
    return localObject1;
  }
  
  private static void b(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(11339);
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
    AppMethodBeat.o(11339);
  }
  
  private static void b(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    AppMethodBeat.i(11344);
    paramStringBuilder.append(" and (bizinfo.brandFlag & 1) ");
    if (paramBoolean) {}
    for (String str = "==";; str = "!=")
    {
      paramStringBuilder.append(str).append(" 0 ");
      AppMethodBeat.o(11344);
      return;
    }
  }
  
  public static void c(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(11340);
    paramStringBuilder.append(" from rcontact, bizinfo");
    paramStringBuilder.append(" where rcontact.username = bizinfo.username");
    paramStringBuilder.append(" and (rcontact.verifyFlag & ").append(ad.dwB()).append(") != 0 ");
    paramStringBuilder.append(" and (rcontact.type & 1) != 0 ");
    AppMethodBeat.o(11340);
  }
  
  public static void d(StringBuilder paramStringBuilder)
  {
    AppMethodBeat.i(11341);
    paramStringBuilder.append(" and bizinfo.type = 3 ");
    AppMethodBeat.o(11341);
  }
  
  public static Cursor rM(String paramString)
  {
    AppMethodBeat.i(11349);
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, false);
    a(localStringBuilder, false);
    localStringBuilder.append(" order by ");
    localStringBuilder.append(aeL());
    paramString = localStringBuilder.toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseDisableChild sql %s", new Object[] { paramString });
    paramString = g.RL().eHS.a(paramString, null, 0);
    AppMethodBeat.o(11349);
    return paramString;
  }
  
  public static List<String> rN(String paramString)
  {
    AppMethodBeat.i(11350);
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    paramString = ((StringBuilder)localObject).toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[] { paramString });
    paramString = g.RL().eHS.a(paramString, null, 2);
    if (paramString == null)
    {
      AppMethodBeat.o(11350);
      return null;
    }
    localObject = new ArrayList();
    while (paramString.moveToNext()) {
      ((List)localObject).add(paramString.getString(0));
    }
    paramString.close();
    AppMethodBeat.o(11350);
    return localObject;
  }
  
  public static String rO(String paramString)
  {
    AppMethodBeat.i(11351);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
      AppMethodBeat.o(11351);
      return null;
    }
    if ((fwe != null) && (fwe.containsKey(paramString)))
    {
      paramString = (String)fwe.get(paramString);
      if ((!bo.isNullOrNil(paramString)) && (t.nT(paramString)))
      {
        AppMethodBeat.o(11351);
        return paramString;
      }
      AppMethodBeat.o(11351);
      return null;
    }
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    a((StringBuilder)localObject, true);
    localObject = ((StringBuilder)localObject).toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[] { localObject });
    Cursor localCursor = g.RL().eHS.a((String)localObject, null, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(11351);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localObject = localCursor.getString(0);
      fwe.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localCursor.close();
      AppMethodBeat.o(11351);
      return paramString;
    }
  }
  
  public static boolean rP(String paramString)
  {
    boolean bool = false;
    AppMethodBeat.i(11353);
    if ((bo.isNullOrNil(paramString)) || (!f.rY(paramString)))
    {
      AppMethodBeat.o(11353);
      return false;
    }
    Object localObject1 = f.rS(paramString);
    Object localObject2;
    if ((((d)localObject1).cU(false) != null) && (((d)localObject1).cU(false).aeI() != null) && (!bo.isNullOrNil(((d)localObject1).aeo())))
    {
      localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arU(((d)localObject1).aeo());
      if ((localObject2 != null) && (((au)localObject2).field_username.equals(paramString)) && (((au)localObject2).field_unReadCount > 0)) {
        ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arJ(((d)localObject1).aeo());
      }
    }
    localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tv(paramString);
    ((Cursor)localObject1).moveToFirst();
    while (!((Cursor)localObject1).isAfterLast())
    {
      localObject2 = new bi();
      ((bi)localObject2).convertFrom((Cursor)localObject1);
      ((bi)localObject2).setStatus(4);
      ab.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + ((dd)localObject2).field_msgSvrId + " status = " + ((dd)localObject2).field_status);
      ((Cursor)localObject1).moveToNext();
      bool = true;
    }
    ((Cursor)localObject1).close();
    if (bool)
    {
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YF().arJ(paramString);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).bPQ().Tt(paramString);
    }
    AppMethodBeat.o(11353);
    return bool;
  }
  
  public static void rQ(String paramString)
  {
    AppMethodBeat.i(11354);
    if ((bo.isNullOrNil(paramString)) || (!f.rY(paramString)))
    {
      AppMethodBeat.o(11354);
      return;
    }
    ((a)g.G(a.class)).getNotification().kD(paramString);
    ((a)g.G(a.class)).getNotification().BR();
    AppMethodBeat.o(11354);
  }
  
  public static void rR(String paramString)
  {
    AppMethodBeat.i(11355);
    if ((bo.isNullOrNil(paramString)) || (!f.rY(paramString)))
    {
      AppMethodBeat.o(11355);
      return;
    }
    ((a)g.G(a.class)).getNotification().kD("");
    AppMethodBeat.o(11355);
  }
  
  public final void a(a parama)
  {
    AppMethodBeat.i(11328);
    if (this.fuL != null) {
      this.fuL.remove(parama);
    }
    AppMethodBeat.o(11328);
  }
  
  public final void a(a parama, Looper paramLooper)
  {
    AppMethodBeat.i(11327);
    this.fuL.a(parama, paramLooper);
    AppMethodBeat.o(11327);
  }
  
  public final void c(d paramd)
  {
    AppMethodBeat.i(11331);
    ab.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(paramd, new String[] { "username" })), paramd.field_username });
    e.a.b localb = new e.a.b();
    localb.fuO = paramd.field_username;
    localb.fwk = e.a.a.fwh;
    localb.fwl = paramd;
    this.fuL.cy(localb);
    this.fuL.doNotify();
    AppMethodBeat.o(11331);
  }
  
  public final boolean d(d paramd)
  {
    AppMethodBeat.i(11332);
    paramd.field_updateTime = System.currentTimeMillis();
    paramd.aeb();
    ab.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[] { paramd.field_username, paramd.field_brandList, Integer.valueOf(paramd.field_brandFlag), paramd.field_brandInfo, paramd.field_extInfo, paramd.field_brandIconURL, Long.valueOf(paramd.field_updateTime) });
    Object localObject = paramd.cU(false);
    if (localObject != null)
    {
      localObject = ((d.b)localObject).aeA();
      if (localObject != null) {
        paramd.field_specialType = ((d.b.b)localObject).fvJ;
      }
    }
    boolean bool = super.insert(paramd);
    if ((bool) && (!t.lA(paramd.field_username)))
    {
      localObject = new e.a.b();
      ((e.a.b)localObject).fuO = paramd.field_username;
      ((e.a.b)localObject).fvo = paramd.aec();
      ((e.a.b)localObject).fwk = e.a.a.fwg;
      ((e.a.b)localObject).fwl = paramd;
      this.fuL.cy(localObject);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11332);
    return bool;
  }
  
  public final void delete(String paramString)
  {
    AppMethodBeat.i(11330);
    d locald = new d();
    locald.field_username = paramString;
    ab.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.delete(locald, new String[] { "username" })), paramString });
    e.a.b localb = new e.a.b();
    localb.fuO = paramString;
    localb.fwk = e.a.a.fwh;
    localb.fwl = locald;
    this.fuL.cy(localb);
    this.fuL.doNotify();
    AppMethodBeat.o(11330);
  }
  
  public final boolean e(d paramd)
  {
    AppMethodBeat.i(11333);
    paramd.field_updateTime = System.currentTimeMillis();
    paramd.aeb();
    Object localObject = paramd.cU(false);
    if (localObject != null)
    {
      localObject = ((d.b)localObject).aeA();
      if (localObject != null) {
        paramd.field_specialType = ((d.b.b)localObject).fvJ;
      }
    }
    boolean bool = super.replace(paramd);
    if ((bool) && (!t.lA(paramd.field_username)))
    {
      localObject = new e.a.b();
      ((e.a.b)localObject).fuO = paramd.field_username;
      ((e.a.b)localObject).fvo = paramd.aec();
      ((e.a.b)localObject).fwk = e.a.a.fwi;
      ((e.a.b)localObject).fwl = paramd;
      this.fuL.cy(localObject);
      this.fuL.doNotify();
    }
    AppMethodBeat.o(11333);
    return bool;
  }
  
  public final List<String> la(int paramInt)
  {
    AppMethodBeat.i(11334);
    Object localObject = String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[] { "username", "bizinfo", "acceptType", Integer.valueOf(paramInt) });
    ab.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[] { localObject });
    long l = bo.yB();
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
      ab.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bo.av(l)) });
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().eM(localLinkedList);
      AppMethodBeat.o(11334);
      return localObject;
    }
    ab.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bo.av(l)) });
    AppMethodBeat.o(11334);
    return localLinkedList;
  }
  
  public final int lb(int paramInt)
  {
    AppMethodBeat.i(11335);
    List localList = la(paramInt);
    if (bo.es(localList))
    {
      AppMethodBeat.o(11335);
      return 0;
    }
    paramInt = localList.size();
    AppMethodBeat.o(11335);
    return paramInt;
  }
  
  public final d rK(String paramString)
  {
    AppMethodBeat.i(11329);
    d locald = new d();
    locald.field_username = paramString;
    super.get(locald, new String[0]);
    AppMethodBeat.o(11329);
    return locald;
  }
  
  public final Cursor rL(String paramString)
  {
    AppMethodBeat.i(11346);
    Object localObject = rN(paramString);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bo.isNullOrNil(rK(str).aen())) {
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() <= 0)
    {
      AppMethodBeat.o(11346);
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
    ((StringBuilder)localObject).append(aeL());
    paramString = ((StringBuilder)localObject).toString();
    ab.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[] { paramString });
    paramString = g.RL().eHS.a(paramString, null, 0);
    AppMethodBeat.o(11346);
    return paramString;
  }
  
  public static abstract interface a
  {
    public abstract void a(e.a.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.aj.e
 * JD-Core Version:    0.7.0.1
 */
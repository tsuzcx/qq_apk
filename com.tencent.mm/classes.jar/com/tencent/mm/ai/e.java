package com.tencent.mm.ai;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.cf.h;
import com.tencent.mm.h.c.as;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.al;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.plugin.notification.b.a;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
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
  extends i<d>
{
  public static final String[] cqY = { "CREATE  INDEX IF NOT EXISTS type_username_index ON bizinfo ( type,username ) ", "CREATE  INDEX IF NOT EXISTS  username_acceptType_index ON bizinfo ( username,acceptType ) " };
  public static final String[] dXp = { i.a(d.buS, "bizinfo") };
  public static Map<String, String> egc = new HashMap();
  private final k<e.a, e.a.b> eeJ = new e.1(this);
  
  public e(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, d.buS, "bizinfo", cqY);
  }
  
  public static Cursor C(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    b(localStringBuilder, true);
    if (paramBoolean) {
      a(localStringBuilder, false);
    }
    localStringBuilder.append(" order by ");
    localStringBuilder.append(Me());
    paramString = localStringBuilder.toString();
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseEnableChild sql %s", new Object[] { paramString });
    return com.tencent.mm.kernel.g.DP().dKu.a(paramString, null, 0);
  }
  
  public static String Md()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("rcontact.showHead asc, ");
    localStringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
    localStringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
    localStringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
    localStringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
    localStringBuffer.append(" upper(rcontact.quanPin) asc, ");
    localStringBuffer.append(" upper(rcontact.nickname) asc, ");
    localStringBuffer.append(" upper(rcontact.username) asc ");
    return localStringBuffer.toString();
  }
  
  public static String Me()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("rcontact.type & 2048 desc, ");
    localStringBuffer.append("rcontact.showHead asc, ");
    localStringBuffer.append(" case when length(rcontact.conRemarkPYFull) > 0 then upper(rcontact.conRemarkPYFull) ");
    localStringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
    localStringBuffer.append(" case when length(rcontact.conRemark) > 0 then upper(rcontact.conRemark) ");
    localStringBuffer.append(" else upper(rcontact.quanPin) end asc, ");
    localStringBuffer.append(" upper(rcontact.quanPin) asc, ");
    localStringBuffer.append(" upper(rcontact.nickname) asc, ");
    localStringBuffer.append(" upper(rcontact.username) asc ");
    return localStringBuffer.toString();
  }
  
  public static List<String> Mf()
  {
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
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseConnectorList sql %s", new Object[] { localObject });
    localObject = com.tencent.mm.kernel.g.DP().dKu.a((String)localObject, null, 2);
    ArrayList localArrayList = new ArrayList();
    if (localObject == null) {
      return localArrayList;
    }
    if (((Cursor)localObject).moveToNext())
    {
      if (((Cursor)localObject).getInt(2) > 0)
      {
        i = 1;
        label140:
        if (i == 0) {
          break label168;
        }
      }
      label168:
      for (int i = 0;; i = 1)
      {
        localArrayList.add(((Cursor)localObject).getString(i));
        break;
        i = 0;
        break label140;
      }
    }
    ((Cursor)localObject).close();
    return ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().dD(localArrayList);
  }
  
  public static List<String> Mg()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("select bizinfo.username");
    ((StringBuilder)localObject1).append(" from rcontact, bizinfo");
    ((StringBuilder)localObject1).append(" where bizinfo.specialType = 1");
    ((StringBuilder)localObject1).append(" and rcontact.username = bizinfo.username");
    ((StringBuilder)localObject1).append(" and (rcontact.verifyFlag & ").append(ad.cuc()).append(") != 0 ");
    ((StringBuilder)localObject1).append(" and (rcontact.type & 1) != 0 ");
    Object localObject2 = ((StringBuilder)localObject1).toString();
    y.i("MicroMsg.BizInfoStorage", "getSpecialInternalBizUsernames sql %s", new Object[] { localObject2 });
    localObject1 = new ArrayList();
    localObject2 = com.tencent.mm.kernel.g.DP().dKu.a((String)localObject2, null, 2);
    int i = ((Cursor)localObject2).getColumnIndex("username");
    while (((Cursor)localObject2).moveToNext()) {
      ((List)localObject1).add(((Cursor)localObject2).getString(i));
    }
    ((Cursor)localObject2).close();
    return localObject1;
  }
  
  public static Cursor N(String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    b(localStringBuilder);
    c(localStringBuilder);
    a(localStringBuilder, paramString);
    a(localStringBuilder, false);
    b(localStringBuilder, true);
    localStringBuilder.append(" and (bizinfo.acceptType & ").append(paramInt).append(") > 0 ");
    localStringBuilder.append(" order by ");
    localStringBuilder.append(Md());
    paramString = localStringBuilder.toString();
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseChildOfAcceptType sql %s", new Object[] { paramString });
    return com.tencent.mm.kernel.g.DP().dKu.a(paramString, null, 0);
  }
  
  public static void a(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append("select bizinfo.username ");
  }
  
  public static void a(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append(" and bizinfo.type = 3");
    paramStringBuilder.append(" and bizinfo.enterpriseFather = '").append(paramString).append("' ");
  }
  
  public static void a(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramStringBuilder.append(" and (bizinfo.bitFlag & 1) ");
    if (paramBoolean) {}
    for (String str = "!=";; str = "==")
    {
      paramStringBuilder.append(str).append(" 0 ");
      return;
    }
  }
  
  public static void b(StringBuilder paramStringBuilder)
  {
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
  }
  
  public static void b(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    paramStringBuilder.append(" and (bizinfo.brandFlag & 1) ");
    if (paramBoolean) {}
    for (String str = "==";; str = "!=")
    {
      paramStringBuilder.append(str).append(" 0 ");
      return;
    }
  }
  
  public static void c(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(" from rcontact, bizinfo");
    paramStringBuilder.append(" where rcontact.username = bizinfo.username");
    paramStringBuilder.append(" and (rcontact.verifyFlag & ").append(ad.cuc()).append(") != 0 ");
    paramStringBuilder.append(" and (rcontact.type & 1) != 0 ");
  }
  
  public static void d(StringBuilder paramStringBuilder)
  {
    paramStringBuilder.append(" and bizinfo.type = 3 ");
  }
  
  public static List<String> kS(String paramString)
  {
    Object localObject = new StringBuilder();
    a((StringBuilder)localObject);
    c((StringBuilder)localObject);
    a((StringBuilder)localObject, paramString);
    paramString = ((StringBuilder)localObject).toString();
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseChildNameList sql %s", new Object[] { paramString });
    paramString = com.tencent.mm.kernel.g.DP().dKu.a(paramString, null, 2);
    if (paramString == null) {
      return null;
    }
    localObject = new ArrayList();
    while (paramString.moveToNext()) {
      ((List)localObject).add(paramString.getString(0));
    }
    paramString.close();
    return localObject;
  }
  
  public static String kT(String paramString)
  {
    if (bk.bl(paramString)) {
      y.w("MicroMsg.BizInfoStorage", "getBizChatBrandUserName userName is null");
    }
    Object localObject;
    Cursor localCursor;
    do
    {
      do
      {
        return null;
        if ((egc == null) || (!egc.containsKey(paramString))) {
          break;
        }
        paramString = (String)egc.get(paramString);
      } while ((bk.bl(paramString)) || (!s.hk(paramString)));
      return paramString;
      localObject = new StringBuilder();
      a((StringBuilder)localObject);
      c((StringBuilder)localObject);
      a((StringBuilder)localObject, paramString);
      a((StringBuilder)localObject, true);
      localObject = ((StringBuilder)localObject).toString();
      y.i("MicroMsg.BizInfoStorage", "getEnterpriseBizChatChild sql %s", new Object[] { localObject });
      localCursor = com.tencent.mm.kernel.g.DP().dKu.a((String)localObject, null, 2);
    } while (localCursor == null);
    if (localCursor.moveToFirst())
    {
      localObject = localCursor.getString(0);
      egc.put(paramString, localObject);
    }
    for (paramString = (String)localObject;; paramString = null)
    {
      localCursor.close();
      return paramString;
    }
  }
  
  public static boolean kU(String paramString)
  {
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (!bk.bl(paramString))
    {
      if (f.ld(paramString)) {
        break label24;
      }
      bool2 = bool1;
    }
    label24:
    do
    {
      return bool2;
      Object localObject1 = f.kX(paramString);
      Object localObject2;
      if ((((d)localObject1).bS(false) != null) && (((d)localObject1).bS(false).Mb() != null) && (!bk.bl(((d)localObject1).LG())))
      {
        localObject2 = ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abK(((d)localObject1).LG());
        if ((localObject2 != null) && (((as)localObject2).field_username.equals(paramString)) && (((as)localObject2).field_unReadCount > 0)) {
          ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abx(((d)localObject1).LG());
        }
      }
      localObject1 = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HK(paramString);
      ((Cursor)localObject1).moveToFirst();
      for (bool1 = bool3; !((Cursor)localObject1).isAfterLast(); bool1 = true)
      {
        localObject2 = new bi();
        ((bi)localObject2).d((Cursor)localObject1);
        ((bi)localObject2).setStatus(4);
        y.d("MicroMsg.BizInfoStorage", "writeOpLog: msgSvrId = " + ((cs)localObject2).field_msgSvrId + " status = " + ((cs)localObject2).field_status);
        ((Cursor)localObject1).moveToNext();
      }
      ((Cursor)localObject1).close();
      bool2 = bool1;
    } while (!bool1);
    ((j)com.tencent.mm.kernel.g.r(j.class)).FB().abx(paramString);
    ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().HI(paramString);
    return bool1;
  }
  
  public static void kV(String paramString)
  {
    if ((bk.bl(paramString)) || (!f.ld(paramString))) {
      return;
    }
    ((a)com.tencent.mm.kernel.g.t(a.class)).getNotification().ew(paramString);
    ((a)com.tencent.mm.kernel.g.t(a.class)).getNotification().tn();
  }
  
  public static void kW(String paramString)
  {
    if ((bk.bl(paramString)) || (!f.ld(paramString))) {
      return;
    }
    ((a)com.tencent.mm.kernel.g.t(a.class)).getNotification().ew("");
  }
  
  public final void a(e.a parama)
  {
    if (this.eeJ != null) {
      this.eeJ.remove(parama);
    }
  }
  
  public final void a(e.a parama, Looper paramLooper)
  {
    this.eeJ.a(parama, paramLooper);
  }
  
  public final void c(d paramd)
  {
    y.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.a(paramd, new String[] { "username" })), paramd.field_username });
    e.a.b localb = new e.a.b();
    localb.eeM = paramd.field_username;
    localb.egi = a.a.egf;
    localb.egj = paramd;
    this.eeJ.bV(localb);
    this.eeJ.doNotify();
  }
  
  public final boolean d(d paramd)
  {
    paramd.field_updateTime = System.currentTimeMillis();
    paramd.Lt();
    y.v("MicroMsg.BizInfoStorage", "username is %s, %s, %d, %s, %s, %s, %d", new Object[] { paramd.field_username, paramd.field_brandList, Integer.valueOf(paramd.field_brandFlag), paramd.field_brandInfo, paramd.field_extInfo, paramd.field_brandIconURL, Long.valueOf(paramd.field_updateTime) });
    Object localObject = paramd.bS(false);
    if (localObject != null)
    {
      localObject = ((d.b)localObject).LS();
      if (localObject != null) {
        paramd.field_specialType = ((d.b.b)localObject).efH;
      }
    }
    boolean bool = super.b(paramd);
    if ((bool) && (!s.fn(paramd.field_username)))
    {
      localObject = new e.a.b();
      ((e.a.b)localObject).eeM = paramd.field_username;
      ((e.a.b)localObject).efm = paramd.Lu();
      ((e.a.b)localObject).egi = a.a.ege;
      ((e.a.b)localObject).egj = paramd;
      this.eeJ.bV(localObject);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final void delete(String paramString)
  {
    d locald = new d();
    locald.field_username = paramString;
    y.i("MicroMsg.BizInfoStorage", "delete biz ret = %b, username = %s", new Object[] { Boolean.valueOf(super.a(locald, new String[] { "username" })), paramString });
    e.a.b localb = new e.a.b();
    localb.eeM = paramString;
    localb.egi = a.a.egf;
    localb.egj = locald;
    this.eeJ.bV(localb);
    this.eeJ.doNotify();
  }
  
  public final boolean e(d paramd)
  {
    paramd.field_updateTime = System.currentTimeMillis();
    paramd.Lt();
    Object localObject = paramd.bS(false);
    if (localObject != null)
    {
      localObject = ((d.b)localObject).LS();
      if (localObject != null) {
        paramd.field_specialType = ((d.b.b)localObject).efH;
      }
    }
    boolean bool = super.a(paramd);
    if ((bool) && (!s.fn(paramd.field_username)))
    {
      localObject = new e.a.b();
      ((e.a.b)localObject).eeM = paramd.field_username;
      ((e.a.b)localObject).efm = paramd.Lu();
      ((e.a.b)localObject).egi = a.a.egg;
      ((e.a.b)localObject).egj = paramd;
      this.eeJ.bV(localObject);
      this.eeJ.doNotify();
    }
    return bool;
  }
  
  public final List<String> in(int paramInt)
  {
    Object localObject = String.format(Locale.US, "select %s from %s where %s & %d > 0", new Object[] { "username", "bizinfo", "acceptType", Integer.valueOf(paramInt) });
    y.i("MicroMsg.BizInfoStorage", "getList: sql[%s]", new Object[] { localObject });
    long l = bk.UZ();
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
      y.i("MicroMsg.BizInfoStorage", "getMyAcceptList: type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bk.cp(l)) });
      return ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().dD(localLinkedList);
    }
    y.i("MicroMsg.BizInfoStorage", "getMyAcceptList: cursor not null, type[%d], use time[%d ms]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(bk.cp(l)) });
    return localLinkedList;
  }
  
  public final int io(int paramInt)
  {
    List localList = in(paramInt);
    if (bk.dk(localList)) {
      return 0;
    }
    return localList.size();
  }
  
  public final d kQ(String paramString)
  {
    d locald = new d();
    locald.field_username = paramString;
    super.b(locald, new String[0]);
    return locald;
  }
  
  public final Cursor kR(String paramString)
  {
    Object localObject = kS(paramString);
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      if (!bk.bl(kQ(str).LF())) {
        localArrayList.add(str);
      }
    }
    if (localArrayList.size() <= 0) {
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
    ((StringBuilder)localObject).append(Me());
    paramString = ((StringBuilder)localObject).toString();
    y.i("MicroMsg.BizInfoStorage", "getEnterpriseChatConnector sql %s", new Object[] { paramString });
    return com.tencent.mm.kernel.g.DP().dKu.a(paramString, null, 0);
  }
  
  public static enum a$a
  {
    private a$a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ai.e
 * JD-Core Version:    0.7.0.1
 */
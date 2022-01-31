package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.d;
import com.tencent.mm.plugin.appbrand.config.l.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.task.g;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class n
  extends i<m>
  implements ag
{
  public static final String[] dUb = { i.a(m.fCU, "AppBrandLocalUsageRecord") };
  private final com.tencent.mm.sdk.e.e fCV;
  
  public n(com.tencent.mm.sdk.e.e parame)
  {
    super(parame, m.fCU, "AppBrandLocalUsageRecord", m.cqY);
    this.fCV = parame;
  }
  
  private boolean a(m paramm, boolean paramBoolean, String... paramVarArgs)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramBoolean) {
      bool1 = super.a(paramm, paramBoolean, paramVarArgs);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!b(paramm, paramVarArgs));
      super.a(paramm, paramBoolean, paramVarArgs);
      bool1 = bool2;
    } while (b(paramm, paramVarArgs));
    return true;
  }
  
  private static void ar(List<LocalUsageInfo> paramList)
  {
    Object localObject = com.tencent.mm.model.c.c.IX().fJ("100361");
    if ((((com.tencent.mm.storage.c)localObject).isValid()) && (bk.getInt((String)((com.tencent.mm.storage.c)localObject).ctr().get("isOpenBatchAttrSync"), 0) > 0))
    {
      localObject = new HashSet(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((Set)localObject).add(((LocalUsageInfo)paramList.next()).username);
      }
      paramList = new ArrayList(((Set)localObject).size());
      paramList.addAll((Collection)localObject);
      s.a(paramList, l.a.fQw);
    }
  }
  
  public final boolean a(String paramString, int paramInt, n.a parama)
  {
    boolean bool1 = false;
    y.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bk.bl(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        parama = new m();
        parama.field_username = paramString;
        parama.field_versionType = paramInt;
        if (!super.b(parama, m.fCT)) {
          break;
        }
        parama.field_updateTime = bk.UX();
        bool2 = super.a(parama.ujK, parama, false);
        bool1 = bool2;
      } while (!bool2);
      b("single", 3, null);
      return bool2;
      parama.field_updateTime = bk.UX();
      super.a(parama, false);
      bool2 = super.b(parama, m.fCT);
      bool1 = bool2;
    } while (!bool2);
    paramInt = AppBrandGlobalSystemConfig.aec().fOL;
    paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
    this.fCV.gk("AppBrandLocalUsageRecord", paramString);
    b("single", 2, null);
    return bool2;
  }
  
  public final boolean as(String paramString, int paramInt)
  {
    return b(paramString, paramInt, n.a.fIC);
  }
  
  final boolean b(String paramString, int paramInt, n.a parama)
  {
    boolean bool1 = false;
    y.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bk.bl(paramString)) {}
    boolean bool2;
    do
    {
      do
      {
        return bool1;
        m localm = new m();
        localm.field_username = paramString;
        localm.field_versionType = paramInt;
        bool2 = a(localm, false, m.fCT);
        if (bool2) {
          b("single", 5, null);
        }
        if ((bool2) && (n.a.fIC == parama)) {
          com.tencent.mm.plugin.appbrand.app.e.aaZ().ax(paramString, paramInt);
        }
        bool1 = bool2;
      } while (!bool2);
      bool1 = bool2;
    } while (n.a.fIC != parama);
    g.aZ(r.sv(paramString), paramInt);
    return bool2;
  }
  
  public final List<LocalUsageInfo> kz(int paramInt)
  {
    Object localObject1 = "select AppBrandLocalUsageRecord.username,AppBrandLocalUsageRecord.versionType,WxaAttributesTable.nickname,WxaAttributesTable.brandIconURL,WxaAttributesTable.appId,WxaAttributesTable.appInfo,WxaAttributesTable.shortNickname,WxaAttributesTable.versionInfo from AppBrandLocalUsageRecord left outer join WxaAttributesTable on AppBrandLocalUsageRecord.username=WxaAttributesTable.username order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.fCV.rawQuery((String)localObject1, null);
    if (localObject2 == null) {
      return null;
    }
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      return null;
    }
    localObject1 = new LinkedList();
    String str1 = ((Cursor)localObject2).getString(0);
    int i;
    String str2;
    String str3;
    String str4;
    WxaAttributes.a locala;
    String str5;
    WxaAttributes.d locald;
    if (!bk.bl(str1))
    {
      i = ((Cursor)localObject2).getInt(1);
      str2 = ((Cursor)localObject2).getString(2);
      str3 = ((Cursor)localObject2).getString(3);
      str4 = ((Cursor)localObject2).getString(4);
      locala = WxaAttributes.a.sH(((Cursor)localObject2).getString(5));
      str5 = ((Cursor)localObject2).getString(6);
      locald = WxaAttributes.d.sI(((Cursor)localObject2).getString(7));
      if (locald != null) {
        break label261;
      }
      paramInt = 0;
      label180:
      if (locala != null) {
        break label270;
      }
    }
    label261:
    label270:
    for (long l = 0L;; l = locala.fKa)
    {
      ((LinkedList)localObject1).add(new LocalUsageInfo(str1, str4, i, paramInt, str2, str5, str3, false, l));
      if (((Cursor)localObject2).moveToNext()) {
        break;
      }
      ((Cursor)localObject2).close();
      localObject2 = new ArrayList(((LinkedList)localObject1).size());
      ((ArrayList)localObject2).addAll((Collection)localObject1);
      ar((List)localObject2);
      return localObject2;
      paramInt = locald.cau;
      break label180;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */
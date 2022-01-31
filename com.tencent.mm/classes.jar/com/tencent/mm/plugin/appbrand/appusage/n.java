package com.tencent.mm.plugin.appbrand.appusage;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.g;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.s;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Deprecated
public final class n
  extends j<m>
  implements ag
{
  public static final String[] fkl;
  private final e gVl;
  
  static
  {
    AppMethodBeat.i(129582);
    fkl = new String[] { j.getCreateSQLs(m.gUb, "AppBrandLocalUsageRecord") };
    AppMethodBeat.o(129582);
  }
  
  public n(e parame)
  {
    super(parame, m.gUb, "AppBrandLocalUsageRecord", m.INDEX_CREATE);
    this.gVl = parame;
  }
  
  private boolean a(m paramm, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(129580);
    if (paramBoolean)
    {
      paramBoolean = super.delete(paramm, paramBoolean, paramVarArgs);
      AppMethodBeat.o(129580);
      return paramBoolean;
    }
    if (!get(paramm, paramVarArgs))
    {
      AppMethodBeat.o(129580);
      return false;
    }
    super.delete(paramm, paramBoolean, paramVarArgs);
    if (!get(paramm, paramVarArgs))
    {
      AppMethodBeat.o(129580);
      return true;
    }
    AppMethodBeat.o(129580);
    return false;
  }
  
  private static void aA(List<LocalUsageInfo> paramList)
  {
    AppMethodBeat.i(129576);
    Object localObject = com.tencent.mm.model.c.c.abU().me("100361");
    if ((((com.tencent.mm.storage.c)localObject).isValid()) && (bo.getInt((String)((com.tencent.mm.storage.c)localObject).dvN().get("isOpenBatchAttrSync"), 0) > 0))
    {
      localObject = new HashSet(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((Set)localObject).add(((LocalUsageInfo)paramList.next()).username);
      }
      paramList = new ArrayList(((Set)localObject).size());
      paramList.addAll((Collection)localObject);
      s.a(paramList, k.a.hjh);
    }
    AppMethodBeat.o(129576);
  }
  
  public final boolean a(String paramString, int paramInt, n.a parama)
  {
    AppMethodBeat.i(129578);
    ab.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129578);
      return false;
    }
    parama = new m();
    parama.field_username = paramString;
    parama.field_versionType = paramInt;
    if (super.get(parama, m.gUa))
    {
      parama.field_updateTime = bo.aox();
      bool = super.update(parama.systemRowid, parama, false);
      if (bool) {
        doNotify("single", 3, null);
      }
      AppMethodBeat.o(129578);
      return bool;
    }
    parama.field_updateTime = bo.aox();
    super.insertNotify(parama, false);
    boolean bool = super.get(parama, m.gUa);
    if (bool)
    {
      paramInt = AppBrandGlobalSystemConfig.ayt().hhL;
      paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
      this.gVl.execSQL("AppBrandLocalUsageRecord", paramString);
      doNotify("single", 2, null);
    }
    AppMethodBeat.o(129578);
    return bool;
  }
  
  public final boolean aF(String paramString, int paramInt)
  {
    AppMethodBeat.i(129577);
    boolean bool = b(paramString, paramInt, n.a.hbu);
    AppMethodBeat.o(129577);
    return bool;
  }
  
  final boolean b(String paramString, int paramInt, n.a parama)
  {
    AppMethodBeat.i(129579);
    ab.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(129579);
      return false;
    }
    m localm = new m();
    localm.field_username = paramString;
    localm.field_versionType = paramInt;
    boolean bool = a(localm, false, m.gUa);
    if (bool) {
      doNotify("single", 5, null);
    }
    if ((bool) && (n.a.hbu == parama)) {
      g.auK().aM(paramString, paramInt);
    }
    if ((bool) && (n.a.hbu == parama)) {
      h.bt(q.Aq(paramString), paramInt);
    }
    AppMethodBeat.o(129579);
    return bool;
  }
  
  public final List<LocalUsageInfo> nu(int paramInt)
  {
    AppMethodBeat.i(129575);
    Object localObject1 = "select AppBrandLocalUsageRecord.username,AppBrandLocalUsageRecord.versionType,WxaAttributesTable.nickname,WxaAttributesTable.brandIconURL,WxaAttributesTable.appId,WxaAttributesTable.appInfo,WxaAttributesTable.shortNickname,WxaAttributesTable.versionInfo from AppBrandLocalUsageRecord left outer join WxaAttributesTable on AppBrandLocalUsageRecord.username=WxaAttributesTable.username order by AppBrandLocalUsageRecord.updateTime desc limit " + Math.max(paramInt, 1) + " offset 0";
    Object localObject2 = this.gVl.rawQuery((String)localObject1, null);
    if (localObject2 == null)
    {
      AppMethodBeat.o(129575);
      return null;
    }
    if (!((Cursor)localObject2).moveToFirst())
    {
      ((Cursor)localObject2).close();
      AppMethodBeat.o(129575);
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
    WxaAttributes.WxaVersionInfo localWxaVersionInfo;
    long l1;
    label198:
    long l2;
    if (!bo.isNullOrNil(str1))
    {
      i = ((Cursor)localObject2).getInt(1);
      str2 = ((Cursor)localObject2).getString(2);
      str3 = ((Cursor)localObject2).getString(3);
      str4 = ((Cursor)localObject2).getString(4);
      locala = WxaAttributes.a.AB(((Cursor)localObject2).getString(5));
      str5 = ((Cursor)localObject2).getString(6);
      localWxaVersionInfo = WxaAttributes.WxaVersionInfo.AD(((Cursor)localObject2).getString(7));
      if (locala != null) {
        break label306;
      }
      l1 = 0L;
      if ((!j.a.nk(i)) || (locala == null)) {
        break label315;
      }
      l2 = locala.hcP;
      label217:
      if (localWxaVersionInfo != null) {
        break label321;
      }
    }
    label306:
    label315:
    label321:
    for (paramInt = 0;; paramInt = localWxaVersionInfo.bDc)
    {
      ((LinkedList)localObject1).add(new LocalUsageInfo(str1, str4, i, paramInt, str2, str5, str3, false, l1, l2));
      if (((Cursor)localObject2).moveToNext()) {
        break;
      }
      ((Cursor)localObject2).close();
      localObject2 = new ArrayList(((LinkedList)localObject1).size());
      ((ArrayList)localObject2).addAll((Collection)localObject1);
      aA((List)localObject2);
      AppMethodBeat.o(129575);
      return localObject2;
      l1 = locala.bDL;
      break label198;
      l2 = 0L;
      break label217;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.app.n;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.plugin.appbrand.task.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

@Deprecated
public final class m
  extends MAutoStorage<l>
{
  public static final String[] nVW;
  private final ISQLiteDatabase qFJ;
  
  static
  {
    AppMethodBeat.i(44511);
    nVW = new String[] { MAutoStorage.getCreateSQLs(l.DB_INFO, "AppBrandLocalUsageRecord") };
    AppMethodBeat.o(44511);
  }
  
  public m(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, l.DB_INFO, "AppBrandLocalUsageRecord", l.INDEX_CREATE);
    this.qFJ = paramISQLiteDatabase;
  }
  
  private boolean a(l paraml, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(44509);
    if (paramBoolean)
    {
      paramBoolean = super.delete(paraml, paramBoolean, paramVarArgs);
      AppMethodBeat.o(44509);
      return paramBoolean;
    }
    if (!get(paraml, paramVarArgs))
    {
      AppMethodBeat.o(44509);
      return false;
    }
    super.delete(paraml, paramBoolean, paramVarArgs);
    if (!get(paraml, paramVarArgs))
    {
      AppMethodBeat.o(44509);
      return true;
    }
    AppMethodBeat.o(44509);
    return false;
  }
  
  public final boolean a(String paramString, int paramInt, m.a parama)
  {
    AppMethodBeat.i(44507);
    Log.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44507);
      return false;
    }
    parama = new l();
    parama.field_username = paramString;
    parama.field_versionType = paramInt;
    if (super.get(parama, l.qDJ))
    {
      parama.field_updateTime = Util.nowSecond();
      bool = super.update(parama.systemRowid, parama, false);
      if (bool) {
        doNotify("single", 3, null);
      }
      AppMethodBeat.o(44507);
      return bool;
    }
    parama.field_updateTime = Util.nowSecond();
    super.insertNotify(parama, false);
    boolean bool = super.get(parama, l.qDJ);
    if (bool)
    {
      paramInt = AppBrandGlobalSystemConfig.ckD().qWU;
      paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
      this.qFJ.execSQL("AppBrandLocalUsageRecord", paramString);
      doNotify("single", 2, null);
    }
    AppMethodBeat.o(44507);
    return bool;
  }
  
  final boolean b(String paramString, int paramInt, m.a parama)
  {
    AppMethodBeat.i(44508);
    Log.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44508);
      return false;
    }
    l locall = new l();
    locall.field_username = paramString;
    locall.field_versionType = paramInt;
    boolean bool = a(locall, false, l.qDJ);
    if (bool) {
      doNotify("single", 5, null);
    }
    if ((bool) && (m.a.qOQ == parama)) {
      n.cfk().ca(paramString, paramInt);
    }
    if ((bool) && (m.a.qOQ == parama)) {
      i.cJV().F(ad.XJ(paramString), paramInt);
    }
    AppMethodBeat.o(44508);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.m
 * JD-Core Version:    0.7.0.1
 */
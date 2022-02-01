package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.task.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

@Deprecated
public final class n
  extends MAutoStorage<m>
{
  public static final String[] iBh;
  private final ISQLiteDatabase kLX;
  
  static
  {
    AppMethodBeat.i(44511);
    iBh = new String[] { MAutoStorage.getCreateSQLs(m.kLR, "AppBrandLocalUsageRecord") };
    AppMethodBeat.o(44511);
  }
  
  public n(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, m.kLR, "AppBrandLocalUsageRecord", m.INDEX_CREATE);
    this.kLX = paramISQLiteDatabase;
  }
  
  private boolean a(m paramm, boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(44509);
    if (paramBoolean)
    {
      paramBoolean = super.delete(paramm, paramBoolean, paramVarArgs);
      AppMethodBeat.o(44509);
      return paramBoolean;
    }
    if (!get(paramm, paramVarArgs))
    {
      AppMethodBeat.o(44509);
      return false;
    }
    super.delete(paramm, paramBoolean, paramVarArgs);
    if (!get(paramm, paramVarArgs))
    {
      AppMethodBeat.o(44509);
      return true;
    }
    AppMethodBeat.o(44509);
    return false;
  }
  
  public final boolean a(String paramString, int paramInt, n.a parama)
  {
    AppMethodBeat.i(44507);
    Log.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44507);
      return false;
    }
    parama = new m();
    parama.field_username = paramString;
    parama.field_versionType = paramInt;
    if (super.get(parama, m.kJX))
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
    boolean bool = super.get(parama, m.kJX);
    if (bool)
    {
      paramInt = AppBrandGlobalSystemConfig.bzP().lcV;
      paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
      this.kLX.execSQL("AppBrandLocalUsageRecord", paramString);
      doNotify("single", 2, null);
    }
    AppMethodBeat.o(44507);
    return bool;
  }
  
  final boolean b(String paramString, int paramInt, n.a parama)
  {
    AppMethodBeat.i(44508);
    Log.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44508);
      return false;
    }
    m localm = new m();
    localm.field_username = paramString;
    localm.field_versionType = paramInt;
    boolean bool = a(localm, false, m.kJX);
    if (bool) {
      doNotify("single", 5, null);
    }
    if ((bool) && (n.a.kUL == parama)) {
      com.tencent.mm.plugin.appbrand.app.n.buJ().bp(paramString, paramInt);
    }
    if ((bool) && (n.a.kUL == parama)) {
      h.bWb().cl(y.Xw(paramString), paramInt);
    }
    AppMethodBeat.o(44508);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */
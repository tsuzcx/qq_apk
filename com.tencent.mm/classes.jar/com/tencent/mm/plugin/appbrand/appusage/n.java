package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class n
  extends com.tencent.mm.sdk.e.j<m>
{
  public static final String[] gLs;
  private final e iMV;
  
  static
  {
    AppMethodBeat.i(44511);
    gLs = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(m.iMP, "AppBrandLocalUsageRecord") };
    AppMethodBeat.o(44511);
  }
  
  public n(e parame)
  {
    super(parame, m.iMP, "AppBrandLocalUsageRecord", m.INDEX_CREATE);
    this.iMV = parame;
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
  
  public final boolean a(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(44507);
    ad.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44507);
      return false;
    }
    parama = new m();
    parama.field_username = paramString;
    parama.field_versionType = paramInt;
    if (super.get(parama, m.iLd))
    {
      parama.field_updateTime = bt.aGK();
      bool = super.update(parama.systemRowid, parama, false);
      if (bool) {
        doNotify("single", 3, null);
      }
      AppMethodBeat.o(44507);
      return bool;
    }
    parama.field_updateTime = bt.aGK();
    super.insertNotify(parama, false);
    boolean bool = super.get(parama, m.iLd);
    if (bool)
    {
      paramInt = AppBrandGlobalSystemConfig.aTv().jcu;
      paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
      this.iMV.execSQL("AppBrandLocalUsageRecord", paramString);
      doNotify("single", 2, null);
    }
    AppMethodBeat.o(44507);
    return bool;
  }
  
  final boolean b(String paramString, int paramInt, a parama)
  {
    AppMethodBeat.i(44508);
    ad.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44508);
      return false;
    }
    m localm = new m();
    localm.field_username = paramString;
    localm.field_versionType = paramInt;
    boolean bool = a(localm, false, m.iLd);
    if (bool) {
      doNotify("single", 5, null);
    }
    if ((bool) && (a.iUA == parama)) {
      com.tencent.mm.plugin.appbrand.app.j.aOI().bb(paramString, paramInt);
    }
    if ((bool) && (a.iUA == parama)) {
      f.bQ(u.Gh(paramString), paramInt);
    }
    AppMethodBeat.o(44508);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44506);
      iUA = new a("CHATTING", 0);
      iUB = new a("USAGE_LIST", 1);
      iUC = new a[] { iUA, iUB };
      AppMethodBeat.o(44506);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */
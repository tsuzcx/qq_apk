package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@Deprecated
public final class n
  extends com.tencent.mm.sdk.e.j<m>
{
  public static final String[] hEf;
  private final e jHa;
  
  static
  {
    AppMethodBeat.i(44511);
    hEf = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(m.jGU, "AppBrandLocalUsageRecord") };
    AppMethodBeat.o(44511);
  }
  
  public n(e parame)
  {
    super(parame, m.jGU, "AppBrandLocalUsageRecord", m.INDEX_CREATE);
    this.jHa = parame;
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
    if (super.get(parama, m.jFa))
    {
      parama.field_updateTime = bt.aQJ();
      bool = super.update(parama.systemRowid, parama, false);
      if (bool) {
        doNotify("single", 3, null);
      }
      AppMethodBeat.o(44507);
      return bool;
    }
    parama.field_updateTime = bt.aQJ();
    super.insertNotify(parama, false);
    boolean bool = super.get(parama, m.jFa);
    if (bool)
    {
      paramInt = AppBrandGlobalSystemConfig.bdT().jWD;
      paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
      this.jHa.execSQL("AppBrandLocalUsageRecord", paramString);
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
    boolean bool = a(localm, false, m.jFa);
    if (bool) {
      doNotify("single", 5, null);
    }
    if ((bool) && (a.jOJ == parama)) {
      com.tencent.mm.plugin.appbrand.app.j.aYV().bh(paramString, paramInt);
    }
    if ((bool) && (a.jOJ == parama)) {
      f.bY(v.NE(paramString), paramInt);
    }
    AppMethodBeat.o(44508);
    return bool;
  }
  
  public static enum a
  {
    static
    {
      AppMethodBeat.i(44506);
      jOJ = new a("CHATTING", 0);
      jOK = new a("USAGE_LIST", 1);
      jOL = new a[] { jOJ, jOK };
      AppMethodBeat.o(44506);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */
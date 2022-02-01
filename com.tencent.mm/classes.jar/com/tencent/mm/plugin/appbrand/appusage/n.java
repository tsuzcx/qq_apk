package com.tencent.mm.plugin.appbrand.appusage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandGlobalSystemConfig;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.task.f;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@Deprecated
public final class n
  extends com.tencent.mm.sdk.e.j<m>
{
  public static final String[] hlS;
  private final e jnc;
  
  static
  {
    AppMethodBeat.i(44511);
    hlS = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(m.jmW, "AppBrandLocalUsageRecord") };
    AppMethodBeat.o(44511);
  }
  
  public n(e parame)
  {
    super(parame, m.jmW, "AppBrandLocalUsageRecord", m.INDEX_CREATE);
    this.jnc = parame;
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
    ac.i("MicroMsg.AppBrandLocalUsageStorage", "addUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44507);
      return false;
    }
    parama = new m();
    parama.field_username = paramString;
    parama.field_versionType = paramInt;
    if (super.get(parama, m.jlk))
    {
      parama.field_updateTime = bs.aNx();
      bool = super.update(parama.systemRowid, parama, false);
      if (bool) {
        doNotify("single", 3, null);
      }
      AppMethodBeat.o(44507);
      return bool;
    }
    parama.field_updateTime = bs.aNx();
    super.insertNotify(parama, false);
    boolean bool = super.get(parama, m.jlk);
    if (bool)
    {
      paramInt = AppBrandGlobalSystemConfig.bat().jCH;
      paramString = "delete from AppBrandLocalUsageRecord where rowid not in ( select rowid from AppBrandLocalUsageRecord order by updateTime desc  limit " + paramInt + " offset 0)";
      this.jnc.execSQL("AppBrandLocalUsageRecord", paramString);
      doNotify("single", 2, null);
    }
    AppMethodBeat.o(44507);
    return bool;
  }
  
  final boolean b(String paramString, int paramInt, n.a parama)
  {
    AppMethodBeat.i(44508);
    ac.i("MicroMsg.AppBrandLocalUsageStorage", "removeUsage, username %s, type %d, scene %s", new Object[] { paramString, Integer.valueOf(paramInt), parama });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(44508);
      return false;
    }
    m localm = new m();
    localm.field_username = paramString;
    localm.field_versionType = paramInt;
    boolean bool = a(localm, false, m.jlk);
    if (bool) {
      doNotify("single", 5, null);
    }
    if ((bool) && (n.a.juQ == parama)) {
      com.tencent.mm.plugin.appbrand.app.j.aVA().bf(paramString, paramInt);
    }
    if ((bool) && (n.a.juQ == parama)) {
      f.bV(u.Kl(paramString), paramInt);
    }
    AppMethodBeat.o(44508);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appusage.n
 * JD-Core Version:    0.7.0.1
 */
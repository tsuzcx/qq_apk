package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearVersion", "", "appId", "", "versionType", "", "getVersion", "insertOrUpdate", "", "record", "block", "Lkotlin/Function1;", "setVersion", "versionMd5", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends com.tencent.mm.plugin.appbrand.ae.c<c>
{
  private static final d.a qDQ;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(185635);
    qDQ = new d.a((byte)0);
    AppMethodBeat.o(185635);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.nVV, "AppBrandTestCodeVersionMarkTable", c.INDEX_CREATE);
    AppMethodBeat.i(180427);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(180427);
  }
  
  public final void bw(String paramString, int paramInt)
  {
    AppMethodBeat.i(185634);
    s.u(paramString, "appId");
    Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "clearVersion appId:" + paramString + " versionType:" + paramInt);
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    paramString = ah.aiuX;
    super.delete((IAutoDBItem)localc, new String[0]);
    AppMethodBeat.o(185634);
  }
  
  public final String bx(String paramString, int paramInt)
  {
    AppMethodBeat.i(320301);
    s.u(paramString, "appId");
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    if (get((IAutoDBItem)localc, new String[0]))
    {
      paramString = localc.field_versionMd5;
      AppMethodBeat.o(320301);
      return paramString;
    }
    AppMethodBeat.o(320301);
    return null;
  }
  
  public final void q(String paramString1, int paramInt, String paramString2)
  {
    AppMethodBeat.i(320296);
    s.u(paramString1, "appId");
    s.u(paramString2, "versionMd5");
    Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "setVersion appId:" + paramString1 + " versionType:" + paramInt + " versionMd5:" + paramString2);
    c localc = new c();
    localc.field_appId = paramString1;
    localc.field_versionType = paramInt;
    paramString1 = (b)new d.b(localc, paramString2);
    paramString2 = com.tencent.mm.plugin.appbrand.ae.d.tVA;
    paramString2 = this.db;
    if ((paramString2 instanceof ISQLiteDatabaseEx))
    {
      long l = ((ISQLiteDatabaseEx)paramString2).beginTransaction(Thread.currentThread().getId());
      if (super.get((IAutoDBItem)localc, new String[0]))
      {
        paramString1.invoke(localc);
        super.update((IAutoDBItem)localc, new String[0]);
      }
      for (;;)
      {
        ((ISQLiteDatabaseEx)paramString2).endTransaction(l);
        AppMethodBeat.o(320296);
        return;
        paramString1.invoke(localc);
        super.insert((IAutoDBItem)localc);
      }
    }
    if (super.get((IAutoDBItem)localc, new String[0]))
    {
      paramString1.invoke(localc);
      super.update((IAutoDBItem)localc, new String[0]);
      AppMethodBeat.o(320296);
      return;
    }
    paramString1.invoke(localc);
    super.insert((IAutoDBItem)localc);
    AppMethodBeat.o(320296);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.d
 * JD-Core Version:    0.7.0.1
 */
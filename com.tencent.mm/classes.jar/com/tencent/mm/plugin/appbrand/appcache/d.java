package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearVersion", "", "appId", "", "versionType", "", "getVersion", "insertOrUpdate", "", "record", "block", "Lkotlin/Function1;", "setVersion", "versionMd5", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.ab.c<c>
{
  @Deprecated
  public static final a nDV;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(185635);
    nDV = new a((byte)0);
    AppMethodBeat.o(185635);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.lqK, "AppBrandTestCodeVersionMarkTable", c.INDEX_CREATE);
    AppMethodBeat.i(180427);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(180427);
  }
  
  public final void bf(String paramString, int paramInt)
  {
    AppMethodBeat.i(185634);
    p.k(paramString, "appId");
    Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "clearVersion appId:" + paramString + " versionType:" + paramInt);
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    super.delete((IAutoDBItem)localc, new String[0]);
    AppMethodBeat.o(185634);
  }
  
  public final String bg(String paramString, int paramInt)
  {
    AppMethodBeat.i(242535);
    p.k(paramString, "appId");
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    if (get((IAutoDBItem)localc, new String[0]))
    {
      paramString = localc.field_versionMd5;
      AppMethodBeat.o(242535);
      return paramString;
    }
    AppMethodBeat.o(242535);
    return null;
  }
  
  public final void o(String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(242531);
    p.k(paramString1, "appId");
    p.k(paramString2, "versionMd5");
    Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "setVersion appId:" + paramString1 + " versionType:" + paramInt + " versionMd5:" + paramString2);
    c localc = new c();
    localc.field_appId = paramString1;
    localc.field_versionType = paramInt;
    paramString1 = (b)new b(localc, paramString2);
    paramString2 = com.tencent.mm.plugin.appbrand.ab.d.qQK;
    paramString2 = this.db;
    if ((paramString2 instanceof ISQLiteDatabaseEx))
    {
      ISQLiteDatabaseEx localISQLiteDatabaseEx = (ISQLiteDatabaseEx)paramString2;
      Thread localThread = Thread.currentThread();
      p.j(localThread, "Thread.currentThread()");
      long l = localISQLiteDatabaseEx.beginTransaction(localThread.getId());
      if (super.get((IAutoDBItem)localc, new String[0]))
      {
        paramString1.invoke(localc);
        super.update((IAutoDBItem)localc, new String[0]);
      }
      for (;;)
      {
        ((ISQLiteDatabaseEx)paramString2).endTransaction(l);
        AppMethodBeat.o(242531);
        return;
        paramString1.invoke(localc);
        super.insert((IAutoDBItem)localc);
      }
    }
    if (super.get((IAutoDBItem)localc, new String[0]))
    {
      paramString1.invoke(localc);
      super.update((IAutoDBItem)localc, new String[0]);
      AppMethodBeat.o(242531);
      return;
    }
    paramString1.invoke(localc);
    super.insert((IAutoDBItem)localc);
    AppMethodBeat.o(242531);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "invoke"})
  static final class b
    extends q
    implements b<c, x>
  {
    b(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.d
 * JD-Core Version:    0.7.0.1
 */
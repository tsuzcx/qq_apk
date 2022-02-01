package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearVersion", "", "appId", "", "versionType", "", "getVersion", "insertOrUpdate", "", "record", "block", "Lkotlin/Function1;", "setVersion", "versionMd5", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.ab.c<c>
{
  @Deprecated
  public static final a kKd;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(185635);
    kKd = new a((byte)0);
    AppMethodBeat.o(185635);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.iBg, "AppBrandTestCodeVersionMarkTable", c.INDEX_CREATE);
    AppMethodBeat.i(180427);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(180427);
  }
  
  public final void aN(String paramString, int paramInt)
  {
    AppMethodBeat.i(185634);
    p.h(paramString, "appId");
    Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "clearVersion appId:" + paramString + " versionType:" + paramInt);
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    super.delete((IAutoDBItem)localc, new String[0]);
    AppMethodBeat.o(185634);
  }
  
  public final String aO(String paramString, int paramInt)
  {
    AppMethodBeat.i(227975);
    p.h(paramString, "appId");
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    if (get((IAutoDBItem)localc, new String[0]))
    {
      paramString = localc.field_versionMd5;
      AppMethodBeat.o(227975);
      return paramString;
    }
    AppMethodBeat.o(227975);
    return null;
  }
  
  public final void n(final String paramString1, int paramInt, final String paramString2)
  {
    AppMethodBeat.i(227974);
    p.h(paramString1, "appId");
    p.h(paramString2, "versionMd5");
    Log.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "setVersion appId:" + paramString1 + " versionType:" + paramInt + " versionMd5:" + paramString2);
    final c localc = new c();
    localc.field_appId = paramString1;
    localc.field_versionType = paramInt;
    paramString1 = (b)new c(localc, paramString2);
    paramString2 = com.tencent.mm.plugin.appbrand.ab.d.nOm;
    ((Boolean)com.tencent.mm.plugin.appbrand.ab.d.a(this.db, (a)new b(this, localc, paramString1))).booleanValue();
    AppMethodBeat.o(227974);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<Boolean>
  {
    b(d paramd, c paramc, b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "invoke"})
  static final class c
    extends q
    implements b<c, x>
  {
    c(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.d
 * JD-Core Version:    0.7.0.1
 */
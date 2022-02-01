package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.a.a;
import d.g.a.b;
import d.g.b.k;
import d.y;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearVersion", "", "appId", "", "versionType", "", "getVersion", "insertOrUpdate", "", "record", "block", "Lkotlin/Function1;", "setVersion", "versionMd5", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.y.c<c>
{
  @Deprecated
  public static final a jls;
  public final e db;
  
  static
  {
    AppMethodBeat.i(185635);
    jls = new a((byte)0);
    AppMethodBeat.o(185635);
  }
  
  public d(e parame)
  {
    super(parame, c.hlR, "AppBrandTestCodeVersionMarkTable", c.INDEX_CREATE);
    AppMethodBeat.i(180427);
    this.db = parame;
    AppMethodBeat.o(180427);
  }
  
  public final void aF(String paramString, int paramInt)
  {
    AppMethodBeat.i(185634);
    k.h(paramString, "appId");
    ac.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "clearVersion appId:" + paramString + " versionType:" + paramInt);
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    super.delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    AppMethodBeat.o(185634);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  public static final class b
    extends d.g.b.l
    implements a<Boolean>
  {
    public b(d paramd, c paramc, b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "invoke"})
  public static final class c
    extends d.g.b.l
    implements b<c, y>
  {
    public c(c paramc, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.d
 * JD-Core Version:    0.7.0.1
 */
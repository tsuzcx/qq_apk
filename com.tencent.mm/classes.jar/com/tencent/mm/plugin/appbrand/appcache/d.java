package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.a.a;
import d.g.a.b;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearVersion", "", "appId", "", "versionType", "", "getVersion", "insertOrUpdate", "", "record", "block", "Lkotlin/Function1;", "setVersion", "versionMd5", "Companion", "plugin-appbrand-integration_release"})
public final class d
  extends com.tencent.mm.plugin.appbrand.x.c<c>
{
  @Deprecated
  public static final a jIh;
  public final e db;
  
  static
  {
    AppMethodBeat.i(185635);
    jIh = new a((byte)0);
    AppMethodBeat.o(185635);
  }
  
  public d(e parame)
  {
    super(parame, c.hGW, "AppBrandTestCodeVersionMarkTable", c.INDEX_CREATE);
    AppMethodBeat.i(180427);
    this.db = parame;
    AppMethodBeat.o(180427);
  }
  
  public final void aI(String paramString, int paramInt)
  {
    AppMethodBeat.i(185634);
    p.h(paramString, "appId");
    ae.i("MicroMsg.AppBrandTestCodeVersionMarkStorage", "clearVersion appId:" + paramString + " versionType:" + paramInt);
    c localc = new c();
    localc.field_appId = paramString;
    localc.field_versionType = paramInt;
    super.delete((com.tencent.mm.sdk.e.c)localc, new String[0]);
    AppMethodBeat.o(185634);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkStorage$Companion;", "", "()V", "TAG", "", "plugin-appbrand-integration_release"})
  static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  public static final class b
    extends q
    implements a<Boolean>
  {
    public b(d paramd, c paramc, b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandTestCodeVersionMarkRecord;", "invoke"})
  public static final class c
    extends q
    implements b<c, z>
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
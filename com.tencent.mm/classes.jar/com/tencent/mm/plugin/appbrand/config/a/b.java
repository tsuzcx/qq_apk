package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.plugin.appbrand.ab.d;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b
  extends MAutoStorage<a>
{
  private final ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.iBg, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
    AppMethodBeat.i(228184);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(228184);
  }
  
  public final boolean a(b.a parama)
  {
    AppMethodBeat.i(228181);
    p.h(parama, "key");
    p.h(parama, "key");
    a locala = new a();
    locala.field_appId = ((b.a.a)parama).value;
    if (super.get((IAutoDBItem)locala, new String[] { "appId" })) {}
    for (parama = locala; parama != null; parama = null)
    {
      AppMethodBeat.o(228181);
      return true;
    }
    AppMethodBeat.o(228181);
    return false;
  }
  
  public final void b(b.a parama)
  {
    AppMethodBeat.i(228183);
    p.h(parama, "key");
    long l = Util.nowSecond();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.b)parama).value;
    locala.field_appId = y.Xw(locala.field_username);
    super.replace((IAutoDBItem)locala);
    AppMethodBeat.o(228183);
  }
  
  public final void br(List<String> paramList)
  {
    AppMethodBeat.i(228182);
    p.h(paramList, "usernameList");
    d locald = d.nOm;
    d.a(this.db, (kotlin.g.a.a)new b.b(this, paramList));
    AppMethodBeat.o(228182);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b
 * JD-Core Version:    0.7.0.1
 */
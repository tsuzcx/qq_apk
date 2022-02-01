package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.d;
import com.tencent.mm.plugin.appbrand.config.ad;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<a>
{
  private final ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nVV, "AppBrandPrefetchWxaAttrsMarkTable", com.tencent.mm.autogen.b.s.INDEX_CREATE);
    AppMethodBeat.i(323475);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(323475);
  }
  
  public final void a(b.a parama)
  {
    AppMethodBeat.i(323493);
    kotlin.g.b.s.u(parama, "key");
    long l = Util.nowSecond();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.a)parama).value;
    locala.field_appId = ad.XJ(locala.field_username);
    super.replace((IAutoDBItem)locala);
    AppMethodBeat.o(323493);
  }
  
  public final void da(List<String> paramList)
  {
    AppMethodBeat.i(323485);
    kotlin.g.b.s.u(paramList, "usernameList");
    Object localObject1 = d.tVA;
    localObject1 = this.db;
    Object localObject2;
    int i;
    if ((localObject1 instanceof ISQLiteDatabaseEx))
    {
      long l = ((ISQLiteDatabaseEx)localObject1).beginTransaction(Thread.currentThread().getId());
      paramList = ((Iterable)paramList).iterator();
      label127:
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        CharSequence localCharSequence = (CharSequence)localObject2;
        if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label127;
          }
          a((b.a)new b.a.a((String)localObject2));
          break;
        }
      }
      paramList = ah.aiuX;
      ((ISQLiteDatabaseEx)localObject1).endTransaction(l);
      AppMethodBeat.o(323485);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    label231:
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label231;
        }
        a((b.a)new b.a.a((String)localObject1));
        break;
      }
    }
    AppMethodBeat.o(323485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b
 * JD-Core Version:    0.7.0.1
 */
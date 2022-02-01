package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.r;
import com.tencent.mm.plugin.appbrand.ab.d;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.ISQLiteDatabaseEx;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b
  extends MAutoStorage<a>
{
  private final ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.lqK, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
    AppMethodBeat.i(274556);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(274556);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(274553);
    p.k(parama, "key");
    p.k(parama, "key");
    a locala = new a();
    locala.field_appId = ((b.a.a)parama).value;
    if (super.get((IAutoDBItem)locala, new String[] { "appId" })) {}
    for (parama = locala; parama != null; parama = null)
    {
      AppMethodBeat.o(274553);
      return true;
    }
    AppMethodBeat.o(274553);
    return false;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(274555);
    p.k(parama, "key");
    long l = Util.nowSecond();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.b)parama).value;
    locala.field_appId = y.afi(locala.field_username);
    super.replace((IAutoDBItem)locala);
    AppMethodBeat.o(274555);
  }
  
  public final void bp(List<String> paramList)
  {
    AppMethodBeat.i(274554);
    p.k(paramList, "usernameList");
    Object localObject1 = d.qQK;
    localObject1 = this.db;
    Object localObject2;
    int i;
    if ((localObject1 instanceof ISQLiteDatabaseEx))
    {
      localObject2 = (ISQLiteDatabaseEx)localObject1;
      Object localObject3 = Thread.currentThread();
      p.j(localObject3, "Thread.currentThread()");
      long l = ((ISQLiteDatabaseEx)localObject2).beginTransaction(((Thread)localObject3).getId());
      paramList = ((Iterable)paramList).iterator();
      label142:
      while (paramList.hasNext())
      {
        localObject2 = (String)paramList.next();
        localObject3 = (CharSequence)localObject2;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label142;
          }
          b((a)new b.a.b((String)localObject2));
          break;
        }
      }
      paramList = x.aazN;
      ((ISQLiteDatabaseEx)localObject1).endTransaction(l);
      AppMethodBeat.o(274554);
      return;
    }
    paramList = ((Iterable)paramList).iterator();
    label246:
    while (paramList.hasNext())
    {
      localObject1 = (String)paramList.next();
      localObject2 = (CharSequence)localObject1;
      if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0)) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          break label246;
        }
        b((a)new b.a.b((String)localObject1));
        break;
      }
    }
    AppMethodBeat.o(274554);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.a
    {
      final String value;
      
      public a(String paramString)
      {
        super();
        AppMethodBeat.i(274037);
        this.value = paramString;
        AppMethodBeat.o(274037);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(274040);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!p.h(this.value, paramObject.value)) {}
          }
        }
        else
        {
          AppMethodBeat.o(274040);
          return true;
        }
        AppMethodBeat.o(274040);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(274039);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(274039);
          return i;
        }
        AppMethodBeat.o(274039);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(274038);
        String str = "APPID(value=" + this.value + ")";
        AppMethodBeat.o(274038);
        return str;
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.a
    {
      final String value;
      
      public b(String paramString)
      {
        super();
        AppMethodBeat.i(279352);
        this.value = paramString;
        AppMethodBeat.o(279352);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(279358);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (!p.h(this.value, paramObject.value)) {}
          }
        }
        else
        {
          AppMethodBeat.o(279358);
          return true;
        }
        AppMethodBeat.o(279358);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(279356);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(279356);
          return i;
        }
        AppMethodBeat.o(279356);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(279354);
        String str = "USERNAME(value=" + this.value + ")";
        AppMethodBeat.o(279354);
        return str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b
 * JD-Core Version:    0.7.0.1
 */
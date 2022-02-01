package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b
  extends j<a>
{
  private final e db;
  
  public b(e parame)
  {
    super(parame, a.hEe, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
    AppMethodBeat.i(189023);
    this.db = parame;
    AppMethodBeat.o(189023);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(189020);
    p.h(parama, "key");
    p.h(parama, "key");
    a locala = new a();
    locala.field_appId = ((b.a.a)parama).value;
    if (super.get((c)locala, new String[] { "appId" })) {}
    for (parama = locala; parama != null; parama = null)
    {
      AppMethodBeat.o(189020);
      return true;
    }
    AppMethodBeat.o(189020);
    return false;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(189022);
    p.h(parama, "key");
    long l = bt.aQJ();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.b)parama).value;
    locala.field_appId = v.NE(locala.field_username);
    super.replace((c)locala);
    AppMethodBeat.o(189022);
  }
  
  public final void be(final List<String> paramList)
  {
    AppMethodBeat.i(189021);
    p.h(paramList, "usernameList");
    d locald = d.mxg;
    d.a(this.db, (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(189021);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.a
    {
      final String value;
      
      public a(String paramString)
      {
        super();
        AppMethodBeat.i(189011);
        this.value = paramString;
        AppMethodBeat.o(189011);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(189014);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!p.i(this.value, paramObject.value)) {}
          }
        }
        else
        {
          AppMethodBeat.o(189014);
          return true;
        }
        AppMethodBeat.o(189014);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(189013);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(189013);
          return i;
        }
        AppMethodBeat.o(189013);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(189012);
        String str = "APPID(value=" + this.value + ")";
        AppMethodBeat.o(189012);
        return str;
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.a
    {
      final String value;
      
      public b(String paramString)
      {
        super();
        AppMethodBeat.i(189015);
        this.value = paramString;
        AppMethodBeat.o(189015);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(189018);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (!p.i(this.value, paramObject.value)) {}
          }
        }
        else
        {
          AppMethodBeat.o(189018);
          return true;
        }
        AppMethodBeat.o(189018);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(189017);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(189017);
          return i;
        }
        AppMethodBeat.o(189017);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(189016);
        String str = "USERNAME(value=" + this.value + ")";
        AppMethodBeat.o(189016);
        return str;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements d.g.a.a<z>
  {
    b(b paramb, List paramList)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b
 * JD-Core Version:    0.7.0.1
 */
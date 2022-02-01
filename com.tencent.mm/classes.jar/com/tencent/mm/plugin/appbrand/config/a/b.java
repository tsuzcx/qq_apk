package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.plugin.appbrand.config.v;
import com.tencent.mm.plugin.appbrand.x.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bu;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b
  extends j<a>
{
  private final e db;
  
  public b(e parame)
  {
    super(parame, a.hGW, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
    AppMethodBeat.i(223282);
    this.db = parame;
    AppMethodBeat.o(223282);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(223279);
    p.h(parama, "key");
    p.h(parama, "key");
    a locala = new a();
    locala.field_appId = ((b.a.a)parama).value;
    if (super.get((c)locala, new String[] { "appId" })) {}
    for (parama = locala; parama != null; parama = null)
    {
      AppMethodBeat.o(223279);
      return true;
    }
    AppMethodBeat.o(223279);
    return false;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(223281);
    p.h(parama, "key");
    long l = bu.aRi();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.b)parama).value;
    locala.field_appId = v.Om(locala.field_username);
    super.replace((c)locala);
    AppMethodBeat.o(223281);
  }
  
  public final void bg(final List<String> paramList)
  {
    AppMethodBeat.i(223280);
    p.h(paramList, "usernameList");
    d locald = d.mCd;
    d.a(this.db, (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(223280);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.a
    {
      final String value;
      
      public a(String paramString)
      {
        super();
        AppMethodBeat.i(223270);
        this.value = paramString;
        AppMethodBeat.o(223270);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(223273);
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
          AppMethodBeat.o(223273);
          return true;
        }
        AppMethodBeat.o(223273);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(223272);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(223272);
          return i;
        }
        AppMethodBeat.o(223272);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223271);
        String str = "APPID(value=" + this.value + ")";
        AppMethodBeat.o(223271);
        return str;
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.a
    {
      final String value;
      
      public b(String paramString)
      {
        super();
        AppMethodBeat.i(223274);
        this.value = paramString;
        AppMethodBeat.o(223274);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(223277);
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
          AppMethodBeat.o(223277);
          return true;
        }
        AppMethodBeat.o(223277);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(223276);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(223276);
          return i;
        }
        AppMethodBeat.o(223276);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(223275);
        String str = "USERNAME(value=" + this.value + ")";
        AppMethodBeat.o(223275);
        return str;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
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
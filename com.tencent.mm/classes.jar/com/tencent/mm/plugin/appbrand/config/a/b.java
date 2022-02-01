package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.y.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bs;
import d.g.b.k;
import d.y;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b
  extends j<a>
{
  private final e db;
  
  public b(e parame)
  {
    super(parame, a.hlR, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
    AppMethodBeat.i(187129);
    this.db = parame;
    AppMethodBeat.o(187129);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(187126);
    k.h(parama, "key");
    k.h(parama, "key");
    a locala = new a();
    locala.field_appId = ((b.a.a)parama).value;
    if (super.get((c)locala, new String[] { "appId" })) {}
    for (parama = locala; parama != null; parama = null)
    {
      AppMethodBeat.o(187126);
      return true;
    }
    AppMethodBeat.o(187126);
    return false;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(187128);
    k.h(parama, "key");
    long l = bs.aNx();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.b)parama).value;
    locala.field_appId = u.Kl(locala.field_username);
    super.replace((c)locala);
    AppMethodBeat.o(187128);
  }
  
  public final void bc(final List<String> paramList)
  {
    AppMethodBeat.i(187127);
    k.h(paramList, "usernameList");
    d locald = d.lXr;
    d.a(this.db, (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(187127);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.a
    {
      final String value;
      
      public a(String paramString)
      {
        super();
        AppMethodBeat.i(187117);
        this.value = paramString;
        AppMethodBeat.o(187117);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(187120);
        if (this != paramObject)
        {
          if ((paramObject instanceof a))
          {
            paramObject = (a)paramObject;
            if (!k.g(this.value, paramObject.value)) {}
          }
        }
        else
        {
          AppMethodBeat.o(187120);
          return true;
        }
        AppMethodBeat.o(187120);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(187119);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(187119);
          return i;
        }
        AppMethodBeat.o(187119);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(187118);
        String str = "APPID(value=" + this.value + ")";
        AppMethodBeat.o(187118);
        return str;
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.a
    {
      final String value;
      
      public b(String paramString)
      {
        super();
        AppMethodBeat.i(187121);
        this.value = paramString;
        AppMethodBeat.o(187121);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(187124);
        if (this != paramObject)
        {
          if ((paramObject instanceof b))
          {
            paramObject = (b)paramObject;
            if (!k.g(this.value, paramObject.value)) {}
          }
        }
        else
        {
          AppMethodBeat.o(187124);
          return true;
        }
        AppMethodBeat.o(187124);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(187123);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(187123);
          return i;
        }
        AppMethodBeat.o(187123);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(187122);
        String str = "USERNAME(value=" + this.value + ")";
        AppMethodBeat.o(187122);
        return str;
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements d.g.a.a<y>
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
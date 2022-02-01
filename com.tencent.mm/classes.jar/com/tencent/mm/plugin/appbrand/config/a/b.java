package com.tencent.mm.plugin.appbrand.config.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.r;
import com.tencent.mm.plugin.appbrand.config.u;
import com.tencent.mm.plugin.appbrand.z.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import d.g.b.k;
import d.y;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfo;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "batchUpdatePrefetchTime", "", "usernameList", "", "", "contains", "", "key", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "delete", "get", "updatePrefetchTime", "KEY", "plugin-appbrand-integration_release"})
public final class b
  extends j<a>
{
  private final e db;
  
  public b(e parame)
  {
    super(parame, a.gLr, "AppBrandPrefetchWxaAttrsMarkTable", r.INDEX_CREATE);
    AppMethodBeat.i(196264);
    this.db = parame;
    AppMethodBeat.o(196264);
  }
  
  public final boolean a(a parama)
  {
    AppMethodBeat.i(196261);
    k.h(parama, "key");
    k.h(parama, "key");
    a locala = new a();
    locala.field_appId = ((b.a.a)parama).value;
    if (super.get((c)locala, new String[] { "appId" })) {}
    for (parama = locala; parama != null; parama = null)
    {
      AppMethodBeat.o(196261);
      return true;
    }
    AppMethodBeat.o(196261);
    return false;
  }
  
  public final void b(a parama)
  {
    AppMethodBeat.i(196263);
    k.h(parama, "key");
    long l = bt.aGK();
    a locala = new a();
    locala.field_prefetchUpdateTime = l;
    locala.field_username = ((b.a.b)parama).value;
    locala.field_appId = u.Gh(locala.field_username);
    super.replace((c)locala);
    AppMethodBeat.o(196263);
  }
  
  public final void be(final List<String> paramList)
  {
    AppMethodBeat.i(196262);
    k.h(paramList, "usernameList");
    d locald = d.lvx;
    d.a(this.db, (d.g.a.a)new b(this, paramList));
    AppMethodBeat.o(196262);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "", "()V", "APPID", "USERNAME", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "plugin-appbrand-integration_release"})
  public static abstract class a
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$APPID;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class a
      extends b.a
    {
      final String value;
      
      public a(String paramString)
      {
        super();
        AppMethodBeat.i(196252);
        this.value = paramString;
        AppMethodBeat.o(196252);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(196255);
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
          AppMethodBeat.o(196255);
          return true;
        }
        AppMethodBeat.o(196255);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(196254);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(196254);
          return i;
        }
        AppMethodBeat.o(196254);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(196253);
        String str = "APPID(value=" + this.value + ")";
        AppMethodBeat.o(196253);
        return str;
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY$USERNAME;", "Lcom/tencent/mm/plugin/appbrand/config/prefetch/PrefetchWxaAttrsInfoStorage$KEY;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "plugin-appbrand-integration_release"})
    public static final class b
      extends b.a
    {
      final String value;
      
      public b(String paramString)
      {
        super();
        AppMethodBeat.i(196256);
        this.value = paramString;
        AppMethodBeat.o(196256);
      }
      
      public final boolean equals(Object paramObject)
      {
        AppMethodBeat.i(196259);
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
          AppMethodBeat.o(196259);
          return true;
        }
        AppMethodBeat.o(196259);
        return false;
      }
      
      public final int hashCode()
      {
        AppMethodBeat.i(196258);
        String str = this.value;
        if (str != null)
        {
          int i = str.hashCode();
          AppMethodBeat.o(196258);
          return i;
        }
        AppMethodBeat.o(196258);
        return 0;
      }
      
      public final String toString()
      {
        AppMethodBeat.i(196257);
        String str = "USERNAME(value=" + this.value + ")";
        AppMethodBeat.o(196257);
        return str;
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.a.b
 * JD-Core Version:    0.7.0.1
 */
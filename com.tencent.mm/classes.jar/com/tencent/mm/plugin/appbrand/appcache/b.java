package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import d.ac;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearMark", "", "appId", "", "getMark", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "appVersion", "", "insertOrUpdate", "record", "block", "Lkotlin/Function1;", "", "setMark", "mark", "MARK", "plugin-appbrand-integration_release"})
public final class b
  extends com.tencent.mm.plugin.appbrand.x.c<a>
{
  private final e db;
  
  public b(e parame)
  {
    super(parame, a.hGW, "AppBrandSeparatedPluginsCompatMarkTable", a.INDEX_CREATE);
    AppMethodBeat.i(180424);
    this.db = parame;
    AppMethodBeat.o(180424);
  }
  
  public final boolean LF(String paramString)
  {
    AppMethodBeat.i(180421);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(180421);
      return false;
    }
    if (this.db.delete(getTableName(), "appId=?", new String[] { paramString }) > 0)
    {
      AppMethodBeat.o(180421);
      return true;
    }
    AppMethodBeat.o(180421);
    return false;
  }
  
  public final boolean a(String paramString, int paramInt, final a parama)
  {
    AppMethodBeat.i(180422);
    p.h(paramString, "appId");
    p.h(parama, "mark");
    if (a.jIa != parama) {}
    for (int i = 1; (ac.Nhs) && (i == 0); i = 0)
    {
      paramString = (Throwable)new AssertionError("Only NOT_USED(0) and USED(1) are acceptable.");
      AppMethodBeat.o(180422);
      throw paramString;
    }
    a locala = new a();
    locala.field_appId = paramString;
    locala.field_appVersion = paramInt;
    paramString = (d.g.a.b)new b(locala, parama);
    if (super.get((com.tencent.mm.sdk.e.c)locala, new String[0]))
    {
      paramString.invoke(locala);
      bool = super.update((com.tencent.mm.sdk.e.c)locala, new String[0]);
      AppMethodBeat.o(180422);
      return bool;
    }
    paramString.invoke(locala);
    boolean bool = super.insert((com.tencent.mm.sdk.e.c)locala);
    AppMethodBeat.o(180422);
    return bool;
  }
  
  public final a aH(String paramString, int paramInt)
  {
    AppMethodBeat.i(180423);
    p.h(paramString, "appId");
    Object localObject = new a();
    ((a)localObject).field_appId = paramString;
    ((a)localObject).field_appVersion = paramInt;
    if (!super.get((com.tencent.mm.sdk.e.c)localObject, new String[0])) {
      ((a)localObject).field_isSeparatedPluginsUsed = a.jIa.intValue;
    }
    paramString = a.jIe;
    int j = ((a)localObject).field_isSeparatedPluginsUsed;
    localObject = a.values();
    int k = localObject.length;
    paramInt = 0;
    int i;
    if (paramInt < k)
    {
      paramString = localObject[paramInt];
      if (paramString.intValue == j)
      {
        i = 1;
        label104:
        if (i == 0) {
          break label133;
        }
      }
    }
    for (;;)
    {
      localObject = paramString;
      if (paramString == null) {
        localObject = a.jIa;
      }
      AppMethodBeat.o(180423);
      return localObject;
      i = 0;
      break label104;
      label133:
      paramInt += 1;
      break;
      paramString = null;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "", "intValue", "", "(Ljava/lang/String;II)V", "toInt", "NONE", "NOT_USED", "USED", "Companion", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public static final a jIe;
    final int intValue;
    
    static
    {
      AppMethodBeat.i(180417);
      a locala1 = new a("NONE", 0, -1);
      jIa = locala1;
      a locala2 = new a("NOT_USED", 1, 0);
      jIb = locala2;
      a locala3 = new a("USED", 2, 1);
      jIc = locala3;
      jId = new a[] { locala1, locala2, locala3 };
      jIe = new a((byte)0);
      AppMethodBeat.o(180417);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK$Companion;", "", "()V", "valueOfInt", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "intValue", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkRecord;", "invoke"})
  static final class b
    extends q
    implements d.g.a.b<a, z>
  {
    b(a parama, b.a parama1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b
 * JD-Core Version:    0.7.0.1
 */
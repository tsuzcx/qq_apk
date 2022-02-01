package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ab.c;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearMark", "", "appId", "", "getMark", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "appVersion", "", "insertOrUpdate", "record", "block", "Lkotlin/Function1;", "", "setMark", "mark", "MARK", "plugin-appbrand-integration_release"})
public final class b
  extends c<a>
{
  private final ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.iBg, "AppBrandSeparatedPluginsCompatMarkTable", a.INDEX_CREATE);
    AppMethodBeat.i(180424);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(180424);
  }
  
  public final boolean UO(String paramString)
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
  
  public final a aM(String paramString, int paramInt)
  {
    AppMethodBeat.i(180423);
    p.h(paramString, "appId");
    Object localObject = new a();
    ((a)localObject).field_appId = paramString;
    ((a)localObject).field_appVersion = paramInt;
    if (!super.get((IAutoDBItem)localObject, new String[0])) {
      ((a)localObject).field_isSeparatedPluginsUsed = a.kJY.intValue;
    }
    paramString = a.kKc;
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
        localObject = a.kJY;
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "", "intValue", "", "(Ljava/lang/String;II)V", "toInt", "NONE", "NOT_USED", "USED", "Companion", "plugin-appbrand-integration_release"})
  public static enum a
  {
    public static final a kKc;
    final int intValue;
    
    static
    {
      AppMethodBeat.i(180417);
      a locala1 = new a("NONE", 0, -1);
      kJY = locala1;
      a locala2 = new a("NOT_USED", 1, 0);
      kJZ = locala2;
      a locala3 = new a("USED", 2, 1);
      kKa = locala3;
      kKb = new a[] { locala1, locala2, locala3 };
      kKc = new a((byte)0);
      AppMethodBeat.o(180417);
    }
    
    private a(int paramInt)
    {
      this.intValue = paramInt;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK$Companion;", "", "()V", "valueOfInt", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "intValue", "", "plugin-appbrand-integration_release"})
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b
 * JD-Core Version:    0.7.0.1
 */
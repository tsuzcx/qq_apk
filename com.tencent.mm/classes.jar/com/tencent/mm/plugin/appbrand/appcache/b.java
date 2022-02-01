package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ae.c;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage;", "Lcom/tencent/mm/plugin/appbrand/storage/MAutoStorageWithMultiKey;", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "clearMark", "", "appId", "", "getMark", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "appVersion", "", "insertOrUpdate", "record", "block", "Lkotlin/Function1;", "", "setMark", "mark", "MARK", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends c<a>
{
  private final ISQLiteDatabase db;
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, a.nVV, "AppBrandSeparatedPluginsCompatMarkTable", a.INDEX_CREATE);
    AppMethodBeat.i(180424);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(180424);
  }
  
  public final boolean UY(String paramString)
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
  
  public final a bv(String paramString, int paramInt)
  {
    AppMethodBeat.i(180423);
    s.u(paramString, "appId");
    Object localObject = new a();
    ((a)localObject).field_appId = paramString;
    ((a)localObject).field_appVersion = paramInt;
    if (!super.get((IAutoDBItem)localObject, new String[0])) {
      ((a)localObject).field_isSeparatedPluginsUsed = a.qDM.qDL;
    }
    paramString = a.qDK;
    int j = ((a)localObject).field_isSeparatedPluginsUsed;
    localObject = a.values();
    int k = localObject.length;
    paramInt = 0;
    int i;
    if (paramInt < k)
    {
      paramString = localObject[paramInt];
      if (paramString.qDL == j)
      {
        i = 1;
        label104:
        if (i == 0) {
          break label128;
        }
      }
    }
    for (;;)
    {
      if (paramString != null) {
        break label140;
      }
      paramString = a.qDM;
      AppMethodBeat.o(180423);
      return paramString;
      i = 0;
      break label104;
      label128:
      paramInt += 1;
      break;
      paramString = null;
    }
    label140:
    AppMethodBeat.o(180423);
    return paramString;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "", "intValue", "", "(Ljava/lang/String;II)V", "toInt", "NONE", "NOT_USED", "USED", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static enum a
  {
    public static final a qDK;
    final int qDL;
    
    static
    {
      AppMethodBeat.i(180417);
      qDM = new a("NONE", 0, -1);
      qDN = new a("NOT_USED", 1, 0);
      qDO = new a("USED", 2, 1);
      qDP = new a[] { qDM, qDN, qDO };
      qDK = new a((byte)0);
      AppMethodBeat.o(180417);
    }
    
    private a(int paramInt)
    {
      this.qDL = paramInt;
    }
    
    @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK$Companion;", "", "()V", "valueOfInt", "Lcom/tencent/mm/plugin/appbrand/appcache/AppBrandSeparatedPluginsCompatMarkStorage$MARK;", "intValue", "", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b
 * JD-Core Version:    0.7.0.1
 */
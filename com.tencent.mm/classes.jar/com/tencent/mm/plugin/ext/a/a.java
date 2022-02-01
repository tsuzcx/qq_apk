package com.tencent.mm.plugin.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.jj;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ext/db/ManufacturerWxaTokenInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "addToken", "", "token", "userName", "uin", "", "appid", "getAllInfo", "", "getInfo", "Companion", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends MAutoStorage<b>
{
  public static final String[] SQL_CREATE;
  public static final a zOw;
  
  static
  {
    AppMethodBeat.i(39597);
    zOw = new a((byte)0);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(jj.aJm(), "WxaTokenInfo") };
    AppMethodBeat.o(39597);
  }
  
  private a(ISQLiteDatabase paramISQLiteDatabase, IAutoDBItem.MAutoDBInfo paramMAutoDBInfo, String paramString)
  {
    super(paramISQLiteDatabase, paramMAutoDBInfo, paramString, null);
  }
  
  public a(h paramh)
  {
    this(paramh, b.access$getInfo$cp(), "WxaTokenInfo");
    AppMethodBeat.i(39596);
    AppMethodBeat.o(39596);
  }
  
  public final b atu(String paramString)
  {
    AppMethodBeat.i(39595);
    s.u(paramString, "token");
    b localb = new b();
    localb.field_token = paramString;
    if (!get((IAutoDBItem)localb, new String[0]))
    {
      AppMethodBeat.o(39595);
      return null;
    }
    AppMethodBeat.o(39595);
    return localb;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/ext/db/ManufacturerWxaTokenInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "app_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.a.a
 * JD-Core Version:    0.7.0.1
 */
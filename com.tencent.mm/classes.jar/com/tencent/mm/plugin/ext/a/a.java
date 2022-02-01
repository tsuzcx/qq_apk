package com.tencent.mm.plugin.ext.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.hp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.storagebase.h;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ext/db/ManufacturerWxaTokenInfoStorage;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/ext/db/WxaTokenInfo;", "dataDB", "Lcom/tencent/mm/storagebase/SqliteDB;", "(Lcom/tencent/mm/storagebase/SqliteDB;)V", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "dbInfo", "Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;", "table", "", "indexCreate", "", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;Lcom/tencent/mm/sdk/storage/IAutoDBItem$MAutoDBInfo;Ljava/lang/String;[Ljava/lang/String;)V", "addToken", "", "token", "userName", "uin", "", "appid", "getAllInfo", "", "getInfo", "Companion", "app_release"})
public final class a
  extends j<b>
{
  public static final String[] SQL_CREATE;
  public static final a rcJ;
  
  static
  {
    AppMethodBeat.i(39597);
    rcJ = new a((byte)0);
    SQL_CREATE = new String[] { j.getCreateSQLs(hp.Vv(), "WxaTokenInfo") };
    AppMethodBeat.o(39597);
  }
  
  private a(e parame, c.a parama, String paramString)
  {
    super(parame, parama, paramString, null);
  }
  
  public a(h paramh)
  {
    this(paramh, b.access$getInfo$cp(), "WxaTokenInfo");
    AppMethodBeat.i(39596);
    AppMethodBeat.o(39596);
  }
  
  public final b afG(String paramString)
  {
    AppMethodBeat.i(39595);
    p.h(paramString, "token");
    b localb = new b();
    localb.field_token = paramString;
    if (!get((c)localb, new String[0]))
    {
      AppMethodBeat.o(39595);
      return null;
    }
    AppMethodBeat.o(39595);
    return localb;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/ext/db/ManufacturerWxaTokenInfoStorage$Companion;", "", "()V", "SQL_CREATE", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "app_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.a.a
 * JD-Core Version:    0.7.0.1
 */
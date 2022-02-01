package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;

public final class j
  extends MAutoStorage<i>
{
  public static final String[] SQL_CREATE;
  private ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(112783);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.info, "CardQrCodeConfi") };
    AppMethodBeat.o(112783);
  }
  
  public j(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, i.info, "CardQrCodeConfi", null);
    this.db = paramISQLiteDatabase;
  }
  
  public final i aqY(String paramString)
  {
    AppMethodBeat.i(112782);
    i locali = new i();
    locali.field_card_id = paramString;
    if (get(locali, new String[0]))
    {
      AppMethodBeat.o(112782);
      return locali;
    }
    AppMethodBeat.o(112782);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.card.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
{
  public static final String[] SQL_CREATE;
  private e db;
  
  static
  {
    AppMethodBeat.i(87841);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(i.info, "CardQrCodeConfi") };
    AppMethodBeat.o(87841);
  }
  
  public j(e parame)
  {
    super(parame, i.info, "CardQrCodeConfi", null);
    this.db = parame;
  }
  
  public final i HK(String paramString)
  {
    AppMethodBeat.i(87840);
    i locali = new i();
    locali.field_card_id = paramString;
    if (get(locali, new String[0]))
    {
      AppMethodBeat.o(87840);
      return locali;
    }
    AppMethodBeat.o(87840);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.j
 * JD-Core Version:    0.7.0.1
 */
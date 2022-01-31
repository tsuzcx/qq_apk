package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.g;
import com.tencent.mm.cg.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  public n gxE;
  
  static
  {
    AppMethodBeat.i(21941);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(i.info, "IPCallPopularCountry") };
    AppMethodBeat.o(21941);
  }
  
  public j(e parame)
  {
    super(parame, i.info, "IPCallPopularCountry", null);
    AppMethodBeat.i(21938);
    this.gxE = new j.1(this);
    this.db = parame;
    AppMethodBeat.o(21938);
  }
  
  public final void U(int paramInt, long paramLong)
  {
    AppMethodBeat.i(21939);
    i locali = new i();
    Cursor localCursor = this.db.a("IPCallPopularCountry", null, "countryCode=?", new String[] { Integer.toString(paramInt) }, null, null, null, 2);
    boolean bool;
    if (!localCursor.moveToFirst())
    {
      ab.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:".concat(String.valueOf(paramInt)));
      localCursor.close();
      locali.field_countryCode = paramInt;
      locali.field_lastCallTime = paramLong;
      locali.field_callTimeCount = 1L;
      bool = insert(locali);
    }
    for (;;)
    {
      ab.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:".concat(String.valueOf(bool)));
      AppMethodBeat.o(21939);
      return;
      locali.convertFrom(localCursor);
      locali.field_callTimeCount += 1L;
      locali.field_lastCallTime = paramLong;
      bool = super.replace(locali);
      localCursor.close();
    }
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final ArrayList<Integer> bJW()
  {
    AppMethodBeat.i(21940);
    ArrayList localArrayList = new ArrayList();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" ORDER BY IPCallPopularCountry.callTimeCount DESC,IPCallPopularCountry.lastCallTime DESC");
    localObject = this.db.a("SELECT IPCallPopularCountry.countryCode,IPCallPopularCountry.callTimeCount,IPCallPopularCountry.lastCallTime FROM IPCallPopularCountry  " + ((StringBuilder)localObject).toString(), null, 2);
    if ((localObject != null) && (((Cursor)localObject).moveToFirst()))
    {
      new ArrayList();
      do
      {
        i locali = new i();
        locali.convertFrom((Cursor)localObject);
        localArrayList.add(Integer.valueOf(locali.field_countryCode));
      } while (((Cursor)localObject).moveToNext());
    }
    if (localObject != null) {
      ((Cursor)localObject).close();
    }
    AppMethodBeat.o(21940);
    return localArrayList;
  }
  
  public final String getTableName()
  {
    return "IPCallPopularCountry";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.j
 * JD-Core Version:    0.7.0.1
 */
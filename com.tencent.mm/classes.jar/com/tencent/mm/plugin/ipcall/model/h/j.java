package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storagebase.g;
import com.tencent.mm.storagebase.g.a;
import java.util.ArrayList;

public final class j
  extends com.tencent.mm.sdk.e.j<i>
  implements g.a
{
  public static final String[] SQL_CREATE;
  private e db;
  public n ikB;
  
  static
  {
    AppMethodBeat.i(25556);
    SQL_CREATE = new String[] { com.tencent.mm.sdk.e.j.getCreateSQLs(i.info, "IPCallPopularCountry") };
    AppMethodBeat.o(25556);
  }
  
  public j(e parame)
  {
    super(parame, i.info, "IPCallPopularCountry", null);
    AppMethodBeat.i(25553);
    this.ikB = new n()
    {
      public final boolean aIE()
      {
        AppMethodBeat.i(25552);
        if ((j.a(j.this) == null) || (j.a(j.this).eHe()))
        {
          if (j.a(j.this) == null) {}
          for (Object localObject = "null";; localObject = Boolean.valueOf(j.a(j.this).eHe()))
          {
            ad.w("MicroMsg.IPCallPopularCountryStorage", "shouldProcessEvent db is close :%s", new Object[] { localObject });
            AppMethodBeat.o(25552);
            return false;
          }
        }
        AppMethodBeat.o(25552);
        return true;
      }
    };
    this.db = parame;
    AppMethodBeat.o(25553);
  }
  
  public final int a(g paramg)
  {
    this.db = paramg;
    return 0;
  }
  
  public final void aj(int paramInt, long paramLong)
  {
    AppMethodBeat.i(25554);
    i locali = new i();
    Cursor localCursor = this.db.a("IPCallPopularCountry", null, "countryCode=?", new String[] { Integer.toString(paramInt) }, null, null, null, 2);
    boolean bool;
    if (!localCursor.moveToFirst())
    {
      ad.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:".concat(String.valueOf(paramInt)));
      localCursor.close();
      locali.field_countryCode = paramInt;
      locali.field_lastCallTime = paramLong;
      locali.field_callTimeCount = 1L;
      bool = insert(locali);
    }
    for (;;)
    {
      ad.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:".concat(String.valueOf(bool)));
      AppMethodBeat.o(25554);
      return;
      locali.convertFrom(localCursor);
      locali.field_callTimeCount += 1L;
      locali.field_lastCallTime = paramLong;
      bool = super.replace(locali);
      localCursor.close();
    }
  }
  
  public final ArrayList<Integer> cHS()
  {
    AppMethodBeat.i(25555);
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
    AppMethodBeat.o(25555);
    return localArrayList;
  }
  
  public final String getTableName()
  {
    return "IPCallPopularCountry";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.j
 * JD-Core Version:    0.7.0.1
 */
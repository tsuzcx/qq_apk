package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.cf.g;
import com.tencent.mm.cf.g.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.y;

public final class j
  extends com.tencent.mm.sdk.e.i<i>
  implements g.a
{
  public static final String[] dXp = { com.tencent.mm.sdk.e.i.a(i.buS, "IPCallPopularCountry") };
  public e dXw;
  public m ffW = new j.1(this);
  
  public j(e parame)
  {
    super(parame, i.buS, "IPCallPopularCountry", null);
    this.dXw = parame;
  }
  
  public final void C(int paramInt, long paramLong)
  {
    i locali = new i();
    Cursor localCursor = this.dXw.a("IPCallPopularCountry", null, "countryCode=?", new String[] { Integer.toString(paramInt) }, null, null, null, 2);
    boolean bool;
    if (!localCursor.moveToFirst())
    {
      y.i("MicroMsg.IPCallPopularCountryStorage", "get null with countryCode:" + paramInt);
      localCursor.close();
      locali.field_countryCode = paramInt;
      locali.field_lastCallTime = paramLong;
      locali.field_callTimeCount = 1L;
      bool = b(locali);
    }
    for (;;)
    {
      y.i("MicroMsg.IPCallPopularCountryStorage", "updatePopularCountryCode ret:" + bool);
      return;
      locali.d(localCursor);
      locali.field_callTimeCount += 1L;
      locali.field_lastCallTime = paramLong;
      bool = super.a(locali);
      localCursor.close();
    }
  }
  
  public final int a(g paramg)
  {
    if (paramg != null) {
      this.dXw = paramg;
    }
    return 0;
  }
  
  public final String getTableName()
  {
    return "IPCallPopularCountry";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.j
 * JD-Core Version:    0.7.0.1
 */
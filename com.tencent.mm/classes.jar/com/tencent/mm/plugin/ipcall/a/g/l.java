package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class l
  extends i<k>
{
  public static final String[] dXp = { i.a(k.buS, "IPCallRecord") };
  public static final String[] lsR = { "*", "rowid" };
  public e dXw;
  
  public l(e parame)
  {
    super(parame, k.buS, "IPCallRecord", null);
    this.dXw = parame;
  }
  
  public final Cursor FE(String paramString)
  {
    return this.dXw.query("IPCallRecord", lsR, "phonenumber=?", new String[] { paramString }, null, null, "calltime desc");
  }
  
  public final void a(k paramk)
  {
    if (paramk != null) {
      a(paramk.ujK, paramk);
    }
  }
  
  public final Cursor eX(long paramLong)
  {
    return this.dXw.query("IPCallRecord", lsR, "addressId=?", new String[] { String.valueOf(paramLong) }, null, null, "calltime desc");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  public h gPa;
  
  static
  {
    AppMethodBeat.i(151333);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "OpenIMAppIdInfo") };
    AppMethodBeat.o(151333);
  }
  
  public d(h paramh)
  {
    super(paramh, c.info, "OpenIMAppIdInfo", null);
    this.gPa = paramh;
  }
  
  public final List<String> Bm(String paramString)
  {
    AppMethodBeat.i(151331);
    LinkedList localLinkedList = new LinkedList();
    paramString = this.gPa.a("select distinct appid from OpenIMAppIdInfo where appid=? ", new String[] { paramString }, 2);
    if (paramString.moveToFirst()) {
      do
      {
        String str = paramString.getString(0);
        if (!bt.isNullOrNil(str)) {
          localLinkedList.add(str);
        }
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(151331);
    return localLinkedList;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(151330);
    paramc.field_updateTime = bt.aGK();
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(151330);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.e.d
 * JD-Core Version:    0.7.0.1
 */
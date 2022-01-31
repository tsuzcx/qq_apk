package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  public h fnw;
  
  static
  {
    AppMethodBeat.i(78989);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "OpenIMAppIdInfo") };
    AppMethodBeat.o(78989);
  }
  
  public d(h paramh)
  {
    super(paramh, c.info, "OpenIMAppIdInfo", null);
    this.fnw = paramh;
  }
  
  public final boolean a(c paramc)
  {
    AppMethodBeat.i(78986);
    paramc.field_updateTime = bo.aox();
    boolean bool = super.replace(paramc);
    AppMethodBeat.o(78986);
    return bool;
  }
  
  public final List<String> wo(String paramString)
  {
    AppMethodBeat.i(78987);
    LinkedList localLinkedList = new LinkedList();
    paramString = this.fnw.a("select distinct appid from OpenIMAppIdInfo where appid=? ", new String[] { paramString }, 2);
    if (paramString.moveToFirst()) {
      do
      {
        String str = paramString.getString(0);
        if (!bo.isNullOrNil(str)) {
          localLinkedList.add(str);
        }
      } while (paramString.moveToNext());
    }
    paramString.close();
    AppMethodBeat.o(78987);
    return localLinkedList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.openim.e.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public final class f
  extends j<e>
{
  public static final String[] SQL_CREATE;
  public h fnw;
  
  static
  {
    AppMethodBeat.i(78994);
    SQL_CREATE = new String[] { j.getCreateSQLs(e.info, "OpenIMWordingInfo") };
    AppMethodBeat.o(78994);
  }
  
  public f(h paramh)
  {
    super(paramh, e.info, "OpenIMWordingInfo", null);
    this.fnw = paramh;
  }
  
  public final List<String> E(int paramInt, String paramString)
  {
    AppMethodBeat.i(78992);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = " select wordingId from OpenIMWordingInfo where language='" + paramString + "' order by updateTime limit " + paramInt;
    ab.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", new Object[] { localObject });
    localObject = this.fnw.a((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        String str = ((Cursor)localObject).getString(0);
        if (!bo.isNullOrNil(str)) {
          localLinkedList.add(str);
        }
      } while (((Cursor)localObject).moveToNext());
    }
    ab.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", new Object[] { Integer.valueOf(localLinkedList.size()), paramString });
    ((Cursor)localObject).close();
    AppMethodBeat.o(78992);
    return localLinkedList;
  }
  
  public final boolean a(e parame)
  {
    AppMethodBeat.i(78991);
    parame.field_updateTime = bo.aox();
    boolean bool = super.replace(parame);
    AppMethodBeat.o(78991);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.openim.e.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.LinkedList;
import java.util.List;

public class h
  extends MAutoStorage<g>
{
  public static final String[] SQL_CREATE;
  public com.tencent.mm.storagebase.h lvy;
  
  static
  {
    AppMethodBeat.i(151338);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(g.info, "OpenIMWordingInfo") };
    AppMethodBeat.o(151338);
  }
  
  public h(com.tencent.mm.storagebase.h paramh)
  {
    super(paramh, g.info, "OpenIMWordingInfo", null);
    this.lvy = paramh;
  }
  
  public final List<String> U(int paramInt, String paramString)
  {
    AppMethodBeat.i(151336);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = " select wordingId from OpenIMWordingInfo where language='" + paramString + "' order by updateTime limit " + paramInt;
    Log.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", new Object[] { localObject });
    localObject = this.lvy.rawQuery((String)localObject, null, 2);
    if (((Cursor)localObject).moveToFirst()) {
      do
      {
        String str = ((Cursor)localObject).getString(0);
        if (!Util.isNullOrNil(str)) {
          localLinkedList.add(str);
        }
      } while (((Cursor)localObject).moveToNext());
    }
    Log.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording result cnt: %d, language:%s", new Object[] { Integer.valueOf(localLinkedList.size()), paramString });
    ((Cursor)localObject).close();
    AppMethodBeat.o(151336);
    return localLinkedList;
  }
  
  public final boolean a(g paramg)
  {
    AppMethodBeat.i(151335);
    paramg.field_updateTime = Util.nowSecond();
    boolean bool = super.replace(paramg);
    AppMethodBeat.o(151335);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.openim.e.h
 * JD-Core Version:    0.7.0.1
 */
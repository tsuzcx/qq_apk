package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.LinkedList;
import java.util.List;

public class l
  extends MAutoStorage<k>
{
  public static final String[] SQL_CREATE;
  public h omV;
  
  static
  {
    AppMethodBeat.i(151338);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(k.info, "OpenIMWordingInfo") };
    AppMethodBeat.o(151338);
  }
  
  public l(h paramh)
  {
    super(paramh, k.info, "OpenIMWordingInfo", null);
    this.omV = paramh;
  }
  
  public final boolean a(k paramk)
  {
    AppMethodBeat.i(151335);
    paramk.field_updateTime = Util.nowSecond();
    boolean bool = super.replace(paramk);
    AppMethodBeat.o(151335);
    return bool;
  }
  
  public final List<String> ac(int paramInt, String paramString)
  {
    AppMethodBeat.i(151336);
    LinkedList localLinkedList = new LinkedList();
    Object localObject = " select wordingId from OpenIMWordingInfo where language='" + paramString + "' order by updateTime limit " + paramInt;
    Log.d("MicroMsg.Openim.OpenIMWordingInfoStg", "getLastWording sql:%s", new Object[] { localObject });
    localObject = this.omV.rawQuery((String)localObject, null, 2);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.e.l
 * JD-Core Version:    0.7.0.1
 */
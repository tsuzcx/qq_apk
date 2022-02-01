package com.tencent.mm.openim.e;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;

public class j
  extends MAutoStorage<i>
{
  public static final String[] SQL_CREATE;
  private h omV;
  
  static
  {
    AppMethodBeat.i(235751);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(i.info, "OpenIMSnsFlag") };
    AppMethodBeat.o(235751);
  }
  
  public j(h paramh)
  {
    super(paramh, i.info, "OpenIMSnsFlag", null);
    this.omV = paramh;
  }
  
  public final long RV(String paramString)
  {
    long l = 0L;
    AppMethodBeat.i(235758);
    Object localObject = "SELECT * FROM OpenIMSnsFlag WHERE openIMUsername = \"" + paramString + "\"";
    Log.d("MicroMsg.Openim.OpenIMSnsFlagStg", "getFlag:".concat(String.valueOf(localObject)));
    localObject = this.omV.rawQuery((String)localObject, null, 2);
    if (localObject == null)
    {
      Log.e("MicroMsg.Openim.OpenIMSnsFlagStg", "getFlag failed, openIMUsername:%s", new Object[] { paramString });
      AppMethodBeat.o(235758);
      return 0L;
    }
    if (((Cursor)localObject).moveToFirst())
    {
      paramString = new i();
      paramString.convertFrom((Cursor)localObject);
      l = paramString.field_openIMSnsFlag;
    }
    ((Cursor)localObject).close();
    AppMethodBeat.o(235758);
    return l;
  }
  
  public final boolean a(i parami)
  {
    AppMethodBeat.i(235754);
    Log.i("MicroMsg.Openim.OpenIMSnsFlagStg", "replace " + parami.field_openIMUsername + "," + parami.field_openIMSnsFlag);
    boolean bool = super.replace(parami);
    AppMethodBeat.o(235754);
    return bool;
  }
  
  public final void bSr()
  {
    AppMethodBeat.i(235763);
    long l4 = System.currentTimeMillis();
    l2 = 0L;
    l1 = l2;
    try
    {
      long l3 = this.omV.beginTransaction(-1L);
      l1 = l3;
      l2 = l3;
      this.omV.execSQL("OpenIMSnsFlag", "DROP TABLE OpenIMSnsFlag");
      l1 = l3;
      l2 = l3;
      this.omV.execSQL("OpenIMSnsFlag", SQL_CREATE[0]);
      this.omV.endTransaction(l3);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        l2 = l1;
        Log.e("MicroMsg.Openim.OpenIMSnsFlagStg", "drop table Error :" + localException.getMessage());
        this.omV.endTransaction(l1);
      }
    }
    finally
    {
      this.omV.endTransaction(l2);
      AppMethodBeat.o(235763);
    }
    Log.i("MicroMsg.Openim.OpenIMSnsFlagStg", "deleteTable cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l4) });
    AppMethodBeat.o(235763);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.openim.e.j
 * JD-Core Version:    0.7.0.1
 */
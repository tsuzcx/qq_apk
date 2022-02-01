package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends MAutoStorage<f>
  implements t
{
  private ISQLiteDatabase db;
  
  public c(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, f.info, "FavEditInfo", null);
    AppMethodBeat.i(101685);
    this.db = paramISQLiteDatabase;
    this.db.execSQL("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
    AppMethodBeat.o(101685);
  }
  
  public final f DX(long paramLong)
  {
    f localf = null;
    AppMethodBeat.i(101686);
    Cursor localCursor = this.db.rawQuery("select * from FavEditInfo where localId =  ? and type =  ?", new String[] { String.valueOf(paramLong), "0" }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(101686);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localf = new f();
      localf.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(101686);
    return localf;
  }
  
  public final List<f> cUO()
  {
    AppMethodBeat.i(101688);
    Cursor localCursor = this.db.rawQuery("select count(*) from FavEditInfo", null, 2);
    if (localCursor == null)
    {
      Log.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
      AppMethodBeat.o(101688);
      return null;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        Log.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", new Object[] { Integer.valueOf(localCursor.getInt(0)) });
      }
      localCursor.close();
      localCursor = this.db.rawQuery("select * from FavEditInfo", null, 2);
      if (localCursor == null)
      {
        AppMethodBeat.o(101688);
        return null;
      }
    }
    catch (Exception localException1)
    {
      Log.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", localException1, "", new Object[0]);
      localCursor.close();
      AppMethodBeat.o(101688);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    try
    {
      if (localCursor.moveToFirst())
      {
        boolean bool;
        do
        {
          f localf = new f();
          localf.convertFrom(localCursor);
          localArrayList.add(localf);
          bool = localCursor.moveToNext();
        } while (bool);
      }
      localCursor.close();
      AppMethodBeat.o(101688);
      return localArrayList;
    }
    catch (Exception localException2)
    {
      Log.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", localException2, "", new Object[0]);
      localCursor.close();
      AppMethodBeat.o(101688);
    }
    return null;
  }
  
  public final void y(long paramLong, int paramInt)
  {
    AppMethodBeat.i(101687);
    this.db.delete("FavEditInfo", "localId=? and type=?", new String[] { String.valueOf(paramLong), String.valueOf(paramInt) });
    AppMethodBeat.o(101687);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends j<f>
  implements t
{
  private e db;
  
  public c(e parame)
  {
    super(parame, f.info, "FavEditInfo", null);
    AppMethodBeat.i(5425);
    this.db = parame;
    this.db.execSQL("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
    AppMethodBeat.o(5425);
  }
  
  public final List<f> bwH()
  {
    AppMethodBeat.i(5428);
    Cursor localCursor = this.db.a("select count(*) from FavEditInfo", null, 2);
    if (localCursor == null)
    {
      ab.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
      AppMethodBeat.o(5428);
      return null;
    }
    try
    {
      if (localCursor.moveToFirst()) {
        ab.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", new Object[] { Integer.valueOf(localCursor.getInt(0)) });
      }
      localCursor.close();
      localCursor = this.db.a("select * from FavEditInfo", null, 2);
      if (localCursor == null)
      {
        AppMethodBeat.o(5428);
        return null;
      }
    }
    catch (Exception localException1)
    {
      ab.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", localException1, "", new Object[0]);
      localCursor.close();
      AppMethodBeat.o(5428);
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
      AppMethodBeat.o(5428);
      return localArrayList;
    }
    catch (Exception localException2)
    {
      ab.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", localException2, "", new Object[0]);
      localCursor.close();
      AppMethodBeat.o(5428);
    }
    return null;
  }
  
  public final f ka(long paramLong)
  {
    f localf = null;
    AppMethodBeat.i(5426);
    Cursor localCursor = this.db.a("select * from FavEditInfo where localId =  ? and type =  ?", new String[] { String.valueOf(paramLong), "0" }, 2);
    if (localCursor == null)
    {
      AppMethodBeat.o(5426);
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localf = new f();
      localf.convertFrom(localCursor);
    }
    localCursor.close();
    AppMethodBeat.o(5426);
    return localf;
  }
  
  public final void u(long paramLong, int paramInt)
  {
    AppMethodBeat.i(5427);
    this.db.delete("FavEditInfo", "localId=? and type=?", new String[] { String.valueOf(paramLong), String.valueOf(paramInt) });
    AppMethodBeat.o(5427);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.c
 * JD-Core Version:    0.7.0.1
 */
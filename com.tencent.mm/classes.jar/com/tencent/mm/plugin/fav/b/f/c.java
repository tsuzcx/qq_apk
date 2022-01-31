package com.tencent.mm.plugin.fav.b.f;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.t;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class c
  extends i<f>
  implements t
{
  private e dXw;
  
  public c(e parame)
  {
    super(parame, f.buS, "FavEditInfo", null);
    this.dXw = parame;
    this.dXw.gk("FavEditInfo", "CREATE INDEX IF NOT EXISTS IndexLocalId_Type ON FavEditInfo(localId,type);");
  }
  
  public final List<f> aQs()
  {
    localCursor = this.dXw.a("select count(*) from FavEditInfo", null, 2);
    if (localCursor == null) {
      y.e("MicroMsg.Fav.FavEditInfoStorage", "count all edit info, cursor is null");
    }
    for (;;)
    {
      return null;
      try
      {
        if (localCursor.moveToFirst()) {
          y.i("MicroMsg.Fav.FavEditInfoStorage", "get all edit infos, count %d", new Object[] { Integer.valueOf(localCursor.getInt(0)) });
        }
        localCursor.close();
        localCursor = this.dXw.a("select * from FavEditInfo", null, 2);
        if (localCursor == null) {
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        f localf;
        boolean bool;
        return null;
      }
      catch (Exception localException1)
      {
        try
        {
          if (localCursor.moveToFirst()) {
            do
            {
              localf = new f();
              localf.d(localCursor);
              localArrayList.add(localf);
              bool = localCursor.moveToNext();
            } while (bool);
          }
          localCursor.close();
          return localArrayList;
        }
        catch (Exception localException2)
        {
          y.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", localException2, "", new Object[0]);
          localCursor.close();
        }
        localException1 = localException1;
        y.printErrStackTrace("MicroMsg.Fav.FavEditInfoStorage", localException1, "", new Object[0]);
        localCursor.close();
        return null;
      }
    }
  }
  
  public final f eD(long paramLong)
  {
    f localf = null;
    Cursor localCursor = this.dXw.a("select * from FavEditInfo where localId =  ? and type =  ?", new String[] { String.valueOf(paramLong), "0" }, 2);
    if (localCursor == null) {
      return null;
    }
    if (localCursor.moveToFirst())
    {
      localf = new f();
      localf.d(localCursor);
    }
    localCursor.close();
    return localf;
  }
  
  public final void p(long paramLong, int paramInt)
  {
    this.dXw.delete("FavEditInfo", "localId=? and type=?", new String[] { String.valueOf(paramLong), String.valueOf(paramInt) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.b.f.c
 * JD-Core Version:    0.7.0.1
 */
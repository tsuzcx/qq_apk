package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  extends j<c>
{
  public static final String[] SQL_CREATE;
  private static final String[] nQd;
  public e db;
  
  static
  {
    AppMethodBeat.i(21932);
    SQL_CREATE = new String[] { j.getCreateSQLs(c.info, "IPCallAddressItem") };
    nQd = new String[] { "*", "rowid" };
    AppMethodBeat.o(21932);
  }
  
  public d(e parame)
  {
    super(parame, c.info, "IPCallAddressItem", null);
    this.db = parame;
  }
  
  private Cursor Rd(String paramString)
  {
    AppMethodBeat.i(21929);
    paramString = this.db.query("IPCallAddressItem", nQd, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[] { "%" + paramString + "%", "%" + paramString + "%" }, null, null, "upper(sortKey) asc");
    AppMethodBeat.o(21929);
    return paramString;
  }
  
  public final c Ra(String paramString)
  {
    AppMethodBeat.i(21923);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21923);
      return null;
    }
    paramString = this.db.a("IPCallAddressItem", nQd, "contactId=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        c localc = new c();
        localc.convertFrom(paramString);
        return localc;
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.IPCallAddressStorage", "getByContactId error: %s", new Object[] { localException.getMessage() });
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label151;
      }
      paramString.close();
      AppMethodBeat.o(21923);
    }
    AppMethodBeat.o(21923);
    return null;
  }
  
  public final c Rb(String paramString)
  {
    AppMethodBeat.i(21924);
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(21924);
      return null;
    }
    paramString = this.db.a("IPCallAddressItem", nQd, "systemAddressBookUsername=?", new String[] { paramString }, null, null, null, 2);
    try
    {
      if (paramString.moveToFirst())
      {
        c localc = new c();
        localc.convertFrom(paramString);
        return localc;
      }
      if (paramString != null) {
        paramString.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.d("MicroMsg.IPCallAddressStorage", "getByContactName error: %s", new Object[] { localException.getMessage() });
        if (paramString != null) {
          paramString.close();
        }
      }
    }
    finally
    {
      if (paramString == null) {
        break label151;
      }
      paramString.close();
      AppMethodBeat.o(21924);
    }
    AppMethodBeat.o(21924);
    return null;
  }
  
  public final Cursor Rc(String paramString)
  {
    AppMethodBeat.i(21928);
    System.currentTimeMillis();
    int i = 0;
    if (i < paramString.length()) {
      if (!Character.isDigit(paramString.charAt(i)))
      {
        i = 0;
        label33:
        if (i != 0) {
          break label67;
        }
      }
    }
    for (paramString = Rd(paramString);; paramString = this.db.query("IPCallAddressItem", nQd, "contactId IN ".concat(String.valueOf(paramString)), null, null, null, "upper(sortKey) asc"))
    {
      System.currentTimeMillis();
      AppMethodBeat.o(21928);
      return paramString;
      i += 1;
      break;
      i = 1;
      break label33;
      label67:
      Object localObject1 = a.RI(paramString);
      paramString = Rd(paramString);
      try
      {
        if (paramString.moveToFirst()) {
          while (!paramString.isAfterLast())
          {
            ((ArrayList)localObject1).add(paramString.getString(paramString.getColumnIndex("contactId")));
            paramString.moveToNext();
          }
        }
        String str2;
        str1 = paramString;
      }
      catch (Exception localException)
      {
        ab.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", new Object[] { localException.getMessage() });
        if (paramString != null) {
          paramString.close();
        }
        for (;;)
        {
          localObject1 = ((ArrayList)localObject1).iterator();
          for (paramString = ""; ((Iterator)localObject1).hasNext(); paramString = paramString + str2 + ",") {
            str2 = (String)((Iterator)localObject1).next();
          }
          if (paramString != null) {
            paramString.close();
          }
        }
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(21928);
      }
      String str1;
      if (paramString.lastIndexOf(",") >= 0) {
        str1 = paramString.substring(0, paramString.lastIndexOf(","));
      }
      paramString = "(" + str1 + ")";
    }
  }
  
  public final ArrayList<c> bJU()
  {
    AppMethodBeat.i(21926);
    Cursor localCursor = this.db.a("IPCallAddressItem", nQd, null, null, null, null, null, 2);
    if (localCursor != null) {}
    try
    {
      if (localCursor.moveToFirst())
      {
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          c localc = new c();
          localc.convertFrom(localCursor);
          localArrayList.add(localc);
          bool = localCursor.moveToNext();
        } while (bool);
        return localArrayList;
      }
      return null;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.IPCallAddressStorage", "getAllAddress, error: %s", new Object[] { localException.getMessage() });
      return null;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(21926);
    }
  }
  
  public final Cursor bJV()
  {
    AppMethodBeat.i(21927);
    Cursor localCursor = this.db.query("IPCallAddressItem", nQd, null, null, null, null, "upper(sortKey) asc");
    AppMethodBeat.o(21927);
    return localCursor;
  }
  
  public final c kq(long paramLong)
  {
    AppMethodBeat.i(21925);
    localCursor = this.db.a("IPCallAddressItem", nQd, "rowid=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    try
    {
      if (localCursor.moveToFirst())
      {
        c localc = new c();
        localc.convertFrom(localCursor);
        return localc;
      }
      if (localCursor != null) {
        localCursor.close();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.d("MicroMsg.IPCallAddressStorage", "getByLocalId error: %s", new Object[] { localException.getMessage() });
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
    finally
    {
      if (localCursor == null) {
        break label145;
      }
      localCursor.close();
      AppMethodBeat.o(21925);
    }
    AppMethodBeat.o(21925);
    return null;
  }
  
  public final long kr(long paramLong)
  {
    AppMethodBeat.i(21930);
    if ((this.db instanceof h))
    {
      paramLong = ((h)this.db).kr(paramLong);
      AppMethodBeat.o(21930);
      return paramLong;
    }
    AppMethodBeat.o(21930);
    return -1L;
  }
  
  public final void ks(long paramLong)
  {
    AppMethodBeat.i(21931);
    if (((this.db instanceof h)) && (paramLong != -1L)) {
      ((h)this.db).nY(paramLong);
    }
    AppMethodBeat.o(21931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.ipcall.model.h;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ipcall.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  extends MAutoStorage<c>
{
  private static final String[] DSJ;
  public static final String[] SQL_CREATE;
  public ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(25547);
    SQL_CREATE = new String[] { MAutoStorage.getCreateSQLs(c.info, "IPCallAddressItem") };
    DSJ = new String[] { "*", "rowid" };
    AppMethodBeat.o(25547);
  }
  
  public d(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.info, "IPCallAddressItem", null);
    this.db = paramISQLiteDatabase;
  }
  
  private Cursor aMf(String paramString)
  {
    AppMethodBeat.i(25544);
    paramString = this.db.query("IPCallAddressItem", DSJ, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[] { "%" + paramString + "%", "%" + paramString + "%" }, null, null, "upper(sortKey) asc");
    AppMethodBeat.o(25544);
    return paramString;
  }
  
  public final c Og(long paramLong)
  {
    AppMethodBeat.i(25540);
    localCursor = this.db.query("IPCallAddressItem", DSJ, "rowid=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
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
        Log.d("MicroMsg.IPCallAddressStorage", "getByLocalId error: %s", new Object[] { localException.getMessage() });
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
      AppMethodBeat.o(25540);
    }
    AppMethodBeat.o(25540);
    return null;
  }
  
  public final void Oh(long paramLong)
  {
    AppMethodBeat.i(25546);
    if (((this.db instanceof h)) && (paramLong != -1L)) {
      ((h)this.db).endTransaction(paramLong);
    }
    AppMethodBeat.o(25546);
  }
  
  public final c aMc(String paramString)
  {
    AppMethodBeat.i(25538);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25538);
      return null;
    }
    paramString = this.db.query("IPCallAddressItem", DSJ, "contactId=?", new String[] { paramString }, null, null, null, 2);
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
        Log.e("MicroMsg.IPCallAddressStorage", "getByContactId error: %s", new Object[] { localException.getMessage() });
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
      AppMethodBeat.o(25538);
    }
    AppMethodBeat.o(25538);
    return null;
  }
  
  public final c aMd(String paramString)
  {
    AppMethodBeat.i(25539);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(25539);
      return null;
    }
    paramString = this.db.query("IPCallAddressItem", DSJ, "systemAddressBookUsername=?", new String[] { paramString }, null, null, null, 2);
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
        Log.d("MicroMsg.IPCallAddressStorage", "getByContactName error: %s", new Object[] { localException.getMessage() });
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
      AppMethodBeat.o(25539);
    }
    AppMethodBeat.o(25539);
    return null;
  }
  
  public final Cursor aMe(String paramString)
  {
    AppMethodBeat.i(25543);
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
    for (paramString = aMf(paramString);; paramString = this.db.query("IPCallAddressItem", DSJ, "contactId IN ".concat(String.valueOf(paramString)), null, null, null, "upper(sortKey) asc"))
    {
      System.currentTimeMillis();
      AppMethodBeat.o(25543);
      return paramString;
      i += 1;
      break;
      i = 1;
      break label33;
      label67:
      Object localObject1 = a.aMJ(paramString);
      paramString = aMf(paramString);
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
        Log.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", new Object[] { localException.getMessage() });
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
        AppMethodBeat.o(25543);
      }
      String str1;
      if (paramString.lastIndexOf(",") >= 0) {
        str1 = paramString.substring(0, paramString.lastIndexOf(","));
      }
      paramString = "(" + str1 + ")";
    }
  }
  
  public final long beginTransaction(long paramLong)
  {
    AppMethodBeat.i(25545);
    if ((this.db instanceof h))
    {
      paramLong = ((h)this.db).beginTransaction(paramLong);
      AppMethodBeat.o(25545);
      return paramLong;
    }
    AppMethodBeat.o(25545);
    return -1L;
  }
  
  public final ArrayList<c> eJW()
  {
    AppMethodBeat.i(25541);
    Cursor localCursor = this.db.query("IPCallAddressItem", DSJ, null, null, null, null, null, 2);
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
      Log.e("MicroMsg.IPCallAddressStorage", "getAllAddress, error: %s", new Object[] { localException.getMessage() });
      return null;
    }
    finally
    {
      if (localCursor != null) {
        localCursor.close();
      }
      AppMethodBeat.o(25541);
    }
  }
  
  public final Cursor eJX()
  {
    AppMethodBeat.i(25542);
    Cursor localCursor = this.db.query("IPCallAddressItem", DSJ, null, null, null, null, "upper(sortKey) asc");
    AppMethodBeat.o(25542);
    return localCursor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.model.h.d
 * JD-Core Version:    0.7.0.1
 */
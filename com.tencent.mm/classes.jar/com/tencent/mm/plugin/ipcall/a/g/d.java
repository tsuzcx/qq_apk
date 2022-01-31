package com.tencent.mm.plugin.ipcall.a.g;

import android.database.Cursor;
import com.tencent.mm.cf.h;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;

public final class d
  extends i<c>
{
  public static final String[] dXp = { i.a(c.buS, "IPCallAddressItem") };
  public static final String[] lsJ = { "*", "rowid" };
  public e dXw;
  
  public d(e parame)
  {
    super(parame, c.buS, "IPCallAddressItem", null);
    this.dXw = parame;
  }
  
  private Cursor FD(String paramString)
  {
    return this.dXw.query("IPCallAddressItem", lsJ, "systemAddressBookUsername LIKE ? or sortKey LIKE ?", new String[] { "%" + paramString + "%", "%" + paramString + "%" }, null, null, "upper(sortKey) asc");
  }
  
  public final c FA(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return null;
      paramString = this.dXw.a("IPCallAddressItem", lsJ, "contactId=?", new String[] { paramString }, null, null, null, 2);
      try
      {
        if (paramString.moveToFirst())
        {
          c localc = new c();
          localc.d(paramString);
          return localc;
        }
        return null;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IPCallAddressStorage", "getByContactId error: %s", new Object[] { localException.getMessage() });
        return null;
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
    }
  }
  
  public final c FB(String paramString)
  {
    if (bk.bl(paramString)) {}
    for (;;)
    {
      return null;
      paramString = this.dXw.a("IPCallAddressItem", lsJ, "systemAddressBookUsername=?", new String[] { paramString }, null, null, null, 2);
      try
      {
        if (paramString.moveToFirst())
        {
          c localc = new c();
          localc.d(paramString);
          return localc;
        }
        return null;
      }
      catch (Exception localException)
      {
        y.d("MicroMsg.IPCallAddressStorage", "getByContactName error: %s", new Object[] { localException.getMessage() });
        return null;
      }
      finally
      {
        if (paramString != null) {
          paramString.close();
        }
      }
    }
  }
  
  public final Cursor FC(String paramString)
  {
    System.currentTimeMillis();
    int i = 0;
    if (i < paramString.length()) {
      if (!Character.isDigit(paramString.charAt(i)))
      {
        i = 0;
        label27:
        if (i != 0) {
          break label55;
        }
      }
    }
    for (paramString = FD(paramString);; paramString = this.dXw.query("IPCallAddressItem", lsJ, "contactId IN " + paramString, null, null, null, "upper(sortKey) asc"))
    {
      System.currentTimeMillis();
      return paramString;
      i += 1;
      break;
      i = 1;
      break label27;
      label55:
      Object localObject1 = a.Gg(paramString);
      paramString = FD(paramString);
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
        y.e("MicroMsg.IPCallAddressStorage", "getContactIdList error: %s", new Object[] { localException.getMessage() });
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
      }
      String str1;
      if (paramString.lastIndexOf(",") >= 0) {
        str1 = paramString.substring(0, paramString.lastIndexOf(","));
      }
      paramString = "(" + str1 + ")";
    }
  }
  
  public final ArrayList<c> bcN()
  {
    Object localObject1 = null;
    localCursor = this.dXw.a("IPCallAddressItem", lsJ, null, null, null, null, null, 2);
    if (localCursor != null) {}
    while (localCursor == null)
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          continue;
        }
        ArrayList localArrayList = new ArrayList();
        boolean bool;
        do
        {
          c localc = new c();
          localc.d(localCursor);
          localArrayList.add(localc);
          bool = localCursor.moveToNext();
        } while (bool);
        if (localCursor != null) {
          localCursor.close();
        }
        localObject1 = localArrayList;
      }
      catch (Exception localException)
      {
        y.e("MicroMsg.IPCallAddressStorage", "getAllAddress, error: %s", new Object[] { localException.getMessage() });
        return null;
      }
      finally
      {
        if (localCursor == null) {
          break;
        }
        localCursor.close();
      }
      return localObject1;
    }
    localCursor.close();
    return null;
  }
  
  public final c eU(long paramLong)
  {
    Object localObject1 = null;
    localCursor = this.dXw.a("IPCallAddressItem", lsJ, "rowid=?", new String[] { String.valueOf(paramLong) }, null, null, null, 2);
    do
    {
      try
      {
        if (!localCursor.moveToFirst()) {
          continue;
        }
        c localc = new c();
        localc.d(localCursor);
        if (localCursor != null) {
          localCursor.close();
        }
        localObject1 = localc;
      }
      catch (Exception localException)
      {
        y.d("MicroMsg.IPCallAddressStorage", "getByLocalId error: %s", new Object[] { localException.getMessage() });
        return null;
      }
      finally
      {
        if (localCursor == null) {
          break;
        }
        localCursor.close();
      }
      return localObject1;
    } while (localCursor == null);
    localCursor.close();
    return null;
  }
  
  public final long eV(long paramLong)
  {
    if ((this.dXw instanceof h)) {
      return ((h)this.dXw).eV(paramLong);
    }
    return -1L;
  }
  
  public final void eW(long paramLong)
  {
    if (((this.dXw instanceof h)) && (paramLong != -1L)) {
      ((h)this.dXw).hI(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.a.g.d
 * JD-Core Version:    0.7.0.1
 */
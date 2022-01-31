package com.tencent.mm.cf;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g
  implements e
{
  public static String uEd = "";
  public int field_MARK_CURSOR_CHECK_IGNORE;
  public boolean rUU;
  public f uDC;
  public h uEc;
  public Map<String, i> uEe;
  public Queue<a> uEf;
  
  public final Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    return rawQuery(paramString, paramArrayOfString);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    return query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
  }
  
  public final int acO(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (!this.rUU) {
      return -4;
    }
    if ((this.uEc == null) || (this.uEc.inTransaction()))
    {
      y.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
      return -3;
    }
    try
    {
      if (f.a(this.uDC, paramString))
      {
        this.uDC.execSQL("drop table " + paramString);
        y.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", new Object[] { paramString });
      }
      Cursor localCursor = this.uEc.a(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null, 0);
      if (localCursor != null)
      {
        localObject1 = localObject2;
        if (localCursor.getCount() == 1)
        {
          localCursor.moveToFirst();
          localObject1 = localCursor.getString(0);
        }
        localCursor.close();
      }
      if (localObject1 == null)
      {
        y.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
        return -1;
      }
      this.uDC.execSQL((String)localObject1);
      this.uDC.execSQL("insert into " + paramString + " select * from old." + paramString);
      y.d("MicroMsg.MemoryStorage", "copy table %s success", new Object[] { paramString });
      return 0;
    }
    catch (Exception paramString)
    {
      y.printErrStackTrace("MicroMsg.MemoryStorage", paramString, "copy table failed with exception.\n", new Object[0]);
    }
    return -2;
  }
  
  public final boolean csp()
  {
    boolean bool = false;
    if ((this.uDC == null) || (!this.uDC.isOpen()))
    {
      y.e("MicroMsg.MemoryStorage", "memory db is close [%s]", new Object[] { uEd });
      bool = true;
    }
    return bool;
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uEe.containsKey(paramString1));
    if ((this.uDC != null) && (this.uDC.isOpen()))
    {
      i locali = (i)this.uEe.get(paramString1);
      i.a locala = new i.a();
      locala.uhL = 5;
      locala.uEy = paramString2;
      locala.K(paramArrayOfString);
      locali.a(locala);
      return this.uDC.delete(paramString1, paramString2, paramArrayOfString);
    }
    y.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", new Object[] { paramString1, uEd });
    if ((this.uEc != null) && (this.uEc.isOpen())) {
      return this.uEc.delete(paramString1, paramString2, paramArrayOfString);
    }
    return -1;
  }
  
  public final boolean gk(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uEe.containsKey(paramString1));
    boolean bool1;
    if ((this.uDC != null) && (this.uDC.isOpen()))
    {
      paramString1 = (i)this.uEe.get(paramString1);
      i.a locala = new i.a();
      locala.uhL = 1;
      locala.sql = paramString2;
      paramString1.a(locala);
      this.uDC.execSQL(paramString2);
      bool1 = true;
    }
    do
    {
      do
      {
        return bool1;
        y.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", new Object[] { paramString1, uEd });
        bool1 = bool2;
      } while (this.uEc == null);
      bool1 = bool2;
    } while (!this.uEc.isOpen());
    this.uEc.gk(paramString2, paramString1);
    return true;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uEe.containsKey(paramString1));
    if ((this.uDC != null) && (this.uDC.isOpen()))
    {
      i locali = (i)this.uEe.get(paramString1);
      i.a locala = new i.a();
      locala.uhL = 2;
      locala.ujM = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.a(locala);
      return this.uDC.insert(paramString1, paramString2, paramContentValues);
    }
    y.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", new Object[] { paramString1, uEd });
    if ((this.uEc != null) && (this.uEc.isOpen())) {
      return this.uEc.insert(paramString1, paramString2, paramContentValues);
    }
    return -1L;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    if ((this.uDC != null) && (this.uDC.isOpen())) {
      return this.uDC.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
    }
    y.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, uEd });
    return d.cwX();
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    if ((this.uDC != null) && (this.uDC.isOpen())) {
      return this.uDC.a(paramString, paramArrayOfString, 0);
    }
    y.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", new Object[] { paramString, uEd });
    return d.cwX();
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uEe.containsKey(paramString1));
    if ((this.uDC != null) && (this.uDC.isOpen()))
    {
      i locali = (i)this.uEe.get(paramString1);
      i.a locala = new i.a();
      locala.uhL = 4;
      locala.ujM = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.a(locala);
      return this.uDC.replace(paramString1, paramString2, paramContentValues);
    }
    y.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", new Object[] { paramString1, uEd });
    if ((this.uEc != null) && (this.uEc.isOpen())) {
      return this.uEc.replace(paramString1, paramString2, paramContentValues);
    }
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    Assert.assertTrue("Not Attach Mem Storage:" + paramString1, this.uEe.containsKey(paramString1));
    if ((this.uDC != null) && (this.uDC.isOpen()))
    {
      i locali = (i)this.uEe.get(paramString1);
      i.a locala = new i.a();
      locala.uhL = 3;
      locala.uEy = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locala.K(paramArrayOfString);
      locali.a(locala);
      return this.uDC.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
    }
    y.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", new Object[] { paramString1, uEd });
    if ((this.uEc != null) && (this.uEc.isOpen())) {
      return this.uEc.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
    }
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract int a(g paramg);
    
    public abstract String getTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cf.g
 * JD-Core Version:    0.7.0.1
 */
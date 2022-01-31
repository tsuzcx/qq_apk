package com.tencent.mm.cg;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.an;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Map;
import java.util.Queue;
import junit.framework.Assert;

public final class g
  implements e
{
  private static String yQM = "";
  public int field_MARK_CURSOR_CHECK_IGNORE;
  public boolean vLI;
  public h yQL;
  public Map<String, i> yQN;
  public Queue<a> yQO;
  public f yQj;
  
  public final Cursor a(String paramString, String[] paramArrayOfString, int paramInt)
  {
    AppMethodBeat.i(59099);
    paramString = rawQuery(paramString, paramArrayOfString);
    AppMethodBeat.o(59099);
    return paramString;
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    AppMethodBeat.i(59097);
    paramString1 = query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5);
    AppMethodBeat.o(59097);
    return paramString1;
  }
  
  public final int atc(String paramString)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(59090);
    if (!this.vLI)
    {
      AppMethodBeat.o(59090);
      return -4;
    }
    if ((this.yQL == null) || (this.yQL.inTransaction()))
    {
      ab.d("MicroMsg.MemoryStorage", "copy table but diskDB inTransaction");
      AppMethodBeat.o(59090);
      return -3;
    }
    try
    {
      if (f.a(this.yQj, paramString))
      {
        this.yQj.execSQL("drop table ".concat(String.valueOf(paramString)));
        ab.i("MicroMsg.MemoryStorage", "table %s is in Memory DB,drop! ", new Object[] { paramString });
      }
      Cursor localCursor = this.yQL.a(" select sql from sqlite_master where tbl_name=\"" + paramString + "\" and type = \"table\"", null, 0);
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
        ab.w("MicroMsg.MemoryStorage", "diskDB has not this table !");
        AppMethodBeat.o(59090);
        return -1;
      }
      this.yQj.execSQL((String)localObject1);
      this.yQj.execSQL("insert into " + paramString + " select * from old." + paramString);
      ab.d("MicroMsg.MemoryStorage", "copy table %s success", new Object[] { paramString });
      AppMethodBeat.o(59090);
      return 0;
    }
    catch (Exception paramString)
    {
      ab.printErrStackTrace("MicroMsg.MemoryStorage", paramString, "copy table failed with exception.\n", new Object[0]);
      AppMethodBeat.o(59090);
    }
    return -2;
  }
  
  public final void closeDB()
  {
    AppMethodBeat.i(59088);
    yQM = bo.dtY().toString();
    if (this.yQj != null)
    {
      this.yQj.close();
      this.yQj = null;
    }
    AppMethodBeat.o(59088);
  }
  
  public final int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59091);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.yQN.containsKey(paramString1));
    int i;
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      i locali = (i)this.yQN.get(paramString1);
      i.a locala = new i.a();
      locala.ypQ = 5;
      locala.yRg = paramString2;
      locala.T(paramArrayOfString);
      locali.b(locala);
      i = this.yQj.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(59091);
      return i;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close delete [%s] [%s]", new Object[] { paramString1, yQM });
    if ((this.yQL != null) && (this.yQL.isOpen()))
    {
      i = this.yQL.delete(paramString1, paramString2, paramArrayOfString);
      AppMethodBeat.o(59091);
      return i;
    }
    AppMethodBeat.o(59091);
    return -1;
  }
  
  public final boolean dun()
  {
    AppMethodBeat.i(59089);
    if ((this.yQj == null) || (!this.yQj.isOpen()))
    {
      ab.e("MicroMsg.MemoryStorage", "memory db is close [%s]", new Object[] { yQM });
      AppMethodBeat.o(59089);
      return true;
    }
    AppMethodBeat.o(59089);
    return false;
  }
  
  public final boolean execSQL(String paramString1, String paramString2)
  {
    AppMethodBeat.i(59092);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.yQN.containsKey(paramString1));
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      paramString1 = (i)this.yQN.get(paramString1);
      i.a locala = new i.a();
      locala.ypQ = 1;
      locala.sql = paramString2;
      paramString1.b(locala);
      this.yQj.execSQL(paramString2);
      AppMethodBeat.o(59092);
      return true;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close execSQL [%s] [%s]", new Object[] { paramString1, yQM });
    if ((this.yQL != null) && (this.yQL.isOpen()))
    {
      this.yQL.execSQL(paramString2, paramString1);
      AppMethodBeat.o(59092);
      return true;
    }
    AppMethodBeat.o(59092);
    return false;
  }
  
  public final long insert(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(59093);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.yQN.containsKey(paramString1));
    long l;
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      i locali = (i)this.yQN.get(paramString1);
      i.a locala = new i.a();
      locala.ypQ = 2;
      locala.yrL = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.yQj.insert(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(59093);
      return l;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close insert [%s] [%s]", new Object[] { paramString1, yQM });
    if ((this.yQL != null) && (this.yQL.isOpen()))
    {
      l = this.yQL.a(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(59093);
      return l;
    }
    AppMethodBeat.o(59093);
    return -1L;
  }
  
  public final Cursor query(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(59096);
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      paramString1 = this.yQj.a(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, 0);
      AppMethodBeat.o(59096);
      return paramString1;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close query [%s] [%s]", new Object[] { paramString1, yQM });
    paramString1 = d.dzJ();
    AppMethodBeat.o(59096);
    return paramString1;
  }
  
  public final Cursor rawQuery(String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59098);
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      paramString = this.yQj.a(paramString, paramArrayOfString, 0);
      AppMethodBeat.o(59098);
      return paramString;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close rawQuery [%s] [%s]", new Object[] { paramString, yQM });
    paramString = d.dzJ();
    AppMethodBeat.o(59098);
    return paramString;
  }
  
  public final long replace(String paramString1, String paramString2, ContentValues paramContentValues)
  {
    AppMethodBeat.i(59094);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.yQN.containsKey(paramString1));
    long l;
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      i locali = (i)this.yQN.get(paramString1);
      i.a locala = new i.a();
      locala.ypQ = 4;
      locala.yrL = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locali.b(locala);
      l = this.yQj.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(59094);
      return l;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close replace [%s] [%s]", new Object[] { paramString1, yQM });
    if ((this.yQL != null) && (this.yQL.isOpen()))
    {
      l = this.yQL.replace(paramString1, paramString2, paramContentValues);
      AppMethodBeat.o(59094);
      return l;
    }
    AppMethodBeat.o(59094);
    return -1L;
  }
  
  public final int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    AppMethodBeat.i(59095);
    Assert.assertTrue("Not Attach Mem Storage:".concat(String.valueOf(paramString1)), this.yQN.containsKey(paramString1));
    int i;
    if ((this.yQj != null) && (this.yQj.isOpen()))
    {
      i locali = (i)this.yQN.get(paramString1);
      i.a locala = new i.a();
      locala.ypQ = 3;
      locala.yRg = paramString2;
      locala.values = new ContentValues(paramContentValues);
      locala.T(paramArrayOfString);
      locali.b(locala);
      i = this.yQj.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(59095);
      return i;
    }
    ab.w("MicroMsg.MemoryStorage", "memoryDB already close update [%s] [%s]", new Object[] { paramString1, yQM });
    if ((this.yQL != null) && (this.yQL.isOpen()))
    {
      i = this.yQL.update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      AppMethodBeat.o(59095);
      return i;
    }
    AppMethodBeat.o(59095);
    return -1;
  }
  
  public static abstract interface a
  {
    public abstract int a(g paramg);
    
    public abstract String getTableName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.cg.g
 * JD-Core Version:    0.7.0.1
 */
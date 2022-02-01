package midas.x;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.SparseIntArray;
import com.tencent.midas.comm.APLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ao
{
  private am a = null;
  private SQLiteDatabase b = null;
  
  public ao(Context paramContext)
  {
    this.a = new am(paramContext.getApplicationContext());
    if (this.b == null)
    {
      this.b = this.a.getWritableDatabase();
      return;
    }
    if ((this.b != null) && (!this.b.isOpen())) {
      this.b = this.a.getWritableDatabase();
    }
  }
  
  public SparseIntArray a(String paramString)
  {
    try
    {
      SparseIntArray localSparseIntArray = new SparseIntArray();
      SQLiteDatabase localSQLiteDatabase = this.b;
      if (localSQLiteDatabase != null) {
        try
        {
          paramString = this.b.rawQuery("select threadid, downlength from filedowntable where downpath=?", new String[] { paramString });
          while (paramString.moveToNext()) {
            localSparseIntArray.put(paramString.getInt(0), paramString.getInt(1));
          }
          if (paramString != null) {
            paramString.close();
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return localSparseIntArray;
    }
    finally {}
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.close();
    }
    if ((this.b != null) && (this.b.isOpen())) {
      this.b.close();
    }
    this.a = null;
    APLog.i("APMidasDownFileManagerr", "resultData=close");
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.b;
      if (localSQLiteDatabase != null) {
        try
        {
          this.b.execSQL("insert into filesizetable(fileid, filesize) values(?,?)", new Object[] { paramString, Integer.valueOf(paramInt) });
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString, Map<Integer, Integer> paramMap)
  {
    try
    {
      Object localObject = this.b;
      if (localObject != null) {
        try
        {
          paramMap = paramMap.entrySet().iterator();
          while (paramMap.hasNext())
          {
            localObject = (Map.Entry)paramMap.next();
            this.b.execSQL("update filedowntable set downlength=? where downpath=? and threadid=?", new Object[] { ((Map.Entry)localObject).getValue(), paramString, ((Map.Entry)localObject).getKey() });
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
  
  public HashMap<String, Integer> b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    try
    {
      if (this.b != null)
      {
        paramString = this.b.rawQuery("select fileid, filesize from filesizetable where fileid=?", new String[] { paramString });
        while (paramString.moveToNext()) {
          localHashMap.put(paramString.getString(0), Integer.valueOf(paramString.getInt(1)));
        }
        if (paramString != null)
        {
          paramString.close();
          return localHashMap;
        }
      }
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return localHashMap;
  }
  
  public void b(String paramString, int paramInt)
  {
    if ((this.b == null) || (paramInt == 1)) {}
    try
    {
      this.b.execSQL("delete from filedowntable where downpath=?", new Object[] { paramString });
      return;
    }
    catch (Exception paramString)
    {
      label53:
      break label53;
    }
    if (paramInt == 2)
    {
      this.b.execSQL("delete from filesizetable where fileid=?", new Object[] { paramString });
      return;
      paramString.printStackTrace();
    }
  }
  
  public void b(String paramString, Map<Integer, Integer> paramMap)
  {
    try
    {
      Object localObject = this.b;
      if (localObject != null) {
        try
        {
          paramMap = paramMap.entrySet().iterator();
          while (paramMap.hasNext())
          {
            localObject = (Map.Entry)paramMap.next();
            this.b.execSQL("insert into filedowntable(downpath, threadid, downlength) values(?,?,?)", new Object[] { paramString, ((Map.Entry)localObject).getKey(), ((Map.Entry)localObject).getValue() });
          }
        }
        catch (Exception paramString)
        {
          paramString.printStackTrace();
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.1f_171060_ba4e988cc9e36ab96c2103acb9510bd4.jar\classes.jar
 * Qualified Name:     midas.x.ao
 * JD-Core Version:    0.7.0.1
 */
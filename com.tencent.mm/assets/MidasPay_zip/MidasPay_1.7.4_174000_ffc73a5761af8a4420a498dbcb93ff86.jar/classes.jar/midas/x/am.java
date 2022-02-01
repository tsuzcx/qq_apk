package midas.x;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.midas.comm.APLog;

public class am
  extends SQLiteOpenHelper
{
  am(Context paramContext)
  {
    super(paramContext, "TencentMidasUpdate.db", null, 1);
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filedowntable (id integer primary key autoincrement, downpath varchar(1024), threadid INTEGER, downlength INTEGER)");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS filesizetable (id integer primary key autoincrement, fileid varchar(100),filesize INTEGER)");
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    APLog.i("APMidasDownDBHelper", "resultData=onUpdate");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS filedowntable");
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS filesizetable");
    onCreate(paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\assets\MidasPay_zip\MidasPay_1.7.4_174000_ffc73a5761af8a4420a498dbcb93ff86.jar\classes.jar
 * Qualified Name:     midas.x.am
 * JD-Core Version:    0.7.0.1
 */
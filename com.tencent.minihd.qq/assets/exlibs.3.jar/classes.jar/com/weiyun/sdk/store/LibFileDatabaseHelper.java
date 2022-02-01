package com.weiyun.sdk.store;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import com.weiyun.sdk.log.Log;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LibFileDatabaseHelper
  extends SQLiteOpenHelper
{
  public static final String COLUMNS_CACHE_FILE_ID = "cache_file_id";
  public static final String COLUMNS_CACHE_FILE_MTIME = "cache_file_mtime";
  public static final String COLUMNS_CACHE_FILE_SIZE = "cache_file_size";
  public static final String COLUMNS_CACHE_THUMBNAIL_TYPE = "cache_thumbnail_type";
  public static final String COLUMNS_CATEGORY_ID = "category_id";
  public static final String COLUMNS_CATEGORY_NAME = "category_name";
  public static final String COLUMNS_CATEGORY_THUMBNAIL_URL = "category_thumbnail_url";
  public static final String COLUMNS_CATEGORY_TIMESTAMP = "category_timestamp";
  public static final String COLUMNS_CATEGORY_TOTAL_NUM = "category_total_num";
  public static final String COLUMNS_CATEGORY_UIN = "category_uin";
  public static final String COLUMNS_FILE_CATEGORY_ID = "category_id";
  public static final String COLUMNS_FILE_COOKIENAME = "cookieName";
  public static final String COLUMNS_FILE_COOKIEVALUE = "cookieValue";
  public static final String COLUMNS_FILE_ENCODEURL = "encodeUrl";
  public static final String COLUMNS_FILE_HOSTNAME = "hostName";
  public static final String COLUMNS_FILE_ID = "file_id";
  public static final String COLUMNS_FILE_MTIME = "file_mtime";
  public static final String COLUMNS_FILE_NAME = "file_name";
  public static final String COLUMNS_FILE_SERVERPORT = "serverPort";
  public static final String COLUMNS_FILE_SIZE = "file_size";
  public static final String COLUMNS_FILE_SOURCE = "file_source";
  public static final String COLUMNS_FILE_UIN = "file_uin";
  public static final String COLUMNS_ID = "_id";
  public static final String COLUMNS_TASK_CUR_SIZE = "task_cur_size";
  public static final String COLUMNS_TASK_FILE_ID = "task_file_id";
  public static final String COLUMNS_TASK_FILE_MD5 = "task_file_md5";
  public static final String COLUMNS_TASK_FILE_MODIFY_TIME = "task_file_modify_time";
  public static final String COLUMNS_TASK_FILE_NAME = "task_file_name";
  public static final String COLUMNS_TASK_FILE_PATH = "task_file_path";
  public static final String COLUMNS_TASK_FILE_SHA = "task_file_sha";
  public static final String COLUMNS_TASK_LOCAL_NAME = "task_local_name";
  public static final String COLUMNS_TASK_TOTAL_SIZE = "task_total_size";
  public static final String COLUMNS_TASK_TYPE = "task_type";
  public static final String COLUMNS_TASK_UIN = "task_uin";
  private static final String CREATE_LIB_CACHE_FILE_INDEX = "CREATE INDEX IF NOT EXISTS cache_file_index ON lib_cache(cache_file_id)";
  private static final String CREATE_LIB_CACHE_SQL = "CREATE TABLE IF NOT EXISTS lib_cache (_id INTEGER PRIMARY KEY AUTOINCREMENT,cache_file_id TEXT, cache_thumbnail_type INTEGER,cache_file_mtime INTERGER,cache_file_size INTERGER,);";
  private static final String CREATE_LIB_CATEGORY_SQL = "CREATE TABLE IF NOT EXISTS lib_category (_id INTEGER PRIMARY KEY AUTOINCREMENT,category_uin TEXT, category_name TEXT,category_total_num INTERGER,category_timestamp TEXT,category_thumbnail_url TEXT);";
  private static final String CREATE_LIB_FILE_INDEX = "CREATE INDEX IF NOT EXISTS file_key_index ON lib_file(category_id,file_mtime)";
  private static final String CREATE_LIB_FILE_SQL = "CREATE TABLE IF NOT EXISTS lib_file (_id INTEGER PRIMARY KEY AUTOINCREMENT,category_id TEXT,file_id TEXT,file_uin TEXT, file_name TEXT,file_mtime INTERGER,file_size INTERGER,file_source INTERGER,encodeUrl TEXT,cookieName TEXT,cookieValue TEXT,hostName TEXT,serverPort INTERGER);";
  private static final String CREATE_LIB_FILE_UIN_INDEX = "CREATE INDEX IF NOT EXISTS file_uin_index ON lib_file(file_uin)";
  private static final String CREATE_LIB_TASK_FILE_ID_INDEX = "CREATE INDEX IF NOT EXISTS task_file_id_index ON lib_task(task_file_id)";
  private static final String CREATE_LIB_TASK_PATH_INDEX = "CREATE INDEX IF NOT EXISTS task_path_index ON lib_task(task_file_path)";
  private static final String CREATE_LIB_TASK_SQL = "CREATE TABLE IF NOT EXISTS lib_task (_id INTEGER PRIMARY KEY AUTOINCREMENT,task_type INTEGER, task_uin TEXT,task_cur_size INTERGER,task_total_size INTERGER,task_file_modify_time INTERGER,task_file_path TEXT,task_file_md5 TEXT,task_file_sha TEXT,task_file_id TEXT,task_file_name TEXT,task_local_name TEXT);";
  public static final String DB_CACHE_TABLE_NAME = "lib_cache";
  public static final String DB_FILE_TABLE_NAME = "lib_file";
  private static final String DB_NAME = "lib_db";
  public static final String DB_TASK_TABLE_NAME = "lib_task";
  public static final String DB_TYPE_TABLE_NAME = "lib_category";
  private static final int DB_VERSION = 1;
  private static LibFileDatabaseHelper gInstance = null;
  
  public LibFileDatabaseHelper(Context paramContext)
  {
    super(paramContext, "lib_db", null, 1);
  }
  
  public static LibFileDatabaseHelper getInstance(Context paramContext)
  {
    try
    {
      if (gInstance == null) {
        gInstance = new LibFileDatabaseHelper(paramContext);
      }
      paramContext = gInstance;
      return paramContext;
    }
    finally {}
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS lib_task (_id INTEGER PRIMARY KEY AUTOINCREMENT,task_type INTEGER, task_uin TEXT,task_cur_size INTERGER,task_total_size INTERGER,task_file_modify_time INTERGER,task_file_path TEXT,task_file_md5 TEXT,task_file_sha TEXT,task_file_id TEXT,task_file_name TEXT,task_local_name TEXT);");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS task_path_index ON lib_task(task_file_path)");
      paramSQLiteDatabase.execSQL("CREATE INDEX IF NOT EXISTS task_file_id_index ON lib_task(task_file_id)");
      return;
    }
    catch (SQLException paramSQLiteDatabase) {}
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
  public static abstract class DBObserver
  {
    public static final int OPT_DELETE = 3;
    public static final int OPT_INSERT = 1;
    public static final int OPT_UPDATE = 2;
    private Handler mHandler;
    
    public DBObserver(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    public void dispatchChange(int paramInt)
    {
      if (this.mHandler == null)
      {
        onChange(paramInt);
        return;
      }
      this.mHandler.post(new NotificationRunnable(paramInt));
    }
    
    public void dispatchChange(int paramInt, long paramLong)
    {
      if (this.mHandler == null)
      {
        onChange(paramInt, paramLong);
        return;
      }
      this.mHandler.post(new NotificationRunnable(paramInt, paramLong));
    }
    
    public abstract void onChange(int paramInt);
    
    public abstract void onChange(int paramInt, long paramLong);
    
    public void setHandler(Handler paramHandler)
    {
      this.mHandler = paramHandler;
    }
    
    private final class NotificationRunnable
      implements Runnable
    {
      private static final int INVALIDE_ID = -1;
      private final long mId;
      private final int mOperation;
      
      public NotificationRunnable(int paramInt)
      {
        this.mOperation = paramInt;
        this.mId = -1L;
      }
      
      public NotificationRunnable(int paramInt, long paramLong)
      {
        this.mOperation = paramInt;
        this.mId = paramLong;
      }
      
      public void run()
      {
        if (this.mId == -1L)
        {
          LibFileDatabaseHelper.DBObserver.this.onChange(this.mOperation);
          return;
        }
        LibFileDatabaseHelper.DBObserver.this.onChange(this.mOperation, this.mId);
      }
    }
  }
  
  public static class NativeDBHelper
  {
    protected static final String ITEM_SELECTION = "_id=?";
    protected static final String TAG = "NativeDBHelper";
    protected final SQLiteOpenHelper mDBHelper;
    protected final ConcurrentLinkedQueue<LibFileDatabaseHelper.DBObserver> mObservers;
    protected final String mTableName;
    
    public NativeDBHelper(String paramString, SQLiteOpenHelper paramSQLiteOpenHelper)
    {
      this.mTableName = paramString;
      this.mDBHelper = paramSQLiteOpenHelper;
      this.mObservers = null;
    }
    
    public NativeDBHelper(String paramString, SQLiteOpenHelper paramSQLiteOpenHelper, boolean paramBoolean)
    {
      this.mTableName = paramString;
      this.mDBHelper = paramSQLiteOpenHelper;
      if (paramBoolean)
      {
        this.mObservers = new ConcurrentLinkedQueue();
        return;
      }
      this.mObservers = null;
    }
    
    private int deleteInternal(String paramString, String[] paramArrayOfString)
    {
      try
      {
        int i = this.mDBHelper.getWritableDatabase().delete(this.mTableName, paramString, paramArrayOfString);
        return i;
      }
      catch (SQLException paramString)
      {
        Log.w("NativeDBHelper", paramString);
      }
      return 0;
    }
    
    private long insertInternal(ContentValues paramContentValues)
    {
      try
      {
        long l = this.mDBHelper.getWritableDatabase().insert(this.mTableName, null, paramContentValues);
        return l;
      }
      catch (SQLException paramContentValues)
      {
        Log.w("NativeDBHelper", paramContentValues);
      }
      return -1L;
    }
    
    private void notifyChange(int paramInt)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext()) {
        ((LibFileDatabaseHelper.DBObserver)localIterator.next()).dispatchChange(paramInt);
      }
    }
    
    private void notifyChange(int paramInt, long paramLong)
    {
      Iterator localIterator = this.mObservers.iterator();
      while (localIterator.hasNext()) {
        ((LibFileDatabaseHelper.DBObserver)localIterator.next()).dispatchChange(paramInt, paramLong);
      }
    }
    
    private int updateInternal(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      try
      {
        int i = this.mDBHelper.getWritableDatabase().update(this.mTableName, paramContentValues, paramString, paramArrayOfString);
        return i;
      }
      catch (SQLException paramContentValues)
      {
        Log.w("NativeDBHelper", paramContentValues);
      }
      return 0;
    }
    
    /* Error */
    public boolean checkItem(long paramLong)
    {
      // Byte code:
      //   0: iconst_1
      //   1: istore 4
      //   3: aload_0
      //   4: iconst_1
      //   5: anewarray 99	java/lang/String
      //   8: dup
      //   9: iconst_0
      //   10: ldc 101
      //   12: aastore
      //   13: lload_1
      //   14: invokevirtual 105	com/weiyun/sdk/store/LibFileDatabaseHelper$NativeDBHelper:queryItem	([Ljava/lang/String;J)Landroid/database/Cursor;
      //   17: astore 5
      //   19: aload 5
      //   21: ifnonnull +5 -> 26
      //   24: iconst_0
      //   25: ireturn
      //   26: aload 5
      //   28: invokeinterface 111 1 0
      //   33: istore_3
      //   34: iload_3
      //   35: ifle +13 -> 48
      //   38: aload 5
      //   40: invokeinterface 114 1 0
      //   45: iload 4
      //   47: ireturn
      //   48: iconst_0
      //   49: istore 4
      //   51: goto -13 -> 38
      //   54: astore 6
      //   56: aload 5
      //   58: invokeinterface 114 1 0
      //   63: aload 6
      //   65: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	66	0	this	NativeDBHelper
      //   0	66	1	paramLong	long
      //   33	2	3	i	int
      //   1	49	4	bool	boolean
      //   17	40	5	localCursor	Cursor
      //   54	10	6	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   26	34	54	finally
    }
    
    public int delete(String paramString, String[] paramArrayOfString)
    {
      return delete(paramString, paramArrayOfString, false);
    }
    
    public int delete(String paramString, String[] paramArrayOfString, boolean paramBoolean)
    {
      int i = deleteInternal(paramString, paramArrayOfString);
      if ((i > 0) && (paramBoolean)) {
        notifyChange(3);
      }
      return i;
    }
    
    public boolean deleteItem(long paramLong)
    {
      return deleteItem(paramLong, false);
    }
    
    public boolean deleteItem(long paramLong, boolean paramBoolean)
    {
      if ((deleteInternal("_id=?", new String[] { Long.toString(paramLong) }) > 0) && (paramBoolean))
      {
        notifyChange(3, paramLong);
        return true;
      }
      return false;
    }
    
    public int getCount(String paramString, String[] paramArrayOfString)
    {
      paramString = query(new String[] { "COUNT(_id)" }, paramString, paramArrayOfString, null, null, null, null);
      if (paramString == null) {
        return -1;
      }
      try
      {
        paramString.moveToFirst();
        int i = paramString.getInt(0);
        return i;
      }
      finally
      {
        paramString.close();
      }
    }
    
    public int insert(ContentValues[] paramArrayOfContentValues)
    {
      return insert(paramArrayOfContentValues, false);
    }
    
    public int insert(ContentValues[] paramArrayOfContentValues, boolean paramBoolean)
    {
      int j = 0;
      int m = paramArrayOfContentValues.length;
      int i = 0;
      while (i < m)
      {
        int k = j;
        if (insertInternal(paramArrayOfContentValues[i]) > 0L) {
          k = j + 1;
        }
        i += 1;
        j = k;
      }
      if ((j > 0) && (paramBoolean)) {
        notifyChange(1);
      }
      return j;
    }
    
    public long insertItem(ContentValues paramContentValues)
    {
      return insertItem(paramContentValues, false);
    }
    
    public long insertItem(ContentValues paramContentValues, boolean paramBoolean)
    {
      long l = insertInternal(paramContentValues);
      if ((l > 0L) && (paramBoolean)) {
        notifyChange(1, l);
      }
      return l;
    }
    
    public Cursor query(String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
    {
      return query(paramArrayOfString1, paramString, paramArrayOfString2, null, null, null, null);
    }
    
    public Cursor query(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3)
    {
      return query(paramArrayOfString1, paramString1, paramArrayOfString2, null, null, paramString2, paramString3);
    }
    
    public Cursor query(String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2, String paramString3, String paramString4, String paramString5)
    {
      try
      {
        paramArrayOfString1 = this.mDBHelper.getReadableDatabase().query(this.mTableName, paramArrayOfString1, paramString1, paramArrayOfString2, paramString2, paramString3, paramString4, paramString5);
        return paramArrayOfString1;
      }
      catch (SQLException paramArrayOfString1)
      {
        Log.w("NativeDBHelper", paramArrayOfString1);
      }
      return null;
    }
    
    public Cursor queryItem(String[] paramArrayOfString, long paramLong)
    {
      return query(paramArrayOfString, "_id=?", new String[] { Long.toString(paramLong) });
    }
    
    public void registerObserver(LibFileDatabaseHelper.DBObserver paramDBObserver)
    {
      if (!this.mObservers.contains(paramDBObserver)) {
        this.mObservers.add(paramDBObserver);
      }
    }
    
    public void unregisterObserver(LibFileDatabaseHelper.DBObserver paramDBObserver)
    {
      this.mObservers.remove(paramDBObserver);
    }
    
    public int update(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
    {
      return update(paramContentValues, paramString, paramArrayOfString, false);
    }
    
    public int update(ContentValues paramContentValues, String paramString, String[] paramArrayOfString, boolean paramBoolean)
    {
      int i = updateInternal(paramContentValues, paramString, paramArrayOfString);
      if ((i > 0) && (paramBoolean)) {
        notifyChange(2);
      }
      return i;
    }
    
    public boolean updateItem(ContentValues paramContentValues, long paramLong)
    {
      return updateItem(paramContentValues, paramLong, false);
    }
    
    public boolean updateItem(ContentValues paramContentValues, long paramLong, boolean paramBoolean)
    {
      if ((updateInternal(paramContentValues, "_id=?", new String[] { Long.toString(paramLong) }) > 0) && (paramBoolean))
      {
        notifyChange(2, paramLong);
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.store.LibFileDatabaseHelper
 * JD-Core Version:    0.7.0.1
 */
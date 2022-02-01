package com.weiyun.sdk.store;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.DownloadJobContext;
import com.weiyun.sdk.job.UploadJobContext;
import com.weiyun.sdk.util.Utils;

public class TaskDBHelper
  extends LibFileDatabaseHelper.NativeDBHelper
{
  protected static final String FILE_ID_SELECTION = "task_file_id=? AND task_uin=? AND task_type=?";
  protected static final String[] ID_PROJECTION = { "_id" };
  protected static final String PATH_SELECTION = "task_file_path=? AND task_uin=? AND task_type=?";
  public static final int TASK_TYPE_DOWNLOAD = 2;
  public static final int TASK_TYPE_UPLOAD = 1;
  
  public TaskDBHelper(SQLiteOpenHelper paramSQLiteOpenHelper)
  {
    super("lib_task", paramSQLiteOpenHelper);
  }
  
  public static TaskDBHelper newDBHelper()
  {
    return new TaskDBHelper(LibFileDatabaseHelper.getInstance(SdkContext.getInstance().getContext()));
  }
  
  public DownloadJobContext getDownloadJobContext(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    String str = Integer.toString(2);
    paramString1 = query(new String[] { "_id", "task_cur_size", "task_total_size", "task_file_modify_time", "task_file_id", "task_file_name", "task_local_name", "task_file_md5" }, "task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, str });
    if (paramString1 == null) {
      return null;
    }
    try
    {
      if (paramString1.moveToNext())
      {
        long l = paramString1.getLong(0);
        paramString2 = new DownloadJobContext(Long.parseLong(paramString2), l, paramString3, paramString4);
        paramString2.setCurSize(paramString1.getLong(1));
        paramString2.setTotalSize(paramString1.getLong(2));
        paramString2.setModifyTime(paramString1.getLong(3));
        paramString2.setFileId(paramString1.getString(4));
        paramString2.setFileName(paramString1.getString(5));
        paramString2.setDestFileName(paramString1.getString(6));
        paramString2.setMd5(paramString1.getString(7));
        return paramString2;
      }
      return null;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  /* Error */
  public String getDownloadNewFileName(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: bipush 47
    //   3: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   6: istore_2
    //   7: aload_1
    //   8: astore 5
    //   10: iload_2
    //   11: iflt +12 -> 23
    //   14: aload_1
    //   15: iload_2
    //   16: iconst_1
    //   17: iadd
    //   18: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   21: astore 5
    //   23: aload 5
    //   25: astore 6
    //   27: ldc 144
    //   29: astore_1
    //   30: aload 5
    //   32: bipush 46
    //   34: invokevirtual 139	java/lang/String:lastIndexOf	(I)I
    //   37: istore_2
    //   38: iload_2
    //   39: iflt +20 -> 59
    //   42: aload 5
    //   44: iload_2
    //   45: iconst_1
    //   46: iadd
    //   47: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   50: astore 6
    //   52: aload 5
    //   54: iload_2
    //   55: invokevirtual 142	java/lang/String:substring	(I)Ljava/lang/String;
    //   58: astore_1
    //   59: new 146	java/lang/StringBuilder
    //   62: dup
    //   63: invokespecial 148	java/lang/StringBuilder:<init>	()V
    //   66: astore 7
    //   68: aload 7
    //   70: ldc 73
    //   72: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: ldc 154
    //   77: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload 7
    //   83: aload 6
    //   85: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 156
    //   90: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: aload_1
    //   94: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: ldc 158
    //   99: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: aload 7
    //   105: ldc 160
    //   107: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: ldc 73
    //   112: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: ldc 162
    //   117: invokevirtual 152	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: pop
    //   121: aload 7
    //   123: invokevirtual 165	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: astore_1
    //   127: aload_0
    //   128: iconst_1
    //   129: anewarray 22	java/lang/String
    //   132: dup
    //   133: iconst_0
    //   134: ldc 73
    //   136: aastore
    //   137: aload_1
    //   138: iconst_1
    //   139: anewarray 22	java/lang/String
    //   142: dup
    //   143: iconst_0
    //   144: aload 5
    //   146: aastore
    //   147: ldc 167
    //   149: aconst_null
    //   150: invokevirtual 170	com/weiyun/sdk/store/TaskDBHelper:query	([Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   153: astore_1
    //   154: aload_1
    //   155: ifnonnull +6 -> 161
    //   158: aload 5
    //   160: areturn
    //   161: iconst_m1
    //   162: istore_2
    //   163: aload_1
    //   164: invokeinterface 85 1 0
    //   169: ifeq +116 -> 285
    //   172: aload_1
    //   173: iconst_0
    //   174: invokeinterface 113 2 0
    //   179: astore 6
    //   181: aload 6
    //   183: aload 5
    //   185: invokevirtual 174	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   188: istore 4
    //   190: iload 4
    //   192: ifeq +15 -> 207
    //   195: iload_2
    //   196: ifle +6 -> 202
    //   199: goto -36 -> 163
    //   202: iconst_0
    //   203: istore_2
    //   204: goto -5 -> 199
    //   207: aload 6
    //   209: aload 6
    //   211: ldc 176
    //   213: invokevirtual 179	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   216: iconst_1
    //   217: iadd
    //   218: aload 6
    //   220: ldc 181
    //   222: invokevirtual 179	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   225: invokevirtual 184	java/lang/String:substring	(II)Ljava/lang/String;
    //   228: invokestatic 188	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   231: invokevirtual 192	java/lang/Integer:intValue	()I
    //   234: istore_3
    //   235: iload_2
    //   236: iload_3
    //   237: if_icmple +6 -> 243
    //   240: goto -77 -> 163
    //   243: iload_3
    //   244: istore_2
    //   245: goto -5 -> 240
    //   248: astore 6
    //   250: ldc 194
    //   252: aload 6
    //   254: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   257: pop
    //   258: goto -95 -> 163
    //   261: astore 5
    //   263: aload_1
    //   264: invokeinterface 129 1 0
    //   269: aload 5
    //   271: athrow
    //   272: astore 6
    //   274: ldc 194
    //   276: aload 6
    //   278: invokestatic 200	android/util/Log:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   281: pop
    //   282: goto -119 -> 163
    //   285: iload_2
    //   286: iflt +22 -> 308
    //   289: aload 5
    //   291: iload_2
    //   292: iconst_1
    //   293: iadd
    //   294: invokestatic 206	com/weiyun/sdk/util/Utils:fileRename	(Ljava/lang/String;I)Ljava/lang/String;
    //   297: astore 5
    //   299: aload_1
    //   300: invokeinterface 129 1 0
    //   305: aload 5
    //   307: areturn
    //   308: aload_1
    //   309: invokeinterface 129 1 0
    //   314: aload 5
    //   316: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	TaskDBHelper
    //   0	317	1	paramString	String
    //   6	288	2	i	int
    //   234	10	3	j	int
    //   188	3	4	bool	boolean
    //   8	176	5	str1	String
    //   261	29	5	str2	String
    //   297	18	5	str3	String
    //   25	194	6	str4	String
    //   248	5	6	localNumberFormatException	java.lang.NumberFormatException
    //   272	5	6	localIndexOutOfBoundsException	java.lang.IndexOutOfBoundsException
    //   66	56	7	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   207	235	248	java/lang/NumberFormatException
    //   163	190	261	finally
    //   207	235	261	finally
    //   250	258	261	finally
    //   274	282	261	finally
    //   289	299	261	finally
    //   207	235	272	java/lang/IndexOutOfBoundsException
  }
  
  public long getDownloadTaskId(String paramString1, String paramString2)
  {
    return getId(query(ID_PROJECTION, "task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(2) }));
  }
  
  protected long getId(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return 0L;
    }
    int i = paramCursor.getColumnIndex("_id");
    try
    {
      if (paramCursor.moveToNext())
      {
        long l = paramCursor.getLong(i);
        return l;
      }
      return 0L;
    }
    finally
    {
      paramCursor.close();
    }
  }
  
  public UploadJobContext getUploadJobContext(String paramString1, String paramString2)
  {
    Object localObject = Integer.toString(1);
    localObject = query(new String[] { "_id", "task_cur_size", "task_total_size", "task_file_modify_time", "task_file_md5", "task_file_sha", "task_file_id" }, "task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, localObject });
    if (localObject == null) {
      return null;
    }
    try
    {
      if (((Cursor)localObject).moveToNext())
      {
        long l = ((Cursor)localObject).getLong(0);
        paramString2 = new UploadJobContext(Long.parseLong(paramString2), l, paramString1);
        paramString2.setCurSize(((Cursor)localObject).getLong(1));
        paramString2.setTotalSize(((Cursor)localObject).getLong(2));
        paramString2.setModifyTime(((Cursor)localObject).getLong(3));
        paramString2.setMd5(((Cursor)localObject).getString(4));
        paramString2.setSha(((Cursor)localObject).getString(5));
        paramString2.setFileId(((Cursor)localObject).getString(6));
        paramString2.setFileName(Utils.getFileNameFromPath(paramString1));
        return paramString2;
      }
      return null;
    }
    finally
    {
      ((Cursor)localObject).close();
    }
  }
  
  public long getUploadTaskId(String paramString1, String paramString2)
  {
    return getId(query(ID_PROJECTION, "task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(1) }));
  }
  
  public long initDownloadTask(String paramString1, String paramString2, String paramString3, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_type", Integer.valueOf(2));
    localContentValues.put("task_uin", paramString2);
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong1));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong2));
    localContentValues.put("task_file_id", paramString1);
    localContentValues.put("task_file_name", paramString3);
    localContentValues.put("task_local_name", paramString3);
    return insertItem(localContentValues);
  }
  
  public long initUploadTask(String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_type", Integer.valueOf(1));
    localContentValues.put("task_uin", paramString2);
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong1));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong2));
    localContentValues.put("task_file_path", paramString1);
    return insertItem(localContentValues);
  }
  
  public boolean isFileDownloading(String paramString1, String paramString2)
  {
    return getCount("task_file_id=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(2) }) == 1;
  }
  
  public boolean isFileUplading(String paramString1, String paramString2)
  {
    return getCount("task_file_path=? AND task_uin=? AND task_type=?", new String[] { paramString1, paramString2, Integer.toString(1) }) == 1;
  }
  
  public boolean updateDownloadContext(long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Long.valueOf(paramLong2));
    localContentValues.put("task_total_size", Long.valueOf(paramLong3));
    localContentValues.put("task_local_name", paramString1);
    localContentValues.put("task_file_md5", paramString2);
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateDownloadFileSizeAndModifyTime(long paramLong1, long paramLong2, long paramLong3)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Integer.valueOf(0));
    localContentValues.put("task_total_size", Long.valueOf(paramLong2));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong3));
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateUploadContext(long paramLong1, long paramLong2, long paramLong3, long paramLong4, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_cur_size", Long.valueOf(paramLong2));
    localContentValues.put("task_total_size", Long.valueOf(paramLong3));
    localContentValues.put("task_file_modify_time", Long.valueOf(paramLong4));
    localContentValues.put("task_file_id", paramString);
    return updateItem(localContentValues, paramLong1);
  }
  
  public boolean updateUploadFileMd5(long paramLong, String paramString1, String paramString2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("task_file_md5", paramString1);
    localContentValues.put("task_file_sha", paramString2);
    return updateItem(localContentValues, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.store.TaskDBHelper
 * JD-Core Version:    0.7.0.1
 */
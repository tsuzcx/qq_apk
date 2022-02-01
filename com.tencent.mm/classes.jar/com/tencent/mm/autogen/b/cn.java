package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.lifecycle.q;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.awf;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.dje;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.djq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.executor.DeleteExecutor;
import com.tencent.mm.sdk.storage.executor.InsertExecutor;
import com.tencent.mm.sdk.storage.executor.ReplaceExecutor;
import com.tencent.mm.sdk.storage.executor.UpdateExecutor;
import com.tencent.mm.sdk.storage.observer.IStorageObserver;
import com.tencent.mm.sdk.storage.observer.StorageEventId;
import com.tencent.mm.sdk.storage.observer.StorageObserverEvent;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SelectSql;
import com.tencent.mm.sdk.storage.sql.SelectSql.Builder;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class cn
  extends IAutoDBItem
{
  public static final Column CLIPLIST;
  public static final String COL_CLIPLIST = "clipList";
  public static final String COL_CREATETIME = "createTime";
  public static final String COL_CUSTOMDATA = "customData";
  public static final String COL_FINDEROBJECT = "finderObject";
  public static final String COL_HALFMEDIAEXTLIST = "halfMediaExtList";
  public static final String COL_ID = "id";
  public static final String COL_LOCALFLAG = "localFlag";
  public static final String COL_LOCALID = "localId";
  public static final String COL_LONGVIDEOMEDIAEXTLIST = "longVideoMediaExtList";
  public static final String COL_MEDIAEXTLIST = "mediaExtList";
  public static final String COL_POSTEXTRADATA = "postExtraData";
  public static final String COL_POSTINFO = "postinfo";
  public static final String COL_REPORTOBJECT = "reportObject";
  public static final String COL_SOURCEFLAG = "sourceFlag";
  public static final String COL_UPDATETIME = "updateTime";
  public static final String COL_USERNAME = "username";
  public static final Column CREATETIME;
  public static final Column CUSTOMDATA;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = initAutoDBInfo(cn.class);
  public static final Column FINDEROBJECT;
  public static final Column HALFMEDIAEXTLIST;
  public static final Column ID;
  public static final String[] INDEX_CREATE;
  public static final Column LOCALFLAG;
  public static final Column LOCALID;
  public static final Column LONGVIDEOMEDIAEXTLIST;
  public static final Column MEDIAEXTLIST;
  public static final Column POSTEXTRADATA;
  public static final Column POSTINFO;
  public static final Column REPORTOBJECT;
  public static final Column ROWID;
  public static final Column SOURCEFLAG;
  public static final SingleTable TABLE = new SingleTable("FinderFeedItem");
  public static final String TABLE_NAME = "FinderFeedItem";
  private static final String TAG_ = "MicroMsg.SDK.BaseFinderFeedItem";
  public static final Column UPDATETIME;
  public static final Column USERNAME;
  private static final int clipList_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int customData_HASHCODE;
  private static final int finderObject_HASHCODE;
  private static final int halfMediaExtList_HASHCODE;
  private static final int id_HASHCODE;
  private static final int localFlag_HASHCODE;
  private static final int localId_HASHCODE;
  private static final int longVideoMediaExtList_HASHCODE;
  private static final int mediaExtList_HASHCODE;
  private static final StorageObserverOwner<cn> observerOwner = new StorageObserverOwner();
  private static final int postExtraData_HASHCODE;
  private static final int postinfo_HASHCODE;
  private static final int reportObject_HASHCODE;
  private static final int rowid_HASHCODE;
  private static final int sourceFlag_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetclipList = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetcustomData = true;
  private boolean __hadSetfinderObject = true;
  private boolean __hadSethalfMediaExtList = true;
  private boolean __hadSetid = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalId = true;
  private boolean __hadSetlongVideoMediaExtList = true;
  private boolean __hadSetmediaExtList = true;
  private boolean __hadSetpostExtraData = true;
  private boolean __hadSetpostinfo = true;
  private boolean __hadSetreportObject = true;
  private boolean __hadSetsourceFlag = true;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public dje field_clipList;
  public long field_createTime;
  public awf field_customData;
  public FinderObject field_finderObject;
  public djq field_halfMediaExtList;
  public long field_id;
  public int field_localFlag;
  public long field_localId;
  public djq field_longVideoMediaExtList;
  public djq field_mediaExtList;
  public bso field_postExtraData;
  public djj field_postinfo;
  public FinderFeedReportObject field_reportObject;
  public int field_sourceFlag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "long", TABLE.getName(), "");
    ID = new Column("id", "long", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    SOURCEFLAG = new Column("sourceFlag", "int", TABLE.getName(), "");
    UPDATETIME = new Column("updateTime", "long", TABLE.getName(), "");
    FINDEROBJECT = new Column("finderObject", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderObject");
    LOCALFLAG = new Column("localFlag", "int", TABLE.getName(), "");
    POSTINFO = new Column("postinfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalFinderPostInfo");
    MEDIAEXTLIST = new Column("mediaExtList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalMediaListExt");
    REPORTOBJECT = new Column("reportObject", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderFeedReportObject");
    POSTEXTRADATA = new Column("postExtraData", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderPostExtra");
    CUSTOMDATA = new Column("customData", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderCustomFeedData");
    LONGVIDEOMEDIAEXTLIST = new Column("longVideoMediaExtList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalMediaListExt");
    HALFMEDIAEXTLIST = new Column("halfMediaExtList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalMediaListExt");
    CLIPLIST = new Column("clipList", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LocalClipListExt");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS FinderFeedItem_local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderFeedItem__Local_Flag ON FinderFeedItem(localFlag)" };
    localId_HASHCODE = "localId".hashCode();
    id_HASHCODE = "id".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    username_HASHCODE = "username".hashCode();
    sourceFlag_HASHCODE = "sourceFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    finderObject_HASHCODE = "finderObject".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
    postinfo_HASHCODE = "postinfo".hashCode();
    mediaExtList_HASHCODE = "mediaExtList".hashCode();
    reportObject_HASHCODE = "reportObject".hashCode();
    postExtraData_HASHCODE = "postExtraData".hashCode();
    customData_HASHCODE = "customData".hashCode();
    longVideoMediaExtList_HASHCODE = "longVideoMediaExtList".hashCode();
    halfMediaExtList_HASHCODE = "halfMediaExtList".hashCode();
    clipList_HASHCODE = "clipList".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static void createTable(ISQLiteDatabase paramISQLiteDatabase)
  {
    Object localObject = new LinkedList();
    ((List)localObject).add(getCreateSQLs());
    String[] arrayOfString = INDEX_CREATE;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      ((List)localObject).add(arrayOfString[i]);
      i += 1;
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramISQLiteDatabase.execSQL("FinderFeedItem", (String)((Iterator)localObject).next());
    }
  }
  
  public static final cn.a cvBuilder()
  {
    return new cn.a();
  }
  
  public static final b delete()
  {
    return new b();
  }
  
  public static final DeleteExecutor delete(cn paramcn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new DeleteExecutor(paramcn, paramcn.createDeleteEvent(), observerOwner, "MicroMsg.SDK.BaseFinderFeedItem");
    }
    return new DeleteExecutor(paramcn, null, null, "MicroMsg.SDK.BaseFinderFeedItem");
  }
  
  private static String getCreateSQLs()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS FinderFeedItem ( ");
    localStringBuilder.append(DB_INFO.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[16];
    paramClass.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "localId";
    paramClass.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.primaryKey = "localId";
    paramClass.columns[1] = "id";
    paramClass.colsMap.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "createTime";
    paramClass.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "username";
    paramClass.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "sourceFlag";
    paramClass.colsMap.put("sourceFlag", "INTEGER");
    localStringBuilder.append(" sourceFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "updateTime";
    paramClass.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "finderObject";
    paramClass.colsMap.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "localFlag";
    paramClass.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "postinfo";
    paramClass.colsMap.put("postinfo", "BLOB");
    localStringBuilder.append(" postinfo BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "mediaExtList";
    paramClass.colsMap.put("mediaExtList", "BLOB");
    localStringBuilder.append(" mediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "reportObject";
    paramClass.colsMap.put("reportObject", "BLOB");
    localStringBuilder.append(" reportObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "postExtraData";
    paramClass.colsMap.put("postExtraData", "BLOB");
    localStringBuilder.append(" postExtraData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "customData";
    paramClass.colsMap.put("customData", "BLOB");
    localStringBuilder.append(" customData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[13] = "longVideoMediaExtList";
    paramClass.colsMap.put("longVideoMediaExtList", "BLOB");
    localStringBuilder.append(" longVideoMediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[14] = "halfMediaExtList";
    paramClass.colsMap.put("halfMediaExtList", "BLOB");
    localStringBuilder.append(" halfMediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[15] = "clipList";
    paramClass.colsMap.put("clipList", "BLOB");
    localStringBuilder.append(" clipList BLOB");
    paramClass.columns[16] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    if (paramClass.primaryKey == null) {
      paramClass.primaryKey = "rowid";
    }
    return paramClass;
  }
  
  public static final InsertExecutor insert(cn paramcn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramcn, true, paramcn.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseFinderFeedItem");
    }
    return new InsertExecutor(paramcn, true, null, null, "MicroMsg.SDK.BaseFinderFeedItem");
  }
  
  public static final InsertExecutor insertOrThrow(cn paramcn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramcn, false, paramcn.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseFinderFeedItem");
    }
    return new InsertExecutor(paramcn, false, null, null, "MicroMsg.SDK.BaseFinderFeedItem");
  }
  
  public static final SelectSql isExistByLocalId(long paramLong)
  {
    return TABLE.select(LOCALID).where(LOCALID.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseFinderFeedItem").limit(1, 0).build();
  }
  
  public static final void observe(q paramq, IStorageObserver<? extends cn> paramIStorageObserver)
  {
    observerOwner.observe(paramq, paramIStorageObserver);
  }
  
  private final void parseBuff() {}
  
  public static final void removeObserve(IStorageObserver<? extends cn> paramIStorageObserver)
  {
    observerOwner.removeObserver(paramIStorageObserver);
  }
  
  public static final ReplaceExecutor replace(cn paramcn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new ReplaceExecutor(paramcn, paramcn.createReplaceEvent(), observerOwner, "MicroMsg.SDK.BaseFinderFeedItem");
    }
    return new ReplaceExecutor(paramcn, null, null, "MicroMsg.SDK.BaseFinderFeedItem");
  }
  
  public static final cn.c select()
  {
    return new cn.c();
  }
  
  public static final SelectSql selectByCreateTime(long paramLong)
  {
    return TABLE.selectAll().where(CREATETIME.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByCreateTimeList(List<Long> paramList)
  {
    return TABLE.selectAll().where(CREATETIME.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectById(long paramLong)
  {
    return TABLE.selectAll().where(ID.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByIdList(List<Long> paramList)
  {
    return TABLE.selectAll().where(ID.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByLocalFlag(int paramInt)
  {
    return TABLE.selectAll().where(LOCALFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByLocalFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LOCALFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByLocalId(long paramLong)
  {
    return TABLE.selectAll().where(LOCALID.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByLocalIdList(List<Long> paramList)
  {
    return TABLE.selectAll().where(LOCALID.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectBySourceFlag(int paramInt)
  {
    return TABLE.selectAll().where(SOURCEFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectBySourceFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(SOURCEFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByUpdateTime(long paramLong)
  {
    return TABLE.selectAll().where(UPDATETIME.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByUpdateTimeList(List<Long> paramList)
  {
    return TABLE.selectAll().where(UPDATETIME.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByUsername(String paramString)
  {
    return TABLE.selectAll().where(USERNAME.equal(paramString)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectByUsernameList(List<String> paramList)
  {
    return TABLE.selectAll().where(USERNAME.inString(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final SelectSql selectExistListByLocalId(List<Long> paramList)
  {
    return TABLE.select(LOCALID).where(LOCALID.inNumber(paramList)).log("MicroMsg.SDK.BaseFinderFeedItem").build();
  }
  
  public static final cn.d update()
  {
    return new cn.d();
  }
  
  public static final UpdateExecutor update(cn paramcn, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new UpdateExecutor(paramcn, paramcn.createUpdateEvent(), observerOwner, "MicroMsg.SDK.BaseFinderFeedItem");
    }
    return new UpdateExecutor(paramcn, null, null, "MicroMsg.SDK.BaseFinderFeedItem");
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsLong("localId").longValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("id"))
    {
      this.field_id = paramContentValues.getAsLong("id").longValue();
      if (paramBoolean) {
        this.__hadSetid = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("sourceFlag"))
    {
      this.field_sourceFlag = paramContentValues.getAsInteger("sourceFlag").intValue();
      if (paramBoolean) {
        this.__hadSetsourceFlag = true;
      }
    }
    if (paramContentValues.containsKey("updateTime"))
    {
      this.field_updateTime = paramContentValues.getAsLong("updateTime").longValue();
      if (paramBoolean) {
        this.__hadSetupdateTime = true;
      }
    }
    if (paramContentValues.containsKey("finderObject")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("finderObject");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_finderObject = ((FinderObject)new FinderObject().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetfinderObject = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("localFlag"))
    {
      this.field_localFlag = paramContentValues.getAsInteger("localFlag").intValue();
      if (paramBoolean) {
        this.__hadSetlocalFlag = true;
      }
    }
    if (paramContentValues.containsKey("postinfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("postinfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_postinfo = ((djj)new djj().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetpostinfo = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("mediaExtList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("mediaExtList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_mediaExtList = ((djq)new djq().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetmediaExtList = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
      }
    }
    if (paramContentValues.containsKey("reportObject")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("reportObject");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_reportObject = ((FinderFeedReportObject)new FinderFeedReportObject().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetreportObject = true;
        }
      }
    }
    catch (IOException localIOException4)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
      }
    }
    if (paramContentValues.containsKey("postExtraData")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("postExtraData");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_postExtraData = ((bso)new bso().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetpostExtraData = true;
        }
      }
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
      }
    }
    if (paramContentValues.containsKey("customData")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("customData");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_customData = ((awf)new awf().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetcustomData = true;
        }
      }
    }
    catch (IOException localIOException6)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
      }
    }
    if (paramContentValues.containsKey("longVideoMediaExtList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("longVideoMediaExtList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_longVideoMediaExtList = ((djq)new djq().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetlongVideoMediaExtList = true;
        }
      }
    }
    catch (IOException localIOException7)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException7.getMessage());
      }
    }
    if (paramContentValues.containsKey("halfMediaExtList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("halfMediaExtList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_halfMediaExtList = ((djq)new djq().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSethalfMediaExtList = true;
        }
      }
    }
    catch (IOException localIOException8)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException8.getMessage());
      }
    }
    if (paramContentValues.containsKey("clipList")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("clipList");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_clipList = ((dje)new dje().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.__hadSetclipList = true;
        }
      }
    }
    catch (IOException localIOException9)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException9.getMessage());
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (id_HASHCODE == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (sourceFlag_HASHCODE == k) {
        this.field_sourceFlag = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (finderObject_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_finderObject = ((FinderObject)new FinderObject().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
        }
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (postinfo_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_postinfo = ((djj)new djj().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
        }
      } else if (mediaExtList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_mediaExtList = ((djq)new djq().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
        }
      } else if (reportObject_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_reportObject = ((FinderFeedReportObject)new FinderFeedReportObject().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
        }
      } else if (postExtraData_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_postExtraData = ((bso)new bso().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
        }
      } else if (customData_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_customData = ((awf)new awf().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
        }
      } else if (longVideoMediaExtList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte7 = paramCursor.getBlob(i);
          if ((arrayOfByte7 == null) || (arrayOfByte7.length <= 0)) {
            continue;
          }
          this.field_longVideoMediaExtList = ((djq)new djq().parseFrom(arrayOfByte7));
        }
        catch (IOException localIOException7)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException7.getMessage());
        }
      } else if (halfMediaExtList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte8 = paramCursor.getBlob(i);
          if ((arrayOfByte8 == null) || (arrayOfByte8.length <= 0)) {
            continue;
          }
          this.field_halfMediaExtList = ((djq)new djq().parseFrom(arrayOfByte8));
        }
        catch (IOException localIOException8)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException8.getMessage());
        }
      } else if (clipList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte9 = paramCursor.getBlob(i);
          if ((arrayOfByte9 == null) || (arrayOfByte9.length <= 0)) {
            continue;
          }
          this.field_clipList = ((dje)new dje().parseFrom(arrayOfByte9));
        }
        catch (IOException localIOException9)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException9.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    buildBuff();
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.__hadSetid) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetsourceFlag) {
      localContentValues.put("sourceFlag", Integer.valueOf(this.field_sourceFlag));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.__hadSetfinderObject) && (this.field_finderObject != null)) {}
    try
    {
      localContentValues.put("finderObject", this.field_finderObject.toByteArray());
      if (this.__hadSetlocalFlag) {
        localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
      }
      if ((!this.__hadSetpostinfo) || (this.field_postinfo == null)) {}
    }
    catch (IOException localIOException8)
    {
      try
      {
        localContentValues.put("postinfo", this.field_postinfo.toByteArray());
        if ((!this.__hadSetmediaExtList) || (this.field_mediaExtList == null)) {}
      }
      catch (IOException localIOException8)
      {
        try
        {
          localContentValues.put("mediaExtList", this.field_mediaExtList.toByteArray());
          if ((!this.__hadSetreportObject) || (this.field_reportObject == null)) {}
        }
        catch (IOException localIOException8)
        {
          try
          {
            localContentValues.put("reportObject", this.field_reportObject.toByteArray());
            if ((!this.__hadSetpostExtraData) || (this.field_postExtraData == null)) {}
          }
          catch (IOException localIOException8)
          {
            try
            {
              localContentValues.put("postExtraData", this.field_postExtraData.toByteArray());
              if ((!this.__hadSetcustomData) || (this.field_customData == null)) {}
            }
            catch (IOException localIOException8)
            {
              try
              {
                localContentValues.put("customData", this.field_customData.toByteArray());
                if ((!this.__hadSetlongVideoMediaExtList) || (this.field_longVideoMediaExtList == null)) {}
              }
              catch (IOException localIOException8)
              {
                try
                {
                  localContentValues.put("longVideoMediaExtList", this.field_longVideoMediaExtList.toByteArray());
                  if ((!this.__hadSethalfMediaExtList) || (this.field_halfMediaExtList == null)) {}
                }
                catch (IOException localIOException8)
                {
                  try
                  {
                    localContentValues.put("halfMediaExtList", this.field_halfMediaExtList.toByteArray());
                    if ((!this.__hadSetclipList) || (this.field_clipList == null)) {}
                  }
                  catch (IOException localIOException8)
                  {
                    try
                    {
                      for (;;)
                      {
                        localContentValues.put("clipList", this.field_clipList.toByteArray());
                        if (this.systemRowid > 0L) {
                          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                        }
                        return localContentValues;
                        localIOException1 = localIOException1;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
                        continue;
                        localIOException2 = localIOException2;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
                        continue;
                        localIOException3 = localIOException3;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
                        continue;
                        localIOException4 = localIOException4;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
                        continue;
                        localIOException5 = localIOException5;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
                        continue;
                        localIOException6 = localIOException6;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
                        continue;
                        localIOException7 = localIOException7;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException7.getMessage());
                      }
                      localIOException8 = localIOException8;
                      Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException8.getMessage());
                    }
                    catch (IOException localIOException9)
                    {
                      for (;;)
                      {
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException9.getMessage());
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  protected StorageObserverEvent<? extends cn> createDeleteEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseFinderFeedItem");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends cn> createInsertEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getINSERT(), "MicroMsg.SDK.BaseFinderFeedItem");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends cn> createReplaceEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseFinderFeedItem");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends cn> createUpdateEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseFinderFeedItem");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  public int deleteFromDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return delete(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends cn> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_localId);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
  
  public long insertOrThrowToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return insertOrThrow(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public long insertToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return insert(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public boolean isExistByLocalIdInDB(ISQLiteDatabase paramISQLiteDatabase)
  {
    return isExistByLocalId(this.field_localId).isExist(paramISQLiteDatabase);
  }
  
  public long replaceToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return replace(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public void reset() {}
  
  public SelectSql selectByCreateTime()
  {
    return selectByCreateTime(this.field_createTime);
  }
  
  public SelectSql selectById()
  {
    return selectById(this.field_id);
  }
  
  public SelectSql selectByLocalFlag()
  {
    return selectByLocalFlag(this.field_localFlag);
  }
  
  public SelectSql selectByLocalId()
  {
    return selectByLocalId(this.field_localId);
  }
  
  public SelectSql selectBySourceFlag()
  {
    return selectBySourceFlag(this.field_sourceFlag);
  }
  
  public SelectSql selectByUpdateTime()
  {
    return selectByUpdateTime(this.field_updateTime);
  }
  
  public SelectSql selectByUsername()
  {
    return selectByUsername(this.field_username);
  }
  
  public int updateToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return update(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public static class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import androidx.lifecycle.q;
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
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class hm
  extends IAutoDBItem
{
  public static final Column ATTRBUF;
  public static final String COL_ATTRBUF = "attrBuf";
  public static final String COL_CONTENT = "content";
  public static final String COL_CREATETIME = "createTime";
  public static final String COL_HEAD = "head";
  public static final String COL_LIKEFLAG = "likeFlag";
  public static final String COL_LOCALFLAG = "localFlag";
  public static final String COL_LOCALPRIVATE = "localPrivate";
  public static final String COL_POSTBUF = "postBuf";
  public static final String COL_PRAVITED = "pravited";
  public static final String COL_SERVEREXTFLAG = "serverExtFlag";
  public static final String COL_SNSID = "snsId";
  public static final String COL_SOURCETYPE = "sourceType";
  public static final String COL_STRINGSEQ = "stringSeq";
  public static final String COL_SUBTYPE = "subType";
  public static final String COL_TYPE = "type";
  public static final String COL_USERNAME = "userName";
  public static final String COL_WITHTA = "withTa";
  public static final String COL_WITHTAHASOTHER = "withTaHasOther";
  public static final Column CONTENT;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = initAutoDBInfo(hm.class);
  public static final Column HEAD;
  public static final String[] INDEX_CREATE;
  public static final Column LIKEFLAG;
  public static final Column LOCALFLAG;
  public static final Column LOCALPRIVATE;
  public static final Column POSTBUF;
  public static final Column PRAVITED;
  public static final Column ROWID;
  public static final Column SERVEREXTFLAG;
  public static final Column SNSID;
  public static final Column SOURCETYPE;
  public static final Column STRINGSEQ;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("SnsInfo");
  public static final String TABLE_NAME = "SnsInfo";
  private static final String TAG_ = "MicroMsg.SDK.BaseSnsInfo";
  public static final Column TYPE;
  public static final Column USERNAME;
  public static final Column WITHTA;
  public static final Column WITHTAHASOTHER;
  private static final int attrBuf_HASHCODE;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int head_HASHCODE;
  private static final int likeFlag_HASHCODE;
  private static final int localFlag_HASHCODE;
  private static final int localPrivate_HASHCODE;
  private static final StorageObserverOwner<hm> observerOwner = new StorageObserverOwner();
  private static final int postBuf_HASHCODE;
  private static final int pravited_HASHCODE;
  private static final int rowid_HASHCODE;
  private static final int serverExtFlag_HASHCODE;
  private static final int snsId_HASHCODE;
  private static final int sourceType_HASHCODE;
  private static final int stringSeq_HASHCODE;
  private static final int subType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE;
  private static final int withTaHasOther_HASHCODE;
  private static final int withTa_HASHCODE;
  private boolean __hadSetattrBuf = true;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSethead = true;
  private boolean __hadSetlikeFlag = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalPrivate = true;
  private boolean __hadSetpostBuf = true;
  private boolean __hadSetpravited = true;
  private boolean __hadSetserverExtFlag = true;
  private boolean __hadSetsnsId = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSetstringSeq = true;
  private boolean __hadSetsubType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetuserName = true;
  private boolean __hadSetwithTa = true;
  private boolean __hadSetwithTaHasOther = true;
  public byte[] field_attrBuf;
  public byte[] field_content;
  public int field_createTime;
  public int field_head;
  public int field_likeFlag;
  public int field_localFlag;
  public int field_localPrivate;
  public byte[] field_postBuf;
  public int field_pravited;
  public int field_serverExtFlag;
  public long field_snsId;
  public int field_sourceType;
  public String field_stringSeq;
  public int field_subType;
  public int field_type;
  public String field_userName;
  public String field_withTa;
  public int field_withTaHasOther;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    SNSID = new Column("snsId", "long", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    LOCALFLAG = new Column("localFlag", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "int", TABLE.getName(), "");
    HEAD = new Column("head", "int", TABLE.getName(), "");
    LOCALPRIVATE = new Column("localPrivate", "int", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    SOURCETYPE = new Column("sourceType", "int", TABLE.getName(), "");
    LIKEFLAG = new Column("likeFlag", "int", TABLE.getName(), "");
    PRAVITED = new Column("pravited", "int", TABLE.getName(), "");
    STRINGSEQ = new Column("stringSeq", "string", TABLE.getName(), "");
    WITHTA = new Column("withTa", "string", TABLE.getName(), "");
    WITHTAHASOTHER = new Column("withTaHasOther", "int", TABLE.getName(), "");
    CONTENT = new Column("content", "byte[]", TABLE.getName(), "");
    ATTRBUF = new Column("attrBuf", "byte[]", TABLE.getName(), "");
    POSTBUF = new Column("postBuf", "byte[]", TABLE.getName(), "");
    SUBTYPE = new Column("subType", "int", TABLE.getName(), "");
    SERVEREXTFLAG = new Column("serverExtFlag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    snsId_HASHCODE = "snsId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    head_HASHCODE = "head".hashCode();
    localPrivate_HASHCODE = "localPrivate".hashCode();
    type_HASHCODE = "type".hashCode();
    sourceType_HASHCODE = "sourceType".hashCode();
    likeFlag_HASHCODE = "likeFlag".hashCode();
    pravited_HASHCODE = "pravited".hashCode();
    stringSeq_HASHCODE = "stringSeq".hashCode();
    withTa_HASHCODE = "withTa".hashCode();
    withTaHasOther_HASHCODE = "withTaHasOther".hashCode();
    content_HASHCODE = "content".hashCode();
    attrBuf_HASHCODE = "attrBuf".hashCode();
    postBuf_HASHCODE = "postBuf".hashCode();
    subType_HASHCODE = "subType".hashCode();
    serverExtFlag_HASHCODE = "serverExtFlag".hashCode();
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
      paramISQLiteDatabase.execSQL("SnsInfo", (String)((Iterator)localObject).next());
    }
  }
  
  public static final hm.a cvBuilder()
  {
    return new hm.a();
  }
  
  public static final b delete()
  {
    return new b();
  }
  
  public static final DeleteExecutor delete(hm paramhm, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new DeleteExecutor(paramhm, paramhm.createDeleteEvent(), observerOwner, "MicroMsg.SDK.BaseSnsInfo");
    }
    return new DeleteExecutor(paramhm, null, null, "MicroMsg.SDK.BaseSnsInfo");
  }
  
  private static String getCreateSQLs()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS SnsInfo ( ");
    localStringBuilder.append(DB_INFO.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[18];
    paramClass.columns = new String[19];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "snsId";
    paramClass.colsMap.put("snsId", "LONG");
    localStringBuilder.append(" snsId LONG");
    localStringBuilder.append(", ");
    paramClass.columns[1] = "userName";
    paramClass.colsMap.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "localFlag";
    paramClass.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "createTime";
    paramClass.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "head";
    paramClass.colsMap.put("head", "INTEGER");
    localStringBuilder.append(" head INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "localPrivate";
    paramClass.colsMap.put("localPrivate", "INTEGER");
    localStringBuilder.append(" localPrivate INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "type";
    paramClass.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "sourceType";
    paramClass.colsMap.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "likeFlag";
    paramClass.colsMap.put("likeFlag", "INTEGER");
    localStringBuilder.append(" likeFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "pravited";
    paramClass.colsMap.put("pravited", "INTEGER");
    localStringBuilder.append(" pravited INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "stringSeq";
    paramClass.colsMap.put("stringSeq", "TEXT");
    localStringBuilder.append(" stringSeq TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "withTa";
    paramClass.colsMap.put("withTa", "TEXT");
    localStringBuilder.append(" withTa TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "withTaHasOther";
    paramClass.colsMap.put("withTaHasOther", "INTEGER");
    localStringBuilder.append(" withTaHasOther INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[13] = "content";
    paramClass.colsMap.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[14] = "attrBuf";
    paramClass.colsMap.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[15] = "postBuf";
    paramClass.colsMap.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[16] = "subType";
    paramClass.colsMap.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[17] = "serverExtFlag";
    paramClass.colsMap.put("serverExtFlag", "INTEGER");
    localStringBuilder.append(" serverExtFlag INTEGER");
    paramClass.columns[18] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    if (paramClass.primaryKey == null) {
      paramClass.primaryKey = "rowid";
    }
    return paramClass;
  }
  
  public static final InsertExecutor insert(hm paramhm, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramhm, true, paramhm.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseSnsInfo");
    }
    return new InsertExecutor(paramhm, true, null, null, "MicroMsg.SDK.BaseSnsInfo");
  }
  
  public static final InsertExecutor insertOrThrow(hm paramhm, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramhm, false, paramhm.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseSnsInfo");
    }
    return new InsertExecutor(paramhm, false, null, null, "MicroMsg.SDK.BaseSnsInfo");
  }
  
  public static final void observe(q paramq, IStorageObserver<? extends hm> paramIStorageObserver)
  {
    observerOwner.observe(paramq, paramIStorageObserver);
  }
  
  private final void parseBuff() {}
  
  public static final void removeObserve(IStorageObserver<? extends hm> paramIStorageObserver)
  {
    observerOwner.removeObserver(paramIStorageObserver);
  }
  
  public static final ReplaceExecutor replace(hm paramhm, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new ReplaceExecutor(paramhm, paramhm.createReplaceEvent(), observerOwner, "MicroMsg.SDK.BaseSnsInfo");
    }
    return new ReplaceExecutor(paramhm, null, null, "MicroMsg.SDK.BaseSnsInfo");
  }
  
  public static final hm.c select()
  {
    return new hm.c();
  }
  
  public static final SelectSql selectByCreateTime(int paramInt)
  {
    return TABLE.selectAll().where(CREATETIME.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByCreateTimeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(CREATETIME.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByHead(int paramInt)
  {
    return TABLE.selectAll().where(HEAD.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByHeadList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(HEAD.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByLikeFlag(int paramInt)
  {
    return TABLE.selectAll().where(LIKEFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByLikeFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LIKEFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalFlag(int paramInt)
  {
    return TABLE.selectAll().where(LOCALFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LOCALFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalPrivate(int paramInt)
  {
    return TABLE.selectAll().where(LOCALPRIVATE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalPrivateList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LOCALPRIVATE.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByPravited(int paramInt)
  {
    return TABLE.selectAll().where(PRAVITED.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByPravitedList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(PRAVITED.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByServerExtFlag(int paramInt)
  {
    return TABLE.selectAll().where(SERVEREXTFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByServerExtFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(SERVEREXTFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectBySnsId(long paramLong)
  {
    return TABLE.selectAll().where(SNSID.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectBySnsIdList(List<Long> paramList)
  {
    return TABLE.selectAll().where(SNSID.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectBySourceType(int paramInt)
  {
    return TABLE.selectAll().where(SOURCETYPE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectBySourceTypeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(SOURCETYPE.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByStringSeq(String paramString)
  {
    return TABLE.selectAll().where(STRINGSEQ.equal(paramString)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByStringSeqList(List<String> paramList)
  {
    return TABLE.selectAll().where(STRINGSEQ.inString(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectBySubType(int paramInt)
  {
    return TABLE.selectAll().where(SUBTYPE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectBySubTypeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(SUBTYPE.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByType(int paramInt)
  {
    return TABLE.selectAll().where(TYPE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByTypeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(TYPE.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByUserName(String paramString)
  {
    return TABLE.selectAll().where(USERNAME.equal(paramString)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByUserNameList(List<String> paramList)
  {
    return TABLE.selectAll().where(USERNAME.inString(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByWithTa(String paramString)
  {
    return TABLE.selectAll().where(WITHTA.equal(paramString)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByWithTaHasOther(int paramInt)
  {
    return TABLE.selectAll().where(WITHTAHASOTHER.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByWithTaHasOtherList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(WITHTAHASOTHER.inNumber(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final SelectSql selectByWithTaList(List<String> paramList)
  {
    return TABLE.selectAll().where(WITHTA.inString(paramList)).log("MicroMsg.SDK.BaseSnsInfo").build();
  }
  
  public static final hm.d update()
  {
    return new hm.d();
  }
  
  public static final UpdateExecutor update(hm paramhm, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new UpdateExecutor(paramhm, paramhm.createUpdateEvent(), observerOwner, "MicroMsg.SDK.BaseSnsInfo");
    }
    return new UpdateExecutor(paramhm, null, null, "MicroMsg.SDK.BaseSnsInfo");
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("snsId"))
    {
      this.field_snsId = paramContentValues.getAsLong("snsId").longValue();
      if (paramBoolean) {
        this.__hadSetsnsId = true;
      }
    }
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("localFlag"))
    {
      this.field_localFlag = paramContentValues.getAsInteger("localFlag").intValue();
      if (paramBoolean) {
        this.__hadSetlocalFlag = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsInteger("createTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("head"))
    {
      this.field_head = paramContentValues.getAsInteger("head").intValue();
      if (paramBoolean) {
        this.__hadSethead = true;
      }
    }
    if (paramContentValues.containsKey("localPrivate"))
    {
      this.field_localPrivate = paramContentValues.getAsInteger("localPrivate").intValue();
      if (paramBoolean) {
        this.__hadSetlocalPrivate = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("sourceType"))
    {
      this.field_sourceType = paramContentValues.getAsInteger("sourceType").intValue();
      if (paramBoolean) {
        this.__hadSetsourceType = true;
      }
    }
    if (paramContentValues.containsKey("likeFlag"))
    {
      this.field_likeFlag = paramContentValues.getAsInteger("likeFlag").intValue();
      if (paramBoolean) {
        this.__hadSetlikeFlag = true;
      }
    }
    if (paramContentValues.containsKey("pravited"))
    {
      this.field_pravited = paramContentValues.getAsInteger("pravited").intValue();
      if (paramBoolean) {
        this.__hadSetpravited = true;
      }
    }
    if (paramContentValues.containsKey("stringSeq"))
    {
      this.field_stringSeq = paramContentValues.getAsString("stringSeq");
      if (paramBoolean) {
        this.__hadSetstringSeq = true;
      }
    }
    if (paramContentValues.containsKey("withTa"))
    {
      this.field_withTa = paramContentValues.getAsString("withTa");
      if (paramBoolean) {
        this.__hadSetwithTa = true;
      }
    }
    if (paramContentValues.containsKey("withTaHasOther"))
    {
      this.field_withTaHasOther = paramContentValues.getAsInteger("withTaHasOther").intValue();
      if (paramBoolean) {
        this.__hadSetwithTaHasOther = true;
      }
    }
    if (paramContentValues.containsKey("content"))
    {
      this.field_content = paramContentValues.getAsByteArray("content");
      if (paramBoolean) {
        this.__hadSetcontent = true;
      }
    }
    if (paramContentValues.containsKey("attrBuf"))
    {
      this.field_attrBuf = paramContentValues.getAsByteArray("attrBuf");
      if (paramBoolean) {
        this.__hadSetattrBuf = true;
      }
    }
    if (paramContentValues.containsKey("postBuf"))
    {
      this.field_postBuf = paramContentValues.getAsByteArray("postBuf");
      if (paramBoolean) {
        this.__hadSetpostBuf = true;
      }
    }
    if (paramContentValues.containsKey("subType"))
    {
      this.field_subType = paramContentValues.getAsInteger("subType").intValue();
      if (paramBoolean) {
        this.__hadSetsubType = true;
      }
    }
    if (paramContentValues.containsKey("serverExtFlag"))
    {
      this.field_serverExtFlag = paramContentValues.getAsInteger("serverExtFlag").intValue();
      if (paramBoolean) {
        this.__hadSetserverExtFlag = true;
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
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (snsId_HASHCODE != k) {
        break label60;
      }
      this.field_snsId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (head_HASHCODE == k) {
        this.field_head = paramCursor.getInt(i);
      } else if (localPrivate_HASHCODE == k) {
        this.field_localPrivate = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (sourceType_HASHCODE == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (likeFlag_HASHCODE == k) {
        this.field_likeFlag = paramCursor.getInt(i);
      } else if (pravited_HASHCODE == k) {
        this.field_pravited = paramCursor.getInt(i);
      } else if (stringSeq_HASHCODE == k) {
        this.field_stringSeq = paramCursor.getString(i);
      } else if (withTa_HASHCODE == k) {
        this.field_withTa = paramCursor.getString(i);
      } else if (withTaHasOther_HASHCODE == k) {
        this.field_withTaHasOther = paramCursor.getInt(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (attrBuf_HASHCODE == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (postBuf_HASHCODE == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (serverExtFlag_HASHCODE == k) {
        this.field_serverExtFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    buildBuff();
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetsnsId) {
      localContentValues.put("snsId", Long.valueOf(this.field_snsId));
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.__hadSetlocalFlag) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.__hadSethead) {
      localContentValues.put("head", Integer.valueOf(this.field_head));
    }
    if (this.__hadSetlocalPrivate) {
      localContentValues.put("localPrivate", Integer.valueOf(this.field_localPrivate));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetsourceType) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSetlikeFlag) {
      localContentValues.put("likeFlag", Integer.valueOf(this.field_likeFlag));
    }
    if (this.__hadSetpravited) {
      localContentValues.put("pravited", Integer.valueOf(this.field_pravited));
    }
    if (this.__hadSetstringSeq) {
      localContentValues.put("stringSeq", this.field_stringSeq);
    }
    if (this.__hadSetwithTa) {
      localContentValues.put("withTa", this.field_withTa);
    }
    if (this.__hadSetwithTaHasOther) {
      localContentValues.put("withTaHasOther", Integer.valueOf(this.field_withTaHasOther));
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.__hadSetattrBuf) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.__hadSetpostBuf) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.__hadSetserverExtFlag) {
      localContentValues.put("serverExtFlag", Integer.valueOf(this.field_serverExtFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  protected StorageObserverEvent<? extends hm> createDeleteEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseSnsInfo");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends hm> createInsertEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getINSERT(), "MicroMsg.SDK.BaseSnsInfo");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends hm> createReplaceEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseSnsInfo");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends hm> createUpdateEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseSnsInfo");
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
  
  public StorageObserverOwner<? extends hm> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
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
  
  public long replaceToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return replace(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public void reset() {}
  
  public SelectSql selectByCreateTime()
  {
    return selectByCreateTime(this.field_createTime);
  }
  
  public SelectSql selectByHead()
  {
    return selectByHead(this.field_head);
  }
  
  public SelectSql selectByLikeFlag()
  {
    return selectByLikeFlag(this.field_likeFlag);
  }
  
  public SelectSql selectByLocalFlag()
  {
    return selectByLocalFlag(this.field_localFlag);
  }
  
  public SelectSql selectByLocalPrivate()
  {
    return selectByLocalPrivate(this.field_localPrivate);
  }
  
  public SelectSql selectByPravited()
  {
    return selectByPravited(this.field_pravited);
  }
  
  public SelectSql selectByServerExtFlag()
  {
    return selectByServerExtFlag(this.field_serverExtFlag);
  }
  
  public SelectSql selectBySnsId()
  {
    return selectBySnsId(this.field_snsId);
  }
  
  public SelectSql selectBySourceType()
  {
    return selectBySourceType(this.field_sourceType);
  }
  
  public SelectSql selectByStringSeq()
  {
    return selectByStringSeq(this.field_stringSeq);
  }
  
  public SelectSql selectBySubType()
  {
    return selectBySubType(this.field_subType);
  }
  
  public SelectSql selectByType()
  {
    return selectByType(this.field_type);
  }
  
  public SelectSql selectByUserName()
  {
    return selectByUserName(this.field_userName);
  }
  
  public SelectSql selectByWithTa()
  {
    return selectByWithTa(this.field_withTa);
  }
  
  public SelectSql selectByWithTaHasOther()
  {
    return selectByWithTaHasOther(this.field_withTaHasOther);
  }
  
  public int updateToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return update(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public static class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.b.hm
 * JD-Core Version:    0.7.0.1
 */
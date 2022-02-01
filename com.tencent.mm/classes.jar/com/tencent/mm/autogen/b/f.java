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

public abstract class f
  extends IAutoDBItem
{
  public static final Column ADINFO;
  public static final Column ADXML;
  public static final Column ATADINFO;
  public static final Column ATTRBUF;
  public static final String COL_ADINFO = "adinfo";
  public static final String COL_ADXML = "adxml";
  public static final String COL_ATADINFO = "atAdinfo";
  public static final String COL_ATTRBUF = "attrBuf";
  public static final String COL_CONTENT = "content";
  public static final String COL_CREATEADTIME = "createAdTime";
  public static final String COL_CREATETIME = "createTime";
  public static final String COL_EXPOSURECOUNT = "exposureCount";
  public static final String COL_EXPOSURETIME = "exposureTime";
  public static final String COL_FIRSTCONTROLTIME = "firstControlTime";
  public static final String COL_HEAD = "head";
  public static final String COL_LIKEFLAG = "likeFlag";
  public static final String COL_LOCALFLAG = "localFlag";
  public static final String COL_LOCALPRIVATE = "localPrivate";
  public static final String COL_POSTBUF = "postBuf";
  public static final String COL_PRAVITED = "pravited";
  public static final String COL_RECXML = "recxml";
  public static final String COL_REMINDINFOGROUP = "remindInfoGroup";
  public static final String COL_SNSID = "snsId";
  public static final String COL_SOURCETYPE = "sourceType";
  public static final String COL_STRINGSEQ = "stringSeq";
  public static final String COL_SUBTYPE = "subType";
  public static final String COL_TYPE = "type";
  public static final String COL_USERNAME = "userName";
  public static final Column CONTENT;
  public static final Column CREATEADTIME;
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = initAutoDBInfo(f.class);
  public static final Column EXPOSURECOUNT;
  public static final Column EXPOSURETIME;
  public static final Column FIRSTCONTROLTIME;
  public static final Column HEAD;
  public static final String[] INDEX_CREATE;
  public static final Column LIKEFLAG;
  public static final Column LOCALFLAG;
  public static final Column LOCALPRIVATE;
  public static final Column POSTBUF;
  public static final Column PRAVITED;
  public static final Column RECXML;
  public static final Column REMINDINFOGROUP;
  public static final Column ROWID;
  public static final Column SNSID;
  public static final Column SOURCETYPE;
  public static final Column STRINGSEQ;
  public static final Column SUBTYPE;
  public static final SingleTable TABLE = new SingleTable("AdSnsInfo");
  public static final String TABLE_NAME = "AdSnsInfo";
  private static final String TAG_ = "MicroMsg.SDK.BaseAdSnsInfo";
  public static final Column TYPE;
  public static final Column USERNAME;
  private static final int adinfo_HASHCODE;
  private static final int adxml_HASHCODE;
  private static final int atAdinfo_HASHCODE;
  private static final int attrBuf_HASHCODE;
  private static final int content_HASHCODE;
  private static final int createAdTime_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int exposureCount_HASHCODE;
  private static final int exposureTime_HASHCODE;
  private static final int firstControlTime_HASHCODE;
  private static final int head_HASHCODE;
  private static final int likeFlag_HASHCODE;
  private static final int localFlag_HASHCODE;
  private static final int localPrivate_HASHCODE;
  private static final StorageObserverOwner<f> observerOwner = new StorageObserverOwner();
  private static final int postBuf_HASHCODE;
  private static final int pravited_HASHCODE;
  private static final int recxml_HASHCODE;
  private static final int remindInfoGroup_HASHCODE;
  private static final int rowid_HASHCODE;
  private static final int snsId_HASHCODE;
  private static final int sourceType_HASHCODE;
  private static final int stringSeq_HASHCODE;
  private static final int subType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetadinfo = true;
  private boolean __hadSetadxml = true;
  private boolean __hadSetatAdinfo = true;
  private boolean __hadSetattrBuf = true;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateAdTime = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetexposureCount = true;
  private boolean __hadSetexposureTime = true;
  private boolean __hadSetfirstControlTime = true;
  private boolean __hadSethead = true;
  private boolean __hadSetlikeFlag = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalPrivate = true;
  private boolean __hadSetpostBuf = true;
  private boolean __hadSetpravited = true;
  private boolean __hadSetrecxml = true;
  private boolean __hadSetremindInfoGroup = true;
  private boolean __hadSetsnsId = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSetstringSeq = true;
  private boolean __hadSetsubType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetuserName = true;
  public String field_adinfo;
  public String field_adxml;
  public String field_atAdinfo;
  public byte[] field_attrBuf;
  public byte[] field_content;
  public int field_createAdTime;
  public int field_createTime;
  public int field_exposureCount;
  public int field_exposureTime;
  public int field_firstControlTime;
  public int field_head;
  public int field_likeFlag;
  public int field_localFlag;
  public int field_localPrivate;
  public byte[] field_postBuf;
  public int field_pravited;
  public String field_recxml;
  public byte[] field_remindInfoGroup;
  public long field_snsId;
  public int field_sourceType;
  public String field_stringSeq;
  public int field_subType;
  public int field_type;
  public String field_userName;
  
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
    CONTENT = new Column("content", "byte[]", TABLE.getName(), "");
    ATTRBUF = new Column("attrBuf", "byte[]", TABLE.getName(), "");
    POSTBUF = new Column("postBuf", "byte[]", TABLE.getName(), "");
    ADINFO = new Column("adinfo", "string", TABLE.getName(), "");
    ADXML = new Column("adxml", "string", TABLE.getName(), "");
    CREATEADTIME = new Column("createAdTime", "int", TABLE.getName(), "");
    EXPOSURETIME = new Column("exposureTime", "int", TABLE.getName(), "");
    FIRSTCONTROLTIME = new Column("firstControlTime", "int", TABLE.getName(), "");
    RECXML = new Column("recxml", "string", TABLE.getName(), "");
    SUBTYPE = new Column("subType", "int", TABLE.getName(), "");
    EXPOSURECOUNT = new Column("exposureCount", "int", TABLE.getName(), "");
    ATADINFO = new Column("atAdinfo", "string", TABLE.getName(), "");
    REMINDINFOGROUP = new Column("remindInfoGroup", "byte[]", TABLE.getName(), "");
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
    content_HASHCODE = "content".hashCode();
    attrBuf_HASHCODE = "attrBuf".hashCode();
    postBuf_HASHCODE = "postBuf".hashCode();
    adinfo_HASHCODE = "adinfo".hashCode();
    adxml_HASHCODE = "adxml".hashCode();
    createAdTime_HASHCODE = "createAdTime".hashCode();
    exposureTime_HASHCODE = "exposureTime".hashCode();
    firstControlTime_HASHCODE = "firstControlTime".hashCode();
    recxml_HASHCODE = "recxml".hashCode();
    subType_HASHCODE = "subType".hashCode();
    exposureCount_HASHCODE = "exposureCount".hashCode();
    atAdinfo_HASHCODE = "atAdinfo".hashCode();
    remindInfoGroup_HASHCODE = "remindInfoGroup".hashCode();
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
      paramISQLiteDatabase.execSQL("AdSnsInfo", (String)((Iterator)localObject).next());
    }
  }
  
  public static final f.a cvBuilder()
  {
    return new f.a();
  }
  
  public static final b delete()
  {
    return new b();
  }
  
  public static final DeleteExecutor delete(f paramf, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new DeleteExecutor(paramf, paramf.createDeleteEvent(), observerOwner, "MicroMsg.SDK.BaseAdSnsInfo");
    }
    return new DeleteExecutor(paramf, null, null, "MicroMsg.SDK.BaseAdSnsInfo");
  }
  
  private static String getCreateSQLs()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CREATE TABLE IF NOT EXISTS AdSnsInfo ( ");
    localStringBuilder.append(DB_INFO.sql);
    localStringBuilder.append(");");
    return localStringBuilder.toString();
  }
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[24];
    paramClass.columns = new String[25];
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
    paramClass.columns[11] = "content";
    paramClass.colsMap.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "attrBuf";
    paramClass.colsMap.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[13] = "postBuf";
    paramClass.colsMap.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[14] = "adinfo";
    paramClass.colsMap.put("adinfo", "TEXT");
    localStringBuilder.append(" adinfo TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[15] = "adxml";
    paramClass.colsMap.put("adxml", "TEXT");
    localStringBuilder.append(" adxml TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[16] = "createAdTime";
    paramClass.colsMap.put("createAdTime", "INTEGER");
    localStringBuilder.append(" createAdTime INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[17] = "exposureTime";
    paramClass.colsMap.put("exposureTime", "INTEGER");
    localStringBuilder.append(" exposureTime INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[18] = "firstControlTime";
    paramClass.colsMap.put("firstControlTime", "INTEGER");
    localStringBuilder.append(" firstControlTime INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[19] = "recxml";
    paramClass.colsMap.put("recxml", "TEXT");
    localStringBuilder.append(" recxml TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[20] = "subType";
    paramClass.colsMap.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[21] = "exposureCount";
    paramClass.colsMap.put("exposureCount", "INTEGER");
    localStringBuilder.append(" exposureCount INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[22] = "atAdinfo";
    paramClass.colsMap.put("atAdinfo", "TEXT");
    localStringBuilder.append(" atAdinfo TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[23] = "remindInfoGroup";
    paramClass.colsMap.put("remindInfoGroup", "BLOB");
    localStringBuilder.append(" remindInfoGroup BLOB");
    paramClass.columns[24] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    if (paramClass.primaryKey == null) {
      paramClass.primaryKey = "rowid";
    }
    return paramClass;
  }
  
  public static final InsertExecutor insert(f paramf, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramf, true, paramf.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseAdSnsInfo");
    }
    return new InsertExecutor(paramf, true, null, null, "MicroMsg.SDK.BaseAdSnsInfo");
  }
  
  public static final InsertExecutor insertOrThrow(f paramf, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new InsertExecutor(paramf, false, paramf.createInsertEvent(), observerOwner, "MicroMsg.SDK.BaseAdSnsInfo");
    }
    return new InsertExecutor(paramf, false, null, null, "MicroMsg.SDK.BaseAdSnsInfo");
  }
  
  public static final void observe(q paramq, IStorageObserver<? extends f> paramIStorageObserver)
  {
    observerOwner.observe(paramq, paramIStorageObserver);
  }
  
  private final void parseBuff() {}
  
  public static final void removeObserve(IStorageObserver<? extends f> paramIStorageObserver)
  {
    observerOwner.removeObserver(paramIStorageObserver);
  }
  
  public static final ReplaceExecutor replace(f paramf, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new ReplaceExecutor(paramf, paramf.createReplaceEvent(), observerOwner, "MicroMsg.SDK.BaseAdSnsInfo");
    }
    return new ReplaceExecutor(paramf, null, null, "MicroMsg.SDK.BaseAdSnsInfo");
  }
  
  public static final f.c select()
  {
    return new f.c();
  }
  
  public static final SelectSql selectByAdinfo(String paramString)
  {
    return TABLE.selectAll().where(ADINFO.equal(paramString)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByAdinfoList(List<String> paramList)
  {
    return TABLE.selectAll().where(ADINFO.inString(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByAdxml(String paramString)
  {
    return TABLE.selectAll().where(ADXML.equal(paramString)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByAdxmlList(List<String> paramList)
  {
    return TABLE.selectAll().where(ADXML.inString(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByAtAdinfo(String paramString)
  {
    return TABLE.selectAll().where(ATADINFO.equal(paramString)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByAtAdinfoList(List<String> paramList)
  {
    return TABLE.selectAll().where(ATADINFO.inString(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByCreateAdTime(int paramInt)
  {
    return TABLE.selectAll().where(CREATEADTIME.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByCreateAdTimeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(CREATEADTIME.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByCreateTime(int paramInt)
  {
    return TABLE.selectAll().where(CREATETIME.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByCreateTimeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(CREATETIME.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByExposureCount(int paramInt)
  {
    return TABLE.selectAll().where(EXPOSURECOUNT.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByExposureCountList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(EXPOSURECOUNT.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByExposureTime(int paramInt)
  {
    return TABLE.selectAll().where(EXPOSURETIME.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByExposureTimeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(EXPOSURETIME.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByFirstControlTime(int paramInt)
  {
    return TABLE.selectAll().where(FIRSTCONTROLTIME.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByFirstControlTimeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(FIRSTCONTROLTIME.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByHead(int paramInt)
  {
    return TABLE.selectAll().where(HEAD.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByHeadList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(HEAD.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByLikeFlag(int paramInt)
  {
    return TABLE.selectAll().where(LIKEFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByLikeFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LIKEFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalFlag(int paramInt)
  {
    return TABLE.selectAll().where(LOCALFLAG.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalFlagList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LOCALFLAG.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalPrivate(int paramInt)
  {
    return TABLE.selectAll().where(LOCALPRIVATE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByLocalPrivateList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(LOCALPRIVATE.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByPravited(int paramInt)
  {
    return TABLE.selectAll().where(PRAVITED.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByPravitedList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(PRAVITED.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByRecxml(String paramString)
  {
    return TABLE.selectAll().where(RECXML.equal(paramString)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByRecxmlList(List<String> paramList)
  {
    return TABLE.selectAll().where(RECXML.inString(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectBySnsId(long paramLong)
  {
    return TABLE.selectAll().where(SNSID.equal(Long.valueOf(paramLong))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectBySnsIdList(List<Long> paramList)
  {
    return TABLE.selectAll().where(SNSID.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectBySourceType(int paramInt)
  {
    return TABLE.selectAll().where(SOURCETYPE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectBySourceTypeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(SOURCETYPE.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByStringSeq(String paramString)
  {
    return TABLE.selectAll().where(STRINGSEQ.equal(paramString)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByStringSeqList(List<String> paramList)
  {
    return TABLE.selectAll().where(STRINGSEQ.inString(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectBySubType(int paramInt)
  {
    return TABLE.selectAll().where(SUBTYPE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectBySubTypeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(SUBTYPE.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByType(int paramInt)
  {
    return TABLE.selectAll().where(TYPE.equal(Integer.valueOf(paramInt))).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByTypeList(List<Integer> paramList)
  {
    return TABLE.selectAll().where(TYPE.inNumber(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByUserName(String paramString)
  {
    return TABLE.selectAll().where(USERNAME.equal(paramString)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final SelectSql selectByUserNameList(List<String> paramList)
  {
    return TABLE.selectAll().where(USERNAME.inString(paramList)).log("MicroMsg.SDK.BaseAdSnsInfo").build();
  }
  
  public static final f.d update()
  {
    return new f.d();
  }
  
  public static final UpdateExecutor update(f paramf, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new UpdateExecutor(paramf, paramf.createUpdateEvent(), observerOwner, "MicroMsg.SDK.BaseAdSnsInfo");
    }
    return new UpdateExecutor(paramf, null, null, "MicroMsg.SDK.BaseAdSnsInfo");
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
    if (paramContentValues.containsKey("adinfo"))
    {
      this.field_adinfo = paramContentValues.getAsString("adinfo");
      if (paramBoolean) {
        this.__hadSetadinfo = true;
      }
    }
    if (paramContentValues.containsKey("adxml"))
    {
      this.field_adxml = paramContentValues.getAsString("adxml");
      if (paramBoolean) {
        this.__hadSetadxml = true;
      }
    }
    if (paramContentValues.containsKey("createAdTime"))
    {
      this.field_createAdTime = paramContentValues.getAsInteger("createAdTime").intValue();
      if (paramBoolean) {
        this.__hadSetcreateAdTime = true;
      }
    }
    if (paramContentValues.containsKey("exposureTime"))
    {
      this.field_exposureTime = paramContentValues.getAsInteger("exposureTime").intValue();
      if (paramBoolean) {
        this.__hadSetexposureTime = true;
      }
    }
    if (paramContentValues.containsKey("firstControlTime"))
    {
      this.field_firstControlTime = paramContentValues.getAsInteger("firstControlTime").intValue();
      if (paramBoolean) {
        this.__hadSetfirstControlTime = true;
      }
    }
    if (paramContentValues.containsKey("recxml"))
    {
      this.field_recxml = paramContentValues.getAsString("recxml");
      if (paramBoolean) {
        this.__hadSetrecxml = true;
      }
    }
    if (paramContentValues.containsKey("subType"))
    {
      this.field_subType = paramContentValues.getAsInteger("subType").intValue();
      if (paramBoolean) {
        this.__hadSetsubType = true;
      }
    }
    if (paramContentValues.containsKey("exposureCount"))
    {
      this.field_exposureCount = paramContentValues.getAsInteger("exposureCount").intValue();
      if (paramBoolean) {
        this.__hadSetexposureCount = true;
      }
    }
    if (paramContentValues.containsKey("atAdinfo"))
    {
      this.field_atAdinfo = paramContentValues.getAsString("atAdinfo");
      if (paramBoolean) {
        this.__hadSetatAdinfo = true;
      }
    }
    if (paramContentValues.containsKey("remindInfoGroup"))
    {
      this.field_remindInfoGroup = paramContentValues.getAsByteArray("remindInfoGroup");
      if (paramBoolean) {
        this.__hadSetremindInfoGroup = true;
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
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (attrBuf_HASHCODE == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (postBuf_HASHCODE == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (adinfo_HASHCODE == k) {
        this.field_adinfo = paramCursor.getString(i);
      } else if (adxml_HASHCODE == k) {
        this.field_adxml = paramCursor.getString(i);
      } else if (createAdTime_HASHCODE == k) {
        this.field_createAdTime = paramCursor.getInt(i);
      } else if (exposureTime_HASHCODE == k) {
        this.field_exposureTime = paramCursor.getInt(i);
      } else if (firstControlTime_HASHCODE == k) {
        this.field_firstControlTime = paramCursor.getInt(i);
      } else if (recxml_HASHCODE == k) {
        this.field_recxml = paramCursor.getString(i);
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (exposureCount_HASHCODE == k) {
        this.field_exposureCount = paramCursor.getInt(i);
      } else if (atAdinfo_HASHCODE == k) {
        this.field_atAdinfo = paramCursor.getString(i);
      } else if (remindInfoGroup_HASHCODE == k) {
        this.field_remindInfoGroup = paramCursor.getBlob(i);
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
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.__hadSetattrBuf) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.__hadSetpostBuf) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.__hadSetadinfo) {
      localContentValues.put("adinfo", this.field_adinfo);
    }
    if (this.__hadSetadxml) {
      localContentValues.put("adxml", this.field_adxml);
    }
    if (this.__hadSetcreateAdTime) {
      localContentValues.put("createAdTime", Integer.valueOf(this.field_createAdTime));
    }
    if (this.__hadSetexposureTime) {
      localContentValues.put("exposureTime", Integer.valueOf(this.field_exposureTime));
    }
    if (this.__hadSetfirstControlTime) {
      localContentValues.put("firstControlTime", Integer.valueOf(this.field_firstControlTime));
    }
    if (this.__hadSetrecxml) {
      localContentValues.put("recxml", this.field_recxml);
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.__hadSetexposureCount) {
      localContentValues.put("exposureCount", Integer.valueOf(this.field_exposureCount));
    }
    if (this.__hadSetatAdinfo) {
      localContentValues.put("atAdinfo", this.field_atAdinfo);
    }
    if (this.__hadSetremindInfoGroup) {
      localContentValues.put("remindInfoGroup", this.field_remindInfoGroup);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  protected StorageObserverEvent<? extends f> createDeleteEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseAdSnsInfo");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends f> createInsertEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getINSERT(), "MicroMsg.SDK.BaseAdSnsInfo");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends f> createReplaceEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseAdSnsInfo");
    localStorageObserverEvent.setObj(this);
    localStorageObserverEvent.setPendingKey(String.valueOf(getPrimaryKeyValue()));
    return localStorageObserverEvent;
  }
  
  protected StorageObserverEvent<? extends f> createUpdateEvent()
  {
    StorageObserverEvent localStorageObserverEvent = new StorageObserverEvent(StorageEventId.getUPDATE(), "MicroMsg.SDK.BaseAdSnsInfo");
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
  
  public StorageObserverOwner<? extends f> getObserverOwner()
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
  
  public SelectSql selectByAdinfo()
  {
    return selectByAdinfo(this.field_adinfo);
  }
  
  public SelectSql selectByAdxml()
  {
    return selectByAdxml(this.field_adxml);
  }
  
  public SelectSql selectByAtAdinfo()
  {
    return selectByAtAdinfo(this.field_atAdinfo);
  }
  
  public SelectSql selectByCreateAdTime()
  {
    return selectByCreateAdTime(this.field_createAdTime);
  }
  
  public SelectSql selectByCreateTime()
  {
    return selectByCreateTime(this.field_createTime);
  }
  
  public SelectSql selectByExposureCount()
  {
    return selectByExposureCount(this.field_exposureCount);
  }
  
  public SelectSql selectByExposureTime()
  {
    return selectByExposureTime(this.field_exposureTime);
  }
  
  public SelectSql selectByFirstControlTime()
  {
    return selectByFirstControlTime(this.field_firstControlTime);
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
  
  public SelectSql selectByRecxml()
  {
    return selectByRecxml(this.field_recxml);
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
  
  public int updateToDB(ISQLiteDatabase paramISQLiteDatabase, boolean paramBoolean)
  {
    return update(this, paramBoolean).execute(paramISQLiteDatabase);
  }
  
  public static class b {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.autogen.b.f
 * JD-Core Version:    0.7.0.1
 */
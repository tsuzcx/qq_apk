package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class f
  extends IAutoDBItem
{
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
  public static final String[] INDEX_CREATE = new String[0];
  public static final String TABLE_NAME = "AdSnsInfo";
  private static final String TAG = "MicroMsg.SDK.BaseAdSnsInfo";
  private static final int adinfo_HASHCODE;
  private static final int adxml_HASHCODE;
  private static final int atAdinfo_HASHCODE = "atAdinfo".hashCode();
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
  private static final int postBuf_HASHCODE;
  private static final int pravited_HASHCODE;
  private static final int recxml_HASHCODE;
  private static final int remindInfoGroup_HASHCODE = "remindInfoGroup".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int snsId_HASHCODE = "snsId".hashCode();
  private static final int sourceType_HASHCODE;
  private static final int stringSeq_HASHCODE;
  private static final int subType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE = "userName".hashCode();
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
  }
  
  private final void buildBuff() {}
  
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
    return paramClass;
  }
  
  private final void parseBuff() {}
  
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
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.f
 * JD-Core Version:    0.7.0.1
 */
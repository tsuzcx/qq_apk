package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gk
  extends IAutoDBItem
{
  public static final String COL_ATTRBUF = "attrBuf";
  public static final String COL_CONTENT = "content";
  public static final String COL_CREATETIME = "createTime";
  public static final String COL_HEAD = "head";
  public static final String COL_LIKEFLAG = "likeFlag";
  public static final String COL_LOCALFLAG = "localFlag";
  public static final String COL_LOCALPRIVATE = "localPrivate";
  public static final String COL_POSTBUF = "postBuf";
  public static final String COL_PRAVITED = "pravited";
  public static final String COL_SNSID = "snsId";
  public static final String COL_SOURCETYPE = "sourceType";
  public static final String COL_STRINGSEQ = "stringSeq";
  public static final String COL_SUBTYPE = "subType";
  public static final String COL_TYPE = "type";
  public static final String COL_USERNAME = "userName";
  public static final String[] INDEX_CREATE = new String[0];
  public static final String TABLE_NAME = "SnsInfo";
  private static final String TAG = "MicroMsg.SDK.BaseSnsInfo";
  private static final int attrBuf_HASHCODE;
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int head_HASHCODE;
  private static final int likeFlag_HASHCODE;
  private static final int localFlag_HASHCODE;
  private static final int localPrivate_HASHCODE;
  private static final int postBuf_HASHCODE;
  private static final int pravited_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int snsId_HASHCODE = "snsId".hashCode();
  private static final int sourceType_HASHCODE;
  private static final int stringSeq_HASHCODE;
  private static final int subType_HASHCODE;
  private static final int type_HASHCODE;
  private static final int userName_HASHCODE = "userName".hashCode();
  private boolean __hadSetattrBuf = true;
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSethead = true;
  private boolean __hadSetlikeFlag = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalPrivate = true;
  private boolean __hadSetpostBuf = true;
  private boolean __hadSetpravited = true;
  private boolean __hadSetsnsId = true;
  private boolean __hadSetsourceType = true;
  private boolean __hadSetstringSeq = true;
  private boolean __hadSetsubType = true;
  private boolean __hadSettype = true;
  private boolean __hadSetuserName = true;
  public byte[] field_attrBuf;
  public byte[] field_content;
  public int field_createTime;
  public int field_head;
  public int field_likeFlag;
  public int field_localFlag;
  public int field_localPrivate;
  public byte[] field_postBuf;
  public int field_pravited;
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
    subType_HASHCODE = "subType".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[15];
    paramClass.columns = new String[16];
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
    paramClass.columns[14] = "subType";
    paramClass.colsMap.put("subType", "INTEGER");
    localStringBuilder.append(" subType INTEGER");
    paramClass.columns[15] = "rowid";
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
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
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
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gk
 * JD-Core Version:    0.7.0.1
 */
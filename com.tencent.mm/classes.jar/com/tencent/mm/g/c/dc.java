package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)" };
  private static final int dGA = "storyID".hashCode();
  private static final int dGB;
  private static final int dGC = "itemStoryFlag".hashCode();
  private static final int dGD = "readCount".hashCode();
  private static final int dGE = "favoriteTime".hashCode();
  private static final int dgK = "userName".hashCode();
  private static final int dgL = "localFlag".hashCode();
  private static final int dgM = "createTime".hashCode();
  private static final int dgP;
  private static final int dgT;
  private static final int dgU;
  private static final int dgV;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dGv = true;
  private boolean dGw = true;
  private boolean dGx = true;
  private boolean dGy = true;
  private boolean dGz = true;
  private boolean dgn = true;
  private boolean dgo = true;
  private boolean dgp = true;
  private boolean dgs = true;
  private boolean dgw = true;
  private boolean dgx = true;
  private boolean dgy = true;
  public byte[] field_attrBuf;
  public int field_commentListCount;
  public byte[] field_content;
  public int field_createTime;
  public int field_favoriteTime;
  public int field_itemStoryFlag;
  public int field_localFlag;
  public byte[] field_postBuf;
  public int field_readCount;
  public int field_sourceType;
  public long field_storyID;
  public int field_type;
  public String field_userName;
  
  static
  {
    dGB = "commentListCount".hashCode();
    dgT = "content".hashCode();
    dgU = "attrBuf".hashCode();
    dgV = "postBuf".hashCode();
    dgP = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyID";
    locala.yrM.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.yrM.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.yrM.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.yrM.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "commentListCount";
    locala.yrM.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "content";
    locala.yrM.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "attrBuf";
    locala.yrM.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "postBuf";
    locala.yrM.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.yrM.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "type";
    locala.yrM.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "itemStoryFlag";
    locala.yrM.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "readCount";
    locala.yrM.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "favoriteTime";
    locala.yrM.put("favoriteTime", "INTEGER");
    localStringBuilder.append(" favoriteTime INTEGER");
    locala.columns[13] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (dGA != k) {
        break label60;
      }
      this.field_storyID = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (dgK == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (dgL == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (dGB == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (dgU == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (dgV == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (dgP == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dGC == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (dGD == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (dGE == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dGv) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.dgo) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.dGw) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.dgx) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.dgy) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.dgs) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dGx) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.dGy) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.dGz) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.dc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dt
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)" };
  private static final int eOC = "storyID".hashCode();
  private static final int eOD;
  private static final int eOE = "itemStoryFlag".hashCode();
  private static final int eOF = "readCount".hashCode();
  private static final int eOG = "favoriteTime".hashCode();
  private static final int ekS = "userName".hashCode();
  private static final int ekT = "localFlag".hashCode();
  private static final int ekU = "createTime".hashCode();
  private static final int ekX;
  private static final int elb;
  private static final int elc;
  private static final int eld;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eOA = true;
  private boolean eOB = true;
  private boolean eOx = true;
  private boolean eOy = true;
  private boolean eOz = true;
  private boolean ekA = true;
  private boolean ekE = true;
  private boolean ekF = true;
  private boolean ekG = true;
  private boolean ekv = true;
  private boolean ekw = true;
  private boolean ekx = true;
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
    eOD = "commentListCount".hashCode();
    elb = "content".hashCode();
    elc = "attrBuf".hashCode();
    eld = "postBuf".hashCode();
    ekX = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyID";
    locala.EYv.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.EYv.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.EYv.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.EYv.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "commentListCount";
    locala.EYv.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "content";
    locala.EYv.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "attrBuf";
    locala.EYv.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "postBuf";
    locala.EYv.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.EYv.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "itemStoryFlag";
    locala.EYv.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "readCount";
    locala.EYv.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "favoriteTime";
    locala.EYv.put("favoriteTime", "INTEGER");
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
      if (eOC != k) {
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
      if (ekS == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (ekT == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eOD == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (elc == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eld == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (ekX == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eOE == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (eOF == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (eOG == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOx) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.ekw) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eOy) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.ekF) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.ekG) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.ekA) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eOz) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.eOA) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.eOB) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dt
 * JD-Core Version:    0.7.0.1
 */
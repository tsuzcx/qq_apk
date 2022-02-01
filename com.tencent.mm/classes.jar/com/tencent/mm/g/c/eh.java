package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eh
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)" };
  private static final int eEd;
  private static final int eEe;
  private static final int eEf;
  private static final int eEi;
  private static final int eEm;
  private static final int eEn;
  private static final int eEo;
  private static final int fkh = "storyID".hashCode();
  private static final int fki;
  private static final int fkj = "itemStoryFlag".hashCode();
  private static final int fkk = "readCount".hashCode();
  private static final int fkl = "favoriteTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eDG = true;
  private boolean eDH = true;
  private boolean eDI = true;
  private boolean eDL = true;
  private boolean eDP = true;
  private boolean eDQ = true;
  private boolean eDR = true;
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
  private boolean fkc = true;
  private boolean fkd = true;
  private boolean fke = true;
  private boolean fkf = true;
  private boolean fkg = true;
  
  static
  {
    eEd = "userName".hashCode();
    eEe = "localFlag".hashCode();
    eEf = "createTime".hashCode();
    fki = "commentListCount".hashCode();
    eEm = "content".hashCode();
    eEn = "attrBuf".hashCode();
    eEo = "postBuf".hashCode();
    eEi = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyID";
    locala.IhC.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.IhC.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.IhC.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.IhC.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "commentListCount";
    locala.IhC.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "content";
    locala.IhC.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "attrBuf";
    locala.IhC.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "postBuf";
    locala.IhC.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.IhC.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "itemStoryFlag";
    locala.IhC.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "readCount";
    locala.IhC.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "favoriteTime";
    locala.IhC.put("favoriteTime", "INTEGER");
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
      if (fkh != k) {
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
      if (eEd == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (eEe == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (fki == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (eEn == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eEo == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (eEi == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fkj == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (fkk == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (fkl == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fkc) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eDH) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.fkd) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eDQ) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.eDR) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.eDL) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fke) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.fkf) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.fkg) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.eh
 * JD-Core Version:    0.7.0.1
 */
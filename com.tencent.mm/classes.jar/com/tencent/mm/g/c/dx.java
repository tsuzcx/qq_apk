package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dx
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS MMStoryInfo_id_Index ON MMStoryInfo(storyID)" };
  private static final int eRK = "storyID".hashCode();
  private static final int eRL;
  private static final int eRM = "itemStoryFlag".hashCode();
  private static final int eRN = "readCount".hashCode();
  private static final int eRO = "favoriteTime".hashCode();
  private static final int emW = "userName".hashCode();
  private static final int emX = "localFlag".hashCode();
  private static final int emY = "createTime".hashCode();
  private static final int enb;
  private static final int eng;
  private static final int enh;
  private static final int eni;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eRF = true;
  private boolean eRG = true;
  private boolean eRH = true;
  private boolean eRI = true;
  private boolean eRJ = true;
  private boolean emA = true;
  private boolean emB = true;
  private boolean emE = true;
  private boolean emI = true;
  private boolean emJ = true;
  private boolean emK = true;
  private boolean emz = true;
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
    eRL = "commentListCount".hashCode();
    eng = "content".hashCode();
    enh = "attrBuf".hashCode();
    eni = "postBuf".hashCode();
    enb = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyID";
    locala.GvH.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.GvH.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.GvH.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.GvH.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "commentListCount";
    locala.GvH.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "content";
    locala.GvH.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "attrBuf";
    locala.GvH.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "postBuf";
    locala.GvH.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.GvH.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "type";
    locala.GvH.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "itemStoryFlag";
    locala.GvH.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "readCount";
    locala.GvH.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "favoriteTime";
    locala.GvH.put("favoriteTime", "INTEGER");
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
      if (eRK != k) {
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
      if (emW == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (emX == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (eRL == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (enh == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eni == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (enb == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eRM == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (eRN == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (eRO == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eRF) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.emA) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.emB) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eRG) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.emJ) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.emK) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.emE) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eRH) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.eRI) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.eRJ) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.dx
 * JD-Core Version:    0.7.0.1
 */
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
  private static final int eFM;
  private static final int eFN;
  private static final int eFO;
  private static final int eFR;
  private static final int eFV;
  private static final int eFW;
  private static final int eFX;
  private static final int fme = "storyID".hashCode();
  private static final int fmf;
  private static final int fmg = "itemStoryFlag".hashCode();
  private static final int fmh = "readCount".hashCode();
  private static final int fmi = "favoriteTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eFA = true;
  private boolean eFp = true;
  private boolean eFq = true;
  private boolean eFr = true;
  private boolean eFu = true;
  private boolean eFy = true;
  private boolean eFz = true;
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
  private boolean flZ = true;
  private boolean fma = true;
  private boolean fmb = true;
  private boolean fmc = true;
  private boolean fmd = true;
  
  static
  {
    eFM = "userName".hashCode();
    eFN = "localFlag".hashCode();
    eFO = "createTime".hashCode();
    fmf = "commentListCount".hashCode();
    eFV = "content".hashCode();
    eFW = "attrBuf".hashCode();
    eFX = "postBuf".hashCode();
    eFR = "sourceType".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyID";
    locala.IBN.put("storyID", "LONG");
    localStringBuilder.append(" storyID LONG");
    localStringBuilder.append(", ");
    locala.columns[1] = "userName";
    locala.IBN.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "localFlag";
    locala.IBN.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "createTime";
    locala.IBN.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "commentListCount";
    locala.IBN.put("commentListCount", "INTEGER");
    localStringBuilder.append(" commentListCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "content";
    locala.IBN.put("content", "BLOB");
    localStringBuilder.append(" content BLOB");
    localStringBuilder.append(", ");
    locala.columns[6] = "attrBuf";
    locala.IBN.put("attrBuf", "BLOB");
    localStringBuilder.append(" attrBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[7] = "postBuf";
    locala.IBN.put("postBuf", "BLOB");
    localStringBuilder.append(" postBuf BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "sourceType";
    locala.IBN.put("sourceType", "INTEGER");
    localStringBuilder.append(" sourceType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[9] = "type";
    locala.IBN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[10] = "itemStoryFlag";
    locala.IBN.put("itemStoryFlag", "INTEGER");
    localStringBuilder.append(" itemStoryFlag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "readCount";
    locala.IBN.put("readCount", "INTEGER");
    localStringBuilder.append(" readCount INTEGER");
    localStringBuilder.append(", ");
    locala.columns[12] = "favoriteTime";
    locala.IBN.put("favoriteTime", "INTEGER");
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
      if (fme != k) {
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
      if (eFM == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (eFN == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (fmf == k) {
        this.field_commentListCount = paramCursor.getInt(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getBlob(i);
      } else if (eFW == k) {
        this.field_attrBuf = paramCursor.getBlob(i);
      } else if (eFX == k) {
        this.field_postBuf = paramCursor.getBlob(i);
      } else if (eFR == k) {
        this.field_sourceType = paramCursor.getInt(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fmg == k) {
        this.field_itemStoryFlag = paramCursor.getInt(i);
      } else if (fmh == k) {
        this.field_readCount = paramCursor.getInt(i);
      } else if (fmi == k) {
        this.field_favoriteTime = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.flZ) {
      localContentValues.put("storyID", Long.valueOf(this.field_storyID));
    }
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.eFq) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.fma) {
      localContentValues.put("commentListCount", Integer.valueOf(this.field_commentListCount));
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eFz) {
      localContentValues.put("attrBuf", this.field_attrBuf);
    }
    if (this.eFA) {
      localContentValues.put("postBuf", this.field_postBuf);
    }
    if (this.eFu) {
      localContentValues.put("sourceType", Integer.valueOf(this.field_sourceType));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fmb) {
      localContentValues.put("itemStoryFlag", Integer.valueOf(this.field_itemStoryFlag));
    }
    if (this.fmc) {
      localContentValues.put("readCount", Integer.valueOf(this.field_readCount));
    }
    if (this.fmd) {
      localContentValues.put("favoriteTime", Integer.valueOf(this.field_favoriteTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.eh
 * JD-Core Version:    0.7.0.1
 */
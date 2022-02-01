package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bz
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)" };
  private static final int eEm;
  private static final int eMk;
  private static final int eVZ;
  private static final int eVj = "localId".hashCode();
  private static final int eWa = "subtype".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eDP = true;
  private boolean eLR = true;
  private boolean eVX = true;
  private boolean eVY = true;
  private boolean eVh = true;
  public String field_content;
  public long field_localId;
  public int field_subtype;
  public String field_tagContent;
  public long field_time;
  public int field_type;
  
  static
  {
    eEm = "content".hashCode();
    eVZ = "tagContent".hashCode();
    eMk = "time".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.IhC.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "localId";
    locala.columns[1] = "content";
    locala.IhC.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "tagContent";
    locala.IhC.put("tagContent", "TEXT");
    localStringBuilder.append(" tagContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "time";
    locala.IhC.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "subtype";
    locala.IhC.put("subtype", "INTEGER default '0' ");
    localStringBuilder.append(" subtype INTEGER default '0' ");
    locala.columns[6] = "rowid";
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eVZ == k) {
        this.field_tagContent = paramCursor.getString(i);
      } else if (eMk == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eWa == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVh) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eVX) {
      localContentValues.put("tagContent", this.field_tagContent);
    }
    if (this.eLR) {
      localContentValues.put("time", Long.valueOf(this.field_time));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eVY) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bz
 * JD-Core Version:    0.7.0.1
 */
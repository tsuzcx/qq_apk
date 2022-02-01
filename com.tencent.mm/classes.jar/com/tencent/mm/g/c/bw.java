package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bw
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)" };
  private static final int eBr = "localId".hashCode();
  private static final int eCh;
  private static final int eCi = "subtype".hashCode();
  private static final int elb = "content".hashCode();
  private static final int esJ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eBp = true;
  private boolean eCf = true;
  private boolean eCg = true;
  private boolean ekE = true;
  private boolean esq = true;
  public String field_content;
  public long field_localId;
  public int field_subtype;
  public String field_tagContent;
  public long field_time;
  public int field_type;
  
  static
  {
    eCh = "tagContent".hashCode();
    esJ = "time".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.EYv.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "localId";
    locala.columns[1] = "content";
    locala.EYv.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "tagContent";
    locala.EYv.put("tagContent", "TEXT");
    localStringBuilder.append(" tagContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "time";
    locala.EYv.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "type";
    locala.EYv.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "subtype";
    locala.EYv.put("subtype", "INTEGER default '0' ");
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
      if (eBr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eCh == k) {
        this.field_tagContent = paramCursor.getString(i);
      } else if (esJ == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eCi == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eBp) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eCf) {
      localContentValues.put("tagContent", this.field_tagContent);
    }
    if (this.esq) {
      localContentValues.put("time", Long.valueOf(this.field_time));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eCg) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bw
 * JD-Core Version:    0.7.0.1
 */
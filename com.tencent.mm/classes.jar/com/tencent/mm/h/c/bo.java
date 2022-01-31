package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bo
  extends c
{
  private static final int cHJ;
  private static final int cIn;
  private static final int cIo = "subtype".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS FavSearchInfo_Content_Index ON FavSearchInfo(content)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_TagContent_Index ON FavSearchInfo(tagContent)", "CREATE INDEX IF NOT EXISTS FavSearchInfo_SubType_Index ON FavSearchInfo(subtype)" };
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int csy;
  private static final int czQ;
  private boolean cHH = true;
  private boolean cIl = true;
  private boolean cIm = true;
  private boolean csa = true;
  private boolean csf = true;
  private boolean czy = true;
  public String field_content;
  public long field_localId;
  public int field_subtype;
  public String field_tagContent;
  public long field_time;
  public int field_type;
  
  static
  {
    cHJ = "localId".hashCode();
    csD = "content".hashCode();
    cIn = "tagContent".hashCode();
    czQ = "time".hashCode();
    csy = "type".hashCode();
  }
  
  public static c.a vg()
  {
    c.a locala = new c.a();
    locala.ujL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localId";
    locala.ujN.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.ujM = "localId";
    locala.columns[1] = "content";
    locala.ujN.put("content", "TEXT");
    localStringBuilder.append(" content TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "tagContent";
    locala.ujN.put("tagContent", "TEXT");
    localStringBuilder.append(" tagContent TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "time";
    locala.ujN.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    locala.columns[4] = "type";
    locala.ujN.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "subtype";
    locala.ujN.put("subtype", "INTEGER default '0' ");
    localStringBuilder.append(" subtype INTEGER default '0' ");
    locala.columns[6] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
  }
  
  public final void d(Cursor paramCursor)
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
      if (cHJ != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.cHH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cIn == k) {
        this.field_tagContent = paramCursor.getString(i);
      } else if (czQ == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (cIo == k) {
        this.field_subtype = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHH) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.cIl) {
      localContentValues.put("tagContent", this.field_tagContent);
    }
    if (this.czy) {
      localContentValues.put("time", Long.valueOf(this.field_time));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cIm) {
      localContentValues.put("subtype", Integer.valueOf(this.field_subtype));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.bo
 * JD-Core Version:    0.7.0.1
 */
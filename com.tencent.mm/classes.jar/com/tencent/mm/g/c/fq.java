package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eYs = "storyId".hashCode();
  private static final int eYt = "readCommentId".hashCode();
  private static final int eYu = "syncCommentId".hashCode();
  private static final int eYv = "readCommentTime".hashCode();
  private static final int eYw = "syncCommentTime".hashCode();
  private static final int eYx = "commentFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eYm = true;
  private boolean eYn = true;
  private boolean eYo = true;
  private boolean eYp = true;
  private boolean eYq = true;
  private boolean eYr = true;
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.EYv.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "storyId";
    locala.columns[1] = "readCommentId";
    locala.EYv.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "syncCommentId";
    locala.EYv.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "readCommentTime";
    locala.EYv.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "syncCommentTime";
    locala.EYv.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "commentFlag";
    locala.EYv.put("commentFlag", "INTEGER");
    localStringBuilder.append(" commentFlag INTEGER");
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
      if (eYs != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.eYm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eYt == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (eYu == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (eYv == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (eYw == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (eYx == k) {
        this.field_commentFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eYm) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.eYn) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.eYo) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.eYp) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.eYq) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.eYr) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fq
 * JD-Core Version:    0.7.0.1
 */
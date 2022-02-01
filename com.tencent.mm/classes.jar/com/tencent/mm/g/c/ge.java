package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ge
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ftU = "storyId".hashCode();
  private static final int ftV = "readCommentId".hashCode();
  private static final int ftW = "syncCommentId".hashCode();
  private static final int ftX = "readCommentTime".hashCode();
  private static final int ftY = "syncCommentTime".hashCode();
  private static final int ftZ = "commentFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  private boolean ftO = true;
  private boolean ftP = true;
  private boolean ftQ = true;
  private boolean ftR = true;
  private boolean ftS = true;
  private boolean ftT = true;
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.IhC.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "storyId";
    locala.columns[1] = "readCommentId";
    locala.IhC.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "syncCommentId";
    locala.IhC.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "readCommentTime";
    locala.IhC.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "syncCommentTime";
    locala.IhC.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "commentFlag";
    locala.IhC.put("commentFlag", "INTEGER");
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
      if (ftU != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.ftO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ftV == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (ftW == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (ftX == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (ftY == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (ftZ == k) {
        this.field_commentFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ftO) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.ftP) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.ftQ) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.ftR) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.ftS) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.ftT) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ge
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class gf
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fvU = "storyId".hashCode();
  private static final int fvV = "readCommentId".hashCode();
  private static final int fvW = "syncCommentId".hashCode();
  private static final int fvX = "readCommentTime".hashCode();
  private static final int fvY = "syncCommentTime".hashCode();
  private static final int fvZ = "commentFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  private boolean fvO = true;
  private boolean fvP = true;
  private boolean fvQ = true;
  private boolean fvR = true;
  private boolean fvS = true;
  private boolean fvT = true;
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.IBN.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "storyId";
    locala.columns[1] = "readCommentId";
    locala.IBN.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "syncCommentId";
    locala.IBN.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "readCommentTime";
    locala.IBN.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "syncCommentTime";
    locala.IBN.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "commentFlag";
    locala.IBN.put("commentFlag", "INTEGER");
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
      if (fvU != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.fvO = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fvV == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (fvW == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (fvX == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (fvY == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (fvZ == k) {
        this.field_commentFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fvO) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.fvP) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.fvQ) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.fvR) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.fvS) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.fvT) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gf
 * JD-Core Version:    0.7.0.1
 */
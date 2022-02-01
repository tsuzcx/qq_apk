package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fbG = "storyId".hashCode();
  private static final int fbH = "readCommentId".hashCode();
  private static final int fbI = "syncCommentId".hashCode();
  private static final int fbJ = "readCommentTime".hashCode();
  private static final int fbK = "syncCommentTime".hashCode();
  private static final int fbL = "commentFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fbA = true;
  private boolean fbB = true;
  private boolean fbC = true;
  private boolean fbD = true;
  private boolean fbE = true;
  private boolean fbF = true;
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.GvH.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "storyId";
    locala.columns[1] = "readCommentId";
    locala.GvH.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "syncCommentId";
    locala.GvH.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "readCommentTime";
    locala.GvH.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "syncCommentTime";
    locala.GvH.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "commentFlag";
    locala.GvH.put("commentFlag", "INTEGER");
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
      if (fbG != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.fbA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fbH == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (fbI == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (fbJ == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (fbK == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (fbL == k) {
        this.field_commentFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fbA) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.fbB) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.fbC) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.fbD) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.fbE) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.fbF) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fu
 * JD-Core Version:    0.7.0.1
 */
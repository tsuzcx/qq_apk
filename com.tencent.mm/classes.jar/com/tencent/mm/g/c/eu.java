package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class eu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dPB = "storyId".hashCode();
  private static final int dPC = "readCommentId".hashCode();
  private static final int dPD = "syncCommentId".hashCode();
  private static final int dPE = "readCommentTime".hashCode();
  private static final int dPF = "syncCommentTime".hashCode();
  private static final int dPG = "commentFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dPA = true;
  private boolean dPv = true;
  private boolean dPw = true;
  private boolean dPx = true;
  private boolean dPy = true;
  private boolean dPz = true;
  public int field_commentFlag;
  public int field_readCommentId;
  public int field_readCommentTime;
  public long field_storyId;
  public int field_syncCommentId;
  public int field_syncCommentTime;
  
  public static c.a Hm()
  {
    c.a locala = new c.a();
    locala.yrK = new Field[6];
    locala.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "storyId";
    locala.yrM.put("storyId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" storyId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "storyId";
    locala.columns[1] = "readCommentId";
    locala.yrM.put("readCommentId", "INTEGER");
    localStringBuilder.append(" readCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[2] = "syncCommentId";
    locala.yrM.put("syncCommentId", "INTEGER");
    localStringBuilder.append(" syncCommentId INTEGER");
    localStringBuilder.append(", ");
    locala.columns[3] = "readCommentTime";
    locala.yrM.put("readCommentTime", "INTEGER");
    localStringBuilder.append(" readCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "syncCommentTime";
    locala.yrM.put("syncCommentTime", "INTEGER");
    localStringBuilder.append(" syncCommentTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "commentFlag";
    locala.yrM.put("commentFlag", "INTEGER");
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
      if (dPB != k) {
        break label65;
      }
      this.field_storyId = paramCursor.getLong(i);
      this.dPv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dPC == k) {
        this.field_readCommentId = paramCursor.getInt(i);
      } else if (dPD == k) {
        this.field_syncCommentId = paramCursor.getInt(i);
      } else if (dPE == k) {
        this.field_readCommentTime = paramCursor.getInt(i);
      } else if (dPF == k) {
        this.field_syncCommentTime = paramCursor.getInt(i);
      } else if (dPG == k) {
        this.field_commentFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dPv) {
      localContentValues.put("storyId", Long.valueOf(this.field_storyId));
    }
    if (this.dPw) {
      localContentValues.put("readCommentId", Integer.valueOf(this.field_readCommentId));
    }
    if (this.dPx) {
      localContentValues.put("syncCommentId", Integer.valueOf(this.field_syncCommentId));
    }
    if (this.dPy) {
      localContentValues.put("readCommentTime", Integer.valueOf(this.field_readCommentTime));
    }
    if (this.dPz) {
      localContentValues.put("syncCommentTime", Integer.valueOf(this.field_syncCommentTime));
    }
    if (this.dPA) {
      localContentValues.put("commentFlag", Integer.valueOf(this.field_commentFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.eu
 * JD-Core Version:    0.7.0.1
 */
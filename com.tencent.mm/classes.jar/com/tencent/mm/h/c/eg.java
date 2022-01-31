package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eg
  extends c
{
  private static final int cEY = "count".hashCode();
  private static final int cYY;
  private static final int cYZ;
  private static final int cZa = "memberList".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private boolean cEy = true;
  private boolean cYV = true;
  private boolean cYW = true;
  private boolean cYX = true;
  public int field_count;
  public String field_memberList;
  public long field_tagId;
  public String field_tagName;
  
  static
  {
    cYY = "tagId".hashCode();
    cYZ = "tagName".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (cYY != k) {
        break label60;
      }
      this.field_tagId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cYZ == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (cEY == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (cZa == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cYV) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.cYW) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.cEy) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.cYX) {
      localContentValues.put("memberList", this.field_memberList);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.eg
 * JD-Core Version:    0.7.0.1
 */
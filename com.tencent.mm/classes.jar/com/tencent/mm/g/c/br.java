package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class br
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjx;
  private static final int fjy;
  private static final int fyq;
  private static final int fzu = "exptId".hashCode();
  private static final int fzv;
  private static final int fzw;
  private static final int fzx;
  private static final int fzy = "exptCheckSum".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int subType_HASHCODE;
  private boolean __hadSetsubType = true;
  public long field_endTime;
  public String field_exptCheckSum;
  public String field_exptContent;
  public int field_exptId;
  public int field_exptSeq;
  public int field_exptType;
  public int field_groupId;
  public long field_startTime;
  public int field_subType;
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean fxE = true;
  private boolean fzp = true;
  private boolean fzq = true;
  private boolean fzr = true;
  private boolean fzs = true;
  private boolean fzt = true;
  
  static
  {
    fyq = "groupId".hashCode();
    fzv = "exptSeq".hashCode();
    fzw = "exptContent".hashCode();
    fjx = "startTime".hashCode();
    fjy = "endTime".hashCode();
    fzx = "exptType".hashCode();
    subType_HASHCODE = "subType".hashCode();
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
      if (fzu != k) {
        break label65;
      }
      this.field_exptId = paramCursor.getInt(i);
      this.fzp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyq == k) {
        this.field_groupId = paramCursor.getInt(i);
      } else if (fzv == k) {
        this.field_exptSeq = paramCursor.getInt(i);
      } else if (fzw == k) {
        this.field_exptContent = paramCursor.getString(i);
      } else if (fjx == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (fjy == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (fzx == k) {
        this.field_exptType = paramCursor.getInt(i);
      } else if (subType_HASHCODE == k) {
        this.field_subType = paramCursor.getInt(i);
      } else if (fzy == k) {
        this.field_exptCheckSum = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fzp) {
      localContentValues.put("exptId", Integer.valueOf(this.field_exptId));
    }
    if (this.fxE) {
      localContentValues.put("groupId", Integer.valueOf(this.field_groupId));
    }
    if (this.fzq) {
      localContentValues.put("exptSeq", Integer.valueOf(this.field_exptSeq));
    }
    if (this.fzr) {
      localContentValues.put("exptContent", this.field_exptContent);
    }
    if (this.fjq) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.fjr) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
    }
    if (this.fzs) {
      localContentValues.put("exptType", Integer.valueOf(this.field_exptType));
    }
    if (this.__hadSetsubType) {
      localContentValues.put("subType", Integer.valueOf(this.field_subType));
    }
    if (this.fzt) {
      localContentValues.put("exptCheckSum", this.field_exptCheckSum);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.br
 * JD-Core Version:    0.7.0.1
 */
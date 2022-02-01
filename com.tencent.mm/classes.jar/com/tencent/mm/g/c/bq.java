package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bq
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fmm = "modifyTime".hashCode();
  private static final int fni;
  private static final int fzk = "prodcutID".hashCode();
  private static final int fzl = "totalCount".hashCode();
  private static final int fzm = "continuCount".hashCode();
  private static final int fzn = "showTipsTime".hashCode();
  private static final int fzo = "setFlagTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_continuCount;
  public int field_flag;
  public long field_modifyTime;
  public String field_prodcutID;
  public long field_setFlagTime;
  public long field_showTipsTime;
  public int field_totalCount;
  private boolean flQ = true;
  private boolean fng = true;
  private boolean fzf = true;
  private boolean fzg = true;
  private boolean fzh = true;
  private boolean fzi = true;
  private boolean fzj = true;
  
  static
  {
    fni = "flag".hashCode();
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
      if (fzk != k) {
        break label65;
      }
      this.field_prodcutID = paramCursor.getString(i);
      this.fzf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fzl == k) {
        this.field_totalCount = paramCursor.getInt(i);
      } else if (fzm == k) {
        this.field_continuCount = paramCursor.getInt(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (fmm == k) {
        this.field_modifyTime = paramCursor.getLong(i);
      } else if (fzn == k) {
        this.field_showTipsTime = paramCursor.getLong(i);
      } else if (fzo == k) {
        this.field_setFlagTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fzf) {
      localContentValues.put("prodcutID", this.field_prodcutID);
    }
    if (this.fzg) {
      localContentValues.put("totalCount", Integer.valueOf(this.field_totalCount));
    }
    if (this.fzh) {
      localContentValues.put("continuCount", Integer.valueOf(this.field_continuCount));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.flQ) {
      localContentValues.put("modifyTime", Long.valueOf(this.field_modifyTime));
    }
    if (this.fzi) {
      localContentValues.put("showTipsTime", Long.valueOf(this.field_showTipsTime));
    }
    if (this.fzj) {
      localContentValues.put("setFlagTime", Long.valueOf(this.field_setFlagTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.bq
 * JD-Core Version:    0.7.0.1
 */
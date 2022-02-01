package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cb
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fBA;
  private static final int fBB;
  private static final int fBC;
  private static final int fBD;
  private static final int fBE = "helpUrl".hashCode();
  private static final int fBF = "updateUrl".hashCode();
  private static final int fBG = "androidUrl".hashCode();
  private static final int fBH = "iconPath".hashCode();
  private static final int fBI = "timestamp".hashCode();
  private static final int fBz = "featureId".hashCode();
  private static final int fnB;
  private static final int fne = "title".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fBp = true;
  private boolean fBq = true;
  private boolean fBr = true;
  private boolean fBs = true;
  private boolean fBt = true;
  private boolean fBu = true;
  private boolean fBv = true;
  private boolean fBw = true;
  private boolean fBx = true;
  private boolean fBy = true;
  public int field_actionType;
  public String field_androidUrl;
  public int field_featureId;
  public String field_helpUrl;
  public String field_iconPath;
  public String field_tag;
  public long field_timestamp;
  public String field_title;
  public String field_titlePY;
  public String field_titleShortPY;
  public String field_updateUrl;
  public String field_url;
  private boolean fnb = true;
  private boolean fnx = true;
  
  static
  {
    fBA = "titlePY".hashCode();
    fBB = "titleShortPY".hashCode();
    fBC = "tag".hashCode();
    fBD = "actionType".hashCode();
    fnB = "url".hashCode();
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
      if (fBz != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.fBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fBA == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (fBB == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (fBC == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (fBD == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (fnB == k) {
        this.field_url = paramCursor.getString(i);
      } else if (fBE == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (fBF == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (fBG == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (fBH == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (fBI == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fBp) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fBq) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.fBr) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.fBs) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.fBt) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fBu) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.fBv) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.fBw) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.fBx) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.fBy) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cb
 * JD-Core Version:    0.7.0.1
 */
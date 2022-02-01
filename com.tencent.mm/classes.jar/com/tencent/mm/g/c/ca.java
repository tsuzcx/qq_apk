package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ca
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHT;
  private static final int eIm = "url".hashCode();
  private static final int eWl = "featureId".hashCode();
  private static final int eWm;
  private static final int eWn;
  private static final int eWo;
  private static final int eWp;
  private static final int eWq = "helpUrl".hashCode();
  private static final int eWr = "updateUrl".hashCode();
  private static final int eWs = "androidUrl".hashCode();
  private static final int eWt = "iconPath".hashCode();
  private static final int eWu = "timestamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHQ = true;
  private boolean eIi = true;
  private boolean eWb = true;
  private boolean eWc = true;
  private boolean eWd = true;
  private boolean eWe = true;
  private boolean eWf = true;
  private boolean eWg = true;
  private boolean eWh = true;
  private boolean eWi = true;
  private boolean eWj = true;
  private boolean eWk = true;
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
  
  static
  {
    eHT = "title".hashCode();
    eWm = "titlePY".hashCode();
    eWn = "titleShortPY".hashCode();
    eWo = "tag".hashCode();
    eWp = "actionType".hashCode();
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
      if (eWl != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.eWb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eWm == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (eWn == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (eWo == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (eWp == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eIm == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eWq == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (eWr == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (eWs == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (eWt == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (eWu == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWb) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eWc) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.eWd) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.eWe) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.eWf) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eIi) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eWg) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.eWh) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.eWi) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.eWj) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.eWk) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ca
 * JD-Core Version:    0.7.0.1
 */
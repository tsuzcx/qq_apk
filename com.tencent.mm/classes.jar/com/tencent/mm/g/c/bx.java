package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCA = "androidUrl".hashCode();
  private static final int eCB = "iconPath".hashCode();
  private static final int eCC = "timestamp".hashCode();
  private static final int eCt = "featureId".hashCode();
  private static final int eCu;
  private static final int eCv;
  private static final int eCw;
  private static final int eCx;
  private static final int eCy;
  private static final int eCz;
  private static final int eoG = "title".hashCode();
  private static final int eoZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCj = true;
  private boolean eCk = true;
  private boolean eCl = true;
  private boolean eCm = true;
  private boolean eCn = true;
  private boolean eCo = true;
  private boolean eCp = true;
  private boolean eCq = true;
  private boolean eCr = true;
  private boolean eCs = true;
  private boolean eoD = true;
  private boolean eoV = true;
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
    eCu = "titlePY".hashCode();
    eCv = "titleShortPY".hashCode();
    eCw = "tag".hashCode();
    eCx = "actionType".hashCode();
    eoZ = "url".hashCode();
    eCy = "helpUrl".hashCode();
    eCz = "updateUrl".hashCode();
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
      if (eCt != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.eCj = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eCu == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (eCv == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (eCw == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (eCx == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eoZ == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eCy == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (eCz == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (eCA == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (eCB == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (eCC == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCj) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eCk) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.eCl) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.eCm) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.eCn) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eCo) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.eCp) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.eCq) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.eCr) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.eCs) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.bx
 * JD-Core Version:    0.7.0.1
 */
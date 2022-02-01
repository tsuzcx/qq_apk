package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEN = "featureId".hashCode();
  private static final int eEO;
  private static final int eEP;
  private static final int eEQ;
  private static final int eER;
  private static final int eES = "helpUrl".hashCode();
  private static final int eET = "updateUrl".hashCode();
  private static final int eEU = "androidUrl".hashCode();
  private static final int eEV = "iconPath".hashCode();
  private static final int eEW = "timestamp".hashCode();
  private static final int eqK = "title".hashCode();
  private static final int erd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eEE = true;
  private boolean eEF = true;
  private boolean eEG = true;
  private boolean eEH = true;
  private boolean eEI = true;
  private boolean eEJ = true;
  private boolean eEK = true;
  private boolean eEL = true;
  private boolean eEM = true;
  private boolean eqH = true;
  private boolean eqZ = true;
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
    eEO = "titlePY".hashCode();
    eEP = "titleShortPY".hashCode();
    eEQ = "tag".hashCode();
    eER = "actionType".hashCode();
    erd = "url".hashCode();
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
      if (eEN != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.eED = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eEO == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (eEP == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (eEQ == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (eER == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (erd == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eES == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (eET == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (eEU == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (eEV == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (eEW == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eEE) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.eEF) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.eEG) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.eEH) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eEI) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.eEJ) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.eEK) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.eEL) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.eEM) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bz
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ca
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJC;
  private static final int eJV = "url".hashCode();
  private static final int eXW = "featureId".hashCode();
  private static final int eXX;
  private static final int eXY;
  private static final int eXZ;
  private static final int eYa;
  private static final int eYb = "helpUrl".hashCode();
  private static final int eYc = "updateUrl".hashCode();
  private static final int eYd = "androidUrl".hashCode();
  private static final int eYe = "iconPath".hashCode();
  private static final int eYf = "timestamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJR = true;
  private boolean eJz = true;
  private boolean eXM = true;
  private boolean eXN = true;
  private boolean eXO = true;
  private boolean eXP = true;
  private boolean eXQ = true;
  private boolean eXR = true;
  private boolean eXS = true;
  private boolean eXT = true;
  private boolean eXU = true;
  private boolean eXV = true;
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
    eJC = "title".hashCode();
    eXX = "titlePY".hashCode();
    eXY = "titleShortPY".hashCode();
    eXZ = "tag".hashCode();
    eYa = "actionType".hashCode();
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
      if (eXW != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.eXM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eXX == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (eXY == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (eXZ == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (eYa == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eJV == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eYb == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (eYc == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (eYd == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (eYe == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (eYf == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eXM) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eXN) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.eXO) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.eXP) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.eXQ) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eXR) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.eXS) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.eXT) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.eXU) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.eXV) {
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
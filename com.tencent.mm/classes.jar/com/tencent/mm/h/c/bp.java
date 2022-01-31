package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bp
  extends c
{
  private static final int cIA;
  private static final int cIB;
  private static final int cIC;
  private static final int cID;
  private static final int cIE = "helpUrl".hashCode();
  private static final int cIF = "updateUrl".hashCode();
  private static final int cIG = "androidUrl".hashCode();
  private static final int cIH = "iconPath".hashCode();
  private static final int cII = "timestamp".hashCode();
  private static final int cIz;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cvZ;
  private static final int cwu;
  private boolean cIp = true;
  private boolean cIq = true;
  private boolean cIr = true;
  private boolean cIs = true;
  private boolean cIt = true;
  private boolean cIu = true;
  private boolean cIv = true;
  private boolean cIw = true;
  private boolean cIx = true;
  private boolean cIy = true;
  private boolean cvV = true;
  private boolean cwp = true;
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
    cIz = "featureId".hashCode();
    cvZ = "title".hashCode();
    cIA = "titlePY".hashCode();
    cIB = "titleShortPY".hashCode();
    cIC = "tag".hashCode();
    cID = "actionType".hashCode();
    cwu = "url".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cIz != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.cIp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (cIA == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (cIB == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (cIC == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (cID == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (cwu == k) {
        this.field_url = paramCursor.getString(i);
      } else if (cIE == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (cIF == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (cIG == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (cIH == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (cII == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cIp) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cIq) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.cIr) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.cIs) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.cIt) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.cIu) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.cIv) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.cIw) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.cIx) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.cIy) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.bp
 * JD-Core Version:    0.7.0.1
 */
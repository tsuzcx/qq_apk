package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class br
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkC = "url".hashCode();
  private static final int dkj;
  private static final int dxj = "featureId".hashCode();
  private static final int dxk;
  private static final int dxl;
  private static final int dxm;
  private static final int dxn;
  private static final int dxo = "helpUrl".hashCode();
  private static final int dxp = "updateUrl".hashCode();
  private static final int dxq = "androidUrl".hashCode();
  private static final int dxr = "iconPath".hashCode();
  private static final int dxs = "timestamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dkg = true;
  private boolean dky = true;
  private boolean dwZ = true;
  private boolean dxa = true;
  private boolean dxb = true;
  private boolean dxc = true;
  private boolean dxd = true;
  private boolean dxe = true;
  private boolean dxf = true;
  private boolean dxg = true;
  private boolean dxh = true;
  private boolean dxi = true;
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
    dkj = "title".hashCode();
    dxk = "titlePY".hashCode();
    dxl = "titleShortPY".hashCode();
    dxm = "tag".hashCode();
    dxn = "actionType".hashCode();
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
      if (dxj != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.dwZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (dxk == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (dxl == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (dxm == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (dxn == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (dkC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (dxo == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (dxp == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (dxq == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (dxr == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (dxs == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwZ) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.dxa) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.dxb) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.dxc) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.dxd) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.dky) {
      localContentValues.put("url", this.field_url);
    }
    if (this.dxe) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.dxf) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.dxg) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.dxh) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.dxi) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.br
 * JD-Core Version:    0.7.0.1
 */
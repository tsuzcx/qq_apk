package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class cb
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("Feature");
  public static final Column hMQ;
  public static final Column hMR;
  public static final Column hMS;
  public static final Column hMT;
  public static final Column hMU;
  public static final Column hMV;
  public static final Column hMW;
  public static final Column hMX;
  public static final Column hMY;
  public static final Column hMZ;
  private static final int hNk;
  private static final int hNl;
  private static final int hNm;
  private static final int hNn;
  private static final int hNo;
  private static final int hNp = "helpUrl".hashCode();
  private static final int hNq = "updateUrl".hashCode();
  private static final int hNr = "androidUrl".hashCode();
  private static final int hNs = "iconPath".hashCode();
  private static final int hNt = "timestamp".hashCode();
  public static final Column hsH;
  private static final int hsP;
  public static final Column hsa;
  private static final int hsg;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hNa = true;
  private boolean hNb = true;
  private boolean hNc = true;
  private boolean hNd = true;
  private boolean hNe = true;
  private boolean hNf = true;
  private boolean hNg = true;
  private boolean hNh = true;
  private boolean hNi = true;
  private boolean hNj = true;
  private boolean hsL = true;
  private boolean hsd = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "Feature", "");
    hMQ = new Column("featureid", "int", "Feature", "");
    hsa = new Column("title", "string", "Feature", "");
    hMR = new Column("titlepy", "string", "Feature", "");
    hMS = new Column("titleshortpy", "string", "Feature", "");
    hMT = new Column("tag", "string", "Feature", "");
    hMU = new Column("actiontype", "int", "Feature", "");
    hsH = new Column("url", "string", "Feature", "");
    hMV = new Column("helpurl", "string", "Feature", "");
    hMW = new Column("updateurl", "string", "Feature", "");
    hMX = new Column("androidurl", "string", "Feature", "");
    hMY = new Column("iconpath", "string", "Feature", "");
    hMZ = new Column("timestamp", "long", "Feature", "");
    hNk = "featureId".hashCode();
    hsg = "title".hashCode();
    hNl = "titlePY".hashCode();
    hNm = "titleShortPY".hashCode();
    hNn = "tag".hashCode();
    hNo = "actionType".hashCode();
    hsP = "url".hashCode();
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
      if (hNk != k) {
        break label65;
      }
      this.field_featureId = paramCursor.getInt(i);
      this.hNa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (hNl == k) {
        this.field_titlePY = paramCursor.getString(i);
      } else if (hNm == k) {
        this.field_titleShortPY = paramCursor.getString(i);
      } else if (hNn == k) {
        this.field_tag = paramCursor.getString(i);
      } else if (hNo == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (hsP == k) {
        this.field_url = paramCursor.getString(i);
      } else if (hNp == k) {
        this.field_helpUrl = paramCursor.getString(i);
      } else if (hNq == k) {
        this.field_updateUrl = paramCursor.getString(i);
      } else if (hNr == k) {
        this.field_androidUrl = paramCursor.getString(i);
      } else if (hNs == k) {
        this.field_iconPath = paramCursor.getString(i);
      } else if (hNt == k) {
        this.field_timestamp = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hNa) {
      localContentValues.put("featureId", Integer.valueOf(this.field_featureId));
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hNb) {
      localContentValues.put("titlePY", this.field_titlePY);
    }
    if (this.hNc) {
      localContentValues.put("titleShortPY", this.field_titleShortPY);
    }
    if (this.hNd) {
      localContentValues.put("tag", this.field_tag);
    }
    if (this.hNe) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hNf) {
      localContentValues.put("helpUrl", this.field_helpUrl);
    }
    if (this.hNg) {
      localContentValues.put("updateUrl", this.field_updateUrl);
    }
    if (this.hNh) {
      localContentValues.put("androidUrl", this.field_androidUrl);
    }
    if (this.hNi) {
      localContentValues.put("iconPath", this.field_iconPath);
    }
    if (this.hNj) {
      localContentValues.put("timestamp", Long.valueOf(this.field_timestamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "Feature";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.cb
 * JD-Core Version:    0.7.0.1
 */
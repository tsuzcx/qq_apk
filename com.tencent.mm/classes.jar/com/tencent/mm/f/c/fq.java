package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PluginDevLaunchInfo");
  public static final Column hnz;
  private static final int hoh = "appId".hashCode();
  public static final Column ire;
  public static final Column irf;
  private static final int iri = "versionDesc".hashCode();
  private static final int irj = "devKey".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_appId;
  public long field_devKey;
  public String field_versionDesc;
  private boolean hnQ = true;
  private boolean irg = true;
  private boolean irh = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PluginDevLaunchInfo", "");
    hnz = new Column("appid", "string", "PluginDevLaunchInfo", "");
    ire = new Column("versiondesc", "string", "PluginDevLaunchInfo", "");
    irf = new Column("devkey", "long", "PluginDevLaunchInfo", "");
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (iri == k) {
        this.field_versionDesc = paramCursor.getString(i);
      } else if (irj == k) {
        this.field_devKey = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.irg) {
      localContentValues.put("versionDesc", this.field_versionDesc);
    }
    if (this.irh) {
      localContentValues.put("devKey", Long.valueOf(this.field_devKey));
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
    return "PluginDevLaunchInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fq
 * JD-Core Version:    0.7.0.1
 */
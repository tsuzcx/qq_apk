package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fo
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PkgUsageLRURecord");
  public static final Column hnz;
  private static final int hoh;
  public static final Column iqY;
  public static final Column iqZ;
  private static final int irc = "hit".hashCode();
  private static final int ird = "hitTimeMS".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_appId;
  public int field_hit;
  public long field_hitTimeMS;
  public int field_type;
  private boolean hnQ = true;
  private boolean ira = true;
  private boolean irb = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PkgUsageLRURecord", "");
    hnz = new Column("appid", "string", "PkgUsageLRURecord", "");
    C_TYPE = new Column("type", "int", "PkgUsageLRURecord", "");
    iqY = new Column("hit", "int", "PkgUsageLRURecord", "");
    iqZ = new Column("hittimems", "long", "PkgUsageLRURecord", "");
    hoh = "appId".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (irc == k) {
        this.field_hit = paramCursor.getInt(i);
      } else if (ird == k) {
        this.field_hitTimeMS = paramCursor.getLong(i);
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
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ira) {
      localContentValues.put("hit", Integer.valueOf(this.field_hit));
    }
    if (this.irb) {
      localContentValues.put("hitTimeMS", Long.valueOf(this.field_hitTimeMS));
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
    return "PkgUsageLRURecord";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.fo
 * JD-Core Version:    0.7.0.1
 */
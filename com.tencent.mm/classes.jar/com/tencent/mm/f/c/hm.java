package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hm
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "WalletBulletin", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletBulletin");
  public static final Column iFX = new Column("bulletin_scene", "string", "WalletBulletin", "");
  public static final Column iFY = new Column("bulletin_content", "string", "WalletBulletin", "");
  public static final Column iFZ = new Column("bulletin_url", "string", "WalletBulletin", "");
  private static final int iGd = "bulletin_scene".hashCode();
  private static final int iGe = "bulletin_content".hashCode();
  private static final int iGf = "bulletin_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_bulletin_content;
  public String field_bulletin_scene;
  public String field_bulletin_url;
  private boolean iGa = true;
  private boolean iGb = true;
  private boolean iGc = true;
  
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
      if (iGd != k) {
        break label65;
      }
      this.field_bulletin_scene = paramCursor.getString(i);
      this.iGa = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iGe == k) {
        this.field_bulletin_content = paramCursor.getString(i);
      } else if (iGf == k) {
        this.field_bulletin_url = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iGa) {
      localContentValues.put("bulletin_scene", this.field_bulletin_scene);
    }
    if (this.iGb) {
      localContentValues.put("bulletin_content", this.field_bulletin_content);
    }
    if (this.iGc) {
      localContentValues.put("bulletin_url", this.field_bulletin_url);
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
    return "WalletBulletin";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.f.c.hm
 * JD-Core Version:    0.7.0.1
 */
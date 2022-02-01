package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ae
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizAdInfo");
  public static final Column hml;
  private static final int hmt = "msgId".hashCode();
  public static final Column hsA;
  public static final Column hsB;
  private static final int hsE;
  private static final int hsF = "exposeTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_aId;
  public long field_exposeTime;
  public long field_msgId;
  private boolean hmp = true;
  private boolean hsC = true;
  private boolean hsD = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BizAdInfo", "");
    hsA = new Column("aid", "string", "BizAdInfo", "");
    hml = new Column("msgid", "long", "BizAdInfo", "");
    hsB = new Column("exposetime", "long", "BizAdInfo", "");
    hsE = "aId".hashCode();
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
      if (hsE != k) {
        break label65;
      }
      this.field_aId = paramCursor.getString(i);
      this.hsC = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmt == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (hsF == k) {
        this.field_exposeTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hsC) {
      localContentValues.put("aId", this.field_aId);
    }
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.hsD) {
      localContentValues.put("exposeTime", Long.valueOf(this.field_exposeTime));
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
    return "BizAdInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ae
 * JD-Core Version:    0.7.0.1
 */
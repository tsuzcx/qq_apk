package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ad
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BackupTempMoveTime");
  public static final Column hmH;
  public static final Column hmI;
  private static final int hmV = "startTime".hashCode();
  private static final int hmW = "endTime".hashCode();
  public static final Column hsp;
  private static final int hsv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_endTime;
  public String field_sessionName;
  public long field_startTime;
  private boolean hmO = true;
  private boolean hmP = true;
  private boolean hss = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BackupTempMoveTime", "");
    hsp = new Column("sessionname", "string", "BackupTempMoveTime", "");
    hmH = new Column("starttime", "long", "BackupTempMoveTime", "");
    hmI = new Column("endtime", "long", "BackupTempMoveTime", "");
    hsv = "sessionName".hashCode();
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
      if (hsv != k) {
        break label60;
      }
      this.field_sessionName = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hmV == k) {
        this.field_startTime = paramCursor.getLong(i);
      } else if (hmW == k) {
        this.field_endTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.hss) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if (this.hmO) {
      localContentValues.put("startTime", Long.valueOf(this.field_startTime));
    }
    if (this.hmP) {
      localContentValues.put("endTime", Long.valueOf(this.field_endTime));
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
    return "BackupTempMoveTime";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ad
 * JD-Core Version:    0.7.0.1
 */
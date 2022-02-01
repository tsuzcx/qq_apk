package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ac
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BackupRecoverMsgListDataId");
  public static final Column hsp;
  private static final int hsv = "sessionName".hashCode();
  public static final Column hsx;
  private static final int hsz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_msgListDataId;
  public String field_sessionName;
  private boolean hss = true;
  private boolean hsy = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "BackupRecoverMsgListDataId", "");
    hsx = new Column("msglistdataid", "string", "BackupRecoverMsgListDataId", "");
    hsp = new Column("sessionname", "string", "BackupRecoverMsgListDataId", "");
    hsz = "msgListDataId".hashCode();
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
      if (hsz != k) {
        break label65;
      }
      this.field_msgListDataId = paramCursor.getString(i);
      this.hsy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hsv == k) {
        this.field_sessionName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hsy) {
      localContentValues.put("msgListDataId", this.field_msgListDataId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.hss) {
      localContentValues.put("sessionName", this.field_sessionName);
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
    return "BackupRecoverMsgListDataId";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.ac
 * JD-Core Version:    0.7.0.1
 */
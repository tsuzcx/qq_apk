package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gv
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SnsWsFoldGroupDetail");
  public static final Column hHh;
  private static final int hIJ = "groupId".hashCode();
  public static final Column izP;
  public static final Column izQ;
  private static final int izT = "groupTime".hashCode();
  private static final int izU = "groupStrcut".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public long field_groupId;
  public byte[] field_groupStrcut;
  public int field_groupTime;
  private boolean hHV = true;
  private boolean izR = true;
  private boolean izS = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsWsFoldGroupDetail", "");
    hHh = new Column("groupid", "long", "SnsWsFoldGroupDetail", "");
    izP = new Column("grouptime", "int", "SnsWsFoldGroupDetail", "");
    izQ = new Column("groupstrcut", "byte[]", "SnsWsFoldGroupDetail", "");
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
      if (hIJ != k) {
        break label65;
      }
      this.field_groupId = paramCursor.getLong(i);
      this.hHV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (izT == k) {
        this.field_groupTime = paramCursor.getInt(i);
      } else if (izU == k) {
        this.field_groupStrcut = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hHV) {
      localContentValues.put("groupId", Long.valueOf(this.field_groupId));
    }
    if (this.izR) {
      localContentValues.put("groupTime", Integer.valueOf(this.field_groupTime));
    }
    if (this.izS) {
      localContentValues.put("groupStrcut", this.field_groupStrcut);
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
    return "SnsWsFoldGroupDetail";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.gv
 * JD-Core Version:    0.7.0.1
 */
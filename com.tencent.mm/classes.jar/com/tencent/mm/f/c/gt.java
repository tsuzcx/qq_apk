package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gt
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SnsTagInfo");
  public static final Column hFV;
  private static final int hGV = "count".hashCode();
  public static final Column hzZ;
  public static final Column izB;
  public static final Column izC;
  private static final int izG;
  private static final int izH;
  private static final int izI = "memberList".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_count;
  public String field_memberList;
  public long field_tagId;
  public String field_tagName;
  private boolean hGv = true;
  private boolean izD = true;
  private boolean izE = true;
  private boolean izF = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsTagInfo", "");
    izB = new Column("tagid", "long", "SnsTagInfo", "");
    izC = new Column("tagname", "string", "SnsTagInfo", "");
    hFV = new Column("count", "int", "SnsTagInfo", "");
    hzZ = new Column("memberlist", "string", "SnsTagInfo", "");
    izG = "tagId".hashCode();
    izH = "tagName".hashCode();
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
      if (izG != k) {
        break label60;
      }
      this.field_tagId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (izH == k) {
        this.field_tagName = paramCursor.getString(i);
      } else if (hGV == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (izI == k) {
        this.field_memberList = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.izD) {
      localContentValues.put("tagId", Long.valueOf(this.field_tagId));
    }
    if (this.field_tagName == null) {
      this.field_tagName = "";
    }
    if (this.izE) {
      localContentValues.put("tagName", this.field_tagName);
    }
    if (this.hGv) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
    }
    if (this.field_memberList == null) {
      this.field_memberList = "";
    }
    if (this.izF) {
      localContentValues.put("memberList", this.field_memberList);
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
    return "SnsTagInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.gt
 * JD-Core Version:    0.7.0.1
 */
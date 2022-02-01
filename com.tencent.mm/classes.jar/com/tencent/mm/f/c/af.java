package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class af
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "BizAppMsgReportContext", "");
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("BizAppMsgReportContext");
  public static final Column hsG = new Column("appmsgreportcontextid", "long", "BizAppMsgReportContext", "");
  public static final Column hsH = new Column("url", "string", "BizAppMsgReportContext", "");
  public static final Column hsI = new Column("reporttime", "long", "BizAppMsgReportContext", "");
  public static final Column hsJ = new Column("ascene", "int", "BizAppMsgReportContext", "");
  private static final int hsO = "appMsgReportContextId".hashCode();
  private static final int hsP = "url".hashCode();
  private static final int hsQ = "reportTime".hashCode();
  private static final int hsR = "aScene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_aScene;
  public long field_appMsgReportContextId;
  public long field_reportTime;
  public String field_url;
  private boolean hsK = true;
  private boolean hsL = true;
  private boolean hsM = true;
  private boolean hsN = true;
  
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
      if (hsO != k) {
        break label65;
      }
      this.field_appMsgReportContextId = paramCursor.getLong(i);
      this.hsK = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hsP == k) {
        this.field_url = paramCursor.getString(i);
      } else if (hsQ == k) {
        this.field_reportTime = paramCursor.getLong(i);
      } else if (hsR == k) {
        this.field_aScene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hsK) {
      localContentValues.put("appMsgReportContextId", Long.valueOf(this.field_appMsgReportContextId));
    }
    if (this.hsL) {
      localContentValues.put("url", this.field_url);
    }
    if (this.hsM) {
      localContentValues.put("reportTime", Long.valueOf(this.field_reportTime));
    }
    if (this.hsN) {
      localContentValues.put("aScene", Integer.valueOf(this.field_aScene));
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
    return "BizAppMsgReportContext";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.af
 * JD-Core Version:    0.7.0.1
 */
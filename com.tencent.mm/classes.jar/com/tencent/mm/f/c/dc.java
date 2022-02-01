package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dc
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameLifeAppMessage");
  public static final Column hml;
  private static final int hmt;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hqa;
  private static final int hqk;
  public static final Column hrZ;
  public static final Column hsa;
  public static final Column hsb;
  private static final int hsf;
  private static final int hsg;
  private static final int hsh;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  private boolean hmp = true;
  private boolean hnQ = true;
  private boolean hqf = true;
  private boolean hsc = true;
  private boolean hsd = true;
  private boolean hse = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameLifeAppMessage", "");
    hml = new Column("msgid", "long", "GameLifeAppMessage", "");
    hrZ = new Column("xml", "string", "GameLifeAppMessage", "");
    hnz = new Column("appid", "string", "GameLifeAppMessage", "");
    hsa = new Column("title", "string", "GameLifeAppMessage", "");
    hsb = new Column("description", "string", "GameLifeAppMessage", "");
    hqa = new Column("source", "string", "GameLifeAppMessage", "");
    C_TYPE = new Column("type", "int", "GameLifeAppMessage", "");
    hmt = "msgId".hashCode();
    hsf = "xml".hashCode();
    hoh = "appId".hashCode();
    hsg = "title".hashCode();
    hsh = "description".hashCode();
    hqk = "source".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "msgId";
    localMAutoDBInfo.colsMap.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "msgId";
    localMAutoDBInfo.columns[1] = "xml";
    localMAutoDBInfo.colsMap.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "description";
    localMAutoDBInfo.colsMap.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "source";
    localMAutoDBInfo.colsMap.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hmt != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.hmp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hsf == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (hoh == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (hsh == k) {
        this.field_description = paramCursor.getString(i);
      } else if (hqk == k) {
        this.field_source = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.hsc) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hse) {
      localContentValues.put("description", this.field_description);
    }
    if (this.hqf) {
      localContentValues.put("source", this.field_source);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
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
    return "GameLifeAppMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.dc
 * JD-Core Version:    0.7.0.1
 */
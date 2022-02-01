package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cy
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fjf = "msgId".hashCode();
  private static final int fkj;
  private static final int flH;
  private static final int fnd = "xml".hashCode();
  private static final int fne;
  private static final int fnf;
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
  private boolean fjS = true;
  private boolean fjb = true;
  private boolean flC = true;
  private boolean fna = true;
  private boolean fnb = true;
  private boolean fnc = true;
  
  static
  {
    fkj = "appId".hashCode();
    fne = "title".hashCode();
    fnf = "description".hashCode();
    flH = "source".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fjf != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.fjb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fnd == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (fkj == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fnf == k) {
        this.field_description = paramCursor.getString(i);
      } else if (flH == k) {
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
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fna) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fnc) {
      localContentValues.put("description", this.field_description);
    }
    if (this.flC) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cy
 * JD-Core Version:    0.7.0.1
 */
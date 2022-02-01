package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ct
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eEU;
  private static final int eGw;
  private static final int eHS = "xml".hashCode();
  private static final int eHT;
  private static final int eHU;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCS = true;
  private boolean eED = true;
  private boolean eGr = true;
  private boolean eHP = true;
  private boolean eHQ = true;
  private boolean eHR = true;
  public String field_appId;
  public String field_description;
  public long field_msgId;
  public String field_source;
  public String field_title;
  public int field_type;
  public String field_xml;
  
  static
  {
    eEU = "appId".hashCode();
    eHT = "title".hashCode();
    eHU = "description".hashCode();
    eGw = "source".hashCode();
    type_HASHCODE = "type".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[7];
    locala.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "msgId";
    locala.IhC.put("msgId", "LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(" msgId LONG default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "msgId";
    locala.columns[1] = "xml";
    locala.IhC.put("xml", "TEXT");
    localStringBuilder.append(" xml TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "appId";
    locala.IhC.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "title";
    locala.IhC.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "description";
    locala.IhC.put("description", "TEXT");
    localStringBuilder.append(" description TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "source";
    locala.IhC.put("source", "TEXT");
    localStringBuilder.append(" source TEXT");
    localStringBuilder.append(", ");
    locala.columns[6] = "type";
    locala.IhC.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    locala.columns[7] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eCW != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.eCS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHS == k) {
        this.field_xml = paramCursor.getString(i);
      } else if (eEU == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eHU == k) {
        this.field_description = paramCursor.getString(i);
      } else if (eGw == k) {
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
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eHP) {
      localContentValues.put("xml", this.field_xml);
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eHR) {
      localContentValues.put("description", this.field_description);
    }
    if (this.eGr) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ct
 * JD-Core Version:    0.7.0.1
 */
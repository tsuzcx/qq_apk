package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int elP = "msgId".hashCode();
  private static final int eoH = "size".hashCode();
  private static final int eok = "username".hashCode();
  private static final int eor;
  private static final int erH = "msgType".hashCode();
  private static final int fjt = "msgSubType".hashCode();
  private static final int fju = "msgtime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean elL = true;
  private boolean eoF = true;
  private boolean eoh = true;
  private boolean eon = true;
  private boolean ers = true;
  public long field_msgId;
  public int field_msgSubType;
  public int field_msgType;
  public long field_msgtime;
  public String field_path;
  public long field_size;
  public String field_username;
  private boolean fjr = true;
  private boolean fjs = true;
  
  static
  {
    eor = "path".hashCode();
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
      if (elP != k) {
        break label60;
      }
      this.field_msgId = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (erH == k) {
        this.field_msgType = paramCursor.getInt(i);
      } else if (fjt == k) {
        this.field_msgSubType = paramCursor.getInt(i);
      } else if (eor == k) {
        this.field_path = paramCursor.getString(i);
      } else if (eoH == k) {
        this.field_size = paramCursor.getLong(i);
      } else if (fju == k) {
        this.field_msgtime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elL) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ers) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.fjr) {
      localContentValues.put("msgSubType", Integer.valueOf(this.field_msgSubType));
    }
    if (this.eon) {
      localContentValues.put("path", this.field_path);
    }
    if (this.eoF) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fjs) {
      localContentValues.put("msgtime", Long.valueOf(this.field_msgtime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.gz
 * JD-Core Version:    0.7.0.1
 */
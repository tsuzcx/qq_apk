package com.tencent.mm.plugin.lite.d;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class a
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGZ = "updateTime".hashCode();
  private static final int fCz = "host".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int vkN = "param".hashCode();
  private static final int vkO = "headerMap".hashCode();
  private static final int vkP = "paramMap".hashCode();
  private boolean eGW = true;
  private boolean fCy = true;
  public String field_headerMap;
  public String field_host;
  public String field_param;
  public String field_paramMap;
  public long field_updateTime;
  private boolean vkK = true;
  private boolean vkL = true;
  private boolean vkM = true;
  
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
      if (fCz != k) {
        break label65;
      }
      this.field_host = paramCursor.getString(i);
      this.fCy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (vkN == k) {
        this.field_param = paramCursor.getString(i);
      } else if (vkO == k) {
        this.field_headerMap = paramCursor.getString(i);
      } else if (vkP == k) {
        this.field_paramMap = paramCursor.getString(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fCy) {
      localContentValues.put("host", this.field_host);
    }
    if (this.vkK) {
      localContentValues.put("param", this.field_param);
    }
    if (this.vkL) {
      localContentValues.put("headerMap", this.field_headerMap);
    }
    if (this.vkM) {
      localContentValues.put("paramMap", this.field_paramMap);
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.d.a
 * JD-Core Version:    0.7.0.1
 */
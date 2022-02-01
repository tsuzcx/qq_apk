package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fa
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVu = "xmlContent".hashCode();
  private static final int eVv = "ScanTime".hashCode();
  private static final int eVw = "funcType".hashCode();
  private static final int eVx = "qrcodeUrl".hashCode();
  private static final int elq = "scene".hashCode();
  private static final int exi = "productId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVq = true;
  private boolean eVr = true;
  private boolean eVs = true;
  private boolean eVt = true;
  private boolean elo = true;
  private boolean exf = true;
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  
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
      if (exi != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.exf = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eVu == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (eVv == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (eVw == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (eVx == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (elq == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.exf) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.eVq) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.eVr) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.eVs) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.eVt) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fa
 * JD-Core Version:    0.7.0.1
 */
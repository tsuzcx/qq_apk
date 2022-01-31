package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ef
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dME = "productId".hashCode();
  private static final int dMF = "xmlContent".hashCode();
  private static final int dMG = "ScanTime".hashCode();
  private static final int dMH = "funcType".hashCode();
  private static final int dMI = "qrcodeUrl".hashCode();
  private static final int dhi = "scene".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dMA = true;
  private boolean dMB = true;
  private boolean dMC = true;
  private boolean dMD = true;
  private boolean dMz = true;
  private boolean dhg = true;
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
      if (dME != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.dMz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dMF == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (dMG == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (dMH == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (dMI == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (dhi == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dMz) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.dMA) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.dMB) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.dMC) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.dMD) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.dhg) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.g.c.ef
 * JD-Core Version:    0.7.0.1
 */
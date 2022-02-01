package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEB = "scene".hashCode();
  private static final int eRb = "productId".hashCode();
  private static final int fqW = "xmlContent".hashCode();
  private static final int fqX = "ScanTime".hashCode();
  private static final int fqY = "funcType".hashCode();
  private static final int fqZ = "qrcodeUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEz = true;
  private boolean eQY = true;
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  private boolean fqS = true;
  private boolean fqT = true;
  private boolean fqU = true;
  private boolean fqV = true;
  
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
      if (eRb != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.eQY = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqW == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (fqX == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (fqY == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (fqZ == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eQY) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.fqS) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.fqT) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.fqU) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.fqV) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fo
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fo
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGk = "scene".hashCode();
  private static final int eSM = "productId".hashCode();
  private static final int fsW = "xmlContent".hashCode();
  private static final int fsX = "ScanTime".hashCode();
  private static final int fsY = "funcType".hashCode();
  private static final int fsZ = "qrcodeUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGi = true;
  private boolean eSJ = true;
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  private boolean fsS = true;
  private boolean fsT = true;
  private boolean fsU = true;
  private boolean fsV = true;
  
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
      if (eSM != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.eSJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fsW == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (fsX == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (fsY == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (fsZ == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (eGk == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSJ) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.fsS) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.fsT) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.fsU) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.fsV) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.eGi) {
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
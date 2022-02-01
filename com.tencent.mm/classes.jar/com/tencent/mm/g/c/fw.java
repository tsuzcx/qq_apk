package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fw
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fXB = "xmlContent".hashCode();
  private static final int fXC = "ScanTime".hashCode();
  private static final int fXD = "funcType".hashCode();
  private static final int fXE = "qrcodeUrl".hashCode();
  private static final int fjQ = "scene".hashCode();
  private static final int fwr = "productId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fXA = true;
  private boolean fXx = true;
  private boolean fXy = true;
  private boolean fXz = true;
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  private boolean fjO = true;
  private boolean fwo = true;
  
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
      if (fwr != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.fwo = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fXB == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (fXC == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (fXD == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (fXE == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (fjQ == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fwo) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.fXx) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.fXy) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.fXz) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.fXA) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fw
 * JD-Core Version:    0.7.0.1
 */
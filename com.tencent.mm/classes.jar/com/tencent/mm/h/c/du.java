package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class du
  extends c
{
  private static final int cWs;
  private static final int cWt;
  private static final int cWu;
  private static final int cWv;
  private static final int cWw;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csS;
  private boolean cWn = true;
  private boolean cWo = true;
  private boolean cWp = true;
  private boolean cWq = true;
  private boolean cWr = true;
  private boolean csQ = true;
  public long field_ScanTime;
  public int field_funcType;
  public String field_productId;
  public String field_qrcodeUrl;
  public int field_scene;
  public String field_xmlContent;
  
  static
  {
    cWs = "productId".hashCode();
    cWt = "xmlContent".hashCode();
    cWu = "ScanTime".hashCode();
    cWv = "funcType".hashCode();
    cWw = "qrcodeUrl".hashCode();
    csS = "scene".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cWs != k) {
        break label65;
      }
      this.field_productId = paramCursor.getString(i);
      this.cWn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cWt == k) {
        this.field_xmlContent = paramCursor.getString(i);
      } else if (cWu == k) {
        this.field_ScanTime = paramCursor.getLong(i);
      } else if (cWv == k) {
        this.field_funcType = paramCursor.getInt(i);
      } else if (cWw == k) {
        this.field_qrcodeUrl = paramCursor.getString(i);
      } else if (csS == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cWn) {
      localContentValues.put("productId", this.field_productId);
    }
    if (this.cWo) {
      localContentValues.put("xmlContent", this.field_xmlContent);
    }
    if (this.cWp) {
      localContentValues.put("ScanTime", Long.valueOf(this.field_ScanTime));
    }
    if (this.cWq) {
      localContentValues.put("funcType", Integer.valueOf(this.field_funcType));
    }
    if (this.cWr) {
      localContentValues.put("qrcodeUrl", this.field_qrcodeUrl);
    }
    if (this.csQ) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.du
 * JD-Core Version:    0.7.0.1
 */
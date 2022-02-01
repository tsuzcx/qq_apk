package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class ge
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ScanTranslationResult");
  public static final Column ivA = new Column("tolang", "string", "ScanTranslationResult", "");
  public static final Column ivB = new Column("brand", "string", "ScanTranslationResult", "");
  private static final int ivH = "originMD5".hashCode();
  private static final int ivI = "resultFile".hashCode();
  private static final int ivJ = "fromLang".hashCode();
  private static final int ivK = "toLang".hashCode();
  private static final int ivL = "brand".hashCode();
  public static final Column ivx;
  public static final Column ivy;
  public static final Column ivz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_brand;
  public String field_fromLang;
  public String field_originMD5;
  public String field_resultFile;
  public String field_toLang;
  private boolean ivC = true;
  private boolean ivD = true;
  private boolean ivE = true;
  private boolean ivF = true;
  private boolean ivG = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ScanTranslationResult", "");
    ivx = new Column("originmd5", "string", "ScanTranslationResult", "");
    ivy = new Column("resultfile", "string", "ScanTranslationResult", "");
    ivz = new Column("fromlang", "string", "ScanTranslationResult", "");
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
      if (ivH != k) {
        break label65;
      }
      this.field_originMD5 = paramCursor.getString(i);
      this.ivC = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ivI == k) {
        this.field_resultFile = paramCursor.getString(i);
      } else if (ivJ == k) {
        this.field_fromLang = paramCursor.getString(i);
      } else if (ivK == k) {
        this.field_toLang = paramCursor.getString(i);
      } else if (ivL == k) {
        this.field_brand = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ivC) {
      localContentValues.put("originMD5", this.field_originMD5);
    }
    if (this.ivD) {
      localContentValues.put("resultFile", this.field_resultFile);
    }
    if (this.ivE) {
      localContentValues.put("fromLang", this.field_fromLang);
    }
    if (this.ivF) {
      localContentValues.put("toLang", this.field_toLang);
    }
    if (this.ivG) {
      localContentValues.put("brand", this.field_brand);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ScanTranslationResult";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.c.ge
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hr
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ghG = "appDs".hashCode();
  private static final int ghH = "appHour".hashCode();
  private static final int ghI = "appTbe".hashCode();
  private static final int ghJ = "appTen".hashCode();
  private static final int ghK = "appIn".hashCode();
  private static final int ghL = "appInbg".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_appDs;
  public int field_appHour;
  public long field_appIn;
  public long field_appInbg;
  public long field_appTbe;
  public long field_appTen;
  private boolean ghA = true;
  private boolean ghB = true;
  private boolean ghC = true;
  private boolean ghD = true;
  private boolean ghE = true;
  private boolean ghF = true;
  
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
      if (ghG != k) {
        break label60;
      }
      this.field_appDs = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (ghH == k) {
        this.field_appHour = paramCursor.getInt(i);
      } else if (ghI == k) {
        this.field_appTbe = paramCursor.getLong(i);
      } else if (ghJ == k) {
        this.field_appTen = paramCursor.getLong(i);
      } else if (ghK == k) {
        this.field_appIn = paramCursor.getLong(i);
      } else if (ghL == k) {
        this.field_appInbg = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ghA) {
      localContentValues.put("appDs", Integer.valueOf(this.field_appDs));
    }
    if (this.ghB) {
      localContentValues.put("appHour", Integer.valueOf(this.field_appHour));
    }
    if (this.ghC) {
      localContentValues.put("appTbe", Long.valueOf(this.field_appTbe));
    }
    if (this.ghD) {
      localContentValues.put("appTen", Long.valueOf(this.field_appTen));
    }
    if (this.ghE) {
      localContentValues.put("appIn", Long.valueOf(this.field_appIn));
    }
    if (this.ghF) {
      localContentValues.put("appInbg", Long.valueOf(this.field_appInbg));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hr
 * JD-Core Version:    0.7.0.1
 */
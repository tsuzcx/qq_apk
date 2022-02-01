package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gm
  extends IAutoDBItem
{
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("SmileyInfo");
  public static final Column hNx;
  private static final int hOF;
  public static final Column hsi;
  private static final int hsm = "flag".hashCode();
  public static final Column ixB;
  public static final Column ixC;
  public static final Column ixD;
  public static final Column ixE;
  public static final Column ixF;
  public static final Column ixG;
  public static final Column ixH;
  private static final int ixP;
  private static final int ixQ;
  private static final int ixR;
  private static final int ixS;
  private static final int ixT;
  private static final int ixU;
  private static final int ixV;
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  public String field_cnValue;
  public int field_eggIndex;
  public String field_enValue;
  public String field_fileName;
  public int field_flag;
  public String field_key;
  public int field_position;
  public String field_qqValue;
  public String field_thValue;
  public String field_twValue;
  private boolean hOb = true;
  private boolean hsk = true;
  private boolean ixI = true;
  private boolean ixJ = true;
  private boolean ixK = true;
  private boolean ixL = true;
  private boolean ixM = true;
  private boolean ixN = true;
  private boolean ixO = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SmileyInfo", "");
    C_KEY = new Column("key", "string", "SmileyInfo", "");
    ixB = new Column("cnvalue", "string", "SmileyInfo", "");
    ixC = new Column("qqvalue", "string", "SmileyInfo", "");
    ixD = new Column("twvalue", "string", "SmileyInfo", "");
    ixE = new Column("envalue", "string", "SmileyInfo", "");
    ixF = new Column("thvalue", "string", "SmileyInfo", "");
    hNx = new Column("filename", "string", "SmileyInfo", "");
    ixG = new Column("eggindex", "int", "SmileyInfo", "");
    ixH = new Column("position", "int", "SmileyInfo", "");
    hsi = new Column("flag", "int", "SmileyInfo", "");
    key_HASHCODE = "key".hashCode();
    ixP = "cnValue".hashCode();
    ixQ = "qqValue".hashCode();
    ixR = "twValue".hashCode();
    ixS = "enValue".hashCode();
    ixT = "thValue".hashCode();
    hOF = "fileName".hashCode();
    ixU = "eggIndex".hashCode();
    ixV = "position".hashCode();
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
      if (key_HASHCODE != k) {
        break label65;
      }
      this.field_key = paramCursor.getString(i);
      this.__hadSetkey = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ixP == k) {
        this.field_cnValue = paramCursor.getString(i);
      } else if (ixQ == k) {
        this.field_qqValue = paramCursor.getString(i);
      } else if (ixR == k) {
        this.field_twValue = paramCursor.getString(i);
      } else if (ixS == k) {
        this.field_enValue = paramCursor.getString(i);
      } else if (ixT == k) {
        this.field_thValue = paramCursor.getString(i);
      } else if (hOF == k) {
        this.field_fileName = paramCursor.getString(i);
      } else if (ixU == k) {
        this.field_eggIndex = paramCursor.getInt(i);
      } else if (ixV == k) {
        this.field_position = paramCursor.getInt(i);
      } else if (hsm == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.ixI) {
      localContentValues.put("cnValue", this.field_cnValue);
    }
    if (this.ixJ) {
      localContentValues.put("qqValue", this.field_qqValue);
    }
    if (this.ixK) {
      localContentValues.put("twValue", this.field_twValue);
    }
    if (this.ixL) {
      localContentValues.put("enValue", this.field_enValue);
    }
    if (this.ixM) {
      localContentValues.put("thValue", this.field_thValue);
    }
    if (this.hOb) {
      localContentValues.put("fileName", this.field_fileName);
    }
    if (this.ixN) {
      localContentValues.put("eggIndex", Integer.valueOf(this.field_eggIndex));
    }
    if (this.ixO) {
      localContentValues.put("position", Integer.valueOf(this.field_position));
    }
    if (this.hsk) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
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
    return "SmileyInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.gm
 * JD-Core Version:    0.7.0.1
 */
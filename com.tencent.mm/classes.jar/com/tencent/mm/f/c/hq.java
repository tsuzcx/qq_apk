package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hq
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("WalletPrefInfo");
  public static final Column hxY;
  private static final int hyK = "logo_url".hashCode();
  private static final int hyQ = "jump_type".hashCode();
  public static final Column hye;
  private static final int iHA;
  private static final int iHB;
  private static final int iHC;
  private static final int iHD;
  private static final int iHE = "tinyapp_username".hashCode();
  private static final int iHF = "tinyapp_path".hashCode();
  public static final Column iHl;
  public static final Column iHm;
  public static final Column iHn;
  public static final Column iHo;
  public static final Column iHp;
  public static final Column iHq;
  public static final Column iHr;
  private static final int iHz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public int field_is_show;
  public int field_jump_type;
  public String field_logo_url;
  public String field_pref_desc;
  public String field_pref_key;
  public String field_pref_title;
  public String field_pref_url;
  public String field_tinyapp_path;
  public String field_tinyapp_username;
  private boolean hyr = true;
  private boolean hyx = true;
  private boolean iHs = true;
  private boolean iHt = true;
  private boolean iHu = true;
  private boolean iHv = true;
  private boolean iHw = true;
  private boolean iHx = true;
  private boolean iHy = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "WalletPrefInfo", "");
    iHl = new Column("pref_key", "string", "WalletPrefInfo", "");
    iHm = new Column("pref_title", "string", "WalletPrefInfo", "");
    iHn = new Column("pref_url", "string", "WalletPrefInfo", "");
    iHo = new Column("is_show", "int", "WalletPrefInfo", "");
    iHp = new Column("pref_desc", "string", "WalletPrefInfo", "");
    hxY = new Column("logo_url", "string", "WalletPrefInfo", "");
    hye = new Column("jump_type", "int", "WalletPrefInfo", "");
    iHq = new Column("tinyapp_username", "string", "WalletPrefInfo", "");
    iHr = new Column("tinyapp_path", "string", "WalletPrefInfo", "");
    iHz = "pref_key".hashCode();
    iHA = "pref_title".hashCode();
    iHB = "pref_url".hashCode();
    iHC = "is_show".hashCode();
    iHD = "pref_desc".hashCode();
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
      if (iHz != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.iHs = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iHA == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (iHB == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (iHC == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (iHD == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (hyK == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (hyQ == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (iHE == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (iHF == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iHs) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.iHt) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.iHu) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.iHv) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.iHw) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.hyr) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.hyx) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.iHx) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.iHy) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
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
    return "WalletPrefInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.hq
 * JD-Core Version:    0.7.0.1
 */
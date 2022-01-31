package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dTU = "pref_key".hashCode();
  private static final int dTV = "pref_title".hashCode();
  private static final int dTW = "pref_url".hashCode();
  private static final int dTX = "is_show".hashCode();
  private static final int dTY = "pref_desc".hashCode();
  private static final int dTZ = "tinyapp_username".hashCode();
  private static final int dUa = "tinyapp_path".hashCode();
  private static final int dnR = "logo_url".hashCode();
  private static final int dnX = "jump_type".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dTN = true;
  private boolean dTO = true;
  private boolean dTP = true;
  private boolean dTQ = true;
  private boolean dTR = true;
  private boolean dTS = true;
  private boolean dTT = true;
  private boolean dnE = true;
  private boolean dny = true;
  public int field_is_show;
  public int field_jump_type;
  public String field_logo_url;
  public String field_pref_desc;
  public String field_pref_key;
  public String field_pref_title;
  public String field_pref_url;
  public String field_tinyapp_path;
  public String field_tinyapp_username;
  
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
      if (dTU != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.dTN = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dTV == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (dTW == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (dTX == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (dTY == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (dnR == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (dnX == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (dTZ == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (dUa == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dTN) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.dTO) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.dTP) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.dTQ) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.dTR) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.dny) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.dnE) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.dTS) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.dTT) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fl
 * JD-Core Version:    0.7.0.1
 */
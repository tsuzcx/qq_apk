package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNU = "logo_url".hashCode();
  private static final int eOa = "jump_type".hashCode();
  private static final int fAN = "pref_key".hashCode();
  private static final int fAO = "pref_title".hashCode();
  private static final int fAP = "pref_url".hashCode();
  private static final int fAQ = "is_show".hashCode();
  private static final int fAR = "pref_desc".hashCode();
  private static final int fAS = "tinyapp_username".hashCode();
  private static final int fAT = "tinyapp_path".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNB = true;
  private boolean eNH = true;
  private boolean fAG = true;
  private boolean fAH = true;
  private boolean fAI = true;
  private boolean fAJ = true;
  private boolean fAK = true;
  private boolean fAL = true;
  private boolean fAM = true;
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
      if (fAN != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.fAG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fAO == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (fAP == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (fAQ == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (fAR == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (eNU == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (eOa == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (fAS == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (fAT == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fAG) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.fAH) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.fAI) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.fAJ) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.fAK) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.eNB) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.eNH) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.fAL) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.fAM) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gy
 * JD-Core Version:    0.7.0.1
 */
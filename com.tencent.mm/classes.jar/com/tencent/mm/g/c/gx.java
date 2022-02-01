package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eMj = "logo_url".hashCode();
  private static final int eMp = "jump_type".hashCode();
  private static final int fyN = "pref_key".hashCode();
  private static final int fyO = "pref_title".hashCode();
  private static final int fyP = "pref_url".hashCode();
  private static final int fyQ = "is_show".hashCode();
  private static final int fyR = "pref_desc".hashCode();
  private static final int fyS = "tinyapp_username".hashCode();
  private static final int fyT = "tinyapp_path".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLQ = true;
  private boolean eLW = true;
  public int field_is_show;
  public int field_jump_type;
  public String field_logo_url;
  public String field_pref_desc;
  public String field_pref_key;
  public String field_pref_title;
  public String field_pref_url;
  public String field_tinyapp_path;
  public String field_tinyapp_username;
  private boolean fyG = true;
  private boolean fyH = true;
  private boolean fyI = true;
  private boolean fyJ = true;
  private boolean fyK = true;
  private boolean fyL = true;
  private boolean fyM = true;
  
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
      if (fyN != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.fyG = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyO == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (fyP == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (fyQ == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (fyR == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (eMj == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (eMp == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (fyS == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (fyT == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fyG) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.fyH) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.fyI) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.fyJ) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.fyK) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.eLQ) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.eLW) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.fyL) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.fyM) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gx
 * JD-Core Version:    0.7.0.1
 */
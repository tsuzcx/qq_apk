package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int esI = "logo_url".hashCode();
  private static final int esO = "jump_type".hashCode();
  private static final int fdn = "pref_key".hashCode();
  private static final int fdo = "pref_title".hashCode();
  private static final int fdp = "pref_url".hashCode();
  private static final int fdq = "is_show".hashCode();
  private static final int fdr = "pref_desc".hashCode();
  private static final int fds = "tinyapp_username".hashCode();
  private static final int fdt = "tinyapp_path".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean esp = true;
  private boolean esv = true;
  private boolean fdg = true;
  private boolean fdh = true;
  private boolean fdi = true;
  private boolean fdj = true;
  private boolean fdk = true;
  private boolean fdl = true;
  private boolean fdm = true;
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
      if (fdn != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.fdg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fdo == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (fdp == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (fdq == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (fdr == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (esI == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (esO == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (fds == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (fdt == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fdg) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.fdh) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.fdi) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.fdj) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.fdk) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.esp) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.esv) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.fdl) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.fdm) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gj
 * JD-Core Version:    0.7.0.1
 */
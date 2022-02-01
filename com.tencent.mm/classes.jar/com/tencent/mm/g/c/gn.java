package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int euM = "logo_url".hashCode();
  private static final int euS = "jump_type".hashCode();
  private static final int fgF = "pref_key".hashCode();
  private static final int fgG = "pref_title".hashCode();
  private static final int fgH = "pref_url".hashCode();
  private static final int fgI = "is_show".hashCode();
  private static final int fgJ = "pref_desc".hashCode();
  private static final int fgK = "tinyapp_username".hashCode();
  private static final int fgL = "tinyapp_path".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eut = true;
  private boolean euz = true;
  private boolean fgA = true;
  private boolean fgB = true;
  private boolean fgC = true;
  private boolean fgD = true;
  private boolean fgE = true;
  private boolean fgy = true;
  private boolean fgz = true;
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
      if (fgF != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.fgy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fgG == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (fgH == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (fgI == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (fgJ == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (euM == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (euS == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (fgK == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (fgL == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fgy) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.fgz) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.fgA) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.fgB) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.fgC) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.eut) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.euz) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.fgD) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.fgE) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gn
 * JD-Core Version:    0.7.0.1
 */
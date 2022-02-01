package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hj
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int frB = "logo_url".hashCode();
  private static final int frH = "jump_type".hashCode();
  private static final int gfL = "pref_key".hashCode();
  private static final int gfM = "pref_title".hashCode();
  private static final int gfN = "pref_url".hashCode();
  private static final int gfO = "is_show".hashCode();
  private static final int gfP = "pref_desc".hashCode();
  private static final int gfQ = "tinyapp_username".hashCode();
  private static final int gfR = "tinyapp_path".hashCode();
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
  private boolean fri = true;
  private boolean fro = true;
  private boolean gfE = true;
  private boolean gfF = true;
  private boolean gfG = true;
  private boolean gfH = true;
  private boolean gfI = true;
  private boolean gfJ = true;
  private boolean gfK = true;
  
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
      if (gfL != k) {
        break label65;
      }
      this.field_pref_key = paramCursor.getString(i);
      this.gfE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (gfM == k) {
        this.field_pref_title = paramCursor.getString(i);
      } else if (gfN == k) {
        this.field_pref_url = paramCursor.getString(i);
      } else if (gfO == k) {
        this.field_is_show = paramCursor.getInt(i);
      } else if (gfP == k) {
        this.field_pref_desc = paramCursor.getString(i);
      } else if (frB == k) {
        this.field_logo_url = paramCursor.getString(i);
      } else if (frH == k) {
        this.field_jump_type = paramCursor.getInt(i);
      } else if (gfQ == k) {
        this.field_tinyapp_username = paramCursor.getString(i);
      } else if (gfR == k) {
        this.field_tinyapp_path = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gfE) {
      localContentValues.put("pref_key", this.field_pref_key);
    }
    if (this.gfF) {
      localContentValues.put("pref_title", this.field_pref_title);
    }
    if (this.gfG) {
      localContentValues.put("pref_url", this.field_pref_url);
    }
    if (this.gfH) {
      localContentValues.put("is_show", Integer.valueOf(this.field_is_show));
    }
    if (this.gfI) {
      localContentValues.put("pref_desc", this.field_pref_desc);
    }
    if (this.fri) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.fro) {
      localContentValues.put("jump_type", Integer.valueOf(this.field_jump_type));
    }
    if (this.gfJ) {
      localContentValues.put("tinyapp_username", this.field_tinyapp_username);
    }
    if (this.gfK) {
      localContentValues.put("tinyapp_path", this.field_tinyapp_path);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.hj
 * JD-Core Version:    0.7.0.1
 */
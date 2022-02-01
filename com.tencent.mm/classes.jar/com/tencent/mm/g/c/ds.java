package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ds
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRb;
  private static final int eRc = "corp_name".hashCode();
  private static final int eRd = "action_type".hashCode();
  private static final int eRe = "action_url".hashCode();
  private static final int eRf = "action_app_username".hashCode();
  private static final int eRg = "action_app_nickname".hashCode();
  private static final int eRh = "packet_id".hashCode();
  private static final int eRi = "update_time".hashCode();
  private static final int eqK = "title".hashCode();
  private static final int eqL;
  private static final int euM = "logo_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eQT = true;
  private boolean eQU = true;
  private boolean eQV = true;
  private boolean eQW = true;
  private boolean eQX = true;
  private boolean eQY = true;
  private boolean eQZ = true;
  private boolean eRa = true;
  private boolean eqH = true;
  private boolean eqI = true;
  private boolean eut = true;
  public String field_action_app_nickname;
  public String field_action_app_username;
  public int field_action_type;
  public String field_action_url;
  public String field_corp_name;
  public String field_description;
  public String field_logo_md5;
  public String field_logo_url;
  public String field_packet_id;
  public String field_title;
  public long field_update_time;
  
  static
  {
    eRb = "logo_md5".hashCode();
    eqL = "description".hashCode();
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
      if (eqK != k) {
        break label60;
      }
      this.field_title = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (euM == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (eRb == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (eqL == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (eRc == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (eRd == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (eRe == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (eRf == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (eRg == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (eRh == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.eQZ = true;
      }
      else if (eRi == k)
      {
        this.field_update_time = paramCursor.getLong(i);
      }
      else if (rowid_HASHCODE == k)
      {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eut) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.eQT) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.eqI) {
      localContentValues.put("description", this.field_description);
    }
    if (this.eQU) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.eQV) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.eQW) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.eQX) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.eQY) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.eQZ) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.eRa) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ds
 * JD-Core Version:    0.7.0.1
 */
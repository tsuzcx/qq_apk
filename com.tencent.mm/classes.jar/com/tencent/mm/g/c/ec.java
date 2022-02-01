package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJC = "title".hashCode();
  private static final int eJD;
  private static final int eNU = "logo_url".hashCode();
  private static final int flA = "action_app_nickname".hashCode();
  private static final int flB = "packet_id".hashCode();
  private static final int flC = "update_time".hashCode();
  private static final int flv = "logo_md5".hashCode();
  private static final int flw;
  private static final int flx;
  private static final int fly;
  private static final int flz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJA = true;
  private boolean eJz = true;
  private boolean eNB = true;
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
  private boolean fln = true;
  private boolean flo = true;
  private boolean flp = true;
  private boolean flq = true;
  private boolean flr = true;
  private boolean fls = true;
  private boolean flt = true;
  private boolean flu = true;
  
  static
  {
    eJD = "description".hashCode();
    flw = "corp_name".hashCode();
    flx = "action_type".hashCode();
    fly = "action_url".hashCode();
    flz = "action_app_username".hashCode();
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
      if (eJC != k) {
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
      if (eNU == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (flv == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (eJD == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (flw == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (flx == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (fly == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (flz == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (flA == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (flB == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.flt = true;
      }
      else if (flC == k)
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
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eNB) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.fln) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.eJA) {
      localContentValues.put("description", this.field_description);
    }
    if (this.flo) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.flp) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.flq) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.flr) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.fls) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.flt) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.flu) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.ec
 * JD-Core Version:    0.7.0.1
 */
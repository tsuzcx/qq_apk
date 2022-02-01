package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ei
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPZ;
  private static final int fQa = "corp_name".hashCode();
  private static final int fQb = "action_type".hashCode();
  private static final int fQc = "action_url".hashCode();
  private static final int fQd = "action_app_username".hashCode();
  private static final int fQe = "action_app_nickname".hashCode();
  private static final int fQf = "packet_id".hashCode();
  private static final int fQg = "update_time".hashCode();
  private static final int fne = "title".hashCode();
  private static final int fnf;
  private static final int frB = "logo_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPR = true;
  private boolean fPS = true;
  private boolean fPT = true;
  private boolean fPU = true;
  private boolean fPV = true;
  private boolean fPW = true;
  private boolean fPX = true;
  private boolean fPY = true;
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
  private boolean fnb = true;
  private boolean fnc = true;
  private boolean fri = true;
  
  static
  {
    fPZ = "logo_md5".hashCode();
    fnf = "description".hashCode();
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
      if (fne != k) {
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
      if (frB == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (fPZ == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (fnf == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (fQa == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (fQb == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (fQc == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (fQd == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (fQe == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (fQf == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.fPX = true;
      }
      else if (fQg == k)
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
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fri) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.fPR) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.fnc) {
      localContentValues.put("description", this.field_description);
    }
    if (this.fPS) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.fPT) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.fPU) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.fPV) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.fPW) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.fPX) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.fPY) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ei
 * JD-Core Version:    0.7.0.1
 */
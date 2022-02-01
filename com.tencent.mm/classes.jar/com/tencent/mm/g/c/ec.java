package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHT = "title".hashCode();
  private static final int eHU;
  private static final int eMj = "logo_url".hashCode();
  private static final int fjA = "action_type".hashCode();
  private static final int fjB = "action_url".hashCode();
  private static final int fjC = "action_app_username".hashCode();
  private static final int fjD = "action_app_nickname".hashCode();
  private static final int fjE = "packet_id".hashCode();
  private static final int fjF = "update_time".hashCode();
  private static final int fjy = "logo_md5".hashCode();
  private static final int fjz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHQ = true;
  private boolean eHR = true;
  private boolean eLQ = true;
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
  private boolean fjq = true;
  private boolean fjr = true;
  private boolean fjs = true;
  private boolean fjt = true;
  private boolean fju = true;
  private boolean fjv = true;
  private boolean fjw = true;
  private boolean fjx = true;
  
  static
  {
    eHU = "description".hashCode();
    fjz = "corp_name".hashCode();
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
      if (eHT != k) {
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
      if (eMj == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (fjy == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (eHU == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (fjz == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (fjA == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (fjB == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (fjC == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (fjD == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (fjE == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.fjw = true;
      }
      else if (fjF == k)
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
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eLQ) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.fjq) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.eHR) {
      localContentValues.put("description", this.field_description);
    }
    if (this.fjr) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.fjs) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.fjt) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.fju) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.fjv) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.fjw) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.fjx) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ec
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNX;
  private static final int eNY = "corp_name".hashCode();
  private static final int eNZ = "action_type".hashCode();
  private static final int eOa = "action_url".hashCode();
  private static final int eOb = "action_app_username".hashCode();
  private static final int eOc = "action_app_nickname".hashCode();
  private static final int eOd = "packet_id".hashCode();
  private static final int eOe = "update_time".hashCode();
  private static final int eoG = "title".hashCode();
  private static final int eoH;
  private static final int esI = "logo_url".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNP = true;
  private boolean eNQ = true;
  private boolean eNR = true;
  private boolean eNS = true;
  private boolean eNT = true;
  private boolean eNU = true;
  private boolean eNV = true;
  private boolean eNW = true;
  private boolean eoD = true;
  private boolean eoE = true;
  private boolean esp = true;
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
    eNX = "logo_md5".hashCode();
    eoH = "description".hashCode();
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
      if (eoG != k) {
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
      if (esI == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (eNX == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (eoH == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (eNY == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (eNZ == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (eOa == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (eOb == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (eOc == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (eOd == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.eNV = true;
      }
      else if (eOe == k)
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
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.esp) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.eNP) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.eoE) {
      localContentValues.put("description", this.field_description);
    }
    if (this.eNQ) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.eNR) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.eNS) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.eNT) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.eNU) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.eNV) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.eNW) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dp
 * JD-Core Version:    0.7.0.1
 */
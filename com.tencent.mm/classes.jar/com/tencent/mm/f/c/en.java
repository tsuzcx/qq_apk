package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class en
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LocalRedPacketStoryInfo");
  public static final Column hsa;
  public static final Column hsb;
  private static final int hsg;
  private static final int hsh = "description".hashCode();
  public static final Column hxY;
  private static final int hyK;
  public static final Column ijA;
  public static final Column ijB;
  public static final Column ijC;
  private static final int ijM;
  private static final int ijN = "corp_name".hashCode();
  private static final int ijO = "action_type".hashCode();
  private static final int ijP = "action_url".hashCode();
  private static final int ijQ = "action_app_username".hashCode();
  private static final int ijR = "action_app_nickname".hashCode();
  private static final int ijS = "packet_id".hashCode();
  private static final int ijT = "update_time".hashCode();
  private static final int ijU = "subtype_id".hashCode();
  public static final Column iju;
  public static final Column ijv;
  public static final Column ijw;
  public static final Column ijx;
  public static final Column ijy;
  public static final Column ijz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_action_app_nickname;
  public String field_action_app_username;
  public int field_action_type;
  public String field_action_url;
  public String field_corp_name;
  public String field_description;
  public String field_logo_md5;
  public String field_logo_url;
  public String field_packet_id;
  public int field_subtype_id;
  public String field_title;
  public long field_update_time;
  private boolean hsd = true;
  private boolean hse = true;
  private boolean hyr = true;
  private boolean ijD = true;
  private boolean ijE = true;
  private boolean ijF = true;
  private boolean ijG = true;
  private boolean ijH = true;
  private boolean ijI = true;
  private boolean ijJ = true;
  private boolean ijK = true;
  private boolean ijL = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LocalRedPacketStoryInfo", "");
    hsa = new Column("title", "string", "LocalRedPacketStoryInfo", "");
    hxY = new Column("logo_url", "string", "LocalRedPacketStoryInfo", "");
    iju = new Column("logo_md5", "string", "LocalRedPacketStoryInfo", "");
    hsb = new Column("description", "string", "LocalRedPacketStoryInfo", "");
    ijv = new Column("corp_name", "string", "LocalRedPacketStoryInfo", "");
    ijw = new Column("action_type", "int", "LocalRedPacketStoryInfo", "");
    ijx = new Column("action_url", "string", "LocalRedPacketStoryInfo", "");
    ijy = new Column("action_app_username", "string", "LocalRedPacketStoryInfo", "");
    ijz = new Column("action_app_nickname", "string", "LocalRedPacketStoryInfo", "");
    ijA = new Column("packet_id", "string", "LocalRedPacketStoryInfo", "");
    ijB = new Column("update_time", "long", "LocalRedPacketStoryInfo", "");
    ijC = new Column("subtype_id", "int", "LocalRedPacketStoryInfo", "");
    hsg = "title".hashCode();
    hyK = "logo_url".hashCode();
    ijM = "logo_md5".hashCode();
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
      if (hsg != k) {
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
      if (hyK == k)
      {
        this.field_logo_url = paramCursor.getString(i);
      }
      else if (ijM == k)
      {
        this.field_logo_md5 = paramCursor.getString(i);
      }
      else if (hsh == k)
      {
        this.field_description = paramCursor.getString(i);
      }
      else if (ijN == k)
      {
        this.field_corp_name = paramCursor.getString(i);
      }
      else if (ijO == k)
      {
        this.field_action_type = paramCursor.getInt(i);
      }
      else if (ijP == k)
      {
        this.field_action_url = paramCursor.getString(i);
      }
      else if (ijQ == k)
      {
        this.field_action_app_username = paramCursor.getString(i);
      }
      else if (ijR == k)
      {
        this.field_action_app_nickname = paramCursor.getString(i);
      }
      else if (ijS == k)
      {
        this.field_packet_id = paramCursor.getString(i);
        this.ijJ = true;
      }
      else if (ijT == k)
      {
        this.field_update_time = paramCursor.getLong(i);
      }
      else if (ijU == k)
      {
        this.field_subtype_id = paramCursor.getInt(i);
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
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hyr) {
      localContentValues.put("logo_url", this.field_logo_url);
    }
    if (this.ijD) {
      localContentValues.put("logo_md5", this.field_logo_md5);
    }
    if (this.hse) {
      localContentValues.put("description", this.field_description);
    }
    if (this.ijE) {
      localContentValues.put("corp_name", this.field_corp_name);
    }
    if (this.ijF) {
      localContentValues.put("action_type", Integer.valueOf(this.field_action_type));
    }
    if (this.ijG) {
      localContentValues.put("action_url", this.field_action_url);
    }
    if (this.ijH) {
      localContentValues.put("action_app_username", this.field_action_app_username);
    }
    if (this.ijI) {
      localContentValues.put("action_app_nickname", this.field_action_app_nickname);
    }
    if (this.ijJ) {
      localContentValues.put("packet_id", this.field_packet_id);
    }
    if (this.ijK) {
      localContentValues.put("update_time", Long.valueOf(this.field_update_time));
    }
    if (this.ijL) {
      localContentValues.put("subtype_id", Integer.valueOf(this.field_subtype_id));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LocalRedPacketStoryInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.f.c.en
 * JD-Core Version:    0.7.0.1
 */
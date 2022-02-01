package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class do
  extends IAutoDBItem
{
  public static final Column C_CONTENT;
  public static final Column C_KEY;
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GroupSolitatire");
  private static final int content_HASHCODE;
  public static final Column hwH;
  private static final int hxj = "msgSvrId".hashCode();
  public static final Column ibW;
  public static final Column ibX;
  public static final Column ibY;
  public static final Column ibZ;
  public static final Column ica;
  private static final int icg;
  private static final int ich;
  private static final int ici;
  private static final int icj = "active".hashCode();
  private static final int ick = "lastActiveTime".hashCode();
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetcontent = true;
  private boolean __hadSetkey = true;
  private boolean __hadSetusername = true;
  public int field_active;
  public String field_content;
  public String field_creator;
  public long field_firstMsgId;
  public String field_key;
  public long field_lastActiveTime;
  public long field_msgSvrId;
  public int field_num;
  public String field_username;
  private boolean hwV = true;
  private boolean icb = true;
  private boolean icc = true;
  private boolean icd = true;
  private boolean ice = true;
  private boolean icf = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GroupSolitatire", "");
    C_USERNAME = new Column("username", "string", "GroupSolitatire", "");
    C_KEY = new Column("key", "string", "GroupSolitatire", "");
    C_CONTENT = new Column("content", "string", "GroupSolitatire", "");
    ibW = new Column("creator", "string", "GroupSolitatire", "");
    ibX = new Column("num", "int", "GroupSolitatire", "");
    ibY = new Column("firstmsgid", "long", "GroupSolitatire", "");
    hwH = new Column("msgsvrid", "long", "GroupSolitatire", "");
    ibZ = new Column("active", "int", "GroupSolitatire", "");
    ica = new Column("lastactivetime", "long", "GroupSolitatire", "");
    username_HASHCODE = "username".hashCode();
    key_HASHCODE = "key".hashCode();
    content_HASHCODE = "content".hashCode();
    icg = "creator".hashCode();
    ich = "num".hashCode();
    ici = "firstMsgId".hashCode();
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
      if (username_HASHCODE != k) {
        break label60;
      }
      this.field_username = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (key_HASHCODE == k) {
        this.field_key = paramCursor.getString(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (icg == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (ich == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (ici == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (hxj == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (icj == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (ick == k) {
        this.field_lastActiveTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.icb) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.icc) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.icd) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.hwV) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.ice) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.icf) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
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
    return "GroupSolitatire";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.do
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO = "createTime".hashCode();
  private static final int eKy;
  private static final int eMP;
  private static final int eWD = "msgContent".hashCode();
  private static final int eWE;
  private static final int eWF = "chatroomName".hashCode();
  private static final int eWl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eFr = true;
  private boolean eKj = true;
  private boolean eMB = true;
  private boolean eVW = true;
  private boolean eWA = true;
  private boolean eWB = true;
  private boolean eWC = true;
  public String field_chatroomName;
  public long field_createTime;
  public String field_encryptTalker;
  public int field_isSend;
  public String field_msgContent;
  public long field_svrId;
  public String field_talker;
  public int field_type;
  
  static
  {
    eKy = "isSend".hashCode();
    eMP = "talker".hashCode();
    eWl = "encryptTalker".hashCode();
    eWE = "svrId".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (eWD != k) {
        break label60;
      }
      this.field_msgContent = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eKy == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eMP == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eWl == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eWE == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eWF == k) {
        this.field_chatroomName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_msgContent == null) {
      this.field_msgContent = "";
    }
    if (this.eWA) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.eKj) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eVW) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.eWB) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.eWC) {
      localContentValues.put("chatroomName", this.field_chatroomName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bt
 * JD-Core Version:    0.7.0.1
 */
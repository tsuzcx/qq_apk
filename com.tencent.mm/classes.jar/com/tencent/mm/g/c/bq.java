package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eAI;
  private static final int eBa = "msgContent".hashCode();
  private static final int eBb;
  private static final int eBc = "chatroomName".hashCode();
  private static final int ekU;
  private static final int epC = "isSend".hashCode();
  private static final int erT = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eAX = true;
  private boolean eAY = true;
  private boolean eAZ = true;
  private boolean eAt = true;
  private boolean ekx = true;
  private boolean epn = true;
  private boolean erF = true;
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
    eAI = "encryptTalker".hashCode();
    eBb = "svrId".hashCode();
    type_HASHCODE = "type".hashCode();
    ekU = "createTime".hashCode();
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
      if (eBa != k) {
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
      if (epC == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (erT == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eAI == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eBb == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eBc == k) {
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
    if (this.eAX) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.epn) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.erF) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eAt) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.eAY) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.eAZ) {
      localContentValues.put("chatroomName", this.field_chatroomName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bq
 * JD-Core Version:    0.7.0.1
 */
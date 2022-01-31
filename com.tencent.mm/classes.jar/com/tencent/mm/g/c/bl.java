package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgM = "createTime".hashCode();
  private static final int dle;
  private static final int dnh;
  private static final int dvI;
  private static final int dwa = "msgContent".hashCode();
  private static final int dwb;
  private static final int dwc = "chatroomName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dgp = true;
  private boolean dkQ = true;
  private boolean dmW = true;
  private boolean dvX = true;
  private boolean dvY = true;
  private boolean dvZ = true;
  private boolean dvt = true;
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
    dle = "isSend".hashCode();
    dnh = "talker".hashCode();
    dvI = "encryptTalker".hashCode();
    dwb = "svrId".hashCode();
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
      if (dwa != k) {
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
      if (dle == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (dnh == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (dvI == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (dwb == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (dwc == k) {
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
    if (this.dvX) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.dkQ) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.dmW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.dvt) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.dvY) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.dvZ) {
      localContentValues.put("chatroomName", this.field_chatroomName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bt
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf = "createTime".hashCode();
  private static final int eIP;
  private static final int eLf;
  private static final int eUA;
  private static final int eUS = "msgContent".hashCode();
  private static final int eUT;
  private static final int eUU = "chatroomName".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eDI = true;
  private boolean eIA = true;
  private boolean eKS = true;
  private boolean eUP = true;
  private boolean eUQ = true;
  private boolean eUR = true;
  private boolean eUl = true;
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
    eIP = "isSend".hashCode();
    eLf = "talker".hashCode();
    eUA = "encryptTalker".hashCode();
    eUT = "svrId".hashCode();
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
      if (eUS != k) {
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
      if (eIP == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (eLf == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (eUA == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (eUT == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eUU == k) {
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
    if (this.eUP) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.eIA) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.eUl) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.eUQ) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.eUR) {
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
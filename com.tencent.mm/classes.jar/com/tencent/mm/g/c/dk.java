package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dk
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int fKQ;
  private static final int fKR;
  private static final int fKS;
  private static final int fKT = "active".hashCode();
  private static final int fKU = "lastActiveTime".hashCode();
  private static final int fqv;
  private static final int key_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetcontent = true;
  private boolean __hadSetkey = true;
  private boolean __hadSetusername = true;
  private boolean fKL = true;
  private boolean fKM = true;
  private boolean fKN = true;
  private boolean fKO = true;
  private boolean fKP = true;
  public int field_active;
  public String field_content;
  public String field_creator;
  public long field_firstMsgId;
  public String field_key;
  public long field_lastActiveTime;
  public long field_msgSvrId;
  public int field_num;
  public String field_username;
  private boolean fqh = true;
  
  static
  {
    key_HASHCODE = "key".hashCode();
    content_HASHCODE = "content".hashCode();
    fKQ = "creator".hashCode();
    fKR = "num".hashCode();
    fKS = "firstMsgId".hashCode();
    fqv = "msgSvrId".hashCode();
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
      } else if (fKQ == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (fKR == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (fKS == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (fqv == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (fKT == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (fKU == k) {
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
    if (this.fKL) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.fKM) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.fKN) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.fqh) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.fKO) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.fKP) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dk
 * JD-Core Version:    0.7.0.1
 */
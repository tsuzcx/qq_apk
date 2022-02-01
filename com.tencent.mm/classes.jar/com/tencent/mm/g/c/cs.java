package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJg;
  private static final int eJh;
  private static final int eJi;
  private static final int eJj = "active".hashCode();
  private static final int eJk = "lastActiveTime".hashCode();
  private static final int elb;
  private static final int eme = "username".hashCode();
  private static final int erS;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eJb = true;
  private boolean eJc = true;
  private boolean eJd = true;
  private boolean eJe = true;
  private boolean eJf = true;
  private boolean ekE = true;
  private boolean emb = true;
  private boolean erE = true;
  public int field_active;
  public String field_content;
  public String field_creator;
  public long field_firstMsgId;
  public String field_key;
  public long field_lastActiveTime;
  public long field_msgSvrId;
  public int field_num;
  public String field_username;
  
  static
  {
    elb = "content".hashCode();
    eJg = "creator".hashCode();
    eJh = "num".hashCode();
    eJi = "firstMsgId".hashCode();
    erS = "msgSvrId".hashCode();
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
      if (eme != k) {
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
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eJg == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (eJh == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (eJi == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (erS == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (eJj == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (eJk == k) {
        this.field_lastActiveTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eJb) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.eJc) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.eJd) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.erE) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.eJe) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.eJf) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cs
 * JD-Core Version:    0.7.0.1
 */
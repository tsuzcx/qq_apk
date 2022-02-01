package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class de
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFV;
  private static final int eGY = "username".hashCode();
  private static final int eMO = "msgSvrId".hashCode();
  private static final int fgn;
  private static final int fgo;
  private static final int fgp;
  private static final int fgq = "active".hashCode();
  private static final int fgr = "lastActiveTime".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eFy = true;
  private boolean eGV = true;
  private boolean eMA = true;
  private boolean fgi = true;
  private boolean fgj = true;
  private boolean fgk = true;
  private boolean fgl = true;
  private boolean fgm = true;
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
    eFV = "content".hashCode();
    fgn = "creator".hashCode();
    fgo = "num".hashCode();
    fgp = "firstMsgId".hashCode();
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
      if (eGY != k) {
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
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fgn == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (fgo == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (fgp == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (eMO == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (fgq == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (fgr == k) {
        this.field_lastActiveTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fgi) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.fgj) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.fgk) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.eMA) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.fgl) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.fgm) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.de
 * JD-Core Version:    0.7.0.1
 */
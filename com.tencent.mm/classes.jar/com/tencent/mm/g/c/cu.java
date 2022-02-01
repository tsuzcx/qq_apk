package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cu
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eLY;
  private static final int eLZ;
  private static final int eMa;
  private static final int eMb = "active".hashCode();
  private static final int eMc = "lastActiveTime".hashCode();
  private static final int eng;
  private static final int eok = "username".hashCode();
  private static final int etW;
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eLT = true;
  private boolean eLU = true;
  private boolean eLV = true;
  private boolean eLW = true;
  private boolean eLX = true;
  private boolean emI = true;
  private boolean eoh = true;
  private boolean etI = true;
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
    eng = "content".hashCode();
    eLY = "creator".hashCode();
    eLZ = "num".hashCode();
    eMa = "firstMsgId".hashCode();
    etW = "msgSvrId".hashCode();
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
      if (eok != k) {
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
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eLY == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (eLZ == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (eMa == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (etW == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (eMb == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (eMc == k) {
        this.field_lastActiveTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.eLT) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.eLU) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.eLV) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.etI) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.eLW) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.eLX) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cu
 * JD-Core Version:    0.7.0.1
 */
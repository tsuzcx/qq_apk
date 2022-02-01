package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class de
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEm;
  private static final int eFp = "username".hashCode();
  private static final int eLe = "msgSvrId".hashCode();
  private static final int feu;
  private static final int fev;
  private static final int few;
  private static final int fex = "active".hashCode();
  private static final int fey = "lastActiveTime".hashCode();
  private static final int key_HASHCODE = "key".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetkey = true;
  private boolean eDP = true;
  private boolean eFm = true;
  private boolean eKR = true;
  private boolean fep = true;
  private boolean feq = true;
  private boolean fer = true;
  private boolean fes = true;
  private boolean fet = true;
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
    eEm = "content".hashCode();
    feu = "creator".hashCode();
    fev = "num".hashCode();
    few = "firstMsgId".hashCode();
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
      if (eFp != k) {
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
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (feu == k) {
        this.field_creator = paramCursor.getString(i);
      } else if (fev == k) {
        this.field_num = paramCursor.getInt(i);
      } else if (few == k) {
        this.field_firstMsgId = paramCursor.getLong(i);
      } else if (eLe == k) {
        this.field_msgSvrId = paramCursor.getLong(i);
      } else if (fex == k) {
        this.field_active = paramCursor.getInt(i);
      } else if (fey == k) {
        this.field_lastActiveTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetkey) {
      localContentValues.put("key", this.field_key);
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.fep) {
      localContentValues.put("creator", this.field_creator);
    }
    if (this.feq) {
      localContentValues.put("num", Integer.valueOf(this.field_num));
    }
    if (this.fer) {
      localContentValues.put("firstMsgId", Long.valueOf(this.field_firstMsgId));
    }
    if (this.eKR) {
      localContentValues.put("msgSvrId", Long.valueOf(this.field_msgSvrId));
    }
    if (this.fes) {
      localContentValues.put("active", Integer.valueOf(this.field_active));
    }
    if (this.fet) {
      localContentValues.put("lastActiveTime", Long.valueOf(this.field_lastActiveTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.de
 * JD-Core Version:    0.7.0.1
 */
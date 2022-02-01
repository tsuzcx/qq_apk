package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int eGl;
  private static final int eMy;
  private static final int eQH;
  private static final int eQN = "encryptUsername".hashCode();
  private static final int fpp = "oldUsername".hashCode();
  private static final int fpq;
  private static final int fpr;
  private static final int fpt = "seq".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean eGj = true;
  private boolean eMu = true;
  private boolean eQp = true;
  private boolean eQv = true;
  public int field_addState;
  public String field_encryptUsername;
  public String field_nickname;
  public String field_oldUsername;
  public String field_pinyinName;
  public int field_seq;
  public int field_showHead;
  public String field_ticket;
  public String field_username;
  private boolean fpl = true;
  private boolean fpm = true;
  private boolean fpn = true;
  private boolean fpo = true;
  
  static
  {
    eGl = "ticket".hashCode();
    eMy = "nickname".hashCode();
    fpq = "addState".hashCode();
    eQH = "showHead".hashCode();
    fpr = "pinyinName".hashCode();
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
      if (eQN != k) {
        break label60;
      }
      this.field_encryptUsername = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fpp == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (eGl == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fpq == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (eQH == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (fpr == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fpt == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eQv) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.fpl) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.eGj) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fpm) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.eQp) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.fpn) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fpo) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.eq
 * JD-Core Version:    0.7.0.1
 */
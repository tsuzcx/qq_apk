package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEC;
  private static final int eFp = "username".hashCode();
  private static final int eKP;
  private static final int eOW;
  private static final int ePc = "encryptUsername".hashCode();
  private static final int fnp = "oldUsername".hashCode();
  private static final int fnq;
  private static final int fnr;
  private static final int fns = "seq".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEA = true;
  private boolean eFm = true;
  private boolean eKL = true;
  private boolean eOE = true;
  private boolean eOK = true;
  public int field_addState;
  public String field_encryptUsername;
  public String field_nickname;
  public String field_oldUsername;
  public String field_pinyinName;
  public int field_seq;
  public int field_showHead;
  public String field_ticket;
  public String field_username;
  private boolean fnl = true;
  private boolean fnm = true;
  private boolean fnn = true;
  private boolean fno = true;
  
  static
  {
    eEC = "ticket".hashCode();
    eKP = "nickname".hashCode();
    fnq = "addState".hashCode();
    eOW = "showHead".hashCode();
    fnr = "pinyinName".hashCode();
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
      if (ePc != k) {
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
      if (fnp == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (eEC == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fnq == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (eOW == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (fnr == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fns == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eOK) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.fnl) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.eEA) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fnm) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.eOE) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.fnn) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fno) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eq
 * JD-Core Version:    0.7.0.1
 */
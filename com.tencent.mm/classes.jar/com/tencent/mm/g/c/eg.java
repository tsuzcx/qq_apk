package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVa;
  private static final int eVb;
  private static final int eVc;
  private static final int eVd = "seq".hashCode();
  private static final int enw;
  private static final int eok;
  private static final int etG;
  private static final int exD = "encryptUsername".hashCode();
  private static final int exx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eUW = true;
  private boolean eUX = true;
  private boolean eUY = true;
  private boolean eUZ = true;
  private boolean enu = true;
  private boolean eoh = true;
  private boolean etC = true;
  private boolean exf = true;
  private boolean exl = true;
  public int field_addState;
  public String field_encryptUsername;
  public String field_nickname;
  public String field_oldUsername;
  public String field_pinyinName;
  public int field_seq;
  public int field_showHead;
  public String field_ticket;
  public String field_username;
  
  static
  {
    eVa = "oldUsername".hashCode();
    enw = "ticket".hashCode();
    etG = "nickname".hashCode();
    eVb = "addState".hashCode();
    exx = "showHead".hashCode();
    eVc = "pinyinName".hashCode();
    eok = "username".hashCode();
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
      if (exD != k) {
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
      if (eVa == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (enw == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (etG == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eVb == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (exx == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (eVc == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eVd == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.exl) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.eUW) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.enu) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eUX) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.exf) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.eUY) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eUZ) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.eg
 * JD-Core Version:    0.7.0.1
 */
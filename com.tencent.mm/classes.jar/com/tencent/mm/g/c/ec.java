package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRQ;
  private static final int eRR;
  private static final int eRS;
  private static final int eRT = "seq".hashCode();
  private static final int elr;
  private static final int eme;
  private static final int erC;
  private static final int evb;
  private static final int evh = "encryptUsername".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRM = true;
  private boolean eRN = true;
  private boolean eRO = true;
  private boolean eRP = true;
  private boolean elp = true;
  private boolean emb = true;
  private boolean ery = true;
  private boolean euJ = true;
  private boolean euP = true;
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
    eRQ = "oldUsername".hashCode();
    elr = "ticket".hashCode();
    erC = "nickname".hashCode();
    eRR = "addState".hashCode();
    evb = "showHead".hashCode();
    eRS = "pinyinName".hashCode();
    eme = "username".hashCode();
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
      if (evh != k) {
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
      if (eRQ == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (elr == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eRR == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (evb == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (eRS == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eRT == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.euP) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.eRM) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.elp) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eRN) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.euJ) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.eRO) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eRP) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ec
 * JD-Core Version:    0.7.0.1
 */
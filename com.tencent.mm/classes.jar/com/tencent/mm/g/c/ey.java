package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ey
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fTV;
  private static final int fTW;
  private static final int fTX;
  private static final int fTY = "seq".hashCode();
  private static final int fjR;
  private static final int fqf;
  private static final int fum;
  private static final int fus = "encryptUsername".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  private boolean fTR = true;
  private boolean fTS = true;
  private boolean fTT = true;
  private boolean fTU = true;
  public int field_addState;
  public String field_encryptUsername;
  public String field_nickname;
  public String field_oldUsername;
  public String field_pinyinName;
  public int field_seq;
  public int field_showHead;
  public String field_ticket;
  public String field_username;
  private boolean fjP = true;
  private boolean fqb = true;
  private boolean ftU = true;
  private boolean fua = true;
  
  static
  {
    fTV = "oldUsername".hashCode();
    fjR = "ticket".hashCode();
    fqf = "nickname".hashCode();
    fTW = "addState".hashCode();
    fum = "showHead".hashCode();
    fTX = "pinyinName".hashCode();
    username_HASHCODE = "username".hashCode();
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
      if (fus != k) {
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
      if (fTV == k) {
        this.field_oldUsername = paramCursor.getString(i);
      } else if (fjR == k) {
        this.field_ticket = paramCursor.getString(i);
      } else if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fTW == k) {
        this.field_addState = paramCursor.getInt(i);
      } else if (fum == k) {
        this.field_showHead = paramCursor.getInt(i);
      } else if (fTX == k) {
        this.field_pinyinName = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fTY == k) {
        this.field_seq = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fua) {
      localContentValues.put("encryptUsername", this.field_encryptUsername);
    }
    if (this.fTR) {
      localContentValues.put("oldUsername", this.field_oldUsername);
    }
    if (this.fjP) {
      localContentValues.put("ticket", this.field_ticket);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fTS) {
      localContentValues.put("addState", Integer.valueOf(this.field_addState));
    }
    if (this.ftU) {
      localContentValues.put("showHead", Integer.valueOf(this.field_showHead));
    }
    if (this.fTT) {
      localContentValues.put("pinyinName", this.field_pinyinName);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fTU) {
      localContentValues.put("seq", Integer.valueOf(this.field_seq));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ey
 * JD-Core Version:    0.7.0.1
 */
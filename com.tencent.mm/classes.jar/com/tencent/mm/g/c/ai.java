package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emW;
  private static final int erZ;
  private static final int erw;
  private static final int esd;
  private static final int ese = "bitFlag".hashCode();
  private static final int esi = "addMemberUrl".hashCode();
  private static final int esl = "userId".hashCode();
  private static final int esp;
  private static final int esq;
  private static final int esr;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emz = true;
  private boolean erM = true;
  private boolean erQ = true;
  private boolean erR = true;
  private boolean erV = true;
  private boolean erh = true;
  private boolean esk = true;
  private boolean esm = true;
  private boolean esn = true;
  private boolean eso = true;
  public int field_UserVersion;
  public String field_addMemberUrl;
  public int field_bitFlag;
  public String field_brandUserName;
  public String field_headImageUrl;
  public boolean field_needToUpdate;
  public String field_profileUrl;
  public String field_userId;
  public String field_userName;
  public String field_userNamePY;
  
  static
  {
    emW = "userName".hashCode();
    esp = "userNamePY".hashCode();
    erw = "brandUserName".hashCode();
    esq = "UserVersion".hashCode();
    esd = "needToUpdate".hashCode();
    erZ = "headImageUrl".hashCode();
    esr = "profileUrl".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (esl != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.esk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (emW == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (esp == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (erw == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (esq == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (esd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (erZ == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (esr == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (ese == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (esi == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.esk) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.emz) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.esm) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.erh) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.esn) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.erQ) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.erM) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.eso) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.erR) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.erV) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ai
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFM;
  private static final int eKR;
  private static final int eKV;
  private static final int eKW = "bitFlag".hashCode();
  private static final int eKo;
  private static final int eLa = "addMemberUrl".hashCode();
  private static final int eLd = "userId".hashCode();
  private static final int eLh;
  private static final int eLi;
  private static final int eLj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFp = true;
  private boolean eJZ = true;
  private boolean eKE = true;
  private boolean eKI = true;
  private boolean eKJ = true;
  private boolean eKN = true;
  private boolean eLc = true;
  private boolean eLe = true;
  private boolean eLf = true;
  private boolean eLg = true;
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
    eFM = "userName".hashCode();
    eLh = "userNamePY".hashCode();
    eKo = "brandUserName".hashCode();
    eLi = "UserVersion".hashCode();
    eKV = "needToUpdate".hashCode();
    eKR = "headImageUrl".hashCode();
    eLj = "profileUrl".hashCode();
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
      if (eLd != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.eLc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFM == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (eLh == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (eKo == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (eLi == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (eKV == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (eKR == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (eLj == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (eKW == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (eLa == k) {
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
    if (this.eLc) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.eFp) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.eLe) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.eJZ) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eLf) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.eKI) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.eKE) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.eLg) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.eKJ) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.eKN) {
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
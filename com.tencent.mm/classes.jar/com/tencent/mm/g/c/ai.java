package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEd;
  private static final int eIF;
  private static final int eJA = "profileUrl".hashCode();
  private static final int eJi;
  private static final int eJm;
  private static final int eJn = "bitFlag".hashCode();
  private static final int eJr = "addMemberUrl".hashCode();
  private static final int eJu = "userId".hashCode();
  private static final int eJy;
  private static final int eJz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDG = true;
  private boolean eIV = true;
  private boolean eIZ = true;
  private boolean eIq = true;
  private boolean eJa = true;
  private boolean eJe = true;
  private boolean eJt = true;
  private boolean eJv = true;
  private boolean eJw = true;
  private boolean eJx = true;
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
    eEd = "userName".hashCode();
    eJy = "userNamePY".hashCode();
    eIF = "brandUserName".hashCode();
    eJz = "UserVersion".hashCode();
    eJm = "needToUpdate".hashCode();
    eJi = "headImageUrl".hashCode();
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
      if (eJu != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.eJt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEd == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (eJy == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (eIF == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (eJz == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (eJm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (eJi == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (eJA == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (eJn == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (eJr == k) {
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
    if (this.eJt) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.eDG) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.eJv) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.eIq) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eJw) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.eIZ) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.eIV) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.eJx) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.eJa) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.eJe) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ai
 * JD-Core Version:    0.7.0.1
 */
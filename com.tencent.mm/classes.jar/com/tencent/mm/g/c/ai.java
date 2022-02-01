package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ai
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ekS;
  private static final int epV;
  private static final int epZ;
  private static final int eps;
  private static final int eqa = "bitFlag".hashCode();
  private static final int eqe = "addMemberUrl".hashCode();
  private static final int eqh = "userId".hashCode();
  private static final int eql;
  private static final int eqm;
  private static final int eqn;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ekv = true;
  private boolean epI = true;
  private boolean epM = true;
  private boolean epN = true;
  private boolean epR = true;
  private boolean epd = true;
  private boolean eqg = true;
  private boolean eqi = true;
  private boolean eqj = true;
  private boolean eqk = true;
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
    ekS = "userName".hashCode();
    eql = "userNamePY".hashCode();
    eps = "brandUserName".hashCode();
    eqm = "UserVersion".hashCode();
    epZ = "needToUpdate".hashCode();
    epV = "headImageUrl".hashCode();
    eqn = "profileUrl".hashCode();
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
      if (eqh != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.eqg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ekS == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (eql == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (eps == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (eqm == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (epZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (epV == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (eqn == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (eqa == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (eqe == k) {
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
    if (this.eqg) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.ekv) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.eqi) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.epd) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.eqj) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.epM) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.epI) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.eqk) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.epN) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.epR) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ai
 * JD-Core Version:    0.7.0.1
 */
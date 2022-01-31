package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ad
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dgK;
  private static final int dkU;
  private static final int dlA = "bitFlag".hashCode();
  private static final int dlE = "addMemberUrl".hashCode();
  private static final int dlG = "userId".hashCode();
  private static final int dlK;
  private static final int dlL;
  private static final int dlM;
  private static final int dlv;
  private static final int dlz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dgn = true;
  private boolean dkG = true;
  private boolean dlF = true;
  private boolean dlH = true;
  private boolean dlI = true;
  private boolean dlJ = true;
  private boolean dlj = true;
  private boolean dln = true;
  private boolean dlo = true;
  private boolean dls = true;
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
    dgK = "userName".hashCode();
    dlK = "userNamePY".hashCode();
    dkU = "brandUserName".hashCode();
    dlL = "UserVersion".hashCode();
    dlz = "needToUpdate".hashCode();
    dlv = "headImageUrl".hashCode();
    dlM = "profileUrl".hashCode();
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
      if (dlG != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.dlF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dgK == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (dlK == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (dkU == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (dlL == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (dlz == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (dlv == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (dlM == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (dlA == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (dlE == k) {
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
    if (this.dlF) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.dgn) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.dlH) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.dkG) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.dlI) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.dln) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.dlj) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.dlJ) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.dlo) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.dls) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ad
 * JD-Core Version:    0.7.0.1
 */
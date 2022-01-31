package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ac
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cst;
  private static final int cwT;
  private static final int cxD;
  private static final int cxF = "userId".hashCode();
  private static final int cxJ;
  private static final int cxK;
  private static final int cxL;
  private static final int cxu;
  private static final int cxy;
  private static final int cxz;
  private boolean crV = true;
  private boolean cwF = true;
  private boolean cxE = true;
  private boolean cxG = true;
  private boolean cxH = true;
  private boolean cxI = true;
  private boolean cxi = true;
  private boolean cxm = true;
  private boolean cxn = true;
  private boolean cxr = true;
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
    cst = "userName".hashCode();
    cxJ = "userNamePY".hashCode();
    cwT = "brandUserName".hashCode();
    cxK = "UserVersion".hashCode();
    cxy = "needToUpdate".hashCode();
    cxu = "headImageUrl".hashCode();
    cxL = "profileUrl".hashCode();
    cxz = "bitFlag".hashCode();
    cxD = "addMemberUrl".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cxF != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.cxE = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cst == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (cxJ == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (cwT == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (cxK == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (cxy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (cxu == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (cxL == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (cxz == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (cxD == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cxE) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.crV) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.cxG) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.cwF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.cxH) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.cxm) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.cxi) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.cxI) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.cxn) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.cxr) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.c.ac
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class aj
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fnU;
  private static final int foB;
  private static final int foC = "bitFlag".hashCode();
  private static final int foG = "addMemberUrl".hashCode();
  private static final int foJ = "userId".hashCode();
  private static final int foN;
  private static final int foO;
  private static final int foP;
  private static final int fox;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int userName_HASHCODE = "userName".hashCode();
  private boolean __hadSetuserName = true;
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
  private boolean fnF = true;
  private boolean foI = true;
  private boolean foK = true;
  private boolean foL = true;
  private boolean foM = true;
  private boolean fok = true;
  private boolean foo = true;
  private boolean fop = true;
  private boolean fot = true;
  
  static
  {
    foN = "userNamePY".hashCode();
    fnU = "brandUserName".hashCode();
    foO = "UserVersion".hashCode();
    foB = "needToUpdate".hashCode();
    fox = "headImageUrl".hashCode();
    foP = "profileUrl".hashCode();
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
      if (foJ != k) {
        break label65;
      }
      this.field_userId = paramCursor.getString(i);
      this.foI = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (userName_HASHCODE == k)
      {
        this.field_userName = paramCursor.getString(i);
      }
      else if (foN == k)
      {
        this.field_userNamePY = paramCursor.getString(i);
      }
      else if (fnU == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (foO == k)
      {
        this.field_UserVersion = paramCursor.getInt(i);
      }
      else
      {
        if (foB == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needToUpdate = bool;
            break;
          }
        }
        if (fox == k) {
          this.field_headImageUrl = paramCursor.getString(i);
        } else if (foP == k) {
          this.field_profileUrl = paramCursor.getString(i);
        } else if (foC == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (foG == k) {
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
    if (this.foI) {
      localContentValues.put("userId", this.field_userId);
    }
    if (this.field_userName == null) {
      this.field_userName = "";
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.field_userNamePY == null) {
      this.field_userNamePY = "";
    }
    if (this.foK) {
      localContentValues.put("userNamePY", this.field_userNamePY);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.fnF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.foL) {
      localContentValues.put("UserVersion", Integer.valueOf(this.field_UserVersion));
    }
    if (this.foo) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.fok) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.foM) {
      localContentValues.put("profileUrl", this.field_profileUrl);
    }
    if (this.fop) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.fot) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.aj
 * JD-Core Version:    0.7.0.1
 */
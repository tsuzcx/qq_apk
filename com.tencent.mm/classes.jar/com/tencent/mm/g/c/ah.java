package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class ah
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fnU;
  private static final int foA = "chatVersion".hashCode();
  private static final int foB = "needToUpdate".hashCode();
  private static final int foC = "bitFlag".hashCode();
  private static final int foD = "maxMemberCnt".hashCode();
  private static final int foE = "ownerUserId".hashCode();
  private static final int foF = "userList".hashCode();
  private static final int foG = "addMemberUrl".hashCode();
  private static final int foH = "roomflag".hashCode();
  private static final int fod;
  private static final int fov = "bizChatLocalId".hashCode();
  private static final int fow = "bizChatServId".hashCode();
  private static final int fox;
  private static final int foy;
  private static final int foz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_addMemberUrl;
  public int field_bitFlag;
  public long field_bizChatLocalId;
  public String field_bizChatServId;
  public String field_brandUserName;
  public String field_chatName;
  public String field_chatNamePY;
  public int field_chatType;
  public int field_chatVersion;
  public String field_headImageUrl;
  public int field_maxMemberCnt;
  public boolean field_needToUpdate;
  public String field_ownerUserId;
  public int field_roomflag;
  public String field_userList;
  private boolean fnF = true;
  private boolean fnO = true;
  private boolean foi = true;
  private boolean foj = true;
  private boolean fok = true;
  private boolean fol = true;
  private boolean fom = true;
  private boolean fon = true;
  private boolean foo = true;
  private boolean fop = true;
  private boolean foq = true;
  private boolean jdField_for = true;
  private boolean fos = true;
  private boolean fot = true;
  private boolean fou = true;
  
  static
  {
    fnU = "brandUserName".hashCode();
    fod = "chatType".hashCode();
    fox = "headImageUrl".hashCode();
    foy = "chatName".hashCode();
    foz = "chatNamePY".hashCode();
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
      if (fov != k) {
        break label65;
      }
      this.field_bizChatLocalId = paramCursor.getLong(i);
      this.foi = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fow == k)
      {
        this.field_bizChatServId = paramCursor.getString(i);
      }
      else if (fnU == k)
      {
        this.field_brandUserName = paramCursor.getString(i);
      }
      else if (fod == k)
      {
        this.field_chatType = paramCursor.getInt(i);
      }
      else if (fox == k)
      {
        this.field_headImageUrl = paramCursor.getString(i);
      }
      else if (foy == k)
      {
        this.field_chatName = paramCursor.getString(i);
      }
      else if (foz == k)
      {
        this.field_chatNamePY = paramCursor.getString(i);
      }
      else if (foA == k)
      {
        this.field_chatVersion = paramCursor.getInt(i);
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
        if (foC == k) {
          this.field_bitFlag = paramCursor.getInt(i);
        } else if (foD == k) {
          this.field_maxMemberCnt = paramCursor.getInt(i);
        } else if (foE == k) {
          this.field_ownerUserId = paramCursor.getString(i);
        } else if (foF == k) {
          this.field_userList = paramCursor.getString(i);
        } else if (foG == k) {
          this.field_addMemberUrl = paramCursor.getString(i);
        } else if (foH == k) {
          this.field_roomflag = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.foi) {
      localContentValues.put("bizChatLocalId", Long.valueOf(this.field_bizChatLocalId));
    }
    if (this.foj) {
      localContentValues.put("bizChatServId", this.field_bizChatServId);
    }
    if (this.field_brandUserName == null) {
      this.field_brandUserName = "";
    }
    if (this.fnF) {
      localContentValues.put("brandUserName", this.field_brandUserName);
    }
    if (this.fnO) {
      localContentValues.put("chatType", Integer.valueOf(this.field_chatType));
    }
    if (this.fok) {
      localContentValues.put("headImageUrl", this.field_headImageUrl);
    }
    if (this.field_chatName == null) {
      this.field_chatName = "";
    }
    if (this.fol) {
      localContentValues.put("chatName", this.field_chatName);
    }
    if (this.field_chatNamePY == null) {
      this.field_chatNamePY = "";
    }
    if (this.fom) {
      localContentValues.put("chatNamePY", this.field_chatNamePY);
    }
    if (this.fon) {
      localContentValues.put("chatVersion", Integer.valueOf(this.field_chatVersion));
    }
    if (this.foo) {
      localContentValues.put("needToUpdate", Boolean.valueOf(this.field_needToUpdate));
    }
    if (this.fop) {
      localContentValues.put("bitFlag", Integer.valueOf(this.field_bitFlag));
    }
    if (this.foq) {
      localContentValues.put("maxMemberCnt", Integer.valueOf(this.field_maxMemberCnt));
    }
    if (this.jdField_for) {
      localContentValues.put("ownerUserId", this.field_ownerUserId);
    }
    if (this.fos) {
      localContentValues.put("userList", this.field_userList);
    }
    if (this.fot) {
      localContentValues.put("addMemberUrl", this.field_addMemberUrl);
    }
    if (this.fou) {
      localContentValues.put("roomflag", Integer.valueOf(this.field_roomflag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ah
 * JD-Core Version:    0.7.0.1
 */
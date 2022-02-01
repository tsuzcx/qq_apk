package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class am
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fmt = "openId".hashCode();
  private static final int fqd = "brandUsername".hashCode();
  private static final int fqe = "headImgUrl".hashCode();
  private static final int fqf = "nickname".hashCode();
  private static final int fqg = "kfType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE = "updateTime".hashCode();
  private boolean __hadSetupdateTime = true;
  public String field_brandUsername;
  public String field_headImgUrl;
  public int field_kfType;
  public String field_nickname;
  public String field_openId;
  public long field_updateTime;
  private boolean flX = true;
  private boolean fpZ = true;
  private boolean fqa = true;
  private boolean fqb = true;
  private boolean fqc = true;
  
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
      if (fmt != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.flX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqd == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (fqe == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fqg == k) {
        this.field_kfType = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.flX) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.fpZ) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.fqa) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fqc) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.am
 * JD-Core Version:    0.7.0.1
 */
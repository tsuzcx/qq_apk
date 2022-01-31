package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ag
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhV = "updateTime".hashCode();
  private static final int djy = "openId".hashCode();
  private static final int dmR = "brandUsername".hashCode();
  private static final int dmS = "headImgUrl".hashCode();
  private static final int dmT = "nickname".hashCode();
  private static final int dmU = "kfType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhT = true;
  private boolean djb = true;
  private boolean dmN = true;
  private boolean dmO = true;
  private boolean dmP = true;
  private boolean dmQ = true;
  public String field_brandUsername;
  public String field_headImgUrl;
  public int field_kfType;
  public String field_nickname;
  public String field_openId;
  public long field_updateTime;
  
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
      if (djy != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.djb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dmR == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (dmS == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (dmT == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (dmU == k) {
        this.field_kfType = paramCursor.getInt(i);
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.djb) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.dmN) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.dmO) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.dmP) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.dmQ) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.dhT) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ag
 * JD-Core Version:    0.7.0.1
 */
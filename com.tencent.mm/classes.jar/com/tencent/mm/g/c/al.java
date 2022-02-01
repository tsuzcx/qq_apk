package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGZ = "updateTime".hashCode();
  private static final int eIR = "openId".hashCode();
  private static final int eMw = "brandUsername".hashCode();
  private static final int eMx = "headImgUrl".hashCode();
  private static final int eMy = "nickname".hashCode();
  private static final int eMz = "kfType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  private boolean eIv = true;
  private boolean eMs = true;
  private boolean eMt = true;
  private boolean eMu = true;
  private boolean eMv = true;
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
      if (eIR != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.eIv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMw == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (eMx == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eMz == k) {
        this.field_kfType = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eIv) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.eMs) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.eMt) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eMv) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.al
 * JD-Core Version:    0.7.0.1
 */
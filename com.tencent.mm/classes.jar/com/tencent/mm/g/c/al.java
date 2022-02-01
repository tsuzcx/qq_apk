package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class al
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int emf = "updateTime".hashCode();
  private static final int enU = "openId".hashCode();
  private static final int erA = "brandUsername".hashCode();
  private static final int erB = "headImgUrl".hashCode();
  private static final int erC = "nickname".hashCode();
  private static final int erD = "kfType".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emc = true;
  private boolean eny = true;
  private boolean erw = true;
  private boolean erx = true;
  private boolean ery = true;
  private boolean erz = true;
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
      if (enU != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.eny = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (erA == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (erB == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (erD == k) {
        this.field_kfType = paramCursor.getInt(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eny) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.erw) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.erx) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.erz) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.emc) {
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
package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class af
  extends c
{
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctG;
  private static final int cvm = "openId".hashCode();
  private static final int cyQ = "brandUsername".hashCode();
  private static final int cyR = "headImgUrl".hashCode();
  private static final int cyS = "nickname".hashCode();
  private static final int cyT = "kfType".hashCode();
  private boolean ctE = true;
  private boolean cuP = true;
  private boolean cyM = true;
  private boolean cyN = true;
  private boolean cyO = true;
  private boolean cyP = true;
  public String field_brandUsername;
  public String field_headImgUrl;
  public int field_kfType;
  public String field_nickname;
  public String field_openId;
  public long field_updateTime;
  
  static
  {
    ctG = "updateTime".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cvm != k) {
        break label65;
      }
      this.field_openId = paramCursor.getString(i);
      this.cuP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cyQ == k) {
        this.field_brandUsername = paramCursor.getString(i);
      } else if (cyR == k) {
        this.field_headImgUrl = paramCursor.getString(i);
      } else if (cyS == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (cyT == k) {
        this.field_kfType = paramCursor.getInt(i);
      } else if (ctG == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cuP) {
      localContentValues.put("openId", this.field_openId);
    }
    if (this.field_brandUsername == null) {
      this.field_brandUsername = "";
    }
    if (this.cyM) {
      localContentValues.put("brandUsername", this.field_brandUsername);
    }
    if (this.cyN) {
      localContentValues.put("headImgUrl", this.field_headImgUrl);
    }
    if (this.cyO) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.cyP) {
      localContentValues.put("kfType", Integer.valueOf(this.field_kfType));
    }
    if (this.ctE) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.af
 * JD-Core Version:    0.7.0.1
 */
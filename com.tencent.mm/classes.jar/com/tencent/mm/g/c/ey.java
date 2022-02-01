package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ey
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKE = "score".hashCode();
  private static final int eVg;
  private static final int eVh;
  private static final int eVi;
  private static final int eVj;
  private static final int eVk;
  private static final int eVl;
  private static final int ejK = "chatroom".hashCode();
  private static final int ept;
  private static final int erC;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKD = true;
  private boolean eVa = true;
  private boolean eVb = true;
  private boolean eVc = true;
  private boolean eVd = true;
  private boolean eVe = true;
  private boolean eVf = true;
  private boolean ejG = true;
  private boolean epe = true;
  private boolean ery = true;
  public String field_chatroom;
  public String field_daySec;
  public int field_disRedDotCount;
  public int field_enterCount;
  public int field_isMute;
  public String field_nickname;
  public float field_score;
  public int field_sendCount;
  public long field_stayTime;
  public int field_unReadCount;
  
  static
  {
    eVg = "daySec".hashCode();
    erC = "nickname".hashCode();
    eVh = "isMute".hashCode();
    ept = "unReadCount".hashCode();
    eVi = "sendCount".hashCode();
    eVj = "enterCount".hashCode();
    eVk = "disRedDotCount".hashCode();
    eVl = "stayTime".hashCode();
  }
  
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
      if (ejK != k) {
        break label60;
      }
      this.field_chatroom = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eVg == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (erC == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eVh == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (ept == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eVi == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (eVj == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (eVk == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (eVl == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (eKE == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ejG) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.eVa) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.ery) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eVb) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.epe) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eVc) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.eVd) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.eVe) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.eVf) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.eKD) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ey
 * JD-Core Version:    0.7.0.1
 */
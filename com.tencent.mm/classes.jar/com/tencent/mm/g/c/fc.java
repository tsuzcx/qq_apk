package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNw = "score".hashCode();
  private static final int eYs;
  private static final int eYt;
  private static final int eYu;
  private static final int eYv;
  private static final int eYw;
  private static final int eYx;
  private static final int elO = "chatroom".hashCode();
  private static final int erx;
  private static final int etG;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNv = true;
  private boolean eYm = true;
  private boolean eYn = true;
  private boolean eYo = true;
  private boolean eYp = true;
  private boolean eYq = true;
  private boolean eYr = true;
  private boolean elK = true;
  private boolean eri = true;
  private boolean etC = true;
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
    eYs = "daySec".hashCode();
    etG = "nickname".hashCode();
    eYt = "isMute".hashCode();
    erx = "unReadCount".hashCode();
    eYu = "sendCount".hashCode();
    eYv = "enterCount".hashCode();
    eYw = "disRedDotCount".hashCode();
    eYx = "stayTime".hashCode();
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
      if (elO != k) {
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
      if (eYs == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (etG == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (eYt == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (erx == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (eYu == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (eYv == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (eYw == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (eYx == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (eNw == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.elK) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.eYm) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.etC) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.eYn) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.eri) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.eYo) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.eYp) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.eYq) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.eYr) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.eNv) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.fc
 * JD-Core Version:    0.7.0.1
 */
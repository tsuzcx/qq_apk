package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ds
  extends c
{
  private static final int cNk = "score".hashCode();
  private static final int cWd;
  private static final int cWe;
  private static final int cWf;
  private static final int cWg;
  private static final int cWh;
  private static final int cWi;
  public static final String[] cqY = new String[0];
  private static final int crf = "chatroom".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int cwU;
  private static final int cyS;
  private boolean cNj = true;
  private boolean cVX = true;
  private boolean cVY = true;
  private boolean cVZ = true;
  private boolean cWa = true;
  private boolean cWb = true;
  private boolean cWc = true;
  private boolean crb = true;
  private boolean cwG = true;
  private boolean cyO = true;
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
    cWd = "daySec".hashCode();
    cyS = "nickname".hashCode();
    cWe = "isMute".hashCode();
    cwU = "unReadCount".hashCode();
    cWf = "sendCount".hashCode();
    cWg = "enterCount".hashCode();
    cWh = "disRedDotCount".hashCode();
    cWi = "stayTime".hashCode();
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
      if (crf != k) {
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
      if (cWd == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (cyS == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (cWe == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (cwU == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (cWf == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (cWg == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (cWh == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (cWi == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (cNk == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crb) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.cVX) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.cyO) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.cVY) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.cwG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.cVZ) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.cWa) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.cWb) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.cWc) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.cNj) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.ds
 * JD-Core Version:    0.7.0.1
 */
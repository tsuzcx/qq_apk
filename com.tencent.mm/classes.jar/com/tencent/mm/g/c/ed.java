package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ed
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dDa = "score".hashCode();
  private static final int dMp;
  private static final int dMq;
  private static final int dMr;
  private static final int dMs;
  private static final int dMt;
  private static final int dMu;
  private static final int dfC = "chatroom".hashCode();
  private static final int dkV;
  private static final int dmT;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dCZ = true;
  private boolean dMj = true;
  private boolean dMk = true;
  private boolean dMl = true;
  private boolean dMm = true;
  private boolean dMn = true;
  private boolean dMo = true;
  private boolean dfy = true;
  private boolean dkH = true;
  private boolean dmP = true;
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
    dMp = "daySec".hashCode();
    dmT = "nickname".hashCode();
    dMq = "isMute".hashCode();
    dkV = "unReadCount".hashCode();
    dMr = "sendCount".hashCode();
    dMs = "enterCount".hashCode();
    dMt = "disRedDotCount".hashCode();
    dMu = "stayTime".hashCode();
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
      if (dfC != k) {
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
      if (dMp == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (dmT == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (dMq == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (dkV == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (dMr == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (dMs == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (dMt == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (dMu == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (dDa == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfy) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.dMj) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.dmP) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.dMk) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.dkH) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.dMl) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.dMm) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.dMn) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.dMo) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.dCZ) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ed
 * JD-Core Version:    0.7.0.1
 */
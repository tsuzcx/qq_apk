package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEE = "chatroom".hashCode();
  private static final int eKp;
  private static final int eMy;
  private static final int fhP = "score".hashCode();
  private static final int fsI = "daySec".hashCode();
  private static final int fsJ;
  private static final int fsK;
  private static final int fsL;
  private static final int fsM;
  private static final int fsN;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEA = true;
  private boolean eKa = true;
  private boolean eMu = true;
  private boolean fhO = true;
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
  private boolean fsC = true;
  private boolean fsD = true;
  private boolean fsE = true;
  private boolean fsF = true;
  private boolean fsG = true;
  private boolean fsH = true;
  
  static
  {
    eMy = "nickname".hashCode();
    fsJ = "isMute".hashCode();
    eKp = "unReadCount".hashCode();
    fsK = "sendCount".hashCode();
    fsL = "enterCount".hashCode();
    fsM = "disRedDotCount".hashCode();
    fsN = "stayTime".hashCode();
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
      if (eEE != k) {
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
      if (fsI == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (eMy == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fsJ == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (eKp == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (fsK == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (fsL == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (fsM == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (fsN == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (fhP == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eEA) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.fsC) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.eMu) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fsD) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.eKa) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.fsE) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.fsF) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.fsG) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.fsH) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.fhO) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.fm
 * JD-Core Version:    0.7.0.1
 */
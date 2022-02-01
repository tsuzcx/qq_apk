package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCV = "chatroom".hashCode();
  private static final int eIG;
  private static final int eKP;
  private static final int ffS = "score".hashCode();
  private static final int fqI = "daySec".hashCode();
  private static final int fqJ;
  private static final int fqK;
  private static final int fqL;
  private static final int fqM;
  private static final int fqN;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCR = true;
  private boolean eIr = true;
  private boolean eKL = true;
  private boolean ffR = true;
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
  private boolean fqC = true;
  private boolean fqD = true;
  private boolean fqE = true;
  private boolean fqF = true;
  private boolean fqG = true;
  private boolean fqH = true;
  
  static
  {
    eKP = "nickname".hashCode();
    fqJ = "isMute".hashCode();
    eIG = "unReadCount".hashCode();
    fqK = "sendCount".hashCode();
    fqL = "enterCount".hashCode();
    fqM = "disRedDotCount".hashCode();
    fqN = "stayTime".hashCode();
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
      if (eCV != k) {
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
      if (fqI == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (eKP == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fqJ == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (eIG == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (fqK == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (fqL == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (fqM == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (fqN == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (ffS == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eCR) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.fqC) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.eKL) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fqD) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.eIr) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.fqE) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.fqF) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.fqG) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.fqH) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.ffR) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fm
 * JD-Core Version:    0.7.0.1
 */
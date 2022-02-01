package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class fu
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fMs = "score".hashCode();
  private static final int fXn;
  private static final int fXo;
  private static final int fXp;
  private static final int fXq;
  private static final int fXr;
  private static final int fXs;
  private static final int fje = "chatroom".hashCode();
  private static final int fnV;
  private static final int fqf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fMr = true;
  private boolean fXh = true;
  private boolean fXi = true;
  private boolean fXj = true;
  private boolean fXk = true;
  private boolean fXl = true;
  private boolean fXm = true;
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
  private boolean fja = true;
  private boolean fnG = true;
  private boolean fqb = true;
  
  static
  {
    fXn = "daySec".hashCode();
    fqf = "nickname".hashCode();
    fXo = "isMute".hashCode();
    fnV = "unReadCount".hashCode();
    fXp = "sendCount".hashCode();
    fXq = "enterCount".hashCode();
    fXr = "disRedDotCount".hashCode();
    fXs = "stayTime".hashCode();
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
      if (fje != k) {
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
      if (fXn == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (fqf == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (fXo == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (fnV == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (fXp == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (fXq == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (fXr == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (fXs == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (fMs == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fja) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.fXh) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.fqb) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.fXi) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.fnG) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.fXj) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.fXk) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.fXl) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.fXm) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.fMr) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.fu
 * JD-Core Version:    0.7.0.1
 */
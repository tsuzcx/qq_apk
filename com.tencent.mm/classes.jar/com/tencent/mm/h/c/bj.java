package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bj
  extends c
{
  private static final int cHa;
  private static final int cHs;
  private static final int cHt;
  private static final int cHu = "chatroomName".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int csy;
  private static final int cxd;
  private static final int czg;
  private boolean cGL = true;
  private boolean cHp = true;
  private boolean cHq = true;
  private boolean cHr = true;
  private boolean crX = true;
  private boolean csa = true;
  private boolean cwP = true;
  private boolean cyV = true;
  public String field_chatroomName;
  public long field_createTime;
  public String field_encryptTalker;
  public int field_isSend;
  public String field_msgContent;
  public long field_svrId;
  public String field_talker;
  public int field_type;
  
  static
  {
    cHs = "msgContent".hashCode();
    cxd = "isSend".hashCode();
    czg = "talker".hashCode();
    cHa = "encryptTalker".hashCode();
    cHt = "svrId".hashCode();
    csy = "type".hashCode();
    csv = "createTime".hashCode();
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
      if (cHs != k) {
        break label60;
      }
      this.field_msgContent = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (cxd == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (czg == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (cHa == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (cHt == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (cHu == k) {
        this.field_chatroomName = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_msgContent == null) {
      this.field_msgContent = "";
    }
    if (this.cHp) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.cwP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.cyV) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.cGL) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.cHq) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.cHr) {
      localContentValues.put("chatroomName", this.field_chatroomName);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.bj
 * JD-Core Version:    0.7.0.1
 */
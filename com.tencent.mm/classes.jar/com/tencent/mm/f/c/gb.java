package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class gb
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("RoomMuteExpt");
  public static final Column hmk;
  private static final int hms;
  public static final Column hsU;
  private static final int hty;
  private static final int hwF;
  public static final Column hwx;
  public static final Column iem;
  private static final int ien = "score".hashCode();
  public static final Column iuO;
  public static final Column iuP;
  public static final Column iuQ;
  public static final Column iuR;
  public static final Column iuS;
  public static final Column iuT;
  private static final int iva;
  private static final int ivb;
  private static final int ivc;
  private static final int ivd;
  private static final int ive;
  private static final int ivf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hmo = true;
  private boolean htj = true;
  private boolean hwB = true;
  private boolean iew = true;
  private boolean iuU = true;
  private boolean iuV = true;
  private boolean iuW = true;
  private boolean iuX = true;
  private boolean iuY = true;
  private boolean iuZ = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "RoomMuteExpt", "");
    hmk = new Column("chatroom", "string", "RoomMuteExpt", "");
    iuO = new Column("daysec", "string", "RoomMuteExpt", "");
    hwx = new Column("nickname", "string", "RoomMuteExpt", "");
    iuP = new Column("ismute", "int", "RoomMuteExpt", "");
    hsU = new Column("unreadcount", "int", "RoomMuteExpt", "");
    iuQ = new Column("sendcount", "int", "RoomMuteExpt", "");
    iuR = new Column("entercount", "int", "RoomMuteExpt", "");
    iuS = new Column("disreddotcount", "int", "RoomMuteExpt", "");
    iuT = new Column("staytime", "long", "RoomMuteExpt", "");
    iem = new Column("score", "float", "RoomMuteExpt", "");
    hms = "chatroom".hashCode();
    iva = "daySec".hashCode();
    hwF = "nickname".hashCode();
    ivb = "isMute".hashCode();
    hty = "unReadCount".hashCode();
    ivc = "sendCount".hashCode();
    ivd = "enterCount".hashCode();
    ive = "disRedDotCount".hashCode();
    ivf = "stayTime".hashCode();
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
      if (hms != k) {
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
      if (iva == k) {
        this.field_daySec = paramCursor.getString(i);
      } else if (hwF == k) {
        this.field_nickname = paramCursor.getString(i);
      } else if (ivb == k) {
        this.field_isMute = paramCursor.getInt(i);
      } else if (hty == k) {
        this.field_unReadCount = paramCursor.getInt(i);
      } else if (ivc == k) {
        this.field_sendCount = paramCursor.getInt(i);
      } else if (ivd == k) {
        this.field_enterCount = paramCursor.getInt(i);
      } else if (ive == k) {
        this.field_disRedDotCount = paramCursor.getInt(i);
      } else if (ivf == k) {
        this.field_stayTime = paramCursor.getLong(i);
      } else if (ien == k) {
        this.field_score = paramCursor.getFloat(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hmo) {
      localContentValues.put("chatroom", this.field_chatroom);
    }
    if (this.iuU) {
      localContentValues.put("daySec", this.field_daySec);
    }
    if (this.hwB) {
      localContentValues.put("nickname", this.field_nickname);
    }
    if (this.iuV) {
      localContentValues.put("isMute", Integer.valueOf(this.field_isMute));
    }
    if (this.htj) {
      localContentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
    }
    if (this.iuW) {
      localContentValues.put("sendCount", Integer.valueOf(this.field_sendCount));
    }
    if (this.iuX) {
      localContentValues.put("enterCount", Integer.valueOf(this.field_enterCount));
    }
    if (this.iuY) {
      localContentValues.put("disRedDotCount", Integer.valueOf(this.field_disRedDotCount));
    }
    if (this.iuZ) {
      localContentValues.put("stayTime", Long.valueOf(this.field_stayTime));
    }
    if (this.iew) {
      localContentValues.put("score", Float.valueOf(this.field_score));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "RoomMuteExpt";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.c.gb
 * JD-Core Version:    0.7.0.1
 */
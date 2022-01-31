package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ce
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dBA;
  private static final int dBB;
  private static final int dBC;
  private static final int dBD = "msgSource".hashCode();
  private static final int dBE = "msgSeq".hashCode();
  private static final int dBz = "originSvrId".hashCode();
  private static final int dgM;
  private static final int dgT;
  private static final int dkn = "flag".hashCode();
  private static final int dud = "reserved1".hashCode();
  private static final int due = "reserved2".hashCode();
  private static final int duf = "reserved3".hashCode();
  private static final int dug = "reserved4".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dBt = true;
  private boolean dBu = true;
  private boolean dBv = true;
  private boolean dBw = true;
  private boolean dBx = true;
  private boolean dBy = true;
  private boolean dgp = true;
  private boolean dgw = true;
  private boolean dkl = true;
  private boolean dtq = true;
  private boolean dtr = true;
  private boolean dtt = true;
  private boolean dtu = true;
  public String field_content;
  public long field_createTime;
  public int field_flag;
  public String field_fromUserName;
  public int field_msgSeq;
  public String field_msgSource;
  public long field_newMsgId;
  public long field_originSvrId;
  public int field_reserved1;
  public long field_reserved2;
  public String field_reserved3;
  public String field_reserved4;
  public String field_toUserName;
  
  static
  {
    dBA = "newMsgId".hashCode();
    dBB = "fromUserName".hashCode();
    dBC = "toUserName".hashCode();
    dgM = "createTime".hashCode();
    dgT = "content".hashCode();
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
      if (dBz != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.dBt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dBA == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (dBB == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (dBC == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (dgM == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (dgT == k) {
        this.field_content = paramCursor.getString(i);
      } else if (dBD == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (dBE == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (dkn == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (dud == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (due == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (duf == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (dug == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dBt) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.dBu) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.dBv) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.dBw) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.dgw) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.dBx) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.dBy) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.dkl) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.dtq) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.dtr) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.dtt) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.dtu) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.ce
 * JD-Core Version:    0.7.0.1
 */
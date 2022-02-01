package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIA = "msgSeq".hashCode();
  private static final int eIv = "originSvrId".hashCode();
  private static final int eIw = "newMsgId".hashCode();
  private static final int eIx = "fromUserName".hashCode();
  private static final int eIy = "toUserName".hashCode();
  private static final int eIz;
  private static final int ekU = "createTime".hashCode();
  private static final int elb = "content".hashCode();
  private static final int eoK = "flag".hashCode();
  private static final int ezd = "reserved1".hashCode();
  private static final int eze = "reserved2".hashCode();
  private static final int ezf = "reserved3".hashCode();
  private static final int ezg = "reserved4".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIp = true;
  private boolean eIq = true;
  private boolean eIr = true;
  private boolean eIs = true;
  private boolean eIt = true;
  private boolean eIu = true;
  private boolean ekE = true;
  private boolean ekx = true;
  private boolean eoI = true;
  private boolean eyr = true;
  private boolean eys = true;
  private boolean eyt = true;
  private boolean eyu = true;
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
    eIz = "msgSource".hashCode();
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
      if (eIv != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.eIp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eIw == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (eIx == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (eIy == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (elb == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eIz == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (eIA == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (eoK == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (ezd == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eze == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (ezf == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (ezg == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eIp) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.eIq) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.eIr) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.eIs) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.ekE) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.eIt) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.eIu) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.eoI) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eyr) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eys) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.eyt) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.eyu) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cq
 * JD-Core Version:    0.7.0.1
 */
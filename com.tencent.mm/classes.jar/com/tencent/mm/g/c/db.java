package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class db
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFO;
  private static final int eFV;
  private static final int eJG = "flag".hashCode();
  private static final int eNt;
  private static final int eUG = "reserved1".hashCode();
  private static final int eUH = "reserved2".hashCode();
  private static final int eUI = "reserved3".hashCode();
  private static final int eUJ = "reserved4".hashCode();
  private static final int ffA;
  private static final int ffB;
  private static final int ffC;
  private static final int ffD;
  private static final int ffz = "originSvrId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFr = true;
  private boolean eFy = true;
  private boolean eJE = true;
  private boolean eNl = true;
  private boolean eTU = true;
  private boolean eTV = true;
  private boolean eTW = true;
  private boolean eTX = true;
  private boolean ffu = true;
  private boolean ffv = true;
  private boolean ffw = true;
  private boolean ffx = true;
  private boolean ffy = true;
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
    ffA = "newMsgId".hashCode();
    ffB = "fromUserName".hashCode();
    ffC = "toUserName".hashCode();
    eFO = "createTime".hashCode();
    eFV = "content".hashCode();
    ffD = "msgSource".hashCode();
    eNt = "msgSeq".hashCode();
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
      if (ffz != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.ffu = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ffA == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (ffB == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (ffC == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eFV == k) {
        this.field_content = paramCursor.getString(i);
      } else if (ffD == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (eNt == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (eJG == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eUG == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eUH == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (eUI == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (eUJ == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffu) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.ffv) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.ffw) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.ffx) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eFy) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.ffy) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.eNl) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.eJE) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eTU) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eTV) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.eTW) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.eTX) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.db
 * JD-Core Version:    0.7.0.1
 */
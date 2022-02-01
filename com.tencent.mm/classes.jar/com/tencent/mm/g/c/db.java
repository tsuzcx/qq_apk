package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class db
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEf;
  private static final int eEm;
  private static final int eHX = "flag".hashCode();
  private static final int eLI;
  private static final int eSV = "reserved1".hashCode();
  private static final int eSW = "reserved2".hashCode();
  private static final int eSX = "reserved3".hashCode();
  private static final int eSY = "reserved4".hashCode();
  private static final int fdG = "originSvrId".hashCode();
  private static final int fdH = "newMsgId".hashCode();
  private static final int fdI = "fromUserName".hashCode();
  private static final int fdJ = "toUserName".hashCode();
  private static final int fdK;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDI = true;
  private boolean eDP = true;
  private boolean eHV = true;
  private boolean eLA = true;
  private boolean eSj = true;
  private boolean eSk = true;
  private boolean eSl = true;
  private boolean eSm = true;
  private boolean fdB = true;
  private boolean fdC = true;
  private boolean fdD = true;
  private boolean fdE = true;
  private boolean fdF = true;
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
    eEf = "createTime".hashCode();
    eEm = "content".hashCode();
    fdK = "msgSource".hashCode();
    eLI = "msgSeq".hashCode();
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
      if (fdG != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.fdB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fdH == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (fdI == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (fdJ == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eEm == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fdK == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (eLI == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (eHX == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eSV == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eSW == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (eSX == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (eSY == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fdB) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.fdC) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.fdD) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.fdE) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.eDP) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.fdF) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.eLA) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.eHV) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eSj) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eSk) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.eSl) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.eSm) {
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
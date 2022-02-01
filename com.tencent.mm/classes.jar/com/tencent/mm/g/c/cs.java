package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cs
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBA = "reserved4".hashCode();
  private static final int eBx;
  private static final int eBy;
  private static final int eBz;
  private static final int eLn = "originSvrId".hashCode();
  private static final int eLo = "newMsgId".hashCode();
  private static final int eLp = "fromUserName".hashCode();
  private static final int eLq = "toUserName".hashCode();
  private static final int eLr;
  private static final int eLs;
  private static final int emY = "createTime".hashCode();
  private static final int eng = "content".hashCode();
  private static final int eqO;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAL = true;
  private boolean eAM = true;
  private boolean eAN = true;
  private boolean eAO = true;
  private boolean eLh = true;
  private boolean eLi = true;
  private boolean eLj = true;
  private boolean eLk = true;
  private boolean eLl = true;
  private boolean eLm = true;
  private boolean emB = true;
  private boolean emI = true;
  private boolean eqM = true;
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
    eLr = "msgSource".hashCode();
    eLs = "msgSeq".hashCode();
    eqO = "flag".hashCode();
    eBx = "reserved1".hashCode();
    eBy = "reserved2".hashCode();
    eBz = "reserved3".hashCode();
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
      if (eLn != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.eLh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eLo == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (eLp == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (eLq == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eng == k) {
        this.field_content = paramCursor.getString(i);
      } else if (eLr == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (eLs == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (eqO == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (eBx == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eBy == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (eBz == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (eBA == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eLh) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.eLi) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.eLj) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.eLk) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.emI) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.eLl) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.eLm) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.eqM) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.eAL) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eAM) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.eAN) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.eAO) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cs
 * JD-Core Version:    0.7.0.1
 */
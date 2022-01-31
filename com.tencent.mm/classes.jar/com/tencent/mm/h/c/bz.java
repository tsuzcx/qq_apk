package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bz
  extends c
{
  private static final int cFI = "reserved1".hashCode();
  private static final int cFJ = "reserved2".hashCode();
  private static final int cFK = "reserved3".hashCode();
  private static final int cFL = "reserved4".hashCode();
  private static final int cLJ;
  private static final int cLK;
  private static final int cLL;
  private static final int cLM;
  private static final int cLN;
  private static final int cLO;
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int csD;
  private static final int csv;
  private static final int cwe;
  private boolean cFf = true;
  private boolean cFg = true;
  private boolean cFh = true;
  private boolean cFi = true;
  private boolean cLD = true;
  private boolean cLE = true;
  private boolean cLF = true;
  private boolean cLG = true;
  private boolean cLH = true;
  private boolean cLI = true;
  private boolean crX = true;
  private boolean csf = true;
  private boolean cwc = true;
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
    cLJ = "originSvrId".hashCode();
    cLK = "newMsgId".hashCode();
    cLL = "fromUserName".hashCode();
    cLM = "toUserName".hashCode();
    csv = "createTime".hashCode();
    csD = "content".hashCode();
    cLN = "msgSource".hashCode();
    cLO = "msgSeq".hashCode();
    cwe = "flag".hashCode();
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
      if (cLJ != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.cLD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cLK == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (cLL == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (cLM == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (csv == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (csD == k) {
        this.field_content = paramCursor.getString(i);
      } else if (cLN == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (cLO == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (cwe == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (cFI == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (cFJ == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (cFK == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (cFL == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cLD) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.cLE) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.cLF) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.cLG) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.csf) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.cLH) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.cLI) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.cwc) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.cFf) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.cFg) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.cFh) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.cFi) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.bz
 * JD-Core Version:    0.7.0.1
 */
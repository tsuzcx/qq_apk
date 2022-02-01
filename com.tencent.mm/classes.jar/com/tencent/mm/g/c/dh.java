package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dh
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int content_HASHCODE;
  private static final int createTime_HASHCODE;
  private static final int fKc = "originSvrId".hashCode();
  private static final int fKd = "newMsgId".hashCode();
  private static final int fKe = "fromUserName".hashCode();
  private static final int fKf = "toUserName".hashCode();
  private static final int fKg;
  private static final int fni = "flag".hashCode();
  private static final int fra;
  private static final int fyl = "reserved1".hashCode();
  private static final int fym = "reserved2".hashCode();
  private static final int fyn = "reserved3".hashCode();
  private static final int fyo = "reserved4".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcontent = true;
  private boolean __hadSetcreateTime = true;
  private boolean fJX = true;
  private boolean fJY = true;
  private boolean fJZ = true;
  private boolean fKa = true;
  private boolean fKb = true;
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
  private boolean fng = true;
  private boolean fqS = true;
  private boolean fxA = true;
  private boolean fxB = true;
  private boolean fxC = true;
  private boolean fxz = true;
  
  static
  {
    createTime_HASHCODE = "createTime".hashCode();
    content_HASHCODE = "content".hashCode();
    fKg = "msgSource".hashCode();
    fra = "msgSeq".hashCode();
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
      if (fKc != k) {
        break label65;
      }
      this.field_originSvrId = paramCursor.getLong(i);
      this.fJX = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fKd == k) {
        this.field_newMsgId = paramCursor.getLong(i);
      } else if (fKe == k) {
        this.field_fromUserName = paramCursor.getString(i);
      } else if (fKf == k) {
        this.field_toUserName = paramCursor.getString(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (content_HASHCODE == k) {
        this.field_content = paramCursor.getString(i);
      } else if (fKg == k) {
        this.field_msgSource = paramCursor.getString(i);
      } else if (fra == k) {
        this.field_msgSeq = paramCursor.getInt(i);
      } else if (fni == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (fyl == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (fym == k) {
        this.field_reserved2 = paramCursor.getLong(i);
      } else if (fyn == k) {
        this.field_reserved3 = paramCursor.getString(i);
      } else if (fyo == k) {
        this.field_reserved4 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fJX) {
      localContentValues.put("originSvrId", Long.valueOf(this.field_originSvrId));
    }
    if (this.fJY) {
      localContentValues.put("newMsgId", Long.valueOf(this.field_newMsgId));
    }
    if (this.field_fromUserName == null) {
      this.field_fromUserName = "";
    }
    if (this.fJZ) {
      localContentValues.put("fromUserName", this.field_fromUserName);
    }
    if (this.field_toUserName == null) {
      this.field_toUserName = "";
    }
    if (this.fKa) {
      localContentValues.put("toUserName", this.field_toUserName);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_content == null) {
      this.field_content = "";
    }
    if (this.__hadSetcontent) {
      localContentValues.put("content", this.field_content);
    }
    if (this.field_msgSource == null) {
      this.field_msgSource = "";
    }
    if (this.fKb) {
      localContentValues.put("msgSource", this.field_msgSource);
    }
    if (this.fqS) {
      localContentValues.put("msgSeq", Integer.valueOf(this.field_msgSeq));
    }
    if (this.fng) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.fxz) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.fxA) {
      localContentValues.put("reserved2", Long.valueOf(this.field_reserved2));
    }
    if (this.field_reserved3 == null) {
      this.field_reserved3 = "";
    }
    if (this.fxB) {
      localContentValues.put("reserved3", this.field_reserved3);
    }
    if (this.field_reserved4 == null) {
      this.field_reserved4 = "";
    }
    if (this.fxC) {
      localContentValues.put("reserved4", this.field_reserved4);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.dh
 * JD-Core Version:    0.7.0.1
 */
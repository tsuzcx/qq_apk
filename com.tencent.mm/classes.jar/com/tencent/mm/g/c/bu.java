package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class bu
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE = "createTime".hashCode();
  private static final int fAi = "msgContent".hashCode();
  private static final int fAj;
  private static final int fAk = "chatroomName".hashCode();
  private static final int foe = "isSend".hashCode();
  private static final int fqw = "talker".hashCode();
  private static final int fzQ = "encryptTalker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  private boolean fAf = true;
  private boolean fAg = true;
  private boolean fAh = true;
  public String field_chatroomName;
  public long field_createTime;
  public String field_encryptTalker;
  public int field_isSend;
  public String field_msgContent;
  public long field_svrId;
  public String field_talker;
  public int field_type;
  private boolean fnP = true;
  private boolean fqi = true;
  private boolean fzB = true;
  
  static
  {
    fAj = "svrId".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (fAi != k) {
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
      if (foe == k) {
        this.field_isSend = paramCursor.getInt(i);
      } else if (fqw == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fzQ == k) {
        this.field_encryptTalker = paramCursor.getString(i);
      } else if (fAj == k) {
        this.field_svrId = paramCursor.getLong(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (fAk == k) {
        this.field_chatroomName = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_msgContent == null) {
      this.field_msgContent = "";
    }
    if (this.fAf) {
      localContentValues.put("msgContent", this.field_msgContent);
    }
    if (this.fnP) {
      localContentValues.put("isSend", Integer.valueOf(this.field_isSend));
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_encryptTalker == null) {
      this.field_encryptTalker = "";
    }
    if (this.fzB) {
      localContentValues.put("encryptTalker", this.field_encryptTalker);
    }
    if (this.fAg) {
      localContentValues.put("svrId", Long.valueOf(this.field_svrId));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.field_chatroomName == null) {
      this.field_chatroomName = "";
    }
    if (this.fAh) {
      localContentValues.put("chatroomName", this.field_chatroomName);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.bu
 * JD-Core Version:    0.7.0.1
 */
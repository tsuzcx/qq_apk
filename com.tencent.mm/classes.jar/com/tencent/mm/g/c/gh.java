package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class gh
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int createTime_HASHCODE;
  private static final int fZA = "clientId".hashCode();
  private static final int fZB = "commentflag".hashCode();
  private static final int fZC = "isSilence".hashCode();
  private static final int fZv = "snsID".hashCode();
  private static final int fZw = "parentID".hashCode();
  private static final int fZx;
  private static final int fZy;
  private static final int fZz;
  private static final int foe;
  private static final int fqF = "isRead".hashCode();
  private static final int fqw;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
  private boolean fZn = true;
  private boolean fZo = true;
  private boolean fZp = true;
  private boolean fZq = true;
  private boolean fZr = true;
  private boolean fZs = true;
  private boolean fZt = true;
  private boolean fZu = true;
  public String field_clientId;
  public long field_commentSvrID;
  public int field_commentflag;
  public int field_createTime;
  public byte[] field_curActionBuf;
  public short field_isRead;
  public boolean field_isSend;
  public int field_isSilence;
  public long field_parentID;
  public byte[] field_refActionBuf;
  public long field_snsID;
  public String field_talker;
  public int field_type;
  private boolean fnP = true;
  private boolean fqi = true;
  private boolean fqr = true;
  
  static
  {
    createTime_HASHCODE = "createTime".hashCode();
    fqw = "talker".hashCode();
    type_HASHCODE = "type".hashCode();
    foe = "isSend".hashCode();
    fZx = "curActionBuf".hashCode();
    fZy = "refActionBuf".hashCode();
    fZz = "commentSvrID".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (fZv != k) {
        break label60;
      }
      this.field_snsID = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fZw == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (fqF == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (fqw == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (foe == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (fZx == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (fZy == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (fZz == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (fZA == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (fZB == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (fZC == k) {
          this.field_isSilence = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fZn) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.fZo) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.fqr) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fnP) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.fZp) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.fZq) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.fZr) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.fZs) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.fZt) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.fZu) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gh
 * JD-Core Version:    0.7.0.1
 */
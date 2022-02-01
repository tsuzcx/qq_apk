package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fn
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int emY;
  private static final int erG = "isSend".hashCode();
  private static final int etX;
  private static final int eug;
  private static final int faA = "curActionBuf".hashCode();
  private static final int faB = "refActionBuf".hashCode();
  private static final int faC = "commentSvrID".hashCode();
  private static final int faD = "clientId".hashCode();
  private static final int faE = "commentflag".hashCode();
  private static final int faF = "isSilence".hashCode();
  private static final int fay = "snsID".hashCode();
  private static final int faz = "parentID".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean emB = true;
  private boolean err = true;
  private boolean etJ = true;
  private boolean etS = true;
  private boolean faq = true;
  private boolean far = true;
  private boolean fas = true;
  private boolean fat = true;
  private boolean fau = true;
  private boolean fav = true;
  private boolean faw = true;
  private boolean fax = true;
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
  
  static
  {
    eug = "isRead".hashCode();
    emY = "createTime".hashCode();
    etX = "talker".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (fay != k) {
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
      if (faz == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (eug == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (emY == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (etX == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (erG == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (faA == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (faB == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (faC == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (faD == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (faE == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (faF == k) {
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
    if (this.faq) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.far) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.etS) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.emB) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.etJ) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.err) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.fas) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.fat) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.fau) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.fav) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.faw) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.fax) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fn
 * JD-Core Version:    0.7.0.1
 */
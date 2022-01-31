package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eo
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int dOA;
  private static final int dOB = "curActionBuf".hashCode();
  private static final int dOC = "refActionBuf".hashCode();
  private static final int dOD = "commentSvrID".hashCode();
  private static final int dOE = "clientId".hashCode();
  private static final int dOF = "commentflag".hashCode();
  private static final int dOG = "isSilence".hashCode();
  private static final int dOz = "snsID".hashCode();
  private static final int dgM;
  private static final int dle;
  private static final int dnh;
  private static final int dnq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dOr = true;
  private boolean dOs = true;
  private boolean dOt = true;
  private boolean dOu = true;
  private boolean dOv = true;
  private boolean dOw = true;
  private boolean dOx = true;
  private boolean dOy = true;
  private boolean dgp = true;
  private boolean dkQ = true;
  private boolean dmW = true;
  private boolean dnf = true;
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
    dOA = "parentID".hashCode();
    dnq = "isRead".hashCode();
    dgM = "createTime".hashCode();
    dnh = "talker".hashCode();
    type_HASHCODE = "type".hashCode();
    dle = "isSend".hashCode();
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
      if (dOz != k) {
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
      if (dOA == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (dnq == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (dgM == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (dnh == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (dle == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (dOB == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (dOC == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (dOD == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (dOE == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (dOF == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (dOG == k) {
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
    if (this.dOr) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.dOs) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.dnf) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.dmW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.dkQ) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.dOt) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.dOu) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.dOv) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.dOw) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.dOx) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.dOy) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.eo
 * JD-Core Version:    0.7.0.1
 */
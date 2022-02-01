package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fx
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int eEf;
  private static final int eIP = "isSend".hashCode();
  private static final int eLf;
  private static final int eLo;
  private static final int fsM = "snsID".hashCode();
  private static final int fsN = "parentID".hashCode();
  private static final int fsO = "curActionBuf".hashCode();
  private static final int fsP = "refActionBuf".hashCode();
  private static final int fsQ = "commentSvrID".hashCode();
  private static final int fsR = "clientId".hashCode();
  private static final int fsS = "commentflag".hashCode();
  private static final int fsT = "isSilence".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eDI = true;
  private boolean eIA = true;
  private boolean eKS = true;
  private boolean eLb = true;
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
  private boolean fsE = true;
  private boolean fsF = true;
  private boolean fsG = true;
  private boolean fsH = true;
  private boolean fsI = true;
  private boolean fsJ = true;
  private boolean fsK = true;
  private boolean fsL = true;
  
  static
  {
    eLo = "isRead".hashCode();
    eEf = "createTime".hashCode();
    eLf = "talker".hashCode();
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
      if (fsM != k) {
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
      if (fsN == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (eLo == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (eEf == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (eLf == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (eIP == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (fsO == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (fsP == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (fsQ == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (fsR == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (fsS == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (fsT == k) {
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
    if (this.fsE) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.fsF) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.eLb) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eKS) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eIA) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.fsG) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.fsH) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.fsI) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.fsJ) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.fsK) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.fsL) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fx
 * JD-Core Version:    0.7.0.1
 */
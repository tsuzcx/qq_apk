package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fy
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int eFO;
  private static final int eKy = "isSend".hashCode();
  private static final int eMP;
  private static final int eMY;
  private static final int fuM = "snsID".hashCode();
  private static final int fuN = "parentID".hashCode();
  private static final int fuO = "curActionBuf".hashCode();
  private static final int fuP = "refActionBuf".hashCode();
  private static final int fuQ = "commentSvrID".hashCode();
  private static final int fuR = "clientId".hashCode();
  private static final int fuS = "commentflag".hashCode();
  private static final int fuT = "isSilence".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eFr = true;
  private boolean eKj = true;
  private boolean eMB = true;
  private boolean eMK = true;
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
  private boolean fuE = true;
  private boolean fuF = true;
  private boolean fuG = true;
  private boolean fuH = true;
  private boolean fuI = true;
  private boolean fuJ = true;
  private boolean fuK = true;
  private boolean fuL = true;
  
  static
  {
    eMY = "isRead".hashCode();
    eFO = "createTime".hashCode();
    eMP = "talker".hashCode();
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
      if (fuM != k) {
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
      if (fuN == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (eMY == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (eFO == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (eMP == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (eKy == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (fuO == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (fuP == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (fuQ == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (fuR == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (fuS == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (fuT == k) {
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
    if (this.fuE) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.fuF) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.eMK) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.eKj) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.fuG) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.fuH) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.fuI) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.fuJ) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.fuK) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.fuL) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fy
 * JD-Core Version:    0.7.0.1
 */
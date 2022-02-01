package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fj
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int eXk = "snsID".hashCode();
  private static final int eXl = "parentID".hashCode();
  private static final int eXm = "curActionBuf".hashCode();
  private static final int eXn = "refActionBuf".hashCode();
  private static final int eXo = "commentSvrID".hashCode();
  private static final int eXp = "clientId".hashCode();
  private static final int eXq = "commentflag".hashCode();
  private static final int eXr = "isSilence".hashCode();
  private static final int ekU;
  private static final int epC;
  private static final int erT;
  private static final int esc = "isRead".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eXc = true;
  private boolean eXd = true;
  private boolean eXe = true;
  private boolean eXf = true;
  private boolean eXg = true;
  private boolean eXh = true;
  private boolean eXi = true;
  private boolean eXj = true;
  private boolean ekx = true;
  private boolean epn = true;
  private boolean erF = true;
  private boolean erO = true;
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
    ekU = "createTime".hashCode();
    erT = "talker".hashCode();
    type_HASHCODE = "type".hashCode();
    epC = "isSend".hashCode();
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
      if (eXk != k) {
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
      if (eXl == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (esc == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (ekU == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (erT == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (epC == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (eXm == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (eXn == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (eXo == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (eXp == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (eXq == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (eXr == k) {
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
    if (this.eXc) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.eXd) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.erO) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.erF) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.epn) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.eXe) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.eXf) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.eXg) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.eXh) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.eXi) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.eXj) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fj
 * JD-Core Version:    0.7.0.1
 */
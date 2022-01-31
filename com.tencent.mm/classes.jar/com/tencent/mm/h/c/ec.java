package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ec
  extends c
{
  private static final int cYf;
  private static final int cYg;
  private static final int cYh = "curActionBuf".hashCode();
  private static final int cYi = "refActionBuf".hashCode();
  private static final int cYj = "commentSvrID".hashCode();
  private static final int cYk = "clientId".hashCode();
  private static final int cYl = "commentflag".hashCode();
  private static final int cYm = "isSilence".hashCode();
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int csy;
  private static final int cxd;
  private static final int czg;
  private static final int czp;
  private boolean cXX = true;
  private boolean cXY = true;
  private boolean cXZ = true;
  private boolean cYa = true;
  private boolean cYb = true;
  private boolean cYc = true;
  private boolean cYd = true;
  private boolean cYe = true;
  private boolean crX = true;
  private boolean csa = true;
  private boolean cwP = true;
  private boolean cyV = true;
  private boolean cze = true;
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
    cYf = "snsID".hashCode();
    cYg = "parentID".hashCode();
    czp = "isRead".hashCode();
    csv = "createTime".hashCode();
    czg = "talker".hashCode();
    csy = "type".hashCode();
    cxd = "isSend".hashCode();
  }
  
  public void d(Cursor paramCursor)
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
      if (cYf != k) {
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
      if (cYg == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (czp == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (csv == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (czg == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (csy == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (cxd == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (cYh == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (cYi == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (cYj == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (cYk == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (cYl == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (cYm == k) {
          this.field_isSilence = paramCursor.getInt(i);
        } else if (crh == k) {
          this.ujK = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cXX) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.cXY) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.cze) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.crX) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.cyV) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.csa) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.cwP) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.cXZ) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.cYa) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.cYb) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.cYc) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.cYd) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.cYe) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.c.ec
 * JD-Core Version:    0.7.0.1
 */
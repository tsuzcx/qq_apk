package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class go
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final Column C_SNSID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS SnsComment_snsID_index ON SnsComment(snsID)", "CREATE INDEX IF NOT EXISTS SnsComment_parentID_index ON SnsComment(parentID)", "CREATE INDEX IF NOT EXISTS SnsComment_isRead_index ON SnsComment(isRead)", "CREATE INDEX IF NOT EXISTS SnsComment_isSend_index ON SnsComment(isSend)" };
  public static final SingleTable TABLE = new SingleTable("SnsComment");
  private static final int createTime_HASHCODE;
  private static final int htH = "isSend".hashCode();
  public static final Column htd;
  public static final Column hwI;
  public static final Column hwR;
  private static final int hxk;
  private static final int hxt;
  public static final Column ixW;
  public static final Column ixX;
  public static final Column ixY;
  public static final Column ixZ;
  public static final Column iya;
  public static final Column iyb;
  public static final Column iyc;
  private static final int iyl;
  private static final int iym;
  private static final int iyn = "curActionBuf".hashCode();
  private static final int iyo = "refActionBuf".hashCode();
  private static final int iyp = "commentSvrID".hashCode();
  private static final int iyq = "clientId".hashCode();
  private static final int iyr = "commentflag".hashCode();
  private static final int iys = "isSilence".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSettype = true;
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
  private boolean hts = true;
  private boolean hwW = true;
  private boolean hxf = true;
  private boolean iyd = true;
  private boolean iye = true;
  private boolean iyf = true;
  private boolean iyg = true;
  private boolean iyh = true;
  private boolean iyi = true;
  private boolean iyj = true;
  private boolean iyk = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "SnsComment", "");
    C_SNSID = new Column("snsid", "long", "SnsComment", "");
    ixW = new Column("parentid", "long", "SnsComment", "");
    hwR = new Column("isread", "short", "SnsComment", "");
    C_CREATETIME = new Column("createtime", "int", "SnsComment", "");
    hwI = new Column("talker", "string", "SnsComment", "");
    C_TYPE = new Column("type", "int", "SnsComment", "");
    htd = new Column("issend", "boolean", "SnsComment", "");
    ixX = new Column("curactionbuf", "byte[]", "SnsComment", "");
    ixY = new Column("refactionbuf", "byte[]", "SnsComment", "");
    ixZ = new Column("commentsvrid", "long", "SnsComment", "");
    iya = new Column("clientid", "string", "SnsComment", "");
    iyb = new Column("commentflag", "int", "SnsComment", "");
    iyc = new Column("issilence", "int", "SnsComment", "");
    iyl = "snsID".hashCode();
    iym = "parentID".hashCode();
    hxt = "isRead".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hxk = "talker".hashCode();
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
      if (iyl != k) {
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
      if (iym == k)
      {
        this.field_parentID = paramCursor.getLong(i);
      }
      else if (hxt == k)
      {
        this.field_isRead = paramCursor.getShort(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getInt(i);
      }
      else if (hxk == k)
      {
        this.field_talker = paramCursor.getString(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else
      {
        if (htH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSend = bool;
            break;
          }
        }
        if (iyn == k) {
          this.field_curActionBuf = paramCursor.getBlob(i);
        } else if (iyo == k) {
          this.field_refActionBuf = paramCursor.getBlob(i);
        } else if (iyp == k) {
          this.field_commentSvrID = paramCursor.getLong(i);
        } else if (iyq == k) {
          this.field_clientId = paramCursor.getString(i);
        } else if (iyr == k) {
          this.field_commentflag = paramCursor.getInt(i);
        } else if (iys == k) {
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
    if (this.iyd) {
      localContentValues.put("snsID", Long.valueOf(this.field_snsID));
    }
    if (this.iye) {
      localContentValues.put("parentID", Long.valueOf(this.field_parentID));
    }
    if (this.hxf) {
      localContentValues.put("isRead", Short.valueOf(this.field_isRead));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.hwW) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.hts) {
      localContentValues.put("isSend", Boolean.valueOf(this.field_isSend));
    }
    if (this.iyf) {
      localContentValues.put("curActionBuf", this.field_curActionBuf);
    }
    if (this.iyg) {
      localContentValues.put("refActionBuf", this.field_refActionBuf);
    }
    if (this.iyh) {
      localContentValues.put("commentSvrID", Long.valueOf(this.field_commentSvrID));
    }
    if (this.iyi) {
      localContentValues.put("clientId", this.field_clientId);
    }
    if (this.iyj) {
      localContentValues.put("commentflag", Integer.valueOf(this.field_commentflag));
    }
    if (this.iyk) {
      localContentValues.put("isSilence", Integer.valueOf(this.field_isSilence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "SnsComment";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.go
 * JD-Core Version:    0.7.0.1
 */
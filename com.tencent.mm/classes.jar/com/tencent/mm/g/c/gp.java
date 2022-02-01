package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gp
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int eDc;
  private static final int eFa;
  private static final int eSV = "reserved1".hashCode();
  private static final int eSW = "reserved2".hashCode();
  private static final int feK;
  private static final int fwa = "filename".hashCode();
  private static final int fwb = "user".hashCode();
  private static final int fwc = "msgid".hashCode();
  private static final int fwd;
  private static final int fwe;
  private static final int fwf;
  private static final int fwg;
  private static final int fwh;
  private static final int fwi;
  private static final int fwj;
  private static final int fwk;
  private static final int fwl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eEJ = true;
  private boolean eSj = true;
  private boolean eSk = true;
  private boolean feB = true;
  public String field_clientid;
  public long field_createtime;
  public String field_filename;
  public int field_filenowsize;
  public String field_human;
  public long field_lastmodifytime;
  public long field_msgid;
  public int field_msglocalid;
  public int field_nettimes;
  public int field_offset;
  public int field_reserved1;
  public String field_reserved2;
  public int field_status;
  public int field_totallen;
  public String field_user;
  public int field_voiceformat;
  public int field_voicelenght;
  private boolean fvO = true;
  private boolean fvP = true;
  private boolean fvQ = true;
  private boolean fvR = true;
  private boolean fvS = true;
  private boolean fvT = true;
  private boolean fvU = true;
  private boolean fvV = true;
  private boolean fvW = true;
  private boolean fvX = true;
  private boolean fvY = true;
  private boolean fvZ = true;
  
  static
  {
    eFa = "offset".hashCode();
    fwd = "filenowsize".hashCode();
    fwe = "totallen".hashCode();
    eDc = "status".hashCode();
    feK = "createtime".hashCode();
    fwf = "lastmodifytime".hashCode();
    fwg = "clientid".hashCode();
    fwh = "voicelenght".hashCode();
    fwi = "msglocalid".hashCode();
    fwj = "human".hashCode();
    fwk = "voiceformat".hashCode();
    fwl = "nettimes".hashCode();
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
      if (fwa != k) {
        break label60;
      }
      this.field_filename = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fwb == k) {
        this.field_user = paramCursor.getString(i);
      } else if (fwc == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (eFa == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (fwd == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (fwe == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (feK == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fwf == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (fwg == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (fwh == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (fwi == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (fwj == k) {
        this.field_human = paramCursor.getString(i);
      } else if (fwk == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (fwl == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (eSV == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eSW == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fvO) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.fvP) {
      localContentValues.put("user", this.field_user);
    }
    if (this.fvQ) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.eEJ) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.fvR) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.fvS) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.eCZ) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.feB) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fvT) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.fvU) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.fvV) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.fvW) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.fvX) {
      localContentValues.put("human", this.field_human);
    }
    if (this.fvY) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.fvZ) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.eSj) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eSk) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gp
 * JD-Core Version:    0.7.0.1
 */
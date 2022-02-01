package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gf
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int eBx = "reserved1".hashCode();
  private static final int eBy = "reserved2".hashCode();
  private static final int eMo;
  private static final int elV;
  private static final int enU;
  private static final int fdS = "filename".hashCode();
  private static final int fdT = "user".hashCode();
  private static final int fdU = "msgid".hashCode();
  private static final int fdV;
  private static final int fdW;
  private static final int fdX;
  private static final int fdY;
  private static final int fdZ;
  private static final int fea;
  private static final int feb;
  private static final int fec;
  private static final int fed;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAL = true;
  private boolean eAM = true;
  private boolean eMf = true;
  private boolean elS = true;
  private boolean enD = true;
  private boolean fdG = true;
  private boolean fdH = true;
  private boolean fdI = true;
  private boolean fdJ = true;
  private boolean fdK = true;
  private boolean fdL = true;
  private boolean fdM = true;
  private boolean fdN = true;
  private boolean fdO = true;
  private boolean fdP = true;
  private boolean fdQ = true;
  private boolean fdR = true;
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
  
  static
  {
    enU = "offset".hashCode();
    fdV = "filenowsize".hashCode();
    fdW = "totallen".hashCode();
    elV = "status".hashCode();
    eMo = "createtime".hashCode();
    fdX = "lastmodifytime".hashCode();
    fdY = "clientid".hashCode();
    fdZ = "voicelenght".hashCode();
    fea = "msglocalid".hashCode();
    feb = "human".hashCode();
    fec = "voiceformat".hashCode();
    fed = "nettimes".hashCode();
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
      if (fdS != k) {
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
      if (fdT == k) {
        this.field_user = paramCursor.getString(i);
      } else if (fdU == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (enU == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (fdV == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (fdW == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eMo == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fdX == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (fdY == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (fdZ == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (fea == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (feb == k) {
        this.field_human = paramCursor.getString(i);
      } else if (fec == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (fed == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (eBx == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eBy == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fdG) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.fdH) {
      localContentValues.put("user", this.field_user);
    }
    if (this.fdI) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.enD) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.fdJ) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.fdK) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.elS) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eMf) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fdL) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.fdM) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.fdN) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.fdO) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.fdP) {
      localContentValues.put("human", this.field_human);
    }
    if (this.fdQ) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.fdR) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.eAL) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eAM) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gf
 * JD-Core Version:    0.7.0.1
 */
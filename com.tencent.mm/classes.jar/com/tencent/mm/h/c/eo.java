package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class eo
  extends c
{
  private static final int cFI = "reserved1".hashCode();
  private static final int cFJ = "reserved2".hashCode();
  private static final int cOc;
  private static final int cZX;
  private static final int cZY;
  private static final int cZZ;
  public static final String[] cqY = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int ctr;
  private static final int daa;
  private static final int dab;
  private static final int dac;
  private static final int dad;
  private static final int dae;
  private static final int daf;
  private static final int dag;
  private static final int dah;
  private static final int dai;
  private boolean cFf = true;
  private boolean cFg = true;
  private boolean cNX = true;
  private boolean cZL = true;
  private boolean cZM = true;
  private boolean cZN = true;
  private boolean cZO = true;
  private boolean cZP = true;
  private boolean cZQ = true;
  private boolean cZR = true;
  private boolean cZS = true;
  private boolean cZT = true;
  private boolean cZU = true;
  private boolean cZV = true;
  private boolean cZW = true;
  private boolean crk = true;
  private boolean cta = true;
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
    cZX = "filename".hashCode();
    cZY = "user".hashCode();
    cZZ = "msgid".hashCode();
    ctr = "offset".hashCode();
    daa = "filenowsize".hashCode();
    dab = "totallen".hashCode();
    crn = "status".hashCode();
    cOc = "createtime".hashCode();
    dac = "lastmodifytime".hashCode();
    dad = "clientid".hashCode();
    dae = "voicelenght".hashCode();
    daf = "msglocalid".hashCode();
    dag = "human".hashCode();
    dah = "voiceformat".hashCode();
    dai = "nettimes".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cZX != k) {
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
      if (cZY == k) {
        this.field_user = paramCursor.getString(i);
      } else if (cZZ == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (ctr == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (daa == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (dab == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cOc == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (dac == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (dad == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (dae == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (daf == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (dag == k) {
        this.field_human = paramCursor.getString(i);
      } else if (dah == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (dai == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (cFI == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (cFJ == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cZL) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.cZM) {
      localContentValues.put("user", this.field_user);
    }
    if (this.cZN) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.cta) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.cZO) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.cZP) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.crk) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.cNX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.cZQ) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.cZR) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.cZS) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.cZT) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.cZU) {
      localContentValues.put("human", this.field_human);
    }
    if (this.cZV) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.cZW) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.cFf) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.cFg) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.eo
 * JD-Core Version:    0.7.0.1
 */
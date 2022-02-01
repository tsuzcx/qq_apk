package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gq
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int eEL;
  private static final int eGJ;
  private static final int eUG = "reserved1".hashCode();
  private static final int eUH = "reserved2".hashCode();
  private static final int fgF;
  private static final int fya = "filename".hashCode();
  private static final int fyb = "user".hashCode();
  private static final int fyc = "msgid".hashCode();
  private static final int fyd;
  private static final int fye;
  private static final int fyf;
  private static final int fyg;
  private static final int fyh;
  private static final int fyi;
  private static final int fyj;
  private static final int fyk;
  private static final int fyl;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEI = true;
  private boolean eGs = true;
  private boolean eTU = true;
  private boolean eTV = true;
  private boolean fgu = true;
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
  private boolean fxO = true;
  private boolean fxP = true;
  private boolean fxQ = true;
  private boolean fxR = true;
  private boolean fxS = true;
  private boolean fxT = true;
  private boolean fxU = true;
  private boolean fxV = true;
  private boolean fxW = true;
  private boolean fxX = true;
  private boolean fxY = true;
  private boolean fxZ = true;
  
  static
  {
    eGJ = "offset".hashCode();
    fyd = "filenowsize".hashCode();
    fye = "totallen".hashCode();
    eEL = "status".hashCode();
    fgF = "createtime".hashCode();
    fyf = "lastmodifytime".hashCode();
    fyg = "clientid".hashCode();
    fyh = "voicelenght".hashCode();
    fyi = "msglocalid".hashCode();
    fyj = "human".hashCode();
    fyk = "voiceformat".hashCode();
    fyl = "nettimes".hashCode();
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
      if (fya != k) {
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
      if (fyb == k) {
        this.field_user = paramCursor.getString(i);
      } else if (fyc == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (eGJ == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (fyd == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (fye == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fgF == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (fyf == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (fyg == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (fyh == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (fyi == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (fyj == k) {
        this.field_human = paramCursor.getString(i);
      } else if (fyk == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (fyl == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (eUG == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eUH == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fxO) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.fxP) {
      localContentValues.put("user", this.field_user);
    }
    if (this.fxQ) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.eGs) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.fxR) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.fxS) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.eEI) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fgu) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.fxT) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.fxU) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.fxV) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.fxW) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.fxX) {
      localContentValues.put("human", this.field_human);
    }
    if (this.fxY) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.fxZ) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.eTU) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eTV) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.gq
 * JD-Core Version:    0.7.0.1
 */
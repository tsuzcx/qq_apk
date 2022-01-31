package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fe
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int dDS;
  private static final int dRA = "nettimes".hashCode();
  private static final int dRp = "filename".hashCode();
  private static final int dRq = "user".hashCode();
  private static final int dRr = "msgid".hashCode();
  private static final int dRs;
  private static final int dRt;
  private static final int dRu;
  private static final int dRv;
  private static final int dRw;
  private static final int dRx;
  private static final int dRy;
  private static final int dRz;
  private static final int dfJ;
  private static final int dhH = "offset".hashCode();
  private static final int dud = "reserved1".hashCode();
  private static final int due = "reserved2".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dDN = true;
  private boolean dRd = true;
  private boolean dRe = true;
  private boolean dRf = true;
  private boolean dRg = true;
  private boolean dRh = true;
  private boolean dRi = true;
  private boolean dRj = true;
  private boolean dRk = true;
  private boolean dRl = true;
  private boolean dRm = true;
  private boolean dRn = true;
  private boolean dRo = true;
  private boolean dfG = true;
  private boolean dhq = true;
  private boolean dtq = true;
  private boolean dtr = true;
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
    dRs = "filenowsize".hashCode();
    dRt = "totallen".hashCode();
    dfJ = "status".hashCode();
    dDS = "createtime".hashCode();
    dRu = "lastmodifytime".hashCode();
    dRv = "clientid".hashCode();
    dRw = "voicelenght".hashCode();
    dRx = "msglocalid".hashCode();
    dRy = "human".hashCode();
    dRz = "voiceformat".hashCode();
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
      if (dRp != k) {
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
      if (dRq == k) {
        this.field_user = paramCursor.getString(i);
      } else if (dRr == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (dhH == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (dRs == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (dRt == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dDS == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (dRu == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (dRv == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (dRw == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (dRx == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (dRy == k) {
        this.field_human = paramCursor.getString(i);
      } else if (dRz == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (dRA == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (dud == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (due == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dRd) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.dRe) {
      localContentValues.put("user", this.field_user);
    }
    if (this.dRf) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.dhq) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.dRg) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.dRh) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.dfG) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.dDN) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.dRi) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.dRj) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.dRk) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.dRl) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.dRm) {
      localContentValues.put("human", this.field_human);
    }
    if (this.dRn) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.dRo) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.dtq) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.dtr) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fe
 * JD-Core Version:    0.7.0.1
 */
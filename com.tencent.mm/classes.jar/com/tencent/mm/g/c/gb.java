package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class gb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int eJw;
  private static final int ejR;
  private static final int elP;
  private static final int ezd = "reserved1".hashCode();
  private static final int eze = "reserved2".hashCode();
  private static final int faG = "filename".hashCode();
  private static final int faH = "user".hashCode();
  private static final int faI = "msgid".hashCode();
  private static final int faJ;
  private static final int faK;
  private static final int faL;
  private static final int faM;
  private static final int faN;
  private static final int faO;
  private static final int faP;
  private static final int faQ;
  private static final int faR;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJn = true;
  private boolean ejO = true;
  private boolean ely = true;
  private boolean eyr = true;
  private boolean eys = true;
  private boolean faA = true;
  private boolean faB = true;
  private boolean faC = true;
  private boolean faD = true;
  private boolean faE = true;
  private boolean faF = true;
  private boolean fau = true;
  private boolean fav = true;
  private boolean faw = true;
  private boolean fax = true;
  private boolean fay = true;
  private boolean faz = true;
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
    elP = "offset".hashCode();
    faJ = "filenowsize".hashCode();
    faK = "totallen".hashCode();
    ejR = "status".hashCode();
    eJw = "createtime".hashCode();
    faL = "lastmodifytime".hashCode();
    faM = "clientid".hashCode();
    faN = "voicelenght".hashCode();
    faO = "msglocalid".hashCode();
    faP = "human".hashCode();
    faQ = "voiceformat".hashCode();
    faR = "nettimes".hashCode();
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
      if (faG != k) {
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
      if (faH == k) {
        this.field_user = paramCursor.getString(i);
      } else if (faI == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (elP == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (faJ == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (faK == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eJw == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (faL == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (faM == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (faN == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (faO == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (faP == k) {
        this.field_human = paramCursor.getString(i);
      } else if (faQ == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (faR == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (ezd == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (eze == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fau) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.fav) {
      localContentValues.put("user", this.field_user);
    }
    if (this.faw) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.ely) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.fax) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.fay) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.ejO) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.eJn) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.faz) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.faA) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.faB) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.faC) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.faD) {
      localContentValues.put("human", this.field_human);
    }
    if (this.faE) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.faF) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.eyr) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.eys) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.gb
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class hb
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  private static final int fLi;
  private static final int fjl;
  private static final int fkp;
  private static final int fyl = "reserved1".hashCode();
  private static final int fym = "reserved2".hashCode();
  private static final int gcS = "filename".hashCode();
  private static final int gcT = "user".hashCode();
  private static final int gcU = "msgid".hashCode();
  private static final int gcV;
  private static final int gcW;
  private static final int gcX;
  private static final int gcY;
  private static final int gcZ;
  private static final int gda;
  private static final int gdb;
  private static final int gdc;
  private static final int gdd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fKX = true;
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
  private boolean fjY = true;
  private boolean fji = true;
  private boolean fxA = true;
  private boolean fxz = true;
  private boolean gcG = true;
  private boolean gcH = true;
  private boolean gcI = true;
  private boolean gcJ = true;
  private boolean gcK = true;
  private boolean gcL = true;
  private boolean gcM = true;
  private boolean gcN = true;
  private boolean gcO = true;
  private boolean gcP = true;
  private boolean gcQ = true;
  private boolean gcR = true;
  
  static
  {
    fkp = "offset".hashCode();
    gcV = "filenowsize".hashCode();
    gcW = "totallen".hashCode();
    fjl = "status".hashCode();
    fLi = "createtime".hashCode();
    gcX = "lastmodifytime".hashCode();
    gcY = "clientid".hashCode();
    gcZ = "voicelenght".hashCode();
    gda = "msglocalid".hashCode();
    gdb = "human".hashCode();
    gdc = "voiceformat".hashCode();
    gdd = "nettimes".hashCode();
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
      if (gcS != k) {
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
      if (gcT == k) {
        this.field_user = paramCursor.getString(i);
      } else if (gcU == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (fkp == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (gcV == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (gcW == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fLi == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (gcX == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (gcY == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (gcZ == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (gda == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (gdb == k) {
        this.field_human = paramCursor.getString(i);
      } else if (gdc == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (gdd == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (fyl == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (fym == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.gcG) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.gcH) {
      localContentValues.put("user", this.field_user);
    }
    if (this.gcI) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.fjY) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.gcJ) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.gcK) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.fji) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.fKX) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.gcL) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.gcM) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.gcN) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.gcO) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.gcP) {
      localContentValues.put("human", this.field_human);
    }
    if (this.gcQ) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.gcR) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.fxz) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.fxA) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.hb
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class hi
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
  public static final SingleTable TABLE = new SingleTable("VoiceRemindInfo");
  public static final Column hHc;
  public static final Column hHd;
  private static final int hIE = "reserved1".hashCode();
  private static final int hIF = "reserved2".hashCode();
  public static final Column hNx;
  private static final int hmC;
  public static final Column hml;
  public static final Column hmw;
  public static final Column hnE;
  public static final Column hnF;
  public static final Column hnH;
  public static final Column hnL;
  private static final int hon;
  public static final Column iCR;
  public static final Column iCS;
  public static final Column iCT;
  public static final Column iCU;
  public static final Column iCV;
  public static final Column iCW;
  private static final int iDj;
  private static final int iDk;
  private static final int iDl;
  private static final int iDm;
  private static final int iDn;
  private static final int iDo;
  private static final int iDp;
  private static final int iDq;
  private static final int iDr;
  private static final int iDs;
  private static final int iDt;
  private static final int iDu;
  private static final int icG;
  public static final Column iya;
  private static final int rowid_HASHCODE = "rowid".hashCode();
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
  private boolean hHQ = true;
  private boolean hHR = true;
  private boolean hmz = true;
  private boolean hnW = true;
  private boolean iCX = true;
  private boolean iCY = true;
  private boolean iCZ = true;
  private boolean iDa = true;
  private boolean iDb = true;
  private boolean iDc = true;
  private boolean iDd = true;
  private boolean iDe = true;
  private boolean iDf = true;
  private boolean iDg = true;
  private boolean iDh = true;
  private boolean iDi = true;
  private boolean icv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "VoiceRemindInfo", "");
    hNx = new Column("filename", "string", "VoiceRemindInfo", "");
    iCR = new Column("user", "string", "VoiceRemindInfo", "");
    hml = new Column("msgid", "long", "VoiceRemindInfo", "");
    hnF = new Column("offset", "int", "VoiceRemindInfo", "");
    iCS = new Column("filenowsize", "int", "VoiceRemindInfo", "");
    hnE = new Column("totallen", "int", "VoiceRemindInfo", "");
    hmw = new Column("status", "int", "VoiceRemindInfo", "");
    C_CREATETIME = new Column("createtime", "long", "VoiceRemindInfo", "");
    hnH = new Column("lastmodifytime", "long", "VoiceRemindInfo", "");
    iya = new Column("clientid", "string", "VoiceRemindInfo", "");
    iCT = new Column("voicelenght", "int", "VoiceRemindInfo", "");
    iCU = new Column("msglocalid", "int", "VoiceRemindInfo", "");
    iCV = new Column("human", "string", "VoiceRemindInfo", "");
    iCW = new Column("voiceformat", "int", "VoiceRemindInfo", "");
    hnL = new Column("nettimes", "int", "VoiceRemindInfo", "");
    hHc = new Column("reserved1", "int", "VoiceRemindInfo", "");
    hHd = new Column("reserved2", "string", "VoiceRemindInfo", "");
    iDj = "filename".hashCode();
    iDk = "user".hashCode();
    iDl = "msgid".hashCode();
    hon = "offset".hashCode();
    iDm = "filenowsize".hashCode();
    iDn = "totallen".hashCode();
    hmC = "status".hashCode();
    icG = "createtime".hashCode();
    iDo = "lastmodifytime".hashCode();
    iDp = "clientid".hashCode();
    iDq = "voicelenght".hashCode();
    iDr = "msglocalid".hashCode();
    iDs = "human".hashCode();
    iDt = "voiceformat".hashCode();
    iDu = "nettimes".hashCode();
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
      if (iDj != k) {
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
      if (iDk == k) {
        this.field_user = paramCursor.getString(i);
      } else if (iDl == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (hon == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (iDm == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (iDn == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (icG == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (iDo == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (iDp == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (iDq == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (iDr == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (iDs == k) {
        this.field_human = paramCursor.getString(i);
      } else if (iDt == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (iDu == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (hIE == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (hIF == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.iCX) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.iCY) {
      localContentValues.put("user", this.field_user);
    }
    if (this.iCZ) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.hnW) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.iDa) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.iDb) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.hmz) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.icv) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.iDc) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.iDd) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.iDe) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.iDf) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.iDg) {
      localContentValues.put("human", this.field_human);
    }
    if (this.iDh) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.iDi) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.hHQ) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.hHR) {
      localContentValues.put("reserved2", this.field_reserved2);
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
    return "VoiceRemindInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.hi
 * JD-Core Version:    0.7.0.1
 */
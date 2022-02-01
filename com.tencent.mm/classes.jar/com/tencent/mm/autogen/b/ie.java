package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ie
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("VoiceRemindInfo");
  private static final int jIF;
  public static final Column jIo;
  public static final Column jIz;
  public static final Column jKB;
  public static final Column jKu;
  public static final Column jKv;
  public static final Column jKx;
  private static final int jLd;
  private static final int kBR;
  private static final int kDR;
  public static final Column kYN;
  public static final Column keg;
  public static final Column keh;
  private static final int kfJ;
  private static final int kfK;
  public static final Column kkB;
  public static final Column leA;
  private static final int leM;
  private static final int leN;
  private static final int leO;
  private static final int leP;
  private static final int leQ;
  private static final int leR;
  private static final int leS;
  private static final int leT;
  private static final int leU;
  private static final int leV;
  private static final int leW;
  public static final Column lev;
  public static final Column lew;
  public static final Column lex;
  public static final Column ley;
  public static final Column lez;
  private static final StorageObserverOwner<ie> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
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
  private boolean jIC = true;
  private boolean jKM = true;
  private boolean kBG = true;
  private boolean kDP = true;
  private boolean keV = true;
  private boolean keW = true;
  private boolean leB = true;
  private boolean leC = true;
  private boolean leD = true;
  private boolean leE = true;
  private boolean leF = true;
  private boolean leG = true;
  private boolean leH = true;
  private boolean leI = true;
  private boolean leJ = true;
  private boolean leK = true;
  private boolean leL = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kkB = new Column("filename", "string", TABLE.getName(), "");
    lev = new Column("user", "string", TABLE.getName(), "");
    jIo = new Column("msgid", "long", TABLE.getName(), "");
    jKv = new Column("offset", "int", TABLE.getName(), "");
    lew = new Column("filenowsize", "int", TABLE.getName(), "");
    jKu = new Column("totallen", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    CREATETIME = new Column("createtime", "long", TABLE.getName(), "");
    jKx = new Column("lastmodifytime", "long", TABLE.getName(), "");
    kYN = new Column("clientid", "string", TABLE.getName(), "");
    lex = new Column("voicelenght", "int", TABLE.getName(), "");
    ley = new Column("msglocalid", "int", TABLE.getName(), "");
    lez = new Column("human", "string", TABLE.getName(), "");
    leA = new Column("voiceformat", "int", TABLE.getName(), "");
    jKB = new Column("nettimes", "int", TABLE.getName(), "");
    keg = new Column("reserved1", "int", TABLE.getName(), "");
    keh = new Column("reserved2", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS voiceRemindFileNameIndex ON VoiceRemindInfo(filename)" };
    leM = "filename".hashCode();
    leN = "user".hashCode();
    kDR = "msgid".hashCode();
    jLd = "offset".hashCode();
    leO = "filenowsize".hashCode();
    leP = "totallen".hashCode();
    jIF = "status".hashCode();
    kBR = "createtime".hashCode();
    leQ = "lastmodifytime".hashCode();
    leR = "clientid".hashCode();
    leS = "voicelenght".hashCode();
    leT = "msglocalid".hashCode();
    leU = "human".hashCode();
    leV = "voiceformat".hashCode();
    leW = "nettimes".hashCode();
    kfJ = "reserved1".hashCode();
    kfK = "reserved2".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[17];
    localMAutoDBInfo.columns = new String[18];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "filename";
    localMAutoDBInfo.colsMap.put("filename", "TEXT");
    localStringBuilder.append(" filename TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "user";
    localMAutoDBInfo.colsMap.put("user", "TEXT");
    localStringBuilder.append(" user TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "msgid";
    localMAutoDBInfo.colsMap.put("msgid", "LONG");
    localStringBuilder.append(" msgid LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "offset";
    localMAutoDBInfo.colsMap.put("offset", "INTEGER");
    localStringBuilder.append(" offset INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "filenowsize";
    localMAutoDBInfo.colsMap.put("filenowsize", "INTEGER");
    localStringBuilder.append(" filenowsize INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "totallen";
    localMAutoDBInfo.colsMap.put("totallen", "INTEGER");
    localStringBuilder.append(" totallen INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "createtime";
    localMAutoDBInfo.colsMap.put("createtime", "LONG");
    localStringBuilder.append(" createtime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "lastmodifytime";
    localMAutoDBInfo.colsMap.put("lastmodifytime", "LONG");
    localStringBuilder.append(" lastmodifytime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "clientid";
    localMAutoDBInfo.colsMap.put("clientid", "TEXT");
    localStringBuilder.append(" clientid TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "voicelenght";
    localMAutoDBInfo.colsMap.put("voicelenght", "INTEGER");
    localStringBuilder.append(" voicelenght INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "msglocalid";
    localMAutoDBInfo.colsMap.put("msglocalid", "INTEGER");
    localStringBuilder.append(" msglocalid INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "human";
    localMAutoDBInfo.colsMap.put("human", "TEXT");
    localStringBuilder.append(" human TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "voiceformat";
    localMAutoDBInfo.colsMap.put("voiceformat", "INTEGER");
    localStringBuilder.append(" voiceformat INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "nettimes";
    localMAutoDBInfo.colsMap.put("nettimes", "INTEGER");
    localStringBuilder.append(" nettimes INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "reserved1";
    localMAutoDBInfo.colsMap.put("reserved1", "INTEGER");
    localStringBuilder.append(" reserved1 INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "reserved2";
    localMAutoDBInfo.colsMap.put("reserved2", "TEXT");
    localStringBuilder.append(" reserved2 TEXT");
    localMAutoDBInfo.columns[17] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("filename"))
    {
      this.field_filename = paramContentValues.getAsString("filename");
      if (paramBoolean) {
        this.leB = true;
      }
    }
    if (paramContentValues.containsKey("user"))
    {
      this.field_user = paramContentValues.getAsString("user");
      if (paramBoolean) {
        this.leC = true;
      }
    }
    if (paramContentValues.containsKey("msgid"))
    {
      this.field_msgid = paramContentValues.getAsLong("msgid").longValue();
      if (paramBoolean) {
        this.kDP = true;
      }
    }
    if (paramContentValues.containsKey("offset"))
    {
      this.field_offset = paramContentValues.getAsInteger("offset").intValue();
      if (paramBoolean) {
        this.jKM = true;
      }
    }
    if (paramContentValues.containsKey("filenowsize"))
    {
      this.field_filenowsize = paramContentValues.getAsInteger("filenowsize").intValue();
      if (paramBoolean) {
        this.leD = true;
      }
    }
    if (paramContentValues.containsKey("totallen"))
    {
      this.field_totallen = paramContentValues.getAsInteger("totallen").intValue();
      if (paramBoolean) {
        this.leE = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("createtime"))
    {
      this.field_createtime = paramContentValues.getAsLong("createtime").longValue();
      if (paramBoolean) {
        this.kBG = true;
      }
    }
    if (paramContentValues.containsKey("lastmodifytime"))
    {
      this.field_lastmodifytime = paramContentValues.getAsLong("lastmodifytime").longValue();
      if (paramBoolean) {
        this.leF = true;
      }
    }
    if (paramContentValues.containsKey("clientid"))
    {
      this.field_clientid = paramContentValues.getAsString("clientid");
      if (paramBoolean) {
        this.leG = true;
      }
    }
    if (paramContentValues.containsKey("voicelenght"))
    {
      this.field_voicelenght = paramContentValues.getAsInteger("voicelenght").intValue();
      if (paramBoolean) {
        this.leH = true;
      }
    }
    if (paramContentValues.containsKey("msglocalid"))
    {
      this.field_msglocalid = paramContentValues.getAsInteger("msglocalid").intValue();
      if (paramBoolean) {
        this.leI = true;
      }
    }
    if (paramContentValues.containsKey("human"))
    {
      this.field_human = paramContentValues.getAsString("human");
      if (paramBoolean) {
        this.leJ = true;
      }
    }
    if (paramContentValues.containsKey("voiceformat"))
    {
      this.field_voiceformat = paramContentValues.getAsInteger("voiceformat").intValue();
      if (paramBoolean) {
        this.leK = true;
      }
    }
    if (paramContentValues.containsKey("nettimes"))
    {
      this.field_nettimes = paramContentValues.getAsInteger("nettimes").intValue();
      if (paramBoolean) {
        this.leL = true;
      }
    }
    if (paramContentValues.containsKey("reserved1"))
    {
      this.field_reserved1 = paramContentValues.getAsInteger("reserved1").intValue();
      if (paramBoolean) {
        this.keV = true;
      }
    }
    if (paramContentValues.containsKey("reserved2"))
    {
      this.field_reserved2 = paramContentValues.getAsString("reserved2");
      if (paramBoolean) {
        this.keW = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
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
      if (leM != k) {
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
      if (leN == k) {
        this.field_user = paramCursor.getString(i);
      } else if (kDR == k) {
        this.field_msgid = paramCursor.getLong(i);
      } else if (jLd == k) {
        this.field_offset = paramCursor.getInt(i);
      } else if (leO == k) {
        this.field_filenowsize = paramCursor.getInt(i);
      } else if (leP == k) {
        this.field_totallen = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kBR == k) {
        this.field_createtime = paramCursor.getLong(i);
      } else if (leQ == k) {
        this.field_lastmodifytime = paramCursor.getLong(i);
      } else if (leR == k) {
        this.field_clientid = paramCursor.getString(i);
      } else if (leS == k) {
        this.field_voicelenght = paramCursor.getInt(i);
      } else if (leT == k) {
        this.field_msglocalid = paramCursor.getInt(i);
      } else if (leU == k) {
        this.field_human = paramCursor.getString(i);
      } else if (leV == k) {
        this.field_voiceformat = paramCursor.getInt(i);
      } else if (leW == k) {
        this.field_nettimes = paramCursor.getInt(i);
      } else if (kfJ == k) {
        this.field_reserved1 = paramCursor.getInt(i);
      } else if (kfK == k) {
        this.field_reserved2 = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.leB) {
      localContentValues.put("filename", this.field_filename);
    }
    if (this.leC) {
      localContentValues.put("user", this.field_user);
    }
    if (this.kDP) {
      localContentValues.put("msgid", Long.valueOf(this.field_msgid));
    }
    if (this.jKM) {
      localContentValues.put("offset", Integer.valueOf(this.field_offset));
    }
    if (this.leD) {
      localContentValues.put("filenowsize", Integer.valueOf(this.field_filenowsize));
    }
    if (this.leE) {
      localContentValues.put("totallen", Integer.valueOf(this.field_totallen));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kBG) {
      localContentValues.put("createtime", Long.valueOf(this.field_createtime));
    }
    if (this.leF) {
      localContentValues.put("lastmodifytime", Long.valueOf(this.field_lastmodifytime));
    }
    if (this.leG) {
      localContentValues.put("clientid", this.field_clientid);
    }
    if (this.leH) {
      localContentValues.put("voicelenght", Integer.valueOf(this.field_voicelenght));
    }
    if (this.leI) {
      localContentValues.put("msglocalid", Integer.valueOf(this.field_msglocalid));
    }
    if (this.leJ) {
      localContentValues.put("human", this.field_human);
    }
    if (this.leK) {
      localContentValues.put("voiceformat", Integer.valueOf(this.field_voiceformat));
    }
    if (this.leL) {
      localContentValues.put("nettimes", Integer.valueOf(this.field_nettimes));
    }
    if (this.keV) {
      localContentValues.put("reserved1", Integer.valueOf(this.field_reserved1));
    }
    if (this.keW) {
      localContentValues.put("reserved2", this.field_reserved2);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends ie> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ie
 * JD-Core Version:    0.7.0.1
 */
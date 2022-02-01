package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.dn;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class di
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FunctionMsgItem");
  private static final int jIF;
  public static final Column jIz;
  private static final int jMG;
  public static final Column jMP;
  public static final Column jMw;
  private static final int kmM;
  public static final Column kml;
  private static final int kmp;
  public static final Column kms;
  public static final Column knj;
  private static final int koF;
  private static final int kvQ;
  private static final int kvR;
  private static final int kvS;
  private static final int kvT;
  private static final int kvU;
  private static final int kvV;
  private static final int kvW;
  private static final int kvX;
  private static final int kvY;
  private static final int kvZ;
  public static final Column kvj;
  public static final Column kvk;
  public static final Column kvl;
  public static final Column kvm;
  public static final Column kvn;
  public static final Column kvo;
  public static final Column kvp;
  public static final Column kvq;
  public static final Column kvr;
  public static final Column kvs;
  public static final Column kvt;
  public static final Column kvu;
  public static final Column kvv;
  public static final Column kvw;
  public static final Column kvx;
  public static final Column kvy;
  private static final int kwa;
  private static final int kwb;
  private static final int kwc;
  private static final int kwd;
  private static final int kwe;
  private static final int kwf;
  private static final int kwg;
  private static final StorageObserverOwner<di> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_actionTime;
  public dl field_addMsg;
  public dn field_addMsgs;
  public tb field_businessInfo;
  public String field_cgi;
  public int field_cmdid;
  public String field_custombuff;
  public String field_defaultContent;
  public long field_delayTime;
  public int field_failkey;
  public int field_finalfailkey;
  public String field_functionmsgid;
  public boolean field_needShow;
  public int field_opCode;
  public long field_preVersion;
  public int field_reportid;
  public int field_retryCount;
  public int field_retryCountLimit;
  public int field_retryinterval;
  public int field_status;
  public int field_successkey;
  public long field_version;
  private boolean jIC = true;
  private boolean jMB = true;
  private boolean kmC = true;
  private boolean kmn = true;
  private boolean knU = true;
  private boolean kvA = true;
  private boolean kvB = true;
  private boolean kvC = true;
  private boolean kvD = true;
  private boolean kvE = true;
  private boolean kvF = true;
  private boolean kvG = true;
  private boolean kvH = true;
  private boolean kvI = true;
  private boolean kvJ = true;
  private boolean kvK = true;
  private boolean kvL = true;
  private boolean kvM = true;
  private boolean kvN = true;
  private boolean kvO = true;
  private boolean kvP = true;
  private boolean kvz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kml = new Column("cgi", "string", TABLE.getName(), "");
    kvj = new Column("cmdid", "int", TABLE.getName(), "");
    kvk = new Column("functionmsgid", "string", TABLE.getName(), "");
    jMw = new Column("version", "long", TABLE.getName(), "");
    kvl = new Column("preVersion", "long", TABLE.getName(), "");
    kvm = new Column("retryinterval", "int", TABLE.getName(), "");
    jMP = new Column("reportid", "int", TABLE.getName(), "");
    kvn = new Column("successkey", "int", TABLE.getName(), "");
    kvo = new Column("failkey", "int", TABLE.getName(), "");
    kvp = new Column("finalfailkey", "int", TABLE.getName(), "");
    kvq = new Column("custombuff", "string", TABLE.getName(), "");
    kvr = new Column("addMsg", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.AddMsg");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kvs = new Column("needShow", "boolean", TABLE.getName(), "");
    kvt = new Column("defaultContent", "string", TABLE.getName(), "");
    kms = new Column("actionTime", "long", TABLE.getName(), "");
    kvu = new Column("delayTime", "long", TABLE.getName(), "");
    knj = new Column("retryCount", "int", TABLE.getName(), "");
    kvv = new Column("retryCountLimit", "int", TABLE.getName(), "");
    kvw = new Column("businessInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.BusinessInfo");
    kvx = new Column("opCode", "int", TABLE.getName(), "");
    kvy = new Column("addMsgs", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.AddMsgList");
    INDEX_CREATE = new String[0];
    kmp = "cgi".hashCode();
    kvQ = "cmdid".hashCode();
    kvR = "functionmsgid".hashCode();
    jMG = "version".hashCode();
    kvS = "preVersion".hashCode();
    kvT = "retryinterval".hashCode();
    kvU = "reportid".hashCode();
    kvV = "successkey".hashCode();
    kvW = "failkey".hashCode();
    kvX = "finalfailkey".hashCode();
    kvY = "custombuff".hashCode();
    kvZ = "addMsg".hashCode();
    jIF = "status".hashCode();
    kwa = "needShow".hashCode();
    kwb = "defaultContent".hashCode();
    kmM = "actionTime".hashCode();
    kwc = "delayTime".hashCode();
    koF = "retryCount".hashCode();
    kwd = "retryCountLimit".hashCode();
    kwe = "businessInfo".hashCode();
    kwf = "opCode".hashCode();
    kwg = "addMsgs".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[22];
    localMAutoDBInfo.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "cgi";
    localMAutoDBInfo.colsMap.put("cgi", "TEXT");
    localStringBuilder.append(" cgi TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "cmdid";
    localMAutoDBInfo.colsMap.put("cmdid", "INTEGER");
    localStringBuilder.append(" cmdid INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "functionmsgid";
    localMAutoDBInfo.colsMap.put("functionmsgid", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" functionmsgid TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "functionmsgid";
    localMAutoDBInfo.columns[3] = "version";
    localMAutoDBInfo.colsMap.put("version", "LONG");
    localStringBuilder.append(" version LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "preVersion";
    localMAutoDBInfo.colsMap.put("preVersion", "LONG");
    localStringBuilder.append(" preVersion LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "retryinterval";
    localMAutoDBInfo.colsMap.put("retryinterval", "INTEGER");
    localStringBuilder.append(" retryinterval INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "reportid";
    localMAutoDBInfo.colsMap.put("reportid", "INTEGER");
    localStringBuilder.append(" reportid INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "successkey";
    localMAutoDBInfo.colsMap.put("successkey", "INTEGER");
    localStringBuilder.append(" successkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "failkey";
    localMAutoDBInfo.colsMap.put("failkey", "INTEGER");
    localStringBuilder.append(" failkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "finalfailkey";
    localMAutoDBInfo.colsMap.put("finalfailkey", "INTEGER");
    localStringBuilder.append(" finalfailkey INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "custombuff";
    localMAutoDBInfo.colsMap.put("custombuff", "TEXT");
    localStringBuilder.append(" custombuff TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "addMsg";
    localMAutoDBInfo.colsMap.put("addMsg", "BLOB");
    localStringBuilder.append(" addMsg BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER default '-1' ");
    localStringBuilder.append(" status INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "needShow";
    localMAutoDBInfo.colsMap.put("needShow", "INTEGER default 'false' ");
    localStringBuilder.append(" needShow INTEGER default 'false' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "defaultContent";
    localMAutoDBInfo.colsMap.put("defaultContent", "TEXT");
    localStringBuilder.append(" defaultContent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "actionTime";
    localMAutoDBInfo.colsMap.put("actionTime", "LONG default '-1' ");
    localStringBuilder.append(" actionTime LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "delayTime";
    localMAutoDBInfo.colsMap.put("delayTime", "LONG default '-1' ");
    localStringBuilder.append(" delayTime LONG default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "retryCount";
    localMAutoDBInfo.colsMap.put("retryCount", "INTEGER default '0' ");
    localStringBuilder.append(" retryCount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "retryCountLimit";
    localMAutoDBInfo.colsMap.put("retryCountLimit", "INTEGER default '0' ");
    localStringBuilder.append(" retryCountLimit INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "businessInfo";
    localMAutoDBInfo.colsMap.put("businessInfo", "BLOB");
    localStringBuilder.append(" businessInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "opCode";
    localMAutoDBInfo.colsMap.put("opCode", "INTEGER default '-1' ");
    localStringBuilder.append(" opCode INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "addMsgs";
    localMAutoDBInfo.colsMap.put("addMsgs", "BLOB");
    localStringBuilder.append(" addMsgs BLOB");
    localMAutoDBInfo.columns[22] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("cgi"))
    {
      this.field_cgi = paramContentValues.getAsString("cgi");
      if (paramBoolean) {
        this.kmn = true;
      }
    }
    if (paramContentValues.containsKey("cmdid"))
    {
      this.field_cmdid = paramContentValues.getAsInteger("cmdid").intValue();
      if (paramBoolean) {
        this.kvz = true;
      }
    }
    if (paramContentValues.containsKey("functionmsgid"))
    {
      this.field_functionmsgid = paramContentValues.getAsString("functionmsgid");
      if (paramBoolean) {
        this.kvA = true;
      }
    }
    if (paramContentValues.containsKey("version"))
    {
      this.field_version = paramContentValues.getAsLong("version").longValue();
      if (paramBoolean) {
        this.jMB = true;
      }
    }
    if (paramContentValues.containsKey("preVersion"))
    {
      this.field_preVersion = paramContentValues.getAsLong("preVersion").longValue();
      if (paramBoolean) {
        this.kvB = true;
      }
    }
    if (paramContentValues.containsKey("retryinterval"))
    {
      this.field_retryinterval = paramContentValues.getAsInteger("retryinterval").intValue();
      if (paramBoolean) {
        this.kvC = true;
      }
    }
    if (paramContentValues.containsKey("reportid"))
    {
      this.field_reportid = paramContentValues.getAsInteger("reportid").intValue();
      if (paramBoolean) {
        this.kvD = true;
      }
    }
    if (paramContentValues.containsKey("successkey"))
    {
      this.field_successkey = paramContentValues.getAsInteger("successkey").intValue();
      if (paramBoolean) {
        this.kvE = true;
      }
    }
    if (paramContentValues.containsKey("failkey"))
    {
      this.field_failkey = paramContentValues.getAsInteger("failkey").intValue();
      if (paramBoolean) {
        this.kvF = true;
      }
    }
    if (paramContentValues.containsKey("finalfailkey"))
    {
      this.field_finalfailkey = paramContentValues.getAsInteger("finalfailkey").intValue();
      if (paramBoolean) {
        this.kvG = true;
      }
    }
    if (paramContentValues.containsKey("custombuff"))
    {
      this.field_custombuff = paramContentValues.getAsString("custombuff");
      if (paramBoolean) {
        this.kvH = true;
      }
    }
    if (paramContentValues.containsKey("addMsg")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("addMsg");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_addMsg = ((dl)new dl().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kvI = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        continue;
        boolean bool = false;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("needShow"))
    {
      if (paramContentValues.getAsInteger("needShow").intValue() == 0) {
        break label790;
      }
      bool = true;
      this.field_needShow = bool;
      if (paramBoolean) {
        this.kvJ = true;
      }
    }
    if (paramContentValues.containsKey("defaultContent"))
    {
      this.field_defaultContent = paramContentValues.getAsString("defaultContent");
      if (paramBoolean) {
        this.kvK = true;
      }
    }
    if (paramContentValues.containsKey("actionTime"))
    {
      this.field_actionTime = paramContentValues.getAsLong("actionTime").longValue();
      if (paramBoolean) {
        this.kmC = true;
      }
    }
    if (paramContentValues.containsKey("delayTime"))
    {
      this.field_delayTime = paramContentValues.getAsLong("delayTime").longValue();
      if (paramBoolean) {
        this.kvL = true;
      }
    }
    if (paramContentValues.containsKey("retryCount"))
    {
      this.field_retryCount = paramContentValues.getAsInteger("retryCount").intValue();
      if (paramBoolean) {
        this.knU = true;
      }
    }
    if (paramContentValues.containsKey("retryCountLimit"))
    {
      this.field_retryCountLimit = paramContentValues.getAsInteger("retryCountLimit").intValue();
      if (paramBoolean) {
        this.kvM = true;
      }
    }
    if (paramContentValues.containsKey("businessInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("businessInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_businessInfo = ((tb)new tb().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kvN = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("opCode"))
    {
      this.field_opCode = paramContentValues.getAsInteger("opCode").intValue();
      if (paramBoolean) {
        this.kvO = true;
      }
    }
    if (paramContentValues.containsKey("addMsgs")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("addMsgs");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_addMsgs = ((dn)new dn().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kvP = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException3.getMessage());
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (kmp != k) {
        break label60;
      }
      this.field_cgi = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kvQ == k)
      {
        this.field_cmdid = paramCursor.getInt(i);
      }
      else if (kvR == k)
      {
        this.field_functionmsgid = paramCursor.getString(i);
        this.kvA = true;
      }
      else if (jMG == k)
      {
        this.field_version = paramCursor.getLong(i);
      }
      else if (kvS == k)
      {
        this.field_preVersion = paramCursor.getLong(i);
      }
      else if (kvT == k)
      {
        this.field_retryinterval = paramCursor.getInt(i);
      }
      else if (kvU == k)
      {
        this.field_reportid = paramCursor.getInt(i);
      }
      else if (kvV == k)
      {
        this.field_successkey = paramCursor.getInt(i);
      }
      else if (kvW == k)
      {
        this.field_failkey = paramCursor.getInt(i);
      }
      else if (kvX == k)
      {
        this.field_finalfailkey = paramCursor.getInt(i);
      }
      else if (kvY == k)
      {
        this.field_custombuff = paramCursor.getString(i);
      }
      else if (kvZ == k)
      {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_addMsg = ((dl)new dl().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
        }
      }
      else if (jIF == k)
      {
        this.field_status = paramCursor.getInt(i);
      }
      else
      {
        if (kwa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_needShow = bool;
            break;
          }
        }
        if (kwb == k) {
          this.field_defaultContent = paramCursor.getString(i);
        } else if (kmM == k) {
          this.field_actionTime = paramCursor.getLong(i);
        } else if (kwc == k) {
          this.field_delayTime = paramCursor.getLong(i);
        } else if (koF == k) {
          this.field_retryCount = paramCursor.getInt(i);
        } else if (kwd == k) {
          this.field_retryCountLimit = paramCursor.getInt(i);
        } else if (kwe == k) {
          try
          {
            byte[] arrayOfByte2 = paramCursor.getBlob(i);
            if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
              continue;
            }
            this.field_businessInfo = ((tb)new tb().parseFrom(arrayOfByte2));
          }
          catch (IOException localIOException2)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
          }
        } else if (kwf == k) {
          this.field_opCode = paramCursor.getInt(i);
        } else if (kwg == k) {
          try
          {
            byte[] arrayOfByte3 = paramCursor.getBlob(i);
            if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
              continue;
            }
            this.field_addMsgs = ((dn)new dn().parseFrom(arrayOfByte3));
          }
          catch (IOException localIOException3)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException3.getMessage());
          }
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kmn) {
      localContentValues.put("cgi", this.field_cgi);
    }
    if (this.kvz) {
      localContentValues.put("cmdid", Integer.valueOf(this.field_cmdid));
    }
    if (this.kvA) {
      localContentValues.put("functionmsgid", this.field_functionmsgid);
    }
    if (this.jMB) {
      localContentValues.put("version", Long.valueOf(this.field_version));
    }
    if (this.kvB) {
      localContentValues.put("preVersion", Long.valueOf(this.field_preVersion));
    }
    if (this.kvC) {
      localContentValues.put("retryinterval", Integer.valueOf(this.field_retryinterval));
    }
    if (this.kvD) {
      localContentValues.put("reportid", Integer.valueOf(this.field_reportid));
    }
    if (this.kvE) {
      localContentValues.put("successkey", Integer.valueOf(this.field_successkey));
    }
    if (this.kvF) {
      localContentValues.put("failkey", Integer.valueOf(this.field_failkey));
    }
    if (this.kvG) {
      localContentValues.put("finalfailkey", Integer.valueOf(this.field_finalfailkey));
    }
    if (this.kvH) {
      localContentValues.put("custombuff", this.field_custombuff);
    }
    if ((this.kvI) && (this.field_addMsg != null)) {}
    try
    {
      localContentValues.put("addMsg", this.field_addMsg.toByteArray());
      if (this.jIC) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.kvJ) {
        localContentValues.put("needShow", Boolean.valueOf(this.field_needShow));
      }
      if (this.kvK) {
        localContentValues.put("defaultContent", this.field_defaultContent);
      }
      if (this.kmC) {
        localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
      }
      if (this.kvL) {
        localContentValues.put("delayTime", Long.valueOf(this.field_delayTime));
      }
      if (this.knU) {
        localContentValues.put("retryCount", Integer.valueOf(this.field_retryCount));
      }
      if (this.kvM) {
        localContentValues.put("retryCountLimit", Integer.valueOf(this.field_retryCountLimit));
      }
      if ((!this.kvN) || (this.field_businessInfo == null)) {}
    }
    catch (IOException localIOException2)
    {
      try
      {
        localContentValues.put("businessInfo", this.field_businessInfo.toByteArray());
        if (this.kvO) {
          localContentValues.put("opCode", Integer.valueOf(this.field_opCode));
        }
        if ((!this.kvP) || (this.field_addMsgs == null)) {}
      }
      catch (IOException localIOException2)
      {
        try
        {
          for (;;)
          {
            localContentValues.put("addMsgs", this.field_addMsgs.toByteArray());
            if (this.systemRowid > 0L) {
              localContentValues.put("rowid", Long.valueOf(this.systemRowid));
            }
            return localContentValues;
            localIOException1 = localIOException1;
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException1.getMessage());
          }
          localIOException2 = localIOException2;
          Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException2.getMessage());
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.SDK.BaseFunctionMsgItem", localIOException3.getMessage());
          }
        }
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends di> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_functionmsgid;
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
 * Qualified Name:     com.tencent.mm.autogen.b.di
 * JD-Core Version:    0.7.0.1
 */
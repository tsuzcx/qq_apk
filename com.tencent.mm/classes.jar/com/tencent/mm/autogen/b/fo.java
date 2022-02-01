package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fni;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fo
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("NewTipsInfo");
  private static final int jSZ;
  public static final Column jSx;
  private static final int kOM;
  private static final int kON;
  private static final int kOO;
  private static final int kOP;
  private static final int kOQ;
  private static final int kOR;
  private static final int kOS;
  private static final int kOT;
  private static final int kOU;
  private static final int kOV;
  private static final int kOW;
  private static final int kOX;
  public static final Column kOo;
  public static final Column kOp;
  public static final Column kOq;
  public static final Column kOr;
  public static final Column kOs;
  public static final Column kOt;
  public static final Column kOu;
  public static final Column kOv;
  public static final Column kOw;
  public static final Column kOx;
  public static final Column kOy;
  public static final Column kOz;
  private static final StorageObserverOwner<fo> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_beginShowTime;
  public long field_disappearTime;
  public String field_extInfo;
  public boolean field_hadRead;
  public boolean field_isExit;
  public boolean field_isReject;
  public long field_overdueTime;
  public long field_pagestaytime;
  public int field_tipId;
  public int field_tipType;
  public int field_tipVersion;
  public String field_tipkey;
  public fni field_tipsShowInfo;
  private boolean jSL = true;
  private boolean kOA = true;
  private boolean kOB = true;
  private boolean kOC = true;
  private boolean kOD = true;
  private boolean kOE = true;
  private boolean kOF = true;
  private boolean kOG = true;
  private boolean kOH = true;
  private boolean kOI = true;
  private boolean kOJ = true;
  private boolean kOK = true;
  private boolean kOL = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kOo = new Column("tipId", "int", TABLE.getName(), "");
    kOp = new Column("tipVersion", "int", TABLE.getName(), "");
    kOq = new Column("tipkey", "string", TABLE.getName(), "");
    kOr = new Column("tipType", "int", TABLE.getName(), "");
    kOs = new Column("isExit", "boolean", TABLE.getName(), "");
    kOt = new Column("hadRead", "boolean", TABLE.getName(), "");
    kOu = new Column("isReject", "boolean", TABLE.getName(), "");
    kOv = new Column("beginShowTime", "long", TABLE.getName(), "");
    kOw = new Column("disappearTime", "long", TABLE.getName(), "");
    kOx = new Column("overdueTime", "long", TABLE.getName(), "");
    kOy = new Column("tipsShowInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.TipsShowInfo");
    jSx = new Column("extInfo", "string", TABLE.getName(), "");
    kOz = new Column("pagestaytime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kOM = "tipId".hashCode();
    kON = "tipVersion".hashCode();
    kOO = "tipkey".hashCode();
    kOP = "tipType".hashCode();
    kOQ = "isExit".hashCode();
    kOR = "hadRead".hashCode();
    kOS = "isReject".hashCode();
    kOT = "beginShowTime".hashCode();
    kOU = "disappearTime".hashCode();
    kOV = "overdueTime".hashCode();
    kOW = "tipsShowInfo".hashCode();
    jSZ = "extInfo".hashCode();
    kOX = "pagestaytime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tipId";
    localMAutoDBInfo.colsMap.put("tipId", "INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(" tipId INTEGER default '0'  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "tipId";
    localMAutoDBInfo.columns[1] = "tipVersion";
    localMAutoDBInfo.colsMap.put("tipVersion", "INTEGER");
    localStringBuilder.append(" tipVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "tipkey";
    localMAutoDBInfo.colsMap.put("tipkey", "TEXT");
    localStringBuilder.append(" tipkey TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "tipType";
    localMAutoDBInfo.colsMap.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "isExit";
    localMAutoDBInfo.colsMap.put("isExit", "INTEGER");
    localStringBuilder.append(" isExit INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "hadRead";
    localMAutoDBInfo.colsMap.put("hadRead", "INTEGER");
    localStringBuilder.append(" hadRead INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "isReject";
    localMAutoDBInfo.colsMap.put("isReject", "INTEGER");
    localStringBuilder.append(" isReject INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "beginShowTime";
    localMAutoDBInfo.colsMap.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "disappearTime";
    localMAutoDBInfo.colsMap.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "overdueTime";
    localMAutoDBInfo.colsMap.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "tipsShowInfo";
    localMAutoDBInfo.colsMap.put("tipsShowInfo", "BLOB");
    localStringBuilder.append(" tipsShowInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "pagestaytime";
    localMAutoDBInfo.colsMap.put("pagestaytime", "LONG");
    localStringBuilder.append(" pagestaytime LONG");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("tipId"))
    {
      this.field_tipId = paramContentValues.getAsInteger("tipId").intValue();
      if (paramBoolean) {
        this.kOA = true;
      }
    }
    if (paramContentValues.containsKey("tipVersion"))
    {
      this.field_tipVersion = paramContentValues.getAsInteger("tipVersion").intValue();
      if (paramBoolean) {
        this.kOB = true;
      }
    }
    if (paramContentValues.containsKey("tipkey"))
    {
      this.field_tipkey = paramContentValues.getAsString("tipkey");
      if (paramBoolean) {
        this.kOC = true;
      }
    }
    if (paramContentValues.containsKey("tipType"))
    {
      this.field_tipType = paramContentValues.getAsInteger("tipType").intValue();
      if (paramBoolean) {
        this.kOD = true;
      }
    }
    if (paramContentValues.containsKey("isExit"))
    {
      if (paramContentValues.getAsInteger("isExit").intValue() == 0) {
        break label469;
      }
      bool1 = true;
      this.field_isExit = bool1;
      if (paramBoolean) {
        this.kOE = true;
      }
    }
    if (paramContentValues.containsKey("hadRead")) {
      if (paramContentValues.getAsInteger("hadRead").intValue() == 0) {
        break label474;
      }
    }
    label469:
    label474:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_hadRead = bool1;
      if (paramBoolean) {
        this.kOF = true;
      }
      if (paramContentValues.containsKey("isReject"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("isReject").intValue() != 0) {
          bool1 = true;
        }
        this.field_isReject = bool1;
        if (paramBoolean) {
          this.kOG = true;
        }
      }
      if (paramContentValues.containsKey("beginShowTime"))
      {
        this.field_beginShowTime = paramContentValues.getAsLong("beginShowTime").longValue();
        if (paramBoolean) {
          this.kOH = true;
        }
      }
      if (paramContentValues.containsKey("disappearTime"))
      {
        this.field_disappearTime = paramContentValues.getAsLong("disappearTime").longValue();
        if (paramBoolean) {
          this.kOI = true;
        }
      }
      if (paramContentValues.containsKey("overdueTime"))
      {
        this.field_overdueTime = paramContentValues.getAsLong("overdueTime").longValue();
        if (paramBoolean) {
          this.kOJ = true;
        }
      }
      if (paramContentValues.containsKey("tipsShowInfo")) {}
      try
      {
        byte[] arrayOfByte = paramContentValues.getAsByteArray("tipsShowInfo");
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          this.field_tipsShowInfo = ((fni)new fni().parseFrom(arrayOfByte));
          if (paramBoolean) {
            this.kOK = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
        }
      }
      if (paramContentValues.containsKey("extInfo"))
      {
        this.field_extInfo = paramContentValues.getAsString("extInfo");
        if (paramBoolean) {
          this.jSL = true;
        }
      }
      if (paramContentValues.containsKey("pagestaytime"))
      {
        this.field_pagestaytime = paramContentValues.getAsLong("pagestaytime").longValue();
        if (paramBoolean) {
          this.kOL = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
      bool1 = false;
      break;
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
      if (kOM != k) {
        break label65;
      }
      this.field_tipId = paramCursor.getInt(i);
      this.kOA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kON == k)
      {
        this.field_tipVersion = paramCursor.getInt(i);
      }
      else if (kOO == k)
      {
        this.field_tipkey = paramCursor.getString(i);
      }
      else if (kOP == k)
      {
        this.field_tipType = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (kOQ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isExit = bool;
            break;
          }
        }
        if (kOR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_hadRead = bool;
            break;
          }
        }
        if (kOS == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isReject = bool;
            break;
          }
        }
        if (kOT == k) {
          this.field_beginShowTime = paramCursor.getLong(i);
        } else if (kOU == k) {
          this.field_disappearTime = paramCursor.getLong(i);
        } else if (kOV == k) {
          this.field_overdueTime = paramCursor.getLong(i);
        } else if (kOW == k) {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_tipsShowInfo = ((fni)new fni().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
          }
        } else if (jSZ == k) {
          this.field_extInfo = paramCursor.getString(i);
        } else if (kOX == k) {
          this.field_pagestaytime = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kOA) {
      localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
    }
    if (this.kOB) {
      localContentValues.put("tipVersion", Integer.valueOf(this.field_tipVersion));
    }
    if (this.kOC) {
      localContentValues.put("tipkey", this.field_tipkey);
    }
    if (this.kOD) {
      localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
    }
    if (this.kOE) {
      localContentValues.put("isExit", Boolean.valueOf(this.field_isExit));
    }
    if (this.kOF) {
      localContentValues.put("hadRead", Boolean.valueOf(this.field_hadRead));
    }
    if (this.kOG) {
      localContentValues.put("isReject", Boolean.valueOf(this.field_isReject));
    }
    if (this.kOH) {
      localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
    }
    if (this.kOI) {
      localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
    }
    if (this.kOJ) {
      localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
    }
    if ((this.kOK) && (this.field_tipsShowInfo != null)) {}
    try
    {
      localContentValues.put("tipsShowInfo", this.field_tipsShowInfo.toByteArray());
      if (this.jSL) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.kOL) {
        localContentValues.put("pagestaytime", Long.valueOf(this.field_pagestaytime));
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseNewTipsInfo", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends fo> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_tipId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.fo
 * JD-Core Version:    0.7.0.1
 */
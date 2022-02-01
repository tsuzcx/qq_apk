package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.btw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class dc
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderRedDotInfo");
  public static final Column jJF;
  private static final int jKd;
  public static final Column jUS;
  private static final int jVE;
  private static final int ksI;
  public static final Column kss;
  public static final Column kud;
  public static final Column kue;
  public static final Column kuf;
  public static final Column kug;
  public static final Column kuh;
  private static final int kun;
  private static final int kuo;
  private static final int kup;
  private static final int kuq;
  private static final int kur;
  private static final StorageObserverOwner<dc> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public long field_aiScene;
  public btw field_ctrInfo;
  public int field_ctrType;
  public long field_expiredTime;
  public String field_revokeId;
  public long field_time;
  public String field_tipsId;
  public FinderTipsShowEntranceExtInfo field_tipsShowEntranceExtInfo;
  private boolean jJR = true;
  private boolean jVl = true;
  private boolean ksA = true;
  private boolean kui = true;
  private boolean kuj = true;
  private boolean kuk = true;
  private boolean kul = true;
  private boolean kum = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    jJF = new Column("tipsId", "string", TABLE.getName(), "");
    kud = new Column("ctrInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderRedDotCtrlInfo");
    jUS = new Column("time", "long", TABLE.getName(), "");
    kss = new Column("revokeId", "string", TABLE.getName(), "");
    kue = new Column("tipsShowEntranceExtInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo");
    kuf = new Column("ctrType", "int", TABLE.getName(), "");
    kug = new Column("expiredTime", "long", TABLE.getName(), "");
    kuh = new Column("aiScene", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_ctrType ON FinderRedDotInfo(ctrType)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_expiredTime ON FinderRedDotInfo(expiredTime)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_ai_scene ON FinderRedDotInfo(aiScene)" };
    jKd = "tipsId".hashCode();
    kun = "ctrInfo".hashCode();
    jVE = "time".hashCode();
    ksI = "revokeId".hashCode();
    kuo = "tipsShowEntranceExtInfo".hashCode();
    kup = "ctrType".hashCode();
    kuq = "expiredTime".hashCode();
    kur = "aiScene".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tipsId";
    localMAutoDBInfo.colsMap.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "tipsId";
    localMAutoDBInfo.columns[1] = "ctrInfo";
    localMAutoDBInfo.colsMap.put("ctrInfo", "BLOB");
    localStringBuilder.append(" ctrInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "time";
    localMAutoDBInfo.colsMap.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "revokeId";
    localMAutoDBInfo.colsMap.put("revokeId", "TEXT");
    localStringBuilder.append(" revokeId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tipsShowEntranceExtInfo";
    localMAutoDBInfo.colsMap.put("tipsShowEntranceExtInfo", "BLOB");
    localStringBuilder.append(" tipsShowEntranceExtInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "ctrType";
    localMAutoDBInfo.colsMap.put("ctrType", "INTEGER");
    localStringBuilder.append(" ctrType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "expiredTime";
    localMAutoDBInfo.colsMap.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "aiScene";
    localMAutoDBInfo.colsMap.put("aiScene", "LONG");
    localStringBuilder.append(" aiScene LONG");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("tipsId"))
    {
      this.field_tipsId = paramContentValues.getAsString("tipsId");
      if (paramBoolean) {
        this.jJR = true;
      }
    }
    if (paramContentValues.containsKey("ctrInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("ctrInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_ctrInfo = ((btw)new btw().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kui = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("time"))
    {
      this.field_time = paramContentValues.getAsLong("time").longValue();
      if (paramBoolean) {
        this.jVl = true;
      }
    }
    if (paramContentValues.containsKey("revokeId"))
    {
      this.field_revokeId = paramContentValues.getAsString("revokeId");
      if (paramBoolean) {
        this.ksA = true;
      }
    }
    if (paramContentValues.containsKey("tipsShowEntranceExtInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("tipsShowEntranceExtInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_tipsShowEntranceExtInfo = ((FinderTipsShowEntranceExtInfo)new FinderTipsShowEntranceExtInfo().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kuj = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("ctrType"))
    {
      this.field_ctrType = paramContentValues.getAsInteger("ctrType").intValue();
      if (paramBoolean) {
        this.kuk = true;
      }
    }
    if (paramContentValues.containsKey("expiredTime"))
    {
      this.field_expiredTime = paramContentValues.getAsLong("expiredTime").longValue();
      if (paramBoolean) {
        this.kul = true;
      }
    }
    if (paramContentValues.containsKey("aiScene"))
    {
      this.field_aiScene = paramContentValues.getAsLong("aiScene").longValue();
      if (paramBoolean) {
        this.kum = true;
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
      if (jKd != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.jJR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kun == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((btw)new btw().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
        }
      } else if (jVE == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (ksI == k) {
        this.field_revokeId = paramCursor.getString(i);
      } else if (kuo == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tipsShowEntranceExtInfo = ((FinderTipsShowEntranceExtInfo)new FinderTipsShowEntranceExtInfo().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      } else if (kup == k) {
        this.field_ctrType = paramCursor.getInt(i);
      } else if (kuq == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (kur == k) {
        this.field_aiScene = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.jJR) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.kui) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.jVl) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.ksA) {
        localContentValues.put("revokeId", this.field_revokeId);
      }
      if ((!this.kuj) || (this.field_tipsShowEntranceExtInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tipsShowEntranceExtInfo", this.field_tipsShowEntranceExtInfo.toByteArray());
        if (this.kuk) {
          localContentValues.put("ctrType", Integer.valueOf(this.field_ctrType));
        }
        if (this.kul) {
          localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.kum) {
          localContentValues.put("aiScene", Long.valueOf(this.field_aiScene));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
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
  
  public StorageObserverOwner<? extends dc> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_tipsId;
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
 * Qualified Name:     com.tencent.mm.autogen.b.dc
 * JD-Core Version:    0.7.0.1
 */
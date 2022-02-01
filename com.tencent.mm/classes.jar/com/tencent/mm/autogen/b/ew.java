package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.bk;
import com.tencent.mm.protocal.protobuf.dgp;
import com.tencent.mm.protocal.protobuf.dyz;
import com.tencent.mm.protocal.protobuf.gki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ew
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LaunchWxaAppRespTable");
  private static final int jKX;
  public static final Column jKp;
  public static final Column kHA;
  public static final Column kHB;
  public static final Column kHC;
  public static final Column kHD;
  public static final Column kHE;
  private static final int kHN;
  private static final int kHO;
  private static final int kHP;
  private static final int kHQ;
  private static final int kHR;
  private static final int kHS;
  private static final int kHT;
  private static final int kHU;
  public static final Column kHx;
  public static final Column kHy;
  public static final Column kHz;
  private static final StorageObserverOwner<ew> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public bk field_actionsheetInfo;
  public String field_appId;
  public int field_appIdHash;
  public long field_expiredAtTimestampSeconds;
  public gki field_hostInfo;
  public aat field_jsapiInfo;
  public dgp field_launchAction;
  public String field_opConfig;
  public dyz field_operationInfo;
  private boolean jKG = true;
  private boolean kHF = true;
  private boolean kHG = true;
  private boolean kHH = true;
  private boolean kHI = true;
  private boolean kHJ = true;
  private boolean kHK = true;
  private boolean kHL = true;
  private boolean kHM = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kHx = new Column("appIdHash", "int", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kHy = new Column("launchAction", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.LaunchAction");
    kHz = new Column("jsapiInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.CheckJsApiInfo");
    kHA = new Column("hostInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.WxaAppHostInfo");
    kHB = new Column("actionsheetInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.ActionSheetInfo");
    kHC = new Column("operationInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.OperationInfo");
    kHD = new Column("opConfig", "string", TABLE.getName(), "");
    kHE = new Column("expiredAtTimestampSeconds", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kHN = "appIdHash".hashCode();
    jKX = "appId".hashCode();
    kHO = "launchAction".hashCode();
    kHP = "jsapiInfo".hashCode();
    kHQ = "hostInfo".hashCode();
    kHR = "actionsheetInfo".hashCode();
    kHS = "operationInfo".hashCode();
    kHT = "opConfig".hashCode();
    kHU = "expiredAtTimestampSeconds".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[9];
    localMAutoDBInfo.columns = new String[10];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appIdHash";
    localMAutoDBInfo.colsMap.put("appIdHash", "INTEGER PRIMARY KEY ");
    localStringBuilder.append(" appIdHash INTEGER PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "appIdHash";
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "launchAction";
    localMAutoDBInfo.colsMap.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "jsapiInfo";
    localMAutoDBInfo.colsMap.put("jsapiInfo", "BLOB");
    localStringBuilder.append(" jsapiInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "hostInfo";
    localMAutoDBInfo.colsMap.put("hostInfo", "BLOB");
    localStringBuilder.append(" hostInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "actionsheetInfo";
    localMAutoDBInfo.colsMap.put("actionsheetInfo", "BLOB");
    localStringBuilder.append(" actionsheetInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "operationInfo";
    localMAutoDBInfo.colsMap.put("operationInfo", "BLOB");
    localStringBuilder.append(" operationInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "opConfig";
    localMAutoDBInfo.colsMap.put("opConfig", "TEXT");
    localStringBuilder.append(" opConfig TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "expiredAtTimestampSeconds";
    localMAutoDBInfo.colsMap.put("expiredAtTimestampSeconds", "LONG");
    localStringBuilder.append(" expiredAtTimestampSeconds LONG");
    localMAutoDBInfo.columns[9] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("appIdHash"))
    {
      this.field_appIdHash = paramContentValues.getAsInteger("appIdHash").intValue();
      if (paramBoolean) {
        this.kHF = true;
      }
    }
    if (paramContentValues.containsKey("appId"))
    {
      this.field_appId = paramContentValues.getAsString("appId");
      if (paramBoolean) {
        this.jKG = true;
      }
    }
    if (paramContentValues.containsKey("launchAction")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("launchAction");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_launchAction = ((dgp)new dgp().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kHG = true;
        }
      }
    }
    catch (IOException localIOException1)
    {
      for (;;)
      {
        byte[] arrayOfByte;
        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("jsapiInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("jsapiInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_jsapiInfo = ((aat)new aat().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kHH = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("hostInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("hostInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_hostInfo = ((gki)new gki().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kHI = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
      }
    }
    if (paramContentValues.containsKey("actionsheetInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("actionsheetInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_actionsheetInfo = ((bk)new bk().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kHJ = true;
        }
      }
    }
    catch (IOException localIOException4)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
      }
    }
    if (paramContentValues.containsKey("operationInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("operationInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_operationInfo = ((dyz)new dyz().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kHK = true;
        }
      }
    }
    catch (IOException localIOException5)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
      }
    }
    if (paramContentValues.containsKey("opConfig"))
    {
      this.field_opConfig = paramContentValues.getAsString("opConfig");
      if (paramBoolean) {
        this.kHL = true;
      }
    }
    if (paramContentValues.containsKey("expiredAtTimestampSeconds"))
    {
      this.field_expiredAtTimestampSeconds = paramContentValues.getAsLong("expiredAtTimestampSeconds").longValue();
      if (paramBoolean) {
        this.kHM = true;
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
      if (kHN != k) {
        break label65;
      }
      this.field_appIdHash = paramCursor.getInt(i);
      this.kHF = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (kHO == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((dgp)new dgp().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
        }
      } else if (kHP == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsapiInfo = ((aat)new aat().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
        }
      } else if (kHQ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_hostInfo = ((gki)new gki().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
        }
      } else if (kHR == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_actionsheetInfo = ((bk)new bk().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
        }
      } else if (kHS == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_operationInfo = ((dyz)new dyz().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
        }
      } else if (kHT == k) {
        this.field_opConfig = paramCursor.getString(i);
      } else if (kHU == k) {
        this.field_expiredAtTimestampSeconds = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kHF) {
      localContentValues.put("appIdHash", Integer.valueOf(this.field_appIdHash));
    }
    if (this.jKG) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.kHG) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.kHH) || (this.field_jsapiInfo == null)) {}
    }
    catch (IOException localIOException4)
    {
      try
      {
        localContentValues.put("jsapiInfo", this.field_jsapiInfo.toByteArray());
        if ((!this.kHI) || (this.field_hostInfo == null)) {}
      }
      catch (IOException localIOException4)
      {
        try
        {
          localContentValues.put("hostInfo", this.field_hostInfo.toByteArray());
          if ((!this.kHJ) || (this.field_actionsheetInfo == null)) {}
        }
        catch (IOException localIOException4)
        {
          try
          {
            localContentValues.put("actionsheetInfo", this.field_actionsheetInfo.toByteArray());
            if ((!this.kHK) || (this.field_operationInfo == null)) {}
          }
          catch (IOException localIOException4)
          {
            try
            {
              for (;;)
              {
                localContentValues.put("operationInfo", this.field_operationInfo.toByteArray());
                if (this.kHL) {
                  localContentValues.put("opConfig", this.field_opConfig);
                }
                if (this.kHM) {
                  localContentValues.put("expiredAtTimestampSeconds", Long.valueOf(this.field_expiredAtTimestampSeconds));
                }
                if (this.systemRowid > 0L) {
                  localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                }
                return localContentValues;
                localIOException1 = localIOException1;
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException1.getMessage());
                continue;
                localIOException2 = localIOException2;
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException2.getMessage());
                continue;
                localIOException3 = localIOException3;
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException3.getMessage());
              }
              localIOException4 = localIOException4;
              Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException4.getMessage());
            }
            catch (IOException localIOException5)
            {
              for (;;)
              {
                Log.e("MicroMsg.SDK.BaseLaunchWxaAppRespTable", localIOException5.getMessage());
              }
            }
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
  
  public StorageObserverOwner<? extends ew> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Integer.valueOf(this.field_appIdHash);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ew
 * JD-Core Version:    0.7.0.1
 */
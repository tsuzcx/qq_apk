package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aat;
import com.tencent.mm.protocal.protobuf.giz;
import com.tencent.mm.protocal.protobuf.gjb;
import com.tencent.mm.protocal.protobuf.gnl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ex
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("LaunchWxaWidgetRespData");
  private static final int jKX;
  public static final Column jKp;
  private static final int kHN;
  private static final int kHO;
  public static final Column kHV;
  public static final Column kHW;
  public static final Column kHX;
  public static final Column kHY;
  public static final Column kHx;
  public static final Column kHy;
  public static final Column kHz;
  private static final int kIe;
  private static final int kIf;
  private static final int kIg;
  private static final int kIh;
  private static final int kIi;
  private static final StorageObserverOwner<ex> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public String field_appId;
  public int field_appIdHash;
  public aat field_jsApiInfo;
  public giz field_launchAction;
  public int field_pkgType;
  public gjb field_versionInfo;
  public gnl field_widgetSetting;
  public int field_widgetType;
  private boolean jKG = true;
  private boolean kHF = true;
  private boolean kHG = true;
  private boolean kHZ = true;
  private boolean kIa = true;
  private boolean kIb = true;
  private boolean kIc = true;
  private boolean kId = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kHx = new Column("appIdHash", "int", TABLE.getName(), "");
    jKp = new Column("appId", "string", TABLE.getName(), "");
    kHV = new Column("pkgType", "int", TABLE.getName(), "");
    kHW = new Column("widgetType", "int", TABLE.getName(), "");
    kHy = new Column("launchAction", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.WidgetLaunchAction");
    kHz = new Column("jsApiInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.CheckJsApiInfo");
    kHX = new Column("versionInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.WidgetVersionInfo");
    kHY = new Column("widgetSetting", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.WxaWidgetSetting");
    INDEX_CREATE = new String[0];
    kHN = "appIdHash".hashCode();
    jKX = "appId".hashCode();
    kIe = "pkgType".hashCode();
    kIf = "widgetType".hashCode();
    kHO = "launchAction".hashCode();
    kIg = "jsApiInfo".hashCode();
    kIh = "versionInfo".hashCode();
    kIi = "widgetSetting".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "appIdHash";
    localMAutoDBInfo.colsMap.put("appIdHash", "INTEGER");
    localStringBuilder.append(" appIdHash INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appId";
    localMAutoDBInfo.colsMap.put("appId", "TEXT");
    localStringBuilder.append(" appId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "pkgType";
    localMAutoDBInfo.colsMap.put("pkgType", "INTEGER");
    localStringBuilder.append(" pkgType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "widgetType";
    localMAutoDBInfo.colsMap.put("widgetType", "INTEGER");
    localStringBuilder.append(" widgetType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "launchAction";
    localMAutoDBInfo.colsMap.put("launchAction", "BLOB");
    localStringBuilder.append(" launchAction BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "jsApiInfo";
    localMAutoDBInfo.colsMap.put("jsApiInfo", "BLOB");
    localStringBuilder.append(" jsApiInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "versionInfo";
    localMAutoDBInfo.colsMap.put("versionInfo", "BLOB");
    localStringBuilder.append(" versionInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "widgetSetting";
    localMAutoDBInfo.colsMap.put("widgetSetting", "BLOB");
    localStringBuilder.append(" widgetSetting BLOB");
    localMAutoDBInfo.columns[8] = "rowid";
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
    if (paramContentValues.containsKey("pkgType"))
    {
      this.field_pkgType = paramContentValues.getAsInteger("pkgType").intValue();
      if (paramBoolean) {
        this.kHZ = true;
      }
    }
    if (paramContentValues.containsKey("widgetType"))
    {
      this.field_widgetType = paramContentValues.getAsInteger("widgetType").intValue();
      if (paramBoolean) {
        this.kIa = true;
      }
    }
    if (paramContentValues.containsKey("launchAction")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("launchAction");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_launchAction = ((giz)new giz().parseFrom(arrayOfByte));
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
        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
      }
    }
    if (paramContentValues.containsKey("jsApiInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("jsApiInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_jsApiInfo = ((aat)new aat().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kIb = true;
        }
      }
    }
    catch (IOException localIOException2)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
      }
    }
    if (paramContentValues.containsKey("versionInfo")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("versionInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_versionInfo = ((gjb)new gjb().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kIc = true;
        }
      }
    }
    catch (IOException localIOException3)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
      }
    }
    if (paramContentValues.containsKey("widgetSetting")) {}
    try
    {
      arrayOfByte = paramContentValues.getAsByteArray("widgetSetting");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_widgetSetting = ((gnl)new gnl().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kId = true;
        }
      }
    }
    catch (IOException localIOException4)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
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
        break label60;
      }
      this.field_appIdHash = paramCursor.getInt(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jKX == k) {
        this.field_appId = paramCursor.getString(i);
      } else if (kIe == k) {
        this.field_pkgType = paramCursor.getInt(i);
      } else if (kIf == k) {
        this.field_widgetType = paramCursor.getInt(i);
      } else if (kHO == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_launchAction = ((giz)new giz().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
        }
      } else if (kIg == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_jsApiInfo = ((aat)new aat().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
        }
      } else if (kIh == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_versionInfo = ((gjb)new gjb().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
        }
      } else if (kIi == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_widgetSetting = ((gnl)new gnl().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
        }
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
    if (this.kHZ) {
      localContentValues.put("pkgType", Integer.valueOf(this.field_pkgType));
    }
    if (this.kIa) {
      localContentValues.put("widgetType", Integer.valueOf(this.field_widgetType));
    }
    if ((this.kHG) && (this.field_launchAction != null)) {}
    try
    {
      localContentValues.put("launchAction", this.field_launchAction.toByteArray());
      if ((!this.kIb) || (this.field_jsApiInfo == null)) {}
    }
    catch (IOException localIOException3)
    {
      try
      {
        localContentValues.put("jsApiInfo", this.field_jsApiInfo.toByteArray());
        if ((!this.kIc) || (this.field_versionInfo == null)) {}
      }
      catch (IOException localIOException3)
      {
        try
        {
          localContentValues.put("versionInfo", this.field_versionInfo.toByteArray());
          if ((!this.kId) || (this.field_widgetSetting == null)) {}
        }
        catch (IOException localIOException3)
        {
          try
          {
            for (;;)
            {
              localContentValues.put("widgetSetting", this.field_widgetSetting.toByteArray());
              if (this.systemRowid > 0L) {
                localContentValues.put("rowid", Long.valueOf(this.systemRowid));
              }
              return localContentValues;
              localIOException1 = localIOException1;
              Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException1.getMessage());
              continue;
              localIOException2 = localIOException2;
              Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException2.getMessage());
            }
            localIOException3 = localIOException3;
            Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException3.getMessage());
          }
          catch (IOException localIOException4)
          {
            for (;;)
            {
              Log.e("MicroMsg.SDK.BaseLaunchWxaWidgetRespData", localIOException4.getMessage());
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
  
  public StorageObserverOwner<? extends ex> getObserverOwner()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.ex
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.atd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class hz
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("UniAction");
  private static final int jJD;
  public static final Column jJz;
  public static final Column kee;
  private static final int kfH;
  public static final Column kjY;
  private static final int kks;
  private static final int kmK;
  private static final int kmL;
  private static final int kmM;
  private static final int kmN;
  private static final int kmO;
  private static final int kmP;
  private static final int kmQ;
  private static final int kmR;
  private static final int kmS;
  private static final int kmT;
  public static final Column kmq;
  public static final Column kmr;
  public static final Column kms;
  public static final Column kmt;
  public static final Column kmu;
  public static final Column kmv;
  public static final Column kmw;
  public static final Column kmx;
  public static final Column kmy;
  public static final Column kmz;
  private static final StorageObserverOwner<hz> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  public atd field_actionInfo;
  public long field_actionTime;
  public int field_actionType;
  public int field_canRemove;
  public int field_failedFlag;
  public long field_feedId;
  public long field_lastTryTime;
  public long field_localCommentId;
  public String field_objectNonceId;
  public long field_postTime;
  public int field_scene;
  public int field_state;
  public long field_tryCount;
  private boolean jJB = true;
  private boolean keT = true;
  private boolean kki = true;
  private boolean kmA = true;
  private boolean kmB = true;
  private boolean kmC = true;
  private boolean kmD = true;
  private boolean kmE = true;
  private boolean kmF = true;
  private boolean kmG = true;
  private boolean kmH = true;
  private boolean kmI = true;
  private boolean kmJ = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kmq = new Column("localCommentId", "long", TABLE.getName(), "");
    kmr = new Column("feedId", "long", TABLE.getName(), "");
    kms = new Column("actionTime", "long", TABLE.getName(), "");
    kjY = new Column("actionType", "int", TABLE.getName(), "");
    kmt = new Column("objectNonceId", "string", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    kmu = new Column("actionInfo", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderActionPb");
    kmv = new Column("postTime", "long", TABLE.getName(), "");
    kmw = new Column("tryCount", "long", TABLE.getName(), "");
    kmx = new Column("canRemove", "int", TABLE.getName(), "");
    kmy = new Column("lastTryTime", "long", TABLE.getName(), "");
    kmz = new Column("failedFlag", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[] { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON UniAction(localCommentId)", "CREATE INDEX IF NOT EXISTS FinderAction_Feed_Id ON UniAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON UniAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON UniAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON UniAction(state)" };
    kmK = "localCommentId".hashCode();
    kmL = "feedId".hashCode();
    kmM = "actionTime".hashCode();
    kks = "actionType".hashCode();
    kmN = "objectNonceId".hashCode();
    jJD = "scene".hashCode();
    kfH = "state".hashCode();
    kmO = "actionInfo".hashCode();
    kmP = "postTime".hashCode();
    kmQ = "tryCount".hashCode();
    kmR = "canRemove".hashCode();
    kmS = "lastTryTime".hashCode();
    kmT = "failedFlag".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localCommentId";
    localMAutoDBInfo.colsMap.put("localCommentId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localCommentId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localCommentId";
    localMAutoDBInfo.columns[1] = "feedId";
    localMAutoDBInfo.colsMap.put("feedId", "LONG");
    localStringBuilder.append(" feedId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "actionTime";
    localMAutoDBInfo.colsMap.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "actionType";
    localMAutoDBInfo.colsMap.put("actionType", "INTEGER");
    localStringBuilder.append(" actionType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "objectNonceId";
    localMAutoDBInfo.colsMap.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "actionInfo";
    localMAutoDBInfo.colsMap.put("actionInfo", "BLOB");
    localStringBuilder.append(" actionInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "postTime";
    localMAutoDBInfo.colsMap.put("postTime", "LONG");
    localStringBuilder.append(" postTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "tryCount";
    localMAutoDBInfo.colsMap.put("tryCount", "LONG");
    localStringBuilder.append(" tryCount LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "canRemove";
    localMAutoDBInfo.colsMap.put("canRemove", "INTEGER");
    localStringBuilder.append(" canRemove INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lastTryTime";
    localMAutoDBInfo.colsMap.put("lastTryTime", "LONG");
    localStringBuilder.append(" lastTryTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "failedFlag";
    localMAutoDBInfo.colsMap.put("failedFlag", "INTEGER");
    localStringBuilder.append(" failedFlag INTEGER");
    localMAutoDBInfo.columns[13] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("localCommentId"))
    {
      this.field_localCommentId = paramContentValues.getAsLong("localCommentId").longValue();
      if (paramBoolean) {
        this.kmA = true;
      }
    }
    if (paramContentValues.containsKey("feedId"))
    {
      this.field_feedId = paramContentValues.getAsLong("feedId").longValue();
      if (paramBoolean) {
        this.kmB = true;
      }
    }
    if (paramContentValues.containsKey("actionTime"))
    {
      this.field_actionTime = paramContentValues.getAsLong("actionTime").longValue();
      if (paramBoolean) {
        this.kmC = true;
      }
    }
    if (paramContentValues.containsKey("actionType"))
    {
      this.field_actionType = paramContentValues.getAsInteger("actionType").intValue();
      if (paramBoolean) {
        this.kki = true;
      }
    }
    if (paramContentValues.containsKey("objectNonceId"))
    {
      this.field_objectNonceId = paramContentValues.getAsString("objectNonceId");
      if (paramBoolean) {
        this.kmD = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("actionInfo")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("actionInfo");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_actionInfo = ((atd)new atd().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kmE = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseUniAction", localIOException.getMessage());
      }
    }
    if (paramContentValues.containsKey("postTime"))
    {
      this.field_postTime = paramContentValues.getAsLong("postTime").longValue();
      if (paramBoolean) {
        this.kmF = true;
      }
    }
    if (paramContentValues.containsKey("tryCount"))
    {
      this.field_tryCount = paramContentValues.getAsLong("tryCount").longValue();
      if (paramBoolean) {
        this.kmG = true;
      }
    }
    if (paramContentValues.containsKey("canRemove"))
    {
      this.field_canRemove = paramContentValues.getAsInteger("canRemove").intValue();
      if (paramBoolean) {
        this.kmH = true;
      }
    }
    if (paramContentValues.containsKey("lastTryTime"))
    {
      this.field_lastTryTime = paramContentValues.getAsLong("lastTryTime").longValue();
      if (paramBoolean) {
        this.kmI = true;
      }
    }
    if (paramContentValues.containsKey("failedFlag"))
    {
      this.field_failedFlag = paramContentValues.getAsInteger("failedFlag").intValue();
      if (paramBoolean) {
        this.kmJ = true;
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
      if (kmK != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.kmA = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kmL == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (kmM == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (kks == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (kmN == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (jJD == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (kmO == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((atd)new atd().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseUniAction", localIOException.getMessage());
        }
      } else if (kmP == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (kmQ == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (kmR == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (kmS == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (kmT == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kmA) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.kmB) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.kmC) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.kki) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.kmD) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.keT) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.kmE) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.kmF) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.kmG) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.kmH) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.kmI) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.kmJ) {
        localContentValues.put("failedFlag", Integer.valueOf(this.field_failedFlag));
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
        Log.e("MicroMsg.SDK.BaseUniAction", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends hz> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_localCommentId);
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
 * Qualified Name:     com.tencent.mm.autogen.b.hz
 * JD-Core Version:    0.7.0.1
 */
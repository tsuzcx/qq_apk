package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fhc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ei
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("HardDeviceRankInfo");
  public static final Column USERNAME;
  public static final Column kDB;
  public static final Column kDC;
  public static final Column kDD;
  public static final Column kDE;
  private static final int kDK;
  private static final int kDL;
  private static final int kDM;
  private static final int kDN;
  public static final Column kDn;
  public static final Column kDo;
  private static final int kDt;
  private static final int kDu;
  public static final Column kDw;
  private static final int kDx;
  private static final StorageObserverOwner<ei> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public fhc field_sportRecord;
  public String field_username;
  private boolean kDF = true;
  private boolean kDG = true;
  private boolean kDH = true;
  private boolean kDI = true;
  private boolean kDJ = true;
  private boolean kDq = true;
  private boolean kDr = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kDn = new Column("rankID", "string", TABLE.getName(), "");
    kDo = new Column("appusername", "string", TABLE.getName(), "");
    USERNAME = new Column("username", "string", TABLE.getName(), "");
    kDB = new Column("ranknum", "int", TABLE.getName(), "");
    kDw = new Column("score", "int", TABLE.getName(), "");
    kDC = new Column("likecount", "int", TABLE.getName(), "");
    kDD = new Column("selfLikeState", "int", TABLE.getName(), "");
    kDE = new Column("sportRecord", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.SportRecord");
    INDEX_CREATE = new String[0];
    kDt = "rankID".hashCode();
    kDu = "appusername".hashCode();
    username_HASHCODE = "username".hashCode();
    kDK = "ranknum".hashCode();
    kDx = "score".hashCode();
    kDL = "likecount".hashCode();
    kDM = "selfLikeState".hashCode();
    kDN = "sportRecord".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[8];
    localMAutoDBInfo.columns = new String[9];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "rankID";
    localMAutoDBInfo.colsMap.put("rankID", "TEXT");
    localStringBuilder.append(" rankID TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "appusername";
    localMAutoDBInfo.colsMap.put("appusername", "TEXT");
    localStringBuilder.append(" appusername TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "username";
    localMAutoDBInfo.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "ranknum";
    localMAutoDBInfo.colsMap.put("ranknum", "INTEGER");
    localStringBuilder.append(" ranknum INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "score";
    localMAutoDBInfo.colsMap.put("score", "INTEGER");
    localStringBuilder.append(" score INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "likecount";
    localMAutoDBInfo.colsMap.put("likecount", "INTEGER default '0' ");
    localStringBuilder.append(" likecount INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "selfLikeState";
    localMAutoDBInfo.colsMap.put("selfLikeState", "INTEGER default '3' ");
    localStringBuilder.append(" selfLikeState INTEGER default '3' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "sportRecord";
    localMAutoDBInfo.colsMap.put("sportRecord", "BLOB");
    localStringBuilder.append(" sportRecord BLOB");
    localMAutoDBInfo.columns[8] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("rankID"))
    {
      this.field_rankID = paramContentValues.getAsString("rankID");
      if (paramBoolean) {
        this.kDq = true;
      }
    }
    if (paramContentValues.containsKey("appusername"))
    {
      this.field_appusername = paramContentValues.getAsString("appusername");
      if (paramBoolean) {
        this.kDr = true;
      }
    }
    if (paramContentValues.containsKey("username"))
    {
      this.field_username = paramContentValues.getAsString("username");
      if (paramBoolean) {
        this.__hadSetusername = true;
      }
    }
    if (paramContentValues.containsKey("ranknum"))
    {
      this.field_ranknum = paramContentValues.getAsInteger("ranknum").intValue();
      if (paramBoolean) {
        this.kDF = true;
      }
    }
    if (paramContentValues.containsKey("score"))
    {
      this.field_score = paramContentValues.getAsInteger("score").intValue();
      if (paramBoolean) {
        this.kDG = true;
      }
    }
    if (paramContentValues.containsKey("likecount"))
    {
      this.field_likecount = paramContentValues.getAsInteger("likecount").intValue();
      if (paramBoolean) {
        this.kDH = true;
      }
    }
    if (paramContentValues.containsKey("selfLikeState"))
    {
      this.field_selfLikeState = paramContentValues.getAsInteger("selfLikeState").intValue();
      if (paramBoolean) {
        this.kDI = true;
      }
    }
    if (paramContentValues.containsKey("sportRecord")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("sportRecord");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_sportRecord = ((fhc)new fhc().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kDJ = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", localIOException.getMessage());
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
      if (kDt != k) {
        break label60;
      }
      this.field_rankID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kDu == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (kDK == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (kDx == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (kDL == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (kDM == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (kDN == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_sportRecord = ((fhc)new fhc().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kDq) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.kDr) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.kDF) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.kDG) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.kDH) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.kDI) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if ((this.kDJ) && (this.field_sportRecord != null)) {}
    try
    {
      localContentValues.put("sportRecord", this.field_sportRecord.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends ei> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.ei
 * JD-Core Version:    0.7.0.1
 */
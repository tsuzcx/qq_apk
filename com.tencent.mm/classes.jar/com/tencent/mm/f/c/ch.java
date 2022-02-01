package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.awh;
import com.tencent.mm.protocal.protobuf.bdp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ch
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_LOCALFLAG;
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderDraftItem_local_index ON FinderDraftItem(localId)", "CREATE INDEX IF NOT EXISTS FinderDraftItem_create_time ON FinderDraftItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Local_Flag ON FinderDraftItem(localFlag)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Object_Type ON FinderDraftItem(objectType)" };
  public static final SingleTable TABLE = new SingleTable("FinderDraftItem");
  private static final int createTime_HASHCODE;
  public static final Column hRO;
  public static final Column hRP;
  public static final Column hRQ;
  public static final Column hRR;
  private static final int hRW = "finderItem".hashCode();
  private static final int hRX = "objectType".hashCode();
  private static final int hRY = "postIntent".hashCode();
  private static final int hRZ = "originMvInfo".hashCode();
  private static final int localFlag_HASHCODE;
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalId = true;
  public int field_createTime;
  public awh field_finderItem;
  public int field_localFlag;
  public long field_localId;
  public int field_objectType;
  public bdp field_originMvInfo;
  public String field_postIntent;
  private boolean hRS = true;
  private boolean hRT = true;
  private boolean hRU = true;
  private boolean hRV = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderDraftItem", "");
    C_LOCALID = new Column("localid", "long", "FinderDraftItem", "");
    C_CREATETIME = new Column("createtime", "int", "FinderDraftItem", "");
    C_LOCALFLAG = new Column("localflag", "int", "FinderDraftItem", "");
    hRO = new Column("finderitem", "proto", "FinderDraftItem", "com.tencent.mm.protocal.protobuf.FinderItemPb");
    hRP = new Column("objecttype", "int", "FinderDraftItem", "");
    hRQ = new Column("postintent", "string", "FinderDraftItem", "");
    hRR = new Column("originmvinfo", "proto", "FinderDraftItem", "com.tencent.mm.protocal.protobuf.FinderMVInfo");
    localId_HASHCODE = "localId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "INTEGER");
    localStringBuilder.append(" createTime INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "localFlag";
    localMAutoDBInfo.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "finderItem";
    localMAutoDBInfo.colsMap.put("finderItem", "BLOB");
    localStringBuilder.append(" finderItem BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "objectType";
    localMAutoDBInfo.colsMap.put("objectType", "INTEGER");
    localStringBuilder.append(" objectType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "postIntent";
    localMAutoDBInfo.colsMap.put("postIntent", "TEXT");
    localStringBuilder.append(" postIntent TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "originMvInfo";
    localMAutoDBInfo.colsMap.put("originMvInfo", "BLOB");
    localStringBuilder.append(" originMvInfo BLOB");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getInt(i);
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (hRW == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_finderItem = ((awh)new awh().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException1.getMessage());
        }
      } else if (hRX == k) {
        this.field_objectType = paramCursor.getInt(i);
      } else if (hRY == k) {
        this.field_postIntent = paramCursor.getString(i);
      } else if (hRZ == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_originMvInfo = ((bdp)new bdp().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException2.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Integer.valueOf(this.field_createTime));
    }
    if (this.__hadSetlocalFlag) {
      localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
    }
    if ((this.hRS) && (this.field_finderItem != null)) {}
    try
    {
      localContentValues.put("finderItem", this.field_finderItem.toByteArray());
      if (this.hRT) {
        localContentValues.put("objectType", Integer.valueOf(this.field_objectType));
      }
      if (this.hRU) {
        localContentValues.put("postIntent", this.field_postIntent);
      }
      if ((!this.hRV) || (this.field_originMvInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("originMvInfo", this.field_originMvInfo.toByteArray());
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException2.getMessage());
        }
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderDraftItem";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ch
 * JD-Core Version:    0.7.0.1
 */
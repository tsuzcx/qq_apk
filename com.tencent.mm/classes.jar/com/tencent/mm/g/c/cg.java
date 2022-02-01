package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aud;
import com.tencent.mm.protocal.protobuf.axw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cg
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderDraftItem_local_index ON FinderDraftItem(localId)", "CREATE INDEX IF NOT EXISTS FinderDraftItem_create_time ON FinderDraftItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Local_Flag ON FinderDraftItem(localFlag)", "CREATE INDEX IF NOT EXISTS FinderDraftItem__Object_Type ON FinderDraftItem(objectType)" };
  private static final int createTime_HASHCODE;
  private static final int fEd = "finderItem".hashCode();
  private static final int fEe = "objectType".hashCode();
  private static final int fEf = "postIntent".hashCode();
  private static final int fEg = "originMvInfo".hashCode();
  private static final int localFlag_HASHCODE;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalId = true;
  private boolean fDZ = true;
  private boolean fEa = true;
  private boolean fEb = true;
  private boolean fEc = true;
  public int field_createTime;
  public aud field_finderItem;
  public int field_localFlag;
  public long field_localId;
  public int field_objectType;
  public axw field_originMvInfo;
  public String field_postIntent;
  
  static
  {
    createTime_HASHCODE = "createTime".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      } else if (fEd == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_finderItem = ((aud)new aud().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderDraftItem", localIOException1.getMessage());
        }
      } else if (fEe == k) {
        this.field_objectType = paramCursor.getInt(i);
      } else if (fEf == k) {
        this.field_postIntent = paramCursor.getString(i);
      } else if (fEg == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_originMvInfo = ((axw)new axw().parseFrom(arrayOfByte2));
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
    if ((this.fDZ) && (this.field_finderItem != null)) {}
    try
    {
      localContentValues.put("finderItem", this.field_finderItem.toByteArray());
      if (this.fEa) {
        localContentValues.put("objectType", Integer.valueOf(this.field_objectType));
      }
      if (this.fEb) {
        localContentValues.put("postIntent", this.field_postIntent);
      }
      if ((!this.fEc) || (this.field_originMvInfo == null)) {}
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cg
 * JD-Core Version:    0.7.0.1
 */
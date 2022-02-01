package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cm
  extends IAutoDBItem
{
  public static final Column C_ROWID = new Column("rowid", "long", "FinderLiveLastRewardInfo", "");
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderLiveLastRewardInfo_liveId_index ON FinderLiveLastRewardInfo(liveId)" };
  public static final SingleTable TABLE = new SingleTable("FinderLiveLastRewardInfo");
  public static final Column hSK = new Column("liveid", "string", "FinderLiveLastRewardInfo", "");
  public static final Column hSL = new Column("lastrewardinfo", "byte[]", "FinderLiveLastRewardInfo", "");
  private static final int hSO = "liveId".hashCode();
  private static final int hSP = "lastRewardInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public byte[] field_lastRewardInfo;
  public String field_liveId;
  private boolean hSM = true;
  private boolean hSN = true;
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[2];
    localMAutoDBInfo.columns = new String[3];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "liveId";
    localMAutoDBInfo.colsMap.put("liveId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" liveId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "liveId";
    localMAutoDBInfo.columns[1] = "lastRewardInfo";
    localMAutoDBInfo.colsMap.put("lastRewardInfo", "BLOB");
    localStringBuilder.append(" lastRewardInfo BLOB");
    localMAutoDBInfo.columns[2] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (hSO != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getString(i);
      this.hSM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hSP == k) {
        this.field_lastRewardInfo = paramCursor.getBlob(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hSM) {
      localContentValues.put("liveId", this.field_liveId);
    }
    if (this.hSN) {
      localContentValues.put("lastRewardInfo", this.field_lastRewardInfo);
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderLiveLastRewardInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.cm
 * JD-Core Version:    0.7.0.1
 */
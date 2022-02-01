package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cn
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("FinderLiveLuckyMoneyInfo");
  public static final Column hSK;
  private static final int hSO = "liveId".hashCode();
  public static final Column hSQ;
  private static final int hSS = "luckyMoneyData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_liveId;
  public byte[] field_luckyMoneyData;
  private boolean hSM = true;
  private boolean hSR = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderLiveLuckyMoneyInfo", "");
    hSK = new Column("liveid", "string", "FinderLiveLuckyMoneyInfo", "");
    hSQ = new Column("luckymoneydata", "byte[]", "FinderLiveLuckyMoneyInfo", "");
  }
  
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
    localMAutoDBInfo.columns[1] = "luckyMoneyData";
    localMAutoDBInfo.colsMap.put("luckyMoneyData", "BLOB");
    localStringBuilder.append(" luckyMoneyData BLOB");
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
      if (hSS == k) {
        this.field_luckyMoneyData = paramCursor.getBlob(i);
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
    if (this.hSR) {
      localContentValues.put("luckyMoneyData", this.field_luckyMoneyData);
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
    return "FinderLiveLuckyMoneyInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.cn
 * JD-Core Version:    0.7.0.1
 */